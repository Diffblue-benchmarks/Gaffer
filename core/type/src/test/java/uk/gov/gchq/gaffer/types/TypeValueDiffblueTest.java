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

package uk.gov.gchq.gaffer.types;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class TypeValueDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TypeValue#TypeValue()}
   *   <li>{@link TypeValue#setType(String)}
   *   <li>{@link TypeValue#setValue(String)}
   *   <li>{@link TypeValue#toString()}
   *   <li>{@link TypeValue#getType()}
   *   <li>{@link TypeValue#getValue()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TypeValue.<init>()", "void TypeValue.<init>(String, String)", "String TypeValue.getType()",
      "String TypeValue.getValue()", "void TypeValue.setType(String)", "void TypeValue.setValue(String)",
      "String TypeValue.toString()"})
  void testGettersAndSetters() {
    // Arrange and Act
    TypeValue actualTypeValue = new TypeValue();
    actualTypeValue.setType("Type");
    actualTypeValue.setValue("42");
    String actualToStringResult = actualTypeValue.toString();
    String actualType = actualTypeValue.getType();

    // Assert
    assertEquals("42", actualTypeValue.getValue());
    assertEquals("Type", actualType);
    assertEquals("TypeValue[type=Type,value=42]", actualToStringResult);
  }

  /**
   * Test getters and setters.
   * <ul>
   *   <li>When {@code Type}.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TypeValue#TypeValue(String, String)}
   *   <li>{@link TypeValue#setType(String)}
   *   <li>{@link TypeValue#setValue(String)}
   *   <li>{@link TypeValue#toString()}
   *   <li>{@link TypeValue#getType()}
   *   <li>{@link TypeValue#getValue()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; when 'Type'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TypeValue.<init>()", "void TypeValue.<init>(String, String)", "String TypeValue.getType()",
      "String TypeValue.getValue()", "void TypeValue.setType(String)", "void TypeValue.setValue(String)",
      "String TypeValue.toString()"})
  void testGettersAndSetters_whenType() {
    // Arrange and Act
    TypeValue actualTypeValue = new TypeValue("Type", "42");
    actualTypeValue.setType("Type");
    actualTypeValue.setValue("42");
    String actualToStringResult = actualTypeValue.toString();
    String actualType = actualTypeValue.getType();

    // Assert
    assertEquals("42", actualTypeValue.getValue());
    assertEquals("Type", actualType);
    assertEquals("TypeValue[type=Type,value=42]", actualToStringResult);
  }

  /**
   * Test {@link TypeValue#equals(Object)}, and {@link TypeValue#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TypeValue#equals(Object)}
   *   <li>{@link TypeValue#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TypeValue.equals(Object)", "int TypeValue.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    TypeValue typeValue = new TypeValue("Type", "42");
    TypeValue typeValue2 = new TypeValue("Type", "42");

    // Act and Assert
    assertEquals(typeValue, typeValue2);
    int expectedHashCodeResult = typeValue.hashCode();
    assertEquals(expectedHashCodeResult, typeValue2.hashCode());
  }

  /**
   * Test {@link TypeValue#equals(Object)}, and {@link TypeValue#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TypeValue#equals(Object)}
   *   <li>{@link TypeValue#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TypeValue.equals(Object)", "int TypeValue.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    TypeValue typeValue = new TypeValue("Type", "42");

    // Act and Assert
    assertEquals(typeValue, typeValue);
    int expectedHashCodeResult = typeValue.hashCode();
    assertEquals(expectedHashCodeResult, typeValue.hashCode());
  }

  /**
   * Test {@link TypeValue#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TypeValue#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TypeValue.equals(Object)", "int TypeValue.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    TypeValue typeValue = new TypeValue("uk.gov.gchq.gaffer.types.TypeValue", "42");

    // Act and Assert
    assertNotEquals(typeValue, new TypeValue("Type", "42"));
  }

  /**
   * Test {@link TypeValue#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TypeValue#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TypeValue.equals(Object)", "int TypeValue.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TypeValue("Type", "42"), null);
  }

  /**
   * Test {@link TypeValue#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TypeValue#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TypeValue.equals(Object)", "int TypeValue.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TypeValue("Type", "42"), "Different type to TypeValue");
  }

  /**
   * Test {@link TypeValue#compareTo(TypeValue)} with {@code TypeValue}.
   * <ul>
   *   <li>Given {@link TypeValue#TypeValue(String, String)} with {@code Type} and value is {@code 42}.</li>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link TypeValue#compareTo(TypeValue)}
   */
  @Test
  @DisplayName("Test compareTo(TypeValue) with 'TypeValue'; given TypeValue(String, String) with 'Type' and value is '42'; then return zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int TypeValue.compareTo(TypeValue)"})
  void testCompareToWithTypeValue_givenTypeValueWithTypeAndValueIs42_thenReturnZero() {
    // Arrange
    TypeValue typeValue = new TypeValue("Type", "42");

    // Act and Assert
    assertEquals(0, typeValue.compareTo(new TypeValue("Type", "42")));
  }

  /**
   * Test {@link TypeValue#compareTo(TypeValue)} with {@code TypeValue}.
   * <ul>
   *   <li>Then return thirty-three.</li>
   * </ul>
   * <p>
   * Method under test: {@link TypeValue#compareTo(TypeValue)}
   */
  @Test
  @DisplayName("Test compareTo(TypeValue) with 'TypeValue'; then return thirty-three")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int TypeValue.compareTo(TypeValue)"})
  void testCompareToWithTypeValue_thenReturnThirtyThree() {
    // Arrange
    TypeValue typeValue = new TypeValue("uk.gov.gchq.gaffer.types.TypeValue", "42");

    // Act and Assert
    assertEquals(33, typeValue.compareTo(new TypeValue("Type", "42")));
  }

  /**
   * Test {@link TypeValue#compareTo(TypeValue)} with {@code TypeValue}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return one.</li>
   * </ul>
   * <p>
   * Method under test: {@link TypeValue#compareTo(TypeValue)}
   */
  @Test
  @DisplayName("Test compareTo(TypeValue) with 'TypeValue'; when 'null'; then return one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int TypeValue.compareTo(TypeValue)"})
  void testCompareToWithTypeValue_whenNull_thenReturnOne() {
    // Arrange, Act and Assert
    assertEquals(1, (new TypeValue("Type", "42")).compareTo(null));
  }
}
