package uk.gov.gchq.gaffer.store.schema;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;
import java.util.function.BinaryOperator;
import java.util.function.Predicate;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.data.element.IdentifierType;
import uk.gov.gchq.gaffer.data.element.function.ElementAggregator;
import uk.gov.gchq.gaffer.data.element.function.ElementFilter;
import uk.gov.gchq.koryphe.ValidationResult;
import uk.gov.gchq.koryphe.tuple.binaryoperator.TupleAdaptedBinaryOperator;
import uk.gov.gchq.koryphe.tuple.predicate.TupleAdaptedPredicate;

class SchemaElementDefinitionValidatorDiffblueTest {
  /**
   * Test {@link SchemaElementDefinitionValidator#validate(SchemaElementDefinition)}.
   *
   * <p>Method under test: {@link
   * SchemaElementDefinitionValidator#validate(SchemaElementDefinition)}
   */
  @Test
  @DisplayName("Test validate(SchemaElementDefinition)")
  @Tag("MaintainedByDiffblue")
  void testValidate() {
    // Arrange
    SchemaElementDefinitionValidator schemaElementDefinitionValidator =
        new SchemaElementDefinitionValidator();
    SchemaEdgeDefinition elementDef = new SchemaEdgeDefinition();

    // Act
    ValidationResult actualValidateResult = schemaElementDefinitionValidator.validate(elementDef);

    // Assert
    Collection<IdentifierType> identifiers = elementDef.getIdentifiers();
    assertTrue(identifiers instanceof Set);
    assertEquals(
        "Validation errors: \nEdge source type is not defined.\nEdge destination type is not defined.",
        actualValidateResult.getErrorString());
    Set<String> errors = actualValidateResult.getErrors();
    assertEquals(2, errors.size());
    assertTrue(identifiers.isEmpty());
    assertTrue(errors.contains("Edge destination type is not defined."));
    assertTrue(errors.contains("Edge source type is not defined."));
    ElementAggregator expectedFullAggregator = elementDef.fullAggregatorCache;
    assertSame(expectedFullAggregator, elementDef.getFullAggregator());
    ElementFilter expectedValidator = elementDef.fullValidatorWithIsACache;
    assertSame(expectedValidator, elementDef.getValidator());
    Set<String> expectedErrors = elementDef.propertiesInAggregatorCache;
    assertSame(
        expectedErrors, schemaElementDefinitionValidator.validateDirection(null).getErrors());
  }

  /**
   * Test {@link SchemaElementDefinitionValidator#validate(SchemaElementDefinition)}.
   *
   * <p>Method under test: {@link
   * SchemaElementDefinitionValidator#validate(SchemaElementDefinition)}
   */
  @Test
  @DisplayName("Test validate(SchemaElementDefinition)")
  @Tag("MaintainedByDiffblue")
  void testValidate2() {
    // Arrange
    SchemaElementDefinitionValidator schemaElementDefinitionValidator =
        new SchemaElementDefinitionValidator();

    SchemaEdgeDefinition elementDef = new SchemaEdgeDefinition();
    elementDef.setAggregate(false);

    // Act
    schemaElementDefinitionValidator.validate(elementDef);

    // Assert that nothing has changed
    Collection<IdentifierType> identifiers = elementDef.getIdentifiers();
    assertTrue(identifiers instanceof Set);
    assertTrue(identifiers.isEmpty());
    assertTrue(schemaElementDefinitionValidator.validateDirection(null).getErrors().isEmpty());
  }

