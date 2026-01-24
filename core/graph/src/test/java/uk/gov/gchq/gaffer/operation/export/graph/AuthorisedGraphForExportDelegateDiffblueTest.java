/*
 * Copyright 2026 Crown Copyright
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

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.commonutil.pair.Pair;
import uk.gov.gchq.gaffer.data.elementdefinition.exception.SchemaException;
import uk.gov.gchq.gaffer.graph.GraphTest;
import uk.gov.gchq.gaffer.graph.GraphTest.TestStoreImpl;
import uk.gov.gchq.gaffer.operation.export.graph.AuthorisedGraphForExportDelegate.Builder;
import uk.gov.gchq.gaffer.store.Store;
import uk.gov.gchq.gaffer.store.StoreProperties;
import uk.gov.gchq.gaffer.store.library.FileGraphLibrary;
import uk.gov.gchq.gaffer.store.library.HashMapGraphLibrary;
import uk.gov.gchq.gaffer.store.schema.Schema;
import uk.gov.gchq.gaffer.user.User;

class AuthorisedGraphForExportDelegateDiffblueTest {
  /**
   * Test Builder {@link Builder#idAuths(Map)}.
   *
   * <p>Method under test: {@link Builder#idAuths(Map)}
   */
  @Test
  @DisplayName("Test Builder idAuths(Map)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.idAuths(Map)"})
  void testBuilderIdAuths() {
    // Arrange
    Builder builder = new Builder();

    // Act
    Builder actualIdAuthsResult = builder.idAuths(new HashMap<>());

    // Assert
    assertSame(builder, actualIdAuthsResult);
  }

  /**
   * Test Builder {@link Builder#user(User)}.
   *
   * <p>Method under test: {@link Builder#user(User)}
   */
  @Test
  @DisplayName("Test Builder user(User)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.user(User)"})
  void testBuilderUser() {
    // Arrange
    Builder builder = new Builder();

    // Act
    Builder actualUserResult = builder.user(new User());

    // Assert
    assertSame(builder, actualUserResult);
  }

  /**
   * Test Builder {@link Builder#_self()}.
   *
   * <p>Method under test: {@link Builder#_self()}
   */
  @Test
  @DisplayName("Test Builder _self()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder._self()"})
  void testBuilder_self() {
    // Arrange
    Builder builder = new Builder();

    // Act
    Builder actual_selfResult = builder._self();

    // Assert
    assertSame(builder, actual_selfResult);
  }

  /**
   * Test {@link AuthorisedGraphForExportDelegate#setIdAuths(Map)}.
   *
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.
   *   <li>Then {@link AuthorisedGraphForExportDelegate} (default constructor) IdAuths is {@link
   *       HashMap#HashMap()}.
   * </ul>
   *
   * <p>Method under test: {@link AuthorisedGraphForExportDelegate#setIdAuths(Map)}
   */
  @Test
  @DisplayName(
      "Test setIdAuths(Map); when HashMap(); then AuthorisedGraphForExportDelegate (default constructor) IdAuths is HashMap()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AuthorisedGraphForExportDelegate.setIdAuths(Map)"})
  void testSetIdAuths_whenHashMap_thenAuthorisedGraphForExportDelegateIdAuthsIsHashMap() {
    // Arrange
    AuthorisedGraphForExportDelegate authorisedGraphForExportDelegate =
        new AuthorisedGraphForExportDelegate();
    HashMap<String, List<String>> idAuths = new HashMap<>();

    // Act
    authorisedGraphForExportDelegate.setIdAuths(idAuths);

    // Assert
    assertSame(idAuths, authorisedGraphForExportDelegate.getIdAuths());
  }

  /**
   * Test {@link AuthorisedGraphForExportDelegate#setIdAuths(Map)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then {@link AuthorisedGraphForExportDelegate} (default constructor) IdAuths Empty.
   * </ul>
   *
   * <p>Method under test: {@link AuthorisedGraphForExportDelegate#setIdAuths(Map)}
   */
  @Test
  @DisplayName(
      "Test setIdAuths(Map); when 'null'; then AuthorisedGraphForExportDelegate (default constructor) IdAuths Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AuthorisedGraphForExportDelegate.setIdAuths(Map)"})
  void testSetIdAuths_whenNull_thenAuthorisedGraphForExportDelegateIdAuthsEmpty() {
    // Arrange
    AuthorisedGraphForExportDelegate authorisedGraphForExportDelegate =
        new AuthorisedGraphForExportDelegate();

    // Act
    authorisedGraphForExportDelegate.setIdAuths(null);

    // Assert that nothing has changed
    assertTrue(authorisedGraphForExportDelegate.getIdAuths().isEmpty());
  }

  /**
   * Test {@link AuthorisedGraphForExportDelegate#createGraphInstance(Store, String, Schema,
   * StoreProperties, List, String, Map, User)} with {@code store}, {@code graphId}, {@code schema},
   * {@code storeProperties}, {@code parentSchemaIds}, {@code parentStorePropertiesId}, {@code
   * idAuths}, {@code user}.
   *
   * <p>Method under test: {@link AuthorisedGraphForExportDelegate#createGraphInstance(Store,
   * String, Schema, StoreProperties, List, String, Map, User)}
   */
  @Test
  @DisplayName(
      "Test createGraphInstance(Store, String, Schema, StoreProperties, List, String, Map, User) with 'store', 'graphId', 'schema', 'storeProperties', 'parentSchemaIds', 'parentStorePropertiesId', 'idAuths', 'user'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "uk.gov.gchq.gaffer.graph.Graph AuthorisedGraphForExportDelegate.createGraphInstance(Store, String, Schema, StoreProperties, List, String, Map, User)"
  })
  void
      testCreateGraphInstanceWithStoreGraphIdSchemaStorePropertiesParentSchemaIdsParentStorePropertiesIdIdAuthsUser() {
    // Arrange
    AuthorisedGraphForExportDelegate authorisedGraphForExportDelegate =
        new AuthorisedGraphForExportDelegate();
    TestStoreImpl store = new TestStoreImpl();
    Schema schema = new Schema();
    StoreProperties storeProperties = new StoreProperties();
    ArrayList<String> parentSchemaIds = new ArrayList<>();
    HashMap<Object, Object> idAuths = new HashMap<>();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            authorisedGraphForExportDelegate.createGraphInstance(
                store, "42", schema, storeProperties, parentSchemaIds, "42", idAuths, new User()));
  }

  /**
   * Test {@link AuthorisedGraphForExportDelegate#createGraphInstance(Store, String, Schema,
   * StoreProperties, List, String, Map, User)} with {@code store}, {@code graphId}, {@code schema},
   * {@code storeProperties}, {@code parentSchemaIds}, {@code parentStorePropertiesId}, {@code
   * idAuths}, {@code user}.
   *
   * <p>Method under test: {@link AuthorisedGraphForExportDelegate#createGraphInstance(Store,
   * String, Schema, StoreProperties, List, String, Map, User)}
   */
  @Test
  @DisplayName(
      "Test createGraphInstance(Store, String, Schema, StoreProperties, List, String, Map, User) with 'store', 'graphId', 'schema', 'storeProperties', 'parentSchemaIds', 'parentStorePropertiesId', 'idAuths', 'user'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "uk.gov.gchq.gaffer.graph.Graph AuthorisedGraphForExportDelegate.createGraphInstance(Store, String, Schema, StoreProperties, List, String, Map, User)"
  })
  void
      testCreateGraphInstanceWithStoreGraphIdSchemaStorePropertiesParentSchemaIdsParentStorePropertiesIdIdAuthsUser2() {
    // Arrange
    AuthorisedGraphForExportDelegate authorisedGraphForExportDelegate =
        new AuthorisedGraphForExportDelegate();

    TestStoreImpl store = new TestStoreImpl();
    store.setGraphLibrary(new FileGraphLibrary());
    Schema schema = new Schema();
    StoreProperties storeProperties = new StoreProperties();
    ArrayList<String> parentSchemaIds = new ArrayList<>();
    HashMap<Object, Object> idAuths = new HashMap<>();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            authorisedGraphForExportDelegate.createGraphInstance(
                store, "42", schema, storeProperties, parentSchemaIds, "42", idAuths, new User()));
  }

  /**
   * Test {@link AuthorisedGraphForExportDelegate#createGraphInstance(Store, String, Schema,
   * StoreProperties, List, String, Map, User)} with {@code store}, {@code graphId}, {@code schema},
   * {@code storeProperties}, {@code parentSchemaIds}, {@code parentStorePropertiesId}, {@code
   * idAuths}, {@code user}.
   *
   * <p>Method under test: {@link AuthorisedGraphForExportDelegate#createGraphInstance(Store,
   * String, Schema, StoreProperties, List, String, Map, User)}
   */
  @Test
  @DisplayName(
      "Test createGraphInstance(Store, String, Schema, StoreProperties, List, String, Map, User) with 'store', 'graphId', 'schema', 'storeProperties', 'parentSchemaIds', 'parentStorePropertiesId', 'idAuths', 'user'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "uk.gov.gchq.gaffer.graph.Graph AuthorisedGraphForExportDelegate.createGraphInstance(Store, String, Schema, StoreProperties, List, String, Map, User)"
  })
  void
      testCreateGraphInstanceWithStoreGraphIdSchemaStorePropertiesParentSchemaIdsParentStorePropertiesIdIdAuthsUser3() {
    // Arrange
    AuthorisedGraphForExportDelegate authorisedGraphForExportDelegate =
        new AuthorisedGraphForExportDelegate();

    TestStoreImpl store = new TestStoreImpl();
    store.setGraphLibrary(new FileGraphLibrary());
    Schema schema = new Schema();
    StoreProperties storeProperties = new StoreProperties();
    ArrayList<String> parentSchemaIds = new ArrayList<>();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            authorisedGraphForExportDelegate.createGraphInstance(
                store, "42", schema, storeProperties, parentSchemaIds, "42", null, new User()));
  }

  /**
   * Test {@link AuthorisedGraphForExportDelegate#createGraphInstance(Store, String, Schema,
   * StoreProperties, List, String, Map, User)} with {@code store}, {@code graphId}, {@code schema},
   * {@code storeProperties}, {@code parentSchemaIds}, {@code parentStorePropertiesId}, {@code
   * idAuths}, {@code user}.
   *
   * <p>Method under test: {@link AuthorisedGraphForExportDelegate#createGraphInstance(Store,
   * String, Schema, StoreProperties, List, String, Map, User)}
   */
  @Test
  @DisplayName(
      "Test createGraphInstance(Store, String, Schema, StoreProperties, List, String, Map, User) with 'store', 'graphId', 'schema', 'storeProperties', 'parentSchemaIds', 'parentStorePropertiesId', 'idAuths', 'user'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "uk.gov.gchq.gaffer.graph.Graph AuthorisedGraphForExportDelegate.createGraphInstance(Store, String, Schema, StoreProperties, List, String, Map, User)"
  })
  void
      testCreateGraphInstanceWithStoreGraphIdSchemaStorePropertiesParentSchemaIdsParentStorePropertiesIdIdAuthsUser4() {
    // Arrange
    AuthorisedGraphForExportDelegate authorisedGraphForExportDelegate =
        new AuthorisedGraphForExportDelegate();

    TestStoreImpl store = new TestStoreImpl();
    store.setGraphLibrary(new HashMapGraphLibrary());
    Schema schema = new Schema();
    StoreProperties storeProperties = new StoreProperties();
    ArrayList<String> parentSchemaIds = new ArrayList<>();
    HashMap<Object, Object> idAuths = new HashMap<>();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            authorisedGraphForExportDelegate.createGraphInstance(
                store, "42", schema, storeProperties, parentSchemaIds, "42", idAuths, new User()));
  }

  /**
   * Test {@link AuthorisedGraphForExportDelegate#resolveSchemaForGraph(Store, Schema, List, Pair)}.
   *
   * <ul>
   *   <li>Given {@link FileGraphLibrary#FileGraphLibrary()}.
   *   <li>Then return {@link Schema#Schema()}.
   * </ul>
   *
   * <p>Method under test: {@link AuthorisedGraphForExportDelegate#resolveSchemaForGraph(Store,
   * Schema, List, Pair)}
   */
  @Test
  @DisplayName(
      "Test resolveSchemaForGraph(Store, Schema, List, Pair); given FileGraphLibrary(); then return Schema()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Schema AuthorisedGraphForExportDelegate.resolveSchemaForGraph(Store, Schema, List, Pair)"
  })
  void testResolveSchemaForGraph_givenFileGraphLibrary_thenReturnSchema() {
    // Arrange
    AuthorisedGraphForExportDelegate authorisedGraphForExportDelegate =
        new AuthorisedGraphForExportDelegate();

    TestStoreImpl store = new TestStoreImpl();
    store.setGraphLibrary(new FileGraphLibrary());
    Schema schema = new Schema();

    // Act
    Schema actualResolveSchemaForGraphResult =
        authorisedGraphForExportDelegate.resolveSchemaForGraph(store, schema, null, null);

    // Assert
    assertEquals(schema, actualResolveSchemaForGraphResult);
  }

  /**
   * Test {@link AuthorisedGraphForExportDelegate#resolveSchemaForGraph(Store, Schema, List, Pair)}.
   *
   * <ul>
   *   <li>Given {@link FileGraphLibrary#FileGraphLibrary()}.
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return {@link Schema#Schema()}.
   * </ul>
   *
   * <p>Method under test: {@link AuthorisedGraphForExportDelegate#resolveSchemaForGraph(Store,
   * Schema, List, Pair)}
   */
  @Test
  @DisplayName(
      "Test resolveSchemaForGraph(Store, Schema, List, Pair); given FileGraphLibrary(); when ArrayList(); then return Schema()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Schema AuthorisedGraphForExportDelegate.resolveSchemaForGraph(Store, Schema, List, Pair)"
  })
  void testResolveSchemaForGraph_givenFileGraphLibrary_whenArrayList_thenReturnSchema() {
    // Arrange
    AuthorisedGraphForExportDelegate authorisedGraphForExportDelegate =
        new AuthorisedGraphForExportDelegate();

    TestStoreImpl store = new TestStoreImpl();
    store.setGraphLibrary(new FileGraphLibrary());
    Schema schema = new Schema();

    // Act
    Schema actualResolveSchemaForGraphResult =
        authorisedGraphForExportDelegate.resolveSchemaForGraph(
            store, schema, new ArrayList<>(), null);

    // Assert
    assertEquals(schema, actualResolveSchemaForGraphResult);
  }

  /**
   * Test {@link AuthorisedGraphForExportDelegate#resolveSchemaForGraph(Store, Schema, List, Pair)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link TestStoreImpl} (default constructor) GraphLibrary is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link AuthorisedGraphForExportDelegate#resolveSchemaForGraph(Store,
   * Schema, List, Pair)}
   */
  @Test
  @DisplayName(
      "Test resolveSchemaForGraph(Store, Schema, List, Pair); given 'null'; when TestStoreImpl (default constructor) GraphLibrary is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Schema AuthorisedGraphForExportDelegate.resolveSchemaForGraph(Store, Schema, List, Pair)"
  })
  void testResolveSchemaForGraph_givenNull_whenTestStoreImplGraphLibraryIsNull() {
    // Arrange
    AuthorisedGraphForExportDelegate authorisedGraphForExportDelegate =
        new AuthorisedGraphForExportDelegate();

    TestStoreImpl store = new TestStoreImpl();
    store.setGraphLibrary(null);
    Schema schema = new Schema();

    ArrayList<String> parentSchemaIds = new ArrayList<>();
    parentSchemaIds.add("Parent Schema Ids");

    // Act
    Schema actualResolveSchemaForGraphResult =
        authorisedGraphForExportDelegate.resolveSchemaForGraph(
            store, schema, parentSchemaIds, null);

    // Assert
    assertSame(schema, actualResolveSchemaForGraphResult);
  }

  /**
   * Test {@link AuthorisedGraphForExportDelegate#resolveSchemaForGraph(Store, Schema, List, Pair)}.
   *
   * <ul>
   *   <li>Given {@code Parent Schema Ids}.
   *   <li>When {@link Pair#Pair(Object)} with first is {@link Schema#Schema()}.
   * </ul>
   *
   * <p>Method under test: {@link AuthorisedGraphForExportDelegate#resolveSchemaForGraph(Store,
   * Schema, List, Pair)}
   */
  @Test
  @DisplayName(
      "Test resolveSchemaForGraph(Store, Schema, List, Pair); given 'Parent Schema Ids'; when Pair(Object) with first is Schema()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Schema AuthorisedGraphForExportDelegate.resolveSchemaForGraph(Store, Schema, List, Pair)"
  })
  void testResolveSchemaForGraph_givenParentSchemaIds_whenPairWithFirstIsSchema() {
    // Arrange
    AuthorisedGraphForExportDelegate authorisedGraphForExportDelegate =
        new AuthorisedGraphForExportDelegate();

    TestStoreImpl store = new TestStoreImpl();
    store.setGraphLibrary(new FileGraphLibrary());
    Schema schema = new Schema();

    ArrayList<String> parentSchemaIds = new ArrayList<>();
    parentSchemaIds.add("Parent Schema Ids");
    Schema schema2 = new Schema();

    // Act and Assert
    assertSame(
        schema2,
        authorisedGraphForExportDelegate.resolveSchemaForGraph(
            store, schema, parentSchemaIds, new Pair<>(schema2)));
  }

  /**
   * Test {@link AuthorisedGraphForExportDelegate#resolveSchemaForGraph(Store, Schema, List, Pair)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return VisibilityProperty is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link AuthorisedGraphForExportDelegate#resolveSchemaForGraph(Store,
   * Schema, List, Pair)}
   */
  @Test
  @DisplayName(
      "Test resolveSchemaForGraph(Store, Schema, List, Pair); when ArrayList(); then return VisibilityProperty is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Schema AuthorisedGraphForExportDelegate.resolveSchemaForGraph(Store, Schema, List, Pair)"
  })
  void testResolveSchemaForGraph_whenArrayList_thenReturnVisibilityPropertyIsNull()
      throws UnsupportedEncodingException, SchemaException {
    // Arrange
    AuthorisedGraphForExportDelegate authorisedGraphForExportDelegate =
        new AuthorisedGraphForExportDelegate();

    TestStoreImpl store = new TestStoreImpl();
    store.setGraphLibrary(new FileGraphLibrary());

    // Act
    Schema actualResolveSchemaForGraphResult =
        authorisedGraphForExportDelegate.resolveSchemaForGraph(
            store, null, new ArrayList<>(), null);

    // Assert
    assertNull(actualResolveSchemaForGraphResult.getVisibilityProperty());
    assertNull(actualResolveSchemaForGraphResult.getConfig());
    assertNull(actualResolveSchemaForGraphResult.getVertexSerialiser());
    assertFalse(actualResolveSchemaForGraphResult.hasEdges());
    assertFalse(actualResolveSchemaForGraphResult.hasEntities());
    assertFalse(actualResolveSchemaForGraphResult.hasGroups());
    assertFalse(actualResolveSchemaForGraphResult.isAggregationEnabled());
    assertTrue(actualResolveSchemaForGraphResult.getAggregatedGroups().isEmpty());
    assertTrue(actualResolveSchemaForGraphResult.getEdges().isEmpty());
    assertTrue(actualResolveSchemaForGraphResult.getEntities().isEmpty());
    assertTrue(actualResolveSchemaForGraphResult.getTypes().isEmpty());
    assertTrue(actualResolveSchemaForGraphResult.getEdgeGroups().isEmpty());
    assertTrue(actualResolveSchemaForGraphResult.getEntityGroups().isEmpty());
    assertTrue(actualResolveSchemaForGraphResult.getGroups().isEmpty());
    byte[] expectedToCompactJsonResult = "{\"types\":{}}".getBytes("UTF-8");
    assertArrayEquals(
        expectedToCompactJsonResult, actualResolveSchemaForGraphResult.toCompactJson());
  }

  /**
   * Test {@link AuthorisedGraphForExportDelegate#resolveSchemaForGraph(Store, Schema, List, Pair)}.
   *
   * <ul>
   *   <li>When {@link TestStoreImpl} (default constructor).
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link AuthorisedGraphForExportDelegate#resolveSchemaForGraph(Store,
   * Schema, List, Pair)}
   */
  @Test
  @DisplayName(
      "Test resolveSchemaForGraph(Store, Schema, List, Pair); when TestStoreImpl (default constructor); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Schema AuthorisedGraphForExportDelegate.resolveSchemaForGraph(Store, Schema, List, Pair)"
  })
  void testResolveSchemaForGraph_whenTestStoreImpl_thenReturnNull() {
    // Arrange
    AuthorisedGraphForExportDelegate authorisedGraphForExportDelegate =
        new AuthorisedGraphForExportDelegate();
    TestStoreImpl store = new TestStoreImpl();
    Schema schema = new Schema();
    ArrayList<String> parentSchemaIds = new ArrayList<>();

    // Act and Assert
    assertNull(
        authorisedGraphForExportDelegate.resolveSchemaForGraph(
            store, schema, parentSchemaIds, new Pair<>()));
  }

  /**
   * Test {@link AuthorisedGraphForExportDelegate#resolveStorePropertiesForGraph(Store,
   * StoreProperties, String, Pair)}.
   *
   * <ul>
   *   <li>Given {@link HashMapGraphLibrary} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link
   * AuthorisedGraphForExportDelegate#resolveStorePropertiesForGraph(Store, StoreProperties, String,
   * Pair)}
   */
  @Test
  @DisplayName(
      "Test resolveStorePropertiesForGraph(Store, StoreProperties, String, Pair); given HashMapGraphLibrary (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "StoreProperties AuthorisedGraphForExportDelegate.resolveStorePropertiesForGraph(Store, StoreProperties, String, Pair)"
  })
  void testResolveStorePropertiesForGraph_givenHashMapGraphLibrary() {
    // Arrange
    AuthorisedGraphForExportDelegate authorisedGraphForExportDelegate =
        new AuthorisedGraphForExportDelegate();

    TestStoreImpl store = new TestStoreImpl();
    store.setGraphLibrary(new HashMapGraphLibrary());
    StoreProperties properties = new StoreProperties();

    // Act
    StoreProperties actualResolveStorePropertiesForGraphResult =
        authorisedGraphForExportDelegate.resolveStorePropertiesForGraph(
            store, properties, "42", null);

    // Assert
    assertEquals(properties, actualResolveStorePropertiesForGraphResult);
  }

  /**
   * Test {@link AuthorisedGraphForExportDelegate#resolveStorePropertiesForGraph(Store,
   * StoreProperties, String, Pair)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>Then return AdminAuth is empty string.
   * </ul>
   *
   * <p>Method under test: {@link
   * AuthorisedGraphForExportDelegate#resolveStorePropertiesForGraph(Store, StoreProperties, String,
   * Pair)}
   */
  @Test
  @DisplayName(
      "Test resolveStorePropertiesForGraph(Store, StoreProperties, String, Pair); given 'null'; then return AdminAuth is empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "StoreProperties AuthorisedGraphForExportDelegate.resolveStorePropertiesForGraph(Store, StoreProperties, String, Pair)"
  })
  void testResolveStorePropertiesForGraph_givenNull_thenReturnAdminAuthIsEmptyString() {
    // Arrange
    AuthorisedGraphForExportDelegate authorisedGraphForExportDelegate =
        new AuthorisedGraphForExportDelegate();

    TestStoreImpl store = new TestStoreImpl();
    store.setGraphLibrary(null);

    // Act
    StoreProperties actualResolveStorePropertiesForGraphResult =
        authorisedGraphForExportDelegate.resolveStorePropertiesForGraph(
            store, new StoreProperties(), "42", null);

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
   * Test {@link AuthorisedGraphForExportDelegate#resolveStorePropertiesForGraph(Store,
   * StoreProperties, String, Pair)}.
   *
   * <ul>
   *   <li>Given {@link StoreProperties#StoreProperties()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AuthorisedGraphForExportDelegate#resolveStorePropertiesForGraph(Store, StoreProperties, String,
   * Pair)}
   */
  @Test
  @DisplayName(
      "Test resolveStorePropertiesForGraph(Store, StoreProperties, String, Pair); given StoreProperties()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "StoreProperties AuthorisedGraphForExportDelegate.resolveStorePropertiesForGraph(Store, StoreProperties, String, Pair)"
  })
  void testResolveStorePropertiesForGraph_givenStoreProperties() {
    // Arrange
    AuthorisedGraphForExportDelegate authorisedGraphForExportDelegate =
        new AuthorisedGraphForExportDelegate();

    TestStoreImpl store = new TestStoreImpl();
    store.setGraphLibrary(new FileGraphLibrary());
    StoreProperties properties = new StoreProperties();

    Pair<Schema, StoreProperties> existingGraphPair = new Pair<>(new Schema());
    StoreProperties storeProperties = new StoreProperties();
    existingGraphPair.setSecond(storeProperties);

    // Act and Assert
    assertSame(
        storeProperties,
        authorisedGraphForExportDelegate.resolveStorePropertiesForGraph(
            store, properties, "42", existingGraphPair));
  }

  /**
   * Test {@link AuthorisedGraphForExportDelegate#resolveStorePropertiesForGraph(Store,
   * StoreProperties, String, Pair)}.
   *
   * <ul>
   *   <li>Then return {@link StoreProperties#StoreProperties()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AuthorisedGraphForExportDelegate#resolveStorePropertiesForGraph(Store, StoreProperties, String,
   * Pair)}
   */
  @Test
  @DisplayName(
      "Test resolveStorePropertiesForGraph(Store, StoreProperties, String, Pair); then return StoreProperties()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "StoreProperties AuthorisedGraphForExportDelegate.resolveStorePropertiesForGraph(Store, StoreProperties, String, Pair)"
  })
  void testResolveStorePropertiesForGraph_thenReturnStoreProperties() {
    // Arrange
    AuthorisedGraphForExportDelegate authorisedGraphForExportDelegate =
        new AuthorisedGraphForExportDelegate();

    TestStoreImpl store = new TestStoreImpl();
    store.setGraphLibrary(new FileGraphLibrary());
    StoreProperties properties = new StoreProperties();

    // Act
    StoreProperties actualResolveStorePropertiesForGraphResult =
        authorisedGraphForExportDelegate.resolveStorePropertiesForGraph(
            store, properties, "42", null);

    // Assert
    assertEquals(properties, actualResolveStorePropertiesForGraphResult);
  }

  /**
   * Test {@link AuthorisedGraphForExportDelegate#resolveStorePropertiesForGraph(Store,
   * StoreProperties, String, Pair)}.
   *
   * <ul>
   *   <li>Then return {@link StoreProperties#StoreProperties()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AuthorisedGraphForExportDelegate#resolveStorePropertiesForGraph(Store, StoreProperties, String,
   * Pair)}
   */
  @Test
  @DisplayName(
      "Test resolveStorePropertiesForGraph(Store, StoreProperties, String, Pair); then return StoreProperties()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "StoreProperties AuthorisedGraphForExportDelegate.resolveStorePropertiesForGraph(Store, StoreProperties, String, Pair)"
  })
  void testResolveStorePropertiesForGraph_thenReturnStoreProperties2() {
    // Arrange
    AuthorisedGraphForExportDelegate authorisedGraphForExportDelegate =
        new AuthorisedGraphForExportDelegate();

    TestStoreImpl store = new TestStoreImpl();
    store.setGraphLibrary(new FileGraphLibrary());
    StoreProperties properties = new StoreProperties();

    // Act
    StoreProperties actualResolveStorePropertiesForGraphResult =
        authorisedGraphForExportDelegate.resolveStorePropertiesForGraph(
            store, properties, null, null);

    // Assert
    assertEquals(properties, actualResolveStorePropertiesForGraphResult);
  }

  /**
   * Test {@link AuthorisedGraphForExportDelegate#resolveStorePropertiesForGraph(Store,
   * StoreProperties, String, Pair)}.
   *
   * <ul>
   *   <li>When {@link TestStoreImpl} (default constructor).
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AuthorisedGraphForExportDelegate#resolveStorePropertiesForGraph(Store, StoreProperties, String,
   * Pair)}
   */
  @Test
  @DisplayName(
      "Test resolveStorePropertiesForGraph(Store, StoreProperties, String, Pair); when TestStoreImpl (default constructor); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "StoreProperties AuthorisedGraphForExportDelegate.resolveStorePropertiesForGraph(Store, StoreProperties, String, Pair)"
  })
  void testResolveStorePropertiesForGraph_whenTestStoreImpl_thenReturnNull() {
    // Arrange
    AuthorisedGraphForExportDelegate authorisedGraphForExportDelegate =
        new AuthorisedGraphForExportDelegate();
    TestStoreImpl store = new TestStoreImpl();
    StoreProperties properties = new StoreProperties();

    // Act and Assert
    assertNull(
        authorisedGraphForExportDelegate.resolveStorePropertiesForGraph(
            store, properties, "42", new Pair<>()));
  }

  /**
   * Test {@link AuthorisedGraphForExportDelegate#validateGraph(Store, String, Schema,
   * StoreProperties, List, String, Pair)} with {@code store}, {@code graphId}, {@code schema},
   * {@code storeProperties}, {@code parentSchemaIds}, {@code parentStorePropertiesId}, {@code
   * existingGraphPair}.
   *
   * <p>Method under test: {@link AuthorisedGraphForExportDelegate#validateGraph(Store, String,
   * Schema, StoreProperties, List, String, Pair)}
   */
  @Test
  @DisplayName(
      "Test validateGraph(Store, String, Schema, StoreProperties, List, String, Pair) with 'store', 'graphId', 'schema', 'storeProperties', 'parentSchemaIds', 'parentStorePropertiesId', 'existingGraphPair'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AuthorisedGraphForExportDelegate.validateGraph(Store, String, Schema, StoreProperties, List, String, Pair)"
  })
  void
      testValidateGraphWithStoreGraphIdSchemaStorePropertiesParentSchemaIdsParentStorePropertiesIdExistingGraphPair() {
    // Arrange
    AuthorisedGraphForExportDelegate authorisedGraphForExportDelegate =
        new AuthorisedGraphForExportDelegate();
    TestStoreImpl store = new TestStoreImpl();
    Schema schema = new Schema();
    StoreProperties storeProperties = new StoreProperties();
    ArrayList<String> parentSchemaIds = new ArrayList<>();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            authorisedGraphForExportDelegate.validateGraph(
                store, "42", schema, storeProperties, parentSchemaIds, "42", new Pair<>()));
  }

  /**
   * Test {@link AuthorisedGraphForExportDelegate#validateGraph(Store, String, Schema,
   * StoreProperties, List, String, Pair)} with {@code store}, {@code graphId}, {@code schema},
   * {@code storeProperties}, {@code parentSchemaIds}, {@code parentStorePropertiesId}, {@code
   * existingGraphPair}.
   *
   * <p>Method under test: {@link AuthorisedGraphForExportDelegate#validateGraph(Store, String,
   * Schema, StoreProperties, List, String, Pair)}
   */
  @Test
  @DisplayName(
      "Test validateGraph(Store, String, Schema, StoreProperties, List, String, Pair) with 'store', 'graphId', 'schema', 'storeProperties', 'parentSchemaIds', 'parentStorePropertiesId', 'existingGraphPair'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AuthorisedGraphForExportDelegate.validateGraph(Store, String, Schema, StoreProperties, List, String, Pair)"
  })
  void
      testValidateGraphWithStoreGraphIdSchemaStorePropertiesParentSchemaIdsParentStorePropertiesIdExistingGraphPair2() {
    // Arrange
    AuthorisedGraphForExportDelegate authorisedGraphForExportDelegate =
        new AuthorisedGraphForExportDelegate();

    TestStoreImpl store = new TestStoreImpl();
    store.setGraphLibrary(new FileGraphLibrary());
    Schema schema = new Schema();
    StoreProperties storeProperties = new StoreProperties();
    ArrayList<String> parentSchemaIds = new ArrayList<>();

    Pair<Schema, StoreProperties> existingGraphPair = new Pair<>(new Schema());
    existingGraphPair.setSecond(new StoreProperties());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            authorisedGraphForExportDelegate.validateGraph(
                store, "42", schema, storeProperties, parentSchemaIds, "42", existingGraphPair));
  }

  /**
   * Test {@link AuthorisedGraphForExportDelegate#validateGraph(Store, String, Schema,
   * StoreProperties, List, String, Pair)} with {@code store}, {@code graphId}, {@code schema},
   * {@code storeProperties}, {@code parentSchemaIds}, {@code parentStorePropertiesId}, {@code
   * existingGraphPair}.
   *
   * <p>Method under test: {@link AuthorisedGraphForExportDelegate#validateGraph(Store, String,
   * Schema, StoreProperties, List, String, Pair)}
   */
  @Test
  @DisplayName(
      "Test validateGraph(Store, String, Schema, StoreProperties, List, String, Pair) with 'store', 'graphId', 'schema', 'storeProperties', 'parentSchemaIds', 'parentStorePropertiesId', 'existingGraphPair'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AuthorisedGraphForExportDelegate.validateGraph(Store, String, Schema, StoreProperties, List, String, Pair)"
  })
  void
      testValidateGraphWithStoreGraphIdSchemaStorePropertiesParentSchemaIdsParentStorePropertiesIdExistingGraphPair3() {
    // Arrange
    AuthorisedGraphForExportDelegate authorisedGraphForExportDelegate =
        new AuthorisedGraphForExportDelegate();

    TestStoreImpl store = new TestStoreImpl();
    store.setGraphLibrary(new FileGraphLibrary());
    Schema schema = new Schema();
    StoreProperties storeProperties = new StoreProperties();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            authorisedGraphForExportDelegate.validateGraph(
                store, "42", schema, storeProperties, new ArrayList<>(), "42", null));
  }

  /**
   * Test {@link AuthorisedGraphForExportDelegate#validateGraph(Store, String, Schema,
   * StoreProperties, List, String, Pair)} with {@code store}, {@code graphId}, {@code schema},
   * {@code storeProperties}, {@code parentSchemaIds}, {@code parentStorePropertiesId}, {@code
   * existingGraphPair}.
   *
   * <p>Method under test: {@link AuthorisedGraphForExportDelegate#validateGraph(Store, String,
   * Schema, StoreProperties, List, String, Pair)}
   */
  @Test
  @DisplayName(
      "Test validateGraph(Store, String, Schema, StoreProperties, List, String, Pair) with 'store', 'graphId', 'schema', 'storeProperties', 'parentSchemaIds', 'parentStorePropertiesId', 'existingGraphPair'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AuthorisedGraphForExportDelegate.validateGraph(Store, String, Schema, StoreProperties, List, String, Pair)"
  })
  void
      testValidateGraphWithStoreGraphIdSchemaStorePropertiesParentSchemaIdsParentStorePropertiesIdExistingGraphPair4() {
    // Arrange
    AuthorisedGraphForExportDelegate authorisedGraphForExportDelegate =
        new AuthorisedGraphForExportDelegate();

    TestStoreImpl store = new TestStoreImpl();
    store.setGraphLibrary(new FileGraphLibrary());
    Schema schema = new Schema();
    StoreProperties storeProperties = new StoreProperties();
    ArrayList<String> parentSchemaIds = new ArrayList<>();

    Pair<Schema, StoreProperties> existingGraphPair = new Pair<>(new Schema());
    existingGraphPair.setSecond(new StoreProperties());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            authorisedGraphForExportDelegate.validateGraph(
                store, "42", schema, storeProperties, parentSchemaIds, null, existingGraphPair));
  }

  /**
   * Test {@link AuthorisedGraphForExportDelegate#validateGraph(Store, String, Schema,
   * StoreProperties, List, String, Pair)} with {@code store}, {@code graphId}, {@code schema},
   * {@code storeProperties}, {@code parentSchemaIds}, {@code parentStorePropertiesId}, {@code
   * existingGraphPair}.
   *
   * <p>Method under test: {@link AuthorisedGraphForExportDelegate#validateGraph(Store, String,
   * Schema, StoreProperties, List, String, Pair)}
   */
  @Test
  @DisplayName(
      "Test validateGraph(Store, String, Schema, StoreProperties, List, String, Pair) with 'store', 'graphId', 'schema', 'storeProperties', 'parentSchemaIds', 'parentStorePropertiesId', 'existingGraphPair'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AuthorisedGraphForExportDelegate.validateGraph(Store, String, Schema, StoreProperties, List, String, Pair)"
  })
  void
      testValidateGraphWithStoreGraphIdSchemaStorePropertiesParentSchemaIdsParentStorePropertiesIdExistingGraphPair5() {
    // Arrange
    AuthorisedGraphForExportDelegate authorisedGraphForExportDelegate =
        new AuthorisedGraphForExportDelegate();

    TestStoreImpl store = new TestStoreImpl();
    store.setGraphLibrary(new FileGraphLibrary());
    Schema schema = new Schema();
    StoreProperties storeProperties = new StoreProperties();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            authorisedGraphForExportDelegate.validateGraph(
                store, "42", schema, storeProperties, new ArrayList<>(), null, null));
  }

  /**
   * Test {@link AuthorisedGraphForExportDelegate#validateGraph(Store, String, Schema,
   * StoreProperties, List, String, Pair)} with {@code store}, {@code graphId}, {@code schema},
   * {@code storeProperties}, {@code parentSchemaIds}, {@code parentStorePropertiesId}, {@code
   * existingGraphPair}.
   *
   * <p>Method under test: {@link AuthorisedGraphForExportDelegate#validateGraph(Store, String,
   * Schema, StoreProperties, List, String, Pair)}
   */
  @Test
  @DisplayName(
      "Test validateGraph(Store, String, Schema, StoreProperties, List, String, Pair) with 'store', 'graphId', 'schema', 'storeProperties', 'parentSchemaIds', 'parentStorePropertiesId', 'existingGraphPair'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AuthorisedGraphForExportDelegate.validateGraph(Store, String, Schema, StoreProperties, List, String, Pair)"
  })
  void
      testValidateGraphWithStoreGraphIdSchemaStorePropertiesParentSchemaIdsParentStorePropertiesIdExistingGraphPair6() {
    // Arrange
    AuthorisedGraphForExportDelegate authorisedGraphForExportDelegate =
        new AuthorisedGraphForExportDelegate();

    TestStoreImpl store = new TestStoreImpl();
    store.setGraphLibrary(new FileGraphLibrary());
    Schema schema = new Schema();
    StoreProperties storeProperties = new StoreProperties();

    Pair<Schema, StoreProperties> existingGraphPair = new Pair<>(new Schema());
    existingGraphPair.setSecond(new StoreProperties());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            authorisedGraphForExportDelegate.validateGraph(
                store, "42", schema, storeProperties, null, "42", existingGraphPair));
  }

  /**
   * Test {@link AuthorisedGraphForExportDelegate#validateGraph(Store, String, Schema,
   * StoreProperties, List, String, Pair)} with {@code store}, {@code graphId}, {@code schema},
   * {@code storeProperties}, {@code parentSchemaIds}, {@code parentStorePropertiesId}, {@code
   * existingGraphPair}.
   *
   * <p>Method under test: {@link AuthorisedGraphForExportDelegate#validateGraph(Store, String,
   * Schema, StoreProperties, List, String, Pair)}
   */
  @Test
  @DisplayName(
      "Test validateGraph(Store, String, Schema, StoreProperties, List, String, Pair) with 'store', 'graphId', 'schema', 'storeProperties', 'parentSchemaIds', 'parentStorePropertiesId', 'existingGraphPair'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AuthorisedGraphForExportDelegate.validateGraph(Store, String, Schema, StoreProperties, List, String, Pair)"
  })
  void
      testValidateGraphWithStoreGraphIdSchemaStorePropertiesParentSchemaIdsParentStorePropertiesIdExistingGraphPair7() {
    // Arrange
    AuthorisedGraphForExportDelegate authorisedGraphForExportDelegate =
        new AuthorisedGraphForExportDelegate();

    TestStoreImpl store = new TestStoreImpl();
    store.setGraphLibrary(new FileGraphLibrary());
    Schema schema = new Schema();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            authorisedGraphForExportDelegate.validateGraph(
                store, "42", schema, new StoreProperties(), null, "42", null));
  }

  /**
   * Test {@link AuthorisedGraphForExportDelegate#validateGraph(Store, String, Schema,
   * StoreProperties, List, String, Pair)} with {@code store}, {@code graphId}, {@code schema},
   * {@code storeProperties}, {@code parentSchemaIds}, {@code parentStorePropertiesId}, {@code
   * existingGraphPair}.
   *
   * <p>Method under test: {@link AuthorisedGraphForExportDelegate#validateGraph(Store, String,
   * Schema, StoreProperties, List, String, Pair)}
   */
  @Test
  @DisplayName(
      "Test validateGraph(Store, String, Schema, StoreProperties, List, String, Pair) with 'store', 'graphId', 'schema', 'storeProperties', 'parentSchemaIds', 'parentStorePropertiesId', 'existingGraphPair'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AuthorisedGraphForExportDelegate.validateGraph(Store, String, Schema, StoreProperties, List, String, Pair)"
  })
  void
      testValidateGraphWithStoreGraphIdSchemaStorePropertiesParentSchemaIdsParentStorePropertiesIdExistingGraphPair8() {
    // Arrange
    AuthorisedGraphForExportDelegate authorisedGraphForExportDelegate =
        new AuthorisedGraphForExportDelegate();

    TestStoreImpl store = new TestStoreImpl();
    store.setGraphLibrary(new FileGraphLibrary());
    Schema schema = new Schema();
    StoreProperties storeProperties = new StoreProperties();

    Pair<Schema, StoreProperties> existingGraphPair = new Pair<>(new Schema());
    existingGraphPair.setSecond(new StoreProperties());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            authorisedGraphForExportDelegate.validateGraph(
                store, "42", schema, storeProperties, null, null, existingGraphPair));
  }

  /**
   * Test {@link AuthorisedGraphForExportDelegate#validateGraph(Store, String, Schema,
   * StoreProperties, List, String, Pair)} with {@code store}, {@code graphId}, {@code schema},
   * {@code storeProperties}, {@code parentSchemaIds}, {@code parentStorePropertiesId}, {@code
   * existingGraphPair}.
   *
   * <p>Method under test: {@link AuthorisedGraphForExportDelegate#validateGraph(Store, String,
   * Schema, StoreProperties, List, String, Pair)}
   */
  @Test
  @DisplayName(
      "Test validateGraph(Store, String, Schema, StoreProperties, List, String, Pair) with 'store', 'graphId', 'schema', 'storeProperties', 'parentSchemaIds', 'parentStorePropertiesId', 'existingGraphPair'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AuthorisedGraphForExportDelegate.validateGraph(Store, String, Schema, StoreProperties, List, String, Pair)"
  })
  void
      testValidateGraphWithStoreGraphIdSchemaStorePropertiesParentSchemaIdsParentStorePropertiesIdExistingGraphPair9() {
    // Arrange
    AuthorisedGraphForExportDelegate authorisedGraphForExportDelegate =
        new AuthorisedGraphForExportDelegate();

    TestStoreImpl store = new TestStoreImpl();
    store.setGraphLibrary(new FileGraphLibrary());
    Schema schema = new Schema();
    ArrayList<String> parentSchemaIds = new ArrayList<>();

    Pair<Schema, StoreProperties> existingGraphPair = new Pair<>(new Schema());
    existingGraphPair.setSecond(new StoreProperties());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            authorisedGraphForExportDelegate.validateGraph(
                store, "42", schema, null, parentSchemaIds, "42", existingGraphPair));
  }

  /**
   * Test {@link AuthorisedGraphForExportDelegate#validateGraph(Store, String, Schema,
   * StoreProperties, List, String, Pair)} with {@code store}, {@code graphId}, {@code schema},
   * {@code storeProperties}, {@code parentSchemaIds}, {@code parentStorePropertiesId}, {@code
   * existingGraphPair}.
   *
   * <p>Method under test: {@link AuthorisedGraphForExportDelegate#validateGraph(Store, String,
   * Schema, StoreProperties, List, String, Pair)}
   */
  @Test
  @DisplayName(
      "Test validateGraph(Store, String, Schema, StoreProperties, List, String, Pair) with 'store', 'graphId', 'schema', 'storeProperties', 'parentSchemaIds', 'parentStorePropertiesId', 'existingGraphPair'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AuthorisedGraphForExportDelegate.validateGraph(Store, String, Schema, StoreProperties, List, String, Pair)"
  })
  void
      testValidateGraphWithStoreGraphIdSchemaStorePropertiesParentSchemaIdsParentStorePropertiesIdExistingGraphPair10() {
    // Arrange
    AuthorisedGraphForExportDelegate authorisedGraphForExportDelegate =
        new AuthorisedGraphForExportDelegate();

    TestStoreImpl store = new TestStoreImpl();
    store.setGraphLibrary(new FileGraphLibrary());
    Schema schema = new Schema();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            authorisedGraphForExportDelegate.validateGraph(
                store, "42", schema, null, new ArrayList<>(), null, null));
  }

  /**
   * Test {@link AuthorisedGraphForExportDelegate#validateGraph(Store, String, Schema,
   * StoreProperties, List, String, Pair)} with {@code store}, {@code graphId}, {@code schema},
   * {@code storeProperties}, {@code parentSchemaIds}, {@code parentStorePropertiesId}, {@code
   * existingGraphPair}.
   *
   * <p>Method under test: {@link AuthorisedGraphForExportDelegate#validateGraph(Store, String,
   * Schema, StoreProperties, List, String, Pair)}
   */
  @Test
  @DisplayName(
      "Test validateGraph(Store, String, Schema, StoreProperties, List, String, Pair) with 'store', 'graphId', 'schema', 'storeProperties', 'parentSchemaIds', 'parentStorePropertiesId', 'existingGraphPair'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AuthorisedGraphForExportDelegate.validateGraph(Store, String, Schema, StoreProperties, List, String, Pair)"
  })
  void
      testValidateGraphWithStoreGraphIdSchemaStorePropertiesParentSchemaIdsParentStorePropertiesIdExistingGraphPair11() {
    // Arrange
    AuthorisedGraphForExportDelegate authorisedGraphForExportDelegate =
        new AuthorisedGraphForExportDelegate();

    TestStoreImpl store = new TestStoreImpl();
    store.setGraphLibrary(new FileGraphLibrary());
    StoreProperties storeProperties = new StoreProperties();
    ArrayList<String> parentSchemaIds = new ArrayList<>();

    Pair<Schema, StoreProperties> existingGraphPair = new Pair<>(new Schema());
    existingGraphPair.setSecond(new StoreProperties());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            authorisedGraphForExportDelegate.validateGraph(
                store, "42", null, storeProperties, parentSchemaIds, "42", existingGraphPair));
  }

  /**
   * Test {@link AuthorisedGraphForExportDelegate#validateGraph(Store, String, Schema,
   * StoreProperties, List, String, Pair)} with {@code store}, {@code graphId}, {@code schema},
   * {@code storeProperties}, {@code parentSchemaIds}, {@code parentStorePropertiesId}, {@code
   * existingGraphPair}.
   *
   * <p>Method under test: {@link AuthorisedGraphForExportDelegate#validateGraph(Store, String,
   * Schema, StoreProperties, List, String, Pair)}
   */
  @Test
  @DisplayName(
      "Test validateGraph(Store, String, Schema, StoreProperties, List, String, Pair) with 'store', 'graphId', 'schema', 'storeProperties', 'parentSchemaIds', 'parentStorePropertiesId', 'existingGraphPair'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AuthorisedGraphForExportDelegate.validateGraph(Store, String, Schema, StoreProperties, List, String, Pair)"
  })
  void
      testValidateGraphWithStoreGraphIdSchemaStorePropertiesParentSchemaIdsParentStorePropertiesIdExistingGraphPair12() {
    // Arrange
    AuthorisedGraphForExportDelegate authorisedGraphForExportDelegate =
        new AuthorisedGraphForExportDelegate();

    TestStoreImpl store = new TestStoreImpl();
    store.setGraphLibrary(new HashMapGraphLibrary());
    Schema schema = new Schema();
    StoreProperties storeProperties = new StoreProperties();
    ArrayList<String> parentSchemaIds = new ArrayList<>();

    Pair<Schema, StoreProperties> existingGraphPair = new Pair<>(new Schema());
    existingGraphPair.setSecond(new StoreProperties());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            authorisedGraphForExportDelegate.validateGraph(
                store, "42", schema, storeProperties, parentSchemaIds, "42", existingGraphPair));
  }

  /**
   * Test {@link AuthorisedGraphForExportDelegate#validateGraph(Store, String, Schema,
   * StoreProperties, List, String, Pair)} with {@code store}, {@code graphId}, {@code schema},
   * {@code storeProperties}, {@code parentSchemaIds}, {@code parentStorePropertiesId}, {@code
   * existingGraphPair}.
   *
   * <p>Method under test: {@link AuthorisedGraphForExportDelegate#validateGraph(Store, String,
   * Schema, StoreProperties, List, String, Pair)}
   */
  @Test
  @DisplayName(
      "Test validateGraph(Store, String, Schema, StoreProperties, List, String, Pair) with 'store', 'graphId', 'schema', 'storeProperties', 'parentSchemaIds', 'parentStorePropertiesId', 'existingGraphPair'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AuthorisedGraphForExportDelegate.validateGraph(Store, String, Schema, StoreProperties, List, String, Pair)"
  })
  void
      testValidateGraphWithStoreGraphIdSchemaStorePropertiesParentSchemaIdsParentStorePropertiesIdExistingGraphPair13() {
    // Arrange
    AuthorisedGraphForExportDelegate authorisedGraphForExportDelegate =
        new AuthorisedGraphForExportDelegate();

    TestStoreImpl store = new TestStoreImpl();
    store.setGraphLibrary(new HashMapGraphLibrary());
    Schema schema = new Schema();
    StoreProperties storeProperties = new StoreProperties();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            authorisedGraphForExportDelegate.validateGraph(
                store, "42", schema, storeProperties, new ArrayList<>(), "42", null));
  }

  /**
   * Test {@link AuthorisedGraphForExportDelegate#validateGraph(Store, String, Schema,
   * StoreProperties, List, String, Pair)} with {@code store}, {@code graphId}, {@code schema},
   * {@code storeProperties}, {@code parentSchemaIds}, {@code parentStorePropertiesId}, {@code
   * existingGraphPair}.
   *
   * <p>Method under test: {@link AuthorisedGraphForExportDelegate#validateGraph(Store, String,
   * Schema, StoreProperties, List, String, Pair)}
   */
  @Test
  @DisplayName(
      "Test validateGraph(Store, String, Schema, StoreProperties, List, String, Pair) with 'store', 'graphId', 'schema', 'storeProperties', 'parentSchemaIds', 'parentStorePropertiesId', 'existingGraphPair'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AuthorisedGraphForExportDelegate.validateGraph(Store, String, Schema, StoreProperties, List, String, Pair)"
  })
  void
      testValidateGraphWithStoreGraphIdSchemaStorePropertiesParentSchemaIdsParentStorePropertiesIdExistingGraphPair14() {
    // Arrange
    AuthorisedGraphForExportDelegate authorisedGraphForExportDelegate =
        new AuthorisedGraphForExportDelegate();

    TestStoreImpl store = new TestStoreImpl();
    store.setGraphLibrary(null);
    Schema schema = new Schema();
    StoreProperties storeProperties = new StoreProperties();
    ArrayList<String> parentSchemaIds = new ArrayList<>();

    Pair<Schema, StoreProperties> existingGraphPair = new Pair<>(new Schema());
    existingGraphPair.setSecond(new StoreProperties());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            authorisedGraphForExportDelegate.validateGraph(
                store, "42", schema, storeProperties, parentSchemaIds, null, existingGraphPair));
  }

  /**
   * Test {@link AuthorisedGraphForExportDelegate#validateGraph(Store, String, Schema,
   * StoreProperties, List, String, Pair)} with {@code store}, {@code graphId}, {@code schema},
   * {@code storeProperties}, {@code parentSchemaIds}, {@code parentStorePropertiesId}, {@code
   * existingGraphPair}.
   *
   * <p>Method under test: {@link AuthorisedGraphForExportDelegate#validateGraph(Store, String,
   * Schema, StoreProperties, List, String, Pair)}
   */
  @Test
  @DisplayName(
      "Test validateGraph(Store, String, Schema, StoreProperties, List, String, Pair) with 'store', 'graphId', 'schema', 'storeProperties', 'parentSchemaIds', 'parentStorePropertiesId', 'existingGraphPair'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AuthorisedGraphForExportDelegate.validateGraph(Store, String, Schema, StoreProperties, List, String, Pair)"
  })
  void
      testValidateGraphWithStoreGraphIdSchemaStorePropertiesParentSchemaIdsParentStorePropertiesIdExistingGraphPair15() {
    // Arrange
    AuthorisedGraphForExportDelegate authorisedGraphForExportDelegate =
        new AuthorisedGraphForExportDelegate();

    TestStoreImpl store = new TestStoreImpl();
    store.setGraphLibrary(new HashMapGraphLibrary());
    Schema schema = new Schema();
    StoreProperties storeProperties = new StoreProperties();
    ArrayList<String> parentSchemaIds = new ArrayList<>();

    Pair<Schema, StoreProperties> existingGraphPair = new Pair<>(new Schema());
    existingGraphPair.setSecond(new StoreProperties());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            authorisedGraphForExportDelegate.validateGraph(
                store, "42", schema, storeProperties, parentSchemaIds, null, existingGraphPair));
  }

  /**
   * Test {@link AuthorisedGraphForExportDelegate#validateGraph(Store, String, Schema,
   * StoreProperties, List, String, Pair)} with {@code store}, {@code graphId}, {@code schema},
   * {@code storeProperties}, {@code parentSchemaIds}, {@code parentStorePropertiesId}, {@code
   * existingGraphPair}.
   *
   * <p>Method under test: {@link AuthorisedGraphForExportDelegate#validateGraph(Store, String,
   * Schema, StoreProperties, List, String, Pair)}
   */
  @Test
  @DisplayName(
      "Test validateGraph(Store, String, Schema, StoreProperties, List, String, Pair) with 'store', 'graphId', 'schema', 'storeProperties', 'parentSchemaIds', 'parentStorePropertiesId', 'existingGraphPair'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AuthorisedGraphForExportDelegate.validateGraph(Store, String, Schema, StoreProperties, List, String, Pair)"
  })
  void
      testValidateGraphWithStoreGraphIdSchemaStorePropertiesParentSchemaIdsParentStorePropertiesIdExistingGraphPair16() {
    // Arrange
    AuthorisedGraphForExportDelegate authorisedGraphForExportDelegate =
        new AuthorisedGraphForExportDelegate();

    TestStoreImpl store = new TestStoreImpl();
    store.setGraphLibrary(null);
    Schema schema = new Schema();
    StoreProperties storeProperties = new StoreProperties();

    Pair<Schema, StoreProperties> existingGraphPair = new Pair<>(new Schema());
    existingGraphPair.setSecond(new StoreProperties());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            authorisedGraphForExportDelegate.validateGraph(
                store, "42", schema, storeProperties, null, "42", existingGraphPair));
  }

  /**
   * Test {@link AuthorisedGraphForExportDelegate#validateGraph(Store, String, Schema,
   * StoreProperties, List, String, Pair)} with {@code store}, {@code graphId}, {@code schema},
   * {@code storeProperties}, {@code parentSchemaIds}, {@code parentStorePropertiesId}, {@code
   * existingGraphPair}.
   *
   * <p>Method under test: {@link AuthorisedGraphForExportDelegate#validateGraph(Store, String,
   * Schema, StoreProperties, List, String, Pair)}
   */
  @Test
  @DisplayName(
      "Test validateGraph(Store, String, Schema, StoreProperties, List, String, Pair) with 'store', 'graphId', 'schema', 'storeProperties', 'parentSchemaIds', 'parentStorePropertiesId', 'existingGraphPair'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AuthorisedGraphForExportDelegate.validateGraph(Store, String, Schema, StoreProperties, List, String, Pair)"
  })
  void
      testValidateGraphWithStoreGraphIdSchemaStorePropertiesParentSchemaIdsParentStorePropertiesIdExistingGraphPair17() {
    // Arrange
    AuthorisedGraphForExportDelegate authorisedGraphForExportDelegate =
        new AuthorisedGraphForExportDelegate();

    TestStoreImpl store = new TestStoreImpl();
    store.setGraphLibrary(new HashMapGraphLibrary());
    Schema schema = new Schema();
    StoreProperties storeProperties = new StoreProperties();

    Pair<Schema, StoreProperties> existingGraphPair = new Pair<>(new Schema());
    existingGraphPair.setSecond(new StoreProperties());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            authorisedGraphForExportDelegate.validateGraph(
                store, "42", schema, storeProperties, null, "42", existingGraphPair));
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link AuthorisedGraphForExportDelegate}
   *   <li>{@link AuthorisedGraphForExportDelegate#setUser(User)}
   *   <li>{@link AuthorisedGraphForExportDelegate#getIdAuths()}
   *   <li>{@link AuthorisedGraphForExportDelegate#getUser()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AuthorisedGraphForExportDelegate.<init>()",
    "Map AuthorisedGraphForExportDelegate.getIdAuths()",
    "User AuthorisedGraphForExportDelegate.getUser()",
    "void AuthorisedGraphForExportDelegate.setUser(User)"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    AuthorisedGraphForExportDelegate actualAuthorisedGraphForExportDelegate =
        new AuthorisedGraphForExportDelegate();
    User user = new User.Builder().userId("42").build();
    actualAuthorisedGraphForExportDelegate.setUser(user);
    Map<String, List<String>> actualIdAuths = actualAuthorisedGraphForExportDelegate.getIdAuths();
    User actualUser = actualAuthorisedGraphForExportDelegate.getUser();

    // Assert
    assertTrue(actualIdAuths.isEmpty());
    assertSame(user, actualUser);
  }
}
