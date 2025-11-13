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

package uk.gov.gchq.gaffer.rest.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.data.element.Edge;
import uk.gov.gchq.gaffer.data.element.Element;
import uk.gov.gchq.gaffer.data.element.Entity;
import uk.gov.gchq.gaffer.data.element.id.DirectedType;

class ExampleElementGeneratorDiffblueTest {
  /**
   * Test {@link ExampleElementGenerator#_apply(ExampleDomainObject)} with {@code ExampleDomainObject}.
   * <ul>
   *   <li>Then return {@link Edge}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExampleElementGenerator#_apply(ExampleDomainObject)}
   */
  @Test
  @DisplayName("Test _apply(ExampleDomainObject) with 'ExampleDomainObject'; then return Edge")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Element ExampleElementGenerator._apply(ExampleDomainObject)"})
  void test_applyWithExampleDomainObject_thenReturnEdge() {
    // Arrange
    ExampleElementGenerator exampleElementGenerator = new ExampleElementGenerator();

    // Act
    Element actual_applyResult = exampleElementGenerator._apply(new ExampleDomainObject("Type", "Ids", "Ids"));

    // Assert
    assertTrue(actual_applyResult instanceof Edge);
    assertEquals("Ids", ((Edge) actual_applyResult).getDestination());
    assertEquals("Ids", ((Edge) actual_applyResult).getSource());
    assertEquals("Ids", ((Edge) actual_applyResult).getAdjacentMatchedVertexValue());
    assertEquals("Ids", ((Edge) actual_applyResult).getMatchedVertexValue());
    assertEquals("uk.gov.gchq.gaffer.data.element.Edge", actual_applyResult.getClassName());
    assertNull(((Edge) actual_applyResult).getMatchedVertex());
    assertEquals(DirectedType.UNDIRECTED, ((Edge) actual_applyResult).getDirectedType());
    assertFalse(((Edge) actual_applyResult).isDirected());
    assertTrue(((Edge) actual_applyResult).isUndirected());
  }

  /**
   * Test {@link ExampleElementGenerator#_apply(ExampleDomainObject)} with {@code ExampleDomainObject}.
   * <ul>
   *   <li>Then return {@link Edge}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExampleElementGenerator#_apply(ExampleDomainObject)}
   */
  @Test
  @DisplayName("Test _apply(ExampleDomainObject) with 'ExampleDomainObject'; then return Edge")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Element ExampleElementGenerator._apply(ExampleDomainObject)"})
  void test_applyWithExampleDomainObject_thenReturnEdge2() {
    // Arrange
    ExampleElementGenerator exampleElementGenerator = new ExampleElementGenerator();

    // Act
    Element actual_applyResult = exampleElementGenerator._apply(new ExampleDomainObject("Type", "Ids", "Ids", "Ids"));

    // Assert
    assertTrue(actual_applyResult instanceof Edge);
    assertEquals("Ids", ((Edge) actual_applyResult).getDestination());
    assertEquals("Ids", ((Edge) actual_applyResult).getSource());
    assertEquals("Ids", ((Edge) actual_applyResult).getAdjacentMatchedVertexValue());
    assertEquals("Ids", ((Edge) actual_applyResult).getMatchedVertexValue());
    assertEquals("uk.gov.gchq.gaffer.data.element.Edge", actual_applyResult.getClassName());
    assertNull(((Edge) actual_applyResult).getMatchedVertex());
    assertEquals(DirectedType.UNDIRECTED, ((Edge) actual_applyResult).getDirectedType());
    assertFalse(((Edge) actual_applyResult).isDirected());
    assertTrue(((Edge) actual_applyResult).isUndirected());
  }

  /**
   * Test {@link ExampleElementGenerator#_apply(ExampleDomainObject)} with {@code ExampleDomainObject}.
   * <ul>
   *   <li>Then return {@link Entity}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExampleElementGenerator#_apply(ExampleDomainObject)}
   */
  @Test
  @DisplayName("Test _apply(ExampleDomainObject) with 'ExampleDomainObject'; then return Entity")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Element ExampleElementGenerator._apply(ExampleDomainObject)"})
  void test_applyWithExampleDomainObject_thenReturnEntity() {
    // Arrange
    ExampleElementGenerator exampleElementGenerator = new ExampleElementGenerator();

    // Act
    Element actual_applyResult = exampleElementGenerator._apply(new ExampleDomainObject("Type", "Ids"));

    // Assert
    assertTrue(actual_applyResult instanceof Entity);
    assertEquals("Ids", ((Entity) actual_applyResult).getVertex());
    assertEquals("uk.gov.gchq.gaffer.data.element.Entity", actual_applyResult.getClassName());
  }
}
