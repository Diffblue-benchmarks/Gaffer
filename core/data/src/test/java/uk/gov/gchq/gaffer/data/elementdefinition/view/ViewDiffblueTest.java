package uk.gov.gchq.gaffer.data.elementdefinition.view;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.io.InputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.data.elementdefinition.exception.SchemaException;
import uk.gov.gchq.gaffer.data.elementdefinition.view.NamedView.Builder;
import uk.gov.gchq.gaffer.data.elementdefinition.view.View.BaseBuilder;

class ViewDiffblueTest {
  /**
   * Test BaseBuilder {@link BaseBuilder#config(Map)} with {@code config}.
   *
   * <ul>
   *   <li>Given {@link Builder#Builder()}.
   *   <li>When {@link HashMap#HashMap()}.
   *   <li>Then return {@link Builder#Builder()}.
   * </ul>
   *
   * <p>Method under test: {@link BaseBuilder#config(Map)}
   */
  @Test
  @DisplayName(
      "Test BaseBuilder config(Map) with 'config'; given Builder(); when HashMap(); then return Builder()")
  @Tag("MaintainedByDiffblue")
  void testBaseBuilderConfigWithConfig_givenBuilder_whenHashMap_thenReturnBuilder() {
    // Arrange
    Builder builder = new Builder();

    // Act
    Builder actualConfigResult = builder.config(new HashMap<>());

    // Assert
    assertSame(builder, actualConfigResult);
  }

  /**
   * Test BaseBuilder {@link BaseBuilder#config(Map)} with {@code config}.
   *
   * <ul>
   *   <li>Then return {@link Builder#Builder(NamedView)} with namedView is {@link NamedView}
   *       (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link BaseBuilder#config(Map)}
   */
  @Test
  @DisplayName(
      "Test BaseBuilder config(Map) with 'config'; then return Builder(NamedView) with namedView is NamedView (default constructor)")
  @Tag("MaintainedByDiffblue")
  void testBaseBuilderConfigWithConfig_thenReturnBuilderWithNamedViewIsNamedView() {
    // Arrange
    Builder builder = new Builder(new NamedView());

    // Act
    Builder actualConfigResult = builder.config(null);

    // Assert
    assertSame(builder, actualConfigResult);
  }

  /**
   * Test BaseBuilder {@link BaseBuilder#config(String, String)} with {@code key}, {@code value}.
   *
   * <ul>
   *   <li>Given {@link Builder#Builder()}.
   *   <li>Then return {@link Builder#Builder()}.
   * </ul>
   *
   * <p>Method under test: {@link BaseBuilder#config(String, String)}
   */
  @Test
  @DisplayName(
      "Test BaseBuilder config(String, String) with 'key', 'value'; given Builder(); then return Builder()")
  @Tag("MaintainedByDiffblue")
  void testBaseBuilderConfigWithKeyValue_givenBuilder_thenReturnBuilder() {
    // Arrange
    Builder builder = new Builder();

    // Act
    Builder actualConfigResult = builder.config("Key", "42");

    // Assert
    assertSame(builder, actualConfigResult);
  }

  /**
   * Test BaseBuilder {@link BaseBuilder#edge(String, ViewElementDefinition)} with {@code group},
   * {@code edgeDef}.
   *
   * <ul>
   *   <li>Given {@link Builder#Builder()}.
   *   <li>When {@code null}.
   *   <li>Then return {@link Builder#Builder()}.
   * </ul>
   *
   * <p>Method under test: {@link BaseBuilder#edge(String, ViewElementDefinition)}
   */
  @Test
  @DisplayName(
      "Test BaseBuilder edge(String, ViewElementDefinition) with 'group', 'edgeDef'; given Builder(); when 'null'; then return Builder()")
  @Tag("MaintainedByDiffblue")
  void testBaseBuilderEdgeWithGroupEdgeDef_givenBuilder_whenNull_thenReturnBuilder() {
    // Arrange
    Builder builder = new Builder();

    // Act
    Builder actualEdgeResult = builder.edge("Group", null);

    // Assert
    assertSame(builder, actualEdgeResult);
  }

