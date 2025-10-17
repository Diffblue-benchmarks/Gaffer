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
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Date;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.time.CommonTimeUtil;
import uk.gov.gchq.gaffer.time.CommonTimeUtil.TimeBucket;

class DateToTimeBucketStartDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link DateToTimeBucketStart#DateToTimeBucketStart()}
   *   <li>{@link DateToTimeBucketStart#setBucket(TimeBucket)}
   *   <li>{@link DateToTimeBucketStart#getBucket()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DateToTimeBucketStart.<init>()",
    "void DateToTimeBucketStart.<init>(TimeBucket)",
    "TimeBucket DateToTimeBucketStart.getBucket()",
    "void DateToTimeBucketStart.setBucket(TimeBucket)"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    DateToTimeBucketStart actualDateToTimeBucketStart = new DateToTimeBucketStart();
    actualDateToTimeBucketStart.setBucket(TimeBucket.SECOND);

    // Assert
    assertEquals(TimeBucket.SECOND, actualDateToTimeBucketStart.getBucket());
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
   *   <li>{@link DateToTimeBucketStart#DateToTimeBucketStart(TimeBucket)}
   *   <li>{@link DateToTimeBucketStart#setBucket(TimeBucket)}
   *   <li>{@link DateToTimeBucketStart#getBucket()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; when 'SECOND'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DateToTimeBucketStart.<init>()",
    "void DateToTimeBucketStart.<init>(TimeBucket)",
    "TimeBucket DateToTimeBucketStart.getBucket()",
    "void DateToTimeBucketStart.setBucket(TimeBucket)"
  })
  void testGettersAndSetters_whenSecond() {
    // Arrange and Act
    DateToTimeBucketStart actualDateToTimeBucketStart =
        new DateToTimeBucketStart(TimeBucket.SECOND);
    actualDateToTimeBucketStart.setBucket(TimeBucket.SECOND);

    // Assert
    assertEquals(TimeBucket.SECOND, actualDateToTimeBucketStart.getBucket());
  }

  /**
   * Test {@link DateToTimeBucketStart#apply(Date)} with {@code Date}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DateToTimeBucketStart#apply(Date)}
   */
  @Test
  @DisplayName("Test apply(Date) with 'Date'; when 'null'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Date DateToTimeBucketStart.apply(Date)"})
  void testApplyWithDate_whenNull_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new DateToTimeBucketStart(TimeBucket.SECOND).apply(null));
  }
}
