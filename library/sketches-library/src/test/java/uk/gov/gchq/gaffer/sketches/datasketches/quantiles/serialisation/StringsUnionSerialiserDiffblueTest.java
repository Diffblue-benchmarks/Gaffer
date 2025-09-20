package uk.gov.gchq.gaffer.sketches.datasketches.quantiles.serialisation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.apache.datasketches.quantiles.ItemsUnion;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.exception.SerialisationException;

class StringsUnionSerialiserDiffblueTest {
  /**
   * Test {@link StringsUnionSerialiser#canHandle(Class)}.
   *
   * <ul>
   *   <li>When {@code Object}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link StringsUnionSerialiser#canHandle(Class)}
   */
  @Test
  @DisplayName("Test canHandle(Class); when 'java.lang.Object'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  void testCanHandle_whenJavaLangObject_thenReturnFalse() {
    // Arrange
    StringsUnionSerialiser stringsUnionSerialiser = new StringsUnionSerialiser();
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertFalse(stringsUnionSerialiser.canHandle(clazz));
  }

  /**
   * Test {@link StringsUnionSerialiser#canHandle(Class)}.
   *
   * <ul>
   *   <li>When {@code ItemsUnion}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link StringsUnionSerialiser#canHandle(Class)}
   */
  @Test
  @DisplayName(
      "Test canHandle(Class); when 'org.apache.datasketches.quantiles.ItemsUnion'; then return 'true'")
  @Tag("MaintainedByDiffblue")
  void testCanHandle_whenOrgApacheDatasketchesQuantilesItemsUnion_thenReturnTrue() {
    // Arrange
    StringsUnionSerialiser stringsUnionSerialiser = new StringsUnionSerialiser();
    Class<ItemsUnion> clazz = ItemsUnion.class;

    // Act and Assert
    assertTrue(stringsUnionSerialiser.canHandle(clazz));
  }

  /**
   * Test {@link StringsUnionSerialiser#deserialiseEmpty()}.
   *
   * <p>Method under test: {@link StringsUnionSerialiser#deserialiseEmpty()}
   */
  @Test
  @DisplayName("Test deserialiseEmpty()")
  @Tag("MaintainedByDiffblue")
  void testDeserialiseEmpty() throws SerialisationException {
    // Arrange, Act and Assert
    assertNull(new StringsUnionSerialiser().deserialiseEmpty());
  }

  /**
   * Test {@link StringsUnionSerialiser#preservesObjectOrdering()}.
   *
   * <p>Method under test: {@link StringsUnionSerialiser#preservesObjectOrdering()}
   */
  @Test
  @DisplayName("Test preservesObjectOrdering()")
  @Tag("MaintainedByDiffblue")
  void testPreservesObjectOrdering() {
    // Arrange, Act and Assert
    assertFalse(new StringsUnionSerialiser().preservesObjectOrdering());
  }

  /**
   * Test {@link StringsUnionSerialiser#equals(Object)}, and {@link
   * StringsUnionSerialiser#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link StringsUnionSerialiser#equals(Object)}
   *   <li>{@link StringsUnionSerialiser#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    StringsUnionSerialiser stringsUnionSerialiser = new StringsUnionSerialiser();
    StringsUnionSerialiser stringsUnionSerialiser2 = new StringsUnionSerialiser();

    // Act and Assert
    assertEquals(stringsUnionSerialiser, stringsUnionSerialiser2);
    assertEquals(stringsUnionSerialiser.hashCode(), stringsUnionSerialiser2.hashCode());
  }

  /**
   * Test {@link StringsUnionSerialiser#equals(Object)}, and {@link
   * StringsUnionSerialiser#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link StringsUnionSerialiser#equals(Object)}
   *   <li>{@link StringsUnionSerialiser#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    StringsUnionSerialiser stringsUnionSerialiser = new StringsUnionSerialiser();

    // Act and Assert
    assertEquals(stringsUnionSerialiser, stringsUnionSerialiser);
    int expectedHashCodeResult = stringsUnionSerialiser.hashCode();
    assertEquals(expectedHashCodeResult, stringsUnionSerialiser.hashCode());
  }

  /**
   * Test {@link StringsUnionSerialiser#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link StringsUnionSerialiser#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new StringsUnionSerialiser(), 1);
  }

  /**
   * Test {@link StringsUnionSerialiser#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link StringsUnionSerialiser#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new StringsUnionSerialiser(), null);
  }

  /**
   * Test {@link StringsUnionSerialiser#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link StringsUnionSerialiser#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new StringsUnionSerialiser(), "Different type to StringsUnionSerialiser");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link StringsUnionSerialiser}
   *   <li>{@link StringsUnionSerialiser#isConsistent()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertFalse(new StringsUnionSerialiser().isConsistent());
  }
}
