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

package uk.gov.gchq.gaffer.sketches.clearspring.cardinality.function;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import com.clearspring.analytics.stream.cardinality.HyperLogLogPlus;
import java.io.IOException;
import org.junit.jupiter.api.Test;

class ToHyperLogLogPlusDiffblueTest {
  /**
   * Method under test: {@link ToHyperLogLogPlus#apply(Object)}
   */
  @Test
  void testApply() throws IOException {
    // Arrange and Act
    HyperLogLogPlus actualApplyResult = (new ToHyperLogLogPlus()).apply("42");

    // Assert
    assertEquals(24, actualApplyResult.sizeof());
    assertArrayEquals(new byte[]{-1, -1, -1, -2, 5, 5, 1, 1, -5, 23}, actualApplyResult.getBytes());
  }

  /**
   * Method under test: {@link ToHyperLogLogPlus#apply(Object)}
   */
  @Test
  void testApply2() throws IOException {
    // Arrange and Act
    HyperLogLogPlus actualApplyResult = (new ToHyperLogLogPlus(5, 0)).apply("42");

    // Assert
    assertEquals(24, actualApplyResult.sizeof());
    assertArrayEquals(
        new byte[]{-1, -1, -1, -2, 5, 0, 0, 24, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        actualApplyResult.getBytes());
  }

  /**
   * Method under test: {@link ToHyperLogLogPlus#apply(Object)}
   */
  @Test
  void testApply3() throws IOException {
    // Arrange and Act
    HyperLogLogPlus actualApplyResult = (new ToHyperLogLogPlus()).apply(3);

    // Assert
    assertEquals(24, actualApplyResult.sizeof());
    assertArrayEquals(new byte[]{-1, -1, -1, -2, 5, 5, 1, 1, -9, '\f'}, actualApplyResult.getBytes());
  }

  /**
   * Method under test: {@link ToHyperLogLogPlus#apply(Object)}
   */
  @Test
  void testApply4() throws IOException {
    // Arrange and Act
    HyperLogLogPlus actualApplyResult = (new ToHyperLogLogPlus()).apply("foo");

    // Assert
    assertEquals(24, actualApplyResult.sizeof());
    assertArrayEquals(new byte[]{-1, -1, -1, -2, 5, 5, 1, 1, -3, 18}, actualApplyResult.getBytes());
  }

  /**
   * Method under test: {@link ToHyperLogLogPlus#apply(Object)}
   */
  @Test
  void testApply5() throws IOException {
    // Arrange and Act
    HyperLogLogPlus actualApplyResult = (new ToHyperLogLogPlus()).apply(Integer.MIN_VALUE);

    // Assert
    assertEquals(24, actualApplyResult.sizeof());
    assertArrayEquals(new byte[]{-1, -1, -1, -2, 5, 5, 1, 1, -3, 28}, actualApplyResult.getBytes());
  }

  /**
   * Method under test: {@link ToHyperLogLogPlus#apply(Object)}
   */
  @Test
  void testApply6() throws IOException {
    // Arrange and Act
    HyperLogLogPlus actualApplyResult = (new ToHyperLogLogPlus()).apply("");

    // Assert
    assertEquals(24, actualApplyResult.sizeof());
    assertArrayEquals(new byte[]{-1, -1, -1, -2, 5, 5, 1, 1, -5, 19}, actualApplyResult.getBytes());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ToHyperLogLogPlus#ToHyperLogLogPlus()}
   *   <li>{@link ToHyperLogLogPlus#setP(int)}
   *   <li>{@link ToHyperLogLogPlus#setSp(int)}
   *   <li>{@link ToHyperLogLogPlus#getP()}
   *   <li>{@link ToHyperLogLogPlus#getSp()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    ToHyperLogLogPlus actualToHyperLogLogPlus = new ToHyperLogLogPlus();
    actualToHyperLogLogPlus.setP(3);
    actualToHyperLogLogPlus.setSp(3);
    int actualP = actualToHyperLogLogPlus.getP();

    // Assert that nothing has changed
    assertEquals(3, actualP);
    assertEquals(3, actualToHyperLogLogPlus.getSp());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ToHyperLogLogPlus#ToHyperLogLogPlus(int, int)}
   *   <li>{@link ToHyperLogLogPlus#setP(int)}
   *   <li>{@link ToHyperLogLogPlus#setSp(int)}
   *   <li>{@link ToHyperLogLogPlus#getP()}
   *   <li>{@link ToHyperLogLogPlus#getSp()}
   * </ul>
   */
  @Test
  void testGettersAndSetters2() {
    // Arrange and Act
    ToHyperLogLogPlus actualToHyperLogLogPlus = new ToHyperLogLogPlus(3, 3);
    actualToHyperLogLogPlus.setP(3);
    actualToHyperLogLogPlus.setSp(3);
    int actualP = actualToHyperLogLogPlus.getP();

    // Assert that nothing has changed
    assertEquals(3, actualP);
    assertEquals(3, actualToHyperLogLogPlus.getSp());
  }
}
