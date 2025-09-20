package uk.gov.gchq.gaffer.store;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.Set;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.data.element.Edge;
import uk.gov.gchq.gaffer.data.element.Element;
import uk.gov.gchq.gaffer.data.elementdefinition.view.View;
import uk.gov.gchq.gaffer.store.schema.Schema;
import uk.gov.gchq.koryphe.ValidationResult;

class ElementValidatorDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>When {@link Schema#Schema()}.
   *   <li>Then return View is {@code null}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ElementValidator#ElementValidator(Schema)}
   *   <li>{@link ElementValidator#getSchema()}
   *   <li>{@link ElementValidator#getView()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; when Schema(); then return View is 'null'")
  @Tag("MaintainedByDiffblue")
  void testGettersAndSetters_whenSchema_thenReturnViewIsNull() {
    // Arrange
    Schema schema = new Schema();

    // Act
    ElementValidator actualElementValidator = new ElementValidator(schema);
    Schema actualSchema = actualElementValidator.getSchema();

    // Assert
    assertNull(actualElementValidator.getView());
    assertSame(schema, actualSchema);
  }

  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>When {@code true}.
   *   <li>Then return View is {@code null}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ElementValidator#ElementValidator(Schema, boolean)}
   *   <li>{@link ElementValidator#getSchema()}
   *   <li>{@link ElementValidator#getView()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; when 'true'; then return View is 'null'")
  @Tag("MaintainedByDiffblue")
  void testGettersAndSetters_whenTrue_thenReturnViewIsNull() {
    // Arrange
    Schema schema = new Schema();

    // Act
    ElementValidator actualElementValidator = new ElementValidator(schema, true);
    Schema actualSchema = actualElementValidator.getSchema();

    // Assert
    assertNull(actualElementValidator.getView());
    assertSame(schema, actualSchema);
  }

  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>When {@link View} (default constructor).
   *   <li>Then return Schema is {@code null}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ElementValidator#ElementValidator(View)}
   *   <li>{@link ElementValidator#getSchema()}
   *   <li>{@link ElementValidator#getView()}
   * </ul>
   */
  @Test
  @DisplayName(
      "Test getters and setters; when View (default constructor); then return Schema is 'null'")
  @Tag("MaintainedByDiffblue")
  void testGettersAndSetters_whenView_thenReturnSchemaIsNull() {
    // Arrange
    View view = new View();

    // Act
    ElementValidator actualElementValidator = new ElementValidator(view);
    Schema actualSchema = actualElementValidator.getSchema();

    // Assert
    assertNull(actualSchema);
    assertSame(view, actualElementValidator.getView());
  }

  /**
   * Test {@link ElementValidator#validate(Element)} with {@code Element}.
   *
   * <ul>
   *   <li>Given {@link ElementValidator#ElementValidator(Schema)} with schema is {@link
   *       Schema#Schema()}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ElementValidator#validate(Element)}
   */
  @Test
  @DisplayName(
      "Test validate(Element) with 'Element'; given ElementValidator(Schema) with schema is Schema(); then return 'false'")
  @Tag("MaintainedByDiffblue")
  void testValidateWithElement_givenElementValidatorWithSchemaIsSchema_thenReturnFalse() {
    // Arrange
    ElementValidator elementValidator = new ElementValidator(new Schema());

    // Act
    boolean actualValidateResult = elementValidator.validate(new Edge("Group"));

    // Assert
    assertFalse(actualValidateResult);
  }

  /**
   * Test {@link ElementValidator#validate(Element)} with {@code Element}.
   *
   * <ul>
   *   <li>Given {@link ElementValidator#ElementValidator(View)} with view is {@code null}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link ElementValidator#validate(Element)}
   */
  @Test
  @DisplayName(
      "Test validate(Element) with 'Element'; given ElementValidator(View) with view is 'null'; then return 'true'")
  @Tag("MaintainedByDiffblue")
  void testValidateWithElement_givenElementValidatorWithViewIsNull_thenReturnTrue() {
    // Arrange
    ElementValidator elementValidator = new ElementValidator((View) null);

    // Act
    boolean actualValidateResult = elementValidator.validate(new Edge("Group"));

    // Assert
    assertTrue(actualValidateResult);
  }

  /**
   * Test {@link ElementValidator#validate(Element)} with {@code Element}.
   *
   * <ul>
   *   <li>Given {@link ElementValidator#ElementValidator(View)} with view is {@link View} (default
   *       constructor).
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ElementValidator#validate(Element)}
   */
  @Test
  @DisplayName(
      "Test validate(Element) with 'Element'; given ElementValidator(View) with view is View (default constructor); then return 'false'")
  @Tag("MaintainedByDiffblue")
  void testValidateWithElement_givenElementValidatorWithViewIsView_thenReturnFalse() {
    // Arrange
    ElementValidator elementValidator = new ElementValidator(new View());

    // Act
    boolean actualValidateResult = elementValidator.validate(new Edge("Group"));

    // Assert
    assertFalse(actualValidateResult);
  }

  /**
   * Test {@link ElementValidator#validate(Element)} with {@code Element}.
   *
   * <ul>
   *   <li>Given {@link ElementValidator#ElementValidator(View)} with view is {@link View} (default
   *       constructor).
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ElementValidator#validate(Element)}
   */
  @Test
  @DisplayName(
      "Test validate(Element) with 'Element'; given ElementValidator(View) with view is View (default constructor); when 'null'")
  @Tag("MaintainedByDiffblue")
  void testValidateWithElement_givenElementValidatorWithViewIsView_whenNull() {
    // Arrange, Act and Assert
    assertFalse(new ElementValidator(new View()).validate(null));
  }

  /**
   * Test {@link ElementValidator#validateWithValidationResult(Element)} with {@code Element}.
   *
   * <p>Method under test: {@link ElementValidator#validateWithValidationResult(Element)}
   */
  @Test
  @DisplayName("Test validateWithValidationResult(Element) with 'Element'")
  @Tag("MaintainedByDiffblue")
  void testValidateWithValidationResultWithElement() {
    // Arrange
    ElementValidator elementValidator = new ElementValidator(new View());

    // Act
    ValidationResult actualValidateWithValidationResultResult =
        elementValidator.validateWithValidationResult(new Edge("Group"));

    // Assert
    assertEquals(
        "Validation errors: \nNo element definition found for: Group",
        actualValidateWithValidationResultResult.getErrorString());
    Set<String> errors = actualValidateWithValidationResultResult.getErrors();
    assertEquals(1, errors.size());
    assertFalse(actualValidateWithValidationResultResult.isValid());
    assertTrue(errors.contains("No element definition found for: Group"));
  }

  /**
   * Test {@link ElementValidator#validateWithValidationResult(Element)} with {@code Element}.
   *
   * <p>Method under test: {@link ElementValidator#validateWithValidationResult(Element)}
   */
  @Test
  @DisplayName("Test validateWithValidationResult(Element) with 'Element'")
  @Tag("MaintainedByDiffblue")
  void testValidateWithValidationResultWithElement2() {
    // Arrange and Act
    ValidationResult actualValidateWithValidationResultResult =
        new ElementValidator(new View()).validateWithValidationResult(null);

    // Assert
    assertEquals(
        "Validation errors: \nElement was null",
        actualValidateWithValidationResultResult.getErrorString());
    Set<String> errors = actualValidateWithValidationResultResult.getErrors();
    assertEquals(1, errors.size());
    assertFalse(actualValidateWithValidationResultResult.isValid());
    assertTrue(errors.contains("Element was null"));
  }

  /**
   * Test {@link ElementValidator#validateWithValidationResult(Element)} with {@code Element}.
   *
   * <p>Method under test: {@link ElementValidator#validateWithValidationResult(Element)}
   */
  @Test
  @DisplayName("Test validateWithValidationResult(Element) with 'Element'")
  @Tag("MaintainedByDiffblue")
  void testValidateWithValidationResultWithElement3() {
    // Arrange
    ElementValidator elementValidator = new ElementValidator((View) null);

    // Act
    ValidationResult actualValidateWithValidationResultResult =
        elementValidator.validateWithValidationResult(new Edge("Group"));

    // Assert
    assertEquals(
        "Validation errors: \n", actualValidateWithValidationResultResult.getErrorString());
    assertTrue(actualValidateWithValidationResultResult.getErrors().isEmpty());
    assertTrue(actualValidateWithValidationResultResult.isValid());
  }

  /**
   * Test {@link ElementValidator#validateWithValidationResult(Element)} with {@code Element}.
   *
   * <p>Method under test: {@link ElementValidator#validateWithValidationResult(Element)}
   */
  @Test
  @DisplayName("Test validateWithValidationResult(Element) with 'Element'")
  @Tag("MaintainedByDiffblue")
  void testValidateWithValidationResultWithElement4() {
    // Arrange
    ElementValidator elementValidator = new ElementValidator(new Schema());

    // Act
    ValidationResult actualValidateWithValidationResultResult =
        elementValidator.validateWithValidationResult(new Edge("Group"));

    // Assert
    assertEquals(
        "Validation errors: \nNo element definition found for: Group",
        actualValidateWithValidationResultResult.getErrorString());
    Set<String> errors = actualValidateWithValidationResultResult.getErrors();
    assertEquals(1, errors.size());
    assertFalse(actualValidateWithValidationResultResult.isValid());
    assertTrue(errors.contains("No element definition found for: Group"));
  }

  /**
   * Test {@link ElementValidator#validateInput(Element)}.
   *
   * <ul>
   *   <li>Given {@link ElementValidator#ElementValidator(View)} with view is {@code null}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link ElementValidator#validateInput(Element)}
   */
  @Test
  @DisplayName(
      "Test validateInput(Element); given ElementValidator(View) with view is 'null'; then return 'true'")
  @Tag("MaintainedByDiffblue")
  void testValidateInput_givenElementValidatorWithViewIsNull_thenReturnTrue() {
    // Arrange
    ElementValidator elementValidator = new ElementValidator((View) null);

    // Act
    boolean actualValidateInputResult = elementValidator.validateInput(new Edge("Group"));

    // Assert
    assertTrue(actualValidateInputResult);
  }

  /**
   * Test {@link ElementValidator#validateInput(Element)}.
   *
   * <ul>
   *   <li>Given {@link ElementValidator#ElementValidator(View)} with view is {@code null}.
   *   <li>When {@code null}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ElementValidator#validateInput(Element)}
   */
  @Test
  @DisplayName(
      "Test validateInput(Element); given ElementValidator(View) with view is 'null'; when 'null'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  void testValidateInput_givenElementValidatorWithViewIsNull_whenNull_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new ElementValidator((View) null).validateInput(null));
  }

  /**
   * Test {@link ElementValidator#validateInput(Element)}.
   *
   * <ul>
   *   <li>Given {@link ElementValidator#ElementValidator(View)} with view is {@link View} (default
   *       constructor).
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ElementValidator#validateInput(Element)}
   */
  @Test
  @DisplayName(
      "Test validateInput(Element); given ElementValidator(View) with view is View (default constructor); then return 'false'")
  @Tag("MaintainedByDiffblue")
  void testValidateInput_givenElementValidatorWithViewIsView_thenReturnFalse() {
    // Arrange
    ElementValidator elementValidator = new ElementValidator(new View());

    // Act
    boolean actualValidateInputResult = elementValidator.validateInput(new Edge("Group"));

    // Assert
    assertFalse(actualValidateInputResult);
  }

  /**
   * Test {@link ElementValidator#validateAggregation(Element)}.
   *
   * <ul>
   *   <li>Given {@link ElementValidator#ElementValidator(View)} with view is {@code null}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link ElementValidator#validateAggregation(Element)}
   */
  @Test
  @DisplayName(
      "Test validateAggregation(Element); given ElementValidator(View) with view is 'null'; then return 'true'")
  @Tag("MaintainedByDiffblue")
  void testValidateAggregation_givenElementValidatorWithViewIsNull_thenReturnTrue() {
    // Arrange
    ElementValidator elementValidator = new ElementValidator((View) null);

    // Act
    boolean actualValidateAggregationResult =
        elementValidator.validateAggregation(new Edge("Group"));

    // Assert
    assertTrue(actualValidateAggregationResult);
  }

  /**
   * Test {@link ElementValidator#validateAggregation(Element)}.
   *
   * <ul>
   *   <li>Given {@link ElementValidator#ElementValidator(View)} with view is {@link View} (default
   *       constructor).
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ElementValidator#validateAggregation(Element)}
   */
  @Test
  @DisplayName(
      "Test validateAggregation(Element); given ElementValidator(View) with view is View (default constructor); then return 'false'")
  @Tag("MaintainedByDiffblue")
  void testValidateAggregation_givenElementValidatorWithViewIsView_thenReturnFalse() {
    // Arrange
    ElementValidator elementValidator = new ElementValidator(new View());

    // Act
    boolean actualValidateAggregationResult =
        elementValidator.validateAggregation(new Edge("Group"));

    // Assert
    assertFalse(actualValidateAggregationResult);
  }

  /**
   * Test {@link ElementValidator#validateAggregation(Element)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ElementValidator#validateAggregation(Element)}
   */
  @Test
  @DisplayName("Test validateAggregation(Element); when 'null'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  void testValidateAggregation_whenNull_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new ElementValidator((View) null).validateAggregation(null));
  }

  /**
   * Test {@link ElementValidator#validateTransform(Element)}.
   *
   * <ul>
   *   <li>Given {@link ElementValidator#ElementValidator(View)} with view is {@code null}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link ElementValidator#validateTransform(Element)}
   */
  @Test
  @DisplayName(
      "Test validateTransform(Element); given ElementValidator(View) with view is 'null'; then return 'true'")
  @Tag("MaintainedByDiffblue")
  void testValidateTransform_givenElementValidatorWithViewIsNull_thenReturnTrue() {
    // Arrange
    ElementValidator elementValidator = new ElementValidator((View) null);

    // Act
    boolean actualValidateTransformResult = elementValidator.validateTransform(new Edge("Group"));

    // Assert
    assertTrue(actualValidateTransformResult);
  }

  /**
   * Test {@link ElementValidator#validateTransform(Element)}.
   *
   * <ul>
   *   <li>Given {@link ElementValidator#ElementValidator(View)} with view is {@link View} (default
   *       constructor).
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ElementValidator#validateTransform(Element)}
   */
  @Test
  @DisplayName(
      "Test validateTransform(Element); given ElementValidator(View) with view is View (default constructor); then return 'false'")
  @Tag("MaintainedByDiffblue")
  void testValidateTransform_givenElementValidatorWithViewIsView_thenReturnFalse() {
    // Arrange
    ElementValidator elementValidator = new ElementValidator(new View());

    // Act
    boolean actualValidateTransformResult = elementValidator.validateTransform(new Edge("Group"));

    // Assert
    assertFalse(actualValidateTransformResult);
  }

  /**
   * Test {@link ElementValidator#validateTransform(Element)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ElementValidator#validateTransform(Element)}
   */
  @Test
  @DisplayName("Test validateTransform(Element); when 'null'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  void testValidateTransform_whenNull_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new ElementValidator((View) null).validateTransform(null));
  }

  /**
   * Test {@link ElementValidator#validateWithSchema(Element)}.
   *
   * <ul>
   *   <li>Given {@link ElementValidator#ElementValidator(Schema)} with schema is {@link
   *       Schema#Schema()}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ElementValidator#validateWithSchema(Element)}
   */
  @Test
  @DisplayName(
      "Test validateWithSchema(Element); given ElementValidator(Schema) with schema is Schema(); then return 'false'")
  @Tag("MaintainedByDiffblue")
  void testValidateWithSchema_givenElementValidatorWithSchemaIsSchema_thenReturnFalse() {
    // Arrange
    ElementValidator elementValidator = new ElementValidator(new Schema());

    // Act
    boolean actualValidateWithSchemaResult = elementValidator.validateWithSchema(new Edge("Group"));

    // Assert
    assertFalse(actualValidateWithSchemaResult);
  }

  /**
   * Test {@link ElementValidator#validateWithSchema(Element)}.
   *
   * <ul>
   *   <li>Given {@link ElementValidator#ElementValidator(View)} with view is {@link View} (default
   *       constructor).
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link ElementValidator#validateWithSchema(Element)}
   */
  @Test
  @DisplayName(
      "Test validateWithSchema(Element); given ElementValidator(View) with view is View (default constructor); then return 'true'")
  @Tag("MaintainedByDiffblue")
  void testValidateWithSchema_givenElementValidatorWithViewIsView_thenReturnTrue() {
    // Arrange
    ElementValidator elementValidator = new ElementValidator(new View());

    // Act
    boolean actualValidateWithSchemaResult = elementValidator.validateWithSchema(new Edge("Group"));

    // Assert
    assertTrue(actualValidateWithSchemaResult);
  }

  /**
   * Test {@link ElementValidator#validateWithSchema(Element)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ElementValidator#validateWithSchema(Element)}
   */
  @Test
  @DisplayName("Test validateWithSchema(Element); when 'null'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  void testValidateWithSchema_whenNull_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new ElementValidator(new View()).validateWithSchema(null));
  }
}
