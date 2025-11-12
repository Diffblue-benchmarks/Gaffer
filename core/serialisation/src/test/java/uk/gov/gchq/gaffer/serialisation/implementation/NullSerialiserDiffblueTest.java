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
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.io.UnsupportedEncodingException;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.exception.SerialisationException;

class NullSerialiserDiffblueTest {
  /**
   * Method under test: {@link NullSerialiser#canHandle(Class)}
   */
  @Test
  void testCanHandle() {
    // Arrange
    NullSerialiser nullSerialiser = new NullSerialiser();
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertTrue(nullSerialiser.canHandle(clazz));
  }

  /**
   * Method under test: {@link NullSerialiser#serialise(Object)}
   */
  @Test
  void testSerialise() throws SerialisationException {
    // Arrange, Act and Assert
    assertEquals(0, (new NullSerialiser()).serialise("Value").length);
  }

  /**
   * Method under test: {@link NullSerialiser#deserialise(byte[])}
   */
  @Test
  void testDeserialise() throws UnsupportedEncodingException, SerialisationException {
    // Arrange
    NullSerialiser nullSerialiser = new NullSerialiser();

    // Act and Assert
    assertNull(nullSerialiser.deserialise("AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Method under test: {@link NullSerialiser#deserialiseEmpty()}
   */
  @Test
  void testDeserialiseEmpty() {
    // Arrange, Act and Assert
    assertNull((new NullSerialiser()).deserialiseEmpty());
  }

  /**
   * Method under test: {@link NullSerialiser#preservesObjectOrdering()}
   */
  @Test
  void testPreservesObjectOrdering() {
    // Arrange, Act and Assert
    assertTrue((new NullSerialiser()).preservesObjectOrdering());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link NullSerialiser#equals(Object)}
   *   <li>{@link NullSerialiser#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    NullSerialiser nullSerialiser = new NullSerialiser();
    NullSerialiser nullSerialiser2 = new NullSerialiser();

    // Act and Assert
    assertEquals(nullSerialiser, nullSerialiser2);
    int expectedHashCodeResult = nullSerialiser.hashCode();
    assertEquals(expectedHashCodeResult, nullSerialiser2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link NullSerialiser#equals(Object)}
   *   <li>{@link NullSerialiser#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    NullSerialiser nullSerialiser = new NullSerialiser();

    // Act and Assert
    assertEquals(nullSerialiser, nullSerialiser);
    int expectedHashCodeResult = nullSerialiser.hashCode();
    assertEquals(expectedHashCodeResult, nullSerialiser.hashCode());
  }

  /**
   * Method under test: {@link NullSerialiser#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new NullSerialiser(), 1);
  }

  /**
   * Method under test: {@link NullSerialiser#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new NullSerialiser(), null);
  }

  /**
   * Method under test: {@link NullSerialiser#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new NullSerialiser(), "Different type to NullSerialiser");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link NullSerialiser}
   *   <li>{@link NullSerialiser#isConsistent()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertTrue((new NullSerialiser()).isConsistent());
  }
}
