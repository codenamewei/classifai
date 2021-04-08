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

import ai.classifai.util.security.Encryption;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


/**
 * Encryption test
 *
 * @author codenamewei
 */
public class EncryptionTest
{
    @Test
    public void encryptionTestEqual()
    {
        Encryption encryption = new Encryption();

        String input = "Hello World";

        String encryptedInput = encryption.encrypt(input);

        //two value should be the same
        Assertions.assertEquals(input, encryption.decrypt(encryptedInput));
    }

    @Test
    public void encryptionTestNotEqual()
    {
        String input = "Hello World";

        String input2 = "Hello world";

        Encryption encryption = new Encryption();

        //input should be not same with another input which slightly varies
        Assertions.assertNotEquals(encryption.encrypt(input), encryption.encrypt(input2));
    }

}
