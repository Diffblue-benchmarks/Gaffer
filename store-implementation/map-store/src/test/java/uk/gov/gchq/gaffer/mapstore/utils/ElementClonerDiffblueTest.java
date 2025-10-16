package uk.gov.gchq.gaffer.mapstore.utils;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.data.element.Edge;
import uk.gov.gchq.gaffer.data.element.Element;
import uk.gov.gchq.gaffer.data.element.Entity;
import uk.gov.gchq.gaffer.data.element.Entity.Builder;
import uk.gov.gchq.gaffer.store.schema.Schema;

class ElementClonerDiffblueTest {
  /**
   * Test {@link ElementCloner#cloneElement(Element, Schema)}.
   *
   * <ul>
   *   <li>When {@link Entity.Builder} (default constructor) group {@code Group} vertex {@code
   *       Vertex} build.
   *   <li>Then return {@link Entity}.
   * </ul>
   *
   * <p>Method under test: {@link ElementCloner#cloneElement(Element, Schema)}
   */
  @Test
  @DisplayName(
      "Test cloneElement(Element, Schema); when Builder (default constructor) group 'Group' vertex 'Vertex' build; then return Entity")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Element ElementCloner.cloneElement(Element, Schema)"})
  void testCloneElement_whenBuilderGroupGroupVertexVertexBuild_thenReturnEntity() {
    // Arrange
    ElementCloner elementCloner = new ElementCloner();
    Entity element = new Builder().group("Group").vertex("Vertex").build();

    // Act
    Element actualCloneElementResult = elementCloner.cloneElement(element, new Schema());

    // Assert
    assertTrue(actualCloneElementResult instanceof Entity);
    assertEquals(element, actualCloneElementResult);
  }

  /**
   * Test {@link ElementCloner#cloneElement(Element, Schema)}.
   *
   * <ul>
   *   <li>When {@link Edge#Edge(String)} with {@code Group}.
   *   <li>Then return {@link Edge}.
   * </ul>
   *
   * <p>Method under test: {@link ElementCloner#cloneElement(Element, Schema)}
   */
  @Test
  @DisplayName(
      "Test cloneElement(Element, Schema); when Edge(String) with 'Group'; then return Edge")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Element ElementCloner.cloneElement(Element, Schema)"})
  void testCloneElement_whenEdgeWithGroup_thenReturnEdge() {
    // Arrange
    ElementCloner elementCloner = new ElementCloner();
    Edge element = new Edge("Group");

    // Act
    Element actualCloneElementResult = elementCloner.cloneElement(element, new Schema());

    // Assert
    assertTrue(actualCloneElementResult instanceof Edge);
    assertEquals(element, actualCloneElementResult);
  }
}
