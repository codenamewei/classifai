package ai.classifai.ui;
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

import ai.classifai.ui.SelectionWindow;
import ai.classifai.ui.launcher.LogoLauncher;
import ai.classifai.ui.launcher.WelcomeLauncher;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import javax.swing.*;

import java.awt.*;

import static javax.swing.JOptionPane.showMessageDialog;

/**
 * Abstraction of UI prompted from backend
 *
 * @author YCCertifai
 */
@Slf4j
public abstract class BackendUI
{
    private static final JFrame frame = initFrame();

    protected enum WindowStatus
    {
        WINDOW_OPEN,
        WINDOW_CLOSE
    }

    // To make sure window open once only
    @Getter
    @Setter
    protected WindowStatus windowStatus = WindowStatus.WINDOW_CLOSE;

    public static JFrame initFrame()
    {
        Point pt = MouseInfo.getPointerInfo().getLocation();
        JFrame frame = new JFrame();
        frame.setIconImage(LogoLauncher.getClassifaiIcon());

        frame.setAlwaysOnTop(true);
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        frame.setLocation(pt);
        frame.requestFocus();
        frame.setVisible(false);

        return frame;
    }

    public boolean isWindowOpen()
    {
        return windowStatus.equals(WindowStatus.WINDOW_OPEN);
    }

    public static void showPopupAndLog(String title, String message, int popupType)
    {
        log.debug(message);
        WelcomeLauncher.setToBackground();
        showMessageDialog(frame, message, title, popupType);
    }

    public void showAbortImportPopup()
    {
        String popupTitle = "Error Opening Window";
        String message = "Another window is currently open. Please close to proceed.";
        SelectionWindow.showPopupAndLog(popupTitle, message, JOptionPane.ERROR_MESSAGE);
    }
}
