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
import uk.gov.gchq.gaffer.types.TypeValue;

class TypeValueSerialiserDiffblueTest {
  /**
   * Test {@link TypeValueSerialiser#canHandle(Class)}.
   *
   * <ul>
   *   <li>When {@code Object}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link TypeValueSerialiser#canHandle(Class)}
   */
  @Test
  @DisplayName("Test canHandle(Class); when 'java.lang.Object'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  void testCanHandle_whenJavaLangObject_thenReturnFalse() {
    // Arrange
    TypeValueSerialiser typeValueSerialiser = new TypeValueSerialiser();
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertFalse(typeValueSerialiser.canHandle(clazz));
  }

  /**
   * Test {@link TypeValueSerialiser#canHandle(Class)}.
   *
   * <ul>
   *   <li>When {@code TypeValue}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link TypeValueSerialiser#canHandle(Class)}
   */
  @Test
  @DisplayName(
      "Test canHandle(Class); when 'uk.gov.gchq.gaffer.types.TypeValue'; then return 'true'")
  @Tag("MaintainedByDiffblue")
  void testCanHandle_whenUkGovGchqGafferTypesTypeValue_thenReturnTrue() {
    // Arrange
    TypeValueSerialiser typeValueSerialiser = new TypeValueSerialiser();
    Class<TypeValue> clazz = TypeValue.class;

    // Act and Assert
    assertTrue(typeValueSerialiser.canHandle(clazz));
  }

  /**
   * Test {@link TypeValueSerialiser#serialise(TypeValue)} with {@code TypeValue}.
   *
   * <ul>
   *   <li>Then return array of {@code byte} with zero and {@code 4}.
   * </ul>
   *
   * <p>Method under test: {@link TypeValueSerialiser#serialise(TypeValue)}
   */
  @Test
  @DisplayName(
      "Test serialise(TypeValue) with 'TypeValue'; then return array of byte with zero and '4'")
  @Tag("MaintainedByDiffblue")
  void testSerialiseWithTypeValue_thenReturnArrayOfByteWithZeroAnd4()
      throws SerialisationException {
    // Arrange
    TypeValueSerialiser typeValueSerialiser = new TypeValueSerialiser();

    // Act
    byte[] actualSerialiseResult = typeValueSerialiser.serialise(new TypeValue(null, "42"));

    // Assert
    assertArrayEquals(new byte[] {0, '4', '2'}, actualSerialiseResult);
  }

  /**
   * Test {@link TypeValueSerialiser#serialise(TypeValue)} with {@code TypeValue}.
   *
   * <ul>
   *   <li>When {@link TypeValue#TypeValue(String, String)} with {@code Type} and value is {@code
   *       42}.
   * </ul>
   *
   * <p>Method under test: {@link TypeValueSerialiser#serialise(TypeValue)}
   */
  @Test
  @DisplayName(
      "Test serialise(TypeValue) with 'TypeValue'; when TypeValue(String, String) with 'Type' and value is '42'")
  @Tag("MaintainedByDiffblue")
  void testSerialiseWithTypeValue_whenTypeValueWithTypeAndValueIs42()
      throws SerialisationException {
    // Arrange
    TypeValueSerialiser typeValueSerialiser = new TypeValueSerialiser();

    // Act
    byte[] actualSerialiseResult = typeValueSerialiser.serialise(new TypeValue("Type", "42"));

    // Assert
    assertArrayEquals(new byte[] {'T', 'y', 'p', 'e', 0, '4', '2'}, actualSerialiseResult);
  }

  /**
   * Test {@link TypeValueSerialiser#serialise(TypeValue)} with {@code TypeValue}.
   *
   * <ul>
   *   <li>When {@link TypeValue#TypeValue(String, String)} with {@code Type} and value is {@code
   *       null}.
   * </ul>
   *
   * <p>Method under test: {@link TypeValueSerialiser#serialise(TypeValue)}
   */
  @Test
  @DisplayName(
      "Test serialise(TypeValue) with 'TypeValue'; when TypeValue(String, String) with 'Type' and value is 'null'")
  @Tag("MaintainedByDiffblue")
  void testSerialiseWithTypeValue_whenTypeValueWithTypeAndValueIsNull()
      throws SerialisationException {
    // Arrange
    TypeValueSerialiser typeValueSerialiser = new TypeValueSerialiser();
    TypeValue typeValue = new TypeValue("Type", null);

    // Act
    byte[] actualSerialiseResult = typeValueSerialiser.serialise(typeValue);

    // Assert
    assertArrayEquals(new byte[] {'T', 'y', 'p', 'e', 0}, actualSerialiseResult);
  }

