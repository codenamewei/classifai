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
package ai.classifai.wasabis3;

import ai.classifai.util.CloudParamConfig;
import ai.classifai.util.security.Encryption;
import lombok.NonNull;
import software.amazon.awssdk.auth.credentials.AwsSessionCredentials;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.services.s3.S3Client;

import java.net.URI;

/**
 * Wasabi Client Creation
 *
 * @author codenamewei
 */
public class WasabiClientHandler
{
    public static S3Client buildClient(@NonNull String accessKey, @NonNull String secretAccessKey, boolean isEncrypted)
    {

        if(isEncrypted)
        {
            Encryption encryption = new Encryption();

            accessKey = encryption.decrypt(accessKey);
            secretAccessKey = encryption.decrypt(secretAccessKey);
        }

        AwsSessionCredentials awsCreds = AwsSessionCredentials.create(accessKey, secretAccessKey, "");

        //TODO how to check if client is valid
        return S3Client.builder()
                .credentialsProvider(StaticCredentialsProvider.create(awsCreds))
                .endpointOverride(URI.create(CloudParamConfig.getWasabiUrl()))
                .region(CloudParamConfig.getRegion())
                .build();
    }
}
