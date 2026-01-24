/*
 * Copyright 2026 Crown Copyright
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

package uk.gov.gchq.gaffer.federatedstore.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.core.exception.Status;

class StorageExceptionDiffblueTest {
  /**
   * Test {@link StorageException#StorageException(String)}.
   *
   * <p>Method under test: {@link StorageException#StorageException(String)}
   */
  @Test
  @DisplayName("Test new StorageException(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void StorageException.<init>(String)"})
  void testNewStorageException() {
    // Arrange and Act
    StorageException actualStorageException = new StorageException("An error occurred");

    // Assert
    assertEquals("An error occurred", actualStorageException.getLocalizedMessage());
    assertEquals("An error occurred", actualStorageException.getMessage());
    assertNull(actualStorageException.getCause());
    assertEquals(0, actualStorageException.getSuppressed().length);
    assertEquals(Status.INTERNAL_SERVER_ERROR, actualStorageException.getStatus());
  }

  /**
   * Test {@link StorageException#StorageException(String, Throwable)}.
   *
   * <p>Method under test: {@link StorageException#StorageException(String, Throwable)}
   */
  @Test
  @DisplayName("Test new StorageException(String, Throwable)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void StorageException.<init>(String, Throwable)"})
  void testNewStorageException2() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    StorageException actualStorageException = new StorageException("An error occurred", cause);

    // Assert
    assertEquals("An error occurred", actualStorageException.getLocalizedMessage());
    assertEquals("An error occurred", actualStorageException.getMessage());
    assertEquals(0, actualStorageException.getSuppressed().length);
    assertEquals(Status.INTERNAL_SERVER_ERROR, actualStorageException.getStatus());
    assertSame(cause, actualStorageException.getCause());
  }

  /**
   * Test {@link StorageException#StorageException(Throwable)}.
   *
   * <p>Method under test: {@link StorageException#StorageException(Throwable)}
   */
  @Test
  @DisplayName("Test new StorageException(Throwable)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void StorageException.<init>(Throwable)"})
  void testNewStorageException3() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    StorageException actualStorageException = new StorageException(cause);

    // Assert
    assertEquals("java.lang.Throwable", actualStorageException.getLocalizedMessage());
    assertEquals("java.lang.Throwable", actualStorageException.getMessage());
    assertEquals(0, actualStorageException.getSuppressed().length);
    assertEquals(Status.INTERNAL_SERVER_ERROR, actualStorageException.getStatus());
    assertSame(cause, actualStorageException.getCause());
  }
}