  /**
   * Test BaseBuilder {@link BaseBuilder#edge(String)} with {@code group}.
   *
   * <ul>
   *   <li>Given {@link Builder#Builder()}.
   *   <li>Then return {@link Builder#Builder()}.
   * </ul>
   *
   * <p>Method under test: {@link BaseBuilder#edge(String)}
   */
  @Test
  @DisplayName("Test BaseBuilder edge(String) with 'group'; given Builder(); then return Builder()")
  @Tag("MaintainedByDiffblue")
  void testBaseBuilderEdgeWithGroup_givenBuilder_thenReturnBuilder() {
    // Arrange
    Builder builder = new Builder();

    // Act
    Builder actualEdgeResult = builder.edge("Group");

    // Assert
    assertSame(builder, actualEdgeResult);
  }

  /**
   * Test BaseBuilder {@link BaseBuilder#edges(Collection)} with {@code groups}.
   *
   * <ul>
   *   <li>Given {@link Builder#Builder()}.
   *   <li>When {@code null}.
   *   <li>Then return {@link Builder#Builder()}.
   * </ul>
   *
   * <p>Method under test: {@link BaseBuilder#edges(Collection)}
   */
  @Test
  @DisplayName(
      "Test BaseBuilder edges(Collection) with 'groups'; given Builder(); when 'null'; then return Builder()")
  @Tag("MaintainedByDiffblue")
  void testBaseBuilderEdgesWithGroups_givenBuilder_whenNull_thenReturnBuilder() {
    // Arrange
    Builder builder = new Builder();

    // Act
    Builder actualEdgesResult = builder.edges((Collection<String>) null);

    // Assert
    assertSame(builder, actualEdgesResult);
  }

  /**
   * Test BaseBuilder {@link BaseBuilder#edges(Collection)} with {@code groups}.
   *
   * <ul>
   *   <li>Given {@code Groups}.
   *   <li>When {@link LinkedHashSet#LinkedHashSet()} add {@code Groups}.
   * </ul>
   *
   * <p>Method under test: {@link BaseBuilder#edges(Collection)}
   */
  @Test
  @DisplayName(
      "Test BaseBuilder edges(Collection) with 'groups'; given 'Groups'; when LinkedHashSet() add 'Groups'")
  @Tag("MaintainedByDiffblue")
  void testBaseBuilderEdgesWithGroups_givenGroups_whenLinkedHashSetAddGroups() {
    // Arrange
    Builder builder = new Builder();

    LinkedHashSet<String> groups = new LinkedHashSet<>();
    groups.add("Groups");

    // Act
    Builder actualEdgesResult = builder.edges(groups);

    // Assert
    assertSame(builder, actualEdgesResult);
  }

  /**
   * Test BaseBuilder {@link BaseBuilder#entities(Collection)} with {@code groups}.
   *
   * <ul>
   *   <li>Given {@link Builder#Builder()}.
   *   <li>When {@code null}.
   *   <li>Then return {@link Builder#Builder()}.
   * </ul>
   *
   * <p>Method under test: {@link BaseBuilder#entities(Collection)}
   */
  @Test
  @DisplayName(
      "Test BaseBuilder entities(Collection) with 'groups'; given Builder(); when 'null'; then return Builder()")
  @Tag("MaintainedByDiffblue")
  void testBaseBuilderEntitiesWithGroups_givenBuilder_whenNull_thenReturnBuilder() {
    // Arrange
    Builder builder = new Builder();

    // Act
    Builder actualEntitiesResult = builder.entities((Collection<String>) null);

    // Assert
    assertSame(builder, actualEntitiesResult);
  }

