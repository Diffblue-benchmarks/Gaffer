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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.operation.Operation;
import uk.gov.gchq.gaffer.operation.OperationChain;
import uk.gov.gchq.gaffer.operation.impl.If;

class OperationHandlerUtilDiffblueTest {
  /**
   * Test {@link OperationHandlerUtil#updateOperationInput(Operation, Object)}.
   *
   * <ul>
   *   <li>When {@link If} (default constructor) addOption {@code Name} and {@code 42}.
   *   <li>Then wrap {@link If} (default constructor) Operations size is one.
   * </ul>
   *
   * <p>Method under test: {@link OperationHandlerUtil#updateOperationInput(Operation, Object)}
   */
  @Test
  @DisplayName(
      "Test updateOperationInput(Operation, Object); when If (default constructor) addOption 'Name' and '42'; then wrap If (default constructor) Operations size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void OperationHandlerUtil.updateOperationInput(Operation, Object)"})
  void testUpdateOperationInput_whenIfAddOptionNameAnd42_thenWrapIfOperationsSizeIsOne() {
    // Arrange
    If<Object, Object> operation = new If<>();
    operation.addOption("Name", "42");
    OperationChain<Object> operation2 = OperationChain.wrap(operation);

    // Act
    OperationHandlerUtil.updateOperationInput(operation2, "Input");

    // Assert
    List<Operation> operations = operation2.getOperations();
    assertEquals(1, operations.size());
    Operation getResult = operations.get(0);
    assertTrue(getResult instanceof If);
    assertEquals("Input", ((If<Object, Object>) getResult).getInput());
  }
}
