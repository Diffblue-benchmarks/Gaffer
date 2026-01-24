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

package uk.gov.gchq.gaffer.store;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void StoreException.<init>(String)"})
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void StoreException.<init>(String, Throwable)"})
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void StoreException.<init>(Throwable)"})
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
