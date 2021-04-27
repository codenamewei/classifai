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
package ai.classifai.ui.component;

import ai.classifai.ui.launcher.WelcomeLauncher;

import javax.swing.*;

/***
 * confirm dialog prompted to obtain user selection: yes or no
 *
 *
 * @author YCCertifai
 */
public class ConfirmDialog
{
    private String title;
    private String message;

    public ConfirmDialog(String title, String message)
    {
        this.title = title;
        this.message = message;
    }

    public boolean init()
    {
        JFrame frame = new JFrame(title);
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        frame.setAlwaysOnTop(true);
        frame.setLocationRelativeTo(null);
        frame.requestFocus();
        WelcomeLauncher.setToBackground();
        frame.setVisible(false);
        int result = JOptionPane.showConfirmDialog(frame, message, title,
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE);

        frame.dispose();

        return result == JOptionPane.YES_OPTION;
    }
}