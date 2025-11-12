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

package uk.gov.gchq.gaffer.commonutil.elementvisibilityutil;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import org.junit.jupiter.api.Test;

class ArrayByteSequenceDiffblueTest {
  /**
   * Method under test: {@link ArrayByteSequence#byteAt(int)}
   */
  @Test
  void testByteAt() {
    // Arrange, Act and Assert
    assertEquals('o', (new ArrayByteSequence("foo")).byteAt(1));
    assertThrows(IllegalArgumentException.class, () -> (new ArrayByteSequence("foo")).byteAt(-1));
    assertThrows(IllegalArgumentException.class, () -> (new ArrayByteSequence("")).byteAt(1));
  }

  /**
   * Method under test: {@link ArrayByteSequence#toArray()}
   */
  @Test
  void testToArray() throws UnsupportedEncodingException {
    // Arrange and Act
    byte[] actualToArrayResult = (new ArrayByteSequence("foo")).toArray();

    // Assert
    assertArrayEquals("foo".getBytes("UTF-8"), actualToArrayResult);
  }

  /**
   * Method under test: {@link ArrayByteSequence#toArray()}
   */
  @Test
  void testToArray2() throws UnsupportedEncodingException {
    // Arrange
    ByteBuffer buffer = ByteBuffer.wrap(new byte[]{'A', 3, 'A', 3, 'A', 3, 'A', 3});
    buffer.put(ByteBuffer.wrap("AXAXAXAX".getBytes("UTF-8")));

    // Act and Assert
    assertEquals(0, (new ArrayByteSequence(buffer)).toArray().length);
  }

  /**
   * Method under test: {@link ArrayByteSequence#subSequence(int, int)}
   */
  @Test
  void testSubSequence() throws UnsupportedEncodingException {
    // Arrange and Act
    ArrayByteSequence actualSubSequenceResult = (new ArrayByteSequence("foo")).subSequence(1, 3);

    // Assert
    assertEquals(1, actualSubSequenceResult.offset());
    assertEquals(1, actualSubSequenceResult.offset);
    assertEquals(2, actualSubSequenceResult.length());
    assertEquals(2, actualSubSequenceResult.length);
    assertTrue(actualSubSequenceResult.isBackedByArray());
    byte[] expectedBackingArray = "foo".getBytes("UTF-8");
    assertArrayEquals(expectedBackingArray, actualSubSequenceResult.getBackingArray());
    assertArrayEquals(new byte[]{'o', 'o'}, actualSubSequenceResult.toArray());
  }

