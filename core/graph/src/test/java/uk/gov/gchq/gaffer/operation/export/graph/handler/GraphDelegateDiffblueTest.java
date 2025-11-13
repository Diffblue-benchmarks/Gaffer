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

package uk.gov.gchq.gaffer.operation.export.graph.handler;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.commonutil.pair.Pair;
import uk.gov.gchq.gaffer.graph.GraphTest;
import uk.gov.gchq.gaffer.graph.GraphTest.TestStoreImpl;
import uk.gov.gchq.gaffer.graph.hook.AddOperationsToChain;
import uk.gov.gchq.gaffer.graph.hook.GraphHook;
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
   * Test BaseBuilder new {@link BaseBuilder} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of {@link BaseBuilder}
   */
  @Test
  @DisplayName("Test BaseBuilder new BaseBuilder (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void BaseBuilder.<init>()", "uk.gov.gchq.gaffer.graph.Graph BaseBuilder.build()"})
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
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then {@link BaseBuilder} (default constructor) {@link BaseBuilder#parentSchemaIds} Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseBuilder#parentSchemaIds(List)}
   */
  @Test
  @DisplayName("Test BaseBuilder parentSchemaIds(List); when ArrayList(); then BaseBuilder (default constructor) parentSchemaIds Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"BaseBuilder BaseBuilder.parentSchemaIds(List)"})
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
   * Test BaseBuilder {@link BaseBuilder#schema(Schema)}.
   * <p>
   * Method under test: {@link BaseBuilder#schema(Schema)}
   */
  @Test
  @DisplayName("Test BaseBuilder schema(Schema)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"BaseBuilder BaseBuilder.schema(Schema)"})
  void testBaseBuilderSchema() {
    // Arrange
    BaseBuilder<BaseBuilder> baseBuilder = new BaseBuilder<>();

    // Act and Assert
    assertSame(baseBuilder, baseBuilder.schema(new Schema()));
  }

  /**
   * Test BaseBuilder {@link BaseBuilder#storeProperties(StoreProperties)}.
   * <p>
   * Method under test: {@link BaseBuilder#storeProperties(StoreProperties)}
   */
  @Test
  @DisplayName("Test BaseBuilder storeProperties(StoreProperties)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"BaseBuilder BaseBuilder.storeProperties(StoreProperties)"})
  void testBaseBuilderStoreProperties() {
    // Arrange
    BaseBuilder<BaseBuilder> baseBuilder = new BaseBuilder<>();

    // Act and Assert
    assertSame(baseBuilder, baseBuilder.storeProperties(new StoreProperties()));
  }

  /**
   * Test BaseBuilder {@link BaseBuilder#_self()}.
   * <p>
   * Method under test: {@link BaseBuilder#_self()}
   */
  @Test
  @DisplayName("Test BaseBuilder _self()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"BaseBuilder BaseBuilder._self()"})
  void testBaseBuilder_self() {
    // Arrange
    BaseBuilder<BaseBuilder> baseBuilder = new BaseBuilder<>();

    // Act and Assert
    assertSame(baseBuilder, baseBuilder._self());
  }

  /**
   * Test Builder {@link Builder#hooks(GraphHook[])}.
   * <p>
   * Method under test: {@link Builder#hooks(GraphHook[])}
   */
  @Test
  @DisplayName("Test Builder hooks(GraphHook[])")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.hooks(GraphHook[])"})
  void testBuilderHooks() {
    // Arrange
    Builder builder = new Builder();

    // Act and Assert
    assertSame(builder, builder.hooks(new AddOperationsToChain()));
  }

  /**
   * Test Builder {@link Builder#_self()}.
   * <p>
   * Method under test: {@link Builder#_self()}
   */
  @Test
  @DisplayName("Test Builder _self()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder._self()"})
  void testBuilder_self() {
    // Arrange
    Builder builder = new Builder();

    // Act and Assert
    assertSame(builder, builder._self());
  }

  /**
   * Test {@link GraphDelegate#createGraph(Store, String, Schema, StoreProperties, List, String)}.
   * <ul>
   *   <li>When {@link TestStoreImpl} (default constructor).</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GraphDelegate#createGraph(Store, String, Schema, StoreProperties, List, String)}
   */
  @Test
  @DisplayName("Test createGraph(Store, String, Schema, StoreProperties, List, String); when TestStoreImpl (default constructor); then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "uk.gov.gchq.gaffer.graph.Graph GraphDelegate.createGraph(Store, String, Schema, StoreProperties, List, String)"})
  void testCreateGraph_whenTestStoreImpl_thenThrowIllegalArgumentException() {
    // Arrange
    TestStoreImpl store = new TestStoreImpl();
    Schema schema = new Schema();
    StoreProperties storeProperties = new StoreProperties();

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> GraphDelegate.createGraph(store, "42", schema, storeProperties, new ArrayList<>(), "42"));
  }

  /**
   * Test {@link GraphDelegate#createGraphSerialisable(Store, String, Schema, StoreProperties, List, String)} with {@code store}, {@code graphId}, {@code schema}, {@code storeProperties}, {@code parentSchemaIds}, {@code parentStorePropertiesId}.
   * <p>
   * Method under test: {@link GraphDelegate#createGraphSerialisable(Store, String, Schema, StoreProperties, List, String)}
   */
  @Test
  @DisplayName("Test createGraphSerialisable(Store, String, Schema, StoreProperties, List, String) with 'store', 'graphId', 'schema', 'storeProperties', 'parentSchemaIds', 'parentStorePropertiesId'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "uk.gov.gchq.gaffer.graph.GraphSerialisable GraphDelegate.createGraphSerialisable(Store, String, Schema, StoreProperties, List, String)"})
  void testCreateGraphSerialisableWithStoreGraphIdSchemaStorePropertiesParentSchemaIdsParentStorePropertiesId() {
    // Arrange
    GraphDelegate graphDelegate = new GraphDelegate();
    TestStoreImpl store = new TestStoreImpl();
    Schema schema = new Schema();
    StoreProperties storeProperties = new StoreProperties();

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> graphDelegate.createGraphSerialisable(store, "42", schema, storeProperties, new ArrayList<>(), "42"));
  }

  /**
   * Test {@link GraphDelegate#createGraphSerialisable(Store, String, Schema, StoreProperties, List, String, GraphHook[])} with {@code store}, {@code graphId}, {@code schema}, {@code storeProperties}, {@code parentSchemaIds}, {@code parentStorePropertiesId}, {@code hooks}.
   * <p>
   * Method under test: {@link GraphDelegate#createGraphSerialisable(Store, String, Schema, StoreProperties, List, String, GraphHook[])}
   */
  @Test
  @DisplayName("Test createGraphSerialisable(Store, String, Schema, StoreProperties, List, String, GraphHook[]) with 'store', 'graphId', 'schema', 'storeProperties', 'parentSchemaIds', 'parentStorePropertiesId', 'hooks'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "uk.gov.gchq.gaffer.graph.GraphSerialisable GraphDelegate.createGraphSerialisable(Store, String, Schema, StoreProperties, List, String, GraphHook[])"})
  void testCreateGraphSerialisableWithStoreGraphIdSchemaStorePropertiesParentSchemaIdsParentStorePropertiesIdHooks() {
    // Arrange
    GraphDelegate graphDelegate = new GraphDelegate();
    TestStoreImpl store = new TestStoreImpl();
    Schema schema = new Schema();
    StoreProperties storeProperties = new StoreProperties();
    ArrayList<String> parentSchemaIds = new ArrayList<>();

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> graphDelegate.createGraphSerialisable(store, "42", schema,
        storeProperties, parentSchemaIds, "42", new AddOperationsToChain()));
  }

  /**
   * Test {@link GraphDelegate#createGraphInstance(Store, String, Schema, StoreProperties, List, String)} with {@code store}, {@code graphId}, {@code schema}, {@code storeProperties}, {@code parentSchemaIds}, {@code parentStorePropertiesId}.
   * <p>
   * Method under test: {@link GraphDelegate#createGraphInstance(Store, String, Schema, StoreProperties, List, String)}
   */
  @Test
  @DisplayName("Test createGraphInstance(Store, String, Schema, StoreProperties, List, String) with 'store', 'graphId', 'schema', 'storeProperties', 'parentSchemaIds', 'parentStorePropertiesId'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "uk.gov.gchq.gaffer.graph.Graph GraphDelegate.createGraphInstance(Store, String, Schema, StoreProperties, List, String)"})
  void testCreateGraphInstanceWithStoreGraphIdSchemaStorePropertiesParentSchemaIdsParentStorePropertiesId() {
    // Arrange
    GraphDelegate graphDelegate = new GraphDelegate();
    TestStoreImpl store = new TestStoreImpl();
    Schema schema = new Schema();
    StoreProperties storeProperties = new StoreProperties();

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> graphDelegate.createGraphInstance(store, "42", schema, storeProperties, new ArrayList<>(), "42"));
  }

  /**
   * Test {@link GraphDelegate#createGraphInstance(Store, String, Schema, StoreProperties, List, String, GraphHook[])} with {@code store}, {@code graphId}, {@code schema}, {@code storeProperties}, {@code parentSchemaIds}, {@code parentStorePropertiesId}, {@code hooks}.
   * <p>
   * Method under test: {@link GraphDelegate#createGraphInstance(Store, String, Schema, StoreProperties, List, String, GraphHook[])}
   */
  @Test
  @DisplayName("Test createGraphInstance(Store, String, Schema, StoreProperties, List, String, GraphHook[]) with 'store', 'graphId', 'schema', 'storeProperties', 'parentSchemaIds', 'parentStorePropertiesId', 'hooks'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "uk.gov.gchq.gaffer.graph.Graph GraphDelegate.createGraphInstance(Store, String, Schema, StoreProperties, List, String, GraphHook[])"})
  void testCreateGraphInstanceWithStoreGraphIdSchemaStorePropertiesParentSchemaIdsParentStorePropertiesIdHooks() {
    // Arrange
    GraphDelegate graphDelegate = new GraphDelegate();
    TestStoreImpl store = new TestStoreImpl();
    Schema schema = new Schema();
    StoreProperties storeProperties = new StoreProperties();
    ArrayList<String> parentSchemaIds = new ArrayList<>();

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> graphDelegate.createGraphInstance(store, "42", schema,
        storeProperties, parentSchemaIds, "42", new AddOperationsToChain()));
  }

  /**
   * Test {@link GraphDelegate#resolveStorePropertiesForGraph(Store, StoreProperties, String, Pair)}.
   * <ul>
   *   <li>Given {@link FileGraphLibrary#FileGraphLibrary()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GraphDelegate#resolveStorePropertiesForGraph(Store, StoreProperties, String, Pair)}
   */
  @Test
  @DisplayName("Test resolveStorePropertiesForGraph(Store, StoreProperties, String, Pair); given FileGraphLibrary()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "StoreProperties GraphDelegate.resolveStorePropertiesForGraph(Store, StoreProperties, String, Pair)"})
  void testResolveStorePropertiesForGraph_givenFileGraphLibrary() {
    // Arrange
    GraphDelegate graphDelegate = new GraphDelegate();

    TestStoreImpl store = new TestStoreImpl();
    store.setGraphLibrary(new FileGraphLibrary());

    // Act
    StoreProperties actualResolveStorePropertiesForGraphResult = graphDelegate.resolveStorePropertiesForGraph(store,
        null, null, null);

    // Assert
    assertEquals("", actualResolveStorePropertiesForGraphResult.getAdminAuth());
    assertEquals("", actualResolveStorePropertiesForGraphResult.getJsonSerialiserModules());
    assertEquals("uk.gov.gchq.gaffer.store.StoreProperties",
        actualResolveStorePropertiesForGraphResult.getStorePropertiesClassName());
    assertEquals("uk.gov.gchq.gaffer.store.schema.Schema",
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
    assertEquals(50, actualResolveStorePropertiesForGraphResult.getJobExecutorThreadCount().intValue());
    assertFalse(actualResolveStorePropertiesForGraphResult.getJobTrackerEnabled());
    assertFalse(actualResolveStorePropertiesForGraphResult.getRescheduleJobsOnStart());
    assertTrue(properties.containsKey("gaffer.store.properties.class"));
    assertTrue(actualResolveStorePropertiesForGraphResult.getNamedOperationEnabled());
    assertTrue(actualResolveStorePropertiesForGraphResult.getNamedViewEnabled());
    Class<StoreProperties> expectedStorePropertiesClass = StoreProperties.class;
    assertEquals(expectedStorePropertiesClass, actualResolveStorePropertiesForGraphResult.getStorePropertiesClass());
    Class<Schema> expectedSchemaClass = Schema.class;
    assertEquals(expectedSchemaClass, actualResolveStorePropertiesForGraphResult.getSchemaClass());
  }

  /**
   * Test {@link GraphDelegate#resolveStorePropertiesForGraph(Store, StoreProperties, String, Pair)}.
   * <ul>
   *   <li>Given {@link FileGraphLibrary#FileGraphLibrary()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GraphDelegate#resolveStorePropertiesForGraph(Store, StoreProperties, String, Pair)}
   */
  @Test
  @DisplayName("Test resolveStorePropertiesForGraph(Store, StoreProperties, String, Pair); given FileGraphLibrary()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "StoreProperties GraphDelegate.resolveStorePropertiesForGraph(Store, StoreProperties, String, Pair)"})
  void testResolveStorePropertiesForGraph_givenFileGraphLibrary2() {
    // Arrange
    GraphDelegate graphDelegate = new GraphDelegate();

    TestStoreImpl store = new TestStoreImpl();
    store.setGraphLibrary(new FileGraphLibrary());

    // Act
    StoreProperties actualResolveStorePropertiesForGraphResult = graphDelegate.resolveStorePropertiesForGraph(store,
        null, "42", null);

    // Assert
    assertEquals("", actualResolveStorePropertiesForGraphResult.getAdminAuth());
    assertEquals("", actualResolveStorePropertiesForGraphResult.getJsonSerialiserModules());
    assertEquals("uk.gov.gchq.gaffer.store.StoreProperties",
        actualResolveStorePropertiesForGraphResult.getStorePropertiesClassName());
    assertEquals("uk.gov.gchq.gaffer.store.schema.Schema",
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
    assertEquals(50, actualResolveStorePropertiesForGraphResult.getJobExecutorThreadCount().intValue());
    assertFalse(actualResolveStorePropertiesForGraphResult.getJobTrackerEnabled());
    assertFalse(actualResolveStorePropertiesForGraphResult.getRescheduleJobsOnStart());
    assertTrue(properties.containsKey("gaffer.store.properties.class"));
    assertTrue(actualResolveStorePropertiesForGraphResult.getNamedOperationEnabled());
    assertTrue(actualResolveStorePropertiesForGraphResult.getNamedViewEnabled());
    Class<StoreProperties> expectedStorePropertiesClass = StoreProperties.class;
    assertEquals(expectedStorePropertiesClass, actualResolveStorePropertiesForGraphResult.getStorePropertiesClass());
    Class<Schema> expectedSchemaClass = Schema.class;
    assertEquals(expectedSchemaClass, actualResolveStorePropertiesForGraphResult.getSchemaClass());
  }

  /**
   * Test {@link GraphDelegate#resolveStorePropertiesForGraph(Store, StoreProperties, String, Pair)}.
   * <ul>
   *   <li>Given {@link HashMapGraphLibrary} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link GraphDelegate#resolveStorePropertiesForGraph(Store, StoreProperties, String, Pair)}
   */
  @Test
  @DisplayName("Test resolveStorePropertiesForGraph(Store, StoreProperties, String, Pair); given HashMapGraphLibrary (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "StoreProperties GraphDelegate.resolveStorePropertiesForGraph(Store, StoreProperties, String, Pair)"})
  void testResolveStorePropertiesForGraph_givenHashMapGraphLibrary() {
    // Arrange
    GraphDelegate graphDelegate = new GraphDelegate();

    TestStoreImpl store = new TestStoreImpl();
    store.setGraphLibrary(new HashMapGraphLibrary());

    // Act
    StoreProperties actualResolveStorePropertiesForGraphResult = graphDelegate.resolveStorePropertiesForGraph(store,
        null, "42", null);

    // Assert
    assertEquals("", actualResolveStorePropertiesForGraphResult.getAdminAuth());
    assertEquals("", actualResolveStorePropertiesForGraphResult.getJsonSerialiserModules());
    assertEquals("uk.gov.gchq.gaffer.store.StoreProperties",
        actualResolveStorePropertiesForGraphResult.getStorePropertiesClassName());
    assertEquals("uk.gov.gchq.gaffer.store.schema.Schema",
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
    assertEquals(50, actualResolveStorePropertiesForGraphResult.getJobExecutorThreadCount().intValue());
    assertFalse(actualResolveStorePropertiesForGraphResult.getJobTrackerEnabled());
    assertFalse(actualResolveStorePropertiesForGraphResult.getRescheduleJobsOnStart());
    assertTrue(properties.containsKey("gaffer.store.properties.class"));
    assertTrue(actualResolveStorePropertiesForGraphResult.getNamedOperationEnabled());
    assertTrue(actualResolveStorePropertiesForGraphResult.getNamedViewEnabled());
    Class<StoreProperties> expectedStorePropertiesClass = StoreProperties.class;
    assertEquals(expectedStorePropertiesClass, actualResolveStorePropertiesForGraphResult.getStorePropertiesClass());
    Class<Schema> expectedSchemaClass = Schema.class;
    assertEquals(expectedSchemaClass, actualResolveStorePropertiesForGraphResult.getSchemaClass());
  }

  /**
   * Test {@link GraphDelegate#resolveStorePropertiesForGraph(Store, StoreProperties, String, Pair)}.
   * <ul>
   *   <li>Given {@link NoGraphLibrary} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link GraphDelegate#resolveStorePropertiesForGraph(Store, StoreProperties, String, Pair)}
   */
  @Test
  @DisplayName("Test resolveStorePropertiesForGraph(Store, StoreProperties, String, Pair); given NoGraphLibrary (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "StoreProperties GraphDelegate.resolveStorePropertiesForGraph(Store, StoreProperties, String, Pair)"})
  void testResolveStorePropertiesForGraph_givenNoGraphLibrary() {
    // Arrange
    GraphDelegate graphDelegate = new GraphDelegate();

    TestStoreImpl store = new TestStoreImpl();
    store.setGraphLibrary(new NoGraphLibrary());

    // Act
    StoreProperties actualResolveStorePropertiesForGraphResult = graphDelegate.resolveStorePropertiesForGraph(store,
        null, "42", null);

    // Assert
    assertEquals("", actualResolveStorePropertiesForGraphResult.getAdminAuth());
    assertEquals("", actualResolveStorePropertiesForGraphResult.getJsonSerialiserModules());
    assertEquals("uk.gov.gchq.gaffer.store.StoreProperties",
        actualResolveStorePropertiesForGraphResult.getStorePropertiesClassName());
    assertEquals("uk.gov.gchq.gaffer.store.schema.Schema",
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
    assertEquals(50, actualResolveStorePropertiesForGraphResult.getJobExecutorThreadCount().intValue());
    assertFalse(actualResolveStorePropertiesForGraphResult.getJobTrackerEnabled());
    assertFalse(actualResolveStorePropertiesForGraphResult.getRescheduleJobsOnStart());
    assertTrue(properties.containsKey("gaffer.store.properties.class"));
    assertTrue(actualResolveStorePropertiesForGraphResult.getNamedOperationEnabled());
    assertTrue(actualResolveStorePropertiesForGraphResult.getNamedViewEnabled());
    Class<StoreProperties> expectedStorePropertiesClass = StoreProperties.class;
    assertEquals(expectedStorePropertiesClass, actualResolveStorePropertiesForGraphResult.getStorePropertiesClass());
    Class<Schema> expectedSchemaClass = Schema.class;
    assertEquals(expectedSchemaClass, actualResolveStorePropertiesForGraphResult.getSchemaClass());
  }

  /**
   * Test {@link GraphDelegate#resolveStorePropertiesForGraph(Store, StoreProperties, String, Pair)}.
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>When {@link TestStoreImpl} (default constructor) GraphLibrary is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GraphDelegate#resolveStorePropertiesForGraph(Store, StoreProperties, String, Pair)}
   */
  @Test
  @DisplayName("Test resolveStorePropertiesForGraph(Store, StoreProperties, String, Pair); given 'null'; when TestStoreImpl (default constructor) GraphLibrary is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "StoreProperties GraphDelegate.resolveStorePropertiesForGraph(Store, StoreProperties, String, Pair)"})
  void testResolveStorePropertiesForGraph_givenNull_whenTestStoreImplGraphLibraryIsNull() {
    // Arrange
    GraphDelegate graphDelegate = new GraphDelegate();

    TestStoreImpl store = new TestStoreImpl();
    store.setGraphLibrary(null);

    // Act and Assert
    assertNull(graphDelegate.resolveStorePropertiesForGraph(store, null, null, null));
  }

  /**
   * Test {@link GraphDelegate#resolveStorePropertiesForGraph(Store, StoreProperties, String, Pair)}.
   * <ul>
   *   <li>When {@link StoreProperties#StoreProperties()}.</li>
   *   <li>Then return {@link StoreProperties#StoreProperties()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GraphDelegate#resolveStorePropertiesForGraph(Store, StoreProperties, String, Pair)}
   */
  @Test
  @DisplayName("Test resolveStorePropertiesForGraph(Store, StoreProperties, String, Pair); when StoreProperties(); then return StoreProperties()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "StoreProperties GraphDelegate.resolveStorePropertiesForGraph(Store, StoreProperties, String, Pair)"})
  void testResolveStorePropertiesForGraph_whenStoreProperties_thenReturnStoreProperties() {
    // Arrange
    GraphDelegate graphDelegate = new GraphDelegate();

    TestStoreImpl store = new TestStoreImpl();
    store.setGraphLibrary(new FileGraphLibrary());
    StoreProperties properties = new StoreProperties();

    // Act and Assert
    assertEquals(properties, graphDelegate.resolveStorePropertiesForGraph(store, properties, null, null));
  }

  /**
   * Test {@link GraphDelegate#resolveStorePropertiesForGraph(Store, StoreProperties, String, Pair)}.
   * <ul>
   *   <li>When {@link TestStoreImpl} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GraphDelegate#resolveStorePropertiesForGraph(Store, StoreProperties, String, Pair)}
   */
  @Test
  @DisplayName("Test resolveStorePropertiesForGraph(Store, StoreProperties, String, Pair); when TestStoreImpl (default constructor); then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "StoreProperties GraphDelegate.resolveStorePropertiesForGraph(Store, StoreProperties, String, Pair)"})
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
   * <ul>
   *   <li>Given {@link FileGraphLibrary#FileGraphLibrary()}.</li>
   *   <li>Then return {@link Schema#Schema()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GraphDelegate#resolveSchemaForGraph(Store, Schema, List, Pair)}
   */
  @Test
  @DisplayName("Test resolveSchemaForGraph(Store, Schema, List, Pair); given FileGraphLibrary(); then return Schema()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Schema GraphDelegate.resolveSchemaForGraph(Store, Schema, List, Pair)"})
  void testResolveSchemaForGraph_givenFileGraphLibrary_thenReturnSchema() {
    // Arrange
    GraphDelegate graphDelegate = new GraphDelegate();

    TestStoreImpl store = new TestStoreImpl();
    store.setGraphLibrary(new FileGraphLibrary());
    Schema schema = new Schema();

    // Act and Assert
    assertEquals(schema, graphDelegate.resolveSchemaForGraph(store, schema, null, null));
  }

  /**
   * Test {@link GraphDelegate#resolveSchemaForGraph(Store, Schema, List, Pair)}.
   * <ul>
   *   <li>Given {@link FileGraphLibrary#FileGraphLibrary()}.</li>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return {@link Schema#Schema()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GraphDelegate#resolveSchemaForGraph(Store, Schema, List, Pair)}
   */
  @Test
  @DisplayName("Test resolveSchemaForGraph(Store, Schema, List, Pair); given FileGraphLibrary(); when ArrayList(); then return Schema()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Schema GraphDelegate.resolveSchemaForGraph(Store, Schema, List, Pair)"})
  void testResolveSchemaForGraph_givenFileGraphLibrary_whenArrayList_thenReturnSchema() {
    // Arrange
    GraphDelegate graphDelegate = new GraphDelegate();

    TestStoreImpl store = new TestStoreImpl();
    store.setGraphLibrary(new FileGraphLibrary());
    Schema schema = new Schema();

    // Act and Assert
    assertEquals(schema, graphDelegate.resolveSchemaForGraph(store, schema, new ArrayList<>(), null));
  }

  /**
   * Test {@link GraphDelegate#resolveSchemaForGraph(Store, Schema, List, Pair)}.
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>When {@link TestStoreImpl} (default constructor) GraphLibrary is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GraphDelegate#resolveSchemaForGraph(Store, Schema, List, Pair)}
   */
  @Test
  @DisplayName("Test resolveSchemaForGraph(Store, Schema, List, Pair); given 'null'; when TestStoreImpl (default constructor) GraphLibrary is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Schema GraphDelegate.resolveSchemaForGraph(Store, Schema, List, Pair)"})
  void testResolveSchemaForGraph_givenNull_whenTestStoreImplGraphLibraryIsNull() {
    // Arrange
    GraphDelegate graphDelegate = new GraphDelegate();

    TestStoreImpl store = new TestStoreImpl();
    store.setGraphLibrary(null);
    Schema schema = new Schema();

    ArrayList<String> parentSchemaIds = new ArrayList<>();
    parentSchemaIds.add(null);

    // Act and Assert
    assertSame(schema, graphDelegate.resolveSchemaForGraph(store, schema, parentSchemaIds, null));
  }

  /**
   * Test {@link GraphDelegate#resolveSchemaForGraph(Store, Schema, List, Pair)}.
   * <ul>
   *   <li>When {@link TestStoreImpl} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GraphDelegate#resolveSchemaForGraph(Store, Schema, List, Pair)}
   */
  @Test
  @DisplayName("Test resolveSchemaForGraph(Store, Schema, List, Pair); when TestStoreImpl (default constructor); then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Schema GraphDelegate.resolveSchemaForGraph(Store, Schema, List, Pair)"})
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
   * Test {@link GraphDelegate#validate(Store, String, Schema, StoreProperties, List, String)} with {@code store}, {@code graphId}, {@code schema}, {@code storeProperties}, {@code parentSchemaIds}, {@code parentStorePropertiesId}.
   * <p>
   * Method under test: {@link GraphDelegate#validate(Store, String, Schema, StoreProperties, List, String)}
   */
  @Test
  @DisplayName("Test validate(Store, String, Schema, StoreProperties, List, String) with 'store', 'graphId', 'schema', 'storeProperties', 'parentSchemaIds', 'parentStorePropertiesId'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void GraphDelegate.validate(Store, String, Schema, StoreProperties, List, String)"})
  void testValidateWithStoreGraphIdSchemaStorePropertiesParentSchemaIdsParentStorePropertiesId() {
    // Arrange
    TestStoreImpl store = new TestStoreImpl();
    Schema schema = new Schema();
    StoreProperties storeProperties = new StoreProperties();

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> GraphDelegate.validate(store, "42", schema, storeProperties, new ArrayList<>(), "42"));
  }

  /**
   * Test {@link GraphDelegate#validate(Store, String, Schema, StoreProperties, List, String, Pair)} with {@code store}, {@code graphId}, {@code schema}, {@code storeProperties}, {@code parentSchemaIds}, {@code parentStorePropertiesId}, {@code existingGraphPair}.
   * <p>
   * Method under test: {@link GraphDelegate#validate(Store, String, Schema, StoreProperties, List, String, Pair)}
   */
  @Test
  @DisplayName("Test validate(Store, String, Schema, StoreProperties, List, String, Pair) with 'store', 'graphId', 'schema', 'storeProperties', 'parentSchemaIds', 'parentStorePropertiesId', 'existingGraphPair'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void GraphDelegate.validate(Store, String, Schema, StoreProperties, List, String, Pair)"})
  void testValidateWithStoreGraphIdSchemaStorePropertiesParentSchemaIdsParentStorePropertiesIdExistingGraphPair() {
    // Arrange
    TestStoreImpl store = new TestStoreImpl();
    Schema schema = new Schema();
    StoreProperties storeProperties = new StoreProperties();
    ArrayList<String> parentSchemaIds = new ArrayList<>();

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> GraphDelegate.validate(store, "42", schema, storeProperties, parentSchemaIds, "42", new Pair<>()));
  }

  /**
   * Test {@link GraphDelegate#validate(Store, String, Schema, StoreProperties, List, String, Pair, ValidationResult)} with {@code store}, {@code graphId}, {@code schema}, {@code storeProperties}, {@code parentSchemaIds}, {@code parentStorePropertiesId}, {@code existingGraphPair}, {@code result}.
   * <p>
   * Method under test: {@link GraphDelegate#validate(Store, String, Schema, StoreProperties, List, String, Pair, ValidationResult)}
   */
  @Test
  @DisplayName("Test validate(Store, String, Schema, StoreProperties, List, String, Pair, ValidationResult) with 'store', 'graphId', 'schema', 'storeProperties', 'parentSchemaIds', 'parentStorePropertiesId', 'existingGraphPair', 'result'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "ValidationResult GraphDelegate.validate(Store, String, Schema, StoreProperties, List, String, Pair, ValidationResult)"})
  void testValidateWithStoreGraphIdSchemaStorePropertiesParentSchemaIdsParentStorePropertiesIdExistingGraphPairResult() {
    // Arrange
    TestStoreImpl store = new TestStoreImpl();
    Schema schema = new Schema();
    StoreProperties storeProperties = new StoreProperties();
    ArrayList<String> parentSchemaIds = new ArrayList<>();
    Pair<Schema, StoreProperties> existingGraphPair = new Pair<>();
    ValidationResult result = new ValidationResult("An error occurred");

    // Act
    ValidationResult actualValidateResult = GraphDelegate.validate(store, "42", schema, storeProperties,
        parentSchemaIds, "42", existingGraphPair, result);

    // Assert
    assertEquals(
        "Validation errors: \n" + "An error occurred\n" + " parentSchemaIds cannot be used without a GraphLibrary\n"
            + " parentStorePropertiesId cannot be used without a GraphLibrary",
        result.getErrorString());
    assertEquals(
        "Validation errors: \n" + "An error occurred\n" + " parentSchemaIds cannot be used without a GraphLibrary\n"
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
   * Test {@link GraphDelegate#validateGraph(Store, String, Schema, StoreProperties, List, String)} with {@code store}, {@code graphId}, {@code schema}, {@code storeProperties}, {@code parentSchemaIds}, {@code parentStorePropertiesId}.
   * <p>
   * Method under test: {@link GraphDelegate#validateGraph(Store, String, Schema, StoreProperties, List, String)}
   */
  @Test
  @DisplayName("Test validateGraph(Store, String, Schema, StoreProperties, List, String) with 'store', 'graphId', 'schema', 'storeProperties', 'parentSchemaIds', 'parentStorePropertiesId'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void GraphDelegate.validateGraph(Store, String, Schema, StoreProperties, List, String)"})
  void testValidateGraphWithStoreGraphIdSchemaStorePropertiesParentSchemaIdsParentStorePropertiesId() {
    // Arrange
    GraphDelegate graphDelegate = new GraphDelegate();
    TestStoreImpl store = new TestStoreImpl();
    Schema schema = new Schema();
    StoreProperties storeProperties = new StoreProperties();

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> graphDelegate.validateGraph(store, "42", schema, storeProperties, new ArrayList<>(), "42"));
  }

  /**
   * Test {@link GraphDelegate#validateGraph(Store, String, Schema, StoreProperties, List, String, Pair)} with {@code store}, {@code graphId}, {@code schema}, {@code storeProperties}, {@code parentSchemaIds}, {@code parentStorePropertiesId}, {@code existingGraphPair}.
   * <p>
   * Method under test: {@link GraphDelegate#validateGraph(Store, String, Schema, StoreProperties, List, String, Pair)}
   */
  @Test
  @DisplayName("Test validateGraph(Store, String, Schema, StoreProperties, List, String, Pair) with 'store', 'graphId', 'schema', 'storeProperties', 'parentSchemaIds', 'parentStorePropertiesId', 'existingGraphPair'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void GraphDelegate.validateGraph(Store, String, Schema, StoreProperties, List, String, Pair)"})
  void testValidateGraphWithStoreGraphIdSchemaStorePropertiesParentSchemaIdsParentStorePropertiesIdExistingGraphPair() {
    // Arrange
    GraphDelegate graphDelegate = new GraphDelegate();
    TestStoreImpl store = new TestStoreImpl();
    Schema schema = new Schema();
    StoreProperties storeProperties = new StoreProperties();
    ArrayList<String> parentSchemaIds = new ArrayList<>();

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> graphDelegate.validateGraph(store, "42", schema, storeProperties, parentSchemaIds, "42", new Pair<>()));
  }
}
