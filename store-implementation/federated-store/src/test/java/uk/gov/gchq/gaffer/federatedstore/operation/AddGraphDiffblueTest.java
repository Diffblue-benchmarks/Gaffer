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

package uk.gov.gchq.gaffer.federatedstore.operation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.function.Predicate;
import org.apache.commons.lang3.exception.CloneFailedException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.access.predicate.AccessPredicate;
import uk.gov.gchq.gaffer.federatedstore.operation.AddGraph.AddGraphBuilder;
import uk.gov.gchq.gaffer.federatedstore.operation.AddGraph.Builder;
import uk.gov.gchq.gaffer.store.StoreProperties;
import uk.gov.gchq.gaffer.store.schema.Schema;

class AddGraphDiffblueTest {
  /**
   * Test AddGraphBuilder {@link AddGraphBuilder#graphAuths(String[])}.
   *
   * <ul>
   *   <li>When {@code Graph Auths}.
   * </ul>
   *
   * <p>Method under test: {@link AddGraphBuilder#graphAuths(String[])}
   */
  @Test
  @DisplayName("Test AddGraphBuilder graphAuths(String[]); when 'Graph Auths'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"AddGraphBuilder AddGraphBuilder.graphAuths(String[])"})
  void testAddGraphBuilderGraphAuths_whenGraphAuths() {
    // Arrange
    Builder builder = new Builder();

    // Act
    Builder actualGraphAuthsResult = builder.graphAuths("Graph Auths");

    // Assert
    assertSame(builder, actualGraphAuthsResult);
  }

  /**
   * Test AddGraphBuilder {@link AddGraphBuilder#graphAuths(String[])}.
   *
   * <ul>
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link AddGraphBuilder#graphAuths(String[])}
   */
  @Test
  @DisplayName("Test AddGraphBuilder graphAuths(String[]); when 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"AddGraphBuilder AddGraphBuilder.graphAuths(String[])"})
  void testAddGraphBuilderGraphAuths_whenNull() {
    // Arrange
    Builder builder = new Builder();

    // Act
    Builder actualGraphAuthsResult = builder.graphAuths(null);

    // Assert
    assertSame(builder, actualGraphAuthsResult);
  }

  /**
   * Test AddGraphBuilder {@link AddGraphBuilder#graphId(String)}.
   *
   * <p>Method under test: {@link AddGraphBuilder#graphId(String)}
   */
  @Test
  @DisplayName("Test AddGraphBuilder graphId(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"AddGraphBuilder AddGraphBuilder.graphId(String)"})
  void testAddGraphBuilderGraphId() {
    // Arrange
    Builder builder = new Builder();

    // Act
    Builder actualGraphIdResult = builder.graphId("42");

    // Assert
    assertSame(builder, actualGraphIdResult);
  }

  /**
   * Test AddGraphBuilder {@link AddGraphBuilder#isPublic(boolean)}.
   *
   * <p>Method under test: {@link AddGraphBuilder#isPublic(boolean)}
   */
  @Test
  @DisplayName("Test AddGraphBuilder isPublic(boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"AddGraphBuilder AddGraphBuilder.isPublic(boolean)"})
  void testAddGraphBuilderIsPublic() {
    // Arrange
    Builder builder = new Builder();

    // Act
    Builder actualIsPublicResult = builder.isPublic(true);

    // Assert
    assertSame(builder, actualIsPublicResult);
  }

  /**
   * Test AddGraphBuilder {@link AddGraphBuilder#parentPropertiesId(String)}.
   *
   * <p>Method under test: {@link AddGraphBuilder#parentPropertiesId(String)}
   */
  @Test
  @DisplayName("Test AddGraphBuilder parentPropertiesId(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"AddGraphBuilder AddGraphBuilder.parentPropertiesId(String)"})
  void testAddGraphBuilderParentPropertiesId() {
    // Arrange
    Builder builder = new Builder();

    // Act
    Builder actualParentPropertiesIdResult = builder.parentPropertiesId("42");

    // Assert
    assertSame(builder, actualParentPropertiesIdResult);
  }

  /**
   * Test AddGraphBuilder {@link AddGraphBuilder#parentSchemaIds(List)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link AddGraphBuilder#parentSchemaIds(List)}
   */
  @Test
  @DisplayName("Test AddGraphBuilder parentSchemaIds(List); given '42'; when ArrayList() add '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"AddGraphBuilder AddGraphBuilder.parentSchemaIds(List)"})
  void testAddGraphBuilderParentSchemaIds_given42_whenArrayListAdd42() {
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
   * Test AddGraphBuilder {@link AddGraphBuilder#parentSchemaIds(List)}.
   *
   * <ul>
   *   <li>Given {@code foo}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code foo}.
   * </ul>
   *
   * <p>Method under test: {@link AddGraphBuilder#parentSchemaIds(List)}
   */
  @Test
  @DisplayName(
      "Test AddGraphBuilder parentSchemaIds(List); given 'foo'; when ArrayList() add 'foo'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"AddGraphBuilder AddGraphBuilder.parentSchemaIds(List)"})
  void testAddGraphBuilderParentSchemaIds_givenFoo_whenArrayListAddFoo() {
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
   * Test AddGraphBuilder {@link AddGraphBuilder#parentSchemaIds(List)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link AddGraphBuilder#parentSchemaIds(List)}
   */
  @Test
  @DisplayName("Test AddGraphBuilder parentSchemaIds(List); when ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"AddGraphBuilder AddGraphBuilder.parentSchemaIds(List)"})
  void testAddGraphBuilderParentSchemaIds_whenArrayList() {
    // Arrange
    Builder builder = new Builder();

    // Act
    Builder actualParentSchemaIdsResult = builder.parentSchemaIds(new ArrayList<>());

    // Assert
    assertSame(builder, actualParentSchemaIdsResult);
  }

  /**
   * Test AddGraphBuilder {@link AddGraphBuilder#readAccessPredicate(AccessPredicate)}.
   *
   * <p>Method under test: {@link AddGraphBuilder#readAccessPredicate(AccessPredicate)}
   */
  @Test
  @DisplayName("Test AddGraphBuilder readAccessPredicate(AccessPredicate)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"AddGraphBuilder AddGraphBuilder.readAccessPredicate(AccessPredicate)"})
  void testAddGraphBuilderReadAccessPredicate() {
    // Arrange
    Builder builder = new Builder();

    // Act
    Builder actualReadAccessPredicateResult =
        builder.readAccessPredicate(new AccessPredicate(mock(Predicate.class)));

    // Assert
    assertSame(builder, actualReadAccessPredicateResult);
  }

  /**
   * Test AddGraphBuilder {@link AddGraphBuilder#schema(Schema)}.
   *
   * <p>Method under test: {@link AddGraphBuilder#schema(Schema)}
   */
  @Test
  @DisplayName("Test AddGraphBuilder schema(Schema)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"AddGraphBuilder AddGraphBuilder.schema(Schema)"})
  void testAddGraphBuilderSchema() {
    // Arrange
    Builder builder = new Builder();

    // Act
    Builder actualSchemaResult = builder.schema(new Schema());

    // Assert
    assertSame(builder, actualSchemaResult);
  }

  /**
   * Test AddGraphBuilder {@link AddGraphBuilder#storeProperties(StoreProperties)}.
   *
   * <p>Method under test: {@link AddGraphBuilder#storeProperties(StoreProperties)}
   */
  @Test
  @DisplayName("Test AddGraphBuilder storeProperties(StoreProperties)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"AddGraphBuilder AddGraphBuilder.storeProperties(StoreProperties)"})
  void testAddGraphBuilderStoreProperties() {
    // Arrange
    Builder builder = new Builder();

    // Act
    Builder actualStorePropertiesResult = builder.storeProperties(new StoreProperties());

    // Assert
    assertSame(builder, actualStorePropertiesResult);
  }

  /**
   * Test AddGraphBuilder {@link AddGraphBuilder#writeAccessPredicate(AccessPredicate)}.
   *
   * <p>Method under test: {@link AddGraphBuilder#writeAccessPredicate(AccessPredicate)}
   */
  @Test
  @DisplayName("Test AddGraphBuilder writeAccessPredicate(AccessPredicate)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"AddGraphBuilder AddGraphBuilder.writeAccessPredicate(AccessPredicate)"})
  void testAddGraphBuilderWriteAccessPredicate() {
    // Arrange
    Builder builder = new Builder();

    // Act
    Builder actualWriteAccessPredicateResult =
        builder.writeAccessPredicate(new AccessPredicate(mock(Predicate.class)));

    // Assert
    assertSame(builder, actualWriteAccessPredicateResult);
  }

  /**
   * Test Builder new {@link Builder} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link Builder}
   */
  @Test
  @DisplayName("Test Builder new Builder (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Builder.<init>()"})
  void testBuilderNewBuilder() {
    // Arrange and Act
    Builder actualBuilder = new Builder();

    // Assert
    AddGraph _getOpResult = actualBuilder._getOp();
    assertNull(_getOpResult.getGraphId());
    assertNull(_getOpResult.getParentPropertiesId());
    assertNull(_getOpResult.getParentSchemaIds());
    assertNull(_getOpResult.getOptions());
    assertNull(_getOpResult.getProperties());
    assertNull(_getOpResult.getGraphAuths());
    assertNull(_getOpResult.getReadAccessPredicate());
    assertNull(_getOpResult.getWriteAccessPredicate());
    assertNull(_getOpResult.getStoreProperties());
    assertNull(_getOpResult.getSchema());
    assertFalse(_getOpResult.getIsPublic());
    assertFalse(_getOpResult.isUserRequestingAdminUsage());
    AddGraph actualAddGraph = actualBuilder.build();
    assertSame(_getOpResult, actualAddGraph);
  }

  /**
   * Test {@link AddGraph#shallowClone()}.
   *
   * <ul>
   *   <li>Given {@link AddGraph} (default constructor) GraphAuths is {@link HashSet#HashSet()}.
   *   <li>Then return GraphAuths Empty.
   * </ul>
   *
   * <p>Method under test: {@link AddGraph#shallowClone()}
   */
  @Test
  @DisplayName(
      "Test shallowClone(); given AddGraph (default constructor) GraphAuths is HashSet(); then return GraphAuths Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"AddGraph AddGraph.shallowClone()"})
  void testShallowClone_givenAddGraphGraphAuthsIsHashSet_thenReturnGraphAuthsEmpty()
      throws CloneFailedException {
    // Arrange
    AddGraph addGraph = new AddGraph();
    addGraph.setGraphAuths(new HashSet<>());

    // Act
    AddGraph actualShallowCloneResult = addGraph.shallowClone();

    // Assert
    assertNull(actualShallowCloneResult.getGraphId());
    assertNull(actualShallowCloneResult.getParentPropertiesId());
    assertNull(actualShallowCloneResult.getParentSchemaIds());
    assertNull(actualShallowCloneResult.getProperties());
    assertNull(actualShallowCloneResult.getReadAccessPredicate());
    assertNull(actualShallowCloneResult.getWriteAccessPredicate());
    assertNull(actualShallowCloneResult.getStoreProperties());
    assertNull(actualShallowCloneResult.getSchema());
    assertFalse(actualShallowCloneResult.isUserRequestingAdminUsage());
    assertTrue(actualShallowCloneResult.getGraphAuths().isEmpty());
  }

  /**
   * Test {@link AddGraph#shallowClone()}.
   *
   * <ul>
   *   <li>Given {@link AddGraph} (default constructor) Options is {@link HashMap#HashMap()}.
   *   <li>Then return Options Empty.
   * </ul>
   *
   * <p>Method under test: {@link AddGraph#shallowClone()}
   */
  @Test
  @DisplayName(
      "Test shallowClone(); given AddGraph (default constructor) Options is HashMap(); then return Options Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"AddGraph AddGraph.shallowClone()"})
  void testShallowClone_givenAddGraphOptionsIsHashMap_thenReturnOptionsEmpty()
      throws CloneFailedException {
    // Arrange
    AddGraph addGraph = new AddGraph();
    addGraph.setOptions(new HashMap<>());

    // Act
    AddGraph actualShallowCloneResult = addGraph.shallowClone();

    // Assert
    assertNull(actualShallowCloneResult.getGraphId());
    assertNull(actualShallowCloneResult.getParentPropertiesId());
    assertNull(actualShallowCloneResult.getParentSchemaIds());
    assertNull(actualShallowCloneResult.getProperties());
    assertNull(actualShallowCloneResult.getReadAccessPredicate());
    assertNull(actualShallowCloneResult.getWriteAccessPredicate());
    assertNull(actualShallowCloneResult.getStoreProperties());
    assertNull(actualShallowCloneResult.getSchema());
    assertFalse(actualShallowCloneResult.isUserRequestingAdminUsage());
    assertTrue(actualShallowCloneResult.getOptions().isEmpty());
  }

  /**
   * Test {@link AddGraph#shallowClone()}.
   *
   * <ul>
   *   <li>Given {@link AddGraphWithHooks} (default constructor) GraphAuths is {@link
   *       HashSet#HashSet()}.
   * </ul>
   *
   * <p>Method under test: {@link AddGraph#shallowClone()}
   */
  @Test
  @DisplayName(
      "Test shallowClone(); given AddGraphWithHooks (default constructor) GraphAuths is HashSet()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"AddGraph AddGraph.shallowClone()"})
  void testShallowClone_givenAddGraphWithHooksGraphAuthsIsHashSet() throws CloneFailedException {
    // Arrange
    AddGraphWithHooks addGraphWithHooks = new AddGraphWithHooks();
    addGraphWithHooks.setGraphAuths(new HashSet<>());

    // Act
    AddGraphWithHooks actualShallowCloneResult = addGraphWithHooks.shallowClone();

    // Assert
    assertTrue(actualShallowCloneResult instanceof AddGraphWithHooks);
    assertNull(actualShallowCloneResult.getOptions());
    assertNull(((AddGraphWithHooks) actualShallowCloneResult).getHooks());
    assertTrue(actualShallowCloneResult.getGraphAuths().isEmpty());
  }

  /**
   * Test {@link AddGraph#shallowClone()}.
   *
   * <ul>
   *   <li>Given {@link AddGraphWithHooks} (default constructor) IsPublic is {@code true}.
   *   <li>Then return IsPublic.
   * </ul>
   *
   * <p>Method under test: {@link AddGraph#shallowClone()}
   */
  @Test
  @DisplayName(
      "Test shallowClone(); given AddGraphWithHooks (default constructor) IsPublic is 'true'; then return IsPublic")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"AddGraph AddGraph.shallowClone()"})
  void testShallowClone_givenAddGraphWithHooksIsPublicIsTrue_thenReturnIsPublic()
      throws CloneFailedException {
    // Arrange
    AddGraphWithHooks addGraphWithHooks = new AddGraphWithHooks();
    addGraphWithHooks.setIsPublic(true);

    // Act
    AddGraphWithHooks actualShallowCloneResult = addGraphWithHooks.shallowClone();

    // Assert
    assertTrue(actualShallowCloneResult instanceof AddGraphWithHooks);
    assertNull(actualShallowCloneResult.getGraphAuths());
    assertNull(((AddGraphWithHooks) actualShallowCloneResult).getHooks());
    assertTrue(actualShallowCloneResult.getIsPublic());
  }

  /**
   * Test {@link AddGraph#shallowClone()}.
   *
   * <ul>
   *   <li>Given {@link AddGraphWithHooks} (default constructor).
   *   <li>Then return Options is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link AddGraph#shallowClone()}
   */
  @Test
  @DisplayName(
      "Test shallowClone(); given AddGraphWithHooks (default constructor); then return Options is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"AddGraph AddGraph.shallowClone()"})
  void testShallowClone_givenAddGraphWithHooks_thenReturnOptionsIsNull()
      throws CloneFailedException {
    // Arrange and Act
    AddGraphWithHooks actualShallowCloneResult = new AddGraphWithHooks().shallowClone();

    // Assert
    assertTrue(actualShallowCloneResult instanceof AddGraphWithHooks);
    assertNull(actualShallowCloneResult.getOptions());
    assertNull(actualShallowCloneResult.getGraphAuths());
    assertNull(((AddGraphWithHooks) actualShallowCloneResult).getHooks());
  }

  /**
   * Test {@link AddGraph#shallowClone()}.
   *
   * <ul>
   *   <li>Given {@link AddGraph} (default constructor).
   *   <li>Then return GraphId is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link AddGraph#shallowClone()}
   */
  @Test
  @DisplayName(
      "Test shallowClone(); given AddGraph (default constructor); then return GraphId is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"AddGraph AddGraph.shallowClone()"})
  void testShallowClone_givenAddGraph_thenReturnGraphIdIsNull() throws CloneFailedException {
    // Arrange and Act
    AddGraph actualShallowCloneResult = new AddGraph().shallowClone();

    // Assert
    assertNull(actualShallowCloneResult.getGraphId());
    assertNull(actualShallowCloneResult.getParentPropertiesId());
    assertNull(actualShallowCloneResult.getParentSchemaIds());
    assertNull(actualShallowCloneResult.getProperties());
    assertNull(actualShallowCloneResult.getReadAccessPredicate());
    assertNull(actualShallowCloneResult.getWriteAccessPredicate());
    assertNull(actualShallowCloneResult.getStoreProperties());
    assertNull(actualShallowCloneResult.getSchema());
    assertFalse(actualShallowCloneResult.isUserRequestingAdminUsage());
  }

  /**
   * Test {@link AddGraph#getProperties()}.
   *
   * <ul>
   *   <li>Given {@link AddGraph} (default constructor).
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link AddGraph#getProperties()}
   */
  @Test
  @DisplayName("Test getProperties(); given AddGraph (default constructor); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Properties AddGraph.getProperties()"})
  void testGetProperties_givenAddGraph_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new AddGraph().getProperties());
  }

  /**
   * Test {@link AddGraph#getProperties()}.
   *
   * <ul>
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link AddGraph#getProperties()}
   */
  @Test
  @DisplayName("Test getProperties(); then return size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Properties AddGraph.getProperties()"})
  void testGetProperties_thenReturnSizeIsOne() {
    // Arrange
    AddGraph addGraph = new AddGraph();
    addGraph.setStoreProperties(new StoreProperties());

    // Act
    Properties actualProperties = addGraph.getProperties();

    // Assert
    assertEquals(1, actualProperties.size());
    assertEquals(
        "uk.gov.gchq.gaffer.store.StoreProperties",
        actualProperties.get("gaffer.store.properties.class"));
  }

  /**
   * Test {@link AddGraph#setProperties(Properties)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then {@link AddGraph} (default constructor) Properties is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link AddGraph#setProperties(Properties)}
   */
  @Test
  @DisplayName(
      "Test setProperties(Properties); when 'null'; then AddGraph (default constructor) Properties is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AddGraph.setProperties(Properties)"})
  void testSetProperties_whenNull_thenAddGraphPropertiesIsNull() {
    // Arrange
    AddGraph addGraph = new AddGraph();

    // Act
    addGraph.setProperties(null);

    // Assert that nothing has changed
    assertNull(addGraph.getProperties());
  }

  /**
   * Test {@link AddGraph#setProperties(Properties)}.
   *
   * <ul>
   *   <li>When {@link Properties#Properties()}.
   *   <li>Then {@link AddGraph} (default constructor) Properties is {@link
   *       Properties#Properties()}.
   * </ul>
   *
   * <p>Method under test: {@link AddGraph#setProperties(Properties)}
   */
  @Test
  @DisplayName(
      "Test setProperties(Properties); when Properties(); then AddGraph (default constructor) Properties is Properties()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AddGraph.setProperties(Properties)"})
  void testSetProperties_whenProperties_thenAddGraphPropertiesIsProperties() {
    // Arrange
    AddGraph addGraph = new AddGraph();
    Properties properties = new Properties();

    // Act
    addGraph.setProperties(properties);

    // Assert
    assertSame(properties, addGraph.getProperties());
  }

  /**
   * Test {@link AddGraph#setUserRequestingAdminUsage(boolean)}.
   *
   * <p>Method under test: {@link AddGraph#setUserRequestingAdminUsage(boolean)}
   */
  @Test
  @DisplayName("Test setUserRequestingAdminUsage(boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"AddGraph AddGraph.setUserRequestingAdminUsage(boolean)"})
  void testSetUserRequestingAdminUsage() {
    // Arrange
    AddGraph addGraph = new AddGraph();

    // Act
    AddGraph actualSetUserRequestingAdminUsageResult = addGraph.setUserRequestingAdminUsage(true);

    // Assert
    assertTrue(addGraph.isUserRequestingAdminUsage());
    assertSame(addGraph, actualSetUserRequestingAdminUsageResult);
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link AddGraph}
   *   <li>{@link AddGraph#setGraphAuths(Set)}
   *   <li>{@link AddGraph#setGraphId(String)}
   *   <li>{@link AddGraph#setIsPublic(boolean)}
   *   <li>{@link AddGraph#setOptions(Map)}
   *   <li>{@link AddGraph#setParentPropertiesId(String)}
   *   <li>{@link AddGraph#setParentSchemaIds(List)}
   *   <li>{@link AddGraph#setReadAccessPredicate(AccessPredicate)}
   *   <li>{@link AddGraph#setSchema(Schema)}
   *   <li>{@link AddGraph#setStoreProperties(StoreProperties)}
   *   <li>{@link AddGraph#setWriteAccessPredicate(AccessPredicate)}
   *   <li>{@link AddGraph#getGraphAuths()}
   *   <li>{@link AddGraph#getGraphId()}
   *   <li>{@link AddGraph#getIsPublic()}
   *   <li>{@link AddGraph#getOptions()}
   *   <li>{@link AddGraph#getParentPropertiesId()}
   *   <li>{@link AddGraph#getParentSchemaIds()}
   *   <li>{@link AddGraph#getReadAccessPredicate()}
   *   <li>{@link AddGraph#getSchema()}
   *   <li>{@link AddGraph#getStoreProperties()}
   *   <li>{@link AddGraph#getWriteAccessPredicate()}
   *   <li>{@link AddGraph#isUserRequestingAdminUsage()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AddGraph.<init>()",
    "Set AddGraph.getGraphAuths()",
    "String AddGraph.getGraphId()",
    "boolean AddGraph.getIsPublic()",
    "Map AddGraph.getOptions()",
    "String AddGraph.getParentPropertiesId()",
    "List AddGraph.getParentSchemaIds()",
    "AccessPredicate AddGraph.getReadAccessPredicate()",
    "Schema AddGraph.getSchema()",
    "StoreProperties AddGraph.getStoreProperties()",
    "AccessPredicate AddGraph.getWriteAccessPredicate()",
    "boolean AddGraph.isUserRequestingAdminUsage()",
    "void AddGraph.setGraphAuths(Set)",
    "void AddGraph.setGraphId(String)",
    "void AddGraph.setIsPublic(boolean)",
    "void AddGraph.setOptions(Map)",
    "void AddGraph.setParentPropertiesId(String)",
    "void AddGraph.setParentSchemaIds(List)",
    "void AddGraph.setReadAccessPredicate(AccessPredicate)",
    "void AddGraph.setSchema(Schema)",
    "void AddGraph.setStoreProperties(StoreProperties)",
    "void AddGraph.setWriteAccessPredicate(AccessPredicate)"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    AddGraph actualAddGraph = new AddGraph();
    HashSet<String> graphAuths = new HashSet<>();
    actualAddGraph.setGraphAuths(graphAuths);
    actualAddGraph.setGraphId("42");
    actualAddGraph.setIsPublic(true);
    HashMap<String, String> options = new HashMap<>();
    actualAddGraph.setOptions(options);
    actualAddGraph.setParentPropertiesId("42");
    ArrayList<String> parentSchemaIds = new ArrayList<>();
    actualAddGraph.setParentSchemaIds(parentSchemaIds);
    AccessPredicate readAccessPredicate = new AccessPredicate(mock(Predicate.class));
    actualAddGraph.setReadAccessPredicate(readAccessPredicate);
    Schema schema = new Schema();
    actualAddGraph.setSchema(schema);
    StoreProperties properties = new StoreProperties();
    actualAddGraph.setStoreProperties(properties);
    AccessPredicate writeAccessPredicate = new AccessPredicate(mock(Predicate.class));
    actualAddGraph.setWriteAccessPredicate(writeAccessPredicate);
    Set<String> actualGraphAuths = actualAddGraph.getGraphAuths();
    String actualGraphId = actualAddGraph.getGraphId();
    boolean actualIsPublic = actualAddGraph.getIsPublic();
    Map<String, String> actualOptions = actualAddGraph.getOptions();
    String actualParentPropertiesId = actualAddGraph.getParentPropertiesId();
    List<String> actualParentSchemaIds = actualAddGraph.getParentSchemaIds();
    AccessPredicate actualReadAccessPredicate = actualAddGraph.getReadAccessPredicate();
    Schema actualSchema = actualAddGraph.getSchema();
    StoreProperties actualStoreProperties = actualAddGraph.getStoreProperties();
    AccessPredicate actualWriteAccessPredicate = actualAddGraph.getWriteAccessPredicate();

    // Assert
    assertEquals("42", actualGraphId);
    assertEquals("42", actualParentPropertiesId);
    assertFalse(actualAddGraph.isUserRequestingAdminUsage());
    assertTrue(actualParentSchemaIds.isEmpty());
    assertTrue(actualOptions.isEmpty());
    assertTrue(actualGraphAuths.isEmpty());
    assertTrue(actualIsPublic);
    assertSame(parentSchemaIds, actualParentSchemaIds);
    assertSame(options, actualOptions);
    assertSame(graphAuths, actualGraphAuths);
    assertSame(readAccessPredicate, actualReadAccessPredicate);
    assertSame(writeAccessPredicate, actualWriteAccessPredicate);
    assertSame(properties, actualStoreProperties);
    assertSame(schema, actualSchema);
  }
}
