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

package uk.gov.gchq.gaffer.store.element;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import uk.gov.gchq.gaffer.data.element.Edge;
import uk.gov.gchq.gaffer.data.element.Edge.Builder;
import uk.gov.gchq.gaffer.data.element.Element;
import uk.gov.gchq.gaffer.data.element.ElementValueLoader;
import uk.gov.gchq.gaffer.data.element.Entity;
import uk.gov.gchq.gaffer.data.element.LazyEdge;
import uk.gov.gchq.gaffer.data.element.LazyProperties;
import uk.gov.gchq.gaffer.data.element.Properties;
import uk.gov.gchq.gaffer.data.element.id.EdgeId;
import uk.gov.gchq.gaffer.data.element.id.EdgeId.MatchedVertex;
import uk.gov.gchq.gaffer.store.element.ElementKey.EdgeKey;
import uk.gov.gchq.gaffer.store.element.ElementKey.EntityKey;
import uk.gov.gchq.gaffer.store.schema.Schema;
import uk.gov.gchq.gaffer.store.schema.SchemaEdgeDefinition;
import uk.gov.gchq.gaffer.store.schema.SchemaElementDefinition;

class ElementKeyDiffblueTest {
  /**
   * Test {@link ElementKey#create(Element, SchemaElementDefinition)} with {@code element}, {@code
   * elementDef}.
   *
   * <ul>
   *   <li>When {@link Edge#Edge(String)} with {@code Group}.
   *   <li>Then return {@link EdgeKey}.
   * </ul>
   *
   * <p>Method under test: {@link ElementKey#create(Element, SchemaElementDefinition)}
   */
  @Test
  @DisplayName(
      "Test create(Element, SchemaElementDefinition) with 'element', 'elementDef'; when Edge(String) with 'Group'; then return EdgeKey")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ElementKey ElementKey.create(Element, SchemaElementDefinition)"})
  void testCreateWithElementElementDef_whenEdgeWithGroup_thenReturnEdgeKey() {
    // Arrange
    Edge element = new Edge("Group");

    // Act and Assert
    assertTrue(ElementKey.create(element, new SchemaEdgeDefinition()) instanceof EdgeKey);
  }

  /**
   * Test {@link ElementKey#create(Element, SchemaElementDefinition)} with {@code element}, {@code
   * elementDef}.
   *
   * <ul>
   *   <li>When {@link Entity#Entity(String)} with {@code Group}.
   *   <li>Then return {@link EntityKey}.
   * </ul>
   *
   * <p>Method under test: {@link ElementKey#create(Element, SchemaElementDefinition)}
   */
  @Test
  @DisplayName(
      "Test create(Element, SchemaElementDefinition) with 'element', 'elementDef'; when Entity(String) with 'Group'; then return EntityKey")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ElementKey ElementKey.create(Element, SchemaElementDefinition)"})
  void testCreateWithElementElementDef_whenEntityWithGroup_thenReturnEntityKey() {
    // Arrange
    Entity element = new Entity("Group");

    // Act and Assert
    assertTrue(ElementKey.create(element, new SchemaEdgeDefinition()) instanceof EntityKey);
  }

  /**
   * Test {@link ElementKey#create(Element, SchemaElementDefinition)} with {@code element}, {@code
   * elementDef}.
   *
   * <ul>
   *   <li>When {@link Entity#Entity(String)} with {@code Group}.
   *   <li>Then return {@link EntityKey}.
   * </ul>
   *
   * <p>Method under test: {@link ElementKey#create(Element, SchemaElementDefinition)}
   */
  @Test
  @DisplayName(
      "Test create(Element, SchemaElementDefinition) with 'element', 'elementDef'; when Entity(String) with 'Group'; then return EntityKey")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ElementKey ElementKey.create(Element, SchemaElementDefinition)"})
  void testCreateWithElementElementDef_whenEntityWithGroup_thenReturnEntityKey2() {
    // Arrange, Act and Assert
    assertTrue(
        ElementKey.create(new Entity("Group"), (SchemaElementDefinition) null)
            instanceof EntityKey);
  }

