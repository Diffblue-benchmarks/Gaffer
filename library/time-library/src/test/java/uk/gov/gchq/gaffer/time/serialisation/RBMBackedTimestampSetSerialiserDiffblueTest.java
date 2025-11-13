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

package uk.gov.gchq.gaffer.time.serialisation;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.UnsupportedEncodingException;
import java.time.LocalDate;
import java.time.ZoneOffset;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.exception.SerialisationException;
import uk.gov.gchq.gaffer.time.CommonTimeUtil;
import uk.gov.gchq.gaffer.time.CommonTimeUtil.TimeBucket;
import uk.gov.gchq.gaffer.time.RBMBackedTimestampSet;
import uk.gov.gchq.gaffer.time.RBMBackedTimestampSet.Builder;

class RBMBackedTimestampSetSerialiserDiffblueTest {
  /**
   * Test {@link RBMBackedTimestampSetSerialiser#canHandle(Class)}.
   * <ul>
   *   <li>When {@code Object}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RBMBackedTimestampSetSerialiser#canHandle(Class)}
   */
  @Test
  @DisplayName("Test canHandle(Class); when 'java.lang.Object'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean RBMBackedTimestampSetSerialiser.canHandle(Class)"})
  void testCanHandle_whenJavaLangObject_thenReturnFalse() {
    // Arrange
    RBMBackedTimestampSetSerialiser rbmBackedTimestampSetSerialiser = new RBMBackedTimestampSetSerialiser();
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertFalse(rbmBackedTimestampSetSerialiser.canHandle(clazz));
  }

  /**
   * Test {@link RBMBackedTimestampSetSerialiser#canHandle(Class)}.
   * <ul>
   *   <li>When {@code RBMBackedTimestampSet}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RBMBackedTimestampSetSerialiser#canHandle(Class)}
   */
  @Test
  @DisplayName("Test canHandle(Class); when 'uk.gov.gchq.gaffer.time.RBMBackedTimestampSet'; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean RBMBackedTimestampSetSerialiser.canHandle(Class)"})
  void testCanHandle_whenUkGovGchqGafferTimeRBMBackedTimestampSet_thenReturnTrue() {
    // Arrange
    RBMBackedTimestampSetSerialiser rbmBackedTimestampSetSerialiser = new RBMBackedTimestampSetSerialiser();
    Class<RBMBackedTimestampSet> clazz = RBMBackedTimestampSet.class;

    // Act and Assert
    assertTrue(rbmBackedTimestampSetSerialiser.canHandle(clazz));
  }

  /**
   * Test {@link RBMBackedTimestampSetSerialiser#serialise(RBMBackedTimestampSet)} with {@code RBMBackedTimestampSet}.
   * <p>
   * Method under test: {@link RBMBackedTimestampSetSerialiser#serialise(RBMBackedTimestampSet)}
   */
  @Test
  @DisplayName("Test serialise(RBMBackedTimestampSet) with 'RBMBackedTimestampSet'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"byte[] RBMBackedTimestampSetSerialiser.serialise(RBMBackedTimestampSet)"})
  void testSerialiseWithRBMBackedTimestampSet() throws SerialisationException {
    // Arrange
    RBMBackedTimestampSetSerialiser rbmBackedTimestampSetSerialiser = new RBMBackedTimestampSetSerialiser();

    // Act and Assert
    assertArrayEquals(new byte[]{0, ':', '0', 0, 0, 0, 0, 0, 0},
        rbmBackedTimestampSetSerialiser.serialise(new RBMBackedTimestampSet(TimeBucket.SECOND)));
  }

  /**
   * Test {@link RBMBackedTimestampSetSerialiser#serialise(RBMBackedTimestampSet)} with {@code RBMBackedTimestampSet}.
   * <p>
   * Method under test: {@link RBMBackedTimestampSetSerialiser#serialise(RBMBackedTimestampSet)}
   */
  @Test
  @DisplayName("Test serialise(RBMBackedTimestampSet) with 'RBMBackedTimestampSet'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"byte[] RBMBackedTimestampSetSerialiser.serialise(RBMBackedTimestampSet)"})
  void testSerialiseWithRBMBackedTimestampSet2() throws SerialisationException {
    // Arrange
    RBMBackedTimestampSetSerialiser rbmBackedTimestampSetSerialiser = new RBMBackedTimestampSetSerialiser();
    Builder timeBucketResult = (new Builder()).timeBucket(TimeBucket.SECOND);
    RBMBackedTimestampSet rbmBackedTimestampSet = timeBucketResult
        .timestamp(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant())
        .build();

    // Act and Assert
    assertArrayEquals(new byte[]{0, ':', '0', 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 16, 0, 0, 0, 0, 0},
        rbmBackedTimestampSetSerialiser.serialise(rbmBackedTimestampSet));
  }

  /**
   * Test {@link RBMBackedTimestampSetSerialiser#serialise(RBMBackedTimestampSet)} with {@code RBMBackedTimestampSet}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return empty array of {@code byte}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RBMBackedTimestampSetSerialiser#serialise(RBMBackedTimestampSet)}
   */
  @Test
  @DisplayName("Test serialise(RBMBackedTimestampSet) with 'RBMBackedTimestampSet'; when 'null'; then return empty array of byte")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"byte[] RBMBackedTimestampSetSerialiser.serialise(RBMBackedTimestampSet)"})
  void testSerialiseWithRBMBackedTimestampSet_whenNull_thenReturnEmptyArrayOfByte() throws SerialisationException {
    // Arrange, Act and Assert
    assertArrayEquals(new byte[]{}, (new RBMBackedTimestampSetSerialiser()).serialise(null));
  }

  /**
   * Test {@link RBMBackedTimestampSetSerialiser#deserialise(byte[], int, int)} with {@code allBytes}, {@code offset}, {@code length}.
   * <ul>
   *   <li>Then throw {@link SerialisationException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RBMBackedTimestampSetSerialiser#deserialise(byte[], int, int)}
   */
  @Test
  @DisplayName("Test deserialise(byte[], int, int) with 'allBytes', 'offset', 'length'; then throw SerialisationException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RBMBackedTimestampSet RBMBackedTimestampSetSerialiser.deserialise(byte[], int, int)"})
  void testDeserialiseWithAllBytesOffsetLength_thenThrowSerialisationException() throws SerialisationException {
    // Arrange, Act and Assert
    assertThrows(SerialisationException.class, () -> (new RBMBackedTimestampSetSerialiser())
        .deserialise(new byte[]{'A', 'X', 3, 'X', 'A', 'X', 'A', 'X'}, 2, 8));
  }

  /**
   * Test {@link RBMBackedTimestampSetSerialiser#deserialise(byte[], int, int)} with {@code allBytes}, {@code offset}, {@code length}.
   * <ul>
   *   <li>When empty array of {@code byte}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RBMBackedTimestampSetSerialiser#deserialise(byte[], int, int)}
   */
  @Test
  @DisplayName("Test deserialise(byte[], int, int) with 'allBytes', 'offset', 'length'; when empty array of byte; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RBMBackedTimestampSet RBMBackedTimestampSetSerialiser.deserialise(byte[], int, int)"})
  void testDeserialiseWithAllBytesOffsetLength_whenEmptyArrayOfByte_thenReturnNull() throws SerialisationException {
    // Arrange, Act and Assert
    assertNull((new RBMBackedTimestampSetSerialiser()).deserialise(new byte[]{}, 2, 3));
  }

  /**
   * Test {@link RBMBackedTimestampSetSerialiser#deserialise(byte[], int, int)} with {@code allBytes}, {@code offset}, {@code length}.
   * <ul>
   *   <li>When {@code X}.</li>
   *   <li>Then throw {@link SerialisationException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RBMBackedTimestampSetSerialiser#deserialise(byte[], int, int)}
   */
  @Test
  @DisplayName("Test deserialise(byte[], int, int) with 'allBytes', 'offset', 'length'; when 'X'; then throw SerialisationException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RBMBackedTimestampSet RBMBackedTimestampSetSerialiser.deserialise(byte[], int, int)"})
  void testDeserialiseWithAllBytesOffsetLength_whenX_thenThrowSerialisationException() throws SerialisationException {
    // Arrange, Act and Assert
    assertThrows(SerialisationException.class, () -> (new RBMBackedTimestampSetSerialiser())
        .deserialise(new byte[]{'A', 'X', 3, 'X', 'A', 'X', 'A', 'X'}, 2, 3));
  }

  /**
   * Test {@link RBMBackedTimestampSetSerialiser#deserialise(byte[], int, int)} with {@code allBytes}, {@code offset}, {@code length}.
   * <ul>
   *   <li>When zero.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RBMBackedTimestampSetSerialiser#deserialise(byte[], int, int)}
   */
  @Test
  @DisplayName("Test deserialise(byte[], int, int) with 'allBytes', 'offset', 'length'; when zero; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RBMBackedTimestampSet RBMBackedTimestampSetSerialiser.deserialise(byte[], int, int)"})
  void testDeserialiseWithAllBytesOffsetLength_whenZero_thenReturnNull()
      throws UnsupportedEncodingException, SerialisationException {
    // Arrange
    RBMBackedTimestampSetSerialiser rbmBackedTimestampSetSerialiser = new RBMBackedTimestampSetSerialiser();

    // Act and Assert
    assertNull(rbmBackedTimestampSetSerialiser.deserialise("AXAXAXAX".getBytes("UTF-8"), 2, 0));
  }

  /**
   * Test {@link RBMBackedTimestampSetSerialiser#deserialise(byte[])} with {@code bytes}.
   * <ul>
   *   <li>Then throw {@link SerialisationException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RBMBackedTimestampSetSerialiser#deserialise(byte[])}
   */
  @Test
  @DisplayName("Test deserialise(byte[]) with 'bytes'; then throw SerialisationException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RBMBackedTimestampSet RBMBackedTimestampSetSerialiser.deserialise(byte[])"})
  void testDeserialiseWithBytes_thenThrowSerialisationException() throws SerialisationException {
    // Arrange, Act and Assert
    assertThrows(SerialisationException.class,
        () -> (new RBMBackedTimestampSetSerialiser()).deserialise(new byte[]{1, 'X', 'A', 'X', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test {@link RBMBackedTimestampSetSerialiser#deserialise(byte[])} with {@code bytes}.
   * <ul>
   *   <li>When empty array of {@code byte}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RBMBackedTimestampSetSerialiser#deserialise(byte[])}
   */
  @Test
  @DisplayName("Test deserialise(byte[]) with 'bytes'; when empty array of byte; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RBMBackedTimestampSet RBMBackedTimestampSetSerialiser.deserialise(byte[])"})
  void testDeserialiseWithBytes_whenEmptyArrayOfByte_thenReturnNull() throws SerialisationException {
    // Arrange, Act and Assert
    assertNull((new RBMBackedTimestampSetSerialiser()).deserialise(new byte[]{}));
  }

  /**
   * Test {@link RBMBackedTimestampSetSerialiser#deserialiseEmpty()}.
   * <p>
   * Method under test: {@link RBMBackedTimestampSetSerialiser#deserialiseEmpty()}
   */
  @Test
  @DisplayName("Test deserialiseEmpty()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RBMBackedTimestampSet RBMBackedTimestampSetSerialiser.deserialiseEmpty()"})
  void testDeserialiseEmpty() throws SerialisationException {
    // Arrange, Act and Assert
    assertNull((new RBMBackedTimestampSetSerialiser()).deserialiseEmpty());
  }

  /**
   * Test {@link RBMBackedTimestampSetSerialiser#preservesObjectOrdering()}.
   * <p>
   * Method under test: {@link RBMBackedTimestampSetSerialiser#preservesObjectOrdering()}
   */
  @Test
  @DisplayName("Test preservesObjectOrdering()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean RBMBackedTimestampSetSerialiser.preservesObjectOrdering()"})
  void testPreservesObjectOrdering() {
    // Arrange, Act and Assert
    assertFalse((new RBMBackedTimestampSetSerialiser()).preservesObjectOrdering());
  }

  /**
   * Test {@link RBMBackedTimestampSetSerialiser#equals(Object)}, and {@link RBMBackedTimestampSetSerialiser#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link RBMBackedTimestampSetSerialiser#equals(Object)}
   *   <li>{@link RBMBackedTimestampSetSerialiser#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean RBMBackedTimestampSetSerialiser.equals(Object)",
      "int RBMBackedTimestampSetSerialiser.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    RBMBackedTimestampSetSerialiser rbmBackedTimestampSetSerialiser = new RBMBackedTimestampSetSerialiser();
    RBMBackedTimestampSetSerialiser rbmBackedTimestampSetSerialiser2 = new RBMBackedTimestampSetSerialiser();

    // Act and Assert
    assertEquals(rbmBackedTimestampSetSerialiser, rbmBackedTimestampSetSerialiser2);
    int expectedHashCodeResult = rbmBackedTimestampSetSerialiser.hashCode();
    assertEquals(expectedHashCodeResult, rbmBackedTimestampSetSerialiser2.hashCode());
  }

  /**
   * Test {@link RBMBackedTimestampSetSerialiser#equals(Object)}, and {@link RBMBackedTimestampSetSerialiser#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link RBMBackedTimestampSetSerialiser#equals(Object)}
   *   <li>{@link RBMBackedTimestampSetSerialiser#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean RBMBackedTimestampSetSerialiser.equals(Object)",
      "int RBMBackedTimestampSetSerialiser.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    RBMBackedTimestampSetSerialiser rbmBackedTimestampSetSerialiser = new RBMBackedTimestampSetSerialiser();

    // Act and Assert
    assertEquals(rbmBackedTimestampSetSerialiser, rbmBackedTimestampSetSerialiser);
    int expectedHashCodeResult = rbmBackedTimestampSetSerialiser.hashCode();
    assertEquals(expectedHashCodeResult, rbmBackedTimestampSetSerialiser.hashCode());
  }

  /**
   * Test {@link RBMBackedTimestampSetSerialiser#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RBMBackedTimestampSetSerialiser#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean RBMBackedTimestampSetSerialiser.equals(Object)",
      "int RBMBackedTimestampSetSerialiser.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new RBMBackedTimestampSetSerialiser(), 1);
  }

  /**
   * Test {@link RBMBackedTimestampSetSerialiser#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RBMBackedTimestampSetSerialiser#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean RBMBackedTimestampSetSerialiser.equals(Object)",
      "int RBMBackedTimestampSetSerialiser.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new RBMBackedTimestampSetSerialiser(), null);
  }

  /**
   * Test {@link RBMBackedTimestampSetSerialiser#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RBMBackedTimestampSetSerialiser#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean RBMBackedTimestampSetSerialiser.equals(Object)",
      "int RBMBackedTimestampSetSerialiser.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new RBMBackedTimestampSetSerialiser(), "Different type to RBMBackedTimestampSetSerialiser");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link RBMBackedTimestampSetSerialiser}
   *   <li>{@link RBMBackedTimestampSetSerialiser#isConsistent()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void RBMBackedTimestampSetSerialiser.<init>()",
      "boolean RBMBackedTimestampSetSerialiser.isConsistent()"})
  void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertFalse((new RBMBackedTimestampSetSerialiser()).isConsistent());
  }
}
