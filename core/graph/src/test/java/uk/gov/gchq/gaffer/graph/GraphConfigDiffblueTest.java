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

package uk.gov.gchq.gaffer.graph;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.data.elementdefinition.exception.SchemaException;
import uk.gov.gchq.gaffer.data.elementdefinition.view.NamedView;
import uk.gov.gchq.gaffer.data.elementdefinition.view.View;
import uk.gov.gchq.gaffer.graph.hook.AddOperationsToChain;
import uk.gov.gchq.gaffer.graph.hook.GraphHook;
import uk.gov.gchq.gaffer.graph.hook.GraphHookPath;
import uk.gov.gchq.gaffer.store.library.GraphLibrary;
import uk.gov.gchq.gaffer.store.schema.Schema;

class GraphConfigDiffblueTest {
  /**
   * Method under test: {@link GraphConfig.Builder#addHook(Path)}
   */
  @Test
  void testBuilderAddHook() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> (new GraphConfig.Builder()).addHook(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt")));
    assertThrows(IllegalArgumentException.class, () -> (new GraphConfig.Builder()).addHook((Path) null));
    assertThrows(IllegalArgumentException.class,
        () -> (new GraphConfig.Builder()).addHook(Paths.get(System.getProperty("java.io.tmpdir"), "")));
  }

  /**
   * Method under test: {@link GraphConfig.Builder#addHook(GraphHook)}
   */
  @Test
  void testBuilderAddHook2() {
    // Arrange
    GraphConfig.Builder builder = new GraphConfig.Builder();

    // Act and Assert
    assertSame(builder, builder.addHook(new AddOperationsToChain()));
  }

  /**
   * Method under test: {@link GraphConfig.Builder#addHook(GraphHook)}
   */
  @Test
  void testBuilderAddHook3() {
    // Arrange
    GraphConfig.Builder builder = new GraphConfig.Builder();

    // Act and Assert
    assertSame(builder, builder.addHook((GraphHook) null));
  }

  /**
   * Method under test: {@link GraphConfig.Builder#addHooks(Path)}
   */
  @Test
  void testBuilderAddHooks() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> (new GraphConfig.Builder()).addHooks(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt")));
    assertThrows(IllegalArgumentException.class, () -> (new GraphConfig.Builder()).addHooks((Path) null));
    assertThrows(IllegalArgumentException.class,
        () -> (new GraphConfig.Builder()).addHooks(Paths.get(System.getProperty("java.io.tmpdir"), "")));
  }

  /**
   * Method under test: {@link GraphConfig.Builder#addHooks(GraphHook[])}
   */
  @Test
  void testBuilderAddHooks2() {
    // Arrange
    GraphConfig.Builder builder = new GraphConfig.Builder();

    // Act and Assert
    assertSame(builder, builder.addHooks(new AddOperationsToChain()));
  }

  /**
   * Method under test: {@link GraphConfig.Builder#addHooks(GraphHook[])}
   */
  @Test
  void testBuilderAddHooks3() {
    // Arrange
    GraphConfig.Builder builder = new GraphConfig.Builder();

    // Act and Assert
    assertSame(builder, builder.addHooks((GraphHook[]) null));
  }

  /**
   * Method under test: {@link GraphConfig.Builder#description(String)}
   */
  @Test
  void testBuilderDescription() {
    // Arrange
    GraphConfig.Builder builder = new GraphConfig.Builder();

    // Act and Assert
    assertSame(builder, builder.description("The characteristics of someone or something"));
  }

  /**
   * Method under test: {@link GraphConfig.Builder#graphId(String)}
   */
  @Test
  void testBuilderGraphId() {
    // Arrange
    GraphConfig.Builder builder = new GraphConfig.Builder();

    // Act and Assert
    assertSame(builder, builder.graphId("42"));
  }

