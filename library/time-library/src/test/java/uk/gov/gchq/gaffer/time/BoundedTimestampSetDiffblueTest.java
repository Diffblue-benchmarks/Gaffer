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
import java.util.SortedSet;
import org.apache.datasketches.sampling.ReservoirLongsUnion;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.roaringbitmap.RoaringBitmap;
import uk.gov.gchq.gaffer.time.BoundedTimestampSet.Builder;
import uk.gov.gchq.gaffer.time.BoundedTimestampSet.State;
import uk.gov.gchq.gaffer.time.CommonTimeUtil.TimeBucket;

class BoundedTimestampSetDiffblueTest {
  /**
   * Test Builder {@link Builder#build()}.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Builder#build()}
   *   <li>default or parameterless constructor of {@link Builder}
   *   <li>{@link Builder#maxSize(int)}
   *   <li>{@link Builder#state(State)}
   *   <li>{@link Builder#timeBucket(TimeBucket)}
   * </ul>
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void Builder.<init>()",
    "BoundedTimestampSet Builder.build()",
    "Builder Builder.maxSize(int)",
    "Builder Builder.state(State)",
    "Builder Builder.timeBucket(TimeBucket)",
    "void Builder.timestamps(Collection)"
  })
  void testBuilderBuild() {
    // Arrange and Act
    BoundedTimestampSet actualBoundedTimestampSet =
        new Builder().maxSize(3).state(State.NOT_FULL).timeBucket(TimeBucket.SECOND).build();

    // Assert
    assertNull(actualBoundedTimestampSet.getEarliest());
    assertNull(actualBoundedTimestampSet.getLatest());
    RBMBackedTimestampSet rbmBackedTimestampSet =
        actualBoundedTimestampSet.getRbmBackedTimestampSet();
    assertNull(rbmBackedTimestampSet.getEarliest());
    assertNull(rbmBackedTimestampSet.getLatest());
    RoaringBitmap rbm = rbmBackedTimestampSet.getRbm();
    assertEquals(0, rbm.getCardinality());
    assertEquals(0L, actualBoundedTimestampSet.getNumberOfTimestamps());
    assertEquals(0L, rbmBackedTimestampSet.getNumberOfTimestamps());
    assertEquals(3, actualBoundedTimestampSet.getMaxSize());
    assertEquals(8, rbm.getSizeInBytes());
    assertEquals(State.NOT_FULL, actualBoundedTimestampSet.getState());
    assertEquals(TimeBucket.SECOND, actualBoundedTimestampSet.getTimeBucket());
    assertEquals(TimeBucket.SECOND, rbmBackedTimestampSet.getTimeBucket());
    assertFalse(rbm.iterator().hasNext());
    assertFalse(rbm.hasRunCompression());
    assertTrue(rbm.isEmpty());
  }

  /**
   * Test {@link BoundedTimestampSet#BoundedTimestampSet(TimeBucket, int)}.
   *
   * <ul>
   *   <li>When {@code SECOND}.
   *   <li>Then return Earliest is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link BoundedTimestampSet#BoundedTimestampSet(TimeBucket, int)}
   */
  @Test
  @DisplayName(
      "Test new BoundedTimestampSet(TimeBucket, int); when 'SECOND'; then return Earliest is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BoundedTimestampSet.<init>(TimeBucket, int)"})
  void testNewBoundedTimestampSet_whenSecond_thenReturnEarliestIsNull() {
    // Arrange and Act
    BoundedTimestampSet actualBoundedTimestampSet = new BoundedTimestampSet(TimeBucket.SECOND, 3);

    // Assert
    assertNull(actualBoundedTimestampSet.getEarliest());
    assertNull(actualBoundedTimestampSet.getLatest());
    RBMBackedTimestampSet rbmBackedTimestampSet =
        actualBoundedTimestampSet.getRbmBackedTimestampSet();
    assertNull(rbmBackedTimestampSet.getEarliest());
    assertNull(rbmBackedTimestampSet.getLatest());
    assertEquals(0L, actualBoundedTimestampSet.getNumberOfTimestamps());
    assertEquals(0L, rbmBackedTimestampSet.getNumberOfTimestamps());
    assertEquals(3, actualBoundedTimestampSet.getMaxSize());
    assertEquals(State.NOT_FULL, actualBoundedTimestampSet.getState());
    assertEquals(TimeBucket.SECOND, actualBoundedTimestampSet.getTimeBucket());
    assertEquals(TimeBucket.SECOND, rbmBackedTimestampSet.getTimeBucket());
    SortedSet<Instant> timestamps = actualBoundedTimestampSet.getTimestamps();
    assertTrue(timestamps.isEmpty());
    RBMBackedTimestampSet actualShallowClone = rbmBackedTimestampSet.getShallowClone();
    assertEquals(rbmBackedTimestampSet, actualShallowClone);
    assertEquals(timestamps, rbmBackedTimestampSet.getTimestamps());
  }

  /**
   * Test {@link BoundedTimestampSet#BoundedTimestampSet(TimeBucket, int)}.
   *
   * <ul>
   *   <li>When {@code SECOND}.
   *   <li>Then return Earliest is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link BoundedTimestampSet#BoundedTimestampSet(TimeBucket, int)}
   */
  @Test
  @DisplayName(
      "Test new BoundedTimestampSet(TimeBucket, int); when 'SECOND'; then return Earliest is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BoundedTimestampSet.<init>(TimeBucket, int)"})
  void testNewBoundedTimestampSet_whenSecond_thenReturnEarliestIsNull2() {
    // Arrange and Act
    BoundedTimestampSet actualBoundedTimestampSet = new BoundedTimestampSet(TimeBucket.SECOND, 3);

    // Assert
    assertNull(actualBoundedTimestampSet.getEarliest());
    assertNull(actualBoundedTimestampSet.getLatest());
    RBMBackedTimestampSet rbmBackedTimestampSet =
        actualBoundedTimestampSet.getRbmBackedTimestampSet();
    assertNull(rbmBackedTimestampSet.getEarliest());
    assertNull(rbmBackedTimestampSet.getLatest());
    assertEquals(0L, actualBoundedTimestampSet.getNumberOfTimestamps());
    assertEquals(0L, rbmBackedTimestampSet.getNumberOfTimestamps());
    assertEquals(3, actualBoundedTimestampSet.getMaxSize());
    assertEquals(State.NOT_FULL, actualBoundedTimestampSet.getState());
    assertEquals(TimeBucket.SECOND, actualBoundedTimestampSet.getTimeBucket());
    assertEquals(TimeBucket.SECOND, rbmBackedTimestampSet.getTimeBucket());
    SortedSet<Instant> timestamps = actualBoundedTimestampSet.getTimestamps();
    assertTrue(timestamps.isEmpty());
    RBMBackedTimestampSet actualShallowClone = rbmBackedTimestampSet.getShallowClone();
    assertEquals(rbmBackedTimestampSet, actualShallowClone);
    assertEquals(timestamps, rbmBackedTimestampSet.getTimestamps());
  }

  /**
   * Test {@link BoundedTimestampSet#BoundedTimestampSet(TimeBucket, int)}.
   *
   * <ul>
   *   <li>When zero.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link BoundedTimestampSet#BoundedTimestampSet(TimeBucket, int)}
   */
  @Test
  @DisplayName(
      "Test new BoundedTimestampSet(TimeBucket, int); when zero; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BoundedTimestampSet.<init>(TimeBucket, int)"})
  void testNewBoundedTimestampSet_whenZero_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> new BoundedTimestampSet(TimeBucket.SECOND, 0));
  }

  /**
   * Test {@link BoundedTimestampSet#BoundedTimestampSet(TimeBucket, int)}.
   *
   * <ul>
   *   <li>When zero.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link BoundedTimestampSet#BoundedTimestampSet(TimeBucket, int)}
   */
  @Test
  @DisplayName(
      "Test new BoundedTimestampSet(TimeBucket, int); when zero; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BoundedTimestampSet.<init>(TimeBucket, int)"})
  void testNewBoundedTimestampSet_whenZero_thenThrowIllegalArgumentException2() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> new BoundedTimestampSet(TimeBucket.SECOND, 0));
  }

  /**
   * Test {@link BoundedTimestampSet#add(Instant)} with {@code instant}.
   *
   * <p>Method under test: {@link BoundedTimestampSet#add(Instant)}
   */
  @Test
  @DisplayName("Test add(Instant) with 'instant'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BoundedTimestampSet.add(Instant)"})
  void testAddWithInstant() {
    // Arrange
    BoundedTimestampSet boundedTimestampSet = new BoundedTimestampSet(TimeBucket.SECOND, 3);

    // Act
    boundedTimestampSet.add(
        LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Assert
    RBMBackedTimestampSet rbmBackedTimestampSet = boundedTimestampSet.getRbmBackedTimestampSet();
    Iterator<Integer> iteratorResult = rbmBackedTimestampSet.getRbm().iterator();
    assertEquals(0, iteratorResult.next().intValue());
    RBMBackedTimestampSet shallowClone = rbmBackedTimestampSet.getShallowClone();
    assertEquals(1L, shallowClone.getNumberOfTimestamps());
    RBMBackedTimestampSet shallowClone2 = shallowClone.getShallowClone();
    assertEquals(1L, shallowClone2.getNumberOfTimestamps());
    assertFalse(iteratorResult.hasNext());
    Instant instant = Instant.EPOCH;
    assertSame(instant, boundedTimestampSet.getEarliest());
    assertSame(instant, boundedTimestampSet.getLatest());
    assertSame(instant, rbmBackedTimestampSet.getEarliest());
    assertSame(instant, shallowClone.getEarliest());
    assertSame(instant, shallowClone2.getEarliest());
    assertSame(instant, rbmBackedTimestampSet.getLatest());
    assertSame(instant, shallowClone.getLatest());
    assertSame(instant, shallowClone2.getLatest());
  }

  /**
   * Test {@link BoundedTimestampSet#add(Instant)} with {@code instant}.
   *
   * <p>Method under test: {@link BoundedTimestampSet#add(Instant)}
   */
  @Test
  @DisplayName("Test add(Instant) with 'instant'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BoundedTimestampSet.add(Instant)"})
  void testAddWithInstant2() {
    // Arrange
    BoundedTimestampSet boundedTimestampSet = new BoundedTimestampSet(TimeBucket.MINUTE, 3);

    // Act
    boundedTimestampSet.add(
        LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Assert
    RBMBackedTimestampSet rbmBackedTimestampSet = boundedTimestampSet.getRbmBackedTimestampSet();
    Iterator<Integer> iteratorResult = rbmBackedTimestampSet.getRbm().iterator();
    assertEquals(0, iteratorResult.next().intValue());
    RBMBackedTimestampSet shallowClone = rbmBackedTimestampSet.getShallowClone();
    assertEquals(1L, shallowClone.getNumberOfTimestamps());
    RBMBackedTimestampSet shallowClone2 = shallowClone.getShallowClone();
    assertEquals(1L, shallowClone2.getNumberOfTimestamps());
    assertFalse(iteratorResult.hasNext());
    Instant instant = Instant.EPOCH;
    assertSame(instant, boundedTimestampSet.getEarliest());
    assertSame(instant, boundedTimestampSet.getLatest());
    assertSame(instant, rbmBackedTimestampSet.getEarliest());
    assertSame(instant, shallowClone.getEarliest());
    assertSame(instant, shallowClone2.getEarliest());
    assertSame(instant, rbmBackedTimestampSet.getLatest());
    assertSame(instant, shallowClone.getLatest());
    assertSame(instant, shallowClone2.getLatest());
  }

  /**
   * Test {@link BoundedTimestampSet#add(Instant)} with {@code instant}.
   *
   * <p>Method under test: {@link BoundedTimestampSet#add(Instant)}
   */
  @Test
  @DisplayName("Test add(Instant) with 'instant'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BoundedTimestampSet.add(Instant)"})
  void testAddWithInstant3() {
    // Arrange
    BoundedTimestampSet boundedTimestampSet = new BoundedTimestampSet(TimeBucket.HOUR, 3);

    // Act
    boundedTimestampSet.add(
        LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Assert
    RBMBackedTimestampSet rbmBackedTimestampSet = boundedTimestampSet.getRbmBackedTimestampSet();
    Iterator<Integer> iteratorResult = rbmBackedTimestampSet.getRbm().iterator();
    assertEquals(0, iteratorResult.next().intValue());
    RBMBackedTimestampSet shallowClone = rbmBackedTimestampSet.getShallowClone();
    assertEquals(1L, shallowClone.getNumberOfTimestamps());
    RBMBackedTimestampSet shallowClone2 = shallowClone.getShallowClone();
    assertEquals(1L, shallowClone2.getNumberOfTimestamps());
    assertFalse(iteratorResult.hasNext());
    Instant instant = Instant.EPOCH;
    assertSame(instant, boundedTimestampSet.getEarliest());
    assertSame(instant, boundedTimestampSet.getLatest());
    assertSame(instant, rbmBackedTimestampSet.getEarliest());
    assertSame(instant, shallowClone.getEarliest());
    assertSame(instant, shallowClone2.getEarliest());
    assertSame(instant, rbmBackedTimestampSet.getLatest());
    assertSame(instant, shallowClone.getLatest());
    assertSame(instant, shallowClone2.getLatest());
  }

  /**
   * Test {@link BoundedTimestampSet#add(Instant)} with {@code instant}.
   *
   * <p>Method under test: {@link BoundedTimestampSet#add(Instant)}
   */
  @Test
  @DisplayName("Test add(Instant) with 'instant'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BoundedTimestampSet.add(Instant)"})
  void testAddWithInstant4() {
    // Arrange
    BoundedTimestampSet boundedTimestampSet = new BoundedTimestampSet(TimeBucket.DAY, 3);

    // Act
    boundedTimestampSet.add(
        LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Assert
    RBMBackedTimestampSet rbmBackedTimestampSet = boundedTimestampSet.getRbmBackedTimestampSet();
    Iterator<Integer> iteratorResult = rbmBackedTimestampSet.getRbm().iterator();
    assertEquals(0, iteratorResult.next().intValue());
    RBMBackedTimestampSet shallowClone = rbmBackedTimestampSet.getShallowClone();
    assertEquals(1L, shallowClone.getNumberOfTimestamps());
    RBMBackedTimestampSet shallowClone2 = shallowClone.getShallowClone();
    assertEquals(1L, shallowClone2.getNumberOfTimestamps());
    assertFalse(iteratorResult.hasNext());
    Instant instant = Instant.EPOCH;
    assertSame(instant, boundedTimestampSet.getEarliest());
    assertSame(instant, boundedTimestampSet.getLatest());
    assertSame(instant, rbmBackedTimestampSet.getEarliest());
    assertSame(instant, shallowClone.getEarliest());
    assertSame(instant, shallowClone2.getEarliest());
    assertSame(instant, rbmBackedTimestampSet.getLatest());
    assertSame(instant, shallowClone.getLatest());
    assertSame(instant, shallowClone2.getLatest());
  }

  /**
   * Test {@link BoundedTimestampSet#add(Instant)} with {@code instant}.
   *
   * <p>Method under test: {@link BoundedTimestampSet#add(Instant)}
   */
  @Test
  @DisplayName("Test add(Instant) with 'instant'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BoundedTimestampSet.add(Instant)"})
  void testAddWithInstant5() {
    // Arrange
    BoundedTimestampSet boundedTimestampSet = new BoundedTimestampSet(TimeBucket.WEEK, 3);

    // Act
    boundedTimestampSet.add(
        LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Assert
    Instant earliest = boundedTimestampSet.getEarliest();
    assertEquals(-259200L, earliest.getEpochSecond());
    RBMBackedTimestampSet rbmBackedTimestampSet = boundedTimestampSet.getRbmBackedTimestampSet();
    Iterator<Integer> iteratorResult = rbmBackedTimestampSet.getRbm().iterator();
    assertEquals(-3, iteratorResult.next().intValue());
    assertEquals(0, earliest.getNano());
    assertFalse(iteratorResult.hasNext());
    assertEquals(earliest, boundedTimestampSet.getLatest());
    assertEquals(earliest, rbmBackedTimestampSet.getEarliest());
    assertEquals(earliest, rbmBackedTimestampSet.getLatest());
  }

  /**
   * Test {@link BoundedTimestampSet#add(Instant)} with {@code instant}.
   *
   * <p>Method under test: {@link BoundedTimestampSet#add(Instant)}
   */
  @Test
  @DisplayName("Test add(Instant) with 'instant'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BoundedTimestampSet.add(Instant)"})
  void testAddWithInstant6() {
    // Arrange
    BoundedTimestampSet boundedTimestampSet = new BoundedTimestampSet(TimeBucket.MONTH, 3);

    // Act
    boundedTimestampSet.add(
        LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Assert
    RBMBackedTimestampSet rbmBackedTimestampSet = boundedTimestampSet.getRbmBackedTimestampSet();
    Iterator<Integer> iteratorResult = rbmBackedTimestampSet.getRbm().iterator();
    assertEquals(0, iteratorResult.next().intValue());
    RBMBackedTimestampSet shallowClone = rbmBackedTimestampSet.getShallowClone();
    assertEquals(1L, shallowClone.getNumberOfTimestamps());
    RBMBackedTimestampSet shallowClone2 = shallowClone.getShallowClone();
    assertEquals(1L, shallowClone2.getNumberOfTimestamps());
    assertFalse(iteratorResult.hasNext());
    Instant instant = Instant.EPOCH;
    assertSame(instant, boundedTimestampSet.getEarliest());
    assertSame(instant, boundedTimestampSet.getLatest());
    assertSame(instant, rbmBackedTimestampSet.getEarliest());
    assertSame(instant, shallowClone.getEarliest());
    assertSame(instant, shallowClone2.getEarliest());
    assertSame(instant, rbmBackedTimestampSet.getLatest());
    assertSame(instant, shallowClone.getLatest());
    assertSame(instant, shallowClone2.getLatest());
  }

  /**
   * Test {@link BoundedTimestampSet#add(Instant)} with {@code instant}.
   *
   * <p>Method under test: {@link BoundedTimestampSet#add(Instant)}
   */
  @Test
  @DisplayName("Test add(Instant) with 'instant'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BoundedTimestampSet.add(Instant)"})
  void testAddWithInstant7() {
    // Arrange
    BoundedTimestampSet boundedTimestampSet = new BoundedTimestampSet(TimeBucket.YEAR, 3);

    // Act
    boundedTimestampSet.add(
        LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Assert
    RBMBackedTimestampSet rbmBackedTimestampSet = boundedTimestampSet.getRbmBackedTimestampSet();
    Iterator<Integer> iteratorResult = rbmBackedTimestampSet.getRbm().iterator();
    assertEquals(0, iteratorResult.next().intValue());
    RBMBackedTimestampSet shallowClone = rbmBackedTimestampSet.getShallowClone();
    assertEquals(1L, shallowClone.getNumberOfTimestamps());
    RBMBackedTimestampSet shallowClone2 = shallowClone.getShallowClone();
    assertEquals(1L, shallowClone2.getNumberOfTimestamps());
    assertFalse(iteratorResult.hasNext());
    Instant instant = Instant.EPOCH;
    assertSame(instant, boundedTimestampSet.getEarliest());
    assertSame(instant, boundedTimestampSet.getLatest());
    assertSame(instant, rbmBackedTimestampSet.getEarliest());
    assertSame(instant, shallowClone.getEarliest());
    assertSame(instant, shallowClone2.getEarliest());
    assertSame(instant, rbmBackedTimestampSet.getLatest());
    assertSame(instant, shallowClone.getLatest());
    assertSame(instant, shallowClone2.getLatest());
  }

  /**
   * Test {@link BoundedTimestampSet#add(Instant)} with {@code instant}.
   *
   * <p>Method under test: {@link BoundedTimestampSet#add(Instant)}
   */
  @Test
  @DisplayName("Test add(Instant) with 'instant'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BoundedTimestampSet.add(Instant)"})
  void testAddWithInstant8() {
    // Arrange
    BoundedTimestampSet boundedTimestampSet = new BoundedTimestampSet(TimeBucket.SECOND, 3);

    // Act
    boundedTimestampSet.add(
        LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Assert
    RBMBackedTimestampSet rbmBackedTimestampSet = boundedTimestampSet.getRbmBackedTimestampSet();
    Iterator<Integer> iteratorResult = rbmBackedTimestampSet.getRbm().iterator();
    assertEquals(0, iteratorResult.next().intValue());
    RBMBackedTimestampSet shallowClone = rbmBackedTimestampSet.getShallowClone();
    assertEquals(1L, shallowClone.getNumberOfTimestamps());
    RBMBackedTimestampSet shallowClone2 = shallowClone.getShallowClone();
    assertEquals(1L, shallowClone2.getNumberOfTimestamps());
    assertFalse(iteratorResult.hasNext());
    Instant instant = Instant.EPOCH;
    assertSame(instant, boundedTimestampSet.getEarliest());
    assertSame(instant, boundedTimestampSet.getLatest());
    assertSame(instant, rbmBackedTimestampSet.getEarliest());
    assertSame(instant, shallowClone.getEarliest());
    assertSame(instant, shallowClone2.getEarliest());
    assertSame(instant, rbmBackedTimestampSet.getLatest());
    assertSame(instant, shallowClone.getLatest());
    assertSame(instant, shallowClone2.getLatest());
  }

  /**
   * Test {@link BoundedTimestampSet#add(Instant)} with {@code instant}.
   *
   * <p>Method under test: {@link BoundedTimestampSet#add(Instant)}
   */
  @Test
  @DisplayName("Test add(Instant) with 'instant'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BoundedTimestampSet.add(Instant)"})
  void testAddWithInstant9() {
    // Arrange
    BoundedTimestampSet boundedTimestampSet = new BoundedTimestampSet(TimeBucket.MINUTE, 3);

    // Act
    boundedTimestampSet.add(
        LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Assert
    RBMBackedTimestampSet rbmBackedTimestampSet = boundedTimestampSet.getRbmBackedTimestampSet();
    Iterator<Integer> iteratorResult = rbmBackedTimestampSet.getRbm().iterator();
    assertEquals(0, iteratorResult.next().intValue());
    RBMBackedTimestampSet shallowClone = rbmBackedTimestampSet.getShallowClone();
    assertEquals(1L, shallowClone.getNumberOfTimestamps());
    RBMBackedTimestampSet shallowClone2 = shallowClone.getShallowClone();
    assertEquals(1L, shallowClone2.getNumberOfTimestamps());
    assertFalse(iteratorResult.hasNext());
    Instant instant = Instant.EPOCH;
    assertSame(instant, boundedTimestampSet.getEarliest());
    assertSame(instant, boundedTimestampSet.getLatest());
    assertSame(instant, rbmBackedTimestampSet.getEarliest());
    assertSame(instant, shallowClone.getEarliest());
    assertSame(instant, shallowClone2.getEarliest());
    assertSame(instant, rbmBackedTimestampSet.getLatest());
    assertSame(instant, shallowClone.getLatest());
    assertSame(instant, shallowClone2.getLatest());
  }

  /**
   * Test {@link BoundedTimestampSet#add(Instant)} with {@code instant}.
   *
   * <p>Method under test: {@link BoundedTimestampSet#add(Instant)}
   */
  @Test
  @DisplayName("Test add(Instant) with 'instant'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BoundedTimestampSet.add(Instant)"})
  void testAddWithInstant10() {
    // Arrange
    BoundedTimestampSet boundedTimestampSet = new BoundedTimestampSet(TimeBucket.HOUR, 3);

    // Act
    boundedTimestampSet.add(
        LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Assert
    RBMBackedTimestampSet rbmBackedTimestampSet = boundedTimestampSet.getRbmBackedTimestampSet();
    Iterator<Integer> iteratorResult = rbmBackedTimestampSet.getRbm().iterator();
    assertEquals(0, iteratorResult.next().intValue());
    RBMBackedTimestampSet shallowClone = rbmBackedTimestampSet.getShallowClone();
    assertEquals(1L, shallowClone.getNumberOfTimestamps());
    RBMBackedTimestampSet shallowClone2 = shallowClone.getShallowClone();
    assertEquals(1L, shallowClone2.getNumberOfTimestamps());
    assertFalse(iteratorResult.hasNext());
    Instant instant = Instant.EPOCH;
    assertSame(instant, boundedTimestampSet.getEarliest());
    assertSame(instant, boundedTimestampSet.getLatest());
    assertSame(instant, rbmBackedTimestampSet.getEarliest());
    assertSame(instant, shallowClone.getEarliest());
    assertSame(instant, shallowClone2.getEarliest());
    assertSame(instant, rbmBackedTimestampSet.getLatest());
    assertSame(instant, shallowClone.getLatest());
    assertSame(instant, shallowClone2.getLatest());
  }

  /**
   * Test {@link BoundedTimestampSet#add(Instant)} with {@code instant}.
   *
   * <p>Method under test: {@link BoundedTimestampSet#add(Instant)}
   */
  @Test
  @DisplayName("Test add(Instant) with 'instant'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BoundedTimestampSet.add(Instant)"})
  void testAddWithInstant11() {
    // Arrange
    BoundedTimestampSet boundedTimestampSet = new BoundedTimestampSet(TimeBucket.DAY, 3);

    // Act
    boundedTimestampSet.add(
        LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Assert
    RBMBackedTimestampSet rbmBackedTimestampSet = boundedTimestampSet.getRbmBackedTimestampSet();
    Iterator<Integer> iteratorResult = rbmBackedTimestampSet.getRbm().iterator();
    assertEquals(0, iteratorResult.next().intValue());
    RBMBackedTimestampSet shallowClone = rbmBackedTimestampSet.getShallowClone();
    assertEquals(1L, shallowClone.getNumberOfTimestamps());
    RBMBackedTimestampSet shallowClone2 = shallowClone.getShallowClone();
    assertEquals(1L, shallowClone2.getNumberOfTimestamps());
    assertFalse(iteratorResult.hasNext());
    Instant instant = Instant.EPOCH;
    assertSame(instant, boundedTimestampSet.getEarliest());
    assertSame(instant, boundedTimestampSet.getLatest());
    assertSame(instant, rbmBackedTimestampSet.getEarliest());
    assertSame(instant, shallowClone.getEarliest());
    assertSame(instant, shallowClone2.getEarliest());
    assertSame(instant, rbmBackedTimestampSet.getLatest());
    assertSame(instant, shallowClone.getLatest());
    assertSame(instant, shallowClone2.getLatest());
  }

  /**
   * Test {@link BoundedTimestampSet#add(Instant)} with {@code instant}.
   *
   * <p>Method under test: {@link BoundedTimestampSet#add(Instant)}
   */
  @Test
  @DisplayName("Test add(Instant) with 'instant'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BoundedTimestampSet.add(Instant)"})
  void testAddWithInstant12() {
    // Arrange
    BoundedTimestampSet boundedTimestampSet = new BoundedTimestampSet(TimeBucket.WEEK, 3);

    // Act
    boundedTimestampSet.add(
        LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Assert
    Instant earliest = boundedTimestampSet.getEarliest();
    assertEquals(-259200L, earliest.getEpochSecond());
    RBMBackedTimestampSet rbmBackedTimestampSet = boundedTimestampSet.getRbmBackedTimestampSet();
    Iterator<Integer> iteratorResult = rbmBackedTimestampSet.getRbm().iterator();
    assertEquals(-3, iteratorResult.next().intValue());
    assertEquals(0, earliest.getNano());
    assertFalse(iteratorResult.hasNext());
    assertEquals(earliest, boundedTimestampSet.getLatest());
    assertEquals(earliest, rbmBackedTimestampSet.getEarliest());
    assertEquals(earliest, rbmBackedTimestampSet.getLatest());
  }

  /**
   * Test {@link BoundedTimestampSet#add(Instant)} with {@code instant}.
   *
   * <p>Method under test: {@link BoundedTimestampSet#add(Instant)}
   */
  @Test
  @DisplayName("Test add(Instant) with 'instant'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BoundedTimestampSet.add(Instant)"})
  void testAddWithInstant13() {
    // Arrange
    BoundedTimestampSet boundedTimestampSet = new BoundedTimestampSet(TimeBucket.MONTH, 3);

    // Act
    boundedTimestampSet.add(
        LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Assert
    RBMBackedTimestampSet rbmBackedTimestampSet = boundedTimestampSet.getRbmBackedTimestampSet();
    Iterator<Integer> iteratorResult = rbmBackedTimestampSet.getRbm().iterator();
    assertEquals(0, iteratorResult.next().intValue());
    RBMBackedTimestampSet shallowClone = rbmBackedTimestampSet.getShallowClone();
    assertEquals(1L, shallowClone.getNumberOfTimestamps());
    RBMBackedTimestampSet shallowClone2 = shallowClone.getShallowClone();
    assertEquals(1L, shallowClone2.getNumberOfTimestamps());
    assertFalse(iteratorResult.hasNext());
    Instant instant = Instant.EPOCH;
    assertSame(instant, boundedTimestampSet.getEarliest());
    assertSame(instant, boundedTimestampSet.getLatest());
    assertSame(instant, rbmBackedTimestampSet.getEarliest());
    assertSame(instant, shallowClone.getEarliest());
    assertSame(instant, shallowClone2.getEarliest());
    assertSame(instant, rbmBackedTimestampSet.getLatest());
    assertSame(instant, shallowClone.getLatest());
    assertSame(instant, shallowClone2.getLatest());
  }

  /**
   * Test {@link BoundedTimestampSet#add(Instant)} with {@code instant}.
   *
   * <p>Method under test: {@link BoundedTimestampSet#add(Instant)}
   */
  @Test
  @DisplayName("Test add(Instant) with 'instant'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BoundedTimestampSet.add(Instant)"})
  void testAddWithInstant14() {
    // Arrange
    BoundedTimestampSet boundedTimestampSet = new BoundedTimestampSet(TimeBucket.YEAR, 3);

    // Act
    boundedTimestampSet.add(
        LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Assert
    RBMBackedTimestampSet rbmBackedTimestampSet = boundedTimestampSet.getRbmBackedTimestampSet();
    Iterator<Integer> iteratorResult = rbmBackedTimestampSet.getRbm().iterator();
    assertEquals(0, iteratorResult.next().intValue());
    RBMBackedTimestampSet shallowClone = rbmBackedTimestampSet.getShallowClone();
    assertEquals(1L, shallowClone.getNumberOfTimestamps());
    RBMBackedTimestampSet shallowClone2 = shallowClone.getShallowClone();
    assertEquals(1L, shallowClone2.getNumberOfTimestamps());
    assertFalse(iteratorResult.hasNext());
    Instant instant = Instant.EPOCH;
    assertSame(instant, boundedTimestampSet.getEarliest());
    assertSame(instant, boundedTimestampSet.getLatest());
    assertSame(instant, rbmBackedTimestampSet.getEarliest());
    assertSame(instant, shallowClone.getEarliest());
    assertSame(instant, shallowClone2.getEarliest());
    assertSame(instant, rbmBackedTimestampSet.getLatest());
    assertSame(instant, shallowClone.getLatest());
    assertSame(instant, shallowClone2.getLatest());
  }

  /**
   * Test {@link BoundedTimestampSet#add(Collection)} with {@code instants}.
   *
   * <p>Method under test: {@link BoundedTimestampSet#add(Collection)}
   */
  @Test
  @DisplayName("Test add(Collection) with 'instants'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BoundedTimestampSet.add(Collection)"})
  void testAddWithInstants() {
    // Arrange
    BoundedTimestampSet boundedTimestampSet = new BoundedTimestampSet(TimeBucket.SECOND, 3);

    // Act
    boundedTimestampSet.add(new ArrayList<>());

    // Assert that nothing has changed
    RBMBackedTimestampSet rbmBackedTimestampSet = boundedTimestampSet.getRbmBackedTimestampSet();
    assertEquals(0L, rbmBackedTimestampSet.getShallowClone().getNumberOfTimestamps());
    assertFalse(rbmBackedTimestampSet.getRbm().iterator().hasNext());
  }

  /**
   * Test {@link BoundedTimestampSet#add(Collection)} with {@code instants}.
   *
   * <p>Method under test: {@link BoundedTimestampSet#add(Collection)}
   */
  @Test
  @DisplayName("Test add(Collection) with 'instants'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BoundedTimestampSet.add(Collection)"})
  void testAddWithInstants2() {
    // Arrange
    BoundedTimestampSet boundedTimestampSet = new BoundedTimestampSet(TimeBucket.SECOND, 3);

    ArrayList<Instant> instants = new ArrayList<>();
    instants.add(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Act
    boundedTimestampSet.add(instants);

    // Assert
    RBMBackedTimestampSet rbmBackedTimestampSet = boundedTimestampSet.getRbmBackedTimestampSet();
    Iterator<Integer> iteratorResult = rbmBackedTimestampSet.getRbm().iterator();
    assertEquals(0, iteratorResult.next().intValue());
    RBMBackedTimestampSet shallowClone = rbmBackedTimestampSet.getShallowClone();
    assertEquals(1L, shallowClone.getNumberOfTimestamps());
    assertEquals(1L, shallowClone.getShallowClone().getNumberOfTimestamps());
    assertFalse(iteratorResult.hasNext());
  }

  /**
   * Test {@link BoundedTimestampSet#add(Collection)} with {@code instants}.
   *
   * <p>Method under test: {@link BoundedTimestampSet#add(Collection)}
   */
  @Test
  @DisplayName("Test add(Collection) with 'instants'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BoundedTimestampSet.add(Collection)"})
  void testAddWithInstants3() {
    // Arrange
    BoundedTimestampSet boundedTimestampSet = new BoundedTimestampSet(TimeBucket.SECOND, 3);

    ArrayList<Instant> instants = new ArrayList<>();
    instants.add(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
    instants.add(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Act
    boundedTimestampSet.add(instants);

    // Assert
    RBMBackedTimestampSet rbmBackedTimestampSet = boundedTimestampSet.getRbmBackedTimestampSet();
    Iterator<Integer> iteratorResult = rbmBackedTimestampSet.getRbm().iterator();
    assertEquals(0, iteratorResult.next().intValue());
    RBMBackedTimestampSet shallowClone = rbmBackedTimestampSet.getShallowClone();
    assertEquals(1L, shallowClone.getNumberOfTimestamps());
    assertEquals(1L, shallowClone.getShallowClone().getNumberOfTimestamps());
    assertFalse(iteratorResult.hasNext());
  }

  /**
   * Test {@link BoundedTimestampSet#add(Collection)} with {@code instants}.
   *
   * <p>Method under test: {@link BoundedTimestampSet#add(Collection)}
   */
  @Test
  @DisplayName("Test add(Collection) with 'instants'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BoundedTimestampSet.add(Collection)"})
  void testAddWithInstants4() {
    // Arrange
    BoundedTimestampSet boundedTimestampSet = new BoundedTimestampSet(TimeBucket.MINUTE, 3);

    ArrayList<Instant> instants = new ArrayList<>();
    instants.add(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Act
    boundedTimestampSet.add(instants);

    // Assert
    RBMBackedTimestampSet rbmBackedTimestampSet = boundedTimestampSet.getRbmBackedTimestampSet();
    Iterator<Integer> iteratorResult = rbmBackedTimestampSet.getRbm().iterator();
    assertEquals(0, iteratorResult.next().intValue());
    RBMBackedTimestampSet shallowClone = rbmBackedTimestampSet.getShallowClone();
    assertEquals(1L, shallowClone.getNumberOfTimestamps());
    assertEquals(1L, shallowClone.getShallowClone().getNumberOfTimestamps());
    assertFalse(iteratorResult.hasNext());
  }

  /**
   * Test {@link BoundedTimestampSet#add(Collection)} with {@code instants}.
   *
   * <p>Method under test: {@link BoundedTimestampSet#add(Collection)}
   */
  @Test
  @DisplayName("Test add(Collection) with 'instants'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BoundedTimestampSet.add(Collection)"})
  void testAddWithInstants5() {
    // Arrange
    BoundedTimestampSet boundedTimestampSet = new BoundedTimestampSet(TimeBucket.HOUR, 3);

    ArrayList<Instant> instants = new ArrayList<>();
    instants.add(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Act
    boundedTimestampSet.add(instants);

    // Assert
    RBMBackedTimestampSet rbmBackedTimestampSet = boundedTimestampSet.getRbmBackedTimestampSet();
    Iterator<Integer> iteratorResult = rbmBackedTimestampSet.getRbm().iterator();
    assertEquals(0, iteratorResult.next().intValue());
    RBMBackedTimestampSet shallowClone = rbmBackedTimestampSet.getShallowClone();
    assertEquals(1L, shallowClone.getNumberOfTimestamps());
    assertEquals(1L, shallowClone.getShallowClone().getNumberOfTimestamps());
    assertFalse(iteratorResult.hasNext());
  }

  /**
   * Test {@link BoundedTimestampSet#add(Collection)} with {@code instants}.
   *
   * <p>Method under test: {@link BoundedTimestampSet#add(Collection)}
   */
  @Test
  @DisplayName("Test add(Collection) with 'instants'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BoundedTimestampSet.add(Collection)"})
  void testAddWithInstants6() {
    // Arrange
    BoundedTimestampSet boundedTimestampSet = new BoundedTimestampSet(TimeBucket.DAY, 3);

    ArrayList<Instant> instants = new ArrayList<>();
    instants.add(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Act
    boundedTimestampSet.add(instants);

    // Assert
    RBMBackedTimestampSet rbmBackedTimestampSet = boundedTimestampSet.getRbmBackedTimestampSet();
    Iterator<Integer> iteratorResult = rbmBackedTimestampSet.getRbm().iterator();
    assertEquals(0, iteratorResult.next().intValue());
    RBMBackedTimestampSet shallowClone = rbmBackedTimestampSet.getShallowClone();
    assertEquals(1L, shallowClone.getNumberOfTimestamps());
    assertEquals(1L, shallowClone.getShallowClone().getNumberOfTimestamps());
    assertFalse(iteratorResult.hasNext());
  }

  /**
   * Test {@link BoundedTimestampSet#add(Collection)} with {@code instants}.
   *
   * <p>Method under test: {@link BoundedTimestampSet#add(Collection)}
   */
  @Test
  @DisplayName("Test add(Collection) with 'instants'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BoundedTimestampSet.add(Collection)"})
  void testAddWithInstants7() {
    // Arrange
    BoundedTimestampSet boundedTimestampSet = new BoundedTimestampSet(TimeBucket.WEEK, 3);

    ArrayList<Instant> instants = new ArrayList<>();
    instants.add(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Act
    boundedTimestampSet.add(instants);

    // Assert
    Instant earliest = boundedTimestampSet.getEarliest();
    assertEquals(-259200L, earliest.getEpochSecond());
    RBMBackedTimestampSet rbmBackedTimestampSet = boundedTimestampSet.getRbmBackedTimestampSet();
    Iterator<Integer> iteratorResult = rbmBackedTimestampSet.getRbm().iterator();
    assertEquals(-3, iteratorResult.next().intValue());
    assertEquals(0, earliest.getNano());
    assertFalse(iteratorResult.hasNext());
    assertEquals(earliest, boundedTimestampSet.getLatest());
    assertEquals(earliest, rbmBackedTimestampSet.getEarliest());
    assertEquals(earliest, rbmBackedTimestampSet.getLatest());
  }

  /**
   * Test {@link BoundedTimestampSet#add(Collection)} with {@code instants}.
   *
   * <p>Method under test: {@link BoundedTimestampSet#add(Collection)}
   */
  @Test
  @DisplayName("Test add(Collection) with 'instants'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BoundedTimestampSet.add(Collection)"})
  void testAddWithInstants8() {
    // Arrange
    BoundedTimestampSet boundedTimestampSet = new BoundedTimestampSet(TimeBucket.MONTH, 3);

    ArrayList<Instant> instants = new ArrayList<>();
    instants.add(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Act
    boundedTimestampSet.add(instants);

    // Assert
    RBMBackedTimestampSet rbmBackedTimestampSet = boundedTimestampSet.getRbmBackedTimestampSet();
    Iterator<Integer> iteratorResult = rbmBackedTimestampSet.getRbm().iterator();
    assertEquals(0, iteratorResult.next().intValue());
    RBMBackedTimestampSet shallowClone = rbmBackedTimestampSet.getShallowClone();
    assertEquals(1L, shallowClone.getNumberOfTimestamps());
    assertEquals(1L, shallowClone.getShallowClone().getNumberOfTimestamps());
    assertFalse(iteratorResult.hasNext());
  }

  /**
   * Test {@link BoundedTimestampSet#add(Collection)} with {@code instants}.
   *
   * <p>Method under test: {@link BoundedTimestampSet#add(Collection)}
   */
  @Test
  @DisplayName("Test add(Collection) with 'instants'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BoundedTimestampSet.add(Collection)"})
  void testAddWithInstants9() {
    // Arrange
    BoundedTimestampSet boundedTimestampSet = new BoundedTimestampSet(TimeBucket.YEAR, 3);

    ArrayList<Instant> instants = new ArrayList<>();
    instants.add(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Act
    boundedTimestampSet.add(instants);

    // Assert
    RBMBackedTimestampSet rbmBackedTimestampSet = boundedTimestampSet.getRbmBackedTimestampSet();
    Iterator<Integer> iteratorResult = rbmBackedTimestampSet.getRbm().iterator();
    assertEquals(0, iteratorResult.next().intValue());
    RBMBackedTimestampSet shallowClone = rbmBackedTimestampSet.getShallowClone();
    assertEquals(1L, shallowClone.getNumberOfTimestamps());
    assertEquals(1L, shallowClone.getShallowClone().getNumberOfTimestamps());
    assertFalse(iteratorResult.hasNext());
  }

  /**
   * Test {@link BoundedTimestampSet#add(Collection)} with {@code instants}.
   *
   * <p>Method under test: {@link BoundedTimestampSet#add(Collection)}
   */
  @Test
  @DisplayName("Test add(Collection) with 'instants'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BoundedTimestampSet.add(Collection)"})
  void testAddWithInstants10() {
    // Arrange
    BoundedTimestampSet boundedTimestampSet = new BoundedTimestampSet(TimeBucket.SECOND, 3);

    // Act
    boundedTimestampSet.add(new ArrayList<>());

    // Assert that nothing has changed
    RBMBackedTimestampSet rbmBackedTimestampSet = boundedTimestampSet.getRbmBackedTimestampSet();
    assertEquals(0L, rbmBackedTimestampSet.getShallowClone().getNumberOfTimestamps());
    assertFalse(rbmBackedTimestampSet.getRbm().iterator().hasNext());
  }

  /**
   * Test {@link BoundedTimestampSet#add(Collection)} with {@code instants}.
   *
   * <p>Method under test: {@link BoundedTimestampSet#add(Collection)}
   */
  @Test
  @DisplayName("Test add(Collection) with 'instants'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BoundedTimestampSet.add(Collection)"})
  void testAddWithInstants11() {
    // Arrange
    BoundedTimestampSet boundedTimestampSet = new BoundedTimestampSet(TimeBucket.SECOND, 3);

    ArrayList<Instant> instants = new ArrayList<>();
    instants.add(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Act
    boundedTimestampSet.add(instants);

    // Assert
    RBMBackedTimestampSet rbmBackedTimestampSet = boundedTimestampSet.getRbmBackedTimestampSet();
    Iterator<Integer> iteratorResult = rbmBackedTimestampSet.getRbm().iterator();
    assertEquals(0, iteratorResult.next().intValue());
    RBMBackedTimestampSet shallowClone = rbmBackedTimestampSet.getShallowClone();
    assertEquals(1L, shallowClone.getNumberOfTimestamps());
    assertEquals(1L, shallowClone.getShallowClone().getNumberOfTimestamps());
    assertFalse(iteratorResult.hasNext());
  }

  /**
   * Test {@link BoundedTimestampSet#add(Collection)} with {@code instants}.
   *
   * <p>Method under test: {@link BoundedTimestampSet#add(Collection)}
   */
  @Test
  @DisplayName("Test add(Collection) with 'instants'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BoundedTimestampSet.add(Collection)"})
  void testAddWithInstants12() {
    // Arrange
    BoundedTimestampSet boundedTimestampSet = new BoundedTimestampSet(TimeBucket.SECOND, 3);

    ArrayList<Instant> instants = new ArrayList<>();
    instants.add(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
    instants.add(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Act
    boundedTimestampSet.add(instants);

    // Assert
    RBMBackedTimestampSet rbmBackedTimestampSet = boundedTimestampSet.getRbmBackedTimestampSet();
    Iterator<Integer> iteratorResult = rbmBackedTimestampSet.getRbm().iterator();
    assertEquals(0, iteratorResult.next().intValue());
    RBMBackedTimestampSet shallowClone = rbmBackedTimestampSet.getShallowClone();
    assertEquals(1L, shallowClone.getNumberOfTimestamps());
    assertEquals(1L, shallowClone.getShallowClone().getNumberOfTimestamps());
    assertFalse(iteratorResult.hasNext());
  }

  /**
   * Test {@link BoundedTimestampSet#add(Collection)} with {@code instants}.
   *
   * <p>Method under test: {@link BoundedTimestampSet#add(Collection)}
   */
  @Test
  @DisplayName("Test add(Collection) with 'instants'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BoundedTimestampSet.add(Collection)"})
  void testAddWithInstants13() {
    // Arrange
    BoundedTimestampSet boundedTimestampSet = new BoundedTimestampSet(TimeBucket.MINUTE, 3);

    ArrayList<Instant> instants = new ArrayList<>();
    instants.add(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Act
    boundedTimestampSet.add(instants);

    // Assert
    RBMBackedTimestampSet rbmBackedTimestampSet = boundedTimestampSet.getRbmBackedTimestampSet();
    Iterator<Integer> iteratorResult = rbmBackedTimestampSet.getRbm().iterator();
    assertEquals(0, iteratorResult.next().intValue());
    RBMBackedTimestampSet shallowClone = rbmBackedTimestampSet.getShallowClone();
    assertEquals(1L, shallowClone.getNumberOfTimestamps());
    assertEquals(1L, shallowClone.getShallowClone().getNumberOfTimestamps());
    assertFalse(iteratorResult.hasNext());
  }

  /**
   * Test {@link BoundedTimestampSet#add(Collection)} with {@code instants}.
   *
   * <p>Method under test: {@link BoundedTimestampSet#add(Collection)}
   */
  @Test
  @DisplayName("Test add(Collection) with 'instants'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BoundedTimestampSet.add(Collection)"})
  void testAddWithInstants14() {
    // Arrange
    BoundedTimestampSet boundedTimestampSet = new BoundedTimestampSet(TimeBucket.HOUR, 3);

    ArrayList<Instant> instants = new ArrayList<>();
    instants.add(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Act
    boundedTimestampSet.add(instants);

    // Assert
    RBMBackedTimestampSet rbmBackedTimestampSet = boundedTimestampSet.getRbmBackedTimestampSet();
    Iterator<Integer> iteratorResult = rbmBackedTimestampSet.getRbm().iterator();
    assertEquals(0, iteratorResult.next().intValue());
    RBMBackedTimestampSet shallowClone = rbmBackedTimestampSet.getShallowClone();
    assertEquals(1L, shallowClone.getNumberOfTimestamps());
    assertEquals(1L, shallowClone.getShallowClone().getNumberOfTimestamps());
    assertFalse(iteratorResult.hasNext());
  }

  /**
   * Test {@link BoundedTimestampSet#add(Collection)} with {@code instants}.
   *
   * <p>Method under test: {@link BoundedTimestampSet#add(Collection)}
   */
  @Test
  @DisplayName("Test add(Collection) with 'instants'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BoundedTimestampSet.add(Collection)"})
  void testAddWithInstants15() {
    // Arrange
    BoundedTimestampSet boundedTimestampSet = new BoundedTimestampSet(TimeBucket.DAY, 3);

    ArrayList<Instant> instants = new ArrayList<>();
    instants.add(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Act
    boundedTimestampSet.add(instants);

    // Assert
    RBMBackedTimestampSet rbmBackedTimestampSet = boundedTimestampSet.getRbmBackedTimestampSet();
    Iterator<Integer> iteratorResult = rbmBackedTimestampSet.getRbm().iterator();
    assertEquals(0, iteratorResult.next().intValue());
    RBMBackedTimestampSet shallowClone = rbmBackedTimestampSet.getShallowClone();
    assertEquals(1L, shallowClone.getNumberOfTimestamps());
    assertEquals(1L, shallowClone.getShallowClone().getNumberOfTimestamps());
    assertFalse(iteratorResult.hasNext());
  }

  /**
   * Test {@link BoundedTimestampSet#add(Collection)} with {@code instants}.
   *
   * <p>Method under test: {@link BoundedTimestampSet#add(Collection)}
   */
  @Test
  @DisplayName("Test add(Collection) with 'instants'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BoundedTimestampSet.add(Collection)"})
  void testAddWithInstants16() {
    // Arrange
    BoundedTimestampSet boundedTimestampSet = new BoundedTimestampSet(TimeBucket.WEEK, 3);

    ArrayList<Instant> instants = new ArrayList<>();
    instants.add(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Act
    boundedTimestampSet.add(instants);

    // Assert
    Instant earliest = boundedTimestampSet.getEarliest();
    assertEquals(-259200L, earliest.getEpochSecond());
    RBMBackedTimestampSet rbmBackedTimestampSet = boundedTimestampSet.getRbmBackedTimestampSet();
    Iterator<Integer> iteratorResult = rbmBackedTimestampSet.getRbm().iterator();
    assertEquals(-3, iteratorResult.next().intValue());
    assertEquals(0, earliest.getNano());
    assertFalse(iteratorResult.hasNext());
    assertEquals(earliest, boundedTimestampSet.getLatest());
    assertEquals(earliest, rbmBackedTimestampSet.getEarliest());
    assertEquals(earliest, rbmBackedTimestampSet.getLatest());
  }

  /**
   * Test {@link BoundedTimestampSet#add(Collection)} with {@code instants}.
   *
   * <p>Method under test: {@link BoundedTimestampSet#add(Collection)}
   */
  @Test
  @DisplayName("Test add(Collection) with 'instants'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BoundedTimestampSet.add(Collection)"})
  void testAddWithInstants17() {
    // Arrange
    BoundedTimestampSet boundedTimestampSet = new BoundedTimestampSet(TimeBucket.MONTH, 3);

    ArrayList<Instant> instants = new ArrayList<>();
    instants.add(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Act
    boundedTimestampSet.add(instants);

    // Assert
    RBMBackedTimestampSet rbmBackedTimestampSet = boundedTimestampSet.getRbmBackedTimestampSet();
    Iterator<Integer> iteratorResult = rbmBackedTimestampSet.getRbm().iterator();
    assertEquals(0, iteratorResult.next().intValue());
    RBMBackedTimestampSet shallowClone = rbmBackedTimestampSet.getShallowClone();
    assertEquals(1L, shallowClone.getNumberOfTimestamps());
    assertEquals(1L, shallowClone.getShallowClone().getNumberOfTimestamps());
    assertFalse(iteratorResult.hasNext());
  }

  /**
   * Test {@link BoundedTimestampSet#add(Collection)} with {@code instants}.
   *
   * <p>Method under test: {@link BoundedTimestampSet#add(Collection)}
   */
  @Test
  @DisplayName("Test add(Collection) with 'instants'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BoundedTimestampSet.add(Collection)"})
  void testAddWithInstants18() {
    // Arrange
    BoundedTimestampSet boundedTimestampSet = new BoundedTimestampSet(TimeBucket.YEAR, 3);

    ArrayList<Instant> instants = new ArrayList<>();
    instants.add(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Act
    boundedTimestampSet.add(instants);

    // Assert
    RBMBackedTimestampSet rbmBackedTimestampSet = boundedTimestampSet.getRbmBackedTimestampSet();
    Iterator<Integer> iteratorResult = rbmBackedTimestampSet.getRbm().iterator();
    assertEquals(0, iteratorResult.next().intValue());
    RBMBackedTimestampSet shallowClone = rbmBackedTimestampSet.getShallowClone();
    assertEquals(1L, shallowClone.getNumberOfTimestamps());
    assertEquals(1L, shallowClone.getShallowClone().getNumberOfTimestamps());
    assertFalse(iteratorResult.hasNext());
  }

  /**
   * Test {@link BoundedTimestampSet#getTimestamps()}.
   *
   * <p>Method under test: {@link BoundedTimestampSet#getTimestamps()}
   */
  @Test
  @DisplayName("Test getTimestamps()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"SortedSet BoundedTimestampSet.getTimestamps()"})
  void testGetTimestamps() {
    // Arrange
    BoundedTimestampSet boundedTimestampSet = new BoundedTimestampSet(TimeBucket.SECOND, 3);
    boundedTimestampSet.add(
        LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Act and Assert
    assertEquals(1, boundedTimestampSet.getTimestamps().size());
  }

  /**
   * Test {@link BoundedTimestampSet#getTimestamps()}.
   *
   * <p>Method under test: {@link BoundedTimestampSet#getTimestamps()}
   */
  @Test
  @DisplayName("Test getTimestamps()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"SortedSet BoundedTimestampSet.getTimestamps()"})
  void testGetTimestamps2() {
    // Arrange
    BoundedTimestampSet boundedTimestampSet = new BoundedTimestampSet(TimeBucket.MINUTE, 3);
    boundedTimestampSet.add(
        LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Act and Assert
    assertEquals(1, boundedTimestampSet.getTimestamps().size());
  }

  /**
   * Test {@link BoundedTimestampSet#getTimestamps()}.
   *
   * <p>Method under test: {@link BoundedTimestampSet#getTimestamps()}
   */
  @Test
  @DisplayName("Test getTimestamps()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"SortedSet BoundedTimestampSet.getTimestamps()"})
  void testGetTimestamps3() {
    // Arrange
    BoundedTimestampSet boundedTimestampSet = new BoundedTimestampSet(TimeBucket.HOUR, 3);
    boundedTimestampSet.add(
        LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Act and Assert
    assertEquals(1, boundedTimestampSet.getTimestamps().size());
  }

  /**
   * Test {@link BoundedTimestampSet#getTimestamps()}.
   *
   * <p>Method under test: {@link BoundedTimestampSet#getTimestamps()}
   */
  @Test
  @DisplayName("Test getTimestamps()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"SortedSet BoundedTimestampSet.getTimestamps()"})
  void testGetTimestamps4() {
    // Arrange
    BoundedTimestampSet boundedTimestampSet = new BoundedTimestampSet(TimeBucket.DAY, 3);
    boundedTimestampSet.add(
        LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Act and Assert
    assertEquals(1, boundedTimestampSet.getTimestamps().size());
  }

  /**
   * Test {@link BoundedTimestampSet#getTimestamps()}.
   *
   * <p>Method under test: {@link BoundedTimestampSet#getTimestamps()}
   */
  @Test
  @DisplayName("Test getTimestamps()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"SortedSet BoundedTimestampSet.getTimestamps()"})
  void testGetTimestamps5() {
    // Arrange
    BoundedTimestampSet boundedTimestampSet = new BoundedTimestampSet(TimeBucket.WEEK, 3);
    boundedTimestampSet.add(
        LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Act and Assert
    assertEquals(1, boundedTimestampSet.getTimestamps().size());
  }

  /**
   * Test {@link BoundedTimestampSet#getTimestamps()}.
   *
   * <p>Method under test: {@link BoundedTimestampSet#getTimestamps()}
   */
  @Test
  @DisplayName("Test getTimestamps()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"SortedSet BoundedTimestampSet.getTimestamps()"})
  void testGetTimestamps6() {
    // Arrange
    BoundedTimestampSet boundedTimestampSet = new BoundedTimestampSet(TimeBucket.MONTH, 3);
    boundedTimestampSet.add(
        LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Act and Assert
    assertEquals(1, boundedTimestampSet.getTimestamps().size());
  }

  /**
   * Test {@link BoundedTimestampSet#getTimestamps()}.
   *
   * <p>Method under test: {@link BoundedTimestampSet#getTimestamps()}
   */
  @Test
  @DisplayName("Test getTimestamps()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"SortedSet BoundedTimestampSet.getTimestamps()"})
  void testGetTimestamps7() {
    // Arrange
    BoundedTimestampSet boundedTimestampSet = new BoundedTimestampSet(TimeBucket.YEAR, 3);
    boundedTimestampSet.add(
        LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Act and Assert
    assertEquals(1, boundedTimestampSet.getTimestamps().size());
  }

  /**
   * Test {@link BoundedTimestampSet#getTimestamps()}.
   *
   * <p>Method under test: {@link BoundedTimestampSet#getTimestamps()}
   */
  @Test
  @DisplayName("Test getTimestamps()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"SortedSet BoundedTimestampSet.getTimestamps()"})
  void testGetTimestamps8() {
    // Arrange
    BoundedTimestampSet boundedTimestampSet =
        new Builder().maxSize(3).state(State.SAMPLE).timeBucket(TimeBucket.SECOND).build();
    boundedTimestampSet.add(
        LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Act and Assert
    assertEquals(1, boundedTimestampSet.getTimestamps().size());
  }

  /**
   * Test {@link BoundedTimestampSet#getTimestamps()}.
   *
   * <p>Method under test: {@link BoundedTimestampSet#getTimestamps()}
   */
  @Test
  @DisplayName("Test getTimestamps()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"SortedSet BoundedTimestampSet.getTimestamps()"})
  void testGetTimestamps9() {
    // Arrange
    BoundedTimestampSet boundedTimestampSet = new BoundedTimestampSet(TimeBucket.SECOND, 3);
    boundedTimestampSet.add(
        LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Act and Assert
    assertEquals(1, boundedTimestampSet.getTimestamps().size());
  }

  /**
   * Test {@link BoundedTimestampSet#getTimestamps()}.
   *
   * <p>Method under test: {@link BoundedTimestampSet#getTimestamps()}
   */
  @Test
  @DisplayName("Test getTimestamps()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"SortedSet BoundedTimestampSet.getTimestamps()"})
  void testGetTimestamps10() {
    // Arrange
    BoundedTimestampSet boundedTimestampSet = new BoundedTimestampSet(TimeBucket.MINUTE, 3);
    boundedTimestampSet.add(
        LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Act and Assert
    assertEquals(1, boundedTimestampSet.getTimestamps().size());
  }

  /**
   * Test {@link BoundedTimestampSet#getTimestamps()}.
   *
   * <p>Method under test: {@link BoundedTimestampSet#getTimestamps()}
   */
  @Test
  @DisplayName("Test getTimestamps()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"SortedSet BoundedTimestampSet.getTimestamps()"})
  void testGetTimestamps11() {
    // Arrange
    BoundedTimestampSet boundedTimestampSet = new BoundedTimestampSet(TimeBucket.HOUR, 3);
    boundedTimestampSet.add(
        LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Act and Assert
    assertEquals(1, boundedTimestampSet.getTimestamps().size());
  }

  /**
   * Test {@link BoundedTimestampSet#getTimestamps()}.
   *
   * <p>Method under test: {@link BoundedTimestampSet#getTimestamps()}
   */
  @Test
  @DisplayName("Test getTimestamps()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"SortedSet BoundedTimestampSet.getTimestamps()"})
  void testGetTimestamps12() {
    // Arrange
    BoundedTimestampSet boundedTimestampSet = new BoundedTimestampSet(TimeBucket.DAY, 3);
    boundedTimestampSet.add(
        LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Act and Assert
    assertEquals(1, boundedTimestampSet.getTimestamps().size());
  }

  /**
   * Test {@link BoundedTimestampSet#getTimestamps()}.
   *
   * <p>Method under test: {@link BoundedTimestampSet#getTimestamps()}
   */
  @Test
  @DisplayName("Test getTimestamps()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"SortedSet BoundedTimestampSet.getTimestamps()"})
  void testGetTimestamps13() {
    // Arrange
    BoundedTimestampSet boundedTimestampSet = new BoundedTimestampSet(TimeBucket.WEEK, 3);
    boundedTimestampSet.add(
        LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Act and Assert
    assertEquals(1, boundedTimestampSet.getTimestamps().size());
  }

  /**
   * Test {@link BoundedTimestampSet#getTimestamps()}.
   *
   * <p>Method under test: {@link BoundedTimestampSet#getTimestamps()}
   */
  @Test
  @DisplayName("Test getTimestamps()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"SortedSet BoundedTimestampSet.getTimestamps()"})
  void testGetTimestamps14() {
    // Arrange
    BoundedTimestampSet boundedTimestampSet = new BoundedTimestampSet(TimeBucket.MONTH, 3);
    boundedTimestampSet.add(
        LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Act and Assert
    assertEquals(1, boundedTimestampSet.getTimestamps().size());
  }

  /**
   * Test {@link BoundedTimestampSet#getTimestamps()}.
   *
   * <p>Method under test: {@link BoundedTimestampSet#getTimestamps()}
   */
  @Test
  @DisplayName("Test getTimestamps()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"SortedSet BoundedTimestampSet.getTimestamps()"})
  void testGetTimestamps15() {
    // Arrange
    BoundedTimestampSet boundedTimestampSet = new BoundedTimestampSet(TimeBucket.YEAR, 3);
    boundedTimestampSet.add(
        LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Act and Assert
    assertEquals(1, boundedTimestampSet.getTimestamps().size());
  }

  /**
   * Test {@link BoundedTimestampSet#getTimestamps()}.
   *
   * <p>Method under test: {@link BoundedTimestampSet#getTimestamps()}
   */
  @Test
  @DisplayName("Test getTimestamps()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"SortedSet BoundedTimestampSet.getTimestamps()"})
  void testGetTimestamps16() {
    // Arrange
    BoundedTimestampSet boundedTimestampSet =
        new Builder().maxSize(3).state(State.SAMPLE).timeBucket(TimeBucket.SECOND).build();
    boundedTimestampSet.add(
        LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Act and Assert
    assertEquals(1, boundedTimestampSet.getTimestamps().size());
  }

  /**
   * Test {@link BoundedTimestampSet#getTimestamps()}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link BoundedTimestampSet#getTimestamps()}
   */
  @Test
  @DisplayName("Test getTimestamps(); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"SortedSet BoundedTimestampSet.getTimestamps()"})
  void testGetTimestamps_thenReturnEmpty() {
    // Arrange, Act and Assert
    assertTrue(new BoundedTimestampSet(TimeBucket.SECOND, 3).getTimestamps().isEmpty());
  }

  /**
   * Test {@link BoundedTimestampSet#getTimestamps()}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link BoundedTimestampSet#getTimestamps()}
   */
  @Test
  @DisplayName("Test getTimestamps(); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"SortedSet BoundedTimestampSet.getTimestamps()"})
  void testGetTimestamps_thenReturnEmpty2() {
    // Arrange, Act and Assert
    assertTrue(new BoundedTimestampSet(TimeBucket.SECOND, 3).getTimestamps().isEmpty());
  }

  /**
   * Test {@link BoundedTimestampSet#getTimestamps()}.
   *
   * <ul>
   *   <li>Then return size is two.
   * </ul>
   *
   * <p>Method under test: {@link BoundedTimestampSet#getTimestamps()}
   */
  @Test
  @DisplayName("Test getTimestamps(); then return size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"SortedSet BoundedTimestampSet.getTimestamps()"})
  void testGetTimestamps_thenReturnSizeIsTwo() {
    // Arrange
    BoundedTimestampSet boundedTimestampSet = new BoundedTimestampSet(TimeBucket.MINUTE, 3);
    boundedTimestampSet.add(
        LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    LocalDate ofEpochDayResult = LocalDate.ofEpochDay(1L);
    boundedTimestampSet.add(ofEpochDayResult.atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Act and Assert
    assertEquals(2, boundedTimestampSet.getTimestamps().size());
  }

  /**
   * Test {@link BoundedTimestampSet#getTimestamps()}.
   *
   * <ul>
   *   <li>Then return size is two.
   * </ul>
   *
   * <p>Method under test: {@link BoundedTimestampSet#getTimestamps()}
   */
  @Test
  @DisplayName("Test getTimestamps(); then return size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"SortedSet BoundedTimestampSet.getTimestamps()"})
  void testGetTimestamps_thenReturnSizeIsTwo2() {
    // Arrange
    BoundedTimestampSet boundedTimestampSet = new BoundedTimestampSet(TimeBucket.MINUTE, 3);
    boundedTimestampSet.add(
        LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    LocalDate ofEpochDayResult = LocalDate.ofEpochDay(1L);
    boundedTimestampSet.add(ofEpochDayResult.atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Act and Assert
    assertEquals(2, boundedTimestampSet.getTimestamps().size());
  }

  /**
   * Test {@link BoundedTimestampSet#getNumberOfTimestamps()}.
   *
   * <p>Method under test: {@link BoundedTimestampSet#getNumberOfTimestamps()}
   */
  @Test
  @DisplayName("Test getNumberOfTimestamps()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long BoundedTimestampSet.getNumberOfTimestamps()"})
  void testGetNumberOfTimestamps() {
    // Arrange
    BoundedTimestampSet boundedTimestampSet = new BoundedTimestampSet(TimeBucket.SECOND, 3);
    boundedTimestampSet.add(
        LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Act and Assert
    assertEquals(1L, boundedTimestampSet.getNumberOfTimestamps());
  }

  /**
   * Test {@link BoundedTimestampSet#getNumberOfTimestamps()}.
   *
   * <p>Method under test: {@link BoundedTimestampSet#getNumberOfTimestamps()}
   */
  @Test
  @DisplayName("Test getNumberOfTimestamps()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long BoundedTimestampSet.getNumberOfTimestamps()"})
  void testGetNumberOfTimestamps2() {
    // Arrange
    BoundedTimestampSet boundedTimestampSet =
        new Builder().maxSize(3).state(State.SAMPLE).timeBucket(TimeBucket.SECOND).build();
    boundedTimestampSet.add(
        LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Act and Assert
    assertEquals(1L, boundedTimestampSet.getNumberOfTimestamps());
  }

  /**
   * Test {@link BoundedTimestampSet#getNumberOfTimestamps()}.
   *
   * <p>Method under test: {@link BoundedTimestampSet#getNumberOfTimestamps()}
   */
  @Test
  @DisplayName("Test getNumberOfTimestamps()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long BoundedTimestampSet.getNumberOfTimestamps()"})
  void testGetNumberOfTimestamps3() {
    // Arrange
    BoundedTimestampSet boundedTimestampSet = new BoundedTimestampSet(TimeBucket.SECOND, 3);
    boundedTimestampSet.add(
        LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Act and Assert
    assertEquals(1L, boundedTimestampSet.getNumberOfTimestamps());
  }

  /**
   * Test {@link BoundedTimestampSet#getNumberOfTimestamps()}.
   *
   * <p>Method under test: {@link BoundedTimestampSet#getNumberOfTimestamps()}
   */
  @Test
  @DisplayName("Test getNumberOfTimestamps()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long BoundedTimestampSet.getNumberOfTimestamps()"})
  void testGetNumberOfTimestamps4() {
    // Arrange
    BoundedTimestampSet boundedTimestampSet =
        new Builder().maxSize(3).state(State.SAMPLE).timeBucket(TimeBucket.SECOND).build();
    boundedTimestampSet.add(
        LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Act and Assert
    assertEquals(1L, boundedTimestampSet.getNumberOfTimestamps());
  }

  /**
   * Test {@link BoundedTimestampSet#getNumberOfTimestamps()}.
   *
   * <ul>
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link BoundedTimestampSet#getNumberOfTimestamps()}
   */
  @Test
  @DisplayName("Test getNumberOfTimestamps(); then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long BoundedTimestampSet.getNumberOfTimestamps()"})
  void testGetNumberOfTimestamps_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0L, new BoundedTimestampSet(TimeBucket.SECOND, 3).getNumberOfTimestamps());
  }

  /**
   * Test {@link BoundedTimestampSet#getNumberOfTimestamps()}.
   *
   * <ul>
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link BoundedTimestampSet#getNumberOfTimestamps()}
   */
  @Test
  @DisplayName("Test getNumberOfTimestamps(); then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long BoundedTimestampSet.getNumberOfTimestamps()"})
  void testGetNumberOfTimestamps_thenReturnZero2() {
    // Arrange, Act and Assert
    assertEquals(0L, new BoundedTimestampSet(TimeBucket.SECOND, 3).getNumberOfTimestamps());
  }

  /**
   * Test {@link BoundedTimestampSet#getEarliest()}.
   *
   * <p>Method under test: {@link BoundedTimestampSet#getEarliest()}
   */
  @Test
  @DisplayName("Test getEarliest()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Instant BoundedTimestampSet.getEarliest()"})
  void testGetEarliest() {
    // Arrange
    BoundedTimestampSet boundedTimestampSet = new BoundedTimestampSet(TimeBucket.SECOND, 3);
    boundedTimestampSet.add(
        LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Act
    boundedTimestampSet.getEarliest();

    // Assert
    Instant instant = Instant.EPOCH;
    RBMBackedTimestampSet rbmBackedTimestampSet = boundedTimestampSet.getRbmBackedTimestampSet();
    assertSame(instant, rbmBackedTimestampSet.getEarliest());
    RBMBackedTimestampSet shallowClone = rbmBackedTimestampSet.getShallowClone();
    assertSame(instant, shallowClone.getEarliest());
    RBMBackedTimestampSet shallowClone2 = shallowClone.getShallowClone();
    assertSame(instant, shallowClone2.getEarliest());
    RBMBackedTimestampSet shallowClone3 = shallowClone2.getShallowClone();
    assertSame(instant, shallowClone3.getEarliest());
    RBMBackedTimestampSet shallowClone4 = shallowClone3.getShallowClone();
    assertSame(instant, shallowClone4.getEarliest());
    RBMBackedTimestampSet shallowClone5 = shallowClone4.getShallowClone();
    assertSame(instant, shallowClone5.getEarliest());
    assertSame(instant, rbmBackedTimestampSet.getLatest());
    assertSame(instant, shallowClone.getLatest());
    assertSame(instant, shallowClone2.getLatest());
    assertSame(instant, shallowClone3.getLatest());
    assertSame(instant, shallowClone4.getLatest());
    assertSame(instant, shallowClone5.getLatest());
  }

  /**
   * Test {@link BoundedTimestampSet#getEarliest()}.
   *
   * <p>Method under test: {@link BoundedTimestampSet#getEarliest()}
   */
  @Test
  @DisplayName("Test getEarliest()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Instant BoundedTimestampSet.getEarliest()"})
  void testGetEarliest2() {
    // Arrange
    BoundedTimestampSet boundedTimestampSet = new BoundedTimestampSet(TimeBucket.MINUTE, 3);
    boundedTimestampSet.add(
        LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Act
    boundedTimestampSet.getEarliest();

    // Assert
    Instant instant = Instant.EPOCH;
    RBMBackedTimestampSet rbmBackedTimestampSet = boundedTimestampSet.getRbmBackedTimestampSet();
    assertSame(instant, rbmBackedTimestampSet.getEarliest());
    RBMBackedTimestampSet shallowClone = rbmBackedTimestampSet.getShallowClone();
    assertSame(instant, shallowClone.getEarliest());
    RBMBackedTimestampSet shallowClone2 = shallowClone.getShallowClone();
    assertSame(instant, shallowClone2.getEarliest());
    RBMBackedTimestampSet shallowClone3 = shallowClone2.getShallowClone();
    assertSame(instant, shallowClone3.getEarliest());
    RBMBackedTimestampSet shallowClone4 = shallowClone3.getShallowClone();
    assertSame(instant, shallowClone4.getEarliest());
    RBMBackedTimestampSet shallowClone5 = shallowClone4.getShallowClone();
    assertSame(instant, shallowClone5.getEarliest());
    assertSame(instant, rbmBackedTimestampSet.getLatest());
    assertSame(instant, shallowClone.getLatest());
    assertSame(instant, shallowClone2.getLatest());
    assertSame(instant, shallowClone3.getLatest());
    assertSame(instant, shallowClone4.getLatest());
    assertSame(instant, shallowClone5.getLatest());
  }

  /**
   * Test {@link BoundedTimestampSet#getEarliest()}.
   *
   * <p>Method under test: {@link BoundedTimestampSet#getEarliest()}
   */
  @Test
  @DisplayName("Test getEarliest()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Instant BoundedTimestampSet.getEarliest()"})
  void testGetEarliest3() {
    // Arrange
    BoundedTimestampSet boundedTimestampSet = new BoundedTimestampSet(TimeBucket.HOUR, 3);
    boundedTimestampSet.add(
        LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Act
    boundedTimestampSet.getEarliest();

    // Assert
    Instant instant = Instant.EPOCH;
    RBMBackedTimestampSet rbmBackedTimestampSet = boundedTimestampSet.getRbmBackedTimestampSet();
    assertSame(instant, rbmBackedTimestampSet.getEarliest());
    RBMBackedTimestampSet shallowClone = rbmBackedTimestampSet.getShallowClone();
    assertSame(instant, shallowClone.getEarliest());
    RBMBackedTimestampSet shallowClone2 = shallowClone.getShallowClone();
    assertSame(instant, shallowClone2.getEarliest());
    RBMBackedTimestampSet shallowClone3 = shallowClone2.getShallowClone();
    assertSame(instant, shallowClone3.getEarliest());
    RBMBackedTimestampSet shallowClone4 = shallowClone3.getShallowClone();
    assertSame(instant, shallowClone4.getEarliest());
    RBMBackedTimestampSet shallowClone5 = shallowClone4.getShallowClone();
    assertSame(instant, shallowClone5.getEarliest());
    assertSame(instant, rbmBackedTimestampSet.getLatest());
    assertSame(instant, shallowClone.getLatest());
    assertSame(instant, shallowClone2.getLatest());
    assertSame(instant, shallowClone3.getLatest());
    assertSame(instant, shallowClone4.getLatest());
    assertSame(instant, shallowClone5.getLatest());
  }

  /**
   * Test {@link BoundedTimestampSet#getEarliest()}.
   *
   * <p>Method under test: {@link BoundedTimestampSet#getEarliest()}
   */
  @Test
  @DisplayName("Test getEarliest()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Instant BoundedTimestampSet.getEarliest()"})
  void testGetEarliest4() {
    // Arrange
    BoundedTimestampSet boundedTimestampSet = new BoundedTimestampSet(TimeBucket.DAY, 3);
    boundedTimestampSet.add(
        LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Act
    boundedTimestampSet.getEarliest();

    // Assert
    Instant instant = Instant.EPOCH;
    RBMBackedTimestampSet rbmBackedTimestampSet = boundedTimestampSet.getRbmBackedTimestampSet();
    assertSame(instant, rbmBackedTimestampSet.getEarliest());
    RBMBackedTimestampSet shallowClone = rbmBackedTimestampSet.getShallowClone();
    assertSame(instant, shallowClone.getEarliest());
    RBMBackedTimestampSet shallowClone2 = shallowClone.getShallowClone();
    assertSame(instant, shallowClone2.getEarliest());
    RBMBackedTimestampSet shallowClone3 = shallowClone2.getShallowClone();
    assertSame(instant, shallowClone3.getEarliest());
    RBMBackedTimestampSet shallowClone4 = shallowClone3.getShallowClone();
    assertSame(instant, shallowClone4.getEarliest());
    RBMBackedTimestampSet shallowClone5 = shallowClone4.getShallowClone();
    assertSame(instant, shallowClone5.getEarliest());
    assertSame(instant, rbmBackedTimestampSet.getLatest());
    assertSame(instant, shallowClone.getLatest());
    assertSame(instant, shallowClone2.getLatest());
    assertSame(instant, shallowClone3.getLatest());
    assertSame(instant, shallowClone4.getLatest());
    assertSame(instant, shallowClone5.getLatest());
  }

  /**
   * Test {@link BoundedTimestampSet#getEarliest()}.
   *
   * <p>Method under test: {@link BoundedTimestampSet#getEarliest()}
   */
  @Test
  @DisplayName("Test getEarliest()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Instant BoundedTimestampSet.getEarliest()"})
  void testGetEarliest5() {
    // Arrange
    BoundedTimestampSet boundedTimestampSet = new BoundedTimestampSet(TimeBucket.MONTH, 3);
    boundedTimestampSet.add(
        LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Act
    boundedTimestampSet.getEarliest();

    // Assert
    Instant instant = Instant.EPOCH;
    RBMBackedTimestampSet rbmBackedTimestampSet = boundedTimestampSet.getRbmBackedTimestampSet();
    assertSame(instant, rbmBackedTimestampSet.getEarliest());
    RBMBackedTimestampSet shallowClone = rbmBackedTimestampSet.getShallowClone();
    assertSame(instant, shallowClone.getEarliest());
    RBMBackedTimestampSet shallowClone2 = shallowClone.getShallowClone();
    assertSame(instant, shallowClone2.getEarliest());
    RBMBackedTimestampSet shallowClone3 = shallowClone2.getShallowClone();
    assertSame(instant, shallowClone3.getEarliest());
    RBMBackedTimestampSet shallowClone4 = shallowClone3.getShallowClone();
    assertSame(instant, shallowClone4.getEarliest());
    RBMBackedTimestampSet shallowClone5 = shallowClone4.getShallowClone();
    assertSame(instant, shallowClone5.getEarliest());
    assertSame(instant, rbmBackedTimestampSet.getLatest());
    assertSame(instant, shallowClone.getLatest());
    assertSame(instant, shallowClone2.getLatest());
    assertSame(instant, shallowClone3.getLatest());
    assertSame(instant, shallowClone4.getLatest());
    assertSame(instant, shallowClone5.getLatest());
  }

  /**
   * Test {@link BoundedTimestampSet#getEarliest()}.
   *
   * <p>Method under test: {@link BoundedTimestampSet#getEarliest()}
   */
  @Test
  @DisplayName("Test getEarliest()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Instant BoundedTimestampSet.getEarliest()"})
  void testGetEarliest6() {
    // Arrange
    BoundedTimestampSet boundedTimestampSet = new BoundedTimestampSet(TimeBucket.YEAR, 3);
    boundedTimestampSet.add(
        LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Act
    boundedTimestampSet.getEarliest();

    // Assert
    Instant instant = Instant.EPOCH;
    RBMBackedTimestampSet rbmBackedTimestampSet = boundedTimestampSet.getRbmBackedTimestampSet();
    assertSame(instant, rbmBackedTimestampSet.getEarliest());
    RBMBackedTimestampSet shallowClone = rbmBackedTimestampSet.getShallowClone();
    assertSame(instant, shallowClone.getEarliest());
    RBMBackedTimestampSet shallowClone2 = shallowClone.getShallowClone();
    assertSame(instant, shallowClone2.getEarliest());
    RBMBackedTimestampSet shallowClone3 = shallowClone2.getShallowClone();
    assertSame(instant, shallowClone3.getEarliest());
    RBMBackedTimestampSet shallowClone4 = shallowClone3.getShallowClone();
    assertSame(instant, shallowClone4.getEarliest());
    RBMBackedTimestampSet shallowClone5 = shallowClone4.getShallowClone();
    assertSame(instant, shallowClone5.getEarliest());
    assertSame(instant, rbmBackedTimestampSet.getLatest());
    assertSame(instant, shallowClone.getLatest());
    assertSame(instant, shallowClone2.getLatest());
    assertSame(instant, shallowClone3.getLatest());
    assertSame(instant, shallowClone4.getLatest());
    assertSame(instant, shallowClone5.getLatest());
  }

  /**
   * Test {@link BoundedTimestampSet#getEarliest()}.
   *
   * <p>Method under test: {@link BoundedTimestampSet#getEarliest()}
   */
  @Test
  @DisplayName("Test getEarliest()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Instant BoundedTimestampSet.getEarliest()"})
  void testGetEarliest7() {
    // Arrange
    BoundedTimestampSet boundedTimestampSet = new BoundedTimestampSet(TimeBucket.SECOND, 3);
    boundedTimestampSet.add(
        LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Act
    boundedTimestampSet.getEarliest();

    // Assert
    Instant instant = Instant.EPOCH;
    RBMBackedTimestampSet rbmBackedTimestampSet = boundedTimestampSet.getRbmBackedTimestampSet();
    assertSame(instant, rbmBackedTimestampSet.getEarliest());
    RBMBackedTimestampSet shallowClone = rbmBackedTimestampSet.getShallowClone();
    assertSame(instant, shallowClone.getEarliest());
    RBMBackedTimestampSet shallowClone2 = shallowClone.getShallowClone();
    assertSame(instant, shallowClone2.getEarliest());
    RBMBackedTimestampSet shallowClone3 = shallowClone2.getShallowClone();
    assertSame(instant, shallowClone3.getEarliest());
    RBMBackedTimestampSet shallowClone4 = shallowClone3.getShallowClone();
    assertSame(instant, shallowClone4.getEarliest());
    RBMBackedTimestampSet shallowClone5 = shallowClone4.getShallowClone();
    assertSame(instant, shallowClone5.getEarliest());
    assertSame(instant, rbmBackedTimestampSet.getLatest());
    assertSame(instant, shallowClone.getLatest());
    assertSame(instant, shallowClone2.getLatest());
    assertSame(instant, shallowClone3.getLatest());
    assertSame(instant, shallowClone4.getLatest());
    assertSame(instant, shallowClone5.getLatest());
  }

  /**
   * Test {@link BoundedTimestampSet#getEarliest()}.
   *
   * <p>Method under test: {@link BoundedTimestampSet#getEarliest()}
   */
  @Test
  @DisplayName("Test getEarliest()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Instant BoundedTimestampSet.getEarliest()"})
  void testGetEarliest8() {
    // Arrange
    BoundedTimestampSet boundedTimestampSet = new BoundedTimestampSet(TimeBucket.MINUTE, 3);
    boundedTimestampSet.add(
        LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Act
    boundedTimestampSet.getEarliest();

    // Assert
    Instant instant = Instant.EPOCH;
    RBMBackedTimestampSet rbmBackedTimestampSet = boundedTimestampSet.getRbmBackedTimestampSet();
    assertSame(instant, rbmBackedTimestampSet.getEarliest());
    RBMBackedTimestampSet shallowClone = rbmBackedTimestampSet.getShallowClone();
    assertSame(instant, shallowClone.getEarliest());
    RBMBackedTimestampSet shallowClone2 = shallowClone.getShallowClone();
    assertSame(instant, shallowClone2.getEarliest());
    RBMBackedTimestampSet shallowClone3 = shallowClone2.getShallowClone();
    assertSame(instant, shallowClone3.getEarliest());
    RBMBackedTimestampSet shallowClone4 = shallowClone3.getShallowClone();
    assertSame(instant, shallowClone4.getEarliest());
    RBMBackedTimestampSet shallowClone5 = shallowClone4.getShallowClone();
    assertSame(instant, shallowClone5.getEarliest());
    assertSame(instant, rbmBackedTimestampSet.getLatest());
    assertSame(instant, shallowClone.getLatest());
    assertSame(instant, shallowClone2.getLatest());
    assertSame(instant, shallowClone3.getLatest());
    assertSame(instant, shallowClone4.getLatest());
    assertSame(instant, shallowClone5.getLatest());
  }

  /**
   * Test {@link BoundedTimestampSet#getEarliest()}.
   *
   * <p>Method under test: {@link BoundedTimestampSet#getEarliest()}
   */
  @Test
  @DisplayName("Test getEarliest()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Instant BoundedTimestampSet.getEarliest()"})
  void testGetEarliest9() {
    // Arrange
    BoundedTimestampSet boundedTimestampSet = new BoundedTimestampSet(TimeBucket.HOUR, 3);
    boundedTimestampSet.add(
        LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Act
    boundedTimestampSet.getEarliest();

    // Assert
    Instant instant = Instant.EPOCH;
    RBMBackedTimestampSet rbmBackedTimestampSet = boundedTimestampSet.getRbmBackedTimestampSet();
    assertSame(instant, rbmBackedTimestampSet.getEarliest());
    RBMBackedTimestampSet shallowClone = rbmBackedTimestampSet.getShallowClone();
    assertSame(instant, shallowClone.getEarliest());
    RBMBackedTimestampSet shallowClone2 = shallowClone.getShallowClone();
    assertSame(instant, shallowClone2.getEarliest());
    RBMBackedTimestampSet shallowClone3 = shallowClone2.getShallowClone();
    assertSame(instant, shallowClone3.getEarliest());
    RBMBackedTimestampSet shallowClone4 = shallowClone3.getShallowClone();
    assertSame(instant, shallowClone4.getEarliest());
    RBMBackedTimestampSet shallowClone5 = shallowClone4.getShallowClone();
    assertSame(instant, shallowClone5.getEarliest());
    assertSame(instant, rbmBackedTimestampSet.getLatest());
    assertSame(instant, shallowClone.getLatest());
    assertSame(instant, shallowClone2.getLatest());
    assertSame(instant, shallowClone3.getLatest());
    assertSame(instant, shallowClone4.getLatest());
    assertSame(instant, shallowClone5.getLatest());
  }

  /**
   * Test {@link BoundedTimestampSet#getEarliest()}.
   *
   * <p>Method under test: {@link BoundedTimestampSet#getEarliest()}
   */
  @Test
  @DisplayName("Test getEarliest()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Instant BoundedTimestampSet.getEarliest()"})
  void testGetEarliest10() {
    // Arrange
    BoundedTimestampSet boundedTimestampSet = new BoundedTimestampSet(TimeBucket.DAY, 3);
    boundedTimestampSet.add(
        LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Act
    boundedTimestampSet.getEarliest();

    // Assert
    Instant instant = Instant.EPOCH;
    RBMBackedTimestampSet rbmBackedTimestampSet = boundedTimestampSet.getRbmBackedTimestampSet();
    assertSame(instant, rbmBackedTimestampSet.getEarliest());
    RBMBackedTimestampSet shallowClone = rbmBackedTimestampSet.getShallowClone();
    assertSame(instant, shallowClone.getEarliest());
    RBMBackedTimestampSet shallowClone2 = shallowClone.getShallowClone();
    assertSame(instant, shallowClone2.getEarliest());
    RBMBackedTimestampSet shallowClone3 = shallowClone2.getShallowClone();
    assertSame(instant, shallowClone3.getEarliest());
    RBMBackedTimestampSet shallowClone4 = shallowClone3.getShallowClone();
    assertSame(instant, shallowClone4.getEarliest());
    RBMBackedTimestampSet shallowClone5 = shallowClone4.getShallowClone();
    assertSame(instant, shallowClone5.getEarliest());
    assertSame(instant, rbmBackedTimestampSet.getLatest());
    assertSame(instant, shallowClone.getLatest());
    assertSame(instant, shallowClone2.getLatest());
    assertSame(instant, shallowClone3.getLatest());
    assertSame(instant, shallowClone4.getLatest());
    assertSame(instant, shallowClone5.getLatest());
  }

  /**
   * Test {@link BoundedTimestampSet#getEarliest()}.
   *
   * <p>Method under test: {@link BoundedTimestampSet#getEarliest()}
   */
  @Test
  @DisplayName("Test getEarliest()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Instant BoundedTimestampSet.getEarliest()"})
  void testGetEarliest11() {
    // Arrange
    BoundedTimestampSet boundedTimestampSet = new BoundedTimestampSet(TimeBucket.MONTH, 3);
    boundedTimestampSet.add(
        LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Act
    boundedTimestampSet.getEarliest();

    // Assert
    Instant instant = Instant.EPOCH;
    RBMBackedTimestampSet rbmBackedTimestampSet = boundedTimestampSet.getRbmBackedTimestampSet();
    assertSame(instant, rbmBackedTimestampSet.getEarliest());
    RBMBackedTimestampSet shallowClone = rbmBackedTimestampSet.getShallowClone();
    assertSame(instant, shallowClone.getEarliest());
    RBMBackedTimestampSet shallowClone2 = shallowClone.getShallowClone();
    assertSame(instant, shallowClone2.getEarliest());
    RBMBackedTimestampSet shallowClone3 = shallowClone2.getShallowClone();
    assertSame(instant, shallowClone3.getEarliest());
    RBMBackedTimestampSet shallowClone4 = shallowClone3.getShallowClone();
    assertSame(instant, shallowClone4.getEarliest());
    RBMBackedTimestampSet shallowClone5 = shallowClone4.getShallowClone();
    assertSame(instant, shallowClone5.getEarliest());
    assertSame(instant, rbmBackedTimestampSet.getLatest());
    assertSame(instant, shallowClone.getLatest());
    assertSame(instant, shallowClone2.getLatest());
    assertSame(instant, shallowClone3.getLatest());
    assertSame(instant, shallowClone4.getLatest());
    assertSame(instant, shallowClone5.getLatest());
  }

  /**
   * Test {@link BoundedTimestampSet#getEarliest()}.
   *
   * <p>Method under test: {@link BoundedTimestampSet#getEarliest()}
   */
  @Test
  @DisplayName("Test getEarliest()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Instant BoundedTimestampSet.getEarliest()"})
  void testGetEarliest12() {
    // Arrange
    BoundedTimestampSet boundedTimestampSet = new BoundedTimestampSet(TimeBucket.YEAR, 3);
    boundedTimestampSet.add(
        LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Act
    boundedTimestampSet.getEarliest();

    // Assert
    Instant instant = Instant.EPOCH;
    RBMBackedTimestampSet rbmBackedTimestampSet = boundedTimestampSet.getRbmBackedTimestampSet();
    assertSame(instant, rbmBackedTimestampSet.getEarliest());
    RBMBackedTimestampSet shallowClone = rbmBackedTimestampSet.getShallowClone();
    assertSame(instant, shallowClone.getEarliest());
    RBMBackedTimestampSet shallowClone2 = shallowClone.getShallowClone();
    assertSame(instant, shallowClone2.getEarliest());
    RBMBackedTimestampSet shallowClone3 = shallowClone2.getShallowClone();
    assertSame(instant, shallowClone3.getEarliest());
    RBMBackedTimestampSet shallowClone4 = shallowClone3.getShallowClone();
    assertSame(instant, shallowClone4.getEarliest());
    RBMBackedTimestampSet shallowClone5 = shallowClone4.getShallowClone();
    assertSame(instant, shallowClone5.getEarliest());
    assertSame(instant, rbmBackedTimestampSet.getLatest());
    assertSame(instant, shallowClone.getLatest());
    assertSame(instant, shallowClone2.getLatest());
    assertSame(instant, shallowClone3.getLatest());
    assertSame(instant, shallowClone4.getLatest());
    assertSame(instant, shallowClone5.getLatest());
  }

  /**
   * Test {@link BoundedTimestampSet#getEarliest()}.
   *
   * <ul>
   *   <li>Then return {@link Instant#EPOCH}.
   * </ul>
   *
   * <p>Method under test: {@link BoundedTimestampSet#getEarliest()}
   */
  @Test
  @DisplayName("Test getEarliest(); then return EPOCH")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Instant BoundedTimestampSet.getEarliest()"})
  void testGetEarliest_thenReturnEpoch() {
    // Arrange
    BoundedTimestampSet boundedTimestampSet =
        new Builder().maxSize(3).state(State.SAMPLE).timeBucket(TimeBucket.SECOND).build();
    boundedTimestampSet.add(
        LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Act and Assert
    Instant instant = Instant.EPOCH;
    assertSame(instant, boundedTimestampSet.getEarliest());
    assertSame(instant, boundedTimestampSet.getLatest());
  }

  /**
   * Test {@link BoundedTimestampSet#getEarliest()}.
   *
   * <ul>
   *   <li>Then return {@link Instant#EPOCH}.
   * </ul>
   *
   * <p>Method under test: {@link BoundedTimestampSet#getEarliest()}
   */
  @Test
  @DisplayName("Test getEarliest(); then return EPOCH")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Instant BoundedTimestampSet.getEarliest()"})
  void testGetEarliest_thenReturnEpoch2() {
    // Arrange
    BoundedTimestampSet boundedTimestampSet =
        new Builder().maxSize(3).state(State.SAMPLE).timeBucket(TimeBucket.SECOND).build();
    boundedTimestampSet.add(
        LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Act and Assert
    Instant instant = Instant.EPOCH;
    assertSame(instant, boundedTimestampSet.getEarliest());
    assertSame(instant, boundedTimestampSet.getLatest());
  }

  /**
   * Test {@link BoundedTimestampSet#getEarliest()}.
   *
   * <ul>
   *   <li>Then return EpochSecond is {@code -259200}.
   * </ul>
   *
   * <p>Method under test: {@link BoundedTimestampSet#getEarliest()}
   */
  @Test
  @DisplayName("Test getEarliest(); then return EpochSecond is '-259200'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Instant BoundedTimestampSet.getEarliest()"})
  void testGetEarliest_thenReturnEpochSecondIs259200() {
    // Arrange
    BoundedTimestampSet boundedTimestampSet = new BoundedTimestampSet(TimeBucket.WEEK, 3);
    boundedTimestampSet.add(
        LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Act
    Instant actualEarliest = boundedTimestampSet.getEarliest();

    // Assert
    assertEquals(-259200L, actualEarliest.getEpochSecond());
    assertEquals(0, actualEarliest.getNano());
  }

  /**
   * Test {@link BoundedTimestampSet#getEarliest()}.
   *
   * <ul>
   *   <li>Then return EpochSecond is {@code -259200}.
   * </ul>
   *
   * <p>Method under test: {@link BoundedTimestampSet#getEarliest()}
   */
  @Test
  @DisplayName("Test getEarliest(); then return EpochSecond is '-259200'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Instant BoundedTimestampSet.getEarliest()"})
  void testGetEarliest_thenReturnEpochSecondIs2592002() {
    // Arrange
    BoundedTimestampSet boundedTimestampSet = new BoundedTimestampSet(TimeBucket.WEEK, 3);
    boundedTimestampSet.add(
        LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Act
    Instant actualEarliest = boundedTimestampSet.getEarliest();

    // Assert
    assertEquals(-259200L, actualEarliest.getEpochSecond());
    assertEquals(0, actualEarliest.getNano());
  }

  /**
   * Test {@link BoundedTimestampSet#getEarliest()}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link BoundedTimestampSet#getEarliest()}
   */
  @Test
  @DisplayName("Test getEarliest(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Instant BoundedTimestampSet.getEarliest()"})
  void testGetEarliest_thenReturnNull() {
    // Arrange
    BoundedTimestampSet boundedTimestampSet = new BoundedTimestampSet(TimeBucket.SECOND, 3);

    // Act and Assert
    assertNull(boundedTimestampSet.getEarliest());
    assertNull(boundedTimestampSet.getLatest());
    RBMBackedTimestampSet rbmBackedTimestampSet = boundedTimestampSet.getRbmBackedTimestampSet();
    assertNull(rbmBackedTimestampSet.getEarliest());
    assertNull(rbmBackedTimestampSet.getLatest());
  }

  /**
   * Test {@link BoundedTimestampSet#getEarliest()}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link BoundedTimestampSet#getEarliest()}
   */
  @Test
  @DisplayName("Test getEarliest(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Instant BoundedTimestampSet.getEarliest()"})
  void testGetEarliest_thenReturnNull2() {
    // Arrange
    BoundedTimestampSet boundedTimestampSet = new BoundedTimestampSet(TimeBucket.SECOND, 3);

    // Act and Assert
    assertNull(boundedTimestampSet.getEarliest());
    assertNull(boundedTimestampSet.getLatest());
    RBMBackedTimestampSet rbmBackedTimestampSet = boundedTimestampSet.getRbmBackedTimestampSet();
    assertNull(rbmBackedTimestampSet.getEarliest());
    assertNull(rbmBackedTimestampSet.getLatest());
  }

  /**
   * Test {@link BoundedTimestampSet#getLatest()}.
   *
   * <p>Method under test: {@link BoundedTimestampSet#getLatest()}
   */
  @Test
  @DisplayName("Test getLatest()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Instant BoundedTimestampSet.getLatest()"})
  void testGetLatest() {
    // Arrange
    BoundedTimestampSet boundedTimestampSet = new BoundedTimestampSet(TimeBucket.SECOND, 3);

    // Act
    Instant actualLatest = boundedTimestampSet.getLatest();

    // Assert
    assertNull(boundedTimestampSet.getEarliest());
    assertNull(actualLatest);
    RBMBackedTimestampSet rbmBackedTimestampSet = boundedTimestampSet.getRbmBackedTimestampSet();
    assertNull(rbmBackedTimestampSet.getEarliest());
    assertNull(rbmBackedTimestampSet.getLatest());
  }

  /**
   * Test {@link BoundedTimestampSet#getLatest()}.
   *
   * <p>Method under test: {@link BoundedTimestampSet#getLatest()}
   */
  @Test
  @DisplayName("Test getLatest()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Instant BoundedTimestampSet.getLatest()"})
  void testGetLatest2() {
    // Arrange
    BoundedTimestampSet boundedTimestampSet = new BoundedTimestampSet(TimeBucket.SECOND, 3);
    boundedTimestampSet.add(
        LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Act
    boundedTimestampSet.getLatest();

    // Assert
    Instant instant = Instant.EPOCH;
    RBMBackedTimestampSet rbmBackedTimestampSet = boundedTimestampSet.getRbmBackedTimestampSet();
    assertSame(instant, rbmBackedTimestampSet.getEarliest());
    RBMBackedTimestampSet shallowClone = rbmBackedTimestampSet.getShallowClone();
    assertSame(instant, shallowClone.getEarliest());
    RBMBackedTimestampSet shallowClone2 = shallowClone.getShallowClone();
    assertSame(instant, shallowClone2.getEarliest());
    RBMBackedTimestampSet shallowClone3 = shallowClone2.getShallowClone();
    assertSame(instant, shallowClone3.getEarliest());
    RBMBackedTimestampSet shallowClone4 = shallowClone3.getShallowClone();
    assertSame(instant, shallowClone4.getEarliest());
    RBMBackedTimestampSet shallowClone5 = shallowClone4.getShallowClone();
    assertSame(instant, shallowClone5.getEarliest());
    assertSame(instant, rbmBackedTimestampSet.getLatest());
    assertSame(instant, shallowClone.getLatest());
    assertSame(instant, shallowClone2.getLatest());
    assertSame(instant, shallowClone3.getLatest());
    assertSame(instant, shallowClone4.getLatest());
    assertSame(instant, shallowClone5.getLatest());
  }

  /**
   * Test {@link BoundedTimestampSet#getLatest()}.
   *
   * <p>Method under test: {@link BoundedTimestampSet#getLatest()}
   */
  @Test
  @DisplayName("Test getLatest()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Instant BoundedTimestampSet.getLatest()"})
  void testGetLatest3() {
    // Arrange
    BoundedTimestampSet boundedTimestampSet = new BoundedTimestampSet(TimeBucket.MINUTE, 3);
    boundedTimestampSet.add(
        LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Act
    boundedTimestampSet.getLatest();

    // Assert
    Instant instant = Instant.EPOCH;
    RBMBackedTimestampSet rbmBackedTimestampSet = boundedTimestampSet.getRbmBackedTimestampSet();
    assertSame(instant, rbmBackedTimestampSet.getEarliest());
    RBMBackedTimestampSet shallowClone = rbmBackedTimestampSet.getShallowClone();
    assertSame(instant, shallowClone.getEarliest());
    RBMBackedTimestampSet shallowClone2 = shallowClone.getShallowClone();
    assertSame(instant, shallowClone2.getEarliest());
    RBMBackedTimestampSet shallowClone3 = shallowClone2.getShallowClone();
    assertSame(instant, shallowClone3.getEarliest());
    RBMBackedTimestampSet shallowClone4 = shallowClone3.getShallowClone();
    assertSame(instant, shallowClone4.getEarliest());
    RBMBackedTimestampSet shallowClone5 = shallowClone4.getShallowClone();
    assertSame(instant, shallowClone5.getEarliest());
    assertSame(instant, rbmBackedTimestampSet.getLatest());
    assertSame(instant, shallowClone.getLatest());
    assertSame(instant, shallowClone2.getLatest());
    assertSame(instant, shallowClone3.getLatest());
    assertSame(instant, shallowClone4.getLatest());
    assertSame(instant, shallowClone5.getLatest());
  }

  /**
   * Test {@link BoundedTimestampSet#getLatest()}.
   *
   * <p>Method under test: {@link BoundedTimestampSet#getLatest()}
   */
  @Test
  @DisplayName("Test getLatest()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Instant BoundedTimestampSet.getLatest()"})
  void testGetLatest4() {
    // Arrange
    BoundedTimestampSet boundedTimestampSet = new BoundedTimestampSet(TimeBucket.HOUR, 3);
    boundedTimestampSet.add(
        LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Act
    boundedTimestampSet.getLatest();

    // Assert
    Instant instant = Instant.EPOCH;
    RBMBackedTimestampSet rbmBackedTimestampSet = boundedTimestampSet.getRbmBackedTimestampSet();
    assertSame(instant, rbmBackedTimestampSet.getEarliest());
    RBMBackedTimestampSet shallowClone = rbmBackedTimestampSet.getShallowClone();
    assertSame(instant, shallowClone.getEarliest());
    RBMBackedTimestampSet shallowClone2 = shallowClone.getShallowClone();
    assertSame(instant, shallowClone2.getEarliest());
    RBMBackedTimestampSet shallowClone3 = shallowClone2.getShallowClone();
    assertSame(instant, shallowClone3.getEarliest());
    RBMBackedTimestampSet shallowClone4 = shallowClone3.getShallowClone();
    assertSame(instant, shallowClone4.getEarliest());
    RBMBackedTimestampSet shallowClone5 = shallowClone4.getShallowClone();
    assertSame(instant, shallowClone5.getEarliest());
    assertSame(instant, rbmBackedTimestampSet.getLatest());
    assertSame(instant, shallowClone.getLatest());
    assertSame(instant, shallowClone2.getLatest());
    assertSame(instant, shallowClone3.getLatest());
    assertSame(instant, shallowClone4.getLatest());
    assertSame(instant, shallowClone5.getLatest());
  }

  /**
   * Test {@link BoundedTimestampSet#getLatest()}.
   *
   * <p>Method under test: {@link BoundedTimestampSet#getLatest()}
   */
  @Test
  @DisplayName("Test getLatest()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Instant BoundedTimestampSet.getLatest()"})
  void testGetLatest5() {
    // Arrange
    BoundedTimestampSet boundedTimestampSet = new BoundedTimestampSet(TimeBucket.DAY, 3);
    boundedTimestampSet.add(
        LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Act
    boundedTimestampSet.getLatest();

    // Assert
    Instant instant = Instant.EPOCH;
    RBMBackedTimestampSet rbmBackedTimestampSet = boundedTimestampSet.getRbmBackedTimestampSet();
    assertSame(instant, rbmBackedTimestampSet.getEarliest());
    RBMBackedTimestampSet shallowClone = rbmBackedTimestampSet.getShallowClone();
    assertSame(instant, shallowClone.getEarliest());
    RBMBackedTimestampSet shallowClone2 = shallowClone.getShallowClone();
    assertSame(instant, shallowClone2.getEarliest());
    RBMBackedTimestampSet shallowClone3 = shallowClone2.getShallowClone();
    assertSame(instant, shallowClone3.getEarliest());
    RBMBackedTimestampSet shallowClone4 = shallowClone3.getShallowClone();
    assertSame(instant, shallowClone4.getEarliest());
    RBMBackedTimestampSet shallowClone5 = shallowClone4.getShallowClone();
    assertSame(instant, shallowClone5.getEarliest());
    assertSame(instant, rbmBackedTimestampSet.getLatest());
    assertSame(instant, shallowClone.getLatest());
    assertSame(instant, shallowClone2.getLatest());
    assertSame(instant, shallowClone3.getLatest());
    assertSame(instant, shallowClone4.getLatest());
    assertSame(instant, shallowClone5.getLatest());
  }

  /**
   * Test {@link BoundedTimestampSet#getLatest()}.
   *
   * <p>Method under test: {@link BoundedTimestampSet#getLatest()}
   */
  @Test
  @DisplayName("Test getLatest()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Instant BoundedTimestampSet.getLatest()"})
  void testGetLatest6() {
    // Arrange
    BoundedTimestampSet boundedTimestampSet = new BoundedTimestampSet(TimeBucket.MONTH, 3);
    boundedTimestampSet.add(
        LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Act
    boundedTimestampSet.getLatest();

    // Assert
    Instant instant = Instant.EPOCH;
    RBMBackedTimestampSet rbmBackedTimestampSet = boundedTimestampSet.getRbmBackedTimestampSet();
    assertSame(instant, rbmBackedTimestampSet.getEarliest());
    RBMBackedTimestampSet shallowClone = rbmBackedTimestampSet.getShallowClone();
    assertSame(instant, shallowClone.getEarliest());
    RBMBackedTimestampSet shallowClone2 = shallowClone.getShallowClone();
    assertSame(instant, shallowClone2.getEarliest());
    RBMBackedTimestampSet shallowClone3 = shallowClone2.getShallowClone();
    assertSame(instant, shallowClone3.getEarliest());
    RBMBackedTimestampSet shallowClone4 = shallowClone3.getShallowClone();
    assertSame(instant, shallowClone4.getEarliest());
    RBMBackedTimestampSet shallowClone5 = shallowClone4.getShallowClone();
    assertSame(instant, shallowClone5.getEarliest());
    assertSame(instant, rbmBackedTimestampSet.getLatest());
    assertSame(instant, shallowClone.getLatest());
    assertSame(instant, shallowClone2.getLatest());
    assertSame(instant, shallowClone3.getLatest());
    assertSame(instant, shallowClone4.getLatest());
    assertSame(instant, shallowClone5.getLatest());
  }

  /**
   * Test {@link BoundedTimestampSet#getLatest()}.
   *
   * <p>Method under test: {@link BoundedTimestampSet#getLatest()}
   */
  @Test
  @DisplayName("Test getLatest()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Instant BoundedTimestampSet.getLatest()"})
  void testGetLatest7() {
    // Arrange
    BoundedTimestampSet boundedTimestampSet = new BoundedTimestampSet(TimeBucket.YEAR, 3);
    boundedTimestampSet.add(
        LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Act
    boundedTimestampSet.getLatest();

    // Assert
    Instant instant = Instant.EPOCH;
    RBMBackedTimestampSet rbmBackedTimestampSet = boundedTimestampSet.getRbmBackedTimestampSet();
    assertSame(instant, rbmBackedTimestampSet.getEarliest());
    RBMBackedTimestampSet shallowClone = rbmBackedTimestampSet.getShallowClone();
    assertSame(instant, shallowClone.getEarliest());
    RBMBackedTimestampSet shallowClone2 = shallowClone.getShallowClone();
    assertSame(instant, shallowClone2.getEarliest());
    RBMBackedTimestampSet shallowClone3 = shallowClone2.getShallowClone();
    assertSame(instant, shallowClone3.getEarliest());
    RBMBackedTimestampSet shallowClone4 = shallowClone3.getShallowClone();
    assertSame(instant, shallowClone4.getEarliest());
    RBMBackedTimestampSet shallowClone5 = shallowClone4.getShallowClone();
    assertSame(instant, shallowClone5.getEarliest());
    assertSame(instant, rbmBackedTimestampSet.getLatest());
    assertSame(instant, shallowClone.getLatest());
    assertSame(instant, shallowClone2.getLatest());
    assertSame(instant, shallowClone3.getLatest());
    assertSame(instant, shallowClone4.getLatest());
    assertSame(instant, shallowClone5.getLatest());
  }

  /**
   * Test {@link BoundedTimestampSet#getLatest()}.
   *
   * <p>Method under test: {@link BoundedTimestampSet#getLatest()}
   */
  @Test
  @DisplayName("Test getLatest()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Instant BoundedTimestampSet.getLatest()"})
  void testGetLatest8() {
    // Arrange
    BoundedTimestampSet boundedTimestampSet =
        new Builder().maxSize(3).state(State.SAMPLE).timeBucket(TimeBucket.SECOND).build();
    boundedTimestampSet.add(
        LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Act
    Instant actualLatest = boundedTimestampSet.getLatest();

    // Assert
    Instant instant = Instant.EPOCH;
    assertSame(instant, boundedTimestampSet.getEarliest());
    assertSame(instant, actualLatest);
  }

  /**
   * Test {@link BoundedTimestampSet#getLatest()}.
   *
   * <p>Method under test: {@link BoundedTimestampSet#getLatest()}
   */
  @Test
  @DisplayName("Test getLatest()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Instant BoundedTimestampSet.getLatest()"})
  void testGetLatest9() {
    // Arrange
    BoundedTimestampSet boundedTimestampSet = new BoundedTimestampSet(TimeBucket.SECOND, 3);

    // Act
    Instant actualLatest = boundedTimestampSet.getLatest();

    // Assert
    assertNull(boundedTimestampSet.getEarliest());
    assertNull(actualLatest);
    RBMBackedTimestampSet rbmBackedTimestampSet = boundedTimestampSet.getRbmBackedTimestampSet();
    assertNull(rbmBackedTimestampSet.getEarliest());
    assertNull(rbmBackedTimestampSet.getLatest());
  }

  /**
   * Test {@link BoundedTimestampSet#getLatest()}.
   *
   * <p>Method under test: {@link BoundedTimestampSet#getLatest()}
   */
  @Test
  @DisplayName("Test getLatest()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Instant BoundedTimestampSet.getLatest()"})
  void testGetLatest10() {
    // Arrange
    BoundedTimestampSet boundedTimestampSet = new BoundedTimestampSet(TimeBucket.SECOND, 3);
    boundedTimestampSet.add(
        LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Act
    boundedTimestampSet.getLatest();

    // Assert
    Instant instant = Instant.EPOCH;
    RBMBackedTimestampSet rbmBackedTimestampSet = boundedTimestampSet.getRbmBackedTimestampSet();
    assertSame(instant, rbmBackedTimestampSet.getEarliest());
    RBMBackedTimestampSet shallowClone = rbmBackedTimestampSet.getShallowClone();
    assertSame(instant, shallowClone.getEarliest());
    RBMBackedTimestampSet shallowClone2 = shallowClone.getShallowClone();
    assertSame(instant, shallowClone2.getEarliest());
    RBMBackedTimestampSet shallowClone3 = shallowClone2.getShallowClone();
    assertSame(instant, shallowClone3.getEarliest());
    RBMBackedTimestampSet shallowClone4 = shallowClone3.getShallowClone();
    assertSame(instant, shallowClone4.getEarliest());
    RBMBackedTimestampSet shallowClone5 = shallowClone4.getShallowClone();
    assertSame(instant, shallowClone5.getEarliest());
    assertSame(instant, rbmBackedTimestampSet.getLatest());
    assertSame(instant, shallowClone.getLatest());
    assertSame(instant, shallowClone2.getLatest());
    assertSame(instant, shallowClone3.getLatest());
    assertSame(instant, shallowClone4.getLatest());
    assertSame(instant, shallowClone5.getLatest());
  }

  /**
   * Test {@link BoundedTimestampSet#getLatest()}.
   *
   * <p>Method under test: {@link BoundedTimestampSet#getLatest()}
   */
  @Test
  @DisplayName("Test getLatest()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Instant BoundedTimestampSet.getLatest()"})
  void testGetLatest11() {
    // Arrange
    BoundedTimestampSet boundedTimestampSet = new BoundedTimestampSet(TimeBucket.MINUTE, 3);
    boundedTimestampSet.add(
        LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Act
    boundedTimestampSet.getLatest();

    // Assert
    Instant instant = Instant.EPOCH;
    RBMBackedTimestampSet rbmBackedTimestampSet = boundedTimestampSet.getRbmBackedTimestampSet();
    assertSame(instant, rbmBackedTimestampSet.getEarliest());
    RBMBackedTimestampSet shallowClone = rbmBackedTimestampSet.getShallowClone();
    assertSame(instant, shallowClone.getEarliest());
    RBMBackedTimestampSet shallowClone2 = shallowClone.getShallowClone();
    assertSame(instant, shallowClone2.getEarliest());
    RBMBackedTimestampSet shallowClone3 = shallowClone2.getShallowClone();
    assertSame(instant, shallowClone3.getEarliest());
    RBMBackedTimestampSet shallowClone4 = shallowClone3.getShallowClone();
    assertSame(instant, shallowClone4.getEarliest());
    RBMBackedTimestampSet shallowClone5 = shallowClone4.getShallowClone();
    assertSame(instant, shallowClone5.getEarliest());
    assertSame(instant, rbmBackedTimestampSet.getLatest());
    assertSame(instant, shallowClone.getLatest());
    assertSame(instant, shallowClone2.getLatest());
    assertSame(instant, shallowClone3.getLatest());
    assertSame(instant, shallowClone4.getLatest());
    assertSame(instant, shallowClone5.getLatest());
  }

  /**
   * Test {@link BoundedTimestampSet#getLatest()}.
   *
   * <p>Method under test: {@link BoundedTimestampSet#getLatest()}
   */
  @Test
  @DisplayName("Test getLatest()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Instant BoundedTimestampSet.getLatest()"})
  void testGetLatest12() {
    // Arrange
    BoundedTimestampSet boundedTimestampSet = new BoundedTimestampSet(TimeBucket.HOUR, 3);
    boundedTimestampSet.add(
        LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Act
    boundedTimestampSet.getLatest();

    // Assert
    Instant instant = Instant.EPOCH;
    RBMBackedTimestampSet rbmBackedTimestampSet = boundedTimestampSet.getRbmBackedTimestampSet();
    assertSame(instant, rbmBackedTimestampSet.getEarliest());
    RBMBackedTimestampSet shallowClone = rbmBackedTimestampSet.getShallowClone();
    assertSame(instant, shallowClone.getEarliest());
    RBMBackedTimestampSet shallowClone2 = shallowClone.getShallowClone();
    assertSame(instant, shallowClone2.getEarliest());
    RBMBackedTimestampSet shallowClone3 = shallowClone2.getShallowClone();
    assertSame(instant, shallowClone3.getEarliest());
    RBMBackedTimestampSet shallowClone4 = shallowClone3.getShallowClone();
    assertSame(instant, shallowClone4.getEarliest());
    RBMBackedTimestampSet shallowClone5 = shallowClone4.getShallowClone();
    assertSame(instant, shallowClone5.getEarliest());
    assertSame(instant, rbmBackedTimestampSet.getLatest());
    assertSame(instant, shallowClone.getLatest());
    assertSame(instant, shallowClone2.getLatest());
    assertSame(instant, shallowClone3.getLatest());
    assertSame(instant, shallowClone4.getLatest());
    assertSame(instant, shallowClone5.getLatest());
  }

  /**
   * Test {@link BoundedTimestampSet#getLatest()}.
   *
   * <p>Method under test: {@link BoundedTimestampSet#getLatest()}
   */
  @Test
  @DisplayName("Test getLatest()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Instant BoundedTimestampSet.getLatest()"})
  void testGetLatest13() {
    // Arrange
    BoundedTimestampSet boundedTimestampSet = new BoundedTimestampSet(TimeBucket.DAY, 3);
    boundedTimestampSet.add(
        LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Act
    boundedTimestampSet.getLatest();

    // Assert
    Instant instant = Instant.EPOCH;
    RBMBackedTimestampSet rbmBackedTimestampSet = boundedTimestampSet.getRbmBackedTimestampSet();
    assertSame(instant, rbmBackedTimestampSet.getEarliest());
    RBMBackedTimestampSet shallowClone = rbmBackedTimestampSet.getShallowClone();
    assertSame(instant, shallowClone.getEarliest());
    RBMBackedTimestampSet shallowClone2 = shallowClone.getShallowClone();
    assertSame(instant, shallowClone2.getEarliest());
    RBMBackedTimestampSet shallowClone3 = shallowClone2.getShallowClone();
    assertSame(instant, shallowClone3.getEarliest());
    RBMBackedTimestampSet shallowClone4 = shallowClone3.getShallowClone();
    assertSame(instant, shallowClone4.getEarliest());
    RBMBackedTimestampSet shallowClone5 = shallowClone4.getShallowClone();
    assertSame(instant, shallowClone5.getEarliest());
    assertSame(instant, rbmBackedTimestampSet.getLatest());
    assertSame(instant, shallowClone.getLatest());
    assertSame(instant, shallowClone2.getLatest());
    assertSame(instant, shallowClone3.getLatest());
    assertSame(instant, shallowClone4.getLatest());
    assertSame(instant, shallowClone5.getLatest());
  }

  /**
   * Test {@link BoundedTimestampSet#getLatest()}.
   *
   * <p>Method under test: {@link BoundedTimestampSet#getLatest()}
   */
  @Test
  @DisplayName("Test getLatest()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Instant BoundedTimestampSet.getLatest()"})
  void testGetLatest14() {
    // Arrange
    BoundedTimestampSet boundedTimestampSet = new BoundedTimestampSet(TimeBucket.MONTH, 3);
    boundedTimestampSet.add(
        LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Act
    boundedTimestampSet.getLatest();

    // Assert
    Instant instant = Instant.EPOCH;
    RBMBackedTimestampSet rbmBackedTimestampSet = boundedTimestampSet.getRbmBackedTimestampSet();
    assertSame(instant, rbmBackedTimestampSet.getEarliest());
    RBMBackedTimestampSet shallowClone = rbmBackedTimestampSet.getShallowClone();
    assertSame(instant, shallowClone.getEarliest());
    RBMBackedTimestampSet shallowClone2 = shallowClone.getShallowClone();
    assertSame(instant, shallowClone2.getEarliest());
    RBMBackedTimestampSet shallowClone3 = shallowClone2.getShallowClone();
    assertSame(instant, shallowClone3.getEarliest());
    RBMBackedTimestampSet shallowClone4 = shallowClone3.getShallowClone();
    assertSame(instant, shallowClone4.getEarliest());
    RBMBackedTimestampSet shallowClone5 = shallowClone4.getShallowClone();
    assertSame(instant, shallowClone5.getEarliest());
    assertSame(instant, rbmBackedTimestampSet.getLatest());
    assertSame(instant, shallowClone.getLatest());
    assertSame(instant, shallowClone2.getLatest());
    assertSame(instant, shallowClone3.getLatest());
    assertSame(instant, shallowClone4.getLatest());
    assertSame(instant, shallowClone5.getLatest());
  }

  /**
   * Test {@link BoundedTimestampSet#getLatest()}.
   *
   * <p>Method under test: {@link BoundedTimestampSet#getLatest()}
   */
  @Test
  @DisplayName("Test getLatest()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Instant BoundedTimestampSet.getLatest()"})
  void testGetLatest15() {
    // Arrange
    BoundedTimestampSet boundedTimestampSet = new BoundedTimestampSet(TimeBucket.YEAR, 3);
    boundedTimestampSet.add(
        LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Act
    boundedTimestampSet.getLatest();

    // Assert
    Instant instant = Instant.EPOCH;
    RBMBackedTimestampSet rbmBackedTimestampSet = boundedTimestampSet.getRbmBackedTimestampSet();
    assertSame(instant, rbmBackedTimestampSet.getEarliest());
    RBMBackedTimestampSet shallowClone = rbmBackedTimestampSet.getShallowClone();
    assertSame(instant, shallowClone.getEarliest());
    RBMBackedTimestampSet shallowClone2 = shallowClone.getShallowClone();
    assertSame(instant, shallowClone2.getEarliest());
    RBMBackedTimestampSet shallowClone3 = shallowClone2.getShallowClone();
    assertSame(instant, shallowClone3.getEarliest());
    RBMBackedTimestampSet shallowClone4 = shallowClone3.getShallowClone();
    assertSame(instant, shallowClone4.getEarliest());
    RBMBackedTimestampSet shallowClone5 = shallowClone4.getShallowClone();
    assertSame(instant, shallowClone5.getEarliest());
    assertSame(instant, rbmBackedTimestampSet.getLatest());
    assertSame(instant, shallowClone.getLatest());
    assertSame(instant, shallowClone2.getLatest());
    assertSame(instant, shallowClone3.getLatest());
    assertSame(instant, shallowClone4.getLatest());
    assertSame(instant, shallowClone5.getLatest());
  }

  /**
   * Test {@link BoundedTimestampSet#getLatest()}.
   *
   * <p>Method under test: {@link BoundedTimestampSet#getLatest()}
   */
  @Test
  @DisplayName("Test getLatest()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Instant BoundedTimestampSet.getLatest()"})
  void testGetLatest16() {
    // Arrange
    BoundedTimestampSet boundedTimestampSet =
        new Builder().maxSize(3).state(State.SAMPLE).timeBucket(TimeBucket.SECOND).build();
    boundedTimestampSet.add(
        LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Act
    Instant actualLatest = boundedTimestampSet.getLatest();

    // Assert
    Instant instant = Instant.EPOCH;
    assertSame(instant, boundedTimestampSet.getEarliest());
    assertSame(instant, actualLatest);
  }

  /**
   * Test {@link BoundedTimestampSet#getLatest()}.
   *
   * <ul>
   *   <li>Then return EpochSecond is {@code -259200}.
   * </ul>
   *
   * <p>Method under test: {@link BoundedTimestampSet#getLatest()}
   */
  @Test
  @DisplayName("Test getLatest(); then return EpochSecond is '-259200'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Instant BoundedTimestampSet.getLatest()"})
  void testGetLatest_thenReturnEpochSecondIs259200() {
    // Arrange
    BoundedTimestampSet boundedTimestampSet = new BoundedTimestampSet(TimeBucket.WEEK, 3);
    boundedTimestampSet.add(
        LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Act
    Instant actualLatest = boundedTimestampSet.getLatest();

    // Assert
    assertEquals(-259200L, actualLatest.getEpochSecond());
    assertEquals(0, actualLatest.getNano());
  }

  /**
   * Test {@link BoundedTimestampSet#getLatest()}.
   *
   * <ul>
   *   <li>Then return EpochSecond is {@code -259200}.
   * </ul>
   *
   * <p>Method under test: {@link BoundedTimestampSet#getLatest()}
   */
  @Test
  @DisplayName("Test getLatest(); then return EpochSecond is '-259200'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Instant BoundedTimestampSet.getLatest()"})
  void testGetLatest_thenReturnEpochSecondIs2592002() {
    // Arrange
    BoundedTimestampSet boundedTimestampSet = new BoundedTimestampSet(TimeBucket.WEEK, 3);
    boundedTimestampSet.add(
        LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Act
    Instant actualLatest = boundedTimestampSet.getLatest();

    // Assert
    assertEquals(-259200L, actualLatest.getEpochSecond());
    assertEquals(0, actualLatest.getNano());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link BoundedTimestampSet#toString()}
   *   <li>{@link BoundedTimestampSet#getMaxSize()}
   *   <li>{@link BoundedTimestampSet#getState()}
   *   <li>{@link BoundedTimestampSet#getTimeBucket()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "int BoundedTimestampSet.getMaxSize()",
    "State BoundedTimestampSet.getState()",
    "TimeBucket BoundedTimestampSet.getTimeBucket()",
    "String BoundedTimestampSet.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    BoundedTimestampSet boundedTimestampSet =
        new Builder().maxSize(3).state(State.NOT_FULL).timeBucket(TimeBucket.SECOND).build();

    // Act
    String actualToStringResult = boundedTimestampSet.toString();
    int actualMaxSize = boundedTimestampSet.getMaxSize();
    State actualState = boundedTimestampSet.getState();

    // Assert
    assertEquals(
        "BoundedTimestampSet[timeBucket=SECOND,state=NOT_FULL,maxSize=3,timestamps=]",
        actualToStringResult);
    assertEquals(3, actualMaxSize);
    assertEquals(State.NOT_FULL, actualState);
    assertEquals(TimeBucket.SECOND, boundedTimestampSet.getTimeBucket());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link BoundedTimestampSet#toString()}
   *   <li>{@link BoundedTimestampSet#getMaxSize()}
   *   <li>{@link BoundedTimestampSet#getState()}
   *   <li>{@link BoundedTimestampSet#getTimeBucket()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "int BoundedTimestampSet.getMaxSize()",
    "State BoundedTimestampSet.getState()",
    "TimeBucket BoundedTimestampSet.getTimeBucket()",
    "String BoundedTimestampSet.toString()"
  })
  void testGettersAndSetters2() {
    // Arrange
    BoundedTimestampSet boundedTimestampSet =
        new Builder().maxSize(3).state(State.NOT_FULL).timeBucket(TimeBucket.SECOND).build();

    // Act
    String actualToStringResult = boundedTimestampSet.toString();
    int actualMaxSize = boundedTimestampSet.getMaxSize();
    State actualState = boundedTimestampSet.getState();

    // Assert
    assertEquals(
        "BoundedTimestampSet[timeBucket=SECOND,state=NOT_FULL,maxSize=3,timestamps=]",
        actualToStringResult);
    assertEquals(3, actualMaxSize);
    assertEquals(State.NOT_FULL, actualState);
    assertEquals(TimeBucket.SECOND, boundedTimestampSet.getTimeBucket());
  }

  /**
   * Test {@link BoundedTimestampSet#getRbmBackedTimestampSet()}.
   *
   * <ul>
   *   <li>Then return Earliest is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link BoundedTimestampSet#getRbmBackedTimestampSet()}
   */
  @Test
  @DisplayName("Test getRbmBackedTimestampSet(); then return Earliest is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"RBMBackedTimestampSet BoundedTimestampSet.getRbmBackedTimestampSet()"})
  void testGetRbmBackedTimestampSet_thenReturnEarliestIsNull() {
    // Arrange and Act
    RBMBackedTimestampSet actualRbmBackedTimestampSet =
        new BoundedTimestampSet(TimeBucket.SECOND, 3).getRbmBackedTimestampSet();

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
   * Test {@link BoundedTimestampSet#getRbmBackedTimestampSet()}.
   *
   * <ul>
   *   <li>Then return Earliest is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link BoundedTimestampSet#getRbmBackedTimestampSet()}
   */
  @Test
  @DisplayName("Test getRbmBackedTimestampSet(); then return Earliest is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"RBMBackedTimestampSet BoundedTimestampSet.getRbmBackedTimestampSet()"})
  void testGetRbmBackedTimestampSet_thenReturnEarliestIsNull2() {
    // Arrange and Act
    RBMBackedTimestampSet actualRbmBackedTimestampSet =
        new BoundedTimestampSet(TimeBucket.SECOND, 3).getRbmBackedTimestampSet();

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
   * Test {@link BoundedTimestampSet#getRbmBackedTimestampSet()}.
   *
   * <ul>
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link BoundedTimestampSet#getRbmBackedTimestampSet()}
   */
  @Test
  @DisplayName("Test getRbmBackedTimestampSet(); then throw RuntimeException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"RBMBackedTimestampSet BoundedTimestampSet.getRbmBackedTimestampSet()"})
  void testGetRbmBackedTimestampSet_thenThrowRuntimeException() {
    // Arrange, Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            new Builder()
                .maxSize(3)
                .state(State.SAMPLE)
                .timeBucket(TimeBucket.SECOND)
                .build()
                .getRbmBackedTimestampSet());
  }

  /**
   * Test {@link BoundedTimestampSet#getRbmBackedTimestampSet()}.
   *
   * <ul>
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link BoundedTimestampSet#getRbmBackedTimestampSet()}
   */
  @Test
  @DisplayName("Test getRbmBackedTimestampSet(); then throw RuntimeException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"RBMBackedTimestampSet BoundedTimestampSet.getRbmBackedTimestampSet()"})
  void testGetRbmBackedTimestampSet_thenThrowRuntimeException2() {
    // Arrange, Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            new Builder()
                .maxSize(3)
                .state(State.SAMPLE)
                .timeBucket(TimeBucket.SECOND)
                .build()
                .getRbmBackedTimestampSet());
  }

  /**
   * Test {@link BoundedTimestampSet#setRbmBackedTimestampSet(RBMBackedTimestampSet)}.
   *
   * <p>Method under test: {@link
   * BoundedTimestampSet#setRbmBackedTimestampSet(RBMBackedTimestampSet)}
   */
  @Test
  @DisplayName("Test setRbmBackedTimestampSet(RBMBackedTimestampSet)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BoundedTimestampSet.setRbmBackedTimestampSet(RBMBackedTimestampSet)"})
  void testSetRbmBackedTimestampSet() {
    // Arrange
    BoundedTimestampSet boundedTimestampSet = new BoundedTimestampSet(TimeBucket.SECOND, 3);
    RBMBackedTimestampSet rbmBackedTimestampSet = new RBMBackedTimestampSet(TimeBucket.SECOND);

    // Act
    boundedTimestampSet.setRbmBackedTimestampSet(rbmBackedTimestampSet);

    // Assert
    assertSame(rbmBackedTimestampSet, boundedTimestampSet.getRbmBackedTimestampSet());
  }

  /**
   * Test {@link BoundedTimestampSet#setRbmBackedTimestampSet(RBMBackedTimestampSet)}.
   *
   * <p>Method under test: {@link
   * BoundedTimestampSet#setRbmBackedTimestampSet(RBMBackedTimestampSet)}
   */
  @Test
  @DisplayName("Test setRbmBackedTimestampSet(RBMBackedTimestampSet)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BoundedTimestampSet.setRbmBackedTimestampSet(RBMBackedTimestampSet)"})
  void testSetRbmBackedTimestampSet2() {
    // Arrange
    BoundedTimestampSet boundedTimestampSet = new BoundedTimestampSet(TimeBucket.SECOND, 3);
    RBMBackedTimestampSet rbmBackedTimestampSet = new RBMBackedTimestampSet(TimeBucket.SECOND);

    // Act
    boundedTimestampSet.setRbmBackedTimestampSet(rbmBackedTimestampSet);

    // Assert
    assertSame(rbmBackedTimestampSet, boundedTimestampSet.getRbmBackedTimestampSet());
  }

  /**
   * Test {@link BoundedTimestampSet#getReservoirLongsUnion()}.
   *
   * <ul>
   *   <li>Then return Result is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link BoundedTimestampSet#getReservoirLongsUnion()}
   */
  @Test
  @DisplayName("Test getReservoirLongsUnion(); then return Result is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ReservoirLongsUnion BoundedTimestampSet.getReservoirLongsUnion()"})
  void testGetReservoirLongsUnion_thenReturnResultIsNull() {
    // Arrange and Act
    ReservoirLongsUnion actualReservoirLongsUnion =
        new Builder()
            .maxSize(3)
            .state(State.SAMPLE)
            .timeBucket(TimeBucket.SECOND)
            .build()
            .getReservoirLongsUnion();

    // Assert
    assertNull(actualReservoirLongsUnion.getResult());
    assertEquals(3, actualReservoirLongsUnion.getMaxK());
  }

  /**
   * Test {@link BoundedTimestampSet#getReservoirLongsUnion()}.
   *
   * <ul>
   *   <li>Then return Result is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link BoundedTimestampSet#getReservoirLongsUnion()}
   */
  @Test
  @DisplayName("Test getReservoirLongsUnion(); then return Result is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ReservoirLongsUnion BoundedTimestampSet.getReservoirLongsUnion()"})
  void testGetReservoirLongsUnion_thenReturnResultIsNull2() {
    // Arrange and Act
    ReservoirLongsUnion actualReservoirLongsUnion =
        new Builder()
            .maxSize(3)
            .state(State.SAMPLE)
            .timeBucket(TimeBucket.SECOND)
            .build()
            .getReservoirLongsUnion();

    // Assert
    assertNull(actualReservoirLongsUnion.getResult());
    assertEquals(3, actualReservoirLongsUnion.getMaxK());
  }

  /**
   * Test {@link BoundedTimestampSet#getReservoirLongsUnion()}.
   *
   * <ul>
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link BoundedTimestampSet#getReservoirLongsUnion()}
   */
  @Test
  @DisplayName("Test getReservoirLongsUnion(); then throw RuntimeException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ReservoirLongsUnion BoundedTimestampSet.getReservoirLongsUnion()"})
  void testGetReservoirLongsUnion_thenThrowRuntimeException() {
    // Arrange, Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> new BoundedTimestampSet(TimeBucket.SECOND, 3).getReservoirLongsUnion());
  }

  /**
   * Test {@link BoundedTimestampSet#getReservoirLongsUnion()}.
   *
   * <ul>
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link BoundedTimestampSet#getReservoirLongsUnion()}
   */
  @Test
  @DisplayName("Test getReservoirLongsUnion(); then throw RuntimeException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ReservoirLongsUnion BoundedTimestampSet.getReservoirLongsUnion()"})
  void testGetReservoirLongsUnion_thenThrowRuntimeException2() {
    // Arrange, Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> new BoundedTimestampSet(TimeBucket.SECOND, 3).getReservoirLongsUnion());
  }

  /**
   * Test {@link BoundedTimestampSet#equals(Object)}, and {@link BoundedTimestampSet#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link BoundedTimestampSet#equals(Object)}
   *   <li>{@link BoundedTimestampSet#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean BoundedTimestampSet.equals(Object)",
    "int BoundedTimestampSet.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    BoundedTimestampSet boundedTimestampSet =
        new Builder().maxSize(3).state(State.NOT_FULL).timeBucket(TimeBucket.SECOND).build();
    BoundedTimestampSet boundedTimestampSet2 =
        new Builder().maxSize(3).state(State.NOT_FULL).timeBucket(TimeBucket.SECOND).build();

    // Act and Assert
    assertEquals(boundedTimestampSet, boundedTimestampSet2);
    assertEquals(boundedTimestampSet.hashCode(), boundedTimestampSet2.hashCode());
  }

  /**
   * Test {@link BoundedTimestampSet#equals(Object)}, and {@link BoundedTimestampSet#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link BoundedTimestampSet#equals(Object)}
   *   <li>{@link BoundedTimestampSet#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean BoundedTimestampSet.equals(Object)",
    "int BoundedTimestampSet.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    BoundedTimestampSet boundedTimestampSet =
        new Builder().maxSize(3).state(State.NOT_FULL).timeBucket(TimeBucket.SECOND).build();
    BoundedTimestampSet boundedTimestampSet2 =
        new Builder().maxSize(3).state(State.NOT_FULL).timeBucket(TimeBucket.SECOND).build();

    // Act and Assert
    assertEquals(boundedTimestampSet, boundedTimestampSet2);
    assertEquals(boundedTimestampSet.hashCode(), boundedTimestampSet2.hashCode());
  }

  /**
   * Test {@link BoundedTimestampSet#equals(Object)}, and {@link BoundedTimestampSet#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link BoundedTimestampSet#equals(Object)}
   *   <li>{@link BoundedTimestampSet#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean BoundedTimestampSet.equals(Object)",
    "int BoundedTimestampSet.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    BoundedTimestampSet boundedTimestampSet =
        new Builder().maxSize(3).state(State.NOT_FULL).timeBucket(TimeBucket.SECOND).build();

    // Act and Assert
    assertEquals(boundedTimestampSet, boundedTimestampSet);
    int expectedHashCodeResult = boundedTimestampSet.hashCode();
    assertEquals(expectedHashCodeResult, boundedTimestampSet.hashCode());
  }

  /**
   * Test {@link BoundedTimestampSet#equals(Object)}, and {@link BoundedTimestampSet#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link BoundedTimestampSet#equals(Object)}
   *   <li>{@link BoundedTimestampSet#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean BoundedTimestampSet.equals(Object)",
    "int BoundedTimestampSet.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual2() {
    // Arrange
    BoundedTimestampSet boundedTimestampSet =
        new Builder().maxSize(3).state(State.NOT_FULL).timeBucket(TimeBucket.SECOND).build();

    // Act and Assert
    assertEquals(boundedTimestampSet, boundedTimestampSet);
    int expectedHashCodeResult = boundedTimestampSet.hashCode();
    assertEquals(expectedHashCodeResult, boundedTimestampSet.hashCode());
  }

  /**
   * Test {@link BoundedTimestampSet#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link BoundedTimestampSet#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean BoundedTimestampSet.equals(Object)",
    "int BoundedTimestampSet.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    BoundedTimestampSet boundedTimestampSet =
        new Builder().maxSize(1).state(State.NOT_FULL).timeBucket(TimeBucket.SECOND).build();

    // Act and Assert
    assertNotEquals(
        boundedTimestampSet,
        new Builder().maxSize(3).state(State.NOT_FULL).timeBucket(TimeBucket.SECOND).build());
  }

  /**
   * Test {@link BoundedTimestampSet#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link BoundedTimestampSet#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean BoundedTimestampSet.equals(Object)",
    "int BoundedTimestampSet.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    BoundedTimestampSet boundedTimestampSet =
        new Builder().maxSize(1).state(State.NOT_FULL).timeBucket(TimeBucket.SECOND).build();

    // Act and Assert
    assertNotEquals(
        boundedTimestampSet,
        new Builder().maxSize(3).state(State.NOT_FULL).timeBucket(TimeBucket.SECOND).build());
  }

  /**
   * Test {@link BoundedTimestampSet#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link BoundedTimestampSet#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean BoundedTimestampSet.equals(Object)",
    "int BoundedTimestampSet.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        new Builder().maxSize(3).state(State.NOT_FULL).timeBucket(TimeBucket.SECOND).build(), null);
  }

  /**
   * Test {@link BoundedTimestampSet#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link BoundedTimestampSet#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean BoundedTimestampSet.equals(Object)",
    "int BoundedTimestampSet.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual2() {
    // Arrange, Act and Assert
    assertNotEquals(
        new Builder().maxSize(3).state(State.NOT_FULL).timeBucket(TimeBucket.SECOND).build(), null);
  }

  /**
   * Test {@link BoundedTimestampSet#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link BoundedTimestampSet#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean BoundedTimestampSet.equals(Object)",
    "int BoundedTimestampSet.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        new Builder().maxSize(3).state(State.NOT_FULL).timeBucket(TimeBucket.SECOND).build(),
        "Different type to BoundedTimestampSet");
  }

  /**
   * Test {@link BoundedTimestampSet#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link BoundedTimestampSet#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean BoundedTimestampSet.equals(Object)",
    "int BoundedTimestampSet.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual2() {
    // Arrange, Act and Assert
    assertNotEquals(
        new Builder().maxSize(3).state(State.NOT_FULL).timeBucket(TimeBucket.SECOND).build(),
        "Different type to BoundedTimestampSet");
  }
}
