package uk.gov.gchq.gaffer.accumulostore.operation.hdfs.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class BulkImportExceptionDiffblueTest {
  /**
   * Test {@link BulkImportException#BulkImportException(String, Throwable)}.
   *
   * <ul>
   *   <li>Then return Message is {@code An error occurred}.
   * </ul>
   *
   * <p>Method under test: {@link BulkImportException#BulkImportException(String, Throwable)}
   */
  @Test
  @DisplayName(
      "Test new BulkImportException(String, Throwable); then return Message is 'An error occurred'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BulkImportException.<init>(String, Throwable)",
    "void BulkImportException.<init>(Throwable)"
  })
  void testNewBulkImportException_thenReturnMessageIsAnErrorOccurred() {
    // Arrange
    Throwable e = new Throwable();

    // Act
    BulkImportException actualBulkImportException = new BulkImportException("An error occurred", e);

    // Assert
    assertEquals("An error occurred", actualBulkImportException.getMessage());
    assertEquals(0, actualBulkImportException.getSuppressed().length);
    assertSame(e, actualBulkImportException.getCause());
  }

  /**
   * Test {@link BulkImportException#BulkImportException(Throwable)}.
   *
   * <ul>
   *   <li>When {@link Throwable#Throwable()}.
   *   <li>Then return Message is {@code Throwable}.
   * </ul>
   *
   * <p>Method under test: {@link BulkImportException#BulkImportException(Throwable)}
   */
  @Test
  @DisplayName(
      "Test new BulkImportException(Throwable); when Throwable(); then return Message is 'java.lang.Throwable'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BulkImportException.<init>(String, Throwable)",
    "void BulkImportException.<init>(Throwable)"
  })
  void testNewBulkImportException_whenThrowable_thenReturnMessageIsJavaLangThrowable() {
    // Arrange
    Throwable e = new Throwable();

    // Act
    BulkImportException actualBulkImportException = new BulkImportException(e);

    // Assert
    assertEquals("java.lang.Throwable", actualBulkImportException.getMessage());
    assertEquals(0, actualBulkImportException.getSuppressed().length);
    assertSame(e, actualBulkImportException.getCause());
  }
}
