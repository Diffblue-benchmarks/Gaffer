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

package uk.gov.gchq.gaffer.serialisation;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.io.UnsupportedEncodingException;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.exception.SerialisationException;
import uk.gov.gchq.gaffer.serialisation.implementation.BooleanSerialiser;
import uk.gov.gchq.gaffer.serialisation.implementation.BytesSerialiser;

class ToBytesSerialiserDiffblueTest {
  /**
   * Method under test: {@link ToBytesSerialiser#serialiseNull()}
   */
  @Test
  void testSerialiseNull() {
    // Arrange, Act and Assert
    assertEquals(0, (new BooleanSerialiser()).serialiseNull().length);
  }

  /**
   * Method under test: {@link ToBytesSerialiser#deserialise(byte[], int, int)}
   */
  @Test
  void testDeserialise() throws UnsupportedEncodingException, SerialisationException {
    // Arrange
    BytesSerialiser bytesSerialiser = new BytesSerialiser();

    // Act
    byte[] actualDeserialiseResult = bytesSerialiser.deserialise("AXAXAXAX".getBytes("UTF-8"), 2, 3);

    // Assert
    assertArrayEquals("AXA".getBytes("UTF-8"), actualDeserialiseResult);
  }
}
