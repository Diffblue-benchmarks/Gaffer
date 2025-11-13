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
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.UnsupportedEncodingException;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import uk.gov.gchq.gaffer.data.element.Edge;
import uk.gov.gchq.gaffer.data.element.Element;
import uk.gov.gchq.gaffer.data.element.ElementValueLoader;
import uk.gov.gchq.gaffer.data.element.Entity;
import uk.gov.gchq.gaffer.data.element.Entity.Builder;
import uk.gov.gchq.gaffer.data.element.LazyEdge;
import uk.gov.gchq.gaffer.data.element.LazyEntity;
import uk.gov.gchq.gaffer.data.element.id.DirectedType;
import uk.gov.gchq.gaffer.data.element.id.EdgeId;
import uk.gov.gchq.gaffer.data.element.id.EdgeId.MatchedVertex;
import uk.gov.gchq.gaffer.data.element.id.ElementId;
import uk.gov.gchq.gaffer.data.element.id.EntityId;
import uk.gov.gchq.gaffer.exception.SerialisationException;
import uk.gov.gchq.gaffer.operation.data.EdgeSeed;
import uk.gov.gchq.gaffer.operation.data.EntitySeed;
import uk.gov.gchq.gaffer.serialisation.AvroSerialiser;
import uk.gov.gchq.gaffer.serialisation.FreqMapSerialiser;
import uk.gov.gchq.gaffer.serialisation.ToBytesSerialiser;
import uk.gov.gchq.gaffer.serialisation.TypeSubTypeValueSerialiser;
import uk.gov.gchq.gaffer.store.schema.Schema;

