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

import java.net.URL;
import java.net.URLConnection;

/**
 * Check if internet is connected
 *
 * @authpr codenamewei
 */
public class InternetConnection
{
    private final static String URL = "http://www.google.com";

    public static boolean isConnected()
    {
        try
        {
            URL url = new URL(URL);

            URLConnection connection = url.openConnection();

            connection.connect();

            return true;
        }
        catch (Exception e)
        {
            return false;
        }
    }
}
