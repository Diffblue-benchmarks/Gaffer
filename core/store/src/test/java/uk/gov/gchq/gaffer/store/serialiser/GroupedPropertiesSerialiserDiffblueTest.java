/*
 * Copyright 2025 Crown Copyright
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

package uk.gov.gchq.gaffer.store.serialiser;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.UnsupportedEncodingException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.data.element.GroupedProperties;
import uk.gov.gchq.gaffer.exception.SerialisationException;
import uk.gov.gchq.gaffer.store.schema.Schema;

class GroupedPropertiesSerialiserDiffblueTest {
  /**
   * Test {@link GroupedPropertiesSerialiser#GroupedPropertiesSerialiser()}.
   * <p>
   * Method under test: {@link GroupedPropertiesSerialiser#GroupedPropertiesSerialiser()}
   */
  @Test
  @DisplayName("Test new GroupedPropertiesSerialiser()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void GroupedPropertiesSerialiser.<init>()"})
  void testNewGroupedPropertiesSerialiser() {
    // Arrange and Act
    GroupedPropertiesSerialiser actualGroupedPropertiesSerialiser = new GroupedPropertiesSerialiser();

    // Assert
    assertNull(actualGroupedPropertiesSerialiser.schema);
    assertFalse(actualGroupedPropertiesSerialiser.isConsistent());
  }

  /**
   * Test {@link GroupedPropertiesSerialiser#canHandle(Class)}.
   * <ul>
   *   <li>When {@code Object}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GroupedPropertiesSerialiser#canHandle(Class)}
   */
  @Test
  @DisplayName("Test canHandle(Class); when 'java.lang.Object'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean GroupedPropertiesSerialiser.canHandle(Class)"})
  void testCanHandle_whenJavaLangObject_thenReturnFalse() {
    // Arrange
    GroupedPropertiesSerialiser groupedPropertiesSerialiser = new GroupedPropertiesSerialiser();
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertFalse(groupedPropertiesSerialiser.canHandle(clazz));
  }

  /**
   * Test {@link GroupedPropertiesSerialiser#canHandle(Class)}.
   * <ul>
   *   <li>When {@code GroupedProperties}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GroupedPropertiesSerialiser#canHandle(Class)}
   */
  @Test
  @DisplayName("Test canHandle(Class); when 'uk.gov.gchq.gaffer.data.element.GroupedProperties'; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean GroupedPropertiesSerialiser.canHandle(Class)"})
  void testCanHandle_whenUkGovGchqGafferDataElementGroupedProperties_thenReturnTrue() {
    // Arrange
    GroupedPropertiesSerialiser groupedPropertiesSerialiser = new GroupedPropertiesSerialiser();
    Class<GroupedProperties> clazz = GroupedProperties.class;

    // Act and Assert
    assertTrue(groupedPropertiesSerialiser.canHandle(clazz));
  }

  /**
   * Test {@link GroupedPropertiesSerialiser#serialise(GroupedProperties)} with {@code GroupedProperties}.
   * <ul>
   *   <li>Given empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link GroupedPropertiesSerialiser#serialise(GroupedProperties)}
   */
  @Test
  @DisplayName("Test serialise(GroupedProperties) with 'GroupedProperties'; given empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"byte[] GroupedPropertiesSerialiser.serialise(GroupedProperties)"})
  void testSerialiseWithGroupedProperties_givenEmptyString() throws SerialisationException {
    // Arrange
    GroupedPropertiesSerialiser groupedPropertiesSerialiser = new GroupedPropertiesSerialiser(new Schema());

    GroupedProperties properties = new GroupedProperties();
    properties.setGroup("");

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> groupedPropertiesSerialiser.serialise(properties));
  }

  /**
   * Test {@link GroupedPropertiesSerialiser#serialise(GroupedProperties)} with {@code GroupedProperties}.
   * <ul>
   *   <li>Then throw {@link SerialisationException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GroupedPropertiesSerialiser#serialise(GroupedProperties)}
   */
  @Test
  @DisplayName("Test serialise(GroupedProperties) with 'GroupedProperties'; then throw SerialisationException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"byte[] GroupedPropertiesSerialiser.serialise(GroupedProperties)"})
  void testSerialiseWithGroupedProperties_thenThrowSerialisationException() throws SerialisationException {
    // Arrange
    GroupedPropertiesSerialiser groupedPropertiesSerialiser = new GroupedPropertiesSerialiser(new Schema());

    GroupedProperties properties = new GroupedProperties();
    properties.setGroup("Group is required for serialising ");

    // Act and Assert
    assertThrows(SerialisationException.class, () -> groupedPropertiesSerialiser.serialise(properties));
  }

  /**
   * Test {@link GroupedPropertiesSerialiser#serialise(GroupedProperties)} with {@code GroupedProperties}.
   * <ul>
   *   <li>When {@link GroupedProperties#GroupedProperties()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GroupedPropertiesSerialiser#serialise(GroupedProperties)}
   */
  @Test
  @DisplayName("Test serialise(GroupedProperties) with 'GroupedProperties'; when GroupedProperties()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"byte[] GroupedPropertiesSerialiser.serialise(GroupedProperties)"})
  void testSerialiseWithGroupedProperties_whenGroupedProperties() throws SerialisationException {
    // Arrange
    GroupedPropertiesSerialiser groupedPropertiesSerialiser = new GroupedPropertiesSerialiser();

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> groupedPropertiesSerialiser.serialise(new GroupedProperties()));
  }

  /**
   * Test {@link GroupedPropertiesSerialiser#deserialise(byte[])} with {@code bytes}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GroupedPropertiesSerialiser#deserialise(byte[])}
   */
  @Test
  @DisplayName("Test deserialise(byte[]) with 'bytes'; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"GroupedProperties GroupedPropertiesSerialiser.deserialise(byte[])"})
  void testDeserialiseWithBytes_thenThrowIllegalArgumentException() throws SerialisationException {
    // Arrange
    GroupedPropertiesSerialiser groupedPropertiesSerialiser = new GroupedPropertiesSerialiser();
    groupedPropertiesSerialiser.updateSchema(new Schema());

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> groupedPropertiesSerialiser.deserialise(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test {@link GroupedPropertiesSerialiser#deserialise(byte[])} with {@code bytes}.
   * <ul>
   *   <li>Then throw {@link SerialisationException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GroupedPropertiesSerialiser#deserialise(byte[])}
   */
  @Test
  @DisplayName("Test deserialise(byte[]) with 'bytes'; then throw SerialisationException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"GroupedProperties GroupedPropertiesSerialiser.deserialise(byte[])"})
  void testDeserialiseWithBytes_thenThrowSerialisationException() throws SerialisationException {
    // Arrange
    GroupedPropertiesSerialiser groupedPropertiesSerialiser = new GroupedPropertiesSerialiser();
    groupedPropertiesSerialiser.updateSchema(new Schema());

    // Act and Assert
    assertThrows(SerialisationException.class,
        () -> groupedPropertiesSerialiser.deserialise(new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test {@link GroupedPropertiesSerialiser#deserialiseEmpty()}.
   * <p>
   * Method under test: {@link GroupedPropertiesSerialiser#deserialiseEmpty()}
   */
  @Test
  @DisplayName("Test deserialiseEmpty()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"GroupedProperties GroupedPropertiesSerialiser.deserialiseEmpty()"})
  void testDeserialiseEmpty() throws SerialisationException {
    // Arrange, Act and Assert
    assertNull((new GroupedPropertiesSerialiser()).deserialiseEmpty());
  }

  /**
   * Test {@link GroupedPropertiesSerialiser#getGroup(byte[])}.
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   *   <li>Then return {@code XAXAXAX}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GroupedPropertiesSerialiser#getGroup(byte[])}
   */
  @Test
  @DisplayName("Test getGroup(byte[]); when 'AXAXAXAX' Bytes is 'UTF-8'; then return 'XAXAXAX'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String GroupedPropertiesSerialiser.getGroup(byte[])"})
  void testGetGroup_whenAxaxaxaxBytesIsUtf8_thenReturnXaxaxax()
      throws UnsupportedEncodingException, SerialisationException {
    // Arrange
    GroupedPropertiesSerialiser groupedPropertiesSerialiser = new GroupedPropertiesSerialiser();

    // Act and Assert
    assertEquals(
        "XAXAXAX\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000",
        groupedPropertiesSerialiser.getGroup("AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link GroupedPropertiesSerialiser#getGroup(byte[])}.
   * <ul>
   *   <li>When empty array of {@code byte}.</li>
   *   <li>Then return empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link GroupedPropertiesSerialiser#getGroup(byte[])}
   */
  @Test
  @DisplayName("Test getGroup(byte[]); when empty array of byte; then return empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String GroupedPropertiesSerialiser.getGroup(byte[])"})
  void testGetGroup_whenEmptyArrayOfByte_thenReturnEmptyString() throws SerialisationException {
    // Arrange, Act and Assert
    assertEquals("", (new GroupedPropertiesSerialiser()).getGroup(new byte[]{}));
  }

  /**
   * Test {@link GroupedPropertiesSerialiser#getGroup(byte[])}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link GroupedPropertiesSerialiser#getGroup(byte[])}
   */
  @Test
  @DisplayName("Test getGroup(byte[]); when 'null'; then return empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String GroupedPropertiesSerialiser.getGroup(byte[])"})
  void testGetGroup_whenNull_thenReturnEmptyString() throws SerialisationException {
    // Arrange, Act and Assert
    assertEquals("", (new GroupedPropertiesSerialiser()).getGroup(null));
  }

  /**
   * Test {@link GroupedPropertiesSerialiser#isConsistent()}.
   * <p>
   * Method under test: {@link GroupedPropertiesSerialiser#isConsistent()}
   */
  @Test
  @DisplayName("Test isConsistent()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean GroupedPropertiesSerialiser.isConsistent()"})
  void testIsConsistent() {
    // Arrange, Act and Assert
    assertFalse((new GroupedPropertiesSerialiser()).isConsistent());
  }
}
