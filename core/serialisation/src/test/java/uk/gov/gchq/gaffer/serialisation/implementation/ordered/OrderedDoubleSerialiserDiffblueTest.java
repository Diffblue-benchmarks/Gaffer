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
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.exception.SerialisationException;

class OrderedDoubleSerialiserDiffblueTest {
  /**
   * Test {@link OrderedDoubleSerialiser#serialise(Double)} with {@code Double}.
   * <ul>
   *   <li>Then return array of {@code byte} with backspace and {@code @}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderedDoubleSerialiser#serialise(Double)}
   */
  @Test
  @DisplayName("Test serialise(Double) with 'Double'; then return array of byte with backspace and '@'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"byte[] OrderedDoubleSerialiser.serialise(Double)"})
  void testSerialiseWithDouble_thenReturnArrayOfByteWithBackspaceAndCommercialAt() {
    // Arrange, Act and Assert
    assertArrayEquals(new byte[]{'\b', '@', '$', 0, 0, 0, 0, 0, 0}, (new OrderedDoubleSerialiser()).serialise(10.0d));
  }

  /**
   * Test {@link OrderedDoubleSerialiser#serialise(Double)} with {@code Double}.
   * <ul>
   *   <li>Then return array of {@code byte} with backspace and minus sixty-four.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderedDoubleSerialiser#serialise(Double)}
   */
  @Test
  @DisplayName("Test serialise(Double) with 'Double'; then return array of byte with backspace and minus sixty-four")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"byte[] OrderedDoubleSerialiser.serialise(Double)"})
  void testSerialiseWithDouble_thenReturnArrayOfByteWithBackspaceAndMinusSixtyFour() {
    // Arrange, Act and Assert
    assertArrayEquals(new byte[]{'\b', -64, 31, -1, -1, -1, -1, -1, -1},
        (new OrderedDoubleSerialiser()).serialise(-0.5d));
  }

  /**
   * Test {@link OrderedDoubleSerialiser#deserialise(byte[])} with {@code bytes}.
   * <ul>
   *   <li>When {@code A}.</li>
   *   <li>Then return doubleValue is {@code -0.0}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderedDoubleSerialiser#deserialise(byte[])}
   */
  @Test
  @DisplayName("Test deserialise(byte[]) with 'bytes'; when 'A'; then return doubleValue is '-0.0'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Double OrderedDoubleSerialiser.deserialise(byte[])"})
  void testDeserialiseWithBytes_whenA_thenReturnDoubleValueIs00() throws SerialisationException {
    // Arrange, Act and Assert
    assertEquals(-0.0d,
        (new OrderedDoubleSerialiser()).deserialise(new byte[]{16, 'X', 'A', 'X', 'A', 'X', 'A', 'X'}).doubleValue());
  }

  /**
   * Test {@link OrderedDoubleSerialiser#deserialise(byte[])} with {@code bytes}.
   * <ul>
   *   <li>When array of {@code byte} with sixteen.</li>
   *   <li>Then return doubleValue is {@code -0.0}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderedDoubleSerialiser#deserialise(byte[])}
   */
  @Test
  @DisplayName("Test deserialise(byte[]) with 'bytes'; when array of byte with sixteen; then return doubleValue is '-0.0'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Double OrderedDoubleSerialiser.deserialise(byte[])"})
  void testDeserialiseWithBytes_whenArrayOfByteWithSixteen_thenReturnDoubleValueIs00() throws SerialisationException {
    // Arrange, Act and Assert
    assertEquals(-0.0d, (new OrderedDoubleSerialiser()).deserialise(new byte[]{16}).doubleValue());
  }

  /**
   * Test {@link OrderedDoubleSerialiser#deserialise(byte[])} with {@code bytes}.
   * <ul>
   *   <li>When array of {@code byte} with zero.</li>
   *   <li>Then return doubleValue is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderedDoubleSerialiser#deserialise(byte[])}
   */
  @Test
  @DisplayName("Test deserialise(byte[]) with 'bytes'; when array of byte with zero; then return doubleValue is zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Double OrderedDoubleSerialiser.deserialise(byte[])"})
  void testDeserialiseWithBytes_whenArrayOfByteWithZero_thenReturnDoubleValueIsZero() throws SerialisationException {
    // Arrange, Act and Assert
    assertEquals(0.0d, (new OrderedDoubleSerialiser()).deserialise(new byte[]{0}).doubleValue());
  }

  /**
   * Test {@link OrderedDoubleSerialiser#deserialiseEmpty()}.
   * <p>
   * Method under test: {@link OrderedDoubleSerialiser#deserialiseEmpty()}
   */
  @Test
  @DisplayName("Test deserialiseEmpty()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Double OrderedDoubleSerialiser.deserialiseEmpty()"})
  void testDeserialiseEmpty() {
    // Arrange, Act and Assert
    assertNull((new OrderedDoubleSerialiser()).deserialiseEmpty());
  }

  /**
   * Test {@link OrderedDoubleSerialiser#preservesObjectOrdering()}.
   * <p>
   * Method under test: {@link OrderedDoubleSerialiser#preservesObjectOrdering()}
   */
  @Test
  @DisplayName("Test preservesObjectOrdering()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean OrderedDoubleSerialiser.preservesObjectOrdering()"})
  void testPreservesObjectOrdering() {
    // Arrange, Act and Assert
    assertTrue((new OrderedDoubleSerialiser()).preservesObjectOrdering());
  }

  /**
   * Test {@link OrderedDoubleSerialiser#canHandle(Class)}.
   * <ul>
   *   <li>When {@code Double}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderedDoubleSerialiser#canHandle(Class)}
   */
  @Test
  @DisplayName("Test canHandle(Class); when 'java.lang.Double'; then return 'true'")
  @Tag("MaintainedByDiffblue")
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
   * <ul>
   *   <li>When {@code Object}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderedDoubleSerialiser#canHandle(Class)}
   */
  @Test
  @DisplayName("Test canHandle(Class); when 'java.lang.Object'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean OrderedDoubleSerialiser.canHandle(Class)"})
  void testCanHandle_whenJavaLangObject_thenReturnFalse() {
    // Arrange
    OrderedDoubleSerialiser orderedDoubleSerialiser = new OrderedDoubleSerialiser();
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertFalse(orderedDoubleSerialiser.canHandle(clazz));
  }

  /**
   * Test {@link OrderedDoubleSerialiser#equals(Object)}, and {@link OrderedDoubleSerialiser#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link OrderedDoubleSerialiser#equals(Object)}
   *   <li>{@link OrderedDoubleSerialiser#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean OrderedDoubleSerialiser.equals(Object)", "int OrderedDoubleSerialiser.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    OrderedDoubleSerialiser orderedDoubleSerialiser = new OrderedDoubleSerialiser();
    OrderedDoubleSerialiser orderedDoubleSerialiser2 = new OrderedDoubleSerialiser();

    // Act and Assert
    assertEquals(orderedDoubleSerialiser, orderedDoubleSerialiser2);
    int expectedHashCodeResult = orderedDoubleSerialiser.hashCode();
    assertEquals(expectedHashCodeResult, orderedDoubleSerialiser2.hashCode());
  }

  /**
   * Test {@link OrderedDoubleSerialiser#equals(Object)}, and {@link OrderedDoubleSerialiser#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link OrderedDoubleSerialiser#equals(Object)}
   *   <li>{@link OrderedDoubleSerialiser#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean OrderedDoubleSerialiser.equals(Object)", "int OrderedDoubleSerialiser.hashCode()"})
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
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderedDoubleSerialiser#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean OrderedDoubleSerialiser.equals(Object)", "int OrderedDoubleSerialiser.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new OrderedDoubleSerialiser(), 1);
  }

  /**
   * Test {@link OrderedDoubleSerialiser#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderedDoubleSerialiser#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean OrderedDoubleSerialiser.equals(Object)", "int OrderedDoubleSerialiser.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new OrderedDoubleSerialiser(), null);
  }

  /**
   * Test {@link OrderedDoubleSerialiser#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderedDoubleSerialiser#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean OrderedDoubleSerialiser.equals(Object)", "int OrderedDoubleSerialiser.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new OrderedDoubleSerialiser(), "Different type to OrderedDoubleSerialiser");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link OrderedDoubleSerialiser}
   *   <li>{@link OrderedDoubleSerialiser#isConsistent()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void OrderedDoubleSerialiser.<init>()", "boolean OrderedDoubleSerialiser.isConsistent()"})
  void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertTrue((new OrderedDoubleSerialiser()).isConsistent());
  }
}
