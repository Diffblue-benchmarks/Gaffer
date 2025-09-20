package uk.gov.gchq.gaffer.data.generator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.ArrayList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class OpenCypherCsvElementGeneratorDiffblueTest {
  /**
   * Test {@link OpenCypherCsvElementGenerator#apply(Iterable)} with {@code Iterable}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.
   *   <li>Then return not iterator hasNext.
   * </ul>
   *
   * <p>Method under test: {@link OpenCypherCsvElementGenerator#apply(Iterable)}
   */
  @Test
  @DisplayName(
      "Test apply(Iterable) with 'Iterable'; given '42'; when ArrayList() add '42'; then return not iterator hasNext")
  @Tag("MaintainedByDiffblue")
  void testApplyWithIterable_given42_whenArrayListAdd42_thenReturnNotIteratorHasNext() {
    // Arrange
    Neo4jCsvElementGenerator neo4jCsvElementGenerator = new Neo4jCsvElementGenerator();

    ArrayList<String> strings = new ArrayList<>();
    strings.add("42");
    strings.add("foo");

    // Act and Assert
    assertFalse(neo4jCsvElementGenerator.apply(strings).iterator().hasNext());
  }

  /**
   * Test {@link OpenCypherCsvElementGenerator#apply(Iterable)} with {@code Iterable}.
   *
   * <ul>
   *   <li>Given {@link Neo4jCsvElementGenerator} (default constructor) Trim is {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link OpenCypherCsvElementGenerator#apply(Iterable)}
   */
  @Test
  @DisplayName(
      "Test apply(Iterable) with 'Iterable'; given Neo4jCsvElementGenerator (default constructor) Trim is 'true'")
  @Tag("MaintainedByDiffblue")
  void testApplyWithIterable_givenNeo4jCsvElementGeneratorTrimIsTrue() {
    // Arrange
    Neo4jCsvElementGenerator neo4jCsvElementGenerator = new Neo4jCsvElementGenerator();
    neo4jCsvElementGenerator.setTrim(true);

    ArrayList<String> strings = new ArrayList<>();
    strings.add("foo");

    // Act and Assert
    assertFalse(neo4jCsvElementGenerator.apply(strings).iterator().hasNext());
  }

  /**
   * Test {@link OpenCypherCsvElementGenerator#apply(Iterable)} with {@code Iterable}.
   *
   * <ul>
   *   <li>Given {@link Neo4jCsvElementGenerator} (default constructor).
   *   <li>Then return not iterator hasNext.
   * </ul>
   *
   * <p>Method under test: {@link OpenCypherCsvElementGenerator#apply(Iterable)}
   */
  @Test
  @DisplayName(
      "Test apply(Iterable) with 'Iterable'; given Neo4jCsvElementGenerator (default constructor); then return not iterator hasNext")
  @Tag("MaintainedByDiffblue")
  void testApplyWithIterable_givenNeo4jCsvElementGenerator_thenReturnNotIteratorHasNext() {
    // Arrange
    Neo4jCsvElementGenerator neo4jCsvElementGenerator = new Neo4jCsvElementGenerator();

    ArrayList<String> strings = new ArrayList<>();
    strings.add("foo");

    // Act and Assert
    assertFalse(neo4jCsvElementGenerator.apply(strings).iterator().hasNext());
  }

  /**
   * Test {@link OpenCypherCsvElementGenerator#getFirstRow()}.
   *
   * <p>Method under test: {@link OpenCypherCsvElementGenerator#getFirstRow()}
   */
  @Test
  @DisplayName("Test getFirstRow()")
  @Tag("MaintainedByDiffblue")
  void testGetFirstRow() {
    // Arrange, Act and Assert
    assertEquals(1, new Neo4jCsvElementGenerator().getFirstRow());
  }

  /**
   * Test {@link OpenCypherCsvElementGenerator#getTrim()}.
   *
   * <ul>
   *   <li>Given {@link Neo4jCsvElementGenerator} (default constructor) Trim is {@code true}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link OpenCypherCsvElementGenerator#getTrim()}
   */
  @Test
  @DisplayName(
      "Test getTrim(); given Neo4jCsvElementGenerator (default constructor) Trim is 'true'; then return 'true'")
  @Tag("MaintainedByDiffblue")
  void testGetTrim_givenNeo4jCsvElementGeneratorTrimIsTrue_thenReturnTrue() {
    // Arrange
    Neo4jCsvElementGenerator neo4jCsvElementGenerator = new Neo4jCsvElementGenerator();
    neo4jCsvElementGenerator.setTrim(true);

    // Act and Assert
    assertTrue(neo4jCsvElementGenerator.getTrim());
  }

  /**
   * Test {@link OpenCypherCsvElementGenerator#getTrim()}.
   *
   * <ul>
   *   <li>Given {@link Neo4jCsvElementGenerator} (default constructor).
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link OpenCypherCsvElementGenerator#getTrim()}
   */
  @Test
  @DisplayName(
      "Test getTrim(); given Neo4jCsvElementGenerator (default constructor); then return 'false'")
  @Tag("MaintainedByDiffblue")
  void testGetTrim_givenNeo4jCsvElementGenerator_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new Neo4jCsvElementGenerator().getTrim());
  }

  /**
   * Test {@link OpenCypherCsvElementGenerator#setTrim(Boolean)}.
   *
   * <p>Method under test: {@link OpenCypherCsvElementGenerator#setTrim(Boolean)}
   */
  @Test
  @DisplayName("Test setTrim(Boolean)")
  @Tag("MaintainedByDiffblue")
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
   *
   * <p>Method under test: {@link OpenCypherCsvElementGenerator#getDelimiter()}
   */
  @Test
  @DisplayName("Test getDelimiter()")
  @Tag("MaintainedByDiffblue")
  void testGetDelimiter() {
    // Arrange, Act and Assert
    assertEquals(',', new Neo4jCsvElementGenerator().getDelimiter());
  }

  /**
   * Test {@link OpenCypherCsvElementGenerator#setDelimiter(char)}.
   *
   * <p>Method under test: {@link OpenCypherCsvElementGenerator#setDelimiter(char)}
   */
  @Test
  @DisplayName("Test setDelimiter(char)")
  @Tag("MaintainedByDiffblue")
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
   *
   * <p>Method under test: {@link OpenCypherCsvElementGenerator#getNullString()}
   */
  @Test
  @DisplayName("Test getNullString()")
  @Tag("MaintainedByDiffblue")
  void testGetNullString() {
    // Arrange, Act and Assert
    assertEquals("", new Neo4jCsvElementGenerator().getNullString());
  }

  /**
   * Test {@link OpenCypherCsvElementGenerator#setNullString(String)}.
   *
   * <p>Method under test: {@link OpenCypherCsvElementGenerator#setNullString(String)}
   */
  @Test
  @DisplayName("Test setNullString(String)")
  @Tag("MaintainedByDiffblue")
  void testSetNullString() {
    // Arrange
    Neo4jCsvElementGenerator neo4jCsvElementGenerator = new Neo4jCsvElementGenerator();

    // Act
    neo4jCsvElementGenerator.setNullString("Null String");

    // Assert
    assertEquals("Null String", neo4jCsvElementGenerator.getNullString());
  }
}
