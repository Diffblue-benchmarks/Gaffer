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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.LinkedHashMap;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import uk.gov.gchq.gaffer.data.element.Edge;
import uk.gov.gchq.gaffer.data.element.Element;
import uk.gov.gchq.gaffer.data.element.ElementValueLoader;
import uk.gov.gchq.gaffer.data.element.IdentifierType;
import uk.gov.gchq.gaffer.data.element.LazyEdge;
import uk.gov.gchq.gaffer.data.element.LazyProperties;
import uk.gov.gchq.gaffer.data.element.Properties;
import uk.gov.gchq.gaffer.data.element.id.EdgeId;
import uk.gov.gchq.gaffer.data.element.id.EdgeId.MatchedVertex;
import uk.gov.gchq.gaffer.data.generator.MapGenerator.Builder;

class MapGeneratorDiffblueTest {
  /**
   * Test Builder {@link Builder#build()}.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Builder#build()}
   *   <li>default or parameterless constructor of {@link Builder}
   * </ul>
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Builder.<init>()", "MapGenerator Builder.build()"})
  void testBuilderBuild() {
    // Arrange and Act
    MapGenerator actualMapGenerator = new Builder().build();

    // Assert
    assertTrue(actualMapGenerator.getConstants().isEmpty());
    assertTrue(actualMapGenerator.getFields().isEmpty());
  }

  /**
   * Test Builder {@link Builder#constant(String, String)}.
   *
   * <p>Method under test: {@link Builder#constant(String, String)}
   */
  @Test
  @DisplayName("Test Builder constant(String, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.constant(String, String)"})
  void testBuilderConstant() {
    // Arrange
    Builder builder = new Builder();

    // Act
    Builder actualConstantResult = builder.constant("Key", "42");

    // Assert
    assertSame(builder, actualConstantResult);
  }

  /**
   * Test Builder {@link Builder#destination(String)}.
   *
   * <p>Method under test: {@link Builder#destination(String)}
   */
  @Test
  @DisplayName("Test Builder destination(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.destination(String)"})
  void testBuilderDestination() {
    // Arrange
    Builder builder = new Builder();

    // Act
    Builder actualDestinationResult = builder.destination("Map Key");

    // Assert
    assertSame(builder, actualDestinationResult);
  }

  /**
   * Test Builder {@link Builder#direction(String)}.
   *
   * <p>Method under test: {@link Builder#direction(String)}
   */
  @Test
  @DisplayName("Test Builder direction(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.direction(String)"})
  void testBuilderDirection() {
    // Arrange
    Builder builder = new Builder();

    // Act
    Builder actualDirectionResult = builder.direction("Map Key");

    // Assert
    assertSame(builder, actualDirectionResult);
  }

  /**
   * Test Builder {@link Builder#group(String)}.
   *
   * <p>Method under test: {@link Builder#group(String)}
   */
  @Test
  @DisplayName("Test Builder group(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.group(String)"})
  void testBuilderGroup() {
    // Arrange
    Builder builder = new Builder();

    // Act
    Builder actualGroupResult = builder.group("Map Key");

    // Assert
    assertSame(builder, actualGroupResult);
  }

  /**
   * Test Builder {@link Builder#identifier(IdentifierType, String)}.
   *
   * <p>Method under test: {@link Builder#identifier(IdentifierType, String)}
   */
  @Test
  @DisplayName("Test Builder identifier(IdentifierType, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.identifier(IdentifierType, String)"})
  void testBuilderIdentifier() {
    // Arrange
    Builder builder = new Builder();

    // Act
    Builder actualIdentifierResult = builder.identifier(IdentifierType.VERTEX, "Map Key");

    // Assert
    assertSame(builder, actualIdentifierResult);
  }

  /**
   * Test Builder {@link Builder#property(String, String)}.
   *
   * <p>Method under test: {@link Builder#property(String, String)}
   */
  @Test
  @DisplayName("Test Builder property(String, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.property(String, String)"})
  void testBuilderProperty() {
    // Arrange
    Builder builder = new Builder();

    // Act
    Builder actualPropertyResult = builder.property("Property Name", "Map Key");

    // Assert
    assertSame(builder, actualPropertyResult);
  }

  /**
   * Test Builder {@link Builder#source(String)}.
   *
   * <p>Method under test: {@link Builder#source(String)}
   */
  @Test
  @DisplayName("Test Builder source(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.source(String)"})
  void testBuilderSource() {
    // Arrange
    Builder builder = new Builder();

    // Act
    Builder actualSourceResult = builder.source("Map Key");

    // Assert
    assertSame(builder, actualSourceResult);
  }

  /**
   * Test Builder {@link Builder#vertex(String)}.
   *
   * <p>Method under test: {@link Builder#vertex(String)}
   */
  @Test
  @DisplayName("Test Builder vertex(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.vertex(String)"})
  void testBuilderVertex() {
    // Arrange
    Builder builder = new Builder();

    // Act
    Builder actualVertexResult = builder.vertex("Map Key");

    // Assert
    assertSame(builder, actualVertexResult);
  }

  /**
   * Test {@link MapGenerator#_apply(Element)}.
   *
   * <p>Method under test: {@link MapGenerator#_apply(Element)}
   */
  @Test
  @DisplayName("Test _apply(Element)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map MapGenerator._apply(Element)"})
  void test_apply() {
    // Arrange
    LinkedHashMap<String, String> fields = new LinkedHashMap<>();
    fields.put("foo", "foo");

    MapGenerator mapGenerator = new MapGenerator();
    mapGenerator.setFields(fields);

    ElementValueLoader valueLoader = mock(ElementValueLoader.class);
    when(valueLoader.getProperty(Mockito.<String>any(), Mockito.<Properties>any()))
        .thenReturn("Property");
    Edge edge =
        new Edge.Builder()
            .dest("Dest")
            .directed(true)
            .group("Group")
            .matchedVertex(MatchedVertex.SOURCE)
            .source("Source")
            .build();

    LazyEdge element = new LazyEdge(edge, valueLoader);
    element.putProperty("Name", "Value");

    // Act
    Map<String, Object> actual_applyResult = mapGenerator._apply(element);

    // Assert
    verify(valueLoader).getProperty(eq("foo"), isA(Properties.class));
    Properties properties = element.getElement().getProperties();
    assertEquals(2, properties.size());
    assertEquals("Property", properties.get("foo"));
    assertEquals(1, actual_applyResult.size());
    assertEquals("Property", actual_applyResult.get("foo"));
    LazyProperties properties2 = element.getProperties();
    assertEquals(2, properties2.size());
    assertEquals("Property", properties2.get((Object) "foo"));
    assertTrue(properties.containsKey("Name"));
    assertTrue(properties2.containsKey("Name"));
  }

  /**
   * Test {@link MapGenerator#_apply(Element)}.
   *
   * <ul>
   *   <li>Given {@link LinkedHashMap#LinkedHashMap()} {@code foo} is {@code foo}.
   *   <li>When {@link Edge#Edge(String)} with {@code Group}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link MapGenerator#_apply(Element)}
   */
  @Test
  @DisplayName(
      "Test _apply(Element); given LinkedHashMap() 'foo' is 'foo'; when Edge(String) with 'Group'; then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map MapGenerator._apply(Element)"})
  void test_apply_givenLinkedHashMapFooIsFoo_whenEdgeWithGroup_thenReturnEmpty() {
    // Arrange
    LinkedHashMap<String, String> fields = new LinkedHashMap<>();
    fields.put("foo", "foo");

    MapGenerator mapGenerator = new MapGenerator();
    mapGenerator.setFields(fields);

    // Act and Assert
    assertTrue(mapGenerator._apply(new Edge("Group")).isEmpty());
  }

  /**
   * Test {@link MapGenerator#_apply(Element)}.
   *
   * <ul>
   *   <li>Given {@link LinkedHashMap#LinkedHashMap()} {@link MapGenerator#GROUP} is {@code foo}.
   *   <li>When {@link Edge#Edge(String)} with {@code Group}.
   *   <li>Then return {@code foo} is {@code Group}.
   * </ul>
   *
   * <p>Method under test: {@link MapGenerator#_apply(Element)}
   */
  @Test
  @DisplayName(
      "Test _apply(Element); given LinkedHashMap() GROUP is 'foo'; when Edge(String) with 'Group'; then return 'foo' is 'Group'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map MapGenerator._apply(Element)"})
  void test_apply_givenLinkedHashMapGroupIsFoo_whenEdgeWithGroup_thenReturnFooIsGroup() {
    // Arrange
    LinkedHashMap<String, String> fields = new LinkedHashMap<>();
    fields.put(MapGenerator.GROUP, "foo");

    MapGenerator mapGenerator = new MapGenerator();
    mapGenerator.setFields(fields);

    // Act
    Map<String, Object> actual_applyResult = mapGenerator._apply(new Edge("Group"));

    // Assert
    assertEquals(1, actual_applyResult.size());
    assertEquals("Group", actual_applyResult.get("foo"));
  }

  /**
   * Test {@link MapGenerator#_apply(Element)}.
   *
   * <ul>
   *   <li>Given {@link MapGenerator} (default constructor).
   *   <li>When {@link Edge#Edge(String)} with {@code Group}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link MapGenerator#_apply(Element)}
   */
  @Test
  @DisplayName(
      "Test _apply(Element); given MapGenerator (default constructor); when Edge(String) with 'Group'; then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map MapGenerator._apply(Element)"})
  void test_apply_givenMapGenerator_whenEdgeWithGroup_thenReturnEmpty() {
    // Arrange
    MapGenerator mapGenerator = new MapGenerator();

    // Act and Assert
    assertTrue(mapGenerator._apply(new Edge("Group")).isEmpty());
  }

  /**
   * Test {@link MapGenerator#setFields(LinkedHashMap)}.
   *
   * <ul>
   *   <li>When {@link LinkedHashMap#LinkedHashMap()}.
   *   <li>Then {@link MapGenerator} (default constructor) Fields is {@link
   *       LinkedHashMap#LinkedHashMap()}.
   * </ul>
   *
   * <p>Method under test: {@link MapGenerator#setFields(LinkedHashMap)}
   */
  @Test
  @DisplayName(
      "Test setFields(LinkedHashMap); when LinkedHashMap(); then MapGenerator (default constructor) Fields is LinkedHashMap()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then {@link MapGenerator} (default constructor) Fields is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link MapGenerator#setFields(LinkedHashMap)}
   */
  @Test
  @DisplayName(
      "Test setFields(LinkedHashMap); when 'null'; then MapGenerator (default constructor) Fields is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
   *
   * <ul>
   *   <li>When {@link LinkedHashMap#LinkedHashMap()}.
   *   <li>Then {@link MapGenerator} (default constructor) Constants is {@link
   *       LinkedHashMap#LinkedHashMap()}.
   * </ul>
   *
   * <p>Method under test: {@link MapGenerator#setConstants(LinkedHashMap)}
   */
  @Test
  @DisplayName(
      "Test setConstants(LinkedHashMap); when LinkedHashMap(); then MapGenerator (default constructor) Constants is LinkedHashMap()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then {@link MapGenerator} (default constructor) Constants is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link MapGenerator#setConstants(LinkedHashMap)}
   */
  @Test
  @DisplayName(
      "Test setConstants(LinkedHashMap); when 'null'; then MapGenerator (default constructor) Constants is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link MapGenerator}
   *   <li>{@link MapGenerator#getConstants()}
   *   <li>{@link MapGenerator#getFields()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void MapGenerator.<init>()",
    "LinkedHashMap MapGenerator.getConstants()",
    "LinkedHashMap MapGenerator.getFields()"
  })
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
