package uk.gov.gchq.gaffer.serialisation.implementation.tostring;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.exception.SerialisationException;

class StringToStringSerialiserDiffblueTest {
  /**
   * Test {@link StringToStringSerialiser#canHandle(Class)}.
   *
   * <ul>
   *   <li>When {@code Object}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link StringToStringSerialiser#canHandle(Class)}
   */
  @Test
  @DisplayName("Test canHandle(Class); when 'java.lang.Object'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  void testCanHandle_whenJavaLangObject_thenReturnFalse() {
    // Arrange
    StringToStringSerialiser stringToStringSerialiser = new StringToStringSerialiser();
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertFalse(stringToStringSerialiser.canHandle(clazz));
  }

  /**
   * Test {@link StringToStringSerialiser#canHandle(Class)}.
   *
   * <ul>
   *   <li>When {@code String}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link StringToStringSerialiser#canHandle(Class)}
   */
  @Test
  @DisplayName("Test canHandle(Class); when 'java.lang.String'; then return 'true'")
  @Tag("MaintainedByDiffblue")
  void testCanHandle_whenJavaLangString_thenReturnTrue() {
    // Arrange
    StringToStringSerialiser stringToStringSerialiser = new StringToStringSerialiser();
    Class<String> clazz = String.class;

    // Act and Assert
    assertTrue(stringToStringSerialiser.canHandle(clazz));
  }

  /**
   * Test {@link StringToStringSerialiser#serialise(String)} with {@code String}.
   *
   * <p>Method under test: {@link StringToStringSerialiser#serialise(String)}
   */
  @Test
  @DisplayName("Test serialise(String) with 'String'")
  @Tag("MaintainedByDiffblue")
  void testSerialiseWithString() throws SerialisationException {
    // Arrange, Act and Assert
    assertEquals("Object", new StringToStringSerialiser().serialise("Object"));
  }

  /**
   * Test {@link StringToStringSerialiser#deserialise(String)} with {@code String}.
   *
   * <p>Method under test: {@link StringToStringSerialiser#deserialise(String)}
   */
  @Test
  @DisplayName("Test deserialise(String) with 'String'")
  @Tag("MaintainedByDiffblue")
  void testDeserialiseWithString() throws SerialisationException {
    // Arrange, Act and Assert
    assertEquals("foo", new StringToStringSerialiser().deserialise("foo"));
  }

  /**
   * Test {@link StringToStringSerialiser#preservesObjectOrdering()}.
   *
   * <p>Method under test: {@link StringToStringSerialiser#preservesObjectOrdering()}
   */
  @Test
  @DisplayName("Test preservesObjectOrdering()")
  @Tag("MaintainedByDiffblue")
  void testPreservesObjectOrdering() {
    // Arrange, Act and Assert
    assertTrue(new StringToStringSerialiser().preservesObjectOrdering());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link StringToStringSerialiser}
   *   <li>{@link StringToStringSerialiser#isConsistent()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertTrue(new StringToStringSerialiser().isConsistent());
  }
}
