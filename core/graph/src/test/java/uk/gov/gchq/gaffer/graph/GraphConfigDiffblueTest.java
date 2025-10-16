package uk.gov.gchq.gaffer.graph;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.data.elementdefinition.exception.SchemaException;
import uk.gov.gchq.gaffer.data.elementdefinition.view.View;
import uk.gov.gchq.gaffer.graph.GraphTest.TestStoreImpl;
import uk.gov.gchq.gaffer.graph.hook.AddOperationsToChain;
import uk.gov.gchq.gaffer.graph.hook.GetFromCacheHook;
import uk.gov.gchq.gaffer.graph.hook.GraphHook;
import uk.gov.gchq.gaffer.graph.hook.GraphHookPath;
import uk.gov.gchq.gaffer.graph.hook.UpdateViewHook;
import uk.gov.gchq.gaffer.graph.hook.UpdateViewHook.Builder;
import uk.gov.gchq.gaffer.graph.hook.exception.GraphHookException;
import uk.gov.gchq.gaffer.integration.store.TestStore;
import uk.gov.gchq.gaffer.operation.Operation;
import uk.gov.gchq.gaffer.store.Store;
import uk.gov.gchq.gaffer.store.library.FileGraphLibrary;
import uk.gov.gchq.gaffer.store.library.GraphLibrary;
import uk.gov.gchq.gaffer.store.operation.handler.OperationHandler;
import uk.gov.gchq.gaffer.store.schema.Schema;

class GraphConfigDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link GraphConfig#GraphConfig()}
   *   <li>{@link GraphConfig#setDescription(String)}
   *   <li>{@link GraphConfig#setGraphId(String)}
   *   <li>{@link GraphConfig#setLibrary(GraphLibrary)}
   *   <li>{@link GraphConfig#setOtelActive(Boolean)}
   *   <li>{@link GraphConfig#toString()}
   *   <li>{@link GraphConfig#getDescription()}
   *   <li>{@link GraphConfig#getGraphId()}
   *   <li>{@link GraphConfig#getHooks()}
   *   <li>{@link GraphConfig#getLibrary()}
   *   <li>{@link GraphConfig#getOtelActive()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void GraphConfig.<init>()",
    "void GraphConfig.<init>(String)",
    "String GraphConfig.getDescription()",
    "String GraphConfig.getGraphId()",
    "List GraphConfig.getHooks()",
    "GraphLibrary GraphConfig.getLibrary()",
    "Boolean GraphConfig.getOtelActive()",
    "void GraphConfig.setDescription(String)",
    "void GraphConfig.setGraphId(String)",
    "void GraphConfig.setLibrary(GraphLibrary)",
    "void GraphConfig.setOtelActive(Boolean)",
    "String GraphConfig.toString()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    GraphConfig actualGraphConfig = new GraphConfig();
    actualGraphConfig.setDescription("The characteristics of someone or something");
    actualGraphConfig.setGraphId("42");
    FileGraphLibrary library = new FileGraphLibrary();
    actualGraphConfig.setLibrary(library);
    actualGraphConfig.setOtelActive(true);
    actualGraphConfig.toString();
    String actualDescription = actualGraphConfig.getDescription();
    String actualGraphId = actualGraphConfig.getGraphId();
    List<GraphHook> actualHooks = actualGraphConfig.getHooks();
    GraphLibrary actualLibrary = actualGraphConfig.getLibrary();
    Boolean actualOtelActive = actualGraphConfig.getOtelActive();

    // Assert
    assertTrue(actualLibrary instanceof FileGraphLibrary);
    assertEquals("42", actualGraphId);
    assertEquals("The characteristics of someone or something", actualDescription);
    assertTrue(actualHooks.isEmpty());
    assertTrue(actualOtelActive);
    assertSame(library, actualLibrary);
  }

  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>When {@code 42}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link GraphConfig#GraphConfig(String)}
   *   <li>{@link GraphConfig#setDescription(String)}
   *   <li>{@link GraphConfig#setGraphId(String)}
   *   <li>{@link GraphConfig#setLibrary(GraphLibrary)}
   *   <li>{@link GraphConfig#setOtelActive(Boolean)}
   *   <li>{@link GraphConfig#toString()}
   *   <li>{@link GraphConfig#getDescription()}
   *   <li>{@link GraphConfig#getGraphId()}
   *   <li>{@link GraphConfig#getHooks()}
   *   <li>{@link GraphConfig#getLibrary()}
   *   <li>{@link GraphConfig#getOtelActive()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; when '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void GraphConfig.<init>()",
    "void GraphConfig.<init>(String)",
    "String GraphConfig.getDescription()",
    "String GraphConfig.getGraphId()",
    "List GraphConfig.getHooks()",
    "GraphLibrary GraphConfig.getLibrary()",
    "Boolean GraphConfig.getOtelActive()",
    "void GraphConfig.setDescription(String)",
    "void GraphConfig.setGraphId(String)",
    "void GraphConfig.setLibrary(GraphLibrary)",
    "void GraphConfig.setOtelActive(Boolean)",
    "String GraphConfig.toString()"
  })
  void testGettersAndSetters_when42() {
    // Arrange and Act
    GraphConfig actualGraphConfig = new GraphConfig("42");
    actualGraphConfig.setDescription("The characteristics of someone or something");
    actualGraphConfig.setGraphId("42");
    FileGraphLibrary library = new FileGraphLibrary();
    actualGraphConfig.setLibrary(library);
    actualGraphConfig.setOtelActive(true);
    actualGraphConfig.toString();
    String actualDescription = actualGraphConfig.getDescription();
    String actualGraphId = actualGraphConfig.getGraphId();
    List<GraphHook> actualHooks = actualGraphConfig.getHooks();
    GraphLibrary actualLibrary = actualGraphConfig.getLibrary();
    Boolean actualOtelActive = actualGraphConfig.getOtelActive();

    // Assert
    assertTrue(actualLibrary instanceof FileGraphLibrary);
    assertEquals("42", actualGraphId);
    assertEquals("The characteristics of someone or something", actualDescription);
    assertTrue(actualHooks.isEmpty());
    assertTrue(actualOtelActive);
    assertSame(library, actualLibrary);
  }

  /**
   * Test {@link GraphConfig#getView()}.
   *
   * <p>Method under test: {@link GraphConfig#getView()}
   */
  @Test
  @DisplayName("Test getView()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"View GraphConfig.getView()"})
  void testGetView() throws SchemaException {
    // Arrange
    GraphConfig graphConfig =
        new GraphConfig.Builder()
            .description("The characteristics of someone or something")
            .build();
    graphConfig.setView(new View());

    // Act
    View actualView = graphConfig.getView();

    // Assert
    assertFalse(actualView.isAllEdges());
    assertFalse(actualView.isAllEntities());
    assertTrue(actualView.getConfig().isEmpty());
    assertArrayEquals(new byte[] {'{', '}'}, actualView.toCompactJson());
  }

  /**
   * Test {@link GraphConfig#getView()}.
   *
   * <ul>
   *   <li>Given {@link GraphConfig#GraphConfig(String)} with graphId is {@code 42} View is {@link
   *       View} (default constructor).
   *   <li>Then return Config Empty.
   * </ul>
   *
   * <p>Method under test: {@link GraphConfig#getView()}
   */
  @Test
  @DisplayName(
      "Test getView(); given GraphConfig(String) with graphId is '42' View is View (default constructor); then return Config Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"View GraphConfig.getView()"})
  void testGetView_givenGraphConfigWithGraphIdIs42ViewIsView_thenReturnConfigEmpty()
      throws SchemaException {
    // Arrange
    GraphConfig graphConfig = new GraphConfig("42");
    graphConfig.setView(new View());

    // Act
    View actualView = graphConfig.getView();

    // Assert
    assertFalse(actualView.isAllEdges());
    assertFalse(actualView.isAllEntities());
    assertTrue(actualView.getConfig().isEmpty());
    assertArrayEquals(new byte[] {'{', '}'}, actualView.toCompactJson());
  }

  /**
   * Test {@link GraphConfig#getView()}.
   *
   * <ul>
   *   <li>Given {@link GraphConfig#GraphConfig(String)} with graphId is {@code 42}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link GraphConfig#getView()}
   */
  @Test
  @DisplayName("Test getView(); given GraphConfig(String) with graphId is '42'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"View GraphConfig.getView()"})
  void testGetView_givenGraphConfigWithGraphIdIs42_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new GraphConfig("42").getView());
  }

  /**
   * Test {@link GraphConfig#getView()}.
   *
   * <ul>
   *   <li>Given {@link View} (default constructor) AllEdges is {@code true}.
   *   <li>Then return AllEdges.
   * </ul>
   *
   * <p>Method under test: {@link GraphConfig#getView()}
   */
  @Test
  @DisplayName(
      "Test getView(); given View (default constructor) AllEdges is 'true'; then return AllEdges")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"View GraphConfig.getView()"})
  void testGetView_givenViewAllEdgesIsTrue_thenReturnAllEdges()
      throws UnsupportedEncodingException, SchemaException {
    // Arrange
    View view = new View();
    view.setAllEdges(true);
    view.addConfig("Key", "42");

    GraphConfig graphConfig = new GraphConfig("42");
    graphConfig.setView(view);

    // Act
    View actualView = graphConfig.getView();

    // Assert
    Map<String, String> config = actualView.getConfig();
    assertEquals(1, config.size());
    assertEquals("42", config.get("Key"));
    assertTrue(actualView.isAllEdges());
    byte[] expectedToCompactJsonResult =
        "{\"allEdges\":true,\"config\":{\"Key\":\"42\"}}".getBytes("UTF-8");
    assertArrayEquals(expectedToCompactJsonResult, actualView.toCompactJson());
  }

  /**
   * Test {@link GraphConfig#getView()}.
   *
   * <ul>
   *   <li>Given {@link View} (default constructor) AllEntities is {@code true}.
   *   <li>Then return AllEntities.
   * </ul>
   *
   * <p>Method under test: {@link GraphConfig#getView()}
   */
  @Test
  @DisplayName(
      "Test getView(); given View (default constructor) AllEntities is 'true'; then return AllEntities")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"View GraphConfig.getView()"})
  void testGetView_givenViewAllEntitiesIsTrue_thenReturnAllEntities()
      throws UnsupportedEncodingException, SchemaException {
    // Arrange
    View view = new View();
    view.setAllEntities(true);
    view.addConfig("Key", "42");

    GraphConfig graphConfig = new GraphConfig("42");
    graphConfig.setView(view);

    // Act
    View actualView = graphConfig.getView();

    // Assert
    Map<String, String> config = actualView.getConfig();
    assertEquals(1, config.size());
    assertEquals("42", config.get("Key"));
    assertTrue(actualView.isAllEntities());
    byte[] expectedToCompactJsonResult =
        "{\"allEntities\":true,\"config\":{\"Key\":\"42\"}}".getBytes("UTF-8");
    assertArrayEquals(expectedToCompactJsonResult, actualView.toCompactJson());
  }

  /**
   * Test {@link GraphConfig#getView()}.
   *
   * <ul>
   *   <li>Then return toCompactJson is {@code {"config":{"Key":"42"}}} Bytes is {@code UTF-8}.
   * </ul>
   *
   * <p>Method under test: {@link GraphConfig#getView()}
   */
  @Test
  @DisplayName(
      "Test getView(); then return toCompactJson is '{\"config\":{\"Key\":\"42\"}}' Bytes is 'UTF-8'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"View GraphConfig.getView()"})
  void testGetView_thenReturnToCompactJsonIsConfigKey42BytesIsUtf8()
      throws UnsupportedEncodingException, SchemaException {
    // Arrange
    View view = new View();
    view.addConfig("Key", "42");

    GraphConfig graphConfig = new GraphConfig("42");
    graphConfig.setView(view);

    // Act
    View actualView = graphConfig.getView();

    // Assert
    Map<String, String> config = actualView.getConfig();
    assertEquals(1, config.size());
    assertEquals("42", config.get("Key"));
    assertFalse(actualView.isAllEdges());
    assertFalse(actualView.isAllEntities());
    byte[] expectedToCompactJsonResult = "{\"config\":{\"Key\":\"42\"}}".getBytes("UTF-8");
    assertArrayEquals(expectedToCompactJsonResult, actualView.toCompactJson());
  }

  /**
   * Test {@link GraphConfig#setView(View)}.
   *
   * <ul>
   *   <li>Given {@code true}.
   *   <li>When {@link View} (default constructor) AllEntities is {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link GraphConfig#setView(View)}
   */
  @Test
  @DisplayName(
      "Test setView(View); given 'true'; when View (default constructor) AllEntities is 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void GraphConfig.setView(View)"})
  void testSetView_givenTrue_whenViewAllEntitiesIsTrue() {
    // Arrange
    GraphConfig graphConfig = new GraphConfig("42");

    View view = new View();
    view.setAllEntities(true);

    // Act
    graphConfig.setView(view);

    // Assert
    assertEquals(view, graphConfig.getView());
  }

  /**
   * Test {@link GraphConfig#setView(View)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then {@link GraphConfig#GraphConfig(String)} with graphId is {@code 42} View is {@code
   *       null}.
   * </ul>
   *
   * <p>Method under test: {@link GraphConfig#setView(View)}
   */
  @Test
  @DisplayName(
      "Test setView(View); when 'null'; then GraphConfig(String) with graphId is '42' View is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void GraphConfig.setView(View)"})
  void testSetView_whenNull_thenGraphConfigWithGraphIdIs42ViewIsNull() {
    // Arrange
    GraphConfig graphConfig = new GraphConfig("42");

    // Act
    graphConfig.setView(null);

    // Assert that nothing has changed
    assertNull(graphConfig.getView());
  }

  /**
   * Test {@link GraphConfig#setView(View)}.
   *
   * <ul>
   *   <li>When {@link View} (default constructor).
   *   <li>Then {@link GraphConfig#GraphConfig(String)} with graphId is {@code 42} View is {@link
   *       View} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link GraphConfig#setView(View)}
   */
  @Test
  @DisplayName(
      "Test setView(View); when View (default constructor); then GraphConfig(String) with graphId is '42' View is View (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void GraphConfig.setView(View)"})
  void testSetView_whenView_thenGraphConfigWithGraphIdIs42ViewIsView() {
    // Arrange
    GraphConfig graphConfig = new GraphConfig("42");
    View view = new View();

    // Act
    graphConfig.setView(view);

    // Assert
    assertEquals(view, graphConfig.getView());
  }

  /**
   * Test {@link GraphConfig#setHooks(List)}.
   *
   * <ul>
   *   <li>Then {@link GraphConfig#GraphConfig(String)} with graphId is {@code 42} Hooks is {@link
   *       ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link GraphConfig#setHooks(List)}
   */
  @Test
  @DisplayName(
      "Test setHooks(List); then GraphConfig(String) with graphId is '42' Hooks is ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void GraphConfig.setHooks(List)"})
  void testSetHooks_thenGraphConfigWithGraphIdIs42HooksIsArrayList() {
    // Arrange
    GraphConfig graphConfig = new GraphConfig("42");

    ArrayList<GraphHook> hooks = new ArrayList<>();

    Builder builder = new Builder();

    Builder blackListElementGroupsResult = builder.blackListElementGroups(new HashSet<>());

    Builder setViewToMergeResult = blackListElementGroupsResult.setViewToMerge(new View());

    Builder whiteListElementGroupsResult =
        setViewToMergeResult.whiteListElementGroups(new HashSet<>());

    Builder withDataAuthResult = whiteListElementGroupsResult.withDataAuth(new HashSet<>());

    Builder withOpAuthResult = withDataAuthResult.withOpAuth(new HashSet<>());

    Builder withoutDataAuthResult = withOpAuthResult.withoutDataAuth(new HashSet<>());
    hooks.add(withoutDataAuthResult.withoutOpAuth(new HashSet<>()).build());

    Builder builder2 = new Builder();

    Builder blackListElementGroupsResult2 = builder2.blackListElementGroups(new HashSet<>());

    Builder setViewToMergeResult2 = blackListElementGroupsResult2.setViewToMerge(new View());

    Builder whiteListElementGroupsResult2 =
        setViewToMergeResult2.whiteListElementGroups(new HashSet<>());

    Builder withDataAuthResult2 = whiteListElementGroupsResult2.withDataAuth(new HashSet<>());

    Builder withOpAuthResult2 = withDataAuthResult2.withOpAuth(new HashSet<>());

    Builder withoutDataAuthResult2 = withOpAuthResult2.withoutDataAuth(new HashSet<>());
    hooks.add(withoutDataAuthResult2.withoutOpAuth(new HashSet<>()).build());

    // Act
    graphConfig.setHooks(hooks);

    // Assert
    assertEquals(hooks, graphConfig.getHooks());
  }

  /**
   * Test {@link GraphConfig#setHooks(List)}.
   *
   * <ul>
   *   <li>Then {@link GraphConfig#GraphConfig(String)} with graphId is {@code 42} Hooks size is
   *       one.
   * </ul>
   *
   * <p>Method under test: {@link GraphConfig#setHooks(List)}
   */
  @Test
  @DisplayName(
      "Test setHooks(List); then GraphConfig(String) with graphId is '42' Hooks size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void GraphConfig.setHooks(List)"})
  void testSetHooks_thenGraphConfigWithGraphIdIs42HooksSizeIsOne() {
    // Arrange
    GraphConfig graphConfig = new GraphConfig("42");

    ArrayList<GraphHook> hooks = new ArrayList<>();

    Builder builder = new Builder();

    Builder blackListElementGroupsResult = builder.blackListElementGroups(new HashSet<>());

    Builder setViewToMergeResult = blackListElementGroupsResult.setViewToMerge(new View());

    Builder whiteListElementGroupsResult =
        setViewToMergeResult.whiteListElementGroups(new HashSet<>());

    Builder withDataAuthResult = whiteListElementGroupsResult.withDataAuth(new HashSet<>());

    Builder withOpAuthResult = withDataAuthResult.withOpAuth(new HashSet<>());

    Builder withoutDataAuthResult = withOpAuthResult.withoutDataAuth(new HashSet<>());
    hooks.add(withoutDataAuthResult.withoutOpAuth(new HashSet<>()).build());

    // Act
    graphConfig.setHooks(hooks);

    // Assert
    assertEquals(1, graphConfig.getHooks().size());
  }

  /**
   * Test {@link GraphConfig#setHooks(List)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then {@link GraphConfig#GraphConfig(String)} with graphId is {@code 42} Hooks Empty.
   * </ul>
   *
   * <p>Method under test: {@link GraphConfig#setHooks(List)}
   */
  @Test
  @DisplayName(
      "Test setHooks(List); when ArrayList(); then GraphConfig(String) with graphId is '42' Hooks Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void GraphConfig.setHooks(List)"})
  void testSetHooks_whenArrayList_thenGraphConfigWithGraphIdIs42HooksEmpty() {
    // Arrange
    GraphConfig graphConfig = new GraphConfig("42");

    // Act
    graphConfig.setHooks(new ArrayList<>());

    // Assert that nothing has changed
    assertTrue(graphConfig.getHooks().isEmpty());
  }

  /**
   * Test {@link GraphConfig#setHooks(List)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then {@link GraphConfig#GraphConfig(String)} with graphId is {@code 42} Hooks Empty.
   * </ul>
   *
   * <p>Method under test: {@link GraphConfig#setHooks(List)}
   */
  @Test
  @DisplayName(
      "Test setHooks(List); when 'null'; then GraphConfig(String) with graphId is '42' Hooks Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void GraphConfig.setHooks(List)"})
  void testSetHooks_whenNull_thenGraphConfigWithGraphIdIs42HooksEmpty() {
    // Arrange
    GraphConfig graphConfig = new GraphConfig("42");

    // Act
    graphConfig.setHooks(null);

    // Assert that nothing has changed
    assertTrue(graphConfig.getHooks().isEmpty());
  }

  /**
   * Test {@link GraphConfig#addHook(GraphHook)}.
   *
   * <ul>
   *   <li>Given {@code Path}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link GraphConfig#addHook(GraphHook)}
   */
  @Test
  @DisplayName("Test addHook(GraphHook); given 'Path'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void GraphConfig.addHook(GraphHook)"})
  void testAddHook_givenPath_thenThrowIllegalArgumentException() {
    // Arrange
    GraphConfig graphConfig = new GraphConfig("42");

    GraphHookPath hook = new GraphHookPath();
    hook.setPath("Path");

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> graphConfig.addHook(hook));
  }

  /**
   * Test {@link GraphConfig#addHook(GraphHook)}.
   *
   * <ul>
   *   <li>Then {@link GraphConfig#GraphConfig(String)} with graphId is {@code 42} Hooks size is
   *       one.
   * </ul>
   *
   * <p>Method under test: {@link GraphConfig#addHook(GraphHook)}
   */
  @Test
  @DisplayName(
      "Test addHook(GraphHook); then GraphConfig(String) with graphId is '42' Hooks size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void GraphConfig.addHook(GraphHook)"})
  void testAddHook_thenGraphConfigWithGraphIdIs42HooksSizeIsOne() {
    // Arrange
    GraphConfig graphConfig = new GraphConfig("42");
    AddOperationsToChain hook = new AddOperationsToChain();

    // Act
    graphConfig.addHook(hook);

    // Assert
    List<GraphHook> hooks = graphConfig.getHooks();
    assertEquals(1, hooks.size());
    assertSame(hook, hooks.get(0));
  }

  /**
   * Test {@link GraphConfig#addHook(GraphHook)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then {@link GraphConfig#GraphConfig(String)} with graphId is {@code 42} Hooks Empty.
   * </ul>
   *
   * <p>Method under test: {@link GraphConfig#addHook(GraphHook)}
   */
  @Test
  @DisplayName(
      "Test addHook(GraphHook); when 'null'; then GraphConfig(String) with graphId is '42' Hooks Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void GraphConfig.addHook(GraphHook)"})
  void testAddHook_whenNull_thenGraphConfigWithGraphIdIs42HooksEmpty() {
    // Arrange
    GraphConfig graphConfig = new GraphConfig("42");

    // Act
    graphConfig.addHook(null);

    // Assert that nothing has changed
    assertTrue(graphConfig.getHooks().isEmpty());
  }

  /**
   * Test {@link GraphConfig#hasHook(Class)}.
   *
   * <ul>
   *   <li>Given {@link GraphConfig#GraphConfig(String)} with graphId is {@code 42}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link GraphConfig#hasHook(Class)}
   */
  @Test
  @DisplayName(
      "Test hasHook(Class); given GraphConfig(String) with graphId is '42'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean GraphConfig.hasHook(Class)"})
  void testHasHook_givenGraphConfigWithGraphIdIs42_thenReturnFalse() {
    // Arrange
    GraphConfig graphConfig = new GraphConfig("42");
    Class<GraphHook> hookClass = GraphHook.class;

    // Act and Assert
    assertFalse(graphConfig.hasHook(hookClass));
  }

  /**
   * Test {@link GraphConfig#hasHook(Class)}.
   *
   * <ul>
   *   <li>When {@code GraphHook}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link GraphConfig#hasHook(Class)}
   */
  @Test
  @DisplayName(
      "Test hasHook(Class); when 'uk.gov.gchq.gaffer.graph.hook.GraphHook'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean GraphConfig.hasHook(Class)"})
  void testHasHook_whenUkGovGchqGafferGraphHookGraphHook_thenReturnTrue() {
    // Arrange
    GraphConfig graphConfig = new GraphConfig("42");

    Builder builder = new Builder();

    Builder blackListElementGroupsResult = builder.blackListElementGroups(new HashSet<>());

    Builder setViewToMergeResult = blackListElementGroupsResult.setViewToMerge(new View());

    Builder whiteListElementGroupsResult =
        setViewToMergeResult.whiteListElementGroups(new HashSet<>());

    Builder withDataAuthResult = whiteListElementGroupsResult.withDataAuth(new HashSet<>());

    Builder withOpAuthResult = withDataAuthResult.withOpAuth(new HashSet<>());

    Builder withoutDataAuthResult = withOpAuthResult.withoutDataAuth(new HashSet<>());
    graphConfig.addHook(withoutDataAuthResult.withoutOpAuth(new HashSet<>()).build());
    Class<GraphHook> hookClass = GraphHook.class;

    // Act and Assert
    assertTrue(graphConfig.hasHook(hookClass));
  }

  /**
   * Test {@link GraphConfig#validateAndUpdateGetFromCacheHook(Store, Class, Class, String)}.
   *
   * <ul>
   *   <li>Then {@link GraphConfig#GraphConfig(String)} with graphId is {@code 42} Hooks Empty.
   * </ul>
   *
   * <p>Method under test: {@link GraphConfig#validateAndUpdateGetFromCacheHook(Store, Class, Class,
   * String)}
   */
  @Test
  @DisplayName(
      "Test validateAndUpdateGetFromCacheHook(Store, Class, Class, String); then GraphConfig(String) with graphId is '42' Hooks Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void GraphConfig.validateAndUpdateGetFromCacheHook(Store, Class, Class, String)"
  })
  void testValidateAndUpdateGetFromCacheHook_thenGraphConfigWithGraphIdIs42HooksEmpty() {
    // Arrange
    GraphConfig graphConfig = new GraphConfig("42");
    TestStoreImpl store = new TestStoreImpl();
    Class<Operation> operationClass = Operation.class;
    Class<GetFromCacheHook> hookClass = GetFromCacheHook.class;

    // Act
    graphConfig.validateAndUpdateGetFromCacheHook(
        store, operationClass, hookClass, "jane.doe@example.org");

    // Assert that nothing has changed
    assertTrue(graphConfig.getHooks().isEmpty());
  }

  /**
   * Test {@link GraphConfig#validateAndUpdateGetFromCacheHook(Store, Class, Class, String)}.
   *
   * <ul>
   *   <li>Then throw {@link GraphHookException}.
   * </ul>
   *
   * <p>Method under test: {@link GraphConfig#validateAndUpdateGetFromCacheHook(Store, Class, Class,
   * String)}
   */
  @Test
  @DisplayName(
      "Test validateAndUpdateGetFromCacheHook(Store, Class, Class, String); then throw GraphHookException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void GraphConfig.validateAndUpdateGetFromCacheHook(Store, Class, Class, String)"
  })
  void testValidateAndUpdateGetFromCacheHook_thenThrowGraphHookException() {
    // Arrange
    GraphConfig graphConfig = new GraphConfig("42");

    TestStoreImpl store = new TestStoreImpl();
    Class<Operation> opClass = Operation.class;
    store.addOperationHandler(opClass, mock(OperationHandler.class));
    Class<Operation> operationClass = Operation.class;
    Class<GetFromCacheHook> hookClass = GetFromCacheHook.class;

    // Act and Assert
    assertThrows(
        GraphHookException.class,
        () ->
            graphConfig.validateAndUpdateGetFromCacheHook(
                store, operationClass, hookClass, "jane.doe@example.org"));
  }

  /**
   * Test {@link GraphConfig#validateAndUpdateGetFromCacheHook(Store, Class, Class, String)}.
   *
   * <ul>
   *   <li>Then throw {@link GraphHookException}.
   * </ul>
   *
   * <p>Method under test: {@link GraphConfig#validateAndUpdateGetFromCacheHook(Store, Class, Class,
   * String)}
   */
  @Test
  @DisplayName(
      "Test validateAndUpdateGetFromCacheHook(Store, Class, Class, String); then throw GraphHookException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void GraphConfig.validateAndUpdateGetFromCacheHook(Store, Class, Class, String)"
  })
  void testValidateAndUpdateGetFromCacheHook_thenThrowGraphHookException2() {
    // Arrange
    GraphConfig graphConfig = new GraphConfig("42");

    Builder builder = new Builder();

    Builder blackListElementGroupsResult = builder.blackListElementGroups(new HashSet<>());

    Builder setViewToMergeResult = blackListElementGroupsResult.setViewToMerge(new View());

    Builder whiteListElementGroupsResult =
        setViewToMergeResult.whiteListElementGroups(new HashSet<>());

    Builder withDataAuthResult = whiteListElementGroupsResult.withDataAuth(new HashSet<>());

    Builder withOpAuthResult = withDataAuthResult.withOpAuth(new HashSet<>());

    Builder withoutDataAuthResult = withOpAuthResult.withoutDataAuth(new HashSet<>());
    graphConfig.addHook(withoutDataAuthResult.withoutOpAuth(new HashSet<>()).build());

    TestStoreImpl store = new TestStoreImpl();
    Class<Operation> opClass = Operation.class;
    store.addOperationHandler(opClass, mock(OperationHandler.class));
    Class<Operation> operationClass = Operation.class;
    Class<GetFromCacheHook> hookClass = GetFromCacheHook.class;

    // Act and Assert
    assertThrows(
        GraphHookException.class,
        () ->
            graphConfig.validateAndUpdateGetFromCacheHook(
                store, operationClass, hookClass, "jane.doe@example.org"));
  }

  /**
   * Test {@link GraphConfig#validateAndUpdateGetFromCacheHook(Store, Class, Class, String)}.
   *
   * <ul>
   *   <li>Then throw {@link GraphHookException}.
   * </ul>
   *
   * <p>Method under test: {@link GraphConfig#validateAndUpdateGetFromCacheHook(Store, Class, Class,
   * String)}
   */
  @Test
  @DisplayName(
      "Test validateAndUpdateGetFromCacheHook(Store, Class, Class, String); then throw GraphHookException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void GraphConfig.validateAndUpdateGetFromCacheHook(Store, Class, Class, String)"
  })
  void testValidateAndUpdateGetFromCacheHook_thenThrowGraphHookException3() {
    // Arrange
    GraphConfig graphConfig = new GraphConfig("42");

    Builder builder = new Builder();

    Builder blackListElementGroupsResult = builder.blackListElementGroups(new HashSet<>());

    Builder setViewToMergeResult = blackListElementGroupsResult.setViewToMerge(new View());

    Builder whiteListElementGroupsResult =
        setViewToMergeResult.whiteListElementGroups(new HashSet<>());

    Builder withDataAuthResult = whiteListElementGroupsResult.withDataAuth(new HashSet<>());

    Builder withOpAuthResult = withDataAuthResult.withOpAuth(new HashSet<>());

    Builder withoutDataAuthResult = withOpAuthResult.withoutDataAuth(new HashSet<>());
    graphConfig.addHook(withoutDataAuthResult.withoutOpAuth(new HashSet<>()).build());

    Builder builder2 = new Builder();

    Builder blackListElementGroupsResult2 = builder2.blackListElementGroups(new HashSet<>());

    Builder setViewToMergeResult2 = blackListElementGroupsResult2.setViewToMerge(new View());

    Builder whiteListElementGroupsResult2 =
        setViewToMergeResult2.whiteListElementGroups(new HashSet<>());

    Builder withDataAuthResult2 = whiteListElementGroupsResult2.withDataAuth(new HashSet<>());

    Builder withOpAuthResult2 = withDataAuthResult2.withOpAuth(new HashSet<>());

    Builder withoutDataAuthResult2 = withOpAuthResult2.withoutDataAuth(new HashSet<>());
    graphConfig.addHook(withoutDataAuthResult2.withoutOpAuth(new HashSet<>()).build());

    TestStoreImpl store = new TestStoreImpl();
    Class<Operation> opClass = Operation.class;
    store.addOperationHandler(opClass, mock(OperationHandler.class));
    Class<Operation> operationClass = Operation.class;
    Class<GetFromCacheHook> hookClass = GetFromCacheHook.class;

    // Act and Assert
    assertThrows(
        GraphHookException.class,
        () ->
            graphConfig.validateAndUpdateGetFromCacheHook(
                store, operationClass, hookClass, "jane.doe@example.org"));
  }

  /**
   * Test {@link GraphConfig#validateAndUpdateGetFromCacheHook(Store, Class, Class, String)}.
   *
   * <ul>
   *   <li>When {@link TestStore} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link GraphConfig#validateAndUpdateGetFromCacheHook(Store, Class, Class,
   * String)}
   */
  @Test
  @DisplayName(
      "Test validateAndUpdateGetFromCacheHook(Store, Class, Class, String); when TestStore (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void GraphConfig.validateAndUpdateGetFromCacheHook(Store, Class, Class, String)"
  })
  void testValidateAndUpdateGetFromCacheHook_whenTestStore() {
    // Arrange
    GraphConfig graphConfig = new GraphConfig("42");
    TestStore store = new TestStore();
    Class<Operation> operationClass = Operation.class;
    Class<GetFromCacheHook> hookClass = GetFromCacheHook.class;

    // Act
    graphConfig.validateAndUpdateGetFromCacheHook(
        store, operationClass, hookClass, "jane.doe@example.org");

    // Assert that nothing has changed
    assertTrue(graphConfig.getHooks().isEmpty());
  }

  /**
   * Test {@link GraphConfig#initView(Schema)}.
   *
   * <p>Method under test: {@link GraphConfig#initView(Schema)}
   */
  @Test
  @DisplayName("Test initView(Schema)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void GraphConfig.initView(Schema)"})
  void testInitView() throws UnsupportedEncodingException, SchemaException {
    // Arrange
    View view = new View();
    view.addConfig("View already set ignoring initView call", "42");

    GraphConfig graphConfig = new GraphConfig("42");
    graphConfig.setView(view);

    // Act
    graphConfig.initView(new Schema());

    // Assert that nothing has changed
    View view2 = graphConfig.getView();
    Map<String, String> config = view2.getConfig();
    assertEquals(1, config.size());
    assertFalse(view2.hasEdges());
    assertFalse(view2.hasEntities());
    assertFalse(view2.hasGroups());
    assertFalse(view2.isAllEdges());
    assertFalse(view2.isAllEntities());
    assertTrue(config.containsKey("View already set ignoring initView call"));
    assertTrue(view2.getEdges().isEmpty());
    assertTrue(view2.getEntities().isEmpty());
    assertTrue(view2.getEdgeGroups().isEmpty());
    assertTrue(view2.getEntityGroups().isEmpty());
    assertTrue(view2.getGroups().isEmpty());
    byte[] expectedToCompactJsonResult =
        "{\"config\":{\"View already set ignoring initView call\":\"42\"}}".getBytes("UTF-8");
    assertArrayEquals(expectedToCompactJsonResult, view2.toCompactJson());
  }

  /**
   * Test {@link GraphConfig#initView(Schema)}.
   *
   * <ul>
   *   <li>Given {@link View} (default constructor) AllEdges is {@code true}.
   *   <li>When {@link Schema#Schema()}.
   *   <li>Then array length is seventy-five.
   * </ul>
   *
   * <p>Method under test: {@link GraphConfig#initView(Schema)}
   */
  @Test
  @DisplayName(
      "Test initView(Schema); given View (default constructor) AllEdges is 'true'; when Schema(); then array length is seventy-five")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void GraphConfig.initView(Schema)"})
  void testInitView_givenViewAllEdgesIsTrue_whenSchema_thenArrayLengthIsSeventyFive()
      throws SchemaException {
    // Arrange
    View view = new View();
    view.setAllEdges(true);
    view.addConfig("View already set ignoring initView call", "42");

    GraphConfig graphConfig = new GraphConfig("42");
    graphConfig.setView(view);

    // Act
    graphConfig.initView(new Schema());

    // Assert that nothing has changed
    View view2 = graphConfig.getView();
    Map<String, String> config = view2.getConfig();
    assertEquals(1, config.size());
    assertEquals(75, view2.toCompactJson().length);
    assertFalse(view2.hasEdges());
    assertFalse(view2.hasEntities());
    assertFalse(view2.hasGroups());
    assertFalse(view2.isAllEntities());
    assertTrue(config.containsKey("View already set ignoring initView call"));
    assertTrue(view2.getEdges().isEmpty());
    assertTrue(view2.getEntities().isEmpty());
    assertTrue(view2.getEdgeGroups().isEmpty());
    assertTrue(view2.getEntityGroups().isEmpty());
    assertTrue(view2.getGroups().isEmpty());
    assertTrue(view2.isAllEdges());
  }

  /**
   * Test {@link GraphConfig#initView(Schema)}.
   *
   * <ul>
   *   <li>Given {@link View} (default constructor) AllEntities is {@code true}.
   *   <li>When {@link Schema#Schema()}.
   *   <li>Then array length is seventy-eight.
   * </ul>
   *
   * <p>Method under test: {@link GraphConfig#initView(Schema)}
   */
  @Test
  @DisplayName(
      "Test initView(Schema); given View (default constructor) AllEntities is 'true'; when Schema(); then array length is seventy-eight")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void GraphConfig.initView(Schema)"})
  void testInitView_givenViewAllEntitiesIsTrue_whenSchema_thenArrayLengthIsSeventyEight()
      throws SchemaException {
    // Arrange
    View view = new View();
    view.setAllEntities(true);
    view.addConfig("View already set ignoring initView call", "42");

    GraphConfig graphConfig = new GraphConfig("42");
    graphConfig.setView(view);

    // Act
    graphConfig.initView(new Schema());

    // Assert that nothing has changed
    View view2 = graphConfig.getView();
    Map<String, String> config = view2.getConfig();
    assertEquals(1, config.size());
    assertEquals(78, view2.toCompactJson().length);
    assertFalse(view2.hasEdges());
    assertFalse(view2.hasEntities());
    assertFalse(view2.hasGroups());
    assertFalse(view2.isAllEdges());
    assertTrue(config.containsKey("View already set ignoring initView call"));
    assertTrue(view2.getEdges().isEmpty());
    assertTrue(view2.getEntities().isEmpty());
    assertTrue(view2.getEdgeGroups().isEmpty());
    assertTrue(view2.getEntityGroups().isEmpty());
    assertTrue(view2.getGroups().isEmpty());
    assertTrue(view2.isAllEntities());
  }

  /**
   * Test {@link GraphConfig#initView(Schema)}.
   *
   * <ul>
   *   <li>Then {@link GraphConfig#GraphConfig(String)} with graphId is {@code 42} View ClassName is
   *       {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link GraphConfig#initView(Schema)}
   */
  @Test
  @DisplayName(
      "Test initView(Schema); then GraphConfig(String) with graphId is '42' View ClassName is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void GraphConfig.initView(Schema)"})
  void testInitView_thenGraphConfigWithGraphIdIs42ViewClassNameIsNull() throws SchemaException {
    // Arrange
    GraphConfig graphConfig = new GraphConfig("42");

    // Act
    graphConfig.initView(new Schema());

    // Assert
    View view = graphConfig.getView();
    assertNull(view.getClassName());
    assertNull(view.getGlobalEdges());
    assertNull(view.getGlobalElements());
    assertNull(view.getGlobalEntities());
    assertFalse(view.hasEdges());
    assertFalse(view.hasEntities());
    assertFalse(view.hasGroups());
    assertFalse(view.isAllEdges());
    assertFalse(view.isAllEntities());
    assertTrue(view.getEdges().isEmpty());
    assertTrue(view.getEntities().isEmpty());
    assertTrue(view.getConfig().isEmpty());
    assertTrue(view.getEdgeGroups().isEmpty());
    assertTrue(view.getEntityGroups().isEmpty());
    assertTrue(view.getGroups().isEmpty());
    assertArrayEquals(new byte[] {'{', '}'}, view.toCompactJson());
  }

  /**
   * Test {@link GraphConfig#initView(Schema)}.
   *
   * <ul>
   *   <li>Then {@link GraphConfig#GraphConfig(String)} with graphId is {@code 42} View Config
   *       Empty.
   * </ul>
   *
   * <p>Method under test: {@link GraphConfig#initView(Schema)}
   */
  @Test
  @DisplayName(
      "Test initView(Schema); then GraphConfig(String) with graphId is '42' View Config Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void GraphConfig.initView(Schema)"})
  void testInitView_thenGraphConfigWithGraphIdIs42ViewConfigEmpty() throws SchemaException {
    // Arrange
    GraphConfig graphConfig = new GraphConfig("42");
    graphConfig.setView(new View());

    // Act
    graphConfig.initView(new Schema());

    // Assert that nothing has changed
    View view = graphConfig.getView();
    assertFalse(view.hasEdges());
    assertFalse(view.hasEntities());
    assertFalse(view.hasGroups());
    assertFalse(view.isAllEdges());
    assertFalse(view.isAllEntities());
    assertTrue(view.getEdges().isEmpty());
    assertTrue(view.getEntities().isEmpty());
    assertTrue(view.getConfig().isEmpty());
    assertTrue(view.getEdgeGroups().isEmpty());
    assertTrue(view.getEntityGroups().isEmpty());
    assertTrue(view.getGroups().isEmpty());
    assertArrayEquals(new byte[] {'{', '}'}, view.toCompactJson());
  }
}
