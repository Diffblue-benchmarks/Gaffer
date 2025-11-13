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

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.named.operation.NamedOperation;
import uk.gov.gchq.gaffer.operation.Operation;

class OperationHandlerUtilDiffblueTest {
  /**
   * Test {@link OperationHandlerUtil#updateOperationInput(Operation, Object)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.</li>
   *   <li>When {@link NamedOperation} (default constructor) Input is {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationHandlerUtil#updateOperationInput(Operation, Object)}
   */
  @Test
  @DisplayName("Test updateOperationInput(Operation, Object); given ArrayList(); when NamedOperation (default constructor) Input is ArrayList()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void OperationHandlerUtil.updateOperationInput(Operation, Object)"})
  void testUpdateOperationInput_givenArrayList_whenNamedOperationInputIsArrayList() {
    // Arrange
    NamedOperation<Object, Object> operation = new NamedOperation<>();
    ArrayList<Object> input = new ArrayList<>();
    operation.setInput(input);

    // Act
    OperationHandlerUtil.updateOperationInput(operation, "Input");

    // Assert that nothing has changed
    Iterable<?> input2 = operation.getInput();
    assertTrue(input2 instanceof List);
    assertTrue(((List<?>) input2).isEmpty());
    assertSame(input, input2);
  }

  /**
   * Test {@link OperationHandlerUtil#updateOperationInput(Operation, Object)}.
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>When {@link NamedOperation} (default constructor) Input is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationHandlerUtil#updateOperationInput(Operation, Object)}
   */
  @Test
  @DisplayName("Test updateOperationInput(Operation, Object); given 'null'; when NamedOperation (default constructor) Input is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void OperationHandlerUtil.updateOperationInput(Operation, Object)"})
  void testUpdateOperationInput_givenNull_whenNamedOperationInputIsNull() {
    // Arrange
    NamedOperation<Object, Object> operation = new NamedOperation<>();
    operation.setInput((Iterable<?>) null);
    ArrayList<Object> objectList = new ArrayList<>();

    // Act
    OperationHandlerUtil.updateOperationInput(operation, objectList);

    // Assert
    Iterable<?> input = operation.getInput();
    assertTrue(input instanceof List);
    assertTrue(((List<?>) input).isEmpty());
    assertSame(objectList, input);
  }
}