class ElementIdSerialiserDiffblueTest {
  /**
   * Test {@link ElementIdSerialiser#ElementIdSerialiser()}.
   * <p>
   * Method under test: {@link ElementIdSerialiser#ElementIdSerialiser()}
   */
  @Test
  @DisplayName("Test new ElementIdSerialiser()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void ElementIdSerialiser.<init>()"})
  void testNewElementIdSerialiser() {
    // Arrange, Act and Assert
    assertFalse((new ElementIdSerialiser()).isConsistent());
  }

  /**
   * Test {@link ElementIdSerialiser#ElementIdSerialiser(ToBytesSerialiser)}.
   * <p>
   * Method under test: {@link ElementIdSerialiser#ElementIdSerialiser(ToBytesSerialiser)}
   */
  @Test
  @DisplayName("Test new ElementIdSerialiser(ToBytesSerialiser)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void ElementIdSerialiser.<init>(ToBytesSerialiser)"})
  void testNewElementIdSerialiser2() {
    // Arrange, Act and Assert
    assertFalse((new ElementIdSerialiser(new EdgeIdSerialiser())).isConsistent());
  }

  /**
   * Test {@link ElementIdSerialiser#ElementIdSerialiser(Schema)}.
   * <ul>
   *   <li>When {@link Schema#Schema()}.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ElementIdSerialiser#ElementIdSerialiser(Schema)}
   */
  @Test
  @DisplayName("Test new ElementIdSerialiser(Schema); when Schema(); then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void ElementIdSerialiser.<init>(Schema)"})
  void testNewElementIdSerialiser_whenSchema_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> new ElementIdSerialiser(new Schema()));
  }

  /**
   * Test {@link ElementIdSerialiser#canHandle(Class)}.
   * <ul>
   *   <li>When {@code Object}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ElementIdSerialiser#canHandle(Class)}
   */
  @Test
  @DisplayName("Test canHandle(Class); when 'java.lang.Object'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ElementIdSerialiser.canHandle(Class)"})
  void testCanHandle_whenJavaLangObject_thenReturnFalse() {
    // Arrange
    ElementIdSerialiser elementIdSerialiser = new ElementIdSerialiser();
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertFalse(elementIdSerialiser.canHandle(clazz));
  }

  /**
   * Test {@link ElementIdSerialiser#canHandle(Class)}.
   * <ul>
   *   <li>When {@code ElementId}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ElementIdSerialiser#canHandle(Class)}
   */
  @Test
  @DisplayName("Test canHandle(Class); when 'uk.gov.gchq.gaffer.data.element.id.ElementId'; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ElementIdSerialiser.canHandle(Class)"})
  void testCanHandle_whenUkGovGchqGafferDataElementIdElementId_thenReturnTrue() {
    // Arrange
    ElementIdSerialiser elementIdSerialiser = new ElementIdSerialiser();
    Class<ElementId> clazz = ElementId.class;

    // Act and Assert
    assertTrue(elementIdSerialiser.canHandle(clazz));
  }

  /**
   * Test {@link ElementIdSerialiser#serialise(EdgeId)} with {@code edgeId}.
   * <ul>
   *   <li>Then return array of {@code byte} with four and zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link ElementIdSerialiser#serialise(EdgeId)}
   */
  @Test
  @DisplayName("Test serialise(EdgeId) with 'edgeId'; then return array of byte with four and zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"byte[] ElementIdSerialiser.serialise(EdgeId)"})
  void testSerialiseWithEdgeId_thenReturnArrayOfByteWithFourAndZero() throws SerialisationException {
    // Arrange
    ElementIdSerialiser elementIdSerialiser = new ElementIdSerialiser(new EdgeIdSerialiser());
    ElementValueLoader valueLoader = mock(ElementValueLoader.class);
    doNothing().when(valueLoader).loadIdentifiers(Mockito.<Element>any());
    Edge edge = (new Edge.Builder()).dest("Dest")
        .directed(true)
        .group("Group")
        .matchedVertex(MatchedVertex.SOURCE)
        .source("Source")
        .build();
    LazyEdge lazyEdge = new LazyEdge(edge, valueLoader);

    Edge buildResult = (new Edge.Builder()).dest("Dest")
        .directed(true)
        .group("Group")
        .matchedVertex(MatchedVertex.SOURCE)
        .source("Source")
        .build();

    // Act
    byte[] actualSerialiseResult = elementIdSerialiser.serialise((EdgeId) new EdgeSeed(lazyEdge, buildResult));

    // Assert
    verify(valueLoader).loadIdentifiers(isA(Element.class));
    assertArrayEquals(new byte[]{4, 0, 0, 1, 1, 4, 0, 0, 1, 1, 1, 1}, actualSerialiseResult);
  }

  /**
   * Test {@link ElementIdSerialiser#serialise(EdgeId)} with {@code edgeId}.
   * <ul>
   *   <li>Then return array of {@code byte} with one and zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link ElementIdSerialiser#serialise(EdgeId)}
   */
  @Test
  @DisplayName("Test serialise(EdgeId) with 'edgeId'; then return array of byte with one and zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"byte[] ElementIdSerialiser.serialise(EdgeId)"})
  void testSerialiseWithEdgeId_thenReturnArrayOfByteWithOneAndZero() throws SerialisationException {
    // Arrange
    ElementIdSerialiser elementIdSerialiser = new ElementIdSerialiser(new EntityIdSerialiser());
    new IllegalArgumentException("foo");
    ElementValueLoader valueLoader = mock(ElementValueLoader.class);
    doNothing().when(valueLoader).loadIdentifiers(Mockito.<Element>any());
    Entity entity = (new Builder()).group("Group").vertex("Vertex").build();
    LazyEntity lazyEntity = new LazyEntity(entity, valueLoader);

    Entity buildResult = (new Builder()).group("Group").vertex("Vertex").build();

    // Act
    byte[] actualSerialiseResult = elementIdSerialiser.serialise((EdgeId) new EdgeSeed(lazyEntity, buildResult));

    // Assert
    verify(valueLoader).loadIdentifiers(isA(Element.class));
    assertArrayEquals(new byte[]{1, 0, 1, 0, 1, 1}, actualSerialiseResult);
  }

  /**
   * Test {@link ElementIdSerialiser#serialise(EdgeId)} with {@code edgeId}.
   * <ul>
   *   <li>When {@link EdgeSeed#EdgeSeed()}.</li>
   *   <li>Then return array of {@code byte} with zero and zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link ElementIdSerialiser#serialise(EdgeId)}
   */
  @Test
  @DisplayName("Test serialise(EdgeId) with 'edgeId'; when EdgeSeed(); then return array of byte with zero and zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"byte[] ElementIdSerialiser.serialise(EdgeId)"})
  void testSerialiseWithEdgeId_whenEdgeSeed_thenReturnArrayOfByteWithZeroAndZero() throws SerialisationException {
    // Arrange
    ElementIdSerialiser elementIdSerialiser = new ElementIdSerialiser(new EdgeIdSerialiser());

    // Act and Assert
    assertArrayEquals(new byte[]{0, 0, 1, 1}, elementIdSerialiser.serialise((EdgeId) new EdgeSeed()));
  }

  /**
   * Test {@link ElementIdSerialiser#serialise(EdgeId)} with {@code edgeId}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return empty array of {@code byte}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ElementIdSerialiser#serialise(EdgeId)}
   */
  @Test
  @DisplayName("Test serialise(EdgeId) with 'edgeId'; when 'null'; then return empty array of byte")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"byte[] ElementIdSerialiser.serialise(EdgeId)"})
  void testSerialiseWithEdgeId_whenNull_thenReturnEmptyArrayOfByte() throws SerialisationException {
    // Arrange
    ElementIdSerialiser elementIdSerialiser = new ElementIdSerialiser(new EdgeIdSerialiser());
    new IllegalArgumentException("foo");

    // Act and Assert
    assertArrayEquals(new byte[]{}, elementIdSerialiser.serialise((EdgeId) null));
  }

  /**
   * Test {@link ElementIdSerialiser#serialise(ElementId)} with {@code elementId}.
   * <ul>
   *   <li>Then return array of {@code byte} with four and zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link ElementIdSerialiser#serialise(ElementId)}
   */
  @Test
  @DisplayName("Test serialise(ElementId) with 'elementId'; then return array of byte with four and zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"byte[] ElementIdSerialiser.serialise(ElementId)"})
  void testSerialiseWithElementId_thenReturnArrayOfByteWithFourAndZero() throws SerialisationException {
    // Arrange
    ElementIdSerialiser elementIdSerialiser = new ElementIdSerialiser(new EdgeIdSerialiser());
    ElementValueLoader valueLoader = mock(ElementValueLoader.class);
    doNothing().when(valueLoader).loadIdentifiers(Mockito.<Element>any());
    Builder groupResult = (new Builder()).group("Group");
    Edge buildResult = (new Edge.Builder()).dest("Dest")
        .directed(true)
        .group("Group")
        .matchedVertex(MatchedVertex.SOURCE)
        .source("Source")
        .build();
    Entity entity = groupResult.vertex(buildResult).build();

    // Act
    byte[] actualSerialiseResult = elementIdSerialiser.serialise((ElementId) new LazyEntity(entity, valueLoader));

    // Assert
    verify(valueLoader).loadIdentifiers(isA(Element.class));
    assertArrayEquals(new byte[]{4, 0, 0, 1, 1}, actualSerialiseResult);
  }

  /**
   * Test {@link ElementIdSerialiser#serialise(ElementId)} with {@code elementId}.
   * <ul>
   *   <li>When {@link EdgeSeed#EdgeSeed()}.</li>
   *   <li>Then return array of {@code byte} with zero and zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link ElementIdSerialiser#serialise(ElementId)}
   */
  @Test
  @DisplayName("Test serialise(ElementId) with 'elementId'; when EdgeSeed(); then return array of byte with zero and zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"byte[] ElementIdSerialiser.serialise(ElementId)"})
  void testSerialiseWithElementId_whenEdgeSeed_thenReturnArrayOfByteWithZeroAndZero() throws SerialisationException {
    // Arrange
    ElementIdSerialiser elementIdSerialiser = new ElementIdSerialiser(new EdgeIdSerialiser());

    // Act and Assert
    assertArrayEquals(new byte[]{0, 0, 1, 1}, elementIdSerialiser.serialise((ElementId) new EdgeSeed()));
  }

  /**
   * Test {@link ElementIdSerialiser#serialise(ElementId)} with {@code elementId}.
   * <ul>
   *   <li>When {@link Edge#Edge(String)} with {@code Group}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ElementIdSerialiser#serialise(ElementId)}
   */
  @Test
  @DisplayName("Test serialise(ElementId) with 'elementId'; when Edge(String) with 'Group'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"byte[] ElementIdSerialiser.serialise(ElementId)"})
  void testSerialiseWithElementId_whenEdgeWithGroup() throws SerialisationException {
    // Arrange
    ElementIdSerialiser elementIdSerialiser = new ElementIdSerialiser(new EdgeIdSerialiser());

    // Act and Assert
    assertArrayEquals(new byte[]{0, 0, 1, 0}, elementIdSerialiser.serialise((ElementId) new Edge("Group")));
  }

  /**
   * Test {@link ElementIdSerialiser#serialise(ElementId)} with {@code elementId}.
   * <ul>
   *   <li>When {@link Entity#Entity(String)} with {@code Group}.</li>
   *   <li>Then return array of {@code byte} with zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link ElementIdSerialiser#serialise(ElementId)}
   */
  @Test
  @DisplayName("Test serialise(ElementId) with 'elementId'; when Entity(String) with 'Group'; then return array of byte with zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"byte[] ElementIdSerialiser.serialise(ElementId)"})
  void testSerialiseWithElementId_whenEntityWithGroup_thenReturnArrayOfByteWithZero() throws SerialisationException {
    // Arrange
    ElementIdSerialiser elementIdSerialiser = new ElementIdSerialiser(new EdgeIdSerialiser());

    // Act and Assert
    assertArrayEquals(new byte[]{0}, elementIdSerialiser.serialise((ElementId) new Entity("Group")));
  }

  /**
   * Test {@link ElementIdSerialiser#serialise(ElementId)} with {@code elementId}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return empty array of {@code byte}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ElementIdSerialiser#serialise(ElementId)}
   */
  @Test
  @DisplayName("Test serialise(ElementId) with 'elementId'; when 'null'; then return empty array of byte")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"byte[] ElementIdSerialiser.serialise(ElementId)"})
  void testSerialiseWithElementId_whenNull_thenReturnEmptyArrayOfByte() throws SerialisationException {
    // Arrange, Act and Assert
    assertArrayEquals(new byte[]{}, (new ElementIdSerialiser()).serialise((ElementId) null));
  }

  /**
   * Test {@link ElementIdSerialiser#serialise(EntityId)} with {@code entityId}.
   * <p>
   * Method under test: {@link ElementIdSerialiser#serialise(EntityId)}
   */
  @Test
  @DisplayName("Test serialise(EntityId) with 'entityId'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"byte[] ElementIdSerialiser.serialise(EntityId)"})
  void testSerialiseWithEntityId() throws SerialisationException {
    // Arrange
    ElementIdSerialiser elementIdSerialiser = new ElementIdSerialiser(new EdgeIdSerialiser());
    ElementValueLoader valueLoader = mock(ElementValueLoader.class);
    doNothing().when(valueLoader).loadIdentifiers(Mockito.<Element>any());
    Builder groupResult = (new Builder()).group("Group");
    Edge buildResult = (new Edge.Builder()).dest("Dest")
        .directed(true)
        .group("Group")
        .matchedVertex(MatchedVertex.SOURCE)
        .source("Source")
        .build();
    Entity entity = groupResult.vertex(buildResult).build();

    // Act
    byte[] actualSerialiseResult = elementIdSerialiser.serialise((EntityId) new LazyEntity(entity, valueLoader));

    // Assert
    verify(valueLoader).loadIdentifiers(isA(Element.class));
    assertArrayEquals(new byte[]{4, 0, 0, 1, 1}, actualSerialiseResult);
  }

  /**
   * Test {@link ElementIdSerialiser#serialise(EntityId)} with {@code entityId}.
   * <p>
   * Method under test: {@link ElementIdSerialiser#serialise(EntityId)}
   */
  @Test
  @DisplayName("Test serialise(EntityId) with 'entityId'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"byte[] ElementIdSerialiser.serialise(EntityId)"})
  void testSerialiseWithEntityId2() throws SerialisationException {
    // Arrange
    ElementIdSerialiser elementIdSerialiser = new ElementIdSerialiser(new EdgeIdSerialiser());
    ElementValueLoader valueLoader = mock(ElementValueLoader.class);
    doNothing().when(valueLoader).loadIdentifiers(Mockito.<Element>any());
    Builder groupResult = (new Builder()).group("Group");
    Entity entity = groupResult.vertex(new EdgeSeed()).build();

    // Act
    byte[] actualSerialiseResult = elementIdSerialiser.serialise((EntityId) new LazyEntity(entity, valueLoader));

    // Assert
    verify(valueLoader).loadIdentifiers(isA(Element.class));
    assertArrayEquals(new byte[]{4, 0, 0, 1, 1}, actualSerialiseResult);
  }

  /**
   * Test {@link ElementIdSerialiser#serialise(EntityId)} with {@code entityId}.
   * <ul>
   *   <li>Given {@link ElementIdSerialiser#ElementIdSerialiser(ToBytesSerialiser)} with vertexSerialiser is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ElementIdSerialiser#serialise(EntityId)}
   */
  @Test
  @DisplayName("Test serialise(EntityId) with 'entityId'; given ElementIdSerialiser(ToBytesSerialiser) with vertexSerialiser is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"byte[] ElementIdSerialiser.serialise(EntityId)"})
  void testSerialiseWithEntityId_givenElementIdSerialiserWithVertexSerialiserIsNull() throws SerialisationException {
    // Arrange
    ElementIdSerialiser elementIdSerialiser = new ElementIdSerialiser((ToBytesSerialiser) null);

    // Act and Assert
    assertArrayEquals(new byte[]{0}, elementIdSerialiser.serialise((EntityId) new EntitySeed()));
  }

  /**
   * Test {@link ElementIdSerialiser#serialise(EntityId)} with {@code entityId}.
   * <ul>
   *   <li>Then return array of {@code byte} with one and zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link ElementIdSerialiser#serialise(EntityId)}
   */
  @Test
  @DisplayName("Test serialise(EntityId) with 'entityId'; then return array of byte with one and zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"byte[] ElementIdSerialiser.serialise(EntityId)"})
  void testSerialiseWithEntityId_thenReturnArrayOfByteWithOneAndZero() throws SerialisationException {
    // Arrange
    ElementIdSerialiser elementIdSerialiser = new ElementIdSerialiser(new EntityIdSerialiser());
    new IllegalArgumentException("foo");
    ElementValueLoader valueLoader = mock(ElementValueLoader.class);
    doNothing().when(valueLoader).loadIdentifiers(Mockito.<Element>any());
    Builder groupResult = (new Builder()).group("Group");
    Entity buildResult = (new Builder()).group("Group").vertex("Vertex").build();
    Entity entity = groupResult.vertex(buildResult).build();

    // Act
    byte[] actualSerialiseResult = elementIdSerialiser.serialise((EntityId) new LazyEntity(entity, valueLoader));

    // Assert
    verify(valueLoader).loadIdentifiers(isA(Element.class));
    assertArrayEquals(new byte[]{1, 0}, actualSerialiseResult);
  }

  /**
   * Test {@link ElementIdSerialiser#serialise(EntityId)} with {@code entityId}.
   * <ul>
   *   <li>When {@link EntitySeed#EntitySeed()}.</li>
   *   <li>Then return array of {@code byte} with zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link ElementIdSerialiser#serialise(EntityId)}
   */
  @Test
  @DisplayName("Test serialise(EntityId) with 'entityId'; when EntitySeed(); then return array of byte with zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"byte[] ElementIdSerialiser.serialise(EntityId)"})
  void testSerialiseWithEntityId_whenEntitySeed_thenReturnArrayOfByteWithZero() throws SerialisationException {
    // Arrange
    ElementIdSerialiser elementIdSerialiser = new ElementIdSerialiser(new EdgeIdSerialiser());

    // Act and Assert
    assertArrayEquals(new byte[]{0}, elementIdSerialiser.serialise((EntityId) new EntitySeed()));
  }

  /**
   * Test {@link ElementIdSerialiser#serialise(EntityId)} with {@code entityId}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return empty array of {@code byte}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ElementIdSerialiser#serialise(EntityId)}
   */
  @Test
  @DisplayName("Test serialise(EntityId) with 'entityId'; when 'null'; then return empty array of byte")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"byte[] ElementIdSerialiser.serialise(EntityId)"})
  void testSerialiseWithEntityId_whenNull_thenReturnEmptyArrayOfByte() throws SerialisationException {
    // Arrange, Act and Assert
    assertArrayEquals(new byte[]{}, (new ElementIdSerialiser(new EdgeIdSerialiser())).serialise((EntityId) null));
  }

  /**
   * Test {@link ElementIdSerialiser#serialiseVertex(Object)}.
   * <p>
   * Method under test: {@link ElementIdSerialiser#serialiseVertex(Object)}
   */
  @Test
  @DisplayName("Test serialiseVertex(Object)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"byte[] ElementIdSerialiser.serialiseVertex(Object)"})
  void testSerialiseVertex() throws SerialisationException {
    // Arrange
    ElementIdSerialiser elementIdSerialiser = new ElementIdSerialiser(new EdgeIdSerialiser());
    Edge buildResult = (new Edge.Builder()).dest("Dest")
        .directed(true)
        .group("Group")
        .matchedVertex(MatchedVertex.SOURCE)
        .source("Source")
        .build();

    // Act and Assert
    assertArrayEquals(new byte[]{4, 0, 0, 1, 1}, elementIdSerialiser.serialiseVertex(buildResult));
  }

  /**
   * Test {@link ElementIdSerialiser#serialiseVertex(Object)}.
   * <ul>
   *   <li>Then return array of {@code byte} with one and zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link ElementIdSerialiser#serialiseVertex(Object)}
   */
  @Test
  @DisplayName("Test serialiseVertex(Object); then return array of byte with one and zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"byte[] ElementIdSerialiser.serialiseVertex(Object)"})
  void testSerialiseVertex_thenReturnArrayOfByteWithOneAndZero() throws SerialisationException {
    // Arrange
    ElementIdSerialiser elementIdSerialiser = new ElementIdSerialiser(new EntityIdSerialiser());
    new IllegalArgumentException("foo");
    Entity buildResult = (new Builder()).group("Group").vertex("Vertex").build();

    // Act and Assert
    assertArrayEquals(new byte[]{1, 0}, elementIdSerialiser.serialiseVertex(buildResult));
  }

  /**
   * Test {@link ElementIdSerialiser#serialiseVertex(Object)}.
   * <ul>
   *   <li>When {@link EdgeSeed#EdgeSeed()}.</li>
   *   <li>Then return array of {@code byte} with four and zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link ElementIdSerialiser#serialiseVertex(Object)}
   */
  @Test
  @DisplayName("Test serialiseVertex(Object); when EdgeSeed(); then return array of byte with four and zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"byte[] ElementIdSerialiser.serialiseVertex(Object)"})
  void testSerialiseVertex_whenEdgeSeed_thenReturnArrayOfByteWithFourAndZero() throws SerialisationException {
    // Arrange
    ElementIdSerialiser elementIdSerialiser = new ElementIdSerialiser(new EdgeIdSerialiser());

    // Act and Assert
    assertArrayEquals(new byte[]{4, 0, 0, 1, 1}, elementIdSerialiser.serialiseVertex(new EdgeSeed()));
  }

  /**
   * Test {@link ElementIdSerialiser#serialiseVertex(Object)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return array of {@code byte} with zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link ElementIdSerialiser#serialiseVertex(Object)}
   */
  @Test
  @DisplayName("Test serialiseVertex(Object); when 'null'; then return array of byte with zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"byte[] ElementIdSerialiser.serialiseVertex(Object)"})
  void testSerialiseVertex_whenNull_thenReturnArrayOfByteWithZero() throws SerialisationException {
    // Arrange, Act and Assert
    assertArrayEquals(new byte[]{0}, (new ElementIdSerialiser(new EdgeIdSerialiser())).serialiseVertex(null));
  }

  /**
   * Test {@link ElementIdSerialiser#serialiseVertex(Object)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return array of {@code byte} with zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link ElementIdSerialiser#serialiseVertex(Object)}
   */
  @Test
  @DisplayName("Test serialiseVertex(Object); when 'null'; then return array of byte with zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"byte[] ElementIdSerialiser.serialiseVertex(Object)"})
  void testSerialiseVertex_whenNull_thenReturnArrayOfByteWithZero2() throws SerialisationException {
    // Arrange
    ElementIdSerialiser elementIdSerialiser = new ElementIdSerialiser(new EntityIdSerialiser());
    new IllegalArgumentException("foo");

    // Act and Assert
    assertArrayEquals(new byte[]{0}, elementIdSerialiser.serialiseVertex(null));
  }

  /**
   * Test {@link ElementIdSerialiser#deserialise(byte[])} with {@code bytes}.
   * <ul>
   *   <li>Then AdjacentMatchedVertexValue return {@link Map}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ElementIdSerialiser#deserialise(byte[])}
   */
  @Test
  @DisplayName("Test deserialise(byte[]) with 'bytes'; then AdjacentMatchedVertexValue return Map")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ElementId ElementIdSerialiser.deserialise(byte[])"})
  void testDeserialiseWithBytes_thenAdjacentMatchedVertexValueReturnMap() throws SerialisationException {
    // Arrange and Act
    ElementId actualDeserialiseResult = (new ElementIdSerialiser(new FreqMapSerialiser()))
        .deserialise(new byte[]{1, 'X', 1, 'X', 'A', 'X', 'A', 'X'});

    // Assert
    Object adjacentMatchedVertexValue = ((EdgeSeed) actualDeserialiseResult).getAdjacentMatchedVertexValue();
    assertTrue(adjacentMatchedVertexValue instanceof Map);
    assertTrue(actualDeserialiseResult instanceof EdgeSeed);
    assertEquals("uk.gov.gchq.gaffer.operation.data.EdgeSeed", actualDeserialiseResult.getClassName());
    assertEquals(DirectedType.UNDIRECTED, ((EdgeSeed) actualDeserialiseResult).getDirectedType());
    assertEquals(MatchedVertex.SOURCE, ((EdgeSeed) actualDeserialiseResult).getMatchedVertex());
    assertFalse(((EdgeSeed) actualDeserialiseResult).isDirected());
    assertTrue(((Map<Object, Object>) adjacentMatchedVertexValue).isEmpty());
    assertTrue(((EdgeSeed) actualDeserialiseResult).isUndirected());
    Object matchedVertexValue = ((EdgeSeed) actualDeserialiseResult).getMatchedVertexValue();
    assertEquals(adjacentMatchedVertexValue, matchedVertexValue);
    assertSame(matchedVertexValue, ((EdgeSeed) actualDeserialiseResult).getSource());
    assertSame(adjacentMatchedVertexValue, ((EdgeSeed) actualDeserialiseResult).getDestination());
  }

  /**
   * Test {@link ElementIdSerialiser#deserialise(byte[])} with {@code bytes}.
   * <ul>
   *   <li>Then return Vertex Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link ElementIdSerialiser#deserialise(byte[])}
   */
  @Test
  @DisplayName("Test deserialise(byte[]) with 'bytes'; then return Vertex Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ElementId ElementIdSerialiser.deserialise(byte[])"})
  void testDeserialiseWithBytes_thenReturnVertexEmpty() throws UnsupportedEncodingException, SerialisationException {
    // Arrange
    ElementIdSerialiser elementIdSerialiser = new ElementIdSerialiser(new FreqMapSerialiser());

    // Act
    ElementId actualDeserialiseResult = elementIdSerialiser.deserialise("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    Object vertex = ((EntitySeed) actualDeserialiseResult).getVertex();
    assertTrue(vertex instanceof Map);
    assertTrue(actualDeserialiseResult instanceof EntitySeed);
    assertEquals("uk.gov.gchq.gaffer.operation.data.EntitySeed", actualDeserialiseResult.getClassName());
    assertTrue(((Map<Object, Object>) vertex).isEmpty());
  }

  /**
   * Test {@link ElementIdSerialiser#deserialise(byte[])} with {@code bytes}.
   * <ul>
   *   <li>When array of {@code byte} with {@code A} and zero.</li>
   *   <li>Then return Vertex size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link ElementIdSerialiser#deserialise(byte[])}
   */
  @Test
  @DisplayName("Test deserialise(byte[]) with 'bytes'; when array of byte with 'A' and zero; then return Vertex size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ElementId ElementIdSerialiser.deserialise(byte[])"})
  void testDeserialiseWithBytes_whenArrayOfByteWithAAndZero_thenReturnVertexSizeIsOne() throws SerialisationException {
    // Arrange and Act
    ElementId actualDeserialiseResult = (new ElementIdSerialiser(new FreqMapSerialiser()))
        .deserialise(new byte[]{'A', 0, 'A', 'X', 'A', 'X', 'A', 'X'});

    // Assert
    Object vertex = ((EntitySeed) actualDeserialiseResult).getVertex();
    assertTrue(vertex instanceof Map);
    assertTrue(actualDeserialiseResult instanceof EntitySeed);
    assertEquals("uk.gov.gchq.gaffer.operation.data.EntitySeed", actualDeserialiseResult.getClassName());
    assertEquals(1, ((Map<String, Long>) vertex).size());
    assertEquals(65L, ((Map<String, Long>) vertex).get("").longValue());
  }

  /**
   * Test {@link ElementIdSerialiser#deserialise(byte[])} with {@code bytes}.
   * <ul>
   *   <li>When array of {@code byte} with zero.</li>
   *   <li>Then return Vertex is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ElementIdSerialiser#deserialise(byte[])}
   */
  @Test
  @DisplayName("Test deserialise(byte[]) with 'bytes'; when array of byte with zero; then return Vertex is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ElementId ElementIdSerialiser.deserialise(byte[])"})
  void testDeserialiseWithBytes_whenArrayOfByteWithZero_thenReturnVertexIsNull() throws SerialisationException {
    // Arrange and Act
    ElementId actualDeserialiseResult = (new ElementIdSerialiser(new EdgeIdSerialiser())).deserialise(new byte[]{0});

    // Assert
    assertTrue(actualDeserialiseResult instanceof EntitySeed);
    assertEquals("uk.gov.gchq.gaffer.operation.data.EntitySeed", actualDeserialiseResult.getClassName());
    assertNull(((EntitySeed) actualDeserialiseResult).getVertex());
  }

  /**
   * Test {@link ElementIdSerialiser#deserialiseEmpty()}.
   * <p>
   * Method under test: {@link ElementIdSerialiser#deserialiseEmpty()}
   */
  @Test
  @DisplayName("Test deserialiseEmpty()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ElementId ElementIdSerialiser.deserialiseEmpty()"})
  void testDeserialiseEmpty() throws SerialisationException {
    // Arrange, Act and Assert
    assertNull((new ElementIdSerialiser()).deserialiseEmpty());
  }

  /**
   * Test {@link ElementIdSerialiser#preservesObjectOrdering()}.
   * <p>
   * Method under test: {@link ElementIdSerialiser#preservesObjectOrdering()}
   */
  @Test
  @DisplayName("Test preservesObjectOrdering()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ElementIdSerialiser.preservesObjectOrdering()"})
  void testPreservesObjectOrdering() {
    // Arrange, Act and Assert
    assertFalse((new ElementIdSerialiser(new EdgeIdSerialiser())).preservesObjectOrdering());
  }

  /**
   * Test {@link ElementIdSerialiser#preservesObjectOrdering()}.
   * <p>
   * Method under test: {@link ElementIdSerialiser#preservesObjectOrdering()}
   */
  @Test
  @DisplayName("Test preservesObjectOrdering()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ElementIdSerialiser.preservesObjectOrdering()"})
  void testPreservesObjectOrdering2() {
    // Arrange, Act and Assert
    assertFalse((new ElementIdSerialiser(new AvroSerialiser())).preservesObjectOrdering());
  }

  /**
   * Test {@link ElementIdSerialiser#preservesObjectOrdering()}.
   * <p>
   * Method under test: {@link ElementIdSerialiser#preservesObjectOrdering()}
   */
  @Test
  @DisplayName("Test preservesObjectOrdering()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ElementIdSerialiser.preservesObjectOrdering()"})
  void testPreservesObjectOrdering3() {
    // Arrange, Act and Assert
    assertTrue((new ElementIdSerialiser(new TypeSubTypeValueSerialiser())).preservesObjectOrdering());
  }

  /**
   * Test {@link ElementIdSerialiser#preservesObjectOrdering()}.
   * <p>
   * Method under test: {@link ElementIdSerialiser#preservesObjectOrdering()}
   */
  @Test
  @DisplayName("Test preservesObjectOrdering()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ElementIdSerialiser.preservesObjectOrdering()"})
  void testPreservesObjectOrdering4() {
    // Arrange, Act and Assert
    assertFalse((new ElementIdSerialiser(new ElementIdSerialiser())).preservesObjectOrdering());
  }

  /**
   * Test {@link ElementIdSerialiser#preservesObjectOrdering()}.
   * <p>
   * Method under test: {@link ElementIdSerialiser#preservesObjectOrdering()}
   */
  @Test
  @DisplayName("Test preservesObjectOrdering()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ElementIdSerialiser.preservesObjectOrdering()"})
  void testPreservesObjectOrdering5() {
    // Arrange, Act and Assert
    assertFalse((new ElementIdSerialiser(new EntityIdSerialiser())).preservesObjectOrdering());
  }

  /**
   * Test {@link ElementIdSerialiser#preservesObjectOrdering()}.
   * <p>
   * Method under test: {@link ElementIdSerialiser#preservesObjectOrdering()}
   */
  @Test
  @DisplayName("Test preservesObjectOrdering()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ElementIdSerialiser.preservesObjectOrdering()"})
  void testPreservesObjectOrdering6() {
    // Arrange, Act and Assert
    assertTrue(
        (new ElementIdSerialiser(new EdgeIdSerialiser(new TypeSubTypeValueSerialiser()))).preservesObjectOrdering());
  }

  /**
   * Test {@link ElementIdSerialiser#preservesObjectOrdering()}.
   * <ul>
   *   <li>Given {@link ElementIdSerialiser#ElementIdSerialiser()}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ElementIdSerialiser#preservesObjectOrdering()}
   */
  @Test
  @DisplayName("Test preservesObjectOrdering(); given ElementIdSerialiser(); then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ElementIdSerialiser.preservesObjectOrdering()"})
  void testPreservesObjectOrdering_givenElementIdSerialiser_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new ElementIdSerialiser()).preservesObjectOrdering());
  }

  /**
   * Test {@link ElementIdSerialiser#isConsistent()}.
   * <p>
   * Method under test: {@link ElementIdSerialiser#isConsistent()}
   */
  @Test
  @DisplayName("Test isConsistent()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ElementIdSerialiser.isConsistent()"})
  void testIsConsistent() {
    // Arrange, Act and Assert
    assertTrue((new ElementIdSerialiser(new TypeSubTypeValueSerialiser())).isConsistent());
  }

  /**
   * Test {@link ElementIdSerialiser#isConsistent()}.
   * <p>
   * Method under test: {@link ElementIdSerialiser#isConsistent()}
   */
  @Test
  @DisplayName("Test isConsistent()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ElementIdSerialiser.isConsistent()"})
  void testIsConsistent2() {
    // Arrange, Act and Assert
    assertFalse((new ElementIdSerialiser(new ElementIdSerialiser())).isConsistent());
  }

  /**
   * Test {@link ElementIdSerialiser#isConsistent()}.
   * <p>
   * Method under test: {@link ElementIdSerialiser#isConsistent()}
   */
  @Test
  @DisplayName("Test isConsistent()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ElementIdSerialiser.isConsistent()"})
  void testIsConsistent3() {
    // Arrange, Act and Assert
    assertFalse((new ElementIdSerialiser(new EntityIdSerialiser())).isConsistent());
  }

  /**
   * Test {@link ElementIdSerialiser#isConsistent()}.
   * <p>
   * Method under test: {@link ElementIdSerialiser#isConsistent()}
   */
  @Test
  @DisplayName("Test isConsistent()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ElementIdSerialiser.isConsistent()"})
  void testIsConsistent4() {
    // Arrange, Act and Assert
    assertTrue((new ElementIdSerialiser(new EdgeIdSerialiser(new TypeSubTypeValueSerialiser()))).isConsistent());
  }

  /**
   * Test {@link ElementIdSerialiser#isConsistent()}.
   * <ul>
   *   <li>Given {@link ElementIdSerialiser#ElementIdSerialiser(ToBytesSerialiser)} with vertexSerialiser is {@link AvroSerialiser} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link ElementIdSerialiser#isConsistent()}
   */
  @Test
  @DisplayName("Test isConsistent(); given ElementIdSerialiser(ToBytesSerialiser) with vertexSerialiser is AvroSerialiser (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ElementIdSerialiser.isConsistent()"})
  void testIsConsistent_givenElementIdSerialiserWithVertexSerialiserIsAvroSerialiser() {
    // Arrange, Act and Assert
    assertFalse((new ElementIdSerialiser(new AvroSerialiser())).isConsistent());
  }

  /**
   * Test {@link ElementIdSerialiser#isConsistent()}.
   * <ul>
   *   <li>Given {@link ElementIdSerialiser#ElementIdSerialiser(ToBytesSerialiser)} with vertexSerialiser is {@link EdgeIdSerialiser#EdgeIdSerialiser()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ElementIdSerialiser#isConsistent()}
   */
  @Test
  @DisplayName("Test isConsistent(); given ElementIdSerialiser(ToBytesSerialiser) with vertexSerialiser is EdgeIdSerialiser()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ElementIdSerialiser.isConsistent()"})
  void testIsConsistent_givenElementIdSerialiserWithVertexSerialiserIsEdgeIdSerialiser() {
    // Arrange, Act and Assert
    assertFalse((new ElementIdSerialiser(new EdgeIdSerialiser())).isConsistent());
  }

  /**
   * Test {@link ElementIdSerialiser#isConsistent()}.
   * <ul>
   *   <li>Given {@link ElementIdSerialiser#ElementIdSerialiser()}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ElementIdSerialiser#isConsistent()}
   */
  @Test
  @DisplayName("Test isConsistent(); given ElementIdSerialiser(); then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ElementIdSerialiser.isConsistent()"})
  void testIsConsistent_givenElementIdSerialiser_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new ElementIdSerialiser()).isConsistent());
  }

  /**
   * Test {@link ElementIdSerialiser#equals(Object)}, and {@link ElementIdSerialiser#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ElementIdSerialiser#equals(Object)}
   *   <li>{@link ElementIdSerialiser#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ElementIdSerialiser.equals(Object)", "int ElementIdSerialiser.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ElementIdSerialiser elementIdSerialiser = new ElementIdSerialiser();
    ElementIdSerialiser elementIdSerialiser2 = new ElementIdSerialiser();

    // Act and Assert
    assertEquals(elementIdSerialiser, elementIdSerialiser2);
    int expectedHashCodeResult = elementIdSerialiser.hashCode();
    assertEquals(expectedHashCodeResult, elementIdSerialiser2.hashCode());
  }

  /**
   * Test {@link ElementIdSerialiser#equals(Object)}, and {@link ElementIdSerialiser#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ElementIdSerialiser#equals(Object)}
   *   <li>{@link ElementIdSerialiser#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ElementIdSerialiser.equals(Object)", "int ElementIdSerialiser.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    ElementIdSerialiser elementIdSerialiser = new ElementIdSerialiser(new ElementIdSerialiser());
    ElementIdSerialiser elementIdSerialiser2 = new ElementIdSerialiser(new ElementIdSerialiser());

    // Act and Assert
    assertEquals(elementIdSerialiser, elementIdSerialiser2);
    int expectedHashCodeResult = elementIdSerialiser.hashCode();
    assertEquals(expectedHashCodeResult, elementIdSerialiser2.hashCode());
  }

  /**
   * Test {@link ElementIdSerialiser#equals(Object)}, and {@link ElementIdSerialiser#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ElementIdSerialiser#equals(Object)}
   *   <li>{@link ElementIdSerialiser#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ElementIdSerialiser.equals(Object)", "int ElementIdSerialiser.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ElementIdSerialiser elementIdSerialiser = new ElementIdSerialiser();

    // Act and Assert
    assertEquals(elementIdSerialiser, elementIdSerialiser);
    int expectedHashCodeResult = elementIdSerialiser.hashCode();
    assertEquals(expectedHashCodeResult, elementIdSerialiser.hashCode());
  }

  /**
   * Test {@link ElementIdSerialiser#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ElementIdSerialiser#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ElementIdSerialiser.equals(Object)", "int ElementIdSerialiser.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ElementIdSerialiser elementIdSerialiser = new ElementIdSerialiser(new EdgeIdSerialiser());

    // Act and Assert
    assertNotEquals(elementIdSerialiser, new ElementIdSerialiser());
  }

  /**
   * Test {@link ElementIdSerialiser#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ElementIdSerialiser#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ElementIdSerialiser.equals(Object)", "int ElementIdSerialiser.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ElementIdSerialiser elementIdSerialiser = new ElementIdSerialiser(new ElementIdSerialiser());

    // Act and Assert
    assertNotEquals(elementIdSerialiser, new ElementIdSerialiser(new EdgeIdSerialiser()));
  }

  /**
   * Test {@link ElementIdSerialiser#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ElementIdSerialiser#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ElementIdSerialiser.equals(Object)", "int ElementIdSerialiser.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new ElementIdSerialiser(), null);
  }

  /**
   * Test {@link ElementIdSerialiser#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ElementIdSerialiser#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ElementIdSerialiser.equals(Object)", "int ElementIdSerialiser.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new ElementIdSerialiser(), "Different type to ElementIdSerialiser");
  }
}
