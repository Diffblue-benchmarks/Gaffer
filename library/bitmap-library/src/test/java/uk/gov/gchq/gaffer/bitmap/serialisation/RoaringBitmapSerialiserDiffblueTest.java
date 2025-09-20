package uk.gov.gchq.gaffer.bitmap.serialisation;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.roaringbitmap.RoaringBitmap;
import uk.gov.gchq.gaffer.exception.SerialisationException;

class RoaringBitmapSerialiserDiffblueTest {
  /**
   * Test {@link RoaringBitmapSerialiser#canHandle(Class)}.
   *
   * <ul>
   *   <li>When {@code Object}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link RoaringBitmapSerialiser#canHandle(Class)}
   */
  @Test
  @DisplayName("Test canHandle(Class); when 'java.lang.Object'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  void testCanHandle_whenJavaLangObject_thenReturnFalse() {
    // Arrange
    RoaringBitmapSerialiser roaringBitmapSerialiser = new RoaringBitmapSerialiser();
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertFalse(roaringBitmapSerialiser.canHandle(clazz));
  }

  /**
   * Test {@link RoaringBitmapSerialiser#canHandle(Class)}.
   *
   * <ul>
   *   <li>When {@code RoaringBitmap}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link RoaringBitmapSerialiser#canHandle(Class)}
   */
  @Test
  @DisplayName("Test canHandle(Class); when 'org.roaringbitmap.RoaringBitmap'; then return 'true'")
  @Tag("MaintainedByDiffblue")
  void testCanHandle_whenOrgRoaringbitmapRoaringBitmap_thenReturnTrue() {
    // Arrange
    RoaringBitmapSerialiser roaringBitmapSerialiser = new RoaringBitmapSerialiser();
    Class<RoaringBitmap> clazz = RoaringBitmap.class;

    // Act and Assert
    assertTrue(roaringBitmapSerialiser.canHandle(clazz));
  }

  /**
   * Test {@link RoaringBitmapSerialiser#serialise(RoaringBitmap)} with {@code RoaringBitmap}.
   *
   * <ul>
   *   <li>Given {@link Integer#MIN_VALUE}.
   *   <li>Then return {@code 462843} element is minus one.
   * </ul>
   *
   * <p>Method under test: {@link RoaringBitmapSerialiser#serialise(RoaringBitmap)}
   */
  @Test
  @DisplayName(
      "Test serialise(RoaringBitmap) with 'RoaringBitmap'; given MIN_VALUE; then return '462843' element is minus one")
  @Tag("MaintainedByDiffblue")
  void testSerialiseWithRoaringBitmap_givenMin_value_thenReturn462843ElementIsMinusOne()
      throws SerialisationException {
    // Arrange
    RoaringBitmapSerialiser roaringBitmapSerialiser = new RoaringBitmapSerialiser();

    RoaringBitmap object = new RoaringBitmap();
    object.add(Integer.MIN_VALUE, 0);
    object.add(1, 2);
    object.add(2);

    // Act
    byte[] actualSerialiseResult = roaringBitmapSerialiser.serialise(object);

    // Assert
    assertEquals((byte) -1, actualSerialiseResult[462842]);
    assertEquals((byte) -1, actualSerialiseResult[462847]);
    assertEquals((byte) -1, actualSerialiseResult[462848]);
    assertEquals((byte) -1, actualSerialiseResult[462853]);
    assertEquals((byte) -1, actualSerialiseResult[462854]);
    assertEquals((byte) -1, actualSerialiseResult[462859]);
    assertEquals((byte) -1, actualSerialiseResult[462860]);
    assertEquals((byte) -1, actualSerialiseResult[462865]);
    assertEquals((byte) -1, actualSerialiseResult[462866]);
    assertEquals((byte) 0, actualSerialiseResult[462844]);
    assertEquals((byte) 0, actualSerialiseResult[462845]);
    assertEquals((byte) 0, actualSerialiseResult[462846]);
    assertEquals((byte) 0, actualSerialiseResult[462850]);
    assertEquals((byte) 0, actualSerialiseResult[462851]);
    assertEquals((byte) 0, actualSerialiseResult[462852]);
    assertEquals((byte) 0, actualSerialiseResult[462856]);
    assertEquals((byte) 0, actualSerialiseResult[462857]);
    assertEquals((byte) 0, actualSerialiseResult[462858]);
    assertEquals((byte) 0, actualSerialiseResult[462862]);
    assertEquals((byte) 0, actualSerialiseResult[462863]);
    assertEquals((byte) 0, actualSerialiseResult[462864]);
    assertEquals((byte) 1, actualSerialiseResult[462843]);
    assertEquals((byte) 1, actualSerialiseResult[462849]);
    assertEquals((byte) 1, actualSerialiseResult[462855]);
    assertEquals((byte) 1, actualSerialiseResult[462861]);
    assertEquals(462867, actualSerialiseResult.length);
  }

