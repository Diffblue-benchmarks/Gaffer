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
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.time.LocalDate;
import java.time.ZoneOffset;
import org.junit.jupiter.api.Test;
import org.roaringbitmap.RoaringBitmap;
import uk.gov.gchq.gaffer.time.CommonTimeUtil;
import uk.gov.gchq.gaffer.time.RBMBackedTimestampSet;
import uk.gov.gchq.koryphe.util.TimeUnit;

class MaskTimestampSetByTimeRangeDiffblueTest {
  /**
   * Method under test:
   * {@link MaskTimestampSetByTimeRange#apply(RBMBackedTimestampSet)}
   */
  @Test
  void testApply() {
    // Arrange
    MaskTimestampSetByTimeRange maskTimestampSetByTimeRange = new MaskTimestampSetByTimeRange();
    maskTimestampSetByTimeRange.setEndTime(1L);
    maskTimestampSetByTimeRange.setStartTime(0L);
    RBMBackedTimestampSet rbmBackedTimestampSet = new RBMBackedTimestampSet(CommonTimeUtil.TimeBucket.SECOND);

    // Act and Assert
    assertEquals(rbmBackedTimestampSet, maskTimestampSetByTimeRange.apply(rbmBackedTimestampSet));
  }

  /**
   * Method under test:
   * {@link MaskTimestampSetByTimeRange#apply(RBMBackedTimestampSet)}
   */
  @Test
  void testApply2() {
    // Arrange
    MaskTimestampSetByTimeRange maskTimestampSetByTimeRange = new MaskTimestampSetByTimeRange(1L, 1L, TimeUnit.DAY);
    maskTimestampSetByTimeRange.setStartTime(0L);
    RBMBackedTimestampSet rbmBackedTimestampSet = new RBMBackedTimestampSet(CommonTimeUtil.TimeBucket.SECOND);

    // Act and Assert
    assertEquals(rbmBackedTimestampSet, maskTimestampSetByTimeRange.apply(rbmBackedTimestampSet));
  }

