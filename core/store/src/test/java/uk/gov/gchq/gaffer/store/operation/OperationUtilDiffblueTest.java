package uk.gov.gchq.gaffer.store.operation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.List;
import java.util.Set;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.named.operation.NamedOperation;
import uk.gov.gchq.gaffer.operation.OperationChain;
import uk.gov.gchq.gaffer.operation.OperationChainDAO;
import uk.gov.gchq.gaffer.operation.impl.GenerateSplitPointsFromSample;
import uk.gov.gchq.gaffer.operation.impl.Map;
import uk.gov.gchq.gaffer.operation.impl.io.GenericInputImpl;
import uk.gov.gchq.gaffer.operation.io.Input;
import uk.gov.gchq.gaffer.operation.io.Output;
import uk.gov.gchq.gaffer.store.operation.OperationUtil.UnknownGenericType;
import uk.gov.gchq.koryphe.ValidationResult;

class OperationUtilDiffblueTest {
  /**
   * Test {@link OperationUtil#getInputType(Class)} with {@code Class}.
   *
   * <ul>
   *   <li>Then return {@link UnknownGenericType}.
   * </ul>
   *
   * <p>Method under test: {@link OperationUtil#getInputType(Class)}
   */
  @Test
  @DisplayName("Test getInputType(Class) with 'Class'; then return UnknownGenericType")
  @Tag("MaintainedByDiffblue")
  void testGetInputTypeWithClass_thenReturnUnknownGenericType() {
    // Arrange
    Class<Input> input = Input.class;

    // Act
    Class<?> actualInputType = OperationUtil.getInputType(input);

    // Assert
    Class<UnknownGenericType> expectedInputType = UnknownGenericType.class;
    assertEquals(expectedInputType, actualInputType);
  }

  /**
   * Test {@link OperationUtil#getInputType(Input)} with {@code Input}.
   *
   * <ul>
   *   <li>When {@link GenerateSplitPointsFromSample} (default constructor).
   *   <li>Then return {@link Iterable}.
   * </ul>
   *
   * <p>Method under test: {@link OperationUtil#getInputType(Input)}
   */
  @Test
  @DisplayName(
      "Test getInputType(Input) with 'Input'; when GenerateSplitPointsFromSample (default constructor); then return Iterable")
  @Tag("MaintainedByDiffblue")
  void testGetInputTypeWithInput_whenGenerateSplitPointsFromSample_thenReturnIterable() {
    // Arrange and Act
    Class<?> actualInputType = OperationUtil.getInputType(new GenerateSplitPointsFromSample());

    // Assert
    Class<Iterable> expectedInputType = Iterable.class;
    assertEquals(expectedInputType, actualInputType);
  }

  /**
   * Test {@link OperationUtil#getInputType(Input)} with {@code Input}.
   *
   * <ul>
   *   <li>When {@link GenericInputImpl#GenericInputImpl()}.
   *   <li>Then return {@link Object}.
   * </ul>
   *
   * <p>Method under test: {@link OperationUtil#getInputType(Input)}
   */
  @Test
  @DisplayName("Test getInputType(Input) with 'Input'; when GenericInputImpl(); then return Object")
  @Tag("MaintainedByDiffblue")
  void testGetInputTypeWithInput_whenGenericInputImpl_thenReturnObject() {
    // Arrange and Act
    Class<?> actualInputType = OperationUtil.getInputType(new GenericInputImpl());

    // Assert
    Class<Object> expectedInputType = Object.class;
    assertEquals(expectedInputType, actualInputType);
  }

  /**
   * Test {@link OperationUtil#getInputType(Input)} with {@code Input}.
   *
   * <ul>
   *   <li>When {@link Map#Map()}.
   *   <li>Then return {@link UnknownGenericType}.
   * </ul>
   *
   * <p>Method under test: {@link OperationUtil#getInputType(Input)}
   */
  @Test
  @DisplayName("Test getInputType(Input) with 'Input'; when Map(); then return UnknownGenericType")
  @Tag("MaintainedByDiffblue")
  void testGetInputTypeWithInput_whenMap_thenReturnUnknownGenericType() {
    // Arrange and Act
    Class<?> actualInputType = OperationUtil.getInputType(new Map());

    // Assert
    Class<UnknownGenericType> expectedInputType = UnknownGenericType.class;
    assertEquals(expectedInputType, actualInputType);
  }

