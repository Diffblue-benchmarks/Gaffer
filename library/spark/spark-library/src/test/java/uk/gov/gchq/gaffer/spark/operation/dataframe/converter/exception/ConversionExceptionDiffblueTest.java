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

package uk.gov.gchq.gaffer.spark.operation.dataframe.converter.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import org.junit.jupiter.api.Test;

class ConversionExceptionDiffblueTest {
  /**
   * Method under test: {@link ConversionException#ConversionException(String)}
   */
  @Test
  void testNewConversionException() {
    // Arrange and Act
    ConversionException actualConversionException = new ConversionException("An error occurred");

    // Assert
    assertEquals("An error occurred", actualConversionException.getMessage());
    assertNull(actualConversionException.getCause());
    assertEquals(0, actualConversionException.getSuppressed().length);
  }

  /**
   * Method under test:
   * {@link ConversionException#ConversionException(String, Throwable)}
   */
  @Test
  void testNewConversionException2() {
    // Arrange
    Throwable e = new Throwable();

    // Act
    ConversionException actualConversionException = new ConversionException("An error occurred", e);

    // Assert
    assertEquals("An error occurred", actualConversionException.getMessage());
    assertEquals(0, actualConversionException.getSuppressed().length);
    assertSame(e, actualConversionException.getCause());
  }
}
