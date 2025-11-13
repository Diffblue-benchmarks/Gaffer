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
   * <ul>
   *   <li>When {@link Comparator}.</li>
   *   <li>Then return size is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link LimitedInMemorySortedIterable#LimitedInMemorySortedIterable(Comparator)}
   */
  @Test
  @DisplayName("Test new LimitedInMemorySortedIterable(Comparator); when Comparator; then return size is zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void LimitedInMemorySortedIterable.<init>(Comparator)"})
  void testNewLimitedInMemorySortedIterable_whenComparator_thenReturnSizeIsZero() {
    // Arrange and Act
    LimitedInMemorySortedIterable<Object> actualLimitedInMemorySortedIterable = new LimitedInMemorySortedIterable<>(
        mock(Comparator.class));

    // Assert
    assertEquals(0, actualLimitedInMemorySortedIterable.size());
  }

  /**
   * Test {@link LimitedInMemorySortedIterable#LimitedInMemorySortedIterable(Comparator, Integer)}.
   * <ul>
   *   <li>When {@link Comparator}.</li>
   *   <li>Then return size is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link LimitedInMemorySortedIterable#LimitedInMemorySortedIterable(Comparator, Integer)}
   */
  @Test
  @DisplayName("Test new LimitedInMemorySortedIterable(Comparator, Integer); when Comparator; then return size is zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void LimitedInMemorySortedIterable.<init>(Comparator, Integer)"})
  void testNewLimitedInMemorySortedIterable_whenComparator_thenReturnSizeIsZero2() {
    // Arrange and Act
    LimitedInMemorySortedIterable<Object> actualLimitedInMemorySortedIterable = new LimitedInMemorySortedIterable<>(
        mock(Comparator.class), 1);

    // Assert
    assertEquals(0, actualLimitedInMemorySortedIterable.size());
  }

  /**
   * Test {@link LimitedInMemorySortedIterable#LimitedInMemorySortedIterable(Comparator, Integer, boolean)}.
   * <ul>
   *   <li>When {@link Comparator}.</li>
   *   <li>Then return size is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link LimitedInMemorySortedIterable#LimitedInMemorySortedIterable(Comparator, Integer, boolean)}
   */
  @Test
  @DisplayName("Test new LimitedInMemorySortedIterable(Comparator, Integer, boolean); when Comparator; then return size is zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void LimitedInMemorySortedIterable.<init>(Comparator, Integer, boolean)"})
  void testNewLimitedInMemorySortedIterable_whenComparator_thenReturnSizeIsZero3() {
    // Arrange and Act
    LimitedInMemorySortedIterable<Object> actualLimitedInMemorySortedIterable = new LimitedInMemorySortedIterable<>(
        mock(Comparator.class), 1, true);

    // Assert
    assertEquals(0, actualLimitedInMemorySortedIterable.size());
  }

  /**
   * Test {@link LimitedInMemorySortedIterable#LimitedInMemorySortedIterable(Comparator)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LimitedInMemorySortedIterable#LimitedInMemorySortedIterable(Comparator)}
   */
  @Test
  @DisplayName("Test new LimitedInMemorySortedIterable(Comparator); when 'null'; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void LimitedInMemorySortedIterable.<init>(Comparator)"})
  void testNewLimitedInMemorySortedIterable_whenNull_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> new LimitedInMemorySortedIterable<>(null));
  }

  /**
   * Test {@link LimitedInMemorySortedIterable#LimitedInMemorySortedIterable(Comparator, Integer)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LimitedInMemorySortedIterable#LimitedInMemorySortedIterable(Comparator, Integer)}
   */
  @Test
  @DisplayName("Test new LimitedInMemorySortedIterable(Comparator, Integer); when 'null'; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void LimitedInMemorySortedIterable.<init>(Comparator, Integer)"})
  void testNewLimitedInMemorySortedIterable_whenNull_thenThrowIllegalArgumentException2() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> new LimitedInMemorySortedIterable<>(null, 1));

  }

  /**
   * Test {@link LimitedInMemorySortedIterable#LimitedInMemorySortedIterable(Comparator, Integer, boolean)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LimitedInMemorySortedIterable#LimitedInMemorySortedIterable(Comparator, Integer, boolean)}
   */
  @Test
  @DisplayName("Test new LimitedInMemorySortedIterable(Comparator, Integer, boolean); when 'null'; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void LimitedInMemorySortedIterable.<init>(Comparator, Integer, boolean)"})
  void testNewLimitedInMemorySortedIterable_whenNull_thenThrowIllegalArgumentException3() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> new LimitedInMemorySortedIterable<>(null, 1, true));

  }

  /**
   * Test {@link LimitedInMemorySortedIterable#LimitedInMemorySortedIterable(Comparator, Integer)}.
   * <ul>
   *   <li>When zero.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LimitedInMemorySortedIterable#LimitedInMemorySortedIterable(Comparator, Integer)}
   */
  @Test
  @DisplayName("Test new LimitedInMemorySortedIterable(Comparator, Integer); when zero; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void LimitedInMemorySortedIterable.<init>(Comparator, Integer)"})
  void testNewLimitedInMemorySortedIterable_whenZero_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> new LimitedInMemorySortedIterable<>(mock(Comparator.class), 0));

  }

  /**
   * Test {@link LimitedInMemorySortedIterable#LimitedInMemorySortedIterable(Comparator, Integer, boolean)}.
   * <ul>
   *   <li>When zero.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LimitedInMemorySortedIterable#LimitedInMemorySortedIterable(Comparator, Integer, boolean)}
   */
  @Test
  @DisplayName("Test new LimitedInMemorySortedIterable(Comparator, Integer, boolean); when zero; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void LimitedInMemorySortedIterable.<init>(Comparator, Integer, boolean)"})
  void testNewLimitedInMemorySortedIterable_whenZero_thenThrowIllegalArgumentException2() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> new LimitedInMemorySortedIterable<>(mock(Comparator.class), 0, true));

  }

  /**
   * Test {@link LimitedInMemorySortedIterable#add(Object)}.
   * <p>
   * Method under test: {@link LimitedInMemorySortedIterable#add(Object)}
   */
  @Test
  @DisplayName("Test add(Object)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean LimitedInMemorySortedIterable.add(Object)"})
  void testAdd() {
    // Arrange
    Comparator<Object> comparator = mock(Comparator.class);
    when(comparator.compare(Mockito.<Object>any(), Mockito.<Object>any())).thenReturn(1);
    LimitedInMemorySortedIterable<Object> limitedInMemorySortedIterable = new LimitedInMemorySortedIterable<>(
        comparator, 1, true);

    // Act
    boolean actualAddResult = limitedInMemorySortedIterable.add("42");

    // Assert
    verify(comparator).compare(isA(Object.class), isA(Object.class));
    assertEquals(1, limitedInMemorySortedIterable.size());
    assertTrue(actualAddResult);
  }

  /**
   * Test {@link LimitedInMemorySortedIterable#add(Object)}.
   * <p>
   * Method under test: {@link LimitedInMemorySortedIterable#add(Object)}
   */
  @Test
  @DisplayName("Test add(Object)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean LimitedInMemorySortedIterable.add(Object)"})
  void testAdd2() {
    // Arrange
    new IllegalArgumentException("foo");
    Comparator<Object> comparator = mock(Comparator.class);
    when(comparator.compare(Mockito.<Object>any(), Mockito.<Object>any())).thenReturn(0);

    LimitedInMemorySortedIterable<Object> limitedInMemorySortedIterable = new LimitedInMemorySortedIterable<>(
        comparator, 1, true);
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
   * <p>
   * Method under test: {@link LimitedInMemorySortedIterable#add(Object)}
   */
  @Test
  @DisplayName("Test add(Object)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean LimitedInMemorySortedIterable.add(Object)"})
  void testAdd3() {
    // Arrange
    new IllegalArgumentException("foo");
    Comparator<Object> comparator = mock(Comparator.class);
    when(comparator.compare(Mockito.<Object>any(), Mockito.<Object>any())).thenReturn(0);

    LimitedInMemorySortedIterable<Object> limitedInMemorySortedIterable = new LimitedInMemorySortedIterable<>(
        comparator, 1, true);
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
   * <p>
   * Method under test: {@link LimitedInMemorySortedIterable#add(Object)}
   */
  @Test
  @DisplayName("Test add(Object)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean LimitedInMemorySortedIterable.add(Object)"})
  void testAdd4() {
    // Arrange
    new IllegalArgumentException("foo");
    Comparator<Object> comparator = mock(Comparator.class);
    when(comparator.compare(Mockito.<Object>any(), Mockito.<Object>any())).thenReturn(0);

    LimitedInMemorySortedIterable<Object> limitedInMemorySortedIterable = new LimitedInMemorySortedIterable<>(
        comparator, 1, true);
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
   * <p>
   * Method under test: {@link LimitedInMemorySortedIterable#add(Object)}
   */
  @Test
  @DisplayName("Test add(Object)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean LimitedInMemorySortedIterable.add(Object)"})
  void testAdd5() {
    // Arrange
    new IllegalArgumentException("foo");
    Comparator<Object> comparator = mock(Comparator.class);
    when(comparator.compare(Mockito.<Object>any(), Mockito.<Object>any())).thenReturn(0);

    LimitedInMemorySortedIterable<Object> limitedInMemorySortedIterable = new LimitedInMemorySortedIterable<>(
        comparator, 1, true);
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
   * <p>
   * Method under test: {@link LimitedInMemorySortedIterable#add(Object)}
   */
  @Test
  @DisplayName("Test add(Object)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean LimitedInMemorySortedIterable.add(Object)"})
  void testAdd6() {
    // Arrange
    new IllegalArgumentException("foo");
    Comparator<Object> comparator = mock(Comparator.class);
    when(comparator.compare(Mockito.<Object>any(), Mockito.<Object>any())).thenReturn(0);

    LimitedInMemorySortedIterable<Object> limitedInMemorySortedIterable = new LimitedInMemorySortedIterable<>(
        comparator, 17, true);
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
   * <ul>
   *   <li>Given {@link Comparator} {@link Comparator#compare(Object, Object)} return minus one.</li>
   * </ul>
   * <p>
   * Method under test: {@link LimitedInMemorySortedIterable#add(Object)}
   */
  @Test
  @DisplayName("Test add(Object); given Comparator compare(Object, Object) return minus one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean LimitedInMemorySortedIterable.add(Object)"})
  void testAdd_givenComparatorCompareReturnMinusOne() {
    // Arrange
    Comparator<Object> comparator = mock(Comparator.class);
    when(comparator.compare(Mockito.<Object>any(), Mockito.<Object>any())).thenReturn(-1);

    LimitedInMemorySortedIterable<Object> limitedInMemorySortedIterable = new LimitedInMemorySortedIterable<>(
        comparator, 1);
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
   * <ul>
   *   <li>Given {@link Comparator} {@link Comparator#compare(Object, Object)} return one.</li>
   *   <li>When {@code 42}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LimitedInMemorySortedIterable#add(Object)}
   */
  @Test
  @DisplayName("Test add(Object); given Comparator compare(Object, Object) return one; when '42'; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean LimitedInMemorySortedIterable.add(Object)"})
  void testAdd_givenComparatorCompareReturnOne_when42_thenReturnTrue() {
    // Arrange
    Comparator<Object> comparator = mock(Comparator.class);
    when(comparator.compare(Mockito.<Object>any(), Mockito.<Object>any())).thenReturn(1);

    LimitedInMemorySortedIterable<Object> limitedInMemorySortedIterable = new LimitedInMemorySortedIterable<>(
        comparator, 1, true);
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
   * <ul>
   *   <li>Given {@link LimitedInMemorySortedIterable#LimitedInMemorySortedIterable(Comparator, Integer)} with {@link Comparator} and limit is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link LimitedInMemorySortedIterable#add(Object)}
   */
  @Test
  @DisplayName("Test add(Object); given LimitedInMemorySortedIterable(Comparator, Integer) with Comparator and limit is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean LimitedInMemorySortedIterable.add(Object)"})
  void testAdd_givenLimitedInMemorySortedIterableWithComparatorAndLimitIsOne() {
    // Arrange
    Comparator<Object> comparator = mock(Comparator.class);
    when(comparator.compare(Mockito.<Object>any(), Mockito.<Object>any())).thenReturn(1);
    LimitedInMemorySortedIterable<Object> limitedInMemorySortedIterable = new LimitedInMemorySortedIterable<>(
        comparator, 1);

    // Act
    boolean actualAddResult = limitedInMemorySortedIterable.add("42");

    // Assert
    verify(comparator).compare(isA(Object.class), isA(Object.class));
    assertEquals(1, limitedInMemorySortedIterable.size());
    assertTrue(actualAddResult);
  }

  /**
   * Test {@link LimitedInMemorySortedIterable#add(Object)}.
   * <ul>
   *   <li>Then {@link LimitedInMemorySortedIterable#LimitedInMemorySortedIterable(Comparator)} with {@link Comparator} size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link LimitedInMemorySortedIterable#add(Object)}
   */
  @Test
  @DisplayName("Test add(Object); then LimitedInMemorySortedIterable(Comparator) with Comparator size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean LimitedInMemorySortedIterable.add(Object)"})
  void testAdd_thenLimitedInMemorySortedIterableWithComparatorSizeIsOne() {
    // Arrange
    Comparator<Object> comparator = mock(Comparator.class);
    when(comparator.compare(Mockito.<Object>any(), Mockito.<Object>any())).thenReturn(1);
    LimitedInMemorySortedIterable<Object> limitedInMemorySortedIterable = new LimitedInMemorySortedIterable<>(
        comparator);

    // Act
    boolean actualAddResult = limitedInMemorySortedIterable.add("42");

    // Assert
    verify(comparator).compare(isA(Object.class), isA(Object.class));
    assertEquals(1, limitedInMemorySortedIterable.size());
    assertTrue(actualAddResult);
  }

  /**
   * Test {@link LimitedInMemorySortedIterable#add(Object)}.
   * <ul>
   *   <li>Then {@link LimitedInMemorySortedIterable#LimitedInMemorySortedIterable(Comparator)} with {@link Comparator} size is three.</li>
   * </ul>
   * <p>
   * Method under test: {@link LimitedInMemorySortedIterable#add(Object)}
   */
  @Test
  @DisplayName("Test add(Object); then LimitedInMemorySortedIterable(Comparator) with Comparator size is three")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean LimitedInMemorySortedIterable.add(Object)"})
  void testAdd_thenLimitedInMemorySortedIterableWithComparatorSizeIsThree() {
    // Arrange
    new IllegalArgumentException("foo");
    Comparator<Object> comparator = mock(Comparator.class);
    when(comparator.compare(Mockito.<Object>any(), Mockito.<Object>any())).thenReturn(0);

    LimitedInMemorySortedIterable<Object> limitedInMemorySortedIterable = new LimitedInMemorySortedIterable<>(
        comparator);
    limitedInMemorySortedIterable.add("42");
    limitedInMemorySortedIterable.add("42");

    // Act
    boolean actualAddResult = limitedInMemorySortedIterable.add("42");

    // Assert
    verify(comparator, atLeast(1)).compare(isA(Object.class), isA(Object.class));
    assertEquals(3, limitedInMemorySortedIterable.size());
    assertTrue(actualAddResult);
  }

  /**
   * Test {@link LimitedInMemorySortedIterable#add(Object)}.
   * <ul>
   *   <li>Then {@link LimitedInMemorySortedIterable#LimitedInMemorySortedIterable(Comparator)} with {@link Comparator} size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link LimitedInMemorySortedIterable#add(Object)}
   */
  @Test
  @DisplayName("Test add(Object); then LimitedInMemorySortedIterable(Comparator) with Comparator size is two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean LimitedInMemorySortedIterable.add(Object)"})
  void testAdd_thenLimitedInMemorySortedIterableWithComparatorSizeIsTwo() {
    // Arrange
    Comparator<Object> comparator = mock(Comparator.class);
    when(comparator.compare(Mockito.<Object>any(), Mockito.<Object>any())).thenReturn(0);

    LimitedInMemorySortedIterable<Object> limitedInMemorySortedIterable = new LimitedInMemorySortedIterable<>(
        comparator);
    limitedInMemorySortedIterable.add("42");

    // Act
    boolean actualAddResult = limitedInMemorySortedIterable.add("42");

    // Assert
    verify(comparator, atLeast(1)).compare(isA(Object.class), isA(Object.class));
    assertEquals(2, limitedInMemorySortedIterable.size());
    assertTrue(actualAddResult);
  }

  /**
   * Test {@link LimitedInMemorySortedIterable#add(Object)}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LimitedInMemorySortedIterable#add(Object)}
   */
  @Test
  @DisplayName("Test add(Object); when 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean LimitedInMemorySortedIterable.add(Object)"})
  void testAdd_whenNull() {
    // Arrange
    new IllegalArgumentException("foo");
    Comparator<Object> comparator = mock(Comparator.class);
    when(comparator.compare(Mockito.<Object>any(), Mockito.<Object>any())).thenReturn(0);

    LimitedInMemorySortedIterable<Object> limitedInMemorySortedIterable = new LimitedInMemorySortedIterable<>(
        comparator, 1, true);
    limitedInMemorySortedIterable.add(new OneOrMore<>());
    limitedInMemorySortedIterable.add("42");

    // Act
    boolean actualAddResult = limitedInMemorySortedIterable.add(null);

    // Assert
    verify(comparator, atLeast(1)).compare(Mockito.<Object>any(), Mockito.<Object>any());
    assertEquals(1, limitedInMemorySortedIterable.size());
    assertFalse(actualAddResult);
  }

  /**
   * Test {@link LimitedInMemorySortedIterable#add(Object)}.
   * <ul>
   *   <li>When {@link OneOrMore#OneOrMore()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LimitedInMemorySortedIterable#add(Object)}
   */
  @Test
  @DisplayName("Test add(Object); when OneOrMore()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean LimitedInMemorySortedIterable.add(Object)"})
  void testAdd_whenOneOrMore() {
    // Arrange
    new IllegalArgumentException("foo");
    Comparator<Object> comparator = mock(Comparator.class);
    when(comparator.compare(Mockito.<Object>any(), Mockito.<Object>any())).thenReturn(0);

    LimitedInMemorySortedIterable<Object> limitedInMemorySortedIterable = new LimitedInMemorySortedIterable<>(
        comparator, 1, true);
    limitedInMemorySortedIterable.add(new OneOrMore<>());
    limitedInMemorySortedIterable.add("42");

    // Act
    boolean actualAddResult = limitedInMemorySortedIterable.add(new OneOrMore<>());

    // Assert
    verify(comparator, atLeast(1)).compare(Mockito.<Object>any(), Mockito.<Object>any());
    assertEquals(1, limitedInMemorySortedIterable.size());
    assertFalse(actualAddResult);
  }

  /**
   * Test {@link LimitedInMemorySortedIterable#add(Object)}.
   * <ul>
   *   <li>When {@link OneOrMore#OneOrMore(boolean, Object)} with deduplicate is {@code true} and {@code Item}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LimitedInMemorySortedIterable#add(Object)}
   */
  @Test
  @DisplayName("Test add(Object); when OneOrMore(boolean, Object) with deduplicate is 'true' and 'Item'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean LimitedInMemorySortedIterable.add(Object)"})
  void testAdd_whenOneOrMoreWithDeduplicateIsTrueAndItem() {
    // Arrange
    new IllegalArgumentException("foo");
    Comparator<Object> comparator = mock(Comparator.class);
    when(comparator.compare(Mockito.<Object>any(), Mockito.<Object>any())).thenReturn(0);

    LimitedInMemorySortedIterable<Object> limitedInMemorySortedIterable = new LimitedInMemorySortedIterable<>(
        comparator, 1, true);
    limitedInMemorySortedIterable.add(new OneOrMore<>());
    limitedInMemorySortedIterable.add("42");

    // Act
    boolean actualAddResult = limitedInMemorySortedIterable.add(new OneOrMore<>(true, "Item"));

    // Assert
    verify(comparator, atLeast(1)).compare(Mockito.<Object>any(), Mockito.<Object>any());
    assertEquals(1, limitedInMemorySortedIterable.size());
    assertFalse(actualAddResult);
  }

  /**
   * Test {@link LimitedInMemorySortedIterable#addAll(Iterable)}.
   * <p>
   * Method under test: {@link LimitedInMemorySortedIterable#addAll(Iterable)}
   */
  @Test
  @DisplayName("Test addAll(Iterable)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean LimitedInMemorySortedIterable.addAll(Iterable)"})
  void testAddAll() {
    // Arrange
    Comparator<Object> comparator = mock(Comparator.class);
    when(comparator.compare(Mockito.<Object>any(), Mockito.<Object>any())).thenReturn(1);
    LimitedInMemorySortedIterable<Object> limitedInMemorySortedIterable = new LimitedInMemorySortedIterable<>(
        comparator, 1, true);

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
   * <p>
   * Method under test: {@link LimitedInMemorySortedIterable#addAll(Iterable)}
   */
  @Test
  @DisplayName("Test addAll(Iterable)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean LimitedInMemorySortedIterable.addAll(Iterable)"})
  void testAddAll2() {
    // Arrange
    Comparator<Object> comparator = mock(Comparator.class);
    when(comparator.compare(Mockito.<Object>any(), Mockito.<Object>any())).thenReturn(1);

    LimitedInMemorySortedIterable<Object> limitedInMemorySortedIterable = new LimitedInMemorySortedIterable<>(
        comparator, 1, true);
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
   * <p>
   * Method under test: {@link LimitedInMemorySortedIterable#addAll(Iterable)}
   */
  @Test
  @DisplayName("Test addAll(Iterable)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean LimitedInMemorySortedIterable.addAll(Iterable)"})
  void testAddAll3() {
    // Arrange
    new IllegalArgumentException("foo");
    Comparator<Object> comparator = mock(Comparator.class);
    when(comparator.compare(Mockito.<Object>any(), Mockito.<Object>any())).thenReturn(0);

    LimitedInMemorySortedIterable<Object> limitedInMemorySortedIterable = new LimitedInMemorySortedIterable<>(
        comparator, 1, true);
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
   * <p>
   * Method under test: {@link LimitedInMemorySortedIterable#addAll(Iterable)}
   */
  @Test
  @DisplayName("Test addAll(Iterable)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean LimitedInMemorySortedIterable.addAll(Iterable)"})
  void testAddAll4() {
    // Arrange
    new IllegalArgumentException("foo");
    Comparator<Object> comparator = mock(Comparator.class);
    when(comparator.compare(Mockito.<Object>any(), Mockito.<Object>any())).thenReturn(0);

    LimitedInMemorySortedIterable<Object> limitedInMemorySortedIterable = new LimitedInMemorySortedIterable<>(
        comparator, 1, true);
    limitedInMemorySortedIterable.add(2);

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
   * <p>
   * Method under test: {@link LimitedInMemorySortedIterable#addAll(Iterable)}
   */
  @Test
  @DisplayName("Test addAll(Iterable)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean LimitedInMemorySortedIterable.addAll(Iterable)"})
  void testAddAll5() {
    // Arrange
    new IllegalArgumentException("foo");
    Comparator<Object> comparator = mock(Comparator.class);
    when(comparator.compare(Mockito.<Object>any(), Mockito.<Object>any())).thenReturn(0);

    LimitedInMemorySortedIterable<Object> limitedInMemorySortedIterable = new LimitedInMemorySortedIterable<>(
        comparator, 1, true);
    limitedInMemorySortedIterable.add(new OneOrMore<>());

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
   * <p>
   * Method under test: {@link LimitedInMemorySortedIterable#addAll(Iterable)}
   */
  @Test
  @DisplayName("Test addAll(Iterable)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean LimitedInMemorySortedIterable.addAll(Iterable)"})
  void testAddAll6() {
    // Arrange
    new IllegalArgumentException("foo");
    Comparator<Object> comparator = mock(Comparator.class);
    when(comparator.compare(Mockito.<Object>any(), Mockito.<Object>any())).thenReturn(0);

    LimitedInMemorySortedIterable<Object> limitedInMemorySortedIterable = new LimitedInMemorySortedIterable<>(
        comparator, 1, true);
    limitedInMemorySortedIterable.add(null);

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
   * <p>
   * Method under test: {@link LimitedInMemorySortedIterable#addAll(Iterable)}
   */
  @Test
  @DisplayName("Test addAll(Iterable)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean LimitedInMemorySortedIterable.addAll(Iterable)"})
  void testAddAll7() {
    // Arrange
    new IllegalArgumentException("foo");
    Comparator<Object> comparator = mock(Comparator.class);
    when(comparator.compare(Mockito.<Object>any(), Mockito.<Object>any())).thenReturn(0);

    LimitedInMemorySortedIterable<Object> limitedInMemorySortedIterable = new LimitedInMemorySortedIterable<>(
        comparator, 17, true);
    limitedInMemorySortedIterable.add(2);

    ArrayList<Object> items = new ArrayList<>();
    items.add("42");

    // Act
    boolean actualAddAllResult = limitedInMemorySortedIterable.addAll(items);

    // Assert
    verify(comparator, atLeast(1)).compare(Mockito.<Object>any(), isA(Object.class));
    assertEquals(2, limitedInMemorySortedIterable.size());
    assertTrue(actualAddAllResult);
  }

  /**
   * Test {@link LimitedInMemorySortedIterable#addAll(Iterable)}.
   * <p>
   * Method under test: {@link LimitedInMemorySortedIterable#addAll(Iterable)}
   */
  @Test
  @DisplayName("Test addAll(Iterable)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean LimitedInMemorySortedIterable.addAll(Iterable)"})
  void testAddAll8() {
    // Arrange
    new IllegalArgumentException("foo");
    Comparator<Object> comparator = mock(Comparator.class);
    when(comparator.compare(Mockito.<Object>any(), Mockito.<Object>any())).thenReturn(0);

    LimitedInMemorySortedIterable<Object> limitedInMemorySortedIterable = new LimitedInMemorySortedIterable<>(
        comparator, 17, true);
    limitedInMemorySortedIterable.add(new OneOrMore<>());

    ArrayList<Object> items = new ArrayList<>();
    items.add("42");

    // Act
    boolean actualAddAllResult = limitedInMemorySortedIterable.addAll(items);

    // Assert
    verify(comparator, atLeast(1)).compare(Mockito.<Object>any(), isA(Object.class));
    assertEquals(2, limitedInMemorySortedIterable.size());
    assertTrue(actualAddAllResult);
  }

  /**
   * Test {@link LimitedInMemorySortedIterable#addAll(Iterable)}.
   * <p>
   * Method under test: {@link LimitedInMemorySortedIterable#addAll(Iterable)}
   */
  @Test
  @DisplayName("Test addAll(Iterable)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean LimitedInMemorySortedIterable.addAll(Iterable)"})
  void testAddAll9() {
    // Arrange
    new IllegalArgumentException("foo");
    Comparator<Object> comparator = mock(Comparator.class);
    when(comparator.compare(Mockito.<Object>any(), Mockito.<Object>any())).thenReturn(1);

    LimitedInMemorySortedIterable<Object> limitedInMemorySortedIterable = new LimitedInMemorySortedIterable<>(
        comparator, 1, true);
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
   * <p>
   * Method under test: {@link LimitedInMemorySortedIterable#addAll(Iterable)}
   */
  @Test
  @DisplayName("Test addAll(Iterable)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean LimitedInMemorySortedIterable.addAll(Iterable)"})
  void testAddAll10() {
    // Arrange
    new IllegalArgumentException("foo");
    Comparator<Object> comparator = mock(Comparator.class);
    when(comparator.compare(Mockito.<Object>any(), Mockito.<Object>any())).thenReturn(0);

    LimitedInMemorySortedIterable<Object> limitedInMemorySortedIterable = new LimitedInMemorySortedIterable<>(
        comparator, 17, true);
    limitedInMemorySortedIterable.add(null);

    ArrayList<Object> items = new ArrayList<>();
    items.add("42");

    // Act
    boolean actualAddAllResult = limitedInMemorySortedIterable.addAll(items);

    // Assert
    verify(comparator, atLeast(1)).compare(Mockito.<Object>any(), isNull());
    assertEquals(2, limitedInMemorySortedIterable.size());
    assertTrue(actualAddAllResult);
  }

  /**
   * Test {@link LimitedInMemorySortedIterable#addAll(Iterable)}.
   * <p>
   * Method under test: {@link LimitedInMemorySortedIterable#addAll(Iterable)}
   */
  @Test
  @DisplayName("Test addAll(Iterable)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean LimitedInMemorySortedIterable.addAll(Iterable)"})
  void testAddAll11() {
    // Arrange
    new IllegalArgumentException("foo");
    Comparator<Object> comparator = mock(Comparator.class);
    when(comparator.compare(Mockito.<Object>any(), Mockito.<Object>any())).thenReturn(0);

    LimitedInMemorySortedIterable<Object> limitedInMemorySortedIterable = new LimitedInMemorySortedIterable<>(
        comparator, 17, true);
    limitedInMemorySortedIterable.add("42");
    limitedInMemorySortedIterable.add(2);

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
   * <ul>
   *   <li>Given {@link Comparator} {@link Comparator#compare(Object, Object)} return minus one.</li>
   * </ul>
   * <p>
   * Method under test: {@link LimitedInMemorySortedIterable#addAll(Iterable)}
   */
  @Test
  @DisplayName("Test addAll(Iterable); given Comparator compare(Object, Object) return minus one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean LimitedInMemorySortedIterable.addAll(Iterable)"})
  void testAddAll_givenComparatorCompareReturnMinusOne() {
    // Arrange
    Comparator<Object> comparator = mock(Comparator.class);
    when(comparator.compare(Mockito.<Object>any(), Mockito.<Object>any())).thenReturn(-1);

    LimitedInMemorySortedIterable<Object> limitedInMemorySortedIterable = new LimitedInMemorySortedIterable<>(
        comparator, 1);
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
   * <ul>
   *   <li>Given {@link LimitedInMemorySortedIterable#LimitedInMemorySortedIterable(Comparator, Integer)} with {@link Comparator} and limit is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link LimitedInMemorySortedIterable#addAll(Iterable)}
   */
  @Test
  @DisplayName("Test addAll(Iterable); given LimitedInMemorySortedIterable(Comparator, Integer) with Comparator and limit is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean LimitedInMemorySortedIterable.addAll(Iterable)"})
  void testAddAll_givenLimitedInMemorySortedIterableWithComparatorAndLimitIsOne() {
    // Arrange
    Comparator<Object> comparator = mock(Comparator.class);
    when(comparator.compare(Mockito.<Object>any(), Mockito.<Object>any())).thenReturn(1);
    LimitedInMemorySortedIterable<Object> limitedInMemorySortedIterable = new LimitedInMemorySortedIterable<>(
        comparator, 1);

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
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LimitedInMemorySortedIterable#addAll(Iterable)}
   */
  @Test
  @DisplayName("Test addAll(Iterable); given 'null'; when ArrayList() add 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean LimitedInMemorySortedIterable.addAll(Iterable)"})
  void testAddAll_givenNull_whenArrayListAddNull() {
    // Arrange
    new IllegalArgumentException("foo");
    Comparator<Object> comparator = mock(Comparator.class);
    when(comparator.compare(Mockito.<Object>any(), Mockito.<Object>any())).thenReturn(0);

    LimitedInMemorySortedIterable<Object> limitedInMemorySortedIterable = new LimitedInMemorySortedIterable<>(
        comparator, 1, true);
    limitedInMemorySortedIterable.add(new OneOrMore<>());

    ArrayList<Object> items = new ArrayList<>();
    items.add(null);

    // Act
    boolean actualAddAllResult = limitedInMemorySortedIterable.addAll(items);

    // Assert
    verify(comparator, atLeast(1)).compare(Mockito.<Object>any(), Mockito.<Object>any());
    assertEquals(1, limitedInMemorySortedIterable.size());
    assertFalse(actualAddAllResult);
  }

  /**
   * Test {@link LimitedInMemorySortedIterable#addAll(Iterable)}.
   * <ul>
   *   <li>Given {@link OneOrMore#OneOrMore(boolean, Object)} with deduplicate is {@code true} and {@code Item}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LimitedInMemorySortedIterable#addAll(Iterable)}
   */
  @Test
  @DisplayName("Test addAll(Iterable); given OneOrMore(boolean, Object) with deduplicate is 'true' and 'Item'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean LimitedInMemorySortedIterable.addAll(Iterable)"})
  void testAddAll_givenOneOrMoreWithDeduplicateIsTrueAndItem() {
    // Arrange
    new IllegalArgumentException("foo");
    Comparator<Object> comparator = mock(Comparator.class);
    when(comparator.compare(Mockito.<Object>any(), Mockito.<Object>any())).thenReturn(0);

    LimitedInMemorySortedIterable<Object> limitedInMemorySortedIterable = new LimitedInMemorySortedIterable<>(
        comparator, 1, true);
    limitedInMemorySortedIterable.add(new OneOrMore<>());

    ArrayList<Object> items = new ArrayList<>();
    items.add(new OneOrMore<>(true, "Item"));

    // Act
    boolean actualAddAllResult = limitedInMemorySortedIterable.addAll(items);

    // Assert
    verify(comparator, atLeast(1)).compare(Mockito.<Object>any(), Mockito.<Object>any());
    assertEquals(1, limitedInMemorySortedIterable.size());
    assertFalse(actualAddAllResult);
  }

  /**
   * Test {@link LimitedInMemorySortedIterable#addAll(Iterable)}.
   * <ul>
   *   <li>Given {@link OneOrMore#OneOrMore()}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@link OneOrMore#OneOrMore()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LimitedInMemorySortedIterable#addAll(Iterable)}
   */
  @Test
  @DisplayName("Test addAll(Iterable); given OneOrMore(); when ArrayList() add OneOrMore()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean LimitedInMemorySortedIterable.addAll(Iterable)"})
  void testAddAll_givenOneOrMore_whenArrayListAddOneOrMore() {
    // Arrange
    new IllegalArgumentException("foo");
    Comparator<Object> comparator = mock(Comparator.class);
    when(comparator.compare(Mockito.<Object>any(), Mockito.<Object>any())).thenReturn(0);

    LimitedInMemorySortedIterable<Object> limitedInMemorySortedIterable = new LimitedInMemorySortedIterable<>(
        comparator, 1, true);
    limitedInMemorySortedIterable.add(new OneOrMore<>());

    ArrayList<Object> items = new ArrayList<>();
    items.add(new OneOrMore<>());

    // Act
    boolean actualAddAllResult = limitedInMemorySortedIterable.addAll(items);

    // Assert
    verify(comparator, atLeast(1)).compare(isA(Object.class), isA(Object.class));
    assertEquals(1, limitedInMemorySortedIterable.size());
    assertFalse(actualAddAllResult);
  }

  /**
   * Test {@link LimitedInMemorySortedIterable#addAll(Iterable)}.
   * <ul>
   *   <li>Then {@link LimitedInMemorySortedIterable#LimitedInMemorySortedIterable(Comparator)} with {@link Comparator} size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link LimitedInMemorySortedIterable#addAll(Iterable)}
   */
  @Test
  @DisplayName("Test addAll(Iterable); then LimitedInMemorySortedIterable(Comparator) with Comparator size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean LimitedInMemorySortedIterable.addAll(Iterable)"})
  void testAddAll_thenLimitedInMemorySortedIterableWithComparatorSizeIsOne() {
    // Arrange
    Comparator<Object> comparator = mock(Comparator.class);
    when(comparator.compare(Mockito.<Object>any(), Mockito.<Object>any())).thenReturn(1);
    LimitedInMemorySortedIterable<Object> limitedInMemorySortedIterable = new LimitedInMemorySortedIterable<>(
        comparator);

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
   * <ul>
   *   <li>Then {@link LimitedInMemorySortedIterable#LimitedInMemorySortedIterable(Comparator)} with {@link Comparator} size is three.</li>
   * </ul>
   * <p>
   * Method under test: {@link LimitedInMemorySortedIterable#addAll(Iterable)}
   */
  @Test
  @DisplayName("Test addAll(Iterable); then LimitedInMemorySortedIterable(Comparator) with Comparator size is three")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean LimitedInMemorySortedIterable.addAll(Iterable)"})
  void testAddAll_thenLimitedInMemorySortedIterableWithComparatorSizeIsThree() {
    // Arrange
    new IllegalArgumentException("foo");
    Comparator<Object> comparator = mock(Comparator.class);
    when(comparator.compare(Mockito.<Object>any(), Mockito.<Object>any())).thenReturn(0);

    LimitedInMemorySortedIterable<Object> limitedInMemorySortedIterable = new LimitedInMemorySortedIterable<>(
        comparator);
    limitedInMemorySortedIterable.add("42");
    limitedInMemorySortedIterable.add(2);

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
   * <ul>
   *   <li>Then {@link LimitedInMemorySortedIterable#LimitedInMemorySortedIterable(Comparator)} with {@link Comparator} size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link LimitedInMemorySortedIterable#addAll(Iterable)}
   */
  @Test
  @DisplayName("Test addAll(Iterable); then LimitedInMemorySortedIterable(Comparator) with Comparator size is two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean LimitedInMemorySortedIterable.addAll(Iterable)"})
  void testAddAll_thenLimitedInMemorySortedIterableWithComparatorSizeIsTwo() {
    // Arrange
    Comparator<Object> comparator = mock(Comparator.class);
    when(comparator.compare(Mockito.<Object>any(), Mockito.<Object>any())).thenReturn(0);

    LimitedInMemorySortedIterable<Object> limitedInMemorySortedIterable = new LimitedInMemorySortedIterable<>(
        comparator);
    limitedInMemorySortedIterable.add("42");

    ArrayList<Object> items = new ArrayList<>();
    items.add("42");

    // Act
    boolean actualAddAllResult = limitedInMemorySortedIterable.addAll(items);

    // Assert
    verify(comparator, atLeast(1)).compare(isA(Object.class), isA(Object.class));
    assertEquals(2, limitedInMemorySortedIterable.size());
    assertTrue(actualAddAllResult);
  }

  /**
   * Test {@link LimitedInMemorySortedIterable#addAll(Iterable)}.
   * <ul>
   *   <li>Then {@link LimitedInMemorySortedIterable#LimitedInMemorySortedIterable(Comparator)} with {@link Comparator} size is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link LimitedInMemorySortedIterable#addAll(Iterable)}
   */
  @Test
  @DisplayName("Test addAll(Iterable); then LimitedInMemorySortedIterable(Comparator) with Comparator size is zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean LimitedInMemorySortedIterable.addAll(Iterable)"})
  void testAddAll_thenLimitedInMemorySortedIterableWithComparatorSizeIsZero() {
    // Arrange
    LimitedInMemorySortedIterable<Object> limitedInMemorySortedIterable = new LimitedInMemorySortedIterable<>(
        mock(Comparator.class));

    // Act
    boolean actualAddAllResult = limitedInMemorySortedIterable.addAll(new ArrayList<>());

    // Assert
    assertEquals(0, limitedInMemorySortedIterable.size());
    assertFalse(actualAddAllResult);
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link LimitedInMemorySortedIterable#toString()}
   *   <li>{@link LimitedInMemorySortedIterable#size()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int LimitedInMemorySortedIterable.size()", "String LimitedInMemorySortedIterable.toString()"})
  void testGettersAndSetters() {
    // Arrange
    LimitedInMemorySortedIterable<Object> limitedInMemorySortedIterable = new LimitedInMemorySortedIterable<>(
        mock(Comparator.class));

    // Act
    String actualToStringResult = limitedInMemorySortedIterable.toString();

    // Assert
    assertEquals("LimitedInMemorySortedIterable[size=0,deduplicate=false,backingMap={}]", actualToStringResult);
    assertEquals(0, limitedInMemorySortedIterable.size());
  }

  /**
   * Test {@link LimitedInMemorySortedIterable#iterator()}.
   * <ul>
   *   <li>Given {@link Comparator} {@link Comparator#compare(Object, Object)} return one.</li>
   *   <li>Then return {@link ChainedIterator}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LimitedInMemorySortedIterable#iterator()}
   */
  @Test
  @DisplayName("Test iterator(); given Comparator compare(Object, Object) return one; then return ChainedIterator")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Iterator LimitedInMemorySortedIterable.iterator()"})
  void testIterator_givenComparatorCompareReturnOne_thenReturnChainedIterator() {
    // Arrange
    Comparator<Object> comparator = mock(Comparator.class);
    when(comparator.compare(Mockito.<Object>any(), Mockito.<Object>any())).thenReturn(1);

    LimitedInMemorySortedIterable<Object> limitedInMemorySortedIterable = new LimitedInMemorySortedIterable<>(
        comparator);
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
   * <ul>
   *   <li>Given {@link LimitedInMemorySortedIterable#LimitedInMemorySortedIterable(Comparator)} with {@link Comparator}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LimitedInMemorySortedIterable#iterator()}
   */
  @Test
  @DisplayName("Test iterator(); given LimitedInMemorySortedIterable(Comparator) with Comparator")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Iterator LimitedInMemorySortedIterable.iterator()"})
  void testIterator_givenLimitedInMemorySortedIterableWithComparator() {
    // Arrange
    LimitedInMemorySortedIterable<Object> limitedInMemorySortedIterable = new LimitedInMemorySortedIterable<>(
        mock(Comparator.class));

    // Act and Assert
    assertFalse(limitedInMemorySortedIterable.iterator().hasNext());
  }

  /**
   * Test {@link LimitedInMemorySortedIterable#equals(Object)}, and {@link LimitedInMemorySortedIterable#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link LimitedInMemorySortedIterable#equals(Object)}
   *   <li>{@link LimitedInMemorySortedIterable#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean LimitedInMemorySortedIterable.equals(Object)",
      "int LimitedInMemorySortedIterable.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    LimitedInMemorySortedIterable<Object> limitedInMemorySortedIterable = new LimitedInMemorySortedIterable<>(
        mock(Comparator.class));
    LimitedInMemorySortedIterable<Object> limitedInMemorySortedIterable2 = new LimitedInMemorySortedIterable<>(
        mock(Comparator.class));

    // Act and Assert
    assertEquals(limitedInMemorySortedIterable, limitedInMemorySortedIterable2);
    int expectedHashCodeResult = limitedInMemorySortedIterable.hashCode();
    assertEquals(expectedHashCodeResult, limitedInMemorySortedIterable2.hashCode());
  }

  /**
   * Test {@link LimitedInMemorySortedIterable#equals(Object)}, and {@link LimitedInMemorySortedIterable#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link LimitedInMemorySortedIterable#equals(Object)}
   *   <li>{@link LimitedInMemorySortedIterable#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean LimitedInMemorySortedIterable.equals(Object)",
      "int LimitedInMemorySortedIterable.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    LimitedInMemorySortedIterable<Object> limitedInMemorySortedIterable = new LimitedInMemorySortedIterable<>(
        mock(Comparator.class));

    // Act and Assert
    assertEquals(limitedInMemorySortedIterable, limitedInMemorySortedIterable);
    int expectedHashCodeResult = limitedInMemorySortedIterable.hashCode();
    assertEquals(expectedHashCodeResult, limitedInMemorySortedIterable.hashCode());
  }

  /**
   * Test {@link LimitedInMemorySortedIterable#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link LimitedInMemorySortedIterable#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean LimitedInMemorySortedIterable.equals(Object)",
      "int LimitedInMemorySortedIterable.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    LimitedInMemorySortedIterable<Object> limitedInMemorySortedIterable = new LimitedInMemorySortedIterable<>(
        mock(Comparator.class), 1);

    // Act and Assert
    assertNotEquals(limitedInMemorySortedIterable, new LimitedInMemorySortedIterable<>(mock(Comparator.class)));
  }

  /**
   * Test {@link LimitedInMemorySortedIterable#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link LimitedInMemorySortedIterable#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean LimitedInMemorySortedIterable.equals(Object)",
      "int LimitedInMemorySortedIterable.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    LimitedInMemorySortedIterable<Object> limitedInMemorySortedIterable = new LimitedInMemorySortedIterable<>(
        mock(Comparator.class));

    // Act and Assert
    assertNotEquals(limitedInMemorySortedIterable, null);
  }

  /**
   * Test {@link LimitedInMemorySortedIterable#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link LimitedInMemorySortedIterable#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean LimitedInMemorySortedIterable.equals(Object)",
      "int LimitedInMemorySortedIterable.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    LimitedInMemorySortedIterable<Object> limitedInMemorySortedIterable = new LimitedInMemorySortedIterable<>(
        mock(Comparator.class));

    // Act and Assert
    assertNotEquals(limitedInMemorySortedIterable, "Different type to LimitedInMemorySortedIterable");
  }
}
