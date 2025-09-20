package uk.gov.gchq.gaffer.sketches.datasketches.sampling.serialisation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.apache.datasketches.sampling.ReservoirItemsUnion;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.exception.SerialisationException;

class ReservoirStringsUnionSerialiserDiffblueTest {
  /**
   * Test {@link ReservoirStringsUnionSerialiser#canHandle(Class)}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link ReservoirStringsUnionSerialiser#canHandle(Class)}
   */
  @Test
  @DisplayName("Test canHandle(Class); then return 'true'")
  @Tag("MaintainedByDiffblue")
  void testCanHandle_thenReturnTrue() {
    // Arrange
    ReservoirStringsUnionSerialiser reservoirStringsUnionSerialiser =
        new ReservoirStringsUnionSerialiser();
    Class<ReservoirItemsUnion> clazz = ReservoirItemsUnion.class;

    // Act and Assert
    assertTrue(reservoirStringsUnionSerialiser.canHandle(clazz));
  }

  /**
   * Test {@link ReservoirStringsUnionSerialiser#canHandle(Class)}.
   *
   * <ul>
   *   <li>When {@code Object}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ReservoirStringsUnionSerialiser#canHandle(Class)}
   */
  @Test
  @DisplayName("Test canHandle(Class); when 'java.lang.Object'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  void testCanHandle_whenJavaLangObject_thenReturnFalse() {
    // Arrange
    ReservoirStringsUnionSerialiser reservoirStringsUnionSerialiser =
        new ReservoirStringsUnionSerialiser();
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertFalse(reservoirStringsUnionSerialiser.canHandle(clazz));
  }

  /**
   * Test {@link ReservoirStringsUnionSerialiser#deserialiseEmpty()}.
   *
   * <p>Method under test: {@link ReservoirStringsUnionSerialiser#deserialiseEmpty()}
   */
  @Test
  @DisplayName("Test deserialiseEmpty()")
  @Tag("MaintainedByDiffblue")
  void testDeserialiseEmpty() throws SerialisationException {
    // Arrange, Act and Assert
    assertNull(new ReservoirStringsUnionSerialiser().deserialiseEmpty());
  }

  /**
   * Test {@link ReservoirStringsUnionSerialiser#preservesObjectOrdering()}.
   *
   * <p>Method under test: {@link ReservoirStringsUnionSerialiser#preservesObjectOrdering()}
   */
  @Test
  @DisplayName("Test preservesObjectOrdering()")
  @Tag("MaintainedByDiffblue")
  void testPreservesObjectOrdering() {
    // Arrange, Act and Assert
    assertFalse(new ReservoirStringsUnionSerialiser().preservesObjectOrdering());
  }

  /**
   * Test {@link ReservoirStringsUnionSerialiser#equals(Object)}, and {@link
   * ReservoirStringsUnionSerialiser#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ReservoirStringsUnionSerialiser#equals(Object)}
   *   <li>{@link ReservoirStringsUnionSerialiser#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ReservoirStringsUnionSerialiser reservoirStringsUnionSerialiser =
        new ReservoirStringsUnionSerialiser();
    ReservoirStringsUnionSerialiser reservoirStringsUnionSerialiser2 =
        new ReservoirStringsUnionSerialiser();

    // Act and Assert
    assertEquals(reservoirStringsUnionSerialiser, reservoirStringsUnionSerialiser2);
    assertEquals(
        reservoirStringsUnionSerialiser.hashCode(), reservoirStringsUnionSerialiser2.hashCode());
  }

  /**
   * Test {@link ReservoirStringsUnionSerialiser#equals(Object)}, and {@link
   * ReservoirStringsUnionSerialiser#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ReservoirStringsUnionSerialiser#equals(Object)}
   *   <li>{@link ReservoirStringsUnionSerialiser#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ReservoirStringsUnionSerialiser reservoirStringsUnionSerialiser =
        new ReservoirStringsUnionSerialiser();

    // Act and Assert
    assertEquals(reservoirStringsUnionSerialiser, reservoirStringsUnionSerialiser);
    int expectedHashCodeResult = reservoirStringsUnionSerialiser.hashCode();
    assertEquals(expectedHashCodeResult, reservoirStringsUnionSerialiser.hashCode());
  }

  /**
   * Test {@link ReservoirStringsUnionSerialiser#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ReservoirStringsUnionSerialiser#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new ReservoirStringsUnionSerialiser(), 1);
  }

  /**
   * Test {@link ReservoirStringsUnionSerialiser#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ReservoirStringsUnionSerialiser#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new ReservoirStringsUnionSerialiser(), null);
  }

  /**
   * Test {@link ReservoirStringsUnionSerialiser#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ReservoirStringsUnionSerialiser#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        new ReservoirStringsUnionSerialiser(), "Different type to ReservoirStringsUnionSerialiser");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link ReservoirStringsUnionSerialiser}
   *   <li>{@link ReservoirStringsUnionSerialiser#isConsistent()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertFalse(new ReservoirStringsUnionSerialiser().isConsistent());
  }
}
