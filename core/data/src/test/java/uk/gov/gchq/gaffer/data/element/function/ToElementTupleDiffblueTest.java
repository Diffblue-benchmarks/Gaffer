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

package uk.gov.gchq.gaffer.data.element.function;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.data.element.Edge;
import uk.gov.gchq.gaffer.data.element.Element;

class ToElementTupleDiffblueTest {
  /**
   * Test {@link ToElementTuple#apply(Element)} with {@code Element}.
   * <ul>
   *   <li>When {@link Edge#Edge(String)} with {@code Group}.</li>
   *   <li>Then return Element is {@link Edge#Edge(String)} with {@code Group}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ToElementTuple#apply(Element)}
   */
  @Test
  @DisplayName("Test apply(Element) with 'Element'; when Edge(String) with 'Group'; then return Element is Edge(String) with 'Group'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ElementTuple ToElementTuple.apply(Element)"})
  void testApplyWithElement_whenEdgeWithGroup_thenReturnElementIsEdgeWithGroup() {
    // Arrange
    ToElementTuple toElementTuple = new ToElementTuple();
    Edge element = new Edge("Group");

    // Act and Assert
    assertSame(element, toElementTuple.apply(element).getElement());
  }

  /**
   * Test {@link ToElementTuple#apply(Element)} with {@code Element}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ToElementTuple#apply(Element)}
   */
  @Test
  @DisplayName("Test apply(Element) with 'Element'; when 'null'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ElementTuple ToElementTuple.apply(Element)"})
  void testApplyWithElement_whenNull_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new ToElementTuple()).apply(null));
  }
}
