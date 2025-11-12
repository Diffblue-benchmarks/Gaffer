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

package uk.gov.gchq.gaffer.sketches.datasketches.cardinality.binaryoperator;

import static org.junit.jupiter.api.Assertions.assertSame;
import org.apache.datasketches.hll.Union;
import org.junit.jupiter.api.Test;

class HllUnionAggregatorDiffblueTest {
  /**
   * Method under test: {@link HllUnionAggregator#_apply(Union, Union)}
   */
  @Test
  void test_apply() {
    // Arrange
    HllUnionAggregator hllUnionAggregator = new HllUnionAggregator();
    Union a = new Union();

    // Act and Assert
    assertSame(a, hllUnionAggregator._apply(a, new Union()));
  }
}