  /**
   * Test {@link TypeValueSerialiser#serialise(TypeValue)} with {@code TypeValue}.
   *
   * <ul>
   *   <li>When {@link TypeValue#TypeValue(String, String)} with type is empty string and value is
   *       {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link TypeValueSerialiser#serialise(TypeValue)}
   */
  @Test
  @DisplayName(
      "Test serialise(TypeValue) with 'TypeValue'; when TypeValue(String, String) with type is empty string and value is 'null'")
  @Tag("MaintainedByDiffblue")
  void testSerialiseWithTypeValue_whenTypeValueWithTypeIsEmptyStringAndValueIsNull()
      throws SerialisationException {
    // Arrange
    TypeValueSerialiser typeValueSerialiser = new TypeValueSerialiser();
    TypeValue typeValue = new TypeValue("", null);

    // Act and Assert
    assertThrows(SerialisationException.class, () -> typeValueSerialiser.serialise(typeValue));
  }

  /**
   * Test {@link TypeValueSerialiser#serialise(TypeValue)} with {@code TypeValue}.
   *
   * <ul>
   *   <li>When {@link TypeValue#TypeValue(String, String)} with type is {@code null} and value is
   *       empty string.
   * </ul>
   *
   * <p>Method under test: {@link TypeValueSerialiser#serialise(TypeValue)}
   */
  @Test
  @DisplayName(
      "Test serialise(TypeValue) with 'TypeValue'; when TypeValue(String, String) with type is 'null' and value is empty string")
  @Tag("MaintainedByDiffblue")
  void testSerialiseWithTypeValue_whenTypeValueWithTypeIsNullAndValueIsEmptyString()
      throws SerialisationException {
    // Arrange
    TypeValueSerialiser typeValueSerialiser = new TypeValueSerialiser();

    // Act and Assert
    assertThrows(
        SerialisationException.class, () -> typeValueSerialiser.serialise(new TypeValue(null, "")));
  }

  /**
   * Test {@link TypeValueSerialiser#serialise(TypeValue)} with {@code TypeValue}.
   *
   * <ul>
   *   <li>When {@link TypeValue#TypeValue(String, String)} with type is {@code null} and value is
   *       {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link TypeValueSerialiser#serialise(TypeValue)}
   */
  @Test
  @DisplayName(
      "Test serialise(TypeValue) with 'TypeValue'; when TypeValue(String, String) with type is 'null' and value is 'null'")
  @Tag("MaintainedByDiffblue")
  void testSerialiseWithTypeValue_whenTypeValueWithTypeIsNullAndValueIsNull()
      throws SerialisationException {
    // Arrange
    TypeValueSerialiser typeValueSerialiser = new TypeValueSerialiser();
    TypeValue typeValue = new TypeValue(null, null);

    // Act and Assert
    assertThrows(SerialisationException.class, () -> typeValueSerialiser.serialise(typeValue));
  }

  /**
   * Test {@link TypeValueSerialiser#deserialise(byte[])} with {@code bytes}.
   *
   * <p>Method under test: {@link TypeValueSerialiser#deserialise(byte[])}
   */
  @Test
  @DisplayName("Test deserialise(byte[]) with 'bytes'")
  @Tag("MaintainedByDiffblue")
  void testDeserialiseWithBytes() throws SerialisationException {
    // Arrange and Act
    TypeValue actualDeserialiseResult =
        new TypeValueSerialiser()
            .deserialise(new byte[] {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0});

    // Assert
    assertEquals(
        "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000",
        actualDeserialiseResult.getValue());
    assertNull(actualDeserialiseResult.getType());
  }

