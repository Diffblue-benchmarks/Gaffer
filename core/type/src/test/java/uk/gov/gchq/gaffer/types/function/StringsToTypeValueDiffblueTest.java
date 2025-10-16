package uk.gov.gchq.gaffer.types.function;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.types.TypeValue;

class StringsToTypeValueDiffblueTest {
  /**
   * Test {@link StringsToTypeValue#apply(String, String)} with {@code type}, {@code value}.
   *
   * <p>Method under test: {@link StringsToTypeValue#apply(String, String)}
   */
  @Test
  @DisplayName("Test apply(String, String) with 'type', 'value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TypeValue StringsToTypeValue.apply(String, String)"})
  void testApplyWithTypeValue() {
    // Arrange and Act
    TypeValue actualApplyResult = new StringsToTypeValue().apply("Type", "42");

    // Assert
    assertEquals("42", actualApplyResult.getValue());
    assertEquals("Type", actualApplyResult.getType());
  }
}
