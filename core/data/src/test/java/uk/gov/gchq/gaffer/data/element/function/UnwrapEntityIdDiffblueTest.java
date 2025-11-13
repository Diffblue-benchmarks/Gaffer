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
import uk.gov.gchq.gaffer.data.element.Entity;

class UnwrapEntityIdDiffblueTest {
  /**
   * Test {@link UnwrapEntityId#apply(Object)}.
   *
   * <ul>
   *   <li>When {@link Entity#Entity(String)} with {@code Group}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link UnwrapEntityId#apply(Object)}
   */
  @Test
  @DisplayName("Test apply(Object); when Entity(String) with 'Group'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object UnwrapEntityId.apply(Object)"})
  void testApply_whenEntityWithGroup_thenReturnNull() {
    // Arrange
    UnwrapEntityId unwrapEntityId = new UnwrapEntityId();

    // Act
    Object actualApplyResult = unwrapEntityId.apply(new Entity("Group"));

    // Assert
    assertNull(actualApplyResult);
  }

  /**
   * Test {@link UnwrapEntityId#apply(Object)}.
   *
   * <ul>
   *   <li>When {@code Item}.
   *   <li>Then return {@code Item}.
   * </ul>
   *
   * <p>Method under test: {@link UnwrapEntityId#apply(Object)}
   */
  @Test
  @DisplayName("Test apply(Object); when 'Item'; then return 'Item'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object UnwrapEntityId.apply(Object)"})
  void testApply_whenItem_thenReturnItem() {
    // Arrange, Act and Assert
    assertEquals("Item", new UnwrapEntityId().apply("Item"));
  }

  /**
   * Test {@link UnwrapEntityId#apply(Object)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link UnwrapEntityId#apply(Object)}
   */
  @Test
  @DisplayName("Test apply(Object); when 'null'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object UnwrapEntityId.apply(Object)"})
  void testApply_whenNull_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new UnwrapEntityId().apply(null));
  }
}
