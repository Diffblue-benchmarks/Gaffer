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
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.data.elementdefinition.exception.SchemaException;
import uk.gov.gchq.gaffer.data.elementdefinition.view.NamedView.Builder;
import uk.gov.gchq.gaffer.data.elementdefinition.view.View.BaseBuilder;

class ViewDiffblueTest {
  /**
   * Test BaseBuilder {@link BaseBuilder#allEdges(boolean)}.
   * <p>
   * Method under test: {@link BaseBuilder#allEdges(boolean)}
   */
  @Test
  @DisplayName("Test BaseBuilder allEdges(boolean)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"BaseBuilder BaseBuilder.allEdges(boolean)"})
  void testBaseBuilderAllEdges() {
    // Arrange
    Builder builder = new Builder();

    // Act and Assert
    assertSame(builder, builder.allEdges(true));
  }

  /**
   * Test BaseBuilder {@link BaseBuilder#allEntities(boolean)}.
   * <p>
   * Method under test: {@link BaseBuilder#allEntities(boolean)}
   */
  @Test
  @DisplayName("Test BaseBuilder allEntities(boolean)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"BaseBuilder BaseBuilder.allEntities(boolean)"})
  void testBaseBuilderAllEntities() {
    // Arrange
    Builder builder = new Builder();

    // Act and Assert
    assertSame(builder, builder.allEntities(true));
  }

  /**
   * Test BaseBuilder {@link BaseBuilder#config(Map)} with {@code config}.
   * <ul>
   *   <li>Given {@link Builder#Builder()}.</li>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@link Builder#Builder()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseBuilder#config(Map)}
   */
  @Test
  @DisplayName("Test BaseBuilder config(Map) with 'config'; given Builder(); when 'null'; then return Builder()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"BaseBuilder BaseBuilder.config(Map)"})
  void testBaseBuilderConfigWithConfig_givenBuilder_whenNull_thenReturnBuilder() {
    // Arrange
    Builder builder = new Builder();

    // Act and Assert
    assertSame(builder, builder.config(null));
  }

  /**
   * Test BaseBuilder {@link BaseBuilder#config(String, String)} with {@code key}, {@code value}.
   * <p>
   * Method under test: {@link BaseBuilder#config(String, String)}
   */
  @Test
  @DisplayName("Test BaseBuilder config(String, String) with 'key', 'value'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"BaseBuilder BaseBuilder.config(String, String)"})
  void testBaseBuilderConfigWithKeyValue() {
    // Arrange
    Builder builder = new Builder();

    // Act and Assert
    assertSame(builder, builder.config("Key", "42"));
  }

  /**
   * Test BaseBuilder {@link BaseBuilder#edge(String, ViewElementDefinition)} with {@code group}, {@code edgeDef}.
   * <ul>
   *   <li>Given {@link Builder#Builder()}.</li>
   *   <li>Then return {@link Builder#Builder()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseBuilder#edge(String, ViewElementDefinition)}
   */
  @Test
  @DisplayName("Test BaseBuilder edge(String, ViewElementDefinition) with 'group', 'edgeDef'; given Builder(); then return Builder()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"BaseBuilder BaseBuilder.edge(String, ViewElementDefinition)"})
  void testBaseBuilderEdgeWithGroupEdgeDef_givenBuilder_thenReturnBuilder() {
    // Arrange
    Builder builder = new Builder();

    // Act and Assert
    assertSame(builder, builder.edge("Group", new ViewElementDefinition()));
  }

  /**
   * Test BaseBuilder {@link BaseBuilder#edge(String, ViewElementDefinition)} with {@code group}, {@code edgeDef}.
   * <ul>
   *   <li>Given {@link Builder#Builder()}.</li>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@link Builder#Builder()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseBuilder#edge(String, ViewElementDefinition)}
   */
  @Test
  @DisplayName("Test BaseBuilder edge(String, ViewElementDefinition) with 'group', 'edgeDef'; given Builder(); when 'null'; then return Builder()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"BaseBuilder BaseBuilder.edge(String, ViewElementDefinition)"})
  void testBaseBuilderEdgeWithGroupEdgeDef_givenBuilder_whenNull_thenReturnBuilder() {
    // Arrange
    Builder builder = new Builder();

    // Act and Assert
    assertSame(builder, builder.edge("Group", null));
  }

  /**
   * Test BaseBuilder {@link BaseBuilder#edge(String)} with {@code group}.
   * <ul>
   *   <li>Given {@link Builder#Builder()}.</li>
   *   <li>Then return {@link Builder#Builder()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseBuilder#edge(String)}
   */
  @Test
  @DisplayName("Test BaseBuilder edge(String) with 'group'; given Builder(); then return Builder()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"BaseBuilder BaseBuilder.edge(String)"})
  void testBaseBuilderEdgeWithGroup_givenBuilder_thenReturnBuilder() {
    // Arrange
    Builder builder = new Builder();

    // Act and Assert
    assertSame(builder, builder.edge("Group"));
  }

  /**
   * Test BaseBuilder {@link BaseBuilder#entity(String, ViewElementDefinition)} with {@code group}, {@code entityDef}.
   * <ul>
   *   <li>Given {@link Builder#Builder()}.</li>
   *   <li>Then return {@link Builder#Builder()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseBuilder#entity(String, ViewElementDefinition)}
   */
  @Test
  @DisplayName("Test BaseBuilder entity(String, ViewElementDefinition) with 'group', 'entityDef'; given Builder(); then return Builder()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"BaseBuilder BaseBuilder.entity(String, ViewElementDefinition)"})
  void testBaseBuilderEntityWithGroupEntityDef_givenBuilder_thenReturnBuilder() {
    // Arrange
    Builder builder = new Builder();

    // Act and Assert
    assertSame(builder, builder.entity("Group", new ViewElementDefinition()));
  }

  /**
   * Test BaseBuilder {@link BaseBuilder#entity(String, ViewElementDefinition)} with {@code group}, {@code entityDef}.
   * <ul>
   *   <li>Given {@link Builder#Builder()}.</li>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@link Builder#Builder()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseBuilder#entity(String, ViewElementDefinition)}
   */
  @Test
  @DisplayName("Test BaseBuilder entity(String, ViewElementDefinition) with 'group', 'entityDef'; given Builder(); when 'null'; then return Builder()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"BaseBuilder BaseBuilder.entity(String, ViewElementDefinition)"})
  void testBaseBuilderEntityWithGroupEntityDef_givenBuilder_whenNull_thenReturnBuilder() {
    // Arrange
    Builder builder = new Builder();

    // Act and Assert
    assertSame(builder, builder.entity("Group", null));
  }

  /**
   * Test BaseBuilder {@link BaseBuilder#entity(String)} with {@code group}.
   * <ul>
   *   <li>Given {@link Builder#Builder()}.</li>
   *   <li>Then return {@link Builder#Builder()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseBuilder#entity(String)}
   */
  @Test
  @DisplayName("Test BaseBuilder entity(String) with 'group'; given Builder(); then return Builder()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"BaseBuilder BaseBuilder.entity(String)"})
  void testBaseBuilderEntityWithGroup_givenBuilder_thenReturnBuilder() {
    // Arrange
    Builder builder = new Builder();

    // Act and Assert
    assertSame(builder, builder.entity("Group"));
  }

  /**
   * Test BaseBuilder {@link BaseBuilder#expandGlobalDefinitions()}.
   * <ul>
   *   <li>Given {@link Builder#Builder()}.</li>
   *   <li>Then return {@link Builder#Builder()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseBuilder#expandGlobalDefinitions()}
   */
  @Test
  @DisplayName("Test BaseBuilder expandGlobalDefinitions(); given Builder(); then return Builder()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"BaseBuilder BaseBuilder.expandGlobalDefinitions()"})
  void testBaseBuilderExpandGlobalDefinitions_givenBuilder_thenReturnBuilder() {
    // Arrange
    Builder builder = new Builder();

    // Act and Assert
    assertSame(builder, builder.expandGlobalDefinitions());
  }

  /**
   * Test BaseBuilder {@link BaseBuilder#json(Path[])} with {@code filePaths}.
   * <ul>
   *   <li>Then return {@link View.Builder#Builder()}.</li>
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
    View.Builder builder = new View.Builder();
    Paths.get(System.getProperty("java.io.tmpdir"), "test.txt");

    // Act and Assert
    assertSame(builder, builder.json(new Path[]{}));
  }

  /**
   * Test BaseBuilder {@link BaseBuilder#json(byte[][])} with {@code jsonBytes}.
   * <ul>
   *   <li>Then return {@link View.Builder#Builder()}.</li>
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
    View.Builder builder = new View.Builder();

    // Act and Assert
    assertSame(builder, builder.json(new byte[][]{}));
  }

  /**
   * Test BaseBuilder {@link BaseBuilder#merge(View)} with {@code View}.
   * <ul>
   *   <li>Given {@link View.Builder#Builder()}.</li>
   *   <li>When {@link View} (default constructor).</li>
   *   <li>Then return build is {@link View} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseBuilder#merge(View)}
   */
  @Test
  @DisplayName("Test BaseBuilder merge(View) with 'View'; given Builder(); when View (default constructor); then return build is View (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"BaseBuilder BaseBuilder.merge(View)"})
  void testBaseBuilderMergeWithView_givenBuilder_whenView_thenReturnBuildIsView() {
    // Arrange
    View.Builder builder = new View.Builder();
    View view = new View();

    // Act and Assert
    assertEquals(view, builder.merge(view).build());
  }

  /**
   * Test BaseBuilder {@link BaseBuilder#merge(View)} with {@code View}.
   * <ul>
   *   <li>Given {@code true}.</li>
   *   <li>When {@link View} (default constructor) AllEntities is {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseBuilder#merge(View)}
   */
  @Test
  @DisplayName("Test BaseBuilder merge(View) with 'View'; given 'true'; when View (default constructor) AllEntities is 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"BaseBuilder BaseBuilder.merge(View)"})
  void testBaseBuilderMergeWithView_givenTrue_whenViewAllEntitiesIsTrue() {
    // Arrange
    View.Builder builder = new View.Builder();

    View view = new View();
    view.setAllEntities(true);

    // Act and Assert
    assertEquals(view, builder.merge(view).build());
  }

  /**
   * Test BaseBuilder {@link BaseBuilder#merge(View)} with {@code View}.
   * <ul>
   *   <li>Given {@code View Name}.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseBuilder#merge(View)}
   */
  @Test
  @DisplayName("Test BaseBuilder merge(View) with 'View'; given 'View Name'; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"BaseBuilder BaseBuilder.merge(View)"})
  void testBaseBuilderMergeWithView_givenViewName_thenThrowIllegalArgumentException() {
    // Arrange
    View.Builder builder = new View.Builder();

    NamedView view = new NamedView();
    view.setName("View Name");

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> builder.merge(view));
  }

  /**
   * Test Builder {@link View.Builder#Builder(View)}.
   * <ul>
   *   <li>Given {@code true}.</li>
   *   <li>When {@link View} (default constructor) AllEntities is {@code true}.</li>
   *   <li>Then return build is {@link View} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link View.Builder#Builder(View)}
   */
  @Test
  @DisplayName("Test Builder new Builder(View); given 'true'; when View (default constructor) AllEntities is 'true'; then return build is View (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void View.Builder.<init>(View)"})
  void testBuilderNewBuilder_givenTrue_whenViewAllEntitiesIsTrue_thenReturnBuildIsView() {
    // Arrange
    View view = new View();
    view.setAllEntities(true);

    // Act and Assert
    assertEquals(view, (new View.Builder(view)).build());
  }

  /**
   * Test Builder {@link View.Builder#Builder(View)}.
   * <ul>
   *   <li>When {@link View} (default constructor).</li>
   *   <li>Then return build is {@link View} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link View.Builder#Builder(View)}
   */
  @Test
  @DisplayName("Test Builder new Builder(View); when View (default constructor); then return build is View (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void View.Builder.<init>(View)"})
  void testBuilderNewBuilder_whenView_thenReturnBuildIsView() {
    // Arrange
    View view = new View();

    // Act and Assert
    assertEquals(view, (new View.Builder(view)).build());
  }

  /**
   * Test Builder {@link View.Builder#self()}.
   * <p>
   * Method under test: {@link View.Builder#self()}
   */
  @Test
  @DisplayName("Test Builder self()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"View.Builder View.Builder.self()"})
  void testBuilderSelf() {
    // Arrange
    View.Builder builder = new View.Builder();

    // Act and Assert
    assertSame(builder, builder.self());
  }

  /**
   * Test {@link View#getElement(String)}.
   * <p>
   * Method under test: {@link View#getElement(String)}
   */
  @Test
  @DisplayName("Test getElement(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ViewElementDefinition View.getElement(String)"})
  void testGetElement() {
    // Arrange, Act and Assert
    assertNull((new View()).getElement("Group"));
  }

  /**
   * Test {@link View#getElementGroupBy(String)}.
   * <p>
   * Method under test: {@link View#getElementGroupBy(String)}
   */
  @Test
  @DisplayName("Test getElementGroupBy(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.util.Set View.getElementGroupBy(String)"})
  void testGetElementGroupBy() {
    // Arrange, Act and Assert
    assertNull((new View()).getElementGroupBy("Group"));
  }

  /**
   * Test {@link View#hasPreAggregationFilters()}.
   * <p>
   * Method under test: {@link View#hasPreAggregationFilters()}
   */
  @Test
  @DisplayName("Test hasPreAggregationFilters()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean View.hasPreAggregationFilters()"})
  void testHasPreAggregationFilters() {
    // Arrange, Act and Assert
    assertFalse((new View()).hasPreAggregationFilters());
  }

  /**
   * Test {@link View#hasPostAggregationFilters()}.
   * <p>
   * Method under test: {@link View#hasPostAggregationFilters()}
   */
  @Test
  @DisplayName("Test hasPostAggregationFilters()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean View.hasPostAggregationFilters()"})
  void testHasPostAggregationFilters() {
    // Arrange, Act and Assert
    assertFalse((new View()).hasPostAggregationFilters());
  }

  /**
   * Test {@link View#hasPostTransformFilters()}.
   * <p>
   * Method under test: {@link View#hasPostTransformFilters()}
   */
  @Test
  @DisplayName("Test hasPostTransformFilters()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean View.hasPostTransformFilters()"})
  void testHasPostTransformFilters() {
    // Arrange, Act and Assert
    assertFalse((new View()).hasPostTransformFilters());
  }

  /**
   * Test {@link View#hasTransform()}.
   * <p>
   * Method under test: {@link View#hasTransform()}
   */
  @Test
  @DisplayName("Test hasTransform()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean View.hasTransform()"})
  void testHasTransform() {
    // Arrange, Act and Assert
    assertFalse((new View()).hasTransform());
  }

  /**
   * Test {@link View#hasEntityFilters()}.
   * <p>
   * Method under test: {@link View#hasEntityFilters()}
   */
  @Test
  @DisplayName("Test hasEntityFilters()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean View.hasEntityFilters()"})
  void testHasEntityFilters() {
    // Arrange, Act and Assert
    assertFalse((new View()).hasEntityFilters());
  }

  /**
   * Test {@link View#hasEdgeFilters()}.
   * <p>
   * Method under test: {@link View#hasEdgeFilters()}
   */
  @Test
  @DisplayName("Test hasEdgeFilters()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean View.hasEdgeFilters()"})
  void testHasEdgeFilters() {
    // Arrange, Act and Assert
    assertFalse((new View()).hasEdgeFilters());
  }

  /**
   * Test {@link View#getConfig(String)} with {@code String}.
   * <p>
   * Method under test: {@link View#getConfig(String)}
   */
  @Test
  @DisplayName("Test getConfig(String) with 'String'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String View.getConfig(String)"})
  void testGetConfigWithString() {
    // Arrange, Act and Assert
    assertNull((new View()).getConfig("Key"));
  }

  /**
   * Test {@link View#canMerge(View, View)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link View#canMerge(View, View)}
   */
  @Test
  @DisplayName("Test canMerge(View, View); when 'null'; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean View.canMerge(View, View)"})
  void testCanMerge_whenNull_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue((new View()).canMerge(null, null));
  }

  /**
   * Test {@link View#canMerge(View, View)}.
   * <ul>
   *   <li>When {@link View} (default constructor).</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link View#canMerge(View, View)}
   */
  @Test
  @DisplayName("Test canMerge(View, View); when View (default constructor); then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean View.canMerge(View, View)"})
  void testCanMerge_whenView_thenReturnFalse() {
    // Arrange
    View view = new View();

    // Act and Assert
    assertFalse(view.canMerge(new View(), null));
  }

