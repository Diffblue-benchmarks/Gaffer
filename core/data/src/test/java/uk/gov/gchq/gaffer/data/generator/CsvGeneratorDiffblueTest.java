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
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.LinkedHashMap;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import uk.gov.gchq.gaffer.data.element.Edge;
import uk.gov.gchq.gaffer.data.element.Element;
import uk.gov.gchq.gaffer.data.element.ElementValueLoader;
import uk.gov.gchq.gaffer.data.element.Entity;
import uk.gov.gchq.gaffer.data.element.IdentifierType;
import uk.gov.gchq.gaffer.data.element.LazyEdge;
import uk.gov.gchq.gaffer.data.element.LazyProperties;
import uk.gov.gchq.gaffer.data.element.Properties;
import uk.gov.gchq.gaffer.data.element.id.EdgeId;
import uk.gov.gchq.gaffer.data.element.id.EdgeId.MatchedVertex;
import uk.gov.gchq.gaffer.data.generator.CsvGenerator.Builder;

class CsvGeneratorDiffblueTest {
  /**
   * Test Builder {@link Builder#build()}.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link Builder#build()}
   *   <li>default or parameterless constructor of {@link Builder}
   *   <li>{@link Builder#commaReplacement(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Builder.<init>()", "CsvGenerator Builder.build()",
      "Builder Builder.commaReplacement(String)"})
  void testBuilderBuild() {
    // Arrange and Act
    CsvGenerator actualBuildResult = (new Builder()).commaReplacement("Comma Replacement").quoted(true).build();

    // Assert
    assertEquals("", actualBuildResult.getHeader());
    assertEquals("Comma Replacement", actualBuildResult.getCommaReplacement());
    assertFalse(actualBuildResult.getIncludeDefaultFields());
    assertFalse(actualBuildResult.getIncludeSchemaProperties());
    assertTrue(actualBuildResult.isQuoted());
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

    // Act
    Builder actualConstantResult = builder.constant("Key", "42");

    // Assert
    assertEquals("42", builder.build().getHeader());
    assertSame(builder, actualConstantResult);
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

    // Act
    Builder actualDestinationResult = builder.destination("Column Header");

    // Assert
    assertEquals("Column Header", builder.build().getHeader());
    assertSame(builder, actualDestinationResult);
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

    // Act
    Builder actualDirectionResult = builder.direction("Column Header");

    // Assert
    assertEquals("Column Header", builder.build().getHeader());
    assertSame(builder, actualDirectionResult);
  }

  /**
   * Test Builder {@link Builder#edgeGroup(String)}.
   * <p>
   * Method under test: {@link Builder#edgeGroup(String)}
   */
  @Test
  @DisplayName("Test Builder edgeGroup(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.edgeGroup(String)"})
  void testBuilderEdgeGroup() {
    // Arrange
    Builder builder = new Builder();

    // Act
    Builder actualEdgeGroupResult = builder.edgeGroup("Column Header");

    // Assert
    assertEquals("Column Header", builder.build().getHeader());
    assertSame(builder, actualEdgeGroupResult);
  }

  /**
   * Test Builder {@link Builder#entityGroup(String)}.
   * <p>
   * Method under test: {@link Builder#entityGroup(String)}
   */
  @Test
  @DisplayName("Test Builder entityGroup(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.entityGroup(String)"})
  void testBuilderEntityGroup() {
    // Arrange
    Builder builder = new Builder();

    // Act
    Builder actualEntityGroupResult = builder.entityGroup("Column Header");

    // Assert
    assertEquals("Column Header", builder.build().getHeader());
    assertSame(builder, actualEntityGroupResult);
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

    // Act
    Builder actualGroupResult = builder.group("Column Header");

    // Assert
    assertEquals("Column Header", builder.build().getHeader());
    assertSame(builder, actualGroupResult);
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

    // Act
    Builder actualIdentifierResult = builder.identifier(IdentifierType.VERTEX, "Column Header");

    // Assert
    assertEquals("Column Header", builder.build().getHeader());
    assertSame(builder, actualIdentifierResult);
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

    // Act
    Builder actualPropertyResult = builder.property("Property Name", "Column Header");

    // Assert
    assertEquals("Column Header", builder.build().getHeader());
    assertSame(builder, actualPropertyResult);
  }

  /**
   * Test Builder {@link Builder#quoted(boolean)}.
   * <p>
   * Method under test: {@link Builder#quoted(boolean)}
   */
  @Test
  @DisplayName("Test Builder quoted(boolean)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.quoted(boolean)"})
  void testBuilderQuoted() {
    // Arrange
    Builder builder = new Builder();

    // Act
    Builder actualQuotedResult = builder.quoted(true);

    // Assert
    assertTrue(builder.build().isQuoted());
    assertSame(builder, actualQuotedResult);
  }

  /**
   * Test Builder {@link Builder#setAdditionalFieldsFromSchemaProperties(LinkedHashMap)}.
   * <p>
   * Method under test: {@link Builder#setAdditionalFieldsFromSchemaProperties(LinkedHashMap)}
   */
  @Test
  @DisplayName("Test Builder setAdditionalFieldsFromSchemaProperties(LinkedHashMap)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.setAdditionalFieldsFromSchemaProperties(LinkedHashMap)"})
  void testBuilderSetAdditionalFieldsFromSchemaProperties() {
    // Arrange
    Builder builder = new Builder();

    // Act and Assert
    assertSame(builder, builder.setAdditionalFieldsFromSchemaProperties(new LinkedHashMap<>()));
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

    // Act
    Builder actualSourceResult = builder.source("Column Header");

    // Assert
    assertEquals("Column Header", builder.build().getHeader());
    assertSame(builder, actualSourceResult);
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

    // Act
    Builder actualVertexResult = builder.vertex("Column Header");

    // Assert
    assertEquals("Column Header", builder.build().getHeader());
    assertSame(builder, actualVertexResult);
  }

  /**
   * Test {@link CsvGenerator#getDefaultFields()}.
   * <p>
   * Method under test: {@link CsvGenerator#getDefaultFields()}
   */
  @Test
  @DisplayName("Test getDefaultFields()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"LinkedHashMap CsvGenerator.getDefaultFields()"})
  void testGetDefaultFields() {
    // Arrange and Act
    LinkedHashMap<String, String> actualDefaultFields = (new CsvGenerator()).getDefaultFields();

    // Assert
    assertEquals(4, actualDefaultFields.size());
    assertEquals("DESTINATION", actualDefaultFields.get("DESTINATION"));
    assertEquals("SOURCE", actualDefaultFields.get("SOURCE"));
    assertEquals("VERTEX", actualDefaultFields.get("VERTEX"));
    assertEquals(MapGenerator.GROUP, actualDefaultFields.get(MapGenerator.GROUP));
  }

  /**
   * Test {@link CsvGenerator#setFields(LinkedHashMap)}.
   * <ul>
   *   <li>Given {@link CsvGenerator} (default constructor) IncludeDefaultFields is {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CsvGenerator#setFields(LinkedHashMap)}
   */
  @Test
  @DisplayName("Test setFields(LinkedHashMap); given CsvGenerator (default constructor) IncludeDefaultFields is 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void CsvGenerator.setFields(LinkedHashMap)"})
  void testSetFields_givenCsvGeneratorIncludeDefaultFieldsIsFalse() {
    // Arrange
    CsvGenerator csvGenerator = new CsvGenerator();
    csvGenerator.setIncludeDefaultFields(false);

    // Act
    csvGenerator.setFields(null);

    // Assert
    assertNull(csvGenerator.getFields());
  }

  /**
   * Test {@link CsvGenerator#setFields(LinkedHashMap)}.
   * <ul>
   *   <li>Given {@link CsvGenerator} (default constructor) IncludeDefaultFields is {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CsvGenerator#setFields(LinkedHashMap)}
   */
  @Test
  @DisplayName("Test setFields(LinkedHashMap); given CsvGenerator (default constructor) IncludeDefaultFields is 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void CsvGenerator.setFields(LinkedHashMap)"})
  void testSetFields_givenCsvGeneratorIncludeDefaultFieldsIsTrue() {
    // Arrange
    CsvGenerator csvGenerator = new CsvGenerator();
    csvGenerator.setIncludeDefaultFields(true);

    // Act
    csvGenerator.setFields(null);

    // Assert
    assertNull(csvGenerator.getFields());
  }

  /**
   * Test {@link CsvGenerator#setFields(LinkedHashMap)}.
   * <ul>
   *   <li>Given {@link CsvGenerator} (default constructor).</li>
   *   <li>Then {@link CsvGenerator} (default constructor) Fields is {@link LinkedHashMap#LinkedHashMap()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CsvGenerator#setFields(LinkedHashMap)}
   */
  @Test
  @DisplayName("Test setFields(LinkedHashMap); given CsvGenerator (default constructor); then CsvGenerator (default constructor) Fields is LinkedHashMap()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void CsvGenerator.setFields(LinkedHashMap)"})
  void testSetFields_givenCsvGenerator_thenCsvGeneratorFieldsIsLinkedHashMap() {
    // Arrange
    CsvGenerator csvGenerator = new CsvGenerator();
    LinkedHashMap<String, String> fields = new LinkedHashMap<>();

    // Act
    csvGenerator.setFields(fields);

    // Assert
    assertSame(fields, csvGenerator.getFields());
  }

  /**
   * Test {@link CsvGenerator#setConstants(LinkedHashMap)}.
   * <ul>
   *   <li>When {@link LinkedHashMap#LinkedHashMap()}.</li>
   *   <li>Then {@link CsvGenerator} (default constructor) Constants is {@link LinkedHashMap#LinkedHashMap()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CsvGenerator#setConstants(LinkedHashMap)}
   */
  @Test
  @DisplayName("Test setConstants(LinkedHashMap); when LinkedHashMap(); then CsvGenerator (default constructor) Constants is LinkedHashMap()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void CsvGenerator.setConstants(LinkedHashMap)"})
  void testSetConstants_whenLinkedHashMap_thenCsvGeneratorConstantsIsLinkedHashMap() {
    // Arrange
    CsvGenerator csvGenerator = new CsvGenerator();
    LinkedHashMap<String, String> constants = new LinkedHashMap<>();

    // Act
    csvGenerator.setConstants(constants);

    // Assert
    assertSame(constants, csvGenerator.getConstants());
  }

  /**
   * Test {@link CsvGenerator#setConstants(LinkedHashMap)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then {@link CsvGenerator} (default constructor) Constants is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CsvGenerator#setConstants(LinkedHashMap)}
   */
  @Test
  @DisplayName("Test setConstants(LinkedHashMap); when 'null'; then CsvGenerator (default constructor) Constants is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void CsvGenerator.setConstants(LinkedHashMap)"})
  void testSetConstants_whenNull_thenCsvGeneratorConstantsIsNull() {
    // Arrange
    CsvGenerator csvGenerator = new CsvGenerator();

    // Act
    csvGenerator.setConstants(null);

    // Assert
    assertNull(csvGenerator.getConstants());
  }

  /**
   * Test {@link CsvGenerator#addAdditionalFieldsFromSchemaProperties(LinkedHashMap)}.
   * <ul>
   *   <li>Given {@link CsvGenerator} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link CsvGenerator#addAdditionalFieldsFromSchemaProperties(LinkedHashMap)}
   */
  @Test
  @DisplayName("Test addAdditionalFieldsFromSchemaProperties(LinkedHashMap); given CsvGenerator (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void CsvGenerator.addAdditionalFieldsFromSchemaProperties(LinkedHashMap)"})
  void testAddAdditionalFieldsFromSchemaProperties_givenCsvGenerator() {
    // Arrange
    CsvGenerator csvGenerator = new CsvGenerator();

    // Act
    csvGenerator.addAdditionalFieldsFromSchemaProperties(new LinkedHashMap<>());

    // Assert that nothing has changed
    assertEquals("", csvGenerator.getHeader());
    assertTrue(csvGenerator.getFields().isEmpty());
  }

  /**
   * Test {@link CsvGenerator#addAdditionalFieldsFromSchemaProperties(LinkedHashMap)}.
   * <ul>
   *   <li>Then {@link CsvGenerator} (default constructor) Fields size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link CsvGenerator#addAdditionalFieldsFromSchemaProperties(LinkedHashMap)}
   */
  @Test
  @DisplayName("Test addAdditionalFieldsFromSchemaProperties(LinkedHashMap); then CsvGenerator (default constructor) Fields size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void CsvGenerator.addAdditionalFieldsFromSchemaProperties(LinkedHashMap)"})
  void testAddAdditionalFieldsFromSchemaProperties_thenCsvGeneratorFieldsSizeIsOne() {
    // Arrange
    CsvGenerator csvGenerator = new CsvGenerator();
    csvGenerator.setIncludeSchemaProperties(true);

    LinkedHashMap<String, Class<?>> schemaProperties = new LinkedHashMap<>();
    Class<Object> forNameResult = Object.class;
    schemaProperties.put("42", forNameResult);

    // Act
    csvGenerator.addAdditionalFieldsFromSchemaProperties(schemaProperties);

    // Assert
    LinkedHashMap<String, String> fields = csvGenerator.getFields();
    assertEquals(1, fields.size());
    assertEquals("42", fields.get("42"));
    assertEquals("42", csvGenerator.getHeader());
  }

  /**
   * Test {@link CsvGenerator#addAdditionalFieldsFromSchemaProperties(LinkedHashMap)}.
   * <ul>
   *   <li>Then {@link CsvGenerator} (default constructor) Header is empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link CsvGenerator#addAdditionalFieldsFromSchemaProperties(LinkedHashMap)}
   */
  @Test
  @DisplayName("Test addAdditionalFieldsFromSchemaProperties(LinkedHashMap); then CsvGenerator (default constructor) Header is empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void CsvGenerator.addAdditionalFieldsFromSchemaProperties(LinkedHashMap)"})
  void testAddAdditionalFieldsFromSchemaProperties_thenCsvGeneratorHeaderIsEmptyString() {
    // Arrange
    CsvGenerator csvGenerator = new CsvGenerator();
    csvGenerator.setIncludeSchemaProperties(true);

    // Act
    csvGenerator.addAdditionalFieldsFromSchemaProperties(new LinkedHashMap<>());

    // Assert that nothing has changed
    assertEquals("", csvGenerator.getHeader());
    assertTrue(csvGenerator.getFields().isEmpty());
  }

  /**
   * Test {@link CsvGenerator#_apply(Element)}.
   * <ul>
   *   <li>Given {@link CsvGenerator} (default constructor).</li>
   *   <li>When {@link Edge#Edge(String)} with {@code Group}.</li>
   *   <li>Then return empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link CsvGenerator#_apply(Element)}
   */
  @Test
  @DisplayName("Test _apply(Element); given CsvGenerator (default constructor); when Edge(String) with 'Group'; then return empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String CsvGenerator._apply(Element)"})
  void test_apply_givenCsvGenerator_whenEdgeWithGroup_thenReturnEmptyString() {
    // Arrange
    CsvGenerator csvGenerator = new CsvGenerator();

    // Act and Assert
    assertEquals("", csvGenerator._apply(new Edge("Group")));
  }

  /**
   * Test {@link CsvGenerator#_apply(Element)}.
   * <ul>
   *   <li>Given {@link Neo4jCsvGenerator} (default constructor) Quoted is {@code true}.</li>
   *   <li>When {@link Edge#Edge(String)} with {@code Group}.</li>
   *   <li>Then return {@code ,,"Group",,}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CsvGenerator#_apply(Element)}
   */
  @Test
  @DisplayName("Test _apply(Element); given Neo4jCsvGenerator (default constructor) Quoted is 'true'; when Edge(String) with 'Group'; then return ',,\"Group\",,'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String CsvGenerator._apply(Element)"})
  void test_apply_givenNeo4jCsvGeneratorQuotedIsTrue_whenEdgeWithGroup_thenReturnGroup() {
    // Arrange
    Neo4jCsvGenerator neo4jCsvGenerator = new Neo4jCsvGenerator();
    neo4jCsvGenerator.setQuoted(true);

    // Act and Assert
    assertEquals(",,\"Group\",,", neo4jCsvGenerator._apply(new Edge("Group")));
  }

  /**
   * Test {@link CsvGenerator#_apply(Element)}.
   * <ul>
   *   <li>Given {@link Neo4jCsvGenerator} (default constructor).</li>
   *   <li>When {@link Edge#Edge(String)} with {@code Group}.</li>
   *   <li>Then return {@code ,,Group,,}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CsvGenerator#_apply(Element)}
   */
  @Test
  @DisplayName("Test _apply(Element); given Neo4jCsvGenerator (default constructor); when Edge(String) with 'Group'; then return ',,Group,,'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String CsvGenerator._apply(Element)"})
  void test_apply_givenNeo4jCsvGenerator_whenEdgeWithGroup_thenReturnGroup() {
    // Arrange
    Neo4jCsvGenerator neo4jCsvGenerator = new Neo4jCsvGenerator();

    // Act and Assert
    assertEquals(",,Group,,", neo4jCsvGenerator._apply(new Edge("Group")));
  }

  /**
   * Test {@link CsvGenerator#_apply(Element)}.
   * <ul>
   *   <li>Given {@code Property}.</li>
   *   <li>Then return {@code ,Value,Property,Source,Dest}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CsvGenerator#_apply(Element)}
   */
  @Test
  @DisplayName("Test _apply(Element); given 'Property'; then return ',Value,Property,Source,Dest'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String CsvGenerator._apply(Element)"})
  void test_apply_givenProperty_thenReturnValuePropertySourceDest() {
    // Arrange
    Neo4jCsvGenerator neo4jCsvGenerator = new Neo4jCsvGenerator();
    ElementValueLoader valueLoader = mock(ElementValueLoader.class);
    when(valueLoader.getProperty(Mockito.<String>any(), Mockito.<Properties>any())).thenReturn("Property");
    doNothing().when(valueLoader).loadIdentifiers(Mockito.<Element>any());
    Edge edge = (new Edge.Builder()).dest("Dest")
        .directed(true)
        .group("Group")
        .matchedVertex(MatchedVertex.SOURCE)
        .source("Source")
        .build();

    LazyEdge element = new LazyEdge(edge, valueLoader);
    element.putProperty("ENTITY_GROUP", "Value");

    // Act
    String actual_applyResult = neo4jCsvGenerator._apply(element);

    // Assert
    verify(valueLoader).getProperty(eq("EDGE_GROUP"), isA(Properties.class));
    verify(valueLoader).loadIdentifiers(isA(Element.class));
    assertEquals(",Value,Property,Source,Dest", actual_applyResult);
    Properties properties = element.getElement().getProperties();
    assertEquals(2, properties.size());
    assertEquals("Property", properties.get("EDGE_GROUP"));
    LazyProperties properties2 = element.getProperties();
    assertEquals(2, properties2.size());
    assertEquals("Property", properties2.get((Object) "EDGE_GROUP"));
    assertTrue(properties.containsKey("ENTITY_GROUP"));
    assertTrue(properties2.containsKey("ENTITY_GROUP"));
  }

  /**
   * Test {@link CsvGenerator#_apply(Element)}.
   * <ul>
   *   <li>Then return {@code Vertex,Group,,,}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CsvGenerator#_apply(Element)}
   */
  @Test
  @DisplayName("Test _apply(Element); then return 'Vertex,Group,,,'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String CsvGenerator._apply(Element)"})
  void test_apply_thenReturnVertexGroup() {
    // Arrange
    Neo4jCsvGenerator neo4jCsvGenerator = new Neo4jCsvGenerator();
    Entity element = (new Entity.Builder()).group("Group").vertex("Vertex").build();
    element.putProperty("ENTITY_GROUP", "Value");

    // Act and Assert
    assertEquals("Vertex,Group,,,", neo4jCsvGenerator._apply(element));
  }

  /**
   * Test {@link CsvGenerator#getHeader()}.
   * <ul>
   *   <li>Given {@link CsvGenerator} (default constructor) Constants is {@link LinkedHashMap#LinkedHashMap()}.</li>
   *   <li>Then return {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CsvGenerator#getHeader()}
   */
  @Test
  @DisplayName("Test getHeader(); given CsvGenerator (default constructor) Constants is LinkedHashMap(); then return 'foo'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String CsvGenerator.getHeader()"})
  void testGetHeader_givenCsvGeneratorConstantsIsLinkedHashMap_thenReturnFoo() {
    // Arrange
    LinkedHashMap<String, String> constants = new LinkedHashMap<>();
    constants.put("foo", "foo");

    CsvGenerator csvGenerator = new CsvGenerator();
    csvGenerator.setConstants(constants);

    // Act and Assert
    assertEquals("foo", csvGenerator.getHeader());
  }

  /**
   * Test {@link CsvGenerator#getHeader()}.
   * <ul>
   *   <li>Given {@link CsvGenerator} (default constructor) Fields is {@link LinkedHashMap#LinkedHashMap()}.</li>
   *   <li>Then return {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CsvGenerator#getHeader()}
   */
  @Test
  @DisplayName("Test getHeader(); given CsvGenerator (default constructor) Fields is LinkedHashMap(); then return 'foo'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String CsvGenerator.getHeader()"})
  void testGetHeader_givenCsvGeneratorFieldsIsLinkedHashMap_thenReturnFoo() {
    // Arrange
    LinkedHashMap<String, String> fields = new LinkedHashMap<>();
    fields.put("foo", "foo");

    CsvGenerator csvGenerator = new CsvGenerator();
    csvGenerator.setFields(fields);

    // Act and Assert
    assertEquals("foo", csvGenerator.getHeader());
  }

  /**
   * Test {@link CsvGenerator#getHeader()}.
   * <ul>
   *   <li>Given {@link CsvGenerator} (default constructor).</li>
   *   <li>Then return empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link CsvGenerator#getHeader()}
   */
  @Test
  @DisplayName("Test getHeader(); given CsvGenerator (default constructor); then return empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String CsvGenerator.getHeader()"})
  void testGetHeader_givenCsvGenerator_thenReturnEmptyString() {
    // Arrange, Act and Assert
    assertEquals("", (new CsvGenerator()).getHeader());
  }

  /**
   * Test {@link CsvGenerator#getHeader()}.
   * <ul>
   *   <li>Given {@link Neo4jCsvGenerator} (default constructor) CommaReplacement is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CsvGenerator#getHeader()}
   */
  @Test
  @DisplayName("Test getHeader(); given Neo4jCsvGenerator (default constructor) CommaReplacement is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String CsvGenerator.getHeader()"})
  void testGetHeader_givenNeo4jCsvGeneratorCommaReplacementIsNull() {
    // Arrange
    Neo4jCsvGenerator neo4jCsvGenerator = new Neo4jCsvGenerator();
    neo4jCsvGenerator.setCommaReplacement(null);
    neo4jCsvGenerator.setQuoted(false);

    // Act and Assert
    assertEquals("_id,_labels,_type,_start,_end", neo4jCsvGenerator.getHeader());
  }

  /**
   * Test {@link CsvGenerator#getHeader()}.
   * <ul>
   *   <li>Given {@link Neo4jCsvGenerator} (default constructor) Quoted is {@code true}.</li>
   *   <li>Then return {@code "_id","_labels","_type","_start","_end"}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CsvGenerator#getHeader()}
   */
  @Test
  @DisplayName("Test getHeader(); given Neo4jCsvGenerator (default constructor) Quoted is 'true'; then return '\"_id\",\"_labels\",\"_type\",\"_start\",\"_end\"'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String CsvGenerator.getHeader()"})
  void testGetHeader_givenNeo4jCsvGeneratorQuotedIsTrue_thenReturnIdLabelsTypeStartEnd() {
    // Arrange
    Neo4jCsvGenerator neo4jCsvGenerator = new Neo4jCsvGenerator();
    neo4jCsvGenerator.setQuoted(true);

    // Act and Assert
    assertEquals("\"_id\",\"_labels\",\"_type\",\"_start\",\"_end\"", neo4jCsvGenerator.getHeader());
  }

  /**
   * Test {@link CsvGenerator#getHeader()}.
   * <ul>
   *   <li>Given {@link Neo4jCsvGenerator} (default constructor).</li>
   *   <li>Then return {@code _id,_labels,_type,_start,_end}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CsvGenerator#getHeader()}
   */
  @Test
  @DisplayName("Test getHeader(); given Neo4jCsvGenerator (default constructor); then return '_id,_labels,_type,_start,_end'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String CsvGenerator.getHeader()"})
  void testGetHeader_givenNeo4jCsvGenerator_thenReturnIdLabelsTypeStartEnd() {
    // Arrange, Act and Assert
    assertEquals("_id,_labels,_type,_start,_end", (new Neo4jCsvGenerator()).getHeader());
  }

  /**
   * Test {@link CsvGenerator#getHeader()}.
   * <ul>
   *   <li>Then return {@code _id,_labels,_type,_start,_end,foo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CsvGenerator#getHeader()}
   */
  @Test
  @DisplayName("Test getHeader(); then return '_id,_labels,_type,_start,_end,foo'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String CsvGenerator.getHeader()"})
  void testGetHeader_thenReturnIdLabelsTypeStartEndFoo() {
    // Arrange
    LinkedHashMap<String, String> constants = new LinkedHashMap<>();
    constants.put("foo", "foo");

    Neo4jCsvGenerator neo4jCsvGenerator = new Neo4jCsvGenerator();
    neo4jCsvGenerator.addAdditionalFieldsFromSchemaProperties(new LinkedHashMap<>());
    neo4jCsvGenerator.setConstants(constants);

    // Act and Assert
    assertEquals("_id,_labels,_type,_start,_end,foo", neo4jCsvGenerator.getHeader());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link CsvGenerator#setCommaReplacement(String)}
   *   <li>{@link CsvGenerator#setIncludeDefaultFields(boolean)}
   *   <li>{@link CsvGenerator#setIncludeSchemaProperties(boolean)}
   *   <li>{@link CsvGenerator#setQuoted(boolean)}
   *   <li>{@link CsvGenerator#getCommaReplacement()}
   *   <li>{@link CsvGenerator#getConstants()}
   *   <li>{@link CsvGenerator#getFields()}
   *   <li>{@link CsvGenerator#getIncludeDefaultFields()}
   *   <li>{@link CsvGenerator#getIncludeSchemaProperties()}
   *   <li>{@link CsvGenerator#isQuoted()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String CsvGenerator.getCommaReplacement()", "LinkedHashMap CsvGenerator.getConstants()",
      "LinkedHashMap CsvGenerator.getFields()", "boolean CsvGenerator.getIncludeDefaultFields()",
      "boolean CsvGenerator.getIncludeSchemaProperties()", "boolean CsvGenerator.isQuoted()",
      "void CsvGenerator.setCommaReplacement(String)", "void CsvGenerator.setIncludeDefaultFields(boolean)",
      "void CsvGenerator.setIncludeSchemaProperties(boolean)", "void CsvGenerator.setQuoted(boolean)"})
  void testGettersAndSetters() {
    // Arrange
    CsvGenerator buildResult = (new Builder()).commaReplacement("Comma Replacement").quoted(true).build();

    // Act
    buildResult.setCommaReplacement("Comma Replacement");
    buildResult.setIncludeDefaultFields(true);
    buildResult.setIncludeSchemaProperties(true);
    buildResult.setQuoted(true);
    String actualCommaReplacement = buildResult.getCommaReplacement();
    LinkedHashMap<String, String> actualConstants = buildResult.getConstants();
    LinkedHashMap<String, String> actualFields = buildResult.getFields();
    boolean actualIncludeDefaultFields = buildResult.getIncludeDefaultFields();
    boolean actualIncludeSchemaProperties = buildResult.getIncludeSchemaProperties();
    boolean actualIsQuotedResult = buildResult.isQuoted();

    // Assert
    assertEquals("Comma Replacement", actualCommaReplacement);
    assertTrue(actualConstants.isEmpty());
    assertTrue(actualFields.isEmpty());
    assertTrue(actualIncludeDefaultFields);
    assertTrue(actualIncludeSchemaProperties);
    assertTrue(actualIsQuotedResult);
  }

  /**
   * Test new {@link CsvGenerator} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of {@link CsvGenerator}
   */
  @Test
  @DisplayName("Test new CsvGenerator (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void CsvGenerator.<init>()"})
  void testNewCsvGenerator() {
    // Arrange and Act
    CsvGenerator actualCsvGenerator = new CsvGenerator();

    // Assert
    assertEquals(" ", actualCsvGenerator.getCommaReplacement());
    assertEquals("", actualCsvGenerator.getHeader());
    LinkedHashMap<String, String> defaultFields = actualCsvGenerator.getDefaultFields();
    assertEquals(4, defaultFields.size());
    assertEquals("DESTINATION", defaultFields.get("DESTINATION"));
    assertEquals("SOURCE", defaultFields.get("SOURCE"));
    assertEquals("VERTEX", defaultFields.get("VERTEX"));
    assertFalse(actualCsvGenerator.getIncludeDefaultFields());
    assertFalse(actualCsvGenerator.getIncludeSchemaProperties());
    assertFalse(actualCsvGenerator.isQuoted());
    LinkedHashMap<String, String> constants = actualCsvGenerator.getConstants();
    assertTrue(constants.isEmpty());
    assertEquals(MapGenerator.GROUP, defaultFields.get(MapGenerator.GROUP));
    assertEquals(constants, actualCsvGenerator.getFields());
  }
}
