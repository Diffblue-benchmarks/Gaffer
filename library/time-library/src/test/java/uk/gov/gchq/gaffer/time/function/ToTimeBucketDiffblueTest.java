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
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.time.CommonTimeUtil;
import uk.gov.gchq.gaffer.time.CommonTimeUtil.TimeBucket;

class ToTimeBucketDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ToTimeBucket#ToTimeBucket()}
   *   <li>{@link ToTimeBucket#setBucket(TimeBucket)}
   *   <li>{@link ToTimeBucket#getBucket()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void ToTimeBucket.<init>()", "void ToTimeBucket.<init>(TimeBucket)",
      "TimeBucket ToTimeBucket.getBucket()", "void ToTimeBucket.setBucket(TimeBucket)"})
  void testGettersAndSetters() {
    // Arrange and Act
    ToTimeBucket actualToTimeBucket = new ToTimeBucket();
    actualToTimeBucket.setBucket(TimeBucket.SECOND);

    // Assert
    assertEquals(TimeBucket.SECOND, actualToTimeBucket.getBucket());
  }

  /**
   * Test getters and setters.
   * <ul>
   *   <li>When {@code SECOND}.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ToTimeBucket#ToTimeBucket(TimeBucket)}
   *   <li>{@link ToTimeBucket#setBucket(TimeBucket)}
   *   <li>{@link ToTimeBucket#getBucket()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; when 'SECOND'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void ToTimeBucket.<init>()", "void ToTimeBucket.<init>(TimeBucket)",
      "TimeBucket ToTimeBucket.getBucket()", "void ToTimeBucket.setBucket(TimeBucket)"})
  void testGettersAndSetters_whenSecond() {
    // Arrange and Act
    ToTimeBucket actualToTimeBucket = new ToTimeBucket(TimeBucket.SECOND);
    actualToTimeBucket.setBucket(TimeBucket.SECOND);

    // Assert
    assertEquals(TimeBucket.SECOND, actualToTimeBucket.getBucket());
  }

  /**
   * Test {@link ToTimeBucket#apply(Long)} with {@code Long}.
   * <ul>
   *   <li>Given {@link ToTimeBucket#ToTimeBucket(TimeBucket)} with bucket is {@code SECOND} Bucket is {@code DAY}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ToTimeBucket#apply(Long)}
   */
  @Test
  @DisplayName("Test apply(Long) with 'Long'; given ToTimeBucket(TimeBucket) with bucket is 'SECOND' Bucket is 'DAY'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Long ToTimeBucket.apply(Long)"})
  void testApplyWithLong_givenToTimeBucketWithBucketIsSecondBucketIsDay() {
    // Arrange
    ToTimeBucket toTimeBucket = new ToTimeBucket(TimeBucket.SECOND);
    toTimeBucket.setBucket(TimeBucket.DAY);

    // Act and Assert
    assertEquals(0L, toTimeBucket.apply(10L).longValue());
  }

  /**
   * Test {@link ToTimeBucket#apply(Long)} with {@code Long}.
   * <ul>
   *   <li>Given {@link ToTimeBucket#ToTimeBucket(TimeBucket)} with bucket is {@code SECOND} Bucket is {@code HOUR}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ToTimeBucket#apply(Long)}
   */
  @Test
  @DisplayName("Test apply(Long) with 'Long'; given ToTimeBucket(TimeBucket) with bucket is 'SECOND' Bucket is 'HOUR'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Long ToTimeBucket.apply(Long)"})
  void testApplyWithLong_givenToTimeBucketWithBucketIsSecondBucketIsHour() {
    // Arrange
    ToTimeBucket toTimeBucket = new ToTimeBucket(TimeBucket.SECOND);
    toTimeBucket.setBucket(TimeBucket.HOUR);

    // Act and Assert
    assertEquals(0L, toTimeBucket.apply(10L).longValue());
  }

  /**
   * Test {@link ToTimeBucket#apply(Long)} with {@code Long}.
   * <ul>
   *   <li>Given {@link ToTimeBucket#ToTimeBucket(TimeBucket)} with bucket is {@code SECOND} Bucket is {@code MINUTE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ToTimeBucket#apply(Long)}
   */
  @Test
  @DisplayName("Test apply(Long) with 'Long'; given ToTimeBucket(TimeBucket) with bucket is 'SECOND' Bucket is 'MINUTE'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Long ToTimeBucket.apply(Long)"})
  void testApplyWithLong_givenToTimeBucketWithBucketIsSecondBucketIsMinute() {
    // Arrange
    ToTimeBucket toTimeBucket = new ToTimeBucket(TimeBucket.SECOND);
    toTimeBucket.setBucket(TimeBucket.MINUTE);

    // Act and Assert
    assertEquals(0L, toTimeBucket.apply(10L).longValue());
  }

  /**
   * Test {@link ToTimeBucket#apply(Long)} with {@code Long}.
   * <ul>
   *   <li>Given {@link ToTimeBucket#ToTimeBucket(TimeBucket)} with bucket is {@code SECOND} Bucket is {@code MONTH}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ToTimeBucket#apply(Long)}
   */
  @Test
  @DisplayName("Test apply(Long) with 'Long'; given ToTimeBucket(TimeBucket) with bucket is 'SECOND' Bucket is 'MONTH'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Long ToTimeBucket.apply(Long)"})
  void testApplyWithLong_givenToTimeBucketWithBucketIsSecondBucketIsMonth() {
    // Arrange
    ToTimeBucket toTimeBucket = new ToTimeBucket(TimeBucket.SECOND);
    toTimeBucket.setBucket(TimeBucket.MONTH);

    // Act and Assert
    assertEquals(0L, toTimeBucket.apply(10L).longValue());
  }

  /**
   * Test {@link ToTimeBucket#apply(Long)} with {@code Long}.
   * <ul>
   *   <li>Given {@link ToTimeBucket#ToTimeBucket(TimeBucket)} with bucket is {@code SECOND} Bucket is {@code YEAR}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ToTimeBucket#apply(Long)}
   */
  @Test
  @DisplayName("Test apply(Long) with 'Long'; given ToTimeBucket(TimeBucket) with bucket is 'SECOND' Bucket is 'YEAR'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Long ToTimeBucket.apply(Long)"})
  void testApplyWithLong_givenToTimeBucketWithBucketIsSecondBucketIsYear() {
    // Arrange
    ToTimeBucket toTimeBucket = new ToTimeBucket(TimeBucket.SECOND);
    toTimeBucket.setBucket(TimeBucket.YEAR);

    // Act and Assert
    assertEquals(0L, toTimeBucket.apply(10L).longValue());
  }

  /**
   * Test {@link ToTimeBucket#apply(Long)} with {@code Long}.
   * <ul>
   *   <li>Given {@link ToTimeBucket#ToTimeBucket(TimeBucket)} with bucket is {@code SECOND}.</li>
   *   <li>Then return longValue is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link ToTimeBucket#apply(Long)}
   */
  @Test
  @DisplayName("Test apply(Long) with 'Long'; given ToTimeBucket(TimeBucket) with bucket is 'SECOND'; then return longValue is zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Long ToTimeBucket.apply(Long)"})
  void testApplyWithLong_givenToTimeBucketWithBucketIsSecond_thenReturnLongValueIsZero() {
    // Arrange, Act and Assert
    assertEquals(0L, (new ToTimeBucket(TimeBucket.SECOND)).apply(10L).longValue());
  }

  /**
   * Test {@link ToTimeBucket#apply(Long)} with {@code Long}.
   * <ul>
   *   <li>Then return longValue is {@code -259200000}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ToTimeBucket#apply(Long)}
   */
  @Test
  @DisplayName("Test apply(Long) with 'Long'; then return longValue is '-259200000'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Long ToTimeBucket.apply(Long)"})
  void testApplyWithLong_thenReturnLongValueIs259200000() {
    // Arrange
    ToTimeBucket toTimeBucket = new ToTimeBucket(TimeBucket.SECOND);
    toTimeBucket.setBucket(TimeBucket.WEEK);

    // Act and Assert
    assertEquals(-259200000L, toTimeBucket.apply(10L).longValue());
  }

  /**
   * Test {@link ToTimeBucket#apply(Long)} with {@code Long}.
   * <ul>
   *   <li>Then return longValue is ten.</li>
   * </ul>
   * <p>
   * Method under test: {@link ToTimeBucket#apply(Long)}
   */
  @Test
  @DisplayName("Test apply(Long) with 'Long'; then return longValue is ten")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Long ToTimeBucket.apply(Long)"})
  void testApplyWithLong_thenReturnLongValueIsTen() {
    // Arrange
    ToTimeBucket toTimeBucket = new ToTimeBucket(TimeBucket.SECOND);
    toTimeBucket.setBucket(TimeBucket.MILLISECOND);

    // Act and Assert
    assertEquals(10L, toTimeBucket.apply(10L).longValue());
  }
}
