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

package uk.gov.gchq.gaffer.time.predicate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.time.LocalDate;
import java.time.ZoneOffset;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.time.CommonTimeUtil;
import uk.gov.gchq.gaffer.time.CommonTimeUtil.TimeBucket;
import uk.gov.gchq.gaffer.time.RBMBackedTimestampSet;
import uk.gov.gchq.gaffer.time.RBMBackedTimestampSet.Builder;
import uk.gov.gchq.koryphe.util.TimeUnit;

class RBMBackedTimestampSetInRangeDiffblueTest {
  /**
   * Test {@link RBMBackedTimestampSetInRange#RBMBackedTimestampSetInRange()}.
   *
   * <p>Method under test: {@link RBMBackedTimestampSetInRange#RBMBackedTimestampSetInRange()}
   */
  @Test
  @DisplayName("Test new RBMBackedTimestampSetInRange()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void RBMBackedTimestampSetInRange.<init>()"})
  void testNewRBMBackedTimestampSetInRange() {
    // Arrange and Act
    RBMBackedTimestampSetInRange actualRbmBackedTimestampSetInRange =
        new RBMBackedTimestampSetInRange();

    // Assert
    assertNull(actualRbmBackedTimestampSetInRange.getEndTime());
    assertNull(actualRbmBackedTimestampSetInRange.getStartTime());
    assertEquals(TimeUnit.MILLISECOND, actualRbmBackedTimestampSetInRange.getTimeUnit());
    assertFalse(actualRbmBackedTimestampSetInRange.isIncludeAllTimestamps());
  }

  /**
   * Test {@link RBMBackedTimestampSetInRange#RBMBackedTimestampSetInRange(Number, Number)}.
   *
   * <p>Method under test: {@link RBMBackedTimestampSetInRange#RBMBackedTimestampSetInRange(Number,
   * Number)}
   */
  @Test
  @DisplayName("Test new RBMBackedTimestampSetInRange(Number, Number)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void RBMBackedTimestampSetInRange.<init>(Number, Number)"})
  void testNewRBMBackedTimestampSetInRange2() {
    // Arrange
    Integer startTime = Integer.valueOf(1);
    Integer endTime = Integer.valueOf(1);

    // Act
    RBMBackedTimestampSetInRange actualRbmBackedTimestampSetInRange =
        new RBMBackedTimestampSetInRange(startTime, endTime);

    // Assert
    Number endTime2 = actualRbmBackedTimestampSetInRange.getEndTime();
    assertEquals(1, endTime2.intValue());
    assertEquals(TimeUnit.MILLISECOND, actualRbmBackedTimestampSetInRange.getTimeUnit());
    assertFalse(actualRbmBackedTimestampSetInRange.isIncludeAllTimestamps());
    assertSame(endTime, endTime2);
    assertSame(endTime, actualRbmBackedTimestampSetInRange.getStartTime());
  }

  /**
   * Test {@link RBMBackedTimestampSetInRange#RBMBackedTimestampSetInRange(Number, Number,
   * TimeUnit)}.
   *
   * <p>Method under test: {@link RBMBackedTimestampSetInRange#RBMBackedTimestampSetInRange(Number,
   * Number, TimeUnit)}
   */
  @Test
  @DisplayName("Test new RBMBackedTimestampSetInRange(Number, Number, TimeUnit)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void RBMBackedTimestampSetInRange.<init>(Number, Number, TimeUnit)"})
  void testNewRBMBackedTimestampSetInRange3() {
    // Arrange
    Integer startTime = Integer.valueOf(1);
    Integer endTime = Integer.valueOf(1);

    // Act
    RBMBackedTimestampSetInRange actualRbmBackedTimestampSetInRange =
        new RBMBackedTimestampSetInRange(startTime, endTime, TimeUnit.DAY);

    // Assert
    Number endTime2 = actualRbmBackedTimestampSetInRange.getEndTime();
    assertEquals(1, endTime2.intValue());
    assertEquals(TimeUnit.DAY, actualRbmBackedTimestampSetInRange.getTimeUnit());
    assertFalse(actualRbmBackedTimestampSetInRange.isIncludeAllTimestamps());
    assertSame(endTime, endTime2);
    assertSame(endTime, actualRbmBackedTimestampSetInRange.getStartTime());
  }

  /**
   * Test {@link RBMBackedTimestampSetInRange#RBMBackedTimestampSetInRange(Number, Number, TimeUnit,
   * Boolean)}.
   *
   * <p>Method under test: {@link RBMBackedTimestampSetInRange#RBMBackedTimestampSetInRange(Number,
   * Number, TimeUnit, Boolean)}
   */
  @Test
  @DisplayName("Test new RBMBackedTimestampSetInRange(Number, Number, TimeUnit, Boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void RBMBackedTimestampSetInRange.<init>(Number, Number, TimeUnit, Boolean)"})
  void testNewRBMBackedTimestampSetInRange4() {
    // Arrange
    Integer startTime = Integer.valueOf(1);
    Integer endTime = Integer.valueOf(1);

    // Act
    RBMBackedTimestampSetInRange actualRbmBackedTimestampSetInRange =
        new RBMBackedTimestampSetInRange(startTime, endTime, TimeUnit.DAY, true);

    // Assert
    Number endTime2 = actualRbmBackedTimestampSetInRange.getEndTime();
    assertEquals(1, endTime2.intValue());
    assertEquals(TimeUnit.DAY, actualRbmBackedTimestampSetInRange.getTimeUnit());
    assertTrue(actualRbmBackedTimestampSetInRange.isIncludeAllTimestamps());
    assertSame(endTime, endTime2);
    assertSame(endTime, actualRbmBackedTimestampSetInRange.getStartTime());
  }

  /**
   * Test {@link RBMBackedTimestampSetInRange#test(RBMBackedTimestampSet)} with {@code
   * RBMBackedTimestampSet}.
   *
   * <p>Method under test: {@link RBMBackedTimestampSetInRange#test(RBMBackedTimestampSet)}
   */
  @Test
  @DisplayName("Test test(RBMBackedTimestampSet) with 'RBMBackedTimestampSet'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RBMBackedTimestampSetInRange.test(RBMBackedTimestampSet)"})
  void testTestWithRBMBackedTimestampSet() {
    // Arrange
    RBMBackedTimestampSetInRange rbmBackedTimestampSetInRange = new RBMBackedTimestampSetInRange();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> rbmBackedTimestampSetInRange.test(new RBMBackedTimestampSet(TimeBucket.SECOND)));
  }

  /**
   * Test {@link RBMBackedTimestampSetInRange#test(RBMBackedTimestampSet)} with {@code
   * RBMBackedTimestampSet}.
   *
   * <p>Method under test: {@link RBMBackedTimestampSetInRange#test(RBMBackedTimestampSet)}
   */
  @Test
  @DisplayName("Test test(RBMBackedTimestampSet) with 'RBMBackedTimestampSet'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RBMBackedTimestampSetInRange.test(RBMBackedTimestampSet)"})
  void testTestWithRBMBackedTimestampSet2() {
    // Arrange
    Integer startTime = Integer.valueOf(1);
    RBMBackedTimestampSetInRange rbmBackedTimestampSetInRange =
        new RBMBackedTimestampSetInRange(startTime, Integer.valueOf(1));

    // Act
    boolean actualTestResult =
        rbmBackedTimestampSetInRange.test(
            new Builder()
                .timeBucket(TimeBucket.SECOND)
                .timestamp(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant())
                .build());

    // Assert
    assertTrue(actualTestResult);
  }

  /**
   * Test {@link RBMBackedTimestampSetInRange#test(RBMBackedTimestampSet)} with {@code
   * RBMBackedTimestampSet}.
   *
   * <p>Method under test: {@link RBMBackedTimestampSetInRange#test(RBMBackedTimestampSet)}
   */
  @Test
  @DisplayName("Test test(RBMBackedTimestampSet) with 'RBMBackedTimestampSet'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RBMBackedTimestampSetInRange.test(RBMBackedTimestampSet)"})
  void testTestWithRBMBackedTimestampSet3() {
    // Arrange
    Integer startTime = Integer.valueOf(1);
    RBMBackedTimestampSetInRange rbmBackedTimestampSetInRange =
        new RBMBackedTimestampSetInRange(startTime, Integer.valueOf(1), TimeUnit.DAY);

    // Act
    boolean actualTestResult =
        rbmBackedTimestampSetInRange.test(
            new Builder()
                .timeBucket(TimeBucket.SECOND)
                .timestamp(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant())
                .build());

    // Assert
    assertFalse(actualTestResult);
  }

  /**
   * Test {@link RBMBackedTimestampSetInRange#test(RBMBackedTimestampSet)} with {@code
   * RBMBackedTimestampSet}.
   *
   * <p>Method under test: {@link RBMBackedTimestampSetInRange#test(RBMBackedTimestampSet)}
   */
  @Test
  @DisplayName("Test test(RBMBackedTimestampSet) with 'RBMBackedTimestampSet'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RBMBackedTimestampSetInRange.test(RBMBackedTimestampSet)"})
  void testTestWithRBMBackedTimestampSet4() {
    // Arrange
    RBMBackedTimestampSetInRange rbmBackedTimestampSetInRange = new RBMBackedTimestampSetInRange();
    rbmBackedTimestampSetInRange.setStartTime(Integer.valueOf(1));

    // Act
    boolean actualTestResult =
        rbmBackedTimestampSetInRange.test(
            new Builder()
                .timeBucket(TimeBucket.SECOND)
                .timestamp(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant())
                .build());

    // Assert
    assertTrue(actualTestResult);
  }

  /**
   * Test {@link RBMBackedTimestampSetInRange#test(RBMBackedTimestampSet)} with {@code
   * RBMBackedTimestampSet}.
   *
   * <p>Method under test: {@link RBMBackedTimestampSetInRange#test(RBMBackedTimestampSet)}
   */
  @Test
  @DisplayName("Test test(RBMBackedTimestampSet) with 'RBMBackedTimestampSet'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RBMBackedTimestampSetInRange.test(RBMBackedTimestampSet)"})
  void testTestWithRBMBackedTimestampSet5() {
    // Arrange
    RBMBackedTimestampSetInRange rbmBackedTimestampSetInRange = new RBMBackedTimestampSetInRange();
    rbmBackedTimestampSetInRange.setIncludeAllTimestamps(true);

    // Act
    boolean actualTestResult =
        rbmBackedTimestampSetInRange.test(
            new Builder()
                .timeBucket(TimeBucket.SECOND)
                .timestamp(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant())
                .build());

    // Assert
    assertTrue(actualTestResult);
  }

  /**
   * Test {@link RBMBackedTimestampSetInRange#test(RBMBackedTimestampSet)} with {@code
   * RBMBackedTimestampSet}.
   *
   * <p>Method under test: {@link RBMBackedTimestampSetInRange#test(RBMBackedTimestampSet)}
   */
  @Test
  @DisplayName("Test test(RBMBackedTimestampSet) with 'RBMBackedTimestampSet'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RBMBackedTimestampSetInRange.test(RBMBackedTimestampSet)"})
  void testTestWithRBMBackedTimestampSet6() {
    // Arrange
    RBMBackedTimestampSetInRange rbmBackedTimestampSetInRange =
        new RBMBackedTimestampSetInRange(0, Integer.valueOf(1), TimeUnit.DAY);

    // Act
    boolean actualTestResult =
        rbmBackedTimestampSetInRange.test(
            new Builder()
                .timeBucket(TimeBucket.SECOND)
                .timestamp(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant())
                .build());

    // Assert
    assertTrue(actualTestResult);
  }

  /**
   * Test {@link RBMBackedTimestampSetInRange#test(RBMBackedTimestampSet)} with {@code
   * RBMBackedTimestampSet}.
   *
   * <p>Method under test: {@link RBMBackedTimestampSetInRange#test(RBMBackedTimestampSet)}
   */
  @Test
  @DisplayName("Test test(RBMBackedTimestampSet) with 'RBMBackedTimestampSet'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RBMBackedTimestampSetInRange.test(RBMBackedTimestampSet)"})
  void testTestWithRBMBackedTimestampSet7() {
    // Arrange
    RBMBackedTimestampSetInRange rbmBackedTimestampSetInRange =
        new RBMBackedTimestampSetInRange(-1, Integer.valueOf(1), TimeUnit.DAY);

    // Act
    boolean actualTestResult =
        rbmBackedTimestampSetInRange.test(
            new Builder()
                .timeBucket(TimeBucket.SECOND)
                .timestamp(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant())
                .build());

    // Assert
    assertFalse(actualTestResult);
  }

  /**
   * Test {@link RBMBackedTimestampSetInRange#test(RBMBackedTimestampSet)} with {@code
   * RBMBackedTimestampSet}.
   *
   * <p>Method under test: {@link RBMBackedTimestampSetInRange#test(RBMBackedTimestampSet)}
   */
  @Test
  @DisplayName("Test test(RBMBackedTimestampSet) with 'RBMBackedTimestampSet'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RBMBackedTimestampSetInRange.test(RBMBackedTimestampSet)"})
  void testTestWithRBMBackedTimestampSet8() {
    // Arrange
    Integer startTime = Integer.valueOf(1);
    RBMBackedTimestampSetInRange rbmBackedTimestampSetInRange =
        new RBMBackedTimestampSetInRange(startTime, null, TimeUnit.DAY);

    // Act
    boolean actualTestResult =
        rbmBackedTimestampSetInRange.test(
            new Builder()
                .timeBucket(TimeBucket.SECOND)
                .timestamp(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant())
                .build());

    // Assert
    assertFalse(actualTestResult);
  }

  /**
   * Test {@link RBMBackedTimestampSetInRange#test(RBMBackedTimestampSet)} with {@code
   * RBMBackedTimestampSet}.
   *
   * <p>Method under test: {@link RBMBackedTimestampSetInRange#test(RBMBackedTimestampSet)}
   */
  @Test
  @DisplayName("Test test(RBMBackedTimestampSet) with 'RBMBackedTimestampSet'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RBMBackedTimestampSetInRange.test(RBMBackedTimestampSet)"})
  void testTestWithRBMBackedTimestampSet9() {
    // Arrange
    Integer startTime = Integer.valueOf(1);
    RBMBackedTimestampSetInRange rbmBackedTimestampSetInRange =
        new RBMBackedTimestampSetInRange(startTime, Integer.valueOf(1), TimeUnit.HOUR);

    // Act
    boolean actualTestResult =
        rbmBackedTimestampSetInRange.test(
            new Builder()
                .timeBucket(TimeBucket.SECOND)
                .timestamp(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant())
                .build());

    // Assert
    assertFalse(actualTestResult);
  }

  /**
   * Test {@link RBMBackedTimestampSetInRange#test(RBMBackedTimestampSet)} with {@code
   * RBMBackedTimestampSet}.
   *
   * <p>Method under test: {@link RBMBackedTimestampSetInRange#test(RBMBackedTimestampSet)}
   */
  @Test
  @DisplayName("Test test(RBMBackedTimestampSet) with 'RBMBackedTimestampSet'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RBMBackedTimestampSetInRange.test(RBMBackedTimestampSet)"})
  void testTestWithRBMBackedTimestampSet10() {
    // Arrange
    RBMBackedTimestampSetInRange rbmBackedTimestampSetInRange =
        new RBMBackedTimestampSetInRange(0, 0, TimeUnit.DAY);

    // Act
    boolean actualTestResult =
        rbmBackedTimestampSetInRange.test(
            new Builder()
                .timeBucket(TimeBucket.SECOND)
                .timestamp(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant())
                .build());

    // Assert
    assertTrue(actualTestResult);
  }

  /**
   * Test {@link RBMBackedTimestampSetInRange#test(RBMBackedTimestampSet)} with {@code
   * RBMBackedTimestampSet}.
   *
   * <p>Method under test: {@link RBMBackedTimestampSetInRange#test(RBMBackedTimestampSet)}
   */
  @Test
  @DisplayName("Test test(RBMBackedTimestampSet) with 'RBMBackedTimestampSet'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RBMBackedTimestampSetInRange.test(RBMBackedTimestampSet)"})
  void testTestWithRBMBackedTimestampSet11() {
    // Arrange
    Integer startTime = Integer.valueOf(1);

    RBMBackedTimestampSetInRange rbmBackedTimestampSetInRange =
        new RBMBackedTimestampSetInRange(startTime, Integer.valueOf(1), TimeUnit.DAY);
    rbmBackedTimestampSetInRange.setIncludeAllTimestamps(true);

    // Act
    boolean actualTestResult =
        rbmBackedTimestampSetInRange.test(
            new Builder()
                .timeBucket(TimeBucket.SECOND)
                .timestamp(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant())
                .build());

    // Assert
    assertFalse(actualTestResult);
  }

  /**
   * Test {@link RBMBackedTimestampSetInRange#test(RBMBackedTimestampSet)} with {@code
   * RBMBackedTimestampSet}.
   *
   * <p>Method under test: {@link RBMBackedTimestampSetInRange#test(RBMBackedTimestampSet)}
   */
  @Test
  @DisplayName("Test test(RBMBackedTimestampSet) with 'RBMBackedTimestampSet'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RBMBackedTimestampSetInRange.test(RBMBackedTimestampSet)"})
  void testTestWithRBMBackedTimestampSet12() {
    // Arrange
    RBMBackedTimestampSetInRange rbmBackedTimestampSetInRange = new RBMBackedTimestampSetInRange();

    RBMBackedTimestampSet rbmBackedTimestampSet = new RBMBackedTimestampSet(TimeBucket.MINUTE);
    rbmBackedTimestampSet.addAll(
        new Builder()
            .timeBucket(TimeBucket.SECOND)
            .timestamp(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant())
            .build());

    // Act
    boolean actualTestResult = rbmBackedTimestampSetInRange.test(rbmBackedTimestampSet);

    // Assert
    assertTrue(actualTestResult);
  }

  /**
   * Test {@link RBMBackedTimestampSetInRange#test(RBMBackedTimestampSet)} with {@code
   * RBMBackedTimestampSet}.
   *
   * <p>Method under test: {@link RBMBackedTimestampSetInRange#test(RBMBackedTimestampSet)}
   */
  @Test
  @DisplayName("Test test(RBMBackedTimestampSet) with 'RBMBackedTimestampSet'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RBMBackedTimestampSetInRange.test(RBMBackedTimestampSet)"})
  void testTestWithRBMBackedTimestampSet13() {
    // Arrange
    RBMBackedTimestampSetInRange rbmBackedTimestampSetInRange = new RBMBackedTimestampSetInRange();

    RBMBackedTimestampSet rbmBackedTimestampSet = new RBMBackedTimestampSet(TimeBucket.HOUR);
    rbmBackedTimestampSet.addAll(
        new Builder()
            .timeBucket(TimeBucket.SECOND)
            .timestamp(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant())
            .build());

    // Act
    boolean actualTestResult = rbmBackedTimestampSetInRange.test(rbmBackedTimestampSet);

    // Assert
    assertTrue(actualTestResult);
  }

  /**
   * Test {@link RBMBackedTimestampSetInRange#test(RBMBackedTimestampSet)} with {@code
   * RBMBackedTimestampSet}.
   *
   * <p>Method under test: {@link RBMBackedTimestampSetInRange#test(RBMBackedTimestampSet)}
   */
  @Test
  @DisplayName("Test test(RBMBackedTimestampSet) with 'RBMBackedTimestampSet'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RBMBackedTimestampSetInRange.test(RBMBackedTimestampSet)"})
  void testTestWithRBMBackedTimestampSet14() {
    // Arrange
    RBMBackedTimestampSetInRange rbmBackedTimestampSetInRange = new RBMBackedTimestampSetInRange();

    RBMBackedTimestampSet rbmBackedTimestampSet = new RBMBackedTimestampSet(TimeBucket.DAY);
    rbmBackedTimestampSet.addAll(
        new Builder()
            .timeBucket(TimeBucket.SECOND)
            .timestamp(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant())
            .build());

    // Act
    boolean actualTestResult = rbmBackedTimestampSetInRange.test(rbmBackedTimestampSet);

    // Assert
    assertTrue(actualTestResult);
  }

  /**
   * Test {@link RBMBackedTimestampSetInRange#test(RBMBackedTimestampSet)} with {@code
   * RBMBackedTimestampSet}.
   *
   * <p>Method under test: {@link RBMBackedTimestampSetInRange#test(RBMBackedTimestampSet)}
   */
  @Test
  @DisplayName("Test test(RBMBackedTimestampSet) with 'RBMBackedTimestampSet'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RBMBackedTimestampSetInRange.test(RBMBackedTimestampSet)"})
  void testTestWithRBMBackedTimestampSet15() {
    // Arrange
    RBMBackedTimestampSetInRange rbmBackedTimestampSetInRange = new RBMBackedTimestampSetInRange();

    RBMBackedTimestampSet rbmBackedTimestampSet = new RBMBackedTimestampSet(TimeBucket.WEEK);
    rbmBackedTimestampSet.addAll(
        new Builder()
            .timeBucket(TimeBucket.SECOND)
            .timestamp(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant())
            .build());

    // Act
    boolean actualTestResult = rbmBackedTimestampSetInRange.test(rbmBackedTimestampSet);

    // Assert
    assertTrue(actualTestResult);
  }

  /**
   * Test {@link RBMBackedTimestampSetInRange#test(RBMBackedTimestampSet)} with {@code
   * RBMBackedTimestampSet}.
   *
   * <p>Method under test: {@link RBMBackedTimestampSetInRange#test(RBMBackedTimestampSet)}
   */
  @Test
  @DisplayName("Test test(RBMBackedTimestampSet) with 'RBMBackedTimestampSet'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RBMBackedTimestampSetInRange.test(RBMBackedTimestampSet)"})
  void testTestWithRBMBackedTimestampSet16() {
    // Arrange
    RBMBackedTimestampSetInRange rbmBackedTimestampSetInRange = new RBMBackedTimestampSetInRange();

    RBMBackedTimestampSet rbmBackedTimestampSet = new RBMBackedTimestampSet(TimeBucket.MONTH);
    rbmBackedTimestampSet.addAll(
        new Builder()
            .timeBucket(TimeBucket.SECOND)
            .timestamp(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant())
            .build());

    // Act
    boolean actualTestResult = rbmBackedTimestampSetInRange.test(rbmBackedTimestampSet);

    // Assert
    assertTrue(actualTestResult);
  }

  /**
   * Test {@link RBMBackedTimestampSetInRange#test(RBMBackedTimestampSet)} with {@code
   * RBMBackedTimestampSet}.
   *
   * <p>Method under test: {@link RBMBackedTimestampSetInRange#test(RBMBackedTimestampSet)}
   */
  @Test
  @DisplayName("Test test(RBMBackedTimestampSet) with 'RBMBackedTimestampSet'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RBMBackedTimestampSetInRange.test(RBMBackedTimestampSet)"})
  void testTestWithRBMBackedTimestampSet17() {
    // Arrange
    RBMBackedTimestampSetInRange rbmBackedTimestampSetInRange = new RBMBackedTimestampSetInRange();

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
    boolean actualTestResult = rbmBackedTimestampSetInRange.test(rbmBackedTimestampSet);

    // Assert
    assertTrue(actualTestResult);
  }

  /**
   * Test {@link RBMBackedTimestampSetInRange#test(RBMBackedTimestampSet)} with {@code
   * RBMBackedTimestampSet}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link RBMBackedTimestampSetInRange#test(RBMBackedTimestampSet)}
   */
  @Test
  @DisplayName("Test test(RBMBackedTimestampSet) with 'RBMBackedTimestampSet'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RBMBackedTimestampSetInRange.test(RBMBackedTimestampSet)"})
  void testTestWithRBMBackedTimestampSet_thenReturnTrue() {
    // Arrange
    RBMBackedTimestampSetInRange rbmBackedTimestampSetInRange = new RBMBackedTimestampSetInRange();

    // Act
    boolean actualTestResult =
        rbmBackedTimestampSetInRange.test(
            new Builder()
                .timeBucket(TimeBucket.SECOND)
                .timestamp(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant())
                .build());

    // Assert
    assertTrue(actualTestResult);
  }

  /**
   * Test {@link RBMBackedTimestampSetInRange#test(RBMBackedTimestampSet)} with {@code
   * RBMBackedTimestampSet}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link RBMBackedTimestampSetInRange#test(RBMBackedTimestampSet)}
   */
  @Test
  @DisplayName(
      "Test test(RBMBackedTimestampSet) with 'RBMBackedTimestampSet'; when 'null'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RBMBackedTimestampSetInRange.test(RBMBackedTimestampSet)"})
  void testTestWithRBMBackedTimestampSet_whenNull_thenThrowIllegalArgumentException() {
    // Arrange
    Integer startTime = Integer.valueOf(1);
    RBMBackedTimestampSetInRange rbmBackedTimestampSetInRange =
        new RBMBackedTimestampSetInRange(startTime, Integer.valueOf(1));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> rbmBackedTimestampSetInRange.test(null));
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link RBMBackedTimestampSetInRange#endTime(Number)}
   *   <li>{@link RBMBackedTimestampSetInRange#includeAllTimestamps(Boolean)}
   *   <li>{@link RBMBackedTimestampSetInRange#setEndTime(Number)}
   *   <li>{@link RBMBackedTimestampSetInRange#setIncludeAllTimestamps(Boolean)}
   *   <li>{@link RBMBackedTimestampSetInRange#setStartTime(Number)}
   *   <li>{@link RBMBackedTimestampSetInRange#setTimeUnit(TimeUnit)}
   *   <li>{@link RBMBackedTimestampSetInRange#startTime(Number)}
   *   <li>{@link RBMBackedTimestampSetInRange#timeUnit(TimeUnit)}
   *   <li>{@link RBMBackedTimestampSetInRange#getEndTime()}
   *   <li>{@link RBMBackedTimestampSetInRange#getStartTime()}
   *   <li>{@link RBMBackedTimestampSetInRange#getTimeUnit()}
   *   <li>{@link RBMBackedTimestampSetInRange#isIncludeAllTimestamps()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "RBMBackedTimestampSetInRange RBMBackedTimestampSetInRange.endTime(Number)",
    "Number RBMBackedTimestampSetInRange.getEndTime()",
    "Number RBMBackedTimestampSetInRange.getStartTime()",
    "TimeUnit RBMBackedTimestampSetInRange.getTimeUnit()",
    "RBMBackedTimestampSetInRange RBMBackedTimestampSetInRange.includeAllTimestamps(Boolean)",
    "Boolean RBMBackedTimestampSetInRange.isIncludeAllTimestamps()",
    "void RBMBackedTimestampSetInRange.setEndTime(Number)",
    "void RBMBackedTimestampSetInRange.setIncludeAllTimestamps(Boolean)",
    "void RBMBackedTimestampSetInRange.setStartTime(Number)",
    "void RBMBackedTimestampSetInRange.setTimeUnit(TimeUnit)",
    "RBMBackedTimestampSetInRange RBMBackedTimestampSetInRange.startTime(Number)",
    "RBMBackedTimestampSetInRange RBMBackedTimestampSetInRange.timeUnit(TimeUnit)"
  })
  void testGettersAndSetters() {
    // Arrange
    RBMBackedTimestampSetInRange rbmBackedTimestampSetInRange = new RBMBackedTimestampSetInRange();

    // Act
    RBMBackedTimestampSetInRange actualEndTimeResult =
        rbmBackedTimestampSetInRange.endTime(Integer.valueOf(1));
    RBMBackedTimestampSetInRange actualIncludeAllTimestampsResult =
        rbmBackedTimestampSetInRange.includeAllTimestamps(true);
    rbmBackedTimestampSetInRange.setEndTime(Integer.valueOf(1));
    rbmBackedTimestampSetInRange.setIncludeAllTimestamps(true);
    rbmBackedTimestampSetInRange.setStartTime(Integer.valueOf(1));
    rbmBackedTimestampSetInRange.setTimeUnit(TimeUnit.DAY);
    Integer startTime = Integer.valueOf(1);
    RBMBackedTimestampSetInRange actualStartTimeResult =
        rbmBackedTimestampSetInRange.startTime(startTime);
    RBMBackedTimestampSetInRange actualTimeUnitResult =
        rbmBackedTimestampSetInRange.timeUnit(TimeUnit.DAY);
    Number actualEndTime = rbmBackedTimestampSetInRange.getEndTime();
    Number actualStartTime = rbmBackedTimestampSetInRange.getStartTime();
    TimeUnit actualTimeUnit = rbmBackedTimestampSetInRange.getTimeUnit();

    // Assert
    assertEquals(TimeUnit.DAY, actualTimeUnit);
    assertTrue(rbmBackedTimestampSetInRange.isIncludeAllTimestamps());
    assertSame(rbmBackedTimestampSetInRange, actualEndTimeResult);
    assertSame(rbmBackedTimestampSetInRange, actualIncludeAllTimestampsResult);
    assertSame(rbmBackedTimestampSetInRange, actualStartTimeResult);
    assertSame(rbmBackedTimestampSetInRange, actualTimeUnitResult);
    assertSame(startTime, actualEndTime);
    assertSame(startTime, actualStartTime);
  }

  /**
   * Test {@link RBMBackedTimestampSetInRange#setIncludeAllTimestamps()}.
   *
   * <p>Method under test: {@link RBMBackedTimestampSetInRange#setIncludeAllTimestamps()}
   */
  @Test
  @DisplayName("Test setIncludeAllTimestamps()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void RBMBackedTimestampSetInRange.setIncludeAllTimestamps()"})
  void testSetIncludeAllTimestamps() {
    // Arrange
    RBMBackedTimestampSetInRange rbmBackedTimestampSetInRange = new RBMBackedTimestampSetInRange();

    // Act
    rbmBackedTimestampSetInRange.setIncludeAllTimestamps();

    // Assert
    assertTrue(rbmBackedTimestampSetInRange.isIncludeAllTimestamps());
  }

  /**
   * Test {@link RBMBackedTimestampSetInRange#includeAllTimestamps()}.
   *
   * <p>Method under test: {@link RBMBackedTimestampSetInRange#includeAllTimestamps()}
   */
  @Test
  @DisplayName("Test includeAllTimestamps()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "RBMBackedTimestampSetInRange RBMBackedTimestampSetInRange.includeAllTimestamps()"
  })
  void testIncludeAllTimestamps() {
    // Arrange
    RBMBackedTimestampSetInRange rbmBackedTimestampSetInRange = new RBMBackedTimestampSetInRange();

    // Act
    RBMBackedTimestampSetInRange actualIncludeAllTimestampsResult =
        rbmBackedTimestampSetInRange.includeAllTimestamps();

    // Assert
    assertTrue(rbmBackedTimestampSetInRange.isIncludeAllTimestamps());
    assertSame(rbmBackedTimestampSetInRange, actualIncludeAllTimestampsResult);
  }
}
