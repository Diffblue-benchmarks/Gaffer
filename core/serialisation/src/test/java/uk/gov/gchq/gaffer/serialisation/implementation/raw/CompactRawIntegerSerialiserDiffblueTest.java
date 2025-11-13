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

package uk.gov.gchq.gaffer.serialisation.implementation.raw;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.UnsupportedEncodingException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.exception.SerialisationException;

class CompactRawIntegerSerialiserDiffblueTest {
  /**
   * Test {@link CompactRawIntegerSerialiser#canHandle(Class)}.
   * <ul>
   *   <li>When {@code Integer}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CompactRawIntegerSerialiser#canHandle(Class)}
   */
  @Test
  @DisplayName("Test canHandle(Class); when 'java.lang.Integer'; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean CompactRawIntegerSerialiser.canHandle(Class)"})
  void testCanHandle_whenJavaLangInteger_thenReturnTrue() {
    // Arrange
    CompactRawIntegerSerialiser compactRawIntegerSerialiser = new CompactRawIntegerSerialiser();
    Class<Integer> clazz = Integer.class;

    // Act and Assert
    assertTrue(compactRawIntegerSerialiser.canHandle(clazz));
  }

  /**
   * Test {@link CompactRawIntegerSerialiser#canHandle(Class)}.
   * <ul>
   *   <li>When {@code Object}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CompactRawIntegerSerialiser#canHandle(Class)}
   */
  @Test
  @DisplayName("Test canHandle(Class); when 'java.lang.Object'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean CompactRawIntegerSerialiser.canHandle(Class)"})
  void testCanHandle_whenJavaLangObject_thenReturnFalse() {
    // Arrange
    CompactRawIntegerSerialiser compactRawIntegerSerialiser = new CompactRawIntegerSerialiser();
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertFalse(compactRawIntegerSerialiser.canHandle(clazz));
  }

  /**
   * Test {@link CompactRawIntegerSerialiser#serialise(Integer)} with {@code Integer}.
   * <p>
   * Method under test: {@link CompactRawIntegerSerialiser#serialise(Integer)}
   */
  @Test
  @DisplayName("Test serialise(Integer) with 'Integer'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"byte[] CompactRawIntegerSerialiser.serialise(Integer)"})
  void testSerialiseWithInteger() throws SerialisationException {
    // Arrange, Act and Assert
    assertArrayEquals(new byte[]{-124, Byte.MAX_VALUE, -1, -1, -1},
        (new CompactRawIntegerSerialiser()).serialise(Integer.MIN_VALUE));
  }

  /**
   * Test {@link CompactRawIntegerSerialiser#serialise(Integer)} with {@code Integer}.
   * <ul>
   *   <li>When one.</li>
   *   <li>Then return array of {@code byte} with one.</li>
   * </ul>
   * <p>
   * Method under test: {@link CompactRawIntegerSerialiser#serialise(Integer)}
   */
  @Test
  @DisplayName("Test serialise(Integer) with 'Integer'; when one; then return array of byte with one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"byte[] CompactRawIntegerSerialiser.serialise(Integer)"})
  void testSerialiseWithInteger_whenOne_thenReturnArrayOfByteWithOne() throws SerialisationException {
    // Arrange, Act and Assert
    assertArrayEquals(new byte[]{1}, (new CompactRawIntegerSerialiser()).serialise(1));
  }

  /**
   * Test {@link CompactRawIntegerSerialiser#deserialise(byte[], int, int)} with {@code allBytes}, {@code offset}, {@code length}.
   * <ul>
   *   <li>Then return intValue is sixty-five.</li>
   * </ul>
   * <p>
   * Method under test: {@link CompactRawIntegerSerialiser#deserialise(byte[], int, int)}
   */
  @Test
  @DisplayName("Test deserialise(byte[], int, int) with 'allBytes', 'offset', 'length'; then return intValue is sixty-five")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Integer CompactRawIntegerSerialiser.deserialise(byte[], int, int)"})
  void testDeserialiseWithAllBytesOffsetLength_thenReturnIntValueIsSixtyFive()
      throws UnsupportedEncodingException, SerialisationException {
    // Arrange
    CompactRawIntegerSerialiser compactRawIntegerSerialiser = new CompactRawIntegerSerialiser();

    // Act and Assert
    assertEquals(65, compactRawIntegerSerialiser.deserialise("AXAXAXAX".getBytes("UTF-8"), 2, 3).intValue());
  }

  /**
   * Test {@link CompactRawIntegerSerialiser#deserialise(byte[])} with {@code bytes}.
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   *   <li>Then return intValue is sixty-five.</li>
   * </ul>
   * <p>
   * Method under test: {@link CompactRawIntegerSerialiser#deserialise(byte[])}
   */
  @Test
  @DisplayName("Test deserialise(byte[]) with 'bytes'; when 'AXAXAXAX' Bytes is 'UTF-8'; then return intValue is sixty-five")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Integer CompactRawIntegerSerialiser.deserialise(byte[])"})
  void testDeserialiseWithBytes_whenAxaxaxaxBytesIsUtf8_thenReturnIntValueIsSixtyFive()
      throws UnsupportedEncodingException, SerialisationException {
    // Arrange
    CompactRawIntegerSerialiser compactRawIntegerSerialiser = new CompactRawIntegerSerialiser();

    // Act and Assert
    assertEquals(65, compactRawIntegerSerialiser.deserialise("AXAXAXAX".getBytes("UTF-8")).intValue());
  }

  /**
   * Test {@link CompactRawIntegerSerialiser#deserialiseEmpty()}.
   * <p>
   * Method under test: {@link CompactRawIntegerSerialiser#deserialiseEmpty()}
   */
  @Test
  @DisplayName("Test deserialiseEmpty()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Integer CompactRawIntegerSerialiser.deserialiseEmpty()"})
  void testDeserialiseEmpty() {
    // Arrange, Act and Assert
    assertNull((new CompactRawIntegerSerialiser()).deserialiseEmpty());
  }

  /**
   * Test {@link CompactRawIntegerSerialiser#preservesObjectOrdering()}.
   * <p>
   * Method under test: {@link CompactRawIntegerSerialiser#preservesObjectOrdering()}
   */
  @Test
  @DisplayName("Test preservesObjectOrdering()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean CompactRawIntegerSerialiser.preservesObjectOrdering()"})
  void testPreservesObjectOrdering() {
    // Arrange, Act and Assert
    assertFalse((new CompactRawIntegerSerialiser()).preservesObjectOrdering());
  }

  /**
   * Test {@link CompactRawIntegerSerialiser#equals(Object)}, and {@link CompactRawIntegerSerialiser#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link CompactRawIntegerSerialiser#equals(Object)}
   *   <li>{@link CompactRawIntegerSerialiser#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean CompactRawIntegerSerialiser.equals(Object)",
      "int CompactRawIntegerSerialiser.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    CompactRawIntegerSerialiser compactRawIntegerSerialiser = new CompactRawIntegerSerialiser();
    CompactRawIntegerSerialiser compactRawIntegerSerialiser2 = new CompactRawIntegerSerialiser();

    // Act and Assert
    assertEquals(compactRawIntegerSerialiser, compactRawIntegerSerialiser2);
    int expectedHashCodeResult = compactRawIntegerSerialiser.hashCode();
    assertEquals(expectedHashCodeResult, compactRawIntegerSerialiser2.hashCode());
  }

  /**
   * Test {@link CompactRawIntegerSerialiser#equals(Object)}, and {@link CompactRawIntegerSerialiser#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link CompactRawIntegerSerialiser#equals(Object)}
   *   <li>{@link CompactRawIntegerSerialiser#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean CompactRawIntegerSerialiser.equals(Object)",
      "int CompactRawIntegerSerialiser.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    CompactRawIntegerSerialiser compactRawIntegerSerialiser = new CompactRawIntegerSerialiser();

    // Act and Assert
    assertEquals(compactRawIntegerSerialiser, compactRawIntegerSerialiser);
    int expectedHashCodeResult = compactRawIntegerSerialiser.hashCode();
    assertEquals(expectedHashCodeResult, compactRawIntegerSerialiser.hashCode());
  }

  /**
   * Test {@link CompactRawIntegerSerialiser#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link CompactRawIntegerSerialiser#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean CompactRawIntegerSerialiser.equals(Object)",
      "int CompactRawIntegerSerialiser.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new CompactRawIntegerSerialiser(), 1);
  }

  /**
   * Test {@link CompactRawIntegerSerialiser#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link CompactRawIntegerSerialiser#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean CompactRawIntegerSerialiser.equals(Object)",
      "int CompactRawIntegerSerialiser.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new CompactRawIntegerSerialiser(), null);
  }

  /**
   * Test {@link CompactRawIntegerSerialiser#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link CompactRawIntegerSerialiser#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean CompactRawIntegerSerialiser.equals(Object)",
      "int CompactRawIntegerSerialiser.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new CompactRawIntegerSerialiser(), "Different type to CompactRawIntegerSerialiser");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link CompactRawIntegerSerialiser}
   *   <li>{@link CompactRawIntegerSerialiser#isConsistent()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void CompactRawIntegerSerialiser.<init>()", "boolean CompactRawIntegerSerialiser.isConsistent()"})
  void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertTrue((new CompactRawIntegerSerialiser()).isConsistent());
  }
}
