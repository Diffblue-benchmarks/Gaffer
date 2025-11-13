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

package uk.gov.gchq.gaffer.federated;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.data.element.Edge;
import uk.gov.gchq.gaffer.data.element.Element;
import uk.gov.gchq.gaffer.data.element.Entity;
import uk.gov.gchq.gaffer.data.element.Entity.Builder;

class IndexGeneratorDiffblueTest {
  /**
   * Test {@link IndexGenerator#_apply(Element)} with {@code Element}.
   * <ul>
   *   <li>Given {@code Element}.</li>
   *   <li>When {@link Entity#Entity(String)} with {@code Group} Vertex is {@code Element}.</li>
   * </ul>
   * <p>
   * Method under test: {@link IndexGenerator#_apply(Element)}
   */
  @Test
  @DisplayName("Test _apply(Element) with 'Element'; given 'Element'; when Entity(String) with 'Group' Vertex is 'Element'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Iterable IndexGenerator._apply(Element)"})
  void test_applyWithElement_givenElement_whenEntityWithGroupVertexIsElement() {
    // Arrange
    IndexGenerator indexGenerator = new IndexGenerator();

    Entity element = new Entity("Group");
    element.setVertex("Element");

    // Act
    Iterable<Element> actual_applyResult = indexGenerator._apply(element);

    // Assert
    assertTrue(actual_applyResult instanceof List);
    assertFalse(actual_applyResult.iterator().hasNext());
    assertTrue(((List<Element>) actual_applyResult).isEmpty());
  }

  /**
   * Test {@link IndexGenerator#_apply(Element)} with {@code Element}.
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>When {@link Entity#Entity(String)} with {@code Group} Vertex is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link IndexGenerator#_apply(Element)}
   */
  @Test
  @DisplayName("Test _apply(Element) with 'Element'; given 'null'; when Entity(String) with 'Group' Vertex is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Iterable IndexGenerator._apply(Element)"})
  void test_applyWithElement_givenNull_whenEntityWithGroupVertexIsNull() {
    // Arrange
    IndexGenerator indexGenerator = new IndexGenerator();

    Entity element = new Entity("Group");
    element.setVertex(null);

    // Act
    Iterable<Element> actual_applyResult = indexGenerator._apply(element);

    // Assert
    assertTrue(actual_applyResult instanceof List);
    assertFalse(actual_applyResult.iterator().hasNext());
    assertTrue(((List<Element>) actual_applyResult).isEmpty());
  }

  /**
   * Test {@link IndexGenerator#_apply(Element)} with {@code Element}.
   * <ul>
   *   <li>When {@link Entity.Builder} (default constructor) group {@code Group} vertex {@code Vertex} build Vertex is {@code Element}.</li>
   * </ul>
   * <p>
   * Method under test: {@link IndexGenerator#_apply(Element)}
   */
  @Test
  @DisplayName("Test _apply(Element) with 'Element'; when Builder (default constructor) group 'Group' vertex 'Vertex' build Vertex is 'Element'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Iterable IndexGenerator._apply(Element)"})
  void test_applyWithElement_whenBuilderGroupGroupVertexVertexBuildVertexIsElement() {
    // Arrange
    IndexGenerator indexGenerator = new IndexGenerator();
    Entity element = (new Builder()).group("Group").vertex("Vertex").build();
    element.setVertex("Element");

    // Act
    Iterable<Element> actual_applyResult = indexGenerator._apply(element);

    // Assert
    assertTrue(actual_applyResult instanceof List);
    assertFalse(actual_applyResult.iterator().hasNext());
    assertTrue(((List<Element>) actual_applyResult).isEmpty());
  }

  /**
   * Test {@link IndexGenerator#_apply(Element)} with {@code Element}.
   * <ul>
   *   <li>When {@link Entity.Builder} (default constructor) group {@code Group} vertex {@code Vertex} build Vertex is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link IndexGenerator#_apply(Element)}
   */
  @Test
  @DisplayName("Test _apply(Element) with 'Element'; when Builder (default constructor) group 'Group' vertex 'Vertex' build Vertex is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Iterable IndexGenerator._apply(Element)"})
  void test_applyWithElement_whenBuilderGroupGroupVertexVertexBuildVertexIsNull() {
    // Arrange
    IndexGenerator indexGenerator = new IndexGenerator();
    Entity element = (new Builder()).group("Group").vertex("Vertex").build();
    element.setVertex(null);

    // Act
    Iterable<Element> actual_applyResult = indexGenerator._apply(element);

    // Assert
    assertTrue(actual_applyResult instanceof List);
    assertFalse(actual_applyResult.iterator().hasNext());
    assertTrue(((List<Element>) actual_applyResult).isEmpty());
  }

  /**
   * Test {@link IndexGenerator#_apply(Element)} with {@code Element}.
   * <ul>
   *   <li>When {@link Edge#Edge(String)} with {@code Group}.</li>
   * </ul>
   * <p>
   * Method under test: {@link IndexGenerator#_apply(Element)}
   */
  @Test
  @DisplayName("Test _apply(Element) with 'Element'; when Edge(String) with 'Group'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Iterable IndexGenerator._apply(Element)"})
  void test_applyWithElement_whenEdgeWithGroup() {
    // Arrange
    IndexGenerator indexGenerator = new IndexGenerator();

    // Act
    Iterable<Element> actual_applyResult = indexGenerator._apply(new Edge("Group"));

    // Assert
    assertTrue(actual_applyResult instanceof List);
    assertFalse(actual_applyResult.iterator().hasNext());
    assertTrue(((List<Element>) actual_applyResult).isEmpty());
  }
}
