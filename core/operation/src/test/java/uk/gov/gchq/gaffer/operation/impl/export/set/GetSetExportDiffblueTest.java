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
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.operation.serialisation.TypeReferenceImpl;

class GetSetExportDiffblueTest {
  /**
   * Method under test: {@link GetSetExport.Builder#end(Integer)}
   */
  @Test
  void testBuilderEnd() {
    // Arrange
    GetSetExport.Builder builder = new GetSetExport.Builder();

    // Act and Assert
    assertSame(builder, builder.end(3));
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link GetSetExport.Builder}
   */
  @Test
  void testBuilderNewBuilder() {
    // Arrange and Act
    GetSetExport.Builder actualBuilder = new GetSetExport.Builder();

    // Assert
    GetSetExport _getOpResult = actualBuilder._getOp();
    TypeReference<Iterable<?>> outputTypeReference = _getOpResult.getOutputTypeReference();
    assertTrue(outputTypeReference instanceof TypeReferenceImpl.IterableObj);
    assertEquals("ALL", _getOpResult.getKeyOrDefault());
    Type outputType = _getOpResult.getOutputType();
    assertEquals("java.lang.Iterable<?>", outputType.getTypeName());
    assertNull(_getOpResult.getEnd());
    assertNull(_getOpResult.getJobId());
    assertNull(_getOpResult.getKey());
    assertNull(_getOpResult.getOptions());
    assertEquals(0, _getOpResult.getStart());
    Class<Iterable> expectedOutputClass = Iterable.class;
    assertEquals(expectedOutputClass, _getOpResult.getOutputClass());
    assertSame(_getOpResult, actualBuilder.build());
    assertSame(outputType, outputTypeReference.getType());
  }

  /**
   * Method under test: {@link GetSetExport.Builder#start(int)}
   */
  @Test
  void testBuilderStart() {
    // Arrange
    GetSetExport.Builder builder = new GetSetExport.Builder();

    // Act and Assert
    assertSame(builder, builder.start(1));
  }

  /**
   * Method under test: {@link GetSetExport#getOutputTypeReference()}
   */
  @Test
  void testGetOutputTypeReference() {
    // Arrange and Act
    TypeReference<Iterable<?>> actualOutputTypeReference = (new GetSetExport()).getOutputTypeReference();

    // Assert
    assertTrue(actualOutputTypeReference instanceof TypeReferenceImpl.IterableObj);
    assertEquals("java.lang.Iterable<?>", actualOutputTypeReference.getType().getTypeName());
  }

  /**
   * Method under test: {@link GetSetExport#getOutputTypeReference()}
   */
  @Test
  void testGetOutputTypeReference2() {
    // Arrange
    HashMap<String, String> options = new HashMap<>();
    options.computeIfPresent("foo", mock(BiFunction.class));

    GetSetExport getSetExport = new GetSetExport();
    getSetExport.setOptions(options);

    // Act
    TypeReference<Iterable<?>> actualOutputTypeReference = getSetExport.getOutputTypeReference();

    // Assert
    assertTrue(actualOutputTypeReference instanceof TypeReferenceImpl.IterableObj);
    assertEquals("java.lang.Iterable<?>", actualOutputTypeReference.getType().getTypeName());
  }

  /**
   * Method under test: {@link GetSetExport#shallowClone()}
   */
  @Test
  void testShallowClone() {
    // Arrange and Act
    GetSetExport actualShallowCloneResult = (new GetSetExport()).shallowClone();

    // Assert
    TypeReference<Iterable<?>> outputTypeReference = actualShallowCloneResult.getOutputTypeReference();
    assertTrue(outputTypeReference instanceof TypeReferenceImpl.IterableObj);
    assertEquals("ALL", actualShallowCloneResult.getKeyOrDefault());
    Type outputType = actualShallowCloneResult.getOutputType();
    assertEquals("java.lang.Iterable<?>", outputType.getTypeName());
    assertNull(actualShallowCloneResult.getEnd());
    assertNull(actualShallowCloneResult.getJobId());
    assertNull(actualShallowCloneResult.getKey());
    assertNull(actualShallowCloneResult.getOptions());
    assertEquals(0, actualShallowCloneResult.getStart());
    Class<Iterable> expectedOutputClass = Iterable.class;
    assertEquals(expectedOutputClass, actualShallowCloneResult.getOutputClass());
    assertSame(outputType, outputTypeReference.getType());
  }