  /**
   * Test {@link SchemaElementDefinitionValidator#validate(SchemaElementDefinition)}.
   *
   * <ul>
   *   <li>Then return ErrorString is {@code Validation errors: Entity vertex type is not defined.}.
   * </ul>
   *
   * <p>Method under test: {@link
   * SchemaElementDefinitionValidator#validate(SchemaElementDefinition)}
   */
  @Test
  @DisplayName(
      "Test validate(SchemaElementDefinition); then return ErrorString is 'Validation errors: Entity vertex type is not defined.'")
  @Tag("MaintainedByDiffblue")
  void testValidate_thenReturnErrorStringIsValidationErrorsEntityVertexTypeIsNotDefined() {
    // Arrange
    SchemaElementDefinitionValidator schemaElementDefinitionValidator =
        new SchemaElementDefinitionValidator();
    SchemaEntityDefinition elementDef = new SchemaEntityDefinition();

    // Act
    ValidationResult actualValidateResult = schemaElementDefinitionValidator.validate(elementDef);

    // Assert
    assertEquals(
        "Validation errors: \nEntity vertex type is not defined.",
        actualValidateResult.getErrorString());
    Set<String> errors = actualValidateResult.getErrors();
    assertEquals(1, errors.size());
    assertTrue(errors.contains("Entity vertex type is not defined."));
    Set<String> stringSet = elementDef.propertiesInAggregatorCache;
    assertEquals(stringSet, elementDef.getIdentifiers());
    ElementAggregator expectedFullAggregator = elementDef.fullAggregatorCache;
    assertSame(expectedFullAggregator, elementDef.getFullAggregator());
    ElementFilter expectedValidator = elementDef.fullValidatorWithIsACache;
    assertSame(expectedValidator, elementDef.getValidator());
    assertSame(stringSet, schemaElementDefinitionValidator.validateDirection(null).getErrors());
  }

  /**
   * Test {@link SchemaElementDefinitionValidator#validatePropertyNames(SchemaElementDefinition)}.
   *
   * <ul>
   *   <li>Then return ErrorString is {@code Validation errors:}.
   * </ul>
   *
   * <p>Method under test: {@link
   * SchemaElementDefinitionValidator#validatePropertyNames(SchemaElementDefinition)}
   */
  @Test
  @DisplayName(
      "Test validatePropertyNames(SchemaElementDefinition); then return ErrorString is 'Validation errors:'")
  @Tag("MaintainedByDiffblue")
  void testValidatePropertyNames_thenReturnErrorStringIsValidationErrors() {
    // Arrange
    SchemaElementDefinitionValidator schemaElementDefinitionValidator =
        new SchemaElementDefinitionValidator();

    // Act
    ValidationResult actualValidatePropertyNamesResult =
        schemaElementDefinitionValidator.validatePropertyNames(new SchemaEdgeDefinition());

    // Assert
    assertEquals("Validation errors: \n", actualValidatePropertyNamesResult.getErrorString());
    assertTrue(actualValidatePropertyNamesResult.getErrors().isEmpty());
    assertTrue(actualValidatePropertyNamesResult.isValid());
  }

  /**
   * Test {@link
   * SchemaElementDefinitionValidator#validateRequiredParameters(SchemaElementDefinition)}.
   *
   * <p>Method under test: {@link
   * SchemaElementDefinitionValidator#validateRequiredParameters(SchemaElementDefinition)}
   */
  @Test
  @DisplayName("Test validateRequiredParameters(SchemaElementDefinition)")
  @Tag("MaintainedByDiffblue")
  void testValidateRequiredParameters() {
    // Arrange
    SchemaElementDefinitionValidator schemaElementDefinitionValidator =
        new SchemaElementDefinitionValidator();

    // Act
    ValidationResult actualValidateRequiredParametersResult =
        schemaElementDefinitionValidator.validateRequiredParameters(new SchemaEdgeDefinition());

    // Assert
    assertEquals(
        "Validation errors: \nEdge source type is not defined.\nEdge destination type is not defined.",
        actualValidateRequiredParametersResult.getErrorString());
    Set<String> errors = actualValidateRequiredParametersResult.getErrors();
    assertEquals(2, errors.size());
    assertTrue(errors.contains("Edge destination type is not defined."));
    assertTrue(errors.contains("Edge source type is not defined."));
  }

