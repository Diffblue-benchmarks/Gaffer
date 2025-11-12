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
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.time.CommonTimeUtil;

class DateToTimeBucketStartDiffblueTest {
  /**
   * Method under test: {@link DateToTimeBucketStart#apply(java.util.Date)}
   */
  @Test
  void testApply() {
    // Arrange
    DateToTimeBucketStart dateToTimeBucketStart = new DateToTimeBucketStart(CommonTimeUtil.TimeBucket.SECOND);
    java.sql.Date date = mock(java.sql.Date.class);
    when(date.getTime()).thenReturn(10L);

    // Act
    dateToTimeBucketStart.apply(date);

    // Assert
    verify(date).getTime();
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link DateToTimeBucketStart#DateToTimeBucketStart()}
   *   <li>{@link DateToTimeBucketStart#setBucket(CommonTimeUtil.TimeBucket)}
   *   <li>{@link DateToTimeBucketStart#getBucket()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    DateToTimeBucketStart actualDateToTimeBucketStart = new DateToTimeBucketStart();
    actualDateToTimeBucketStart.setBucket(CommonTimeUtil.TimeBucket.SECOND);

    // Assert that nothing has changed
    assertEquals(CommonTimeUtil.TimeBucket.SECOND, actualDateToTimeBucketStart.getBucket());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>
   * {@link DateToTimeBucketStart#DateToTimeBucketStart(CommonTimeUtil.TimeBucket)}
   *   <li>{@link DateToTimeBucketStart#setBucket(CommonTimeUtil.TimeBucket)}
   *   <li>{@link DateToTimeBucketStart#getBucket()}
   * </ul>
   */
  @Test
  void testGettersAndSetters2() {
    // Arrange and Act
    DateToTimeBucketStart actualDateToTimeBucketStart = new DateToTimeBucketStart(CommonTimeUtil.TimeBucket.SECOND);
    actualDateToTimeBucketStart.setBucket(CommonTimeUtil.TimeBucket.SECOND);

    // Assert that nothing has changed
    assertEquals(CommonTimeUtil.TimeBucket.SECOND, actualDateToTimeBucketStart.getBucket());
  }
}
