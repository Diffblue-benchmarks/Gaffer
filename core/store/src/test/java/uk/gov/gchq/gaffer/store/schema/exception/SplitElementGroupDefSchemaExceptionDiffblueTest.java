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
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.core.exception.Status;

class SplitElementGroupDefSchemaExceptionDiffblueTest {
  /**
   * Test {@link SplitElementGroupDefSchemaException#SplitElementGroupDefSchemaException(String)}.
   * <p>
   * Method under test: {@link SplitElementGroupDefSchemaException#SplitElementGroupDefSchemaException(String)}
   */
  @Test
  @DisplayName("Test new SplitElementGroupDefSchemaException(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void SplitElementGroupDefSchemaException.<init>(String)"})
  void testNewSplitElementGroupDefSchemaException() {
    // Arrange and Act
    SplitElementGroupDefSchemaException actualSplitElementGroupDefSchemaException = new SplitElementGroupDefSchemaException(
        "Shared Group");

    // Assert
    assertEquals(
        "Element group properties cannot be defined in different schema parts, they must all be defined in a"
            + " single schema part. Please fix this group: Shared Group",
        actualSplitElementGroupDefSchemaException.getLocalizedMessage());
    assertEquals(
        "Element group properties cannot be defined in different schema parts, they must all be defined in a"
            + " single schema part. Please fix this group: Shared Group",
        actualSplitElementGroupDefSchemaException.getMessage());
    assertNull(actualSplitElementGroupDefSchemaException.getCause());
    assertEquals(0, actualSplitElementGroupDefSchemaException.getSuppressed().length);
    assertEquals(Status.BAD_REQUEST, actualSplitElementGroupDefSchemaException.getStatus());
  }

  /**
   * Test {@link SplitElementGroupDefSchemaException#SplitElementGroupDefSchemaException(String, Throwable)}.
   * <p>
   * Method under test: {@link SplitElementGroupDefSchemaException#SplitElementGroupDefSchemaException(String, Throwable)}
   */
  @Test
  @DisplayName("Test new SplitElementGroupDefSchemaException(String, Throwable)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void SplitElementGroupDefSchemaException.<init>(String, Throwable)"})
  void testNewSplitElementGroupDefSchemaException2() {
    // Arrange
    Throwable e = new Throwable();

    // Act
    SplitElementGroupDefSchemaException actualSplitElementGroupDefSchemaException = new SplitElementGroupDefSchemaException(
        "An error occurred", e);

    // Assert
    assertEquals("An error occurred", actualSplitElementGroupDefSchemaException.getLocalizedMessage());
    assertEquals("An error occurred", actualSplitElementGroupDefSchemaException.getMessage());
    assertEquals(0, actualSplitElementGroupDefSchemaException.getSuppressed().length);
    assertEquals(Status.BAD_REQUEST, actualSplitElementGroupDefSchemaException.getStatus());
    assertSame(e, actualSplitElementGroupDefSchemaException.getCause());
  }
}
