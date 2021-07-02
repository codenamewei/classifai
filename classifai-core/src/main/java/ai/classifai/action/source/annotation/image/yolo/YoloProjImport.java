/*
 * Copyright (c) 2021 CertifAI Sdn. Bhd.
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
package ai.classifai.action.source.annotation.image.yolo;

import ai.classifai.action.source.LabelListImport;
import ai.classifai.database.versioning.ProjectVersion;
import ai.classifai.loader.ProjectLoader;
import ai.classifai.loader.ProjectLoaderStatus;
import ai.classifai.selector.status.FileSystemStatus;
import ai.classifai.util.collection.UuidGenerator;
import ai.classifai.util.data.FileHandler;
import ai.classifai.util.data.ImageHandler;
import ai.classifai.util.project.ProjectHandler;
import ai.classifai.util.project.ProjectInfra;
import ai.classifai.util.type.AnnotationType;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.FileReader;
import java.util.Arrays;
import java.util.List;

@Slf4j
public class YoloProjImport
{
    private static final String LABEL_EXT = ".txt";
    private static final String IMG_FOLDER = "images";
    private static final String LABEL_FOLDER = "labels";

    public void importYoloProj(YoloProj yoloProj)
    {
        File projFolder = yoloProj.getProjectPath();

        File imageFile = Paths.get(projFolder.toString(), IMG_FOLDER).toFile();
        File labelTxtFile = Paths.get(projFolder.toString(), LABEL_FOLDER).toFile();

        if(imageFile.exists() && labelTxtFile.exists())
        {
            //create project
            loadProject(yoloProj);

        }
        else
        {
            //TODO: FAIL
        }
    }

    private void loadProject(YoloProj yoloProj)
    {
        LabelListImport labelImport = new LabelListImport(yoloProj.getLabelFilePath());

        ProjectLoader loader = ProjectLoader.builder()
                .projectId(UuidGenerator.generateUuid())
                .projectName(yoloProj.getProjectName())
                .annotationType(AnnotationType.BOUNDINGBOX.ordinal())
                .projectPath(yoloProj.getProjectPath())
                //TODO: remove these
                .isProjectNew(true)
                .isProjectStarred(false)
                .projectVersion(new ProjectVersion())
                //TODO: -------------
                .labelList(labelImport.getValidLabelList())
                .projectLoaderStatus(ProjectLoaderStatus.LOADED)
                .projectInfra(ProjectInfra.ON_PREMISE)
                .fileSystemStatus(FileSystemStatus.ITERATING_FOLDER)
                .build();

        ProjectHandler.loadProjectLoader(loader);

        YoloLabelParser yoloLabelParser = new YoloLabelParser(yoloProj.getLabelFilePath());

        //iterate image folder
        List<String> imgStrList = FileHandler.processFolder(yoloProj.getProjectPath(), ImageHandler::isImageFileValid);

        int numLabels = yoloLabelParser.getLabelRefDict().size();
        for(String imgStr : imgStrList)
        {
            Path targetPathImg = Paths.get(imgStr);

            String fileName = FileHandler.getFileNameWithoutExt(targetPathImg.toFile());

            Path targetPathLabel = Paths.get(yoloProj.getProjectPath().toString(), LABEL_FOLDER, fileName +  LABEL_EXT);

            try
            {
                String labels = IOUtils.toString(new FileReader(targetPathLabel.toFile()));

                List<String> inputLabelLine = Arrays.asList(labels.split("\n"));

                yoloLabelParser.getYoloContent().add(new YoloFormat(inputLabelLine, numLabels));
            }
            catch(Exception e)
            {
                log.info("Label file not found: ", e);
            }

        }
    }
}
