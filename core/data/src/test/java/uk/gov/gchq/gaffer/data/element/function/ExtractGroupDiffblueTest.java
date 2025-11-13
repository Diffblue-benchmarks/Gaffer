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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.data.element.Edge;
import uk.gov.gchq.gaffer.data.element.Element;

class ExtractGroupDiffblueTest {
  /**
   * Test {@link ExtractGroup#apply(Element)} with {@code Element}.
   *
   * <ul>
   *   <li>When {@link Edge#Edge(String)} with {@code Group}.
   *   <li>Then return {@code Group}.
   * </ul>
   *
   * <p>Method under test: {@link ExtractGroup#apply(Element)}
   */
  @Test
  @DisplayName(
      "Test apply(Element) with 'Element'; when Edge(String) with 'Group'; then return 'Group'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ExtractGroup.apply(Element)"})
  void testApplyWithElement_whenEdgeWithGroup_thenReturnGroup() {
    // Arrange
    ExtractGroup extractGroup = new ExtractGroup();

    // Act
    String actualApplyResult = extractGroup.apply(new Edge("Group"));

    // Assert
    assertEquals("Group", actualApplyResult);
  }

  /**
   * Test {@link ExtractGroup#apply(Element)} with {@code Element}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ExtractGroup#apply(Element)}
   */
  @Test
  @DisplayName("Test apply(Element) with 'Element'; when 'null'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ExtractGroup.apply(Element)"})
  void testApplyWithElement_whenNull_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new ExtractGroup().apply(null));
  }
}
