package uk.gov.gchq.gaffer.operation.export.graph;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.data.element.Element;
import uk.gov.gchq.gaffer.operation.export.graph.ExportToOtherAuthorisedGraph.Builder;

class ExportToOtherAuthorisedGraphDiffblueTest {
  /**
   * Test Builder {@link Builder#graphId(String)}.
   *
   * <p>Method under test: {@link Builder#graphId(String)}
   */
  @Test
  @DisplayName("Test Builder graphId(String)")
  @Tag("MaintainedByDiffblue")
  void testBuilderGraphId() {
    // Arrange
    Builder builder = new Builder();

    // Act
    Builder actualGraphIdResult = builder.graphId("42");

    // Assert
    assertSame(builder, actualGraphIdResult);
  }

  /**
   * Test Builder {@link Builder#parentSchemaIds(List)} with {@code List}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#parentSchemaIds(List)}
   */
  @Test
  @DisplayName(
      "Test Builder parentSchemaIds(List) with 'List'; given '42'; when ArrayList() add '42'")
  @Tag("MaintainedByDiffblue")
  void testBuilderParentSchemaIdsWithList_given42_whenArrayListAdd42() {
    // Arrange
    Builder builder = new Builder();

    ArrayList<String> parentSchemaIds = new ArrayList<>();
    parentSchemaIds.add("42");
    parentSchemaIds.add("foo");

    // Act
    Builder actualParentSchemaIdsResult = builder.parentSchemaIds(parentSchemaIds);

    // Assert
    assertSame(builder, actualParentSchemaIdsResult);
  }

  /**
   * Test Builder {@link Builder#parentSchemaIds(List)} with {@code List}.
   *
   * <ul>
   *   <li>Given {@code foo}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code foo}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#parentSchemaIds(List)}
   */
  @Test
  @DisplayName(
      "Test Builder parentSchemaIds(List) with 'List'; given 'foo'; when ArrayList() add 'foo'")
  @Tag("MaintainedByDiffblue")
  void testBuilderParentSchemaIdsWithList_givenFoo_whenArrayListAddFoo() {
    // Arrange
    Builder builder = new Builder();

    ArrayList<String> parentSchemaIds = new ArrayList<>();
    parentSchemaIds.add("foo");

    // Act
    Builder actualParentSchemaIdsResult = builder.parentSchemaIds(parentSchemaIds);

    // Assert
    assertSame(builder, actualParentSchemaIdsResult);
  }

  /**
   * Test Builder {@link Builder#parentSchemaIds(List)} with {@code List}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#parentSchemaIds(List)}
   */
  @Test
  @DisplayName("Test Builder parentSchemaIds(List) with 'List'; when ArrayList()")
  @Tag("MaintainedByDiffblue")
  void testBuilderParentSchemaIdsWithList_whenArrayList() {
    // Arrange
    Builder builder = new Builder();

    // Act
    Builder actualParentSchemaIdsResult = builder.parentSchemaIds(new ArrayList<>());

    // Assert
    assertSame(builder, actualParentSchemaIdsResult);
  }

  /**
   * Test Builder {@link Builder#parentSchemaIds(String[])} with {@code String[]}.
   *
   * <ul>
   *   <li>When {@code Parent Schema Ids}.
   *   <li>Then return {@link Builder} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link Builder#parentSchemaIds(String[])}
   */
  @Test
  @DisplayName(
      "Test Builder parentSchemaIds(String[]) with 'String[]'; when 'Parent Schema Ids'; then return Builder (default constructor)")
  @Tag("MaintainedByDiffblue")
  void testBuilderParentSchemaIdsWithString_whenParentSchemaIds_thenReturnBuilder() {
    // Arrange
    Builder builder = new Builder();

    // Act
    Builder actualParentSchemaIdsResult = builder.parentSchemaIds("Parent Schema Ids");

    // Assert
    assertSame(builder, actualParentSchemaIdsResult);
  }

