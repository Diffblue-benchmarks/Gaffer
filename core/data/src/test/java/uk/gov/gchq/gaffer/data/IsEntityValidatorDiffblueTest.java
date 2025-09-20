package uk.gov.gchq.gaffer.data;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.data.element.Edge;
import uk.gov.gchq.gaffer.data.element.Element;
import uk.gov.gchq.gaffer.data.element.Entity;

class IsEntityValidatorDiffblueTest {
  /**
   * Test {@link IsEntityValidator#validate(Element)} with {@code Element}.
   *
   * <ul>
   *   <li>When {@link Edge#Edge(String)} with {@code Group}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link IsEntityValidator#validate(Element)}
   */
  @Test
  @DisplayName(
      "Test validate(Element) with 'Element'; when Edge(String) with 'Group'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  void testValidateWithElement_whenEdgeWithGroup_thenReturnFalse() {
    // Arrange
    IsEntityValidator isEntityValidator = new IsEntityValidator();

    // Act
    boolean actualValidateResult = isEntityValidator.validate(new Edge("Group"));

    // Assert
    assertFalse(actualValidateResult);
  }

  /**
   * Test {@link IsEntityValidator#validate(Element)} with {@code Element}.
   *
   * <ul>
   *   <li>When {@link Entity#Entity(String)} with {@code Group}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link IsEntityValidator#validate(Element)}
   */
  @Test
  @DisplayName(
      "Test validate(Element) with 'Element'; when Entity(String) with 'Group'; then return 'true'")
  @Tag("MaintainedByDiffblue")
  void testValidateWithElement_whenEntityWithGroup_thenReturnTrue() {
    // Arrange
    IsEntityValidator isEntityValidator = new IsEntityValidator();

    // Act
    boolean actualValidateResult = isEntityValidator.validate(new Entity("Group"));

    // Assert
    assertTrue(actualValidateResult);
  }
}
