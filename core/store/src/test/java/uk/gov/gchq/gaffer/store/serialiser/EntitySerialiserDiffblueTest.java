package uk.gov.gchq.gaffer.store.serialiser;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.data.element.Entity;
import uk.gov.gchq.gaffer.exception.SerialisationException;
import uk.gov.gchq.gaffer.store.schema.Schema;

class EntitySerialiserDiffblueTest {
  /**
   * Test {@link EntitySerialiser#EntitySerialiser()}.
   *
   * <p>Method under test: {@link EntitySerialiser#EntitySerialiser()}
   */
  @Test
  @DisplayName("Test new EntitySerialiser()")
  @Tag("MaintainedByDiffblue")
  void testNewEntitySerialiser() {
    // Arrange and Act
    EntitySerialiser actualEntitySerialiser = new EntitySerialiser();

    // Assert
    assertNull(actualEntitySerialiser.vertexSerialiser);
    assertNull(actualEntitySerialiser.schema);
    assertFalse(actualEntitySerialiser.isConsistent());
  }

  /**
   * Test {@link EntitySerialiser#EntitySerialiser(Schema)}.
   *
   * <ul>
   *   <li>When {@link Schema#Schema()}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link EntitySerialiser#EntitySerialiser(Schema)}
   */
  @Test
  @DisplayName(
      "Test new EntitySerialiser(Schema); when Schema(); then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  void testNewEntitySerialiser_whenSchema_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> new EntitySerialiser(new Schema()));
  }

  /**
   * Test {@link EntitySerialiser#updateSchema(Schema)}.
   *
   * <ul>
   *   <li>When {@link Schema#Schema()}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link EntitySerialiser#updateSchema(Schema)}
   */
  @Test
  @DisplayName("Test updateSchema(Schema); when Schema(); then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  void testUpdateSchema_whenSchema_thenThrowIllegalArgumentException() {
    // Arrange
    EntitySerialiser entitySerialiser = new EntitySerialiser();

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> entitySerialiser.updateSchema(new Schema()));
  }

  /**
   * Test {@link EntitySerialiser#canHandle(Class)}.
   *
   * <ul>
   *   <li>When {@code Object}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link EntitySerialiser#canHandle(Class)}
   */
  @Test
  @DisplayName("Test canHandle(Class); when 'java.lang.Object'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  void testCanHandle_whenJavaLangObject_thenReturnFalse() {
    // Arrange
    EntitySerialiser entitySerialiser = new EntitySerialiser();
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertFalse(entitySerialiser.canHandle(clazz));
  }

  /**
   * Test {@link EntitySerialiser#canHandle(Class)}.
   *
   * <ul>
   *   <li>When {@code Entity}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link EntitySerialiser#canHandle(Class)}
   */
  @Test
  @DisplayName(
      "Test canHandle(Class); when 'uk.gov.gchq.gaffer.data.element.Entity'; then return 'true'")
  @Tag("MaintainedByDiffblue")
  void testCanHandle_whenUkGovGchqGafferDataElementEntity_thenReturnTrue() {
    // Arrange
    EntitySerialiser entitySerialiser = new EntitySerialiser();
    Class<Entity> clazz = Entity.class;

    // Act and Assert
    assertTrue(entitySerialiser.canHandle(clazz));
  }

  /**
   * Test {@link EntitySerialiser#deserialiseEmpty()}.
   *
   * <p>Method under test: {@link EntitySerialiser#deserialiseEmpty()}
   */
  @Test
  @DisplayName("Test deserialiseEmpty()")
  @Tag("MaintainedByDiffblue")
  void testDeserialiseEmpty() throws SerialisationException {
    // Arrange, Act and Assert
    assertNull(new EntitySerialiser().deserialiseEmpty());
  }

  /**
   * Test {@link EntitySerialiser#isConsistent()}.
   *
   * <p>Method under test: {@link EntitySerialiser#isConsistent()}
   */
  @Test
  @DisplayName("Test isConsistent()")
  @Tag("MaintainedByDiffblue")
  void testIsConsistent() {
    // Arrange, Act and Assert
    assertFalse(new EntitySerialiser().isConsistent());
  }
}
