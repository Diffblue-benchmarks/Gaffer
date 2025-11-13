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

package uk.gov.gchq.gaffer.operation.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.function.Function;
import org.apache.commons.lang3.exception.CloneFailedException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.operation.impl.Map.Builder;
import uk.gov.gchq.gaffer.operation.impl.Map.OutputBuilder;
import uk.gov.gchq.gaffer.operation.serialisation.TypeReferenceImpl;

class MapDiffblueTest {
  /**
   * Test Builder {@link Builder#first(Function)}.
   *
   * <p>Method under test: {@link Builder#first(Function)}
   */
  @Test
  @DisplayName("Test Builder first(Function)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"OutputBuilder Builder.first(Function)"})
  void testBuilderFirst() {
    // Arrange
    Builder<Object> builder = new Builder<>();
    Function<Object, Object> function = mock(Function.class);

    // Act
    OutputBuilder<Object, Object> actualFirstResult = builder.first(function);

    // Assert
    Map<Object, Object> _getOpResult = actualFirstResult._getOp();
    assertTrue(_getOpResult.getOutputTypeReference() instanceof TypeReferenceImpl.Object);
    assertNull(_getOpResult.getInput());
    assertNull(_getOpResult.getOptions());
    List<Function> functions = _getOpResult.getFunctions();
    assertEquals(1, functions.size());
    Class<Object> expectedOutputClass = Object.class;
    assertEquals(expectedOutputClass, _getOpResult.getOutputClass());
    Map<Object, Object> actualMap = actualFirstResult.build();
    assertSame(_getOpResult, actualMap);
    assertSame(function, functions.get(0));
  }

  /**
   * Test Builder new {@link Builder} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link Builder}
   */
  @Test
  @DisplayName("Test Builder new Builder (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Builder.<init>()"})
  void testBuilderNewBuilder() {
    // Arrange and Act
    Builder<Object> actualBuilder = new Builder<>();

    // Assert
    Map<Object, Object> _getOpResult = actualBuilder._getOp();
    assertTrue(_getOpResult.getOutputTypeReference() instanceof TypeReferenceImpl.Object);
    assertNull(_getOpResult.getInput());
    assertNull(_getOpResult.getFunctions());
    assertNull(_getOpResult.getOptions());
    Class<Object> expectedOutputClass = Object.class;
    assertEquals(expectedOutputClass, _getOpResult.getOutputClass());
    Map<Object, Object> actualMap = actualBuilder.build();
    assertSame(_getOpResult, actualMap);
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Map#Map()}
   *   <li>{@link Map#setFunctions(List)}
   *   <li>{@link Map#setInput(Object)}
   *   <li>{@link Map#setOptions(java.util.Map)}
   *   <li>{@link Map#getFunctions()}
   *   <li>{@link Map#getInput()}
   *   <li>{@link Map#getOptions()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void Map.<init>()",
    "void Map.<init>(List)",
    "List Map.getFunctions()",
    "Object Map.getInput()",
    "java.util.Map Map.getOptions()",
    "void Map.setFunctions(List)",
    "void Map.setInput(Object)",
    "void Map.setOptions(java.util.Map)"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    Map<Object, Object> actualMap = new Map<>();
    ArrayList<Function> funcs = new ArrayList<>();
    actualMap.setFunctions(funcs);
    actualMap.setInput("Input");
    HashMap<String, String> options = new HashMap<>();
    actualMap.setOptions(options);
    List<Function> actualFunctions = actualMap.getFunctions();
    Object actualInput = actualMap.getInput();
    java.util.Map<String, String> actualOptions = actualMap.getOptions();

    // Assert
    assertEquals("Input", actualInput);
    assertTrue(actualFunctions.isEmpty());
    assertTrue(actualOptions.isEmpty());
    assertSame(funcs, actualFunctions);
    assertSame(options, actualOptions);
  }

  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Map#Map(List)}
   *   <li>{@link Map#setFunctions(List)}
   *   <li>{@link Map#setInput(Object)}
   *   <li>{@link Map#setOptions(java.util.Map)}
   *   <li>{@link Map#getFunctions()}
   *   <li>{@link Map#getInput()}
   *   <li>{@link Map#getOptions()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; when ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void Map.<init>()",
    "void Map.<init>(List)",
    "List Map.getFunctions()",
    "Object Map.getInput()",
    "java.util.Map Map.getOptions()",
    "void Map.setFunctions(List)",
    "void Map.setInput(Object)",
    "void Map.setOptions(java.util.Map)"
  })
  void testGettersAndSetters_whenArrayList() {
    // Arrange and Act
    Map<Object, Object> actualMap = new Map<>(new ArrayList<>());
    ArrayList<Function> funcs = new ArrayList<>();
    actualMap.setFunctions(funcs);
    actualMap.setInput("Input");
    HashMap<String, String> options = new HashMap<>();
    actualMap.setOptions(options);
    List<Function> actualFunctions = actualMap.getFunctions();
    Object actualInput = actualMap.getInput();
    java.util.Map<String, String> actualOptions = actualMap.getOptions();

    // Assert
    assertEquals("Input", actualInput);
    assertTrue(actualFunctions.isEmpty());
    assertTrue(actualOptions.isEmpty());
    assertSame(funcs, actualFunctions);
    assertSame(options, actualOptions);
  }

  /**
   * Test {@link Map#Map(Function)}.
   *
   * <p>Method under test: {@link Map#Map(Function)}
   */
  @Test
  @DisplayName("Test new Map(Function)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Map.<init>(Function)"})
  void testNewMap() {
    // Arrange
    Function function = mock(Function.class);

    // Act
    Map<Object, Object> actualMap = new Map<>(function);

    // Assert
    assertTrue(actualMap.getOutputTypeReference() instanceof TypeReferenceImpl.Object);
    assertNull(actualMap.getInput());
    assertNull(actualMap.getOptions());
    List<Function> functions = actualMap.getFunctions();
    assertEquals(1, functions.size());
    Class<Object> expectedOutputClass = Object.class;
    assertEquals(expectedOutputClass, actualMap.getOutputClass());
    assertSame(function, functions.get(0));
  }

  /**
   * Test {@link Map#getOutputTypeReference()}.
   *
   * <p>Method under test: {@link Map#getOutputTypeReference()}
   */
  @Test
  @DisplayName("Test getOutputTypeReference()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"com.fasterxml.jackson.core.type.TypeReference Map.getOutputTypeReference()"})
  void testGetOutputTypeReference() {
    // Arrange
    Map<Object, Object> map = new Map<>();

    // Act and Assert
    assertTrue(map.getOutputTypeReference() instanceof TypeReferenceImpl.Object);
  }

  /**
   * Test {@link Map#shallowClone()}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link Function}.
   *   <li>Then OutputTypeReference return {@link TypeReferenceImpl.Object}.
   * </ul>
   *
   * <p>Method under test: {@link Map#shallowClone()}
   */
  @Test
  @DisplayName(
      "Test shallowClone(); given ArrayList() add Function; then OutputTypeReference return Object")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map Map.shallowClone()"})
  void testShallowClone_givenArrayListAddFunction_thenOutputTypeReferenceReturnObject()
      throws CloneFailedException {
    // Arrange
    ArrayList<Function> functions = new ArrayList<>();
    functions.add(mock(Function.class));
    Map<Object, Object> map = new Map<>(functions);

    // Act
    Map<Object, Object> actualShallowCloneResult = map.shallowClone();

    // Assert
    assertTrue(
        actualShallowCloneResult.getOutputTypeReference() instanceof TypeReferenceImpl.Object);
    assertNull(actualShallowCloneResult.getInput());
    assertNull(actualShallowCloneResult.getOptions());
    assertEquals(1, actualShallowCloneResult.getFunctions().size());
    Class<Object> expectedOutputClass = Object.class;
    assertEquals(expectedOutputClass, actualShallowCloneResult.getOutputClass());
  }

  /**
   * Test {@link Map#setFunction(Function)}.
   *
   * <p>Method under test: {@link Map#setFunction(Function)}
   */
  @Test
  @DisplayName("Test setFunction(Function)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Map.setFunction(Function)"})
  void testSetFunction() {
    // Arrange
    Map<Object, Object> map = new Map<>();
    Function function = mock(Function.class);

    // Act
    map.setFunction(function);

    // Assert
    List<Function> functions = map.getFunctions();
    assertEquals(1, functions.size());
    assertSame(function, functions.get(0));
  }
}
