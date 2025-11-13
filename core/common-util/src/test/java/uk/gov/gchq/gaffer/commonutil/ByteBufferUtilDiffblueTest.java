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
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ByteBufferUtilDiffblueTest {
  /**
   * Test {@link ByteBufferUtil#toBytes(ByteBuffer)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ByteBufferUtil#toBytes(ByteBuffer)}
   */
  @Test
  @DisplayName("Test toBytes(ByteBuffer); when 'null'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"byte[] ByteBufferUtil.toBytes(ByteBuffer)"})
  void testToBytes_whenNull_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(ByteBufferUtil.toBytes(null));
  }

  /**
   * Test {@link ByteBufferUtil#toBytes(ByteBuffer)}.
   * <ul>
   *   <li>When wrap {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   *   <li>Then return {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ByteBufferUtil#toBytes(ByteBuffer)}
   */
  @Test
  @DisplayName("Test toBytes(ByteBuffer); when wrap 'AXAXAXAX' Bytes is 'UTF-8'; then return 'AXAXAXAX' Bytes is 'UTF-8'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"byte[] ByteBufferUtil.toBytes(ByteBuffer)"})
  void testToBytes_whenWrapAxaxaxaxBytesIsUtf8_thenReturnAxaxaxaxBytesIsUtf8() throws UnsupportedEncodingException {
    // Arrange and Act
    byte[] actualToBytesResult = ByteBufferUtil.toBytes(ByteBuffer.wrap("AXAXAXAX".getBytes("UTF-8")));

    // Assert
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualToBytesResult);
  }

  /**
   * Test {@link ByteBufferUtil#toString(ByteBuffer)} with {@code ByteBuffer}.
   * <ul>
   *   <li>When wrap {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   *   <li>Then return {@code AXAXAXAX}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ByteBufferUtil#toString(ByteBuffer)}
   */
  @Test
  @DisplayName("Test toString(ByteBuffer) with 'ByteBuffer'; when wrap 'AXAXAXAX' Bytes is 'UTF-8'; then return 'AXAXAXAX'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String ByteBufferUtil.toString(ByteBuffer)"})
  void testToStringWithByteBuffer_whenWrapAxaxaxaxBytesIsUtf8_thenReturnAxaxaxax() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertEquals("AXAXAXAX", ByteBufferUtil.toString(ByteBuffer.wrap("AXAXAXAX".getBytes("UTF-8"))));
  }

  /**
   * Test {@link ByteBufferUtil#toBytesList(Collection)}.
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>When {@link LinkedHashSet#LinkedHashSet()} add {@code null}.</li>
   *   <li>Then return first is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ByteBufferUtil#toBytesList(Collection)}
   */
  @Test
  @DisplayName("Test toBytesList(Collection); given 'null'; when LinkedHashSet() add 'null'; then return first is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List ByteBufferUtil.toBytesList(Collection)"})
  void testToBytesList_givenNull_whenLinkedHashSetAddNull_thenReturnFirstIsNull() {
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
   * Test {@link ByteBufferUtil#toBytesList(Collection)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()} add wrap {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   *   <li>Then return size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link ByteBufferUtil#toBytesList(Collection)}
   */
  @Test
  @DisplayName("Test toBytesList(Collection); when ArrayList() add wrap 'AXAXAXAX' Bytes is 'UTF-8'; then return size is two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List ByteBufferUtil.toBytesList(Collection)"})
  void testToBytesList_whenArrayListAddWrapAxaxaxaxBytesIsUtf8_thenReturnSizeIsTwo()
      throws UnsupportedEncodingException {
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
   * Test {@link ByteBufferUtil#toBytesList(Collection)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link ByteBufferUtil#toBytesList(Collection)}
   */
  @Test
  @DisplayName("Test toBytesList(Collection); when ArrayList(); then return Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List ByteBufferUtil.toBytesList(Collection)"})
  void testToBytesList_whenArrayList_thenReturnEmpty() {
    // Arrange and Act
    List<byte[]> actualToBytesListResult = ByteBufferUtil.toBytesList(new ArrayList<>());

    // Assert
    assertTrue(actualToBytesListResult.isEmpty());
  }

  /**
   * Test {@link ByteBufferUtil#toBytesList(Collection)}.
   * <ul>
   *   <li>When {@link LinkedHashSet#LinkedHashSet()} add wrap {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   *   <li>Then return size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link ByteBufferUtil#toBytesList(Collection)}
   */
  @Test
  @DisplayName("Test toBytesList(Collection); when LinkedHashSet() add wrap 'AXAXAXAX' Bytes is 'UTF-8'; then return size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List ByteBufferUtil.toBytesList(Collection)"})
  void testToBytesList_whenLinkedHashSetAddWrapAxaxaxaxBytesIsUtf8_thenReturnSizeIsOne()
      throws UnsupportedEncodingException {
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
   * Test {@link ByteBufferUtil#toBytesList(Collection)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ByteBufferUtil#toBytesList(Collection)}
   */
  @Test
  @DisplayName("Test toBytesList(Collection); when 'null'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List ByteBufferUtil.toBytesList(Collection)"})
  void testToBytesList_whenNull_thenReturnNull() {
    // Arrange and Act
    List<byte[]> actualToBytesListResult = ByteBufferUtil.toBytesList(null);

    // Assert
    assertNull(actualToBytesListResult);
  }

  /**
   * Test {@link ByteBufferUtil#toByteArrayInputStream(ByteBuffer)}.
   * <ul>
   *   <li>When wrap {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   *   <li>Then return read is eight.</li>
   * </ul>
   * <p>
   * Method under test: {@link ByteBufferUtil#toByteArrayInputStream(ByteBuffer)}
   */
  @Test
  @DisplayName("Test toByteArrayInputStream(ByteBuffer); when wrap 'AXAXAXAX' Bytes is 'UTF-8'; then return read is eight")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.io.ByteArrayInputStream ByteBufferUtil.toByteArrayInputStream(ByteBuffer)"})
  void testToByteArrayInputStream_whenWrapAxaxaxaxBytesIsUtf8_thenReturnReadIsEight() throws IOException {
    // Arrange, Act and Assert
    byte[] byteArray = new byte[8];
    assertEquals(8,
        ByteBufferUtil.toByteArrayInputStream(ByteBuffer.wrap("AXAXAXAX".getBytes("UTF-8"))).read(byteArray));
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), byteArray);
  }
}
