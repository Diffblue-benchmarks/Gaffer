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
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.time.LocalDate;
import java.time.ZoneOffset;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.time.CommonTimeUtil;
import uk.gov.gchq.gaffer.time.CommonTimeUtil.TimeBucket;
import uk.gov.gchq.gaffer.time.LongTimeSeries;

class LongTimeSeriesAggregatorDiffblueTest {
  /**
   * Test {@link LongTimeSeriesAggregator#_apply(LongTimeSeries, LongTimeSeries)} with {@code LongTimeSeries}, {@code LongTimeSeries}.
   * <p>
   * Method under test: {@link LongTimeSeriesAggregator#_apply(LongTimeSeries, LongTimeSeries)}
   */
  @Test
  @DisplayName("Test _apply(LongTimeSeries, LongTimeSeries) with 'LongTimeSeries', 'LongTimeSeries'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"LongTimeSeries LongTimeSeriesAggregator._apply(LongTimeSeries, LongTimeSeries)"})
  void test_applyWithLongTimeSeriesLongTimeSeries() {
    // Arrange
    LongTimeSeriesAggregator longTimeSeriesAggregator = new LongTimeSeriesAggregator();
    LongTimeSeries a = new LongTimeSeries(TimeBucket.SECOND);

    // Act
    longTimeSeriesAggregator._apply(a, new LongTimeSeries(TimeBucket.SECOND));

    // Assert that nothing has changed
    assertEquals(0, a.getNumberOfInstants());
    assertTrue(a.getTimeSeries().isEmpty());
    assertTrue(a.getInstants().isEmpty());
  }

  /**
   * Test {@link LongTimeSeriesAggregator#_apply(LongTimeSeries, LongTimeSeries)} with {@code LongTimeSeries}, {@code LongTimeSeries}.
   * <p>
   * Method under test: {@link LongTimeSeriesAggregator#_apply(LongTimeSeries, LongTimeSeries)}
   */
  @Test
  @DisplayName("Test _apply(LongTimeSeries, LongTimeSeries) with 'LongTimeSeries', 'LongTimeSeries'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"LongTimeSeries LongTimeSeriesAggregator._apply(LongTimeSeries, LongTimeSeries)"})
  void test_applyWithLongTimeSeriesLongTimeSeries2() {
    // Arrange
    LongTimeSeriesAggregator longTimeSeriesAggregator = new LongTimeSeriesAggregator();
    LongTimeSeries a = new LongTimeSeries(TimeBucket.SECOND);

    LongTimeSeries b = new LongTimeSeries(TimeBucket.SECOND);
    b.put(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant(), 42L);

    // Act
    longTimeSeriesAggregator._apply(a, b);

    // Assert
    assertEquals(1, a.getTimeSeries().size());
    assertEquals(1, a.getInstants().size());
    assertEquals(1, a.getNumberOfInstants());
  }

  /**
   * Test {@link LongTimeSeriesAggregator#_apply(LongTimeSeries, LongTimeSeries)} with {@code LongTimeSeries}, {@code LongTimeSeries}.
   * <p>
   * Method under test: {@link LongTimeSeriesAggregator#_apply(LongTimeSeries, LongTimeSeries)}
   */
  @Test
  @DisplayName("Test _apply(LongTimeSeries, LongTimeSeries) with 'LongTimeSeries', 'LongTimeSeries'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"LongTimeSeries LongTimeSeriesAggregator._apply(LongTimeSeries, LongTimeSeries)"})
  void test_applyWithLongTimeSeriesLongTimeSeries3() {
    // Arrange
    LongTimeSeriesAggregator longTimeSeriesAggregator = new LongTimeSeriesAggregator();

    LongTimeSeries a = new LongTimeSeries(TimeBucket.SECOND);
    a.put(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant(), 42L);

    LongTimeSeries b = new LongTimeSeries(TimeBucket.SECOND);
    b.put(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant(), 42L);

    // Act
    longTimeSeriesAggregator._apply(a, b);

    // Assert that nothing has changed
    assertEquals(1, a.getTimeSeries().size());
    assertEquals(1, a.getInstants().size());
    assertEquals(1, a.getNumberOfInstants());
  }

  /**
   * Test {@link LongTimeSeriesAggregator#_apply(LongTimeSeries, LongTimeSeries)} with {@code LongTimeSeries}, {@code LongTimeSeries}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LongTimeSeriesAggregator#_apply(LongTimeSeries, LongTimeSeries)}
   */
  @Test
  @DisplayName("Test _apply(LongTimeSeries, LongTimeSeries) with 'LongTimeSeries', 'LongTimeSeries'; then throw RuntimeException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"LongTimeSeries LongTimeSeriesAggregator._apply(LongTimeSeries, LongTimeSeries)"})
  void test_applyWithLongTimeSeriesLongTimeSeries_thenThrowRuntimeException() {
    // Arrange
    LongTimeSeriesAggregator longTimeSeriesAggregator = new LongTimeSeriesAggregator();
    LongTimeSeries a = new LongTimeSeries(TimeBucket.MINUTE);

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> longTimeSeriesAggregator._apply(a, new LongTimeSeries(TimeBucket.SECOND)));
  }
}
