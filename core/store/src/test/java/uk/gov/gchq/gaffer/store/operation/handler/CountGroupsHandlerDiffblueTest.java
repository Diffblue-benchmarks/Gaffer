package uk.gov.gchq.gaffer.store.operation.handler;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.data.GroupCounts;
import uk.gov.gchq.gaffer.operation.OperationException;
import uk.gov.gchq.gaffer.operation.impl.CountGroups;
import uk.gov.gchq.gaffer.store.Context;
import uk.gov.gchq.gaffer.store.Store;

class CountGroupsHandlerDiffblueTest {
  /**
   * Test {@link CountGroupsHandler#doOperation(CountGroups, Context, Store)} with {@code
   * CountGroups}, {@code Context}, {@code Store}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link CountGroupsHandler#doOperation(CountGroups, Context, Store)}
   */
  @Test
  @DisplayName(
      "Test doOperation(CountGroups, Context, Store) with 'CountGroups', 'Context', 'Store'; given ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"GroupCounts CountGroupsHandler.doOperation(CountGroups, Context, Store)"})
  void testDoOperationWithCountGroupsContextStore_givenArrayList() throws OperationException {
    // Arrange
    CountGroupsHandler countGroupsHandler = new CountGroupsHandler();

    CountGroups operation = new CountGroups(null);
    operation.setInput(new ArrayList<>());
    Context context = new Context();

    // Act
    GroupCounts actualDoOperationResult =
        countGroupsHandler.doOperation(operation, context, new TestAddToGraphLibraryImpl());

    // Assert
    assertFalse(actualDoOperationResult.isLimitHit());
    assertTrue(actualDoOperationResult.getEdgeGroups().isEmpty());
    assertTrue(actualDoOperationResult.getEntityGroups().isEmpty());
  }

  /**
   * Test {@link CountGroupsHandler#doOperation(CountGroups, Context, Store)} with {@code
   * CountGroups}, {@code Context}, {@code Store}.
   *
   * <ul>
   *   <li>When {@link CountGroups#CountGroups()}.
   * </ul>
   *
   * <p>Method under test: {@link CountGroupsHandler#doOperation(CountGroups, Context, Store)}
   */
  @Test
  @DisplayName(
      "Test doOperation(CountGroups, Context, Store) with 'CountGroups', 'Context', 'Store'; when CountGroups()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"GroupCounts CountGroupsHandler.doOperation(CountGroups, Context, Store)"})
  void testDoOperationWithCountGroupsContextStore_whenCountGroups() throws OperationException {
    // Arrange
    CountGroupsHandler countGroupsHandler = new CountGroupsHandler();
    CountGroups operation = new CountGroups();
    Context context = new Context();

    // Act
    GroupCounts actualDoOperationResult =
        countGroupsHandler.doOperation(operation, context, new TestAddToGraphLibraryImpl());

    // Assert
    assertFalse(actualDoOperationResult.isLimitHit());
    assertTrue(actualDoOperationResult.getEdgeGroups().isEmpty());
    assertTrue(actualDoOperationResult.getEntityGroups().isEmpty());
  }
}
