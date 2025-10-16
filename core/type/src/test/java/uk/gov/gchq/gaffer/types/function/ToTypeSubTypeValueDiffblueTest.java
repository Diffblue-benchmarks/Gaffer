package uk.gov.gchq.gaffer.types.function;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.types.TypeSubTypeValue;

class ToTypeSubTypeValueDiffblueTest {
  /**
   * Test {@link ToTypeSubTypeValue#ToTypeSubTypeValue()}.
   *
   * <p>Method under test: {@link ToTypeSubTypeValue#ToTypeSubTypeValue()}
   */
  @Test
  @DisplayName("Test new ToTypeSubTypeValue()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ToTypeSubTypeValue.<init>()"})
  void testNewToTypeSubTypeValue() {
    // Arrange and Act
    ToTypeSubTypeValue actualToTypeSubTypeValue = new ToTypeSubTypeValue();

    // Assert
    assertNull(actualToTypeSubTypeValue.getSubType());
    assertNull(actualToTypeSubTypeValue.getType());
  }

  /**
   * Test {@link ToTypeSubTypeValue#ToTypeSubTypeValue(String, String)}.
   *
   * <p>Method under test: {@link ToTypeSubTypeValue#ToTypeSubTypeValue(String, String)}
   */
  @Test
  @DisplayName("Test new ToTypeSubTypeValue(String, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ToTypeSubTypeValue.<init>(String, String)"})
  void testNewToTypeSubTypeValue2() {
    // Arrange and Act
    ToTypeSubTypeValue actualToTypeSubTypeValue = new ToTypeSubTypeValue("Type", "Sub Type");

    // Assert
    assertEquals("Sub Type", actualToTypeSubTypeValue.getSubType());
    assertEquals("Type", actualToTypeSubTypeValue.getType());
  }

  /**
   * Test {@link ToTypeSubTypeValue#apply(Object)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return Value is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ToTypeSubTypeValue#apply(Object)}
   */
  @Test
  @DisplayName("Test apply(Object); when 'null'; then return Value is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TypeSubTypeValue ToTypeSubTypeValue.apply(Object)"})
  void testApply_whenNull_thenReturnValueIsNull() {
    // Arrange and Act
    TypeSubTypeValue actualApplyResult = new ToTypeSubTypeValue().apply(null);

    // Assert
    assertNull(actualApplyResult.getSubType());
    assertNull(actualApplyResult.getType());
    assertNull(actualApplyResult.getValue());
  }

  /**
   * Test {@link ToTypeSubTypeValue#apply(Object)}.
   *
   * <ul>
   *   <li>When {@code Value}.
   *   <li>Then return {@code Value}.
   * </ul>
   *
   * <p>Method under test: {@link ToTypeSubTypeValue#apply(Object)}
   */
  @Test
  @DisplayName("Test apply(Object); when 'Value'; then return 'Value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TypeSubTypeValue ToTypeSubTypeValue.apply(Object)"})
  void testApply_whenValue_thenReturnValue() {
    // Arrange and Act
    TypeSubTypeValue actualApplyResult = new ToTypeSubTypeValue().apply("Value");

    // Assert
    assertEquals("Value", actualApplyResult.getValue());
    assertNull(actualApplyResult.getSubType());
    assertNull(actualApplyResult.getType());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ToTypeSubTypeValue#setSubType(String)}
   *   <li>{@link ToTypeSubTypeValue#setType(String)}
   *   <li>{@link ToTypeSubTypeValue#getSubType()}
   *   <li>{@link ToTypeSubTypeValue#getType()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String ToTypeSubTypeValue.getSubType()",
    "String ToTypeSubTypeValue.getType()",
    "void ToTypeSubTypeValue.setSubType(String)",
    "void ToTypeSubTypeValue.setType(String)"
  })
  void testGettersAndSetters() {
    // Arrange
    ToTypeSubTypeValue toTypeSubTypeValue = new ToTypeSubTypeValue();

    // Act
    toTypeSubTypeValue.setSubType("Sub Type");
    toTypeSubTypeValue.setType("Type");
    String actualSubType = toTypeSubTypeValue.getSubType();

    // Assert
    assertEquals("Sub Type", actualSubType);
    assertEquals("Type", toTypeSubTypeValue.getType());
  }
}
