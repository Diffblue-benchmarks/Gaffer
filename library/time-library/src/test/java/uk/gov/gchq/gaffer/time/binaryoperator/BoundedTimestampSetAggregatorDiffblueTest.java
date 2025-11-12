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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.time.LocalDate;
import java.time.ZoneOffset;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.time.BoundedTimestampSet;
import uk.gov.gchq.gaffer.time.CommonTimeUtil;

class BoundedTimestampSetAggregatorDiffblueTest {
  /**
   * Method under test:
   * {@link BoundedTimestampSetAggregator#_apply(BoundedTimestampSet, BoundedTimestampSet)}
   */
  @Test
  void test_apply() {
    // Arrange
    BoundedTimestampSetAggregator boundedTimestampSetAggregator = new BoundedTimestampSetAggregator();
    BoundedTimestampSet a = new BoundedTimestampSet(CommonTimeUtil.TimeBucket.SECOND, 3);

    // Act
    BoundedTimestampSet actual_applyResult = boundedTimestampSetAggregator._apply(a,
        new BoundedTimestampSet(CommonTimeUtil.TimeBucket.SECOND, 3));

    // Assert
    assertEquals(0L, a.getNumberOfTimestamps());
    assertTrue(a.getTimestamps().isEmpty());
    assertSame(a, actual_applyResult);
  }

  /**
   * Method under test:
   * {@link BoundedTimestampSetAggregator#_apply(BoundedTimestampSet, BoundedTimestampSet)}
   */
  @Test
  void test_apply2() {
    // Arrange
    BoundedTimestampSetAggregator boundedTimestampSetAggregator = new BoundedTimestampSetAggregator();
    BoundedTimestampSet a = new BoundedTimestampSet(CommonTimeUtil.TimeBucket.MINUTE, 3);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> boundedTimestampSetAggregator._apply(a, new BoundedTimestampSet(CommonTimeUtil.TimeBucket.SECOND, 3)));
  }

  /**
   * Method under test:
   * {@link BoundedTimestampSetAggregator#_apply(BoundedTimestampSet, BoundedTimestampSet)}
   */
  @Test
  void test_apply3() {
    // Arrange
    BoundedTimestampSetAggregator boundedTimestampSetAggregator = new BoundedTimestampSetAggregator();
    BoundedTimestampSet a = new BoundedTimestampSet(CommonTimeUtil.TimeBucket.SECOND, 1);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> boundedTimestampSetAggregator._apply(a, new BoundedTimestampSet(CommonTimeUtil.TimeBucket.SECOND, 3)));
  }

  /**
   * Method under test:
   * {@link BoundedTimestampSetAggregator#_apply(BoundedTimestampSet, BoundedTimestampSet)}
   */
  @Test
  void test_apply4() {
    // Arrange
    BoundedTimestampSetAggregator boundedTimestampSetAggregator = new BoundedTimestampSetAggregator();
    BoundedTimestampSet a = new BoundedTimestampSet(CommonTimeUtil.TimeBucket.SECOND, 3);

    BoundedTimestampSet b = new BoundedTimestampSet(CommonTimeUtil.TimeBucket.SECOND, 3);
    b.add(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Act
    BoundedTimestampSet actual_applyResult = boundedTimestampSetAggregator._apply(a, b);

    // Assert
    assertEquals(1, a.getTimestamps().size());
    assertEquals(1L, a.getNumberOfTimestamps());
    assertSame(a, actual_applyResult);
  }
}
