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

package uk.gov.gchq.gaffer.data.elementdefinition;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.function.Predicate;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.data.elementdefinition.ElementDefinitions.BaseBuilder;
import uk.gov.gchq.gaffer.data.elementdefinition.exception.SchemaException;
import uk.gov.gchq.gaffer.data.elementdefinition.view.NamedView;
import uk.gov.gchq.gaffer.data.elementdefinition.view.NamedView.Builder;
import uk.gov.gchq.gaffer.data.elementdefinition.view.View;
import uk.gov.gchq.gaffer.data.elementdefinition.view.ViewElementDefinition;

class ElementDefinitionsDiffblueTest {
  /**
   * Test BaseBuilder {@link BaseBuilder#addEdges(Map)}.
   * <ul>
   *   <li>Given {@link Builder#Builder()}.</li>
   *   <li>When {@link HashMap#HashMap()}.</li>
   *   <li>Then return {@link Builder#Builder()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseBuilder#addEdges(Map)}
   */
  @Test
  @DisplayName("Test BaseBuilder addEdges(Map); given Builder(); when HashMap(); then return Builder()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"BaseBuilder BaseBuilder.addEdges(Map)"})
  void testBaseBuilderAddEdges_givenBuilder_whenHashMap_thenReturnBuilder() {
    // Arrange
    Builder builder = new Builder();

    // Act and Assert
    assertSame(builder, builder.addEdges(new HashMap<>()));
  }

  /**
   * Test BaseBuilder {@link BaseBuilder#addEdges(Map)}.
   * <ul>
   *   <li>Given {@link Builder#Builder()}.</li>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@link Builder#Builder()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseBuilder#addEdges(Map)}
   */
  @Test
  @DisplayName("Test BaseBuilder addEdges(Map); given Builder(); when 'null'; then return Builder()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"BaseBuilder BaseBuilder.addEdges(Map)"})
  void testBaseBuilderAddEdges_givenBuilder_whenNull_thenReturnBuilder() {
    // Arrange
    Builder builder = new Builder();

    // Act and Assert
    assertSame(builder, builder.addEdges(null));
  }

  /**
   * Test BaseBuilder {@link BaseBuilder#addEntities(Map)}.
   * <ul>
   *   <li>Given {@link Builder#Builder()}.</li>
   *   <li>When {@link HashMap#HashMap()}.</li>
   *   <li>Then return {@link Builder#Builder()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseBuilder#addEntities(Map)}
   */
  @Test
  @DisplayName("Test BaseBuilder addEntities(Map); given Builder(); when HashMap(); then return Builder()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"BaseBuilder BaseBuilder.addEntities(Map)"})
  void testBaseBuilderAddEntities_givenBuilder_whenHashMap_thenReturnBuilder() {
    // Arrange
    Builder builder = new Builder();

    // Act and Assert
    assertSame(builder, builder.addEntities(new HashMap<>()));
  }

  /**
   * Test BaseBuilder {@link BaseBuilder#addEntities(Map)}.
   * <ul>
   *   <li>Given {@link Builder#Builder()}.</li>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@link Builder#Builder()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseBuilder#addEntities(Map)}
   */
  @Test
  @DisplayName("Test BaseBuilder addEntities(Map); given Builder(); when 'null'; then return Builder()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"BaseBuilder BaseBuilder.addEntities(Map)"})
  void testBaseBuilderAddEntities_givenBuilder_whenNull_thenReturnBuilder() {
    // Arrange
    Builder builder = new Builder();

    // Act and Assert
    assertSame(builder, builder.addEntities(null));
  }

  /**
   * Test BaseBuilder {@link BaseBuilder#edges(Map)}.
   * <ul>
   *   <li>Given {@link Builder#Builder()}.</li>
   *   <li>When {@link HashMap#HashMap()}.</li>
   *   <li>Then return {@link Builder#Builder()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseBuilder#edges(Map)}
   */
  @Test
  @DisplayName("Test BaseBuilder edges(Map); given Builder(); when HashMap(); then return Builder()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"BaseBuilder BaseBuilder.edges(Map)"})
  void testBaseBuilderEdges_givenBuilder_whenHashMap_thenReturnBuilder() {
    // Arrange
    Builder builder = new Builder();

    // Act and Assert
    assertSame(builder, builder.edges(new HashMap<>()));
  }

  /**
   * Test BaseBuilder {@link BaseBuilder#edges(Map)}.
   * <ul>
   *   <li>Given {@link Builder#Builder()}.</li>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@link Builder#Builder()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseBuilder#edges(Map)}
   */
  @Test
  @DisplayName("Test BaseBuilder edges(Map); given Builder(); when 'null'; then return Builder()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"BaseBuilder BaseBuilder.edges(Map)"})
  void testBaseBuilderEdges_givenBuilder_whenNull_thenReturnBuilder() {
    // Arrange
    Builder builder = new Builder();

    // Act and Assert
    assertSame(builder, builder.edges((Map<String, ViewElementDefinition>) null));
  }

  /**
   * Test BaseBuilder {@link BaseBuilder#entities(Map)}.
   * <ul>
   *   <li>Given {@link Builder#Builder()}.</li>
   *   <li>When {@link HashMap#HashMap()}.</li>
   *   <li>Then return {@link Builder#Builder()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseBuilder#entities(Map)}
   */
  @Test
  @DisplayName("Test BaseBuilder entities(Map); given Builder(); when HashMap(); then return Builder()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"BaseBuilder BaseBuilder.entities(Map)"})
  void testBaseBuilderEntities_givenBuilder_whenHashMap_thenReturnBuilder() {
    // Arrange
    Builder builder = new Builder();

    // Act and Assert
    assertSame(builder, builder.entities(new HashMap<>()));
  }

  /**
   * Test BaseBuilder {@link BaseBuilder#entities(Map)}.
   * <ul>
   *   <li>Given {@link Builder#Builder()}.</li>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@link Builder#Builder()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseBuilder#entities(Map)}
   */
  @Test
  @DisplayName("Test BaseBuilder entities(Map); given Builder(); when 'null'; then return Builder()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"BaseBuilder BaseBuilder.entities(Map)"})
  void testBaseBuilderEntities_givenBuilder_whenNull_thenReturnBuilder() {
    // Arrange
    Builder builder = new Builder();

    // Act and Assert
    assertSame(builder, builder.entities((Map<String, ViewElementDefinition>) null));
  }

  /**
   * Test BaseBuilder {@link BaseBuilder#json(Class, Path[])} with {@code clazz}, {@code filePaths}.
   * <ul>
   *   <li>Then return {@link Builder#Builder()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseBuilder#json(Class, Path[])}
   */
  @Test
  @DisplayName("Test BaseBuilder json(Class, Path[]) with 'clazz', 'filePaths'; then return Builder()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"BaseBuilder BaseBuilder.json(Class, Path[])"})
  void testBaseBuilderJsonWithClazzFilePaths_thenReturnBuilder() throws SchemaException {
    // Arrange
    Builder builder = new Builder();
    Class<View> clazz = View.class;
    Paths.get(System.getProperty("java.io.tmpdir"), "test.txt");

    // Act and Assert
    assertSame(builder, builder.json(clazz, new Path[]{}));
  }

  /**
   * Test BaseBuilder {@link BaseBuilder#json(Class, Path[])} with {@code clazz}, {@code filePaths}.
   * <ul>
   *   <li>When Property is {@code java.io.tmpdir} is empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseBuilder#json(Class, Path[])}
   */
  @Test
  @DisplayName("Test BaseBuilder json(Class, Path[]) with 'clazz', 'filePaths'; when Property is 'java.io.tmpdir' is empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"BaseBuilder BaseBuilder.json(Class, Path[])"})
  void testBaseBuilderJsonWithClazzFilePaths_whenPropertyIsJavaIoTmpdirIsEmptyString() throws SchemaException {
    // Arrange
    Builder builder = new Builder();
    Class<View> clazz = View.class;

    // Act and Assert
    assertThrows(SchemaException.class, () -> builder.json(clazz, Paths.get(System.getProperty("java.io.tmpdir"), "")));
  }

  /**
   * Test BaseBuilder {@link BaseBuilder#json(Class, Path[])} with {@code clazz}, {@code filePaths}.
   * <ul>
   *   <li>When Property is {@code java.io.tmpdir} is {@code test.txt}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseBuilder#json(Class, Path[])}
   */
  @Test
  @DisplayName("Test BaseBuilder json(Class, Path[]) with 'clazz', 'filePaths'; when Property is 'java.io.tmpdir' is 'test.txt'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"BaseBuilder BaseBuilder.json(Class, Path[])"})
  void testBaseBuilderJsonWithClazzFilePaths_whenPropertyIsJavaIoTmpdirIsTestTxt() throws SchemaException {
    // Arrange
    Builder builder = new Builder();
    Class<View> clazz = View.class;

    // Act and Assert
    assertThrows(SchemaException.class,
        () -> builder.json(clazz, Paths.get(System.getProperty("java.io.tmpdir"), "test.txt")));
  }

  /**
   * Test BaseBuilder {@link BaseBuilder#json(Class, byte[][])} with {@code clazz}, {@code jsonBytes}.
   * <ul>
   *   <li>Then return {@link Builder#Builder()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseBuilder#json(Class, byte[][])}
   */
  @Test
  @DisplayName("Test BaseBuilder json(Class, byte[][]) with 'clazz', 'jsonBytes'; then return Builder()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"BaseBuilder BaseBuilder.json(Class, byte[][])"})
  void testBaseBuilderJsonWithClazzJsonBytes_thenReturnBuilder() throws SchemaException {
    // Arrange
    Builder builder = new Builder();
    Class<View> clazz = View.class;

    // Act and Assert
    assertSame(builder, builder.json(clazz, new byte[][]{}));
  }

  /**
   * Test BaseBuilder {@link BaseBuilder#removeEdges(Predicate)}.
   * <ul>
   *   <li>Given {@link Builder#Builder()}.</li>
   *   <li>When {@link Predicate}.</li>
   *   <li>Then return {@link Builder#Builder()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseBuilder#removeEdges(Predicate)}
   */
  @Test
  @DisplayName("Test BaseBuilder removeEdges(Predicate); given Builder(); when Predicate; then return Builder()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"BaseBuilder BaseBuilder.removeEdges(Predicate)"})
  void testBaseBuilderRemoveEdges_givenBuilder_whenPredicate_thenReturnBuilder() {
    // Arrange
    Builder builder = new Builder();

    // Act and Assert
    assertSame(builder, builder.removeEdges(mock(Predicate.class)));
  }

  /**
   * Test BaseBuilder {@link BaseBuilder#removeEntities(Predicate)}.
   * <ul>
   *   <li>Given {@link Builder#Builder()}.</li>
   *   <li>When {@link Predicate}.</li>
   *   <li>Then return {@link Builder#Builder()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseBuilder#removeEntities(Predicate)}
   */
  @Test
  @DisplayName("Test BaseBuilder removeEntities(Predicate); given Builder(); when Predicate; then return Builder()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"BaseBuilder BaseBuilder.removeEntities(Predicate)"})
  void testBaseBuilderRemoveEntities_givenBuilder_whenPredicate_thenReturnBuilder() {
    // Arrange
    Builder builder = new Builder();

    // Act and Assert
    assertSame(builder, builder.removeEntities(mock(Predicate.class)));
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link ElementDefinitions}
   *   <li>{@link ElementDefinitions#setEdges(Map)}
   *   <li>{@link ElementDefinitions#setEntities(Map)}
   *   <li>{@link ElementDefinitions#toString()}
   *   <li>{@link ElementDefinitions#getEdges()}
   *   <li>{@link ElementDefinitions#getEntities()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void ElementDefinitions.<init>()", "Map ElementDefinitions.getEdges()",
      "Map ElementDefinitions.getEntities()", "void ElementDefinitions.setEdges(Map)",
      "void ElementDefinitions.setEntities(Map)", "String ElementDefinitions.toString()"})
  void testGettersAndSetters() {
    // Arrange and Act
    ElementDefinitions<ElementDefinition, ElementDefinition> actualElementDefinitions = new ElementDefinitions<>();
    HashMap<String, ElementDefinition> edges = new HashMap<>();
    actualElementDefinitions.setEdges(edges);
    HashMap<String, ElementDefinition> entities = new HashMap<>();
    actualElementDefinitions.setEntities(entities);
    String actualToStringResult = actualElementDefinitions.toString();
    Map<String, ElementDefinition> actualEdges = actualElementDefinitions.getEdges();
    Map<String, ElementDefinition> actualEntities = actualElementDefinitions.getEntities();

    // Assert
    assertEquals("ElementDefinitions[edges={},entities={}]", actualToStringResult);
    assertTrue(actualEdges.isEmpty());
    assertTrue(actualEntities.isEmpty());
    assertSame(edges, actualEdges);
    assertSame(entities, actualEntities);
  }

  /**
   * Test {@link ElementDefinitions#isEntity(String)}.
   * <p>
   * Method under test: {@link ElementDefinitions#isEntity(String)}
   */
  @Test
  @DisplayName("Test isEntity(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ElementDefinitions.isEntity(String)"})
  void testIsEntity() {
    // Arrange
    ElementDefinitions<ElementDefinition, ElementDefinition> elementDefinitions = new ElementDefinitions<>();

    // Act and Assert
    assertFalse(elementDefinitions.isEntity("Group"));
  }

  /**
   * Test {@link ElementDefinitions#isEdge(String)}.
   * <p>
   * Method under test: {@link ElementDefinitions#isEdge(String)}
   */
  @Test
  @DisplayName("Test isEdge(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ElementDefinitions.isEdge(String)"})
  void testIsEdge() {
    // Arrange
    ElementDefinitions<ElementDefinition, ElementDefinition> elementDefinitions = new ElementDefinitions<>();

    // Act and Assert
    assertFalse(elementDefinitions.isEdge("Group"));
  }

  /**
   * Test {@link ElementDefinitions#getEdgeGroups()}.
   * <ul>
   *   <li>Given {@link ElementDefinitions#ElementDefinitions()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ElementDefinitions#getEdgeGroups()}
   */
  @Test
  @DisplayName("Test getEdgeGroups(); given ElementDefinitions()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.util.Set ElementDefinitions.getEdgeGroups()"})
  void testGetEdgeGroups_givenElementDefinitions() {
    // Arrange
    ElementDefinitions<ElementDefinition, ElementDefinition> elementDefinitions = new ElementDefinitions<>();

    // Act and Assert
    assertTrue(elementDefinitions.getEdgeGroups().isEmpty());
  }

  /**
   * Test {@link ElementDefinitions#getEdgeGroups()}.
   * <ul>
   *   <li>Given {@link ElementDefinitions#ElementDefinitions()} Edges is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ElementDefinitions#getEdgeGroups()}
   */
  @Test
  @DisplayName("Test getEdgeGroups(); given ElementDefinitions() Edges is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.util.Set ElementDefinitions.getEdgeGroups()"})
  void testGetEdgeGroups_givenElementDefinitionsEdgesIsNull() {
    // Arrange
    ElementDefinitions<ElementDefinition, ElementDefinition> elementDefinitions = new ElementDefinitions<>();
    elementDefinitions.setEdges(null);

    // Act and Assert
    assertTrue(elementDefinitions.getEdgeGroups().isEmpty());
  }

  /**
   * Test {@link ElementDefinitions#getEntityGroups()}.
   * <ul>
   *   <li>Given {@link ElementDefinitions#ElementDefinitions()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ElementDefinitions#getEntityGroups()}
   */
  @Test
  @DisplayName("Test getEntityGroups(); given ElementDefinitions()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.util.Set ElementDefinitions.getEntityGroups()"})
  void testGetEntityGroups_givenElementDefinitions() {
    // Arrange
    ElementDefinitions<ElementDefinition, ElementDefinition> elementDefinitions = new ElementDefinitions<>();

    // Act and Assert
    assertTrue(elementDefinitions.getEntityGroups().isEmpty());
  }

  /**
   * Test {@link ElementDefinitions#getEntityGroups()}.
   * <ul>
   *   <li>Given {@link ElementDefinitions#ElementDefinitions()} Entities is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ElementDefinitions#getEntityGroups()}
   */
  @Test
  @DisplayName("Test getEntityGroups(); given ElementDefinitions() Entities is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.util.Set ElementDefinitions.getEntityGroups()"})
  void testGetEntityGroups_givenElementDefinitionsEntitiesIsNull() {
    // Arrange
    ElementDefinitions<ElementDefinition, ElementDefinition> elementDefinitions = new ElementDefinitions<>();
    elementDefinitions.setEntities(null);

    // Act and Assert
    assertTrue(elementDefinitions.getEntityGroups().isEmpty());
  }

  /**
   * Test {@link ElementDefinitions#getGroups()}.
   * <ul>
   *   <li>Given {@link ElementDefinitions#ElementDefinitions()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ElementDefinitions#getGroups()}
   */
  @Test
  @DisplayName("Test getGroups(); given ElementDefinitions()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.util.Set ElementDefinitions.getGroups()"})
  void testGetGroups_givenElementDefinitions() {
    // Arrange
    ElementDefinitions<ElementDefinition, ElementDefinition> elementDefinitions = new ElementDefinitions<>();

    // Act and Assert
    assertTrue(elementDefinitions.getGroups().isEmpty());
  }

  /**
   * Test {@link ElementDefinitions#getGroups()}.
   * <ul>
   *   <li>Given {@link ElementDefinitions#ElementDefinitions()} Edges is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ElementDefinitions#getGroups()}
   */
  @Test
  @DisplayName("Test getGroups(); given ElementDefinitions() Edges is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.util.Set ElementDefinitions.getGroups()"})
  void testGetGroups_givenElementDefinitionsEdgesIsNull() {
    // Arrange
    ElementDefinitions<ElementDefinition, ElementDefinition> elementDefinitions = new ElementDefinitions<>();
    elementDefinitions.setEdges(null);
    elementDefinitions.setEntities(null);

    // Act and Assert
    assertTrue(elementDefinitions.getGroups().isEmpty());
  }

  /**
   * Test {@link ElementDefinitions#hasEntities()}.
   * <ul>
   *   <li>Given {@link ElementDefinitions#ElementDefinitions()} Entities is {@code null}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ElementDefinitions#hasEntities()}
   */
  @Test
  @DisplayName("Test hasEntities(); given ElementDefinitions() Entities is 'null'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ElementDefinitions.hasEntities()"})
  void testHasEntities_givenElementDefinitionsEntitiesIsNull_thenReturnFalse() {
    // Arrange
    ElementDefinitions<ElementDefinition, ElementDefinition> elementDefinitions = new ElementDefinitions<>();
    elementDefinitions.setEntities(null);

    // Act and Assert
    assertFalse(elementDefinitions.hasEntities());
  }

  /**
   * Test {@link ElementDefinitions#hasEntities()}.
   * <ul>
   *   <li>Given {@link ElementDefinitions#ElementDefinitions()}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ElementDefinitions#hasEntities()}
   */
  @Test
  @DisplayName("Test hasEntities(); given ElementDefinitions(); then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ElementDefinitions.hasEntities()"})
  void testHasEntities_givenElementDefinitions_thenReturnFalse() {
    // Arrange
    ElementDefinitions<ElementDefinition, ElementDefinition> elementDefinitions = new ElementDefinitions<>();

    // Act and Assert
    assertFalse(elementDefinitions.hasEntities());
  }

  /**
   * Test {@link ElementDefinitions#hasEntities()}.
   * <ul>
   *   <li>Given {@link TreeMap#TreeMap()} {@code foo} is {@link ElementDefinition}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ElementDefinitions#hasEntities()}
   */
  @Test
  @DisplayName("Test hasEntities(); given TreeMap() 'foo' is ElementDefinition; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ElementDefinitions.hasEntities()"})
  void testHasEntities_givenTreeMapFooIsElementDefinition_thenReturnTrue() {
    // Arrange
    TreeMap<String, ElementDefinition> entities = new TreeMap<>();
    entities.put("foo", mock(ElementDefinition.class));

    ElementDefinitions<ElementDefinition, ElementDefinition> elementDefinitions = new ElementDefinitions<>();
    elementDefinitions.setEntities(entities);

    // Act and Assert
    assertTrue(elementDefinitions.hasEntities());
  }

  /**
   * Test {@link ElementDefinitions#hasEdges()}.
   * <ul>
   *   <li>Given {@link ElementDefinitions#ElementDefinitions()} Edges is {@code null}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ElementDefinitions#hasEdges()}
   */
  @Test
  @DisplayName("Test hasEdges(); given ElementDefinitions() Edges is 'null'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ElementDefinitions.hasEdges()"})
  void testHasEdges_givenElementDefinitionsEdgesIsNull_thenReturnFalse() {
    // Arrange
    ElementDefinitions<ElementDefinition, ElementDefinition> elementDefinitions = new ElementDefinitions<>();
    elementDefinitions.setEdges(null);

    // Act and Assert
    assertFalse(elementDefinitions.hasEdges());
  }

  /**
   * Test {@link ElementDefinitions#hasEdges()}.
   * <ul>
   *   <li>Given {@link ElementDefinitions#ElementDefinitions()}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ElementDefinitions#hasEdges()}
   */
  @Test
  @DisplayName("Test hasEdges(); given ElementDefinitions(); then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ElementDefinitions.hasEdges()"})
  void testHasEdges_givenElementDefinitions_thenReturnFalse() {
    // Arrange
    ElementDefinitions<ElementDefinition, ElementDefinition> elementDefinitions = new ElementDefinitions<>();

    // Act and Assert
    assertFalse(elementDefinitions.hasEdges());
  }

  /**
   * Test {@link ElementDefinitions#hasEdges()}.
   * <ul>
   *   <li>Given {@link TreeMap#TreeMap()} {@code foo} is {@link ElementDefinition}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ElementDefinitions#hasEdges()}
   */
  @Test
  @DisplayName("Test hasEdges(); given TreeMap() 'foo' is ElementDefinition; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ElementDefinitions.hasEdges()"})
  void testHasEdges_givenTreeMapFooIsElementDefinition_thenReturnTrue() {
    // Arrange
    TreeMap<String, ElementDefinition> edges = new TreeMap<>();
    edges.put("foo", mock(ElementDefinition.class));

    ElementDefinitions<ElementDefinition, ElementDefinition> elementDefinitions = new ElementDefinitions<>();
    elementDefinitions.setEdges(edges);

    // Act and Assert
    assertTrue(elementDefinitions.hasEdges());
  }

  /**
   * Test {@link ElementDefinitions#hasGroups()}.
   * <ul>
   *   <li>Given {@link ElementDefinitions#ElementDefinitions()} Edges is {@link HashMap#HashMap()}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ElementDefinitions#hasGroups()}
   */
  @Test
  @DisplayName("Test hasGroups(); given ElementDefinitions() Edges is HashMap(); then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ElementDefinitions.hasGroups()"})
  void testHasGroups_givenElementDefinitionsEdgesIsHashMap_thenReturnTrue() {
    // Arrange
    HashMap<String, ElementDefinition> edges = new HashMap<>();
    edges.put("foo", mock(ElementDefinition.class));

    ElementDefinitions<ElementDefinition, ElementDefinition> elementDefinitions = new ElementDefinitions<>();
    elementDefinitions.setEdges(edges);

    // Act and Assert
    assertTrue(elementDefinitions.hasGroups());
  }

  /**
   * Test {@link ElementDefinitions#hasGroups()}.
   * <ul>
   *   <li>Given {@link ElementDefinitions#ElementDefinitions()} Edges is {@code null}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ElementDefinitions#hasGroups()}
   */
  @Test
  @DisplayName("Test hasGroups(); given ElementDefinitions() Edges is 'null'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ElementDefinitions.hasGroups()"})
  void testHasGroups_givenElementDefinitionsEdgesIsNull_thenReturnFalse() {
    // Arrange
    ElementDefinitions<ElementDefinition, ElementDefinition> elementDefinitions = new ElementDefinitions<>();
    elementDefinitions.setEdges(null);
    elementDefinitions.setEntities(null);

    // Act and Assert
    assertFalse(elementDefinitions.hasGroups());
  }

  /**
   * Test {@link ElementDefinitions#hasGroups()}.
   * <ul>
   *   <li>Given {@link ElementDefinitions#ElementDefinitions()} Entities is {@link HashMap#HashMap()}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ElementDefinitions#hasGroups()}
   */
  @Test
  @DisplayName("Test hasGroups(); given ElementDefinitions() Entities is HashMap(); then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ElementDefinitions.hasGroups()"})
  void testHasGroups_givenElementDefinitionsEntitiesIsHashMap_thenReturnTrue() {
    // Arrange
    HashMap<String, ElementDefinition> entities = new HashMap<>();
    entities.put("foo", mock(ElementDefinition.class));

    ElementDefinitions<ElementDefinition, ElementDefinition> elementDefinitions = new ElementDefinitions<>();
    elementDefinitions.setEntities(entities);

    // Act and Assert
    assertTrue(elementDefinitions.hasGroups());
  }

