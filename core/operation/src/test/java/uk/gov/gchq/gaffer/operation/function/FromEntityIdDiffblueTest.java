package uk.gov.gchq.gaffer.operation.function;

import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.data.element.id.EntityId;
import uk.gov.gchq.gaffer.operation.data.EntitySeed;

class FromEntityIdDiffblueTest {
  /**
   * Test {@link FromEntityId#apply(EntityId)} with {@code EntityId}.
   *
   * <ul>
   *   <li>When {@link EntitySeed#EntitySeed()}.
   * </ul>
   *
   * <p>Method under test: {@link FromEntityId#apply(EntityId)}
   */
  @Test
  @DisplayName("Test apply(EntityId) with 'EntityId'; when EntitySeed()")
  @Tag("MaintainedByDiffblue")
  void testApplyWithEntityId_whenEntitySeed() {
    // Arrange
    FromEntityId fromEntityId = new FromEntityId();

    // Act and Assert
    assertNull(fromEntityId.apply(new EntitySeed()));
  }

  /**
   * Test {@link FromEntityId#apply(EntityId)} with {@code EntityId}.
   *
   * <ul>
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link FromEntityId#apply(EntityId)}
   */
  @Test
  @DisplayName("Test apply(EntityId) with 'EntityId'; when 'null'")
  @Tag("MaintainedByDiffblue")
  void testApplyWithEntityId_whenNull() {
    // Arrange, Act and Assert
    assertNull(new FromEntityId().apply(null));
  }
}
