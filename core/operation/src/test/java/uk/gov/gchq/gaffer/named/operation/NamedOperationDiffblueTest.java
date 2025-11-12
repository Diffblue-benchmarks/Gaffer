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

package uk.gov.gchq.gaffer.named.operation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.fasterxml.jackson.core.type.TypeReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.operation.Operation;
import uk.gov.gchq.gaffer.operation.serialisation.TypeReferenceImpl;

class NamedOperationDiffblueTest {
  /**
   * Method under test: {@link NamedOperation.Builder#name(String)}
   */
  @Test
  void testBuilderName() {
    // Arrange
    NamedOperation.Builder<Object, Object> builder = new NamedOperation.Builder<>();

    // Act and Assert
    assertSame(builder, builder.name("Name"));
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link NamedOperation.Builder}
   */
  @Test
  void testBuilderNewBuilder() {
    // Arrange and Act
    NamedOperation.Builder<Object, Object> actualBuilder = new NamedOperation.Builder<>();

    // Assert
    NamedOperation<Object, Object> _getOpResult = actualBuilder._getOp();
    TypeReference<Object> outputTypeReference = _getOpResult.getOutputTypeReference();
    assertTrue(outputTypeReference instanceof TypeReferenceImpl.Object);
    assertNull(_getOpResult.getInput());
    assertNull(_getOpResult.getOperationName());
    assertNull(_getOpResult.getParameters());
    assertNull(_getOpResult.getOptions());
    assertTrue(_getOpResult.getOperations().isEmpty());
    Class<Object> expectedOutputClass = Object.class;
    Class<?> outputClass = _getOpResult.getOutputClass();
    assertEquals(expectedOutputClass, outputClass);
    Class<Operation> expectedOperationsClass = Operation.class;
    assertEquals(expectedOperationsClass, _getOpResult.getOperationsClass());
    assertSame(_getOpResult, actualBuilder.build());
    assertSame(outputClass, outputTypeReference.getType());
    assertSame(outputClass, _getOpResult.getOutputType());
  }

  /**
   * Method under test: {@link NamedOperation.Builder#parameters(Map)}
   */
  @Test
  void testBuilderParameters() {
    // Arrange
    NamedOperation.Builder<Object, Object> builder = new NamedOperation.Builder<>();

    // Act and Assert
    assertSame(builder, builder.parameters(new HashMap<>()));
  }

  /**
   * Method under test: {@link NamedOperation.Builder#parameters(Map)}
   */
  @Test
  void testBuilderParameters2() {
    // Arrange
    NamedOperation.Builder<Object, Object> builder = new NamedOperation.Builder<>();

    HashMap<String, Object> params = new HashMap<>();
    params.computeIfPresent("foo", mock(BiFunction.class));

    // Act and Assert
    assertSame(builder, builder.parameters(params));
  }

  /**
   * Method under test: {@link NamedOperation#setParameters(Map)}
   */
  @Test
  void testSetParameters() {
    // Arrange
    NamedOperation<Object, Object> namedOperation = new NamedOperation<>();

    // Act
    namedOperation.setParameters(new HashMap<>());

    // Assert
    assertTrue(namedOperation.getParameters().isEmpty());
  }

  /**
   * Method under test: {@link NamedOperation#setParameters(Map)}
   */
  @Test
  void testSetParameters2() {
    // Arrange
    NamedOperation<Object, Object> namedOperation = new NamedOperation<>();

    // Act
    namedOperation.setParameters((Map<String, Object>) null);

    // Assert that nothing has changed
    assertNull(namedOperation.getParameters());
  }

  /**
   * Method under test: {@link NamedOperation#setParameters(Map)}
   */
  @Test
  void testSetParameters3() {
    // Arrange
    NamedOperation<Object, Object> namedOperation = new NamedOperation<>();

    HashMap<String, Object> parameters = new HashMap<>();
    parameters.computeIfPresent("foo", mock(BiFunction.class));

    // Act
    namedOperation.setParameters(parameters);

    // Assert
    assertTrue(namedOperation.getParameters().isEmpty());
  }

