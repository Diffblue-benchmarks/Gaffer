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
import java.util.LinkedHashMap;
import org.junit.jupiter.api.Test;

class Neo4jCsvElementGeneratorDiffblueTest {
  /**
   * Method under test: {@link Neo4jCsvElementGenerator#getFields()}
   */
  @Test
  void testGetFields() {
    // Arrange
    Neo4jCsvElementGenerator neo4jCsvElementGenerator = new Neo4jCsvElementGenerator();

    // Act and Assert
    assertEquals(neo4jCsvElementGenerator.fields, neo4jCsvElementGenerator.getFields());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link Neo4jCsvElementGenerator}
   */
  @Test
  void testNewNeo4jCsvElementGenerator() {
    // Arrange and Act
    Neo4jCsvElementGenerator actualNeo4jCsvElementGenerator = new Neo4jCsvElementGenerator();

    // Assert
    assertEquals("", actualNeo4jCsvElementGenerator.getNullString());
    LinkedHashMap<String, String> stringStringMap = actualNeo4jCsvElementGenerator.fields;
    assertEquals(5, stringStringMap.size());
    assertEquals("_end", stringStringMap.get("DESTINATION"));
    assertEquals("_id", stringStringMap.get("VERTEX"));
    assertEquals("_labels", stringStringMap.get("ENTITY_GROUP"));
    assertEquals("_start", stringStringMap.get("SOURCE"));
    assertEquals("_type", stringStringMap.get("EDGE_GROUP"));
    assertEquals(',', actualNeo4jCsvElementGenerator.getDelimiter());
    assertEquals(1, actualNeo4jCsvElementGenerator.getFirstRow());
    assertFalse(actualNeo4jCsvElementGenerator.getTrim());
    LinkedHashMap<String, String> expectedFields = actualNeo4jCsvElementGenerator.fields;
    assertEquals(expectedFields, actualNeo4jCsvElementGenerator.getFields());
  }
}
