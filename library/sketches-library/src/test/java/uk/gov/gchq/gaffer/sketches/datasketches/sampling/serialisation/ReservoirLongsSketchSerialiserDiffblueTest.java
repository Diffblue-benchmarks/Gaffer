package uk.gov.gchq.gaffer.sketches.datasketches.sampling.serialisation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.apache.datasketches.sampling.ReservoirLongsSketch;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.exception.SerialisationException;

class ReservoirLongsSketchSerialiserDiffblueTest {
  /**
   * Test {@link ReservoirLongsSketchSerialiser#canHandle(Class)}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link ReservoirLongsSketchSerialiser#canHandle(Class)}
   */
  @Test
  @DisplayName("Test canHandle(Class); then return 'true'")
  @Tag("MaintainedByDiffblue")
  void testCanHandle_thenReturnTrue() {
    // Arrange
    ReservoirLongsSketchSerialiser reservoirLongsSketchSerialiser =
        new ReservoirLongsSketchSerialiser();
    Class<ReservoirLongsSketch> clazz = ReservoirLongsSketch.class;

    // Act and Assert
    assertTrue(reservoirLongsSketchSerialiser.canHandle(clazz));
  }

  /**
   * Test {@link ReservoirLongsSketchSerialiser#canHandle(Class)}.
   *
   * <ul>
   *   <li>When {@code Object}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ReservoirLongsSketchSerialiser#canHandle(Class)}
   */
  @Test
  @DisplayName("Test canHandle(Class); when 'java.lang.Object'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  void testCanHandle_whenJavaLangObject_thenReturnFalse() {
    // Arrange
    ReservoirLongsSketchSerialiser reservoirLongsSketchSerialiser =
        new ReservoirLongsSketchSerialiser();
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertFalse(reservoirLongsSketchSerialiser.canHandle(clazz));
  }

  /**
   * Test {@link ReservoirLongsSketchSerialiser#deserialiseEmpty()}.
   *
   * <p>Method under test: {@link ReservoirLongsSketchSerialiser#deserialiseEmpty()}
   */
  @Test
  @DisplayName("Test deserialiseEmpty()")
  @Tag("MaintainedByDiffblue")
  void testDeserialiseEmpty() throws SerialisationException {
    // Arrange, Act and Assert
    assertNull(new ReservoirLongsSketchSerialiser().deserialiseEmpty());
  }

  /**
   * Test {@link ReservoirLongsSketchSerialiser#preservesObjectOrdering()}.
   *
   * <p>Method under test: {@link ReservoirLongsSketchSerialiser#preservesObjectOrdering()}
   */
  @Test
  @DisplayName("Test preservesObjectOrdering()")
  @Tag("MaintainedByDiffblue")
  void testPreservesObjectOrdering() {
    // Arrange, Act and Assert
    assertFalse(new ReservoirLongsSketchSerialiser().preservesObjectOrdering());
  }

  /**
   * Test {@link ReservoirLongsSketchSerialiser#equals(Object)}, and {@link
   * ReservoirLongsSketchSerialiser#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ReservoirLongsSketchSerialiser#equals(Object)}
   *   <li>{@link ReservoirLongsSketchSerialiser#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ReservoirLongsSketchSerialiser reservoirLongsSketchSerialiser =
        new ReservoirLongsSketchSerialiser();
    ReservoirLongsSketchSerialiser reservoirLongsSketchSerialiser2 =
        new ReservoirLongsSketchSerialiser();

    // Act and Assert
    assertEquals(reservoirLongsSketchSerialiser, reservoirLongsSketchSerialiser2);
    assertEquals(
        reservoirLongsSketchSerialiser.hashCode(), reservoirLongsSketchSerialiser2.hashCode());
  }

  /**
   * Test {@link ReservoirLongsSketchSerialiser#equals(Object)}, and {@link
   * ReservoirLongsSketchSerialiser#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ReservoirLongsSketchSerialiser#equals(Object)}
   *   <li>{@link ReservoirLongsSketchSerialiser#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ReservoirLongsSketchSerialiser reservoirLongsSketchSerialiser =
        new ReservoirLongsSketchSerialiser();

    // Act and Assert
    assertEquals(reservoirLongsSketchSerialiser, reservoirLongsSketchSerialiser);
    int expectedHashCodeResult = reservoirLongsSketchSerialiser.hashCode();
    assertEquals(expectedHashCodeResult, reservoirLongsSketchSerialiser.hashCode());
  }

  /**
   * Test {@link ReservoirLongsSketchSerialiser#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ReservoirLongsSketchSerialiser#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new ReservoirLongsSketchSerialiser(), 1);
  }

  /**
   * Test {@link ReservoirLongsSketchSerialiser#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ReservoirLongsSketchSerialiser#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new ReservoirLongsSketchSerialiser(), null);
  }

  /**
   * Test {@link ReservoirLongsSketchSerialiser#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ReservoirLongsSketchSerialiser#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        new ReservoirLongsSketchSerialiser(), "Different type to ReservoirLongsSketchSerialiser");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link ReservoirLongsSketchSerialiser}
   *   <li>{@link ReservoirLongsSketchSerialiser#isConsistent()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertFalse(new ReservoirLongsSketchSerialiser().isConsistent());
  }
}
