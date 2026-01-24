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

package uk.gov.gchq.gaffer.tinkerpop.process.traversal.strategy.optimisation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import org.apache.commons.configuration2.BaseConfiguration;
import org.apache.commons.configuration2.Configuration;
import org.apache.commons.configuration2.convert.DefaultConversionHandler;
import org.apache.commons.configuration2.convert.DisabledListDelimiterHandler;
import org.apache.commons.configuration2.sync.NoOpSynchronizer;
import org.apache.commons.configuration2.sync.Synchronizer;
import org.apache.tinkerpop.gremlin.groovy.jsr223.dsl.credential.DefaultCredentialTraversal;
import org.apache.tinkerpop.gremlin.process.computer.traversal.lambda.HaltedTraversersCountTraversal;
import org.apache.tinkerpop.gremlin.process.computer.traversal.step.map.ComputerResultStep;
import org.apache.tinkerpop.gremlin.process.traversal.Step;
import org.apache.tinkerpop.gremlin.process.traversal.Traversal.Admin;
import org.apache.tinkerpop.gremlin.process.traversal.TraversalStrategy;
import org.apache.tinkerpop.gremlin.process.traversal.TraversalStrategy.ProviderOptimizationStrategy;
import org.apache.tinkerpop.gremlin.process.traversal.dsl.graph.DefaultGraphTraversal;
import org.apache.tinkerpop.gremlin.process.traversal.util.EmptyTraversalStrategies;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class GafferPopGraphStepStrategyDiffblueTest {
  /**
   * Test {@link GafferPopGraphStepStrategy#apply(Admin)}.
   *
   * <p>Method under test: {@link GafferPopGraphStepStrategy#apply(Admin)}
   */
  @Test
  @DisplayName("Test apply(Admin)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void GafferPopGraphStepStrategy.apply(Admin)"})
  void testApply() {
    // Arrange
    GafferPopGraphStepStrategy instanceResult = GafferPopGraphStepStrategy.instance();

    ArrayList<Step> stepList = new ArrayList<>();
    stepList.add(new ComputerResultStep(new DefaultCredentialTraversal()));

    DefaultGraphTraversal<?, ?> traversal = mock(DefaultGraphTraversal.class);
    when(traversal.getSteps()).thenReturn(stepList);
    when(traversal.getStrategies()).thenReturn(EmptyTraversalStrategies.instance());

    // Act
    instanceResult.apply(traversal);

    // Assert
    verify(traversal).getSteps();
    verify(traversal).getStrategies();
  }

  /**
   * Test {@link GafferPopGraphStepStrategy#apply(Admin)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.
   *   <li>Then calls {@link DefaultGraphTraversal#getSteps()}.
   * </ul>
   *
   * <p>Method under test: {@link GafferPopGraphStepStrategy#apply(Admin)}
   */
  @Test
  @DisplayName("Test apply(Admin); given ArrayList(); then calls getSteps()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void GafferPopGraphStepStrategy.apply(Admin)"})
  void testApply_givenArrayList_thenCallsGetSteps() {
    // Arrange
    GafferPopGraphStepStrategy instanceResult = GafferPopGraphStepStrategy.instance();

    DefaultGraphTraversal<?, ?> traversal = mock(DefaultGraphTraversal.class);
    when(traversal.getSteps()).thenReturn(new ArrayList<>());
    when(traversal.getStrategies()).thenReturn(EmptyTraversalStrategies.instance());

    // Act
    instanceResult.apply(traversal);

    // Assert
    verify(traversal).getSteps();
    verify(traversal).getStrategies();
  }

  /**
   * Test {@link GafferPopGraphStepStrategy#instance()}.
   *
   * <ul>
   *   <li>Then Configuration return {@link BaseConfiguration}.
   * </ul>
   *
   * <p>Method under test: {@link GafferPopGraphStepStrategy#instance()}
   */
  @Test
  @DisplayName("Test instance(); then Configuration return BaseConfiguration")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"GafferPopGraphStepStrategy GafferPopGraphStepStrategy.instance()"})
  void testInstance_thenConfigurationReturnBaseConfiguration() {
    // Arrange and Act
    GafferPopGraphStepStrategy actualInstanceResult = GafferPopGraphStepStrategy.instance();
    actualInstanceResult.apply(new DefaultCredentialTraversal<>());

    // Assert
    Configuration configuration = actualInstanceResult.getConfiguration();
    assertTrue(configuration instanceof BaseConfiguration);
    assertTrue(
        ((BaseConfiguration) configuration).getConversionHandler()
            instanceof DefaultConversionHandler);
    assertTrue(
        ((BaseConfiguration) configuration).getListDelimiterHandler()
            instanceof DisabledListDelimiterHandler);
    Synchronizer synchronizer = configuration.getSynchronizer();
    assertTrue(synchronizer instanceof NoOpSynchronizer);
    assertNull(((BaseConfiguration) configuration).getConfigurationDecoder());
    assertEquals(0, configuration.size());
    assertEquals(NoOpSynchronizer.INSTANCE, synchronizer);
    assertFalse(configuration.getKeys().hasNext());
    assertFalse(((BaseConfiguration) configuration).isThrowExceptionOnMissing());
    assertTrue(((BaseConfiguration) configuration).getEventListenerRegistrations().isEmpty());
    Class<ProviderOptimizationStrategy> expectedTraversalCategory =
        ProviderOptimizationStrategy.class;
    assertEquals(expectedTraversalCategory, actualInstanceResult.getTraversalCategory());
  }

  /**
   * Test {@link GafferPopGraphStepStrategy#instance()}.
   *
   * <ul>
   *   <li>Then Configuration return {@link BaseConfiguration}.
   * </ul>
   *
   * <p>Method under test: {@link GafferPopGraphStepStrategy#instance()}
   */
  @Test
  @DisplayName("Test instance(); then Configuration return BaseConfiguration")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"GafferPopGraphStepStrategy GafferPopGraphStepStrategy.instance()"})
  void testInstance_thenConfigurationReturnBaseConfiguration2() {
    // Arrange and Act
    GafferPopGraphStepStrategy actualInstanceResult = GafferPopGraphStepStrategy.instance();
    actualInstanceResult.apply(new HaltedTraversersCountTraversal());

    // Assert
    Configuration configuration = actualInstanceResult.getConfiguration();
    assertTrue(configuration instanceof BaseConfiguration);
    assertTrue(
        ((BaseConfiguration) configuration).getConversionHandler()
            instanceof DefaultConversionHandler);
    assertTrue(
        ((BaseConfiguration) configuration).getListDelimiterHandler()
            instanceof DisabledListDelimiterHandler);
    Synchronizer synchronizer = configuration.getSynchronizer();
    assertTrue(synchronizer instanceof NoOpSynchronizer);
    assertNull(((BaseConfiguration) configuration).getConfigurationDecoder());
    assertEquals(0, configuration.size());
    assertEquals(NoOpSynchronizer.INSTANCE, synchronizer);
    assertFalse(configuration.getKeys().hasNext());
    assertFalse(((BaseConfiguration) configuration).isThrowExceptionOnMissing());
    assertTrue(((BaseConfiguration) configuration).getEventListenerRegistrations().isEmpty());
    Class<ProviderOptimizationStrategy> expectedTraversalCategory =
        ProviderOptimizationStrategy.class;
    assertEquals(expectedTraversalCategory, actualInstanceResult.getTraversalCategory());
  }

  /**
   * Test {@link GafferPopGraphStepStrategy#instance()}.
   *
   * <ul>
   *   <li>Then Configuration return {@link BaseConfiguration}.
   * </ul>
   *
   * <p>Method under test: {@link GafferPopGraphStepStrategy#instance()}
   */
  @Test
  @DisplayName("Test instance(); then Configuration return BaseConfiguration")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"GafferPopGraphStepStrategy GafferPopGraphStepStrategy.instance()"})
  void testInstance_thenConfigurationReturnBaseConfiguration3() {
    // Arrange and Act
    GafferPopGraphStepStrategy actualInstanceResult = GafferPopGraphStepStrategy.instance();
    DefaultCredentialTraversal<?, ?> traversal = new DefaultCredentialTraversal<>();
    traversal.addV("Vertex Label");
    actualInstanceResult.apply(traversal);

    // Assert
    Configuration configuration = actualInstanceResult.getConfiguration();
    assertTrue(configuration instanceof BaseConfiguration);
    assertTrue(
        ((BaseConfiguration) configuration).getConversionHandler()
            instanceof DefaultConversionHandler);
    assertTrue(
        ((BaseConfiguration) configuration).getListDelimiterHandler()
            instanceof DisabledListDelimiterHandler);
    Synchronizer synchronizer = configuration.getSynchronizer();
    assertTrue(synchronizer instanceof NoOpSynchronizer);
    assertNull(((BaseConfiguration) configuration).getConfigurationDecoder());
    assertEquals(0, configuration.size());
    assertEquals(NoOpSynchronizer.INSTANCE, synchronizer);
    assertFalse(configuration.getKeys().hasNext());
    assertFalse(((BaseConfiguration) configuration).isThrowExceptionOnMissing());
    assertTrue(((BaseConfiguration) configuration).getEventListenerRegistrations().isEmpty());
    Class<ProviderOptimizationStrategy> expectedTraversalCategory =
        ProviderOptimizationStrategy.class;
    assertEquals(expectedTraversalCategory, actualInstanceResult.getTraversalCategory());
  }
}
