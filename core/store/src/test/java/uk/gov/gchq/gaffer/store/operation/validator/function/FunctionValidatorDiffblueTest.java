package uk.gov.gchq.gaffer.store.operation.validator.function;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.AbstractMap;
import java.util.AbstractMap.SimpleEntry;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.data.element.function.ElementAggregator;
import uk.gov.gchq.gaffer.data.element.function.ElementAggregator.Builder;
import uk.gov.gchq.gaffer.operation.impl.function.Aggregate;
import uk.gov.gchq.gaffer.operation.impl.function.Function;
import uk.gov.gchq.gaffer.operation.util.AggregatePair;
import uk.gov.gchq.gaffer.store.schema.Schema;
import uk.gov.gchq.gaffer.store.schema.SchemaEdgeDefinition;
import uk.gov.gchq.gaffer.store.schema.SchemaElementDefinition;
import uk.gov.gchq.koryphe.ValidationResult;

class FunctionValidatorDiffblueTest {
  /**
   * Test {@link FunctionValidator#validate(Function, Schema)}.
   *
   * <p>Method under test: {@link FunctionValidator#validate(Function, Schema)}
   */
  @Test
  @DisplayName("Test validate(Function, Schema)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ValidationResult FunctionValidator.validate(Function, Schema)"})
  void testValidate() {
    // Arrange
    AggregateValidator aggregateValidator = new AggregateValidator();

    HashMap<String, AggregatePair> edges = new HashMap<>();
    edges.put("foo", new AggregatePair());

    Aggregate aggregate = new Aggregate();
    aggregate.setEdges(edges);

    // Act
    ValidationResult actualValidateResult = aggregateValidator.validate(aggregate, new Schema());

    // Assert
    assertEquals(
        "Validation errors: \nEdge group: foo does not exist in the schema.",
        actualValidateResult.getErrorString());
    Set<String> errors = actualValidateResult.getErrors();
    assertEquals(1, errors.size());
    assertFalse(actualValidateResult.isValid());
    assertTrue(errors.contains("Edge group: foo does not exist in the schema."));
  }

  /**
   * Test {@link FunctionValidator#validate(Function, Schema)}.
   *
   * <p>Method under test: {@link FunctionValidator#validate(Function, Schema)}
   */
  @Test
  @DisplayName("Test validate(Function, Schema)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ValidationResult FunctionValidator.validate(Function, Schema)"})
  void testValidate2() {
    // Arrange
    AggregateValidator aggregateValidator = new AggregateValidator();

    HashMap<String, AggregatePair> edges = new HashMap<>();
    edges.put(" does not exist in the schema.", new AggregatePair());
    edges.put("foo", new AggregatePair());

    Aggregate aggregate = new Aggregate();
    aggregate.setEdges(edges);

    // Act
    ValidationResult actualValidateResult = aggregateValidator.validate(aggregate, new Schema());

    // Assert
    assertEquals(
        "Validation errors: \n"
            + "Edge group:  does not exist in the schema. does not exist in the schema.\n"
            + "Edge group: foo does not exist in the schema.",
        actualValidateResult.getErrorString());
    Set<String> errors = actualValidateResult.getErrors();
    assertEquals(2, errors.size());
    assertTrue(
        errors.contains(
            "Edge group:  does not exist in the schema. does not exist in the schema."));
    assertTrue(errors.contains("Edge group: foo does not exist in the schema."));
  }

  /**
   * Test {@link FunctionValidator#validate(Function, Schema)}.
   *
   * <p>Method under test: {@link FunctionValidator#validate(Function, Schema)}
   */
  @Test
  @DisplayName("Test validate(Function, Schema)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ValidationResult FunctionValidator.validate(Function, Schema)"})
  void testValidate3() {
    // Arrange
    AggregateValidator aggregateValidator = new AggregateValidator();

    HashMap<String, AggregatePair> entities = new HashMap<>();
    entities.put("foo", new AggregatePair());

    Aggregate aggregate = new Aggregate();
    aggregate.setEntities(entities);

    // Act
    ValidationResult actualValidateResult = aggregateValidator.validate(aggregate, new Schema());

    // Assert
    assertEquals(
        "Validation errors: \nEntity group: foo does not exist in the schema.",
        actualValidateResult.getErrorString());
    Set<String> errors = actualValidateResult.getErrors();
    assertEquals(1, errors.size());
    assertFalse(actualValidateResult.isValid());
    assertTrue(errors.contains("Entity group: foo does not exist in the schema."));
  }

  /**
   * Test {@link FunctionValidator#validate(Function, Schema)}.
   *
   * <p>Method under test: {@link FunctionValidator#validate(Function, Schema)}
   */
  @Test
  @DisplayName("Test validate(Function, Schema)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ValidationResult FunctionValidator.validate(Function, Schema)"})
  void testValidate4() {
    // Arrange
    AggregateValidator aggregateValidator = new AggregateValidator();

    HashMap<String, AggregatePair> entities = new HashMap<>();
    entities.put(" does not exist in the schema.", new AggregatePair());
    entities.put("foo", new AggregatePair());

    Aggregate aggregate = new Aggregate();
    aggregate.setEntities(entities);

    // Act
    ValidationResult actualValidateResult = aggregateValidator.validate(aggregate, new Schema());

    // Assert
    assertEquals(
        "Validation errors: \n"
            + "Entity group:  does not exist in the schema. does not exist in the schema.\n"
            + "Entity group: foo does not exist in the schema.",
        actualValidateResult.getErrorString());
    Set<String> errors = actualValidateResult.getErrors();
    assertEquals(2, errors.size());
    assertTrue(
        errors.contains(
            "Entity group:  does not exist in the schema. does not exist in the schema."));
    assertTrue(errors.contains("Entity group: foo does not exist in the schema."));
  }

  /**
   * Test {@link FunctionValidator#validate(Function, Schema)}.
   *
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} {@code foo} is {@link
   *       AggregatePair#AggregatePair(ElementAggregator)} with aggregator is {@link
   *       Builder#Builder()} build.
   * </ul>
   *
   * <p>Method under test: {@link FunctionValidator#validate(Function, Schema)}
   */
  @Test
  @DisplayName(
      "Test validate(Function, Schema); given HashMap() 'foo' is AggregatePair(ElementAggregator) with aggregator is Builder() build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ValidationResult FunctionValidator.validate(Function, Schema)"})
  void testValidate_givenHashMapFooIsAggregatePairWithAggregatorIsBuilderBuild() {
    // Arrange
    AggregateValidator aggregateValidator = new AggregateValidator();

    HashMap<String, AggregatePair> edges = new HashMap<>();
    ElementAggregator aggregator = new Builder().build();
    edges.put("foo", new AggregatePair(aggregator));

    Aggregate aggregate = new Aggregate();
    aggregate.setEdges(edges);

    // Act
    ValidationResult actualValidateResult = aggregateValidator.validate(aggregate, new Schema());

    // Assert
    assertEquals(
        "Validation errors: \nEdge group: foo does not exist in the schema.",
        actualValidateResult.getErrorString());
    Set<String> errors = actualValidateResult.getErrors();
    assertEquals(1, errors.size());
    assertFalse(actualValidateResult.isValid());
    assertTrue(errors.contains("Edge group: foo does not exist in the schema."));
  }

  /**
   * Test {@link FunctionValidator#validate(Function, Schema)}.
   *
   * <ul>
   *   <li>Then return ErrorString is {@code Validation errors: Schema cannot be null.}.
   * </ul>
   *
   * <p>Method under test: {@link FunctionValidator#validate(Function, Schema)}
   */
  @Test
  @DisplayName(
      "Test validate(Function, Schema); then return ErrorString is 'Validation errors: Schema cannot be null.'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ValidationResult FunctionValidator.validate(Function, Schema)"})
  void testValidate_thenReturnErrorStringIsValidationErrorsSchemaCannotBeNull() {
    // Arrange
    AggregateValidator aggregateValidator = new AggregateValidator();

    // Act
    ValidationResult actualValidateResult = aggregateValidator.validate(new Aggregate(), null);

    // Assert
    assertEquals(
        "Validation errors: \nSchema cannot be null.", actualValidateResult.getErrorString());
    Set<String> errors = actualValidateResult.getErrors();
    assertEquals(1, errors.size());
    assertFalse(actualValidateResult.isValid());
    assertTrue(errors.contains("Schema cannot be null."));
  }

  /**
   * Test {@link FunctionValidator#validate(Function, Schema)}.
   *
   * <ul>
   *   <li>When {@link Aggregate} (default constructor).
   *   <li>Then return ErrorString is {@code Validation errors:}.
   * </ul>
   *
   * <p>Method under test: {@link FunctionValidator#validate(Function, Schema)}
   */
  @Test
  @DisplayName(
      "Test validate(Function, Schema); when Aggregate (default constructor); then return ErrorString is 'Validation errors:'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ValidationResult FunctionValidator.validate(Function, Schema)"})
  void testValidate_whenAggregate_thenReturnErrorStringIsValidationErrors() {
    // Arrange
    AggregateValidator aggregateValidator = new AggregateValidator();
    Aggregate aggregate = new Aggregate();

    // Act
    ValidationResult actualValidateResult = aggregateValidator.validate(aggregate, new Schema());

    // Assert
    assertEquals("Validation errors: \n", actualValidateResult.getErrorString());
    assertTrue(actualValidateResult.getErrors().isEmpty());
    assertTrue(actualValidateResult.isValid());
  }

  /**
   * Test {@link FunctionValidator#validateEdge(Entry, Schema)}.
   *
   * <p>Method under test: {@link FunctionValidator#validateEdge(Entry, Schema)}
   */
  @Test
  @DisplayName("Test validateEdge(Entry, Schema)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ValidationResult FunctionValidator.validateEdge(Entry, Schema)"})
  void testValidateEdge() {
    // Arrange
    AggregateValidator aggregateValidator = new AggregateValidator();
    SimpleEntry<String, Object> edgeEntry = new SimpleEntry<>("foo", "42");

    // Act
    ValidationResult actualValidateEdgeResult =
        aggregateValidator.validateEdge(edgeEntry, new Schema());

    // Assert
    assertEquals(
        "Validation errors: \nEdge group: foo does not exist in the schema.",
        actualValidateEdgeResult.getErrorString());
    Set<String> errors = actualValidateEdgeResult.getErrors();
    assertEquals(1, errors.size());
    assertFalse(actualValidateEdgeResult.isValid());
    assertTrue(errors.contains("Edge group: foo does not exist in the schema."));
  }

  /**
   * Test {@link FunctionValidator#validateEdge(Entry, Schema)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return ErrorString is {@code Validation errors:}.
   * </ul>
   *
   * <p>Method under test: {@link FunctionValidator#validateEdge(Entry, Schema)}
   */
  @Test
  @DisplayName(
      "Test validateEdge(Entry, Schema); when 'null'; then return ErrorString is 'Validation errors:'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ValidationResult FunctionValidator.validateEdge(Entry, Schema)"})
  void testValidateEdge_whenNull_thenReturnErrorStringIsValidationErrors() {
    // Arrange
    AggregateValidator aggregateValidator = new AggregateValidator();

    // Act
    ValidationResult actualValidateEdgeResult = aggregateValidator.validateEdge(null, new Schema());

    // Assert
    assertEquals("Validation errors: \n", actualValidateEdgeResult.getErrorString());
    assertTrue(actualValidateEdgeResult.getErrors().isEmpty());
    assertTrue(actualValidateEdgeResult.isValid());
  }

  /**
   * Test {@link FunctionValidator#validateEntity(Entry, Schema)}.
   *
   * <p>Method under test: {@link FunctionValidator#validateEntity(Entry, Schema)}
   */
  @Test
  @DisplayName("Test validateEntity(Entry, Schema)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ValidationResult FunctionValidator.validateEntity(Entry, Schema)"})
  void testValidateEntity() {
    // Arrange
    AggregateValidator aggregateValidator = new AggregateValidator();
    SimpleEntry<String, Object> entityEntry = new SimpleEntry<>("foo", "42");

    // Act
    ValidationResult actualValidateEntityResult =
        aggregateValidator.validateEntity(entityEntry, new Schema());

    // Assert
    assertEquals(
        "Validation errors: \nEntity group: foo does not exist in the schema.",
        actualValidateEntityResult.getErrorString());
    Set<String> errors = actualValidateEntityResult.getErrors();
    assertEquals(1, errors.size());
    assertFalse(actualValidateEntityResult.isValid());
    assertTrue(errors.contains("Entity group: foo does not exist in the schema."));
  }

  /**
   * Test {@link FunctionValidator#validateEntity(Entry, Schema)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return ErrorString is {@code Validation errors:}.
   * </ul>
   *
   * <p>Method under test: {@link FunctionValidator#validateEntity(Entry, Schema)}
   */
  @Test
  @DisplayName(
      "Test validateEntity(Entry, Schema); when 'null'; then return ErrorString is 'Validation errors:'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ValidationResult FunctionValidator.validateEntity(Entry, Schema)"})
  void testValidateEntity_whenNull_thenReturnErrorStringIsValidationErrors() {
    // Arrange
    AggregateValidator aggregateValidator = new AggregateValidator();

    // Act
    ValidationResult actualValidateEntityResult =
        aggregateValidator.validateEntity(null, new Schema());

    // Assert
    assertEquals("Validation errors: \n", actualValidateEntityResult.getErrorString());
    assertTrue(actualValidateEntityResult.getErrors().isEmpty());
    assertTrue(actualValidateEntityResult.isValid());
  }

  /**
   * Test {@link FunctionValidator#getTypeClasses(String[], SchemaElementDefinition)}.
   *
   * <ul>
   *   <li>When {@link SchemaEdgeDefinition} (default constructor).
   *   <li>Then return first element is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link FunctionValidator#getTypeClasses(String[],
   * SchemaElementDefinition)}
   */
  @Test
  @DisplayName(
      "Test getTypeClasses(String[], SchemaElementDefinition); when SchemaEdgeDefinition (default constructor); then return first element is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Class[] FunctionValidator.getTypeClasses(String[], SchemaElementDefinition)"})
  void testGetTypeClasses_whenSchemaEdgeDefinition_thenReturnFirstElementIsNull() {
    // Arrange
    AggregateValidator aggregateValidator = new AggregateValidator();

    // Act
    Class[] actualTypeClasses =
        aggregateValidator.getTypeClasses(new String[] {"Keys"}, new SchemaEdgeDefinition());

    // Assert
    assertNull(actualTypeClasses[0]);
    assertEquals(1, actualTypeClasses.length);
  }

  /**
   * Test {@link FunctionValidator#getTypeClass(String, SchemaElementDefinition)}.
   *
   * <ul>
   *   <li>When {@link SchemaEdgeDefinition} (default constructor).
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link FunctionValidator#getTypeClass(String, SchemaElementDefinition)}
   */
  @Test
  @DisplayName(
      "Test getTypeClass(String, SchemaElementDefinition); when SchemaEdgeDefinition (default constructor); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Class FunctionValidator.getTypeClass(String, SchemaElementDefinition)"})
  void testGetTypeClass_whenSchemaEdgeDefinition_thenReturnNull() {
    // Arrange
    AggregateValidator aggregateValidator = new AggregateValidator();

    // Act and Assert
    assertNull(aggregateValidator.getTypeClass("Key", new SchemaEdgeDefinition()));
  }
}
