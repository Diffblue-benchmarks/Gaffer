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

package uk.gov.gchq.gaffer.accumulostore.operation.hdfs.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class BulkImportExceptionDiffblueTest {
  /**
   * Test {@link BulkImportException#BulkImportException(String, Throwable)}.
   * <ul>
   *   <li>Then return Message is {@code An error occurred}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BulkImportException#BulkImportException(String, Throwable)}
   */
  @Test
  @DisplayName("Test new BulkImportException(String, Throwable); then return Message is 'An error occurred'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void BulkImportException.<init>(String, Throwable)",
      "void BulkImportException.<init>(Throwable)"})
  void testNewBulkImportException_thenReturnMessageIsAnErrorOccurred() {
    // Arrange
    Throwable e = new Throwable();

    // Act
    BulkImportException actualBulkImportException = new BulkImportException("An error occurred", e);

    // Assert
    assertEquals("An error occurred", actualBulkImportException.getMessage());
    assertEquals(0, actualBulkImportException.getSuppressed().length);
    assertSame(e, actualBulkImportException.getCause());
  }

  /**
   * Test {@link BulkImportException#BulkImportException(Throwable)}.
   * <ul>
   *   <li>When {@link Throwable#Throwable()}.</li>
   *   <li>Then return Message is {@code Throwable}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BulkImportException#BulkImportException(Throwable)}
   */
  @Test
  @DisplayName("Test new BulkImportException(Throwable); when Throwable(); then return Message is 'java.lang.Throwable'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void BulkImportException.<init>(String, Throwable)",
      "void BulkImportException.<init>(Throwable)"})
  void testNewBulkImportException_whenThrowable_thenReturnMessageIsJavaLangThrowable() {
    // Arrange
    Throwable e = new Throwable();

    // Act
    BulkImportException actualBulkImportException = new BulkImportException(e);

    // Assert
    assertEquals("java.lang.Throwable", actualBulkImportException.getMessage());
    assertEquals(0, actualBulkImportException.getSuppressed().length);
    assertSame(e, actualBulkImportException.getCause());
  }
}
