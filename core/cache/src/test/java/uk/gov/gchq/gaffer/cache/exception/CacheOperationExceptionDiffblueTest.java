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

package uk.gov.gchq.gaffer.cache.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.core.exception.Status;

class CacheOperationExceptionDiffblueTest {
  /**
   * Test {@link CacheOperationException#CacheOperationException()}.
   * <p>
   * Method under test: {@link CacheOperationException#CacheOperationException()}
   */
  @Test
  @DisplayName("Test new CacheOperationException()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void CacheOperationException.<init>()"})
  void testNewCacheOperationException() {
    // Arrange and Act
    CacheOperationException actualCacheOperationException = new CacheOperationException();

    // Assert
    assertNull(actualCacheOperationException.getLocalizedMessage());
    assertNull(actualCacheOperationException.getMessage());
    assertNull(actualCacheOperationException.getCause());
    assertEquals(0, actualCacheOperationException.getSuppressed().length);
    assertEquals(Status.INTERNAL_SERVER_ERROR, actualCacheOperationException.getStatus());
  }

  /**
   * Test {@link CacheOperationException#CacheOperationException(String)}.
   * <p>
   * Method under test: {@link CacheOperationException#CacheOperationException(String)}
   */
  @Test
  @DisplayName("Test new CacheOperationException(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void CacheOperationException.<init>(String)"})
  void testNewCacheOperationException2() {
    // Arrange and Act
    CacheOperationException actualCacheOperationException = new CacheOperationException("An error occurred");

    // Assert
    assertEquals("An error occurred", actualCacheOperationException.getLocalizedMessage());
    assertEquals("An error occurred", actualCacheOperationException.getMessage());
    assertNull(actualCacheOperationException.getCause());
    assertEquals(0, actualCacheOperationException.getSuppressed().length);
    assertEquals(Status.INTERNAL_SERVER_ERROR, actualCacheOperationException.getStatus());
  }

  /**
   * Test {@link CacheOperationException#CacheOperationException(String, Throwable)}.
   * <p>
   * Method under test: {@link CacheOperationException#CacheOperationException(String, Throwable)}
   */
  @Test
  @DisplayName("Test new CacheOperationException(String, Throwable)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void CacheOperationException.<init>(String, Throwable)"})
  void testNewCacheOperationException3() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    CacheOperationException actualCacheOperationException = new CacheOperationException("An error occurred", cause);

    // Assert
    assertEquals("An error occurred", actualCacheOperationException.getLocalizedMessage());
    assertEquals("An error occurred", actualCacheOperationException.getMessage());
    assertEquals(0, actualCacheOperationException.getSuppressed().length);
    assertEquals(Status.INTERNAL_SERVER_ERROR, actualCacheOperationException.getStatus());
    assertSame(cause, actualCacheOperationException.getCause());
  }

  /**
   * Test {@link CacheOperationException#CacheOperationException(String, Throwable, Status)}.
   * <p>
   * Method under test: {@link CacheOperationException#CacheOperationException(String, Throwable, Status)}
   */
  @Test
  @DisplayName("Test new CacheOperationException(String, Throwable, Status)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void CacheOperationException.<init>(String, Throwable, Status)"})
  void testNewCacheOperationException4() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    CacheOperationException actualCacheOperationException = new CacheOperationException("An error occurred", cause,
        Status.CONTINUE);

    // Assert
    assertEquals("An error occurred", actualCacheOperationException.getLocalizedMessage());
    assertEquals("An error occurred", actualCacheOperationException.getMessage());
    assertEquals(0, actualCacheOperationException.getSuppressed().length);
    assertEquals(Status.CONTINUE, actualCacheOperationException.getStatus());
    assertSame(cause, actualCacheOperationException.getCause());
  }

  /**
   * Test {@link CacheOperationException#CacheOperationException(String, Status)}.
   * <p>
   * Method under test: {@link CacheOperationException#CacheOperationException(String, Status)}
   */
  @Test
  @DisplayName("Test new CacheOperationException(String, Status)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void CacheOperationException.<init>(String, Status)"})
  void testNewCacheOperationException5() {
    // Arrange and Act
    CacheOperationException actualCacheOperationException = new CacheOperationException("An error occurred",
        Status.CONTINUE);

    // Assert
    assertEquals("An error occurred", actualCacheOperationException.getLocalizedMessage());
    assertEquals("An error occurred", actualCacheOperationException.getMessage());
    assertNull(actualCacheOperationException.getCause());
    assertEquals(0, actualCacheOperationException.getSuppressed().length);
    assertEquals(Status.CONTINUE, actualCacheOperationException.getStatus());
  }

  /**
   * Test {@link CacheOperationException#CacheOperationException(Throwable)}.
   * <p>
   * Method under test: {@link CacheOperationException#CacheOperationException(Throwable)}
   */
  @Test
  @DisplayName("Test new CacheOperationException(Throwable)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void CacheOperationException.<init>(Throwable)"})
  void testNewCacheOperationException6() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    CacheOperationException actualCacheOperationException = new CacheOperationException(cause);

    // Assert
    assertEquals("java.lang.Throwable", actualCacheOperationException.getLocalizedMessage());
    assertEquals("java.lang.Throwable", actualCacheOperationException.getMessage());
    assertEquals(0, actualCacheOperationException.getSuppressed().length);
    assertEquals(Status.INTERNAL_SERVER_ERROR, actualCacheOperationException.getStatus());
    assertSame(cause, actualCacheOperationException.getCause());
  }

  /**
   * Test {@link CacheOperationException#CacheOperationException(Throwable, Status)}.
   * <p>
   * Method under test: {@link CacheOperationException#CacheOperationException(Throwable, Status)}
   */
  @Test
  @DisplayName("Test new CacheOperationException(Throwable, Status)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void CacheOperationException.<init>(Throwable, Status)"})
  void testNewCacheOperationException7() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    CacheOperationException actualCacheOperationException = new CacheOperationException(cause, Status.CONTINUE);

    // Assert
    assertEquals("java.lang.Throwable", actualCacheOperationException.getLocalizedMessage());
    assertEquals("java.lang.Throwable", actualCacheOperationException.getMessage());
    assertEquals(0, actualCacheOperationException.getSuppressed().length);
    assertEquals(Status.CONTINUE, actualCacheOperationException.getStatus());
    assertSame(cause, actualCacheOperationException.getCause());
  }
}
