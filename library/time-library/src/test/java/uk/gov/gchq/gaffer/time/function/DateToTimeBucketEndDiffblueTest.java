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
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.Date;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.time.CommonTimeUtil;

class DateToTimeBucketEndDiffblueTest {
  /**
   * Method under test: {@link DateToTimeBucketEnd#apply(Date)}
   */
  @Test
  void testApply() {
    // Arrange
    DateToTimeBucketEnd dateToTimeBucketEnd = new DateToTimeBucketEnd(CommonTimeUtil.TimeBucket.SECOND);
    dateToTimeBucketEnd.setBucket(CommonTimeUtil.TimeBucket.DAY);

    // Act
    Date actualApplyResult = dateToTimeBucketEnd
        .apply(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    // Assert
    assertEquals("1970-01-01", (new SimpleDateFormat("yyyy-MM-dd")).format(actualApplyResult));
  }

  /**
   * Method under test: {@link DateToTimeBucketEnd#apply(Date)}
   */
  @Test
  void testApply2() {
    // Arrange
    DateToTimeBucketEnd dateToTimeBucketEnd = new DateToTimeBucketEnd(CommonTimeUtil.TimeBucket.SECOND);
    dateToTimeBucketEnd.setBucket(CommonTimeUtil.TimeBucket.WEEK);

    // Act
    Date actualApplyResult = dateToTimeBucketEnd
        .apply(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    // Assert
    assertEquals("1970-01-04", (new SimpleDateFormat("yyyy-MM-dd")).format(actualApplyResult));
  }

  /**
   * Method under test: {@link DateToTimeBucketEnd#apply(Date)}
   */
  @Test
  void testApply3() {
    // Arrange
    DateToTimeBucketEnd dateToTimeBucketEnd = new DateToTimeBucketEnd(CommonTimeUtil.TimeBucket.SECOND);
    dateToTimeBucketEnd.setBucket(CommonTimeUtil.TimeBucket.MONTH);

    // Act
    Date actualApplyResult = dateToTimeBucketEnd
        .apply(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    // Assert
    assertEquals("1970-01-31", (new SimpleDateFormat("yyyy-MM-dd")).format(actualApplyResult));
  }

  /**
   * Method under test: {@link DateToTimeBucketEnd#apply(Date)}
   */
  @Test
  void testApply4() {
    // Arrange
    DateToTimeBucketEnd dateToTimeBucketEnd = new DateToTimeBucketEnd(CommonTimeUtil.TimeBucket.SECOND);
    dateToTimeBucketEnd.setBucket(CommonTimeUtil.TimeBucket.YEAR);

    // Act
    Date actualApplyResult = dateToTimeBucketEnd
        .apply(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    // Assert
    assertEquals("1970-12-31", (new SimpleDateFormat("yyyy-MM-dd")).format(actualApplyResult));
  }

  /**
   * Method under test: {@link DateToTimeBucketEnd#apply(java.util.Date)}
   */
  @Test
  void testApply5() {
    // Arrange
    DateToTimeBucketEnd dateToTimeBucketEnd = new DateToTimeBucketEnd(CommonTimeUtil.TimeBucket.SECOND);
    java.sql.Date date = mock(java.sql.Date.class);
    when(date.getTime()).thenReturn(10L);

    // Act
    dateToTimeBucketEnd.apply(date);

    // Assert
    verify(date).getTime();
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link DateToTimeBucketEnd#DateToTimeBucketEnd()}
   *   <li>{@link DateToTimeBucketEnd#setBucket(CommonTimeUtil.TimeBucket)}
   *   <li>{@link DateToTimeBucketEnd#getBucket()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    DateToTimeBucketEnd actualDateToTimeBucketEnd = new DateToTimeBucketEnd();
    actualDateToTimeBucketEnd.setBucket(CommonTimeUtil.TimeBucket.SECOND);

    // Assert that nothing has changed
    assertEquals(CommonTimeUtil.TimeBucket.SECOND, actualDateToTimeBucketEnd.getBucket());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>
   * {@link DateToTimeBucketEnd#DateToTimeBucketEnd(CommonTimeUtil.TimeBucket)}
   *   <li>{@link DateToTimeBucketEnd#setBucket(CommonTimeUtil.TimeBucket)}
   *   <li>{@link DateToTimeBucketEnd#getBucket()}
   * </ul>
   */
  @Test
  void testGettersAndSetters2() {
    // Arrange and Act
    DateToTimeBucketEnd actualDateToTimeBucketEnd = new DateToTimeBucketEnd(CommonTimeUtil.TimeBucket.SECOND);
    actualDateToTimeBucketEnd.setBucket(CommonTimeUtil.TimeBucket.SECOND);

    // Assert that nothing has changed
    assertEquals(CommonTimeUtil.TimeBucket.SECOND, actualDateToTimeBucketEnd.getBucket());
  }
}
