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
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.core.type.TypeReference;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.apache.commons.lang3.exception.CloneFailedException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.operation.impl.GenerateSplitPointsFromSample.Builder;
import uk.gov.gchq.gaffer.operation.serialisation.TypeReferenceImpl;
import uk.gov.gchq.koryphe.ValidationResult;

class GenerateSplitPointsFromSampleDiffblueTest {
  /**
   * Test Builder new {@link Builder} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of {@link Builder}
   */
  @Test
  @DisplayName("Test Builder new Builder (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Builder.<init>()"})
  void testBuilderNewBuilder() {
    // Arrange and Act
    Builder<Object> actualBuilder = new Builder<>();

    // Assert
    GenerateSplitPointsFromSample<Object> _getOpResult = actualBuilder._getOp();
    TypeReference<List<Object>> outputTypeReference = _getOpResult.getOutputTypeReference();
    assertTrue(outputTypeReference instanceof TypeReferenceImpl.List);
    Type outputType = _getOpResult.getOutputType();
    assertEquals("java.util.List<T>", outputType.getTypeName());
    assertNull(_getOpResult.getNumSplits());
    assertNull(_getOpResult.getInput());
    assertNull(_getOpResult.getOptions());
    Class<List> expectedOutputClass = List.class;
    assertEquals(expectedOutputClass, _getOpResult.getOutputClass());
    assertSame(_getOpResult, actualBuilder.build());
    assertSame(outputType, outputTypeReference.getType());
  }

  /**
   * Test Builder {@link Builder#numSplits(Integer)}.
   * <p>
   * Method under test: {@link Builder#numSplits(Integer)}
   */
  @Test
  @DisplayName("Test Builder numSplits(Integer)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.numSplits(Integer)"})
  void testBuilderNumSplits() {
    // Arrange
    Builder<Object> builder = new Builder<>();

    // Act and Assert
    assertSame(builder, builder.numSplits(10));
  }

  /**
   * Test {@link GenerateSplitPointsFromSample#validate()}.
   * <p>
   * Method under test: {@link GenerateSplitPointsFromSample#validate()}
   */
  @Test
  @DisplayName("Test validate()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ValidationResult GenerateSplitPointsFromSample.validate()"})
  void testValidate() {
    // Arrange
    GenerateSplitPointsFromSample<Object> generateSplitPointsFromSample = new GenerateSplitPointsFromSample<>();
    generateSplitPointsFromSample.setNumSplits(0);

    // Act
    ValidationResult actualValidateResult = generateSplitPointsFromSample.validate();

    // Assert
    assertEquals("Validation errors: \nnumSplits must be null or greater than 0",
        actualValidateResult.getErrorString());
    Set<String> errors = actualValidateResult.getErrors();
    assertEquals(1, errors.size());
    assertFalse(actualValidateResult.isValid());
    assertTrue(errors.contains("numSplits must be null or greater than 0"));
  }

  /**
   * Test {@link GenerateSplitPointsFromSample#validate()}.
   * <ul>
   *   <li>Given {@link GenerateSplitPointsFromSample} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link GenerateSplitPointsFromSample#validate()}
   */
  @Test
  @DisplayName("Test validate(); given GenerateSplitPointsFromSample (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ValidationResult GenerateSplitPointsFromSample.validate()"})
  void testValidate_givenGenerateSplitPointsFromSample() {
    // Arrange
    GenerateSplitPointsFromSample<Object> generateSplitPointsFromSample = new GenerateSplitPointsFromSample<>();

    // Act
    ValidationResult actualValidateResult = generateSplitPointsFromSample.validate();

    // Assert
    assertEquals("Validation errors: \n", actualValidateResult.getErrorString());
    assertTrue(actualValidateResult.getErrors().isEmpty());
    assertTrue(actualValidateResult.isValid());
  }

  /**
   * Test {@link GenerateSplitPointsFromSample#validate()}.
   * <ul>
   *   <li>Given {@link GenerateSplitPointsFromSample} (default constructor) NumSplits is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link GenerateSplitPointsFromSample#validate()}
   */
  @Test
  @DisplayName("Test validate(); given GenerateSplitPointsFromSample (default constructor) NumSplits is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ValidationResult GenerateSplitPointsFromSample.validate()"})
  void testValidate_givenGenerateSplitPointsFromSampleNumSplitsIsOne() {
    // Arrange
    GenerateSplitPointsFromSample<Object> generateSplitPointsFromSample = new GenerateSplitPointsFromSample<>();
    generateSplitPointsFromSample.setNumSplits(1);

    // Act
    ValidationResult actualValidateResult = generateSplitPointsFromSample.validate();

    // Assert
    assertEquals("Validation errors: \n", actualValidateResult.getErrorString());
    assertTrue(actualValidateResult.getErrors().isEmpty());
    assertTrue(actualValidateResult.isValid());
  }

  /**
   * Test {@link GenerateSplitPointsFromSample#getOutputTypeReference()}.
   * <p>
   * Method under test: {@link GenerateSplitPointsFromSample#getOutputTypeReference()}
   */
  @Test
  @DisplayName("Test getOutputTypeReference()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TypeReference GenerateSplitPointsFromSample.getOutputTypeReference()"})
  void testGetOutputTypeReference() {
    // Arrange
    GenerateSplitPointsFromSample<Object> generateSplitPointsFromSample = new GenerateSplitPointsFromSample<>();

    // Act
    TypeReference<List<Object>> actualOutputTypeReference = generateSplitPointsFromSample.getOutputTypeReference();

    // Assert
    assertTrue(actualOutputTypeReference instanceof TypeReferenceImpl.List);
    assertEquals("java.util.List<T>", actualOutputTypeReference.getType().getTypeName());
  }

  /**
   * Test {@link GenerateSplitPointsFromSample#shallowClone()}.
   * <ul>
   *   <li>Given {@link GenerateSplitPointsFromSample} (default constructor).</li>
   *   <li>Then return Options is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GenerateSplitPointsFromSample#shallowClone()}
   */
  @Test
  @DisplayName("Test shallowClone(); given GenerateSplitPointsFromSample (default constructor); then return Options is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"GenerateSplitPointsFromSample GenerateSplitPointsFromSample.shallowClone()"})
  void testShallowClone_givenGenerateSplitPointsFromSample_thenReturnOptionsIsNull() throws CloneFailedException {
    // Arrange
    GenerateSplitPointsFromSample<Object> generateSplitPointsFromSample = new GenerateSplitPointsFromSample<>();

    // Act
    GenerateSplitPointsFromSample<Object> actualShallowCloneResult = generateSplitPointsFromSample.shallowClone();

    // Assert
    TypeReference<List<Object>> outputTypeReference = actualShallowCloneResult.getOutputTypeReference();
    assertTrue(outputTypeReference instanceof TypeReferenceImpl.List);
    Type outputType = actualShallowCloneResult.getOutputType();
    assertEquals("java.util.List<T>", outputType.getTypeName());
    assertNull(actualShallowCloneResult.getNumSplits());
    assertNull(actualShallowCloneResult.getInput());
    assertNull(actualShallowCloneResult.getOptions());
    Class<List> expectedOutputClass = List.class;
    assertEquals(expectedOutputClass, actualShallowCloneResult.getOutputClass());
    assertSame(outputType, outputTypeReference.getType());
  }

  /**
   * Test {@link GenerateSplitPointsFromSample#shallowClone()}.
   * <ul>
   *   <li>Then return Options Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link GenerateSplitPointsFromSample#shallowClone()}
   */
  @Test
  @DisplayName("Test shallowClone(); then return Options Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"GenerateSplitPointsFromSample GenerateSplitPointsFromSample.shallowClone()"})
  void testShallowClone_thenReturnOptionsEmpty() throws CloneFailedException {
    // Arrange
    GenerateSplitPointsFromSample<Object> generateSplitPointsFromSample = new GenerateSplitPointsFromSample<>();
    generateSplitPointsFromSample.setOptions(new HashMap<>());

    // Act
    GenerateSplitPointsFromSample<Object> actualShallowCloneResult = generateSplitPointsFromSample.shallowClone();

    // Assert
    TypeReference<List<Object>> outputTypeReference = actualShallowCloneResult.getOutputTypeReference();
    assertTrue(outputTypeReference instanceof TypeReferenceImpl.List);
    Type outputType = actualShallowCloneResult.getOutputType();
    assertEquals("java.util.List<T>", outputType.getTypeName());
    assertNull(actualShallowCloneResult.getNumSplits());
    assertNull(actualShallowCloneResult.getInput());
    assertTrue(actualShallowCloneResult.getOptions().isEmpty());
    Class<List> expectedOutputClass = List.class;
    assertEquals(expectedOutputClass, actualShallowCloneResult.getOutputClass());
    assertSame(outputType, outputTypeReference.getType());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link GenerateSplitPointsFromSample}
   *   <li>{@link GenerateSplitPointsFromSample#setInput(Iterable)}
   *   <li>{@link GenerateSplitPointsFromSample#setNumSplits(Integer)}
   *   <li>{@link GenerateSplitPointsFromSample#setOptions(Map)}
   *   <li>{@link GenerateSplitPointsFromSample#getNumSplits()}
   *   <li>{@link GenerateSplitPointsFromSample#getOptions()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void GenerateSplitPointsFromSample.<init>()",
      "Integer GenerateSplitPointsFromSample.getNumSplits()", "Map GenerateSplitPointsFromSample.getOptions()",
      "void GenerateSplitPointsFromSample.setInput(Iterable)",
      "void GenerateSplitPointsFromSample.setNumSplits(Integer)", "void GenerateSplitPointsFromSample.setOptions(Map)"})
  void testGettersAndSetters() {
    // Arrange and Act
    GenerateSplitPointsFromSample<Object> actualGenerateSplitPointsFromSample = new GenerateSplitPointsFromSample<>();
    ArrayList<Object> input = new ArrayList<>();
    actualGenerateSplitPointsFromSample.setInput(input);
    actualGenerateSplitPointsFromSample.setNumSplits(10);
    HashMap<String, String> options = new HashMap<>();
    actualGenerateSplitPointsFromSample.setOptions(options);
    Integer actualNumSplits = actualGenerateSplitPointsFromSample.getNumSplits();
    Map<String, String> actualOptions = actualGenerateSplitPointsFromSample.getOptions();

    // Assert
    Iterable<?> input2 = actualGenerateSplitPointsFromSample.getInput();
    assertTrue(input2 instanceof List);
    assertEquals(10, actualNumSplits.intValue());
    assertTrue(actualOptions.isEmpty());
    assertSame(input, input2);
    assertSame(options, actualOptions);
  }
}
