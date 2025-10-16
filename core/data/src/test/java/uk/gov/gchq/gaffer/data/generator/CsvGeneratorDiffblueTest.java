package uk.gov.gchq.gaffer.data.generator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
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
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Builder#build()}
   *   <li>default or parameterless constructor of {@link Builder}
   *   <li>{@link Builder#commaReplacement(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void Builder.<init>()",
    "CsvGenerator Builder.build()",
    "Builder Builder.commaReplacement(String)"
  })
  void testBuilderBuild() {
    // Arrange and Act
    CsvGenerator actualCsvGenerator =
        new Builder().commaReplacement("Comma Replacement").quoted(true).build();

    // Assert
    assertEquals("", actualCsvGenerator.getHeader());
    assertEquals("Comma Replacement", actualCsvGenerator.getCommaReplacement());
    assertFalse(actualCsvGenerator.getIncludeDefaultFields());
    assertFalse(actualCsvGenerator.getIncludeSchemaProperties());
    assertTrue(actualCsvGenerator.isQuoted());
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
    assertEquals("42", builder.build().getHeader());
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
    Builder actualDestinationResult = builder.destination("Column Header");

    // Assert
    assertEquals("Column Header", builder.build().getHeader());
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
    Builder actualDirectionResult = builder.direction("Column Header");

    // Assert
    assertEquals("Column Header", builder.build().getHeader());
    assertSame(builder, actualDirectionResult);
  }

  /**
   * Test Builder {@link Builder#edgeGroup(String)}.
   *
   * <p>Method under test: {@link Builder#edgeGroup(String)}
   */
  @Test
  @DisplayName("Test Builder edgeGroup(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
   *
   * <p>Method under test: {@link Builder#entityGroup(String)}
   */
  @Test
  @DisplayName("Test Builder entityGroup(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
    Builder actualGroupResult = builder.group("Column Header");

    // Assert
    assertEquals("Column Header", builder.build().getHeader());
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
    Builder actualIdentifierResult = builder.identifier(IdentifierType.VERTEX, "Column Header");

    // Assert
    assertEquals("Column Header", builder.build().getHeader());
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
    Builder actualPropertyResult = builder.property("Property Name", "Column Header");

    // Assert
    assertEquals("Column Header", builder.build().getHeader());
    assertSame(builder, actualPropertyResult);
  }

  /**
   * Test Builder {@link Builder#quoted(boolean)}.
   *
   * <p>Method under test: {@link Builder#quoted(boolean)}
   */
  @Test
  @DisplayName("Test Builder quoted(boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
   *
   * <p>Method under test: {@link Builder#setAdditionalFieldsFromSchemaProperties(LinkedHashMap)}
   */
  @Test
  @DisplayName("Test Builder setAdditionalFieldsFromSchemaProperties(LinkedHashMap)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.setAdditionalFieldsFromSchemaProperties(LinkedHashMap)"})
  void testBuilderSetAdditionalFieldsFromSchemaProperties() {
    // Arrange
    Builder builder = new Builder();

    // Act
    Builder actualSetAdditionalFieldsFromSchemaPropertiesResult =
        builder.setAdditionalFieldsFromSchemaProperties(new LinkedHashMap<>());

    // Assert
    assertSame(builder, actualSetAdditionalFieldsFromSchemaPropertiesResult);
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
    Builder actualSourceResult = builder.source("Column Header");

    // Assert
    assertEquals("Column Header", builder.build().getHeader());
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
    Builder actualVertexResult = builder.vertex("Column Header");

    // Assert
    assertEquals("Column Header", builder.build().getHeader());
    assertSame(builder, actualVertexResult);
  }

  /**
   * Test {@link CsvGenerator#getDefaultFields()}.
   *
   * <p>Method under test: {@link CsvGenerator#getDefaultFields()}
   */
  @Test
  @DisplayName("Test getDefaultFields()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LinkedHashMap CsvGenerator.getDefaultFields()"})
  void testGetDefaultFields() {
    // Arrange and Act
    LinkedHashMap<String, String> actualDefaultFields = new CsvGenerator().getDefaultFields();

    // Assert
    assertEquals(4, actualDefaultFields.size());
    assertEquals("DESTINATION", actualDefaultFields.get("DESTINATION"));
    assertEquals("SOURCE", actualDefaultFields.get("SOURCE"));
    assertEquals("VERTEX", actualDefaultFields.get("VERTEX"));
    assertEquals(MapGenerator.GROUP, actualDefaultFields.get(MapGenerator.GROUP));
  }

  /**
   * Test {@link CsvGenerator#setFields(LinkedHashMap)}.
   *
   * <ul>
   *   <li>Given {@link CsvGenerator} (default constructor) IncludeDefaultFields is {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link CsvGenerator#setFields(LinkedHashMap)}
   */
  @Test
  @DisplayName(
      "Test setFields(LinkedHashMap); given CsvGenerator (default constructor) IncludeDefaultFields is 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
   *
   * <ul>
   *   <li>Given {@link CsvGenerator} (default constructor) IncludeDefaultFields is {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link CsvGenerator#setFields(LinkedHashMap)}
   */
  @Test
  @DisplayName(
      "Test setFields(LinkedHashMap); given CsvGenerator (default constructor) IncludeDefaultFields is 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
   *
   * <ul>
   *   <li>Given {@link CsvGenerator} (default constructor).
   *   <li>Then {@link CsvGenerator} (default constructor) Fields is {@link
   *       LinkedHashMap#LinkedHashMap()}.
   * </ul>
   *
   * <p>Method under test: {@link CsvGenerator#setFields(LinkedHashMap)}
   */
  @Test
  @DisplayName(
      "Test setFields(LinkedHashMap); given CsvGenerator (default constructor); then CsvGenerator (default constructor) Fields is LinkedHashMap()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
   *
   * <ul>
   *   <li>When {@link LinkedHashMap#LinkedHashMap()}.
   *   <li>Then {@link CsvGenerator} (default constructor) Constants is {@link
   *       LinkedHashMap#LinkedHashMap()}.
   * </ul>
   *
   * <p>Method under test: {@link CsvGenerator#setConstants(LinkedHashMap)}
   */
  @Test
  @DisplayName(
      "Test setConstants(LinkedHashMap); when LinkedHashMap(); then CsvGenerator (default constructor) Constants is LinkedHashMap()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then {@link CsvGenerator} (default constructor) Constants is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link CsvGenerator#setConstants(LinkedHashMap)}
   */
  @Test
  @DisplayName(
      "Test setConstants(LinkedHashMap); when 'null'; then CsvGenerator (default constructor) Constants is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
   *
   * <ul>
   *   <li>Given {@link CsvGenerator} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link
   * CsvGenerator#addAdditionalFieldsFromSchemaProperties(LinkedHashMap)}
   */
  @Test
  @DisplayName(
      "Test addAdditionalFieldsFromSchemaProperties(LinkedHashMap); given CsvGenerator (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
   *
   * <ul>
   *   <li>Then {@link CsvGenerator} (default constructor) Fields size is one.
   * </ul>
   *
   * <p>Method under test: {@link
   * CsvGenerator#addAdditionalFieldsFromSchemaProperties(LinkedHashMap)}
   */
  @Test
  @DisplayName(
      "Test addAdditionalFieldsFromSchemaProperties(LinkedHashMap); then CsvGenerator (default constructor) Fields size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CsvGenerator.addAdditionalFieldsFromSchemaProperties(LinkedHashMap)"})
  void testAddAdditionalFieldsFromSchemaProperties_thenCsvGeneratorFieldsSizeIsOne() {
    // Arrange
    CsvGenerator csvGenerator = new CsvGenerator();
    csvGenerator.setIncludeSchemaProperties(true);

    LinkedHashMap<String, Class<?>> schemaProperties = new LinkedHashMap<>();
    Class<Object> forNameResult = Object.class;
    schemaProperties.put("foo", forNameResult);

    // Act
    csvGenerator.addAdditionalFieldsFromSchemaProperties(schemaProperties);

    // Assert
    LinkedHashMap<String, String> fields = csvGenerator.getFields();
    assertEquals(1, fields.size());
    assertEquals("foo", fields.get("foo"));
    assertEquals("foo", csvGenerator.getHeader());
  }

  /**
   * Test {@link CsvGenerator#addAdditionalFieldsFromSchemaProperties(LinkedHashMap)}.
   *
   * <ul>
   *   <li>Then {@link CsvGenerator} (default constructor) Header is empty string.
   * </ul>
   *
   * <p>Method under test: {@link
   * CsvGenerator#addAdditionalFieldsFromSchemaProperties(LinkedHashMap)}
   */
  @Test
  @DisplayName(
      "Test addAdditionalFieldsFromSchemaProperties(LinkedHashMap); then CsvGenerator (default constructor) Header is empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
   *
   * <ul>
   *   <li>Given {@link CsvGenerator} (default constructor).
   *   <li>When {@link Edge#Edge(String)} with {@code Group}.
   *   <li>Then return empty string.
   * </ul>
   *
   * <p>Method under test: {@link CsvGenerator#_apply(Element)}
   */
  @Test
  @DisplayName(
      "Test _apply(Element); given CsvGenerator (default constructor); when Edge(String) with 'Group'; then return empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String CsvGenerator._apply(Element)"})
  void test_apply_givenCsvGenerator_whenEdgeWithGroup_thenReturnEmptyString() {
    // Arrange
    CsvGenerator csvGenerator = new CsvGenerator();

    // Act
    String actual_applyResult = csvGenerator._apply(new Edge("Group"));

    // Assert
    assertEquals("", actual_applyResult);
  }

  /**
   * Test {@link CsvGenerator#_apply(Element)}.
   *
   * <ul>
   *   <li>Given {@code ENTITY_GROUP}.
   *   <li>Then return {@code ,Value,Property,Source,Dest}.
   * </ul>
   *
   * <p>Method under test: {@link CsvGenerator#_apply(Element)}
   */
  @Test
  @DisplayName(
      "Test _apply(Element); given 'ENTITY_GROUP'; then return ',Value,Property,Source,Dest'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String CsvGenerator._apply(Element)"})
  void test_apply_givenEntityGroup_thenReturnValuePropertySourceDest() {
    // Arrange
    Neo4jCsvGenerator neo4jCsvGenerator = new Neo4jCsvGenerator();

    ElementValueLoader valueLoader = mock(ElementValueLoader.class);
    when(valueLoader.getProperty(Mockito.<String>any(), Mockito.<Properties>any()))
        .thenReturn("Property");
    doNothing().when(valueLoader).loadIdentifiers(Mockito.<Element>any());
    Edge edge =
        new Edge.Builder()
            .dest("Dest")
            .directed(true)
            .group("Group")
            .matchedVertex(MatchedVertex.SOURCE)
            .source("Source")
            .build();

    LazyEdge element = new LazyEdge(edge, valueLoader);
    element.putProperty("ENTITY_GROUP", "Value");
    element.putProperty(",", "Value");

    // Act
    String actual_applyResult = neo4jCsvGenerator._apply(element);

    // Assert
    verify(valueLoader).getProperty(eq("EDGE_GROUP"), isA(Properties.class));
    verify(valueLoader).loadIdentifiers(isA(Element.class));
    assertEquals(",Value,Property,Source,Dest", actual_applyResult);
    Properties properties = element.getElement().getProperties();
    assertEquals(3, properties.size());
    assertEquals("Property", properties.get("EDGE_GROUP"));
    LazyProperties properties2 = element.getProperties();
    assertEquals(3, properties2.size());
    assertEquals("Property", properties2.get((Object) "EDGE_GROUP"));
    assertTrue(properties.containsKey(","));
    assertTrue(properties.containsKey("ENTITY_GROUP"));
    assertTrue(properties2.containsKey(","));
    assertTrue(properties2.containsKey("ENTITY_GROUP"));
  }

  /**
   * Test {@link CsvGenerator#_apply(Element)}.
   *
   * <ul>
   *   <li>Given {@link Neo4jCsvGenerator} (default constructor) Quoted is {@code true}.
   *   <li>When {@link Edge#Edge(String)} with {@code Group}.
   *   <li>Then return {@code ,,"Group",,}.
   * </ul>
   *
   * <p>Method under test: {@link CsvGenerator#_apply(Element)}
   */
  @Test
  @DisplayName(
      "Test _apply(Element); given Neo4jCsvGenerator (default constructor) Quoted is 'true'; when Edge(String) with 'Group'; then return ',,\"Group\",,'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String CsvGenerator._apply(Element)"})
  void test_apply_givenNeo4jCsvGeneratorQuotedIsTrue_whenEdgeWithGroup_thenReturnGroup() {
    // Arrange
    Neo4jCsvGenerator neo4jCsvGenerator = new Neo4jCsvGenerator();
    neo4jCsvGenerator.setQuoted(true);

    // Act
    String actual_applyResult = neo4jCsvGenerator._apply(new Edge("Group"));

    // Assert
    assertEquals(",,\"Group\",,", actual_applyResult);
  }

  /**
   * Test {@link CsvGenerator#_apply(Element)}.
   *
   * <ul>
   *   <li>Given {@link Neo4jCsvGenerator} (default constructor).
   *   <li>When {@link Edge#Edge(String)} with {@code Group}.
   *   <li>Then return {@code ,,Group,,}.
   * </ul>
   *
   * <p>Method under test: {@link CsvGenerator#_apply(Element)}
   */
  @Test
  @DisplayName(
      "Test _apply(Element); given Neo4jCsvGenerator (default constructor); when Edge(String) with 'Group'; then return ',,Group,,'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String CsvGenerator._apply(Element)"})
  void test_apply_givenNeo4jCsvGenerator_whenEdgeWithGroup_thenReturnGroup() {
    // Arrange
    Neo4jCsvGenerator neo4jCsvGenerator = new Neo4jCsvGenerator();

    // Act
    String actual_applyResult = neo4jCsvGenerator._apply(new Edge("Group"));

    // Assert
    assertEquals(",,Group,,", actual_applyResult);
  }

  /**
   * Test {@link CsvGenerator#_apply(Element)}.
   *
   * <ul>
   *   <li>Given {@code Property}.
   *   <li>Then return {@code ,Property,Property,Source,Dest}.
   * </ul>
   *
   * <p>Method under test: {@link CsvGenerator#_apply(Element)}
   */
  @Test
  @DisplayName(
      "Test _apply(Element); given 'Property'; then return ',Property,Property,Source,Dest'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String CsvGenerator._apply(Element)"})
  void test_apply_givenProperty_thenReturnPropertyPropertySourceDest() {
    // Arrange
    Neo4jCsvGenerator neo4jCsvGenerator = new Neo4jCsvGenerator();

    ElementValueLoader valueLoader = mock(ElementValueLoader.class);
    when(valueLoader.getProperty(Mockito.<String>any(), Mockito.<Properties>any()))
        .thenReturn("Property");
    doNothing().when(valueLoader).loadIdentifiers(Mockito.<Element>any());
    Edge edge =
        new Edge.Builder()
            .dest("Dest")
            .directed(true)
            .group("Group")
            .matchedVertex(MatchedVertex.SOURCE)
            .source("Source")
            .build();

    LazyEdge element = new LazyEdge(edge, valueLoader);
    element.putProperty(",", "Value");

    // Act
    String actual_applyResult = neo4jCsvGenerator._apply(element);

    // Assert
    verify(valueLoader, atLeast(1)).getProperty(Mockito.<String>any(), isA(Properties.class));
    verify(valueLoader).loadIdentifiers(isA(Element.class));
    assertEquals(",Property,Property,Source,Dest", actual_applyResult);
    Properties properties = element.getElement().getProperties();
    assertEquals(3, properties.size());
    assertEquals("Property", properties.get("ENTITY_GROUP"));
    LazyProperties properties2 = element.getProperties();
    assertEquals(3, properties2.size());
    assertEquals("Property", properties2.get((Object) "ENTITY_GROUP"));
    assertTrue(properties.containsKey(","));
    assertTrue(properties.containsKey("EDGE_GROUP"));
    assertTrue(properties2.containsKey(","));
    assertTrue(properties2.containsKey("EDGE_GROUP"));
  }

  /**
   * Test {@link CsvGenerator#_apply(Element)}.
   *
   * <ul>
   *   <li>When {@link Entity.Builder} (default constructor) group {@code Group} vertex {@code
   *       Vertex} build.
   *   <li>Then return {@code Vertex,Group,,,}.
   * </ul>
   *
   * <p>Method under test: {@link CsvGenerator#_apply(Element)}
   */
  @Test
  @DisplayName(
      "Test _apply(Element); when Builder (default constructor) group 'Group' vertex 'Vertex' build; then return 'Vertex,Group,,,'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String CsvGenerator._apply(Element)"})
  void test_apply_whenBuilderGroupGroupVertexVertexBuild_thenReturnVertexGroup() {
    // Arrange
    Neo4jCsvGenerator neo4jCsvGenerator = new Neo4jCsvGenerator();

    // Act
    String actual_applyResult =
        neo4jCsvGenerator._apply(new Entity.Builder().group("Group").vertex("Vertex").build());

    // Assert
    assertEquals("Vertex,Group,,,", actual_applyResult);
  }

  /**
   * Test {@link CsvGenerator#getHeader()}.
   *
   * <ul>
   *   <li>Given {@link CsvGenerator} (default constructor) Constants is {@link
   *       LinkedHashMap#LinkedHashMap()}.
   *   <li>Then return {@code foo}.
   * </ul>
   *
   * <p>Method under test: {@link CsvGenerator#getHeader()}
   */
  @Test
  @DisplayName(
      "Test getHeader(); given CsvGenerator (default constructor) Constants is LinkedHashMap(); then return 'foo'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
   *
   * <ul>
   *   <li>Given {@link CsvGenerator} (default constructor) Fields is {@link
   *       LinkedHashMap#LinkedHashMap()}.
   *   <li>Then return {@code foo}.
   * </ul>
   *
   * <p>Method under test: {@link CsvGenerator#getHeader()}
   */
  @Test
  @DisplayName(
      "Test getHeader(); given CsvGenerator (default constructor) Fields is LinkedHashMap(); then return 'foo'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
   *
   * <ul>
   *   <li>Given {@link CsvGenerator} (default constructor).
   *   <li>Then return empty string.
   * </ul>
   *
   * <p>Method under test: {@link CsvGenerator#getHeader()}
   */
  @Test
  @DisplayName(
      "Test getHeader(); given CsvGenerator (default constructor); then return empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String CsvGenerator.getHeader()"})
  void testGetHeader_givenCsvGenerator_thenReturnEmptyString() {
    // Arrange, Act and Assert
    assertEquals("", new CsvGenerator().getHeader());
  }

  /**
   * Test {@link CsvGenerator#getHeader()}.
   *
   * <ul>
   *   <li>Given {@link Neo4jCsvGenerator} (default constructor) CommaReplacement is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link CsvGenerator#getHeader()}
   */
  @Test
  @DisplayName(
      "Test getHeader(); given Neo4jCsvGenerator (default constructor) CommaReplacement is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String CsvGenerator.getHeader()"})
  void testGetHeader_givenNeo4jCsvGeneratorCommaReplacementIsNull() {
    // Arrange
    Neo4jCsvGenerator neo4jCsvGenerator = new Neo4jCsvGenerator();
    neo4jCsvGenerator.setCommaReplacement(null);

    // Act and Assert
    assertEquals("_id,_labels,_type,_start,_end", neo4jCsvGenerator.getHeader());
  }

  /**
   * Test {@link CsvGenerator#getHeader()}.
   *
   * <ul>
   *   <li>Given {@link Neo4jCsvGenerator} (default constructor) Quoted is {@code true}.
   *   <li>Then return {@code "_id","_labels","_type","_start","_end"}.
   * </ul>
   *
   * <p>Method under test: {@link CsvGenerator#getHeader()}
   */
  @Test
  @DisplayName(
      "Test getHeader(); given Neo4jCsvGenerator (default constructor) Quoted is 'true'; then return '\"_id\",\"_labels\",\"_type\",\"_start\",\"_end\"'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String CsvGenerator.getHeader()"})
  void testGetHeader_givenNeo4jCsvGeneratorQuotedIsTrue_thenReturnIdLabelsTypeStartEnd() {
    // Arrange
    Neo4jCsvGenerator neo4jCsvGenerator = new Neo4jCsvGenerator();
    neo4jCsvGenerator.setQuoted(true);

    // Act and Assert
    assertEquals(
        "\"_id\",\"_labels\",\"_type\",\"_start\",\"_end\"", neo4jCsvGenerator.getHeader());
  }

  /**
   * Test {@link CsvGenerator#getHeader()}.
   *
   * <ul>
   *   <li>Given {@link Neo4jCsvGenerator} (default constructor).
   *   <li>Then return {@code _id,_labels,_type,_start,_end}.
   * </ul>
   *
   * <p>Method under test: {@link CsvGenerator#getHeader()}
   */
  @Test
  @DisplayName(
      "Test getHeader(); given Neo4jCsvGenerator (default constructor); then return '_id,_labels,_type,_start,_end'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String CsvGenerator.getHeader()"})
  void testGetHeader_givenNeo4jCsvGenerator_thenReturnIdLabelsTypeStartEnd() {
    // Arrange, Act and Assert
    assertEquals("_id,_labels,_type,_start,_end", new Neo4jCsvGenerator().getHeader());
  }

  /**
   * Test {@link CsvGenerator#getHeader()}.
   *
   * <ul>
   *   <li>Then return {@code _id,_labels,_type,_start,_end,foo}.
   * </ul>
   *
   * <p>Method under test: {@link CsvGenerator#getHeader()}
   */
  @Test
  @DisplayName("Test getHeader(); then return '_id,_labels,_type,_start,_end,foo'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
   *
   * <p>Methods under test:
   *
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String CsvGenerator.getCommaReplacement()",
    "LinkedHashMap CsvGenerator.getConstants()",
    "LinkedHashMap CsvGenerator.getFields()",
    "boolean CsvGenerator.getIncludeDefaultFields()",
    "boolean CsvGenerator.getIncludeSchemaProperties()",
    "boolean CsvGenerator.isQuoted()",
    "void CsvGenerator.setCommaReplacement(String)",
    "void CsvGenerator.setIncludeDefaultFields(boolean)",
    "void CsvGenerator.setIncludeSchemaProperties(boolean)",
    "void CsvGenerator.setQuoted(boolean)"
  })
  void testGettersAndSetters() {
    // Arrange
    CsvGenerator csvGenerator =
        new Builder().commaReplacement("Comma Replacement").quoted(true).build();

    // Act
    csvGenerator.setCommaReplacement("Comma Replacement");
    csvGenerator.setIncludeDefaultFields(true);
    csvGenerator.setIncludeSchemaProperties(true);
    csvGenerator.setQuoted(true);
    String actualCommaReplacement = csvGenerator.getCommaReplacement();
    LinkedHashMap<String, String> actualConstants = csvGenerator.getConstants();
    LinkedHashMap<String, String> actualFields = csvGenerator.getFields();
    boolean actualIncludeDefaultFields = csvGenerator.getIncludeDefaultFields();
    boolean actualIncludeSchemaProperties = csvGenerator.getIncludeSchemaProperties();
    boolean actualIsQuotedResult = csvGenerator.isQuoted();

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
   *
   * <p>Method under test: default or parameterless constructor of {@link CsvGenerator}
   */
  @Test
  @DisplayName("Test new CsvGenerator (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
