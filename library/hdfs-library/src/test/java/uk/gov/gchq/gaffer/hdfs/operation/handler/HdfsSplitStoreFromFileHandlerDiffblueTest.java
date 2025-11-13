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

package uk.gov.gchq.gaffer.hdfs.operation.handler;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import uk.gov.gchq.gaffer.operation.Operation;
import uk.gov.gchq.gaffer.operation.OperationException;
import uk.gov.gchq.gaffer.operation.impl.SplitStoreFromFile;
import uk.gov.gchq.gaffer.store.Context;
import uk.gov.gchq.gaffer.store.Store;

class HdfsSplitStoreFromFileHandlerDiffblueTest {
  /**
   * Test {@link HdfsSplitStoreFromFileHandler#getSplits(SplitStoreFromFile, Context, Store)}.
   * <ul>
   *   <li>Given {@code Input Path}.</li>
   *   <li>When {@link SplitStoreFromFile} (default constructor) InputPath is {@code Input Path}.</li>
   * </ul>
   * <p>
   * Method under test: {@link HdfsSplitStoreFromFileHandler#getSplits(SplitStoreFromFile, Context, Store)}
   */
  @Test
  @DisplayName("Test getSplits(SplitStoreFromFile, Context, Store); given 'Input Path'; when SplitStoreFromFile (default constructor) InputPath is 'Input Path'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.util.List HdfsSplitStoreFromFileHandler.getSplits(SplitStoreFromFile, Context, Store)"})
  void testGetSplits_givenInputPath_whenSplitStoreFromFileInputPathIsInputPath() throws OperationException {
    // Arrange
    HdfsSplitStoreFromFileHandler hdfsSplitStoreFromFileHandler = new HdfsSplitStoreFromFileHandler();

    SplitStoreFromFile operation = new SplitStoreFromFile();
    operation.setInputPath("Input Path");
    Context context = new Context();
    Store store = mock(Store.class);
    when(store.isSupported(Mockito.<Class<Operation>>any())).thenReturn(true);

    // Act and Assert
    assertThrows(OperationException.class, () -> hdfsSplitStoreFromFileHandler.getSplits(operation, context, store));
    verify(store).isSupported(isA(Class.class));
  }

  /**
   * Test {@link HdfsSplitStoreFromFileHandler#getSplits(SplitStoreFromFile, Context, Store)}.
   * <ul>
   *   <li>Given {@code ///}.</li>
   * </ul>
   * <p>
   * Method under test: {@link HdfsSplitStoreFromFileHandler#getSplits(SplitStoreFromFile, Context, Store)}
   */
  @Test
  @DisplayName("Test getSplits(SplitStoreFromFile, Context, Store); given '///'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.util.List HdfsSplitStoreFromFileHandler.getSplits(SplitStoreFromFile, Context, Store)"})
  void testGetSplits_givenSlashSlashSlash() throws OperationException {
    // Arrange
    HdfsSplitStoreFromFileHandler hdfsSplitStoreFromFileHandler = new HdfsSplitStoreFromFileHandler();
    SplitStoreFromFile operation = mock(SplitStoreFromFile.class);
    when(operation.getInputPath()).thenReturn("///");
    Context context = new Context();
    Store store = mock(Store.class);
    when(store.isSupported(Mockito.<Class<Operation>>any())).thenReturn(true);

    // Act and Assert
    assertThrows(OperationException.class, () -> hdfsSplitStoreFromFileHandler.getSplits(operation, context, store));
    verify(operation, atLeast(1)).getInputPath();
    verify(store).isSupported(isA(Class.class));
  }

  /**
   * Test {@link HdfsSplitStoreFromFileHandler#getSplits(SplitStoreFromFile, Context, Store)}.
   * <ul>
   *   <li>When {@link SplitStoreFromFile} {@link SplitStoreFromFile#getInputPath()} return {@code Input Path}.</li>
   * </ul>
   * <p>
   * Method under test: {@link HdfsSplitStoreFromFileHandler#getSplits(SplitStoreFromFile, Context, Store)}
   */
  @Test
  @DisplayName("Test getSplits(SplitStoreFromFile, Context, Store); when SplitStoreFromFile getInputPath() return 'Input Path'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.util.List HdfsSplitStoreFromFileHandler.getSplits(SplitStoreFromFile, Context, Store)"})
  void testGetSplits_whenSplitStoreFromFileGetInputPathReturnInputPath() throws OperationException {
    // Arrange
    HdfsSplitStoreFromFileHandler hdfsSplitStoreFromFileHandler = new HdfsSplitStoreFromFileHandler();
    SplitStoreFromFile operation = mock(SplitStoreFromFile.class);
    when(operation.getInputPath()).thenReturn("Input Path");
    Context context = new Context();
    Store store = mock(Store.class);
    when(store.isSupported(Mockito.<Class<Operation>>any())).thenReturn(true);

    // Act and Assert
    assertThrows(OperationException.class, () -> hdfsSplitStoreFromFileHandler.getSplits(operation, context, store));
    verify(operation, atLeast(1)).getInputPath();
    verify(store).isSupported(isA(Class.class));
  }
}
