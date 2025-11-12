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

package uk.gov.gchq.gaffer.data.generator;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import java.util.LinkedHashMap;
import java.util.function.BiFunction;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.data.element.Edge;
import uk.gov.gchq.gaffer.data.element.Element;
import uk.gov.gchq.gaffer.data.element.ElementValueLoader;
import uk.gov.gchq.gaffer.data.element.IdentifierType;
import uk.gov.gchq.gaffer.data.element.LazyEdge;

class MapGeneratorDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link MapGenerator.Builder#build()}
   *   <li>default or parameterless constructor of {@link MapGenerator.Builder}
   * </ul>
   */
  @Test
  void testBuilderBuild() {
    // Arrange and Act
    MapGenerator actualBuildResult = (new MapGenerator.Builder()).build();

    // Assert
    assertTrue(actualBuildResult.getConstants().isEmpty());
    assertTrue(actualBuildResult.getFields().isEmpty());
  }

  /**
   * Method under test: {@link MapGenerator.Builder#constant(String, String)}
   */
  @Test
  void testBuilderConstant() {
    // Arrange
    MapGenerator.Builder builder = new MapGenerator.Builder();

    // Act and Assert
    assertSame(builder, builder.constant("Key", "42"));
  }

  /**
   * Method under test: {@link MapGenerator.Builder#destination(String)}
   */
  @Test
  void testBuilderDestination() {
    // Arrange
    MapGenerator.Builder builder = new MapGenerator.Builder();

    // Act and Assert
    assertSame(builder, builder.destination("Map Key"));
  }

  /**
   * Method under test: {@link MapGenerator.Builder#direction(String)}
   */
  @Test
  void testBuilderDirection() {
    // Arrange
    MapGenerator.Builder builder = new MapGenerator.Builder();

    // Act and Assert
    assertSame(builder, builder.direction("Map Key"));
  }

  /**
   * Method under test: {@link MapGenerator.Builder#group(String)}
   */
  @Test
  void testBuilderGroup() {
    // Arrange
    MapGenerator.Builder builder = new MapGenerator.Builder();

    // Act and Assert
    assertSame(builder, builder.group("Map Key"));
  }

  /**
   * Method under test:
   * {@link MapGenerator.Builder#identifier(IdentifierType, String)}
   */
  @Test
  void testBuilderIdentifier() {
    // Arrange
    MapGenerator.Builder builder = new MapGenerator.Builder();

    // Act and Assert
    assertSame(builder, builder.identifier(IdentifierType.VERTEX, "Map Key"));
  }

  /**
   * Method under test: {@link MapGenerator.Builder#property(String, String)}
   */
  @Test
  void testBuilderProperty() {
    // Arrange
    MapGenerator.Builder builder = new MapGenerator.Builder();

    // Act and Assert
    assertSame(builder, builder.property("Property Name", "Map Key"));
  }

  /**
   * Method under test: {@link MapGenerator.Builder#source(String)}
   */
  @Test
  void testBuilderSource() {
    // Arrange
    MapGenerator.Builder builder = new MapGenerator.Builder();

    // Act and Assert
    assertSame(builder, builder.source("Map Key"));
  }

  /**
   * Method under test: {@link MapGenerator.Builder#vertex(String)}
   */
  @Test
  void testBuilderVertex() {
    // Arrange
    MapGenerator.Builder builder = new MapGenerator.Builder();

    // Act and Assert
    assertSame(builder, builder.vertex("Map Key"));
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link MapGenerator}
   *   <li>{@link MapGenerator#getConstants()}
   *   <li>{@link MapGenerator#getFields()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    MapGenerator actualMapGenerator = new MapGenerator();
    LinkedHashMap<String, String> actualConstants = actualMapGenerator.getConstants();
    LinkedHashMap<String, String> actualFields = actualMapGenerator.getFields();

    // Assert
    assertTrue(actualConstants.isEmpty());
    assertTrue(actualFields.isEmpty());
  }

  /**
   * Method under test: {@link MapGenerator#_apply(Element)}
   */
  @Test
  void test_apply() {
    // Arrange
    MapGenerator mapGenerator = new MapGenerator();

    // Act and Assert
    assertTrue(mapGenerator._apply(new Edge("Group")).isEmpty());
  }

  /**
   * Method under test: {@link MapGenerator#_apply(Element)}
   */
  @Test
  void test_apply2() {
    // Arrange
    MapGenerator mapGenerator = new MapGenerator();

    // Act and Assert
    assertTrue(mapGenerator._apply(new LazyEdge(new Edge("Group"), mock(ElementValueLoader.class))).isEmpty());
  }

  /**
   * Method under test: {@link MapGenerator#setFields(LinkedHashMap)}
   */
  @Test
  void testSetFields() {
    // Arrange
    MapGenerator mapGenerator = new MapGenerator();
    LinkedHashMap<String, String> fields = new LinkedHashMap<>();

    // Act
    mapGenerator.setFields(fields);

    // Assert
    assertSame(fields, mapGenerator.getFields());
  }

  /**
   * Method under test: {@link MapGenerator#setFields(LinkedHashMap)}
   */
  @Test
  void testSetFields2() {
    // Arrange
    MapGenerator mapGenerator = new MapGenerator();

    // Act
    mapGenerator.setFields(null);

    // Assert
    assertNull(mapGenerator.getFields());
  }

  /**
   * Method under test: {@link MapGenerator#setFields(LinkedHashMap)}
   */
  @Test
  void testSetFields3() {
    // Arrange
    MapGenerator mapGenerator = new MapGenerator();

    LinkedHashMap<String, String> fields = new LinkedHashMap<>();
    fields.replaceAll(mock(BiFunction.class));

    // Act
    mapGenerator.setFields(fields);

    // Assert
    assertSame(fields, mapGenerator.getFields());
  }

  /**
   * Method under test: {@link MapGenerator#setConstants(LinkedHashMap)}
   */
  @Test
  void testSetConstants() {
    // Arrange
    MapGenerator mapGenerator = new MapGenerator();
    LinkedHashMap<String, String> constants = new LinkedHashMap<>();

    // Act
    mapGenerator.setConstants(constants);

    // Assert
    assertSame(constants, mapGenerator.getConstants());
  }

  /**
   * Method under test: {@link MapGenerator#setConstants(LinkedHashMap)}
   */
  @Test
  void testSetConstants2() {
    // Arrange
    MapGenerator mapGenerator = new MapGenerator();

    // Act
    mapGenerator.setConstants(null);

    // Assert
    assertNull(mapGenerator.getConstants());
  }

  /**
   * Method under test: {@link MapGenerator#setConstants(LinkedHashMap)}
   */
  @Test
  void testSetConstants3() {
    // Arrange
    MapGenerator mapGenerator = new MapGenerator();

    LinkedHashMap<String, String> constants = new LinkedHashMap<>();
    constants.replaceAll(mock(BiFunction.class));

    // Act
    mapGenerator.setConstants(constants);

    // Assert
    assertSame(constants, mapGenerator.getConstants());
  }
}
