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
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class TypeSubTypeValueDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TypeSubTypeValue#TypeSubTypeValue()}
   *   <li>{@link TypeSubTypeValue#setSubType(String)}
   *   <li>{@link TypeSubTypeValue#setType(String)}
   *   <li>{@link TypeSubTypeValue#setValue(String)}
   *   <li>{@link TypeSubTypeValue#toString()}
   *   <li>{@link TypeSubTypeValue#getSubType()}
   *   <li>{@link TypeSubTypeValue#getType()}
   *   <li>{@link TypeSubTypeValue#getValue()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void TypeSubTypeValue.<init>()",
    "void TypeSubTypeValue.<init>(String, String, String)",
    "String TypeSubTypeValue.getSubType()",
    "String TypeSubTypeValue.getType()",
    "String TypeSubTypeValue.getValue()",
    "void TypeSubTypeValue.setSubType(String)",
    "void TypeSubTypeValue.setType(String)",
    "void TypeSubTypeValue.setValue(String)",
    "String TypeSubTypeValue.toString()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    TypeSubTypeValue actualTypeSubTypeValue = new TypeSubTypeValue();
    actualTypeSubTypeValue.setSubType("Sub Type");
    actualTypeSubTypeValue.setType("Type");
    actualTypeSubTypeValue.setValue("42");
    String actualToStringResult = actualTypeSubTypeValue.toString();
    String actualSubType = actualTypeSubTypeValue.getSubType();
    String actualType = actualTypeSubTypeValue.getType();

    // Assert
    assertEquals("42", actualTypeSubTypeValue.getValue());
    assertEquals("Sub Type", actualSubType);
    assertEquals("Type", actualType);
    assertEquals("TypeSubTypeValue[type=Type,subType=Sub Type,value=42]", actualToStringResult);
  }

  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>When {@code Type}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TypeSubTypeValue#TypeSubTypeValue(String, String, String)}
   *   <li>{@link TypeSubTypeValue#setSubType(String)}
   *   <li>{@link TypeSubTypeValue#setType(String)}
   *   <li>{@link TypeSubTypeValue#setValue(String)}
   *   <li>{@link TypeSubTypeValue#toString()}
   *   <li>{@link TypeSubTypeValue#getSubType()}
   *   <li>{@link TypeSubTypeValue#getType()}
   *   <li>{@link TypeSubTypeValue#getValue()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; when 'Type'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void TypeSubTypeValue.<init>()",
    "void TypeSubTypeValue.<init>(String, String, String)",
    "String TypeSubTypeValue.getSubType()",
    "String TypeSubTypeValue.getType()",
    "String TypeSubTypeValue.getValue()",
    "void TypeSubTypeValue.setSubType(String)",
    "void TypeSubTypeValue.setType(String)",
    "void TypeSubTypeValue.setValue(String)",
    "String TypeSubTypeValue.toString()"
  })
  void testGettersAndSetters_whenType() {
    // Arrange and Act
    TypeSubTypeValue actualTypeSubTypeValue = new TypeSubTypeValue("Type", "Sub Type", "42");
    actualTypeSubTypeValue.setSubType("Sub Type");
    actualTypeSubTypeValue.setType("Type");
    actualTypeSubTypeValue.setValue("42");
    String actualToStringResult = actualTypeSubTypeValue.toString();
    String actualSubType = actualTypeSubTypeValue.getSubType();
    String actualType = actualTypeSubTypeValue.getType();

    // Assert
    assertEquals("42", actualTypeSubTypeValue.getValue());
    assertEquals("Sub Type", actualSubType);
    assertEquals("Type", actualType);
    assertEquals("TypeSubTypeValue[type=Type,subType=Sub Type,value=42]", actualToStringResult);
  }

  /**
   * Test {@link TypeSubTypeValue#equals(Object)}, and {@link TypeSubTypeValue#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TypeSubTypeValue#equals(Object)}
   *   <li>{@link TypeSubTypeValue#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TypeSubTypeValue.equals(Object)", "int TypeSubTypeValue.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    TypeSubTypeValue typeSubTypeValue = new TypeSubTypeValue("Type", "Sub Type", "42");
    TypeSubTypeValue typeSubTypeValue2 = new TypeSubTypeValue("Type", "Sub Type", "42");

    // Act and Assert
    assertEquals(typeSubTypeValue, typeSubTypeValue2);
    assertEquals(typeSubTypeValue.hashCode(), typeSubTypeValue2.hashCode());
  }

  /**
   * Test {@link TypeSubTypeValue#equals(Object)}, and {@link TypeSubTypeValue#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TypeSubTypeValue#equals(Object)}
   *   <li>{@link TypeSubTypeValue#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TypeSubTypeValue.equals(Object)", "int TypeSubTypeValue.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    TypeSubTypeValue typeSubTypeValue = new TypeSubTypeValue("Type", "Sub Type", "42");

    // Act and Assert
    assertEquals(typeSubTypeValue, typeSubTypeValue);
    int expectedHashCodeResult = typeSubTypeValue.hashCode();
    assertEquals(expectedHashCodeResult, typeSubTypeValue.hashCode());
  }

  /**
   * Test {@link TypeSubTypeValue#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TypeSubTypeValue#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TypeSubTypeValue.equals(Object)", "int TypeSubTypeValue.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    TypeSubTypeValue typeSubTypeValue =
        new TypeSubTypeValue("uk.gov.gchq.gaffer.types.TypeSubTypeValue", "Sub Type", "42");

    // Act and Assert
    assertNotEquals(typeSubTypeValue, new TypeSubTypeValue("Type", "Sub Type", "42"));
  }

  /**
   * Test {@link TypeSubTypeValue#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TypeSubTypeValue#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TypeSubTypeValue.equals(Object)", "int TypeSubTypeValue.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TypeSubTypeValue("Type", "Sub Type", "42"), null);
  }

  /**
   * Test {@link TypeSubTypeValue#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TypeSubTypeValue#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TypeSubTypeValue.equals(Object)", "int TypeSubTypeValue.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        new TypeSubTypeValue("Type", "Sub Type", "42"), "Different type to TypeSubTypeValue");
  }

  /**
   * Test {@link TypeSubTypeValue#compareTo(TypeSubTypeValue)} with {@code TypeSubTypeValue}.
   *
   * <ul>
   *   <li>Then return thirty-four.
   * </ul>
   *
   * <p>Method under test: {@link TypeSubTypeValue#compareTo(TypeSubTypeValue)}
   */
  @Test
  @DisplayName("Test compareTo(TypeSubTypeValue) with 'TypeSubTypeValue'; then return thirty-four")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int TypeSubTypeValue.compareTo(TypeSubTypeValue)"})
  void testCompareToWithTypeSubTypeValue_thenReturnThirtyFour() {
    // Arrange
    TypeSubTypeValue typeSubTypeValue =
        new TypeSubTypeValue("Type", "uk.gov.gchq.gaffer.types.TypeSubTypeValue", "42");
    TypeSubTypeValue typeSubTypeValue2 = new TypeSubTypeValue("Type", "Sub Type", "42");

    // Act
    int actualCompareToResult = typeSubTypeValue.compareTo(typeSubTypeValue2);

    // Assert
    assertEquals(34, actualCompareToResult);
  }

  /**
   * Test {@link TypeSubTypeValue#compareTo(TypeSubTypeValue)} with {@code TypeSubTypeValue}.
   *
   * <ul>
   *   <li>Then return thirty-three.
   * </ul>
   *
   * <p>Method under test: {@link TypeSubTypeValue#compareTo(TypeSubTypeValue)}
   */
  @Test
  @DisplayName("Test compareTo(TypeSubTypeValue) with 'TypeSubTypeValue'; then return thirty-three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int TypeSubTypeValue.compareTo(TypeSubTypeValue)"})
  void testCompareToWithTypeSubTypeValue_thenReturnThirtyThree() {
    // Arrange
    TypeSubTypeValue typeSubTypeValue =
        new TypeSubTypeValue("uk.gov.gchq.gaffer.types.TypeSubTypeValue", "Sub Type", "42");
    TypeSubTypeValue typeSubTypeValue2 = new TypeSubTypeValue("Type", "Sub Type", "42");

    // Act
    int actualCompareToResult = typeSubTypeValue.compareTo(typeSubTypeValue2);

    // Assert
    assertEquals(33, actualCompareToResult);
  }

  /**
   * Test {@link TypeSubTypeValue#compareTo(TypeSubTypeValue)} with {@code TypeSubTypeValue}.
   *
   * <ul>
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link TypeSubTypeValue#compareTo(TypeSubTypeValue)}
   */
  @Test
  @DisplayName("Test compareTo(TypeSubTypeValue) with 'TypeSubTypeValue'; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int TypeSubTypeValue.compareTo(TypeSubTypeValue)"})
  void testCompareToWithTypeSubTypeValue_thenReturnZero() {
    // Arrange
    TypeSubTypeValue typeSubTypeValue = new TypeSubTypeValue("Type", "Sub Type", "42");
    TypeSubTypeValue typeSubTypeValue2 = new TypeSubTypeValue("Type", "Sub Type", "42");

    // Act
    int actualCompareToResult = typeSubTypeValue.compareTo(typeSubTypeValue2);

    // Assert
    assertEquals(0, actualCompareToResult);
  }

  /**
   * Test {@link TypeSubTypeValue#compareTo(TypeSubTypeValue)} with {@code TypeSubTypeValue}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link TypeSubTypeValue#compareTo(TypeSubTypeValue)}
   */
  @Test
  @DisplayName(
      "Test compareTo(TypeSubTypeValue) with 'TypeSubTypeValue'; when 'null'; then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int TypeSubTypeValue.compareTo(TypeSubTypeValue)"})
  void testCompareToWithTypeSubTypeValue_whenNull_thenReturnOne() {
    // Arrange
    TypeSubTypeValue typeSubTypeValue = new TypeSubTypeValue("Type", "Sub Type", "42");

    // Act and Assert
    assertEquals(1, typeSubTypeValue.compareTo(null));
  }
}
