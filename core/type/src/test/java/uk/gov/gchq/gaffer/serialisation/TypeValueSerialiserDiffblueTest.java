package uk.gov.gchq.gaffer.serialisation;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TypeValueSerialiser.canHandle(Class)"})
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TypeValueSerialiser.canHandle(Class)"})
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] TypeValueSerialiser.serialise(TypeValue)"})
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] TypeValueSerialiser.serialise(TypeValue)"})
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] TypeValueSerialiser.serialise(TypeValue)"})
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] TypeValueSerialiser.serialise(TypeValue)"})
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] TypeValueSerialiser.serialise(TypeValue)"})
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] TypeValueSerialiser.serialise(TypeValue)"})
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TypeValue TypeValueSerialiser.deserialise(byte[])"})
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TypeValue TypeValueSerialiser.deserialise(byte[])"})
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TypeValue TypeValueSerialiser.deserialise(byte[])"})
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TypeValue TypeValueSerialiser.deserialise(byte[])"})
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TypeValue TypeValueSerialiser.deserialise(byte[])"})
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TypeValue TypeValueSerialiser.deserialise(byte[])"})
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TypeValue TypeValueSerialiser.deserialise(byte[])"})
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TypeValue TypeValueSerialiser.deserialiseEmpty()"})
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TypeValueSerialiser.preservesObjectOrdering()"})
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TypeValueSerialiser.equals(Object)",
    "int TypeValueSerialiser.hashCode()"
  })
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TypeValueSerialiser.equals(Object)",
    "int TypeValueSerialiser.hashCode()"
  })
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TypeValueSerialiser.equals(Object)",
    "int TypeValueSerialiser.hashCode()"
  })
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TypeValueSerialiser.equals(Object)",
    "int TypeValueSerialiser.hashCode()"
  })
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TypeValueSerialiser.equals(Object)",
    "int TypeValueSerialiser.hashCode()"
  })
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void TypeValueSerialiser.<init>()",
    "boolean TypeValueSerialiser.isConsistent()"
  })
  void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertTrue(new TypeValueSerialiser().isConsistent());
  }
}
