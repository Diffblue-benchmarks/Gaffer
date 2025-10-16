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
import uk.gov.gchq.gaffer.data.element.Entity;
import uk.gov.gchq.gaffer.data.element.Entity.Builder;
import uk.gov.gchq.gaffer.data.element.id.EntityId;
import uk.gov.gchq.gaffer.operation.data.EntitySeed;

class ToEntityIdDiffblueTest {
  /**
   * Test {@link ToEntityId#apply(Object)}.
   *
   * <ul>
   *   <li>Then return {@link Entity.Builder} (default constructor) group {@code Group} vertex
   *       {@code Vertex} build.
   * </ul>
   *
   * <p>Method under test: {@link ToEntityId#apply(Object)}
   */
  @Test
  @DisplayName(
      "Test apply(Object); then return Builder (default constructor) group 'Group' vertex 'Vertex' build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityId ToEntityId.apply(Object)"})
  void testApply_thenReturnBuilderGroupGroupVertexVertexBuild() {
    // Arrange
    ToEntityId toEntityId = new ToEntityId();
    Entity entity = new Builder().group("Group").vertex("Vertex").build();

    // Act
    EntityId actualApplyResult = toEntityId.apply(entity);

    // Assert
    assertSame(entity, actualApplyResult);
  }

  /**
   * Test {@link ToEntityId#apply(Object)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ToEntityId#apply(Object)}
   */
  @Test
  @DisplayName("Test apply(Object); when 'null'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityId ToEntityId.apply(Object)"})
  void testApply_whenNull_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new ToEntityId().apply(null));
  }

  /**
   * Test {@link ToEntityId#apply(Object)}.
   *
   * <ul>
   *   <li>When {@code Obj}.
   *   <li>Then return {@link EntitySeed}.
   * </ul>
   *
   * <p>Method under test: {@link ToEntityId#apply(Object)}
   */
  @Test
  @DisplayName("Test apply(Object); when 'Obj'; then return EntitySeed")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityId ToEntityId.apply(Object)"})
  void testApply_whenObj_thenReturnEntitySeed() {
    // Arrange and Act
    EntityId actualApplyResult = new ToEntityId().apply("Obj");

    // Assert
    assertTrue(actualApplyResult instanceof EntitySeed);
    assertEquals("Obj", actualApplyResult.getVertex());
    assertEquals("uk.gov.gchq.gaffer.operation.data.EntitySeed", actualApplyResult.getClassName());
  }
}
