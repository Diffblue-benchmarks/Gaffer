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
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.apache.commons.configuration2.BaseConfiguration;
import org.apache.commons.configuration2.Configuration;
import org.apache.commons.configuration2.convert.DefaultConversionHandler;
import org.apache.commons.configuration2.convert.DisabledListDelimiterHandler;
import org.apache.commons.configuration2.sync.NoOpSynchronizer;
import org.apache.commons.configuration2.sync.Synchronizer;
import org.apache.tinkerpop.gremlin.groovy.jsr223.dsl.credential.DefaultCredentialTraversal;
import org.apache.tinkerpop.gremlin.process.traversal.TraversalStrategy;
import org.apache.tinkerpop.gremlin.process.traversal.TraversalStrategy.ProviderOptimizationStrategy;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class GafferPopVertexStepStrategyDiffblueTest {
  /**
   * Test {@link GafferPopVertexStepStrategy#instance()}.
   * <ul>
   *   <li>Then Configuration return {@link BaseConfiguration}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GafferPopVertexStepStrategy#instance()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"GafferPopVertexStepStrategy GafferPopVertexStepStrategy.instance()"})
  public void testInstance_thenConfigurationReturnBaseConfiguration() {
    // Arrange and Act
    GafferPopVertexStepStrategy actualInstanceResult = GafferPopVertexStepStrategy.instance();
    actualInstanceResult.apply(new DefaultCredentialTraversal<>());

    // Assert
    Configuration configuration = actualInstanceResult.getConfiguration();
    assertTrue(configuration instanceof BaseConfiguration);
    assertTrue(((BaseConfiguration) configuration).getConversionHandler() instanceof DefaultConversionHandler);
    assertTrue(((BaseConfiguration) configuration).getListDelimiterHandler() instanceof DisabledListDelimiterHandler);
    Synchronizer synchronizer = configuration.getSynchronizer();
    assertTrue(synchronizer instanceof NoOpSynchronizer);
    assertNull(((BaseConfiguration) configuration).getConfigurationDecoder());
    assertEquals(0, configuration.size());
    assertEquals(NoOpSynchronizer.INSTANCE, synchronizer);
    assertFalse(configuration.getKeys().hasNext());
    assertFalse(((BaseConfiguration) configuration).isThrowExceptionOnMissing());
    assertTrue(((BaseConfiguration) configuration).getEventListenerRegistrations().isEmpty());
    Class<ProviderOptimizationStrategy> expectedTraversalCategory = ProviderOptimizationStrategy.class;
    assertEquals(expectedTraversalCategory, actualInstanceResult.getTraversalCategory());
  }
}
