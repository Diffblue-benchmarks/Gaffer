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

package uk.gov.gchq.gaffer.time.function;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.time.Instant;
import java.util.Iterator;
import org.junit.jupiter.api.Test;
import org.roaringbitmap.RoaringBitmap;
import uk.gov.gchq.gaffer.time.BoundedTimestampSet;
import uk.gov.gchq.gaffer.time.CommonTimeUtil;
import uk.gov.gchq.gaffer.time.RBMBackedTimestampSet;
import uk.gov.gchq.gaffer.time.TimestampSet;

class ToTimestampSetDiffblueTest {
  /**
   * Method under test: {@link ToTimestampSet#apply(Long)}
   */
  @Test
  void testApply() {
    // Arrange and Act
    TimestampSet actualApplyResult = (new ToTimestampSet(CommonTimeUtil.TimeBucket.SECOND, true)).apply(10L);

    // Assert
    assertTrue(actualApplyResult instanceof RBMBackedTimestampSet);
    Instant earliest = actualApplyResult.getEarliest();
    assertEquals(0, earliest.getNano());
    assertEquals(1, actualApplyResult.getTimestamps().size());
    RoaringBitmap rbm = ((RBMBackedTimestampSet) actualApplyResult).getRbm();
    assertEquals(1, rbm.getCardinality());
    Iterator<Integer> iteratorResult = rbm.iterator();
    assertEquals(10, iteratorResult.next().intValue());
    assertEquals(10L, earliest.getEpochSecond());
    assertEquals(1L, actualApplyResult.getNumberOfTimestamps());
    assertEquals(CommonTimeUtil.TimeBucket.SECOND, ((RBMBackedTimestampSet) actualApplyResult).getTimeBucket());
    assertFalse(iteratorResult.hasNext());
    assertFalse(rbm.hasRunCompression());
    assertFalse(rbm.isEmpty());
    assertEquals(earliest, actualApplyResult.getLatest());
    assertEquals(actualApplyResult, ((RBMBackedTimestampSet) actualApplyResult).getShallowClone());
    assertEquals(Short.SIZE, rbm.getSizeInBytes());
  }

  /**
   * Method under test: {@link ToTimestampSet#apply(Long)}
   */
  @Test
  void testApply2() {
    // Arrange and Act
    TimestampSet actualApplyResult = (new ToTimestampSet(CommonTimeUtil.TimeBucket.MINUTE, true)).apply(10L);

    // Assert
    assertTrue(actualApplyResult instanceof RBMBackedTimestampSet);
    RoaringBitmap rbm = ((RBMBackedTimestampSet) actualApplyResult).getRbm();
    Iterator<Integer> iteratorResult = rbm.iterator();
    assertEquals(0, iteratorResult.next().intValue());
    Instant earliest = actualApplyResult.getEarliest();
    assertEquals(0, earliest.getNano());
    assertEquals(0L, earliest.getEpochSecond());
    assertEquals(1, actualApplyResult.getTimestamps().size());
    assertEquals(1, rbm.getCardinality());
    assertEquals(1L, actualApplyResult.getNumberOfTimestamps());
    assertEquals(CommonTimeUtil.TimeBucket.MINUTE, ((RBMBackedTimestampSet) actualApplyResult).getTimeBucket());
    assertFalse(iteratorResult.hasNext());
    assertFalse(rbm.hasRunCompression());
    assertFalse(rbm.isEmpty());
    assertEquals(actualApplyResult, ((RBMBackedTimestampSet) actualApplyResult).getShallowClone());
    assertEquals(Short.SIZE, rbm.getSizeInBytes());
    assertSame(earliest, actualApplyResult.getLatest());
  }

