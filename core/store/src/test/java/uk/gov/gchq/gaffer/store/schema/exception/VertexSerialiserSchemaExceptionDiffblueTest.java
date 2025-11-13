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

package uk.gov.gchq.gaffer.store.schema.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.core.exception.Status;

class VertexSerialiserSchemaExceptionDiffblueTest {
  /**
   * Test {@link VertexSerialiserSchemaException#VertexSerialiserSchemaException(String, String)}.
   *
   * <p>Method under test: {@link
   * VertexSerialiserSchemaException#VertexSerialiserSchemaException(String, String)}
   */
  @Test
  @DisplayName("Test new VertexSerialiserSchemaException(String, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void VertexSerialiserSchemaException.<init>(String, String)"})
  void testNewVertexSerialiserSchemaException() {
    // Arrange and Act
    VertexSerialiserSchemaException actualVertexSerialiserSchemaException =
        new VertexSerialiserSchemaException("This Vertex Serialiser", "That Vertex Serialiser");

    // Assert
    assertEquals(
        "Unable to merge schemas because of conflict with the vertex serialiser, options are: This Vertex"
            + " Serialiser and That Vertex Serialiser",
        actualVertexSerialiserSchemaException.getLocalizedMessage());
    assertEquals(
        "Unable to merge schemas because of conflict with the vertex serialiser, options are: This Vertex"
            + " Serialiser and That Vertex Serialiser",
        actualVertexSerialiserSchemaException.getMessage());
    assertNull(actualVertexSerialiserSchemaException.getCause());
    assertEquals(0, actualVertexSerialiserSchemaException.getSuppressed().length);
    assertEquals(Status.BAD_REQUEST, actualVertexSerialiserSchemaException.getStatus());
  }

  /**
   * Test {@link VertexSerialiserSchemaException#VertexSerialiserSchemaException(String,
   * Throwable)}.
   *
   * <p>Method under test: {@link
   * VertexSerialiserSchemaException#VertexSerialiserSchemaException(String, Throwable)}
   */
  @Test
  @DisplayName("Test new VertexSerialiserSchemaException(String, Throwable)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void VertexSerialiserSchemaException.<init>(String, Throwable)"})
  void testNewVertexSerialiserSchemaException2() {
    // Arrange
    Throwable e = new Throwable();

    // Act
    VertexSerialiserSchemaException actualVertexSerialiserSchemaException =
        new VertexSerialiserSchemaException("An error occurred", e);

    // Assert
    assertEquals("An error occurred", actualVertexSerialiserSchemaException.getLocalizedMessage());
    assertEquals("An error occurred", actualVertexSerialiserSchemaException.getMessage());
    assertEquals(0, actualVertexSerialiserSchemaException.getSuppressed().length);
    assertEquals(Status.BAD_REQUEST, actualVertexSerialiserSchemaException.getStatus());
    assertSame(e, actualVertexSerialiserSchemaException.getCause());
  }
}
