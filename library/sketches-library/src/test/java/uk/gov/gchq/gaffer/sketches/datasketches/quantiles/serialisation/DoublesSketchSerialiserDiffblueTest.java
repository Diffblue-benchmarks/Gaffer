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
import org.apache.datasketches.quantiles.DoublesSketch;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.exception.SerialisationException;

class DoublesSketchSerialiserDiffblueTest {
  /**
   * Test {@link DoublesSketchSerialiser#canHandle(Class)}.
   *
   * <ul>
   *   <li>When {@code Object}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link DoublesSketchSerialiser#canHandle(Class)}
   */
  @Test
  @DisplayName("Test canHandle(Class); when 'java.lang.Object'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  void testCanHandle_whenJavaLangObject_thenReturnFalse() {
    // Arrange
    DoublesSketchSerialiser doublesSketchSerialiser = new DoublesSketchSerialiser();
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertFalse(doublesSketchSerialiser.canHandle(clazz));
  }

  /**
   * Test {@link DoublesSketchSerialiser#canHandle(Class)}.
   *
   * <ul>
   *   <li>When {@code DoublesSketch}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link DoublesSketchSerialiser#canHandle(Class)}
   */
  @Test
  @DisplayName(
      "Test canHandle(Class); when 'org.apache.datasketches.quantiles.DoublesSketch'; then return 'true'")
  @Tag("MaintainedByDiffblue")
  void testCanHandle_whenOrgApacheDatasketchesQuantilesDoublesSketch_thenReturnTrue() {
    // Arrange
    DoublesSketchSerialiser doublesSketchSerialiser = new DoublesSketchSerialiser();
    Class<DoublesSketch> clazz = DoublesSketch.class;

    // Act and Assert
    assertTrue(doublesSketchSerialiser.canHandle(clazz));
  }

  /**
   * Test {@link DoublesSketchSerialiser#serialise(DoublesSketch)} with {@code DoublesSketch}.
   *
   * <p>Method under test: {@link DoublesSketchSerialiser#serialise(DoublesSketch)}
   */
  @Test
  @DisplayName("Test serialise(DoublesSketch) with 'DoublesSketch'")
  @Tag("MaintainedByDiffblue")
  void testSerialiseWithDoublesSketch()
      throws UnsupportedEncodingException, SerialisationException {
    // Arrange
    DoublesSketchSerialiser doublesSketchSerialiser = new DoublesSketchSerialiser();

    DoublesSketch sketch = mock(DoublesSketch.class);
    when(sketch.toByteArray()).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    byte[] actualSerialiseResult = doublesSketchSerialiser.serialise(sketch);

    // Assert
    verify(sketch).toByteArray();
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualSerialiseResult);
  }

  /**
   * Test {@link DoublesSketchSerialiser#deserialiseEmpty()}.
   *
   * <p>Method under test: {@link DoublesSketchSerialiser#deserialiseEmpty()}
   */
  @Test
  @DisplayName("Test deserialiseEmpty()")
  @Tag("MaintainedByDiffblue")
  void testDeserialiseEmpty() throws SerialisationException {
    // Arrange, Act and Assert
    assertNull(new DoublesSketchSerialiser().deserialiseEmpty());
  }

  /**
   * Test {@link DoublesSketchSerialiser#preservesObjectOrdering()}.
   *
   * <p>Method under test: {@link DoublesSketchSerialiser#preservesObjectOrdering()}
   */
  @Test
  @DisplayName("Test preservesObjectOrdering()")
  @Tag("MaintainedByDiffblue")
  void testPreservesObjectOrdering() {
    // Arrange, Act and Assert
    assertFalse(new DoublesSketchSerialiser().preservesObjectOrdering());
  }

  /**
   * Test {@link DoublesSketchSerialiser#equals(Object)}, and {@link
   * DoublesSketchSerialiser#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link DoublesSketchSerialiser#equals(Object)}
   *   <li>{@link DoublesSketchSerialiser#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    DoublesSketchSerialiser doublesSketchSerialiser = new DoublesSketchSerialiser();
    DoublesSketchSerialiser doublesSketchSerialiser2 = new DoublesSketchSerialiser();

    // Act and Assert
    assertEquals(doublesSketchSerialiser, doublesSketchSerialiser2);
    assertEquals(doublesSketchSerialiser.hashCode(), doublesSketchSerialiser2.hashCode());
  }

  /**
   * Test {@link DoublesSketchSerialiser#equals(Object)}, and {@link
   * DoublesSketchSerialiser#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link DoublesSketchSerialiser#equals(Object)}
   *   <li>{@link DoublesSketchSerialiser#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    DoublesSketchSerialiser doublesSketchSerialiser = new DoublesSketchSerialiser();

    // Act and Assert
    assertEquals(doublesSketchSerialiser, doublesSketchSerialiser);
    int expectedHashCodeResult = doublesSketchSerialiser.hashCode();
    assertEquals(expectedHashCodeResult, doublesSketchSerialiser.hashCode());
  }

  /**
   * Test {@link DoublesSketchSerialiser#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DoublesSketchSerialiser#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new DoublesSketchSerialiser(), 1);
  }

  /**
   * Test {@link DoublesSketchSerialiser#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DoublesSketchSerialiser#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new DoublesSketchSerialiser(), null);
  }

  /**
   * Test {@link DoublesSketchSerialiser#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DoublesSketchSerialiser#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new DoublesSketchSerialiser(), "Different type to DoublesSketchSerialiser");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link DoublesSketchSerialiser}
   *   <li>{@link DoublesSketchSerialiser#isConsistent()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertFalse(new DoublesSketchSerialiser().isConsistent());
  }
}
