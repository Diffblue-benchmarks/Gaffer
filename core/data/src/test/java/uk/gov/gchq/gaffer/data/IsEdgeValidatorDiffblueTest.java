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

package uk.gov.gchq.gaffer.data;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.data.element.Edge;
import uk.gov.gchq.gaffer.data.element.Element;

class IsEdgeValidatorDiffblueTest {
  /**
   * Test {@link IsEdgeValidator#validate(Element)} with {@code Element}.
   * <ul>
   *   <li>When {@link Edge#Edge(String)} with {@code Group}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link IsEdgeValidator#validate(Element)}
   */
  @Test
  @DisplayName("Test validate(Element) with 'Element'; when Edge(String) with 'Group'; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean IsEdgeValidator.validate(Element)"})
  void testValidateWithElement_whenEdgeWithGroup_thenReturnTrue() {
    // Arrange
    IsEdgeValidator isEdgeValidator = new IsEdgeValidator();

    // Act and Assert
    assertTrue(isEdgeValidator.validate(new Edge("Group")));
  }

  /**
   * Test {@link IsEdgeValidator#validate(Element)} with {@code Element}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link IsEdgeValidator#validate(Element)}
   */
  @Test
  @DisplayName("Test validate(Element) with 'Element'; when 'null'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean IsEdgeValidator.validate(Element)"})
  void testValidateWithElement_whenNull_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new IsEdgeValidator()).validate(null));
  }
}
