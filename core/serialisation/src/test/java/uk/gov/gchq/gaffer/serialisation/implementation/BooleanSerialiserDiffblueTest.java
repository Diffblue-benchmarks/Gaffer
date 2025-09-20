package uk.gov.gchq.gaffer.serialisation.implementation;

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

class BooleanSerialiserDiffblueTest {
  /**
   * Test {@link BooleanSerialiser#serialise(Boolean)} with {@code Boolean}.
   *
   * <ul>
   *   <li>When {@code false}.
   *   <li>Then return array of {@code byte} with zero.
   * </ul>
   *
   * <p>Method under test: {@link BooleanSerialiser#serialise(Boolean)}
   */
  @Test
  @DisplayName(
      "Test serialise(Boolean) with 'Boolean'; when 'false'; then return array of byte with zero")
  @Tag("MaintainedByDiffblue")
  void testSerialiseWithBoolean_whenFalse_thenReturnArrayOfByteWithZero()
      throws SerialisationException {
    // Arrange, Act and Assert
    assertArrayEquals(new byte[] {0}, new BooleanSerialiser().serialise(false));
  }

  /**
   * Test {@link BooleanSerialiser#serialise(Boolean)} with {@code Boolean}.
   *
   * <ul>
   *   <li>When {@code true}.
   *   <li>Then return array of {@code byte} with one.
   * </ul>
   *
   * <p>Method under test: {@link BooleanSerialiser#serialise(Boolean)}
   */
  @Test
  @DisplayName(
      "Test serialise(Boolean) with 'Boolean'; when 'true'; then return array of byte with one")
  @Tag("MaintainedByDiffblue")
  void testSerialiseWithBoolean_whenTrue_thenReturnArrayOfByteWithOne()
      throws SerialisationException {
    // Arrange, Act and Assert
    assertArrayEquals(new byte[] {1}, new BooleanSerialiser().serialise(true));
  }

