package uk.gov.gchq.gaffer.serialisation.implementation;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.io.UnsupportedEncodingException;
import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.exception.SerialisationException;
import uk.gov.gchq.gaffer.serialisation.ToBytesSerialiser;

class SetSerialiserDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>Then ObjectSerialiser return {@link BooleanSerialiser}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link SetSerialiser#SetSerialiser()}
   *   <li>{@link SetSerialiser#setObjectSerialiser(ToBytesSerialiser)}
   *   <li>{@link SetSerialiser#setSetClass(Class)}
   *   <li>{@link SetSerialiser#getObjectSerialiser()}
   *   <li>{@link SetSerialiser#getSetClass()}
   *   <li>{@link SetSerialiser#isConsistent()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; then ObjectSerialiser return BooleanSerialiser")
  @Tag("MaintainedByDiffblue")
  void testGettersAndSetters_thenObjectSerialiserReturnBooleanSerialiser() {
    // Arrange and Act
    SetSerialiser actualSetSerialiser = new SetSerialiser();
    BooleanSerialiser objectSerialiser = new BooleanSerialiser();
    actualSetSerialiser.setObjectSerialiser(objectSerialiser);
    Class<Set> setClass = Set.class;
    actualSetSerialiser.setSetClass(setClass);
    ToBytesSerialiser actualObjectSerialiser = actualSetSerialiser.getObjectSerialiser();
    Class<? extends Set> actualSetClass = actualSetSerialiser.getSetClass();

    // Assert
    assertTrue(actualObjectSerialiser instanceof BooleanSerialiser);
    assertFalse(actualSetSerialiser.isConsistent());
    Class<Set> expectedSetClass = Set.class;
    assertEquals(expectedSetClass, actualSetClass);
    assertSame(objectSerialiser, actualObjectSerialiser);
    assertSame(setClass, actualSetClass);
  }

  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>When {@link BooleanSerialiser} (default constructor).
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link SetSerialiser#SetSerialiser(ToBytesSerialiser)}
   *   <li>{@link SetSerialiser#setObjectSerialiser(ToBytesSerialiser)}
   *   <li>{@link SetSerialiser#setSetClass(Class)}
   *   <li>{@link SetSerialiser#getObjectSerialiser()}
   *   <li>{@link SetSerialiser#getSetClass()}
   *   <li>{@link SetSerialiser#isConsistent()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; when BooleanSerialiser (default constructor)")
  @Tag("MaintainedByDiffblue")
  void testGettersAndSetters_whenBooleanSerialiser() {
    // Arrange and Act
    SetSerialiser actualSetSerialiser = new SetSerialiser(new BooleanSerialiser());
    BooleanSerialiser objectSerialiser = new BooleanSerialiser();
    actualSetSerialiser.setObjectSerialiser(objectSerialiser);
    Class<Set> setClass = Set.class;
    actualSetSerialiser.setSetClass(setClass);
    ToBytesSerialiser actualObjectSerialiser = actualSetSerialiser.getObjectSerialiser();
    Class<? extends Set> actualSetClass = actualSetSerialiser.getSetClass();

    // Assert
    assertFalse(actualSetSerialiser.isConsistent());
    Class<Set> expectedSetClass = Set.class;
    assertEquals(expectedSetClass, actualSetClass);
    assertSame(objectSerialiser, actualObjectSerialiser);
    assertSame(setClass, actualSetClass);
  }

  /**
   * Test {@link SetSerialiser#canHandle(Class)}.
   *
   * <ul>
   *   <li>When {@code Object}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link SetSerialiser#canHandle(Class)}
   */
  @Test
  @DisplayName("Test canHandle(Class); when 'java.lang.Object'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  void testCanHandle_whenJavaLangObject_thenReturnFalse() {
    // Arrange
    SetSerialiser setSerialiser = new SetSerialiser();
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertFalse(setSerialiser.canHandle(clazz));
  }

  /**
   * Test {@link SetSerialiser#canHandle(Class)}.
   *
   * <ul>
   *   <li>When {@code Set}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link SetSerialiser#canHandle(Class)}
   */
  @Test
  @DisplayName("Test canHandle(Class); when 'java.util.Set'; then return 'true'")
  @Tag("MaintainedByDiffblue")
  void testCanHandle_whenJavaUtilSet_thenReturnTrue() {
    // Arrange
    SetSerialiser setSerialiser = new SetSerialiser();
    Class<Set> clazz = Set.class;

    // Act and Assert
    assertTrue(setSerialiser.canHandle(clazz));
  }

  /**
   * Test {@link SetSerialiser#serialise(Set)} with {@code Set}.
   *
   * <ul>
   *   <li>Given {@link SetSerialiser#SetSerialiser()}.
   *   <li>When {@link HashSet#HashSet()}.
   *   <li>Then return empty array of {@code byte}.
   * </ul>
   *
   * <p>Method under test: {@link SetSerialiser#serialise(Set)}
   */
  @Test
  @DisplayName(
      "Test serialise(Set) with 'Set'; given SetSerialiser(); when HashSet(); then return empty array of byte")
  @Tag("MaintainedByDiffblue")
  void testSerialiseWithSet_givenSetSerialiser_whenHashSet_thenReturnEmptyArrayOfByte()
      throws SerialisationException {
    // Arrange
    SetSerialiser setSerialiser = new SetSerialiser();

    // Act and Assert
    assertArrayEquals(new byte[] {}, setSerialiser.serialise(new HashSet<>()));
  }

  /**
   * Test {@link SetSerialiser#serialise(Set)} with {@code Set}.
   *
   * <ul>
   *   <li>Then return array of {@code byte} with tab and minus eighty-four.
   * </ul>
   *
   * <p>Method under test: {@link SetSerialiser#serialise(Set)}
   */
  @Test
  @DisplayName(
      "Test serialise(Set) with 'Set'; then return array of byte with tab and minus eighty-four")
  @Tag("MaintainedByDiffblue")
  void testSerialiseWithSet_thenReturnArrayOfByteWithTabAndMinusEightyFour()
      throws SerialisationException {
    // Arrange
    SetSerialiser setSerialiser = new SetSerialiser(new JavaSerialiser());

    HashSet<Object> object = new HashSet<>();
    object.add("42");

    // Act and Assert
    assertArrayEquals(
        new byte[] {'\t', -84, -19, 0, 5, 't', 0, 2, '4', '2'}, setSerialiser.serialise(object));
  }

  /**
   * Test {@link SetSerialiser#deserialise(byte[])} with {@code bytes}.
   *
   * <ul>
   *   <li>Given {@code Set}.
   *   <li>Then throw {@link SerialisationException}.
   * </ul>
   *
   * <p>Method under test: {@link SetSerialiser#deserialise(byte[])}
   */
  @Test
  @DisplayName(
      "Test deserialise(byte[]) with 'bytes'; given 'java.util.Set'; then throw SerialisationException")
  @Tag("MaintainedByDiffblue")
  void testDeserialiseWithBytes_givenJavaUtilSet_thenThrowSerialisationException()
      throws UnsupportedEncodingException, SerialisationException {
    // Arrange
    SetSerialiser setSerialiser = new SetSerialiser();
    Class<Set> setClass = Set.class;
    setSerialiser.setSetClass(setClass);

    // Act and Assert
    assertThrows(
        SerialisationException.class,
        () -> setSerialiser.deserialise("AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link SetSerialiser#deserialise(byte[])} with {@code bytes}.
   *
   * <ul>
   *   <li>Given {@link SetSerialiser#SetSerialiser(ToBytesSerialiser)} with objectSerialiser is
   *       {@link SetSerialiser#SetSerialiser(ToBytesSerialiser)}.
   * </ul>
   *
   * <p>Method under test: {@link SetSerialiser#deserialise(byte[])}
   */
  @Test
  @DisplayName(
      "Test deserialise(byte[]) with 'bytes'; given SetSerialiser(ToBytesSerialiser) with objectSerialiser is SetSerialiser(ToBytesSerialiser)")
  @Tag("MaintainedByDiffblue")
  void testDeserialiseWithBytes_givenSetSerialiserWithObjectSerialiserIsSetSerialiser()
      throws UnsupportedEncodingException, SerialisationException {
    // Arrange, Act and Assert
    assertEquals(
        1,
        new SetSerialiser(new SetSerialiser(new BooleanSerialiser()))
            .deserialise("AXAXAXAX".getBytes("UTF-8"))
            .size());
  }

  /**
   * Test {@link SetSerialiser#deserialise(byte[])} with {@code bytes}.
   *
   * <ul>
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link SetSerialiser#deserialise(byte[])}
   */
  @Test
  @DisplayName("Test deserialise(byte[]) with 'bytes'; then return size is one")
  @Tag("MaintainedByDiffblue")
  void testDeserialiseWithBytes_thenReturnSizeIsOne()
      throws UnsupportedEncodingException, SerialisationException {
    // Arrange, Act and Assert
    assertEquals(
        1,
        new SetSerialiser(new BooleanSerialiser())
            .deserialise("AXAXAXAX".getBytes("UTF-8"))
            .size());
  }

  /**
   * Test {@link SetSerialiser#deserialiseEmpty()}.
   *
   * <ul>
   *   <li>Given {@code Set}.
   *   <li>Then throw {@link SerialisationException}.
   * </ul>
   *
   * <p>Method under test: {@link SetSerialiser#deserialiseEmpty()}
   */
  @Test
  @DisplayName("Test deserialiseEmpty(); given 'java.util.Set'; then throw SerialisationException")
  @Tag("MaintainedByDiffblue")
  void testDeserialiseEmpty_givenJavaUtilSet_thenThrowSerialisationException()
      throws SerialisationException {
    // Arrange
    SetSerialiser setSerialiser = new SetSerialiser();
    Class<Set> setClass = Set.class;
    setSerialiser.setSetClass(setClass);

    // Act and Assert
    assertThrows(SerialisationException.class, () -> setSerialiser.deserialiseEmpty());
  }

  /**
   * Test {@link SetSerialiser#deserialiseEmpty()}.
   *
   * <ul>
   *   <li>Given {@link SetSerialiser#SetSerialiser()}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link SetSerialiser#deserialiseEmpty()}
   */
  @Test
  @DisplayName("Test deserialiseEmpty(); given SetSerialiser(); then return Empty")
  @Tag("MaintainedByDiffblue")
  void testDeserialiseEmpty_givenSetSerialiser_thenReturnEmpty() throws SerialisationException {
    // Arrange, Act and Assert
    assertTrue(new SetSerialiser().deserialiseEmpty().isEmpty());
  }

  /**
   * Test {@link SetSerialiser#preservesObjectOrdering()}.
   *
   * <p>Method under test: {@link SetSerialiser#preservesObjectOrdering()}
   */
  @Test
  @DisplayName("Test preservesObjectOrdering()")
  @Tag("MaintainedByDiffblue")
  void testPreservesObjectOrdering() {
    // Arrange, Act and Assert
    assertFalse(new SetSerialiser().preservesObjectOrdering());
  }

  /**
   * Test {@link SetSerialiser#serialiseNull()}.
   *
   * <p>Method under test: {@link SetSerialiser#serialiseNull()}
   */
  @Test
  @DisplayName("Test serialiseNull()")
  @Tag("MaintainedByDiffblue")
  void testSerialiseNull() {
    // Arrange, Act and Assert
    assertArrayEquals(new byte[] {}, new SetSerialiser().serialiseNull());
  }

  /**
   * Test {@link SetSerialiser#getObjectSerialiserClassString()}.
   *
   * <p>Method under test: {@link SetSerialiser#getObjectSerialiserClassString()}
   */
  @Test
  @DisplayName("Test getObjectSerialiserClassString()")
  @Tag("MaintainedByDiffblue")
  void testGetObjectSerialiserClassString() {
    // Arrange, Act and Assert
    assertEquals(
        "uk.gov.gchq.gaffer.serialisation.implementation.BooleanSerialiser",
        new SetSerialiser(new BooleanSerialiser()).getObjectSerialiserClassString());
  }

  /**
   * Test {@link SetSerialiser#getObjectSerialiserClassString()}.
   *
   * <ul>
   *   <li>Given {@link SetSerialiser#SetSerialiser()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link SetSerialiser#getObjectSerialiserClassString()}
   */
  @Test
  @DisplayName("Test getObjectSerialiserClassString(); given SetSerialiser(); then return 'null'")
  @Tag("MaintainedByDiffblue")
  void testGetObjectSerialiserClassString_givenSetSerialiser_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new SetSerialiser().getObjectSerialiserClassString());
  }

  /**
   * Test {@link SetSerialiser#setObjectSerialiserClassString(String)}.
   *
   * <p>Method under test: {@link SetSerialiser#setObjectSerialiserClassString(String)}
   */
  @Test
  @DisplayName("Test setObjectSerialiserClassString(String)")
  @Tag("MaintainedByDiffblue")
  void testSetObjectSerialiserClassString()
      throws ClassNotFoundException, IllegalAccessException, InstantiationException {
    // Arrange
    SetSerialiser setSerialiser = new SetSerialiser(new BooleanSerialiser());

    // Act
    setSerialiser.setObjectSerialiserClassString(null);

    // Assert
    assertNull(setSerialiser.getObjectSerialiserClassString());
    assertNull(setSerialiser.getObjectSerialiser());
  }

  /**
   * Test {@link SetSerialiser#setObjectSerialiserClassString(String)}.
   *
   * <p>Method under test: {@link SetSerialiser#setObjectSerialiserClassString(String)}
   */
  @Test
  @DisplayName("Test setObjectSerialiserClassString(String)")
  @Tag("MaintainedByDiffblue")
  void testSetObjectSerialiserClassString2()
      throws ClassNotFoundException, IllegalAccessException, InstantiationException {
    // Arrange
    SetSerialiser setSerialiser = new SetSerialiser(new BooleanSerialiser());

    // Act
    setSerialiser.setObjectSerialiserClassString(
        "uk.gov.gchq.gaffer.serialisation.implementation.SetSerialiser");

    // Assert
    ToBytesSerialiser objectSerialiser = setSerialiser.getObjectSerialiser();
    assertTrue(objectSerialiser instanceof SetSerialiser);
    assertEquals(
        "uk.gov.gchq.gaffer.serialisation.implementation.SetSerialiser",
        setSerialiser.getObjectSerialiserClassString());
    assertNull(((SetSerialiser) objectSerialiser).getSetClass());
    assertNull(((SetSerialiser) objectSerialiser).getObjectSerialiserClassString());
    assertNull(((SetSerialiser) objectSerialiser).getSetClassString());
    assertNull(((SetSerialiser) objectSerialiser).getObjectSerialiser());
    assertFalse(objectSerialiser.isConsistent());
  }

  /**
   * Test {@link SetSerialiser#getSetClassString()}.
   *
   * <ul>
   *   <li>Given {@code Set}.
   *   <li>Then return {@code Set}.
   * </ul>
   *
   * <p>Method under test: {@link SetSerialiser#getSetClassString()}
   */
  @Test
  @DisplayName("Test getSetClassString(); given 'java.util.Set'; then return 'java.util.Set'")
  @Tag("MaintainedByDiffblue")
  void testGetSetClassString_givenJavaUtilSet_thenReturnJavaUtilSet() {
    // Arrange
    SetSerialiser setSerialiser = new SetSerialiser();
    Class<Set> setClass = Set.class;
    setSerialiser.setSetClass(setClass);

    // Act and Assert
    assertEquals("java.util.Set", setSerialiser.getSetClassString());
  }

  /**
   * Test {@link SetSerialiser#getSetClassString()}.
   *
   * <ul>
   *   <li>Given {@link SetSerialiser#SetSerialiser()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link SetSerialiser#getSetClassString()}
   */
  @Test
  @DisplayName("Test getSetClassString(); given SetSerialiser(); then return 'null'")
  @Tag("MaintainedByDiffblue")
  void testGetSetClassString_givenSetSerialiser_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new SetSerialiser().getSetClassString());
  }

  /**
   * Test {@link SetSerialiser#setSetClassString(String)}.
   *
   * <p>Method under test: {@link SetSerialiser#setSetClassString(String)}
   */
  @Test
  @DisplayName("Test setSetClassString(String)")
  @Tag("MaintainedByDiffblue")
  void testSetSetClassString() throws ClassNotFoundException {
    // Arrange
    SetSerialiser setSerialiser = new SetSerialiser(new BooleanSerialiser());

    // Act
    setSerialiser.setSetClassString(null);

    // Assert that nothing has changed
    assertNull(setSerialiser.getSetClass());
    assertNull(setSerialiser.getSetClassString());
  }

  /**
   * Test {@link SetSerialiser#setSetClassString(String)}.
   *
   * <ul>
   *   <li>Then {@link SetSerialiser#SetSerialiser()} SetClassString is {@code Set}.
   * </ul>
   *
   * <p>Method under test: {@link SetSerialiser#setSetClassString(String)}
   */
  @Test
  @DisplayName(
      "Test setSetClassString(String); then SetSerialiser() SetClassString is 'java.util.Set'")
  @Tag("MaintainedByDiffblue")
  void testSetSetClassString_thenSetSerialiserSetClassStringIsJavaUtilSet()
      throws ClassNotFoundException {
    // Arrange
    SetSerialiser setSerialiser = new SetSerialiser();

    // Act
    setSerialiser.setSetClassString("java.util.Set");

    // Assert
    assertEquals("java.util.Set", setSerialiser.getSetClassString());
    Class<Set> expectedSetClass = Set.class;
    assertEquals(expectedSetClass, setSerialiser.getSetClass());
  }

  /**
   * Test {@link SetSerialiser#equals(Object)}, and {@link SetSerialiser#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link SetSerialiser#equals(Object)}
   *   <li>{@link SetSerialiser#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    SetSerialiser setSerialiser = new SetSerialiser();
    SetSerialiser setSerialiser2 = new SetSerialiser();

    // Act and Assert
    assertEquals(setSerialiser, setSerialiser2);
    assertEquals(setSerialiser.hashCode(), setSerialiser2.hashCode());
  }

  /**
   * Test {@link SetSerialiser#equals(Object)}, and {@link SetSerialiser#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link SetSerialiser#equals(Object)}
   *   <li>{@link SetSerialiser#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    SetSerialiser setSerialiser = new SetSerialiser();

    // Act and Assert
    assertEquals(setSerialiser, setSerialiser);
    int expectedHashCodeResult = setSerialiser.hashCode();
    assertEquals(expectedHashCodeResult, setSerialiser.hashCode());
  }

  /**
   * Test {@link SetSerialiser#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SetSerialiser#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    SetSerialiser setSerialiser = new SetSerialiser();
    setSerialiser.setObjectSerialiser(new BooleanSerialiser());

    // Act and Assert
    assertNotEquals(setSerialiser, new SetSerialiser());
  }

  /**
   * Test {@link SetSerialiser#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SetSerialiser#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    SetSerialiser setSerialiser = new SetSerialiser();
    setSerialiser.setObjectSerialiser(new SetSerialiser());

    SetSerialiser setSerialiser2 = new SetSerialiser();
    setSerialiser2.setObjectSerialiser(new BooleanSerialiser());

    // Act and Assert
    assertNotEquals(setSerialiser, setSerialiser2);
  }

  /**
   * Test {@link SetSerialiser#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SetSerialiser#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new SetSerialiser(), null);
  }

  /**
   * Test {@link SetSerialiser#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SetSerialiser#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new SetSerialiser(), "Different type to SetSerialiser");
  }
}
