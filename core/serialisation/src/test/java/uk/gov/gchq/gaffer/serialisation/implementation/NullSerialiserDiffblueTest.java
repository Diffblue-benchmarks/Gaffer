package uk.gov.gchq.gaffer.serialisation.implementation;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.io.UnsupportedEncodingException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.exception.SerialisationException;

class NullSerialiserDiffblueTest {
  /**
   * Test {@link NullSerialiser#canHandle(Class)}.
   *
   * <p>Method under test: {@link NullSerialiser#canHandle(Class)}
   */
  @Test
  @DisplayName("Test canHandle(Class)")
  @Tag("MaintainedByDiffblue")
  void testCanHandle() {
    // Arrange
    NullSerialiser nullSerialiser = new NullSerialiser();
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertTrue(nullSerialiser.canHandle(clazz));
  }

  /**
   * Test {@link NullSerialiser#serialise(Object)}.
   *
   * <p>Method under test: {@link NullSerialiser#serialise(Object)}
   */
  @Test
  @DisplayName("Test serialise(Object)")
  @Tag("MaintainedByDiffblue")
  void testSerialise() throws SerialisationException {
    // Arrange, Act and Assert
    assertArrayEquals(new byte[] {}, new NullSerialiser().serialise("Value"));
  }

  /**
   * Test {@link NullSerialiser#deserialise(byte[])} with {@code bytes}.
   *
   * <p>Method under test: {@link NullSerialiser#deserialise(byte[])}
   */
  @Test
  @DisplayName("Test deserialise(byte[]) with 'bytes'")
  @Tag("MaintainedByDiffblue")
  void testDeserialiseWithBytes() throws UnsupportedEncodingException, SerialisationException {
    // Arrange and Act
    Object actualDeserialiseResult = new NullSerialiser().deserialise("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertNull(actualDeserialiseResult);
  }

  /**
   * Test {@link NullSerialiser#deserialiseEmpty()}.
   *
   * <p>Method under test: {@link NullSerialiser#deserialiseEmpty()}
   */
  @Test
  @DisplayName("Test deserialiseEmpty()")
  @Tag("MaintainedByDiffblue")
  void testDeserialiseEmpty() {
    // Arrange, Act and Assert
    assertNull(new NullSerialiser().deserialiseEmpty());
  }

  /**
   * Test {@link NullSerialiser#preservesObjectOrdering()}.
   *
   * <p>Method under test: {@link NullSerialiser#preservesObjectOrdering()}
   */
  @Test
  @DisplayName("Test preservesObjectOrdering()")
  @Tag("MaintainedByDiffblue")
  void testPreservesObjectOrdering() {
    // Arrange, Act and Assert
    assertTrue(new NullSerialiser().preservesObjectOrdering());
  }

  /**
   * Test {@link NullSerialiser#equals(Object)}, and {@link NullSerialiser#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link NullSerialiser#equals(Object)}
   *   <li>{@link NullSerialiser#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    NullSerialiser nullSerialiser = new NullSerialiser();
    NullSerialiser nullSerialiser2 = new NullSerialiser();

    // Act and Assert
    assertEquals(nullSerialiser, nullSerialiser2);
    assertEquals(nullSerialiser.hashCode(), nullSerialiser2.hashCode());
  }

  /**
   * Test {@link NullSerialiser#equals(Object)}, and {@link NullSerialiser#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link NullSerialiser#equals(Object)}
   *   <li>{@link NullSerialiser#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    NullSerialiser nullSerialiser = new NullSerialiser();

    // Act and Assert
    assertEquals(nullSerialiser, nullSerialiser);
    int expectedHashCodeResult = nullSerialiser.hashCode();
    assertEquals(expectedHashCodeResult, nullSerialiser.hashCode());
  }

  /**
   * Test {@link NullSerialiser#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link NullSerialiser#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new NullSerialiser(), 1);
  }

  /**
   * Test {@link NullSerialiser#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link NullSerialiser#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new NullSerialiser(), null);
  }

  /**
   * Test {@link NullSerialiser#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link NullSerialiser#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new NullSerialiser(), "Different type to NullSerialiser");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link NullSerialiser}
   *   <li>{@link NullSerialiser#isConsistent()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertTrue(new NullSerialiser().isConsistent());
  }
}
