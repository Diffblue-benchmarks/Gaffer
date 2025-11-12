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

package uk.gov.gchq.gaffer.commonutil;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import org.junit.jupiter.api.Test;

class ByteBufferUtilDiffblueTest {
  /**
   * Method under test: {@link ByteBufferUtil#toBytes(ByteBuffer)}
   */
  @Test
  void testToBytes() throws UnsupportedEncodingException {
    // Arrange and Act
    byte[] actualToBytesResult = ByteBufferUtil.toBytes(ByteBuffer.wrap("AXAXAXAX".getBytes("UTF-8")));

    // Assert
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualToBytesResult);
  }

  /**
   * Method under test: {@link ByteBufferUtil#toBytes(ByteBuffer)}
   */
  @Test
  void testToBytes2() {
    // Arrange, Act and Assert
    assertNull(ByteBufferUtil.toBytes(null));
  }

  /**
   * Method under test: {@link ByteBufferUtil#toString(ByteBuffer)}
   */
  @Test
  void testToString() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertEquals("AXAXAXAX", ByteBufferUtil.toString(ByteBuffer.wrap("AXAXAXAX".getBytes("UTF-8"))));
  }

  /**
   * Method under test: {@link ByteBufferUtil#toBytesList(Collection)}
   */
  @Test
  void testToBytesList() {
    // Arrange and Act
    List<byte[]> actualToBytesListResult = ByteBufferUtil.toBytesList(new ArrayList<>());

    // Assert
    assertTrue(actualToBytesListResult.isEmpty());
  }

  /**
   * Method under test: {@link ByteBufferUtil#toBytesList(Collection)}
   */
  @Test
  void testToBytesList2() {
    // Arrange and Act
    List<byte[]> actualToBytesListResult = ByteBufferUtil.toBytesList(null);

    // Assert
    assertNull(actualToBytesListResult);
  }

  /**
   * Method under test: {@link ByteBufferUtil#toBytesList(Collection)}
   */
  @Test
  void testToBytesList3() {
    // Arrange
    LinkedHashSet<ByteBuffer> bytesList = new LinkedHashSet<>();
    bytesList.add(null);

    // Act
    List<byte[]> actualToBytesListResult = ByteBufferUtil.toBytesList(bytesList);

    // Assert
    assertEquals(1, actualToBytesListResult.size());
    assertNull(actualToBytesListResult.get(0));
  }

  /**
   * Method under test: {@link ByteBufferUtil#toBytesList(Collection)}
   */
  @Test
  void testToBytesList4() throws UnsupportedEncodingException {
    // Arrange
    LinkedHashSet<ByteBuffer> bytesList = new LinkedHashSet<>();
    bytesList.add(ByteBuffer.wrap("AXAXAXAX".getBytes("UTF-8")));

    // Act
    List<byte[]> actualToBytesListResult = ByteBufferUtil.toBytesList(bytesList);

    // Assert
    assertEquals(1, actualToBytesListResult.size());
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualToBytesListResult.get(0));
  }

  /**
   * Method under test: {@link ByteBufferUtil#toBytesList(Collection)}
   */
  @Test
  void testToBytesList5() throws UnsupportedEncodingException {
    // Arrange
    ArrayList<ByteBuffer> bytesList = new ArrayList<>();
    bytesList.add(ByteBuffer.wrap("AXAXAXAX".getBytes("UTF-8")));
    bytesList.add(ByteBuffer.wrap("AXAXAXAX".getBytes("UTF-8")));

    // Act
    List<byte[]> actualToBytesListResult = ByteBufferUtil.toBytesList(bytesList);

    // Assert
    assertEquals(2, actualToBytesListResult.size());
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualToBytesListResult.get(0));
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualToBytesListResult.get(1));
  }

  /**
   * Method under test: {@link ByteBufferUtil#toByteArrayInputStream(ByteBuffer)}
   */
  @Test
  void testToByteArrayInputStream() throws IOException {
    // Arrange, Act and Assert
    byte[] byteArray = new byte[8];
    assertEquals(8,
        ByteBufferUtil.toByteArrayInputStream(ByteBuffer.wrap("AXAXAXAX".getBytes("UTF-8"))).read(byteArray));
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), byteArray);
  }
}
