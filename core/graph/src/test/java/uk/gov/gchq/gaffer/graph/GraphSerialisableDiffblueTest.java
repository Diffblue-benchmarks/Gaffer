package uk.gov.gchq.gaffer.graph;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import uk.gov.gchq.gaffer.core.exception.GafferRuntimeException;
import uk.gov.gchq.gaffer.data.elementdefinition.exception.SchemaException;
import uk.gov.gchq.gaffer.data.elementdefinition.view.NamedView;
import uk.gov.gchq.gaffer.data.elementdefinition.view.View;
import uk.gov.gchq.gaffer.graph.hook.GraphHook;
import uk.gov.gchq.gaffer.graph.hook.UpdateViewHook;
import uk.gov.gchq.gaffer.graph.hook.UpdateViewHook.Builder;
import uk.gov.gchq.gaffer.store.StoreProperties;
import uk.gov.gchq.gaffer.store.library.FileGraphLibrary;
import uk.gov.gchq.gaffer.store.library.GraphLibrary;
import uk.gov.gchq.gaffer.store.library.NoGraphLibrary;
import uk.gov.gchq.gaffer.store.schema.Schema;

class GraphSerialisableDiffblueTest {
  /**
   * Test Builder {@link GraphSerialisable.Builder#config(GraphConfig)}.
   *
   * <p>Method under test: {@link GraphSerialisable.Builder#config(GraphConfig)}
   */
  @Test
  @DisplayName("Test Builder config(GraphConfig)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"GraphSerialisable.Builder GraphSerialisable.Builder.config(GraphConfig)"})
  void testBuilderConfig() throws UnsupportedEncodingException {
    // Arrange
    GraphSerialisable.Builder builder = new GraphSerialisable.Builder();

    // Act
    GraphSerialisable.Builder actualConfigResult = builder.config(new GraphConfig("42"));

    // Assert
    GraphSerialisable graphSerialisable = builder.build();
    GraphConfig config = graphSerialisable.getConfig();
    assertTrue(config.getLibrary() instanceof NoGraphLibrary);
    assertEquals("42", config.getGraphId());
    assertEquals("42", graphSerialisable.getGraphId());
    assertNull(graphSerialisable.getSerialisedProperties());
    assertNull(graphSerialisable.getSerialisedSchema());
    assertNull(config.getOtelActive());
    assertNull(config.getDescription());
    assertNull(config.getView());
    assertNull(graphSerialisable.getStoreProperties());
    assertNull(graphSerialisable.getSchema());
    assertTrue(config.getHooks().isEmpty());
    assertSame(builder, actualConfigResult);
    assertArrayEquals(
        "{\n  \"graphId\" : \"42\",\n  \"hooks\" : [ ]\n}".getBytes("UTF-8"),
        graphSerialisable.getSerialisedConfig());
  }

  /**
   * Test Builder {@link GraphSerialisable.Builder#mergeConfig(GraphConfig)}.
   *
   * <ul>
   *   <li>Given {@link FileGraphLibrary#FileGraphLibrary()}.
   * </ul>
   *
   * <p>Method under test: {@link GraphSerialisable.Builder#mergeConfig(GraphConfig)}
   */
  @Test
  @DisplayName("Test Builder mergeConfig(GraphConfig); given FileGraphLibrary()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "GraphSerialisable.Builder GraphSerialisable.Builder.mergeConfig(GraphConfig)"
  })
  void testBuilderMergeConfig_givenFileGraphLibrary() {
    // Arrange
    GraphConfig config =
        new GraphConfig.Builder()
            .description("The characteristics of someone or something")
            .build();
    Schema schema = new Schema();

    GraphSerialisable graphSerialisable = new GraphSerialisable(config, schema, new Properties());

    GraphSerialisable.Builder builder = new GraphSerialisable.Builder(graphSerialisable);
    builder.config(null);

    GraphConfig config2 = new GraphConfig(null);
    config2.setLibrary(new FileGraphLibrary());
    config2.setDescription(null);
    config2.setOtelActive(null);
    config2.setView(null);

    // Act
    GraphSerialisable.Builder actualMergeConfigResult = builder.mergeConfig(config2);

    // Assert
    assertSame(builder, actualMergeConfigResult);
  }

