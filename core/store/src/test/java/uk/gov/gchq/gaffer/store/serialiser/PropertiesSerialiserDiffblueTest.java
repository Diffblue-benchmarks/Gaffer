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

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;
import java.util.HashSet;
import java.util.function.BinaryOperator;
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
import uk.gov.gchq.gaffer.store.schema.TypeDefinition.Builder;

class PropertiesSerialiserDiffblueTest {
  /**
   * Test {@link PropertiesSerialiser#preservesObjectOrdering()}.
   * <p>
   * Method under test: {@link PropertiesSerialiser#preservesObjectOrdering()}
   */
  @Test
  @DisplayName("Test preservesObjectOrdering()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean PropertiesSerialiser.preservesObjectOrdering()"})
  void testPreservesObjectOrdering() {
    // Arrange, Act and Assert
    assertFalse((new EdgeSerialiser()).preservesObjectOrdering());
  }

  /**
   * Test {@link PropertiesSerialiser#serialiseProperties(Properties, SchemaElementDefinition, ByteArrayOutputStream)}.
   * <p>
   * Method under test: {@link PropertiesSerialiser#serialiseProperties(Properties, SchemaElementDefinition, ByteArrayOutputStream)}
   */
  @Test
  @DisplayName("Test serialiseProperties(Properties, SchemaElementDefinition, ByteArrayOutputStream)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "void PropertiesSerialiser.serialiseProperties(Properties, SchemaElementDefinition, ByteArrayOutputStream)"})
  void testSerialiseProperties() throws SerialisationException {
    // Arrange
    EdgeSerialiser edgeSerialiser = new EdgeSerialiser();
    Properties properties = new Properties();

    HashSet<String> stringSet = new HashSet<>();
    stringSet.add("foo");
    SchemaEdgeDefinition elementDefinition = mock(SchemaEdgeDefinition.class);
    TypeDefinition buildResult = (new Builder())
        .<BinaryOperator<Object>, Object>aggregateFunction(mock(BinaryOperator.class))
        .build();
    when(elementDefinition.getPropertyTypeDef(Mockito.<String>any())).thenReturn(buildResult);
    when(elementDefinition.getProperties()).thenReturn(stringSet);
    ByteArrayOutputStream out = new ByteArrayOutputStream(1);

    // Act
    edgeSerialiser.serialiseProperties(properties, elementDefinition, out);

    // Assert
    verify(elementDefinition).getProperties();
    verify(elementDefinition).getPropertyTypeDef(eq("foo"));
    assertArrayEquals(new byte[]{0}, out.toByteArray());
  }

  /**
   * Test {@link PropertiesSerialiser#serialiseProperties(Properties, SchemaElementDefinition, ByteArrayOutputStream)}.
   * <p>
   * Method under test: {@link PropertiesSerialiser#serialiseProperties(Properties, SchemaElementDefinition, ByteArrayOutputStream)}
   */
  @Test
  @DisplayName("Test serialiseProperties(Properties, SchemaElementDefinition, ByteArrayOutputStream)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "void PropertiesSerialiser.serialiseProperties(Properties, SchemaElementDefinition, ByteArrayOutputStream)"})
  void testSerialiseProperties2() throws UnsupportedEncodingException, SerialisationException {
    // Arrange
    EdgeSerialiser edgeSerialiser = new EdgeSerialiser();
    Properties properties = new Properties();

    HashSet<String> stringSet = new HashSet<>();
    stringSet.add("foo");
    AvroSerialiser serialiser = mock(AvroSerialiser.class);
    when(serialiser.serialiseNull()).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    Builder builder = new Builder();
    builder.serialiser(serialiser);
    TypeDefinition buildResult = builder.<BinaryOperator<Object>, Object>aggregateFunction(mock(BinaryOperator.class))
        .build();
    SchemaEdgeDefinition elementDefinition = mock(SchemaEdgeDefinition.class);
    when(elementDefinition.getPropertyTypeDef(Mockito.<String>any())).thenReturn(buildResult);
    when(elementDefinition.getProperties()).thenReturn(stringSet);
    ByteArrayOutputStream out = new ByteArrayOutputStream(1);

    // Act
    edgeSerialiser.serialiseProperties(properties, elementDefinition, out);

    // Assert
    verify(serialiser).serialiseNull();
    verify(elementDefinition).getProperties();
    verify(elementDefinition).getPropertyTypeDef(eq("foo"));
    byte[] expectedToByteArrayResult = "\bAXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedToByteArrayResult, out.toByteArray());
  }

  /**
   * Test {@link PropertiesSerialiser#serialiseProperties(Properties, SchemaElementDefinition, ByteArrayOutputStream)}.
   * <ul>
   *   <li>Given {@link Builder} (default constructor) serialiser {@link EdgeIdSerialiser#EdgeIdSerialiser()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PropertiesSerialiser#serialiseProperties(Properties, SchemaElementDefinition, ByteArrayOutputStream)}
   */
  @Test
  @DisplayName("Test serialiseProperties(Properties, SchemaElementDefinition, ByteArrayOutputStream); given Builder (default constructor) serialiser EdgeIdSerialiser()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "void PropertiesSerialiser.serialiseProperties(Properties, SchemaElementDefinition, ByteArrayOutputStream)"})
  void testSerialiseProperties_givenBuilderSerialiserEdgeIdSerialiser() throws SerialisationException {
    // Arrange
    EdgeSerialiser edgeSerialiser = new EdgeSerialiser();
    Properties properties = new Properties();

    HashSet<String> stringSet = new HashSet<>();
    stringSet.add("foo");

    Builder builder = new Builder();
    builder.serialiser(new EdgeIdSerialiser());
    TypeDefinition buildResult = builder.<BinaryOperator<Object>, Object>aggregateFunction(mock(BinaryOperator.class))
        .build();
    SchemaEdgeDefinition elementDefinition = mock(SchemaEdgeDefinition.class);
    when(elementDefinition.getPropertyTypeDef(Mockito.<String>any())).thenReturn(buildResult);
    when(elementDefinition.getProperties()).thenReturn(stringSet);
    ByteArrayOutputStream out = new ByteArrayOutputStream(1);

    // Act
    edgeSerialiser.serialiseProperties(properties, elementDefinition, out);

    // Assert
    verify(elementDefinition).getProperties();
    verify(elementDefinition).getPropertyTypeDef(eq("foo"));
    assertArrayEquals(new byte[]{0}, out.toByteArray());
  }

  /**
   * Test {@link PropertiesSerialiser#serialiseProperties(Properties, SchemaElementDefinition, ByteArrayOutputStream)}.
   * <ul>
   *   <li>Given {@link HashSet#HashSet()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PropertiesSerialiser#serialiseProperties(Properties, SchemaElementDefinition, ByteArrayOutputStream)}
   */
  @Test
  @DisplayName("Test serialiseProperties(Properties, SchemaElementDefinition, ByteArrayOutputStream); given HashSet()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "void PropertiesSerialiser.serialiseProperties(Properties, SchemaElementDefinition, ByteArrayOutputStream)"})
  void testSerialiseProperties_givenHashSet() throws SerialisationException {
    // Arrange
    EdgeSerialiser edgeSerialiser = new EdgeSerialiser();
    Properties properties = new Properties();
    SchemaEdgeDefinition elementDefinition = mock(SchemaEdgeDefinition.class);
    when(elementDefinition.getProperties()).thenReturn(new HashSet<>());
    ByteArrayOutputStream out = new ByteArrayOutputStream(1);

    // Act
    edgeSerialiser.serialiseProperties(properties, elementDefinition, out);

    // Assert that nothing has changed
    verify(elementDefinition).getProperties();
    assertArrayEquals(new byte[]{}, out.toByteArray());
  }

  /**
   * Test {@link PropertiesSerialiser#serialiseProperties(Properties, SchemaElementDefinition, ByteArrayOutputStream)}.
   * <ul>
   *   <li>When {@link SchemaEdgeDefinition} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link PropertiesSerialiser#serialiseProperties(Properties, SchemaElementDefinition, ByteArrayOutputStream)}
   */
  @Test
  @DisplayName("Test serialiseProperties(Properties, SchemaElementDefinition, ByteArrayOutputStream); when SchemaEdgeDefinition (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "void PropertiesSerialiser.serialiseProperties(Properties, SchemaElementDefinition, ByteArrayOutputStream)"})
  void testSerialiseProperties_whenSchemaEdgeDefinition() throws SerialisationException {
    // Arrange
    EdgeSerialiser edgeSerialiser = new EdgeSerialiser();
    Properties properties = new Properties();
    SchemaEdgeDefinition elementDefinition = new SchemaEdgeDefinition();
    ByteArrayOutputStream out = new ByteArrayOutputStream(1);

    // Act
    edgeSerialiser.serialiseProperties(properties, elementDefinition, out);

    // Assert that nothing has changed
    assertArrayEquals(new byte[]{}, out.toByteArray());
  }

  /**
   * Test {@link PropertiesSerialiser#deserialiseProperties(byte[], Properties, SchemaElementDefinition, int[])}.
   * <ul>
   *   <li>Given {@link HashSet#HashSet()} add {@code foo}.</li>
   *   <li>Then calls {@link SchemaElementDefinition#getProperties()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PropertiesSerialiser#deserialiseProperties(byte[], Properties, SchemaElementDefinition, int[])}
   */
  @Test
  @DisplayName("Test deserialiseProperties(byte[], Properties, SchemaElementDefinition, int[]); given HashSet() add 'foo'; then calls getProperties()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "void PropertiesSerialiser.deserialiseProperties(byte[], Properties, SchemaElementDefinition, int[])"})
  void testDeserialiseProperties_givenHashSetAddFoo_thenCallsGetProperties() throws SerialisationException {
    // Arrange
    EdgeSerialiser edgeSerialiser = new EdgeSerialiser();
    Properties properties = new Properties();

    HashSet<String> stringSet = new HashSet<>();
    stringSet.add("foo");
    SchemaEdgeDefinition elementDefinition = mock(SchemaEdgeDefinition.class);
    when(elementDefinition.getProperties()).thenReturn(stringSet);

    // Act
    edgeSerialiser.deserialiseProperties(new byte[]{}, properties, elementDefinition, 1, 0, 1, 0);

    // Assert
    verify(elementDefinition).getProperties();
  }

  /**
   * Test {@link PropertiesSerialiser#deserialiseProperties(byte[], Properties, SchemaElementDefinition, int[])}.
   * <ul>
   *   <li>Given {@link HashSet#HashSet()}.</li>
   *   <li>Then calls {@link SchemaElementDefinition#getProperties()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PropertiesSerialiser#deserialiseProperties(byte[], Properties, SchemaElementDefinition, int[])}
   */
  @Test
  @DisplayName("Test deserialiseProperties(byte[], Properties, SchemaElementDefinition, int[]); given HashSet(); then calls getProperties()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "void PropertiesSerialiser.deserialiseProperties(byte[], Properties, SchemaElementDefinition, int[])"})
  void testDeserialiseProperties_givenHashSet_thenCallsGetProperties()
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
   * Test {@link PropertiesSerialiser#equals(Object)}, and {@link PropertiesSerialiser#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link PropertiesSerialiser#equals(Object)}
   *   <li>{@link PropertiesSerialiser#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean PropertiesSerialiser.equals(Object)", "int PropertiesSerialiser.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    EdgeSerialiser edgeSerialiser = new EdgeSerialiser();
    EdgeSerialiser edgeSerialiser2 = new EdgeSerialiser();

    // Act and Assert
    assertEquals(edgeSerialiser, edgeSerialiser2);
    int expectedHashCodeResult = edgeSerialiser.hashCode();
    assertEquals(expectedHashCodeResult, edgeSerialiser2.hashCode());
  }

  /**
   * Test {@link PropertiesSerialiser#equals(Object)}, and {@link PropertiesSerialiser#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link PropertiesSerialiser#equals(Object)}
   *   <li>{@link PropertiesSerialiser#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean PropertiesSerialiser.equals(Object)", "int PropertiesSerialiser.hashCode()"})
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
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link PropertiesSerialiser#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean PropertiesSerialiser.equals(Object)", "int PropertiesSerialiser.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new EdgeSerialiser(), null);
  }

  /**
   * Test {@link PropertiesSerialiser#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link PropertiesSerialiser#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean PropertiesSerialiser.equals(Object)", "int PropertiesSerialiser.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new EdgeSerialiser(), null);
  }

  /**
   * Test {@link PropertiesSerialiser#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link PropertiesSerialiser#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean PropertiesSerialiser.equals(Object)", "int PropertiesSerialiser.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new EdgeSerialiser(), "Different type to PropertiesSerialiser");
  }
}