  /**
   * Test BaseBuilder {@link BaseBuilder#entities(Collection)} with {@code groups}.
   *
   * <ul>
   *   <li>Given {@code Groups}.
   *   <li>When {@link LinkedHashSet#LinkedHashSet()} add {@code Groups}.
   * </ul>
   *
   * <p>Method under test: {@link BaseBuilder#entities(Collection)}
   */
  @Test
  @DisplayName(
      "Test BaseBuilder entities(Collection) with 'groups'; given 'Groups'; when LinkedHashSet() add 'Groups'")
  @Tag("MaintainedByDiffblue")
  void testBaseBuilderEntitiesWithGroups_givenGroups_whenLinkedHashSetAddGroups() {
    // Arrange
    Builder builder = new Builder();

    LinkedHashSet<String> groups = new LinkedHashSet<>();
    groups.add("Groups");

    // Act
    Builder actualEntitiesResult = builder.entities(groups);

    // Assert
    assertSame(builder, actualEntitiesResult);
  }

  /**
   * Test BaseBuilder {@link BaseBuilder#entity(String, ViewElementDefinition)} with {@code group},
   * {@code entityDef}.
   *
   * <ul>
   *   <li>Given {@link Builder#Builder()}.
   *   <li>When {@code null}.
   *   <li>Then return {@link Builder#Builder()}.
   * </ul>
   *
   * <p>Method under test: {@link BaseBuilder#entity(String, ViewElementDefinition)}
   */
  @Test
  @DisplayName(
      "Test BaseBuilder entity(String, ViewElementDefinition) with 'group', 'entityDef'; given Builder(); when 'null'; then return Builder()")
  @Tag("MaintainedByDiffblue")
  void testBaseBuilderEntityWithGroupEntityDef_givenBuilder_whenNull_thenReturnBuilder() {
    // Arrange
    Builder builder = new Builder();

    // Act
    Builder actualEntityResult = builder.entity("Group", null);

    // Assert
    assertSame(builder, actualEntityResult);
  }

  /**
   * Test BaseBuilder {@link BaseBuilder#entity(String)} with {@code group}.
   *
   * <ul>
   *   <li>Given {@link Builder#Builder()}.
   *   <li>Then return {@link Builder#Builder()}.
   * </ul>
   *
   * <p>Method under test: {@link BaseBuilder#entity(String)}
   */
  @Test
  @DisplayName(
      "Test BaseBuilder entity(String) with 'group'; given Builder(); then return Builder()")
  @Tag("MaintainedByDiffblue")
  void testBaseBuilderEntityWithGroup_givenBuilder_thenReturnBuilder() {
    // Arrange
    Builder builder = new Builder();

    // Act
    Builder actualEntityResult = builder.entity("Group");

    // Assert
    assertSame(builder, actualEntityResult);
  }

  /**
   * Test BaseBuilder {@link BaseBuilder#expandGlobalDefinitions()}.
   *
   * <ul>
   *   <li>Given {@link Builder#Builder()}.
   *   <li>Then return {@link Builder#Builder()}.
   * </ul>
   *
   * <p>Method under test: {@link BaseBuilder#expandGlobalDefinitions()}
   */
  @Test
  @DisplayName("Test BaseBuilder expandGlobalDefinitions(); given Builder(); then return Builder()")
  @Tag("MaintainedByDiffblue")
  void testBaseBuilderExpandGlobalDefinitions_givenBuilder_thenReturnBuilder() {
    // Arrange
    Builder builder = new Builder();

    // Act
    Builder actualExpandGlobalDefinitionsResult = builder.expandGlobalDefinitions();

    // Assert
    assertSame(builder, actualExpandGlobalDefinitionsResult);
  }

  /**
   * Test BaseBuilder {@link BaseBuilder#json(Path[])} with {@code filePaths}.
   *
   * <ul>
   *   <li>Then return {@link View.Builder#Builder()}.
   * </ul>
   *
   * <p>Method under test: {@link BaseBuilder#json(Path[])}
   */
  @Test
  @DisplayName("Test BaseBuilder json(Path[]) with 'filePaths'; then return Builder()")
  @Tag("MaintainedByDiffblue")
  void testBaseBuilderJsonWithFilePaths_thenReturnBuilder() throws SchemaException {
    // Arrange
    View.Builder builder = new View.Builder();
    Paths.get(System.getProperty("java.io.tmpdir"), "test.txt");

    // Act
    View.Builder actualJsonResult = builder.json(new Path[] {});

    // Assert
    assertSame(builder, actualJsonResult);
  }

