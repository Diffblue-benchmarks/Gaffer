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
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.time.LocalDate;
import java.time.ZoneOffset;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.time.CommonTimeUtil;
import uk.gov.gchq.gaffer.time.CommonTimeUtil.TimeBucket;
import uk.gov.gchq.gaffer.time.RBMBackedTimestampSet;
import uk.gov.gchq.gaffer.time.function.MaskTimestampSetByTimeRange.Builder;
import uk.gov.gchq.koryphe.util.TimeUnit;

class MaskTimestampSetByTimeRangeDiffblueTest {
  /**
   * Test Builder {@link Builder#build()}.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link Builder#build()}
   *   <li>{@link Builder#endTime(Long)}
   *   <li>{@link Builder#startTime(Long)}
   *   <li>{@link Builder#timeUnit(TimeUnit)}
   * </ul>
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MaskTimestampSetByTimeRange Builder.build()", "Builder Builder.endTime(Long)",
      "Builder Builder.startTime(Long)", "Builder Builder.timeUnit(TimeUnit)"})
  void testBuilderBuild() {
    // Arrange and Act
    MaskTimestampSetByTimeRange actualBuildResult = (new Builder()).endTime(1L)
        .startTime(1L)
        .timeUnit(TimeUnit.DAY)
        .build();

    // Assert
    assertEquals(1L, actualBuildResult.getEndTime().longValue());
    assertEquals(1L, actualBuildResult.getStartTime().longValue());
    assertEquals(TimeUnit.DAY, actualBuildResult.getTimeUnit());
  }

  /**
   * Test Builder new {@link Builder} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of {@link Builder}
   */
  @Test
  @DisplayName("Test Builder new Builder (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Builder.<init>()"})
  void testBuilderNewBuilder() {
    // Arrange, Act and Assert
    MaskTimestampSetByTimeRange buildResult = (new Builder()).build();
    assertNull(buildResult.getEndTime());
    assertNull(buildResult.getStartTime());
    assertEquals(TimeUnit.MILLISECOND, buildResult.getTimeUnit());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link MaskTimestampSetByTimeRange#MaskTimestampSetByTimeRange(Long, Long, TimeUnit)}
   *   <li>{@link MaskTimestampSetByTimeRange#setEndTime(Long)}
   *   <li>{@link MaskTimestampSetByTimeRange#setStartTime(Long)}
   *   <li>{@link MaskTimestampSetByTimeRange#setTimeUnit(TimeUnit)}
   *   <li>{@link MaskTimestampSetByTimeRange#getEndTime()}
   *   <li>{@link MaskTimestampSetByTimeRange#getStartTime()}
   *   <li>{@link MaskTimestampSetByTimeRange#getTimeUnit()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void MaskTimestampSetByTimeRange.<init>(Long, Long, TimeUnit)",
      "Long MaskTimestampSetByTimeRange.getEndTime()", "Long MaskTimestampSetByTimeRange.getStartTime()",
      "TimeUnit MaskTimestampSetByTimeRange.getTimeUnit()", "void MaskTimestampSetByTimeRange.setEndTime(Long)",
      "void MaskTimestampSetByTimeRange.setStartTime(Long)", "void MaskTimestampSetByTimeRange.setTimeUnit(TimeUnit)"})
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

    // Assert
    assertEquals(1L, actualEndTime.longValue());
    assertEquals(1L, actualStartTime.longValue());
    assertEquals(TimeUnit.DAY, actualTimeUnit);
  }

  /**
   * Test {@link MaskTimestampSetByTimeRange#MaskTimestampSetByTimeRange()}.
   * <p>
   * Method under test: {@link MaskTimestampSetByTimeRange#MaskTimestampSetByTimeRange()}
   */
  @Test
  @DisplayName("Test new MaskTimestampSetByTimeRange()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void MaskTimestampSetByTimeRange.<init>()"})
  void testNewMaskTimestampSetByTimeRange() {
    // Arrange and Act
    MaskTimestampSetByTimeRange actualMaskTimestampSetByTimeRange = new MaskTimestampSetByTimeRange();

    // Assert
    assertNull(actualMaskTimestampSetByTimeRange.getEndTime());
    assertNull(actualMaskTimestampSetByTimeRange.getStartTime());
    assertEquals(TimeUnit.MILLISECOND, actualMaskTimestampSetByTimeRange.getTimeUnit());
  }

  /**
   * Test {@link MaskTimestampSetByTimeRange#MaskTimestampSetByTimeRange(Long, Long)}.
   * <p>
   * Method under test: {@link MaskTimestampSetByTimeRange#MaskTimestampSetByTimeRange(Long, Long)}
   */
  @Test
  @DisplayName("Test new MaskTimestampSetByTimeRange(Long, Long)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void MaskTimestampSetByTimeRange.<init>(Long, Long)"})
  void testNewMaskTimestampSetByTimeRange2() {
    // Arrange and Act
    MaskTimestampSetByTimeRange actualMaskTimestampSetByTimeRange = new MaskTimestampSetByTimeRange(1L, 1L);

    // Assert
    assertEquals(1L, actualMaskTimestampSetByTimeRange.getEndTime().longValue());
    assertEquals(1L, actualMaskTimestampSetByTimeRange.getStartTime().longValue());
    assertEquals(TimeUnit.MILLISECOND, actualMaskTimestampSetByTimeRange.getTimeUnit());
  }

  /**
   * Test {@link MaskTimestampSetByTimeRange#apply(RBMBackedTimestampSet)} with {@code RBMBackedTimestampSet}.
   * <p>
   * Method under test: {@link MaskTimestampSetByTimeRange#apply(RBMBackedTimestampSet)}
   */
  @Test
  @DisplayName("Test apply(RBMBackedTimestampSet) with 'RBMBackedTimestampSet'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RBMBackedTimestampSet MaskTimestampSetByTimeRange.apply(RBMBackedTimestampSet)"})
  void testApplyWithRBMBackedTimestampSet() {
    // Arrange
    MaskTimestampSetByTimeRange buildResult = (new Builder()).endTime(1L).startTime(1L).timeUnit(TimeUnit.DAY).build();
    RBMBackedTimestampSet.Builder timeBucketResult = (new RBMBackedTimestampSet.Builder())
        .timeBucket(TimeBucket.SECOND);
    RBMBackedTimestampSet rbmBackedTimestampSet = timeBucketResult
        .timestamp(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant())
        .build();

    // Act
    RBMBackedTimestampSet actualApplyResult = buildResult.apply(rbmBackedTimestampSet);

    // Assert
    assertEquals(actualApplyResult, actualApplyResult.getShallowClone());
  }

  /**
   * Test {@link MaskTimestampSetByTimeRange#apply(RBMBackedTimestampSet)} with {@code RBMBackedTimestampSet}.
   * <p>
   * Method under test: {@link MaskTimestampSetByTimeRange#apply(RBMBackedTimestampSet)}
   */
  @Test
  @DisplayName("Test apply(RBMBackedTimestampSet) with 'RBMBackedTimestampSet'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RBMBackedTimestampSet MaskTimestampSetByTimeRange.apply(RBMBackedTimestampSet)"})
  void testApplyWithRBMBackedTimestampSet2() {
    // Arrange
    MaskTimestampSetByTimeRange maskTimestampSetByTimeRange = new MaskTimestampSetByTimeRange();
    maskTimestampSetByTimeRange.setStartTime(0L);
    RBMBackedTimestampSet.Builder timeBucketResult = (new RBMBackedTimestampSet.Builder())
        .timeBucket(TimeBucket.SECOND);
    RBMBackedTimestampSet rbmBackedTimestampSet = timeBucketResult
        .timestamp(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant())
        .build();

    // Act and Assert
    assertEquals(rbmBackedTimestampSet, maskTimestampSetByTimeRange.apply(rbmBackedTimestampSet));
  }

  /**
   * Test {@link MaskTimestampSetByTimeRange#apply(RBMBackedTimestampSet)} with {@code RBMBackedTimestampSet}.
   * <p>
   * Method under test: {@link MaskTimestampSetByTimeRange#apply(RBMBackedTimestampSet)}
   */
  @Test
  @DisplayName("Test apply(RBMBackedTimestampSet) with 'RBMBackedTimestampSet'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RBMBackedTimestampSet MaskTimestampSetByTimeRange.apply(RBMBackedTimestampSet)"})
  void testApplyWithRBMBackedTimestampSet3() {
    // Arrange
    MaskTimestampSetByTimeRange buildResult = (new Builder()).endTime(1L).startTime(1L).timeUnit(TimeUnit.DAY).build();
    buildResult.setStartTime(0L);
    RBMBackedTimestampSet rbmBackedTimestampSet = new RBMBackedTimestampSet(TimeBucket.MINUTE);

    // Act and Assert
    assertEquals(rbmBackedTimestampSet, buildResult.apply(rbmBackedTimestampSet));
  }

  /**
   * Test {@link MaskTimestampSetByTimeRange#apply(RBMBackedTimestampSet)} with {@code RBMBackedTimestampSet}.
   * <p>
   * Method under test: {@link MaskTimestampSetByTimeRange#apply(RBMBackedTimestampSet)}
   */
  @Test
  @DisplayName("Test apply(RBMBackedTimestampSet) with 'RBMBackedTimestampSet'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RBMBackedTimestampSet MaskTimestampSetByTimeRange.apply(RBMBackedTimestampSet)"})
  void testApplyWithRBMBackedTimestampSet4() {
    // Arrange
    MaskTimestampSetByTimeRange buildResult = (new Builder()).endTime(1L).startTime(1L).timeUnit(TimeUnit.DAY).build();
    buildResult.setStartTime(0L);
    RBMBackedTimestampSet rbmBackedTimestampSet = new RBMBackedTimestampSet(TimeBucket.HOUR);

    // Act and Assert
    assertEquals(rbmBackedTimestampSet, buildResult.apply(rbmBackedTimestampSet));
  }

  /**
   * Test {@link MaskTimestampSetByTimeRange#apply(RBMBackedTimestampSet)} with {@code RBMBackedTimestampSet}.
   * <p>
   * Method under test: {@link MaskTimestampSetByTimeRange#apply(RBMBackedTimestampSet)}
   */
  @Test
  @DisplayName("Test apply(RBMBackedTimestampSet) with 'RBMBackedTimestampSet'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RBMBackedTimestampSet MaskTimestampSetByTimeRange.apply(RBMBackedTimestampSet)"})
  void testApplyWithRBMBackedTimestampSet5() {
    // Arrange
    MaskTimestampSetByTimeRange buildResult = (new Builder()).endTime(1L).startTime(1L).timeUnit(TimeUnit.DAY).build();
    buildResult.setStartTime(0L);
    RBMBackedTimestampSet rbmBackedTimestampSet = new RBMBackedTimestampSet(TimeBucket.DAY);

    // Act and Assert
    assertEquals(rbmBackedTimestampSet, buildResult.apply(rbmBackedTimestampSet));
  }

  /**
   * Test {@link MaskTimestampSetByTimeRange#apply(RBMBackedTimestampSet)} with {@code RBMBackedTimestampSet}.
   * <p>
   * Method under test: {@link MaskTimestampSetByTimeRange#apply(RBMBackedTimestampSet)}
   */
  @Test
  @DisplayName("Test apply(RBMBackedTimestampSet) with 'RBMBackedTimestampSet'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RBMBackedTimestampSet MaskTimestampSetByTimeRange.apply(RBMBackedTimestampSet)"})
  void testApplyWithRBMBackedTimestampSet6() {
    // Arrange
    MaskTimestampSetByTimeRange maskTimestampSetByTimeRange = new MaskTimestampSetByTimeRange();
    maskTimestampSetByTimeRange.setStartTime(-1L);
    RBMBackedTimestampSet.Builder timeBucketResult = (new RBMBackedTimestampSet.Builder())
        .timeBucket(TimeBucket.SECOND);
    RBMBackedTimestampSet rbmBackedTimestampSet = timeBucketResult
        .timestamp(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant())
        .build();

    // Act
    RBMBackedTimestampSet actualApplyResult = maskTimestampSetByTimeRange.apply(rbmBackedTimestampSet);

    // Assert
    assertEquals(actualApplyResult, actualApplyResult.getShallowClone());
  }

  /**
   * Test {@link MaskTimestampSetByTimeRange#apply(RBMBackedTimestampSet)} with {@code RBMBackedTimestampSet}.
   * <p>
   * Method under test: {@link MaskTimestampSetByTimeRange#apply(RBMBackedTimestampSet)}
   */
  @Test
  @DisplayName("Test apply(RBMBackedTimestampSet) with 'RBMBackedTimestampSet'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RBMBackedTimestampSet MaskTimestampSetByTimeRange.apply(RBMBackedTimestampSet)"})
  void testApplyWithRBMBackedTimestampSet7() {
    // Arrange
    MaskTimestampSetByTimeRange maskTimestampSetByTimeRange = new MaskTimestampSetByTimeRange();
    maskTimestampSetByTimeRange.setStartTime(1000L);
    RBMBackedTimestampSet.Builder timeBucketResult = (new RBMBackedTimestampSet.Builder())
        .timeBucket(TimeBucket.SECOND);
    RBMBackedTimestampSet rbmBackedTimestampSet = timeBucketResult
        .timestamp(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant())
        .build();

    // Act
    RBMBackedTimestampSet actualApplyResult = maskTimestampSetByTimeRange.apply(rbmBackedTimestampSet);

    // Assert
    assertEquals(actualApplyResult, actualApplyResult.getShallowClone());
  }

  /**
   * Test {@link MaskTimestampSetByTimeRange#apply(RBMBackedTimestampSet)} with {@code RBMBackedTimestampSet}.
   * <p>
   * Method under test: {@link MaskTimestampSetByTimeRange#apply(RBMBackedTimestampSet)}
   */
  @Test
  @DisplayName("Test apply(RBMBackedTimestampSet) with 'RBMBackedTimestampSet'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RBMBackedTimestampSet MaskTimestampSetByTimeRange.apply(RBMBackedTimestampSet)"})
  void testApplyWithRBMBackedTimestampSet8() {
    // Arrange
    MaskTimestampSetByTimeRange maskTimestampSetByTimeRange = new MaskTimestampSetByTimeRange();
    maskTimestampSetByTimeRange.setStartTime(0L);
    RBMBackedTimestampSet.Builder timeBucketResult = (new RBMBackedTimestampSet.Builder())
        .timeBucket(TimeBucket.MINUTE);
    RBMBackedTimestampSet rbmBackedTimestampSet = timeBucketResult
        .timestamp(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant())
        .build();

    // Act and Assert
    assertEquals(rbmBackedTimestampSet, maskTimestampSetByTimeRange.apply(rbmBackedTimestampSet));
  }

  /**
   * Test {@link MaskTimestampSetByTimeRange#apply(RBMBackedTimestampSet)} with {@code RBMBackedTimestampSet}.
   * <p>
   * Method under test: {@link MaskTimestampSetByTimeRange#apply(RBMBackedTimestampSet)}
   */
  @Test
  @DisplayName("Test apply(RBMBackedTimestampSet) with 'RBMBackedTimestampSet'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RBMBackedTimestampSet MaskTimestampSetByTimeRange.apply(RBMBackedTimestampSet)"})
  void testApplyWithRBMBackedTimestampSet9() {
    // Arrange
    MaskTimestampSetByTimeRange maskTimestampSetByTimeRange = new MaskTimestampSetByTimeRange();
    maskTimestampSetByTimeRange.setStartTime(0L);
    RBMBackedTimestampSet.Builder timeBucketResult = (new RBMBackedTimestampSet.Builder()).timeBucket(TimeBucket.HOUR);
    RBMBackedTimestampSet rbmBackedTimestampSet = timeBucketResult
        .timestamp(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant())
        .build();

    // Act and Assert
    assertEquals(rbmBackedTimestampSet, maskTimestampSetByTimeRange.apply(rbmBackedTimestampSet));
  }

  /**
   * Test {@link MaskTimestampSetByTimeRange#apply(RBMBackedTimestampSet)} with {@code RBMBackedTimestampSet}.
   * <p>
   * Method under test: {@link MaskTimestampSetByTimeRange#apply(RBMBackedTimestampSet)}
   */
  @Test
  @DisplayName("Test apply(RBMBackedTimestampSet) with 'RBMBackedTimestampSet'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RBMBackedTimestampSet MaskTimestampSetByTimeRange.apply(RBMBackedTimestampSet)"})
  void testApplyWithRBMBackedTimestampSet10() {
    // Arrange
    MaskTimestampSetByTimeRange maskTimestampSetByTimeRange = new MaskTimestampSetByTimeRange();
    maskTimestampSetByTimeRange.setStartTime(0L);
    RBMBackedTimestampSet.Builder timeBucketResult = (new RBMBackedTimestampSet.Builder()).timeBucket(TimeBucket.DAY);
    RBMBackedTimestampSet rbmBackedTimestampSet = timeBucketResult
        .timestamp(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant())
        .build();

    // Act and Assert
    assertEquals(rbmBackedTimestampSet, maskTimestampSetByTimeRange.apply(rbmBackedTimestampSet));
  }

  /**
   * Test {@link MaskTimestampSetByTimeRange#apply(RBMBackedTimestampSet)} with {@code RBMBackedTimestampSet}.
   * <p>
   * Method under test: {@link MaskTimestampSetByTimeRange#apply(RBMBackedTimestampSet)}
   */
  @Test
  @DisplayName("Test apply(RBMBackedTimestampSet) with 'RBMBackedTimestampSet'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RBMBackedTimestampSet MaskTimestampSetByTimeRange.apply(RBMBackedTimestampSet)"})
  void testApplyWithRBMBackedTimestampSet11() {
    // Arrange
    MaskTimestampSetByTimeRange maskTimestampSetByTimeRange = new MaskTimestampSetByTimeRange();
    maskTimestampSetByTimeRange.setStartTime(0L);
    RBMBackedTimestampSet.Builder timeBucketResult = (new RBMBackedTimestampSet.Builder())
        .timeBucket(TimeBucket.SECOND);
    RBMBackedTimestampSet rbmBackedTimestampSet = timeBucketResult
        .timestamp(LocalDate.now().atStartOfDay().atZone(ZoneOffset.UTC).toInstant())
        .build();

    // Act and Assert
    assertEquals(rbmBackedTimestampSet, maskTimestampSetByTimeRange.apply(rbmBackedTimestampSet));
  }

  /**
   * Test {@link MaskTimestampSetByTimeRange#equals(Object)}, and {@link MaskTimestampSetByTimeRange#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link MaskTimestampSetByTimeRange#equals(Object)}
   *   <li>{@link MaskTimestampSetByTimeRange#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean MaskTimestampSetByTimeRange.equals(Object)",
      "int MaskTimestampSetByTimeRange.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    MaskTimestampSetByTimeRange buildResult = (new Builder()).endTime(1L).startTime(1L).timeUnit(TimeUnit.DAY).build();
    MaskTimestampSetByTimeRange buildResult2 = (new Builder()).endTime(1L).startTime(1L).timeUnit(TimeUnit.DAY).build();

    // Act and Assert
    assertEquals(buildResult, buildResult2);
    int expectedHashCodeResult = buildResult.hashCode();
    assertEquals(expectedHashCodeResult, buildResult2.hashCode());
  }

  /**
   * Test {@link MaskTimestampSetByTimeRange#equals(Object)}, and {@link MaskTimestampSetByTimeRange#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link MaskTimestampSetByTimeRange#equals(Object)}
   *   <li>{@link MaskTimestampSetByTimeRange#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean MaskTimestampSetByTimeRange.equals(Object)",
      "int MaskTimestampSetByTimeRange.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    MaskTimestampSetByTimeRange buildResult = (new Builder()).endTime(1L).startTime(1L).timeUnit(TimeUnit.DAY).build();

    // Act and Assert
    assertEquals(buildResult, buildResult);
    int expectedHashCodeResult = buildResult.hashCode();
    assertEquals(expectedHashCodeResult, buildResult.hashCode());
  }

  /**
   * Test {@link MaskTimestampSetByTimeRange#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link MaskTimestampSetByTimeRange#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean MaskTimestampSetByTimeRange.equals(Object)",
      "int MaskTimestampSetByTimeRange.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    MaskTimestampSetByTimeRange buildResult = (new Builder()).endTime(0L).startTime(1L).timeUnit(TimeUnit.DAY).build();
    MaskTimestampSetByTimeRange buildResult2 = (new Builder()).endTime(1L).startTime(1L).timeUnit(TimeUnit.DAY).build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link MaskTimestampSetByTimeRange#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link MaskTimestampSetByTimeRange#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean MaskTimestampSetByTimeRange.equals(Object)",
      "int MaskTimestampSetByTimeRange.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    MaskTimestampSetByTimeRange buildResult = (new Builder()).endTime(1L).startTime(0L).timeUnit(TimeUnit.DAY).build();
    MaskTimestampSetByTimeRange buildResult2 = (new Builder()).endTime(1L).startTime(1L).timeUnit(TimeUnit.DAY).build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link MaskTimestampSetByTimeRange#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link MaskTimestampSetByTimeRange#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean MaskTimestampSetByTimeRange.equals(Object)",
      "int MaskTimestampSetByTimeRange.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    MaskTimestampSetByTimeRange buildResult = (new Builder()).endTime(1L).startTime(1L).timeUnit(null).build();
    MaskTimestampSetByTimeRange buildResult2 = (new Builder()).endTime(1L).startTime(1L).timeUnit(TimeUnit.DAY).build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link MaskTimestampSetByTimeRange#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link MaskTimestampSetByTimeRange#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean MaskTimestampSetByTimeRange.equals(Object)",
      "int MaskTimestampSetByTimeRange.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    MaskTimestampSetByTimeRange buildResult = (new Builder()).endTime(1L).startTime(1L).timeUnit(TimeUnit.DAY).build();

    // Act and Assert
    assertNotEquals(buildResult, null);
  }

  /**
   * Test {@link MaskTimestampSetByTimeRange#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link MaskTimestampSetByTimeRange#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean MaskTimestampSetByTimeRange.equals(Object)",
      "int MaskTimestampSetByTimeRange.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    MaskTimestampSetByTimeRange buildResult = (new Builder()).endTime(1L).startTime(1L).timeUnit(TimeUnit.DAY).build();

    // Act and Assert
    assertNotEquals(buildResult, "Different type to MaskTimestampSetByTimeRange");
  }
}