  /**
   * Test Builder {@link Builder#parentStorePropertiesId(String)}.
   *
   * <p>Method under test: {@link Builder#parentStorePropertiesId(String)}
   */
  @Test
  @DisplayName("Test Builder parentStorePropertiesId(String)")
  @Tag("MaintainedByDiffblue")
  void testBuilderParentStorePropertiesId() {
    // Arrange
    Builder builder = new Builder();

    // Act
    Builder actualParentStorePropertiesIdResult = builder.parentStorePropertiesId("42");

    // Assert
    assertSame(builder, actualParentStorePropertiesIdResult);
  }

  /**
   * Test {@link ExportToOtherAuthorisedGraph#getInput()}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ExportToOtherAuthorisedGraph#getInput()}
   */
  @Test
  @DisplayName("Test getInput(); then return 'null'")
  @Tag("MaintainedByDiffblue")
  void testGetInput_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new ExportToOtherAuthorisedGraph().getInput());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link ExportToOtherAuthorisedGraph}
   *   <li>{@link ExportToOtherAuthorisedGraph#setGraphId(String)}
   *   <li>{@link ExportToOtherAuthorisedGraph#setInput(Iterable)}
   *   <li>{@link ExportToOtherAuthorisedGraph#setOptions(Map)}
   *   <li>{@link ExportToOtherAuthorisedGraph#setParentSchemaIds(List)}
   *   <li>{@link ExportToOtherAuthorisedGraph#setParentStorePropertiesId(String)}
   *   <li>{@link ExportToOtherAuthorisedGraph#setKey(String)}
   *   <li>{@link ExportToOtherAuthorisedGraph#getGraphId()}
   *   <li>{@link ExportToOtherAuthorisedGraph#getKey()}
   *   <li>{@link ExportToOtherAuthorisedGraph#getOptions()}
   *   <li>{@link ExportToOtherAuthorisedGraph#getParentSchemaIds()}
   *   <li>{@link ExportToOtherAuthorisedGraph#getParentStorePropertiesId()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  void testGettersAndSetters() {
    // Arrange and Act
    ExportToOtherAuthorisedGraph actualExportToOtherAuthorisedGraph =
        new ExportToOtherAuthorisedGraph();
    actualExportToOtherAuthorisedGraph.setGraphId("42");
    ArrayList<Element> input = new ArrayList<>();
    actualExportToOtherAuthorisedGraph.setInput(input);
    HashMap<String, String> options = new HashMap<>();
    actualExportToOtherAuthorisedGraph.setOptions(options);
    ArrayList<String> parentSchemaIds = new ArrayList<>();
    actualExportToOtherAuthorisedGraph.setParentSchemaIds(parentSchemaIds);
    actualExportToOtherAuthorisedGraph.setParentStorePropertiesId("42");
    actualExportToOtherAuthorisedGraph.setKey("Key");
    String actualGraphId = actualExportToOtherAuthorisedGraph.getGraphId();
    String actualKey = actualExportToOtherAuthorisedGraph.getKey();
    Map<String, String> actualOptions = actualExportToOtherAuthorisedGraph.getOptions();
    List<String> actualParentSchemaIds = actualExportToOtherAuthorisedGraph.getParentSchemaIds();
    String actualParentStorePropertiesId =
        actualExportToOtherAuthorisedGraph.getParentStorePropertiesId();

    // Assert
    Iterable<? extends Element> input2 = actualExportToOtherAuthorisedGraph.getInput();
    assertTrue(input2 instanceof List);
    assertEquals("42", actualGraphId);
    assertEquals("42", actualParentStorePropertiesId);
    assertNull(actualKey);
    assertTrue(actualParentSchemaIds.isEmpty());
    assertTrue(actualOptions.isEmpty());
    assertSame(input, input2);
    assertSame(parentSchemaIds, actualParentSchemaIds);
    assertSame(options, actualOptions);
  }
}