  /**
   * Method under test: {@link ArrayByteSequence#subSequence(int, int)}
   */
  @Test
  void testSubSequence2() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> (new ArrayByteSequence("foo")).subSequence(-1, 3));
  }

  /**
   * Method under test: {@link ArrayByteSequence#subSequence(int, int)}
   */
  @Test
  void testSubSequence3() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> (new ArrayByteSequence("42")).subSequence(1, 3));
  }

  /**
   * Method under test: {@link ArrayByteSequence#subSequence(int, int)}
   */
  @Test
  void testSubSequence4() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> (new ArrayByteSequence("foo")).subSequence(255, 3));
  }

  /**
   * Method under test:
   * {@link ArrayByteSequence#compareBytes(ArrayByteSequence, ArrayByteSequence)}
   */
  @Test
  void testCompareBytes() {
    // Arrange
    ArrayByteSequence bs1 = new ArrayByteSequence("foo");

    // Act and Assert
    assertEquals(0, ArrayByteSequence.compareBytes(bs1, new ArrayByteSequence("foo")));
  }

  /**
   * Method under test:
   * {@link ArrayByteSequence#compareBytes(ArrayByteSequence, ArrayByteSequence)}
   */
  @Test
  void testCompareBytes2() {
    // Arrange
    ArrayByteSequence bs1 = new ArrayByteSequence(
        "uk.gov.gchq.gaffer.commonutil.elementvisibilityutil.ArrayByteSequence");

    // Act and Assert
    assertEquals(15, ArrayByteSequence.compareBytes(bs1, new ArrayByteSequence("foo")));
  }

  /**
   * Method under test: {@link ArrayByteSequence#compareTo(ArrayByteSequence)}
   */
  @Test
  void testCompareTo() {
    // Arrange
    ArrayByteSequence arrayByteSequence = new ArrayByteSequence("foo");

    // Act and Assert
    assertEquals(0, arrayByteSequence.compareTo(new ArrayByteSequence("foo")));
  }

  /**
   * Method under test: {@link ArrayByteSequence#compareTo(ArrayByteSequence)}
   */
  @Test
  void testCompareTo2() {
    // Arrange
    ArrayByteSequence arrayByteSequence = new ArrayByteSequence("");

    // Act and Assert
    assertEquals(-3, arrayByteSequence.compareTo(new ArrayByteSequence("foo")));
  }

  /**
   * Method under test: {@link ArrayByteSequence#compareTo(ArrayByteSequence)}
   */
  @Test
  void testCompareTo3() throws UnsupportedEncodingException {
    // Arrange
    ByteBuffer buffer = ByteBuffer.wrap(new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1});
    buffer.put(ByteBuffer.wrap("AXAXAXAX".getBytes("UTF-8")));
    ArrayByteSequence arrayByteSequence = new ArrayByteSequence(buffer);

    // Act and Assert
    assertEquals(-3, arrayByteSequence.compareTo(new ArrayByteSequence("foo")));
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ArrayByteSequence#equals(Object)}
   *   <li>{@link ArrayByteSequence#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ArrayByteSequence arrayByteSequence = new ArrayByteSequence("foo");
    ArrayByteSequence arrayByteSequence2 = new ArrayByteSequence("foo");

    // Act and Assert
    assertEquals(arrayByteSequence, arrayByteSequence2);
    int expectedHashCodeResult = arrayByteSequence.hashCode();
    assertEquals(expectedHashCodeResult, arrayByteSequence2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ArrayByteSequence#equals(Object)}
   *   <li>{@link ArrayByteSequence#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ArrayByteSequence arrayByteSequence = new ArrayByteSequence("foo");

    // Act and Assert
    assertEquals(arrayByteSequence, arrayByteSequence);
    int expectedHashCodeResult = arrayByteSequence.hashCode();
    assertEquals(expectedHashCodeResult, arrayByteSequence.hashCode());
  }

  /**
   * Method under test: {@link ArrayByteSequence#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ArrayByteSequence arrayByteSequence = new ArrayByteSequence(
        "uk.gov.gchq.gaffer.commonutil.elementvisibilityutil.ArrayByteSequence");

    // Act and Assert
    assertNotEquals(arrayByteSequence, new ArrayByteSequence("foo"));
  }

  /**
   * Method under test: {@link ArrayByteSequence#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new ArrayByteSequence("foo"), null);
  }

  /**
   * Method under test: {@link ArrayByteSequence#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new ArrayByteSequence("foo"), "Different type to ArrayByteSequence");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ArrayByteSequence#toString()}
   *   <li>{@link ArrayByteSequence#getBackingArray()}
   *   <li>{@link ArrayByteSequence#isBackedByArray()}
   *   <li>{@link ArrayByteSequence#length()}
   *   <li>{@link ArrayByteSequence#offset()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() throws UnsupportedEncodingException {
    // Arrange
    ArrayByteSequence arrayByteSequence = new ArrayByteSequence("foo");

    // Act
    String actualToStringResult = arrayByteSequence.toString();
    byte[] actualBackingArray = arrayByteSequence.getBackingArray();
    boolean actualIsBackedByArrayResult = arrayByteSequence.isBackedByArray();
    int actualLengthResult = arrayByteSequence.length();

    // Assert
    assertEquals("foo", actualToStringResult);
    assertEquals(0, arrayByteSequence.offset());
    assertEquals(3, actualLengthResult);
    assertTrue(actualIsBackedByArrayResult);
    assertArrayEquals("foo".getBytes("UTF-8"), actualBackingArray);
  }

  /**
   * Method under test: {@link ArrayByteSequence#ArrayByteSequence(String)}
   */
  @Test
  void testNewArrayByteSequence() throws UnsupportedEncodingException {
    // Arrange and Act
    ArrayByteSequence actualArrayByteSequence = new ArrayByteSequence("foo");

    // Assert
    assertEquals(0, actualArrayByteSequence.offset());
    assertEquals(0, actualArrayByteSequence.offset);
    assertEquals(3, actualArrayByteSequence.length());
    assertEquals(3, actualArrayByteSequence.length);
    assertTrue(actualArrayByteSequence.isBackedByArray());
    byte[] backingArray = actualArrayByteSequence.getBackingArray();
    assertSame(backingArray, actualArrayByteSequence.toArray());
    assertArrayEquals("foo".getBytes("UTF-8"), backingArray);
  }

  /**
   * Method under test: {@link ArrayByteSequence#ArrayByteSequence(ByteBuffer)}
   */
  @Test
  void testNewArrayByteSequence2() throws UnsupportedEncodingException {
    // Arrange and Act
    ArrayByteSequence actualArrayByteSequence = new ArrayByteSequence(ByteBuffer.wrap("AXAXAXAX".getBytes("UTF-8")));

    // Assert
    assertEquals(0, actualArrayByteSequence.offset());
    assertEquals(0, actualArrayByteSequence.offset);
    assertEquals(8, actualArrayByteSequence.length());
    assertEquals(8, actualArrayByteSequence.length);
    assertTrue(actualArrayByteSequence.isBackedByArray());
    byte[] backingArray = actualArrayByteSequence.getBackingArray();
    assertSame(backingArray, actualArrayByteSequence.toArray());
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), backingArray);
  }

  /**
   * Method under test: {@link ArrayByteSequence#ArrayByteSequence(byte[])}
   */
  @Test
  void testNewArrayByteSequence3() throws UnsupportedEncodingException {
    // Arrange
    byte[] data = "AXAXAXAX".getBytes("UTF-8");

    // Act
    ArrayByteSequence actualArrayByteSequence = new ArrayByteSequence(data);

    // Assert
    assertEquals(0, actualArrayByteSequence.offset());
    assertEquals(0, actualArrayByteSequence.offset);
    assertEquals(8, actualArrayByteSequence.length());
    assertEquals(8, actualArrayByteSequence.length);
    assertTrue(actualArrayByteSequence.isBackedByArray());
    assertSame(data, actualArrayByteSequence.getBackingArray());
    assertSame(data, actualArrayByteSequence.toArray());
  }

  /**
   * Method under test:
   * {@link ArrayByteSequence#ArrayByteSequence(byte[], int, int)}
   */
  @Test
  void testNewArrayByteSequence4() throws UnsupportedEncodingException {
    // Arrange
    byte[] data = "AXAXAXAX".getBytes("UTF-8");

    // Act
    ArrayByteSequence actualArrayByteSequence = new ArrayByteSequence(data, 2, 3);

    // Assert
    assertEquals(2, actualArrayByteSequence.offset());
    assertEquals(2, actualArrayByteSequence.offset);
    assertEquals(3, actualArrayByteSequence.length());
    assertEquals(3, actualArrayByteSequence.length);
    assertTrue(actualArrayByteSequence.isBackedByArray());
    assertSame(data, actualArrayByteSequence.getBackingArray());
    byte[] expectedToArrayResult = "AXA".getBytes("UTF-8");
    assertArrayEquals(expectedToArrayResult, actualArrayByteSequence.toArray());
  }

  /**
   * Method under test:
   * {@link ArrayByteSequence#ArrayByteSequence(byte[], int, int)}
   */
  @Test
  void testNewArrayByteSequence5() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> new ArrayByteSequence(new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'}, 0, -1));

  }

  /**
   * Method under test:
   * {@link ArrayByteSequence#ArrayByteSequence(byte[], int, int)}
   */
  @Test
  void testNewArrayByteSequence6() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> new ArrayByteSequence(new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'}, -1, 0));

  }

  /**
   * Method under test:
   * {@link ArrayByteSequence#ArrayByteSequence(byte[], int, int)}
   */
  @Test
  void testNewArrayByteSequence7() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> new ArrayByteSequence(new byte[]{}, 2, 3));

  }

  /**
   * Method under test:
   * {@link ArrayByteSequence#ArrayByteSequence(byte[], int, int)}
   */
  @Test
  void testNewArrayByteSequence8() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> new ArrayByteSequence("AXAXAXAX".getBytes("UTF-8"), 8, 3));

  }
}
