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
import ai.classifai.database.annotation.AnnotationQuery;
import ai.classifai.database.portfolio.PortfolioDbQuery;
import ai.classifai.database.versioning.ProjectVersion;
import ai.classifai.ui.component.DbMigrationUi;
import ai.classifai.util.ParamConfig;
import ai.classifai.util.collection.ConversionHandler;
import ai.classifai.util.collection.UuidGenerator;
import ai.classifai.util.exception.DatabaseMigrationException;
import ai.classifai.util.project.ProjectInfra;
import ai.classifai.util.type.database.Hsql;
import ai.classifai.util.type.database.RelationalDb;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;
import org.json.JSONArray;
import org.json.JSONObject;

import javax.swing.*;
import java.io.File;
import java.sql.*;
import java.util.*;

/***
 * Program for database migration from v1 -> v2 // hsql -> h2
 *
 *
 * @author YCCertifai
 */
@Slf4j
public class HsqlToH2DbMigration extends DbMigration
{
    //Migration from v1 -> v2

    // replacing project id  & uuid from int -> string(uuidv4)
    //Key: v1 project id
    //Value: v2 project id
    private Map<Integer, String> projectIdDict;

    //Key: v1 project id
    //Value: Map<Integer v1 uuid, String v2 uuid>
    private Map<Integer, Map<Integer, String>> projectUuidDict;

    //Root path dictionary
    //will be built upon checking. If images from same folder will be stored; if images imported from more than 1 folder will be discarded.

    //Key: v1 project id
    //Value: project root path
    private Map<Integer, String> projectPathDict;

    //Project version is introduced in v2, transform v1 data into v2 format

    //Key: v1 project id
    //Value: ProjectVersion
    private Map<Integer, ProjectVersion> projectVersionDict;

    //keywords used during database migration
    private static final String lineWidthParam = "lineWidth";
    private static final String colorParam = "color";

    public HsqlToH2DbMigration()
    {
        super(DbConfig.getHsql(), DbConfig.getH2(), Arrays.asList(DbConfig.getPortfolioKey(), DbConfig.getBndBoxKey(), DbConfig.getSegKey()));
    }

    @Override
    protected Map<String, String> buildCreateTableQueryDict(List<String> tableKeyList)
    {
        HashMap<String, String> createTableQueryDict = new HashMap<>();

        for (String key : tableKeyList)
        {
            String query = key.equals(DbConfig.getPortfolioKey()) ? PortfolioDbQuery.getCreatePortfolioTable() : AnnotationQuery.getCreateProject();
            createTableQueryDict.put(key, query);
        }

        return createTableQueryDict;
    }

    @Override
    protected boolean isFromDbLocked(RelationalDb fromDb) {
        return !((Hsql) fromDb).removeLckIfExist();
    }

    @Override
    protected JSONArray readFromDb2Json(String key, Connection con)
    {
        JSONArray arr = new JSONArray();

        String query = key.equals(DbConfig.getPortfolioKey()) ? PortfolioDbQuery.getRetrieveAllProjects() : AnnotationQuery.getRetrieveAllProjects();

        try (Statement st = con.createStatement())
        {
            ResultSet rs = st.executeQuery(query);

            if (key.equals(DbConfig.getPortfolioKey()))
            {
                while (rs.next())
                {
                    arr.put(new JSONObject()
                            .put(ParamConfig.getProjectIdParam(), rs.getInt(1))
                            .put(ParamConfig.getProjectNameParam(), rs.getString(2))
                            .put(ParamConfig.getAnnotationTypeParam(), rs.getInt(3))
                            .put(ParamConfig.getLabelListParam(), rs.getString(4))
                            .put(ParamConfig.getUuidListParam(), rs.getString(6)));

                }
            } else
            {
                while (rs.next())
                {

                    arr.put(new JSONObject()
                            .put(ParamConfig.getUuidParam(), rs.getInt(1))
                            .put(ParamConfig.getProjectIdParam(), rs.getInt(2))
                            .put(ParamConfig.getImgPathParam(), rs.getString(3))
                            .put(ParamConfig.getAnnotationParam(), rs.getString(4))
                            .put(ParamConfig.getImgDepth(), rs.getInt(5))
                            .put(ParamConfig.getImgXParam(), rs.getInt(6))
                            .put(ParamConfig.getImgYParam(), rs.getInt(7))
                            .put(ParamConfig.getImgWParam(), rs.getInt(8))
                            .put(ParamConfig.getImgHParam(), rs.getInt(9))
                            .put(ParamConfig.getFileSizeParam(), rs.getInt(10))
                            .put(ParamConfig.getImgOriWParam(), rs.getInt(11))
                            .put(ParamConfig.getImgOriHParam(), rs.getInt(12)));

                }
            }
        } catch (Exception e) {
            log.debug("Fail to write to JSON: " + e);
        }

        return arr;
    }

