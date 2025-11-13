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

package uk.gov.gchq.gaffer.accumulostore.operation.handler;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import uk.gov.gchq.gaffer.accumulostore.AccumuloStore;
import uk.gov.gchq.gaffer.data.element.Edge;
import uk.gov.gchq.gaffer.data.element.Edge.Builder;
import uk.gov.gchq.gaffer.data.element.Element;
import uk.gov.gchq.gaffer.data.element.id.EdgeId;
import uk.gov.gchq.gaffer.data.element.id.EdgeId.MatchedVertex;
import uk.gov.gchq.gaffer.operation.OperationException;
import uk.gov.gchq.gaffer.operation.impl.delete.DeleteElements;
import uk.gov.gchq.gaffer.store.Context;
import uk.gov.gchq.gaffer.store.Store;
import uk.gov.gchq.gaffer.store.StoreException;
import uk.gov.gchq.gaffer.store.schema.Schema;
import uk.gov.gchq.gaffer.store.schema.SchemaEdgeDefinition;

class DeleteElementsHandlerDiffblueTest {
  /**
   * Test {@link DeleteElementsHandler#doOperation(DeleteElements, Context, Store)} with {@code DeleteElements}, {@code Context}, {@code Store}.
   * <p>
   * Method under test: {@link DeleteElementsHandler#doOperation(DeleteElements, Context, Store)}
   */
  @Test
  @DisplayName("Test doOperation(DeleteElements, Context, Store) with 'DeleteElements', 'Context', 'Store'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Long DeleteElementsHandler.doOperation(DeleteElements, Context, Store)"})
  void testDoOperationWithDeleteElementsContextStore() throws OperationException, StoreException {
    // Arrange
    DeleteElementsHandler deleteElementsHandler = new DeleteElementsHandler();

    ArrayList<Element> elementList = new ArrayList<>();
    Edge buildResult = (new Builder()).dest("Dest")
        .directed(true)
        .group("Group")
        .matchedVertex(MatchedVertex.SOURCE)
        .source("Source")
        .build();
    elementList.add(buildResult);
    DeleteElements operation = mock(DeleteElements.class);
    when(operation.isSkipInvalidElements()).thenReturn(true);
    when(operation.isValidate()).thenReturn(true);
    Mockito.<Iterable<? extends Element>>when(operation.getInput()).thenReturn(elementList);
    Context context = new Context();
    Schema schema = mock(Schema.class);
    when(schema.getElement(Mockito.<String>any())).thenReturn(new SchemaEdgeDefinition());
    AccumuloStore store = mock(AccumuloStore.class);
    when(store.getSchema()).thenReturn(schema);
    doNothing().when(store).deleteElements(Mockito.<Iterable<Element>>any());

    // Act
    Long actualDoOperationResult = deleteElementsHandler.doOperation(operation, context, store);

    // Assert
    verify(store).deleteElements(isA(Iterable.class));
    verify(operation).getInput();
    verify(operation).isSkipInvalidElements();
    verify(operation).isValidate();
    verify(store).getSchema();
    verify(schema).getElement(eq("Group"));
    assertEquals(1L, actualDoOperationResult.longValue());
  }

  /**
   * Test {@link DeleteElementsHandler#doOperation(DeleteElements, Context, Store)} with {@code DeleteElements}, {@code Context}, {@code Store}.
   * <ul>
   *   <li>Then calls {@link Element#getGroup()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeleteElementsHandler#doOperation(DeleteElements, Context, Store)}
   */
  @Test
  @DisplayName("Test doOperation(DeleteElements, Context, Store) with 'DeleteElements', 'Context', 'Store'; then calls getGroup()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Long DeleteElementsHandler.doOperation(DeleteElements, Context, Store)"})
  void testDoOperationWithDeleteElementsContextStore_thenCallsGetGroup() throws OperationException, StoreException {
    // Arrange
    DeleteElementsHandler deleteElementsHandler = new DeleteElementsHandler();
    Edge edge = mock(Edge.class);
    when(edge.getGroup()).thenReturn("Group");

    ArrayList<Element> elementList = new ArrayList<>();
    elementList.add(edge);
    DeleteElements operation = mock(DeleteElements.class);
    when(operation.isSkipInvalidElements()).thenReturn(true);
    when(operation.isValidate()).thenReturn(true);
    Mockito.<Iterable<? extends Element>>when(operation.getInput()).thenReturn(elementList);
    Context context = new Context();
    Schema schema = mock(Schema.class);
    when(schema.getElement(Mockito.<String>any())).thenReturn(new SchemaEdgeDefinition());
    AccumuloStore store = mock(AccumuloStore.class);
    when(store.getSchema()).thenReturn(schema);
    doNothing().when(store).deleteElements(Mockito.<Iterable<Element>>any());

    // Act
    Long actualDoOperationResult = deleteElementsHandler.doOperation(operation, context, store);

    // Assert
    verify(store).deleteElements(isA(Iterable.class));
    verify(edge).getGroup();
    verify(operation).getInput();
    verify(operation).isSkipInvalidElements();
    verify(operation).isValidate();
    verify(store).getSchema();
    verify(schema).getElement(eq("Group"));
    assertEquals(1L, actualDoOperationResult.longValue());
  }

  /**
   * Test {@link DeleteElementsHandler#doOperation(DeleteElements, Context, Store)} with {@code DeleteElements}, {@code Context}, {@code Store}.
   * <ul>
   *   <li>Then return longValue is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeleteElementsHandler#doOperation(DeleteElements, Context, Store)}
   */
  @Test
  @DisplayName("Test doOperation(DeleteElements, Context, Store) with 'DeleteElements', 'Context', 'Store'; then return longValue is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Long DeleteElementsHandler.doOperation(DeleteElements, Context, Store)"})
  void testDoOperationWithDeleteElementsContextStore_thenReturnLongValueIsOne()
      throws OperationException, StoreException {
    // Arrange
    DeleteElementsHandler deleteElementsHandler = new DeleteElementsHandler();

    ArrayList<Element> elementList = new ArrayList<>();
    elementList.add(new Edge("Deleting elements: {}"));
    DeleteElements operation = mock(DeleteElements.class);
    when(operation.isSkipInvalidElements()).thenReturn(true);
    when(operation.isValidate()).thenReturn(true);
    Mockito.<Iterable<? extends Element>>when(operation.getInput()).thenReturn(elementList);
    Context context = new Context();
    Schema schema = mock(Schema.class);
    when(schema.getElement(Mockito.<String>any())).thenReturn(new SchemaEdgeDefinition());
    AccumuloStore store = mock(AccumuloStore.class);
    when(store.getSchema()).thenReturn(schema);
    doNothing().when(store).deleteElements(Mockito.<Iterable<Element>>any());

    // Act
    Long actualDoOperationResult = deleteElementsHandler.doOperation(operation, context, store);

    // Assert
    verify(store).deleteElements(isA(Iterable.class));
    verify(operation).getInput();
    verify(operation).isSkipInvalidElements();
    verify(operation).isValidate();
    verify(store).getSchema();
    verify(schema).getElement(eq("Deleting elements: {}"));
    assertEquals(1L, actualDoOperationResult.longValue());
  }

  /**
   * Test {@link DeleteElementsHandler#doOperation(DeleteElements, Context, Store)} with {@code DeleteElements}, {@code Context}, {@code Store}.
   * <ul>
   *   <li>Then return longValue is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeleteElementsHandler#doOperation(DeleteElements, Context, Store)}
   */
  @Test
  @DisplayName("Test doOperation(DeleteElements, Context, Store) with 'DeleteElements', 'Context', 'Store'; then return longValue is two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Long DeleteElementsHandler.doOperation(DeleteElements, Context, Store)"})
  void testDoOperationWithDeleteElementsContextStore_thenReturnLongValueIsTwo()
      throws OperationException, StoreException {
    // Arrange
    DeleteElementsHandler deleteElementsHandler = new DeleteElementsHandler();

    ArrayList<Element> elementList = new ArrayList<>();
    elementList.add(new Edge("source"));
    elementList.add(new Edge("Deleting elements: {}"));
    DeleteElements operation = mock(DeleteElements.class);
    when(operation.isSkipInvalidElements()).thenReturn(true);
    when(operation.isValidate()).thenReturn(true);
    Mockito.<Iterable<? extends Element>>when(operation.getInput()).thenReturn(elementList);
    Context context = new Context();
    Schema schema = mock(Schema.class);
    when(schema.getElement(Mockito.<String>any())).thenReturn(new SchemaEdgeDefinition());
    AccumuloStore store = mock(AccumuloStore.class);
    when(store.getSchema()).thenReturn(schema);
    doNothing().when(store).deleteElements(Mockito.<Iterable<Element>>any());

    // Act
    Long actualDoOperationResult = deleteElementsHandler.doOperation(operation, context, store);

    // Assert
    verify(store).deleteElements(isA(Iterable.class));
    verify(operation).getInput();
    verify(operation).isSkipInvalidElements();
    verify(operation).isValidate();
    verify(store).getSchema();
    verify(schema, atLeast(1)).getElement(Mockito.<String>any());
    assertEquals(2L, actualDoOperationResult.longValue());
  }

  /**
   * Test {@link DeleteElementsHandler#doOperation(DeleteElements, Context, Store)} with {@code DeleteElements}, {@code Context}, {@code Store}.
   * <ul>
   *   <li>Then return longValue is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeleteElementsHandler#doOperation(DeleteElements, Context, Store)}
   */
  @Test
  @DisplayName("Test doOperation(DeleteElements, Context, Store) with 'DeleteElements', 'Context', 'Store'; then return longValue is zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Long DeleteElementsHandler.doOperation(DeleteElements, Context, Store)"})
  void testDoOperationWithDeleteElementsContextStore_thenReturnLongValueIsZero()
      throws OperationException, StoreException {
    // Arrange
    DeleteElementsHandler deleteElementsHandler = new DeleteElementsHandler();
    DeleteElements operation = mock(DeleteElements.class);
    when(operation.isSkipInvalidElements()).thenReturn(true);
    when(operation.isValidate()).thenReturn(true);
    Mockito.<Iterable<? extends Element>>when(operation.getInput()).thenReturn(new ArrayList<>());
    Context context = new Context();
    AccumuloStore store = mock(AccumuloStore.class);
    when(store.getSchema()).thenReturn(new Schema());
    doNothing().when(store).deleteElements(Mockito.<Iterable<Element>>any());

    // Act
    Long actualDoOperationResult = deleteElementsHandler.doOperation(operation, context, store);

    // Assert
    verify(store).deleteElements(isA(Iterable.class));
    verify(operation).getInput();
    verify(operation).isSkipInvalidElements();
    verify(operation).isValidate();
    verify(store).getSchema();
    assertEquals(0L, actualDoOperationResult.longValue());
  }

  /**
   * Test {@link DeleteElementsHandler#doOperation(DeleteElements, Context, Store)} with {@code DeleteElements}, {@code Context}, {@code Store}.
   * <ul>
   *   <li>Then return longValue is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeleteElementsHandler#doOperation(DeleteElements, Context, Store)}
   */
  @Test
  @DisplayName("Test doOperation(DeleteElements, Context, Store) with 'DeleteElements', 'Context', 'Store'; then return longValue is zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Long DeleteElementsHandler.doOperation(DeleteElements, Context, Store)"})
  void testDoOperationWithDeleteElementsContextStore_thenReturnLongValueIsZero2()
      throws OperationException, StoreException {
    // Arrange
    DeleteElementsHandler deleteElementsHandler = new DeleteElementsHandler();

    ArrayList<Element> elementList = new ArrayList<>();
    elementList.add(new Edge("Deleting elements: {}"));
    DeleteElements operation = mock(DeleteElements.class);
    when(operation.isSkipInvalidElements()).thenReturn(true);
    when(operation.isValidate()).thenReturn(true);
    Mockito.<Iterable<? extends Element>>when(operation.getInput()).thenReturn(elementList);
    Context context = new Context();
    AccumuloStore store = mock(AccumuloStore.class);
    when(store.getSchema()).thenReturn(new Schema());
    doNothing().when(store).deleteElements(Mockito.<Iterable<Element>>any());

    // Act
    Long actualDoOperationResult = deleteElementsHandler.doOperation(operation, context, store);

    // Assert
    verify(store).deleteElements(isA(Iterable.class));
    verify(operation).getInput();
    verify(operation).isSkipInvalidElements();
    verify(operation).isValidate();
    verify(store).getSchema();
    assertEquals(0L, actualDoOperationResult.longValue());
  }

  /**
   * Test {@link DeleteElementsHandler#doOperation(DeleteElements, Context, Store)} with {@code DeleteElements}, {@code Context}, {@code Store}.
   * <ul>
   *   <li>Then return longValue is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeleteElementsHandler#doOperation(DeleteElements, Context, Store)}
   */
  @Test
  @DisplayName("Test doOperation(DeleteElements, Context, Store) with 'DeleteElements', 'Context', 'Store'; then return longValue is zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Long DeleteElementsHandler.doOperation(DeleteElements, Context, Store)"})
  void testDoOperationWithDeleteElementsContextStore_thenReturnLongValueIsZero3()
      throws OperationException, StoreException {
    // Arrange
    DeleteElementsHandler deleteElementsHandler = new DeleteElementsHandler();

    ArrayList<Element> elementList = new ArrayList<>();
    elementList.add(new Edge("Deleting elements: {}"));
    elementList.add(new Edge("Deleting elements: {}"));
    DeleteElements operation = mock(DeleteElements.class);
    when(operation.isSkipInvalidElements()).thenReturn(true);
    when(operation.isValidate()).thenReturn(true);
    Mockito.<Iterable<? extends Element>>when(operation.getInput()).thenReturn(elementList);
    Context context = new Context();
    AccumuloStore store = mock(AccumuloStore.class);
    when(store.getSchema()).thenReturn(new Schema());
    doNothing().when(store).deleteElements(Mockito.<Iterable<Element>>any());

    // Act
    Long actualDoOperationResult = deleteElementsHandler.doOperation(operation, context, store);

    // Assert
    verify(store).deleteElements(isA(Iterable.class));
    verify(operation).getInput();
    verify(operation).isSkipInvalidElements();
    verify(operation).isValidate();
    verify(store).getSchema();
    assertEquals(0L, actualDoOperationResult.longValue());
  }

  /**
   * Test {@link DeleteElementsHandler#doOperation(DeleteElements, Context, Store)} with {@code DeleteElements}, {@code Context}, {@code Store}.
   * <ul>
   *   <li>Then throw {@link OperationException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeleteElementsHandler#doOperation(DeleteElements, Context, Store)}
   */
  @Test
  @DisplayName("Test doOperation(DeleteElements, Context, Store) with 'DeleteElements', 'Context', 'Store'; then throw OperationException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Long DeleteElementsHandler.doOperation(DeleteElements, Context, Store)"})
  void testDoOperationWithDeleteElementsContextStore_thenThrowOperationException()
      throws OperationException, StoreException {
    // Arrange
    DeleteElementsHandler deleteElementsHandler = new DeleteElementsHandler();
    DeleteElements operation = mock(DeleteElements.class);
    when(operation.isSkipInvalidElements()).thenReturn(true);
    when(operation.isValidate()).thenReturn(true);
    Mockito.<Iterable<? extends Element>>when(operation.getInput()).thenReturn(new ArrayList<>());
    Context context = new Context();
    AccumuloStore store = mock(AccumuloStore.class);
    when(store.getSchema()).thenReturn(new Schema());
    doThrow(new StoreException("An error occurred")).when(store).deleteElements(Mockito.<Iterable<Element>>any());

    // Act and Assert
    assertThrows(OperationException.class, () -> deleteElementsHandler.doOperation(operation, context, store));
    verify(store).deleteElements(isA(Iterable.class));
    verify(operation).getInput();
    verify(operation).isSkipInvalidElements();
    verify(operation).isValidate();
    verify(store).getSchema();
  }
}