  /**
   * Method under test:
   * {@link MaskTimestampSetByTimeRange#apply(RBMBackedTimestampSet)}
   */
  @Test
  void testApply3() {
    // Arrange
    MaskTimestampSetByTimeRange maskTimestampSetByTimeRange = new MaskTimestampSetByTimeRange();
    maskTimestampSetByTimeRange.setStartTime(0L);
    RBMBackedTimestampSet rbmBackedTimestampSet = new RBMBackedTimestampSet(CommonTimeUtil.TimeBucket.SECOND,
        LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Act and Assert
    assertEquals(rbmBackedTimestampSet, maskTimestampSetByTimeRange.apply(rbmBackedTimestampSet));
  }

  /**
   * Method under test:
   * {@link MaskTimestampSetByTimeRange#apply(RBMBackedTimestampSet)}
   */
  @Test
  void testApply4() {
    // Arrange
    MaskTimestampSetByTimeRange maskTimestampSetByTimeRange = new MaskTimestampSetByTimeRange();
    maskTimestampSetByTimeRange.setEndTime(0L);
    maskTimestampSetByTimeRange.setStartTime(0L);
    RBMBackedTimestampSet rbmBackedTimestampSet = new RBMBackedTimestampSet(CommonTimeUtil.TimeBucket.SECOND);

    // Act and Assert
    assertEquals(rbmBackedTimestampSet, maskTimestampSetByTimeRange.apply(rbmBackedTimestampSet));
  }

  /**
   * Method under test:
   * {@link MaskTimestampSetByTimeRange#apply(RBMBackedTimestampSet)}
   */
  @Test
  void testApply5() {
    // Arrange
    MaskTimestampSetByTimeRange maskTimestampSetByTimeRange = new MaskTimestampSetByTimeRange();
    maskTimestampSetByTimeRange.setEndTime(1L);
    maskTimestampSetByTimeRange.setStartTime(0L);
    RBMBackedTimestampSet rbmBackedTimestampSet = new RBMBackedTimestampSet(CommonTimeUtil.TimeBucket.MINUTE);

    // Act and Assert
    assertEquals(rbmBackedTimestampSet, maskTimestampSetByTimeRange.apply(rbmBackedTimestampSet));
  }

  /**
   * Method under test:
   * {@link MaskTimestampSetByTimeRange#apply(RBMBackedTimestampSet)}
   */
  @Test
  void testApply6() {
    // Arrange
    MaskTimestampSetByTimeRange maskTimestampSetByTimeRange = new MaskTimestampSetByTimeRange();
    maskTimestampSetByTimeRange.setEndTime(1L);
    maskTimestampSetByTimeRange.setStartTime(0L);
    RBMBackedTimestampSet rbmBackedTimestampSet = new RBMBackedTimestampSet(CommonTimeUtil.TimeBucket.HOUR);

    // Act and Assert
    assertEquals(rbmBackedTimestampSet, maskTimestampSetByTimeRange.apply(rbmBackedTimestampSet));
  }

  /**
   * Method under test:
   * {@link MaskTimestampSetByTimeRange#apply(RBMBackedTimestampSet)}
   */
  @Test
  void testApply7() {
    // Arrange
    MaskTimestampSetByTimeRange maskTimestampSetByTimeRange = new MaskTimestampSetByTimeRange();
    maskTimestampSetByTimeRange.setEndTime(1L);
    maskTimestampSetByTimeRange.setStartTime(0L);
    RBMBackedTimestampSet rbmBackedTimestampSet = new RBMBackedTimestampSet(CommonTimeUtil.TimeBucket.DAY);

    // Act and Assert
    assertEquals(rbmBackedTimestampSet, maskTimestampSetByTimeRange.apply(rbmBackedTimestampSet));
  }

  /**
   * Method under test:
   * {@link MaskTimestampSetByTimeRange#apply(RBMBackedTimestampSet)}
   */
  @Test
  void testApply8() {
    // Arrange
    MaskTimestampSetByTimeRange maskTimestampSetByTimeRange = new MaskTimestampSetByTimeRange();
    maskTimestampSetByTimeRange.setStartTime(-1L);

    // Act
    RBMBackedTimestampSet actualApplyResult = maskTimestampSetByTimeRange.apply(new RBMBackedTimestampSet(
        CommonTimeUtil.TimeBucket.SECOND, LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    // Assert
    assertNull(actualApplyResult.getEarliest());
    assertNull(actualApplyResult.getLatest());
    RoaringBitmap rbm = actualApplyResult.getRbm();
    assertEquals(0, rbm.getCardinality());
    assertEquals(0L, actualApplyResult.getNumberOfTimestamps());
    assertEquals(8, rbm.getSizeInBytes());
    assertEquals(CommonTimeUtil.TimeBucket.SECOND, actualApplyResult.getTimeBucket());
    assertFalse(rbm.iterator().hasNext());
    assertFalse(rbm.hasRunCompression());
    assertTrue(actualApplyResult.getTimestamps().isEmpty());
    assertTrue(rbm.isEmpty());
    assertEquals(actualApplyResult, actualApplyResult.getShallowClone());
  }

  /**
   * Method under test:
   * {@link MaskTimestampSetByTimeRange#apply(RBMBackedTimestampSet)}
   */
  @Test
  void testApply9() {
    // Arrange
    MaskTimestampSetByTimeRange maskTimestampSetByTimeRange = new MaskTimestampSetByTimeRange();
    maskTimestampSetByTimeRange.setStartTime(1000L);

    // Act
    RBMBackedTimestampSet actualApplyResult = maskTimestampSetByTimeRange.apply(new RBMBackedTimestampSet(
        CommonTimeUtil.TimeBucket.SECOND, LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    // Assert
    assertNull(actualApplyResult.getEarliest());
    assertNull(actualApplyResult.getLatest());
    RoaringBitmap rbm = actualApplyResult.getRbm();
    assertEquals(0, rbm.getCardinality());
    assertEquals(0L, actualApplyResult.getNumberOfTimestamps());
    assertEquals(8, rbm.getSizeInBytes());
    assertEquals(CommonTimeUtil.TimeBucket.SECOND, actualApplyResult.getTimeBucket());
    assertFalse(rbm.iterator().hasNext());
    assertFalse(rbm.hasRunCompression());
    assertTrue(actualApplyResult.getTimestamps().isEmpty());
    assertTrue(rbm.isEmpty());
    assertEquals(actualApplyResult, actualApplyResult.getShallowClone());
  }

  /**
   * Method under test:
   * {@link MaskTimestampSetByTimeRange#apply(RBMBackedTimestampSet)}
   */
  @Test
  void testApply10() {
    // Arrange
    MaskTimestampSetByTimeRange maskTimestampSetByTimeRange = new MaskTimestampSetByTimeRange();
    maskTimestampSetByTimeRange.setStartTime(0L);
    RBMBackedTimestampSet rbmBackedTimestampSet = new RBMBackedTimestampSet(CommonTimeUtil.TimeBucket.MINUTE,
        LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Act and Assert
    assertEquals(rbmBackedTimestampSet, maskTimestampSetByTimeRange.apply(rbmBackedTimestampSet));
  }

  /**
   * Method under test:
   * {@link MaskTimestampSetByTimeRange#apply(RBMBackedTimestampSet)}
   */
  @Test
  void testApply11() {
    // Arrange
    MaskTimestampSetByTimeRange maskTimestampSetByTimeRange = new MaskTimestampSetByTimeRange();
    maskTimestampSetByTimeRange.setStartTime(0L);
    RBMBackedTimestampSet rbmBackedTimestampSet = new RBMBackedTimestampSet(CommonTimeUtil.TimeBucket.HOUR,
        LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Act and Assert
    assertEquals(rbmBackedTimestampSet, maskTimestampSetByTimeRange.apply(rbmBackedTimestampSet));
  }

  /**
   * Method under test:
   * {@link MaskTimestampSetByTimeRange#apply(RBMBackedTimestampSet)}
   */
  @Test
  void testApply12() {
    // Arrange
    MaskTimestampSetByTimeRange maskTimestampSetByTimeRange = new MaskTimestampSetByTimeRange();
    maskTimestampSetByTimeRange.setStartTime(0L);
    RBMBackedTimestampSet rbmBackedTimestampSet = new RBMBackedTimestampSet(CommonTimeUtil.TimeBucket.DAY,
        LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Act and Assert
    assertEquals(rbmBackedTimestampSet, maskTimestampSetByTimeRange.apply(rbmBackedTimestampSet));
  }

  /**
   * Method under test:
   * {@link MaskTimestampSetByTimeRange#apply(RBMBackedTimestampSet)}
   */
  @Test
  void testApply13() {
    // Arrange
    MaskTimestampSetByTimeRange maskTimestampSetByTimeRange = new MaskTimestampSetByTimeRange();
    maskTimestampSetByTimeRange.setStartTime(0L);
    RBMBackedTimestampSet rbmBackedTimestampSet = new RBMBackedTimestampSet(CommonTimeUtil.TimeBucket.SECOND,
        LocalDate.now().atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Act and Assert
    assertEquals(rbmBackedTimestampSet, maskTimestampSetByTimeRange.apply(rbmBackedTimestampSet));
  }

  /**
   * Method under test:
   * {@link MaskTimestampSetByTimeRange#apply(RBMBackedTimestampSet)}
   */
  @Test
  void testApply14() {
    // Arrange
    MaskTimestampSetByTimeRange maskTimestampSetByTimeRange = new MaskTimestampSetByTimeRange();
    maskTimestampSetByTimeRange.setStartTime(0L);

    RBMBackedTimestampSet rbmBackedTimestampSet = new RBMBackedTimestampSet(CommonTimeUtil.TimeBucket.SECOND,
        LocalDate.now().atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
    rbmBackedTimestampSet.add(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Act and Assert
    assertEquals(rbmBackedTimestampSet, maskTimestampSetByTimeRange.apply(rbmBackedTimestampSet));
  }

  /**
   * Method under test:
   * {@link MaskTimestampSetByTimeRange#apply(RBMBackedTimestampSet)}
   */
  @Test
  void testApply15() {
    // Arrange
    MaskTimestampSetByTimeRange maskTimestampSetByTimeRange = new MaskTimestampSetByTimeRange();
    maskTimestampSetByTimeRange.setStartTime(1000L);

    RBMBackedTimestampSet rbmBackedTimestampSet = new RBMBackedTimestampSet(CommonTimeUtil.TimeBucket.SECOND,
        LocalDate.now().atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
    rbmBackedTimestampSet.add(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Act
    RBMBackedTimestampSet actualApplyResult = maskTimestampSetByTimeRange.apply(rbmBackedTimestampSet);

    // Assert
    assertEquals(CommonTimeUtil.TimeBucket.SECOND, actualApplyResult.getTimeBucket());
    assertFalse(actualApplyResult.getRbm().hasRunCompression());
    assertEquals(actualApplyResult, actualApplyResult.getShallowClone());
  }

  /**
   * Method under test:
   * {@link MaskTimestampSetByTimeRange#apply(RBMBackedTimestampSet)}
   */
  @Test
  void testApply16() {
    // Arrange
    MaskTimestampSetByTimeRange maskTimestampSetByTimeRange = new MaskTimestampSetByTimeRange();
    maskTimestampSetByTimeRange.setStartTime(0L);

    RBMBackedTimestampSet rbmBackedTimestampSet = new RBMBackedTimestampSet(CommonTimeUtil.TimeBucket.DAY,
        LocalDate.now().atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
    rbmBackedTimestampSet.add(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Act and Assert
    assertEquals(rbmBackedTimestampSet, maskTimestampSetByTimeRange.apply(rbmBackedTimestampSet));
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link MaskTimestampSetByTimeRange.Builder#build()}
   *   <li>{@link MaskTimestampSetByTimeRange.Builder#endTime(Long)}
   *   <li>{@link MaskTimestampSetByTimeRange.Builder#startTime(Long)}
   *   <li>{@link MaskTimestampSetByTimeRange.Builder#timeUnit(TimeUnit)}
   * </ul>
   */
  @Test
  void testBuilderBuild() {
    // Arrange and Act
    MaskTimestampSetByTimeRange actualBuildResult = (new MaskTimestampSetByTimeRange.Builder()).endTime(1L)
        .startTime(1L)
        .timeUnit(TimeUnit.DAY)
        .build();

    // Assert
    assertEquals(1L, actualBuildResult.getEndTime().longValue());
    assertEquals(1L, actualBuildResult.getStartTime().longValue());
    assertEquals(TimeUnit.DAY, actualBuildResult.getTimeUnit());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link MaskTimestampSetByTimeRange.Builder}
   */
  @Test
  void testBuilderNewBuilder() {
    // Arrange, Act and Assert
    MaskTimestampSetByTimeRange buildResult = (new MaskTimestampSetByTimeRange.Builder()).build();
    assertNull(buildResult.getEndTime());
    assertNull(buildResult.getStartTime());
    assertEquals(TimeUnit.MILLISECOND, buildResult.getTimeUnit());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link MaskTimestampSetByTimeRange#equals(Object)}
   *   <li>{@link MaskTimestampSetByTimeRange#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    MaskTimestampSetByTimeRange maskTimestampSetByTimeRange = new MaskTimestampSetByTimeRange();
    MaskTimestampSetByTimeRange maskTimestampSetByTimeRange2 = new MaskTimestampSetByTimeRange();

    // Act and Assert
    assertEquals(maskTimestampSetByTimeRange, maskTimestampSetByTimeRange2);
    int expectedHashCodeResult = maskTimestampSetByTimeRange.hashCode();
    assertEquals(expectedHashCodeResult, maskTimestampSetByTimeRange2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link MaskTimestampSetByTimeRange#equals(Object)}
   *   <li>{@link MaskTimestampSetByTimeRange#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    MaskTimestampSetByTimeRange maskTimestampSetByTimeRange = new MaskTimestampSetByTimeRange();

    // Act and Assert
    assertEquals(maskTimestampSetByTimeRange, maskTimestampSetByTimeRange);
    int expectedHashCodeResult = maskTimestampSetByTimeRange.hashCode();
    assertEquals(expectedHashCodeResult, maskTimestampSetByTimeRange.hashCode());
  }

  /**
   * Method under test: {@link MaskTimestampSetByTimeRange#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    MaskTimestampSetByTimeRange maskTimestampSetByTimeRange = new MaskTimestampSetByTimeRange(1L, 1L);

    // Act and Assert
    assertNotEquals(maskTimestampSetByTimeRange, new MaskTimestampSetByTimeRange());
  }

  /**
   * Method under test: {@link MaskTimestampSetByTimeRange#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    MaskTimestampSetByTimeRange maskTimestampSetByTimeRange = new MaskTimestampSetByTimeRange();
    maskTimestampSetByTimeRange.setEndTime(1L);

    // Act and Assert
    assertNotEquals(maskTimestampSetByTimeRange, new MaskTimestampSetByTimeRange());
  }

  /**
   * Method under test: {@link MaskTimestampSetByTimeRange#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    MaskTimestampSetByTimeRange maskTimestampSetByTimeRange = new MaskTimestampSetByTimeRange();
    maskTimestampSetByTimeRange.setTimeUnit(TimeUnit.DAY);

    // Act and Assert
    assertNotEquals(maskTimestampSetByTimeRange, new MaskTimestampSetByTimeRange());
  }

  /**
   * Method under test: {@link MaskTimestampSetByTimeRange#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new MaskTimestampSetByTimeRange(), null);
  }

  /**
   * Method under test: {@link MaskTimestampSetByTimeRange#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new MaskTimestampSetByTimeRange(), "Different type to MaskTimestampSetByTimeRange");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>
   * {@link MaskTimestampSetByTimeRange#MaskTimestampSetByTimeRange(Long, Long, TimeUnit)}
   *   <li>{@link MaskTimestampSetByTimeRange#setEndTime(Long)}
   *   <li>{@link MaskTimestampSetByTimeRange#setStartTime(Long)}
   *   <li>{@link MaskTimestampSetByTimeRange#setTimeUnit(TimeUnit)}
   *   <li>{@link MaskTimestampSetByTimeRange#getEndTime()}
   *   <li>{@link MaskTimestampSetByTimeRange#getStartTime()}
   *   <li>{@link MaskTimestampSetByTimeRange#getTimeUnit()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    MaskTimestampSetByTimeRange actualMaskTimestampSetByTimeRange = new MaskTimestampSetByTimeRange(1L, 1L,
        TimeUnit.DAY);
    actualMaskTimestampSetByTimeRange.setEndTime(1L);
    actualMaskTimestampSetByTimeRange.setStartTime(1L);
    actualMaskTimestampSetByTimeRange.setTimeUnit(TimeUnit.DAY);
    Long actualEndTime = actualMaskTimestampSetByTimeRange.getEndTime();
    Long actualStartTime = actualMaskTimestampSetByTimeRange.getStartTime();
    TimeUnit actualTimeUnit = actualMaskTimestampSetByTimeRange.getTimeUnit();

    // Assert that nothing has changed
    assertEquals(1L, actualEndTime.longValue());
    assertEquals(1L, actualStartTime.longValue());
    assertEquals(TimeUnit.DAY, actualTimeUnit);
  }

  /**
   * Method under test:
   * {@link MaskTimestampSetByTimeRange#MaskTimestampSetByTimeRange()}
   */
  @Test
  void testNewMaskTimestampSetByTimeRange() {
    // Arrange and Act
    MaskTimestampSetByTimeRange actualMaskTimestampSetByTimeRange = new MaskTimestampSetByTimeRange();

    // Assert
    assertNull(actualMaskTimestampSetByTimeRange.getEndTime());
    assertNull(actualMaskTimestampSetByTimeRange.getStartTime());
    assertEquals(TimeUnit.MILLISECOND, actualMaskTimestampSetByTimeRange.getTimeUnit());
  }

  /**
   * Method under test:
   * {@link MaskTimestampSetByTimeRange#MaskTimestampSetByTimeRange(Long, Long)}
   */
  @Test
  void testNewMaskTimestampSetByTimeRange2() {
    // Arrange and Act
    MaskTimestampSetByTimeRange actualMaskTimestampSetByTimeRange = new MaskTimestampSetByTimeRange(1L, 1L);

    // Assert
    assertEquals(1L, actualMaskTimestampSetByTimeRange.getEndTime().longValue());
    assertEquals(1L, actualMaskTimestampSetByTimeRange.getStartTime().longValue());
    assertEquals(TimeUnit.MILLISECOND, actualMaskTimestampSetByTimeRange.getTimeUnit());
  }
}
