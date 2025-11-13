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

package uk.gov.gchq.gaffer.mapstore.impl;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import uk.gov.gchq.gaffer.data.element.Element;
import uk.gov.gchq.gaffer.data.elementdefinition.ElementDefinitions;
import uk.gov.gchq.gaffer.data.elementdefinition.view.View;
import uk.gov.gchq.gaffer.mapstore.MapStore;
import uk.gov.gchq.gaffer.mapstore.MapStoreProperties;
import uk.gov.gchq.gaffer.operation.OperationException;
import uk.gov.gchq.gaffer.operation.impl.get.GetAllElements;
import uk.gov.gchq.gaffer.store.Context;
import uk.gov.gchq.gaffer.store.Store;
import uk.gov.gchq.gaffer.store.schema.Schema;

class GetAllElementsHandlerDiffblueTest {
  /**
   * Test {@link GetAllElementsHandler#doOperation(GetAllElements, Context, Store)} with {@code operation}, {@code context}, {@code store}.
   * <ul>
   *   <li>Given {@link HashSet#HashSet()} add {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GetAllElementsHandler#doOperation(GetAllElements, Context, Store)}
   */
  @Test
  @DisplayName("Test doOperation(GetAllElements, Context, Store) with 'operation', 'context', 'store'; given HashSet() add 'foo'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.Iterable GetAllElementsHandler.doOperation(GetAllElements, Context, Store)"})
  void testDoOperationWithOperationContextStore_givenHashSetAddFoo() throws OperationException {
    // Arrange
    GetAllElementsHandler getAllElementsHandler = new GetAllElementsHandler();

    HashSet<String> stringSet = new HashSet<>();
    stringSet.add("foo");
    View view = mock(View.class);
    when(view.hasEdges()).thenReturn(true);
    when(view.getEdgeGroups()).thenReturn(stringSet);
    when(view.getEntityGroups()).thenReturn(new HashSet<>());
    when(view.getGroups()).thenReturn(new HashSet<>());

    GetAllElements operation = new GetAllElements();
    operation.setView(view);
    Context context = new Context();
    MapStore store = mock(MapStore.class);
    when(store.getTraits()).thenReturn(new HashSet<>());
    Schema schema = new Schema();
    when(store.getMapImpl()).thenReturn(new MapImpl(schema, new MapStoreProperties()));
    when(store.getSchema()).thenReturn(new Schema());

    // Act
    Iterator<? extends Element> actualIteratorResult = getAllElementsHandler.doOperation(operation, context, store)
        .iterator();

    // Assert
    verify(view).getEdgeGroups();
    verify(view).getEntityGroups();
    verify(view, atLeast(1)).getGroups();
    verify(view).hasEdges();
    verify(store).getMapImpl();
    verify(store).getTraits();
    verify(store).getSchema();
    assertFalse(actualIteratorResult.hasNext());
  }

  /**
   * Test {@link GetAllElementsHandler#doOperation(GetAllElements, Context, Store)} with {@code operation}, {@code context}, {@code store}.
   * <ul>
   *   <li>Given {@link HashSet#HashSet()} add {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GetAllElementsHandler#doOperation(GetAllElements, Context, Store)}
   */
  @Test
  @DisplayName("Test doOperation(GetAllElements, Context, Store) with 'operation', 'context', 'store'; given HashSet() add 'foo'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.Iterable GetAllElementsHandler.doOperation(GetAllElements, Context, Store)"})
  void testDoOperationWithOperationContextStore_givenHashSetAddFoo2() throws OperationException {
    // Arrange
    GetAllElementsHandler getAllElementsHandler = new GetAllElementsHandler();

    HashSet<String> stringSet = new HashSet<>();
    stringSet.add("foo");
    View view = mock(View.class);
    when(view.hasEdges()).thenReturn(true);
    when(view.getEntityGroups()).thenReturn(stringSet);
    when(view.getGroups()).thenReturn(new HashSet<>());

    GetAllElements operation = new GetAllElements();
    operation.setView(view);
    Context context = new Context();
    MapStore store = mock(MapStore.class);
    when(store.getTraits()).thenReturn(new HashSet<>());
    Schema schema = new Schema();
    when(store.getMapImpl()).thenReturn(new MapImpl(schema, new MapStoreProperties()));
    when(store.getSchema()).thenReturn(new Schema());

    // Act
    Iterator<? extends Element> actualIteratorResult = getAllElementsHandler.doOperation(operation, context, store)
        .iterator();

    // Assert
    verify(view).getEntityGroups();
    verify(view, atLeast(1)).getGroups();
    verify(view).hasEdges();
    verify(store).getMapImpl();
    verify(store).getTraits();
    verify(store).getSchema();
    assertFalse(actualIteratorResult.hasNext());
  }

  /**
   * Test {@link GetAllElementsHandler#doOperation(GetAllElements, Context, Store)} with {@code operation}, {@code context}, {@code store}.
   * <ul>
   *   <li>Then calls {@link MapImpl#getAllElements(Set)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GetAllElementsHandler#doOperation(GetAllElements, Context, Store)}
   */
  @Test
  @DisplayName("Test doOperation(GetAllElements, Context, Store) with 'operation', 'context', 'store'; then calls getAllElements(Set)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.Iterable GetAllElementsHandler.doOperation(GetAllElements, Context, Store)"})
  void testDoOperationWithOperationContextStore_thenCallsGetAllElements() throws OperationException {
    // Arrange
    GetAllElementsHandler getAllElementsHandler = new GetAllElementsHandler();
    View view = mock(View.class);
    when(view.hasEdges()).thenReturn(true);
    when(view.getEdgeGroups()).thenReturn(new HashSet<>());
    when(view.getEntityGroups()).thenReturn(new HashSet<>());
    when(view.getGroups()).thenReturn(new HashSet<>());

    GetAllElements operation = new GetAllElements();
    operation.setView(view);
    Context context = new Context();
    MapImpl mapImpl = mock(MapImpl.class);

    ArrayList<Element> elementList = new ArrayList<>();
    Stream<Element> streamResult = elementList.stream();
    when(mapImpl.getAllElements(Mockito.<Set<String>>any())).thenReturn(streamResult);
    MapStore store = mock(MapStore.class);
    when(store.getTraits()).thenReturn(new HashSet<>());
    when(store.getMapImpl()).thenReturn(mapImpl);
    when(store.getSchema()).thenReturn(new Schema());

    // Act
    Iterator<? extends Element> actualIteratorResult = getAllElementsHandler.doOperation(operation, context, store)
        .iterator();

    // Assert
    verify(view).getEdgeGroups();
    verify(view).getEntityGroups();
    verify(view, atLeast(1)).getGroups();
    verify(view).hasEdges();
    verify(store).getMapImpl();
    verify(store).getTraits();
    verify(mapImpl).getAllElements(isA(Set.class));
    verify(store).getSchema();
    assertFalse(actualIteratorResult.hasNext());
  }

  /**
   * Test {@link GetAllElementsHandler#doOperation(GetAllElements, Context, Store)} with {@code operation}, {@code context}, {@code store}.
   * <ul>
   *   <li>Then calls {@link ElementDefinitions#getEdgeGroups()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GetAllElementsHandler#doOperation(GetAllElements, Context, Store)}
   */
  @Test
  @DisplayName("Test doOperation(GetAllElements, Context, Store) with 'operation', 'context', 'store'; then calls getEdgeGroups()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.Iterable GetAllElementsHandler.doOperation(GetAllElements, Context, Store)"})
  void testDoOperationWithOperationContextStore_thenCallsGetEdgeGroups() throws OperationException {
    // Arrange
    GetAllElementsHandler getAllElementsHandler = new GetAllElementsHandler();
    View view = mock(View.class);
    when(view.hasEdges()).thenReturn(true);
    when(view.getEdgeGroups()).thenReturn(new HashSet<>());
    when(view.getEntityGroups()).thenReturn(new HashSet<>());
    when(view.getGroups()).thenReturn(new HashSet<>());

    GetAllElements operation = new GetAllElements();
    operation.setView(view);
    Context context = new Context();
    MapStore store = mock(MapStore.class);
    when(store.getTraits()).thenReturn(new HashSet<>());
    Schema schema = new Schema();
    when(store.getMapImpl()).thenReturn(new MapImpl(schema, new MapStoreProperties()));
    when(store.getSchema()).thenReturn(new Schema());

    // Act
    Iterator<? extends Element> actualIteratorResult = getAllElementsHandler.doOperation(operation, context, store)
        .iterator();

    // Assert
    verify(view).getEdgeGroups();
    verify(view).getEntityGroups();
    verify(view, atLeast(1)).getGroups();
    verify(view).hasEdges();
    verify(store).getMapImpl();
    verify(store).getTraits();
    verify(store).getSchema();
    assertFalse(actualIteratorResult.hasNext());
  }

  /**
   * Test {@link GetAllElementsHandler#doOperation(GetAllElements, Context, Store)} with {@code operation}, {@code context}, {@code store}.
   * <ul>
   *   <li>When {@link GetAllElements} (default constructor) View is {@link View} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link GetAllElementsHandler#doOperation(GetAllElements, Context, Store)}
   */
  @Test
  @DisplayName("Test doOperation(GetAllElements, Context, Store) with 'operation', 'context', 'store'; when GetAllElements (default constructor) View is View (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.Iterable GetAllElementsHandler.doOperation(GetAllElements, Context, Store)"})
  void testDoOperationWithOperationContextStore_whenGetAllElementsViewIsView() throws OperationException {
    // Arrange
    GetAllElementsHandler getAllElementsHandler = new GetAllElementsHandler();

    GetAllElements operation = new GetAllElements();
    operation.setView(new View());
    Context context = new Context();
    MapStore store = mock(MapStore.class);
    when(store.getTraits()).thenReturn(new HashSet<>());
    Schema schema = new Schema();
    when(store.getMapImpl()).thenReturn(new MapImpl(schema, new MapStoreProperties()));
    when(store.getSchema()).thenReturn(new Schema());

    // Act
    Iterator<? extends Element> actualIteratorResult = getAllElementsHandler.doOperation(operation, context, store)
        .iterator();

    // Assert
    verify(store).getMapImpl();
    verify(store).getTraits();
    verify(store).getSchema();
    assertFalse(actualIteratorResult.hasNext());
  }
}
