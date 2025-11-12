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

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.operation.OperationChain;
import uk.gov.gchq.gaffer.operation.OperationException;
import uk.gov.gchq.gaffer.store.Context;
import uk.gov.gchq.gaffer.store.Store;
import uk.gov.gchq.gaffer.store.operation.OperationChainValidator;
import uk.gov.gchq.gaffer.store.optimiser.OperationChainOptimiser;

class OperationChainHandlerDiffblueTest {
  /**
   * Method under test:
   * {@link OperationChainHandler#doOperation(OperationChain, Context, Store)}
   */
  @Test
  void testDoOperation() throws OperationException {
    // Arrange
    OperationChainValidator opChainValidator = new OperationChainValidator(null);
    OperationChainHandler<Object> operationChainHandler = new OperationChainHandler<>(opChainValidator,
        new ArrayList<>());
    OperationChain<Object> operationChain = new OperationChain<>();

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> operationChainHandler.doOperation(operationChain, new Context(), null));
  }

  /**
   * Method under test:
   * {@link OperationChainHandler#doOperation(OperationChain, Context, Store)}
   */
  @Test
  void testDoOperation2() throws OperationException {
    // Arrange
    ArrayList<OperationChainOptimiser> opChainOptimisers = new ArrayList<>();
    opChainOptimisers.add(mock(OperationChainOptimiser.class));
    OperationChainHandler<Object> operationChainHandler = new OperationChainHandler<>(new OperationChainValidator(null),
        opChainOptimisers);
    OperationChain<Object> operationChain = new OperationChain<>();

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> operationChainHandler.doOperation(operationChain, new Context(), null));
  }

  /**
   * Method under test:
   * {@link OperationChainHandler#prepareOperationChain(OperationChain, Context, Store)}
   */
  @Test
  void testPrepareOperationChain() {
    // Arrange
    OperationChainValidator opChainValidator = new OperationChainValidator(null);
    OperationChainHandler<Object> operationChainHandler = new OperationChainHandler<>(opChainValidator,
        new ArrayList<>());
    OperationChain<Object> operationChain = new OperationChain<>();

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> operationChainHandler.prepareOperationChain(operationChain, new Context(), null));
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>
   * {@link OperationChainHandler#OperationChainHandler(OperationChainValidator, List)}
   *   <li>{@link OperationChainHandler#getOpChainOptimisers()}
   *   <li>{@link OperationChainHandler#getOpChainValidator()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange
    OperationChainValidator opChainValidator = new OperationChainValidator(null);
    ArrayList<OperationChainOptimiser> opChainOptimisers = new ArrayList<>();

    // Act
    OperationChainHandler<Object> actualOperationChainHandler = new OperationChainHandler<>(opChainValidator,
        opChainOptimisers);
    List<OperationChainOptimiser> actualOpChainOptimisers = actualOperationChainHandler.getOpChainOptimisers();
    OperationChainValidator actualOpChainValidator = actualOperationChainHandler.getOpChainValidator();

    // Assert
    assertTrue(actualOpChainOptimisers.isEmpty());
    assertSame(opChainOptimisers, actualOpChainOptimisers);
    assertSame(opChainValidator, actualOpChainValidator);
  }
}
