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
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.LinkedHashMap;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.data.element.Edge;
import uk.gov.gchq.gaffer.data.element.Element;
import uk.gov.gchq.gaffer.data.element.IdentifierType;
import uk.gov.gchq.gaffer.data.generator.MapGenerator.Builder;

class MapGeneratorDiffblueTest {
  /**
   * Test Builder {@link Builder#build()}.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link Builder#build()}
   *   <li>default or parameterless constructor of {@link Builder}
   * </ul>
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Builder.<init>()", "MapGenerator Builder.build()"})
  void testBuilderBuild() {
    // Arrange and Act
    MapGenerator actualBuildResult = (new Builder()).build();

    // Assert
    assertTrue(actualBuildResult.getConstants().isEmpty());
    assertTrue(actualBuildResult.getFields().isEmpty());
  }

  /**
   * Test Builder {@link Builder#constant(String, String)}.
   * <p>
   * Method under test: {@link Builder#constant(String, String)}
   */
  @Test
  @DisplayName("Test Builder constant(String, String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.constant(String, String)"})
  void testBuilderConstant() {
    // Arrange
    Builder builder = new Builder();

    // Act and Assert
    assertSame(builder, builder.constant("Key", "42"));
  }

  /**
   * Test Builder {@link Builder#destination(String)}.
   * <p>
   * Method under test: {@link Builder#destination(String)}
   */
  @Test
  @DisplayName("Test Builder destination(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.destination(String)"})
  void testBuilderDestination() {
    // Arrange
    Builder builder = new Builder();

    // Act and Assert
    assertSame(builder, builder.destination("Map Key"));
  }

  /**
   * Test Builder {@link Builder#direction(String)}.
   * <p>
   * Method under test: {@link Builder#direction(String)}
   */
  @Test
  @DisplayName("Test Builder direction(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.direction(String)"})
  void testBuilderDirection() {
    // Arrange
    Builder builder = new Builder();

    // Act and Assert
    assertSame(builder, builder.direction("Map Key"));
  }

  /**
   * Test Builder {@link Builder#group(String)}.
   * <p>
   * Method under test: {@link Builder#group(String)}
   */
  @Test
  @DisplayName("Test Builder group(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.group(String)"})
  void testBuilderGroup() {
    // Arrange
    Builder builder = new Builder();

    // Act and Assert
    assertSame(builder, builder.group("Map Key"));
  }

  /**
   * Test Builder {@link Builder#identifier(IdentifierType, String)}.
   * <p>
   * Method under test: {@link Builder#identifier(IdentifierType, String)}
   */
  @Test
  @DisplayName("Test Builder identifier(IdentifierType, String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.identifier(IdentifierType, String)"})
  void testBuilderIdentifier() {
    // Arrange
    Builder builder = new Builder();

    // Act and Assert
    assertSame(builder, builder.identifier(IdentifierType.VERTEX, "Map Key"));
  }

  /**
   * Test Builder {@link Builder#property(String, String)}.
   * <p>
   * Method under test: {@link Builder#property(String, String)}
   */
  @Test
  @DisplayName("Test Builder property(String, String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.property(String, String)"})
  void testBuilderProperty() {
    // Arrange
    Builder builder = new Builder();

    // Act and Assert
    assertSame(builder, builder.property("Property Name", "Map Key"));
  }

  /**
   * Test Builder {@link Builder#source(String)}.
   * <p>
   * Method under test: {@link Builder#source(String)}
   */
  @Test
  @DisplayName("Test Builder source(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.source(String)"})
  void testBuilderSource() {
    // Arrange
    Builder builder = new Builder();

    // Act and Assert
    assertSame(builder, builder.source("Map Key"));
  }

  /**
   * Test Builder {@link Builder#vertex(String)}.
   * <p>
   * Method under test: {@link Builder#vertex(String)}
   */
  @Test
  @DisplayName("Test Builder vertex(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.vertex(String)"})
  void testBuilderVertex() {
    // Arrange
    Builder builder = new Builder();

    // Act and Assert
    assertSame(builder, builder.vertex("Map Key"));
  }

  /**
   * Test {@link MapGenerator#_apply(Element)}.
   * <p>
   * Method under test: {@link MapGenerator#_apply(Element)}
   */
  @Test
  @DisplayName("Test _apply(Element)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.util.Map MapGenerator._apply(Element)"})
  void test_apply() {
    // Arrange
    MapGenerator mapGenerator = new MapGenerator();

    // Act and Assert
    assertTrue(mapGenerator._apply(new Edge("Group")).isEmpty());
  }

  /**
   * Test {@link MapGenerator#setFields(LinkedHashMap)}.
   * <ul>
   *   <li>When {@link LinkedHashMap#LinkedHashMap()}.</li>
   *   <li>Then {@link MapGenerator} (default constructor) Fields is {@link LinkedHashMap#LinkedHashMap()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MapGenerator#setFields(LinkedHashMap)}
   */
  @Test
  @DisplayName("Test setFields(LinkedHashMap); when LinkedHashMap(); then MapGenerator (default constructor) Fields is LinkedHashMap()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void MapGenerator.setFields(LinkedHashMap)"})
  void testSetFields_whenLinkedHashMap_thenMapGeneratorFieldsIsLinkedHashMap() {
    // Arrange
    MapGenerator mapGenerator = new MapGenerator();
    LinkedHashMap<String, String> fields = new LinkedHashMap<>();

    // Act
    mapGenerator.setFields(fields);

    // Assert
    assertSame(fields, mapGenerator.getFields());
  }

  /**
   * Test {@link MapGenerator#setFields(LinkedHashMap)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then {@link MapGenerator} (default constructor) Fields is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MapGenerator#setFields(LinkedHashMap)}
   */
  @Test
  @DisplayName("Test setFields(LinkedHashMap); when 'null'; then MapGenerator (default constructor) Fields is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void MapGenerator.setFields(LinkedHashMap)"})
  void testSetFields_whenNull_thenMapGeneratorFieldsIsNull() {
    // Arrange
    MapGenerator mapGenerator = new MapGenerator();

    // Act
    mapGenerator.setFields(null);

    // Assert
    assertNull(mapGenerator.getFields());
  }

  /**
   * Test {@link MapGenerator#setConstants(LinkedHashMap)}.
   * <ul>
   *   <li>When {@link LinkedHashMap#LinkedHashMap()}.</li>
   *   <li>Then {@link MapGenerator} (default constructor) Constants is {@link LinkedHashMap#LinkedHashMap()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MapGenerator#setConstants(LinkedHashMap)}
   */
  @Test
  @DisplayName("Test setConstants(LinkedHashMap); when LinkedHashMap(); then MapGenerator (default constructor) Constants is LinkedHashMap()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void MapGenerator.setConstants(LinkedHashMap)"})
  void testSetConstants_whenLinkedHashMap_thenMapGeneratorConstantsIsLinkedHashMap() {
    // Arrange
    MapGenerator mapGenerator = new MapGenerator();
    LinkedHashMap<String, String> constants = new LinkedHashMap<>();

    // Act
    mapGenerator.setConstants(constants);

    // Assert
    assertSame(constants, mapGenerator.getConstants());
  }

  /**
   * Test {@link MapGenerator#setConstants(LinkedHashMap)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then {@link MapGenerator} (default constructor) Constants is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MapGenerator#setConstants(LinkedHashMap)}
   */
  @Test
  @DisplayName("Test setConstants(LinkedHashMap); when 'null'; then MapGenerator (default constructor) Constants is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void MapGenerator.setConstants(LinkedHashMap)"})
  void testSetConstants_whenNull_thenMapGeneratorConstantsIsNull() {
    // Arrange
    MapGenerator mapGenerator = new MapGenerator();

    // Act
    mapGenerator.setConstants(null);

    // Assert
    assertNull(mapGenerator.getConstants());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link MapGenerator}
   *   <li>{@link MapGenerator#getConstants()}
   *   <li>{@link MapGenerator#getFields()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void MapGenerator.<init>()", "LinkedHashMap MapGenerator.getConstants()",
      "LinkedHashMap MapGenerator.getFields()"})
  void testGettersAndSetters() {
    // Arrange and Act
    MapGenerator actualMapGenerator = new MapGenerator();
    LinkedHashMap<String, String> actualConstants = actualMapGenerator.getConstants();
    LinkedHashMap<String, String> actualFields = actualMapGenerator.getFields();

    // Assert
    assertTrue(actualConstants.isEmpty());
    assertTrue(actualFields.isEmpty());
  }
}
