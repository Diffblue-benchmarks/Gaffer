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

package uk.gov.gchq.gaffer.commonutil.elementvisibilityutil;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ArrayByteSequenceDiffblueTest {
  /**
   * Test {@link ArrayByteSequence#ArrayByteSequence(String)}.
   *
   * <p>Method under test: {@link ArrayByteSequence#ArrayByteSequence(String)}
   */
  @Test
  @DisplayName("Test new ArrayByteSequence(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ArrayByteSequence.<init>(String)"})
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
   * Test {@link ArrayByteSequence#ArrayByteSequence(byte[])}.
   *
   * <p>Method under test: {@link ArrayByteSequence#ArrayByteSequence(byte[])}
   */
  @Test
  @DisplayName("Test new ArrayByteSequence(byte[])")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ArrayByteSequence.<init>(byte[])"})
  void testNewArrayByteSequence2() throws UnsupportedEncodingException {
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
    assertSame(data, actualArrayByteSequence.toArray());
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualArrayByteSequence.getBackingArray());
  }

  /**
   * Test {@link ArrayByteSequence#ArrayByteSequence(byte[], int, int)}.
   *
   * <ul>
   *   <li>When {@code A}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link ArrayByteSequence#ArrayByteSequence(byte[], int, int)}
   */
  @Test
  @DisplayName(
      "Test new ArrayByteSequence(byte[], int, int); when 'A'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ArrayByteSequence.<init>(byte[], int, int)"})
  void testNewArrayByteSequence_whenA_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> new ArrayByteSequence(new byte[] {'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'}, 0, -1));
  }

  /**
   * Test {@link ArrayByteSequence#ArrayByteSequence(byte[], int, int)}.
   *
   * <ul>
   *   <li>When {@code A}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link ArrayByteSequence#ArrayByteSequence(byte[], int, int)}
   */
  @Test
  @DisplayName(
      "Test new ArrayByteSequence(byte[], int, int); when 'A'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ArrayByteSequence.<init>(byte[], int, int)"})
  void testNewArrayByteSequence_whenA_thenThrowIllegalArgumentException2() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> new ArrayByteSequence(new byte[] {'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'}, -1, 0));
  }

  /**
   * Test {@link ArrayByteSequence#ArrayByteSequence(byte[], int, int)}.
   *
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.
   *   <li>Then return offset is two.
   * </ul>
   *
   * <p>Method under test: {@link ArrayByteSequence#ArrayByteSequence(byte[], int, int)}
   */
  @Test
  @DisplayName(
      "Test new ArrayByteSequence(byte[], int, int); when 'AXAXAXAX' Bytes is 'UTF-8'; then return offset is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ArrayByteSequence.<init>(byte[], int, int)"})
  void testNewArrayByteSequence_whenAxaxaxaxBytesIsUtf8_thenReturnOffsetIsTwo()
      throws UnsupportedEncodingException {
    // Arrange and Act
    ArrayByteSequence actualArrayByteSequence =
        new ArrayByteSequence("AXAXAXAX".getBytes("UTF-8"), 2, 3);

    // Assert
    assertEquals(2, actualArrayByteSequence.offset());
    assertEquals(2, actualArrayByteSequence.offset);
    assertEquals(3, actualArrayByteSequence.length());
    assertEquals(3, actualArrayByteSequence.length);
    assertTrue(actualArrayByteSequence.isBackedByArray());
    byte[] expectedToArrayResult = "AXA".getBytes("UTF-8");
    assertArrayEquals(expectedToArrayResult, actualArrayByteSequence.toArray());
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualArrayByteSequence.getBackingArray());
  }

  /**
   * Test {@link ArrayByteSequence#ArrayByteSequence(byte[], int, int)}.
   *
   * <ul>
   *   <li>When eight.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link ArrayByteSequence#ArrayByteSequence(byte[], int, int)}
   */
  @Test
  @DisplayName(
      "Test new ArrayByteSequence(byte[], int, int); when eight; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ArrayByteSequence.<init>(byte[], int, int)"})
  void testNewArrayByteSequence_whenEight_thenThrowIllegalArgumentException()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> new ArrayByteSequence("AXAXAXAX".getBytes("UTF-8"), 8, 3));
  }

  /**
   * Test {@link ArrayByteSequence#ArrayByteSequence(byte[], int, int)}.
   *
   * <ul>
   *   <li>When empty array of {@code byte}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link ArrayByteSequence#ArrayByteSequence(byte[], int, int)}
   */
  @Test
  @DisplayName(
      "Test new ArrayByteSequence(byte[], int, int); when empty array of byte; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ArrayByteSequence.<init>(byte[], int, int)"})
  void testNewArrayByteSequence_whenEmptyArrayOfByte_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> new ArrayByteSequence(new byte[] {}, 2, 3));
  }

  /**
   * Test {@link ArrayByteSequence#ArrayByteSequence(ByteBuffer)}.
   *
   * <ul>
   *   <li>When wrap {@code AXAXAXAX} Bytes is {@code UTF-8}.
   *   <li>Then return offset is zero.
   * </ul>
   *
   * <p>Method under test: {@link ArrayByteSequence#ArrayByteSequence(ByteBuffer)}
   */
  @Test
  @DisplayName(
      "Test new ArrayByteSequence(ByteBuffer); when wrap 'AXAXAXAX' Bytes is 'UTF-8'; then return offset is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ArrayByteSequence.<init>(ByteBuffer)"})
  void testNewArrayByteSequence_whenWrapAxaxaxaxBytesIsUtf8_thenReturnOffsetIsZero()
      throws UnsupportedEncodingException {
    // Arrange and Act
    ArrayByteSequence actualArrayByteSequence =
        new ArrayByteSequence(ByteBuffer.wrap("AXAXAXAX".getBytes("UTF-8")));

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
   * Test {@link ArrayByteSequence#byteAt(int)}.
   *
   * <ul>
   *   <li>Given {@link ArrayByteSequence#ArrayByteSequence(String)} with s is empty string.
   * </ul>
   *
   * <p>Method under test: {@link ArrayByteSequence#byteAt(int)}
   */
  @Test
  @DisplayName("Test byteAt(int); given ArrayByteSequence(String) with s is empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte ArrayByteSequence.byteAt(int)"})
  void testByteAt_givenArrayByteSequenceWithSIsEmptyString() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> new ArrayByteSequence("").byteAt(1));
  }

  /**
   * Test {@link ArrayByteSequence#byteAt(int)}.
   *
   * <ul>
   *   <li>Given {@link ArrayByteSequence#ArrayByteSequence(String)} with s is {@code foo}.
   *   <li>When one.
   *   <li>Then return {@code o}.
   * </ul>
   *
   * <p>Method under test: {@link ArrayByteSequence#byteAt(int)}
   */
  @Test
  @DisplayName(
      "Test byteAt(int); given ArrayByteSequence(String) with s is 'foo'; when one; then return 'o'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte ArrayByteSequence.byteAt(int)"})
  void testByteAt_givenArrayByteSequenceWithSIsFoo_whenOne_thenReturnO() {
    // Arrange, Act and Assert
    assertEquals('o', new ArrayByteSequence("foo").byteAt(1));
  }

  /**
   * Test {@link ArrayByteSequence#byteAt(int)}.
   *
   * <ul>
   *   <li>When minus one.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link ArrayByteSequence#byteAt(int)}
   */
  @Test
  @DisplayName("Test byteAt(int); when minus one; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte ArrayByteSequence.byteAt(int)"})
  void testByteAt_whenMinusOne_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> new ArrayByteSequence("foo").byteAt(-1));
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ArrayByteSequence#toString()}
   *   <li>{@link ArrayByteSequence#getBackingArray()}
   *   <li>{@link ArrayByteSequence#isBackedByArray()}
   *   <li>{@link ArrayByteSequence#length()}
   *   <li>{@link ArrayByteSequence#offset()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "byte[] ArrayByteSequence.getBackingArray()",
    "boolean ArrayByteSequence.isBackedByArray()",
    "int ArrayByteSequence.length()",
    "int ArrayByteSequence.offset()",
    "String ArrayByteSequence.toString()"
  })
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
   * Test {@link ArrayByteSequence#toArray()}.
   *
   * <ul>
   *   <li>Given {@code A}.
   *   <li>Then return empty array of {@code byte}.
   * </ul>
   *
   * <p>Method under test: {@link ArrayByteSequence#toArray()}
   */
  @Test
  @DisplayName("Test toArray(); given 'A'; then return empty array of byte")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] ArrayByteSequence.toArray()"})
  void testToArray_givenA_thenReturnEmptyArrayOfByte() throws UnsupportedEncodingException {
    // Arrange
    ByteBuffer buffer = ByteBuffer.wrap(new byte[] {'A', 3, 'A', 3, 'A', 3, 'A', 3});
    buffer.put(ByteBuffer.wrap("AXAXAXAX".getBytes("UTF-8")));

    // Act and Assert
    assertArrayEquals(new byte[] {}, new ArrayByteSequence(buffer).toArray());
  }

  /**
   * Test {@link ArrayByteSequence#toArray()}.
   *
   * <ul>
   *   <li>Given {@link ArrayByteSequence#ArrayByteSequence(String)} with s is {@code foo}.
   *   <li>Then return {@code foo} Bytes is {@code UTF-8}.
   * </ul>
   *
   * <p>Method under test: {@link ArrayByteSequence#toArray()}
   */
  @Test
  @DisplayName(
      "Test toArray(); given ArrayByteSequence(String) with s is 'foo'; then return 'foo' Bytes is 'UTF-8'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] ArrayByteSequence.toArray()"})
  void testToArray_givenArrayByteSequenceWithSIsFoo_thenReturnFooBytesIsUtf8()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertArrayEquals("foo".getBytes("UTF-8"), new ArrayByteSequence("foo").toArray());
  }

  /**
   * Test {@link ArrayByteSequence#subSequence(int, int)}.
   *
   * <ul>
   *   <li>Given {@link ArrayByteSequence#ArrayByteSequence(String)} with s is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ArrayByteSequence#subSequence(int, int)}
   */
  @Test
  @DisplayName("Test subSequence(int, int); given ArrayByteSequence(String) with s is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ArrayByteSequence ArrayByteSequence.subSequence(int, int)"})
  void testSubSequence_givenArrayByteSequenceWithSIs42() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> new ArrayByteSequence("42").subSequence(1, 3));
  }

  /**
   * Test {@link ArrayByteSequence#subSequence(int, int)}.
   *
   * <ul>
   *   <li>Given {@link ArrayByteSequence#ArrayByteSequence(String)} with s is {@code foo}.
   *   <li>When one.
   *   <li>Then return offset is one.
   * </ul>
   *
   * <p>Method under test: {@link ArrayByteSequence#subSequence(int, int)}
   */
  @Test
  @DisplayName(
      "Test subSequence(int, int); given ArrayByteSequence(String) with s is 'foo'; when one; then return offset is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ArrayByteSequence ArrayByteSequence.subSequence(int, int)"})
  void testSubSequence_givenArrayByteSequenceWithSIsFoo_whenOne_thenReturnOffsetIsOne()
      throws UnsupportedEncodingException {
    // Arrange and Act
    ArrayByteSequence actualSubSequenceResult = new ArrayByteSequence("foo").subSequence(1, 3);

    // Assert
    assertEquals(1, actualSubSequenceResult.offset());
    assertEquals(1, actualSubSequenceResult.offset);
    assertEquals(2, actualSubSequenceResult.length());
    assertEquals(2, actualSubSequenceResult.length);
    assertTrue(actualSubSequenceResult.isBackedByArray());
    assertArrayEquals("foo".getBytes("UTF-8"), actualSubSequenceResult.getBackingArray());
    assertArrayEquals(new byte[] {'o', 'o'}, actualSubSequenceResult.toArray());
  }

  /**
   * Test {@link ArrayByteSequence#subSequence(int, int)}.
   *
   * <ul>
   *   <li>When minus one.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link ArrayByteSequence#subSequence(int, int)}
   */
  @Test
  @DisplayName("Test subSequence(int, int); when minus one; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ArrayByteSequence ArrayByteSequence.subSequence(int, int)"})
  void testSubSequence_whenMinusOne_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> new ArrayByteSequence("foo").subSequence(-1, 3));
  }

  /**
   * Test {@link ArrayByteSequence#subSequence(int, int)}.
   *
   * <ul>
   *   <li>When zero.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link ArrayByteSequence#subSequence(int, int)}
   */
  @Test
  @DisplayName("Test subSequence(int, int); when zero; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ArrayByteSequence ArrayByteSequence.subSequence(int, int)"})
  void testSubSequence_whenZero_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> new ArrayByteSequence("foo").subSequence(1, 0));
  }

  /**
   * Test {@link ArrayByteSequence#compareBytes(ArrayByteSequence, ArrayByteSequence)}.
   *
   * <ul>
   *   <li>When {@code A}.
   *   <li>Then return minus thirty-seven.
   * </ul>
   *
   * <p>Method under test: {@link ArrayByteSequence#compareBytes(ArrayByteSequence,
   * ArrayByteSequence)}
   */
  @Test
  @DisplayName(
      "Test compareBytes(ArrayByteSequence, ArrayByteSequence); when 'A'; then return minus thirty-seven")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int ArrayByteSequence.compareBytes(ArrayByteSequence, ArrayByteSequence)"})
  void testCompareBytes_whenA_thenReturnMinusThirtySeven() {
    // Arrange
    ByteBuffer buffer = ByteBuffer.wrap(new byte[] {'A', 3, 'A', 3, 'A', 3, 'A', 3});
    ArrayByteSequence bs1 = new ArrayByteSequence(buffer);

    // Act
    int actualCompareBytesResult =
        ArrayByteSequence.compareBytes(bs1, new ArrayByteSequence("foo"));

    // Assert
    assertEquals(-37, actualCompareBytesResult);
  }

  /**
   * Test {@link ArrayByteSequence#compareBytes(ArrayByteSequence, ArrayByteSequence)}.
   *
   * <ul>
   *   <li>When {@link ArrayByteSequence#ArrayByteSequence(String)} with s is {@code foo}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link ArrayByteSequence#compareBytes(ArrayByteSequence,
   * ArrayByteSequence)}
   */
  @Test
  @DisplayName(
      "Test compareBytes(ArrayByteSequence, ArrayByteSequence); when ArrayByteSequence(String) with s is 'foo'; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int ArrayByteSequence.compareBytes(ArrayByteSequence, ArrayByteSequence)"})
  void testCompareBytes_whenArrayByteSequenceWithSIsFoo_thenReturnZero() {
    // Arrange
    ArrayByteSequence bs1 = new ArrayByteSequence("foo");

    // Act
    int actualCompareBytesResult =
        ArrayByteSequence.compareBytes(bs1, new ArrayByteSequence("foo"));

    // Assert
    assertEquals(0, actualCompareBytesResult);
  }

  /**
   * Test {@link ArrayByteSequence#compareTo(ArrayByteSequence)} with {@code ArrayByteSequence}.
   *
   * <ul>
   *   <li>Given {@code A}.
   *   <li>Then return minus three.
   * </ul>
   *
   * <p>Method under test: {@link ArrayByteSequence#compareTo(ArrayByteSequence)}
   */
  @Test
  @DisplayName(
      "Test compareTo(ArrayByteSequence) with 'ArrayByteSequence'; given 'A'; then return minus three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int ArrayByteSequence.compareTo(ArrayByteSequence)"})
  void testCompareToWithArrayByteSequence_givenA_thenReturnMinusThree()
      throws UnsupportedEncodingException {
    // Arrange
    ByteBuffer buffer = ByteBuffer.wrap(new byte[] {'A', 1, 'A', 1, 'A', 1, 'A', 1});
    buffer.put(ByteBuffer.wrap("AXAXAXAX".getBytes("UTF-8")));
    ArrayByteSequence arrayByteSequence = new ArrayByteSequence(buffer);

    // Act
    int actualCompareToResult = arrayByteSequence.compareTo(new ArrayByteSequence("foo"));

    // Assert
    assertEquals(-3, actualCompareToResult);
  }

  /**
   * Test {@link ArrayByteSequence#compareTo(ArrayByteSequence)} with {@code ArrayByteSequence}.
   *
   * <ul>
   *   <li>Given {@link ArrayByteSequence#ArrayByteSequence(String)} with s is empty string.
   * </ul>
   *
   * <p>Method under test: {@link ArrayByteSequence#compareTo(ArrayByteSequence)}
   */
  @Test
  @DisplayName(
      "Test compareTo(ArrayByteSequence) with 'ArrayByteSequence'; given ArrayByteSequence(String) with s is empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int ArrayByteSequence.compareTo(ArrayByteSequence)"})
  void testCompareToWithArrayByteSequence_givenArrayByteSequenceWithSIsEmptyString() {
    // Arrange
    ArrayByteSequence arrayByteSequence = new ArrayByteSequence("");

    // Act
    int actualCompareToResult = arrayByteSequence.compareTo(new ArrayByteSequence("foo"));

    // Assert
    assertEquals(-3, actualCompareToResult);
  }

  /**
   * Test {@link ArrayByteSequence#compareTo(ArrayByteSequence)} with {@code ArrayByteSequence}.
   *
   * <ul>
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link ArrayByteSequence#compareTo(ArrayByteSequence)}
   */
  @Test
  @DisplayName("Test compareTo(ArrayByteSequence) with 'ArrayByteSequence'; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int ArrayByteSequence.compareTo(ArrayByteSequence)"})
  void testCompareToWithArrayByteSequence_thenReturnZero() {
    // Arrange
    ArrayByteSequence arrayByteSequence = new ArrayByteSequence("foo");

    // Act
    int actualCompareToResult = arrayByteSequence.compareTo(new ArrayByteSequence("foo"));

    // Assert
    assertEquals(0, actualCompareToResult);
  }

  /**
   * Test {@link ArrayByteSequence#equals(Object)}, and {@link ArrayByteSequence#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ArrayByteSequence#equals(Object)}
   *   <li>{@link ArrayByteSequence#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ArrayByteSequence.equals(Object)",
    "int ArrayByteSequence.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ByteBuffer buffer = ByteBuffer.wrap(new byte[] {'A', 1, 'A', 1, 'A', 1, 'A', 1});
    ArrayByteSequence arrayByteSequence = new ArrayByteSequence(buffer);
    ByteBuffer buffer2 = ByteBuffer.wrap(new byte[] {'A', 1, 'A', 1, 'A', 1, 'A', 1});
    ArrayByteSequence arrayByteSequence2 = new ArrayByteSequence(buffer2);

    // Act and Assert
    assertEquals(arrayByteSequence, arrayByteSequence2);
    assertEquals(arrayByteSequence.hashCode(), arrayByteSequence2.hashCode());
  }

  /**
   * Test {@link ArrayByteSequence#equals(Object)}, and {@link ArrayByteSequence#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ArrayByteSequence#equals(Object)}
   *   <li>{@link ArrayByteSequence#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ArrayByteSequence.equals(Object)",
    "int ArrayByteSequence.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ArrayByteSequence arrayByteSequence = new ArrayByteSequence("foo");

    // Act and Assert
    assertEquals(arrayByteSequence, arrayByteSequence);
    int expectedHashCodeResult = arrayByteSequence.hashCode();
    assertEquals(expectedHashCodeResult, arrayByteSequence.hashCode());
  }

  /**
   * Test {@link ArrayByteSequence#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ArrayByteSequence#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ArrayByteSequence.equals(Object)",
    "int ArrayByteSequence.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ByteBuffer buffer = ByteBuffer.wrap(new byte[] {'A', 1, 'A', 1, 'A', 1, 'A', 1});
    ArrayByteSequence arrayByteSequence = new ArrayByteSequence(buffer);

    // Act and Assert
    assertNotEquals(arrayByteSequence, new ArrayByteSequence("foo"));
  }

  /**
   * Test {@link ArrayByteSequence#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ArrayByteSequence#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ArrayByteSequence.equals(Object)",
    "int ArrayByteSequence.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ByteBuffer buffer = ByteBuffer.wrap(new byte[] {1, 1, 'A', 1, 'A', 1, 'A', 1});
    ArrayByteSequence arrayByteSequence = new ArrayByteSequence(buffer);
    ByteBuffer buffer2 = ByteBuffer.wrap(new byte[] {'A', 1, 'A', 1, 'A', 1, 'A', 1});

    // Act and Assert
    assertNotEquals(arrayByteSequence, new ArrayByteSequence(buffer2));
  }

  /**
   * Test {@link ArrayByteSequence#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ArrayByteSequence#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ArrayByteSequence.equals(Object)",
    "int ArrayByteSequence.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new ArrayByteSequence("foo"), null);
  }

  /**
   * Test {@link ArrayByteSequence#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ArrayByteSequence#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ArrayByteSequence.equals(Object)",
    "int ArrayByteSequence.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new ArrayByteSequence("foo"), "Different type to ArrayByteSequence");
  }
}
