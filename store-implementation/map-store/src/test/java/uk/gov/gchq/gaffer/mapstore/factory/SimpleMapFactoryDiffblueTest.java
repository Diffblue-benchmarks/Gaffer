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

package uk.gov.gchq.gaffer.mapstore.factory;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import uk.gov.gchq.gaffer.data.element.Edge;
import uk.gov.gchq.gaffer.data.element.Element;
import uk.gov.gchq.gaffer.data.element.ElementValueLoader;
import uk.gov.gchq.gaffer.data.element.Entity;
import uk.gov.gchq.gaffer.data.element.Entity.Builder;
import uk.gov.gchq.gaffer.data.element.LazyEntity;
import uk.gov.gchq.gaffer.mapstore.multimap.MapOfSets;
import uk.gov.gchq.gaffer.mapstore.multimap.MultiMap;
import uk.gov.gchq.gaffer.store.schema.Schema;

class SimpleMapFactoryDiffblueTest {
  /**
   * Test {@link SimpleMapFactory#getMap(String, Class, Class)}.
   *
   * <p>Method under test: {@link SimpleMapFactory#getMap(String, Class, Class)}
   */
  @Test
  @DisplayName("Test getMap(String, Class, Class)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.Map SimpleMapFactory.getMap(String, Class, Class)"})
  void testGetMap() {
    // Arrange
    SimpleMapFactory simpleMapFactory = new SimpleMapFactory();
    Class<Object> keyClass = Object.class;
    Class<Object> valueClass = Object.class;

    // Act and Assert
    assertTrue(simpleMapFactory.getMap("Map Name", keyClass, valueClass).isEmpty());
  }

  /**
   * Test {@link SimpleMapFactory#getMultiMap(String, Class, Class)}.
   *
   * <p>Method under test: {@link SimpleMapFactory#getMultiMap(String, Class, Class)}
   */
  @Test
  @DisplayName("Test getMultiMap(String, Class, Class)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MultiMap SimpleMapFactory.getMultiMap(String, Class, Class)"})
  void testGetMultiMap() {
    // Arrange
    SimpleMapFactory simpleMapFactory = new SimpleMapFactory();
    Class<Object> keyClass = Object.class;
    Class<Object> valueClass = Object.class;

    // Act
    MultiMap<Object, Object> actualMultiMap =
        simpleMapFactory.getMultiMap("Map Name", keyClass, valueClass);

    // Assert
    assertTrue(actualMultiMap instanceof MapOfSets);
    assertTrue(((MapOfSets<Object, Object>) actualMultiMap).getWrappedMap().isEmpty());
  }

  /**
   * Test {@link SimpleMapFactory#cloneElement(Element, Schema)}.
   *
   * <ul>
   *   <li>Then return {@link Entity.Builder} (default constructor) group {@code Group} vertex
   *       {@code Vertex} build.
   * </ul>
   *
   * <p>Method under test: {@link SimpleMapFactory#cloneElement(Element, Schema)}
   */
  @Test
  @DisplayName(
      "Test cloneElement(Element, Schema); then return Builder (default constructor) group 'Group' vertex 'Vertex' build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Element SimpleMapFactory.cloneElement(Element, Schema)"})
  void testCloneElement_thenReturnBuilderGroupGroupVertexVertexBuild() {
    // Arrange
    SimpleMapFactory simpleMapFactory = new SimpleMapFactory();
    Entity element = new Builder().group("Group").vertex("Vertex").build();

    // Act
    Element actualCloneElementResult = simpleMapFactory.cloneElement(element, new Schema());

    // Assert
    assertTrue(actualCloneElementResult instanceof Entity);
    assertEquals(element, actualCloneElementResult);
  }

  /**
   * Test {@link SimpleMapFactory#cloneElement(Element, Schema)}.
   *
   * <ul>
   *   <li>Then return {@code Group}.
   * </ul>
   *
   * <p>Method under test: {@link SimpleMapFactory#cloneElement(Element, Schema)}
   */
  @Test
  @DisplayName("Test cloneElement(Element, Schema); then return 'Group'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Element SimpleMapFactory.cloneElement(Element, Schema)"})
  void testCloneElement_thenReturnGroup() {
    // Arrange
    SimpleMapFactory simpleMapFactory = new SimpleMapFactory();

    ElementValueLoader valueLoader = mock(ElementValueLoader.class);
    doNothing().when(valueLoader).loadIdentifiers(Mockito.<Element>any());
    Entity entity = new Builder().group("Group").vertex("Vertex").build();

    LazyEntity element = new LazyEntity(entity, valueLoader);

    // Act
    Element actualCloneElementResult = simpleMapFactory.cloneElement(element, new Schema());

    // Assert
    verify(valueLoader).loadIdentifiers(isA(Element.class));
    assertTrue(actualCloneElementResult instanceof Entity);
    assertEquals("Group", actualCloneElementResult.getGroup());
    assertEquals("Vertex", ((Entity) actualCloneElementResult).getVertex());
    assertEquals("uk.gov.gchq.gaffer.data.element.Entity", actualCloneElementResult.getClassName());
    assertTrue(actualCloneElementResult.getProperties().isEmpty());
  }

  /**
   * Test {@link SimpleMapFactory#cloneElement(Element, Schema)}.
   *
   * <ul>
   *   <li>When {@link Edge#Edge(String)} with {@code Group}.
   *   <li>Then return {@link Edge}.
   * </ul>
   *
   * <p>Method under test: {@link SimpleMapFactory#cloneElement(Element, Schema)}
   */
  @Test
  @DisplayName(
      "Test cloneElement(Element, Schema); when Edge(String) with 'Group'; then return Edge")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Element SimpleMapFactory.cloneElement(Element, Schema)"})
  void testCloneElement_whenEdgeWithGroup_thenReturnEdge() {
    // Arrange
    SimpleMapFactory simpleMapFactory = new SimpleMapFactory();
    Edge element = new Edge("Group");

    // Act
    Element actualCloneElementResult = simpleMapFactory.cloneElement(element, new Schema());

    // Assert
    assertTrue(actualCloneElementResult instanceof Edge);
    assertEquals(element, actualCloneElementResult);
  }
}
