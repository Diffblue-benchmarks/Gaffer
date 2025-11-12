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

package uk.gov.gchq.gaffer.serialisation.implementation.tostring;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.exception.SerialisationException;

class StringToStringSerialiserDiffblueTest {
  /**
   * Method under test: {@link StringToStringSerialiser#canHandle(Class)}
   */
  @Test
  void testCanHandle() {
    // Arrange
    StringToStringSerialiser stringToStringSerialiser = new StringToStringSerialiser();
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertFalse(stringToStringSerialiser.canHandle(clazz));
  }

  /**
   * Method under test: {@link StringToStringSerialiser#canHandle(Class)}
   */
  @Test
  void testCanHandle2() {
    // Arrange
    StringToStringSerialiser stringToStringSerialiser = new StringToStringSerialiser();
    Class<String> clazz = String.class;

    // Act and Assert
    assertTrue(stringToStringSerialiser.canHandle(clazz));
  }

  /**
   * Method under test: {@link StringToStringSerialiser#serialise(String)}
   */
  @Test
  void testSerialise() throws SerialisationException {
    // Arrange, Act and Assert
    assertEquals("Object", (new StringToStringSerialiser()).serialise("Object"));
  }

  /**
   * Method under test: {@link StringToStringSerialiser#deserialise(String)}
   */
  @Test
  void testDeserialise() throws SerialisationException {
    // Arrange, Act and Assert
    assertEquals("foo", (new StringToStringSerialiser()).deserialise("foo"));
  }

  /**
   * Method under test: {@link StringToStringSerialiser#preservesObjectOrdering()}
   */
  @Test
  void testPreservesObjectOrdering() {
    // Arrange, Act and Assert
    assertTrue((new StringToStringSerialiser()).preservesObjectOrdering());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link StringToStringSerialiser}
   *   <li>{@link StringToStringSerialiser#isConsistent()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertTrue((new StringToStringSerialiser()).isConsistent());
  }
}
