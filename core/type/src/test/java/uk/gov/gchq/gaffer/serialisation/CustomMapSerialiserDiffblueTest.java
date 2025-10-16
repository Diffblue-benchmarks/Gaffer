package uk.gov.gchq.gaffer.serialisation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.UnsupportedEncodingException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.exception.SerialisationException;
import uk.gov.gchq.gaffer.types.CustomMap;

class CustomMapSerialiserDiffblueTest {
  /**
   * Test {@link CustomMapSerialiser#canHandle(Class)}.
   *
   * <ul>
   *   <li>When {@code Object}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link CustomMapSerialiser#canHandle(Class)}
   */
  @Test
  @DisplayName("Test canHandle(Class); when 'java.lang.Object'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CustomMapSerialiser.canHandle(Class)"})
  void testCanHandle_whenJavaLangObject_thenReturnFalse() {
    // Arrange
    CustomMapSerialiser customMapSerialiser = new CustomMapSerialiser();
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertFalse(customMapSerialiser.canHandle(clazz));
  }

  /**
   * Test {@link CustomMapSerialiser#canHandle(Class)}.
   *
   * <ul>
   *   <li>When {@code CustomMap}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link CustomMapSerialiser#canHandle(Class)}
   */
  @Test
  @DisplayName(
      "Test canHandle(Class); when 'uk.gov.gchq.gaffer.types.CustomMap'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CustomMapSerialiser.canHandle(Class)"})
  void testCanHandle_whenUkGovGchqGafferTypesCustomMap_thenReturnTrue() {
    // Arrange
    CustomMapSerialiser customMapSerialiser = new CustomMapSerialiser();
    Class<CustomMap> clazz = CustomMap.class;

    // Act and Assert
    assertTrue(customMapSerialiser.canHandle(clazz));
  }

  /**
   * Test {@link CustomMapSerialiser#serialise(CustomMap)} with {@code CustomMap}.
   *
   * <p>Method under test: {@link CustomMapSerialiser#serialise(CustomMap)}
   */
  @Test
  @DisplayName("Test serialise(CustomMap) with 'CustomMap'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] CustomMapSerialiser.serialise(CustomMap)"})
  void testSerialiseWithCustomMap() throws SerialisationException {
    // Arrange
    CustomMapSerialiser customMapSerialiser = new CustomMapSerialiser();
    AvroSerialiser keySerialiser = new AvroSerialiser();
    CustomMap customMap = new CustomMap(keySerialiser, new AvroSerialiser());

    // Act
    byte[] actualSerialiseResult = customMapSerialiser.serialise(customMap);

    // Assert
    assertEquals((byte) -100, actualSerialiseResult[280]);
    assertEquals((byte) -113, actualSerialiseResult[276]);
    assertEquals((byte) -123, actualSerialiseResult[275]);
    assertEquals((byte) -87, actualSerialiseResult[273]);
    assertEquals((byte) -8, actualSerialiseResult[279]);
    assertEquals((byte) 0, actualSerialiseResult[282]);
    assertEquals((byte) 0, actualSerialiseResult[283]);
    assertEquals((byte) 0, actualSerialiseResult[288]);
    assertEquals((byte) 0, actualSerialiseResult[290]);
    assertEquals((byte) 14, actualSerialiseResult[274]);
    assertEquals(292, actualSerialiseResult.length);
    assertEquals((byte) 2, actualSerialiseResult[281]);
    assertEquals((byte) 6, actualSerialiseResult[291]);
    assertEquals(':', actualSerialiseResult[278]);
    assertEquals('I', actualSerialiseResult[277]);
    assertEquals('a', actualSerialiseResult[267]);
    assertEquals('e', actualSerialiseResult[271]);
    assertEquals('i', actualSerialiseResult[269]);
    assertEquals('l', actualSerialiseResult[268]);
    assertEquals('p', actualSerialiseResult[285]);
    assertEquals('q', actualSerialiseResult[287]);
    assertEquals('r', actualSerialiseResult[272]);
    assertEquals('s', actualSerialiseResult[270]);
    assertEquals('s', actualSerialiseResult[286]);
    assertEquals('x', actualSerialiseResult[284]);
    assertEquals('~', actualSerialiseResult[289]);
  }

  /**
   * Test {@link CustomMapSerialiser#serialise(CustomMap)} with {@code CustomMap}.
   *
   * <p>Method under test: {@link CustomMapSerialiser#serialise(CustomMap)}
   */
  @Test
  @DisplayName("Test serialise(CustomMap) with 'CustomMap'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] CustomMapSerialiser.serialise(CustomMap)"})
  void testSerialiseWithCustomMap2() throws SerialisationException {
    // Arrange
    CustomMapSerialiser customMapSerialiser = new CustomMapSerialiser();
    AvroSerialiser keySerialiser = new AvroSerialiser();

    CustomMap customMap = new CustomMap(keySerialiser, new AvroSerialiser());
    customMap.put("Key", "Value");

    // Act
    byte[] actualSerialiseResult = customMapSerialiser.serialise(customMap);

    // Assert
    assertEquals((byte) -100, actualSerialiseResult[414]);
    assertEquals((byte) -113, actualSerialiseResult[410]);
    assertEquals((byte) -123, actualSerialiseResult[409]);
    assertEquals((byte) -87, actualSerialiseResult[407]);
    assertEquals((byte) -8, actualSerialiseResult[413]);
    assertEquals((byte) 0, actualSerialiseResult[416]);
    assertEquals((byte) 0, actualSerialiseResult[417]);
    assertEquals((byte) 0, actualSerialiseResult[422]);
    assertEquals((byte) 0, actualSerialiseResult[424]);
    assertEquals((byte) 14, actualSerialiseResult[408]);
    assertEquals((byte) 2, actualSerialiseResult[415]);
    assertEquals(426, actualSerialiseResult.length);
    assertEquals((byte) 6, actualSerialiseResult[425]);
    assertEquals(':', actualSerialiseResult[412]);
    assertEquals('I', actualSerialiseResult[411]);
    assertEquals('a', actualSerialiseResult[401]);
    assertEquals('e', actualSerialiseResult[405]);
    assertEquals('i', actualSerialiseResult[403]);
    assertEquals('l', actualSerialiseResult[402]);
    assertEquals('p', actualSerialiseResult[419]);
    assertEquals('q', actualSerialiseResult[421]);
    assertEquals('r', actualSerialiseResult[406]);
    assertEquals('s', actualSerialiseResult[404]);
    assertEquals('s', actualSerialiseResult[420]);
    assertEquals('x', actualSerialiseResult[418]);
    assertEquals('~', actualSerialiseResult[423]);
  }

  /**
   * Test {@link CustomMapSerialiser#deserialise(byte[])} with {@code bytes}.
   *
   * <p>Method under test: {@link CustomMapSerialiser#deserialise(byte[])}
   */
  @Test
  @DisplayName("Test deserialise(byte[]) with 'bytes'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"CustomMap CustomMapSerialiser.deserialise(byte[])"})
  void testDeserialiseWithBytes() throws UnsupportedEncodingException, SerialisationException {
    // Arrange, Act and Assert
    assertThrows(
        SerialisationException.class,
        () -> new CustomMapSerialiser().deserialise("AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link CustomMapSerialiser#deserialiseEmpty()}.
   *
   * <p>Method under test: {@link CustomMapSerialiser#deserialiseEmpty()}
   */
  @Test
  @DisplayName("Test deserialiseEmpty()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"CustomMap CustomMapSerialiser.deserialiseEmpty()"})
  void testDeserialiseEmpty() throws SerialisationException {
    // Arrange, Act and Assert
    assertNull(new CustomMapSerialiser().deserialiseEmpty());
  }

  /**
   * Test {@link CustomMapSerialiser#preservesObjectOrdering()}.
   *
   * <p>Method under test: {@link CustomMapSerialiser#preservesObjectOrdering()}
   */
  @Test
  @DisplayName("Test preservesObjectOrdering()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CustomMapSerialiser.preservesObjectOrdering()"})
  void testPreservesObjectOrdering() {
    // Arrange, Act and Assert
    assertFalse(new CustomMapSerialiser().preservesObjectOrdering());
  }

  /**
   * Test {@link CustomMapSerialiser#equals(Object)}, and {@link CustomMapSerialiser#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link CustomMapSerialiser#equals(Object)}
   *   <li>{@link CustomMapSerialiser#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CustomMapSerialiser.equals(Object)",
    "int CustomMapSerialiser.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    CustomMapSerialiser customMapSerialiser = new CustomMapSerialiser();
    CustomMapSerialiser customMapSerialiser2 = new CustomMapSerialiser();

    // Act and Assert
    assertEquals(customMapSerialiser, customMapSerialiser2);
    assertEquals(customMapSerialiser.hashCode(), customMapSerialiser2.hashCode());
  }

  /**
   * Test {@link CustomMapSerialiser#equals(Object)}, and {@link CustomMapSerialiser#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link CustomMapSerialiser#equals(Object)}
   *   <li>{@link CustomMapSerialiser#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CustomMapSerialiser.equals(Object)",
    "int CustomMapSerialiser.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    CustomMapSerialiser customMapSerialiser = new CustomMapSerialiser();

    // Act and Assert
    assertEquals(customMapSerialiser, customMapSerialiser);
    int expectedHashCodeResult = customMapSerialiser.hashCode();
    assertEquals(expectedHashCodeResult, customMapSerialiser.hashCode());
  }

  /**
   * Test {@link CustomMapSerialiser#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CustomMapSerialiser#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CustomMapSerialiser.equals(Object)",
    "int CustomMapSerialiser.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new CustomMapSerialiser(), 1);
  }

  /**
   * Test {@link CustomMapSerialiser#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CustomMapSerialiser#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CustomMapSerialiser.equals(Object)",
    "int CustomMapSerialiser.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new CustomMapSerialiser(), null);
  }

  /**
   * Test {@link CustomMapSerialiser#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CustomMapSerialiser#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CustomMapSerialiser.equals(Object)",
    "int CustomMapSerialiser.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new CustomMapSerialiser(), "Different type to CustomMapSerialiser");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link CustomMapSerialiser}
   *   <li>{@link CustomMapSerialiser#isConsistent()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void CustomMapSerialiser.<init>()",
    "boolean CustomMapSerialiser.isConsistent()"
  })
  void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertFalse(new CustomMapSerialiser().isConsistent());
  }
}
