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

package uk.gov.gchq.gaffer.store.serialiser;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;
import java.util.HashSet;
import java.util.LinkedHashSet;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import uk.gov.gchq.gaffer.data.element.Properties;
import uk.gov.gchq.gaffer.exception.SerialisationException;
import uk.gov.gchq.gaffer.serialisation.AvroSerialiser;
import uk.gov.gchq.gaffer.store.schema.SchemaEdgeDefinition;
import uk.gov.gchq.gaffer.store.schema.SchemaElementDefinition;
import uk.gov.gchq.gaffer.store.schema.TypeDefinition;

class PropertiesSerialiserDiffblueTest {
  /**
   * Test {@link PropertiesSerialiser#preservesObjectOrdering()}.
   *
   * <p>Method under test: {@link PropertiesSerialiser#preservesObjectOrdering()}
   */
  @Test
  @DisplayName("Test preservesObjectOrdering()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PropertiesSerialiser.preservesObjectOrdering()"})
  void testPreservesObjectOrdering() {
    // Arrange, Act and Assert
    assertFalse(new EdgeSerialiser().preservesObjectOrdering());
  }

  /**
   * Test {@link PropertiesSerialiser#serialiseProperties(Properties, SchemaElementDefinition,
   * ByteArrayOutputStream)}.
   *
   * <p>Method under test: {@link PropertiesSerialiser#serialiseProperties(Properties,
   * SchemaElementDefinition, ByteArrayOutputStream)}
   */
  @Test
  @DisplayName(
      "Test serialiseProperties(Properties, SchemaElementDefinition, ByteArrayOutputStream)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PropertiesSerialiser.serialiseProperties(Properties, SchemaElementDefinition, ByteArrayOutputStream)"
  })
  void testSerialiseProperties() throws SerialisationException {
    // Arrange
    EdgeSerialiser edgeSerialiser = new EdgeSerialiser();
    Properties properties = new Properties();

    LinkedHashSet<String> stringSet = new LinkedHashSet<>();
    stringSet.add("Properties");
    Class<Object> clazz = Object.class;

    TypeDefinition typeDefinition = new TypeDefinition(clazz);
    typeDefinition.setSerialiser(new EdgeIdSerialiser());

    SchemaEdgeDefinition elementDefinition = mock(SchemaEdgeDefinition.class);
    when(elementDefinition.getPropertyTypeDef(Mockito.<String>any())).thenReturn(typeDefinition);
    when(elementDefinition.getProperties()).thenReturn(stringSet);
    ByteArrayOutputStream out = new ByteArrayOutputStream();

    // Act
    edgeSerialiser.serialiseProperties(properties, elementDefinition, out);

    // Assert
    verify(elementDefinition).getProperties();
    verify(elementDefinition).getPropertyTypeDef("Properties");
    assertArrayEquals(new byte[] {0}, out.toByteArray());
  }

  /**
   * Test {@link PropertiesSerialiser#serialiseProperties(Properties, SchemaElementDefinition,
   * ByteArrayOutputStream)}.
   *
   * <p>Method under test: {@link PropertiesSerialiser#serialiseProperties(Properties,
   * SchemaElementDefinition, ByteArrayOutputStream)}
   */
  @Test
  @DisplayName(
      "Test serialiseProperties(Properties, SchemaElementDefinition, ByteArrayOutputStream)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PropertiesSerialiser.serialiseProperties(Properties, SchemaElementDefinition, ByteArrayOutputStream)"
  })
  void testSerialiseProperties2() throws UnsupportedEncodingException, SerialisationException {
    // Arrange
    EdgeSerialiser edgeSerialiser = new EdgeSerialiser();
    Properties properties = new Properties();

    LinkedHashSet<String> stringSet = new LinkedHashSet<>();
    stringSet.add("Properties");

    AvroSerialiser serialiser = mock(AvroSerialiser.class);
    when(serialiser.serialiseNull()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    Class<Object> clazz = Object.class;

    TypeDefinition typeDefinition = new TypeDefinition(clazz);
    typeDefinition.setSerialiser(serialiser);

    SchemaEdgeDefinition elementDefinition = mock(SchemaEdgeDefinition.class);
    when(elementDefinition.getPropertyTypeDef(Mockito.<String>any())).thenReturn(typeDefinition);
    when(elementDefinition.getProperties()).thenReturn(stringSet);
    ByteArrayOutputStream out = new ByteArrayOutputStream();

    // Act
    edgeSerialiser.serialiseProperties(properties, elementDefinition, out);

    // Assert
    verify(serialiser).serialiseNull();
    verify(elementDefinition).getProperties();
    verify(elementDefinition).getPropertyTypeDef("Properties");
    byte[] expectedToByteArrayResult = "\bAXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedToByteArrayResult, out.toByteArray());
  }

  /**
   * Test {@link PropertiesSerialiser#serialiseProperties(Properties, SchemaElementDefinition,
   * ByteArrayOutputStream)}.
   *
   * <ul>
   *   <li>Given {@link HashSet#HashSet()}.
   * </ul>
   *
   * <p>Method under test: {@link PropertiesSerialiser#serialiseProperties(Properties,
   * SchemaElementDefinition, ByteArrayOutputStream)}
   */
  @Test
  @DisplayName(
      "Test serialiseProperties(Properties, SchemaElementDefinition, ByteArrayOutputStream); given HashSet()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PropertiesSerialiser.serialiseProperties(Properties, SchemaElementDefinition, ByteArrayOutputStream)"
  })
  void testSerialiseProperties_givenHashSet() throws SerialisationException {
    // Arrange
    EdgeSerialiser edgeSerialiser = new EdgeSerialiser();
    Properties properties = new Properties();

    SchemaEdgeDefinition elementDefinition = mock(SchemaEdgeDefinition.class);
    when(elementDefinition.getProperties()).thenReturn(new HashSet<>());
    ByteArrayOutputStream out = new ByteArrayOutputStream();

    // Act
    edgeSerialiser.serialiseProperties(properties, elementDefinition, out);

    // Assert that nothing has changed
    verify(elementDefinition).getProperties();
    assertArrayEquals(new byte[] {}, out.toByteArray());
  }

  /**
   * Test {@link PropertiesSerialiser#serialiseProperties(Properties, SchemaElementDefinition,
   * ByteArrayOutputStream)}.
   *
   * <ul>
   *   <li>Given {@link TypeDefinition#TypeDefinition(Class)} with clazz is {@link Object}
   *       Serialiser is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PropertiesSerialiser#serialiseProperties(Properties,
   * SchemaElementDefinition, ByteArrayOutputStream)}
   */
  @Test
  @DisplayName(
      "Test serialiseProperties(Properties, SchemaElementDefinition, ByteArrayOutputStream); given TypeDefinition(Class) with clazz is Object Serialiser is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PropertiesSerialiser.serialiseProperties(Properties, SchemaElementDefinition, ByteArrayOutputStream)"
  })
  void testSerialiseProperties_givenTypeDefinitionWithClazzIsObjectSerialiserIsNull()
      throws SerialisationException {
    // Arrange
    EdgeSerialiser edgeSerialiser = new EdgeSerialiser();
    Properties properties = new Properties();

    LinkedHashSet<String> stringSet = new LinkedHashSet<>();
    stringSet.add("Properties");
    Class<Object> clazz = Object.class;

    TypeDefinition typeDefinition = new TypeDefinition(clazz);
    typeDefinition.setSerialiser(null);

    SchemaEdgeDefinition elementDefinition = mock(SchemaEdgeDefinition.class);
    when(elementDefinition.getPropertyTypeDef(Mockito.<String>any())).thenReturn(typeDefinition);
    when(elementDefinition.getProperties()).thenReturn(stringSet);
    ByteArrayOutputStream out = new ByteArrayOutputStream();

    // Act
    edgeSerialiser.serialiseProperties(properties, elementDefinition, out);

    // Assert
    verify(elementDefinition).getProperties();
    verify(elementDefinition).getPropertyTypeDef("Properties");
    assertArrayEquals(new byte[] {0}, out.toByteArray());
  }

  /**
   * Test {@link PropertiesSerialiser#serialiseProperties(Properties, SchemaElementDefinition,
   * ByteArrayOutputStream)}.
   *
   * <ul>
   *   <li>When {@link SchemaEdgeDefinition} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link PropertiesSerialiser#serialiseProperties(Properties,
   * SchemaElementDefinition, ByteArrayOutputStream)}
   */
  @Test
  @DisplayName(
      "Test serialiseProperties(Properties, SchemaElementDefinition, ByteArrayOutputStream); when SchemaEdgeDefinition (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PropertiesSerialiser.serialiseProperties(Properties, SchemaElementDefinition, ByteArrayOutputStream)"
  })
  void testSerialiseProperties_whenSchemaEdgeDefinition() throws SerialisationException {
    // Arrange
    EdgeSerialiser edgeSerialiser = new EdgeSerialiser();
    Properties properties = new Properties();
    SchemaEdgeDefinition elementDefinition = new SchemaEdgeDefinition();
    ByteArrayOutputStream out = new ByteArrayOutputStream();

    // Act
    edgeSerialiser.serialiseProperties(properties, elementDefinition, out);

    // Assert that nothing has changed
    assertArrayEquals(new byte[] {}, out.toByteArray());
  }

  /**
   * Test {@link PropertiesSerialiser#deserialiseProperties(byte[], Properties,
   * SchemaElementDefinition, int[])}.
   *
   * <ul>
   *   <li>Given {@link HashSet#HashSet()}.
   * </ul>
   *
   * <p>Method under test: {@link PropertiesSerialiser#deserialiseProperties(byte[], Properties,
   * SchemaElementDefinition, int[])}
   */
  @Test
  @DisplayName(
      "Test deserialiseProperties(byte[], Properties, SchemaElementDefinition, int[]); given HashSet()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PropertiesSerialiser.deserialiseProperties(byte[], Properties, SchemaElementDefinition, int[])"
  })
  void testDeserialiseProperties_givenHashSet()
      throws UnsupportedEncodingException, SerialisationException {
    // Arrange
    EdgeSerialiser edgeSerialiser = new EdgeSerialiser();
    byte[] bytes = "AXAXAXAX".getBytes("UTF-8");
    Properties properties = new Properties();

    SchemaEdgeDefinition elementDefinition = mock(SchemaEdgeDefinition.class);
    when(elementDefinition.getProperties()).thenReturn(new HashSet<>());

    // Act
    edgeSerialiser.deserialiseProperties(bytes, properties, elementDefinition, 1, 0, 1, 0);

    // Assert
    verify(elementDefinition).getProperties();
  }

  /**
   * Test {@link PropertiesSerialiser#deserialiseProperties(byte[], Properties,
   * SchemaElementDefinition, int[])}.
   *
   * <ul>
   *   <li>Given {@link LinkedHashSet#LinkedHashSet()} add {@code Properties}.
   *   <li>Then calls {@link SchemaEdgeDefinition#getProperties()}.
   * </ul>
   *
   * <p>Method under test: {@link PropertiesSerialiser#deserialiseProperties(byte[], Properties,
   * SchemaElementDefinition, int[])}
   */
  @Test
  @DisplayName(
      "Test deserialiseProperties(byte[], Properties, SchemaElementDefinition, int[]); given LinkedHashSet() add 'Properties'; then calls getProperties()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PropertiesSerialiser.deserialiseProperties(byte[], Properties, SchemaElementDefinition, int[])"
  })
  void testDeserialiseProperties_givenLinkedHashSetAddProperties_thenCallsGetProperties()
      throws SerialisationException {
    // Arrange
    EdgeSerialiser edgeSerialiser = new EdgeSerialiser();
    Properties properties = new Properties();

    LinkedHashSet<String> stringSet = new LinkedHashSet<>();
    stringSet.add("Properties");

    SchemaEdgeDefinition elementDefinition = mock(SchemaEdgeDefinition.class);
    when(elementDefinition.getProperties()).thenReturn(stringSet);

    // Act
    edgeSerialiser.deserialiseProperties(new byte[] {}, properties, elementDefinition, 1, 0, 1, 0);

    // Assert
    verify(elementDefinition).getProperties();
  }

  /**
   * Test {@link PropertiesSerialiser#equals(Object)}, and {@link PropertiesSerialiser#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link PropertiesSerialiser#equals(Object)}
   *   <li>{@link PropertiesSerialiser#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean PropertiesSerialiser.equals(Object)",
    "int PropertiesSerialiser.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    EdgeSerialiser edgeSerialiser = new EdgeSerialiser();
    EdgeSerialiser edgeSerialiser2 = new EdgeSerialiser();

    // Act and Assert
    assertEquals(edgeSerialiser, edgeSerialiser2);
    assertEquals(edgeSerialiser.hashCode(), edgeSerialiser2.hashCode());
  }

  /**
   * Test {@link PropertiesSerialiser#equals(Object)}, and {@link PropertiesSerialiser#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link PropertiesSerialiser#equals(Object)}
   *   <li>{@link PropertiesSerialiser#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean PropertiesSerialiser.equals(Object)",
    "int PropertiesSerialiser.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    EdgeSerialiser edgeSerialiser = new EdgeSerialiser();

    // Act and Assert
    assertEquals(edgeSerialiser, edgeSerialiser);
    int expectedHashCodeResult = edgeSerialiser.hashCode();
    assertEquals(expectedHashCodeResult, edgeSerialiser.hashCode());
  }

  /**
   * Test {@link PropertiesSerialiser#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link PropertiesSerialiser#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean PropertiesSerialiser.equals(Object)",
    "int PropertiesSerialiser.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new EdgeSerialiser(), null);
  }

  /**
   * Test {@link PropertiesSerialiser#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link PropertiesSerialiser#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean PropertiesSerialiser.equals(Object)",
    "int PropertiesSerialiser.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new EdgeSerialiser(), null);
  }

  /**
   * Test {@link PropertiesSerialiser#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link PropertiesSerialiser#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean PropertiesSerialiser.equals(Object)",
    "int PropertiesSerialiser.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new EdgeSerialiser(), "Different type to PropertiesSerialiser");
  }
}
