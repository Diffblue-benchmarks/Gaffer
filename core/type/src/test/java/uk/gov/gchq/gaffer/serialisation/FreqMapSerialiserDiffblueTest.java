package uk.gov.gchq.gaffer.serialisation;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.io.UnsupportedEncodingException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.exception.SerialisationException;
import uk.gov.gchq.gaffer.types.FreqMap;

class FreqMapSerialiserDiffblueTest {
  /**
   * Test {@link FreqMapSerialiser#serialise(FreqMap)} with {@code FreqMap}.
   *
   * <ul>
   *   <li>Given {@code Long}.
   *   <li>Then return array of {@code byte} with {@code j} and {@code a}.
   * </ul>
   *
   * <p>Method under test: {@link FreqMapSerialiser#serialise(FreqMap)}
   */
  @Test
  @DisplayName(
      "Test serialise(FreqMap) with 'FreqMap'; given 'java.lang.Long'; then return array of byte with 'j' and 'a'")
  @Tag("MaintainedByDiffblue")
  void testSerialiseWithFreqMap_givenJavaLangLong_thenReturnArrayOfByteWithJAndA()
      throws SerialisationException {
    // Arrange
    FreqMapSerialiser freqMapSerialiser = new FreqMapSerialiser();

    FreqMap map = new FreqMap();
    map.put("java.lang.Long", 2L);
    map.put("foo", 1L);

    // Act and Assert
    assertArrayEquals(
        new byte[] {
          'j', 'a', 'v', 'a', '.', 'l', 'a', 'n', 'g', '.', 'L', 'o', 'n', 'g', 0, 2, 0, 'f', 'o',
          'o', 0, 1, 2
        },
        freqMapSerialiser.serialise(map));
  }

  /**
   * Test {@link FreqMapSerialiser#serialise(FreqMap)} with {@code FreqMap}.
   *
   * <ul>
   *   <li>Given {@link Long#MAX_VALUE}.
   *   <li>When {@link FreqMap#FreqMap()} {@code foo} is {@link Long#MAX_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link FreqMapSerialiser#serialise(FreqMap)}
   */
  @Test
  @DisplayName(
      "Test serialise(FreqMap) with 'FreqMap'; given MAX_VALUE; when FreqMap() 'foo' is MAX_VALUE")
  @Tag("MaintainedByDiffblue")
  void testSerialiseWithFreqMap_givenMax_value_whenFreqMapFooIsMax_value()
      throws SerialisationException {
    // Arrange
    FreqMapSerialiser freqMapSerialiser = new FreqMapSerialiser();

    FreqMap map = new FreqMap();
    map.put("foo", Long.MAX_VALUE);

    // Act and Assert
    assertArrayEquals(
        new byte[] {'f', 'o', 'o', 0, -120, Byte.MAX_VALUE, -1, -1, -1, -1, -1, -1, -1},
        freqMapSerialiser.serialise(map));
  }

  /**
   * Test {@link FreqMapSerialiser#serialise(FreqMap)} with {@code FreqMap}.
   *
   * <ul>
   *   <li>Given {@link Long#MIN_VALUE}.
   *   <li>When {@link FreqMap#FreqMap()} {@code foo} is {@link Long#MIN_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link FreqMapSerialiser#serialise(FreqMap)}
   */
  @Test
  @DisplayName(
      "Test serialise(FreqMap) with 'FreqMap'; given MIN_VALUE; when FreqMap() 'foo' is MIN_VALUE")
  @Tag("MaintainedByDiffblue")
  void testSerialiseWithFreqMap_givenMin_value_whenFreqMapFooIsMin_value()
      throws SerialisationException {
    // Arrange
    FreqMapSerialiser freqMapSerialiser = new FreqMapSerialiser();

    FreqMap map = new FreqMap();
    map.put("foo", Long.MIN_VALUE);

    // Act and Assert
    assertArrayEquals(
        new byte[] {'f', 'o', 'o', 0, Byte.MIN_VALUE, Byte.MAX_VALUE, -1, -1, -1, -1, -1, -1, -1},
        freqMapSerialiser.serialise(map));
  }

