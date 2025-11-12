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

package uk.gov.gchq.gaffer.store.operation.declaration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.mock;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.operation.Operation;
import uk.gov.gchq.gaffer.store.operation.handler.OperationHandler;

class OperationDeclarationDiffblueTest {
  /**
   * Method under test: {@link OperationDeclaration.Builder#build()}
   */
  @Test
  void testBuilderBuild() {
    // Arrange
    OperationDeclaration.Builder handlerResult = (new OperationDeclaration.Builder())
        .handler(mock(OperationHandler.class));
    Class<Operation> operation = Operation.class;

    // Act
    OperationDeclaration actualBuildResult = handlerResult.operation(operation).build();

    // Assert
    Class<Operation> expectedOperation = Operation.class;
    Class<? extends Operation> operation2 = actualBuildResult.getOperation();
    assertEquals(expectedOperation, operation2);
    assertSame(operation, operation2);
  }

  /**
   * Method under test:
   * {@link OperationDeclaration.Builder#handler(OperationHandler)}
   */
  @Test
  void testBuilderHandler() {
    // Arrange
    OperationDeclaration.Builder builder = new OperationDeclaration.Builder();

    // Act and Assert
    assertSame(builder, builder.handler(mock(OperationHandler.class)));
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link OperationDeclaration.Builder}
   */
  @Test
  void testBuilderNewBuilder() {
    // Arrange, Act and Assert
    OperationDeclaration buildResult = (new OperationDeclaration.Builder()).build();
    assertNull(buildResult.getOperation());
    assertNull(buildResult.getHandler());
  }

  /**
   * Method under test: {@link OperationDeclaration.Builder#operation(Class)}
   */
  @Test
  void testBuilderOperation() {
    // Arrange
    OperationDeclaration.Builder builder = new OperationDeclaration.Builder();
    Class<Operation> operation = Operation.class;

    // Act and Assert
    assertSame(builder, builder.operation(operation));
  }

  /**
   * Method under test: {@link OperationDeclaration.Builder#operation(Class)}
   */
  @Test
  void testBuilderOperation2() {
    // Arrange
    OperationDeclaration.Builder builder = new OperationDeclaration.Builder();
    builder.handler(mock(OperationHandler.class));
    Class<Operation> operation = Operation.class;

    // Act and Assert
    assertSame(builder, builder.operation(operation));
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link OperationDeclaration}
   *   <li>{@link OperationDeclaration#setHandler(OperationHandler)}
   *   <li>{@link OperationDeclaration#setOperation(Class)}
   *   <li>{@link OperationDeclaration#getHandler()}
   *   <li>{@link OperationDeclaration#getOperation()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    OperationDeclaration actualOperationDeclaration = new OperationDeclaration();
    OperationHandler handler = mock(OperationHandler.class);
    actualOperationDeclaration.setHandler(handler);
    Class<Operation> operation = Operation.class;
    actualOperationDeclaration.setOperation(operation);
    OperationHandler actualHandler = actualOperationDeclaration.getHandler();
    Class<? extends Operation> actualOperation = actualOperationDeclaration.getOperation();

    // Assert that nothing has changed
    Class<Operation> expectedOperation = Operation.class;
    assertEquals(expectedOperation, actualOperation);
    assertSame(operation, actualOperation);
    assertSame(handler, actualHandler);
  }
}
