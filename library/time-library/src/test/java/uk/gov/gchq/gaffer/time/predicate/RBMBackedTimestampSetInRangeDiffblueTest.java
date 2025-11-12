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

package uk.gov.gchq.gaffer.time.predicate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.time.LocalDate;
import java.time.ZoneOffset;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.time.CommonTimeUtil;
import uk.gov.gchq.gaffer.time.RBMBackedTimestampSet;
import uk.gov.gchq.koryphe.util.TimeUnit;

class RBMBackedTimestampSetInRangeDiffblueTest {
  /**
   * Method under test:
   * {@link RBMBackedTimestampSetInRange#test(RBMBackedTimestampSet)}
   */
  @Test
  void testTest() {
    // Arrange
    RBMBackedTimestampSetInRange rbmBackedTimestampSetInRange = new RBMBackedTimestampSetInRange();

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> rbmBackedTimestampSetInRange.test(new RBMBackedTimestampSet(CommonTimeUtil.TimeBucket.SECOND)));
  }

  /**
   * Method under test:
   * {@link RBMBackedTimestampSetInRange#test(RBMBackedTimestampSet)}
   */
  @Test
  void testTest2() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> (new RBMBackedTimestampSetInRange()).test(null));
  }

  /**
   * Method under test:
   * {@link RBMBackedTimestampSetInRange#test(RBMBackedTimestampSet)}
   */
  @Test
  void testTest3() {
    // Arrange
    RBMBackedTimestampSetInRange rbmBackedTimestampSetInRange = new RBMBackedTimestampSetInRange();

    // Act and Assert
    assertTrue(rbmBackedTimestampSetInRange.test(new RBMBackedTimestampSet(CommonTimeUtil.TimeBucket.SECOND,
        LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant())));
  }

  /**
   * Method under test:
   * {@link RBMBackedTimestampSetInRange#test(RBMBackedTimestampSet)}
   */
  @Test
  void testTest4() {
    // Arrange
    Integer startTime = Integer.valueOf(1);
    RBMBackedTimestampSetInRange rbmBackedTimestampSetInRange = new RBMBackedTimestampSetInRange(startTime,
        Integer.valueOf(1));

    // Act and Assert
    assertTrue(rbmBackedTimestampSetInRange.test(new RBMBackedTimestampSet(CommonTimeUtil.TimeBucket.SECOND,
        LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant())));
  }

  /**
   * Method under test:
   * {@link RBMBackedTimestampSetInRange#test(RBMBackedTimestampSet)}
   */
  @Test
  void testTest5() {
    // Arrange
    Integer startTime = Integer.valueOf(1);
    RBMBackedTimestampSetInRange rbmBackedTimestampSetInRange = new RBMBackedTimestampSetInRange(startTime,
        Integer.valueOf(1), TimeUnit.DAY);

    // Act and Assert
    assertFalse(rbmBackedTimestampSetInRange.test(new RBMBackedTimestampSet(CommonTimeUtil.TimeBucket.SECOND,
        LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant())));
  }

  /**
   * Method under test:
   * {@link RBMBackedTimestampSetInRange#test(RBMBackedTimestampSet)}
   */
  @Test
  void testTest6() {
    // Arrange
    RBMBackedTimestampSetInRange rbmBackedTimestampSetInRange = new RBMBackedTimestampSetInRange();

    // Act and Assert
    assertTrue(rbmBackedTimestampSetInRange.test(new RBMBackedTimestampSet(CommonTimeUtil.TimeBucket.MINUTE,
        LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant())));
  }

  /**
   * Method under test:
   * {@link RBMBackedTimestampSetInRange#test(RBMBackedTimestampSet)}
   */
  @Test
  void testTest7() {
    // Arrange
    RBMBackedTimestampSetInRange rbmBackedTimestampSetInRange = new RBMBackedTimestampSetInRange();

    // Act and Assert
    assertTrue(rbmBackedTimestampSetInRange.test(new RBMBackedTimestampSet(CommonTimeUtil.TimeBucket.HOUR,
        LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant())));
  }

  /**
   * Method under test:
   * {@link RBMBackedTimestampSetInRange#test(RBMBackedTimestampSet)}
   */
  @Test
  void testTest8() {
    // Arrange
    RBMBackedTimestampSetInRange rbmBackedTimestampSetInRange = new RBMBackedTimestampSetInRange();

    // Act and Assert
    assertTrue(rbmBackedTimestampSetInRange.test(new RBMBackedTimestampSet(CommonTimeUtil.TimeBucket.DAY,
        LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant())));
  }

  /**
   * Method under test:
   * {@link RBMBackedTimestampSetInRange#test(RBMBackedTimestampSet)}
   */
  @Test
  void testTest9() {
    // Arrange
    RBMBackedTimestampSetInRange rbmBackedTimestampSetInRange = new RBMBackedTimestampSetInRange();
    rbmBackedTimestampSetInRange.setStartTime(Integer.valueOf(1));

    // Act and Assert
    assertTrue(rbmBackedTimestampSetInRange.test(new RBMBackedTimestampSet(CommonTimeUtil.TimeBucket.SECOND,
        LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant())));
  }

  /**
   * Method under test:
   * {@link RBMBackedTimestampSetInRange#test(RBMBackedTimestampSet)}
   */
  @Test
  void testTest10() {
    // Arrange
    RBMBackedTimestampSetInRange rbmBackedTimestampSetInRange = new RBMBackedTimestampSetInRange();
    rbmBackedTimestampSetInRange.setIncludeAllTimestamps(true);

    // Act and Assert
    assertTrue(rbmBackedTimestampSetInRange.test(new RBMBackedTimestampSet(CommonTimeUtil.TimeBucket.SECOND,
        LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant())));
  }

  /**
   * Method under test:
   * {@link RBMBackedTimestampSetInRange#test(RBMBackedTimestampSet)}
   */
  @Test
  void testTest11() {
    // Arrange
    Integer startTime = Integer.valueOf(0);
    RBMBackedTimestampSetInRange rbmBackedTimestampSetInRange = new RBMBackedTimestampSetInRange(startTime,
        Integer.valueOf(1));

    // Act and Assert
    assertTrue(rbmBackedTimestampSetInRange.test(new RBMBackedTimestampSet(CommonTimeUtil.TimeBucket.SECOND,
        LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant())));
  }

  /**
   * Method under test:
   * {@link RBMBackedTimestampSetInRange#test(RBMBackedTimestampSet)}
   */
  @Test
  void testTest12() {
    // Arrange
    Integer startTime = Integer.valueOf(-1);
    RBMBackedTimestampSetInRange rbmBackedTimestampSetInRange = new RBMBackedTimestampSetInRange(startTime,
        Integer.valueOf(1));

    // Act and Assert
    assertFalse(rbmBackedTimestampSetInRange.test(new RBMBackedTimestampSet(CommonTimeUtil.TimeBucket.SECOND,
        LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant())));
  }

  /**
   * Method under test:
   * {@link RBMBackedTimestampSetInRange#test(RBMBackedTimestampSet)}
   */
  @Test
  void testTest13() {
    // Arrange
    Integer startTime = Integer.valueOf(0);
    RBMBackedTimestampSetInRange rbmBackedTimestampSetInRange = new RBMBackedTimestampSetInRange(startTime,
        Integer.valueOf(1), TimeUnit.DAY);

    // Act and Assert
    assertTrue(rbmBackedTimestampSetInRange.test(new RBMBackedTimestampSet(CommonTimeUtil.TimeBucket.SECOND,
        LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant())));
  }

  /**
   * Method under test:
   * {@link RBMBackedTimestampSetInRange#test(RBMBackedTimestampSet)}
   */
  @Test
  void testTest14() {
    // Arrange
    RBMBackedTimestampSetInRange rbmBackedTimestampSetInRange = new RBMBackedTimestampSetInRange(Integer.valueOf(1),
        null, TimeUnit.DAY);

    // Act and Assert
    assertFalse(rbmBackedTimestampSetInRange.test(new RBMBackedTimestampSet(CommonTimeUtil.TimeBucket.SECOND,
        LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant())));
  }

  /**
   * Method under test:
   * {@link RBMBackedTimestampSetInRange#test(RBMBackedTimestampSet)}
   */
  @Test
  void testTest15() {
    // Arrange
    Integer startTime = Integer.valueOf(1);
    RBMBackedTimestampSetInRange rbmBackedTimestampSetInRange = new RBMBackedTimestampSetInRange(startTime,
        Integer.valueOf(1), TimeUnit.HOUR);

    // Act and Assert
    assertFalse(rbmBackedTimestampSetInRange.test(new RBMBackedTimestampSet(CommonTimeUtil.TimeBucket.SECOND,
        LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant())));
  }

  /**
   * Method under test:
   * {@link RBMBackedTimestampSetInRange#test(RBMBackedTimestampSet)}
   */
  @Test
  void testTest16() {
    // Arrange
    Integer startTime = Integer.valueOf(0);
    RBMBackedTimestampSetInRange rbmBackedTimestampSetInRange = new RBMBackedTimestampSetInRange(startTime,
        Integer.valueOf(0));

    // Act and Assert
    assertTrue(rbmBackedTimestampSetInRange.test(new RBMBackedTimestampSet(CommonTimeUtil.TimeBucket.SECOND,
        LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant())));
  }

  /**
   * Method under test:
   * {@link RBMBackedTimestampSetInRange#test(RBMBackedTimestampSet)}
   */
  @Test
  void testTest17() {
    // Arrange
    Integer startTime = Integer.valueOf(1);
    RBMBackedTimestampSetInRange rbmBackedTimestampSetInRange = new RBMBackedTimestampSetInRange(startTime,
        Integer.valueOf(1));

    RBMBackedTimestampSet rbmBackedTimestampSet = new RBMBackedTimestampSet(CommonTimeUtil.TimeBucket.SECOND,
        LocalDate.now().atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
    rbmBackedTimestampSet.add(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Act and Assert
    assertTrue(rbmBackedTimestampSetInRange.test(rbmBackedTimestampSet));
  }

  /**
   * Method under test:
   * {@link RBMBackedTimestampSetInRange#setIncludeAllTimestamps()}
   */
  @Test
  void testSetIncludeAllTimestamps() {
    // Arrange
    RBMBackedTimestampSetInRange rbmBackedTimestampSetInRange = new RBMBackedTimestampSetInRange();

    // Act
    rbmBackedTimestampSetInRange.setIncludeAllTimestamps();

    // Assert
    assertTrue(rbmBackedTimestampSetInRange.isIncludeAllTimestamps());
  }

  /**
   * Method under test:
   * {@link RBMBackedTimestampSetInRange#includeAllTimestamps()}
   */
  @Test
  void testIncludeAllTimestamps() {
    // Arrange
    RBMBackedTimestampSetInRange rbmBackedTimestampSetInRange = new RBMBackedTimestampSetInRange();

    // Act
    RBMBackedTimestampSetInRange actualIncludeAllTimestampsResult = rbmBackedTimestampSetInRange.includeAllTimestamps();

    // Assert
    assertTrue(rbmBackedTimestampSetInRange.isIncludeAllTimestamps());
    assertSame(rbmBackedTimestampSetInRange, actualIncludeAllTimestampsResult);
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link RBMBackedTimestampSetInRange#endTime(Number)}
   *   <li>{@link RBMBackedTimestampSetInRange#includeAllTimestamps(Boolean)}
   *   <li>{@link RBMBackedTimestampSetInRange#setEndTime(Number)}
   *   <li>{@link RBMBackedTimestampSetInRange#setIncludeAllTimestamps(Boolean)}
   *   <li>{@link RBMBackedTimestampSetInRange#setStartTime(Number)}
   *   <li>{@link RBMBackedTimestampSetInRange#setTimeUnit(TimeUnit)}
   *   <li>{@link RBMBackedTimestampSetInRange#startTime(Number)}
   *   <li>{@link RBMBackedTimestampSetInRange#timeUnit(TimeUnit)}
   *   <li>{@link RBMBackedTimestampSetInRange#getEndTime()}
   *   <li>{@link RBMBackedTimestampSetInRange#getStartTime()}
   *   <li>{@link RBMBackedTimestampSetInRange#getTimeUnit()}
   *   <li>{@link RBMBackedTimestampSetInRange#isIncludeAllTimestamps()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange
    RBMBackedTimestampSetInRange rbmBackedTimestampSetInRange = new RBMBackedTimestampSetInRange();

    // Act
    RBMBackedTimestampSetInRange actualEndTimeResult = rbmBackedTimestampSetInRange.endTime(Integer.valueOf(1));
    RBMBackedTimestampSetInRange actualIncludeAllTimestampsResult = rbmBackedTimestampSetInRange
        .includeAllTimestamps(true);
    rbmBackedTimestampSetInRange.setEndTime(Integer.valueOf(1));
    rbmBackedTimestampSetInRange.setIncludeAllTimestamps(true);
    rbmBackedTimestampSetInRange.setStartTime(Integer.valueOf(1));
    rbmBackedTimestampSetInRange.setTimeUnit(TimeUnit.DAY);
    Integer startTime = Integer.valueOf(1);
    RBMBackedTimestampSetInRange actualStartTimeResult = rbmBackedTimestampSetInRange.startTime(startTime);
    RBMBackedTimestampSetInRange actualTimeUnitResult = rbmBackedTimestampSetInRange.timeUnit(TimeUnit.DAY);
    Number actualEndTime = rbmBackedTimestampSetInRange.getEndTime();
    Number actualStartTime = rbmBackedTimestampSetInRange.getStartTime();
    TimeUnit actualTimeUnit = rbmBackedTimestampSetInRange.getTimeUnit();

    // Assert that nothing has changed
    assertEquals(TimeUnit.DAY, actualTimeUnit);
    assertTrue(rbmBackedTimestampSetInRange.isIncludeAllTimestamps());
    assertSame(rbmBackedTimestampSetInRange, actualEndTimeResult);
    assertSame(rbmBackedTimestampSetInRange, actualIncludeAllTimestampsResult);
    assertSame(rbmBackedTimestampSetInRange, actualStartTimeResult);
    assertSame(rbmBackedTimestampSetInRange, actualTimeUnitResult);
    assertSame(startTime, actualEndTime);
    assertSame(startTime, actualStartTime);
  }

  /**
   * Method under test:
   * {@link RBMBackedTimestampSetInRange#RBMBackedTimestampSetInRange()}
   */
  @Test
  void testNewRBMBackedTimestampSetInRange() {
    // Arrange and Act
    RBMBackedTimestampSetInRange actualRbmBackedTimestampSetInRange = new RBMBackedTimestampSetInRange();

    // Assert
    assertNull(actualRbmBackedTimestampSetInRange.getEndTime());
    assertNull(actualRbmBackedTimestampSetInRange.getStartTime());
    assertEquals(TimeUnit.MILLISECOND, actualRbmBackedTimestampSetInRange.getTimeUnit());
    assertFalse(actualRbmBackedTimestampSetInRange.isIncludeAllTimestamps());
  }

  /**
   * Method under test:
   * {@link RBMBackedTimestampSetInRange#RBMBackedTimestampSetInRange(Number, Number)}
   */
  @Test
  void testNewRBMBackedTimestampSetInRange2() {
    // Arrange
    Integer startTime = Integer.valueOf(1);
    Integer endTime = Integer.valueOf(1);

    // Act
    RBMBackedTimestampSetInRange actualRbmBackedTimestampSetInRange = new RBMBackedTimestampSetInRange(startTime,
        endTime);

    // Assert
    assertEquals(TimeUnit.MILLISECOND, actualRbmBackedTimestampSetInRange.getTimeUnit());
    assertFalse(actualRbmBackedTimestampSetInRange.isIncludeAllTimestamps());
    assertSame(endTime, actualRbmBackedTimestampSetInRange.getEndTime());
    assertSame(endTime, actualRbmBackedTimestampSetInRange.getStartTime());
  }

  /**
   * Method under test:
   * {@link RBMBackedTimestampSetInRange#RBMBackedTimestampSetInRange(Number, Number, TimeUnit)}
   */
  @Test
  void testNewRBMBackedTimestampSetInRange3() {
    // Arrange
    Integer startTime = Integer.valueOf(1);
    Integer endTime = Integer.valueOf(1);

    // Act
    RBMBackedTimestampSetInRange actualRbmBackedTimestampSetInRange = new RBMBackedTimestampSetInRange(startTime,
        endTime, TimeUnit.DAY);

    // Assert
    assertEquals(TimeUnit.DAY, actualRbmBackedTimestampSetInRange.getTimeUnit());
    assertFalse(actualRbmBackedTimestampSetInRange.isIncludeAllTimestamps());
    assertSame(endTime, actualRbmBackedTimestampSetInRange.getEndTime());
    assertSame(endTime, actualRbmBackedTimestampSetInRange.getStartTime());
  }

  /**
   * Method under test:
   * {@link RBMBackedTimestampSetInRange#RBMBackedTimestampSetInRange(Number, Number, TimeUnit, Boolean)}
   */
  @Test
  void testNewRBMBackedTimestampSetInRange4() {
    // Arrange
    Integer startTime = Integer.valueOf(1);
    Integer endTime = Integer.valueOf(1);

    // Act
    RBMBackedTimestampSetInRange actualRbmBackedTimestampSetInRange = new RBMBackedTimestampSetInRange(startTime,
        endTime, TimeUnit.DAY, true);

    // Assert
    assertEquals(TimeUnit.DAY, actualRbmBackedTimestampSetInRange.getTimeUnit());
    assertTrue(actualRbmBackedTimestampSetInRange.isIncludeAllTimestamps());
    assertSame(endTime, actualRbmBackedTimestampSetInRange.getEndTime());
    assertSame(endTime, actualRbmBackedTimestampSetInRange.getStartTime());
  }
}
