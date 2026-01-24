/*
 * Copyright 2026 Crown Copyright
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
import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.data.element.id.ElementId;
import uk.gov.gchq.gaffer.operation.data.EdgeSeed;
import uk.gov.gchq.gaffer.operation.data.EntitySeed;

class FromElementIdDiffblueTest {
  /**
   * Test {@link FromElementId#apply(ElementId)} with {@code ElementId}.
   *
   * <ul>
   *   <li>When {@link EdgeSeed#EdgeSeed()}.
   *   <li>Then return {@link EdgeSeed#EdgeSeed()}.
   * </ul>
   *
   * <p>Method under test: {@link FromElementId#apply(ElementId)}
   */
  @Test
  @DisplayName("Test apply(ElementId) with 'ElementId'; when EdgeSeed(); then return EdgeSeed()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object FromElementId.apply(ElementId)"})
  void testApplyWithElementId_whenEdgeSeed_thenReturnEdgeSeed() {
    // Arrange
    FromElementId fromElementId = new FromElementId();
    EdgeSeed e = new EdgeSeed();

    // Act
    Object actualApplyResult = fromElementId.apply(e);

    // Assert
    assertSame(e, actualApplyResult);
  }

  /**
   * Test {@link FromElementId#apply(ElementId)} with {@code ElementId}.
   *
   * <ul>
   *   <li>When {@link EntitySeed#EntitySeed()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link FromElementId#apply(ElementId)}
   */
  @Test
  @DisplayName("Test apply(ElementId) with 'ElementId'; when EntitySeed(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object FromElementId.apply(ElementId)"})
  void testApplyWithElementId_whenEntitySeed_thenReturnNull() {
    // Arrange
    FromElementId fromElementId = new FromElementId();

    // Act and Assert
    assertNull(fromElementId.apply(new EntitySeed()));
  }

  /**
   * Test {@link FromElementId#apply(ElementId)} with {@code ElementId}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link FromElementId#apply(ElementId)}
   */
  @Test
  @DisplayName("Test apply(ElementId) with 'ElementId'; when 'null'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object FromElementId.apply(ElementId)"})
  void testApplyWithElementId_whenNull_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new FromElementId().apply(null));
  }
}
