package uk.gov.gchq.gaffer.store.operation.handler.join;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import uk.gov.gchq.gaffer.operation.Operation;
import uk.gov.gchq.gaffer.operation.OperationException;
import uk.gov.gchq.gaffer.operation.impl.OperationImpl;
import uk.gov.gchq.gaffer.operation.impl.join.Join;
import uk.gov.gchq.gaffer.operation.impl.join.match.MatchKey;
import uk.gov.gchq.gaffer.operation.impl.join.methods.JoinType;
import uk.gov.gchq.gaffer.store.Context;
import uk.gov.gchq.gaffer.store.Store;
import uk.gov.gchq.gaffer.store.operation.handler.TestAddToGraphLibraryImpl;
import uk.gov.gchq.gaffer.store.operation.handler.join.match.KeyFunctionMatch;
import uk.gov.gchq.gaffer.store.operation.handler.join.match.KeyFunctionMatch.Builder;
import uk.gov.gchq.koryphe.tuple.MapTuple;

class JoinHandlerDiffblueTest {
  /**
   * Test {@link JoinHandler#doOperation(Join, Context, Store)} with {@code Join}, {@code Context},
   * {@code Store}.
   *
   * <ul>
   *   <li>Given {@code false}.
   *   <li>When {@link Join} {@link Join#isFlatten()} return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link JoinHandler#doOperation(Join, Context, Store)}
   */
  @Test
  @DisplayName(
      "Test doOperation(Join, Context, Store) with 'Join', 'Context', 'Store'; given 'false'; when Join isFlatten() return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Iterable JoinHandler.doOperation(Join, Context, Store)"})
  void testDoOperationWithJoinContextStore_givenFalse_whenJoinIsFlattenReturnFalse()
      throws OperationException {
    // Arrange
    JoinHandler<Object> joinHandler = new JoinHandler<>();

    Join<Object> operation = mock(Join.class);
    when(operation.isFlatten()).thenReturn(false);
    when(operation.getOperation()).thenReturn(mock(OperationImpl.class));
    Mockito.<Iterable<?>>when(operation.getInput()).thenReturn(new ArrayList<>());
    when(operation.getMatchKey()).thenReturn(MatchKey.LEFT);
    when(operation.getMatchMethod())
        .thenReturn(
            new Builder()
                .firstKeyFunction(mock(Function.class))
                .secondKeyFunction(mock(Function.class))
                .build());
    when(operation.getCollectionLimit()).thenReturn(1);
    when(operation.getJoinType()).thenReturn(JoinType.FULL);
    Context context = new Context();

    TestAddToGraphLibraryImpl store = mock(TestAddToGraphLibraryImpl.class);
    doNothing().when(store).execute(Mockito.<Operation>any(), Mockito.<Context>any());

    // Act
    Iterable<? extends MapTuple> actualDoOperationResult =
        joinHandler.doOperation(operation, context, store);
    Iterator<? extends MapTuple> actualIteratorResult = actualDoOperationResult.iterator();

    // Assert
    verify(operation, atLeast(1)).getCollectionLimit();
    verify(operation, atLeast(1)).getInput();
    verify(operation, atLeast(1)).getJoinType();
    verify(operation).getMatchKey();
    verify(operation, atLeast(1)).getMatchMethod();
    verify(operation, atLeast(1)).getOperation();
    verify(operation).isFlatten();
    verify(store).execute(isA(Operation.class), isA(Context.class));
    assertTrue(actualDoOperationResult instanceof List);
    assertFalse(actualIteratorResult.hasNext());
    assertTrue(((List<? extends MapTuple>) actualDoOperationResult).isEmpty());
  }

  /**
   * Test {@link JoinHandler#doOperation(Join, Context, Store)} with {@code Join}, {@code Context},
   * {@code Store}.
   *
   * <ul>
   *   <li>Given {@link OperationImpl}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link JoinHandler#doOperation(Join, Context, Store)}
   */
  @Test
  @DisplayName(
      "Test doOperation(Join, Context, Store) with 'Join', 'Context', 'Store'; given OperationImpl; then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Iterable JoinHandler.doOperation(Join, Context, Store)"})
  void testDoOperationWithJoinContextStore_givenOperationImpl_thenReturnEmpty()
      throws OperationException {
    // Arrange
    JoinHandler<Object> joinHandler = new JoinHandler<>();

    Join<Object> operation = mock(Join.class);
    when(operation.isFlatten()).thenReturn(true);
    when(operation.getOperation()).thenReturn(mock(OperationImpl.class));
    Mockito.<Iterable<?>>when(operation.getInput()).thenReturn(new ArrayList<>());
    when(operation.getMatchKey()).thenReturn(MatchKey.LEFT);
    when(operation.getMatchMethod())
        .thenReturn(
            new Builder()
                .firstKeyFunction(mock(Function.class))
                .secondKeyFunction(mock(Function.class))
                .build());
    when(operation.getCollectionLimit()).thenReturn(1);
    when(operation.getJoinType()).thenReturn(JoinType.FULL);
    Context context = new Context();

    TestAddToGraphLibraryImpl store = mock(TestAddToGraphLibraryImpl.class);
    doNothing().when(store).execute(Mockito.<Operation>any(), Mockito.<Context>any());

    // Act
    Iterable<? extends MapTuple> actualDoOperationResult =
        joinHandler.doOperation(operation, context, store);
    Iterator<? extends MapTuple> actualIteratorResult = actualDoOperationResult.iterator();

    // Assert
    verify(operation, atLeast(1)).getCollectionLimit();
    verify(operation, atLeast(1)).getInput();
    verify(operation, atLeast(1)).getJoinType();
    verify(operation).getMatchKey();
    verify(operation, atLeast(1)).getMatchMethod();
    verify(operation, atLeast(1)).getOperation();
    verify(operation).isFlatten();
    verify(store).execute(isA(Operation.class), isA(Context.class));
    assertTrue(actualDoOperationResult instanceof List);
    assertFalse(actualIteratorResult.hasNext());
    assertTrue(((List<? extends MapTuple>) actualDoOperationResult).isEmpty());
  }

  /**
   * Test {@link JoinHandler#doOperation(Join, Context, Store)} with {@code Join}, {@code Context},
   * {@code Store}.
   *
   * <ul>
   *   <li>Given {@code RIGHT}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link JoinHandler#doOperation(Join, Context, Store)}
   */
  @Test
  @DisplayName(
      "Test doOperation(Join, Context, Store) with 'Join', 'Context', 'Store'; given 'RIGHT'; then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Iterable JoinHandler.doOperation(Join, Context, Store)"})
  void testDoOperationWithJoinContextStore_givenRight_thenReturnEmpty() throws OperationException {
    // Arrange
    JoinHandler<Object> joinHandler = new JoinHandler<>();

    Function secondKeyFunction = mock(Function.class);
    when(secondKeyFunction.apply(Mockito.<Object>any())).thenReturn("Apply");
    KeyFunctionMatch keyFunctionMatch =
        new Builder()
            .firstKeyFunction(mock(Function.class))
            .secondKeyFunction(secondKeyFunction)
            .build();

    ArrayList<Object> objectList = new ArrayList<>();
    objectList.add("42");

    Join<Object> operation = mock(Join.class);
    when(operation.isFlatten()).thenReturn(true);
    when(operation.getOperation()).thenReturn(mock(OperationImpl.class));
    Mockito.<Iterable<?>>when(operation.getInput()).thenReturn(objectList);
    when(operation.getMatchKey()).thenReturn(MatchKey.RIGHT);
    when(operation.getMatchMethod()).thenReturn(keyFunctionMatch);
    when(operation.getCollectionLimit()).thenReturn(1);
    when(operation.getJoinType()).thenReturn(JoinType.FULL);
    Context context = new Context();

    TestAddToGraphLibraryImpl store = mock(TestAddToGraphLibraryImpl.class);
    doNothing().when(store).execute(Mockito.<Operation>any(), Mockito.<Context>any());

    // Act
    Iterable<? extends MapTuple> actualDoOperationResult =
        joinHandler.doOperation(operation, context, store);
    Iterator<? extends MapTuple> actualIteratorResult = actualDoOperationResult.iterator();

    // Assert
    verify(secondKeyFunction).apply(isA(Object.class));
    verify(operation, atLeast(1)).getCollectionLimit();
    verify(operation, atLeast(1)).getInput();
    verify(operation, atLeast(1)).getJoinType();
    verify(operation).getMatchKey();
    verify(operation, atLeast(1)).getMatchMethod();
    verify(operation, atLeast(1)).getOperation();
    verify(operation).isFlatten();
    verify(store).execute(isA(Operation.class), isA(Context.class));
    assertTrue(actualDoOperationResult instanceof List);
    assertFalse(actualIteratorResult.hasNext());
    assertTrue(((List<? extends MapTuple>) actualDoOperationResult).isEmpty());
  }

  /**
   * Test {@link JoinHandler#doOperation(Join, Context, Store)} with {@code Join}, {@code Context},
   * {@code Store}.
   *
   * <ul>
   *   <li>Then return first Values {@code LEFT} is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link JoinHandler#doOperation(Join, Context, Store)}
   */
  @Test
  @DisplayName(
      "Test doOperation(Join, Context, Store) with 'Join', 'Context', 'Store'; then return first Values 'LEFT' is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Iterable JoinHandler.doOperation(Join, Context, Store)"})
  void testDoOperationWithJoinContextStore_thenReturnFirstValuesLeftIs42()
      throws OperationException {
    // Arrange
    JoinHandler<Object> joinHandler = new JoinHandler<>();

    Join<Object> operation = mock(Join.class);
    when(operation.isFlatten()).thenReturn(true);
    when(operation.getOperation()).thenReturn(mock(OperationImpl.class));

    ArrayList<Object> objectList = new ArrayList<>();
    objectList.add("42");
    Mockito.<Iterable<?>>when(operation.getInput()).thenReturn(objectList);
    when(operation.getMatchKey()).thenReturn(MatchKey.LEFT);

    Builder builder = new Builder();

    Function firstKeyFunction = mock(Function.class);
    when(firstKeyFunction.apply(Mockito.<Object>any())).thenReturn("Apply");
    when(operation.getMatchMethod())
        .thenReturn(
            builder
                .firstKeyFunction(firstKeyFunction)
                .secondKeyFunction(mock(Function.class))
                .build());
    when(operation.getCollectionLimit()).thenReturn(1);
    when(operation.getJoinType()).thenReturn(JoinType.FULL);
    Context context = new Context();

    TestAddToGraphLibraryImpl store = mock(TestAddToGraphLibraryImpl.class);
    doNothing().when(store).execute(Mockito.<Operation>any(), Mockito.<Context>any());

    // Act
    Iterable<? extends MapTuple> actualDoOperationResult =
        joinHandler.doOperation(operation, context, store);
    Iterator<? extends MapTuple> actualIteratorResult = actualDoOperationResult.iterator();

    // Assert
    assertTrue(actualDoOperationResult instanceof List);
    assertEquals(1, ((List<? extends MapTuple>) actualDoOperationResult).size());
    MapTuple getResult = ((List<? extends MapTuple>) actualDoOperationResult).get(0);
    Map values = getResult.getValues();
    assertEquals(2, values.size());
    Object actualGetResult = values.get("LEFT");
    assertEquals("42", actualGetResult);
    assertNull(values.get("RIGHT"));
    Iterator<Object> iteratorResult = getResult.iterator();
    Object nextResult = iteratorResult.next();
    Object actualNextResult = iteratorResult.next();
    assertFalse(iteratorResult.hasNext());
    assertEquals("42", nextResult);
    assertNull(actualNextResult);
    Iterable<Object> valuesResult = getResult.values();
    assertTrue(valuesResult instanceof Collection);
    assertEquals(2, ((Collection<Object>) valuesResult).size());
    verify(operation).isFlatten();
    verify(operation, atLeast(1)).getCollectionLimit();
    verify(operation, atLeast(1)).getInput();
    verify(operation, atLeast(1)).getOperation();
    verify(operation, atLeast(1)).getMatchMethod();
    verify(operation).getMatchKey();
    verify(operation, atLeast(1)).getJoinType();
    verify(firstKeyFunction).apply(isA(Object.class));
    verify(store).execute(isA(Operation.class), isA(Context.class));
    MapTuple actualNextResult2 = actualIteratorResult.next();
    assertFalse(actualIteratorResult.hasNext());
    assertSame(getResult, actualNextResult2);
  }

  /**
   * Test {@link JoinHandler#getOperationFromJoin(Join)}.
   *
   * <ul>
   *   <li>When {@link Join} (default constructor).
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link JoinHandler#getOperationFromJoin(Join)}
   */
  @Test
  @DisplayName(
      "Test getOperationFromJoin(Join); when Join (default constructor); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Operation JoinHandler.getOperationFromJoin(Join)"})
  void testGetOperationFromJoin_whenJoin_thenReturnNull() {
    // Arrange
    JoinHandler<Object> joinHandler = new JoinHandler<>();

    // Act and Assert
    assertNull(joinHandler.getOperationFromJoin(new Join<>()));
  }
}
