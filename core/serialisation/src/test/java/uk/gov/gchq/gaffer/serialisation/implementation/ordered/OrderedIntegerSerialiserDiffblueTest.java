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

package uk.gov.gchq.gaffer.serialisation.implementation.ordered;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.UnsupportedEncodingException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.exception.SerialisationException;

class OrderedIntegerSerialiserDiffblueTest {
  /**
   * Test {@link OrderedIntegerSerialiser#serialise(Integer)} with {@code Integer}.
   *
   * <ul>
   *   <li>When {@link Integer#MIN_VALUE}.
   *   <li>Then return array of {@code byte} with zero.
   * </ul>
   *
   * <p>Method under test: {@link OrderedIntegerSerialiser#serialise(Integer)}
   */
  @Test
  @DisplayName(
      "Test serialise(Integer) with 'Integer'; when MIN_VALUE; then return array of byte with zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] OrderedIntegerSerialiser.serialise(Integer)"})
  void testSerialiseWithInteger_whenMin_value_thenReturnArrayOfByteWithZero() {
    // Arrange, Act and Assert
    assertArrayEquals(new byte[] {0}, new OrderedIntegerSerialiser().serialise(Integer.MIN_VALUE));
  }

  /**
   * Test {@link OrderedIntegerSerialiser#serialise(Integer)} with {@code Integer}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then return array of {@code byte} with four and {@link Byte#MIN_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link OrderedIntegerSerialiser#serialise(Integer)}
   */
  @Test
  @DisplayName(
      "Test serialise(Integer) with 'Integer'; when one; then return array of byte with four and MIN_VALUE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] OrderedIntegerSerialiser.serialise(Integer)"})
  void testSerialiseWithInteger_whenOne_thenReturnArrayOfByteWithFourAndMin_value() {
    // Arrange, Act and Assert
    assertArrayEquals(
        new byte[] {4, Byte.MIN_VALUE, 0, 0, 1}, new OrderedIntegerSerialiser().serialise(1));
  }

  /**
   * Test {@link OrderedIntegerSerialiser#deserialise(byte[])} with {@code bytes}.
   *
   * <ul>
   *   <li>When array of {@code byte} with backspace.
   * </ul>
   *
   * <p>Method under test: {@link OrderedIntegerSerialiser#deserialise(byte[])}
   */
  @Test
  @DisplayName("Test deserialise(byte[]) with 'bytes'; when array of byte with backspace")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Integer OrderedIntegerSerialiser.deserialise(byte[])"})
  void testDeserialiseWithBytes_whenArrayOfByteWithBackspace() throws SerialisationException {
    // Arrange, Act and Assert
    assertEquals(
        Integer.MAX_VALUE,
        new OrderedIntegerSerialiser().deserialise(new byte[] {'\b'}).intValue());
  }

  /**
   * Test {@link OrderedIntegerSerialiser#deserialise(byte[])} with {@code bytes}.
   *
   * <ul>
   *   <li>When array of {@code byte} with minus one.
   * </ul>
   *
   * <p>Method under test: {@link OrderedIntegerSerialiser#deserialise(byte[])}
   */
  @Test
  @DisplayName("Test deserialise(byte[]) with 'bytes'; when array of byte with minus one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Integer OrderedIntegerSerialiser.deserialise(byte[])"})
  void testDeserialiseWithBytes_whenArrayOfByteWithMinusOne() throws SerialisationException {
    // Arrange, Act and Assert
    assertThrows(
        SerialisationException.class,
        () -> new OrderedIntegerSerialiser().deserialise(new byte[] {-1}));
  }

  /**
   * Test {@link OrderedIntegerSerialiser#deserialise(byte[])} with {@code bytes}.
   *
   * <ul>
   *   <li>When array of {@code byte} with zero.
   *   <li>Then return intValue is {@link Integer#MIN_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link OrderedIntegerSerialiser#deserialise(byte[])}
   */
  @Test
  @DisplayName(
      "Test deserialise(byte[]) with 'bytes'; when array of byte with zero; then return intValue is MIN_VALUE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Integer OrderedIntegerSerialiser.deserialise(byte[])"})
  void testDeserialiseWithBytes_whenArrayOfByteWithZero_thenReturnIntValueIsMin_value()
      throws SerialisationException {
    // Arrange, Act and Assert
    assertEquals(
        Integer.MIN_VALUE, new OrderedIntegerSerialiser().deserialise(new byte[] {0}).intValue());
  }

  /**
   * Test {@link OrderedIntegerSerialiser#deserialise(byte[])} with {@code bytes}.
   *
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.
   *   <li>Then throw {@link SerialisationException}.
   * </ul>
   *
   * <p>Method under test: {@link OrderedIntegerSerialiser#deserialise(byte[])}
   */
  @Test
  @DisplayName(
      "Test deserialise(byte[]) with 'bytes'; when 'AXAXAXAX' Bytes is 'UTF-8'; then throw SerialisationException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Integer OrderedIntegerSerialiser.deserialise(byte[])"})
  void testDeserialiseWithBytes_whenAxaxaxaxBytesIsUtf8_thenThrowSerialisationException()
      throws UnsupportedEncodingException, SerialisationException {
    // Arrange, Act and Assert
    assertThrows(
        SerialisationException.class,
        () -> new OrderedIntegerSerialiser().deserialise("AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link OrderedIntegerSerialiser#deserialise(byte[])} with {@code bytes}.
   *
   * <ul>
   *   <li>When {@code XAXAXAX} Bytes is {@code UTF-8}.
   *   <li>Then return intValue is {@link Integer#MAX_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link OrderedIntegerSerialiser#deserialise(byte[])}
   */
  @Test
  @DisplayName(
      "Test deserialise(byte[]) with 'bytes'; when 'XAXAXAX' Bytes is 'UTF-8'; then return intValue is MAX_VALUE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Integer OrderedIntegerSerialiser.deserialise(byte[])"})
  void testDeserialiseWithBytes_whenXaxaxaxBytesIsUtf8_thenReturnIntValueIsMax_value()
      throws UnsupportedEncodingException, SerialisationException {
    // Arrange, Act and Assert
    assertEquals(
        Integer.MAX_VALUE,
        new OrderedIntegerSerialiser().deserialise("\bXAXAXAX".getBytes("UTF-8")).intValue());
  }

  /**
   * Test {@link OrderedIntegerSerialiser#deserialiseEmpty()}.
   *
   * <p>Method under test: {@link OrderedIntegerSerialiser#deserialiseEmpty()}
   */
  @Test
  @DisplayName("Test deserialiseEmpty()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Integer OrderedIntegerSerialiser.deserialiseEmpty()"})
  void testDeserialiseEmpty() {
    // Arrange, Act and Assert
    assertNull(new OrderedIntegerSerialiser().deserialiseEmpty());
  }

  /**
   * Test {@link OrderedIntegerSerialiser#preservesObjectOrdering()}.
   *
   * <p>Method under test: {@link OrderedIntegerSerialiser#preservesObjectOrdering()}
   */
  @Test
  @DisplayName("Test preservesObjectOrdering()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OrderedIntegerSerialiser.preservesObjectOrdering()"})
  void testPreservesObjectOrdering() {
    // Arrange, Act and Assert
    assertTrue(new OrderedIntegerSerialiser().preservesObjectOrdering());
  }

  /**
   * Test {@link OrderedIntegerSerialiser#canHandle(Class)}.
   *
   * <ul>
   *   <li>When {@code Integer}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link OrderedIntegerSerialiser#canHandle(Class)}
   */
  @Test
  @DisplayName("Test canHandle(Class); when 'java.lang.Integer'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OrderedIntegerSerialiser.canHandle(Class)"})
  void testCanHandle_whenJavaLangInteger_thenReturnTrue() {
    // Arrange
    OrderedIntegerSerialiser orderedIntegerSerialiser = new OrderedIntegerSerialiser();
    Class<Integer> clazz = Integer.class;

    // Act and Assert
    assertTrue(orderedIntegerSerialiser.canHandle(clazz));
  }

  /**
   * Test {@link OrderedIntegerSerialiser#canHandle(Class)}.
   *
   * <ul>
   *   <li>When {@code Object}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link OrderedIntegerSerialiser#canHandle(Class)}
   */
  @Test
  @DisplayName("Test canHandle(Class); when 'java.lang.Object'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OrderedIntegerSerialiser.canHandle(Class)"})
  void testCanHandle_whenJavaLangObject_thenReturnFalse() {
    // Arrange
    OrderedIntegerSerialiser orderedIntegerSerialiser = new OrderedIntegerSerialiser();
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertFalse(orderedIntegerSerialiser.canHandle(clazz));
  }

  /**
   * Test {@link OrderedIntegerSerialiser#equals(Object)}, and {@link
   * OrderedIntegerSerialiser#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link OrderedIntegerSerialiser#equals(Object)}
   *   <li>{@link OrderedIntegerSerialiser#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OrderedIntegerSerialiser.equals(Object)",
    "int OrderedIntegerSerialiser.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    OrderedIntegerSerialiser orderedIntegerSerialiser = new OrderedIntegerSerialiser();
    OrderedIntegerSerialiser orderedIntegerSerialiser2 = new OrderedIntegerSerialiser();

    // Act and Assert
    assertEquals(orderedIntegerSerialiser, orderedIntegerSerialiser2);
    assertEquals(orderedIntegerSerialiser.hashCode(), orderedIntegerSerialiser2.hashCode());
  }

  /**
   * Test {@link OrderedIntegerSerialiser#equals(Object)}, and {@link
   * OrderedIntegerSerialiser#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link OrderedIntegerSerialiser#equals(Object)}
   *   <li>{@link OrderedIntegerSerialiser#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OrderedIntegerSerialiser.equals(Object)",
    "int OrderedIntegerSerialiser.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    OrderedIntegerSerialiser orderedIntegerSerialiser = new OrderedIntegerSerialiser();

    // Act and Assert
    assertEquals(orderedIntegerSerialiser, orderedIntegerSerialiser);
    int expectedHashCodeResult = orderedIntegerSerialiser.hashCode();
    assertEquals(expectedHashCodeResult, orderedIntegerSerialiser.hashCode());
  }

  /**
   * Test {@link OrderedIntegerSerialiser#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OrderedIntegerSerialiser#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OrderedIntegerSerialiser.equals(Object)",
    "int OrderedIntegerSerialiser.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new OrderedIntegerSerialiser(), 1);
  }

  /**
   * Test {@link OrderedIntegerSerialiser#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OrderedIntegerSerialiser#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OrderedIntegerSerialiser.equals(Object)",
    "int OrderedIntegerSerialiser.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new OrderedIntegerSerialiser(), null);
  }

  /**
   * Test {@link OrderedIntegerSerialiser#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OrderedIntegerSerialiser#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OrderedIntegerSerialiser.equals(Object)",
    "int OrderedIntegerSerialiser.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new OrderedIntegerSerialiser(), "Different type to OrderedIntegerSerialiser");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link OrderedIntegerSerialiser}
   *   <li>{@link OrderedIntegerSerialiser#isConsistent()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void OrderedIntegerSerialiser.<init>()",
    "boolean OrderedIntegerSerialiser.isConsistent()"
  })
  void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertTrue(new OrderedIntegerSerialiser().isConsistent());
  }
}
