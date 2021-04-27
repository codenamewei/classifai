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
package ai.classifai.database;

import ai.classifai.database.migration.DbMigration;
import ai.classifai.database.migration.HsqlToH2DbMigration;
import ai.classifai.ui.SelectionWindow;
import ai.classifai.util.data.FileHandler;
import lombok.extern.slf4j.Slf4j;

import javax.swing.*;
import java.io.File;
import java.util.ArrayList;
import java.util.List;


/**
 * Db Operations for files and paths of database
 *
 * @author codenamewei
 */
@Slf4j
public class DbOps {
    private DbOps() {
        throw new IllegalStateException("DbOps class");
    }

    // perform migration (if required) and database setup
    // return false only when migration aborted
    public static boolean configureDatabase() {
        if (migrateDbIfExist())
        {
            setupDb();
            return true;
        }
        return false;
    }

    // database migration
    // return false only when migration aborted
    private static boolean migrateDbIfExist()
    {
        if (DbConfig.getHsql().isDbExist() && !DbConfig.getH2().isDbExist()) {
            log.info("Database migration required. Executing database migration.");
            return new HsqlToH2DbMigration().migrate();
        } else {
            log.debug("Database migration did not initiated");
        }
        return true;
    }

    private static void setupDb()
    {
        String dataRootPath = DbConfig.getDbRootPath();

        if (isDbExist())
        {
            log.info("Existing database of classifai on " + dataRootPath);

            if(DbConfig.getH2().isDbLocked())
            {
                String popupTitle = "Database Setup Error";
                String message = "H2 Database is locked. Likely another classifai application is running. Close it and try again.";
                SelectionWindow.showPopupAndLog(popupTitle, message, JOptionPane.ERROR_MESSAGE);

                System.exit(0);
            }
        }
        else
        {
            boolean databaseIsBuild = mkdirDatabase();

            if (databaseIsBuild)
            {
                log.info("Database of classifai created on " + dataRootPath);
            }
            else
            {
                log.debug("Base database could not created: ", dataRootPath);
            }
        }
    }

    private static boolean isDbExist()
    {
        if(!new File(DbConfig.getDbRootPath()).exists()) return false;

        List<String> dbFolderList = new ArrayList<>(DbConfig.getTableFolderPathDict().values());

        for(String path : dbFolderList)
        {
            if(!new File(path).exists()) return false;
        }

        return true;
    }

    private static boolean mkdirDatabase()
    {
        File dataRootPath = new File(DbConfig.getDbRootPath());

        if(!FileHandler.createFolderIfNotExist(dataRootPath))
        {
            return false;
        }

        List<String> dbFolderList = new ArrayList<>(DbConfig.getTableFolderPathDict().values());

        for(String path : dbFolderList)
        {
            File folderPath = new File(path);

            if(!FileHandler.createFolderIfNotExist(folderPath))
            {
                return false;
            }
        }

        return true;
    }
}