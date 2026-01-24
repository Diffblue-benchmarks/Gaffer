/*
 * Copyright 2026 Crown Copyright
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
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.LinkedHashMap;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class Neo4jCsvGeneratorDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Neo4jCsvGenerator#getFields()}
   *   <li>{@link Neo4jCsvGenerator#getIncludeDefaultFields()}
   *   <li>{@link Neo4jCsvGenerator#getIncludeSchemaProperties()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "LinkedHashMap Neo4jCsvGenerator.getFields()",
    "boolean Neo4jCsvGenerator.getIncludeDefaultFields()",
    "boolean Neo4jCsvGenerator.getIncludeSchemaProperties()"
  })
  void testGettersAndSetters() {
    // Arrange
    Neo4jCsvGenerator neo4jCsvGenerator = new Neo4jCsvGenerator();

    // Act
    LinkedHashMap<String, String> actualFields = neo4jCsvGenerator.getFields();
    boolean actualIncludeDefaultFields = neo4jCsvGenerator.getIncludeDefaultFields();

    // Assert
    assertEquals(5, actualFields.size());
    assertEquals("_end", actualFields.get("DESTINATION"));
    assertEquals("_id", actualFields.get("VERTEX"));
    assertEquals("_labels", actualFields.get("ENTITY_GROUP"));
    assertEquals("_start", actualFields.get("SOURCE"));
    assertEquals("_type", actualFields.get("EDGE_GROUP"));
    assertTrue(actualIncludeDefaultFields);
    assertTrue(neo4jCsvGenerator.getIncludeSchemaProperties());
  }

  /**
   * Test {@link Neo4jCsvGenerator#getDefaultFields()}.
   *
   * <p>Method under test: {@link Neo4jCsvGenerator#getDefaultFields()}
   */
  @Test
  @DisplayName("Test getDefaultFields()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LinkedHashMap Neo4jCsvGenerator.getDefaultFields()"})
  void testGetDefaultFields() {
    // Arrange and Act
    LinkedHashMap<String, String> actualDefaultFields = new Neo4jCsvGenerator().getDefaultFields();

    // Assert
    assertEquals(5, actualDefaultFields.size());
    assertEquals("_end", actualDefaultFields.get("DESTINATION"));
    assertEquals("_id", actualDefaultFields.get("VERTEX"));
    assertEquals("_labels", actualDefaultFields.get("ENTITY_GROUP"));
    assertEquals("_start", actualDefaultFields.get("SOURCE"));
    assertEquals("_type", actualDefaultFields.get("EDGE_GROUP"));
  }

  /**
   * Test {@link Neo4jCsvGenerator#addAdditionalFieldsFromSchemaProperties(LinkedHashMap)}.
   *
   * <p>Method under test: {@link
   * Neo4jCsvGenerator#addAdditionalFieldsFromSchemaProperties(LinkedHashMap)}
   */
  @Test
  @DisplayName("Test addAdditionalFieldsFromSchemaProperties(LinkedHashMap)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void Neo4jCsvGenerator.addAdditionalFieldsFromSchemaProperties(LinkedHashMap)"
  })
  void testAddAdditionalFieldsFromSchemaProperties() {
    // Arrange
    Neo4jCsvGenerator neo4jCsvGenerator = new Neo4jCsvGenerator();

    // Act
    neo4jCsvGenerator.addAdditionalFieldsFromSchemaProperties(new LinkedHashMap<>());

    // Assert that nothing has changed
    assertEquals("_id,_labels,_type,_start,_end", neo4jCsvGenerator.getHeader());
  }

  /**
   * Test {@link Neo4jCsvGenerator#addAdditionalFieldsFromSchemaProperties(LinkedHashMap)}.
   *
   * <p>Method under test: {@link
   * Neo4jCsvGenerator#addAdditionalFieldsFromSchemaProperties(LinkedHashMap)}
   */
  @Test
  @DisplayName("Test addAdditionalFieldsFromSchemaProperties(LinkedHashMap)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void Neo4jCsvGenerator.addAdditionalFieldsFromSchemaProperties(LinkedHashMap)"
  })
  void testAddAdditionalFieldsFromSchemaProperties2() {
    // Arrange
    NeptuneCsvGenerator neptuneCsvGenerator = new NeptuneCsvGenerator();

    // Act
    neptuneCsvGenerator.addAdditionalFieldsFromSchemaProperties(new LinkedHashMap<>());

    // Assert that nothing has changed
    assertEquals(":ID,:LABEL,:TYPE,:START_ID,:END_ID", neptuneCsvGenerator.getHeader());
  }

  /**
   * Test {@link Neo4jCsvGenerator#addAdditionalFieldsFromSchemaProperties(LinkedHashMap)}.
   *
   * <p>Method under test: {@link
   * Neo4jCsvGenerator#addAdditionalFieldsFromSchemaProperties(LinkedHashMap)}
   */
  @Test
  @DisplayName("Test addAdditionalFieldsFromSchemaProperties(LinkedHashMap)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void Neo4jCsvGenerator.addAdditionalFieldsFromSchemaProperties(LinkedHashMap)"
  })
  void testAddAdditionalFieldsFromSchemaProperties3() {
    // Arrange
    Neo4jCsvGenerator neo4jCsvGenerator = new Neo4jCsvGenerator();

    LinkedHashMap<String, Class<?>> schemaProperties = new LinkedHashMap<>();
    Class<Object> forNameResult = Object.class;
    schemaProperties.put("foo", forNameResult);

    // Act
    neo4jCsvGenerator.addAdditionalFieldsFromSchemaProperties(schemaProperties);

    // Assert
    assertEquals("_id,_labels,_type,_start,_end,foo:String", neo4jCsvGenerator.getHeader());
    LinkedHashMap<String, String> fields = neo4jCsvGenerator.getFields();
    assertEquals(6, fields.size());
    assertEquals("foo:String", fields.get("foo"));
    assertTrue(fields.containsKey("DESTINATION"));
    assertTrue(fields.containsKey("EDGE_GROUP"));
    assertTrue(fields.containsKey("ENTITY_GROUP"));
    assertTrue(fields.containsKey("SOURCE"));
    assertTrue(fields.containsKey("VERTEX"));
  }

  /**
   * Test new {@link Neo4jCsvGenerator} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link Neo4jCsvGenerator}
   */
  @Test
  @DisplayName("Test new Neo4jCsvGenerator (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Neo4jCsvGenerator.<init>()"})
  void testNewNeo4jCsvGenerator() {
    // Arrange and Act
    Neo4jCsvGenerator actualNeo4jCsvGenerator = new Neo4jCsvGenerator();

    // Assert
    assertEquals(" ", actualNeo4jCsvGenerator.getCommaReplacement());
    LinkedHashMap<String, String> defaultFields = actualNeo4jCsvGenerator.getDefaultFields();
    assertEquals(5, defaultFields.size());
    assertEquals("_end", defaultFields.get("DESTINATION"));
    assertEquals("_id", defaultFields.get("VERTEX"));
    assertEquals("_id,_labels,_type,_start,_end", actualNeo4jCsvGenerator.getHeader());
    assertEquals("_labels", defaultFields.get("ENTITY_GROUP"));
    assertEquals("_start", defaultFields.get("SOURCE"));
    assertEquals("_type", defaultFields.get("EDGE_GROUP"));
    assertFalse(actualNeo4jCsvGenerator.isQuoted());
    assertTrue(actualNeo4jCsvGenerator.getConstants().isEmpty());
    assertTrue(actualNeo4jCsvGenerator.getIncludeDefaultFields());
    assertTrue(actualNeo4jCsvGenerator.getIncludeSchemaProperties());
    assertEquals(defaultFields, actualNeo4jCsvGenerator.getFields());
  }
}