  /**
   * Test {@link RoaringBitmapSerialiser#serialise(RoaringBitmap)} with {@code RoaringBitmap}.
   *
   * <ul>
   *   <li>Given minus one.
   *   <li>Then return {@code 471029} element is minus one.
   * </ul>
   *
   * <p>Method under test: {@link RoaringBitmapSerialiser#serialise(RoaringBitmap)}
   */
  @Test
  @DisplayName(
      "Test serialise(RoaringBitmap) with 'RoaringBitmap'; given minus one; then return '471029' element is minus one")
  @Tag("MaintainedByDiffblue")
  void testSerialiseWithRoaringBitmap_givenMinusOne_thenReturn471029ElementIsMinusOne()
      throws SerialisationException {
    // Arrange
    RoaringBitmapSerialiser roaringBitmapSerialiser = new RoaringBitmapSerialiser();

    RoaringBitmap object = new RoaringBitmap();
    object.add(-1);
    object.add(Integer.MIN_VALUE, 0);
    object.add(1, 2);
    object.add(2);

    // Act
    byte[] actualSerialiseResult = roaringBitmapSerialiser.serialise(object);

    // Assert
    assertEquals((byte) -1, actualSerialiseResult[471028]);
    assertEquals((byte) -1, actualSerialiseResult[471029]);
    assertEquals((byte) -1, actualSerialiseResult[471030]);
    assertEquals((byte) -1, actualSerialiseResult[471031]);
    assertEquals((byte) -1, actualSerialiseResult[471032]);
    assertEquals((byte) -1, actualSerialiseResult[471033]);
    assertEquals((byte) -1, actualSerialiseResult[471034]);
    assertEquals((byte) -1, actualSerialiseResult[471035]);
    assertEquals((byte) -1, actualSerialiseResult[471036]);
    assertEquals((byte) -1, actualSerialiseResult[471037]);
    assertEquals((byte) -1, actualSerialiseResult[471038]);
    assertEquals((byte) -1, actualSerialiseResult[471039]);
    assertEquals((byte) -1, actualSerialiseResult[471040]);
    assertEquals((byte) -1, actualSerialiseResult[471041]);
    assertEquals((byte) -1, actualSerialiseResult[471042]);
    assertEquals((byte) -1, actualSerialiseResult[471043]);
    assertEquals((byte) -1, actualSerialiseResult[471044]);
    assertEquals((byte) -1, actualSerialiseResult[471045]);
    assertEquals((byte) -1, actualSerialiseResult[471046]);
    assertEquals((byte) -1, actualSerialiseResult[471047]);
    assertEquals((byte) -1, actualSerialiseResult[471048]);
    assertEquals((byte) -1, actualSerialiseResult[471049]);
    assertEquals((byte) -1, actualSerialiseResult[471050]);
    assertEquals((byte) -1, actualSerialiseResult[471051]);
    assertEquals((byte) -1, actualSerialiseResult[471052]);
    assertEquals(471053, actualSerialiseResult.length);
  }

  /**
   * Test {@link RoaringBitmapSerialiser#serialise(RoaringBitmap)} with {@code RoaringBitmap}.
   *
   * <ul>
   *   <li>Given minus one.
   *   <li>When {@link RoaringBitmap} (default constructor) add minus one.
   * </ul>
   *
   * <p>Method under test: {@link RoaringBitmapSerialiser#serialise(RoaringBitmap)}
   */
  @Test
  @DisplayName(
      "Test serialise(RoaringBitmap) with 'RoaringBitmap'; given minus one; when RoaringBitmap (default constructor) add minus one")
  @Tag("MaintainedByDiffblue")
  void testSerialiseWithRoaringBitmap_givenMinusOne_whenRoaringBitmapAddMinusOne()
      throws SerialisationException {
    // Arrange
    RoaringBitmapSerialiser roaringBitmapSerialiser = new RoaringBitmapSerialiser();

    RoaringBitmap object = new RoaringBitmap();
    object.add(-1);
    object.add(1, 2);
    object.add(2);

    // Act and Assert
    assertArrayEquals(
        new byte[] {';', '0', 1, 0, 1, 0, 0, 1, 0, -1, -1, 0, 0, 1, 0, 1, 0, 1, 0, -1, -1},
        roaringBitmapSerialiser.serialise(object));
  }

