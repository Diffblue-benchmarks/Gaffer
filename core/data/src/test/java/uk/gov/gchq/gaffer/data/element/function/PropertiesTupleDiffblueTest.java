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

package uk.gov.gchq.gaffer.data.element.function;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.data.element.Properties;

class PropertiesTupleDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link PropertiesTuple#PropertiesTuple()}
   *   <li>{@link PropertiesTuple#setProperties(Properties)}
   *   <li>{@link PropertiesTuple#toString()}
   *   <li>{@link PropertiesTuple#getProperties()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PropertiesTuple.<init>()", "void PropertiesTuple.<init>(Properties)",
      "Properties PropertiesTuple.getProperties()", "void PropertiesTuple.setProperties(Properties)",
      "String PropertiesTuple.toString()"})
  void testGettersAndSetters() {
    // Arrange and Act
    PropertiesTuple actualPropertiesTuple = new PropertiesTuple();
    Properties properties = new Properties();
    actualPropertiesTuple.setProperties(properties);
    String actualToStringResult = actualPropertiesTuple.toString();

    // Assert
    assertEquals("PropertiesTuple[properties=Properties[]]", actualToStringResult);
    assertSame(properties, actualPropertiesTuple.getProperties());
  }

  /**
   * Test getters and setters.
   * <ul>
   *   <li>When {@link Properties#Properties()}.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link PropertiesTuple#PropertiesTuple(Properties)}
   *   <li>{@link PropertiesTuple#setProperties(Properties)}
   *   <li>{@link PropertiesTuple#toString()}
   *   <li>{@link PropertiesTuple#getProperties()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; when Properties()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PropertiesTuple.<init>()", "void PropertiesTuple.<init>(Properties)",
      "Properties PropertiesTuple.getProperties()", "void PropertiesTuple.setProperties(Properties)",
      "String PropertiesTuple.toString()"})
  void testGettersAndSetters_whenProperties() {
    // Arrange and Act
    PropertiesTuple actualPropertiesTuple = new PropertiesTuple(new Properties());
    Properties properties = new Properties();
    actualPropertiesTuple.setProperties(properties);
    String actualToStringResult = actualPropertiesTuple.toString();

    // Assert
    assertEquals("PropertiesTuple[properties=Properties[]]", actualToStringResult);
    assertSame(properties, actualPropertiesTuple.getProperties());
  }

  /**
   * Test {@link PropertiesTuple#get(String)} with {@code String}.
   * <ul>
   *   <li>Given {@link PropertiesTuple#PropertiesTuple(Properties)} with properties is {@link Properties#Properties()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PropertiesTuple#get(String)}
   */
  @Test
  @DisplayName("Test get(String) with 'String'; given PropertiesTuple(Properties) with properties is Properties(); then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object PropertiesTuple.get(String)"})
  void testGetWithString_givenPropertiesTupleWithPropertiesIsProperties_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new PropertiesTuple(new Properties())).get("Property Name"));
  }

  /**
   * Test {@link PropertiesTuple#get(String)} with {@code String}.
   * <ul>
   *   <li>Given {@link PropertiesTuple#PropertiesTuple()}.</li>
   *   <li>When {@link PropertiesTuple#PROPERTIES}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PropertiesTuple#get(String)}
   */
  @Test
  @DisplayName("Test get(String) with 'String'; given PropertiesTuple(); when PROPERTIES; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object PropertiesTuple.get(String)"})
  void testGetWithString_givenPropertiesTuple_whenProperties_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new PropertiesTuple()).get(PropertiesTuple.PROPERTIES));
  }

  /**
   * Test {@link PropertiesTuple#equals(Object)}, and {@link PropertiesTuple#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link PropertiesTuple#equals(Object)}
   *   <li>{@link PropertiesTuple#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean PropertiesTuple.equals(Object)", "int PropertiesTuple.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    PropertiesTuple propertiesTuple = new PropertiesTuple();
    PropertiesTuple propertiesTuple2 = new PropertiesTuple();

    // Act and Assert
    assertEquals(propertiesTuple, propertiesTuple2);
    int expectedHashCodeResult = propertiesTuple.hashCode();
    assertEquals(expectedHashCodeResult, propertiesTuple2.hashCode());
  }

  /**
   * Test {@link PropertiesTuple#equals(Object)}, and {@link PropertiesTuple#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link PropertiesTuple#equals(Object)}
   *   <li>{@link PropertiesTuple#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean PropertiesTuple.equals(Object)", "int PropertiesTuple.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    PropertiesTuple propertiesTuple = new PropertiesTuple();

    // Act and Assert
    assertEquals(propertiesTuple, propertiesTuple);
    int expectedHashCodeResult = propertiesTuple.hashCode();
    assertEquals(expectedHashCodeResult, propertiesTuple.hashCode());
  }

  /**
   * Test {@link PropertiesTuple#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link PropertiesTuple#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean PropertiesTuple.equals(Object)", "int PropertiesTuple.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    PropertiesTuple propertiesTuple = new PropertiesTuple();
    propertiesTuple.setProperties(new Properties());

    // Act and Assert
    assertNotEquals(propertiesTuple, new PropertiesTuple());
  }

  /**
   * Test {@link PropertiesTuple#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link PropertiesTuple#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean PropertiesTuple.equals(Object)", "int PropertiesTuple.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new PropertiesTuple(), null);
  }

  /**
   * Test {@link PropertiesTuple#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link PropertiesTuple#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean PropertiesTuple.equals(Object)", "int PropertiesTuple.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new PropertiesTuple(), "Different type to PropertiesTuple");
  }
}
