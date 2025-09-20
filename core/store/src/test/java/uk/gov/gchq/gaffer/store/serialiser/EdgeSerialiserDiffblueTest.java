package uk.gov.gchq.gaffer.store.serialiser;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.data.element.Edge;
import uk.gov.gchq.gaffer.exception.SerialisationException;
import uk.gov.gchq.gaffer.store.schema.Schema;

class EdgeSerialiserDiffblueTest {
  /**
   * Test {@link EdgeSerialiser#EdgeSerialiser()}.
   *
   * <p>Method under test: {@link EdgeSerialiser#EdgeSerialiser()}
   */
  @Test
  @DisplayName("Test new EdgeSerialiser()")
  @Tag("MaintainedByDiffblue")
  void testNewEdgeSerialiser() {
    // Arrange and Act
    EdgeSerialiser actualEdgeSerialiser = new EdgeSerialiser();

    // Assert
    assertNull(actualEdgeSerialiser.vertexSerialiser);
    assertNull(actualEdgeSerialiser.schema);
    assertFalse(actualEdgeSerialiser.isConsistent());
  }

  /**
   * Test {@link EdgeSerialiser#EdgeSerialiser(Schema)}.
   *
   * <ul>
   *   <li>When {@link Schema#Schema()}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link EdgeSerialiser#EdgeSerialiser(Schema)}
   */
  @Test
  @DisplayName(
      "Test new EdgeSerialiser(Schema); when Schema(); then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  void testNewEdgeSerialiser_whenSchema_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> new EdgeSerialiser(new Schema()));
  }

  /**
   * Test {@link EdgeSerialiser#updateSchema(Schema)}.
   *
   * <ul>
   *   <li>When {@link Schema#Schema()}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link EdgeSerialiser#updateSchema(Schema)}
   */
  @Test
  @DisplayName("Test updateSchema(Schema); when Schema(); then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  void testUpdateSchema_whenSchema_thenThrowIllegalArgumentException() {
    // Arrange
    EdgeSerialiser edgeSerialiser = new EdgeSerialiser();

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> edgeSerialiser.updateSchema(new Schema()));
  }

  /**
   * Test {@link EdgeSerialiser#canHandle(Class)}.
   *
   * <ul>
   *   <li>When {@code Object}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link EdgeSerialiser#canHandle(Class)}
   */
  @Test
  @DisplayName("Test canHandle(Class); when 'java.lang.Object'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  void testCanHandle_whenJavaLangObject_thenReturnFalse() {
    // Arrange
    EdgeSerialiser edgeSerialiser = new EdgeSerialiser();
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertFalse(edgeSerialiser.canHandle(clazz));
  }

  /**
   * Test {@link EdgeSerialiser#canHandle(Class)}.
   *
   * <ul>
   *   <li>When {@code Edge}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link EdgeSerialiser#canHandle(Class)}
   */
  @Test
  @DisplayName(
      "Test canHandle(Class); when 'uk.gov.gchq.gaffer.data.element.Edge'; then return 'true'")
  @Tag("MaintainedByDiffblue")
  void testCanHandle_whenUkGovGchqGafferDataElementEdge_thenReturnTrue() {
    // Arrange
    EdgeSerialiser edgeSerialiser = new EdgeSerialiser();
    Class<Edge> clazz = Edge.class;

    // Act and Assert
    assertTrue(edgeSerialiser.canHandle(clazz));
  }

  /**
   * Test {@link EdgeSerialiser#deserialiseEmpty()}.
   *
   * <p>Method under test: {@link EdgeSerialiser#deserialiseEmpty()}
   */
  @Test
  @DisplayName("Test deserialiseEmpty()")
  @Tag("MaintainedByDiffblue")
  void testDeserialiseEmpty() throws SerialisationException {
    // Arrange, Act and Assert
    assertNull(new EdgeSerialiser().deserialiseEmpty());
  }

  /**
   * Test {@link EdgeSerialiser#isConsistent()}.
   *
   * <p>Method under test: {@link EdgeSerialiser#isConsistent()}
   */
  @Test
  @DisplayName("Test isConsistent()")
  @Tag("MaintainedByDiffblue")
  void testIsConsistent() {
    // Arrange, Act and Assert
    assertFalse(new EdgeSerialiser().isConsistent());
  }
}