    @Override
    public Pair<Map<String, JSONArray>, Map<String, JSONArray>> filterProjects(Map<String, JSONArray> jsonDict)
    {
        buildMigratableProjDict(jsonDict);

        return filterMigratableProjects(jsonDict, projectPathDict);
    }

    @Override
    public Map<String, JSONArray> transformData(Map<String, JSONArray> jsonDict)
    {
        buildTransformationDicts(jsonDict);

        return transformData(jsonDict, projectIdDict, projectUuidDict, projectPathDict, projectVersionDict);
    }

    @Override
    protected boolean writeJson2ToDb(String key, Connection con, JSONArray arr)
    {
        String query = key.equals(DbConfig.getPortfolioKey()) ? PortfolioDbQuery.getCreateNewProject() : AnnotationQuery.getCreateData();

        try (PreparedStatement st = con.prepareStatement(query))
        {
            if(key.equals(DbConfig.getPortfolioKey()))
            {
                for(int i = 0; i < arr.length(); ++i)
                {
                    JSONObject obj = arr.getJSONObject(i);

                    st.setString(1, obj.getString(ParamConfig.getProjectIdParam()));                    //project_id
                    st.setString(2, obj.getString(ParamConfig.getProjectNameParam()));                  //project_name
                    st.setInt(3, obj.getInt(ParamConfig.getAnnotationTypeParam()));                     //annotation
                    st.setString( 4, obj.getString(ParamConfig.getProjectPathParam()));                 //root_path
                    st.setBoolean(5, obj.getBoolean(ParamConfig.getIsNewParam()));                      //is_new
                    st.setBoolean(6, obj.getBoolean(ParamConfig.getIsStarredParam()));                  //is_starred
                    st.setString( 7, obj.getString(ParamConfig.getProjectInfraParam()));                //project_infra
                    st.setString(8, obj.getString(ParamConfig.getCurrentVersionParam()));               //current_version
                    st.setString(9, obj.getString(ParamConfig.getProjectVersionParam()));               //project_version
                    st.setString(10, obj.getString(ParamConfig.getUuidVersionListParam()));             //uuid_project_version
                    st.setString(11, obj.getString(ParamConfig.getLabelVersionListParam()));            //lable_version

                    st.executeUpdate();
                    st.clearParameters();
                }
            }
            else
            {
                for(int i = 0; i < arr.length(); ++i)
                {
                    JSONObject obj = arr.getJSONObject(i);

                    st.setString(1, obj.getString(ParamConfig.getUuidParam()));                         //uuid
                    st.setString(2, obj.getString(ParamConfig.getProjectIdParam()));                    //project_id
                    st.setString(3, obj.getString(ParamConfig.getImgPathParam()));                      //relative_path
                    st.setString(4, JSONObject.valueToString(obj.getJSONArray(ParamConfig.getVersionListParam())));                  //version_list
                    st.setInt(5, obj.getInt(ParamConfig.getImgDepth()));                                //img_depth
                    st.setInt(6, obj.getInt(ParamConfig.getImgOriWParam()));                            //ori W
                    st.setInt(7, obj.getInt(ParamConfig.getImgOriHParam()));                            //ori H
                    st.setInt(8, obj.getInt(ParamConfig.getFileSizeParam()));                           //file_size

                    st.executeUpdate();
                    st.clearParameters();
                }
            }
        }
        catch (SQLException e)
        {
            log.debug("Fail to write to H2: " + e);
            return false;
        }

        return true;
    }

    @Override
    protected Map<String, JSONArray> convertDisallowedJsonDict(Map<String, JSONArray> filteredJsonDict, Map<String, JSONArray> disallowedJsonDict) throws DatabaseMigrationException
    {
        if (!disallowedJsonDict.get(DbConfig.getPortfolioKey()).isEmpty())
        {

            JSONArray disallowedPortfolioJsonArray = disallowedJsonDict.get(DbConfig.getPortfolioKey());

            // change project path and child path
            Map<String, String> newProjectPathDict = getNewPathFromUser(disallowedPortfolioJsonArray);

            convertPortfolioAndCreateFolder(disallowedPortfolioJsonArray, newProjectPathDict, filteredJsonDict);

            convertProjectAndCopyValidImages(disallowedJsonDict, filteredJsonDict, DbConfig.getBndBoxKey());

            convertProjectAndCopyValidImages(disallowedJsonDict, filteredJsonDict, DbConfig.getSegKey());
        }

        return filteredJsonDict;
    }

