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
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.TreeSet;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.exception.SerialisationException;

class TreeSetStringSerialiserDiffblueTest {
  /**
   * Method under test: {@link TreeSetStringSerialiser#canHandle(Class)}
   */
  @Test
  void testCanHandle() {
    // Arrange
    TreeSetStringSerialiser treeSetStringSerialiser = new TreeSetStringSerialiser();
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertFalse(treeSetStringSerialiser.canHandle(clazz));
  }

  /**
   * Method under test: {@link TreeSetStringSerialiser#canHandle(Class)}
   */
  @Test
  void testCanHandle2() {
    // Arrange
    TreeSetStringSerialiser treeSetStringSerialiser = new TreeSetStringSerialiser();
    Class<TreeSet> clazz = TreeSet.class;

    // Act and Assert
    assertTrue(treeSetStringSerialiser.canHandle(clazz));
  }

  /**
   * Method under test: {@link TreeSetStringSerialiser#serialiseToString(TreeSet)}
   */
  @Test
  void testSerialiseToString() throws SerialisationException {
    // Arrange
    TreeSetStringSerialiser treeSetStringSerialiser = new TreeSetStringSerialiser();

    // Act and Assert
    assertEquals("{}", treeSetStringSerialiser.serialiseToString(new TreeSet<>()));
  }

  /**
   * Method under test: {@link TreeSetStringSerialiser#serialiseToString(TreeSet)}
   */
  @Test
  void testSerialiseToString2() throws SerialisationException {
    // Arrange
    TreeSetStringSerialiser treeSetStringSerialiser = new TreeSetStringSerialiser();

    TreeSet<String> object = new TreeSet<>();
    object.add("{");

    // Act and Assert
    assertEquals("{{}", treeSetStringSerialiser.serialiseToString(object));
  }

  /**
   * Method under test: {@link TreeSetStringSerialiser#serialiseToString(TreeSet)}
   */
  @Test
  void testSerialiseToString3() throws SerialisationException {
    // Arrange
    TreeSetStringSerialiser treeSetStringSerialiser = new TreeSetStringSerialiser();

    TreeSet<String> object = new TreeSet<>();
    object.add("}");
    object.add("{");

    // Act and Assert
    assertEquals("{{\\,}}", treeSetStringSerialiser.serialiseToString(object));
  }

  /**
   * Method under test: {@link TreeSetStringSerialiser#deserialiseString(String)}
   */
  @Test
  void testDeserialiseString() throws SerialisationException {
    // Arrange, Act and Assert
    assertTrue((new TreeSetStringSerialiser()).deserialiseString("42").isEmpty());
    assertTrue((new TreeSetStringSerialiser()).deserialiseString("\\,").isEmpty());
  }

  /**
   * Method under test: {@link TreeSetStringSerialiser#deserialiseString(String)}
   */
  @Test
  void testDeserialiseString2() throws SerialisationException {
    // Arrange and Act
    TreeSet<String> actualDeserialiseStringResult = (new TreeSetStringSerialiser()).deserialiseString("Value");

    // Assert
    assertEquals(1, actualDeserialiseStringResult.size());
    assertTrue(actualDeserialiseStringResult.contains("alu"));
  }

  /**
   * Method under test: {@link TreeSetStringSerialiser#deserialiseEmpty()}
   */
  @Test
  void testDeserialiseEmpty() {
    // Arrange, Act and Assert
    assertTrue((new TreeSetStringSerialiser()).deserialiseEmpty().isEmpty());
  }

  /**
   * Method under test: {@link TreeSetStringSerialiser#preservesObjectOrdering()}
   */
  @Test
  void testPreservesObjectOrdering() {
    // Arrange, Act and Assert
    assertTrue((new TreeSetStringSerialiser()).preservesObjectOrdering());
  }

  /**
   * Method under test: {@link TreeSetStringSerialiser#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TreeSetStringSerialiser(), 1);
  }

  /**
   * Method under test: {@link TreeSetStringSerialiser#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TreeSetStringSerialiser(), null);
  }

  /**
   * Method under test: {@link TreeSetStringSerialiser#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TreeSetStringSerialiser(), "Different type to TreeSetStringSerialiser");
  }

  /**
   * Method under test: {@link TreeSetStringSerialiser#isConsistent()}
   */
  @Test
  void testIsConsistent() {
    // Arrange, Act and Assert
    assertTrue((new TreeSetStringSerialiser()).isConsistent());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link TreeSetStringSerialiser#equals(Object)}
   *   <li>{@link TreeSetStringSerialiser#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    TreeSetStringSerialiser treeSetStringSerialiser = new TreeSetStringSerialiser();
    TreeSetStringSerialiser treeSetStringSerialiser2 = new TreeSetStringSerialiser();

    // Act and Assert
    assertEquals(treeSetStringSerialiser, treeSetStringSerialiser2);
    int expectedHashCodeResult = treeSetStringSerialiser.hashCode();
    assertEquals(expectedHashCodeResult, treeSetStringSerialiser2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link TreeSetStringSerialiser#equals(Object)}
   *   <li>{@link TreeSetStringSerialiser#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    TreeSetStringSerialiser treeSetStringSerialiser = new TreeSetStringSerialiser();

    // Act and Assert
    assertEquals(treeSetStringSerialiser, treeSetStringSerialiser);
    int expectedHashCodeResult = treeSetStringSerialiser.hashCode();
    assertEquals(expectedHashCodeResult, treeSetStringSerialiser.hashCode());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link TreeSetStringSerialiser}
   */
  @Test
  void testNewTreeSetStringSerialiser() {
    // Arrange and Act
    TreeSetStringSerialiser actualTreeSetStringSerialiser = new TreeSetStringSerialiser();

    // Assert
    assertEquals("UTF-8", actualTreeSetStringSerialiser.getCharset());
    assertTrue(actualTreeSetStringSerialiser.isConsistent());
  }
}
