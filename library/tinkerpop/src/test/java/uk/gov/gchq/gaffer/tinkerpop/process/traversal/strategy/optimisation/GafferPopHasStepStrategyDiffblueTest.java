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

package uk.gov.gchq.gaffer.tinkerpop.process.traversal.strategy.optimisation;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import java.util.List;
import java.util.Map;
import org.apache.commons.configuration2.BaseConfiguration;
import org.apache.commons.configuration2.Configuration;
import org.apache.commons.configuration2.ConfigurationLookup;
import org.apache.commons.configuration2.convert.ConversionHandler;
import org.apache.commons.configuration2.convert.DefaultConversionHandler;
import org.apache.commons.configuration2.convert.DisabledListDelimiterHandler;
import org.apache.commons.configuration2.convert.ListDelimiterHandler;
import org.apache.commons.configuration2.interpol.ConfigurationInterpolator;
import org.apache.commons.configuration2.interpol.Lookup;
import org.apache.commons.configuration2.io.ConfigurationLogger;
import org.apache.commons.configuration2.sync.NoOpSynchronizer;
import org.apache.commons.configuration2.sync.Synchronizer;
import org.apache.tinkerpop.gremlin.groovy.jsr223.dsl.credential.DefaultCredentialTraversal;
import org.apache.tinkerpop.gremlin.process.computer.traversal.step.map.ComputerResultStep;
import org.apache.tinkerpop.gremlin.process.remote.EmbeddedRemoteConnection;
import org.apache.tinkerpop.gremlin.process.traversal.TraversalStrategy;
import org.apache.tinkerpop.gremlin.process.traversal.dsl.graph.DefaultGraphTraversal;
import org.apache.tinkerpop.gremlin.process.traversal.dsl.graph.GraphTraversalSource;
import org.junit.Test;

public class GafferPopHasStepStrategyDiffblueTest {
  /**
   * Method under test: {@link GafferPopHasStepStrategy#instance()}
   */
  @Test
  public void testInstance() {
    // Arrange and Act
    GafferPopHasStepStrategy actualInstanceResult = GafferPopHasStepStrategy.instance();
    actualInstanceResult.apply(new DefaultCredentialTraversal<>());

    // Assert
    Configuration configuration = actualInstanceResult.getConfiguration();
    assertTrue(configuration instanceof BaseConfiguration);
    ConfigurationInterpolator interpolator = configuration.getInterpolator();
    List<Lookup> defaultLookups = interpolator.getDefaultLookups();
    assertEquals(1, defaultLookups.size());
    Lookup getResult = defaultLookups.get(0);
    assertTrue(getResult instanceof ConfigurationLookup);
    ConversionHandler conversionHandler = ((BaseConfiguration) configuration).getConversionHandler();
    assertTrue(conversionHandler instanceof DefaultConversionHandler);
    ListDelimiterHandler listDelimiterHandler = ((BaseConfiguration) configuration).getListDelimiterHandler();
    assertTrue(listDelimiterHandler instanceof DisabledListDelimiterHandler);
    Synchronizer synchronizer = configuration.getSynchronizer();
    assertTrue(synchronizer instanceof NoOpSynchronizer);
    assertEquals("yyyy-MM-dd HH:mm:ss", ((DefaultConversionHandler) conversionHandler).getDateFormat());
    assertNull(((BaseConfiguration) configuration).getConfigurationDecoder());
    assertNull(interpolator.getParentInterpolator());
    assertEquals(0, configuration.size());
    Map<String, Lookup> lookups = interpolator.getLookups();
    assertEquals(14, lookups.size());
    assertEquals(NoOpSynchronizer.INSTANCE, synchronizer);
    assertFalse(configuration.getKeys().hasNext());
    assertFalse(((BaseConfiguration) configuration).isThrowExceptionOnMissing());
    assertFalse(interpolator.isEnableSubstitutionInVariables());
    ConfigurationLogger logger = ((BaseConfiguration) configuration).getLogger();
    assertFalse(logger.isDebugEnabled());
    assertFalse(logger.isInfoEnabled());
    assertTrue(((BaseConfiguration) configuration).getEventListenerRegistrations().isEmpty());
    assertTrue(lookups.containsKey("const"));
    assertTrue(lookups.containsKey("date"));
    assertTrue(lookups.containsKey("localhost"));
    Class<TraversalStrategy.ProviderOptimizationStrategy> expectedTraversalCategory = TraversalStrategy.ProviderOptimizationStrategy.class;
    assertEquals(expectedTraversalCategory, actualInstanceResult.getTraversalCategory());
    assertSame(configuration, ((ConfigurationLookup) getResult).getConfiguration());
    assertSame(listDelimiterHandler, ((DefaultConversionHandler) conversionHandler).getListDelimiterHandler());
  }