  /**
   * Test {@link FreqMapSerialiser#serialise(FreqMap)} with {@code FreqMap}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>When {@link FreqMap#FreqMap()} {@code foo} is one.
   * </ul>
   *
   * <p>Method under test: {@link FreqMapSerialiser#serialise(FreqMap)}
   */
  @Test
  @DisplayName("Test serialise(FreqMap) with 'FreqMap'; given one; when FreqMap() 'foo' is one")
  @Tag("MaintainedByDiffblue")
  void testSerialiseWithFreqMap_givenOne_whenFreqMapFooIsOne() throws SerialisationException {
    // Arrange
    FreqMapSerialiser freqMapSerialiser = new FreqMapSerialiser();

    FreqMap map = new FreqMap();
    map.put("foo", 1L);

    // Act and Assert
    assertArrayEquals(new byte[] {'f', 'o', 'o', 0, 1, 2}, freqMapSerialiser.serialise(map));
  }

  /**
   * Test {@link FreqMapSerialiser#serialise(FreqMap)} with {@code FreqMap}.
   *
   * <ul>
   *   <li>Given zero.
   *   <li>When {@link FreqMap#FreqMap()} {@code foo} is zero.
   * </ul>
   *
   * <p>Method under test: {@link FreqMapSerialiser#serialise(FreqMap)}
   */
  @Test
  @DisplayName("Test serialise(FreqMap) with 'FreqMap'; given zero; when FreqMap() 'foo' is zero")
  @Tag("MaintainedByDiffblue")
  void testSerialiseWithFreqMap_givenZero_whenFreqMapFooIsZero() throws SerialisationException {
    // Arrange
    FreqMapSerialiser freqMapSerialiser = new FreqMapSerialiser();

    FreqMap map = new FreqMap();
    map.put("foo", 0L);

    // Act and Assert
    assertArrayEquals(new byte[] {'f', 'o', 'o', 0, 1, 1}, freqMapSerialiser.serialise(map));
  }

  /**
   * Test {@link FreqMapSerialiser#serialise(FreqMap)} with {@code FreqMap}.
   *
   * <ul>
   *   <li>When {@link FreqMap#FreqMap()}.
   *   <li>Then return empty array of {@code byte}.
   * </ul>
   *
   * <p>Method under test: {@link FreqMapSerialiser#serialise(FreqMap)}
   */
  @Test
  @DisplayName(
      "Test serialise(FreqMap) with 'FreqMap'; when FreqMap(); then return empty array of byte")
  @Tag("MaintainedByDiffblue")
  void testSerialiseWithFreqMap_whenFreqMap_thenReturnEmptyArrayOfByte()
      throws SerialisationException {
    // Arrange
    FreqMapSerialiser freqMapSerialiser = new FreqMapSerialiser();

    // Act and Assert
    assertArrayEquals(new byte[] {}, freqMapSerialiser.serialise(new FreqMap()));
  }

  /**
   * Test {@link FreqMapSerialiser#deserialise(byte[])} with {@code bytes}.
   *
   * <ul>
   *   <li>Then return {@code A} longValue is sixty-five.
   * </ul>
   *
   * <p>Method under test: {@link FreqMapSerialiser#deserialise(byte[])}
   */
  @Test
  @DisplayName("Test deserialise(byte[]) with 'bytes'; then return 'A' longValue is sixty-five")
  @Tag("MaintainedByDiffblue")
  void testDeserialiseWithBytes_thenReturnALongValueIsSixtyFive() throws SerialisationException {
    // Arrange and Act
    FreqMap actualDeserialiseResult =
        new FreqMapSerialiser().deserialise(new byte[] {'A', 0, 'A', 'X', 'A', 'X', 'A', 'X'});

    // Assert
    assertEquals(1, actualDeserialiseResult.size());
    assertEquals(65L, actualDeserialiseResult.get("A").longValue());
  }

