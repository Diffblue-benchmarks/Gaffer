package uk.gov.gchq.gaffer.tinkerpop.process.traversal.strategy.optimisation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.apache.commons.configuration2.BaseConfiguration;
import org.apache.commons.configuration2.Configuration;
import org.apache.commons.configuration2.convert.DefaultConversionHandler;
import org.apache.commons.configuration2.convert.DisabledListDelimiterHandler;
import org.apache.commons.configuration2.sync.NoOpSynchronizer;
import org.apache.commons.configuration2.sync.Synchronizer;
import org.apache.tinkerpop.gremlin.groovy.jsr223.dsl.credential.DefaultCredentialTraversal;
import org.apache.tinkerpop.gremlin.process.computer.traversal.step.map.ComputerResultStep;
import org.apache.tinkerpop.gremlin.process.traversal.TraversalStrategy;
import org.apache.tinkerpop.gremlin.process.traversal.TraversalStrategy.ProviderOptimizationStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class GafferPopHasStepStrategyDiffblueTest {
  /**
   * Test {@link GafferPopHasStepStrategy#instance()}.
   *
   * <ul>
   *   <li>Then Configuration return {@link BaseConfiguration}.
   * </ul>
   *
   * <p>Method under test: {@link GafferPopHasStepStrategy#instance()}
   */
  @Test
  @DisplayName("Test instance(); then Configuration return BaseConfiguration")
  @Tag("MaintainedByDiffblue")
  void testInstance_thenConfigurationReturnBaseConfiguration() {
    // Arrange and Act
    GafferPopHasStepStrategy actualInstanceResult = GafferPopHasStepStrategy.instance();
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
   * Test {@link GafferPopHasStepStrategy#instance()}.
   *
   * <ul>
   *   <li>Then Configuration return {@link BaseConfiguration}.
   * </ul>
   *
   * <p>Method under test: {@link GafferPopHasStepStrategy#instance()}
   */
  @Test
  @DisplayName("Test instance(); then Configuration return BaseConfiguration")
  @Tag("MaintainedByDiffblue")
  void testInstance_thenConfigurationReturnBaseConfiguration2() {
    // Arrange and Act
    GafferPopHasStepStrategy actualInstanceResult = GafferPopHasStepStrategy.instance();
    DefaultCredentialTraversal<?, ?> traversal = new DefaultCredentialTraversal<>();
    traversal.addStep(new ComputerResultStep<>(new DefaultCredentialTraversal()));
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
