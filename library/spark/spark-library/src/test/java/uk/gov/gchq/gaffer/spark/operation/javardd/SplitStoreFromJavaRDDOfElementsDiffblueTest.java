package uk.gov.gchq.gaffer.spark.operation.javardd;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import org.apache.commons.lang3.exception.CloneFailedException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.operation.Operation;
import uk.gov.gchq.gaffer.spark.operation.javardd.SplitStoreFromJavaRDDOfElements.Builder;
import uk.gov.gchq.koryphe.ValidationResult;

class SplitStoreFromJavaRDDOfElementsDiffblueTest {
  /**
   * Test Builder {@link Builder#fractionToSample(Double)}.
   *
   * <p>Method under test: {@link Builder#fractionToSample(Double)}
   */
  @Test
  @DisplayName("Test Builder fractionToSample(Double)")
  @Tag("MaintainedByDiffblue")
  void testBuilderFractionToSample() {
    // Arrange
    Builder builder = new Builder();

    // Act
    Builder actualFractionToSampleResult = builder.fractionToSample(10.0d);

    // Assert
    assertSame(builder, actualFractionToSampleResult);
  }

  /**
   * Test Builder {@link Builder#maxSampleSize(Integer)}.
   *
   * <p>Method under test: {@link Builder#maxSampleSize(Integer)}
   */
  @Test
  @DisplayName("Test Builder maxSampleSize(Integer)")
  @Tag("MaintainedByDiffblue")
  void testBuilderMaxSampleSize() {
    // Arrange
    Builder builder = new Builder();

    // Act
    Builder actualMaxSampleSizeResult = builder.maxSampleSize(3);

    // Assert
    assertSame(builder, actualMaxSampleSizeResult);
  }

  /**
   * Test Builder new {@link Builder} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link Builder}
   */
  @Test
  @DisplayName("Test Builder new Builder (default constructor)")
  @Tag("MaintainedByDiffblue")
  void testBuilderNewBuilder() {
    // Arrange and Act
    Builder actualBuilder = new Builder();

    // Assert
    SplitStoreFromJavaRDDOfElements _getOpResult = actualBuilder._getOp();
    assertNull(_getOpResult.getFractionToSample());
    assertNull(_getOpResult.getMaxSampleSize());
    assertNull(_getOpResult.getNumSplits());
    assertNull(_getOpResult.getOptions());
    assertNull(_getOpResult.getInput());
    SplitStoreFromJavaRDDOfElements actualSplitStoreFromJavaRDDOfElements = actualBuilder.build();
    assertSame(_getOpResult, actualSplitStoreFromJavaRDDOfElements);
  }

  /**
   * Test Builder {@link Builder#numSplits(Integer)}.
   *
   * <p>Method under test: {@link Builder#numSplits(Integer)}
   */
  @Test
  @DisplayName("Test Builder numSplits(Integer)")
  @Tag("MaintainedByDiffblue")
  void testBuilderNumSplits() {
    // Arrange
    Builder builder = new Builder();

    // Act
    Builder actualNumSplitsResult = builder.numSplits(10);

    // Assert
    assertSame(builder, actualNumSplitsResult);
  }

  /**
   * Test {@link SplitStoreFromJavaRDDOfElements#validate()}.
   *
   * <p>Method under test: {@link SplitStoreFromJavaRDDOfElements#validate()}
   */
  @Test
  @DisplayName("Test validate()")
  @Tag("MaintainedByDiffblue")
  void testValidate() {
    // Arrange
    SplitStoreFromJavaRDDOfElements splitStoreFromJavaRDDOfElements =
        new SplitStoreFromJavaRDDOfElements();
    splitStoreFromJavaRDDOfElements.setFractionToSample(null);
    splitStoreFromJavaRDDOfElements.setMaxSampleSize(null);
    splitStoreFromJavaRDDOfElements.setNumSplits(0);

    // Act
    ValidationResult actualValidateResult = splitStoreFromJavaRDDOfElements.validate();

    // Assert
    assertEquals(
        "Validation errors: \nnumSplits must be null or greater than 0",
        actualValidateResult.getErrorString());
    Set<String> errors = actualValidateResult.getErrors();
    assertEquals(1, errors.size());
    assertFalse(actualValidateResult.isValid());
    assertTrue(errors.contains("numSplits must be null or greater than 0"));
  }

