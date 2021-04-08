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
package ai.classifai.util.security;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;

/**
 * AES Encryption
 *
 * @author codenamewei
 */
@Slf4j
public class Encryption
{
    private static final String UTF8 = "UTF-8";
    private static final String ALGORITHM = "AES/ECB/PKCS5Padding";

    private static SecretKeySpec secretKey;
    private static byte[] key;

    private static void setKey()
    {
        final String myKey = "0rB5Sa]}}I>HM%9?3)jBSCnkY1zX,R";
        MessageDigest sha;
        try {
            key = myKey.getBytes(UTF8);
            sha = MessageDigest.getInstance("SHA-1");
            key = sha.digest(key);
            key = Arrays.copyOf(key, 16);
            secretKey = new SecretKeySpec(key, "AES");
        }
        catch (NoSuchAlgorithmException e)
        {
            log.debug("NoSuchAlgorithmException: ", e);
        }
        catch (UnsupportedEncodingException e)
        {
            log.debug("UnsupportedEncodingException: ", e);
        }
    }

    public String encrypt(@NonNull String input)
    {
        try
        {
            setKey();
            Cipher cipher = Cipher.getInstance(ALGORITHM);
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            return Base64.getEncoder().encodeToString(cipher.doFinal(input.getBytes(UTF8)));
        }
        catch (Exception e)
        {
            log.info("Error while encrypting: ", e);
        }
        return null;
    }

    public String decrypt(@NonNull String encryptedInput)
    {
        try
        {
            setKey();
            Cipher cipher = Cipher.getInstance(ALGORITHM);
            cipher.init(Cipher.DECRYPT_MODE, secretKey);
            return new String(cipher.doFinal(Base64.getDecoder().decode(encryptedInput)));
        }
        catch (Exception e)
        {
            log.info("Error while decrypting: ", e);
        }

        return null;
    }

}
