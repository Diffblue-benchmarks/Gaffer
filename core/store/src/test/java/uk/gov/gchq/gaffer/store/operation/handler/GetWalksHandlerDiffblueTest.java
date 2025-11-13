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

package uk.gov.gchq.gaffer.store.operation.handler;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.Iterator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.commonutil.iterable.EmptyIterable;
import uk.gov.gchq.gaffer.commonutil.iterable.EmptyIterator;
import uk.gov.gchq.gaffer.data.element.Element;
import uk.gov.gchq.gaffer.data.element.Entity;
import uk.gov.gchq.gaffer.data.element.Entity.Builder;
import uk.gov.gchq.gaffer.data.element.id.EntityId;
import uk.gov.gchq.gaffer.data.graph.Walk;
import uk.gov.gchq.gaffer.named.operation.NamedOperation;
import uk.gov.gchq.gaffer.operation.OperationException;
import uk.gov.gchq.gaffer.operation.impl.GetWalks;
import uk.gov.gchq.gaffer.operation.impl.If;
import uk.gov.gchq.gaffer.operation.io.Output;
import uk.gov.gchq.gaffer.operation.util.Conditional;
import uk.gov.gchq.gaffer.store.Context;
import uk.gov.gchq.gaffer.store.Store;

class GetWalksHandlerDiffblueTest {
  /**
   * Test {@link GetWalksHandler#doOperation(GetWalks, Context, Store)} with {@code GetWalks},
   * {@code Context}, {@code Store}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link GetWalksHandler#doOperation(GetWalks, Context, Store)}
   */
  @Test
  @DisplayName(
      "Test doOperation(GetWalks, Context, Store) with 'GetWalks', 'Context', 'Store'; given ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Iterable GetWalksHandler.doOperation(GetWalks, Context, Store)"})
  void testDoOperationWithGetWalksContextStore_givenArrayList() throws OperationException {
    // Arrange
    GetWalksHandler getWalksHandler = new GetWalksHandler();

    ArrayList<EntityId> input = new ArrayList<>();
    input.add(new Builder().group("Group").vertex("Vertex").build());

    GetWalks getWalks = new GetWalks();
    getWalks.setResultsLimit(1);
    getWalks.addOperations(new ArrayList<>());
    getWalks.setInput(input);
    Context context = new Context();

    // Act
    Iterable<Walk> actualDoOperationResult =
        getWalksHandler.doOperation(getWalks, context, new TestAddToGraphLibraryImpl());

    // Assert
    assertTrue(actualDoOperationResult instanceof EmptyIterable);
    Iterator<Walk> iteratorResult = actualDoOperationResult.iterator();
    assertTrue(iteratorResult instanceof EmptyIterator);
    assertFalse(iteratorResult.hasNext());
  }

  /**
   * Test {@link GetWalksHandler#doOperation(GetWalks, Context, Store)} with {@code GetWalks},
   * {@code Context}, {@code Store}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link If} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link GetWalksHandler#doOperation(GetWalks, Context, Store)}
   */
  @Test
  @DisplayName(
      "Test doOperation(GetWalks, Context, Store) with 'GetWalks', 'Context', 'Store'; given ArrayList() add If (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Iterable GetWalksHandler.doOperation(GetWalks, Context, Store)"})
  void testDoOperationWithGetWalksContextStore_givenArrayListAddIf() throws OperationException {
    // Arrange
    GetWalksHandler getWalksHandler = new GetWalksHandler();

    ArrayList<EntityId> input = new ArrayList<>();
    input.add(new Builder().group("Group").vertex("Vertex").build());

    ArrayList<Output<Iterable<Element>>> operations = new ArrayList<>();
    operations.add(new If<>());

    GetWalks getWalks = new GetWalks();
    getWalks.setResultsLimit(1);
    getWalks.addOperations(operations);
    getWalks.setInput(input);
    Context context = new Context();

    // Act
    Iterable<Walk> actualDoOperationResult =
        getWalksHandler.doOperation(getWalks, context, new TestAddToGraphLibraryImpl());

    // Assert
    assertTrue(actualDoOperationResult instanceof EmptyIterable);
    Iterator<Walk> iteratorResult = actualDoOperationResult.iterator();
    assertTrue(iteratorResult instanceof EmptyIterator);
    assertFalse(iteratorResult.hasNext());
  }

  /**
   * Test {@link GetWalksHandler#doOperation(GetWalks, Context, Store)} with {@code GetWalks},
   * {@code Context}, {@code Store}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link NamedOperation} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link GetWalksHandler#doOperation(GetWalks, Context, Store)}
   */
  @Test
  @DisplayName(
      "Test doOperation(GetWalks, Context, Store) with 'GetWalks', 'Context', 'Store'; given ArrayList() add NamedOperation (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Iterable GetWalksHandler.doOperation(GetWalks, Context, Store)"})
  void testDoOperationWithGetWalksContextStore_givenArrayListAddNamedOperation()
      throws OperationException {
    // Arrange
    GetWalksHandler getWalksHandler = new GetWalksHandler();

    ArrayList<EntityId> input = new ArrayList<>();
    input.add(new Builder().group("Group").vertex("Vertex").build());

    ArrayList<Output<Iterable<Element>>> operations = new ArrayList<>();
    operations.add(new NamedOperation<>());

    GetWalks getWalks = new GetWalks();
    getWalks.setResultsLimit(1);
    getWalks.addOperations(operations);
    getWalks.setInput(input);
    Context context = new Context();

    // Act
    Iterable<Walk> actualDoOperationResult =
        getWalksHandler.doOperation(getWalks, context, new TestAddToGraphLibraryImpl());

    // Assert
    assertTrue(actualDoOperationResult instanceof EmptyIterable);
    Iterator<Walk> iteratorResult = actualDoOperationResult.iterator();
    assertTrue(iteratorResult instanceof EmptyIterator);
    assertFalse(iteratorResult.hasNext());
  }

  /**
   * Test {@link GetWalksHandler#doOperation(GetWalks, Context, Store)} with {@code GetWalks},
   * {@code Context}, {@code Store}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.
   *   <li>Then return {@link EmptyIterable}.
   * </ul>
   *
   * <p>Method under test: {@link GetWalksHandler#doOperation(GetWalks, Context, Store)}
   */
  @Test
  @DisplayName(
      "Test doOperation(GetWalks, Context, Store) with 'GetWalks', 'Context', 'Store'; given ArrayList(); then return EmptyIterable")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Iterable GetWalksHandler.doOperation(GetWalks, Context, Store)"})
  void testDoOperationWithGetWalksContextStore_givenArrayList_thenReturnEmptyIterable()
      throws OperationException {
    // Arrange
    GetWalksHandler getWalksHandler = new GetWalksHandler();

    GetWalks getWalks = new GetWalks();
    getWalks.setInput(new ArrayList<>());
    Context context = new Context();

    // Act
    Iterable<Walk> actualDoOperationResult =
        getWalksHandler.doOperation(getWalks, context, new TestAddToGraphLibraryImpl());

    // Assert
    assertTrue(actualDoOperationResult instanceof EmptyIterable);
    Iterator<Walk> iteratorResult = actualDoOperationResult.iterator();
    assertTrue(iteratorResult instanceof EmptyIterator);
    assertFalse(iteratorResult.hasNext());
  }

  /**
   * Test {@link GetWalksHandler#doOperation(GetWalks, Context, Store)} with {@code GetWalks},
   * {@code Context}, {@code Store}.
   *
   * <ul>
   *   <li>Given {@link If} (default constructor) Conditional is {@link Conditional#Conditional()}.
   * </ul>
   *
   * <p>Method under test: {@link GetWalksHandler#doOperation(GetWalks, Context, Store)}
   */
  @Test
  @DisplayName(
      "Test doOperation(GetWalks, Context, Store) with 'GetWalks', 'Context', 'Store'; given If (default constructor) Conditional is Conditional()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Iterable GetWalksHandler.doOperation(GetWalks, Context, Store)"})
  void testDoOperationWithGetWalksContextStore_givenIfConditionalIsConditional()
      throws OperationException {
    // Arrange
    GetWalksHandler getWalksHandler = new GetWalksHandler();

    ArrayList<EntityId> input = new ArrayList<>();
    input.add(new Builder().group("Group").vertex("Vertex").build());

    If<Object, Iterable<Element>> resultIf = new If<>();
    resultIf.setConditional(new Conditional());

    ArrayList<Output<Iterable<Element>>> operations = new ArrayList<>();
    operations.add(resultIf);

    GetWalks getWalks = new GetWalks();
    getWalks.setResultsLimit(1);
    getWalks.addOperations(operations);
    getWalks.setInput(input);
    Context context = new Context();

    // Act
    Iterable<Walk> actualDoOperationResult =
        getWalksHandler.doOperation(getWalks, context, new TestAddToGraphLibraryImpl());

    // Assert
    assertTrue(actualDoOperationResult instanceof EmptyIterable);
    Iterator<Walk> iteratorResult = actualDoOperationResult.iterator();
    assertTrue(iteratorResult instanceof EmptyIterator);
    assertFalse(iteratorResult.hasNext());
  }

  /**
   * Test {@link GetWalksHandler#doOperation(GetWalks, Context, Store)} with {@code GetWalks},
   * {@code Context}, {@code Store}.
   *
   * <ul>
   *   <li>Then return {@link EmptyIterable}.
   * </ul>
   *
   * <p>Method under test: {@link GetWalksHandler#doOperation(GetWalks, Context, Store)}
   */
  @Test
  @DisplayName(
      "Test doOperation(GetWalks, Context, Store) with 'GetWalks', 'Context', 'Store'; then return EmptyIterable")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Iterable GetWalksHandler.doOperation(GetWalks, Context, Store)"})
  void testDoOperationWithGetWalksContextStore_thenReturnEmptyIterable() throws OperationException {
    // Arrange
    GetWalksHandler getWalksHandler = new GetWalksHandler();

    ArrayList<EntityId> input = new ArrayList<>();
    input.add(new Builder().group("Group").vertex("Vertex").build());

    GetWalks getWalks = new GetWalks();
    getWalks.setInput(input);
    Context context = new Context();

    // Act
    Iterable<Walk> actualDoOperationResult =
        getWalksHandler.doOperation(getWalks, context, new TestAddToGraphLibraryImpl());

    // Assert
    assertTrue(actualDoOperationResult instanceof EmptyIterable);
    Iterator<Walk> iteratorResult = actualDoOperationResult.iterator();
    assertTrue(iteratorResult instanceof EmptyIterator);
    assertFalse(iteratorResult.hasNext());
  }

  /**
   * Test {@link GetWalksHandler#doOperation(GetWalks, Context, Store)} with {@code GetWalks},
   * {@code Context}, {@code Store}.
   *
   * <ul>
   *   <li>When {@link GetWalks} (default constructor).
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link GetWalksHandler#doOperation(GetWalks, Context, Store)}
   */
  @Test
  @DisplayName(
      "Test doOperation(GetWalks, Context, Store) with 'GetWalks', 'Context', 'Store'; when GetWalks (default constructor); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Iterable GetWalksHandler.doOperation(GetWalks, Context, Store)"})
  void testDoOperationWithGetWalksContextStore_whenGetWalks_thenReturnNull()
      throws OperationException {
    // Arrange
    GetWalksHandler getWalksHandler = new GetWalksHandler();
    GetWalks getWalks = new GetWalks();
    Context context = new Context();

    // Act and Assert
    assertNull(getWalksHandler.doOperation(getWalks, context, new TestAddToGraphLibraryImpl()));
  }

  /**
   * Test {@link GetWalksHandler#getPrune()}.
   *
   * <ul>
   *   <li>Given {@link GetWalksHandler} (default constructor) Prune is {@code false}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link GetWalksHandler#getPrune()}
   */
  @Test
  @DisplayName(
      "Test getPrune(); given GetWalksHandler (default constructor) Prune is 'false'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.Boolean GetWalksHandler.getPrune()"})
  void testGetPrune_givenGetWalksHandlerPruneIsFalse_thenReturnFalse() {
    // Arrange
    GetWalksHandler getWalksHandler = new GetWalksHandler();
    getWalksHandler.setPrune(false);

    // Act and Assert
    assertFalse(getWalksHandler.getPrune());
  }

  /**
   * Test {@link GetWalksHandler#getPrune()}.
   *
   * <ul>
   *   <li>Given {@link GetWalksHandler} (default constructor).
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link GetWalksHandler#getPrune()}
   */
  @Test
  @DisplayName("Test getPrune(); given GetWalksHandler (default constructor); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.Boolean GetWalksHandler.getPrune()"})
  void testGetPrune_givenGetWalksHandler_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(new GetWalksHandler().getPrune());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link GetWalksHandler}
   *   <li>{@link GetWalksHandler#setMaxHops(Integer)}
   *   <li>{@link GetWalksHandler#getMaxHops()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void GetWalksHandler.<init>()",
    "Integer GetWalksHandler.getMaxHops()",
    "void GetWalksHandler.setMaxHops(Integer)"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    GetWalksHandler actualGetWalksHandler = new GetWalksHandler();
    actualGetWalksHandler.setMaxHops(3);

    // Assert
    assertEquals(3, actualGetWalksHandler.getMaxHops().intValue());
  }
}
