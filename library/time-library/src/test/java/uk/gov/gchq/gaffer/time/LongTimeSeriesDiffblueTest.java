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

package uk.gov.gchq.gaffer.time;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.time.CommonTimeUtil.TimeBucket;
import uk.gov.gchq.gaffer.time.LongTimeSeries.Builder;

class LongTimeSeriesDiffblueTest {
  /**
   * Test Builder {@link Builder#build()}.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link Builder#build()}
   *   <li>default or parameterless constructor of {@link Builder}
   *   <li>{@link Builder#instantCountPairs(Map)}
   *   <li>{@link Builder#timeBucket(TimeBucket)}
   * </ul>
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Builder.<init>()", "LongTimeSeries Builder.build()",
      "Builder Builder.instantCountPairs(Map)", "Builder Builder.timeBucket(TimeBucket)"})
  void testBuilderBuild() {
    // Arrange
    Builder builder = new Builder();

    // Act
    LongTimeSeries actualBuildResult = builder.instantCountPairs(new HashMap<>()).timeBucket(TimeBucket.SECOND).build();

    // Assert
    assertEquals(0, actualBuildResult.getNumberOfInstants());
    assertEquals(TimeBucket.SECOND, actualBuildResult.getTimeBucket());
  }

  /**
   * Test {@link LongTimeSeries#LongTimeSeries(TimeBucket)}.
   * <p>
   * Method under test: {@link LongTimeSeries#LongTimeSeries(TimeBucket)}
   */
  @Test
  @DisplayName("Test new LongTimeSeries(TimeBucket)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void LongTimeSeries.<init>(TimeBucket)"})
  void testNewLongTimeSeries() {
    // Arrange and Act
    LongTimeSeries actualLongTimeSeries = new LongTimeSeries(TimeBucket.SECOND);

    // Assert
    assertEquals(0, actualLongTimeSeries.getNumberOfInstants());
    assertEquals(TimeBucket.SECOND, actualLongTimeSeries.getTimeBucket());
    assertTrue(actualLongTimeSeries.getTimeSeries().isEmpty());
    assertTrue(actualLongTimeSeries.getInstants().isEmpty());
  }

  /**
   * Test {@link LongTimeSeries#LongTimeSeries(TimeBucket, Map)}.
   * <ul>
   *   <li>Given now atStartOfDay atZone {@link ZoneOffset#UTC} toInstant.</li>
   * </ul>
   * <p>
   * Method under test: {@link LongTimeSeries#LongTimeSeries(TimeBucket, Map)}
   */
  @Test
  @DisplayName("Test new LongTimeSeries(TimeBucket, Map); given now atStartOfDay atZone UTC toInstant")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void LongTimeSeries.<init>(TimeBucket, Map)"})
  void testNewLongTimeSeries_givenNowAtStartOfDayAtZoneUtcToInstant() {
    // Arrange
    HashMap<Instant, Long> timeSeries = new HashMap<>();
    timeSeries.put(LocalDate.now().atStartOfDay().atZone(ZoneOffset.UTC).toInstant(), 2L);
    timeSeries.put(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant(), 1L);

    // Act
    LongTimeSeries actualLongTimeSeries = new LongTimeSeries(TimeBucket.SECOND, timeSeries);

    // Assert
    assertEquals(TimeBucket.SECOND, actualLongTimeSeries.getTimeBucket());
    assertEquals(timeSeries, actualLongTimeSeries.getTimeSeries());
  }

  /**
   * Test {@link LongTimeSeries#LongTimeSeries(TimeBucket, Map)}.
   * <ul>
   *   <li>When {@code DAY}.</li>
   *   <li>Then return TimeBucket is {@code DAY}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LongTimeSeries#LongTimeSeries(TimeBucket, Map)}
   */
  @Test
  @DisplayName("Test new LongTimeSeries(TimeBucket, Map); when 'DAY'; then return TimeBucket is 'DAY'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void LongTimeSeries.<init>(TimeBucket, Map)"})
  void testNewLongTimeSeries_whenDay_thenReturnTimeBucketIsDay() {
    // Arrange
    HashMap<Instant, Long> timeSeries = new HashMap<>();
    timeSeries.put(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant(), 1L);

    // Act
    LongTimeSeries actualLongTimeSeries = new LongTimeSeries(TimeBucket.DAY, timeSeries);

    // Assert
    assertEquals(1, actualLongTimeSeries.getInstants().size());
    assertEquals(1, actualLongTimeSeries.getNumberOfInstants());
    assertEquals(TimeBucket.DAY, actualLongTimeSeries.getTimeBucket());
    assertEquals(timeSeries, actualLongTimeSeries.getTimeSeries());
  }

  /**
   * Test {@link LongTimeSeries#LongTimeSeries(TimeBucket, Map)}.
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.</li>
   *   <li>Then return NumberOfInstants is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link LongTimeSeries#LongTimeSeries(TimeBucket, Map)}
   */
  @Test
  @DisplayName("Test new LongTimeSeries(TimeBucket, Map); when HashMap(); then return NumberOfInstants is zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void LongTimeSeries.<init>(TimeBucket, Map)"})
  void testNewLongTimeSeries_whenHashMap_thenReturnNumberOfInstantsIsZero() {
    // Arrange
    HashMap<Instant, Long> timeSeries = new HashMap<>();

    // Act
    LongTimeSeries actualLongTimeSeries = new LongTimeSeries(TimeBucket.SECOND, timeSeries);

    // Assert
    assertEquals(0, actualLongTimeSeries.getNumberOfInstants());
    assertEquals(TimeBucket.SECOND, actualLongTimeSeries.getTimeBucket());
    assertTrue(actualLongTimeSeries.getInstants().isEmpty());
    assertEquals(timeSeries, actualLongTimeSeries.getTimeSeries());
  }

  /**
   * Test {@link LongTimeSeries#LongTimeSeries(TimeBucket, Map)}.
   * <ul>
   *   <li>When {@code HOUR}.</li>
   *   <li>Then return TimeBucket is {@code HOUR}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LongTimeSeries#LongTimeSeries(TimeBucket, Map)}
   */
  @Test
  @DisplayName("Test new LongTimeSeries(TimeBucket, Map); when 'HOUR'; then return TimeBucket is 'HOUR'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void LongTimeSeries.<init>(TimeBucket, Map)"})
  void testNewLongTimeSeries_whenHour_thenReturnTimeBucketIsHour() {
    // Arrange
    HashMap<Instant, Long> timeSeries = new HashMap<>();
    timeSeries.put(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant(), 1L);

    // Act
    LongTimeSeries actualLongTimeSeries = new LongTimeSeries(TimeBucket.HOUR, timeSeries);

    // Assert
    assertEquals(1, actualLongTimeSeries.getInstants().size());
    assertEquals(1, actualLongTimeSeries.getNumberOfInstants());
    assertEquals(TimeBucket.HOUR, actualLongTimeSeries.getTimeBucket());
    assertEquals(timeSeries, actualLongTimeSeries.getTimeSeries());
  }

  /**
   * Test {@link LongTimeSeries#LongTimeSeries(TimeBucket, Map)}.
   * <ul>
   *   <li>When {@code MILLISECOND}.</li>
   *   <li>Then return TimeBucket is {@code MILLISECOND}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LongTimeSeries#LongTimeSeries(TimeBucket, Map)}
   */
  @Test
  @DisplayName("Test new LongTimeSeries(TimeBucket, Map); when 'MILLISECOND'; then return TimeBucket is 'MILLISECOND'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void LongTimeSeries.<init>(TimeBucket, Map)"})
  void testNewLongTimeSeries_whenMillisecond_thenReturnTimeBucketIsMillisecond() {
    // Arrange
    HashMap<Instant, Long> timeSeries = new HashMap<>();
    timeSeries.put(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant(), 1L);

    // Act
    LongTimeSeries actualLongTimeSeries = new LongTimeSeries(TimeBucket.MILLISECOND, timeSeries);

    // Assert
    assertEquals(1, actualLongTimeSeries.getInstants().size());
    assertEquals(1, actualLongTimeSeries.getNumberOfInstants());
    assertEquals(TimeBucket.MILLISECOND, actualLongTimeSeries.getTimeBucket());
    assertEquals(timeSeries, actualLongTimeSeries.getTimeSeries());
  }

  /**
   * Test {@link LongTimeSeries#LongTimeSeries(TimeBucket, Map)}.
   * <ul>
   *   <li>When {@code MINUTE}.</li>
   *   <li>Then return TimeBucket is {@code MINUTE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LongTimeSeries#LongTimeSeries(TimeBucket, Map)}
   */
  @Test
  @DisplayName("Test new LongTimeSeries(TimeBucket, Map); when 'MINUTE'; then return TimeBucket is 'MINUTE'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void LongTimeSeries.<init>(TimeBucket, Map)"})
  void testNewLongTimeSeries_whenMinute_thenReturnTimeBucketIsMinute() {
    // Arrange
    HashMap<Instant, Long> timeSeries = new HashMap<>();
    timeSeries.put(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant(), 1L);

    // Act
    LongTimeSeries actualLongTimeSeries = new LongTimeSeries(TimeBucket.MINUTE, timeSeries);

    // Assert
    assertEquals(1, actualLongTimeSeries.getInstants().size());
    assertEquals(1, actualLongTimeSeries.getNumberOfInstants());
    assertEquals(TimeBucket.MINUTE, actualLongTimeSeries.getTimeBucket());
    assertEquals(timeSeries, actualLongTimeSeries.getTimeSeries());
  }

  /**
   * Test {@link LongTimeSeries#LongTimeSeries(TimeBucket, Map)}.
   * <ul>
   *   <li>When {@code MONTH}.</li>
   *   <li>Then return TimeBucket is {@code MONTH}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LongTimeSeries#LongTimeSeries(TimeBucket, Map)}
   */
  @Test
  @DisplayName("Test new LongTimeSeries(TimeBucket, Map); when 'MONTH'; then return TimeBucket is 'MONTH'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void LongTimeSeries.<init>(TimeBucket, Map)"})
  void testNewLongTimeSeries_whenMonth_thenReturnTimeBucketIsMonth() {
    // Arrange
    HashMap<Instant, Long> timeSeries = new HashMap<>();
    timeSeries.put(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant(), 1L);

    // Act
    LongTimeSeries actualLongTimeSeries = new LongTimeSeries(TimeBucket.MONTH, timeSeries);

    // Assert
    assertEquals(1, actualLongTimeSeries.getInstants().size());
    assertEquals(1, actualLongTimeSeries.getNumberOfInstants());
    assertEquals(TimeBucket.MONTH, actualLongTimeSeries.getTimeBucket());
    assertEquals(timeSeries, actualLongTimeSeries.getTimeSeries());
  }

  /**
   * Test {@link LongTimeSeries#LongTimeSeries(TimeBucket, Map)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return TimeSeries Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link LongTimeSeries#LongTimeSeries(TimeBucket, Map)}
   */
  @Test
  @DisplayName("Test new LongTimeSeries(TimeBucket, Map); when 'null'; then return TimeSeries Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void LongTimeSeries.<init>(TimeBucket, Map)"})
  void testNewLongTimeSeries_whenNull_thenReturnTimeSeriesEmpty() {
    // Arrange and Act
    LongTimeSeries actualLongTimeSeries = new LongTimeSeries(TimeBucket.SECOND, null);

    // Assert
    assertEquals(0, actualLongTimeSeries.getNumberOfInstants());
    assertTrue(actualLongTimeSeries.getTimeSeries().isEmpty());
    assertTrue(actualLongTimeSeries.getInstants().isEmpty());
  }

  /**
   * Test {@link LongTimeSeries#LongTimeSeries(TimeBucket, Map)}.
   * <ul>
   *   <li>When {@code SECOND}.</li>
   *   <li>Then return TimeBucket is {@code SECOND}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LongTimeSeries#LongTimeSeries(TimeBucket, Map)}
   */
  @Test
  @DisplayName("Test new LongTimeSeries(TimeBucket, Map); when 'SECOND'; then return TimeBucket is 'SECOND'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void LongTimeSeries.<init>(TimeBucket, Map)"})
  void testNewLongTimeSeries_whenSecond_thenReturnTimeBucketIsSecond() {
    // Arrange
    HashMap<Instant, Long> timeSeries = new HashMap<>();
    timeSeries.put(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant(), 1L);

    // Act
    LongTimeSeries actualLongTimeSeries = new LongTimeSeries(TimeBucket.SECOND, timeSeries);

    // Assert
    assertEquals(1, actualLongTimeSeries.getInstants().size());
    assertEquals(1, actualLongTimeSeries.getNumberOfInstants());
    assertEquals(TimeBucket.SECOND, actualLongTimeSeries.getTimeBucket());
    assertEquals(timeSeries, actualLongTimeSeries.getTimeSeries());
  }

  /**
   * Test {@link LongTimeSeries#LongTimeSeries(TimeBucket, Map)}.
   * <ul>
   *   <li>When {@code WEEK}.</li>
   *   <li>Then return TimeSeries size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link LongTimeSeries#LongTimeSeries(TimeBucket, Map)}
   */
  @Test
  @DisplayName("Test new LongTimeSeries(TimeBucket, Map); when 'WEEK'; then return TimeSeries size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void LongTimeSeries.<init>(TimeBucket, Map)"})
  void testNewLongTimeSeries_whenWeek_thenReturnTimeSeriesSizeIsOne() {
    // Arrange
    HashMap<Instant, Long> timeSeries = new HashMap<>();
    timeSeries.put(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant(), 1L);

    // Act
    LongTimeSeries actualLongTimeSeries = new LongTimeSeries(TimeBucket.WEEK, timeSeries);

    // Assert
    assertEquals(1, actualLongTimeSeries.getTimeSeries().size());
    assertEquals(1, actualLongTimeSeries.getInstants().size());
    assertEquals(1, actualLongTimeSeries.getNumberOfInstants());
    assertEquals(TimeBucket.WEEK, actualLongTimeSeries.getTimeBucket());
  }

  /**
   * Test {@link LongTimeSeries#LongTimeSeries(TimeBucket, Map)}.
   * <ul>
   *   <li>When {@code YEAR}.</li>
   *   <li>Then return TimeBucket is {@code YEAR}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LongTimeSeries#LongTimeSeries(TimeBucket, Map)}
   */
  @Test
  @DisplayName("Test new LongTimeSeries(TimeBucket, Map); when 'YEAR'; then return TimeBucket is 'YEAR'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void LongTimeSeries.<init>(TimeBucket, Map)"})
  void testNewLongTimeSeries_whenYear_thenReturnTimeBucketIsYear() {
    // Arrange
    HashMap<Instant, Long> timeSeries = new HashMap<>();
    timeSeries.put(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant(), 1L);

    // Act
    LongTimeSeries actualLongTimeSeries = new LongTimeSeries(TimeBucket.YEAR, timeSeries);

    // Assert
    assertEquals(1, actualLongTimeSeries.getInstants().size());
    assertEquals(1, actualLongTimeSeries.getNumberOfInstants());
    assertEquals(TimeBucket.YEAR, actualLongTimeSeries.getTimeBucket());
    assertEquals(timeSeries, actualLongTimeSeries.getTimeSeries());
  }

  /**
   * Test {@link LongTimeSeries#put(Instant, Long)} with {@code Instant}, {@code Long}.
   * <p>
   * Method under test: {@link LongTimeSeries#put(Instant, Long)}
   */
  @Test
  @DisplayName("Test put(Instant, Long) with 'Instant', 'Long'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void LongTimeSeries.put(Instant, Long)"})
  void testPutWithInstantLong() {
    // Arrange
    LongTimeSeries longTimeSeries = new LongTimeSeries(TimeBucket.SECOND);

    // Act
    longTimeSeries.put(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant(), 42L);

    // Assert
    assertEquals(1, longTimeSeries.getTimeSeries().size());
    assertEquals(1, longTimeSeries.getInstants().size());
    assertEquals(1, longTimeSeries.getNumberOfInstants());
  }

  /**
   * Test {@link LongTimeSeries#put(Instant, Long)} with {@code Instant}, {@code Long}.
   * <p>
   * Method under test: {@link LongTimeSeries#put(Instant, Long)}
   */
  @Test
  @DisplayName("Test put(Instant, Long) with 'Instant', 'Long'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void LongTimeSeries.put(Instant, Long)"})
  void testPutWithInstantLong2() {
    // Arrange
    LongTimeSeries longTimeSeries = new LongTimeSeries(TimeBucket.MINUTE);

    // Act
    longTimeSeries.put(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant(), 42L);

    // Assert
    assertEquals(1, longTimeSeries.getTimeSeries().size());
    assertEquals(1, longTimeSeries.getInstants().size());
    assertEquals(1, longTimeSeries.getNumberOfInstants());
  }

  /**
   * Test {@link LongTimeSeries#put(Instant, Long)} with {@code Instant}, {@code Long}.
   * <p>
   * Method under test: {@link LongTimeSeries#put(Instant, Long)}
   */
  @Test
  @DisplayName("Test put(Instant, Long) with 'Instant', 'Long'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void LongTimeSeries.put(Instant, Long)"})
  void testPutWithInstantLong3() {
    // Arrange
    LongTimeSeries longTimeSeries = new LongTimeSeries(TimeBucket.MONTH);

    // Act
    longTimeSeries.put(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant(), 42L);

    // Assert
    assertEquals(1, longTimeSeries.getTimeSeries().size());
    assertEquals(1, longTimeSeries.getInstants().size());
    assertEquals(1, longTimeSeries.getNumberOfInstants());
  }

  /**
   * Test {@link LongTimeSeries#put(Instant, Long)} with {@code Instant}, {@code Long}.
   * <p>
   * Method under test: {@link LongTimeSeries#put(Instant, Long)}
   */
  @Test
  @DisplayName("Test put(Instant, Long) with 'Instant', 'Long'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void LongTimeSeries.put(Instant, Long)"})
  void testPutWithInstantLong4() {
    // Arrange
    LongTimeSeries longTimeSeries = new LongTimeSeries(TimeBucket.MILLISECOND);

    // Act
    longTimeSeries.put(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant(), 42L);

    // Assert
    assertEquals(1, longTimeSeries.getTimeSeries().size());
    assertEquals(1, longTimeSeries.getInstants().size());
    assertEquals(1, longTimeSeries.getNumberOfInstants());
  }

  /**
   * Test {@link LongTimeSeries#put(Instant, Long)} with {@code Instant}, {@code Long}.
   * <ul>
   *   <li>Then {@link LongTimeSeries#LongTimeSeries(TimeBucket)} with timeBucket is {@code DAY} TimeSeries size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link LongTimeSeries#put(Instant, Long)}
   */
  @Test
  @DisplayName("Test put(Instant, Long) with 'Instant', 'Long'; then LongTimeSeries(TimeBucket) with timeBucket is 'DAY' TimeSeries size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void LongTimeSeries.put(Instant, Long)"})
  void testPutWithInstantLong_thenLongTimeSeriesWithTimeBucketIsDayTimeSeriesSizeIsOne() {
    // Arrange
    LongTimeSeries longTimeSeries = new LongTimeSeries(TimeBucket.DAY);

    // Act
    longTimeSeries.put(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant(), 42L);

    // Assert
    assertEquals(1, longTimeSeries.getTimeSeries().size());
    assertEquals(1, longTimeSeries.getInstants().size());
    assertEquals(1, longTimeSeries.getNumberOfInstants());
  }

  /**
   * Test {@link LongTimeSeries#put(Instant, Long)} with {@code Instant}, {@code Long}.
   * <ul>
   *   <li>Then {@link LongTimeSeries#LongTimeSeries(TimeBucket)} with timeBucket is {@code HOUR} TimeSeries size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link LongTimeSeries#put(Instant, Long)}
   */
  @Test
  @DisplayName("Test put(Instant, Long) with 'Instant', 'Long'; then LongTimeSeries(TimeBucket) with timeBucket is 'HOUR' TimeSeries size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void LongTimeSeries.put(Instant, Long)"})
  void testPutWithInstantLong_thenLongTimeSeriesWithTimeBucketIsHourTimeSeriesSizeIsOne() {
    // Arrange
    LongTimeSeries longTimeSeries = new LongTimeSeries(TimeBucket.HOUR);

    // Act
    longTimeSeries.put(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant(), 42L);

    // Assert
    assertEquals(1, longTimeSeries.getTimeSeries().size());
    assertEquals(1, longTimeSeries.getInstants().size());
    assertEquals(1, longTimeSeries.getNumberOfInstants());
  }

  /**
   * Test {@link LongTimeSeries#put(Instant, Long)} with {@code Instant}, {@code Long}.
   * <ul>
   *   <li>Then {@link LongTimeSeries#LongTimeSeries(TimeBucket)} with timeBucket is {@code WEEK} TimeSeries size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link LongTimeSeries#put(Instant, Long)}
   */
  @Test
  @DisplayName("Test put(Instant, Long) with 'Instant', 'Long'; then LongTimeSeries(TimeBucket) with timeBucket is 'WEEK' TimeSeries size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void LongTimeSeries.put(Instant, Long)"})
  void testPutWithInstantLong_thenLongTimeSeriesWithTimeBucketIsWeekTimeSeriesSizeIsOne() {
    // Arrange
    LongTimeSeries longTimeSeries = new LongTimeSeries(TimeBucket.WEEK);

    // Act
    longTimeSeries.put(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant(), 42L);

    // Assert
    assertEquals(1, longTimeSeries.getTimeSeries().size());
    assertEquals(1, longTimeSeries.getInstants().size());
    assertEquals(1, longTimeSeries.getNumberOfInstants());
  }

  /**
   * Test {@link LongTimeSeries#put(Instant, Long)} with {@code Instant}, {@code Long}.
   * <ul>
   *   <li>Then {@link LongTimeSeries#LongTimeSeries(TimeBucket)} with timeBucket is {@code YEAR} TimeSeries size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link LongTimeSeries#put(Instant, Long)}
   */
  @Test
  @DisplayName("Test put(Instant, Long) with 'Instant', 'Long'; then LongTimeSeries(TimeBucket) with timeBucket is 'YEAR' TimeSeries size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void LongTimeSeries.put(Instant, Long)"})
  void testPutWithInstantLong_thenLongTimeSeriesWithTimeBucketIsYearTimeSeriesSizeIsOne() {
    // Arrange
    LongTimeSeries longTimeSeries = new LongTimeSeries(TimeBucket.YEAR);

    // Act
    longTimeSeries.put(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant(), 42L);

    // Assert
    assertEquals(1, longTimeSeries.getTimeSeries().size());
    assertEquals(1, longTimeSeries.getInstants().size());
    assertEquals(1, longTimeSeries.getNumberOfInstants());
  }

  /**
   * Test {@link LongTimeSeries#get(Instant)}.
   * <ul>
   *   <li>Given {@link LongTimeSeries#LongTimeSeries(TimeBucket)} with timeBucket is {@code DAY}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LongTimeSeries#get(Instant)}
   */
  @Test
  @DisplayName("Test get(Instant); given LongTimeSeries(TimeBucket) with timeBucket is 'DAY'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Long LongTimeSeries.get(Instant)"})
  void testGet_givenLongTimeSeriesWithTimeBucketIsDay() {
    // Arrange
    LongTimeSeries longTimeSeries = new LongTimeSeries(TimeBucket.DAY);

    // Act and Assert
    assertNull(longTimeSeries.get(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
  }

  /**
   * Test {@link LongTimeSeries#get(Instant)}.
   * <ul>
   *   <li>Given {@link LongTimeSeries#LongTimeSeries(TimeBucket)} with timeBucket is {@code HOUR}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LongTimeSeries#get(Instant)}
   */
  @Test
  @DisplayName("Test get(Instant); given LongTimeSeries(TimeBucket) with timeBucket is 'HOUR'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Long LongTimeSeries.get(Instant)"})
  void testGet_givenLongTimeSeriesWithTimeBucketIsHour() {
    // Arrange
    LongTimeSeries longTimeSeries = new LongTimeSeries(TimeBucket.HOUR);

    // Act and Assert
    assertNull(longTimeSeries.get(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
  }

  /**
   * Test {@link LongTimeSeries#get(Instant)}.
   * <ul>
   *   <li>Given {@link LongTimeSeries#LongTimeSeries(TimeBucket)} with timeBucket is {@code MILLISECOND}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LongTimeSeries#get(Instant)}
   */
  @Test
  @DisplayName("Test get(Instant); given LongTimeSeries(TimeBucket) with timeBucket is 'MILLISECOND'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Long LongTimeSeries.get(Instant)"})
  void testGet_givenLongTimeSeriesWithTimeBucketIsMillisecond() {
    // Arrange
    LongTimeSeries longTimeSeries = new LongTimeSeries(TimeBucket.MILLISECOND);

    // Act and Assert
    assertNull(longTimeSeries.get(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
  }

  /**
   * Test {@link LongTimeSeries#get(Instant)}.
   * <ul>
   *   <li>Given {@link LongTimeSeries#LongTimeSeries(TimeBucket)} with timeBucket is {@code MINUTE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LongTimeSeries#get(Instant)}
   */
  @Test
  @DisplayName("Test get(Instant); given LongTimeSeries(TimeBucket) with timeBucket is 'MINUTE'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Long LongTimeSeries.get(Instant)"})
  void testGet_givenLongTimeSeriesWithTimeBucketIsMinute() {
    // Arrange
    LongTimeSeries longTimeSeries = new LongTimeSeries(TimeBucket.MINUTE);

    // Act and Assert
    assertNull(longTimeSeries.get(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
  }

  /**
   * Test {@link LongTimeSeries#get(Instant)}.
   * <ul>
   *   <li>Given {@link LongTimeSeries#LongTimeSeries(TimeBucket)} with timeBucket is {@code MONTH}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LongTimeSeries#get(Instant)}
   */
  @Test
  @DisplayName("Test get(Instant); given LongTimeSeries(TimeBucket) with timeBucket is 'MONTH'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Long LongTimeSeries.get(Instant)"})
  void testGet_givenLongTimeSeriesWithTimeBucketIsMonth() {
    // Arrange
    LongTimeSeries longTimeSeries = new LongTimeSeries(TimeBucket.MONTH);

    // Act and Assert
    assertNull(longTimeSeries.get(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
  }

  /**
   * Test {@link LongTimeSeries#get(Instant)}.
   * <ul>
   *   <li>Given {@link LongTimeSeries#LongTimeSeries(TimeBucket)} with timeBucket is {@code SECOND}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LongTimeSeries#get(Instant)}
   */
  @Test
  @DisplayName("Test get(Instant); given LongTimeSeries(TimeBucket) with timeBucket is 'SECOND'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Long LongTimeSeries.get(Instant)"})
  void testGet_givenLongTimeSeriesWithTimeBucketIsSecond() {
    // Arrange
    LongTimeSeries longTimeSeries = new LongTimeSeries(TimeBucket.SECOND);

    // Act and Assert
    assertNull(longTimeSeries.get(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
  }

  /**
   * Test {@link LongTimeSeries#get(Instant)}.
   * <ul>
   *   <li>Given {@link LongTimeSeries#LongTimeSeries(TimeBucket)} with timeBucket is {@code WEEK}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LongTimeSeries#get(Instant)}
   */
  @Test
  @DisplayName("Test get(Instant); given LongTimeSeries(TimeBucket) with timeBucket is 'WEEK'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Long LongTimeSeries.get(Instant)"})
  void testGet_givenLongTimeSeriesWithTimeBucketIsWeek() {
    // Arrange
    LongTimeSeries longTimeSeries = new LongTimeSeries(TimeBucket.WEEK);

    // Act and Assert
    assertNull(longTimeSeries.get(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
  }

  /**
   * Test {@link LongTimeSeries#get(Instant)}.
   * <ul>
   *   <li>Given {@link LongTimeSeries#LongTimeSeries(TimeBucket)} with timeBucket is {@code YEAR}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LongTimeSeries#get(Instant)}
   */
  @Test
  @DisplayName("Test get(Instant); given LongTimeSeries(TimeBucket) with timeBucket is 'YEAR'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Long LongTimeSeries.get(Instant)"})
  void testGet_givenLongTimeSeriesWithTimeBucketIsYear() {
    // Arrange
    LongTimeSeries longTimeSeries = new LongTimeSeries(TimeBucket.YEAR);

    // Act and Assert
    assertNull(longTimeSeries.get(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
  }

  /**
   * Test {@link LongTimeSeries#upsert(Instant, long)}.
   * <p>
   * Method under test: {@link LongTimeSeries#upsert(Instant, long)}
   */
  @Test
  @DisplayName("Test upsert(Instant, long)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void LongTimeSeries.upsert(Instant, long)"})
  void testUpsert() {
    // Arrange
    LongTimeSeries longTimeSeries = new LongTimeSeries(TimeBucket.SECOND);
    longTimeSeries.put(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant(), 42L);

    // Act
    longTimeSeries.upsert(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant(), 3L);

    // Assert that nothing has changed
    assertEquals(1, longTimeSeries.getTimeSeries().size());
    assertEquals(1, longTimeSeries.getInstants().size());
    assertEquals(1, longTimeSeries.getNumberOfInstants());
  }

  /**
   * Test {@link LongTimeSeries#upsert(Instant, long)}.
   * <ul>
   *   <li>Given {@link LongTimeSeries#LongTimeSeries(TimeBucket)} with timeBucket is {@code SECOND}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LongTimeSeries#upsert(Instant, long)}
   */
  @Test
  @DisplayName("Test upsert(Instant, long); given LongTimeSeries(TimeBucket) with timeBucket is 'SECOND'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void LongTimeSeries.upsert(Instant, long)"})
  void testUpsert_givenLongTimeSeriesWithTimeBucketIsSecond() {
    // Arrange
    LongTimeSeries longTimeSeries = new LongTimeSeries(TimeBucket.SECOND);

    // Act
    longTimeSeries.upsert(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant(), 3L);

    // Assert
    assertEquals(1, longTimeSeries.getTimeSeries().size());
    assertEquals(1, longTimeSeries.getInstants().size());
    assertEquals(1, longTimeSeries.getNumberOfInstants());
  }

  /**
   * Test {@link LongTimeSeries#upsert(Instant, long)}.
   * <ul>
   *   <li>Then {@link LongTimeSeries#LongTimeSeries(TimeBucket)} with timeBucket is {@code DAY} TimeSeries size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link LongTimeSeries#upsert(Instant, long)}
   */
  @Test
  @DisplayName("Test upsert(Instant, long); then LongTimeSeries(TimeBucket) with timeBucket is 'DAY' TimeSeries size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void LongTimeSeries.upsert(Instant, long)"})
  void testUpsert_thenLongTimeSeriesWithTimeBucketIsDayTimeSeriesSizeIsOne() {
    // Arrange
    LongTimeSeries longTimeSeries = new LongTimeSeries(TimeBucket.DAY);

    // Act
    longTimeSeries.upsert(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant(), 3L);

    // Assert
    assertEquals(1, longTimeSeries.getTimeSeries().size());
    assertEquals(1, longTimeSeries.getInstants().size());
    assertEquals(1, longTimeSeries.getNumberOfInstants());
  }

  /**
   * Test {@link LongTimeSeries#upsert(Instant, long)}.
   * <ul>
   *   <li>Then {@link LongTimeSeries#LongTimeSeries(TimeBucket)} with timeBucket is {@code HOUR} TimeSeries size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link LongTimeSeries#upsert(Instant, long)}
   */
  @Test
  @DisplayName("Test upsert(Instant, long); then LongTimeSeries(TimeBucket) with timeBucket is 'HOUR' TimeSeries size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void LongTimeSeries.upsert(Instant, long)"})
  void testUpsert_thenLongTimeSeriesWithTimeBucketIsHourTimeSeriesSizeIsOne() {
    // Arrange
    LongTimeSeries longTimeSeries = new LongTimeSeries(TimeBucket.HOUR);

    // Act
    longTimeSeries.upsert(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant(), 3L);

    // Assert
    assertEquals(1, longTimeSeries.getTimeSeries().size());
    assertEquals(1, longTimeSeries.getInstants().size());
    assertEquals(1, longTimeSeries.getNumberOfInstants());
  }

  /**
   * Test {@link LongTimeSeries#upsert(Instant, long)}.
   * <ul>
   *   <li>Then {@link LongTimeSeries#LongTimeSeries(TimeBucket)} with timeBucket is {@code MILLISECOND} TimeSeries size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link LongTimeSeries#upsert(Instant, long)}
   */
  @Test
  @DisplayName("Test upsert(Instant, long); then LongTimeSeries(TimeBucket) with timeBucket is 'MILLISECOND' TimeSeries size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void LongTimeSeries.upsert(Instant, long)"})
  void testUpsert_thenLongTimeSeriesWithTimeBucketIsMillisecondTimeSeriesSizeIsOne() {
    // Arrange
    LongTimeSeries longTimeSeries = new LongTimeSeries(TimeBucket.MILLISECOND);

    // Act
    longTimeSeries.upsert(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant(), 3L);

    // Assert
    assertEquals(1, longTimeSeries.getTimeSeries().size());
    assertEquals(1, longTimeSeries.getInstants().size());
    assertEquals(1, longTimeSeries.getNumberOfInstants());
  }

  /**
   * Test {@link LongTimeSeries#upsert(Instant, long)}.
   * <ul>
   *   <li>Then {@link LongTimeSeries#LongTimeSeries(TimeBucket)} with timeBucket is {@code MINUTE} TimeSeries size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link LongTimeSeries#upsert(Instant, long)}
   */
  @Test
  @DisplayName("Test upsert(Instant, long); then LongTimeSeries(TimeBucket) with timeBucket is 'MINUTE' TimeSeries size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void LongTimeSeries.upsert(Instant, long)"})
  void testUpsert_thenLongTimeSeriesWithTimeBucketIsMinuteTimeSeriesSizeIsOne() {
    // Arrange
    LongTimeSeries longTimeSeries = new LongTimeSeries(TimeBucket.MINUTE);

    // Act
    longTimeSeries.upsert(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant(), 3L);

    // Assert
    assertEquals(1, longTimeSeries.getTimeSeries().size());
    assertEquals(1, longTimeSeries.getInstants().size());
    assertEquals(1, longTimeSeries.getNumberOfInstants());
  }

  /**
   * Test {@link LongTimeSeries#upsert(Instant, long)}.
   * <ul>
   *   <li>Then {@link LongTimeSeries#LongTimeSeries(TimeBucket)} with timeBucket is {@code MONTH} TimeSeries size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link LongTimeSeries#upsert(Instant, long)}
   */
  @Test
  @DisplayName("Test upsert(Instant, long); then LongTimeSeries(TimeBucket) with timeBucket is 'MONTH' TimeSeries size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void LongTimeSeries.upsert(Instant, long)"})
  void testUpsert_thenLongTimeSeriesWithTimeBucketIsMonthTimeSeriesSizeIsOne() {
    // Arrange
    LongTimeSeries longTimeSeries = new LongTimeSeries(TimeBucket.MONTH);

    // Act
    longTimeSeries.upsert(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant(), 3L);

    // Assert
    assertEquals(1, longTimeSeries.getTimeSeries().size());
    assertEquals(1, longTimeSeries.getInstants().size());
    assertEquals(1, longTimeSeries.getNumberOfInstants());
  }

  /**
   * Test {@link LongTimeSeries#upsert(Instant, long)}.
   * <ul>
   *   <li>Then {@link LongTimeSeries#LongTimeSeries(TimeBucket)} with timeBucket is {@code WEEK} TimeSeries size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link LongTimeSeries#upsert(Instant, long)}
   */
  @Test
  @DisplayName("Test upsert(Instant, long); then LongTimeSeries(TimeBucket) with timeBucket is 'WEEK' TimeSeries size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void LongTimeSeries.upsert(Instant, long)"})
  void testUpsert_thenLongTimeSeriesWithTimeBucketIsWeekTimeSeriesSizeIsOne() {
    // Arrange
    LongTimeSeries longTimeSeries = new LongTimeSeries(TimeBucket.WEEK);

    // Act
    longTimeSeries.upsert(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant(), 3L);

    // Assert
    assertEquals(1, longTimeSeries.getTimeSeries().size());
    assertEquals(1, longTimeSeries.getInstants().size());
    assertEquals(1, longTimeSeries.getNumberOfInstants());
  }

  /**
   * Test {@link LongTimeSeries#upsert(Instant, long)}.
   * <ul>
   *   <li>Then {@link LongTimeSeries#LongTimeSeries(TimeBucket)} with timeBucket is {@code YEAR} TimeSeries size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link LongTimeSeries#upsert(Instant, long)}
   */
  @Test
  @DisplayName("Test upsert(Instant, long); then LongTimeSeries(TimeBucket) with timeBucket is 'YEAR' TimeSeries size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void LongTimeSeries.upsert(Instant, long)"})
  void testUpsert_thenLongTimeSeriesWithTimeBucketIsYearTimeSeriesSizeIsOne() {
    // Arrange
    LongTimeSeries longTimeSeries = new LongTimeSeries(TimeBucket.YEAR);

    // Act
    longTimeSeries.upsert(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant(), 3L);

    // Assert
    assertEquals(1, longTimeSeries.getTimeSeries().size());
    assertEquals(1, longTimeSeries.getInstants().size());
    assertEquals(1, longTimeSeries.getNumberOfInstants());
  }

  /**
   * Test {@link LongTimeSeries#getInstants()}.
   * <p>
   * Method under test: {@link LongTimeSeries#getInstants()}
   */
  @Test
  @DisplayName("Test getInstants()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.util.SortedSet LongTimeSeries.getInstants()"})
  void testGetInstants() {
    // Arrange
    LongTimeSeries longTimeSeries = new LongTimeSeries(TimeBucket.SECOND);
    longTimeSeries.put(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant(), 42L);

    // Act and Assert
    assertEquals(1, longTimeSeries.getInstants().size());
  }

  /**
   * Test {@link LongTimeSeries#getInstants()}.
   * <p>
   * Method under test: {@link LongTimeSeries#getInstants()}
   */
  @Test
  @DisplayName("Test getInstants()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.util.SortedSet LongTimeSeries.getInstants()"})
  void testGetInstants2() {
    // Arrange
    LongTimeSeries longTimeSeries = new LongTimeSeries(TimeBucket.MINUTE);
    longTimeSeries.put(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant(), 42L);

    // Act and Assert
    assertEquals(1, longTimeSeries.getInstants().size());
  }

  /**
   * Test {@link LongTimeSeries#getInstants()}.
   * <p>
   * Method under test: {@link LongTimeSeries#getInstants()}
   */
  @Test
  @DisplayName("Test getInstants()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.util.SortedSet LongTimeSeries.getInstants()"})
  void testGetInstants3() {
    // Arrange
    LongTimeSeries longTimeSeries = new LongTimeSeries(TimeBucket.HOUR);
    longTimeSeries.put(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant(), 42L);

    // Act and Assert
    assertEquals(1, longTimeSeries.getInstants().size());
  }

  /**
   * Test {@link LongTimeSeries#getInstants()}.
   * <p>
   * Method under test: {@link LongTimeSeries#getInstants()}
   */
  @Test
  @DisplayName("Test getInstants()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.util.SortedSet LongTimeSeries.getInstants()"})
  void testGetInstants4() {
    // Arrange
    LongTimeSeries longTimeSeries = new LongTimeSeries(TimeBucket.DAY);
    longTimeSeries.put(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant(), 42L);

    // Act and Assert
    assertEquals(1, longTimeSeries.getInstants().size());
  }

  /**
   * Test {@link LongTimeSeries#getInstants()}.
   * <p>
   * Method under test: {@link LongTimeSeries#getInstants()}
   */
  @Test
  @DisplayName("Test getInstants()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.util.SortedSet LongTimeSeries.getInstants()"})
  void testGetInstants5() {
    // Arrange
    LongTimeSeries longTimeSeries = new LongTimeSeries(TimeBucket.WEEK);
    longTimeSeries.put(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant(), 42L);

    // Act and Assert
    assertEquals(1, longTimeSeries.getInstants().size());
  }

  /**
   * Test {@link LongTimeSeries#getInstants()}.
   * <p>
   * Method under test: {@link LongTimeSeries#getInstants()}
   */
  @Test
  @DisplayName("Test getInstants()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.util.SortedSet LongTimeSeries.getInstants()"})
  void testGetInstants6() {
    // Arrange
    LongTimeSeries longTimeSeries = new LongTimeSeries(TimeBucket.MONTH);
    longTimeSeries.put(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant(), 42L);

    // Act and Assert
    assertEquals(1, longTimeSeries.getInstants().size());
  }

  /**
   * Test {@link LongTimeSeries#getInstants()}.
   * <p>
   * Method under test: {@link LongTimeSeries#getInstants()}
   */
  @Test
  @DisplayName("Test getInstants()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.util.SortedSet LongTimeSeries.getInstants()"})
  void testGetInstants7() {
    // Arrange
    LongTimeSeries longTimeSeries = new LongTimeSeries(TimeBucket.YEAR);
    longTimeSeries.put(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant(), 42L);

    // Act and Assert
    assertEquals(1, longTimeSeries.getInstants().size());
  }

  /**
   * Test {@link LongTimeSeries#getInstants()}.
   * <p>
   * Method under test: {@link LongTimeSeries#getInstants()}
   */
  @Test
  @DisplayName("Test getInstants()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.util.SortedSet LongTimeSeries.getInstants()"})
  void testGetInstants8() {
    // Arrange
    LongTimeSeries longTimeSeries = new LongTimeSeries(TimeBucket.MILLISECOND);
    longTimeSeries.put(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant(), 42L);

    // Act and Assert
    assertEquals(1, longTimeSeries.getInstants().size());
  }

  /**
   * Test {@link LongTimeSeries#getInstants()}.
   * <ul>
   *   <li>Given {@link LongTimeSeries#LongTimeSeries(TimeBucket)} with timeBucket is {@code SECOND}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link LongTimeSeries#getInstants()}
   */
  @Test
  @DisplayName("Test getInstants(); given LongTimeSeries(TimeBucket) with timeBucket is 'SECOND'; then return Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.util.SortedSet LongTimeSeries.getInstants()"})
  void testGetInstants_givenLongTimeSeriesWithTimeBucketIsSecond_thenReturnEmpty() {
    // Arrange, Act and Assert
    assertTrue((new LongTimeSeries(TimeBucket.SECOND)).getInstants().isEmpty());
  }

  /**
   * Test {@link LongTimeSeries#getNumberOfInstants()}.
   * <p>
   * Method under test: {@link LongTimeSeries#getNumberOfInstants()}
   */
  @Test
  @DisplayName("Test getNumberOfInstants()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int LongTimeSeries.getNumberOfInstants()"})
  void testGetNumberOfInstants() {
    // Arrange, Act and Assert
    assertEquals(0, (new LongTimeSeries(TimeBucket.SECOND)).getNumberOfInstants());
  }

  /**
   * Test {@link LongTimeSeries#getTimeSeries()}.
   * <p>
   * Method under test: {@link LongTimeSeries#getTimeSeries()}
   */
  @Test
  @DisplayName("Test getTimeSeries()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.util.SortedMap LongTimeSeries.getTimeSeries()"})
  void testGetTimeSeries() {
    // Arrange
    LongTimeSeries longTimeSeries = new LongTimeSeries(TimeBucket.SECOND);
    longTimeSeries.put(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant(), 42L);

    // Act and Assert
    assertEquals(1, longTimeSeries.getTimeSeries().size());
  }

  /**
   * Test {@link LongTimeSeries#getTimeSeries()}.
   * <p>
   * Method under test: {@link LongTimeSeries#getTimeSeries()}
   */
  @Test
  @DisplayName("Test getTimeSeries()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.util.SortedMap LongTimeSeries.getTimeSeries()"})
  void testGetTimeSeries2() {
    // Arrange
    LongTimeSeries longTimeSeries = new LongTimeSeries(TimeBucket.MINUTE);
    longTimeSeries.put(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant(), 42L);

    // Act and Assert
    assertEquals(1, longTimeSeries.getTimeSeries().size());
  }

  /**
   * Test {@link LongTimeSeries#getTimeSeries()}.
   * <p>
   * Method under test: {@link LongTimeSeries#getTimeSeries()}
   */
  @Test
  @DisplayName("Test getTimeSeries()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.util.SortedMap LongTimeSeries.getTimeSeries()"})
  void testGetTimeSeries3() {
    // Arrange
    LongTimeSeries longTimeSeries = new LongTimeSeries(TimeBucket.HOUR);
    longTimeSeries.put(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant(), 42L);

    // Act and Assert
    assertEquals(1, longTimeSeries.getTimeSeries().size());
  }

  /**
   * Test {@link LongTimeSeries#getTimeSeries()}.
   * <p>
   * Method under test: {@link LongTimeSeries#getTimeSeries()}
   */
  @Test
  @DisplayName("Test getTimeSeries()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.util.SortedMap LongTimeSeries.getTimeSeries()"})
  void testGetTimeSeries4() {
    // Arrange
    LongTimeSeries longTimeSeries = new LongTimeSeries(TimeBucket.DAY);
    longTimeSeries.put(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant(), 42L);

    // Act and Assert
    assertEquals(1, longTimeSeries.getTimeSeries().size());
  }

  /**
   * Test {@link LongTimeSeries#getTimeSeries()}.
   * <p>
   * Method under test: {@link LongTimeSeries#getTimeSeries()}
   */
  @Test
  @DisplayName("Test getTimeSeries()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.util.SortedMap LongTimeSeries.getTimeSeries()"})
  void testGetTimeSeries5() {
    // Arrange
    LongTimeSeries longTimeSeries = new LongTimeSeries(TimeBucket.WEEK);
    longTimeSeries.put(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant(), 42L);

    // Act and Assert
    assertEquals(1, longTimeSeries.getTimeSeries().size());
  }

  /**
   * Test {@link LongTimeSeries#getTimeSeries()}.
   * <p>
   * Method under test: {@link LongTimeSeries#getTimeSeries()}
   */
  @Test
  @DisplayName("Test getTimeSeries()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.util.SortedMap LongTimeSeries.getTimeSeries()"})
  void testGetTimeSeries6() {
    // Arrange
    LongTimeSeries longTimeSeries = new LongTimeSeries(TimeBucket.MONTH);
    longTimeSeries.put(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant(), 42L);

    // Act and Assert
    assertEquals(1, longTimeSeries.getTimeSeries().size());
  }

  /**
   * Test {@link LongTimeSeries#getTimeSeries()}.
   * <p>
   * Method under test: {@link LongTimeSeries#getTimeSeries()}
   */
  @Test
  @DisplayName("Test getTimeSeries()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.util.SortedMap LongTimeSeries.getTimeSeries()"})
  void testGetTimeSeries7() {
    // Arrange
    LongTimeSeries longTimeSeries = new LongTimeSeries(TimeBucket.YEAR);
    longTimeSeries.put(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant(), 42L);

    // Act and Assert
    assertEquals(1, longTimeSeries.getTimeSeries().size());
  }

  /**
   * Test {@link LongTimeSeries#getTimeSeries()}.
   * <p>
   * Method under test: {@link LongTimeSeries#getTimeSeries()}
   */
  @Test
  @DisplayName("Test getTimeSeries()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.util.SortedMap LongTimeSeries.getTimeSeries()"})
  void testGetTimeSeries8() {
    // Arrange
    LongTimeSeries longTimeSeries = new LongTimeSeries(TimeBucket.MILLISECOND);
    longTimeSeries.put(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant(), 42L);

    // Act and Assert
    assertEquals(1, longTimeSeries.getTimeSeries().size());
  }

  /**
   * Test {@link LongTimeSeries#getTimeSeries()}.
   * <ul>
   *   <li>Given {@link LongTimeSeries#LongTimeSeries(TimeBucket)} with timeBucket is {@code SECOND}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link LongTimeSeries#getTimeSeries()}
   */
  @Test
  @DisplayName("Test getTimeSeries(); given LongTimeSeries(TimeBucket) with timeBucket is 'SECOND'; then return Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.util.SortedMap LongTimeSeries.getTimeSeries()"})
  void testGetTimeSeries_givenLongTimeSeriesWithTimeBucketIsSecond_thenReturnEmpty() {
    // Arrange, Act and Assert
    assertTrue((new LongTimeSeries(TimeBucket.SECOND)).getTimeSeries().isEmpty());
  }

  /**
   * Test {@link LongTimeSeries#setTimeSeries(Map)}.
   * <ul>
   *   <li>Given now atStartOfDay atZone {@link ZoneOffset#UTC} toInstant.</li>
   * </ul>
   * <p>
   * Method under test: {@link LongTimeSeries#setTimeSeries(Map)}
   */
  @Test
  @DisplayName("Test setTimeSeries(Map); given now atStartOfDay atZone UTC toInstant")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void LongTimeSeries.setTimeSeries(Map)"})
  void testSetTimeSeries_givenNowAtStartOfDayAtZoneUtcToInstant() {
    // Arrange
    LongTimeSeries longTimeSeries = new LongTimeSeries(TimeBucket.SECOND);

    HashMap<Instant, Long> timeSeries = new HashMap<>();
    timeSeries.put(LocalDate.now().atStartOfDay().atZone(ZoneOffset.UTC).toInstant(), 2L);
    timeSeries.put(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant(), 1L);

    // Act
    longTimeSeries.setTimeSeries(timeSeries);

    // Assert
    assertEquals(timeSeries, longTimeSeries.getTimeSeries());
  }

  /**
   * Test {@link LongTimeSeries#setTimeSeries(Map)}.
   * <ul>
   *   <li>Then {@link LongTimeSeries#LongTimeSeries(TimeBucket)} with timeBucket is {@code DAY} Instants size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link LongTimeSeries#setTimeSeries(Map)}
   */
  @Test
  @DisplayName("Test setTimeSeries(Map); then LongTimeSeries(TimeBucket) with timeBucket is 'DAY' Instants size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void LongTimeSeries.setTimeSeries(Map)"})
  void testSetTimeSeries_thenLongTimeSeriesWithTimeBucketIsDayInstantsSizeIsOne() {
    // Arrange
    LongTimeSeries longTimeSeries = new LongTimeSeries(TimeBucket.DAY);

    HashMap<Instant, Long> timeSeries = new HashMap<>();
    timeSeries.put(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant(), 1L);

    // Act
    longTimeSeries.setTimeSeries(timeSeries);

    // Assert
    assertEquals(1, longTimeSeries.getInstants().size());
    assertEquals(1, longTimeSeries.getNumberOfInstants());
    assertEquals(timeSeries, longTimeSeries.getTimeSeries());
  }

  /**
   * Test {@link LongTimeSeries#setTimeSeries(Map)}.
   * <ul>
   *   <li>Then {@link LongTimeSeries#LongTimeSeries(TimeBucket)} with timeBucket is {@code HOUR} Instants size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link LongTimeSeries#setTimeSeries(Map)}
   */
  @Test
  @DisplayName("Test setTimeSeries(Map); then LongTimeSeries(TimeBucket) with timeBucket is 'HOUR' Instants size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void LongTimeSeries.setTimeSeries(Map)"})
  void testSetTimeSeries_thenLongTimeSeriesWithTimeBucketIsHourInstantsSizeIsOne() {
    // Arrange
    LongTimeSeries longTimeSeries = new LongTimeSeries(TimeBucket.HOUR);

    HashMap<Instant, Long> timeSeries = new HashMap<>();
    timeSeries.put(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant(), 1L);

    // Act
    longTimeSeries.setTimeSeries(timeSeries);

    // Assert
    assertEquals(1, longTimeSeries.getInstants().size());
    assertEquals(1, longTimeSeries.getNumberOfInstants());
    assertEquals(timeSeries, longTimeSeries.getTimeSeries());
  }

  /**
   * Test {@link LongTimeSeries#setTimeSeries(Map)}.
   * <ul>
   *   <li>Then {@link LongTimeSeries#LongTimeSeries(TimeBucket)} with timeBucket is {@code MILLISECOND} Instants size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link LongTimeSeries#setTimeSeries(Map)}
   */
  @Test
  @DisplayName("Test setTimeSeries(Map); then LongTimeSeries(TimeBucket) with timeBucket is 'MILLISECOND' Instants size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void LongTimeSeries.setTimeSeries(Map)"})
  void testSetTimeSeries_thenLongTimeSeriesWithTimeBucketIsMillisecondInstantsSizeIsOne() {
    // Arrange
    LongTimeSeries longTimeSeries = new LongTimeSeries(TimeBucket.MILLISECOND);

    HashMap<Instant, Long> timeSeries = new HashMap<>();
    timeSeries.put(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant(), 1L);

    // Act
    longTimeSeries.setTimeSeries(timeSeries);

    // Assert
    assertEquals(1, longTimeSeries.getInstants().size());
    assertEquals(1, longTimeSeries.getNumberOfInstants());
    assertEquals(timeSeries, longTimeSeries.getTimeSeries());
  }

  /**
   * Test {@link LongTimeSeries#setTimeSeries(Map)}.
   * <ul>
   *   <li>Then {@link LongTimeSeries#LongTimeSeries(TimeBucket)} with timeBucket is {@code MINUTE} Instants size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link LongTimeSeries#setTimeSeries(Map)}
   */
  @Test
  @DisplayName("Test setTimeSeries(Map); then LongTimeSeries(TimeBucket) with timeBucket is 'MINUTE' Instants size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void LongTimeSeries.setTimeSeries(Map)"})
  void testSetTimeSeries_thenLongTimeSeriesWithTimeBucketIsMinuteInstantsSizeIsOne() {
    // Arrange
    LongTimeSeries longTimeSeries = new LongTimeSeries(TimeBucket.MINUTE);

    HashMap<Instant, Long> timeSeries = new HashMap<>();
    timeSeries.put(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant(), 1L);

    // Act
    longTimeSeries.setTimeSeries(timeSeries);

    // Assert
    assertEquals(1, longTimeSeries.getInstants().size());
    assertEquals(1, longTimeSeries.getNumberOfInstants());
    assertEquals(timeSeries, longTimeSeries.getTimeSeries());
  }

  /**
   * Test {@link LongTimeSeries#setTimeSeries(Map)}.
   * <ul>
   *   <li>Then {@link LongTimeSeries#LongTimeSeries(TimeBucket)} with timeBucket is {@code MONTH} Instants size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link LongTimeSeries#setTimeSeries(Map)}
   */
  @Test
  @DisplayName("Test setTimeSeries(Map); then LongTimeSeries(TimeBucket) with timeBucket is 'MONTH' Instants size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void LongTimeSeries.setTimeSeries(Map)"})
  void testSetTimeSeries_thenLongTimeSeriesWithTimeBucketIsMonthInstantsSizeIsOne() {
    // Arrange
    LongTimeSeries longTimeSeries = new LongTimeSeries(TimeBucket.MONTH);

    HashMap<Instant, Long> timeSeries = new HashMap<>();
    timeSeries.put(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant(), 1L);

    // Act
    longTimeSeries.setTimeSeries(timeSeries);

    // Assert
    assertEquals(1, longTimeSeries.getInstants().size());
    assertEquals(1, longTimeSeries.getNumberOfInstants());
    assertEquals(timeSeries, longTimeSeries.getTimeSeries());
  }

  /**
   * Test {@link LongTimeSeries#setTimeSeries(Map)}.
   * <ul>
   *   <li>Then {@link LongTimeSeries#LongTimeSeries(TimeBucket)} with timeBucket is {@code SECOND} Instants size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link LongTimeSeries#setTimeSeries(Map)}
   */
  @Test
  @DisplayName("Test setTimeSeries(Map); then LongTimeSeries(TimeBucket) with timeBucket is 'SECOND' Instants size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void LongTimeSeries.setTimeSeries(Map)"})
  void testSetTimeSeries_thenLongTimeSeriesWithTimeBucketIsSecondInstantsSizeIsOne() {
    // Arrange
    LongTimeSeries longTimeSeries = new LongTimeSeries(TimeBucket.SECOND);

    HashMap<Instant, Long> timeSeries = new HashMap<>();
    timeSeries.put(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant(), 1L);

    // Act
    longTimeSeries.setTimeSeries(timeSeries);

    // Assert
    assertEquals(1, longTimeSeries.getInstants().size());
    assertEquals(1, longTimeSeries.getNumberOfInstants());
    assertEquals(timeSeries, longTimeSeries.getTimeSeries());
  }

  /**
   * Test {@link LongTimeSeries#setTimeSeries(Map)}.
   * <ul>
   *   <li>Then {@link LongTimeSeries#LongTimeSeries(TimeBucket)} with timeBucket is {@code SECOND} NumberOfInstants is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link LongTimeSeries#setTimeSeries(Map)}
   */
  @Test
  @DisplayName("Test setTimeSeries(Map); then LongTimeSeries(TimeBucket) with timeBucket is 'SECOND' NumberOfInstants is zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void LongTimeSeries.setTimeSeries(Map)"})
  void testSetTimeSeries_thenLongTimeSeriesWithTimeBucketIsSecondNumberOfInstantsIsZero() {
    // Arrange
    LongTimeSeries longTimeSeries = new LongTimeSeries(TimeBucket.SECOND);
    HashMap<Instant, Long> timeSeries = new HashMap<>();

    // Act
    longTimeSeries.setTimeSeries(timeSeries);

    // Assert that nothing has changed
    assertEquals(0, longTimeSeries.getNumberOfInstants());
    assertTrue(longTimeSeries.getInstants().isEmpty());
    assertEquals(timeSeries, longTimeSeries.getTimeSeries());
  }

  /**
   * Test {@link LongTimeSeries#setTimeSeries(Map)}.
   * <ul>
   *   <li>Then {@link LongTimeSeries#LongTimeSeries(TimeBucket)} with timeBucket is {@code WEEK} TimeSeries size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link LongTimeSeries#setTimeSeries(Map)}
   */
  @Test
  @DisplayName("Test setTimeSeries(Map); then LongTimeSeries(TimeBucket) with timeBucket is 'WEEK' TimeSeries size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void LongTimeSeries.setTimeSeries(Map)"})
  void testSetTimeSeries_thenLongTimeSeriesWithTimeBucketIsWeekTimeSeriesSizeIsOne() {
    // Arrange
    LongTimeSeries longTimeSeries = new LongTimeSeries(TimeBucket.WEEK);

    HashMap<Instant, Long> timeSeries = new HashMap<>();
    timeSeries.put(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant(), 1L);

    // Act
    longTimeSeries.setTimeSeries(timeSeries);

    // Assert
    assertEquals(1, longTimeSeries.getTimeSeries().size());
    assertEquals(1, longTimeSeries.getInstants().size());
    assertEquals(1, longTimeSeries.getNumberOfInstants());
  }

  /**
   * Test {@link LongTimeSeries#setTimeSeries(Map)}.
   * <ul>
   *   <li>Then {@link LongTimeSeries#LongTimeSeries(TimeBucket)} with timeBucket is {@code YEAR} Instants size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link LongTimeSeries#setTimeSeries(Map)}
   */
  @Test
  @DisplayName("Test setTimeSeries(Map); then LongTimeSeries(TimeBucket) with timeBucket is 'YEAR' Instants size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void LongTimeSeries.setTimeSeries(Map)"})
  void testSetTimeSeries_thenLongTimeSeriesWithTimeBucketIsYearInstantsSizeIsOne() {
    // Arrange
    LongTimeSeries longTimeSeries = new LongTimeSeries(TimeBucket.YEAR);

    HashMap<Instant, Long> timeSeries = new HashMap<>();
    timeSeries.put(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant(), 1L);

    // Act
    longTimeSeries.setTimeSeries(timeSeries);

    // Assert
    assertEquals(1, longTimeSeries.getInstants().size());
    assertEquals(1, longTimeSeries.getNumberOfInstants());
    assertEquals(timeSeries, longTimeSeries.getTimeSeries());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link LongTimeSeries#toString()}
   *   <li>{@link LongTimeSeries#getTimeBucket()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TimeBucket LongTimeSeries.getTimeBucket()", "String LongTimeSeries.toString()"})
  void testGettersAndSetters() {
    // Arrange
    Builder timeBucketResult = (new Builder()).timeBucket(TimeBucket.SECOND);
    LongTimeSeries buildResult = timeBucketResult.instantCountPairs(new HashMap<>()).build();

    // Act
    String actualToStringResult = buildResult.toString();

    // Assert
    assertEquals("LongTimeSeries[timeBucket=SECOND,timeSeries={}]", actualToStringResult);
    assertEquals(TimeBucket.SECOND, buildResult.getTimeBucket());
  }

  /**
   * Test {@link LongTimeSeries#equals(Object)}, and {@link LongTimeSeries#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link LongTimeSeries#equals(Object)}
   *   <li>{@link LongTimeSeries#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean LongTimeSeries.equals(Object)", "int LongTimeSeries.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Builder timeBucketResult = (new Builder()).timeBucket(TimeBucket.SECOND);
    LongTimeSeries buildResult = timeBucketResult.instantCountPairs(new HashMap<>()).build();
    Builder timeBucketResult2 = (new Builder()).timeBucket(TimeBucket.SECOND);
    LongTimeSeries buildResult2 = timeBucketResult2.instantCountPairs(new HashMap<>()).build();

    // Act and Assert
    assertEquals(buildResult, buildResult2);
    int expectedHashCodeResult = buildResult.hashCode();
    assertEquals(expectedHashCodeResult, buildResult2.hashCode());
  }

  /**
   * Test {@link LongTimeSeries#equals(Object)}, and {@link LongTimeSeries#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link LongTimeSeries#equals(Object)}
   *   <li>{@link LongTimeSeries#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean LongTimeSeries.equals(Object)", "int LongTimeSeries.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Builder timeBucketResult = (new Builder()).timeBucket(TimeBucket.SECOND);
    LongTimeSeries buildResult = timeBucketResult.instantCountPairs(new HashMap<>()).build();

    // Act and Assert
    assertEquals(buildResult, buildResult);
    int expectedHashCodeResult = buildResult.hashCode();
    assertEquals(expectedHashCodeResult, buildResult.hashCode());
  }

  /**
   * Test {@link LongTimeSeries#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link LongTimeSeries#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean LongTimeSeries.equals(Object)", "int LongTimeSeries.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Builder timeBucketResult = (new Builder()).timeBucket(TimeBucket.MINUTE);
    LongTimeSeries buildResult = timeBucketResult.instantCountPairs(new HashMap<>()).build();
    Builder timeBucketResult2 = (new Builder()).timeBucket(TimeBucket.SECOND);
    LongTimeSeries buildResult2 = timeBucketResult2.instantCountPairs(new HashMap<>()).build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link LongTimeSeries#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link LongTimeSeries#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean LongTimeSeries.equals(Object)", "int LongTimeSeries.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    Builder timeBucketResult = (new Builder()).timeBucket(TimeBucket.SECOND);
    LongTimeSeries buildResult = timeBucketResult.instantCountPairs(new HashMap<>()).build();

    // Act and Assert
    assertNotEquals(buildResult, null);
  }

  /**
   * Test {@link LongTimeSeries#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link LongTimeSeries#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean LongTimeSeries.equals(Object)", "int LongTimeSeries.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    Builder timeBucketResult = (new Builder()).timeBucket(TimeBucket.SECOND);
    LongTimeSeries buildResult = timeBucketResult.instantCountPairs(new HashMap<>()).build();

    // Act and Assert
    assertNotEquals(buildResult, "Different type to LongTimeSeries");
  }
}
