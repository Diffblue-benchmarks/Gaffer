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

package uk.gov.gchq.gaffer.store.operation.handler.util;

import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.operation.Operation;
import uk.gov.gchq.gaffer.operation.OperationChain;
import uk.gov.gchq.gaffer.operation.impl.DiscardOutput;
import uk.gov.gchq.gaffer.store.operation.DeleteAllData;

class OperationHandlerUtilDiffblueTest {
  /**
   * Method under test:
   * {@link OperationHandlerUtil#updateOperationInput(Operation, Object)}
   */
  @Test
  void testUpdateOperationInput() {
    // Arrange
    OperationChain<Object> operation = mock(OperationChain.class);
    when(operation.getOperations()).thenReturn(new ArrayList<>());

    // Act
    OperationHandlerUtil.updateOperationInput(operation, "Input");

    // Assert
    verify(operation).getOperations();
  }

  /**
   * Method under test:
   * {@link OperationHandlerUtil#updateOperationInput(Operation, Object)}
   */
  @Test
  void testUpdateOperationInput2() {
    // Arrange
    ArrayList<Operation> operationList = new ArrayList<>();
    operationList.add(new DeleteAllData());
    OperationChain<Object> operation = mock(OperationChain.class);
    when(operation.getOperations()).thenReturn(operationList);

    // Act
    OperationHandlerUtil.updateOperationInput(operation, "Input");

    // Assert
    verify(operation, atLeast(1)).getOperations();
  }

  /**
   * Method under test:
   * {@link OperationHandlerUtil#updateOperationInput(Operation, Object)}
   */
  @Test
  void testUpdateOperationInput3() {
    // Arrange
    ArrayList<Operation> operationList = new ArrayList<>();
    operationList.add(new OperationChain<>());
    OperationChain<Object> operation = mock(OperationChain.class);
    when(operation.getOperations()).thenReturn(operationList);

    // Act
    OperationHandlerUtil.updateOperationInput(operation, "Input");

    // Assert
    verify(operation, atLeast(1)).getOperations();
  }

  /**
   * Method under test:
   * {@link OperationHandlerUtil#updateOperationInput(Operation, Object)}
   */
  @Test
  void testUpdateOperationInput4() {
    // Arrange
    ArrayList<Operation> operationList = new ArrayList<>();
    operationList.add(new DiscardOutput());
    OperationChain<Object> operation = mock(OperationChain.class);
    when(operation.getOperations()).thenReturn(operationList);

    // Act
    OperationHandlerUtil.updateOperationInput(operation, "Input");

    // Assert
    verify(operation, atLeast(1)).getOperations();
  }
}
