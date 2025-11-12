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
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.types.FreqMap;

class IterableToFreqMapDiffblueTest {
  /**
   * Method under test: {@link IterableToFreqMap#apply(Iterable)}
   */
  @Test
  void testApply() {
    // Arrange
    IterableToFreqMap iterableToFreqMap = new IterableToFreqMap();

    // Act and Assert
    assertTrue(iterableToFreqMap.apply(new ArrayList<>()).isEmpty());
  }

  /**
   * Method under test: {@link IterableToFreqMap#apply(Iterable)}
   */
  @Test
  void testApply2() {
    // Arrange
    IterableToFreqMap iterableToFreqMap = new IterableToFreqMap();

    LinkedHashSet<String> strings = new LinkedHashSet<>();
    strings.add("Strings");

    // Act
    FreqMap actualApplyResult = iterableToFreqMap.apply(strings);

    // Assert
    assertEquals(1, actualApplyResult.size());
    assertEquals(1L, actualApplyResult.get("Strings").longValue());
  }
}
