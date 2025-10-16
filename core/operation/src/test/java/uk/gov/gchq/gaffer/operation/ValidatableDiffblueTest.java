package uk.gov.gchq.gaffer.operation;

import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.operation.impl.Validate;
import uk.gov.gchq.gaffer.operation.impl.Validate.Builder;

class ValidatableDiffblueTest {
  /**
   * Test Builder {@link
   * uk.gov.gchq.gaffer.operation.Validatable.Builder#skipInvalidElements(boolean)}.
   *
   * <p>Method under test: {@link
   * uk.gov.gchq.gaffer.operation.Validatable.Builder#skipInvalidElements(boolean)}
   */
  @Test
  @DisplayName("Test Builder skipInvalidElements(boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "uk.gov.gchq.gaffer.operation.Validatable.Builder uk.gov.gchq.gaffer.operation.Validatable.Builder.skipInvalidElements(boolean)"
  })
  void testBuilderSkipInvalidElements() {
    // Arrange
    Builder builder = new Builder();

    // Act
    Builder actualSkipInvalidElementsResult = builder.skipInvalidElements(true);

    // Assert
    assertSame(builder, actualSkipInvalidElementsResult);
  }

  /**
   * Test Builder {@link uk.gov.gchq.gaffer.operation.Validatable.Builder#validate(boolean)}.
   *
   * <p>Method under test: {@link
   * uk.gov.gchq.gaffer.operation.Validatable.Builder#validate(boolean)}
   */
  @Test
  @DisplayName("Test Builder validate(boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "uk.gov.gchq.gaffer.operation.Validatable.Builder uk.gov.gchq.gaffer.operation.Validatable.Builder.validate(boolean)"
  })
  void testBuilderValidate() {
    // Arrange
    Builder builder = new Builder();

    // Act
    Builder actualValidateResult = builder.validate(true);

    // Assert
    assertSame(builder, actualValidateResult);
  }
}
