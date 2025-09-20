package uk.gov.gchq.gaffer.data;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.data.element.Edge;
import uk.gov.gchq.gaffer.data.element.Element;

class IsEdgeValidatorDiffblueTest {
  /**
   * Test {@link IsEdgeValidator#validate(Element)} with {@code Element}.
   *
   * <ul>
   *   <li>When {@link Edge#Edge(String)} with {@code Group}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link IsEdgeValidator#validate(Element)}
   */
  @Test
  @DisplayName(
      "Test validate(Element) with 'Element'; when Edge(String) with 'Group'; then return 'true'")
  @Tag("MaintainedByDiffblue")
  void testValidateWithElement_whenEdgeWithGroup_thenReturnTrue() {
    // Arrange
    IsEdgeValidator isEdgeValidator = new IsEdgeValidator();

    // Act
    boolean actualValidateResult = isEdgeValidator.validate(new Edge("Group"));

    // Assert
    assertTrue(actualValidateResult);
  }

  /**
   * Test {@link IsEdgeValidator#validate(Element)} with {@code Element}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link IsEdgeValidator#validate(Element)}
   */
  @Test
  @DisplayName("Test validate(Element) with 'Element'; when 'null'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  void testValidateWithElement_whenNull_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new IsEdgeValidator().validate(null));
  }
}
