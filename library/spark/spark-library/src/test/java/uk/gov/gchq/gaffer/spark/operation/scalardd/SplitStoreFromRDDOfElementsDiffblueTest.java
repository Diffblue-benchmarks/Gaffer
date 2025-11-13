/*
 * Copyright 2025 Crown Copyright
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package uk.gov.gchq.gaffer.spark.operation.scalardd;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import org.apache.commons.lang3.exception.CloneFailedException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.operation.Operation;
import uk.gov.gchq.gaffer.spark.operation.scalardd.SplitStoreFromRDDOfElements.Builder;
import uk.gov.gchq.koryphe.ValidationResult;

class SplitStoreFromRDDOfElementsDiffblueTest {
  /**
   * Test Builder {@link Builder#fractionToSample(Double)}.
   *
   * <p>Method under test: {@link Builder#fractionToSample(Double)}
   */
  @Test
  @DisplayName("Test Builder fractionToSample(Double)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.fractionToSample(Double)"})
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.maxSampleSize(Integer)"})
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Builder.<init>()"})
  void testBuilderNewBuilder() {
    // Arrange and Act
    Builder actualBuilder = new Builder();

    // Assert
    SplitStoreFromRDDOfElements _getOpResult = actualBuilder._getOp();
    assertNull(_getOpResult.getFractionToSample());
    assertNull(_getOpResult.getMaxSampleSize());
    assertNull(_getOpResult.getNumSplits());
    assertNull(_getOpResult.getOptions());
    assertNull(_getOpResult.getInput());
    SplitStoreFromRDDOfElements actualSplitStoreFromRDDOfElements = actualBuilder.build();
    assertSame(_getOpResult, actualSplitStoreFromRDDOfElements);
  }

  /**
   * Test Builder {@link Builder#numSplits(Integer)}.
   *
   * <p>Method under test: {@link Builder#numSplits(Integer)}
   */
  @Test
  @DisplayName("Test Builder numSplits(Integer)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.numSplits(Integer)"})
  void testBuilderNumSplits() {
    // Arrange
    Builder builder = new Builder();

    // Act
    Builder actualNumSplitsResult = builder.numSplits(10);

    // Assert
    assertSame(builder, actualNumSplitsResult);
  }

  /**
   * Test {@link SplitStoreFromRDDOfElements#validate()}.
   *
   * <p>Method under test: {@link SplitStoreFromRDDOfElements#validate()}
   */
  @Test
  @DisplayName("Test validate()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ValidationResult SplitStoreFromRDDOfElements.validate()"})
  void testValidate() {
    // Arrange
    SplitStoreFromRDDOfElements splitStoreFromRDDOfElements = new SplitStoreFromRDDOfElements();
    splitStoreFromRDDOfElements.setFractionToSample(0.0d);
    splitStoreFromRDDOfElements.setMaxSampleSize(1);
    splitStoreFromRDDOfElements.setNumSplits(1);

    // Act
    ValidationResult actualValidateResult = splitStoreFromRDDOfElements.validate();

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
   * Test {@link SplitStoreFromRDDOfElements#validate()}.
   *
   * <ul>
   *   <li>Given {@link SplitStoreFromRDDOfElements} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link SplitStoreFromRDDOfElements#validate()}
   */
  @Test
  @DisplayName("Test validate(); given SplitStoreFromRDDOfElements (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ValidationResult SplitStoreFromRDDOfElements.validate()"})
  void testValidate_givenSplitStoreFromRDDOfElements() {
    // Arrange and Act
    ValidationResult actualValidateResult = new SplitStoreFromRDDOfElements().validate();

    // Assert
    assertEquals("Validation errors: \n", actualValidateResult.getErrorString());
    assertTrue(actualValidateResult.getErrors().isEmpty());
    assertTrue(actualValidateResult.isValid());
  }

  /**
   * Test {@link SplitStoreFromRDDOfElements#validate()}.
   *
   * <ul>
   *   <li>Given {@link SplitStoreFromRDDOfElements} (default constructor) FractionToSample is
   *       {@code 1.0E-10}.
   * </ul>
   *
   * <p>Method under test: {@link SplitStoreFromRDDOfElements#validate()}
   */
  @Test
  @DisplayName(
      "Test validate(); given SplitStoreFromRDDOfElements (default constructor) FractionToSample is '1.0E-10'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ValidationResult SplitStoreFromRDDOfElements.validate()"})
  void testValidate_givenSplitStoreFromRDDOfElementsFractionToSampleIs10e10() {
    // Arrange
    SplitStoreFromRDDOfElements splitStoreFromRDDOfElements = new SplitStoreFromRDDOfElements();
    splitStoreFromRDDOfElements.setFractionToSample(1.0E-10d);
    splitStoreFromRDDOfElements.setMaxSampleSize(1);
    splitStoreFromRDDOfElements.setNumSplits(1);

    // Act
    ValidationResult actualValidateResult = splitStoreFromRDDOfElements.validate();

    // Assert
    assertEquals("Validation errors: \n", actualValidateResult.getErrorString());
    assertTrue(actualValidateResult.getErrors().isEmpty());
    assertTrue(actualValidateResult.isValid());
  }

  /**
   * Test {@link SplitStoreFromRDDOfElements#validate()}.
   *
   * <ul>
   *   <li>Given {@link SplitStoreFromRDDOfElements} (default constructor) FractionToSample is
   *       {@code 1.0000000000000002}.
   * </ul>
   *
   * <p>Method under test: {@link SplitStoreFromRDDOfElements#validate()}
   */
  @Test
  @DisplayName(
      "Test validate(); given SplitStoreFromRDDOfElements (default constructor) FractionToSample is '1.0000000000000002'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ValidationResult SplitStoreFromRDDOfElements.validate()"})
  void testValidate_givenSplitStoreFromRDDOfElementsFractionToSampleIs10000000000000002() {
    // Arrange
    SplitStoreFromRDDOfElements splitStoreFromRDDOfElements = new SplitStoreFromRDDOfElements();
    splitStoreFromRDDOfElements.setFractionToSample(1.0000000000000002d);
    splitStoreFromRDDOfElements.setMaxSampleSize(1);
    splitStoreFromRDDOfElements.setNumSplits(1);

    // Act
    ValidationResult actualValidateResult = splitStoreFromRDDOfElements.validate();

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
   * Test {@link SplitStoreFromRDDOfElements#validate()}.
   *
   * <ul>
   *   <li>Then return Errors contains {@code maxSampleSize must be null or greater than 0}.
   * </ul>
   *
   * <p>Method under test: {@link SplitStoreFromRDDOfElements#validate()}
   */
  @Test
  @DisplayName(
      "Test validate(); then return Errors contains 'maxSampleSize must be null or greater than 0'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ValidationResult SplitStoreFromRDDOfElements.validate()"})
  void testValidate_thenReturnErrorsContainsMaxSampleSizeMustBeNullOrGreaterThan0() {
    // Arrange
    SplitStoreFromRDDOfElements splitStoreFromRDDOfElements = new SplitStoreFromRDDOfElements();
    splitStoreFromRDDOfElements.setFractionToSample(0.0d);
    splitStoreFromRDDOfElements.setMaxSampleSize(0);
    splitStoreFromRDDOfElements.setNumSplits(1);

    // Act
    ValidationResult actualValidateResult = splitStoreFromRDDOfElements.validate();

    // Assert
    assertEquals(
        "Validation errors: \n"
            + "fractionToSample must be null or between 0 exclusive and 1 inclusive\n"
            + "maxSampleSize must be null or greater than 0",
        actualValidateResult.getErrorString());
    Set<String> errors = actualValidateResult.getErrors();
    assertEquals(2, errors.size());
    assertFalse(actualValidateResult.isValid());
    assertTrue(
        errors.contains("fractionToSample must be null or between 0 exclusive and 1 inclusive"));
    assertTrue(errors.contains("maxSampleSize must be null or greater than 0"));
  }

  /**
   * Test {@link SplitStoreFromRDDOfElements#validate()}.
   *
   * <ul>
   *   <li>Then return Errors contains {@code numSplits must be null or greater than 0}.
   * </ul>
   *
   * <p>Method under test: {@link SplitStoreFromRDDOfElements#validate()}
   */
  @Test
  @DisplayName(
      "Test validate(); then return Errors contains 'numSplits must be null or greater than 0'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ValidationResult SplitStoreFromRDDOfElements.validate()"})
  void testValidate_thenReturnErrorsContainsNumSplitsMustBeNullOrGreaterThan0() {
    // Arrange
    SplitStoreFromRDDOfElements splitStoreFromRDDOfElements = new SplitStoreFromRDDOfElements();
    splitStoreFromRDDOfElements.setFractionToSample(0.0d);
    splitStoreFromRDDOfElements.setMaxSampleSize(1);
    splitStoreFromRDDOfElements.setNumSplits(0);

    // Act
    ValidationResult actualValidateResult = splitStoreFromRDDOfElements.validate();

    // Assert
    assertEquals(
        "Validation errors: \n"
            + "fractionToSample must be null or between 0 exclusive and 1 inclusive\n"
            + "numSplits must be null or greater than 0",
        actualValidateResult.getErrorString());
    Set<String> errors = actualValidateResult.getErrors();
    assertEquals(2, errors.size());
    assertFalse(actualValidateResult.isValid());
    assertTrue(
        errors.contains("fractionToSample must be null or between 0 exclusive and 1 inclusive"));
    assertTrue(errors.contains("numSplits must be null or greater than 0"));
  }

  /**
   * Test {@link SplitStoreFromRDDOfElements#getInput()}.
   *
   * <p>Method under test: {@link SplitStoreFromRDDOfElements#getInput()}
   */
  @Test
  @DisplayName("Test getInput()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"org.apache.spark.rdd.RDD SplitStoreFromRDDOfElements.getInput()"})
  void testGetInput() {
    // Arrange, Act and Assert
    assertNull(new SplitStoreFromRDDOfElements().getInput());
  }

  /**
   * Test {@link SplitStoreFromRDDOfElements#shallowClone()}.
   *
   * <ul>
   *   <li>Given {@link SplitStoreFromRDDOfElements} (default constructor).
   *   <li>Then return Options is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link SplitStoreFromRDDOfElements#shallowClone()}
   */
  @Test
  @DisplayName(
      "Test shallowClone(); given SplitStoreFromRDDOfElements (default constructor); then return Options is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Operation SplitStoreFromRDDOfElements.shallowClone()"})
  void testShallowClone_givenSplitStoreFromRDDOfElements_thenReturnOptionsIsNull()
      throws CloneFailedException {
    // Arrange and Act
    Operation actualShallowCloneResult = new SplitStoreFromRDDOfElements().shallowClone();

    // Assert
    assertTrue(actualShallowCloneResult instanceof SplitStoreFromRDDOfElements);
    assertNull(((SplitStoreFromRDDOfElements) actualShallowCloneResult).getFractionToSample());
    assertNull(((SplitStoreFromRDDOfElements) actualShallowCloneResult).getMaxSampleSize());
    assertNull(((SplitStoreFromRDDOfElements) actualShallowCloneResult).getNumSplits());
    assertNull(actualShallowCloneResult.getOptions());
    assertNull(((SplitStoreFromRDDOfElements) actualShallowCloneResult).getInput());
  }

  /**
   * Test {@link SplitStoreFromRDDOfElements#shallowClone()}.
   *
   * <ul>
   *   <li>Then return Options Empty.
   * </ul>
   *
   * <p>Method under test: {@link SplitStoreFromRDDOfElements#shallowClone()}
   */
  @Test
  @DisplayName("Test shallowClone(); then return Options Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Operation SplitStoreFromRDDOfElements.shallowClone()"})
  void testShallowClone_thenReturnOptionsEmpty() throws CloneFailedException {
    // Arrange
    SplitStoreFromRDDOfElements splitStoreFromRDDOfElements = new SplitStoreFromRDDOfElements();
    splitStoreFromRDDOfElements.setOptions(new HashMap<>());

    // Act
    Operation actualShallowCloneResult = splitStoreFromRDDOfElements.shallowClone();

    // Assert
    assertTrue(actualShallowCloneResult instanceof SplitStoreFromRDDOfElements);
    assertNull(((SplitStoreFromRDDOfElements) actualShallowCloneResult).getFractionToSample());
    assertNull(((SplitStoreFromRDDOfElements) actualShallowCloneResult).getMaxSampleSize());
    assertNull(((SplitStoreFromRDDOfElements) actualShallowCloneResult).getNumSplits());
    assertNull(((SplitStoreFromRDDOfElements) actualShallowCloneResult).getInput());
    assertTrue(actualShallowCloneResult.getOptions().isEmpty());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link SplitStoreFromRDDOfElements}
   *   <li>{@link SplitStoreFromRDDOfElements#setFractionToSample(Double)}
   *   <li>{@link SplitStoreFromRDDOfElements#setMaxSampleSize(Integer)}
   *   <li>{@link SplitStoreFromRDDOfElements#setNumSplits(Integer)}
   *   <li>{@link SplitStoreFromRDDOfElements#setOptions(Map)}
   *   <li>{@link SplitStoreFromRDDOfElements#getFractionToSample()}
   *   <li>{@link SplitStoreFromRDDOfElements#getMaxSampleSize()}
   *   <li>{@link SplitStoreFromRDDOfElements#getNumSplits()}
   *   <li>{@link SplitStoreFromRDDOfElements#getOptions()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void SplitStoreFromRDDOfElements.<init>()",
    "Double SplitStoreFromRDDOfElements.getFractionToSample()",
    "Integer SplitStoreFromRDDOfElements.getMaxSampleSize()",
    "Integer SplitStoreFromRDDOfElements.getNumSplits()",
    "Map SplitStoreFromRDDOfElements.getOptions()",
    "void SplitStoreFromRDDOfElements.setFractionToSample(Double)",
    "void SplitStoreFromRDDOfElements.setInput(org.apache.spark.rdd.RDD)",
    "void SplitStoreFromRDDOfElements.setMaxSampleSize(Integer)",
    "void SplitStoreFromRDDOfElements.setNumSplits(Integer)",
    "void SplitStoreFromRDDOfElements.setOptions(Map)"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    SplitStoreFromRDDOfElements actualSplitStoreFromRDDOfElements =
        new SplitStoreFromRDDOfElements();
    actualSplitStoreFromRDDOfElements.setFractionToSample(10.0d);
    actualSplitStoreFromRDDOfElements.setMaxSampleSize(3);
    actualSplitStoreFromRDDOfElements.setNumSplits(10);
    HashMap<String, String> options = new HashMap<>();
    actualSplitStoreFromRDDOfElements.setOptions(options);
    Double actualFractionToSample = actualSplitStoreFromRDDOfElements.getFractionToSample();
    Integer actualMaxSampleSize = actualSplitStoreFromRDDOfElements.getMaxSampleSize();
    Integer actualNumSplits = actualSplitStoreFromRDDOfElements.getNumSplits();
    Map<String, String> actualOptions = actualSplitStoreFromRDDOfElements.getOptions();

    // Assert
    assertNull(actualSplitStoreFromRDDOfElements.getInput());
    assertEquals(10, actualNumSplits.intValue());
    assertEquals(10.0d, actualFractionToSample.doubleValue());
    assertEquals(3, actualMaxSampleSize.intValue());
    assertTrue(actualOptions.isEmpty());
    assertSame(options, actualOptions);
  }
}
