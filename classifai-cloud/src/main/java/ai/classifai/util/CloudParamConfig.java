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

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import software.amazon.awssdk.regions.Region;

/***
 * Parameters configuration for cloud-based projects
 *
 * @author codenamewei
 */
@Slf4j
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CloudParamConfig
{
    @Getter private static final String wasabiUrl = "https://s3.wasabisys.com";

    @Getter private static final String wasabiTable = "Wasabi";

    @Getter private static final String cloudIdParam = "cloud_id";

    @Getter private static final String accessKeyParam = "access_key";

    @Getter private static final String secretAccessKeyParam = "secret_access_key";

    @Getter private static final String bucketParam = "bucket";

    //FIXME: hardcode of region
    @Getter private static final Region region = Region.US_EAST_1;
}
