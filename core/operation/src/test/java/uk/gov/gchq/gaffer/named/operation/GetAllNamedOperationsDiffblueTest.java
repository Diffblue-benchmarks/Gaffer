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
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.named.operation.serialisation.NamedOperationTypeReference;

class GetAllNamedOperationsDiffblueTest {
  /**
   * Method under test: default or parameterless constructor of
   * {@link GetAllNamedOperations.Builder}
   */
  @Test
  void testBuilderNewBuilder() {
    // Arrange and Act
    GetAllNamedOperations.Builder actualBuilder = new GetAllNamedOperations.Builder();

    // Assert
    GetAllNamedOperations _getOpResult = actualBuilder._getOp();
    TypeReference<Iterable<NamedOperationDetail>> outputTypeReference = _getOpResult.getOutputTypeReference();
    assertTrue(outputTypeReference instanceof NamedOperationTypeReference.IterableNamedOperationDetail);
    Type outputType = _getOpResult.getOutputType();
    assertEquals("java.lang.Iterable<uk.gov.gchq.gaffer.named.operation.NamedOperationDetail>",
        outputType.getTypeName());
    assertNull(_getOpResult.getOptions());
    Class<Iterable> expectedOutputClass = Iterable.class;
    assertEquals(expectedOutputClass, _getOpResult.getOutputClass());
    assertSame(_getOpResult, actualBuilder.build());
    assertSame(outputType, outputTypeReference.getType());
  }

  /**
   * Method under test: {@link GetAllNamedOperations#getOutputTypeReference()}
   */
  @Test
  void testGetOutputTypeReference() {
    // Arrange and Act
    TypeReference<Iterable<NamedOperationDetail>> actualOutputTypeReference = (new GetAllNamedOperations())
        .getOutputTypeReference();

    // Assert
    assertTrue(actualOutputTypeReference instanceof NamedOperationTypeReference.IterableNamedOperationDetail);
    assertEquals("java.lang.Iterable<uk.gov.gchq.gaffer.named.operation.NamedOperationDetail>",
        actualOutputTypeReference.getType().getTypeName());
  }

  /**
   * Method under test: {@link GetAllNamedOperations#getOutputTypeReference()}
   */
  @Test
  void testGetOutputTypeReference2() {
    // Arrange
    HashMap<String, String> options = new HashMap<>();
    options.computeIfPresent("foo", mock(BiFunction.class));

    GetAllNamedOperations getAllNamedOperations = new GetAllNamedOperations();
    getAllNamedOperations.setOptions(options);

    // Act
    TypeReference<Iterable<NamedOperationDetail>> actualOutputTypeReference = getAllNamedOperations
        .getOutputTypeReference();

    // Assert
    assertTrue(actualOutputTypeReference instanceof NamedOperationTypeReference.IterableNamedOperationDetail);
    assertEquals("java.lang.Iterable<uk.gov.gchq.gaffer.named.operation.NamedOperationDetail>",
        actualOutputTypeReference.getType().getTypeName());
  }

  /**
   * Method under test: {@link GetAllNamedOperations#shallowClone()}
   */
  @Test
  void testShallowClone() {
    // Arrange and Act
    GetAllNamedOperations actualShallowCloneResult = (new GetAllNamedOperations()).shallowClone();

    // Assert
    TypeReference<Iterable<NamedOperationDetail>> outputTypeReference = actualShallowCloneResult
        .getOutputTypeReference();
    assertTrue(outputTypeReference instanceof NamedOperationTypeReference.IterableNamedOperationDetail);
    Type outputType = actualShallowCloneResult.getOutputType();
    assertEquals("java.lang.Iterable<uk.gov.gchq.gaffer.named.operation.NamedOperationDetail>",
        outputType.getTypeName());
    assertNull(actualShallowCloneResult.getOptions());
    Class<Iterable> expectedOutputClass = Iterable.class;
    assertEquals(expectedOutputClass, actualShallowCloneResult.getOutputClass());
    assertSame(outputType, outputTypeReference.getType());
  }

  /**
   * Method under test: {@link GetAllNamedOperations#shallowClone()}
   */
  @Test
  void testShallowClone2() {
    // Arrange
    GetAllNamedOperations getAllNamedOperations = new GetAllNamedOperations();
    getAllNamedOperations.setOptions(new HashMap<>());

    // Act
    GetAllNamedOperations actualShallowCloneResult = getAllNamedOperations.shallowClone();

    // Assert
    TypeReference<Iterable<NamedOperationDetail>> outputTypeReference = actualShallowCloneResult
        .getOutputTypeReference();
    assertTrue(outputTypeReference instanceof NamedOperationTypeReference.IterableNamedOperationDetail);
    Type outputType = actualShallowCloneResult.getOutputType();
    assertEquals("java.lang.Iterable<uk.gov.gchq.gaffer.named.operation.NamedOperationDetail>",
        outputType.getTypeName());
    assertTrue(actualShallowCloneResult.getOptions().isEmpty());
    Class<Iterable> expectedOutputClass = Iterable.class;
    assertEquals(expectedOutputClass, actualShallowCloneResult.getOutputClass());
    assertSame(outputType, outputTypeReference.getType());
  }

  /**
   * Method under test: {@link GetAllNamedOperations#shallowClone()}
   */
  @Test
  void testShallowClone3() {
    // Arrange
    HashMap<String, String> options = new HashMap<>();
    options.computeIfPresent("foo", mock(BiFunction.class));

    GetAllNamedOperations getAllNamedOperations = new GetAllNamedOperations();
    getAllNamedOperations.setOptions(options);

    // Act
    GetAllNamedOperations actualShallowCloneResult = getAllNamedOperations.shallowClone();

    // Assert
    TypeReference<Iterable<NamedOperationDetail>> outputTypeReference = actualShallowCloneResult
        .getOutputTypeReference();
    assertTrue(outputTypeReference instanceof NamedOperationTypeReference.IterableNamedOperationDetail);
    Type outputType = actualShallowCloneResult.getOutputType();
    assertEquals("java.lang.Iterable<uk.gov.gchq.gaffer.named.operation.NamedOperationDetail>",
        outputType.getTypeName());
    assertTrue(actualShallowCloneResult.getOptions().isEmpty());
    Class<Iterable> expectedOutputClass = Iterable.class;
    assertEquals(expectedOutputClass, actualShallowCloneResult.getOutputClass());
    assertSame(outputType, outputTypeReference.getType());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link GetAllNamedOperations}
   *   <li>{@link GetAllNamedOperations#setOptions(Map)}
   *   <li>{@link GetAllNamedOperations#getOptions()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    GetAllNamedOperations actualGetAllNamedOperations = new GetAllNamedOperations();
    HashMap<String, String> options = new HashMap<>();
    actualGetAllNamedOperations.setOptions(options);
    Map<String, String> actualOptions = actualGetAllNamedOperations.getOptions();

    // Assert that nothing has changed
    assertTrue(actualOptions.isEmpty());
    assertSame(options, actualOptions);
  }
}
