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

package uk.gov.gchq.gaffer.operation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.core.exception.Status;

class OperationExceptionDiffblueTest {
  /**
   * Method under test: {@link OperationException#OperationException(String)}
   */
  @Test
  void testNewOperationException() {
    // Arrange and Act
    OperationException actualOperationException = new OperationException("An error occurred");

    // Assert
    assertEquals("An error occurred", actualOperationException.getLocalizedMessage());
    assertEquals("An error occurred", actualOperationException.getMessage());
    assertNull(actualOperationException.getCause());
    assertEquals(0, actualOperationException.getSuppressed().length);
    assertEquals(Status.INTERNAL_SERVER_ERROR, actualOperationException.getStatus());
  }

  /**
   * Method under test:
   * {@link OperationException#OperationException(String, Throwable)}
   */
  @Test
  void testNewOperationException2() {
    // Arrange
    Throwable e = new Throwable();

    // Act
    OperationException actualOperationException = new OperationException("An error occurred", e);

    // Assert
    assertEquals("An error occurred", actualOperationException.getLocalizedMessage());
    assertEquals("An error occurred", actualOperationException.getMessage());
    assertEquals(0, actualOperationException.getSuppressed().length);
    assertEquals(Status.INTERNAL_SERVER_ERROR, actualOperationException.getStatus());
    assertSame(e, actualOperationException.getCause());
  }

  /**
   * Method under test:
   * {@link OperationException#OperationException(String, Throwable, Status)}
   */
  @Test
  void testNewOperationException3() {
    // Arrange
    Throwable e = new Throwable();

    // Act
    OperationException actualOperationException = new OperationException("An error occurred", e, Status.CONTINUE);

    // Assert
    assertEquals("An error occurred", actualOperationException.getLocalizedMessage());
    assertEquals("An error occurred", actualOperationException.getMessage());
    assertEquals(0, actualOperationException.getSuppressed().length);
    assertEquals(Status.CONTINUE, actualOperationException.getStatus());
    assertSame(e, actualOperationException.getCause());
  }

  /**
   * Method under test:
   * {@link OperationException#OperationException(String, Status)}
   */
  @Test
  void testNewOperationException4() {
    // Arrange and Act
    OperationException actualOperationException = new OperationException("An error occurred", Status.CONTINUE);

    // Assert
    assertEquals("An error occurred", actualOperationException.getLocalizedMessage());
    assertEquals("An error occurred", actualOperationException.getMessage());
    assertNull(actualOperationException.getCause());
    assertEquals(0, actualOperationException.getSuppressed().length);
    assertEquals(Status.CONTINUE, actualOperationException.getStatus());
  }

  /**
   * Method under test: {@link OperationException#OperationException(Throwable)}
   */
  @Test
  void testNewOperationException5() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    OperationException actualOperationException = new OperationException(cause);

    // Assert
    assertEquals("java.lang.Throwable", actualOperationException.getLocalizedMessage());
    assertEquals("java.lang.Throwable", actualOperationException.getMessage());
    assertEquals(0, actualOperationException.getSuppressed().length);
    assertEquals(Status.INTERNAL_SERVER_ERROR, actualOperationException.getStatus());
    assertSame(cause, actualOperationException.getCause());
  }
}
