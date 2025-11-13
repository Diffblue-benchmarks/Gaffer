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
import static org.junit.jupiter.api.Assertions.assertNull;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.Date;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.time.CommonTimeUtil;
import uk.gov.gchq.gaffer.time.CommonTimeUtil.TimeBucket;

class DateToTimeBucketEndDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link DateToTimeBucketEnd#DateToTimeBucketEnd()}
   *   <li>{@link DateToTimeBucketEnd#setBucket(TimeBucket)}
   *   <li>{@link DateToTimeBucketEnd#getBucket()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void DateToTimeBucketEnd.<init>()", "void DateToTimeBucketEnd.<init>(TimeBucket)",
      "TimeBucket DateToTimeBucketEnd.getBucket()", "void DateToTimeBucketEnd.setBucket(TimeBucket)"})
  void testGettersAndSetters() {
    // Arrange and Act
    DateToTimeBucketEnd actualDateToTimeBucketEnd = new DateToTimeBucketEnd();
    actualDateToTimeBucketEnd.setBucket(TimeBucket.SECOND);

    // Assert
    assertEquals(TimeBucket.SECOND, actualDateToTimeBucketEnd.getBucket());
  }

  /**
   * Test getters and setters.
   * <ul>
   *   <li>When {@code SECOND}.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link DateToTimeBucketEnd#DateToTimeBucketEnd(TimeBucket)}
   *   <li>{@link DateToTimeBucketEnd#setBucket(TimeBucket)}
   *   <li>{@link DateToTimeBucketEnd#getBucket()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; when 'SECOND'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void DateToTimeBucketEnd.<init>()", "void DateToTimeBucketEnd.<init>(TimeBucket)",
      "TimeBucket DateToTimeBucketEnd.getBucket()", "void DateToTimeBucketEnd.setBucket(TimeBucket)"})
  void testGettersAndSetters_whenSecond() {
    // Arrange and Act
    DateToTimeBucketEnd actualDateToTimeBucketEnd = new DateToTimeBucketEnd(TimeBucket.SECOND);
    actualDateToTimeBucketEnd.setBucket(TimeBucket.SECOND);

    // Assert
    assertEquals(TimeBucket.SECOND, actualDateToTimeBucketEnd.getBucket());
  }

  /**
   * Test {@link DateToTimeBucketEnd#apply(Date)} with {@code Date}.
   * <ul>
   *   <li>Then return {@link SimpleDateFormat#SimpleDateFormat(String)} with {@code yyyy-MM-dd} format is {@code 1970-01-01}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DateToTimeBucketEnd#apply(Date)}
   */
  @Test
  @DisplayName("Test apply(Date) with 'Date'; then return SimpleDateFormat(String) with 'yyyy-MM-dd' format is '1970-01-01'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Date DateToTimeBucketEnd.apply(Date)"})
  void testApplyWithDate_thenReturnSimpleDateFormatWithYyyyMmDdFormatIs19700101() {
    // Arrange
    DateToTimeBucketEnd dateToTimeBucketEnd = new DateToTimeBucketEnd(TimeBucket.SECOND);
    dateToTimeBucketEnd.setBucket(TimeBucket.DAY);

    // Act
    Date actualApplyResult = dateToTimeBucketEnd
        .apply(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    // Assert
    assertEquals("1970-01-01", (new SimpleDateFormat("yyyy-MM-dd")).format(actualApplyResult));
  }

  /**
   * Test {@link DateToTimeBucketEnd#apply(Date)} with {@code Date}.
   * <ul>
   *   <li>Then return {@link SimpleDateFormat#SimpleDateFormat(String)} with {@code yyyy-MM-dd} format is {@code 1970-01-04}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DateToTimeBucketEnd#apply(Date)}
   */
  @Test
  @DisplayName("Test apply(Date) with 'Date'; then return SimpleDateFormat(String) with 'yyyy-MM-dd' format is '1970-01-04'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Date DateToTimeBucketEnd.apply(Date)"})
  void testApplyWithDate_thenReturnSimpleDateFormatWithYyyyMmDdFormatIs19700104() {
    // Arrange
    DateToTimeBucketEnd dateToTimeBucketEnd = new DateToTimeBucketEnd(TimeBucket.SECOND);
    dateToTimeBucketEnd.setBucket(TimeBucket.WEEK);

    // Act
    Date actualApplyResult = dateToTimeBucketEnd
        .apply(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    // Assert
    assertEquals("1970-01-04", (new SimpleDateFormat("yyyy-MM-dd")).format(actualApplyResult));
  }

  /**
   * Test {@link DateToTimeBucketEnd#apply(Date)} with {@code Date}.
   * <ul>
   *   <li>Then return {@link SimpleDateFormat#SimpleDateFormat(String)} with {@code yyyy-MM-dd} format is {@code 1970-01-31}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DateToTimeBucketEnd#apply(Date)}
   */
  @Test
  @DisplayName("Test apply(Date) with 'Date'; then return SimpleDateFormat(String) with 'yyyy-MM-dd' format is '1970-01-31'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Date DateToTimeBucketEnd.apply(Date)"})
  void testApplyWithDate_thenReturnSimpleDateFormatWithYyyyMmDdFormatIs19700131() {
    // Arrange
    DateToTimeBucketEnd dateToTimeBucketEnd = new DateToTimeBucketEnd(TimeBucket.SECOND);
    dateToTimeBucketEnd.setBucket(TimeBucket.MONTH);

    // Act
    Date actualApplyResult = dateToTimeBucketEnd
        .apply(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    // Assert
    assertEquals("1970-01-31", (new SimpleDateFormat("yyyy-MM-dd")).format(actualApplyResult));
  }

  /**
   * Test {@link DateToTimeBucketEnd#apply(Date)} with {@code Date}.
   * <ul>
   *   <li>Then return {@link SimpleDateFormat#SimpleDateFormat(String)} with {@code yyyy-MM-dd} format is {@code 1970-12-31}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DateToTimeBucketEnd#apply(Date)}
   */
  @Test
  @DisplayName("Test apply(Date) with 'Date'; then return SimpleDateFormat(String) with 'yyyy-MM-dd' format is '1970-12-31'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Date DateToTimeBucketEnd.apply(Date)"})
  void testApplyWithDate_thenReturnSimpleDateFormatWithYyyyMmDdFormatIs19701231() {
    // Arrange
    DateToTimeBucketEnd dateToTimeBucketEnd = new DateToTimeBucketEnd(TimeBucket.SECOND);
    dateToTimeBucketEnd.setBucket(TimeBucket.YEAR);

    // Act
    Date actualApplyResult = dateToTimeBucketEnd
        .apply(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    // Assert
    assertEquals("1970-12-31", (new SimpleDateFormat("yyyy-MM-dd")).format(actualApplyResult));
  }

  /**
   * Test {@link DateToTimeBucketEnd#apply(Date)} with {@code Date}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DateToTimeBucketEnd#apply(Date)}
   */
  @Test
  @DisplayName("Test apply(Date) with 'Date'; when 'null'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Date DateToTimeBucketEnd.apply(Date)"})
  void testApplyWithDate_whenNull_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new DateToTimeBucketEnd(TimeBucket.SECOND)).apply(null));
  }
}
