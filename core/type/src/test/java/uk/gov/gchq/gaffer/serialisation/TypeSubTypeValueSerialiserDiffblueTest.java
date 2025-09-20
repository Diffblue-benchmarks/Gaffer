package uk.gov.gchq.gaffer.serialisation;

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
import uk.gov.gchq.gaffer.types.TypeSubTypeValue;

class TypeSubTypeValueSerialiserDiffblueTest {
  /**
   * Test {@link TypeSubTypeValueSerialiser#canHandle(Class)}.
   *
   * <ul>
   *   <li>When {@code Object}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link TypeSubTypeValueSerialiser#canHandle(Class)}
   */
  @Test
  @DisplayName("Test canHandle(Class); when 'java.lang.Object'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  void testCanHandle_whenJavaLangObject_thenReturnFalse() {
    // Arrange
    TypeSubTypeValueSerialiser typeSubTypeValueSerialiser = new TypeSubTypeValueSerialiser();
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertFalse(typeSubTypeValueSerialiser.canHandle(clazz));
  }

  /**
   * Test {@link TypeSubTypeValueSerialiser#canHandle(Class)}.
   *
   * <ul>
   *   <li>When {@code TypeSubTypeValue}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link TypeSubTypeValueSerialiser#canHandle(Class)}
   */
  @Test
  @DisplayName(
      "Test canHandle(Class); when 'uk.gov.gchq.gaffer.types.TypeSubTypeValue'; then return 'true'")
  @Tag("MaintainedByDiffblue")
  void testCanHandle_whenUkGovGchqGafferTypesTypeSubTypeValue_thenReturnTrue() {
    // Arrange
    TypeSubTypeValueSerialiser typeSubTypeValueSerialiser = new TypeSubTypeValueSerialiser();
    Class<TypeSubTypeValue> clazz = TypeSubTypeValue.class;

    // Act and Assert
    assertTrue(typeSubTypeValueSerialiser.canHandle(clazz));
  }

  /**
   * Test {@link TypeSubTypeValueSerialiser#serialise(TypeSubTypeValue)} with {@code
   * TypeSubTypeValue}.
   *
   * <p>Method under test: {@link TypeSubTypeValueSerialiser#serialise(TypeSubTypeValue)}
   */
  @Test
  @DisplayName("Test serialise(TypeSubTypeValue) with 'TypeSubTypeValue'")
  @Tag("MaintainedByDiffblue")
  void testSerialiseWithTypeSubTypeValue() throws SerialisationException {
    // Arrange
    TypeSubTypeValueSerialiser typeSubTypeValueSerialiser = new TypeSubTypeValueSerialiser();
    TypeSubTypeValue typeSubTypeValue = new TypeSubTypeValue("Type", "Sub Type", "42");

    // Act
    byte[] actualSerialiseResult = typeSubTypeValueSerialiser.serialise(typeSubTypeValue);

    // Assert
    assertArrayEquals(
        new byte[] {'T', 'y', 'p', 'e', 0, 'S', 'u', 'b', ' ', 'T', 'y', 'p', 'e', 0, '4', '2'},
        actualSerialiseResult);
  }

  /**
   * Test {@link TypeSubTypeValueSerialiser#serialise(TypeSubTypeValue)} with {@code
   * TypeSubTypeValue}.
   *
   * <p>Method under test: {@link TypeSubTypeValueSerialiser#serialise(TypeSubTypeValue)}
   */
  @Test
  @DisplayName("Test serialise(TypeSubTypeValue) with 'TypeSubTypeValue'")
  @Tag("MaintainedByDiffblue")
  void testSerialiseWithTypeSubTypeValue2() throws SerialisationException {
    // Arrange
    TypeSubTypeValueSerialiser typeSubTypeValueSerialiser = new TypeSubTypeValueSerialiser();
    TypeSubTypeValue typeSubTypeValue = new TypeSubTypeValue("", "", "42");

    // Act
    byte[] actualSerialiseResult = typeSubTypeValueSerialiser.serialise(typeSubTypeValue);

    // Assert
    assertArrayEquals(new byte[] {0, 0, '4', '2'}, actualSerialiseResult);
  }

