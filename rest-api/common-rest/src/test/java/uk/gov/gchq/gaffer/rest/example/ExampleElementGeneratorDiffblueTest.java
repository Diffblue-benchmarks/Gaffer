package uk.gov.gchq.gaffer.rest.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.data.element.Edge;
import uk.gov.gchq.gaffer.data.element.Element;
import uk.gov.gchq.gaffer.data.element.Entity;
import uk.gov.gchq.gaffer.data.element.id.DirectedType;

class ExampleElementGeneratorDiffblueTest {
  /**
   * Test {@link ExampleElementGenerator#_apply(ExampleDomainObject)} with {@code
   * ExampleDomainObject}.
   *
   * <ul>
   *   <li>Then return Destination is {@code Ids}.
   * </ul>
   *
   * <p>Method under test: {@link ExampleElementGenerator#_apply(ExampleDomainObject)}
   */
  @Test
  @DisplayName(
      "Test _apply(ExampleDomainObject) with 'ExampleDomainObject'; then return Destination is 'Ids'")
  @Tag("MaintainedByDiffblue")
  void test_applyWithExampleDomainObject_thenReturnDestinationIsIds() {
    // Arrange
    ExampleElementGenerator exampleElementGenerator = new ExampleElementGenerator();
    ExampleDomainObject obj = new ExampleDomainObject("Type", "Ids", "Ids");

    // Act
    Element actual_applyResult = exampleElementGenerator._apply(obj);

    // Assert
    assertTrue(actual_applyResult instanceof Edge);
    assertEquals("Ids", ((Edge) actual_applyResult).getDestination());
    assertEquals("Ids", ((Edge) actual_applyResult).getAdjacentMatchedVertexValue());
    assertEquals(DirectedType.UNDIRECTED, ((Edge) actual_applyResult).getDirectedType());
    assertFalse(((Edge) actual_applyResult).isDirected());
    assertTrue(((Edge) actual_applyResult).isUndirected());
  }

  /**
   * Test {@link ExampleElementGenerator#_apply(ExampleDomainObject)} with {@code
   * ExampleDomainObject}.
   *
   * <ul>
   *   <li>Then return Destination is {@code Ids}.
   * </ul>
   *
   * <p>Method under test: {@link ExampleElementGenerator#_apply(ExampleDomainObject)}
   */
  @Test
  @DisplayName(
      "Test _apply(ExampleDomainObject) with 'ExampleDomainObject'; then return Destination is 'Ids'")
  @Tag("MaintainedByDiffblue")
  void test_applyWithExampleDomainObject_thenReturnDestinationIsIds2() {
    // Arrange
    ExampleElementGenerator exampleElementGenerator = new ExampleElementGenerator();
    ExampleDomainObject obj = new ExampleDomainObject("Type", "Ids", "Ids", "Ids");

    // Act
    Element actual_applyResult = exampleElementGenerator._apply(obj);

    // Assert
    assertTrue(actual_applyResult instanceof Edge);
    assertEquals("Ids", ((Edge) actual_applyResult).getDestination());
    assertEquals("Ids", ((Edge) actual_applyResult).getAdjacentMatchedVertexValue());
    assertEquals(DirectedType.UNDIRECTED, ((Edge) actual_applyResult).getDirectedType());
    assertFalse(((Edge) actual_applyResult).isDirected());
    assertTrue(((Edge) actual_applyResult).isUndirected());
  }

  /**
   * Test {@link ExampleElementGenerator#_apply(ExampleDomainObject)} with {@code
   * ExampleDomainObject}.
   *
   * <ul>
   *   <li>Then return Destination is {@code UNKNOWN}.
   * </ul>
   *
   * <p>Method under test: {@link ExampleElementGenerator#_apply(ExampleDomainObject)}
   */
  @Test
  @DisplayName(
      "Test _apply(ExampleDomainObject) with 'ExampleDomainObject'; then return Destination is 'UNKNOWN'")
  @Tag("MaintainedByDiffblue")
  void test_applyWithExampleDomainObject_thenReturnDestinationIsUnknown() {
    // Arrange
    ExampleElementGenerator exampleElementGenerator = new ExampleElementGenerator();
    ExampleDomainObject obj = new ExampleDomainObject("Type", "UNKNOWN", "Ids");

    // Act
    Element actual_applyResult = exampleElementGenerator._apply(obj);

    // Assert
    assertTrue(actual_applyResult instanceof Edge);
    assertEquals("UNKNOWN", ((Edge) actual_applyResult).getDestination());
    assertEquals("UNKNOWN", ((Edge) actual_applyResult).getAdjacentMatchedVertexValue());
    assertEquals(DirectedType.UNDIRECTED, ((Edge) actual_applyResult).getDirectedType());
    assertFalse(((Edge) actual_applyResult).isDirected());
    assertTrue(((Edge) actual_applyResult).isUndirected());
  }

  /**
   * Test {@link ExampleElementGenerator#_apply(ExampleDomainObject)} with {@code
   * ExampleDomainObject}.
   *
   * <ul>
   *   <li>Then return DirectedType is {@code DIRECTED}.
   * </ul>
   *
   * <p>Method under test: {@link ExampleElementGenerator#_apply(ExampleDomainObject)}
   */
  @Test
  @DisplayName(
      "Test _apply(ExampleDomainObject) with 'ExampleDomainObject'; then return DirectedType is 'DIRECTED'")
  @Tag("MaintainedByDiffblue")
  void test_applyWithExampleDomainObject_thenReturnDirectedTypeIsDirected() {
    // Arrange
    ExampleElementGenerator exampleElementGenerator = new ExampleElementGenerator();
    ExampleDomainObject obj = new ExampleDomainObject("Type", "Ids", "Ids", true);

    // Act
    Element actual_applyResult = exampleElementGenerator._apply(obj);

    // Assert
    assertTrue(actual_applyResult instanceof Edge);
    assertEquals("Ids", ((Edge) actual_applyResult).getDestination());
    assertEquals("Ids", ((Edge) actual_applyResult).getAdjacentMatchedVertexValue());
    assertEquals(DirectedType.DIRECTED, ((Edge) actual_applyResult).getDirectedType());
    assertFalse(((Edge) actual_applyResult).isUndirected());
    assertTrue(((Edge) actual_applyResult).isDirected());
  }

  /**
   * Test {@link ExampleElementGenerator#_apply(ExampleDomainObject)} with {@code
   * ExampleDomainObject}.
   *
   * <ul>
   *   <li>Then return {@link Entity}.
   * </ul>
   *
   * <p>Method under test: {@link ExampleElementGenerator#_apply(ExampleDomainObject)}
   */
  @Test
  @DisplayName("Test _apply(ExampleDomainObject) with 'ExampleDomainObject'; then return Entity")
  @Tag("MaintainedByDiffblue")
  void test_applyWithExampleDomainObject_thenReturnEntity() {
    // Arrange
    ExampleElementGenerator exampleElementGenerator = new ExampleElementGenerator();

    // Act
    Element actual_applyResult =
        exampleElementGenerator._apply(new ExampleDomainObject("Type", "Ids"));

    // Assert
    assertTrue(actual_applyResult instanceof Entity);
    assertEquals("Ids", ((Entity) actual_applyResult).getVertex());
    assertEquals("uk.gov.gchq.gaffer.data.element.Entity", actual_applyResult.getClassName());
  }
}
