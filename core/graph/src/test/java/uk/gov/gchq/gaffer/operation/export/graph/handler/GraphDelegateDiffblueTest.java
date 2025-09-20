package uk.gov.gchq.gaffer.operation.export.graph.handler;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.commonutil.exception.OverwritingException;
import uk.gov.gchq.gaffer.commonutil.pair.Pair;
import uk.gov.gchq.gaffer.data.elementdefinition.view.View;
import uk.gov.gchq.gaffer.graph.GraphSerialisable;
import uk.gov.gchq.gaffer.graph.GraphTest;
import uk.gov.gchq.gaffer.graph.GraphTest.TestStoreImpl;
import uk.gov.gchq.gaffer.graph.hook.AddOperationsToChain;
import uk.gov.gchq.gaffer.graph.hook.GraphHook;
import uk.gov.gchq.gaffer.graph.hook.UpdateViewHook;
import uk.gov.gchq.gaffer.operation.export.graph.handler.GraphDelegate.BaseBuilder;
import uk.gov.gchq.gaffer.operation.export.graph.handler.GraphDelegate.Builder;
import uk.gov.gchq.gaffer.store.Store;
import uk.gov.gchq.gaffer.store.StoreProperties;
import uk.gov.gchq.gaffer.store.library.FileGraphLibrary;
import uk.gov.gchq.gaffer.store.library.HashMapGraphLibrary;
import uk.gov.gchq.gaffer.store.library.NoGraphLibrary;
import uk.gov.gchq.gaffer.store.schema.Schema;
import uk.gov.gchq.koryphe.ValidationResult;

class GraphDelegateDiffblueTest {
  /**
   * Test BaseBuilder {@link BaseBuilder#buildGraphSerialisable()}.
   *
   * <ul>
   *   <li>Then return GraphId is {@code foo}.
   * </ul>
   *
   * <p>Method under test: {@link BaseBuilder#buildGraphSerialisable()}
   */
  @Test
  @DisplayName("Test BaseBuilder buildGraphSerialisable(); then return GraphId is 'foo'")
  @Tag("MaintainedByDiffblue")
  void testBaseBuilderBuildGraphSerialisable_thenReturnGraphIdIsFoo()
      throws UnsupportedEncodingException {
    // Arrange
    TestStoreImpl store = new TestStoreImpl();
    store.setGraphLibrary(null);

    BaseBuilder<BaseBuilder> baseBuilder = new BaseBuilder<>();
    baseBuilder.store(store);
    baseBuilder.graphId("foo");
    baseBuilder.parentSchemaIds(null);
    baseBuilder.schema(new Schema());
    baseBuilder.parentStorePropertiesId(null);
    baseBuilder.storeProperties(new StoreProperties());

    // Act
    GraphSerialisable actualBuildGraphSerialisableResult = baseBuilder.buildGraphSerialisable();

    // Assert
    assertEquals("foo", actualBuildGraphSerialisableResult.getGraphId());
    assertEquals(125, actualBuildGraphSerialisableResult.getSerialisedConfig().length);
    assertEquals(82, actualBuildGraphSerialisableResult.getSerialisedProperties().length);
    assertArrayEquals(
        "{\n  \"types\" : { }\n}".getBytes("UTF-8"),
        actualBuildGraphSerialisableResult.getSerialisedSchema());
  }

  /**
   * Test BaseBuilder {@link BaseBuilder#createGraphSerialisable()}.
   *
   * <ul>
   *   <li>Then return GraphId is {@code foo}.
   * </ul>
   *
   * <p>Method under test: {@link BaseBuilder#createGraphSerialisable()}
   */
  @Test
  @DisplayName("Test BaseBuilder createGraphSerialisable(); then return GraphId is 'foo'")
  @Tag("MaintainedByDiffblue")
  void testBaseBuilderCreateGraphSerialisable_thenReturnGraphIdIsFoo()
      throws UnsupportedEncodingException {
    // Arrange
    TestStoreImpl store = new TestStoreImpl();
    store.setGraphLibrary(null);

    BaseBuilder<BaseBuilder> baseBuilder = new BaseBuilder<>();
    baseBuilder.store(store);
    baseBuilder.graphId("foo");
    baseBuilder.parentSchemaIds(null);
    baseBuilder.schema(new Schema());
    baseBuilder.parentStorePropertiesId(null);
    baseBuilder.storeProperties(new StoreProperties());

    // Act
    GraphSerialisable actualCreateGraphSerialisableResult = baseBuilder.createGraphSerialisable();

    // Assert
    assertEquals("foo", actualCreateGraphSerialisableResult.getGraphId());
    assertEquals(125, actualCreateGraphSerialisableResult.getSerialisedConfig().length);
    assertEquals(82, actualCreateGraphSerialisableResult.getSerialisedProperties().length);
    assertArrayEquals(
        "{\n  \"types\" : { }\n}".getBytes("UTF-8"),
        actualCreateGraphSerialisableResult.getSerialisedSchema());
  }

  /**
   * Test BaseBuilder {@link BaseBuilder#graphId(String)}.
   *
   * <p>Method under test: {@link BaseBuilder#graphId(String)}
   */
  @Test
  @DisplayName("Test BaseBuilder graphId(String)")
  @Tag("MaintainedByDiffblue")
  void testBaseBuilderGraphId() {
    // Arrange
    BaseBuilder<BaseBuilder> baseBuilder = new BaseBuilder<>();

    // Act
    BaseBuilder actualGraphIdResult = baseBuilder.graphId("42");

    // Assert
    assertEquals("42", baseBuilder.graphId);
    assertSame(baseBuilder, actualGraphIdResult);
  }

  /**
   * Test BaseBuilder new {@link BaseBuilder} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link BaseBuilder}
   */
  @Test
  @DisplayName("Test BaseBuilder new BaseBuilder (default constructor)")
  @Tag("MaintainedByDiffblue")
  void testBaseBuilderNewBaseBuilder() {
    // Arrange and Act
    BaseBuilder<BaseBuilder> actualBaseBuilder = new BaseBuilder<>();

    // Assert
    assertNull(actualBaseBuilder.graphId);
    assertNull(actualBaseBuilder.parentStorePropertiesId);
    assertNull(actualBaseBuilder.parentSchemaIds);
    assertNull(actualBaseBuilder.store);
    assertNull(actualBaseBuilder.storeProperties);
    assertNull(actualBaseBuilder.schema);
  }

  /**
   * Test BaseBuilder {@link BaseBuilder#parentSchemaIds(List)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>Then {@link BaseBuilder} (default constructor) {@link BaseBuilder#parentSchemaIds} size
   *       is two.
   * </ul>
   *
   * <p>Method under test: {@link BaseBuilder#parentSchemaIds(List)}
   */
  @Test
  @DisplayName(
      "Test BaseBuilder parentSchemaIds(List); given '42'; then BaseBuilder (default constructor) parentSchemaIds size is two")
  @Tag("MaintainedByDiffblue")
  void testBaseBuilderParentSchemaIds_given42_thenBaseBuilderParentSchemaIdsSizeIsTwo() {
    // Arrange
    BaseBuilder<BaseBuilder> baseBuilder = new BaseBuilder<>();

    ArrayList<String> parentSchemaIds = new ArrayList<>();
    parentSchemaIds.add("42");
    parentSchemaIds.add("foo");

    // Act
    BaseBuilder actualParentSchemaIdsResult = baseBuilder.parentSchemaIds(parentSchemaIds);

    // Assert
    List<String> stringList = baseBuilder.parentSchemaIds;
    assertEquals(2, stringList.size());
    assertEquals("42", stringList.get(0));
    assertEquals("foo", stringList.get(1));
    assertSame(baseBuilder, actualParentSchemaIdsResult);
  }

  /**
   * Test BaseBuilder {@link BaseBuilder#parentSchemaIds(List)}.
   *
   * <ul>
   *   <li>Given {@code foo}.
   *   <li>Then {@link BaseBuilder} (default constructor) {@link BaseBuilder#parentSchemaIds} size
   *       is one.
   * </ul>
   *
   * <p>Method under test: {@link BaseBuilder#parentSchemaIds(List)}
   */
  @Test
  @DisplayName(
      "Test BaseBuilder parentSchemaIds(List); given 'foo'; then BaseBuilder (default constructor) parentSchemaIds size is one")
  @Tag("MaintainedByDiffblue")
  void testBaseBuilderParentSchemaIds_givenFoo_thenBaseBuilderParentSchemaIdsSizeIsOne() {
    // Arrange
    BaseBuilder<BaseBuilder> baseBuilder = new BaseBuilder<>();

    ArrayList<String> parentSchemaIds = new ArrayList<>();
    parentSchemaIds.add("foo");

    // Act
    BaseBuilder actualParentSchemaIdsResult = baseBuilder.parentSchemaIds(parentSchemaIds);

    // Assert
    List<String> stringList = baseBuilder.parentSchemaIds;
    assertEquals(1, stringList.size());
    assertEquals("foo", stringList.get(0));
    assertSame(baseBuilder, actualParentSchemaIdsResult);
  }

  /**
   * Test BaseBuilder {@link BaseBuilder#parentSchemaIds(List)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then {@link BaseBuilder} (default constructor) {@link BaseBuilder#parentSchemaIds} Empty.
   * </ul>
   *
   * <p>Method under test: {@link BaseBuilder#parentSchemaIds(List)}
   */
  @Test
  @DisplayName(
      "Test BaseBuilder parentSchemaIds(List); when ArrayList(); then BaseBuilder (default constructor) parentSchemaIds Empty")
  @Tag("MaintainedByDiffblue")
  void testBaseBuilderParentSchemaIds_whenArrayList_thenBaseBuilderParentSchemaIdsEmpty() {
    // Arrange
    BaseBuilder<BaseBuilder> baseBuilder = new BaseBuilder<>();

    // Act
    BaseBuilder actualParentSchemaIdsResult = baseBuilder.parentSchemaIds(new ArrayList<>());

    // Assert
    assertTrue(baseBuilder.parentSchemaIds.isEmpty());
    assertSame(baseBuilder, actualParentSchemaIdsResult);
  }

  /**
   * Test BaseBuilder {@link BaseBuilder#parentStorePropertiesId(String)}.
   *
   * <p>Method under test: {@link BaseBuilder#parentStorePropertiesId(String)}
   */
  @Test
  @DisplayName("Test BaseBuilder parentStorePropertiesId(String)")
  @Tag("MaintainedByDiffblue")
  void testBaseBuilderParentStorePropertiesId() {
    // Arrange
    BaseBuilder<BaseBuilder> baseBuilder = new BaseBuilder<>();

    // Act
    BaseBuilder actualParentStorePropertiesIdResult = baseBuilder.parentStorePropertiesId("42");

    // Assert
    assertEquals("42", baseBuilder.parentStorePropertiesId);
    assertSame(baseBuilder, actualParentStorePropertiesIdResult);
  }

  /**
   * Test BaseBuilder {@link BaseBuilder#schema(Schema)}.
   *
   * <p>Method under test: {@link BaseBuilder#schema(Schema)}
   */
  @Test
  @DisplayName("Test BaseBuilder schema(Schema)")
  @Tag("MaintainedByDiffblue")
  void testBaseBuilderSchema() {
    // Arrange
    BaseBuilder<BaseBuilder> baseBuilder = new BaseBuilder<>();

    // Act
    BaseBuilder actualSchemaResult = baseBuilder.schema(new Schema());

    // Assert
    assertSame(baseBuilder, actualSchemaResult);
  }

  /**
   * Test BaseBuilder {@link BaseBuilder#store(Store)}.
   *
   * <p>Method under test: {@link BaseBuilder#store(Store)}
   */
  @Test
  @DisplayName("Test BaseBuilder store(Store)")
  @Tag("MaintainedByDiffblue")
  void testBaseBuilderStore() {
    // Arrange
    BaseBuilder<BaseBuilder> baseBuilder = new BaseBuilder<>();

    // Act
    BaseBuilder actualStoreResult = baseBuilder.store(new TestStoreImpl());

    // Assert
    assertTrue(baseBuilder.store instanceof TestStoreImpl);
    assertSame(baseBuilder, actualStoreResult);
  }

  /**
   * Test BaseBuilder {@link BaseBuilder#storeProperties(StoreProperties)}.
   *
   * <p>Method under test: {@link BaseBuilder#storeProperties(StoreProperties)}
   */
  @Test
  @DisplayName("Test BaseBuilder storeProperties(StoreProperties)")
  @Tag("MaintainedByDiffblue")
  void testBaseBuilderStoreProperties() {
    // Arrange
    BaseBuilder<BaseBuilder> baseBuilder = new BaseBuilder<>();

    // Act
    BaseBuilder actualStorePropertiesResult = baseBuilder.storeProperties(new StoreProperties());

    // Assert
    assertSame(baseBuilder, actualStorePropertiesResult);
  }

  /**
   * Test BaseBuilder {@link BaseBuilder#_self()}.
   *
   * <p>Method under test: {@link BaseBuilder#_self()}
   */
  @Test
  @DisplayName("Test BaseBuilder _self()")
  @Tag("MaintainedByDiffblue")
  void testBaseBuilder_self() {
    // Arrange
    BaseBuilder<BaseBuilder> baseBuilder = new BaseBuilder<>();

    // Act
    BaseBuilder actual_selfResult = baseBuilder._self();

    // Assert
    assertSame(baseBuilder, actual_selfResult);
  }

  /**
   * Test Builder {@link Builder#createGraphSerialisable()}.
   *
   * <ul>
   *   <li>Given {@link Builder} (default constructor) graphId {@code foo}.
   *   <li>Then return GraphId is {@code foo}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#createGraphSerialisable()}
   */
  @Test
  @DisplayName(
      "Test Builder createGraphSerialisable(); given Builder (default constructor) graphId 'foo'; then return GraphId is 'foo'")
  @Tag("MaintainedByDiffblue")
  void testBuilderCreateGraphSerialisable_givenBuilderGraphIdFoo_thenReturnGraphIdIsFoo()
      throws UnsupportedEncodingException {
    // Arrange
    TestStoreImpl store = new TestStoreImpl();
    store.setGraphLibrary(null);

    Builder builder = new Builder();
    builder.store(store);
    builder.hooks(null);
    builder.graphId("foo");
    builder.parentSchemaIds(null);
    builder.schema(new Schema());
    builder.parentStorePropertiesId(null);
    builder.storeProperties(new StoreProperties());

    // Act
    GraphSerialisable actualCreateGraphSerialisableResult = builder.createGraphSerialisable();

    // Assert
    assertEquals("foo", actualCreateGraphSerialisableResult.getGraphId());
    assertEquals(125, actualCreateGraphSerialisableResult.getSerialisedConfig().length);
    assertEquals(82, actualCreateGraphSerialisableResult.getSerialisedProperties().length);
    assertArrayEquals(
        "{\n  \"types\" : { }\n}".getBytes("UTF-8"),
        actualCreateGraphSerialisableResult.getSerialisedSchema());
  }

  /**
   * Test Builder {@link Builder#hooks(GraphHook[])}.
   *
   * <p>Method under test: {@link Builder#hooks(GraphHook[])}
   */
  @Test
  @DisplayName("Test Builder hooks(GraphHook[])")
  @Tag("MaintainedByDiffblue")
  void testBuilderHooks() {
    // Arrange
    Builder builder = new Builder();

    // Act
    Builder actualHooksResult = builder.hooks(new AddOperationsToChain());

    // Assert
    assertSame(builder, actualHooksResult);
  }

  /**
   * Test Builder {@link Builder#_self()}.
   *
   * <p>Method under test: {@link Builder#_self()}
   */
  @Test
  @DisplayName("Test Builder _self()")
  @Tag("MaintainedByDiffblue")
  void testBuilder_self() {
    // Arrange
    Builder builder = new Builder();

    // Act
    Builder actual_selfResult = builder._self();

    // Assert
    assertSame(builder, actual_selfResult);
  }

