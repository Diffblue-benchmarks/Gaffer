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

package uk.gov.gchq.gaffer.operation.impl.export.resultcache;

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
import uk.gov.gchq.gaffer.operation.impl.job.GetJobResults;
import uk.gov.gchq.gaffer.operation.serialisation.TypeReferenceImpl;

class GetGafferResultCacheExportDiffblueTest {
  /**
   * Method under test: default or parameterless constructor of
   * {@link GetGafferResultCacheExport.Builder}
   */
  @Test
  void testBuilderNewBuilder() {
    // Arrange and Act
    GetGafferResultCacheExport.Builder actualBuilder = new GetGafferResultCacheExport.Builder();

    // Assert
    GetGafferResultCacheExport _getOpResult = actualBuilder._getOp();
    TypeReference<Iterable<?>> outputTypeReference = _getOpResult.getOutputTypeReference();
    assertTrue(outputTypeReference instanceof TypeReferenceImpl.IterableObj);
    assertEquals("ALL", _getOpResult.getKeyOrDefault());
    assertEquals("ALL", _getOpResult.getKey());
    Type outputType = _getOpResult.getOutputType();
    assertEquals("java.lang.Iterable<?>", outputType.getTypeName());
    assertNull(_getOpResult.getJobId());
    assertNull(_getOpResult.getOptions());
    Class<Iterable> expectedOutputClass = Iterable.class;
    assertEquals(expectedOutputClass, _getOpResult.getOutputClass());
    assertSame(_getOpResult, actualBuilder.build());
    assertSame(outputType, outputTypeReference.getType());
  }

  /**
   * Method under test:
   * {@link GetGafferResultCacheExport#getOutputTypeReference()}
   */
  @Test
  void testGetOutputTypeReference() {
    // Arrange and Act
    TypeReference<Iterable<?>> actualOutputTypeReference = (new GetGafferResultCacheExport()).getOutputTypeReference();

    // Assert
    assertTrue(actualOutputTypeReference instanceof TypeReferenceImpl.IterableObj);
    assertEquals("java.lang.Iterable<?>", actualOutputTypeReference.getType().getTypeName());
  }

  /**
   * Method under test:
   * {@link GetGafferResultCacheExport#getOutputTypeReference()}
   */
  @Test
  void testGetOutputTypeReference2() {
    // Arrange
    HashMap<String, String> options = new HashMap<>();
    options.computeIfPresent("foo", mock(BiFunction.class));

    GetGafferResultCacheExport getGafferResultCacheExport = new GetGafferResultCacheExport();
    getGafferResultCacheExport.setOptions(options);

    // Act
    TypeReference<Iterable<?>> actualOutputTypeReference = getGafferResultCacheExport.getOutputTypeReference();

    // Assert
    assertTrue(actualOutputTypeReference instanceof TypeReferenceImpl.IterableObj);
    assertEquals("java.lang.Iterable<?>", actualOutputTypeReference.getType().getTypeName());
  }

  /**
   * Method under test: {@link GetGafferResultCacheExport#shallowClone()}
   */
  @Test
  void testShallowClone() {
    // Arrange and Act
    GetGafferResultCacheExport actualShallowCloneResult = (new GetGafferResultCacheExport()).shallowClone();

    // Assert
    TypeReference<Iterable<?>> outputTypeReference = actualShallowCloneResult.getOutputTypeReference();
    assertTrue(outputTypeReference instanceof TypeReferenceImpl.IterableObj);
    assertEquals("ALL", actualShallowCloneResult.getKeyOrDefault());
    assertEquals("ALL", actualShallowCloneResult.getKey());
    Type outputType = actualShallowCloneResult.getOutputType();
    assertEquals("java.lang.Iterable<?>", outputType.getTypeName());
    assertNull(actualShallowCloneResult.getJobId());
    assertNull(actualShallowCloneResult.getOptions());
    Class<Iterable> expectedOutputClass = Iterable.class;
    assertEquals(expectedOutputClass, actualShallowCloneResult.getOutputClass());
    assertSame(outputType, outputTypeReference.getType());
  }