  /**
   * Test {@link OperationUtil#getOutputType(Class)} with {@code Class}.
   *
   * <ul>
   *   <li>Then return {@link UnknownGenericType}.
   * </ul>
   *
   * <p>Method under test: {@link OperationUtil#getOutputType(Class)}
   */
  @Test
  @DisplayName("Test getOutputType(Class) with 'Class'; then return UnknownGenericType")
  @Tag("MaintainedByDiffblue")
  void testGetOutputTypeWithClass_thenReturnUnknownGenericType() {
    // Arrange
    Class<Output> output = Output.class;

    // Act
    Class<?> actualOutputType = OperationUtil.getOutputType(output);

    // Assert
    Class<UnknownGenericType> expectedOutputType = UnknownGenericType.class;
    assertEquals(expectedOutputType, actualOutputType);
  }

  /**
   * Test {@link OperationUtil#getOutputType(Output)} with {@code Output}.
   *
   * <ul>
   *   <li>When {@link GenerateSplitPointsFromSample} (default constructor).
   *   <li>Then return {@link List}.
   * </ul>
   *
   * <p>Method under test: {@link OperationUtil#getOutputType(Output)}
   */
  @Test
  @DisplayName(
      "Test getOutputType(Output) with 'Output'; when GenerateSplitPointsFromSample (default constructor); then return List")
  @Tag("MaintainedByDiffblue")
  void testGetOutputTypeWithOutput_whenGenerateSplitPointsFromSample_thenReturnList() {
    // Arrange and Act
    Class<?> actualOutputType = OperationUtil.getOutputType(new GenerateSplitPointsFromSample<>());

    // Assert
    Class<List> expectedOutputType = List.class;
    assertEquals(expectedOutputType, actualOutputType);
  }

  /**
   * Test {@link OperationUtil#getOutputType(Output)} with {@code Output}.
   *
   * <ul>
   *   <li>When wrap wrap {@link NamedOperation} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link OperationUtil#getOutputType(Output)}
   */
  @Test
  @DisplayName(
      "Test getOutputType(Output) with 'Output'; when wrap wrap NamedOperation (default constructor)")
  @Tag("MaintainedByDiffblue")
  void testGetOutputTypeWithOutput_whenWrapWrapNamedOperation() {
    // Arrange
    OperationChain<Object> operation = OperationChain.wrap(new NamedOperation<>());
    OperationChain<?> output = OperationChain.wrap(operation);

    // Act
    Class<?> actualOutputType = OperationUtil.getOutputType(output);

    // Assert
    Class<UnknownGenericType> expectedOutputType = UnknownGenericType.class;
    assertEquals(expectedOutputType, actualOutputType);
  }

  /**
   * Test {@link OperationUtil#getOutputType(Output)} with {@code Output}.
   *
   * <ul>
   *   <li>When wrap wrap {@link OperationChainDAO#OperationChainDAO()}.
   * </ul>
   *
   * <p>Method under test: {@link OperationUtil#getOutputType(Output)}
   */
  @Test
  @DisplayName("Test getOutputType(Output) with 'Output'; when wrap wrap OperationChainDAO()")
  @Tag("MaintainedByDiffblue")
  void testGetOutputTypeWithOutput_whenWrapWrapOperationChainDAO() {
    // Arrange
    OperationChain<Object> operation = OperationChain.wrap(new OperationChainDAO<>());
    OperationChain<?> output = OperationChain.wrap(operation);

    // Act
    Class<?> actualOutputType = OperationUtil.getOutputType(output);

    // Assert
    Class<UnknownGenericType> expectedOutputType = UnknownGenericType.class;
    assertEquals(expectedOutputType, actualOutputType);
  }

  /**
   * Test {@link OperationUtil#isValid(Class, Class)}.
   *
   * <ul>
   *   <li>When {@code Class}.
   *   <li>Then return ErrorString is a string.
   * </ul>
   *
   * <p>Method under test: {@link OperationUtil#isValid(Class, Class)}
   */
  @Test
  @DisplayName(
      "Test isValid(Class, Class); when 'java.lang.Class'; then return ErrorString is a string")
  @Tag("MaintainedByDiffblue")
  void testIsValid_whenJavaLangClass_thenReturnErrorStringIsAString() {
    // Arrange
    Class<Object> output = Object.class;
    Class<Class> input = Class.class;

    // Act
    ValidationResult actualIsValidResult = OperationUtil.isValid(output, input);

    // Assert
    assertEquals(
        "Validation errors: \n"
            + "Incompatible output, input types. class java.lang.Object: java.lang.Object, input: java.lang.Class",
        actualIsValidResult.getErrorString());
    Set<String> errors = actualIsValidResult.getErrors();
    assertEquals(1, errors.size());
    assertFalse(actualIsValidResult.isValid());
    assertTrue(
        errors.contains(
            "Incompatible output, input types. class java.lang.Object: java.lang.Object, input: java.lang.Class"));
  }

