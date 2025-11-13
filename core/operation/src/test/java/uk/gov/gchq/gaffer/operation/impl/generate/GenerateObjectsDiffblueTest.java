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

package uk.gov.gchq.gaffer.operation.impl.generate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.core.type.TypeReference;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.function.Function;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.operation.impl.generate.GenerateObjects.Builder;
import uk.gov.gchq.gaffer.operation.serialisation.TypeReferenceImpl;
import uk.gov.gchq.gaffer.operation.serialisation.TypeReferenceImpl.IterableObj;

class GenerateObjectsDiffblueTest {
  /**
   * Test Builder {@link Builder#generator(Function)}.
   * <p>
   * Method under test: {@link Builder#generator(Function)}
   */
  @Test
  @DisplayName("Test Builder generator(Function)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.generator(Function)"})
  void testBuilderGenerator() {
    // Arrange
    Builder<Object> builder = new Builder<>();

    // Act and Assert
    assertSame(builder, builder.generator(mock(Function.class)));
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
    Builder<Object> actualBuilder = new Builder<>();

    // Assert
    GenerateObjects<Object> _getOpResult = actualBuilder._getOp();
    TypeReference<Iterable<?>> outputTypeReference = _getOpResult.getOutputTypeReference();
    assertTrue(outputTypeReference instanceof IterableObj);
    Type outputType = _getOpResult.getOutputType();
    assertEquals("java.lang.Iterable<?>", outputType.getTypeName());
    assertNull(_getOpResult.getInput());
    assertNull(_getOpResult.getOptions());
    assertNull(_getOpResult.getElementGenerator());
    Class<Iterable> expectedOutputClass = Iterable.class;
    assertEquals(expectedOutputClass, _getOpResult.getOutputClass());
    assertSame(_getOpResult, actualBuilder.build());
    assertSame(outputType, outputTypeReference.getType());
  }

  /**
   * Test {@link GenerateObjects#createInputArray()}.
   * <ul>
   *   <li>Given {@link GenerateObjects#GenerateObjects()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GenerateObjects#createInputArray()}
   */
  @Test
  @DisplayName("Test createInputArray(); given GenerateObjects(); then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object[] GenerateObjects.createInputArray()"})
  void testCreateInputArray_givenGenerateObjects_thenReturnNull() {
    // Arrange
    GenerateObjects<Object> generateObjects = new GenerateObjects<>();

    // Act and Assert
    assertNull(generateObjects.createInputArray());
  }

  /**
   * Test {@link GenerateObjects#createInputArray()}.
   * <ul>
   *   <li>Then return array length is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link GenerateObjects#createInputArray()}
   */
  @Test
  @DisplayName("Test createInputArray(); then return array length is zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object[] GenerateObjects.createInputArray()"})
  void testCreateInputArray_thenReturnArrayLengthIsZero() {
    // Arrange
    GenerateObjects<Object> generateObjects = new GenerateObjects<>();
    generateObjects.setInput(new ArrayList<>());

    // Act and Assert
    assertEquals(0, generateObjects.createInputArray().length);
  }

  /**
   * Test {@link GenerateObjects#getOutputTypeReference()}.
   * <p>
   * Method under test: {@link GenerateObjects#getOutputTypeReference()}
   */
  @Test
  @DisplayName("Test getOutputTypeReference()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TypeReference GenerateObjects.getOutputTypeReference()"})
  void testGetOutputTypeReference() {
    // Arrange
    GenerateObjects<Object> generateObjects = new GenerateObjects<>();

    // Act
    TypeReference<Iterable<?>> actualOutputTypeReference = generateObjects.getOutputTypeReference();

    // Assert
    assertTrue(actualOutputTypeReference instanceof IterableObj);
    assertEquals("java.lang.Iterable<?>", actualOutputTypeReference.getType().getTypeName());
  }

  /**
   * Test {@link GenerateObjects#shallowClone()}.
   * <ul>
   *   <li>Given {@link GenerateObjects#GenerateObjects()} Options is {@link HashMap#HashMap()}.</li>
   *   <li>Then return Options Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link GenerateObjects#shallowClone()}
   */
  @Test
  @DisplayName("Test shallowClone(); given GenerateObjects() Options is HashMap(); then return Options Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"GenerateObjects GenerateObjects.shallowClone()"})
  void testShallowClone_givenGenerateObjectsOptionsIsHashMap_thenReturnOptionsEmpty() {
    // Arrange
    GenerateObjects<Object> generateObjects = new GenerateObjects<>();
    generateObjects.setOptions(new HashMap<>());

    // Act
    GenerateObjects<Object> actualShallowCloneResult = generateObjects.shallowClone();

    // Assert
    TypeReference<Iterable<?>> outputTypeReference = actualShallowCloneResult.getOutputTypeReference();
    assertTrue(outputTypeReference instanceof IterableObj);
    Type outputType = actualShallowCloneResult.getOutputType();
    assertEquals("java.lang.Iterable<?>", outputType.getTypeName());
    assertNull(actualShallowCloneResult.getInput());
    assertNull(actualShallowCloneResult.getElementGenerator());
    assertTrue(actualShallowCloneResult.getOptions().isEmpty());
    Class<Iterable> expectedOutputClass = Iterable.class;
    assertEquals(expectedOutputClass, actualShallowCloneResult.getOutputClass());
    assertSame(outputType, outputTypeReference.getType());
  }

  /**
   * Test {@link GenerateObjects#shallowClone()}.
   * <ul>
   *   <li>Given {@link GenerateObjects#GenerateObjects()}.</li>
   *   <li>Then return Options is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GenerateObjects#shallowClone()}
   */
  @Test
  @DisplayName("Test shallowClone(); given GenerateObjects(); then return Options is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"GenerateObjects GenerateObjects.shallowClone()"})
  void testShallowClone_givenGenerateObjects_thenReturnOptionsIsNull() {
    // Arrange
    GenerateObjects<Object> generateObjects = new GenerateObjects<>();

    // Act
    GenerateObjects<Object> actualShallowCloneResult = generateObjects.shallowClone();

    // Assert
    TypeReference<Iterable<?>> outputTypeReference = actualShallowCloneResult.getOutputTypeReference();
    assertTrue(outputTypeReference instanceof IterableObj);
    Type outputType = actualShallowCloneResult.getOutputType();
    assertEquals("java.lang.Iterable<?>", outputType.getTypeName());
    assertNull(actualShallowCloneResult.getInput());
    assertNull(actualShallowCloneResult.getOptions());
    assertNull(actualShallowCloneResult.getElementGenerator());
    Class<Iterable> expectedOutputClass = Iterable.class;
    assertEquals(expectedOutputClass, actualShallowCloneResult.getOutputClass());
    assertSame(outputType, outputTypeReference.getType());
  }
}
