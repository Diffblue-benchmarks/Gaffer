package uk.gov.gchq.gaffer.sketches.datasketches.sampling.serialisation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.apache.datasketches.sampling.ReservoirItemsUnion;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.exception.SerialisationException;

class ReservoirNumbersUnionSerialiserDiffblueTest {
  /**
   * Test {@link ReservoirNumbersUnionSerialiser#canHandle(Class)}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link ReservoirNumbersUnionSerialiser#canHandle(Class)}
   */
  @Test
  @DisplayName("Test canHandle(Class); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ReservoirNumbersUnionSerialiser.canHandle(Class)"})
  void testCanHandle_thenReturnTrue() {
    // Arrange
    ReservoirNumbersUnionSerialiser reservoirNumbersUnionSerialiser =
        new ReservoirNumbersUnionSerialiser();
    Class<ReservoirItemsUnion> clazz = ReservoirItemsUnion.class;

    // Act and Assert
    assertTrue(reservoirNumbersUnionSerialiser.canHandle(clazz));
  }

  /**
   * Test {@link ReservoirNumbersUnionSerialiser#canHandle(Class)}.
   *
   * <ul>
   *   <li>When {@code Object}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ReservoirNumbersUnionSerialiser#canHandle(Class)}
   */
  @Test
  @DisplayName("Test canHandle(Class); when 'java.lang.Object'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ReservoirNumbersUnionSerialiser.canHandle(Class)"})
  void testCanHandle_whenJavaLangObject_thenReturnFalse() {
    // Arrange
    ReservoirNumbersUnionSerialiser reservoirNumbersUnionSerialiser =
        new ReservoirNumbersUnionSerialiser();
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertFalse(reservoirNumbersUnionSerialiser.canHandle(clazz));
  }

  /**
   * Test {@link ReservoirNumbersUnionSerialiser#deserialiseEmpty()}.
   *
   * <p>Method under test: {@link ReservoirNumbersUnionSerialiser#deserialiseEmpty()}
   */
  @Test
  @DisplayName("Test deserialiseEmpty()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ReservoirItemsUnion ReservoirNumbersUnionSerialiser.deserialiseEmpty()"})
  void testDeserialiseEmpty() throws SerialisationException {
    // Arrange, Act and Assert
    assertNull(new ReservoirNumbersUnionSerialiser().deserialiseEmpty());
  }

  /**
   * Test {@link ReservoirNumbersUnionSerialiser#preservesObjectOrdering()}.
   *
   * <p>Method under test: {@link ReservoirNumbersUnionSerialiser#preservesObjectOrdering()}
   */
  @Test
  @DisplayName("Test preservesObjectOrdering()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ReservoirNumbersUnionSerialiser.preservesObjectOrdering()"})
  void testPreservesObjectOrdering() {
    // Arrange, Act and Assert
    assertFalse(new ReservoirNumbersUnionSerialiser().preservesObjectOrdering());
  }

  /**
   * Test {@link ReservoirNumbersUnionSerialiser#equals(Object)}, and {@link
   * ReservoirNumbersUnionSerialiser#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ReservoirNumbersUnionSerialiser#equals(Object)}
   *   <li>{@link ReservoirNumbersUnionSerialiser#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ReservoirNumbersUnionSerialiser.equals(Object)",
    "int ReservoirNumbersUnionSerialiser.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ReservoirNumbersUnionSerialiser reservoirNumbersUnionSerialiser =
        new ReservoirNumbersUnionSerialiser();
    ReservoirNumbersUnionSerialiser reservoirNumbersUnionSerialiser2 =
        new ReservoirNumbersUnionSerialiser();

    // Act and Assert
    assertEquals(reservoirNumbersUnionSerialiser, reservoirNumbersUnionSerialiser2);
    assertEquals(
        reservoirNumbersUnionSerialiser.hashCode(), reservoirNumbersUnionSerialiser2.hashCode());
  }

  /**
   * Test {@link ReservoirNumbersUnionSerialiser#equals(Object)}, and {@link
   * ReservoirNumbersUnionSerialiser#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ReservoirNumbersUnionSerialiser#equals(Object)}
   *   <li>{@link ReservoirNumbersUnionSerialiser#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ReservoirNumbersUnionSerialiser.equals(Object)",
    "int ReservoirNumbersUnionSerialiser.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ReservoirNumbersUnionSerialiser reservoirNumbersUnionSerialiser =
        new ReservoirNumbersUnionSerialiser();

    // Act and Assert
    assertEquals(reservoirNumbersUnionSerialiser, reservoirNumbersUnionSerialiser);
    int expectedHashCodeResult = reservoirNumbersUnionSerialiser.hashCode();
    assertEquals(expectedHashCodeResult, reservoirNumbersUnionSerialiser.hashCode());
  }

  /**
   * Test {@link ReservoirNumbersUnionSerialiser#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ReservoirNumbersUnionSerialiser#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ReservoirNumbersUnionSerialiser.equals(Object)",
    "int ReservoirNumbersUnionSerialiser.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new ReservoirNumbersUnionSerialiser(), 1);
  }

  /**
   * Test {@link ReservoirNumbersUnionSerialiser#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ReservoirNumbersUnionSerialiser#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ReservoirNumbersUnionSerialiser.equals(Object)",
    "int ReservoirNumbersUnionSerialiser.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new ReservoirNumbersUnionSerialiser(), null);
  }

  /**
   * Test {@link ReservoirNumbersUnionSerialiser#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ReservoirNumbersUnionSerialiser#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ReservoirNumbersUnionSerialiser.equals(Object)",
    "int ReservoirNumbersUnionSerialiser.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        new ReservoirNumbersUnionSerialiser(), "Different type to ReservoirNumbersUnionSerialiser");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link ReservoirNumbersUnionSerialiser}
   *   <li>{@link ReservoirNumbersUnionSerialiser#isConsistent()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ReservoirNumbersUnionSerialiser.<init>()",
    "boolean ReservoirNumbersUnionSerialiser.isConsistent()"
  })
  void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertFalse(new ReservoirNumbersUnionSerialiser().isConsistent());
  }
}
