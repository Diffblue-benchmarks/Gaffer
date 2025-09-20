package uk.gov.gchq.gaffer.serialisation.implementation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.exception.SerialisationException;

class StringSerialiserDiffblueTest {
  /**
   * Test new {@link StringSerialiser} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link StringSerialiser}
   */
  @Test
  @DisplayName("Test new StringSerialiser (default constructor)")
  @Tag("MaintainedByDiffblue")
  void testNewStringSerialiser() {
    // Arrange and Act
    StringSerialiser actualStringSerialiser = new StringSerialiser();

    // Assert
    assertEquals("UTF-8", actualStringSerialiser.getCharset());
    assertTrue(actualStringSerialiser.isConsistent());
  }

  /**
   * Test {@link StringSerialiser#canHandle(Class)}.
   *
   * <ul>
   *   <li>When {@code Object}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link StringSerialiser#canHandle(Class)}
   */
  @Test
  @DisplayName("Test canHandle(Class); when 'java.lang.Object'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  void testCanHandle_whenJavaLangObject_thenReturnFalse() {
    // Arrange
    StringSerialiser stringSerialiser = new StringSerialiser();
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertFalse(stringSerialiser.canHandle(clazz));
  }

  /**
   * Test {@link StringSerialiser#canHandle(Class)}.
   *
   * <ul>
   *   <li>When {@code String}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link StringSerialiser#canHandle(Class)}
   */
  @Test
  @DisplayName("Test canHandle(Class); when 'java.lang.String'; then return 'true'")
  @Tag("MaintainedByDiffblue")
  void testCanHandle_whenJavaLangString_thenReturnTrue() {
    // Arrange
    StringSerialiser stringSerialiser = new StringSerialiser();
    Class<String> clazz = String.class;

    // Act and Assert
    assertTrue(stringSerialiser.canHandle(clazz));
  }

  /**
   * Test {@link StringSerialiser#serialiseToString(String)} with {@code String}.
   *
   * <p>Method under test: {@link StringSerialiser#serialiseToString(String)}
   */
  @Test
  @DisplayName("Test serialiseToString(String) with 'String'")
  @Tag("MaintainedByDiffblue")
  void testSerialiseToStringWithString() throws SerialisationException {
    // Arrange, Act and Assert
    assertEquals("Object", new StringSerialiser().serialiseToString("Object"));
  }

  /**
   * Test {@link StringSerialiser#deserialiseString(String)}.
   *
   * <p>Method under test: {@link StringSerialiser#deserialiseString(String)}
   */
  @Test
  @DisplayName("Test deserialiseString(String)")
  @Tag("MaintainedByDiffblue")
  void testDeserialiseString() throws SerialisationException {
    // Arrange, Act and Assert
    assertEquals("42", new StringSerialiser().deserialiseString("42"));
  }

  /**
   * Test {@link StringSerialiser#deserialiseEmpty()}.
   *
   * <p>Method under test: {@link StringSerialiser#deserialiseEmpty()}
   */
  @Test
  @DisplayName("Test deserialiseEmpty()")
  @Tag("MaintainedByDiffblue")
  void testDeserialiseEmpty() {
    // Arrange, Act and Assert
    assertEquals("", new StringSerialiser().deserialiseEmpty());
  }

  /**
   * Test {@link StringSerialiser#preservesObjectOrdering()}.
   *
   * <p>Method under test: {@link StringSerialiser#preservesObjectOrdering()}
   */
  @Test
  @DisplayName("Test preservesObjectOrdering()")
  @Tag("MaintainedByDiffblue")
  void testPreservesObjectOrdering() {
    // Arrange, Act and Assert
    assertTrue(new StringSerialiser().preservesObjectOrdering());
  }

  /**
   * Test {@link StringSerialiser#isConsistent()}.
   *
   * <p>Method under test: {@link StringSerialiser#isConsistent()}
   */
  @Test
  @DisplayName("Test isConsistent()")
  @Tag("MaintainedByDiffblue")
  void testIsConsistent() {
    // Arrange, Act and Assert
    assertTrue(new StringSerialiser().isConsistent());
  }

  /**
   * Test {@link StringSerialiser#equals(Object)}, and {@link StringSerialiser#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link StringSerialiser#equals(Object)}
   *   <li>{@link StringSerialiser#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    StringSerialiser stringSerialiser = new StringSerialiser();
    StringSerialiser stringSerialiser2 = new StringSerialiser();

    // Act and Assert
    assertEquals(stringSerialiser, stringSerialiser2);
    assertEquals(stringSerialiser.hashCode(), stringSerialiser2.hashCode());
  }

  /**
   * Test {@link StringSerialiser#equals(Object)}, and {@link StringSerialiser#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link StringSerialiser#equals(Object)}
   *   <li>{@link StringSerialiser#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    StringSerialiser stringSerialiser = new StringSerialiser();

    // Act and Assert
    assertEquals(stringSerialiser, stringSerialiser);
    int expectedHashCodeResult = stringSerialiser.hashCode();
    assertEquals(expectedHashCodeResult, stringSerialiser.hashCode());
  }

  /**
   * Test {@link StringSerialiser#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link StringSerialiser#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new StringSerialiser(), 1);
  }

  /**
   * Test {@link StringSerialiser#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link StringSerialiser#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new StringSerialiser(), null);
  }

  /**
   * Test {@link StringSerialiser#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link StringSerialiser#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new StringSerialiser(), "Different type to StringSerialiser");
  }
}
