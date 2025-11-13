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

package uk.gov.gchq.gaffer.store.operation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.core.type.TypeReference;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.lang3.exception.CloneFailedException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.store.TypeReferenceStoreImpl;
import uk.gov.gchq.gaffer.store.operation.GetSchema.Builder;
import uk.gov.gchq.gaffer.store.schema.Schema;

class GetSchemaDiffblueTest {
  /**
   * Test Builder {@link Builder#compact(boolean)}.
   * <p>
   * Method under test: {@link Builder#compact(boolean)}
   */
  @Test
  @DisplayName("Test Builder compact(boolean)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.compact(boolean)"})
  void testBuilderCompact() {
    // Arrange
    Builder builder = new Builder();

    // Act and Assert
    assertSame(builder, builder.compact(true));
  }

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
    Builder actualBuilder = new Builder();

    // Assert
    GetSchema _getOpResult = actualBuilder._getOp();
    TypeReference<Schema> outputTypeReference = _getOpResult.getOutputTypeReference();
    assertTrue(outputTypeReference instanceof TypeReferenceStoreImpl.Schema);
    assertNull(_getOpResult.getOptions());
    assertFalse(_getOpResult.isCompact());
    Class<Schema> expectedOutputClass = Schema.class;
    Class<?> outputClass = _getOpResult.getOutputClass();
    assertEquals(expectedOutputClass, outputClass);
    assertSame(_getOpResult, actualBuilder.build());
    assertSame(outputClass, outputTypeReference.getType());
    assertSame(outputClass, _getOpResult.getOutputType());
  }

  /**
   * Test {@link GetSchema#shallowClone()}.
   * <ul>
   *   <li>Given {@link GetSchema} (default constructor) Options is {@link HashMap#HashMap()}.</li>
   *   <li>Then return Options Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link GetSchema#shallowClone()}
   */
  @Test
  @DisplayName("Test shallowClone(); given GetSchema (default constructor) Options is HashMap(); then return Options Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"GetSchema GetSchema.shallowClone()"})
  void testShallowClone_givenGetSchemaOptionsIsHashMap_thenReturnOptionsEmpty() throws CloneFailedException {
    // Arrange
    GetSchema getSchema = new GetSchema();
    getSchema.setOptions(new HashMap<>());

    // Act
    GetSchema actualShallowCloneResult = getSchema.shallowClone();

    // Assert
    TypeReference<Schema> outputTypeReference = actualShallowCloneResult.getOutputTypeReference();
    assertTrue(outputTypeReference instanceof TypeReferenceStoreImpl.Schema);
    assertFalse(actualShallowCloneResult.isCompact());
    assertTrue(actualShallowCloneResult.getOptions().isEmpty());
    Class<Schema> expectedOutputClass = Schema.class;
    Class<?> outputClass = actualShallowCloneResult.getOutputClass();
    assertEquals(expectedOutputClass, outputClass);
    assertSame(outputClass, outputTypeReference.getType());
    assertSame(outputClass, actualShallowCloneResult.getOutputType());
  }

  /**
   * Test {@link GetSchema#shallowClone()}.
   * <ul>
   *   <li>Given {@link GetSchema} (default constructor).</li>
   *   <li>Then return Options is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GetSchema#shallowClone()}
   */
  @Test
  @DisplayName("Test shallowClone(); given GetSchema (default constructor); then return Options is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"GetSchema GetSchema.shallowClone()"})
  void testShallowClone_givenGetSchema_thenReturnOptionsIsNull() throws CloneFailedException {
    // Arrange and Act
    GetSchema actualShallowCloneResult = (new GetSchema()).shallowClone();

    // Assert
    TypeReference<Schema> outputTypeReference = actualShallowCloneResult.getOutputTypeReference();
    assertTrue(outputTypeReference instanceof TypeReferenceStoreImpl.Schema);
    assertNull(actualShallowCloneResult.getOptions());
    assertFalse(actualShallowCloneResult.isCompact());
    Class<Schema> expectedOutputClass = Schema.class;
    Class<?> outputClass = actualShallowCloneResult.getOutputClass();
    assertEquals(expectedOutputClass, outputClass);
    assertSame(outputClass, outputTypeReference.getType());
    assertSame(outputClass, actualShallowCloneResult.getOutputType());
  }

  /**
   * Test {@link GetSchema#getOutputTypeReference()}.
   * <p>
   * Method under test: {@link GetSchema#getOutputTypeReference()}
   */
  @Test
  @DisplayName("Test getOutputTypeReference()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TypeReference GetSchema.getOutputTypeReference()"})
  void testGetOutputTypeReference() {
    // Arrange, Act and Assert
    assertTrue((new GetSchema()).getOutputTypeReference() instanceof TypeReferenceStoreImpl.Schema);
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link GetSchema}
   *   <li>{@link GetSchema#setCompact(boolean)}
   *   <li>{@link GetSchema#setOptions(Map)}
   *   <li>{@link GetSchema#getOptions()}
   *   <li>{@link GetSchema#isCompact()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void GetSchema.<init>()", "Map GetSchema.getOptions()", "boolean GetSchema.isCompact()",
      "void GetSchema.setCompact(boolean)", "void GetSchema.setOptions(Map)"})
  void testGettersAndSetters() {
    // Arrange and Act
    GetSchema actualGetSchema = new GetSchema();
    actualGetSchema.setCompact(true);
    HashMap<String, String> options = new HashMap<>();
    actualGetSchema.setOptions(options);
    Map<String, String> actualOptions = actualGetSchema.getOptions();
    boolean actualIsCompactResult = actualGetSchema.isCompact();

    // Assert
    assertTrue(actualOptions.isEmpty());
    assertTrue(actualIsCompactResult);
    assertSame(options, actualOptions);
  }
}
