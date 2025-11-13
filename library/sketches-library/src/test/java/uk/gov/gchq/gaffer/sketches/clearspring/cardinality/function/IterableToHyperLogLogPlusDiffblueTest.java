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
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import java.util.ArrayList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class IterableToHyperLogLogPlusDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link IterableToHyperLogLogPlus#IterableToHyperLogLogPlus()}
   *   <li>{@link IterableToHyperLogLogPlus#setP(int)}
   *   <li>{@link IterableToHyperLogLogPlus#setSp(int)}
   *   <li>{@link IterableToHyperLogLogPlus#getP()}
   *   <li>{@link IterableToHyperLogLogPlus#getSp()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void IterableToHyperLogLogPlus.<init>()",
    "void IterableToHyperLogLogPlus.<init>(int, int)",
    "int IterableToHyperLogLogPlus.getP()",
    "int IterableToHyperLogLogPlus.getSp()",
    "void IterableToHyperLogLogPlus.setP(int)",
    "void IterableToHyperLogLogPlus.setSp(int)"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    IterableToHyperLogLogPlus actualIterableToHyperLogLogPlus = new IterableToHyperLogLogPlus();
    actualIterableToHyperLogLogPlus.setP(3);
    actualIterableToHyperLogLogPlus.setSp(3);
    int actualP = actualIterableToHyperLogLogPlus.getP();

    // Assert
    assertEquals(3, actualP);
    assertEquals(3, actualIterableToHyperLogLogPlus.getSp());
  }

  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>When three.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link IterableToHyperLogLogPlus#IterableToHyperLogLogPlus(int, int)}
   *   <li>{@link IterableToHyperLogLogPlus#setP(int)}
   *   <li>{@link IterableToHyperLogLogPlus#setSp(int)}
   *   <li>{@link IterableToHyperLogLogPlus#getP()}
   *   <li>{@link IterableToHyperLogLogPlus#getSp()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; when three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void IterableToHyperLogLogPlus.<init>()",
    "void IterableToHyperLogLogPlus.<init>(int, int)",
    "int IterableToHyperLogLogPlus.getP()",
    "int IterableToHyperLogLogPlus.getSp()",
    "void IterableToHyperLogLogPlus.setP(int)",
    "void IterableToHyperLogLogPlus.setSp(int)"
  })
  void testGettersAndSetters_whenThree() {
    // Arrange and Act
    IterableToHyperLogLogPlus actualIterableToHyperLogLogPlus = new IterableToHyperLogLogPlus(3, 3);
    actualIterableToHyperLogLogPlus.setP(3);
    actualIterableToHyperLogLogPlus.setSp(3);
    int actualP = actualIterableToHyperLogLogPlus.getP();

    // Assert
    assertEquals(3, actualP);
    assertEquals(3, actualIterableToHyperLogLogPlus.getSp());
  }

  /**
   * Test {@link IterableToHyperLogLogPlus#apply(Iterable)} with {@code Iterable}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.
   *   <li>Then return sizeof is twenty-four.
   * </ul>
   *
   * <p>Method under test: {@link IterableToHyperLogLogPlus#apply(Iterable)}
   */
  @Test
  @DisplayName(
      "Test apply(Iterable) with 'Iterable'; given '42'; when ArrayList() add '42'; then return sizeof is twenty-four")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"HyperLogLogPlus IterableToHyperLogLogPlus.apply(Iterable)"})
  void testApplyWithIterable_given42_whenArrayListAdd42_thenReturnSizeofIsTwentyFour()
      throws IOException {
    // Arrange
    IterableToHyperLogLogPlus iterableToHyperLogLogPlus = new IterableToHyperLogLogPlus();

    ArrayList<Object> o = new ArrayList<>();
    o.add("42");

    // Act
    HyperLogLogPlus actualApplyResult = iterableToHyperLogLogPlus.apply(o);

    // Assert
    assertEquals(24, actualApplyResult.sizeof());
    assertArrayEquals(
        new byte[] {-1, -1, -1, -2, 5, 5, 1, 1, -5, 23}, actualApplyResult.getBytes());
  }

  /**
   * Test {@link IterableToHyperLogLogPlus#apply(Iterable)} with {@code Iterable}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.
   *   <li>Then return sizeof is twenty-four.
   * </ul>
   *
   * <p>Method under test: {@link IterableToHyperLogLogPlus#apply(Iterable)}
   */
  @Test
  @DisplayName(
      "Test apply(Iterable) with 'Iterable'; given '42'; when ArrayList() add '42'; then return sizeof is twenty-four")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"HyperLogLogPlus IterableToHyperLogLogPlus.apply(Iterable)"})
  void testApplyWithIterable_given42_whenArrayListAdd42_thenReturnSizeofIsTwentyFour2()
      throws IOException {
    // Arrange
    IterableToHyperLogLogPlus iterableToHyperLogLogPlus = new IterableToHyperLogLogPlus();

    ArrayList<Object> o = new ArrayList<>();
    o.add("42");
    o.add("42");

    // Act
    HyperLogLogPlus actualApplyResult = iterableToHyperLogLogPlus.apply(o);

    // Assert
    assertEquals(24, actualApplyResult.sizeof());
    assertArrayEquals(
        new byte[] {-1, -1, -1, -2, 5, 5, 1, 1, -5, 23}, actualApplyResult.getBytes());
  }

  /**
   * Test {@link IterableToHyperLogLogPlus#apply(Iterable)} with {@code Iterable}.
   *
   * <ul>
   *   <li>Given empty string.
   *   <li>When {@link ArrayList#ArrayList()} add empty string.
   * </ul>
   *
   * <p>Method under test: {@link IterableToHyperLogLogPlus#apply(Iterable)}
   */
  @Test
  @DisplayName(
      "Test apply(Iterable) with 'Iterable'; given empty string; when ArrayList() add empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"HyperLogLogPlus IterableToHyperLogLogPlus.apply(Iterable)"})
  void testApplyWithIterable_givenEmptyString_whenArrayListAddEmptyString() throws IOException {
    // Arrange
    IterableToHyperLogLogPlus iterableToHyperLogLogPlus = new IterableToHyperLogLogPlus();

    ArrayList<Object> o = new ArrayList<>();
    o.add("");

    // Act
    HyperLogLogPlus actualApplyResult = iterableToHyperLogLogPlus.apply(o);

    // Assert
    assertEquals(24, actualApplyResult.sizeof());
    assertArrayEquals(
        new byte[] {-1, -1, -1, -2, 5, 5, 1, 1, -5, 19}, actualApplyResult.getBytes());
  }

  /**
   * Test {@link IterableToHyperLogLogPlus#apply(Iterable)} with {@code Iterable}.
   *
   * <ul>
   *   <li>Given {@code foo}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code foo}.
   *   <li>Then return sizeof is twenty-four.
   * </ul>
   *
   * <p>Method under test: {@link IterableToHyperLogLogPlus#apply(Iterable)}
   */
  @Test
  @DisplayName(
      "Test apply(Iterable) with 'Iterable'; given 'foo'; when ArrayList() add 'foo'; then return sizeof is twenty-four")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"HyperLogLogPlus IterableToHyperLogLogPlus.apply(Iterable)"})
  void testApplyWithIterable_givenFoo_whenArrayListAddFoo_thenReturnSizeofIsTwentyFour()
      throws IOException {
    // Arrange
    IterableToHyperLogLogPlus iterableToHyperLogLogPlus = new IterableToHyperLogLogPlus();

    ArrayList<Object> o = new ArrayList<>();
    o.add("foo");

    // Act
    HyperLogLogPlus actualApplyResult = iterableToHyperLogLogPlus.apply(o);

    // Assert
    assertEquals(24, actualApplyResult.sizeof());
    assertArrayEquals(
        new byte[] {-1, -1, -1, -2, 5, 5, 1, 1, -3, 18}, actualApplyResult.getBytes());
  }

  /**
   * Test {@link IterableToHyperLogLogPlus#apply(Iterable)} with {@code Iterable}.
   *
   * <ul>
   *   <li>Given {@link IterableToHyperLogLogPlus#IterableToHyperLogLogPlus(int, int)} with p is
   *       five and sp is zero.
   * </ul>
   *
   * <p>Method under test: {@link IterableToHyperLogLogPlus#apply(Iterable)}
   */
  @Test
  @DisplayName(
      "Test apply(Iterable) with 'Iterable'; given IterableToHyperLogLogPlus(int, int) with p is five and sp is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"HyperLogLogPlus IterableToHyperLogLogPlus.apply(Iterable)"})
  void testApplyWithIterable_givenIterableToHyperLogLogPlusWithPIsFiveAndSpIsZero()
      throws IOException {
    // Arrange
    IterableToHyperLogLogPlus iterableToHyperLogLogPlus = new IterableToHyperLogLogPlus(5, 0);

    // Act
    HyperLogLogPlus actualApplyResult = iterableToHyperLogLogPlus.apply(new ArrayList<>());

    // Assert
    assertEquals(24, actualApplyResult.sizeof());
    assertArrayEquals(
        new byte[] {
          -1, -1, -1, -2, 5, 0, 0, 24, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
          0, 0, 0, 0
        },
        actualApplyResult.getBytes());
  }

  /**
   * Test {@link IterableToHyperLogLogPlus#apply(Iterable)} with {@code Iterable}.
   *
   * <ul>
   *   <li>Given {@link IterableToHyperLogLogPlus#IterableToHyperLogLogPlus(int, int)} with p is
   *       five and sp is zero.
   * </ul>
   *
   * <p>Method under test: {@link IterableToHyperLogLogPlus#apply(Iterable)}
   */
  @Test
  @DisplayName(
      "Test apply(Iterable) with 'Iterable'; given IterableToHyperLogLogPlus(int, int) with p is five and sp is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"HyperLogLogPlus IterableToHyperLogLogPlus.apply(Iterable)"})
  void testApplyWithIterable_givenIterableToHyperLogLogPlusWithPIsFiveAndSpIsZero2()
      throws IOException {
    // Arrange
    IterableToHyperLogLogPlus iterableToHyperLogLogPlus = new IterableToHyperLogLogPlus(5, 0);

    ArrayList<Object> o = new ArrayList<>();
    o.add("42");

    // Act
    HyperLogLogPlus actualApplyResult = iterableToHyperLogLogPlus.apply(o);

    // Assert
    assertEquals(24, actualApplyResult.sizeof());
    assertArrayEquals(
        new byte[] {
          -1, -1, -1, -2, 5, 0, 0, 24, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 4, 0, 0, 0, 0, 0, 0, 0,
          0, 0, 0, 0
        },
        actualApplyResult.getBytes());
  }

  /**
   * Test {@link IterableToHyperLogLogPlus#apply(Iterable)} with {@code Iterable}.
   *
   * <ul>
   *   <li>Given {@link IterableToHyperLogLogPlus#IterableToHyperLogLogPlus(int, int)} with p is
   *       five and sp is zero.
   * </ul>
   *
   * <p>Method under test: {@link IterableToHyperLogLogPlus#apply(Iterable)}
   */
  @Test
  @DisplayName(
      "Test apply(Iterable) with 'Iterable'; given IterableToHyperLogLogPlus(int, int) with p is five and sp is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"HyperLogLogPlus IterableToHyperLogLogPlus.apply(Iterable)"})
  void testApplyWithIterable_givenIterableToHyperLogLogPlusWithPIsFiveAndSpIsZero3()
      throws IOException {
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
        new byte[] {
          -1, -1, -1, -2, 5, 0, 0, 24, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 4, 0, 0, 0, 0, 0, 0, 0,
          0, 0, 0, 0
        },
        actualApplyResult.getBytes());
  }

  /**
   * Test {@link IterableToHyperLogLogPlus#apply(Iterable)} with {@code Iterable}.
   *
   * <ul>
   *   <li>Given {@link IterableToHyperLogLogPlus#IterableToHyperLogLogPlus()}.
   *   <li>When {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link IterableToHyperLogLogPlus#apply(Iterable)}
   */
  @Test
  @DisplayName(
      "Test apply(Iterable) with 'Iterable'; given IterableToHyperLogLogPlus(); when ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"HyperLogLogPlus IterableToHyperLogLogPlus.apply(Iterable)"})
  void testApplyWithIterable_givenIterableToHyperLogLogPlus_whenArrayList() throws IOException {
    // Arrange
    IterableToHyperLogLogPlus iterableToHyperLogLogPlus = new IterableToHyperLogLogPlus();

    // Act
    HyperLogLogPlus actualApplyResult = iterableToHyperLogLogPlus.apply(new ArrayList<>());

    // Assert
    assertEquals(24, actualApplyResult.sizeof());
    assertArrayEquals(new byte[] {-1, -1, -1, -2, 5, 5, 1, 0}, actualApplyResult.getBytes());
  }

  /**
   * Test {@link IterableToHyperLogLogPlus#apply(Iterable)} with {@code Iterable}.
   *
   * <ul>
   *   <li>Given {@link Integer#MIN_VALUE}.
   *   <li>When {@link ArrayList#ArrayList()} add {@link Integer#MIN_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link IterableToHyperLogLogPlus#apply(Iterable)}
   */
  @Test
  @DisplayName(
      "Test apply(Iterable) with 'Iterable'; given MIN_VALUE; when ArrayList() add MIN_VALUE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"HyperLogLogPlus IterableToHyperLogLogPlus.apply(Iterable)"})
  void testApplyWithIterable_givenMin_value_whenArrayListAddMin_value() throws IOException {
    // Arrange
    IterableToHyperLogLogPlus iterableToHyperLogLogPlus = new IterableToHyperLogLogPlus();

    ArrayList<Object> o = new ArrayList<>();
    o.add(Integer.MIN_VALUE);

    // Act
    HyperLogLogPlus actualApplyResult = iterableToHyperLogLogPlus.apply(o);

    // Assert
    assertEquals(24, actualApplyResult.sizeof());
    assertArrayEquals(
        new byte[] {-1, -1, -1, -2, 5, 5, 1, 1, -3, 28}, actualApplyResult.getBytes());
  }

  /**
   * Test {@link IterableToHyperLogLogPlus#apply(Iterable)} with {@code Iterable}.
   *
   * <ul>
   *   <li>Given two.
   *   <li>When {@link ArrayList#ArrayList()} add two.
   *   <li>Then return sizeof is twenty-four.
   * </ul>
   *
   * <p>Method under test: {@link IterableToHyperLogLogPlus#apply(Iterable)}
   */
  @Test
  @DisplayName(
      "Test apply(Iterable) with 'Iterable'; given two; when ArrayList() add two; then return sizeof is twenty-four")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"HyperLogLogPlus IterableToHyperLogLogPlus.apply(Iterable)"})
  void testApplyWithIterable_givenTwo_whenArrayListAddTwo_thenReturnSizeofIsTwentyFour()
      throws IOException {
    // Arrange
    IterableToHyperLogLogPlus iterableToHyperLogLogPlus = new IterableToHyperLogLogPlus();

    ArrayList<Object> o = new ArrayList<>();
    o.add(2);

    // Act
    HyperLogLogPlus actualApplyResult = iterableToHyperLogLogPlus.apply(o);

    // Assert
    assertEquals(24, actualApplyResult.sizeof());
    assertArrayEquals(
        new byte[] {-1, -1, -1, -2, 5, 5, 1, 1, -5, 11}, actualApplyResult.getBytes());
  }
}