  /**
   * Test {@link View#canMerge(View, View)}.
   * <ul>
   *   <li>When {@link View} (default constructor).</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link View#canMerge(View, View)}
   */
  @Test
  @DisplayName("Test canMerge(View, View); when View (default constructor); then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean View.canMerge(View, View)"})
  void testCanMerge_whenView_thenReturnTrue() {
    // Arrange
    View view = new View();
    View addingView = new View();

    // Act and Assert
    assertTrue(view.canMerge(addingView, new View()));
  }

  /**
   * Test {@link View#equals(Object)}, and {@link View#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link View#equals(Object)}
   *   <li>{@link View#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean View.equals(Object)", "int View.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    View view = new View();
    View view2 = new View();

    // Act and Assert
    assertEquals(view, view2);
    int expectedHashCodeResult = view.hashCode();
    assertEquals(expectedHashCodeResult, view2.hashCode());
  }

  /**
   * Test {@link View#equals(Object)}, and {@link View#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link View#equals(Object)}
   *   <li>{@link View#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean View.equals(Object)", "int View.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    View view = new View();

    // Act and Assert
    assertEquals(view, view);
    int expectedHashCodeResult = view.hashCode();
    assertEquals(expectedHashCodeResult, view.hashCode());
  }

  /**
   * Test {@link View#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link View#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean View.equals(Object)", "int View.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    NamedView namedView = new NamedView();

    // Act and Assert
    assertNotEquals(namedView, new View());
  }

  /**
   * Test {@link View#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link View#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean View.equals(Object)", "int View.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    View view = new View();

    View view2 = new View();
    view2.setAllEntities(true);

    // Act and Assert
    assertNotEquals(view, view2);
  }

  /**
   * Test {@link View#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link View#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean View.equals(Object)", "int View.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new View(), null);
  }

  /**
   * Test {@link View#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link View#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean View.equals(Object)", "int View.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new View(), "Different type to View");
  }

  /**
   * Test {@link View#getClassName()}.
   * <ul>
   *   <li>Given {@link View} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link View#getClassName()}
   */
  @Test
  @DisplayName("Test getClassName(); given View (default constructor); then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String View.getClassName()"})
  void testGetClassName_givenView_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new View()).getClassName());
  }

  /**
   * Test {@link View#getClassName()}.
   * <ul>
   *   <li>Then return {@code NamedView}.</li>
   * </ul>
   * <p>
   * Method under test: {@link View#getClassName()}
   */
  @Test
  @DisplayName("Test getClassName(); then return 'uk.gov.gchq.gaffer.data.elementdefinition.view.NamedView'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String View.getClassName()"})
  void testGetClassName_thenReturnUkGovGchqGafferDataElementdefinitionViewNamedView() {
    // Arrange, Act and Assert
    assertEquals("uk.gov.gchq.gaffer.data.elementdefinition.view.NamedView", (new NamedView()).getClassName());
  }
}
