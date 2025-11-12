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

package uk.gov.gchq.gaffer.proxystore.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import org.junit.jupiter.api.Test;

class ProxyStoreExceptionDiffblueTest {
  /**
   * Method under test: {@link ProxyStoreException#ProxyStoreException()}
   */
  @Test
  void testNewProxyStoreException() {
    // Arrange and Act
    ProxyStoreException actualProxyStoreException = new ProxyStoreException();

    // Assert
    assertNull(actualProxyStoreException.getMessage());
    assertNull(actualProxyStoreException.getCause());
    assertEquals(0, actualProxyStoreException.getSuppressed().length);
  }

  /**
   * Method under test: {@link ProxyStoreException#ProxyStoreException(String)}
   */
  @Test
  void testNewProxyStoreException2() {
    // Arrange and Act
    ProxyStoreException actualProxyStoreException = new ProxyStoreException("An error occurred");

    // Assert
    assertEquals("An error occurred", actualProxyStoreException.getMessage());
    assertNull(actualProxyStoreException.getCause());
    assertEquals(0, actualProxyStoreException.getSuppressed().length);
  }

  /**
   * Method under test:
   * {@link ProxyStoreException#ProxyStoreException(String, Throwable)}
   */
  @Test
  void testNewProxyStoreException3() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    ProxyStoreException actualProxyStoreException = new ProxyStoreException("An error occurred", cause);

    // Assert
    assertEquals("An error occurred", actualProxyStoreException.getMessage());
    assertEquals(0, actualProxyStoreException.getSuppressed().length);
    assertSame(cause, actualProxyStoreException.getCause());
  }

  /**
   * Method under test:
   * {@link ProxyStoreException#ProxyStoreException(String, Throwable, boolean, boolean)}
   */
  @Test
  void testNewProxyStoreException4() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    ProxyStoreException actualProxyStoreException = new ProxyStoreException("An error occurred", cause, true, true);

    // Assert
    assertEquals("An error occurred", actualProxyStoreException.getMessage());
    assertEquals(0, actualProxyStoreException.getSuppressed().length);
    assertSame(cause, actualProxyStoreException.getCause());
  }

  /**
   * Method under test: {@link ProxyStoreException#ProxyStoreException(Throwable)}
   */
  @Test
  void testNewProxyStoreException5() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    ProxyStoreException actualProxyStoreException = new ProxyStoreException(cause);

    // Assert
    assertEquals("java.lang.Throwable", actualProxyStoreException.getMessage());
    assertEquals(0, actualProxyStoreException.getSuppressed().length);
    assertSame(cause, actualProxyStoreException.getCause());
  }
}
