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
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.UnsupportedEncodingException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.exception.SerialisationException;

class OrderedFloatSerialiserDiffblueTest {
  /**
   * Test {@link OrderedFloatSerialiser#serialise(Float)} with {@code Float}.
   *
   * <ul>
   *   <li>When {@code -0.5}.
   *   <li>Then return array of {@code byte} with four and minus sixty-four.
   * </ul>
   *
   * <p>Method under test: {@link OrderedFloatSerialiser#serialise(Float)}
   */
  @Test
  @DisplayName(
      "Test serialise(Float) with 'Float'; when '-0.5'; then return array of byte with four and minus sixty-four")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] OrderedFloatSerialiser.serialise(Float)"})
  void testSerialiseWithFloat_when05_thenReturnArrayOfByteWithFourAndMinusSixtyFour() {
    // Arrange, Act and Assert
    assertArrayEquals(
        new byte[] {4, -64, -1, -1, -1}, new OrderedFloatSerialiser().serialise(-0.5f));
  }

  /**
   * Test {@link OrderedFloatSerialiser#serialise(Float)} with {@code Float}.
   *
   * <ul>
   *   <li>When ten.
   *   <li>Then return array of {@code byte} with four and {@code A}.
   * </ul>
   *
   * <p>Method under test: {@link OrderedFloatSerialiser#serialise(Float)}
   */
  @Test
  @DisplayName(
      "Test serialise(Float) with 'Float'; when ten; then return array of byte with four and 'A'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] OrderedFloatSerialiser.serialise(Float)"})
  void testSerialiseWithFloat_whenTen_thenReturnArrayOfByteWithFourAndA() {
    // Arrange, Act and Assert
    assertArrayEquals(
        new byte[] {4, 'A', ' ', 0, 0}, new OrderedFloatSerialiser().serialise(10.0f));
  }

  /**
   * Test {@link OrderedFloatSerialiser#deserialise(byte[])} with {@code bytes}.
   *
   * <ul>
   *   <li>When array of {@code byte} with backspace.
   *   <li>Then return floatValue is {@code -0.0}.
   * </ul>
   *
   * <p>Method under test: {@link OrderedFloatSerialiser#deserialise(byte[])}
   */
  @Test
  @DisplayName(
      "Test deserialise(byte[]) with 'bytes'; when array of byte with backspace; then return floatValue is '-0.0'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Float OrderedFloatSerialiser.deserialise(byte[])"})
  void testDeserialiseWithBytes_whenArrayOfByteWithBackspace_thenReturnFloatValueIs00()
      throws SerialisationException {
    // Arrange, Act and Assert
    assertEquals(-0.0f, new OrderedFloatSerialiser().deserialise(new byte[] {'\b'}).floatValue());
  }

  /**
   * Test {@link OrderedFloatSerialiser#deserialise(byte[])} with {@code bytes}.
   *
   * <ul>
   *   <li>When array of {@code byte} with zero.
   *   <li>Then return floatValue is zero.
   * </ul>
   *
   * <p>Method under test: {@link OrderedFloatSerialiser#deserialise(byte[])}
   */
  @Test
  @DisplayName(
      "Test deserialise(byte[]) with 'bytes'; when array of byte with zero; then return floatValue is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Float OrderedFloatSerialiser.deserialise(byte[])"})
  void testDeserialiseWithBytes_whenArrayOfByteWithZero_thenReturnFloatValueIsZero()
      throws SerialisationException {
    // Arrange, Act and Assert
    assertEquals(0.0f, new OrderedFloatSerialiser().deserialise(new byte[] {0}).floatValue());
  }

  /**
   * Test {@link OrderedFloatSerialiser#deserialise(byte[])} with {@code bytes}.
   *
   * <ul>
   *   <li>When {@code XAXAXAX} Bytes is {@code UTF-8}.
   *   <li>Then return floatValue is {@code -0.0}.
   * </ul>
   *
   * <p>Method under test: {@link OrderedFloatSerialiser#deserialise(byte[])}
   */
  @Test
  @DisplayName(
      "Test deserialise(byte[]) with 'bytes'; when 'XAXAXAX' Bytes is 'UTF-8'; then return floatValue is '-0.0'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Float OrderedFloatSerialiser.deserialise(byte[])"})
  void testDeserialiseWithBytes_whenXaxaxaxBytesIsUtf8_thenReturnFloatValueIs00()
      throws UnsupportedEncodingException, SerialisationException {
    // Arrange, Act and Assert
    assertEquals(
        -0.0f,
        new OrderedFloatSerialiser().deserialise("\bXAXAXAX".getBytes("UTF-8")).floatValue());
  }

  /**
   * Test {@link OrderedFloatSerialiser#deserialiseEmpty()}.
   *
   * <p>Method under test: {@link OrderedFloatSerialiser#deserialiseEmpty()}
   */
  @Test
  @DisplayName("Test deserialiseEmpty()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Float OrderedFloatSerialiser.deserialiseEmpty()"})
  void testDeserialiseEmpty() {
    // Arrange, Act and Assert
    assertNull(new OrderedFloatSerialiser().deserialiseEmpty());
  }

  /**
   * Test {@link OrderedFloatSerialiser#preservesObjectOrdering()}.
   *
   * <p>Method under test: {@link OrderedFloatSerialiser#preservesObjectOrdering()}
   */
  @Test
  @DisplayName("Test preservesObjectOrdering()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OrderedFloatSerialiser.preservesObjectOrdering()"})
  void testPreservesObjectOrdering() {
    // Arrange, Act and Assert
    assertTrue(new OrderedFloatSerialiser().preservesObjectOrdering());
  }

  /**
   * Test {@link OrderedFloatSerialiser#canHandle(Class)}.
   *
   * <ul>
   *   <li>When {@code Float}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link OrderedFloatSerialiser#canHandle(Class)}
   */
  @Test
  @DisplayName("Test canHandle(Class); when 'java.lang.Float'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OrderedFloatSerialiser.canHandle(Class)"})
  void testCanHandle_whenJavaLangFloat_thenReturnTrue() {
    // Arrange
    OrderedFloatSerialiser orderedFloatSerialiser = new OrderedFloatSerialiser();
    Class<Float> clazz = Float.class;

    // Act and Assert
    assertTrue(orderedFloatSerialiser.canHandle(clazz));
  }

  /**
   * Test {@link OrderedFloatSerialiser#canHandle(Class)}.
   *
   * <ul>
   *   <li>When {@code Object}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link OrderedFloatSerialiser#canHandle(Class)}
   */
  @Test
  @DisplayName("Test canHandle(Class); when 'java.lang.Object'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OrderedFloatSerialiser.canHandle(Class)"})
  void testCanHandle_whenJavaLangObject_thenReturnFalse() {
    // Arrange
    OrderedFloatSerialiser orderedFloatSerialiser = new OrderedFloatSerialiser();
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertFalse(orderedFloatSerialiser.canHandle(clazz));
  }

  /**
   * Test {@link OrderedFloatSerialiser#equals(Object)}, and {@link
   * OrderedFloatSerialiser#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link OrderedFloatSerialiser#equals(Object)}
   *   <li>{@link OrderedFloatSerialiser#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OrderedFloatSerialiser.equals(Object)",
    "int OrderedFloatSerialiser.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    OrderedFloatSerialiser orderedFloatSerialiser = new OrderedFloatSerialiser();
    OrderedFloatSerialiser orderedFloatSerialiser2 = new OrderedFloatSerialiser();

    // Act and Assert
    assertEquals(orderedFloatSerialiser, orderedFloatSerialiser2);
    assertEquals(orderedFloatSerialiser.hashCode(), orderedFloatSerialiser2.hashCode());
  }

  /**
   * Test {@link OrderedFloatSerialiser#equals(Object)}, and {@link
   * OrderedFloatSerialiser#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link OrderedFloatSerialiser#equals(Object)}
   *   <li>{@link OrderedFloatSerialiser#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OrderedFloatSerialiser.equals(Object)",
    "int OrderedFloatSerialiser.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    OrderedFloatSerialiser orderedFloatSerialiser = new OrderedFloatSerialiser();

    // Act and Assert
    assertEquals(orderedFloatSerialiser, orderedFloatSerialiser);
    int expectedHashCodeResult = orderedFloatSerialiser.hashCode();
    assertEquals(expectedHashCodeResult, orderedFloatSerialiser.hashCode());
  }

  /**
   * Test {@link OrderedFloatSerialiser#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OrderedFloatSerialiser#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OrderedFloatSerialiser.equals(Object)",
    "int OrderedFloatSerialiser.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new OrderedFloatSerialiser(), 1);
  }

  /**
   * Test {@link OrderedFloatSerialiser#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OrderedFloatSerialiser#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OrderedFloatSerialiser.equals(Object)",
    "int OrderedFloatSerialiser.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new OrderedFloatSerialiser(), null);
  }

  /**
   * Test {@link OrderedFloatSerialiser#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OrderedFloatSerialiser#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OrderedFloatSerialiser.equals(Object)",
    "int OrderedFloatSerialiser.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new OrderedFloatSerialiser(), "Different type to OrderedFloatSerialiser");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link OrderedFloatSerialiser}
   *   <li>{@link OrderedFloatSerialiser#isConsistent()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void OrderedFloatSerialiser.<init>()",
    "boolean OrderedFloatSerialiser.isConsistent()"
  })
  void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertTrue(new OrderedFloatSerialiser().isConsistent());
  }
}
