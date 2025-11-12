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
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.function.BiFunction;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.operation.serialisation.TypeReferenceImpl;

class ExportToGafferResultCacheDiffblueTest {
  /**
   * Method under test: default or parameterless constructor of
   * {@link ExportToGafferResultCache.Builder}
   */
  @Test
  void testBuilderNewBuilder() {
    // Arrange and Act
    ExportToGafferResultCache.Builder<Object> actualBuilder = new ExportToGafferResultCache.Builder<>();

    // Assert
    ExportToGafferResultCache<Object> _getOpResult = actualBuilder._getOp();
    TypeReference<Object> outputTypeReference = _getOpResult.getOutputTypeReference();
    assertTrue(outputTypeReference instanceof TypeReferenceImpl.Object);
    assertEquals("ALL", _getOpResult.getKeyOrDefault());
    assertNull(_getOpResult.getInput());
    assertNull(_getOpResult.getKey());
    assertNull(_getOpResult.getOptions());
    assertNull(_getOpResult.getOpAuths());
    Class<Object> expectedOutputClass = Object.class;
    Class<?> outputClass = _getOpResult.getOutputClass();
    assertEquals(expectedOutputClass, outputClass);
    assertSame(_getOpResult, actualBuilder.build());
    assertSame(outputClass, outputTypeReference.getType());
    assertSame(outputClass, _getOpResult.getOutputType());
  }

  /**
   * Method under test: {@link ExportToGafferResultCache.Builder#opAuths(Set)}
   */
  @Test
  void testBuilderOpAuths() {
    // Arrange
    ExportToGafferResultCache.Builder<Object> builder = new ExportToGafferResultCache.Builder<>();

    // Act and Assert
    assertSame(builder, builder.opAuths(new HashSet<>()));
  }

  /**
   * Method under test: {@link ExportToGafferResultCache.Builder#opAuths(Set)}
   */
  @Test
  void testBuilderOpAuths2() {
    // Arrange
    ExportToGafferResultCache.Builder<Object> builder = new ExportToGafferResultCache.Builder<>();

    HashSet<String> opAuths = new HashSet<>();
    opAuths.add("foo");

    // Act and Assert
    assertSame(builder, builder.opAuths(opAuths));
  }

  /**
   * Method under test: {@link ExportToGafferResultCache.Builder#opAuths(Set)}
   */
  @Test
  void testBuilderOpAuths3() {
    // Arrange
    ExportToGafferResultCache.Builder<Object> builder = new ExportToGafferResultCache.Builder<>();

    HashSet<String> opAuths = new HashSet<>();
    opAuths.add("42");
    opAuths.add("foo");

    // Act and Assert
    assertSame(builder, builder.opAuths(opAuths));
  }

  /**
   * Method under test:
   * {@link ExportToGafferResultCache.Builder#opAuths(String[])}
   */
  @Test
  void testBuilderOpAuths4() {
    // Arrange
    ExportToGafferResultCache.Builder<Object> builder = new ExportToGafferResultCache.Builder<>();

    // Act and Assert
    assertSame(builder, builder.opAuths("Op Auths"));
  }

  /**
   * Method under test:
   * {@link ExportToGafferResultCache.Builder#opAuths(String[])}
   */
  @Test
  void testBuilderOpAuths5() {
    // Arrange
    ExportToGafferResultCache.Builder<Object> builder = new ExportToGafferResultCache.Builder<>();

    // Act and Assert
    assertSame(builder, builder.opAuths("Op Auths", "42", "Op Auths"));
  }

  /**
   * Method under test: {@link ExportToGafferResultCache#shallowClone()}
   */
  @Test
  void testShallowClone() {
    // Arrange
    ExportToGafferResultCache<Object> exportToGafferResultCache = new ExportToGafferResultCache<>();

    // Act
    ExportToGafferResultCache<Object> actualShallowCloneResult = exportToGafferResultCache.shallowClone();

    // Assert
    TypeReference<Object> outputTypeReference = actualShallowCloneResult.getOutputTypeReference();
    assertTrue(outputTypeReference instanceof TypeReferenceImpl.Object);
    assertEquals("ALL", actualShallowCloneResult.getKeyOrDefault());
    assertNull(actualShallowCloneResult.getInput());
    assertNull(actualShallowCloneResult.getKey());
    assertNull(actualShallowCloneResult.getOptions());
    assertNull(actualShallowCloneResult.getOpAuths());
    Class<Object> expectedOutputClass = Object.class;
    Class<?> outputClass = actualShallowCloneResult.getOutputClass();
    assertEquals(expectedOutputClass, outputClass);
    assertSame(outputClass, outputTypeReference.getType());
    assertSame(outputClass, actualShallowCloneResult.getOutputType());
  }

