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
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.data.element.Element;

class ExportToOtherAuthorisedGraphDiffblueTest {
  /**
   * Method under test:
   * {@link ExportToOtherAuthorisedGraph.Builder#graphId(String)}
   */
  @Test
  void testBuilderGraphId() {
    // Arrange
    ExportToOtherAuthorisedGraph.Builder builder = new ExportToOtherAuthorisedGraph.Builder();

    // Act and Assert
    assertSame(builder, builder.graphId("42"));
  }

  /**
   * Method under test:
   * {@link ExportToOtherAuthorisedGraph.Builder#parentSchemaIds(List)}
   */
  @Test
  void testBuilderParentSchemaIds() {
    // Arrange
    ExportToOtherAuthorisedGraph.Builder builder = new ExportToOtherAuthorisedGraph.Builder();

    // Act and Assert
    assertSame(builder, builder.parentSchemaIds(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ExportToOtherAuthorisedGraph.Builder#parentSchemaIds(List)}
   */
  @Test
  void testBuilderParentSchemaIds2() {
    // Arrange
    ExportToOtherAuthorisedGraph.Builder builder = new ExportToOtherAuthorisedGraph.Builder();

    ArrayList<String> parentSchemaIds = new ArrayList<>();
    parentSchemaIds.add("foo");

    // Act and Assert
    assertSame(builder, builder.parentSchemaIds(parentSchemaIds));
  }

  /**
   * Method under test:
   * {@link ExportToOtherAuthorisedGraph.Builder#parentSchemaIds(List)}
   */
  @Test
  void testBuilderParentSchemaIds3() {
    // Arrange
    ExportToOtherAuthorisedGraph.Builder builder = new ExportToOtherAuthorisedGraph.Builder();

    ArrayList<String> parentSchemaIds = new ArrayList<>();
    parentSchemaIds.add("42");
    parentSchemaIds.add("foo");

    // Act and Assert
    assertSame(builder, builder.parentSchemaIds(parentSchemaIds));
  }

  /**
   * Method under test:
   * {@link ExportToOtherAuthorisedGraph.Builder#parentSchemaIds(String[])}
   */
  @Test
  void testBuilderParentSchemaIds4() {
    // Arrange
    ExportToOtherAuthorisedGraph.Builder builder = new ExportToOtherAuthorisedGraph.Builder();

    // Act and Assert
    assertSame(builder, builder.parentSchemaIds("Parent Schema Ids"));
  }

  /**
   * Method under test:
   * {@link ExportToOtherAuthorisedGraph.Builder#parentStorePropertiesId(String)}
   */
  @Test
  void testBuilderParentStorePropertiesId() {
    // Arrange
    ExportToOtherAuthorisedGraph.Builder builder = new ExportToOtherAuthorisedGraph.Builder();

    // Act and Assert
    assertSame(builder, builder.parentStorePropertiesId("42"));
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of
   * {@link ExportToOtherAuthorisedGraph}
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
    actualExportToOtherAuthorisedGraph.getKey();
    Map<String, String> actualOptions = actualExportToOtherAuthorisedGraph.getOptions();
    List<String> actualParentSchemaIds = actualExportToOtherAuthorisedGraph.getParentSchemaIds();
    String actualParentStorePropertiesId = actualExportToOtherAuthorisedGraph.getParentStorePropertiesId();

    // Assert that nothing has changed
    Iterable<? extends Element> input2 = actualExportToOtherAuthorisedGraph.getInput();
    assertTrue(input2 instanceof List);
    assertEquals("42", actualGraphId);
    assertEquals("42", actualParentStorePropertiesId);
    assertTrue(actualParentSchemaIds.isEmpty());
    assertTrue(actualOptions.isEmpty());
    assertSame(input, input2);
    assertSame(parentSchemaIds, actualParentSchemaIds);
    assertSame(options, actualOptions);
  }
}
