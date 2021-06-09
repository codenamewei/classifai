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
package ai.classifai.util;

import ai.classifai.ui.component.BrowserHandler;
import ai.classifai.ui.component.LogHandler;
import ai.classifai.ui.component.ProgramOpener;
import ai.classifai.util.type.OS;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.util.List;

/**
 * Handler for system action
 *
 * @author YCCertifai
 */
@Slf4j
public class SystemHandler
{
    public static boolean openLogFile()
    {
        boolean isOpen = false;

        OS currentOS = ParamConfig.getOsManager().getCurrentOS();

        List<String> programPath = LogHandler.getOSEditor(currentOS);

        for (String editor : programPath)
        {
            if (isProgramPathExist(editor))
            {
                String[] command = null;

                String logPath = ParamConfig.getLogFilePath();

                if (currentOS.equals(OS.MAC))
                {
                    command = new String[]{"/usr/bin/open", "-e", logPath};
                }
                else if (currentOS.equals(OS.WINDOWS))
                {
                    command = new String[]{editor + " " + logPath};
                }
                else if (currentOS.equals(OS.LINUX))
                {
                    command = new String[]{"gio", "open", logPath};
                }

                if (ProgramOpener.runProgramPath(currentOS, command))
                {
                    isOpen = true;
                    break;
                }
            }
        }
        return isOpen;
    }

    public static boolean openBrowser()
    {
        boolean isOpen = false;

        OS currentOS = ParamConfig.getOsManager().getCurrentOS();

        List<String> programPath = BrowserHandler.getOSBrowser(currentOS);

        for (String browser : programPath)
        {
            if (isProgramPathExist(browser))
            {
                String[] command = null;

                if (currentOS.equals(OS.MAC))
                {
                    command = new String[]{"/usr/bin/open", "-a", browser, BrowserHandler.getBrowserURL()};
                }
                else if (currentOS.equals(OS.WINDOWS))
                {
                    command = new String[]{browser + " " + BrowserHandler.getBrowserURL()};
                }
                else if (currentOS.equals(OS.LINUX))
                {
                    command = new String[]{"gio", "open", BrowserHandler.getBrowserURL()};
                }

                if (ProgramOpener.runProgramPath(currentOS, command)) {
                    isOpen = true;
                    break;
                }
            }
        }

        return isOpen;
    }

    private static boolean isProgramPathExist(String appPath)
    {
        if (appPath.equals("default"))
        {
            return true;
        }
        if (!new File(appPath).exists())
        {
            log.debug("Program not found - " + appPath);

            return false;
        }
        return true;
    }
}
