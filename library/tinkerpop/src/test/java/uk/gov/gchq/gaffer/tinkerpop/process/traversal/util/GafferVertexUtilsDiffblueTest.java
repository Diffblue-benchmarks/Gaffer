package uk.gov.gchq.gaffer.tinkerpop.process.traversal.util;

import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import org.apache.tinkerpop.gremlin.structure.Vertex;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.data.element.Edge;
import uk.gov.gchq.gaffer.data.element.Edge.Builder;
import uk.gov.gchq.gaffer.data.element.Element;
import uk.gov.gchq.gaffer.data.element.id.EdgeId;
import uk.gov.gchq.gaffer.data.element.id.EdgeId.MatchedVertex;
import uk.gov.gchq.gaffer.tinkerpop.GafferPopGraph;

class GafferVertexUtilsDiffblueTest {
  /**
   * Test {@link GafferVertexUtils#getOrphanVertices(Iterable, GafferPopGraph, Object[])}.
   *
   * <p>Method under test: {@link GafferVertexUtils#getOrphanVertices(Iterable, GafferPopGraph,
   * Object[])}
   */
  @Test
  @DisplayName("Test getOrphanVertices(Iterable, GafferPopGraph, Object[])")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Collection GafferVertexUtils.getOrphanVertices(Iterable, GafferPopGraph, Object[])"
  })
  void testGetOrphanVertices() {
    // Arrange
    ArrayList<Element> result = new ArrayList<>();
    result.add(
        new Builder()
            .dest("Dest")
            .directed(true)
            .group("Group")
            .matchedVertex(MatchedVertex.SOURCE)
            .source("Source")
            .build());

    // Act
    Collection<Vertex> actualOrphanVertices =
        GafferVertexUtils.getOrphanVertices(result, null, "Vertex Ids");

    // Assert
    assertTrue(actualOrphanVertices instanceof Set);
    assertTrue(actualOrphanVertices.isEmpty());
  }

  /**
   * Test {@link GafferVertexUtils#getOrphanVertices(Iterable, GafferPopGraph, Object[])}.
   *
   * <p>Method under test: {@link GafferVertexUtils#getOrphanVertices(Iterable, GafferPopGraph,
   * Object[])}
   */
  @Test
  @DisplayName("Test getOrphanVertices(Iterable, GafferPopGraph, Object[])")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Collection GafferVertexUtils.getOrphanVertices(Iterable, GafferPopGraph, Object[])"
  })
  void testGetOrphanVertices2() {
    // Arrange
    ArrayList<Element> result = new ArrayList<>();
    result.add(
        new Builder()
            .dest("Dest")
            .directed(true)
            .group("Group")
            .matchedVertex(MatchedVertex.SOURCE)
            .source("Source")
            .build());
    result.add(
        new Builder()
            .dest("Dest")
            .directed(true)
            .group("Group")
            .matchedVertex(MatchedVertex.SOURCE)
            .source("Source")
            .build());

    // Act
    Collection<Vertex> actualOrphanVertices =
        GafferVertexUtils.getOrphanVertices(result, null, "Vertex Ids");

    // Assert
    assertTrue(actualOrphanVertices instanceof Set);
    assertTrue(actualOrphanVertices.isEmpty());
  }

  /**
   * Test {@link GafferVertexUtils#getOrphanVertices(Iterable, GafferPopGraph, Object[])}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return {@link List}.
   * </ul>
   *
   * <p>Method under test: {@link GafferVertexUtils#getOrphanVertices(Iterable, GafferPopGraph,
   * Object[])}
   */
  @Test
  @DisplayName(
      "Test getOrphanVertices(Iterable, GafferPopGraph, Object[]); when ArrayList(); then return List")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Collection GafferVertexUtils.getOrphanVertices(Iterable, GafferPopGraph, Object[])"
  })
  void testGetOrphanVertices_whenArrayList_thenReturnList() {
    // Arrange and Act
    Collection<Vertex> actualOrphanVertices =
        GafferVertexUtils.getOrphanVertices(new ArrayList<>(), null);

    // Assert
    assertTrue(actualOrphanVertices instanceof List);
    assertTrue(actualOrphanVertices.isEmpty());
  }

  /**
   * Test {@link GafferVertexUtils#getOrphanVertices(Iterable, GafferPopGraph, Object[])}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return {@link Set}.
   * </ul>
   *
   * <p>Method under test: {@link GafferVertexUtils#getOrphanVertices(Iterable, GafferPopGraph,
   * Object[])}
   */
  @Test
  @DisplayName(
      "Test getOrphanVertices(Iterable, GafferPopGraph, Object[]); when ArrayList(); then return Set")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Collection GafferVertexUtils.getOrphanVertices(Iterable, GafferPopGraph, Object[])"
  })
  void testGetOrphanVertices_whenArrayList_thenReturnSet() {
    // Arrange and Act
    Collection<Vertex> actualOrphanVertices =
        GafferVertexUtils.getOrphanVertices(new ArrayList<>(), null, "Vertex Ids");

    // Assert
    assertTrue(actualOrphanVertices instanceof Set);
    assertTrue(actualOrphanVertices.isEmpty());
  }

  /**
   * Test {@link GafferVertexUtils#getOrphanVertices(Iterable, GafferPopGraph, Object[])}.
   *
   * <ul>
   *   <li>When {@code Vertex Ids} and {@code Vertex Ids}.
   *   <li>Then return {@link Set}.
   * </ul>
   *
   * <p>Method under test: {@link GafferVertexUtils#getOrphanVertices(Iterable, GafferPopGraph,
   * Object[])}
   */
  @Test
  @DisplayName(
      "Test getOrphanVertices(Iterable, GafferPopGraph, Object[]); when 'Vertex Ids' and 'Vertex Ids'; then return Set")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Collection GafferVertexUtils.getOrphanVertices(Iterable, GafferPopGraph, Object[])"
  })
  void testGetOrphanVertices_whenVertexIdsAndVertexIds_thenReturnSet() {
    // Arrange and Act
    Collection<Vertex> actualOrphanVertices =
        GafferVertexUtils.getOrphanVertices(new ArrayList<>(), null, "Vertex Ids", "Vertex Ids");

    // Assert
    assertTrue(actualOrphanVertices instanceof Set);
    assertTrue(actualOrphanVertices.isEmpty());
  }
}
