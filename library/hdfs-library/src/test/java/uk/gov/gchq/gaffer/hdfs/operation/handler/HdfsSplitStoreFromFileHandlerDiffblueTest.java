package uk.gov.gchq.gaffer.hdfs.operation.handler;

import static org.junit.jupiter.api.Assertions.assertThrows;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.operation.OperationException;
import uk.gov.gchq.gaffer.operation.impl.SplitStoreFromFile;
import uk.gov.gchq.gaffer.store.Context;
import uk.gov.gchq.gaffer.store.Store;
import uk.gov.gchq.gaffer.store.operation.handler.TestAddToGraphLibraryImpl;

class HdfsSplitStoreFromFileHandlerDiffblueTest {
  /**
   * Test {@link HdfsSplitStoreFromFileHandler#getSplits(SplitStoreFromFile, Context, Store)}.
   *
   * <ul>
   *   <li>Then throw {@link UnsupportedOperationException}.
   * </ul>
   *
   * <p>Method under test: {@link HdfsSplitStoreFromFileHandler#getSplits(SplitStoreFromFile,
   * Context, Store)}
   */
  @Test
  @DisplayName(
      "Test getSplits(SplitStoreFromFile, Context, Store); then throw UnsupportedOperationException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.util.List HdfsSplitStoreFromFileHandler.getSplits(SplitStoreFromFile, Context, Store)"
  })
  void testGetSplits_thenThrowUnsupportedOperationException() throws OperationException {
    // Arrange
    HdfsSplitStoreFromFileHandler hdfsSplitStoreFromFileHandler =
        new HdfsSplitStoreFromFileHandler();
    SplitStoreFromFile operation = new SplitStoreFromFile();
    Context context = new Context();

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () ->
            hdfsSplitStoreFromFileHandler.getSplits(
                operation, context, new TestAddToGraphLibraryImpl()));
  }
}