  /**
   * Test BaseBuilder {@link BaseBuilder#json(Path[])} with {@code filePaths}.
   *
   * <ul>
   *   <li>When Property is {@code java.io.tmpdir} is empty string.
   * </ul>
   *
   * <p>Method under test: {@link BaseBuilder#json(Path[])}
   */
  @Test
  @DisplayName(
      "Test BaseBuilder json(Path[]) with 'filePaths'; when Property is 'java.io.tmpdir' is empty string")
  @Tag("MaintainedByDiffblue")
  void testBaseBuilderJsonWithFilePaths_whenPropertyIsJavaIoTmpdirIsEmptyString()
      throws SchemaException {
    // Arrange, Act and Assert
    assertThrows(
        SchemaException.class,
        () -> new View.Builder().json(Paths.get(System.getProperty("java.io.tmpdir"), "")));
  }

  /**
   * Test BaseBuilder {@link BaseBuilder#json(Path[])} with {@code filePaths}.
   *
   * <ul>
   *   <li>When Property is {@code java.io.tmpdir} is {@code test.txt}.
   * </ul>
   *
   * <p>Method under test: {@link BaseBuilder#json(Path[])}
   */
  @Test
  @DisplayName(
      "Test BaseBuilder json(Path[]) with 'filePaths'; when Property is 'java.io.tmpdir' is 'test.txt'")
  @Tag("MaintainedByDiffblue")
  void testBaseBuilderJsonWithFilePaths_whenPropertyIsJavaIoTmpdirIsTestTxt()
      throws SchemaException {
    // Arrange, Act and Assert
    assertThrows(
        SchemaException.class,
        () -> new View.Builder().json(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt")));
  }

  /**
   * Test BaseBuilder {@link BaseBuilder#json(InputStream[])} with {@code inputStreams}.
   *
   * <ul>
   *   <li>Then return {@link View.Builder#Builder()}.
   * </ul>
   *
   * <p>Method under test: {@link BaseBuilder#json(InputStream[])}
   */
  @Test
  @DisplayName("Test BaseBuilder json(InputStream[]) with 'inputStreams'; then return Builder()")
  @Tag("MaintainedByDiffblue")
  void testBaseBuilderJsonWithInputStreams_thenReturnBuilder() throws SchemaException {
    // Arrange
    View.Builder builder = new View.Builder();

    // Act
    View.Builder actualJsonResult = builder.json(new InputStream[] {});

    // Assert
    assertSame(builder, actualJsonResult);
  }

  /**
   * Test BaseBuilder {@link BaseBuilder#json(byte[][])} with {@code jsonBytes}.
   *
   * <ul>
   *   <li>Then return {@link View.Builder#Builder()}.
   * </ul>
   *
   * <p>Method under test: {@link BaseBuilder#json(byte[][])}
   */
  @Test
  @DisplayName("Test BaseBuilder json(byte[][]) with 'jsonBytes'; then return Builder()")
  @Tag("MaintainedByDiffblue")
  void testBaseBuilderJsonWithJsonBytes_thenReturnBuilder() throws SchemaException {
    // Arrange
    View.Builder builder = new View.Builder();

    // Act
    View.Builder actualJsonResult = builder.json(new byte[][] {});

    // Assert
    assertSame(builder, actualJsonResult);
  }

  /**
   * Test BaseBuilder {@link BaseBuilder#merge(View)} with {@code View}.
   *
   * <ul>
   *   <li>Given {@code true}.
   *   <li>When {@link View} (default constructor) AllEntities is {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link BaseBuilder#merge(View)}
   */
  @Test
  @DisplayName(
      "Test BaseBuilder merge(View) with 'View'; given 'true'; when View (default constructor) AllEntities is 'true'")
  @Tag("MaintainedByDiffblue")
  void testBaseBuilderMergeWithView_givenTrue_whenViewAllEntitiesIsTrue() {
    // Arrange
    View.Builder builder = new View.Builder();

    View view = new View();
    view.setAllEntities(true);

    // Act
    View.Builder actualMergeResult = builder.merge(view);

    // Assert
    assertSame(builder, actualMergeResult);
  }

  /**
   * Test BaseBuilder {@link BaseBuilder#merge(View)} with {@code View}.
   *
   * <ul>
   *   <li>Given {@code View Name}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link BaseBuilder#merge(View)}
   */
  @Test
  @DisplayName(
      "Test BaseBuilder merge(View) with 'View'; given 'View Name'; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  void testBaseBuilderMergeWithView_givenViewName_thenThrowIllegalArgumentException() {
    // Arrange
    View.Builder builder = new View.Builder();

    NamedView view = new NamedView();
    view.setName("View Name");

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> builder.merge(view));
  }

  /**
   * Test BaseBuilder {@link BaseBuilder#merge(View)} with {@code View}.
   *
   * <ul>
   *   <li>When {@link NamedView} (default constructor).
   *   <li>Then return {@link View.Builder#Builder()}.
   * </ul>
   *
   * <p>Method under test: {@link BaseBuilder#merge(View)}
   */
  @Test
  @DisplayName(
      "Test BaseBuilder merge(View) with 'View'; when NamedView (default constructor); then return Builder()")
  @Tag("MaintainedByDiffblue")
  void testBaseBuilderMergeWithView_whenNamedView_thenReturnBuilder() {
    // Arrange
    View.Builder builder = new View.Builder();

    // Act
    View.Builder actualMergeResult = builder.merge(new NamedView());

    // Assert
    assertSame(builder, actualMergeResult);
  }

  /**
   * Test BaseBuilder {@link BaseBuilder#merge(View)} with {@code View}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@link View.Builder#Builder()}.
   * </ul>
   *
   * <p>Method under test: {@link BaseBuilder#merge(View)}
   */
  @Test
  @DisplayName("Test BaseBuilder merge(View) with 'View'; when 'null'; then return Builder()")
  @Tag("MaintainedByDiffblue")
  void testBaseBuilderMergeWithView_whenNull_thenReturnBuilder() {
    // Arrange
    View.Builder builder = new View.Builder();

    // Act
    View.Builder actualMergeResult = builder.merge(null);

    // Assert
    assertSame(builder, actualMergeResult);
  }

  /**
   * Test BaseBuilder {@link BaseBuilder#merge(View)} with {@code View}.
   *
   * <ul>
   *   <li>When {@link View} (default constructor).
   *   <li>Then return {@link View.Builder#Builder()}.
   * </ul>
   *
   * <p>Method under test: {@link BaseBuilder#merge(View)}
   */
  @Test
  @DisplayName(
      "Test BaseBuilder merge(View) with 'View'; when View (default constructor); then return Builder()")
  @Tag("MaintainedByDiffblue")
  void testBaseBuilderMergeWithView_whenView_thenReturnBuilder() {
    // Arrange
    View.Builder builder = new View.Builder();

    // Act
    View.Builder actualMergeResult = builder.merge(new View());

    // Assert
    assertSame(builder, actualMergeResult);
  }

  /**
   * Test Builder {@link View.Builder#Builder(View)}.
   *
   * <ul>
   *   <li>Given {@code true}.
   *   <li>When {@link View} (default constructor) AllEntities is {@code true}.
   *   <li>Then return build is {@link View} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link View.Builder#Builder(View)}
   */
  @Test
  @DisplayName(
      "Test Builder new Builder(View); given 'true'; when View (default constructor) AllEntities is 'true'; then return build is View (default constructor)")
  @Tag("MaintainedByDiffblue")
  void testBuilderNewBuilder_givenTrue_whenViewAllEntitiesIsTrue_thenReturnBuildIsView() {
    // Arrange
    View view = new View();
    view.setAllEntities(true);

    // Act and Assert
    View actualView = new View.Builder(view).build();
    assertEquals(view, actualView);
  }

  /**
   * Test Builder {@link View.Builder#Builder(View)}.
   *
   * <ul>
   *   <li>Given {@code View Name}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link View.Builder#Builder(View)}
   */
  @Test
  @DisplayName(
      "Test Builder new Builder(View); given 'View Name'; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  void testBuilderNewBuilder_givenViewName_thenThrowIllegalArgumentException() {
    // Arrange
    NamedView view = new NamedView();
    view.setName("View Name");

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> new View.Builder(view));
  }