  /**
   * Test {@link SplitStoreFromJavaRDDOfElements#validate()}.
   *
   * <p>Method under test: {@link SplitStoreFromJavaRDDOfElements#validate()}
   */
  @Test
  @DisplayName("Test validate()")
  @Tag("MaintainedByDiffblue")
  void testValidate2() {
    // Arrange
    SplitStoreFromJavaRDDOfElements splitStoreFromJavaRDDOfElements =
        new SplitStoreFromJavaRDDOfElements();
    splitStoreFromJavaRDDOfElements.setFractionToSample(null);
    splitStoreFromJavaRDDOfElements.setMaxSampleSize(0);
    splitStoreFromJavaRDDOfElements.setNumSplits(null);

    // Act
    ValidationResult actualValidateResult = splitStoreFromJavaRDDOfElements.validate();

    // Assert
    assertEquals(
        "Validation errors: \nmaxSampleSize must be null or greater than 0",
        actualValidateResult.getErrorString());
    Set<String> errors = actualValidateResult.getErrors();
    assertEquals(1, errors.size());
    assertFalse(actualValidateResult.isValid());
    assertTrue(errors.contains("maxSampleSize must be null or greater than 0"));
  }

  /**
   * Test {@link SplitStoreFromJavaRDDOfElements#validate()}.
   *
   * <ul>
   *   <li>Given {@link SplitStoreFromJavaRDDOfElements} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link SplitStoreFromJavaRDDOfElements#validate()}
   */
  @Test
  @DisplayName("Test validate(); given SplitStoreFromJavaRDDOfElements (default constructor)")
  @Tag("MaintainedByDiffblue")
  void testValidate_givenSplitStoreFromJavaRDDOfElements() {
    // Arrange and Act
    ValidationResult actualValidateResult = new SplitStoreFromJavaRDDOfElements().validate();

    // Assert
    assertEquals("Validation errors: \n", actualValidateResult.getErrorString());
    assertTrue(actualValidateResult.getErrors().isEmpty());
    assertTrue(actualValidateResult.isValid());
  }

  /**
   * Test {@link SplitStoreFromJavaRDDOfElements#validate()}.
   *
   * <ul>
   *   <li>Given {@link SplitStoreFromJavaRDDOfElements} (default constructor) FractionToSample is
   *       {@code 1.0E-10}.
   * </ul>
   *
   * <p>Method under test: {@link SplitStoreFromJavaRDDOfElements#validate()}
   */
  @Test
  @DisplayName(
      "Test validate(); given SplitStoreFromJavaRDDOfElements (default constructor) FractionToSample is '1.0E-10'")
  @Tag("MaintainedByDiffblue")
  void testValidate_givenSplitStoreFromJavaRDDOfElementsFractionToSampleIs10e10() {
    // Arrange
    SplitStoreFromJavaRDDOfElements splitStoreFromJavaRDDOfElements =
        new SplitStoreFromJavaRDDOfElements();
    splitStoreFromJavaRDDOfElements.setFractionToSample(1.0E-10d);
    splitStoreFromJavaRDDOfElements.setMaxSampleSize(null);
    splitStoreFromJavaRDDOfElements.setNumSplits(null);

    // Act
    ValidationResult actualValidateResult = splitStoreFromJavaRDDOfElements.validate();

    // Assert
    assertEquals("Validation errors: \n", actualValidateResult.getErrorString());
    assertTrue(actualValidateResult.getErrors().isEmpty());
    assertTrue(actualValidateResult.isValid());
  }

