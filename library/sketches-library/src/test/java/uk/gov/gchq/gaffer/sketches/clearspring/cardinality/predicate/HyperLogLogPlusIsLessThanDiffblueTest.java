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

package uk.gov.gchq.gaffer.sketches.clearspring.cardinality.predicate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.clearspring.analytics.stream.cardinality.HyperLogLogPlus;
import org.junit.jupiter.api.Test;

class HyperLogLogPlusIsLessThanDiffblueTest {
  /**
   * Method under test: {@link HyperLogLogPlusIsLessThan#test(HyperLogLogPlus)}
   */
  @Test
  void testTest() {
    // Arrange
    HyperLogLogPlusIsLessThan hyperLogLogPlusIsLessThan = new HyperLogLogPlusIsLessThan(42L);
    hyperLogLogPlusIsLessThan.setOrEqualTo(false);

    // Act and Assert
    assertFalse(hyperLogLogPlusIsLessThan.test(null));
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link HyperLogLogPlusIsLessThan#equals(Object)}
   *   <li>{@link HyperLogLogPlusIsLessThan#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    HyperLogLogPlusIsLessThan hyperLogLogPlusIsLessThan = new HyperLogLogPlusIsLessThan(42L);
    HyperLogLogPlusIsLessThan hyperLogLogPlusIsLessThan2 = new HyperLogLogPlusIsLessThan(42L);

    // Act and Assert
    assertEquals(hyperLogLogPlusIsLessThan, hyperLogLogPlusIsLessThan2);
    int expectedHashCodeResult = hyperLogLogPlusIsLessThan.hashCode();
    assertEquals(expectedHashCodeResult, hyperLogLogPlusIsLessThan2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link HyperLogLogPlusIsLessThan#equals(Object)}
   *   <li>{@link HyperLogLogPlusIsLessThan#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    HyperLogLogPlusIsLessThan hyperLogLogPlusIsLessThan = new HyperLogLogPlusIsLessThan(42L);

    // Act and Assert
    assertEquals(hyperLogLogPlusIsLessThan, hyperLogLogPlusIsLessThan);
    int expectedHashCodeResult = hyperLogLogPlusIsLessThan.hashCode();
    assertEquals(expectedHashCodeResult, hyperLogLogPlusIsLessThan.hashCode());
  }

  /**
   * Method under test: {@link HyperLogLogPlusIsLessThan#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    HyperLogLogPlusIsLessThan hyperLogLogPlusIsLessThan = new HyperLogLogPlusIsLessThan(1L);

    // Act and Assert
    assertNotEquals(hyperLogLogPlusIsLessThan, new HyperLogLogPlusIsLessThan(42L));
  }

  /**
   * Method under test: {@link HyperLogLogPlusIsLessThan#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new HyperLogLogPlusIsLessThan(42L), null);
  }

  /**
   * Method under test: {@link HyperLogLogPlusIsLessThan#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new HyperLogLogPlusIsLessThan(42L), "Different type to HyperLogLogPlusIsLessThan");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link HyperLogLogPlusIsLessThan#HyperLogLogPlusIsLessThan()}
   *   <li>{@link HyperLogLogPlusIsLessThan#setControlValue(long)}
   *   <li>{@link HyperLogLogPlusIsLessThan#setOrEqualTo(boolean)}
   *   <li>{@link HyperLogLogPlusIsLessThan#getControlValue()}
   *   <li>{@link HyperLogLogPlusIsLessThan#getOrEqualTo()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    HyperLogLogPlusIsLessThan actualHyperLogLogPlusIsLessThan = new HyperLogLogPlusIsLessThan();
    actualHyperLogLogPlusIsLessThan.setControlValue(42L);
    actualHyperLogLogPlusIsLessThan.setOrEqualTo(true);
    long actualControlValue = actualHyperLogLogPlusIsLessThan.getControlValue();

    // Assert that nothing has changed
    assertEquals(42L, actualControlValue);
    assertTrue(actualHyperLogLogPlusIsLessThan.getOrEqualTo());
  }

  /**
   * Method under test:
   * {@link HyperLogLogPlusIsLessThan#HyperLogLogPlusIsLessThan(long)}
   */
  @Test
  void testNewHyperLogLogPlusIsLessThan() {
    // Arrange and Act
    HyperLogLogPlusIsLessThan actualHyperLogLogPlusIsLessThan = new HyperLogLogPlusIsLessThan(42L);

    // Assert
    assertEquals(42L, actualHyperLogLogPlusIsLessThan.getControlValue());
    assertFalse(actualHyperLogLogPlusIsLessThan.getOrEqualTo());
  }

  /**
   * Method under test:
   * {@link HyperLogLogPlusIsLessThan#HyperLogLogPlusIsLessThan(long, boolean)}
   */
  @Test
  void testNewHyperLogLogPlusIsLessThan2() {
    // Arrange and Act
    HyperLogLogPlusIsLessThan actualHyperLogLogPlusIsLessThan = new HyperLogLogPlusIsLessThan(42L, true);

    // Assert
    assertEquals(42L, actualHyperLogLogPlusIsLessThan.getControlValue());
    assertTrue(actualHyperLogLogPlusIsLessThan.getOrEqualTo());
  }
}
