/*
 * Copyright 2026 Crown Copyright
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

package uk.gov.gchq.gaffer.time.function;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.time.Instant;
import java.util.Iterator;
import java.util.SortedSet;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.time.BoundedTimestampSet;
import uk.gov.gchq.gaffer.time.CommonTimeUtil;
import uk.gov.gchq.gaffer.time.CommonTimeUtil.TimeBucket;
import uk.gov.gchq.gaffer.time.RBMBackedTimestampSet;
import uk.gov.gchq.gaffer.time.TimestampSet;

class ToTimestampSetDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ToTimestampSet#ToTimestampSet()}
   *   <li>{@link ToTimestampSet#setBucket(TimeBucket)}
   *   <li>{@link ToTimestampSet#setMaxSize(Integer)}
   *   <li>{@link ToTimestampSet#setMillisCorrection(long)}
   *   <li>{@link ToTimestampSet#getBucket()}
   *   <li>{@link ToTimestampSet#getMaxSize()}
   *   <li>{@link ToTimestampSet#getMillisCorrection()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ToTimestampSet.<init>()",
    "void ToTimestampSet.<init>(TimeBucket, Integer)",
    "TimeBucket ToTimestampSet.getBucket()",
    "Integer ToTimestampSet.getMaxSize()",
    "long ToTimestampSet.getMillisCorrection()",
    "void ToTimestampSet.setBucket(TimeBucket)",
    "void ToTimestampSet.setMaxSize(Integer)",
    "void ToTimestampSet.setMillisCorrection(long)"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    ToTimestampSet actualToTimestampSet = new ToTimestampSet();
    actualToTimestampSet.setBucket(TimeBucket.SECOND);
    actualToTimestampSet.setMaxSize(3);
    actualToTimestampSet.setMillisCorrection(1L);
    TimeBucket actualBucket = actualToTimestampSet.getBucket();
    Integer actualMaxSize = actualToTimestampSet.getMaxSize();

    // Assert
    assertEquals(1L, actualToTimestampSet.getMillisCorrection());
    assertEquals(3, actualMaxSize.intValue());
    assertEquals(TimeBucket.SECOND, actualBucket);
  }

  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>When {@code SECOND}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ToTimestampSet#ToTimestampSet(TimeBucket, Integer)}
   *   <li>{@link ToTimestampSet#setBucket(TimeBucket)}
   *   <li>{@link ToTimestampSet#setMaxSize(Integer)}
   *   <li>{@link ToTimestampSet#setMillisCorrection(long)}
   *   <li>{@link ToTimestampSet#getBucket()}
   *   <li>{@link ToTimestampSet#getMaxSize()}
   *   <li>{@link ToTimestampSet#getMillisCorrection()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; when 'SECOND'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ToTimestampSet.<init>()",
    "void ToTimestampSet.<init>(TimeBucket, Integer)",
    "TimeBucket ToTimestampSet.getBucket()",
    "Integer ToTimestampSet.getMaxSize()",
    "long ToTimestampSet.getMillisCorrection()",
    "void ToTimestampSet.setBucket(TimeBucket)",
    "void ToTimestampSet.setMaxSize(Integer)",
    "void ToTimestampSet.setMillisCorrection(long)"
  })
  void testGettersAndSetters_whenSecond() {
    // Arrange and Act
    ToTimestampSet actualToTimestampSet = new ToTimestampSet(TimeBucket.SECOND, 3);
    actualToTimestampSet.setBucket(TimeBucket.SECOND);
    actualToTimestampSet.setMaxSize(3);
    actualToTimestampSet.setMillisCorrection(1L);
    TimeBucket actualBucket = actualToTimestampSet.getBucket();
    Integer actualMaxSize = actualToTimestampSet.getMaxSize();

    // Assert
    assertEquals(1L, actualToTimestampSet.getMillisCorrection());
    assertEquals(3, actualMaxSize.intValue());
    assertEquals(TimeBucket.SECOND, actualBucket);
  }

  /**
   * Test {@link ToTimestampSet#ToTimestampSet(TimeBucket, boolean)}.
   *
   * <ul>
   *   <li>When {@code false}.
   *   <li>Then return MillisCorrection is one.
   * </ul>
   *
   * <p>Method under test: {@link ToTimestampSet#ToTimestampSet(TimeBucket, boolean)}
   */
  @Test
  @DisplayName(
      "Test new ToTimestampSet(TimeBucket, boolean); when 'false'; then return MillisCorrection is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ToTimestampSet.<init>(TimeBucket, boolean)"})
  void testNewToTimestampSet_whenFalse_thenReturnMillisCorrectionIsOne() {
    // Arrange and Act
    ToTimestampSet actualToTimestampSet = new ToTimestampSet(TimeBucket.SECOND, false);

    // Assert
    assertNull(actualToTimestampSet.getMaxSize());
    assertEquals(1L, actualToTimestampSet.getMillisCorrection());
    assertEquals(TimeBucket.SECOND, actualToTimestampSet.getBucket());
  }

  /**
   * Test {@link ToTimestampSet#ToTimestampSet(TimeBucket, boolean)}.
   *
   * <ul>
   *   <li>When {@code true}.
   *   <li>Then return MillisCorrection is one thousand.
   * </ul>
   *
   * <p>Method under test: {@link ToTimestampSet#ToTimestampSet(TimeBucket, boolean)}
   */
  @Test
  @DisplayName(
      "Test new ToTimestampSet(TimeBucket, boolean); when 'true'; then return MillisCorrection is one thousand")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ToTimestampSet.<init>(TimeBucket, boolean)"})
  void testNewToTimestampSet_whenTrue_thenReturnMillisCorrectionIsOneThousand() {
    // Arrange and Act
    ToTimestampSet actualToTimestampSet = new ToTimestampSet(TimeBucket.SECOND, true);

    // Assert
    assertNull(actualToTimestampSet.getMaxSize());
    assertEquals(1000L, actualToTimestampSet.getMillisCorrection());
    assertEquals(TimeBucket.SECOND, actualToTimestampSet.getBucket());
  }

  /**
   * Test {@link ToTimestampSet#apply(Long)} with {@code Long}.
   *
   * <ul>
   *   <li>Then return Earliest EpochSecond is {@code -259200}.
   * </ul>
   *
   * <p>Method under test: {@link ToTimestampSet#apply(Long)}
   */
  @Test
  @DisplayName("Test apply(Long) with 'Long'; then return Earliest EpochSecond is '-259200'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TimestampSet ToTimestampSet.apply(Long)"})
  void testApplyWithLong_thenReturnEarliestEpochSecondIs259200() {
    // Arrange and Act
    TimestampSet actualApplyResult = new ToTimestampSet(TimeBucket.WEEK, true).apply(10L);

    // Assert
    assertTrue(actualApplyResult instanceof RBMBackedTimestampSet);
    Instant earliest = actualApplyResult.getEarliest();
    assertEquals(-259200L, earliest.getEpochSecond());
    Iterator<Integer> iteratorResult =
        ((RBMBackedTimestampSet) actualApplyResult).getRbm().iterator();
    assertEquals(-3, iteratorResult.next().intValue());
    assertEquals(TimeBucket.WEEK, ((RBMBackedTimestampSet) actualApplyResult).getTimeBucket());
    assertFalse(iteratorResult.hasNext());
    assertEquals(earliest, actualApplyResult.getLatest());
  }

  /**
   * Test {@link ToTimestampSet#apply(Long)} with {@code Long}.
   *
   * <ul>
   *   <li>Then return Earliest Nano is zero.
   * </ul>
   *
   * <p>Method under test: {@link ToTimestampSet#apply(Long)}
   */
  @Test
  @DisplayName("Test apply(Long) with 'Long'; then return Earliest Nano is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TimestampSet ToTimestampSet.apply(Long)"})
  void testApplyWithLong_thenReturnEarliestNanoIsZero() {
    // Arrange
    ToTimestampSet toTimestampSet = new ToTimestampSet(TimeBucket.SECOND, true);
    toTimestampSet.setMaxSize(1);

    // Act
    TimestampSet actualApplyResult = toTimestampSet.apply(10L);

    // Assert
    assertTrue(actualApplyResult instanceof BoundedTimestampSet);
    Instant earliest = actualApplyResult.getEarliest();
    assertEquals(0, earliest.getNano());
    SortedSet<Instant> timestamps = actualApplyResult.getTimestamps();
    assertEquals(1, timestamps.size());
    assertEquals(10L, earliest.getEpochSecond());
    RBMBackedTimestampSet rbmBackedTimestampSet =
        ((BoundedTimestampSet) actualApplyResult).getRbmBackedTimestampSet();
    assertEquals(1L, rbmBackedTimestampSet.getNumberOfTimestamps());
    assertEquals(1L, actualApplyResult.getNumberOfTimestamps());
    RBMBackedTimestampSet actualShallowClone = rbmBackedTimestampSet.getShallowClone();
    assertEquals(rbmBackedTimestampSet, actualShallowClone);
    assertEquals(earliest, rbmBackedTimestampSet.getEarliest());
    assertEquals(earliest, rbmBackedTimestampSet.getLatest());
    assertEquals(earliest, actualApplyResult.getLatest());
    assertEquals(timestamps, rbmBackedTimestampSet.getTimestamps());
  }

  /**
   * Test {@link ToTimestampSet#apply(Long)} with {@code Long}.
   *
   * <ul>
   *   <li>Then return Rbm iterator next intValue is ten.
   * </ul>
   *
   * <p>Method under test: {@link ToTimestampSet#apply(Long)}
   */
  @Test
  @DisplayName("Test apply(Long) with 'Long'; then return Rbm iterator next intValue is ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TimestampSet ToTimestampSet.apply(Long)"})
  void testApplyWithLong_thenReturnRbmIteratorNextIntValueIsTen() {
    // Arrange and Act
    TimestampSet actualApplyResult = new ToTimestampSet(TimeBucket.SECOND, true).apply(10L);

    // Assert
    assertTrue(actualApplyResult instanceof RBMBackedTimestampSet);
    Iterator<Integer> iteratorResult =
        ((RBMBackedTimestampSet) actualApplyResult).getRbm().iterator();
    assertEquals(10, iteratorResult.next().intValue());
    Instant earliest = actualApplyResult.getEarliest();
    assertEquals(10L, earliest.getEpochSecond());
    assertEquals(TimeBucket.SECOND, ((RBMBackedTimestampSet) actualApplyResult).getTimeBucket());
    assertFalse(iteratorResult.hasNext());
    assertEquals(earliest, actualApplyResult.getLatest());
    assertEquals(actualApplyResult, ((RBMBackedTimestampSet) actualApplyResult).getShallowClone());
  }

  /**
   * Test {@link ToTimestampSet#apply(Long)} with {@code Long}.
   *
   * <ul>
   *   <li>Then return TimeBucket is {@code DAY}.
   * </ul>
   *
   * <p>Method under test: {@link ToTimestampSet#apply(Long)}
   */
  @Test
  @DisplayName("Test apply(Long) with 'Long'; then return TimeBucket is 'DAY'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TimestampSet ToTimestampSet.apply(Long)"})
  void testApplyWithLong_thenReturnTimeBucketIsDay() {
    // Arrange and Act
    TimestampSet actualApplyResult = new ToTimestampSet(TimeBucket.DAY, true).apply(10L);

    // Assert
    assertTrue(actualApplyResult instanceof RBMBackedTimestampSet);
    assertEquals(TimeBucket.DAY, ((RBMBackedTimestampSet) actualApplyResult).getTimeBucket());
    assertEquals(actualApplyResult, ((RBMBackedTimestampSet) actualApplyResult).getShallowClone());
  }

  /**
   * Test {@link ToTimestampSet#apply(Long)} with {@code Long}.
   *
   * <ul>
   *   <li>Then return TimeBucket is {@code HOUR}.
   * </ul>
   *
   * <p>Method under test: {@link ToTimestampSet#apply(Long)}
   */
  @Test
  @DisplayName("Test apply(Long) with 'Long'; then return TimeBucket is 'HOUR'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TimestampSet ToTimestampSet.apply(Long)"})
  void testApplyWithLong_thenReturnTimeBucketIsHour() {
    // Arrange and Act
    TimestampSet actualApplyResult = new ToTimestampSet(TimeBucket.HOUR, true).apply(10L);

    // Assert
    assertTrue(actualApplyResult instanceof RBMBackedTimestampSet);
    assertEquals(TimeBucket.HOUR, ((RBMBackedTimestampSet) actualApplyResult).getTimeBucket());
    assertEquals(actualApplyResult, ((RBMBackedTimestampSet) actualApplyResult).getShallowClone());
  }

  /**
   * Test {@link ToTimestampSet#apply(Long)} with {@code Long}.
   *
   * <ul>
   *   <li>Then return TimeBucket is {@code MINUTE}.
   * </ul>
   *
   * <p>Method under test: {@link ToTimestampSet#apply(Long)}
   */
  @Test
  @DisplayName("Test apply(Long) with 'Long'; then return TimeBucket is 'MINUTE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TimestampSet ToTimestampSet.apply(Long)"})
  void testApplyWithLong_thenReturnTimeBucketIsMinute() {
    // Arrange and Act
    TimestampSet actualApplyResult = new ToTimestampSet(TimeBucket.MINUTE, true).apply(10L);

    // Assert
    assertTrue(actualApplyResult instanceof RBMBackedTimestampSet);
    assertEquals(TimeBucket.MINUTE, ((RBMBackedTimestampSet) actualApplyResult).getTimeBucket());
    assertEquals(actualApplyResult, ((RBMBackedTimestampSet) actualApplyResult).getShallowClone());
  }

  /**
   * Test {@link ToTimestampSet#apply(Long)} with {@code Long}.
   *
   * <ul>
   *   <li>Then return TimeBucket is {@code MONTH}.
   * </ul>
   *
   * <p>Method under test: {@link ToTimestampSet#apply(Long)}
   */
  @Test
  @DisplayName("Test apply(Long) with 'Long'; then return TimeBucket is 'MONTH'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TimestampSet ToTimestampSet.apply(Long)"})
  void testApplyWithLong_thenReturnTimeBucketIsMonth() {
    // Arrange and Act
    TimestampSet actualApplyResult = new ToTimestampSet(TimeBucket.MONTH, true).apply(10L);

    // Assert
    assertTrue(actualApplyResult instanceof RBMBackedTimestampSet);
    assertEquals(TimeBucket.MONTH, ((RBMBackedTimestampSet) actualApplyResult).getTimeBucket());
    assertEquals(actualApplyResult, ((RBMBackedTimestampSet) actualApplyResult).getShallowClone());
  }

  /**
   * Test {@link ToTimestampSet#apply(Long)} with {@code Long}.
   *
   * <ul>
   *   <li>Then return TimeBucket is {@code YEAR}.
   * </ul>
   *
   * <p>Method under test: {@link ToTimestampSet#apply(Long)}
   */
  @Test
  @DisplayName("Test apply(Long) with 'Long'; then return TimeBucket is 'YEAR'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TimestampSet ToTimestampSet.apply(Long)"})
  void testApplyWithLong_thenReturnTimeBucketIsYear() {
    // Arrange and Act
    TimestampSet actualApplyResult = new ToTimestampSet(TimeBucket.YEAR, true).apply(10L);

    // Assert
    assertTrue(actualApplyResult instanceof RBMBackedTimestampSet);
    assertEquals(TimeBucket.YEAR, ((RBMBackedTimestampSet) actualApplyResult).getTimeBucket());
    assertEquals(actualApplyResult, ((RBMBackedTimestampSet) actualApplyResult).getShallowClone());
  }

  /**
   * Test {@link ToTimestampSet#apply(Long)} with {@code Long}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return RbmBackedTimestampSet Earliest is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ToTimestampSet#apply(Long)}
   */
  @Test
  @DisplayName(
      "Test apply(Long) with 'Long'; when 'null'; then return RbmBackedTimestampSet Earliest is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TimestampSet ToTimestampSet.apply(Long)"})
  void testApplyWithLong_whenNull_thenReturnRbmBackedTimestampSetEarliestIsNull() {
    // Arrange
    ToTimestampSet toTimestampSet = new ToTimestampSet(TimeBucket.SECOND, true);
    toTimestampSet.setMaxSize(1);

    // Act
    TimestampSet actualApplyResult = toTimestampSet.apply(null);

    // Assert
    assertTrue(actualApplyResult instanceof BoundedTimestampSet);
    RBMBackedTimestampSet rbmBackedTimestampSet =
        ((BoundedTimestampSet) actualApplyResult).getRbmBackedTimestampSet();
    assertNull(rbmBackedTimestampSet.getEarliest());
    assertNull(rbmBackedTimestampSet.getLatest());
    assertNull(actualApplyResult.getEarliest());
    assertNull(actualApplyResult.getLatest());
    assertEquals(0L, rbmBackedTimestampSet.getNumberOfTimestamps());
    assertEquals(0L, actualApplyResult.getNumberOfTimestamps());
    SortedSet<Instant> timestamps = actualApplyResult.getTimestamps();
    assertTrue(timestamps.isEmpty());
    RBMBackedTimestampSet actualShallowClone = rbmBackedTimestampSet.getShallowClone();
    assertEquals(rbmBackedTimestampSet, actualShallowClone);
    assertEquals(timestamps, rbmBackedTimestampSet.getTimestamps());
  }
}