  /**
   * Test {@link SplitStoreFromJavaRDDOfElements#validate()}.
   *
   * <ul>
   *   <li>Given {@link SplitStoreFromJavaRDDOfElements} (default constructor) FractionToSample is
   *       ten.
   * </ul>
   *
   * <p>Method under test: {@link SplitStoreFromJavaRDDOfElements#validate()}
   */
  @Test
  @DisplayName(
      "Test validate(); given SplitStoreFromJavaRDDOfElements (default constructor) FractionToSample is ten")
  @Tag("MaintainedByDiffblue")
  void testValidate_givenSplitStoreFromJavaRDDOfElementsFractionToSampleIsTen() {
    // Arrange
    SplitStoreFromJavaRDDOfElements splitStoreFromJavaRDDOfElements =
        new SplitStoreFromJavaRDDOfElements();
    splitStoreFromJavaRDDOfElements.setFractionToSample(10.0d);

    // Act
    ValidationResult actualValidateResult = splitStoreFromJavaRDDOfElements.validate();

    // Assert
    assertEquals(
        "Validation errors: \nfractionToSample must be null or between 0 exclusive and 1 inclusive",
        actualValidateResult.getErrorString());
    Set<String> errors = actualValidateResult.getErrors();
    assertEquals(1, errors.size());
    assertFalse(actualValidateResult.isValid());
    assertTrue(
        errors.contains("fractionToSample must be null or between 0 exclusive and 1 inclusive"));
  }

  /**
   * Test {@link SplitStoreFromJavaRDDOfElements#validate()}.
   *
   * <ul>
   *   <li>Given {@link SplitStoreFromJavaRDDOfElements} (default constructor) FractionToSample is
   *       zero.
   * </ul>
   *
   * <p>Method under test: {@link SplitStoreFromJavaRDDOfElements#validate()}
   */
  @Test
  @DisplayName(
      "Test validate(); given SplitStoreFromJavaRDDOfElements (default constructor) FractionToSample is zero")
  @Tag("MaintainedByDiffblue")
  void testValidate_givenSplitStoreFromJavaRDDOfElementsFractionToSampleIsZero() {
    // Arrange
    SplitStoreFromJavaRDDOfElements splitStoreFromJavaRDDOfElements =
        new SplitStoreFromJavaRDDOfElements();
    splitStoreFromJavaRDDOfElements.setFractionToSample(0.0d);
    splitStoreFromJavaRDDOfElements.setMaxSampleSize(null);
    splitStoreFromJavaRDDOfElements.setNumSplits(null);

    // Act
    ValidationResult actualValidateResult = splitStoreFromJavaRDDOfElements.validate();

    // Assert
    assertEquals(
        "Validation errors: \nfractionToSample must be null or between 0 exclusive and 1 inclusive",
        actualValidateResult.getErrorString());
    Set<String> errors = actualValidateResult.getErrors();
    assertEquals(1, errors.size());
    assertFalse(actualValidateResult.isValid());
    assertTrue(
        errors.contains("fractionToSample must be null or between 0 exclusive and 1 inclusive"));
  }

  /**
   * Test {@link SplitStoreFromJavaRDDOfElements#validate()}.
   *
   * <ul>
   *   <li>Given {@link SplitStoreFromJavaRDDOfElements} (default constructor) MaxSampleSize is one.
   * </ul>
   *
   * <p>Method under test: {@link SplitStoreFromJavaRDDOfElements#validate()}
   */
  @Test
  @DisplayName(
      "Test validate(); given SplitStoreFromJavaRDDOfElements (default constructor) MaxSampleSize is one")
  @Tag("MaintainedByDiffblue")
  void testValidate_givenSplitStoreFromJavaRDDOfElementsMaxSampleSizeIsOne() {
    // Arrange
    SplitStoreFromJavaRDDOfElements splitStoreFromJavaRDDOfElements =
        new SplitStoreFromJavaRDDOfElements();
    splitStoreFromJavaRDDOfElements.setFractionToSample(null);
    splitStoreFromJavaRDDOfElements.setMaxSampleSize(1);
    splitStoreFromJavaRDDOfElements.setNumSplits(null);

    // Act
    ValidationResult actualValidateResult = splitStoreFromJavaRDDOfElements.validate();

    // Assert
    assertEquals("Validation errors: \n", actualValidateResult.getErrorString());
    assertTrue(actualValidateResult.getErrors().isEmpty());
    assertTrue(actualValidateResult.isValid());
  }

