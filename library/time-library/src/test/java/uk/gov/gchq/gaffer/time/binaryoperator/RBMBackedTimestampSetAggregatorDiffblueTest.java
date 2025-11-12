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

package uk.gov.gchq.gaffer.time.binaryoperator;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.time.CommonTimeUtil;
import uk.gov.gchq.gaffer.time.RBMBackedTimestampSet;

class RBMBackedTimestampSetAggregatorDiffblueTest {
  /**
   * Method under test:
   * {@link RBMBackedTimestampSetAggregator#_apply(RBMBackedTimestampSet, RBMBackedTimestampSet)}
   */
  @Test
  void test_apply() {
    // Arrange
    RBMBackedTimestampSetAggregator rbmBackedTimestampSetAggregator = new RBMBackedTimestampSetAggregator();
    RBMBackedTimestampSet a = new RBMBackedTimestampSet(CommonTimeUtil.TimeBucket.SECOND);

    // Act and Assert
    assertSame(a,
        rbmBackedTimestampSetAggregator._apply(a, new RBMBackedTimestampSet(CommonTimeUtil.TimeBucket.SECOND)));
  }

  /**
   * Method under test:
   * {@link RBMBackedTimestampSetAggregator#_apply(RBMBackedTimestampSet, RBMBackedTimestampSet)}
   */
  @Test
  void test_apply2() {
    // Arrange
    RBMBackedTimestampSetAggregator rbmBackedTimestampSetAggregator = new RBMBackedTimestampSetAggregator();
    RBMBackedTimestampSet a = new RBMBackedTimestampSet(CommonTimeUtil.TimeBucket.MINUTE);

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> rbmBackedTimestampSetAggregator._apply(a, new RBMBackedTimestampSet(CommonTimeUtil.TimeBucket.SECOND)));
  }
}
