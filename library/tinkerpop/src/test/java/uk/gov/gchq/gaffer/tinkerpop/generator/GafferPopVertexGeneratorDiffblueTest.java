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

package uk.gov.gchq.gaffer.tinkerpop.generator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import uk.gov.gchq.gaffer.data.element.Edge;
import uk.gov.gchq.gaffer.data.element.Element;
import uk.gov.gchq.gaffer.data.element.Entity;
import uk.gov.gchq.gaffer.data.element.Entity.Builder;
import uk.gov.gchq.gaffer.data.element.id.EdgeId;
import uk.gov.gchq.gaffer.data.element.id.EdgeId.MatchedVertex;
import uk.gov.gchq.gaffer.tinkerpop.GafferPopVertex;

public class GafferPopVertexGeneratorDiffblueTest {
  /**
   * Test {@link GafferPopVertexGenerator#_apply(Element)}.
   * <ul>
   *   <li>Given {@code Element}.</li>
   *   <li>Then return id is {@code Element}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GafferPopVertexGenerator#_apply(Element)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"GafferPopVertex GafferPopVertexGenerator._apply(Element)"})
  public void test_apply_givenElement_thenReturnIdIsElement() {
    // Arrange
    GafferPopVertexGenerator gafferPopVertexGenerator = new GafferPopVertexGenerator(null);
    Entity element = (new Builder()).group("Group").vertex("Vertex").build();
    element.setVertex("Element");

    // Act
    GafferPopVertex actual_applyResult = gafferPopVertexGenerator._apply(element);

    // Assert
    assertEquals("Element", actual_applyResult.id());
    assertEquals("Group", actual_applyResult.label());
    assertNull(actual_applyResult.graph());
    assertTrue(actual_applyResult.isReadOnly());
  }

  /**
   * Test {@link GafferPopVertexGenerator#_apply(Element)}.
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>Then return id is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GafferPopVertexGenerator#_apply(Element)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"GafferPopVertex GafferPopVertexGenerator._apply(Element)"})
  public void test_apply_givenNull_thenReturnIdIsNull() {
    // Arrange
    GafferPopVertexGenerator gafferPopVertexGenerator = new GafferPopVertexGenerator(null);
    Entity element = (new Builder()).group("Group").vertex("Vertex").build();
    element.setVertex(null);

    // Act
    GafferPopVertex actual_applyResult = gafferPopVertexGenerator._apply(element);

    // Assert
    assertEquals("Group", actual_applyResult.label());
    assertNull(actual_applyResult.id());
    assertNull(actual_applyResult.graph());
    assertTrue(actual_applyResult.isReadOnly());
  }

  /**
   * Test {@link GafferPopVertexGenerator#_apply(Element)}.
   * <ul>
   *   <li>Then return id is a string.</li>
   * </ul>
   * <p>
   * Method under test: {@link GafferPopVertexGenerator#_apply(Element)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"GafferPopVertex GafferPopVertexGenerator._apply(Element)"})
  public void test_apply_thenReturnIdIsAString() {
    // Arrange
    GafferPopVertexGenerator gafferPopVertexGenerator = new GafferPopVertexGenerator(null);
    Entity element = (new Builder()).group("Group").vertex("Vertex").build();
    Edge buildResult = (new Edge.Builder()).dest("Dest")
        .directed(true)
        .group("Group")
        .matchedVertex(MatchedVertex.SOURCE)
        .source("Source")
        .build();
    element.setVertex(buildResult);

    // Act
    GafferPopVertex actual_applyResult = gafferPopVertexGenerator._apply(element);

    // Assert
    assertEquals("Edge[source=Source,destination=Dest,directed=true,matchedVertex=SOURCE,group=Group,properties"
        + "=Properties[]]", actual_applyResult.id());
    assertEquals("Group", actual_applyResult.label());
    assertNull(actual_applyResult.graph());
    assertTrue(actual_applyResult.isReadOnly());
  }

  /**
   * Test {@link GafferPopVertexGenerator#_apply(Element)}.
   * <ul>
   *   <li>When {@link Edge#Edge(String)} with {@code Group}.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GafferPopVertexGenerator#_apply(Element)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"GafferPopVertex GafferPopVertexGenerator._apply(Element)"})
  public void test_apply_whenEdgeWithGroup_thenThrowIllegalArgumentException() {
    // Arrange
    GafferPopVertexGenerator gafferPopVertexGenerator = new GafferPopVertexGenerator(null);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> gafferPopVertexGenerator._apply(new Edge("Group")));
  }
}