  /**
   * Test {@link TypeValueSerialiser#deserialise(byte[])} with {@code bytes}.
   *
   * <ul>
   *   <li>When array of {@code byte} with {@code A} and zero.
   *   <li>Then return Type is {@code A}.
   * </ul>
   *
   * <p>Method under test: {@link TypeValueSerialiser#deserialise(byte[])}
   */
  @Test
  @DisplayName(
      "Test deserialise(byte[]) with 'bytes'; when array of byte with 'A' and zero; then return Type is 'A'")
  @Tag("MaintainedByDiffblue")
  void testDeserialiseWithBytes_whenArrayOfByteWithAAndZero_thenReturnTypeIsA()
      throws SerialisationException {
    // Arrange and Act
    TypeValue actualDeserialiseResult =
        new TypeValueSerialiser().deserialise(new byte[] {'A', 0, 'A', 'X', 'A', 'X', 'A', 'X'});

    // Assert
    assertEquals("A", actualDeserialiseResult.getType());
    assertEquals("AXAXAX", actualDeserialiseResult.getValue());
  }

  /**
   * Test {@link TypeValueSerialiser#deserialise(byte[])} with {@code bytes}.
   *
   * <ul>
   *   <li>When array of {@code byte} with one and one.
   *   <li>Then return Value is {@code AXAXAX}.
   * </ul>
   *
   * <p>Method under test: {@link TypeValueSerialiser#deserialise(byte[])}
   */
  @Test
  @DisplayName(
      "Test deserialise(byte[]) with 'bytes'; when array of byte with one and one; then return Value is 'AXAXAX'")
  @Tag("MaintainedByDiffblue")
  void testDeserialiseWithBytes_whenArrayOfByteWithOneAndOne_thenReturnValueIsAxaxax()
      throws SerialisationException {
    // Arrange and Act
    TypeValue actualDeserialiseResult =
        new TypeValueSerialiser().deserialise(new byte[] {1, 1, 'A', 'X', 'A', 'X', 'A', 'X'});

    // Assert
    assertEquals("\u0000AXAXAX", actualDeserialiseResult.getValue());
    assertNull(actualDeserialiseResult.getType());
  }

  /**
   * Test {@link TypeValueSerialiser#deserialise(byte[])} with {@code bytes}.
   *
   * <ul>
   *   <li>When array of {@code byte} with one and two.
   *   <li>Then return Value is {@code AXAXAX}.
   * </ul>
   *
   * <p>Method under test: {@link TypeValueSerialiser#deserialise(byte[])}
   */
  @Test
  @DisplayName(
      "Test deserialise(byte[]) with 'bytes'; when array of byte with one and two; then return Value is 'AXAXAX'")
  @Tag("MaintainedByDiffblue")
  void testDeserialiseWithBytes_whenArrayOfByteWithOneAndTwo_thenReturnValueIsAxaxax()
      throws SerialisationException {
    // Arrange and Act
    TypeValue actualDeserialiseResult =
        new TypeValueSerialiser().deserialise(new byte[] {1, 2, 'A', 'X', 'A', 'X', 'A', 'X'});

    // Assert
    assertEquals("\u0001AXAXAX", actualDeserialiseResult.getValue());
    assertNull(actualDeserialiseResult.getType());
  }

