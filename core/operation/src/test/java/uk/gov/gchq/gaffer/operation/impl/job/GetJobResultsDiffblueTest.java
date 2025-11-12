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

package uk.gov.gchq.gaffer.operation.impl.job;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.fasterxml.jackson.core.type.TypeReference;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.operation.serialisation.TypeReferenceImpl;

class GetJobResultsDiffblueTest {
  /**
   * Method under test: default or parameterless constructor of
   * {@link GetJobResults.Builder}
   */
  @Test
  void testBuilderNewBuilder() {
    // Arrange and Act
    GetJobResults.Builder actualBuilder = new GetJobResults.Builder();

    // Assert
    GetJobResults _getOpResult = actualBuilder._getOp();
    TypeReference<Iterable<?>> outputTypeReference = _getOpResult.getOutputTypeReference();
    assertTrue(outputTypeReference instanceof TypeReferenceImpl.IterableObj);
    assertEquals("ALL", _getOpResult.getKeyOrDefault());
    Type outputType = _getOpResult.getOutputType();
    assertEquals("java.lang.Iterable<?>", outputType.getTypeName());
    assertNull(_getOpResult.getJobId());
    assertNull(_getOpResult.getKey());
    assertNull(_getOpResult.getOptions());
    Class<Iterable> expectedOutputClass = Iterable.class;
    assertEquals(expectedOutputClass, _getOpResult.getOutputClass());
    assertSame(_getOpResult, actualBuilder.build());
    assertSame(outputType, outputTypeReference.getType());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link GetJobResults}
   *   <li>{@link GetJobResults#setOptions(Map)}
   *   <li>{@link GetJobResults#getKey()}
   *   <li>{@link GetJobResults#getOptions()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    GetJobResults actualGetJobResults = new GetJobResults();
    HashMap<String, String> options = new HashMap<>();
    actualGetJobResults.setOptions(options);
    actualGetJobResults.getKey();
    Map<String, String> actualOptions = actualGetJobResults.getOptions();

    // Assert that nothing has changed
    assertTrue(actualOptions.isEmpty());
    assertSame(options, actualOptions);
  }

  /**
   * Method under test: {@link GetJobResults#setKey(String)}
   */
  @Test
  void testSetKey() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> (new GetJobResults()).setKey("Key"));
  }

  /**
   * Method under test: {@link GetJobResults#shallowClone()}
   */
  @Test
  void testShallowClone() {
    // Arrange and Act
    GetJobResults actualShallowCloneResult = (new GetJobResults()).shallowClone();

    // Assert
    TypeReference<Iterable<?>> outputTypeReference = actualShallowCloneResult.getOutputTypeReference();
    assertTrue(outputTypeReference instanceof TypeReferenceImpl.IterableObj);
    assertEquals("ALL", actualShallowCloneResult.getKeyOrDefault());
    Type outputType = actualShallowCloneResult.getOutputType();
    assertEquals("java.lang.Iterable<?>", outputType.getTypeName());
    assertNull(actualShallowCloneResult.getJobId());
    assertNull(actualShallowCloneResult.getKey());
    assertNull(actualShallowCloneResult.getOptions());
    Class<Iterable> expectedOutputClass = Iterable.class;
    assertEquals(expectedOutputClass, actualShallowCloneResult.getOutputClass());
    assertSame(outputType, outputTypeReference.getType());
  }

  /**
   * Method under test: {@link GetJobResults#shallowClone()}
   */
  @Test
  void testShallowClone2() {
    // Arrange
    GetJobResults getJobResults = new GetJobResults();
    getJobResults.setOptions(new HashMap<>());

    // Act
    GetJobResults actualShallowCloneResult = getJobResults.shallowClone();

    // Assert
    TypeReference<Iterable<?>> outputTypeReference = actualShallowCloneResult.getOutputTypeReference();
    assertTrue(outputTypeReference instanceof TypeReferenceImpl.IterableObj);
    assertEquals("ALL", actualShallowCloneResult.getKeyOrDefault());
    Type outputType = actualShallowCloneResult.getOutputType();
    assertEquals("java.lang.Iterable<?>", outputType.getTypeName());
    assertNull(actualShallowCloneResult.getJobId());
    assertNull(actualShallowCloneResult.getKey());
    assertTrue(actualShallowCloneResult.getOptions().isEmpty());
    Class<Iterable> expectedOutputClass = Iterable.class;
    assertEquals(expectedOutputClass, actualShallowCloneResult.getOutputClass());
    assertSame(outputType, outputTypeReference.getType());
  }

  /**
   * Method under test: {@link GetJobResults#shallowClone()}
   */
  @Test
  void testShallowClone3() {
    // Arrange
    HashMap<String, String> options = new HashMap<>();
    options.computeIfPresent("ALL", mock(BiFunction.class));

    GetJobResults getJobResults = new GetJobResults();
    getJobResults.setOptions(options);

    // Act
    GetJobResults actualShallowCloneResult = getJobResults.shallowClone();

    // Assert
    TypeReference<Iterable<?>> outputTypeReference = actualShallowCloneResult.getOutputTypeReference();
    assertTrue(outputTypeReference instanceof TypeReferenceImpl.IterableObj);
    assertEquals("ALL", actualShallowCloneResult.getKeyOrDefault());
    Type outputType = actualShallowCloneResult.getOutputType();
    assertEquals("java.lang.Iterable<?>", outputType.getTypeName());
    assertNull(actualShallowCloneResult.getJobId());
    assertNull(actualShallowCloneResult.getKey());
    assertTrue(actualShallowCloneResult.getOptions().isEmpty());
    Class<Iterable> expectedOutputClass = Iterable.class;
    assertEquals(expectedOutputClass, actualShallowCloneResult.getOutputClass());
    assertSame(outputType, outputTypeReference.getType());
  }
}
