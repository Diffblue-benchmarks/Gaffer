package uk.gov.gchq.gaffer.federatedstore.util;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashMap;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.core.exception.GafferCheckedException;
import uk.gov.gchq.gaffer.store.schema.Schema;

class MergeSchemaDiffblueTest {
  /**
   * Test {@link MergeSchema#MergeSchema()}.
   *
   * <p>Method under test: {@link MergeSchema#MergeSchema()}
   */
  @Test
  @DisplayName("Test new MergeSchema()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MergeSchema.<init>()"})
  void testNewMergeSchema() {
    // Arrange, Act and Assert
    assertTrue(new MergeSchema().getRequiredContextValues().isEmpty());
  }

  /**
   * Test {@link MergeSchema#MergeSchema(HashMap)}.
   *
   * <p>Method under test: {@link MergeSchema#MergeSchema(HashMap)}
   */
  @Test
  @DisplayName("Test new MergeSchema(HashMap)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MergeSchema.<init>(HashMap)"})
  void testNewMergeSchema2() {
    // Arrange, Act and Assert
    assertTrue(new MergeSchema(new HashMap<>()).getRequiredContextValues().isEmpty());
  }

  /**
   * Test {@link MergeSchema#apply(Schema, Schema)} with {@code Schema}, {@code Schema}.
   *
   * <ul>
   *   <li>Given {@link MergeSchema#MergeSchema()}.
   *   <li>When {@code null}.
   *   <li>Then return {@link Schema#Schema()}.
   * </ul>
   *
   * <p>Method under test: {@link MergeSchema#apply(Schema, Schema)}
   */
  @Test
  @DisplayName(
      "Test apply(Schema, Schema) with 'Schema', 'Schema'; given MergeSchema(); when 'null'; then return Schema()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Schema MergeSchema.apply(Schema, Schema)"})
  void testApplyWithSchemaSchema_givenMergeSchema_whenNull_thenReturnSchema() {
    // Arrange
    MergeSchema mergeSchema = new MergeSchema();
    Schema update = new Schema();

    // Act
    Schema actualApplyResult = mergeSchema.apply(update, null);

    // Assert
    assertSame(update, actualApplyResult);
  }

  /**
   * Test {@link MergeSchema#createFunctionWithContext(HashMap)}.
   *
   * <p>Method under test: {@link MergeSchema#createFunctionWithContext(HashMap)}
   */
  @Test
  @DisplayName("Test createFunctionWithContext(HashMap)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ContextSpecificMergeFunction MergeSchema.createFunctionWithContext(HashMap)"})
  void testCreateFunctionWithContext() throws GafferCheckedException {
    // Arrange
    MergeSchema mergeSchema = new MergeSchema();

    // Act
    ContextSpecificMergeFunction<Schema, Schema, Schema> actualCreateFunctionWithContextResult =
        mergeSchema.createFunctionWithContext(new HashMap<>());

    // Assert
    assertTrue(actualCreateFunctionWithContextResult instanceof MergeSchema);
    assertTrue(actualCreateFunctionWithContextResult.getRequiredContextValues().isEmpty());
  }

  /**
   * Test {@link MergeSchema#getRequiredContextValues()}.
   *
   * <p>Method under test: {@link MergeSchema#getRequiredContextValues()}
   */
  @Test
  @DisplayName("Test getRequiredContextValues()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.Set MergeSchema.getRequiredContextValues()"})
  void testGetRequiredContextValues() {
    // Arrange, Act and Assert
    assertTrue(new MergeSchema().getRequiredContextValues().isEmpty());
  }
}