  /**
   * Method under test: {@link GafferPopHasStepStrategy#instance()}
   */
  @Test
  public void testInstance2() {
    // Arrange and Act
    GafferPopHasStepStrategy actualInstanceResult = GafferPopHasStepStrategy.instance();
    actualInstanceResult.apply(new DefaultGraphTraversal<>(
        new GraphTraversalSource(new EmbeddedRemoteConnection(mock(GraphTraversalSource.class)))));

    // Assert
    Configuration configuration = actualInstanceResult.getConfiguration();
    assertTrue(configuration instanceof BaseConfiguration);
    ConfigurationInterpolator interpolator = configuration.getInterpolator();
    List<Lookup> defaultLookups = interpolator.getDefaultLookups();
    assertEquals(1, defaultLookups.size());
    Lookup getResult = defaultLookups.get(0);
    assertTrue(getResult instanceof ConfigurationLookup);
    ConversionHandler conversionHandler = ((BaseConfiguration) configuration).getConversionHandler();
    assertTrue(conversionHandler instanceof DefaultConversionHandler);
    ListDelimiterHandler listDelimiterHandler = ((BaseConfiguration) configuration).getListDelimiterHandler();
    assertTrue(listDelimiterHandler instanceof DisabledListDelimiterHandler);
    Synchronizer synchronizer = configuration.getSynchronizer();
    assertTrue(synchronizer instanceof NoOpSynchronizer);
    assertEquals("yyyy-MM-dd HH:mm:ss", ((DefaultConversionHandler) conversionHandler).getDateFormat());
    assertNull(((BaseConfiguration) configuration).getConfigurationDecoder());
    assertNull(interpolator.getParentInterpolator());
    assertEquals(0, configuration.size());
    Map<String, Lookup> lookups = interpolator.getLookups();
    assertEquals(14, lookups.size());
    assertEquals(NoOpSynchronizer.INSTANCE, synchronizer);
    assertFalse(configuration.getKeys().hasNext());
    assertFalse(((BaseConfiguration) configuration).isThrowExceptionOnMissing());
    assertFalse(interpolator.isEnableSubstitutionInVariables());
    ConfigurationLogger logger = ((BaseConfiguration) configuration).getLogger();
    assertFalse(logger.isDebugEnabled());
    assertFalse(logger.isInfoEnabled());
    assertTrue(((BaseConfiguration) configuration).getEventListenerRegistrations().isEmpty());
    assertTrue(lookups.containsKey("const"));
    assertTrue(lookups.containsKey("date"));
    assertTrue(lookups.containsKey("localhost"));
    Class<TraversalStrategy.ProviderOptimizationStrategy> expectedTraversalCategory = TraversalStrategy.ProviderOptimizationStrategy.class;
    assertEquals(expectedTraversalCategory, actualInstanceResult.getTraversalCategory());
    assertSame(configuration, ((ConfigurationLookup) getResult).getConfiguration());
    assertSame(listDelimiterHandler, ((DefaultConversionHandler) conversionHandler).getListDelimiterHandler());
  }

  /**
   * Method under test: {@link GafferPopHasStepStrategy#instance()}
   */
  @Test
  public void testInstance3() throws IllegalStateException {
    // Arrange and Act
    GafferPopHasStepStrategy actualInstanceResult = GafferPopHasStepStrategy.instance();
    DefaultCredentialTraversal<?, ?> traversal = new DefaultCredentialTraversal<>();
    traversal.addStep(new ComputerResultStep<>(new DefaultCredentialTraversal()));
    traversal.addStep(1, new ComputerResultStep<>(new DefaultCredentialTraversal()));
    actualInstanceResult.apply(traversal);

    // Assert
    Configuration configuration = actualInstanceResult.getConfiguration();
    assertTrue(configuration instanceof BaseConfiguration);
    ConfigurationInterpolator interpolator = configuration.getInterpolator();
    List<Lookup> defaultLookups = interpolator.getDefaultLookups();
    assertEquals(1, defaultLookups.size());
    Lookup getResult = defaultLookups.get(0);
    assertTrue(getResult instanceof ConfigurationLookup);
    ConversionHandler conversionHandler = ((BaseConfiguration) configuration).getConversionHandler();
    assertTrue(conversionHandler instanceof DefaultConversionHandler);
    ListDelimiterHandler listDelimiterHandler = ((BaseConfiguration) configuration).getListDelimiterHandler();
    assertTrue(listDelimiterHandler instanceof DisabledListDelimiterHandler);
    Synchronizer synchronizer = configuration.getSynchronizer();
    assertTrue(synchronizer instanceof NoOpSynchronizer);
    assertEquals("yyyy-MM-dd HH:mm:ss", ((DefaultConversionHandler) conversionHandler).getDateFormat());
    assertNull(((BaseConfiguration) configuration).getConfigurationDecoder());
    assertNull(interpolator.getParentInterpolator());
    assertEquals(0, configuration.size());
    Map<String, Lookup> lookups = interpolator.getLookups();
    assertEquals(14, lookups.size());
    assertEquals(NoOpSynchronizer.INSTANCE, synchronizer);
    assertFalse(configuration.getKeys().hasNext());
    assertFalse(((BaseConfiguration) configuration).isThrowExceptionOnMissing());
    assertFalse(interpolator.isEnableSubstitutionInVariables());
    ConfigurationLogger logger = ((BaseConfiguration) configuration).getLogger();
    assertFalse(logger.isDebugEnabled());
    assertFalse(logger.isInfoEnabled());
    assertTrue(((BaseConfiguration) configuration).getEventListenerRegistrations().isEmpty());
    assertTrue(lookups.containsKey("const"));
    assertTrue(lookups.containsKey("date"));
    assertTrue(lookups.containsKey("localhost"));
    Class<TraversalStrategy.ProviderOptimizationStrategy> expectedTraversalCategory = TraversalStrategy.ProviderOptimizationStrategy.class;
    assertEquals(expectedTraversalCategory, actualInstanceResult.getTraversalCategory());
    assertSame(configuration, ((ConfigurationLookup) getResult).getConfiguration());
    assertSame(listDelimiterHandler, ((DefaultConversionHandler) conversionHandler).getListDelimiterHandler());
  }
}
