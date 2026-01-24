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
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.time.CommonTimeUtil;
import uk.gov.gchq.gaffer.time.CommonTimeUtil.TimeBucket;

class ToTimeBucketStartDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ToTimeBucketStart#ToTimeBucketStart()}
   *   <li>{@link ToTimeBucketStart#setBucket(TimeBucket)}
   *   <li>{@link ToTimeBucketStart#getBucket()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ToTimeBucketStart.<init>()",
    "void ToTimeBucketStart.<init>(TimeBucket)",
    "TimeBucket ToTimeBucketStart.getBucket()",
    "void ToTimeBucketStart.setBucket(TimeBucket)"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    ToTimeBucketStart actualToTimeBucketStart = new ToTimeBucketStart();
    actualToTimeBucketStart.setBucket(TimeBucket.SECOND);

    // Assert
    assertEquals(TimeBucket.SECOND, actualToTimeBucketStart.getBucket());
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
   *   <li>{@link ToTimeBucketStart#ToTimeBucketStart(TimeBucket)}
   *   <li>{@link ToTimeBucketStart#setBucket(TimeBucket)}
   *   <li>{@link ToTimeBucketStart#getBucket()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; when 'SECOND'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ToTimeBucketStart.<init>()",
    "void ToTimeBucketStart.<init>(TimeBucket)",
    "TimeBucket ToTimeBucketStart.getBucket()",
    "void ToTimeBucketStart.setBucket(TimeBucket)"
  })
  void testGettersAndSetters_whenSecond() {
    // Arrange and Act
    ToTimeBucketStart actualToTimeBucketStart = new ToTimeBucketStart(TimeBucket.SECOND);
    actualToTimeBucketStart.setBucket(TimeBucket.SECOND);

    // Assert
    assertEquals(TimeBucket.SECOND, actualToTimeBucketStart.getBucket());
  }

  /**
   * Test {@link ToTimeBucketStart#apply(Long)} with {@code Long}.
   *
   * <ul>
   *   <li>Given {@link ToTimeBucketStart#ToTimeBucketStart(TimeBucket)} with bucket is {@code DAY}.
   * </ul>
   *
   * <p>Method under test: {@link ToTimeBucketStart#apply(Long)}
   */
  @Test
  @DisplayName(
      "Test apply(Long) with 'Long'; given ToTimeBucketStart(TimeBucket) with bucket is 'DAY'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Long ToTimeBucketStart.apply(Long)"})
  void testApplyWithLong_givenToTimeBucketStartWithBucketIsDay() {
    // Arrange, Act and Assert
    assertEquals(0L, new ToTimeBucketStart(TimeBucket.DAY).apply(10L).longValue());
  }

  /**
   * Test {@link ToTimeBucketStart#apply(Long)} with {@code Long}.
   *
   * <ul>
   *   <li>Given {@link ToTimeBucketStart#ToTimeBucketStart(TimeBucket)} with bucket is {@code
   *       HOUR}.
   * </ul>
   *
   * <p>Method under test: {@link ToTimeBucketStart#apply(Long)}
   */
  @Test
  @DisplayName(
      "Test apply(Long) with 'Long'; given ToTimeBucketStart(TimeBucket) with bucket is 'HOUR'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Long ToTimeBucketStart.apply(Long)"})
  void testApplyWithLong_givenToTimeBucketStartWithBucketIsHour() {
    // Arrange, Act and Assert
    assertEquals(0L, new ToTimeBucketStart(TimeBucket.HOUR).apply(10L).longValue());
  }

  /**
   * Test {@link ToTimeBucketStart#apply(Long)} with {@code Long}.
   *
   * <ul>
   *   <li>Given {@link ToTimeBucketStart#ToTimeBucketStart(TimeBucket)} with bucket is {@code
   *       MINUTE}.
   * </ul>
   *
   * <p>Method under test: {@link ToTimeBucketStart#apply(Long)}
   */
  @Test
  @DisplayName(
      "Test apply(Long) with 'Long'; given ToTimeBucketStart(TimeBucket) with bucket is 'MINUTE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Long ToTimeBucketStart.apply(Long)"})
  void testApplyWithLong_givenToTimeBucketStartWithBucketIsMinute() {
    // Arrange, Act and Assert
    assertEquals(0L, new ToTimeBucketStart(TimeBucket.MINUTE).apply(10L).longValue());
  }

  /**
   * Test {@link ToTimeBucketStart#apply(Long)} with {@code Long}.
   *
   * <ul>
   *   <li>Given {@link ToTimeBucketStart#ToTimeBucketStart(TimeBucket)} with bucket is {@code
   *       MONTH}.
   * </ul>
   *
   * <p>Method under test: {@link ToTimeBucketStart#apply(Long)}
   */
  @Test
  @DisplayName(
      "Test apply(Long) with 'Long'; given ToTimeBucketStart(TimeBucket) with bucket is 'MONTH'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Long ToTimeBucketStart.apply(Long)"})
  void testApplyWithLong_givenToTimeBucketStartWithBucketIsMonth() {
    // Arrange, Act and Assert
    assertEquals(0L, new ToTimeBucketStart(TimeBucket.MONTH).apply(10L).longValue());
  }

  /**
   * Test {@link ToTimeBucketStart#apply(Long)} with {@code Long}.
   *
   * <ul>
   *   <li>Given {@link ToTimeBucketStart#ToTimeBucketStart(TimeBucket)} with bucket is {@code
   *       SECOND}.
   * </ul>
   *
   * <p>Method under test: {@link ToTimeBucketStart#apply(Long)}
   */
  @Test
  @DisplayName(
      "Test apply(Long) with 'Long'; given ToTimeBucketStart(TimeBucket) with bucket is 'SECOND'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Long ToTimeBucketStart.apply(Long)"})
  void testApplyWithLong_givenToTimeBucketStartWithBucketIsSecond() {
    // Arrange, Act and Assert
    assertEquals(0L, new ToTimeBucketStart(TimeBucket.SECOND).apply(10L).longValue());
  }

  /**
   * Test {@link ToTimeBucketStart#apply(Long)} with {@code Long}.
   *
   * <ul>
   *   <li>Given {@link ToTimeBucketStart#ToTimeBucketStart(TimeBucket)} with bucket is {@code
   *       YEAR}.
   * </ul>
   *
   * <p>Method under test: {@link ToTimeBucketStart#apply(Long)}
   */
  @Test
  @DisplayName(
      "Test apply(Long) with 'Long'; given ToTimeBucketStart(TimeBucket) with bucket is 'YEAR'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Long ToTimeBucketStart.apply(Long)"})
  void testApplyWithLong_givenToTimeBucketStartWithBucketIsYear() {
    // Arrange, Act and Assert
    assertEquals(0L, new ToTimeBucketStart(TimeBucket.YEAR).apply(10L).longValue());
  }

  /**
   * Test {@link ToTimeBucketStart#apply(Long)} with {@code Long}.
   *
   * <ul>
   *   <li>Then return longValue is {@code -259200000}.
   * </ul>
   *
   * <p>Method under test: {@link ToTimeBucketStart#apply(Long)}
   */
  @Test
  @DisplayName("Test apply(Long) with 'Long'; then return longValue is '-259200000'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Long ToTimeBucketStart.apply(Long)"})
  void testApplyWithLong_thenReturnLongValueIs259200000() {
    // Arrange, Act and Assert
    assertEquals(-259200000L, new ToTimeBucketStart(TimeBucket.WEEK).apply(10L).longValue());
  }

  /**
   * Test {@link ToTimeBucketStart#apply(Long)} with {@code Long}.
   *
   * <ul>
   *   <li>Then return longValue is ten.
   * </ul>
   *
   * <p>Method under test: {@link ToTimeBucketStart#apply(Long)}
   */
  @Test
  @DisplayName("Test apply(Long) with 'Long'; then return longValue is ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Long ToTimeBucketStart.apply(Long)"})
  void testApplyWithLong_thenReturnLongValueIsTen() {
    // Arrange, Act and Assert
    assertEquals(10L, new ToTimeBucketStart(TimeBucket.MILLISECOND).apply(10L).longValue());
  }
}
