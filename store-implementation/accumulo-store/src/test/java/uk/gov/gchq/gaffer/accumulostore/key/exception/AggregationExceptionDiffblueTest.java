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
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import org.junit.jupiter.api.Test;

class AggregationExceptionDiffblueTest {
  /**
   * Method under test: {@link AggregationException#AggregationException(String)}
   */
  @Test
  void testNewAggregationException() {
    // Arrange and Act
    AggregationException actualAggregationException = new AggregationException("An error occurred");

    // Assert
    assertEquals("An error occurred", actualAggregationException.getMessage());
    assertNull(actualAggregationException.getCause());
    assertEquals(0, actualAggregationException.getSuppressed().length);
  }

  /**
   * Method under test:
   * {@link AggregationException#AggregationException(String, Throwable)}
   */
  @Test
  void testNewAggregationException2() {
    // Arrange
    Throwable e = new Throwable();

    // Act
    AggregationException actualAggregationException = new AggregationException("An error occurred", e);

    // Assert
    assertEquals("An error occurred", actualAggregationException.getMessage());
    assertEquals(0, actualAggregationException.getSuppressed().length);
    assertSame(e, actualAggregationException.getCause());
  }
}
