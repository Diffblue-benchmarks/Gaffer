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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.named.operation.AddNamedOperation;

class OperationChainDAODiffblueTest {
  /**
   * Test {@link OperationChainDAO#OperationChainDAO(OperationChain)}.
   * <p>
   * Method under test: {@link OperationChainDAO#OperationChainDAO(OperationChain)}
   */
  @Test
  @DisplayName("Test new OperationChainDAO(OperationChain)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void OperationChainDAO.<init>(OperationChain)"})
  void testNewOperationChainDAO() {
    // Arrange
    OperationChain<?> operationChain = new OperationChain<>();

    // Act and Assert
    assertEquals(operationChain, new OperationChainDAO<>(operationChain));
  }

  /**
   * Test {@link OperationChainDAO#OperationChainDAO(List)}.
   * <ul>
   *   <li>Given {@link AddNamedOperation} (default constructor).</li>
   *   <li>Then return array length is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationChainDAO#OperationChainDAO(List)}
   */
  @Test
  @DisplayName("Test new OperationChainDAO(List); given AddNamedOperation (default constructor); then return array length is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void OperationChainDAO.<init>(List)"})
  void testNewOperationChainDAO_givenAddNamedOperation_thenReturnArrayLengthIsOne() {
    // Arrange
    ArrayList<Operation> operations = new ArrayList<>();
    AddNamedOperation addNamedOperation = new AddNamedOperation();
    operations.add(addNamedOperation);

    // Act
    OperationChainDAO<Object> actualOperationChainDAO = new OperationChainDAO<>(operations);

    // Assert
    Operation[] operationArray = actualOperationChainDAO.getOperationArray();
    assertEquals(1, operationArray.length);
    assertEquals(operations, actualOperationChainDAO.getOperations());
    assertSame(addNamedOperation, operationArray[0]);
  }

  /**
   * Test {@link OperationChainDAO#OperationChainDAO(List)}.
   * <ul>
   *   <li>Given {@link AddNamedOperation} (default constructor).</li>
   *   <li>Then return Operations size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationChainDAO#OperationChainDAO(List)}
   */
  @Test
  @DisplayName("Test new OperationChainDAO(List); given AddNamedOperation (default constructor); then return Operations size is two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void OperationChainDAO.<init>(List)"})
  void testNewOperationChainDAO_givenAddNamedOperation_thenReturnOperationsSizeIsTwo() {
    // Arrange
    ArrayList<Operation> operations = new ArrayList<>();
    operations.add(new AddNamedOperation());
    AddNamedOperation addNamedOperation = new AddNamedOperation();
    operations.add(addNamedOperation);

    // Act
    OperationChainDAO<Object> actualOperationChainDAO = new OperationChainDAO<>(operations);

    // Assert
    List<Operation> operations2 = actualOperationChainDAO.getOperations();
    assertEquals(2, operations2.size());
    Operation[] operationArray = actualOperationChainDAO.getOperationArray();
    assertEquals(2, operationArray.length);
    assertSame(addNamedOperation, operations2.get(1));
    assertSame(addNamedOperation, operationArray[1]);
  }

  /**
   * Test {@link OperationChainDAO#getClassName()}.
   * <p>
   * Method under test: {@link OperationChainDAO#getClassName()}
   */
  @Test
  @DisplayName("Test getClassName()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String OperationChainDAO.getClassName()"})
  void testGetClassName() {
    // Arrange
    OperationChainDAO<Object> operationChainDAO = new OperationChainDAO<>();

    // Act and Assert
    assertNull(operationChainDAO.getClassName());
  }

  /**
   * Test {@link OperationChainDAO#setClassName(String)}.
   * <ul>
   *   <li>When {@code Class Name}.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationChainDAO#setClassName(String)}
   */
  @Test
  @DisplayName("Test setClassName(String); when 'Class Name'; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void OperationChainDAO.setClassName(String)"})
  void testSetClassName_whenClassName_thenThrowIllegalArgumentException() {
    // Arrange
    OperationChainDAO<Object> operationChainDAO = new OperationChainDAO<>();

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> operationChainDAO.setClassName("Class Name"));
  }
}
