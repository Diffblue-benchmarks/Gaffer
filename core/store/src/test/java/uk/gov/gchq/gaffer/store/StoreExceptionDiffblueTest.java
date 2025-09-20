package uk.gov.gchq.gaffer.store;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.core.exception.Status;

class StoreExceptionDiffblueTest {
  /**
   * Test {@link StoreException#StoreException(String)}.
   *
   * <p>Method under test: {@link StoreException#StoreException(String)}
   */
  @Test
  @DisplayName("Test new StoreException(String)")
  @Tag("MaintainedByDiffblue")
  void testNewStoreException() {
    // Arrange and Act
    StoreException actualStoreException = new StoreException("An error occurred");

    // Assert
    assertEquals("An error occurred", actualStoreException.getLocalizedMessage());
    assertEquals("An error occurred", actualStoreException.getMessage());
    assertNull(actualStoreException.getCause());
    assertEquals(0, actualStoreException.getSuppressed().length);
    assertEquals(Status.INTERNAL_SERVER_ERROR, actualStoreException.getStatus());
  }

  /**
   * Test {@link StoreException#StoreException(String, Throwable)}.
   *
   * <p>Method under test: {@link StoreException#StoreException(String, Throwable)}
   */
  @Test
  @DisplayName("Test new StoreException(String, Throwable)")
  @Tag("MaintainedByDiffblue")
  void testNewStoreException2() {
    // Arrange
    Throwable e = new Throwable();

    // Act
    StoreException actualStoreException = new StoreException("An error occurred", e);

    // Assert
    assertEquals("An error occurred", actualStoreException.getLocalizedMessage());
    assertEquals("An error occurred", actualStoreException.getMessage());
    assertEquals(0, actualStoreException.getSuppressed().length);
    assertEquals(Status.INTERNAL_SERVER_ERROR, actualStoreException.getStatus());
    assertSame(e, actualStoreException.getCause());
  }

  /**
   * Test {@link StoreException#StoreException(Throwable)}.
   *
   * <p>Method under test: {@link StoreException#StoreException(Throwable)}
   */
  @Test
  @DisplayName("Test new StoreException(Throwable)")
  @Tag("MaintainedByDiffblue")
  void testNewStoreException3() {
    // Arrange
    Throwable e = new Throwable();

    // Act
    StoreException actualStoreException = new StoreException(e);

    // Assert
    assertEquals("java.lang.Throwable", actualStoreException.getLocalizedMessage());
    assertEquals("java.lang.Throwable", actualStoreException.getMessage());
    assertEquals(0, actualStoreException.getSuppressed().length);
    assertEquals(Status.INTERNAL_SERVER_ERROR, actualStoreException.getStatus());
    assertSame(e, actualStoreException.getCause());
  }
}
