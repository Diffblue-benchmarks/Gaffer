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

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.operation.OperationException;
import uk.gov.gchq.gaffer.operation.impl.SplitStoreFromFile;
import uk.gov.gchq.gaffer.operation.impl.SplitStoreFromIterable;
import uk.gov.gchq.gaffer.store.Context;
import uk.gov.gchq.gaffer.store.Store;

class SplitStoreFromFileHandlerDiffblueTest {
  /**
   * Test {@link SplitStoreFromFileHandler#doOperation(SplitStoreFromFile, Context, Store)} with {@code SplitStoreFromFile}, {@code Context}, {@code Store}.
   * <p>
   * Method under test: {@link SplitStoreFromFileHandler#doOperation(SplitStoreFromFile, Context, Store)}
   */
  @Test
  @DisplayName("Test doOperation(SplitStoreFromFile, Context, Store) with 'SplitStoreFromFile', 'Context', 'Store'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.Void SplitStoreFromFileHandler.doOperation(SplitStoreFromFile, Context, Store)"})
  void testDoOperationWithSplitStoreFromFileContextStore() throws OperationException {
    // Arrange
    SplitStoreFromFileHandler splitStoreFromFileHandler = new SplitStoreFromFileHandler();
    SplitStoreFromFile operation = new SplitStoreFromFile();
    Context context = new Context();

    // Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> splitStoreFromFileHandler.doOperation(operation, context, new TestAddToGraphLibraryImpl()));
  }

  /**
   * Test {@link SplitStoreFromFileHandler#doOperation(SplitStoreFromFile, Context, Store)} with {@code SplitStoreFromFile}, {@code Context}, {@code Store}.
   * <ul>
   *   <li>Then throw {@link OperationException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SplitStoreFromFileHandler#doOperation(SplitStoreFromFile, Context, Store)}
   */
  @Test
  @DisplayName("Test doOperation(SplitStoreFromFile, Context, Store) with 'SplitStoreFromFile', 'Context', 'Store'; then throw OperationException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.Void SplitStoreFromFileHandler.doOperation(SplitStoreFromFile, Context, Store)"})
  void testDoOperationWithSplitStoreFromFileContextStore_thenThrowOperationException() throws OperationException {
    // Arrange
    SplitStoreFromFileHandler splitStoreFromFileHandler = new SplitStoreFromFileHandler();

    SplitStoreFromFile operation = new SplitStoreFromFile();
    operation.setInputPath("Input Path");
    Context context = new Context();

    TestAddToGraphLibraryImpl store = new TestAddToGraphLibraryImpl();
    Class<SplitStoreFromIterable> opClass = SplitStoreFromIterable.class;
    store.addOperationHandler(opClass, mock(OperationHandler.class));

    // Act and Assert
    assertThrows(OperationException.class, () -> splitStoreFromFileHandler.doOperation(operation, context, store));
  }

  /**
   * Test {@link SplitStoreFromFileHandler#getSplits(SplitStoreFromFile, Context, Store)}.
   * <ul>
   *   <li>Given {@code Input Path}.</li>
   *   <li>Then throw {@link OperationException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SplitStoreFromFileHandler#getSplits(SplitStoreFromFile, Context, Store)}
   */
  @Test
  @DisplayName("Test getSplits(SplitStoreFromFile, Context, Store); given 'Input Path'; then throw OperationException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.util.List SplitStoreFromFileHandler.getSplits(SplitStoreFromFile, Context, Store)"})
  void testGetSplits_givenInputPath_thenThrowOperationException() throws OperationException {
    // Arrange
    SplitStoreFromFileHandler splitStoreFromFileHandler = new SplitStoreFromFileHandler();

    SplitStoreFromFile operation = new SplitStoreFromFile();
    operation.setInputPath("Input Path");
    Context context = new Context();

    TestAddToGraphLibraryImpl store = new TestAddToGraphLibraryImpl();
    Class<SplitStoreFromIterable> opClass = SplitStoreFromIterable.class;
    store.addOperationHandler(opClass, mock(OperationHandler.class));

    // Act and Assert
    assertThrows(OperationException.class, () -> splitStoreFromFileHandler.getSplits(operation, context, store));
  }

  /**
   * Test {@link SplitStoreFromFileHandler#getSplits(SplitStoreFromFile, Context, Store)}.
   * <ul>
   *   <li>Then throw {@link UnsupportedOperationException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SplitStoreFromFileHandler#getSplits(SplitStoreFromFile, Context, Store)}
   */
  @Test
  @DisplayName("Test getSplits(SplitStoreFromFile, Context, Store); then throw UnsupportedOperationException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.util.List SplitStoreFromFileHandler.getSplits(SplitStoreFromFile, Context, Store)"})
  void testGetSplits_thenThrowUnsupportedOperationException() throws OperationException {
    // Arrange
    SplitStoreFromFileHandler splitStoreFromFileHandler = new SplitStoreFromFileHandler();
    SplitStoreFromFile operation = new SplitStoreFromFile();
    Context context = new Context();

    // Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> splitStoreFromFileHandler.getSplits(operation, context, new TestAddToGraphLibraryImpl()));
  }

  /**
   * Test {@link SplitStoreFromFileHandler#splitStoreFromIterable(Iterable, Context, Store)}.
   * <ul>
   *   <li>Then throw {@link UnsupportedOperationException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SplitStoreFromFileHandler#splitStoreFromIterable(Iterable, Context, Store)}
   */
  @Test
  @DisplayName("Test splitStoreFromIterable(Iterable, Context, Store); then throw UnsupportedOperationException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void SplitStoreFromFileHandler.splitStoreFromIterable(Iterable, Context, Store)"})
  void testSplitStoreFromIterable_thenThrowUnsupportedOperationException() throws OperationException {
    // Arrange
    SplitStoreFromFileHandler splitStoreFromFileHandler = new SplitStoreFromFileHandler();
    ArrayList<String> splits = new ArrayList<>();
    Context context = new Context();

    // Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> splitStoreFromFileHandler.splitStoreFromIterable(splits, context, new TestAddToGraphLibraryImpl()));
  }
}
