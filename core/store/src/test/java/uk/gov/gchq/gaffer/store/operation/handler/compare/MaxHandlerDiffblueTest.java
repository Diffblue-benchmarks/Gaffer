/*
 * Copyright 2026 Crown Copyright
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
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashSet;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import uk.gov.gchq.gaffer.data.element.Element;
import uk.gov.gchq.gaffer.data.element.comparison.ElementPropertyComparator;
import uk.gov.gchq.gaffer.operation.OperationException;
import uk.gov.gchq.gaffer.operation.impl.compare.Max;
import uk.gov.gchq.gaffer.store.Context;
import uk.gov.gchq.gaffer.store.Store;
import uk.gov.gchq.gaffer.store.operation.handler.TestAddToGraphLibraryImpl;

class MaxHandlerDiffblueTest {
  /**
   * Test {@link MaxHandler#doOperation(Max, Context, Store)} with {@code Max}, {@code Context},
   * {@code Store}.
   *
   * <ul>
   *   <li>Given {@link LinkedHashSet#LinkedHashSet()} add {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link MaxHandler#doOperation(Max, Context, Store)}
   */
  @Test
  @DisplayName(
      "Test doOperation(Max, Context, Store) with 'Max', 'Context', 'Store'; given LinkedHashSet() add 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Element MaxHandler.doOperation(Max, Context, Store)"})
  void testDoOperationWithMaxContextStore_givenLinkedHashSetAddNull() throws OperationException {
    // Arrange
    MaxHandler maxHandler = new MaxHandler();

    LinkedHashSet<? extends Element> input = new LinkedHashSet<>();
    input.add(null);

    ElementPropertyComparator elementPropertyComparator = new ElementPropertyComparator();
    elementPropertyComparator.setGroups(new HashSet<>());
    elementPropertyComparator.setComparator(mock(Comparator.class));
    elementPropertyComparator.setReversed(false);

    Comparator<Element> comparator = mock(Comparator.class);
    when(comparator.thenComparing(Mockito.<Comparator<Element>>any()))
        .thenReturn(mock(Comparator.class));

    Comparator<Element> comparator2 = mock(Comparator.class);
    when(comparator2.thenComparing(Mockito.<Comparator<Element>>any())).thenReturn(comparator);

    ArrayList<Comparator<Element>> comparators = new ArrayList<>();
    comparators.add(comparator2);
    comparators.add(mock(Comparator.class));
    comparators.add(elementPropertyComparator);

    Max operation = new Max();
    operation.setInput(input);
    operation.setComparators(comparators);
    Context context = new Context();

    // Act
    Element actualDoOperationResult =
        maxHandler.doOperation(operation, context, new TestAddToGraphLibraryImpl());

    // Assert
    verify(comparator2).thenComparing(isA(Comparator.class));
    verify(comparator).thenComparing(isA(Comparator.class));
    assertNull(actualDoOperationResult);
  }

  /**
   * Test {@link MaxHandler#doOperation(Max, Context, Store)} with {@code Max}, {@code Context},
   * {@code Store}.
   *
   * <ul>
   *   <li>Given {@link LinkedHashSet#LinkedHashSet()} add {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link MaxHandler#doOperation(Max, Context, Store)}
   */
  @Test
  @DisplayName(
      "Test doOperation(Max, Context, Store) with 'Max', 'Context', 'Store'; given LinkedHashSet() add 'null'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Element MaxHandler.doOperation(Max, Context, Store)"})
  void testDoOperationWithMaxContextStore_givenLinkedHashSetAddNull_thenReturnNull()
      throws OperationException {
    // Arrange
    MaxHandler maxHandler = new MaxHandler();

    LinkedHashSet<? extends Element> input = new LinkedHashSet<>();
    input.add(null);

    ElementPropertyComparator elementPropertyComparator = new ElementPropertyComparator();
    elementPropertyComparator.setGroups(new HashSet<>());
    elementPropertyComparator.setComparator(mock(Comparator.class));
    elementPropertyComparator.setReversed(false);

    ArrayList<Comparator<Element>> comparators = new ArrayList<>();
    comparators.add(elementPropertyComparator);

    Max operation = new Max();
    operation.setInput(input);
    operation.setComparators(comparators);
    Context context = new Context();

    // Act and Assert
    assertNull(maxHandler.doOperation(operation, context, new TestAddToGraphLibraryImpl()));
  }

  /**
   * Test {@link MaxHandler#doOperation(Max, Context, Store)} with {@code Max}, {@code Context},
   * {@code Store}.
   *
   * <ul>
   *   <li>When {@link Max} (default constructor).
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link MaxHandler#doOperation(Max, Context, Store)}
   */
  @Test
  @DisplayName(
      "Test doOperation(Max, Context, Store) with 'Max', 'Context', 'Store'; when Max (default constructor); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Element MaxHandler.doOperation(Max, Context, Store)"})
  void testDoOperationWithMaxContextStore_whenMax_thenReturnNull() throws OperationException {
    // Arrange
    MaxHandler maxHandler = new MaxHandler();
    Max operation = new Max();
    Context context = new Context();

    // Act and Assert
    assertNull(maxHandler.doOperation(operation, context, new TestAddToGraphLibraryImpl()));
  }
}
