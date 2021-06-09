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
package ai.classifai.ui;

import ai.classifai.util.ParamConfig;
import lombok.extern.slf4j.Slf4j;

import javax.swing.*;
import java.awt.*;

/**
 * For selection windows initialization and settings
 *
 * @author devenyantis
 */
@Slf4j
public class SelectionWindow extends BackendUI
{
    public static JFileChooser initChooser(int mode, String title)
    {
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

        chooser.setDialogTitle(title);
        chooser.setCurrentDirectory(ParamConfig.getRootSearchPath());
        chooser.setMultiSelectionEnabled(false);
        chooser.setFileSelectionMode(mode);
        chooser.setAcceptAllFileFilterUsed(false);

        return chooser;
    }
}
