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
import java.io.UnsupportedEncodingException;
import org.apache.datasketches.theta.CompactSketch;
import org.apache.datasketches.theta.Union;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.exception.SerialisationException;

class UnionSerialiserDiffblueTest {
  /**
   * Test {@link UnionSerialiser#canHandle(Class)}.
   *
   * <ul>
   *   <li>When {@code Object}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link UnionSerialiser#canHandle(Class)}
   */
  @Test
  @DisplayName("Test canHandle(Class); when 'java.lang.Object'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  void testCanHandle_whenJavaLangObject_thenReturnFalse() {
    // Arrange
    UnionSerialiser unionSerialiser = new UnionSerialiser();
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertFalse(unionSerialiser.canHandle(clazz));
  }

  /**
   * Test {@link UnionSerialiser#canHandle(Class)}.
   *
   * <ul>
   *   <li>When {@code Union}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link UnionSerialiser#canHandle(Class)}
   */
  @Test
  @DisplayName(
      "Test canHandle(Class); when 'org.apache.datasketches.theta.Union'; then return 'true'")
  @Tag("MaintainedByDiffblue")
  void testCanHandle_whenOrgApacheDatasketchesThetaUnion_thenReturnTrue() {
    // Arrange
    UnionSerialiser unionSerialiser = new UnionSerialiser();
    Class<Union> clazz = Union.class;

    // Act and Assert
    assertTrue(unionSerialiser.canHandle(clazz));
  }

  /**
   * Test {@link UnionSerialiser#serialise(Union)} with {@code Union}.
   *
   * <p>Method under test: {@link UnionSerialiser#serialise(Union)}
   */
  @Test
  @DisplayName("Test serialise(Union) with 'Union'")
  @Tag("MaintainedByDiffblue")
  void testSerialiseWithUnion() throws UnsupportedEncodingException, SerialisationException {
    // Arrange
    UnionSerialiser unionSerialiser = new UnionSerialiser();

    CompactSketch compactSketch = mock(CompactSketch.class);
    when(compactSketch.toByteArray()).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    Union union = mock(Union.class);
    when(union.getResult()).thenReturn(compactSketch);

    // Act
    byte[] actualSerialiseResult = unionSerialiser.serialise(union);

    // Assert
    verify(compactSketch).toByteArray();
    verify(union).getResult();
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualSerialiseResult);
  }

  /**
   * Test {@link UnionSerialiser#deserialiseEmpty()}.
   *
   * <p>Method under test: {@link UnionSerialiser#deserialiseEmpty()}
   */
  @Test
  @DisplayName("Test deserialiseEmpty()")
  @Tag("MaintainedByDiffblue")
  void testDeserialiseEmpty() throws SerialisationException {
    // Arrange, Act and Assert
    assertNull(new UnionSerialiser().deserialiseEmpty());
  }

  /**
   * Test {@link UnionSerialiser#preservesObjectOrdering()}.
   *
   * <p>Method under test: {@link UnionSerialiser#preservesObjectOrdering()}
   */
  @Test
  @DisplayName("Test preservesObjectOrdering()")
  @Tag("MaintainedByDiffblue")
  void testPreservesObjectOrdering() {
    // Arrange, Act and Assert
    assertFalse(new UnionSerialiser().preservesObjectOrdering());
  }

  /**
   * Test {@link UnionSerialiser#equals(Object)}, and {@link UnionSerialiser#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link UnionSerialiser#equals(Object)}
   *   <li>{@link UnionSerialiser#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    UnionSerialiser unionSerialiser = new UnionSerialiser();
    UnionSerialiser unionSerialiser2 = new UnionSerialiser();

    // Act and Assert
    assertEquals(unionSerialiser, unionSerialiser2);
    assertEquals(unionSerialiser.hashCode(), unionSerialiser2.hashCode());
  }

  /**
   * Test {@link UnionSerialiser#equals(Object)}, and {@link UnionSerialiser#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link UnionSerialiser#equals(Object)}
   *   <li>{@link UnionSerialiser#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    UnionSerialiser unionSerialiser = new UnionSerialiser();

    // Act and Assert
    assertEquals(unionSerialiser, unionSerialiser);
    int expectedHashCodeResult = unionSerialiser.hashCode();
    assertEquals(expectedHashCodeResult, unionSerialiser.hashCode());
  }

  /**
   * Test {@link UnionSerialiser#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link UnionSerialiser#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new UnionSerialiser(), 1);
  }

  /**
   * Test {@link UnionSerialiser#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link UnionSerialiser#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new UnionSerialiser(), null);
  }

  /**
   * Test {@link UnionSerialiser#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link UnionSerialiser#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new UnionSerialiser(), "Different type to UnionSerialiser");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link UnionSerialiser}
   *   <li>{@link UnionSerialiser#isConsistent()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertFalse(new UnionSerialiser().isConsistent());
  }
}
