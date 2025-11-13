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

package uk.gov.gchq.gaffer.commonutil.iterable;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import uk.gov.gchq.gaffer.commonutil.OneOrMore;
import uk.gov.gchq.koryphe.iterable.ChainedIterator;

class LimitedInMemorySortedIterableDiffblueTest {
  /**
   * Test {@link LimitedInMemorySortedIterable#LimitedInMemorySortedIterable(Comparator)}.
   *
   * <ul>
   *   <li>When {@link Comparator}.
   *   <li>Then return size is zero.
   * </ul>
   *
   * <p>Method under test: {@link
   * LimitedInMemorySortedIterable#LimitedInMemorySortedIterable(Comparator)}
   */
  @Test
  @DisplayName(
      "Test new LimitedInMemorySortedIterable(Comparator); when Comparator; then return size is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void LimitedInMemorySortedIterable.<init>(Comparator)"})
  void testNewLimitedInMemorySortedIterable_whenComparator_thenReturnSizeIsZero() {
    // Arrange and Act
    LimitedInMemorySortedIterable<Object> actualLimitedInMemorySortedIterable =
        new LimitedInMemorySortedIterable<>(mock(Comparator.class));

    // Assert
    assertEquals(0, actualLimitedInMemorySortedIterable.size());
  }

  /**
   * Test {@link LimitedInMemorySortedIterable#LimitedInMemorySortedIterable(Comparator, Integer)}.
   *
   * <ul>
   *   <li>When {@link Comparator}.
   *   <li>Then return size is zero.
   * </ul>
   *
   * <p>Method under test: {@link
   * LimitedInMemorySortedIterable#LimitedInMemorySortedIterable(Comparator, Integer)}
   */
  @Test
  @DisplayName(
      "Test new LimitedInMemorySortedIterable(Comparator, Integer); when Comparator; then return size is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void LimitedInMemorySortedIterable.<init>(Comparator, Integer)"})
  void testNewLimitedInMemorySortedIterable_whenComparator_thenReturnSizeIsZero2() {
    // Arrange and Act
    LimitedInMemorySortedIterable<Object> actualLimitedInMemorySortedIterable =
        new LimitedInMemorySortedIterable<>(mock(Comparator.class), 1);

    // Assert
    assertEquals(0, actualLimitedInMemorySortedIterable.size());
  }

  /**
   * Test {@link LimitedInMemorySortedIterable#LimitedInMemorySortedIterable(Comparator, Integer,
   * boolean)}.
   *
   * <ul>
   *   <li>When {@link Comparator}.
   *   <li>Then return size is zero.
   * </ul>
   *
   * <p>Method under test: {@link
   * LimitedInMemorySortedIterable#LimitedInMemorySortedIterable(Comparator, Integer, boolean)}
   */
  @Test
  @DisplayName(
      "Test new LimitedInMemorySortedIterable(Comparator, Integer, boolean); when Comparator; then return size is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void LimitedInMemorySortedIterable.<init>(Comparator, Integer, boolean)"})
  void testNewLimitedInMemorySortedIterable_whenComparator_thenReturnSizeIsZero3() {
    // Arrange and Act
    LimitedInMemorySortedIterable<Object> actualLimitedInMemorySortedIterable =
        new LimitedInMemorySortedIterable<>(mock(Comparator.class), 1, true);

    // Assert
    assertEquals(0, actualLimitedInMemorySortedIterable.size());
  }

  /**
   * Test {@link LimitedInMemorySortedIterable#LimitedInMemorySortedIterable(Comparator)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link
   * LimitedInMemorySortedIterable#LimitedInMemorySortedIterable(Comparator)}
   */
  @Test
  @DisplayName(
      "Test new LimitedInMemorySortedIterable(Comparator); when 'null'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void LimitedInMemorySortedIterable.<init>(Comparator)"})
  void testNewLimitedInMemorySortedIterable_whenNull_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> new LimitedInMemorySortedIterable<>(null));
  }

  /**
   * Test {@link LimitedInMemorySortedIterable#LimitedInMemorySortedIterable(Comparator, Integer)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link
   * LimitedInMemorySortedIterable#LimitedInMemorySortedIterable(Comparator, Integer)}
   */
  @Test
  @DisplayName(
      "Test new LimitedInMemorySortedIterable(Comparator, Integer); when 'null'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void LimitedInMemorySortedIterable.<init>(Comparator, Integer)"})
  void testNewLimitedInMemorySortedIterable_whenNull_thenThrowIllegalArgumentException2() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> new LimitedInMemorySortedIterable<>(null, 1));
  }

  /**
   * Test {@link LimitedInMemorySortedIterable#LimitedInMemorySortedIterable(Comparator, Integer,
   * boolean)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link
   * LimitedInMemorySortedIterable#LimitedInMemorySortedIterable(Comparator, Integer, boolean)}
   */
  @Test
  @DisplayName(
      "Test new LimitedInMemorySortedIterable(Comparator, Integer, boolean); when 'null'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void LimitedInMemorySortedIterable.<init>(Comparator, Integer, boolean)"})
  void testNewLimitedInMemorySortedIterable_whenNull_thenThrowIllegalArgumentException3() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> new LimitedInMemorySortedIterable<>(null, 1, true));
  }

  /**
   * Test {@link LimitedInMemorySortedIterable#LimitedInMemorySortedIterable(Comparator, Integer)}.
   *
   * <ul>
   *   <li>When zero.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link
   * LimitedInMemorySortedIterable#LimitedInMemorySortedIterable(Comparator, Integer)}
   */
  @Test
  @DisplayName(
      "Test new LimitedInMemorySortedIterable(Comparator, Integer); when zero; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void LimitedInMemorySortedIterable.<init>(Comparator, Integer)"})
  void testNewLimitedInMemorySortedIterable_whenZero_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> new LimitedInMemorySortedIterable<>(mock(Comparator.class), 0));
  }

  /**
   * Test {@link LimitedInMemorySortedIterable#LimitedInMemorySortedIterable(Comparator, Integer,
   * boolean)}.
   *
   * <ul>
   *   <li>When zero.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link
   * LimitedInMemorySortedIterable#LimitedInMemorySortedIterable(Comparator, Integer, boolean)}
   */
  @Test
  @DisplayName(
      "Test new LimitedInMemorySortedIterable(Comparator, Integer, boolean); when zero; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void LimitedInMemorySortedIterable.<init>(Comparator, Integer, boolean)"})
  void testNewLimitedInMemorySortedIterable_whenZero_thenThrowIllegalArgumentException2() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> new LimitedInMemorySortedIterable<>(mock(Comparator.class), 0, true));
  }

  /**
   * Test {@link LimitedInMemorySortedIterable#add(Object)}.
   *
   * <p>Method under test: {@link LimitedInMemorySortedIterable#add(Object)}
   */
  @Test
  @DisplayName("Test add(Object)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean LimitedInMemorySortedIterable.add(Object)"})
  void testAdd() {
    // Arrange
    Comparator<Object> comparator = mock(Comparator.class);
    when(comparator.compare(Mockito.<Object>any(), Mockito.<Object>any())).thenReturn(1);
    LimitedInMemorySortedIterable<Object> limitedInMemorySortedIterable =
        new LimitedInMemorySortedIterable<>(comparator, 1, true);

    // Act
    boolean actualAddResult = limitedInMemorySortedIterable.add("42");

    // Assert
    verify(comparator).compare(isA(Object.class), isA(Object.class));
    assertEquals(1, limitedInMemorySortedIterable.size());
    assertTrue(actualAddResult);
  }

  /**
   * Test {@link LimitedInMemorySortedIterable#add(Object)}.
   *
   * <p>Method under test: {@link LimitedInMemorySortedIterable#add(Object)}
   */
  @Test
  @DisplayName("Test add(Object)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean LimitedInMemorySortedIterable.add(Object)"})
  void testAdd2() {
    // Arrange
    Comparator<Object> comparator = mock(Comparator.class);
    when(comparator.compare(Mockito.<Object>any(), Mockito.<Object>any())).thenReturn(0);

    LimitedInMemorySortedIterable<Object> limitedInMemorySortedIterable =
        new LimitedInMemorySortedIterable<>(comparator, 1, true);
    limitedInMemorySortedIterable.add(2);
    limitedInMemorySortedIterable.add("42");

    // Act
    boolean actualAddResult = limitedInMemorySortedIterable.add("42");

    // Assert
    verify(comparator, atLeast(1)).compare(Mockito.<Object>any(), Mockito.<Object>any());
    assertEquals(1, limitedInMemorySortedIterable.size());
    assertFalse(actualAddResult);
  }

  /**
   * Test {@link LimitedInMemorySortedIterable#add(Object)}.
   *
   * <p>Method under test: {@link LimitedInMemorySortedIterable#add(Object)}
   */
  @Test
  @DisplayName("Test add(Object)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean LimitedInMemorySortedIterable.add(Object)"})
  void testAdd3() {
    // Arrange
    Comparator<Object> comparator = mock(Comparator.class);
    when(comparator.compare(Mockito.<Object>any(), Mockito.<Object>any())).thenReturn(0);

    LimitedInMemorySortedIterable<Object> limitedInMemorySortedIterable =
        new LimitedInMemorySortedIterable<>(comparator, 1, true);
    limitedInMemorySortedIterable.add(new OneOrMore<>());
    limitedInMemorySortedIterable.add("42");

    // Act
    boolean actualAddResult = limitedInMemorySortedIterable.add("42");

    // Assert
    verify(comparator, atLeast(1)).compare(Mockito.<Object>any(), Mockito.<Object>any());
    assertEquals(1, limitedInMemorySortedIterable.size());
    assertFalse(actualAddResult);
  }

  /**
   * Test {@link LimitedInMemorySortedIterable#add(Object)}.
   *
   * <p>Method under test: {@link LimitedInMemorySortedIterable#add(Object)}
   */
  @Test
  @DisplayName("Test add(Object)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean LimitedInMemorySortedIterable.add(Object)"})
  void testAdd4() {
    // Arrange
    Comparator<Object> comparator = mock(Comparator.class);
    when(comparator.compare(Mockito.<Object>any(), Mockito.<Object>any())).thenReturn(0);

    LimitedInMemorySortedIterable<Object> limitedInMemorySortedIterable =
        new LimitedInMemorySortedIterable<>(comparator, 1, true);
    limitedInMemorySortedIterable.add(null);
    limitedInMemorySortedIterable.add("42");

    // Act
    boolean actualAddResult = limitedInMemorySortedIterable.add("42");

    // Assert
    verify(comparator, atLeast(1)).compare(Mockito.<Object>any(), Mockito.<Object>any());
    assertEquals(1, limitedInMemorySortedIterable.size());
    assertFalse(actualAddResult);
  }

  /**
   * Test {@link LimitedInMemorySortedIterable#add(Object)}.
   *
   * <p>Method under test: {@link LimitedInMemorySortedIterable#add(Object)}
   */
  @Test
  @DisplayName("Test add(Object)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean LimitedInMemorySortedIterable.add(Object)"})
  void testAdd5() {
    // Arrange
    Comparator<Object> comparator = mock(Comparator.class);
    when(comparator.compare(Mockito.<Object>any(), Mockito.<Object>any())).thenReturn(0);

    LimitedInMemorySortedIterable<Object> limitedInMemorySortedIterable =
        new LimitedInMemorySortedIterable<>(comparator, 17, true);
    limitedInMemorySortedIterable.add(2);
    limitedInMemorySortedIterable.add("42");

    // Act
    boolean actualAddResult = limitedInMemorySortedIterable.add("42");

    // Assert
    verify(comparator, atLeast(1)).compare(Mockito.<Object>any(), isA(Object.class));
    assertEquals(2, limitedInMemorySortedIterable.size());
    assertFalse(actualAddResult);
  }

  /**
   * Test {@link LimitedInMemorySortedIterable#add(Object)}.
   *
   * <ul>
   *   <li>Given {@link Comparator} {@link Comparator#compare(Object, Object)} return minus one.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link LimitedInMemorySortedIterable#add(Object)}
   */
  @Test
  @DisplayName(
      "Test add(Object); given Comparator compare(Object, Object) return minus one; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean LimitedInMemorySortedIterable.add(Object)"})
  void testAdd_givenComparatorCompareReturnMinusOne_thenReturnFalse() {
    // Arrange
    Comparator<Object> comparator = mock(Comparator.class);
    when(comparator.compare(Mockito.<Object>any(), Mockito.<Object>any())).thenReturn(-1);

    LimitedInMemorySortedIterable<Object> limitedInMemorySortedIterable =
        new LimitedInMemorySortedIterable<>(comparator, 1, true);
    limitedInMemorySortedIterable.add("42");
    limitedInMemorySortedIterable.add("42");

    // Act
    boolean actualAddResult = limitedInMemorySortedIterable.add("42");

    // Assert
    verify(comparator, atLeast(1)).compare(isA(Object.class), isA(Object.class));
    assertEquals(1, limitedInMemorySortedIterable.size());
    assertFalse(actualAddResult);
  }

  /**
   * Test {@link LimitedInMemorySortedIterable#add(Object)}.
   *
   * <ul>
   *   <li>Given {@link Comparator} {@link Comparator#compare(Object, Object)} return one.
   * </ul>
   *
   * <p>Method under test: {@link LimitedInMemorySortedIterable#add(Object)}
   */
  @Test
  @DisplayName("Test add(Object); given Comparator compare(Object, Object) return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean LimitedInMemorySortedIterable.add(Object)"})
  void testAdd_givenComparatorCompareReturnOne() {
    // Arrange
    Comparator<Object> comparator = mock(Comparator.class);
    when(comparator.compare(Mockito.<Object>any(), Mockito.<Object>any())).thenReturn(1);

    LimitedInMemorySortedIterable<Object> limitedInMemorySortedIterable =
        new LimitedInMemorySortedIterable<>(comparator, 1, true);
    limitedInMemorySortedIterable.add("42");

    // Act
    boolean actualAddResult = limitedInMemorySortedIterable.add("42");

    // Assert
    verify(comparator, atLeast(1)).compare(isA(Object.class), isA(Object.class));
    assertEquals(1, limitedInMemorySortedIterable.size());
    assertTrue(actualAddResult);
  }

  /**
   * Test {@link LimitedInMemorySortedIterable#add(Object)}.
   *
   * <ul>
   *   <li>Given {@link LimitedInMemorySortedIterable#LimitedInMemorySortedIterable(Comparator)}
   *       with {@link Comparator} add {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link LimitedInMemorySortedIterable#add(Object)}
   */
  @Test
  @DisplayName(
      "Test add(Object); given LimitedInMemorySortedIterable(Comparator) with Comparator add 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean LimitedInMemorySortedIterable.add(Object)"})
  void testAdd_givenLimitedInMemorySortedIterableWithComparatorAddNull() {
    // Arrange
    Comparator<Object> comparator = mock(Comparator.class);
    when(comparator.compare(Mockito.<Object>any(), Mockito.<Object>any())).thenReturn(0);

    LimitedInMemorySortedIterable<Object> limitedInMemorySortedIterable =
        new LimitedInMemorySortedIterable<>(comparator);
    limitedInMemorySortedIterable.add(null);
    limitedInMemorySortedIterable.add("42");

    // Act
    boolean actualAddResult = limitedInMemorySortedIterable.add("42");

    // Assert
    verify(comparator, atLeast(1)).compare(Mockito.<Object>any(), isNull());
    assertEquals(3, limitedInMemorySortedIterable.size());
    assertTrue(actualAddResult);
  }

  /**
   * Test {@link LimitedInMemorySortedIterable#add(Object)}.
   *
   * <ul>
   *   <li>Given {@link LimitedInMemorySortedIterable#LimitedInMemorySortedIterable(Comparator)}
   *       with {@link Comparator} add {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link LimitedInMemorySortedIterable#add(Object)}
   */
  @Test
  @DisplayName(
      "Test add(Object); given LimitedInMemorySortedIterable(Comparator) with Comparator add 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean LimitedInMemorySortedIterable.add(Object)"})
  void testAdd_givenLimitedInMemorySortedIterableWithComparatorAddNull2() {
    // Arrange
    Comparator<Object> comparator = mock(Comparator.class);
    when(comparator.compare(Mockito.<Object>any(), Mockito.<Object>any())).thenReturn(0);

    LimitedInMemorySortedIterable<Object> limitedInMemorySortedIterable =
        new LimitedInMemorySortedIterable<>(comparator);
    limitedInMemorySortedIterable.add(null);
    limitedInMemorySortedIterable.add(null);

    // Act
    boolean actualAddResult = limitedInMemorySortedIterable.add("42");

    // Assert
    verify(comparator, atLeast(1)).compare(Mockito.<Object>any(), isNull());
    assertEquals(3, limitedInMemorySortedIterable.size());
    assertTrue(actualAddResult);
  }

  /**
   * Test {@link LimitedInMemorySortedIterable#add(Object)}.
   *
   * <ul>
   *   <li>Given {@link LimitedInMemorySortedIterable#LimitedInMemorySortedIterable(Comparator)}
   *       with {@link Comparator} add two.
   * </ul>
   *
   * <p>Method under test: {@link LimitedInMemorySortedIterable#add(Object)}
   */
  @Test
  @DisplayName(
      "Test add(Object); given LimitedInMemorySortedIterable(Comparator) with Comparator add two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean LimitedInMemorySortedIterable.add(Object)"})
  void testAdd_givenLimitedInMemorySortedIterableWithComparatorAddTwo() {
    // Arrange
    Comparator<Object> comparator = mock(Comparator.class);
    when(comparator.compare(Mockito.<Object>any(), Mockito.<Object>any())).thenReturn(0);

    LimitedInMemorySortedIterable<Object> limitedInMemorySortedIterable =
        new LimitedInMemorySortedIterable<>(comparator);
    limitedInMemorySortedIterable.add(2);
    limitedInMemorySortedIterable.add("42");

    // Act
    boolean actualAddResult = limitedInMemorySortedIterable.add("42");

    // Assert
    verify(comparator, atLeast(1)).compare(Mockito.<Object>any(), isA(Object.class));
    assertEquals(3, limitedInMemorySortedIterable.size());
    assertTrue(actualAddResult);
  }

  /**
   * Test {@link LimitedInMemorySortedIterable#add(Object)}.
   *
   * <ul>
   *   <li>Given {@link LimitedInMemorySortedIterable#LimitedInMemorySortedIterable(Comparator,
   *       Integer)} with {@link Comparator} and limit is one.
   * </ul>
   *
   * <p>Method under test: {@link LimitedInMemorySortedIterable#add(Object)}
   */
  @Test
  @DisplayName(
      "Test add(Object); given LimitedInMemorySortedIterable(Comparator, Integer) with Comparator and limit is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean LimitedInMemorySortedIterable.add(Object)"})
  void testAdd_givenLimitedInMemorySortedIterableWithComparatorAndLimitIsOne() {
    // Arrange
    Comparator<Object> comparator = mock(Comparator.class);
    when(comparator.compare(Mockito.<Object>any(), Mockito.<Object>any())).thenReturn(1);
    LimitedInMemorySortedIterable<Object> limitedInMemorySortedIterable =
        new LimitedInMemorySortedIterable<>(comparator, 1);

    // Act
    boolean actualAddResult = limitedInMemorySortedIterable.add("42");

    // Assert
    verify(comparator).compare(isA(Object.class), isA(Object.class));
    assertEquals(1, limitedInMemorySortedIterable.size());
    assertTrue(actualAddResult);
  }

  /**
   * Test {@link LimitedInMemorySortedIterable#add(Object)}.
   *
   * <ul>
   *   <li>Given {@link LimitedInMemorySortedIterable#LimitedInMemorySortedIterable(Comparator,
   *       Integer)} with {@link Comparator} and limit is one add {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link LimitedInMemorySortedIterable#add(Object)}
   */
  @Test
  @DisplayName(
      "Test add(Object); given LimitedInMemorySortedIterable(Comparator, Integer) with Comparator and limit is one add 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean LimitedInMemorySortedIterable.add(Object)"})
  void testAdd_givenLimitedInMemorySortedIterableWithComparatorAndLimitIsOneAddNull() {
    // Arrange
    Comparator<Object> comparator = mock(Comparator.class);
    when(comparator.compare(Mockito.<Object>any(), Mockito.<Object>any())).thenReturn(1);

    LimitedInMemorySortedIterable<Object> limitedInMemorySortedIterable =
        new LimitedInMemorySortedIterable<>(comparator, 1);
    limitedInMemorySortedIterable.add(null);
    limitedInMemorySortedIterable.add(null);

    // Act
    boolean actualAddResult = limitedInMemorySortedIterable.add("42");

    // Assert
    verify(comparator, atLeast(1)).compare(Mockito.<Object>any(), Mockito.<Object>any());
    assertEquals(1, limitedInMemorySortedIterable.size());
    assertTrue(actualAddResult);
  }

  /**
   * Test {@link LimitedInMemorySortedIterable#add(Object)}.
   *
   * <ul>
   *   <li>Then {@link LimitedInMemorySortedIterable#LimitedInMemorySortedIterable(Comparator)} with
   *       {@link Comparator} size is one.
   * </ul>
   *
   * <p>Method under test: {@link LimitedInMemorySortedIterable#add(Object)}
   */
  @Test
  @DisplayName(
      "Test add(Object); then LimitedInMemorySortedIterable(Comparator) with Comparator size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean LimitedInMemorySortedIterable.add(Object)"})
  void testAdd_thenLimitedInMemorySortedIterableWithComparatorSizeIsOne() {
    // Arrange
    Comparator<Object> comparator = mock(Comparator.class);
    when(comparator.compare(Mockito.<Object>any(), Mockito.<Object>any())).thenReturn(1);
    LimitedInMemorySortedIterable<Object> limitedInMemorySortedIterable =
        new LimitedInMemorySortedIterable<>(comparator);

    // Act
    boolean actualAddResult = limitedInMemorySortedIterable.add("42");

    // Assert
    verify(comparator).compare(isA(Object.class), isA(Object.class));
    assertEquals(1, limitedInMemorySortedIterable.size());
    assertTrue(actualAddResult);
  }

  /**
   * Test {@link LimitedInMemorySortedIterable#add(Object)}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link LimitedInMemorySortedIterable#add(Object)}
   */
  @Test
  @DisplayName("Test add(Object); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean LimitedInMemorySortedIterable.add(Object)"})
  void testAdd_thenReturnFalse() {
    // Arrange
    Comparator<Object> comparator = mock(Comparator.class);
    when(comparator.compare(Mockito.<Object>any(), Mockito.<Object>any())).thenReturn(0);

    LimitedInMemorySortedIterable<Object> limitedInMemorySortedIterable =
        new LimitedInMemorySortedIterable<>(comparator, 1, true);
    limitedInMemorySortedIterable.add("42");
    limitedInMemorySortedIterable.add("42");

    // Act
    boolean actualAddResult = limitedInMemorySortedIterable.add("42");

    // Assert
    verify(comparator, atLeast(1)).compare(isA(Object.class), isA(Object.class));
    assertEquals(1, limitedInMemorySortedIterable.size());
    assertFalse(actualAddResult);
  }

  /**
   * Test {@link LimitedInMemorySortedIterable#addAll(Iterable)}.
   *
   * <p>Method under test: {@link LimitedInMemorySortedIterable#addAll(Iterable)}
   */
  @Test
  @DisplayName("Test addAll(Iterable)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean LimitedInMemorySortedIterable.addAll(Iterable)"})
  void testAddAll() {
    // Arrange
    Comparator<Object> comparator = mock(Comparator.class);
    when(comparator.compare(Mockito.<Object>any(), Mockito.<Object>any())).thenReturn(1);
    LimitedInMemorySortedIterable<Object> limitedInMemorySortedIterable =
        new LimitedInMemorySortedIterable<>(comparator, 1, true);

    ArrayList<Object> items = new ArrayList<>();
    items.add("42");

    // Act
    boolean actualAddAllResult = limitedInMemorySortedIterable.addAll(items);

    // Assert
    verify(comparator).compare(isA(Object.class), isA(Object.class));
    assertEquals(1, limitedInMemorySortedIterable.size());
    assertTrue(actualAddAllResult);
  }

  /**
   * Test {@link LimitedInMemorySortedIterable#addAll(Iterable)}.
   *
   * <p>Method under test: {@link LimitedInMemorySortedIterable#addAll(Iterable)}
   */
  @Test
  @DisplayName("Test addAll(Iterable)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean LimitedInMemorySortedIterable.addAll(Iterable)"})
  void testAddAll2() {
    // Arrange
    Comparator<Object> comparator = mock(Comparator.class);
    when(comparator.compare(Mockito.<Object>any(), Mockito.<Object>any())).thenReturn(0);

    LimitedInMemorySortedIterable<Object> limitedInMemorySortedIterable =
        new LimitedInMemorySortedIterable<>(comparator, 1, true);
    limitedInMemorySortedIterable.add("42");
    limitedInMemorySortedIterable.add("42");

    ArrayList<Object> items = new ArrayList<>();
    items.add("42");

    // Act
    boolean actualAddAllResult = limitedInMemorySortedIterable.addAll(items);

    // Assert
    verify(comparator, atLeast(1)).compare(isA(Object.class), isA(Object.class));
    assertEquals(1, limitedInMemorySortedIterable.size());
    assertFalse(actualAddAllResult);
  }

  /**
   * Test {@link LimitedInMemorySortedIterable#addAll(Iterable)}.
   *
   * <p>Method under test: {@link LimitedInMemorySortedIterable#addAll(Iterable)}
   */
  @Test
  @DisplayName("Test addAll(Iterable)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean LimitedInMemorySortedIterable.addAll(Iterable)"})
  void testAddAll3() {
    // Arrange
    Comparator<Object> comparator = mock(Comparator.class);
    when(comparator.compare(Mockito.<Object>any(), Mockito.<Object>any())).thenReturn(0);

    LimitedInMemorySortedIterable<Object> limitedInMemorySortedIterable =
        new LimitedInMemorySortedIterable<>(comparator, 1, true);
    limitedInMemorySortedIterable.add(2);
    limitedInMemorySortedIterable.add("42");

    ArrayList<Object> items = new ArrayList<>();
    items.add("42");

    // Act
    boolean actualAddAllResult = limitedInMemorySortedIterable.addAll(items);

    // Assert
    verify(comparator, atLeast(1)).compare(Mockito.<Object>any(), Mockito.<Object>any());
    assertEquals(1, limitedInMemorySortedIterable.size());
    assertFalse(actualAddAllResult);
  }

  /**
   * Test {@link LimitedInMemorySortedIterable#addAll(Iterable)}.
   *
   * <p>Method under test: {@link LimitedInMemorySortedIterable#addAll(Iterable)}
   */
  @Test
  @DisplayName("Test addAll(Iterable)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean LimitedInMemorySortedIterable.addAll(Iterable)"})
  void testAddAll4() {
    // Arrange
    Comparator<Object> comparator = mock(Comparator.class);
    when(comparator.compare(Mockito.<Object>any(), Mockito.<Object>any())).thenReturn(0);

    LimitedInMemorySortedIterable<Object> limitedInMemorySortedIterable =
        new LimitedInMemorySortedIterable<>(comparator, 1, true);
    limitedInMemorySortedIterable.add(new OneOrMore<>());
    limitedInMemorySortedIterable.add("42");

    ArrayList<Object> items = new ArrayList<>();
    items.add("42");

    // Act
    boolean actualAddAllResult = limitedInMemorySortedIterable.addAll(items);

    // Assert
    verify(comparator, atLeast(1)).compare(Mockito.<Object>any(), Mockito.<Object>any());
    assertEquals(1, limitedInMemorySortedIterable.size());
    assertFalse(actualAddAllResult);
  }

  /**
   * Test {@link LimitedInMemorySortedIterable#addAll(Iterable)}.
   *
   * <p>Method under test: {@link LimitedInMemorySortedIterable#addAll(Iterable)}
   */
  @Test
  @DisplayName("Test addAll(Iterable)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean LimitedInMemorySortedIterable.addAll(Iterable)"})
  void testAddAll5() {
    // Arrange
    Comparator<Object> comparator = mock(Comparator.class);
    when(comparator.compare(Mockito.<Object>any(), Mockito.<Object>any())).thenReturn(0);

    LimitedInMemorySortedIterable<Object> limitedInMemorySortedIterable =
        new LimitedInMemorySortedIterable<>(comparator, 1, true);
    limitedInMemorySortedIterable.add(null);
    limitedInMemorySortedIterable.add("42");

    ArrayList<Object> items = new ArrayList<>();
    items.add("42");

    // Act
    boolean actualAddAllResult = limitedInMemorySortedIterable.addAll(items);

    // Assert
    verify(comparator, atLeast(1)).compare(Mockito.<Object>any(), Mockito.<Object>any());
    assertEquals(1, limitedInMemorySortedIterable.size());
    assertFalse(actualAddAllResult);
  }

  /**
   * Test {@link LimitedInMemorySortedIterable#addAll(Iterable)}.
   *
   * <p>Method under test: {@link LimitedInMemorySortedIterable#addAll(Iterable)}
   */
  @Test
  @DisplayName("Test addAll(Iterable)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean LimitedInMemorySortedIterable.addAll(Iterable)"})
  void testAddAll6() {
    // Arrange
    Comparator<Object> comparator = mock(Comparator.class);
    when(comparator.compare(Mockito.<Object>any(), Mockito.<Object>any())).thenReturn(0);

    LimitedInMemorySortedIterable<Object> limitedInMemorySortedIterable =
        new LimitedInMemorySortedIterable<>(comparator, 17, true);
    limitedInMemorySortedIterable.add(2);
    limitedInMemorySortedIterable.add("42");

    ArrayList<Object> items = new ArrayList<>();
    items.add("42");

    // Act
    boolean actualAddAllResult = limitedInMemorySortedIterable.addAll(items);

    // Assert
    verify(comparator, atLeast(1)).compare(Mockito.<Object>any(), isA(Object.class));
    assertEquals(2, limitedInMemorySortedIterable.size());
    assertFalse(actualAddAllResult);
  }

  /**
   * Test {@link LimitedInMemorySortedIterable#addAll(Iterable)}.
   *
   * <ul>
   *   <li>Given {@link Comparator} {@link Comparator#compare(Object, Object)} return minus one.
   * </ul>
   *
   * <p>Method under test: {@link LimitedInMemorySortedIterable#addAll(Iterable)}
   */
  @Test
  @DisplayName("Test addAll(Iterable); given Comparator compare(Object, Object) return minus one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean LimitedInMemorySortedIterable.addAll(Iterable)"})
  void testAddAll_givenComparatorCompareReturnMinusOne() {
    // Arrange
    Comparator<Object> comparator = mock(Comparator.class);
    when(comparator.compare(Mockito.<Object>any(), Mockito.<Object>any())).thenReturn(-1);

    LimitedInMemorySortedIterable<Object> limitedInMemorySortedIterable =
        new LimitedInMemorySortedIterable<>(comparator, 1, true);
    limitedInMemorySortedIterable.add("42");
    limitedInMemorySortedIterable.add("42");

    ArrayList<Object> items = new ArrayList<>();
    items.add("42");

    // Act
    boolean actualAddAllResult = limitedInMemorySortedIterable.addAll(items);

    // Assert
    verify(comparator, atLeast(1)).compare(isA(Object.class), isA(Object.class));
    assertEquals(1, limitedInMemorySortedIterable.size());
    assertFalse(actualAddAllResult);
  }

  /**
   * Test {@link LimitedInMemorySortedIterable#addAll(Iterable)}.
   *
   * <ul>
   *   <li>Given {@link Comparator} {@link Comparator#compare(Object, Object)} return one.
   * </ul>
   *
   * <p>Method under test: {@link LimitedInMemorySortedIterable#addAll(Iterable)}
   */
  @Test
  @DisplayName("Test addAll(Iterable); given Comparator compare(Object, Object) return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean LimitedInMemorySortedIterable.addAll(Iterable)"})
  void testAddAll_givenComparatorCompareReturnOne() {
    // Arrange
    Comparator<Object> comparator = mock(Comparator.class);
    when(comparator.compare(Mockito.<Object>any(), Mockito.<Object>any())).thenReturn(1);

    LimitedInMemorySortedIterable<Object> limitedInMemorySortedIterable =
        new LimitedInMemorySortedIterable<>(comparator, 1, true);
    limitedInMemorySortedIterable.add("42");

    ArrayList<Object> items = new ArrayList<>();
    items.add("42");

    // Act
    boolean actualAddAllResult = limitedInMemorySortedIterable.addAll(items);

    // Assert
    verify(comparator, atLeast(1)).compare(isA(Object.class), isA(Object.class));
    assertEquals(1, limitedInMemorySortedIterable.size());
    assertTrue(actualAddAllResult);
  }

  /**
   * Test {@link LimitedInMemorySortedIterable#addAll(Iterable)}.
   *
   * <ul>
   *   <li>Given {@link LimitedInMemorySortedIterable#LimitedInMemorySortedIterable(Comparator)}
   *       with {@link Comparator} add {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link LimitedInMemorySortedIterable#addAll(Iterable)}
   */
  @Test
  @DisplayName(
      "Test addAll(Iterable); given LimitedInMemorySortedIterable(Comparator) with Comparator add 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean LimitedInMemorySortedIterable.addAll(Iterable)"})
  void testAddAll_givenLimitedInMemorySortedIterableWithComparatorAddNull() {
    // Arrange
    Comparator<Object> comparator = mock(Comparator.class);
    when(comparator.compare(Mockito.<Object>any(), Mockito.<Object>any())).thenReturn(0);

    LimitedInMemorySortedIterable<Object> limitedInMemorySortedIterable =
        new LimitedInMemorySortedIterable<>(comparator);
    limitedInMemorySortedIterable.add(null);
    limitedInMemorySortedIterable.add("42");

    ArrayList<Object> items = new ArrayList<>();
    items.add("42");

    // Act
    boolean actualAddAllResult = limitedInMemorySortedIterable.addAll(items);

    // Assert
    verify(comparator, atLeast(1)).compare(Mockito.<Object>any(), isNull());
    assertEquals(3, limitedInMemorySortedIterable.size());
    assertTrue(actualAddAllResult);
  }

  /**
   * Test {@link LimitedInMemorySortedIterable#addAll(Iterable)}.
   *
   * <ul>
   *   <li>Given {@link LimitedInMemorySortedIterable#LimitedInMemorySortedIterable(Comparator)}
   *       with {@link Comparator} add {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link LimitedInMemorySortedIterable#addAll(Iterable)}
   */
  @Test
  @DisplayName(
      "Test addAll(Iterable); given LimitedInMemorySortedIterable(Comparator) with Comparator add 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean LimitedInMemorySortedIterable.addAll(Iterable)"})
  void testAddAll_givenLimitedInMemorySortedIterableWithComparatorAddNull2() {
    // Arrange
    Comparator<Object> comparator = mock(Comparator.class);
    when(comparator.compare(Mockito.<Object>any(), Mockito.<Object>any())).thenReturn(0);

    LimitedInMemorySortedIterable<Object> limitedInMemorySortedIterable =
        new LimitedInMemorySortedIterable<>(comparator);
    limitedInMemorySortedIterable.add(null);
    limitedInMemorySortedIterable.add(null);

    ArrayList<Object> items = new ArrayList<>();
    items.add("42");

    // Act
    boolean actualAddAllResult = limitedInMemorySortedIterable.addAll(items);

    // Assert
    verify(comparator, atLeast(1)).compare(Mockito.<Object>any(), isNull());
    assertEquals(3, limitedInMemorySortedIterable.size());
    assertTrue(actualAddAllResult);
  }

  /**
   * Test {@link LimitedInMemorySortedIterable#addAll(Iterable)}.
   *
   * <ul>
   *   <li>Given {@link LimitedInMemorySortedIterable#LimitedInMemorySortedIterable(Comparator)}
   *       with {@link Comparator} add two.
   * </ul>
   *
   * <p>Method under test: {@link LimitedInMemorySortedIterable#addAll(Iterable)}
   */
  @Test
  @DisplayName(
      "Test addAll(Iterable); given LimitedInMemorySortedIterable(Comparator) with Comparator add two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean LimitedInMemorySortedIterable.addAll(Iterable)"})
  void testAddAll_givenLimitedInMemorySortedIterableWithComparatorAddTwo() {
    // Arrange
    Comparator<Object> comparator = mock(Comparator.class);
    when(comparator.compare(Mockito.<Object>any(), Mockito.<Object>any())).thenReturn(0);

    LimitedInMemorySortedIterable<Object> limitedInMemorySortedIterable =
        new LimitedInMemorySortedIterable<>(comparator);
    limitedInMemorySortedIterable.add(2);
    limitedInMemorySortedIterable.add("42");

    ArrayList<Object> items = new ArrayList<>();
    items.add("42");

    // Act
    boolean actualAddAllResult = limitedInMemorySortedIterable.addAll(items);

    // Assert
    verify(comparator, atLeast(1)).compare(Mockito.<Object>any(), isA(Object.class));
    assertEquals(3, limitedInMemorySortedIterable.size());
    assertTrue(actualAddAllResult);
  }

  /**
   * Test {@link LimitedInMemorySortedIterable#addAll(Iterable)}.
   *
   * <ul>
   *   <li>Given {@link LimitedInMemorySortedIterable#LimitedInMemorySortedIterable(Comparator,
   *       Integer)} with {@link Comparator} and limit is one.
   * </ul>
   *
   * <p>Method under test: {@link LimitedInMemorySortedIterable#addAll(Iterable)}
   */
  @Test
  @DisplayName(
      "Test addAll(Iterable); given LimitedInMemorySortedIterable(Comparator, Integer) with Comparator and limit is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean LimitedInMemorySortedIterable.addAll(Iterable)"})
  void testAddAll_givenLimitedInMemorySortedIterableWithComparatorAndLimitIsOne() {
    // Arrange
    Comparator<Object> comparator = mock(Comparator.class);
    when(comparator.compare(Mockito.<Object>any(), Mockito.<Object>any())).thenReturn(1);
    LimitedInMemorySortedIterable<Object> limitedInMemorySortedIterable =
        new LimitedInMemorySortedIterable<>(comparator, 1);

    ArrayList<Object> items = new ArrayList<>();
    items.add("42");

    // Act
    boolean actualAddAllResult = limitedInMemorySortedIterable.addAll(items);

    // Assert
    verify(comparator).compare(isA(Object.class), isA(Object.class));
    assertEquals(1, limitedInMemorySortedIterable.size());
    assertTrue(actualAddAllResult);
  }

  /**
   * Test {@link LimitedInMemorySortedIterable#addAll(Iterable)}.
   *
   * <ul>
   *   <li>Given {@link LimitedInMemorySortedIterable#LimitedInMemorySortedIterable(Comparator,
   *       Integer)} with {@link Comparator} and limit is one add {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link LimitedInMemorySortedIterable#addAll(Iterable)}
   */
  @Test
  @DisplayName(
      "Test addAll(Iterable); given LimitedInMemorySortedIterable(Comparator, Integer) with Comparator and limit is one add 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean LimitedInMemorySortedIterable.addAll(Iterable)"})
  void testAddAll_givenLimitedInMemorySortedIterableWithComparatorAndLimitIsOneAddNull() {
    // Arrange
    Comparator<Object> comparator = mock(Comparator.class);
    when(comparator.compare(Mockito.<Object>any(), Mockito.<Object>any())).thenReturn(1);

    LimitedInMemorySortedIterable<Object> limitedInMemorySortedIterable =
        new LimitedInMemorySortedIterable<>(comparator, 1);
    limitedInMemorySortedIterable.add(null);
    limitedInMemorySortedIterable.add(null);

    ArrayList<Object> items = new ArrayList<>();
    items.add("42");

    // Act
    boolean actualAddAllResult = limitedInMemorySortedIterable.addAll(items);

    // Assert
    verify(comparator, atLeast(1)).compare(Mockito.<Object>any(), Mockito.<Object>any());
    assertEquals(1, limitedInMemorySortedIterable.size());
    assertTrue(actualAddAllResult);
  }

  /**
   * Test {@link LimitedInMemorySortedIterable#addAll(Iterable)}.
   *
   * <ul>
   *   <li>Then {@link LimitedInMemorySortedIterable#LimitedInMemorySortedIterable(Comparator)} with
   *       {@link Comparator} size is one.
   * </ul>
   *
   * <p>Method under test: {@link LimitedInMemorySortedIterable#addAll(Iterable)}
   */
  @Test
  @DisplayName(
      "Test addAll(Iterable); then LimitedInMemorySortedIterable(Comparator) with Comparator size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean LimitedInMemorySortedIterable.addAll(Iterable)"})
  void testAddAll_thenLimitedInMemorySortedIterableWithComparatorSizeIsOne() {
    // Arrange
    Comparator<Object> comparator = mock(Comparator.class);
    when(comparator.compare(Mockito.<Object>any(), Mockito.<Object>any())).thenReturn(1);
    LimitedInMemorySortedIterable<Object> limitedInMemorySortedIterable =
        new LimitedInMemorySortedIterable<>(comparator);

    ArrayList<Object> items = new ArrayList<>();
    items.add("42");

    // Act
    boolean actualAddAllResult = limitedInMemorySortedIterable.addAll(items);

    // Assert
    verify(comparator).compare(isA(Object.class), isA(Object.class));
    assertEquals(1, limitedInMemorySortedIterable.size());
    assertTrue(actualAddAllResult);
  }

  /**
   * Test {@link LimitedInMemorySortedIterable#addAll(Iterable)}.
   *
   * <ul>
   *   <li>Then {@link LimitedInMemorySortedIterable#LimitedInMemorySortedIterable(Comparator)} with
   *       {@link Comparator} size is zero.
   * </ul>
   *
   * <p>Method under test: {@link LimitedInMemorySortedIterable#addAll(Iterable)}
   */
  @Test
  @DisplayName(
      "Test addAll(Iterable); then LimitedInMemorySortedIterable(Comparator) with Comparator size is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean LimitedInMemorySortedIterable.addAll(Iterable)"})
  void testAddAll_thenLimitedInMemorySortedIterableWithComparatorSizeIsZero() {
    // Arrange
    LimitedInMemorySortedIterable<Object> limitedInMemorySortedIterable =
        new LimitedInMemorySortedIterable<>(mock(Comparator.class));

    // Act
    boolean actualAddAllResult = limitedInMemorySortedIterable.addAll(new ArrayList<>());

    // Assert
    assertEquals(0, limitedInMemorySortedIterable.size());
    assertFalse(actualAddAllResult);
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link LimitedInMemorySortedIterable#toString()}
   *   <li>{@link LimitedInMemorySortedIterable#size()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "int LimitedInMemorySortedIterable.size()",
    "String LimitedInMemorySortedIterable.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    LimitedInMemorySortedIterable<Object> limitedInMemorySortedIterable =
        new LimitedInMemorySortedIterable<>(mock(Comparator.class));

    // Act
    String actualToStringResult = limitedInMemorySortedIterable.toString();

    // Assert
    assertEquals(
        "LimitedInMemorySortedIterable[size=0,deduplicate=false,backingMap={}]",
        actualToStringResult);
    assertEquals(0, limitedInMemorySortedIterable.size());
  }

  /**
   * Test {@link LimitedInMemorySortedIterable#iterator()}.
   *
   * <ul>
   *   <li>Given {@link Comparator} {@link Comparator#compare(Object, Object)} return one.
   *   <li>Then return {@link ChainedIterator}.
   * </ul>
   *
   * <p>Method under test: {@link LimitedInMemorySortedIterable#iterator()}
   */
  @Test
  @DisplayName(
      "Test iterator(); given Comparator compare(Object, Object) return one; then return ChainedIterator")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Iterator LimitedInMemorySortedIterable.iterator()"})
  void testIterator_givenComparatorCompareReturnOne_thenReturnChainedIterator() {
    // Arrange
    Comparator<Object> comparator = mock(Comparator.class);
    when(comparator.compare(Mockito.<Object>any(), Mockito.<Object>any())).thenReturn(1);

    LimitedInMemorySortedIterable<Object> limitedInMemorySortedIterable =
        new LimitedInMemorySortedIterable<>(comparator);
    limitedInMemorySortedIterable.add("42");

    // Act
    Iterator<Object> actualIteratorResult = limitedInMemorySortedIterable.iterator();

    // Assert
    verify(comparator).compare(isA(Object.class), isA(Object.class));
    assertTrue(actualIteratorResult instanceof ChainedIterator);
    assertEquals("42", actualIteratorResult.next());
    assertFalse(actualIteratorResult.hasNext());
  }

  /**
   * Test {@link LimitedInMemorySortedIterable#iterator()}.
   *
   * <ul>
   *   <li>Given {@link LimitedInMemorySortedIterable#LimitedInMemorySortedIterable(Comparator)}
   *       with {@link Comparator}.
   * </ul>
   *
   * <p>Method under test: {@link LimitedInMemorySortedIterable#iterator()}
   */
  @Test
  @DisplayName("Test iterator(); given LimitedInMemorySortedIterable(Comparator) with Comparator")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Iterator LimitedInMemorySortedIterable.iterator()"})
  void testIterator_givenLimitedInMemorySortedIterableWithComparator() {
    // Arrange
    LimitedInMemorySortedIterable<Object> limitedInMemorySortedIterable =
        new LimitedInMemorySortedIterable<>(mock(Comparator.class));

    // Act and Assert
    assertFalse(limitedInMemorySortedIterable.iterator().hasNext());
  }

  /**
   * Test {@link LimitedInMemorySortedIterable#equals(Object)}, and {@link
   * LimitedInMemorySortedIterable#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link LimitedInMemorySortedIterable#equals(Object)}
   *   <li>{@link LimitedInMemorySortedIterable#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean LimitedInMemorySortedIterable.equals(Object)",
    "int LimitedInMemorySortedIterable.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    LimitedInMemorySortedIterable<Object> limitedInMemorySortedIterable =
        new LimitedInMemorySortedIterable<>(mock(Comparator.class));
    LimitedInMemorySortedIterable<Object> limitedInMemorySortedIterable2 =
        new LimitedInMemorySortedIterable<>(mock(Comparator.class));

    // Act and Assert
    assertEquals(limitedInMemorySortedIterable, limitedInMemorySortedIterable2);
    assertEquals(
        limitedInMemorySortedIterable.hashCode(), limitedInMemorySortedIterable2.hashCode());
  }

  /**
   * Test {@link LimitedInMemorySortedIterable#equals(Object)}, and {@link
   * LimitedInMemorySortedIterable#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link LimitedInMemorySortedIterable#equals(Object)}
   *   <li>{@link LimitedInMemorySortedIterable#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean LimitedInMemorySortedIterable.equals(Object)",
    "int LimitedInMemorySortedIterable.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    LimitedInMemorySortedIterable<Object> limitedInMemorySortedIterable =
        new LimitedInMemorySortedIterable<>(mock(Comparator.class));

    // Act and Assert
    assertEquals(limitedInMemorySortedIterable, limitedInMemorySortedIterable);
    int expectedHashCodeResult = limitedInMemorySortedIterable.hashCode();
    assertEquals(expectedHashCodeResult, limitedInMemorySortedIterable.hashCode());
  }

  /**
   * Test {@link LimitedInMemorySortedIterable#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link LimitedInMemorySortedIterable#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean LimitedInMemorySortedIterable.equals(Object)",
    "int LimitedInMemorySortedIterable.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    LimitedInMemorySortedIterable<Object> limitedInMemorySortedIterable =
        new LimitedInMemorySortedIterable<>(mock(Comparator.class), 1);

    // Act and Assert
    assertNotEquals(
        limitedInMemorySortedIterable, new LimitedInMemorySortedIterable<>(mock(Comparator.class)));
  }

  /**
   * Test {@link LimitedInMemorySortedIterable#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link LimitedInMemorySortedIterable#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean LimitedInMemorySortedIterable.equals(Object)",
    "int LimitedInMemorySortedIterable.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    LimitedInMemorySortedIterable<Object> limitedInMemorySortedIterable =
        new LimitedInMemorySortedIterable<>(mock(Comparator.class));

    // Act and Assert
    assertNotEquals(limitedInMemorySortedIterable, null);
  }

  /**
   * Test {@link LimitedInMemorySortedIterable#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link LimitedInMemorySortedIterable#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean LimitedInMemorySortedIterable.equals(Object)",
    "int LimitedInMemorySortedIterable.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    LimitedInMemorySortedIterable<Object> limitedInMemorySortedIterable =
        new LimitedInMemorySortedIterable<>(mock(Comparator.class));

    // Act and Assert
    assertNotEquals(
        limitedInMemorySortedIterable, "Different type to LimitedInMemorySortedIterable");
  }
}