    private void convertProjectAndCopyValidImages(Map<String, JSONArray> disallowedJsonDict, Map<String, JSONArray> filteredJsonDict, String key)
    {
        JSONArray disallowedProjectJsonArray = disallowedJsonDict.get(key);

        Set<Integer> projectIdSet = projectPathDict.keySet();

        for (Object obj : disallowedProjectJsonArray)
        {
            JSONObject jsonObj = (JSONObject) obj;

            Integer projectId = jsonObj.getInt(ParamConfig.getProjectIdParam());

            String imagePath = jsonObj.getString(ParamConfig.getImgPathParam());

            if (projectIdSet.contains(projectId))
            {
                String targetPath = projectPathDict.get(projectId);
                try
                {
                    //get current path
                    File file = new File(imagePath);
                    File target = getNewFileName(targetPath, file.getName());

                    // copy
                    FileUtils.copyFile(file, target);

                    jsonObj.put(ParamConfig.getImgPathParam(), target.getAbsolutePath());

                    filteredJsonDict.get(key).put(jsonObj);
                }
                catch (Exception exception)
                {
                    log.debug(String.format("Unable to copy image %s.", imagePath));
                }
            }
        }
    }

    private File getNewFileName(String targetPath, String name)
    {
        File target = new File(targetPath, name);

        int num = 0;

        int idxOfDot = name.lastIndexOf('.');
        String filename = name.substring(0, idxOfDot);
        String ext = name.substring(idxOfDot);

        while (target.exists())
        {
            String newName = String.format("%s_%d%s", filename, num, ext);
            target = new File(targetPath, newName);
        }

        return target;
    }

    private Map<String, String> getNewPathFromUser(JSONArray disallowedProjectNameList) throws DatabaseMigrationException
    {
        // show user which project is not migratable
        DbMigrationUi dbMigrationUi = new DbMigrationUi(disallowedProjectNameList);

        int result = JOptionPane.showConfirmDialog(null, dbMigrationUi.getMainPanel(), "Project Path Reconfiguring", JOptionPane.OK_CANCEL_OPTION);

        if (result == JOptionPane.OK_OPTION)
        {
            return dbMigrationUi.getSavePath();
        }
        else
        {
            throw new DatabaseMigrationException("User stopped migration process");
        }
    }

    private void convertPortfolioAndCreateFolder(JSONArray disallowedPortfolioJsonArray, Map<String, String> newProjectPathDict, Map<String, JSONArray> filteredJsonDict)
    {
        Set<String> convertedProject = newProjectPathDict.keySet();

        for (Object obj : disallowedPortfolioJsonArray)
        {
            JSONObject jsonObj = (JSONObject) obj;

            String projectName = jsonObj.getString(ParamConfig.getProjectNameParam());

            Integer projectId = jsonObj.getInt(ParamConfig.getProjectIdParam());

            if (convertedProject.contains(projectName))
            {
                projectPathDict.put(projectId, newProjectPathDict.get(projectName));

                filteredJsonDict.get(DbConfig.getPortfolioKey()).put(jsonObj);
            }
        }
    }

    private Pair<Map<String, JSONArray>, Map<String, JSONArray>> filterMigratableProjects(Map<String, JSONArray> jsonDict, Map<Integer, String> projectPathDict)
    {
        Map<String, JSONArray> filteredDict = new HashMap<>();
        Map<String, JSONArray> disallowedDict = new HashMap<>();

        Set<Integer> allowedProject = projectPathDict.keySet();
        for (String key : jsonDict.keySet())
        {
            JSONArray data = jsonDict.get(key);
            JSONArray filteredData = new JSONArray();
            JSONArray disallowedData = new JSONArray();

            for (int i = data.length() - 1; i >= 0; i--)
            {
                JSONObject row = data.getJSONObject(i);

                Integer projectId = row.getInt(ParamConfig.getProjectIdParam());

                if (!allowedProject.contains(projectId))
                {
                    disallowedData.put(row);
                }
                else
                {
                    filteredData.put(row);
                }
            }
            disallowedDict.put(key, disallowedData);
            filteredDict.put(key, filteredData);
        }
        return new ImmutablePair<>(filteredDict, disallowedDict);
    }

