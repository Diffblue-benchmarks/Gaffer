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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.data.element.id.ElementId;
import uk.gov.gchq.gaffer.operation.data.EdgeSeed;
import uk.gov.gchq.gaffer.operation.data.EntitySeed;

class ToElementIdDiffblueTest {
  /**
   * Test {@link ToElementId#apply(Object)}.
   *
   * <ul>
   *   <li>When {@link EdgeSeed#EdgeSeed()}.
   *   <li>Then return {@link EdgeSeed#EdgeSeed()}.
   * </ul>
   *
   * <p>Method under test: {@link ToElementId#apply(Object)}
   */
  @Test
  @DisplayName("Test apply(Object); when EdgeSeed(); then return EdgeSeed()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ElementId ToElementId.apply(Object)"})
  void testApply_whenEdgeSeed_thenReturnEdgeSeed() {
    // Arrange
    ToElementId toElementId = new ToElementId();
    EdgeSeed edgeSeed = new EdgeSeed();

    // Act
    ElementId actualApplyResult = toElementId.apply(edgeSeed);

    // Assert
    assertSame(edgeSeed, actualApplyResult);
  }

  /**
   * Test {@link ToElementId#apply(Object)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ToElementId#apply(Object)}
   */
  @Test
  @DisplayName("Test apply(Object); when 'null'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ElementId ToElementId.apply(Object)"})
  void testApply_whenNull_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new ToElementId().apply(null));
  }

  /**
   * Test {@link ToElementId#apply(Object)}.
   *
   * <ul>
   *   <li>When {@code Obj}.
   *   <li>Then return {@link EntitySeed}.
   * </ul>
   *
   * <p>Method under test: {@link ToElementId#apply(Object)}
   */
  @Test
  @DisplayName("Test apply(Object); when 'Obj'; then return EntitySeed")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ElementId ToElementId.apply(Object)"})
  void testApply_whenObj_thenReturnEntitySeed() {
    // Arrange and Act
    ElementId actualApplyResult = new ToElementId().apply("Obj");

    // Assert
    assertTrue(actualApplyResult instanceof EntitySeed);
    assertEquals("Obj", ((EntitySeed) actualApplyResult).getVertex());
    assertEquals("uk.gov.gchq.gaffer.operation.data.EntitySeed", actualApplyResult.getClassName());
  }
}
