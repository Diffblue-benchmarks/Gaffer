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
import static org.junit.jupiter.api.Assertions.assertThrows;
import java.io.UnsupportedEncodingException;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.exception.SerialisationException;
import uk.gov.gchq.gaffer.serialisation.implementation.StringSerialiser;

class ToBytesViaStringDeserialiserDiffblueTest {
  /**
   * Method under test: {@link ToBytesViaStringDeserialiser#getCharset()}
   */
  @Test
  void testGetCharset() {
    // Arrange, Act and Assert
    assertEquals("UTF-8", (new StringSerialiser()).getCharset());
  }

  /**
   * Method under test: {@link ToBytesViaStringDeserialiser#deserialise(byte[])}
   */
  @Test
  void testDeserialise() throws UnsupportedEncodingException, SerialisationException {
    // Arrange
    StringSerialiser stringSerialiser = new StringSerialiser();

    // Act and Assert
    assertEquals("AXAXAXAX", stringSerialiser.deserialise("AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Method under test:
   * {@link ToBytesViaStringDeserialiser#deserialise(byte[], int, int)}
   */
  @Test
  void testDeserialise2() throws UnsupportedEncodingException, SerialisationException {
    // Arrange
    StringSerialiser stringSerialiser = new StringSerialiser();

    // Act and Assert
    assertEquals("AXA", stringSerialiser.deserialise("AXAXAXAX".getBytes("UTF-8"), 2, 3));
  }

  /**
   * Method under test: {@link ToBytesViaStringDeserialiser#serialise(Object)}
   */
  @Test
  void testSerialise() throws UnsupportedEncodingException, SerialisationException {
    // Arrange and Act
    byte[] actualSerialiseResult = (new StringSerialiser()).serialise("Object");

    // Assert
    assertArrayEquals("Object".getBytes("UTF-8"), actualSerialiseResult);
  }

  /**
   * Method under test: {@link ToBytesViaStringDeserialiser#serialise(Object)}
   */
  @Test
  void testSerialise2() throws SerialisationException {
    // Arrange
    StringSerialiser stringSerialiser = new StringSerialiser();
    stringSerialiser.setCharset("Charset");

    // Act and Assert
    assertThrows(SerialisationException.class, () -> stringSerialiser.serialise("Object"));
  }
}
