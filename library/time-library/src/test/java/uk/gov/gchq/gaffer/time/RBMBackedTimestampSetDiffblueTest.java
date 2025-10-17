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
import com.diffblue.cover.annotations.ManagedByDiffblue;
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
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Builder#build()}
   *   <li>default or parameterless constructor of {@link Builder}
   *   <li>{@link Builder#timeBucket(TimeBucket)}
   * </ul>
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void Builder.<init>()",
    "RBMBackedTimestampSet Builder.build()",
    "Builder Builder.timeBucket(TimeBucket)"
  })
  void testBuilderBuild() {
    // Arrange and Act
    Builder actualTimestampResult =
        new Builder()
            .timeBucket(TimeBucket.SECOND)
            .timestamp(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
    RBMBackedTimestampSet actualRbmBackedTimestampSet =
        actualTimestampResult
            .timestamps(new ArrayList<>())
            .timestamps(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant())
            .build();

    // Assert
    RoaringBitmap rbm = actualRbmBackedTimestampSet.getRbm();
    Iterator<Integer> iteratorResult = rbm.iterator();
    assertEquals(0, iteratorResult.next().intValue());
    assertEquals(1, rbm.getCardinality());
    assertEquals(1L, actualRbmBackedTimestampSet.getNumberOfTimestamps());
    assertEquals(TimeBucket.SECOND, actualRbmBackedTimestampSet.getTimeBucket());
    assertFalse(iteratorResult.hasNext());
    assertFalse(rbm.hasRunCompression());
    assertFalse(rbm.isEmpty());
    assertEquals(Short.SIZE, rbm.getSizeInBytes());
    Instant instant = Instant.EPOCH;
    assertSame(instant, actualRbmBackedTimestampSet.getEarliest());
    assertSame(instant, actualRbmBackedTimestampSet.getLatest());
  }

  /**
   * Test Builder {@link Builder#timestamp(Instant)}.
   *
   * <ul>
   *   <li>Given {@link Builder} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link Builder#timestamp(Instant)}
   */
  @Test
  @DisplayName("Test Builder timestamp(Instant); given Builder (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.timestamp(Instant)"})
  void testBuilderTimestamp_givenBuilder() {
    // Arrange
    Builder builder = new Builder();

    // Act
    Builder actualTimestampResult =
        builder.timestamp(
            LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Assert
    assertSame(builder, actualTimestampResult);
  }

  /**
   * Test Builder {@link Builder#timestamp(Instant)}.
   *
   * <ul>
   *   <li>Given {@link Builder} (default constructor) timestamp {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#timestamp(Instant)}
   */
  @Test
  @DisplayName(
      "Test Builder timestamp(Instant); given Builder (default constructor) timestamp 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.timestamp(Instant)"})
  void testBuilderTimestamp_givenBuilderTimestampNull() {
    // Arrange
    Builder builder = new Builder();
    builder.timestamp(null);

    // Act
    Builder actualTimestampResult =
        builder.timestamp(
            LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Assert
    assertSame(builder, actualTimestampResult);
  }

  /**
   * Test Builder {@link Builder#timestamps(Collection)} with {@code Collection}.
   *
   * <p>Method under test: {@link Builder#timestamps(Collection)}
   */
  @Test
  @DisplayName("Test Builder timestamps(Collection) with 'Collection'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.timestamps(Collection)"})
  void testBuilderTimestampsWithCollection() {
    // Arrange
    Builder builder = new Builder();

    ArrayList<Instant> timestamps = new ArrayList<>();
    timestamps.add(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Act
    Builder actualTimestampsResult = builder.timestamps(timestamps);

    // Assert
    assertSame(builder, actualTimestampsResult);
  }

  /**
   * Test Builder {@link Builder#timestamps(Collection)} with {@code Collection}.
   *
   * <p>Method under test: {@link Builder#timestamps(Collection)}
   */
  @Test
  @DisplayName("Test Builder timestamps(Collection) with 'Collection'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.timestamps(Collection)"})
  void testBuilderTimestampsWithCollection2() {
    // Arrange
    Builder builder = new Builder();

    ArrayList<Instant> timestamps = new ArrayList<>();
    timestamps.add(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
    timestamps.add(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Act
    Builder actualTimestampsResult = builder.timestamps(timestamps);

    // Assert
    assertSame(builder, actualTimestampsResult);
  }

  /**
   * Test Builder {@link Builder#timestamps(Collection)} with {@code Collection}.
   *
   * <ul>
   *   <li>Given {@link Builder} (default constructor) timestamp {@code null}.
   *   <li>When {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#timestamps(Collection)}
   */
  @Test
  @DisplayName(
      "Test Builder timestamps(Collection) with 'Collection'; given Builder (default constructor) timestamp 'null'; when ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.timestamps(Collection)"})
  void testBuilderTimestampsWithCollection_givenBuilderTimestampNull_whenArrayList() {
    // Arrange
    Builder builder = new Builder();
    builder.timestamp(null);

    // Act
    Builder actualTimestampsResult = builder.timestamps(new ArrayList<>());

    // Assert
    assertSame(builder, actualTimestampsResult);
  }

  /**
   * Test Builder {@link Builder#timestamps(Collection)} with {@code Collection}.
   *
   * <ul>
   *   <li>Given {@link Builder} (default constructor).
   *   <li>When {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#timestamps(Collection)}
   */
  @Test
  @DisplayName(
      "Test Builder timestamps(Collection) with 'Collection'; given Builder (default constructor); when ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.timestamps(Collection)"})
  void testBuilderTimestampsWithCollection_givenBuilder_whenArrayList() {
    // Arrange
    Builder builder = new Builder();

    // Act
    Builder actualTimestampsResult = builder.timestamps(new ArrayList<>());

    // Assert
    assertSame(builder, actualTimestampsResult);
  }

  /**
   * Test Builder {@link Builder#timestamps(Instant[])} with {@code Instant[]}.
   *
   * <ul>
   *   <li>Given {@link Builder} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link Builder#timestamps(Instant[])}
   */
  @Test
  @DisplayName(
      "Test Builder timestamps(Instant[]) with 'Instant[]'; given Builder (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.timestamps(Instant[])"})
  void testBuilderTimestampsWithInstant_givenBuilder() {
    // Arrange
    Builder builder = new Builder();

    // Act
    Builder actualTimestampsResult =
        builder.timestamps(
            LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Assert
    assertSame(builder, actualTimestampsResult);
  }

  /**
   * Test Builder {@link Builder#timestamps(Instant[])} with {@code Instant[]}.
   *
   * <ul>
   *   <li>Given {@link Builder} (default constructor) timestamp {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#timestamps(Instant[])}
   */
  @Test
  @DisplayName(
      "Test Builder timestamps(Instant[]) with 'Instant[]'; given Builder (default constructor) timestamp 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.timestamps(Instant[])"})
  void testBuilderTimestampsWithInstant_givenBuilderTimestampNull() {
    // Arrange
    Builder builder = new Builder();
    builder.timestamp(null);

    // Act
    Builder actualTimestampsResult =
        builder.timestamps(
            LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Assert
    assertSame(builder, actualTimestampsResult);
  }

  /**
   * Test {@link RBMBackedTimestampSet#RBMBackedTimestampSet(TimeBucket, Instant[])}.
   *
   * <p>Method under test: {@link RBMBackedTimestampSet#RBMBackedTimestampSet(TimeBucket,
   * Instant[])}
   */
  @Test
  @DisplayName("Test new RBMBackedTimestampSet(TimeBucket, Instant[])")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void RBMBackedTimestampSet.<init>(TimeBucket, Instant[])"})
  void testNewRBMBackedTimestampSet() {
    // Arrange
    LocalDate ofYearDayResult = LocalDate.ofYearDay(1, 1);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            new RBMBackedTimestampSet(
                TimeBucket.SECOND,
                ofYearDayResult.atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
  }

  /**
   * Test {@link RBMBackedTimestampSet#RBMBackedTimestampSet(TimeBucket, Instant[])}.
   *
   * <p>Method under test: {@link RBMBackedTimestampSet#RBMBackedTimestampSet(TimeBucket,
   * Instant[])}
   */
  @Test
  @DisplayName("Test new RBMBackedTimestampSet(TimeBucket, Instant[])")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void RBMBackedTimestampSet.<init>(TimeBucket, Instant[])"})
  void testNewRBMBackedTimestampSet2() {
    // Arrange and Act
    RBMBackedTimestampSet actualRbmBackedTimestampSet =
        new RBMBackedTimestampSet(
            TimeBucket.SECOND,
            LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant(),
            LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Assert
    RBMBackedTimestampSet actualShallowClone = actualRbmBackedTimestampSet.getShallowClone();
    assertEquals(actualRbmBackedTimestampSet, actualShallowClone);
  }

  /**
   * Test {@link RBMBackedTimestampSet#RBMBackedTimestampSet(TimeBucket, Instant[])}.
   *
   * <p>Method under test: {@link RBMBackedTimestampSet#RBMBackedTimestampSet(TimeBucket,
   * Instant[])}
   */
  @Test
  @DisplayName("Test new RBMBackedTimestampSet(TimeBucket, Instant[])")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void RBMBackedTimestampSet.<init>(TimeBucket, Instant[])"})
  void testNewRBMBackedTimestampSet3() {
    // Arrange and Act
    RBMBackedTimestampSet actualRbmBackedTimestampSet =
        new RBMBackedTimestampSet(
            TimeBucket.SECOND,
            LocalDate.now().atStartOfDay().atZone(ZoneOffset.UTC).toInstant(),
            LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Assert
    RBMBackedTimestampSet actualShallowClone = actualRbmBackedTimestampSet.getShallowClone();
    assertEquals(actualRbmBackedTimestampSet, actualShallowClone);
  }

  /**
   * Test {@link RBMBackedTimestampSet#RBMBackedTimestampSet(TimeBucket, Instant[])}.
   *
   * <p>Method under test: {@link RBMBackedTimestampSet#RBMBackedTimestampSet(TimeBucket,
   * Instant[])}
   */
  @Test
  @DisplayName("Test new RBMBackedTimestampSet(TimeBucket, Instant[])")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void RBMBackedTimestampSet.<init>(TimeBucket, Instant[])"})
  void testNewRBMBackedTimestampSet4() {
    // Arrange and Act
    RBMBackedTimestampSet actualRbmBackedTimestampSet =
        new RBMBackedTimestampSet(
            TimeBucket.SECOND,
            LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant(),
            LocalDate.now().atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Assert
    RBMBackedTimestampSet actualShallowClone = actualRbmBackedTimestampSet.getShallowClone();
    assertEquals(actualRbmBackedTimestampSet, actualShallowClone);
  }

  /**
   * Test {@link RBMBackedTimestampSet#RBMBackedTimestampSet(TimeBucket, Instant[])}.
   *
   * <ul>
   *   <li>When {@code DAY}.
   *   <li>Then return TimeBucket is {@code DAY}.
   * </ul>
   *
   * <p>Method under test: {@link RBMBackedTimestampSet#RBMBackedTimestampSet(TimeBucket,
   * Instant[])}
   */
  @Test
  @DisplayName(
      "Test new RBMBackedTimestampSet(TimeBucket, Instant[]); when 'DAY'; then return TimeBucket is 'DAY'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void RBMBackedTimestampSet.<init>(TimeBucket, Instant[])"})
  void testNewRBMBackedTimestampSet_whenDay_thenReturnTimeBucketIsDay() {
    // Arrange and Act
    RBMBackedTimestampSet actualRbmBackedTimestampSet =
        new RBMBackedTimestampSet(
            TimeBucket.DAY,
            LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Assert
    assertEquals(TimeBucket.DAY, actualRbmBackedTimestampSet.getTimeBucket());
    RBMBackedTimestampSet actualShallowClone = actualRbmBackedTimestampSet.getShallowClone();
    assertEquals(actualRbmBackedTimestampSet, actualShallowClone);
  }

  /**
   * Test {@link RBMBackedTimestampSet#RBMBackedTimestampSet(TimeBucket, Instant[])}.
   *
   * <ul>
   *   <li>When {@code HOUR}.
   *   <li>Then return TimeBucket is {@code HOUR}.
   * </ul>
   *
   * <p>Method under test: {@link RBMBackedTimestampSet#RBMBackedTimestampSet(TimeBucket,
   * Instant[])}
   */
  @Test
  @DisplayName(
      "Test new RBMBackedTimestampSet(TimeBucket, Instant[]); when 'HOUR'; then return TimeBucket is 'HOUR'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void RBMBackedTimestampSet.<init>(TimeBucket, Instant[])"})
  void testNewRBMBackedTimestampSet_whenHour_thenReturnTimeBucketIsHour() {
    // Arrange and Act
    RBMBackedTimestampSet actualRbmBackedTimestampSet =
        new RBMBackedTimestampSet(
            TimeBucket.HOUR,
            LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Assert
    assertEquals(TimeBucket.HOUR, actualRbmBackedTimestampSet.getTimeBucket());
    RBMBackedTimestampSet actualShallowClone = actualRbmBackedTimestampSet.getShallowClone();
    assertEquals(actualRbmBackedTimestampSet, actualShallowClone);
  }

  /**
   * Test {@link RBMBackedTimestampSet#RBMBackedTimestampSet(TimeBucket)}.
   *
   * <ul>
   *   <li>When {@code MILLISECOND}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link RBMBackedTimestampSet#RBMBackedTimestampSet(TimeBucket)}
   */
  @Test
  @DisplayName(
      "Test new RBMBackedTimestampSet(TimeBucket); when 'MILLISECOND'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void RBMBackedTimestampSet.<init>(TimeBucket)"})
  void testNewRBMBackedTimestampSet_whenMillisecond_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> new RBMBackedTimestampSet(TimeBucket.MILLISECOND));
  }

  /**
   * Test {@link RBMBackedTimestampSet#RBMBackedTimestampSet(TimeBucket, Instant[])}.
   *
   * <ul>
   *   <li>When {@code MILLISECOND}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link RBMBackedTimestampSet#RBMBackedTimestampSet(TimeBucket,
   * Instant[])}
   */
  @Test
  @DisplayName(
      "Test new RBMBackedTimestampSet(TimeBucket, Instant[]); when 'MILLISECOND'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void RBMBackedTimestampSet.<init>(TimeBucket, Instant[])"})
  void testNewRBMBackedTimestampSet_whenMillisecond_thenThrowIllegalArgumentException2() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            new RBMBackedTimestampSet(
                TimeBucket.MILLISECOND,
                LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
  }

  /**
   * Test {@link RBMBackedTimestampSet#RBMBackedTimestampSet(TimeBucket, Instant[])}.
   *
   * <ul>
   *   <li>When {@code MINUTE}.
   *   <li>Then return TimeBucket is {@code MINUTE}.
   * </ul>
   *
   * <p>Method under test: {@link RBMBackedTimestampSet#RBMBackedTimestampSet(TimeBucket,
   * Instant[])}
   */
  @Test
  @DisplayName(
      "Test new RBMBackedTimestampSet(TimeBucket, Instant[]); when 'MINUTE'; then return TimeBucket is 'MINUTE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void RBMBackedTimestampSet.<init>(TimeBucket, Instant[])"})
  void testNewRBMBackedTimestampSet_whenMinute_thenReturnTimeBucketIsMinute() {
    // Arrange and Act
    RBMBackedTimestampSet actualRbmBackedTimestampSet =
        new RBMBackedTimestampSet(
            TimeBucket.MINUTE,
            LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Assert
    assertEquals(TimeBucket.MINUTE, actualRbmBackedTimestampSet.getTimeBucket());
    RBMBackedTimestampSet actualShallowClone = actualRbmBackedTimestampSet.getShallowClone();
    assertEquals(actualRbmBackedTimestampSet, actualShallowClone);
  }

  /**
   * Test {@link RBMBackedTimestampSet#RBMBackedTimestampSet(TimeBucket, Instant[])}.
   *
   * <ul>
   *   <li>When {@code MONTH}.
   *   <li>Then return TimeBucket is {@code MONTH}.
   * </ul>
   *
   * <p>Method under test: {@link RBMBackedTimestampSet#RBMBackedTimestampSet(TimeBucket,
   * Instant[])}
   */
  @Test
  @DisplayName(
      "Test new RBMBackedTimestampSet(TimeBucket, Instant[]); when 'MONTH'; then return TimeBucket is 'MONTH'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void RBMBackedTimestampSet.<init>(TimeBucket, Instant[])"})
  void testNewRBMBackedTimestampSet_whenMonth_thenReturnTimeBucketIsMonth() {
    // Arrange and Act
    RBMBackedTimestampSet actualRbmBackedTimestampSet =
        new RBMBackedTimestampSet(
            TimeBucket.MONTH,
            LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Assert
    assertEquals(TimeBucket.MONTH, actualRbmBackedTimestampSet.getTimeBucket());
    RBMBackedTimestampSet actualShallowClone = actualRbmBackedTimestampSet.getShallowClone();
    assertEquals(actualRbmBackedTimestampSet, actualShallowClone);
  }

  /**
   * Test {@link RBMBackedTimestampSet#RBMBackedTimestampSet(TimeBucket, Instant[])}.
   *
   * <ul>
   *   <li>When {@code SECOND}.
   * </ul>
   *
   * <p>Method under test: {@link RBMBackedTimestampSet#RBMBackedTimestampSet(TimeBucket,
   * Instant[])}
   */
  @Test
  @DisplayName("Test new RBMBackedTimestampSet(TimeBucket, Instant[]); when 'SECOND'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void RBMBackedTimestampSet.<init>(TimeBucket, Instant[])"})
  void testNewRBMBackedTimestampSet_whenSecond() {
    // Arrange and Act
    RBMBackedTimestampSet actualRbmBackedTimestampSet =
        new RBMBackedTimestampSet(
            TimeBucket.SECOND,
            LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Assert
    RBMBackedTimestampSet actualShallowClone = actualRbmBackedTimestampSet.getShallowClone();
    assertEquals(actualRbmBackedTimestampSet, actualShallowClone);
  }

  /**
   * Test {@link RBMBackedTimestampSet#RBMBackedTimestampSet(TimeBucket)}.
   *
   * <ul>
   *   <li>When {@code SECOND}.
   *   <li>Then return Earliest is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link RBMBackedTimestampSet#RBMBackedTimestampSet(TimeBucket)}
   */
  @Test
  @DisplayName(
      "Test new RBMBackedTimestampSet(TimeBucket); when 'SECOND'; then return Earliest is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void RBMBackedTimestampSet.<init>(TimeBucket)"})
  void testNewRBMBackedTimestampSet_whenSecond_thenReturnEarliestIsNull() {
    // Arrange and Act
    RBMBackedTimestampSet actualRbmBackedTimestampSet =
        new RBMBackedTimestampSet(TimeBucket.SECOND);

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
    RBMBackedTimestampSet actualShallowClone = actualRbmBackedTimestampSet.getShallowClone();
    assertEquals(actualRbmBackedTimestampSet, actualShallowClone);
  }

  /**
   * Test {@link RBMBackedTimestampSet#RBMBackedTimestampSet(TimeBucket, Instant[])}.
   *
   * <ul>
   *   <li>When {@code SECOND}.
   *   <li>Then return Earliest is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link RBMBackedTimestampSet#RBMBackedTimestampSet(TimeBucket,
   * Instant[])}
   */
  @Test
  @DisplayName(
      "Test new RBMBackedTimestampSet(TimeBucket, Instant[]); when 'SECOND'; then return Earliest is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void RBMBackedTimestampSet.<init>(TimeBucket, Instant[])"})
  void testNewRBMBackedTimestampSet_whenSecond_thenReturnEarliestIsNull2() {
    // Arrange and Act
    RBMBackedTimestampSet actualRbmBackedTimestampSet =
        new RBMBackedTimestampSet(TimeBucket.SECOND, new Instant[] {});

    // Assert
    assertNull(actualRbmBackedTimestampSet.getEarliest());
    assertNull(actualRbmBackedTimestampSet.getLatest());
    RoaringBitmap rbm = actualRbmBackedTimestampSet.getRbm();
    assertEquals(0, rbm.getCardinality());
    assertEquals(0L, actualRbmBackedTimestampSet.getNumberOfTimestamps());
    assertEquals(8, rbm.getSizeInBytes());
    assertFalse(rbm.iterator().hasNext());
    assertTrue(actualRbmBackedTimestampSet.getTimestamps().isEmpty());
    assertTrue(rbm.isEmpty());
    RBMBackedTimestampSet actualShallowClone = actualRbmBackedTimestampSet.getShallowClone();
    assertEquals(actualRbmBackedTimestampSet, actualShallowClone);
  }

  /**
   * Test {@link RBMBackedTimestampSet#RBMBackedTimestampSet(TimeBucket, Instant[])}.
   *
   * <ul>
   *   <li>When {@code WEEK}.
   *   <li>Then return Earliest EpochSecond is {@code -259200}.
   * </ul>
   *
   * <p>Method under test: {@link RBMBackedTimestampSet#RBMBackedTimestampSet(TimeBucket,
   * Instant[])}
   */
  @Test
  @DisplayName(
      "Test new RBMBackedTimestampSet(TimeBucket, Instant[]); when 'WEEK'; then return Earliest EpochSecond is '-259200'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void RBMBackedTimestampSet.<init>(TimeBucket, Instant[])"})
  void testNewRBMBackedTimestampSet_whenWeek_thenReturnEarliestEpochSecondIs259200() {
    // Arrange and Act
    RBMBackedTimestampSet actualRbmBackedTimestampSet =
        new RBMBackedTimestampSet(
            TimeBucket.WEEK,
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
   *
   * <ul>
   *   <li>When {@code YEAR}.
   *   <li>Then return TimeBucket is {@code YEAR}.
   * </ul>
   *
   * <p>Method under test: {@link RBMBackedTimestampSet#RBMBackedTimestampSet(TimeBucket,
   * Instant[])}
   */
  @Test
  @DisplayName(
      "Test new RBMBackedTimestampSet(TimeBucket, Instant[]); when 'YEAR'; then return TimeBucket is 'YEAR'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void RBMBackedTimestampSet.<init>(TimeBucket, Instant[])"})
  void testNewRBMBackedTimestampSet_whenYear_thenReturnTimeBucketIsYear() {
    // Arrange and Act
    RBMBackedTimestampSet actualRbmBackedTimestampSet =
        new RBMBackedTimestampSet(
            TimeBucket.YEAR,
            LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Assert
    assertEquals(TimeBucket.YEAR, actualRbmBackedTimestampSet.getTimeBucket());
    RBMBackedTimestampSet actualShallowClone = actualRbmBackedTimestampSet.getShallowClone();
    assertEquals(actualRbmBackedTimestampSet, actualShallowClone);
  }

  /**
   * Test {@link RBMBackedTimestampSet#add(Instant)} with {@code instant}.
   *
   * <p>Method under test: {@link RBMBackedTimestampSet#add(Instant)}
   */
  @Test
  @DisplayName("Test add(Instant) with 'instant'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void RBMBackedTimestampSet.add(Instant)"})
  void testAddWithInstant() {
    // Arrange
    RBMBackedTimestampSet rbmBackedTimestampSet = new RBMBackedTimestampSet(TimeBucket.SECOND);

    // Act
    rbmBackedTimestampSet.add(
        LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Assert
    RBMBackedTimestampSet shallowClone = rbmBackedTimestampSet.getShallowClone();
    assertEquals(1L, shallowClone.getNumberOfTimestamps());
    RBMBackedTimestampSet shallowClone2 = shallowClone.getShallowClone();
    assertEquals(1L, shallowClone2.getNumberOfTimestamps());
    RBMBackedTimestampSet shallowClone3 = shallowClone2.getShallowClone();
    assertEquals(1L, shallowClone3.getNumberOfTimestamps());
    RBMBackedTimestampSet shallowClone4 = shallowClone3.getShallowClone();
    assertEquals(1L, shallowClone4.getNumberOfTimestamps());
    Instant instant = Instant.EPOCH;
    assertSame(instant, shallowClone.getEarliest());
    assertSame(instant, shallowClone2.getEarliest());
    assertSame(instant, shallowClone3.getEarliest());
    assertSame(instant, shallowClone4.getEarliest());
    assertSame(instant, rbmBackedTimestampSet.getLatest());
    assertSame(instant, shallowClone.getLatest());
    assertSame(instant, shallowClone2.getLatest());
    assertSame(instant, shallowClone3.getLatest());
    assertSame(instant, shallowClone4.getLatest());
  }

  /**
   * Test {@link RBMBackedTimestampSet#add(Instant)} with {@code instant}.
   *
   * <p>Method under test: {@link RBMBackedTimestampSet#add(Instant)}
   */
  @Test
  @DisplayName("Test add(Instant) with 'instant'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void RBMBackedTimestampSet.add(Instant)"})
  void testAddWithInstant2() {
    // Arrange
    RBMBackedTimestampSet rbmBackedTimestampSet = new RBMBackedTimestampSet(TimeBucket.MINUTE);

    // Act
    rbmBackedTimestampSet.add(
        LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Assert
    RBMBackedTimestampSet shallowClone = rbmBackedTimestampSet.getShallowClone();
    assertEquals(1L, shallowClone.getNumberOfTimestamps());
    RBMBackedTimestampSet shallowClone2 = shallowClone.getShallowClone();
    assertEquals(1L, shallowClone2.getNumberOfTimestamps());
    RBMBackedTimestampSet shallowClone3 = shallowClone2.getShallowClone();
    assertEquals(1L, shallowClone3.getNumberOfTimestamps());
    RBMBackedTimestampSet shallowClone4 = shallowClone3.getShallowClone();
    assertEquals(1L, shallowClone4.getNumberOfTimestamps());
    Instant instant = Instant.EPOCH;
    assertSame(instant, shallowClone.getEarliest());
    assertSame(instant, shallowClone2.getEarliest());
    assertSame(instant, shallowClone3.getEarliest());
    assertSame(instant, shallowClone4.getEarliest());
    assertSame(instant, rbmBackedTimestampSet.getLatest());
    assertSame(instant, shallowClone.getLatest());
    assertSame(instant, shallowClone2.getLatest());
    assertSame(instant, shallowClone3.getLatest());
    assertSame(instant, shallowClone4.getLatest());
  }

  /**
   * Test {@link RBMBackedTimestampSet#add(Instant)} with {@code instant}.
   *
   * <p>Method under test: {@link RBMBackedTimestampSet#add(Instant)}
   */
  @Test
  @DisplayName("Test add(Instant) with 'instant'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void RBMBackedTimestampSet.add(Instant)"})
  void testAddWithInstant3() {
    // Arrange
    RBMBackedTimestampSet rbmBackedTimestampSet = new RBMBackedTimestampSet(TimeBucket.HOUR);

    // Act
    rbmBackedTimestampSet.add(
        LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Assert
    RBMBackedTimestampSet shallowClone = rbmBackedTimestampSet.getShallowClone();
    assertEquals(1L, shallowClone.getNumberOfTimestamps());
    RBMBackedTimestampSet shallowClone2 = shallowClone.getShallowClone();
    assertEquals(1L, shallowClone2.getNumberOfTimestamps());
    RBMBackedTimestampSet shallowClone3 = shallowClone2.getShallowClone();
    assertEquals(1L, shallowClone3.getNumberOfTimestamps());
    RBMBackedTimestampSet shallowClone4 = shallowClone3.getShallowClone();
    assertEquals(1L, shallowClone4.getNumberOfTimestamps());
    Instant instant = Instant.EPOCH;
    assertSame(instant, shallowClone.getEarliest());
    assertSame(instant, shallowClone2.getEarliest());
    assertSame(instant, shallowClone3.getEarliest());
    assertSame(instant, shallowClone4.getEarliest());
    assertSame(instant, rbmBackedTimestampSet.getLatest());
    assertSame(instant, shallowClone.getLatest());
    assertSame(instant, shallowClone2.getLatest());
    assertSame(instant, shallowClone3.getLatest());
    assertSame(instant, shallowClone4.getLatest());
  }

  /**
   * Test {@link RBMBackedTimestampSet#add(Instant)} with {@code instant}.
   *
   * <p>Method under test: {@link RBMBackedTimestampSet#add(Instant)}
   */
  @Test
  @DisplayName("Test add(Instant) with 'instant'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void RBMBackedTimestampSet.add(Instant)"})
  void testAddWithInstant4() {
    // Arrange
    RBMBackedTimestampSet rbmBackedTimestampSet = new RBMBackedTimestampSet(TimeBucket.DAY);

    // Act
    rbmBackedTimestampSet.add(
        LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Assert
    RBMBackedTimestampSet shallowClone = rbmBackedTimestampSet.getShallowClone();
    assertEquals(1L, shallowClone.getNumberOfTimestamps());
    RBMBackedTimestampSet shallowClone2 = shallowClone.getShallowClone();
    assertEquals(1L, shallowClone2.getNumberOfTimestamps());
    RBMBackedTimestampSet shallowClone3 = shallowClone2.getShallowClone();
    assertEquals(1L, shallowClone3.getNumberOfTimestamps());
    RBMBackedTimestampSet shallowClone4 = shallowClone3.getShallowClone();
    assertEquals(1L, shallowClone4.getNumberOfTimestamps());
    Instant instant = Instant.EPOCH;
    assertSame(instant, shallowClone.getEarliest());
    assertSame(instant, shallowClone2.getEarliest());
    assertSame(instant, shallowClone3.getEarliest());
    assertSame(instant, shallowClone4.getEarliest());
    assertSame(instant, rbmBackedTimestampSet.getLatest());
    assertSame(instant, shallowClone.getLatest());
    assertSame(instant, shallowClone2.getLatest());
    assertSame(instant, shallowClone3.getLatest());
    assertSame(instant, shallowClone4.getLatest());
  }

  /**
   * Test {@link RBMBackedTimestampSet#add(Instant)} with {@code instant}.
   *
   * <p>Method under test: {@link RBMBackedTimestampSet#add(Instant)}
   */
  @Test
  @DisplayName("Test add(Instant) with 'instant'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void RBMBackedTimestampSet.add(Instant)"})
  void testAddWithInstant5() {
    // Arrange
    RBMBackedTimestampSet rbmBackedTimestampSet = new RBMBackedTimestampSet(TimeBucket.WEEK);

    // Act
    rbmBackedTimestampSet.add(
        LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

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
   *
   * <p>Method under test: {@link RBMBackedTimestampSet#add(Instant)}
   */
  @Test
  @DisplayName("Test add(Instant) with 'instant'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void RBMBackedTimestampSet.add(Instant)"})
  void testAddWithInstant6() {
    // Arrange
    RBMBackedTimestampSet rbmBackedTimestampSet = new RBMBackedTimestampSet(TimeBucket.MONTH);

    // Act
    rbmBackedTimestampSet.add(
        LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Assert
    RBMBackedTimestampSet shallowClone = rbmBackedTimestampSet.getShallowClone();
    assertEquals(1L, shallowClone.getNumberOfTimestamps());
    RBMBackedTimestampSet shallowClone2 = shallowClone.getShallowClone();
    assertEquals(1L, shallowClone2.getNumberOfTimestamps());
    RBMBackedTimestampSet shallowClone3 = shallowClone2.getShallowClone();
    assertEquals(1L, shallowClone3.getNumberOfTimestamps());
    RBMBackedTimestampSet shallowClone4 = shallowClone3.getShallowClone();
    assertEquals(1L, shallowClone4.getNumberOfTimestamps());
    Instant instant = Instant.EPOCH;
    assertSame(instant, shallowClone.getEarliest());
    assertSame(instant, shallowClone2.getEarliest());
    assertSame(instant, shallowClone3.getEarliest());
    assertSame(instant, shallowClone4.getEarliest());
    assertSame(instant, rbmBackedTimestampSet.getLatest());
    assertSame(instant, shallowClone.getLatest());
    assertSame(instant, shallowClone2.getLatest());
    assertSame(instant, shallowClone3.getLatest());
    assertSame(instant, shallowClone4.getLatest());
  }

  /**
   * Test {@link RBMBackedTimestampSet#add(Instant)} with {@code instant}.
   *
   * <p>Method under test: {@link RBMBackedTimestampSet#add(Instant)}
   */
  @Test
  @DisplayName("Test add(Instant) with 'instant'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void RBMBackedTimestampSet.add(Instant)"})
  void testAddWithInstant7() {
    // Arrange
    RBMBackedTimestampSet rbmBackedTimestampSet = new RBMBackedTimestampSet(TimeBucket.YEAR);

    // Act
    rbmBackedTimestampSet.add(
        LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Assert
    RBMBackedTimestampSet shallowClone = rbmBackedTimestampSet.getShallowClone();
    assertEquals(1L, shallowClone.getNumberOfTimestamps());
    RBMBackedTimestampSet shallowClone2 = shallowClone.getShallowClone();
    assertEquals(1L, shallowClone2.getNumberOfTimestamps());
    RBMBackedTimestampSet shallowClone3 = shallowClone2.getShallowClone();
    assertEquals(1L, shallowClone3.getNumberOfTimestamps());
    RBMBackedTimestampSet shallowClone4 = shallowClone3.getShallowClone();
    assertEquals(1L, shallowClone4.getNumberOfTimestamps());
    Instant instant = Instant.EPOCH;
    assertSame(instant, shallowClone.getEarliest());
    assertSame(instant, shallowClone2.getEarliest());
    assertSame(instant, shallowClone3.getEarliest());
    assertSame(instant, shallowClone4.getEarliest());
    assertSame(instant, rbmBackedTimestampSet.getLatest());
    assertSame(instant, shallowClone.getLatest());
    assertSame(instant, shallowClone2.getLatest());
    assertSame(instant, shallowClone3.getLatest());
    assertSame(instant, shallowClone4.getLatest());
  }

  /**
   * Test {@link RBMBackedTimestampSet#add(Instant)} with {@code instant}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link RBMBackedTimestampSet#add(Instant)}
   */
  @Test
  @DisplayName("Test add(Instant) with 'instant'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void RBMBackedTimestampSet.add(Instant)"})
  void testAddWithInstant_thenThrowIllegalArgumentException() {
    // Arrange
    LocalDate ofYearDayResult = LocalDate.ofYearDay(1, 1);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            new RBMBackedTimestampSet(TimeBucket.SECOND)
                .add(ofYearDayResult.atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
  }

  /**
   * Test {@link RBMBackedTimestampSet#add(Collection)} with {@code instants}.
   *
   * <p>Method under test: {@link RBMBackedTimestampSet#add(Collection)}
   */
  @Test
  @DisplayName("Test add(Collection) with 'instants'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
    assertEquals(0L, rbmBackedTimestampSet.getShallowClone().getNumberOfTimestamps());
    assertEquals(8, rbm.getSizeInBytes());
    assertFalse(rbm.iterator().hasNext());
    assertTrue(rbmBackedTimestampSet.getTimestamps().isEmpty());
  }

  /**
   * Test {@link RBMBackedTimestampSet#add(Collection)} with {@code instants}.
   *
   * <p>Method under test: {@link RBMBackedTimestampSet#add(Collection)}
   */
  @Test
  @DisplayName("Test add(Collection) with 'instants'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void RBMBackedTimestampSet.add(Collection)"})
  void testAddWithInstants2() {
    // Arrange
    RBMBackedTimestampSet rbmBackedTimestampSet = new RBMBackedTimestampSet(TimeBucket.SECOND);

    ArrayList<Instant> instants = new ArrayList<>();
    instants.add(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Act
    rbmBackedTimestampSet.add(instants);

    // Assert
    Iterator<Integer> iteratorResult = rbmBackedTimestampSet.getRbm().iterator();
    assertEquals(0, iteratorResult.next().intValue());
    RBMBackedTimestampSet shallowClone = rbmBackedTimestampSet.getShallowClone();
    assertEquals(1L, shallowClone.getNumberOfTimestamps());
    RBMBackedTimestampSet shallowClone2 = shallowClone.getShallowClone();
    assertEquals(1L, shallowClone2.getNumberOfTimestamps());
    assertEquals(1L, shallowClone2.getShallowClone().getNumberOfTimestamps());
    assertFalse(iteratorResult.hasNext());
  }

  /**
   * Test {@link RBMBackedTimestampSet#add(Collection)} with {@code instants}.
   *
   * <p>Method under test: {@link RBMBackedTimestampSet#add(Collection)}
   */
  @Test
  @DisplayName("Test add(Collection) with 'instants'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
    Iterator<Integer> iteratorResult = rbmBackedTimestampSet.getRbm().iterator();
    assertEquals(0, iteratorResult.next().intValue());
    RBMBackedTimestampSet shallowClone = rbmBackedTimestampSet.getShallowClone();
    assertEquals(1L, shallowClone.getNumberOfTimestamps());
    RBMBackedTimestampSet shallowClone2 = shallowClone.getShallowClone();
    assertEquals(1L, shallowClone2.getNumberOfTimestamps());
    assertEquals(1L, shallowClone2.getShallowClone().getNumberOfTimestamps());
    assertFalse(iteratorResult.hasNext());
  }

  /**
   * Test {@link RBMBackedTimestampSet#add(Collection)} with {@code instants}.
   *
   * <p>Method under test: {@link RBMBackedTimestampSet#add(Collection)}
   */
  @Test
  @DisplayName("Test add(Collection) with 'instants'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void RBMBackedTimestampSet.add(Collection)"})
  void testAddWithInstants4() {
    // Arrange
    RBMBackedTimestampSet rbmBackedTimestampSet = new RBMBackedTimestampSet(TimeBucket.MINUTE);

    ArrayList<Instant> instants = new ArrayList<>();
    instants.add(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Act
    rbmBackedTimestampSet.add(instants);

    // Assert
    Iterator<Integer> iteratorResult = rbmBackedTimestampSet.getRbm().iterator();
    assertEquals(0, iteratorResult.next().intValue());
    RBMBackedTimestampSet shallowClone = rbmBackedTimestampSet.getShallowClone();
    assertEquals(1L, shallowClone.getNumberOfTimestamps());
    RBMBackedTimestampSet shallowClone2 = shallowClone.getShallowClone();
    assertEquals(1L, shallowClone2.getNumberOfTimestamps());
    assertEquals(1L, shallowClone2.getShallowClone().getNumberOfTimestamps());
    assertFalse(iteratorResult.hasNext());
  }

  /**
   * Test {@link RBMBackedTimestampSet#add(Collection)} with {@code instants}.
   *
   * <p>Method under test: {@link RBMBackedTimestampSet#add(Collection)}
   */
  @Test
  @DisplayName("Test add(Collection) with 'instants'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void RBMBackedTimestampSet.add(Collection)"})
  void testAddWithInstants5() {
    // Arrange
    RBMBackedTimestampSet rbmBackedTimestampSet = new RBMBackedTimestampSet(TimeBucket.HOUR);

    ArrayList<Instant> instants = new ArrayList<>();
    instants.add(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Act
    rbmBackedTimestampSet.add(instants);

    // Assert
    Iterator<Integer> iteratorResult = rbmBackedTimestampSet.getRbm().iterator();
    assertEquals(0, iteratorResult.next().intValue());
    RBMBackedTimestampSet shallowClone = rbmBackedTimestampSet.getShallowClone();
    assertEquals(1L, shallowClone.getNumberOfTimestamps());
    RBMBackedTimestampSet shallowClone2 = shallowClone.getShallowClone();
    assertEquals(1L, shallowClone2.getNumberOfTimestamps());
    assertEquals(1L, shallowClone2.getShallowClone().getNumberOfTimestamps());
    assertFalse(iteratorResult.hasNext());
  }

  /**
   * Test {@link RBMBackedTimestampSet#add(Collection)} with {@code instants}.
   *
   * <p>Method under test: {@link RBMBackedTimestampSet#add(Collection)}
   */
  @Test
  @DisplayName("Test add(Collection) with 'instants'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void RBMBackedTimestampSet.add(Collection)"})
  void testAddWithInstants6() {
    // Arrange
    RBMBackedTimestampSet rbmBackedTimestampSet = new RBMBackedTimestampSet(TimeBucket.DAY);

    ArrayList<Instant> instants = new ArrayList<>();
    instants.add(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Act
    rbmBackedTimestampSet.add(instants);

    // Assert
    Iterator<Integer> iteratorResult = rbmBackedTimestampSet.getRbm().iterator();
    assertEquals(0, iteratorResult.next().intValue());
    RBMBackedTimestampSet shallowClone = rbmBackedTimestampSet.getShallowClone();
    assertEquals(1L, shallowClone.getNumberOfTimestamps());
    RBMBackedTimestampSet shallowClone2 = shallowClone.getShallowClone();
    assertEquals(1L, shallowClone2.getNumberOfTimestamps());
    assertEquals(1L, shallowClone2.getShallowClone().getNumberOfTimestamps());
    assertFalse(iteratorResult.hasNext());
  }

  /**
   * Test {@link RBMBackedTimestampSet#add(Collection)} with {@code instants}.
   *
   * <p>Method under test: {@link RBMBackedTimestampSet#add(Collection)}
   */
  @Test
  @DisplayName("Test add(Collection) with 'instants'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
   *
   * <p>Method under test: {@link RBMBackedTimestampSet#add(Collection)}
   */
  @Test
  @DisplayName("Test add(Collection) with 'instants'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void RBMBackedTimestampSet.add(Collection)"})
  void testAddWithInstants8() {
    // Arrange
    RBMBackedTimestampSet rbmBackedTimestampSet = new RBMBackedTimestampSet(TimeBucket.MONTH);

    ArrayList<Instant> instants = new ArrayList<>();
    instants.add(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Act
    rbmBackedTimestampSet.add(instants);

    // Assert
    Iterator<Integer> iteratorResult = rbmBackedTimestampSet.getRbm().iterator();
    assertEquals(0, iteratorResult.next().intValue());
    RBMBackedTimestampSet shallowClone = rbmBackedTimestampSet.getShallowClone();
    assertEquals(1L, shallowClone.getNumberOfTimestamps());
    RBMBackedTimestampSet shallowClone2 = shallowClone.getShallowClone();
    assertEquals(1L, shallowClone2.getNumberOfTimestamps());
    assertEquals(1L, shallowClone2.getShallowClone().getNumberOfTimestamps());
    assertFalse(iteratorResult.hasNext());
  }

  /**
   * Test {@link RBMBackedTimestampSet#add(Collection)} with {@code instants}.
   *
   * <p>Method under test: {@link RBMBackedTimestampSet#add(Collection)}
   */
  @Test
  @DisplayName("Test add(Collection) with 'instants'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void RBMBackedTimestampSet.add(Collection)"})
  void testAddWithInstants9() {
    // Arrange
    RBMBackedTimestampSet rbmBackedTimestampSet = new RBMBackedTimestampSet(TimeBucket.YEAR);

    ArrayList<Instant> instants = new ArrayList<>();
    instants.add(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Act
    rbmBackedTimestampSet.add(instants);

    // Assert
    Iterator<Integer> iteratorResult = rbmBackedTimestampSet.getRbm().iterator();
    assertEquals(0, iteratorResult.next().intValue());
    RBMBackedTimestampSet shallowClone = rbmBackedTimestampSet.getShallowClone();
    assertEquals(1L, shallowClone.getNumberOfTimestamps());
    RBMBackedTimestampSet shallowClone2 = shallowClone.getShallowClone();
    assertEquals(1L, shallowClone2.getNumberOfTimestamps());
    assertEquals(1L, shallowClone2.getShallowClone().getNumberOfTimestamps());
    assertFalse(iteratorResult.hasNext());
  }

  /**
   * Test {@link RBMBackedTimestampSet#add(Collection)} with {@code instants}.
   *
   * <ul>
   *   <li>Given now atStartOfDay atZone {@link ZoneOffset#UTC} toInstant.
   * </ul>
   *
   * <p>Method under test: {@link RBMBackedTimestampSet#add(Collection)}
   */
  @Test
  @DisplayName("Test add(Collection) with 'instants'; given now atStartOfDay atZone UTC toInstant")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void RBMBackedTimestampSet.add(Collection)"})
  void testAddWithInstants_givenNowAtStartOfDayAtZoneUtcToInstant() {
    // Arrange
    RBMBackedTimestampSet rbmBackedTimestampSet = new RBMBackedTimestampSet(TimeBucket.SECOND);

    ArrayList<Instant> instants = new ArrayList<>();
    instants.add(LocalDate.now().atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
    instants.add(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Act
    rbmBackedTimestampSet.add(instants);

    // Assert
    assertEquals(0, rbmBackedTimestampSet.getRbm().iterator().next().intValue());
  }

  /**
   * Test {@link RBMBackedTimestampSet#add(Collection)} with {@code instants}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link RBMBackedTimestampSet#add(Collection)}
   */
  @Test
  @DisplayName("Test add(Collection) with 'instants'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void RBMBackedTimestampSet.add(Collection)"})
  void testAddWithInstants_thenThrowIllegalArgumentException() {
    // Arrange
    RBMBackedTimestampSet rbmBackedTimestampSet = new RBMBackedTimestampSet(TimeBucket.SECOND);

    ArrayList<Instant> instants = new ArrayList<>();

    LocalDate ofYearDayResult = LocalDate.ofYearDay(1, 1);
    instants.add(ofYearDayResult.atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> rbmBackedTimestampSet.add(instants));
  }

  /**
   * Test {@link RBMBackedTimestampSet#getTimestamps()}.
   *
   * <p>Method under test: {@link RBMBackedTimestampSet#getTimestamps()}
   */
  @Test
  @DisplayName("Test getTimestamps()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.SortedSet RBMBackedTimestampSet.getTimestamps()"})
  void testGetTimestamps() {
    // Arrange, Act and Assert
    assertEquals(
        1,
        new Builder()
            .timeBucket(TimeBucket.SECOND)
            .timestamp(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant())
            .build()
            .getTimestamps()
            .size());
  }

  /**
   * Test {@link RBMBackedTimestampSet#getTimestamps()}.
   *
   * <p>Method under test: {@link RBMBackedTimestampSet#getTimestamps()}
   */
  @Test
  @DisplayName("Test getTimestamps()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.SortedSet RBMBackedTimestampSet.getTimestamps()"})
  void testGetTimestamps2() {
    // Arrange, Act and Assert
    assertEquals(
        1,
        new Builder()
            .timeBucket(TimeBucket.MINUTE)
            .timestamp(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant())
            .build()
            .getTimestamps()
            .size());
  }

  /**
   * Test {@link RBMBackedTimestampSet#getTimestamps()}.
   *
   * <p>Method under test: {@link RBMBackedTimestampSet#getTimestamps()}
   */
  @Test
  @DisplayName("Test getTimestamps()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.SortedSet RBMBackedTimestampSet.getTimestamps()"})
  void testGetTimestamps3() {
    // Arrange, Act and Assert
    assertEquals(
        1,
        new Builder()
            .timeBucket(TimeBucket.HOUR)
            .timestamp(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant())
            .build()
            .getTimestamps()
            .size());
  }

  /**
   * Test {@link RBMBackedTimestampSet#getTimestamps()}.
   *
   * <p>Method under test: {@link RBMBackedTimestampSet#getTimestamps()}
   */
  @Test
  @DisplayName("Test getTimestamps()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.SortedSet RBMBackedTimestampSet.getTimestamps()"})
  void testGetTimestamps4() {
    // Arrange, Act and Assert
    assertEquals(
        1,
        new Builder()
            .timeBucket(TimeBucket.DAY)
            .timestamp(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant())
            .build()
            .getTimestamps()
            .size());
  }

  /**
   * Test {@link RBMBackedTimestampSet#getTimestamps()}.
   *
   * <p>Method under test: {@link RBMBackedTimestampSet#getTimestamps()}
   */
  @Test
  @DisplayName("Test getTimestamps()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.SortedSet RBMBackedTimestampSet.getTimestamps()"})
  void testGetTimestamps5() {
    // Arrange, Act and Assert
    assertEquals(
        1,
        new Builder()
            .timeBucket(TimeBucket.WEEK)
            .timestamp(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant())
            .build()
            .getTimestamps()
            .size());
  }

  /**
   * Test {@link RBMBackedTimestampSet#getTimestamps()}.
   *
   * <p>Method under test: {@link RBMBackedTimestampSet#getTimestamps()}
   */
  @Test
  @DisplayName("Test getTimestamps()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.SortedSet RBMBackedTimestampSet.getTimestamps()"})
  void testGetTimestamps6() {
    // Arrange, Act and Assert
    assertEquals(
        1,
        new Builder()
            .timeBucket(TimeBucket.MONTH)
            .timestamp(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant())
            .build()
            .getTimestamps()
            .size());
  }

  /**
   * Test {@link RBMBackedTimestampSet#getTimestamps()}.
   *
   * <p>Method under test: {@link RBMBackedTimestampSet#getTimestamps()}
   */
  @Test
  @DisplayName("Test getTimestamps()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.SortedSet RBMBackedTimestampSet.getTimestamps()"})
  void testGetTimestamps7() {
    // Arrange, Act and Assert
    assertEquals(
        1,
        new Builder()
            .timeBucket(TimeBucket.YEAR)
            .timestamp(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant())
            .build()
            .getTimestamps()
            .size());
  }

  /**
   * Test {@link RBMBackedTimestampSet#getTimestamps()}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link RBMBackedTimestampSet#getTimestamps()}
   */
  @Test
  @DisplayName("Test getTimestamps(); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.SortedSet RBMBackedTimestampSet.getTimestamps()"})
  void testGetTimestamps_thenReturnEmpty() {
    // Arrange, Act and Assert
    assertTrue(new RBMBackedTimestampSet(TimeBucket.SECOND).getTimestamps().isEmpty());
  }

  /**
   * Test {@link RBMBackedTimestampSet#getNumberOfTimestamps()}.
   *
   * <ul>
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link RBMBackedTimestampSet#getNumberOfTimestamps()}
   */
  @Test
  @DisplayName("Test getNumberOfTimestamps(); then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long RBMBackedTimestampSet.getNumberOfTimestamps()"})
  void testGetNumberOfTimestamps_thenReturnOne() {
    // Arrange, Act and Assert
    assertEquals(
        1L,
        new Builder()
            .timeBucket(TimeBucket.SECOND)
            .timestamp(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant())
            .build()
            .getNumberOfTimestamps());
  }

  /**
   * Test {@link RBMBackedTimestampSet#getNumberOfTimestamps()}.
   *
   * <ul>
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link RBMBackedTimestampSet#getNumberOfTimestamps()}
   */
  @Test
  @DisplayName("Test getNumberOfTimestamps(); then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long RBMBackedTimestampSet.getNumberOfTimestamps()"})
  void testGetNumberOfTimestamps_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0L, new RBMBackedTimestampSet(TimeBucket.SECOND).getNumberOfTimestamps());
  }

  /**
   * Test {@link RBMBackedTimestampSet#getEarliest()}.
   *
   * <p>Method under test: {@link RBMBackedTimestampSet#getEarliest()}
   */
  @Test
  @DisplayName("Test getEarliest()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Instant RBMBackedTimestampSet.getEarliest()"})
  void testGetEarliest() {
    // Arrange
    RBMBackedTimestampSet rbmBackedTimestampSet =
        new Builder()
            .timeBucket(TimeBucket.SECOND)
            .timestamp(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant())
            .build();

    // Act
    Instant actualEarliest = rbmBackedTimestampSet.getEarliest();

    // Assert
    assertEquals(0L, actualEarliest.getEpochSecond());
    Instant instant = Instant.EPOCH;
    assertSame(instant, actualEarliest);
    RBMBackedTimestampSet shallowClone = rbmBackedTimestampSet.getShallowClone();
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
    assertSame(instant, rbmBackedTimestampSet.getLatest());
  }

  /**
   * Test {@link RBMBackedTimestampSet#getEarliest()}.
   *
   * <p>Method under test: {@link RBMBackedTimestampSet#getEarliest()}
   */
  @Test
  @DisplayName("Test getEarliest()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Instant RBMBackedTimestampSet.getEarliest()"})
  void testGetEarliest2() {
    // Arrange
    RBMBackedTimestampSet rbmBackedTimestampSet =
        new Builder()
            .timeBucket(TimeBucket.MINUTE)
            .timestamp(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant())
            .build();

    // Act
    Instant actualEarliest = rbmBackedTimestampSet.getEarliest();

    // Assert
    assertEquals(0L, actualEarliest.getEpochSecond());
    Instant instant = Instant.EPOCH;
    assertSame(instant, actualEarliest);
    RBMBackedTimestampSet shallowClone = rbmBackedTimestampSet.getShallowClone();
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
    assertSame(instant, rbmBackedTimestampSet.getLatest());
  }

  /**
   * Test {@link RBMBackedTimestampSet#getEarliest()}.
   *
   * <p>Method under test: {@link RBMBackedTimestampSet#getEarliest()}
   */
  @Test
  @DisplayName("Test getEarliest()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Instant RBMBackedTimestampSet.getEarliest()"})
  void testGetEarliest3() {
    // Arrange
    RBMBackedTimestampSet rbmBackedTimestampSet =
        new Builder()
            .timeBucket(TimeBucket.HOUR)
            .timestamp(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant())
            .build();

    // Act
    Instant actualEarliest = rbmBackedTimestampSet.getEarliest();

    // Assert
    assertEquals(0L, actualEarliest.getEpochSecond());
    Instant instant = Instant.EPOCH;
    assertSame(instant, actualEarliest);
    RBMBackedTimestampSet shallowClone = rbmBackedTimestampSet.getShallowClone();
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
    assertSame(instant, rbmBackedTimestampSet.getLatest());
  }

  /**
   * Test {@link RBMBackedTimestampSet#getEarliest()}.
   *
   * <p>Method under test: {@link RBMBackedTimestampSet#getEarliest()}
   */
  @Test
  @DisplayName("Test getEarliest()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Instant RBMBackedTimestampSet.getEarliest()"})
  void testGetEarliest4() {
    // Arrange
    RBMBackedTimestampSet rbmBackedTimestampSet =
        new Builder()
            .timeBucket(TimeBucket.DAY)
            .timestamp(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant())
            .build();

    // Act
    Instant actualEarliest = rbmBackedTimestampSet.getEarliest();

    // Assert
    assertEquals(0L, actualEarliest.getEpochSecond());
    Instant instant = Instant.EPOCH;
    assertSame(instant, actualEarliest);
    RBMBackedTimestampSet shallowClone = rbmBackedTimestampSet.getShallowClone();
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
    assertSame(instant, rbmBackedTimestampSet.getLatest());
  }

  /**
   * Test {@link RBMBackedTimestampSet#getEarliest()}.
   *
   * <p>Method under test: {@link RBMBackedTimestampSet#getEarliest()}
   */
  @Test
  @DisplayName("Test getEarliest()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Instant RBMBackedTimestampSet.getEarliest()"})
  void testGetEarliest5() {
    // Arrange
    RBMBackedTimestampSet rbmBackedTimestampSet =
        new Builder()
            .timeBucket(TimeBucket.MONTH)
            .timestamp(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant())
            .build();

    // Act
    Instant actualEarliest = rbmBackedTimestampSet.getEarliest();

    // Assert
    assertEquals(0L, actualEarliest.getEpochSecond());
    Instant instant = Instant.EPOCH;
    assertSame(instant, actualEarliest);
    RBMBackedTimestampSet shallowClone = rbmBackedTimestampSet.getShallowClone();
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
    assertSame(instant, rbmBackedTimestampSet.getLatest());
  }

  /**
   * Test {@link RBMBackedTimestampSet#getEarliest()}.
   *
   * <p>Method under test: {@link RBMBackedTimestampSet#getEarliest()}
   */
  @Test
  @DisplayName("Test getEarliest()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Instant RBMBackedTimestampSet.getEarliest()"})
  void testGetEarliest6() {
    // Arrange
    RBMBackedTimestampSet rbmBackedTimestampSet =
        new Builder()
            .timeBucket(TimeBucket.YEAR)
            .timestamp(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant())
            .build();

    // Act
    Instant actualEarliest = rbmBackedTimestampSet.getEarliest();

    // Assert
    assertEquals(0L, actualEarliest.getEpochSecond());
    Instant instant = Instant.EPOCH;
    assertSame(instant, actualEarliest);
    RBMBackedTimestampSet shallowClone = rbmBackedTimestampSet.getShallowClone();
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
    assertSame(instant, rbmBackedTimestampSet.getLatest());
  }

  /**
   * Test {@link RBMBackedTimestampSet#getEarliest()}.
   *
   * <ul>
   *   <li>Given {@link RBMBackedTimestampSet#RBMBackedTimestampSet(TimeBucket)} with timeBucket is
   *       {@code SECOND}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link RBMBackedTimestampSet#getEarliest()}
   */
  @Test
  @DisplayName(
      "Test getEarliest(); given RBMBackedTimestampSet(TimeBucket) with timeBucket is 'SECOND'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
   *
   * <ul>
   *   <li>Then return EpochSecond is {@code -259200}.
   * </ul>
   *
   * <p>Method under test: {@link RBMBackedTimestampSet#getEarliest()}
   */
  @Test
  @DisplayName("Test getEarliest(); then return EpochSecond is '-259200'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Instant RBMBackedTimestampSet.getEarliest()"})
  void testGetEarliest_thenReturnEpochSecondIs259200() {
    // Arrange and Act
    Instant actualEarliest =
        new Builder()
            .timeBucket(TimeBucket.WEEK)
            .timestamp(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant())
            .build()
            .getEarliest();

    // Assert
    assertEquals(-259200L, actualEarliest.getEpochSecond());
    assertEquals(0, actualEarliest.getNano());
  }

  /**
   * Test {@link RBMBackedTimestampSet#getLatest()}.
   *
   * <p>Method under test: {@link RBMBackedTimestampSet#getLatest()}
   */
  @Test
  @DisplayName("Test getLatest()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Instant RBMBackedTimestampSet.getLatest()"})
  void testGetLatest() {
    // Arrange
    RBMBackedTimestampSet rbmBackedTimestampSet =
        new Builder()
            .timeBucket(TimeBucket.SECOND)
            .timestamp(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant())
            .build();

    // Act
    Instant actualLatest = rbmBackedTimestampSet.getLatest();

    // Assert
    assertEquals(0L, actualLatest.getEpochSecond());
    Instant instant = Instant.EPOCH;
    RBMBackedTimestampSet shallowClone = rbmBackedTimestampSet.getShallowClone();
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
    assertSame(instant, rbmBackedTimestampSet.getEarliest());
    assertSame(instant, actualLatest);
  }

  /**
   * Test {@link RBMBackedTimestampSet#getLatest()}.
   *
   * <p>Method under test: {@link RBMBackedTimestampSet#getLatest()}
   */
  @Test
  @DisplayName("Test getLatest()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Instant RBMBackedTimestampSet.getLatest()"})
  void testGetLatest2() {
    // Arrange
    RBMBackedTimestampSet rbmBackedTimestampSet =
        new Builder()
            .timeBucket(TimeBucket.MINUTE)
            .timestamp(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant())
            .build();

    // Act
    Instant actualLatest = rbmBackedTimestampSet.getLatest();

    // Assert
    assertEquals(0L, actualLatest.getEpochSecond());
    Instant instant = Instant.EPOCH;
    RBMBackedTimestampSet shallowClone = rbmBackedTimestampSet.getShallowClone();
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
    assertSame(instant, rbmBackedTimestampSet.getEarliest());
    assertSame(instant, actualLatest);
  }

  /**
   * Test {@link RBMBackedTimestampSet#getLatest()}.
   *
   * <p>Method under test: {@link RBMBackedTimestampSet#getLatest()}
   */
  @Test
  @DisplayName("Test getLatest()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Instant RBMBackedTimestampSet.getLatest()"})
  void testGetLatest3() {
    // Arrange
    RBMBackedTimestampSet rbmBackedTimestampSet =
        new Builder()
            .timeBucket(TimeBucket.HOUR)
            .timestamp(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant())
            .build();

    // Act
    Instant actualLatest = rbmBackedTimestampSet.getLatest();

    // Assert
    assertEquals(0L, actualLatest.getEpochSecond());
    Instant instant = Instant.EPOCH;
    RBMBackedTimestampSet shallowClone = rbmBackedTimestampSet.getShallowClone();
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
    assertSame(instant, rbmBackedTimestampSet.getEarliest());
    assertSame(instant, actualLatest);
  }

  /**
   * Test {@link RBMBackedTimestampSet#getLatest()}.
   *
   * <p>Method under test: {@link RBMBackedTimestampSet#getLatest()}
   */
  @Test
  @DisplayName("Test getLatest()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Instant RBMBackedTimestampSet.getLatest()"})
  void testGetLatest4() {
    // Arrange
    RBMBackedTimestampSet rbmBackedTimestampSet =
        new Builder()
            .timeBucket(TimeBucket.DAY)
            .timestamp(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant())
            .build();

    // Act
    Instant actualLatest = rbmBackedTimestampSet.getLatest();

    // Assert
    assertEquals(0L, actualLatest.getEpochSecond());
    Instant instant = Instant.EPOCH;
    RBMBackedTimestampSet shallowClone = rbmBackedTimestampSet.getShallowClone();
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
    assertSame(instant, rbmBackedTimestampSet.getEarliest());
    assertSame(instant, actualLatest);
  }

  /**
   * Test {@link RBMBackedTimestampSet#getLatest()}.
   *
   * <p>Method under test: {@link RBMBackedTimestampSet#getLatest()}
   */
  @Test
  @DisplayName("Test getLatest()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Instant RBMBackedTimestampSet.getLatest()"})
  void testGetLatest5() {
    // Arrange
    RBMBackedTimestampSet rbmBackedTimestampSet =
        new Builder()
            .timeBucket(TimeBucket.MONTH)
            .timestamp(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant())
            .build();

    // Act
    Instant actualLatest = rbmBackedTimestampSet.getLatest();

    // Assert
    assertEquals(0L, actualLatest.getEpochSecond());
    Instant instant = Instant.EPOCH;
    RBMBackedTimestampSet shallowClone = rbmBackedTimestampSet.getShallowClone();
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
    assertSame(instant, rbmBackedTimestampSet.getEarliest());
    assertSame(instant, actualLatest);
  }

  /**
   * Test {@link RBMBackedTimestampSet#getLatest()}.
   *
   * <p>Method under test: {@link RBMBackedTimestampSet#getLatest()}
   */
  @Test
  @DisplayName("Test getLatest()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Instant RBMBackedTimestampSet.getLatest()"})
  void testGetLatest6() {
    // Arrange
    RBMBackedTimestampSet rbmBackedTimestampSet =
        new Builder()
            .timeBucket(TimeBucket.YEAR)
            .timestamp(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant())
            .build();

    // Act
    Instant actualLatest = rbmBackedTimestampSet.getLatest();

    // Assert
    assertEquals(0L, actualLatest.getEpochSecond());
    Instant instant = Instant.EPOCH;
    RBMBackedTimestampSet shallowClone = rbmBackedTimestampSet.getShallowClone();
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
    assertSame(instant, rbmBackedTimestampSet.getEarliest());
    assertSame(instant, actualLatest);
  }

  /**
   * Test {@link RBMBackedTimestampSet#getLatest()}.
   *
   * <ul>
   *   <li>Then {@link RBMBackedTimestampSet#RBMBackedTimestampSet(TimeBucket)} with timeBucket is
   *       {@code SECOND} Earliest is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link RBMBackedTimestampSet#getLatest()}
   */
  @Test
  @DisplayName(
      "Test getLatest(); then RBMBackedTimestampSet(TimeBucket) with timeBucket is 'SECOND' Earliest is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
   *
   * <ul>
   *   <li>Then return EpochSecond is {@code -259200}.
   * </ul>
   *
   * <p>Method under test: {@link RBMBackedTimestampSet#getLatest()}
   */
  @Test
  @DisplayName("Test getLatest(); then return EpochSecond is '-259200'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Instant RBMBackedTimestampSet.getLatest()"})
  void testGetLatest_thenReturnEpochSecondIs259200() {
    // Arrange and Act
    Instant actualLatest =
        new Builder()
            .timeBucket(TimeBucket.WEEK)
            .timestamp(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant())
            .build()
            .getLatest();

    // Assert
    assertEquals(-259200L, actualLatest.getEpochSecond());
    assertEquals(0, actualLatest.getNano());
  }

  /**
   * Test {@link RBMBackedTimestampSet#applyTimeRangeMask(Long, Long)}.
   *
   * <p>Method under test: {@link RBMBackedTimestampSet#applyTimeRangeMask(Long, Long)}
   */
  @Test
  @DisplayName("Test applyTimeRangeMask(Long, Long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void RBMBackedTimestampSet.applyTimeRangeMask(Long, Long)"})
  void testApplyTimeRangeMask() {
    // Arrange
    RBMBackedTimestampSet rbmBackedTimestampSet = new RBMBackedTimestampSet(TimeBucket.SECOND);

    // Act
    rbmBackedTimestampSet.applyTimeRangeMask(1L, 1L);

    // Assert that nothing has changed
    RBMBackedTimestampSet shallowClone = rbmBackedTimestampSet.getShallowClone();
    assertNull(shallowClone.getEarliest());
    assertNull(shallowClone.getLatest());
  }

  /**
   * Test {@link RBMBackedTimestampSet#applyTimeRangeMask(Long, Long)}.
   *
   * <p>Method under test: {@link RBMBackedTimestampSet#applyTimeRangeMask(Long, Long)}
   */
  @Test
  @DisplayName("Test applyTimeRangeMask(Long, Long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void RBMBackedTimestampSet.applyTimeRangeMask(Long, Long)"})
  void testApplyTimeRangeMask2() {
    // Arrange
    RBMBackedTimestampSet rbmBackedTimestampSet = new RBMBackedTimestampSet(TimeBucket.MINUTE);

    // Act
    rbmBackedTimestampSet.applyTimeRangeMask(1L, 1L);

    // Assert that nothing has changed
    RBMBackedTimestampSet shallowClone = rbmBackedTimestampSet.getShallowClone();
    assertNull(shallowClone.getEarliest());
    assertNull(shallowClone.getLatest());
  }

  /**
   * Test {@link RBMBackedTimestampSet#applyTimeRangeMask(Long, Long)}.
   *
   * <p>Method under test: {@link RBMBackedTimestampSet#applyTimeRangeMask(Long, Long)}
   */
  @Test
  @DisplayName("Test applyTimeRangeMask(Long, Long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void RBMBackedTimestampSet.applyTimeRangeMask(Long, Long)"})
  void testApplyTimeRangeMask3() {
    // Arrange
    RBMBackedTimestampSet rbmBackedTimestampSet = new RBMBackedTimestampSet(TimeBucket.HOUR);

    // Act
    rbmBackedTimestampSet.applyTimeRangeMask(1L, 1L);

    // Assert that nothing has changed
    RBMBackedTimestampSet shallowClone = rbmBackedTimestampSet.getShallowClone();
    assertNull(shallowClone.getEarliest());
    assertNull(shallowClone.getLatest());
  }

  /**
   * Test {@link RBMBackedTimestampSet#applyTimeRangeMask(Long, Long)}.
   *
   * <p>Method under test: {@link RBMBackedTimestampSet#applyTimeRangeMask(Long, Long)}
   */
  @Test
  @DisplayName("Test applyTimeRangeMask(Long, Long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void RBMBackedTimestampSet.applyTimeRangeMask(Long, Long)"})
  void testApplyTimeRangeMask4() {
    // Arrange
    RBMBackedTimestampSet rbmBackedTimestampSet = new RBMBackedTimestampSet(TimeBucket.DAY);

    // Act
    rbmBackedTimestampSet.applyTimeRangeMask(1L, 1L);

    // Assert that nothing has changed
    RBMBackedTimestampSet shallowClone = rbmBackedTimestampSet.getShallowClone();
    assertNull(shallowClone.getEarliest());
    assertNull(shallowClone.getLatest());
  }

  /**
   * Test {@link RBMBackedTimestampSet#applyTimeRangeMask(Long, Long)}.
   *
   * <p>Method under test: {@link RBMBackedTimestampSet#applyTimeRangeMask(Long, Long)}
   */
  @Test
  @DisplayName("Test applyTimeRangeMask(Long, Long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void RBMBackedTimestampSet.applyTimeRangeMask(Long, Long)"})
  void testApplyTimeRangeMask5() {
    // Arrange
    RBMBackedTimestampSet rbmBackedTimestampSet = new RBMBackedTimestampSet(TimeBucket.MONTH);

    // Act
    rbmBackedTimestampSet.applyTimeRangeMask(1L, 1L);

    // Assert that nothing has changed
    RBMBackedTimestampSet shallowClone = rbmBackedTimestampSet.getShallowClone();
    assertNull(shallowClone.getEarliest());
    assertNull(shallowClone.getLatest());
  }

  /**
   * Test {@link RBMBackedTimestampSet#applyTimeRangeMask(Long, Long)}.
   *
   * <p>Method under test: {@link RBMBackedTimestampSet#applyTimeRangeMask(Long, Long)}
   */
  @Test
  @DisplayName("Test applyTimeRangeMask(Long, Long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void RBMBackedTimestampSet.applyTimeRangeMask(Long, Long)"})
  void testApplyTimeRangeMask6() {
    // Arrange
    RBMBackedTimestampSet rbmBackedTimestampSet = new RBMBackedTimestampSet(TimeBucket.SECOND);
    rbmBackedTimestampSet.addAll(
        new Builder()
            .timeBucket(TimeBucket.WEEK)
            .timestamp(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant())
            .build());

    // Act
    rbmBackedTimestampSet.applyTimeRangeMask(1L, 1L);

    // Assert
    assertNull(rbmBackedTimestampSet.getEarliest());
    assertNull(rbmBackedTimestampSet.getLatest());
    RoaringBitmap rbm = rbmBackedTimestampSet.getRbm();
    assertEquals(0, rbm.getCardinality());
    assertEquals(0L, rbmBackedTimestampSet.getNumberOfTimestamps());
    assertEquals(8, rbm.getSizeInBytes());
    assertFalse(rbm.iterator().hasNext());
    assertTrue(rbmBackedTimestampSet.getTimestamps().isEmpty());
    assertTrue(rbm.isEmpty());
    RBMBackedTimestampSet actualShallowClone = rbmBackedTimestampSet.getShallowClone();
    assertEquals(rbmBackedTimestampSet, actualShallowClone);
  }

  /**
   * Test {@link RBMBackedTimestampSet#applyTimeRangeMask(Long, Long)}.
   *
   * <p>Method under test: {@link RBMBackedTimestampSet#applyTimeRangeMask(Long, Long)}
   */
  @Test
  @DisplayName("Test applyTimeRangeMask(Long, Long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void RBMBackedTimestampSet.applyTimeRangeMask(Long, Long)"})
  void testApplyTimeRangeMask7() {
    // Arrange
    RBMBackedTimestampSet rbmBackedTimestampSet = new RBMBackedTimestampSet(TimeBucket.SECOND);
    rbmBackedTimestampSet.addAll(
        new Builder()
            .timeBucket(TimeBucket.WEEK)
            .timestamp(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant())
            .build());

    // Act
    rbmBackedTimestampSet.applyTimeRangeMask(1L, CommonTimeUtil.MILLISECONDS_IN_DAY);

    // Assert
    assertNull(rbmBackedTimestampSet.getEarliest());
    assertNull(rbmBackedTimestampSet.getLatest());
    RoaringBitmap rbm = rbmBackedTimestampSet.getRbm();
    assertEquals(0, rbm.getCardinality());
    assertEquals(0L, rbmBackedTimestampSet.getNumberOfTimestamps());
    assertEquals(8, rbm.getSizeInBytes());
    assertFalse(rbm.iterator().hasNext());
    assertTrue(rbmBackedTimestampSet.getTimestamps().isEmpty());
    assertTrue(rbm.isEmpty());
    RBMBackedTimestampSet actualShallowClone = rbmBackedTimestampSet.getShallowClone();
    assertEquals(rbmBackedTimestampSet, actualShallowClone);
  }

  /**
   * Test {@link RBMBackedTimestampSet#applyTimeRangeMask(Long, Long)}.
   *
   * <p>Method under test: {@link RBMBackedTimestampSet#applyTimeRangeMask(Long, Long)}
   */
  @Test
  @DisplayName("Test applyTimeRangeMask(Long, Long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void RBMBackedTimestampSet.applyTimeRangeMask(Long, Long)"})
  void testApplyTimeRangeMask8() {
    // Arrange
    RBMBackedTimestampSet rbmBackedTimestampSet = new RBMBackedTimestampSet(TimeBucket.SECOND);
    rbmBackedTimestampSet.addAll(
        new Builder()
            .timeBucket(TimeBucket.WEEK)
            .timestamp(LocalDate.now().atStartOfDay().atZone(ZoneOffset.UTC).toInstant())
            .build());

    // Act
    rbmBackedTimestampSet.applyTimeRangeMask(1L, 1L);

    // Assert
    assertNull(rbmBackedTimestampSet.getEarliest());
    assertNull(rbmBackedTimestampSet.getLatest());
    RoaringBitmap rbm = rbmBackedTimestampSet.getRbm();
    assertEquals(0, rbm.getCardinality());
    assertEquals(0L, rbmBackedTimestampSet.getNumberOfTimestamps());
    assertEquals(8, rbm.getSizeInBytes());
    assertFalse(rbm.iterator().hasNext());
    assertTrue(rbmBackedTimestampSet.getTimestamps().isEmpty());
    assertTrue(rbm.isEmpty());
    RBMBackedTimestampSet actualShallowClone = rbmBackedTimestampSet.getShallowClone();
    assertEquals(rbmBackedTimestampSet, actualShallowClone);
  }

  /**
   * Test {@link RBMBackedTimestampSet#applyTimeRangeMask(Long, Long)}.
   *
   * <ul>
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link RBMBackedTimestampSet#applyTimeRangeMask(Long, Long)}
   */
  @Test
  @DisplayName("Test applyTimeRangeMask(Long, Long); then throw RuntimeException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void RBMBackedTimestampSet.applyTimeRangeMask(Long, Long)"})
  void testApplyTimeRangeMask_thenThrowRuntimeException() {
    // Arrange, Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> new RBMBackedTimestampSet(TimeBucket.WEEK).applyTimeRangeMask(1L, 1L));
  }

  /**
   * Test {@link RBMBackedTimestampSet#applyTimeRangeMask(Long, Long)}.
   *
   * <ul>
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link RBMBackedTimestampSet#applyTimeRangeMask(Long, Long)}
   */
  @Test
  @DisplayName("Test applyTimeRangeMask(Long, Long); then throw RuntimeException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void RBMBackedTimestampSet.applyTimeRangeMask(Long, Long)"})
  void testApplyTimeRangeMask_thenThrowRuntimeException2() {
    // Arrange, Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> new RBMBackedTimestampSet(TimeBucket.WEEK).applyTimeRangeMask(0L, 1L));
  }

  /**
   * Test {@link RBMBackedTimestampSet#applyTimeRangeMask(Long, Long)}.
   *
   * <ul>
   *   <li>When {@link Long#MAX_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link RBMBackedTimestampSet#applyTimeRangeMask(Long, Long)}
   */
  @Test
  @DisplayName("Test applyTimeRangeMask(Long, Long); when MAX_VALUE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void RBMBackedTimestampSet.applyTimeRangeMask(Long, Long)"})
  void testApplyTimeRangeMask_whenMax_value() {
    // Arrange
    RBMBackedTimestampSet rbmBackedTimestampSet = new RBMBackedTimestampSet(TimeBucket.MINUTE);

    // Act
    rbmBackedTimestampSet.applyTimeRangeMask(1L, Long.MAX_VALUE);

    // Assert that nothing has changed
    RBMBackedTimestampSet shallowClone = rbmBackedTimestampSet.getShallowClone();
    assertNull(shallowClone.getEarliest());
    assertNull(shallowClone.getLatest());
  }

  /**
   * Test {@link RBMBackedTimestampSet#applyTimeRangeMask(Long, Long)}.
   *
   * <ul>
   *   <li>When {@link CommonTimeUtil#MILLISECONDS_IN_DAY}.
   * </ul>
   *
   * <p>Method under test: {@link RBMBackedTimestampSet#applyTimeRangeMask(Long, Long)}
   */
  @Test
  @DisplayName("Test applyTimeRangeMask(Long, Long); when MILLISECONDS_IN_DAY")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void RBMBackedTimestampSet.applyTimeRangeMask(Long, Long)"})
  void testApplyTimeRangeMask_whenMilliseconds_in_day() {
    // Arrange
    RBMBackedTimestampSet rbmBackedTimestampSet = new RBMBackedTimestampSet(TimeBucket.SECOND);

    // Act
    rbmBackedTimestampSet.applyTimeRangeMask(1L, CommonTimeUtil.MILLISECONDS_IN_DAY);

    // Assert that nothing has changed
    RBMBackedTimestampSet shallowClone = rbmBackedTimestampSet.getShallowClone();
    assertNull(shallowClone.getEarliest());
    assertNull(shallowClone.getLatest());
  }

  /**
   * Test {@link RBMBackedTimestampSet#applyTimeRangeMask(Long, Long)}.
   *
   * <ul>
   *   <li>When two.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link RBMBackedTimestampSet#applyTimeRangeMask(Long, Long)}
   */
  @Test
  @DisplayName("Test applyTimeRangeMask(Long, Long); when two; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void RBMBackedTimestampSet.applyTimeRangeMask(Long, Long)"})
  void testApplyTimeRangeMask_whenTwo_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> new RBMBackedTimestampSet(TimeBucket.SECOND).applyTimeRangeMask(2L, 1L));
  }

  /**
   * Test {@link RBMBackedTimestampSet#applyTimeRangeMask(Long, Long)}.
   *
   * <ul>
   *   <li>When zero.
   * </ul>
   *
   * <p>Method under test: {@link RBMBackedTimestampSet#applyTimeRangeMask(Long, Long)}
   */
  @Test
  @DisplayName("Test applyTimeRangeMask(Long, Long); when zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void RBMBackedTimestampSet.applyTimeRangeMask(Long, Long)"})
  void testApplyTimeRangeMask_whenZero() {
    // Arrange
    RBMBackedTimestampSet rbmBackedTimestampSet = new RBMBackedTimestampSet(TimeBucket.SECOND);

    // Act
    rbmBackedTimestampSet.applyTimeRangeMask(0L, 1L);

    // Assert that nothing has changed
    RBMBackedTimestampSet shallowClone = rbmBackedTimestampSet.getShallowClone();
    assertNull(shallowClone.getEarliest());
    assertNull(shallowClone.getLatest());
  }

  /**
   * Test {@link RBMBackedTimestampSet#applyTimeRangeMask(Long, Long)}.
   *
   * <ul>
   *   <li>When zero.
   * </ul>
   *
   * <p>Method under test: {@link RBMBackedTimestampSet#applyTimeRangeMask(Long, Long)}
   */
  @Test
  @DisplayName("Test applyTimeRangeMask(Long, Long); when zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void RBMBackedTimestampSet.applyTimeRangeMask(Long, Long)"})
  void testApplyTimeRangeMask_whenZero2() {
    // Arrange
    RBMBackedTimestampSet rbmBackedTimestampSet = new RBMBackedTimestampSet(TimeBucket.SECOND);

    // Act
    rbmBackedTimestampSet.applyTimeRangeMask(0L, 0L);

    // Assert that nothing has changed
    RBMBackedTimestampSet shallowClone = rbmBackedTimestampSet.getShallowClone();
    assertNull(shallowClone.getEarliest());
    assertNull(shallowClone.getLatest());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link RBMBackedTimestampSet#setRbm(RoaringBitmap)}
   *   <li>{@link RBMBackedTimestampSet#toString()}
   *   <li>{@link RBMBackedTimestampSet#getRbm()}
   *   <li>{@link RBMBackedTimestampSet#getTimeBucket()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "RoaringBitmap RBMBackedTimestampSet.getRbm()",
    "TimeBucket RBMBackedTimestampSet.getTimeBucket()",
    "void RBMBackedTimestampSet.setRbm(RoaringBitmap)",
    "String RBMBackedTimestampSet.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    RBMBackedTimestampSet rbmBackedTimestampSet =
        new Builder()
            .timeBucket(TimeBucket.SECOND)
            .timestamp(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant())
            .build();
    RoaringBitmap rbm = new RoaringBitmap();

    // Act
    rbmBackedTimestampSet.setRbm(rbm);
    String actualToStringResult = rbmBackedTimestampSet.toString();
    RoaringBitmap actualRbm = rbmBackedTimestampSet.getRbm();

    // Assert
    assertEquals("RBMBackedTimestampSet[timeBucket=SECOND,timestamps=]", actualToStringResult);
    assertEquals(TimeBucket.SECOND, rbmBackedTimestampSet.getTimeBucket());
    assertSame(rbm, actualRbm);
  }

  /**
   * Test {@link RBMBackedTimestampSet#addAll(RBMBackedTimestampSet)}.
   *
   * <p>Method under test: {@link RBMBackedTimestampSet#addAll(RBMBackedTimestampSet)}
   */
  @Test
  @DisplayName("Test addAll(RBMBackedTimestampSet)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void RBMBackedTimestampSet.addAll(RBMBackedTimestampSet)"})
  void testAddAll() {
    // Arrange
    RBMBackedTimestampSet rbmBackedTimestampSet = new RBMBackedTimestampSet(TimeBucket.SECOND);
    RBMBackedTimestampSet other =
        new Builder()
            .timeBucket(TimeBucket.SECOND)
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
   * Test {@link RBMBackedTimestampSet#addAll(RBMBackedTimestampSet)}.
   *
   * <p>Method under test: {@link RBMBackedTimestampSet#addAll(RBMBackedTimestampSet)}
   */
  @Test
  @DisplayName("Test addAll(RBMBackedTimestampSet)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void RBMBackedTimestampSet.addAll(RBMBackedTimestampSet)"})
  void testAddAll2() {
    // Arrange
    RBMBackedTimestampSet rbmBackedTimestampSet = new RBMBackedTimestampSet(TimeBucket.SECOND);
    rbmBackedTimestampSet.addAll(
        new Builder()
            .timeBucket(TimeBucket.WEEK)
            .timestamp(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant())
            .build());

    // Act
    rbmBackedTimestampSet.addAll(
        new Builder()
            .timeBucket(TimeBucket.SECOND)
            .timestamp(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant())
            .build());

    // Assert
    assertEquals(2L, rbmBackedTimestampSet.getNumberOfTimestamps());
    RoaringBitmap rbm = rbmBackedTimestampSet.getRbm();
    assertEquals(2, rbm.getCardinality());
    assertEquals(24, rbm.getSizeInBytes());
    Iterator<Integer> iteratorResult = rbm.iterator();
    Integer nextResult = iteratorResult.next();
    Integer nextResult2 = iteratorResult.next();
    assertFalse(iteratorResult.hasNext());
    assertEquals(0, nextResult.intValue());
    assertEquals(-3, nextResult2.intValue());
    assertEquals(2, rbmBackedTimestampSet.getTimestamps().size());
  }

  /**
   * Test {@link RBMBackedTimestampSet#getShallowClone()}.
   *
   * <p>Method under test: {@link RBMBackedTimestampSet#getShallowClone()}
   */
  @Test
  @DisplayName("Test getShallowClone()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"RBMBackedTimestampSet RBMBackedTimestampSet.getShallowClone()"})
  void testGetShallowClone() {
    // Arrange
    RBMBackedTimestampSet rbmBackedTimestampSet =
        new Builder()
            .timeBucket(TimeBucket.SECOND)
            .timestamp(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant())
            .build();

    // Act
    RBMBackedTimestampSet actualShallowClone = rbmBackedTimestampSet.getShallowClone();

    // Assert
    assertEquals(rbmBackedTimestampSet, actualShallowClone);
  }

  /**
   * Test {@link RBMBackedTimestampSet#getShallowClone()}.
   *
   * <p>Method under test: {@link RBMBackedTimestampSet#getShallowClone()}
   */
  @Test
  @DisplayName("Test getShallowClone()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"RBMBackedTimestampSet RBMBackedTimestampSet.getShallowClone()"})
  void testGetShallowClone2() {
    // Arrange
    RBMBackedTimestampSet rbmBackedTimestampSet = new RBMBackedTimestampSet(TimeBucket.SECOND);
    rbmBackedTimestampSet.addAll(
        new Builder()
            .timeBucket(TimeBucket.WEEK)
            .timestamp(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant())
            .build());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> rbmBackedTimestampSet.getShallowClone());
  }

  /**
   * Test {@link RBMBackedTimestampSet#getShallowClone()}.
   *
   * <p>Method under test: {@link RBMBackedTimestampSet#getShallowClone()}
   */
  @Test
  @DisplayName("Test getShallowClone()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"RBMBackedTimestampSet RBMBackedTimestampSet.getShallowClone()"})
  void testGetShallowClone3() {
    // Arrange
    RBMBackedTimestampSet rbmBackedTimestampSet = new RBMBackedTimestampSet(TimeBucket.MINUTE);
    rbmBackedTimestampSet.addAll(
        new Builder()
            .timeBucket(TimeBucket.WEEK)
            .timestamp(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant())
            .build());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> rbmBackedTimestampSet.getShallowClone());
  }

  /**
   * Test {@link RBMBackedTimestampSet#getShallowClone()}.
   *
   * <p>Method under test: {@link RBMBackedTimestampSet#getShallowClone()}
   */
  @Test
  @DisplayName("Test getShallowClone()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"RBMBackedTimestampSet RBMBackedTimestampSet.getShallowClone()"})
  void testGetShallowClone4() {
    // Arrange
    RBMBackedTimestampSet rbmBackedTimestampSet = new RBMBackedTimestampSet(TimeBucket.HOUR);
    rbmBackedTimestampSet.addAll(
        new Builder()
            .timeBucket(TimeBucket.WEEK)
            .timestamp(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant())
            .build());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> rbmBackedTimestampSet.getShallowClone());
  }

  /**
   * Test {@link RBMBackedTimestampSet#getShallowClone()}.
   *
   * <p>Method under test: {@link RBMBackedTimestampSet#getShallowClone()}
   */
  @Test
  @DisplayName("Test getShallowClone()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"RBMBackedTimestampSet RBMBackedTimestampSet.getShallowClone()"})
  void testGetShallowClone5() {
    // Arrange
    RBMBackedTimestampSet rbmBackedTimestampSet = new RBMBackedTimestampSet(TimeBucket.DAY);
    rbmBackedTimestampSet.addAll(
        new Builder()
            .timeBucket(TimeBucket.WEEK)
            .timestamp(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant())
            .build());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> rbmBackedTimestampSet.getShallowClone());
  }

  /**
   * Test {@link RBMBackedTimestampSet#getShallowClone()}.
   *
   * <p>Method under test: {@link RBMBackedTimestampSet#getShallowClone()}
   */
  @Test
  @DisplayName("Test getShallowClone()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"RBMBackedTimestampSet RBMBackedTimestampSet.getShallowClone()"})
  void testGetShallowClone6() {
    // Arrange
    RBMBackedTimestampSet rbmBackedTimestampSet = new RBMBackedTimestampSet(TimeBucket.WEEK);
    rbmBackedTimestampSet.addAll(
        new Builder()
            .timeBucket(TimeBucket.WEEK)
            .timestamp(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant())
            .build());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> rbmBackedTimestampSet.getShallowClone());
  }

  /**
   * Test {@link RBMBackedTimestampSet#getShallowClone()}.
   *
   * <p>Method under test: {@link RBMBackedTimestampSet#getShallowClone()}
   */
  @Test
  @DisplayName("Test getShallowClone()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"RBMBackedTimestampSet RBMBackedTimestampSet.getShallowClone()"})
  void testGetShallowClone7() {
    // Arrange
    RBMBackedTimestampSet rbmBackedTimestampSet = new RBMBackedTimestampSet(TimeBucket.MONTH);
    rbmBackedTimestampSet.addAll(
        new Builder()
            .timeBucket(TimeBucket.WEEK)
            .timestamp(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant())
            .build());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> rbmBackedTimestampSet.getShallowClone());
  }

  /**
   * Test {@link RBMBackedTimestampSet#getShallowClone()}.
   *
   * <p>Method under test: {@link RBMBackedTimestampSet#getShallowClone()}
   */
  @Test
  @DisplayName("Test getShallowClone()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"RBMBackedTimestampSet RBMBackedTimestampSet.getShallowClone()"})
  void testGetShallowClone8() {
    // Arrange
    RBMBackedTimestampSet rbmBackedTimestampSet = new RBMBackedTimestampSet(TimeBucket.MINUTE);
    rbmBackedTimestampSet.addAll(
        new Builder()
            .timeBucket(TimeBucket.SECOND)
            .timestamp(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant())
            .build());

    // Act
    RBMBackedTimestampSet actualShallowClone = rbmBackedTimestampSet.getShallowClone();

    // Assert
    assertEquals(rbmBackedTimestampSet, actualShallowClone);
  }

  /**
   * Test {@link RBMBackedTimestampSet#getShallowClone()}.
   *
   * <p>Method under test: {@link RBMBackedTimestampSet#getShallowClone()}
   */
  @Test
  @DisplayName("Test getShallowClone()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"RBMBackedTimestampSet RBMBackedTimestampSet.getShallowClone()"})
  void testGetShallowClone9() {
    // Arrange
    RBMBackedTimestampSet rbmBackedTimestampSet =
        new Builder()
            .timeBucket(TimeBucket.SECOND)
            .timestamp(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant())
            .build();
    rbmBackedTimestampSet.addAll(
        new Builder()
            .timeBucket(TimeBucket.SECOND)
            .timestamp(LocalDate.now().atStartOfDay().atZone(ZoneOffset.UTC).toInstant())
            .build());

    // Act
    RBMBackedTimestampSet actualShallowClone = rbmBackedTimestampSet.getShallowClone();

    // Assert
    assertEquals(rbmBackedTimestampSet, actualShallowClone);
  }

  /**
   * Test {@link RBMBackedTimestampSet#getShallowClone()}.
   *
   * <p>Method under test: {@link RBMBackedTimestampSet#getShallowClone()}
   */
  @Test
  @DisplayName("Test getShallowClone()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"RBMBackedTimestampSet RBMBackedTimestampSet.getShallowClone()"})
  void testGetShallowClone10() {
    // Arrange
    RBMBackedTimestampSet rbmBackedTimestampSet =
        new Builder()
            .timeBucket(TimeBucket.SECOND)
            .timestamp(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant())
            .build();
    rbmBackedTimestampSet.addAll(
        new Builder()
            .timeBucket(TimeBucket.DAY)
            .timestamp(LocalDate.now().atStartOfDay().atZone(ZoneOffset.UTC).toInstant())
            .build());

    // Act
    RBMBackedTimestampSet actualShallowClone = rbmBackedTimestampSet.getShallowClone();

    // Assert
    assertEquals(rbmBackedTimestampSet, actualShallowClone);
  }

  /**
   * Test {@link RBMBackedTimestampSet#getShallowClone()}.
   *
   * <p>Method under test: {@link RBMBackedTimestampSet#getShallowClone()}
   */
  @Test
  @DisplayName("Test getShallowClone()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"RBMBackedTimestampSet RBMBackedTimestampSet.getShallowClone()"})
  void testGetShallowClone11() {
    // Arrange
    RBMBackedTimestampSet rbmBackedTimestampSet = new RBMBackedTimestampSet(TimeBucket.YEAR);
    rbmBackedTimestampSet.addAll(
        new Builder()
            .timeBucket(TimeBucket.WEEK)
            .timestamp(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant())
            .build());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> rbmBackedTimestampSet.getShallowClone());
  }

  /**
   * Test {@link RBMBackedTimestampSet#getShallowClone()}.
   *
   * <ul>
   *   <li>Then return Earliest EpochSecond is {@code -259200}.
   * </ul>
   *
   * <p>Method under test: {@link RBMBackedTimestampSet#getShallowClone()}
   */
  @Test
  @DisplayName("Test getShallowClone(); then return Earliest EpochSecond is '-259200'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"RBMBackedTimestampSet RBMBackedTimestampSet.getShallowClone()"})
  void testGetShallowClone_thenReturnEarliestEpochSecondIs259200() {
    // Arrange
    RBMBackedTimestampSet rbmBackedTimestampSet = new RBMBackedTimestampSet(TimeBucket.WEEK);
    rbmBackedTimestampSet.addAll(
        new Builder()
            .timeBucket(TimeBucket.SECOND)
            .timestamp(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant())
            .build());

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
   *
   * <ul>
   *   <li>Then return {@link RBMBackedTimestampSet#RBMBackedTimestampSet(TimeBucket)} with
   *       timeBucket is {@code DAY}.
   * </ul>
   *
   * <p>Method under test: {@link RBMBackedTimestampSet#getShallowClone()}
   */
  @Test
  @DisplayName(
      "Test getShallowClone(); then return RBMBackedTimestampSet(TimeBucket) with timeBucket is 'DAY'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"RBMBackedTimestampSet RBMBackedTimestampSet.getShallowClone()"})
  void testGetShallowClone_thenReturnRBMBackedTimestampSetWithTimeBucketIsDay() {
    // Arrange
    RBMBackedTimestampSet rbmBackedTimestampSet = new RBMBackedTimestampSet(TimeBucket.DAY);
    rbmBackedTimestampSet.addAll(
        new Builder()
            .timeBucket(TimeBucket.SECOND)
            .timestamp(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant())
            .build());

    // Act
    RBMBackedTimestampSet actualShallowClone = rbmBackedTimestampSet.getShallowClone();

    // Assert
    assertEquals(rbmBackedTimestampSet, actualShallowClone);
  }

  /**
   * Test {@link RBMBackedTimestampSet#getShallowClone()}.
   *
   * <ul>
   *   <li>Then return {@link RBMBackedTimestampSet#RBMBackedTimestampSet(TimeBucket)} with
   *       timeBucket is {@code HOUR}.
   * </ul>
   *
   * <p>Method under test: {@link RBMBackedTimestampSet#getShallowClone()}
   */
  @Test
  @DisplayName(
      "Test getShallowClone(); then return RBMBackedTimestampSet(TimeBucket) with timeBucket is 'HOUR'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"RBMBackedTimestampSet RBMBackedTimestampSet.getShallowClone()"})
  void testGetShallowClone_thenReturnRBMBackedTimestampSetWithTimeBucketIsHour() {
    // Arrange
    RBMBackedTimestampSet rbmBackedTimestampSet = new RBMBackedTimestampSet(TimeBucket.HOUR);
    rbmBackedTimestampSet.addAll(
        new Builder()
            .timeBucket(TimeBucket.SECOND)
            .timestamp(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant())
            .build());

    // Act
    RBMBackedTimestampSet actualShallowClone = rbmBackedTimestampSet.getShallowClone();

    // Assert
    assertEquals(rbmBackedTimestampSet, actualShallowClone);
  }

  /**
   * Test {@link RBMBackedTimestampSet#getShallowClone()}.
   *
   * <ul>
   *   <li>Then return {@link RBMBackedTimestampSet#RBMBackedTimestampSet(TimeBucket)} with
   *       timeBucket is {@code MONTH}.
   * </ul>
   *
   * <p>Method under test: {@link RBMBackedTimestampSet#getShallowClone()}
   */
  @Test
  @DisplayName(
      "Test getShallowClone(); then return RBMBackedTimestampSet(TimeBucket) with timeBucket is 'MONTH'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"RBMBackedTimestampSet RBMBackedTimestampSet.getShallowClone()"})
  void testGetShallowClone_thenReturnRBMBackedTimestampSetWithTimeBucketIsMonth() {
    // Arrange
    RBMBackedTimestampSet rbmBackedTimestampSet = new RBMBackedTimestampSet(TimeBucket.MONTH);
    rbmBackedTimestampSet.addAll(
        new Builder()
            .timeBucket(TimeBucket.SECOND)
            .timestamp(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant())
            .build());

    // Act
    RBMBackedTimestampSet actualShallowClone = rbmBackedTimestampSet.getShallowClone();

    // Assert
    assertEquals(rbmBackedTimestampSet, actualShallowClone);
  }

  /**
   * Test {@link RBMBackedTimestampSet#getShallowClone()}.
   *
   * <ul>
   *   <li>Then return {@link RBMBackedTimestampSet#RBMBackedTimestampSet(TimeBucket)} with
   *       timeBucket is {@code SECOND}.
   * </ul>
   *
   * <p>Method under test: {@link RBMBackedTimestampSet#getShallowClone()}
   */
  @Test
  @DisplayName(
      "Test getShallowClone(); then return RBMBackedTimestampSet(TimeBucket) with timeBucket is 'SECOND'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"RBMBackedTimestampSet RBMBackedTimestampSet.getShallowClone()"})
  void testGetShallowClone_thenReturnRBMBackedTimestampSetWithTimeBucketIsSecond() {
    // Arrange
    RBMBackedTimestampSet rbmBackedTimestampSet = new RBMBackedTimestampSet(TimeBucket.SECOND);

    // Act
    RBMBackedTimestampSet actualShallowClone = rbmBackedTimestampSet.getShallowClone();

    // Assert
    assertEquals(rbmBackedTimestampSet, actualShallowClone);
  }

  /**
   * Test {@link RBMBackedTimestampSet#getShallowClone()}.
   *
   * <ul>
   *   <li>Then return {@link RBMBackedTimestampSet#RBMBackedTimestampSet(TimeBucket)} with
   *       timeBucket is {@code YEAR}.
   * </ul>
   *
   * <p>Method under test: {@link RBMBackedTimestampSet#getShallowClone()}
   */
  @Test
  @DisplayName(
      "Test getShallowClone(); then return RBMBackedTimestampSet(TimeBucket) with timeBucket is 'YEAR'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"RBMBackedTimestampSet RBMBackedTimestampSet.getShallowClone()"})
  void testGetShallowClone_thenReturnRBMBackedTimestampSetWithTimeBucketIsYear() {
    // Arrange
    RBMBackedTimestampSet rbmBackedTimestampSet = new RBMBackedTimestampSet(TimeBucket.YEAR);
    rbmBackedTimestampSet.addAll(
        new Builder()
            .timeBucket(TimeBucket.SECOND)
            .timestamp(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant())
            .build());

    // Act
    RBMBackedTimestampSet actualShallowClone = rbmBackedTimestampSet.getShallowClone();

    // Assert
    assertEquals(rbmBackedTimestampSet, actualShallowClone);
  }

  /**
   * Test {@link RBMBackedTimestampSet#equals(Object)}, and {@link
   * RBMBackedTimestampSet#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link RBMBackedTimestampSet#equals(Object)}
   *   <li>{@link RBMBackedTimestampSet#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean RBMBackedTimestampSet.equals(Object)",
    "int RBMBackedTimestampSet.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    RBMBackedTimestampSet rbmBackedTimestampSet =
        new Builder()
            .timeBucket(TimeBucket.SECOND)
            .timestamp(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant())
            .build();
    RBMBackedTimestampSet rbmBackedTimestampSet2 =
        new Builder()
            .timeBucket(TimeBucket.SECOND)
            .timestamp(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant())
            .build();

    // Act and Assert
    assertEquals(rbmBackedTimestampSet, rbmBackedTimestampSet2);
    assertEquals(rbmBackedTimestampSet.hashCode(), rbmBackedTimestampSet2.hashCode());
  }

  /**
   * Test {@link RBMBackedTimestampSet#equals(Object)}, and {@link
   * RBMBackedTimestampSet#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link RBMBackedTimestampSet#equals(Object)}
   *   <li>{@link RBMBackedTimestampSet#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean RBMBackedTimestampSet.equals(Object)",
    "int RBMBackedTimestampSet.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    RBMBackedTimestampSet rbmBackedTimestampSet =
        new Builder()
            .timeBucket(TimeBucket.SECOND)
            .timestamp(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant())
            .build();

    // Act and Assert
    assertEquals(rbmBackedTimestampSet, rbmBackedTimestampSet);
    int expectedHashCodeResult = rbmBackedTimestampSet.hashCode();
    assertEquals(expectedHashCodeResult, rbmBackedTimestampSet.hashCode());
  }

  /**
   * Test {@link RBMBackedTimestampSet#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RBMBackedTimestampSet#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean RBMBackedTimestampSet.equals(Object)",
    "int RBMBackedTimestampSet.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    RBMBackedTimestampSet rbmBackedTimestampSet =
        new Builder()
            .timeBucket(TimeBucket.MINUTE)
            .timestamp(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant())
            .build();

    // Act and Assert
    assertNotEquals(
        rbmBackedTimestampSet,
        new Builder()
            .timeBucket(TimeBucket.SECOND)
            .timestamp(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant())
            .build());
  }

  /**
   * Test {@link RBMBackedTimestampSet#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RBMBackedTimestampSet#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean RBMBackedTimestampSet.equals(Object)",
    "int RBMBackedTimestampSet.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        new Builder()
            .timeBucket(TimeBucket.SECOND)
            .timestamp(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant())
            .build(),
        null);
  }

  /**
   * Test {@link RBMBackedTimestampSet#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RBMBackedTimestampSet#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean RBMBackedTimestampSet.equals(Object)",
    "int RBMBackedTimestampSet.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        new Builder()
            .timeBucket(TimeBucket.SECOND)
            .timestamp(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant())
            .build(),
        "Different type to RBMBackedTimestampSet");
  }

  /**
   * Test {@link RBMBackedTimestampSet#fromInt(TimeBucket, int)} with {@code timeBucket}, {@code i}.
   *
   * <ul>
   *   <li>When {@code DAY}.
   *   <li>Then return {@link CommonTimeUtil#MILLISECONDS_IN_DAY}.
   * </ul>
   *
   * <p>Method under test: {@link RBMBackedTimestampSet#fromInt(TimeBucket, int)}
   */
  @Test
  @DisplayName(
      "Test fromInt(TimeBucket, int) with 'timeBucket', 'i'; when 'DAY'; then return MILLISECONDS_IN_DAY")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long RBMBackedTimestampSet.fromInt(TimeBucket, int)"})
  void testFromIntWithTimeBucketI_whenDay_thenReturnMilliseconds_in_day() {
    // Arrange, Act and Assert
    assertEquals(
        CommonTimeUtil.MILLISECONDS_IN_DAY, RBMBackedTimestampSet.fromInt(TimeBucket.DAY, 1));
  }

  /**
   * Test {@link RBMBackedTimestampSet#fromInt(TimeBucket, int)} with {@code timeBucket}, {@code i}.
   *
   * <ul>
   *   <li>When {@code HOUR}.
   *   <li>Then return {@link CommonTimeUtil#MILLISECONDS_IN_HOUR}.
   * </ul>
   *
   * <p>Method under test: {@link RBMBackedTimestampSet#fromInt(TimeBucket, int)}
   */
  @Test
  @DisplayName(
      "Test fromInt(TimeBucket, int) with 'timeBucket', 'i'; when 'HOUR'; then return MILLISECONDS_IN_HOUR")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long RBMBackedTimestampSet.fromInt(TimeBucket, int)"})
  void testFromIntWithTimeBucketI_whenHour_thenReturnMilliseconds_in_hour() {
    // Arrange, Act and Assert
    assertEquals(
        CommonTimeUtil.MILLISECONDS_IN_HOUR, RBMBackedTimestampSet.fromInt(TimeBucket.HOUR, 1));
  }

  /**
   * Test {@link RBMBackedTimestampSet#fromInt(TimeBucket, int)} with {@code timeBucket}, {@code i}.
   *
   * <ul>
   *   <li>When {@code MILLISECOND}.
   *   <li>Then throw {@link IllegalStateException}.
   * </ul>
   *
   * <p>Method under test: {@link RBMBackedTimestampSet#fromInt(TimeBucket, int)}
   */
  @Test
  @DisplayName(
      "Test fromInt(TimeBucket, int) with 'timeBucket', 'i'; when 'MILLISECOND'; then throw IllegalStateException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long RBMBackedTimestampSet.fromInt(TimeBucket, int)"})
  void testFromIntWithTimeBucketI_whenMillisecond_thenThrowIllegalStateException() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalStateException.class,
        () -> RBMBackedTimestampSet.fromInt(TimeBucket.MILLISECOND, 1));
  }

  /**
   * Test {@link RBMBackedTimestampSet#fromInt(TimeBucket, int)} with {@code timeBucket}, {@code i}.
   *
   * <ul>
   *   <li>When {@code MINUTE}.
   *   <li>Then return {@link CommonTimeUtil#MILLISECONDS_IN_MINUTE}.
   * </ul>
   *
   * <p>Method under test: {@link RBMBackedTimestampSet#fromInt(TimeBucket, int)}
   */
  @Test
  @DisplayName(
      "Test fromInt(TimeBucket, int) with 'timeBucket', 'i'; when 'MINUTE'; then return MILLISECONDS_IN_MINUTE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long RBMBackedTimestampSet.fromInt(TimeBucket, int)"})
  void testFromIntWithTimeBucketI_whenMinute_thenReturnMilliseconds_in_minute() {
    // Arrange, Act and Assert
    assertEquals(
        CommonTimeUtil.MILLISECONDS_IN_MINUTE, RBMBackedTimestampSet.fromInt(TimeBucket.MINUTE, 1));
  }

  /**
   * Test {@link RBMBackedTimestampSet#fromInt(TimeBucket, int)} with {@code timeBucket}, {@code i}.
   *
   * <ul>
   *   <li>When {@code MONTH}.
   *   <li>Then return {@link CommonTimeUtil#MILLISECONDS_IN_DAY}.
   * </ul>
   *
   * <p>Method under test: {@link RBMBackedTimestampSet#fromInt(TimeBucket, int)}
   */
  @Test
  @DisplayName(
      "Test fromInt(TimeBucket, int) with 'timeBucket', 'i'; when 'MONTH'; then return MILLISECONDS_IN_DAY")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long RBMBackedTimestampSet.fromInt(TimeBucket, int)"})
  void testFromIntWithTimeBucketI_whenMonth_thenReturnMilliseconds_in_day() {
    // Arrange, Act and Assert
    assertEquals(
        CommonTimeUtil.MILLISECONDS_IN_DAY, RBMBackedTimestampSet.fromInt(TimeBucket.MONTH, 1));
  }

  /**
   * Test {@link RBMBackedTimestampSet#fromInt(TimeBucket, int)} with {@code timeBucket}, {@code i}.
   *
   * <ul>
   *   <li>When {@code SECOND}.
   *   <li>Then return {@link CommonTimeUtil#MILLISECONDS_IN_SECOND}.
   * </ul>
   *
   * <p>Method under test: {@link RBMBackedTimestampSet#fromInt(TimeBucket, int)}
   */
  @Test
  @DisplayName(
      "Test fromInt(TimeBucket, int) with 'timeBucket', 'i'; when 'SECOND'; then return MILLISECONDS_IN_SECOND")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long RBMBackedTimestampSet.fromInt(TimeBucket, int)"})
  void testFromIntWithTimeBucketI_whenSecond_thenReturnMilliseconds_in_second() {
    // Arrange, Act and Assert
    assertEquals(
        CommonTimeUtil.MILLISECONDS_IN_SECOND, RBMBackedTimestampSet.fromInt(TimeBucket.SECOND, 1));
  }

  /**
   * Test {@link RBMBackedTimestampSet#fromInt(TimeBucket, int)} with {@code timeBucket}, {@code i}.
   *
   * <ul>
   *   <li>When {@code WEEK}.
   *   <li>Then return {@link CommonTimeUtil#MILLISECONDS_IN_DAY}.
   * </ul>
   *
   * <p>Method under test: {@link RBMBackedTimestampSet#fromInt(TimeBucket, int)}
   */
  @Test
  @DisplayName(
      "Test fromInt(TimeBucket, int) with 'timeBucket', 'i'; when 'WEEK'; then return MILLISECONDS_IN_DAY")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long RBMBackedTimestampSet.fromInt(TimeBucket, int)"})
  void testFromIntWithTimeBucketI_whenWeek_thenReturnMilliseconds_in_day() {
    // Arrange, Act and Assert
    assertEquals(
        CommonTimeUtil.MILLISECONDS_IN_DAY, RBMBackedTimestampSet.fromInt(TimeBucket.WEEK, 1));
  }

  /**
   * Test {@link RBMBackedTimestampSet#fromInt(TimeBucket, int)} with {@code timeBucket}, {@code i}.
   *
   * <ul>
   *   <li>When {@code YEAR}.
   *   <li>Then return {@link CommonTimeUtil#MILLISECONDS_IN_DAY}.
   * </ul>
   *
   * <p>Method under test: {@link RBMBackedTimestampSet#fromInt(TimeBucket, int)}
   */
  @Test
  @DisplayName(
      "Test fromInt(TimeBucket, int) with 'timeBucket', 'i'; when 'YEAR'; then return MILLISECONDS_IN_DAY")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long RBMBackedTimestampSet.fromInt(TimeBucket, int)"})
  void testFromIntWithTimeBucketI_whenYear_thenReturnMilliseconds_in_day() {
    // Arrange, Act and Assert
    assertEquals(
        CommonTimeUtil.MILLISECONDS_IN_DAY, RBMBackedTimestampSet.fromInt(TimeBucket.YEAR, 1));
  }
}