  /**
   * Test {@link TypeSubTypeValueSerialiser#serialise(TypeSubTypeValue)} with {@code
   * TypeSubTypeValue}.
   *
   * <p>Method under test: {@link TypeSubTypeValueSerialiser#serialise(TypeSubTypeValue)}
   */
  @Test
  @DisplayName("Test serialise(TypeSubTypeValue) with 'TypeSubTypeValue'")
  @Tag("MaintainedByDiffblue")
  void testSerialiseWithTypeSubTypeValue3() throws SerialisationException {
    // Arrange
    TypeSubTypeValueSerialiser typeSubTypeValueSerialiser = new TypeSubTypeValueSerialiser();
    TypeSubTypeValue typeSubTypeValue = new TypeSubTypeValue("", "", "");

    // Act and Assert
    assertThrows(
        SerialisationException.class, () -> typeSubTypeValueSerialiser.serialise(typeSubTypeValue));
  }

  /**
   * Test {@link TypeSubTypeValueSerialiser#serialise(TypeSubTypeValue)} with {@code
   * TypeSubTypeValue}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link TypeSubTypeValue#TypeSubTypeValue()} Value is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link TypeSubTypeValueSerialiser#serialise(TypeSubTypeValue)}
   */
  @Test
  @DisplayName(
      "Test serialise(TypeSubTypeValue) with 'TypeSubTypeValue'; given '42'; when TypeSubTypeValue() Value is '42'")
  @Tag("MaintainedByDiffblue")
  void testSerialiseWithTypeSubTypeValue_given42_whenTypeSubTypeValueValueIs42()
      throws SerialisationException {
    // Arrange
    TypeSubTypeValueSerialiser typeSubTypeValueSerialiser = new TypeSubTypeValueSerialiser();

    TypeSubTypeValue typeSubTypeValue = new TypeSubTypeValue();
    typeSubTypeValue.setValue("42");

    // Act and Assert
    assertArrayEquals(
        new byte[] {0, 0, '4', '2'}, typeSubTypeValueSerialiser.serialise(typeSubTypeValue));
  }

  /**
   * Test {@link TypeSubTypeValueSerialiser#serialise(TypeSubTypeValue)} with {@code
   * TypeSubTypeValue}.
   *
   * <ul>
   *   <li>Given {@code TypeSubTypeValue passed to serialiser is blank}.
   * </ul>
   *
   * <p>Method under test: {@link TypeSubTypeValueSerialiser#serialise(TypeSubTypeValue)}
   */
  @Test
  @DisplayName(
      "Test serialise(TypeSubTypeValue) with 'TypeSubTypeValue'; given 'TypeSubTypeValue passed to serialiser is blank'")
  @Tag("MaintainedByDiffblue")
  void testSerialiseWithTypeSubTypeValue_givenTypeSubTypeValuePassedToSerialiserIsBlank()
      throws SerialisationException {
    // Arrange
    TypeSubTypeValueSerialiser typeSubTypeValueSerialiser = new TypeSubTypeValueSerialiser();

    TypeSubTypeValue typeSubTypeValue = new TypeSubTypeValue();
    typeSubTypeValue.setType("TypeSubTypeValue passed to serialiser is blank");

    // Act and Assert
    assertArrayEquals(
        new byte[] {
          'T', 'y', 'p', 'e', 'S', 'u', 'b', 'T', 'y', 'p', 'e', 'V', 'a', 'l', 'u', 'e', ' ', 'p',
          'a', 's', 's', 'e', 'd', ' ', 't', 'o', ' ', 's', 'e', 'r', 'i', 'a', 'l', 'i', 's', 'e',
          'r', ' ', 'i', 's', ' ', 'b', 'l', 'a', 'n', 'k', 0, 0
        },
        typeSubTypeValueSerialiser.serialise(typeSubTypeValue));
  }

  /**
   * Test {@link TypeSubTypeValueSerialiser#serialise(TypeSubTypeValue)} with {@code
   * TypeSubTypeValue}.
   *
   * <ul>
   *   <li>Then return array of {@code byte} with zero and {@code S}.
   * </ul>
   *
   * <p>Method under test: {@link TypeSubTypeValueSerialiser#serialise(TypeSubTypeValue)}
   */
  @Test
  @DisplayName(
      "Test serialise(TypeSubTypeValue) with 'TypeSubTypeValue'; then return array of byte with zero and 'S'")
  @Tag("MaintainedByDiffblue")
  void testSerialiseWithTypeSubTypeValue_thenReturnArrayOfByteWithZeroAndS()
      throws SerialisationException {
    // Arrange
    TypeSubTypeValueSerialiser typeSubTypeValueSerialiser = new TypeSubTypeValueSerialiser();
    TypeSubTypeValue typeSubTypeValue = new TypeSubTypeValue("", "Sub Type", "42");

    // Act
    byte[] actualSerialiseResult = typeSubTypeValueSerialiser.serialise(typeSubTypeValue);

    // Assert
    assertArrayEquals(
        new byte[] {0, 'S', 'u', 'b', ' ', 'T', 'y', 'p', 'e', 0, '4', '2'}, actualSerialiseResult);
  }