  /**
   * Method under test: {@link GetGafferResultCacheExport#shallowClone()}
   */
  @Test
  void testShallowClone2() {
    // Arrange
    GetGafferResultCacheExport getGafferResultCacheExport = new GetGafferResultCacheExport();
    getGafferResultCacheExport.setOptions(new HashMap<>());

    // Act
    GetGafferResultCacheExport actualShallowCloneResult = getGafferResultCacheExport.shallowClone();

    // Assert
    TypeReference<Iterable<?>> outputTypeReference = actualShallowCloneResult.getOutputTypeReference();
    assertTrue(outputTypeReference instanceof TypeReferenceImpl.IterableObj);
    assertEquals("ALL", actualShallowCloneResult.getKeyOrDefault());
    assertEquals("ALL", actualShallowCloneResult.getKey());
    Type outputType = actualShallowCloneResult.getOutputType();
    assertEquals("java.lang.Iterable<?>", outputType.getTypeName());
    assertNull(actualShallowCloneResult.getJobId());
    assertTrue(actualShallowCloneResult.getOptions().isEmpty());
    Class<Iterable> expectedOutputClass = Iterable.class;
    assertEquals(expectedOutputClass, actualShallowCloneResult.getOutputClass());
    assertSame(outputType, outputTypeReference.getType());
  }

  /**
   * Method under test: {@link GetGafferResultCacheExport#shallowClone()}
   */
  @Test
  void testShallowClone3() {
    // Arrange and Act
    GetJobResults actualShallowCloneResult = (new GetJobResults()).shallowClone();

    // Assert
    assertTrue(actualShallowCloneResult instanceof GetJobResults);
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
   * Method under test: {@link GetGafferResultCacheExport#shallowClone()}
   */
  @Test
  void testShallowClone4() {
    // Arrange
    HashMap<String, String> options = new HashMap<>();
    options.computeIfPresent("ALL", mock(BiFunction.class));

    GetGafferResultCacheExport getGafferResultCacheExport = new GetGafferResultCacheExport();
    getGafferResultCacheExport.setOptions(options);

    // Act
    GetGafferResultCacheExport actualShallowCloneResult = getGafferResultCacheExport.shallowClone();

    // Assert
    TypeReference<Iterable<?>> outputTypeReference = actualShallowCloneResult.getOutputTypeReference();
    assertTrue(outputTypeReference instanceof TypeReferenceImpl.IterableObj);
    assertEquals("ALL", actualShallowCloneResult.getKeyOrDefault());
    assertEquals("ALL", actualShallowCloneResult.getKey());
    Type outputType = actualShallowCloneResult.getOutputType();
    assertEquals("java.lang.Iterable<?>", outputType.getTypeName());
    assertNull(actualShallowCloneResult.getJobId());
    assertTrue(actualShallowCloneResult.getOptions().isEmpty());
    Class<Iterable> expectedOutputClass = Iterable.class;
    assertEquals(expectedOutputClass, actualShallowCloneResult.getOutputClass());
    assertSame(outputType, outputTypeReference.getType());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of
   * {@link GetGafferResultCacheExport}
   *   <li>{@link GetGafferResultCacheExport#setJobId(String)}
   *   <li>{@link GetGafferResultCacheExport#setKey(String)}
   *   <li>{@link GetGafferResultCacheExport#setOptions(Map)}
   *   <li>{@link GetGafferResultCacheExport#getJobId()}
   *   <li>{@link GetGafferResultCacheExport#getKey()}
   *   <li>{@link GetGafferResultCacheExport#getOptions()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    GetGafferResultCacheExport actualGetGafferResultCacheExport = new GetGafferResultCacheExport();
    actualGetGafferResultCacheExport.setJobId("42");
    actualGetGafferResultCacheExport.setKey("Key");
    HashMap<String, String> options = new HashMap<>();
    actualGetGafferResultCacheExport.setOptions(options);
    String actualJobId = actualGetGafferResultCacheExport.getJobId();
    String actualKey = actualGetGafferResultCacheExport.getKey();
    Map<String, String> actualOptions = actualGetGafferResultCacheExport.getOptions();

    // Assert that nothing has changed
    assertEquals("42", actualJobId);
    assertEquals("Key", actualKey);
    assertTrue(actualOptions.isEmpty());
    assertSame(options, actualOptions);
  }
}
