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
import static org.mockito.Mockito.mock;
import java.util.LinkedHashMap;
import java.util.function.BiFunction;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.data.element.Edge;
import uk.gov.gchq.gaffer.data.element.Element;
import uk.gov.gchq.gaffer.data.element.Entity;
import uk.gov.gchq.gaffer.data.element.IdentifierType;

class CsvGeneratorDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link CsvGenerator.Builder#build()}
   *   <li>default or parameterless constructor of {@link CsvGenerator.Builder}
   *   <li>{@link CsvGenerator.Builder#commaReplacement(String)}
   * </ul>
   */
  @Test
  void testBuilderBuild() {
    // Arrange and Act
    CsvGenerator actualBuildResult = (new CsvGenerator.Builder()).commaReplacement("Comma Replacement")
        .quoted(true)
        .build();

    // Assert
    assertEquals("", actualBuildResult.getHeader());
    assertEquals("Comma Replacement", actualBuildResult.getCommaReplacement());
    assertFalse(actualBuildResult.getIncludeDefaultFields());
    assertFalse(actualBuildResult.getIncludeSchemaProperties());
    assertTrue(actualBuildResult.isQuoted());
  }

  /**
   * Method under test: {@link CsvGenerator.Builder#constant(String, String)}
   */
  @Test
  void testBuilderConstant() {
    // Arrange
    CsvGenerator.Builder builder = new CsvGenerator.Builder();

    // Act
    CsvGenerator.Builder actualConstantResult = builder.constant("Key", "42");

    // Assert
    assertEquals("42", builder.build().getHeader());
    assertSame(builder, actualConstantResult);
  }

  /**
   * Method under test: {@link CsvGenerator.Builder#destination(String)}
   */
  @Test
  void testBuilderDestination() {
    // Arrange
    CsvGenerator.Builder builder = new CsvGenerator.Builder();

    // Act
    CsvGenerator.Builder actualDestinationResult = builder.destination("Column Header");

    // Assert
    assertEquals("Column Header", builder.build().getHeader());
    assertSame(builder, actualDestinationResult);
  }

  /**
   * Method under test: {@link CsvGenerator.Builder#direction(String)}
   */
  @Test
  void testBuilderDirection() {
    // Arrange
    CsvGenerator.Builder builder = new CsvGenerator.Builder();

    // Act
    CsvGenerator.Builder actualDirectionResult = builder.direction("Column Header");

    // Assert
    assertEquals("Column Header", builder.build().getHeader());
    assertSame(builder, actualDirectionResult);
  }

  /**
   * Method under test: {@link CsvGenerator.Builder#edgeGroup(String)}
   */
  @Test
  void testBuilderEdgeGroup() {
    // Arrange
    CsvGenerator.Builder builder = new CsvGenerator.Builder();

    // Act
    CsvGenerator.Builder actualEdgeGroupResult = builder.edgeGroup("Column Header");

    // Assert
    assertEquals("Column Header", builder.build().getHeader());
    assertSame(builder, actualEdgeGroupResult);
  }

  /**
   * Method under test: {@link CsvGenerator.Builder#entityGroup(String)}
   */
  @Test
  void testBuilderEntityGroup() {
    // Arrange
    CsvGenerator.Builder builder = new CsvGenerator.Builder();

    // Act
    CsvGenerator.Builder actualEntityGroupResult = builder.entityGroup("Column Header");

    // Assert
    assertEquals("Column Header", builder.build().getHeader());
    assertSame(builder, actualEntityGroupResult);
  }

  /**
   * Method under test: {@link CsvGenerator.Builder#group(String)}
   */
  @Test
  void testBuilderGroup() {
    // Arrange
    CsvGenerator.Builder builder = new CsvGenerator.Builder();

    // Act
    CsvGenerator.Builder actualGroupResult = builder.group("Column Header");

    // Assert
    assertEquals("Column Header", builder.build().getHeader());
    assertSame(builder, actualGroupResult);
  }

  /**
   * Method under test:
   * {@link CsvGenerator.Builder#identifier(IdentifierType, String)}
   */
  @Test
  void testBuilderIdentifier() {
    // Arrange
    CsvGenerator.Builder builder = new CsvGenerator.Builder();

    // Act
    CsvGenerator.Builder actualIdentifierResult = builder.identifier(IdentifierType.VERTEX, "Column Header");

    // Assert
    assertEquals("Column Header", builder.build().getHeader());
    assertSame(builder, actualIdentifierResult);
  }

  /**
   * Method under test: {@link CsvGenerator.Builder#property(String, String)}
   */
  @Test
  void testBuilderProperty() {
    // Arrange
    CsvGenerator.Builder builder = new CsvGenerator.Builder();

    // Act
    CsvGenerator.Builder actualPropertyResult = builder.property("Property Name", "Column Header");

    // Assert
    assertEquals("Column Header", builder.build().getHeader());
    assertSame(builder, actualPropertyResult);
  }

  /**
   * Method under test: {@link CsvGenerator.Builder#quoted(boolean)}
   */
  @Test
  void testBuilderQuoted() {
    // Arrange
    CsvGenerator.Builder builder = new CsvGenerator.Builder();

    // Act
    CsvGenerator.Builder actualQuotedResult = builder.quoted(true);

    // Assert
    assertTrue(builder.build().isQuoted());
    assertSame(builder, actualQuotedResult);
  }

  /**
   * Method under test:
   * {@link CsvGenerator.Builder#setAdditionalFieldsFromSchemaProperties(LinkedHashMap)}
   */
  @Test
  void testBuilderSetAdditionalFieldsFromSchemaProperties() {
    // Arrange
    CsvGenerator.Builder builder = new CsvGenerator.Builder();

    // Act and Assert
    assertSame(builder, builder.setAdditionalFieldsFromSchemaProperties(new LinkedHashMap<>()));
  }

  /**
   * Method under test:
   * {@link CsvGenerator.Builder#setAdditionalFieldsFromSchemaProperties(LinkedHashMap)}
   */
  @Test
  void testBuilderSetAdditionalFieldsFromSchemaProperties2() {
    // Arrange
    CsvGenerator.Builder builder = new CsvGenerator.Builder();

    LinkedHashMap<String, Class<?>> schemaProperties = new LinkedHashMap<>();
    schemaProperties.replaceAll(mock(BiFunction.class));

    // Act and Assert
    assertSame(builder, builder.setAdditionalFieldsFromSchemaProperties(schemaProperties));
  }

  /**
   * Method under test: {@link CsvGenerator.Builder#source(String)}
   */
  @Test
  void testBuilderSource() {
    // Arrange
    CsvGenerator.Builder builder = new CsvGenerator.Builder();

    // Act
    CsvGenerator.Builder actualSourceResult = builder.source("Column Header");

    // Assert
    assertEquals("Column Header", builder.build().getHeader());
    assertSame(builder, actualSourceResult);
  }

  /**
   * Method under test: {@link CsvGenerator.Builder#vertex(String)}
   */
  @Test
  void testBuilderVertex() {
    // Arrange
    CsvGenerator.Builder builder = new CsvGenerator.Builder();

    // Act
    CsvGenerator.Builder actualVertexResult = builder.vertex("Column Header");

    // Assert
    assertEquals("Column Header", builder.build().getHeader());
    assertSame(builder, actualVertexResult);
  }

  /**
   * Method under test: {@link CsvGenerator#getDefaultFields()}
   */
  @Test
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
   * Method under test: {@link CsvGenerator#getDefaultFields()}
   */
  @Test
  void testGetDefaultFields2() {
    // Arrange
    LinkedHashMap<String, Class<?>> schemaProperties = new LinkedHashMap<>();
    schemaProperties.replaceAll(mock(BiFunction.class));

    CsvGenerator csvGenerator = new CsvGenerator();
    csvGenerator.addAdditionalFieldsFromSchemaProperties(schemaProperties);

    // Act
    LinkedHashMap<String, String> actualDefaultFields = csvGenerator.getDefaultFields();

    // Assert
    assertEquals(4, actualDefaultFields.size());
    assertEquals("DESTINATION", actualDefaultFields.get("DESTINATION"));
    assertEquals("SOURCE", actualDefaultFields.get("SOURCE"));
    assertEquals("VERTEX", actualDefaultFields.get("VERTEX"));
    assertEquals(MapGenerator.GROUP, actualDefaultFields.get(MapGenerator.GROUP));
  }

  /**
   * Method under test: {@link CsvGenerator#setFields(LinkedHashMap)}
   */
  @Test
  void testSetFields() {
    // Arrange
    CsvGenerator csvGenerator = new CsvGenerator();
    LinkedHashMap<String, String> fields = new LinkedHashMap<>();

    // Act
    csvGenerator.setFields(fields);

    // Assert
    assertSame(fields, csvGenerator.getFields());
  }

  /**
   * Method under test: {@link CsvGenerator#setFields(LinkedHashMap)}
   */
  @Test
  void testSetFields2() {
    // Arrange
    CsvGenerator csvGenerator = new CsvGenerator();
    csvGenerator.setIncludeDefaultFields(false);

    // Act
    csvGenerator.setFields(null);

    // Assert
    assertNull(csvGenerator.getFields());
  }

  /**
   * Method under test: {@link CsvGenerator#setFields(LinkedHashMap)}
   */
  @Test
  void testSetFields3() {
    // Arrange
    CsvGenerator csvGenerator = new CsvGenerator();

    LinkedHashMap<String, String> fields = new LinkedHashMap<>();
    fields.replaceAll(mock(BiFunction.class));

    // Act
    csvGenerator.setFields(fields);

    // Assert
    assertSame(fields, csvGenerator.getFields());
  }

  /**
   * Method under test: {@link CsvGenerator#setFields(LinkedHashMap)}
   */
  @Test
  void testSetFields4() {
    // Arrange
    CsvGenerator csvGenerator = new CsvGenerator();
    csvGenerator.setIncludeDefaultFields(true);

    // Act
    csvGenerator.setFields(null);

    // Assert
    assertNull(csvGenerator.getFields());
  }

  /**
   * Method under test: {@link CsvGenerator#setConstants(LinkedHashMap)}
   */
  @Test
  void testSetConstants() {
    // Arrange
    CsvGenerator csvGenerator = new CsvGenerator();
    LinkedHashMap<String, String> constants = new LinkedHashMap<>();

    // Act
    csvGenerator.setConstants(constants);

    // Assert
    assertSame(constants, csvGenerator.getConstants());
  }

  /**
   * Method under test: {@link CsvGenerator#setConstants(LinkedHashMap)}
   */
  @Test
  void testSetConstants2() {
    // Arrange
    CsvGenerator csvGenerator = new CsvGenerator();

    // Act
    csvGenerator.setConstants(null);

    // Assert
    assertNull(csvGenerator.getConstants());
  }

  /**
   * Method under test: {@link CsvGenerator#setConstants(LinkedHashMap)}
   */
  @Test
  void testSetConstants3() {
    // Arrange
    CsvGenerator csvGenerator = new CsvGenerator();

    LinkedHashMap<String, String> constants = new LinkedHashMap<>();
    constants.replaceAll(mock(BiFunction.class));

    // Act
    csvGenerator.setConstants(constants);

    // Assert
    assertSame(constants, csvGenerator.getConstants());
  }

  /**
   * Method under test:
   * {@link CsvGenerator#addAdditionalFieldsFromSchemaProperties(LinkedHashMap)}
   */
  @Test
  void testAddAdditionalFieldsFromSchemaProperties() {
    // Arrange
    CsvGenerator csvGenerator = new CsvGenerator();

    // Act
    csvGenerator.addAdditionalFieldsFromSchemaProperties(new LinkedHashMap<>());

    // Assert that nothing has changed
    assertEquals("", csvGenerator.getHeader());
    assertTrue(csvGenerator.getFields().isEmpty());
  }

  /**
   * Method under test:
   * {@link CsvGenerator#addAdditionalFieldsFromSchemaProperties(LinkedHashMap)}
   */
  @Test
  void testAddAdditionalFieldsFromSchemaProperties2() {
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
   * Method under test:
   * {@link CsvGenerator#addAdditionalFieldsFromSchemaProperties(LinkedHashMap)}
   */
  @Test
  void testAddAdditionalFieldsFromSchemaProperties3() {
    // Arrange
    CsvGenerator csvGenerator = new CsvGenerator();

    LinkedHashMap<String, Class<?>> schemaProperties = new LinkedHashMap<>();
    schemaProperties.replaceAll(mock(BiFunction.class));

    // Act
    csvGenerator.addAdditionalFieldsFromSchemaProperties(schemaProperties);

    // Assert that nothing has changed
    assertEquals("", csvGenerator.getHeader());
    assertTrue(csvGenerator.getFields().isEmpty());
  }

  /**
   * Method under test:
   * {@link CsvGenerator#addAdditionalFieldsFromSchemaProperties(LinkedHashMap)}
   */
  @Test
  void testAddAdditionalFieldsFromSchemaProperties4() {
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
  void testGettersAndSetters() {
    // Arrange
    CsvGenerator csvGenerator = new CsvGenerator();

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

    // Assert that nothing has changed
    assertEquals("Comma Replacement", actualCommaReplacement);
    assertTrue(actualConstants.isEmpty());
    assertTrue(actualFields.isEmpty());
    assertTrue(actualIncludeDefaultFields);
    assertTrue(actualIncludeSchemaProperties);
    assertTrue(actualIsQuotedResult);
  }

  /**
   * Method under test: {@link CsvGenerator#_apply(Element)}
   */
  @Test
  void test_apply() {
    // Arrange
    CsvGenerator csvGenerator = new CsvGenerator();

    // Act and Assert
    assertEquals("", csvGenerator._apply(new Edge("Group")));
  }

  /**
   * Method under test: {@link CsvGenerator#_apply(Element)}
   */
  @Test
  void test_apply2() {
    // Arrange
    Neo4jCsvGenerator neo4jCsvGenerator = new Neo4jCsvGenerator();

    // Act and Assert
    assertEquals(",,Group,,", neo4jCsvGenerator._apply(new Edge("Group")));
  }

  /**
   * Method under test: {@link CsvGenerator#_apply(Element)}
   */
  @Test
  void test_apply3() {
    // Arrange
    Neo4jCsvGenerator neo4jCsvGenerator = new Neo4jCsvGenerator();
    neo4jCsvGenerator.addAdditionalFieldsFromSchemaProperties(new LinkedHashMap<>());

    // Act and Assert
    assertEquals(",Group,,,", neo4jCsvGenerator._apply(new Entity("Group")));
  }

  /**
   * Method under test: {@link CsvGenerator#getHeader()}
   */
  @Test
  void testGetHeader() {
    // Arrange, Act and Assert
    assertEquals("", (new CsvGenerator()).getHeader());
    assertEquals("_id,_labels,_type,_start,_end", (new Neo4jCsvGenerator()).getHeader());
  }

  /**
   * Method under test: {@link CsvGenerator#getHeader()}
   */
  @Test
  void testGetHeader2() {
    // Arrange
    Neo4jCsvGenerator neo4jCsvGenerator = new Neo4jCsvGenerator();
    neo4jCsvGenerator.setQuoted(true);

    // Act and Assert
    assertEquals("\"_id\",\"_labels\",\"_type\",\"_start\",\"_end\"", neo4jCsvGenerator.getHeader());
  }

  /**
   * Method under test: {@link CsvGenerator#getHeader()}
   */
  @Test
  void testGetHeader3() {
    // Arrange
    LinkedHashMap<String, String> fields = new LinkedHashMap<>();
    fields.put("foo", "foo");

    CsvGenerator csvGenerator = new CsvGenerator();
    csvGenerator.setFields(fields);

    // Act and Assert
    assertEquals("foo", csvGenerator.getHeader());
  }

  /**
   * Method under test: {@link CsvGenerator#getHeader()}
   */
  @Test
  void testGetHeader4() {
    // Arrange
    LinkedHashMap<String, String> fields = new LinkedHashMap<>();
    fields.replaceAll(mock(BiFunction.class));
    fields.put("foo", "foo");

    CsvGenerator csvGenerator = new CsvGenerator();
    csvGenerator.setFields(fields);

    // Act and Assert
    assertEquals("foo", csvGenerator.getHeader());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link CsvGenerator}
   */
  @Test
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
    assertTrue(actualCsvGenerator.getConstants().isEmpty());
    assertTrue(actualCsvGenerator.getFields().isEmpty());
    assertEquals(MapGenerator.GROUP, defaultFields.get(MapGenerator.GROUP));
  }
}
