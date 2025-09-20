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

class BytesSerialiserDiffblueTest {
  /**
   * Test {@link BytesSerialiser#canHandle(Class)}.
   *
   * <p>Method under test: {@link BytesSerialiser#canHandle(Class)}
   */
  @Test
  @DisplayName("Test canHandle(Class)")
  @Tag("MaintainedByDiffblue")
  void testCanHandle() {
    // Arrange
    BytesSerialiser bytesSerialiser = new BytesSerialiser();
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertFalse(bytesSerialiser.canHandle(clazz));
  }

  /**
   * Test {@link BytesSerialiser#serialise(byte[])} with {@code byte[]}.
   *
   * <p>Method under test: {@link BytesSerialiser#serialise(byte[])}
   */
  @Test
  @DisplayName("Test serialise(byte[]) with 'byte[]'")
  @Tag("MaintainedByDiffblue")
  void testSerialiseWithByte() throws UnsupportedEncodingException, SerialisationException {
    // Arrange and Act
    byte[] actualSerialiseResult = new BytesSerialiser().serialise("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualSerialiseResult);
  }

  /**
   * Test {@link BytesSerialiser#deserialise(byte[])} with {@code bytes}.
   *
   * <p>Method under test: {@link BytesSerialiser#deserialise(byte[])}
   */
  @Test
  @DisplayName("Test deserialise(byte[]) with 'bytes'")
  @Tag("MaintainedByDiffblue")
  void testDeserialiseWithBytes() throws UnsupportedEncodingException, SerialisationException {
    // Arrange and Act
    byte[] actualDeserialiseResult =
        new BytesSerialiser().deserialise("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualDeserialiseResult);
  }

  /**
   * Test {@link BytesSerialiser#deserialiseEmpty()}.
   *
   * <p>Method under test: {@link BytesSerialiser#deserialiseEmpty()}
   */
  @Test
  @DisplayName("Test deserialiseEmpty()")
  @Tag("MaintainedByDiffblue")
  void testDeserialiseEmpty() {
    // Arrange, Act and Assert
    assertArrayEquals(new byte[] {}, new BytesSerialiser().deserialiseEmpty());
  }

  /**
   * Test {@link BytesSerialiser#preservesObjectOrdering()}.
   *
   * <p>Method under test: {@link BytesSerialiser#preservesObjectOrdering()}
   */
  @Test
  @DisplayName("Test preservesObjectOrdering()")
  @Tag("MaintainedByDiffblue")
  void testPreservesObjectOrdering() {
    // Arrange, Act and Assert
    assertTrue(new BytesSerialiser().preservesObjectOrdering());
  }

  /**
   * Test {@link BytesSerialiser#equals(Object)}, and {@link BytesSerialiser#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link BytesSerialiser#equals(Object)}
   *   <li>{@link BytesSerialiser#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    BytesSerialiser bytesSerialiser = new BytesSerialiser();
    BytesSerialiser bytesSerialiser2 = new BytesSerialiser();

    // Act and Assert
    assertEquals(bytesSerialiser, bytesSerialiser2);
    assertEquals(bytesSerialiser.hashCode(), bytesSerialiser2.hashCode());
  }

  /**
   * Test {@link BytesSerialiser#equals(Object)}, and {@link BytesSerialiser#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link BytesSerialiser#equals(Object)}
   *   <li>{@link BytesSerialiser#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    BytesSerialiser bytesSerialiser = new BytesSerialiser();

    // Act and Assert
    assertEquals(bytesSerialiser, bytesSerialiser);
    int expectedHashCodeResult = bytesSerialiser.hashCode();
    assertEquals(expectedHashCodeResult, bytesSerialiser.hashCode());
  }

  /**
   * Test {@link BytesSerialiser#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link BytesSerialiser#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new BytesSerialiser(), 1);
  }

  /**
   * Test {@link BytesSerialiser#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link BytesSerialiser#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new BytesSerialiser(), null);
  }

  /**
   * Test {@link BytesSerialiser#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link BytesSerialiser#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new BytesSerialiser(), "Different type to BytesSerialiser");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link BytesSerialiser}
   *   <li>{@link BytesSerialiser#isConsistent()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertTrue(new BytesSerialiser().isConsistent());
  }
}
