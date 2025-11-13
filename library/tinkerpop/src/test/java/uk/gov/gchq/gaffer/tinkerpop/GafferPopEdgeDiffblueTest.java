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

package uk.gov.gchq.gaffer.tinkerpop;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import org.apache.tinkerpop.gremlin.structure.Direction;
import org.apache.tinkerpop.gremlin.structure.Property;
import org.apache.tinkerpop.gremlin.structure.Vertex;
import org.apache.tinkerpop.gremlin.structure.util.empty.EmptyProperty;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import uk.gov.gchq.gaffer.operation.OperationChain;

class GafferPopEdgeDiffblueTest {
  /**
   * Test {@link GafferPopEdge#GafferPopEdge(String, Object, Object, GafferPopGraph)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then {@link GafferPopElement#id} return {@link List}.
   * </ul>
   *
   * <p>Method under test: {@link GafferPopEdge#GafferPopEdge(String, Object, Object,
   * GafferPopGraph)}
   */
  @Test
  @DisplayName(
      "Test new GafferPopEdge(String, Object, Object, GafferPopGraph); when 'null'; then id return List")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void GafferPopEdge.<init>(String, Object, Object, GafferPopGraph)"})
  void testNewGafferPopEdge_whenNull_thenIdReturnList() {
    // Arrange and Act
    GafferPopEdge actualGafferPopEdge = new GafferPopEdge("Label", "Out Vertex", "In Vertex", null);

    // Assert
    Object object = actualGafferPopEdge.id;
    assertTrue(object instanceof List);
    assertTrue(actualGafferPopEdge.inVertex() instanceof GafferPopVertex);
    assertTrue(actualGafferPopEdge.outVertex() instanceof GafferPopVertex);
    assertEquals("Label", actualGafferPopEdge.label());
    assertEquals("Label", actualGafferPopEdge.label);
    assertNull(actualGafferPopEdge.graph());
    assertEquals(3, ((List<String>) object).size());
    assertFalse(actualGafferPopEdge.isReadOnly());
    Object expectedIdResult = actualGafferPopEdge.id;
    assertSame(expectedIdResult, actualGafferPopEdge.id());
  }

