package uk.gov.gchq.gaffer.time.serialisation;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.UnsupportedEncodingException;
import java.time.LocalDate;
import java.time.ZoneOffset;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.exception.SerialisationException;
import uk.gov.gchq.gaffer.time.BoundedTimestampSet;
import uk.gov.gchq.gaffer.time.CommonTimeUtil;
import uk.gov.gchq.gaffer.time.CommonTimeUtil.TimeBucket;

class BoundedTimestampSetSerialiserDiffblueTest {
  /**
   * Test {@link BoundedTimestampSetSerialiser#canHandle(Class)}.
   *
   * <ul>
   *   <li>When {@code Object}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link BoundedTimestampSetSerialiser#canHandle(Class)}
   */
  @Test
  @DisplayName("Test canHandle(Class); when 'java.lang.Object'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BoundedTimestampSetSerialiser.canHandle(Class)"})
  void testCanHandle_whenJavaLangObject_thenReturnFalse() {
    // Arrange
    BoundedTimestampSetSerialiser boundedTimestampSetSerialiser =
        new BoundedTimestampSetSerialiser();
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertFalse(boundedTimestampSetSerialiser.canHandle(clazz));
  }

  /**
   * Test {@link BoundedTimestampSetSerialiser#canHandle(Class)}.
   *
   * <ul>
   *   <li>When {@code BoundedTimestampSet}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link BoundedTimestampSetSerialiser#canHandle(Class)}
   */
  @Test
  @DisplayName(
      "Test canHandle(Class); when 'uk.gov.gchq.gaffer.time.BoundedTimestampSet'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BoundedTimestampSetSerialiser.canHandle(Class)"})
  void testCanHandle_whenUkGovGchqGafferTimeBoundedTimestampSet_thenReturnTrue() {
    // Arrange
    BoundedTimestampSetSerialiser boundedTimestampSetSerialiser =
        new BoundedTimestampSetSerialiser();
    Class<BoundedTimestampSet> clazz = BoundedTimestampSet.class;

    // Act and Assert
    assertTrue(boundedTimestampSetSerialiser.canHandle(clazz));
  }

  /**
   * Test {@link BoundedTimestampSetSerialiser#serialise(BoundedTimestampSet)} with {@code
   * BoundedTimestampSet}.
   *
   * <p>Method under test: {@link BoundedTimestampSetSerialiser#serialise(BoundedTimestampSet)}
   */
  @Test
  @DisplayName("Test serialise(BoundedTimestampSet) with 'BoundedTimestampSet'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] BoundedTimestampSetSerialiser.serialise(BoundedTimestampSet)"})
  void testSerialiseWithBoundedTimestampSet() throws SerialisationException {
    // Arrange
    BoundedTimestampSetSerialiser boundedTimestampSetSerialiser =
        new BoundedTimestampSetSerialiser();

    // Act
    byte[] actualSerialiseResult =
        boundedTimestampSetSerialiser.serialise(new BoundedTimestampSet(TimeBucket.SECOND, 3));

    // Assert
    assertArrayEquals(new byte[] {0, 3, 0, ':', '0', 0, 0, 0, 0, 0, 0}, actualSerialiseResult);
  }

  /**
   * Test {@link BoundedTimestampSetSerialiser#serialise(BoundedTimestampSet)} with {@code
   * BoundedTimestampSet}.
   *
   * <p>Method under test: {@link BoundedTimestampSetSerialiser#serialise(BoundedTimestampSet)}
   */
  @Test
  @DisplayName("Test serialise(BoundedTimestampSet) with 'BoundedTimestampSet'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] BoundedTimestampSetSerialiser.serialise(BoundedTimestampSet)"})
  void testSerialiseWithBoundedTimestampSet2() throws SerialisationException {
    // Arrange
    BoundedTimestampSetSerialiser boundedTimestampSetSerialiser =
        new BoundedTimestampSetSerialiser();

    BoundedTimestampSet boundedTimestampSet = new BoundedTimestampSet(TimeBucket.SECOND, 3);
    boundedTimestampSet.add(
        LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Act
    byte[] actualSerialiseResult = boundedTimestampSetSerialiser.serialise(boundedTimestampSet);

    // Assert
    assertArrayEquals(
        new byte[] {0, 3, 0, ':', '0', 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 16, 0, 0, 0, 0, 0},
        actualSerialiseResult);
  }

  /**
   * Test {@link BoundedTimestampSetSerialiser#serialise(BoundedTimestampSet)} with {@code
   * BoundedTimestampSet}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return empty array of {@code byte}.
   * </ul>
   *
   * <p>Method under test: {@link BoundedTimestampSetSerialiser#serialise(BoundedTimestampSet)}
   */
  @Test
  @DisplayName(
      "Test serialise(BoundedTimestampSet) with 'BoundedTimestampSet'; when 'null'; then return empty array of byte")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] BoundedTimestampSetSerialiser.serialise(BoundedTimestampSet)"})
  void testSerialiseWithBoundedTimestampSet_whenNull_thenReturnEmptyArrayOfByte()
      throws SerialisationException {
    // Arrange, Act and Assert
    assertArrayEquals(new byte[] {}, new BoundedTimestampSetSerialiser().serialise(null));
  }

  /**
   * Test {@link BoundedTimestampSetSerialiser#deserialise(byte[], int, int)} with {@code allBytes},
   * {@code offset}, {@code length}.
   *
   * <ul>
   *   <li>When eight.
   * </ul>
   *
   * <p>Method under test: {@link BoundedTimestampSetSerialiser#deserialise(byte[], int, int)}
   */
  @Test
  @DisplayName("Test deserialise(byte[], int, int) with 'allBytes', 'offset', 'length'; when eight")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BoundedTimestampSet BoundedTimestampSetSerialiser.deserialise(byte[], int, int)"
  })
  void testDeserialiseWithAllBytesOffsetLength_whenEight() throws SerialisationException {
    // Arrange, Act and Assert
    assertThrows(
        SerialisationException.class,
        () ->
            new BoundedTimestampSetSerialiser()
                .deserialise(new byte[] {'A', 'X', 3, 'X', 0, 'X', 'A', 'X'}, 2, 8));
  }

  /**
   * Test {@link BoundedTimestampSetSerialiser#deserialise(byte[], int, int)} with {@code allBytes},
   * {@code offset}, {@code length}.
   *
   * <ul>
   *   <li>When empty array of {@code byte}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link BoundedTimestampSetSerialiser#deserialise(byte[], int, int)}
   */
  @Test
  @DisplayName(
      "Test deserialise(byte[], int, int) with 'allBytes', 'offset', 'length'; when empty array of byte; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BoundedTimestampSet BoundedTimestampSetSerialiser.deserialise(byte[], int, int)"
  })
  void testDeserialiseWithAllBytesOffsetLength_whenEmptyArrayOfByte_thenReturnNull()
      throws SerialisationException {
    // Arrange, Act and Assert
    assertNull(new BoundedTimestampSetSerialiser().deserialise(new byte[] {}, 2, 3));
  }

  /**
   * Test {@link BoundedTimestampSetSerialiser#deserialise(byte[], int, int)} with {@code allBytes},
   * {@code offset}, {@code length}.
   *
   * <ul>
   *   <li>When {@code X}.
   *   <li>Then throw {@link SerialisationException}.
   * </ul>
   *
   * <p>Method under test: {@link BoundedTimestampSetSerialiser#deserialise(byte[], int, int)}
   */
  @Test
  @DisplayName(
      "Test deserialise(byte[], int, int) with 'allBytes', 'offset', 'length'; when 'X'; then throw SerialisationException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BoundedTimestampSet BoundedTimestampSetSerialiser.deserialise(byte[], int, int)"
  })
  void testDeserialiseWithAllBytesOffsetLength_whenX_thenThrowSerialisationException()
      throws SerialisationException {
    // Arrange, Act and Assert
    assertThrows(
        SerialisationException.class,
        () ->
            new BoundedTimestampSetSerialiser()
                .deserialise(new byte[] {'A', 'X', 3, 'X', 'A', 'X', 'A', 'X'}, 2, 3));
  }

  /**
   * Test {@link BoundedTimestampSetSerialiser#deserialise(byte[], int, int)} with {@code allBytes},
   * {@code offset}, {@code length}.
   *
   * <ul>
   *   <li>When {@code X}.
   *   <li>Then throw {@link SerialisationException}.
   * </ul>
   *
   * <p>Method under test: {@link BoundedTimestampSetSerialiser#deserialise(byte[], int, int)}
   */
  @Test
  @DisplayName(
      "Test deserialise(byte[], int, int) with 'allBytes', 'offset', 'length'; when 'X'; then throw SerialisationException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BoundedTimestampSet BoundedTimestampSetSerialiser.deserialise(byte[], int, int)"
  })
  void testDeserialiseWithAllBytesOffsetLength_whenX_thenThrowSerialisationException2()
      throws SerialisationException {
    // Arrange, Act and Assert
    assertThrows(
        SerialisationException.class,
        () ->
            new BoundedTimestampSetSerialiser()
                .deserialise(new byte[] {'A', 'X', 3, 'X', 1, 'X', 'A', 'X'}, 2, 3));
  }

  /**
   * Test {@link BoundedTimestampSetSerialiser#deserialise(byte[], int, int)} with {@code allBytes},
   * {@code offset}, {@code length}.
   *
   * <ul>
   *   <li>When {@code X}.
   *   <li>Then throw {@link SerialisationException}.
   * </ul>
   *
   * <p>Method under test: {@link BoundedTimestampSetSerialiser#deserialise(byte[], int, int)}
   */
  @Test
  @DisplayName(
      "Test deserialise(byte[], int, int) with 'allBytes', 'offset', 'length'; when 'X'; then throw SerialisationException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BoundedTimestampSet BoundedTimestampSetSerialiser.deserialise(byte[], int, int)"
  })
  void testDeserialiseWithAllBytesOffsetLength_whenX_thenThrowSerialisationException3()
      throws SerialisationException {
    // Arrange, Act and Assert
    assertThrows(
        SerialisationException.class,
        () ->
            new BoundedTimestampSetSerialiser()
                .deserialise(new byte[] {'A', 'X', 3, 'X', 0, 'X', 'A', 'X'}, 2, 3));
  }

  /**
   * Test {@link BoundedTimestampSetSerialiser#deserialise(byte[], int, int)} with {@code allBytes},
   * {@code offset}, {@code length}.
   *
   * <ul>
   *   <li>When zero.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link BoundedTimestampSetSerialiser#deserialise(byte[], int, int)}
   */
  @Test
  @DisplayName(
      "Test deserialise(byte[], int, int) with 'allBytes', 'offset', 'length'; when zero; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BoundedTimestampSet BoundedTimestampSetSerialiser.deserialise(byte[], int, int)"
  })
  void testDeserialiseWithAllBytesOffsetLength_whenZero_thenReturnNull()
      throws UnsupportedEncodingException, SerialisationException {
    // Arrange, Act and Assert
    assertNull(new BoundedTimestampSetSerialiser().deserialise("AXAXAXAX".getBytes("UTF-8"), 2, 0));
  }

  /**
   * Test {@link BoundedTimestampSetSerialiser#deserialise(byte[])} with {@code bytes}.
   *
   * <ul>
   *   <li>Then throw {@link SerialisationException}.
   * </ul>
   *
   * <p>Method under test: {@link BoundedTimestampSetSerialiser#deserialise(byte[])}
   */
  @Test
  @DisplayName("Test deserialise(byte[]) with 'bytes'; then throw SerialisationException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BoundedTimestampSet BoundedTimestampSetSerialiser.deserialise(byte[])"})
  void testDeserialiseWithBytes_thenThrowSerialisationException() throws SerialisationException {
    // Arrange, Act and Assert
    assertThrows(
        SerialisationException.class,
        () ->
            new BoundedTimestampSetSerialiser()
                .deserialise(new byte[] {1, 'X', 'A', 'X', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test {@link BoundedTimestampSetSerialiser#deserialise(byte[])} with {@code bytes}.
   *
   * <ul>
   *   <li>Then throw {@link SerialisationException}.
   * </ul>
   *
   * <p>Method under test: {@link BoundedTimestampSetSerialiser#deserialise(byte[])}
   */
  @Test
  @DisplayName("Test deserialise(byte[]) with 'bytes'; then throw SerialisationException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BoundedTimestampSet BoundedTimestampSetSerialiser.deserialise(byte[])"})
  void testDeserialiseWithBytes_thenThrowSerialisationException2() throws SerialisationException {
    // Arrange, Act and Assert
    assertThrows(
        SerialisationException.class,
        () ->
            new BoundedTimestampSetSerialiser()
                .deserialise(new byte[] {1, 'X', 0, 'X', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test {@link BoundedTimestampSetSerialiser#deserialise(byte[])} with {@code bytes}.
   *
   * <ul>
   *   <li>When empty array of {@code byte}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link BoundedTimestampSetSerialiser#deserialise(byte[])}
   */
  @Test
  @DisplayName(
      "Test deserialise(byte[]) with 'bytes'; when empty array of byte; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BoundedTimestampSet BoundedTimestampSetSerialiser.deserialise(byte[])"})
  void testDeserialiseWithBytes_whenEmptyArrayOfByte_thenReturnNull()
      throws SerialisationException {
    // Arrange and Act
    BoundedTimestampSet actualDeserialiseResult =
        new BoundedTimestampSetSerialiser().deserialise(new byte[] {});

    // Assert
    assertNull(actualDeserialiseResult);
  }

  /**
   * Test {@link BoundedTimestampSetSerialiser#deserialiseEmpty()}.
   *
   * <p>Method under test: {@link BoundedTimestampSetSerialiser#deserialiseEmpty()}
   */
  @Test
  @DisplayName("Test deserialiseEmpty()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BoundedTimestampSet BoundedTimestampSetSerialiser.deserialiseEmpty()"})
  void testDeserialiseEmpty() throws SerialisationException {
    // Arrange, Act and Assert
    assertNull(new BoundedTimestampSetSerialiser().deserialiseEmpty());
  }

  /**
   * Test {@link BoundedTimestampSetSerialiser#preservesObjectOrdering()}.
   *
   * <p>Method under test: {@link BoundedTimestampSetSerialiser#preservesObjectOrdering()}
   */
  @Test
  @DisplayName("Test preservesObjectOrdering()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BoundedTimestampSetSerialiser.preservesObjectOrdering()"})
  void testPreservesObjectOrdering() {
    // Arrange, Act and Assert
    assertFalse(new BoundedTimestampSetSerialiser().preservesObjectOrdering());
  }

  /**
   * Test {@link BoundedTimestampSetSerialiser#equals(Object)}, and {@link
   * BoundedTimestampSetSerialiser#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link BoundedTimestampSetSerialiser#equals(Object)}
   *   <li>{@link BoundedTimestampSetSerialiser#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean BoundedTimestampSetSerialiser.equals(Object)",
    "int BoundedTimestampSetSerialiser.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    BoundedTimestampSetSerialiser boundedTimestampSetSerialiser =
        new BoundedTimestampSetSerialiser();
    BoundedTimestampSetSerialiser boundedTimestampSetSerialiser2 =
        new BoundedTimestampSetSerialiser();

    // Act and Assert
    assertEquals(boundedTimestampSetSerialiser, boundedTimestampSetSerialiser2);
    assertEquals(
        boundedTimestampSetSerialiser.hashCode(), boundedTimestampSetSerialiser2.hashCode());
  }

  /**
   * Test {@link BoundedTimestampSetSerialiser#equals(Object)}, and {@link
   * BoundedTimestampSetSerialiser#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link BoundedTimestampSetSerialiser#equals(Object)}
   *   <li>{@link BoundedTimestampSetSerialiser#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean BoundedTimestampSetSerialiser.equals(Object)",
    "int BoundedTimestampSetSerialiser.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    BoundedTimestampSetSerialiser boundedTimestampSetSerialiser =
        new BoundedTimestampSetSerialiser();

    // Act and Assert
    assertEquals(boundedTimestampSetSerialiser, boundedTimestampSetSerialiser);
    int expectedHashCodeResult = boundedTimestampSetSerialiser.hashCode();
    assertEquals(expectedHashCodeResult, boundedTimestampSetSerialiser.hashCode());
  }

  /**
   * Test {@link BoundedTimestampSetSerialiser#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link BoundedTimestampSetSerialiser#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean BoundedTimestampSetSerialiser.equals(Object)",
    "int BoundedTimestampSetSerialiser.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new BoundedTimestampSetSerialiser(), 1);
  }

  /**
   * Test {@link BoundedTimestampSetSerialiser#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link BoundedTimestampSetSerialiser#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean BoundedTimestampSetSerialiser.equals(Object)",
    "int BoundedTimestampSetSerialiser.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new BoundedTimestampSetSerialiser(), null);
  }

  /**
   * Test {@link BoundedTimestampSetSerialiser#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link BoundedTimestampSetSerialiser#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean BoundedTimestampSetSerialiser.equals(Object)",
    "int BoundedTimestampSetSerialiser.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        new BoundedTimestampSetSerialiser(), "Different type to BoundedTimestampSetSerialiser");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link BoundedTimestampSetSerialiser}
   *   <li>{@link BoundedTimestampSetSerialiser#isConsistent()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BoundedTimestampSetSerialiser.<init>()",
    "boolean BoundedTimestampSetSerialiser.isConsistent()"
  })
  void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertFalse(new BoundedTimestampSetSerialiser().isConsistent());
  }
}
