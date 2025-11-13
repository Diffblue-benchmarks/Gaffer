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

package uk.gov.gchq.gaffer.accumulostore.key.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.core.exception.Status;

class RangeFactoryExceptionDiffblueTest {
  /**
   * Test {@link RangeFactoryException#RangeFactoryException(String, Throwable)}.
   *
   * <p>Method under test: {@link RangeFactoryException#RangeFactoryException(String, Throwable)}
   */
  @Test
  @DisplayName("Test new RangeFactoryException(String, Throwable)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void RangeFactoryException.<init>(String, Throwable)"})
  void testNewRangeFactoryException() {
    // Arrange
    Throwable e = new Throwable();

    // Act
    RangeFactoryException actualRangeFactoryException =
        new RangeFactoryException("An error occurred", e);

    // Assert
    assertEquals("An error occurred", actualRangeFactoryException.getLocalizedMessage());
    assertEquals("An error occurred", actualRangeFactoryException.getMessage());
    assertEquals(0, actualRangeFactoryException.getSuppressed().length);
    assertEquals(Status.INTERNAL_SERVER_ERROR, actualRangeFactoryException.getStatus());
    assertSame(e, actualRangeFactoryException.getCause());
  }
}
