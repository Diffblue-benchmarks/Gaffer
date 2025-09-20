package uk.gov.gchq.gaffer.data;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.data.element.Edge;

class IsElementValidatorDiffblueTest {
  /**
   * Test {@link IsElementValidator#validate(Object)}.
   *
   * <ul>
   *   <li>When {@link Edge#Edge(String)} with {@code Group}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link IsElementValidator#validate(Object)}
   */
  @Test
  @DisplayName("Test validate(Object); when Edge(String) with 'Group'; then return 'true'")
  @Tag("MaintainedByDiffblue")
  void testValidate_whenEdgeWithGroup_thenReturnTrue() {
    // Arrange
    IsElementValidator isElementValidator = new IsElementValidator();

    // Act
    boolean actualValidateResult = isElementValidator.validate(new Edge("Group"));

    // Assert
    assertTrue(actualValidateResult);
  }

  /**
   * Test {@link IsElementValidator#validate(Object)}.
   *
   * <ul>
   *   <li>When {@code Object}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link IsElementValidator#validate(Object)}
   */
  @Test
  @DisplayName("Test validate(Object); when 'Object'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  void testValidate_whenObject_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new IsElementValidator().validate("Object"));
  }
}
