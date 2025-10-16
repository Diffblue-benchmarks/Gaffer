package uk.gov.gchq.gaffer.store.operation.handler.output;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.operation.OperationException;
import uk.gov.gchq.gaffer.operation.impl.output.ToList;
import uk.gov.gchq.gaffer.store.Context;
import uk.gov.gchq.gaffer.store.Store;
import uk.gov.gchq.gaffer.store.operation.handler.TestAddToGraphLibraryImpl;

class ToListHandlerDiffblueTest {
  /**
   * Test {@link ToListHandler#doOperation(ToList, Context, Store)} with {@code ToList}, {@code
   * Context}, {@code Store}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link ToListHandler#doOperation(ToList, Context, Store)}
   */
  @Test
  @DisplayName(
      "Test doOperation(ToList, Context, Store) with 'ToList', 'Context', 'Store'; given ArrayList(); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.List ToListHandler.doOperation(ToList, Context, Store)"})
  void testDoOperationWithToListContextStore_givenArrayList_thenReturnEmpty()
      throws OperationException {
    // Arrange
    ToListHandler<Object> toListHandler = new ToListHandler<>();

    ToList<Object> operation = new ToList<>();
    operation.setInput(new ArrayList<>());
    Context context = new Context();

    // Act and Assert
    assertTrue(
        toListHandler.doOperation(operation, context, new TestAddToGraphLibraryImpl()).isEmpty());
  }

  /**
   * Test {@link ToListHandler#doOperation(ToList, Context, Store)} with {@code ToList}, {@code
   * Context}, {@code Store}.
   *
   * <ul>
   *   <li>When {@link ToList} (default constructor).
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ToListHandler#doOperation(ToList, Context, Store)}
   */
  @Test
  @DisplayName(
      "Test doOperation(ToList, Context, Store) with 'ToList', 'Context', 'Store'; when ToList (default constructor); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.List ToListHandler.doOperation(ToList, Context, Store)"})
  void testDoOperationWithToListContextStore_whenToList_thenReturnNull() throws OperationException {
    // Arrange
    ToListHandler<Object> toListHandler = new ToListHandler<>();
    ToList<Object> operation = new ToList<>();
    Context context = new Context();

    // Act and Assert
    assertNull(toListHandler.doOperation(operation, context, new TestAddToGraphLibraryImpl()));
  }
}
