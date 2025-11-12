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
import java.util.ArrayList;
import org.junit.jupiter.api.Test;

class IterableToHyperLogLogPlusDiffblueTest {
  /**
   * Method under test: {@link IterableToHyperLogLogPlus#apply(Iterable)}
   */
  @Test
  void testApply() throws IOException {
    // Arrange
    IterableToHyperLogLogPlus iterableToHyperLogLogPlus = new IterableToHyperLogLogPlus();

    // Act
    HyperLogLogPlus actualApplyResult = iterableToHyperLogLogPlus.apply(new ArrayList<>());

    // Assert
    assertEquals(24, actualApplyResult.sizeof());
    assertArrayEquals(new byte[]{-1, -1, -1, -2, 5, 5, 1, 0}, actualApplyResult.getBytes());
  }

  /**
   * Method under test: {@link IterableToHyperLogLogPlus#apply(Iterable)}
   */
  @Test
  void testApply2() throws IOException {
    // Arrange
    IterableToHyperLogLogPlus iterableToHyperLogLogPlus = new IterableToHyperLogLogPlus(5, 0);

    // Act
    HyperLogLogPlus actualApplyResult = iterableToHyperLogLogPlus.apply(new ArrayList<>());

    // Assert
    assertEquals(24, actualApplyResult.sizeof());
    assertArrayEquals(
        new byte[]{-1, -1, -1, -2, 5, 0, 0, 24, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        actualApplyResult.getBytes());
  }

  /**
   * Method under test: {@link IterableToHyperLogLogPlus#apply(Iterable)}
   */
  @Test
  void testApply3() throws IOException {
    // Arrange
    IterableToHyperLogLogPlus iterableToHyperLogLogPlus = new IterableToHyperLogLogPlus();

    ArrayList<Object> o = new ArrayList<>();
    o.add("42");

    // Act
    HyperLogLogPlus actualApplyResult = iterableToHyperLogLogPlus.apply(o);

    // Assert
    assertEquals(24, actualApplyResult.sizeof());
    assertArrayEquals(new byte[]{-1, -1, -1, -2, 5, 5, 1, 1, -5, 23}, actualApplyResult.getBytes());
  }

  /**
   * Method under test: {@link IterableToHyperLogLogPlus#apply(Iterable)}
   */
  @Test
  void testApply4() throws IOException {
    // Arrange
    IterableToHyperLogLogPlus iterableToHyperLogLogPlus = new IterableToHyperLogLogPlus();

    ArrayList<Object> o = new ArrayList<>();
    o.add("42");
    o.add("42");

    // Act
    HyperLogLogPlus actualApplyResult = iterableToHyperLogLogPlus.apply(o);

    // Assert
    assertEquals(24, actualApplyResult.sizeof());
    assertArrayEquals(new byte[]{-1, -1, -1, -2, 5, 5, 1, 1, -5, 23}, actualApplyResult.getBytes());
  }

  /**
   * Method under test: {@link IterableToHyperLogLogPlus#apply(Iterable)}
   */
  @Test
  void testApply5() throws IOException {
    // Arrange
    IterableToHyperLogLogPlus iterableToHyperLogLogPlus = new IterableToHyperLogLogPlus();

    ArrayList<Object> o = new ArrayList<>();
    o.add(2);

    // Act
    HyperLogLogPlus actualApplyResult = iterableToHyperLogLogPlus.apply(o);

    // Assert
    assertEquals(24, actualApplyResult.sizeof());
    assertArrayEquals(new byte[]{-1, -1, -1, -2, 5, 5, 1, 1, -5, 11}, actualApplyResult.getBytes());
  }

  /**
   * Method under test: {@link IterableToHyperLogLogPlus#apply(Iterable)}
   */
  @Test
  void testApply6() throws IOException {
    // Arrange
    IterableToHyperLogLogPlus iterableToHyperLogLogPlus = new IterableToHyperLogLogPlus();

    ArrayList<Object> o = new ArrayList<>();
    o.add("foo");

    // Act
    HyperLogLogPlus actualApplyResult = iterableToHyperLogLogPlus.apply(o);

    // Assert
    assertEquals(24, actualApplyResult.sizeof());
    assertArrayEquals(new byte[]{-1, -1, -1, -2, 5, 5, 1, 1, -3, 18}, actualApplyResult.getBytes());
  }

  /**
   * Method under test: {@link IterableToHyperLogLogPlus#apply(Iterable)}
   */
  @Test
  void testApply7() throws IOException {
    // Arrange
    IterableToHyperLogLogPlus iterableToHyperLogLogPlus = new IterableToHyperLogLogPlus();

    ArrayList<Object> o = new ArrayList<>();
    o.add(Integer.MIN_VALUE);

    // Act
    HyperLogLogPlus actualApplyResult = iterableToHyperLogLogPlus.apply(o);

    // Assert
    assertEquals(24, actualApplyResult.sizeof());
    assertArrayEquals(new byte[]{-1, -1, -1, -2, 5, 5, 1, 1, -3, 28}, actualApplyResult.getBytes());
  }

  /**
   * Method under test: {@link IterableToHyperLogLogPlus#apply(Iterable)}
   */
  @Test
  void testApply8() throws IOException {
    // Arrange
    IterableToHyperLogLogPlus iterableToHyperLogLogPlus = new IterableToHyperLogLogPlus();

    ArrayList<Object> o = new ArrayList<>();
    o.add("");

    // Act
    HyperLogLogPlus actualApplyResult = iterableToHyperLogLogPlus.apply(o);

    // Assert
    assertEquals(24, actualApplyResult.sizeof());
    assertArrayEquals(new byte[]{-1, -1, -1, -2, 5, 5, 1, 1, -5, 19}, actualApplyResult.getBytes());
  }

  /**
   * Method under test: {@link IterableToHyperLogLogPlus#apply(Iterable)}
   */
  @Test
  void testApply9() throws IOException {
    // Arrange
    IterableToHyperLogLogPlus iterableToHyperLogLogPlus = new IterableToHyperLogLogPlus(5, 0);

    ArrayList<Object> o = new ArrayList<>();
    o.add("42");

    // Act
    HyperLogLogPlus actualApplyResult = iterableToHyperLogLogPlus.apply(o);

    // Assert
    assertEquals(24, actualApplyResult.sizeof());
    assertArrayEquals(
        new byte[]{-1, -1, -1, -2, 5, 0, 0, 24, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        actualApplyResult.getBytes());
  }

  /**
   * Method under test: {@link IterableToHyperLogLogPlus#apply(Iterable)}
   */
  @Test
  void testApply10() throws IOException {
    // Arrange
    IterableToHyperLogLogPlus iterableToHyperLogLogPlus = new IterableToHyperLogLogPlus(5, 0);

    ArrayList<Object> o = new ArrayList<>();
    o.add("42");
    o.add("42");

    // Act
    HyperLogLogPlus actualApplyResult = iterableToHyperLogLogPlus.apply(o);

    // Assert
    assertEquals(24, actualApplyResult.sizeof());
    assertArrayEquals(
        new byte[]{-1, -1, -1, -2, 5, 0, 0, 24, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        actualApplyResult.getBytes());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link IterableToHyperLogLogPlus#IterableToHyperLogLogPlus()}
   *   <li>{@link IterableToHyperLogLogPlus#setP(int)}
   *   <li>{@link IterableToHyperLogLogPlus#setSp(int)}
   *   <li>{@link IterableToHyperLogLogPlus#getP()}
   *   <li>{@link IterableToHyperLogLogPlus#getSp()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    IterableToHyperLogLogPlus actualIterableToHyperLogLogPlus = new IterableToHyperLogLogPlus();
    actualIterableToHyperLogLogPlus.setP(3);
    actualIterableToHyperLogLogPlus.setSp(3);
    int actualP = actualIterableToHyperLogLogPlus.getP();

    // Assert that nothing has changed
    assertEquals(3, actualP);
    assertEquals(3, actualIterableToHyperLogLogPlus.getSp());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link IterableToHyperLogLogPlus#IterableToHyperLogLogPlus(int, int)}
   *   <li>{@link IterableToHyperLogLogPlus#setP(int)}
   *   <li>{@link IterableToHyperLogLogPlus#setSp(int)}
   *   <li>{@link IterableToHyperLogLogPlus#getP()}
   *   <li>{@link IterableToHyperLogLogPlus#getSp()}
   * </ul>
   */
  @Test
  void testGettersAndSetters2() {
    // Arrange and Act
    IterableToHyperLogLogPlus actualIterableToHyperLogLogPlus = new IterableToHyperLogLogPlus(3, 3);
    actualIterableToHyperLogLogPlus.setP(3);
    actualIterableToHyperLogLogPlus.setSp(3);
    int actualP = actualIterableToHyperLogLogPlus.getP();

    // Assert that nothing has changed
    assertEquals(3, actualP);
    assertEquals(3, actualIterableToHyperLogLogPlus.getSp());
  }
}
