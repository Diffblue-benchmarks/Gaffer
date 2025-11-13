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

package uk.gov.gchq.gaffer.operation.impl.output;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.core.type.TypeReference;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.operation.impl.output.ToArray.Builder;
import uk.gov.gchq.gaffer.operation.serialisation.TypeReferenceImpl;
import uk.gov.gchq.gaffer.operation.serialisation.TypeReferenceImpl.Array;

class ToArrayDiffblueTest {
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
    ToArray<Object> _getOpResult = actualBuilder._getOp();
    TypeReference<Object[]> outputTypeReference = _getOpResult.getOutputTypeReference();
    assertTrue(outputTypeReference instanceof Array);
    Type outputType = _getOpResult.getOutputType();
    assertEquals("T[]", outputType.getTypeName());
    assertNull(_getOpResult.getInput());
    assertNull(_getOpResult.getOptions());
    Class<Object> expectedOutputClass = Object.class;
    assertEquals(expectedOutputClass, _getOpResult.getOutputClass());
    assertSame(_getOpResult, actualBuilder.build());
    assertSame(outputType, outputTypeReference.getType());
  }

  /**
   * Test {@link ToArray#getOutputTypeReference()}.
   * <p>
   * Method under test: {@link ToArray#getOutputTypeReference()}
   */
  @Test
  @DisplayName("Test getOutputTypeReference()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TypeReference ToArray.getOutputTypeReference()"})
  void testGetOutputTypeReference() {
    // Arrange
    ToArray<Object> toArray = new ToArray<>();

    // Act
    TypeReference<Object[]> actualOutputTypeReference = toArray.getOutputTypeReference();

    // Assert
    assertTrue(actualOutputTypeReference instanceof Array);
    assertEquals("T[]", actualOutputTypeReference.getType().getTypeName());
  }

  /**
   * Test {@link ToArray#shallowClone()}.
   * <ul>
   *   <li>Given {@link ToArray} (default constructor) Options is {@link HashMap#HashMap()}.</li>
   *   <li>Then return Options Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link ToArray#shallowClone()}
   */
  @Test
  @DisplayName("Test shallowClone(); given ToArray (default constructor) Options is HashMap(); then return Options Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ToArray ToArray.shallowClone()"})
  void testShallowClone_givenToArrayOptionsIsHashMap_thenReturnOptionsEmpty() {
    // Arrange
    ToArray<Object> toArray = new ToArray<>();
    toArray.setOptions(new HashMap<>());

    // Act
    ToArray<Object> actualShallowCloneResult = toArray.shallowClone();

    // Assert
    TypeReference<Object[]> outputTypeReference = actualShallowCloneResult.getOutputTypeReference();
    assertTrue(outputTypeReference instanceof Array);
    Type outputType = actualShallowCloneResult.getOutputType();
    assertEquals("T[]", outputType.getTypeName());
    assertNull(actualShallowCloneResult.getInput());
    assertTrue(actualShallowCloneResult.getOptions().isEmpty());
    Class<Object> expectedOutputClass = Object.class;
    assertEquals(expectedOutputClass, actualShallowCloneResult.getOutputClass());
    assertSame(outputType, outputTypeReference.getType());
  }

  /**
   * Test {@link ToArray#shallowClone()}.
   * <ul>
   *   <li>Given {@link ToArray} (default constructor).</li>
   *   <li>Then return Options is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ToArray#shallowClone()}
   */
  @Test
  @DisplayName("Test shallowClone(); given ToArray (default constructor); then return Options is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ToArray ToArray.shallowClone()"})
  void testShallowClone_givenToArray_thenReturnOptionsIsNull() {
    // Arrange
    ToArray<Object> toArray = new ToArray<>();

    // Act
    ToArray<Object> actualShallowCloneResult = toArray.shallowClone();

    // Assert
    TypeReference<Object[]> outputTypeReference = actualShallowCloneResult.getOutputTypeReference();
    assertTrue(outputTypeReference instanceof Array);
    Type outputType = actualShallowCloneResult.getOutputType();
    assertEquals("T[]", outputType.getTypeName());
    assertNull(actualShallowCloneResult.getInput());
    assertNull(actualShallowCloneResult.getOptions());
    Class<Object> expectedOutputClass = Object.class;
    assertEquals(expectedOutputClass, actualShallowCloneResult.getOutputClass());
    assertSame(outputType, outputTypeReference.getType());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link ToArray}
   *   <li>{@link ToArray#setInput(Iterable)}
   *   <li>{@link ToArray#setOptions(Map)}
   *   <li>{@link ToArray#getOptions()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void ToArray.<init>()", "Map ToArray.getOptions()", "void ToArray.setInput(Iterable)",
      "void ToArray.setOptions(Map)"})
  void testGettersAndSetters() {
    // Arrange and Act
    ToArray<Object> actualToArray = new ToArray<>();
    ArrayList<Object> input = new ArrayList<>();
    actualToArray.setInput(input);
    HashMap<String, String> options = new HashMap<>();
    actualToArray.setOptions(options);
    Map<String, String> actualOptions = actualToArray.getOptions();

    // Assert
    Iterable<?> input2 = actualToArray.getInput();
    assertTrue(input2 instanceof List);
    assertTrue(actualOptions.isEmpty());
    assertSame(input, input2);
    assertSame(options, actualOptions);
  }
}
