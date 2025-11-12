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

package uk.gov.gchq.gaffer.flink.operation.handler.serialisation;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import org.junit.Test;

public class ByteArraySchemaDiffblueTest {
  /**
   * Method under test: {@link ByteArraySchema#deserialize(byte[])}
   */
  @Test
  public void testDeserialize() throws IOException {
    // Arrange
    ByteArraySchema byteArraySchema = new ByteArraySchema();
    byte[] bytes = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertSame(bytes, byteArraySchema.deserialize(bytes));
  }

  /**
   * Method under test: {@link ByteArraySchema#isEndOfStream(byte[])}
   */
  @Test
  public void testIsEndOfStream() throws UnsupportedEncodingException {
    // Arrange
    ByteArraySchema byteArraySchema = new ByteArraySchema();

    // Act and Assert
    assertFalse(byteArraySchema.isEndOfStream("AXAXAXAX".getBytes("UTF-8")));
  }
}
