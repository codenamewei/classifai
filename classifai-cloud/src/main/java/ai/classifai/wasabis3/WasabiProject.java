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
import io.vertx.core.json.JsonObject;
import lombok.Getter;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import software.amazon.awssdk.auth.credentials.AwsSessionCredentials;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.services.s3.S3Client;

import java.net.URI;

/**
 * Single wasabi project operation handler
 *
 * @author codenamewei
 */
@Slf4j
@Getter
public class WasabiProject
{
    private String cloudId;
    private S3Client wasabiS3Client;
    private String wasabiBucket;

    public WasabiProject(@NonNull JsonObject objectInput)
    {
        String accessKey = objectInput.getString(CloudParamConfig.getAccessKeyParam());
        String secretAccessKey = objectInput.getString(CloudParamConfig.getSecretAccessKeyParam());

        AwsSessionCredentials awsCreds = AwsSessionCredentials.create(accessKey, secretAccessKey, "");

        //TODO how to check if client is valid
        wasabiS3Client = S3Client.builder()
                .credentialsProvider(StaticCredentialsProvider.create(awsCreds))
                .endpointOverride(URI.create(CloudParamConfig.getWasabiUrl()))
                .region(CloudParamConfig.getRegion())
                .build();

        wasabiBucket = objectInput.getString(CloudParamConfig.getBucketParam());

        cloudId = objectInput.getString(CloudParamConfig.getCloudIdParam());

    }
}