  /**
   * Method under test: {@link ToTimestampSet#apply(Long)}
   */
  @Test
  void testApply3() {
    // Arrange and Act
    TimestampSet actualApplyResult = (new ToTimestampSet(CommonTimeUtil.TimeBucket.HOUR, true)).apply(10L);

    // Assert
    assertTrue(actualApplyResult instanceof RBMBackedTimestampSet);
    RoaringBitmap rbm = ((RBMBackedTimestampSet) actualApplyResult).getRbm();
    Iterator<Integer> iteratorResult = rbm.iterator();
    assertEquals(0, iteratorResult.next().intValue());
    Instant earliest = actualApplyResult.getEarliest();
    assertEquals(0, earliest.getNano());
    assertEquals(0L, earliest.getEpochSecond());
    assertEquals(1, actualApplyResult.getTimestamps().size());
    assertEquals(1, rbm.getCardinality());
    assertEquals(1L, actualApplyResult.getNumberOfTimestamps());
    assertEquals(CommonTimeUtil.TimeBucket.HOUR, ((RBMBackedTimestampSet) actualApplyResult).getTimeBucket());
    assertFalse(iteratorResult.hasNext());
    assertFalse(rbm.hasRunCompression());
    assertFalse(rbm.isEmpty());
    assertEquals(actualApplyResult, ((RBMBackedTimestampSet) actualApplyResult).getShallowClone());
    assertEquals(Short.SIZE, rbm.getSizeInBytes());
    assertSame(earliest, actualApplyResult.getLatest());
  }

  /**
   * Method under test: {@link ToTimestampSet#apply(Long)}
   */
  @Test
  void testApply4() {
    // Arrange and Act
    TimestampSet actualApplyResult = (new ToTimestampSet(CommonTimeUtil.TimeBucket.DAY, true)).apply(10L);

    // Assert
    assertTrue(actualApplyResult instanceof RBMBackedTimestampSet);
    RoaringBitmap rbm = ((RBMBackedTimestampSet) actualApplyResult).getRbm();
    Iterator<Integer> iteratorResult = rbm.iterator();
    assertEquals(0, iteratorResult.next().intValue());
    Instant earliest = actualApplyResult.getEarliest();
    assertEquals(0, earliest.getNano());
    assertEquals(0L, earliest.getEpochSecond());
    assertEquals(1, actualApplyResult.getTimestamps().size());
    assertEquals(1, rbm.getCardinality());
    assertEquals(1L, actualApplyResult.getNumberOfTimestamps());
    assertEquals(CommonTimeUtil.TimeBucket.DAY, ((RBMBackedTimestampSet) actualApplyResult).getTimeBucket());
    assertFalse(iteratorResult.hasNext());
    assertFalse(rbm.hasRunCompression());
    assertFalse(rbm.isEmpty());
    assertEquals(actualApplyResult, ((RBMBackedTimestampSet) actualApplyResult).getShallowClone());
    assertEquals(Short.SIZE, rbm.getSizeInBytes());
    assertSame(earliest, actualApplyResult.getLatest());
  }

  /**
   * Method under test: {@link ToTimestampSet#apply(Long)}
   */
  @Test
  void testApply5() {
    // Arrange and Act
    TimestampSet actualApplyResult = (new ToTimestampSet(CommonTimeUtil.TimeBucket.SECOND, 3)).apply(10L);

    // Assert
    assertTrue(actualApplyResult instanceof BoundedTimestampSet);
    RBMBackedTimestampSet rbmBackedTimestampSet = ((BoundedTimestampSet) actualApplyResult).getRbmBackedTimestampSet();
    RoaringBitmap rbm = rbmBackedTimestampSet.getRbm();
    Iterator<Integer> iteratorResult = rbm.iterator();
    assertEquals(0, iteratorResult.next().intValue());
    Instant earliest = actualApplyResult.getEarliest();
    assertEquals(0, earliest.getNano());
    assertEquals(0L, earliest.getEpochSecond());
    assertEquals(1, rbmBackedTimestampSet.getTimestamps().size());
    assertEquals(1, actualApplyResult.getTimestamps().size());
    assertEquals(1, rbm.getCardinality());
    assertEquals(1L, rbmBackedTimestampSet.getNumberOfTimestamps());
    assertEquals(1L, actualApplyResult.getNumberOfTimestamps());
    assertEquals(3, ((BoundedTimestampSet) actualApplyResult).getMaxSize());
    assertEquals(BoundedTimestampSet.State.NOT_FULL, ((BoundedTimestampSet) actualApplyResult).getState());
    assertEquals(CommonTimeUtil.TimeBucket.SECOND, ((BoundedTimestampSet) actualApplyResult).getTimeBucket());
    assertEquals(CommonTimeUtil.TimeBucket.SECOND, rbmBackedTimestampSet.getTimeBucket());
    assertFalse(iteratorResult.hasNext());
    assertFalse(rbm.hasRunCompression());
    assertFalse(rbm.isEmpty());
    assertEquals(rbmBackedTimestampSet, rbmBackedTimestampSet.getShallowClone());
    assertEquals(Short.SIZE, rbm.getSizeInBytes());
    assertSame(earliest, rbmBackedTimestampSet.getEarliest());
    assertSame(earliest, rbmBackedTimestampSet.getLatest());
    assertSame(earliest, actualApplyResult.getLatest());
  }

