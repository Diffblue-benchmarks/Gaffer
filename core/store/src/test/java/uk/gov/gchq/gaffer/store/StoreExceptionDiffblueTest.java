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

package uk.gov.gchq.gaffer.store;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.core.exception.Status;

class StoreExceptionDiffblueTest {
  /**
   * Method under test: {@link StoreException#StoreException(String)}
   */
  @Test
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
   * Method under test: {@link StoreException#StoreException(String, Throwable)}
   */
  @Test
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
   * Method under test: {@link StoreException#StoreException(Throwable)}
   */
  @Test
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
