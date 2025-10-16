package uk.gov.gchq.gaffer.sketches.datasketches.theta.serialisation;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.UnsupportedEncodingException;
import org.apache.datasketches.theta.Sketch;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.exception.SerialisationException;

class SketchSerialiserDiffblueTest {
  /**
   * Test {@link SketchSerialiser#canHandle(Class)}.
   *
   * <ul>
   *   <li>When {@code Object}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link SketchSerialiser#canHandle(Class)}
   */
  @Test
  @DisplayName("Test canHandle(Class); when 'java.lang.Object'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SketchSerialiser.canHandle(Class)"})
  void testCanHandle_whenJavaLangObject_thenReturnFalse() {
    // Arrange
    SketchSerialiser sketchSerialiser = new SketchSerialiser();
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertFalse(sketchSerialiser.canHandle(clazz));
  }

  /**
   * Test {@link SketchSerialiser#canHandle(Class)}.
   *
   * <ul>
   *   <li>When {@code Sketch}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link SketchSerialiser#canHandle(Class)}
   */
  @Test
  @DisplayName(
      "Test canHandle(Class); when 'org.apache.datasketches.theta.Sketch'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SketchSerialiser.canHandle(Class)"})
  void testCanHandle_whenOrgApacheDatasketchesThetaSketch_thenReturnTrue() {
    // Arrange
    SketchSerialiser sketchSerialiser = new SketchSerialiser();
    Class<Sketch> clazz = Sketch.class;

    // Act and Assert
    assertTrue(sketchSerialiser.canHandle(clazz));
  }

  /**
   * Test {@link SketchSerialiser#serialise(Sketch)} with {@code Sketch}.
   *
   * <p>Method under test: {@link SketchSerialiser#serialise(Sketch)}
   */
  @Test
  @DisplayName("Test serialise(Sketch) with 'Sketch'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] SketchSerialiser.serialise(Sketch)"})
  void testSerialiseWithSketch() throws UnsupportedEncodingException, SerialisationException {
    // Arrange
    SketchSerialiser sketchSerialiser = new SketchSerialiser();

    Sketch sketch = mock(Sketch.class);
    when(sketch.toByteArray()).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    byte[] actualSerialiseResult = sketchSerialiser.serialise(sketch);

    // Assert
    verify(sketch).toByteArray();
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualSerialiseResult);
  }

  /**
   * Test {@link SketchSerialiser#deserialiseEmpty()}.
   *
   * <p>Method under test: {@link SketchSerialiser#deserialiseEmpty()}
   */
  @Test
  @DisplayName("Test deserialiseEmpty()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Sketch SketchSerialiser.deserialiseEmpty()"})
  void testDeserialiseEmpty() throws SerialisationException {
    // Arrange, Act and Assert
    assertNull(new SketchSerialiser().deserialiseEmpty());
  }

  /**
   * Test {@link SketchSerialiser#preservesObjectOrdering()}.
   *
   * <p>Method under test: {@link SketchSerialiser#preservesObjectOrdering()}
   */
  @Test
  @DisplayName("Test preservesObjectOrdering()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SketchSerialiser.preservesObjectOrdering()"})
  void testPreservesObjectOrdering() {
    // Arrange, Act and Assert
    assertFalse(new SketchSerialiser().preservesObjectOrdering());
  }

  /**
   * Test {@link SketchSerialiser#equals(Object)}, and {@link SketchSerialiser#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link SketchSerialiser#equals(Object)}
   *   <li>{@link SketchSerialiser#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SketchSerialiser.equals(Object)", "int SketchSerialiser.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    SketchSerialiser sketchSerialiser = new SketchSerialiser();
    SketchSerialiser sketchSerialiser2 = new SketchSerialiser();

    // Act and Assert
    assertEquals(sketchSerialiser, sketchSerialiser2);
    assertEquals(sketchSerialiser.hashCode(), sketchSerialiser2.hashCode());
  }

  /**
   * Test {@link SketchSerialiser#equals(Object)}, and {@link SketchSerialiser#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link SketchSerialiser#equals(Object)}
   *   <li>{@link SketchSerialiser#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SketchSerialiser.equals(Object)", "int SketchSerialiser.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    SketchSerialiser sketchSerialiser = new SketchSerialiser();

    // Act and Assert
    assertEquals(sketchSerialiser, sketchSerialiser);
    int expectedHashCodeResult = sketchSerialiser.hashCode();
    assertEquals(expectedHashCodeResult, sketchSerialiser.hashCode());
  }

  /**
   * Test {@link SketchSerialiser#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SketchSerialiser#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SketchSerialiser.equals(Object)", "int SketchSerialiser.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new SketchSerialiser(), 1);
  }

  /**
   * Test {@link SketchSerialiser#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SketchSerialiser#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SketchSerialiser.equals(Object)", "int SketchSerialiser.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new SketchSerialiser(), null);
  }

  /**
   * Test {@link SketchSerialiser#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SketchSerialiser#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SketchSerialiser.equals(Object)", "int SketchSerialiser.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new SketchSerialiser(), "Different type to SketchSerialiser");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link SketchSerialiser}
   *   <li>{@link SketchSerialiser#isConsistent()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SketchSerialiser.<init>()", "boolean SketchSerialiser.isConsistent()"})
  void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertFalse(new SketchSerialiser().isConsistent());
  }
}
