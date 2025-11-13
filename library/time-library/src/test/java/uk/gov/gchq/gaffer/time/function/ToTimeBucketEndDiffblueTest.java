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

class ToTimeBucketEndDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ToTimeBucketEnd#ToTimeBucketEnd()}
   *   <li>{@link ToTimeBucketEnd#setBucket(TimeBucket)}
   *   <li>{@link ToTimeBucketEnd#getBucket()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void ToTimeBucketEnd.<init>()", "void ToTimeBucketEnd.<init>(TimeBucket)",
      "TimeBucket ToTimeBucketEnd.getBucket()", "void ToTimeBucketEnd.setBucket(TimeBucket)"})
  void testGettersAndSetters() {
    // Arrange and Act
    ToTimeBucketEnd actualToTimeBucketEnd = new ToTimeBucketEnd();
    actualToTimeBucketEnd.setBucket(TimeBucket.SECOND);

    // Assert
    assertEquals(TimeBucket.SECOND, actualToTimeBucketEnd.getBucket());
  }

  /**
   * Test getters and setters.
   * <ul>
   *   <li>When {@code SECOND}.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ToTimeBucketEnd#ToTimeBucketEnd(TimeBucket)}
   *   <li>{@link ToTimeBucketEnd#setBucket(TimeBucket)}
   *   <li>{@link ToTimeBucketEnd#getBucket()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; when 'SECOND'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void ToTimeBucketEnd.<init>()", "void ToTimeBucketEnd.<init>(TimeBucket)",
      "TimeBucket ToTimeBucketEnd.getBucket()", "void ToTimeBucketEnd.setBucket(TimeBucket)"})
  void testGettersAndSetters_whenSecond() {
    // Arrange and Act
    ToTimeBucketEnd actualToTimeBucketEnd = new ToTimeBucketEnd(TimeBucket.SECOND);
    actualToTimeBucketEnd.setBucket(TimeBucket.SECOND);

    // Assert
    assertEquals(TimeBucket.SECOND, actualToTimeBucketEnd.getBucket());
  }

  /**
   * Test {@link ToTimeBucketEnd#apply(Long)} with {@code Long}.
   * <ul>
   *   <li>Then return longValue is {@code 59999}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ToTimeBucketEnd#apply(Long)}
   */
  @Test
  @DisplayName("Test apply(Long) with 'Long'; then return longValue is '59999'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Long ToTimeBucketEnd.apply(Long)"})
  void testApplyWithLong_thenReturnLongValueIs59999() {
    // Arrange
    ToTimeBucketEnd toTimeBucketEnd = new ToTimeBucketEnd(TimeBucket.SECOND);
    toTimeBucketEnd.setBucket(TimeBucket.MINUTE);

    // Act and Assert
    assertEquals(59999L, toTimeBucketEnd.apply(10L).longValue());
  }

  /**
   * Test {@link ToTimeBucketEnd#apply(Long)} with {@code Long}.
   * <ul>
   *   <li>Then return longValue is {@code 3599999}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ToTimeBucketEnd#apply(Long)}
   */
  @Test
  @DisplayName("Test apply(Long) with 'Long'; then return longValue is '3599999'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Long ToTimeBucketEnd.apply(Long)"})
  void testApplyWithLong_thenReturnLongValueIs3599999() {
    // Arrange
    ToTimeBucketEnd toTimeBucketEnd = new ToTimeBucketEnd(TimeBucket.SECOND);
    toTimeBucketEnd.setBucket(TimeBucket.HOUR);

    // Act and Assert
    assertEquals(3599999L, toTimeBucketEnd.apply(10L).longValue());
  }

  /**
   * Test {@link ToTimeBucketEnd#apply(Long)} with {@code Long}.
   * <ul>
   *   <li>Then return longValue is {@code 86399999}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ToTimeBucketEnd#apply(Long)}
   */
  @Test
  @DisplayName("Test apply(Long) with 'Long'; then return longValue is '86399999'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Long ToTimeBucketEnd.apply(Long)"})
  void testApplyWithLong_thenReturnLongValueIs86399999() {
    // Arrange
    ToTimeBucketEnd toTimeBucketEnd = new ToTimeBucketEnd(TimeBucket.SECOND);
    toTimeBucketEnd.setBucket(TimeBucket.DAY);

    // Act and Assert
    assertEquals(86399999L, toTimeBucketEnd.apply(10L).longValue());
  }

  /**
   * Test {@link ToTimeBucketEnd#apply(Long)} with {@code Long}.
   * <ul>
   *   <li>Then return longValue is {@code 345599999}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ToTimeBucketEnd#apply(Long)}
   */
  @Test
  @DisplayName("Test apply(Long) with 'Long'; then return longValue is '345599999'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Long ToTimeBucketEnd.apply(Long)"})
  void testApplyWithLong_thenReturnLongValueIs345599999() {
    // Arrange
    ToTimeBucketEnd toTimeBucketEnd = new ToTimeBucketEnd(TimeBucket.SECOND);
    toTimeBucketEnd.setBucket(TimeBucket.WEEK);

    // Act and Assert
    assertEquals(345599999L, toTimeBucketEnd.apply(10L).longValue());
  }

  /**
   * Test {@link ToTimeBucketEnd#apply(Long)} with {@code Long}.
   * <ul>
   *   <li>Then return longValue is {@code 2678399999}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ToTimeBucketEnd#apply(Long)}
   */
  @Test
  @DisplayName("Test apply(Long) with 'Long'; then return longValue is '2678399999'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Long ToTimeBucketEnd.apply(Long)"})
  void testApplyWithLong_thenReturnLongValueIs2678399999() {
    // Arrange
    ToTimeBucketEnd toTimeBucketEnd = new ToTimeBucketEnd(TimeBucket.SECOND);
    toTimeBucketEnd.setBucket(TimeBucket.MONTH);

    // Act and Assert
    assertEquals(2678399999L, toTimeBucketEnd.apply(10L).longValue());
  }

  /**
   * Test {@link ToTimeBucketEnd#apply(Long)} with {@code Long}.
   * <ul>
   *   <li>Then return longValue is {@code 31535999999}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ToTimeBucketEnd#apply(Long)}
   */
  @Test
  @DisplayName("Test apply(Long) with 'Long'; then return longValue is '31535999999'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Long ToTimeBucketEnd.apply(Long)"})
  void testApplyWithLong_thenReturnLongValueIs31535999999() {
    // Arrange
    ToTimeBucketEnd toTimeBucketEnd = new ToTimeBucketEnd(TimeBucket.SECOND);
    toTimeBucketEnd.setBucket(TimeBucket.YEAR);

    // Act and Assert
    assertEquals(31535999999L, toTimeBucketEnd.apply(10L).longValue());
  }

  /**
   * Test {@link ToTimeBucketEnd#apply(Long)} with {@code Long}.
   * <ul>
   *   <li>Then return longValue is nine hundred ninety-nine.</li>
   * </ul>
   * <p>
   * Method under test: {@link ToTimeBucketEnd#apply(Long)}
   */
  @Test
  @DisplayName("Test apply(Long) with 'Long'; then return longValue is nine hundred ninety-nine")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Long ToTimeBucketEnd.apply(Long)"})
  void testApplyWithLong_thenReturnLongValueIsNineHundredNinetyNine() {
    // Arrange, Act and Assert
    assertEquals(999L, (new ToTimeBucketEnd(TimeBucket.SECOND)).apply(10L).longValue());
  }

  /**
   * Test {@link ToTimeBucketEnd#apply(Long)} with {@code Long}.
   * <ul>
   *   <li>Then return longValue is ten.</li>
   * </ul>
   * <p>
   * Method under test: {@link ToTimeBucketEnd#apply(Long)}
   */
  @Test
  @DisplayName("Test apply(Long) with 'Long'; then return longValue is ten")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Long ToTimeBucketEnd.apply(Long)"})
  void testApplyWithLong_thenReturnLongValueIsTen() {
    // Arrange
    ToTimeBucketEnd toTimeBucketEnd = new ToTimeBucketEnd(TimeBucket.SECOND);
    toTimeBucketEnd.setBucket(TimeBucket.MILLISECOND);

    // Act and Assert
    assertEquals(10L, toTimeBucketEnd.apply(10L).longValue());
  }
}
