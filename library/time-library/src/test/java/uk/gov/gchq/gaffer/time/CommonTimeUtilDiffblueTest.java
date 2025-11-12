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

package uk.gov.gchq.gaffer.time;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class CommonTimeUtilDiffblueTest {
  /**
   * Method under test:
   * {@link CommonTimeUtil#timeToBucket(long, CommonTimeUtil.TimeBucket)}
   */
  @Test
  void testTimeToBucket() {
    // Arrange, Act and Assert
    assertEquals(0L, CommonTimeUtil.timeToBucket(10L, CommonTimeUtil.TimeBucket.SECOND));
    assertEquals(10L, CommonTimeUtil.timeToBucket(10L, CommonTimeUtil.TimeBucket.MILLISECOND));
    assertEquals(0L, CommonTimeUtil.timeToBucket(10L, CommonTimeUtil.TimeBucket.MINUTE));
    assertEquals(0L, CommonTimeUtil.timeToBucket(10L, CommonTimeUtil.TimeBucket.HOUR));
    assertEquals(0L, CommonTimeUtil.timeToBucket(10L, CommonTimeUtil.TimeBucket.DAY));
    assertEquals(-259200000L, CommonTimeUtil.timeToBucket(10L, CommonTimeUtil.TimeBucket.WEEK));
    assertEquals(0L, CommonTimeUtil.timeToBucket(10L, CommonTimeUtil.TimeBucket.MONTH));
    assertEquals(0L, CommonTimeUtil.timeToBucket(10L, CommonTimeUtil.TimeBucket.YEAR));
  }

  /**
   * Method under test:
   * {@link CommonTimeUtil#timeToBucketStart(long, CommonTimeUtil.TimeBucket)}
   */
  @Test
  void testTimeToBucketStart() {
    // Arrange, Act and Assert
    assertEquals(0L, CommonTimeUtil.timeToBucketStart(10L, CommonTimeUtil.TimeBucket.SECOND));
    assertEquals(10L, CommonTimeUtil.timeToBucketStart(10L, CommonTimeUtil.TimeBucket.MILLISECOND));
    assertEquals(0L, CommonTimeUtil.timeToBucketStart(10L, CommonTimeUtil.TimeBucket.MINUTE));
    assertEquals(0L, CommonTimeUtil.timeToBucketStart(10L, CommonTimeUtil.TimeBucket.HOUR));
    assertEquals(0L, CommonTimeUtil.timeToBucketStart(10L, CommonTimeUtil.TimeBucket.DAY));
    assertEquals(-259200000L, CommonTimeUtil.timeToBucketStart(10L, CommonTimeUtil.TimeBucket.WEEK));
    assertEquals(0L, CommonTimeUtil.timeToBucketStart(10L, CommonTimeUtil.TimeBucket.MONTH));
    assertEquals(0L, CommonTimeUtil.timeToBucketStart(10L, CommonTimeUtil.TimeBucket.YEAR));
  }

  /**
   * Method under test:
   * {@link CommonTimeUtil#timeToBucketEnd(long, CommonTimeUtil.TimeBucket)}
   */
  @Test
  void testTimeToBucketEnd() {
    // Arrange, Act and Assert
    assertEquals(999L, CommonTimeUtil.timeToBucketEnd(10L, CommonTimeUtil.TimeBucket.SECOND));
    assertEquals(10L, CommonTimeUtil.timeToBucketEnd(10L, CommonTimeUtil.TimeBucket.MILLISECOND));
    assertEquals(59999L, CommonTimeUtil.timeToBucketEnd(10L, CommonTimeUtil.TimeBucket.MINUTE));
    assertEquals(3599999L, CommonTimeUtil.timeToBucketEnd(10L, CommonTimeUtil.TimeBucket.HOUR));
    assertEquals(86399999L, CommonTimeUtil.timeToBucketEnd(10L, CommonTimeUtil.TimeBucket.DAY));
    assertEquals(345599999L, CommonTimeUtil.timeToBucketEnd(10L, CommonTimeUtil.TimeBucket.WEEK));
    assertEquals(2678399999L, CommonTimeUtil.timeToBucketEnd(10L, CommonTimeUtil.TimeBucket.MONTH));
    assertEquals(31535999999L, CommonTimeUtil.timeToBucketEnd(10L, CommonTimeUtil.TimeBucket.YEAR));
  }
}
