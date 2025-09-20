package uk.gov.gchq.gaffer.sketches.datasketches.frequencies.serialisation;

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
import org.apache.datasketches.frequencies.LongsSketch;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.exception.SerialisationException;

class LongsSketchSerialiserDiffblueTest {
  /**
   * Test {@link LongsSketchSerialiser#canHandle(Class)}.
   *
   * <ul>
   *   <li>When {@code Object}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link LongsSketchSerialiser#canHandle(Class)}
   */
  @Test
  @DisplayName("Test canHandle(Class); when 'java.lang.Object'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  void testCanHandle_whenJavaLangObject_thenReturnFalse() {
    // Arrange
    LongsSketchSerialiser longsSketchSerialiser = new LongsSketchSerialiser();
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertFalse(longsSketchSerialiser.canHandle(clazz));
  }

  /**
   * Test {@link LongsSketchSerialiser#canHandle(Class)}.
   *
   * <ul>
   *   <li>When {@code LongsSketch}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link LongsSketchSerialiser#canHandle(Class)}
   */
  @Test
  @DisplayName(
      "Test canHandle(Class); when 'org.apache.datasketches.frequencies.LongsSketch'; then return 'true'")
  @Tag("MaintainedByDiffblue")
  void testCanHandle_whenOrgApacheDatasketchesFrequenciesLongsSketch_thenReturnTrue() {
    // Arrange
    LongsSketchSerialiser longsSketchSerialiser = new LongsSketchSerialiser();
    Class<LongsSketch> clazz = LongsSketch.class;

    // Act and Assert
    assertTrue(longsSketchSerialiser.canHandle(clazz));
  }

  /**
   * Test {@link LongsSketchSerialiser#serialise(LongsSketch)} with {@code LongsSketch}.
   *
   * <ul>
   *   <li>Then return {@code AXAXAXAX} Bytes is {@code UTF-8}.
   * </ul>
   *
   * <p>Method under test: {@link LongsSketchSerialiser#serialise(LongsSketch)}
   */
  @Test
  @DisplayName(
      "Test serialise(LongsSketch) with 'LongsSketch'; then return 'AXAXAXAX' Bytes is 'UTF-8'")
  @Tag("MaintainedByDiffblue")
  void testSerialiseWithLongsSketch_thenReturnAxaxaxaxBytesIsUtf8()
      throws UnsupportedEncodingException, SerialisationException {
    // Arrange
    LongsSketchSerialiser longsSketchSerialiser = new LongsSketchSerialiser();

    LongsSketch sketch = mock(LongsSketch.class);
    when(sketch.toByteArray()).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    byte[] actualSerialiseResult = longsSketchSerialiser.serialise(sketch);

    // Assert
    verify(sketch).toByteArray();
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualSerialiseResult);
  }

  /**
   * Test {@link LongsSketchSerialiser#deserialiseEmpty()}.
   *
   * <p>Method under test: {@link LongsSketchSerialiser#deserialiseEmpty()}
   */
  @Test
  @DisplayName("Test deserialiseEmpty()")
  @Tag("MaintainedByDiffblue")
  void testDeserialiseEmpty() throws SerialisationException {
    // Arrange, Act and Assert
    assertNull(new LongsSketchSerialiser().deserialiseEmpty());
  }

  /**
   * Test {@link LongsSketchSerialiser#preservesObjectOrdering()}.
   *
   * <p>Method under test: {@link LongsSketchSerialiser#preservesObjectOrdering()}
   */
  @Test
  @DisplayName("Test preservesObjectOrdering()")
  @Tag("MaintainedByDiffblue")
  void testPreservesObjectOrdering() {
    // Arrange, Act and Assert
    assertFalse(new LongsSketchSerialiser().preservesObjectOrdering());
  }

  /**
   * Test {@link LongsSketchSerialiser#equals(Object)}, and {@link
   * LongsSketchSerialiser#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link LongsSketchSerialiser#equals(Object)}
   *   <li>{@link LongsSketchSerialiser#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    LongsSketchSerialiser longsSketchSerialiser = new LongsSketchSerialiser();
    LongsSketchSerialiser longsSketchSerialiser2 = new LongsSketchSerialiser();

    // Act and Assert
    assertEquals(longsSketchSerialiser, longsSketchSerialiser2);
    assertEquals(longsSketchSerialiser.hashCode(), longsSketchSerialiser2.hashCode());
  }

  /**
   * Test {@link LongsSketchSerialiser#equals(Object)}, and {@link
   * LongsSketchSerialiser#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link LongsSketchSerialiser#equals(Object)}
   *   <li>{@link LongsSketchSerialiser#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    LongsSketchSerialiser longsSketchSerialiser = new LongsSketchSerialiser();

    // Act and Assert
    assertEquals(longsSketchSerialiser, longsSketchSerialiser);
    int expectedHashCodeResult = longsSketchSerialiser.hashCode();
    assertEquals(expectedHashCodeResult, longsSketchSerialiser.hashCode());
  }

  /**
   * Test {@link LongsSketchSerialiser#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link LongsSketchSerialiser#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new LongsSketchSerialiser(), 1);
  }

  /**
   * Test {@link LongsSketchSerialiser#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link LongsSketchSerialiser#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new LongsSketchSerialiser(), null);
  }

  /**
   * Test {@link LongsSketchSerialiser#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link LongsSketchSerialiser#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new LongsSketchSerialiser(), "Different type to LongsSketchSerialiser");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link LongsSketchSerialiser}
   *   <li>{@link LongsSketchSerialiser#isConsistent()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertFalse(new LongsSketchSerialiser().isConsistent());
  }
}
