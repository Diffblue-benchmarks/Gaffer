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

package uk.gov.gchq.gaffer.sketches.datasketches.cardinality.predicate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.apache.datasketches.hll.HllSketch;
import org.junit.jupiter.api.Test;

class HllSketchIsLessThanDiffblueTest {
  /**
   * Method under test: {@link HllSketchIsLessThan#test(HllSketch)}
   */
  @Test
  void testTest() {
    // Arrange
    HllSketchIsLessThan hllSketchIsLessThan = new HllSketchIsLessThan(42L);

    // Act and Assert
    assertTrue(hllSketchIsLessThan.test(new HllSketch()));
  }

  /**
   * Method under test: {@link HllSketchIsLessThan#test(HllSketch)}
   */
  @Test
  void testTest2() {
    // Arrange
    HllSketchIsLessThan hllSketchIsLessThan = new HllSketchIsLessThan(42L);
    hllSketchIsLessThan.setOrEqualTo(false);

    // Act and Assert
    assertFalse(hllSketchIsLessThan.test(null));
  }

  /**
   * Method under test: {@link HllSketchIsLessThan#test(HllSketch)}
   */
  @Test
  void testTest3() {
    // Arrange
    HllSketchIsLessThan hllSketchIsLessThan = new HllSketchIsLessThan(-1L);

    // Act and Assert
    assertFalse(hllSketchIsLessThan.test(new HllSketch()));
  }

  /**
   * Method under test: {@link HllSketchIsLessThan#test(HllSketch)}
   */
  @Test
  void testTest4() {
    // Arrange
    HllSketchIsLessThan hllSketchIsLessThan = new HllSketchIsLessThan(42L, true);

    // Act and Assert
    assertTrue(hllSketchIsLessThan.test(new HllSketch()));
  }

  /**
   * Method under test: {@link HllSketchIsLessThan#test(HllSketch)}
   */
  @Test
  void testTest5() {
    // Arrange
    HllSketchIsLessThan hllSketchIsLessThan = new HllSketchIsLessThan(-1L, true);

    // Act and Assert
    assertFalse(hllSketchIsLessThan.test(new HllSketch()));
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link HllSketchIsLessThan#equals(Object)}
   *   <li>{@link HllSketchIsLessThan#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    HllSketchIsLessThan hllSketchIsLessThan = new HllSketchIsLessThan(42L);
    HllSketchIsLessThan hllSketchIsLessThan2 = new HllSketchIsLessThan(42L);

    // Act and Assert
    assertEquals(hllSketchIsLessThan, hllSketchIsLessThan2);
    int expectedHashCodeResult = hllSketchIsLessThan.hashCode();
    assertEquals(expectedHashCodeResult, hllSketchIsLessThan2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link HllSketchIsLessThan#equals(Object)}
   *   <li>{@link HllSketchIsLessThan#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    HllSketchIsLessThan hllSketchIsLessThan = new HllSketchIsLessThan(42L);

    // Act and Assert
    assertEquals(hllSketchIsLessThan, hllSketchIsLessThan);
    int expectedHashCodeResult = hllSketchIsLessThan.hashCode();
    assertEquals(expectedHashCodeResult, hllSketchIsLessThan.hashCode());
  }

  /**
   * Method under test: {@link HllSketchIsLessThan#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    HllSketchIsLessThan hllSketchIsLessThan = new HllSketchIsLessThan(1L);

    // Act and Assert
    assertNotEquals(hllSketchIsLessThan, new HllSketchIsLessThan(42L));
  }

  /**
   * Method under test: {@link HllSketchIsLessThan#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new HllSketchIsLessThan(42L), null);
  }

  /**
   * Method under test: {@link HllSketchIsLessThan#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new HllSketchIsLessThan(42L), "Different type to HllSketchIsLessThan");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link HllSketchIsLessThan#HllSketchIsLessThan()}
   *   <li>{@link HllSketchIsLessThan#setControlValue(long)}
   *   <li>{@link HllSketchIsLessThan#setOrEqualTo(boolean)}
   *   <li>{@link HllSketchIsLessThan#getControlValue()}
   *   <li>{@link HllSketchIsLessThan#getOrEqualTo()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    HllSketchIsLessThan actualHllSketchIsLessThan = new HllSketchIsLessThan();
    actualHllSketchIsLessThan.setControlValue(42L);
    actualHllSketchIsLessThan.setOrEqualTo(true);
    long actualControlValue = actualHllSketchIsLessThan.getControlValue();

    // Assert that nothing has changed
    assertEquals(42L, actualControlValue);
    assertTrue(actualHllSketchIsLessThan.getOrEqualTo());
  }

  /**
   * Method under test: {@link HllSketchIsLessThan#HllSketchIsLessThan(long)}
   */
  @Test
  void testNewHllSketchIsLessThan() {
    // Arrange and Act
    HllSketchIsLessThan actualHllSketchIsLessThan = new HllSketchIsLessThan(42L);

    // Assert
    assertEquals(42L, actualHllSketchIsLessThan.getControlValue());
    assertFalse(actualHllSketchIsLessThan.getOrEqualTo());
  }

  /**
   * Method under test:
   * {@link HllSketchIsLessThan#HllSketchIsLessThan(long, boolean)}
   */
  @Test
  void testNewHllSketchIsLessThan2() {
    // Arrange and Act
    HllSketchIsLessThan actualHllSketchIsLessThan = new HllSketchIsLessThan(42L, true);

    // Assert
    assertEquals(42L, actualHllSketchIsLessThan.getControlValue());
    assertTrue(actualHllSketchIsLessThan.getOrEqualTo());
  }
}
