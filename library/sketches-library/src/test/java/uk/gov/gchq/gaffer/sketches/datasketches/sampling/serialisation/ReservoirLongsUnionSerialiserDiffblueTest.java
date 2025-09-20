package uk.gov.gchq.gaffer.sketches.datasketches.sampling.serialisation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.apache.datasketches.sampling.ReservoirLongsUnion;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.exception.SerialisationException;

class ReservoirLongsUnionSerialiserDiffblueTest {
  /**
   * Test {@link ReservoirLongsUnionSerialiser#canHandle(Class)}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link ReservoirLongsUnionSerialiser#canHandle(Class)}
   */
  @Test
  @DisplayName("Test canHandle(Class); then return 'true'")
  @Tag("MaintainedByDiffblue")
  void testCanHandle_thenReturnTrue() {
    // Arrange
    ReservoirLongsUnionSerialiser reservoirLongsUnionSerialiser =
        new ReservoirLongsUnionSerialiser();
    Class<ReservoirLongsUnion> clazz = ReservoirLongsUnion.class;

    // Act and Assert
    assertTrue(reservoirLongsUnionSerialiser.canHandle(clazz));
  }

  /**
   * Test {@link ReservoirLongsUnionSerialiser#canHandle(Class)}.
   *
   * <ul>
   *   <li>When {@code Object}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ReservoirLongsUnionSerialiser#canHandle(Class)}
   */
  @Test
  @DisplayName("Test canHandle(Class); when 'java.lang.Object'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  void testCanHandle_whenJavaLangObject_thenReturnFalse() {
    // Arrange
    ReservoirLongsUnionSerialiser reservoirLongsUnionSerialiser =
        new ReservoirLongsUnionSerialiser();
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertFalse(reservoirLongsUnionSerialiser.canHandle(clazz));
  }

  /**
   * Test {@link ReservoirLongsUnionSerialiser#deserialiseEmpty()}.
   *
   * <p>Method under test: {@link ReservoirLongsUnionSerialiser#deserialiseEmpty()}
   */
  @Test
  @DisplayName("Test deserialiseEmpty()")
  @Tag("MaintainedByDiffblue")
  void testDeserialiseEmpty() throws SerialisationException {
    // Arrange, Act and Assert
    assertNull(new ReservoirLongsUnionSerialiser().deserialiseEmpty());
  }

  /**
   * Test {@link ReservoirLongsUnionSerialiser#preservesObjectOrdering()}.
   *
   * <p>Method under test: {@link ReservoirLongsUnionSerialiser#preservesObjectOrdering()}
   */
  @Test
  @DisplayName("Test preservesObjectOrdering()")
  @Tag("MaintainedByDiffblue")
  void testPreservesObjectOrdering() {
    // Arrange, Act and Assert
    assertFalse(new ReservoirLongsUnionSerialiser().preservesObjectOrdering());
  }

  /**
   * Test {@link ReservoirLongsUnionSerialiser#equals(Object)}, and {@link
   * ReservoirLongsUnionSerialiser#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ReservoirLongsUnionSerialiser#equals(Object)}
   *   <li>{@link ReservoirLongsUnionSerialiser#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ReservoirLongsUnionSerialiser reservoirLongsUnionSerialiser =
        new ReservoirLongsUnionSerialiser();
    ReservoirLongsUnionSerialiser reservoirLongsUnionSerialiser2 =
        new ReservoirLongsUnionSerialiser();

    // Act and Assert
    assertEquals(reservoirLongsUnionSerialiser, reservoirLongsUnionSerialiser2);
    assertEquals(
        reservoirLongsUnionSerialiser.hashCode(), reservoirLongsUnionSerialiser2.hashCode());
  }

  /**
   * Test {@link ReservoirLongsUnionSerialiser#equals(Object)}, and {@link
   * ReservoirLongsUnionSerialiser#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ReservoirLongsUnionSerialiser#equals(Object)}
   *   <li>{@link ReservoirLongsUnionSerialiser#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ReservoirLongsUnionSerialiser reservoirLongsUnionSerialiser =
        new ReservoirLongsUnionSerialiser();

    // Act and Assert
    assertEquals(reservoirLongsUnionSerialiser, reservoirLongsUnionSerialiser);
    int expectedHashCodeResult = reservoirLongsUnionSerialiser.hashCode();
    assertEquals(expectedHashCodeResult, reservoirLongsUnionSerialiser.hashCode());
  }

  /**
   * Test {@link ReservoirLongsUnionSerialiser#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ReservoirLongsUnionSerialiser#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new ReservoirLongsUnionSerialiser(), 1);
  }

  /**
   * Test {@link ReservoirLongsUnionSerialiser#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ReservoirLongsUnionSerialiser#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new ReservoirLongsUnionSerialiser(), null);
  }

  /**
   * Test {@link ReservoirLongsUnionSerialiser#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ReservoirLongsUnionSerialiser#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        new ReservoirLongsUnionSerialiser(), "Different type to ReservoirLongsUnionSerialiser");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link ReservoirLongsUnionSerialiser}
   *   <li>{@link ReservoirLongsUnionSerialiser#isConsistent()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertFalse(new ReservoirLongsUnionSerialiser().isConsistent());
  }
}
