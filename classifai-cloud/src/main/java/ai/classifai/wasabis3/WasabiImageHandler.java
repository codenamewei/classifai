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

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import software.amazon.awssdk.core.ResponseInputStream;
import software.amazon.awssdk.services.s3.model.GetObjectRequest;
import software.amazon.awssdk.services.s3.model.GetObjectResponse;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Base64;


/**
 * Wasabi image handler
 *
 * @author codenamewei
 */
@Slf4j
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class WasabiImageHandler
{

    public static String getRawBase64Binary(@NonNull WasabiCredential wasabiCredential, @NonNull String dataPath)
    {
        byte[] bytes = getObject(wasabiCredential, dataPath);

        return Base64.getEncoder().encodeToString(bytes);
    }

    public static BufferedImage getThumbNail(@NonNull WasabiCredential wasabiCredential, @NonNull String dataPath)
    {
        byte[] bytes = getObject(wasabiCredential, dataPath);

        return bytesToBufferedImage(bytes);
    }

    private static byte[] getObject(@NonNull WasabiCredential project, @NonNull String key)
    {
        GetObjectRequest objectRequest = GetObjectRequest.builder()
                .bucket(project.getWasabiBucket())
                .key(key)
                .range("*")
                .build();

        ResponseInputStream<GetObjectResponse> objectPortion = project.getWasabiS3Client().getObject(objectRequest);

        if(objectPortion != null)
        {
            try
            {
                byte[] bytes = objectPortion.readAllBytes();

                return bytes;
            }
            catch(Exception e)
            {
                log.info("Read data wrong");
            }
        }
        else
        {
            log.info("Object response is null: " + project.getWasabiBucket() + " " + key);
        }

        return null;
    }

    private static BufferedImage bytesToBufferedImage(byte[] imageData)
    {
        ByteArrayInputStream byteArray = new ByteArrayInputStream(imageData);

        try
        {
            return ImageIO.read(byteArray);
        }
        catch (IOException e)
        {
            log.debug("Failure in the conversion from bytes to BufferedImage");
        }

        return null;
    }


}
