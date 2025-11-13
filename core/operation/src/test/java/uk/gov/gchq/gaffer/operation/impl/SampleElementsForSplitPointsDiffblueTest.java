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

package uk.gov.gchq.gaffer.operation.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.core.type.TypeReference;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.data.element.Element;
import uk.gov.gchq.gaffer.operation.impl.SampleElementsForSplitPoints.Builder;
import uk.gov.gchq.gaffer.operation.serialisation.TypeReferenceImpl;
import uk.gov.gchq.koryphe.ValidationResult;

class SampleElementsForSplitPointsDiffblueTest {
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
    Builder<Object> actualBuilder = new Builder<>();

    // Assert
    SampleElementsForSplitPoints<Object> _getOpResult = actualBuilder._getOp();
    TypeReference<List<Object>> outputTypeReference = _getOpResult.getOutputTypeReference();
    assertTrue(outputTypeReference instanceof TypeReferenceImpl.List);
    Type outputType = _getOpResult.getOutputType();
    assertEquals("java.util.List<T>", outputType.getTypeName());
    assertNull(_getOpResult.getNumSplits());
    assertNull(_getOpResult.getInput());
    assertNull(_getOpResult.getOptions());
    assertEquals(1.0f, _getOpResult.getProportionToSample());
    Class<List> expectedOutputClass = List.class;
    assertEquals(expectedOutputClass, _getOpResult.getOutputClass());
    SampleElementsForSplitPoints<Object> actualSampleElementsForSplitPoints = actualBuilder.build();
    assertSame(_getOpResult, actualSampleElementsForSplitPoints);
    assertSame(outputType, outputTypeReference.getType());
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
    Builder<Object> builder = new Builder<>();

    // Act
    Builder<Object> actualNumSplitsResult = builder.numSplits(10);

