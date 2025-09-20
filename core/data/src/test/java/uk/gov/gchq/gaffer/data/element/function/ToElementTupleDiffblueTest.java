package uk.gov.gchq.gaffer.data.element.function;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.data.element.Edge;
import uk.gov.gchq.gaffer.data.element.Element;

class ToElementTupleDiffblueTest {
  /**
   * Test {@link ToElementTuple#apply(Element)} with {@code Element}.
   *
   * <ul>
   *   <li>When {@link Edge#Edge(String)} with {@code Group}.
   *   <li>Then return Element is {@link Edge#Edge(String)} with {@code Group}.
   * </ul>
   *
   * <p>Method under test: {@link ToElementTuple#apply(Element)}
   */
  @Test
  @DisplayName(
      "Test apply(Element) with 'Element'; when Edge(String) with 'Group'; then return Element is Edge(String) with 'Group'")
  @Tag("MaintainedByDiffblue")
  void testApplyWithElement_whenEdgeWithGroup_thenReturnElementIsEdgeWithGroup() {
    // Arrange
    ToElementTuple toElementTuple = new ToElementTuple();
    Edge element = new Edge("Group");

    // Act and Assert
    assertSame(element, toElementTuple.apply(element).getElement());
  }

  /**
   * Test {@link ToElementTuple#apply(Element)} with {@code Element}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ToElementTuple#apply(Element)}
   */
  @Test
  @DisplayName("Test apply(Element) with 'Element'; when 'null'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  void testApplyWithElement_whenNull_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new ToElementTuple().apply(null));
  }
}