  /**
   * Test {@link TypeSubTypeValueSerialiser#serialise(TypeSubTypeValue)} with {@code
   * TypeSubTypeValue}.
   *
   * <ul>
   *   <li>When {@link TypeSubTypeValue#TypeSubTypeValue()}.
   * </ul>
   *
   * <p>Method under test: {@link TypeSubTypeValueSerialiser#serialise(TypeSubTypeValue)}
   */
  @Test
  @DisplayName("Test serialise(TypeSubTypeValue) with 'TypeSubTypeValue'; when TypeSubTypeValue()")
  @Tag("MaintainedByDiffblue")
  void testSerialiseWithTypeSubTypeValue_whenTypeSubTypeValue() throws SerialisationException {
    // Arrange
    TypeSubTypeValueSerialiser typeSubTypeValueSerialiser = new TypeSubTypeValueSerialiser();

    // Act and Assert
    assertThrows(
        SerialisationException.class,
        () -> typeSubTypeValueSerialiser.serialise(new TypeSubTypeValue()));
  }

  /**
   * Test {@link TypeSubTypeValueSerialiser#deserialise(byte[])} with {@code bytes}.
   *
   * <p>Method under test: {@link TypeSubTypeValueSerialiser#deserialise(byte[])}
   */
  @Test
  @DisplayName("Test deserialise(byte[]) with 'bytes'")
  @Tag("MaintainedByDiffblue")
  void testDeserialiseWithBytes() throws SerialisationException {
    // Arrange and Act
    TypeSubTypeValue actualDeserialiseResult =
        new TypeSubTypeValueSerialiser()
            .deserialise(new byte[] {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0});

    // Assert
    assertEquals(
        "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000",
        actualDeserialiseResult.getValue());
    assertNull(actualDeserialiseResult.getSubType());
    assertNull(actualDeserialiseResult.getType());
  }

  /**
   * Test {@link TypeSubTypeValueSerialiser#deserialise(byte[])} with {@code bytes}.
   *
   * <ul>
   *   <li>When array of {@code byte} with {@code A} and zero.
   *   <li>Then return SubType is {@code A}.
   * </ul>
   *
   * <p>Method under test: {@link TypeSubTypeValueSerialiser#deserialise(byte[])}
   */
  @Test
  @DisplayName(
      "Test deserialise(byte[]) with 'bytes'; when array of byte with 'A' and zero; then return SubType is 'A'")
  @Tag("MaintainedByDiffblue")
  void testDeserialiseWithBytes_whenArrayOfByteWithAAndZero_thenReturnSubTypeIsA()
      throws SerialisationException {
    // Arrange and Act
    TypeSubTypeValue actualDeserialiseResult =
        new TypeSubTypeValueSerialiser()
            .deserialise(new byte[] {'A', 0, 'A', 0, 'A', 'X', 'A', 'X'});

    // Assert
    assertEquals("A", actualDeserialiseResult.getSubType());
    assertEquals("A", actualDeserialiseResult.getType());
    assertEquals("AXAX", actualDeserialiseResult.getValue());
  }

  /**
   * Test {@link TypeSubTypeValueSerialiser#deserialise(byte[])} with {@code bytes}.
   *
   * <ul>
   *   <li>When array of {@code byte} with {@code A} and zero.
   *   <li>Then return Type is {@code A}.
   * </ul>
   *
   * <p>Method under test: {@link TypeSubTypeValueSerialiser#deserialise(byte[])}
   */
  @Test
  @DisplayName(
      "Test deserialise(byte[]) with 'bytes'; when array of byte with 'A' and zero; then return Type is 'A'")
  @Tag("MaintainedByDiffblue")
  void testDeserialiseWithBytes_whenArrayOfByteWithAAndZero_thenReturnTypeIsA()
      throws SerialisationException {
    // Arrange and Act
    TypeSubTypeValue actualDeserialiseResult =
        new TypeSubTypeValueSerialiser()
            .deserialise(new byte[] {'A', 0, 'A', 'X', 'A', 'X', 'A', 'X'});

    // Assert
    assertEquals("A", actualDeserialiseResult.getType());
    assertEquals("AXAXAX", actualDeserialiseResult.getValue());
    assertNull(actualDeserialiseResult.getSubType());
  }