  /**
   * Method under test: {@link NamedOperation#setParameters(Map)}
   */
  @Test
  void testSetParameters4() {
    // Arrange
    NamedOperation<Object, Object> namedOperation = new NamedOperation<>();
    LinkedHashMap<String, Object> parameters = new LinkedHashMap<>();

    // Act
    namedOperation.setParameters((Map<String, Object>) parameters);

    // Assert
    assertSame(parameters, namedOperation.getParameters());
  }

  /**
   * Method under test: {@link NamedOperation#getOutputTypeReference()}
   */
  @Test
  void testGetOutputTypeReference() {
    // Arrange
    NamedOperation<Object, Object> namedOperation = new NamedOperation<>();

    // Act and Assert
    assertTrue(namedOperation.getOutputTypeReference() instanceof TypeReferenceImpl.Object);
  }

  /**
   * Method under test: {@link NamedOperation#getOutputTypeReference()}
   */
  @Test
  void testGetOutputTypeReference2() {
    // Arrange
    LinkedHashMap<String, Object> parameters = new LinkedHashMap<>();
    parameters.replaceAll(mock(BiFunction.class));

    NamedOperation<Object, Object> namedOperation = new NamedOperation<>();
    namedOperation.setParameters(parameters);

    // Act and Assert
    assertTrue(namedOperation.getOutputTypeReference() instanceof TypeReferenceImpl.Object);
  }

  /**
   * Method under test: {@link NamedOperation#shallowClone()}
   */
  @Test
  void testShallowClone() {
    // Arrange
    NamedOperation<Object, Object> namedOperation = new NamedOperation<>();

    // Act
    NamedOperation actualShallowCloneResult = namedOperation.shallowClone();

    // Assert
    TypeReference outputTypeReference = actualShallowCloneResult.getOutputTypeReference();
    assertTrue(outputTypeReference instanceof TypeReferenceImpl.Object);
    assertNull(actualShallowCloneResult.getInput());
    assertNull(actualShallowCloneResult.getOperationName());
    assertNull(actualShallowCloneResult.getParameters());
    assertNull(actualShallowCloneResult.getOptions());
    assertTrue(actualShallowCloneResult.getOperations().isEmpty());
    Class<Object> expectedOutputClass = Object.class;
    Class<?> outputClass = actualShallowCloneResult.getOutputClass();
    assertEquals(expectedOutputClass, outputClass);
    Class<Operation> expectedOperationsClass = Operation.class;
    assertEquals(expectedOperationsClass, actualShallowCloneResult.getOperationsClass());
    assertSame(outputClass, outputTypeReference.getType());
    assertSame(outputClass, actualShallowCloneResult.getOutputType());
  }

  /**
   * Method under test: {@link NamedOperation#shallowClone()}
   */
  @Test
  void testShallowClone2() {
    // Arrange
    NamedOperation<Object, Object> namedOperation = new NamedOperation<>();
    LinkedHashMap<String, Object> parameters = new LinkedHashMap<>();
    namedOperation.setParameters(parameters);

    // Act
    NamedOperation actualShallowCloneResult = namedOperation.shallowClone();

    // Assert
    TypeReference outputTypeReference = actualShallowCloneResult.getOutputTypeReference();
    assertTrue(outputTypeReference instanceof TypeReferenceImpl.Object);
    assertNull(actualShallowCloneResult.getInput());
    assertNull(actualShallowCloneResult.getOperationName());
    assertNull(actualShallowCloneResult.getOptions());
    assertTrue(actualShallowCloneResult.getOperations().isEmpty());
    Map<String, Object> parameters2 = actualShallowCloneResult.getParameters();
    assertTrue(parameters2.isEmpty());
    Class<Object> expectedOutputClass = Object.class;
    Class<?> outputClass = actualShallowCloneResult.getOutputClass();
    assertEquals(expectedOutputClass, outputClass);
    Class<Operation> expectedOperationsClass = Operation.class;
    assertEquals(expectedOperationsClass, actualShallowCloneResult.getOperationsClass());
    assertSame(parameters, parameters2);
    assertSame(outputClass, outputTypeReference.getType());
    assertSame(outputClass, actualShallowCloneResult.getOutputType());
  }

