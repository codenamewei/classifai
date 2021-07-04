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

import ai.classifai.database.versioning.ProjectVersion;
import ai.classifai.loader.NameGenerator;
import ai.classifai.loader.ProjectLoader;
import ai.classifai.loader.ProjectLoaderStatus;
import ai.classifai.selector.status.FileSystemStatus;
import ai.classifai.selector.status.NewProjectStatus;
import ai.classifai.util.collection.UuidGenerator;
import ai.classifai.util.project.ProjectHandler;
import ai.classifai.util.project.ProjectInfra;
import ai.classifai.util.type.AnnotationType;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;


@Slf4j
@NoArgsConstructor
public class YoloProjImport
{
    public boolean init(String projName, String strImgFolder, String labelTxtFile, String yoloLabelFolder)
    {
        Path yoloImagePath = Paths.get(strImgFolder);

        if(!yoloImagePath.toFile().exists())
        {
            yoloImagePath = null;
            log.info("YOLO Image Path not exist: " + strImgFolder);
            return false;
        }

        Path yoloLabelPath = yoloLabelFolder == null ? null : Paths.get(yoloLabelFolder);

        if((yoloLabelPath != null) && (!yoloLabelPath.toFile().exists()))
        {
            Path defaultYoloLabelPath = Paths.get(strImgFolder.replace("images", "labels"));

            yoloLabelPath = defaultYoloLabelPath.toFile().exists() ? defaultYoloLabelPath : null;

            if (yoloLabelPath == null) {
                log.info("YOLO Label Path not exist: " + defaultYoloLabelPath.toString());
                return false;
            }
        }

        if((projName == null) || (!ProjectHandler.isProjectNameUnique(projName, AnnotationType.BOUNDINGBOX.ordinal())))
        {
            projName = new NameGenerator().getNewProjectName();
        }

        List<String> labelDict = loadLabelTxtFile(new File(labelTxtFile));

        if((yoloImagePath != null) && (yoloLabelPath != null) && (labelDict != null))
        {
            ProjectLoader loader = ProjectLoader.builder()
                    .projectId(UuidGenerator.generateUuid())
                    .projectName(projName)
                    .annotationType(AnnotationType.BOUNDINGBOX.ordinal())
                    .projectPath(yoloImagePath.toFile())
                    //TODO: remove these
                    .isProjectNew(true)
                    .isProjectStarred(false)
                    .projectVersion(new ProjectVersion())
                    //TODO: -------------
                    .newProjectStatus(NewProjectStatus.YOLO)
                    .yoloLabelPath(yoloLabelPath.toFile())
                    .labelList(labelDict)
                    .projectLoaderStatus(ProjectLoaderStatus.LOADED)
                    .projectInfra(ProjectInfra.ON_PREMISE)
                    .fileSystemStatus(FileSystemStatus.ITERATING_FOLDER)
                    .build();

            ProjectHandler.loadProjectLoader(loader);

            loader.initFolderIteration();

            return true;
        }
        else
        {

            System.out.println((yoloImagePath != null) ? "(yoloImagePath != null)" : "(yoloImagePath == null)");
            System.out.println((yoloLabelPath != null) ? "(yoloLabelPath != null)" : "(yoloLabelPath == null)");
            System.out.println((labelDict != null) ? "(labelDict != null)" : "(labelDict == null)");

            log.info("YoloProject failed to initiate");
            return false;
        }
    }

    private List<String> loadLabelTxtFile(File labelTxtFile)
    {
        if(labelTxtFile == null) return null;

        List<String> labelRefDict = null;

        try
        {
            String labels = IOUtils.toString(new java.io.FileReader(labelTxtFile));

            labelRefDict = Arrays.asList(labels.split("\n"));
        }
        catch(Exception e)
        {
            log.debug("Error in loading label: ", e);
        }

        return labelRefDict;
    }

//    public void load()
//    {
//        List<String> imgStrList = ImageHandler.getValidImagesFromFolder(yoloProj.getYoloImagePath().toFile());
//
//        for(String imgStr : imgStrList)
//        {
//            System.out.println("Img: " + imgStr);
//
//            Path targetPathImg = Paths.get(imgStr);
//
//            String fileName = FileHandler.getFileNameWithoutExt(targetPathImg.toFile());
//
//            Path labelFile = Paths.get(yoloProj.getYoloLabelPath().toString(), fileName + LABEL_EXT);
//
//            System.out.println("Txt: " + labelFile.toString());
//
//            try
//            {
//                String labels = IOUtils.toString(new FileReader(labelFile.toFile()));
//
//                List<String> inputLabelLine = Arrays.asList(labels.split("\n"));
//
//                YoloFormat yoloFormat = new YoloFormat(inputLabelLine, yoloProj.getLabelMap().size());
//
//                //yoloProj.getYoloLabels().add(yoloFormat);
//
//                //TODO: write to annotation
//            }
//            catch(Exception e)
//            {
//                log.info("Error when loading label file: ", labelFile.toString());
//            }
//        }
//    }
}
