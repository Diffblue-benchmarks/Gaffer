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
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.time.CommonTimeUtil;
import uk.gov.gchq.gaffer.time.CommonTimeUtil.TimeBucket;
import uk.gov.gchq.gaffer.time.RBMBackedTimestampSet;

class RBMBackedTimestampSetAggregatorDiffblueTest {
  /**
   * Test {@link RBMBackedTimestampSetAggregator#_apply(RBMBackedTimestampSet, RBMBackedTimestampSet)} with {@code RBMBackedTimestampSet}, {@code RBMBackedTimestampSet}.
   * <p>
   * Method under test: {@link RBMBackedTimestampSetAggregator#_apply(RBMBackedTimestampSet, RBMBackedTimestampSet)}
   */
  @Test
  @DisplayName("Test _apply(RBMBackedTimestampSet, RBMBackedTimestampSet) with 'RBMBackedTimestampSet', 'RBMBackedTimestampSet'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "RBMBackedTimestampSet RBMBackedTimestampSetAggregator._apply(RBMBackedTimestampSet, RBMBackedTimestampSet)"})
  void test_applyWithRBMBackedTimestampSetRBMBackedTimestampSet() {
    // Arrange
    RBMBackedTimestampSetAggregator rbmBackedTimestampSetAggregator = new RBMBackedTimestampSetAggregator();
    RBMBackedTimestampSet a = new RBMBackedTimestampSet(TimeBucket.SECOND);

    // Act and Assert
    assertSame(a, rbmBackedTimestampSetAggregator._apply(a, new RBMBackedTimestampSet(TimeBucket.SECOND)));
  }

  /**
   * Test {@link RBMBackedTimestampSetAggregator#_apply(RBMBackedTimestampSet, RBMBackedTimestampSet)} with {@code RBMBackedTimestampSet}, {@code RBMBackedTimestampSet}.
   * <p>
   * Method under test: {@link RBMBackedTimestampSetAggregator#_apply(RBMBackedTimestampSet, RBMBackedTimestampSet)}
   */
  @Test
  @DisplayName("Test _apply(RBMBackedTimestampSet, RBMBackedTimestampSet) with 'RBMBackedTimestampSet', 'RBMBackedTimestampSet'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "RBMBackedTimestampSet RBMBackedTimestampSetAggregator._apply(RBMBackedTimestampSet, RBMBackedTimestampSet)"})
  void test_applyWithRBMBackedTimestampSetRBMBackedTimestampSet2() {
    // Arrange
    RBMBackedTimestampSetAggregator rbmBackedTimestampSetAggregator = new RBMBackedTimestampSetAggregator();
    RBMBackedTimestampSet a = new RBMBackedTimestampSet(TimeBucket.MINUTE);

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> rbmBackedTimestampSetAggregator._apply(a, new RBMBackedTimestampSet(TimeBucket.SECOND)));
  }
}
