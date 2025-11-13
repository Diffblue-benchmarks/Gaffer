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
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.operation.OperationChain;
import uk.gov.gchq.gaffer.operation.OperationException;
import uk.gov.gchq.gaffer.store.Context;
import uk.gov.gchq.gaffer.store.Store;
import uk.gov.gchq.gaffer.store.operation.DeleteAllData;
import uk.gov.gchq.gaffer.store.operation.OperationChainValidator;
import uk.gov.gchq.gaffer.store.optimiser.OperationChainOptimiser;
import uk.gov.gchq.gaffer.store.schema.ViewValidator;

class OperationChainHandlerDiffblueTest {
  /**
   * Test {@link OperationChainHandler#doOperation(OperationChain, Context, Store)} with {@code OperationChain}, {@code Context}, {@code Store}.
   * <p>
   * Method under test: {@link OperationChainHandler#doOperation(OperationChain, Context, Store)}
   */
  @Test
  @DisplayName("Test doOperation(OperationChain, Context, Store) with 'OperationChain', 'Context', 'Store'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object OperationChainHandler.doOperation(OperationChain, Context, Store)"})
  void testDoOperationWithOperationChainContextStore() throws OperationException {
    // Arrange
    OperationChainValidator opChainValidator = new OperationChainValidator(null);
    OperationChainHandler<Object> operationChainHandler = new OperationChainHandler<>(opChainValidator,
        new ArrayList<>());
    OperationChain<Object> operationChain = new OperationChain<>();
    Context context = new Context();

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> operationChainHandler.doOperation(operationChain, context, new TestAddToGraphLibraryImpl()));
  }

  /**
   * Test {@link OperationChainHandler#doOperation(OperationChain, Context, Store)} with {@code OperationChain}, {@code Context}, {@code Store}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationChainHandler#doOperation(OperationChain, Context, Store)}
   */
  @Test
  @DisplayName("Test doOperation(OperationChain, Context, Store) with 'OperationChain', 'Context', 'Store'; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object OperationChainHandler.doOperation(OperationChain, Context, Store)"})
  void testDoOperationWithOperationChainContextStore_thenThrowIllegalArgumentException() throws OperationException {
    // Arrange
    OperationChainValidator opChainValidator = new OperationChainValidator(new ViewValidator());
    OperationChainHandler<Object> operationChainHandler = new OperationChainHandler<>(opChainValidator,
        new ArrayList<>());
    OperationChain<Object> operationChain = new OperationChain<>();
    Context context = new Context();

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> operationChainHandler.doOperation(operationChain, context, new TestAddToGraphLibraryImpl()));
  }

  /**
   * Test {@link OperationChainHandler#prepareOperationChain(OperationChain, Context, Store)}.
   * <ul>
   *   <li>Then return {@link OperationChain#OperationChain(Operation[])} with operations is {@link DeleteAllData} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationChainHandler#prepareOperationChain(OperationChain, Context, Store)}
   */
  @Test
  @DisplayName("Test prepareOperationChain(OperationChain, Context, Store); then return OperationChain(Operation[]) with operations is DeleteAllData (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"OperationChain OperationChainHandler.prepareOperationChain(OperationChain, Context, Store)"})
  void testPrepareOperationChain_thenReturnOperationChainWithOperationsIsDeleteAllData() {
    // Arrange
    OperationChainValidator opChainValidator = new OperationChainValidator(new ViewValidator());
    OperationChainHandler<Object> operationChainHandler = new OperationChainHandler<>(opChainValidator,
        new ArrayList<>());
    OperationChain<Object> operationChain = new OperationChain<>(new DeleteAllData());
    Context context = new Context();

    // Act and Assert
    assertSame(operationChain,
        operationChainHandler.prepareOperationChain(operationChain, context, new TestAddToGraphLibraryImpl()));
  }

  /**
   * Test {@link OperationChainHandler#prepareOperationChain(OperationChain, Context, Store)}.
   * <ul>
   *   <li>When {@link OperationChain#OperationChain()}.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationChainHandler#prepareOperationChain(OperationChain, Context, Store)}
   */
  @Test
  @DisplayName("Test prepareOperationChain(OperationChain, Context, Store); when OperationChain(); then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"OperationChain OperationChainHandler.prepareOperationChain(OperationChain, Context, Store)"})
  void testPrepareOperationChain_whenOperationChain_thenThrowIllegalArgumentException() {
    // Arrange
    OperationChainValidator opChainValidator = new OperationChainValidator(new ViewValidator());
    OperationChainHandler<Object> operationChainHandler = new OperationChainHandler<>(opChainValidator,
        new ArrayList<>());
    OperationChain<Object> operationChain = new OperationChain<>();
    Context context = new Context();

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> operationChainHandler.prepareOperationChain(operationChain, context, new TestAddToGraphLibraryImpl()));
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link OperationChainHandler#OperationChainHandler(OperationChainValidator, List)}
   *   <li>{@link OperationChainHandler#getOpChainOptimisers()}
   *   <li>{@link OperationChainHandler#getOpChainValidator()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void OperationChainHandler.<init>(OperationChainValidator, List)",
      "List OperationChainHandler.getOpChainOptimisers()",
      "OperationChainValidator OperationChainHandler.getOpChainValidator()"})
  void testGettersAndSetters() {
    // Arrange
    OperationChainValidator opChainValidator = new OperationChainValidator(new ViewValidator());
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
