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

package uk.gov.gchq.gaffer.graph.hook.migrate.predicate;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.data.element.Edge;
import uk.gov.gchq.gaffer.data.element.Element;
import uk.gov.gchq.gaffer.data.element.ElementValueLoader;
import uk.gov.gchq.gaffer.data.element.LazyEdge;
import uk.gov.gchq.gaffer.data.element.function.ElementFilter;
import uk.gov.gchq.gaffer.data.element.function.ElementTransformer;

class TransformAndFilterDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link TransformAndFilter#TransformAndFilter()}
   *   <li>{@link TransformAndFilter#setFilter(ElementFilter)}
   *   <li>{@link TransformAndFilter#setTransformer(ElementTransformer)}
   *   <li>{@link TransformAndFilter#getFilter()}
   *   <li>{@link TransformAndFilter#getTransformer()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    TransformAndFilter actualTransformAndFilter = new TransformAndFilter();
    ElementFilter filter = new ElementFilter();
    actualTransformAndFilter.setFilter(filter);
    ElementTransformer transformer = new ElementTransformer();
    actualTransformAndFilter.setTransformer(transformer);
    ElementFilter actualFilter = actualTransformAndFilter.getFilter();
    ElementTransformer actualTransformer = actualTransformAndFilter.getTransformer();

    // Assert that nothing has changed
    assertTrue(actualFilter.getComponents().isEmpty());
    assertSame(filter, actualFilter);
    assertSame(transformer, actualTransformer);
  }

  /**
   * Method under test: {@link TransformAndFilter#test(Element)}
   */
  @Test
  void testTest() {
    // Arrange
    TransformAndFilter transformAndFilter = new TransformAndFilter();

    // Act and Assert
    assertTrue(transformAndFilter.test(new Edge("Group")));
  }

  /**
   * Method under test: {@link TransformAndFilter#test(Element)}
   */
  @Test
  void testTest2() {
    // Arrange
    TransformAndFilter transformAndFilter = new TransformAndFilter();
    transformAndFilter.setFilter(null);
    transformAndFilter.setTransformer(null);

    // Act and Assert
    assertFalse(transformAndFilter.test(null));
  }

  /**
   * Method under test: {@link TransformAndFilter#test(Element)}
   */
  @Test
  void testTest3() {
    // Arrange
    TransformAndFilter transformAndFilter = new TransformAndFilter();
    transformAndFilter.setFilter(new ElementFilter());
    transformAndFilter.setTransformer(null);

    // Act and Assert
    assertTrue(transformAndFilter.test(new Edge("Group")));
  }

  /**
   * Method under test: {@link TransformAndFilter#test(Element)}
   */
  @Test
  void testTest4() {
    // Arrange
    TransformAndFilter transformAndFilter = new TransformAndFilter();
    transformAndFilter.setFilter(new ElementFilter());
    transformAndFilter.setTransformer(new ElementTransformer());

    // Act and Assert
    assertTrue(transformAndFilter.test(new Edge("Group")));
  }

  /**
   * Method under test: {@link TransformAndFilter#test(Element)}
   */
  @Test
  void testTest5() {
    // Arrange
    TransformAndFilter transformAndFilter = new TransformAndFilter();

    // Act and Assert
    assertTrue(transformAndFilter.test(new LazyEdge(new Edge("Group"), mock(ElementValueLoader.class))));
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link TransformAndFilter#TransformAndFilter(ElementFilter)}
   *   <li>{@link TransformAndFilter#setFilter(ElementFilter)}
   *   <li>{@link TransformAndFilter#setTransformer(ElementTransformer)}
   *   <li>{@link TransformAndFilter#getFilter()}
   *   <li>{@link TransformAndFilter#getTransformer()}
   * </ul>
   */
  @Test
  void testGettersAndSetters2() {
    // Arrange and Act
    TransformAndFilter actualTransformAndFilter = new TransformAndFilter(new ElementFilter());
    ElementFilter filter = new ElementFilter();
    actualTransformAndFilter.setFilter(filter);
    ElementTransformer transformer = new ElementTransformer();
    actualTransformAndFilter.setTransformer(transformer);
    ElementFilter actualFilter = actualTransformAndFilter.getFilter();
    ElementTransformer actualTransformer = actualTransformAndFilter.getTransformer();

    // Assert that nothing has changed
    assertTrue(actualFilter.getComponents().isEmpty());
    assertSame(filter, actualFilter);
    assertSame(transformer, actualTransformer);
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>
   * {@link TransformAndFilter#TransformAndFilter(ElementTransformer, ElementFilter)}
   *   <li>{@link TransformAndFilter#setFilter(ElementFilter)}
   *   <li>{@link TransformAndFilter#setTransformer(ElementTransformer)}
   *   <li>{@link TransformAndFilter#getFilter()}
   *   <li>{@link TransformAndFilter#getTransformer()}
   * </ul>
   */
  @Test
  void testGettersAndSetters3() {
    // Arrange
    ElementTransformer transformer = new ElementTransformer();

    // Act
    TransformAndFilter actualTransformAndFilter = new TransformAndFilter(transformer, new ElementFilter());
    ElementFilter filter = new ElementFilter();
    actualTransformAndFilter.setFilter(filter);
    ElementTransformer transformer2 = new ElementTransformer();
    actualTransformAndFilter.setTransformer(transformer2);
    ElementFilter actualFilter = actualTransformAndFilter.getFilter();
    ElementTransformer actualTransformer = actualTransformAndFilter.getTransformer();

    // Assert that nothing has changed
    assertTrue(actualFilter.getComponents().isEmpty());
    assertSame(filter, actualFilter);
    assertSame(transformer2, actualTransformer);
  }
}
