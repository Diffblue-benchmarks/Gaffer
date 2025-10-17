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

package uk.gov.gchq.gaffer.serialisation.implementation.ordered;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.exception.SerialisationException;

class OrderedDoubleSerialiserDiffblueTest {
  /**
   * Test {@link OrderedDoubleSerialiser#serialise(Double)} with {@code Double}.
   *
   * <ul>
   *   <li>Then return array of {@code byte} with backspace and {@code @}.
   * </ul>
   *
   * <p>Method under test: {@link OrderedDoubleSerialiser#serialise(Double)}
   */
  @Test
  @DisplayName(
      "Test serialise(Double) with 'Double'; then return array of byte with backspace and '@'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] OrderedDoubleSerialiser.serialise(Double)"})
  void testSerialiseWithDouble_thenReturnArrayOfByteWithBackspaceAndCommercialAt() {
    // Arrange, Act and Assert
    assertArrayEquals(
        new byte[] {'\b', '@', '$', 0, 0, 0, 0, 0, 0},
        new OrderedDoubleSerialiser().serialise(10.0d));
  }

  /**
   * Test {@link OrderedDoubleSerialiser#serialise(Double)} with {@code Double}.
   *
   * <ul>
   *   <li>Then return array of {@code byte} with backspace and minus sixty-four.
   * </ul>
   *
   * <p>Method under test: {@link OrderedDoubleSerialiser#serialise(Double)}
   */
  @Test
  @DisplayName(
      "Test serialise(Double) with 'Double'; then return array of byte with backspace and minus sixty-four")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] OrderedDoubleSerialiser.serialise(Double)"})
  void testSerialiseWithDouble_thenReturnArrayOfByteWithBackspaceAndMinusSixtyFour() {
    // Arrange, Act and Assert
    assertArrayEquals(
        new byte[] {'\b', -64, 31, -1, -1, -1, -1, -1, -1},
        new OrderedDoubleSerialiser().serialise(-0.5d));
  }

  /**
   * Test {@link OrderedDoubleSerialiser#deserialise(byte[])} with {@code bytes}.
   *
   * <ul>
   *   <li>When {@code A}.
   *   <li>Then return doubleValue is {@code -0.0}.
   * </ul>
   *
   * <p>Method under test: {@link OrderedDoubleSerialiser#deserialise(byte[])}
   */
  @Test
  @DisplayName("Test deserialise(byte[]) with 'bytes'; when 'A'; then return doubleValue is '-0.0'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Double OrderedDoubleSerialiser.deserialise(byte[])"})
  void testDeserialiseWithBytes_whenA_thenReturnDoubleValueIs00() throws SerialisationException {
    // Arrange, Act and Assert
    assertEquals(
        -0.0d,
        new OrderedDoubleSerialiser()
            .deserialise(new byte[] {16, 'X', 'A', 'X', 'A', 'X', 'A', 'X'})
            .doubleValue());
  }

  /**
   * Test {@link OrderedDoubleSerialiser#deserialise(byte[])} with {@code bytes}.
   *
   * <ul>
   *   <li>When array of {@code byte} with sixteen.
   *   <li>Then return doubleValue is {@code -0.0}.
   * </ul>
   *
   * <p>Method under test: {@link OrderedDoubleSerialiser#deserialise(byte[])}
   */
  @Test
  @DisplayName(
      "Test deserialise(byte[]) with 'bytes'; when array of byte with sixteen; then return doubleValue is '-0.0'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Double OrderedDoubleSerialiser.deserialise(byte[])"})
  void testDeserialiseWithBytes_whenArrayOfByteWithSixteen_thenReturnDoubleValueIs00()
      throws SerialisationException {
    // Arrange, Act and Assert
    assertEquals(-0.0d, new OrderedDoubleSerialiser().deserialise(new byte[] {16}).doubleValue());
  }

  /**
   * Test {@link OrderedDoubleSerialiser#deserialise(byte[])} with {@code bytes}.
   *
   * <ul>
   *   <li>When array of {@code byte} with zero.
   *   <li>Then return doubleValue is zero.
   * </ul>
   *
   * <p>Method under test: {@link OrderedDoubleSerialiser#deserialise(byte[])}
   */
  @Test
  @DisplayName(
      "Test deserialise(byte[]) with 'bytes'; when array of byte with zero; then return doubleValue is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Double OrderedDoubleSerialiser.deserialise(byte[])"})
  void testDeserialiseWithBytes_whenArrayOfByteWithZero_thenReturnDoubleValueIsZero()
      throws SerialisationException {
    // Arrange, Act and Assert
    assertEquals(0.0d, new OrderedDoubleSerialiser().deserialise(new byte[] {0}).doubleValue());
  }

  /**
   * Test {@link OrderedDoubleSerialiser#deserialiseEmpty()}.
   *
   * <p>Method under test: {@link OrderedDoubleSerialiser#deserialiseEmpty()}
   */
  @Test
  @DisplayName("Test deserialiseEmpty()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Double OrderedDoubleSerialiser.deserialiseEmpty()"})
  void testDeserialiseEmpty() {
    // Arrange, Act and Assert
    assertNull(new OrderedDoubleSerialiser().deserialiseEmpty());
  }

  /**
   * Test {@link OrderedDoubleSerialiser#preservesObjectOrdering()}.
   *
   * <p>Method under test: {@link OrderedDoubleSerialiser#preservesObjectOrdering()}
   */
  @Test
  @DisplayName("Test preservesObjectOrdering()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OrderedDoubleSerialiser.preservesObjectOrdering()"})
  void testPreservesObjectOrdering() {
    // Arrange, Act and Assert
    assertTrue(new OrderedDoubleSerialiser().preservesObjectOrdering());
  }

  /**
   * Test {@link OrderedDoubleSerialiser#canHandle(Class)}.
   *
   * <ul>
   *   <li>When {@code Double}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link OrderedDoubleSerialiser#canHandle(Class)}
   */
  @Test
  @DisplayName("Test canHandle(Class); when 'java.lang.Double'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OrderedDoubleSerialiser.canHandle(Class)"})
  void testCanHandle_whenJavaLangDouble_thenReturnTrue() {
    // Arrange
    OrderedDoubleSerialiser orderedDoubleSerialiser = new OrderedDoubleSerialiser();
    Class<Double> clazz = Double.class;

    // Act and Assert
    assertTrue(orderedDoubleSerialiser.canHandle(clazz));
  }

  /**
   * Test {@link OrderedDoubleSerialiser#canHandle(Class)}.
   *
   * <ul>
   *   <li>When {@code Object}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link OrderedDoubleSerialiser#canHandle(Class)}
   */
  @Test
  @DisplayName("Test canHandle(Class); when 'java.lang.Object'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OrderedDoubleSerialiser.canHandle(Class)"})
  void testCanHandle_whenJavaLangObject_thenReturnFalse() {
    // Arrange
    OrderedDoubleSerialiser orderedDoubleSerialiser = new OrderedDoubleSerialiser();
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertFalse(orderedDoubleSerialiser.canHandle(clazz));
  }

  /**
   * Test {@link OrderedDoubleSerialiser#equals(Object)}, and {@link
   * OrderedDoubleSerialiser#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link OrderedDoubleSerialiser#equals(Object)}
   *   <li>{@link OrderedDoubleSerialiser#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OrderedDoubleSerialiser.equals(Object)",
    "int OrderedDoubleSerialiser.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    OrderedDoubleSerialiser orderedDoubleSerialiser = new OrderedDoubleSerialiser();
    OrderedDoubleSerialiser orderedDoubleSerialiser2 = new OrderedDoubleSerialiser();

    // Act and Assert
    assertEquals(orderedDoubleSerialiser, orderedDoubleSerialiser2);
    assertEquals(orderedDoubleSerialiser.hashCode(), orderedDoubleSerialiser2.hashCode());
  }

  /**
   * Test {@link OrderedDoubleSerialiser#equals(Object)}, and {@link
   * OrderedDoubleSerialiser#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link OrderedDoubleSerialiser#equals(Object)}
   *   <li>{@link OrderedDoubleSerialiser#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OrderedDoubleSerialiser.equals(Object)",
    "int OrderedDoubleSerialiser.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    OrderedDoubleSerialiser orderedDoubleSerialiser = new OrderedDoubleSerialiser();

    // Act and Assert
    assertEquals(orderedDoubleSerialiser, orderedDoubleSerialiser);
    int expectedHashCodeResult = orderedDoubleSerialiser.hashCode();
    assertEquals(expectedHashCodeResult, orderedDoubleSerialiser.hashCode());
  }

  /**
   * Test {@link OrderedDoubleSerialiser#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OrderedDoubleSerialiser#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OrderedDoubleSerialiser.equals(Object)",
    "int OrderedDoubleSerialiser.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new OrderedDoubleSerialiser(), 1);
  }

  /**
   * Test {@link OrderedDoubleSerialiser#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OrderedDoubleSerialiser#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OrderedDoubleSerialiser.equals(Object)",
    "int OrderedDoubleSerialiser.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new OrderedDoubleSerialiser(), null);
  }

  /**
   * Test {@link OrderedDoubleSerialiser#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OrderedDoubleSerialiser#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OrderedDoubleSerialiser.equals(Object)",
    "int OrderedDoubleSerialiser.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new OrderedDoubleSerialiser(), "Different type to OrderedDoubleSerialiser");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link OrderedDoubleSerialiser}
   *   <li>{@link OrderedDoubleSerialiser#isConsistent()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void OrderedDoubleSerialiser.<init>()",
    "boolean OrderedDoubleSerialiser.isConsistent()"
  })
  void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertTrue(new OrderedDoubleSerialiser().isConsistent());
  }
}
