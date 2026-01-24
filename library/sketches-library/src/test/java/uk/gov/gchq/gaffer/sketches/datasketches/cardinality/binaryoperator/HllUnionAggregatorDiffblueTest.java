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

package uk.gov.gchq.gaffer.sketches.datasketches.cardinality.binaryoperator;

import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.apache.datasketches.hll.Union;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class HllUnionAggregatorDiffblueTest {
  /**
   * Test {@link HllUnionAggregator#_apply(Union, Union)} with {@code Union}, {@code Union}.
   *
   * <ul>
   *   <li>When {@link Union#Union()}.
   *   <li>Then return {@link Union#Union()}.
   * </ul>
   *
   * <p>Method under test: {@link HllUnionAggregator#_apply(Union, Union)}
   */
  @Test
  @DisplayName("Test _apply(Union, Union) with 'Union', 'Union'; when Union(); then return Union()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Union HllUnionAggregator._apply(Union, Union)"})
  void test_applyWithUnionUnion_whenUnion_thenReturnUnion() {
    // Arrange
    HllUnionAggregator hllUnionAggregator = new HllUnionAggregator();
    Union a = new Union();

    // Act
    Union actual_applyResult = hllUnionAggregator._apply(a, new Union());

    // Assert
    assertSame(a, actual_applyResult);
  }
}
