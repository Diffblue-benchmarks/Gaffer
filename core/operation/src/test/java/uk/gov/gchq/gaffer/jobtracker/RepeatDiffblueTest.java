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

package uk.gov.gchq.gaffer.jobtracker;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import java.util.concurrent.TimeUnit;
import org.junit.jupiter.api.Test;

class RepeatDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link Repeat#equals(Object)}
   *   <li>{@link Repeat#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Repeat repeat = new Repeat();
    Repeat repeat2 = new Repeat();

    // Act and Assert
    assertEquals(repeat, repeat2);
    int expectedHashCodeResult = repeat.hashCode();
    assertEquals(expectedHashCodeResult, repeat2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link Repeat#equals(Object)}
   *   <li>{@link Repeat#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Repeat repeat = new Repeat();

    // Act and Assert
    assertEquals(repeat, repeat);
    int expectedHashCodeResult = repeat.hashCode();
    assertEquals(expectedHashCodeResult, repeat.hashCode());
  }

  /**
   * Method under test: {@link Repeat#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Repeat repeat = new Repeat(1L, 1L, TimeUnit.NANOSECONDS);

    // Act and Assert
    assertNotEquals(repeat, new Repeat());
  }

  /**
   * Method under test: {@link Repeat#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new Repeat(), null);
  }

  /**
   * Method under test: {@link Repeat#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new Repeat(), "Different type to Repeat");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link Repeat#setInitialDelay(long)}
   *   <li>{@link Repeat#setRepeatPeriod(long)}
   *   <li>{@link Repeat#setTimeUnit(TimeUnit)}
   *   <li>{@link Repeat#getInitialDelay()}
   *   <li>{@link Repeat#getRepeatPeriod()}
   *   <li>{@link Repeat#getTimeUnit()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange
    Repeat repeat = new Repeat();

    // Act
    repeat.setInitialDelay(1L);
    repeat.setRepeatPeriod(1L);
    repeat.setTimeUnit(TimeUnit.NANOSECONDS);
    long actualInitialDelay = repeat.getInitialDelay();
    long actualRepeatPeriod = repeat.getRepeatPeriod();

    // Assert that nothing has changed
    assertEquals(1L, actualInitialDelay);
    assertEquals(1L, actualRepeatPeriod);
    assertEquals(TimeUnit.NANOSECONDS, repeat.getTimeUnit());
  }

  /**
   * Method under test: {@link Repeat#Repeat()}
   */
  @Test
  void testNewRepeat() {
    // Arrange and Act
    Repeat actualRepeat = new Repeat();

    // Assert
    assertEquals(0L, actualRepeat.getInitialDelay());
    assertEquals(0L, actualRepeat.getRepeatPeriod());
    assertEquals(TimeUnit.SECONDS, actualRepeat.getTimeUnit());
  }

  /**
   * Method under test: {@link Repeat#Repeat(long, long, TimeUnit)}
   */
  @Test
  void testNewRepeat2() {
    // Arrange and Act
    Repeat actualRepeat = new Repeat(1L, 1L, TimeUnit.NANOSECONDS);

    // Assert
    assertEquals(1L, actualRepeat.getInitialDelay());
    assertEquals(1L, actualRepeat.getRepeatPeriod());
    assertEquals(TimeUnit.NANOSECONDS, actualRepeat.getTimeUnit());
  }
}
