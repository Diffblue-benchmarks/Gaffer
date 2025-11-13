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
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.data.element.Edge;
import uk.gov.gchq.gaffer.data.element.Element;
import uk.gov.gchq.gaffer.data.element.Entity;

class ExampleDomainObjectGeneratorDiffblueTest {
  /**
   * Test {@link ExampleDomainObjectGenerator#_apply(Element)}.
   *
   * <ul>
   *   <li>When {@link Edge#Edge(String)} with {@code Group}.
   *   <li>Then return second element is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ExampleDomainObjectGenerator#_apply(Element)}
   */
  @Test
  @DisplayName(
      "Test _apply(Element); when Edge(String) with 'Group'; then return second element is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ExampleDomainObject ExampleDomainObjectGenerator._apply(Element)"})
  void test_apply_whenEdgeWithGroup_thenReturnSecondElementIsNull() {
    // Arrange
    ExampleDomainObjectGenerator exampleDomainObjectGenerator = new ExampleDomainObjectGenerator();

    // Act and Assert
    Object[] ids = exampleDomainObjectGenerator._apply(new Edge("Group")).getIds();
    assertNull(ids[1]);
    assertEquals(3, ids.length);
    assertFalse((Boolean) ids[2]);
  }

  /**
   * Test {@link ExampleDomainObjectGenerator#_apply(Element)}.
   *
   * <ul>
   *   <li>When {@link Entity#Entity(String)} with {@code Group}.
   *   <li>Then return Type is {@code Group}.
   * </ul>
   *
   * <p>Method under test: {@link ExampleDomainObjectGenerator#_apply(Element)}
   */
  @Test
  @DisplayName(
      "Test _apply(Element); when Entity(String) with 'Group'; then return Type is 'Group'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ExampleDomainObject ExampleDomainObjectGenerator._apply(Element)"})
  void test_apply_whenEntityWithGroup_thenReturnTypeIsGroup() {
    // Arrange
    ExampleDomainObjectGenerator exampleDomainObjectGenerator = new ExampleDomainObjectGenerator();

    // Act
    ExampleDomainObject actual_applyResult =
        exampleDomainObjectGenerator._apply(new Entity("Group"));

    // Assert
    assertEquals("Group", actual_applyResult.getType());
    Object[] ids = actual_applyResult.getIds();
    assertNull(ids[0]);
    assertEquals(1, ids.length);
  }
}