  /**
   * Test {@link RoaringBitmapSerialiser#serialise(RoaringBitmap)} with {@code RoaringBitmap}.
   *
   * <ul>
   *   <li>Given two.
   *   <li>Then return array of {@code byte} with {@code :} and {@code 0}.
   * </ul>
   *
   * <p>Method under test: {@link RoaringBitmapSerialiser#serialise(RoaringBitmap)}
   */
  @Test
  @DisplayName(
      "Test serialise(RoaringBitmap) with 'RoaringBitmap'; given two; then return array of byte with ':' and '0'")
  @Tag("MaintainedByDiffblue")
  void testSerialiseWithRoaringBitmap_givenTwo_thenReturnArrayOfByteWithColonAnd0()
      throws SerialisationException {
    // Arrange
    RoaringBitmapSerialiser roaringBitmapSerialiser = new RoaringBitmapSerialiser();

    RoaringBitmap object = new RoaringBitmap();
    object.add(2);

    // Act and Assert
    assertArrayEquals(
        new byte[] {':', '0', 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 16, 0, 0, 0, 2, 0},
        roaringBitmapSerialiser.serialise(object));
  }

  /**
   * Test {@link RoaringBitmapSerialiser#serialise(RoaringBitmap)} with {@code RoaringBitmap}.
   *
   * <ul>
   *   <li>Then return array of {@code byte} with {@code ;} and {@code 0}.
   * </ul>
   *
   * <p>Method under test: {@link RoaringBitmapSerialiser#serialise(RoaringBitmap)}
   */
  @Test
  @DisplayName(
      "Test serialise(RoaringBitmap) with 'RoaringBitmap'; then return array of byte with ';' and '0'")
  @Tag("MaintainedByDiffblue")
  void testSerialiseWithRoaringBitmap_thenReturnArrayOfByteWithSemicolonAnd0()
      throws SerialisationException {
    // Arrange
    RoaringBitmapSerialiser roaringBitmapSerialiser = new RoaringBitmapSerialiser();

    RoaringBitmap object = new RoaringBitmap();
    object.add(1, 2);
    object.add(2);

    // Act and Assert
    assertArrayEquals(
        new byte[] {';', '0', 0, 0, 1, 0, 0, 1, 0, 1, 0, 1, 0, 1, 0},
        roaringBitmapSerialiser.serialise(object));
  }

  /**
   * Test {@link RoaringBitmapSerialiser#serialise(RoaringBitmap)} with {@code RoaringBitmap}.
   *
   * <ul>
   *   <li>When {@link RoaringBitmap} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link RoaringBitmapSerialiser#serialise(RoaringBitmap)}
   */
  @Test
  @DisplayName(
      "Test serialise(RoaringBitmap) with 'RoaringBitmap'; when RoaringBitmap (default constructor)")
  @Tag("MaintainedByDiffblue")
  void testSerialiseWithRoaringBitmap_whenRoaringBitmap() throws SerialisationException {
    // Arrange
    RoaringBitmapSerialiser roaringBitmapSerialiser = new RoaringBitmapSerialiser();

    // Act and Assert
    assertArrayEquals(
        new byte[] {':', '0', 0, 0, 0, 0, 0, 0},
        roaringBitmapSerialiser.serialise(new RoaringBitmap()));
  }

  /**
   * Test {@link RoaringBitmapSerialiser#serialise(RoaringBitmap)} with {@code RoaringBitmap}.
   *
   * <ul>
   *   <li>When {@link RoaringBitmap} (default constructor) add zero and one.
   * </ul>
   *
   * <p>Method under test: {@link RoaringBitmapSerialiser#serialise(RoaringBitmap)}
   */
  @Test
  @DisplayName(
      "Test serialise(RoaringBitmap) with 'RoaringBitmap'; when RoaringBitmap (default constructor) add zero and one")
  @Tag("MaintainedByDiffblue")
  void testSerialiseWithRoaringBitmap_whenRoaringBitmapAddZeroAndOne()
      throws SerialisationException {
    // Arrange
    RoaringBitmapSerialiser roaringBitmapSerialiser = new RoaringBitmapSerialiser();

    RoaringBitmap object = new RoaringBitmap();
    object.add(0, 1);
    object.add(2);

    // Act and Assert
    assertArrayEquals(
        new byte[] {';', '0', 0, 0, 1, 0, 0, 1, 0, 2, 0, 0, 0, 0, 0, 2, 0, 0, 0},
        roaringBitmapSerialiser.serialise(object));
  }

