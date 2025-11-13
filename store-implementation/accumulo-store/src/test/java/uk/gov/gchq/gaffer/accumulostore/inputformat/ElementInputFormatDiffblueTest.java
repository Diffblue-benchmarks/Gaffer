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

package uk.gov.gchq.gaffer.accumulostore.inputformat;

import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.data.element.Edge;
import uk.gov.gchq.gaffer.data.element.Element;
import uk.gov.gchq.gaffer.data.element.function.ElementFilter;
import uk.gov.gchq.gaffer.data.elementdefinition.view.View;

class ElementInputFormatDiffblueTest {
  /**
   * Test {@link ElementInputFormat#doPostFilter(Element, View)}.
   * <ul>
   *   <li>When {@link Edge#Edge(String)} with {@code Group}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ElementInputFormat#doPostFilter(Element, View)}
   */
  @Test
  @DisplayName("Test doPostFilter(Element, View); when Edge(String) with 'Group'; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ElementInputFormat.doPostFilter(Element, View)"})
  void testDoPostFilter_whenEdgeWithGroup_thenReturnTrue() {
    // Arrange
    Edge element = new Edge("Group");

    // Act and Assert
    assertTrue(ElementInputFormat.doPostFilter(element, new View()));
  }

  /**
   * Test {@link ElementInputFormat#postFilter(Element, ElementFilter)}.
   * <ul>
   *   <li>When {@link ElementFilter} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link ElementInputFormat#postFilter(Element, ElementFilter)}
   */
  @Test
  @DisplayName("Test postFilter(Element, ElementFilter); when ElementFilter (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ElementInputFormat.postFilter(Element, ElementFilter)"})
  void testPostFilter_whenElementFilter() {
    // Arrange
    Edge element = new Edge("Group");

    // Act and Assert
    assertTrue(ElementInputFormat.postFilter(element, new ElementFilter()));
  }

  /**
   * Test {@link ElementInputFormat#postFilter(Element, ElementFilter)}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ElementInputFormat#postFilter(Element, ElementFilter)}
   */
  @Test
  @DisplayName("Test postFilter(Element, ElementFilter); when 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ElementInputFormat.postFilter(Element, ElementFilter)"})
  void testPostFilter_whenNull() {
    // Arrange, Act and Assert
    assertTrue(ElementInputFormat.postFilter(new Edge("Group"), null));
  }
}
