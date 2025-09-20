package uk.gov.gchq.gaffer.serialisation.implementation.ordered;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.io.UnsupportedEncodingException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.exception.SerialisationException;

class OrderedLongSerialiserDiffblueTest {
  /**
   * Test {@link OrderedLongSerialiser#serialise(Long)} with {@code Long}.
   *
   * <ul>
   *   <li>Then return array of {@code byte} with backspace and {@link Byte#MAX_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link OrderedLongSerialiser#serialise(Long)}
   */
  @Test
  @DisplayName(
      "Test serialise(Long) with 'Long'; then return array of byte with backspace and MAX_VALUE")
  @Tag("MaintainedByDiffblue")
  void testSerialiseWithLong_thenReturnArrayOfByteWithBackspaceAndMax_value() {
    // Arrange, Act and Assert
    assertArrayEquals(
        new byte[] {'\b', Byte.MAX_VALUE, -1, -1, -1, -1, -1, -1, -1},
        new OrderedLongSerialiser().serialise(-1L));
  }

  /**
   * Test {@link OrderedLongSerialiser#serialise(Long)} with {@code Long}.
   *
   * <ul>
   *   <li>When {@link Long#MAX_VALUE}.
   *   <li>Then return array of {@code byte} with sixteen.
   * </ul>
   *
   * <p>Method under test: {@link OrderedLongSerialiser#serialise(Long)}
   */
  @Test
  @DisplayName(
      "Test serialise(Long) with 'Long'; when MAX_VALUE; then return array of byte with sixteen")
  @Tag("MaintainedByDiffblue")
  void testSerialiseWithLong_whenMax_value_thenReturnArrayOfByteWithSixteen() {
    // Arrange, Act and Assert
    assertArrayEquals(new byte[] {16}, new OrderedLongSerialiser().serialise(Long.MAX_VALUE));
  }

  /**
   * Test {@link OrderedLongSerialiser#serialise(Long)} with {@code Long}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then return array of {@code byte} with backspace and {@link Byte#MIN_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link OrderedLongSerialiser#serialise(Long)}
   */
  @Test
  @DisplayName(
      "Test serialise(Long) with 'Long'; when one; then return array of byte with backspace and MIN_VALUE")
  @Tag("MaintainedByDiffblue")
  void testSerialiseWithLong_whenOne_thenReturnArrayOfByteWithBackspaceAndMin_value() {
    // Arrange, Act and Assert
    assertArrayEquals(
        new byte[] {'\b', Byte.MIN_VALUE, 0, 0, 0, 0, 0, 0, 1},
        new OrderedLongSerialiser().serialise(1L));
  }

  /**
   * Test {@link OrderedLongSerialiser#deserialise(byte[])} with {@code bytes}.
   *
   * <ul>
   *   <li>When {@code A}.
   *   <li>Then return longValue is {@link Long#MAX_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link OrderedLongSerialiser#deserialise(byte[])}
   */
  @Test
  @DisplayName(
      "Test deserialise(byte[]) with 'bytes'; when 'A'; then return longValue is MAX_VALUE")
  @Tag("MaintainedByDiffblue")
  void testDeserialiseWithBytes_whenA_thenReturnLongValueIsMax_value()
      throws SerialisationException {
    // Arrange, Act and Assert
    assertEquals(
        Long.MAX_VALUE,
        new OrderedLongSerialiser()
            .deserialise(new byte[] {16, 'X', 'A', 'X', 'A', 'X', 'A', 'X'})
            .longValue());
  }

  /**
   * Test {@link OrderedLongSerialiser#deserialise(byte[])} with {@code bytes}.
   *
   * <ul>
   *   <li>When array of {@code byte} with minus one.
   * </ul>
   *
   * <p>Method under test: {@link OrderedLongSerialiser#deserialise(byte[])}
   */
  @Test
  @DisplayName("Test deserialise(byte[]) with 'bytes'; when array of byte with minus one")
  @Tag("MaintainedByDiffblue")
  void testDeserialiseWithBytes_whenArrayOfByteWithMinusOne() throws SerialisationException {
    // Arrange, Act and Assert
    assertThrows(
        SerialisationException.class,
        () -> new OrderedLongSerialiser().deserialise(new byte[] {-1}));
  }

  /**
   * Test {@link OrderedLongSerialiser#deserialise(byte[])} with {@code bytes}.
   *
   * <ul>
   *   <li>When array of {@code byte} with sixteen.
   * </ul>
   *
   * <p>Method under test: {@link OrderedLongSerialiser#deserialise(byte[])}
   */
  @Test
  @DisplayName("Test deserialise(byte[]) with 'bytes'; when array of byte with sixteen")
  @Tag("MaintainedByDiffblue")
  void testDeserialiseWithBytes_whenArrayOfByteWithSixteen() throws SerialisationException {
    // Arrange, Act and Assert
    assertEquals(
        Long.MAX_VALUE, new OrderedLongSerialiser().deserialise(new byte[] {16}).longValue());
  }

