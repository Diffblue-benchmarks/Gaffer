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

package uk.gov.gchq.gaffer.tinkerpop;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.apache.commons.configuration2.BaseConfiguration;
import org.apache.commons.configuration2.CompositeConfiguration;
import org.apache.commons.configuration2.Configuration;
import org.apache.commons.configuration2.EnvironmentConfiguration;
import org.apache.commons.configuration2.INIConfiguration;
import org.apache.commons.configuration2.tree.ImmutableNode;
import org.apache.tinkerpop.gremlin.process.traversal.TraversalStrategies;
import org.apache.tinkerpop.gremlin.process.traversal.dsl.graph.GraphTraversalSource;
import org.apache.tinkerpop.gremlin.process.traversal.util.DefaultTraversalStrategies;
import org.apache.tinkerpop.gremlin.structure.Graph.Variables;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.graph.Graph;
import uk.gov.gchq.gaffer.operation.serialisation.TypeReferenceImpl;
import uk.gov.gchq.gaffer.operation.serialisation.TypeReferenceImpl.Void;
import uk.gov.gchq.gaffer.user.User;
import uk.gov.gchq.gaffer.user.User.Builder;

class GafferPopGraphDiffblueTest {
  /**
   * Test {@link GafferPopGraph#GafferPopGraph(Configuration, Graph)}.
   *
   * <p>Method under test: {@link GafferPopGraph#GafferPopGraph(Configuration, Graph)}
   */
  @Test
  @DisplayName("Test new GafferPopGraph(Configuration, Graph)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void GafferPopGraph.<init>(Configuration, Graph)"})
  void testNewGafferPopGraph() {
    // Arrange
    INIConfiguration configuration =
        INIConfiguration.builder().setSectionInLineCommentsAllowed(true).build();

    // Act
    GafferPopGraph actualGafferPopGraph = new GafferPopGraph(configuration, null);

    // Assert
    Configuration configurationResult = actualGafferPopGraph.configuration();
    assertTrue(configurationResult instanceof INIConfiguration);
    ImmutableNode inMemoryRepresentation =
        ((INIConfiguration) configurationResult).getNodeModel().getInMemoryRepresentation();
    assertFalse(inMemoryRepresentation.iterator().hasNext());
    Stream<ImmutableNode> streamResult = inMemoryRepresentation.stream();
    assertTrue(streamResult.limit(5).collect(Collectors.toList()).isEmpty());
    assertTrue(inMemoryRepresentation.getChildren().isEmpty());
    assertTrue(((INIConfiguration) configurationResult).getSections().isEmpty());
  }

  /**
   * Test {@link GafferPopGraph#GafferPopGraph(Configuration, Graph)}.
   *
   * <p>Method under test: {@link GafferPopGraph#GafferPopGraph(Configuration, Graph)}
   */
  @Test
  @DisplayName("Test new GafferPopGraph(Configuration, Graph)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void GafferPopGraph.<init>(Configuration, Graph)"})
  void testNewGafferPopGraph2() {
    // Arrange
    BaseConfiguration configuration = new BaseConfiguration();
    configuration.addProperty(GafferPopGraph.USER_ID, new Builder().userId("42").build());

    // Act
    GafferPopGraph actualGafferPopGraph = new GafferPopGraph(configuration, null);

    // Assert
    GraphTraversalSource traversalResult = actualGafferPopGraph.traversal();
    TraversalStrategies strategies = traversalResult.getStrategies();
    assertTrue(strategies instanceof DefaultTraversalStrategies);
    Variables variablesResult = actualGafferPopGraph.variables();
    assertTrue(
        ((GafferPopGraphVariables) variablesResult).getLastOperationChain().getOutputTypeReference()
            instanceof Void);
    assertTrue(variablesResult instanceof GafferPopGraphVariables);
    assertEquals(
        "User[userId=42,dataAuths=[],opAuths=[]]",
        ((GafferPopGraphVariables) variablesResult).getUser().getUserId());
    assertEquals(18, strategies.toList().size());
    assertSame(configuration, actualGafferPopGraph.configuration());
    assertSame(actualGafferPopGraph, traversalResult.getGraph());
  }

  /**
   * Test {@link GafferPopGraph#GafferPopGraph(Configuration, Graph)}.
   *
   * <p>Method under test: {@link GafferPopGraph#GafferPopGraph(Configuration, Graph)}
   */
  @Test
  @DisplayName("Test new GafferPopGraph(Configuration, Graph)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void GafferPopGraph.<init>(Configuration, Graph)"})
  void testNewGafferPopGraph3() {
    // Arrange
    INIConfiguration configuration =
        INIConfiguration.builder().setSectionInLineCommentsAllowed(true).build();
    configuration.addProperty(GafferPopGraph.USER_ID, new Builder().userId("42").build());

    // Act
    GafferPopGraph actualGafferPopGraph = new GafferPopGraph(configuration, null);

    // Assert
    Configuration configurationResult = actualGafferPopGraph.configuration();
    assertTrue(configurationResult instanceof INIConfiguration);
    List<ImmutableNode> children =
        ((INIConfiguration) configurationResult)
            .getNodeModel()
            .getInMemoryRepresentation()
            .getChildren();
    assertEquals(1, children.size());
    List<ImmutableNode> children2 = children.get(0).getChildren();
    assertEquals(1, children2.size());
    ImmutableNode getResult = children2.get(0);
    Object value = getResult.getValue();
    assertTrue(value instanceof User);
    assertEquals("42", ((User) value).getUserId());
    assertFalse(getResult.iterator().hasNext());
    Stream<ImmutableNode> streamResult = getResult.stream();
    assertTrue(streamResult.limit(5).collect(Collectors.toList()).isEmpty());
    assertTrue(getResult.getChildren().isEmpty());
    assertEquals(GafferPopGraphVariables.USER_ID, getResult.getNodeName());
  }

  /**
   * Test {@link GafferPopGraph#GafferPopGraph(Configuration, Graph)}.
   *
   * <p>Method under test: {@link GafferPopGraph#GafferPopGraph(Configuration, Graph)}
   */
  @Test
  @DisplayName("Test new GafferPopGraph(Configuration, Graph)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void GafferPopGraph.<init>(Configuration, Graph)"})
  void testNewGafferPopGraph4() {
    // Arrange
    BaseConfiguration configuration = new BaseConfiguration();
    configuration.addProperty(GafferPopGraph.OP_OPTIONS, "Updating graph variable: {} to {}");

    // Act
    GafferPopGraph actualGafferPopGraph = new GafferPopGraph(configuration, null);

    // Assert
    GraphTraversalSource traversalResult = actualGafferPopGraph.traversal();
    TraversalStrategies strategies = traversalResult.getStrategies();
    assertTrue(strategies instanceof DefaultTraversalStrategies);
    Variables variablesResult = actualGafferPopGraph.variables();
    assertTrue(
        ((GafferPopGraphVariables) variablesResult).getLastOperationChain().getOutputTypeReference()
            instanceof Void);
    assertTrue(variablesResult instanceof GafferPopGraphVariables);
    Map<String, String> operationOptions =
        ((GafferPopGraphVariables) variablesResult).getOperationOptions();
    assertEquals(1, operationOptions.size());
    assertEquals(" {} to {}", operationOptions.get("Updating graph variable"));
    assertEquals(18, strategies.toList().size());
    assertSame(configuration, actualGafferPopGraph.configuration());
    assertSame(actualGafferPopGraph, traversalResult.getGraph());
  }

  /**
   * Test {@link GafferPopGraph#GafferPopGraph(Configuration, Graph)}.
   *
   * <ul>
   *   <li>Given {@link GafferPopGraph#DATA_AUTHS}.
   *   <li>Then return not configuration Keys hasNext.
   * </ul>
   *
   * <p>Method under test: {@link GafferPopGraph#GafferPopGraph(Configuration, Graph)}
   */
  @Test
  @DisplayName(
      "Test new GafferPopGraph(Configuration, Graph); given DATA_AUTHS; then return not configuration Keys hasNext")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void GafferPopGraph.<init>(Configuration, Graph)"})
  void testNewGafferPopGraph_givenData_auths_thenReturnNotConfigurationKeysHasNext() {
    // Arrange
    INIConfiguration configuration =
        INIConfiguration.builder().setSectionInLineCommentsAllowed(true).build();
    configuration.addProperty(GafferPopGraph.DATA_AUTHS, new Builder().userId("42").build());

    // Act
    GafferPopGraph actualGafferPopGraph = new GafferPopGraph(configuration, null);

    // Assert
    Configuration configurationResult = actualGafferPopGraph.configuration();
    assertTrue(configurationResult instanceof INIConfiguration);
    Iterator<String> keys = configurationResult.getKeys();
    String actualNextResult = keys.next();
    assertFalse(keys.hasNext());
    assertEquals(GafferPopGraph.DATA_AUTHS, actualNextResult);
    List<ImmutableNode> children =
        ((INIConfiguration) configurationResult)
            .getNodeModel()
            .getInMemoryRepresentation()
            .getChildren();
    assertEquals(1, children.size());
    List<ImmutableNode> children2 = children.get(0).getChildren();
    assertEquals(1, children2.size());
    assertEquals(GafferPopGraphVariables.DATA_AUTHS, children2.get(0).getNodeName());
    Variables variablesResult = actualGafferPopGraph.variables();
    assertTrue(variablesResult instanceof GafferPopGraphVariables);
    Set<String> dataAuths = ((GafferPopGraphVariables) variablesResult).getUser().getDataAuths();
    assertEquals(1, dataAuths.size());
    assertTrue(dataAuths.contains("User[userId=42,dataAuths=[],opAuths=[]]"));
  }

  /**
   * Test {@link GafferPopGraph#GafferPopGraph(Configuration, Graph)}.
   *
   * <ul>
   *   <li>When {@link BaseConfiguration} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link GafferPopGraph#GafferPopGraph(Configuration, Graph)}
   */
  @Test
  @DisplayName(
      "Test new GafferPopGraph(Configuration, Graph); when BaseConfiguration (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void GafferPopGraph.<init>(Configuration, Graph)"})
  void testNewGafferPopGraph_whenBaseConfiguration() {
    // Arrange
    BaseConfiguration configuration = new BaseConfiguration();

    // Act
    GafferPopGraph actualGafferPopGraph = new GafferPopGraph(configuration, null);

    // Assert
    GraphTraversalSource traversalResult = actualGafferPopGraph.traversal();
    TraversalStrategies strategies = traversalResult.getStrategies();
    assertTrue(strategies instanceof DefaultTraversalStrategies);
    Variables variablesResult = actualGafferPopGraph.variables();
    assertTrue(
        ((GafferPopGraphVariables) variablesResult).getLastOperationChain().getOutputTypeReference()
            instanceof Void);
    assertTrue(variablesResult instanceof GafferPopGraphVariables);
    assertEquals(18, strategies.toList().size());
    assertSame(configuration, actualGafferPopGraph.configuration());
    assertSame(actualGafferPopGraph, traversalResult.getGraph());
  }

  /**
   * Test {@link GafferPopGraph#GafferPopGraph(Configuration, Graph)}.
   *
   * <ul>
   *   <li>When {@link BaseConfiguration} (default constructor) addProperty {@link
   *       GafferPopGraph#OP_OPTIONS} and empty string.
   * </ul>
   *
   * <p>Method under test: {@link GafferPopGraph#GafferPopGraph(Configuration, Graph)}
   */
  @Test
  @DisplayName(
      "Test new GafferPopGraph(Configuration, Graph); when BaseConfiguration (default constructor) addProperty OP_OPTIONS and empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void GafferPopGraph.<init>(Configuration, Graph)"})
  void testNewGafferPopGraph_whenBaseConfigurationAddPropertyOp_optionsAndEmptyString() {
    // Arrange
    BaseConfiguration configuration = new BaseConfiguration();
    configuration.addProperty(GafferPopGraph.OP_OPTIONS, "");

    // Act
    GafferPopGraph actualGafferPopGraph = new GafferPopGraph(configuration, null);

    // Assert
    GraphTraversalSource traversalResult = actualGafferPopGraph.traversal();
    TraversalStrategies strategies = traversalResult.getStrategies();
    assertTrue(strategies instanceof DefaultTraversalStrategies);
    Variables variablesResult = actualGafferPopGraph.variables();
    assertTrue(
        ((GafferPopGraphVariables) variablesResult).getLastOperationChain().getOutputTypeReference()
            instanceof Void);
    assertTrue(variablesResult instanceof GafferPopGraphVariables);
    assertEquals(18, strategies.toList().size());
    assertSame(configuration, actualGafferPopGraph.configuration());
    assertSame(actualGafferPopGraph, traversalResult.getGraph());
  }

  /**
   * Test {@link GafferPopGraph#GafferPopGraph(Configuration, Graph)}.
   *
   * <ul>
   *   <li>When {@link BaseConfiguration} (default constructor) addProperty {@link
   *       GafferPopGraph#USER_ID} and empty string.
   * </ul>
   *
   * <p>Method under test: {@link GafferPopGraph#GafferPopGraph(Configuration, Graph)}
   */
  @Test
  @DisplayName(
      "Test new GafferPopGraph(Configuration, Graph); when BaseConfiguration (default constructor) addProperty USER_ID and empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void GafferPopGraph.<init>(Configuration, Graph)"})
  void testNewGafferPopGraph_whenBaseConfigurationAddPropertyUser_idAndEmptyString() {
    // Arrange
    BaseConfiguration configuration = new BaseConfiguration();
    configuration.addProperty(GafferPopGraph.USER_ID, "");

    // Act
    GafferPopGraph actualGafferPopGraph = new GafferPopGraph(configuration, null);

    // Assert
    GraphTraversalSource traversalResult = actualGafferPopGraph.traversal();
    TraversalStrategies strategies = traversalResult.getStrategies();
    assertTrue(strategies instanceof DefaultTraversalStrategies);
    Variables variablesResult = actualGafferPopGraph.variables();
    assertTrue(
        ((GafferPopGraphVariables) variablesResult).getLastOperationChain().getOutputTypeReference()
            instanceof Void);
    assertTrue(variablesResult instanceof GafferPopGraphVariables);
    assertEquals(18, strategies.toList().size());
    assertSame(configuration, actualGafferPopGraph.configuration());
    assertSame(actualGafferPopGraph, traversalResult.getGraph());
  }

  /**
   * Test {@link GafferPopGraph#GafferPopGraph(Configuration)}.
   *
   * <ul>
   *   <li>When {@link BaseConfiguration} (default constructor).
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link GafferPopGraph#GafferPopGraph(Configuration)}
   */
  @Test
  @DisplayName(
      "Test new GafferPopGraph(Configuration); when BaseConfiguration (default constructor); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void GafferPopGraph.<init>(Configuration)"})
  void testNewGafferPopGraph_whenBaseConfiguration_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> new GafferPopGraph(new BaseConfiguration()));
  }

  /**
   * Test {@link GafferPopGraph#GafferPopGraph(Configuration)}.
   *
   * <ul>
   *   <li>When builder SectionInLineCommentsAllowed is {@code true} build.
   * </ul>
   *
   * <p>Method under test: {@link GafferPopGraph#GafferPopGraph(Configuration)}
   */
  @Test
  @DisplayName(
      "Test new GafferPopGraph(Configuration); when builder SectionInLineCommentsAllowed is 'true' build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void GafferPopGraph.<init>(Configuration)"})
  void testNewGafferPopGraph_whenBuilderSectionInLineCommentsAllowedIsTrueBuild() {
    // Arrange
    INIConfiguration configuration =
        INIConfiguration.builder().setSectionInLineCommentsAllowed(true).build();

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> new GafferPopGraph(configuration));
  }

  /**
   * Test {@link GafferPopGraph#GafferPopGraph(Configuration)}.
   *
   * <ul>
   *   <li>When {@link CompositeConfiguration#CompositeConfiguration()}.
   * </ul>
   *
   * <p>Method under test: {@link GafferPopGraph#GafferPopGraph(Configuration)}
   */
  @Test
  @DisplayName("Test new GafferPopGraph(Configuration); when CompositeConfiguration()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void GafferPopGraph.<init>(Configuration)"})
  void testNewGafferPopGraph_whenCompositeConfiguration() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> new GafferPopGraph(new CompositeConfiguration()));
  }

  /**
   * Test {@link GafferPopGraph#GafferPopGraph(Configuration, Graph)}.
   *
   * <ul>
   *   <li>When {@link CompositeConfiguration#CompositeConfiguration()}.
   * </ul>
   *
   * <p>Method under test: {@link GafferPopGraph#GafferPopGraph(Configuration, Graph)}
   */
  @Test
  @DisplayName("Test new GafferPopGraph(Configuration, Graph); when CompositeConfiguration()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void GafferPopGraph.<init>(Configuration, Graph)"})
  void testNewGafferPopGraph_whenCompositeConfiguration2() {
    // Arrange
    CompositeConfiguration configuration = new CompositeConfiguration();

    // Act
    GafferPopGraph actualGafferPopGraph = new GafferPopGraph(configuration, null);

    // Assert
    assertSame(configuration, actualGafferPopGraph.configuration());
    assertSame(actualGafferPopGraph, actualGafferPopGraph.traversal().getGraph());
  }

  /**
   * Test {@link GafferPopGraph#GafferPopGraph(Configuration, Graph)}.
   *
   * <ul>
   *   <li>When {@link CompositeConfiguration#CompositeConfiguration()} addProperty {@link
   *       GafferPopGraph#USER_ID} and empty string.
   * </ul>
   *
   * <p>Method under test: {@link GafferPopGraph#GafferPopGraph(Configuration, Graph)}
   */
  @Test
  @DisplayName(
      "Test new GafferPopGraph(Configuration, Graph); when CompositeConfiguration() addProperty USER_ID and empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void GafferPopGraph.<init>(Configuration, Graph)"})
  void testNewGafferPopGraph_whenCompositeConfigurationAddPropertyUser_idAndEmptyString() {
    // Arrange
    CompositeConfiguration configuration = new CompositeConfiguration();
    configuration.addProperty(GafferPopGraph.USER_ID, "");

    // Act
    GafferPopGraph actualGafferPopGraph = new GafferPopGraph(configuration, null);

    // Assert
    assertSame(configuration, actualGafferPopGraph.configuration());
    assertSame(actualGafferPopGraph, actualGafferPopGraph.traversal().getGraph());
  }

  /**
   * Test {@link GafferPopGraph#GafferPopGraph(Configuration)}.
   *
   * <ul>
   *   <li>When {@link EnvironmentConfiguration} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link GafferPopGraph#GafferPopGraph(Configuration)}
   */
  @Test
  @DisplayName(
      "Test new GafferPopGraph(Configuration); when EnvironmentConfiguration (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void GafferPopGraph.<init>(Configuration)"})
  void testNewGafferPopGraph_whenEnvironmentConfiguration() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> new GafferPopGraph(new EnvironmentConfiguration()));
  }

  /**
   * Test {@link GafferPopGraph#open(Configuration, Graph)} with {@code configuration}, {@code
   * graph}.
   *
   * <p>Method under test: {@link GafferPopGraph#open(Configuration, Graph)}
   */
  @Test
  @DisplayName("Test open(Configuration, Graph) with 'configuration', 'graph'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"GafferPopGraph GafferPopGraph.open(Configuration, Graph)"})
  void testOpenWithConfigurationGraph() {
    // Arrange
    INIConfiguration configuration =
        INIConfiguration.builder().setSectionInLineCommentsAllowed(true).build();

    // Act and Assert
    Configuration configurationResult = GafferPopGraph.open(configuration, null).configuration();
    assertTrue(configurationResult instanceof INIConfiguration);
    ImmutableNode inMemoryRepresentation =
        ((INIConfiguration) configurationResult).getNodeModel().getInMemoryRepresentation();
    assertFalse(inMemoryRepresentation.iterator().hasNext());
    Stream<ImmutableNode> streamResult = inMemoryRepresentation.stream();
    assertTrue(streamResult.limit(5).collect(Collectors.toList()).isEmpty());
    assertTrue(inMemoryRepresentation.getChildren().isEmpty());
    assertTrue(((INIConfiguration) configurationResult).getSections().isEmpty());
  }

  /**
   * Test {@link GafferPopGraph#open(Configuration, Graph)} with {@code configuration}, {@code
   * graph}.
   *
   * <p>Method under test: {@link GafferPopGraph#open(Configuration, Graph)}
   */
  @Test
  @DisplayName("Test open(Configuration, Graph) with 'configuration', 'graph'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"GafferPopGraph GafferPopGraph.open(Configuration, Graph)"})
  void testOpenWithConfigurationGraph2() {
    // Arrange
    BaseConfiguration configuration = new BaseConfiguration();
    configuration.addProperty(GafferPopGraph.OP_OPTIONS, "");

    // Act
    GafferPopGraph actualOpenResult = GafferPopGraph.open(configuration, null);

    // Assert
    GraphTraversalSource traversalResult = actualOpenResult.traversal();
    TraversalStrategies strategies = traversalResult.getStrategies();
    assertTrue(strategies instanceof DefaultTraversalStrategies);
    Variables variablesResult = actualOpenResult.variables();
    assertTrue(
        ((GafferPopGraphVariables) variablesResult).getLastOperationChain().getOutputTypeReference()
            instanceof Void);
    assertTrue(variablesResult instanceof GafferPopGraphVariables);
    assertEquals(18, strategies.toList().size());
    assertSame(configuration, actualOpenResult.configuration());
    assertSame(actualOpenResult, traversalResult.getGraph());
  }

  /**
   * Test {@link GafferPopGraph#open(Configuration, Graph)} with {@code configuration}, {@code
   * graph}.
   *
   * <p>Method under test: {@link GafferPopGraph#open(Configuration, Graph)}
   */
  @Test
  @DisplayName("Test open(Configuration, Graph) with 'configuration', 'graph'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"GafferPopGraph GafferPopGraph.open(Configuration, Graph)"})
  void testOpenWithConfigurationGraph3() {
    // Arrange
    BaseConfiguration configuration = new BaseConfiguration();
    configuration.addProperty(GafferPopGraph.USER_ID, "");

    // Act
    GafferPopGraph actualOpenResult = GafferPopGraph.open(configuration, null);

    // Assert
    GraphTraversalSource traversalResult = actualOpenResult.traversal();
    TraversalStrategies strategies = traversalResult.getStrategies();
    assertTrue(strategies instanceof DefaultTraversalStrategies);
    Variables variablesResult = actualOpenResult.variables();
    assertTrue(
        ((GafferPopGraphVariables) variablesResult).getLastOperationChain().getOutputTypeReference()
            instanceof Void);
    assertTrue(variablesResult instanceof GafferPopGraphVariables);
    assertEquals(18, strategies.toList().size());
    assertSame(configuration, actualOpenResult.configuration());
    assertSame(actualOpenResult, traversalResult.getGraph());
  }

  /**
   * Test {@link GafferPopGraph#open(Configuration, Graph)} with {@code configuration}, {@code
   * graph}.
   *
   * <p>Method under test: {@link GafferPopGraph#open(Configuration, Graph)}
   */
  @Test
  @DisplayName("Test open(Configuration, Graph) with 'configuration', 'graph'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"GafferPopGraph GafferPopGraph.open(Configuration, Graph)"})
  void testOpenWithConfigurationGraph4() {
    // Arrange
    CompositeConfiguration configuration = new CompositeConfiguration();
    configuration.addProperty(GafferPopGraph.USER_ID, "");

    // Act
    GafferPopGraph actualOpenResult = GafferPopGraph.open(configuration, null);

    // Assert
    assertSame(configuration, actualOpenResult.configuration());
    assertSame(actualOpenResult, actualOpenResult.traversal().getGraph());
  }

  /**
   * Test {@link GafferPopGraph#open(Configuration, Graph)} with {@code configuration}, {@code
   * graph}.
   *
   * <p>Method under test: {@link GafferPopGraph#open(Configuration, Graph)}
   */
  @Test
  @DisplayName("Test open(Configuration, Graph) with 'configuration', 'graph'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"GafferPopGraph GafferPopGraph.open(Configuration, Graph)"})
  void testOpenWithConfigurationGraph5() {
    // Arrange
    BaseConfiguration configuration = new BaseConfiguration();
    configuration.addProperty(GafferPopGraph.USER_ID, new Builder().userId("42").build());

    // Act
    GafferPopGraph actualOpenResult = GafferPopGraph.open(configuration, null);

    // Assert
    GraphTraversalSource traversalResult = actualOpenResult.traversal();
    TraversalStrategies strategies = traversalResult.getStrategies();
    assertTrue(strategies instanceof DefaultTraversalStrategies);
    Variables variablesResult = actualOpenResult.variables();
    assertTrue(
        ((GafferPopGraphVariables) variablesResult).getLastOperationChain().getOutputTypeReference()
            instanceof Void);
    assertTrue(variablesResult instanceof GafferPopGraphVariables);
    assertEquals(
        "User[userId=42,dataAuths=[],opAuths=[]]",
        ((GafferPopGraphVariables) variablesResult).getUser().getUserId());
    assertEquals(18, strategies.toList().size());
    assertSame(configuration, actualOpenResult.configuration());
    assertSame(actualOpenResult, traversalResult.getGraph());
  }

  /**
   * Test {@link GafferPopGraph#open(Configuration, Graph)} with {@code configuration}, {@code
   * graph}.
   *
   * <p>Method under test: {@link GafferPopGraph#open(Configuration, Graph)}
   */
  @Test
  @DisplayName("Test open(Configuration, Graph) with 'configuration', 'graph'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"GafferPopGraph GafferPopGraph.open(Configuration, Graph)"})
  void testOpenWithConfigurationGraph6() {
    // Arrange
    INIConfiguration configuration =
        INIConfiguration.builder().setSectionInLineCommentsAllowed(true).build();
    configuration.addProperty(GafferPopGraph.USER_ID, new Builder().userId("42").build());

    // Act and Assert
    Configuration configurationResult = GafferPopGraph.open(configuration, null).configuration();
    assertTrue(configurationResult instanceof INIConfiguration);
    List<ImmutableNode> children =
        ((INIConfiguration) configurationResult)
            .getNodeModel()
            .getInMemoryRepresentation()
            .getChildren();
    assertEquals(1, children.size());
    List<ImmutableNode> children2 = children.get(0).getChildren();
    assertEquals(1, children2.size());
    ImmutableNode getResult = children2.get(0);
    Object value = getResult.getValue();
    assertTrue(value instanceof User);
    assertEquals("42", ((User) value).getUserId());
    assertFalse(getResult.iterator().hasNext());
    Stream<ImmutableNode> streamResult = getResult.stream();
    assertTrue(streamResult.limit(5).collect(Collectors.toList()).isEmpty());
    assertTrue(getResult.getChildren().isEmpty());
    assertEquals(GafferPopGraphVariables.USER_ID, getResult.getNodeName());
  }

  /**
   * Test {@link GafferPopGraph#open(Configuration, Graph)} with {@code configuration}, {@code
   * graph}.
   *
   * <p>Method under test: {@link GafferPopGraph#open(Configuration, Graph)}
   */
  @Test
  @DisplayName("Test open(Configuration, Graph) with 'configuration', 'graph'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"GafferPopGraph GafferPopGraph.open(Configuration, Graph)"})
  void testOpenWithConfigurationGraph7() {
    // Arrange
    BaseConfiguration configuration = new BaseConfiguration();
    configuration.addProperty(GafferPopGraph.OP_OPTIONS, "Updating graph variable: {} to {}");

    // Act
    GafferPopGraph actualOpenResult = GafferPopGraph.open(configuration, null);

    // Assert
    GraphTraversalSource traversalResult = actualOpenResult.traversal();
    TraversalStrategies strategies = traversalResult.getStrategies();
    assertTrue(strategies instanceof DefaultTraversalStrategies);
    Variables variablesResult = actualOpenResult.variables();
    assertTrue(
        ((GafferPopGraphVariables) variablesResult).getLastOperationChain().getOutputTypeReference()
            instanceof Void);
    assertTrue(variablesResult instanceof GafferPopGraphVariables);
    Map<String, String> operationOptions =
        ((GafferPopGraphVariables) variablesResult).getOperationOptions();
    assertEquals(1, operationOptions.size());
    assertEquals(" {} to {}", operationOptions.get("Updating graph variable"));
    assertEquals(18, strategies.toList().size());
    assertSame(configuration, actualOpenResult.configuration());
    assertSame(actualOpenResult, traversalResult.getGraph());
  }

  /**
   * Test {@link GafferPopGraph#open(Configuration, Graph)} with {@code configuration}, {@code
   * graph}.
   *
   * <ul>
   *   <li>Then return configuration is {@link EnvironmentConfiguration} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link GafferPopGraph#open(Configuration, Graph)}
   */
  @Test
  @DisplayName(
      "Test open(Configuration, Graph) with 'configuration', 'graph'; then return configuration is EnvironmentConfiguration (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"GafferPopGraph GafferPopGraph.open(Configuration, Graph)"})
  void testOpenWithConfigurationGraph_thenReturnConfigurationIsEnvironmentConfiguration() {
    // Arrange
    EnvironmentConfiguration configuration = new EnvironmentConfiguration();

    // Act
    GafferPopGraph actualOpenResult = GafferPopGraph.open(configuration, null);

    // Assert
    assertSame(configuration, actualOpenResult.configuration());
    assertSame(actualOpenResult, actualOpenResult.traversal().getGraph());
  }

  /**
   * Test {@link GafferPopGraph#open(Configuration, Graph)} with {@code configuration}, {@code
   * graph}.
   *
   * <ul>
   *   <li>Then return not configuration Keys hasNext.
   * </ul>
   *
   * <p>Method under test: {@link GafferPopGraph#open(Configuration, Graph)}
   */
  @Test
  @DisplayName(
      "Test open(Configuration, Graph) with 'configuration', 'graph'; then return not configuration Keys hasNext")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"GafferPopGraph GafferPopGraph.open(Configuration, Graph)"})
  void testOpenWithConfigurationGraph_thenReturnNotConfigurationKeysHasNext() {
    // Arrange
    INIConfiguration configuration =
        INIConfiguration.builder().setSectionInLineCommentsAllowed(true).build();
    configuration.addProperty(GafferPopGraph.DATA_AUTHS, new Builder().userId("42").build());

    // Act
    GafferPopGraph actualOpenResult = GafferPopGraph.open(configuration, null);

    // Assert
    Configuration configurationResult = actualOpenResult.configuration();
    assertTrue(configurationResult instanceof INIConfiguration);
    Iterator<String> keys = configurationResult.getKeys();
    String actualNextResult = keys.next();
    assertFalse(keys.hasNext());
    assertEquals(GafferPopGraph.DATA_AUTHS, actualNextResult);
    List<ImmutableNode> children =
        ((INIConfiguration) configurationResult)
            .getNodeModel()
            .getInMemoryRepresentation()
            .getChildren();
    assertEquals(1, children.size());
    List<ImmutableNode> children2 = children.get(0).getChildren();
    assertEquals(1, children2.size());
    assertEquals(GafferPopGraphVariables.DATA_AUTHS, children2.get(0).getNodeName());
    Variables variablesResult = actualOpenResult.variables();
    assertTrue(variablesResult instanceof GafferPopGraphVariables);
    Set<String> dataAuths = ((GafferPopGraphVariables) variablesResult).getUser().getDataAuths();
    assertEquals(1, dataAuths.size());
    assertTrue(dataAuths.contains("User[userId=42,dataAuths=[],opAuths=[]]"));
  }

  /**
   * Test {@link GafferPopGraph#open(Configuration, Graph)} with {@code configuration}, {@code
   * graph}.
   *
   * <ul>
   *   <li>When {@link BaseConfiguration} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link GafferPopGraph#open(Configuration, Graph)}
   */
  @Test
  @DisplayName(
      "Test open(Configuration, Graph) with 'configuration', 'graph'; when BaseConfiguration (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"GafferPopGraph GafferPopGraph.open(Configuration, Graph)"})
  void testOpenWithConfigurationGraph_whenBaseConfiguration() {
    // Arrange
    BaseConfiguration configuration = new BaseConfiguration();

    // Act
    GafferPopGraph actualOpenResult = GafferPopGraph.open(configuration, null);

    // Assert
    GraphTraversalSource traversalResult = actualOpenResult.traversal();
    TraversalStrategies strategies = traversalResult.getStrategies();
    assertTrue(strategies instanceof DefaultTraversalStrategies);
    Variables variablesResult = actualOpenResult.variables();
    assertTrue(
        ((GafferPopGraphVariables) variablesResult).getLastOperationChain().getOutputTypeReference()
            instanceof Void);
    assertTrue(variablesResult instanceof GafferPopGraphVariables);
    assertEquals(18, strategies.toList().size());
    assertSame(configuration, actualOpenResult.configuration());
    assertSame(actualOpenResult, traversalResult.getGraph());
  }

  /**
   * Test {@link GafferPopGraph#open(Configuration, Graph)} with {@code configuration}, {@code
   * graph}.
   *
   * <ul>
   *   <li>When {@link CompositeConfiguration#CompositeConfiguration()}.
   * </ul>
   *
   * <p>Method under test: {@link GafferPopGraph#open(Configuration, Graph)}
   */
  @Test
  @DisplayName(
      "Test open(Configuration, Graph) with 'configuration', 'graph'; when CompositeConfiguration()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"GafferPopGraph GafferPopGraph.open(Configuration, Graph)"})
  void testOpenWithConfigurationGraph_whenCompositeConfiguration() {
    // Arrange
    CompositeConfiguration configuration = new CompositeConfiguration();

    // Act
    GafferPopGraph actualOpenResult = GafferPopGraph.open(configuration, null);

    // Assert
    assertSame(configuration, actualOpenResult.configuration());
    assertSame(actualOpenResult, actualOpenResult.traversal().getGraph());
  }

  /**
   * Test {@link GafferPopGraph#open(Configuration)} with {@code configuration}.
   *
   * <ul>
   *   <li>When {@link BaseConfiguration} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link GafferPopGraph#open(Configuration)}
   */
  @Test
  @DisplayName(
      "Test open(Configuration) with 'configuration'; when BaseConfiguration (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"GafferPopGraph GafferPopGraph.open(Configuration)"})
  void testOpenWithConfiguration_whenBaseConfiguration() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> GafferPopGraph.open(new BaseConfiguration()));
  }

  /**
   * Test {@link GafferPopGraph#open(Configuration)} with {@code configuration}.
   *
   * <ul>
   *   <li>When builder SectionInLineCommentsAllowed is {@code true} build.
   * </ul>
   *
   * <p>Method under test: {@link GafferPopGraph#open(Configuration)}
   */
  @Test
  @DisplayName(
      "Test open(Configuration) with 'configuration'; when builder SectionInLineCommentsAllowed is 'true' build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"GafferPopGraph GafferPopGraph.open(Configuration)"})
  void testOpenWithConfiguration_whenBuilderSectionInLineCommentsAllowedIsTrueBuild() {
    // Arrange
    INIConfiguration configuration =
        INIConfiguration.builder().setSectionInLineCommentsAllowed(true).build();

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> GafferPopGraph.open(configuration));
  }

  /**
   * Test {@link GafferPopGraph#open(Configuration)} with {@code configuration}.
   *
   * <ul>
   *   <li>When {@link CompositeConfiguration#CompositeConfiguration()}.
   * </ul>
   *
   * <p>Method under test: {@link GafferPopGraph#open(Configuration)}
   */
  @Test
  @DisplayName("Test open(Configuration) with 'configuration'; when CompositeConfiguration()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"GafferPopGraph GafferPopGraph.open(Configuration)"})
  void testOpenWithConfiguration_whenCompositeConfiguration() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> GafferPopGraph.open(new CompositeConfiguration()));
  }

  /**
   * Test {@link GafferPopGraph#open(Configuration)} with {@code configuration}.
   *
   * <ul>
   *   <li>When {@link EnvironmentConfiguration} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link GafferPopGraph#open(Configuration)}
   */
  @Test
  @DisplayName(
      "Test open(Configuration) with 'configuration'; when EnvironmentConfiguration (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"GafferPopGraph GafferPopGraph.open(Configuration)"})
  void testOpenWithConfiguration_whenEnvironmentConfiguration() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> GafferPopGraph.open(new EnvironmentConfiguration()));
  }
}