  /**
   * Test {@link RoaringBitmapSerialiser#preservesObjectOrdering()}.
   *
   * <p>Method under test: {@link RoaringBitmapSerialiser#preservesObjectOrdering()}
   */
  @Test
  @DisplayName("Test preservesObjectOrdering()")
  @Tag("MaintainedByDiffblue")
  void testPreservesObjectOrdering() {
    // Arrange, Act and Assert
    assertFalse(new RoaringBitmapSerialiser().preservesObjectOrdering());
  }

  /**
   * Test {@link RoaringBitmapSerialiser#deserialiseEmpty()}.
   *
   * <p>Method under test: {@link RoaringBitmapSerialiser#deserialiseEmpty()}
   */
  @Test
  @DisplayName("Test deserialiseEmpty()")
  @Tag("MaintainedByDiffblue")
  void testDeserialiseEmpty() {
    // Arrange and Act
    RoaringBitmap actualDeserialiseEmptyResult = new RoaringBitmapSerialiser().deserialiseEmpty();

    // Assert
    assertEquals(0, actualDeserialiseEmptyResult.getCardinality());
    assertEquals(8, actualDeserialiseEmptyResult.getSizeInBytes());
    assertFalse(actualDeserialiseEmptyResult.iterator().hasNext());
    assertFalse(actualDeserialiseEmptyResult.hasRunCompression());
    assertTrue(actualDeserialiseEmptyResult.isEmpty());
  }

  /**
   * Test {@link RoaringBitmapSerialiser#serialiseNull()}.
   *
   * <p>Method under test: {@link RoaringBitmapSerialiser#serialiseNull()}
   */
  @Test
  @DisplayName("Test serialiseNull()")
  @Tag("MaintainedByDiffblue")
  void testSerialiseNull() {
    // Arrange, Act and Assert
    assertArrayEquals(new byte[] {}, new RoaringBitmapSerialiser().serialiseNull());
  }

  /**
   * Test {@link RoaringBitmapSerialiser#equals(Object)}, and {@link
   * RoaringBitmapSerialiser#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link RoaringBitmapSerialiser#equals(Object)}
   *   <li>{@link RoaringBitmapSerialiser#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    RoaringBitmapSerialiser roaringBitmapSerialiser = new RoaringBitmapSerialiser();
    RoaringBitmapSerialiser roaringBitmapSerialiser2 = new RoaringBitmapSerialiser();

    // Act and Assert
    assertEquals(roaringBitmapSerialiser, roaringBitmapSerialiser2);
    assertEquals(roaringBitmapSerialiser.hashCode(), roaringBitmapSerialiser2.hashCode());
  }

  /**
   * Test {@link RoaringBitmapSerialiser#equals(Object)}, and {@link
   * RoaringBitmapSerialiser#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link RoaringBitmapSerialiser#equals(Object)}
   *   <li>{@link RoaringBitmapSerialiser#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    RoaringBitmapSerialiser roaringBitmapSerialiser = new RoaringBitmapSerialiser();

    // Act and Assert
    assertEquals(roaringBitmapSerialiser, roaringBitmapSerialiser);
    int expectedHashCodeResult = roaringBitmapSerialiser.hashCode();
    assertEquals(expectedHashCodeResult, roaringBitmapSerialiser.hashCode());
  }

  /**
   * Test {@link RoaringBitmapSerialiser#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RoaringBitmapSerialiser#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new RoaringBitmapSerialiser(), 1);
  }

  /**
   * Test {@link RoaringBitmapSerialiser#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RoaringBitmapSerialiser#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new RoaringBitmapSerialiser(), null);
  }

  /**
   * Test {@link RoaringBitmapSerialiser#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RoaringBitmapSerialiser#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new RoaringBitmapSerialiser(), "Different type to RoaringBitmapSerialiser");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link RoaringBitmapSerialiser}
   *   <li>{@link RoaringBitmapSerialiser#isConsistent()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertFalse(new RoaringBitmapSerialiser().isConsistent());
  }
}
