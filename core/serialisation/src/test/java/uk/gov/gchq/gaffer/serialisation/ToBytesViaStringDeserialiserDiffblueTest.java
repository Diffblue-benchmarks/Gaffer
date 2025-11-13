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
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.UnsupportedEncodingException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.exception.SerialisationException;
import uk.gov.gchq.gaffer.serialisation.implementation.StringSerialiser;

class ToBytesViaStringDeserialiserDiffblueTest {
  /**
   * Test {@link ToBytesViaStringDeserialiser#getCharset()}.
   * <p>
   * Method under test: {@link ToBytesViaStringDeserialiser#getCharset()}
   */
  @Test
  @DisplayName("Test getCharset()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String ToBytesViaStringDeserialiser.getCharset()"})
  void testGetCharset() {
    // Arrange, Act and Assert
    assertEquals("UTF-8", (new StringSerialiser()).getCharset());
  }

  /**
   * Test {@link ToBytesViaStringDeserialiser#deserialise(byte[], int, int)} with {@code allBytes}, {@code offset}, {@code length}.
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   *   <li>Then return {@code AXA}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ToBytesViaStringDeserialiser#deserialise(byte[], int, int)}
   */
  @Test
  @DisplayName("Test deserialise(byte[], int, int) with 'allBytes', 'offset', 'length'; when 'AXAXAXAX' Bytes is 'UTF-8'; then return 'AXA'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object ToBytesViaStringDeserialiser.deserialise(byte[], int, int)"})
  void testDeserialiseWithAllBytesOffsetLength_whenAxaxaxaxBytesIsUtf8_thenReturnAxa()
      throws UnsupportedEncodingException, SerialisationException {
    // Arrange
    StringSerialiser stringSerialiser = new StringSerialiser();

    // Act and Assert
    assertEquals("AXA", stringSerialiser.deserialise("AXAXAXAX".getBytes("UTF-8"), 2, 3));
  }

  /**
   * Test {@link ToBytesViaStringDeserialiser#deserialise(byte[])} with {@code bytes}.
   * <p>
   * Method under test: {@link ToBytesViaStringDeserialiser#deserialise(byte[])}
   */
  @Test
  @DisplayName("Test deserialise(byte[]) with 'bytes'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object ToBytesViaStringDeserialiser.deserialise(byte[])"})
  void testDeserialiseWithBytes() throws UnsupportedEncodingException, SerialisationException {
    // Arrange
    StringSerialiser stringSerialiser = new StringSerialiser();

    // Act and Assert
    assertEquals("AXAXAXAX", stringSerialiser.deserialise("AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link ToBytesViaStringDeserialiser#serialise(Object)}.
   * <ul>
   *   <li>Given {@link StringSerialiser} (default constructor).</li>
   *   <li>Then return {@code Object} Bytes is {@code UTF-8}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ToBytesViaStringDeserialiser#serialise(Object)}
   */
  @Test
  @DisplayName("Test serialise(Object); given StringSerialiser (default constructor); then return 'Object' Bytes is 'UTF-8'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"byte[] ToBytesViaStringDeserialiser.serialise(Object)"})
  void testSerialise_givenStringSerialiser_thenReturnObjectBytesIsUtf8()
      throws UnsupportedEncodingException, SerialisationException {
    // Arrange and Act
    byte[] actualSerialiseResult = (new StringSerialiser()).serialise("Object");

    // Assert
    assertArrayEquals("Object".getBytes("UTF-8"), actualSerialiseResult);
  }

  /**
   * Test {@link ToBytesViaStringDeserialiser#serialise(Object)}.
   * <ul>
   *   <li>Then throw {@link SerialisationException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ToBytesViaStringDeserialiser#serialise(Object)}
   */
  @Test
  @DisplayName("Test serialise(Object); then throw SerialisationException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"byte[] ToBytesViaStringDeserialiser.serialise(Object)"})
  void testSerialise_thenThrowSerialisationException() throws SerialisationException {
    // Arrange
    StringSerialiser stringSerialiser = new StringSerialiser();
    stringSerialiser.setCharset("Charset");

    // Act and Assert
    assertThrows(SerialisationException.class, () -> stringSerialiser.serialise("Object"));
  }
}