  /**
   * Test {@link
   * SchemaElementDefinitionValidator#validateRequiredParameters(SchemaElementDefinition)}.
   *
   * <p>Method under test: {@link
   * SchemaElementDefinitionValidator#validateRequiredParameters(SchemaElementDefinition)}
   */
  @Test
  @DisplayName("Test validateRequiredParameters(SchemaElementDefinition)")
  @Tag("MaintainedByDiffblue")
  void testValidateRequiredParameters2() {
    // Arrange
    SchemaElementDefinitionValidator schemaElementDefinitionValidator =
        new SchemaElementDefinitionValidator();

    // Act
    ValidationResult actualValidateRequiredParametersResult =
        schemaElementDefinitionValidator.validateRequiredParameters(new SchemaEntityDefinition());

    // Assert
    assertEquals(
        "Validation errors: \nEntity vertex type is not defined.",
        actualValidateRequiredParametersResult.getErrorString());
    Set<String> errors = actualValidateRequiredParametersResult.getErrors();
    assertEquals(1, errors.size());
    assertFalse(actualValidateRequiredParametersResult.isValid());
    assertTrue(errors.contains("Entity vertex type is not defined."));
  }

  /**
   * Test {@link
   * SchemaElementDefinitionValidator#validateRequiredParameters(SchemaElementDefinition)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return ErrorString is {@code Validation errors:}.
   * </ul>
   *
   * <p>Method under test: {@link
   * SchemaElementDefinitionValidator#validateRequiredParameters(SchemaElementDefinition)}
   */
  @Test
  @DisplayName(
      "Test validateRequiredParameters(SchemaElementDefinition); when 'null'; then return ErrorString is 'Validation errors:'")
  @Tag("MaintainedByDiffblue")
  void testValidateRequiredParameters_whenNull_thenReturnErrorStringIsValidationErrors() {
    // Arrange and Act
    ValidationResult actualValidateRequiredParametersResult =
        new SchemaElementDefinitionValidator().validateRequiredParameters(null);

    // Assert
    assertEquals("Validation errors: \n", actualValidateRequiredParametersResult.getErrorString());
    assertTrue(actualValidateRequiredParametersResult.getErrors().isEmpty());
    assertTrue(actualValidateRequiredParametersResult.isValid());
  }

  /**
   * Test {@link SchemaElementDefinitionValidator#validateComponentTypes(SchemaElementDefinition)}.
   *
   * <ul>
   *   <li>Then return ErrorString is {@code Validation errors:}.
   * </ul>
   *
   * <p>Method under test: {@link
   * SchemaElementDefinitionValidator#validateComponentTypes(SchemaElementDefinition)}
   */
  @Test
  @DisplayName(
      "Test validateComponentTypes(SchemaElementDefinition); then return ErrorString is 'Validation errors:'")
  @Tag("MaintainedByDiffblue")
  void testValidateComponentTypes_thenReturnErrorStringIsValidationErrors() {
    // Arrange
    SchemaElementDefinitionValidator schemaElementDefinitionValidator =
        new SchemaElementDefinitionValidator();

    // Act
    ValidationResult actualValidateComponentTypesResult =
        schemaElementDefinitionValidator.validateComponentTypes(new SchemaEdgeDefinition());

    // Assert
    assertEquals("Validation errors: \n", actualValidateComponentTypesResult.getErrorString());
    assertTrue(actualValidateComponentTypesResult.getErrors().isEmpty());
    assertTrue(actualValidateComponentTypesResult.isValid());
  }