  /**
   * Method under test: {@link GraphConfig.Builder#json(InputStream)}
   */
  @Test
  void testBuilderJson() throws UnsupportedEncodingException {
    // Arrange
    GraphConfig.Builder builder = new GraphConfig.Builder();

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> builder.json(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))));
  }

  /**
   * Method under test: {@link GraphConfig.Builder#json(InputStream)}
   */
  @Test
  void testBuilderJson2() {
    // Arrange
    GraphConfig.Builder builder = new GraphConfig.Builder();

    // Act and Assert
    assertSame(builder, builder.json((InputStream) null));
  }

  /**
   * Method under test: {@link GraphConfig.Builder#json(InputStream)}
   */
  @Test
  void testBuilderJson3() {
    // Arrange
    GraphConfig.Builder builder = new GraphConfig.Builder();

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> builder.json(new ByteArrayInputStream(new byte[]{})));
  }

  /**
   * Method under test: {@link GraphConfig.Builder#json(Path)}
   */
  @Test
  void testBuilderJson4() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> (new GraphConfig.Builder()).json(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt")));
  }

  /**
   * Method under test: {@link GraphConfig.Builder#json(Path)}
   */
  @Test
  void testBuilderJson5() {
    // Arrange
    GraphConfig.Builder builder = new GraphConfig.Builder();

    // Act and Assert
    assertSame(builder, builder.json((Path) null));
  }

  /**
   * Method under test: {@link GraphConfig.Builder#json(byte[])}
   */
  @Test
  void testBuilderJson6() throws UnsupportedEncodingException {
    // Arrange
    GraphConfig.Builder builder = new GraphConfig.Builder();

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> builder.json("AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Method under test: {@link GraphConfig.Builder#json(byte[])}
   */
  @Test
  void testBuilderJson7() {
    // Arrange
    GraphConfig.Builder builder = new GraphConfig.Builder();

    // Act and Assert
    assertSame(builder, builder.json((byte[]) null));
  }

  /**
   * Method under test: {@link GraphConfig.Builder#json(byte[])}
   */
  @Test
  void testBuilderJson8() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> (new GraphConfig.Builder()).json(new byte[]{}));
  }

  /**
   * Method under test: {@link GraphConfig.Builder#library(GraphLibrary)}
   */
  @Test
  void testBuilderLibrary() {
    // Arrange
    GraphConfig.Builder builder = new GraphConfig.Builder();

    // Act and Assert
    assertSame(builder, builder.library(null));
  }

  /**
   * Method under test: {@link GraphConfig.Builder#merge(GraphConfig)}
   */
  @Test
  void testBuilderMerge() {
    // Arrange
    GraphConfig.Builder builder = new GraphConfig.Builder();

    // Act and Assert
    assertSame(builder, builder.merge(new GraphConfig("42")));
  }

  /**
   * Method under test: {@link GraphConfig.Builder#merge(GraphConfig)}
   */
  @Test
  void testBuilderMerge2() {
    // Arrange
    GraphConfig.Builder builder = new GraphConfig.Builder();

    // Act and Assert
    assertSame(builder, builder.merge(null));
  }

  /**
   * Method under test: {@link GraphConfig.Builder#merge(GraphConfig)}
   */
  @Test
  void testBuilderMerge3() {
    // Arrange
    GraphConfig.Builder builder = new GraphConfig.Builder();

    GraphConfig config = new GraphConfig("42");
    config.setGraphId(null);
    config.setLibrary(null);
    config.setDescription(null);
    config.setOtelActive(null);
    config.setView(null);

    // Act and Assert
    assertSame(builder, builder.merge(config));
  }

  /**
   * Method under test: {@link GraphConfig.Builder#merge(GraphConfig)}
   */
  @Test
  void testBuilderMerge4() {
    // Arrange
    GraphConfig.Builder builder = new GraphConfig.Builder();

    GraphConfig config = new GraphConfig("42");
    config.setGraphId(null);
    config.setLibrary(null);
    config.setDescription(null);
    config.setOtelActive(null);
    config.setView(new View());

    // Act and Assert
    assertSame(builder, builder.merge(config));
  }

  /**
   * Method under test: {@link GraphConfig.Builder#merge(GraphConfig)}
   */
  @Test
  void testBuilderMerge5() {
    // Arrange
    GraphConfig.Builder builder = new GraphConfig.Builder();

    GraphConfig config = new GraphConfig("42");
    config.setGraphId(null);
    config.setLibrary(null);
    config.setDescription(null);
    config.setOtelActive(true);
    config.setView(null);

    // Act and Assert
    assertSame(builder, builder.merge(config));
  }

  /**
   * Method under test: {@link GraphConfig.Builder#merge(GraphConfig)}
   */
  @Test
  void testBuilderMerge6() {
    // Arrange
    GraphConfig.Builder builder = new GraphConfig.Builder();

    GraphConfig config = new GraphConfig("42");
    config.setGraphId(null);
    config.setLibrary(null);
    config.setDescription("Config");
    config.setOtelActive(null);
    config.setView(null);

    // Act and Assert
    assertSame(builder, builder.merge(config));
  }

  /**
   * Method under test: {@link GraphConfig.Builder#merge(GraphConfig)}
   */
  @Test
  void testBuilderMerge7() {
    // Arrange
    GraphConfig.Builder builder = new GraphConfig.Builder();

    View view = new View();
    view.addConfig("Name must be set", "42");

    GraphConfig config = new GraphConfig("42");
    config.setGraphId(null);
    config.setLibrary(null);
    config.setDescription(null);
    config.setOtelActive(null);
    config.setView(view);

    // Act and Assert
    assertSame(builder, builder.merge(config));
  }

  /**
   * Method under test: {@link GraphConfig.Builder#merge(GraphConfig)}
   */
  @Test
  void testBuilderMerge8() {
    // Arrange
    GraphConfig.Builder builder = new GraphConfig.Builder();

    View view = new View();
    view.setAllEntities(true);

    GraphConfig config = new GraphConfig("42");
    config.setGraphId(null);
    config.setLibrary(null);
    config.setDescription(null);
    config.setOtelActive(null);
    config.setView(view);

    // Act and Assert
    assertSame(builder, builder.merge(config));
  }

  /**
   * Method under test: {@link GraphConfig.Builder#merge(GraphConfig)}
   */
  @Test
  void testBuilderMerge9() {
    // Arrange
    GraphConfig.Builder builder = new GraphConfig.Builder();

    View view = new View();
    view.setAllEdges(true);

    GraphConfig config = new GraphConfig("42");
    config.setGraphId(null);
    config.setLibrary(null);
    config.setDescription(null);
    config.setOtelActive(null);
    config.setView(view);

    // Act and Assert
    assertSame(builder, builder.merge(config));
  }

  /**
   * Method under test: {@link GraphConfig.Builder#otelActive(Boolean)}
   */
  @Test
  void testBuilderOtelActive() {
    // Arrange
    GraphConfig.Builder builder = new GraphConfig.Builder();

    // Act and Assert
    assertSame(builder, builder.otelActive(true));
  }

  /**
   * Method under test: {@link GraphConfig.Builder#view(InputStream)}
   */
  @Test
  void testBuilderView() {
    // Arrange
    GraphConfig.Builder builder = new GraphConfig.Builder();

    // Act and Assert
    assertSame(builder, builder.view((InputStream) null));
  }

  /**
   * Method under test: {@link GraphConfig.Builder#view(Path)}
   */
  @Test
  void testBuilderView2() {
    // Arrange
    GraphConfig.Builder builder = new GraphConfig.Builder();

    // Act and Assert
    assertSame(builder, builder.view((Path) null));
  }

  /**
   * Method under test: {@link GraphConfig.Builder#view(View)}
   */
  @Test
  void testBuilderView3() {
    // Arrange
    GraphConfig.Builder builder = new GraphConfig.Builder();

    // Act and Assert
    assertSame(builder, builder.view(new View()));
  }

  /**
   * Method under test: {@link GraphConfig.Builder#view(View)}
   */
  @Test
  void testBuilderView4() {
    // Arrange
    GraphConfig.Builder builder = new GraphConfig.Builder();

    // Act and Assert
    assertSame(builder, builder.view((View) null));
  }

  /**
   * Method under test: {@link GraphConfig.Builder#view(View)}
   */
  @Test
  void testBuilderView5() {
    // Arrange
    GraphConfig.Builder builder = new GraphConfig.Builder();

    // Act and Assert
    assertSame(builder, builder.view(new NamedView()));
  }

  /**
   * Method under test: {@link GraphConfig.Builder#view(View)}
   */
  @Test
  void testBuilderView6() {
    // Arrange
    GraphConfig.Builder builder = new GraphConfig.Builder();

    View view = new View();
    view.setAllEntities(true);

    // Act and Assert
    assertSame(builder, builder.view(view));
  }

  /**
   * Method under test: {@link GraphConfig.Builder#view(byte[])}
   */
  @Test
  void testBuilderView7() {
    // Arrange
    GraphConfig.Builder builder = new GraphConfig.Builder();

    // Act and Assert
    assertSame(builder, builder.view((byte[]) null));
  }

  /**
   * Method under test: {@link GraphConfig#getView()}
   */
  @Test
  void testGetView() {
    // Arrange, Act and Assert
    assertNull((new GraphConfig("42")).getView());
  }

  /**
   * Method under test: {@link GraphConfig#getView()}
   */
  @Test
  void testGetView2() {
    // Arrange
    GraphConfig graphConfig = new GraphConfig("42");
    View view = new View();
    graphConfig.setView(view);

    // Act and Assert
    assertEquals(view, graphConfig.getView());
  }

  /**
   * Method under test: {@link GraphConfig#getView()}
   */
  @Test
  void testGetView3() {
    // Arrange
    GraphConfig graphConfig = new GraphConfig("Graph Id");
    View view = new View();
    graphConfig.setView(view);

    // Act and Assert
    assertEquals(view, graphConfig.getView());
  }

  /**
   * Method under test: {@link GraphConfig#getView()}
   */
  @Test
  void testGetView4() {
    // Arrange
    View view = new View();
    view.addConfig("Key", "42");

    GraphConfig graphConfig = new GraphConfig("42");
    graphConfig.setView(view);

    // Act and Assert
    assertEquals(view, graphConfig.getView());
  }

  /**
   * Method under test: {@link GraphConfig#getView()}
   */
  @Test
  void testGetView5() {
    // Arrange
    View view = new View();
    view.setAllEntities(true);
    view.addConfig("Key", "42");

    GraphConfig graphConfig = new GraphConfig("42");
    graphConfig.setView(view);

    // Act and Assert
    assertEquals(view, graphConfig.getView());
  }

  /**
   * Method under test: {@link GraphConfig#getView()}
   */
  @Test
  void testGetView6() {
    // Arrange
    View view = new View();
    view.setAllEdges(true);
    view.addConfig("Key", "42");

    GraphConfig graphConfig = new GraphConfig("42");
    graphConfig.setView(view);

    // Act and Assert
    assertEquals(view, graphConfig.getView());
  }

  /**
   * Method under test: {@link GraphConfig#setView(View)}
   */
  @Test
  void testSetView() {
    // Arrange
    GraphConfig graphConfig = new GraphConfig("42");
    View view = new View();

    // Act
    graphConfig.setView(view);

    // Assert
    assertEquals(view, graphConfig.getView());
  }

  /**
   * Method under test: {@link GraphConfig#setView(View)}
   */
  @Test
  void testSetView2() {
    // Arrange
    GraphConfig graphConfig = new GraphConfig("42");

    // Act
    graphConfig.setView(null);

    // Assert
    assertNull(graphConfig.getView());
  }

  /**
   * Method under test: {@link GraphConfig#setView(View)}
   */
  @Test
  void testSetView3() {
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
   * Method under test: {@link GraphConfig#setHooks(List)}
   */
  @Test
  void testSetHooks() {
    // Arrange
    GraphConfig graphConfig = new GraphConfig("42");

    // Act
    graphConfig.setHooks(new ArrayList<>());

    // Assert
    assertTrue(graphConfig.getHooks().isEmpty());
  }

  /**
   * Method under test: {@link GraphConfig#setHooks(List)}
   */
  @Test
  void testSetHooks2() {
    // Arrange
    GraphConfig graphConfig = new GraphConfig("42");

    // Act
    graphConfig.setHooks(null);

    // Assert
    assertTrue(graphConfig.getHooks().isEmpty());
  }

  /**
   * Method under test: {@link GraphConfig#setHooks(List)}
   */
  @Test
  void testSetHooks3() {
    // Arrange
    GraphConfig graphConfig = new GraphConfig("42");

    ArrayList<GraphHook> hooks = new ArrayList<>();
    hooks.add(new AddOperationsToChain());

    // Act
    graphConfig.setHooks(hooks);

    // Assert
    assertEquals(hooks, graphConfig.getHooks());
  }

  /**
   * Method under test: {@link GraphConfig#setHooks(List)}
   */
  @Test
  void testSetHooks4() {
    // Arrange
    GraphConfig graphConfig = new GraphConfig("42");

    ArrayList<GraphHook> hooks = new ArrayList<>();
    hooks.add(new AddOperationsToChain());
    hooks.add(new AddOperationsToChain());

    // Act
    graphConfig.setHooks(hooks);

    // Assert
    assertEquals(hooks, graphConfig.getHooks());
  }

  /**
   * Method under test: {@link GraphConfig#setHooks(List)}
   */
  @Test
  void testSetHooks5() {
    // Arrange
    GraphConfig graphConfig = new GraphConfig("42");

    ArrayList<GraphHook> hooks = new ArrayList<>();
    hooks.add(null);

    // Act
    graphConfig.setHooks(hooks);

    // Assert
    assertTrue(graphConfig.getHooks().isEmpty());
  }

  /**
   * Method under test: {@link GraphConfig#setHooks(List)}
   */
  @Test
  void testSetHooks6() {
    // Arrange
    GraphConfig graphConfig = new GraphConfig("42");

    GraphHookPath graphHookPath = new GraphHookPath();
    graphHookPath.setPath("Path");

    ArrayList<GraphHook> hooks = new ArrayList<>();
    hooks.add(graphHookPath);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> graphConfig.setHooks(hooks));
  }

  /**
   * Method under test: {@link GraphConfig#addHook(GraphHook)}
   */
  @Test
  void testAddHook() {
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
   * Method under test: {@link GraphConfig#addHook(GraphHook)}
   */
  @Test
  void testAddHook2() {
    // Arrange
    GraphConfig graphConfig = new GraphConfig("42");

    // Act
    graphConfig.addHook(null);

    // Assert
    assertTrue(graphConfig.getHooks().isEmpty());
  }

  /**
   * Method under test: {@link GraphConfig#addHook(GraphHook)}
   */
  @Test
  void testAddHook3() {
    // Arrange
    GraphConfig graphConfig = new GraphConfig("42");

    GraphHookPath hook = new GraphHookPath();
    hook.setPath("Path");

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> graphConfig.addHook(hook));
  }

  /**
   * Method under test: {@link GraphConfig#hasHook(Class)}
   */
  @Test
  void testHasHook() {
    // Arrange
    GraphConfig graphConfig = new GraphConfig("42");
    Class<GraphHook> hookClass = GraphHook.class;

    // Act and Assert
    assertFalse(graphConfig.hasHook(hookClass));
  }

  /**
   * Method under test: {@link GraphConfig#hasHook(Class)}
   */
  @Test
  void testHasHook2() {
    // Arrange
    GraphConfig graphConfig = new GraphConfig("42");
    graphConfig.addHook(new AddOperationsToChain());
    Class<GraphHook> hookClass = GraphHook.class;

    // Act and Assert
    assertTrue(graphConfig.hasHook(hookClass));
  }

  /**
   * Method under test: {@link GraphConfig#initView(Schema)}
   */
  @Test
  void testInitView() throws SchemaException {
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
    assertArrayEquals(new byte[]{'{', '}'}, view.toCompactJson());
  }

  /**
   * Method under test: {@link GraphConfig#initView(Schema)}
   */
  @Test
  void testInitView2() {
    // Arrange
    GraphConfig graphConfig = new GraphConfig("42");
    View view = new View();
    graphConfig.setView(view);

    // Act
    graphConfig.initView(new Schema());

    // Assert
    assertEquals(view, graphConfig.getView());
  }

  /**
   * Method under test: {@link GraphConfig#initView(Schema)}
   */
  @Test
  void testInitView3() {
    // Arrange
    View view = new View();
    view.addConfig("View already set ignoring initView call", "42");

    GraphConfig graphConfig = new GraphConfig("42");
    graphConfig.setView(view);

    // Act
    graphConfig.initView(new Schema());

    // Assert
    assertEquals(view, graphConfig.getView());
  }

  /**
   * Method under test: {@link GraphConfig#initView(Schema)}
   */
  @Test
  void testInitView4() {
    // Arrange
    View view = new View();
    view.setAllEntities(true);
    view.addConfig("View already set ignoring initView call", "42");

    GraphConfig graphConfig = new GraphConfig("42");
    graphConfig.setView(view);

    // Act
    graphConfig.initView(new Schema());

    // Assert
    assertEquals(view, graphConfig.getView());
  }

  /**
   * Method under test: {@link GraphConfig#initView(Schema)}
   */
  @Test
  void testInitView5() {
    // Arrange
    View view = new View();
    view.setAllEdges(true);
    view.addConfig("View already set ignoring initView call", "42");

    GraphConfig graphConfig = new GraphConfig("42");
    graphConfig.setView(view);

    // Act
    graphConfig.initView(new Schema());

    // Assert
    assertEquals(view, graphConfig.getView());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link GraphConfig#GraphConfig()}
   *   <li>{@link GraphConfig#setDescription(String)}
   *   <li>{@link GraphConfig#setGraphId(String)}
   *   <li>{@link GraphConfig#setLibrary(GraphLibrary)}
   *   <li>{@link GraphConfig#setOtelActive(Boolean)}
   *   <li>{@link GraphConfig#getDescription()}
   *   <li>{@link GraphConfig#getGraphId()}
   *   <li>{@link GraphConfig#getHooks()}
   *   <li>{@link GraphConfig#getLibrary()}
   *   <li>{@link GraphConfig#getOtelActive()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    GraphConfig actualGraphConfig = new GraphConfig();
    actualGraphConfig.setDescription("The characteristics of someone or something");
    actualGraphConfig.setGraphId("42");
    actualGraphConfig.setLibrary(null);
    actualGraphConfig.setOtelActive(true);
    String actualDescription = actualGraphConfig.getDescription();
    String actualGraphId = actualGraphConfig.getGraphId();
    List<GraphHook> actualHooks = actualGraphConfig.getHooks();
    actualGraphConfig.getLibrary();
    Boolean actualOtelActive = actualGraphConfig.getOtelActive();

    // Assert that nothing has changed
    assertEquals("42", actualGraphId);
    assertEquals("The characteristics of someone or something", actualDescription);
    assertTrue(actualHooks.isEmpty());
    assertTrue(actualOtelActive);
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link GraphConfig#GraphConfig(String)}
   *   <li>{@link GraphConfig#setDescription(String)}
   *   <li>{@link GraphConfig#setGraphId(String)}
   *   <li>{@link GraphConfig#setLibrary(GraphLibrary)}
   *   <li>{@link GraphConfig#setOtelActive(Boolean)}
   *   <li>{@link GraphConfig#getDescription()}
   *   <li>{@link GraphConfig#getGraphId()}
   *   <li>{@link GraphConfig#getHooks()}
   *   <li>{@link GraphConfig#getLibrary()}
   *   <li>{@link GraphConfig#getOtelActive()}
   * </ul>
   */
  @Test
  void testGettersAndSetters2() {
    // Arrange and Act
    GraphConfig actualGraphConfig = new GraphConfig("42");
    actualGraphConfig.setDescription("The characteristics of someone or something");
    actualGraphConfig.setGraphId("42");
    actualGraphConfig.setLibrary(null);
    actualGraphConfig.setOtelActive(true);
    String actualDescription = actualGraphConfig.getDescription();
    String actualGraphId = actualGraphConfig.getGraphId();
    List<GraphHook> actualHooks = actualGraphConfig.getHooks();
    actualGraphConfig.getLibrary();
    Boolean actualOtelActive = actualGraphConfig.getOtelActive();

    // Assert that nothing has changed
    assertEquals("42", actualGraphId);
    assertEquals("The characteristics of someone or something", actualDescription);
    assertTrue(actualHooks.isEmpty());
    assertTrue(actualOtelActive);
  }
}