  /**
   * Method under test: {@link NamedOperation#shallowClone()}
   */
  @Test
  void testShallowClone3() {
    // Arrange
    NamedOperation<Object, Object> namedOperation = new NamedOperation<>();
    namedOperation.setOptions(new HashMap<>());

    // Act
    NamedOperation actualShallowCloneResult = namedOperation.shallowClone();

    // Assert
    TypeReference outputTypeReference = actualShallowCloneResult.getOutputTypeReference();
    assertTrue(outputTypeReference instanceof TypeReferenceImpl.Object);
    assertNull(actualShallowCloneResult.getInput());
    assertNull(actualShallowCloneResult.getOperationName());
    assertNull(actualShallowCloneResult.getParameters());
    assertTrue(actualShallowCloneResult.getOperations().isEmpty());
    assertTrue(actualShallowCloneResult.getOptions().isEmpty());
    Class<Object> expectedOutputClass = Object.class;
    Class<?> outputClass = actualShallowCloneResult.getOutputClass();
    assertEquals(expectedOutputClass, outputClass);
    Class<Operation> expectedOperationsClass = Operation.class;
    assertEquals(expectedOperationsClass, actualShallowCloneResult.getOperationsClass());
    assertSame(outputClass, outputTypeReference.getType());
    assertSame(outputClass, actualShallowCloneResult.getOutputType());
  }

  /**
   * Method under test: {@link NamedOperation#shallowClone()}
   */
  @Test
  void testShallowClone4() {
    // Arrange
    HashMap<String, String> options = new HashMap<>();
    options.computeIfPresent("foo", mock(BiFunction.class));

    NamedOperation<Object, Object> namedOperation = new NamedOperation<>();
    namedOperation.setOptions(options);

    // Act
    NamedOperation actualShallowCloneResult = namedOperation.shallowClone();

    // Assert
    TypeReference outputTypeReference = actualShallowCloneResult.getOutputTypeReference();
    assertTrue(outputTypeReference instanceof TypeReferenceImpl.Object);
    assertNull(actualShallowCloneResult.getInput());
    assertNull(actualShallowCloneResult.getOperationName());
    assertNull(actualShallowCloneResult.getParameters());
    assertTrue(actualShallowCloneResult.getOperations().isEmpty());
    assertTrue(actualShallowCloneResult.getOptions().isEmpty());
    Class<Object> expectedOutputClass = Object.class;
    Class<?> outputClass = actualShallowCloneResult.getOutputClass();
    assertEquals(expectedOutputClass, outputClass);
    Class<Operation> expectedOperationsClass = Operation.class;
    assertEquals(expectedOperationsClass, actualShallowCloneResult.getOperationsClass());
    assertSame(outputClass, outputTypeReference.getType());
    assertSame(outputClass, actualShallowCloneResult.getOutputType());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link NamedOperation}
   *   <li>{@link NamedOperation#setInput(Iterable)}
   *   <li>{@link NamedOperation#setOperationName(String)}
   *   <li>{@link NamedOperation#setOptions(Map)}
   *   <li>{@link NamedOperation#setParameters(LinkedHashMap)}
   *   <li>{@link NamedOperation#getOperationName()}
   *   <li>{@link NamedOperation#getOptions()}
   *   <li>{@link NamedOperation#getParameters()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    NamedOperation<Object, Object> actualNamedOperation = new NamedOperation<>();
    ArrayList<Object> input = new ArrayList<>();
    actualNamedOperation.setInput(input);
    actualNamedOperation.setOperationName("Operation Name");
    HashMap<String, String> options = new HashMap<>();
    actualNamedOperation.setOptions(options);
    LinkedHashMap<String, Object> parameters = new LinkedHashMap<>();
    actualNamedOperation.setParameters(parameters);
    String actualOperationName = actualNamedOperation.getOperationName();
    Map<String, String> actualOptions = actualNamedOperation.getOptions();
    Map<String, Object> actualParameters = actualNamedOperation.getParameters();

    // Assert that nothing has changed
    Iterable<?> input2 = actualNamedOperation.getInput();
    assertTrue(input2 instanceof List);
    assertEquals("Operation Name", actualOperationName);
    assertTrue(actualOptions.isEmpty());
    assertTrue(actualParameters.isEmpty());
    assertSame(input, input2);
    assertSame(options, actualOptions);
    assertSame(parameters, actualParameters);
  }
}
