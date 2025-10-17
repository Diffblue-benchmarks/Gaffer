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
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.TreeSet;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.exception.SerialisationException;

class TreeSetStringSerialiserDiffblueTest {
  /**
   * Test new {@link TreeSetStringSerialiser} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link TreeSetStringSerialiser}
   */
  @Test
  @DisplayName("Test new TreeSetStringSerialiser (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TreeSetStringSerialiser.<init>()"})
  void testNewTreeSetStringSerialiser() {
    // Arrange and Act
    TreeSetStringSerialiser actualTreeSetStringSerialiser = new TreeSetStringSerialiser();

    // Assert
    assertEquals("UTF-8", actualTreeSetStringSerialiser.getCharset());
    assertTrue(actualTreeSetStringSerialiser.isConsistent());
  }

  /**
   * Test {@link TreeSetStringSerialiser#canHandle(Class)}.
   *
   * <ul>
   *   <li>When {@code Object}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link TreeSetStringSerialiser#canHandle(Class)}
   */
  @Test
  @DisplayName("Test canHandle(Class); when 'java.lang.Object'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TreeSetStringSerialiser.canHandle(Class)"})
  void testCanHandle_whenJavaLangObject_thenReturnFalse() {
    // Arrange
    TreeSetStringSerialiser treeSetStringSerialiser = new TreeSetStringSerialiser();
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertFalse(treeSetStringSerialiser.canHandle(clazz));
  }

  /**
   * Test {@link TreeSetStringSerialiser#canHandle(Class)}.
   *
   * <ul>
   *   <li>When {@code TreeSet}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link TreeSetStringSerialiser#canHandle(Class)}
   */
  @Test
  @DisplayName("Test canHandle(Class); when 'java.util.TreeSet'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TreeSetStringSerialiser.canHandle(Class)"})
  void testCanHandle_whenJavaUtilTreeSet_thenReturnTrue() {
    // Arrange
    TreeSetStringSerialiser treeSetStringSerialiser = new TreeSetStringSerialiser();
    Class<TreeSet> clazz = TreeSet.class;

    // Act and Assert
    assertTrue(treeSetStringSerialiser.canHandle(clazz));
  }

  /**
   * Test {@link TreeSetStringSerialiser#serialiseToString(TreeSet)} with {@code TreeSet}.
   *
   * <p>Method under test: {@link TreeSetStringSerialiser#serialiseToString(TreeSet)}
   */
  @Test
  @DisplayName("Test serialiseToString(TreeSet) with 'TreeSet'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TreeSetStringSerialiser.serialiseToString(TreeSet)"})
  void testSerialiseToStringWithTreeSet() throws SerialisationException {
    // Arrange
    TreeSetStringSerialiser treeSetStringSerialiser = new TreeSetStringSerialiser();

    TreeSet<String> object = new TreeSet<>();
    object.add("{");

    // Act and Assert
    assertEquals("{{}", treeSetStringSerialiser.serialiseToString(object));
  }

  /**
   * Test {@link TreeSetStringSerialiser#serialiseToString(TreeSet)} with {@code TreeSet}.
   *
   * <p>Method under test: {@link TreeSetStringSerialiser#serialiseToString(TreeSet)}
   */
  @Test
  @DisplayName("Test serialiseToString(TreeSet) with 'TreeSet'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TreeSetStringSerialiser.serialiseToString(TreeSet)"})
  void testSerialiseToStringWithTreeSet2() throws SerialisationException {
    // Arrange
    TreeSetStringSerialiser treeSetStringSerialiser = new TreeSetStringSerialiser();

    TreeSet<String> object = new TreeSet<>();
    object.add("}");
    object.add("{");

    // Act and Assert
    assertEquals("{{\\,}}", treeSetStringSerialiser.serialiseToString(object));
  }

  /**
   * Test {@link TreeSetStringSerialiser#serialiseToString(TreeSet)} with {@code TreeSet}.
   *
   * <ul>
   *   <li>Then return {@code {}}.
   * </ul>
   *
   * <p>Method under test: {@link TreeSetStringSerialiser#serialiseToString(TreeSet)}
   */
  @Test
  @DisplayName("Test serialiseToString(TreeSet) with 'TreeSet'; then return '{}'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TreeSetStringSerialiser.serialiseToString(TreeSet)"})
  void testSerialiseToStringWithTreeSet_thenReturnLeftCurlyBracketRightCurlyBracket()
      throws SerialisationException {
    // Arrange
    TreeSetStringSerialiser treeSetStringSerialiser = new TreeSetStringSerialiser();

    // Act and Assert
    assertEquals("{}", treeSetStringSerialiser.serialiseToString(new TreeSet<>()));
  }

  /**
   * Test {@link TreeSetStringSerialiser#deserialiseString(String)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link TreeSetStringSerialiser#deserialiseString(String)}
   */
  @Test
  @DisplayName("Test deserialiseString(String); when '42'; then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TreeSet TreeSetStringSerialiser.deserialiseString(String)"})
  void testDeserialiseString_when42_thenReturnEmpty() throws SerialisationException {
    // Arrange, Act and Assert
    assertTrue(new TreeSetStringSerialiser().deserialiseString("42").isEmpty());
  }

  /**
   * Test {@link TreeSetStringSerialiser#deserialiseString(String)}.
   *
   * <ul>
   *   <li>When {@code Value}.
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link TreeSetStringSerialiser#deserialiseString(String)}
   */
  @Test
  @DisplayName("Test deserialiseString(String); when 'Value'; then return size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TreeSet TreeSetStringSerialiser.deserialiseString(String)"})
  void testDeserialiseString_whenValue_thenReturnSizeIsOne() throws SerialisationException {
    // Arrange and Act
    TreeSet<String> actualDeserialiseStringResult =
        new TreeSetStringSerialiser().deserialiseString("Value");

    // Assert
    assertEquals(1, actualDeserialiseStringResult.size());
    assertTrue(actualDeserialiseStringResult.contains("alu"));
  }

  /**
   * Test {@link TreeSetStringSerialiser#deserialiseEmpty()}.
   *
   * <p>Method under test: {@link TreeSetStringSerialiser#deserialiseEmpty()}
   */
  @Test
  @DisplayName("Test deserialiseEmpty()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TreeSet TreeSetStringSerialiser.deserialiseEmpty()"})
  void testDeserialiseEmpty() {
    // Arrange, Act and Assert
    assertTrue(new TreeSetStringSerialiser().deserialiseEmpty().isEmpty());
  }

  /**
   * Test {@link TreeSetStringSerialiser#preservesObjectOrdering()}.
   *
   * <p>Method under test: {@link TreeSetStringSerialiser#preservesObjectOrdering()}
   */
  @Test
  @DisplayName("Test preservesObjectOrdering()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TreeSetStringSerialiser.preservesObjectOrdering()"})
  void testPreservesObjectOrdering() {
    // Arrange, Act and Assert
    assertTrue(new TreeSetStringSerialiser().preservesObjectOrdering());
  }

  /**
   * Test {@link TreeSetStringSerialiser#isConsistent()}.
   *
   * <p>Method under test: {@link TreeSetStringSerialiser#isConsistent()}
   */
  @Test
  @DisplayName("Test isConsistent()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TreeSetStringSerialiser.isConsistent()"})
  void testIsConsistent() {
    // Arrange, Act and Assert
    assertTrue(new TreeSetStringSerialiser().isConsistent());
  }

  /**
   * Test {@link TreeSetStringSerialiser#equals(Object)}, and {@link
   * TreeSetStringSerialiser#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TreeSetStringSerialiser#equals(Object)}
   *   <li>{@link TreeSetStringSerialiser#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TreeSetStringSerialiser.equals(Object)",
    "int TreeSetStringSerialiser.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    TreeSetStringSerialiser treeSetStringSerialiser = new TreeSetStringSerialiser();
    TreeSetStringSerialiser treeSetStringSerialiser2 = new TreeSetStringSerialiser();

    // Act and Assert
    assertEquals(treeSetStringSerialiser, treeSetStringSerialiser2);
    assertEquals(treeSetStringSerialiser.hashCode(), treeSetStringSerialiser2.hashCode());
  }

  /**
   * Test {@link TreeSetStringSerialiser#equals(Object)}, and {@link
   * TreeSetStringSerialiser#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TreeSetStringSerialiser#equals(Object)}
   *   <li>{@link TreeSetStringSerialiser#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TreeSetStringSerialiser.equals(Object)",
    "int TreeSetStringSerialiser.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    TreeSetStringSerialiser treeSetStringSerialiser = new TreeSetStringSerialiser();

    // Act and Assert
    assertEquals(treeSetStringSerialiser, treeSetStringSerialiser);
    int expectedHashCodeResult = treeSetStringSerialiser.hashCode();
    assertEquals(expectedHashCodeResult, treeSetStringSerialiser.hashCode());
  }

  /**
   * Test {@link TreeSetStringSerialiser#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TreeSetStringSerialiser#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TreeSetStringSerialiser.equals(Object)",
    "int TreeSetStringSerialiser.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TreeSetStringSerialiser(), 1);
  }

  /**
   * Test {@link TreeSetStringSerialiser#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TreeSetStringSerialiser#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TreeSetStringSerialiser.equals(Object)",
    "int TreeSetStringSerialiser.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TreeSetStringSerialiser(), null);
  }

  /**
   * Test {@link TreeSetStringSerialiser#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TreeSetStringSerialiser#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TreeSetStringSerialiser.equals(Object)",
    "int TreeSetStringSerialiser.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TreeSetStringSerialiser(), "Different type to TreeSetStringSerialiser");
  }
}
