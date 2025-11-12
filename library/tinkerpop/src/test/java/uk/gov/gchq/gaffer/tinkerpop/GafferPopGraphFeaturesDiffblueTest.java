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

import static org.junit.Assert.assertTrue;
import org.apache.tinkerpop.gremlin.structure.Graph;
import org.junit.Test;

public class GafferPopGraphFeaturesDiffblueTest {
  /**
   * Method under test: {@link GafferPopGraphFeatures#graph()}
   */
  @Test
  public void testGraph() {
    // Arrange, Act and Assert
    assertTrue((new GafferPopGraphFeatures()).graph() instanceof GafferPopGraphFeatures.GafferPopGraphGraphFeatures);
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link GafferPopGraphFeatures}
   */
  @Test
  public void testNewGafferPopGraphFeatures() {
    // Arrange and Act
    GafferPopGraphFeatures actualGafferPopGraphFeatures = new GafferPopGraphFeatures();

    // Assert
    assertTrue(actualGafferPopGraphFeatures.edge() instanceof GafferPopGraphFeatures.GafferPopGraphEdgeFeatures);
    assertTrue(actualGafferPopGraphFeatures.graph() instanceof GafferPopGraphFeatures.GafferPopGraphGraphFeatures);
    Graph.Features.VertexFeatures vertexResult = actualGafferPopGraphFeatures.vertex();
    assertTrue(vertexResult instanceof GafferPopGraphFeatures.GafferPopGraphVertexFeatures);
    assertTrue(vertexResult.properties() instanceof GafferPopGraphFeatures.GafferPopGraphVertexPropertyFeatures);
  }

  /**
   * Method under test: {@link GafferPopGraphFeatures#edge()}
   */
  @Test
  public void testEdge() {
    // Arrange, Act and Assert
    assertTrue((new GafferPopGraphFeatures()).edge() instanceof GafferPopGraphFeatures.GafferPopGraphEdgeFeatures);
  }

  /**
   * Method under test: {@link GafferPopGraphFeatures#vertex()}
   */
  @Test
  public void testVertex() {
    // Arrange and Act
    Graph.Features.VertexFeatures actualVertexResult = (new GafferPopGraphFeatures()).vertex();

    // Assert
    assertTrue(actualVertexResult instanceof GafferPopGraphFeatures.GafferPopGraphVertexFeatures);
    assertTrue(actualVertexResult.properties() instanceof GafferPopGraphFeatures.GafferPopGraphVertexPropertyFeatures);
  }
}