    private void buildTransformationDicts(Map<String, JSONArray> jsonDict)
    {
        projectIdDict = new HashMap<>();
        projectUuidDict = new HashMap<>();
        projectVersionDict = new HashMap<>();

        JSONArray portfolioData = jsonDict.get(DbConfig.getPortfolioKey());

        for (Object obj : portfolioData)
        {
            JSONObject row = (JSONObject) obj;

            Map<Integer, String> uuidMap = new HashMap<>();

            //get data required for transformation
            Integer projectIdInt = row.getInt(ParamConfig.getProjectIdParam());
            List<String> labelList = ConversionHandler.string2StringList(row.getString(ParamConfig.getLabelListParam()));
            List<String> processedLabelList = removeColorCodeInLabel(labelList);
            List<Integer> uuidIntList = ConversionHandler.string2IntegerList(row.getString(ParamConfig.getUuidListParam()));

            //transform projectid
            String projectId = UuidGenerator.generateUuid();
            projectIdDict.put(projectIdInt, projectId);

            //transform uuid
            List<String> uuidList = new ArrayList<>();

            for (Integer uuidInt: uuidIntList)
            {
                String uuid = UuidGenerator.generateUuid();
                uuidMap.put(uuidInt, uuid);
                uuidList.add(uuid);
            }

            projectUuidDict.put(projectIdInt, uuidMap);

            //add in project version
            ProjectVersion projectVersion = new ProjectVersion();

            projectVersion.setCurrentVersionUuidList(uuidList);
            projectVersion.setCurrentVersionLabelList(processedLabelList);

            projectVersionDict.put(projectIdInt, projectVersion);
        }
    }

    private List<String> removeColorCodeInLabel(List<String> labelList)
    {
        List<String> processedList = new ArrayList<>();

        for (String label : labelList)
        {
            processedList.add(label.substring(0, label.length() - 8));
        }

        return processedList;
    }

    private Map<String, JSONArray> transformData(Map<String, JSONArray> jsonDict, Map<Integer, String> projectIdDict, Map<Integer, Map<Integer, String>> projectUuidDict, Map<Integer, String> projectPathDict, Map<Integer, ProjectVersion> projectVersionDict)
    {
        Map<String, JSONArray> transformedDict = new HashMap<>();

        for (String key : jsonDict.keySet())
        {
            JSONArray transformedData = new JSONArray();

            for (Object obj : jsonDict.get(key))
            {
                JSONObject row = (JSONObject) obj;
                JSONObject transformedRow = new JSONObject();

                Integer projectIdInt = row.getInt(ParamConfig.getProjectIdParam());
                if (key.equals(DbConfig.getPortfolioKey()))
                {
                    //project id transformation
                    String projectId = projectIdDict.get(projectIdInt);

                    //add project path
                    String projectPath = projectPathDict.get(projectIdInt);

                    //project version
                    ProjectVersion projectVersion = projectVersionDict.get(projectIdInt);

                    //output data
                    transformedRow.put(ParamConfig.getProjectIdParam(), projectId)
                            .put(ParamConfig.getProjectNameParam(), row.getString(ParamConfig.getProjectNameParam()))
                            .put(ParamConfig.getAnnotationTypeParam(), row.getInt(ParamConfig.getAnnotationTypeParam()))
                            .put(ParamConfig.getProjectPathParam(), projectPath)
                            .put(ParamConfig.getCurrentVersionParam(), projectVersion.getCurrentVersion().getDbFormat())
                            .put(ParamConfig.getProjectVersionParam(), projectVersion.getDbFormat())
                            .put(ParamConfig.getUuidVersionListParam(), projectVersion.getUuidVersionDbFormat())
                            .put(ParamConfig.getLabelVersionListParam(), projectVersion.getLabelVersionDbFormat())
                            .put(ParamConfig.getIsNewParam(), false)
                            .put(ParamConfig.getIsStarredParam(), false)
                            .put(ParamConfig.getProjectInfraParam(), ProjectInfra.ON_PREMISE.name());
                }
                else
                {
                    Integer uuidInt = row.getInt(ParamConfig.getUuidParam());

                    //project id transformation
                    String projectId = projectIdDict.get(projectIdInt);

                    //uuid transformation
                    String uuid = projectUuidDict.get(projectIdInt).get(uuidInt);

                    //relative path transformation
                    String imgPath = row.getString(ParamConfig.getImgPathParam());
                    String relativePath = imgPath.substring(imgPath.lastIndexOf(File.separator));

                    //version list and annotation transformation
                    JSONArray annotationArr = new JSONArray(row.getString(ParamConfig.getAnnotationParam()));

                    int imgX = row.getInt(ParamConfig.getImgXParam());
                    int imgY = row.getInt(ParamConfig.getImgYParam());
                    int imgW = row.getInt(ParamConfig.getImgWParam());
                    int imgH = row.getInt(ParamConfig.getImgHParam());

                    ProjectVersion projectVersion = projectVersionDict.get(projectIdInt);

                    String currVersionUuid = projectVersion.getCurrentVersion().getVersionUuid();

                    JSONArray versionList = buildVersionList(annotationArr, imgX, imgY, imgW, imgH, currVersionUuid);

                    //output data
                    transformedRow.put(ParamConfig.getUuidParam(), uuid)
                            .put(ParamConfig.getProjectIdParam(), projectId)
                            .put(ParamConfig.getImgPathParam(), relativePath)
                            .put(ParamConfig.getVersionListParam(), versionList)
                            .put(ParamConfig.getImgDepth(), row.getInt(ParamConfig.getImgDepth()))
                            .put(ParamConfig.getImgOriWParam(), row.getInt(ParamConfig.getImgOriWParam()))
                            .put(ParamConfig.getImgOriHParam(), row.getInt(ParamConfig.getImgOriHParam()))
                            .put(ParamConfig.getFileSizeParam(), row.getInt(ParamConfig.getFileSizeParam()));
                }
                transformedData.put(transformedRow);
            }

            transformedDict.put(key, transformedData);
        }

        return transformedDict;
    }

