package uk.gov.gchq.gaffer.time.function;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.Iterator;
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
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Builder#build()}
   *   <li>{@link Builder#endTime(Long)}
   *   <li>{@link Builder#startTime(Long)}
   *   <li>{@link Builder#timeUnit(TimeUnit)}
   * </ul>
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "MaskTimestampSetByTimeRange Builder.build()",
    "Builder Builder.endTime(Long)",
    "Builder Builder.startTime(Long)",
    "Builder Builder.timeUnit(TimeUnit)"
  })
  void testBuilderBuild() {
    // Arrange and Act
    MaskTimestampSetByTimeRange actualMaskTimestampSetByTimeRange =
        new Builder().endTime(1L).startTime(1L).timeUnit(TimeUnit.DAY).build();

    // Assert
    assertEquals(1L, actualMaskTimestampSetByTimeRange.getEndTime().longValue());
    assertEquals(1L, actualMaskTimestampSetByTimeRange.getStartTime().longValue());
    assertEquals(TimeUnit.DAY, actualMaskTimestampSetByTimeRange.getTimeUnit());
  }

  /**
   * Test Builder new {@link Builder} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link Builder}
   */
  @Test
  @DisplayName("Test Builder new Builder (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Builder.<init>()"})
  void testBuilderNewBuilder() {
    // Arrange, Act and Assert
    MaskTimestampSetByTimeRange maskTimestampSetByTimeRange = new Builder().build();
    assertNull(maskTimestampSetByTimeRange.getEndTime());
    assertNull(maskTimestampSetByTimeRange.getStartTime());
    assertEquals(TimeUnit.MILLISECOND, maskTimestampSetByTimeRange.getTimeUnit());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void MaskTimestampSetByTimeRange.<init>(Long, Long, TimeUnit)",
    "Long MaskTimestampSetByTimeRange.getEndTime()",
    "Long MaskTimestampSetByTimeRange.getStartTime()",
    "TimeUnit MaskTimestampSetByTimeRange.getTimeUnit()",
    "void MaskTimestampSetByTimeRange.setEndTime(Long)",
    "void MaskTimestampSetByTimeRange.setStartTime(Long)",
    "void MaskTimestampSetByTimeRange.setTimeUnit(TimeUnit)"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    MaskTimestampSetByTimeRange actualMaskTimestampSetByTimeRange =
        new MaskTimestampSetByTimeRange(1L, 1L, TimeUnit.DAY);
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
   *
   * <p>Method under test: {@link MaskTimestampSetByTimeRange#MaskTimestampSetByTimeRange()}
   */
  @Test
  @DisplayName("Test new MaskTimestampSetByTimeRange()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MaskTimestampSetByTimeRange.<init>()"})
  void testNewMaskTimestampSetByTimeRange() {
    // Arrange and Act
    MaskTimestampSetByTimeRange actualMaskTimestampSetByTimeRange =
        new MaskTimestampSetByTimeRange();

    // Assert
    assertNull(actualMaskTimestampSetByTimeRange.getEndTime());
    assertNull(actualMaskTimestampSetByTimeRange.getStartTime());
    assertEquals(TimeUnit.MILLISECOND, actualMaskTimestampSetByTimeRange.getTimeUnit());
  }

  /**
   * Test {@link MaskTimestampSetByTimeRange#MaskTimestampSetByTimeRange(Long, Long)}.
   *
   * <p>Method under test: {@link MaskTimestampSetByTimeRange#MaskTimestampSetByTimeRange(Long,
   * Long)}
   */
  @Test
  @DisplayName("Test new MaskTimestampSetByTimeRange(Long, Long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MaskTimestampSetByTimeRange.<init>(Long, Long)"})
  void testNewMaskTimestampSetByTimeRange2() {
    // Arrange and Act
    MaskTimestampSetByTimeRange actualMaskTimestampSetByTimeRange =
        new MaskTimestampSetByTimeRange(1L, 1L);

    // Assert
    assertEquals(1L, actualMaskTimestampSetByTimeRange.getEndTime().longValue());
    assertEquals(1L, actualMaskTimestampSetByTimeRange.getStartTime().longValue());
    assertEquals(TimeUnit.MILLISECOND, actualMaskTimestampSetByTimeRange.getTimeUnit());
  }

  /**
   * Test {@link MaskTimestampSetByTimeRange#apply(RBMBackedTimestampSet)} with {@code
   * RBMBackedTimestampSet}.
   *
   * <p>Method under test: {@link MaskTimestampSetByTimeRange#apply(RBMBackedTimestampSet)}
   */
  @Test
  @DisplayName("Test apply(RBMBackedTimestampSet) with 'RBMBackedTimestampSet'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "RBMBackedTimestampSet MaskTimestampSetByTimeRange.apply(RBMBackedTimestampSet)"
  })
  void testApplyWithRBMBackedTimestampSet() {
    // Arrange
    MaskTimestampSetByTimeRange maskTimestampSetByTimeRange =
        new Builder().endTime(1L).startTime(1L).timeUnit(TimeUnit.DAY).build();

    // Act
    RBMBackedTimestampSet actualApplyResult =
        maskTimestampSetByTimeRange.apply(
            new RBMBackedTimestampSet.Builder()
                .timeBucket(TimeBucket.SECOND)
                .timestamp(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant())
                .build());

    // Assert
    RBMBackedTimestampSet actualShallowClone = actualApplyResult.getShallowClone();
    assertEquals(actualApplyResult, actualShallowClone);
  }

  /**
   * Test {@link MaskTimestampSetByTimeRange#apply(RBMBackedTimestampSet)} with {@code
   * RBMBackedTimestampSet}.
   *
   * <p>Method under test: {@link MaskTimestampSetByTimeRange#apply(RBMBackedTimestampSet)}
   */
  @Test
  @DisplayName("Test apply(RBMBackedTimestampSet) with 'RBMBackedTimestampSet'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "RBMBackedTimestampSet MaskTimestampSetByTimeRange.apply(RBMBackedTimestampSet)"
  })
  void testApplyWithRBMBackedTimestampSet2() {
    // Arrange
    MaskTimestampSetByTimeRange maskTimestampSetByTimeRange = new MaskTimestampSetByTimeRange();
    maskTimestampSetByTimeRange.setStartTime(0L);
    RBMBackedTimestampSet rbmBackedTimestampSet =
        new RBMBackedTimestampSet.Builder()
            .timeBucket(TimeBucket.SECOND)
            .timestamp(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant())
            .build();

    // Act
    RBMBackedTimestampSet actualApplyResult =
        maskTimestampSetByTimeRange.apply(rbmBackedTimestampSet);

    // Assert
    assertEquals(rbmBackedTimestampSet, actualApplyResult);
  }

  /**
   * Test {@link MaskTimestampSetByTimeRange#apply(RBMBackedTimestampSet)} with {@code
   * RBMBackedTimestampSet}.
   *
   * <p>Method under test: {@link MaskTimestampSetByTimeRange#apply(RBMBackedTimestampSet)}
   */
  @Test
  @DisplayName("Test apply(RBMBackedTimestampSet) with 'RBMBackedTimestampSet'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "RBMBackedTimestampSet MaskTimestampSetByTimeRange.apply(RBMBackedTimestampSet)"
  })
  void testApplyWithRBMBackedTimestampSet3() {
    // Arrange
    MaskTimestampSetByTimeRange maskTimestampSetByTimeRange = new MaskTimestampSetByTimeRange();
    maskTimestampSetByTimeRange.setEndTime(1L);
    maskTimestampSetByTimeRange.setStartTime(0L);
    RBMBackedTimestampSet rbmBackedTimestampSet = new RBMBackedTimestampSet(TimeBucket.MINUTE);

    // Act
    RBMBackedTimestampSet actualApplyResult =
        maskTimestampSetByTimeRange.apply(rbmBackedTimestampSet);

    // Assert
    assertEquals(rbmBackedTimestampSet, actualApplyResult);
  }

  /**
   * Test {@link MaskTimestampSetByTimeRange#apply(RBMBackedTimestampSet)} with {@code
   * RBMBackedTimestampSet}.
   *
   * <p>Method under test: {@link MaskTimestampSetByTimeRange#apply(RBMBackedTimestampSet)}
   */
  @Test
  @DisplayName("Test apply(RBMBackedTimestampSet) with 'RBMBackedTimestampSet'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "RBMBackedTimestampSet MaskTimestampSetByTimeRange.apply(RBMBackedTimestampSet)"
  })
  void testApplyWithRBMBackedTimestampSet4() {
    // Arrange
    MaskTimestampSetByTimeRange maskTimestampSetByTimeRange = new MaskTimestampSetByTimeRange();
    maskTimestampSetByTimeRange.setEndTime(1L);
    maskTimestampSetByTimeRange.setStartTime(0L);
    RBMBackedTimestampSet rbmBackedTimestampSet = new RBMBackedTimestampSet(TimeBucket.HOUR);

    // Act
    RBMBackedTimestampSet actualApplyResult =
        maskTimestampSetByTimeRange.apply(rbmBackedTimestampSet);

    // Assert
    assertEquals(rbmBackedTimestampSet, actualApplyResult);
  }

  /**
   * Test {@link MaskTimestampSetByTimeRange#apply(RBMBackedTimestampSet)} with {@code
   * RBMBackedTimestampSet}.
   *
   * <p>Method under test: {@link MaskTimestampSetByTimeRange#apply(RBMBackedTimestampSet)}
   */
  @Test
  @DisplayName("Test apply(RBMBackedTimestampSet) with 'RBMBackedTimestampSet'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "RBMBackedTimestampSet MaskTimestampSetByTimeRange.apply(RBMBackedTimestampSet)"
  })
  void testApplyWithRBMBackedTimestampSet5() {
    // Arrange
    MaskTimestampSetByTimeRange maskTimestampSetByTimeRange = new MaskTimestampSetByTimeRange();
    maskTimestampSetByTimeRange.setEndTime(1L);
    maskTimestampSetByTimeRange.setStartTime(0L);
    RBMBackedTimestampSet rbmBackedTimestampSet = new RBMBackedTimestampSet(TimeBucket.DAY);

    // Act
    RBMBackedTimestampSet actualApplyResult =
        maskTimestampSetByTimeRange.apply(rbmBackedTimestampSet);

    // Assert
    assertEquals(rbmBackedTimestampSet, actualApplyResult);
  }

  /**
   * Test {@link MaskTimestampSetByTimeRange#apply(RBMBackedTimestampSet)} with {@code
   * RBMBackedTimestampSet}.
   *
   * <p>Method under test: {@link MaskTimestampSetByTimeRange#apply(RBMBackedTimestampSet)}
   */
  @Test
  @DisplayName("Test apply(RBMBackedTimestampSet) with 'RBMBackedTimestampSet'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "RBMBackedTimestampSet MaskTimestampSetByTimeRange.apply(RBMBackedTimestampSet)"
  })
  void testApplyWithRBMBackedTimestampSet6() {
    // Arrange
    MaskTimestampSetByTimeRange maskTimestampSetByTimeRange = new MaskTimestampSetByTimeRange();
    maskTimestampSetByTimeRange.setStartTime(-1L);

    // Act
    RBMBackedTimestampSet actualApplyResult =
        maskTimestampSetByTimeRange.apply(
            new RBMBackedTimestampSet.Builder()
                .timeBucket(TimeBucket.SECOND)
                .timestamp(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant())
                .build());

    // Assert
    RBMBackedTimestampSet actualShallowClone = actualApplyResult.getShallowClone();
    assertEquals(actualApplyResult, actualShallowClone);
  }

  /**
   * Test {@link MaskTimestampSetByTimeRange#apply(RBMBackedTimestampSet)} with {@code
   * RBMBackedTimestampSet}.
   *
   * <p>Method under test: {@link MaskTimestampSetByTimeRange#apply(RBMBackedTimestampSet)}
   */
  @Test
  @DisplayName("Test apply(RBMBackedTimestampSet) with 'RBMBackedTimestampSet'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "RBMBackedTimestampSet MaskTimestampSetByTimeRange.apply(RBMBackedTimestampSet)"
  })
  void testApplyWithRBMBackedTimestampSet7() {
    // Arrange
    MaskTimestampSetByTimeRange maskTimestampSetByTimeRange = new MaskTimestampSetByTimeRange();
    maskTimestampSetByTimeRange.setStartTime(1000L);

    // Act
    RBMBackedTimestampSet actualApplyResult =
        maskTimestampSetByTimeRange.apply(
            new RBMBackedTimestampSet.Builder()
                .timeBucket(TimeBucket.SECOND)
                .timestamp(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant())
                .build());

    // Assert
    RBMBackedTimestampSet actualShallowClone = actualApplyResult.getShallowClone();
    assertEquals(actualApplyResult, actualShallowClone);
  }

  /**
   * Test {@link MaskTimestampSetByTimeRange#apply(RBMBackedTimestampSet)} with {@code
   * RBMBackedTimestampSet}.
   *
   * <p>Method under test: {@link MaskTimestampSetByTimeRange#apply(RBMBackedTimestampSet)}
   */
  @Test
  @DisplayName("Test apply(RBMBackedTimestampSet) with 'RBMBackedTimestampSet'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "RBMBackedTimestampSet MaskTimestampSetByTimeRange.apply(RBMBackedTimestampSet)"
  })
  void testApplyWithRBMBackedTimestampSet8() {
    // Arrange
    MaskTimestampSetByTimeRange maskTimestampSetByTimeRange = new MaskTimestampSetByTimeRange();
    maskTimestampSetByTimeRange.setEndTime(0L);
    maskTimestampSetByTimeRange.setStartTime(0L);
    RBMBackedTimestampSet rbmBackedTimestampSet = new RBMBackedTimestampSet(TimeBucket.WEEK);

    // Act
    RBMBackedTimestampSet actualApplyResult =
        maskTimestampSetByTimeRange.apply(rbmBackedTimestampSet);

    // Assert
    assertEquals(rbmBackedTimestampSet, actualApplyResult);
  }

  /**
   * Test {@link MaskTimestampSetByTimeRange#apply(RBMBackedTimestampSet)} with {@code
   * RBMBackedTimestampSet}.
   *
   * <p>Method under test: {@link MaskTimestampSetByTimeRange#apply(RBMBackedTimestampSet)}
   */
  @Test
  @DisplayName("Test apply(RBMBackedTimestampSet) with 'RBMBackedTimestampSet'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "RBMBackedTimestampSet MaskTimestampSetByTimeRange.apply(RBMBackedTimestampSet)"
  })
  void testApplyWithRBMBackedTimestampSet9() {
    // Arrange
    MaskTimestampSetByTimeRange maskTimestampSetByTimeRange = new MaskTimestampSetByTimeRange();
    maskTimestampSetByTimeRange.setStartTime(0L);
    RBMBackedTimestampSet rbmBackedTimestampSet =
        new RBMBackedTimestampSet.Builder()
            .timeBucket(TimeBucket.SECOND)
            .timestamp(LocalDate.now().atStartOfDay().atZone(ZoneOffset.UTC).toInstant())
            .build();

    // Act
    RBMBackedTimestampSet actualApplyResult =
        maskTimestampSetByTimeRange.apply(rbmBackedTimestampSet);

    // Assert
    assertEquals(rbmBackedTimestampSet, actualApplyResult);
  }

  /**
   * Test {@link MaskTimestampSetByTimeRange#apply(RBMBackedTimestampSet)} with {@code
   * RBMBackedTimestampSet}.
   *
   * <p>Method under test: {@link MaskTimestampSetByTimeRange#apply(RBMBackedTimestampSet)}
   */
  @Test
  @DisplayName("Test apply(RBMBackedTimestampSet) with 'RBMBackedTimestampSet'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "RBMBackedTimestampSet MaskTimestampSetByTimeRange.apply(RBMBackedTimestampSet)"
  })
  void testApplyWithRBMBackedTimestampSet10() {
    // Arrange
    MaskTimestampSetByTimeRange maskTimestampSetByTimeRange = new MaskTimestampSetByTimeRange();
    maskTimestampSetByTimeRange.setEndTime(1L);
    maskTimestampSetByTimeRange.setStartTime(0L);
    RBMBackedTimestampSet rbmBackedTimestampSet = new RBMBackedTimestampSet(TimeBucket.MONTH);

    // Act
    RBMBackedTimestampSet actualApplyResult =
        maskTimestampSetByTimeRange.apply(rbmBackedTimestampSet);

    // Assert
    assertEquals(rbmBackedTimestampSet, actualApplyResult);
  }

  /**
   * Test {@link MaskTimestampSetByTimeRange#apply(RBMBackedTimestampSet)} with {@code
   * RBMBackedTimestampSet}.
   *
   * <p>Method under test: {@link MaskTimestampSetByTimeRange#apply(RBMBackedTimestampSet)}
   */
  @Test
  @DisplayName("Test apply(RBMBackedTimestampSet) with 'RBMBackedTimestampSet'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "RBMBackedTimestampSet MaskTimestampSetByTimeRange.apply(RBMBackedTimestampSet)"
  })
  void testApplyWithRBMBackedTimestampSet11() {
    // Arrange
    MaskTimestampSetByTimeRange maskTimestampSetByTimeRange = new MaskTimestampSetByTimeRange();
    maskTimestampSetByTimeRange.setEndTime(1L);
    maskTimestampSetByTimeRange.setStartTime(0L);

    RBMBackedTimestampSet rbmBackedTimestampSet = new RBMBackedTimestampSet(TimeBucket.MINUTE);

    LocalDate ofEpochDayResult = LocalDate.ofEpochDay(1L);
    rbmBackedTimestampSet.add(ofEpochDayResult.atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Act
    RBMBackedTimestampSet actualApplyResult =
        maskTimestampSetByTimeRange.apply(rbmBackedTimestampSet);

    // Assert
    RBMBackedTimestampSet actualShallowClone = actualApplyResult.getShallowClone();
    assertEquals(actualApplyResult, actualShallowClone);
  }

  /**
   * Test {@link MaskTimestampSetByTimeRange#apply(RBMBackedTimestampSet)} with {@code
   * RBMBackedTimestampSet}.
   *
   * <p>Method under test: {@link MaskTimestampSetByTimeRange#apply(RBMBackedTimestampSet)}
   */
  @Test
  @DisplayName("Test apply(RBMBackedTimestampSet) with 'RBMBackedTimestampSet'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "RBMBackedTimestampSet MaskTimestampSetByTimeRange.apply(RBMBackedTimestampSet)"
  })
  void testApplyWithRBMBackedTimestampSet12() {
    // Arrange
    MaskTimestampSetByTimeRange maskTimestampSetByTimeRange = new MaskTimestampSetByTimeRange();
    maskTimestampSetByTimeRange.setEndTime(1L);
    maskTimestampSetByTimeRange.setStartTime(0L);

    RBMBackedTimestampSet rbmBackedTimestampSet =
        new RBMBackedTimestampSet.Builder()
            .timeBucket(TimeBucket.SECOND)
            .timestamp(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant())
            .build();

    LocalDate ofEpochDayResult = LocalDate.ofEpochDay(1L);
    rbmBackedTimestampSet.add(ofEpochDayResult.atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Act
    RBMBackedTimestampSet actualApplyResult =
        maskTimestampSetByTimeRange.apply(rbmBackedTimestampSet);

    // Assert
    RBMBackedTimestampSet actualShallowClone = actualApplyResult.getShallowClone();
    assertEquals(actualApplyResult, actualShallowClone);
  }

  /**
   * Test {@link MaskTimestampSetByTimeRange#apply(RBMBackedTimestampSet)} with {@code
   * RBMBackedTimestampSet}.
   *
   * <p>Method under test: {@link MaskTimestampSetByTimeRange#apply(RBMBackedTimestampSet)}
   */
  @Test
  @DisplayName("Test apply(RBMBackedTimestampSet) with 'RBMBackedTimestampSet'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "RBMBackedTimestampSet MaskTimestampSetByTimeRange.apply(RBMBackedTimestampSet)"
  })
  void testApplyWithRBMBackedTimestampSet13() {
    // Arrange
    MaskTimestampSetByTimeRange maskTimestampSetByTimeRange = new MaskTimestampSetByTimeRange();
    maskTimestampSetByTimeRange.setEndTime(1L);
    maskTimestampSetByTimeRange.setStartTime(0L);

    RBMBackedTimestampSet rbmBackedTimestampSet = new RBMBackedTimestampSet(TimeBucket.MINUTE);
    rbmBackedTimestampSet.add(
        LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    LocalDate ofEpochDayResult = LocalDate.ofEpochDay(1L);
    rbmBackedTimestampSet.add(ofEpochDayResult.atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Act
    RBMBackedTimestampSet actualApplyResult =
        maskTimestampSetByTimeRange.apply(rbmBackedTimestampSet);

    // Assert
    RBMBackedTimestampSet actualShallowClone = actualApplyResult.getShallowClone();
    assertEquals(actualApplyResult, actualShallowClone);
  }

  /**
   * Test {@link MaskTimestampSetByTimeRange#apply(RBMBackedTimestampSet)} with {@code
   * RBMBackedTimestampSet}.
   *
   * <ul>
   *   <li>Then return Earliest EpochSecond is {@code -259200}.
   * </ul>
   *
   * <p>Method under test: {@link MaskTimestampSetByTimeRange#apply(RBMBackedTimestampSet)}
   */
  @Test
  @DisplayName(
      "Test apply(RBMBackedTimestampSet) with 'RBMBackedTimestampSet'; then return Earliest EpochSecond is '-259200'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "RBMBackedTimestampSet MaskTimestampSetByTimeRange.apply(RBMBackedTimestampSet)"
  })
  void testApplyWithRBMBackedTimestampSet_thenReturnEarliestEpochSecondIs259200() {
    // Arrange
    MaskTimestampSetByTimeRange maskTimestampSetByTimeRange = new MaskTimestampSetByTimeRange();
    maskTimestampSetByTimeRange.setEndTime(0L);
    maskTimestampSetByTimeRange.setStartTime(0L);

    RBMBackedTimestampSet rbmBackedTimestampSet = new RBMBackedTimestampSet(TimeBucket.WEEK);
    rbmBackedTimestampSet.addAll(
        new RBMBackedTimestampSet.Builder()
            .timeBucket(TimeBucket.SECOND)
            .timestamp(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant())
            .build());

    // Act
    RBMBackedTimestampSet actualApplyResult =
        maskTimestampSetByTimeRange.apply(rbmBackedTimestampSet);

    // Assert
    Instant earliest = actualApplyResult.getEarliest();
    assertEquals(-259200L, earliest.getEpochSecond());
    Iterator<Integer> iteratorResult = actualApplyResult.getRbm().iterator();
    assertEquals(-3, iteratorResult.next().intValue());
    assertEquals(TimeBucket.WEEK, actualApplyResult.getTimeBucket());
    assertFalse(iteratorResult.hasNext());
    assertEquals(earliest, actualApplyResult.getLatest());
  }

  /**
   * Test {@link MaskTimestampSetByTimeRange#equals(Object)}, and {@link
   * MaskTimestampSetByTimeRange#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link MaskTimestampSetByTimeRange#equals(Object)}
   *   <li>{@link MaskTimestampSetByTimeRange#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean MaskTimestampSetByTimeRange.equals(Object)",
    "int MaskTimestampSetByTimeRange.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    MaskTimestampSetByTimeRange maskTimestampSetByTimeRange =
        new Builder().endTime(1L).startTime(1L).timeUnit(TimeUnit.DAY).build();
    MaskTimestampSetByTimeRange maskTimestampSetByTimeRange2 =
        new Builder().endTime(1L).startTime(1L).timeUnit(TimeUnit.DAY).build();

    // Act and Assert
    assertEquals(maskTimestampSetByTimeRange, maskTimestampSetByTimeRange2);
    assertEquals(maskTimestampSetByTimeRange.hashCode(), maskTimestampSetByTimeRange2.hashCode());
  }

  /**
   * Test {@link MaskTimestampSetByTimeRange#equals(Object)}, and {@link
   * MaskTimestampSetByTimeRange#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link MaskTimestampSetByTimeRange#equals(Object)}
   *   <li>{@link MaskTimestampSetByTimeRange#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean MaskTimestampSetByTimeRange.equals(Object)",
    "int MaskTimestampSetByTimeRange.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    MaskTimestampSetByTimeRange maskTimestampSetByTimeRange =
        new Builder().endTime(1L).startTime(1L).timeUnit(TimeUnit.DAY).build();

    // Act and Assert
    assertEquals(maskTimestampSetByTimeRange, maskTimestampSetByTimeRange);
    int expectedHashCodeResult = maskTimestampSetByTimeRange.hashCode();
    assertEquals(expectedHashCodeResult, maskTimestampSetByTimeRange.hashCode());
  }

  /**
   * Test {@link MaskTimestampSetByTimeRange#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link MaskTimestampSetByTimeRange#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean MaskTimestampSetByTimeRange.equals(Object)",
    "int MaskTimestampSetByTimeRange.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    MaskTimestampSetByTimeRange maskTimestampSetByTimeRange =
        new Builder().endTime(0L).startTime(1L).timeUnit(TimeUnit.DAY).build();

    // Act and Assert
    assertNotEquals(
        maskTimestampSetByTimeRange,
        new Builder().endTime(1L).startTime(1L).timeUnit(TimeUnit.DAY).build());
  }

  /**
   * Test {@link MaskTimestampSetByTimeRange#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link MaskTimestampSetByTimeRange#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean MaskTimestampSetByTimeRange.equals(Object)",
    "int MaskTimestampSetByTimeRange.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    MaskTimestampSetByTimeRange maskTimestampSetByTimeRange =
        new Builder().endTime(1L).startTime(0L).timeUnit(TimeUnit.DAY).build();

    // Act and Assert
    assertNotEquals(
        maskTimestampSetByTimeRange,
        new Builder().endTime(1L).startTime(1L).timeUnit(TimeUnit.DAY).build());
  }

  /**
   * Test {@link MaskTimestampSetByTimeRange#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link MaskTimestampSetByTimeRange#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean MaskTimestampSetByTimeRange.equals(Object)",
    "int MaskTimestampSetByTimeRange.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    MaskTimestampSetByTimeRange maskTimestampSetByTimeRange =
        new Builder().endTime(1L).startTime(1L).timeUnit(null).build();

    // Act and Assert
    assertNotEquals(
        maskTimestampSetByTimeRange,
        new Builder().endTime(1L).startTime(1L).timeUnit(TimeUnit.DAY).build());
  }

  /**
   * Test {@link MaskTimestampSetByTimeRange#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link MaskTimestampSetByTimeRange#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean MaskTimestampSetByTimeRange.equals(Object)",
    "int MaskTimestampSetByTimeRange.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new Builder().endTime(1L).startTime(1L).timeUnit(TimeUnit.DAY).build(), null);
  }

  /**
   * Test {@link MaskTimestampSetByTimeRange#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link MaskTimestampSetByTimeRange#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean MaskTimestampSetByTimeRange.equals(Object)",
    "int MaskTimestampSetByTimeRange.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        new Builder().endTime(1L).startTime(1L).timeUnit(TimeUnit.DAY).build(),
        "Different type to MaskTimestampSetByTimeRange");
  }
}