  /**
   * Test {@link GafferPopEdge#property(String, Object)} with {@code key}, {@code value}.
   *
   * <p>Method under test: {@link GafferPopEdge#property(String, Object)}
   */
  @Test
  @DisplayName("Test property(String, Object) with 'key', 'value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Property GafferPopEdge.property(String, Object)"})
  void testPropertyWithKeyValue() throws NoSuchElementException {
    // Arrange
    GafferPopGraph graph = mock(GafferPopGraph.class);
    doNothing().when(graph).addEdge(Mockito.<GafferPopEdge>any());

    GafferPopEdge gafferPopEdge = new GafferPopEdge("Label", "Out Vertex", "In Vertex", graph);
    gafferPopEdge.propertyWithoutUpdate("Updating Edge properties via aggregation", "Value");

    // Act
    Property<Object> actualPropertyResult = gafferPopEdge.property("Key", "Value");

    // Assert
    verify(graph).addEdge(isA(GafferPopEdge.class));
    assertTrue(actualPropertyResult instanceof GafferPopProperty);
    assertEquals("Key", actualPropertyResult.key());
    assertEquals("Value", actualPropertyResult.value());
    assertTrue(actualPropertyResult.isPresent());
    assertSame(gafferPopEdge, actualPropertyResult.element());
  }

  /**
   * Test {@link GafferPopEdge#property(String, Object)} with {@code key}, {@code value}.
   *
   * <ul>
   *   <li>Then return {@link GafferPopProperty}.
   * </ul>
   *
   * <p>Method under test: {@link GafferPopEdge#property(String, Object)}
   */
  @Test
  @DisplayName("Test property(String, Object) with 'key', 'value'; then return GafferPopProperty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Property GafferPopEdge.property(String, Object)"})
  void testPropertyWithKeyValue_thenReturnGafferPopProperty() throws NoSuchElementException {
    // Arrange
    GafferPopGraph graph = mock(GafferPopGraph.class);
    doNothing().when(graph).addEdge(Mockito.<GafferPopEdge>any());
    GafferPopEdge gafferPopEdge = new GafferPopEdge("Label", "Out Vertex", "In Vertex", graph);

    // Act
    Property<Object> actualPropertyResult = gafferPopEdge.property("Key", "Value");

    // Assert
    verify(graph).addEdge(isA(GafferPopEdge.class));
    assertTrue(actualPropertyResult instanceof GafferPopProperty);
    assertEquals("Key", actualPropertyResult.key());
    assertEquals("Value", actualPropertyResult.value());
    assertTrue(actualPropertyResult.isPresent());
    assertSame(gafferPopEdge, actualPropertyResult.element());
  }

  /**
   * Test {@link GafferPopEdge#property(String)} with {@code key}.
   *
   * <ul>
   *   <li>Then return {@link EmptyProperty}.
   * </ul>
   *
   * <p>Method under test: {@link GafferPopEdge#property(String)}
   */
  @Test
  @DisplayName("Test property(String) with 'key'; then return EmptyProperty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Property GafferPopEdge.property(String)"})
  void testPropertyWithKey_thenReturnEmptyProperty() {
    // Arrange
    GafferPopEdge gafferPopEdge = new GafferPopEdge("Label", "Out Vertex", "In Vertex", null);

    // Act
    Property<Object> actualPropertyResult = gafferPopEdge.property("Key");

    // Assert
    assertTrue(actualPropertyResult instanceof EmptyProperty);
    assertFalse(actualPropertyResult.isPresent());
  }

  /**
   * Test {@link GafferPopEdge#property(String)} with {@code key}.
   *
   * <ul>
   *   <li>Then return {@link GafferPopProperty}.
   * </ul>
   *
   * <p>Method under test: {@link GafferPopEdge#property(String)}
   */
  @Test
  @DisplayName("Test property(String) with 'key'; then return GafferPopProperty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Property GafferPopEdge.property(String)"})
  void testPropertyWithKey_thenReturnGafferPopProperty() throws NoSuchElementException {
    // Arrange
    GafferPopEdge gafferPopEdge = new GafferPopEdge("Label", "Out Vertex", "In Vertex", null);
    gafferPopEdge.propertyWithoutUpdate("Key", "Value");

    // Act
    Property<Object> actualPropertyResult = gafferPopEdge.property("Key");

    // Assert
    assertTrue(actualPropertyResult instanceof GafferPopProperty);
    assertEquals("Key", actualPropertyResult.key());
    assertEquals("Value", actualPropertyResult.value());
    assertTrue(actualPropertyResult.isPresent());
    assertSame(gafferPopEdge, actualPropertyResult.element());
  }

  /**
   * Test {@link GafferPopEdge#properties(String[])}.
   *
   * <ul>
   *   <li>Given {@link GafferPopEdge#GafferPopEdge(String, Object, Object, GafferPopGraph)} with
   *       {@code Label} and {@code Out Vertex} and {@code In Vertex} and graph is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link GafferPopEdge#properties(String[])}
   */
  @Test
  @DisplayName(
      "Test properties(String[]); given GafferPopEdge(String, Object, Object, GafferPopGraph) with 'Label' and 'Out Vertex' and 'In Vertex' and graph is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Iterator GafferPopEdge.properties(String[])"})
  void testProperties_givenGafferPopEdgeWithLabelAndOutVertexAndInVertexAndGraphIsNull() {
    // Arrange
    GafferPopEdge gafferPopEdge = new GafferPopEdge("Label", "Out Vertex", "In Vertex", null);

    // Act and Assert
    assertFalse(gafferPopEdge.properties("Property Keys").hasNext());
  }

  /**
   * Test {@link GafferPopEdge#properties(String[])}.
   *
   * <ul>
   *   <li>Then next return {@link GafferPopProperty}.
   * </ul>
   *
   * <p>Method under test: {@link GafferPopEdge#properties(String[])}
   */
  @Test
  @DisplayName("Test properties(String[]); then next return GafferPopProperty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Iterator GafferPopEdge.properties(String[])"})
  void testProperties_thenNextReturnGafferPopProperty() throws NoSuchElementException {
    // Arrange
    GafferPopEdge gafferPopEdge = new GafferPopEdge("Label", "Out Vertex", "In Vertex", null);
    gafferPopEdge.propertyWithoutUpdate("Key", "Value");

    // Act
    Iterator<Property<Object>> actualPropertiesResult = gafferPopEdge.properties();

    // Assert
    Property<Object> nextResult = actualPropertiesResult.next();
    assertTrue(nextResult instanceof GafferPopProperty);
    assertEquals("Key", nextResult.key());
    assertEquals("Value", nextResult.value());
    assertFalse(actualPropertiesResult.hasNext());
    assertTrue(nextResult.isPresent());
    assertSame(gafferPopEdge, nextResult.element());
  }

  /**
   * Test {@link GafferPopEdge#properties(String[])}.
   *
   * <ul>
   *   <li>When {@code Property Keys} and {@code null}.
   *   <li>Then return not hasNext.
   * </ul>
   *
   * <p>Method under test: {@link GafferPopEdge#properties(String[])}
   */
  @Test
  @DisplayName(
      "Test properties(String[]); when 'Property Keys' and 'null'; then return not hasNext")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Iterator GafferPopEdge.properties(String[])"})
  void testProperties_whenPropertyKeysAndNull_thenReturnNotHasNext() {
    // Arrange
    GafferPopEdge gafferPopEdge = new GafferPopEdge("Label", "Out Vertex", "In Vertex", null);
    gafferPopEdge.propertyWithoutUpdate("Key", "Value");

    // Act and Assert
    assertFalse(gafferPopEdge.properties("Property Keys", null).hasNext());
  }

  /**
   * Test {@link GafferPopEdge#properties(String[])}.
   *
   * <ul>
   *   <li>When {@code Property Keys}.
   *   <li>Then return not hasNext.
   * </ul>
   *
   * <p>Method under test: {@link GafferPopEdge#properties(String[])}
   */
  @Test
  @DisplayName("Test properties(String[]); when 'Property Keys'; then return not hasNext")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Iterator GafferPopEdge.properties(String[])"})
  void testProperties_whenPropertyKeys_thenReturnNotHasNext() {
    // Arrange
    GafferPopEdge gafferPopEdge = new GafferPopEdge("Label", "Out Vertex", "In Vertex", null);
    gafferPopEdge.propertyWithoutUpdate("Key", "Value");

    // Act and Assert
    assertFalse(gafferPopEdge.properties("Property Keys").hasNext());
  }

  /**
   * Test {@link GafferPopEdge#propertyWithoutUpdate(String, Object)}.
   *
   * <ul>
   *   <li>When {@code Key}.
   *   <li>Then return {@link GafferPopProperty}.
   * </ul>
   *
   * <p>Method under test: {@link GafferPopEdge#propertyWithoutUpdate(String, Object)}
   */
  @Test
  @DisplayName(
      "Test propertyWithoutUpdate(String, Object); when 'Key'; then return GafferPopProperty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Property GafferPopEdge.propertyWithoutUpdate(String, Object)"})
  void testPropertyWithoutUpdate_whenKey_thenReturnGafferPopProperty()
      throws NoSuchElementException {
    // Arrange
    GafferPopEdge gafferPopEdge = new GafferPopEdge("Label", "Out Vertex", "In Vertex", null);

    // Act
    Property<Object> actualPropertyWithoutUpdateResult =
        gafferPopEdge.propertyWithoutUpdate("Key", "Value");

    // Assert
    assertTrue(actualPropertyWithoutUpdateResult instanceof GafferPopProperty);
    assertEquals("Key", actualPropertyWithoutUpdateResult.key());
    assertEquals("Value", actualPropertyWithoutUpdateResult.value());
    assertTrue(actualPropertyWithoutUpdateResult.isPresent());
    assertSame(gafferPopEdge, actualPropertyWithoutUpdateResult.element());
  }

  /**
   * Test {@link GafferPopEdge#vertices(Direction)}.
   *
   * <ul>
   *   <li>Given {@link GafferPopGraph} {@link GafferPopGraph#execute(OperationChain)} return {@code
   *       null}.
   *   <li>Then return next id is {@code Out Vertex}.
   * </ul>
   *
   * <p>Method under test: {@link GafferPopEdge#vertices(Direction)}
   */
  @Test
  @DisplayName(
      "Test vertices(Direction); given GafferPopGraph execute(OperationChain) return 'null'; then return next id is 'Out Vertex'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Iterator GafferPopEdge.vertices(Direction)"})
  void testVertices_givenGafferPopGraphExecuteReturnNull_thenReturnNextIdIsOutVertex() {
    // Arrange
    GafferPopGraph graph = mock(GafferPopGraph.class);
    when(graph.execute(Mockito.<OperationChain<Object>>any())).thenReturn(null);
    GafferPopEdge gafferPopEdge = new GafferPopEdge("Label", "Out Vertex", "In Vertex", graph);

    // Act
    Iterator<Vertex> actualVerticesResult = gafferPopEdge.vertices(Direction.OUT);

    // Assert
    verify(graph).execute(isA(OperationChain.class));
    Vertex nextResult = actualVerticesResult.next();
    assertTrue(nextResult instanceof GafferPopVertex);
    assertEquals("Out Vertex", nextResult.id());
    assertEquals("Out Vertex", ((GafferPopVertex) nextResult).id);
    assertFalse(actualVerticesResult.hasNext());
    assertFalse(((GafferPopVertex) nextResult).isReadOnly());
    assertEquals(GafferPopGraph.ID_LABEL, nextResult.label());
    assertEquals(GafferPopGraph.ID_LABEL, ((GafferPopVertex) nextResult).label);
  }

  /**
   * Test {@link GafferPopEdge#vertices(Direction)}.
   *
   * <ul>
   *   <li>Then return next id is {@code In Vertex}.
   * </ul>
   *
   * <p>Method under test: {@link GafferPopEdge#vertices(Direction)}
   */
  @Test
  @DisplayName("Test vertices(Direction); then return next id is 'In Vertex'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Iterator GafferPopEdge.vertices(Direction)"})
  void testVertices_thenReturnNextIdIsInVertex() {
    // Arrange
    GafferPopGraph graph = mock(GafferPopGraph.class);
    when(graph.execute(Mockito.<OperationChain<Object>>any())).thenReturn(new ArrayList<>());
    GafferPopEdge gafferPopEdge = new GafferPopEdge("Label", "Out Vertex", "In Vertex", graph);

    // Act
    Iterator<Vertex> actualVerticesResult = gafferPopEdge.vertices(Direction.IN);

    // Assert
    verify(graph).execute(isA(OperationChain.class));
    Vertex nextResult = actualVerticesResult.next();
    assertTrue(nextResult instanceof GafferPopVertex);
    assertEquals("In Vertex", nextResult.id());
    assertEquals("In Vertex", ((GafferPopVertex) nextResult).id);
    assertFalse(actualVerticesResult.hasNext());
    assertFalse(((GafferPopVertex) nextResult).isReadOnly());
    assertEquals(GafferPopGraph.ID_LABEL, nextResult.label());
    assertEquals(GafferPopGraph.ID_LABEL, ((GafferPopVertex) nextResult).label);
  }

  /**
   * Test {@link GafferPopEdge#vertices(Direction)}.
   *
   * <ul>
   *   <li>Then return next id is {@code Out Vertex}.
   * </ul>
   *
   * <p>Method under test: {@link GafferPopEdge#vertices(Direction)}
   */
  @Test
  @DisplayName("Test vertices(Direction); then return next id is 'Out Vertex'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Iterator GafferPopEdge.vertices(Direction)"})
  void testVertices_thenReturnNextIdIsOutVertex() {
    // Arrange
    GafferPopGraph graph = mock(GafferPopGraph.class);
    when(graph.execute(Mockito.<OperationChain<Object>>any())).thenReturn(new ArrayList<>());
    GafferPopEdge gafferPopEdge = new GafferPopEdge("Label", "Out Vertex", "In Vertex", graph);

    // Act
    Iterator<Vertex> actualVerticesResult = gafferPopEdge.vertices(Direction.OUT);

    // Assert
    verify(graph).execute(isA(OperationChain.class));
    Vertex nextResult = actualVerticesResult.next();
    assertTrue(nextResult instanceof GafferPopVertex);
    assertEquals("Out Vertex", nextResult.id());
    assertEquals("Out Vertex", ((GafferPopVertex) nextResult).id);
    assertFalse(actualVerticesResult.hasNext());
    assertFalse(((GafferPopVertex) nextResult).isReadOnly());
    assertEquals(GafferPopGraph.ID_LABEL, nextResult.label());
    assertEquals(GafferPopGraph.ID_LABEL, ((GafferPopVertex) nextResult).label);
  }

  /**
   * Test {@link GafferPopEdge#vertices(Direction)}.
   *
   * <ul>
   *   <li>Then throw {@link UnsupportedOperationException}.
   * </ul>
   *
   * <p>Method under test: {@link GafferPopEdge#vertices(Direction)}
   */
  @Test
  @DisplayName("Test vertices(Direction); then throw UnsupportedOperationException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Iterator GafferPopEdge.vertices(Direction)"})
  void testVertices_thenThrowUnsupportedOperationException() {
    // Arrange
    GafferPopGraph graph = mock(GafferPopGraph.class);
    when(graph.execute(Mockito.<OperationChain<Object>>any()))
        .thenThrow(new UnsupportedOperationException());
    GafferPopEdge gafferPopEdge = new GafferPopEdge("Label", "Out Vertex", "In Vertex", graph);

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> gafferPopEdge.vertices(Direction.IN));
    verify(graph).execute(isA(OperationChain.class));
  }

  /**
   * Test {@link GafferPopEdge#vertices(Direction)}.
   *
   * <ul>
   *   <li>Then throw {@link UnsupportedOperationException}.
   * </ul>
   *
   * <p>Method under test: {@link GafferPopEdge#vertices(Direction)}
   */
  @Test
  @DisplayName("Test vertices(Direction); then throw UnsupportedOperationException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Iterator GafferPopEdge.vertices(Direction)"})
  void testVertices_thenThrowUnsupportedOperationException2() {
    // Arrange
    GafferPopGraph graph = mock(GafferPopGraph.class);
    when(graph.execute(Mockito.<OperationChain<Object>>any()))
        .thenThrow(new UnsupportedOperationException());
    GafferPopEdge gafferPopEdge = new GafferPopEdge("Label", "Out Vertex", "In Vertex", graph);

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> gafferPopEdge.vertices(Direction.BOTH));
    verify(graph).execute(isA(OperationChain.class));
  }

  /**
   * Test {@link GafferPopEdge#keys()}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link GafferPopEdge#keys()}
   */
  @Test
  @DisplayName("Test keys(); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set GafferPopEdge.keys()"})
  void testKeys_thenReturnEmpty() {
    // Arrange
    GafferPopEdge gafferPopEdge = new GafferPopEdge("Label", "Out Vertex", "In Vertex", null);

    // Act and Assert
    assertTrue(gafferPopEdge.keys().isEmpty());
  }

  /**
   * Test {@link GafferPopEdge#keys()}.
   *
   * <ul>
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link GafferPopEdge#keys()}
   */
  @Test
  @DisplayName("Test keys(); then return size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set GafferPopEdge.keys()"})
  void testKeys_thenReturnSizeIsOne() {
    // Arrange
    GafferPopEdge gafferPopEdge = new GafferPopEdge("Label", "Out Vertex", "In Vertex", null);
    gafferPopEdge.propertyWithoutUpdate("Key", "Value");

    // Act
    Set<String> actualKeysResult = gafferPopEdge.keys();

    // Assert
    assertEquals(1, actualKeysResult.size());
    assertTrue(actualKeysResult.contains("Key"));
  }
}
