package uk.gov.gchq.gaffer.spark.operation.handler.graphframe;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import uk.gov.gchq.gaffer.operation.OperationException;
import uk.gov.gchq.gaffer.operation.io.Output;
import uk.gov.gchq.gaffer.spark.operation.graphframe.GetGraphFrameOfElements;
import uk.gov.gchq.gaffer.store.Context;
import uk.gov.gchq.gaffer.store.Store;

class GetGraphFrameOfElementsHandlerDiffblueTest {
  /**
   * Test {@link GetGraphFrameOfElementsHandler#doOperation(GetGraphFrameOfElements, Context,
   * Store)} with {@code GetGraphFrameOfElements}, {@code Context}, {@code Store}.
   *
   * <p>Method under test: {@link
   * GetGraphFrameOfElementsHandler#doOperation(GetGraphFrameOfElements, Context, Store)}
   */
  @Test
  @DisplayName(
      "Test doOperation(GetGraphFrameOfElements, Context, Store) with 'GetGraphFrameOfElements', 'Context', 'Store'")
  @Tag("MaintainedByDiffblue")
  void testDoOperationWithGetGraphFrameOfElementsContextStore() throws OperationException {
    // Arrange
    GetGraphFrameOfElementsHandler getGraphFrameOfElementsHandler =
        new GetGraphFrameOfElementsHandler();
    GetGraphFrameOfElements operation = new GetGraphFrameOfElements();
    Context context = new Context();

    Store store = mock(Store.class);
    when(store.execute(Mockito.<Output<Dataset<Row>>>any(), Mockito.<Context>any()))
        .thenThrow(new OperationException("An error occurred"));

    // Act and Assert
    assertThrows(
        OperationException.class,
        () -> getGraphFrameOfElementsHandler.doOperation(operation, context, store));
    verify(store).execute(isA(Output.class), isA(Context.class));
  }
}