  /**
   * Test {@link SplitStoreFromJavaRDDOfElements#validate()}.
   *
   * <ul>
   *   <li>Given {@link SplitStoreFromJavaRDDOfElements} (default constructor) NumSplits is one.
   * </ul>
   *
   * <p>Method under test: {@link SplitStoreFromJavaRDDOfElements#validate()}
   */
  @Test
  @DisplayName(
      "Test validate(); given SplitStoreFromJavaRDDOfElements (default constructor) NumSplits is one")
  @Tag("MaintainedByDiffblue")
  void testValidate_givenSplitStoreFromJavaRDDOfElementsNumSplitsIsOne() {
    // Arrange
    SplitStoreFromJavaRDDOfElements splitStoreFromJavaRDDOfElements =
        new SplitStoreFromJavaRDDOfElements();
    splitStoreFromJavaRDDOfElements.setFractionToSample(null);
    splitStoreFromJavaRDDOfElements.setMaxSampleSize(null);
    splitStoreFromJavaRDDOfElements.setNumSplits(1);

    // Act
    ValidationResult actualValidateResult = splitStoreFromJavaRDDOfElements.validate();

    // Assert
    assertEquals("Validation errors: \n", actualValidateResult.getErrorString());
    assertTrue(actualValidateResult.getErrors().isEmpty());
    assertTrue(actualValidateResult.isValid());
  }

  /**
   * Test {@link SplitStoreFromJavaRDDOfElements#getInput()}.
   *
   * <p>Method under test: {@link SplitStoreFromJavaRDDOfElements#getInput()}
   */
  @Test
  @DisplayName("Test getInput()")
  @Tag("MaintainedByDiffblue")
  void testGetInput() {
    // Arrange, Act and Assert
    assertNull(new SplitStoreFromJavaRDDOfElements().getInput());
  }

  /**
   * Test {@link SplitStoreFromJavaRDDOfElements#shallowClone()}.
   *
   * <ul>
   *   <li>Given {@link SplitStoreFromJavaRDDOfElements} (default constructor).
   *   <li>Then return Options is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link SplitStoreFromJavaRDDOfElements#shallowClone()}
   */
  @Test
  @DisplayName(
      "Test shallowClone(); given SplitStoreFromJavaRDDOfElements (default constructor); then return Options is 'null'")
  @Tag("MaintainedByDiffblue")
  void testShallowClone_givenSplitStoreFromJavaRDDOfElements_thenReturnOptionsIsNull()
      throws CloneFailedException {
    // Arrange and Act
    Operation actualShallowCloneResult = new SplitStoreFromJavaRDDOfElements().shallowClone();

    // Assert
    assertTrue(actualShallowCloneResult instanceof SplitStoreFromJavaRDDOfElements);
    assertNull(((SplitStoreFromJavaRDDOfElements) actualShallowCloneResult).getFractionToSample());
    assertNull(((SplitStoreFromJavaRDDOfElements) actualShallowCloneResult).getMaxSampleSize());
    assertNull(((SplitStoreFromJavaRDDOfElements) actualShallowCloneResult).getNumSplits());
    assertNull(actualShallowCloneResult.getOptions());
    assertNull(((SplitStoreFromJavaRDDOfElements) actualShallowCloneResult).getInput());
  }

