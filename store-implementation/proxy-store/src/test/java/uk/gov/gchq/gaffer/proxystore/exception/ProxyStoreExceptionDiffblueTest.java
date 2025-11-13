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
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ProxyStoreExceptionDiffblueTest {
  /**
   * Test {@link ProxyStoreException#ProxyStoreException(String, Throwable)}.
   *
   * <ul>
   *   <li>Then return Message is {@code An error occurred}.
   * </ul>
   *
   * <p>Method under test: {@link ProxyStoreException#ProxyStoreException(String, Throwable)}
   */
  @Test
  @DisplayName(
      "Test new ProxyStoreException(String, Throwable); then return Message is 'An error occurred'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ProxyStoreException.<init>()",
    "void ProxyStoreException.<init>(String)",
    "void ProxyStoreException.<init>(String, Throwable)",
    "void ProxyStoreException.<init>(String, Throwable, boolean, boolean)",
    "void ProxyStoreException.<init>(Throwable)"
  })
  void testNewProxyStoreException_thenReturnMessageIsAnErrorOccurred() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    ProxyStoreException actualProxyStoreException =
        new ProxyStoreException("An error occurred", cause);

    // Assert
    assertEquals("An error occurred", actualProxyStoreException.getMessage());
    assertEquals(0, actualProxyStoreException.getSuppressed().length);
    assertSame(cause, actualProxyStoreException.getCause());
  }

  /**
   * Test {@link ProxyStoreException#ProxyStoreException()}.
   *
   * <ul>
   *   <li>Then return Message is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ProxyStoreException#ProxyStoreException()}
   */
  @Test
  @DisplayName("Test new ProxyStoreException(); then return Message is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ProxyStoreException.<init>()",
    "void ProxyStoreException.<init>(String)",
    "void ProxyStoreException.<init>(String, Throwable)",
    "void ProxyStoreException.<init>(String, Throwable, boolean, boolean)",
    "void ProxyStoreException.<init>(Throwable)"
  })
  void testNewProxyStoreException_thenReturnMessageIsNull() {
    // Arrange and Act
    ProxyStoreException actualProxyStoreException = new ProxyStoreException();

    // Assert
    assertNull(actualProxyStoreException.getMessage());
    assertNull(actualProxyStoreException.getCause());
    assertEquals(0, actualProxyStoreException.getSuppressed().length);
  }

  /**
   * Test {@link ProxyStoreException#ProxyStoreException(String)}.
   *
   * <ul>
   *   <li>When {@code An error occurred}.
   *   <li>Then return Cause is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ProxyStoreException#ProxyStoreException(String)}
   */
  @Test
  @DisplayName(
      "Test new ProxyStoreException(String); when 'An error occurred'; then return Cause is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ProxyStoreException.<init>()",
    "void ProxyStoreException.<init>(String)",
    "void ProxyStoreException.<init>(String, Throwable)",
    "void ProxyStoreException.<init>(String, Throwable, boolean, boolean)",
    "void ProxyStoreException.<init>(Throwable)"
  })
  void testNewProxyStoreException_whenAnErrorOccurred_thenReturnCauseIsNull() {
    // Arrange and Act
    ProxyStoreException actualProxyStoreException = new ProxyStoreException("An error occurred");

    // Assert
    assertEquals("An error occurred", actualProxyStoreException.getMessage());
    assertNull(actualProxyStoreException.getCause());
    assertEquals(0, actualProxyStoreException.getSuppressed().length);
  }

  /**
   * Test {@link ProxyStoreException#ProxyStoreException(Throwable)}.
   *
   * <ul>
   *   <li>When {@link Throwable#Throwable()}.
   *   <li>Then return Message is {@code Throwable}.
   * </ul>
   *
   * <p>Method under test: {@link ProxyStoreException#ProxyStoreException(Throwable)}
   */
  @Test
  @DisplayName(
      "Test new ProxyStoreException(Throwable); when Throwable(); then return Message is 'java.lang.Throwable'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ProxyStoreException.<init>()",
    "void ProxyStoreException.<init>(String)",
    "void ProxyStoreException.<init>(String, Throwable)",
    "void ProxyStoreException.<init>(String, Throwable, boolean, boolean)",
    "void ProxyStoreException.<init>(Throwable)"
  })
  void testNewProxyStoreException_whenThrowable_thenReturnMessageIsJavaLangThrowable() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    ProxyStoreException actualProxyStoreException = new ProxyStoreException(cause);

    // Assert
    assertEquals("java.lang.Throwable", actualProxyStoreException.getMessage());
    assertEquals(0, actualProxyStoreException.getSuppressed().length);
    assertSame(cause, actualProxyStoreException.getCause());
  }

  /**
   * Test {@link ProxyStoreException#ProxyStoreException(String, Throwable, boolean, boolean)}.
   *
   * <ul>
   *   <li>When {@code true}.
   *   <li>Then return Message is {@code An error occurred}.
   * </ul>
   *
   * <p>Method under test: {@link ProxyStoreException#ProxyStoreException(String, Throwable,
   * boolean, boolean)}
   */
  @Test
  @DisplayName(
      "Test new ProxyStoreException(String, Throwable, boolean, boolean); when 'true'; then return Message is 'An error occurred'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ProxyStoreException.<init>()",
    "void ProxyStoreException.<init>(String)",
    "void ProxyStoreException.<init>(String, Throwable)",
    "void ProxyStoreException.<init>(String, Throwable, boolean, boolean)",
    "void ProxyStoreException.<init>(Throwable)"
  })
  void testNewProxyStoreException_whenTrue_thenReturnMessageIsAnErrorOccurred() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    ProxyStoreException actualProxyStoreException =
        new ProxyStoreException("An error occurred", cause, true, true);

    // Assert
    assertEquals("An error occurred", actualProxyStoreException.getMessage());
    assertEquals(0, actualProxyStoreException.getSuppressed().length);
    assertSame(cause, actualProxyStoreException.getCause());
  }
}