  /**
   * Test Builder {@link GraphSerialisable.Builder#mergeConfig(GraphConfig)}.
   *
   * <ul>
   *   <li>Given {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link GraphSerialisable.Builder#mergeConfig(GraphConfig)}
   */
  @Test
  @DisplayName("Test Builder mergeConfig(GraphConfig); given 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "GraphSerialisable.Builder GraphSerialisable.Builder.mergeConfig(GraphConfig)"
  })
  void testBuilderMergeConfig_givenTrue() {
    // Arrange
    GraphConfig config =
        new GraphConfig.Builder()
            .description("The characteristics of someone or something")
            .build();
    Schema schema = new Schema();

    GraphSerialisable graphSerialisable = new GraphSerialisable(config, schema, new Properties());

    GraphSerialisable.Builder builder = new GraphSerialisable.Builder(graphSerialisable);
    builder.config(null);

    GraphConfig config2 = new GraphConfig(null);
    config2.setLibrary(null);
    config2.setDescription(null);
    config2.setOtelActive(true);
    config2.setView(null);

    // Act
    GraphSerialisable.Builder actualMergeConfigResult = builder.mergeConfig(config2);

    // Assert
    assertSame(builder, actualMergeConfigResult);
  }

  /**
   * Test Builder {@link GraphSerialisable.Builder#mergeConfig(GraphConfig)}.
   *
   * <ul>
   *   <li>Given {@link View} (default constructor).
   *   <li>When {@link GraphConfig#GraphConfig(String)} with graphId is {@code null} View is {@link
   *       View} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link GraphSerialisable.Builder#mergeConfig(GraphConfig)}
   */
  @Test
  @DisplayName(
      "Test Builder mergeConfig(GraphConfig); given View (default constructor); when GraphConfig(String) with graphId is 'null' View is View (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "GraphSerialisable.Builder GraphSerialisable.Builder.mergeConfig(GraphConfig)"
  })
  void testBuilderMergeConfig_givenView_whenGraphConfigWithGraphIdIsNullViewIsView() {
    // Arrange
    GraphConfig config =
        new GraphConfig.Builder()
            .description("The characteristics of someone or something")
            .build();
    Schema schema = new Schema();

    GraphSerialisable graphSerialisable = new GraphSerialisable(config, schema, new Properties());

    GraphSerialisable.Builder builder = new GraphSerialisable.Builder(graphSerialisable);
    builder.config(null);

    GraphConfig config2 = new GraphConfig(null);
    config2.setLibrary(null);
    config2.setDescription(null);
    config2.setOtelActive(null);
    config2.setView(new View());

    // Act
    GraphSerialisable.Builder actualMergeConfigResult = builder.mergeConfig(config2);

    // Assert
    assertSame(builder, actualMergeConfigResult);
  }

  /**
   * Test Builder {@link GraphSerialisable.Builder#mergeConfig(GraphConfig)}.
   *
   * <ul>
   *   <li>Then {@link GraphSerialisable.Builder#Builder()} build GraphId is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link GraphSerialisable.Builder#mergeConfig(GraphConfig)}
   */
  @Test
  @DisplayName("Test Builder mergeConfig(GraphConfig); then Builder() build GraphId is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "GraphSerialisable.Builder GraphSerialisable.Builder.mergeConfig(GraphConfig)"
  })
  void testBuilderMergeConfig_thenBuilderBuildGraphIdIs42() {
    // Arrange
    GraphSerialisable.Builder builder = new GraphSerialisable.Builder();

    // Act
    builder.mergeConfig(new GraphConfig("42"));

    // Assert
    GraphSerialisable graphSerialisable = builder.build();
    assertEquals("42", graphSerialisable.getGraphId());
    assertNull(graphSerialisable.getSerialisedProperties());
    assertNull(graphSerialisable.getSerialisedSchema());
    assertNull(graphSerialisable.getStoreProperties());
    assertNull(graphSerialisable.getSchema());
    assertEquals(124, graphSerialisable.getSerialisedConfig().length);
  }

  /**
   * Test Builder {@link GraphSerialisable.Builder#mergeConfig(GraphConfig)}.
   *
   * <ul>
   *   <li>Then return {@link GraphSerialisable.Builder#Builder()}.
   * </ul>
   *
   * <p>Method under test: {@link GraphSerialisable.Builder#mergeConfig(GraphConfig)}
   */
  @Test
  @DisplayName("Test Builder mergeConfig(GraphConfig); then return Builder()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "GraphSerialisable.Builder GraphSerialisable.Builder.mergeConfig(GraphConfig)"
  })
  void testBuilderMergeConfig_thenReturnBuilder() {
    // Arrange
    GraphSerialisable.Builder builder = new GraphSerialisable.Builder();

    // Act
    GraphSerialisable.Builder actualMergeConfigResult =
        builder.mergeConfig(
            new GraphConfig.Builder()
                .description("The characteristics of someone or something")
                .build());

    // Assert
    assertSame(builder, actualMergeConfigResult);
  }

  /**
   * Test Builder {@link GraphSerialisable.Builder#Builder()}.
   *
   * <p>Method under test: {@link GraphSerialisable.Builder#Builder()}
   */
  @Test
  @DisplayName("Test Builder new Builder()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void GraphSerialisable.Builder.<init>()",
    "GraphSerialisable GraphSerialisable.Builder.build()"
  })
  void testBuilderNewBuilder() {
    // Arrange and Act
    GraphSerialisable.Builder actualBuilder = new GraphSerialisable.Builder();
    GraphSerialisable.Builder actualConfigResult =
        actualBuilder.config(
            new GraphConfig.Builder()
                .description("The characteristics of someone or something")
                .build());
    GraphSerialisable.Builder actualMergeConfigResult =
        actualConfigResult.mergeConfig(
            new GraphConfig.Builder()
                .description("The characteristics of someone or something")
                .build());
    GraphSerialisable.Builder actualPropertiesResult =
        actualMergeConfigResult.properties(new Properties());
    GraphSerialisable.Builder actualPropertiesResult2 =
        actualPropertiesResult.properties(new StoreProperties());
    GraphSerialisable.Builder actualSchemaResult = actualPropertiesResult2.schema(new Schema());

    // Assert
    assertSame(actualPropertiesResult2, actualSchemaResult);
  }

  /**
   * Test Builder {@link GraphSerialisable.Builder#Builder(GraphSerialisable)}.
   *
   * <p>Method under test: {@link GraphSerialisable.Builder#Builder(GraphSerialisable)}
   */
  @Test
  @DisplayName("Test Builder new Builder(GraphSerialisable)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void GraphSerialisable.Builder.<init>(GraphSerialisable)"})
  void testBuilderNewBuilder2() {
    // Arrange
    GraphConfig.Builder builder = new GraphConfig.Builder();
    builder.graphId("42");

    Builder builder2 = new Builder();

    Builder blackListElementGroupsResult = builder2.blackListElementGroups(new HashSet<>());

    Builder setViewToMergeResult = blackListElementGroupsResult.setViewToMerge(new View());

    Builder whiteListElementGroupsResult =
        setViewToMergeResult.whiteListElementGroups(new HashSet<>());

    Builder withDataAuthResult = whiteListElementGroupsResult.withDataAuth(new HashSet<>());

    Builder withOpAuthResult = withDataAuthResult.withOpAuth(new HashSet<>());

    Builder withoutDataAuthResult = withOpAuthResult.withoutDataAuth(new HashSet<>());
    builder.addHook(withoutDataAuthResult.withoutOpAuth(new HashSet<>()).build());
    GraphConfig config = builder.description("The characteristics of someone or something").build();
    Schema schema = new Schema();

    GraphSerialisable graphSerialisable = new GraphSerialisable(config, schema, new Properties());

    // Act and Assert
    GraphSerialisable actualGraphSerialisable =
        new GraphSerialisable.Builder(graphSerialisable).build();
    assertEquals(graphSerialisable, actualGraphSerialisable);
  }

  /**
   * Test Builder {@link GraphSerialisable.Builder#properties(InputStream)} with {@code
   * InputStream}.
   *
   * <p>Method under test: {@link GraphSerialisable.Builder#properties(InputStream)}
   */
  @Test
  @DisplayName("Test Builder properties(InputStream) with 'InputStream'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"GraphSerialisable.Builder GraphSerialisable.Builder.properties(InputStream)"})
  void testBuilderPropertiesWithInputStream() throws IOException {
    // Arrange
    GraphSerialisable.Builder builder = new GraphSerialisable.Builder();
    ByteArrayInputStream properties = new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"));

    // Act
    GraphSerialisable.Builder actualPropertiesResult = builder.properties(properties);

    // Assert
    int actualReadResult = properties.read(new byte[] {});
    assertEquals(-1, actualReadResult);
    assertSame(builder, actualPropertiesResult);
  }

  /**
   * Test Builder {@link GraphSerialisable.Builder#properties(InputStream)} with {@code
   * InputStream}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link GraphSerialisable.Builder#properties(InputStream)}
   */
  @Test
  @DisplayName("Test Builder properties(InputStream) with 'InputStream'; when 'null'; then 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"GraphSerialisable.Builder GraphSerialisable.Builder.properties(InputStream)"})
  void testBuilderPropertiesWithInputStream_whenNull_thenNull() {
    // Arrange
    GraphSerialisable.Builder builder = new GraphSerialisable.Builder();

    // Act
    GraphSerialisable.Builder actualPropertiesResult = builder.properties((InputStream) null);

    // Assert
    assertNull(null);
    assertSame(builder, actualPropertiesResult);
  }

  /**
   * Test Builder {@link GraphSerialisable.Builder#properties(Properties)} with {@code Properties}.
   *
   * <p>Method under test: {@link GraphSerialisable.Builder#properties(Properties)}
   */
  @Test
  @DisplayName("Test Builder properties(Properties) with 'Properties'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"GraphSerialisable.Builder GraphSerialisable.Builder.properties(Properties)"})
  void testBuilderPropertiesWithProperties() {
    // Arrange
    GraphSerialisable.Builder builder = new GraphSerialisable.Builder();

    // Act
    GraphSerialisable.Builder actualPropertiesResult = builder.properties(new Properties());

    // Assert
    assertSame(builder, actualPropertiesResult);
  }

  /**
   * Test Builder {@link GraphSerialisable.Builder#properties(StoreProperties)} with {@code
   * StoreProperties}.
   *
   * <ul>
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link GraphSerialisable.Builder#properties(StoreProperties)}
   */
  @Test
  @DisplayName("Test Builder properties(StoreProperties) with 'StoreProperties'; when 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "GraphSerialisable.Builder GraphSerialisable.Builder.properties(StoreProperties)"
  })
  void testBuilderPropertiesWithStoreProperties_whenNull() {
    // Arrange
    GraphSerialisable.Builder builder = new GraphSerialisable.Builder();

    // Act
    GraphSerialisable.Builder actualPropertiesResult = builder.properties((StoreProperties) null);

    // Assert
    assertSame(builder, actualPropertiesResult);
  }

  /**
   * Test Builder {@link GraphSerialisable.Builder#properties(StoreProperties)} with {@code
   * StoreProperties}.
   *
   * <ul>
   *   <li>When {@link StoreProperties#StoreProperties()}.
   * </ul>
   *
   * <p>Method under test: {@link GraphSerialisable.Builder#properties(StoreProperties)}
   */
  @Test
  @DisplayName(
      "Test Builder properties(StoreProperties) with 'StoreProperties'; when StoreProperties()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "GraphSerialisable.Builder GraphSerialisable.Builder.properties(StoreProperties)"
  })
  void testBuilderPropertiesWithStoreProperties_whenStoreProperties() {
    // Arrange
    GraphSerialisable.Builder builder = new GraphSerialisable.Builder();

    // Act
    GraphSerialisable.Builder actualPropertiesResult = builder.properties(new StoreProperties());

    // Assert
    assertSame(builder, actualPropertiesResult);
  }

  /**
   * Test Builder {@link GraphSerialisable.Builder#schema(Schema)} with {@code Schema}.
   *
   * <p>Method under test: {@link GraphSerialisable.Builder#schema(Schema)}
   */
  @Test
  @DisplayName("Test Builder schema(Schema) with 'Schema'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"GraphSerialisable.Builder GraphSerialisable.Builder.schema(Schema)"})
  void testBuilderSchemaWithSchema() {
    // Arrange
    GraphSerialisable.Builder builder = new GraphSerialisable.Builder();

    // Act
    GraphSerialisable.Builder actualSchemaResult = builder.schema(new Schema());

    // Assert
    assertSame(builder, actualSchemaResult);
  }

  /**
   * Test {@link GraphSerialisable#GraphSerialisable(GraphConfig, Schema, StoreProperties)}.
   *
   * <p>Method under test: {@link GraphSerialisable#GraphSerialisable(GraphConfig, Schema,
   * StoreProperties)}
   */
  @Test
  @DisplayName("Test new GraphSerialisable(GraphConfig, Schema, StoreProperties)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void GraphSerialisable.<init>(GraphConfig, Schema, StoreProperties)"})
  void testNewGraphSerialisable() {
    // Arrange
    GraphConfig config = new GraphConfig("42");

    Builder builder = new Builder();

    Builder blackListElementGroupsResult = builder.blackListElementGroups(new HashSet<>());

    Builder setViewToMergeResult = blackListElementGroupsResult.setViewToMerge(new NamedView());

    Builder whiteListElementGroupsResult =
        setViewToMergeResult.whiteListElementGroups(new HashSet<>());

    Builder withDataAuthResult = whiteListElementGroupsResult.withDataAuth(new HashSet<>());

    Builder withOpAuthResult = withDataAuthResult.withOpAuth(new HashSet<>());

    Builder withoutDataAuthResult = withOpAuthResult.withoutDataAuth(new HashSet<>());
    config.addHook(withoutDataAuthResult.withoutOpAuth(new HashSet<>()).build());
    Schema schema = new Schema();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> new GraphSerialisable(config, schema, new StoreProperties()));
  }

  /**
   * Test {@link GraphSerialisable#GraphSerialisable(GraphConfig, Schema, StoreProperties)}.
   *
   * <ul>
   *   <li>Given {@link NamedView} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link GraphSerialisable#GraphSerialisable(GraphConfig, Schema,
   * StoreProperties)}
   */
  @Test
  @DisplayName(
      "Test new GraphSerialisable(GraphConfig, Schema, StoreProperties); given NamedView (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void GraphSerialisable.<init>(GraphConfig, Schema, StoreProperties)"})
  void testNewGraphSerialisable_givenNamedView() {
    // Arrange
    GraphConfig config = new GraphConfig("42");
    config.setView(new NamedView());

    Builder builder = new Builder();

    Builder blackListElementGroupsResult = builder.blackListElementGroups(new HashSet<>());

    Builder setViewToMergeResult = blackListElementGroupsResult.setViewToMerge(new View());

    Builder whiteListElementGroupsResult =
        setViewToMergeResult.whiteListElementGroups(new HashSet<>());

    Builder withDataAuthResult = whiteListElementGroupsResult.withDataAuth(new HashSet<>());

    Builder withOpAuthResult = withDataAuthResult.withOpAuth(new HashSet<>());

    Builder withoutDataAuthResult = withOpAuthResult.withoutDataAuth(new HashSet<>());
    config.addHook(withoutDataAuthResult.withoutOpAuth(new HashSet<>()).build());
    Schema schema = new Schema();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> new GraphSerialisable(config, schema, new StoreProperties()));
  }

  /**
   * Test {@link GraphSerialisable#GraphSerialisable(GraphConfig, Schema, Properties)}.
   *
   * <ul>
   *   <li>Given {@link NamedView} (default constructor) addConfig {@code filterFieldsByName} and
   *       {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link GraphSerialisable#GraphSerialisable(GraphConfig, Schema,
   * Properties)}
   */
  @Test
  @DisplayName(
      "Test new GraphSerialisable(GraphConfig, Schema, Properties); given NamedView (default constructor) addConfig 'filterFieldsByName' and '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void GraphSerialisable.<init>(GraphConfig, Schema, Properties)"})
  void testNewGraphSerialisable_givenNamedViewAddConfigFilterFieldsByNameAnd42() {
    // Arrange
    NamedView view = new NamedView();
    view.addConfig("filterFieldsByName", "42");

    GraphConfig config = new GraphConfig("42");
    config.setView(view);

    Builder builder = new Builder();

    Builder blackListElementGroupsResult = builder.blackListElementGroups(new HashSet<>());

    Builder setViewToMergeResult = blackListElementGroupsResult.setViewToMerge(new View());

    Builder whiteListElementGroupsResult =
        setViewToMergeResult.whiteListElementGroups(new HashSet<>());

    Builder withDataAuthResult = whiteListElementGroupsResult.withDataAuth(new HashSet<>());

    Builder withOpAuthResult = withDataAuthResult.withOpAuth(new HashSet<>());

    Builder withoutDataAuthResult = withOpAuthResult.withoutDataAuth(new HashSet<>());
    config.addHook(withoutDataAuthResult.withoutOpAuth(new HashSet<>()).build());
    Schema schema = new Schema();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> new GraphSerialisable(config, schema, new Properties()));
  }

  /**
   * Test {@link GraphSerialisable#GraphSerialisable(GraphConfig, Schema, Properties)}.
   *
   * <ul>
   *   <li>Given {@link NamedView} (default constructor).
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link GraphSerialisable#GraphSerialisable(GraphConfig, Schema,
   * Properties)}
   */
  @Test
  @DisplayName(
      "Test new GraphSerialisable(GraphConfig, Schema, Properties); given NamedView (default constructor); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void GraphSerialisable.<init>(GraphConfig, Schema, Properties)"})
  void testNewGraphSerialisable_givenNamedView_thenThrowIllegalArgumentException() {
    // Arrange
    GraphConfig config = new GraphConfig("42");
    config.setView(new NamedView());

    Builder builder = new Builder();

    Builder blackListElementGroupsResult = builder.blackListElementGroups(new HashSet<>());

    Builder setViewToMergeResult = blackListElementGroupsResult.setViewToMerge(new View());

    Builder whiteListElementGroupsResult =
        setViewToMergeResult.whiteListElementGroups(new HashSet<>());

    Builder withDataAuthResult = whiteListElementGroupsResult.withDataAuth(new HashSet<>());

    Builder withOpAuthResult = withDataAuthResult.withOpAuth(new HashSet<>());

    Builder withoutDataAuthResult = withOpAuthResult.withoutDataAuth(new HashSet<>());
    config.addHook(withoutDataAuthResult.withoutOpAuth(new HashSet<>()).build());
    Schema schema = new Schema();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> new GraphSerialisable(config, schema, new Properties()));
  }

  /**
   * Test {@link GraphSerialisable#GraphSerialisable(GraphConfig, Schema, Properties)}.
   *
   * <ul>
   *   <li>Given {@link View} (default constructor).
   *   <li>Then return array length is three hundred fifty-five.
   * </ul>
   *
   * <p>Method under test: {@link GraphSerialisable#GraphSerialisable(GraphConfig, Schema,
   * Properties)}
   */
  @Test
  @DisplayName(
      "Test new GraphSerialisable(GraphConfig, Schema, Properties); given View (default constructor); then return array length is three hundred fifty-five")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void GraphSerialisable.<init>(GraphConfig, Schema, Properties)"})
  void testNewGraphSerialisable_givenView_thenReturnArrayLengthIsThreeHundredFiftyFive()
      throws UnsupportedEncodingException {
    // Arrange
    GraphConfig config = new GraphConfig("42");
    config.setView(new View());

    Builder builder = new Builder();

    Builder blackListElementGroupsResult = builder.blackListElementGroups(new HashSet<>());

    Builder setViewToMergeResult = blackListElementGroupsResult.setViewToMerge(new View());

    Builder whiteListElementGroupsResult =
        setViewToMergeResult.whiteListElementGroups(new HashSet<>());

    Builder withDataAuthResult = whiteListElementGroupsResult.withDataAuth(new HashSet<>());

    Builder withOpAuthResult = withDataAuthResult.withOpAuth(new HashSet<>());

    Builder withoutDataAuthResult = withOpAuthResult.withoutDataAuth(new HashSet<>());
    config.addHook(withoutDataAuthResult.withoutOpAuth(new HashSet<>()).build());
    Schema schema = new Schema();

    // Act
    GraphSerialisable actualGraphSerialisable =
        new GraphSerialisable(config, schema, new Properties());

    // Assert
    assertEquals(355, actualGraphSerialisable.getSerialisedConfig().length);
    assertArrayEquals("{ }".getBytes("UTF-8"), actualGraphSerialisable.getSerialisedProperties());
    assertArrayEquals(
        "{\n  \"types\" : { }\n}".getBytes("UTF-8"), actualGraphSerialisable.getSerialisedSchema());
  }

  /**
   * Test {@link GraphSerialisable#GraphSerialisable(GraphConfig, Schema, StoreProperties)}.
   *
   * <ul>
   *   <li>Given {@link View} (default constructor).
   *   <li>Then return array length is three hundred fifty-five.
   * </ul>
   *
   * <p>Method under test: {@link GraphSerialisable#GraphSerialisable(GraphConfig, Schema,
   * StoreProperties)}
   */
  @Test
  @DisplayName(
      "Test new GraphSerialisable(GraphConfig, Schema, StoreProperties); given View (default constructor); then return array length is three hundred fifty-five")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void GraphSerialisable.<init>(GraphConfig, Schema, StoreProperties)"})
  void testNewGraphSerialisable_givenView_thenReturnArrayLengthIsThreeHundredFiftyFive2()
      throws UnsupportedEncodingException {
    // Arrange
    GraphConfig config = new GraphConfig("42");
    config.setView(new View());

    Builder builder = new Builder();

    Builder blackListElementGroupsResult = builder.blackListElementGroups(new HashSet<>());

    Builder setViewToMergeResult = blackListElementGroupsResult.setViewToMerge(new View());

    Builder whiteListElementGroupsResult =
        setViewToMergeResult.whiteListElementGroups(new HashSet<>());

    Builder withDataAuthResult = whiteListElementGroupsResult.withDataAuth(new HashSet<>());

    Builder withOpAuthResult = withDataAuthResult.withOpAuth(new HashSet<>());

    Builder withoutDataAuthResult = withOpAuthResult.withoutDataAuth(new HashSet<>());
    config.addHook(withoutDataAuthResult.withoutOpAuth(new HashSet<>()).build());
    Schema schema = new Schema();

    // Act
    GraphSerialisable actualGraphSerialisable =
        new GraphSerialisable(config, schema, new StoreProperties());

    // Assert
    assertEquals(355, actualGraphSerialisable.getSerialisedConfig().length);
    assertArrayEquals(
        "{\n  \"types\" : { }\n}".getBytes("UTF-8"), actualGraphSerialisable.getSerialisedSchema());
  }

  /**
   * Test {@link GraphSerialisable#GraphSerialisable(GraphConfig, Schema, Properties)}.
   *
   * <ul>
   *   <li>Then return array length is four hundred fourteen.
   * </ul>
   *
   * <p>Method under test: {@link GraphSerialisable#GraphSerialisable(GraphConfig, Schema,
   * Properties)}
   */
  @Test
  @DisplayName(
      "Test new GraphSerialisable(GraphConfig, Schema, Properties); then return array length is four hundred fourteen")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void GraphSerialisable.<init>(GraphConfig, Schema, Properties)"})
  void testNewGraphSerialisable_thenReturnArrayLengthIsFourHundredFourteen()
      throws UnsupportedEncodingException {
    // Arrange
    View view = new View();
    view.addConfig("filterFieldsByName", "42");

    GraphConfig config = new GraphConfig("42");
    config.setView(view);

    Builder builder = new Builder();

    Builder blackListElementGroupsResult = builder.blackListElementGroups(new HashSet<>());

    Builder setViewToMergeResult = blackListElementGroupsResult.setViewToMerge(new View());

    Builder whiteListElementGroupsResult =
        setViewToMergeResult.whiteListElementGroups(new HashSet<>());

    Builder withDataAuthResult = whiteListElementGroupsResult.withDataAuth(new HashSet<>());

    Builder withOpAuthResult = withDataAuthResult.withOpAuth(new HashSet<>());

    Builder withoutDataAuthResult = withOpAuthResult.withoutDataAuth(new HashSet<>());
    config.addHook(withoutDataAuthResult.withoutOpAuth(new HashSet<>()).build());
    Schema schema = new Schema();

    // Act
    GraphSerialisable actualGraphSerialisable =
        new GraphSerialisable(config, schema, new Properties());

    // Assert
    assertEquals(414, actualGraphSerialisable.getSerialisedConfig().length);
    assertArrayEquals("{ }".getBytes("UTF-8"), actualGraphSerialisable.getSerialisedProperties());
    assertArrayEquals(
        "{\n  \"types\" : { }\n}".getBytes("UTF-8"), actualGraphSerialisable.getSerialisedSchema());
  }

  /**
   * Test {@link GraphSerialisable#GraphSerialisable(GraphConfig, Schema, StoreProperties)}.
   *
   * <ul>
   *   <li>Then return array length is four hundred fourteen.
   * </ul>
   *
   * <p>Method under test: {@link GraphSerialisable#GraphSerialisable(GraphConfig, Schema,
   * StoreProperties)}
   */
  @Test
  @DisplayName(
      "Test new GraphSerialisable(GraphConfig, Schema, StoreProperties); then return array length is four hundred fourteen")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void GraphSerialisable.<init>(GraphConfig, Schema, StoreProperties)"})
  void testNewGraphSerialisable_thenReturnArrayLengthIsFourHundredFourteen2()
      throws UnsupportedEncodingException {
    // Arrange
    View view = new View();
    view.addConfig("filterFieldsByName", "42");

    GraphConfig config = new GraphConfig("42");
    config.setView(view);

    Builder builder = new Builder();

    Builder blackListElementGroupsResult = builder.blackListElementGroups(new HashSet<>());

    Builder setViewToMergeResult = blackListElementGroupsResult.setViewToMerge(new View());

    Builder whiteListElementGroupsResult =
        setViewToMergeResult.whiteListElementGroups(new HashSet<>());

    Builder withDataAuthResult = whiteListElementGroupsResult.withDataAuth(new HashSet<>());

    Builder withOpAuthResult = withDataAuthResult.withOpAuth(new HashSet<>());

    Builder withoutDataAuthResult = withOpAuthResult.withoutDataAuth(new HashSet<>());
    config.addHook(withoutDataAuthResult.withoutOpAuth(new HashSet<>()).build());
    Schema schema = new Schema();

    // Act
    GraphSerialisable actualGraphSerialisable =
        new GraphSerialisable(config, schema, new StoreProperties());

    // Assert
    assertEquals(414, actualGraphSerialisable.getSerialisedConfig().length);
    assertArrayEquals(
        "{\n  \"types\" : { }\n}".getBytes("UTF-8"), actualGraphSerialisable.getSerialisedSchema());
  }

  /**
   * Test {@link GraphSerialisable#GraphSerialisable(GraphConfig, Schema, Properties)}.
   *
   * <ul>
   *   <li>Then return array length is four hundred sixty-nine.
   * </ul>
   *
   * <p>Method under test: {@link GraphSerialisable#GraphSerialisable(GraphConfig, Schema,
   * Properties)}
   */
  @Test
  @DisplayName(
      "Test new GraphSerialisable(GraphConfig, Schema, Properties); then return array length is four hundred sixty-nine")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void GraphSerialisable.<init>(GraphConfig, Schema, Properties)"})
  void testNewGraphSerialisable_thenReturnArrayLengthIsFourHundredSixtyNine()
      throws UnsupportedEncodingException {
    // Arrange
    GraphConfig config =
        new GraphConfig.Builder()
            .description("The characteristics of someone or something")
            .build();

    Builder builder = new Builder();

    Builder blackListElementGroupsResult = builder.blackListElementGroups(new HashSet<>());

    Builder setViewToMergeResult = blackListElementGroupsResult.setViewToMerge(new View());

    Builder whiteListElementGroupsResult =
        setViewToMergeResult.whiteListElementGroups(new HashSet<>());

    Builder withDataAuthResult = whiteListElementGroupsResult.withDataAuth(new HashSet<>());

    Builder withOpAuthResult = withDataAuthResult.withOpAuth(new HashSet<>());

    Builder withoutDataAuthResult = withOpAuthResult.withoutDataAuth(new HashSet<>());
    config.addHook(withoutDataAuthResult.withoutOpAuth(new HashSet<>()).build());
    Schema schema = new Schema();

    // Act
    GraphSerialisable actualGraphSerialisable =
        new GraphSerialisable(config, schema, new Properties());

    // Assert
    assertEquals(469, actualGraphSerialisable.getSerialisedConfig().length);
    assertArrayEquals("{ }".getBytes("UTF-8"), actualGraphSerialisable.getSerialisedProperties());
    assertArrayEquals(
        "{\n  \"types\" : { }\n}".getBytes("UTF-8"), actualGraphSerialisable.getSerialisedSchema());
  }

  /**
   * Test {@link GraphSerialisable#GraphSerialisable(GraphConfig, Schema, Properties)}.
   *
   * <ul>
   *   <li>Then return array length is one hundred sixty-nine.
   * </ul>
   *
   * <p>Method under test: {@link GraphSerialisable#GraphSerialisable(GraphConfig, Schema,
   * Properties)}
   */
  @Test
  @DisplayName(
      "Test new GraphSerialisable(GraphConfig, Schema, Properties); then return array length is one hundred sixty-nine")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void GraphSerialisable.<init>(GraphConfig, Schema, Properties)"})
  void testNewGraphSerialisable_thenReturnArrayLengthIsOneHundredSixtyNine()
      throws UnsupportedEncodingException {
    // Arrange
    GraphConfig config =
        new GraphConfig.Builder()
            .description("The characteristics of someone or something")
            .build();
    Schema schema = new Schema();

    // Act
    GraphSerialisable actualGraphSerialisable =
        new GraphSerialisable(config, schema, new Properties());

    // Assert
    assertEquals(169, actualGraphSerialisable.getSerialisedConfig().length);
    assertArrayEquals("{ }".getBytes("UTF-8"), actualGraphSerialisable.getSerialisedProperties());
    assertArrayEquals(
        "{\n  \"types\" : { }\n}".getBytes("UTF-8"), actualGraphSerialisable.getSerialisedSchema());
  }

  /**
   * Test {@link GraphSerialisable#GraphSerialisable(GraphConfig, Schema, StoreProperties)}.
   *
   * <ul>
   *   <li>Then return array length is one hundred sixty-nine.
   * </ul>
   *
   * <p>Method under test: {@link GraphSerialisable#GraphSerialisable(GraphConfig, Schema,
   * StoreProperties)}
   */
  @Test
  @DisplayName(
      "Test new GraphSerialisable(GraphConfig, Schema, StoreProperties); then return array length is one hundred sixty-nine")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void GraphSerialisable.<init>(GraphConfig, Schema, StoreProperties)"})
  void testNewGraphSerialisable_thenReturnArrayLengthIsOneHundredSixtyNine2()
      throws UnsupportedEncodingException {
    // Arrange
    GraphConfig config =
        new GraphConfig.Builder()
            .description("The characteristics of someone or something")
            .build();
    Schema schema = new Schema();

    // Act
    GraphSerialisable actualGraphSerialisable =
        new GraphSerialisable(config, schema, new StoreProperties());

    // Assert
    assertEquals(169, actualGraphSerialisable.getSerialisedConfig().length);
    assertArrayEquals(
        "{\n  \"types\" : { }\n}".getBytes("UTF-8"), actualGraphSerialisable.getSerialisedSchema());
  }

  /**
   * Test {@link GraphSerialisable#GraphSerialisable(GraphConfig, Schema, Properties)}.
   *
   * <ul>
   *   <li>Then return array length is six hundred forty.
   * </ul>
   *
   * <p>Method under test: {@link GraphSerialisable#GraphSerialisable(GraphConfig, Schema,
   * Properties)}
   */
  @Test
  @DisplayName(
      "Test new GraphSerialisable(GraphConfig, Schema, Properties); then return array length is six hundred forty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void GraphSerialisable.<init>(GraphConfig, Schema, Properties)"})
  void testNewGraphSerialisable_thenReturnArrayLengthIsSixHundredForty()
      throws UnsupportedEncodingException {
    // Arrange
    GraphConfig config = new GraphConfig("42");

    Builder builder = new Builder();

    Builder blackListElementGroupsResult = builder.blackListElementGroups(new HashSet<>());

    Builder setViewToMergeResult = blackListElementGroupsResult.setViewToMerge(new View());

    Builder whiteListElementGroupsResult =
        setViewToMergeResult.whiteListElementGroups(new HashSet<>());

    Builder withDataAuthResult = whiteListElementGroupsResult.withDataAuth(new HashSet<>());

    Builder withOpAuthResult = withDataAuthResult.withOpAuth(new HashSet<>());

    Builder withoutDataAuthResult = withOpAuthResult.withoutDataAuth(new HashSet<>());
    config.addHook(withoutDataAuthResult.withoutOpAuth(new HashSet<>()).build());

    Builder builder2 = new Builder();

    Builder blackListElementGroupsResult2 = builder2.blackListElementGroups(new HashSet<>());

    Builder setViewToMergeResult2 = blackListElementGroupsResult2.setViewToMerge(new View());

    Builder whiteListElementGroupsResult2 =
        setViewToMergeResult2.whiteListElementGroups(new HashSet<>());

    Builder withDataAuthResult2 = whiteListElementGroupsResult2.withDataAuth(new HashSet<>());

    Builder withOpAuthResult2 = withDataAuthResult2.withOpAuth(new HashSet<>());

    Builder withoutDataAuthResult2 = withOpAuthResult2.withoutDataAuth(new HashSet<>());
    config.addHook(withoutDataAuthResult2.withoutOpAuth(new HashSet<>()).build());
    Schema schema = new Schema();

    // Act
    GraphSerialisable actualGraphSerialisable =
        new GraphSerialisable(config, schema, new Properties());

    // Assert
    assertEquals(640, actualGraphSerialisable.getSerialisedConfig().length);
    assertArrayEquals("{ }".getBytes("UTF-8"), actualGraphSerialisable.getSerialisedProperties());
    assertArrayEquals(
        "{\n  \"types\" : { }\n}".getBytes("UTF-8"), actualGraphSerialisable.getSerialisedSchema());
  }

  /**
   * Test {@link GraphSerialisable#GraphSerialisable(GraphConfig, Schema, StoreProperties)}.
   *
   * <ul>
   *   <li>Then return array length is six hundred forty.
   * </ul>
   *
   * <p>Method under test: {@link GraphSerialisable#GraphSerialisable(GraphConfig, Schema,
   * StoreProperties)}
   */
  @Test
  @DisplayName(
      "Test new GraphSerialisable(GraphConfig, Schema, StoreProperties); then return array length is six hundred forty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void GraphSerialisable.<init>(GraphConfig, Schema, StoreProperties)"})
  void testNewGraphSerialisable_thenReturnArrayLengthIsSixHundredForty2()
      throws UnsupportedEncodingException {
    // Arrange
    GraphConfig config = new GraphConfig("42");

    Builder builder = new Builder();

    Builder blackListElementGroupsResult = builder.blackListElementGroups(new HashSet<>());

    Builder setViewToMergeResult = blackListElementGroupsResult.setViewToMerge(new View());

    Builder whiteListElementGroupsResult =
        setViewToMergeResult.whiteListElementGroups(new HashSet<>());

    Builder withDataAuthResult = whiteListElementGroupsResult.withDataAuth(new HashSet<>());

    Builder withOpAuthResult = withDataAuthResult.withOpAuth(new HashSet<>());

    Builder withoutDataAuthResult = withOpAuthResult.withoutDataAuth(new HashSet<>());
    config.addHook(withoutDataAuthResult.withoutOpAuth(new HashSet<>()).build());

    Builder builder2 = new Builder();

    Builder blackListElementGroupsResult2 = builder2.blackListElementGroups(new HashSet<>());

    Builder setViewToMergeResult2 = blackListElementGroupsResult2.setViewToMerge(new View());

    Builder whiteListElementGroupsResult2 =
        setViewToMergeResult2.whiteListElementGroups(new HashSet<>());

    Builder withDataAuthResult2 = whiteListElementGroupsResult2.withDataAuth(new HashSet<>());

    Builder withOpAuthResult2 = withDataAuthResult2.withOpAuth(new HashSet<>());

    Builder withoutDataAuthResult2 = withOpAuthResult2.withoutDataAuth(new HashSet<>());
    config.addHook(withoutDataAuthResult2.withoutOpAuth(new HashSet<>()).build());
    Schema schema = new Schema();

    // Act
    GraphSerialisable actualGraphSerialisable =
        new GraphSerialisable(config, schema, new StoreProperties());

    // Assert
    assertEquals(640, actualGraphSerialisable.getSerialisedConfig().length);
    assertArrayEquals(
        "{\n  \"types\" : { }\n}".getBytes("UTF-8"), actualGraphSerialisable.getSerialisedSchema());
  }

  /**
   * Test {@link GraphSerialisable#GraphSerialisable(GraphConfig, Schema, Properties)}.
   *
   * <ul>
   *   <li>Then return array length is three hundred thirty-nine.
   * </ul>
   *
   * <p>Method under test: {@link GraphSerialisable#GraphSerialisable(GraphConfig, Schema,
   * Properties)}
   */
  @Test
  @DisplayName(
      "Test new GraphSerialisable(GraphConfig, Schema, Properties); then return array length is three hundred thirty-nine")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void GraphSerialisable.<init>(GraphConfig, Schema, Properties)"})
  void testNewGraphSerialisable_thenReturnArrayLengthIsThreeHundredThirtyNine()
      throws UnsupportedEncodingException {
    // Arrange
    GraphConfig config = new GraphConfig("42");

    Builder builder = new Builder();

    Builder blackListElementGroupsResult = builder.blackListElementGroups(new HashSet<>());

    Builder setViewToMergeResult = blackListElementGroupsResult.setViewToMerge(new View());

    Builder whiteListElementGroupsResult =
        setViewToMergeResult.whiteListElementGroups(new HashSet<>());

    Builder withDataAuthResult = whiteListElementGroupsResult.withDataAuth(new HashSet<>());

    Builder withOpAuthResult = withDataAuthResult.withOpAuth(new HashSet<>());

    Builder withoutDataAuthResult = withOpAuthResult.withoutDataAuth(new HashSet<>());
    config.addHook(withoutDataAuthResult.withoutOpAuth(new HashSet<>()).build());
    Schema schema = new Schema();

    // Act
    GraphSerialisable actualGraphSerialisable =
        new GraphSerialisable(config, schema, new Properties());

    // Assert
    assertEquals(339, actualGraphSerialisable.getSerialisedConfig().length);
    assertArrayEquals("{ }".getBytes("UTF-8"), actualGraphSerialisable.getSerialisedProperties());
    assertArrayEquals(
        "{\n  \"types\" : { }\n}".getBytes("UTF-8"), actualGraphSerialisable.getSerialisedSchema());
  }

  /**
   * Test {@link GraphSerialisable#GraphSerialisable(GraphConfig, Schema, StoreProperties)}.
   *
   * <ul>
   *   <li>Then return array length is three hundred thirty-nine.
   * </ul>
   *
   * <p>Method under test: {@link GraphSerialisable#GraphSerialisable(GraphConfig, Schema,
   * StoreProperties)}
   */
  @Test
  @DisplayName(
      "Test new GraphSerialisable(GraphConfig, Schema, StoreProperties); then return array length is three hundred thirty-nine")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void GraphSerialisable.<init>(GraphConfig, Schema, StoreProperties)"})
  void testNewGraphSerialisable_thenReturnArrayLengthIsThreeHundredThirtyNine2()
      throws UnsupportedEncodingException {
    // Arrange
    GraphConfig config = new GraphConfig("42");

    Builder builder = new Builder();

    Builder blackListElementGroupsResult = builder.blackListElementGroups(new HashSet<>());

    Builder setViewToMergeResult = blackListElementGroupsResult.setViewToMerge(new View());

    Builder whiteListElementGroupsResult =
        setViewToMergeResult.whiteListElementGroups(new HashSet<>());

    Builder withDataAuthResult = whiteListElementGroupsResult.withDataAuth(new HashSet<>());

    Builder withOpAuthResult = withDataAuthResult.withOpAuth(new HashSet<>());

    Builder withoutDataAuthResult = withOpAuthResult.withoutDataAuth(new HashSet<>());
    config.addHook(withoutDataAuthResult.withoutOpAuth(new HashSet<>()).build());
    Schema schema = new Schema();

    // Act
    GraphSerialisable actualGraphSerialisable =
        new GraphSerialisable(config, schema, new StoreProperties());

    // Assert
    assertEquals(339, actualGraphSerialisable.getSerialisedConfig().length);
    assertArrayEquals(
        "{\n  \"types\" : { }\n}".getBytes("UTF-8"), actualGraphSerialisable.getSerialisedSchema());
  }

  /**
   * Test {@link GraphSerialisable#GraphSerialisable(GraphConfig, Schema, StoreProperties)}.
   *
   * <ul>
   *   <li>Then return Config Hooks Empty.
   * </ul>
   *
   * <p>Method under test: {@link GraphSerialisable#GraphSerialisable(GraphConfig, Schema,
   * StoreProperties)}
   */
  @Test
  @DisplayName(
      "Test new GraphSerialisable(GraphConfig, Schema, StoreProperties); then return Config Hooks Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void GraphSerialisable.<init>(GraphConfig, Schema, StoreProperties)"})
  void testNewGraphSerialisable_thenReturnConfigHooksEmpty()
      throws UnsupportedEncodingException, SchemaException {
    // Arrange
    GraphConfig config = new GraphConfig("42");
    Schema schema = new Schema();

    // Act
    GraphSerialisable actualGraphSerialisable =
        new GraphSerialisable(config, schema, new StoreProperties());

    // Assert
    assertTrue(actualGraphSerialisable.getConfig().getHooks().isEmpty());
    byte[] expectedToCompactJsonResult = "{\"types\":{}}".getBytes("UTF-8");
    assertArrayEquals(
        expectedToCompactJsonResult, actualGraphSerialisable.getSchema().toCompactJson());
    assertArrayEquals(
        "{\n  \"graphId\" : \"42\",\n  \"hooks\" : [ ]\n}".getBytes("UTF-8"),
        actualGraphSerialisable.getSerialisedConfig());
    assertArrayEquals(
        "{\n  \"types\" : { }\n}".getBytes("UTF-8"), actualGraphSerialisable.getSerialisedSchema());
  }

  /**
   * Test {@link GraphSerialisable#GraphSerialisable(GraphConfig, Schema, Properties)}.
   *
   * <ul>
   *   <li>Then return Schema toCompactJson is {@code {"types":{}}} Bytes is {@code UTF-8}.
   * </ul>
   *
   * <p>Method under test: {@link GraphSerialisable#GraphSerialisable(GraphConfig, Schema,
   * Properties)}
   */
  @Test
  @DisplayName(
      "Test new GraphSerialisable(GraphConfig, Schema, Properties); then return Schema toCompactJson is '{\"types\":{}}' Bytes is 'UTF-8'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void GraphSerialisable.<init>(GraphConfig, Schema, Properties)"})
  void testNewGraphSerialisable_thenReturnSchemaToCompactJsonIsTypesBytesIsUtf8()
      throws UnsupportedEncodingException, SchemaException {
    // Arrange
    GraphConfig config = new GraphConfig("42");
    Schema schema = new Schema();

    // Act
    GraphSerialisable actualGraphSerialisable =
        new GraphSerialisable(config, schema, new Properties());

    // Assert
    assertArrayEquals("{ }".getBytes("UTF-8"), actualGraphSerialisable.getSerialisedProperties());
    byte[] expectedToCompactJsonResult = "{\"types\":{}}".getBytes("UTF-8");
    assertArrayEquals(
        expectedToCompactJsonResult, actualGraphSerialisable.getSchema().toCompactJson());
    assertArrayEquals(
        "{\n  \"graphId\" : \"42\",\n  \"hooks\" : [ ]\n}".getBytes("UTF-8"),
        actualGraphSerialisable.getSerialisedConfig());
    assertArrayEquals(
        "{\n  \"types\" : { }\n}".getBytes("UTF-8"), actualGraphSerialisable.getSerialisedSchema());
  }

  /**
   * Test {@link GraphSerialisable#GraphSerialisable(GraphConfig, Schema, Properties)}.
   *
   * <ul>
   *   <li>Then return SerialisedSchema is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link GraphSerialisable#GraphSerialisable(GraphConfig, Schema,
   * Properties)}
   */
  @Test
  @DisplayName(
      "Test new GraphSerialisable(GraphConfig, Schema, Properties); then return SerialisedSchema is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void GraphSerialisable.<init>(GraphConfig, Schema, Properties)"})
  void testNewGraphSerialisable_thenReturnSerialisedSchemaIsNull()
      throws UnsupportedEncodingException {
    // Arrange
    GraphConfig config = new GraphConfig("42");

    // Act
    GraphSerialisable actualGraphSerialisable =
        new GraphSerialisable(config, null, new Properties());

    // Assert
    assertNull(actualGraphSerialisable.getSerialisedSchema());
    assertNull(actualGraphSerialisable.getSchema());
    assertArrayEquals("{ }".getBytes("UTF-8"), actualGraphSerialisable.getSerialisedProperties());
    assertArrayEquals(
        "{\n  \"graphId\" : \"42\",\n  \"hooks\" : [ ]\n}".getBytes("UTF-8"),
        actualGraphSerialisable.getSerialisedConfig());
  }

  /**
   * Test {@link GraphSerialisable#GraphSerialisable(GraphConfig, Schema, StoreProperties)}.
   *
   * <ul>
   *   <li>Then return SerialisedSchema is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link GraphSerialisable#GraphSerialisable(GraphConfig, Schema,
   * StoreProperties)}
   */
  @Test
  @DisplayName(
      "Test new GraphSerialisable(GraphConfig, Schema, StoreProperties); then return SerialisedSchema is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void GraphSerialisable.<init>(GraphConfig, Schema, StoreProperties)"})
  void testNewGraphSerialisable_thenReturnSerialisedSchemaIsNull2()
      throws UnsupportedEncodingException {
    // Arrange
    GraphConfig config = new GraphConfig("42");

    // Act
    GraphSerialisable actualGraphSerialisable =
        new GraphSerialisable(config, null, new StoreProperties());

    // Assert
    assertNull(actualGraphSerialisable.getSerialisedSchema());
    assertNull(actualGraphSerialisable.getSchema());
    assertTrue(actualGraphSerialisable.getConfig().getHooks().isEmpty());
    assertArrayEquals(
        "{\n  \"graphId\" : \"42\",\n  \"hooks\" : [ ]\n}".getBytes("UTF-8"),
        actualGraphSerialisable.getSerialisedConfig());
  }

  /**
   * Test {@link GraphSerialisable#GraphSerialisable(GraphConfig, Schema, Properties)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return SerialisedConfig is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link GraphSerialisable#GraphSerialisable(GraphConfig, Schema,
   * Properties)}
   */
  @Test
  @DisplayName(
      "Test new GraphSerialisable(GraphConfig, Schema, Properties); when 'null'; then return SerialisedConfig is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void GraphSerialisable.<init>(GraphConfig, Schema, Properties)"})
  void testNewGraphSerialisable_whenNull_thenReturnSerialisedConfigIsNull()
      throws UnsupportedEncodingException, SchemaException {
    // Arrange
    Schema schema = new Schema();

    // Act
    GraphSerialisable actualGraphSerialisable =
        new GraphSerialisable(null, schema, new Properties());

    // Assert
    assertNull(actualGraphSerialisable.getSerialisedConfig());
    assertNull(actualGraphSerialisable.getConfig());
    assertArrayEquals("{ }".getBytes("UTF-8"), actualGraphSerialisable.getSerialisedProperties());
    byte[] expectedToCompactJsonResult = "{\"types\":{}}".getBytes("UTF-8");
    assertArrayEquals(
        expectedToCompactJsonResult, actualGraphSerialisable.getSchema().toCompactJson());
    assertArrayEquals(
        "{\n  \"types\" : { }\n}".getBytes("UTF-8"), actualGraphSerialisable.getSerialisedSchema());
  }

  /**
   * Test {@link GraphSerialisable#GraphSerialisable(GraphConfig, Schema, StoreProperties)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return SerialisedConfig is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link GraphSerialisable#GraphSerialisable(GraphConfig, Schema,
   * StoreProperties)}
   */
  @Test
  @DisplayName(
      "Test new GraphSerialisable(GraphConfig, Schema, StoreProperties); when 'null'; then return SerialisedConfig is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void GraphSerialisable.<init>(GraphConfig, Schema, StoreProperties)"})
  void testNewGraphSerialisable_whenNull_thenReturnSerialisedConfigIsNull2()
      throws UnsupportedEncodingException, SchemaException {
    // Arrange
    Schema schema = new Schema();

    // Act
    GraphSerialisable actualGraphSerialisable =
        new GraphSerialisable(null, schema, new StoreProperties());

    // Assert
    assertNull(actualGraphSerialisable.getSerialisedConfig());
    assertNull(actualGraphSerialisable.getConfig());
    byte[] expectedToCompactJsonResult = "{\"types\":{}}".getBytes("UTF-8");
    assertArrayEquals(
        expectedToCompactJsonResult, actualGraphSerialisable.getSchema().toCompactJson());
    assertArrayEquals(
        "{\n  \"types\" : { }\n}".getBytes("UTF-8"), actualGraphSerialisable.getSerialisedSchema());
  }

  /**
   * Test {@link GraphSerialisable#getGraph()}.
   *
   * <ul>
   *   <li>Given {@link Properties#Properties()} {@code 42} is {@link DataInputStream}.
   *   <li>Then throw {@link GafferRuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link GraphSerialisable#getGraph()}
   */
  @Test
  @DisplayName(
      "Test getGraph(); given Properties() '42' is DataInputStream; then throw GafferRuntimeException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"uk.gov.gchq.gaffer.graph.Graph GraphSerialisable.getGraph()"})
  void testGetGraph_givenProperties42IsDataInputStream_thenThrowGafferRuntimeException() {
    // Arrange
    GraphConfig.Builder builder = new GraphConfig.Builder();

    Builder builder2 = new Builder();

    Builder blackListElementGroupsResult = builder2.blackListElementGroups(new HashSet<>());

    Builder setViewToMergeResult = blackListElementGroupsResult.setViewToMerge(new View());

    Builder whiteListElementGroupsResult =
        setViewToMergeResult.whiteListElementGroups(new HashSet<>());

    Builder withDataAuthResult = whiteListElementGroupsResult.withDataAuth(new HashSet<>());

    Builder withOpAuthResult = withDataAuthResult.withOpAuth(new HashSet<>());

    Builder withoutDataAuthResult = withOpAuthResult.withoutDataAuth(new HashSet<>());
    builder.addHook(withoutDataAuthResult.withoutOpAuth(new HashSet<>()).build());

    Builder builder3 = new Builder();

    Builder blackListElementGroupsResult2 = builder3.blackListElementGroups(new HashSet<>());

    Builder setViewToMergeResult2 = blackListElementGroupsResult2.setViewToMerge(new View());

    Builder whiteListElementGroupsResult2 =
        setViewToMergeResult2.whiteListElementGroups(new HashSet<>());

    Builder withDataAuthResult2 = whiteListElementGroupsResult2.withDataAuth(new HashSet<>());

    Builder withOpAuthResult2 = withDataAuthResult2.withOpAuth(new HashSet<>());

    Builder withoutDataAuthResult2 = withOpAuthResult2.withoutDataAuth(new HashSet<>());
    builder.addHook(withoutDataAuthResult2.withoutOpAuth(new HashSet<>()).build());
    GraphConfig config = builder.description("The characteristics of someone or something").build();

    Properties properties = new Properties();
    properties.put("42", mock(DataInputStream.class));

    GraphSerialisable graphSerialisable = new GraphSerialisable(config, new Schema(), properties);

    // Act and Assert
    assertThrows(GafferRuntimeException.class, () -> graphSerialisable.getGraph());
  }

  /**
   * Test {@link GraphSerialisable#getSchema(GraphLibrary)} with {@code GraphLibrary}.
   *
   * <ul>
   *   <li>Then return {@link Schema#Schema()}.
   * </ul>
   *
   * <p>Method under test: {@link GraphSerialisable#getSchema(GraphLibrary)}
   */
  @Test
  @DisplayName("Test getSchema(GraphLibrary) with 'GraphLibrary'; then return Schema()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Schema GraphSerialisable.getSchema(GraphLibrary)"})
  void testGetSchemaWithGraphLibrary_thenReturnSchema() {
    // Arrange
    GraphConfig config =
        new GraphConfig.Builder()
            .description("The characteristics of someone or something")
            .build();
    Schema schema = new Schema();

    GraphSerialisable graphSerialisable = new GraphSerialisable(config, schema, new Properties());

    // Act and Assert
    assertEquals(schema, graphSerialisable.getSchema(new FileGraphLibrary()));
  }

  /**
   * Test {@link GraphSerialisable#getSchema(GraphLibrary)} with {@code GraphLibrary}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link GraphSerialisable#getSchema(GraphLibrary)}
   */
  @Test
  @DisplayName("Test getSchema(GraphLibrary) with 'GraphLibrary'; when 'null'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Schema GraphSerialisable.getSchema(GraphLibrary)"})
  void testGetSchemaWithGraphLibrary_whenNull_thenReturnNull() {
    // Arrange
    GraphConfig config =
        new GraphConfig.Builder()
            .description("The characteristics of someone or something")
            .build();
    GraphSerialisable graphSerialisable = new GraphSerialisable(config, null, new Properties());

    // Act and Assert
    assertNull(graphSerialisable.getSchema(null));
  }

  /**
   * Test {@link GraphSerialisable#getSchema()}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link GraphSerialisable#getSchema()}
   */
  @Test
  @DisplayName("Test getSchema(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Schema GraphSerialisable.getSchema()"})
  void testGetSchema_thenReturnNull() {
    // Arrange
    GraphConfig config =
        new GraphConfig.Builder()
            .description("The characteristics of someone or something")
            .build();
    GraphSerialisable graphSerialisable = new GraphSerialisable(config, null, new Properties());

    // Act and Assert
    assertNull(graphSerialisable.getSchema());
  }

  /**
   * Test {@link GraphSerialisable#getSchema()}.
   *
   * <ul>
   *   <li>Then return {@link Schema#Schema()}.
   * </ul>
   *
   * <p>Method under test: {@link GraphSerialisable#getSchema()}
   */
  @Test
  @DisplayName("Test getSchema(); then return Schema()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Schema GraphSerialisable.getSchema()"})
  void testGetSchema_thenReturnSchema() {
    // Arrange
    GraphConfig config =
        new GraphConfig.Builder()
            .description("The characteristics of someone or something")
            .build();
    Schema schema = new Schema();

    GraphSerialisable graphSerialisable = new GraphSerialisable(config, schema, new Properties());

    // Act and Assert
    assertEquals(schema, graphSerialisable.getSchema());
  }

  /**
   * Test {@link GraphSerialisable#getGraphId()}.
   *
   * <ul>
   *   <li>Given {@link GraphConfig.Builder} (default constructor) graphId {@code 42}.
   *   <li>Then return {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link GraphSerialisable#getGraphId()}
   */
  @Test
  @DisplayName(
      "Test getGraphId(); given Builder (default constructor) graphId '42'; then return '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String GraphSerialisable.getGraphId()"})
  void testGetGraphId_givenBuilderGraphId42_thenReturn42() {
    // Arrange
    GraphConfig.Builder builder = new GraphConfig.Builder();
    builder.graphId("42");

    Builder builder2 = new Builder();

    Builder blackListElementGroupsResult = builder2.blackListElementGroups(new HashSet<>());

    Builder setViewToMergeResult = blackListElementGroupsResult.setViewToMerge(new View());

    Builder whiteListElementGroupsResult =
        setViewToMergeResult.whiteListElementGroups(new HashSet<>());

    Builder withDataAuthResult = whiteListElementGroupsResult.withDataAuth(new HashSet<>());

    Builder withOpAuthResult = withDataAuthResult.withOpAuth(new HashSet<>());

    Builder withoutDataAuthResult = withOpAuthResult.withoutDataAuth(new HashSet<>());
    builder.addHook(withoutDataAuthResult.withoutOpAuth(new HashSet<>()).build());
    GraphConfig config = builder.description("The characteristics of someone or something").build();
    Schema schema = new Schema();

    GraphSerialisable graphSerialisable = new GraphSerialisable(config, schema, new Properties());

    // Act and Assert
    assertEquals("42", graphSerialisable.getGraphId());
  }

  /**
   * Test {@link GraphSerialisable#getGraphId()}.
   *
   * <ul>
   *   <li>Given {@link GraphConfig.Builder} (default constructor) library {@link
   *       FileGraphLibrary#FileGraphLibrary()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link GraphSerialisable#getGraphId()}
   */
  @Test
  @DisplayName(
      "Test getGraphId(); given Builder (default constructor) library FileGraphLibrary(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String GraphSerialisable.getGraphId()"})
  void testGetGraphId_givenBuilderLibraryFileGraphLibrary_thenReturnNull() {
    // Arrange
    GraphConfig.Builder builder = new GraphConfig.Builder();
    builder.library(new FileGraphLibrary());

    Builder builder2 = new Builder();

    Builder blackListElementGroupsResult = builder2.blackListElementGroups(new HashSet<>());

    Builder setViewToMergeResult = blackListElementGroupsResult.setViewToMerge(new View());

    Builder whiteListElementGroupsResult =
        setViewToMergeResult.whiteListElementGroups(new HashSet<>());

    Builder withDataAuthResult = whiteListElementGroupsResult.withDataAuth(new HashSet<>());

    Builder withOpAuthResult = withDataAuthResult.withOpAuth(new HashSet<>());

    Builder withoutDataAuthResult = withOpAuthResult.withoutDataAuth(new HashSet<>());
    builder.addHook(withoutDataAuthResult.withoutOpAuth(new HashSet<>()).build());
    GraphConfig config = builder.description("The characteristics of someone or something").build();
    Schema schema = new Schema();

    GraphSerialisable graphSerialisable = new GraphSerialisable(config, schema, new Properties());

    // Act and Assert
    assertNull(graphSerialisable.getGraphId());
  }

  /**
   * Test {@link GraphSerialisable#getGraphId()}.
   *
   * <ul>
   *   <li>Given {@link GraphConfig.Builder} (default constructor) otelActive {@code true}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link GraphSerialisable#getGraphId()}
   */
  @Test
  @DisplayName(
      "Test getGraphId(); given Builder (default constructor) otelActive 'true'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String GraphSerialisable.getGraphId()"})
  void testGetGraphId_givenBuilderOtelActiveTrue_thenReturnNull() {
    // Arrange
    GraphConfig.Builder builder = new GraphConfig.Builder();
    builder.otelActive(true);

    Builder builder2 = new Builder();

    Builder blackListElementGroupsResult = builder2.blackListElementGroups(new HashSet<>());

    Builder setViewToMergeResult = blackListElementGroupsResult.setViewToMerge(new View());

    Builder whiteListElementGroupsResult =
        setViewToMergeResult.whiteListElementGroups(new HashSet<>());

    Builder withDataAuthResult = whiteListElementGroupsResult.withDataAuth(new HashSet<>());

    Builder withOpAuthResult = withDataAuthResult.withOpAuth(new HashSet<>());

    Builder withoutDataAuthResult = withOpAuthResult.withoutDataAuth(new HashSet<>());
    builder.addHook(withoutDataAuthResult.withoutOpAuth(new HashSet<>()).build());
    GraphConfig config = builder.description("The characteristics of someone or something").build();
    Schema schema = new Schema();

    GraphSerialisable graphSerialisable = new GraphSerialisable(config, schema, new Properties());

    // Act and Assert
    assertNull(graphSerialisable.getGraphId());
  }

  /**
   * Test {@link GraphSerialisable#getGraphId()}.
   *
   * <ul>
   *   <li>Given {@link GraphConfig.Builder} (default constructor) view {@link View} (default
   *       constructor).
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link GraphSerialisable#getGraphId()}
   */
  @Test
  @DisplayName(
      "Test getGraphId(); given Builder (default constructor) view View (default constructor); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String GraphSerialisable.getGraphId()"})
  void testGetGraphId_givenBuilderViewView_thenReturnNull() {
    // Arrange
    GraphConfig.Builder builder = new GraphConfig.Builder();
    builder.view(new View());

    Builder builder2 = new Builder();

    Builder blackListElementGroupsResult = builder2.blackListElementGroups(new HashSet<>());

    Builder setViewToMergeResult = blackListElementGroupsResult.setViewToMerge(new View());

    Builder whiteListElementGroupsResult =
        setViewToMergeResult.whiteListElementGroups(new HashSet<>());

    Builder withDataAuthResult = whiteListElementGroupsResult.withDataAuth(new HashSet<>());

    Builder withOpAuthResult = withDataAuthResult.withOpAuth(new HashSet<>());

    Builder withoutDataAuthResult = withOpAuthResult.withoutDataAuth(new HashSet<>());
    builder.addHook(withoutDataAuthResult.withoutOpAuth(new HashSet<>()).build());
    GraphConfig config = builder.description("The characteristics of someone or something").build();
    Schema schema = new Schema();

    GraphSerialisable graphSerialisable = new GraphSerialisable(config, schema, new Properties());

    // Act and Assert
    assertNull(graphSerialisable.getGraphId());
  }

  /**
   * Test {@link GraphSerialisable#getGraphId()}.
   *
   * <ul>
   *   <li>Given {@link View} (default constructor) addConfig {@code .} and {@code 42}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link GraphSerialisable#getGraphId()}
   */
  @Test
  @DisplayName(
      "Test getGraphId(); given View (default constructor) addConfig '.' and '42'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String GraphSerialisable.getGraphId()"})
  void testGetGraphId_givenViewAddConfigDotAnd42_thenReturnNull() {
    // Arrange
    View viewToMerge = new View();
    viewToMerge.addConfig(".", "42");

    Builder builder = new Builder();

    Builder setViewToMergeResult =
        builder.blackListElementGroups(new HashSet<>()).setViewToMerge(viewToMerge);

    Builder whiteListElementGroupsResult =
        setViewToMergeResult.whiteListElementGroups(new HashSet<>());

    Builder withDataAuthResult = whiteListElementGroupsResult.withDataAuth(new HashSet<>());

    Builder withOpAuthResult = withDataAuthResult.withOpAuth(new HashSet<>());

    Builder withoutDataAuthResult = withOpAuthResult.withoutDataAuth(new HashSet<>());
    UpdateViewHook graphHook = withoutDataAuthResult.withoutOpAuth(new HashSet<>()).build();

    GraphConfig.Builder builder2 = new GraphConfig.Builder();
    builder2.addHook(graphHook);
    GraphConfig config =
        builder2.description("The characteristics of someone or something").build();
    Schema schema = new Schema();

    GraphSerialisable graphSerialisable = new GraphSerialisable(config, schema, new Properties());

    // Act and Assert
    assertNull(graphSerialisable.getGraphId());
  }

  /**
   * Test {@link GraphSerialisable#getGraphId()}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link GraphSerialisable#getGraphId()}
   */
  @Test
  @DisplayName("Test getGraphId(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String GraphSerialisable.getGraphId()"})
  void testGetGraphId_thenReturnNull() {
    // Arrange
    GraphConfig config =
        new GraphConfig.Builder()
            .description("The characteristics of someone or something")
            .build();
    Schema schema = new Schema();

    GraphSerialisable graphSerialisable = new GraphSerialisable(config, schema, new Properties());

    // Act and Assert
    assertNull(graphSerialisable.getGraphId());
  }

  /**
   * Test {@link GraphSerialisable#getGraphId()}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link GraphSerialisable#getGraphId()}
   */
  @Test
  @DisplayName("Test getGraphId(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String GraphSerialisable.getGraphId()"})
  void testGetGraphId_thenReturnNull2() {
    // Arrange
    GraphConfig.Builder builder = new GraphConfig.Builder();

    Builder builder2 = new Builder();

    Builder blackListElementGroupsResult = builder2.blackListElementGroups(new HashSet<>());

    Builder setViewToMergeResult = blackListElementGroupsResult.setViewToMerge(new View());

    Builder whiteListElementGroupsResult =
        setViewToMergeResult.whiteListElementGroups(new HashSet<>());

    Builder withDataAuthResult = whiteListElementGroupsResult.withDataAuth(new HashSet<>());

    Builder withOpAuthResult = withDataAuthResult.withOpAuth(new HashSet<>());

    Builder withoutDataAuthResult = withOpAuthResult.withoutDataAuth(new HashSet<>());
    builder.addHook(withoutDataAuthResult.withoutOpAuth(new HashSet<>()).build());
    GraphConfig config = builder.description("The characteristics of someone or something").build();
    Schema schema = new Schema();

    GraphSerialisable graphSerialisable = new GraphSerialisable(config, schema, new Properties());

    // Act and Assert
    assertNull(graphSerialisable.getGraphId());
  }

  /**
   * Test {@link GraphSerialisable#getGraphId()}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link GraphSerialisable#getGraphId()}
   */
  @Test
  @DisplayName("Test getGraphId(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String GraphSerialisable.getGraphId()"})
  void testGetGraphId_thenReturnNull3() {
    // Arrange
    GraphConfig.Builder builder = new GraphConfig.Builder();

    Builder builder2 = new Builder();

    Builder blackListElementGroupsResult = builder2.blackListElementGroups(new HashSet<>());

    Builder setViewToMergeResult = blackListElementGroupsResult.setViewToMerge(new View());

    Builder whiteListElementGroupsResult =
        setViewToMergeResult.whiteListElementGroups(new HashSet<>());

    Builder withDataAuthResult = whiteListElementGroupsResult.withDataAuth(new HashSet<>());

    Builder withOpAuthResult = withDataAuthResult.withOpAuth(new HashSet<>());

    Builder withoutDataAuthResult = withOpAuthResult.withoutDataAuth(new HashSet<>());
    builder.addHook(withoutDataAuthResult.withoutOpAuth(new HashSet<>()).build());

    Builder builder3 = new Builder();

    Builder blackListElementGroupsResult2 = builder3.blackListElementGroups(new HashSet<>());

    Builder setViewToMergeResult2 = blackListElementGroupsResult2.setViewToMerge(new View());

    Builder whiteListElementGroupsResult2 =
        setViewToMergeResult2.whiteListElementGroups(new HashSet<>());

    Builder withDataAuthResult2 = whiteListElementGroupsResult2.withDataAuth(new HashSet<>());

    Builder withOpAuthResult2 = withDataAuthResult2.withOpAuth(new HashSet<>());

    Builder withoutDataAuthResult2 = withOpAuthResult2.withoutDataAuth(new HashSet<>());
    builder.addHook(withoutDataAuthResult2.withoutOpAuth(new HashSet<>()).build());
    GraphConfig config = builder.description("The characteristics of someone or something").build();
    Schema schema = new Schema();

    GraphSerialisable graphSerialisable = new GraphSerialisable(config, schema, new Properties());

    // Act and Assert
    assertNull(graphSerialisable.getGraphId());
  }

  /**
   * Test {@link GraphSerialisable#getStoreProperties(GraphLibrary)} with {@code GraphLibrary}.
   *
   * <p>Method under test: {@link GraphSerialisable#getStoreProperties(GraphLibrary)}
   */
  @Test
  @DisplayName("Test getStoreProperties(GraphLibrary) with 'GraphLibrary'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"StoreProperties GraphSerialisable.getStoreProperties(GraphLibrary)"})
  void testGetStorePropertiesWithGraphLibrary() {
    // Arrange
    GraphConfig config =
        new GraphConfig.Builder()
            .description("The characteristics of someone or something")
            .build();
    Schema schema = new Schema();

    GraphSerialisable graphSerialisable = new GraphSerialisable(config, schema, new Properties());

    // Act
    StoreProperties actualStoreProperties =
        graphSerialisable.getStoreProperties(new FileGraphLibrary());

    // Assert
    assertEquals("", actualStoreProperties.getAdminAuth());
    assertEquals("", actualStoreProperties.getJsonSerialiserModules());
    assertEquals(
        "uk.gov.gchq.gaffer.store.StoreProperties",
        actualStoreProperties.getStorePropertiesClassName());
    assertEquals(
        "uk.gov.gchq.gaffer.store.schema.Schema", actualStoreProperties.getSchemaClassName());
    assertNull(actualStoreProperties.getStrictJson());
    assertNull(actualStoreProperties.getCacheServiceClass());
    assertNull(actualStoreProperties.getDefaultCacheServiceClass());
    assertNull(actualStoreProperties.getJobTrackerCacheServiceClass());
    assertNull(actualStoreProperties.getJsonSerialiserClass());
    assertNull(actualStoreProperties.getNamedOperationCacheServiceClass());
    assertNull(actualStoreProperties.getNamedViewCacheServiceClass());
    assertNull(actualStoreProperties.getOperationDeclarationPaths());
    assertNull(actualStoreProperties.getReflectionPackages());
    assertNull(actualStoreProperties.getStoreClass());
    assertEquals(50, actualStoreProperties.getJobExecutorThreadCount().intValue());
    assertFalse(actualStoreProperties.getJobTrackerEnabled());
    assertFalse(actualStoreProperties.getRescheduleJobsOnStart());
    assertTrue(actualStoreProperties.getProperties().isEmpty());
    assertTrue(actualStoreProperties.getNamedOperationEnabled());
    assertTrue(actualStoreProperties.getNamedViewEnabled());
    Class<StoreProperties> expectedStorePropertiesClass = StoreProperties.class;
    assertEquals(expectedStorePropertiesClass, actualStoreProperties.getStorePropertiesClass());
    Class<Schema> expectedSchemaClass = Schema.class;
    assertEquals(expectedSchemaClass, actualStoreProperties.getSchemaClass());
  }

  /**
   * Test {@link GraphSerialisable#getStoreProperties(GraphLibrary)} with {@code GraphLibrary}.
   *
   * <ul>
   *   <li>Given {@link GraphConfig.Builder} (default constructor) graphId {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link GraphSerialisable#getStoreProperties(GraphLibrary)}
   */
  @Test
  @DisplayName(
      "Test getStoreProperties(GraphLibrary) with 'GraphLibrary'; given Builder (default constructor) graphId '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"StoreProperties GraphSerialisable.getStoreProperties(GraphLibrary)"})
  void testGetStorePropertiesWithGraphLibrary_givenBuilderGraphId42() {
    // Arrange
    GraphConfig.Builder builder = new GraphConfig.Builder();
    builder.graphId("42");
    GraphConfig config = builder.description("The characteristics of someone or something").build();

    GraphSerialisable.Builder configResult = new GraphSerialisable.Builder().config(config);

    GraphSerialisable.Builder propertiesResult = configResult.properties(new Properties());
    GraphSerialisable graphSerialisable = propertiesResult.schema(new Schema()).build();

    // Act
    StoreProperties actualStoreProperties =
        graphSerialisable.getStoreProperties(new FileGraphLibrary());

    // Assert
    assertEquals("", actualStoreProperties.getAdminAuth());
    assertEquals("", actualStoreProperties.getJsonSerialiserModules());
    assertEquals(
        "uk.gov.gchq.gaffer.store.StoreProperties",
        actualStoreProperties.getStorePropertiesClassName());
    assertEquals(
        "uk.gov.gchq.gaffer.store.schema.Schema", actualStoreProperties.getSchemaClassName());
    assertNull(actualStoreProperties.getStrictJson());
    assertNull(actualStoreProperties.getCacheServiceClass());
    assertNull(actualStoreProperties.getDefaultCacheServiceClass());
    assertNull(actualStoreProperties.getJobTrackerCacheServiceClass());
    assertNull(actualStoreProperties.getJsonSerialiserClass());
    assertNull(actualStoreProperties.getNamedOperationCacheServiceClass());
    assertNull(actualStoreProperties.getNamedViewCacheServiceClass());
    assertNull(actualStoreProperties.getOperationDeclarationPaths());
    assertNull(actualStoreProperties.getReflectionPackages());
    assertNull(actualStoreProperties.getStoreClass());
    assertEquals(50, actualStoreProperties.getJobExecutorThreadCount().intValue());
    assertFalse(actualStoreProperties.getJobTrackerEnabled());
    assertFalse(actualStoreProperties.getRescheduleJobsOnStart());
    assertTrue(actualStoreProperties.getProperties().isEmpty());
    assertTrue(actualStoreProperties.getNamedOperationEnabled());
    assertTrue(actualStoreProperties.getNamedViewEnabled());
    Class<StoreProperties> expectedStorePropertiesClass = StoreProperties.class;
    assertEquals(expectedStorePropertiesClass, actualStoreProperties.getStorePropertiesClass());
    Class<Schema> expectedSchemaClass = Schema.class;
    assertEquals(expectedSchemaClass, actualStoreProperties.getSchemaClass());
  }

  /**
   * Test {@link GraphSerialisable#getStoreProperties(GraphLibrary)} with {@code GraphLibrary}.
   *
   * <ul>
   *   <li>Then return Properties size is one.
   * </ul>
   *
   * <p>Method under test: {@link GraphSerialisable#getStoreProperties(GraphLibrary)}
   */
  @Test
  @DisplayName(
      "Test getStoreProperties(GraphLibrary) with 'GraphLibrary'; then return Properties size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"StoreProperties GraphSerialisable.getStoreProperties(GraphLibrary)"})
  void testGetStorePropertiesWithGraphLibrary_thenReturnPropertiesSizeIsOne() {
    // Arrange
    GraphConfig config =
        new GraphConfig.Builder()
            .description("The characteristics of someone or something")
            .build();
    Schema schema = new Schema();

    GraphSerialisable graphSerialisable =
        new GraphSerialisable(config, schema, new StoreProperties());

    // Act and Assert
    Properties properties =
        graphSerialisable.getStoreProperties(new FileGraphLibrary()).getProperties();
    assertEquals(1, properties.size());
    assertEquals(
        "uk.gov.gchq.gaffer.store.StoreProperties",
        properties.get("gaffer.store.properties.class"));
  }

  /**
   * Test {@link GraphSerialisable#getStoreProperties()}.
   *
   * <ul>
   *   <li>Then return AdminAuth is empty string.
   * </ul>
   *
   * <p>Method under test: {@link GraphSerialisable#getStoreProperties()}
   */
  @Test
  @DisplayName("Test getStoreProperties(); then return AdminAuth is empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"StoreProperties GraphSerialisable.getStoreProperties()"})
  void testGetStoreProperties_thenReturnAdminAuthIsEmptyString() {
    // Arrange
    GraphConfig config =
        new GraphConfig.Builder()
            .description("The characteristics of someone or something")
            .build();
    Schema schema = new Schema();

    GraphSerialisable graphSerialisable = new GraphSerialisable(config, schema, new Properties());

    // Act
    StoreProperties actualStoreProperties = graphSerialisable.getStoreProperties();

    // Assert
    assertEquals("", actualStoreProperties.getAdminAuth());
    assertEquals("", actualStoreProperties.getJsonSerialiserModules());
    assertEquals(
        "uk.gov.gchq.gaffer.store.StoreProperties",
        actualStoreProperties.getStorePropertiesClassName());
    assertEquals(
        "uk.gov.gchq.gaffer.store.schema.Schema", actualStoreProperties.getSchemaClassName());
    assertNull(actualStoreProperties.getStrictJson());
    assertNull(actualStoreProperties.getCacheServiceClass());
    assertNull(actualStoreProperties.getDefaultCacheServiceClass());
    assertNull(actualStoreProperties.getJobTrackerCacheServiceClass());
    assertNull(actualStoreProperties.getJsonSerialiserClass());
    assertNull(actualStoreProperties.getNamedOperationCacheServiceClass());
    assertNull(actualStoreProperties.getNamedViewCacheServiceClass());
    assertNull(actualStoreProperties.getOperationDeclarationPaths());
    assertNull(actualStoreProperties.getReflectionPackages());
    assertNull(actualStoreProperties.getStoreClass());
    assertEquals(50, actualStoreProperties.getJobExecutorThreadCount().intValue());
    assertFalse(actualStoreProperties.getJobTrackerEnabled());
    assertFalse(actualStoreProperties.getRescheduleJobsOnStart());
    assertTrue(actualStoreProperties.getProperties().isEmpty());
    assertTrue(actualStoreProperties.getNamedOperationEnabled());
    assertTrue(actualStoreProperties.getNamedViewEnabled());
    Class<StoreProperties> expectedStorePropertiesClass = StoreProperties.class;
    assertEquals(expectedStorePropertiesClass, actualStoreProperties.getStorePropertiesClass());
    Class<Schema> expectedSchemaClass = Schema.class;
    assertEquals(expectedSchemaClass, actualStoreProperties.getSchemaClass());
  }

  /**
   * Test {@link GraphSerialisable#getStoreProperties()}.
   *
   * <ul>
   *   <li>Then return Properties size is one.
   * </ul>
   *
   * <p>Method under test: {@link GraphSerialisable#getStoreProperties()}
   */
  @Test
  @DisplayName("Test getStoreProperties(); then return Properties size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"StoreProperties GraphSerialisable.getStoreProperties()"})
  void testGetStoreProperties_thenReturnPropertiesSizeIsOne() {
    // Arrange
    GraphConfig config =
        new GraphConfig.Builder()
            .description("The characteristics of someone or something")
            .build();
    Schema schema = new Schema();

    GraphSerialisable graphSerialisable =
        new GraphSerialisable(config, schema, new StoreProperties());

    // Act and Assert
    Properties properties = graphSerialisable.getStoreProperties().getProperties();
    assertEquals(1, properties.size());
    assertEquals(
        "uk.gov.gchq.gaffer.store.StoreProperties",
        properties.get("gaffer.store.properties.class"));
  }

  /**
   * Test {@link GraphSerialisable#getConfig()}.
   *
   * <ul>
   *   <li>Given {@link GraphConfig.Builder} {@link GraphConfig.Builder#addHook(GraphHook)} return
   *       {@link GraphConfig.Builder} (default constructor).
   *   <li>Then return Description is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link GraphSerialisable#getConfig()}
   */
  @Test
  @DisplayName(
      "Test getConfig(); given Builder addHook(GraphHook) return Builder (default constructor); then return Description is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"GraphConfig GraphSerialisable.getConfig()"})
  void testGetConfig_givenBuilderAddHookReturnBuilder_thenReturnDescriptionIsNull() {
    // Arrange
    GraphConfig.Builder builder = mock(GraphConfig.Builder.class);
    when(builder.addHook(Mockito.<GraphHook>any())).thenReturn(new GraphConfig.Builder());
    when(builder.description(Mockito.<String>any())).thenReturn(new GraphConfig.Builder());

    Builder builder2 = new Builder();

    Builder blackListElementGroupsResult = builder2.blackListElementGroups(new HashSet<>());

    Builder setViewToMergeResult = blackListElementGroupsResult.setViewToMerge(new View());

    Builder whiteListElementGroupsResult =
        setViewToMergeResult.whiteListElementGroups(new HashSet<>());

    Builder withDataAuthResult = whiteListElementGroupsResult.withDataAuth(new HashSet<>());

    Builder withOpAuthResult = withDataAuthResult.withOpAuth(new HashSet<>());

    Builder withoutDataAuthResult = withOpAuthResult.withoutDataAuth(new HashSet<>());
    builder.addHook(withoutDataAuthResult.withoutOpAuth(new HashSet<>()).build());
    GraphConfig config = builder.description("The characteristics of someone or something").build();
    Schema schema = new Schema();

    GraphSerialisable graphSerialisable = new GraphSerialisable(config, schema, new Properties());

    // Act
    GraphConfig actualConfig = graphSerialisable.getConfig();

    // Assert
    verify(builder).addHook(isA(GraphHook.class));
    verify(builder).description("The characteristics of someone or something");
    assertTrue(actualConfig.getLibrary() instanceof NoGraphLibrary);
    assertNull(actualConfig.getOtelActive());
    assertNull(actualConfig.getDescription());
    assertNull(actualConfig.getGraphId());
    assertNull(actualConfig.getView());
    assertTrue(actualConfig.getHooks().isEmpty());
  }

  /**
   * Test {@link GraphSerialisable#getConfig()}.
   *
   * <ul>
   *   <li>Given {@link GraphConfig.Builder} (default constructor) graphId {@code 42}.
   *   <li>Then return GraphId is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link GraphSerialisable#getConfig()}
   */
  @Test
  @DisplayName(
      "Test getConfig(); given Builder (default constructor) graphId '42'; then return GraphId is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"GraphConfig GraphSerialisable.getConfig()"})
  void testGetConfig_givenBuilderGraphId42_thenReturnGraphIdIs42() throws SchemaException {
    // Arrange
    GraphConfig.Builder builder = new GraphConfig.Builder();
    builder.graphId("42");

    Builder builder2 = new Builder();

    Builder blackListElementGroupsResult = builder2.blackListElementGroups(new HashSet<>());

    Builder setViewToMergeResult = blackListElementGroupsResult.setViewToMerge(new View());

    Builder whiteListElementGroupsResult =
        setViewToMergeResult.whiteListElementGroups(new HashSet<>());

    Builder withDataAuthResult = whiteListElementGroupsResult.withDataAuth(new HashSet<>());

    Builder withOpAuthResult = withDataAuthResult.withOpAuth(new HashSet<>());

    Builder withoutDataAuthResult = withOpAuthResult.withoutDataAuth(new HashSet<>());
    builder.addHook(withoutDataAuthResult.withoutOpAuth(new HashSet<>()).build());
    GraphConfig config = builder.description("The characteristics of someone or something").build();
    Schema schema = new Schema();

    GraphSerialisable graphSerialisable = new GraphSerialisable(config, schema, new Properties());

    // Act
    GraphConfig actualConfig = graphSerialisable.getConfig();

    // Assert
    List<GraphHook> hooks = actualConfig.getHooks();
    assertEquals(1, hooks.size());
    GraphHook getResult = hooks.get(0);
    assertTrue(getResult instanceof UpdateViewHook);
    assertEquals("42", actualConfig.getGraphId());
    View viewToMerge = ((UpdateViewHook) getResult).getViewToMerge();
    assertTrue(viewToMerge.getConfig().isEmpty());
    assertArrayEquals(new byte[] {'{', '}'}, viewToMerge.toCompactJson());
  }

  /**
   * Test {@link GraphSerialisable#getConfig()}.
   *
   * <ul>
   *   <li>Given {@link GraphConfig.Builder} (default constructor) otelActive {@code true}.
   *   <li>Then return OtelActive.
   * </ul>
   *
   * <p>Method under test: {@link GraphSerialisable#getConfig()}
   */
  @Test
  @DisplayName(
      "Test getConfig(); given Builder (default constructor) otelActive 'true'; then return OtelActive")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"GraphConfig GraphSerialisable.getConfig()"})
  void testGetConfig_givenBuilderOtelActiveTrue_thenReturnOtelActive() throws SchemaException {
    // Arrange
    GraphConfig.Builder builder = new GraphConfig.Builder();
    builder.otelActive(true);

    Builder builder2 = new Builder();

    Builder blackListElementGroupsResult = builder2.blackListElementGroups(new HashSet<>());

    Builder setViewToMergeResult = blackListElementGroupsResult.setViewToMerge(new View());

    Builder whiteListElementGroupsResult =
        setViewToMergeResult.whiteListElementGroups(new HashSet<>());

    Builder withDataAuthResult = whiteListElementGroupsResult.withDataAuth(new HashSet<>());

    Builder withOpAuthResult = withDataAuthResult.withOpAuth(new HashSet<>());

    Builder withoutDataAuthResult = withOpAuthResult.withoutDataAuth(new HashSet<>());
    builder.addHook(withoutDataAuthResult.withoutOpAuth(new HashSet<>()).build());
    GraphConfig config = builder.description("The characteristics of someone or something").build();
    Schema schema = new Schema();

    GraphSerialisable graphSerialisable = new GraphSerialisable(config, schema, new Properties());

    // Act
    GraphConfig actualConfig = graphSerialisable.getConfig();

    // Assert
    List<GraphHook> hooks = actualConfig.getHooks();
    assertEquals(1, hooks.size());
    GraphHook getResult = hooks.get(0);
    assertTrue(getResult instanceof UpdateViewHook);
    View viewToMerge = ((UpdateViewHook) getResult).getViewToMerge();
    assertTrue(viewToMerge.getConfig().isEmpty());
    assertTrue(actualConfig.getOtelActive());
    assertArrayEquals(new byte[] {'{', '}'}, viewToMerge.toCompactJson());
  }

  /**
   * Test {@link GraphSerialisable#getConfig()}.
   *
   * <ul>
   *   <li>Given {@link GraphConfig.Builder} (default constructor) view {@link View} (default
   *       constructor).
   *   <li>Then return View is {@link View} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link GraphSerialisable#getConfig()}
   */
  @Test
  @DisplayName(
      "Test getConfig(); given Builder (default constructor) view View (default constructor); then return View is View (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"GraphConfig GraphSerialisable.getConfig()"})
  void testGetConfig_givenBuilderViewView_thenReturnViewIsView() {
    // Arrange
    GraphConfig.Builder builder = new GraphConfig.Builder();
    View view = new View();
    builder.view(view);

    Builder builder2 = new Builder();

    Builder blackListElementGroupsResult = builder2.blackListElementGroups(new HashSet<>());

    Builder setViewToMergeResult = blackListElementGroupsResult.setViewToMerge(new View());

    Builder whiteListElementGroupsResult =
        setViewToMergeResult.whiteListElementGroups(new HashSet<>());

    Builder withDataAuthResult = whiteListElementGroupsResult.withDataAuth(new HashSet<>());

    Builder withOpAuthResult = withDataAuthResult.withOpAuth(new HashSet<>());

    Builder withoutDataAuthResult = withOpAuthResult.withoutDataAuth(new HashSet<>());
    builder.addHook(withoutDataAuthResult.withoutOpAuth(new HashSet<>()).build());
    GraphConfig config = builder.description("The characteristics of someone or something").build();
    Schema schema = new Schema();

    GraphSerialisable graphSerialisable = new GraphSerialisable(config, schema, new Properties());

    // Act and Assert
    assertEquals(view, graphSerialisable.getConfig().getView());
  }

  /**
   * Test {@link GraphSerialisable#getConfig()}.
   *
   * <ul>
   *   <li>Then Library return {@link FileGraphLibrary}.
   * </ul>
   *
   * <p>Method under test: {@link GraphSerialisable#getConfig()}
   */
  @Test
  @DisplayName("Test getConfig(); then Library return FileGraphLibrary")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"GraphConfig GraphSerialisable.getConfig()"})
  void testGetConfig_thenLibraryReturnFileGraphLibrary() throws SchemaException {
    // Arrange
    GraphConfig.Builder builder = new GraphConfig.Builder();
    builder.library(new FileGraphLibrary());

    Builder builder2 = new Builder();

    Builder blackListElementGroupsResult = builder2.blackListElementGroups(new HashSet<>());

    Builder setViewToMergeResult = blackListElementGroupsResult.setViewToMerge(new View());

    Builder whiteListElementGroupsResult =
        setViewToMergeResult.whiteListElementGroups(new HashSet<>());

    Builder withDataAuthResult = whiteListElementGroupsResult.withDataAuth(new HashSet<>());

    Builder withOpAuthResult = withDataAuthResult.withOpAuth(new HashSet<>());

    Builder withoutDataAuthResult = withOpAuthResult.withoutDataAuth(new HashSet<>());
    builder.addHook(withoutDataAuthResult.withoutOpAuth(new HashSet<>()).build());
    GraphConfig config = builder.description("The characteristics of someone or something").build();
    Schema schema = new Schema();

    GraphSerialisable graphSerialisable = new GraphSerialisable(config, schema, new Properties());

    // Act
    GraphConfig actualConfig = graphSerialisable.getConfig();

    // Assert
    List<GraphHook> hooks = actualConfig.getHooks();
    assertEquals(1, hooks.size());
    GraphHook getResult = hooks.get(0);
    assertTrue(getResult instanceof UpdateViewHook);
    GraphLibrary library = actualConfig.getLibrary();
    assertTrue(library instanceof FileGraphLibrary);
    assertEquals("graphLibrary", ((FileGraphLibrary) library).getPath());
    View viewToMerge = ((UpdateViewHook) getResult).getViewToMerge();
    assertTrue(viewToMerge.getConfig().isEmpty());
    assertArrayEquals(new byte[] {'{', '}'}, viewToMerge.toCompactJson());
  }

  /**
   * Test {@link GraphSerialisable#getConfig()}.
   *
   * <ul>
   *   <li>Then return Description is {@code The characteristics of someone or something}.
   * </ul>
   *
   * <p>Method under test: {@link GraphSerialisable#getConfig()}
   */
  @Test
  @DisplayName(
      "Test getConfig(); then return Description is 'The characteristics of someone or something'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"GraphConfig GraphSerialisable.getConfig()"})
  void testGetConfig_thenReturnDescriptionIsTheCharacteristicsOfSomeoneOrSomething() {
    // Arrange
    GraphConfig config =
        new GraphConfig.Builder()
            .description("The characteristics of someone or something")
            .build();
    Schema schema = new Schema();

    GraphSerialisable graphSerialisable = new GraphSerialisable(config, schema, new Properties());

    // Act
    GraphConfig actualConfig = graphSerialisable.getConfig();

    // Assert
    assertTrue(actualConfig.getLibrary() instanceof NoGraphLibrary);
    assertEquals("The characteristics of someone or something", actualConfig.getDescription());
    assertNull(actualConfig.getOtelActive());
    assertNull(actualConfig.getGraphId());
    assertNull(actualConfig.getView());
    assertTrue(actualConfig.getHooks().isEmpty());
  }

  /**
   * Test {@link GraphSerialisable#getConfig()}.
   *
   * <ul>
   *   <li>Then return Hooks first ViewToMerge Config size is one.
   * </ul>
   *
   * <p>Method under test: {@link GraphSerialisable#getConfig()}
   */
  @Test
  @DisplayName("Test getConfig(); then return Hooks first ViewToMerge Config size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"GraphConfig GraphSerialisable.getConfig()"})
  void testGetConfig_thenReturnHooksFirstViewToMergeConfigSizeIsOne()
      throws UnsupportedEncodingException, SchemaException {
    // Arrange
    View viewToMerge = new View();
    viewToMerge.addConfig("filterFieldsByName", "42");

    Builder builder = new Builder();

    Builder setViewToMergeResult =
        builder.blackListElementGroups(new HashSet<>()).setViewToMerge(viewToMerge);

    Builder whiteListElementGroupsResult =
        setViewToMergeResult.whiteListElementGroups(new HashSet<>());

    Builder withDataAuthResult = whiteListElementGroupsResult.withDataAuth(new HashSet<>());

    Builder withOpAuthResult = withDataAuthResult.withOpAuth(new HashSet<>());

    Builder withoutDataAuthResult = withOpAuthResult.withoutDataAuth(new HashSet<>());
    UpdateViewHook graphHook = withoutDataAuthResult.withoutOpAuth(new HashSet<>()).build();

    GraphConfig.Builder builder2 = new GraphConfig.Builder();
    builder2.addHook(graphHook);
    GraphConfig config =
        builder2.description("The characteristics of someone or something").build();
    Schema schema = new Schema();

    GraphSerialisable graphSerialisable = new GraphSerialisable(config, schema, new Properties());

    // Act and Assert
    List<GraphHook> hooks = graphSerialisable.getConfig().getHooks();
    assertEquals(1, hooks.size());
    GraphHook getResult = hooks.get(0);
    assertTrue(getResult instanceof UpdateViewHook);
    View viewToMerge2 = ((UpdateViewHook) getResult).getViewToMerge();
    Map<String, String> config2 = viewToMerge2.getConfig();
    assertEquals(1, config2.size());
    assertEquals("42", config2.get("filterFieldsByName"));
    byte[] expectedToCompactJsonResult =
        "{\"config\":{\"filterFieldsByName\":\"42\"}}".getBytes("UTF-8");
    assertArrayEquals(expectedToCompactJsonResult, viewToMerge2.toCompactJson());
  }

  /**
   * Test {@link GraphSerialisable#getConfig()}.
   *
   * <ul>
   *   <li>Then return Hooks size is two.
   * </ul>
   *
   * <p>Method under test: {@link GraphSerialisable#getConfig()}
   */
  @Test
  @DisplayName("Test getConfig(); then return Hooks size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"GraphConfig GraphSerialisable.getConfig()"})
  void testGetConfig_thenReturnHooksSizeIsTwo() {
    // Arrange
    GraphConfig.Builder builder = new GraphConfig.Builder();

    Builder builder2 = new Builder();

    Builder blackListElementGroupsResult = builder2.blackListElementGroups(new HashSet<>());
    View viewToMerge = new View();

    Builder setViewToMergeResult = blackListElementGroupsResult.setViewToMerge(viewToMerge);

    Builder whiteListElementGroupsResult =
        setViewToMergeResult.whiteListElementGroups(new HashSet<>());

    Builder withDataAuthResult = whiteListElementGroupsResult.withDataAuth(new HashSet<>());

    Builder withOpAuthResult = withDataAuthResult.withOpAuth(new HashSet<>());

    Builder withoutDataAuthResult = withOpAuthResult.withoutDataAuth(new HashSet<>());
    builder.addHook(withoutDataAuthResult.withoutOpAuth(new HashSet<>()).build());

    Builder builder3 = new Builder();

    Builder blackListElementGroupsResult2 = builder3.blackListElementGroups(new HashSet<>());

    Builder setViewToMergeResult2 = blackListElementGroupsResult2.setViewToMerge(new View());

    Builder whiteListElementGroupsResult2 =
        setViewToMergeResult2.whiteListElementGroups(new HashSet<>());

    Builder withDataAuthResult2 = whiteListElementGroupsResult2.withDataAuth(new HashSet<>());

    Builder withOpAuthResult2 = withDataAuthResult2.withOpAuth(new HashSet<>());

    Builder withoutDataAuthResult2 = withOpAuthResult2.withoutDataAuth(new HashSet<>());
    builder.addHook(withoutDataAuthResult2.withoutOpAuth(new HashSet<>()).build());
    GraphConfig config = builder.description("The characteristics of someone or something").build();
    Schema schema = new Schema();

    GraphSerialisable graphSerialisable = new GraphSerialisable(config, schema, new Properties());

    // Act and Assert
    List<GraphHook> hooks = graphSerialisable.getConfig().getHooks();
    assertEquals(2, hooks.size());
    GraphHook getResult = hooks.get(1);
    assertTrue(getResult instanceof UpdateViewHook);
    assertFalse(((UpdateViewHook) getResult).isAddExtraGroups());
    assertTrue(((UpdateViewHook) getResult).getBlackListElementGroups().isEmpty());
    assertTrue(((UpdateViewHook) getResult).getWhiteListElementGroups().isEmpty());
    assertTrue(((UpdateViewHook) getResult).getWithDataAuth().isEmpty());
    assertTrue(((UpdateViewHook) getResult).getWithOpAuth().isEmpty());
    assertTrue(((UpdateViewHook) getResult).getWithoutDataAuth().isEmpty());
    assertTrue(((UpdateViewHook) getResult).getWithoutOpAuth().isEmpty());
    assertEquals(viewToMerge, ((UpdateViewHook) getResult).getViewToMerge());
  }

  /**
   * Test {@link GraphSerialisable#getConfig()}.
   *
   * <ul>
   *   <li>Then return not Hooks first AddExtraGroups.
   * </ul>
   *
   * <p>Method under test: {@link GraphSerialisable#getConfig()}
   */
  @Test
  @DisplayName("Test getConfig(); then return not Hooks first AddExtraGroups")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"GraphConfig GraphSerialisable.getConfig()"})
  void testGetConfig_thenReturnNotHooksFirstAddExtraGroups() {
    // Arrange
    GraphConfig.Builder builder = new GraphConfig.Builder();

    Builder builder2 = new Builder();

    Builder blackListElementGroupsResult = builder2.blackListElementGroups(new HashSet<>());
    View viewToMerge = new View();

    Builder setViewToMergeResult = blackListElementGroupsResult.setViewToMerge(viewToMerge);

    Builder whiteListElementGroupsResult =
        setViewToMergeResult.whiteListElementGroups(new HashSet<>());

    Builder withDataAuthResult = whiteListElementGroupsResult.withDataAuth(new HashSet<>());

    Builder withOpAuthResult = withDataAuthResult.withOpAuth(new HashSet<>());

    Builder withoutDataAuthResult = withOpAuthResult.withoutDataAuth(new HashSet<>());
    builder.addHook(withoutDataAuthResult.withoutOpAuth(new HashSet<>()).build());
    GraphConfig config = builder.description("The characteristics of someone or something").build();
    Schema schema = new Schema();

    GraphSerialisable graphSerialisable = new GraphSerialisable(config, schema, new Properties());

    // Act and Assert
    List<GraphHook> hooks = graphSerialisable.getConfig().getHooks();
    assertEquals(1, hooks.size());
    GraphHook getResult = hooks.get(0);
    assertTrue(getResult instanceof UpdateViewHook);
    assertFalse(((UpdateViewHook) getResult).isAddExtraGroups());
    assertTrue(((UpdateViewHook) getResult).getBlackListElementGroups().isEmpty());
    assertTrue(((UpdateViewHook) getResult).getWhiteListElementGroups().isEmpty());
    assertTrue(((UpdateViewHook) getResult).getWithDataAuth().isEmpty());
    assertTrue(((UpdateViewHook) getResult).getWithOpAuth().isEmpty());
    assertTrue(((UpdateViewHook) getResult).getWithoutDataAuth().isEmpty());
    assertTrue(((UpdateViewHook) getResult).getWithoutOpAuth().isEmpty());
    assertEquals(viewToMerge, ((UpdateViewHook) getResult).getViewToMerge());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link GraphSerialisable#toString()}
   *   <li>{@link GraphSerialisable#getSerialisedConfig()}
   *   <li>{@link GraphSerialisable#getSerialisedProperties()}
   *   <li>{@link GraphSerialisable#getSerialisedSchema()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "byte[] GraphSerialisable.getSerialisedConfig()",
    "byte[] GraphSerialisable.getSerialisedProperties()",
    "byte[] GraphSerialisable.getSerialisedSchema()",
    "String GraphSerialisable.toString()"
  })
  void testGettersAndSetters() throws UnsupportedEncodingException {
    // Arrange
    GraphConfig config =
        new GraphConfig.Builder()
            .description("The characteristics of someone or something")
            .build();
    Schema schema = new Schema();

    GraphSerialisable graphSerialisable = new GraphSerialisable(config, schema, new Properties());

    // Act
    graphSerialisable.toString();
    byte[] actualSerialisedConfig = graphSerialisable.getSerialisedConfig();
    byte[] actualSerialisedProperties = graphSerialisable.getSerialisedProperties();

    // Assert
    assertEquals(169, actualSerialisedConfig.length);
    assertEquals(' ', actualSerialisedConfig[164]);
    assertEquals(' ', actualSerialisedConfig[165]);
    assertEquals(' ', actualSerialisedConfig[17]);
    assertEquals(' ', actualSerialisedConfig[19]);
    assertEquals(' ', actualSerialisedConfig[2]);
    assertEquals(' ', actualSerialisedConfig[24]);
    assertEquals(' ', actualSerialisedConfig[3]);
    assertEquals('.', actualSerialisedConfig[147]);
    assertEquals(':', actualSerialisedConfig[18]);
    assertEquals('G', actualSerialisedConfig[150]);
    assertEquals('L', actualSerialisedConfig[155]);
    assertEquals('N', actualSerialisedConfig[148]);
    assertEquals('T', actualSerialisedConfig[21]);
    assertEquals('"', actualSerialisedConfig[162]);
    assertEquals('"', actualSerialisedConfig[20]);
    assertEquals('"', actualSerialisedConfig[4]);
    assertEquals('"', actualSerialisedConfig[Short.SIZE]);
    assertEquals('\n', actualSerialisedConfig[1]);
    assertEquals('\n', actualSerialisedConfig[163]);
    assertEquals('\n', actualSerialisedConfig[167]);
    assertEquals('a', actualSerialisedConfig[144]);
    assertEquals('a', actualSerialisedConfig[152]);
    assertEquals('a', actualSerialisedConfig[159]);
    assertEquals('b', actualSerialisedConfig[157]);
    assertEquals('c', actualSerialisedConfig[8]);
    assertEquals('d', actualSerialisedConfig[5]);
    assertEquals('e', actualSerialisedConfig[23]);
    assertEquals('e', actualSerialisedConfig[6]);
    assertEquals('h', actualSerialisedConfig[154]);
    assertEquals('h', actualSerialisedConfig[22]);
    assertEquals('i', actualSerialisedConfig[10]);
    assertEquals('i', actualSerialisedConfig[13]);
    assertEquals('i', actualSerialisedConfig[156]);
    assertEquals('n', actualSerialisedConfig[15]);
    assertEquals('o', actualSerialisedConfig[14]);
    assertEquals('o', actualSerialisedConfig[149]);
    assertEquals('p', actualSerialisedConfig[11]);
    assertEquals('p', actualSerialisedConfig[153]);
    assertEquals('r', actualSerialisedConfig[145]);
    assertEquals('r', actualSerialisedConfig[151]);
    assertEquals('r', actualSerialisedConfig[158]);
    assertEquals('r', actualSerialisedConfig[160]);
    assertEquals('r', actualSerialisedConfig[9]);
    assertEquals('s', actualSerialisedConfig[7]);
    assertEquals('t', actualSerialisedConfig[12]);
    assertEquals('y', actualSerialisedConfig[146]);
    assertEquals('y', actualSerialisedConfig[161]);
    assertEquals('{', actualSerialisedConfig[0]);
    assertEquals('}', actualSerialisedConfig[166]);
    assertEquals('}', actualSerialisedConfig[168]);
    assertArrayEquals("{ }".getBytes("UTF-8"), actualSerialisedProperties);
    assertArrayEquals(
        "{\n  \"types\" : { }\n}".getBytes("UTF-8"), graphSerialisable.getSerialisedSchema());
  }
}
