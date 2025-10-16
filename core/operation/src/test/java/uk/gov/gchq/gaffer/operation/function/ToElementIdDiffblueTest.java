package uk.gov.gchq.gaffer.operation.function;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.data.element.Edge;
import uk.gov.gchq.gaffer.data.element.Edge.Builder;
import uk.gov.gchq.gaffer.data.element.id.EdgeId;
import uk.gov.gchq.gaffer.data.element.id.EdgeId.MatchedVertex;
import uk.gov.gchq.gaffer.data.element.id.ElementId;
import uk.gov.gchq.gaffer.operation.data.EntitySeed;

class ToElementIdDiffblueTest {
  /**
   * Test {@link ToElementId#apply(Object)}.
   *
   * <p>Method under test: {@link ToElementId#apply(Object)}
   */
  @Test
  @DisplayName("Test apply(Object)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ElementId ToElementId.apply(Object)"})
  void testApply() {
    // Arrange
    ToElementId toElementId = new ToElementId();
    Edge edge =
        new Builder()
            .dest("Dest")
            .directed(true)
            .group("Group")
            .matchedVertex(MatchedVertex.SOURCE)
            .source("Source")
            .build();

    // Act
    ElementId actualApplyResult = toElementId.apply(edge);

    // Assert
    assertSame(edge, actualApplyResult);
  }

  /**
   * Test {@link ToElementId#apply(Object)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ToElementId#apply(Object)}
   */
  @Test
  @DisplayName("Test apply(Object); when 'null'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ElementId ToElementId.apply(Object)"})
  void testApply_whenNull_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new ToElementId().apply(null));
  }

  /**
   * Test {@link ToElementId#apply(Object)}.
   *
   * <ul>
   *   <li>When {@code Obj}.
   *   <li>Then return {@link EntitySeed}.
   * </ul>
   *
   * <p>Method under test: {@link ToElementId#apply(Object)}
   */
  @Test
  @DisplayName("Test apply(Object); when 'Obj'; then return EntitySeed")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ElementId ToElementId.apply(Object)"})
  void testApply_whenObj_thenReturnEntitySeed() {
    // Arrange and Act
    ElementId actualApplyResult = new ToElementId().apply("Obj");

    // Assert
    assertTrue(actualApplyResult instanceof EntitySeed);
    assertEquals("Obj", ((EntitySeed) actualApplyResult).getVertex());
    assertEquals("uk.gov.gchq.gaffer.operation.data.EntitySeed", actualApplyResult.getClassName());
  }
}
