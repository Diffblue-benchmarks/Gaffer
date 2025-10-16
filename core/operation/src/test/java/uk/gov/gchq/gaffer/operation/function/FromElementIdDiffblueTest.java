package uk.gov.gchq.gaffer.operation.function;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.data.element.Entity;
import uk.gov.gchq.gaffer.data.element.Entity.Builder;
import uk.gov.gchq.gaffer.data.element.id.ElementId;
import uk.gov.gchq.gaffer.operation.data.EdgeSeed;

class FromElementIdDiffblueTest {
  /**
   * Test {@link FromElementId#apply(ElementId)} with {@code ElementId}.
   *
   * <ul>
   *   <li>When {@link Entity.Builder} (default constructor) group {@code Group} vertex {@code
   *       Vertex} build.
   *   <li>Then return {@code Vertex}.
   * </ul>
   *
   * <p>Method under test: {@link FromElementId#apply(ElementId)}
   */
  @Test
  @DisplayName(
      "Test apply(ElementId) with 'ElementId'; when Builder (default constructor) group 'Group' vertex 'Vertex' build; then return 'Vertex'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object FromElementId.apply(ElementId)"})
  void testApplyWithElementId_whenBuilderGroupGroupVertexVertexBuild_thenReturnVertex() {
    // Arrange
    FromElementId fromElementId = new FromElementId();

    // Act
    Object actualApplyResult =
        fromElementId.apply(new Builder().group("Group").vertex("Vertex").build());

    // Assert
    assertEquals("Vertex", actualApplyResult);
  }

  /**
   * Test {@link FromElementId#apply(ElementId)} with {@code ElementId}.
   *
   * <ul>
   *   <li>When {@link EdgeSeed#EdgeSeed()}.
   *   <li>Then return {@link EdgeSeed#EdgeSeed()}.
   * </ul>
   *
   * <p>Method under test: {@link FromElementId#apply(ElementId)}
   */
  @Test
  @DisplayName("Test apply(ElementId) with 'ElementId'; when EdgeSeed(); then return EdgeSeed()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object FromElementId.apply(ElementId)"})
  void testApplyWithElementId_whenEdgeSeed_thenReturnEdgeSeed() {
    // Arrange
    FromElementId fromElementId = new FromElementId();
    EdgeSeed e = new EdgeSeed();

    // Act
    Object actualApplyResult = fromElementId.apply(e);

    // Assert
    assertSame(e, actualApplyResult);
  }

  /**
   * Test {@link FromElementId#apply(ElementId)} with {@code ElementId}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link FromElementId#apply(ElementId)}
   */
  @Test
  @DisplayName("Test apply(ElementId) with 'ElementId'; when 'null'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object FromElementId.apply(ElementId)"})
  void testApplyWithElementId_whenNull_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new FromElementId().apply(null));
  }
}