  /**
   * Test {@link SplitStoreFromJavaRDDOfElements#shallowClone()}.
   *
   * <ul>
   *   <li>Then return Options Empty.
   * </ul>
   *
   * <p>Method under test: {@link SplitStoreFromJavaRDDOfElements#shallowClone()}
   */
  @Test
  @DisplayName("Test shallowClone(); then return Options Empty")
  @Tag("MaintainedByDiffblue")
  void testShallowClone_thenReturnOptionsEmpty() throws CloneFailedException {
    // Arrange
    SplitStoreFromJavaRDDOfElements splitStoreFromJavaRDDOfElements =
        new SplitStoreFromJavaRDDOfElements();
    splitStoreFromJavaRDDOfElements.setOptions(new HashMap<>());

    // Act
    Operation actualShallowCloneResult = splitStoreFromJavaRDDOfElements.shallowClone();

    // Assert
    assertTrue(actualShallowCloneResult instanceof SplitStoreFromJavaRDDOfElements);
    assertNull(((SplitStoreFromJavaRDDOfElements) actualShallowCloneResult).getFractionToSample());
    assertNull(((SplitStoreFromJavaRDDOfElements) actualShallowCloneResult).getMaxSampleSize());
    assertNull(((SplitStoreFromJavaRDDOfElements) actualShallowCloneResult).getNumSplits());
    assertNull(((SplitStoreFromJavaRDDOfElements) actualShallowCloneResult).getInput());
    assertTrue(actualShallowCloneResult.getOptions().isEmpty());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link SplitStoreFromJavaRDDOfElements}
   *   <li>{@link SplitStoreFromJavaRDDOfElements#setFractionToSample(Double)}
   *   <li>{@link SplitStoreFromJavaRDDOfElements#setMaxSampleSize(Integer)}
   *   <li>{@link SplitStoreFromJavaRDDOfElements#setNumSplits(Integer)}
   *   <li>{@link SplitStoreFromJavaRDDOfElements#setOptions(Map)}
   *   <li>{@link SplitStoreFromJavaRDDOfElements#getFractionToSample()}
   *   <li>{@link SplitStoreFromJavaRDDOfElements#getMaxSampleSize()}
   *   <li>{@link SplitStoreFromJavaRDDOfElements#getNumSplits()}
   *   <li>{@link SplitStoreFromJavaRDDOfElements#getOptions()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  void testGettersAndSetters() {
    // Arrange and Act
    SplitStoreFromJavaRDDOfElements actualSplitStoreFromJavaRDDOfElements =
        new SplitStoreFromJavaRDDOfElements();
    actualSplitStoreFromJavaRDDOfElements.setFractionToSample(10.0d);
    actualSplitStoreFromJavaRDDOfElements.setMaxSampleSize(3);
    actualSplitStoreFromJavaRDDOfElements.setNumSplits(10);
    HashMap<String, String> options = new HashMap<>();
    actualSplitStoreFromJavaRDDOfElements.setOptions(options);
    Double actualFractionToSample = actualSplitStoreFromJavaRDDOfElements.getFractionToSample();
    Integer actualMaxSampleSize = actualSplitStoreFromJavaRDDOfElements.getMaxSampleSize();
    Integer actualNumSplits = actualSplitStoreFromJavaRDDOfElements.getNumSplits();
    Map<String, String> actualOptions = actualSplitStoreFromJavaRDDOfElements.getOptions();

    // Assert
    assertNull(actualSplitStoreFromJavaRDDOfElements.getInput());
    assertEquals(10, actualNumSplits.intValue());
    assertEquals(10.0d, actualFractionToSample.doubleValue());
    assertEquals(3, actualMaxSampleSize.intValue());
    assertTrue(actualOptions.isEmpty());
    assertSame(options, actualOptions);
  }
}
