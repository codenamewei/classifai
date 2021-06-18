/*
 * Copyright (c) 2020-2021 CertifAI Sdn. Bhd.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Apache License, Version 2.0 which is available at
 * https://www.apache.org/licenses/LICENSE-2.0.
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations
 * under the License.
 *
 * SPDX-License-Identifier: Apache-2.0
 */
package ai.classifai.database.migration;

import ai.classifai.database.DbConfig;
import ai.classifai.util.data.FileHandler;
import ai.classifai.util.exception.DatabaseMigrationException;
import ai.classifai.util.type.database.RelationalDb;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.tuple.Pair;
import org.json.JSONArray;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static javax.swing.JOptionPane.showMessageDialog;

/***
 * Implementation of functionalities of Database Migration
 *
 * @author YCCertifai
 */
@Slf4j
public abstract class DbMigration implements DbMigrationServiceable
{
    private Map<String, Connection> fromConnDict;
    private Map<String, Connection> toConnDict;

    private Map<String, String> createTableQueryDict;

    private RelationalDb fromDb;
    private RelationalDb toDb;

    //key list of databases those are required to be migrated
    private List<String> tableKeyList;

    private boolean migrationOption;

    /**
     * Constructor
     *
     * @param fromDb database to be migrated
     * @param toDb new database
     * @param tableKeyList list of keys representing databases to be migrated
     */
    public DbMigration(RelationalDb fromDb, RelationalDb toDb, List<String> tableKeyList)
    {
        this.tableKeyList = tableKeyList;

        this.fromDb = fromDb;
        this.toDb = toDb;

        this.createTableQueryDict = buildCreateTableQueryDict(tableKeyList);

        migrationOption = true;
    }

    /**
     * Build dictionary for query to create tables for each database
     * key: database key
     * value: create table query
     *
     * @param tableKeyList list of keys representing databases to be migrated
     * @return the dictionary
     */
    protected abstract Map<String, String> buildCreateTableQueryDict(List<String> tableKeyList);

    /**
     * Perform checking if the database to be migrated is locked
     *
     * @param fromDb database to be migrated
     * @return true if locked, else false
     */
    protected abstract boolean isFromDbLocked(RelationalDb fromDb);

    /**
     * read all the data from the database to be migrated into a jsonArray
     *
     * @param key key representing specific database
     * @param con JDBC connection to the respective database
     * @return jsonArray loaded with data
     */
    protected abstract JSONArray readFromDb2Json(String key, Connection con);

    /**
     * perform filtering to the data that are unable to be migrated
     *
     * @param inputJsonDict map with all jsonArray loaded with data to be migrated
     *                      key: database key
     *                      value: jsonArray of respective database
     * @return pair of dictionary and JsonArray
     * left: migratable databases; key: database key, value: database rows
     * right: nonmigratable databases; key: database key, value: database rows
     */
    protected abstract Pair<Map<String, JSONArray>, Map<String, JSONArray>> filterProjects(Map<String, JSONArray> inputJsonDict);
    
    /**
     * perform transformation of data to fit new database structure
     *
     * @param filteredJsonDict map with all jsonArray loaded with data able to be migrated
     *                         key: database key
     *                         value: filtered jsonArray of respective database
     * @return dictionary with all transformed jsonArray
     */
    protected abstract Map<String, JSONArray> transformData(Map<String, JSONArray> filteredJsonDict);

    /**
     * write transformed jsonArray into new database
     *
     * @param key key representing specific database
     * @param con JDBC connection to the respective database
     * @param arr jsonArray to be written into new database
     * @return dictionary with all transformed jsonArray
     */
    protected abstract boolean writeJson2ToDb(String key, Connection con, JSONArray arr);

    /**
     * convert the disallowed projects to migratable form with user permission
     * 
     * @param filteredJsonDict the allowed project json dict
     * @param disallowedJsonDict the disallowed project json dict
     * @return dictionary with all allowed and converted disallowed projects, the                           
     */
    protected abstract Map<String, JSONArray> convertDisallowedJsonDict(Map<String, JSONArray> filteredJsonDict, Map<String, JSONArray> disallowedJsonDict) throws DatabaseMigrationException;