  /**
   * Test {@link TypeSubTypeValueSerialiser#deserialise(byte[])} with {@code bytes}.
   *
   * <ul>
   *   <li>When array of {@code byte} with one and one.
   *   <li>Then return Value is {@code AXAXAX}.
   * </ul>
   *
   * <p>Method under test: {@link TypeSubTypeValueSerialiser#deserialise(byte[])}
   */
  @Test
  @DisplayName(
      "Test deserialise(byte[]) with 'bytes'; when array of byte with one and one; then return Value is 'AXAXAX'")
  @Tag("MaintainedByDiffblue")
  void testDeserialiseWithBytes_whenArrayOfByteWithOneAndOne_thenReturnValueIsAxaxax()
      throws SerialisationException {
    // Arrange and Act
    TypeSubTypeValue actualDeserialiseResult =
        new TypeSubTypeValueSerialiser()
            .deserialise(new byte[] {1, 1, 'A', 'X', 'A', 'X', 'A', 'X'});

    // Assert
    assertEquals("\u0000AXAXAX", actualDeserialiseResult.getValue());
    assertNull(actualDeserialiseResult.getSubType());
    assertNull(actualDeserialiseResult.getType());
  }

  /**
   * Test {@link TypeSubTypeValueSerialiser#deserialise(byte[])} with {@code bytes}.
   *
   * <ul>
   *   <li>When array of {@code byte} with one and two.
   *   <li>Then return Value is {@code AXAXAX}.
   * </ul>
   *
   * <p>Method under test: {@link TypeSubTypeValueSerialiser#deserialise(byte[])}
   */
  @Test
  @DisplayName(
      "Test deserialise(byte[]) with 'bytes'; when array of byte with one and two; then return Value is 'AXAXAX'")
  @Tag("MaintainedByDiffblue")
  void testDeserialiseWithBytes_whenArrayOfByteWithOneAndTwo_thenReturnValueIsAxaxax()
      throws SerialisationException {
    // Arrange and Act
    TypeSubTypeValue actualDeserialiseResult =
        new TypeSubTypeValueSerialiser()
            .deserialise(new byte[] {1, 2, 'A', 'X', 'A', 'X', 'A', 'X'});

    // Assert
    assertEquals("\u0001AXAXAX", actualDeserialiseResult.getValue());
    assertNull(actualDeserialiseResult.getSubType());
    assertNull(actualDeserialiseResult.getType());
  }

