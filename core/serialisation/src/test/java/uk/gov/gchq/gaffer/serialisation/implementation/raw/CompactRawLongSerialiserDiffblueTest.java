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

class CompactRawLongSerialiserDiffblueTest {
  /**
   * Test {@link CompactRawLongSerialiser#canHandle(Class)}.
   * <ul>
   *   <li>When {@code Long}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CompactRawLongSerialiser#canHandle(Class)}
   */
  @Test
  @DisplayName("Test canHandle(Class); when 'java.lang.Long'; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean CompactRawLongSerialiser.canHandle(Class)"})
  void testCanHandle_whenJavaLangLong_thenReturnTrue() {
    // Arrange
    CompactRawLongSerialiser compactRawLongSerialiser = new CompactRawLongSerialiser();
    Class<Long> clazz = Long.class;

    // Act and Assert
    assertTrue(compactRawLongSerialiser.canHandle(clazz));
  }

  /**
   * Test {@link CompactRawLongSerialiser#canHandle(Class)}.
   * <ul>
   *   <li>When {@code Object}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CompactRawLongSerialiser#canHandle(Class)}
   */
  @Test
  @DisplayName("Test canHandle(Class); when 'java.lang.Object'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean CompactRawLongSerialiser.canHandle(Class)"})
  void testCanHandle_whenJavaLangObject_thenReturnFalse() {
    // Arrange
    CompactRawLongSerialiser compactRawLongSerialiser = new CompactRawLongSerialiser();
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertFalse(compactRawLongSerialiser.canHandle(clazz));
  }

  /**
   * Test {@link CompactRawLongSerialiser#serialise(Long)} with {@code Long}.
   * <p>
   * Method under test: {@link CompactRawLongSerialiser#serialise(Long)}
   */
  @Test
  @DisplayName("Test serialise(Long) with 'Long'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"byte[] CompactRawLongSerialiser.serialise(Long)"})
  void testSerialiseWithLong() throws SerialisationException {
    // Arrange, Act and Assert
    assertArrayEquals(new byte[]{-113, Byte.MIN_VALUE}, (new CompactRawLongSerialiser()).serialise(128L));
  }

  /**
   * Test {@link CompactRawLongSerialiser#serialise(Long)} with {@code Long}.
   * <ul>
   *   <li>Then return array of {@code byte} with minus one hundred twenty-one and {@code p}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CompactRawLongSerialiser#serialise(Long)}
   */
  @Test
  @DisplayName("Test serialise(Long) with 'Long'; then return array of byte with minus one hundred twenty-one and 'p'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"byte[] CompactRawLongSerialiser.serialise(Long)"})
  void testSerialiseWithLong_thenReturnArrayOfByteWithMinusOneHundredTwentyOneAndP() throws SerialisationException {
    // Arrange, Act and Assert
    assertArrayEquals(new byte[]{-121, 'p'}, (new CompactRawLongSerialiser()).serialise(-113L));
  }

  /**
   * Test {@link CompactRawLongSerialiser#serialise(Long)} with {@code Long}.
   * <ul>
   *   <li>When one.</li>
   *   <li>Then return array of {@code byte} with one.</li>
   * </ul>
   * <p>
   * Method under test: {@link CompactRawLongSerialiser#serialise(Long)}
   */
  @Test
  @DisplayName("Test serialise(Long) with 'Long'; when one; then return array of byte with one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"byte[] CompactRawLongSerialiser.serialise(Long)"})
  void testSerialiseWithLong_whenOne_thenReturnArrayOfByteWithOne() throws SerialisationException {
    // Arrange, Act and Assert
    assertArrayEquals(new byte[]{1}, (new CompactRawLongSerialiser()).serialise(1L));
  }

  /**
   * Test {@link CompactRawLongSerialiser#deserialise(byte[], int, int)} with {@code allBytes}, {@code offset}, {@code length}.
   * <ul>
   *   <li>Then return longValue is sixty-five.</li>
   * </ul>
   * <p>
   * Method under test: {@link CompactRawLongSerialiser#deserialise(byte[], int, int)}
   */
  @Test
  @DisplayName("Test deserialise(byte[], int, int) with 'allBytes', 'offset', 'length'; then return longValue is sixty-five")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Long CompactRawLongSerialiser.deserialise(byte[], int, int)"})
  void testDeserialiseWithAllBytesOffsetLength_thenReturnLongValueIsSixtyFive()
      throws UnsupportedEncodingException, SerialisationException {
    // Arrange
    CompactRawLongSerialiser compactRawLongSerialiser = new CompactRawLongSerialiser();

    // Act and Assert
    assertEquals(65L, compactRawLongSerialiser.deserialise("AXAXAXAX".getBytes("UTF-8"), 2, 3).longValue());
  }

  /**
   * Test {@link CompactRawLongSerialiser#deserialise(byte[])} with {@code bytes}.
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   *   <li>Then return longValue is sixty-five.</li>
   * </ul>
   * <p>
   * Method under test: {@link CompactRawLongSerialiser#deserialise(byte[])}
   */
  @Test
  @DisplayName("Test deserialise(byte[]) with 'bytes'; when 'AXAXAXAX' Bytes is 'UTF-8'; then return longValue is sixty-five")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Long CompactRawLongSerialiser.deserialise(byte[])"})
  void testDeserialiseWithBytes_whenAxaxaxaxBytesIsUtf8_thenReturnLongValueIsSixtyFive()
      throws UnsupportedEncodingException, SerialisationException {
    // Arrange
    CompactRawLongSerialiser compactRawLongSerialiser = new CompactRawLongSerialiser();

    // Act and Assert
    assertEquals(65L, compactRawLongSerialiser.deserialise("AXAXAXAX".getBytes("UTF-8")).longValue());
  }

  /**
   * Test {@link CompactRawLongSerialiser#deserialiseEmpty()}.
   * <p>
   * Method under test: {@link CompactRawLongSerialiser#deserialiseEmpty()}
   */
  @Test
  @DisplayName("Test deserialiseEmpty()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Long CompactRawLongSerialiser.deserialiseEmpty()"})
  void testDeserialiseEmpty() {
    // Arrange, Act and Assert
    assertNull((new CompactRawLongSerialiser()).deserialiseEmpty());
  }

  /**
   * Test {@link CompactRawLongSerialiser#preservesObjectOrdering()}.
   * <p>
   * Method under test: {@link CompactRawLongSerialiser#preservesObjectOrdering()}
   */
  @Test
  @DisplayName("Test preservesObjectOrdering()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean CompactRawLongSerialiser.preservesObjectOrdering()"})
  void testPreservesObjectOrdering() {
    // Arrange, Act and Assert
    assertFalse((new CompactRawLongSerialiser()).preservesObjectOrdering());
  }

  /**
   * Test {@link CompactRawLongSerialiser#equals(Object)}, and {@link CompactRawLongSerialiser#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link CompactRawLongSerialiser#equals(Object)}
   *   <li>{@link CompactRawLongSerialiser#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean CompactRawLongSerialiser.equals(Object)", "int CompactRawLongSerialiser.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    CompactRawLongSerialiser compactRawLongSerialiser = new CompactRawLongSerialiser();
    CompactRawLongSerialiser compactRawLongSerialiser2 = new CompactRawLongSerialiser();

    // Act and Assert
    assertEquals(compactRawLongSerialiser, compactRawLongSerialiser2);
    int expectedHashCodeResult = compactRawLongSerialiser.hashCode();
    assertEquals(expectedHashCodeResult, compactRawLongSerialiser2.hashCode());
  }

  /**
   * Test {@link CompactRawLongSerialiser#equals(Object)}, and {@link CompactRawLongSerialiser#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link CompactRawLongSerialiser#equals(Object)}
   *   <li>{@link CompactRawLongSerialiser#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean CompactRawLongSerialiser.equals(Object)", "int CompactRawLongSerialiser.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    CompactRawLongSerialiser compactRawLongSerialiser = new CompactRawLongSerialiser();

    // Act and Assert
    assertEquals(compactRawLongSerialiser, compactRawLongSerialiser);
    int expectedHashCodeResult = compactRawLongSerialiser.hashCode();
    assertEquals(expectedHashCodeResult, compactRawLongSerialiser.hashCode());
  }

  /**
   * Test {@link CompactRawLongSerialiser#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link CompactRawLongSerialiser#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean CompactRawLongSerialiser.equals(Object)", "int CompactRawLongSerialiser.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new CompactRawLongSerialiser(), 1);
  }

  /**
   * Test {@link CompactRawLongSerialiser#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link CompactRawLongSerialiser#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean CompactRawLongSerialiser.equals(Object)", "int CompactRawLongSerialiser.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new CompactRawLongSerialiser(), null);
  }

  /**
   * Test {@link CompactRawLongSerialiser#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link CompactRawLongSerialiser#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean CompactRawLongSerialiser.equals(Object)", "int CompactRawLongSerialiser.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new CompactRawLongSerialiser(), "Different type to CompactRawLongSerialiser");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link CompactRawLongSerialiser}
   *   <li>{@link CompactRawLongSerialiser#isConsistent()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void CompactRawLongSerialiser.<init>()", "boolean CompactRawLongSerialiser.isConsistent()"})
  void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertTrue((new CompactRawLongSerialiser()).isConsistent());
  }
}
