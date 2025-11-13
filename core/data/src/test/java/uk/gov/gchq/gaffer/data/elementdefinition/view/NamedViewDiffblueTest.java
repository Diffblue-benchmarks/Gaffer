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

package uk.gov.gchq.gaffer.data.elementdefinition.view;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.data.elementdefinition.exception.SchemaException;
import uk.gov.gchq.gaffer.data.elementdefinition.view.NamedView.BaseBuilder;
import uk.gov.gchq.gaffer.data.elementdefinition.view.NamedView.Builder;

class NamedViewDiffblueTest {
  /**
   * Test BaseBuilder {@link BaseBuilder#json(Path[])} with {@code filePaths}.
   * <ul>
   *   <li>Then return {@link Builder#Builder()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseBuilder#json(Path[])}
   */
  @Test
  @DisplayName("Test BaseBuilder json(Path[]) with 'filePaths'; then return Builder()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"BaseBuilder BaseBuilder.json(Path[])"})
  void testBaseBuilderJsonWithFilePaths_thenReturnBuilder() throws SchemaException {
    // Arrange
    Builder builder = new Builder();
    Paths.get(System.getProperty("java.io.tmpdir"), "test.txt");

    // Act and Assert
    assertSame(builder, builder.json(new Path[]{}));
  }

  /**
   * Test BaseBuilder {@link BaseBuilder#json(byte[][])} with {@code jsonBytes}.
   * <ul>
   *   <li>Then return {@link Builder#Builder()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseBuilder#json(byte[][])}
   */
  @Test
  @DisplayName("Test BaseBuilder json(byte[][]) with 'jsonBytes'; then return Builder()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"BaseBuilder BaseBuilder.json(byte[][])"})
  void testBaseBuilderJsonWithJsonBytes_thenReturnBuilder() throws SchemaException {
    // Arrange
    Builder builder = new Builder();

    // Act and Assert
    assertSame(builder, builder.json(new byte[][]{}));
  }

  /**
   * Test BaseBuilder {@link BaseBuilder#merge(View)} with {@code View}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseBuilder#merge(View)}
   */
  @Test
  @DisplayName("Test BaseBuilder merge(View) with 'View'; given ArrayList() add 'foo'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"BaseBuilder BaseBuilder.merge(View)"})
  void testBaseBuilderMergeWithView_givenArrayListAddFoo() {
    // Arrange
    Builder builder = new Builder();

    ArrayList<String> mergedNamedViewNames = new ArrayList<>();
    mergedNamedViewNames.add("foo");

    NamedView view = new NamedView();
    view.setMergedNamedViewNames(mergedNamedViewNames);

    // Act and Assert
    assertEquals(view, builder.merge(view).getElementDefs());
  }

  /**
   * Test BaseBuilder {@link BaseBuilder#merge(View)} with {@code View}.
   * <ul>
   *   <li>Then return {@link Builder#Builder(NamedView)} with namedView is {@link NamedView} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseBuilder#merge(View)}
   */
  @Test
  @DisplayName("Test BaseBuilder merge(View) with 'View'; then return Builder(NamedView) with namedView is NamedView (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"BaseBuilder BaseBuilder.merge(View)"})
  void testBaseBuilderMergeWithView_thenReturnBuilderWithNamedViewIsNamedView() {
    // Arrange
    Builder builder = new Builder(new NamedView());

    // Act and Assert
    assertSame(builder, builder.merge(new NamedView()));
  }

  /**
   * Test BaseBuilder {@link BaseBuilder#merge(View)} with {@code View}.
   * <ul>
   *   <li>Then return ElementDefs Edges size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseBuilder#merge(View)}
   */
  @Test
  @DisplayName("Test BaseBuilder merge(View) with 'View'; then return ElementDefs Edges size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"BaseBuilder BaseBuilder.merge(View)"})
  void testBaseBuilderMergeWithView_thenReturnElementDefsEdgesSizeIsOne() {
    // Arrange
    HashMap<String, ViewElementDefinition> edges = new HashMap<>();
    edges.put("foo", new ViewElementDefinition());

    Builder builder = new Builder();
    builder.addEdges(edges);

    // Act and Assert
    NamedView elementDefs = builder.merge(new View()).getElementDefs();
    Map<String, ViewElementDefinition> edges2 = elementDefs.getEdges();
    assertEquals(1, edges2.size());
    Set<String> edgeGroups = elementDefs.getEdgeGroups();
    assertEquals(1, edgeGroups.size());
    assertTrue(edges2.containsKey("foo"));
    assertTrue(elementDefs.hasEdges());
    assertEquals(edgeGroups, elementDefs.getGroups());
  }

  /**
   * Test BaseBuilder {@link BaseBuilder#merge(View)} with {@code View}.
   * <ul>
   *   <li>When {@link NamedView} (default constructor).</li>
   *   <li>Then return ElementDefs is {@link NamedView} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseBuilder#merge(View)}
   */
  @Test
  @DisplayName("Test BaseBuilder merge(View) with 'View'; when NamedView (default constructor); then return ElementDefs is NamedView (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"BaseBuilder BaseBuilder.merge(View)"})
  void testBaseBuilderMergeWithView_whenNamedView_thenReturnElementDefsIsNamedView() {
    // Arrange
    Builder builder = new Builder();
    NamedView view = new NamedView();

    // Act and Assert
    assertEquals(view, builder.merge(view).getElementDefs());
  }

  /**
   * Test BaseBuilder {@link BaseBuilder#name(String)}.
   * <ul>
   *   <li>Given {@link Builder#Builder()}.</li>
   *   <li>Then return {@link Builder#Builder()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseBuilder#name(String)}
   */
  @Test
  @DisplayName("Test BaseBuilder name(String); given Builder(); then return Builder()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"BaseBuilder BaseBuilder.name(String)"})
  void testBaseBuilderName_givenBuilder_thenReturnBuilder() {
    // Arrange
    Builder builder = new Builder();

    // Act and Assert
    assertSame(builder, builder.name("Name"));
  }

  /**
   * Test BaseBuilder {@link BaseBuilder#parameters(Map)}.
   * <ul>
   *   <li>Given {@link Builder#Builder()}.</li>
   *   <li>Then return {@link Builder#Builder()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseBuilder#parameters(Map)}
   */
  @Test
  @DisplayName("Test BaseBuilder parameters(Map); given Builder(); then return Builder()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"BaseBuilder BaseBuilder.parameters(Map)"})
  void testBaseBuilderParameters_givenBuilder_thenReturnBuilder() {
    // Arrange
    Builder builder = new Builder();

    // Act and Assert
    assertSame(builder, builder.parameters(new HashMap<>()));
  }

  /**
   * Test Builder {@link Builder#self()}.
   * <p>
   * Method under test: {@link Builder#self()}
   */
  @Test
  @DisplayName("Test Builder self()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.self()"})
  void testBuilderSelf() {
    // Arrange
    Builder builder = new Builder();

    // Act and Assert
    assertSame(builder, builder.self());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link NamedView}
   *   <li>{@link NamedView#setName(String)}
   *   <li>{@link NamedView#expandGlobalDefinitions()}
   *   <li>{@link NamedView#getMergedNamedViewNames()}
   *   <li>{@link NamedView#getName()}
   *   <li>{@link NamedView#getParameters()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void NamedView.<init>()", "void NamedView.expandGlobalDefinitions()",
      "List NamedView.getMergedNamedViewNames()", "String NamedView.getName()", "Map NamedView.getParameters()",
      "void NamedView.setName(String)"})
  void testGettersAndSetters() {
    // Arrange and Act
    NamedView actualNamedView = new NamedView();
    actualNamedView.setName("View Name");
    actualNamedView.expandGlobalDefinitions();
    List<String> actualMergedNamedViewNames = actualNamedView.getMergedNamedViewNames();
    String actualName = actualNamedView.getName();
    Map<String, Object> actualParameters = actualNamedView.getParameters();

    // Assert
    assertEquals("View Name", actualName);
    assertNull(actualNamedView.getGlobalEdges());
    assertNull(actualNamedView.getGlobalElements());
    assertNull(actualNamedView.getGlobalEntities());
    assertFalse(actualNamedView.isAllEdges());
    assertFalse(actualNamedView.isAllEntities());
    assertTrue(actualMergedNamedViewNames.isEmpty());
    assertTrue(actualNamedView.getEdges().isEmpty());
    assertTrue(actualNamedView.getEntities().isEmpty());
    assertTrue(actualParameters.isEmpty());
    assertTrue(actualNamedView.getConfig().isEmpty());
  }

  /**
   * Test {@link NamedView#setMergedNamedViewNames(List)}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link NamedView#setMergedNamedViewNames(List)}
   */
  @Test
  @DisplayName("Test setMergedNamedViewNames(List); given '42'; when ArrayList() add '42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void NamedView.setMergedNamedViewNames(List)"})
  void testSetMergedNamedViewNames_given42_whenArrayListAdd42() {
    // Arrange
    NamedView namedView = new NamedView();

    ArrayList<String> mergedNamedViewNames = new ArrayList<>();
    mergedNamedViewNames.add("42");
    mergedNamedViewNames.add("foo");

    // Act
    namedView.setMergedNamedViewNames(mergedNamedViewNames);

    // Assert
    assertEquals(mergedNamedViewNames, namedView.getMergedNamedViewNames());
  }

  /**
   * Test {@link NamedView#setMergedNamedViewNames(List)}.
   * <ul>
   *   <li>Given {@link NamedView} (default constructor) MergedNamedViewNames is {@code null}.</li>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link NamedView#setMergedNamedViewNames(List)}
   */
  @Test
  @DisplayName("Test setMergedNamedViewNames(List); given NamedView (default constructor) MergedNamedViewNames is 'null'; when 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void NamedView.setMergedNamedViewNames(List)"})
  void testSetMergedNamedViewNames_givenNamedViewMergedNamedViewNamesIsNull_whenNull() {
    // Arrange
    NamedView namedView = new NamedView();
    namedView.setMergedNamedViewNames(null);

    // Act
    namedView.setMergedNamedViewNames(null);

    // Assert that nothing has changed
    assertTrue(namedView.getMergedNamedViewNames().isEmpty());
  }

  /**
   * Test {@link NamedView#setMergedNamedViewNames(List)}.
   * <ul>
   *   <li>Then {@link NamedView} (default constructor) MergedNamedViewNames is {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link NamedView#setMergedNamedViewNames(List)}
   */
  @Test
  @DisplayName("Test setMergedNamedViewNames(List); then NamedView (default constructor) MergedNamedViewNames is ArrayList()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void NamedView.setMergedNamedViewNames(List)"})
  void testSetMergedNamedViewNames_thenNamedViewMergedNamedViewNamesIsArrayList() {
    // Arrange
    NamedView namedView = new NamedView();

    ArrayList<String> mergedNamedViewNames = new ArrayList<>();
    mergedNamedViewNames.add("foo");

    // Act
    namedView.setMergedNamedViewNames(mergedNamedViewNames);

    // Assert
    assertEquals(mergedNamedViewNames, namedView.getMergedNamedViewNames());
  }

  /**
   * Test {@link NamedView#setMergedNamedViewNames(List)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then {@link NamedView} (default constructor) MergedNamedViewNames Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link NamedView#setMergedNamedViewNames(List)}
   */
  @Test
  @DisplayName("Test setMergedNamedViewNames(List); when ArrayList(); then NamedView (default constructor) MergedNamedViewNames Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void NamedView.setMergedNamedViewNames(List)"})
  void testSetMergedNamedViewNames_whenArrayList_thenNamedViewMergedNamedViewNamesEmpty() {
    // Arrange
    NamedView namedView = new NamedView();

    // Act
    namedView.setMergedNamedViewNames(new ArrayList<>());

    // Assert that nothing has changed
    assertTrue(namedView.getMergedNamedViewNames().isEmpty());
  }

  /**
   * Test {@link NamedView#canMerge(View, View)}.
   * <ul>
   *   <li>Given {@code Adding View}.</li>
   *   <li>When {@link NamedView} (default constructor) Name is {@code Adding View}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link NamedView#canMerge(View, View)}
   */
  @Test
  @DisplayName("Test canMerge(View, View); given 'Adding View'; when NamedView (default constructor) Name is 'Adding View'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean NamedView.canMerge(View, View)"})
  void testCanMerge_givenAddingView_whenNamedViewNameIsAddingView_thenReturnFalse() {
    // Arrange
    NamedView namedView = new NamedView();

    NamedView addingView = new NamedView();
    addingView.setName("Adding View");

    // Act and Assert
    assertFalse(namedView.canMerge(addingView, new View()));
  }

  /**
   * Test {@link NamedView#canMerge(View, View)}.
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>When {@link NamedView} (default constructor) Name is {@code null}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link NamedView#canMerge(View, View)}
   */
  @Test
  @DisplayName("Test canMerge(View, View); given 'null'; when NamedView (default constructor) Name is 'null'; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean NamedView.canMerge(View, View)"})
  void testCanMerge_givenNull_whenNamedViewNameIsNull_thenReturnTrue() {
    // Arrange
    NamedView namedView = new NamedView();

    NamedView addingView = new NamedView();
    addingView.setName(null);

    // Act and Assert
    assertTrue(namedView.canMerge(addingView, new NamedView()));
  }

  /**
   * Test {@link NamedView#canMerge(View, View)}.
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>When {@link NamedView} (default constructor) Name is {@code null}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link NamedView#canMerge(View, View)}
   */
  @Test
  @DisplayName("Test canMerge(View, View); given 'null'; when NamedView (default constructor) Name is 'null'; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean NamedView.canMerge(View, View)"})
  void testCanMerge_givenNull_whenNamedViewNameIsNull_thenReturnTrue2() {
    // Arrange
    NamedView namedView = new NamedView();

    NamedView addingView = new NamedView();
    addingView.setName(null);

    // Act and Assert
    assertTrue(namedView.canMerge(addingView, new View()));
  }

  /**
   * Test {@link NamedView#canMerge(View, View)}.
   * <ul>
   *   <li>When {@link NamedView} (default constructor).</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link NamedView#canMerge(View, View)}
   */
  @Test
  @DisplayName("Test canMerge(View, View); when NamedView (default constructor); then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean NamedView.canMerge(View, View)"})
  void testCanMerge_whenNamedView_thenReturnTrue() {
    // Arrange
    NamedView namedView = new NamedView();
    NamedView addingView = new NamedView();

    // Act and Assert
    assertTrue(namedView.canMerge(addingView, new View()));
  }

  /**
   * Test {@link NamedView#canMerge(View, View)}.
   * <ul>
   *   <li>When {@link View} (default constructor).</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link NamedView#canMerge(View, View)}
   */
  @Test
  @DisplayName("Test canMerge(View, View); when View (default constructor); then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean NamedView.canMerge(View, View)"})
  void testCanMerge_whenView_thenReturnTrue() {
    // Arrange
    NamedView namedView = new NamedView();
    View addingView = new View();

    // Act and Assert
    assertTrue(namedView.canMerge(addingView, new View()));
  }
}