  /**
   * Test Builder {@link View.Builder#Builder(View)}.
   *
   * <ul>
   *   <li>When {@link View} (default constructor).
   *   <li>Then return build is {@link View} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link View.Builder#Builder(View)}
   */
  @Test
  @DisplayName(
      "Test Builder new Builder(View); when View (default constructor); then return build is View (default constructor)")
  @Tag("MaintainedByDiffblue")
  void testBuilderNewBuilder_whenView_thenReturnBuildIsView() {
    // Arrange
    View view = new View();

    // Act and Assert
    View actualView = new View.Builder(view).build();
    assertEquals(view, actualView);
  }

  /**
   * Test Builder {@link View.Builder#self()}.
   *
   * <p>Method under test: {@link View.Builder#self()}
   */
  @Test
  @DisplayName("Test Builder self()")
  @Tag("MaintainedByDiffblue")
  void testBuilderSelf() {
    // Arrange
    View.Builder builder = new View.Builder();

    // Act
    View.Builder actualSelfResult = builder.self();

    // Assert
    assertSame(builder, actualSelfResult);
  }

  /**
   * Test {@link View#getElement(String)}.
   *
   * <p>Method under test: {@link View#getElement(String)}
   */
  @Test
  @DisplayName("Test getElement(String)")
  @Tag("MaintainedByDiffblue")
  void testGetElement() {
    // Arrange, Act and Assert
    assertNull(new View().getElement("Group"));
  }

