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

package uk.gov.gchq.gaffer.serialisation.implementation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.io.UnsupportedEncodingException;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.exception.SerialisationException;

class BytesSerialiserDiffblueTest {
  /**
   * Method under test: {@link BytesSerialiser#canHandle(Class)}
   */
  @Test
  void testCanHandle() {
    // Arrange
    BytesSerialiser bytesSerialiser = new BytesSerialiser();
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertFalse(bytesSerialiser.canHandle(clazz));
  }

  /**
   * Method under test: {@link BytesSerialiser#serialise(byte[])}
   */
  @Test
  void testSerialise() throws UnsupportedEncodingException, SerialisationException {
    // Arrange
    BytesSerialiser bytesSerialiser = new BytesSerialiser();
    byte[] value = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertSame(value, bytesSerialiser.serialise(value));
  }

  /**
   * Method under test: {@link BytesSerialiser#deserialise(byte[])}
   */
  @Test
  void testDeserialise() throws UnsupportedEncodingException, SerialisationException {
    // Arrange
    BytesSerialiser bytesSerialiser = new BytesSerialiser();
    byte[] bytes = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertSame(bytes, bytesSerialiser.deserialise(bytes));
  }

  /**
   * Method under test: {@link BytesSerialiser#deserialiseEmpty()}
   */
  @Test
  void testDeserialiseEmpty() {
    // Arrange, Act and Assert
    assertEquals(0, (new BytesSerialiser()).deserialiseEmpty().length);
  }

  /**
   * Method under test: {@link BytesSerialiser#preservesObjectOrdering()}
   */
  @Test
  void testPreservesObjectOrdering() {
    // Arrange, Act and Assert
    assertTrue((new BytesSerialiser()).preservesObjectOrdering());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link BytesSerialiser#equals(Object)}
   *   <li>{@link BytesSerialiser#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    BytesSerialiser bytesSerialiser = new BytesSerialiser();
    BytesSerialiser bytesSerialiser2 = new BytesSerialiser();

    // Act and Assert
    assertEquals(bytesSerialiser, bytesSerialiser2);
    int expectedHashCodeResult = bytesSerialiser.hashCode();
    assertEquals(expectedHashCodeResult, bytesSerialiser2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link BytesSerialiser#equals(Object)}
   *   <li>{@link BytesSerialiser#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    BytesSerialiser bytesSerialiser = new BytesSerialiser();

    // Act and Assert
    assertEquals(bytesSerialiser, bytesSerialiser);
    int expectedHashCodeResult = bytesSerialiser.hashCode();
    assertEquals(expectedHashCodeResult, bytesSerialiser.hashCode());
  }

  /**
   * Method under test: {@link BytesSerialiser#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new BytesSerialiser(), 1);
  }

  /**
   * Method under test: {@link BytesSerialiser#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new BytesSerialiser(), null);
  }

  /**
   * Method under test: {@link BytesSerialiser#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new BytesSerialiser(), "Different type to BytesSerialiser");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link BytesSerialiser}
   *   <li>{@link BytesSerialiser#isConsistent()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertTrue((new BytesSerialiser()).isConsistent());
  }
}
