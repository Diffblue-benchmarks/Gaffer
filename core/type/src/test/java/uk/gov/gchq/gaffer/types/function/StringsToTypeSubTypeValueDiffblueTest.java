package uk.gov.gchq.gaffer.types.function;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.types.TypeSubTypeValue;

class StringsToTypeSubTypeValueDiffblueTest {
  /**
   * Test {@link StringsToTypeSubTypeValue#apply(String, String, String)} with {@code type}, {@code
   * subType}, {@code value}.
   *
   * <p>Method under test: {@link StringsToTypeSubTypeValue#apply(String, String, String)}
   */
  @Test
  @DisplayName("Test apply(String, String, String) with 'type', 'subType', 'value'")
  @Tag("MaintainedByDiffblue")
  void testApplyWithTypeSubTypeValue() {
    // Arrange and Act
    TypeSubTypeValue actualApplyResult =
        new StringsToTypeSubTypeValue().apply("Type", "Sub Type", "42");

    // Assert
    assertEquals("42", actualApplyResult.getValue());
    assertEquals("Sub Type", actualApplyResult.getSubType());
    assertEquals("Type", actualApplyResult.getType());
  }
}
