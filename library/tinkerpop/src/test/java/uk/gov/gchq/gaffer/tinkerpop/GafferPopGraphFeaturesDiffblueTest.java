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

import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.apache.tinkerpop.gremlin.structure.Graph;
import org.apache.tinkerpop.gremlin.structure.Graph.Features;
import org.apache.tinkerpop.gremlin.structure.Graph.Features.VertexFeatures;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.tinkerpop.GafferPopGraphFeatures.GafferPopGraphEdgeFeatures;
import uk.gov.gchq.gaffer.tinkerpop.GafferPopGraphFeatures.GafferPopGraphGraphFeatures;
import uk.gov.gchq.gaffer.tinkerpop.GafferPopGraphFeatures.GafferPopGraphVertexFeatures;
import uk.gov.gchq.gaffer.tinkerpop.GafferPopGraphFeatures.GafferPopGraphVertexPropertyFeatures;

class GafferPopGraphFeaturesDiffblueTest {
  /**
   * Test {@link GafferPopGraphFeatures#graph()}.
   *
   * <p>Method under test: {@link GafferPopGraphFeatures#graph()}
   */
  @Test
  @DisplayName("Test graph()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Graph.Features.GraphFeatures GafferPopGraphFeatures.graph()"})
  void testGraph() {
    // Arrange, Act and Assert
    assertTrue(new GafferPopGraphFeatures().graph() instanceof GafferPopGraphGraphFeatures);
  }

  /**
   * Test {@link GafferPopGraphFeatures#edge()}.
   *
   * <p>Method under test: {@link GafferPopGraphFeatures#edge()}
   */
  @Test
  @DisplayName("Test edge()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Graph.Features.EdgeFeatures GafferPopGraphFeatures.edge()"})
  void testEdge() {
    // Arrange, Act and Assert
    assertTrue(new GafferPopGraphFeatures().edge() instanceof GafferPopGraphEdgeFeatures);
  }

  /**
   * Test {@link GafferPopGraphFeatures#vertex()}.
   *
   * <p>Method under test: {@link GafferPopGraphFeatures#vertex()}
   */
  @Test
  @DisplayName("Test vertex()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"VertexFeatures GafferPopGraphFeatures.vertex()"})
  void testVertex() {
    // Arrange and Act
    VertexFeatures actualVertexResult = new GafferPopGraphFeatures().vertex();

    // Assert
    assertTrue(actualVertexResult instanceof GafferPopGraphVertexFeatures);
    assertTrue(actualVertexResult.properties() instanceof GafferPopGraphVertexPropertyFeatures);
  }

  /**
   * Test new {@link GafferPopGraphFeatures} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link GafferPopGraphFeatures}
   */
  @Test
  @DisplayName("Test new GafferPopGraphFeatures (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void GafferPopGraphFeatures.<init>()"})
  void testNewGafferPopGraphFeatures() {
    // Arrange and Act
    GafferPopGraphFeatures actualGafferPopGraphFeatures = new GafferPopGraphFeatures();

    // Assert
    assertTrue(actualGafferPopGraphFeatures.edge() instanceof GafferPopGraphEdgeFeatures);
    assertTrue(actualGafferPopGraphFeatures.graph() instanceof GafferPopGraphGraphFeatures);
    VertexFeatures vertexResult = actualGafferPopGraphFeatures.vertex();
    assertTrue(vertexResult instanceof GafferPopGraphVertexFeatures);
    assertTrue(vertexResult.properties() instanceof GafferPopGraphVertexPropertyFeatures);
  }
}
