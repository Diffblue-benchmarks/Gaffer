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

package uk.gov.gchq.gaffer.spark.operation.handler.graphframe;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
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
import uk.gov.gchq.gaffer.store.Context.Builder;
import uk.gov.gchq.gaffer.store.Store;
import uk.gov.gchq.gaffer.user.User;

class GetGraphFrameOfElementsHandlerDiffblueTest {
  /**
   * Test {@link GetGraphFrameOfElementsHandler#doOperation(GetGraphFrameOfElements, Context, Store)} with {@code GetGraphFrameOfElements}, {@code Context}, {@code Store}.
   * <p>
   * Method under test: {@link GetGraphFrameOfElementsHandler#doOperation(GetGraphFrameOfElements, Context, Store)}
   */
  @Test
  @DisplayName("Test doOperation(GetGraphFrameOfElements, Context, Store) with 'GetGraphFrameOfElements', 'Context', 'Store'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "org.graphframes.GraphFrame GetGraphFrameOfElementsHandler.doOperation(GetGraphFrameOfElements, Context, Store)"})
  void testDoOperationWithGetGraphFrameOfElementsContextStore() throws OperationException {
    // Arrange
    GetGraphFrameOfElementsHandler getGraphFrameOfElementsHandler = new GetGraphFrameOfElementsHandler();
    GetGraphFrameOfElements operation = new GetGraphFrameOfElements();

    Builder builder = new Builder();
    User user = (new User.Builder()).userId("42").build();
    Context context = builder.user(user).build();
    Store store = mock(Store.class);
    when(store.execute(Mockito.<Output<Dataset<Row>>>any(), Mockito.<Context>any()))
        .thenThrow(new OperationException("An error occurred"));

    // Act and Assert
    assertThrows(OperationException.class, () -> getGraphFrameOfElementsHandler.doOperation(operation, context, store));
    verify(store).execute(isA(Output.class), isA(Context.class));
  }
}
