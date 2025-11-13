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
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.operation.Operation;
import uk.gov.gchq.gaffer.store.operation.declaration.OperationDeclaration.Builder;
import uk.gov.gchq.gaffer.store.operation.handler.OperationHandler;

class OperationDeclarationDiffblueTest {
  /**
   * Test Builder {@link Builder#build()}.
   * <p>
   * Method under test: {@link Builder#build()}
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"OperationDeclaration Builder.build()"})
  void testBuilderBuild() {
    // Arrange
    Builder handlerResult = (new Builder()).handler(mock(OperationHandler.class));
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
   * Test Builder {@link Builder#handler(OperationHandler)}.
   * <p>
   * Method under test: {@link Builder#handler(OperationHandler)}
   */
  @Test
  @DisplayName("Test Builder handler(OperationHandler)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.handler(OperationHandler)"})
  void testBuilderHandler() {
    // Arrange
    Builder builder = new Builder();

    // Act and Assert
    assertSame(builder, builder.handler(mock(OperationHandler.class)));
  }

  /**
   * Test Builder new {@link Builder} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of {@link Builder}
   */
  @Test
  @DisplayName("Test Builder new Builder (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Builder.<init>()"})
  void testBuilderNewBuilder() {
    // Arrange, Act and Assert
    OperationDeclaration buildResult = (new Builder()).build();
    assertNull(buildResult.getOperation());
    assertNull(buildResult.getHandler());
  }

  /**
   * Test Builder {@link Builder#operation(Class)}.
   * <p>
   * Method under test: {@link Builder#operation(Class)}
   */
  @Test
  @DisplayName("Test Builder operation(Class)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.operation(Class)"})
  void testBuilderOperation() {
    // Arrange
    Builder builder = new Builder();
    Class<Operation> operation = Operation.class;

    // Act and Assert
    assertSame(builder, builder.operation(operation));
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link OperationDeclaration}
   *   <li>{@link OperationDeclaration#setHandler(OperationHandler)}
   *   <li>{@link OperationDeclaration#setOperation(Class)}
   *   <li>{@link OperationDeclaration#toString()}
   *   <li>{@link OperationDeclaration#getHandler()}
   *   <li>{@link OperationDeclaration#getOperation()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void OperationDeclaration.<init>()", "OperationHandler OperationDeclaration.getHandler()",
      "Class OperationDeclaration.getOperation()", "void OperationDeclaration.setHandler(OperationHandler)",
      "void OperationDeclaration.setOperation(Class)", "java.lang.String OperationDeclaration.toString()"})
  void testGettersAndSetters() {
    // Arrange and Act
    OperationDeclaration actualOperationDeclaration = new OperationDeclaration();
    OperationHandler handler = mock(OperationHandler.class);
    actualOperationDeclaration.setHandler(handler);
    Class<Operation> operation = Operation.class;
    actualOperationDeclaration.setOperation(operation);
    actualOperationDeclaration.toString();
    OperationHandler actualHandler = actualOperationDeclaration.getHandler();
    Class<? extends Operation> actualOperation = actualOperationDeclaration.getOperation();

    // Assert
    Class<Operation> expectedOperation = Operation.class;
    assertEquals(expectedOperation, actualOperation);
    assertSame(operation, actualOperation);
    assertSame(handler, actualHandler);
  }
}
