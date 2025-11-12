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
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.operation.serialisation.TypeReferenceImpl;

class ScoreOperationChainDiffblueTest {
  /**
   * Method under test: default or parameterless constructor of
   * {@link ScoreOperationChain.Builder}
   */
  @Test
  void testBuilderNewBuilder() {
    // Arrange and Act
    ScoreOperationChain.Builder actualBuilder = new ScoreOperationChain.Builder();

    // Assert
    ScoreOperationChain _getOpResult = actualBuilder._getOp();
    TypeReference<Integer> outputTypeReference = _getOpResult.getOutputTypeReference();
    assertTrue(outputTypeReference instanceof TypeReferenceImpl.Integer);
    assertNull(_getOpResult.getOptions());
    assertNull(_getOpResult.getOperationChain());
    Class<Integer> expectedOutputClass = Integer.class;
    Class<?> outputClass = _getOpResult.getOutputClass();
    assertEquals(expectedOutputClass, outputClass);
    assertSame(_getOpResult, actualBuilder.build());
    assertSame(outputClass, outputTypeReference.getType());
    assertSame(outputClass, _getOpResult.getOutputType());
  }

  /**
   * Method under test: {@link ScoreOperationChain#getOutputTypeReference()}
   */
  @Test
  void testGetOutputTypeReference() {
    // Arrange, Act and Assert
    assertTrue((new ScoreOperationChain()).getOutputTypeReference() instanceof TypeReferenceImpl.Integer);
  }

  /**
   * Method under test: {@link ScoreOperationChain#getOutputTypeReference()}
   */
  @Test
  void testGetOutputTypeReference2() {
    // Arrange
    HashMap<String, String> options = new HashMap<>();
    options.computeIfPresent("foo", mock(BiFunction.class));

    ScoreOperationChain scoreOperationChain = new ScoreOperationChain();
    scoreOperationChain.setOptions(options);

    // Act and Assert
    assertTrue(scoreOperationChain.getOutputTypeReference() instanceof TypeReferenceImpl.Integer);
  }

  /**
   * Method under test: {@link ScoreOperationChain#shallowClone()}
   */
  @Test
  void testShallowClone() {
    // Arrange and Act
    ScoreOperationChain actualShallowCloneResult = (new ScoreOperationChain()).shallowClone();

    // Assert
    TypeReference<Integer> outputTypeReference = actualShallowCloneResult.getOutputTypeReference();
    assertTrue(outputTypeReference instanceof TypeReferenceImpl.Integer);
    assertNull(actualShallowCloneResult.getOptions());
    assertNull(actualShallowCloneResult.getOperationChain());
    Class<Integer> expectedOutputClass = Integer.class;
    Class<?> outputClass = actualShallowCloneResult.getOutputClass();
    assertEquals(expectedOutputClass, outputClass);
    assertSame(outputClass, outputTypeReference.getType());
    assertSame(outputClass, actualShallowCloneResult.getOutputType());
  }

  /**
   * Method under test: {@link ScoreOperationChain#shallowClone()}
   */
  @Test
  void testShallowClone2() {
    // Arrange
    ScoreOperationChain scoreOperationChain = new ScoreOperationChain();
    scoreOperationChain.setOptions(new HashMap<>());

    // Act
    ScoreOperationChain actualShallowCloneResult = scoreOperationChain.shallowClone();

    // Assert
    TypeReference<Integer> outputTypeReference = actualShallowCloneResult.getOutputTypeReference();
    assertTrue(outputTypeReference instanceof TypeReferenceImpl.Integer);
    assertNull(actualShallowCloneResult.getOperationChain());
    assertTrue(actualShallowCloneResult.getOptions().isEmpty());
    Class<Integer> expectedOutputClass = Integer.class;
    Class<?> outputClass = actualShallowCloneResult.getOutputClass();
    assertEquals(expectedOutputClass, outputClass);
    assertSame(outputClass, outputTypeReference.getType());
    assertSame(outputClass, actualShallowCloneResult.getOutputType());
  }

  /**
   * Method under test: {@link ScoreOperationChain#shallowClone()}
   */
  @Test
  void testShallowClone3() {
    // Arrange
    HashMap<String, String> options = new HashMap<>();
    options.computeIfPresent("foo", mock(BiFunction.class));

    ScoreOperationChain scoreOperationChain = new ScoreOperationChain();
    scoreOperationChain.setOptions(options);

    // Act
    ScoreOperationChain actualShallowCloneResult = scoreOperationChain.shallowClone();

    // Assert
    TypeReference<Integer> outputTypeReference = actualShallowCloneResult.getOutputTypeReference();
    assertTrue(outputTypeReference instanceof TypeReferenceImpl.Integer);
    assertNull(actualShallowCloneResult.getOperationChain());
    assertTrue(actualShallowCloneResult.getOptions().isEmpty());
    Class<Integer> expectedOutputClass = Integer.class;
    Class<?> outputClass = actualShallowCloneResult.getOutputClass();
    assertEquals(expectedOutputClass, outputClass);
    assertSame(outputClass, outputTypeReference.getType());
    assertSame(outputClass, actualShallowCloneResult.getOutputType());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link ScoreOperationChain}
   *   <li>{@link ScoreOperationChain#setOptions(Map)}
   *   <li>{@link ScoreOperationChain#getOperationChain()}
   *   <li>{@link ScoreOperationChain#getOptions()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    ScoreOperationChain actualScoreOperationChain = new ScoreOperationChain();
    HashMap<String, String> options = new HashMap<>();
    actualScoreOperationChain.setOptions(options);
    actualScoreOperationChain.getOperationChain();
    Map<String, String> actualOptions = actualScoreOperationChain.getOptions();

    // Assert that nothing has changed
    assertTrue(actualOptions.isEmpty());
    assertSame(options, actualOptions);
  }
}
