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

package uk.gov.gchq.gaffer.data.elementdefinition.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.core.exception.Status;

class SchemaExceptionDiffblueTest {
  /**
   * Method under test: {@link SchemaException#prependToMessage(String)}
   */
  @Test
  void testPrependToMessage() {
    // Arrange
    SchemaException schemaException = new SchemaException("An error occurred");

    // Act and Assert
    assertSame(schemaException, schemaException.prependToMessage("An error occurred"));
  }

  /**
   * Method under test: {@link SchemaException#prependToMessage(String)}
   */
  @Test
  void testPrependToMessage2() {
    // Arrange
    SchemaException schemaException = new SchemaException("An error occurred");
    schemaException.prependToMessage(null);

    // Act and Assert
    assertSame(schemaException, schemaException.prependToMessage("An error occurred"));
  }

  /**
   * Method under test: {@link SchemaException#getMessage()}
   */
  @Test
  void testGetMessage() {
    // Arrange
    SchemaException schemaException = new SchemaException("An error occurred");

    // Act and Assert
    assertEquals("An error occurred", schemaException.getLocalizedMessage());
    assertEquals("An error occurred", schemaException.getMessage());
  }

  /**
   * Method under test: {@link SchemaException#SchemaException(String)}
   */
  @Test
  void testNewSchemaException() {
    // Arrange and Act
    SchemaException actualSchemaException = new SchemaException("An error occurred");

    // Assert
    assertEquals("An error occurred", actualSchemaException.getLocalizedMessage());
    assertEquals("An error occurred", actualSchemaException.getMessage());
    assertNull(actualSchemaException.getCause());
    assertEquals(0, actualSchemaException.getSuppressed().length);
    assertEquals(Status.BAD_REQUEST, actualSchemaException.getStatus());
  }

  /**
   * Method under test: {@link SchemaException#SchemaException(String, Throwable)}
   */
  @Test
  void testNewSchemaException2() {
    // Arrange
    Throwable e = new Throwable();

    // Act
    SchemaException actualSchemaException = new SchemaException("An error occurred", e);

    // Assert
    assertEquals("An error occurred", actualSchemaException.getLocalizedMessage());
    assertEquals("An error occurred", actualSchemaException.getMessage());
    assertEquals(0, actualSchemaException.getSuppressed().length);
    assertEquals(Status.BAD_REQUEST, actualSchemaException.getStatus());
    assertSame(e, actualSchemaException.getCause());
  }
}