  /**
   * Method under test: {@link ToTimestampSet#apply(Long)}
   */
  @Test
  void testApply6() {
    // Arrange and Act
    TimestampSet actualApplyResult = (new ToTimestampSet(CommonTimeUtil.TimeBucket.WEEK, true)).apply(10L);

    // Assert
    assertTrue(actualApplyResult instanceof RBMBackedTimestampSet);
    Instant earliest = actualApplyResult.getEarliest();
    assertEquals(-259200L, earliest.getEpochSecond());
    RoaringBitmap rbm = ((RBMBackedTimestampSet) actualApplyResult).getRbm();
    Iterator<Integer> iteratorResult = rbm.iterator();
    assertEquals(-3, iteratorResult.next().intValue());
    assertEquals(0, earliest.getNano());
    assertEquals(1, actualApplyResult.getTimestamps().size());
    assertEquals(1, rbm.getCardinality());
    assertEquals(1L, actualApplyResult.getNumberOfTimestamps());
    assertEquals(CommonTimeUtil.TimeBucket.WEEK, ((RBMBackedTimestampSet) actualApplyResult).getTimeBucket());
    assertFalse(iteratorResult.hasNext());
    assertFalse(rbm.hasRunCompression());
    assertFalse(rbm.isEmpty());
    assertEquals(earliest, actualApplyResult.getLatest());
    assertEquals(Short.SIZE, rbm.getSizeInBytes());
  }

  /**
   * Method under test: {@link ToTimestampSet#apply(Long)}
   */
  @Test
  void testApply7() {
    // Arrange and Act
    TimestampSet actualApplyResult = (new ToTimestampSet(CommonTimeUtil.TimeBucket.MONTH, true)).apply(10L);

    // Assert
    assertTrue(actualApplyResult instanceof RBMBackedTimestampSet);
    RoaringBitmap rbm = ((RBMBackedTimestampSet) actualApplyResult).getRbm();
    Iterator<Integer> iteratorResult = rbm.iterator();
    assertEquals(0, iteratorResult.next().intValue());
    Instant earliest = actualApplyResult.getEarliest();
    assertEquals(0, earliest.getNano());
    assertEquals(0L, earliest.getEpochSecond());
    assertEquals(1, actualApplyResult.getTimestamps().size());
    assertEquals(1, rbm.getCardinality());
    assertEquals(1L, actualApplyResult.getNumberOfTimestamps());
    assertEquals(CommonTimeUtil.TimeBucket.MONTH, ((RBMBackedTimestampSet) actualApplyResult).getTimeBucket());
    assertFalse(iteratorResult.hasNext());
    assertFalse(rbm.hasRunCompression());
    assertFalse(rbm.isEmpty());
    assertEquals(actualApplyResult, ((RBMBackedTimestampSet) actualApplyResult).getShallowClone());
    assertEquals(Short.SIZE, rbm.getSizeInBytes());
    assertSame(earliest, actualApplyResult.getLatest());
  }

