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
import uk.gov.gchq.gaffer.time.CommonTimeUtil;
import uk.gov.gchq.gaffer.time.LongTimeSeries;

class LongTimeSeriesAggregatorDiffblueTest {
  /**
   * Method under test:
   * {@link LongTimeSeriesAggregator#_apply(LongTimeSeries, LongTimeSeries)}
   */
  @Test
  void test_apply() {
    // Arrange
    LongTimeSeriesAggregator longTimeSeriesAggregator = new LongTimeSeriesAggregator();
    LongTimeSeries a = new LongTimeSeries(CommonTimeUtil.TimeBucket.SECOND);

    // Act
    LongTimeSeries actual_applyResult = longTimeSeriesAggregator._apply(a,
        new LongTimeSeries(CommonTimeUtil.TimeBucket.SECOND));

    // Assert
    assertEquals(0, a.getNumberOfInstants());
    assertTrue(a.getTimeSeries().isEmpty());
    assertTrue(a.getInstants().isEmpty());
    assertSame(a, actual_applyResult);
  }

  /**
   * Method under test:
   * {@link LongTimeSeriesAggregator#_apply(LongTimeSeries, LongTimeSeries)}
   */
  @Test
  void test_apply2() {
    // Arrange
    LongTimeSeriesAggregator longTimeSeriesAggregator = new LongTimeSeriesAggregator();
    LongTimeSeries a = new LongTimeSeries(CommonTimeUtil.TimeBucket.MINUTE);

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> longTimeSeriesAggregator._apply(a, new LongTimeSeries(CommonTimeUtil.TimeBucket.SECOND)));
  }

  /**
   * Method under test:
   * {@link LongTimeSeriesAggregator#_apply(LongTimeSeries, LongTimeSeries)}
   */
  @Test
  void test_apply3() {
    // Arrange
    LongTimeSeriesAggregator longTimeSeriesAggregator = new LongTimeSeriesAggregator();
    LongTimeSeries a = new LongTimeSeries(CommonTimeUtil.TimeBucket.SECOND);

    LongTimeSeries b = new LongTimeSeries(CommonTimeUtil.TimeBucket.SECOND);
    b.put(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant(), 42L);

    // Act
    LongTimeSeries actual_applyResult = longTimeSeriesAggregator._apply(a, b);

    // Assert
    assertEquals(1, a.getTimeSeries().size());
    assertEquals(1, a.getInstants().size());
    assertEquals(1, a.getNumberOfInstants());
    assertSame(a, actual_applyResult);
  }

  /**
   * Method under test:
   * {@link LongTimeSeriesAggregator#_apply(LongTimeSeries, LongTimeSeries)}
   */
  @Test
  void test_apply4() {
    // Arrange
    LongTimeSeriesAggregator longTimeSeriesAggregator = new LongTimeSeriesAggregator();

    LongTimeSeries a = new LongTimeSeries(CommonTimeUtil.TimeBucket.SECOND);
    a.put(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant(), 42L);

    LongTimeSeries b = new LongTimeSeries(CommonTimeUtil.TimeBucket.SECOND);
    b.put(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant(), 42L);

    // Act
    LongTimeSeries actual_applyResult = longTimeSeriesAggregator._apply(a, b);

    // Assert
    assertEquals(1, a.getTimeSeries().size());
    assertEquals(1, a.getInstants().size());
    assertEquals(1, a.getNumberOfInstants());
    assertSame(a, actual_applyResult);
  }

  /**
   * Method under test:
   * {@link LongTimeSeriesAggregator#_apply(LongTimeSeries, LongTimeSeries)}
   */
  @Test
  void test_apply5() {
    // Arrange
    LongTimeSeriesAggregator longTimeSeriesAggregator = new LongTimeSeriesAggregator();
    LongTimeSeries a = new LongTimeSeries(CommonTimeUtil.TimeBucket.SECOND);

    LongTimeSeries b = new LongTimeSeries(CommonTimeUtil.TimeBucket.SECOND);
    b.put(LocalDate.now().atStartOfDay().atZone(ZoneOffset.UTC).toInstant(), 1L);
    b.put(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant(), 42L);

    // Act and Assert
    assertSame(a, longTimeSeriesAggregator._apply(a, b));
  }
}