  /**
   * Test {@link TypeSubTypeValueSerialiser#deserialise(byte[])} with {@code bytes}.
   *
   * <ul>
   *   <li>When array of {@code byte} with one and {@code X}.
   *   <li>Then return Value is {@code XAXAXAX}.
   * </ul>
   *
   * <p>Method under test: {@link TypeSubTypeValueSerialiser#deserialise(byte[])}
   */
  @Test
  @DisplayName(
      "Test deserialise(byte[]) with 'bytes'; when array of byte with one and 'X'; then return Value is 'XAXAXAX'")
  @Tag("MaintainedByDiffblue")
  void testDeserialiseWithBytes_whenArrayOfByteWithOneAndX_thenReturnValueIsXaxaxax()
      throws SerialisationException {
    // Arrange and Act
    TypeSubTypeValue actualDeserialiseResult =
        new TypeSubTypeValueSerialiser()
            .deserialise(new byte[] {1, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Assert
    assertEquals("XAXAXAX", actualDeserialiseResult.getValue());
    assertNull(actualDeserialiseResult.getSubType());
    assertNull(actualDeserialiseResult.getType());
  }

  /**
   * Test {@link TypeSubTypeValueSerialiser#deserialise(byte[])} with {@code bytes}.
   *
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.
   *   <li>Then return Value is {@code AXAXAXAX}.
   * </ul>
   *
   * <p>Method under test: {@link TypeSubTypeValueSerialiser#deserialise(byte[])}
   */
  @Test
  @DisplayName(
      "Test deserialise(byte[]) with 'bytes'; when 'AXAXAXAX' Bytes is 'UTF-8'; then return Value is 'AXAXAXAX'")
  @Tag("MaintainedByDiffblue")
  void testDeserialiseWithBytes_whenAxaxaxaxBytesIsUtf8_thenReturnValueIsAxaxaxax()
      throws UnsupportedEncodingException, SerialisationException {
    // Arrange and Act
    TypeSubTypeValue actualDeserialiseResult =
        new TypeSubTypeValueSerialiser().deserialise("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertEquals("AXAXAXAX", actualDeserialiseResult.getValue());
    assertNull(actualDeserialiseResult.getSubType());
    assertNull(actualDeserialiseResult.getType());
  }

  /**
   * Test {@link TypeSubTypeValueSerialiser#deserialise(byte[])} with {@code bytes}.
   *
   * <ul>
   *   <li>When empty array of {@code byte}.
   *   <li>Then return Value is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link TypeSubTypeValueSerialiser#deserialise(byte[])}
   */
  @Test
  @DisplayName(
      "Test deserialise(byte[]) with 'bytes'; when empty array of byte; then return Value is 'null'")
  @Tag("MaintainedByDiffblue")
  void testDeserialiseWithBytes_whenEmptyArrayOfByte_thenReturnValueIsNull()
      throws SerialisationException {
    // Arrange and Act
    TypeSubTypeValue actualDeserialiseResult =
        new TypeSubTypeValueSerialiser().deserialise(new byte[] {});

    // Assert
    assertNull(actualDeserialiseResult.getSubType());
    assertNull(actualDeserialiseResult.getType());
    assertNull(actualDeserialiseResult.getValue());
  }

  /**
   * Test {@link TypeSubTypeValueSerialiser#preservesObjectOrdering()}.
   *
   * <p>Method under test: {@link TypeSubTypeValueSerialiser#preservesObjectOrdering()}
   */
  @Test
  @DisplayName("Test preservesObjectOrdering()")
  @Tag("MaintainedByDiffblue")
  void testPreservesObjectOrdering() {
    // Arrange, Act and Assert
    assertTrue(new TypeSubTypeValueSerialiser().preservesObjectOrdering());
  }

  /**
   * Test {@link TypeSubTypeValueSerialiser#deserialiseEmpty()}.
   *
   * <p>Method under test: {@link TypeSubTypeValueSerialiser#deserialiseEmpty()}
   */
  @Test
  @DisplayName("Test deserialiseEmpty()")
  @Tag("MaintainedByDiffblue")
  void testDeserialiseEmpty() {
    // Arrange and Act
    TypeSubTypeValue actualDeserialiseEmptyResult =
        new TypeSubTypeValueSerialiser().deserialiseEmpty();

    // Assert
    assertNull(actualDeserialiseEmptyResult.getSubType());
    assertNull(actualDeserialiseEmptyResult.getType());
    assertNull(actualDeserialiseEmptyResult.getValue());
  }

  /**
   * Test {@link TypeSubTypeValueSerialiser#equals(Object)}, and {@link
   * TypeSubTypeValueSerialiser#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TypeSubTypeValueSerialiser#equals(Object)}
   *   <li>{@link TypeSubTypeValueSerialiser#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    TypeSubTypeValueSerialiser typeSubTypeValueSerialiser = new TypeSubTypeValueSerialiser();
    TypeSubTypeValueSerialiser typeSubTypeValueSerialiser2 = new TypeSubTypeValueSerialiser();

    // Act and Assert
    assertEquals(typeSubTypeValueSerialiser, typeSubTypeValueSerialiser2);
    assertEquals(typeSubTypeValueSerialiser.hashCode(), typeSubTypeValueSerialiser2.hashCode());
  }

  /**
   * Test {@link TypeSubTypeValueSerialiser#equals(Object)}, and {@link
   * TypeSubTypeValueSerialiser#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TypeSubTypeValueSerialiser#equals(Object)}
   *   <li>{@link TypeSubTypeValueSerialiser#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    TypeSubTypeValueSerialiser typeSubTypeValueSerialiser = new TypeSubTypeValueSerialiser();

    // Act and Assert
    assertEquals(typeSubTypeValueSerialiser, typeSubTypeValueSerialiser);
    int expectedHashCodeResult = typeSubTypeValueSerialiser.hashCode();
    assertEquals(expectedHashCodeResult, typeSubTypeValueSerialiser.hashCode());
  }

  /**
   * Test {@link TypeSubTypeValueSerialiser#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TypeSubTypeValueSerialiser#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TypeSubTypeValueSerialiser(), 1);
  }

  /**
   * Test {@link TypeSubTypeValueSerialiser#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TypeSubTypeValueSerialiser#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TypeSubTypeValueSerialiser(), null);
  }

  /**
   * Test {@link TypeSubTypeValueSerialiser#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TypeSubTypeValueSerialiser#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        new TypeSubTypeValueSerialiser(), "Different type to TypeSubTypeValueSerialiser");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link TypeSubTypeValueSerialiser}
   *   <li>{@link TypeSubTypeValueSerialiser#isConsistent()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertTrue(new TypeSubTypeValueSerialiser().isConsistent());
  }
}