  /**
   * Method under test: {@link ExportToGafferResultCache#shallowClone()}
   */
  @Test
  void testShallowClone2() {
    // Arrange
    ExportToGafferResultCache<Object> exportToGafferResultCache = new ExportToGafferResultCache<>();
    exportToGafferResultCache.setOptions(new HashMap<>());

    // Act
    ExportToGafferResultCache<Object> actualShallowCloneResult = exportToGafferResultCache.shallowClone();

    // Assert
    TypeReference<Object> outputTypeReference = actualShallowCloneResult.getOutputTypeReference();
    assertTrue(outputTypeReference instanceof TypeReferenceImpl.Object);
    assertEquals("ALL", actualShallowCloneResult.getKeyOrDefault());
    assertNull(actualShallowCloneResult.getInput());
    assertNull(actualShallowCloneResult.getKey());
    assertNull(actualShallowCloneResult.getOpAuths());
    assertTrue(actualShallowCloneResult.getOptions().isEmpty());
    Class<Object> expectedOutputClass = Object.class;
    Class<?> outputClass = actualShallowCloneResult.getOutputClass();
    assertEquals(expectedOutputClass, outputClass);
    assertSame(outputClass, outputTypeReference.getType());
    assertSame(outputClass, actualShallowCloneResult.getOutputType());
  }

  /**
   * Method under test: {@link ExportToGafferResultCache#shallowClone()}
   */
  @Test
  void testShallowClone3() {
    // Arrange
    HashMap<String, String> options = new HashMap<>();
    options.computeIfPresent("foo", mock(BiFunction.class));

    ExportToGafferResultCache<Object> exportToGafferResultCache = new ExportToGafferResultCache<>();
    exportToGafferResultCache.setOptions(options);

    // Act
    ExportToGafferResultCache<Object> actualShallowCloneResult = exportToGafferResultCache.shallowClone();

    // Assert
    TypeReference<Object> outputTypeReference = actualShallowCloneResult.getOutputTypeReference();
    assertTrue(outputTypeReference instanceof TypeReferenceImpl.Object);
    assertEquals("ALL", actualShallowCloneResult.getKeyOrDefault());
    assertNull(actualShallowCloneResult.getInput());
    assertNull(actualShallowCloneResult.getKey());
    assertNull(actualShallowCloneResult.getOpAuths());
    assertTrue(actualShallowCloneResult.getOptions().isEmpty());
    Class<Object> expectedOutputClass = Object.class;
    Class<?> outputClass = actualShallowCloneResult.getOutputClass();
    assertEquals(expectedOutputClass, outputClass);
    assertSame(outputClass, outputTypeReference.getType());
    assertSame(outputClass, actualShallowCloneResult.getOutputType());
  }

  /**
   * Method under test: {@link ExportToGafferResultCache#getOutputTypeReference()}
   */
  @Test
  void testGetOutputTypeReference() {
    // Arrange
    ExportToGafferResultCache<Object> exportToGafferResultCache = new ExportToGafferResultCache<>();

    // Act and Assert
    assertTrue(exportToGafferResultCache.getOutputTypeReference() instanceof TypeReferenceImpl.Object);
  }

  /**
   * Method under test: {@link ExportToGafferResultCache#getOutputTypeReference()}
   */
  @Test
  void testGetOutputTypeReference2() {
    // Arrange
    HashMap<String, String> options = new HashMap<>();
    options.computeIfPresent("foo", mock(BiFunction.class));

    ExportToGafferResultCache<Object> exportToGafferResultCache = new ExportToGafferResultCache<>();
    exportToGafferResultCache.setOptions(options);

    // Act and Assert
    assertTrue(exportToGafferResultCache.getOutputTypeReference() instanceof TypeReferenceImpl.Object);
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link ExportToGafferResultCache}
   *   <li>{@link ExportToGafferResultCache#setInput(Object)}
   *   <li>{@link ExportToGafferResultCache#setKey(String)}
   *   <li>{@link ExportToGafferResultCache#setOpAuths(Set)}
   *   <li>{@link ExportToGafferResultCache#setOptions(Map)}
   *   <li>{@link ExportToGafferResultCache#getInput()}
   *   <li>{@link ExportToGafferResultCache#getKey()}
   *   <li>{@link ExportToGafferResultCache#getOpAuths()}
   *   <li>{@link ExportToGafferResultCache#getOptions()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    ExportToGafferResultCache<Object> actualExportToGafferResultCache = new ExportToGafferResultCache<>();
    actualExportToGafferResultCache.setInput("Input");
    actualExportToGafferResultCache.setKey("Key");
    HashSet<String> opAuths = new HashSet<>();
    actualExportToGafferResultCache.setOpAuths(opAuths);
    HashMap<String, String> options = new HashMap<>();
    actualExportToGafferResultCache.setOptions(options);
    Object actualInput = actualExportToGafferResultCache.getInput();
    String actualKey = actualExportToGafferResultCache.getKey();
    Set<String> actualOpAuths = actualExportToGafferResultCache.getOpAuths();
    Map<String, String> actualOptions = actualExportToGafferResultCache.getOptions();

    // Assert that nothing has changed
    assertEquals("Input", actualInput);
    assertEquals("Key", actualKey);
    assertTrue(actualOptions.isEmpty());
    assertTrue(actualOpAuths.isEmpty());
    assertSame(options, actualOptions);
    assertSame(opAuths, actualOpAuths);
  }
}