  /**
   * Test {@link FreqMapSerialiser#deserialise(byte[])} with {@code bytes}.
   *
   * <ul>
   *   <li>Then return empty string longValue is eighty-eight.
   * </ul>
   *
   * <p>Method under test: {@link FreqMapSerialiser#deserialise(byte[])}
   */
  @Test
  @DisplayName(
      "Test deserialise(byte[]) with 'bytes'; then return empty string longValue is eighty-eight")
  @Tag("MaintainedByDiffblue")
  void testDeserialiseWithBytes_thenReturnEmptyStringLongValueIsEightyEight()
      throws SerialisationException {
    // Arrange and Act
    FreqMap actualDeserialiseResult =
        new FreqMapSerialiser().deserialise(new byte[] {0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Assert
    assertEquals(1, actualDeserialiseResult.size());
    assertEquals(88L, actualDeserialiseResult.get("").longValue());
  }

  /**
   * Test {@link FreqMapSerialiser#deserialise(byte[])} with {@code bytes}.
   *
   * <ul>
   *   <li>Then return empty string longValue is eighty-eight.
   * </ul>
   *
   * <p>Method under test: {@link FreqMapSerialiser#deserialise(byte[])}
   */
  @Test
  @DisplayName(
      "Test deserialise(byte[]) with 'bytes'; then return empty string longValue is eighty-eight")
  @Tag("MaintainedByDiffblue")
  void testDeserialiseWithBytes_thenReturnEmptyStringLongValueIsEightyEight2()
      throws SerialisationException {
    // Arrange and Act
    FreqMap actualDeserialiseResult =
        new FreqMapSerialiser().deserialise(new byte[] {0, 'X', 0, 'X', 'A', 'X', 'A', 'X'});

    // Assert
    assertEquals(1, actualDeserialiseResult.size());
    assertEquals(88L, actualDeserialiseResult.get("").longValue());
  }

  /**
   * Test {@link FreqMapSerialiser#deserialise(byte[])} with {@code bytes}.
   *
   * <ul>
   *   <li>Then return empty string longValue is one.
   * </ul>
   *
   * <p>Method under test: {@link FreqMapSerialiser#deserialise(byte[])}
   */
  @Test
  @DisplayName("Test deserialise(byte[]) with 'bytes'; then return empty string longValue is one")
  @Tag("MaintainedByDiffblue")
  void testDeserialiseWithBytes_thenReturnEmptyStringLongValueIsOne()
      throws SerialisationException {
    // Arrange and Act
    FreqMap actualDeserialiseResult =
        new FreqMapSerialiser().deserialise(new byte[] {0, 1, 2, 'X', 'A', 'X', 'A', 'X'});

    // Assert
    assertEquals(1, actualDeserialiseResult.size());
    assertEquals(1L, actualDeserialiseResult.get("").longValue());
  }

  /**
   * Test {@link FreqMapSerialiser#deserialise(byte[])} with {@code bytes}.
   *
   * <ul>
   *   <li>Then return empty string longValue is sixty-five.
   * </ul>
   *
   * <p>Method under test: {@link FreqMapSerialiser#deserialise(byte[])}
   */
  @Test
  @DisplayName(
      "Test deserialise(byte[]) with 'bytes'; then return empty string longValue is sixty-five")
  @Tag("MaintainedByDiffblue")
  void testDeserialiseWithBytes_thenReturnEmptyStringLongValueIsSixtyFive()
      throws SerialisationException {
    // Arrange and Act
    FreqMap actualDeserialiseResult =
        new FreqMapSerialiser().deserialise(new byte[] {0, 1, 'A', 'X', 'A', 'X', 'A', 'X'});

    // Assert
    assertEquals(1, actualDeserialiseResult.size());
    assertEquals(65L, actualDeserialiseResult.get("").longValue());
  }

  /**
   * Test {@link FreqMapSerialiser#deserialise(byte[])} with {@code bytes}.
   *
   * <ul>
   *   <li>Then return empty string longValue is zero.
   * </ul>
   *
   * <p>Method under test: {@link FreqMapSerialiser#deserialise(byte[])}
   */
  @Test
  @DisplayName("Test deserialise(byte[]) with 'bytes'; then return empty string longValue is zero")
  @Tag("MaintainedByDiffblue")
  void testDeserialiseWithBytes_thenReturnEmptyStringLongValueIsZero()
      throws SerialisationException {
    // Arrange and Act
    FreqMap actualDeserialiseResult =
        new FreqMapSerialiser().deserialise(new byte[] {0, 1, 1, 'X', 'A', 'X', 'A', 'X'});

    // Assert
    assertEquals(1, actualDeserialiseResult.size());
    assertEquals(0L, actualDeserialiseResult.get("").longValue());
  }

  /**
   * Test {@link FreqMapSerialiser#deserialise(byte[])} with {@code bytes}.
   *
   * <ul>
   *   <li>When array of {@code byte} with zero and zero.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link FreqMapSerialiser#deserialise(byte[])}
   */
  @Test
  @DisplayName(
      "Test deserialise(byte[]) with 'bytes'; when array of byte with zero and zero; then return Empty")
  @Tag("MaintainedByDiffblue")
  void testDeserialiseWithBytes_whenArrayOfByteWithZeroAndZero_thenReturnEmpty()
      throws SerialisationException {
    // Arrange, Act and Assert
    assertTrue(
        new FreqMapSerialiser()
            .deserialise(new byte[] {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0})
            .isEmpty());
  }

  /**
   * Test {@link FreqMapSerialiser#deserialise(byte[])} with {@code bytes}.
   *
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link FreqMapSerialiser#deserialise(byte[])}
   */
  @Test
  @DisplayName(
      "Test deserialise(byte[]) with 'bytes'; when 'AXAXAXAX' Bytes is 'UTF-8'; then return Empty")
  @Tag("MaintainedByDiffblue")
  void testDeserialiseWithBytes_whenAxaxaxaxBytesIsUtf8_thenReturnEmpty()
      throws UnsupportedEncodingException, SerialisationException {
    // Arrange, Act and Assert
    assertTrue(new FreqMapSerialiser().deserialise("AXAXAXAX".getBytes("UTF-8")).isEmpty());
  }

  /**
   * Test {@link FreqMapSerialiser#deserialise(byte[])} with {@code bytes}.
   *
   * <ul>
   *   <li>When empty array of {@code byte}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link FreqMapSerialiser#deserialise(byte[])}
   */
  @Test
  @DisplayName("Test deserialise(byte[]) with 'bytes'; when empty array of byte; then return Empty")
  @Tag("MaintainedByDiffblue")
  void testDeserialiseWithBytes_whenEmptyArrayOfByte_thenReturnEmpty()
      throws SerialisationException {
    // Arrange, Act and Assert
    assertTrue(new FreqMapSerialiser().deserialise(new byte[] {}).isEmpty());
  }

  /**
   * Test {@link FreqMapSerialiser#canHandle(Class)}.
   *
   * <ul>
   *   <li>When {@code Object}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link FreqMapSerialiser#canHandle(Class)}
   */
  @Test
  @DisplayName("Test canHandle(Class); when 'java.lang.Object'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  void testCanHandle_whenJavaLangObject_thenReturnFalse() {
    // Arrange
    FreqMapSerialiser freqMapSerialiser = new FreqMapSerialiser();
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertFalse(freqMapSerialiser.canHandle(clazz));
  }

  /**
   * Test {@link FreqMapSerialiser#canHandle(Class)}.
   *
   * <ul>
   *   <li>When {@code FreqMap}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link FreqMapSerialiser#canHandle(Class)}
   */
  @Test
  @DisplayName("Test canHandle(Class); when 'uk.gov.gchq.gaffer.types.FreqMap'; then return 'true'")
  @Tag("MaintainedByDiffblue")
  void testCanHandle_whenUkGovGchqGafferTypesFreqMap_thenReturnTrue() {
    // Arrange
    FreqMapSerialiser freqMapSerialiser = new FreqMapSerialiser();
    Class<FreqMap> clazz = FreqMap.class;

    // Act and Assert
    assertTrue(freqMapSerialiser.canHandle(clazz));
  }

  /**
   * Test {@link FreqMapSerialiser#preservesObjectOrdering()}.
   *
   * <p>Method under test: {@link FreqMapSerialiser#preservesObjectOrdering()}
   */
  @Test
  @DisplayName("Test preservesObjectOrdering()")
  @Tag("MaintainedByDiffblue")
  void testPreservesObjectOrdering() {
    // Arrange, Act and Assert
    assertFalse(new FreqMapSerialiser().preservesObjectOrdering());
  }

  /**
   * Test {@link FreqMapSerialiser#isConsistent()}.
   *
   * <p>Method under test: {@link FreqMapSerialiser#isConsistent()}
   */
  @Test
  @DisplayName("Test isConsistent()")
  @Tag("MaintainedByDiffblue")
  void testIsConsistent() {
    // Arrange, Act and Assert
    assertFalse(new FreqMapSerialiser().isConsistent());
  }

  /**
   * Test {@link FreqMapSerialiser#deserialiseEmpty()}.
   *
   * <p>Method under test: {@link FreqMapSerialiser#deserialiseEmpty()}
   */
  @Test
  @DisplayName("Test deserialiseEmpty()")
  @Tag("MaintainedByDiffblue")
  void testDeserialiseEmpty() {
    // Arrange, Act and Assert
    assertTrue(new FreqMapSerialiser().deserialiseEmpty().isEmpty());
  }

  /**
   * Test {@link FreqMapSerialiser#equals(Object)}, and {@link FreqMapSerialiser#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link FreqMapSerialiser#equals(Object)}
   *   <li>{@link FreqMapSerialiser#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    FreqMapSerialiser freqMapSerialiser = new FreqMapSerialiser();
    FreqMapSerialiser freqMapSerialiser2 = new FreqMapSerialiser();

    // Act and Assert
    assertEquals(freqMapSerialiser, freqMapSerialiser2);
    assertEquals(freqMapSerialiser.hashCode(), freqMapSerialiser2.hashCode());
  }

  /**
   * Test {@link FreqMapSerialiser#equals(Object)}, and {@link FreqMapSerialiser#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link FreqMapSerialiser#equals(Object)}
   *   <li>{@link FreqMapSerialiser#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    FreqMapSerialiser freqMapSerialiser = new FreqMapSerialiser();

    // Act and Assert
    assertEquals(freqMapSerialiser, freqMapSerialiser);
    int expectedHashCodeResult = freqMapSerialiser.hashCode();
    assertEquals(expectedHashCodeResult, freqMapSerialiser.hashCode());
  }

  /**
   * Test {@link FreqMapSerialiser#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link FreqMapSerialiser#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new FreqMapSerialiser(), 1);
  }

  /**
   * Test {@link FreqMapSerialiser#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link FreqMapSerialiser#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new FreqMapSerialiser(), null);
  }

  /**
   * Test {@link FreqMapSerialiser#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link FreqMapSerialiser#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new FreqMapSerialiser(), "Different type to FreqMapSerialiser");
  }

  /**
   * Test new {@link FreqMapSerialiser} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link FreqMapSerialiser}
   */
  @Test
  @DisplayName("Test new FreqMapSerialiser (default constructor)")
  @Tag("MaintainedByDiffblue")
  void testNewFreqMapSerialiser() {
    // Arrange, Act and Assert
    assertFalse(new FreqMapSerialiser().isConsistent());
  }
}
