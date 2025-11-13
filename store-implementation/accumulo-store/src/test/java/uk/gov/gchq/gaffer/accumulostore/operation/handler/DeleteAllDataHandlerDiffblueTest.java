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

package uk.gov.gchq.gaffer.accumulostore.operation.handler;

import static org.junit.jupiter.api.Assertions.assertThrows;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.accumulostore.AccumuloStore;
import uk.gov.gchq.gaffer.operation.OperationException;
import uk.gov.gchq.gaffer.store.Context;
import uk.gov.gchq.gaffer.store.Context.Builder;
import uk.gov.gchq.gaffer.store.Store;
import uk.gov.gchq.gaffer.store.operation.DeleteAllData;
import uk.gov.gchq.gaffer.user.User;

class DeleteAllDataHandlerDiffblueTest {
  /**
   * Test {@link DeleteAllDataHandler#doOperation(DeleteAllData, Context, Store)} with {@code DeleteAllData}, {@code Context}, {@code Store}.
   * <p>
   * Method under test: {@link DeleteAllDataHandler#doOperation(DeleteAllData, Context, Store)}
   */
  @Test
  @DisplayName("Test doOperation(DeleteAllData, Context, Store) with 'DeleteAllData', 'Context', 'Store'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.Object DeleteAllDataHandler.doOperation(DeleteAllData, Context, Store)"})
  void testDoOperationWithDeleteAllDataContextStore() throws OperationException {
    // Arrange
    DeleteAllDataHandler deleteAllDataHandler = new DeleteAllDataHandler();
    DeleteAllData operation = new DeleteAllData();

    Builder builder = new Builder();
    User user = (new User.Builder()).userId("42").build();
    Context context = builder.user(user).build();

    // Act and Assert
    assertThrows(OperationException.class,
        () -> deleteAllDataHandler.doOperation(operation, context, new AccumuloStore()));
  }

  /**
   * Test {@link DeleteAllDataHandler#doOperation(DeleteAllData, Context, Store)} with {@code DeleteAllData}, {@code Context}, {@code Store}.
   * <p>
   * Method under test: {@link DeleteAllDataHandler#doOperation(DeleteAllData, Context, Store)}
   */
  @Test
  @DisplayName("Test doOperation(DeleteAllData, Context, Store) with 'DeleteAllData', 'Context', 'Store'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.Object DeleteAllDataHandler.doOperation(DeleteAllData, Context, Store)"})
  void testDoOperationWithDeleteAllDataContextStore2() throws OperationException {
    // Arrange
    DeleteAllDataHandler deleteAllDataHandler = new DeleteAllDataHandler();
    DeleteAllData operation = new DeleteAllData();

    Builder builder = new Builder();
    User user = (new User.Builder()).userId("42").build();
    Context context = builder.user(user).build();

    // Act and Assert
    assertThrows(OperationException.class,
        () -> deleteAllDataHandler.doOperation(operation, context, new AccumuloStore()));
  }

  /**
   * Test {@link DeleteAllDataHandler#doOperation(DeleteAllData, Context, Store)} with {@code DeleteAllData}, {@code Context}, {@code Store}.
   * <ul>
   *   <li>When {@link Context#Context()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeleteAllDataHandler#doOperation(DeleteAllData, Context, Store)}
   */
  @Test
  @DisplayName("Test doOperation(DeleteAllData, Context, Store) with 'DeleteAllData', 'Context', 'Store'; when Context()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.Object DeleteAllDataHandler.doOperation(DeleteAllData, Context, Store)"})
  void testDoOperationWithDeleteAllDataContextStore_whenContext() throws OperationException {
    // Arrange
    DeleteAllDataHandler deleteAllDataHandler = new DeleteAllDataHandler();
    DeleteAllData operation = new DeleteAllData();
    Context context = new Context();

    // Act and Assert
    assertThrows(OperationException.class,
        () -> deleteAllDataHandler.doOperation(operation, context, new AccumuloStore()));
  }

  /**
   * Test {@link DeleteAllDataHandler#doOperation(DeleteAllData, Context, Store)} with {@code DeleteAllData}, {@code Context}, {@code Store}.
   * <ul>
   *   <li>When {@link Context#Context()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeleteAllDataHandler#doOperation(DeleteAllData, Context, Store)}
   */
  @Test
  @DisplayName("Test doOperation(DeleteAllData, Context, Store) with 'DeleteAllData', 'Context', 'Store'; when Context()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.Object DeleteAllDataHandler.doOperation(DeleteAllData, Context, Store)"})
  void testDoOperationWithDeleteAllDataContextStore_whenContext2() throws OperationException {
    // Arrange
    DeleteAllDataHandler deleteAllDataHandler = new DeleteAllDataHandler();
    DeleteAllData operation = new DeleteAllData();
    Context context = new Context();

    // Act and Assert
    assertThrows(OperationException.class,
        () -> deleteAllDataHandler.doOperation(operation, context, new AccumuloStore()));
  }
}