  /**
   * Method under test: {@link GetSetExport#shallowClone()}
   */
  @Test
  void testShallowClone2() {
    // Arrange
    GetSetExport getSetExport = new GetSetExport();
    getSetExport.setOptions(new HashMap<>());

    // Act
    GetSetExport actualShallowCloneResult = getSetExport.shallowClone();

    // Assert
    TypeReference<Iterable<?>> outputTypeReference = actualShallowCloneResult.getOutputTypeReference();
    assertTrue(outputTypeReference instanceof TypeReferenceImpl.IterableObj);
    assertEquals("ALL", actualShallowCloneResult.getKeyOrDefault());
    Type outputType = actualShallowCloneResult.getOutputType();
    assertEquals("java.lang.Iterable<?>", outputType.getTypeName());
    assertNull(actualShallowCloneResult.getEnd());
    assertNull(actualShallowCloneResult.getJobId());
    assertNull(actualShallowCloneResult.getKey());
    assertEquals(0, actualShallowCloneResult.getStart());
    assertTrue(actualShallowCloneResult.getOptions().isEmpty());
    Class<Iterable> expectedOutputClass = Iterable.class;
    assertEquals(expectedOutputClass, actualShallowCloneResult.getOutputClass());
    assertSame(outputType, outputTypeReference.getType());
  }

  /**
   * Method under test: {@link GetSetExport#shallowClone()}
   */
  @Test
  void testShallowClone3() {
    // Arrange
    HashMap<String, String> options = new HashMap<>();
    options.computeIfPresent("foo", mock(BiFunction.class));

    GetSetExport getSetExport = new GetSetExport();
    getSetExport.setOptions(options);

    // Act
    GetSetExport actualShallowCloneResult = getSetExport.shallowClone();

    // Assert
    TypeReference<Iterable<?>> outputTypeReference = actualShallowCloneResult.getOutputTypeReference();
    assertTrue(outputTypeReference instanceof TypeReferenceImpl.IterableObj);
    assertEquals("ALL", actualShallowCloneResult.getKeyOrDefault());
    Type outputType = actualShallowCloneResult.getOutputType();
    assertEquals("java.lang.Iterable<?>", outputType.getTypeName());
    assertNull(actualShallowCloneResult.getEnd());
    assertNull(actualShallowCloneResult.getJobId());
    assertNull(actualShallowCloneResult.getKey());
    assertEquals(0, actualShallowCloneResult.getStart());
    assertTrue(actualShallowCloneResult.getOptions().isEmpty());
    Class<Iterable> expectedOutputClass = Iterable.class;
    assertEquals(expectedOutputClass, actualShallowCloneResult.getOutputClass());
    assertSame(outputType, outputTypeReference.getType());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link GetSetExport}
   *   <li>{@link GetSetExport#setEnd(Integer)}
   *   <li>{@link GetSetExport#setJobId(String)}
   *   <li>{@link GetSetExport#setKey(String)}
   *   <li>{@link GetSetExport#setOptions(Map)}
   *   <li>{@link GetSetExport#setStart(int)}
   *   <li>{@link GetSetExport#getEnd()}
   *   <li>{@link GetSetExport#getJobId()}
   *   <li>{@link GetSetExport#getKey()}
   *   <li>{@link GetSetExport#getOptions()}
   *   <li>{@link GetSetExport#getStart()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    GetSetExport actualGetSetExport = new GetSetExport();
    actualGetSetExport.setEnd(3);
    actualGetSetExport.setJobId("42");
    actualGetSetExport.setKey("Key");
    HashMap<String, String> options = new HashMap<>();
    actualGetSetExport.setOptions(options);
    actualGetSetExport.setStart(1);
    Integer actualEnd = actualGetSetExport.getEnd();
    String actualJobId = actualGetSetExport.getJobId();
    String actualKey = actualGetSetExport.getKey();
    Map<String, String> actualOptions = actualGetSetExport.getOptions();

    // Assert that nothing has changed
    assertEquals("42", actualJobId);
    assertEquals("Key", actualKey);
    assertEquals(1, actualGetSetExport.getStart());
    assertEquals(3, actualEnd.intValue());
    assertTrue(actualOptions.isEmpty());
    assertSame(options, actualOptions);
  }
}