    private void buildMigratableProjDict(Map<String, JSONArray> jsonDict)
    {
        projectPathDict = new HashMap<>();

        for (String key : jsonDict.keySet())
        {
            Set<Integer> projectIdList = new HashSet<>();

            if (key.equals(DbConfig.getPortfolioKey())) continue;

            for (Object obj : jsonDict.get(key))
            {
                JSONObject row = (JSONObject) obj;

                projectIdList.add(row.getInt(ParamConfig.getProjectIdParam()));
            }

            for (Integer projectId : projectIdList)
            {
                String projectRootPath = null;

                for (Object obj : jsonDict.get(key))
                {
                    JSONObject row = (JSONObject) obj;

                    if (row.getInt(ParamConfig.getProjectIdParam()) == projectId)
                    {
                        String imgPath = row.getString(ParamConfig.getImgPathParam());

                        String currRootPath = imgPath.substring(0, imgPath.lastIndexOf(File.separator));

                        if (projectRootPath == null || projectRootPath.equals(currRootPath))
                        {
                            projectRootPath = currRootPath;
                        }
                        else
                        {
                            projectRootPath = null;
                            break;
                        }
                    }
                }

                if (projectRootPath != null)
                {
                    projectPathDict.put(projectId, projectRootPath);
                }
            }
        }
    }

    private JSONArray buildVersionList(JSONArray annotationArr, int imgX, int imgY, int imgW, int imgH, String currVersionUuid)
    {
        JSONArray versionList = new JSONArray();

        JSONObject currVersion = new JSONObject();

        JSONObject annotationData = buildAnnotationData(annotationArr, imgX, imgY, imgW, imgH);

        currVersion.put(ParamConfig.getVersionUuidParam(), currVersionUuid);
        currVersion.put(ParamConfig.getAnnotationDataParam(), annotationData);

        versionList.put(currVersion);

        return versionList;
    }

    private JSONObject buildAnnotationData(JSONArray annotationArr, int imgX, int imgY, int imgW, int imgH)
    {
        JSONObject annotationData = new JSONObject();

        annotationData.put(ParamConfig.getImgXParam(), imgX);
        annotationData.put(ParamConfig.getImgYParam(), imgY);
        annotationData.put(ParamConfig.getImgWParam(), imgW);
        annotationData.put(ParamConfig.getImgHParam(), imgH);
        annotationData.put(ParamConfig.getAnnotationParam(), transformAnnotation(annotationArr));

        return annotationData;
    }

    private JSONArray transformAnnotation(JSONArray annotationArr)
    {
        JSONArray outputArr = new JSONArray();

        for (Object annotation : annotationArr)
        {
            JSONObject jsonAnnotation = (JSONObject) annotation;

            //transform color based on lineWidth
            int lineWidth = jsonAnnotation.getInt(lineWidthParam);

            String color = lineWidth == 1 ? "rgba(255,255,0,0.8)" : "rgba(255,255,0,1.0)";

            jsonAnnotation.put(colorParam, color);

            outputArr.put(jsonAnnotation);
        }

        return outputArr;
    }
}