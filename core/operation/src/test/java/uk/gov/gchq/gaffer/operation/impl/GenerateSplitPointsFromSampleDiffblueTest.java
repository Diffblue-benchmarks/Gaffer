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
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.fasterxml.jackson.core.type.TypeReference;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import org.apache.commons.lang3.exception.CloneFailedException;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.operation.serialisation.TypeReferenceImpl;

class GenerateSplitPointsFromSampleDiffblueTest {
  /**
   * Method under test: default or parameterless constructor of
   * {@link GenerateSplitPointsFromSample.Builder}
   */
  @Test
  void testBuilderNewBuilder() {
    // Arrange and Act
    GenerateSplitPointsFromSample.Builder<Object> actualBuilder = new GenerateSplitPointsFromSample.Builder<>();

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
   * Method under test:
   * {@link GenerateSplitPointsFromSample.Builder#numSplits(Integer)}
   */
  @Test
  void testBuilderNumSplits() {
    // Arrange
    GenerateSplitPointsFromSample.Builder<Object> builder = new GenerateSplitPointsFromSample.Builder<>();

    // Act and Assert
    assertSame(builder, builder.numSplits(10));
  }

  /**
   * Method under test:
   * {@link GenerateSplitPointsFromSample#getOutputTypeReference()}
   */
  @Test
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
   * Method under test:
   * {@link GenerateSplitPointsFromSample#getOutputTypeReference()}
   */
  @Test
  void testGetOutputTypeReference2() {
    // Arrange
    HashMap<String, String> options = new HashMap<>();
    options.computeIfPresent("foo", mock(BiFunction.class));

    GenerateSplitPointsFromSample<Object> generateSplitPointsFromSample = new GenerateSplitPointsFromSample<>();
    generateSplitPointsFromSample.setOptions(options);

    // Act
    TypeReference<List<Object>> actualOutputTypeReference = generateSplitPointsFromSample.getOutputTypeReference();

    // Assert
    assertTrue(actualOutputTypeReference instanceof TypeReferenceImpl.List);
    assertEquals("java.util.List<T>", actualOutputTypeReference.getType().getTypeName());
  }

  /**
   * Method under test: {@link GenerateSplitPointsFromSample#shallowClone()}
   */
  @Test
  void testShallowClone() throws CloneFailedException {
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
   * Method under test: {@link GenerateSplitPointsFromSample#shallowClone()}
   */
  @Test
  void testShallowClone2() throws CloneFailedException {
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
   * Method under test: {@link GenerateSplitPointsFromSample#shallowClone()}
   */
  @Test
  void testShallowClone3() throws CloneFailedException {
    // Arrange
    HashMap<String, String> options = new HashMap<>();
    options.computeIfPresent("foo", mock(BiFunction.class));

    GenerateSplitPointsFromSample<Object> generateSplitPointsFromSample = new GenerateSplitPointsFromSample<>();
    generateSplitPointsFromSample.setOptions(options);

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
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of
   * {@link GenerateSplitPointsFromSample}
   *   <li>{@link GenerateSplitPointsFromSample#setInput(Iterable)}
   *   <li>{@link GenerateSplitPointsFromSample#setNumSplits(Integer)}
   *   <li>{@link GenerateSplitPointsFromSample#setOptions(Map)}
   *   <li>{@link GenerateSplitPointsFromSample#getNumSplits()}
   *   <li>{@link GenerateSplitPointsFromSample#getOptions()}
   * </ul>
   */
  @Test
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

    // Assert that nothing has changed
    Iterable<?> input2 = actualGenerateSplitPointsFromSample.getInput();
    assertTrue(input2 instanceof List);
    assertEquals(10, actualNumSplits.intValue());
    assertTrue(actualOptions.isEmpty());
    assertSame(input, input2);
    assertSame(options, actualOptions);
  }
}