    /**
     * main function of database migration
     *
     * @return true means migrate; false means not migrating => abort classifai as well
     */
    @Override
    public boolean migrate(){
        try
        {
            //move all old files to archive
            copyToArchive();

            //check if from database lock. If locked and unable to unlock, stop migration.
            if (isFromDbLocked(fromDb))
            {
                throw new DatabaseMigrationException("Remove lock file from origin database failed. Migration aborted.");
            }

            //create jdbc connection to from and to database
            createConnectionToDatabases();

            //read data from old database
            Map<String, JSONArray> inputJsonDict = readInDb();

            //split projects into migratable and nonmigratable
            //left: dict for migratable projects databases
            //right: dict for nonmigratable projects databases
            Pair<Map<String, JSONArray>, Map<String, JSONArray>> filteredPair = filterProjects(inputJsonDict);
            
            Map<String, JSONArray> filteredJsonDict = filteredPair.getLeft();
            
            Map<String, JSONArray> disallowedJsonDict = filteredPair.getRight();

            //perform convertion to disallowedJsonDict to make it migratable **with user permission**
            Map<String, JSONArray> finalMigratingDict = convertDisallowedJsonDict(filteredJsonDict, disallowedJsonDict);

            //transform migratable data into correct format
            Map<String, JSONArray> outputJsonDict = transformData(finalMigratingDict);

            //create table to new database
            createToDbTables();

            //write data to new database
            if (!writeOutDb(outputJsonDict)) {
                log.debug("failure in writing to output database. Migration aborted.");
                throw new DatabaseMigrationException("Failed to write to output database. Migration aborted.");
            }
        }
        catch (Exception e)
        {
            String message = "Database migration aborted!\n\nContact hello@classifai.ai if extra help is required.";
            log.info(e.getMessage());
            showMessageDialog(new JFrame("Message"), message);
            migrationOption = false;
        }

        //close all jdbc connections
        closeConnectionToDatases();

        deleteDatabaseFiles(migrationOption);

        //delete old database files
        return migrationOption;
    }
    
    private void deleteDatabaseFiles(boolean skipOrDelete)
    {
        for (String key : tableKeyList)
        {
            String tableFolderPath = DbConfig.getTableFolderPathDict().get(key);
            File tableFilePath = toDb.getTableAbsPathDict().get(key);

            selectiveDelete(tableFolderPath, tableFilePath.getAbsolutePath(), skipOrDelete);
        }
    }

    private void closeConnectionToDatases()
    {
        closeConnection(new ArrayList<>(toConnDict.values()));
        closeConnection(new ArrayList<>(fromConnDict.values()));
    }

    private void createConnectionToDatabases() throws SQLException, ClassNotFoundException
    {
        this.fromConnDict = createConnection(fromDb);
        this.toConnDict = createConnection(toDb);
    }

    private Map<String, Connection> createConnection(RelationalDb db) throws SQLException, ClassNotFoundException
    {
        Map<String, Connection> connDict = new HashMap<>();

        for (String key : tableKeyList)
        {
                Connection con = connectDb(DbConfig.getTableAbsPathDict().get(key), db);

                connDict.put(key, con);
        }

        return connDict;
    }

    private Connection connectDb(String tableAbsPath, RelationalDb db) throws SQLException, ClassNotFoundException {
        Class.forName(db.getDriver());

        return DriverManager.getConnection(db.getUrlHeader() + tableAbsPath, db.getUser(), db.getPassword());
    }

    private void copyToArchive() throws IOException {
        for (String key : tableKeyList)
        {
            String path = DbConfig.getTableFolderPathDict().get(key);

            ArchiveHandler.copyToArchive(path);
        }
    }

    private void createDbTable(Connection con, String query)
    {
        try (Statement st = con.createStatement())
        {
            st.executeUpdate(query);
        }
        catch (Exception e)
        {
            log.debug("Unable to create table. Please check on query: " + query);
        }
    }

    private void createToDbTables()
    {
        for (String key : tableKeyList)
        {
            createDbTable(toConnDict.get(key), createTableQueryDict.get(key));
        }
    }

    private Map<String, JSONArray> readInDb()
    {
        Map<String, JSONArray> tempJsonDict = new HashMap<>();

        for (String key : tableKeyList)
        {
            tempJsonDict.put(key, readFromDb2Json(key, fromConnDict.get(key)));
        }

        return tempJsonDict;
    }

    private boolean writeOutDb(Map<String, JSONArray> transformedJsonDict)
    {
        for (String key : tableKeyList)
        {
            if(! writeJson2ToDb(key, toConnDict.get(key), transformedJsonDict.get(key))) return false;
        }

        return true;
    }

    private void selectiveDelete(String folderName, String path, boolean skipOrDelete)
    {
        File folder = new File(folderName);

        if (folder.isDirectory())
        {
            for (File file: folder.listFiles())
            {
                if (file.getAbsolutePath().equals(path) ^ skipOrDelete)
                {
                    FileHandler.deleteFile(file);
                }
            }
        }
        else
        {
            log.debug(folderName + " is not a directory");
        }
    }

    private void closeConnection(List<Connection> connection)
    {
        for(Connection conn : connection)
        {
            try {
                conn.close();
            }
            catch(Exception e)
            {
                log.debug("Close connection failed with: " + e);
            }
        }
    }
}
