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
import java.util.Set;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.operation.impl.output.ToSet.Builder;
import uk.gov.gchq.gaffer.operation.serialisation.TypeReferenceImpl;

class ToSetDiffblueTest {
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
    ToSet<Object> _getOpResult = actualBuilder._getOp();
    TypeReference<Set<?>> outputTypeReference = _getOpResult.getOutputTypeReference();
    assertTrue(outputTypeReference instanceof TypeReferenceImpl.Set);
    Type outputType = _getOpResult.getOutputType();
    assertEquals("java.util.Set<T>", outputType.getTypeName());
    assertNull(_getOpResult.getInput());
    assertNull(_getOpResult.getOptions());
    Class<Set> expectedOutputClass = Set.class;
    assertEquals(expectedOutputClass, _getOpResult.getOutputClass());
    assertSame(_getOpResult, actualBuilder.build());
    assertSame(outputType, outputTypeReference.getType());
  }

  /**
   * Test {@link ToSet#getOutputTypeReference()}.
   * <p>
   * Method under test: {@link ToSet#getOutputTypeReference()}
   */
  @Test
  @DisplayName("Test getOutputTypeReference()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TypeReference ToSet.getOutputTypeReference()"})
  void testGetOutputTypeReference() {
    // Arrange
    ToSet<Object> toSet = new ToSet<>();

    // Act
    TypeReference<Set<?>> actualOutputTypeReference = toSet.getOutputTypeReference();

    // Assert
    assertTrue(actualOutputTypeReference instanceof TypeReferenceImpl.Set);
    assertEquals("java.util.Set<T>", actualOutputTypeReference.getType().getTypeName());
  }

  /**
   * Test {@link ToSet#shallowClone()}.
   * <ul>
   *   <li>Given {@link ToSet} (default constructor) Options is {@link HashMap#HashMap()}.</li>
   *   <li>Then return Options Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link ToSet#shallowClone()}
   */
  @Test
  @DisplayName("Test shallowClone(); given ToSet (default constructor) Options is HashMap(); then return Options Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ToSet ToSet.shallowClone()"})
  void testShallowClone_givenToSetOptionsIsHashMap_thenReturnOptionsEmpty() {
    // Arrange
    ToSet<Object> toSet = new ToSet<>();
    toSet.setOptions(new HashMap<>());

    // Act
    ToSet actualShallowCloneResult = toSet.shallowClone();

    // Assert
    TypeReference<Set> outputTypeReference = actualShallowCloneResult.getOutputTypeReference();
    assertTrue(outputTypeReference instanceof TypeReferenceImpl.Set);
    Type outputType = actualShallowCloneResult.getOutputType();
    assertEquals("java.util.Set<T>", outputType.getTypeName());
    assertNull(actualShallowCloneResult.getInput());
    assertTrue(actualShallowCloneResult.getOptions().isEmpty());
    Class<Set> expectedOutputClass = Set.class;
    assertEquals(expectedOutputClass, actualShallowCloneResult.getOutputClass());
    assertSame(outputType, outputTypeReference.getType());
  }

  /**
   * Test {@link ToSet#shallowClone()}.
   * <ul>
   *   <li>Given {@link ToSet} (default constructor).</li>
   *   <li>Then return Options is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ToSet#shallowClone()}
   */
  @Test
  @DisplayName("Test shallowClone(); given ToSet (default constructor); then return Options is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ToSet ToSet.shallowClone()"})
  void testShallowClone_givenToSet_thenReturnOptionsIsNull() {
    // Arrange
    ToSet<Object> toSet = new ToSet<>();

    // Act
    ToSet actualShallowCloneResult = toSet.shallowClone();

    // Assert
    TypeReference<Set> outputTypeReference = actualShallowCloneResult.getOutputTypeReference();
    assertTrue(outputTypeReference instanceof TypeReferenceImpl.Set);
    Type outputType = actualShallowCloneResult.getOutputType();
    assertEquals("java.util.Set<T>", outputType.getTypeName());
    assertNull(actualShallowCloneResult.getInput());
    assertNull(actualShallowCloneResult.getOptions());
    Class<Set> expectedOutputClass = Set.class;
    assertEquals(expectedOutputClass, actualShallowCloneResult.getOutputClass());
    assertSame(outputType, outputTypeReference.getType());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link ToSet}
   *   <li>{@link ToSet#setInput(Iterable)}
   *   <li>{@link ToSet#setOptions(Map)}
   *   <li>{@link ToSet#getOptions()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void ToSet.<init>()", "Map ToSet.getOptions()", "void ToSet.setInput(Iterable)",
      "void ToSet.setOptions(Map)"})
  void testGettersAndSetters() {
    // Arrange and Act
    ToSet<Object> actualToSet = new ToSet<>();
    ArrayList<Object> input = new ArrayList<>();
    actualToSet.setInput(input);
    HashMap<String, String> options = new HashMap<>();
    actualToSet.setOptions(options);
    Map<String, String> actualOptions = actualToSet.getOptions();

    // Assert
    Iterable<?> input2 = actualToSet.getInput();
    assertTrue(input2 instanceof List);
    assertTrue(actualOptions.isEmpty());
    assertSame(input, input2);
    assertSame(options, actualOptions);
  }
}
