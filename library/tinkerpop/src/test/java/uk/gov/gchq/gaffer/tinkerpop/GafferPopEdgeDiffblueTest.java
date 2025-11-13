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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
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
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mockito.Mockito;
import uk.gov.gchq.gaffer.operation.OperationChain;

public class GafferPopEdgeDiffblueTest {
  /**
   * Test {@link GafferPopEdge#GafferPopEdge(String, Object, Object, GafferPopGraph)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then {@link GafferPopElement#id} return {@link List}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GafferPopEdge#GafferPopEdge(String, Object, Object, GafferPopGraph)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void GafferPopEdge.<init>(String, Object, Object, GafferPopGraph)"})
  public void testNewGafferPopEdge_whenNull_thenIdReturnList() {
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
   * Test {@link GafferPopEdge#property(String)} with {@code key}.
   * <p>
   * Method under test: {@link GafferPopEdge#property(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Property GafferPopEdge.property(String)"})
  public void testPropertyWithKey() {
    // Arrange and Act
    Property<Object> actualPropertyResult = (new GafferPopEdge("Label", "Out Vertex", "In Vertex", null))
        .property("Key");

    // Assert
    assertTrue(actualPropertyResult instanceof EmptyProperty);
    assertFalse(actualPropertyResult.isPresent());
  }

  /**
   * Test {@link GafferPopEdge#property(String)} with {@code key}.
   * <p>
   * Method under test: {@link GafferPopEdge#property(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Property GafferPopEdge.property(String)"})
  public void testPropertyWithKey2() {
    // Arrange and Act
    Property<Object> actualPropertyResult = (new GafferPopEdge(GafferPopGraph.ID_LABEL, "Out Vertex", "In Vertex",
        null)).property("Key");

    // Assert
    assertTrue(actualPropertyResult instanceof EmptyProperty);
    assertFalse(actualPropertyResult.isPresent());
  }

  /**
   * Test {@link GafferPopEdge#property(String, Object)} with {@code key}, {@code value}.
   * <p>
   * Method under test: {@link GafferPopEdge#property(String, Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Property GafferPopEdge.property(String, Object)"})
  public void testPropertyWithKeyValue() throws NoSuchElementException {
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
   * <ul>
   *   <li>Then return {@link GafferPopProperty}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GafferPopEdge#property(String, Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Property GafferPopEdge.property(String, Object)"})
  public void testPropertyWithKeyValue_thenReturnGafferPopProperty() throws NoSuchElementException {
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
   * <ul>
   *   <li>Then return {@link GafferPopProperty}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GafferPopEdge#property(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Property GafferPopEdge.property(String)"})
  public void testPropertyWithKey_thenReturnGafferPopProperty() throws NoSuchElementException {
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
   * <ul>
   *   <li>Given {@link GafferPopEdge#GafferPopEdge(String, Object, Object, GafferPopGraph)} with {@code Label} and {@code Out Vertex} and {@code In Vertex} and graph is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GafferPopEdge#properties(String[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Iterator GafferPopEdge.properties(String[])"})
  public void testProperties_givenGafferPopEdgeWithLabelAndOutVertexAndInVertexAndGraphIsNull() {
    // Arrange, Act and Assert
    assertFalse((new GafferPopEdge("Label", "Out Vertex", "In Vertex", null)).properties("Property Keys").hasNext());
  }

  /**
   * Test {@link GafferPopEdge#properties(String[])}.
   * <ul>
   *   <li>Then return next key is {@link GafferPopGraph#ID_LABEL}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GafferPopEdge#properties(String[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Iterator GafferPopEdge.properties(String[])"})
  public void testProperties_thenReturnNextKeyIsId_label() throws NoSuchElementException {
    // Arrange
    GafferPopEdge gafferPopEdge = new GafferPopEdge("Label", "Out Vertex", "In Vertex", null);
    gafferPopEdge.propertyWithoutUpdate(GafferPopGraph.ID_LABEL, "Value");

    // Act
    Iterator<Property<Object>> actualPropertiesResult = gafferPopEdge.properties("Property Keys",
        GafferPopGraph.ID_LABEL);

    // Assert
    Property<Object> nextResult = actualPropertiesResult.next();
    assertTrue(nextResult instanceof GafferPopProperty);
    assertEquals("Value", nextResult.value());
    assertFalse(actualPropertiesResult.hasNext());
    assertTrue(nextResult.isPresent());
    assertEquals(GafferPopGraph.ID_LABEL, nextResult.key());
    assertSame(gafferPopEdge, nextResult.element());
  }

  /**
   * Test {@link GafferPopEdge#properties(String[])}.
   * <ul>
   *   <li>Then return next key is {@code Key}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GafferPopEdge#properties(String[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Iterator GafferPopEdge.properties(String[])"})
  public void testProperties_thenReturnNextKeyIsKey() throws NoSuchElementException {
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
   * <ul>
   *   <li>When {@code Property Keys}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GafferPopEdge#properties(String[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Iterator GafferPopEdge.properties(String[])"})
  public void testProperties_whenPropertyKeys() {
    // Arrange
    GafferPopEdge gafferPopEdge = new GafferPopEdge("Label", "Out Vertex", "In Vertex", null);
    gafferPopEdge.propertyWithoutUpdate("Key", "Value");

    // Act and Assert
    assertFalse(gafferPopEdge.properties("Property Keys").hasNext());
  }

  /**
   * Test {@link GafferPopEdge#properties(String[])}.
   * <ul>
   *   <li>When {@code Property Keys} and {@link GafferPopGraph#ID_LABEL}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GafferPopEdge#properties(String[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Iterator GafferPopEdge.properties(String[])"})
  public void testProperties_whenPropertyKeysAndId_label() {
    // Arrange
    GafferPopEdge gafferPopEdge = new GafferPopEdge("Label", "Out Vertex", "In Vertex", null);
    gafferPopEdge.propertyWithoutUpdate("Key", "Value");

    // Act and Assert
    assertFalse(gafferPopEdge.properties("Property Keys", GafferPopGraph.ID_LABEL).hasNext());
  }

  /**
   * Test {@link GafferPopEdge#propertyWithoutUpdate(String, Object)}.
   * <ul>
   *   <li>When {@code Key}.</li>
   *   <li>Then return {@link GafferPopProperty}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GafferPopEdge#propertyWithoutUpdate(String, Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Property GafferPopEdge.propertyWithoutUpdate(String, Object)"})
  public void testPropertyWithoutUpdate_whenKey_thenReturnGafferPopProperty() throws NoSuchElementException {
    // Arrange
    GafferPopEdge gafferPopEdge = new GafferPopEdge("Label", "Out Vertex", "In Vertex", null);

    // Act
    Property<Object> actualPropertyWithoutUpdateResult = gafferPopEdge.propertyWithoutUpdate("Key", "Value");

    // Assert
    assertTrue(actualPropertyWithoutUpdateResult instanceof GafferPopProperty);
    assertEquals("Key", actualPropertyWithoutUpdateResult.key());
    assertEquals("Value", actualPropertyWithoutUpdateResult.value());
    assertTrue(actualPropertyWithoutUpdateResult.isPresent());
    assertSame(gafferPopEdge, actualPropertyWithoutUpdateResult.element());
  }

  /**
   * Test {@link GafferPopEdge#vertices(Direction)}.
   * <ul>
   *   <li>Given {@link GafferPopGraph} {@link GafferPopGraph#execute(OperationChain)} return {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GafferPopEdge#vertices(Direction)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Iterator GafferPopEdge.vertices(Direction)"})
  public void testVertices_givenGafferPopGraphExecuteReturnArrayList() {
    // Arrange
    GafferPopGraph graph = mock(GafferPopGraph.class);
    when(graph.execute(Mockito.<OperationChain<Object>>any())).thenReturn(new ArrayList<>());

    // Act
    Iterator<Vertex> actualVerticesResult = (new GafferPopEdge("Label", "Out Vertex", "In Vertex", graph))
        .vertices(Direction.OUT);

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
   * <ul>
   *   <li>Given {@link GafferPopGraph} {@link GafferPopGraph#execute(OperationChain)} return {@code null}.</li>
   *   <li>Then next return {@link GafferPopVertex}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GafferPopEdge#vertices(Direction)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Iterator GafferPopEdge.vertices(Direction)"})
  public void testVertices_givenGafferPopGraphExecuteReturnNull_thenNextReturnGafferPopVertex() {
    // Arrange
    GafferPopGraph graph = mock(GafferPopGraph.class);
    when(graph.execute(Mockito.<OperationChain<Object>>any())).thenReturn(null);

    // Act
    Iterator<Vertex> actualVerticesResult = (new GafferPopEdge("Label", "Out Vertex", "In Vertex", graph))
        .vertices(Direction.OUT);

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
   * <ul>
   *   <li>Then throw {@link UnsupportedOperationException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GafferPopEdge#vertices(Direction)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Iterator GafferPopEdge.vertices(Direction)"})
  public void testVertices_thenThrowUnsupportedOperationException() {
    // Arrange
    GafferPopGraph graph = mock(GafferPopGraph.class);
    when(graph.execute(Mockito.<OperationChain<Object>>any())).thenThrow(new UnsupportedOperationException("foo"));

    // Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new GafferPopEdge("Label", "Out Vertex", "In Vertex", graph)).vertices(Direction.IN));
    verify(graph).execute(isA(OperationChain.class));
  }

  /**
   * Test {@link GafferPopEdge#vertices(Direction)}.
   * <ul>
   *   <li>When {@code BOTH}.</li>
   *   <li>Then throw {@link UnsupportedOperationException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GafferPopEdge#vertices(Direction)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Iterator GafferPopEdge.vertices(Direction)"})
  public void testVertices_whenBoth_thenThrowUnsupportedOperationException() {
    // Arrange
    GafferPopGraph graph = mock(GafferPopGraph.class);
    when(graph.execute(Mockito.<OperationChain<Object>>any())).thenThrow(new UnsupportedOperationException("foo"));

    // Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new GafferPopEdge("Label", "Out Vertex", "In Vertex", graph)).vertices(Direction.BOTH));
    verify(graph).execute(isA(OperationChain.class));
  }

  /**
   * Test {@link GafferPopEdge#keys()}.
   * <ul>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link GafferPopEdge#keys()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Set GafferPopEdge.keys()"})
  public void testKeys_thenReturnEmpty() {
    // Arrange, Act and Assert
    assertTrue((new GafferPopEdge("Label", "Out Vertex", "In Vertex", null)).keys().isEmpty());
  }

  /**
   * Test {@link GafferPopEdge#keys()}.
   * <ul>
   *   <li>Then return size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link GafferPopEdge#keys()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Set GafferPopEdge.keys()"})
  public void testKeys_thenReturnSizeIsOne() {
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
