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
import uk.gov.gchq.gaffer.data.element.Element;
import uk.gov.gchq.gaffer.data.generator.MapGenerator;
import uk.gov.gchq.gaffer.operation.impl.output.ToMap.Builder;
import uk.gov.gchq.gaffer.operation.serialisation.TypeReferenceImpl;
import uk.gov.gchq.gaffer.operation.serialisation.TypeReferenceImpl.IterableMap;

class ToMapDiffblueTest {
  /**
   * Test Builder {@link Builder#generator(MapGenerator)}.
   * <p>
   * Method under test: {@link Builder#generator(MapGenerator)}
   */
  @Test
  @DisplayName("Test Builder generator(MapGenerator)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.generator(MapGenerator)"})
  void testBuilderGenerator() {
    // Arrange
    Builder builder = new Builder();

    // Act and Assert
    assertSame(builder, builder.generator(new MapGenerator()));
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
    ToMap _getOpResult = actualBuilder._getOp();
    TypeReference<Iterable<? extends Map<String, Object>>> outputTypeReference = _getOpResult.getOutputTypeReference();
    assertTrue(outputTypeReference instanceof IterableMap);
    Type outputType = _getOpResult.getOutputType();
    assertEquals("java.lang.Iterable<? extends java.util.Map<java.lang.String, java.lang.Object>>",
        outputType.getTypeName());
    assertNull(_getOpResult.getInput());
    assertNull(_getOpResult.getOptions());
    assertNull(_getOpResult.getElementGenerator());
    Class<Iterable> expectedOutputClass = Iterable.class;
    assertEquals(expectedOutputClass, _getOpResult.getOutputClass());
    assertSame(_getOpResult, actualBuilder.build());
    assertSame(outputType, outputTypeReference.getType());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ToMap#ToMap()}
   *   <li>{@link ToMap#setElementGenerator(MapGenerator)}
   *   <li>{@link ToMap#setInput(Iterable)}
   *   <li>{@link ToMap#setOptions(Map)}
   *   <li>{@link ToMap#getElementGenerator()}
   *   <li>{@link ToMap#getOptions()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void ToMap.<init>()", "void ToMap.<init>(MapGenerator)",
      "MapGenerator ToMap.getElementGenerator()", "Map ToMap.getOptions()",
      "void ToMap.setElementGenerator(MapGenerator)", "void ToMap.setInput(Iterable)", "void ToMap.setOptions(Map)"})
  void testGettersAndSetters() {
    // Arrange and Act
    ToMap actualToMap = new ToMap();
    MapGenerator elementGenerator = (new MapGenerator.Builder()).build();
    actualToMap.setElementGenerator(elementGenerator);
    ArrayList<Element> input = new ArrayList<>();
    actualToMap.setInput(input);
    HashMap<String, String> options = new HashMap<>();
    actualToMap.setOptions(options);
    MapGenerator actualElementGenerator = actualToMap.getElementGenerator();
    Map<String, String> actualOptions = actualToMap.getOptions();

    // Assert
    Iterable<? extends Element> input2 = actualToMap.getInput();
    assertTrue(input2 instanceof List);
    assertTrue(actualOptions.isEmpty());
    assertSame(input, input2);
    assertSame(options, actualOptions);
    assertSame(elementGenerator, actualElementGenerator);
  }

  /**
   * Test getters and setters.
   * <ul>
   *   <li>When {@link MapGenerator.Builder} (default constructor) build.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ToMap#ToMap(MapGenerator)}
   *   <li>{@link ToMap#setElementGenerator(MapGenerator)}
   *   <li>{@link ToMap#setInput(Iterable)}
   *   <li>{@link ToMap#setOptions(Map)}
   *   <li>{@link ToMap#getElementGenerator()}
   *   <li>{@link ToMap#getOptions()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; when Builder (default constructor) build")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void ToMap.<init>()", "void ToMap.<init>(MapGenerator)",
      "MapGenerator ToMap.getElementGenerator()", "Map ToMap.getOptions()",
      "void ToMap.setElementGenerator(MapGenerator)", "void ToMap.setInput(Iterable)", "void ToMap.setOptions(Map)"})
  void testGettersAndSetters_whenBuilderBuild() {
    // Arrange
    MapGenerator elementGenerator = (new MapGenerator.Builder()).build();

    // Act
    ToMap actualToMap = new ToMap(elementGenerator);
    MapGenerator elementGenerator2 = (new MapGenerator.Builder()).build();
    actualToMap.setElementGenerator(elementGenerator2);
    ArrayList<Element> input = new ArrayList<>();
    actualToMap.setInput(input);
    HashMap<String, String> options = new HashMap<>();
    actualToMap.setOptions(options);
    MapGenerator actualElementGenerator = actualToMap.getElementGenerator();
    Map<String, String> actualOptions = actualToMap.getOptions();

    // Assert
    Iterable<? extends Element> input2 = actualToMap.getInput();
    assertTrue(input2 instanceof List);
    assertTrue(actualOptions.isEmpty());
    assertSame(input, input2);
    assertSame(options, actualOptions);
    assertSame(elementGenerator2, actualElementGenerator);
  }

  /**
   * Test {@link ToMap#getOutputTypeReference()}.
   * <p>
   * Method under test: {@link ToMap#getOutputTypeReference()}
   */
  @Test
  @DisplayName("Test getOutputTypeReference()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TypeReference ToMap.getOutputTypeReference()"})
  void testGetOutputTypeReference() {
    // Arrange and Act
    TypeReference<Iterable<? extends Map<String, Object>>> actualOutputTypeReference = (new ToMap())
        .getOutputTypeReference();

    // Assert
    assertTrue(actualOutputTypeReference instanceof IterableMap);
    assertEquals("java.lang.Iterable<? extends java.util.Map<java.lang.String, java.lang.Object>>",
        actualOutputTypeReference.getType().getTypeName());
  }

  /**
   * Test {@link ToMap#shallowClone()}.
   * <ul>
   *   <li>Given {@link ToMap#ToMap()} Options is {@link HashMap#HashMap()}.</li>
   *   <li>Then return Options Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link ToMap#shallowClone()}
   */
  @Test
  @DisplayName("Test shallowClone(); given ToMap() Options is HashMap(); then return Options Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ToMap ToMap.shallowClone()"})
  void testShallowClone_givenToMapOptionsIsHashMap_thenReturnOptionsEmpty() {
    // Arrange
    ToMap toMap = new ToMap();
    toMap.setOptions(new HashMap<>());

    // Act
    ToMap actualShallowCloneResult = toMap.shallowClone();

    // Assert
    TypeReference<Iterable<? extends Map<String, Object>>> outputTypeReference = actualShallowCloneResult
        .getOutputTypeReference();
    assertTrue(outputTypeReference instanceof IterableMap);
    Type outputType = actualShallowCloneResult.getOutputType();
    assertEquals("java.lang.Iterable<? extends java.util.Map<java.lang.String, java.lang.Object>>",
        outputType.getTypeName());
    assertNull(actualShallowCloneResult.getInput());
    assertNull(actualShallowCloneResult.getElementGenerator());
    assertTrue(actualShallowCloneResult.getOptions().isEmpty());
    Class<Iterable> expectedOutputClass = Iterable.class;
    assertEquals(expectedOutputClass, actualShallowCloneResult.getOutputClass());
    assertSame(outputType, outputTypeReference.getType());
  }

  /**
   * Test {@link ToMap#shallowClone()}.
   * <ul>
   *   <li>Given {@link ToMap#ToMap()}.</li>
   *   <li>Then return Options is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ToMap#shallowClone()}
   */
  @Test
  @DisplayName("Test shallowClone(); given ToMap(); then return Options is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ToMap ToMap.shallowClone()"})
  void testShallowClone_givenToMap_thenReturnOptionsIsNull() {
    // Arrange and Act
    ToMap actualShallowCloneResult = (new ToMap()).shallowClone();

    // Assert
    TypeReference<Iterable<? extends Map<String, Object>>> outputTypeReference = actualShallowCloneResult
        .getOutputTypeReference();
    assertTrue(outputTypeReference instanceof IterableMap);
    Type outputType = actualShallowCloneResult.getOutputType();
    assertEquals("java.lang.Iterable<? extends java.util.Map<java.lang.String, java.lang.Object>>",
        outputType.getTypeName());
    assertNull(actualShallowCloneResult.getInput());
    assertNull(actualShallowCloneResult.getOptions());
    assertNull(actualShallowCloneResult.getElementGenerator());
    Class<Iterable> expectedOutputClass = Iterable.class;
    assertEquals(expectedOutputClass, actualShallowCloneResult.getOutputClass());
    assertSame(outputType, outputTypeReference.getType());
  }
}
