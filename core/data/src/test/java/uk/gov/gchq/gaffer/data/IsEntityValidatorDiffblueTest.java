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
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.data.element.Edge;
import uk.gov.gchq.gaffer.data.element.Element;
import uk.gov.gchq.gaffer.data.element.Entity;

class IsEntityValidatorDiffblueTest {
  /**
   * Test {@link IsEntityValidator#validate(Element)} with {@code Element}.
   *
   * <ul>
   *   <li>When {@link Edge#Edge(String)} with {@code Group}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link IsEntityValidator#validate(Element)}
   */
  @Test
  @DisplayName(
      "Test validate(Element) with 'Element'; when Edge(String) with 'Group'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean IsEntityValidator.validate(Element)"})
  void testValidateWithElement_whenEdgeWithGroup_thenReturnFalse() {
    // Arrange
    IsEntityValidator isEntityValidator = new IsEntityValidator();

    // Act
    boolean actualValidateResult = isEntityValidator.validate(new Edge("Group"));

    // Assert
    assertFalse(actualValidateResult);
  }

  /**
   * Test {@link IsEntityValidator#validate(Element)} with {@code Element}.
   *
   * <ul>
   *   <li>When {@link Entity#Entity(String)} with {@code Group}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link IsEntityValidator#validate(Element)}
   */
  @Test
  @DisplayName(
      "Test validate(Element) with 'Element'; when Entity(String) with 'Group'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean IsEntityValidator.validate(Element)"})
  void testValidateWithElement_whenEntityWithGroup_thenReturnTrue() {
    // Arrange
    IsEntityValidator isEntityValidator = new IsEntityValidator();

    // Act
    boolean actualValidateResult = isEntityValidator.validate(new Entity("Group"));

    // Assert
    assertTrue(actualValidateResult);
  }
}
