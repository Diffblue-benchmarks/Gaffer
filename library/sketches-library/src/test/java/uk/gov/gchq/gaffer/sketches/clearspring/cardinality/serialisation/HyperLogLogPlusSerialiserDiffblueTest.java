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

package uk.gov.gchq.gaffer.sketches.clearspring.cardinality.serialisation;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.clearspring.analytics.stream.cardinality.HyperLogLogPlus;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.exception.SerialisationException;

class HyperLogLogPlusSerialiserDiffblueTest {
  /**
   * Test {@link HyperLogLogPlusSerialiser#canHandle(Class)}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link HyperLogLogPlusSerialiser#canHandle(Class)}
   */
  @Test
  @DisplayName("Test canHandle(Class); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean HyperLogLogPlusSerialiser.canHandle(Class)"})
  void testCanHandle_thenReturnTrue() {
    // Arrange
    HyperLogLogPlusSerialiser hyperLogLogPlusSerialiser = new HyperLogLogPlusSerialiser();
    Class<HyperLogLogPlus> clazz = HyperLogLogPlus.class;

    // Act and Assert
    assertTrue(hyperLogLogPlusSerialiser.canHandle(clazz));
  }

  /**
   * Test {@link HyperLogLogPlusSerialiser#canHandle(Class)}.
   *
   * <ul>
   *   <li>When {@code Object}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link HyperLogLogPlusSerialiser#canHandle(Class)}
   */
  @Test
  @DisplayName("Test canHandle(Class); when 'java.lang.Object'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean HyperLogLogPlusSerialiser.canHandle(Class)"})
  void testCanHandle_whenJavaLangObject_thenReturnFalse() {
    // Arrange
    HyperLogLogPlusSerialiser hyperLogLogPlusSerialiser = new HyperLogLogPlusSerialiser();
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertFalse(hyperLogLogPlusSerialiser.canHandle(clazz));
  }

  /**
   * Test {@link HyperLogLogPlusSerialiser#serialise(HyperLogLogPlus)} with {@code HyperLogLogPlus}.
   *
   * <ul>
   *   <li>Given {@link IOException#IOException()}.
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link HyperLogLogPlusSerialiser#serialise(HyperLogLogPlus)}
   */
  @Test
  @DisplayName(
      "Test serialise(HyperLogLogPlus) with 'HyperLogLogPlus'; given IOException(); then throw RuntimeException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] HyperLogLogPlusSerialiser.serialise(HyperLogLogPlus)"})
  void testSerialiseWithHyperLogLogPlus_givenIOException_thenThrowRuntimeException()
      throws IOException {
    // Arrange
    HyperLogLogPlusSerialiser hyperLogLogPlusSerialiser = new HyperLogLogPlusSerialiser();

    HyperLogLogPlus value = mock(HyperLogLogPlus.class);
    when(value.getBytes()).thenThrow(new IOException());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> hyperLogLogPlusSerialiser.serialise(value));
    verify(value).getBytes();
  }

  /**
   * Test {@link HyperLogLogPlusSerialiser#serialise(HyperLogLogPlus)} with {@code HyperLogLogPlus}.
   *
   * <ul>
   *   <li>Then return {@code AXAXAXAX} Bytes is {@code UTF-8}.
   * </ul>
   *
   * <p>Method under test: {@link HyperLogLogPlusSerialiser#serialise(HyperLogLogPlus)}
   */
  @Test
  @DisplayName(
      "Test serialise(HyperLogLogPlus) with 'HyperLogLogPlus'; then return 'AXAXAXAX' Bytes is 'UTF-8'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] HyperLogLogPlusSerialiser.serialise(HyperLogLogPlus)"})
  void testSerialiseWithHyperLogLogPlus_thenReturnAxaxaxaxBytesIsUtf8() throws IOException {
    // Arrange
    HyperLogLogPlusSerialiser hyperLogLogPlusSerialiser = new HyperLogLogPlusSerialiser();

    HyperLogLogPlus value = mock(HyperLogLogPlus.class);
    when(value.getBytes()).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    byte[] actualSerialiseResult = hyperLogLogPlusSerialiser.serialise(value);

    // Assert
    verify(value).getBytes();
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualSerialiseResult);
  }

  /**
   * Test {@link HyperLogLogPlusSerialiser#deserialise(byte[])} with {@code bytes}.
   *
   * <ul>
   *   <li>Then return sizeof is {@code 1431655768}.
   * </ul>
   *
   * <p>Method under test: {@link HyperLogLogPlusSerialiser#deserialise(byte[])}
   */
  @Test
  @DisplayName("Test deserialise(byte[]) with 'bytes'; then return sizeof is '1431655768'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"HyperLogLogPlus HyperLogLogPlusSerialiser.deserialise(byte[])"})
  void testDeserialiseWithBytes_thenReturnSizeofIs1431655768() throws IOException {
    // Arrange and Act
    HyperLogLogPlus actualDeserialiseResult =
        new HyperLogLogPlusSerialiser().deserialise(new byte[] {-1, 'X', 'A', 'X', 'A', 0, 'A', 0});

    // Assert
    assertEquals(1431655768, actualDeserialiseResult.sizeof());
    assertArrayEquals(
        new byte[] {-1, -1, -1, -2, 'A', 0, 1, 0}, actualDeserialiseResult.getBytes());
  }

  /**
   * Test {@link HyperLogLogPlusSerialiser#deserialise(byte[])} with {@code bytes}.
   *
   * <ul>
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link HyperLogLogPlusSerialiser#deserialise(byte[])}
   */
  @Test
  @DisplayName("Test deserialise(byte[]) with 'bytes'; then throw RuntimeException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"HyperLogLogPlus HyperLogLogPlusSerialiser.deserialise(byte[])"})
  void testDeserialiseWithBytes_thenThrowRuntimeException() throws SerialisationException {
    // Arrange, Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            new HyperLogLogPlusSerialiser()
                .deserialise(new byte[] {-1, 'X', 'A', 'X', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test {@link HyperLogLogPlusSerialiser#deserialise(byte[])} with {@code bytes}.
   *
   * <ul>
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link HyperLogLogPlusSerialiser#deserialise(byte[])}
   */
  @Test
  @DisplayName("Test deserialise(byte[]) with 'bytes'; then throw RuntimeException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"HyperLogLogPlus HyperLogLogPlusSerialiser.deserialise(byte[])"})
  void testDeserialiseWithBytes_thenThrowRuntimeException2() throws SerialisationException {
    // Arrange, Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            new HyperLogLogPlusSerialiser()
                .deserialise(new byte[] {-1, 'X', 'A', 'X', -1, 'X', 'A', 'X'}));
  }

  /**
   * Test {@link HyperLogLogPlusSerialiser#deserialise(byte[])} with {@code bytes}.
   *
   * <ul>
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link HyperLogLogPlusSerialiser#deserialise(byte[])}
   */
  @Test
  @DisplayName("Test deserialise(byte[]) with 'bytes'; then throw RuntimeException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"HyperLogLogPlus HyperLogLogPlusSerialiser.deserialise(byte[])"})
  void testDeserialiseWithBytes_thenThrowRuntimeException3() throws SerialisationException {
    // Arrange, Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            new HyperLogLogPlusSerialiser()
                .deserialise(new byte[] {-1, 'X', 'A', 'X', 'A', 'X', 0, 'X'}));
  }

  /**
   * Test {@link HyperLogLogPlusSerialiser#deserialise(byte[])} with {@code bytes}.
   *
   * <ul>
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link HyperLogLogPlusSerialiser#deserialise(byte[])}
   */
  @Test
  @DisplayName("Test deserialise(byte[]) with 'bytes'; then throw RuntimeException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"HyperLogLogPlus HyperLogLogPlusSerialiser.deserialise(byte[])"})
  void testDeserialiseWithBytes_thenThrowRuntimeException4() throws SerialisationException {
    // Arrange, Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            new HyperLogLogPlusSerialiser()
                .deserialise(
                    new byte[] {
                      -1, 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'
                    }));
  }

  /**
   * Test {@link HyperLogLogPlusSerialiser#deserialise(byte[])} with {@code bytes}.
   *
   * <ul>
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link HyperLogLogPlusSerialiser#deserialise(byte[])}
   */
  @Test
  @DisplayName("Test deserialise(byte[]) with 'bytes'; then throw RuntimeException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"HyperLogLogPlus HyperLogLogPlusSerialiser.deserialise(byte[])"})
  void testDeserialiseWithBytes_thenThrowRuntimeException5() throws SerialisationException {
    // Arrange, Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            new HyperLogLogPlusSerialiser()
                .deserialise(new byte[] {-1, 'X', 'A', 'X', -1, 'X', 'A', 0}));
  }

  /**
   * Test {@link HyperLogLogPlusSerialiser#deserialise(byte[])} with {@code bytes}.
   *
   * <ul>
   *   <li>When array of {@code byte} with minus one and {@code X}.
   *   <li>Then return sizeof is zero.
   * </ul>
   *
   * <p>Method under test: {@link HyperLogLogPlusSerialiser#deserialise(byte[])}
   */
  @Test
  @DisplayName(
      "Test deserialise(byte[]) with 'bytes'; when array of byte with minus one and 'X'; then return sizeof is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"HyperLogLogPlus HyperLogLogPlusSerialiser.deserialise(byte[])"})
  void testDeserialiseWithBytes_whenArrayOfByteWithMinusOneAndX_thenReturnSizeofIsZero()
      throws IOException {
    // Arrange and Act
    HyperLogLogPlus actualDeserialiseResult =
        new HyperLogLogPlusSerialiser().deserialise(new byte[] {-1, 'X', 'A', 'X', 'A', 0, 0, 0});

    // Assert
    assertEquals(0, actualDeserialiseResult.sizeof());
    assertArrayEquals(
        new byte[] {-1, -1, -1, -2, 'A', 0, 0, 0}, actualDeserialiseResult.getBytes());
  }

  /**
   * Test {@link HyperLogLogPlusSerialiser#deserialise(byte[])} with {@code bytes}.
   *
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link HyperLogLogPlusSerialiser#deserialise(byte[])}
   */
  @Test
  @DisplayName(
      "Test deserialise(byte[]) with 'bytes'; when 'AXAXAXAX' Bytes is 'UTF-8'; then throw RuntimeException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"HyperLogLogPlus HyperLogLogPlusSerialiser.deserialise(byte[])"})
  void testDeserialiseWithBytes_whenAxaxaxaxBytesIsUtf8_thenThrowRuntimeException()
      throws UnsupportedEncodingException, SerialisationException {
    // Arrange, Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> new HyperLogLogPlusSerialiser().deserialise("AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link HyperLogLogPlusSerialiser#deserialise(byte[])} with {@code bytes}.
   *
   * <ul>
   *   <li>When {@code AXAXAXAXAXAXAXAX} Bytes is {@code UTF-8}.
   * </ul>
   *
   * <p>Method under test: {@link HyperLogLogPlusSerialiser#deserialise(byte[])}
   */
  @Test
  @DisplayName("Test deserialise(byte[]) with 'bytes'; when 'AXAXAXAXAXAXAXAX' Bytes is 'UTF-8'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"HyperLogLogPlus HyperLogLogPlusSerialiser.deserialise(byte[])"})
  void testDeserialiseWithBytes_whenAxaxaxaxaxaxaxaxBytesIsUtf8()
      throws UnsupportedEncodingException, SerialisationException {
    // Arrange, Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> new HyperLogLogPlusSerialiser().deserialise("AXAXAXAXAXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link HyperLogLogPlusSerialiser#deserialise(byte[])} with {@code bytes}.
   *
   * <ul>
   *   <li>When empty array of {@code byte}.
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link HyperLogLogPlusSerialiser#deserialise(byte[])}
   */
  @Test
  @DisplayName(
      "Test deserialise(byte[]) with 'bytes'; when empty array of byte; then throw RuntimeException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"HyperLogLogPlus HyperLogLogPlusSerialiser.deserialise(byte[])"})
  void testDeserialiseWithBytes_whenEmptyArrayOfByte_thenThrowRuntimeException()
      throws SerialisationException {
    // Arrange, Act and Assert
    assertThrows(
        RuntimeException.class, () -> new HyperLogLogPlusSerialiser().deserialise(new byte[] {}));
  }

  /**
   * Test {@link HyperLogLogPlusSerialiser#deserialiseEmpty()}.
   *
   * <p>Method under test: {@link HyperLogLogPlusSerialiser#deserialiseEmpty()}
   */
  @Test
  @DisplayName("Test deserialiseEmpty()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"HyperLogLogPlus HyperLogLogPlusSerialiser.deserialiseEmpty()"})
  void testDeserialiseEmpty() throws SerialisationException {
    // Arrange, Act and Assert
    assertNull(new HyperLogLogPlusSerialiser().deserialiseEmpty());
  }

  /**
   * Test {@link HyperLogLogPlusSerialiser#preservesObjectOrdering()}.
   *
   * <p>Method under test: {@link HyperLogLogPlusSerialiser#preservesObjectOrdering()}
   */
  @Test
  @DisplayName("Test preservesObjectOrdering()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean HyperLogLogPlusSerialiser.preservesObjectOrdering()"})
  void testPreservesObjectOrdering() {
    // Arrange, Act and Assert
    assertFalse(new HyperLogLogPlusSerialiser().preservesObjectOrdering());
  }

  /**
   * Test {@link HyperLogLogPlusSerialiser#equals(Object)}, and {@link
   * HyperLogLogPlusSerialiser#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link HyperLogLogPlusSerialiser#equals(Object)}
   *   <li>{@link HyperLogLogPlusSerialiser#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean HyperLogLogPlusSerialiser.equals(Object)",
    "int HyperLogLogPlusSerialiser.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    HyperLogLogPlusSerialiser hyperLogLogPlusSerialiser = new HyperLogLogPlusSerialiser();
    HyperLogLogPlusSerialiser hyperLogLogPlusSerialiser2 = new HyperLogLogPlusSerialiser();

    // Act and Assert
    assertEquals(hyperLogLogPlusSerialiser, hyperLogLogPlusSerialiser2);
    assertEquals(hyperLogLogPlusSerialiser.hashCode(), hyperLogLogPlusSerialiser2.hashCode());
  }

  /**
   * Test {@link HyperLogLogPlusSerialiser#equals(Object)}, and {@link
   * HyperLogLogPlusSerialiser#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link HyperLogLogPlusSerialiser#equals(Object)}
   *   <li>{@link HyperLogLogPlusSerialiser#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean HyperLogLogPlusSerialiser.equals(Object)",
    "int HyperLogLogPlusSerialiser.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    HyperLogLogPlusSerialiser hyperLogLogPlusSerialiser = new HyperLogLogPlusSerialiser();

    // Act and Assert
    assertEquals(hyperLogLogPlusSerialiser, hyperLogLogPlusSerialiser);
    int expectedHashCodeResult = hyperLogLogPlusSerialiser.hashCode();
    assertEquals(expectedHashCodeResult, hyperLogLogPlusSerialiser.hashCode());
  }

  /**
   * Test {@link HyperLogLogPlusSerialiser#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link HyperLogLogPlusSerialiser#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean HyperLogLogPlusSerialiser.equals(Object)",
    "int HyperLogLogPlusSerialiser.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new HyperLogLogPlusSerialiser(), 3);
  }

  /**
   * Test {@link HyperLogLogPlusSerialiser#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link HyperLogLogPlusSerialiser#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean HyperLogLogPlusSerialiser.equals(Object)",
    "int HyperLogLogPlusSerialiser.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new HyperLogLogPlusSerialiser(), null);
  }

  /**
   * Test {@link HyperLogLogPlusSerialiser#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link HyperLogLogPlusSerialiser#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean HyperLogLogPlusSerialiser.equals(Object)",
    "int HyperLogLogPlusSerialiser.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new HyperLogLogPlusSerialiser(), "Different type to HyperLogLogPlusSerialiser");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link HyperLogLogPlusSerialiser}
   *   <li>{@link HyperLogLogPlusSerialiser#isConsistent()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void HyperLogLogPlusSerialiser.<init>()",
    "boolean HyperLogLogPlusSerialiser.isConsistent()"
  })
  void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertFalse(new HyperLogLogPlusSerialiser().isConsistent());
  }
}
