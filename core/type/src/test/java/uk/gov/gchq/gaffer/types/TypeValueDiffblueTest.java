package uk.gov.gchq.gaffer.types;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class TypeValueDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
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
   *
   * <ul>
   *   <li>When {@code Type}.
   * </ul>
   *
   * <p>Methods under test:
   *
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
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TypeValue#equals(Object)}
   *   <li>{@link TypeValue#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    TypeValue typeValue = new TypeValue("Type", "42");
    TypeValue typeValue2 = new TypeValue("Type", "42");

    // Act and Assert
    assertEquals(typeValue, typeValue2);
    assertEquals(typeValue.hashCode(), typeValue2.hashCode());
  }

  /**
   * Test {@link TypeValue#equals(Object)}, and {@link TypeValue#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TypeValue#equals(Object)}
   *   <li>{@link TypeValue#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
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
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TypeValue#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    TypeValue typeValue = new TypeValue("uk.gov.gchq.gaffer.types.TypeValue", "42");

    // Act and Assert
    assertNotEquals(typeValue, new TypeValue("Type", "42"));
  }

  /**
   * Test {@link TypeValue#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TypeValue#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TypeValue("Type", "42"), null);
  }

  /**
   * Test {@link TypeValue#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TypeValue#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TypeValue("Type", "42"), "Different type to TypeValue");
  }

  /**
   * Test {@link TypeValue#compareTo(TypeValue)} with {@code TypeValue}.
   *
   * <ul>
   *   <li>Given {@link TypeValue#TypeValue(String, String)} with {@code Type} and value is {@code
   *       42}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link TypeValue#compareTo(TypeValue)}
   */
  @Test
  @DisplayName(
      "Test compareTo(TypeValue) with 'TypeValue'; given TypeValue(String, String) with 'Type' and value is '42'; then return zero")
  @Tag("MaintainedByDiffblue")
  void testCompareToWithTypeValue_givenTypeValueWithTypeAndValueIs42_thenReturnZero() {
    // Arrange
    TypeValue typeValue = new TypeValue("Type", "42");

    // Act
    int actualCompareToResult = typeValue.compareTo(new TypeValue("Type", "42"));

    // Assert
    assertEquals(0, actualCompareToResult);
  }

  /**
   * Test {@link TypeValue#compareTo(TypeValue)} with {@code TypeValue}.
   *
   * <ul>
   *   <li>Then return thirty-three.
   * </ul>
   *
   * <p>Method under test: {@link TypeValue#compareTo(TypeValue)}
   */
  @Test
  @DisplayName("Test compareTo(TypeValue) with 'TypeValue'; then return thirty-three")
  @Tag("MaintainedByDiffblue")
  void testCompareToWithTypeValue_thenReturnThirtyThree() {
    // Arrange
    TypeValue typeValue = new TypeValue("uk.gov.gchq.gaffer.types.TypeValue", "42");

    // Act
    int actualCompareToResult = typeValue.compareTo(new TypeValue("Type", "42"));

    // Assert
    assertEquals(33, actualCompareToResult);
  }

  /**
   * Test {@link TypeValue#compareTo(TypeValue)} with {@code TypeValue}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link TypeValue#compareTo(TypeValue)}
   */
  @Test
  @DisplayName("Test compareTo(TypeValue) with 'TypeValue'; when 'null'; then return one")
  @Tag("MaintainedByDiffblue")
  void testCompareToWithTypeValue_whenNull_thenReturnOne() {
    // Arrange, Act and Assert
    assertEquals(1, new TypeValue("Type", "42").compareTo(null));
  }
}