  /**
   * Test {@link View#getElementGroupBy(String)}.
   *
   * <p>Method under test: {@link View#getElementGroupBy(String)}
   */
  @Test
  @DisplayName("Test getElementGroupBy(String)")
  @Tag("MaintainedByDiffblue")
  void testGetElementGroupBy() {
    // Arrange, Act and Assert
    assertNull(new View().getElementGroupBy("Group"));
  }

  /**
   * Test {@link View#hasPreAggregationFilters()}.
   *
   * <p>Method under test: {@link View#hasPreAggregationFilters()}
   */
  @Test
  @DisplayName("Test hasPreAggregationFilters()")
  @Tag("MaintainedByDiffblue")
  void testHasPreAggregationFilters() {
    // Arrange, Act and Assert
    assertFalse(new View().hasPreAggregationFilters());
  }

  /**
   * Test {@link View#hasPostAggregationFilters()}.
   *
   * <p>Method under test: {@link View#hasPostAggregationFilters()}
   */
  @Test
  @DisplayName("Test hasPostAggregationFilters()")
  @Tag("MaintainedByDiffblue")
  void testHasPostAggregationFilters() {
    // Arrange, Act and Assert
    assertFalse(new View().hasPostAggregationFilters());
  }

  /**
   * Test {@link View#hasPostTransformFilters()}.
   *
   * <p>Method under test: {@link View#hasPostTransformFilters()}
   */
  @Test
  @DisplayName("Test hasPostTransformFilters()")
  @Tag("MaintainedByDiffblue")
  void testHasPostTransformFilters() {
    // Arrange, Act and Assert
    assertFalse(new View().hasPostTransformFilters());
  }

  /**
   * Test {@link View#hasTransform()}.
   *
   * <p>Method under test: {@link View#hasTransform()}
   */
  @Test
  @DisplayName("Test hasTransform()")
  @Tag("MaintainedByDiffblue")
  void testHasTransform() {
    // Arrange, Act and Assert
    assertFalse(new View().hasTransform());
  }

  /**
   * Test {@link View#hasEntityFilters()}.
   *
   * <p>Method under test: {@link View#hasEntityFilters()}
   */
  @Test
  @DisplayName("Test hasEntityFilters()")
  @Tag("MaintainedByDiffblue")
  void testHasEntityFilters() {
    // Arrange, Act and Assert
    assertFalse(new View().hasEntityFilters());
  }

