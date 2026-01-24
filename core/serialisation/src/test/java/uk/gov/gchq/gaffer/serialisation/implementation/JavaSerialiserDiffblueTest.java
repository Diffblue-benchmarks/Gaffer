/*
 * Copyright 2026 Crown Copyright
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package uk.gov.gchq.gaffer.serialisation.implementation;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.exception.SerialisationException;

class JavaSerialiserDiffblueTest {
  /**
   * Test {@link JavaSerialiser#serialise(Object)}.
   *
   * <p>Method under test: {@link JavaSerialiser#serialise(Object)}
   */
  @Test
  @DisplayName("Test serialise(Object)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] JavaSerialiser.serialise(Object)"})
  void testSerialise() throws SerialisationException {
    // Arrange, Act and Assert
    assertArrayEquals(
        new byte[] {-84, -19, 0, 5, 't', 0, 6, 'O', 'b', 'j', 'e', 'c', 't'},
        new JavaSerialiser().serialise("Object"));
  }

  /**
   * Test {@link JavaSerialiser#deserialise(byte[], int, int)} with {@code allBytes}, {@code
   * offset}, {@code length}.
   *
   * <ul>
   *   <li>When two.
   *   <li>Then throw {@link SerialisationException}.
   * </ul>
   *
   * <p>Method under test: {@link JavaSerialiser#deserialise(byte[], int, int)}
   */
  @Test
  @DisplayName(
      "Test deserialise(byte[], int, int) with 'allBytes', 'offset', 'length'; when two; then throw SerialisationException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object JavaSerialiser.deserialise(byte[], int, int)"})
  void testDeserialiseWithAllBytesOffsetLength_whenTwo_thenThrowSerialisationException()
      throws UnsupportedEncodingException, SerialisationException {
    // Arrange, Act and Assert
    assertThrows(
        SerialisationException.class,
        () -> new JavaSerialiser().deserialise("AXAXAXAX".getBytes("UTF-8"), 2, 3));
  }

  /**
   * Test {@link JavaSerialiser#deserialise(byte[])} with {@code bytes}.
   *
   * <p>Method under test: {@link JavaSerialiser#deserialise(byte[])}
   */
  @Test
  @DisplayName("Test deserialise(byte[]) with 'bytes'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object JavaSerialiser.deserialise(byte[])"})
  void testDeserialiseWithBytes() throws UnsupportedEncodingException, SerialisationException {
    // Arrange, Act and Assert
    assertThrows(
        SerialisationException.class,
        () -> new JavaSerialiser().deserialise("AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link JavaSerialiser#deserialiseEmpty()}.
   *
   * <p>Method under test: {@link JavaSerialiser#deserialiseEmpty()}
   */
  @Test
  @DisplayName("Test deserialiseEmpty()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object JavaSerialiser.deserialiseEmpty()"})
  void testDeserialiseEmpty() {
    // Arrange, Act and Assert
    assertNull(new JavaSerialiser().deserialiseEmpty());
  }

  /**
   * Test {@link JavaSerialiser#canHandle(Class)}.
   *
   * <ul>
   *   <li>When {@code Serializable}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link JavaSerialiser#canHandle(Class)}
   */
  @Test
  @DisplayName("Test canHandle(Class); when 'java.io.Serializable'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean JavaSerialiser.canHandle(Class)"})
  void testCanHandle_whenJavaIoSerializable_thenReturnTrue() {
    // Arrange
    JavaSerialiser javaSerialiser = new JavaSerialiser();
    Class<Serializable> clazz = Serializable.class;

    // Act and Assert
    assertTrue(javaSerialiser.canHandle(clazz));
  }

  /**
   * Test {@link JavaSerialiser#canHandle(Class)}.
   *
   * <ul>
   *   <li>When {@code Object}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link JavaSerialiser#canHandle(Class)}
   */
  @Test
  @DisplayName("Test canHandle(Class); when 'java.lang.Object'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean JavaSerialiser.canHandle(Class)"})
  void testCanHandle_whenJavaLangObject_thenReturnFalse() {
    // Arrange
    JavaSerialiser javaSerialiser = new JavaSerialiser();
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertFalse(javaSerialiser.canHandle(clazz));
  }

  /**
   * Test {@link JavaSerialiser#preservesObjectOrdering()}.
   *
   * <p>Method under test: {@link JavaSerialiser#preservesObjectOrdering()}
   */
  @Test
  @DisplayName("Test preservesObjectOrdering()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean JavaSerialiser.preservesObjectOrdering()"})
  void testPreservesObjectOrdering() {
    // Arrange, Act and Assert
    assertFalse(new JavaSerialiser().preservesObjectOrdering());
  }

  /**
   * Test {@link JavaSerialiser#equals(Object)}, and {@link JavaSerialiser#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link JavaSerialiser#equals(Object)}
   *   <li>{@link JavaSerialiser#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean JavaSerialiser.equals(Object)", "int JavaSerialiser.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    JavaSerialiser javaSerialiser = new JavaSerialiser();
    JavaSerialiser javaSerialiser2 = new JavaSerialiser();

    // Act and Assert
    assertEquals(javaSerialiser, javaSerialiser2);
    assertEquals(javaSerialiser.hashCode(), javaSerialiser2.hashCode());
  }

  /**
   * Test {@link JavaSerialiser#equals(Object)}, and {@link JavaSerialiser#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link JavaSerialiser#equals(Object)}
   *   <li>{@link JavaSerialiser#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean JavaSerialiser.equals(Object)", "int JavaSerialiser.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    JavaSerialiser javaSerialiser = new JavaSerialiser();

    // Act and Assert
    assertEquals(javaSerialiser, javaSerialiser);
    int expectedHashCodeResult = javaSerialiser.hashCode();
    assertEquals(expectedHashCodeResult, javaSerialiser.hashCode());
  }

  /**
   * Test {@link JavaSerialiser#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link JavaSerialiser#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean JavaSerialiser.equals(Object)", "int JavaSerialiser.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new JavaSerialiser(), 1);
  }

  /**
   * Test {@link JavaSerialiser#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link JavaSerialiser#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean JavaSerialiser.equals(Object)", "int JavaSerialiser.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new JavaSerialiser(), null);
  }

  /**
   * Test {@link JavaSerialiser#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link JavaSerialiser#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean JavaSerialiser.equals(Object)", "int JavaSerialiser.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new JavaSerialiser(), "Different type to JavaSerialiser");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link JavaSerialiser}
   *   <li>{@link JavaSerialiser#isConsistent()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void JavaSerialiser.<init>()", "boolean JavaSerialiser.isConsistent()"})
  void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertFalse(new JavaSerialiser().isConsistent());
  }
}
