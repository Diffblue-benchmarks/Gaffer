package uk.gov.gchq.gaffer.sketches.datasketches.sampling.serialisation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.apache.datasketches.common.ArrayOfItemsSerDe;
import org.apache.datasketches.sampling.ReservoirItemsSketch;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.exception.SerialisationException;

class ReservoirItemsSketchSerialiserDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ReservoirItemsSketchSerialiser#ReservoirItemsSketchSerialiser(ArrayOfItemsSerDe)}
   *   <li>{@link ReservoirItemsSketchSerialiser#isConsistent()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ReservoirItemsSketchSerialiser.<init>(ArrayOfItemsSerDe)",
    "boolean ReservoirItemsSketchSerialiser.isConsistent()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    ReservoirItemsSketchSerialiser<Object> actualReservoirItemsSketchSerialiser =
        new ReservoirItemsSketchSerialiser<>(null);

    // Assert
    assertFalse(actualReservoirItemsSketchSerialiser.isConsistent());
  }

  /**
   * Test {@link ReservoirItemsSketchSerialiser#canHandle(Class)}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link ReservoirItemsSketchSerialiser#canHandle(Class)}
   */
  @Test
  @DisplayName("Test canHandle(Class); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ReservoirItemsSketchSerialiser.canHandle(Class)"})
  void testCanHandle_thenReturnTrue() {
    // Arrange
    ReservoirItemsSketchSerialiser<Object> reservoirItemsSketchSerialiser =
        new ReservoirItemsSketchSerialiser<>(mock(ArrayOfItemsSerDe.class));
    Class<ReservoirItemsSketch> clazz = ReservoirItemsSketch.class;

    // Act and Assert
    assertTrue(reservoirItemsSketchSerialiser.canHandle(clazz));
  }

  /**
   * Test {@link ReservoirItemsSketchSerialiser#canHandle(Class)}.
   *
   * <ul>
   *   <li>When {@code Object}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ReservoirItemsSketchSerialiser#canHandle(Class)}
   */
  @Test
  @DisplayName("Test canHandle(Class); when 'java.lang.Object'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ReservoirItemsSketchSerialiser.canHandle(Class)"})
  void testCanHandle_whenJavaLangObject_thenReturnFalse() {
    // Arrange
    ReservoirItemsSketchSerialiser<Object> reservoirItemsSketchSerialiser =
        new ReservoirItemsSketchSerialiser<>(mock(ArrayOfItemsSerDe.class));
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertFalse(reservoirItemsSketchSerialiser.canHandle(clazz));
  }

  /**
   * Test {@link ReservoirItemsSketchSerialiser#deserialiseEmpty()}.
   *
   * <p>Method under test: {@link ReservoirItemsSketchSerialiser#deserialiseEmpty()}
   */
  @Test
  @DisplayName("Test deserialiseEmpty()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ReservoirItemsSketch ReservoirItemsSketchSerialiser.deserialiseEmpty()"})
  void testDeserialiseEmpty() throws SerialisationException {
    // Arrange
    ReservoirItemsSketchSerialiser<Object> reservoirItemsSketchSerialiser =
        new ReservoirItemsSketchSerialiser<>(mock(ArrayOfItemsSerDe.class));

    // Act and Assert
    assertNull(reservoirItemsSketchSerialiser.deserialiseEmpty());
  }

  /**
   * Test {@link ReservoirItemsSketchSerialiser#preservesObjectOrdering()}.
   *
   * <p>Method under test: {@link ReservoirItemsSketchSerialiser#preservesObjectOrdering()}
   */
  @Test
  @DisplayName("Test preservesObjectOrdering()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ReservoirItemsSketchSerialiser.preservesObjectOrdering()"})
  void testPreservesObjectOrdering() {
    // Arrange
    ReservoirItemsSketchSerialiser<Object> reservoirItemsSketchSerialiser =
        new ReservoirItemsSketchSerialiser<>(mock(ArrayOfItemsSerDe.class));

    // Act and Assert
    assertFalse(reservoirItemsSketchSerialiser.preservesObjectOrdering());
  }

  /**
   * Test {@link ReservoirItemsSketchSerialiser#equals(Object)}, and {@link
   * ReservoirItemsSketchSerialiser#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ReservoirItemsSketchSerialiser#equals(Object)}
   *   <li>{@link ReservoirItemsSketchSerialiser#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ReservoirItemsSketchSerialiser.equals(Object)",
    "int ReservoirItemsSketchSerialiser.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ReservoirItemsSketchSerialiser<Object> reservoirItemsSketchSerialiser =
        new ReservoirItemsSketchSerialiser<>(mock(ArrayOfItemsSerDe.class));
    ReservoirItemsSketchSerialiser<Object> reservoirItemsSketchSerialiser2 =
        new ReservoirItemsSketchSerialiser<>(mock(ArrayOfItemsSerDe.class));

    // Act and Assert
    assertEquals(reservoirItemsSketchSerialiser, reservoirItemsSketchSerialiser2);
    assertNotEquals(
        reservoirItemsSketchSerialiser.hashCode(), reservoirItemsSketchSerialiser2.hashCode());
  }

  /**
   * Test {@link ReservoirItemsSketchSerialiser#equals(Object)}, and {@link
   * ReservoirItemsSketchSerialiser#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ReservoirItemsSketchSerialiser#equals(Object)}
   *   <li>{@link ReservoirItemsSketchSerialiser#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ReservoirItemsSketchSerialiser.equals(Object)",
    "int ReservoirItemsSketchSerialiser.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ReservoirItemsSketchSerialiser<Object> reservoirItemsSketchSerialiser =
        new ReservoirItemsSketchSerialiser<>(null);

    // Act and Assert
    assertEquals(reservoirItemsSketchSerialiser, reservoirItemsSketchSerialiser);
    int expectedHashCodeResult = reservoirItemsSketchSerialiser.hashCode();
    assertEquals(expectedHashCodeResult, reservoirItemsSketchSerialiser.hashCode());
  }

  /**
   * Test {@link ReservoirItemsSketchSerialiser#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ReservoirItemsSketchSerialiser#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ReservoirItemsSketchSerialiser.equals(Object)",
    "int ReservoirItemsSketchSerialiser.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ReservoirItemsSketchSerialiser<Object> reservoirItemsSketchSerialiser =
        new ReservoirItemsSketchSerialiser<>(null);

    // Act and Assert
    assertNotEquals(reservoirItemsSketchSerialiser, 1);
  }

  /**
   * Test {@link ReservoirItemsSketchSerialiser#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ReservoirItemsSketchSerialiser#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ReservoirItemsSketchSerialiser.equals(Object)",
    "int ReservoirItemsSketchSerialiser.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ReservoirItemsSketchSerialiser<Object> reservoirItemsSketchSerialiser =
        new ReservoirItemsSketchSerialiser<>(mock(ArrayOfItemsSerDe.class));

    // Act and Assert
    assertNotEquals(reservoirItemsSketchSerialiser, new ReservoirNumbersSketchSerialiser());
  }

  /**
   * Test {@link ReservoirItemsSketchSerialiser#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ReservoirItemsSketchSerialiser#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ReservoirItemsSketchSerialiser.equals(Object)",
    "int ReservoirItemsSketchSerialiser.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    ReservoirItemsSketchSerialiser<Object> reservoirItemsSketchSerialiser =
        new ReservoirItemsSketchSerialiser<>(null);

    // Act and Assert
    assertNotEquals(reservoirItemsSketchSerialiser, null);
  }

  /**
   * Test {@link ReservoirItemsSketchSerialiser#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ReservoirItemsSketchSerialiser#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ReservoirItemsSketchSerialiser.equals(Object)",
    "int ReservoirItemsSketchSerialiser.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    ReservoirItemsSketchSerialiser<Object> reservoirItemsSketchSerialiser =
        new ReservoirItemsSketchSerialiser<>(null);

    // Act and Assert
    assertNotEquals(
        reservoirItemsSketchSerialiser, "Different type to ReservoirItemsSketchSerialiser");
  }
}