  /**
   * Test {@link ElementDefinitions#hasGroups()}.
   * <ul>
   *   <li>Given {@link ElementDefinitions#ElementDefinitions()}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ElementDefinitions#hasGroups()}
   */
  @Test
  @DisplayName("Test hasGroups(); given ElementDefinitions(); then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ElementDefinitions.hasGroups()"})
  void testHasGroups_givenElementDefinitions_thenReturnFalse() {
    // Arrange
    ElementDefinitions<ElementDefinition, ElementDefinition> elementDefinitions = new ElementDefinitions<>();

    // Act and Assert
    assertFalse(elementDefinitions.hasGroups());
  }

  /**
   * Test {@link ElementDefinitions#equals(Object)}, and {@link ElementDefinitions#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ElementDefinitions#equals(Object)}
   *   <li>{@link ElementDefinitions#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ElementDefinitions.equals(Object)", "int ElementDefinitions.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ElementDefinitions<ElementDefinition, ElementDefinition> elementDefinitions = new ElementDefinitions<>();
    ElementDefinitions<ElementDefinition, ElementDefinition> elementDefinitions2 = new ElementDefinitions<>();

    // Act and Assert
    assertEquals(elementDefinitions, elementDefinitions2);
    int expectedHashCodeResult = elementDefinitions.hashCode();
    assertEquals(expectedHashCodeResult, elementDefinitions2.hashCode());
  }

  /**
   * Test {@link ElementDefinitions#equals(Object)}, and {@link ElementDefinitions#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ElementDefinitions#equals(Object)}
   *   <li>{@link ElementDefinitions#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ElementDefinitions.equals(Object)", "int ElementDefinitions.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ElementDefinitions<ElementDefinition, ElementDefinition> elementDefinitions = new ElementDefinitions<>();

    // Act and Assert
    assertEquals(elementDefinitions, elementDefinitions);
    int expectedHashCodeResult = elementDefinitions.hashCode();
    assertEquals(expectedHashCodeResult, elementDefinitions.hashCode());
  }

  /**
   * Test {@link ElementDefinitions#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ElementDefinitions#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ElementDefinitions.equals(Object)", "int ElementDefinitions.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ElementDefinitions<ElementDefinition, ElementDefinition> elementDefinitions = new ElementDefinitions<>();

    // Act and Assert
    assertNotEquals(elementDefinitions, null);
  }

  /**
   * Test {@link ElementDefinitions#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ElementDefinitions#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ElementDefinitions.equals(Object)", "int ElementDefinitions.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    ElementDefinitions<ElementDefinition, ElementDefinition> elementDefinitions = new ElementDefinitions<>();

    // Act and Assert
    assertNotEquals(elementDefinitions, null);
  }

  /**
   * Test {@link ElementDefinitions#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ElementDefinitions#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ElementDefinitions.equals(Object)", "int ElementDefinitions.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    ElementDefinitions<ElementDefinition, ElementDefinition> elementDefinitions = new ElementDefinitions<>();

    // Act and Assert
    assertNotEquals(elementDefinitions, "Different type to ElementDefinitions");
  }
}