  /**
   * Test {@link SchemaElementDefinitionValidator#validateFunctionArgumentTypes(ElementAggregator,
   * SchemaElementDefinition)} with {@code aggregator}, {@code schemaElDef}.
   *
   * <p>Method under test: {@link
   * SchemaElementDefinitionValidator#validateFunctionArgumentTypes(ElementAggregator,
   * SchemaElementDefinition)}
   */
  @Test
  @DisplayName(
      "Test validateFunctionArgumentTypes(ElementAggregator, SchemaElementDefinition) with 'aggregator', 'schemaElDef'")
  @Tag("MaintainedByDiffblue")
  void testValidateFunctionArgumentTypesWithAggregatorSchemaElDef() {
    // Arrange
    SchemaElementDefinitionValidator schemaElementDefinitionValidator =
        new SchemaElementDefinitionValidator();

    ArrayList<TupleAdaptedBinaryOperator<String, ?>> components = new ArrayList<>();
    components.add(new TupleAdaptedBinaryOperator<>());

    ElementAggregator aggregator = new ElementAggregator();
    aggregator.setComponents(components);

    // Act
    ValidationResult actualValidateFunctionArgumentTypesResult =
        schemaElementDefinitionValidator.validateFunctionArgumentTypes(
            aggregator, new SchemaEdgeDefinition());

    // Assert
    assertEquals(
        "Validation errors: \nElementAggregator contains a null function.",
        actualValidateFunctionArgumentTypesResult.getErrorString());
    Set<String> errors = actualValidateFunctionArgumentTypesResult.getErrors();
    assertEquals(1, errors.size());
    assertFalse(actualValidateFunctionArgumentTypesResult.isValid());
    assertTrue(errors.contains("ElementAggregator contains a null function."));
  }

  /**
   * Test {@link SchemaElementDefinitionValidator#validateFunctionArgumentTypes(ElementAggregator,
   * SchemaElementDefinition)} with {@code aggregator}, {@code schemaElDef}.
   *
   * <p>Method under test: {@link
   * SchemaElementDefinitionValidator#validateFunctionArgumentTypes(ElementAggregator,
   * SchemaElementDefinition)}
   */
  @Test
  @DisplayName(
      "Test validateFunctionArgumentTypes(ElementAggregator, SchemaElementDefinition) with 'aggregator', 'schemaElDef'")
  @Tag("MaintainedByDiffblue")
  void testValidateFunctionArgumentTypesWithAggregatorSchemaElDef2() {
    // Arrange
    SchemaElementDefinitionValidator schemaElementDefinitionValidator =
        new SchemaElementDefinitionValidator();

    ArrayList<TupleAdaptedBinaryOperator<String, ?>> components = new ArrayList<>();
    String[] selection = new String[] {" contains a null function."};
    TupleAdaptedBinaryOperator<String, ?> tupleAdaptedBinaryOperator =
        new TupleAdaptedBinaryOperator<>(mock(BinaryOperator.class), selection);
    components.add(tupleAdaptedBinaryOperator);

    ElementAggregator aggregator = new ElementAggregator();
    aggregator.setComponents(components);

    // Act
    ValidationResult actualValidateFunctionArgumentTypesResult =
        schemaElementDefinitionValidator.validateFunctionArgumentTypes(
            aggregator, new SchemaEdgeDefinition());

    // Assert
    assertEquals(
        "Validation errors: \n", actualValidateFunctionArgumentTypesResult.getErrorString());
    assertTrue(actualValidateFunctionArgumentTypesResult.getErrors().isEmpty());
    assertTrue(actualValidateFunctionArgumentTypesResult.isValid());
  }

  /**
   * Test {@link SchemaElementDefinitionValidator#validateFunctionArgumentTypes(ElementAggregator,
   * SchemaElementDefinition)} with {@code aggregator}, {@code schemaElDef}.
   *
   * <ul>
   *   <li>When {@link ElementAggregator} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link
   * SchemaElementDefinitionValidator#validateFunctionArgumentTypes(ElementAggregator,
   * SchemaElementDefinition)}
   */
  @Test
  @DisplayName(
      "Test validateFunctionArgumentTypes(ElementAggregator, SchemaElementDefinition) with 'aggregator', 'schemaElDef'; when ElementAggregator (default constructor)")
  @Tag("MaintainedByDiffblue")
  void testValidateFunctionArgumentTypesWithAggregatorSchemaElDef_whenElementAggregator() {
    // Arrange
    SchemaElementDefinitionValidator schemaElementDefinitionValidator =
        new SchemaElementDefinitionValidator();
    ElementAggregator aggregator = new ElementAggregator();

    // Act
    ValidationResult actualValidateFunctionArgumentTypesResult =
        schemaElementDefinitionValidator.validateFunctionArgumentTypes(
            aggregator, new SchemaEdgeDefinition());

    // Assert
    assertEquals(
        "Validation errors: \n", actualValidateFunctionArgumentTypesResult.getErrorString());
    assertTrue(actualValidateFunctionArgumentTypesResult.getErrors().isEmpty());
    assertTrue(actualValidateFunctionArgumentTypesResult.isValid());
  }