  /**
   * Test {@link GraphDelegate#createGraph(Store, String, Schema, StoreProperties, List, String)}.
   *
   * <ul>
   *   <li>Given {@link FileGraphLibrary#FileGraphLibrary()}.
   * </ul>
   *
   * <p>Method under test: {@link GraphDelegate#createGraph(Store, String, Schema, StoreProperties,
   * List, String)}
   */
  @Test
  @DisplayName(
      "Test createGraph(Store, String, Schema, StoreProperties, List, String); given FileGraphLibrary()")
  @Tag("MaintainedByDiffblue")
  void testCreateGraph_givenFileGraphLibrary() {
    // Arrange
    TestStoreImpl store = new TestStoreImpl();
    store.setGraphLibrary(new FileGraphLibrary());
    Schema schema = new Schema();
    StoreProperties storeProperties = new StoreProperties();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            GraphDelegate.createGraph(
                store, "42", schema, storeProperties, new ArrayList<>(), "42"));
  }

  /**
   * Test {@link GraphDelegate#createGraph(Store, String, Schema, StoreProperties, List, String)}.
   *
   * <ul>
   *   <li>Given {@link NoGraphLibrary} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link GraphDelegate#createGraph(Store, String, Schema, StoreProperties,
   * List, String)}
   */
  @Test
  @DisplayName(
      "Test createGraph(Store, String, Schema, StoreProperties, List, String); given NoGraphLibrary (default constructor)")
  @Tag("MaintainedByDiffblue")
  void testCreateGraph_givenNoGraphLibrary() {
    // Arrange
    TestStoreImpl store = new TestStoreImpl();
    store.setGraphLibrary(new NoGraphLibrary());
    Schema schema = new Schema();
    StoreProperties storeProperties = new StoreProperties();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            GraphDelegate.createGraph(
                store, "42", schema, storeProperties, new ArrayList<>(), "42"));
  }

  /**
   * Test {@link GraphDelegate#createGraph(Store, String, Schema, StoreProperties, List, String)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link TestStoreImpl} (default constructor) GraphLibrary is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link GraphDelegate#createGraph(Store, String, Schema, StoreProperties,
   * List, String)}
   */
  @Test
  @DisplayName(
      "Test createGraph(Store, String, Schema, StoreProperties, List, String); given 'null'; when TestStoreImpl (default constructor) GraphLibrary is 'null'")
  @Tag("MaintainedByDiffblue")
  void testCreateGraph_givenNull_whenTestStoreImplGraphLibraryIsNull() {
    // Arrange
    TestStoreImpl store = new TestStoreImpl();
    store.setGraphLibrary(null);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> GraphDelegate.createGraph(store, null, null, null, null, null));
  }

  /**
   * Test {@link GraphDelegate#createGraph(Store, String, Schema, StoreProperties, List, String)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link TestStoreImpl} (default constructor) GraphLibrary is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link GraphDelegate#createGraph(Store, String, Schema, StoreProperties,
   * List, String)}
   */
  @Test
  @DisplayName(
      "Test createGraph(Store, String, Schema, StoreProperties, List, String); given 'null'; when TestStoreImpl (default constructor) GraphLibrary is 'null'")
  @Tag("MaintainedByDiffblue")
  void testCreateGraph_givenNull_whenTestStoreImplGraphLibraryIsNull2() {
    // Arrange
    TestStoreImpl store = new TestStoreImpl();
    store.setGraphLibrary(null);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> GraphDelegate.createGraph(store, null, null, new StoreProperties(), null, null));
  }

  /**
   * Test {@link GraphDelegate#createGraph(Store, String, Schema, StoreProperties, List, String)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link TestStoreImpl} (default constructor) GraphLibrary is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link GraphDelegate#createGraph(Store, String, Schema, StoreProperties,
   * List, String)}
   */
  @Test
  @DisplayName(
      "Test createGraph(Store, String, Schema, StoreProperties, List, String); given 'null'; when TestStoreImpl (default constructor) GraphLibrary is 'null'")
  @Tag("MaintainedByDiffblue")
  void testCreateGraph_givenNull_whenTestStoreImplGraphLibraryIsNull3() {
    // Arrange
    TestStoreImpl store = new TestStoreImpl();
    store.setGraphLibrary(null);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> GraphDelegate.createGraph(store, null, new Schema(), null, null, null));
  }

  /**
   * Test {@link GraphDelegate#createGraph(Store, String, Schema, StoreProperties, List, String)}.
   *
   * <ul>
   *   <li>Given {@code Parent Schema Ids}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code Parent Schema Ids}.
   * </ul>
   *
   * <p>Method under test: {@link GraphDelegate#createGraph(Store, String, Schema, StoreProperties,
   * List, String)}
   */
  @Test
  @DisplayName(
      "Test createGraph(Store, String, Schema, StoreProperties, List, String); given 'Parent Schema Ids'; when ArrayList() add 'Parent Schema Ids'")
  @Tag("MaintainedByDiffblue")
  void testCreateGraph_givenParentSchemaIds_whenArrayListAddParentSchemaIds() {
    // Arrange
    TestStoreImpl store = new TestStoreImpl();
    store.setGraphLibrary(null);

    ArrayList<String> parentSchemaIds = new ArrayList<>();
    parentSchemaIds.add("Parent Schema Ids");

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> GraphDelegate.createGraph(store, null, null, null, parentSchemaIds, null));
  }

  /**
   * Test {@link GraphDelegate#createGraph(Store, String, Schema, StoreProperties, List, String)}.
   *
   * <ul>
   *   <li>When {@link TestStoreImpl} (default constructor).
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link GraphDelegate#createGraph(Store, String, Schema, StoreProperties,
   * List, String)}
   */
  @Test
  @DisplayName(
      "Test createGraph(Store, String, Schema, StoreProperties, List, String); when TestStoreImpl (default constructor); then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  void testCreateGraph_whenTestStoreImpl_thenThrowIllegalArgumentException() {
    // Arrange
    TestStoreImpl store = new TestStoreImpl();
    Schema schema = new Schema();
    StoreProperties storeProperties = new StoreProperties();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            GraphDelegate.createGraph(
                store, "42", schema, storeProperties, new ArrayList<>(), "42"));
  }

  /**
   * Test {@link GraphDelegate#createGraphSerialisable(Store, String, Schema, StoreProperties, List,
   * String)} with {@code store}, {@code graphId}, {@code schema}, {@code storeProperties}, {@code
   * parentSchemaIds}, {@code parentStorePropertiesId}.
   *
   * <p>Method under test: {@link GraphDelegate#createGraphSerialisable(Store, String, Schema,
   * StoreProperties, List, String)}
   */
  @Test
  @DisplayName(
      "Test createGraphSerialisable(Store, String, Schema, StoreProperties, List, String) with 'store', 'graphId', 'schema', 'storeProperties', 'parentSchemaIds', 'parentStorePropertiesId'")
  @Tag("MaintainedByDiffblue")
  void
      testCreateGraphSerialisableWithStoreGraphIdSchemaStorePropertiesParentSchemaIdsParentStorePropertiesId() {
    // Arrange
    GraphDelegate graphDelegate = new GraphDelegate();
    TestStoreImpl store = new TestStoreImpl();
    Schema schema = new Schema();
    StoreProperties storeProperties = new StoreProperties();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            graphDelegate.createGraphSerialisable(
                store, "42", schema, storeProperties, new ArrayList<>(), "42"));
  }

  /**
   * Test {@link GraphDelegate#createGraphSerialisable(Store, String, Schema, StoreProperties, List,
   * String)} with {@code store}, {@code graphId}, {@code schema}, {@code storeProperties}, {@code
   * parentSchemaIds}, {@code parentStorePropertiesId}.
   *
   * <p>Method under test: {@link GraphDelegate#createGraphSerialisable(Store, String, Schema,
   * StoreProperties, List, String)}
   */
  @Test
  @DisplayName(
      "Test createGraphSerialisable(Store, String, Schema, StoreProperties, List, String) with 'store', 'graphId', 'schema', 'storeProperties', 'parentSchemaIds', 'parentStorePropertiesId'")
  @Tag("MaintainedByDiffblue")
  void
      testCreateGraphSerialisableWithStoreGraphIdSchemaStorePropertiesParentSchemaIdsParentStorePropertiesId2() {
    // Arrange
    GraphDelegate graphDelegate = new GraphDelegate();

    TestStoreImpl store = new TestStoreImpl();
    store.setGraphLibrary(null);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> graphDelegate.createGraphSerialisable(store, null, null, null, null, null));
  }

  /**
   * Test {@link GraphDelegate#createGraphSerialisable(Store, String, Schema, StoreProperties, List,
   * String)} with {@code store}, {@code graphId}, {@code schema}, {@code storeProperties}, {@code
   * parentSchemaIds}, {@code parentStorePropertiesId}.
   *
   * <p>Method under test: {@link GraphDelegate#createGraphSerialisable(Store, String, Schema,
   * StoreProperties, List, String)}
   */
  @Test
  @DisplayName(
      "Test createGraphSerialisable(Store, String, Schema, StoreProperties, List, String) with 'store', 'graphId', 'schema', 'storeProperties', 'parentSchemaIds', 'parentStorePropertiesId'")
  @Tag("MaintainedByDiffblue")
  void
      testCreateGraphSerialisableWithStoreGraphIdSchemaStorePropertiesParentSchemaIdsParentStorePropertiesId3() {
    // Arrange
    GraphDelegate graphDelegate = new GraphDelegate();

    TestStoreImpl store = new TestStoreImpl();
    store.setGraphLibrary(null);

    ArrayList<String> parentSchemaIds = new ArrayList<>();
    parentSchemaIds.add("Parent Schema Ids");

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            graphDelegate.createGraphSerialisable(store, null, null, null, parentSchemaIds, null));
  }

  /**
   * Test {@link GraphDelegate#createGraphSerialisable(Store, String, Schema, StoreProperties, List,
   * String)} with {@code store}, {@code graphId}, {@code schema}, {@code storeProperties}, {@code
   * parentSchemaIds}, {@code parentStorePropertiesId}.
   *
   * <p>Method under test: {@link GraphDelegate#createGraphSerialisable(Store, String, Schema,
   * StoreProperties, List, String)}
   */
  @Test
  @DisplayName(
      "Test createGraphSerialisable(Store, String, Schema, StoreProperties, List, String) with 'store', 'graphId', 'schema', 'storeProperties', 'parentSchemaIds', 'parentStorePropertiesId'")
  @Tag("MaintainedByDiffblue")
  void
      testCreateGraphSerialisableWithStoreGraphIdSchemaStorePropertiesParentSchemaIdsParentStorePropertiesId4() {
    // Arrange
    GraphDelegate graphDelegate = new GraphDelegate();

    TestStoreImpl store = new TestStoreImpl();
    store.setGraphLibrary(null);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            graphDelegate.createGraphSerialisable(
                store, null, null, new StoreProperties(), null, null));
  }

  /**
   * Test {@link GraphDelegate#createGraphSerialisable(Store, String, Schema, StoreProperties, List,
   * String)} with {@code store}, {@code graphId}, {@code schema}, {@code storeProperties}, {@code
   * parentSchemaIds}, {@code parentStorePropertiesId}.
   *
   * <p>Method under test: {@link GraphDelegate#createGraphSerialisable(Store, String, Schema,
   * StoreProperties, List, String)}
   */
  @Test
  @DisplayName(
      "Test createGraphSerialisable(Store, String, Schema, StoreProperties, List, String) with 'store', 'graphId', 'schema', 'storeProperties', 'parentSchemaIds', 'parentStorePropertiesId'")
  @Tag("MaintainedByDiffblue")
  void
      testCreateGraphSerialisableWithStoreGraphIdSchemaStorePropertiesParentSchemaIdsParentStorePropertiesId5() {
    // Arrange
    GraphDelegate graphDelegate = new GraphDelegate();

    TestStoreImpl store = new TestStoreImpl();
    store.setGraphLibrary(null);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> graphDelegate.createGraphSerialisable(store, null, new Schema(), null, null, null));
  }

  /**
   * Test {@link GraphDelegate#createGraphSerialisable(Store, String, Schema, StoreProperties, List,
   * String)} with {@code store}, {@code graphId}, {@code schema}, {@code storeProperties}, {@code
   * parentSchemaIds}, {@code parentStorePropertiesId}.
   *
   * <p>Method under test: {@link GraphDelegate#createGraphSerialisable(Store, String, Schema,
   * StoreProperties, List, String)}
   */
  @Test
  @DisplayName(
      "Test createGraphSerialisable(Store, String, Schema, StoreProperties, List, String) with 'store', 'graphId', 'schema', 'storeProperties', 'parentSchemaIds', 'parentStorePropertiesId'")
  @Tag("MaintainedByDiffblue")
  void
      testCreateGraphSerialisableWithStoreGraphIdSchemaStorePropertiesParentSchemaIdsParentStorePropertiesId6()
          throws UnsupportedEncodingException {
    // Arrange
    GraphDelegate graphDelegate = new GraphDelegate();

    TestStoreImpl store = new TestStoreImpl();
    store.setGraphLibrary(null);
    Schema schema = new Schema();

    // Act
    GraphSerialisable actualCreateGraphSerialisableResult =
        graphDelegate.createGraphSerialisable(
            store, "42", schema, new StoreProperties(), null, null);

    // Assert
    assertEquals(124, actualCreateGraphSerialisableResult.getSerialisedConfig().length);
    assertArrayEquals(
        "{\n  \"types\" : { }\n}".getBytes("UTF-8"),
        actualCreateGraphSerialisableResult.getSerialisedSchema());
  }

  /**
   * Test {@link GraphDelegate#createGraphSerialisable(Store, String, Schema, StoreProperties, List,
   * String)} with {@code store}, {@code graphId}, {@code schema}, {@code storeProperties}, {@code
   * parentSchemaIds}, {@code parentStorePropertiesId}.
   *
   * <p>Method under test: {@link GraphDelegate#createGraphSerialisable(Store, String, Schema,
   * StoreProperties, List, String)}
   */
  @Test
  @DisplayName(
      "Test createGraphSerialisable(Store, String, Schema, StoreProperties, List, String) with 'store', 'graphId', 'schema', 'storeProperties', 'parentSchemaIds', 'parentStorePropertiesId'")
  @Tag("MaintainedByDiffblue")
  void
      testCreateGraphSerialisableWithStoreGraphIdSchemaStorePropertiesParentSchemaIdsParentStorePropertiesId7() {
    // Arrange
    GraphDelegate graphDelegate = new GraphDelegate();

    TestStoreImpl store = new TestStoreImpl();
    store.setGraphLibrary(new FileGraphLibrary());
    Schema schema = new Schema();
    StoreProperties storeProperties = new StoreProperties();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            graphDelegate.createGraphSerialisable(
                store, "42", schema, storeProperties, new ArrayList<>(), "42"));
  }

  /**
   * Test {@link GraphDelegate#createGraphSerialisable(Store, String, Schema, StoreProperties, List,
   * String)} with {@code store}, {@code graphId}, {@code schema}, {@code storeProperties}, {@code
   * parentSchemaIds}, {@code parentStorePropertiesId}.
   *
   * <p>Method under test: {@link GraphDelegate#createGraphSerialisable(Store, String, Schema,
   * StoreProperties, List, String)}
   */
  @Test
  @DisplayName(
      "Test createGraphSerialisable(Store, String, Schema, StoreProperties, List, String) with 'store', 'graphId', 'schema', 'storeProperties', 'parentSchemaIds', 'parentStorePropertiesId'")
  @Tag("MaintainedByDiffblue")
  void
      testCreateGraphSerialisableWithStoreGraphIdSchemaStorePropertiesParentSchemaIdsParentStorePropertiesId8()
          throws UnsupportedEncodingException {
    // Arrange
    GraphDelegate graphDelegate = new GraphDelegate();

    TestStoreImpl store = new TestStoreImpl();
    store.setGraphLibrary(new FileGraphLibrary());
    Schema schema = new Schema();

    // Act
    GraphSerialisable actualCreateGraphSerialisableResult =
        graphDelegate.createGraphSerialisable(
            store, "42", schema, new StoreProperties(), null, null);

    // Assert
    assertEquals(155, actualCreateGraphSerialisableResult.getSerialisedConfig().length);
    assertArrayEquals(
        "{\n  \"types\" : { }\n}".getBytes("UTF-8"),
        actualCreateGraphSerialisableResult.getSerialisedSchema());
  }

  /**
   * Test {@link GraphDelegate#createGraphSerialisable(Store, String, Schema, StoreProperties, List,
   * String)} with {@code store}, {@code graphId}, {@code schema}, {@code storeProperties}, {@code
   * parentSchemaIds}, {@code parentStorePropertiesId}.
   *
   * <p>Method under test: {@link GraphDelegate#createGraphSerialisable(Store, String, Schema,
   * StoreProperties, List, String)}
   */
  @Test
  @DisplayName(
      "Test createGraphSerialisable(Store, String, Schema, StoreProperties, List, String) with 'store', 'graphId', 'schema', 'storeProperties', 'parentSchemaIds', 'parentStorePropertiesId'")
  @Tag("MaintainedByDiffblue")
  void
      testCreateGraphSerialisableWithStoreGraphIdSchemaStorePropertiesParentSchemaIdsParentStorePropertiesId9()
          throws UnsupportedEncodingException {
    // Arrange
    GraphDelegate graphDelegate = new GraphDelegate();

    TestStoreImpl store = new TestStoreImpl();
    store.setGraphLibrary(new HashMapGraphLibrary());
    Schema schema = new Schema();

    // Act
    GraphSerialisable actualCreateGraphSerialisableResult =
        graphDelegate.createGraphSerialisable(
            store, "42", schema, new StoreProperties(), null, null);

    // Assert
    assertEquals(129, actualCreateGraphSerialisableResult.getSerialisedConfig().length);
    assertArrayEquals(
        "{\n  \"types\" : { }\n}".getBytes("UTF-8"),
        actualCreateGraphSerialisableResult.getSerialisedSchema());
  }

  /**
   * Test {@link GraphDelegate#createGraphSerialisable(Store, String, Schema, StoreProperties, List,
   * String)} with {@code store}, {@code graphId}, {@code schema}, {@code storeProperties}, {@code
   * parentSchemaIds}, {@code parentStorePropertiesId}.
   *
   * <p>Method under test: {@link GraphDelegate#createGraphSerialisable(Store, String, Schema,
   * StoreProperties, List, String)}
   */
  @Test
  @DisplayName(
      "Test createGraphSerialisable(Store, String, Schema, StoreProperties, List, String) with 'store', 'graphId', 'schema', 'storeProperties', 'parentSchemaIds', 'parentStorePropertiesId'")
  @Tag("MaintainedByDiffblue")
  void
      testCreateGraphSerialisableWithStoreGraphIdSchemaStorePropertiesParentSchemaIdsParentStorePropertiesId10()
          throws UnsupportedEncodingException {
    // Arrange
    GraphDelegate graphDelegate = new GraphDelegate();

    TestStoreImpl store = new TestStoreImpl();
    store.setGraphLibrary(new NoGraphLibrary());
    Schema schema = new Schema();

    // Act
    GraphSerialisable actualCreateGraphSerialisableResult =
        graphDelegate.createGraphSerialisable(
            store, "42", schema, new StoreProperties(), null, null);

    // Assert
    assertEquals(124, actualCreateGraphSerialisableResult.getSerialisedConfig().length);
    assertArrayEquals(
        "{\n  \"types\" : { }\n}".getBytes("UTF-8"),
        actualCreateGraphSerialisableResult.getSerialisedSchema());
  }

  /**
   * Test {@link GraphDelegate#createGraphSerialisable(Store, String, Schema, StoreProperties, List,
   * String, GraphHook[])} with {@code store}, {@code graphId}, {@code schema}, {@code
   * storeProperties}, {@code parentSchemaIds}, {@code parentStorePropertiesId}, {@code hooks}.
   *
   * <p>Method under test: {@link GraphDelegate#createGraphSerialisable(Store, String, Schema,
   * StoreProperties, List, String, GraphHook[])}
   */
  @Test
  @DisplayName(
      "Test createGraphSerialisable(Store, String, Schema, StoreProperties, List, String, GraphHook[]) with 'store', 'graphId', 'schema', 'storeProperties', 'parentSchemaIds', 'parentStorePropertiesId', 'hooks'")
  @Tag("MaintainedByDiffblue")
  void
      testCreateGraphSerialisableWithStoreGraphIdSchemaStorePropertiesParentSchemaIdsParentStorePropertiesIdHooks() {
    // Arrange
    GraphDelegate graphDelegate = new GraphDelegate();
    TestStoreImpl store = new TestStoreImpl();
    Schema schema = new Schema();
    StoreProperties storeProperties = new StoreProperties();
    ArrayList<String> parentSchemaIds = new ArrayList<>();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            graphDelegate.createGraphSerialisable(
                store,
                "42",
                schema,
                storeProperties,
                parentSchemaIds,
                "42",
                new AddOperationsToChain()));
  }

  /**
   * Test {@link GraphDelegate#createGraphSerialisable(Store, String, Schema, StoreProperties, List,
   * String, GraphHook[])} with {@code store}, {@code graphId}, {@code schema}, {@code
   * storeProperties}, {@code parentSchemaIds}, {@code parentStorePropertiesId}, {@code hooks}.
   *
   * <p>Method under test: {@link GraphDelegate#createGraphSerialisable(Store, String, Schema,
   * StoreProperties, List, String, GraphHook[])}
   */
  @Test
  @DisplayName(
      "Test createGraphSerialisable(Store, String, Schema, StoreProperties, List, String, GraphHook[]) with 'store', 'graphId', 'schema', 'storeProperties', 'parentSchemaIds', 'parentStorePropertiesId', 'hooks'")
  @Tag("MaintainedByDiffblue")
  void
      testCreateGraphSerialisableWithStoreGraphIdSchemaStorePropertiesParentSchemaIdsParentStorePropertiesIdHooks2() {
    // Arrange
    GraphDelegate graphDelegate = new GraphDelegate();

    TestStoreImpl store = new TestStoreImpl();
    store.setGraphLibrary(null);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> graphDelegate.createGraphSerialisable(store, null, null, null, null, null, null));
  }

  /**
   * Test {@link GraphDelegate#createGraphSerialisable(Store, String, Schema, StoreProperties, List,
   * String, GraphHook[])} with {@code store}, {@code graphId}, {@code schema}, {@code
   * storeProperties}, {@code parentSchemaIds}, {@code parentStorePropertiesId}, {@code hooks}.
   *
   * <p>Method under test: {@link GraphDelegate#createGraphSerialisable(Store, String, Schema,
   * StoreProperties, List, String, GraphHook[])}
   */
  @Test
  @DisplayName(
      "Test createGraphSerialisable(Store, String, Schema, StoreProperties, List, String, GraphHook[]) with 'store', 'graphId', 'schema', 'storeProperties', 'parentSchemaIds', 'parentStorePropertiesId', 'hooks'")
  @Tag("MaintainedByDiffblue")
  void
      testCreateGraphSerialisableWithStoreGraphIdSchemaStorePropertiesParentSchemaIdsParentStorePropertiesIdHooks3() {
    // Arrange
    GraphDelegate graphDelegate = new GraphDelegate();

    TestStoreImpl store = new TestStoreImpl();
    store.setGraphLibrary(null);

    ArrayList<String> parentSchemaIds = new ArrayList<>();
    parentSchemaIds.add("Parent Schema Ids");

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            graphDelegate.createGraphSerialisable(
                store, null, null, null, parentSchemaIds, null, null));
  }

  /**
   * Test {@link GraphDelegate#createGraphSerialisable(Store, String, Schema, StoreProperties, List,
   * String, GraphHook[])} with {@code store}, {@code graphId}, {@code schema}, {@code
   * storeProperties}, {@code parentSchemaIds}, {@code parentStorePropertiesId}, {@code hooks}.
   *
   * <p>Method under test: {@link GraphDelegate#createGraphSerialisable(Store, String, Schema,
   * StoreProperties, List, String, GraphHook[])}
   */
  @Test
  @DisplayName(
      "Test createGraphSerialisable(Store, String, Schema, StoreProperties, List, String, GraphHook[]) with 'store', 'graphId', 'schema', 'storeProperties', 'parentSchemaIds', 'parentStorePropertiesId', 'hooks'")
  @Tag("MaintainedByDiffblue")
  void
      testCreateGraphSerialisableWithStoreGraphIdSchemaStorePropertiesParentSchemaIdsParentStorePropertiesIdHooks4() {
    // Arrange
    GraphDelegate graphDelegate = new GraphDelegate();

    TestStoreImpl store = new TestStoreImpl();
    store.setGraphLibrary(null);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            graphDelegate.createGraphSerialisable(
                store, null, null, new StoreProperties(), null, null, null));
  }

  /**
   * Test {@link GraphDelegate#createGraphSerialisable(Store, String, Schema, StoreProperties, List,
   * String, GraphHook[])} with {@code store}, {@code graphId}, {@code schema}, {@code
   * storeProperties}, {@code parentSchemaIds}, {@code parentStorePropertiesId}, {@code hooks}.
   *
   * <p>Method under test: {@link GraphDelegate#createGraphSerialisable(Store, String, Schema,
   * StoreProperties, List, String, GraphHook[])}
   */
  @Test
  @DisplayName(
      "Test createGraphSerialisable(Store, String, Schema, StoreProperties, List, String, GraphHook[]) with 'store', 'graphId', 'schema', 'storeProperties', 'parentSchemaIds', 'parentStorePropertiesId', 'hooks'")
  @Tag("MaintainedByDiffblue")
  void
      testCreateGraphSerialisableWithStoreGraphIdSchemaStorePropertiesParentSchemaIdsParentStorePropertiesIdHooks5() {
    // Arrange
    GraphDelegate graphDelegate = new GraphDelegate();

    TestStoreImpl store = new TestStoreImpl();
    store.setGraphLibrary(null);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            graphDelegate.createGraphSerialisable(
                store, null, new Schema(), null, null, null, null));
  }

  /**
   * Test {@link GraphDelegate#createGraphSerialisable(Store, String, Schema, StoreProperties, List,
   * String, GraphHook[])} with {@code store}, {@code graphId}, {@code schema}, {@code
   * storeProperties}, {@code parentSchemaIds}, {@code parentStorePropertiesId}, {@code hooks}.
   *
   * <p>Method under test: {@link GraphDelegate#createGraphSerialisable(Store, String, Schema,
   * StoreProperties, List, String, GraphHook[])}
   */
  @Test
  @DisplayName(
      "Test createGraphSerialisable(Store, String, Schema, StoreProperties, List, String, GraphHook[]) with 'store', 'graphId', 'schema', 'storeProperties', 'parentSchemaIds', 'parentStorePropertiesId', 'hooks'")
  @Tag("MaintainedByDiffblue")
  void
      testCreateGraphSerialisableWithStoreGraphIdSchemaStorePropertiesParentSchemaIdsParentStorePropertiesIdHooks6() {
    // Arrange
    GraphDelegate graphDelegate = new GraphDelegate();

    TestStoreImpl store = new TestStoreImpl();
    store.setGraphLibrary(new FileGraphLibrary());
    Schema schema = new Schema();
    StoreProperties storeProperties = new StoreProperties();
    ArrayList<String> parentSchemaIds = new ArrayList<>();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            graphDelegate.createGraphSerialisable(
                store,
                "42",
                schema,
                storeProperties,
                parentSchemaIds,
                "42",
                new AddOperationsToChain()));
  }

  /**
   * Test {@link GraphDelegate#createGraphSerialisable(Store, String, Schema, StoreProperties, List,
   * String, GraphHook[])} with {@code store}, {@code graphId}, {@code schema}, {@code
   * storeProperties}, {@code parentSchemaIds}, {@code parentStorePropertiesId}, {@code hooks}.
   *
   * <p>Method under test: {@link GraphDelegate#createGraphSerialisable(Store, String, Schema,
   * StoreProperties, List, String, GraphHook[])}
   */
  @Test
  @DisplayName(
      "Test createGraphSerialisable(Store, String, Schema, StoreProperties, List, String, GraphHook[]) with 'store', 'graphId', 'schema', 'storeProperties', 'parentSchemaIds', 'parentStorePropertiesId', 'hooks'")
  @Tag("MaintainedByDiffblue")
  void
      testCreateGraphSerialisableWithStoreGraphIdSchemaStorePropertiesParentSchemaIdsParentStorePropertiesIdHooks7()
          throws UnsupportedEncodingException {
    // Arrange
    GraphDelegate graphDelegate = new GraphDelegate();

    TestStoreImpl store = new TestStoreImpl();
    store.setGraphLibrary(null);
    Schema schema = new Schema();

    // Act
    GraphSerialisable actualCreateGraphSerialisableResult =
        graphDelegate.createGraphSerialisable(
            store, "42", schema, new StoreProperties(), null, null, null);

    // Assert
    assertEquals(124, actualCreateGraphSerialisableResult.getSerialisedConfig().length);
    assertArrayEquals(
        "{\n  \"types\" : { }\n}".getBytes("UTF-8"),
        actualCreateGraphSerialisableResult.getSerialisedSchema());
  }

  /**
   * Test {@link GraphDelegate#createGraphSerialisable(Store, String, Schema, StoreProperties, List,
   * String, GraphHook[])} with {@code store}, {@code graphId}, {@code schema}, {@code
   * storeProperties}, {@code parentSchemaIds}, {@code parentStorePropertiesId}, {@code hooks}.
   *
   * <p>Method under test: {@link GraphDelegate#createGraphSerialisable(Store, String, Schema,
   * StoreProperties, List, String, GraphHook[])}
   */
  @Test
  @DisplayName(
      "Test createGraphSerialisable(Store, String, Schema, StoreProperties, List, String, GraphHook[]) with 'store', 'graphId', 'schema', 'storeProperties', 'parentSchemaIds', 'parentStorePropertiesId', 'hooks'")
  @Tag("MaintainedByDiffblue")
  void
      testCreateGraphSerialisableWithStoreGraphIdSchemaStorePropertiesParentSchemaIdsParentStorePropertiesIdHooks8()
          throws UnsupportedEncodingException {
    // Arrange
    GraphDelegate graphDelegate = new GraphDelegate();

    TestStoreImpl store = new TestStoreImpl();
    store.setGraphLibrary(new FileGraphLibrary());
    Schema schema = new Schema();

    // Act
    GraphSerialisable actualCreateGraphSerialisableResult =
        graphDelegate.createGraphSerialisable(
            store, "42", schema, new StoreProperties(), null, null, null);

    // Assert
    assertEquals(155, actualCreateGraphSerialisableResult.getSerialisedConfig().length);
    assertArrayEquals(
        "{\n  \"types\" : { }\n}".getBytes("UTF-8"),
        actualCreateGraphSerialisableResult.getSerialisedSchema());
  }

  /**
   * Test {@link GraphDelegate#createGraphSerialisable(Store, String, Schema, StoreProperties, List,
   * String, GraphHook[])} with {@code store}, {@code graphId}, {@code schema}, {@code
   * storeProperties}, {@code parentSchemaIds}, {@code parentStorePropertiesId}, {@code hooks}.
   *
   * <p>Method under test: {@link GraphDelegate#createGraphSerialisable(Store, String, Schema,
   * StoreProperties, List, String, GraphHook[])}
   */
  @Test
  @DisplayName(
      "Test createGraphSerialisable(Store, String, Schema, StoreProperties, List, String, GraphHook[]) with 'store', 'graphId', 'schema', 'storeProperties', 'parentSchemaIds', 'parentStorePropertiesId', 'hooks'")
  @Tag("MaintainedByDiffblue")
  void
      testCreateGraphSerialisableWithStoreGraphIdSchemaStorePropertiesParentSchemaIdsParentStorePropertiesIdHooks9()
          throws UnsupportedEncodingException {
    // Arrange
    GraphDelegate graphDelegate = new GraphDelegate();

    TestStoreImpl store = new TestStoreImpl();
    store.setGraphLibrary(new HashMapGraphLibrary());
    Schema schema = new Schema();

    // Act
    GraphSerialisable actualCreateGraphSerialisableResult =
        graphDelegate.createGraphSerialisable(
            store, "42", schema, new StoreProperties(), null, null, null);

    // Assert
    assertEquals(129, actualCreateGraphSerialisableResult.getSerialisedConfig().length);
    assertArrayEquals(
        "{\n  \"types\" : { }\n}".getBytes("UTF-8"),
        actualCreateGraphSerialisableResult.getSerialisedSchema());
  }

  /**
   * Test {@link GraphDelegate#createGraphSerialisable(Store, String, Schema, StoreProperties, List,
   * String, GraphHook[])} with {@code store}, {@code graphId}, {@code schema}, {@code
   * storeProperties}, {@code parentSchemaIds}, {@code parentStorePropertiesId}, {@code hooks}.
   *
   * <p>Method under test: {@link GraphDelegate#createGraphSerialisable(Store, String, Schema,
   * StoreProperties, List, String, GraphHook[])}
   */
  @Test
  @DisplayName(
      "Test createGraphSerialisable(Store, String, Schema, StoreProperties, List, String, GraphHook[]) with 'store', 'graphId', 'schema', 'storeProperties', 'parentSchemaIds', 'parentStorePropertiesId', 'hooks'")
  @Tag("MaintainedByDiffblue")
  void
      testCreateGraphSerialisableWithStoreGraphIdSchemaStorePropertiesParentSchemaIdsParentStorePropertiesIdHooks10()
          throws UnsupportedEncodingException {
    // Arrange
    GraphDelegate graphDelegate = new GraphDelegate();

    TestStoreImpl store = new TestStoreImpl();
    store.setGraphLibrary(new NoGraphLibrary());
    Schema schema = new Schema();

    // Act
    GraphSerialisable actualCreateGraphSerialisableResult =
        graphDelegate.createGraphSerialisable(
            store, "42", schema, new StoreProperties(), null, null, null);

    // Assert
    assertEquals(124, actualCreateGraphSerialisableResult.getSerialisedConfig().length);
    assertArrayEquals(
        "{\n  \"types\" : { }\n}".getBytes("UTF-8"),
        actualCreateGraphSerialisableResult.getSerialisedSchema());
  }

  /**
   * Test {@link GraphDelegate#createGraphSerialisable(Store, String, Schema, StoreProperties, List,
   * String, GraphHook[])} with {@code store}, {@code graphId}, {@code schema}, {@code
   * storeProperties}, {@code parentSchemaIds}, {@code parentStorePropertiesId}, {@code hooks}.
   *
   * <p>Method under test: {@link GraphDelegate#createGraphSerialisable(Store, String, Schema,
   * StoreProperties, List, String, GraphHook[])}
   */
  @Test
  @DisplayName(
      "Test createGraphSerialisable(Store, String, Schema, StoreProperties, List, String, GraphHook[]) with 'store', 'graphId', 'schema', 'storeProperties', 'parentSchemaIds', 'parentStorePropertiesId', 'hooks'")
  @Tag("MaintainedByDiffblue")
  void
      testCreateGraphSerialisableWithStoreGraphIdSchemaStorePropertiesParentSchemaIdsParentStorePropertiesIdHooks11()
          throws UnsupportedEncodingException {
    // Arrange
    GraphDelegate graphDelegate = new GraphDelegate();

    TestStoreImpl store = new TestStoreImpl();
    store.setGraphLibrary(null);
    Schema schema = new Schema();
    StoreProperties storeProperties = new StoreProperties();

    // Act
    GraphSerialisable actualCreateGraphSerialisableResult =
        graphDelegate.createGraphSerialisable(
            store, "42", schema, storeProperties, null, null, new AddOperationsToChain());

    // Assert
    assertEquals(299, actualCreateGraphSerialisableResult.getSerialisedConfig().length);
    assertArrayEquals(
        "{\n  \"types\" : { }\n}".getBytes("UTF-8"),
        actualCreateGraphSerialisableResult.getSerialisedSchema());
  }

  /**
   * Test {@link GraphDelegate#createGraphSerialisable(Store, String, Schema, StoreProperties, List,
   * String, GraphHook[])} with {@code store}, {@code graphId}, {@code schema}, {@code
   * storeProperties}, {@code parentSchemaIds}, {@code parentStorePropertiesId}, {@code hooks}.
   *
   * <p>Method under test: {@link GraphDelegate#createGraphSerialisable(Store, String, Schema,
   * StoreProperties, List, String, GraphHook[])}
   */
  @Test
  @DisplayName(
      "Test createGraphSerialisable(Store, String, Schema, StoreProperties, List, String, GraphHook[]) with 'store', 'graphId', 'schema', 'storeProperties', 'parentSchemaIds', 'parentStorePropertiesId', 'hooks'")
  @Tag("MaintainedByDiffblue")
  void
      testCreateGraphSerialisableWithStoreGraphIdSchemaStorePropertiesParentSchemaIdsParentStorePropertiesIdHooks12()
          throws UnsupportedEncodingException {
    // Arrange
    GraphDelegate graphDelegate = new GraphDelegate();

    TestStoreImpl store = new TestStoreImpl();
    store.setGraphLibrary(null);
    Schema schema = new Schema();
    StoreProperties storeProperties = new StoreProperties();

    UpdateViewHook.Builder builder = new UpdateViewHook.Builder();

    UpdateViewHook.Builder blackListElementGroupsResult =
        builder.blackListElementGroups(new HashSet<>());

    UpdateViewHook.Builder setViewToMergeResult =
        blackListElementGroupsResult.setViewToMerge(new View());

    UpdateViewHook.Builder whiteListElementGroupsResult =
        setViewToMergeResult.whiteListElementGroups(new HashSet<>());

    UpdateViewHook.Builder withDataAuthResult =
        whiteListElementGroupsResult.withDataAuth(new HashSet<>());

    UpdateViewHook.Builder withOpAuthResult = withDataAuthResult.withOpAuth(new HashSet<>());

    UpdateViewHook.Builder withoutDataAuthResult =
        withOpAuthResult.withoutDataAuth(new HashSet<>());

    // Act
    GraphSerialisable actualCreateGraphSerialisableResult =
        graphDelegate.createGraphSerialisable(
            store,
            "42",
            schema,
            storeProperties,
            null,
            null,
            withoutDataAuthResult.withoutOpAuth(new HashSet<>()).build());

    // Assert
    assertEquals(424, actualCreateGraphSerialisableResult.getSerialisedConfig().length);
    assertArrayEquals(
        "{\n  \"types\" : { }\n}".getBytes("UTF-8"),
        actualCreateGraphSerialisableResult.getSerialisedSchema());
  }

  /**
   * Test {@link GraphDelegate#createGraphInstance(Store, String, Schema, StoreProperties, List,
   * String)} with {@code store}, {@code graphId}, {@code schema}, {@code storeProperties}, {@code
   * parentSchemaIds}, {@code parentStorePropertiesId}.
   *
   * <p>Method under test: {@link GraphDelegate#createGraphInstance(Store, String, Schema,
   * StoreProperties, List, String)}
   */
  @Test
  @DisplayName(
      "Test createGraphInstance(Store, String, Schema, StoreProperties, List, String) with 'store', 'graphId', 'schema', 'storeProperties', 'parentSchemaIds', 'parentStorePropertiesId'")
  @Tag("MaintainedByDiffblue")
  void
      testCreateGraphInstanceWithStoreGraphIdSchemaStorePropertiesParentSchemaIdsParentStorePropertiesId() {
    // Arrange
    GraphDelegate graphDelegate = new GraphDelegate();
    TestStoreImpl store = new TestStoreImpl();
    Schema schema = new Schema();
    StoreProperties storeProperties = new StoreProperties();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            graphDelegate.createGraphInstance(
                store, "42", schema, storeProperties, new ArrayList<>(), "42"));
  }

  /**
   * Test {@link GraphDelegate#createGraphInstance(Store, String, Schema, StoreProperties, List,
   * String)} with {@code store}, {@code graphId}, {@code schema}, {@code storeProperties}, {@code
   * parentSchemaIds}, {@code parentStorePropertiesId}.
   *
   * <p>Method under test: {@link GraphDelegate#createGraphInstance(Store, String, Schema,
   * StoreProperties, List, String)}
   */
  @Test
  @DisplayName(
      "Test createGraphInstance(Store, String, Schema, StoreProperties, List, String) with 'store', 'graphId', 'schema', 'storeProperties', 'parentSchemaIds', 'parentStorePropertiesId'")
  @Tag("MaintainedByDiffblue")
  void
      testCreateGraphInstanceWithStoreGraphIdSchemaStorePropertiesParentSchemaIdsParentStorePropertiesId2() {
    // Arrange
    GraphDelegate graphDelegate = new GraphDelegate();

    TestStoreImpl store = new TestStoreImpl();
    store.setGraphLibrary(null);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> graphDelegate.createGraphInstance(store, null, null, null, null, null));
  }

  /**
   * Test {@link GraphDelegate#createGraphInstance(Store, String, Schema, StoreProperties, List,
   * String)} with {@code store}, {@code graphId}, {@code schema}, {@code storeProperties}, {@code
   * parentSchemaIds}, {@code parentStorePropertiesId}.
   *
   * <p>Method under test: {@link GraphDelegate#createGraphInstance(Store, String, Schema,
   * StoreProperties, List, String)}
   */
  @Test
  @DisplayName(
      "Test createGraphInstance(Store, String, Schema, StoreProperties, List, String) with 'store', 'graphId', 'schema', 'storeProperties', 'parentSchemaIds', 'parentStorePropertiesId'")
  @Tag("MaintainedByDiffblue")
  void
      testCreateGraphInstanceWithStoreGraphIdSchemaStorePropertiesParentSchemaIdsParentStorePropertiesId3() {
    // Arrange
    GraphDelegate graphDelegate = new GraphDelegate();

    TestStoreImpl store = new TestStoreImpl();
    store.setGraphLibrary(null);

    ArrayList<String> parentSchemaIds = new ArrayList<>();
    parentSchemaIds.add("Parent Schema Ids");

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> graphDelegate.createGraphInstance(store, null, null, null, parentSchemaIds, null));
  }

  /**
   * Test {@link GraphDelegate#createGraphInstance(Store, String, Schema, StoreProperties, List,
   * String)} with {@code store}, {@code graphId}, {@code schema}, {@code storeProperties}, {@code
   * parentSchemaIds}, {@code parentStorePropertiesId}.
   *
   * <p>Method under test: {@link GraphDelegate#createGraphInstance(Store, String, Schema,
   * StoreProperties, List, String)}
   */
  @Test
  @DisplayName(
      "Test createGraphInstance(Store, String, Schema, StoreProperties, List, String) with 'store', 'graphId', 'schema', 'storeProperties', 'parentSchemaIds', 'parentStorePropertiesId'")
  @Tag("MaintainedByDiffblue")
  void
      testCreateGraphInstanceWithStoreGraphIdSchemaStorePropertiesParentSchemaIdsParentStorePropertiesId4() {
    // Arrange
    GraphDelegate graphDelegate = new GraphDelegate();

    TestStoreImpl store = new TestStoreImpl();
    store.setGraphLibrary(null);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            graphDelegate.createGraphInstance(
                store, null, null, new StoreProperties(), null, null));
  }

  /**
   * Test {@link GraphDelegate#createGraphInstance(Store, String, Schema, StoreProperties, List,
   * String)} with {@code store}, {@code graphId}, {@code schema}, {@code storeProperties}, {@code
   * parentSchemaIds}, {@code parentStorePropertiesId}.
   *
   * <p>Method under test: {@link GraphDelegate#createGraphInstance(Store, String, Schema,
   * StoreProperties, List, String)}
   */
  @Test
  @DisplayName(
      "Test createGraphInstance(Store, String, Schema, StoreProperties, List, String) with 'store', 'graphId', 'schema', 'storeProperties', 'parentSchemaIds', 'parentStorePropertiesId'")
  @Tag("MaintainedByDiffblue")
  void
      testCreateGraphInstanceWithStoreGraphIdSchemaStorePropertiesParentSchemaIdsParentStorePropertiesId5() {
    // Arrange
    GraphDelegate graphDelegate = new GraphDelegate();

    TestStoreImpl store = new TestStoreImpl();
    store.setGraphLibrary(null);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> graphDelegate.createGraphInstance(store, null, new Schema(), null, null, null));
  }

  /**
   * Test {@link GraphDelegate#createGraphInstance(Store, String, Schema, StoreProperties, List,
   * String)} with {@code store}, {@code graphId}, {@code schema}, {@code storeProperties}, {@code
   * parentSchemaIds}, {@code parentStorePropertiesId}.
   *
   * <p>Method under test: {@link GraphDelegate#createGraphInstance(Store, String, Schema,
   * StoreProperties, List, String)}
   */
  @Test
  @DisplayName(
      "Test createGraphInstance(Store, String, Schema, StoreProperties, List, String) with 'store', 'graphId', 'schema', 'storeProperties', 'parentSchemaIds', 'parentStorePropertiesId'")
  @Tag("MaintainedByDiffblue")
  void
      testCreateGraphInstanceWithStoreGraphIdSchemaStorePropertiesParentSchemaIdsParentStorePropertiesId6() {
    // Arrange
    GraphDelegate graphDelegate = new GraphDelegate();

    TestStoreImpl store = new TestStoreImpl();
    store.setGraphLibrary(new FileGraphLibrary());
    Schema schema = new Schema();
    StoreProperties storeProperties = new StoreProperties();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            graphDelegate.createGraphInstance(
                store, "42", schema, storeProperties, new ArrayList<>(), "42"));
  }

  /**
   * Test {@link GraphDelegate#createGraphInstance(Store, String, Schema, StoreProperties, List,
   * String, GraphHook[])} with {@code store}, {@code graphId}, {@code schema}, {@code
   * storeProperties}, {@code parentSchemaIds}, {@code parentStorePropertiesId}, {@code hooks}.
   *
   * <p>Method under test: {@link GraphDelegate#createGraphInstance(Store, String, Schema,
   * StoreProperties, List, String, GraphHook[])}
   */
  @Test
  @DisplayName(
      "Test createGraphInstance(Store, String, Schema, StoreProperties, List, String, GraphHook[]) with 'store', 'graphId', 'schema', 'storeProperties', 'parentSchemaIds', 'parentStorePropertiesId', 'hooks'")
  @Tag("MaintainedByDiffblue")
  void
      testCreateGraphInstanceWithStoreGraphIdSchemaStorePropertiesParentSchemaIdsParentStorePropertiesIdHooks() {
    // Arrange
    GraphDelegate graphDelegate = new GraphDelegate();
    TestStoreImpl store = new TestStoreImpl();
    Schema schema = new Schema();
    StoreProperties storeProperties = new StoreProperties();
    ArrayList<String> parentSchemaIds = new ArrayList<>();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            graphDelegate.createGraphInstance(
                store,
                "42",
                schema,
                storeProperties,
                parentSchemaIds,
                "42",
                new AddOperationsToChain()));
  }

  /**
   * Test {@link GraphDelegate#createGraphInstance(Store, String, Schema, StoreProperties, List,
   * String, GraphHook[])} with {@code store}, {@code graphId}, {@code schema}, {@code
   * storeProperties}, {@code parentSchemaIds}, {@code parentStorePropertiesId}, {@code hooks}.
   *
   * <p>Method under test: {@link GraphDelegate#createGraphInstance(Store, String, Schema,
   * StoreProperties, List, String, GraphHook[])}
   */
  @Test
  @DisplayName(
      "Test createGraphInstance(Store, String, Schema, StoreProperties, List, String, GraphHook[]) with 'store', 'graphId', 'schema', 'storeProperties', 'parentSchemaIds', 'parentStorePropertiesId', 'hooks'")
  @Tag("MaintainedByDiffblue")
  void
      testCreateGraphInstanceWithStoreGraphIdSchemaStorePropertiesParentSchemaIdsParentStorePropertiesIdHooks2() {
    // Arrange
    GraphDelegate graphDelegate = new GraphDelegate();

    TestStoreImpl store = new TestStoreImpl();
    store.setGraphLibrary(null);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> graphDelegate.createGraphInstance(store, null, null, null, null, null, null));
  }

  /**
   * Test {@link GraphDelegate#createGraphInstance(Store, String, Schema, StoreProperties, List,
   * String, GraphHook[])} with {@code store}, {@code graphId}, {@code schema}, {@code
   * storeProperties}, {@code parentSchemaIds}, {@code parentStorePropertiesId}, {@code hooks}.
   *
   * <p>Method under test: {@link GraphDelegate#createGraphInstance(Store, String, Schema,
   * StoreProperties, List, String, GraphHook[])}
   */
  @Test
  @DisplayName(
      "Test createGraphInstance(Store, String, Schema, StoreProperties, List, String, GraphHook[]) with 'store', 'graphId', 'schema', 'storeProperties', 'parentSchemaIds', 'parentStorePropertiesId', 'hooks'")
  @Tag("MaintainedByDiffblue")
  void
      testCreateGraphInstanceWithStoreGraphIdSchemaStorePropertiesParentSchemaIdsParentStorePropertiesIdHooks3() {
    // Arrange
    GraphDelegate graphDelegate = new GraphDelegate();

    TestStoreImpl store = new TestStoreImpl();
    store.setGraphLibrary(null);

    ArrayList<String> parentSchemaIds = new ArrayList<>();
    parentSchemaIds.add("Parent Schema Ids");

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            graphDelegate.createGraphInstance(
                store, null, null, null, parentSchemaIds, null, null));
  }

  /**
   * Test {@link GraphDelegate#createGraphInstance(Store, String, Schema, StoreProperties, List,
   * String, GraphHook[])} with {@code store}, {@code graphId}, {@code schema}, {@code
   * storeProperties}, {@code parentSchemaIds}, {@code parentStorePropertiesId}, {@code hooks}.
   *
   * <p>Method under test: {@link GraphDelegate#createGraphInstance(Store, String, Schema,
   * StoreProperties, List, String, GraphHook[])}
   */
  @Test
  @DisplayName(
      "Test createGraphInstance(Store, String, Schema, StoreProperties, List, String, GraphHook[]) with 'store', 'graphId', 'schema', 'storeProperties', 'parentSchemaIds', 'parentStorePropertiesId', 'hooks'")
  @Tag("MaintainedByDiffblue")
  void
      testCreateGraphInstanceWithStoreGraphIdSchemaStorePropertiesParentSchemaIdsParentStorePropertiesIdHooks4() {
    // Arrange
    GraphDelegate graphDelegate = new GraphDelegate();

    TestStoreImpl store = new TestStoreImpl();
    store.setGraphLibrary(null);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            graphDelegate.createGraphInstance(
                store, null, null, new StoreProperties(), null, null, null));
  }

  /**
   * Test {@link GraphDelegate#createGraphInstance(Store, String, Schema, StoreProperties, List,
   * String, GraphHook[])} with {@code store}, {@code graphId}, {@code schema}, {@code
   * storeProperties}, {@code parentSchemaIds}, {@code parentStorePropertiesId}, {@code hooks}.
   *
   * <p>Method under test: {@link GraphDelegate#createGraphInstance(Store, String, Schema,
   * StoreProperties, List, String, GraphHook[])}
   */
  @Test
  @DisplayName(
      "Test createGraphInstance(Store, String, Schema, StoreProperties, List, String, GraphHook[]) with 'store', 'graphId', 'schema', 'storeProperties', 'parentSchemaIds', 'parentStorePropertiesId', 'hooks'")
  @Tag("MaintainedByDiffblue")
  void
      testCreateGraphInstanceWithStoreGraphIdSchemaStorePropertiesParentSchemaIdsParentStorePropertiesIdHooks5() {
    // Arrange
    GraphDelegate graphDelegate = new GraphDelegate();

    TestStoreImpl store = new TestStoreImpl();
    store.setGraphLibrary(null);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> graphDelegate.createGraphInstance(store, null, new Schema(), null, null, null, null));
  }

  /**
   * Test {@link GraphDelegate#createGraphInstance(Store, String, Schema, StoreProperties, List,
   * String, GraphHook[])} with {@code store}, {@code graphId}, {@code schema}, {@code
   * storeProperties}, {@code parentSchemaIds}, {@code parentStorePropertiesId}, {@code hooks}.
   *
   * <p>Method under test: {@link GraphDelegate#createGraphInstance(Store, String, Schema,
   * StoreProperties, List, String, GraphHook[])}
   */
  @Test
  @DisplayName(
      "Test createGraphInstance(Store, String, Schema, StoreProperties, List, String, GraphHook[]) with 'store', 'graphId', 'schema', 'storeProperties', 'parentSchemaIds', 'parentStorePropertiesId', 'hooks'")
  @Tag("MaintainedByDiffblue")
  void
      testCreateGraphInstanceWithStoreGraphIdSchemaStorePropertiesParentSchemaIdsParentStorePropertiesIdHooks6() {
    // Arrange
    GraphDelegate graphDelegate = new GraphDelegate();

    TestStoreImpl store = new TestStoreImpl();
    store.setGraphLibrary(new FileGraphLibrary());
    Schema schema = new Schema();
    StoreProperties storeProperties = new StoreProperties();
    ArrayList<String> parentSchemaIds = new ArrayList<>();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            graphDelegate.createGraphInstance(
                store,
                "42",
                schema,
                storeProperties,
                parentSchemaIds,
                "42",
                new AddOperationsToChain()));
  }

  /**
   * Test {@link GraphDelegate#resolveStorePropertiesForGraph(Store, StoreProperties, String,
   * Pair)}.
   *
   * <ul>
   *   <li>Given {@link FileGraphLibrary#FileGraphLibrary()}.
   * </ul>
   *
   * <p>Method under test: {@link GraphDelegate#resolveStorePropertiesForGraph(Store,
   * StoreProperties, String, Pair)}
   */
  @Test
  @DisplayName(
      "Test resolveStorePropertiesForGraph(Store, StoreProperties, String, Pair); given FileGraphLibrary()")
  @Tag("MaintainedByDiffblue")
  void testResolveStorePropertiesForGraph_givenFileGraphLibrary() {
    // Arrange
    GraphDelegate graphDelegate = new GraphDelegate();

    TestStoreImpl store = new TestStoreImpl();
    store.setGraphLibrary(new FileGraphLibrary());

    // Act
    StoreProperties actualResolveStorePropertiesForGraphResult =
        graphDelegate.resolveStorePropertiesForGraph(store, null, null, null);

    // Assert
    assertEquals("", actualResolveStorePropertiesForGraphResult.getAdminAuth());
    assertEquals("", actualResolveStorePropertiesForGraphResult.getJsonSerialiserModules());
    assertEquals(
        "uk.gov.gchq.gaffer.store.StoreProperties",
        actualResolveStorePropertiesForGraphResult.getStorePropertiesClassName());
    assertEquals(
        "uk.gov.gchq.gaffer.store.schema.Schema",
        actualResolveStorePropertiesForGraphResult.getSchemaClassName());
    assertNull(actualResolveStorePropertiesForGraphResult.getStrictJson());
    assertNull(actualResolveStorePropertiesForGraphResult.getCacheServiceClass());
    assertNull(actualResolveStorePropertiesForGraphResult.getDefaultCacheServiceClass());
    assertNull(actualResolveStorePropertiesForGraphResult.getJobTrackerCacheServiceClass());
    assertNull(actualResolveStorePropertiesForGraphResult.getJsonSerialiserClass());
    assertNull(actualResolveStorePropertiesForGraphResult.getNamedOperationCacheServiceClass());
    assertNull(actualResolveStorePropertiesForGraphResult.getNamedViewCacheServiceClass());
    assertNull(actualResolveStorePropertiesForGraphResult.getOperationDeclarationPaths());
    assertNull(actualResolveStorePropertiesForGraphResult.getReflectionPackages());
    assertNull(actualResolveStorePropertiesForGraphResult.getStoreClass());
    Properties properties = actualResolveStorePropertiesForGraphResult.getProperties();
    assertEquals(1, properties.size());
    assertEquals(
        50, actualResolveStorePropertiesForGraphResult.getJobExecutorThreadCount().intValue());
    assertFalse(actualResolveStorePropertiesForGraphResult.getJobTrackerEnabled());
    assertFalse(actualResolveStorePropertiesForGraphResult.getRescheduleJobsOnStart());
    assertTrue(properties.containsKey("gaffer.store.properties.class"));
    assertTrue(actualResolveStorePropertiesForGraphResult.getNamedOperationEnabled());
    assertTrue(actualResolveStorePropertiesForGraphResult.getNamedViewEnabled());
    Class<StoreProperties> expectedStorePropertiesClass = StoreProperties.class;
    assertEquals(
        expectedStorePropertiesClass,
        actualResolveStorePropertiesForGraphResult.getStorePropertiesClass());
    Class<Schema> expectedSchemaClass = Schema.class;
    assertEquals(expectedSchemaClass, actualResolveStorePropertiesForGraphResult.getSchemaClass());
  }

  /**
   * Test {@link GraphDelegate#resolveStorePropertiesForGraph(Store, StoreProperties, String,
   * Pair)}.
   *
   * <ul>
   *   <li>Given {@link FileGraphLibrary#FileGraphLibrary()}.
   * </ul>
   *
   * <p>Method under test: {@link GraphDelegate#resolveStorePropertiesForGraph(Store,
   * StoreProperties, String, Pair)}
   */
  @Test
  @DisplayName(
      "Test resolveStorePropertiesForGraph(Store, StoreProperties, String, Pair); given FileGraphLibrary()")
  @Tag("MaintainedByDiffblue")
  void testResolveStorePropertiesForGraph_givenFileGraphLibrary2() {
    // Arrange
    GraphDelegate graphDelegate = new GraphDelegate();

    TestStoreImpl store = new TestStoreImpl();
    store.setGraphLibrary(new FileGraphLibrary());

    // Act
    StoreProperties actualResolveStorePropertiesForGraphResult =
        graphDelegate.resolveStorePropertiesForGraph(store, null, "42", null);

    // Assert
    assertEquals("", actualResolveStorePropertiesForGraphResult.getAdminAuth());
    assertEquals("", actualResolveStorePropertiesForGraphResult.getJsonSerialiserModules());
    assertEquals(
        "uk.gov.gchq.gaffer.store.StoreProperties",
        actualResolveStorePropertiesForGraphResult.getStorePropertiesClassName());
    assertEquals(
        "uk.gov.gchq.gaffer.store.schema.Schema",
        actualResolveStorePropertiesForGraphResult.getSchemaClassName());
    assertNull(actualResolveStorePropertiesForGraphResult.getStrictJson());
    assertNull(actualResolveStorePropertiesForGraphResult.getCacheServiceClass());
    assertNull(actualResolveStorePropertiesForGraphResult.getDefaultCacheServiceClass());
    assertNull(actualResolveStorePropertiesForGraphResult.getJobTrackerCacheServiceClass());
    assertNull(actualResolveStorePropertiesForGraphResult.getJsonSerialiserClass());
    assertNull(actualResolveStorePropertiesForGraphResult.getNamedOperationCacheServiceClass());
    assertNull(actualResolveStorePropertiesForGraphResult.getNamedViewCacheServiceClass());
    assertNull(actualResolveStorePropertiesForGraphResult.getOperationDeclarationPaths());
    assertNull(actualResolveStorePropertiesForGraphResult.getReflectionPackages());
    assertNull(actualResolveStorePropertiesForGraphResult.getStoreClass());
    Properties properties = actualResolveStorePropertiesForGraphResult.getProperties();
    assertEquals(1, properties.size());
    assertEquals(
        50, actualResolveStorePropertiesForGraphResult.getJobExecutorThreadCount().intValue());
    assertFalse(actualResolveStorePropertiesForGraphResult.getJobTrackerEnabled());
    assertFalse(actualResolveStorePropertiesForGraphResult.getRescheduleJobsOnStart());
    assertTrue(properties.containsKey("gaffer.store.properties.class"));
    assertTrue(actualResolveStorePropertiesForGraphResult.getNamedOperationEnabled());
    assertTrue(actualResolveStorePropertiesForGraphResult.getNamedViewEnabled());
    Class<StoreProperties> expectedStorePropertiesClass = StoreProperties.class;
    assertEquals(
        expectedStorePropertiesClass,
        actualResolveStorePropertiesForGraphResult.getStorePropertiesClass());
    Class<Schema> expectedSchemaClass = Schema.class;
    assertEquals(expectedSchemaClass, actualResolveStorePropertiesForGraphResult.getSchemaClass());
  }

  /**
   * Test {@link GraphDelegate#resolveStorePropertiesForGraph(Store, StoreProperties, String,
   * Pair)}.
   *
   * <ul>
   *   <li>Given {@link HashMapGraphLibrary} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link GraphDelegate#resolveStorePropertiesForGraph(Store,
   * StoreProperties, String, Pair)}
   */
  @Test
  @DisplayName(
      "Test resolveStorePropertiesForGraph(Store, StoreProperties, String, Pair); given HashMapGraphLibrary (default constructor)")
  @Tag("MaintainedByDiffblue")
  void testResolveStorePropertiesForGraph_givenHashMapGraphLibrary() {
    // Arrange
    GraphDelegate graphDelegate = new GraphDelegate();

    TestStoreImpl store = new TestStoreImpl();
    store.setGraphLibrary(new HashMapGraphLibrary());

    // Act
    StoreProperties actualResolveStorePropertiesForGraphResult =
        graphDelegate.resolveStorePropertiesForGraph(store, null, "42", null);

    // Assert
    assertEquals("", actualResolveStorePropertiesForGraphResult.getAdminAuth());
    assertEquals("", actualResolveStorePropertiesForGraphResult.getJsonSerialiserModules());
    assertEquals(
        "uk.gov.gchq.gaffer.store.StoreProperties",
        actualResolveStorePropertiesForGraphResult.getStorePropertiesClassName());
    assertEquals(
        "uk.gov.gchq.gaffer.store.schema.Schema",
        actualResolveStorePropertiesForGraphResult.getSchemaClassName());
    assertNull(actualResolveStorePropertiesForGraphResult.getStrictJson());
    assertNull(actualResolveStorePropertiesForGraphResult.getCacheServiceClass());
    assertNull(actualResolveStorePropertiesForGraphResult.getDefaultCacheServiceClass());
    assertNull(actualResolveStorePropertiesForGraphResult.getJobTrackerCacheServiceClass());
    assertNull(actualResolveStorePropertiesForGraphResult.getJsonSerialiserClass());
    assertNull(actualResolveStorePropertiesForGraphResult.getNamedOperationCacheServiceClass());
    assertNull(actualResolveStorePropertiesForGraphResult.getNamedViewCacheServiceClass());
    assertNull(actualResolveStorePropertiesForGraphResult.getOperationDeclarationPaths());
    assertNull(actualResolveStorePropertiesForGraphResult.getReflectionPackages());
    assertNull(actualResolveStorePropertiesForGraphResult.getStoreClass());
    Properties properties = actualResolveStorePropertiesForGraphResult.getProperties();
    assertEquals(1, properties.size());
    assertEquals(
        50, actualResolveStorePropertiesForGraphResult.getJobExecutorThreadCount().intValue());
    assertFalse(actualResolveStorePropertiesForGraphResult.getJobTrackerEnabled());
    assertFalse(actualResolveStorePropertiesForGraphResult.getRescheduleJobsOnStart());
    assertTrue(properties.containsKey("gaffer.store.properties.class"));
    assertTrue(actualResolveStorePropertiesForGraphResult.getNamedOperationEnabled());
    assertTrue(actualResolveStorePropertiesForGraphResult.getNamedViewEnabled());
    Class<StoreProperties> expectedStorePropertiesClass = StoreProperties.class;
    assertEquals(
        expectedStorePropertiesClass,
        actualResolveStorePropertiesForGraphResult.getStorePropertiesClass());
    Class<Schema> expectedSchemaClass = Schema.class;
    assertEquals(expectedSchemaClass, actualResolveStorePropertiesForGraphResult.getSchemaClass());
  }

  /**
   * Test {@link GraphDelegate#resolveStorePropertiesForGraph(Store, StoreProperties, String,
   * Pair)}.
   *
   * <ul>
   *   <li>Given {@link NoGraphLibrary} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link GraphDelegate#resolveStorePropertiesForGraph(Store,
   * StoreProperties, String, Pair)}
   */
  @Test
  @DisplayName(
      "Test resolveStorePropertiesForGraph(Store, StoreProperties, String, Pair); given NoGraphLibrary (default constructor)")
  @Tag("MaintainedByDiffblue")
  void testResolveStorePropertiesForGraph_givenNoGraphLibrary() {
    // Arrange
    GraphDelegate graphDelegate = new GraphDelegate();

    TestStoreImpl store = new TestStoreImpl();
    store.setGraphLibrary(new NoGraphLibrary());

    // Act
    StoreProperties actualResolveStorePropertiesForGraphResult =
        graphDelegate.resolveStorePropertiesForGraph(store, null, "42", null);

    // Assert
    assertEquals("", actualResolveStorePropertiesForGraphResult.getAdminAuth());
    assertEquals("", actualResolveStorePropertiesForGraphResult.getJsonSerialiserModules());
    assertEquals(
        "uk.gov.gchq.gaffer.store.StoreProperties",
        actualResolveStorePropertiesForGraphResult.getStorePropertiesClassName());
    assertEquals(
        "uk.gov.gchq.gaffer.store.schema.Schema",
        actualResolveStorePropertiesForGraphResult.getSchemaClassName());
    assertNull(actualResolveStorePropertiesForGraphResult.getStrictJson());
    assertNull(actualResolveStorePropertiesForGraphResult.getCacheServiceClass());
    assertNull(actualResolveStorePropertiesForGraphResult.getDefaultCacheServiceClass());
    assertNull(actualResolveStorePropertiesForGraphResult.getJobTrackerCacheServiceClass());
    assertNull(actualResolveStorePropertiesForGraphResult.getJsonSerialiserClass());
    assertNull(actualResolveStorePropertiesForGraphResult.getNamedOperationCacheServiceClass());
    assertNull(actualResolveStorePropertiesForGraphResult.getNamedViewCacheServiceClass());
    assertNull(actualResolveStorePropertiesForGraphResult.getOperationDeclarationPaths());
    assertNull(actualResolveStorePropertiesForGraphResult.getReflectionPackages());
    assertNull(actualResolveStorePropertiesForGraphResult.getStoreClass());
    Properties properties = actualResolveStorePropertiesForGraphResult.getProperties();
    assertEquals(1, properties.size());
    assertEquals(
        50, actualResolveStorePropertiesForGraphResult.getJobExecutorThreadCount().intValue());
    assertFalse(actualResolveStorePropertiesForGraphResult.getJobTrackerEnabled());
    assertFalse(actualResolveStorePropertiesForGraphResult.getRescheduleJobsOnStart());
    assertTrue(properties.containsKey("gaffer.store.properties.class"));
    assertTrue(actualResolveStorePropertiesForGraphResult.getNamedOperationEnabled());
    assertTrue(actualResolveStorePropertiesForGraphResult.getNamedViewEnabled());
    Class<StoreProperties> expectedStorePropertiesClass = StoreProperties.class;
    assertEquals(
        expectedStorePropertiesClass,
        actualResolveStorePropertiesForGraphResult.getStorePropertiesClass());
    Class<Schema> expectedSchemaClass = Schema.class;
    assertEquals(expectedSchemaClass, actualResolveStorePropertiesForGraphResult.getSchemaClass());
  }

  /**
   * Test {@link GraphDelegate#resolveStorePropertiesForGraph(Store, StoreProperties, String,
   * Pair)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link TestStoreImpl} (default constructor) GraphLibrary is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link GraphDelegate#resolveStorePropertiesForGraph(Store,
   * StoreProperties, String, Pair)}
   */
  @Test
  @DisplayName(
      "Test resolveStorePropertiesForGraph(Store, StoreProperties, String, Pair); given 'null'; when TestStoreImpl (default constructor) GraphLibrary is 'null'")
  @Tag("MaintainedByDiffblue")
  void testResolveStorePropertiesForGraph_givenNull_whenTestStoreImplGraphLibraryIsNull() {
    // Arrange
    GraphDelegate graphDelegate = new GraphDelegate();

    TestStoreImpl store = new TestStoreImpl();
    store.setGraphLibrary(null);

    // Act and Assert
    assertNull(graphDelegate.resolveStorePropertiesForGraph(store, null, null, null));
  }

  /**
   * Test {@link GraphDelegate#resolveStorePropertiesForGraph(Store, StoreProperties, String,
   * Pair)}.
   *
   * <ul>
   *   <li>When {@link StoreProperties#StoreProperties()}.
   *   <li>Then return {@link StoreProperties#StoreProperties()}.
   * </ul>
   *
   * <p>Method under test: {@link GraphDelegate#resolveStorePropertiesForGraph(Store,
   * StoreProperties, String, Pair)}
   */
  @Test
  @DisplayName(
      "Test resolveStorePropertiesForGraph(Store, StoreProperties, String, Pair); when StoreProperties(); then return StoreProperties()")
  @Tag("MaintainedByDiffblue")
  void testResolveStorePropertiesForGraph_whenStoreProperties_thenReturnStoreProperties() {
    // Arrange
    GraphDelegate graphDelegate = new GraphDelegate();

    TestStoreImpl store = new TestStoreImpl();
    store.setGraphLibrary(new FileGraphLibrary());
    StoreProperties properties = new StoreProperties();

    // Act
    StoreProperties actualResolveStorePropertiesForGraphResult =
        graphDelegate.resolveStorePropertiesForGraph(store, properties, null, null);

    // Assert
    assertEquals(properties, actualResolveStorePropertiesForGraphResult);
  }

  /**
   * Test {@link GraphDelegate#resolveStorePropertiesForGraph(Store, StoreProperties, String,
   * Pair)}.
   *
   * <ul>
   *   <li>When {@link TestStoreImpl} (default constructor).
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link GraphDelegate#resolveStorePropertiesForGraph(Store,
   * StoreProperties, String, Pair)}
   */
  @Test
  @DisplayName(
      "Test resolveStorePropertiesForGraph(Store, StoreProperties, String, Pair); when TestStoreImpl (default constructor); then return 'null'")
  @Tag("MaintainedByDiffblue")
  void testResolveStorePropertiesForGraph_whenTestStoreImpl_thenReturnNull() {
    // Arrange
    GraphDelegate graphDelegate = new GraphDelegate();
    TestStoreImpl store = new TestStoreImpl();
    StoreProperties properties = new StoreProperties();

    // Act and Assert
    assertNull(graphDelegate.resolveStorePropertiesForGraph(store, properties, "42", new Pair<>()));
  }

  /**
   * Test {@link GraphDelegate#resolveSchemaForGraph(Store, Schema, List, Pair)}.
   *
   * <ul>
   *   <li>Given {@link FileGraphLibrary#FileGraphLibrary()}.
   *   <li>Then return {@link Schema#Schema()}.
   * </ul>
   *
   * <p>Method under test: {@link GraphDelegate#resolveSchemaForGraph(Store, Schema, List, Pair)}
   */
  @Test
  @DisplayName(
      "Test resolveSchemaForGraph(Store, Schema, List, Pair); given FileGraphLibrary(); then return Schema()")
  @Tag("MaintainedByDiffblue")
  void testResolveSchemaForGraph_givenFileGraphLibrary_thenReturnSchema() {
    // Arrange
    GraphDelegate graphDelegate = new GraphDelegate();

    TestStoreImpl store = new TestStoreImpl();
    store.setGraphLibrary(new FileGraphLibrary());
    Schema schema = new Schema();

    // Act
    Schema actualResolveSchemaForGraphResult =
        graphDelegate.resolveSchemaForGraph(store, schema, null, null);

    // Assert
    assertEquals(schema, actualResolveSchemaForGraphResult);
  }

  /**
   * Test {@link GraphDelegate#resolveSchemaForGraph(Store, Schema, List, Pair)}.
   *
   * <ul>
   *   <li>Given {@link FileGraphLibrary#FileGraphLibrary()}.
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return {@link Schema#Schema()}.
   * </ul>
   *
   * <p>Method under test: {@link GraphDelegate#resolveSchemaForGraph(Store, Schema, List, Pair)}
   */
  @Test
  @DisplayName(
      "Test resolveSchemaForGraph(Store, Schema, List, Pair); given FileGraphLibrary(); when ArrayList(); then return Schema()")
  @Tag("MaintainedByDiffblue")
  void testResolveSchemaForGraph_givenFileGraphLibrary_whenArrayList_thenReturnSchema() {
    // Arrange
    GraphDelegate graphDelegate = new GraphDelegate();

    TestStoreImpl store = new TestStoreImpl();
    store.setGraphLibrary(new FileGraphLibrary());
    Schema schema = new Schema();

    // Act
    Schema actualResolveSchemaForGraphResult =
        graphDelegate.resolveSchemaForGraph(store, schema, new ArrayList<>(), null);

    // Assert
    assertEquals(schema, actualResolveSchemaForGraphResult);
  }

  /**
   * Test {@link GraphDelegate#resolveSchemaForGraph(Store, Schema, List, Pair)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link TestStoreImpl} (default constructor) GraphLibrary is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link GraphDelegate#resolveSchemaForGraph(Store, Schema, List, Pair)}
   */
  @Test
  @DisplayName(
      "Test resolveSchemaForGraph(Store, Schema, List, Pair); given 'null'; when TestStoreImpl (default constructor) GraphLibrary is 'null'")
  @Tag("MaintainedByDiffblue")
  void testResolveSchemaForGraph_givenNull_whenTestStoreImplGraphLibraryIsNull() {
    // Arrange
    GraphDelegate graphDelegate = new GraphDelegate();

    TestStoreImpl store = new TestStoreImpl();
    store.setGraphLibrary(null);
    Schema schema = new Schema();

    // Act
    Schema actualResolveSchemaForGraphResult =
        graphDelegate.resolveSchemaForGraph(store, schema, null, null);

    // Assert
    assertSame(schema, actualResolveSchemaForGraphResult);
  }

  /**
   * Test {@link GraphDelegate#resolveSchemaForGraph(Store, Schema, List, Pair)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link TestStoreImpl} (default constructor) GraphLibrary is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link GraphDelegate#resolveSchemaForGraph(Store, Schema, List, Pair)}
   */
  @Test
  @DisplayName(
      "Test resolveSchemaForGraph(Store, Schema, List, Pair); given 'null'; when TestStoreImpl (default constructor) GraphLibrary is 'null'")
  @Tag("MaintainedByDiffblue")
  void testResolveSchemaForGraph_givenNull_whenTestStoreImplGraphLibraryIsNull2() {
    // Arrange
    GraphDelegate graphDelegate = new GraphDelegate();

    TestStoreImpl store = new TestStoreImpl();
    store.setGraphLibrary(null);
    Schema schema = new Schema();

    ArrayList<String> parentSchemaIds = new ArrayList<>();
    parentSchemaIds.add(null);

    // Act
    Schema actualResolveSchemaForGraphResult =
        graphDelegate.resolveSchemaForGraph(store, schema, parentSchemaIds, null);

    // Assert
    assertSame(schema, actualResolveSchemaForGraphResult);
  }

  /**
   * Test {@link GraphDelegate#resolveSchemaForGraph(Store, Schema, List, Pair)}.
   *
   * <ul>
   *   <li>When {@link TestStoreImpl} (default constructor).
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link GraphDelegate#resolveSchemaForGraph(Store, Schema, List, Pair)}
   */
  @Test
  @DisplayName(
      "Test resolveSchemaForGraph(Store, Schema, List, Pair); when TestStoreImpl (default constructor); then return 'null'")
  @Tag("MaintainedByDiffblue")
  void testResolveSchemaForGraph_whenTestStoreImpl_thenReturnNull() {
    // Arrange
    GraphDelegate graphDelegate = new GraphDelegate();
    TestStoreImpl store = new TestStoreImpl();
    Schema schema = new Schema();
    ArrayList<String> parentSchemaIds = new ArrayList<>();

    // Act and Assert
    assertNull(graphDelegate.resolveSchemaForGraph(store, schema, parentSchemaIds, new Pair<>()));
  }

  /**
   * Test {@link GraphDelegate#validate(Store, String, Schema, StoreProperties, List, String)} with
   * {@code store}, {@code graphId}, {@code schema}, {@code storeProperties}, {@code
   * parentSchemaIds}, {@code parentStorePropertiesId}.
   *
   * <p>Method under test: {@link GraphDelegate#validate(Store, String, Schema, StoreProperties,
   * List, String)}
   */
  @Test
  @DisplayName(
      "Test validate(Store, String, Schema, StoreProperties, List, String) with 'store', 'graphId', 'schema', 'storeProperties', 'parentSchemaIds', 'parentStorePropertiesId'")
  @Tag("MaintainedByDiffblue")
  void testValidateWithStoreGraphIdSchemaStorePropertiesParentSchemaIdsParentStorePropertiesId() {
    // Arrange
    TestStoreImpl store = new TestStoreImpl();
    Schema schema = new Schema();
    StoreProperties storeProperties = new StoreProperties();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            GraphDelegate.validate(store, "42", schema, storeProperties, new ArrayList<>(), "42"));
  }

  /**
   * Test {@link GraphDelegate#validate(Store, String, Schema, StoreProperties, List, String)} with
   * {@code store}, {@code graphId}, {@code schema}, {@code storeProperties}, {@code
   * parentSchemaIds}, {@code parentStorePropertiesId}.
   *
   * <p>Method under test: {@link GraphDelegate#validate(Store, String, Schema, StoreProperties,
   * List, String)}
   */
  @Test
  @DisplayName(
      "Test validate(Store, String, Schema, StoreProperties, List, String) with 'store', 'graphId', 'schema', 'storeProperties', 'parentSchemaIds', 'parentStorePropertiesId'")
  @Tag("MaintainedByDiffblue")
  void testValidateWithStoreGraphIdSchemaStorePropertiesParentSchemaIdsParentStorePropertiesId2() {
    // Arrange
    TestStoreImpl store = new TestStoreImpl();
    store.setGraphLibrary(null);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> GraphDelegate.validate(store, null, null, null, null, null));
  }

  /**
   * Test {@link GraphDelegate#validate(Store, String, Schema, StoreProperties, List, String)} with
   * {@code store}, {@code graphId}, {@code schema}, {@code storeProperties}, {@code
   * parentSchemaIds}, {@code parentStorePropertiesId}.
   *
   * <p>Method under test: {@link GraphDelegate#validate(Store, String, Schema, StoreProperties,
   * List, String)}
   */
  @Test
  @DisplayName(
      "Test validate(Store, String, Schema, StoreProperties, List, String) with 'store', 'graphId', 'schema', 'storeProperties', 'parentSchemaIds', 'parentStorePropertiesId'")
  @Tag("MaintainedByDiffblue")
  void testValidateWithStoreGraphIdSchemaStorePropertiesParentSchemaIdsParentStorePropertiesId3() {
    // Arrange
    TestStoreImpl store = new TestStoreImpl();
    store.setGraphLibrary(null);

    ArrayList<String> parentSchemaIds = new ArrayList<>();
    parentSchemaIds.add("Parent Schema Ids");

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> GraphDelegate.validate(store, null, null, null, parentSchemaIds, null));
  }

  /**
   * Test {@link GraphDelegate#validate(Store, String, Schema, StoreProperties, List, String)} with
   * {@code store}, {@code graphId}, {@code schema}, {@code storeProperties}, {@code
   * parentSchemaIds}, {@code parentStorePropertiesId}.
   *
   * <p>Method under test: {@link GraphDelegate#validate(Store, String, Schema, StoreProperties,
   * List, String)}
   */
  @Test
  @DisplayName(
      "Test validate(Store, String, Schema, StoreProperties, List, String) with 'store', 'graphId', 'schema', 'storeProperties', 'parentSchemaIds', 'parentStorePropertiesId'")
  @Tag("MaintainedByDiffblue")
  void testValidateWithStoreGraphIdSchemaStorePropertiesParentSchemaIdsParentStorePropertiesId4() {
    // Arrange
    TestStoreImpl store = new TestStoreImpl();
    store.setGraphLibrary(null);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> GraphDelegate.validate(store, null, null, new StoreProperties(), null, null));
  }

  /**
   * Test {@link GraphDelegate#validate(Store, String, Schema, StoreProperties, List, String)} with
   * {@code store}, {@code graphId}, {@code schema}, {@code storeProperties}, {@code
   * parentSchemaIds}, {@code parentStorePropertiesId}.
   *
   * <p>Method under test: {@link GraphDelegate#validate(Store, String, Schema, StoreProperties,
   * List, String)}
   */
  @Test
  @DisplayName(
      "Test validate(Store, String, Schema, StoreProperties, List, String) with 'store', 'graphId', 'schema', 'storeProperties', 'parentSchemaIds', 'parentStorePropertiesId'")
  @Tag("MaintainedByDiffblue")
  void testValidateWithStoreGraphIdSchemaStorePropertiesParentSchemaIdsParentStorePropertiesId5() {
    // Arrange
    TestStoreImpl store = new TestStoreImpl();
    store.setGraphLibrary(null);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> GraphDelegate.validate(store, null, new Schema(), null, null, null));
  }

  /**
   * Test {@link GraphDelegate#validate(Store, String, Schema, StoreProperties, List, String)} with
   * {@code store}, {@code graphId}, {@code schema}, {@code storeProperties}, {@code
   * parentSchemaIds}, {@code parentStorePropertiesId}.
   *
   * <p>Method under test: {@link GraphDelegate#validate(Store, String, Schema, StoreProperties,
   * List, String)}
   */
  @Test
  @DisplayName(
      "Test validate(Store, String, Schema, StoreProperties, List, String) with 'store', 'graphId', 'schema', 'storeProperties', 'parentSchemaIds', 'parentStorePropertiesId'")
  @Tag("MaintainedByDiffblue")
  void testValidateWithStoreGraphIdSchemaStorePropertiesParentSchemaIdsParentStorePropertiesId6() {
    // Arrange
    TestStoreImpl store = new TestStoreImpl();
    store.setGraphLibrary(new FileGraphLibrary());
    Schema schema = new Schema();
    StoreProperties storeProperties = new StoreProperties();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            GraphDelegate.validate(store, "42", schema, storeProperties, new ArrayList<>(), "42"));
  }

  /**
   * Test {@link GraphDelegate#validate(Store, String, Schema, StoreProperties, List, String)} with
   * {@code store}, {@code graphId}, {@code schema}, {@code storeProperties}, {@code
   * parentSchemaIds}, {@code parentStorePropertiesId}.
   *
   * <p>Method under test: {@link GraphDelegate#validate(Store, String, Schema, StoreProperties,
   * List, String)}
   */
  @Test
  @DisplayName(
      "Test validate(Store, String, Schema, StoreProperties, List, String) with 'store', 'graphId', 'schema', 'storeProperties', 'parentSchemaIds', 'parentStorePropertiesId'")
  @Tag("MaintainedByDiffblue")
  void testValidateWithStoreGraphIdSchemaStorePropertiesParentSchemaIdsParentStorePropertiesId7() {
    // Arrange
    TestStoreImpl store = new TestStoreImpl();
    store.setGraphLibrary(new NoGraphLibrary());
    Schema schema = new Schema();
    StoreProperties storeProperties = new StoreProperties();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            GraphDelegate.validate(store, "42", schema, storeProperties, new ArrayList<>(), "42"));
  }

  /**
   * Test {@link GraphDelegate#validate(Store, String, Schema, StoreProperties, List, String, Pair)}
   * with {@code store}, {@code graphId}, {@code schema}, {@code storeProperties}, {@code
   * parentSchemaIds}, {@code parentStorePropertiesId}, {@code existingGraphPair}.
   *
   * <p>Method under test: {@link GraphDelegate#validate(Store, String, Schema, StoreProperties,
   * List, String, Pair)}
   */
  @Test
  @DisplayName(
      "Test validate(Store, String, Schema, StoreProperties, List, String, Pair) with 'store', 'graphId', 'schema', 'storeProperties', 'parentSchemaIds', 'parentStorePropertiesId', 'existingGraphPair'")
  @Tag("MaintainedByDiffblue")
  void
      testValidateWithStoreGraphIdSchemaStorePropertiesParentSchemaIdsParentStorePropertiesIdExistingGraphPair() {
    // Arrange
    TestStoreImpl store = new TestStoreImpl();
    Schema schema = new Schema();
    StoreProperties storeProperties = new StoreProperties();
    ArrayList<String> parentSchemaIds = new ArrayList<>();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            GraphDelegate.validate(
                store, "42", schema, storeProperties, parentSchemaIds, "42", new Pair<>()));
  }

  /**
   * Test {@link GraphDelegate#validate(Store, String, Schema, StoreProperties, List, String, Pair)}
   * with {@code store}, {@code graphId}, {@code schema}, {@code storeProperties}, {@code
   * parentSchemaIds}, {@code parentStorePropertiesId}, {@code existingGraphPair}.
   *
   * <p>Method under test: {@link GraphDelegate#validate(Store, String, Schema, StoreProperties,
   * List, String, Pair)}
   */
  @Test
  @DisplayName(
      "Test validate(Store, String, Schema, StoreProperties, List, String, Pair) with 'store', 'graphId', 'schema', 'storeProperties', 'parentSchemaIds', 'parentStorePropertiesId', 'existingGraphPair'")
  @Tag("MaintainedByDiffblue")
  void
      testValidateWithStoreGraphIdSchemaStorePropertiesParentSchemaIdsParentStorePropertiesIdExistingGraphPair2() {
    // Arrange
    TestStoreImpl store = new TestStoreImpl();
    store.setGraphLibrary(null);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> GraphDelegate.validate(store, "42", null, null, null, null, null));
  }

  /**
   * Test {@link GraphDelegate#validate(Store, String, Schema, StoreProperties, List, String, Pair)}
   * with {@code store}, {@code graphId}, {@code schema}, {@code storeProperties}, {@code
   * parentSchemaIds}, {@code parentStorePropertiesId}, {@code existingGraphPair}.
   *
   * <p>Method under test: {@link GraphDelegate#validate(Store, String, Schema, StoreProperties,
   * List, String, Pair)}
   */
  @Test
  @DisplayName(
      "Test validate(Store, String, Schema, StoreProperties, List, String, Pair) with 'store', 'graphId', 'schema', 'storeProperties', 'parentSchemaIds', 'parentStorePropertiesId', 'existingGraphPair'")
  @Tag("MaintainedByDiffblue")
  void
      testValidateWithStoreGraphIdSchemaStorePropertiesParentSchemaIdsParentStorePropertiesIdExistingGraphPair3() {
    // Arrange
    TestStoreImpl store = new TestStoreImpl();
    store.setGraphLibrary(null);

    ArrayList<String> parentSchemaIds = new ArrayList<>();
    parentSchemaIds.add(null);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> GraphDelegate.validate(store, "42", null, null, parentSchemaIds, null, null));
  }

  /**
   * Test {@link GraphDelegate#validate(Store, String, Schema, StoreProperties, List, String, Pair)}
   * with {@code store}, {@code graphId}, {@code schema}, {@code storeProperties}, {@code
   * parentSchemaIds}, {@code parentStorePropertiesId}, {@code existingGraphPair}.
   *
   * <p>Method under test: {@link GraphDelegate#validate(Store, String, Schema, StoreProperties,
   * List, String, Pair)}
   */
  @Test
  @DisplayName(
      "Test validate(Store, String, Schema, StoreProperties, List, String, Pair) with 'store', 'graphId', 'schema', 'storeProperties', 'parentSchemaIds', 'parentStorePropertiesId', 'existingGraphPair'")
  @Tag("MaintainedByDiffblue")
  void
      testValidateWithStoreGraphIdSchemaStorePropertiesParentSchemaIdsParentStorePropertiesIdExistingGraphPair4() {
    // Arrange
    TestStoreImpl store = new TestStoreImpl();
    store.setGraphLibrary(null);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> GraphDelegate.validate(store, "42", null, new StoreProperties(), null, null, null));
  }

  /**
   * Test {@link GraphDelegate#validate(Store, String, Schema, StoreProperties, List, String, Pair)}
   * with {@code store}, {@code graphId}, {@code schema}, {@code storeProperties}, {@code
   * parentSchemaIds}, {@code parentStorePropertiesId}, {@code existingGraphPair}.
   *
   * <p>Method under test: {@link GraphDelegate#validate(Store, String, Schema, StoreProperties,
   * List, String, Pair)}
   */
  @Test
  @DisplayName(
      "Test validate(Store, String, Schema, StoreProperties, List, String, Pair) with 'store', 'graphId', 'schema', 'storeProperties', 'parentSchemaIds', 'parentStorePropertiesId', 'existingGraphPair'")
  @Tag("MaintainedByDiffblue")
  void
      testValidateWithStoreGraphIdSchemaStorePropertiesParentSchemaIdsParentStorePropertiesIdExistingGraphPair5() {
    // Arrange
    TestStoreImpl store = new TestStoreImpl();
    store.setGraphLibrary(null);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> GraphDelegate.validate(store, "42", new Schema(), null, null, null, null));
  }

  /**
   * Test {@link GraphDelegate#validate(Store, String, Schema, StoreProperties, List, String, Pair)}
   * with {@code store}, {@code graphId}, {@code schema}, {@code storeProperties}, {@code
   * parentSchemaIds}, {@code parentStorePropertiesId}, {@code existingGraphPair}.
   *
   * <p>Method under test: {@link GraphDelegate#validate(Store, String, Schema, StoreProperties,
   * List, String, Pair)}
   */
  @Test
  @DisplayName(
      "Test validate(Store, String, Schema, StoreProperties, List, String, Pair) with 'store', 'graphId', 'schema', 'storeProperties', 'parentSchemaIds', 'parentStorePropertiesId', 'existingGraphPair'")
  @Tag("MaintainedByDiffblue")
  void
      testValidateWithStoreGraphIdSchemaStorePropertiesParentSchemaIdsParentStorePropertiesIdExistingGraphPair6() {
    // Arrange
    TestStoreImpl store = new TestStoreImpl();
    store.setGraphLibrary(new FileGraphLibrary());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> GraphDelegate.validate(store, "42", null, null, null, null, null));
  }

  /**
   * Test {@link GraphDelegate#validate(Store, String, Schema, StoreProperties, List, String, Pair)}
   * with {@code store}, {@code graphId}, {@code schema}, {@code storeProperties}, {@code
   * parentSchemaIds}, {@code parentStorePropertiesId}, {@code existingGraphPair}.
   *
   * <p>Method under test: {@link GraphDelegate#validate(Store, String, Schema, StoreProperties,
   * List, String, Pair)}
   */
  @Test
  @DisplayName(
      "Test validate(Store, String, Schema, StoreProperties, List, String, Pair) with 'store', 'graphId', 'schema', 'storeProperties', 'parentSchemaIds', 'parentStorePropertiesId', 'existingGraphPair'")
  @Tag("MaintainedByDiffblue")
  void
      testValidateWithStoreGraphIdSchemaStorePropertiesParentSchemaIdsParentStorePropertiesIdExistingGraphPair7() {
    // Arrange
    TestStoreImpl store = new TestStoreImpl();
    store.setGraphLibrary(new FileGraphLibrary());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> GraphDelegate.validate(store, "42", null, new StoreProperties(), null, null, null));
  }

  /**
   * Test {@link GraphDelegate#validate(Store, String, Schema, StoreProperties, List, String, Pair)}
   * with {@code store}, {@code graphId}, {@code schema}, {@code storeProperties}, {@code
   * parentSchemaIds}, {@code parentStorePropertiesId}, {@code existingGraphPair}.
   *
   * <p>Method under test: {@link GraphDelegate#validate(Store, String, Schema, StoreProperties,
   * List, String, Pair)}
   */
  @Test
  @DisplayName(
      "Test validate(Store, String, Schema, StoreProperties, List, String, Pair) with 'store', 'graphId', 'schema', 'storeProperties', 'parentSchemaIds', 'parentStorePropertiesId', 'existingGraphPair'")
  @Tag("MaintainedByDiffblue")
  void
      testValidateWithStoreGraphIdSchemaStorePropertiesParentSchemaIdsParentStorePropertiesIdExistingGraphPair8() {
    // Arrange
    TestStoreImpl store = new TestStoreImpl();
    store.setGraphLibrary(new FileGraphLibrary());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> GraphDelegate.validate(store, "42", new Schema(), null, null, null, null));
  }

  /**
   * Test {@link GraphDelegate#validate(Store, String, Schema, StoreProperties, List, String, Pair)}
   * with {@code store}, {@code graphId}, {@code schema}, {@code storeProperties}, {@code
   * parentSchemaIds}, {@code parentStorePropertiesId}, {@code existingGraphPair}.
   *
   * <p>Method under test: {@link GraphDelegate#validate(Store, String, Schema, StoreProperties,
   * List, String, Pair)}
   */
  @Test
  @DisplayName(
      "Test validate(Store, String, Schema, StoreProperties, List, String, Pair) with 'store', 'graphId', 'schema', 'storeProperties', 'parentSchemaIds', 'parentStorePropertiesId', 'existingGraphPair'")
  @Tag("MaintainedByDiffblue")
  void
      testValidateWithStoreGraphIdSchemaStorePropertiesParentSchemaIdsParentStorePropertiesIdExistingGraphPair9() {
    // Arrange
    TestStoreImpl store = new TestStoreImpl();
    store.setGraphLibrary(new FileGraphLibrary());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> GraphDelegate.validate(store, "42", null, null, null, "42", null));
  }

  /**
   * Test {@link GraphDelegate#validate(Store, String, Schema, StoreProperties, List, String, Pair)}
   * with {@code store}, {@code graphId}, {@code schema}, {@code storeProperties}, {@code
   * parentSchemaIds}, {@code parentStorePropertiesId}, {@code existingGraphPair}.
   *
   * <p>Method under test: {@link GraphDelegate#validate(Store, String, Schema, StoreProperties,
   * List, String, Pair)}
   */
  @Test
  @DisplayName(
      "Test validate(Store, String, Schema, StoreProperties, List, String, Pair) with 'store', 'graphId', 'schema', 'storeProperties', 'parentSchemaIds', 'parentStorePropertiesId', 'existingGraphPair'")
  @Tag("MaintainedByDiffblue")
  void
      testValidateWithStoreGraphIdSchemaStorePropertiesParentSchemaIdsParentStorePropertiesIdExistingGraphPair10()
          throws OverwritingException {
    // Arrange
    HashMapGraphLibrary library = new HashMapGraphLibrary();
    Schema schema = new Schema();
    library.add("42", schema, new StoreProperties());

    TestStoreImpl store = new TestStoreImpl();
    store.setGraphLibrary(library);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> GraphDelegate.validate(store, "42", null, null, null, "42", null));
  }

  /**
   * Test {@link GraphDelegate#validate(Store, String, Schema, StoreProperties, List, String, Pair)}
   * with {@code store}, {@code graphId}, {@code schema}, {@code storeProperties}, {@code
   * parentSchemaIds}, {@code parentStorePropertiesId}, {@code existingGraphPair}.
   *
   * <p>Method under test: {@link GraphDelegate#validate(Store, String, Schema, StoreProperties,
   * List, String, Pair)}
   */
  @Test
  @DisplayName(
      "Test validate(Store, String, Schema, StoreProperties, List, String, Pair) with 'store', 'graphId', 'schema', 'storeProperties', 'parentSchemaIds', 'parentStorePropertiesId', 'existingGraphPair'")
  @Tag("MaintainedByDiffblue")
  void
      testValidateWithStoreGraphIdSchemaStorePropertiesParentSchemaIdsParentStorePropertiesIdExistingGraphPair11()
          throws OverwritingException {
    // Arrange
    NoGraphLibrary library = new NoGraphLibrary();
    Schema schema = new Schema();
    library.add("42", schema, new StoreProperties());

    TestStoreImpl store = new TestStoreImpl();
    store.setGraphLibrary(library);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> GraphDelegate.validate(store, "42", null, null, null, "42", null));
  }

  /**
   * Test {@link GraphDelegate#validate(Store, String, Schema, StoreProperties, List, String, Pair,
   * ValidationResult)} with {@code store}, {@code graphId}, {@code schema}, {@code
   * storeProperties}, {@code parentSchemaIds}, {@code parentStorePropertiesId}, {@code
   * existingGraphPair}, {@code result}.
   *
   * <p>Method under test: {@link GraphDelegate#validate(Store, String, Schema, StoreProperties,
   * List, String, Pair, ValidationResult)}
   */
  @Test
  @DisplayName(
      "Test validate(Store, String, Schema, StoreProperties, List, String, Pair, ValidationResult) with 'store', 'graphId', 'schema', 'storeProperties', 'parentSchemaIds', 'parentStorePropertiesId', 'existingGraphPair', 'result'")
  @Tag("MaintainedByDiffblue")
  void
      testValidateWithStoreGraphIdSchemaStorePropertiesParentSchemaIdsParentStorePropertiesIdExistingGraphPairResult() {
    // Arrange
    TestStoreImpl store = new TestStoreImpl();
    Schema schema = new Schema();
    StoreProperties storeProperties = new StoreProperties();
    ArrayList<String> parentSchemaIds = new ArrayList<>();
    Pair<Schema, StoreProperties> existingGraphPair = new Pair<>();
    ValidationResult result = new ValidationResult("An error occurred");

    // Act
    ValidationResult actualValidateResult =
        GraphDelegate.validate(
            store, "42", schema, storeProperties, parentSchemaIds, "42", existingGraphPair, result);

    // Assert
    assertEquals(
        "Validation errors: \n"
            + "An error occurred\n"
            + " parentSchemaIds cannot be used without a GraphLibrary\n"
            + " parentStorePropertiesId cannot be used without a GraphLibrary",
        result.getErrorString());
    assertEquals(
        "Validation errors: \n"
            + "An error occurred\n"
            + " parentSchemaIds cannot be used without a GraphLibrary\n"
            + " parentStorePropertiesId cannot be used without a GraphLibrary",
        actualValidateResult.getErrorString());
    Set<String> errors = actualValidateResult.getErrors();
    assertEquals(3, errors.size());
    assertFalse(actualValidateResult.isValid());
    assertTrue(errors.contains(" parentSchemaIds cannot be used without a GraphLibrary"));
    assertTrue(errors.contains(" parentStorePropertiesId cannot be used without a GraphLibrary"));
    assertTrue(errors.contains("An error occurred"));
  }

  /**
   * Test {@link GraphDelegate#validateGraph(Store, String, Schema, StoreProperties, List, String)}
   * with {@code store}, {@code graphId}, {@code schema}, {@code storeProperties}, {@code
   * parentSchemaIds}, {@code parentStorePropertiesId}.
   *
   * <p>Method under test: {@link GraphDelegate#validateGraph(Store, String, Schema,
   * StoreProperties, List, String)}
   */
  @Test
  @DisplayName(
      "Test validateGraph(Store, String, Schema, StoreProperties, List, String) with 'store', 'graphId', 'schema', 'storeProperties', 'parentSchemaIds', 'parentStorePropertiesId'")
  @Tag("MaintainedByDiffblue")
  void
      testValidateGraphWithStoreGraphIdSchemaStorePropertiesParentSchemaIdsParentStorePropertiesId() {
    // Arrange
    GraphDelegate graphDelegate = new GraphDelegate();
    TestStoreImpl store = new TestStoreImpl();
    Schema schema = new Schema();
    StoreProperties storeProperties = new StoreProperties();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            graphDelegate.validateGraph(
                store, "42", schema, storeProperties, new ArrayList<>(), "42"));
  }

  /**
   * Test {@link GraphDelegate#validateGraph(Store, String, Schema, StoreProperties, List, String)}
   * with {@code store}, {@code graphId}, {@code schema}, {@code storeProperties}, {@code
   * parentSchemaIds}, {@code parentStorePropertiesId}.
   *
   * <p>Method under test: {@link GraphDelegate#validateGraph(Store, String, Schema,
   * StoreProperties, List, String)}
   */
  @Test
  @DisplayName(
      "Test validateGraph(Store, String, Schema, StoreProperties, List, String) with 'store', 'graphId', 'schema', 'storeProperties', 'parentSchemaIds', 'parentStorePropertiesId'")
  @Tag("MaintainedByDiffblue")
  void
      testValidateGraphWithStoreGraphIdSchemaStorePropertiesParentSchemaIdsParentStorePropertiesId2() {
    // Arrange
    GraphDelegate graphDelegate = new GraphDelegate();

    TestStoreImpl store = new TestStoreImpl();
    store.setGraphLibrary(null);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> graphDelegate.validateGraph(store, null, null, null, null, null));
  }

  /**
   * Test {@link GraphDelegate#validateGraph(Store, String, Schema, StoreProperties, List, String)}
   * with {@code store}, {@code graphId}, {@code schema}, {@code storeProperties}, {@code
   * parentSchemaIds}, {@code parentStorePropertiesId}.
   *
   * <p>Method under test: {@link GraphDelegate#validateGraph(Store, String, Schema,
   * StoreProperties, List, String)}
   */
  @Test
  @DisplayName(
      "Test validateGraph(Store, String, Schema, StoreProperties, List, String) with 'store', 'graphId', 'schema', 'storeProperties', 'parentSchemaIds', 'parentStorePropertiesId'")
  @Tag("MaintainedByDiffblue")
  void
      testValidateGraphWithStoreGraphIdSchemaStorePropertiesParentSchemaIdsParentStorePropertiesId3() {
    // Arrange
    GraphDelegate graphDelegate = new GraphDelegate();

    TestStoreImpl store = new TestStoreImpl();
    store.setGraphLibrary(null);

    ArrayList<String> parentSchemaIds = new ArrayList<>();
    parentSchemaIds.add("Parent Schema Ids");

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> graphDelegate.validateGraph(store, null, null, null, parentSchemaIds, null));
  }

  /**
   * Test {@link GraphDelegate#validateGraph(Store, String, Schema, StoreProperties, List, String)}
   * with {@code store}, {@code graphId}, {@code schema}, {@code storeProperties}, {@code
   * parentSchemaIds}, {@code parentStorePropertiesId}.
   *
   * <p>Method under test: {@link GraphDelegate#validateGraph(Store, String, Schema,
   * StoreProperties, List, String)}
   */
  @Test
  @DisplayName(
      "Test validateGraph(Store, String, Schema, StoreProperties, List, String) with 'store', 'graphId', 'schema', 'storeProperties', 'parentSchemaIds', 'parentStorePropertiesId'")
  @Tag("MaintainedByDiffblue")
  void
      testValidateGraphWithStoreGraphIdSchemaStorePropertiesParentSchemaIdsParentStorePropertiesId4() {
    // Arrange
    GraphDelegate graphDelegate = new GraphDelegate();

    TestStoreImpl store = new TestStoreImpl();
    store.setGraphLibrary(null);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> graphDelegate.validateGraph(store, null, null, new StoreProperties(), null, null));
  }

  /**
   * Test {@link GraphDelegate#validateGraph(Store, String, Schema, StoreProperties, List, String)}
   * with {@code store}, {@code graphId}, {@code schema}, {@code storeProperties}, {@code
   * parentSchemaIds}, {@code parentStorePropertiesId}.
   *
   * <p>Method under test: {@link GraphDelegate#validateGraph(Store, String, Schema,
   * StoreProperties, List, String)}
   */
  @Test
  @DisplayName(
      "Test validateGraph(Store, String, Schema, StoreProperties, List, String) with 'store', 'graphId', 'schema', 'storeProperties', 'parentSchemaIds', 'parentStorePropertiesId'")
  @Tag("MaintainedByDiffblue")
  void
      testValidateGraphWithStoreGraphIdSchemaStorePropertiesParentSchemaIdsParentStorePropertiesId5() {
    // Arrange
    GraphDelegate graphDelegate = new GraphDelegate();

    TestStoreImpl store = new TestStoreImpl();
    store.setGraphLibrary(null);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> graphDelegate.validateGraph(store, null, new Schema(), null, null, null));
  }

  /**
   * Test {@link GraphDelegate#validateGraph(Store, String, Schema, StoreProperties, List, String)}
   * with {@code store}, {@code graphId}, {@code schema}, {@code storeProperties}, {@code
   * parentSchemaIds}, {@code parentStorePropertiesId}.
   *
   * <p>Method under test: {@link GraphDelegate#validateGraph(Store, String, Schema,
   * StoreProperties, List, String)}
   */
  @Test
  @DisplayName(
      "Test validateGraph(Store, String, Schema, StoreProperties, List, String) with 'store', 'graphId', 'schema', 'storeProperties', 'parentSchemaIds', 'parentStorePropertiesId'")
  @Tag("MaintainedByDiffblue")
  void
      testValidateGraphWithStoreGraphIdSchemaStorePropertiesParentSchemaIdsParentStorePropertiesId6() {
    // Arrange
    GraphDelegate graphDelegate = new GraphDelegate();

    TestStoreImpl store = new TestStoreImpl();
    store.setGraphLibrary(new FileGraphLibrary());
    Schema schema = new Schema();
    StoreProperties storeProperties = new StoreProperties();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            graphDelegate.validateGraph(
                store, "42", schema, storeProperties, new ArrayList<>(), "42"));
  }

  /**
   * Test {@link GraphDelegate#validateGraph(Store, String, Schema, StoreProperties, List, String,
   * Pair)} with {@code store}, {@code graphId}, {@code schema}, {@code storeProperties}, {@code
   * parentSchemaIds}, {@code parentStorePropertiesId}, {@code existingGraphPair}.
   *
   * <p>Method under test: {@link GraphDelegate#validateGraph(Store, String, Schema,
   * StoreProperties, List, String, Pair)}
   */
  @Test
  @DisplayName(
      "Test validateGraph(Store, String, Schema, StoreProperties, List, String, Pair) with 'store', 'graphId', 'schema', 'storeProperties', 'parentSchemaIds', 'parentStorePropertiesId', 'existingGraphPair'")
  @Tag("MaintainedByDiffblue")
  void
      testValidateGraphWithStoreGraphIdSchemaStorePropertiesParentSchemaIdsParentStorePropertiesIdExistingGraphPair() {
    // Arrange
    GraphDelegate graphDelegate = new GraphDelegate();
    TestStoreImpl store = new TestStoreImpl();
    Schema schema = new Schema();
    StoreProperties storeProperties = new StoreProperties();
    ArrayList<String> parentSchemaIds = new ArrayList<>();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            graphDelegate.validateGraph(
                store, "42", schema, storeProperties, parentSchemaIds, "42", new Pair<>()));
  }

  /**
   * Test {@link GraphDelegate#validateGraph(Store, String, Schema, StoreProperties, List, String,
   * Pair)} with {@code store}, {@code graphId}, {@code schema}, {@code storeProperties}, {@code
   * parentSchemaIds}, {@code parentStorePropertiesId}, {@code existingGraphPair}.
   *
   * <p>Method under test: {@link GraphDelegate#validateGraph(Store, String, Schema,
   * StoreProperties, List, String, Pair)}
   */
  @Test
  @DisplayName(
      "Test validateGraph(Store, String, Schema, StoreProperties, List, String, Pair) with 'store', 'graphId', 'schema', 'storeProperties', 'parentSchemaIds', 'parentStorePropertiesId', 'existingGraphPair'")
  @Tag("MaintainedByDiffblue")
  void
      testValidateGraphWithStoreGraphIdSchemaStorePropertiesParentSchemaIdsParentStorePropertiesIdExistingGraphPair2() {
    // Arrange
    GraphDelegate graphDelegate = new GraphDelegate();

    TestStoreImpl store = new TestStoreImpl();
    store.setGraphLibrary(null);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> graphDelegate.validateGraph(store, "42", null, null, null, null, null));
  }

  /**
   * Test {@link GraphDelegate#validateGraph(Store, String, Schema, StoreProperties, List, String,
   * Pair)} with {@code store}, {@code graphId}, {@code schema}, {@code storeProperties}, {@code
   * parentSchemaIds}, {@code parentStorePropertiesId}, {@code existingGraphPair}.
   *
   * <p>Method under test: {@link GraphDelegate#validateGraph(Store, String, Schema,
   * StoreProperties, List, String, Pair)}
   */
  @Test
  @DisplayName(
      "Test validateGraph(Store, String, Schema, StoreProperties, List, String, Pair) with 'store', 'graphId', 'schema', 'storeProperties', 'parentSchemaIds', 'parentStorePropertiesId', 'existingGraphPair'")
  @Tag("MaintainedByDiffblue")
  void
      testValidateGraphWithStoreGraphIdSchemaStorePropertiesParentSchemaIdsParentStorePropertiesIdExistingGraphPair3() {
    // Arrange
    GraphDelegate graphDelegate = new GraphDelegate();

    TestStoreImpl store = new TestStoreImpl();
    store.setGraphLibrary(null);

    ArrayList<String> parentSchemaIds = new ArrayList<>();
    parentSchemaIds.add(null);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> graphDelegate.validateGraph(store, "42", null, null, parentSchemaIds, null, null));
  }

  /**
   * Test {@link GraphDelegate#validateGraph(Store, String, Schema, StoreProperties, List, String,
   * Pair)} with {@code store}, {@code graphId}, {@code schema}, {@code storeProperties}, {@code
   * parentSchemaIds}, {@code parentStorePropertiesId}, {@code existingGraphPair}.
   *
   * <p>Method under test: {@link GraphDelegate#validateGraph(Store, String, Schema,
   * StoreProperties, List, String, Pair)}
   */
  @Test
  @DisplayName(
      "Test validateGraph(Store, String, Schema, StoreProperties, List, String, Pair) with 'store', 'graphId', 'schema', 'storeProperties', 'parentSchemaIds', 'parentStorePropertiesId', 'existingGraphPair'")
  @Tag("MaintainedByDiffblue")
  void
      testValidateGraphWithStoreGraphIdSchemaStorePropertiesParentSchemaIdsParentStorePropertiesIdExistingGraphPair4() {
    // Arrange
    GraphDelegate graphDelegate = new GraphDelegate();

    TestStoreImpl store = new TestStoreImpl();
    store.setGraphLibrary(null);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            graphDelegate.validateGraph(
                store, "42", null, new StoreProperties(), null, null, null));
  }

  /**
   * Test {@link GraphDelegate#validateGraph(Store, String, Schema, StoreProperties, List, String,
   * Pair)} with {@code store}, {@code graphId}, {@code schema}, {@code storeProperties}, {@code
   * parentSchemaIds}, {@code parentStorePropertiesId}, {@code existingGraphPair}.
   *
   * <p>Method under test: {@link GraphDelegate#validateGraph(Store, String, Schema,
   * StoreProperties, List, String, Pair)}
   */
  @Test
  @DisplayName(
      "Test validateGraph(Store, String, Schema, StoreProperties, List, String, Pair) with 'store', 'graphId', 'schema', 'storeProperties', 'parentSchemaIds', 'parentStorePropertiesId', 'existingGraphPair'")
  @Tag("MaintainedByDiffblue")
  void
      testValidateGraphWithStoreGraphIdSchemaStorePropertiesParentSchemaIdsParentStorePropertiesIdExistingGraphPair5() {
    // Arrange
    GraphDelegate graphDelegate = new GraphDelegate();

    TestStoreImpl store = new TestStoreImpl();
    store.setGraphLibrary(null);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> graphDelegate.validateGraph(store, "42", new Schema(), null, null, null, null));
  }

  /**
   * Test {@link GraphDelegate#validateGraph(Store, String, Schema, StoreProperties, List, String,
   * Pair)} with {@code store}, {@code graphId}, {@code schema}, {@code storeProperties}, {@code
   * parentSchemaIds}, {@code parentStorePropertiesId}, {@code existingGraphPair}.
   *
   * <p>Method under test: {@link GraphDelegate#validateGraph(Store, String, Schema,
   * StoreProperties, List, String, Pair)}
   */
  @Test
  @DisplayName(
      "Test validateGraph(Store, String, Schema, StoreProperties, List, String, Pair) with 'store', 'graphId', 'schema', 'storeProperties', 'parentSchemaIds', 'parentStorePropertiesId', 'existingGraphPair'")
  @Tag("MaintainedByDiffblue")
  void
      testValidateGraphWithStoreGraphIdSchemaStorePropertiesParentSchemaIdsParentStorePropertiesIdExistingGraphPair6() {
    // Arrange
    GraphDelegate graphDelegate = new GraphDelegate();

    TestStoreImpl store = new TestStoreImpl();
    store.setGraphLibrary(new FileGraphLibrary());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> graphDelegate.validateGraph(store, "42", null, null, null, null, null));
  }

  /**
   * Test {@link GraphDelegate#validateGraph(Store, String, Schema, StoreProperties, List, String,
   * Pair)} with {@code store}, {@code graphId}, {@code schema}, {@code storeProperties}, {@code
   * parentSchemaIds}, {@code parentStorePropertiesId}, {@code existingGraphPair}.
   *
   * <p>Method under test: {@link GraphDelegate#validateGraph(Store, String, Schema,
   * StoreProperties, List, String, Pair)}
   */
  @Test
  @DisplayName(
      "Test validateGraph(Store, String, Schema, StoreProperties, List, String, Pair) with 'store', 'graphId', 'schema', 'storeProperties', 'parentSchemaIds', 'parentStorePropertiesId', 'existingGraphPair'")
  @Tag("MaintainedByDiffblue")
  void
      testValidateGraphWithStoreGraphIdSchemaStorePropertiesParentSchemaIdsParentStorePropertiesIdExistingGraphPair7() {
    // Arrange
    GraphDelegate graphDelegate = new GraphDelegate();

    TestStoreImpl store = new TestStoreImpl();
    store.setGraphLibrary(new FileGraphLibrary());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            graphDelegate.validateGraph(
                store, "42", null, new StoreProperties(), null, null, null));
  }

  /**
   * Test {@link GraphDelegate#validateGraph(Store, String, Schema, StoreProperties, List, String,
   * Pair)} with {@code store}, {@code graphId}, {@code schema}, {@code storeProperties}, {@code
   * parentSchemaIds}, {@code parentStorePropertiesId}, {@code existingGraphPair}.
   *
   * <p>Method under test: {@link GraphDelegate#validateGraph(Store, String, Schema,
   * StoreProperties, List, String, Pair)}
   */
  @Test
  @DisplayName(
      "Test validateGraph(Store, String, Schema, StoreProperties, List, String, Pair) with 'store', 'graphId', 'schema', 'storeProperties', 'parentSchemaIds', 'parentStorePropertiesId', 'existingGraphPair'")
  @Tag("MaintainedByDiffblue")
  void
      testValidateGraphWithStoreGraphIdSchemaStorePropertiesParentSchemaIdsParentStorePropertiesIdExistingGraphPair8() {
    // Arrange
    GraphDelegate graphDelegate = new GraphDelegate();

    TestStoreImpl store = new TestStoreImpl();
    store.setGraphLibrary(new FileGraphLibrary());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> graphDelegate.validateGraph(store, "42", new Schema(), null, null, null, null));
  }

  /**
   * Test {@link GraphDelegate#validateGraph(Store, String, Schema, StoreProperties, List, String,
   * Pair)} with {@code store}, {@code graphId}, {@code schema}, {@code storeProperties}, {@code
   * parentSchemaIds}, {@code parentStorePropertiesId}, {@code existingGraphPair}.
   *
   * <p>Method under test: {@link GraphDelegate#validateGraph(Store, String, Schema,
   * StoreProperties, List, String, Pair)}
   */
  @Test
  @DisplayName(
      "Test validateGraph(Store, String, Schema, StoreProperties, List, String, Pair) with 'store', 'graphId', 'schema', 'storeProperties', 'parentSchemaIds', 'parentStorePropertiesId', 'existingGraphPair'")
  @Tag("MaintainedByDiffblue")
  void
      testValidateGraphWithStoreGraphIdSchemaStorePropertiesParentSchemaIdsParentStorePropertiesIdExistingGraphPair9() {
    // Arrange
    GraphDelegate graphDelegate = new GraphDelegate();

    TestStoreImpl store = new TestStoreImpl();
    store.setGraphLibrary(new FileGraphLibrary());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> graphDelegate.validateGraph(store, "42", null, null, null, "42", null));
  }

  /**
   * Test {@link GraphDelegate#validateGraph(Store, String, Schema, StoreProperties, List, String,
   * Pair)} with {@code store}, {@code graphId}, {@code schema}, {@code storeProperties}, {@code
   * parentSchemaIds}, {@code parentStorePropertiesId}, {@code existingGraphPair}.
   *
   * <p>Method under test: {@link GraphDelegate#validateGraph(Store, String, Schema,
   * StoreProperties, List, String, Pair)}
   */
  @Test
  @DisplayName(
      "Test validateGraph(Store, String, Schema, StoreProperties, List, String, Pair) with 'store', 'graphId', 'schema', 'storeProperties', 'parentSchemaIds', 'parentStorePropertiesId', 'existingGraphPair'")
  @Tag("MaintainedByDiffblue")
  void
      testValidateGraphWithStoreGraphIdSchemaStorePropertiesParentSchemaIdsParentStorePropertiesIdExistingGraphPair10()
          throws OverwritingException {
    // Arrange
    GraphDelegate graphDelegate = new GraphDelegate();

    HashMapGraphLibrary library = new HashMapGraphLibrary();
    Schema schema = new Schema();
    library.add("42", schema, new StoreProperties());

    TestStoreImpl store = new TestStoreImpl();
    store.setGraphLibrary(library);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> graphDelegate.validateGraph(store, "42", null, null, null, "42", null));
  }

  /**
   * Test {@link GraphDelegate#validateGraph(Store, String, Schema, StoreProperties, List, String,
   * Pair)} with {@code store}, {@code graphId}, {@code schema}, {@code storeProperties}, {@code
   * parentSchemaIds}, {@code parentStorePropertiesId}, {@code existingGraphPair}.
   *
   * <p>Method under test: {@link GraphDelegate#validateGraph(Store, String, Schema,
   * StoreProperties, List, String, Pair)}
   */
  @Test
  @DisplayName(
      "Test validateGraph(Store, String, Schema, StoreProperties, List, String, Pair) with 'store', 'graphId', 'schema', 'storeProperties', 'parentSchemaIds', 'parentStorePropertiesId', 'existingGraphPair'")
  @Tag("MaintainedByDiffblue")
  void
      testValidateGraphWithStoreGraphIdSchemaStorePropertiesParentSchemaIdsParentStorePropertiesIdExistingGraphPair11()
          throws OverwritingException {
    // Arrange
    GraphDelegate graphDelegate = new GraphDelegate();

    NoGraphLibrary library = new NoGraphLibrary();
    Schema schema = new Schema();
    library.add("42", schema, new StoreProperties());

    TestStoreImpl store = new TestStoreImpl();
    store.setGraphLibrary(library);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> graphDelegate.validateGraph(store, "42", null, null, null, "42", null));
  }
}
