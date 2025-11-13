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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.apache.commons.configuration2.BaseConfiguration;
import org.apache.commons.configuration2.BaseHierarchicalConfiguration;
import org.apache.commons.configuration2.Configuration;
import org.apache.commons.configuration2.EnvironmentConfiguration;
import org.apache.commons.configuration2.convert.DefaultConversionHandler;
import org.apache.tinkerpop.gremlin.process.traversal.TraversalStrategies;
import org.apache.tinkerpop.gremlin.process.traversal.dsl.graph.GraphTraversalSource;
import org.apache.tinkerpop.gremlin.process.traversal.util.DefaultTraversalStrategies;
import org.apache.tinkerpop.gremlin.structure.Graph.Variables;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import uk.gov.gchq.gaffer.graph.Graph;
import uk.gov.gchq.gaffer.operation.serialisation.TypeReferenceImpl;
import uk.gov.gchq.gaffer.operation.serialisation.TypeReferenceImpl.Void;
import uk.gov.gchq.gaffer.user.User;

public class GafferPopGraphDiffblueTest {
  /**
   * Test {@link GafferPopGraph#GafferPopGraph(Configuration, Graph)}.
   * <ul>
   *   <li>Then return configuration is {@link BaseConfiguration} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link GafferPopGraph#GafferPopGraph(Configuration, Graph)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void GafferPopGraph.<init>(Configuration, Graph)"})
  public void testNewGafferPopGraph_thenReturnConfigurationIsBaseConfiguration() {
    // Arrange
    BaseConfiguration configuration = new BaseConfiguration();
    configuration.addProperty(GafferPopGraph.OP_OPTIONS, "");

    // Act
    GafferPopGraph actualGafferPopGraph = new GafferPopGraph(configuration, null);

    // Assert
    assertTrue(actualGafferPopGraph.variables() instanceof GafferPopGraphVariables);
    assertSame(configuration, actualGafferPopGraph.configuration());
    assertSame(actualGafferPopGraph, actualGafferPopGraph.traversal().getGraph());
  }

  /**
   * Test {@link GafferPopGraph#GafferPopGraph(Configuration, Graph)}.
   * <ul>
   *   <li>Then return configuration is {@link BaseHierarchicalConfiguration#BaseHierarchicalConfiguration()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GafferPopGraph#GafferPopGraph(Configuration, Graph)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void GafferPopGraph.<init>(Configuration, Graph)"})
  public void testNewGafferPopGraph_thenReturnConfigurationIsBaseHierarchicalConfiguration() {
    // Arrange
    BaseHierarchicalConfiguration configuration = new BaseHierarchicalConfiguration();

    // Act
    GafferPopGraph actualGafferPopGraph = new GafferPopGraph(configuration, null);

    // Assert
    assertTrue(actualGafferPopGraph.variables() instanceof GafferPopGraphVariables);
    assertSame(configuration, actualGafferPopGraph.configuration());
    assertSame(actualGafferPopGraph, actualGafferPopGraph.traversal().getGraph());
  }

  /**
   * Test {@link GafferPopGraph#GafferPopGraph(Configuration, Graph)}.
   * <ul>
   *   <li>Then return configuration is {@link EnvironmentConfiguration} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link GafferPopGraph#GafferPopGraph(Configuration, Graph)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void GafferPopGraph.<init>(Configuration, Graph)"})
  public void testNewGafferPopGraph_thenReturnConfigurationIsEnvironmentConfiguration() {
    // Arrange
    EnvironmentConfiguration configuration = new EnvironmentConfiguration();

    // Act
    GafferPopGraph actualGafferPopGraph = new GafferPopGraph(configuration, null);

    // Assert
    assertSame(configuration, actualGafferPopGraph.configuration());
    assertSame(actualGafferPopGraph, actualGafferPopGraph.traversal().getGraph());
  }

  /**
   * Test {@link GafferPopGraph#GafferPopGraph(Configuration, Graph)}.
   * <ul>
   *   <li>When {@link BaseConfiguration} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link GafferPopGraph#GafferPopGraph(Configuration, Graph)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void GafferPopGraph.<init>(Configuration, Graph)"})
  public void testNewGafferPopGraph_whenBaseConfiguration() {
    // Arrange
    BaseConfiguration configuration = new BaseConfiguration();

    // Act
    GafferPopGraph actualGafferPopGraph = new GafferPopGraph(configuration, null);

    // Assert
    assertTrue(actualGafferPopGraph.variables() instanceof GafferPopGraphVariables);
    assertSame(configuration, actualGafferPopGraph.configuration());
    assertSame(actualGafferPopGraph, actualGafferPopGraph.traversal().getGraph());
  }

  /**
   * Test {@link GafferPopGraph#GafferPopGraph(Configuration)}.
   * <ul>
   *   <li>When {@link BaseConfiguration} (default constructor).</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GafferPopGraph#GafferPopGraph(Configuration)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void GafferPopGraph.<init>(Configuration)"})
  public void testNewGafferPopGraph_whenBaseConfiguration_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> new GafferPopGraph(new BaseConfiguration()));
  }

  /**
   * Test {@link GafferPopGraph#GafferPopGraph(Configuration)}.
   * <ul>
   *   <li>When {@link EnvironmentConfiguration} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link GafferPopGraph#GafferPopGraph(Configuration)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void GafferPopGraph.<init>(Configuration)"})
  public void testNewGafferPopGraph_whenEnvironmentConfiguration() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> new GafferPopGraph(new EnvironmentConfiguration()));
  }

  /**
   * Test {@link GafferPopGraph#open(Configuration, Graph)} with {@code configuration}, {@code graph}.
   * <p>
   * Method under test: {@link GafferPopGraph#open(Configuration, Graph)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"GafferPopGraph GafferPopGraph.open(Configuration, Graph)"})
  public void testOpenWithConfigurationGraph() {
    // Arrange and Act
    GafferPopGraph actualOpenResult = GafferPopGraph.open(new BaseConfiguration(), null);

    // Assert
    Configuration configurationResult = actualOpenResult.configuration();
    assertTrue(configurationResult instanceof BaseConfiguration);
    assertTrue(((BaseConfiguration) configurationResult).getConversionHandler() instanceof DefaultConversionHandler);
    TraversalStrategies strategies = actualOpenResult.traversal().getStrategies();
    assertTrue(strategies instanceof DefaultTraversalStrategies);
    Variables variablesResult = actualOpenResult.variables();
    assertTrue(
        ((GafferPopGraphVariables) variablesResult).getLastOperationChain().getOutputTypeReference() instanceof Void);
    assertTrue(variablesResult instanceof GafferPopGraphVariables);
    User user = ((GafferPopGraphVariables) variablesResult).getUser();
    assertEquals("UNKNOWN", user.getUserId());
    assertEquals(0, configurationResult.size());
    assertEquals(1, configurationResult.getInterpolator().getDefaultLookups().size());
    assertEquals(18, strategies.toList().size());
    assertFalse(configurationResult.getKeys().hasNext());
    assertTrue(user.getDataAuths().isEmpty());
  }

  /**
   * Test {@link GafferPopGraph#open(Configuration, Graph)} with {@code configuration}, {@code graph}.
   * <p>
   * Method under test: {@link GafferPopGraph#open(Configuration, Graph)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"GafferPopGraph GafferPopGraph.open(Configuration, Graph)"})
  public void testOpenWithConfigurationGraph2() {
    // Arrange
    BaseConfiguration configuration = new BaseConfiguration();
    configuration.addProperty(GafferPopGraph.OP_OPTIONS, "");

    // Act
    GafferPopGraph actualOpenResult = GafferPopGraph.open(configuration, null);

    // Assert
    Configuration configurationResult = actualOpenResult.configuration();
    assertTrue(configurationResult instanceof BaseConfiguration);
    assertTrue(((BaseConfiguration) configurationResult).getConversionHandler() instanceof DefaultConversionHandler);
    GraphTraversalSource traversalResult = actualOpenResult.traversal();
    assertTrue(traversalResult.getStrategies() instanceof DefaultTraversalStrategies);
    Variables variablesResult = actualOpenResult.variables();
    assertTrue(variablesResult instanceof GafferPopGraphVariables);
    assertTrue(((GafferPopGraphVariables) variablesResult).getOperationOptions().isEmpty());
    assertSame(configuration, configurationResult);
    assertSame(actualOpenResult, traversalResult.getGraph());
  }

  /**
   * Test {@link GafferPopGraph#open(Configuration, Graph)} with {@code configuration}, {@code graph}.
   * <p>
   * Method under test: {@link GafferPopGraph#open(Configuration, Graph)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"GafferPopGraph GafferPopGraph.open(Configuration, Graph)"})
  public void testOpenWithConfigurationGraph3() {
    // Arrange
    BaseConfiguration configuration = new BaseConfiguration();
    configuration.addProperty(GafferPopGraph.USER_ID, "");

    // Act
    GafferPopGraph actualOpenResult = GafferPopGraph.open(configuration, null);

    // Assert
    Configuration configurationResult = actualOpenResult.configuration();
    assertTrue(configurationResult instanceof BaseConfiguration);
    assertTrue(((BaseConfiguration) configurationResult).getConversionHandler() instanceof DefaultConversionHandler);
    GraphTraversalSource traversalResult = actualOpenResult.traversal();
    assertTrue(traversalResult.getStrategies() instanceof DefaultTraversalStrategies);
    Variables variablesResult = actualOpenResult.variables();
    assertTrue(variablesResult instanceof GafferPopGraphVariables);
    assertTrue(((GafferPopGraphVariables) variablesResult).getOperationOptions().isEmpty());
    assertSame(configuration, configurationResult);
    assertSame(actualOpenResult, traversalResult.getGraph());
  }

  /**
   * Test {@link GafferPopGraph#open(Configuration, Graph)} with {@code configuration}, {@code graph}.
   * <ul>
   *   <li>Then return configuration is {@link EnvironmentConfiguration} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link GafferPopGraph#open(Configuration, Graph)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"GafferPopGraph GafferPopGraph.open(Configuration, Graph)"})
  public void testOpenWithConfigurationGraph_thenReturnConfigurationIsEnvironmentConfiguration() {
    // Arrange
    EnvironmentConfiguration configuration = new EnvironmentConfiguration();

    // Act
    GafferPopGraph actualOpenResult = GafferPopGraph.open(configuration, null);

    // Assert
    assertSame(configuration, actualOpenResult.configuration());
    assertSame(actualOpenResult, actualOpenResult.traversal().getGraph());
  }

  /**
   * Test {@link GafferPopGraph#open(Configuration)} with {@code configuration}.
   * <ul>
   *   <li>When {@link BaseConfiguration} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link GafferPopGraph#open(Configuration)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"GafferPopGraph GafferPopGraph.open(Configuration)"})
  public void testOpenWithConfiguration_whenBaseConfiguration() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> GafferPopGraph.open(new BaseConfiguration()));
  }

  /**
   * Test {@link GafferPopGraph#open(Configuration)} with {@code configuration}.
   * <ul>
   *   <li>When {@link EnvironmentConfiguration} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link GafferPopGraph#open(Configuration)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"GafferPopGraph GafferPopGraph.open(Configuration)"})
  public void testOpenWithConfiguration_whenEnvironmentConfiguration() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> GafferPopGraph.open(new EnvironmentConfiguration()));
  }
}
