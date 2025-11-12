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

package uk.gov.gchq.gaffer.data.element.comparison;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class ComparableOrToStringComparatorDiffblueTest {
  /**
   * Method under test:
   * {@link ComparableOrToStringComparator#compare(Object, Object)}
   */
  @Test
  void testCompare() {
    // Arrange, Act and Assert
    assertEquals(-1, (new ComparableOrToStringComparator()).compare("Vertex1", "Vertex2"));
    assertEquals(30, (new ComparableOrToStringComparator()).compare(true, "Vertex2"));
  }
}
