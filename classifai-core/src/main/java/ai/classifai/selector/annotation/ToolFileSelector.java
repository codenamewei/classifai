/*
 * Copyright (c) 2020 CertifAI Sdn. Bhd.
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

package ai.classifai.selector.annotation;

import ai.classifai.data.type.image.ImageFileType;
import ai.classifai.loader.ProjectLoader;
import ai.classifai.selector.filesystem.FileSystemStatus;
import ai.classifai.ui.launcher.WelcomeLauncher;
import ai.classifai.util.ParamConfig;
import ai.classifai.util.ProjectHandler;
import ai.classifai.util.data.ImageHandler;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.io.File;
import java.util.ArrayList;

/**
 * Open browser to select files
 *
 * @author codenamewei
 */
@Slf4j
public class ToolFileSelector
{
    private static FileNameExtensionFilter imgfilter = new FileNameExtensionFilter("Image Files", ImageFileType.getImageFileTypes());

    public void run(@NonNull Integer projectID)
    {
        try {
            EventQueue.invokeLater(new Runnable() {
                @Override
                public void run() {

                    ProjectLoader loader = ProjectHandler.getProjectLoader(projectID);
                    loader.setFileSystemStatus(FileSystemStatus.WINDOW_OPEN);

                    Point pt = MouseInfo.getPointerInfo().getLocation();
                    JFrame frame = new JFrame();
                    frame.setAlwaysOnTop(true);
                    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    frame.setLocation(pt);
                    frame.requestFocus();
                    frame.setVisible(false);

                    JFileChooser chooser = new JFileChooser() {
                        @Override
                        protected JDialog createDialog(Component parent)
                                throws HeadlessException {
                            JDialog dialog = super.createDialog(parent);
                            dialog.setLocationByPlatform(true);
                            dialog.setAlwaysOnTop(true);
                            return dialog;
                        }
                    };

                    chooser.setCurrentDirectory(ParamConfig.getFileSysRootSearchPath());
                    chooser.setFileFilter(imgfilter);
                    chooser.setDialogTitle("Select Files");
                    chooser.setMultiSelectionEnabled(true);
                    chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
                    int res = chooser.showOpenDialog(frame);
                    frame.dispose();

                    //prevent Welcome Console from popping out
                    WelcomeLauncher.setToBackground();

                    if (res == JFileChooser.APPROVE_OPTION)
                    {
                        java.util.List<File> files = new ArrayList<>(java.util.Arrays.asList(chooser.getSelectedFiles()));

                        if((files != null) && (!files.isEmpty()) && (files.get(0) != null))
                        {

                            loader.setFileSystemStatus(FileSystemStatus.WINDOW_CLOSE_LOADING_FILES);

                            ImageHandler.processFile(projectID, files);
                        }
                        else
                        {
                            loader.setFileSystemStatus(FileSystemStatus.WINDOW_CLOSE_DATABASE_NOT_UPDATED);
                        }
                    }
                    else
                    {
                        loader.setFileSystemStatus(FileSystemStatus.WINDOW_CLOSE_DATABASE_NOT_UPDATED);
                    }

                }
            });
        }
        catch (Exception e){

            log.info("ProjectHandler for File type failed to open", e);
        }

    }

}