  /**
   * Test {@link BooleanSerialiser#deserialise(byte[], int, int)} with {@code allBytes}, {@code
   * offset}, {@code length}.
   *
   * <ul>
   *   <li>When {@code A}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link BooleanSerialiser#deserialise(byte[], int, int)}
   */
  @Test
  @DisplayName(
      "Test deserialise(byte[], int, int) with 'allBytes', 'offset', 'length'; when 'A'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  void testDeserialiseWithAllBytesOffsetLength_whenA_thenReturnFalse()
      throws SerialisationException {
    // Arrange, Act and Assert
    assertFalse(
        new BooleanSerialiser()
            .deserialise(new byte[] {'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'}, 2, 1));
  }

  /**
   * Test {@link BooleanSerialiser#deserialise(byte[], int, int)} with {@code allBytes}, {@code
   * offset}, {@code length}.
   *
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link BooleanSerialiser#deserialise(byte[], int, int)}
   */
  @Test
  @DisplayName(
      "Test deserialise(byte[], int, int) with 'allBytes', 'offset', 'length'; when 'AXAXAXAX' Bytes is 'UTF-8'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  void testDeserialiseWithAllBytesOffsetLength_whenAxaxaxaxBytesIsUtf8_thenReturnFalse()
      throws UnsupportedEncodingException, SerialisationException {
    // Arrange, Act and Assert
    assertFalse(new BooleanSerialiser().deserialise("AXAXAXAX".getBytes("UTF-8"), 2, 3));
  }

  /**
   * Test {@link BooleanSerialiser#deserialise(byte[], int, int)} with {@code allBytes}, {@code
   * offset}, {@code length}.
   *
   * <ul>
   *   <li>When {@code X}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link BooleanSerialiser#deserialise(byte[], int, int)}
   */
  @Test
  @DisplayName(
      "Test deserialise(byte[], int, int) with 'allBytes', 'offset', 'length'; when 'X'; then return 'true'")
  @Tag("MaintainedByDiffblue")
  void testDeserialiseWithAllBytesOffsetLength_whenX_thenReturnTrue()
      throws SerialisationException {
    // Arrange, Act and Assert
    assertTrue(
        new BooleanSerialiser()
            .deserialise(new byte[] {'A', 'X', 1, 'X', 'A', 'X', 'A', 'X'}, 2, 1));
  }

  /**
   * Test {@link BooleanSerialiser#deserialise(byte[], Class)} with {@code bytes}, {@code clazz}.
   *
   * <ul>
   *   <li>When array of {@code byte} with {@code A}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link BooleanSerialiser#deserialise(byte[], Class)}
   */
  @Test
  @DisplayName(
      "Test deserialise(byte[], Class) with 'bytes', 'clazz'; when array of byte with 'A'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  void testDeserialiseWithBytesClazz_whenArrayOfByteWithA_thenReturnFalse()
      throws SerialisationException {
    // Arrange
    BooleanSerialiser booleanSerialiser = new BooleanSerialiser();
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertFalse((Boolean) booleanSerialiser.deserialise(new byte[] {'A'}, clazz));
  }

  /**
   * Test {@link BooleanSerialiser#deserialise(byte[], Class)} with {@code bytes}, {@code clazz}.
   *
   * <ul>
   *   <li>When array of {@code byte} with one.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link BooleanSerialiser#deserialise(byte[], Class)}
   */
  @Test
  @DisplayName(
      "Test deserialise(byte[], Class) with 'bytes', 'clazz'; when array of byte with one; then return 'true'")
  @Tag("MaintainedByDiffblue")
  void testDeserialiseWithBytesClazz_whenArrayOfByteWithOne_thenReturnTrue()
      throws SerialisationException {
    // Arrange
    BooleanSerialiser booleanSerialiser = new BooleanSerialiser();
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertTrue((Boolean) booleanSerialiser.deserialise(new byte[] {1}, clazz));
  }

  /**
   * Test {@link BooleanSerialiser#deserialise(byte[], Class)} with {@code bytes}, {@code clazz}.
   *
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link BooleanSerialiser#deserialise(byte[], Class)}
   */
  @Test
  @DisplayName(
      "Test deserialise(byte[], Class) with 'bytes', 'clazz'; when 'AXAXAXAX' Bytes is 'UTF-8'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  void testDeserialiseWithBytesClazz_whenAxaxaxaxBytesIsUtf8_thenReturnFalse()
      throws UnsupportedEncodingException, SerialisationException {
    // Arrange
    BooleanSerialiser booleanSerialiser = new BooleanSerialiser();
    byte[] bytes = "AXAXAXAX".getBytes("UTF-8");
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertFalse((Boolean) booleanSerialiser.deserialise(bytes, clazz));
  }

  /**
   * Test {@link BooleanSerialiser#deserialise(byte[])} with {@code bytes}.
   *
   * <ul>
   *   <li>When array of {@code byte} with {@code A}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link BooleanSerialiser#deserialise(byte[])}
   */
  @Test
  @DisplayName(
      "Test deserialise(byte[]) with 'bytes'; when array of byte with 'A'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  void testDeserialiseWithBytes_whenArrayOfByteWithA_thenReturnFalse()
      throws SerialisationException {
    // Arrange and Act
    Boolean actualDeserialiseResult = new BooleanSerialiser().deserialise(new byte[] {'A'});

    // Assert
    assertFalse(actualDeserialiseResult);
  }

  /**
   * Test {@link BooleanSerialiser#deserialise(byte[])} with {@code bytes}.
   *
   * <ul>
   *   <li>When array of {@code byte} with one.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link BooleanSerialiser#deserialise(byte[])}
   */
  @Test
  @DisplayName(
      "Test deserialise(byte[]) with 'bytes'; when array of byte with one; then return 'true'")
  @Tag("MaintainedByDiffblue")
  void testDeserialiseWithBytes_whenArrayOfByteWithOne_thenReturnTrue()
      throws SerialisationException {
    // Arrange and Act
    Boolean actualDeserialiseResult = new BooleanSerialiser().deserialise(new byte[] {1});

    // Assert
    assertTrue(actualDeserialiseResult);
  }

  /**
   * Test {@link BooleanSerialiser#deserialise(byte[])} with {@code bytes}.
   *
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link BooleanSerialiser#deserialise(byte[])}
   */
  @Test
  @DisplayName(
      "Test deserialise(byte[]) with 'bytes'; when 'AXAXAXAX' Bytes is 'UTF-8'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  void testDeserialiseWithBytes_whenAxaxaxaxBytesIsUtf8_thenReturnFalse()
      throws UnsupportedEncodingException, SerialisationException {
    // Arrange and Act
    Boolean actualDeserialiseResult =
        new BooleanSerialiser().deserialise("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertFalse(actualDeserialiseResult);
  }

  /**
   * Test {@link BooleanSerialiser#deserialiseEmpty()}.
   *
   * <p>Method under test: {@link BooleanSerialiser#deserialiseEmpty()}
   */
  @Test
  @DisplayName("Test deserialiseEmpty()")
  @Tag("MaintainedByDiffblue")
  void testDeserialiseEmpty() {
    // Arrange, Act and Assert
    assertFalse(new BooleanSerialiser().deserialiseEmpty());
  }

  /**
   * Test {@link BooleanSerialiser#canHandle(Class)}.
   *
   * <ul>
   *   <li>When {@code Boolean}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link BooleanSerialiser#canHandle(Class)}
   */
  @Test
  @DisplayName("Test canHandle(Class); when 'java.lang.Boolean'; then return 'true'")
  @Tag("MaintainedByDiffblue")
  void testCanHandle_whenJavaLangBoolean_thenReturnTrue() {
    // Arrange
    BooleanSerialiser booleanSerialiser = new BooleanSerialiser();
    Class<Boolean> clazz = Boolean.class;

    // Act and Assert
    assertTrue(booleanSerialiser.canHandle(clazz));
  }

  /**
   * Test {@link BooleanSerialiser#canHandle(Class)}.
   *
   * <ul>
   *   <li>When {@code Object}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link BooleanSerialiser#canHandle(Class)}
   */
  @Test
  @DisplayName("Test canHandle(Class); when 'java.lang.Object'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  void testCanHandle_whenJavaLangObject_thenReturnFalse() {
    // Arrange
    BooleanSerialiser booleanSerialiser = new BooleanSerialiser();
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertFalse(booleanSerialiser.canHandle(clazz));
  }

  /**
   * Test {@link BooleanSerialiser#preservesObjectOrdering()}.
   *
   * <p>Method under test: {@link BooleanSerialiser#preservesObjectOrdering()}
   */
  @Test
  @DisplayName("Test preservesObjectOrdering()")
  @Tag("MaintainedByDiffblue")
  void testPreservesObjectOrdering() {
    // Arrange, Act and Assert
    assertTrue(new BooleanSerialiser().preservesObjectOrdering());
  }

  /**
   * Test {@link BooleanSerialiser#equals(Object)}, and {@link BooleanSerialiser#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link BooleanSerialiser#equals(Object)}
   *   <li>{@link BooleanSerialiser#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    BooleanSerialiser booleanSerialiser = new BooleanSerialiser();
    BooleanSerialiser booleanSerialiser2 = new BooleanSerialiser();

    // Act and Assert
    assertEquals(booleanSerialiser, booleanSerialiser2);
    assertEquals(booleanSerialiser.hashCode(), booleanSerialiser2.hashCode());
  }

  /**
   * Test {@link BooleanSerialiser#equals(Object)}, and {@link BooleanSerialiser#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link BooleanSerialiser#equals(Object)}
   *   <li>{@link BooleanSerialiser#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    BooleanSerialiser booleanSerialiser = new BooleanSerialiser();

    // Act and Assert
    assertEquals(booleanSerialiser, booleanSerialiser);
    int expectedHashCodeResult = booleanSerialiser.hashCode();
    assertEquals(expectedHashCodeResult, booleanSerialiser.hashCode());
  }

  /**
   * Test {@link BooleanSerialiser#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link BooleanSerialiser#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new BooleanSerialiser(), 1);
  }

  /**
   * Test {@link BooleanSerialiser#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link BooleanSerialiser#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new BooleanSerialiser(), null);
  }

  /**
   * Test {@link BooleanSerialiser#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link BooleanSerialiser#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new BooleanSerialiser(), "Different type to BooleanSerialiser");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link BooleanSerialiser}
   *   <li>{@link BooleanSerialiser#isConsistent()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertTrue(new BooleanSerialiser().isConsistent());
  }
}