    // Assert
    assertSame(builder, actualNumSplitsResult);
  }

  /**
   * Test Builder {@link Builder#proportionToSample(float)}.
   *
   * <p>Method under test: {@link Builder#proportionToSample(float)}
   */
  @Test
  @DisplayName("Test Builder proportionToSample(float)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.proportionToSample(float)"})
  void testBuilderProportionToSample() {
    // Arrange
    Builder<Object> builder = new Builder<>();

    // Act
    Builder<Object> actualProportionToSampleResult = builder.proportionToSample(10.0f);

    // Assert
    assertSame(builder, actualProportionToSampleResult);
  }

  /**
   * Test {@link SampleElementsForSplitPoints#validate()}.
   *
   * <p>Method under test: {@link SampleElementsForSplitPoints#validate()}
   */
  @Test
  @DisplayName("Test validate()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ValidationResult SampleElementsForSplitPoints.validate()"})
  void testValidate() {
    // Arrange
    SampleElementsForSplitPoints<Object> sampleElementsForSplitPoints =
        new SampleElementsForSplitPoints<>();
    sampleElementsForSplitPoints.setNumSplits(0);
    sampleElementsForSplitPoints.setProportionToSample(1.0f);

    // Act
    ValidationResult actualValidateResult = sampleElementsForSplitPoints.validate();

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
   * Test {@link SampleElementsForSplitPoints#validate()}.
   *
   * <ul>
   *   <li>Given {@link SampleElementsForSplitPoints} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link SampleElementsForSplitPoints#validate()}
   */
  @Test
  @DisplayName("Test validate(); given SampleElementsForSplitPoints (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ValidationResult SampleElementsForSplitPoints.validate()"})
  void testValidate_givenSampleElementsForSplitPoints() {
    // Arrange
    SampleElementsForSplitPoints<Object> sampleElementsForSplitPoints =
        new SampleElementsForSplitPoints<>();

    // Act
    ValidationResult actualValidateResult = sampleElementsForSplitPoints.validate();

    // Assert
    assertEquals("Validation errors: \n", actualValidateResult.getErrorString());
    assertTrue(actualValidateResult.getErrors().isEmpty());
    assertTrue(actualValidateResult.isValid());
  }

  /**
   * Test {@link SampleElementsForSplitPoints#validate()}.
   *
   * <ul>
   *   <li>Given {@link SampleElementsForSplitPoints} (default constructor) ProportionToSample is
   *       {@code -1.0E-5}.
   * </ul>
   *
   * <p>Method under test: {@link SampleElementsForSplitPoints#validate()}
   */
  @Test
  @DisplayName(
      "Test validate(); given SampleElementsForSplitPoints (default constructor) ProportionToSample is '-1.0E-5'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ValidationResult SampleElementsForSplitPoints.validate()"})
  void testValidate_givenSampleElementsForSplitPointsProportionToSampleIs10e5() {
    // Arrange
    SampleElementsForSplitPoints<Object> sampleElementsForSplitPoints =
        new SampleElementsForSplitPoints<>();
    sampleElementsForSplitPoints.setNumSplits(1);
    sampleElementsForSplitPoints.setProportionToSample(-1.0E-5f);

    // Act
    ValidationResult actualValidateResult = sampleElementsForSplitPoints.validate();

    // Assert
    assertEquals(
        "Validation errors: \nproportionToSample must within range: [0, 1]",
        actualValidateResult.getErrorString());
    Set<String> errors = actualValidateResult.getErrors();
    assertEquals(1, errors.size());
    assertFalse(actualValidateResult.isValid());
    assertTrue(errors.contains("proportionToSample must within range: [0, 1]"));
  }

  /**
   * Test {@link SampleElementsForSplitPoints#validate()}.
   *
   * <ul>
   *   <li>Given {@link SampleElementsForSplitPoints} (default constructor) ProportionToSample is
   *       {@code 1.0000001}.
   * </ul>
   *
   * <p>Method under test: {@link SampleElementsForSplitPoints#validate()}
   */
  @Test
  @DisplayName(
      "Test validate(); given SampleElementsForSplitPoints (default constructor) ProportionToSample is '1.0000001'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ValidationResult SampleElementsForSplitPoints.validate()"})
  void testValidate_givenSampleElementsForSplitPointsProportionToSampleIs10000001() {
    // Arrange
    SampleElementsForSplitPoints<Object> sampleElementsForSplitPoints =
        new SampleElementsForSplitPoints<>();
    sampleElementsForSplitPoints.setNumSplits(1);
    sampleElementsForSplitPoints.setProportionToSample(1.0000001f);

    // Act
    ValidationResult actualValidateResult = sampleElementsForSplitPoints.validate();

    // Assert
    assertEquals(
        "Validation errors: \nproportionToSample must within range: [0, 1]",
        actualValidateResult.getErrorString());
    Set<String> errors = actualValidateResult.getErrors();
    assertEquals(1, errors.size());
    assertFalse(actualValidateResult.isValid());
    assertTrue(errors.contains("proportionToSample must within range: [0, 1]"));
  }

  /**
   * Test {@link SampleElementsForSplitPoints#validate()}.
   *
   * <ul>
   *   <li>Then return ErrorString is {@code Validation errors:}.
   * </ul>
   *
   * <p>Method under test: {@link SampleElementsForSplitPoints#validate()}
   */
  @Test
  @DisplayName("Test validate(); then return ErrorString is 'Validation errors:'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ValidationResult SampleElementsForSplitPoints.validate()"})
  void testValidate_thenReturnErrorStringIsValidationErrors() {
    // Arrange
    SampleElementsForSplitPoints<Object> sampleElementsForSplitPoints =
        new SampleElementsForSplitPoints<>();
    sampleElementsForSplitPoints.setNumSplits(1);
    sampleElementsForSplitPoints.setProportionToSample(1.0f);

    // Act
    ValidationResult actualValidateResult = sampleElementsForSplitPoints.validate();

    // Assert
    assertEquals("Validation errors: \n", actualValidateResult.getErrorString());
    assertTrue(actualValidateResult.getErrors().isEmpty());
    assertTrue(actualValidateResult.isValid());
  }

  /**
   * Test {@link SampleElementsForSplitPoints#shallowClone()}.
   *
   * <ul>
   *   <li>Given {@link SampleElementsForSplitPoints} (default constructor).
   *   <li>Then return Options is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link SampleElementsForSplitPoints#shallowClone()}
   */
  @Test
  @DisplayName(
      "Test shallowClone(); given SampleElementsForSplitPoints (default constructor); then return Options is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"SampleElementsForSplitPoints SampleElementsForSplitPoints.shallowClone()"})
  void testShallowClone_givenSampleElementsForSplitPoints_thenReturnOptionsIsNull() {
    // Arrange
    SampleElementsForSplitPoints<Object> sampleElementsForSplitPoints =
        new SampleElementsForSplitPoints<>();

    // Act
    SampleElementsForSplitPoints<Object> actualShallowCloneResult =
        sampleElementsForSplitPoints.shallowClone();

    // Assert
    TypeReference<List<Object>> outputTypeReference =
        actualShallowCloneResult.getOutputTypeReference();
    assertTrue(outputTypeReference instanceof TypeReferenceImpl.List);
    Type outputType = actualShallowCloneResult.getOutputType();
    assertEquals("java.util.List<T>", outputType.getTypeName());
    assertNull(actualShallowCloneResult.getNumSplits());
    assertNull(actualShallowCloneResult.getInput());
    assertNull(actualShallowCloneResult.getOptions());
    assertEquals(1.0f, actualShallowCloneResult.getProportionToSample());
    Class<List> expectedOutputClass = List.class;
    assertEquals(expectedOutputClass, actualShallowCloneResult.getOutputClass());
    assertSame(outputType, outputTypeReference.getType());
  }

  /**
   * Test {@link SampleElementsForSplitPoints#shallowClone()}.
   *
   * <ul>
   *   <li>Then return Options Empty.
   * </ul>
   *
   * <p>Method under test: {@link SampleElementsForSplitPoints#shallowClone()}
   */
  @Test
  @DisplayName("Test shallowClone(); then return Options Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"SampleElementsForSplitPoints SampleElementsForSplitPoints.shallowClone()"})
  void testShallowClone_thenReturnOptionsEmpty() {
    // Arrange
    SampleElementsForSplitPoints<Object> sampleElementsForSplitPoints =
        new SampleElementsForSplitPoints<>();
    sampleElementsForSplitPoints.setOptions(new HashMap<>());

    // Act
    SampleElementsForSplitPoints<Object> actualShallowCloneResult =
        sampleElementsForSplitPoints.shallowClone();

    // Assert
    TypeReference<List<Object>> outputTypeReference =
        actualShallowCloneResult.getOutputTypeReference();
    assertTrue(outputTypeReference instanceof TypeReferenceImpl.List);
    Type outputType = actualShallowCloneResult.getOutputType();
    assertEquals("java.util.List<T>", outputType.getTypeName());
    assertNull(actualShallowCloneResult.getNumSplits());
    assertNull(actualShallowCloneResult.getInput());
    assertEquals(1.0f, actualShallowCloneResult.getProportionToSample());
    assertTrue(actualShallowCloneResult.getOptions().isEmpty());
    Class<List> expectedOutputClass = List.class;
    assertEquals(expectedOutputClass, actualShallowCloneResult.getOutputClass());
    assertSame(outputType, outputTypeReference.getType());
  }

  /**
   * Test {@link SampleElementsForSplitPoints#getInput()}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link SampleElementsForSplitPoints#getInput()}
   */
  @Test
  @DisplayName("Test getInput(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Iterable SampleElementsForSplitPoints.getInput()"})
  void testGetInput_thenReturnNull() {
    // Arrange
    SampleElementsForSplitPoints<Object> sampleElementsForSplitPoints =
        new SampleElementsForSplitPoints<>();

    // Act and Assert
    assertNull(sampleElementsForSplitPoints.getInput());
  }

  /**
   * Test {@link SampleElementsForSplitPoints#getOutputTypeReference()}.
   *
   * <p>Method under test: {@link SampleElementsForSplitPoints#getOutputTypeReference()}
   */
  @Test
  @DisplayName("Test getOutputTypeReference()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TypeReference SampleElementsForSplitPoints.getOutputTypeReference()"})
  void testGetOutputTypeReference() {
    // Arrange
    SampleElementsForSplitPoints<Object> sampleElementsForSplitPoints =
        new SampleElementsForSplitPoints<>();

    // Act
    TypeReference<List<Object>> actualOutputTypeReference =
        sampleElementsForSplitPoints.getOutputTypeReference();

    // Assert
    assertTrue(actualOutputTypeReference instanceof TypeReferenceImpl.List);
    assertEquals("java.util.List<T>", actualOutputTypeReference.getType().getTypeName());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link SampleElementsForSplitPoints}
   *   <li>{@link SampleElementsForSplitPoints#setInput(Iterable)}
   *   <li>{@link SampleElementsForSplitPoints#setNumSplits(Integer)}
   *   <li>{@link SampleElementsForSplitPoints#setOptions(Map)}
   *   <li>{@link SampleElementsForSplitPoints#setProportionToSample(float)}
   *   <li>{@link SampleElementsForSplitPoints#getNumSplits()}
   *   <li>{@link SampleElementsForSplitPoints#getOptions()}
   *   <li>{@link SampleElementsForSplitPoints#getProportionToSample()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void SampleElementsForSplitPoints.<init>()",
    "Integer SampleElementsForSplitPoints.getNumSplits()",
    "Map SampleElementsForSplitPoints.getOptions()",
    "float SampleElementsForSplitPoints.getProportionToSample()",
    "void SampleElementsForSplitPoints.setInput(Iterable)",
    "void SampleElementsForSplitPoints.setNumSplits(Integer)",
    "void SampleElementsForSplitPoints.setOptions(Map)",
    "void SampleElementsForSplitPoints.setProportionToSample(float)"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    SampleElementsForSplitPoints<Object> actualSampleElementsForSplitPoints =
        new SampleElementsForSplitPoints<>();
    ArrayList<Element> input = new ArrayList<>();
    actualSampleElementsForSplitPoints.setInput(input);
    actualSampleElementsForSplitPoints.setNumSplits(10);
    HashMap<String, String> options = new HashMap<>();
    actualSampleElementsForSplitPoints.setOptions(options);
    actualSampleElementsForSplitPoints.setProportionToSample(10.0f);
    Integer actualNumSplits = actualSampleElementsForSplitPoints.getNumSplits();
    Map<String, String> actualOptions = actualSampleElementsForSplitPoints.getOptions();
    float actualProportionToSample = actualSampleElementsForSplitPoints.getProportionToSample();

    // Assert
    Iterable<? extends Element> input2 = actualSampleElementsForSplitPoints.getInput();
    assertTrue(input2 instanceof List);
    assertEquals(10, actualNumSplits.intValue());
    assertEquals(10.0f, actualProportionToSample);
    assertTrue(actualOptions.isEmpty());
    assertSame(input, input2);
    assertSame(options, actualOptions);
  }
}
