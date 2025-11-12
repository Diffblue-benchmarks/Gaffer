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
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.types.FreqMap;

class ToFreqMapDiffblueTest {
  /**
   * Method under test: {@link ToFreqMap#apply(Object)}
   */
  @Test
  void testApply() {
    // Arrange and Act
    FreqMap actualApplyResult = (new ToFreqMap()).apply("Value");

    // Assert
    assertEquals(1, actualApplyResult.size());
    assertEquals(1L, actualApplyResult.get("Value").longValue());
  }

  /**
   * Method under test: {@link ToFreqMap#apply(Object)}
   */
  @Test
  void testApply2() {
    // Arrange and Act
    FreqMap actualApplyResult = (new ToFreqMap()).apply(null);

    // Assert
    assertEquals(1, actualApplyResult.size());
    assertEquals(1L, actualApplyResult.get(null).longValue());
  }
}
