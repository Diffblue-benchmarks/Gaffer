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

package uk.gov.gchq.gaffer.operation.export.graph;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
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
   * <p>
   * Method under test: {@link Builder#graphId(String)}
   */
  @Test
  @DisplayName("Test Builder graphId(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.graphId(String)"})
  void testBuilderGraphId() {
    // Arrange
    Builder builder = new Builder();

    // Act and Assert
    assertSame(builder, builder.graphId("42"));
  }

  /**
   * Test Builder {@link Builder#parentSchemaIds(List)} with {@code List}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#parentSchemaIds(List)}
   */
  @Test
  @DisplayName("Test Builder parentSchemaIds(List) with 'List'; given '42'; when ArrayList() add '42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.parentSchemaIds(List)"})
  void testBuilderParentSchemaIdsWithList_given42_whenArrayListAdd42() {
    // Arrange
    Builder builder = new Builder();

    ArrayList<String> parentSchemaIds = new ArrayList<>();
    parentSchemaIds.add("42");
    parentSchemaIds.add("foo");

    // Act and Assert
    assertSame(builder, builder.parentSchemaIds(parentSchemaIds));
  }

  /**
   * Test Builder {@link Builder#parentSchemaIds(List)} with {@code List}.
   * <ul>
   *   <li>Given {@code foo}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#parentSchemaIds(List)}
   */
  @Test
  @DisplayName("Test Builder parentSchemaIds(List) with 'List'; given 'foo'; when ArrayList() add 'foo'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.parentSchemaIds(List)"})
  void testBuilderParentSchemaIdsWithList_givenFoo_whenArrayListAddFoo() {
    // Arrange
    Builder builder = new Builder();

    ArrayList<String> parentSchemaIds = new ArrayList<>();
    parentSchemaIds.add("foo");

    // Act and Assert
    assertSame(builder, builder.parentSchemaIds(parentSchemaIds));
  }

  /**
   * Test Builder {@link Builder#parentSchemaIds(List)} with {@code List}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#parentSchemaIds(List)}
   */
  @Test
  @DisplayName("Test Builder parentSchemaIds(List) with 'List'; when ArrayList()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.parentSchemaIds(List)"})
  void testBuilderParentSchemaIdsWithList_whenArrayList() {
    // Arrange
    Builder builder = new Builder();

    // Act and Assert
    assertSame(builder, builder.parentSchemaIds(new ArrayList<>()));
  }

  /**
   * Test Builder {@link Builder#parentSchemaIds(String[])} with {@code String[]}.
   * <ul>
   *   <li>When {@code Parent Schema Ids}.</li>
   *   <li>Then return {@link Builder} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#parentSchemaIds(String[])}
   */
  @Test
  @DisplayName("Test Builder parentSchemaIds(String[]) with 'String[]'; when 'Parent Schema Ids'; then return Builder (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.parentSchemaIds(String[])"})
  void testBuilderParentSchemaIdsWithString_whenParentSchemaIds_thenReturnBuilder() {
    // Arrange
    Builder builder = new Builder();

    // Act and Assert
    assertSame(builder, builder.parentSchemaIds("Parent Schema Ids"));
  }

  /**
   * Test Builder {@link Builder#parentStorePropertiesId(String)}.
   * <p>
   * Method under test: {@link Builder#parentStorePropertiesId(String)}
   */
  @Test
  @DisplayName("Test Builder parentStorePropertiesId(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.parentStorePropertiesId(String)"})
  void testBuilderParentStorePropertiesId() {
    // Arrange
    Builder builder = new Builder();

    // Act and Assert
    assertSame(builder, builder.parentStorePropertiesId("42"));
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
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
  @MethodsUnderTest({"void ExportToOtherAuthorisedGraph.<init>()", "String ExportToOtherAuthorisedGraph.getGraphId()",
      "String ExportToOtherAuthorisedGraph.getKey()", "Map ExportToOtherAuthorisedGraph.getOptions()",
      "List ExportToOtherAuthorisedGraph.getParentSchemaIds()",
      "String ExportToOtherAuthorisedGraph.getParentStorePropertiesId()",
      "void ExportToOtherAuthorisedGraph.setGraphId(String)", "void ExportToOtherAuthorisedGraph.setInput(Iterable)",
      "void ExportToOtherAuthorisedGraph.setKey(String)", "void ExportToOtherAuthorisedGraph.setOptions(Map)",
      "void ExportToOtherAuthorisedGraph.setParentSchemaIds(List)",
      "void ExportToOtherAuthorisedGraph.setParentStorePropertiesId(String)"})
  void testGettersAndSetters() {
    // Arrange and Act
    ExportToOtherAuthorisedGraph actualExportToOtherAuthorisedGraph = new ExportToOtherAuthorisedGraph();
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
    String actualParentStorePropertiesId = actualExportToOtherAuthorisedGraph.getParentStorePropertiesId();

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
