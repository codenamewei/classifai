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
package ai.classifai.database.wasabis3;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Table to store Wasabi S3 credentials
 *
 * @author codenamewei
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class WasabiQuery
{
    @Getter private static final String queue = "wasabi.queue";

    @Getter private static final String createTable = "CREATE TABLE IF NOT EXISTS Wasabi (cloud_id VARCHAR(50), project_id UUID, access_key VARCHAR(200), secret_access_key VARCHAR(200), bucket VARCHAR(50), PRIMARY KEY (project_id))";

    @Getter private static final String writeCredential = "INSERT INTO Wasabi VALUES (?, ?, ?, ?, ?)";

    @Getter private static final String retrieveCredential = "SELECT * FROM Wasabi";
}
