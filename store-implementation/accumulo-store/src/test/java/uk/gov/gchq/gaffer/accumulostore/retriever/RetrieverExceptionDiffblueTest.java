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

package uk.gov.gchq.gaffer.accumulostore.retriever;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.core.exception.Status;

class RetrieverExceptionDiffblueTest {
  /**
   * Test {@link RetrieverException#RetrieverException(String, Throwable)}.
   *
   * <p>Method under test: {@link RetrieverException#RetrieverException(String, Throwable)}
   */
  @Test
  @DisplayName("Test new RetrieverException(String, Throwable)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void RetrieverException.<init>(String, Throwable)"})
  void testNewRetrieverException() {
    // Arrange
    Throwable e = new Throwable();

    // Act
    RetrieverException actualRetrieverException = new RetrieverException("An error occurred", e);

    // Assert
    assertEquals("An error occurred", actualRetrieverException.getLocalizedMessage());
    assertEquals("An error occurred", actualRetrieverException.getMessage());
    assertEquals(0, actualRetrieverException.getSuppressed().length);
    assertEquals(Status.INTERNAL_SERVER_ERROR, actualRetrieverException.getStatus());
    assertSame(e, actualRetrieverException.getCause());
  }

  /**
   * Test {@link RetrieverException#RetrieverException(Throwable)}.
   *
   * <p>Method under test: {@link RetrieverException#RetrieverException(Throwable)}
   */
  @Test
  @DisplayName("Test new RetrieverException(Throwable)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void RetrieverException.<init>(Throwable)"})
  void testNewRetrieverException2() {
    // Arrange
    Throwable e = new Throwable();

    // Act
    RetrieverException actualRetrieverException = new RetrieverException(e);

    // Assert
    assertEquals("java.lang.Throwable", actualRetrieverException.getLocalizedMessage());
    assertEquals("java.lang.Throwable", actualRetrieverException.getMessage());
    assertEquals(0, actualRetrieverException.getSuppressed().length);
    assertEquals(Status.INTERNAL_SERVER_ERROR, actualRetrieverException.getStatus());
    assertSame(e, actualRetrieverException.getCause());
  }
}
