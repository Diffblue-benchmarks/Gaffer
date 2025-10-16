package uk.gov.gchq.gaffer.accumulostore.retriever;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.core.exception.Status;

class RetrieverExceptionDiffblueTest {
  /**
   * Test {@link RetrieverException#RetrieverException(String, Throwable)}.
   *
   * <p>Method under test: {@link RetrieverException#RetrieverException(String, Throwable)}
   */
  @Test
  @DisplayName("Test new RetrieverException(String, Throwable)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void RetrieverException.<init>(String, Throwable)"})
  void testNewRetrieverException() {
    // Arrange
    Throwable e = new Throwable();

    // Act
    RetrieverException actualRetrieverException = new RetrieverException("An error occurred", e);

    // Assert
    assertEquals("An error occurred", actualRetrieverException.getLocalizedMessage());
    assertEquals("An error occurred", actualRetrieverException.getMessage());
    assertEquals(0, actualRetrieverException.getSuppressed().length);
    assertEquals(Status.INTERNAL_SERVER_ERROR, actualRetrieverException.getStatus());
    assertSame(e, actualRetrieverException.getCause());
  }

  /**
   * Test {@link RetrieverException#RetrieverException(Throwable)}.
   *
   * <p>Method under test: {@link RetrieverException#RetrieverException(Throwable)}
   */
  @Test
  @DisplayName("Test new RetrieverException(Throwable)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void RetrieverException.<init>(Throwable)"})
  void testNewRetrieverException2() {
    // Arrange
    Throwable e = new Throwable();

    // Act
    RetrieverException actualRetrieverException = new RetrieverException(e);

    // Assert
    assertEquals("java.lang.Throwable", actualRetrieverException.getLocalizedMessage());
    assertEquals("java.lang.Throwable", actualRetrieverException.getMessage());
    assertEquals(0, actualRetrieverException.getSuppressed().length);
    assertEquals(Status.INTERNAL_SERVER_ERROR, actualRetrieverException.getStatus());
    assertSame(e, actualRetrieverException.getCause());
  }
}
