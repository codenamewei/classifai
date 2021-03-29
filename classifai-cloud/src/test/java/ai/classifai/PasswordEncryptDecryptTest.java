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

import ai.classifai.util.PasswordHash;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

/**
 * Password hashing test
 *
 * @author codenamewei
 */
@Slf4j
public class PasswordEncryptDecryptTest
{
    private static PasswordHash passwordHash;

    @BeforeAll
    public static void setup()
    {
        passwordHash = new PasswordHash();
    }

    @Test
    public void passwordTestEqual()
    {
        String testInput = "the quick brown fox jumps over the lazy dog";

        String encrypted = passwordHash.encrypt(testInput);

        String decrypted = passwordHash.decrypt(encrypted);

        //input should be same with decryption of input
        Assertions.assertEquals(testInput, decrypted);
    }

    @Test
    public void passwordTestNotEqual()
    {
        String testInput = "testInput";
        String anotherTestInput = "testinput";

        String encrypted = passwordHash.encrypt(testInput);

        String decrypted = passwordHash.decrypt(encrypted);

        //input should be not same with another input which slightly varies
        Assertions.assertNotEquals(anotherTestInput, decrypted);
    }


}