  /**
   * Test {@link View#hasEdgeFilters()}.
   *
   * <p>Method under test: {@link View#hasEdgeFilters()}
   */
  @Test
  @DisplayName("Test hasEdgeFilters()")
  @Tag("MaintainedByDiffblue")
  void testHasEdgeFilters() {
    // Arrange, Act and Assert
    assertFalse(new View().hasEdgeFilters());
  }

  /**
   * Test {@link View#getConfig(String)} with {@code String}.
   *
   * <p>Method under test: {@link View#getConfig(String)}
   */
  @Test
  @DisplayName("Test getConfig(String) with 'String'")
  @Tag("MaintainedByDiffblue")
  void testGetConfigWithString() {
    // Arrange, Act and Assert
    assertNull(new View().getConfig("Key"));
  }

  /**
   * Test {@link View#canMerge(View, View)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link View#canMerge(View, View)}
   */
  @Test
  @DisplayName("Test canMerge(View, View); when 'null'; then return 'true'")
  @Tag("MaintainedByDiffblue")
  void testCanMerge_whenNull_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(new View().canMerge(null, null));
  }

  /**
   * Test {@link View#canMerge(View, View)}.
   *
   * <ul>
   *   <li>When {@link View} (default constructor).
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link View#canMerge(View, View)}
   */
  @Test
  @DisplayName("Test canMerge(View, View); when View (default constructor); then return 'false'")
  @Tag("MaintainedByDiffblue")
  void testCanMerge_whenView_thenReturnFalse() {
    // Arrange
    View view = new View();

    // Act and Assert
    assertFalse(view.canMerge(new View(), null));
  }

  /**
   * Test {@link View#canMerge(View, View)}.
   *
   * <ul>
   *   <li>When {@link View} (default constructor).
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link View#canMerge(View, View)}
   */
  @Test
  @DisplayName("Test canMerge(View, View); when View (default constructor); then return 'true'")
  @Tag("MaintainedByDiffblue")
  void testCanMerge_whenView_thenReturnTrue() {
    // Arrange
    View view = new View();
    View addingView = new View();

    // Act and Assert
    assertTrue(view.canMerge(addingView, new View()));
  }

  /**
   * Test {@link View#equals(Object)}, and {@link View#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link View#equals(Object)}
   *   <li>{@link View#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    View view = new View();
    View view2 = new View();

    // Act and Assert
    assertEquals(view, view2);
    assertEquals(view.hashCode(), view2.hashCode());
  }

  /**
   * Test {@link View#equals(Object)}, and {@link View#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link View#equals(Object)}
   *   <li>{@link View#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
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
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link View#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    NamedView namedView = new NamedView();

    // Act and Assert
    assertNotEquals(namedView, new View());
  }

  /**
   * Test {@link View#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link View#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
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
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link View#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new View(), null);
  }

  /**
   * Test {@link View#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link View#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new View(), "Different type to View");
  }

  /**
   * Test {@link View#getClassName()}.
   *
   * <ul>
   *   <li>Given {@link View} (default constructor).
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link View#getClassName()}
   */
  @Test
  @DisplayName("Test getClassName(); given View (default constructor); then return 'null'")
  @Tag("MaintainedByDiffblue")
  void testGetClassName_givenView_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new View().getClassName());
  }

  /**
   * Test {@link View#getClassName()}.
   *
   * <ul>
   *   <li>Then return {@code NamedView}.
   * </ul>
   *
   * <p>Method under test: {@link View#getClassName()}
   */
  @Test
  @DisplayName(
      "Test getClassName(); then return 'uk.gov.gchq.gaffer.data.elementdefinition.view.NamedView'")
  @Tag("MaintainedByDiffblue")
  void testGetClassName_thenReturnUkGovGchqGafferDataElementdefinitionViewNamedView() {
    // Arrange, Act and Assert
    assertEquals(
        "uk.gov.gchq.gaffer.data.elementdefinition.view.NamedView", new NamedView().getClassName());
  }
}
