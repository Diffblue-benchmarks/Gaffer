package uk.gov.gchq.gaffer.federatedstore.util;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ContextSpecificMergeFunctionDiffblueTest {
  /**
   * Test {@link ContextSpecificMergeFunction#isRequired(String)}.
   *
   * <ul>
   *   <li>When {@code Name}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ContextSpecificMergeFunction#isRequired(String)}
   */
  @Test
  @DisplayName("Test isRequired(String); when 'Name'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ContextSpecificMergeFunction.isRequired(String)"})
  void testIsRequired_whenName_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new ApplyViewToElementsFunction().isRequired("Name"));
  }

  /**
   * Test {@link ContextSpecificMergeFunction#isRequired(String)}.
   *
   * <ul>
   *   <li>When {@link ApplyViewToElementsFunction#VIEW}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link ContextSpecificMergeFunction#isRequired(String)}
   */
  @Test
  @DisplayName("Test isRequired(String); when VIEW; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ContextSpecificMergeFunction.isRequired(String)"})
  void testIsRequired_whenView_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(new ApplyViewToElementsFunction().isRequired(ApplyViewToElementsFunction.VIEW));
  }
}
