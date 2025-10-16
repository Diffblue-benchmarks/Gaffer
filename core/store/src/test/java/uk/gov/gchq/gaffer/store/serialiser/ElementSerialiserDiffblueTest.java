package uk.gov.gchq.gaffer.store.serialiser;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.UnsupportedEncodingException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.data.element.Element;
import uk.gov.gchq.gaffer.exception.SerialisationException;
import uk.gov.gchq.gaffer.store.schema.Schema;

class ElementSerialiserDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ElementSerialiser#ElementSerialiser()}
   *   <li>{@link ElementSerialiser#isConsistent()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ElementSerialiser.<init>()", "boolean ElementSerialiser.isConsistent()"})
  void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertFalse(new ElementSerialiser().isConsistent());
  }

  /**
   * Test {@link ElementSerialiser#ElementSerialiser(Schema)}.
   *
   * <ul>
   *   <li>Given {@link EdgeIdSerialiser#EdgeIdSerialiser()}.
   *   <li>Then return not Consistent.
   * </ul>
   *
   * <p>Method under test: {@link ElementSerialiser#ElementSerialiser(Schema)}
   */
  @Test
  @DisplayName(
      "Test new ElementSerialiser(Schema); given EdgeIdSerialiser(); then return not Consistent")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ElementSerialiser.<init>(Schema)"})
  void testNewElementSerialiser_givenEdgeIdSerialiser_thenReturnNotConsistent() {
    // Arrange
    Schema schema = mock(Schema.class);
    when(schema.getVertexSerialiser()).thenReturn(new EdgeIdSerialiser());

    // Act
    ElementSerialiser actualElementSerialiser = new ElementSerialiser(schema);

    // Assert
    verify(schema, atLeast(1)).getVertexSerialiser();
    assertFalse(actualElementSerialiser.isConsistent());
  }

  /**
   * Test {@link ElementSerialiser#canHandle(Class)}.
   *
   * <ul>
   *   <li>When {@code Object}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ElementSerialiser#canHandle(Class)}
   */
  @Test
  @DisplayName("Test canHandle(Class); when 'java.lang.Object'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ElementSerialiser.canHandle(Class)"})
  void testCanHandle_whenJavaLangObject_thenReturnFalse() {
    // Arrange
    ElementSerialiser elementSerialiser = new ElementSerialiser();
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertFalse(elementSerialiser.canHandle(clazz));
  }

  /**
   * Test {@link ElementSerialiser#canHandle(Class)}.
   *
   * <ul>
   *   <li>When {@code Element}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link ElementSerialiser#canHandle(Class)}
   */
  @Test
  @DisplayName(
      "Test canHandle(Class); when 'uk.gov.gchq.gaffer.data.element.Element'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ElementSerialiser.canHandle(Class)"})
  void testCanHandle_whenUkGovGchqGafferDataElementElement_thenReturnTrue() {
    // Arrange
    ElementSerialiser elementSerialiser = new ElementSerialiser();
    Class<Element> clazz = Element.class;

    // Act and Assert
    assertTrue(elementSerialiser.canHandle(clazz));
  }

  /**
   * Test {@link ElementSerialiser#getGroup(byte[])}.
   *
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.
   *   <li>Then return {@code XAXAXAX}.
   * </ul>
   *
   * <p>Method under test: {@link ElementSerialiser#getGroup(byte[])}
   */
  @Test
  @DisplayName("Test getGroup(byte[]); when 'AXAXAXAX' Bytes is 'UTF-8'; then return 'XAXAXAX'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ElementSerialiser.getGroup(byte[])"})
  void testGetGroup_whenAxaxaxaxBytesIsUtf8_thenReturnXaxaxax()
      throws UnsupportedEncodingException, SerialisationException {
    // Arrange and Act
    String actualGroup = new ElementSerialiser().getGroup("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertEquals(
        "XAXAXAX\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000",
        actualGroup);
  }

  /**
   * Test {@link ElementSerialiser#getGroup(byte[])}.
   *
   * <ul>
   *   <li>When empty array of {@code byte}.
   *   <li>Then return empty string.
   * </ul>
   *
   * <p>Method under test: {@link ElementSerialiser#getGroup(byte[])}
   */
  @Test
  @DisplayName("Test getGroup(byte[]); when empty array of byte; then return empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ElementSerialiser.getGroup(byte[])"})
  void testGetGroup_whenEmptyArrayOfByte_thenReturnEmptyString() throws SerialisationException {
    // Arrange and Act
    String actualGroup = new ElementSerialiser().getGroup(new byte[] {});

    // Assert
    assertEquals("", actualGroup);
  }

  /**
   * Test {@link ElementSerialiser#getGroup(byte[])}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return empty string.
   * </ul>
   *
   * <p>Method under test: {@link ElementSerialiser#getGroup(byte[])}
   */
  @Test
  @DisplayName("Test getGroup(byte[]); when 'null'; then return empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ElementSerialiser.getGroup(byte[])"})
  void testGetGroup_whenNull_thenReturnEmptyString() throws SerialisationException {
    // Arrange, Act and Assert
    assertEquals("", new ElementSerialiser().getGroup(null));
  }

  /**
   * Test {@link ElementSerialiser#deserialiseEmpty()}.
   *
   * <p>Method under test: {@link ElementSerialiser#deserialiseEmpty()}
   */
  @Test
  @DisplayName("Test deserialiseEmpty()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Element ElementSerialiser.deserialiseEmpty()"})
  void testDeserialiseEmpty() throws SerialisationException {
    // Arrange, Act and Assert
    assertNull(new ElementSerialiser().deserialiseEmpty());
  }

  /**
   * Test {@link ElementSerialiser#equals(Object)}, and {@link ElementSerialiser#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ElementSerialiser#equals(Object)}
   *   <li>{@link ElementSerialiser#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ElementSerialiser.equals(Object)",
    "int ElementSerialiser.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ElementSerialiser elementSerialiser = new ElementSerialiser();
    ElementSerialiser elementSerialiser2 = new ElementSerialiser();

    // Act and Assert
    assertEquals(elementSerialiser, elementSerialiser2);
    assertEquals(elementSerialiser.hashCode(), elementSerialiser2.hashCode());
  }

  /**
   * Test {@link ElementSerialiser#equals(Object)}, and {@link ElementSerialiser#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ElementSerialiser#equals(Object)}
   *   <li>{@link ElementSerialiser#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ElementSerialiser.equals(Object)",
    "int ElementSerialiser.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ElementSerialiser elementSerialiser = new ElementSerialiser();

    // Act and Assert
    assertEquals(elementSerialiser, elementSerialiser);
    int expectedHashCodeResult = elementSerialiser.hashCode();
    assertEquals(expectedHashCodeResult, elementSerialiser.hashCode());
  }

  /**
   * Test {@link ElementSerialiser#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ElementSerialiser#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ElementSerialiser.equals(Object)",
    "int ElementSerialiser.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new ElementSerialiser(), null);
  }

  /**
   * Test {@link ElementSerialiser#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ElementSerialiser#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ElementSerialiser.equals(Object)",
    "int ElementSerialiser.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new ElementSerialiser(), "Different type to ElementSerialiser");
  }
}