  /**
   * Test {@link SchemaElementDefinitionValidator#validateFunctionArgumentTypes(ElementAggregator,
   * SchemaElementDefinition)} with {@code aggregator}, {@code schemaElDef}.
   *
   * <ul>
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * SchemaElementDefinitionValidator#validateFunctionArgumentTypes(ElementAggregator,
   * SchemaElementDefinition)}
   */
  @Test
  @DisplayName(
      "Test validateFunctionArgumentTypes(ElementAggregator, SchemaElementDefinition) with 'aggregator', 'schemaElDef'; when 'null'")
  @Tag("MaintainedByDiffblue")
  void testValidateFunctionArgumentTypesWithAggregatorSchemaElDef_whenNull() {
    // Arrange
    SchemaElementDefinitionValidator schemaElementDefinitionValidator =
        new SchemaElementDefinitionValidator();

    // Act
    ValidationResult actualValidateFunctionArgumentTypesResult =
        schemaElementDefinitionValidator.validateFunctionArgumentTypes(
            (ElementAggregator) null, new SchemaEdgeDefinition());

    // Assert
    assertEquals(
        "Validation errors: \n", actualValidateFunctionArgumentTypesResult.getErrorString());
    assertTrue(actualValidateFunctionArgumentTypesResult.getErrors().isEmpty());
    assertTrue(actualValidateFunctionArgumentTypesResult.isValid());
  }

  /**
   * Test {@link SchemaElementDefinitionValidator#validateFunctionArgumentTypes(ElementFilter,
   * SchemaElementDefinition)} with {@code filter}, {@code schemaElDef}.
   *
   * <p>Method under test: {@link
   * SchemaElementDefinitionValidator#validateFunctionArgumentTypes(ElementFilter,
   * SchemaElementDefinition)}
   */
  @Test
  @DisplayName(
      "Test validateFunctionArgumentTypes(ElementFilter, SchemaElementDefinition) with 'filter', 'schemaElDef'")
  @Tag("MaintainedByDiffblue")
  void testValidateFunctionArgumentTypesWithFilterSchemaElDef() {
    // Arrange
    SchemaElementDefinitionValidator schemaElementDefinitionValidator =
        new SchemaElementDefinitionValidator();

    ArrayList<TupleAdaptedPredicate<String, ?>> components = new ArrayList<>();
    components.add(new TupleAdaptedPredicate<>());

    ElementFilter filter = new ElementFilter();
    filter.setComponents(components);

    // Act
    ValidationResult actualValidateFunctionArgumentTypesResult =
        schemaElementDefinitionValidator.validateFunctionArgumentTypes(
            filter, new SchemaEdgeDefinition());

    // Assert
    assertEquals(
        "Validation errors: \nElementFilter contains a null function.",
        actualValidateFunctionArgumentTypesResult.getErrorString());
    Set<String> errors = actualValidateFunctionArgumentTypesResult.getErrors();
    assertEquals(1, errors.size());
    assertFalse(actualValidateFunctionArgumentTypesResult.isValid());
    assertTrue(errors.contains("ElementFilter contains a null function."));
  }

