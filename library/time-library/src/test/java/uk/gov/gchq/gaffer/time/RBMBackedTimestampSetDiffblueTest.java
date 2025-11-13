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
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.roaringbitmap.RoaringBitmap;
import uk.gov.gchq.gaffer.time.CommonTimeUtil.TimeBucket;
import uk.gov.gchq.gaffer.time.RBMBackedTimestampSet.Builder;

class RBMBackedTimestampSetDiffblueTest {
  /**
   * Test Builder {@link Builder#build()}.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link Builder#build()}
   *   <li>default or parameterless constructor of {@link Builder}
   *   <li>{@link Builder#timeBucket(TimeBucket)}
   * </ul>
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Builder.<init>()", "RBMBackedTimestampSet Builder.build()",
      "Builder Builder.timeBucket(TimeBucket)"})
  void testBuilderBuild() {
    // Arrange
    Builder timeBucketResult = (new Builder()).timeBucket(TimeBucket.SECOND);
    Builder timestampResult = timeBucketResult
        .timestamp(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
    Builder timestampsResult = timestampResult.timestamps(new ArrayList<>());

    // Act
    RBMBackedTimestampSet actualBuildResult = timestampsResult
        .timestamps(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant())
        .build();

    // Assert
    RoaringBitmap rbm = actualBuildResult.getRbm();
    Iterator<Integer> iteratorResult = rbm.iterator();
    assertEquals(0, iteratorResult.next().intValue());
    Instant earliest = actualBuildResult.getEarliest();
    assertEquals(0, earliest.getNano());
    assertEquals(0L, earliest.getEpochSecond());
    assertEquals(1, rbm.getCardinality());
    assertEquals(1L, actualBuildResult.getNumberOfTimestamps());
    assertEquals(TimeBucket.SECOND, actualBuildResult.getTimeBucket());
    assertFalse(iteratorResult.hasNext());
    assertFalse(rbm.hasRunCompression());
    assertFalse(rbm.isEmpty());
    assertEquals(Short.SIZE, rbm.getSizeInBytes());
  }

  /**
   * Test Builder {@link Builder#timestamp(Instant)}.
   * <ul>
   *   <li>Given {@link Builder} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#timestamp(Instant)}
   */
  @Test
  @DisplayName("Test Builder timestamp(Instant); given Builder (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.timestamp(Instant)"})
  void testBuilderTimestamp_givenBuilder() {
    // Arrange
    Builder builder = new Builder();

    // Act and Assert
    assertSame(builder, builder.timestamp(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
  }

  /**
   * Test Builder {@link Builder#timestamp(Instant)}.
   * <ul>
   *   <li>Given {@link Builder} (default constructor) timestamp {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#timestamp(Instant)}
   */
  @Test
  @DisplayName("Test Builder timestamp(Instant); given Builder (default constructor) timestamp 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.timestamp(Instant)"})
  void testBuilderTimestamp_givenBuilderTimestampNull() {
    // Arrange
    Builder builder = new Builder();
    builder.timestamp(null);

    // Act and Assert
    assertSame(builder, builder.timestamp(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
  }

  /**
   * Test Builder {@link Builder#timestamps(Collection)} with {@code Collection}.
   * <p>
   * Method under test: {@link Builder#timestamps(Collection)}
   */
  @Test
  @DisplayName("Test Builder timestamps(Collection) with 'Collection'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.timestamps(Collection)"})
  void testBuilderTimestampsWithCollection() {
    // Arrange
    Builder builder = new Builder();

    ArrayList<Instant> timestamps = new ArrayList<>();
    timestamps.add(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Act and Assert
    assertSame(builder, builder.timestamps(timestamps));
  }

  /**
   * Test Builder {@link Builder#timestamps(Collection)} with {@code Collection}.
   * <p>
   * Method under test: {@link Builder#timestamps(Collection)}
   */
  @Test
  @DisplayName("Test Builder timestamps(Collection) with 'Collection'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.timestamps(Collection)"})
  void testBuilderTimestampsWithCollection2() {
    // Arrange
    Builder builder = new Builder();

    ArrayList<Instant> timestamps = new ArrayList<>();
    timestamps.add(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
    timestamps.add(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Act and Assert
    assertSame(builder, builder.timestamps(timestamps));
  }

  /**
   * Test Builder {@link Builder#timestamps(Collection)} with {@code Collection}.
   * <ul>
   *   <li>Given {@link Builder} (default constructor) timestamp {@code null}.</li>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#timestamps(Collection)}
   */
  @Test
  @DisplayName("Test Builder timestamps(Collection) with 'Collection'; given Builder (default constructor) timestamp 'null'; when ArrayList()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.timestamps(Collection)"})
  void testBuilderTimestampsWithCollection_givenBuilderTimestampNull_whenArrayList() {
    // Arrange
    Builder builder = new Builder();
    builder.timestamp(null);

    // Act and Assert
    assertSame(builder, builder.timestamps(new ArrayList<>()));
  }

  /**
   * Test Builder {@link Builder#timestamps(Collection)} with {@code Collection}.
   * <ul>
   *   <li>Given {@link Builder} (default constructor).</li>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#timestamps(Collection)}
   */
  @Test
  @DisplayName("Test Builder timestamps(Collection) with 'Collection'; given Builder (default constructor); when ArrayList()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.timestamps(Collection)"})
  void testBuilderTimestampsWithCollection_givenBuilder_whenArrayList() {
    // Arrange
    Builder builder = new Builder();

    // Act and Assert
    assertSame(builder, builder.timestamps(new ArrayList<>()));
  }

  /**
   * Test Builder {@link Builder#timestamps(Instant[])} with {@code Instant[]}.
   * <ul>
   *   <li>Given {@link Builder} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#timestamps(Instant[])}
   */
  @Test
  @DisplayName("Test Builder timestamps(Instant[]) with 'Instant[]'; given Builder (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.timestamps(Instant[])"})
  void testBuilderTimestampsWithInstant_givenBuilder() {
    // Arrange
    Builder builder = new Builder();

    // Act and Assert
    assertSame(builder, builder.timestamps(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
  }

  /**
   * Test Builder {@link Builder#timestamps(Instant[])} with {@code Instant[]}.
   * <ul>
   *   <li>Given {@link Builder} (default constructor) timestamp {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#timestamps(Instant[])}
   */
  @Test
  @DisplayName("Test Builder timestamps(Instant[]) with 'Instant[]'; given Builder (default constructor) timestamp 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.timestamps(Instant[])"})
  void testBuilderTimestampsWithInstant_givenBuilderTimestampNull() {
    // Arrange
    Builder builder = new Builder();
    builder.timestamp(null);

    // Act and Assert
    assertSame(builder, builder.timestamps(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
  }

  /**
   * Test {@link RBMBackedTimestampSet#RBMBackedTimestampSet(TimeBucket, Instant[])}.
   * <p>
   * Method under test: {@link RBMBackedTimestampSet#RBMBackedTimestampSet(TimeBucket, Instant[])}
   */
  @Test
  @DisplayName("Test new RBMBackedTimestampSet(TimeBucket, Instant[])")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void RBMBackedTimestampSet.<init>(TimeBucket, Instant[])"})
  void testNewRBMBackedTimestampSet() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> new RBMBackedTimestampSet(TimeBucket.SECOND,
        LocalDate.ofYearDay(1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

  }

  /**
   * Test {@link RBMBackedTimestampSet#RBMBackedTimestampSet(TimeBucket, Instant[])}.
   * <p>
   * Method under test: {@link RBMBackedTimestampSet#RBMBackedTimestampSet(TimeBucket, Instant[])}
   */
  @Test
  @DisplayName("Test new RBMBackedTimestampSet(TimeBucket, Instant[])")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void RBMBackedTimestampSet.<init>(TimeBucket, Instant[])"})
  void testNewRBMBackedTimestampSet2() {
    // Arrange
    Instant toInstantResult = LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant();

    // Act
    RBMBackedTimestampSet actualRbmBackedTimestampSet = new RBMBackedTimestampSet(TimeBucket.SECOND, toInstantResult,
        LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Assert
    assertEquals(actualRbmBackedTimestampSet, actualRbmBackedTimestampSet.getShallowClone());
  }

  /**
   * Test {@link RBMBackedTimestampSet#RBMBackedTimestampSet(TimeBucket, Instant[])}.
   * <p>
   * Method under test: {@link RBMBackedTimestampSet#RBMBackedTimestampSet(TimeBucket, Instant[])}
   */
  @Test
  @DisplayName("Test new RBMBackedTimestampSet(TimeBucket, Instant[])")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void RBMBackedTimestampSet.<init>(TimeBucket, Instant[])"})
  void testNewRBMBackedTimestampSet3() {
    // Arrange
    Instant toInstantResult = LocalDate.now().atStartOfDay().atZone(ZoneOffset.UTC).toInstant();

    // Act
    RBMBackedTimestampSet actualRbmBackedTimestampSet = new RBMBackedTimestampSet(TimeBucket.SECOND, toInstantResult,
        LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Assert
    assertEquals(actualRbmBackedTimestampSet, actualRbmBackedTimestampSet.getShallowClone());
  }

  /**
   * Test {@link RBMBackedTimestampSet#RBMBackedTimestampSet(TimeBucket, Instant[])}.
   * <p>
   * Method under test: {@link RBMBackedTimestampSet#RBMBackedTimestampSet(TimeBucket, Instant[])}
   */
  @Test
  @DisplayName("Test new RBMBackedTimestampSet(TimeBucket, Instant[])")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void RBMBackedTimestampSet.<init>(TimeBucket, Instant[])"})
  void testNewRBMBackedTimestampSet4() {
    // Arrange
    Instant toInstantResult = LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant();

    // Act
    RBMBackedTimestampSet actualRbmBackedTimestampSet = new RBMBackedTimestampSet(TimeBucket.SECOND, toInstantResult,
        LocalDate.now().atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Assert
    assertEquals(actualRbmBackedTimestampSet, actualRbmBackedTimestampSet.getShallowClone());
  }

  /**
   * Test {@link RBMBackedTimestampSet#RBMBackedTimestampSet(TimeBucket, Instant[])}.
   * <ul>
   *   <li>When {@code DAY}.</li>
   *   <li>Then return TimeBucket is {@code DAY}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RBMBackedTimestampSet#RBMBackedTimestampSet(TimeBucket, Instant[])}
   */
  @Test
  @DisplayName("Test new RBMBackedTimestampSet(TimeBucket, Instant[]); when 'DAY'; then return TimeBucket is 'DAY'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void RBMBackedTimestampSet.<init>(TimeBucket, Instant[])"})
  void testNewRBMBackedTimestampSet_whenDay_thenReturnTimeBucketIsDay() {
    // Arrange and Act
    RBMBackedTimestampSet actualRbmBackedTimestampSet = new RBMBackedTimestampSet(TimeBucket.DAY,
        LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Assert
    assertEquals(TimeBucket.DAY, actualRbmBackedTimestampSet.getTimeBucket());
    assertEquals(actualRbmBackedTimestampSet, actualRbmBackedTimestampSet.getShallowClone());
  }

  /**
   * Test {@link RBMBackedTimestampSet#RBMBackedTimestampSet(TimeBucket, Instant[])}.
   * <ul>
   *   <li>When {@code HOUR}.</li>
   *   <li>Then return TimeBucket is {@code HOUR}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RBMBackedTimestampSet#RBMBackedTimestampSet(TimeBucket, Instant[])}
   */
  @Test
  @DisplayName("Test new RBMBackedTimestampSet(TimeBucket, Instant[]); when 'HOUR'; then return TimeBucket is 'HOUR'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void RBMBackedTimestampSet.<init>(TimeBucket, Instant[])"})
  void testNewRBMBackedTimestampSet_whenHour_thenReturnTimeBucketIsHour() {
    // Arrange and Act
    RBMBackedTimestampSet actualRbmBackedTimestampSet = new RBMBackedTimestampSet(TimeBucket.HOUR,
        LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Assert
    assertEquals(TimeBucket.HOUR, actualRbmBackedTimestampSet.getTimeBucket());
    assertEquals(actualRbmBackedTimestampSet, actualRbmBackedTimestampSet.getShallowClone());
  }

  /**
   * Test {@link RBMBackedTimestampSet#RBMBackedTimestampSet(TimeBucket)}.
   * <ul>
   *   <li>When {@code MILLISECOND}.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RBMBackedTimestampSet#RBMBackedTimestampSet(TimeBucket)}
   */
  @Test
  @DisplayName("Test new RBMBackedTimestampSet(TimeBucket); when 'MILLISECOND'; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void RBMBackedTimestampSet.<init>(TimeBucket)"})
  void testNewRBMBackedTimestampSet_whenMillisecond_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> new RBMBackedTimestampSet(TimeBucket.MILLISECOND));
  }

  /**
   * Test {@link RBMBackedTimestampSet#RBMBackedTimestampSet(TimeBucket, Instant[])}.
   * <ul>
   *   <li>When {@code MILLISECOND}.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RBMBackedTimestampSet#RBMBackedTimestampSet(TimeBucket, Instant[])}
   */
  @Test
  @DisplayName("Test new RBMBackedTimestampSet(TimeBucket, Instant[]); when 'MILLISECOND'; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void RBMBackedTimestampSet.<init>(TimeBucket, Instant[])"})
  void testNewRBMBackedTimestampSet_whenMillisecond_thenThrowIllegalArgumentException2() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> new RBMBackedTimestampSet(TimeBucket.MILLISECOND,
        LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

  }

  /**
   * Test {@link RBMBackedTimestampSet#RBMBackedTimestampSet(TimeBucket, Instant[])}.
   * <ul>
   *   <li>When {@code MINUTE}.</li>
   *   <li>Then return TimeBucket is {@code MINUTE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RBMBackedTimestampSet#RBMBackedTimestampSet(TimeBucket, Instant[])}
   */
  @Test
  @DisplayName("Test new RBMBackedTimestampSet(TimeBucket, Instant[]); when 'MINUTE'; then return TimeBucket is 'MINUTE'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void RBMBackedTimestampSet.<init>(TimeBucket, Instant[])"})
  void testNewRBMBackedTimestampSet_whenMinute_thenReturnTimeBucketIsMinute() {
    // Arrange and Act
    RBMBackedTimestampSet actualRbmBackedTimestampSet = new RBMBackedTimestampSet(TimeBucket.MINUTE,
        LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Assert
    assertEquals(TimeBucket.MINUTE, actualRbmBackedTimestampSet.getTimeBucket());
    assertEquals(actualRbmBackedTimestampSet, actualRbmBackedTimestampSet.getShallowClone());
  }

  /**
   * Test {@link RBMBackedTimestampSet#RBMBackedTimestampSet(TimeBucket, Instant[])}.
   * <ul>
   *   <li>When {@code MONTH}.</li>
   *   <li>Then return TimeBucket is {@code MONTH}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RBMBackedTimestampSet#RBMBackedTimestampSet(TimeBucket, Instant[])}
   */
  @Test
  @DisplayName("Test new RBMBackedTimestampSet(TimeBucket, Instant[]); when 'MONTH'; then return TimeBucket is 'MONTH'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void RBMBackedTimestampSet.<init>(TimeBucket, Instant[])"})
  void testNewRBMBackedTimestampSet_whenMonth_thenReturnTimeBucketIsMonth() {
    // Arrange and Act
    RBMBackedTimestampSet actualRbmBackedTimestampSet = new RBMBackedTimestampSet(TimeBucket.MONTH,
        LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Assert
    assertEquals(TimeBucket.MONTH, actualRbmBackedTimestampSet.getTimeBucket());
    assertEquals(actualRbmBackedTimestampSet, actualRbmBackedTimestampSet.getShallowClone());
  }

  /**
   * Test {@link RBMBackedTimestampSet#RBMBackedTimestampSet(TimeBucket, Instant[])}.
   * <ul>
   *   <li>When {@code SECOND}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RBMBackedTimestampSet#RBMBackedTimestampSet(TimeBucket, Instant[])}
   */
  @Test
  @DisplayName("Test new RBMBackedTimestampSet(TimeBucket, Instant[]); when 'SECOND'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void RBMBackedTimestampSet.<init>(TimeBucket, Instant[])"})
  void testNewRBMBackedTimestampSet_whenSecond() {
    // Arrange and Act
    RBMBackedTimestampSet actualRbmBackedTimestampSet = new RBMBackedTimestampSet(TimeBucket.SECOND,
        LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Assert
    assertEquals(actualRbmBackedTimestampSet, actualRbmBackedTimestampSet.getShallowClone());
  }

  /**
   * Test {@link RBMBackedTimestampSet#RBMBackedTimestampSet(TimeBucket)}.
   * <ul>
   *   <li>When {@code SECOND}.</li>
   *   <li>Then return Earliest is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RBMBackedTimestampSet#RBMBackedTimestampSet(TimeBucket)}
   */
  @Test
  @DisplayName("Test new RBMBackedTimestampSet(TimeBucket); when 'SECOND'; then return Earliest is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void RBMBackedTimestampSet.<init>(TimeBucket)"})
  void testNewRBMBackedTimestampSet_whenSecond_thenReturnEarliestIsNull() {
    // Arrange and Act
    RBMBackedTimestampSet actualRbmBackedTimestampSet = new RBMBackedTimestampSet(TimeBucket.SECOND);

    // Assert
    assertNull(actualRbmBackedTimestampSet.getEarliest());
    assertNull(actualRbmBackedTimestampSet.getLatest());
    RoaringBitmap rbm = actualRbmBackedTimestampSet.getRbm();
    assertEquals(0, rbm.getCardinality());
    assertEquals(0L, actualRbmBackedTimestampSet.getNumberOfTimestamps());
    assertEquals(8, rbm.getSizeInBytes());
    assertEquals(TimeBucket.SECOND, actualRbmBackedTimestampSet.getTimeBucket());
    assertFalse(rbm.iterator().hasNext());
    assertFalse(rbm.hasRunCompression());
    assertTrue(actualRbmBackedTimestampSet.getTimestamps().isEmpty());
    assertTrue(rbm.isEmpty());
    assertEquals(actualRbmBackedTimestampSet, actualRbmBackedTimestampSet.getShallowClone());
  }

  /**
   * Test {@link RBMBackedTimestampSet#RBMBackedTimestampSet(TimeBucket, Instant[])}.
   * <ul>
   *   <li>When {@code SECOND}.</li>
   *   <li>Then return Earliest is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RBMBackedTimestampSet#RBMBackedTimestampSet(TimeBucket, Instant[])}
   */
  @Test
  @DisplayName("Test new RBMBackedTimestampSet(TimeBucket, Instant[]); when 'SECOND'; then return Earliest is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void RBMBackedTimestampSet.<init>(TimeBucket, Instant[])"})
  void testNewRBMBackedTimestampSet_whenSecond_thenReturnEarliestIsNull2() {
    // Arrange and Act
    RBMBackedTimestampSet actualRbmBackedTimestampSet = new RBMBackedTimestampSet(TimeBucket.SECOND, new Instant[]{});

    // Assert
    assertNull(actualRbmBackedTimestampSet.getEarliest());
    RBMBackedTimestampSet shallowClone = actualRbmBackedTimestampSet.getShallowClone();
    assertNull(shallowClone.getEarliest());
    assertNull(actualRbmBackedTimestampSet.getLatest());
    assertNull(shallowClone.getLatest());
    RoaringBitmap rbm = actualRbmBackedTimestampSet.getRbm();
    assertEquals(0, rbm.getCardinality());
    assertEquals(0L, actualRbmBackedTimestampSet.getNumberOfTimestamps());
    assertEquals(0L, shallowClone.getNumberOfTimestamps());
    assertEquals(8, rbm.getSizeInBytes());
    assertFalse(rbm.iterator().hasNext());
    assertTrue(actualRbmBackedTimestampSet.getTimestamps().isEmpty());
    assertTrue(rbm.isEmpty());
  }

  /**
   * Test {@link RBMBackedTimestampSet#RBMBackedTimestampSet(TimeBucket, Instant[])}.
   * <ul>
   *   <li>When {@code WEEK}.</li>
   *   <li>Then return Earliest EpochSecond is {@code -259200}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RBMBackedTimestampSet#RBMBackedTimestampSet(TimeBucket, Instant[])}
   */
  @Test
  @DisplayName("Test new RBMBackedTimestampSet(TimeBucket, Instant[]); when 'WEEK'; then return Earliest EpochSecond is '-259200'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void RBMBackedTimestampSet.<init>(TimeBucket, Instant[])"})
  void testNewRBMBackedTimestampSet_whenWeek_thenReturnEarliestEpochSecondIs259200() {
    // Arrange and Act
    RBMBackedTimestampSet actualRbmBackedTimestampSet = new RBMBackedTimestampSet(TimeBucket.WEEK,
        LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Assert
    Instant earliest = actualRbmBackedTimestampSet.getEarliest();
    assertEquals(-259200L, earliest.getEpochSecond());
    Iterator<Integer> iteratorResult = actualRbmBackedTimestampSet.getRbm().iterator();
    assertEquals(-3, iteratorResult.next().intValue());
    assertEquals(TimeBucket.WEEK, actualRbmBackedTimestampSet.getTimeBucket());
    assertFalse(iteratorResult.hasNext());
    assertEquals(earliest, actualRbmBackedTimestampSet.getLatest());
  }

  /**
   * Test {@link RBMBackedTimestampSet#RBMBackedTimestampSet(TimeBucket, Instant[])}.
   * <ul>
   *   <li>When {@code YEAR}.</li>
   *   <li>Then return TimeBucket is {@code YEAR}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RBMBackedTimestampSet#RBMBackedTimestampSet(TimeBucket, Instant[])}
   */
  @Test
  @DisplayName("Test new RBMBackedTimestampSet(TimeBucket, Instant[]); when 'YEAR'; then return TimeBucket is 'YEAR'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void RBMBackedTimestampSet.<init>(TimeBucket, Instant[])"})
  void testNewRBMBackedTimestampSet_whenYear_thenReturnTimeBucketIsYear() {
    // Arrange and Act
    RBMBackedTimestampSet actualRbmBackedTimestampSet = new RBMBackedTimestampSet(TimeBucket.YEAR,
        LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Assert
    assertEquals(TimeBucket.YEAR, actualRbmBackedTimestampSet.getTimeBucket());
    assertEquals(actualRbmBackedTimestampSet, actualRbmBackedTimestampSet.getShallowClone());
  }

  /**
   * Test {@link RBMBackedTimestampSet#add(Instant)} with {@code instant}.
   * <p>
   * Method under test: {@link RBMBackedTimestampSet#add(Instant)}
   */
  @Test
  @DisplayName("Test add(Instant) with 'instant'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void RBMBackedTimestampSet.add(Instant)"})
  void testAddWithInstant() {
    // Arrange
    RBMBackedTimestampSet rbmBackedTimestampSet = new RBMBackedTimestampSet(TimeBucket.SECOND);
    Instant instant = LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant();

    // Act
    rbmBackedTimestampSet.add(instant);

    // Assert
    RBMBackedTimestampSet shallowClone = rbmBackedTimestampSet.getShallowClone();
    assertEquals(1L, shallowClone.getNumberOfTimestamps());
    RBMBackedTimestampSet shallowClone2 = shallowClone.getShallowClone();
    assertEquals(1L, shallowClone2.getNumberOfTimestamps());
    RBMBackedTimestampSet shallowClone3 = shallowClone2.getShallowClone();
    assertEquals(1L, shallowClone3.getNumberOfTimestamps());
    RBMBackedTimestampSet shallowClone4 = shallowClone3.getShallowClone();
    assertEquals(1L, shallowClone4.getNumberOfTimestamps());
    Instant instant2 = instant.EPOCH;
    assertSame(instant2, shallowClone.getEarliest());
    assertSame(instant2, shallowClone2.getEarliest());
    assertSame(instant2, shallowClone3.getEarliest());
    assertSame(instant2, shallowClone4.getEarliest());
    assertSame(instant2, rbmBackedTimestampSet.getLatest());
    assertSame(instant2, shallowClone.getLatest());
    assertSame(instant2, shallowClone2.getLatest());
    assertSame(instant2, shallowClone3.getLatest());
    assertSame(instant2, shallowClone4.getLatest());
  }

  /**
   * Test {@link RBMBackedTimestampSet#add(Instant)} with {@code instant}.
   * <p>
   * Method under test: {@link RBMBackedTimestampSet#add(Instant)}
   */
  @Test
  @DisplayName("Test add(Instant) with 'instant'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void RBMBackedTimestampSet.add(Instant)"})
  void testAddWithInstant2() {
    // Arrange
    RBMBackedTimestampSet rbmBackedTimestampSet = new RBMBackedTimestampSet(TimeBucket.MINUTE);
    Instant instant = LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant();

    // Act
    rbmBackedTimestampSet.add(instant);

    // Assert
    RBMBackedTimestampSet shallowClone = rbmBackedTimestampSet.getShallowClone();
    assertEquals(1L, shallowClone.getNumberOfTimestamps());
    RBMBackedTimestampSet shallowClone2 = shallowClone.getShallowClone();
    assertEquals(1L, shallowClone2.getNumberOfTimestamps());
    RBMBackedTimestampSet shallowClone3 = shallowClone2.getShallowClone();
    assertEquals(1L, shallowClone3.getNumberOfTimestamps());
    RBMBackedTimestampSet shallowClone4 = shallowClone3.getShallowClone();
    assertEquals(1L, shallowClone4.getNumberOfTimestamps());
    Instant instant2 = instant.EPOCH;
    assertSame(instant2, shallowClone.getEarliest());
    assertSame(instant2, shallowClone2.getEarliest());
    assertSame(instant2, shallowClone3.getEarliest());
    assertSame(instant2, shallowClone4.getEarliest());
    assertSame(instant2, rbmBackedTimestampSet.getLatest());
    assertSame(instant2, shallowClone.getLatest());
    assertSame(instant2, shallowClone2.getLatest());
    assertSame(instant2, shallowClone3.getLatest());
    assertSame(instant2, shallowClone4.getLatest());
  }

  /**
   * Test {@link RBMBackedTimestampSet#add(Instant)} with {@code instant}.
   * <p>
   * Method under test: {@link RBMBackedTimestampSet#add(Instant)}
   */
  @Test
  @DisplayName("Test add(Instant) with 'instant'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void RBMBackedTimestampSet.add(Instant)"})
  void testAddWithInstant3() {
    // Arrange
    RBMBackedTimestampSet rbmBackedTimestampSet = new RBMBackedTimestampSet(TimeBucket.HOUR);
    Instant instant = LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant();

    // Act
    rbmBackedTimestampSet.add(instant);

    // Assert
    RBMBackedTimestampSet shallowClone = rbmBackedTimestampSet.getShallowClone();
    assertEquals(1L, shallowClone.getNumberOfTimestamps());
    RBMBackedTimestampSet shallowClone2 = shallowClone.getShallowClone();
    assertEquals(1L, shallowClone2.getNumberOfTimestamps());
    RBMBackedTimestampSet shallowClone3 = shallowClone2.getShallowClone();
    assertEquals(1L, shallowClone3.getNumberOfTimestamps());
    RBMBackedTimestampSet shallowClone4 = shallowClone3.getShallowClone();
    assertEquals(1L, shallowClone4.getNumberOfTimestamps());
    Instant instant2 = instant.EPOCH;
    assertSame(instant2, shallowClone.getEarliest());
    assertSame(instant2, shallowClone2.getEarliest());
    assertSame(instant2, shallowClone3.getEarliest());
    assertSame(instant2, shallowClone4.getEarliest());
    assertSame(instant2, rbmBackedTimestampSet.getLatest());
    assertSame(instant2, shallowClone.getLatest());
    assertSame(instant2, shallowClone2.getLatest());
    assertSame(instant2, shallowClone3.getLatest());
    assertSame(instant2, shallowClone4.getLatest());
  }

  /**
   * Test {@link RBMBackedTimestampSet#add(Instant)} with {@code instant}.
   * <p>
   * Method under test: {@link RBMBackedTimestampSet#add(Instant)}
   */
  @Test
  @DisplayName("Test add(Instant) with 'instant'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void RBMBackedTimestampSet.add(Instant)"})
  void testAddWithInstant4() {
    // Arrange
    RBMBackedTimestampSet rbmBackedTimestampSet = new RBMBackedTimestampSet(TimeBucket.DAY);
    Instant instant = LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant();

    // Act
    rbmBackedTimestampSet.add(instant);

    // Assert
    RBMBackedTimestampSet shallowClone = rbmBackedTimestampSet.getShallowClone();
    assertEquals(1L, shallowClone.getNumberOfTimestamps());
    RBMBackedTimestampSet shallowClone2 = shallowClone.getShallowClone();
    assertEquals(1L, shallowClone2.getNumberOfTimestamps());
    RBMBackedTimestampSet shallowClone3 = shallowClone2.getShallowClone();
    assertEquals(1L, shallowClone3.getNumberOfTimestamps());
    RBMBackedTimestampSet shallowClone4 = shallowClone3.getShallowClone();
    assertEquals(1L, shallowClone4.getNumberOfTimestamps());
    Instant instant2 = instant.EPOCH;
    assertSame(instant2, shallowClone.getEarliest());
    assertSame(instant2, shallowClone2.getEarliest());
    assertSame(instant2, shallowClone3.getEarliest());
    assertSame(instant2, shallowClone4.getEarliest());
    assertSame(instant2, rbmBackedTimestampSet.getLatest());
    assertSame(instant2, shallowClone.getLatest());
    assertSame(instant2, shallowClone2.getLatest());
    assertSame(instant2, shallowClone3.getLatest());
    assertSame(instant2, shallowClone4.getLatest());
  }

  /**
   * Test {@link RBMBackedTimestampSet#add(Instant)} with {@code instant}.
   * <p>
   * Method under test: {@link RBMBackedTimestampSet#add(Instant)}
   */
  @Test
  @DisplayName("Test add(Instant) with 'instant'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void RBMBackedTimestampSet.add(Instant)"})
  void testAddWithInstant5() {
    // Arrange
    RBMBackedTimestampSet rbmBackedTimestampSet = new RBMBackedTimestampSet(TimeBucket.WEEK);

    // Act
    rbmBackedTimestampSet.add(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Assert
    Instant earliest = rbmBackedTimestampSet.getEarliest();
    assertEquals(-259200L, earliest.getEpochSecond());
    Iterator<Integer> iteratorResult = rbmBackedTimestampSet.getRbm().iterator();
    assertEquals(-3, iteratorResult.next().intValue());
    assertEquals(0, earliest.getNano());
    assertFalse(iteratorResult.hasNext());
    assertEquals(earliest, rbmBackedTimestampSet.getLatest());
  }

  /**
   * Test {@link RBMBackedTimestampSet#add(Instant)} with {@code instant}.
   * <p>
   * Method under test: {@link RBMBackedTimestampSet#add(Instant)}
   */
  @Test
  @DisplayName("Test add(Instant) with 'instant'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void RBMBackedTimestampSet.add(Instant)"})
  void testAddWithInstant6() {
    // Arrange
    RBMBackedTimestampSet rbmBackedTimestampSet = new RBMBackedTimestampSet(TimeBucket.WEEK);
    Builder timeBucketResult = (new Builder()).timeBucket(TimeBucket.SECOND);
    RBMBackedTimestampSet other = timeBucketResult
        .timestamp(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant())
        .build();
    rbmBackedTimestampSet.addAll(other);

    // Act
    rbmBackedTimestampSet.add(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Assert
    Instant latest = rbmBackedTimestampSet.getLatest();
    assertEquals(-259200L, latest.getEpochSecond());
    assertEquals(0, latest.getNano());
  }

  /**
   * Test {@link RBMBackedTimestampSet#add(Instant)} with {@code instant}.
   * <p>
   * Method under test: {@link RBMBackedTimestampSet#add(Instant)}
   */
  @Test
  @DisplayName("Test add(Instant) with 'instant'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void RBMBackedTimestampSet.add(Instant)"})
  void testAddWithInstant7() {
    // Arrange
    RBMBackedTimestampSet rbmBackedTimestampSet = new RBMBackedTimestampSet(TimeBucket.MONTH);
    Instant instant = LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant();

    // Act
    rbmBackedTimestampSet.add(instant);

    // Assert
    RBMBackedTimestampSet shallowClone = rbmBackedTimestampSet.getShallowClone();
    assertEquals(1L, shallowClone.getNumberOfTimestamps());
    RBMBackedTimestampSet shallowClone2 = shallowClone.getShallowClone();
    assertEquals(1L, shallowClone2.getNumberOfTimestamps());
    RBMBackedTimestampSet shallowClone3 = shallowClone2.getShallowClone();
    assertEquals(1L, shallowClone3.getNumberOfTimestamps());
    RBMBackedTimestampSet shallowClone4 = shallowClone3.getShallowClone();
    assertEquals(1L, shallowClone4.getNumberOfTimestamps());
    Instant instant2 = instant.EPOCH;
    assertSame(instant2, shallowClone.getEarliest());
    assertSame(instant2, shallowClone2.getEarliest());
    assertSame(instant2, shallowClone3.getEarliest());
    assertSame(instant2, shallowClone4.getEarliest());
    assertSame(instant2, rbmBackedTimestampSet.getLatest());
    assertSame(instant2, shallowClone.getLatest());
    assertSame(instant2, shallowClone2.getLatest());
    assertSame(instant2, shallowClone3.getLatest());
    assertSame(instant2, shallowClone4.getLatest());
  }

  /**
   * Test {@link RBMBackedTimestampSet#add(Instant)} with {@code instant}.
   * <p>
   * Method under test: {@link RBMBackedTimestampSet#add(Instant)}
   */
  @Test
  @DisplayName("Test add(Instant) with 'instant'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void RBMBackedTimestampSet.add(Instant)"})
  void testAddWithInstant8() {
    // Arrange
    RBMBackedTimestampSet rbmBackedTimestampSet = new RBMBackedTimestampSet(TimeBucket.YEAR);
    Instant instant = LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant();

    // Act
    rbmBackedTimestampSet.add(instant);

    // Assert
    RBMBackedTimestampSet shallowClone = rbmBackedTimestampSet.getShallowClone();
    assertEquals(1L, shallowClone.getNumberOfTimestamps());
    RBMBackedTimestampSet shallowClone2 = shallowClone.getShallowClone();
    assertEquals(1L, shallowClone2.getNumberOfTimestamps());
    RBMBackedTimestampSet shallowClone3 = shallowClone2.getShallowClone();
    assertEquals(1L, shallowClone3.getNumberOfTimestamps());
    RBMBackedTimestampSet shallowClone4 = shallowClone3.getShallowClone();
    assertEquals(1L, shallowClone4.getNumberOfTimestamps());
    Instant instant2 = instant.EPOCH;
    assertSame(instant2, shallowClone.getEarliest());
    assertSame(instant2, shallowClone2.getEarliest());
    assertSame(instant2, shallowClone3.getEarliest());
    assertSame(instant2, shallowClone4.getEarliest());
    assertSame(instant2, rbmBackedTimestampSet.getLatest());
    assertSame(instant2, shallowClone.getLatest());
    assertSame(instant2, shallowClone2.getLatest());
    assertSame(instant2, shallowClone3.getLatest());
    assertSame(instant2, shallowClone4.getLatest());
  }

  /**
   * Test {@link RBMBackedTimestampSet#add(Instant)} with {@code instant}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RBMBackedTimestampSet#add(Instant)}
   */
  @Test
  @DisplayName("Test add(Instant) with 'instant'; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void RBMBackedTimestampSet.add(Instant)"})
  void testAddWithInstant_thenThrowIllegalArgumentException() {
    // Arrange
    RBMBackedTimestampSet rbmBackedTimestampSet = new RBMBackedTimestampSet(TimeBucket.SECOND);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> rbmBackedTimestampSet.add(LocalDate.ofYearDay(1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
  }

  /**
   * Test {@link RBMBackedTimestampSet#add(Collection)} with {@code instants}.
   * <p>
   * Method under test: {@link RBMBackedTimestampSet#add(Collection)}
   */
  @Test
  @DisplayName("Test add(Collection) with 'instants'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void RBMBackedTimestampSet.add(Collection)"})
  void testAddWithInstants() {
    // Arrange
    RBMBackedTimestampSet rbmBackedTimestampSet = new RBMBackedTimestampSet(TimeBucket.SECOND);

    // Act
    rbmBackedTimestampSet.add(new ArrayList<>());

    // Assert that nothing has changed
    RoaringBitmap rbm = rbmBackedTimestampSet.getRbm();
    assertEquals(0, rbm.getCardinality());
    assertEquals(0L, rbmBackedTimestampSet.getNumberOfTimestamps());
    assertEquals(8, rbm.getSizeInBytes());
    assertFalse(rbm.iterator().hasNext());
    assertTrue(rbmBackedTimestampSet.getTimestamps().isEmpty());
  }

  /**
   * Test {@link RBMBackedTimestampSet#add(Collection)} with {@code instants}.
   * <p>
   * Method under test: {@link RBMBackedTimestampSet#add(Collection)}
   */
  @Test
  @DisplayName("Test add(Collection) with 'instants'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void RBMBackedTimestampSet.add(Collection)"})
  void testAddWithInstants2() {
    // Arrange
    RBMBackedTimestampSet rbmBackedTimestampSet = new RBMBackedTimestampSet(TimeBucket.SECOND);

    ArrayList<Instant> instants = new ArrayList<>();
    instants.add(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Act
    rbmBackedTimestampSet.add(instants);

    // Assert
    RBMBackedTimestampSet shallowClone = rbmBackedTimestampSet.getShallowClone();
    assertEquals(1L, shallowClone.getNumberOfTimestamps());
    RBMBackedTimestampSet shallowClone2 = shallowClone.getShallowClone();
    assertEquals(1L, shallowClone2.getNumberOfTimestamps());
    RBMBackedTimestampSet shallowClone3 = shallowClone2.getShallowClone();
    assertEquals(1L, shallowClone3.getNumberOfTimestamps());
    assertEquals(1L, shallowClone3.getShallowClone().getNumberOfTimestamps());
  }

  /**
   * Test {@link RBMBackedTimestampSet#add(Collection)} with {@code instants}.
   * <p>
   * Method under test: {@link RBMBackedTimestampSet#add(Collection)}
   */
  @Test
  @DisplayName("Test add(Collection) with 'instants'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void RBMBackedTimestampSet.add(Collection)"})
  void testAddWithInstants3() {
    // Arrange
    RBMBackedTimestampSet rbmBackedTimestampSet = new RBMBackedTimestampSet(TimeBucket.SECOND);

    ArrayList<Instant> instants = new ArrayList<>();
    instants.add(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
    instants.add(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Act
    rbmBackedTimestampSet.add(instants);

    // Assert
    RBMBackedTimestampSet shallowClone = rbmBackedTimestampSet.getShallowClone();
    assertEquals(1L, shallowClone.getNumberOfTimestamps());
    RBMBackedTimestampSet shallowClone2 = shallowClone.getShallowClone();
    assertEquals(1L, shallowClone2.getNumberOfTimestamps());
    RBMBackedTimestampSet shallowClone3 = shallowClone2.getShallowClone();
    assertEquals(1L, shallowClone3.getNumberOfTimestamps());
    assertEquals(1L, shallowClone3.getShallowClone().getNumberOfTimestamps());
  }

  /**
   * Test {@link RBMBackedTimestampSet#add(Collection)} with {@code instants}.
   * <p>
   * Method under test: {@link RBMBackedTimestampSet#add(Collection)}
   */
  @Test
  @DisplayName("Test add(Collection) with 'instants'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void RBMBackedTimestampSet.add(Collection)"})
  void testAddWithInstants4() {
    // Arrange
    RBMBackedTimestampSet rbmBackedTimestampSet = new RBMBackedTimestampSet(TimeBucket.MINUTE);

    ArrayList<Instant> instants = new ArrayList<>();
    instants.add(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Act
    rbmBackedTimestampSet.add(instants);

    // Assert
    RBMBackedTimestampSet shallowClone = rbmBackedTimestampSet.getShallowClone();
    assertEquals(1L, shallowClone.getNumberOfTimestamps());
    RBMBackedTimestampSet shallowClone2 = shallowClone.getShallowClone();
    assertEquals(1L, shallowClone2.getNumberOfTimestamps());
    RBMBackedTimestampSet shallowClone3 = shallowClone2.getShallowClone();
    assertEquals(1L, shallowClone3.getNumberOfTimestamps());
    assertEquals(1L, shallowClone3.getShallowClone().getNumberOfTimestamps());
  }

  /**
   * Test {@link RBMBackedTimestampSet#add(Collection)} with {@code instants}.
   * <p>
   * Method under test: {@link RBMBackedTimestampSet#add(Collection)}
   */
  @Test
  @DisplayName("Test add(Collection) with 'instants'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void RBMBackedTimestampSet.add(Collection)"})
  void testAddWithInstants5() {
    // Arrange
    RBMBackedTimestampSet rbmBackedTimestampSet = new RBMBackedTimestampSet(TimeBucket.HOUR);

    ArrayList<Instant> instants = new ArrayList<>();
    instants.add(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Act
    rbmBackedTimestampSet.add(instants);

    // Assert
    RBMBackedTimestampSet shallowClone = rbmBackedTimestampSet.getShallowClone();
    assertEquals(1L, shallowClone.getNumberOfTimestamps());
    RBMBackedTimestampSet shallowClone2 = shallowClone.getShallowClone();
    assertEquals(1L, shallowClone2.getNumberOfTimestamps());
    RBMBackedTimestampSet shallowClone3 = shallowClone2.getShallowClone();
    assertEquals(1L, shallowClone3.getNumberOfTimestamps());
    assertEquals(1L, shallowClone3.getShallowClone().getNumberOfTimestamps());
  }

  /**
   * Test {@link RBMBackedTimestampSet#add(Collection)} with {@code instants}.
   * <p>
   * Method under test: {@link RBMBackedTimestampSet#add(Collection)}
   */
  @Test
  @DisplayName("Test add(Collection) with 'instants'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void RBMBackedTimestampSet.add(Collection)"})
  void testAddWithInstants6() {
    // Arrange
    RBMBackedTimestampSet rbmBackedTimestampSet = new RBMBackedTimestampSet(TimeBucket.DAY);

    ArrayList<Instant> instants = new ArrayList<>();
    instants.add(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Act
    rbmBackedTimestampSet.add(instants);

    // Assert
    RBMBackedTimestampSet shallowClone = rbmBackedTimestampSet.getShallowClone();
    assertEquals(1L, shallowClone.getNumberOfTimestamps());
    RBMBackedTimestampSet shallowClone2 = shallowClone.getShallowClone();
    assertEquals(1L, shallowClone2.getNumberOfTimestamps());
    RBMBackedTimestampSet shallowClone3 = shallowClone2.getShallowClone();
    assertEquals(1L, shallowClone3.getNumberOfTimestamps());
    assertEquals(1L, shallowClone3.getShallowClone().getNumberOfTimestamps());
  }

  /**
   * Test {@link RBMBackedTimestampSet#add(Collection)} with {@code instants}.
   * <p>
   * Method under test: {@link RBMBackedTimestampSet#add(Collection)}
   */
  @Test
  @DisplayName("Test add(Collection) with 'instants'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void RBMBackedTimestampSet.add(Collection)"})
  void testAddWithInstants7() {
    // Arrange
    RBMBackedTimestampSet rbmBackedTimestampSet = new RBMBackedTimestampSet(TimeBucket.WEEK);

    ArrayList<Instant> instants = new ArrayList<>();
    instants.add(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Act
    rbmBackedTimestampSet.add(instants);

    // Assert
    Instant earliest = rbmBackedTimestampSet.getEarliest();
    assertEquals(-259200L, earliest.getEpochSecond());
    Iterator<Integer> iteratorResult = rbmBackedTimestampSet.getRbm().iterator();
    assertEquals(-3, iteratorResult.next().intValue());
    assertEquals(0, earliest.getNano());
    assertFalse(iteratorResult.hasNext());
    assertEquals(earliest, rbmBackedTimestampSet.getLatest());
  }

  /**
   * Test {@link RBMBackedTimestampSet#add(Collection)} with {@code instants}.
   * <p>
   * Method under test: {@link RBMBackedTimestampSet#add(Collection)}
   */
  @Test
  @DisplayName("Test add(Collection) with 'instants'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void RBMBackedTimestampSet.add(Collection)"})
  void testAddWithInstants8() {
    // Arrange
    RBMBackedTimestampSet rbmBackedTimestampSet = new RBMBackedTimestampSet(TimeBucket.MONTH);

    ArrayList<Instant> instants = new ArrayList<>();
    instants.add(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Act
    rbmBackedTimestampSet.add(instants);

    // Assert
    RBMBackedTimestampSet shallowClone = rbmBackedTimestampSet.getShallowClone();
    assertEquals(1L, shallowClone.getNumberOfTimestamps());
    RBMBackedTimestampSet shallowClone2 = shallowClone.getShallowClone();
    assertEquals(1L, shallowClone2.getNumberOfTimestamps());
    RBMBackedTimestampSet shallowClone3 = shallowClone2.getShallowClone();
    assertEquals(1L, shallowClone3.getNumberOfTimestamps());
    assertEquals(1L, shallowClone3.getShallowClone().getNumberOfTimestamps());
  }

  /**
   * Test {@link RBMBackedTimestampSet#add(Collection)} with {@code instants}.
   * <p>
   * Method under test: {@link RBMBackedTimestampSet#add(Collection)}
   */
  @Test
  @DisplayName("Test add(Collection) with 'instants'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void RBMBackedTimestampSet.add(Collection)"})
  void testAddWithInstants9() {
    // Arrange
    RBMBackedTimestampSet rbmBackedTimestampSet = new RBMBackedTimestampSet(TimeBucket.YEAR);

    ArrayList<Instant> instants = new ArrayList<>();
    instants.add(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Act
    rbmBackedTimestampSet.add(instants);

    // Assert
    RBMBackedTimestampSet shallowClone = rbmBackedTimestampSet.getShallowClone();
    assertEquals(1L, shallowClone.getNumberOfTimestamps());
    RBMBackedTimestampSet shallowClone2 = shallowClone.getShallowClone();
    assertEquals(1L, shallowClone2.getNumberOfTimestamps());
    RBMBackedTimestampSet shallowClone3 = shallowClone2.getShallowClone();
    assertEquals(1L, shallowClone3.getNumberOfTimestamps());
    assertEquals(1L, shallowClone3.getShallowClone().getNumberOfTimestamps());
  }

  /**
   * Test {@link RBMBackedTimestampSet#add(Collection)} with {@code instants}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RBMBackedTimestampSet#add(Collection)}
   */
  @Test
  @DisplayName("Test add(Collection) with 'instants'; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void RBMBackedTimestampSet.add(Collection)"})
  void testAddWithInstants_thenThrowIllegalArgumentException() {
    // Arrange
    RBMBackedTimestampSet rbmBackedTimestampSet = new RBMBackedTimestampSet(TimeBucket.SECOND);

    ArrayList<Instant> instants = new ArrayList<>();
    instants.add(LocalDate.ofYearDay(1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> rbmBackedTimestampSet.add(instants));
  }

  /**
   * Test {@link RBMBackedTimestampSet#getTimestamps()}.
   * <p>
   * Method under test: {@link RBMBackedTimestampSet#getTimestamps()}
   */
  @Test
  @DisplayName("Test getTimestamps()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.util.SortedSet RBMBackedTimestampSet.getTimestamps()"})
  void testGetTimestamps() {
    // Arrange
    Builder timeBucketResult = (new Builder()).timeBucket(TimeBucket.SECOND);
    RBMBackedTimestampSet buildResult = timeBucketResult
        .timestamp(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant())
        .build();

    // Act and Assert
    assertEquals(1, buildResult.getTimestamps().size());
  }

  /**
   * Test {@link RBMBackedTimestampSet#getTimestamps()}.
   * <p>
   * Method under test: {@link RBMBackedTimestampSet#getTimestamps()}
   */
  @Test
  @DisplayName("Test getTimestamps()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.util.SortedSet RBMBackedTimestampSet.getTimestamps()"})
  void testGetTimestamps2() {
    // Arrange
    Builder timeBucketResult = (new Builder()).timeBucket(TimeBucket.MINUTE);
    RBMBackedTimestampSet buildResult = timeBucketResult
        .timestamp(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant())
        .build();

    // Act and Assert
    assertEquals(1, buildResult.getTimestamps().size());
  }

  /**
   * Test {@link RBMBackedTimestampSet#getTimestamps()}.
   * <p>
   * Method under test: {@link RBMBackedTimestampSet#getTimestamps()}
   */
  @Test
  @DisplayName("Test getTimestamps()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.util.SortedSet RBMBackedTimestampSet.getTimestamps()"})
  void testGetTimestamps3() {
    // Arrange
    Builder timeBucketResult = (new Builder()).timeBucket(TimeBucket.HOUR);
    RBMBackedTimestampSet buildResult = timeBucketResult
        .timestamp(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant())
        .build();

    // Act and Assert
    assertEquals(1, buildResult.getTimestamps().size());
  }

  /**
   * Test {@link RBMBackedTimestampSet#getTimestamps()}.
   * <p>
   * Method under test: {@link RBMBackedTimestampSet#getTimestamps()}
   */
  @Test
  @DisplayName("Test getTimestamps()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.util.SortedSet RBMBackedTimestampSet.getTimestamps()"})
  void testGetTimestamps4() {
    // Arrange
    Builder timeBucketResult = (new Builder()).timeBucket(TimeBucket.DAY);
    RBMBackedTimestampSet buildResult = timeBucketResult
        .timestamp(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant())
        .build();

    // Act and Assert
    assertEquals(1, buildResult.getTimestamps().size());
  }

  /**
   * Test {@link RBMBackedTimestampSet#getTimestamps()}.
   * <p>
   * Method under test: {@link RBMBackedTimestampSet#getTimestamps()}
   */
  @Test
  @DisplayName("Test getTimestamps()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.util.SortedSet RBMBackedTimestampSet.getTimestamps()"})
  void testGetTimestamps5() {
    // Arrange
    Builder timeBucketResult = (new Builder()).timeBucket(TimeBucket.WEEK);
    RBMBackedTimestampSet buildResult = timeBucketResult
        .timestamp(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant())
        .build();

    // Act and Assert
    assertEquals(1, buildResult.getTimestamps().size());
  }

  /**
   * Test {@link RBMBackedTimestampSet#getTimestamps()}.
   * <p>
   * Method under test: {@link RBMBackedTimestampSet#getTimestamps()}
   */
  @Test
  @DisplayName("Test getTimestamps()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.util.SortedSet RBMBackedTimestampSet.getTimestamps()"})
  void testGetTimestamps6() {
    // Arrange
    Builder timeBucketResult = (new Builder()).timeBucket(TimeBucket.MONTH);
    RBMBackedTimestampSet buildResult = timeBucketResult
        .timestamp(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant())
        .build();

    // Act and Assert
    assertEquals(1, buildResult.getTimestamps().size());
  }

  /**
   * Test {@link RBMBackedTimestampSet#getTimestamps()}.
   * <p>
   * Method under test: {@link RBMBackedTimestampSet#getTimestamps()}
   */
  @Test
  @DisplayName("Test getTimestamps()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.util.SortedSet RBMBackedTimestampSet.getTimestamps()"})
  void testGetTimestamps7() {
    // Arrange
    Builder timeBucketResult = (new Builder()).timeBucket(TimeBucket.YEAR);
    RBMBackedTimestampSet buildResult = timeBucketResult
        .timestamp(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant())
        .build();

    // Act and Assert
    assertEquals(1, buildResult.getTimestamps().size());
  }

  /**
   * Test {@link RBMBackedTimestampSet#getTimestamps()}.
   * <ul>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link RBMBackedTimestampSet#getTimestamps()}
   */
  @Test
  @DisplayName("Test getTimestamps(); then return Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.util.SortedSet RBMBackedTimestampSet.getTimestamps()"})
  void testGetTimestamps_thenReturnEmpty() {
    // Arrange, Act and Assert
    assertTrue((new RBMBackedTimestampSet(TimeBucket.SECOND)).getTimestamps().isEmpty());
  }

  /**
   * Test {@link RBMBackedTimestampSet#getNumberOfTimestamps()}.
   * <ul>
   *   <li>Then return one.</li>
   * </ul>
   * <p>
   * Method under test: {@link RBMBackedTimestampSet#getNumberOfTimestamps()}
   */
  @Test
  @DisplayName("Test getNumberOfTimestamps(); then return one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"long RBMBackedTimestampSet.getNumberOfTimestamps()"})
  void testGetNumberOfTimestamps_thenReturnOne() {
    // Arrange
    Builder timeBucketResult = (new Builder()).timeBucket(TimeBucket.SECOND);
    RBMBackedTimestampSet buildResult = timeBucketResult
        .timestamp(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant())
        .build();

    // Act and Assert
    assertEquals(1L, buildResult.getNumberOfTimestamps());
  }

  /**
   * Test {@link RBMBackedTimestampSet#getNumberOfTimestamps()}.
   * <ul>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link RBMBackedTimestampSet#getNumberOfTimestamps()}
   */
  @Test
  @DisplayName("Test getNumberOfTimestamps(); then return zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"long RBMBackedTimestampSet.getNumberOfTimestamps()"})
  void testGetNumberOfTimestamps_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0L, (new RBMBackedTimestampSet(TimeBucket.SECOND)).getNumberOfTimestamps());
  }

  /**
   * Test {@link RBMBackedTimestampSet#getEarliest()}.
   * <p>
   * Method under test: {@link RBMBackedTimestampSet#getEarliest()}
   */
  @Test
  @DisplayName("Test getEarliest()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Instant RBMBackedTimestampSet.getEarliest()"})
  void testGetEarliest() {
    // Arrange
    Builder timeBucketResult = (new Builder()).timeBucket(TimeBucket.SECOND);
    RBMBackedTimestampSet buildResult = timeBucketResult
        .timestamp(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant())
        .build();

    // Act
    Instant actualEarliest = buildResult.getEarliest();

    // Assert
    Instant instant = actualEarliest.EPOCH;
    assertSame(instant, actualEarliest);
    RBMBackedTimestampSet shallowClone = buildResult.getShallowClone();
    RBMBackedTimestampSet shallowClone2 = shallowClone.getShallowClone();
    RBMBackedTimestampSet shallowClone3 = shallowClone2.getShallowClone();
    RBMBackedTimestampSet shallowClone4 = shallowClone3.getShallowClone();
    RBMBackedTimestampSet shallowClone5 = shallowClone4.getShallowClone();
    RBMBackedTimestampSet shallowClone6 = shallowClone5.getShallowClone();
    RBMBackedTimestampSet shallowClone7 = shallowClone6.getShallowClone();
    assertSame(instant, shallowClone7.getShallowClone().getLatest());
    assertSame(instant, shallowClone7.getLatest());
    assertSame(instant, shallowClone6.getLatest());
    assertSame(instant, shallowClone5.getLatest());
    assertSame(instant, shallowClone4.getLatest());
    assertSame(instant, shallowClone3.getLatest());
    assertSame(instant, shallowClone2.getLatest());
    assertSame(instant, shallowClone.getLatest());
    assertSame(instant, buildResult.getLatest());
  }

  /**
   * Test {@link RBMBackedTimestampSet#getEarliest()}.
   * <p>
   * Method under test: {@link RBMBackedTimestampSet#getEarliest()}
   */
  @Test
  @DisplayName("Test getEarliest()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Instant RBMBackedTimestampSet.getEarliest()"})
  void testGetEarliest2() {
    // Arrange
    Builder timeBucketResult = (new Builder()).timeBucket(TimeBucket.MINUTE);
    RBMBackedTimestampSet buildResult = timeBucketResult
        .timestamp(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant())
        .build();

    // Act
    Instant actualEarliest = buildResult.getEarliest();

    // Assert
    Instant instant = actualEarliest.EPOCH;
    assertSame(instant, actualEarliest);
    RBMBackedTimestampSet shallowClone = buildResult.getShallowClone();
    RBMBackedTimestampSet shallowClone2 = shallowClone.getShallowClone();
    RBMBackedTimestampSet shallowClone3 = shallowClone2.getShallowClone();
    RBMBackedTimestampSet shallowClone4 = shallowClone3.getShallowClone();
    RBMBackedTimestampSet shallowClone5 = shallowClone4.getShallowClone();
    RBMBackedTimestampSet shallowClone6 = shallowClone5.getShallowClone();
    RBMBackedTimestampSet shallowClone7 = shallowClone6.getShallowClone();
    assertSame(instant, shallowClone7.getShallowClone().getLatest());
    assertSame(instant, shallowClone7.getLatest());
    assertSame(instant, shallowClone6.getLatest());
    assertSame(instant, shallowClone5.getLatest());
    assertSame(instant, shallowClone4.getLatest());
    assertSame(instant, shallowClone3.getLatest());
    assertSame(instant, shallowClone2.getLatest());
    assertSame(instant, shallowClone.getLatest());
    assertSame(instant, buildResult.getLatest());
  }

  /**
   * Test {@link RBMBackedTimestampSet#getEarliest()}.
   * <p>
   * Method under test: {@link RBMBackedTimestampSet#getEarliest()}
   */
  @Test
  @DisplayName("Test getEarliest()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Instant RBMBackedTimestampSet.getEarliest()"})
  void testGetEarliest3() {
    // Arrange
    Builder timeBucketResult = (new Builder()).timeBucket(TimeBucket.HOUR);
    RBMBackedTimestampSet buildResult = timeBucketResult
        .timestamp(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant())
        .build();

    // Act
    Instant actualEarliest = buildResult.getEarliest();

    // Assert
    Instant instant = actualEarliest.EPOCH;
    assertSame(instant, actualEarliest);
    RBMBackedTimestampSet shallowClone = buildResult.getShallowClone();
    RBMBackedTimestampSet shallowClone2 = shallowClone.getShallowClone();
    RBMBackedTimestampSet shallowClone3 = shallowClone2.getShallowClone();
    RBMBackedTimestampSet shallowClone4 = shallowClone3.getShallowClone();
    RBMBackedTimestampSet shallowClone5 = shallowClone4.getShallowClone();
    RBMBackedTimestampSet shallowClone6 = shallowClone5.getShallowClone();
    RBMBackedTimestampSet shallowClone7 = shallowClone6.getShallowClone();
    assertSame(instant, shallowClone7.getShallowClone().getLatest());
    assertSame(instant, shallowClone7.getLatest());
    assertSame(instant, shallowClone6.getLatest());
    assertSame(instant, shallowClone5.getLatest());
    assertSame(instant, shallowClone4.getLatest());
    assertSame(instant, shallowClone3.getLatest());
    assertSame(instant, shallowClone2.getLatest());
    assertSame(instant, shallowClone.getLatest());
    assertSame(instant, buildResult.getLatest());
  }

  /**
   * Test {@link RBMBackedTimestampSet#getEarliest()}.
   * <p>
   * Method under test: {@link RBMBackedTimestampSet#getEarliest()}
   */
  @Test
  @DisplayName("Test getEarliest()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Instant RBMBackedTimestampSet.getEarliest()"})
  void testGetEarliest4() {
    // Arrange
    Builder timeBucketResult = (new Builder()).timeBucket(TimeBucket.DAY);
    RBMBackedTimestampSet buildResult = timeBucketResult
        .timestamp(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant())
        .build();

    // Act
    Instant actualEarliest = buildResult.getEarliest();

    // Assert
    Instant instant = actualEarliest.EPOCH;
    assertSame(instant, actualEarliest);
    RBMBackedTimestampSet shallowClone = buildResult.getShallowClone();
    RBMBackedTimestampSet shallowClone2 = shallowClone.getShallowClone();
    RBMBackedTimestampSet shallowClone3 = shallowClone2.getShallowClone();
    RBMBackedTimestampSet shallowClone4 = shallowClone3.getShallowClone();
    RBMBackedTimestampSet shallowClone5 = shallowClone4.getShallowClone();
    RBMBackedTimestampSet shallowClone6 = shallowClone5.getShallowClone();
    RBMBackedTimestampSet shallowClone7 = shallowClone6.getShallowClone();
    assertSame(instant, shallowClone7.getShallowClone().getLatest());
    assertSame(instant, shallowClone7.getLatest());
    assertSame(instant, shallowClone6.getLatest());
    assertSame(instant, shallowClone5.getLatest());
    assertSame(instant, shallowClone4.getLatest());
    assertSame(instant, shallowClone3.getLatest());
    assertSame(instant, shallowClone2.getLatest());
    assertSame(instant, shallowClone.getLatest());
    assertSame(instant, buildResult.getLatest());
  }

  /**
   * Test {@link RBMBackedTimestampSet#getEarliest()}.
   * <p>
   * Method under test: {@link RBMBackedTimestampSet#getEarliest()}
   */
  @Test
  @DisplayName("Test getEarliest()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Instant RBMBackedTimestampSet.getEarliest()"})
  void testGetEarliest5() {
    // Arrange
    Builder timeBucketResult = (new Builder()).timeBucket(TimeBucket.MONTH);
    RBMBackedTimestampSet buildResult = timeBucketResult
        .timestamp(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant())
        .build();

    // Act
    Instant actualEarliest = buildResult.getEarliest();

    // Assert
    Instant instant = actualEarliest.EPOCH;
    assertSame(instant, actualEarliest);
    RBMBackedTimestampSet shallowClone = buildResult.getShallowClone();
    RBMBackedTimestampSet shallowClone2 = shallowClone.getShallowClone();
    RBMBackedTimestampSet shallowClone3 = shallowClone2.getShallowClone();
    RBMBackedTimestampSet shallowClone4 = shallowClone3.getShallowClone();
    RBMBackedTimestampSet shallowClone5 = shallowClone4.getShallowClone();
    RBMBackedTimestampSet shallowClone6 = shallowClone5.getShallowClone();
    RBMBackedTimestampSet shallowClone7 = shallowClone6.getShallowClone();
    assertSame(instant, shallowClone7.getShallowClone().getLatest());
    assertSame(instant, shallowClone7.getLatest());
    assertSame(instant, shallowClone6.getLatest());
    assertSame(instant, shallowClone5.getLatest());
    assertSame(instant, shallowClone4.getLatest());
    assertSame(instant, shallowClone3.getLatest());
    assertSame(instant, shallowClone2.getLatest());
    assertSame(instant, shallowClone.getLatest());
    assertSame(instant, buildResult.getLatest());
  }

  /**
   * Test {@link RBMBackedTimestampSet#getEarliest()}.
   * <p>
   * Method under test: {@link RBMBackedTimestampSet#getEarliest()}
   */
  @Test
  @DisplayName("Test getEarliest()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Instant RBMBackedTimestampSet.getEarliest()"})
  void testGetEarliest6() {
    // Arrange
    Builder timeBucketResult = (new Builder()).timeBucket(TimeBucket.YEAR);
    RBMBackedTimestampSet buildResult = timeBucketResult
        .timestamp(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant())
        .build();

    // Act
    Instant actualEarliest = buildResult.getEarliest();

    // Assert
    Instant instant = actualEarliest.EPOCH;
    assertSame(instant, actualEarliest);
    RBMBackedTimestampSet shallowClone = buildResult.getShallowClone();
    RBMBackedTimestampSet shallowClone2 = shallowClone.getShallowClone();
    RBMBackedTimestampSet shallowClone3 = shallowClone2.getShallowClone();
    RBMBackedTimestampSet shallowClone4 = shallowClone3.getShallowClone();
    RBMBackedTimestampSet shallowClone5 = shallowClone4.getShallowClone();
    RBMBackedTimestampSet shallowClone6 = shallowClone5.getShallowClone();
    RBMBackedTimestampSet shallowClone7 = shallowClone6.getShallowClone();
    assertSame(instant, shallowClone7.getShallowClone().getLatest());
    assertSame(instant, shallowClone7.getLatest());
    assertSame(instant, shallowClone6.getLatest());
    assertSame(instant, shallowClone5.getLatest());
    assertSame(instant, shallowClone4.getLatest());
    assertSame(instant, shallowClone3.getLatest());
    assertSame(instant, shallowClone2.getLatest());
    assertSame(instant, shallowClone.getLatest());
    assertSame(instant, buildResult.getLatest());
  }

  /**
   * Test {@link RBMBackedTimestampSet#getEarliest()}.
   * <ul>
   *   <li>Given {@link RBMBackedTimestampSet#RBMBackedTimestampSet(TimeBucket)} with timeBucket is {@code SECOND}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RBMBackedTimestampSet#getEarliest()}
   */
  @Test
  @DisplayName("Test getEarliest(); given RBMBackedTimestampSet(TimeBucket) with timeBucket is 'SECOND'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Instant RBMBackedTimestampSet.getEarliest()"})
  void testGetEarliest_givenRBMBackedTimestampSetWithTimeBucketIsSecond_thenReturnNull() {
    // Arrange
    RBMBackedTimestampSet rbmBackedTimestampSet = new RBMBackedTimestampSet(TimeBucket.SECOND);

    // Act and Assert
    assertNull(rbmBackedTimestampSet.getEarliest());
    assertNull(rbmBackedTimestampSet.getLatest());
    RBMBackedTimestampSet shallowClone = rbmBackedTimestampSet.getShallowClone();
    assertNull(shallowClone.getLatest());
    RBMBackedTimestampSet shallowClone2 = shallowClone.getShallowClone();
    assertNull(shallowClone2.getLatest());
    RBMBackedTimestampSet shallowClone3 = shallowClone2.getShallowClone();
    assertNull(shallowClone3.getLatest());
    RBMBackedTimestampSet shallowClone4 = shallowClone3.getShallowClone();
    assertNull(shallowClone4.getLatest());
    RBMBackedTimestampSet shallowClone5 = shallowClone4.getShallowClone();
    assertNull(shallowClone5.getLatest());
    RBMBackedTimestampSet shallowClone6 = shallowClone5.getShallowClone();
    assertNull(shallowClone6.getLatest());
    RBMBackedTimestampSet shallowClone7 = shallowClone6.getShallowClone();
    assertNull(shallowClone7.getLatest());
    assertNull(shallowClone7.getShallowClone().getLatest());
  }

  /**
   * Test {@link RBMBackedTimestampSet#getEarliest()}.
   * <ul>
   *   <li>Then return EpochSecond is {@code -259200}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RBMBackedTimestampSet#getEarliest()}
   */
  @Test
  @DisplayName("Test getEarliest(); then return EpochSecond is '-259200'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Instant RBMBackedTimestampSet.getEarliest()"})
  void testGetEarliest_thenReturnEpochSecondIs259200() {
    // Arrange
    Builder timeBucketResult = (new Builder()).timeBucket(TimeBucket.WEEK);
    RBMBackedTimestampSet buildResult = timeBucketResult
        .timestamp(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant())
        .build();

    // Act
    Instant actualEarliest = buildResult.getEarliest();

    // Assert
    assertEquals(-259200L, actualEarliest.getEpochSecond());
    assertEquals(0, actualEarliest.getNano());
  }

  /**
   * Test {@link RBMBackedTimestampSet#getLatest()}.
   * <p>
   * Method under test: {@link RBMBackedTimestampSet#getLatest()}
   */
  @Test
  @DisplayName("Test getLatest()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Instant RBMBackedTimestampSet.getLatest()"})
  void testGetLatest() {
    // Arrange
    Builder timeBucketResult = (new Builder()).timeBucket(TimeBucket.SECOND);
    RBMBackedTimestampSet buildResult = timeBucketResult
        .timestamp(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant())
        .build();

    // Act
    Instant actualLatest = buildResult.getLatest();

    // Assert
    Instant instant = actualLatest.EPOCH;
    RBMBackedTimestampSet shallowClone = buildResult.getShallowClone();
    RBMBackedTimestampSet shallowClone2 = shallowClone.getShallowClone();
    RBMBackedTimestampSet shallowClone3 = shallowClone2.getShallowClone();
    RBMBackedTimestampSet shallowClone4 = shallowClone3.getShallowClone();
    RBMBackedTimestampSet shallowClone5 = shallowClone4.getShallowClone();
    RBMBackedTimestampSet shallowClone6 = shallowClone5.getShallowClone();
    RBMBackedTimestampSet shallowClone7 = shallowClone6.getShallowClone();
    assertSame(instant, shallowClone7.getShallowClone().getEarliest());
    assertSame(instant, shallowClone7.getEarliest());
    assertSame(instant, shallowClone6.getEarliest());
    assertSame(instant, shallowClone5.getEarliest());
    assertSame(instant, shallowClone4.getEarliest());
    assertSame(instant, shallowClone3.getEarliest());
    assertSame(instant, shallowClone2.getEarliest());
    assertSame(instant, shallowClone.getEarliest());
    assertSame(instant, buildResult.getEarliest());
    assertSame(instant, actualLatest);
  }

  /**
   * Test {@link RBMBackedTimestampSet#getLatest()}.
   * <p>
   * Method under test: {@link RBMBackedTimestampSet#getLatest()}
   */
  @Test
  @DisplayName("Test getLatest()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Instant RBMBackedTimestampSet.getLatest()"})
  void testGetLatest2() {
    // Arrange
    Builder timeBucketResult = (new Builder()).timeBucket(TimeBucket.MINUTE);
    RBMBackedTimestampSet buildResult = timeBucketResult
        .timestamp(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant())
        .build();

    // Act
    Instant actualLatest = buildResult.getLatest();

    // Assert
    Instant instant = actualLatest.EPOCH;
    RBMBackedTimestampSet shallowClone = buildResult.getShallowClone();
    RBMBackedTimestampSet shallowClone2 = shallowClone.getShallowClone();
    RBMBackedTimestampSet shallowClone3 = shallowClone2.getShallowClone();
    RBMBackedTimestampSet shallowClone4 = shallowClone3.getShallowClone();
    RBMBackedTimestampSet shallowClone5 = shallowClone4.getShallowClone();
    RBMBackedTimestampSet shallowClone6 = shallowClone5.getShallowClone();
    RBMBackedTimestampSet shallowClone7 = shallowClone6.getShallowClone();
    assertSame(instant, shallowClone7.getShallowClone().getEarliest());
    assertSame(instant, shallowClone7.getEarliest());
    assertSame(instant, shallowClone6.getEarliest());
    assertSame(instant, shallowClone5.getEarliest());
    assertSame(instant, shallowClone4.getEarliest());
    assertSame(instant, shallowClone3.getEarliest());
    assertSame(instant, shallowClone2.getEarliest());
    assertSame(instant, shallowClone.getEarliest());
    assertSame(instant, buildResult.getEarliest());
    assertSame(instant, actualLatest);
  }

  /**
   * Test {@link RBMBackedTimestampSet#getLatest()}.
   * <p>
   * Method under test: {@link RBMBackedTimestampSet#getLatest()}
   */
  @Test
  @DisplayName("Test getLatest()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Instant RBMBackedTimestampSet.getLatest()"})
  void testGetLatest3() {
    // Arrange
    Builder timeBucketResult = (new Builder()).timeBucket(TimeBucket.HOUR);
    RBMBackedTimestampSet buildResult = timeBucketResult
        .timestamp(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant())
        .build();

    // Act
    Instant actualLatest = buildResult.getLatest();

    // Assert
    Instant instant = actualLatest.EPOCH;
    RBMBackedTimestampSet shallowClone = buildResult.getShallowClone();
    RBMBackedTimestampSet shallowClone2 = shallowClone.getShallowClone();
    RBMBackedTimestampSet shallowClone3 = shallowClone2.getShallowClone();
    RBMBackedTimestampSet shallowClone4 = shallowClone3.getShallowClone();
    RBMBackedTimestampSet shallowClone5 = shallowClone4.getShallowClone();
    RBMBackedTimestampSet shallowClone6 = shallowClone5.getShallowClone();
    RBMBackedTimestampSet shallowClone7 = shallowClone6.getShallowClone();
    assertSame(instant, shallowClone7.getShallowClone().getEarliest());
    assertSame(instant, shallowClone7.getEarliest());
    assertSame(instant, shallowClone6.getEarliest());
    assertSame(instant, shallowClone5.getEarliest());
    assertSame(instant, shallowClone4.getEarliest());
    assertSame(instant, shallowClone3.getEarliest());
    assertSame(instant, shallowClone2.getEarliest());
    assertSame(instant, shallowClone.getEarliest());
    assertSame(instant, buildResult.getEarliest());
    assertSame(instant, actualLatest);
  }

  /**
   * Test {@link RBMBackedTimestampSet#getLatest()}.
   * <p>
   * Method under test: {@link RBMBackedTimestampSet#getLatest()}
   */
  @Test
  @DisplayName("Test getLatest()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Instant RBMBackedTimestampSet.getLatest()"})
  void testGetLatest4() {
    // Arrange
    Builder timeBucketResult = (new Builder()).timeBucket(TimeBucket.DAY);
    RBMBackedTimestampSet buildResult = timeBucketResult
        .timestamp(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant())
        .build();

    // Act
    Instant actualLatest = buildResult.getLatest();

    // Assert
    Instant instant = actualLatest.EPOCH;
    RBMBackedTimestampSet shallowClone = buildResult.getShallowClone();
    RBMBackedTimestampSet shallowClone2 = shallowClone.getShallowClone();
    RBMBackedTimestampSet shallowClone3 = shallowClone2.getShallowClone();
    RBMBackedTimestampSet shallowClone4 = shallowClone3.getShallowClone();
    RBMBackedTimestampSet shallowClone5 = shallowClone4.getShallowClone();
    RBMBackedTimestampSet shallowClone6 = shallowClone5.getShallowClone();
    RBMBackedTimestampSet shallowClone7 = shallowClone6.getShallowClone();
    assertSame(instant, shallowClone7.getShallowClone().getEarliest());
    assertSame(instant, shallowClone7.getEarliest());
    assertSame(instant, shallowClone6.getEarliest());
    assertSame(instant, shallowClone5.getEarliest());
    assertSame(instant, shallowClone4.getEarliest());
    assertSame(instant, shallowClone3.getEarliest());
    assertSame(instant, shallowClone2.getEarliest());
    assertSame(instant, shallowClone.getEarliest());
    assertSame(instant, buildResult.getEarliest());
    assertSame(instant, actualLatest);
  }

  /**
   * Test {@link RBMBackedTimestampSet#getLatest()}.
   * <p>
   * Method under test: {@link RBMBackedTimestampSet#getLatest()}
   */
  @Test
  @DisplayName("Test getLatest()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Instant RBMBackedTimestampSet.getLatest()"})
  void testGetLatest5() {
    // Arrange
    Builder timeBucketResult = (new Builder()).timeBucket(TimeBucket.MONTH);
    RBMBackedTimestampSet buildResult = timeBucketResult
        .timestamp(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant())
        .build();

    // Act
    Instant actualLatest = buildResult.getLatest();

    // Assert
    Instant instant = actualLatest.EPOCH;
    RBMBackedTimestampSet shallowClone = buildResult.getShallowClone();
    RBMBackedTimestampSet shallowClone2 = shallowClone.getShallowClone();
    RBMBackedTimestampSet shallowClone3 = shallowClone2.getShallowClone();
    RBMBackedTimestampSet shallowClone4 = shallowClone3.getShallowClone();
    RBMBackedTimestampSet shallowClone5 = shallowClone4.getShallowClone();
    RBMBackedTimestampSet shallowClone6 = shallowClone5.getShallowClone();
    RBMBackedTimestampSet shallowClone7 = shallowClone6.getShallowClone();
    assertSame(instant, shallowClone7.getShallowClone().getEarliest());
    assertSame(instant, shallowClone7.getEarliest());
    assertSame(instant, shallowClone6.getEarliest());
    assertSame(instant, shallowClone5.getEarliest());
    assertSame(instant, shallowClone4.getEarliest());
    assertSame(instant, shallowClone3.getEarliest());
    assertSame(instant, shallowClone2.getEarliest());
    assertSame(instant, shallowClone.getEarliest());
    assertSame(instant, buildResult.getEarliest());
    assertSame(instant, actualLatest);
  }

  /**
   * Test {@link RBMBackedTimestampSet#getLatest()}.
   * <p>
   * Method under test: {@link RBMBackedTimestampSet#getLatest()}
   */
  @Test
  @DisplayName("Test getLatest()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Instant RBMBackedTimestampSet.getLatest()"})
  void testGetLatest6() {
    // Arrange
    Builder timeBucketResult = (new Builder()).timeBucket(TimeBucket.YEAR);
    RBMBackedTimestampSet buildResult = timeBucketResult
        .timestamp(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant())
        .build();

    // Act
    Instant actualLatest = buildResult.getLatest();

    // Assert
    Instant instant = actualLatest.EPOCH;
    RBMBackedTimestampSet shallowClone = buildResult.getShallowClone();
    RBMBackedTimestampSet shallowClone2 = shallowClone.getShallowClone();
    RBMBackedTimestampSet shallowClone3 = shallowClone2.getShallowClone();
    RBMBackedTimestampSet shallowClone4 = shallowClone3.getShallowClone();
    RBMBackedTimestampSet shallowClone5 = shallowClone4.getShallowClone();
    RBMBackedTimestampSet shallowClone6 = shallowClone5.getShallowClone();
    RBMBackedTimestampSet shallowClone7 = shallowClone6.getShallowClone();
    assertSame(instant, shallowClone7.getShallowClone().getEarliest());
    assertSame(instant, shallowClone7.getEarliest());
    assertSame(instant, shallowClone6.getEarliest());
    assertSame(instant, shallowClone5.getEarliest());
    assertSame(instant, shallowClone4.getEarliest());
    assertSame(instant, shallowClone3.getEarliest());
    assertSame(instant, shallowClone2.getEarliest());
    assertSame(instant, shallowClone.getEarliest());
    assertSame(instant, buildResult.getEarliest());
    assertSame(instant, actualLatest);
  }

  /**
   * Test {@link RBMBackedTimestampSet#getLatest()}.
   * <ul>
   *   <li>Then {@link RBMBackedTimestampSet#RBMBackedTimestampSet(TimeBucket)} with timeBucket is {@code SECOND} Earliest is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RBMBackedTimestampSet#getLatest()}
   */
  @Test
  @DisplayName("Test getLatest(); then RBMBackedTimestampSet(TimeBucket) with timeBucket is 'SECOND' Earliest is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Instant RBMBackedTimestampSet.getLatest()"})
  void testGetLatest_thenRBMBackedTimestampSetWithTimeBucketIsSecondEarliestIsNull() {
    // Arrange
    RBMBackedTimestampSet rbmBackedTimestampSet = new RBMBackedTimestampSet(TimeBucket.SECOND);

    // Act
    Instant actualLatest = rbmBackedTimestampSet.getLatest();

    // Assert
    assertNull(rbmBackedTimestampSet.getEarliest());
    RBMBackedTimestampSet shallowClone = rbmBackedTimestampSet.getShallowClone();
    assertNull(shallowClone.getEarliest());
    RBMBackedTimestampSet shallowClone2 = shallowClone.getShallowClone();
    assertNull(shallowClone2.getEarliest());
    RBMBackedTimestampSet shallowClone3 = shallowClone2.getShallowClone();
    assertNull(shallowClone3.getEarliest());
    RBMBackedTimestampSet shallowClone4 = shallowClone3.getShallowClone();
    assertNull(shallowClone4.getEarliest());
    RBMBackedTimestampSet shallowClone5 = shallowClone4.getShallowClone();
    assertNull(shallowClone5.getEarliest());
    RBMBackedTimestampSet shallowClone6 = shallowClone5.getShallowClone();
    assertNull(shallowClone6.getEarliest());
    RBMBackedTimestampSet shallowClone7 = shallowClone6.getShallowClone();
    assertNull(shallowClone7.getEarliest());
    assertNull(shallowClone7.getShallowClone().getEarliest());
    assertNull(actualLatest);
  }

  /**
   * Test {@link RBMBackedTimestampSet#getLatest()}.
   * <ul>
   *   <li>Then return EpochSecond is {@code -259200}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RBMBackedTimestampSet#getLatest()}
   */
  @Test
  @DisplayName("Test getLatest(); then return EpochSecond is '-259200'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Instant RBMBackedTimestampSet.getLatest()"})
  void testGetLatest_thenReturnEpochSecondIs259200() {
    // Arrange
    Builder timeBucketResult = (new Builder()).timeBucket(TimeBucket.WEEK);
    RBMBackedTimestampSet buildResult = timeBucketResult
        .timestamp(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant())
        .build();

    // Act
    Instant actualLatest = buildResult.getLatest();

    // Assert
    assertEquals(-259200L, actualLatest.getEpochSecond());
    assertEquals(0, actualLatest.getNano());
  }

  /**
   * Test {@link RBMBackedTimestampSet#applyTimeRangeMask(Long, Long)}.
   * <p>
   * Method under test: {@link RBMBackedTimestampSet#applyTimeRangeMask(Long, Long)}
   */
  @Test
  @DisplayName("Test applyTimeRangeMask(Long, Long)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void RBMBackedTimestampSet.applyTimeRangeMask(Long, Long)"})
  void testApplyTimeRangeMask() {
    // Arrange
    Builder timeBucketResult = (new Builder()).timeBucket(TimeBucket.SECOND);
    RBMBackedTimestampSet buildResult = timeBucketResult
        .timestamp(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant())
        .build();

    // Act
    buildResult.applyTimeRangeMask(1L, 1L);

    // Assert that nothing has changed
    assertEquals(buildResult, buildResult.getShallowClone());
  }

  /**
   * Test {@link RBMBackedTimestampSet#applyTimeRangeMask(Long, Long)}.
   * <p>
   * Method under test: {@link RBMBackedTimestampSet#applyTimeRangeMask(Long, Long)}
   */
  @Test
  @DisplayName("Test applyTimeRangeMask(Long, Long)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void RBMBackedTimestampSet.applyTimeRangeMask(Long, Long)"})
  void testApplyTimeRangeMask2() {
    // Arrange
    RBMBackedTimestampSet rbmBackedTimestampSet = new RBMBackedTimestampSet(TimeBucket.SECOND);
    Builder timeBucketResult = (new Builder()).timeBucket(TimeBucket.WEEK);
    RBMBackedTimestampSet other = timeBucketResult
        .timestamp(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant())
        .build();
    rbmBackedTimestampSet.addAll(other);

    // Act
    rbmBackedTimestampSet.applyTimeRangeMask(1L, 1L);

    // Assert
    assertEquals(rbmBackedTimestampSet, rbmBackedTimestampSet.getShallowClone());
  }

  /**
   * Test {@link RBMBackedTimestampSet#applyTimeRangeMask(Long, Long)}.
   * <p>
   * Method under test: {@link RBMBackedTimestampSet#applyTimeRangeMask(Long, Long)}
   */
  @Test
  @DisplayName("Test applyTimeRangeMask(Long, Long)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void RBMBackedTimestampSet.applyTimeRangeMask(Long, Long)"})
  void testApplyTimeRangeMask3() {
    // Arrange
    RBMBackedTimestampSet rbmBackedTimestampSet = new RBMBackedTimestampSet(TimeBucket.SECOND);
    Builder timeBucketResult = (new Builder()).timeBucket(TimeBucket.WEEK);
    RBMBackedTimestampSet other = timeBucketResult
        .timestamp(LocalDate.now().atStartOfDay().atZone(ZoneOffset.UTC).toInstant())
        .build();
    rbmBackedTimestampSet.addAll(other);

    // Act
    rbmBackedTimestampSet.applyTimeRangeMask(1L, 1L);

    // Assert
    assertEquals(rbmBackedTimestampSet, rbmBackedTimestampSet.getShallowClone());
  }

  /**
   * Test {@link RBMBackedTimestampSet#applyTimeRangeMask(Long, Long)}.
   * <p>
   * Method under test: {@link RBMBackedTimestampSet#applyTimeRangeMask(Long, Long)}
   */
  @Test
  @DisplayName("Test applyTimeRangeMask(Long, Long)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void RBMBackedTimestampSet.applyTimeRangeMask(Long, Long)"})
  void testApplyTimeRangeMask4() {
    // Arrange
    RBMBackedTimestampSet rbmBackedTimestampSet = new RBMBackedTimestampSet(TimeBucket.SECOND);
    Builder timeBucketResult = (new Builder()).timeBucket(TimeBucket.WEEK);
    RBMBackedTimestampSet other = timeBucketResult
        .timestamp(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant())
        .build();
    rbmBackedTimestampSet.addAll(other);

    // Act
    rbmBackedTimestampSet.applyTimeRangeMask(null, 1L);

    // Assert
    assertEquals(rbmBackedTimestampSet, rbmBackedTimestampSet.getShallowClone());
  }

  /**
   * Test {@link RBMBackedTimestampSet#applyTimeRangeMask(Long, Long)}.
   * <p>
   * Method under test: {@link RBMBackedTimestampSet#applyTimeRangeMask(Long, Long)}
   */
  @Test
  @DisplayName("Test applyTimeRangeMask(Long, Long)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void RBMBackedTimestampSet.applyTimeRangeMask(Long, Long)"})
  void testApplyTimeRangeMask5() {
    // Arrange
    RBMBackedTimestampSet rbmBackedTimestampSet = new RBMBackedTimestampSet(TimeBucket.SECOND);
    Builder timeBucketResult = (new Builder()).timeBucket(TimeBucket.WEEK);
    RBMBackedTimestampSet other = timeBucketResult
        .timestamp(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant())
        .build();
    rbmBackedTimestampSet.addAll(other);

    // Act
    rbmBackedTimestampSet.applyTimeRangeMask(1L, null);

    // Assert
    assertEquals(rbmBackedTimestampSet, rbmBackedTimestampSet.getShallowClone());
  }

  /**
   * Test {@link RBMBackedTimestampSet#applyTimeRangeMask(Long, Long)}.
   * <p>
   * Method under test: {@link RBMBackedTimestampSet#applyTimeRangeMask(Long, Long)}
   */
  @Test
  @DisplayName("Test applyTimeRangeMask(Long, Long)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void RBMBackedTimestampSet.applyTimeRangeMask(Long, Long)"})
  void testApplyTimeRangeMask6() {
    // Arrange
    RBMBackedTimestampSet rbmBackedTimestampSet = new RBMBackedTimestampSet(TimeBucket.MINUTE);
    Builder timeBucketResult = (new Builder()).timeBucket(TimeBucket.WEEK);
    RBMBackedTimestampSet other = timeBucketResult
        .timestamp(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant())
        .build();
    rbmBackedTimestampSet.addAll(other);

    // Act
    rbmBackedTimestampSet.applyTimeRangeMask(1L, Long.MAX_VALUE);

    // Assert
    assertEquals(rbmBackedTimestampSet, rbmBackedTimestampSet.getShallowClone());
  }

  /**
   * Test {@link RBMBackedTimestampSet#applyTimeRangeMask(Long, Long)}.
   * <p>
   * Method under test: {@link RBMBackedTimestampSet#applyTimeRangeMask(Long, Long)}
   */
  @Test
  @DisplayName("Test applyTimeRangeMask(Long, Long)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void RBMBackedTimestampSet.applyTimeRangeMask(Long, Long)"})
  void testApplyTimeRangeMask7() {
    // Arrange
    RBMBackedTimestampSet rbmBackedTimestampSet = new RBMBackedTimestampSet(TimeBucket.MINUTE);
    Builder timeBucketResult = (new Builder()).timeBucket(TimeBucket.WEEK);
    RBMBackedTimestampSet other = timeBucketResult
        .timestamp(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant())
        .build();
    rbmBackedTimestampSet.addAll(other);

    // Act
    rbmBackedTimestampSet.applyTimeRangeMask(null, 1L);

    // Assert
    assertEquals(rbmBackedTimestampSet, rbmBackedTimestampSet.getShallowClone());
  }

  /**
   * Test {@link RBMBackedTimestampSet#applyTimeRangeMask(Long, Long)}.
   * <p>
   * Method under test: {@link RBMBackedTimestampSet#applyTimeRangeMask(Long, Long)}
   */
  @Test
  @DisplayName("Test applyTimeRangeMask(Long, Long)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void RBMBackedTimestampSet.applyTimeRangeMask(Long, Long)"})
  void testApplyTimeRangeMask8() {
    // Arrange
    RBMBackedTimestampSet rbmBackedTimestampSet = new RBMBackedTimestampSet(TimeBucket.HOUR);
    Builder timeBucketResult = (new Builder()).timeBucket(TimeBucket.WEEK);
    RBMBackedTimestampSet other = timeBucketResult
        .timestamp(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant())
        .build();
    rbmBackedTimestampSet.addAll(other);

    // Act
    rbmBackedTimestampSet.applyTimeRangeMask(null, 1L);

    // Assert
    assertEquals(rbmBackedTimestampSet, rbmBackedTimestampSet.getShallowClone());
  }

  /**
   * Test {@link RBMBackedTimestampSet#applyTimeRangeMask(Long, Long)}.
   * <p>
   * Method under test: {@link RBMBackedTimestampSet#applyTimeRangeMask(Long, Long)}
   */
  @Test
  @DisplayName("Test applyTimeRangeMask(Long, Long)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void RBMBackedTimestampSet.applyTimeRangeMask(Long, Long)"})
  void testApplyTimeRangeMask9() {
    // Arrange
    RBMBackedTimestampSet rbmBackedTimestampSet = new RBMBackedTimestampSet(TimeBucket.DAY);
    Builder timeBucketResult = (new Builder()).timeBucket(TimeBucket.WEEK);
    RBMBackedTimestampSet other = timeBucketResult
        .timestamp(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant())
        .build();
    rbmBackedTimestampSet.addAll(other);

    // Act
    rbmBackedTimestampSet.applyTimeRangeMask(null, 1L);

    // Assert
    assertEquals(rbmBackedTimestampSet, rbmBackedTimestampSet.getShallowClone());
  }

  /**
   * Test {@link RBMBackedTimestampSet#applyTimeRangeMask(Long, Long)}.
   * <ul>
   *   <li>Given {@link RBMBackedTimestampSet#RBMBackedTimestampSet(TimeBucket)} with timeBucket is {@code WEEK}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RBMBackedTimestampSet#applyTimeRangeMask(Long, Long)}
   */
  @Test
  @DisplayName("Test applyTimeRangeMask(Long, Long); given RBMBackedTimestampSet(TimeBucket) with timeBucket is 'WEEK'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void RBMBackedTimestampSet.applyTimeRangeMask(Long, Long)"})
  void testApplyTimeRangeMask_givenRBMBackedTimestampSetWithTimeBucketIsWeek() {
    // Arrange, Act and Assert
    assertThrows(RuntimeException.class, () -> (new RBMBackedTimestampSet(TimeBucket.WEEK)).applyTimeRangeMask(1L, 1L));
  }

  /**
   * Test {@link RBMBackedTimestampSet#applyTimeRangeMask(Long, Long)}.
   * <ul>
   *   <li>When {@link Long#MAX_VALUE}.</li>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RBMBackedTimestampSet#applyTimeRangeMask(Long, Long)}
   */
  @Test
  @DisplayName("Test applyTimeRangeMask(Long, Long); when MAX_VALUE; then throw RuntimeException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void RBMBackedTimestampSet.applyTimeRangeMask(Long, Long)"})
  void testApplyTimeRangeMask_whenMax_value_thenThrowRuntimeException() {
    // Arrange, Act and Assert
    assertThrows(RuntimeException.class,
        () -> (new RBMBackedTimestampSet(TimeBucket.SECOND)).applyTimeRangeMask(1L, Long.MAX_VALUE));
  }

  /**
   * Test {@link RBMBackedTimestampSet#applyTimeRangeMask(Long, Long)}.
   * <ul>
   *   <li>When {@link CommonTimeUtil#MILLISECONDS_IN_DAY}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RBMBackedTimestampSet#applyTimeRangeMask(Long, Long)}
   */
  @Test
  @DisplayName("Test applyTimeRangeMask(Long, Long); when MILLISECONDS_IN_DAY")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void RBMBackedTimestampSet.applyTimeRangeMask(Long, Long)"})
  void testApplyTimeRangeMask_whenMilliseconds_in_day() {
    // Arrange
    RBMBackedTimestampSet rbmBackedTimestampSet = new RBMBackedTimestampSet(TimeBucket.SECOND);
    Builder timeBucketResult = (new Builder()).timeBucket(TimeBucket.WEEK);
    RBMBackedTimestampSet other = timeBucketResult
        .timestamp(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant())
        .build();
    rbmBackedTimestampSet.addAll(other);

    // Act
    rbmBackedTimestampSet.applyTimeRangeMask(1L, CommonTimeUtil.MILLISECONDS_IN_DAY);

    // Assert
    assertEquals(rbmBackedTimestampSet, rbmBackedTimestampSet.getShallowClone());
  }

  /**
   * Test {@link RBMBackedTimestampSet#applyTimeRangeMask(Long, Long)}.
   * <ul>
   *   <li>When two.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RBMBackedTimestampSet#applyTimeRangeMask(Long, Long)}
   */
  @Test
  @DisplayName("Test applyTimeRangeMask(Long, Long); when two; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void RBMBackedTimestampSet.applyTimeRangeMask(Long, Long)"})
  void testApplyTimeRangeMask_whenTwo_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> (new RBMBackedTimestampSet(TimeBucket.SECOND)).applyTimeRangeMask(2L, 1L));
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link RBMBackedTimestampSet#setRbm(RoaringBitmap)}
   *   <li>{@link RBMBackedTimestampSet#toString()}
   *   <li>{@link RBMBackedTimestampSet#getRbm()}
   *   <li>{@link RBMBackedTimestampSet#getTimeBucket()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RoaringBitmap RBMBackedTimestampSet.getRbm()", "TimeBucket RBMBackedTimestampSet.getTimeBucket()",
      "void RBMBackedTimestampSet.setRbm(RoaringBitmap)", "String RBMBackedTimestampSet.toString()"})
  void testGettersAndSetters() {
    // Arrange
    Builder timeBucketResult = (new Builder()).timeBucket(TimeBucket.SECOND);
    RBMBackedTimestampSet buildResult = timeBucketResult
        .timestamp(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant())
        .build();
    RoaringBitmap rbm = new RoaringBitmap();

    // Act
    buildResult.setRbm(rbm);
    String actualToStringResult = buildResult.toString();
    RoaringBitmap actualRbm = buildResult.getRbm();

    // Assert
    assertEquals("RBMBackedTimestampSet[timeBucket=SECOND,timestamps=]", actualToStringResult);
    assertEquals(TimeBucket.SECOND, buildResult.getTimeBucket());
    assertSame(rbm, actualRbm);
  }

  /**
   * Test {@link RBMBackedTimestampSet#addAll(RBMBackedTimestampSet)}.
   * <p>
   * Method under test: {@link RBMBackedTimestampSet#addAll(RBMBackedTimestampSet)}
   */
  @Test
  @DisplayName("Test addAll(RBMBackedTimestampSet)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void RBMBackedTimestampSet.addAll(RBMBackedTimestampSet)"})
  void testAddAll() {
    // Arrange
    RBMBackedTimestampSet rbmBackedTimestampSet = new RBMBackedTimestampSet(TimeBucket.SECOND);
    Builder timeBucketResult = (new Builder()).timeBucket(TimeBucket.SECOND);
    RBMBackedTimestampSet other = timeBucketResult
        .timestamp(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant())
        .build();

    // Act
    rbmBackedTimestampSet.addAll(other);

    // Assert
    assertEquals(1L, rbmBackedTimestampSet.getNumberOfTimestamps());
    assertEquals(1L, rbmBackedTimestampSet.getShallowClone().getNumberOfTimestamps());
    assertEquals(rbmBackedTimestampSet, other);
  }

  /**
   * Test {@link RBMBackedTimestampSet#getShallowClone()}.
   * <p>
   * Method under test: {@link RBMBackedTimestampSet#getShallowClone()}
   */
  @Test
  @DisplayName("Test getShallowClone()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RBMBackedTimestampSet RBMBackedTimestampSet.getShallowClone()"})
  void testGetShallowClone() {
    // Arrange
    Builder timeBucketResult = (new Builder()).timeBucket(TimeBucket.SECOND);
    RBMBackedTimestampSet buildResult = timeBucketResult
        .timestamp(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant())
        .build();

    // Act and Assert
    assertEquals(buildResult, buildResult.getShallowClone());
  }

  /**
   * Test {@link RBMBackedTimestampSet#getShallowClone()}.
   * <p>
   * Method under test: {@link RBMBackedTimestampSet#getShallowClone()}
   */
  @Test
  @DisplayName("Test getShallowClone()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RBMBackedTimestampSet RBMBackedTimestampSet.getShallowClone()"})
  void testGetShallowClone2() {
    // Arrange
    RBMBackedTimestampSet rbmBackedTimestampSet = new RBMBackedTimestampSet(TimeBucket.SECOND);
    Builder timeBucketResult = (new Builder()).timeBucket(TimeBucket.WEEK);
    RBMBackedTimestampSet other = timeBucketResult
        .timestamp(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant())
        .build();
    rbmBackedTimestampSet.addAll(other);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> rbmBackedTimestampSet.getShallowClone());
  }

  /**
   * Test {@link RBMBackedTimestampSet#getShallowClone()}.
   * <p>
   * Method under test: {@link RBMBackedTimestampSet#getShallowClone()}
   */
  @Test
  @DisplayName("Test getShallowClone()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RBMBackedTimestampSet RBMBackedTimestampSet.getShallowClone()"})
  void testGetShallowClone3() {
    // Arrange
    RBMBackedTimestampSet rbmBackedTimestampSet = new RBMBackedTimestampSet(TimeBucket.MINUTE);
    Builder timeBucketResult = (new Builder()).timeBucket(TimeBucket.WEEK);
    RBMBackedTimestampSet other = timeBucketResult
        .timestamp(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant())
        .build();
    rbmBackedTimestampSet.addAll(other);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> rbmBackedTimestampSet.getShallowClone());
  }

  /**
   * Test {@link RBMBackedTimestampSet#getShallowClone()}.
   * <p>
   * Method under test: {@link RBMBackedTimestampSet#getShallowClone()}
   */
  @Test
  @DisplayName("Test getShallowClone()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RBMBackedTimestampSet RBMBackedTimestampSet.getShallowClone()"})
  void testGetShallowClone4() {
    // Arrange
    RBMBackedTimestampSet rbmBackedTimestampSet = new RBMBackedTimestampSet(TimeBucket.HOUR);
    Builder timeBucketResult = (new Builder()).timeBucket(TimeBucket.WEEK);
    RBMBackedTimestampSet other = timeBucketResult
        .timestamp(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant())
        .build();
    rbmBackedTimestampSet.addAll(other);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> rbmBackedTimestampSet.getShallowClone());
  }

  /**
   * Test {@link RBMBackedTimestampSet#getShallowClone()}.
   * <p>
   * Method under test: {@link RBMBackedTimestampSet#getShallowClone()}
   */
  @Test
  @DisplayName("Test getShallowClone()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RBMBackedTimestampSet RBMBackedTimestampSet.getShallowClone()"})
  void testGetShallowClone5() {
    // Arrange
    RBMBackedTimestampSet rbmBackedTimestampSet = new RBMBackedTimestampSet(TimeBucket.DAY);
    Builder timeBucketResult = (new Builder()).timeBucket(TimeBucket.WEEK);
    RBMBackedTimestampSet other = timeBucketResult
        .timestamp(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant())
        .build();
    rbmBackedTimestampSet.addAll(other);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> rbmBackedTimestampSet.getShallowClone());
  }

  /**
   * Test {@link RBMBackedTimestampSet#getShallowClone()}.
   * <p>
   * Method under test: {@link RBMBackedTimestampSet#getShallowClone()}
   */
  @Test
  @DisplayName("Test getShallowClone()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RBMBackedTimestampSet RBMBackedTimestampSet.getShallowClone()"})
  void testGetShallowClone6() {
    // Arrange
    RBMBackedTimestampSet rbmBackedTimestampSet = new RBMBackedTimestampSet(TimeBucket.WEEK);
    Builder timeBucketResult = (new Builder()).timeBucket(TimeBucket.WEEK);
    RBMBackedTimestampSet other = timeBucketResult
        .timestamp(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant())
        .build();
    rbmBackedTimestampSet.addAll(other);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> rbmBackedTimestampSet.getShallowClone());
  }

  /**
   * Test {@link RBMBackedTimestampSet#getShallowClone()}.
   * <p>
   * Method under test: {@link RBMBackedTimestampSet#getShallowClone()}
   */
  @Test
  @DisplayName("Test getShallowClone()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RBMBackedTimestampSet RBMBackedTimestampSet.getShallowClone()"})
  void testGetShallowClone7() {
    // Arrange
    RBMBackedTimestampSet rbmBackedTimestampSet = new RBMBackedTimestampSet(TimeBucket.MINUTE);
    Builder timeBucketResult = (new Builder()).timeBucket(TimeBucket.SECOND);
    RBMBackedTimestampSet other = timeBucketResult
        .timestamp(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant())
        .build();
    rbmBackedTimestampSet.addAll(other);

    // Act and Assert
    assertEquals(rbmBackedTimestampSet, rbmBackedTimestampSet.getShallowClone());
  }

  /**
   * Test {@link RBMBackedTimestampSet#getShallowClone()}.
   * <p>
   * Method under test: {@link RBMBackedTimestampSet#getShallowClone()}
   */
  @Test
  @DisplayName("Test getShallowClone()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RBMBackedTimestampSet RBMBackedTimestampSet.getShallowClone()"})
  void testGetShallowClone8() {
    // Arrange
    Builder timeBucketResult = (new Builder()).timeBucket(TimeBucket.SECOND);
    RBMBackedTimestampSet buildResult = timeBucketResult
        .timestamp(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant())
        .build();
    Builder timeBucketResult2 = (new Builder()).timeBucket(TimeBucket.SECOND);
    RBMBackedTimestampSet other = timeBucketResult2
        .timestamp(LocalDate.now().atStartOfDay().atZone(ZoneOffset.UTC).toInstant())
        .build();
    buildResult.addAll(other);

    // Act and Assert
    assertEquals(buildResult, buildResult.getShallowClone());
  }

  /**
   * Test {@link RBMBackedTimestampSet#getShallowClone()}.
   * <p>
   * Method under test: {@link RBMBackedTimestampSet#getShallowClone()}
   */
  @Test
  @DisplayName("Test getShallowClone()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RBMBackedTimestampSet RBMBackedTimestampSet.getShallowClone()"})
  void testGetShallowClone9() {
    // Arrange
    Builder timeBucketResult = (new Builder()).timeBucket(TimeBucket.SECOND);
    RBMBackedTimestampSet buildResult = timeBucketResult
        .timestamp(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant())
        .build();
    Builder timeBucketResult2 = (new Builder()).timeBucket(TimeBucket.DAY);
    RBMBackedTimestampSet other = timeBucketResult2
        .timestamp(LocalDate.now().atStartOfDay().atZone(ZoneOffset.UTC).toInstant())
        .build();
    buildResult.addAll(other);

    // Act and Assert
    assertEquals(buildResult, buildResult.getShallowClone());
  }

  /**
   * Test {@link RBMBackedTimestampSet#getShallowClone()}.
   * <p>
   * Method under test: {@link RBMBackedTimestampSet#getShallowClone()}
   */
  @Test
  @DisplayName("Test getShallowClone()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RBMBackedTimestampSet RBMBackedTimestampSet.getShallowClone()"})
  void testGetShallowClone10() {
    // Arrange
    RBMBackedTimestampSet rbmBackedTimestampSet = new RBMBackedTimestampSet(TimeBucket.MONTH);
    Builder timeBucketResult = (new Builder()).timeBucket(TimeBucket.WEEK);
    RBMBackedTimestampSet other = timeBucketResult
        .timestamp(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant())
        .build();
    rbmBackedTimestampSet.addAll(other);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> rbmBackedTimestampSet.getShallowClone());
  }

  /**
   * Test {@link RBMBackedTimestampSet#getShallowClone()}.
   * <p>
   * Method under test: {@link RBMBackedTimestampSet#getShallowClone()}
   */
  @Test
  @DisplayName("Test getShallowClone()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RBMBackedTimestampSet RBMBackedTimestampSet.getShallowClone()"})
  void testGetShallowClone11() {
    // Arrange
    RBMBackedTimestampSet rbmBackedTimestampSet = new RBMBackedTimestampSet(TimeBucket.YEAR);
    Builder timeBucketResult = (new Builder()).timeBucket(TimeBucket.WEEK);
    RBMBackedTimestampSet other = timeBucketResult
        .timestamp(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant())
        .build();
    rbmBackedTimestampSet.addAll(other);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> rbmBackedTimestampSet.getShallowClone());
  }

  /**
   * Test {@link RBMBackedTimestampSet#getShallowClone()}.
   * <ul>
   *   <li>Then return Earliest EpochSecond is {@code -259200}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RBMBackedTimestampSet#getShallowClone()}
   */
  @Test
  @DisplayName("Test getShallowClone(); then return Earliest EpochSecond is '-259200'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RBMBackedTimestampSet RBMBackedTimestampSet.getShallowClone()"})
  void testGetShallowClone_thenReturnEarliestEpochSecondIs259200() {
    // Arrange
    RBMBackedTimestampSet rbmBackedTimestampSet = new RBMBackedTimestampSet(TimeBucket.WEEK);
    Builder timeBucketResult = (new Builder()).timeBucket(TimeBucket.SECOND);
    RBMBackedTimestampSet other = timeBucketResult
        .timestamp(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant())
        .build();
    rbmBackedTimestampSet.addAll(other);

    // Act
    RBMBackedTimestampSet actualShallowClone = rbmBackedTimestampSet.getShallowClone();

    // Assert
    Instant earliest = actualShallowClone.getEarliest();
    assertEquals(-259200L, earliest.getEpochSecond());
    Iterator<Integer> iteratorResult = actualShallowClone.getRbm().iterator();
    assertEquals(-3, iteratorResult.next().intValue());
    assertEquals(TimeBucket.WEEK, actualShallowClone.getTimeBucket());
    assertFalse(iteratorResult.hasNext());
    assertEquals(earliest, actualShallowClone.getLatest());
  }

  /**
   * Test {@link RBMBackedTimestampSet#getShallowClone()}.
   * <ul>
   *   <li>Then return {@link RBMBackedTimestampSet#RBMBackedTimestampSet(TimeBucket)} with timeBucket is {@code DAY}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RBMBackedTimestampSet#getShallowClone()}
   */
  @Test
  @DisplayName("Test getShallowClone(); then return RBMBackedTimestampSet(TimeBucket) with timeBucket is 'DAY'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RBMBackedTimestampSet RBMBackedTimestampSet.getShallowClone()"})
  void testGetShallowClone_thenReturnRBMBackedTimestampSetWithTimeBucketIsDay() {
    // Arrange
    RBMBackedTimestampSet rbmBackedTimestampSet = new RBMBackedTimestampSet(TimeBucket.DAY);
    Builder timeBucketResult = (new Builder()).timeBucket(TimeBucket.SECOND);
    RBMBackedTimestampSet other = timeBucketResult
        .timestamp(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant())
        .build();
    rbmBackedTimestampSet.addAll(other);

    // Act and Assert
    assertEquals(rbmBackedTimestampSet, rbmBackedTimestampSet.getShallowClone());
  }

  /**
   * Test {@link RBMBackedTimestampSet#getShallowClone()}.
   * <ul>
   *   <li>Then return {@link RBMBackedTimestampSet#RBMBackedTimestampSet(TimeBucket)} with timeBucket is {@code HOUR}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RBMBackedTimestampSet#getShallowClone()}
   */
  @Test
  @DisplayName("Test getShallowClone(); then return RBMBackedTimestampSet(TimeBucket) with timeBucket is 'HOUR'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RBMBackedTimestampSet RBMBackedTimestampSet.getShallowClone()"})
  void testGetShallowClone_thenReturnRBMBackedTimestampSetWithTimeBucketIsHour() {
    // Arrange
    RBMBackedTimestampSet rbmBackedTimestampSet = new RBMBackedTimestampSet(TimeBucket.HOUR);
    Builder timeBucketResult = (new Builder()).timeBucket(TimeBucket.SECOND);
    RBMBackedTimestampSet other = timeBucketResult
        .timestamp(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant())
        .build();
    rbmBackedTimestampSet.addAll(other);

    // Act and Assert
    assertEquals(rbmBackedTimestampSet, rbmBackedTimestampSet.getShallowClone());
  }

  /**
   * Test {@link RBMBackedTimestampSet#getShallowClone()}.
   * <ul>
   *   <li>Then return {@link RBMBackedTimestampSet#RBMBackedTimestampSet(TimeBucket)} with timeBucket is {@code MONTH}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RBMBackedTimestampSet#getShallowClone()}
   */
  @Test
  @DisplayName("Test getShallowClone(); then return RBMBackedTimestampSet(TimeBucket) with timeBucket is 'MONTH'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RBMBackedTimestampSet RBMBackedTimestampSet.getShallowClone()"})
  void testGetShallowClone_thenReturnRBMBackedTimestampSetWithTimeBucketIsMonth() {
    // Arrange
    RBMBackedTimestampSet rbmBackedTimestampSet = new RBMBackedTimestampSet(TimeBucket.MONTH);
    Builder timeBucketResult = (new Builder()).timeBucket(TimeBucket.SECOND);
    RBMBackedTimestampSet other = timeBucketResult
        .timestamp(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant())
        .build();
    rbmBackedTimestampSet.addAll(other);

    // Act and Assert
    assertEquals(rbmBackedTimestampSet, rbmBackedTimestampSet.getShallowClone());
  }

  /**
   * Test {@link RBMBackedTimestampSet#getShallowClone()}.
   * <ul>
   *   <li>Then return {@link RBMBackedTimestampSet#RBMBackedTimestampSet(TimeBucket)} with timeBucket is {@code SECOND}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RBMBackedTimestampSet#getShallowClone()}
   */
  @Test
  @DisplayName("Test getShallowClone(); then return RBMBackedTimestampSet(TimeBucket) with timeBucket is 'SECOND'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RBMBackedTimestampSet RBMBackedTimestampSet.getShallowClone()"})
  void testGetShallowClone_thenReturnRBMBackedTimestampSetWithTimeBucketIsSecond() {
    // Arrange
    RBMBackedTimestampSet rbmBackedTimestampSet = new RBMBackedTimestampSet(TimeBucket.SECOND);

    // Act and Assert
    assertEquals(rbmBackedTimestampSet, rbmBackedTimestampSet.getShallowClone());
  }

  /**
   * Test {@link RBMBackedTimestampSet#getShallowClone()}.
   * <ul>
   *   <li>Then return {@link RBMBackedTimestampSet#RBMBackedTimestampSet(TimeBucket)} with timeBucket is {@code YEAR}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RBMBackedTimestampSet#getShallowClone()}
   */
  @Test
  @DisplayName("Test getShallowClone(); then return RBMBackedTimestampSet(TimeBucket) with timeBucket is 'YEAR'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RBMBackedTimestampSet RBMBackedTimestampSet.getShallowClone()"})
  void testGetShallowClone_thenReturnRBMBackedTimestampSetWithTimeBucketIsYear() {
    // Arrange
    RBMBackedTimestampSet rbmBackedTimestampSet = new RBMBackedTimestampSet(TimeBucket.YEAR);
    Builder timeBucketResult = (new Builder()).timeBucket(TimeBucket.SECOND);
    RBMBackedTimestampSet other = timeBucketResult
        .timestamp(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant())
        .build();
    rbmBackedTimestampSet.addAll(other);

    // Act and Assert
    assertEquals(rbmBackedTimestampSet, rbmBackedTimestampSet.getShallowClone());
  }

  /**
   * Test {@link RBMBackedTimestampSet#equals(Object)}, and {@link RBMBackedTimestampSet#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link RBMBackedTimestampSet#equals(Object)}
   *   <li>{@link RBMBackedTimestampSet#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean RBMBackedTimestampSet.equals(Object)", "int RBMBackedTimestampSet.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Builder timeBucketResult = (new Builder()).timeBucket(TimeBucket.SECOND);
    RBMBackedTimestampSet buildResult = timeBucketResult
        .timestamp(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant())
        .build();
    Builder timeBucketResult2 = (new Builder()).timeBucket(TimeBucket.SECOND);
    RBMBackedTimestampSet buildResult2 = timeBucketResult2
        .timestamp(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant())
        .build();

    // Act and Assert
    assertEquals(buildResult, buildResult2);
    int expectedHashCodeResult = buildResult.hashCode();
    assertEquals(expectedHashCodeResult, buildResult2.hashCode());
  }

  /**
   * Test {@link RBMBackedTimestampSet#equals(Object)}, and {@link RBMBackedTimestampSet#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link RBMBackedTimestampSet#equals(Object)}
   *   <li>{@link RBMBackedTimestampSet#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean RBMBackedTimestampSet.equals(Object)", "int RBMBackedTimestampSet.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Builder timeBucketResult = (new Builder()).timeBucket(TimeBucket.SECOND);
    RBMBackedTimestampSet buildResult = timeBucketResult
        .timestamp(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant())
        .build();

    // Act and Assert
    assertEquals(buildResult, buildResult);
    int expectedHashCodeResult = buildResult.hashCode();
    assertEquals(expectedHashCodeResult, buildResult.hashCode());
  }

  /**
   * Test {@link RBMBackedTimestampSet#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RBMBackedTimestampSet#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean RBMBackedTimestampSet.equals(Object)", "int RBMBackedTimestampSet.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Builder timeBucketResult = (new Builder()).timeBucket(TimeBucket.MINUTE);
    RBMBackedTimestampSet buildResult = timeBucketResult
        .timestamp(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant())
        .build();
    Builder timeBucketResult2 = (new Builder()).timeBucket(TimeBucket.SECOND);
    RBMBackedTimestampSet buildResult2 = timeBucketResult2
        .timestamp(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant())
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link RBMBackedTimestampSet#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RBMBackedTimestampSet#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean RBMBackedTimestampSet.equals(Object)", "int RBMBackedTimestampSet.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    Builder timeBucketResult = (new Builder()).timeBucket(TimeBucket.SECOND);
    RBMBackedTimestampSet buildResult = timeBucketResult
        .timestamp(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant())
        .build();

    // Act and Assert
    assertNotEquals(buildResult, null);
  }

  /**
   * Test {@link RBMBackedTimestampSet#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RBMBackedTimestampSet#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean RBMBackedTimestampSet.equals(Object)", "int RBMBackedTimestampSet.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    Builder timeBucketResult = (new Builder()).timeBucket(TimeBucket.SECOND);
    RBMBackedTimestampSet buildResult = timeBucketResult
        .timestamp(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant())
        .build();

    // Act and Assert
    assertNotEquals(buildResult, "Different type to RBMBackedTimestampSet");
  }

  /**
   * Test {@link RBMBackedTimestampSet#fromInt(TimeBucket, int)} with {@code timeBucket}, {@code i}.
   * <ul>
   *   <li>When {@code DAY}.</li>
   *   <li>Then return {@link CommonTimeUtil#MILLISECONDS_IN_DAY}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RBMBackedTimestampSet#fromInt(TimeBucket, int)}
   */
  @Test
  @DisplayName("Test fromInt(TimeBucket, int) with 'timeBucket', 'i'; when 'DAY'; then return MILLISECONDS_IN_DAY")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"long RBMBackedTimestampSet.fromInt(TimeBucket, int)"})
  void testFromIntWithTimeBucketI_whenDay_thenReturnMilliseconds_in_day() {
    // Arrange, Act and Assert
    assertEquals(CommonTimeUtil.MILLISECONDS_IN_DAY, RBMBackedTimestampSet.fromInt(TimeBucket.DAY, 1));
  }

  /**
   * Test {@link RBMBackedTimestampSet#fromInt(TimeBucket, int)} with {@code timeBucket}, {@code i}.
   * <ul>
   *   <li>When {@code HOUR}.</li>
   *   <li>Then return {@link CommonTimeUtil#MILLISECONDS_IN_HOUR}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RBMBackedTimestampSet#fromInt(TimeBucket, int)}
   */
  @Test
  @DisplayName("Test fromInt(TimeBucket, int) with 'timeBucket', 'i'; when 'HOUR'; then return MILLISECONDS_IN_HOUR")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"long RBMBackedTimestampSet.fromInt(TimeBucket, int)"})
  void testFromIntWithTimeBucketI_whenHour_thenReturnMilliseconds_in_hour() {
    // Arrange, Act and Assert
    assertEquals(CommonTimeUtil.MILLISECONDS_IN_HOUR, RBMBackedTimestampSet.fromInt(TimeBucket.HOUR, 1));
  }

  /**
   * Test {@link RBMBackedTimestampSet#fromInt(TimeBucket, int)} with {@code timeBucket}, {@code i}.
   * <ul>
   *   <li>When {@code MILLISECOND}.</li>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RBMBackedTimestampSet#fromInt(TimeBucket, int)}
   */
  @Test
  @DisplayName("Test fromInt(TimeBucket, int) with 'timeBucket', 'i'; when 'MILLISECOND'; then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"long RBMBackedTimestampSet.fromInt(TimeBucket, int)"})
  void testFromIntWithTimeBucketI_whenMillisecond_thenThrowIllegalStateException() {
    // Arrange, Act and Assert
    assertThrows(IllegalStateException.class, () -> RBMBackedTimestampSet.fromInt(TimeBucket.MILLISECOND, 1));
  }

  /**
   * Test {@link RBMBackedTimestampSet#fromInt(TimeBucket, int)} with {@code timeBucket}, {@code i}.
   * <ul>
   *   <li>When {@code MINUTE}.</li>
   *   <li>Then return {@link CommonTimeUtil#MILLISECONDS_IN_MINUTE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RBMBackedTimestampSet#fromInt(TimeBucket, int)}
   */
  @Test
  @DisplayName("Test fromInt(TimeBucket, int) with 'timeBucket', 'i'; when 'MINUTE'; then return MILLISECONDS_IN_MINUTE")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"long RBMBackedTimestampSet.fromInt(TimeBucket, int)"})
  void testFromIntWithTimeBucketI_whenMinute_thenReturnMilliseconds_in_minute() {
    // Arrange, Act and Assert
    assertEquals(CommonTimeUtil.MILLISECONDS_IN_MINUTE, RBMBackedTimestampSet.fromInt(TimeBucket.MINUTE, 1));
  }

  /**
   * Test {@link RBMBackedTimestampSet#fromInt(TimeBucket, int)} with {@code timeBucket}, {@code i}.
   * <ul>
   *   <li>When {@code MONTH}.</li>
   *   <li>Then return {@link CommonTimeUtil#MILLISECONDS_IN_DAY}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RBMBackedTimestampSet#fromInt(TimeBucket, int)}
   */
  @Test
  @DisplayName("Test fromInt(TimeBucket, int) with 'timeBucket', 'i'; when 'MONTH'; then return MILLISECONDS_IN_DAY")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"long RBMBackedTimestampSet.fromInt(TimeBucket, int)"})
  void testFromIntWithTimeBucketI_whenMonth_thenReturnMilliseconds_in_day() {
    // Arrange, Act and Assert
    assertEquals(CommonTimeUtil.MILLISECONDS_IN_DAY, RBMBackedTimestampSet.fromInt(TimeBucket.MONTH, 1));
  }

  /**
   * Test {@link RBMBackedTimestampSet#fromInt(TimeBucket, int)} with {@code timeBucket}, {@code i}.
   * <ul>
   *   <li>When {@code SECOND}.</li>
   *   <li>Then return {@link CommonTimeUtil#MILLISECONDS_IN_SECOND}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RBMBackedTimestampSet#fromInt(TimeBucket, int)}
   */
  @Test
  @DisplayName("Test fromInt(TimeBucket, int) with 'timeBucket', 'i'; when 'SECOND'; then return MILLISECONDS_IN_SECOND")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"long RBMBackedTimestampSet.fromInt(TimeBucket, int)"})
  void testFromIntWithTimeBucketI_whenSecond_thenReturnMilliseconds_in_second() {
    // Arrange, Act and Assert
    assertEquals(CommonTimeUtil.MILLISECONDS_IN_SECOND, RBMBackedTimestampSet.fromInt(TimeBucket.SECOND, 1));
  }

  /**
   * Test {@link RBMBackedTimestampSet#fromInt(TimeBucket, int)} with {@code timeBucket}, {@code i}.
   * <ul>
   *   <li>When {@code WEEK}.</li>
   *   <li>Then return {@link CommonTimeUtil#MILLISECONDS_IN_DAY}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RBMBackedTimestampSet#fromInt(TimeBucket, int)}
   */
  @Test
  @DisplayName("Test fromInt(TimeBucket, int) with 'timeBucket', 'i'; when 'WEEK'; then return MILLISECONDS_IN_DAY")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"long RBMBackedTimestampSet.fromInt(TimeBucket, int)"})
  void testFromIntWithTimeBucketI_whenWeek_thenReturnMilliseconds_in_day() {
    // Arrange, Act and Assert
    assertEquals(CommonTimeUtil.MILLISECONDS_IN_DAY, RBMBackedTimestampSet.fromInt(TimeBucket.WEEK, 1));
  }

  /**
   * Test {@link RBMBackedTimestampSet#fromInt(TimeBucket, int)} with {@code timeBucket}, {@code i}.
   * <ul>
   *   <li>When {@code YEAR}.</li>
   *   <li>Then return {@link CommonTimeUtil#MILLISECONDS_IN_DAY}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RBMBackedTimestampSet#fromInt(TimeBucket, int)}
   */
  @Test
  @DisplayName("Test fromInt(TimeBucket, int) with 'timeBucket', 'i'; when 'YEAR'; then return MILLISECONDS_IN_DAY")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"long RBMBackedTimestampSet.fromInt(TimeBucket, int)"})
  void testFromIntWithTimeBucketI_whenYear_thenReturnMilliseconds_in_day() {
    // Arrange, Act and Assert
    assertEquals(CommonTimeUtil.MILLISECONDS_IN_DAY, RBMBackedTimestampSet.fromInt(TimeBucket.YEAR, 1));
  }
}
