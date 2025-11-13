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
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.exception.SerialisationException;

class StringSerialiserDiffblueTest {
  /**
   * Test new {@link StringSerialiser} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of {@link StringSerialiser}
   */
  @Test
  @DisplayName("Test new StringSerialiser (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void StringSerialiser.<init>()"})
  void testNewStringSerialiser() {
    // Arrange and Act
    StringSerialiser actualStringSerialiser = new StringSerialiser();

    // Assert
    assertEquals("UTF-8", actualStringSerialiser.getCharset());
    assertTrue(actualStringSerialiser.isConsistent());
  }

  /**
   * Test {@link StringSerialiser#canHandle(Class)}.
   * <ul>
   *   <li>When {@code Object}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringSerialiser#canHandle(Class)}
   */
  @Test
  @DisplayName("Test canHandle(Class); when 'java.lang.Object'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean StringSerialiser.canHandle(Class)"})
  void testCanHandle_whenJavaLangObject_thenReturnFalse() {
    // Arrange
    StringSerialiser stringSerialiser = new StringSerialiser();
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertFalse(stringSerialiser.canHandle(clazz));
  }

  /**
   * Test {@link StringSerialiser#canHandle(Class)}.
   * <ul>
   *   <li>When {@code String}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringSerialiser#canHandle(Class)}
   */
  @Test
  @DisplayName("Test canHandle(Class); when 'java.lang.String'; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean StringSerialiser.canHandle(Class)"})
  void testCanHandle_whenJavaLangString_thenReturnTrue() {
    // Arrange
    StringSerialiser stringSerialiser = new StringSerialiser();
    Class<String> clazz = String.class;

    // Act and Assert
    assertTrue(stringSerialiser.canHandle(clazz));
  }

  /**
   * Test {@link StringSerialiser#serialiseToString(String)} with {@code String}.
   * <p>
   * Method under test: {@link StringSerialiser#serialiseToString(String)}
   */
  @Test
  @DisplayName("Test serialiseToString(String) with 'String'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StringSerialiser.serialiseToString(String)"})
  void testSerialiseToStringWithString() throws SerialisationException {
    // Arrange, Act and Assert
    assertEquals("Object", (new StringSerialiser()).serialiseToString("Object"));
  }

  /**
   * Test {@link StringSerialiser#deserialiseString(String)}.
   * <p>
   * Method under test: {@link StringSerialiser#deserialiseString(String)}
   */
  @Test
  @DisplayName("Test deserialiseString(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StringSerialiser.deserialiseString(String)"})
  void testDeserialiseString() throws SerialisationException {
    // Arrange, Act and Assert
    assertEquals("42", (new StringSerialiser()).deserialiseString("42"));
  }

  /**
   * Test {@link StringSerialiser#deserialiseEmpty()}.
   * <p>
   * Method under test: {@link StringSerialiser#deserialiseEmpty()}
   */
  @Test
  @DisplayName("Test deserialiseEmpty()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StringSerialiser.deserialiseEmpty()"})
  void testDeserialiseEmpty() {
    // Arrange, Act and Assert
    assertEquals("", (new StringSerialiser()).deserialiseEmpty());
  }

  /**
   * Test {@link StringSerialiser#preservesObjectOrdering()}.
   * <p>
   * Method under test: {@link StringSerialiser#preservesObjectOrdering()}
   */
  @Test
  @DisplayName("Test preservesObjectOrdering()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean StringSerialiser.preservesObjectOrdering()"})
  void testPreservesObjectOrdering() {
    // Arrange, Act and Assert
    assertTrue((new StringSerialiser()).preservesObjectOrdering());
  }

  /**
   * Test {@link StringSerialiser#isConsistent()}.
   * <p>
   * Method under test: {@link StringSerialiser#isConsistent()}
   */
  @Test
  @DisplayName("Test isConsistent()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean StringSerialiser.isConsistent()"})
  void testIsConsistent() {
    // Arrange, Act and Assert
    assertTrue((new StringSerialiser()).isConsistent());
  }

  /**
   * Test {@link StringSerialiser#equals(Object)}, and {@link StringSerialiser#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link StringSerialiser#equals(Object)}
   *   <li>{@link StringSerialiser#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean StringSerialiser.equals(Object)", "int StringSerialiser.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    StringSerialiser stringSerialiser = new StringSerialiser();
    StringSerialiser stringSerialiser2 = new StringSerialiser();

    // Act and Assert
    assertEquals(stringSerialiser, stringSerialiser2);
    int expectedHashCodeResult = stringSerialiser.hashCode();
    assertEquals(expectedHashCodeResult, stringSerialiser2.hashCode());
  }

  /**
   * Test {@link StringSerialiser#equals(Object)}, and {@link StringSerialiser#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link StringSerialiser#equals(Object)}
   *   <li>{@link StringSerialiser#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean StringSerialiser.equals(Object)", "int StringSerialiser.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    StringSerialiser stringSerialiser = new StringSerialiser();

    // Act and Assert
    assertEquals(stringSerialiser, stringSerialiser);
    int expectedHashCodeResult = stringSerialiser.hashCode();
    assertEquals(expectedHashCodeResult, stringSerialiser.hashCode());
  }

  /**
   * Test {@link StringSerialiser#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringSerialiser#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean StringSerialiser.equals(Object)", "int StringSerialiser.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new StringSerialiser(), 1);
  }

  /**
   * Test {@link StringSerialiser#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringSerialiser#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean StringSerialiser.equals(Object)", "int StringSerialiser.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new StringSerialiser(), null);
  }

  /**
   * Test {@link StringSerialiser#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringSerialiser#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean StringSerialiser.equals(Object)", "int StringSerialiser.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new StringSerialiser(), "Different type to StringSerialiser");
  }
}