  /**
   * Test {@link SchemaElementDefinitionValidator#validateFunctionArgumentTypes(ElementFilter,
   * SchemaElementDefinition)} with {@code filter}, {@code schemaElDef}.
   *
   * <p>Method under test: {@link
   * SchemaElementDefinitionValidator#validateFunctionArgumentTypes(ElementFilter,
   * SchemaElementDefinition)}
   */
  @Test
  @DisplayName(
      "Test validateFunctionArgumentTypes(ElementFilter, SchemaElementDefinition) with 'filter', 'schemaElDef'")
  @Tag("MaintainedByDiffblue")
  void testValidateFunctionArgumentTypesWithFilterSchemaElDef2() {
    // Arrange
    SchemaElementDefinitionValidator schemaElementDefinitionValidator =
        new SchemaElementDefinitionValidator();

    ArrayList<TupleAdaptedPredicate<String, ?>> components = new ArrayList<>();
    String[] selection = new String[] {" contains a null function."};
    TupleAdaptedPredicate<String, ?> tupleAdaptedPredicate =
        new TupleAdaptedPredicate<>(mock(Predicate.class), selection);
    components.add(tupleAdaptedPredicate);

    ElementFilter filter = new ElementFilter();
    filter.setComponents(components);

    // Act
    ValidationResult actualValidateFunctionArgumentTypesResult =
        schemaElementDefinitionValidator.validateFunctionArgumentTypes(
            filter, new SchemaEdgeDefinition());

    // Assert
    assertEquals(
        "Validation errors: \n", actualValidateFunctionArgumentTypesResult.getErrorString());
    assertTrue(actualValidateFunctionArgumentTypesResult.getErrors().isEmpty());
    assertTrue(actualValidateFunctionArgumentTypesResult.isValid());
  }

  /**
   * Test {@link SchemaElementDefinitionValidator#validateFunctionArgumentTypes(ElementFilter,
   * SchemaElementDefinition)} with {@code filter}, {@code schemaElDef}.
   *
   * <ul>
   *   <li>When {@link ElementFilter} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link
   * SchemaElementDefinitionValidator#validateFunctionArgumentTypes(ElementFilter,
   * SchemaElementDefinition)}
   */
  @Test
  @DisplayName(
      "Test validateFunctionArgumentTypes(ElementFilter, SchemaElementDefinition) with 'filter', 'schemaElDef'; when ElementFilter (default constructor)")
  @Tag("MaintainedByDiffblue")
  void testValidateFunctionArgumentTypesWithFilterSchemaElDef_whenElementFilter() {
    // Arrange
    SchemaElementDefinitionValidator schemaElementDefinitionValidator =
        new SchemaElementDefinitionValidator();
    ElementFilter filter = new ElementFilter();

    // Act
    ValidationResult actualValidateFunctionArgumentTypesResult =
        schemaElementDefinitionValidator.validateFunctionArgumentTypes(
            filter, new SchemaEdgeDefinition());

    // Assert
    assertEquals(
        "Validation errors: \n", actualValidateFunctionArgumentTypesResult.getErrorString());
    assertTrue(actualValidateFunctionArgumentTypesResult.getErrors().isEmpty());
    assertTrue(actualValidateFunctionArgumentTypesResult.isValid());
  }

  /**
   * Test {@link SchemaElementDefinitionValidator#validateFunctionArgumentTypes(ElementFilter,
   * SchemaElementDefinition)} with {@code filter}, {@code schemaElDef}.
   *
   * <ul>
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * SchemaElementDefinitionValidator#validateFunctionArgumentTypes(ElementFilter,
   * SchemaElementDefinition)}
   */
  @Test
  @DisplayName(
      "Test validateFunctionArgumentTypes(ElementFilter, SchemaElementDefinition) with 'filter', 'schemaElDef'; when 'null'")
  @Tag("MaintainedByDiffblue")
  void testValidateFunctionArgumentTypesWithFilterSchemaElDef_whenNull() {
    // Arrange
    SchemaElementDefinitionValidator schemaElementDefinitionValidator =
        new SchemaElementDefinitionValidator();

    // Act
    ValidationResult actualValidateFunctionArgumentTypesResult =
        schemaElementDefinitionValidator.validateFunctionArgumentTypes(
            (ElementFilter) null, new SchemaEdgeDefinition());

    // Assert
    assertEquals(
        "Validation errors: \n", actualValidateFunctionArgumentTypesResult.getErrorString());
    assertTrue(actualValidateFunctionArgumentTypesResult.getErrors().isEmpty());
    assertTrue(actualValidateFunctionArgumentTypesResult.isValid());
  }