  /**
   * Test {@link TypeValueSerialiser#deserialise(byte[])} with {@code bytes}.
   *
   * <ul>
   *   <li>When array of {@code byte} with one and {@code X}.
   *   <li>Then return Value is {@code XAXAXAX}.
   * </ul>
   *
   * <p>Method under test: {@link TypeValueSerialiser#deserialise(byte[])}
   */
  @Test
  @DisplayName(
      "Test deserialise(byte[]) with 'bytes'; when array of byte with one and 'X'; then return Value is 'XAXAXAX'")
  @Tag("MaintainedByDiffblue")
  void testDeserialiseWithBytes_whenArrayOfByteWithOneAndX_thenReturnValueIsXaxaxax()
      throws SerialisationException {
    // Arrange and Act
    TypeValue actualDeserialiseResult =
        new TypeValueSerialiser().deserialise(new byte[] {1, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Assert
    assertEquals("XAXAXAX", actualDeserialiseResult.getValue());
    assertNull(actualDeserialiseResult.getType());
  }

  /**
   * Test {@link TypeValueSerialiser#deserialise(byte[])} with {@code bytes}.
   *
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.
   *   <li>Then return Value is {@code AXAXAXAX}.
   * </ul>
   *
   * <p>Method under test: {@link TypeValueSerialiser#deserialise(byte[])}
   */
  @Test
  @DisplayName(
      "Test deserialise(byte[]) with 'bytes'; when 'AXAXAXAX' Bytes is 'UTF-8'; then return Value is 'AXAXAXAX'")
  @Tag("MaintainedByDiffblue")
  void testDeserialiseWithBytes_whenAxaxaxaxBytesIsUtf8_thenReturnValueIsAxaxaxax()
      throws UnsupportedEncodingException, SerialisationException {
    // Arrange and Act
    TypeValue actualDeserialiseResult =
        new TypeValueSerialiser().deserialise("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertEquals("AXAXAXAX", actualDeserialiseResult.getValue());
    assertNull(actualDeserialiseResult.getType());
  }

  /**
   * Test {@link TypeValueSerialiser#deserialise(byte[])} with {@code bytes}.
   *
   * <ul>
   *   <li>When empty array of {@code byte}.
   *   <li>Then return Value is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link TypeValueSerialiser#deserialise(byte[])}
   */
  @Test
  @DisplayName(
      "Test deserialise(byte[]) with 'bytes'; when empty array of byte; then return Value is 'null'")
  @Tag("MaintainedByDiffblue")
  void testDeserialiseWithBytes_whenEmptyArrayOfByte_thenReturnValueIsNull()
      throws SerialisationException {
    // Arrange and Act
    TypeValue actualDeserialiseResult = new TypeValueSerialiser().deserialise(new byte[] {});

    // Assert
    assertNull(actualDeserialiseResult.getType());
    assertNull(actualDeserialiseResult.getValue());
  }

  /**
   * Test {@link TypeValueSerialiser#deserialiseEmpty()}.
   *
   * <p>Method under test: {@link TypeValueSerialiser#deserialiseEmpty()}
   */
  @Test
  @DisplayName("Test deserialiseEmpty()")
  @Tag("MaintainedByDiffblue")
  void testDeserialiseEmpty() throws SerialisationException {
    // Arrange, Act and Assert
    assertNull(new TypeValueSerialiser().deserialiseEmpty());
  }

  /**
   * Test {@link TypeValueSerialiser#preservesObjectOrdering()}.
   *
   * <p>Method under test: {@link TypeValueSerialiser#preservesObjectOrdering()}
   */
  @Test
  @DisplayName("Test preservesObjectOrdering()")
  @Tag("MaintainedByDiffblue")
  void testPreservesObjectOrdering() {
    // Arrange, Act and Assert
    assertTrue(new TypeValueSerialiser().preservesObjectOrdering());
  }

  /**
   * Test {@link TypeValueSerialiser#equals(Object)}, and {@link TypeValueSerialiser#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TypeValueSerialiser#equals(Object)}
   *   <li>{@link TypeValueSerialiser#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    TypeValueSerialiser typeValueSerialiser = new TypeValueSerialiser();
    TypeValueSerialiser typeValueSerialiser2 = new TypeValueSerialiser();

    // Act and Assert
    assertEquals(typeValueSerialiser, typeValueSerialiser2);
    assertEquals(typeValueSerialiser.hashCode(), typeValueSerialiser2.hashCode());
  }

  /**
   * Test {@link TypeValueSerialiser#equals(Object)}, and {@link TypeValueSerialiser#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TypeValueSerialiser#equals(Object)}
   *   <li>{@link TypeValueSerialiser#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    TypeValueSerialiser typeValueSerialiser = new TypeValueSerialiser();

    // Act and Assert
    assertEquals(typeValueSerialiser, typeValueSerialiser);
    int expectedHashCodeResult = typeValueSerialiser.hashCode();
    assertEquals(expectedHashCodeResult, typeValueSerialiser.hashCode());
  }

  /**
   * Test {@link TypeValueSerialiser#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TypeValueSerialiser#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TypeValueSerialiser(), 1);
  }

  /**
   * Test {@link TypeValueSerialiser#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TypeValueSerialiser#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TypeValueSerialiser(), null);
  }

  /**
   * Test {@link TypeValueSerialiser#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TypeValueSerialiser#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TypeValueSerialiser(), "Different type to TypeValueSerialiser");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link TypeValueSerialiser}
   *   <li>{@link TypeValueSerialiser#isConsistent()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertTrue(new TypeValueSerialiser().isConsistent());
  }
}
