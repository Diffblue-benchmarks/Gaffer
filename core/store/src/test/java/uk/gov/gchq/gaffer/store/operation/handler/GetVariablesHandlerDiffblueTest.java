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
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.nimbusds.jose.shaded.gson.internal.NonNullElementWrapperList;
import java.util.ArrayList;
import java.util.Map;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.operation.OperationException;
import uk.gov.gchq.gaffer.operation.impl.GetVariables;
import uk.gov.gchq.gaffer.store.Context;
import uk.gov.gchq.gaffer.store.Store;

class GetVariablesHandlerDiffblueTest {
  /**
   * Method under test:
   * {@link GetVariablesHandler#doOperation(GetVariables, Context, Store)}
   */
  @Test
  void testDoOperation() throws OperationException {
    // Arrange
    GetVariablesHandler getVariablesHandler = new GetVariablesHandler();
    GetVariables operation = new GetVariables();

    // Act and Assert
    assertTrue(getVariablesHandler.doOperation(operation, new Context(), null).isEmpty());
  }

  /**
   * Method under test:
   * {@link GetVariablesHandler#doOperation(GetVariables, Context, Store)}
   */
  @Test
  void testDoOperation2() throws OperationException {
    // Arrange
    GetVariablesHandler getVariablesHandler = new GetVariablesHandler();

    GetVariables operation = new GetVariables();
    operation.setVariableNames(new ArrayList<>());

    // Act and Assert
    assertTrue(getVariablesHandler.doOperation(operation, new Context(), null).isEmpty());
  }

  /**
   * Method under test:
   * {@link GetVariablesHandler#doOperation(GetVariables, Context, Store)}
   */
  @Test
  void testDoOperation3() throws OperationException {
    // Arrange
    GetVariablesHandler getVariablesHandler = new GetVariablesHandler();

    ArrayList<String> variableNames = new ArrayList<>();
    variableNames.add(null);

    GetVariables operation = new GetVariables();
    operation.setVariableNames(variableNames);

    // Act and Assert
    assertTrue(getVariablesHandler.doOperation(operation, new Context(), null).isEmpty());
  }

  /**
   * Method under test:
   * {@link GetVariablesHandler#doOperation(GetVariables, Context, Store)}
   */
  @Test
  void testDoOperation4() throws OperationException {
    // Arrange
    GetVariablesHandler getVariablesHandler = new GetVariablesHandler();

    ArrayList<String> variableNames = new ArrayList<>();
    variableNames.add("Operation");

    GetVariables operation = new GetVariables();
    operation.setVariableNames(variableNames);

    // Act
    Map<String, Object> actualDoOperationResult = getVariablesHandler.doOperation(operation, new Context(), null);

    // Assert
    assertEquals(1, actualDoOperationResult.size());
    assertNull(actualDoOperationResult.get("Operation"));
  }

  /**
   * Method under test:
   * {@link GetVariablesHandler#doOperation(GetVariables, Context, Store)}
   */
  @Test
  void testDoOperation5() throws OperationException {
    // Arrange
    GetVariablesHandler getVariablesHandler = new GetVariablesHandler();
    NonNullElementWrapperList<String> variableNames = mock(NonNullElementWrapperList.class);

    ArrayList<String> stringList = new ArrayList<>();
    when(variableNames.iterator()).thenReturn(stringList.iterator());

    GetVariables operation = new GetVariables();
    operation.setVariableNames(variableNames);

    // Act
    Map<String, Object> actualDoOperationResult = getVariablesHandler.doOperation(operation, new Context(), null);

    // Assert
    verify(variableNames).iterator();
    assertTrue(actualDoOperationResult.isEmpty());
  }
}
