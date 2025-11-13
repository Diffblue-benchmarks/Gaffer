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
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class OpenCypherCsvElementGeneratorDiffblueTest {
  /**
   * Test {@link OpenCypherCsvElementGenerator#getFirstRow()}.
   * <p>
   * Method under test: {@link OpenCypherCsvElementGenerator#getFirstRow()}
   */
  @Test
  @DisplayName("Test getFirstRow()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int OpenCypherCsvElementGenerator.getFirstRow()"})
  void testGetFirstRow() {
    // Arrange, Act and Assert
    assertEquals(1, (new Neo4jCsvElementGenerator()).getFirstRow());
  }

  /**
   * Test {@link OpenCypherCsvElementGenerator#getTrim()}.
   * <ul>
   *   <li>Given {@link Neo4jCsvElementGenerator} (default constructor) Trim is {@code true}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OpenCypherCsvElementGenerator#getTrim()}
   */
  @Test
  @DisplayName("Test getTrim(); given Neo4jCsvElementGenerator (default constructor) Trim is 'true'; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Boolean OpenCypherCsvElementGenerator.getTrim()"})
  void testGetTrim_givenNeo4jCsvElementGeneratorTrimIsTrue_thenReturnTrue() {
    // Arrange
    Neo4jCsvElementGenerator neo4jCsvElementGenerator = new Neo4jCsvElementGenerator();
    neo4jCsvElementGenerator.setTrim(true);

    // Act and Assert
    assertTrue(neo4jCsvElementGenerator.getTrim());
  }

  /**
   * Test {@link OpenCypherCsvElementGenerator#getTrim()}.
   * <ul>
   *   <li>Given {@link Neo4jCsvElementGenerator} (default constructor).</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OpenCypherCsvElementGenerator#getTrim()}
   */
  @Test
  @DisplayName("Test getTrim(); given Neo4jCsvElementGenerator (default constructor); then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Boolean OpenCypherCsvElementGenerator.getTrim()"})
  void testGetTrim_givenNeo4jCsvElementGenerator_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new Neo4jCsvElementGenerator()).getTrim());
  }

  /**
   * Test {@link OpenCypherCsvElementGenerator#setTrim(Boolean)}.
   * <p>
   * Method under test: {@link OpenCypherCsvElementGenerator#setTrim(Boolean)}
   */
  @Test
  @DisplayName("Test setTrim(Boolean)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void OpenCypherCsvElementGenerator.setTrim(Boolean)"})
  void testSetTrim() {
    // Arrange
    Neo4jCsvElementGenerator neo4jCsvElementGenerator = new Neo4jCsvElementGenerator();

    // Act
    neo4jCsvElementGenerator.setTrim(true);

    // Assert
    assertTrue(neo4jCsvElementGenerator.getTrim());
  }

  /**
   * Test {@link OpenCypherCsvElementGenerator#getDelimiter()}.
   * <p>
   * Method under test: {@link OpenCypherCsvElementGenerator#getDelimiter()}
   */
  @Test
  @DisplayName("Test getDelimiter()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"char OpenCypherCsvElementGenerator.getDelimiter()"})
  void testGetDelimiter() {
    // Arrange, Act and Assert
    assertEquals(',', (new Neo4jCsvElementGenerator()).getDelimiter());
  }

  /**
   * Test {@link OpenCypherCsvElementGenerator#setDelimiter(char)}.
   * <p>
   * Method under test: {@link OpenCypherCsvElementGenerator#setDelimiter(char)}
   */
  @Test
  @DisplayName("Test setDelimiter(char)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void OpenCypherCsvElementGenerator.setDelimiter(char)"})
  void testSetDelimiter() {
    // Arrange
    Neo4jCsvElementGenerator neo4jCsvElementGenerator = new Neo4jCsvElementGenerator();

    // Act
    neo4jCsvElementGenerator.setDelimiter('A');

    // Assert
    assertEquals('A', neo4jCsvElementGenerator.getDelimiter());
  }

  /**
   * Test {@link OpenCypherCsvElementGenerator#getNullString()}.
   * <p>
   * Method under test: {@link OpenCypherCsvElementGenerator#getNullString()}
   */
  @Test
  @DisplayName("Test getNullString()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String OpenCypherCsvElementGenerator.getNullString()"})
  void testGetNullString() {
    // Arrange, Act and Assert
    assertEquals("", (new Neo4jCsvElementGenerator()).getNullString());
  }

  /**
   * Test {@link OpenCypherCsvElementGenerator#setNullString(String)}.
   * <p>
   * Method under test: {@link OpenCypherCsvElementGenerator#setNullString(String)}
   */
  @Test
  @DisplayName("Test setNullString(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void OpenCypherCsvElementGenerator.setNullString(String)"})
  void testSetNullString() {
    // Arrange
    Neo4jCsvElementGenerator neo4jCsvElementGenerator = new Neo4jCsvElementGenerator();

    // Act
    neo4jCsvElementGenerator.setNullString("Null String");

    // Assert
    assertEquals("Null String", neo4jCsvElementGenerator.getNullString());
  }
}
