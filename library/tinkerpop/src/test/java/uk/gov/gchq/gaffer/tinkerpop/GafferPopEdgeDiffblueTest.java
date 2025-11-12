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
import static org.junit.Assert.assertTrue;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import org.apache.tinkerpop.gremlin.structure.Property;
import org.apache.tinkerpop.gremlin.structure.Vertex;
import org.apache.tinkerpop.gremlin.structure.util.empty.EmptyProperty;
import org.junit.Test;

public class GafferPopEdgeDiffblueTest {
  /**
   * Method under test: {@link GafferPopEdge#property(String)}
   */
  @Test
  public void testProperty() {
    // Arrange and Act
    Property<Object> actualPropertyResult = (new GafferPopEdge("Label", "Out Vertex", "In Vertex", null))
        .property("Key");

    // Assert
    assertTrue(actualPropertyResult instanceof EmptyProperty);
    assertFalse(actualPropertyResult.isPresent());
  }

  /**
   * Method under test: {@link GafferPopEdge#property(String)}
   */
  @Test
  public void testProperty2() {
    // Arrange and Act
    Property<Object> actualPropertyResult = (new GafferPopEdge("id", "Out Vertex", "In Vertex", null)).property("Key");

    // Assert
    assertTrue(actualPropertyResult instanceof EmptyProperty);
    assertFalse(actualPropertyResult.isPresent());
  }