  /**
   * Test {@link SchemaElementDefinitionValidator#validateDirection(SchemaElementDefinition)}.
   *
   * <ul>
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * SchemaElementDefinitionValidator#validateDirection(SchemaElementDefinition)}
   */
  @Test
  @DisplayName("Test validateDirection(SchemaElementDefinition); when 'null'")
  @Tag("MaintainedByDiffblue")
  void testValidateDirection_whenNull() {
    // Arrange and Act
    ValidationResult actualValidateDirectionResult =
        new SchemaElementDefinitionValidator().validateDirection(null);

    // Assert
    assertEquals("Validation errors: \n", actualValidateDirectionResult.getErrorString());
    assertTrue(actualValidateDirectionResult.getErrors().isEmpty());
    assertTrue(actualValidateDirectionResult.isValid());
  }

  /**
   * Test {@link SchemaElementDefinitionValidator#validateDirection(SchemaElementDefinition)}.
   *
   * <ul>
   *   <li>When {@link SchemaEdgeDefinition} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link
   * SchemaElementDefinitionValidator#validateDirection(SchemaElementDefinition)}
   */
  @Test
  @DisplayName(
      "Test validateDirection(SchemaElementDefinition); when SchemaEdgeDefinition (default constructor)")
  @Tag("MaintainedByDiffblue")
  void testValidateDirection_whenSchemaEdgeDefinition() {
    // Arrange
    SchemaElementDefinitionValidator schemaElementDefinitionValidator =
        new SchemaElementDefinitionValidator();

    // Act
    ValidationResult actualValidateDirectionResult =
        schemaElementDefinitionValidator.validateDirection(new SchemaEdgeDefinition());

    // Assert
    assertEquals("Validation errors: \n", actualValidateDirectionResult.getErrorString());
    assertTrue(actualValidateDirectionResult.getErrors().isEmpty());
    assertTrue(actualValidateDirectionResult.isValid());
  }

  /**
   * Test {@link SchemaElementDefinitionValidator#equals(Object)}, and {@link
   * SchemaElementDefinitionValidator#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link SchemaElementDefinitionValidator#equals(Object)}
   *   <li>{@link SchemaElementDefinitionValidator#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    SchemaElementDefinitionValidator schemaElementDefinitionValidator =
        new SchemaElementDefinitionValidator();
    SchemaElementDefinitionValidator schemaElementDefinitionValidator2 =
        new SchemaElementDefinitionValidator();

    // Act and Assert
    assertEquals(schemaElementDefinitionValidator, schemaElementDefinitionValidator2);
    assertNotEquals(
        schemaElementDefinitionValidator.hashCode(), schemaElementDefinitionValidator2.hashCode());
  }

  /**
   * Test {@link SchemaElementDefinitionValidator#equals(Object)}, and {@link
   * SchemaElementDefinitionValidator#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link SchemaElementDefinitionValidator#equals(Object)}
   *   <li>{@link SchemaElementDefinitionValidator#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    SchemaElementDefinitionValidator schemaElementDefinitionValidator =
        new SchemaElementDefinitionValidator();

    // Act and Assert
    assertEquals(schemaElementDefinitionValidator, schemaElementDefinitionValidator);
    int expectedHashCodeResult = schemaElementDefinitionValidator.hashCode();
    assertEquals(expectedHashCodeResult, schemaElementDefinitionValidator.hashCode());
  }

  /**
   * Test {@link SchemaElementDefinitionValidator#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SchemaElementDefinitionValidator#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new SchemaElementDefinitionValidator(), 1);
  }

  /**
   * Test {@link SchemaElementDefinitionValidator#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then throw exception.
   * </ul>
   *
   * <p>Method under test: {@link SchemaElementDefinitionValidator#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then throw exception")
  @Tag("MaintainedByDiffblue")
  void testEquals_whenOtherIsNull_thenThrowException() {
    // Arrange, Act and Assert
    assertThrows(
        NullPointerException.class, () -> new SchemaElementDefinitionValidator().equals(null));
  }

  /**
   * Test {@link SchemaElementDefinitionValidator#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SchemaElementDefinitionValidator#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        new SchemaElementDefinitionValidator(),
        "Different type to SchemaElementDefinitionValidator");
  }
}
