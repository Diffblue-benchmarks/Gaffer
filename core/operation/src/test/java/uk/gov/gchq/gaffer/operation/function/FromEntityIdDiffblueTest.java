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

package uk.gov.gchq.gaffer.operation.function;

import static org.junit.jupiter.api.Assertions.assertNull;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.data.element.id.EntityId;
import uk.gov.gchq.gaffer.operation.data.EntitySeed;

class FromEntityIdDiffblueTest {
  /**
   * Test {@link FromEntityId#apply(EntityId)} with {@code EntityId}.
   *
   * <ul>
   *   <li>When {@link EntitySeed#EntitySeed()}.
   * </ul>
   *
   * <p>Method under test: {@link FromEntityId#apply(EntityId)}
   */
  @Test
  @DisplayName("Test apply(EntityId) with 'EntityId'; when EntitySeed()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.Object FromEntityId.apply(EntityId)"})
  void testApplyWithEntityId_whenEntitySeed() {
    // Arrange
    FromEntityId fromEntityId = new FromEntityId();

    // Act and Assert
    assertNull(fromEntityId.apply(new EntitySeed()));
  }

  /**
   * Test {@link FromEntityId#apply(EntityId)} with {@code EntityId}.
   *
   * <ul>
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link FromEntityId#apply(EntityId)}
   */
  @Test
  @DisplayName("Test apply(EntityId) with 'EntityId'; when 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.Object FromEntityId.apply(EntityId)"})
  void testApplyWithEntityId_whenNull() {
    // Arrange, Act and Assert
    assertNull(new FromEntityId().apply(null));
  }
}
