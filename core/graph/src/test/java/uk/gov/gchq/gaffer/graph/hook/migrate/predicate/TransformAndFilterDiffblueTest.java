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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.data.element.Edge;
import uk.gov.gchq.gaffer.data.element.Element;
import uk.gov.gchq.gaffer.data.element.function.ElementFilter;
import uk.gov.gchq.gaffer.data.element.function.ElementFilter.Builder;
import uk.gov.gchq.gaffer.data.element.function.ElementTransformer;

class TransformAndFilterDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TransformAndFilter#TransformAndFilter()}
   *   <li>{@link TransformAndFilter#setFilter(ElementFilter)}
   *   <li>{@link TransformAndFilter#setTransformer(ElementTransformer)}
   *   <li>{@link TransformAndFilter#toString()}
   *   <li>{@link TransformAndFilter#getFilter()}
   *   <li>{@link TransformAndFilter#getTransformer()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TransformAndFilter.<init>()", "void TransformAndFilter.<init>(ElementFilter)",
      "void TransformAndFilter.<init>(ElementTransformer, ElementFilter)",
      "ElementFilter TransformAndFilter.getFilter()", "ElementTransformer TransformAndFilter.getTransformer()",
      "void TransformAndFilter.setFilter(ElementFilter)", "void TransformAndFilter.setTransformer(ElementTransformer)",
      "String TransformAndFilter.toString()"})
  void testGettersAndSetters() {
    // Arrange and Act
    TransformAndFilter actualTransformAndFilter = new TransformAndFilter();
    ElementFilter filter = (new Builder()).build();
    actualTransformAndFilter.setFilter(filter);
    ElementTransformer transformer = (new ElementTransformer.Builder()).build();
    actualTransformAndFilter.setTransformer(transformer);
    String actualToStringResult = actualTransformAndFilter.toString();
    ElementFilter actualFilter = actualTransformAndFilter.getFilter();
    ElementTransformer actualTransformer = actualTransformAndFilter.getTransformer();

    // Assert
    assertEquals("TransformAndFilter[transformer=ElementTransformer[elementTuple=ElementTuple[]],filter=ElementFilter"
        + "[elementTuple=ElementTuple[]]]", actualToStringResult);
    assertTrue(actualFilter.getComponents().isEmpty());
    assertSame(filter, actualFilter);
    assertSame(transformer, actualTransformer);
  }

  /**
   * Test getters and setters.
   * <ul>
   *   <li>When {@link Builder#Builder()} build.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TransformAndFilter#TransformAndFilter(ElementFilter)}
   *   <li>{@link TransformAndFilter#setFilter(ElementFilter)}
   *   <li>{@link TransformAndFilter#setTransformer(ElementTransformer)}
   *   <li>{@link TransformAndFilter#toString()}
   *   <li>{@link TransformAndFilter#getFilter()}
   *   <li>{@link TransformAndFilter#getTransformer()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; when Builder() build")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TransformAndFilter.<init>()", "void TransformAndFilter.<init>(ElementFilter)",
      "void TransformAndFilter.<init>(ElementTransformer, ElementFilter)",
      "ElementFilter TransformAndFilter.getFilter()", "ElementTransformer TransformAndFilter.getTransformer()",
      "void TransformAndFilter.setFilter(ElementFilter)", "void TransformAndFilter.setTransformer(ElementTransformer)",
      "String TransformAndFilter.toString()"})
  void testGettersAndSetters_whenBuilderBuild() {
    // Arrange
    ElementFilter filter = (new Builder()).build();

    // Act
    TransformAndFilter actualTransformAndFilter = new TransformAndFilter(filter);
    ElementFilter filter2 = (new Builder()).build();
    actualTransformAndFilter.setFilter(filter2);
    ElementTransformer transformer = (new ElementTransformer.Builder()).build();
    actualTransformAndFilter.setTransformer(transformer);
    String actualToStringResult = actualTransformAndFilter.toString();
    ElementFilter actualFilter = actualTransformAndFilter.getFilter();
    ElementTransformer actualTransformer = actualTransformAndFilter.getTransformer();

    // Assert
    assertEquals("TransformAndFilter[transformer=ElementTransformer[elementTuple=ElementTuple[]],filter=ElementFilter"
        + "[elementTuple=ElementTuple[]]]", actualToStringResult);
    assertTrue(actualFilter.getComponents().isEmpty());
    assertSame(filter2, actualFilter);
    assertSame(transformer, actualTransformer);
  }

  /**
   * Test getters and setters.
   * <ul>
   *   <li>When {@link ElementTransformer.Builder#Builder()} build.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TransformAndFilter#TransformAndFilter(ElementTransformer, ElementFilter)}
   *   <li>{@link TransformAndFilter#setFilter(ElementFilter)}
   *   <li>{@link TransformAndFilter#setTransformer(ElementTransformer)}
   *   <li>{@link TransformAndFilter#toString()}
   *   <li>{@link TransformAndFilter#getFilter()}
   *   <li>{@link TransformAndFilter#getTransformer()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; when Builder() build")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TransformAndFilter.<init>()", "void TransformAndFilter.<init>(ElementFilter)",
      "void TransformAndFilter.<init>(ElementTransformer, ElementFilter)",
      "ElementFilter TransformAndFilter.getFilter()", "ElementTransformer TransformAndFilter.getTransformer()",
      "void TransformAndFilter.setFilter(ElementFilter)", "void TransformAndFilter.setTransformer(ElementTransformer)",
      "String TransformAndFilter.toString()"})
  void testGettersAndSetters_whenBuilderBuild2() {
    // Arrange
    ElementTransformer transformer = (new ElementTransformer.Builder()).build();
    ElementFilter filter = (new Builder()).build();

    // Act
    TransformAndFilter actualTransformAndFilter = new TransformAndFilter(transformer, filter);
    ElementFilter filter2 = (new Builder()).build();
    actualTransformAndFilter.setFilter(filter2);
    ElementTransformer transformer2 = (new ElementTransformer.Builder()).build();
    actualTransformAndFilter.setTransformer(transformer2);
    String actualToStringResult = actualTransformAndFilter.toString();
    ElementFilter actualFilter = actualTransformAndFilter.getFilter();
    ElementTransformer actualTransformer = actualTransformAndFilter.getTransformer();

    // Assert
    assertEquals("TransformAndFilter[transformer=ElementTransformer[elementTuple=ElementTuple[]],filter=ElementFilter"
        + "[elementTuple=ElementTuple[]]]", actualToStringResult);
    assertTrue(actualFilter.getComponents().isEmpty());
    assertSame(filter2, actualFilter);
    assertSame(transformer2, actualTransformer);
  }

  /**
   * Test {@link TransformAndFilter#test(Element)} with {@code Element}.
   * <ul>
   *   <li>Given {@link TransformAndFilter#TransformAndFilter()} Filter is {@link ElementFilter} (default constructor).</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TransformAndFilter#test(Element)}
   */
  @Test
  @DisplayName("Test test(Element) with 'Element'; given TransformAndFilter() Filter is ElementFilter (default constructor); then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TransformAndFilter.test(Element)"})
  void testTestWithElement_givenTransformAndFilterFilterIsElementFilter_thenReturnTrue() {
    // Arrange
    TransformAndFilter transformAndFilter = new TransformAndFilter();
    transformAndFilter.setFilter(new ElementFilter());
    transformAndFilter.setTransformer(null);

    // Act and Assert
    assertTrue(transformAndFilter.test(new Edge("Group")));
  }

  /**
   * Test {@link TransformAndFilter#test(Element)} with {@code Element}.
   * <ul>
   *   <li>Given {@link TransformAndFilter#TransformAndFilter()} Filter is {@code null}.</li>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TransformAndFilter#test(Element)}
   */
  @Test
  @DisplayName("Test test(Element) with 'Element'; given TransformAndFilter() Filter is 'null'; when 'null'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TransformAndFilter.test(Element)"})
  void testTestWithElement_givenTransformAndFilterFilterIsNull_whenNull_thenReturnFalse() {
    // Arrange
    TransformAndFilter transformAndFilter = new TransformAndFilter();
    transformAndFilter.setFilter(null);
    transformAndFilter.setTransformer(null);

    // Act and Assert
    assertFalse(transformAndFilter.test(null));
  }

  /**
   * Test {@link TransformAndFilter#test(Element)} with {@code Element}.
   * <ul>
   *   <li>Given {@link TransformAndFilter#TransformAndFilter()} Transformer is {@link ElementTransformer} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link TransformAndFilter#test(Element)}
   */
  @Test
  @DisplayName("Test test(Element) with 'Element'; given TransformAndFilter() Transformer is ElementTransformer (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TransformAndFilter.test(Element)"})
  void testTestWithElement_givenTransformAndFilterTransformerIsElementTransformer() {
    // Arrange
    TransformAndFilter transformAndFilter = new TransformAndFilter();
    transformAndFilter.setFilter(new ElementFilter());
    transformAndFilter.setTransformer(new ElementTransformer());

    // Act and Assert
    assertTrue(transformAndFilter.test(new Edge("Group")));
  }

  /**
   * Test {@link TransformAndFilter#test(Element)} with {@code Element}.
   * <ul>
   *   <li>Given {@link TransformAndFilter#TransformAndFilter()}.</li>
   *   <li>When {@link Edge#Edge(String)} with {@code Group}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TransformAndFilter#test(Element)}
   */
  @Test
  @DisplayName("Test test(Element) with 'Element'; given TransformAndFilter(); when Edge(String) with 'Group'; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TransformAndFilter.test(Element)"})
  void testTestWithElement_givenTransformAndFilter_whenEdgeWithGroup_thenReturnTrue() {
    // Arrange
    TransformAndFilter transformAndFilter = new TransformAndFilter();

    // Act and Assert
    assertTrue(transformAndFilter.test(new Edge("Group")));
  }
}
