package uk.gov.gchq.gaffer.data.element.function;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.data.element.Entity;
import uk.gov.gchq.gaffer.data.element.Entity.Builder;

class UnwrapEntityIdDiffblueTest {
  /**
   * Test {@link UnwrapEntityId#apply(Object)}.
   *
   * <ul>
   *   <li>When {@link Entity.Builder} (default constructor) group {@code Group} vertex {@code
   *       Vertex} build.
   *   <li>Then return {@code Vertex}.
   * </ul>
   *
   * <p>Method under test: {@link UnwrapEntityId#apply(Object)}
   */
  @Test
  @DisplayName(
      "Test apply(Object); when Builder (default constructor) group 'Group' vertex 'Vertex' build; then return 'Vertex'")
  @Tag("MaintainedByDiffblue")
  void testApply_whenBuilderGroupGroupVertexVertexBuild_thenReturnVertex() {
    // Arrange
    UnwrapEntityId unwrapEntityId = new UnwrapEntityId();

    // Act
    Object actualApplyResult =
        unwrapEntityId.apply(new Builder().group("Group").vertex("Vertex").build());

    // Assert
    assertEquals("Vertex", actualApplyResult);
  }

  /**
   * Test {@link UnwrapEntityId#apply(Object)}.
   *
   * <ul>
   *   <li>When {@code Item}.
   *   <li>Then return {@code Item}.
   * </ul>
   *
   * <p>Method under test: {@link UnwrapEntityId#apply(Object)}
   */
  @Test
  @DisplayName("Test apply(Object); when 'Item'; then return 'Item'")
  @Tag("MaintainedByDiffblue")
  void testApply_whenItem_thenReturnItem() {
    // Arrange, Act and Assert
    assertEquals("Item", new UnwrapEntityId().apply("Item"));
  }

  /**
   * Test {@link UnwrapEntityId#apply(Object)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link UnwrapEntityId#apply(Object)}
   */
  @Test
  @DisplayName("Test apply(Object); when 'null'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  void testApply_whenNull_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new UnwrapEntityId().apply(null));
  }
}
