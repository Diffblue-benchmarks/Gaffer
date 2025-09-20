package uk.gov.gchq.gaffer.types.function;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.types.TypeValue;

class ToTypeValueDiffblueTest {
  /**
   * Test {@link ToTypeValue#ToTypeValue()}.
   *
   * <p>Method under test: {@link ToTypeValue#ToTypeValue()}
   */
  @Test
  @DisplayName("Test new ToTypeValue()")
  @Tag("MaintainedByDiffblue")
  void testNewToTypeValue() {
    // Arrange, Act and Assert
    assertNull(new ToTypeValue().getType());
  }

  /**
   * Test {@link ToTypeValue#ToTypeValue(String)}.
   *
   * <p>Method under test: {@link ToTypeValue#ToTypeValue(String)}
   */
  @Test
  @DisplayName("Test new ToTypeValue(String)")
  @Tag("MaintainedByDiffblue")
  void testNewToTypeValue2() {
    // Arrange, Act and Assert
    assertEquals("Type", new ToTypeValue("Type").getType());
  }

  /**
   * Test {@link ToTypeValue#apply(Object)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return Value is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ToTypeValue#apply(Object)}
   */
  @Test
  @DisplayName("Test apply(Object); when 'null'; then return Value is 'null'")
  @Tag("MaintainedByDiffblue")
  void testApply_whenNull_thenReturnValueIsNull() {
    // Arrange and Act
    TypeValue actualApplyResult = new ToTypeValue().apply(null);

    // Assert
    assertNull(actualApplyResult.getType());
    assertNull(actualApplyResult.getValue());
  }

  /**
   * Test {@link ToTypeValue#apply(Object)}.
   *
   * <ul>
   *   <li>When {@code Value}.
   *   <li>Then return {@code Value}.
   * </ul>
   *
   * <p>Method under test: {@link ToTypeValue#apply(Object)}
   */
  @Test
  @DisplayName("Test apply(Object); when 'Value'; then return 'Value'")
  @Tag("MaintainedByDiffblue")
  void testApply_whenValue_thenReturnValue() {
    // Arrange and Act
    TypeValue actualApplyResult = new ToTypeValue().apply("Value");

    // Assert
    assertEquals("Value", actualApplyResult.getValue());
    assertNull(actualApplyResult.getType());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ToTypeValue#setType(String)}
   *   <li>{@link ToTypeValue#getType()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  void testGettersAndSetters() {
    // Arrange
    ToTypeValue toTypeValue = new ToTypeValue();

    // Act
    toTypeValue.setType("Type");

    // Assert
    assertEquals("Type", toTypeValue.getType());
  }
}
