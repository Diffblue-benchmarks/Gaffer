package uk.gov.gchq.gaffer.rest.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.data.element.Edge;
import uk.gov.gchq.gaffer.data.element.Element;
import uk.gov.gchq.gaffer.data.element.Entity;

class ExampleDomainObjectGeneratorDiffblueTest {
  /**
   * Test {@link ExampleDomainObjectGenerator#_apply(Element)}.
   *
   * <ul>
   *   <li>When {@link Edge#Edge(String)} with {@code Group}.
   *   <li>Then return second element is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ExampleDomainObjectGenerator#_apply(Element)}
   */
  @Test
  @DisplayName(
      "Test _apply(Element); when Edge(String) with 'Group'; then return second element is 'null'")
  @Tag("MaintainedByDiffblue")
  void test_apply_whenEdgeWithGroup_thenReturnSecondElementIsNull() {
    // Arrange
    ExampleDomainObjectGenerator exampleDomainObjectGenerator = new ExampleDomainObjectGenerator();

    // Act and Assert
    Object[] ids = exampleDomainObjectGenerator._apply(new Edge("Group")).getIds();
    assertNull(ids[1]);
    assertEquals(3, ids.length);
    assertFalse((Boolean) ids[2]);
  }

  /**
   * Test {@link ExampleDomainObjectGenerator#_apply(Element)}.
   *
   * <ul>
   *   <li>When {@link Entity#Entity(String)} with {@code Group}.
   *   <li>Then return Type is {@code Group}.
   * </ul>
   *
   * <p>Method under test: {@link ExampleDomainObjectGenerator#_apply(Element)}
   */
  @Test
  @DisplayName(
      "Test _apply(Element); when Entity(String) with 'Group'; then return Type is 'Group'")
  @Tag("MaintainedByDiffblue")
  void test_apply_whenEntityWithGroup_thenReturnTypeIsGroup() {
    // Arrange
    ExampleDomainObjectGenerator exampleDomainObjectGenerator = new ExampleDomainObjectGenerator();

    // Act
    ExampleDomainObject actual_applyResult =
        exampleDomainObjectGenerator._apply(new Entity("Group"));

    // Assert
    assertEquals("Group", actual_applyResult.getType());
    Object[] ids = actual_applyResult.getIds();
    assertNull(ids[0]);
    assertEquals(1, ids.length);
  }
}