  /**
   * Test {@link OrderedLongSerialiser#deserialise(byte[])} with {@code bytes}.
   *
   * <ul>
   *   <li>When array of {@code byte} with zero.
   *   <li>Then return longValue is {@link Long#MIN_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link OrderedLongSerialiser#deserialise(byte[])}
   */
  @Test
  @DisplayName(
      "Test deserialise(byte[]) with 'bytes'; when array of byte with zero; then return longValue is MIN_VALUE")
  @Tag("MaintainedByDiffblue")
  void testDeserialiseWithBytes_whenArrayOfByteWithZero_thenReturnLongValueIsMin_value()
      throws SerialisationException {
    // Arrange, Act and Assert
    assertEquals(
        Long.MIN_VALUE, new OrderedLongSerialiser().deserialise(new byte[] {0}).longValue());
  }

  /**
   * Test {@link OrderedLongSerialiser#deserialise(byte[])} with {@code bytes}.
   *
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.
   *   <li>Then throw {@link SerialisationException}.
   * </ul>
   *
   * <p>Method under test: {@link OrderedLongSerialiser#deserialise(byte[])}
   */
  @Test
  @DisplayName(
      "Test deserialise(byte[]) with 'bytes'; when 'AXAXAXAX' Bytes is 'UTF-8'; then throw SerialisationException")
  @Tag("MaintainedByDiffblue")
  void testDeserialiseWithBytes_whenAxaxaxaxBytesIsUtf8_thenThrowSerialisationException()
      throws UnsupportedEncodingException, SerialisationException {
    // Arrange, Act and Assert
    assertThrows(
        SerialisationException.class,
        () -> new OrderedLongSerialiser().deserialise("AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link OrderedLongSerialiser#canHandle(Class)}.
   *
   * <ul>
   *   <li>When {@code Long}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link OrderedLongSerialiser#canHandle(Class)}
   */
  @Test
  @DisplayName("Test canHandle(Class); when 'java.lang.Long'; then return 'true'")
  @Tag("MaintainedByDiffblue")
  void testCanHandle_whenJavaLangLong_thenReturnTrue() {
    // Arrange
    OrderedLongSerialiser orderedLongSerialiser = new OrderedLongSerialiser();
    Class<Long> clazz = Long.class;

    // Act and Assert
    assertTrue(orderedLongSerialiser.canHandle(clazz));
  }

  /**
   * Test {@link OrderedLongSerialiser#canHandle(Class)}.
   *
   * <ul>
   *   <li>When {@code Object}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link OrderedLongSerialiser#canHandle(Class)}
   */
  @Test
  @DisplayName("Test canHandle(Class); when 'java.lang.Object'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  void testCanHandle_whenJavaLangObject_thenReturnFalse() {
    // Arrange
    OrderedLongSerialiser orderedLongSerialiser = new OrderedLongSerialiser();
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertFalse(orderedLongSerialiser.canHandle(clazz));
  }

  /**
   * Test {@link OrderedLongSerialiser#deserialiseEmpty()}.
   *
   * <p>Method under test: {@link OrderedLongSerialiser#deserialiseEmpty()}
   */
  @Test
  @DisplayName("Test deserialiseEmpty()")
  @Tag("MaintainedByDiffblue")
  void testDeserialiseEmpty() {
    // Arrange, Act and Assert
    assertNull(new OrderedLongSerialiser().deserialiseEmpty());
  }

  /**
   * Test {@link OrderedLongSerialiser#preservesObjectOrdering()}.
   *
   * <p>Method under test: {@link OrderedLongSerialiser#preservesObjectOrdering()}
   */
  @Test
  @DisplayName("Test preservesObjectOrdering()")
  @Tag("MaintainedByDiffblue")
  void testPreservesObjectOrdering() {
    // Arrange, Act and Assert
    assertTrue(new OrderedLongSerialiser().preservesObjectOrdering());
  }

  /**
   * Test {@link OrderedLongSerialiser#equals(Object)}, and {@link
   * OrderedLongSerialiser#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link OrderedLongSerialiser#equals(Object)}
   *   <li>{@link OrderedLongSerialiser#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    OrderedLongSerialiser orderedLongSerialiser = new OrderedLongSerialiser();
    OrderedLongSerialiser orderedLongSerialiser2 = new OrderedLongSerialiser();

    // Act and Assert
    assertEquals(orderedLongSerialiser, orderedLongSerialiser2);
    assertEquals(orderedLongSerialiser.hashCode(), orderedLongSerialiser2.hashCode());
  }

  /**
   * Test {@link OrderedLongSerialiser#equals(Object)}, and {@link
   * OrderedLongSerialiser#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link OrderedLongSerialiser#equals(Object)}
   *   <li>{@link OrderedLongSerialiser#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    OrderedLongSerialiser orderedLongSerialiser = new OrderedLongSerialiser();

    // Act and Assert
    assertEquals(orderedLongSerialiser, orderedLongSerialiser);
    int expectedHashCodeResult = orderedLongSerialiser.hashCode();
    assertEquals(expectedHashCodeResult, orderedLongSerialiser.hashCode());
  }

  /**
   * Test {@link OrderedLongSerialiser#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OrderedLongSerialiser#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new OrderedLongSerialiser(), 1);
  }

  /**
   * Test {@link OrderedLongSerialiser#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OrderedLongSerialiser#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new OrderedLongSerialiser(), null);
  }

  /**
   * Test {@link OrderedLongSerialiser#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OrderedLongSerialiser#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new OrderedLongSerialiser(), "Different type to OrderedLongSerialiser");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link OrderedLongSerialiser}
   *   <li>{@link OrderedLongSerialiser#isConsistent()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertTrue(new OrderedLongSerialiser().isConsistent());
  }
}
