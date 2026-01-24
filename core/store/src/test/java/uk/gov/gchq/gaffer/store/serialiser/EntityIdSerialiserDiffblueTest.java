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
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.UnsupportedEncodingException;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.data.element.Entity;
import uk.gov.gchq.gaffer.data.element.Entity.Builder;
import uk.gov.gchq.gaffer.data.element.id.EntityId;
import uk.gov.gchq.gaffer.exception.SerialisationException;
import uk.gov.gchq.gaffer.operation.data.EntitySeed;
import uk.gov.gchq.gaffer.serialisation.AvroSerialiser;
import uk.gov.gchq.gaffer.serialisation.FreqMapSerialiser;
import uk.gov.gchq.gaffer.serialisation.TypeSubTypeValueSerialiser;
import uk.gov.gchq.gaffer.store.schema.Schema;

class EntityIdSerialiserDiffblueTest {
  /**
   * Test {@link EntityIdSerialiser#EntityIdSerialiser()}.
   *
   * <ul>
   *   <li>Then return {@link EntityIdSerialiser#vertexSerialiser} is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link EntityIdSerialiser#EntityIdSerialiser()}
   */
  @Test
  @DisplayName("Test new EntityIdSerialiser(); then return vertexSerialiser is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void EntityIdSerialiser.<init>()",
    "void EntityIdSerialiser.<init>(uk.gov.gchq.gaffer.serialisation.ToBytesSerialiser)"
  })
  void testNewEntityIdSerialiser_thenReturnVertexSerialiserIsNull() {
    // Arrange and Act
    EntityIdSerialiser actualEntityIdSerialiser = new EntityIdSerialiser();

    // Assert
    assertNull(actualEntityIdSerialiser.vertexSerialiser);
    assertFalse(actualEntityIdSerialiser.isConsistent());
  }

  /**
   * Test {@link EntityIdSerialiser#EntityIdSerialiser(Schema)}.
   *
   * <ul>
   *   <li>When {@link Schema#Schema()}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link EntityIdSerialiser#EntityIdSerialiser(Schema)}
   */
  @Test
  @DisplayName(
      "Test new EntityIdSerialiser(Schema); when Schema(); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void EntityIdSerialiser.<init>(Schema)"})
  void testNewEntityIdSerialiser_whenSchema_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> new EntityIdSerialiser(new Schema()));
  }

  /**
   * Test {@link EntityIdSerialiser#canHandle(Class)}.
   *
   * <ul>
   *   <li>When {@code Object}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link EntityIdSerialiser#canHandle(Class)}
   */
  @Test
  @DisplayName("Test canHandle(Class); when 'java.lang.Object'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EntityIdSerialiser.canHandle(Class)"})
  void testCanHandle_whenJavaLangObject_thenReturnFalse() {
    // Arrange
    EntityIdSerialiser entityIdSerialiser = new EntityIdSerialiser();
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertFalse(entityIdSerialiser.canHandle(clazz));
  }

  /**
   * Test {@link EntityIdSerialiser#canHandle(Class)}.
   *
   * <ul>
   *   <li>When {@code EntityId}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link EntityIdSerialiser#canHandle(Class)}
   */
  @Test
  @DisplayName(
      "Test canHandle(Class); when 'uk.gov.gchq.gaffer.data.element.id.EntityId'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EntityIdSerialiser.canHandle(Class)"})
  void testCanHandle_whenUkGovGchqGafferDataElementIdEntityId_thenReturnTrue() {
    // Arrange
    EntityIdSerialiser entityIdSerialiser = new EntityIdSerialiser();
    Class<EntityId> clazz = EntityId.class;

    // Act and Assert
    assertTrue(entityIdSerialiser.canHandle(clazz));
  }

  /**
   * Test {@link EntityIdSerialiser#serialise(EntityId)} with {@code EntityId}.
   *
   * <p>Method under test: {@link EntityIdSerialiser#serialise(EntityId)}
   */
  @Test
  @DisplayName("Test serialise(EntityId) with 'EntityId'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] EntityIdSerialiser.serialise(EntityId)"})
  void testSerialiseWithEntityId() throws SerialisationException {
    // Arrange
    EntityIdSerialiser entityIdSerialiser = new EntityIdSerialiser(new EdgeIdSerialiser());

    // Act and Assert
    assertArrayEquals(new byte[] {0}, entityIdSerialiser.serialise(new EntitySeed()));
  }

  /**
   * Test {@link EntityIdSerialiser#serialise(EntityId)} with {@code EntityId}.
   *
   * <ul>
   *   <li>When {@link EntitySeed#EntitySeed()}.
   *   <li>Then return array of {@code byte} with zero.
   * </ul>
   *
   * <p>Method under test: {@link EntityIdSerialiser#serialise(EntityId)}
   */
  @Test
  @DisplayName(
      "Test serialise(EntityId) with 'EntityId'; when EntitySeed(); then return array of byte with zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] EntityIdSerialiser.serialise(EntityId)"})
  void testSerialiseWithEntityId_whenEntitySeed_thenReturnArrayOfByteWithZero()
      throws SerialisationException {
    // Arrange
    EntityIdSerialiser entityIdSerialiser = new EntityIdSerialiser();

    // Act and Assert
    assertArrayEquals(new byte[] {0}, entityIdSerialiser.serialise(new EntitySeed()));
  }

  /**
   * Test {@link EntityIdSerialiser#serialise(EntityId)} with {@code EntityId}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return empty array of {@code byte}.
   * </ul>
   *
   * <p>Method under test: {@link EntityIdSerialiser#serialise(EntityId)}
   */
  @Test
  @DisplayName(
      "Test serialise(EntityId) with 'EntityId'; when 'null'; then return empty array of byte")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] EntityIdSerialiser.serialise(EntityId)"})
  void testSerialiseWithEntityId_whenNull_thenReturnEmptyArrayOfByte()
      throws SerialisationException {
    // Arrange, Act and Assert
    assertArrayEquals(new byte[] {}, new EntityIdSerialiser().serialise(null));
  }

  /**
   * Test {@link EntityIdSerialiser#serialiseVertex(Object)}.
   *
   * <ul>
   *   <li>Then return array of {@code byte} with one and zero.
   * </ul>
   *
   * <p>Method under test: {@link EntityIdSerialiser#serialiseVertex(Object)}
   */
  @Test
  @DisplayName("Test serialiseVertex(Object); then return array of byte with one and zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] EntityIdSerialiser.serialiseVertex(Object)"})
  void testSerialiseVertex_thenReturnArrayOfByteWithOneAndZero() throws SerialisationException {
    // Arrange
    EntityIdSerialiser entityIdSerialiser = new EntityIdSerialiser(new EntityIdSerialiser());

    // Act
    byte[] actualSerialiseVertexResult =
        entityIdSerialiser.serialiseVertex(new Builder().group("Group").vertex("Vertex").build());

    // Assert
    assertArrayEquals(new byte[] {1, 0}, actualSerialiseVertexResult);
  }

  /**
   * Test {@link EntityIdSerialiser#serialiseVertex(Object)}.
   *
   * <ul>
   *   <li>Then return forty-sixth element is fourteen.
   * </ul>
   *
   * <p>Method under test: {@link EntityIdSerialiser#serialiseVertex(Object)}
   */
  @Test
  @DisplayName("Test serialiseVertex(Object); then return forty-sixth element is fourteen")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] EntityIdSerialiser.serialiseVertex(Object)"})
  void testSerialiseVertex_thenReturnFortySixthElementIsFourteen() throws SerialisationException {
    // Arrange and Act
    byte[] actualSerialiseVertexResult =
        new EntityIdSerialiser(new AvroSerialiser()).serialiseVertex("Vertex");

    // Assert
    assertEquals((byte) 14, actualSerialiseVertexResult[45]);
    assertEquals((byte) 16, actualSerialiseVertexResult[18]);
    assertEquals((byte) 1, actualSerialiseVertexResult[4]);
    assertEquals((byte) 22, actualSerialiseVertexResult[6]);
    assertEquals((byte) 2, actualSerialiseVertexResult[44]);
    assertEquals((byte) 2, actualSerialiseVertexResult[5]);
    assertEquals(69, actualSerialiseVertexResult.length);
    assertEquals('.', actualSerialiseVertexResult[11]);
    assertEquals('D', actualSerialiseVertexResult[0]);
    assertEquals('O', actualSerialiseVertexResult[1]);
    assertEquals('V', actualSerialiseVertexResult[47]);
    assertEquals('"', actualSerialiseVertexResult[19]);
    assertEquals('\f', actualSerialiseVertexResult[46]);
    assertEquals('a', actualSerialiseVertexResult[17]);
    assertEquals('a', actualSerialiseVertexResult[7]);
    assertEquals('b', actualSerialiseVertexResult[2]);
    assertEquals('c', actualSerialiseVertexResult[13]);
    assertEquals('e', actualSerialiseVertexResult[15]);
    assertEquals('e', actualSerialiseVertexResult[48]);
    assertEquals('e', actualSerialiseVertexResult[51]);
    assertEquals('h', actualSerialiseVertexResult[14]);
    assertEquals('i', actualSerialiseVertexResult[23]);
    assertEquals('j', actualSerialiseVertexResult[3]);
    assertEquals('m', actualSerialiseVertexResult[Short.SIZE]);
    assertEquals('n', actualSerialiseVertexResult[24]);
    assertEquals('o', actualSerialiseVertexResult[10]);
    assertEquals('r', actualSerialiseVertexResult[22]);
    assertEquals('r', actualSerialiseVertexResult[49]);
    assertEquals('r', actualSerialiseVertexResult[9]);
    assertEquals('s', actualSerialiseVertexResult[12]);
    assertEquals('s', actualSerialiseVertexResult[20]);
    assertEquals('t', actualSerialiseVertexResult[21]);
    assertEquals('t', actualSerialiseVertexResult[50]);
    assertEquals('v', actualSerialiseVertexResult[8]);
    assertEquals('x', actualSerialiseVertexResult[52]);
  }

  /**
   * Test {@link EntityIdSerialiser#serialiseVertex(Object)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return array of {@code byte} with zero.
   * </ul>
   *
   * <p>Method under test: {@link EntityIdSerialiser#serialiseVertex(Object)}
   */
  @Test
  @DisplayName("Test serialiseVertex(Object); when 'null'; then return array of byte with zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] EntityIdSerialiser.serialiseVertex(Object)"})
  void testSerialiseVertex_whenNull_thenReturnArrayOfByteWithZero() throws SerialisationException {
    // Arrange, Act and Assert
    assertArrayEquals(
        new byte[] {0}, new EntityIdSerialiser(new EntityIdSerialiser()).serialiseVertex(null));
  }

  /**
   * Test {@link EntityIdSerialiser#deserialise(byte[])} with {@code bytes}.
   *
   * <p>Method under test: {@link EntityIdSerialiser#deserialise(byte[])}
   */
  @Test
  @DisplayName("Test deserialise(byte[]) with 'bytes'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityId EntityIdSerialiser.deserialise(byte[])"})
  void testDeserialiseWithBytes() throws SerialisationException {
    // Arrange and Act
    EntityId actualDeserialiseResult =
        new EntityIdSerialiser(new EntityIdSerialiser()).deserialise(new byte[] {});

    // Assert
    assertTrue(actualDeserialiseResult instanceof EntitySeed);
    assertEquals(
        "uk.gov.gchq.gaffer.operation.data.EntitySeed", actualDeserialiseResult.getClassName());
    assertNull(actualDeserialiseResult.getVertex());
  }

  /**
   * Test {@link EntityIdSerialiser#deserialise(byte[])} with {@code bytes}.
   *
   * <ul>
   *   <li>Then return Vertex Empty.
   * </ul>
   *
   * <p>Method under test: {@link EntityIdSerialiser#deserialise(byte[])}
   */
  @Test
  @DisplayName("Test deserialise(byte[]) with 'bytes'; then return Vertex Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityId EntityIdSerialiser.deserialise(byte[])"})
  void testDeserialiseWithBytes_thenReturnVertexEmpty()
      throws UnsupportedEncodingException, SerialisationException {
    // Arrange and Act
    EntityId actualDeserialiseResult =
        new EntityIdSerialiser(new FreqMapSerialiser()).deserialise("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    Object vertex = actualDeserialiseResult.getVertex();
    assertTrue(vertex instanceof Map);
    assertTrue(actualDeserialiseResult instanceof EntitySeed);
    assertEquals(
        "uk.gov.gchq.gaffer.operation.data.EntitySeed", actualDeserialiseResult.getClassName());
    assertTrue(((Map<Object, Object>) vertex).isEmpty());
  }

  /**
   * Test {@link EntityIdSerialiser#deserialise(byte[])} with {@code bytes}.
   *
   * <ul>
   *   <li>Then return Vertex is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link EntityIdSerialiser#deserialise(byte[])}
   */
  @Test
  @DisplayName("Test deserialise(byte[]) with 'bytes'; then return Vertex is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityId EntityIdSerialiser.deserialise(byte[])"})
  void testDeserialiseWithBytes_thenReturnVertexIsNull() throws SerialisationException {
    // Arrange and Act
    EntityId actualDeserialiseResult =
        new EntityIdSerialiser(new EdgeIdSerialiser()).deserialise(new byte[] {});

    // Assert
    assertTrue(actualDeserialiseResult instanceof EntitySeed);
    assertEquals(
        "uk.gov.gchq.gaffer.operation.data.EntitySeed", actualDeserialiseResult.getClassName());
    assertNull(actualDeserialiseResult.getVertex());
  }

  /**
   * Test {@link EntityIdSerialiser#deserialise(byte[])} with {@code bytes}.
   *
   * <ul>
   *   <li>When array of {@code byte} with {@code A} and zero.
   *   <li>Then return Vertex size is one.
   * </ul>
   *
   * <p>Method under test: {@link EntityIdSerialiser#deserialise(byte[])}
   */
  @Test
  @DisplayName(
      "Test deserialise(byte[]) with 'bytes'; when array of byte with 'A' and zero; then return Vertex size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityId EntityIdSerialiser.deserialise(byte[])"})
  void testDeserialiseWithBytes_whenArrayOfByteWithAAndZero_thenReturnVertexSizeIsOne()
      throws SerialisationException {
    // Arrange and Act
    EntityId actualDeserialiseResult =
        new EntityIdSerialiser(new FreqMapSerialiser())
            .deserialise(new byte[] {'A', 0, 'A', 'X', 'A', 'X', 'A', 'X'});

    // Assert
    Object vertex = actualDeserialiseResult.getVertex();
    assertTrue(vertex instanceof Map);
    assertTrue(actualDeserialiseResult instanceof EntitySeed);
    assertEquals(
        "uk.gov.gchq.gaffer.operation.data.EntitySeed", actualDeserialiseResult.getClassName());
    assertEquals(1, ((Map<String, Long>) vertex).size());
    assertEquals(65L, ((Map<String, Long>) vertex).get("").longValue());
  }

  /**
   * Test {@link EntityIdSerialiser#deserialise(byte[])} with {@code bytes}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return Vertex is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link EntityIdSerialiser#deserialise(byte[])}
   */
  @Test
  @DisplayName("Test deserialise(byte[]) with 'bytes'; when 'null'; then return Vertex is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityId EntityIdSerialiser.deserialise(byte[])"})
  void testDeserialiseWithBytes_whenNull_thenReturnVertexIsNull() throws SerialisationException {
    // Arrange and Act
    EntityId actualDeserialiseResult =
        new EntityIdSerialiser(new EdgeIdSerialiser()).deserialise(null);

    // Assert
    assertTrue(actualDeserialiseResult instanceof EntitySeed);
    assertEquals(
        "uk.gov.gchq.gaffer.operation.data.EntitySeed", actualDeserialiseResult.getClassName());
    assertNull(actualDeserialiseResult.getVertex());
  }

  /**
   * Test {@link EntityIdSerialiser#deserialiseEmpty()}.
   *
   * <p>Method under test: {@link EntityIdSerialiser#deserialiseEmpty()}
   */
  @Test
  @DisplayName("Test deserialiseEmpty()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityId EntityIdSerialiser.deserialiseEmpty()"})
  void testDeserialiseEmpty() throws SerialisationException {
    // Arrange, Act and Assert
    assertNull(new EntityIdSerialiser().deserialiseEmpty());
  }

  /**
   * Test {@link EntityIdSerialiser#preservesObjectOrdering()}.
   *
   * <p>Method under test: {@link EntityIdSerialiser#preservesObjectOrdering()}
   */
  @Test
  @DisplayName("Test preservesObjectOrdering()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EntityIdSerialiser.preservesObjectOrdering()"})
  void testPreservesObjectOrdering() {
    // Arrange, Act and Assert
    assertFalse(new EntityIdSerialiser(new EdgeIdSerialiser()).preservesObjectOrdering());
  }

  /**
   * Test {@link EntityIdSerialiser#preservesObjectOrdering()}.
   *
   * <p>Method under test: {@link EntityIdSerialiser#preservesObjectOrdering()}
   */
  @Test
  @DisplayName("Test preservesObjectOrdering()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EntityIdSerialiser.preservesObjectOrdering()"})
  void testPreservesObjectOrdering2() {
    // Arrange, Act and Assert
    assertFalse(new EntityIdSerialiser(new EntityIdSerialiser()).preservesObjectOrdering());
  }

  /**
   * Test {@link EntityIdSerialiser#preservesObjectOrdering()}.
   *
   * <ul>
   *   <li>Given {@link EntityIdSerialiser#EntityIdSerialiser()}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link EntityIdSerialiser#preservesObjectOrdering()}
   */
  @Test
  @DisplayName("Test preservesObjectOrdering(); given EntityIdSerialiser(); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EntityIdSerialiser.preservesObjectOrdering()"})
  void testPreservesObjectOrdering_givenEntityIdSerialiser_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new EntityIdSerialiser().preservesObjectOrdering());
  }

  /**
   * Test {@link EntityIdSerialiser#preservesObjectOrdering()}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link EntityIdSerialiser#preservesObjectOrdering()}
   */
  @Test
  @DisplayName("Test preservesObjectOrdering(); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EntityIdSerialiser.preservesObjectOrdering()"})
  void testPreservesObjectOrdering_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(new EntityIdSerialiser(new TypeSubTypeValueSerialiser()).preservesObjectOrdering());
  }

  /**
   * Test {@link EntityIdSerialiser#isConsistent()}.
   *
   * <ul>
   *   <li>Given {@link EntityIdSerialiser#EntityIdSerialiser(ToBytesSerialiser)} with
   *       vertexSerialiser is {@link EdgeIdSerialiser#EdgeIdSerialiser()}.
   * </ul>
   *
   * <p>Method under test: {@link EntityIdSerialiser#isConsistent()}
   */
  @Test
  @DisplayName(
      "Test isConsistent(); given EntityIdSerialiser(ToBytesSerialiser) with vertexSerialiser is EdgeIdSerialiser()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EntityIdSerialiser.isConsistent()"})
  void testIsConsistent_givenEntityIdSerialiserWithVertexSerialiserIsEdgeIdSerialiser() {
    // Arrange, Act and Assert
    assertFalse(new EntityIdSerialiser(new EdgeIdSerialiser()).isConsistent());
  }

  /**
   * Test {@link EntityIdSerialiser#isConsistent()}.
   *
   * <ul>
   *   <li>Given {@link EntityIdSerialiser#EntityIdSerialiser(ToBytesSerialiser)} with
   *       vertexSerialiser is {@link EntityIdSerialiser#EntityIdSerialiser()}.
   * </ul>
   *
   * <p>Method under test: {@link EntityIdSerialiser#isConsistent()}
   */
  @Test
  @DisplayName(
      "Test isConsistent(); given EntityIdSerialiser(ToBytesSerialiser) with vertexSerialiser is EntityIdSerialiser()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EntityIdSerialiser.isConsistent()"})
  void testIsConsistent_givenEntityIdSerialiserWithVertexSerialiserIsEntityIdSerialiser() {
    // Arrange, Act and Assert
    assertFalse(new EntityIdSerialiser(new EntityIdSerialiser()).isConsistent());
  }

  /**
   * Test {@link EntityIdSerialiser#isConsistent()}.
   *
   * <ul>
   *   <li>Given {@link EntityIdSerialiser#EntityIdSerialiser()}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link EntityIdSerialiser#isConsistent()}
   */
  @Test
  @DisplayName("Test isConsistent(); given EntityIdSerialiser(); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EntityIdSerialiser.isConsistent()"})
  void testIsConsistent_givenEntityIdSerialiser_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new EntityIdSerialiser().isConsistent());
  }

  /**
   * Test {@link EntityIdSerialiser#isConsistent()}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link EntityIdSerialiser#isConsistent()}
   */
  @Test
  @DisplayName("Test isConsistent(); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EntityIdSerialiser.isConsistent()"})
  void testIsConsistent_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(new EntityIdSerialiser(new TypeSubTypeValueSerialiser()).isConsistent());
  }

  /**
   * Test {@link EntityIdSerialiser#equals(Object)}, and {@link EntityIdSerialiser#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EntityIdSerialiser#equals(Object)}
   *   <li>{@link EntityIdSerialiser#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EntityIdSerialiser.equals(Object)",
    "int EntityIdSerialiser.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    EntityIdSerialiser entityIdSerialiser = new EntityIdSerialiser();
    EntityIdSerialiser entityIdSerialiser2 = new EntityIdSerialiser();

    // Act and Assert
    assertEquals(entityIdSerialiser, entityIdSerialiser2);
    assertEquals(entityIdSerialiser.hashCode(), entityIdSerialiser2.hashCode());
  }

  /**
   * Test {@link EntityIdSerialiser#equals(Object)}, and {@link EntityIdSerialiser#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EntityIdSerialiser#equals(Object)}
   *   <li>{@link EntityIdSerialiser#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EntityIdSerialiser.equals(Object)",
    "int EntityIdSerialiser.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    EntityIdSerialiser entityIdSerialiser = new EntityIdSerialiser();

    // Act and Assert
    assertEquals(entityIdSerialiser, entityIdSerialiser);
    int expectedHashCodeResult = entityIdSerialiser.hashCode();
    assertEquals(expectedHashCodeResult, entityIdSerialiser.hashCode());
  }

  /**
   * Test {@link EntityIdSerialiser#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntityIdSerialiser#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EntityIdSerialiser.equals(Object)",
    "int EntityIdSerialiser.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    EntityIdSerialiser entityIdSerialiser = new EntityIdSerialiser(new EdgeIdSerialiser());

    // Act and Assert
    assertNotEquals(entityIdSerialiser, new EntityIdSerialiser());
  }

  /**
   * Test {@link EntityIdSerialiser#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntityIdSerialiser#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EntityIdSerialiser.equals(Object)",
    "int EntityIdSerialiser.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    EntityIdSerialiser entityIdSerialiser = new EntityIdSerialiser(new EntityIdSerialiser());

    // Act and Assert
    assertNotEquals(entityIdSerialiser, new EntityIdSerialiser(new EdgeIdSerialiser()));
  }

  /**
   * Test {@link EntityIdSerialiser#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntityIdSerialiser#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EntityIdSerialiser.equals(Object)",
    "int EntityIdSerialiser.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new EntityIdSerialiser(), null);
  }

  /**
   * Test {@link EntityIdSerialiser#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntityIdSerialiser#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EntityIdSerialiser.equals(Object)",
    "int EntityIdSerialiser.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new EntityIdSerialiser(), "Different type to EntityIdSerialiser");
  }
}
