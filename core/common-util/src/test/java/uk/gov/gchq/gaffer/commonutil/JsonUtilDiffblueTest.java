/*
 * Copyright 2025 Crown Copyright
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package uk.gov.gchq.gaffer.commonutil;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.io.UnsupportedEncodingException;
import org.junit.jupiter.api.Test;

class JsonUtilDiffblueTest {
  /**
   * Method under test: {@link JsonUtil#equals(String, String)}
   */
  @Test
  void testEquals() {
    // Arrange, Act and Assert
    assertFalse(JsonUtil.equals("Expected Json", "Actual Json"));
    assertTrue(JsonUtil.equals((String) null, null));
    assertFalse(JsonUtil.equals(null, "Actual Json"));
    assertFalse(JsonUtil.equals("42", "Actual Json"));
    assertFalse(JsonUtil.equals("", "Actual Json"));
    assertFalse(JsonUtil.equals("42", "Error comparing json.\nexpectedJson:\n {}\n actual json:\n"));
    assertTrue(JsonUtil.equals((byte[]) null, null));
    assertFalse(JsonUtil.equals(null, new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'}));
    assertFalse(JsonUtil.equals(new byte[]{3, 'X', 'A', 'X', 'A', 'X', 'A', 'X'}, "AXAXAXAX".getBytes("UTF-8")));
    assertFalse(JsonUtil.equals(new byte[]{}, "AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Method under test: {@link JsonUtil#equals(byte[], byte[])}
   */
  @Test
  void testEquals2() throws UnsupportedEncodingException {
    // Arrange
    byte[] expectedJson = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertFalse(JsonUtil.equals(expectedJson, "AXAXAXAX".getBytes("UTF-8")));
  }
}