  /**
   * Test {@link ElementKey#create(Element, SchemaElementDefinition)} with {@code element}, {@code
   * elementDef}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link ElementKey#create(Element, SchemaElementDefinition)}
   */
  @Test
  @DisplayName(
      "Test create(Element, SchemaElementDefinition) with 'element', 'elementDef'; when 'null'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ElementKey ElementKey.create(Element, SchemaElementDefinition)"})
  void testCreateWithElementElementDef_whenNull_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> ElementKey.create(null, new SchemaEdgeDefinition()));
  }

  /**
   * Test {@link ElementKey#create(Element, Set)} with {@code element}, {@code groupBy}.
   *
   * <p>Method under test: {@link ElementKey#create(Element, Set)}
   */
  @Test
  @DisplayName("Test create(Element, Set) with 'element', 'groupBy'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ElementKey ElementKey.create(Element, Set)"})
  void testCreateWithElementGroupBy() {
    // Arrange
    ElementValueLoader valueLoader = mock(ElementValueLoader.class);
    when(valueLoader.getProperty(Mockito.<String>any(), Mockito.<Properties>any()))
        .thenReturn("Property");
    Edge edge =
        new Builder()
            .dest("Dest")
            .directed(true)
            .group("Group")
            .matchedVertex(MatchedVertex.SOURCE)
            .source("Source")
            .build();

    LazyEdge element = new LazyEdge(edge, valueLoader);

    LinkedHashSet<String> groupBy = new LinkedHashSet<>();
    groupBy.add("Group By");

    // Act
    ElementKey.create(element, groupBy);

    // Assert
    verify(valueLoader).getProperty(eq("Group By"), isA(Properties.class));
    Properties properties = element.getElement().getProperties();
    assertEquals(1, properties.size());
    assertEquals("Property", properties.get("Group By"));
    LazyProperties properties2 = element.getProperties();
    assertEquals(1, properties2.size());
    assertEquals("Property", properties2.get((Object) "Group By"));
  }

  /**
   * Test {@link ElementKey#create(Element, Set)} with {@code element}, {@code groupBy}.
   *
   * <p>Method under test: {@link ElementKey#create(Element, Set)}
   */
  @Test
  @DisplayName("Test create(Element, Set) with 'element', 'groupBy'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ElementKey ElementKey.create(Element, Set)"})
  void testCreateWithElementGroupBy2() {
    // Arrange
    ElementValueLoader valueLoader = mock(ElementValueLoader.class);
    when(valueLoader.getProperty(Mockito.<String>any(), Mockito.<Properties>any()))
        .thenReturn(null);
    Edge edge =
        new Builder()
            .dest("Dest")
            .directed(true)
            .group("Group")
            .matchedVertex(MatchedVertex.SOURCE)
            .source("Source")
            .build();

    LazyEdge element = new LazyEdge(edge, valueLoader);

    LinkedHashSet<String> groupBy = new LinkedHashSet<>();
    groupBy.add("Group By");

    // Act
    ElementKey actualCreateResult = ElementKey.create(element, groupBy);

    // Assert
    verify(valueLoader).getProperty(eq("Group By"), isA(Properties.class));
    assertTrue(actualCreateResult instanceof EdgeKey);
    assertTrue(element.getElement().getProperties().isEmpty());
    assertTrue(element.getProperties().isEmpty());
  }

  /**
   * Test {@link ElementKey#create(Element, Set)} with {@code element}, {@code groupBy}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link HashSet#HashSet()} add {@code 42}.
   *   <li>Then return {@link EdgeKey}.
   * </ul>
   *
   * <p>Method under test: {@link ElementKey#create(Element, Set)}
   */
  @Test
  @DisplayName(
      "Test create(Element, Set) with 'element', 'groupBy'; given '42'; when HashSet() add '42'; then return EdgeKey")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ElementKey ElementKey.create(Element, Set)"})
  void testCreateWithElementGroupBy_given42_whenHashSetAdd42_thenReturnEdgeKey() {
    // Arrange
    Edge element = new Edge("Group");

    HashSet<String> groupBy = new HashSet<>();
    groupBy.add("42");
    groupBy.add("foo");

    // Act and Assert
    assertTrue(ElementKey.create(element, groupBy) instanceof EdgeKey);
  }

  /**
   * Test {@link ElementKey#create(Element, Set)} with {@code element}, {@code groupBy}.
   *
   * <ul>
   *   <li>When {@link Entity#Entity(String)} with {@code Group}.
   *   <li>Then return {@link EntityKey}.
   * </ul>
   *
   * <p>Method under test: {@link ElementKey#create(Element, Set)}
   */
  @Test
  @DisplayName(
      "Test create(Element, Set) with 'element', 'groupBy'; when Entity(String) with 'Group'; then return EntityKey")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ElementKey ElementKey.create(Element, Set)"})
  void testCreateWithElementGroupBy_whenEntityWithGroup_thenReturnEntityKey() {
    // Arrange
    Entity element = new Entity("Group");

    LinkedHashSet<String> groupBy = new LinkedHashSet<>();
    groupBy.add("Group By");

    // Act and Assert
    assertTrue(ElementKey.create(element, groupBy) instanceof EntityKey);
  }

  /**
   * Test {@link ElementKey#create(Element, Set)} with {@code element}, {@code groupBy}.
   *
   * <ul>
   *   <li>When {@link Entity#Entity(String)} with {@code Group}.
   *   <li>Then return {@link EntityKey}.
   * </ul>
   *
   * <p>Method under test: {@link ElementKey#create(Element, Set)}
   */
  @Test
  @DisplayName(
      "Test create(Element, Set) with 'element', 'groupBy'; when Entity(String) with 'Group'; then return EntityKey")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ElementKey ElementKey.create(Element, Set)"})
  void testCreateWithElementGroupBy_whenEntityWithGroup_thenReturnEntityKey2() {
    // Arrange, Act and Assert
    assertTrue(ElementKey.create(new Entity("Group"), (Set<String>) null) instanceof EntityKey);
  }

  /**
   * Test {@link ElementKey#create(Element, Set)} with {@code element}, {@code groupBy}.
   *
   * <ul>
   *   <li>When {@link HashSet#HashSet()}.
   *   <li>Then return {@link EdgeKey}.
   * </ul>
   *
   * <p>Method under test: {@link ElementKey#create(Element, Set)}
   */
  @Test
  @DisplayName(
      "Test create(Element, Set) with 'element', 'groupBy'; when HashSet(); then return EdgeKey")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ElementKey ElementKey.create(Element, Set)"})
  void testCreateWithElementGroupBy_whenHashSet_thenReturnEdgeKey() {
    // Arrange
    Edge element = new Edge("Group");

    // Act and Assert
    assertTrue(ElementKey.create(element, new HashSet<>()) instanceof EdgeKey);
  }

  /**
   * Test {@link ElementKey#create(Element, Set)} with {@code element}, {@code groupBy}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link ElementKey#create(Element, Set)}
   */
  @Test
  @DisplayName(
      "Test create(Element, Set) with 'element', 'groupBy'; when 'null'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ElementKey ElementKey.create(Element, Set)"})
  void testCreateWithElementGroupBy_whenNull_thenThrowIllegalArgumentException() {
    // Arrange
    LinkedHashSet<String> groupBy = new LinkedHashSet<>();
    groupBy.add("Group By");

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> ElementKey.create(null, groupBy));
  }

  /**
   * Test {@link ElementKey#create(Element, Schema)} with {@code element}, {@code schema}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link ElementKey#create(Element, Schema)}
   */
  @Test
  @DisplayName(
      "Test create(Element, Schema) with 'element', 'schema'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ElementKey ElementKey.create(Element, Schema)"})
  void testCreateWithElementSchema_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> ElementKey.create(new Entity("Group"), (Schema) null));
  }

  /**
   * Test {@link ElementKey#create(Element, Schema)} with {@code element}, {@code schema}.
   *
   * <ul>
   *   <li>When {@link Edge#Edge(String)} with {@code Group}.
   *   <li>Then return {@link EdgeKey}.
   * </ul>
   *
   * <p>Method under test: {@link ElementKey#create(Element, Schema)}
   */
  @Test
  @DisplayName(
      "Test create(Element, Schema) with 'element', 'schema'; when Edge(String) with 'Group'; then return EdgeKey")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ElementKey ElementKey.create(Element, Schema)"})
  void testCreateWithElementSchema_whenEdgeWithGroup_thenReturnEdgeKey() {
    // Arrange
    Edge element = new Edge("Group");

    // Act and Assert
    assertTrue(ElementKey.create(element, new Schema()) instanceof EdgeKey);
  }

  /**
   * Test {@link ElementKey#create(Element, Schema)} with {@code element}, {@code schema}.
   *
   * <ul>
   *   <li>When {@link Entity#Entity(String)} with {@code Group}.
   *   <li>Then return {@link EntityKey}.
   * </ul>
   *
   * <p>Method under test: {@link ElementKey#create(Element, Schema)}
   */
  @Test
  @DisplayName(
      "Test create(Element, Schema) with 'element', 'schema'; when Entity(String) with 'Group'; then return EntityKey")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ElementKey ElementKey.create(Element, Schema)"})
  void testCreateWithElementSchema_whenEntityWithGroup_thenReturnEntityKey() {
    // Arrange
    Entity element = new Entity("Group");

    // Act and Assert
    assertTrue(ElementKey.create(element, new Schema()) instanceof EntityKey);
  }

  /**
   * Test {@link ElementKey#create(Element, Schema)} with {@code element}, {@code schema}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link ElementKey#create(Element, Schema)}
   */
  @Test
  @DisplayName(
      "Test create(Element, Schema) with 'element', 'schema'; when 'null'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ElementKey ElementKey.create(Element, Schema)"})
  void testCreateWithElementSchema_whenNull_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> ElementKey.create(null, new Schema()));
  }
}
