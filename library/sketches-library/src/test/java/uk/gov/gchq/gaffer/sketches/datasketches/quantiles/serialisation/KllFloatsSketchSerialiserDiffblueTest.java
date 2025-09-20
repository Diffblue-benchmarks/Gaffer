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
import org.apache.datasketches.kll.KllFloatsSketch;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.exception.SerialisationException;

class KllFloatsSketchSerialiserDiffblueTest {
  /**
   * Test {@link KllFloatsSketchSerialiser#canHandle(Class)}.
   *
   * <ul>
   *   <li>When {@code Object}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link KllFloatsSketchSerialiser#canHandle(Class)}
   */
  @Test
  @DisplayName("Test canHandle(Class); when 'java.lang.Object'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  void testCanHandle_whenJavaLangObject_thenReturnFalse() {
    // Arrange
    KllFloatsSketchSerialiser kllFloatsSketchSerialiser = new KllFloatsSketchSerialiser();
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertFalse(kllFloatsSketchSerialiser.canHandle(clazz));
  }

  /**
   * Test {@link KllFloatsSketchSerialiser#canHandle(Class)}.
   *
   * <ul>
   *   <li>When {@code KllFloatsSketch}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link KllFloatsSketchSerialiser#canHandle(Class)}
   */
  @Test
  @DisplayName(
      "Test canHandle(Class); when 'org.apache.datasketches.kll.KllFloatsSketch'; then return 'true'")
  @Tag("MaintainedByDiffblue")
  void testCanHandle_whenOrgApacheDatasketchesKllKllFloatsSketch_thenReturnTrue() {
    // Arrange
    KllFloatsSketchSerialiser kllFloatsSketchSerialiser = new KllFloatsSketchSerialiser();
    Class<KllFloatsSketch> clazz = KllFloatsSketch.class;

    // Act and Assert
    assertTrue(kllFloatsSketchSerialiser.canHandle(clazz));
  }

  /**
   * Test {@link KllFloatsSketchSerialiser#serialise(KllFloatsSketch)} with {@code KllFloatsSketch}.
   *
   * <p>Method under test: {@link KllFloatsSketchSerialiser#serialise(KllFloatsSketch)}
   */
  @Test
  @DisplayName("Test serialise(KllFloatsSketch) with 'KllFloatsSketch'")
  @Tag("MaintainedByDiffblue")
  void testSerialiseWithKllFloatsSketch()
      throws UnsupportedEncodingException, SerialisationException {
    // Arrange
    KllFloatsSketchSerialiser kllFloatsSketchSerialiser = new KllFloatsSketchSerialiser();

    KllFloatsSketch sketch = mock(KllFloatsSketch.class);
    when(sketch.toByteArray()).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    byte[] actualSerialiseResult = kllFloatsSketchSerialiser.serialise(sketch);

    // Assert
    verify(sketch).toByteArray();
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualSerialiseResult);
  }

  /**
   * Test {@link KllFloatsSketchSerialiser#deserialiseEmpty()}.
   *
   * <p>Method under test: {@link KllFloatsSketchSerialiser#deserialiseEmpty()}
   */
  @Test
  @DisplayName("Test deserialiseEmpty()")
  @Tag("MaintainedByDiffblue")
  void testDeserialiseEmpty() throws SerialisationException {
    // Arrange, Act and Assert
    assertNull(new KllFloatsSketchSerialiser().deserialiseEmpty());
  }

  /**
   * Test {@link KllFloatsSketchSerialiser#preservesObjectOrdering()}.
   *
   * <p>Method under test: {@link KllFloatsSketchSerialiser#preservesObjectOrdering()}
   */
  @Test
  @DisplayName("Test preservesObjectOrdering()")
  @Tag("MaintainedByDiffblue")
  void testPreservesObjectOrdering() {
    // Arrange, Act and Assert
    assertFalse(new KllFloatsSketchSerialiser().preservesObjectOrdering());
  }

  /**
   * Test {@link KllFloatsSketchSerialiser#equals(Object)}, and {@link
   * KllFloatsSketchSerialiser#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link KllFloatsSketchSerialiser#equals(Object)}
   *   <li>{@link KllFloatsSketchSerialiser#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    KllFloatsSketchSerialiser kllFloatsSketchSerialiser = new KllFloatsSketchSerialiser();
    KllFloatsSketchSerialiser kllFloatsSketchSerialiser2 = new KllFloatsSketchSerialiser();

    // Act and Assert
    assertEquals(kllFloatsSketchSerialiser, kllFloatsSketchSerialiser2);
    assertEquals(kllFloatsSketchSerialiser.hashCode(), kllFloatsSketchSerialiser2.hashCode());
  }

  /**
   * Test {@link KllFloatsSketchSerialiser#equals(Object)}, and {@link
   * KllFloatsSketchSerialiser#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link KllFloatsSketchSerialiser#equals(Object)}
   *   <li>{@link KllFloatsSketchSerialiser#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    KllFloatsSketchSerialiser kllFloatsSketchSerialiser = new KllFloatsSketchSerialiser();

    // Act and Assert
    assertEquals(kllFloatsSketchSerialiser, kllFloatsSketchSerialiser);
    int expectedHashCodeResult = kllFloatsSketchSerialiser.hashCode();
    assertEquals(expectedHashCodeResult, kllFloatsSketchSerialiser.hashCode());
  }

  /**
   * Test {@link KllFloatsSketchSerialiser#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link KllFloatsSketchSerialiser#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new KllFloatsSketchSerialiser(), 1);
  }

  /**
   * Test {@link KllFloatsSketchSerialiser#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link KllFloatsSketchSerialiser#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new KllFloatsSketchSerialiser(), null);
  }

  /**
   * Test {@link KllFloatsSketchSerialiser#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link KllFloatsSketchSerialiser#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new KllFloatsSketchSerialiser(), "Different type to KllFloatsSketchSerialiser");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link KllFloatsSketchSerialiser}
   *   <li>{@link KllFloatsSketchSerialiser#isConsistent()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertFalse(new KllFloatsSketchSerialiser().isConsistent());
  }
}