  /**
   * Method under test: {@link ToTimestampSet#apply(Long)}
   */
  @Test
  void testApply8() {
    // Arrange and Act
    TimestampSet actualApplyResult = (new ToTimestampSet(CommonTimeUtil.TimeBucket.YEAR, true)).apply(10L);

    // Assert
    assertTrue(actualApplyResult instanceof RBMBackedTimestampSet);
    RoaringBitmap rbm = ((RBMBackedTimestampSet) actualApplyResult).getRbm();
    Iterator<Integer> iteratorResult = rbm.iterator();
    assertEquals(0, iteratorResult.next().intValue());
    Instant earliest = actualApplyResult.getEarliest();
    assertEquals(0, earliest.getNano());
    assertEquals(0L, earliest.getEpochSecond());
    assertEquals(1, actualApplyResult.getTimestamps().size());
    assertEquals(1, rbm.getCardinality());
    assertEquals(1L, actualApplyResult.getNumberOfTimestamps());
    assertEquals(CommonTimeUtil.TimeBucket.YEAR, ((RBMBackedTimestampSet) actualApplyResult).getTimeBucket());
    assertFalse(iteratorResult.hasNext());
    assertFalse(rbm.hasRunCompression());
    assertFalse(rbm.isEmpty());
    assertEquals(actualApplyResult, ((RBMBackedTimestampSet) actualApplyResult).getShallowClone());
    assertEquals(Short.SIZE, rbm.getSizeInBytes());
    assertSame(earliest, actualApplyResult.getLatest());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ToTimestampSet#ToTimestampSet()}
   *   <li>{@link ToTimestampSet#setBucket(CommonTimeUtil.TimeBucket)}
   *   <li>{@link ToTimestampSet#setMaxSize(Integer)}
   *   <li>{@link ToTimestampSet#setMillisCorrection(long)}
   *   <li>{@link ToTimestampSet#getBucket()}
   *   <li>{@link ToTimestampSet#getMaxSize()}
   *   <li>{@link ToTimestampSet#getMillisCorrection()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    ToTimestampSet actualToTimestampSet = new ToTimestampSet();
    actualToTimestampSet.setBucket(CommonTimeUtil.TimeBucket.SECOND);
    actualToTimestampSet.setMaxSize(3);
    actualToTimestampSet.setMillisCorrection(1L);
    CommonTimeUtil.TimeBucket actualBucket = actualToTimestampSet.getBucket();
    Integer actualMaxSize = actualToTimestampSet.getMaxSize();

    // Assert that nothing has changed
    assertEquals(1L, actualToTimestampSet.getMillisCorrection());
    assertEquals(3, actualMaxSize.intValue());
    assertEquals(CommonTimeUtil.TimeBucket.SECOND, actualBucket);
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ToTimestampSet#ToTimestampSet(CommonTimeUtil.TimeBucket, Integer)}
   *   <li>{@link ToTimestampSet#setBucket(CommonTimeUtil.TimeBucket)}
   *   <li>{@link ToTimestampSet#setMaxSize(Integer)}
   *   <li>{@link ToTimestampSet#setMillisCorrection(long)}
   *   <li>{@link ToTimestampSet#getBucket()}
   *   <li>{@link ToTimestampSet#getMaxSize()}
   *   <li>{@link ToTimestampSet#getMillisCorrection()}
   * </ul>
   */
  @Test
  void testGettersAndSetters2() {
    // Arrange and Act
    ToTimestampSet actualToTimestampSet = new ToTimestampSet(CommonTimeUtil.TimeBucket.SECOND, 3);
    actualToTimestampSet.setBucket(CommonTimeUtil.TimeBucket.SECOND);
    actualToTimestampSet.setMaxSize(3);
    actualToTimestampSet.setMillisCorrection(1L);
    CommonTimeUtil.TimeBucket actualBucket = actualToTimestampSet.getBucket();
    Integer actualMaxSize = actualToTimestampSet.getMaxSize();

    // Assert that nothing has changed
    assertEquals(1L, actualToTimestampSet.getMillisCorrection());
    assertEquals(3, actualMaxSize.intValue());
    assertEquals(CommonTimeUtil.TimeBucket.SECOND, actualBucket);
  }

  /**
   * Method under test:
   * {@link ToTimestampSet#ToTimestampSet(CommonTimeUtil.TimeBucket, boolean)}
   */
  @Test
  void testNewToTimestampSet() {
    // Arrange and Act
    ToTimestampSet actualToTimestampSet = new ToTimestampSet(CommonTimeUtil.TimeBucket.SECOND, true);

    // Assert
    assertNull(actualToTimestampSet.getMaxSize());
    assertEquals(1000L, actualToTimestampSet.getMillisCorrection());
    assertEquals(CommonTimeUtil.TimeBucket.SECOND, actualToTimestampSet.getBucket());
  }

  /**
   * Method under test:
   * {@link ToTimestampSet#ToTimestampSet(CommonTimeUtil.TimeBucket, boolean)}
   */
  @Test
  void testNewToTimestampSet2() {
    // Arrange and Act
    ToTimestampSet actualToTimestampSet = new ToTimestampSet(CommonTimeUtil.TimeBucket.SECOND, false);

    // Assert
    assertNull(actualToTimestampSet.getMaxSize());
    assertEquals(1L, actualToTimestampSet.getMillisCorrection());
    assertEquals(CommonTimeUtil.TimeBucket.SECOND, actualToTimestampSet.getBucket());
  }
}
