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

package uk.gov.gchq.gaffer.serialisation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import java.io.UnsupportedEncodingException;
import java.util.function.BiFunction;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.exception.SerialisationException;
import uk.gov.gchq.gaffer.types.FreqMap;

class FreqMapSerialiserDiffblueTest {
  /**
   * Method under test: {@link FreqMapSerialiser#serialise(FreqMap)}
   */
  @Test
  void testSerialise() throws SerialisationException {
    // Arrange
    FreqMapSerialiser freqMapSerialiser = new FreqMapSerialiser();

    // Act and Assert
    assertEquals(0, freqMapSerialiser.serialise(new FreqMap()).length);
  }

  /**
   * Method under test: {@link FreqMapSerialiser#serialise(FreqMap)}
   */
  @Test
  void testSerialise2() throws SerialisationException {
    // Arrange
    FreqMapSerialiser freqMapSerialiser = new FreqMapSerialiser();

    FreqMap map = new FreqMap();
    map.computeIfPresent("foo", mock(BiFunction.class));

    // Act and Assert
    assertEquals(0, freqMapSerialiser.serialise(map).length);
  }

  /**
   * Method under test: {@link FreqMapSerialiser#deserialise(byte[])}
   */
  @Test
  void testDeserialise() throws UnsupportedEncodingException, SerialisationException {
    // Arrange
    FreqMapSerialiser freqMapSerialiser = new FreqMapSerialiser();

    // Act and Assert
    assertTrue(freqMapSerialiser.deserialise("AXAXAXAX".getBytes("UTF-8")).isEmpty());
  }

  /**
   * Method under test: {@link FreqMapSerialiser#deserialise(byte[])}
   */
  @Test
  void testDeserialise2() throws SerialisationException {
    // Arrange, Act and Assert
    assertTrue((new FreqMapSerialiser()).deserialise(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0})
        .isEmpty());
  }

  /**
   * Method under test: {@link FreqMapSerialiser#deserialise(byte[])}
   */
  @Test
  void testDeserialise3() throws SerialisationException {
    // Arrange, Act and Assert
    assertTrue((new FreqMapSerialiser()).deserialise(new byte[]{}).isEmpty());
  }

  /**
   * Method under test: {@link FreqMapSerialiser#canHandle(Class)}
   */
  @Test
  void testCanHandle() {
    // Arrange
    FreqMapSerialiser freqMapSerialiser = new FreqMapSerialiser();
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertFalse(freqMapSerialiser.canHandle(clazz));
  }

  /**
   * Method under test: {@link FreqMapSerialiser#canHandle(Class)}
   */
  @Test
  void testCanHandle2() {
    // Arrange
    FreqMapSerialiser freqMapSerialiser = new FreqMapSerialiser();
    Class<FreqMap> clazz = FreqMap.class;

    // Act and Assert
    assertTrue(freqMapSerialiser.canHandle(clazz));
  }

  /**
   * Method under test: {@link FreqMapSerialiser#preservesObjectOrdering()}
   */
  @Test
  void testPreservesObjectOrdering() {
    // Arrange, Act and Assert
    assertFalse((new FreqMapSerialiser()).preservesObjectOrdering());
  }

  /**
   * Method under test: {@link FreqMapSerialiser#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new FreqMapSerialiser(), 1);
  }

  /**
   * Method under test: {@link FreqMapSerialiser#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new FreqMapSerialiser(), null);
  }

  /**
   * Method under test: {@link FreqMapSerialiser#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new FreqMapSerialiser(), "Different type to FreqMapSerialiser");
  }

  /**
   * Method under test: {@link FreqMapSerialiser#isConsistent()}
   */
  @Test
  void testIsConsistent() {
    // Arrange, Act and Assert
    assertFalse((new FreqMapSerialiser()).isConsistent());
  }

  /**
   * Method under test: {@link FreqMapSerialiser#deserialiseEmpty()}
   */
  @Test
  void testDeserialiseEmpty() {
    // Arrange, Act and Assert
    assertTrue((new FreqMapSerialiser()).deserialiseEmpty().isEmpty());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link FreqMapSerialiser#equals(Object)}
   *   <li>{@link FreqMapSerialiser#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    FreqMapSerialiser freqMapSerialiser = new FreqMapSerialiser();
    FreqMapSerialiser freqMapSerialiser2 = new FreqMapSerialiser();

    // Act and Assert
    assertEquals(freqMapSerialiser, freqMapSerialiser2);
    int expectedHashCodeResult = freqMapSerialiser.hashCode();
    assertEquals(expectedHashCodeResult, freqMapSerialiser2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link FreqMapSerialiser#equals(Object)}
   *   <li>{@link FreqMapSerialiser#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    FreqMapSerialiser freqMapSerialiser = new FreqMapSerialiser();

    // Act and Assert
    assertEquals(freqMapSerialiser, freqMapSerialiser);
    int expectedHashCodeResult = freqMapSerialiser.hashCode();
    assertEquals(expectedHashCodeResult, freqMapSerialiser.hashCode());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link FreqMapSerialiser}
   */
  @Test
  void testNewFreqMapSerialiser() {
    // Arrange, Act and Assert
    assertFalse((new FreqMapSerialiser()).isConsistent());
  }
}