  /**
   * Method under test: {@link GafferPopEdge#property(String)}
   */
  @Test
  public void testProperty3() throws NoSuchElementException {
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
   * Method under test: {@link GafferPopEdge#properties(String[])}
   */
  @Test
  public void testProperties() {
    // Arrange, Act and Assert
    assertFalse((new GafferPopEdge("Label", "Out Vertex", "In Vertex", null)).properties("Property Keys").hasNext());
  }

  /**
   * Method under test: {@link GafferPopEdge#properties(String[])}
   */
  @Test
  public void testProperties2() {
    // Arrange
    GafferPopEdge gafferPopEdge = new GafferPopEdge("Label", "Out Vertex", "In Vertex", null);
    gafferPopEdge.propertyWithoutUpdate("Key", "Value");

    // Act and Assert
    assertFalse(gafferPopEdge.properties("Property Keys").hasNext());
  }

  /**
   * Method under test: {@link GafferPopEdge#properties(String[])}
   */
  @Test
  public void testProperties3() throws NoSuchElementException {
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
   * Method under test: {@link GafferPopEdge#properties(String[])}
   */
  @Test
  public void testProperties4() {
    // Arrange
    GafferPopEdge gafferPopEdge = new GafferPopEdge("Label", "Out Vertex", "In Vertex", null);
    gafferPopEdge.propertyWithoutUpdate("Key", "Value");

    // Act and Assert
    assertFalse(gafferPopEdge.properties("Property Keys", null).hasNext());
  }

  /**
   * Method under test:
   * {@link GafferPopEdge#propertyWithoutUpdate(String, Object)}
   */
  @Test
  public void testPropertyWithoutUpdate() throws NoSuchElementException {
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
   * Method under test: {@link GafferPopEdge#keys()}
   */
  @Test
  public void testKeys() {
    // Arrange, Act and Assert
    assertTrue((new GafferPopEdge("Label", "Out Vertex", "In Vertex", null)).keys().isEmpty());
  }

  /**
   * Method under test: {@link GafferPopEdge#keys()}
   */
  @Test
  public void testKeys2() {
    // Arrange
    GafferPopEdge gafferPopEdge = new GafferPopEdge("Label", "Out Vertex", "In Vertex", null);
    gafferPopEdge.propertyWithoutUpdate("Key", "Value");

    // Act
    Set<String> actualKeysResult = gafferPopEdge.keys();

    // Assert
    assertEquals(1, actualKeysResult.size());
    assertTrue(actualKeysResult.contains("Key"));
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link GafferPopEdge#toString()}
   *   <li>{@link GafferPopEdge#inVertex()}
   *   <li>{@link GafferPopEdge#outVertex()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    GafferPopEdge gafferPopEdge = new GafferPopEdge("Label", "Out Vertex", "In Vertex", null);

    // Act
    String actualToStringResult = gafferPopEdge.toString();
    Vertex actualInVertexResult = gafferPopEdge.inVertex();
    Vertex actualOutVertexResult = gafferPopEdge.outVertex();

    // Assert
    assertTrue(actualInVertexResult instanceof GafferPopVertex);
    assertTrue(actualOutVertexResult instanceof GafferPopVertex);
    assertEquals("In Vertex", ((GafferPopVertex) actualInVertexResult).id);
    assertEquals("Out Vertex", ((GafferPopVertex) actualOutVertexResult).id);
    assertEquals("e[[Out Vertex, Label, In Vertex]][Out Vertex-Label->In Vertex]", actualToStringResult);
    assertEquals("id", ((GafferPopVertex) actualInVertexResult).label);
    assertEquals("id", ((GafferPopVertex) actualOutVertexResult).label);
  }

  /**
   * Method under test:
   * {@link GafferPopEdge#GafferPopEdge(String, Object, Object, GafferPopGraph)}
   */
  @Test
  public void testNewGafferPopEdge() {
    // Arrange and Act
    GafferPopEdge actualGafferPopEdge = new GafferPopEdge("Label", "Out Vertex", "In Vertex", null);

    // Assert
    Object object = actualGafferPopEdge.id;
    assertTrue(object instanceof List);
    Vertex inVertexResult = actualGafferPopEdge.inVertex();
    assertTrue(inVertexResult instanceof GafferPopVertex);
    Vertex outVertexResult = actualGafferPopEdge.outVertex();
    assertTrue(outVertexResult instanceof GafferPopVertex);
    assertEquals(3, ((List<String>) object).size());
    assertEquals("In Vertex", ((List<String>) object).get(2));
    assertEquals("In Vertex", inVertexResult.id());
    assertEquals("In Vertex", ((GafferPopVertex) inVertexResult).id);
    assertEquals("Label", ((List<String>) object).get(1));
    assertEquals("Label", actualGafferPopEdge.label());
    assertEquals("Label", actualGafferPopEdge.label);
    assertEquals("Out Vertex", ((List<String>) object).get(0));
    assertEquals("Out Vertex", outVertexResult.id());
    assertEquals("Out Vertex", ((GafferPopVertex) outVertexResult).id);
    assertEquals("id", inVertexResult.label());
    assertEquals("id", outVertexResult.label());
    assertEquals("id", ((GafferPopVertex) inVertexResult).label);
    assertEquals("id", ((GafferPopVertex) outVertexResult).label);
    assertNull(inVertexResult.graph());
    assertNull(outVertexResult.graph());
    assertNull(actualGafferPopEdge.graph());
    assertFalse(actualGafferPopEdge.isReadOnly());
    assertFalse(((GafferPopVertex) inVertexResult).isReadOnly());
    assertFalse(((GafferPopVertex) outVertexResult).isReadOnly());
    Object expectedIdResult = actualGafferPopEdge.id;
    assertSame(expectedIdResult, actualGafferPopEdge.id());
  }

  /**
   * Method under test:
   * {@link GafferPopEdge#GafferPopEdge(String, Object, Object, GafferPopGraph)}
   */
  @Test
  public void testNewGafferPopEdge2() {
    // Arrange
    GafferPopVertex gafferPopVertex = new GafferPopVertex("Label", "Id", null);

    GafferPopVertex gafferPopVertex2 = new GafferPopVertex("Label", "Id", null);

    // Act
    GafferPopEdge actualGafferPopEdge = new GafferPopEdge("Label", gafferPopVertex, gafferPopVertex2, null);

    // Assert
    Object object = actualGafferPopEdge.id;
    assertTrue(object instanceof List);
    assertEquals(3, ((List<String>) object).size());
    assertEquals("Id", ((List<String>) object).get(0));
    assertEquals("Id", ((List<String>) object).get(2));
    assertEquals("Label", ((List<String>) object).get(1));
    assertEquals("Label", actualGafferPopEdge.label());
    assertEquals("Label", actualGafferPopEdge.label);
    assertNull(actualGafferPopEdge.graph());
    assertFalse(actualGafferPopEdge.isReadOnly());
    assertSame(gafferPopVertex2, actualGafferPopEdge.inVertex());
    assertSame(gafferPopVertex, actualGafferPopEdge.outVertex());
    Object expectedIdResult = actualGafferPopEdge.id;
    assertSame(expectedIdResult, actualGafferPopEdge.id());
  }
}
