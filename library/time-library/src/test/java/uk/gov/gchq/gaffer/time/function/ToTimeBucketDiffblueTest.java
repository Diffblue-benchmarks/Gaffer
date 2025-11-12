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

class ToTimeBucketDiffblueTest {
  /**
   * Method under test: {@link ToTimeBucket#apply(Long)}
   */
  @Test
  void testApply() {
    // Arrange, Act and Assert
    assertEquals(0L, (new ToTimeBucket(CommonTimeUtil.TimeBucket.SECOND)).apply(10L).longValue());
  }

  /**
   * Method under test: {@link ToTimeBucket#apply(Long)}
   */
  @Test
  void testApply2() {
    // Arrange
    ToTimeBucket toTimeBucket = new ToTimeBucket(CommonTimeUtil.TimeBucket.SECOND);
    toTimeBucket.setBucket(CommonTimeUtil.TimeBucket.MILLISECOND);

    // Act and Assert
    assertEquals(10L, toTimeBucket.apply(10L).longValue());
  }

  /**
   * Method under test: {@link ToTimeBucket#apply(Long)}
   */
  @Test
  void testApply3() {
    // Arrange
    ToTimeBucket toTimeBucket = new ToTimeBucket(CommonTimeUtil.TimeBucket.SECOND);
    toTimeBucket.setBucket(CommonTimeUtil.TimeBucket.MINUTE);

    // Act and Assert
    assertEquals(0L, toTimeBucket.apply(10L).longValue());
  }

  /**
   * Method under test: {@link ToTimeBucket#apply(Long)}
   */
  @Test
  void testApply4() {
    // Arrange
    ToTimeBucket toTimeBucket = new ToTimeBucket(CommonTimeUtil.TimeBucket.SECOND);
    toTimeBucket.setBucket(CommonTimeUtil.TimeBucket.HOUR);

    // Act and Assert
    assertEquals(0L, toTimeBucket.apply(10L).longValue());
  }

  /**
   * Method under test: {@link ToTimeBucket#apply(Long)}
   */
  @Test
  void testApply5() {
    // Arrange
    ToTimeBucket toTimeBucket = new ToTimeBucket(CommonTimeUtil.TimeBucket.SECOND);
    toTimeBucket.setBucket(CommonTimeUtil.TimeBucket.DAY);

    // Act and Assert
    assertEquals(0L, toTimeBucket.apply(10L).longValue());
  }

  /**
   * Method under test: {@link ToTimeBucket#apply(Long)}
   */
  @Test
  void testApply6() {
    // Arrange
    ToTimeBucket toTimeBucket = new ToTimeBucket(CommonTimeUtil.TimeBucket.SECOND);
    toTimeBucket.setBucket(CommonTimeUtil.TimeBucket.WEEK);

    // Act and Assert
    assertEquals(-259200000L, toTimeBucket.apply(10L).longValue());
  }

  /**
   * Method under test: {@link ToTimeBucket#apply(Long)}
   */
  @Test
  void testApply7() {
    // Arrange
    ToTimeBucket toTimeBucket = new ToTimeBucket(CommonTimeUtil.TimeBucket.SECOND);
    toTimeBucket.setBucket(CommonTimeUtil.TimeBucket.MONTH);

    // Act and Assert
    assertEquals(0L, toTimeBucket.apply(10L).longValue());
  }

  /**
   * Method under test: {@link ToTimeBucket#apply(Long)}
   */
  @Test
  void testApply8() {
    // Arrange
    ToTimeBucket toTimeBucket = new ToTimeBucket(CommonTimeUtil.TimeBucket.SECOND);
    toTimeBucket.setBucket(CommonTimeUtil.TimeBucket.YEAR);

    // Act and Assert
    assertEquals(0L, toTimeBucket.apply(10L).longValue());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ToTimeBucket#ToTimeBucket()}
   *   <li>{@link ToTimeBucket#setBucket(CommonTimeUtil.TimeBucket)}
   *   <li>{@link ToTimeBucket#getBucket()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    ToTimeBucket actualToTimeBucket = new ToTimeBucket();
    actualToTimeBucket.setBucket(CommonTimeUtil.TimeBucket.SECOND);

    // Assert that nothing has changed
    assertEquals(CommonTimeUtil.TimeBucket.SECOND, actualToTimeBucket.getBucket());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ToTimeBucket#ToTimeBucket(CommonTimeUtil.TimeBucket)}
   *   <li>{@link ToTimeBucket#setBucket(CommonTimeUtil.TimeBucket)}
   *   <li>{@link ToTimeBucket#getBucket()}
   * </ul>
   */
  @Test
  void testGettersAndSetters2() {
    // Arrange and Act
    ToTimeBucket actualToTimeBucket = new ToTimeBucket(CommonTimeUtil.TimeBucket.SECOND);
    actualToTimeBucket.setBucket(CommonTimeUtil.TimeBucket.SECOND);

    // Assert that nothing has changed
    assertEquals(CommonTimeUtil.TimeBucket.SECOND, actualToTimeBucket.getBucket());
  }
}
