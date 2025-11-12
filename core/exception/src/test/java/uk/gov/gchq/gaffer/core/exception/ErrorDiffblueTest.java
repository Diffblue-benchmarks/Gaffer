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

package uk.gov.gchq.gaffer.core.exception;

import static org.junit.jupiter.api.Assertions.assertSame;
import org.junit.jupiter.api.Test;

class ErrorDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link Error.ErrorBuilder}
   *   <li>{@link Error.ErrorBuilder#detailMessage(String)}
   *   <li>{@link Error.ErrorBuilder#simpleMessage(String)}
   * </ul>
   */
  @Test
  void testErrorBuilderNewErrorBuilder() {
    // Arrange and Act
    Error.ErrorBuilder actualDetailMessageResult = (new Error.ErrorBuilder()).detailMessage("Detail Message");

    // Assert
    assertSame(actualDetailMessageResult, actualDetailMessageResult.simpleMessage("Simple Message"));
  }

  /**
   * Method under test: {@link Error.ErrorBuilder#status(Status)}
   */
  @Test
  void testErrorBuilderStatus() {
    // Arrange
    Error.ErrorBuilder errorBuilder = new Error.ErrorBuilder();

    // Act and Assert
    assertSame(errorBuilder, errorBuilder.status(Status.CONTINUE));
  }

  /**
   * Method under test: {@link Error.ErrorBuilder#statusCode(int)}
   */
  @Test
  void testErrorBuilderStatusCode() {
    // Arrange
    Error.ErrorBuilder errorBuilder = new Error.ErrorBuilder();

    // Act and Assert
    assertSame(errorBuilder, errorBuilder.statusCode(100));
  }
}
