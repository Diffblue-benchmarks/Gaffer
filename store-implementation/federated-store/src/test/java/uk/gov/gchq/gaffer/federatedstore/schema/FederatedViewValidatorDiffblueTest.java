package uk.gov.gchq.gaffer.federatedstore.schema;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.data.elementdefinition.view.View;
import uk.gov.gchq.gaffer.store.StoreTrait;
import uk.gov.gchq.gaffer.store.schema.Schema;
import uk.gov.gchq.koryphe.ValidationResult;

class FederatedViewValidatorDiffblueTest {
  /**
   * Test {@link FederatedViewValidator#validate(View, Schema, Set)}.
   *
   * <ul>
   *   <li>Given {@code INGEST_AGGREGATION}.
   *   <li>When {@link HashSet#HashSet()} add {@code INGEST_AGGREGATION}.
   * </ul>
   *
   * <p>Method under test: {@link FederatedViewValidator#validate(View, Schema, Set)}
   */
  @Test
  @DisplayName(
      "Test validate(View, Schema, Set); given 'INGEST_AGGREGATION'; when HashSet() add 'INGEST_AGGREGATION'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ValidationResult FederatedViewValidator.validate(View, Schema, Set)"})
  void testValidate_givenIngestAggregation_whenHashSetAddIngestAggregation() {
    // Arrange
    FederatedViewValidator federatedViewValidator = new FederatedViewValidator();
    View view = new View();
    Schema schema = new Schema();

    HashSet<StoreTrait> storeTraits = new HashSet<>();
    storeTraits.add(StoreTrait.INGEST_AGGREGATION);

    // Act
    ValidationResult actualValidateResult =
        federatedViewValidator.validate(view, schema, storeTraits);

    // Assert
    assertEquals("Validation errors: \n", actualValidateResult.getErrorString());
    assertTrue(actualValidateResult.getErrors().isEmpty());
    assertTrue(actualValidateResult.isValid());
  }

  /**
   * Test {@link FederatedViewValidator#validate(View, Schema, Set)}.
   *
   * <ul>
   *   <li>Given {@code QUERY_AGGREGATION}.
   *   <li>When {@link HashSet#HashSet()} add {@code QUERY_AGGREGATION}.
   * </ul>
   *
   * <p>Method under test: {@link FederatedViewValidator#validate(View, Schema, Set)}
   */
  @Test
  @DisplayName(
      "Test validate(View, Schema, Set); given 'QUERY_AGGREGATION'; when HashSet() add 'QUERY_AGGREGATION'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ValidationResult FederatedViewValidator.validate(View, Schema, Set)"})
  void testValidate_givenQueryAggregation_whenHashSetAddQueryAggregation() {
    // Arrange
    FederatedViewValidator federatedViewValidator = new FederatedViewValidator();
    View view = new View();
    Schema schema = new Schema();

    HashSet<StoreTrait> storeTraits = new HashSet<>();
    storeTraits.add(StoreTrait.QUERY_AGGREGATION);
    storeTraits.add(StoreTrait.INGEST_AGGREGATION);

    // Act
    ValidationResult actualValidateResult =
        federatedViewValidator.validate(view, schema, storeTraits);

    // Assert
    assertEquals("Validation errors: \n", actualValidateResult.getErrorString());
    assertTrue(actualValidateResult.getErrors().isEmpty());
    assertTrue(actualValidateResult.isValid());
  }

  /**
   * Test {@link FederatedViewValidator#validate(View, Schema, Set)}.
   *
   * <ul>
   *   <li>When {@link HashSet#HashSet()}.
   * </ul>
   *
   * <p>Method under test: {@link FederatedViewValidator#validate(View, Schema, Set)}
   */
  @Test
  @DisplayName("Test validate(View, Schema, Set); when HashSet()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ValidationResult FederatedViewValidator.validate(View, Schema, Set)"})
  void testValidate_whenHashSet() {
    // Arrange
    FederatedViewValidator federatedViewValidator = new FederatedViewValidator();
    View view = new View();
    Schema schema = new Schema();

    // Act
    ValidationResult actualValidateResult =
        federatedViewValidator.validate(view, schema, new HashSet<>());

    // Assert
    assertEquals("Validation errors: \n", actualValidateResult.getErrorString());
    assertTrue(actualValidateResult.getErrors().isEmpty());
    assertTrue(actualValidateResult.isValid());
  }

  /**
   * Test {@link FederatedViewValidator#validate(View, Schema, Set)}.
   *
   * <ul>
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link FederatedViewValidator#validate(View, Schema, Set)}
   */
  @Test
  @DisplayName("Test validate(View, Schema, Set); when 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ValidationResult FederatedViewValidator.validate(View, Schema, Set)"})
  void testValidate_whenNull() {
    // Arrange
    FederatedViewValidator federatedViewValidator = new FederatedViewValidator();
    Schema schema = new Schema();

    // Act
    ValidationResult actualValidateResult =
        federatedViewValidator.validate(null, schema, new HashSet<>());

    // Assert
    assertEquals("Validation errors: \n", actualValidateResult.getErrorString());
    assertTrue(actualValidateResult.getErrors().isEmpty());
    assertTrue(actualValidateResult.isValid());
  }

  /**
   * Test {@link FederatedViewValidator#getEdgeResult(View, Schema, Set, boolean)}.
   *
   * <ul>
   *   <li>Given {@code INGEST_AGGREGATION}.
   *   <li>When {@link HashSet#HashSet()} add {@code INGEST_AGGREGATION}.
   * </ul>
   *
   * <p>Method under test: {@link FederatedViewValidator#getEdgeResult(View, Schema, Set, boolean)}
   */
  @Test
  @DisplayName(
      "Test getEdgeResult(View, Schema, Set, boolean); given 'INGEST_AGGREGATION'; when HashSet() add 'INGEST_AGGREGATION'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ValidationResult FederatedViewValidator.getEdgeResult(View, Schema, Set, boolean)"
  })
  void testGetEdgeResult_givenIngestAggregation_whenHashSetAddIngestAggregation() {
    // Arrange
    FederatedViewValidator federatedViewValidator = new FederatedViewValidator();
    View view = new View();
    Schema schema = new Schema();

    HashSet<StoreTrait> storeTraits = new HashSet<>();
    storeTraits.add(StoreTrait.INGEST_AGGREGATION);

    // Act
    ValidationResult actualEdgeResult =
        federatedViewValidator.getEdgeResult(view, schema, storeTraits, true);

    // Assert
    assertEquals("Validation errors: \n", actualEdgeResult.getErrorString());
    assertTrue(actualEdgeResult.getErrors().isEmpty());
    assertTrue(actualEdgeResult.isValid());
  }

  /**
   * Test {@link FederatedViewValidator#getEdgeResult(View, Schema, Set, boolean)}.
   *
   * <ul>
   *   <li>Given {@code QUERY_AGGREGATION}.
   *   <li>When {@link HashSet#HashSet()} add {@code QUERY_AGGREGATION}.
   * </ul>
   *
   * <p>Method under test: {@link FederatedViewValidator#getEdgeResult(View, Schema, Set, boolean)}
   */
  @Test
  @DisplayName(
      "Test getEdgeResult(View, Schema, Set, boolean); given 'QUERY_AGGREGATION'; when HashSet() add 'QUERY_AGGREGATION'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ValidationResult FederatedViewValidator.getEdgeResult(View, Schema, Set, boolean)"
  })
  void testGetEdgeResult_givenQueryAggregation_whenHashSetAddQueryAggregation() {
    // Arrange
    FederatedViewValidator federatedViewValidator = new FederatedViewValidator();
    View view = new View();
    Schema schema = new Schema();

    HashSet<StoreTrait> storeTraits = new HashSet<>();
    storeTraits.add(StoreTrait.QUERY_AGGREGATION);
    storeTraits.add(StoreTrait.INGEST_AGGREGATION);

    // Act
    ValidationResult actualEdgeResult =
        federatedViewValidator.getEdgeResult(view, schema, storeTraits, true);

    // Assert
    assertEquals("Validation errors: \n", actualEdgeResult.getErrorString());
    assertTrue(actualEdgeResult.getErrors().isEmpty());
    assertTrue(actualEdgeResult.isValid());
  }

  /**
   * Test {@link FederatedViewValidator#getEdgeResult(View, Schema, Set, boolean)}.
   *
   * <ul>
   *   <li>When {@link HashSet#HashSet()}.
   *   <li>Then return ErrorString is {@code Validation errors:}.
   * </ul>
   *
   * <p>Method under test: {@link FederatedViewValidator#getEdgeResult(View, Schema, Set, boolean)}
   */
  @Test
  @DisplayName(
      "Test getEdgeResult(View, Schema, Set, boolean); when HashSet(); then return ErrorString is 'Validation errors:'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ValidationResult FederatedViewValidator.getEdgeResult(View, Schema, Set, boolean)"
  })
  void testGetEdgeResult_whenHashSet_thenReturnErrorStringIsValidationErrors() {
    // Arrange
    FederatedViewValidator federatedViewValidator = new FederatedViewValidator();
    View view = new View();
    Schema schema = new Schema();

    // Act
    ValidationResult actualEdgeResult =
        federatedViewValidator.getEdgeResult(view, schema, new HashSet<>(), true);

    // Assert
    assertEquals("Validation errors: \n", actualEdgeResult.getErrorString());
    assertTrue(actualEdgeResult.getErrors().isEmpty());
    assertTrue(actualEdgeResult.isValid());
  }

  /**
   * Test {@link FederatedViewValidator#getEntityResult(View, Schema, Set, boolean)}.
   *
   * <ul>
   *   <li>Given {@code INGEST_AGGREGATION}.
   *   <li>When {@link HashSet#HashSet()} add {@code INGEST_AGGREGATION}.
   * </ul>
   *
   * <p>Method under test: {@link FederatedViewValidator#getEntityResult(View, Schema, Set,
   * boolean)}
   */
  @Test
  @DisplayName(
      "Test getEntityResult(View, Schema, Set, boolean); given 'INGEST_AGGREGATION'; when HashSet() add 'INGEST_AGGREGATION'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ValidationResult FederatedViewValidator.getEntityResult(View, Schema, Set, boolean)"
  })
  void testGetEntityResult_givenIngestAggregation_whenHashSetAddIngestAggregation() {
    // Arrange
    FederatedViewValidator federatedViewValidator = new FederatedViewValidator();
    View view = new View();
    Schema schema = new Schema();

    HashSet<StoreTrait> storeTraits = new HashSet<>();
    storeTraits.add(StoreTrait.INGEST_AGGREGATION);

    // Act
    ValidationResult actualEntityResult =
        federatedViewValidator.getEntityResult(view, schema, storeTraits, true);

    // Assert
    assertEquals("Validation errors: \n", actualEntityResult.getErrorString());
    assertTrue(actualEntityResult.getErrors().isEmpty());
    assertTrue(actualEntityResult.isValid());
  }

  /**
   * Test {@link FederatedViewValidator#getEntityResult(View, Schema, Set, boolean)}.
   *
   * <ul>
   *   <li>Given {@code QUERY_AGGREGATION}.
   *   <li>When {@link HashSet#HashSet()} add {@code QUERY_AGGREGATION}.
   * </ul>
   *
   * <p>Method under test: {@link FederatedViewValidator#getEntityResult(View, Schema, Set,
   * boolean)}
   */
  @Test
  @DisplayName(
      "Test getEntityResult(View, Schema, Set, boolean); given 'QUERY_AGGREGATION'; when HashSet() add 'QUERY_AGGREGATION'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ValidationResult FederatedViewValidator.getEntityResult(View, Schema, Set, boolean)"
  })
  void testGetEntityResult_givenQueryAggregation_whenHashSetAddQueryAggregation() {
    // Arrange
    FederatedViewValidator federatedViewValidator = new FederatedViewValidator();
    View view = new View();
    Schema schema = new Schema();

    HashSet<StoreTrait> storeTraits = new HashSet<>();
    storeTraits.add(StoreTrait.QUERY_AGGREGATION);
    storeTraits.add(StoreTrait.INGEST_AGGREGATION);

    // Act
    ValidationResult actualEntityResult =
        federatedViewValidator.getEntityResult(view, schema, storeTraits, true);

    // Assert
    assertEquals("Validation errors: \n", actualEntityResult.getErrorString());
    assertTrue(actualEntityResult.getErrors().isEmpty());
    assertTrue(actualEntityResult.isValid());
  }

  /**
   * Test {@link FederatedViewValidator#getEntityResult(View, Schema, Set, boolean)}.
   *
   * <ul>
   *   <li>When {@link HashSet#HashSet()}.
   *   <li>Then return ErrorString is {@code Validation errors:}.
   * </ul>
   *
   * <p>Method under test: {@link FederatedViewValidator#getEntityResult(View, Schema, Set,
   * boolean)}
   */
  @Test
  @DisplayName(
      "Test getEntityResult(View, Schema, Set, boolean); when HashSet(); then return ErrorString is 'Validation errors:'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ValidationResult FederatedViewValidator.getEntityResult(View, Schema, Set, boolean)"
  })
  void testGetEntityResult_whenHashSet_thenReturnErrorStringIsValidationErrors() {
    // Arrange
    FederatedViewValidator federatedViewValidator = new FederatedViewValidator();
    View view = new View();
    Schema schema = new Schema();

    // Act
    ValidationResult actualEntityResult =
        federatedViewValidator.getEntityResult(view, schema, new HashSet<>(), true);

    // Assert
    assertEquals("Validation errors: \n", actualEntityResult.getErrorString());
    assertTrue(actualEntityResult.getErrors().isEmpty());
    assertTrue(actualEntityResult.isValid());
  }
}
