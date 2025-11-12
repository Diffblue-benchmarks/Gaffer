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
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

class OpenCypherCsvElementGeneratorDiffblueTest {
  /**
   * Method under test: {@link OpenCypherCsvElementGenerator#getFirstRow()}
   */
  @Test
  void testGetFirstRow() {
    // Arrange, Act and Assert
    assertEquals(1, (new Neo4jCsvElementGenerator()).getFirstRow());
  }

  /**
   * Method under test: {@link OpenCypherCsvElementGenerator#getTrim()}
   */
  @Test
  void testGetTrim() {
    // Arrange, Act and Assert
    assertFalse((new Neo4jCsvElementGenerator()).getTrim());
  }

  /**
   * Method under test: {@link OpenCypherCsvElementGenerator#getTrim()}
   */
  @Test
  void testGetTrim2() {
    // Arrange
    Neo4jCsvElementGenerator neo4jCsvElementGenerator = new Neo4jCsvElementGenerator();
    neo4jCsvElementGenerator.setTrim(true);

    // Act and Assert
    assertTrue(neo4jCsvElementGenerator.getTrim());
  }

  /**
   * Method under test: {@link OpenCypherCsvElementGenerator#setTrim(Boolean)}
   */
  @Test
  void testSetTrim() {
    // Arrange
    Neo4jCsvElementGenerator neo4jCsvElementGenerator = new Neo4jCsvElementGenerator();

    // Act
    neo4jCsvElementGenerator.setTrim(true);

    // Assert
    assertTrue(neo4jCsvElementGenerator.getTrim());
  }

  /**
   * Method under test: {@link OpenCypherCsvElementGenerator#getDelimiter()}
   */
  @Test
  void testGetDelimiter() {
    // Arrange, Act and Assert
    assertEquals(',', (new Neo4jCsvElementGenerator()).getDelimiter());
  }

  /**
   * Method under test: {@link OpenCypherCsvElementGenerator#setDelimiter(char)}
   */
  @Test
  void testSetDelimiter() {
    // Arrange
    Neo4jCsvElementGenerator neo4jCsvElementGenerator = new Neo4jCsvElementGenerator();

    // Act
    neo4jCsvElementGenerator.setDelimiter('A');

    // Assert
    assertEquals('A', neo4jCsvElementGenerator.getDelimiter());
  }

  /**
   * Method under test: {@link OpenCypherCsvElementGenerator#getNullString()}
   */
  @Test
  void testGetNullString() {
    // Arrange, Act and Assert
    assertEquals("", (new Neo4jCsvElementGenerator()).getNullString());
  }

  /**
   * Method under test:
   * {@link OpenCypherCsvElementGenerator#setNullString(String)}
   */
  @Test
  void testSetNullString() {
    // Arrange
    Neo4jCsvElementGenerator neo4jCsvElementGenerator = new Neo4jCsvElementGenerator();

    // Act
    neo4jCsvElementGenerator.setNullString("Null String");

    // Assert
    assertEquals("Null String", neo4jCsvElementGenerator.getNullString());
  }
}
