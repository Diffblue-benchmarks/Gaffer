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
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.time.CommonTimeUtil;

class ToTimeBucketEndDiffblueTest {
  /**
   * Method under test: {@link ToTimeBucketEnd#apply(Long)}
   */
  @Test
  void testApply() {
    // Arrange, Act and Assert
    assertEquals(999L, (new ToTimeBucketEnd(CommonTimeUtil.TimeBucket.SECOND)).apply(10L).longValue());
  }

  /**
   * Method under test: {@link ToTimeBucketEnd#apply(Long)}
   */
  @Test
  void testApply2() {
    // Arrange
    ToTimeBucketEnd toTimeBucketEnd = new ToTimeBucketEnd(CommonTimeUtil.TimeBucket.SECOND);
    toTimeBucketEnd.setBucket(CommonTimeUtil.TimeBucket.MILLISECOND);

    // Act and Assert
    assertEquals(10L, toTimeBucketEnd.apply(10L).longValue());
  }

  /**
   * Method under test: {@link ToTimeBucketEnd#apply(Long)}
   */
  @Test
  void testApply3() {
    // Arrange
    ToTimeBucketEnd toTimeBucketEnd = new ToTimeBucketEnd(CommonTimeUtil.TimeBucket.SECOND);
    toTimeBucketEnd.setBucket(CommonTimeUtil.TimeBucket.MINUTE);

    // Act and Assert
    assertEquals(59999L, toTimeBucketEnd.apply(10L).longValue());
  }

  /**
   * Method under test: {@link ToTimeBucketEnd#apply(Long)}
   */
  @Test
  void testApply4() {
    // Arrange
    ToTimeBucketEnd toTimeBucketEnd = new ToTimeBucketEnd(CommonTimeUtil.TimeBucket.SECOND);
    toTimeBucketEnd.setBucket(CommonTimeUtil.TimeBucket.HOUR);

    // Act and Assert
    assertEquals(3599999L, toTimeBucketEnd.apply(10L).longValue());
  }

  /**
   * Method under test: {@link ToTimeBucketEnd#apply(Long)}
   */
  @Test
  void testApply5() {
    // Arrange
    ToTimeBucketEnd toTimeBucketEnd = new ToTimeBucketEnd(CommonTimeUtil.TimeBucket.SECOND);
    toTimeBucketEnd.setBucket(CommonTimeUtil.TimeBucket.DAY);

    // Act and Assert
    assertEquals(86399999L, toTimeBucketEnd.apply(10L).longValue());
  }

  /**
   * Method under test: {@link ToTimeBucketEnd#apply(Long)}
   */
  @Test
  void testApply6() {
    // Arrange
    ToTimeBucketEnd toTimeBucketEnd = new ToTimeBucketEnd(CommonTimeUtil.TimeBucket.SECOND);
    toTimeBucketEnd.setBucket(CommonTimeUtil.TimeBucket.WEEK);

    // Act and Assert
    assertEquals(345599999L, toTimeBucketEnd.apply(10L).longValue());
  }

  /**
   * Method under test: {@link ToTimeBucketEnd#apply(Long)}
   */
  @Test
  void testApply7() {
    // Arrange
    ToTimeBucketEnd toTimeBucketEnd = new ToTimeBucketEnd(CommonTimeUtil.TimeBucket.SECOND);
    toTimeBucketEnd.setBucket(CommonTimeUtil.TimeBucket.MONTH);

    // Act and Assert
    assertEquals(2678399999L, toTimeBucketEnd.apply(10L).longValue());
  }

  /**
   * Method under test: {@link ToTimeBucketEnd#apply(Long)}
   */
  @Test
  void testApply8() {
    // Arrange
    ToTimeBucketEnd toTimeBucketEnd = new ToTimeBucketEnd(CommonTimeUtil.TimeBucket.SECOND);
    toTimeBucketEnd.setBucket(CommonTimeUtil.TimeBucket.YEAR);

    // Act and Assert
    assertEquals(31535999999L, toTimeBucketEnd.apply(10L).longValue());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ToTimeBucketEnd#ToTimeBucketEnd()}
   *   <li>{@link ToTimeBucketEnd#setBucket(CommonTimeUtil.TimeBucket)}
   *   <li>{@link ToTimeBucketEnd#getBucket()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    ToTimeBucketEnd actualToTimeBucketEnd = new ToTimeBucketEnd();
    actualToTimeBucketEnd.setBucket(CommonTimeUtil.TimeBucket.SECOND);

    // Assert that nothing has changed
    assertEquals(CommonTimeUtil.TimeBucket.SECOND, actualToTimeBucketEnd.getBucket());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ToTimeBucketEnd#ToTimeBucketEnd(CommonTimeUtil.TimeBucket)}
   *   <li>{@link ToTimeBucketEnd#setBucket(CommonTimeUtil.TimeBucket)}
   *   <li>{@link ToTimeBucketEnd#getBucket()}
   * </ul>
   */
  @Test
  void testGettersAndSetters2() {
    // Arrange and Act
    ToTimeBucketEnd actualToTimeBucketEnd = new ToTimeBucketEnd(CommonTimeUtil.TimeBucket.SECOND);
    actualToTimeBucketEnd.setBucket(CommonTimeUtil.TimeBucket.SECOND);

    // Assert that nothing has changed
    assertEquals(CommonTimeUtil.TimeBucket.SECOND, actualToTimeBucketEnd.getBucket());
  }
}
