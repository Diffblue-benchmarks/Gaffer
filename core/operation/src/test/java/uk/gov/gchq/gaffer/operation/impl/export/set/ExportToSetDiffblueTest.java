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

package uk.gov.gchq.gaffer.operation.impl.export.set;

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

class ExportToSetDiffblueTest {
  /**
   * Method under test: default or parameterless constructor of
   * {@link ExportToSet.Builder}
   */
  @Test
  void testBuilderNewBuilder() {
    // Arrange and Act
    ExportToSet.Builder<Object> actualBuilder = new ExportToSet.Builder<>();

    // Assert
    ExportToSet<Object> _getOpResult = actualBuilder._getOp();
    TypeReference<Object> outputTypeReference = _getOpResult.getOutputTypeReference();
    assertTrue(outputTypeReference instanceof TypeReferenceImpl.Object);
    assertEquals("ALL", _getOpResult.getKeyOrDefault());
    assertNull(_getOpResult.getInput());
    assertNull(_getOpResult.getKey());
    assertNull(_getOpResult.getOptions());
    Class<Object> expectedOutputClass = Object.class;
    Class<?> outputClass = _getOpResult.getOutputClass();
    assertEquals(expectedOutputClass, outputClass);
    assertSame(_getOpResult, actualBuilder.build());
    assertSame(outputClass, outputTypeReference.getType());
    assertSame(outputClass, _getOpResult.getOutputType());
  }

  /**
   * Method under test: {@link ExportToSet#getOutputTypeReference()}
   */
  @Test
  void testGetOutputTypeReference() {
    // Arrange
    ExportToSet<Object> exportToSet = new ExportToSet<>();

    // Act and Assert
    assertTrue(exportToSet.getOutputTypeReference() instanceof TypeReferenceImpl.Object);
  }

  /**
   * Method under test: {@link ExportToSet#getOutputTypeReference()}
   */
  @Test
  void testGetOutputTypeReference2() {
    // Arrange
    HashMap<String, String> options = new HashMap<>();
    options.computeIfPresent("foo", mock(BiFunction.class));

    ExportToSet<Object> exportToSet = new ExportToSet<>();
    exportToSet.setOptions(options);

    // Act and Assert
    assertTrue(exportToSet.getOutputTypeReference() instanceof TypeReferenceImpl.Object);
  }

  /**
   * Method under test: {@link ExportToSet#shallowClone()}
   */
  @Test
  void testShallowClone() {
    // Arrange
    ExportToSet<Object> exportToSet = new ExportToSet<>();

    // Act
    ExportToSet<Object> actualShallowCloneResult = exportToSet.shallowClone();

    // Assert
    TypeReference<Object> outputTypeReference = actualShallowCloneResult.getOutputTypeReference();
    assertTrue(outputTypeReference instanceof TypeReferenceImpl.Object);
    assertEquals("ALL", actualShallowCloneResult.getKeyOrDefault());
    assertNull(actualShallowCloneResult.getInput());
    assertNull(actualShallowCloneResult.getKey());
    assertNull(actualShallowCloneResult.getOptions());
    Class<Object> expectedOutputClass = Object.class;
    Class<?> outputClass = actualShallowCloneResult.getOutputClass();
    assertEquals(expectedOutputClass, outputClass);
    assertSame(outputClass, outputTypeReference.getType());
    assertSame(outputClass, actualShallowCloneResult.getOutputType());
  }

  /**
   * Method under test: {@link ExportToSet#shallowClone()}
   */
  @Test
  void testShallowClone2() {
    // Arrange
    ExportToSet<Object> exportToSet = new ExportToSet<>();
    exportToSet.setOptions(new HashMap<>());

    // Act
    ExportToSet<Object> actualShallowCloneResult = exportToSet.shallowClone();

    // Assert
    TypeReference<Object> outputTypeReference = actualShallowCloneResult.getOutputTypeReference();
    assertTrue(outputTypeReference instanceof TypeReferenceImpl.Object);
    assertEquals("ALL", actualShallowCloneResult.getKeyOrDefault());
    assertNull(actualShallowCloneResult.getInput());
    assertNull(actualShallowCloneResult.getKey());
    assertTrue(actualShallowCloneResult.getOptions().isEmpty());
    Class<Object> expectedOutputClass = Object.class;
    Class<?> outputClass = actualShallowCloneResult.getOutputClass();
    assertEquals(expectedOutputClass, outputClass);
    assertSame(outputClass, outputTypeReference.getType());
    assertSame(outputClass, actualShallowCloneResult.getOutputType());
  }

  /**
   * Method under test: {@link ExportToSet#shallowClone()}
   */
  @Test
  void testShallowClone3() {
    // Arrange
    HashMap<String, String> options = new HashMap<>();
    options.computeIfPresent("foo", mock(BiFunction.class));

    ExportToSet<Object> exportToSet = new ExportToSet<>();
    exportToSet.setOptions(options);

    // Act
    ExportToSet<Object> actualShallowCloneResult = exportToSet.shallowClone();

    // Assert
    TypeReference<Object> outputTypeReference = actualShallowCloneResult.getOutputTypeReference();
    assertTrue(outputTypeReference instanceof TypeReferenceImpl.Object);
    assertEquals("ALL", actualShallowCloneResult.getKeyOrDefault());
    assertNull(actualShallowCloneResult.getInput());
    assertNull(actualShallowCloneResult.getKey());
    assertTrue(actualShallowCloneResult.getOptions().isEmpty());
    Class<Object> expectedOutputClass = Object.class;
    Class<?> outputClass = actualShallowCloneResult.getOutputClass();
    assertEquals(expectedOutputClass, outputClass);
    assertSame(outputClass, outputTypeReference.getType());
    assertSame(outputClass, actualShallowCloneResult.getOutputType());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link ExportToSet}
   *   <li>{@link ExportToSet#setInput(Object)}
   *   <li>{@link ExportToSet#setKey(String)}
   *   <li>{@link ExportToSet#setOptions(Map)}
   *   <li>{@link ExportToSet#getInput()}
   *   <li>{@link ExportToSet#getKey()}
   *   <li>{@link ExportToSet#getOptions()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    ExportToSet<Object> actualExportToSet = new ExportToSet<>();
    actualExportToSet.setInput("Input");
    actualExportToSet.setKey("Key");
    HashMap<String, String> options = new HashMap<>();
    actualExportToSet.setOptions(options);
    Object actualInput = actualExportToSet.getInput();
    String actualKey = actualExportToSet.getKey();
    Map<String, String> actualOptions = actualExportToSet.getOptions();

    // Assert that nothing has changed
    assertEquals("Input", actualInput);
    assertEquals("Key", actualKey);
    assertTrue(actualOptions.isEmpty());
    assertSame(options, actualOptions);
  }
}
