package uk.gov.gchq.gaffer.store.operation.handler;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.function.Function;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import uk.gov.gchq.gaffer.operation.OperationException;
import uk.gov.gchq.gaffer.operation.impl.Map;
import uk.gov.gchq.gaffer.store.Context;
import uk.gov.gchq.gaffer.store.Store;

class MapHandlerDiffblueTest {
  /**
   * Test {@link MapHandler#doOperation(Map, Context, Store)} with {@code Map}, {@code Context},
   * {@code Store}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.
   *   <li>Then return {@code Input}.
   * </ul>
   *
   * <p>Method under test: {@link MapHandler#doOperation(Map, Context, Store)}
   */
  @Test
  @DisplayName(
      "Test doOperation(Map, Context, Store) with 'Map', 'Context', 'Store'; given ArrayList(); then return 'Input'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object MapHandler.doOperation(Map, Context, Store)"})
  void testDoOperationWithMapContextStore_givenArrayList_thenReturnInput()
      throws OperationException {
    // Arrange
    MapHandler<Object, Object> mapHandler = new MapHandler<>();

    Map<Object, Object> operation = new Map<>();
    operation.setFunctions(new ArrayList<>());
    operation.setInput("Input");
    Context context = new Context();

    // Act and Assert
    assertEquals(
        "Input", mapHandler.doOperation(operation, context, new TestAddToGraphLibraryImpl()));
  }

  /**
   * Test {@link MapHandler#doOperation(Map, Context, Store)} with {@code Map}, {@code Context},
   * {@code Store}.
   *
   * <ul>
   *   <li>Given {@link Function} {@link Function#apply(Object)} return {@code Apply}.
   *   <li>Then return {@code Apply}.
   * </ul>
   *
   * <p>Method under test: {@link MapHandler#doOperation(Map, Context, Store)}
   */
  @Test
  @DisplayName(
      "Test doOperation(Map, Context, Store) with 'Map', 'Context', 'Store'; given Function apply(Object) return 'Apply'; then return 'Apply'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object MapHandler.doOperation(Map, Context, Store)"})
  void testDoOperationWithMapContextStore_givenFunctionApplyReturnApply_thenReturnApply()
      throws OperationException {
    // Arrange
    MapHandler<Object, Object> mapHandler = new MapHandler<>();

    Function function = mock(Function.class);
    when(function.apply(Mockito.<Object>any())).thenReturn("Apply");

    Map<Object, Object> operation = new Map<>();
    operation.setFunction(function);
    operation.setInput("Input");
    Context context = new Context();

    // Act
    Object actualDoOperationResult =
        mapHandler.doOperation(operation, context, new TestAddToGraphLibraryImpl());

    // Assert
    verify(function).apply(isA(Object.class));
    assertEquals("Apply", actualDoOperationResult);
  }

  /**
   * Test {@link MapHandler#doOperation(Map, Context, Store)} with {@code Map}, {@code Context},
   * {@code Store}.
   *
   * <ul>
   *   <li>When {@link Map#Map()}.
   *   <li>Then throw {@link OperationException}.
   * </ul>
   *
   * <p>Method under test: {@link MapHandler#doOperation(Map, Context, Store)}
   */
  @Test
  @DisplayName(
      "Test doOperation(Map, Context, Store) with 'Map', 'Context', 'Store'; when Map(); then throw OperationException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object MapHandler.doOperation(Map, Context, Store)"})
  void testDoOperationWithMapContextStore_whenMap_thenThrowOperationException()
      throws OperationException {
    // Arrange
    MapHandler<Object, Object> mapHandler = new MapHandler<>();
    Map<Object, Object> operation = new Map<>();
    Context context = new Context();

    // Act and Assert
    assertThrows(
        OperationException.class,
        () -> mapHandler.doOperation(operation, context, new TestAddToGraphLibraryImpl()));
  }

  /**
   * Test {@link MapHandler#doOperation(Map, Context, Store)} with {@code Map}, {@code Context},
   * {@code Store}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then throw {@link OperationException}.
   * </ul>
   *
   * <p>Method under test: {@link MapHandler#doOperation(Map, Context, Store)}
   */
  @Test
  @DisplayName(
      "Test doOperation(Map, Context, Store) with 'Map', 'Context', 'Store'; when 'null'; then throw OperationException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object MapHandler.doOperation(Map, Context, Store)"})
  void testDoOperationWithMapContextStore_whenNull_thenThrowOperationException()
      throws OperationException {
    // Arrange
    MapHandler<Object, Object> mapHandler = new MapHandler<>();
    Context context = new Context();

    // Act and Assert
    assertThrows(
        OperationException.class,
        () -> mapHandler.doOperation(null, context, new TestAddToGraphLibraryImpl()));
  }
}
