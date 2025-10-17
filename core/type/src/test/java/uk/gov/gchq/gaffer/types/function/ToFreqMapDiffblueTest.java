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

package uk.gov.gchq.gaffer.types.function;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.types.FreqMap;

class ToFreqMapDiffblueTest {
  /**
   * Test {@link ToFreqMap#apply(Object)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code null} longValue is one.
   * </ul>
   *
   * <p>Method under test: {@link ToFreqMap#apply(Object)}
   */
  @Test
  @DisplayName("Test apply(Object); when 'null'; then return 'null' longValue is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"FreqMap ToFreqMap.apply(Object)"})
  void testApply_whenNull_thenReturnNullLongValueIsOne() {
    // Arrange and Act
    FreqMap actualApplyResult = new ToFreqMap().apply(null);

    // Assert
    assertEquals(1, actualApplyResult.size());
    assertEquals(1L, actualApplyResult.get(null).longValue());
  }

  /**
   * Test {@link ToFreqMap#apply(Object)}.
   *
   * <ul>
   *   <li>When {@code Value}.
   *   <li>Then return {@code Value} longValue is one.
   * </ul>
   *
   * <p>Method under test: {@link ToFreqMap#apply(Object)}
   */
  @Test
  @DisplayName("Test apply(Object); when 'Value'; then return 'Value' longValue is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"FreqMap ToFreqMap.apply(Object)"})
  void testApply_whenValue_thenReturnValueLongValueIsOne() {
    // Arrange and Act
    FreqMap actualApplyResult = new ToFreqMap().apply("Value");

    // Assert
    assertEquals(1, actualApplyResult.size());
    assertEquals(1L, actualApplyResult.get("Value").longValue());
  }
}
