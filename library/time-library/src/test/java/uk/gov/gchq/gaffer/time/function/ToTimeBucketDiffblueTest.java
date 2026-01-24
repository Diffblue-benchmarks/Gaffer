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

class ToTimeBucketDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ToTimeBucket#ToTimeBucket()}
   *   <li>{@link ToTimeBucket#setBucket(TimeBucket)}
   *   <li>{@link ToTimeBucket#getBucket()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ToTimeBucket.<init>()",
    "void ToTimeBucket.<init>(TimeBucket)",
    "TimeBucket ToTimeBucket.getBucket()",
    "void ToTimeBucket.setBucket(TimeBucket)"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    ToTimeBucket actualToTimeBucket = new ToTimeBucket();
    actualToTimeBucket.setBucket(TimeBucket.SECOND);

    // Assert
    assertEquals(TimeBucket.SECOND, actualToTimeBucket.getBucket());
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
   *   <li>{@link ToTimeBucket#ToTimeBucket(TimeBucket)}
   *   <li>{@link ToTimeBucket#setBucket(TimeBucket)}
   *   <li>{@link ToTimeBucket#getBucket()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; when 'SECOND'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ToTimeBucket.<init>()",
    "void ToTimeBucket.<init>(TimeBucket)",
    "TimeBucket ToTimeBucket.getBucket()",
    "void ToTimeBucket.setBucket(TimeBucket)"
  })
  void testGettersAndSetters_whenSecond() {
    // Arrange and Act
    ToTimeBucket actualToTimeBucket = new ToTimeBucket(TimeBucket.SECOND);
    actualToTimeBucket.setBucket(TimeBucket.SECOND);

    // Assert
    assertEquals(TimeBucket.SECOND, actualToTimeBucket.getBucket());
  }

  /**
   * Test {@link ToTimeBucket#apply(Long)} with {@code Long}.
   *
   * <ul>
   *   <li>Given {@link ToTimeBucket#ToTimeBucket(TimeBucket)} with bucket is {@code DAY}.
   *   <li>Then return longValue is zero.
   * </ul>
   *
   * <p>Method under test: {@link ToTimeBucket#apply(Long)}
   */
  @Test
  @DisplayName(
      "Test apply(Long) with 'Long'; given ToTimeBucket(TimeBucket) with bucket is 'DAY'; then return longValue is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Long ToTimeBucket.apply(Long)"})
  void testApplyWithLong_givenToTimeBucketWithBucketIsDay_thenReturnLongValueIsZero() {
    // Arrange, Act and Assert
    assertEquals(0L, new ToTimeBucket(TimeBucket.DAY).apply(10L).longValue());
  }

  /**
   * Test {@link ToTimeBucket#apply(Long)} with {@code Long}.
   *
   * <ul>
   *   <li>Given {@link ToTimeBucket#ToTimeBucket(TimeBucket)} with bucket is {@code HOUR}.
   *   <li>Then return longValue is zero.
   * </ul>
   *
   * <p>Method under test: {@link ToTimeBucket#apply(Long)}
   */
  @Test
  @DisplayName(
      "Test apply(Long) with 'Long'; given ToTimeBucket(TimeBucket) with bucket is 'HOUR'; then return longValue is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Long ToTimeBucket.apply(Long)"})
  void testApplyWithLong_givenToTimeBucketWithBucketIsHour_thenReturnLongValueIsZero() {
    // Arrange, Act and Assert
    assertEquals(0L, new ToTimeBucket(TimeBucket.HOUR).apply(10L).longValue());
  }

  /**
   * Test {@link ToTimeBucket#apply(Long)} with {@code Long}.
   *
   * <ul>
   *   <li>Given {@link ToTimeBucket#ToTimeBucket(TimeBucket)} with bucket is {@code MINUTE}.
   *   <li>Then return longValue is zero.
   * </ul>
   *
   * <p>Method under test: {@link ToTimeBucket#apply(Long)}
   */
  @Test
  @DisplayName(
      "Test apply(Long) with 'Long'; given ToTimeBucket(TimeBucket) with bucket is 'MINUTE'; then return longValue is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Long ToTimeBucket.apply(Long)"})
  void testApplyWithLong_givenToTimeBucketWithBucketIsMinute_thenReturnLongValueIsZero() {
    // Arrange, Act and Assert
    assertEquals(0L, new ToTimeBucket(TimeBucket.MINUTE).apply(10L).longValue());
  }

  /**
   * Test {@link ToTimeBucket#apply(Long)} with {@code Long}.
   *
   * <ul>
   *   <li>Given {@link ToTimeBucket#ToTimeBucket(TimeBucket)} with bucket is {@code MONTH}.
   *   <li>Then return longValue is zero.
   * </ul>
   *
   * <p>Method under test: {@link ToTimeBucket#apply(Long)}
   */
  @Test
  @DisplayName(
      "Test apply(Long) with 'Long'; given ToTimeBucket(TimeBucket) with bucket is 'MONTH'; then return longValue is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Long ToTimeBucket.apply(Long)"})
  void testApplyWithLong_givenToTimeBucketWithBucketIsMonth_thenReturnLongValueIsZero() {
    // Arrange, Act and Assert
    assertEquals(0L, new ToTimeBucket(TimeBucket.MONTH).apply(10L).longValue());
  }

  /**
   * Test {@link ToTimeBucket#apply(Long)} with {@code Long}.
   *
   * <ul>
   *   <li>Given {@link ToTimeBucket#ToTimeBucket(TimeBucket)} with bucket is {@code SECOND}.
   *   <li>Then return longValue is zero.
   * </ul>
   *
   * <p>Method under test: {@link ToTimeBucket#apply(Long)}
   */
  @Test
  @DisplayName(
      "Test apply(Long) with 'Long'; given ToTimeBucket(TimeBucket) with bucket is 'SECOND'; then return longValue is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Long ToTimeBucket.apply(Long)"})
  void testApplyWithLong_givenToTimeBucketWithBucketIsSecond_thenReturnLongValueIsZero() {
    // Arrange, Act and Assert
    assertEquals(0L, new ToTimeBucket(TimeBucket.SECOND).apply(10L).longValue());
  }

  /**
   * Test {@link ToTimeBucket#apply(Long)} with {@code Long}.
   *
   * <ul>
   *   <li>Given {@link ToTimeBucket#ToTimeBucket(TimeBucket)} with bucket is {@code YEAR}.
   *   <li>Then return longValue is zero.
   * </ul>
   *
   * <p>Method under test: {@link ToTimeBucket#apply(Long)}
   */
  @Test
  @DisplayName(
      "Test apply(Long) with 'Long'; given ToTimeBucket(TimeBucket) with bucket is 'YEAR'; then return longValue is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Long ToTimeBucket.apply(Long)"})
  void testApplyWithLong_givenToTimeBucketWithBucketIsYear_thenReturnLongValueIsZero() {
    // Arrange, Act and Assert
    assertEquals(0L, new ToTimeBucket(TimeBucket.YEAR).apply(10L).longValue());
  }

  /**
   * Test {@link ToTimeBucket#apply(Long)} with {@code Long}.
   *
   * <ul>
   *   <li>Then return longValue is {@code -259200000}.
   * </ul>
   *
   * <p>Method under test: {@link ToTimeBucket#apply(Long)}
   */
  @Test
  @DisplayName("Test apply(Long) with 'Long'; then return longValue is '-259200000'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Long ToTimeBucket.apply(Long)"})
  void testApplyWithLong_thenReturnLongValueIs259200000() {
    // Arrange, Act and Assert
    assertEquals(-259200000L, new ToTimeBucket(TimeBucket.WEEK).apply(10L).longValue());
  }

  /**
   * Test {@link ToTimeBucket#apply(Long)} with {@code Long}.
   *
   * <ul>
   *   <li>Then return longValue is ten.
   * </ul>
   *
   * <p>Method under test: {@link ToTimeBucket#apply(Long)}
   */
  @Test
  @DisplayName("Test apply(Long) with 'Long'; then return longValue is ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Long ToTimeBucket.apply(Long)"})
  void testApplyWithLong_thenReturnLongValueIsTen() {
    // Arrange, Act and Assert
    assertEquals(10L, new ToTimeBucket(TimeBucket.MILLISECOND).apply(10L).longValue());
  }
}
