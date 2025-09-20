package uk.gov.gchq.gaffer.sketches.datasketches.quantiles.serialisation;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.io.UnsupportedEncodingException;
import org.apache.datasketches.quantiles.DoublesUnion;
import org.apache.datasketches.quantiles.UpdateDoublesSketch;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.exception.SerialisationException;

class DoublesUnionSerialiserDiffblueTest {
  /**
   * Test {@link DoublesUnionSerialiser#canHandle(Class)}.
   *
   * <ul>
   *   <li>When {@code Object}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link DoublesUnionSerialiser#canHandle(Class)}
   */
  @Test
  @DisplayName("Test canHandle(Class); when 'java.lang.Object'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  void testCanHandle_whenJavaLangObject_thenReturnFalse() {
    // Arrange
    DoublesUnionSerialiser doublesUnionSerialiser = new DoublesUnionSerialiser();
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertFalse(doublesUnionSerialiser.canHandle(clazz));
  }

  /**
   * Test {@link DoublesUnionSerialiser#canHandle(Class)}.
   *
   * <ul>
   *   <li>When {@code DoublesUnion}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link DoublesUnionSerialiser#canHandle(Class)}
   */
  @Test
  @DisplayName(
      "Test canHandle(Class); when 'org.apache.datasketches.quantiles.DoublesUnion'; then return 'true'")
  @Tag("MaintainedByDiffblue")
  void testCanHandle_whenOrgApacheDatasketchesQuantilesDoublesUnion_thenReturnTrue() {
    // Arrange
    DoublesUnionSerialiser doublesUnionSerialiser = new DoublesUnionSerialiser();
    Class<DoublesUnion> clazz = DoublesUnion.class;

    // Act and Assert
    assertTrue(doublesUnionSerialiser.canHandle(clazz));
  }

  /**
   * Test {@link DoublesUnionSerialiser#serialise(DoublesUnion)} with {@code DoublesUnion}.
   *
   * <p>Method under test: {@link DoublesUnionSerialiser#serialise(DoublesUnion)}
   */
  @Test
  @DisplayName("Test serialise(DoublesUnion) with 'DoublesUnion'")
  @Tag("MaintainedByDiffblue")
  void testSerialiseWithDoublesUnion() throws UnsupportedEncodingException, SerialisationException {
    // Arrange
    DoublesUnionSerialiser doublesUnionSerialiser = new DoublesUnionSerialiser();

    UpdateDoublesSketch updateDoublesSketch = mock(UpdateDoublesSketch.class);
    when(updateDoublesSketch.toByteArray()).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    DoublesUnion union = mock(DoublesUnion.class);
    when(union.getResult()).thenReturn(updateDoublesSketch);

    // Act
    byte[] actualSerialiseResult = doublesUnionSerialiser.serialise(union);

    // Assert
    verify(updateDoublesSketch).toByteArray();
    verify(union).getResult();
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualSerialiseResult);
  }

  /**
   * Test {@link DoublesUnionSerialiser#deserialiseEmpty()}.
   *
   * <p>Method under test: {@link DoublesUnionSerialiser#deserialiseEmpty()}
   */
  @Test
  @DisplayName("Test deserialiseEmpty()")
  @Tag("MaintainedByDiffblue")
  void testDeserialiseEmpty() throws SerialisationException {
    // Arrange, Act and Assert
    assertNull(new DoublesUnionSerialiser().deserialiseEmpty());
  }

  /**
   * Test {@link DoublesUnionSerialiser#preservesObjectOrdering()}.
   *
   * <p>Method under test: {@link DoublesUnionSerialiser#preservesObjectOrdering()}
   */
  @Test
  @DisplayName("Test preservesObjectOrdering()")
  @Tag("MaintainedByDiffblue")
  void testPreservesObjectOrdering() {
    // Arrange, Act and Assert
    assertFalse(new DoublesUnionSerialiser().preservesObjectOrdering());
  }

  /**
   * Test {@link DoublesUnionSerialiser#equals(Object)}, and {@link
   * DoublesUnionSerialiser#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link DoublesUnionSerialiser#equals(Object)}
   *   <li>{@link DoublesUnionSerialiser#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    DoublesUnionSerialiser doublesUnionSerialiser = new DoublesUnionSerialiser();
    DoublesUnionSerialiser doublesUnionSerialiser2 = new DoublesUnionSerialiser();

    // Act and Assert
    assertEquals(doublesUnionSerialiser, doublesUnionSerialiser2);
    assertEquals(doublesUnionSerialiser.hashCode(), doublesUnionSerialiser2.hashCode());
  }

  /**
   * Test {@link DoublesUnionSerialiser#equals(Object)}, and {@link
   * DoublesUnionSerialiser#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link DoublesUnionSerialiser#equals(Object)}
   *   <li>{@link DoublesUnionSerialiser#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    DoublesUnionSerialiser doublesUnionSerialiser = new DoublesUnionSerialiser();

    // Act and Assert
    assertEquals(doublesUnionSerialiser, doublesUnionSerialiser);
    int expectedHashCodeResult = doublesUnionSerialiser.hashCode();
    assertEquals(expectedHashCodeResult, doublesUnionSerialiser.hashCode());
  }

  /**
   * Test {@link DoublesUnionSerialiser#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DoublesUnionSerialiser#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new DoublesUnionSerialiser(), 1);
  }

  /**
   * Test {@link DoublesUnionSerialiser#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DoublesUnionSerialiser#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new DoublesUnionSerialiser(), null);
  }

  /**
   * Test {@link DoublesUnionSerialiser#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DoublesUnionSerialiser#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new DoublesUnionSerialiser(), "Different type to DoublesUnionSerialiser");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link DoublesUnionSerialiser}
   *   <li>{@link DoublesUnionSerialiser#isConsistent()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertFalse(new DoublesUnionSerialiser().isConsistent());
  }
}
