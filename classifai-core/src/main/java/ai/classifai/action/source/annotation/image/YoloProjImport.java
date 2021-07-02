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
package ai.classifai.action.source.annotation.image;

import ai.classifai.util.data.FileHandler;
import ai.classifai.util.data.ImageHandler;

import java.io.File;
import java.nio.file.Paths;
import java.util.List;

public class YoloProjImport
{
    public void importYoloProj(String projFolder, String labelFile)
    {
        File rootFile = new File(projFolder);

        if(rootFile.exists())
        {
            String imageFolder = "images";
            String labelTxtFolder = "labels";

            File imageFile = Paths.get(projFolder, imageFolder).toFile();
            File labelTxtFile = Paths.get(projFolder, labelTxtFolder).toFile();

            if(imageFile.exists() && labelTxtFile.exists())
            {
                //iterate image folder

                List<String> inputFiles = FileHandler.processFolder(rootFile, ImageHandler::isImageFileValid);
            }
            else
            {
                //TODO: FAIL
            }
        }
        else
        {
            //TODO: FAIL
        }
    }
}
