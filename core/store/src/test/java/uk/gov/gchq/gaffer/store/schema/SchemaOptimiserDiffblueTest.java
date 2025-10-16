package uk.gov.gchq.gaffer.store.schema;

import static org.junit.jupiter.api.Assertions.assertNull;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class SchemaOptimiserDiffblueTest {
  /**
   * Test {@link SchemaOptimiser#SchemaOptimiser()}.
   *
   * <p>Method under test: {@link SchemaOptimiser#SchemaOptimiser()}
   */
  @Test
  @DisplayName("Test new SchemaOptimiser()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SchemaOptimiser.<init>()"})
  void testNewSchemaOptimiser() {
    // Arrange, Act and Assert
    assertNull(new SchemaOptimiser().optimise(null, true));
  }

  /**
   * Test {@link SchemaOptimiser#optimise(Schema, boolean)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link SchemaOptimiser#optimise(Schema, boolean)}
   */
  @Test
  @DisplayName("Test optimise(Schema, boolean); when 'null'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Schema SchemaOptimiser.optimise(Schema, boolean)"})
  void testOptimise_whenNull_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new SchemaOptimiser().optimise(null, false));
  }

  /**
   * Test {@link SchemaOptimiser#getDefaultVertexSerialiser(Schema, boolean)}.
   *
   * <ul>
   *   <li>When {@link Schema#Schema()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link SchemaOptimiser#getDefaultVertexSerialiser(Schema, boolean)}
   */
  @Test
  @DisplayName(
      "Test getDefaultVertexSerialiser(Schema, boolean); when Schema(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "uk.gov.gchq.gaffer.serialisation.Serialiser SchemaOptimiser.getDefaultVertexSerialiser(Schema, boolean)"
  })
  void testGetDefaultVertexSerialiser_whenSchema_thenReturnNull() {
    // Arrange
    SchemaOptimiser schemaOptimiser = new SchemaOptimiser();

    // Act and Assert
    assertNull(schemaOptimiser.getDefaultVertexSerialiser(new Schema(), true));
  }
}
