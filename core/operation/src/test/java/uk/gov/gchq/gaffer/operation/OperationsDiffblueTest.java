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

package uk.gov.gchq.gaffer.operation;

import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.Collection;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class OperationsDiffblueTest {
  /**
   * Method under test: {@link Operations#updateOperations(Collection)}
   */
  @Test
  void testUpdateOperations() {
    // Arrange
    Operations<Operation> operations = mock(Operations.class);
    doNothing().when(operations).updateOperations(Mockito.<Collection<Operation>>any());

    // Act
    operations.updateOperations(new ArrayList<>());

    // Assert
    verify(operations).updateOperations(isA(Collection.class));
  }

  /**
   * Method under test: {@link Operations#getOperationsClass()}
   */
  @Test
  void testGetOperationsClass() {
    // Arrange
    Operations<Operation> operations = mock(Operations.class);
    Class<Operation> forNameResult = Operation.class;
    when(operations.getOperationsClass()).thenReturn(forNameResult);

    // Act
    operations.getOperationsClass();

    // Assert
    verify(operations).getOperationsClass();
  }
}
