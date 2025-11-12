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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.operation.OperationException;
import uk.gov.gchq.gaffer.operation.impl.SetVariable;
import uk.gov.gchq.gaffer.store.Context;
import uk.gov.gchq.gaffer.store.Store;

class SetVariableHandlerDiffblueTest {
  /**
   * Method under test:
   * {@link SetVariableHandler#doOperation(SetVariable, Context, Store)}
   */
  @Test
  void testDoOperation() throws OperationException {
    // Arrange
    SetVariableHandler setVariableHandler = new SetVariableHandler();
    SetVariable operation = new SetVariable();

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> setVariableHandler.doOperation(operation, new Context(), null));
  }

  /**
   * Method under test:
   * {@link SetVariableHandler#doOperation(SetVariable, Context, Store)}
   */
  @Test
  void testDoOperation2() throws OperationException {
    // Arrange
    SetVariableHandler setVariableHandler = new SetVariableHandler();

    SetVariable operation = new SetVariable();
    operation.setVariableName("Operation");
    operation.setInput(null);

    Context context = new Context();
    context.setVariables(null);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> setVariableHandler.doOperation(operation, context, null));
  }

  /**
   * Method under test:
   * {@link SetVariableHandler#doOperation(SetVariable, Context, Store)}
   */
  @Test
  void testDoOperation3() throws OperationException {
    // Arrange
    SetVariableHandler setVariableHandler = new SetVariableHandler();

    SetVariable operation = new SetVariable();
    operation.setVariableName("Operation");
    operation.setInput("Operation");

    Context context = new Context();
    context.setVariables(null);

    // Act
    Void actualDoOperationResult = setVariableHandler.doOperation(operation, context, null);

    // Assert
    Map<String, Object> variables = context.getVariables();
    assertEquals(1, variables.size());
    assertEquals("Operation", variables.get("Operation"));
    assertNull(actualDoOperationResult);
  }

  /**
   * Method under test:
   * {@link SetVariableHandler#doOperation(SetVariable, Context, Store)}
   */
  @Test
  void testDoOperation4() throws OperationException {
    // Arrange
    SetVariableHandler setVariableHandler = new SetVariableHandler();

    SetVariable operation = new SetVariable();
    operation.setVariableName("Operation");
    operation.setInput("Operation");

    Context context = new Context();
    HashMap<String, Object> variables = new HashMap<>();
    context.setVariables(variables);

    // Act
    Void actualDoOperationResult = setVariableHandler.doOperation(operation, context, null);

    // Assert
    Map<String, Object> variables2 = context.getVariables();
    assertEquals(1, variables2.size());
    assertEquals("Operation", variables2.get("Operation"));
    assertNull(actualDoOperationResult);
    assertSame(variables, variables2);
  }

  /**
   * Method under test:
   * {@link SetVariableHandler#doOperation(SetVariable, Context, Store)}
   */
  @Test
  void testDoOperation5() throws OperationException {
    // Arrange
    SetVariableHandler setVariableHandler = new SetVariableHandler();

    SetVariable operation = new SetVariable();
    operation.setVariableName("Operation");
    operation.setInput("Operation");

    HashMap<String, Object> variables = new HashMap<>();
    variables.computeIfPresent("foo", mock(BiFunction.class));

    Context context = new Context();
    context.setVariables(variables);

    // Act
    Void actualDoOperationResult = setVariableHandler.doOperation(operation, context, null);

    // Assert
    Map<String, Object> variables2 = context.getVariables();
    assertEquals(1, variables2.size());
    assertEquals("Operation", variables2.get("Operation"));
    assertNull(actualDoOperationResult);
    assertSame(variables, variables2);
  }
}
