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
package ai.classifai;

import ai.classifai.util.security.FileHashing;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.net.URISyntaxException;

/**
 * File Hashing Test
 *
 * @author codenamewei
 */
@Slf4j
public class FileHashingTest
{
    private static FileHashing fileHashing;
    private static File imageFile1;
    private static File imageFile2;


    @BeforeAll
    public static void setup()
    {
        fileHashing = new FileHashing();

        try
        {
            imageFile1 = new File(FileHashingTest.class.getClassLoader().getResource("lena.jpeg").toURI());
            imageFile2 = new File(FileHashingTest.class.getClassLoader().getResource("mnist.png").toURI());

        }
        catch(URISyntaxException e)
        {
            log.info("Exception when getting resource: ", e);
        }
    }

    @Test
    public void hashTestEqual()
    {
        String hash1 = fileHashing.hash(imageFile1);

        String hash2 = fileHashing.hash(imageFile1);

        //two hash value should be the same
        Assertions.assertEquals(hash1, hash2);
    }

    @Test
    public void hashTestNotEqual()
    {
        String hash1 = fileHashing.hash(imageFile1);

        String hash2 = fileHashing.hash(imageFile2);

        //input should be not same with another input which slightly varies
        Assertions.assertNotEquals(hash1, hash2);
    }

    @Test
    public void hashVariableInitialization()
    {
        String testInput = "hash variable";

        //initialization of different hash variable should not affect the hashing value of the same type
        Assertions.assertEquals(new FileHashing().hash(imageFile1), new FileHashing().hash(imageFile1));
    }
}
