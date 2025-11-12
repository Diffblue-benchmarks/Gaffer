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
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import uk.gov.gchq.gaffer.commonutil.OneOrMore;
import uk.gov.gchq.koryphe.iterable.ChainedIterator;

class LimitedInMemorySortedIterableDiffblueTest {
  /**
   * Method under test: {@link LimitedInMemorySortedIterable#add(Object)}
   */
  @Test
  void testAdd() {
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
   * Method under test: {@link LimitedInMemorySortedIterable#add(Object)}
   */
  @Test
  void testAdd2() {
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
   * Method under test: {@link LimitedInMemorySortedIterable#add(Object)}
   */
  @Test
  void testAdd3() {
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
   * Method under test: {@link LimitedInMemorySortedIterable#add(Object)}
   */
  @Test
  void testAdd4() {
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
   * Method under test: {@link LimitedInMemorySortedIterable#add(Object)}
   */
  @Test
  void testAdd5() {
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
   * Method under test: {@link LimitedInMemorySortedIterable#add(Object)}
   */
  @Test
  void testAdd6() {
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
   * Method under test: {@link LimitedInMemorySortedIterable#add(Object)}
   */
  @Test
  void testAdd7() {
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
   * Method under test: {@link LimitedInMemorySortedIterable#add(Object)}
   */
  @Test
  void testAdd8() {
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
   * Method under test: {@link LimitedInMemorySortedIterable#add(Object)}
   */
  @Test
  void testAdd9() {
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
   * Method under test: {@link LimitedInMemorySortedIterable#add(Object)}
   */
  @Test
  void testAdd10() {
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
   * Method under test: {@link LimitedInMemorySortedIterable#add(Object)}
   */
  @Test
  void testAdd11() {
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
   * Method under test: {@link LimitedInMemorySortedIterable#add(Object)}
   */
  @Test
  void testAdd12() {
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
    assertFalse(actualAddResult);
  }

  /**
   * Method under test: {@link LimitedInMemorySortedIterable#add(Object)}
   */
  @Test
  void testAdd13() {
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
   * Method under test: {@link LimitedInMemorySortedIterable#add(Object)}
   */
  @Test
  void testAdd14() {
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
   * Method under test: {@link LimitedInMemorySortedIterable#add(Object)}
   */
  @Test
  void testAdd15() {
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
   * Method under test: {@link LimitedInMemorySortedIterable#addAll(Iterable)}
   */
  @Test
  void testAddAll() {
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
   * Method under test: {@link LimitedInMemorySortedIterable#addAll(Iterable)}
   */
  @Test
  void testAddAll2() {
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
   * Method under test: {@link LimitedInMemorySortedIterable#addAll(Iterable)}
   */
  @Test
  void testAddAll3() {
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
   * Method under test: {@link LimitedInMemorySortedIterable#addAll(Iterable)}
   */
  @Test
  void testAddAll4() {
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
   * Method under test: {@link LimitedInMemorySortedIterable#addAll(Iterable)}
   */
  @Test
  void testAddAll5() {
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
   * Method under test: {@link LimitedInMemorySortedIterable#addAll(Iterable)}
   */
  @Test
  void testAddAll6() {
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
   * Method under test: {@link LimitedInMemorySortedIterable#addAll(Iterable)}
   */
  @Test
  void testAddAll7() {
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
   * Method under test: {@link LimitedInMemorySortedIterable#addAll(Iterable)}
   */
  @Test
  void testAddAll8() {
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
   * Method under test: {@link LimitedInMemorySortedIterable#addAll(Iterable)}
   */
  @Test
  void testAddAll9() {
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
   * Method under test: {@link LimitedInMemorySortedIterable#addAll(Iterable)}
   */
  @Test
  void testAddAll10() {
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
   * Method under test: {@link LimitedInMemorySortedIterable#addAll(Iterable)}
   */
  @Test
  void testAddAll11() {
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
   * Method under test: {@link LimitedInMemorySortedIterable#addAll(Iterable)}
   */
  @Test
  void testAddAll12() {
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
   * Method under test: {@link LimitedInMemorySortedIterable#addAll(Iterable)}
   */
  @Test
  void testAddAll13() {
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
   * Method under test: {@link LimitedInMemorySortedIterable#addAll(Iterable)}
   */
  @Test
  void testAddAll14() {
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
   * Method under test: {@link LimitedInMemorySortedIterable#addAll(Iterable)}
   */
  @Test
  void testAddAll15() {
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
   * Method under test: {@link LimitedInMemorySortedIterable#addAll(Iterable)}
   */
  @Test
  void testAddAll16() {
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
   * Method under test: {@link LimitedInMemorySortedIterable#addAll(Iterable)}
   */
  @Test
  void testAddAll17() {
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
   * Method under test: {@link LimitedInMemorySortedIterable#addAll(Iterable)}
   */
  @Test
  void testAddAll18() {
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
   * Method under test: {@link LimitedInMemorySortedIterable#addAll(Iterable)}
   */
  @Test
  void testAddAll19() {
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
   * Method under test: {@link LimitedInMemorySortedIterable#addAll(Iterable)}
   */
  @Test
  void testAddAll20() {
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
   * Method under test: {@link LimitedInMemorySortedIterable#iterator()}
   */
  @Test
  void testIterator() {
    // Arrange
    LimitedInMemorySortedIterable<Object> limitedInMemorySortedIterable = new LimitedInMemorySortedIterable<>(
        mock(Comparator.class));

    // Act and Assert
    assertFalse(limitedInMemorySortedIterable.iterator().hasNext());
  }

  /**
   * Method under test: {@link LimitedInMemorySortedIterable#iterator()}
   */
  @Test
  void testIterator2() {
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
   * Methods under test:
   * <ul>
   *   <li>{@link LimitedInMemorySortedIterable#equals(Object)}
   *   <li>{@link LimitedInMemorySortedIterable#hashCode()}
   * </ul>
   */
  @Test
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
   * Methods under test:
   * <ul>
   *   <li>{@link LimitedInMemorySortedIterable#equals(Object)}
   *   <li>{@link LimitedInMemorySortedIterable#hashCode()}
   * </ul>
   */
  @Test
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
   * Method under test: {@link LimitedInMemorySortedIterable#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    LimitedInMemorySortedIterable<Object> limitedInMemorySortedIterable = new LimitedInMemorySortedIterable<>(
        mock(Comparator.class), 1);

    // Act and Assert
    assertNotEquals(limitedInMemorySortedIterable, new LimitedInMemorySortedIterable<>(mock(Comparator.class)));
  }

  /**
   * Method under test: {@link LimitedInMemorySortedIterable#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    LimitedInMemorySortedIterable<Object> limitedInMemorySortedIterable = new LimitedInMemorySortedIterable<>(
        mock(Comparator.class));

    // Act and Assert
    assertNotEquals(limitedInMemorySortedIterable, null);
  }

  /**
   * Method under test: {@link LimitedInMemorySortedIterable#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    LimitedInMemorySortedIterable<Object> limitedInMemorySortedIterable = new LimitedInMemorySortedIterable<>(
        mock(Comparator.class));

    // Act and Assert
    assertNotEquals(limitedInMemorySortedIterable, "Different type to LimitedInMemorySortedIterable");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link LimitedInMemorySortedIterable#toString()}
   *   <li>{@link LimitedInMemorySortedIterable#size()}
   * </ul>
   */
  @Test
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
   * Method under test:
   * {@link LimitedInMemorySortedIterable#LimitedInMemorySortedIterable(Comparator)}
   */
  @Test
  void testNewLimitedInMemorySortedIterable() {
    // Arrange and Act
    LimitedInMemorySortedIterable<Object> actualLimitedInMemorySortedIterable = new LimitedInMemorySortedIterable<>(
        mock(Comparator.class));

    // Assert
    assertEquals(0, actualLimitedInMemorySortedIterable.size());
  }

  /**
   * Method under test:
   * {@link LimitedInMemorySortedIterable#LimitedInMemorySortedIterable(Comparator)}
   */
  @Test
  void testNewLimitedInMemorySortedIterable2() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> new LimitedInMemorySortedIterable<>(null));
  }

  /**
   * Method under test:
   * {@link LimitedInMemorySortedIterable#LimitedInMemorySortedIterable(Comparator, Integer)}
   */
  @Test
  void testNewLimitedInMemorySortedIterable3() {
    // Arrange and Act
    LimitedInMemorySortedIterable<Object> actualLimitedInMemorySortedIterable = new LimitedInMemorySortedIterable<>(
        mock(Comparator.class), 1);

    // Assert
    assertEquals(0, actualLimitedInMemorySortedIterable.size());
  }

  /**
   * Method under test:
   * {@link LimitedInMemorySortedIterable#LimitedInMemorySortedIterable(Comparator, Integer)}
   */
  @Test
  void testNewLimitedInMemorySortedIterable4() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> new LimitedInMemorySortedIterable<>(mock(Comparator.class), 0));

  }

  /**
   * Method under test:
   * {@link LimitedInMemorySortedIterable#LimitedInMemorySortedIterable(Comparator, Integer)}
   */
  @Test
  void testNewLimitedInMemorySortedIterable5() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> new LimitedInMemorySortedIterable<>(null, 1));

  }

  /**
   * Method under test:
   * {@link LimitedInMemorySortedIterable#LimitedInMemorySortedIterable(Comparator, Integer, boolean)}
   */
  @Test
  void testNewLimitedInMemorySortedIterable6() {
    // Arrange and Act
    LimitedInMemorySortedIterable<Object> actualLimitedInMemorySortedIterable = new LimitedInMemorySortedIterable<>(
        mock(Comparator.class), 1, true);

    // Assert
    assertEquals(0, actualLimitedInMemorySortedIterable.size());
  }

  /**
   * Method under test:
   * {@link LimitedInMemorySortedIterable#LimitedInMemorySortedIterable(Comparator, Integer, boolean)}
   */
  @Test
  void testNewLimitedInMemorySortedIterable7() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> new LimitedInMemorySortedIterable<>(mock(Comparator.class), 0, true));

  }

  /**
   * Method under test:
   * {@link LimitedInMemorySortedIterable#LimitedInMemorySortedIterable(Comparator, Integer, boolean)}
   */
  @Test
  void testNewLimitedInMemorySortedIterable8() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> new LimitedInMemorySortedIterable<>(null, 1, true));

  }
}
