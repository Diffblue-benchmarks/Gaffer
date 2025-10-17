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

package uk.gov.gchq.gaffer.accumulostore.operation.hdfs.handler;

import static org.junit.jupiter.api.Assertions.assertThrows;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.accumulostore.AccumuloStore;
import uk.gov.gchq.gaffer.hdfs.operation.AddElementsFromHdfs;
import uk.gov.gchq.gaffer.operation.OperationException;
import uk.gov.gchq.gaffer.store.Context;

class AddElementsFromHdfsHandlerDiffblueTest {
  /**
   * Test {@link AddElementsFromHdfsHandler#doOperation(AddElementsFromHdfs, Context,
   * AccumuloStore)} with {@code AddElementsFromHdfs}, {@code Context}, {@code AccumuloStore}.
   *
   * <p>Method under test: {@link AddElementsFromHdfsHandler#doOperation(AddElementsFromHdfs,
   * Context, AccumuloStore)}
   */
  @Test
  @DisplayName(
      "Test doOperation(AddElementsFromHdfs, Context, AccumuloStore) with 'AddElementsFromHdfs', 'Context', 'AccumuloStore'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AddElementsFromHdfsHandler.doOperation(AddElementsFromHdfs, Context, AccumuloStore)"
  })
  void testDoOperationWithAddElementsFromHdfsContextAccumuloStore() throws OperationException {
    // Arrange
    AddElementsFromHdfsHandler addElementsFromHdfsHandler = new AddElementsFromHdfsHandler();
    AddElementsFromHdfs operation = new AddElementsFromHdfs();
    Context context = new Context();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> addElementsFromHdfsHandler.doOperation(operation, context, new AccumuloStore()));
  }

  /**
   * Test {@link AddElementsFromHdfsHandler#doOperation(AddElementsFromHdfs, Context,
   * AccumuloStore)} with {@code AddElementsFromHdfs}, {@code Context}, {@code AccumuloStore}.
   *
   * <p>Method under test: {@link AddElementsFromHdfsHandler#doOperation(AddElementsFromHdfs,
   * Context, AccumuloStore)}
   */
  @Test
  @DisplayName(
      "Test doOperation(AddElementsFromHdfs, Context, AccumuloStore) with 'AddElementsFromHdfs', 'Context', 'AccumuloStore'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AddElementsFromHdfsHandler.doOperation(AddElementsFromHdfs, Context, AccumuloStore)"
  })
  void testDoOperationWithAddElementsFromHdfsContextAccumuloStore2() throws OperationException {
    // Arrange
    AddElementsFromHdfsHandler addElementsFromHdfsHandler = new AddElementsFromHdfsHandler();

    AddElementsFromHdfs operation = new AddElementsFromHdfs();
    operation.setSplitsFilePath(null);
    operation.setUseProvidedSplits(false);
    operation.setMinMapTasks(null);
    operation.setMaxMapTasks(null);
    operation.setMinReduceTasks(1);
    operation.setMaxReduceTasks(null);
    operation.setWorkingPath(null);
    Context context = new Context();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> addElementsFromHdfsHandler.doOperation(operation, context, new AccumuloStore()));
  }

  /**
   * Test {@link AddElementsFromHdfsHandler#doOperation(AddElementsFromHdfs, Context,
   * AccumuloStore)} with {@code AddElementsFromHdfs}, {@code Context}, {@code AccumuloStore}.
   *
   * <p>Method under test: {@link AddElementsFromHdfsHandler#doOperation(AddElementsFromHdfs,
   * Context, AccumuloStore)}
   */
  @Test
  @DisplayName(
      "Test doOperation(AddElementsFromHdfs, Context, AccumuloStore) with 'AddElementsFromHdfs', 'Context', 'AccumuloStore'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AddElementsFromHdfsHandler.doOperation(AddElementsFromHdfs, Context, AccumuloStore)"
  })
  void testDoOperationWithAddElementsFromHdfsContextAccumuloStore3() throws OperationException {
    // Arrange
    AddElementsFromHdfsHandler addElementsFromHdfsHandler = new AddElementsFromHdfsHandler();

    AddElementsFromHdfs operation = new AddElementsFromHdfs();
    operation.setSplitsFilePath(null);
    operation.setUseProvidedSplits(false);
    operation.setMinMapTasks(null);
    operation.setMaxMapTasks(null);
    operation.setMinReduceTasks(1);
    operation.setMaxReduceTasks(1);
    operation.setWorkingPath(null);
    Context context = new Context();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> addElementsFromHdfsHandler.doOperation(operation, context, new AccumuloStore()));
  }

  /**
   * Test {@link AddElementsFromHdfsHandler#doOperation(AddElementsFromHdfs, Context,
   * AccumuloStore)} with {@code AddElementsFromHdfs}, {@code Context}, {@code AccumuloStore}.
   *
   * <p>Method under test: {@link AddElementsFromHdfsHandler#doOperation(AddElementsFromHdfs,
   * Context, AccumuloStore)}
   */
  @Test
  @DisplayName(
      "Test doOperation(AddElementsFromHdfs, Context, AccumuloStore) with 'AddElementsFromHdfs', 'Context', 'AccumuloStore'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AddElementsFromHdfsHandler.doOperation(AddElementsFromHdfs, Context, AccumuloStore)"
  })
  void testDoOperationWithAddElementsFromHdfsContextAccumuloStore4() throws OperationException {
    // Arrange
    AddElementsFromHdfsHandler addElementsFromHdfsHandler = new AddElementsFromHdfsHandler();

    AddElementsFromHdfs operation = new AddElementsFromHdfs();
    operation.setSplitsFilePath(null);
    operation.setUseProvidedSplits(false);
    operation.setMinMapTasks(null);
    operation.setMaxMapTasks(1);
    operation.setMinReduceTasks(null);
    operation.setMaxReduceTasks(null);
    operation.setWorkingPath(null);
    Context context = new Context();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> addElementsFromHdfsHandler.doOperation(operation, context, new AccumuloStore()));
  }

  /**
   * Test {@link AddElementsFromHdfsHandler#doOperation(AddElementsFromHdfs, Context,
   * AccumuloStore)} with {@code AddElementsFromHdfs}, {@code Context}, {@code AccumuloStore}.
   *
   * <p>Method under test: {@link AddElementsFromHdfsHandler#doOperation(AddElementsFromHdfs,
   * Context, AccumuloStore)}
   */
  @Test
  @DisplayName(
      "Test doOperation(AddElementsFromHdfs, Context, AccumuloStore) with 'AddElementsFromHdfs', 'Context', 'AccumuloStore'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AddElementsFromHdfsHandler.doOperation(AddElementsFromHdfs, Context, AccumuloStore)"
  })
  void testDoOperationWithAddElementsFromHdfsContextAccumuloStore5() throws OperationException {
    // Arrange
    AddElementsFromHdfsHandler addElementsFromHdfsHandler = new AddElementsFromHdfsHandler();

    AddElementsFromHdfs operation = new AddElementsFromHdfs();
    operation.setSplitsFilePath(null);
    operation.setUseProvidedSplits(false);
    operation.setMinMapTasks(1);
    operation.setMaxMapTasks(null);
    operation.setMinReduceTasks(null);
    operation.setMaxReduceTasks(null);
    operation.setWorkingPath(null);
    Context context = new Context();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> addElementsFromHdfsHandler.doOperation(operation, context, new AccumuloStore()));
  }

  /**
   * Test {@link AddElementsFromHdfsHandler#doOperation(AddElementsFromHdfs, Context,
   * AccumuloStore)} with {@code AddElementsFromHdfs}, {@code Context}, {@code AccumuloStore}.
   *
   * <ul>
   *   <li>Given {@code /directory/foo.txt}.
   * </ul>
   *
   * <p>Method under test: {@link AddElementsFromHdfsHandler#doOperation(AddElementsFromHdfs,
   * Context, AccumuloStore)}
   */
  @Test
  @DisplayName(
      "Test doOperation(AddElementsFromHdfs, Context, AccumuloStore) with 'AddElementsFromHdfs', 'Context', 'AccumuloStore'; given '/directory/foo.txt'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AddElementsFromHdfsHandler.doOperation(AddElementsFromHdfs, Context, AccumuloStore)"
  })
  void testDoOperationWithAddElementsFromHdfsContextAccumuloStore_givenDirectoryFooTxt()
      throws OperationException {
    // Arrange
    AddElementsFromHdfsHandler addElementsFromHdfsHandler = new AddElementsFromHdfsHandler();

    AddElementsFromHdfs operation = new AddElementsFromHdfs();
    operation.setSplitsFilePath("/directory/foo.txt");
    Context context = new Context();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> addElementsFromHdfsHandler.doOperation(operation, context, new AccumuloStore()));
  }

  /**
   * Test {@link AddElementsFromHdfsHandler#doOperation(AddElementsFromHdfs, Context,
   * AccumuloStore)} with {@code AddElementsFromHdfs}, {@code Context}, {@code AccumuloStore}.
   *
   * <ul>
   *   <li>Given zero.
   * </ul>
   *
   * <p>Method under test: {@link AddElementsFromHdfsHandler#doOperation(AddElementsFromHdfs,
   * Context, AccumuloStore)}
   */
  @Test
  @DisplayName(
      "Test doOperation(AddElementsFromHdfs, Context, AccumuloStore) with 'AddElementsFromHdfs', 'Context', 'AccumuloStore'; given zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AddElementsFromHdfsHandler.doOperation(AddElementsFromHdfs, Context, AccumuloStore)"
  })
  void testDoOperationWithAddElementsFromHdfsContextAccumuloStore_givenZero()
      throws OperationException {
    // Arrange
    AddElementsFromHdfsHandler addElementsFromHdfsHandler = new AddElementsFromHdfsHandler();

    AddElementsFromHdfs operation = new AddElementsFromHdfs();
    operation.setSplitsFilePath(null);
    operation.setUseProvidedSplits(false);
    operation.setMinMapTasks(null);
    operation.setMaxMapTasks(null);
    operation.setMinReduceTasks(1);
    operation.setMaxReduceTasks(0);
    operation.setWorkingPath(null);
    Context context = new Context();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> addElementsFromHdfsHandler.doOperation(operation, context, new AccumuloStore()));
  }
}
