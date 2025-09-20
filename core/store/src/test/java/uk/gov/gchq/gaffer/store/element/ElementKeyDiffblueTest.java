package uk.gov.gchq.gaffer.store.element;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
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
   *   <li>Then return {@link EntityKey}.
   * </ul>
   *
   * <p>Method under test: {@link ElementKey#create(Element, SchemaElementDefinition)}
   */
  @Test
  @DisplayName(
      "Test create(Element, SchemaElementDefinition) with 'element', 'elementDef'; then return EntityKey")
  @Tag("MaintainedByDiffblue")
  void testCreateWithElementElementDef_thenReturnEntityKey() {
    // Arrange
    Entity element = new Builder().group("Group").vertex("Vertex").build();

    // Act and Assert
    assertTrue(ElementKey.create(element, new SchemaEdgeDefinition()) instanceof EntityKey);
  }

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
  @Tag("MaintainedByDiffblue")
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
   *   <li>When {@link Edge#Edge(String)} with {@code Group}.
   *   <li>Then return {@link EdgeKey}.
   * </ul>
   *
   * <p>Method under test: {@link ElementKey#create(Element, SchemaElementDefinition)}
   */
  @Test
  @DisplayName(
      "Test create(Element, SchemaElementDefinition) with 'element', 'elementDef'; when Edge(String) with 'Group'; then return EdgeKey")
  @Tag("MaintainedByDiffblue")
  void testCreateWithElementElementDef_whenEdgeWithGroup_thenReturnEdgeKey2() {
    // Arrange, Act and Assert
    assertTrue(
        ElementKey.create(new Edge("Group"), (SchemaElementDefinition) null) instanceof EdgeKey);
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
  @Tag("MaintainedByDiffblue")
  void testCreateWithElementElementDef_whenNull_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> ElementKey.create(null, (SchemaElementDefinition) null));
  }

  /**
   * Test {@link ElementKey#create(Element, Set)} with {@code element}, {@code groupBy}.
   *
   * <p>Method under test: {@link ElementKey#create(Element, Set)}
   */
  @Test
  @DisplayName("Test create(Element, Set) with 'element', 'groupBy'")
  @Tag("MaintainedByDiffblue")
  void testCreateWithElementGroupBy() {
    // Arrange
    ElementValueLoader valueLoader = mock(ElementValueLoader.class);
    when(valueLoader.getProperty(Mockito.<String>any(), Mockito.<Properties>any()))
        .thenReturn("Property");
    Edge edge =
        new Edge.Builder()
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
  @Tag("MaintainedByDiffblue")
  void testCreateWithElementGroupBy2() {
    // Arrange
    ElementValueLoader valueLoader = mock(ElementValueLoader.class);
    when(valueLoader.getProperty(Mockito.<String>any(), Mockito.<Properties>any()))
        .thenReturn(null);
    Edge edge =
        new Edge.Builder()
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
   *   <li>Given empty string.
   *   <li>When {@link HashSet#HashSet()} add empty string.
   * </ul>
   *
   * <p>Method under test: {@link ElementKey#create(Element, Set)}
   */
  @Test
  @DisplayName(
      "Test create(Element, Set) with 'element', 'groupBy'; given empty string; when HashSet() add empty string")
  @Tag("MaintainedByDiffblue")
  void testCreateWithElementGroupBy_givenEmptyString_whenHashSetAddEmptyString() {
    // Arrange
    Edge element = new Edge("Group");

    HashSet<String> groupBy = new HashSet<>();
    groupBy.add("");
    groupBy.add("foo");

    // Act and Assert
    assertTrue(ElementKey.create(element, groupBy) instanceof EdgeKey);
  }

  /**
   * Test {@link ElementKey#create(Element, Set)} with {@code element}, {@code groupBy}.
   *
   * <ul>
   *   <li>Given {@code Group By}.
   *   <li>When {@link Edge#Edge(String)} with {@code Group}.
   *   <li>Then return {@link EdgeKey}.
   * </ul>
   *
   * <p>Method under test: {@link ElementKey#create(Element, Set)}
   */
  @Test
  @DisplayName(
      "Test create(Element, Set) with 'element', 'groupBy'; given 'Group By'; when Edge(String) with 'Group'; then return EdgeKey")
  @Tag("MaintainedByDiffblue")
  void testCreateWithElementGroupBy_givenGroupBy_whenEdgeWithGroup_thenReturnEdgeKey() {
    // Arrange
    Edge element = new Edge("Group");

    LinkedHashSet<String> groupBy = new LinkedHashSet<>();
    groupBy.add("Group By");

    // Act and Assert
    assertTrue(ElementKey.create(element, groupBy) instanceof EdgeKey);
  }

  /**
   * Test {@link ElementKey#create(Element, Set)} with {@code element}, {@code groupBy}.
   *
   * <ul>
   *   <li>Then return {@link EntityKey}.
   * </ul>
   *
   * <p>Method under test: {@link ElementKey#create(Element, Set)}
   */
  @Test
  @DisplayName("Test create(Element, Set) with 'element', 'groupBy'; then return EntityKey")
  @Tag("MaintainedByDiffblue")
  void testCreateWithElementGroupBy_thenReturnEntityKey() {
    // Arrange
    Entity element = new Builder().group("Group").vertex("Vertex").build();

    // Act and Assert
    assertTrue(ElementKey.create(element, new HashSet<>()) instanceof EntityKey);
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
  @Tag("MaintainedByDiffblue")
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
   *   <li>Then return {@link EdgeKey}.
   * </ul>
   *
   * <p>Method under test: {@link ElementKey#create(Element, Set)}
   */
  @Test
  @DisplayName(
      "Test create(Element, Set) with 'element', 'groupBy'; when 'null'; then return EdgeKey")
  @Tag("MaintainedByDiffblue")
  void testCreateWithElementGroupBy_whenNull_thenReturnEdgeKey() {
    // Arrange, Act and Assert
    assertTrue(ElementKey.create(new Edge("Group"), (Set<String>) null) instanceof EdgeKey);
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
  @Tag("MaintainedByDiffblue")
  void testCreateWithElementGroupBy_whenNull_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> ElementKey.create(null, (Set<String>) null));
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
  @Tag("MaintainedByDiffblue")
  void testCreateWithElementGroupBy_whenNull_thenThrowIllegalArgumentException2() {
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
   *   <li>Then return {@link EntityKey}.
   * </ul>
   *
   * <p>Method under test: {@link ElementKey#create(Element, Schema)}
   */
  @Test
  @DisplayName("Test create(Element, Schema) with 'element', 'schema'; then return EntityKey")
  @Tag("MaintainedByDiffblue")
  void testCreateWithElementSchema_thenReturnEntityKey() {
    // Arrange
    Entity element = new Builder().group("Group").vertex("Vertex").build();

    // Act and Assert
    assertTrue(ElementKey.create(element, new Schema()) instanceof EntityKey);
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
  @Tag("MaintainedByDiffblue")
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
   *   <li>When {@code null}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link ElementKey#create(Element, Schema)}
   */
  @Test
  @DisplayName(
      "Test create(Element, Schema) with 'element', 'schema'; when 'null'; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  void testCreateWithElementSchema_whenNull_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> ElementKey.create(null, (Schema) null));
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
  @Tag("MaintainedByDiffblue")
  void testCreateWithElementSchema_whenNull_thenThrowIllegalArgumentException2() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> ElementKey.create(null, new Schema()));
  }
}
