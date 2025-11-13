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

package uk.gov.gchq.gaffer.store.operation.handler.compare;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.nimbusds.jose.shaded.gson.internal.NonNullElementWrapperList;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import uk.gov.gchq.gaffer.data.element.Edge;
import uk.gov.gchq.gaffer.data.element.Element;
import uk.gov.gchq.gaffer.data.element.comparison.ElementPropertyComparator;
import uk.gov.gchq.gaffer.operation.OperationException;
import uk.gov.gchq.gaffer.operation.impl.compare.Min;
import uk.gov.gchq.gaffer.store.Context;
import uk.gov.gchq.gaffer.store.Store;
import uk.gov.gchq.gaffer.store.operation.handler.TestAddToGraphLibraryImpl;

class MinHandlerDiffblueTest {
  /**
   * Test {@link MinHandler#doOperation(Min, Context, Store)} with {@code Min}, {@code Context}, {@code Store}.
   * <p>
   * Method under test: {@link MinHandler#doOperation(Min, Context, Store)}
   */
  @Test
  @DisplayName("Test doOperation(Min, Context, Store) with 'Min', 'Context', 'Store'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Element MinHandler.doOperation(Min, Context, Store)"})
  void testDoOperationWithMinContextStore() throws OperationException {
    // Arrange
    MinHandler minHandler = new MinHandler();

    ElementPropertyComparator elementPropertyComparator = new ElementPropertyComparator();
    elementPropertyComparator.setComparator(null);
    elementPropertyComparator.setReversed(false);
    elementPropertyComparator.setGroups(new HashSet<>());

    ArrayList<Comparator<Element>> comparators = new ArrayList<>();
    comparators.add(elementPropertyComparator);

    Min operation = new Min();
    operation.setInput(new ArrayList<>());
    operation.setComparators(comparators);
    Context context = new Context();

    // Act and Assert
    assertNull(minHandler.doOperation(operation, context, new TestAddToGraphLibraryImpl()));
  }

  /**
   * Test {@link MinHandler#doOperation(Min, Context, Store)} with {@code Min}, {@code Context}, {@code Store}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link Comparator}.</li>
   *   <li>Then calls {@link NonNullElementWrapperList#get(int)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MinHandler#doOperation(Min, Context, Store)}
   */
  @Test
  @DisplayName("Test doOperation(Min, Context, Store) with 'Min', 'Context', 'Store'; given ArrayList() add Comparator; then calls get(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Element MinHandler.doOperation(Min, Context, Store)"})
  void testDoOperationWithMinContextStore_givenArrayListAddComparator_thenCallsGet() throws OperationException {
    // Arrange
    MinHandler minHandler = new MinHandler();

    ArrayList<Comparator<Element>> comparatorList = new ArrayList<>();
    comparatorList.add(mock(Comparator.class));
    Iterator<Comparator<Element>> iteratorResult = comparatorList.iterator();
    NonNullElementWrapperList<Comparator<Element>> comparators = mock(NonNullElementWrapperList.class);
    when(comparators.get(anyInt())).thenReturn(mock(Comparator.class));
    when(comparators.isEmpty()).thenReturn(false);
    when(comparators.size()).thenReturn(1);
    when(comparators.iterator()).thenReturn(iteratorResult);

    Min operation = new Min();
    operation.setInput(new ArrayList<>());
    operation.setComparators(comparators);
    Context context = new Context();

    // Act
    Element actualDoOperationResult = minHandler.doOperation(operation, context, new TestAddToGraphLibraryImpl());

    // Assert
    verify(comparators).get(eq(0));
    verify(comparators).size();
    verify(comparators, atLeast(1)).isEmpty();
    verify(comparators).iterator();
    assertNull(actualDoOperationResult);
  }

  /**
   * Test {@link MinHandler#doOperation(Min, Context, Store)} with {@code Min}, {@code Context}, {@code Store}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@code null}.</li>
   *   <li>Then calls {@link NonNullElementWrapperList#get(int)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MinHandler#doOperation(Min, Context, Store)}
   */
  @Test
  @DisplayName("Test doOperation(Min, Context, Store) with 'Min', 'Context', 'Store'; given ArrayList() add 'null'; then calls get(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Element MinHandler.doOperation(Min, Context, Store)"})
  void testDoOperationWithMinContextStore_givenArrayListAddNull_thenCallsGet() throws OperationException {
    // Arrange
    MinHandler minHandler = new MinHandler();

    ArrayList<Element> input = new ArrayList<>();
    input.add(null);

    ArrayList<Comparator<Element>> comparatorList = new ArrayList<>();
    comparatorList.add(mock(Comparator.class));
    Iterator<Comparator<Element>> iteratorResult = comparatorList.iterator();
    NonNullElementWrapperList<Comparator<Element>> comparators = mock(NonNullElementWrapperList.class);
    when(comparators.get(anyInt())).thenReturn(mock(Comparator.class));
    when(comparators.isEmpty()).thenReturn(false);
    when(comparators.size()).thenReturn(1);
    when(comparators.iterator()).thenReturn(iteratorResult);

    Min operation = new Min();
    operation.setInput(input);
    operation.setComparators(comparators);
    Context context = new Context();

    // Act
    Element actualDoOperationResult = minHandler.doOperation(operation, context, new TestAddToGraphLibraryImpl());

    // Assert
    verify(comparators).get(eq(0));
    verify(comparators).size();
    verify(comparators, atLeast(1)).isEmpty();
    verify(comparators).iterator();
    assertNull(actualDoOperationResult);
  }

  /**
   * Test {@link MinHandler#doOperation(Min, Context, Store)} with {@code Min}, {@code Context}, {@code Store}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.</li>
   *   <li>When {@link Min} (default constructor) Comparators is {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MinHandler#doOperation(Min, Context, Store)}
   */
  @Test
  @DisplayName("Test doOperation(Min, Context, Store) with 'Min', 'Context', 'Store'; given ArrayList(); when Min (default constructor) Comparators is ArrayList()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Element MinHandler.doOperation(Min, Context, Store)"})
  void testDoOperationWithMinContextStore_givenArrayList_whenMinComparatorsIsArrayList() throws OperationException {
    // Arrange
    MinHandler minHandler = new MinHandler();

    Min operation = new Min();
    operation.setInput(new ArrayList<>());
    operation.setComparators(new ArrayList<>());
    Context context = new Context();

    // Act and Assert
    assertNull(minHandler.doOperation(operation, context, new TestAddToGraphLibraryImpl()));
  }

  /**
   * Test {@link MinHandler#doOperation(Min, Context, Store)} with {@code Min}, {@code Context}, {@code Store}.
   * <ul>
   *   <li>Given {@link Comparator} {@link Comparator#compare(Object, Object)} return minus one.</li>
   * </ul>
   * <p>
   * Method under test: {@link MinHandler#doOperation(Min, Context, Store)}
   */
  @Test
  @DisplayName("Test doOperation(Min, Context, Store) with 'Min', 'Context', 'Store'; given Comparator compare(Object, Object) return minus one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Element MinHandler.doOperation(Min, Context, Store)"})
  void testDoOperationWithMinContextStore_givenComparatorCompareReturnMinusOne() throws OperationException {
    // Arrange
    MinHandler minHandler = new MinHandler();

    ArrayList<Element> input = new ArrayList<>();
    Edge edge = new Edge("Group");
    input.add(edge);
    Comparator<Element> comparator = mock(Comparator.class);
    when(comparator.compare(Mockito.<Element>any(), Mockito.<Element>any())).thenReturn(-1);

    ArrayList<Comparator<Element>> comparatorList = new ArrayList<>();
    comparatorList.add(comparator);
    Iterator<Comparator<Element>> iteratorResult = comparatorList.iterator();
    NonNullElementWrapperList<Comparator<Element>> comparators = mock(NonNullElementWrapperList.class);
    when(comparators.get(anyInt())).thenReturn(mock(Comparator.class));
    when(comparators.isEmpty()).thenReturn(false);
    when(comparators.size()).thenReturn(1);
    when(comparators.iterator()).thenReturn(iteratorResult);

    Min operation = new Min();
    operation.setInput(input);
    operation.setComparators(comparators);
    Context context = new Context();

    // Act
    Element actualDoOperationResult = minHandler.doOperation(operation, context, new TestAddToGraphLibraryImpl());

    // Assert
    verify(comparators).get(eq(0));
    verify(comparators).size();
    verify(comparators, atLeast(1)).isEmpty();
    verify(comparators).iterator();
    verify(comparator).compare(isA(Element.class), isA(Element.class));
    assertSame(edge, actualDoOperationResult);
  }

  /**
   * Test {@link MinHandler#doOperation(Min, Context, Store)} with {@code Min}, {@code Context}, {@code Store}.
   * <ul>
   *   <li>Given {@link Comparator} {@link Comparator#compare(Object, Object)} return one.</li>
   * </ul>
   * <p>
   * Method under test: {@link MinHandler#doOperation(Min, Context, Store)}
   */
  @Test
  @DisplayName("Test doOperation(Min, Context, Store) with 'Min', 'Context', 'Store'; given Comparator compare(Object, Object) return one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Element MinHandler.doOperation(Min, Context, Store)"})
  void testDoOperationWithMinContextStore_givenComparatorCompareReturnOne() throws OperationException {
    // Arrange
    MinHandler minHandler = new MinHandler();

    ArrayList<Element> input = new ArrayList<>();
    Edge edge = new Edge("Group");
    input.add(edge);
    Comparator<Element> comparator = mock(Comparator.class);
    when(comparator.compare(Mockito.<Element>any(), Mockito.<Element>any())).thenReturn(1);

    ArrayList<Comparator<Element>> comparatorList = new ArrayList<>();
    comparatorList.add(comparator);
    Iterator<Comparator<Element>> iteratorResult = comparatorList.iterator();
    NonNullElementWrapperList<Comparator<Element>> comparators = mock(NonNullElementWrapperList.class);
    when(comparators.get(anyInt())).thenReturn(mock(Comparator.class));
    when(comparators.isEmpty()).thenReturn(false);
    when(comparators.size()).thenReturn(1);
    when(comparators.iterator()).thenReturn(iteratorResult);

    Min operation = new Min();
    operation.setInput(input);
    operation.setComparators(comparators);
    Context context = new Context();

    // Act
    Element actualDoOperationResult = minHandler.doOperation(operation, context, new TestAddToGraphLibraryImpl());

    // Assert
    verify(comparators).get(eq(0));
    verify(comparators).size();
    verify(comparators, atLeast(1)).isEmpty();
    verify(comparators).iterator();
    verify(comparator).compare(isA(Element.class), isA(Element.class));
    assertSame(edge, actualDoOperationResult);
  }

  /**
   * Test {@link MinHandler#doOperation(Min, Context, Store)} with {@code Min}, {@code Context}, {@code Store}.
   * <ul>
   *   <li>Given {@link Comparator} {@link Comparator#compare(Object, Object)} return one.</li>
   * </ul>
   * <p>
   * Method under test: {@link MinHandler#doOperation(Min, Context, Store)}
   */
  @Test
  @DisplayName("Test doOperation(Min, Context, Store) with 'Min', 'Context', 'Store'; given Comparator compare(Object, Object) return one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Element MinHandler.doOperation(Min, Context, Store)"})
  void testDoOperationWithMinContextStore_givenComparatorCompareReturnOne2() throws OperationException {
    // Arrange
    MinHandler minHandler = new MinHandler();

    ArrayList<Element> input = new ArrayList<>();
    Edge edge = new Edge("Group");
    input.add(edge);
    input.add(new Edge("Group"));
    Comparator<Element> comparator = mock(Comparator.class);
    when(comparator.compare(Mockito.<Element>any(), Mockito.<Element>any())).thenReturn(1);

    ArrayList<Comparator<Element>> comparatorList = new ArrayList<>();
    comparatorList.add(comparator);
    Iterator<Comparator<Element>> iteratorResult = comparatorList.iterator();
    NonNullElementWrapperList<Comparator<Element>> comparators = mock(NonNullElementWrapperList.class);
    when(comparators.get(anyInt())).thenReturn(mock(Comparator.class));
    when(comparators.isEmpty()).thenReturn(false);
    when(comparators.size()).thenReturn(1);
    when(comparators.iterator()).thenReturn(iteratorResult);

    Min operation = new Min();
    operation.setInput(input);
    operation.setComparators(comparators);
    Context context = new Context();

    // Act
    Element actualDoOperationResult = minHandler.doOperation(operation, context, new TestAddToGraphLibraryImpl());

    // Assert
    verify(comparators).get(eq(0));
    verify(comparators).size();
    verify(comparators, atLeast(1)).isEmpty();
    verify(comparators).iterator();
    verify(comparator, atLeast(1)).compare(isA(Element.class), isA(Element.class));
    assertSame(edge, actualDoOperationResult);
  }

  /**
   * Test {@link MinHandler#doOperation(Min, Context, Store)} with {@code Min}, {@code Context}, {@code Store}.
   * <ul>
   *   <li>Given {@link LinkedHashSet#LinkedHashSet()} add {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MinHandler#doOperation(Min, Context, Store)}
   */
  @Test
  @DisplayName("Test doOperation(Min, Context, Store) with 'Min', 'Context', 'Store'; given LinkedHashSet() add 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Element MinHandler.doOperation(Min, Context, Store)"})
  void testDoOperationWithMinContextStore_givenLinkedHashSetAddNull() throws OperationException {
    // Arrange
    MinHandler minHandler = new MinHandler();

    LinkedHashSet<? extends Element> input = new LinkedHashSet<>();
    input.add(null);

    ElementPropertyComparator elementPropertyComparator = new ElementPropertyComparator();
    elementPropertyComparator.setComparator(null);
    elementPropertyComparator.setReversed(false);
    elementPropertyComparator.setGroups(new HashSet<>());

    ArrayList<Comparator<Element>> comparators = new ArrayList<>();
    comparators.add(elementPropertyComparator);

    Min operation = new Min();
    operation.setInput(input);
    operation.setComparators(comparators);
    Context context = new Context();

    // Act and Assert
    assertNull(minHandler.doOperation(operation, context, new TestAddToGraphLibraryImpl()));
  }

  /**
   * Test {@link MinHandler#doOperation(Min, Context, Store)} with {@code Min}, {@code Context}, {@code Store}.
   * <ul>
   *   <li>Given {@link NonNullElementWrapperList} {@link NonNullElementWrapperList#size()} return three.</li>
   * </ul>
   * <p>
   * Method under test: {@link MinHandler#doOperation(Min, Context, Store)}
   */
  @Test
  @DisplayName("Test doOperation(Min, Context, Store) with 'Min', 'Context', 'Store'; given NonNullElementWrapperList size() return three")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Element MinHandler.doOperation(Min, Context, Store)"})
  void testDoOperationWithMinContextStore_givenNonNullElementWrapperListSizeReturnThree() throws OperationException {
    // Arrange
    MinHandler minHandler = new MinHandler();
    NonNullElementWrapperList<Comparator<Element>> comparators = mock(NonNullElementWrapperList.class);
    when(comparators.isEmpty()).thenReturn(false);
    when(comparators.size()).thenReturn(3);

    ArrayList<Comparator<Element>> comparatorList = new ArrayList<>();
    when(comparators.iterator()).thenReturn(comparatorList.iterator());

    Min operation = new Min();
    operation.setInput(new ArrayList<>());
    operation.setComparators(comparators);
    Context context = new Context();

    // Act
    Element actualDoOperationResult = minHandler.doOperation(operation, context, new TestAddToGraphLibraryImpl());

    // Assert
    verify(comparators).size();
    verify(comparators, atLeast(1)).isEmpty();
    verify(comparators).iterator();
    assertNull(actualDoOperationResult);
  }

  /**
   * Test {@link MinHandler#doOperation(Min, Context, Store)} with {@code Min}, {@code Context}, {@code Store}.
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>When {@link Min} (default constructor) Comparators is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MinHandler#doOperation(Min, Context, Store)}
   */
  @Test
  @DisplayName("Test doOperation(Min, Context, Store) with 'Min', 'Context', 'Store'; given 'null'; when Min (default constructor) Comparators is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Element MinHandler.doOperation(Min, Context, Store)"})
  void testDoOperationWithMinContextStore_givenNull_whenMinComparatorsIsNull() throws OperationException {
    // Arrange
    MinHandler minHandler = new MinHandler();

    Min operation = new Min();
    operation.setInput(new ArrayList<>());
    operation.setComparators(null);
    Context context = new Context();

    // Act and Assert
    assertNull(minHandler.doOperation(operation, context, new TestAddToGraphLibraryImpl()));
  }

  /**
   * Test {@link MinHandler#doOperation(Min, Context, Store)} with {@code Min}, {@code Context}, {@code Store}.
   * <ul>
   *   <li>Then calls {@link NonNullElementWrapperList#get(int)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MinHandler#doOperation(Min, Context, Store)}
   */
  @Test
  @DisplayName("Test doOperation(Min, Context, Store) with 'Min', 'Context', 'Store'; then calls get(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Element MinHandler.doOperation(Min, Context, Store)"})
  void testDoOperationWithMinContextStore_thenCallsGet() throws OperationException {
    // Arrange
    MinHandler minHandler = new MinHandler();
    NonNullElementWrapperList<Comparator<Element>> comparators = mock(NonNullElementWrapperList.class);
    when(comparators.get(anyInt())).thenReturn(mock(Comparator.class));
    when(comparators.isEmpty()).thenReturn(false);
    when(comparators.size()).thenReturn(1);

    ArrayList<Comparator<Element>> comparatorList = new ArrayList<>();
    when(comparators.iterator()).thenReturn(comparatorList.iterator());

    Min operation = new Min();
    operation.setInput(new ArrayList<>());
    operation.setComparators(comparators);
    Context context = new Context();

    // Act
    Element actualDoOperationResult = minHandler.doOperation(operation, context, new TestAddToGraphLibraryImpl());

    // Assert
    verify(comparators).get(eq(0));
    verify(comparators).size();
    verify(comparators, atLeast(1)).isEmpty();
    verify(comparators).iterator();
    assertNull(actualDoOperationResult);
  }

  /**
   * Test {@link MinHandler#doOperation(Min, Context, Store)} with {@code Min}, {@code Context}, {@code Store}.
   * <ul>
   *   <li>When {@link Min} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MinHandler#doOperation(Min, Context, Store)}
   */
  @Test
  @DisplayName("Test doOperation(Min, Context, Store) with 'Min', 'Context', 'Store'; when Min (default constructor); then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Element MinHandler.doOperation(Min, Context, Store)"})
  void testDoOperationWithMinContextStore_whenMin_thenReturnNull() throws OperationException {
    // Arrange
    MinHandler minHandler = new MinHandler();
    Min operation = new Min();
    Context context = new Context();

    // Act and Assert
    assertNull(minHandler.doOperation(operation, context, new TestAddToGraphLibraryImpl()));
  }
}