  /**
   * Test {@link OperationUtil#isValid(Class, Class)}.
   *
   * <ul>
   *   <li>When {@code Object}.
   *   <li>Then return ErrorString is {@code Validation errors:}.
   * </ul>
   *
   * <p>Method under test: {@link OperationUtil#isValid(Class, Class)}
   */
  @Test
  @DisplayName(
      "Test isValid(Class, Class); when 'java.lang.Object'; then return ErrorString is 'Validation errors:'")
  @Tag("MaintainedByDiffblue")
  void testIsValid_whenJavaLangObject_thenReturnErrorStringIsValidationErrors() {
    // Arrange
    Class<Object> output = Object.class;
    Class<Object> input = Object.class;

    // Act
    ValidationResult actualIsValidResult = OperationUtil.isValid(output, input);

    // Assert
    assertEquals("Validation errors: \n", actualIsValidResult.getErrorString());
    assertTrue(actualIsValidResult.getErrors().isEmpty());
    assertTrue(actualIsValidResult.isValid());
  }

  /**
   * Test {@link OperationUtil#isValid(Class, Class)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return ErrorString is {@code Validation errors:}.
   * </ul>
   *
   * <p>Method under test: {@link OperationUtil#isValid(Class, Class)}
   */
  @Test
  @DisplayName(
      "Test isValid(Class, Class); when 'null'; then return ErrorString is 'Validation errors:'")
  @Tag("MaintainedByDiffblue")
  void testIsValid_whenNull_thenReturnErrorStringIsValidationErrors() {
    // Arrange and Act
    ValidationResult actualIsValidResult = OperationUtil.isValid(null, null);

    // Assert
    assertEquals("Validation errors: \n", actualIsValidResult.getErrorString());
    assertTrue(actualIsValidResult.getErrors().isEmpty());
    assertTrue(actualIsValidResult.isValid());
  }

  /**
   * Test {@link OperationUtil#isValid(Class, Class)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return ErrorString is {@code Validation errors:}.
   * </ul>
   *
   * <p>Method under test: {@link OperationUtil#isValid(Class, Class)}
   */
  @Test
  @DisplayName(
      "Test isValid(Class, Class); when 'null'; then return ErrorString is 'Validation errors:'")
  @Tag("MaintainedByDiffblue")
  void testIsValid_whenNull_thenReturnErrorStringIsValidationErrors2() {
    // Arrange
    Class<Object> input = Object.class;

    // Act
    ValidationResult actualIsValidResult = OperationUtil.isValid(null, input);

    // Assert
    assertEquals("Validation errors: \n", actualIsValidResult.getErrorString());
    assertTrue(actualIsValidResult.getErrors().isEmpty());
    assertTrue(actualIsValidResult.isValid());
  }

  /**
   * Test {@link OperationUtil#isValid(Class, Class)}.
   *
   * <ul>
   *   <li>When {@code OperationUtil$UnknownGenericType}.
   * </ul>
   *
   * <p>Method under test: {@link OperationUtil#isValid(Class, Class)}
   */
  @Test
  @DisplayName(
      "Test isValid(Class, Class); when 'uk.gov.gchq.gaffer.store.operation.OperationUtil$UnknownGenericType'")
  @Tag("MaintainedByDiffblue")
  void testIsValid_whenUkGovGchqGafferStoreOperationOperationUtilUnknownGenericType() {
    // Arrange
    Class<UnknownGenericType> output = UnknownGenericType.class;
    Class<Object> input = Object.class;

    // Act
    ValidationResult actualIsValidResult = OperationUtil.isValid(output, input);

    // Assert
    assertEquals("Validation errors: \n", actualIsValidResult.getErrorString());
    assertTrue(actualIsValidResult.getErrors().isEmpty());
    assertTrue(actualIsValidResult.isValid());
  }

  /**
   * Test {@link OperationUtil#isValid(Class, Class)}.
   *
   * <ul>
   *   <li>When {@code OperationUtil$UnknownGenericType}.
   * </ul>
   *
   * <p>Method under test: {@link OperationUtil#isValid(Class, Class)}
   */
  @Test
  @DisplayName(
      "Test isValid(Class, Class); when 'uk.gov.gchq.gaffer.store.operation.OperationUtil$UnknownGenericType'")
  @Tag("MaintainedByDiffblue")
  void testIsValid_whenUkGovGchqGafferStoreOperationOperationUtilUnknownGenericType2() {
    // Arrange
    Class<Object> output = Object.class;
    Class<UnknownGenericType> input = UnknownGenericType.class;

    // Act
    ValidationResult actualIsValidResult = OperationUtil.isValid(output, input);

    // Assert
    assertEquals("Validation errors: \n", actualIsValidResult.getErrorString());
    assertTrue(actualIsValidResult.getErrors().isEmpty());
    assertTrue(actualIsValidResult.isValid());
  }
}
