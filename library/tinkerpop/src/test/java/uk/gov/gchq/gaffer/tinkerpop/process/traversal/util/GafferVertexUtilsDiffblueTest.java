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

package uk.gov.gchq.gaffer.tinkerpop.process.traversal.util;

import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import org.apache.tinkerpop.gremlin.structure.Vertex;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import uk.gov.gchq.gaffer.data.element.Edge;
import uk.gov.gchq.gaffer.data.element.Element;
import uk.gov.gchq.gaffer.data.element.Entity;
import uk.gov.gchq.gaffer.data.element.Entity.Builder;
import uk.gov.gchq.gaffer.tinkerpop.GafferPopGraph;

public class GafferVertexUtilsDiffblueTest {
  /**
   * Test {@link GafferVertexUtils#getOrphanVertices(Iterable, GafferPopGraph, Object[])}.
   * <ul>
   *   <li>Given {@link Entity.Builder} (default constructor) group {@code Group} vertex {@code Vertex} build.</li>
   * </ul>
   * <p>
   * Method under test: {@link GafferVertexUtils#getOrphanVertices(Iterable, GafferPopGraph, Object[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Collection GafferVertexUtils.getOrphanVertices(Iterable, GafferPopGraph, Object[])"})
  public void testGetOrphanVertices_givenBuilderGroupGroupVertexVertexBuild() {
    // Arrange
    ArrayList<Element> result = new ArrayList<>();
    Entity buildResult = (new Builder()).group("Group").vertex("Vertex").build();
    result.add(buildResult);

    // Act
    Collection<Vertex> actualOrphanVertices = GafferVertexUtils.getOrphanVertices(result, null, "Vertex Ids");

    // Assert
    assertTrue(actualOrphanVertices instanceof Set);
    assertTrue(actualOrphanVertices.isEmpty());
  }

  /**
   * Test {@link GafferVertexUtils#getOrphanVertices(Iterable, GafferPopGraph, Object[])}.
   * <ul>
   *   <li>Given {@link Edge#Edge(String)} with group is {@code Getting orphan vertices for vertex {}}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GafferVertexUtils#getOrphanVertices(Iterable, GafferPopGraph, Object[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Collection GafferVertexUtils.getOrphanVertices(Iterable, GafferPopGraph, Object[])"})
  public void testGetOrphanVertices_givenEdgeWithGroupIsGettingOrphanVerticesForVertex() {
    // Arrange
    ArrayList<Element> result = new ArrayList<>();
    result.add(new Edge("Getting orphan vertices for vertex {}"));

    // Act
    Collection<Vertex> actualOrphanVertices = GafferVertexUtils.getOrphanVertices(result, null, "Vertex Ids");

    // Assert
    assertTrue(actualOrphanVertices instanceof Set);
    assertTrue(actualOrphanVertices.isEmpty());
  }

  /**
   * Test {@link GafferVertexUtils#getOrphanVertices(Iterable, GafferPopGraph, Object[])}.
   * <ul>
   *   <li>Given {@link Edge#Edge(String)} with group is {@code Getting orphan vertices for vertex {}}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GafferVertexUtils#getOrphanVertices(Iterable, GafferPopGraph, Object[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Collection GafferVertexUtils.getOrphanVertices(Iterable, GafferPopGraph, Object[])"})
  public void testGetOrphanVertices_givenEdgeWithGroupIsGettingOrphanVerticesForVertex2() {
    // Arrange
    ArrayList<Element> result = new ArrayList<>();
    result.add(new Edge("Getting orphan vertices for vertex {}"));
    result.add(new Edge("Getting orphan vertices for vertex {}"));

    // Act
    Collection<Vertex> actualOrphanVertices = GafferVertexUtils.getOrphanVertices(result, null, "Vertex Ids");

    // Assert
    assertTrue(actualOrphanVertices instanceof Set);
    assertTrue(actualOrphanVertices.isEmpty());
  }

  /**
   * Test {@link GafferVertexUtils#getOrphanVertices(Iterable, GafferPopGraph, Object[])}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return {@link List}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GafferVertexUtils#getOrphanVertices(Iterable, GafferPopGraph, Object[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Collection GafferVertexUtils.getOrphanVertices(Iterable, GafferPopGraph, Object[])"})
  public void testGetOrphanVertices_whenArrayList_thenReturnList() {
    // Arrange and Act
    Collection<Vertex> actualOrphanVertices = GafferVertexUtils.getOrphanVertices(new ArrayList<>(), null);

    // Assert
    assertTrue(actualOrphanVertices instanceof List);
    assertTrue(actualOrphanVertices.isEmpty());
  }

  /**
   * Test {@link GafferVertexUtils#getOrphanVertices(Iterable, GafferPopGraph, Object[])}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return {@link Set}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GafferVertexUtils#getOrphanVertices(Iterable, GafferPopGraph, Object[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Collection GafferVertexUtils.getOrphanVertices(Iterable, GafferPopGraph, Object[])"})
  public void testGetOrphanVertices_whenArrayList_thenReturnSet() {
    // Arrange and Act
    Collection<Vertex> actualOrphanVertices = GafferVertexUtils.getOrphanVertices(new ArrayList<>(), null,
        "Vertex Ids");

    // Assert
    assertTrue(actualOrphanVertices instanceof Set);
    assertTrue(actualOrphanVertices.isEmpty());
  }

  /**
   * Test {@link GafferVertexUtils#getOrphanVertices(Iterable, GafferPopGraph, Object[])}.
   * <ul>
   *   <li>When {@code Vertex Ids} and {@code Vertex Ids}.</li>
   *   <li>Then return {@link Set}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GafferVertexUtils#getOrphanVertices(Iterable, GafferPopGraph, Object[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Collection GafferVertexUtils.getOrphanVertices(Iterable, GafferPopGraph, Object[])"})
  public void testGetOrphanVertices_whenVertexIdsAndVertexIds_thenReturnSet() {
    // Arrange and Act
    Collection<Vertex> actualOrphanVertices = GafferVertexUtils.getOrphanVertices(new ArrayList<>(), null, "Vertex Ids",
        "Vertex Ids");

    // Assert
    assertTrue(actualOrphanVertices instanceof Set);
    assertTrue(actualOrphanVertices.isEmpty());
  }
}
