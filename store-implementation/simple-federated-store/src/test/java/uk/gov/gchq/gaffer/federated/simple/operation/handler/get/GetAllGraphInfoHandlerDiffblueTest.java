package uk.gov.gchq.gaffer.federated.simple.operation.handler.get;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.federated.simple.FederatedStore;
import uk.gov.gchq.gaffer.federated.simple.operation.GetAllGraphInfo;
import uk.gov.gchq.gaffer.operation.OperationException;
import uk.gov.gchq.gaffer.store.Context;
import uk.gov.gchq.gaffer.store.Store;

class GetAllGraphInfoHandlerDiffblueTest {
  /**
   * Test {@link GetAllGraphInfoHandler#doOperation(GetAllGraphInfo, Context, Store)} with {@code
   * GetAllGraphInfo}, {@code Context}, {@code Store}.
   *
   * <ul>
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link GetAllGraphInfoHandler#doOperation(GetAllGraphInfo, Context,
   * Store)}
   */
  @Test
  @DisplayName(
      "Test doOperation(GetAllGraphInfo, Context, Store) with 'GetAllGraphInfo', 'Context', 'Store'; then return size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map GetAllGraphInfoHandler.doOperation(GetAllGraphInfo, Context, Store)"})
  void testDoOperationWithGetAllGraphInfoContextStore_thenReturnSizeIsOne()
      throws OperationException {
    // Arrange
    GetAllGraphInfoHandler getAllGraphInfoHandler = new GetAllGraphInfoHandler();
    GetAllGraphInfo operation = new GetAllGraphInfo();
    Context context = new Context();

    FederatedStore store = mock(FederatedStore.class);
    when(store.getAllGraphsAndAccess()).thenReturn(new ArrayList<>());
    ArrayList<String> stringList = new ArrayList<>();
    when(store.getDefaultGraphIds()).thenReturn(stringList);

    // Act
    Map<String, Object> actualDoOperationResult =
        getAllGraphInfoHandler.doOperation(operation, context, store);

    // Assert
    verify(store).getAllGraphsAndAccess();
    verify(store).getDefaultGraphIds();
    assertEquals(1, actualDoOperationResult.size());
    Object getResult = actualDoOperationResult.get(GetAllGraphInfoHandler.DEFAULT_GRAPH_IDS);
    assertTrue(getResult instanceof List);
    assertTrue(((List<Object>) getResult).isEmpty());
    assertSame(stringList, getResult);
  }
}
