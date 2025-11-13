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

class ToTimeBucketStartDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ToTimeBucketStart#ToTimeBucketStart()}
   *   <li>{@link ToTimeBucketStart#setBucket(TimeBucket)}
   *   <li>{@link ToTimeBucketStart#getBucket()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void ToTimeBucketStart.<init>()", "void ToTimeBucketStart.<init>(TimeBucket)",
      "TimeBucket ToTimeBucketStart.getBucket()", "void ToTimeBucketStart.setBucket(TimeBucket)"})
  void testGettersAndSetters() {
    // Arrange and Act
    ToTimeBucketStart actualToTimeBucketStart = new ToTimeBucketStart();
    actualToTimeBucketStart.setBucket(TimeBucket.SECOND);

    // Assert
    assertEquals(TimeBucket.SECOND, actualToTimeBucketStart.getBucket());
  }

  /**
   * Test getters and setters.
   * <ul>
   *   <li>When {@code SECOND}.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ToTimeBucketStart#ToTimeBucketStart(TimeBucket)}
   *   <li>{@link ToTimeBucketStart#setBucket(TimeBucket)}
   *   <li>{@link ToTimeBucketStart#getBucket()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; when 'SECOND'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void ToTimeBucketStart.<init>()", "void ToTimeBucketStart.<init>(TimeBucket)",
      "TimeBucket ToTimeBucketStart.getBucket()", "void ToTimeBucketStart.setBucket(TimeBucket)"})
  void testGettersAndSetters_whenSecond() {
    // Arrange and Act
    ToTimeBucketStart actualToTimeBucketStart = new ToTimeBucketStart(TimeBucket.SECOND);
    actualToTimeBucketStart.setBucket(TimeBucket.SECOND);

    // Assert
    assertEquals(TimeBucket.SECOND, actualToTimeBucketStart.getBucket());
  }

  /**
   * Test {@link ToTimeBucketStart#apply(Long)} with {@code Long}.
   * <ul>
   *   <li>Given {@link ToTimeBucketStart#ToTimeBucketStart(TimeBucket)} with bucket is {@code SECOND}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ToTimeBucketStart#apply(Long)}
   */
  @Test
  @DisplayName("Test apply(Long) with 'Long'; given ToTimeBucketStart(TimeBucket) with bucket is 'SECOND'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Long ToTimeBucketStart.apply(Long)"})
  void testApplyWithLong_givenToTimeBucketStartWithBucketIsSecond() {
    // Arrange, Act and Assert
    assertEquals(0L, (new ToTimeBucketStart(TimeBucket.SECOND)).apply(10L).longValue());
  }

  /**
   * Test {@link ToTimeBucketStart#apply(Long)} with {@code Long}.
   * <ul>
   *   <li>Given {@link ToTimeBucketStart#ToTimeBucketStart(TimeBucket)} with bucket is {@code SECOND} Bucket is {@code DAY}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ToTimeBucketStart#apply(Long)}
   */
  @Test
  @DisplayName("Test apply(Long) with 'Long'; given ToTimeBucketStart(TimeBucket) with bucket is 'SECOND' Bucket is 'DAY'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Long ToTimeBucketStart.apply(Long)"})
  void testApplyWithLong_givenToTimeBucketStartWithBucketIsSecondBucketIsDay() {
    // Arrange
    ToTimeBucketStart toTimeBucketStart = new ToTimeBucketStart(TimeBucket.SECOND);
    toTimeBucketStart.setBucket(TimeBucket.DAY);

    // Act and Assert
    assertEquals(0L, toTimeBucketStart.apply(10L).longValue());
  }

  /**
   * Test {@link ToTimeBucketStart#apply(Long)} with {@code Long}.
   * <ul>
   *   <li>Given {@link ToTimeBucketStart#ToTimeBucketStart(TimeBucket)} with bucket is {@code SECOND} Bucket is {@code HOUR}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ToTimeBucketStart#apply(Long)}
   */
  @Test
  @DisplayName("Test apply(Long) with 'Long'; given ToTimeBucketStart(TimeBucket) with bucket is 'SECOND' Bucket is 'HOUR'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Long ToTimeBucketStart.apply(Long)"})
  void testApplyWithLong_givenToTimeBucketStartWithBucketIsSecondBucketIsHour() {
    // Arrange
    ToTimeBucketStart toTimeBucketStart = new ToTimeBucketStart(TimeBucket.SECOND);
    toTimeBucketStart.setBucket(TimeBucket.HOUR);

    // Act and Assert
    assertEquals(0L, toTimeBucketStart.apply(10L).longValue());
  }

  /**
   * Test {@link ToTimeBucketStart#apply(Long)} with {@code Long}.
   * <ul>
   *   <li>Given {@link ToTimeBucketStart#ToTimeBucketStart(TimeBucket)} with bucket is {@code SECOND} Bucket is {@code MINUTE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ToTimeBucketStart#apply(Long)}
   */
  @Test
  @DisplayName("Test apply(Long) with 'Long'; given ToTimeBucketStart(TimeBucket) with bucket is 'SECOND' Bucket is 'MINUTE'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Long ToTimeBucketStart.apply(Long)"})
  void testApplyWithLong_givenToTimeBucketStartWithBucketIsSecondBucketIsMinute() {
    // Arrange
    ToTimeBucketStart toTimeBucketStart = new ToTimeBucketStart(TimeBucket.SECOND);
    toTimeBucketStart.setBucket(TimeBucket.MINUTE);

    // Act and Assert
    assertEquals(0L, toTimeBucketStart.apply(10L).longValue());
  }

  /**
   * Test {@link ToTimeBucketStart#apply(Long)} with {@code Long}.
   * <ul>
   *   <li>Given {@link ToTimeBucketStart#ToTimeBucketStart(TimeBucket)} with bucket is {@code SECOND} Bucket is {@code MONTH}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ToTimeBucketStart#apply(Long)}
   */
  @Test
  @DisplayName("Test apply(Long) with 'Long'; given ToTimeBucketStart(TimeBucket) with bucket is 'SECOND' Bucket is 'MONTH'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Long ToTimeBucketStart.apply(Long)"})
  void testApplyWithLong_givenToTimeBucketStartWithBucketIsSecondBucketIsMonth() {
    // Arrange
    ToTimeBucketStart toTimeBucketStart = new ToTimeBucketStart(TimeBucket.SECOND);
    toTimeBucketStart.setBucket(TimeBucket.MONTH);

    // Act and Assert
    assertEquals(0L, toTimeBucketStart.apply(10L).longValue());
  }

  /**
   * Test {@link ToTimeBucketStart#apply(Long)} with {@code Long}.
   * <ul>
   *   <li>Given {@link ToTimeBucketStart#ToTimeBucketStart(TimeBucket)} with bucket is {@code SECOND} Bucket is {@code YEAR}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ToTimeBucketStart#apply(Long)}
   */
  @Test
  @DisplayName("Test apply(Long) with 'Long'; given ToTimeBucketStart(TimeBucket) with bucket is 'SECOND' Bucket is 'YEAR'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Long ToTimeBucketStart.apply(Long)"})
  void testApplyWithLong_givenToTimeBucketStartWithBucketIsSecondBucketIsYear() {
    // Arrange
    ToTimeBucketStart toTimeBucketStart = new ToTimeBucketStart(TimeBucket.SECOND);
    toTimeBucketStart.setBucket(TimeBucket.YEAR);

    // Act and Assert
    assertEquals(0L, toTimeBucketStart.apply(10L).longValue());
  }

  /**
   * Test {@link ToTimeBucketStart#apply(Long)} with {@code Long}.
   * <ul>
   *   <li>Then return longValue is {@code -259200000}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ToTimeBucketStart#apply(Long)}
   */
  @Test
  @DisplayName("Test apply(Long) with 'Long'; then return longValue is '-259200000'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Long ToTimeBucketStart.apply(Long)"})
  void testApplyWithLong_thenReturnLongValueIs259200000() {
    // Arrange
    ToTimeBucketStart toTimeBucketStart = new ToTimeBucketStart(TimeBucket.SECOND);
    toTimeBucketStart.setBucket(TimeBucket.WEEK);

    // Act and Assert
    assertEquals(-259200000L, toTimeBucketStart.apply(10L).longValue());
  }

  /**
   * Test {@link ToTimeBucketStart#apply(Long)} with {@code Long}.
   * <ul>
   *   <li>Then return longValue is ten.</li>
   * </ul>
   * <p>
   * Method under test: {@link ToTimeBucketStart#apply(Long)}
   */
  @Test
  @DisplayName("Test apply(Long) with 'Long'; then return longValue is ten")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Long ToTimeBucketStart.apply(Long)"})
  void testApplyWithLong_thenReturnLongValueIsTen() {
    // Arrange
    ToTimeBucketStart toTimeBucketStart = new ToTimeBucketStart(TimeBucket.SECOND);
    toTimeBucketStart.setBucket(TimeBucket.MILLISECOND);

    // Act and Assert
    assertEquals(10L, toTimeBucketStart.apply(10L).longValue());
  }
}
