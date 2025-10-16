package uk.gov.gchq.gaffer.mapstore.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.data.element.Edge;
import uk.gov.gchq.gaffer.data.element.Element;
import uk.gov.gchq.gaffer.data.element.Entity;
import uk.gov.gchq.gaffer.data.element.Entity.Builder;
import uk.gov.gchq.gaffer.data.element.GroupedProperties;
import uk.gov.gchq.gaffer.data.element.id.EdgeId;
import uk.gov.gchq.gaffer.data.element.id.EdgeId.MatchedVertex;
import uk.gov.gchq.gaffer.data.element.id.EntityId;
import uk.gov.gchq.gaffer.mapstore.MapStoreProperties;
import uk.gov.gchq.gaffer.operation.data.EdgeSeed;
import uk.gov.gchq.gaffer.operation.data.EntitySeed;
import uk.gov.gchq.gaffer.store.schema.Schema;

class MapImplDiffblueTest {
  /**
   * Test {@link MapImpl#MapImpl(Schema, MapStoreProperties)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link MapImpl#MapImpl(Schema, MapStoreProperties)}
   */
  @Test
  @DisplayName("Test new MapImpl(Schema, MapStoreProperties); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MapImpl.<init>(Schema, MapStoreProperties)"})
  void testNewMapImpl_thenThrowIllegalArgumentException() {
    // Arrange
    Schema schema = new Schema();

    MapStoreProperties mapStoreProperties = new MapStoreProperties();
    mapStoreProperties.set("gaffer.store.mapstore.map.factory", "42");

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> new MapImpl(schema, mapStoreProperties));
  }

  /**
   * Test {@link MapImpl#MapImpl(Schema, MapStoreProperties)}.
   *
   * <ul>
   *   <li>When {@link MapStoreProperties#MapStoreProperties()}.
   *   <li>Then return MaintainIndex.
   * </ul>
   *
   * <p>Method under test: {@link MapImpl#MapImpl(Schema, MapStoreProperties)}
   */
  @Test
  @DisplayName(
      "Test new MapImpl(Schema, MapStoreProperties); when MapStoreProperties(); then return MaintainIndex")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MapImpl.<init>(Schema, MapStoreProperties)"})
  void testNewMapImpl_whenMapStoreProperties_thenReturnMaintainIndex() {
    // Arrange
    Schema schema = new Schema();

    // Act
    MapImpl actualMapImpl = new MapImpl(schema, new MapStoreProperties());

    // Assert
    assertTrue(actualMapImpl.isMaintainIndex());
  }

  /**
   * Test {@link MapImpl#addAggElement(Element, GroupedProperties)}.
   *
   * <ul>
   *   <li>Given {@code Group}.
   *   <li>When {@link Edge} {@link Edge#getGroup()} return {@code Group}.
   *   <li>Then calls {@link Edge#getGroup()}.
   * </ul>
   *
   * <p>Method under test: {@link MapImpl#addAggElement(Element, GroupedProperties)}
   */
  @Test
  @DisplayName(
      "Test addAggElement(Element, GroupedProperties); given 'Group'; when Edge getGroup() return 'Group'; then calls getGroup()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MapImpl.addAggElement(Element, GroupedProperties)"})
  void testAddAggElement_givenGroup_whenEdgeGetGroupReturnGroup_thenCallsGetGroup() {
    // Arrange
    Schema schema = new Schema();
    MapImpl mapImpl = new MapImpl(schema, new MapStoreProperties());

    Edge elementWithGroupByProperties = mock(Edge.class);
    when(elementWithGroupByProperties.getGroup()).thenReturn("Group");

    // Act
    mapImpl.addAggElement(elementWithGroupByProperties, new GroupedProperties());

    // Assert
    verify(elementWithGroupByProperties).getGroup();
  }

  /**
   * Test {@link MapImpl#lookup(EdgeId)} with {@code edgeId}.
   *
   * <p>Method under test: {@link MapImpl#lookup(EdgeId)}
   */
  @Test
  @DisplayName("Test lookup(EdgeId) with 'edgeId'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Collection MapImpl.lookup(EdgeId)"})
  void testLookupWithEdgeId() {
    // Arrange
    Schema schema = new Schema();
    MapImpl mapImpl = new MapImpl(schema, new MapStoreProperties());

    // Act
    Collection<Element> actualLookupResult =
        mapImpl.lookup(
            new Edge.Builder()
                .dest("Dest")
                .directed(true)
                .group("Group")
                .matchedVertex(MatchedVertex.SOURCE)
                .source("Source")
                .build());

    // Assert
    assertTrue(actualLookupResult instanceof Set);
    assertTrue(actualLookupResult.isEmpty());
  }

  /**
   * Test {@link MapImpl#lookup(EdgeId)} with {@code edgeId}.
   *
   * <ul>
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link MapImpl#lookup(EdgeId)}
   */
  @Test
  @DisplayName("Test lookup(EdgeId) with 'edgeId'; then return size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Collection MapImpl.lookup(EdgeId)"})
  void testLookupWithEdgeId_thenReturnSizeIsOne() {
    // Arrange
    Schema schema = new Schema();

    MapImpl mapImpl = new MapImpl(schema, new MapStoreProperties());
    EdgeSeed edgeSeed = new EdgeSeed();
    mapImpl.addIndex(
        edgeSeed,
        new Edge.Builder()
            .dest("Dest")
            .directed(true)
            .group("Group")
            .matchedVertex(MatchedVertex.SOURCE)
            .source("Source")
            .build());

    // Act
    Collection<Element> actualLookupResult = mapImpl.lookup(new EdgeSeed());

    // Assert
    assertTrue(actualLookupResult instanceof Set);
    assertEquals(1, actualLookupResult.size());
  }

  /**
   * Test {@link MapImpl#lookup(EdgeId)} with {@code edgeId}.
   *
   * <ul>
   *   <li>When {@link EdgeSeed#EdgeSeed()}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link MapImpl#lookup(EdgeId)}
   */
  @Test
  @DisplayName("Test lookup(EdgeId) with 'edgeId'; when EdgeSeed(); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Collection MapImpl.lookup(EdgeId)"})
  void testLookupWithEdgeId_whenEdgeSeed_thenReturnEmpty() {
    // Arrange
    Schema schema = new Schema();
    MapImpl mapImpl = new MapImpl(schema, new MapStoreProperties());

    // Act
    Collection<Element> actualLookupResult = mapImpl.lookup(new EdgeSeed());

    // Assert
    assertTrue(actualLookupResult instanceof Set);
    assertTrue(actualLookupResult.isEmpty());
  }

  /**
   * Test {@link MapImpl#lookup(EdgeId)} with {@code edgeId}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link MapImpl#lookup(EdgeId)}
   */
  @Test
  @DisplayName("Test lookup(EdgeId) with 'edgeId'; when 'null'; then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Collection MapImpl.lookup(EdgeId)"})
  void testLookupWithEdgeId_whenNull_thenReturnEmpty() {
    // Arrange
    Schema schema = new Schema();
    MapImpl mapImpl = new MapImpl(schema, new MapStoreProperties());

    // Act
    Collection<Element> actualLookupResult = mapImpl.lookup((EdgeId) null);

    // Assert
    assertTrue(actualLookupResult instanceof Set);
    assertTrue(actualLookupResult.isEmpty());
  }

  /**
   * Test {@link MapImpl#lookup(EntityId)} with {@code entityId}.
   *
   * <ul>
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link MapImpl#lookup(EntityId)}
   */
  @Test
  @DisplayName("Test lookup(EntityId) with 'entityId'; then return size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Collection MapImpl.lookup(EntityId)"})
  void testLookupWithEntityId_thenReturnSizeIsOne() {
    // Arrange
    Schema schema = new Schema();

    MapImpl mapImpl = new MapImpl(schema, new MapStoreProperties());
    EntitySeed entitySeed = new EntitySeed();
    mapImpl.addIndex(
        entitySeed,
        new Edge.Builder()
            .dest("Dest")
            .directed(true)
            .group("Group")
            .matchedVertex(MatchedVertex.SOURCE)
            .source("Source")
            .build());

    // Act
    Collection<Element> actualLookupResult = mapImpl.lookup(new EntitySeed());

    // Assert
    assertTrue(actualLookupResult instanceof Set);
    assertEquals(1, actualLookupResult.size());
  }

  /**
   * Test {@link MapImpl#lookup(EntityId)} with {@code entityId}.
   *
   * <ul>
   *   <li>When {@link Entity.Builder} (default constructor) group {@code Group} vertex {@code
   *       Vertex} build.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link MapImpl#lookup(EntityId)}
   */
  @Test
  @DisplayName(
      "Test lookup(EntityId) with 'entityId'; when Builder (default constructor) group 'Group' vertex 'Vertex' build; then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Collection MapImpl.lookup(EntityId)"})
  void testLookupWithEntityId_whenBuilderGroupGroupVertexVertexBuild_thenReturnEmpty() {
    // Arrange
    Schema schema = new Schema();
    MapImpl mapImpl = new MapImpl(schema, new MapStoreProperties());

    // Act
    Collection<Element> actualLookupResult =
        mapImpl.lookup(new Builder().group("Group").vertex("Vertex").build());

    // Assert
    assertTrue(actualLookupResult instanceof Set);
    assertTrue(actualLookupResult.isEmpty());
  }

  /**
   * Test {@link MapImpl#lookup(EntityId)} with {@code entityId}.
   *
   * <ul>
   *   <li>When {@link EntitySeed#EntitySeed()}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link MapImpl#lookup(EntityId)}
   */
  @Test
  @DisplayName("Test lookup(EntityId) with 'entityId'; when EntitySeed(); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Collection MapImpl.lookup(EntityId)"})
  void testLookupWithEntityId_whenEntitySeed_thenReturnEmpty() {
    // Arrange
    Schema schema = new Schema();
    MapImpl mapImpl = new MapImpl(schema, new MapStoreProperties());

    // Act
    Collection<Element> actualLookupResult = mapImpl.lookup(new EntitySeed());

    // Assert
    assertTrue(actualLookupResult instanceof Set);
    assertTrue(actualLookupResult.isEmpty());
  }

  /**
   * Test {@link MapImpl#lookup(EntityId)} with {@code entityId}.
   *
   * <ul>
   *   <li>When {@link Entity#Entity(String)} with {@code Group}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link MapImpl#lookup(EntityId)}
   */
  @Test
  @DisplayName(
      "Test lookup(EntityId) with 'entityId'; when Entity(String) with 'Group'; then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Collection MapImpl.lookup(EntityId)"})
  void testLookupWithEntityId_whenEntityWithGroup_thenReturnEmpty() {
    // Arrange
    Schema schema = new Schema();
    MapImpl mapImpl = new MapImpl(schema, new MapStoreProperties());

    // Act
    Collection<Element> actualLookupResult = mapImpl.lookup(new Entity("Group"));

    // Assert
    assertTrue(actualLookupResult instanceof Set);
    assertTrue(actualLookupResult.isEmpty());
  }

  /**
   * Test {@link MapImpl#getAllAggElements(Set)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link HashSet#HashSet()} add {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link MapImpl#getAllAggElements(Set)}
   */
  @Test
  @DisplayName("Test getAllAggElements(Set); given '42'; when HashSet() add '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Stream MapImpl.getAllAggElements(Set)"})
  void testGetAllAggElements_given42_whenHashSetAdd42() {
    // Arrange
    Schema schema = new Schema();
    MapImpl mapImpl = new MapImpl(schema, new MapStoreProperties());

    HashSet<String> groups = new HashSet<>();
    groups.add("42");
    groups.add("foo");

    // Act
    Stream<Element> actualAllAggElements = mapImpl.getAllAggElements(groups);

    // Assert
    assertTrue(actualAllAggElements.limit(5).collect(Collectors.toList()).isEmpty());
  }

  /**
   * Test {@link MapImpl#getAllAggElements(Set)}.
   *
   * <ul>
   *   <li>Given {@code foo}.
   *   <li>When {@link HashSet#HashSet()} add {@code foo}.
   * </ul>
   *
   * <p>Method under test: {@link MapImpl#getAllAggElements(Set)}
   */
  @Test
  @DisplayName("Test getAllAggElements(Set); given 'foo'; when HashSet() add 'foo'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Stream MapImpl.getAllAggElements(Set)"})
  void testGetAllAggElements_givenFoo_whenHashSetAddFoo() {
    // Arrange
    Schema schema = new Schema();
    MapImpl mapImpl = new MapImpl(schema, new MapStoreProperties());

    HashSet<String> groups = new HashSet<>();
    groups.add("foo");

    // Act
    Stream<Element> actualAllAggElements = mapImpl.getAllAggElements(groups);

    // Assert
    assertTrue(actualAllAggElements.limit(5).collect(Collectors.toList()).isEmpty());
  }

  /**
   * Test {@link MapImpl#getAllAggElements(Set)}.
   *
   * <ul>
   *   <li>When {@link HashSet#HashSet()}.
   * </ul>
   *
   * <p>Method under test: {@link MapImpl#getAllAggElements(Set)}
   */
  @Test
  @DisplayName("Test getAllAggElements(Set); when HashSet()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Stream MapImpl.getAllAggElements(Set)"})
  void testGetAllAggElements_whenHashSet() {
    // Arrange
    Schema schema = new Schema();
    MapImpl mapImpl = new MapImpl(schema, new MapStoreProperties());

    // Act
    Stream<Element> actualAllAggElements = mapImpl.getAllAggElements(new HashSet<>());

    // Assert
    assertTrue(actualAllAggElements.limit(5).collect(Collectors.toList()).isEmpty());
  }

  /**
   * Test {@link MapImpl#getAllNonAggElements(Set)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link HashSet#HashSet()} add {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link MapImpl#getAllNonAggElements(Set)}
   */
  @Test
  @DisplayName("Test getAllNonAggElements(Set); given '42'; when HashSet() add '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Stream MapImpl.getAllNonAggElements(Set)"})
  void testGetAllNonAggElements_given42_whenHashSetAdd42() {
    // Arrange
    Schema schema = new Schema();
    MapImpl mapImpl = new MapImpl(schema, new MapStoreProperties());

    HashSet<String> groups = new HashSet<>();
    groups.add("42");
    groups.add("foo");

    // Act
    Stream<Element> actualAllNonAggElements = mapImpl.getAllNonAggElements(groups);

    // Assert
    assertTrue(actualAllNonAggElements.limit(5).collect(Collectors.toList()).isEmpty());
  }

  /**
   * Test {@link MapImpl#getAllNonAggElements(Set)}.
   *
   * <ul>
   *   <li>Given {@code foo}.
   *   <li>When {@link HashSet#HashSet()} add {@code foo}.
   * </ul>
   *
   * <p>Method under test: {@link MapImpl#getAllNonAggElements(Set)}
   */
  @Test
  @DisplayName("Test getAllNonAggElements(Set); given 'foo'; when HashSet() add 'foo'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Stream MapImpl.getAllNonAggElements(Set)"})
  void testGetAllNonAggElements_givenFoo_whenHashSetAddFoo() {
    // Arrange
    Schema schema = new Schema();
    MapImpl mapImpl = new MapImpl(schema, new MapStoreProperties());

    HashSet<String> groups = new HashSet<>();
    groups.add("foo");

    // Act
    Stream<Element> actualAllNonAggElements = mapImpl.getAllNonAggElements(groups);

    // Assert
    assertTrue(actualAllNonAggElements.limit(5).collect(Collectors.toList()).isEmpty());
  }

  /**
   * Test {@link MapImpl#getAllNonAggElements(Set)}.
   *
   * <ul>
   *   <li>When {@link HashSet#HashSet()}.
   * </ul>
   *
   * <p>Method under test: {@link MapImpl#getAllNonAggElements(Set)}
   */
  @Test
  @DisplayName("Test getAllNonAggElements(Set); when HashSet()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Stream MapImpl.getAllNonAggElements(Set)"})
  void testGetAllNonAggElements_whenHashSet() {
    // Arrange
    Schema schema = new Schema();
    MapImpl mapImpl = new MapImpl(schema, new MapStoreProperties());

    // Act
    Stream<Element> actualAllNonAggElements = mapImpl.getAllNonAggElements(new HashSet<>());

    // Assert
    assertTrue(actualAllNonAggElements.limit(5).collect(Collectors.toList()).isEmpty());
  }

  /**
   * Test {@link MapImpl#getAllElements(Set)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link HashSet#HashSet()} add {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link MapImpl#getAllElements(Set)}
   */
  @Test
  @DisplayName("Test getAllElements(Set); given '42'; when HashSet() add '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Stream MapImpl.getAllElements(Set)"})
  void testGetAllElements_given42_whenHashSetAdd42() {
    // Arrange
    Schema schema = new Schema();
    MapImpl mapImpl = new MapImpl(schema, new MapStoreProperties());

    HashSet<String> groups = new HashSet<>();
    groups.add("42");
    groups.add("foo");

    // Act
    Stream<Element> actualAllElements = mapImpl.getAllElements(groups);

    // Assert
    assertTrue(actualAllElements.limit(5).collect(Collectors.toList()).isEmpty());
  }

  /**
   * Test {@link MapImpl#getAllElements(Set)}.
   *
   * <ul>
   *   <li>Given {@code foo}.
   *   <li>When {@link HashSet#HashSet()} add {@code foo}.
   * </ul>
   *
   * <p>Method under test: {@link MapImpl#getAllElements(Set)}
   */
  @Test
  @DisplayName("Test getAllElements(Set); given 'foo'; when HashSet() add 'foo'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Stream MapImpl.getAllElements(Set)"})
  void testGetAllElements_givenFoo_whenHashSetAddFoo() {
    // Arrange
    Schema schema = new Schema();
    MapImpl mapImpl = new MapImpl(schema, new MapStoreProperties());

    HashSet<String> groups = new HashSet<>();
    groups.add("foo");

    // Act
    Stream<Element> actualAllElements = mapImpl.getAllElements(groups);

    // Assert
    assertTrue(actualAllElements.limit(5).collect(Collectors.toList()).isEmpty());
  }

  /**
   * Test {@link MapImpl#getAllElements(Set)}.
   *
   * <ul>
   *   <li>When {@link HashSet#HashSet()}.
   * </ul>
   *
   * <p>Method under test: {@link MapImpl#getAllElements(Set)}
   */
  @Test
  @DisplayName("Test getAllElements(Set); when HashSet()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Stream MapImpl.getAllElements(Set)"})
  void testGetAllElements_whenHashSet() {
    // Arrange
    Schema schema = new Schema();
    MapImpl mapImpl = new MapImpl(schema, new MapStoreProperties());

    // Act
    Stream<Element> actualAllElements = mapImpl.getAllElements(new HashSet<>());

    // Assert
    assertTrue(actualAllElements.limit(5).collect(Collectors.toList()).isEmpty());
  }

  /**
   * Test {@link MapImpl#isMaintainIndex()}.
   *
   * <p>Method under test: {@link MapImpl#isMaintainIndex()}
   */
  @Test
  @DisplayName("Test isMaintainIndex()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MapImpl.isMaintainIndex()"})
  void testIsMaintainIndex() {
    // Arrange
    Schema schema = new Schema();
    MapImpl mapImpl = new MapImpl(schema, new MapStoreProperties());

    // Act and Assert
    assertTrue(mapImpl.isMaintainIndex());
  }

  /**
   * Test {@link MapImpl#cloneElement(Element, Schema)}.
   *
   * <ul>
   *   <li>When {@link Entity.Builder} (default constructor) group {@code Group} vertex {@code
   *       Vertex} build.
   *   <li>Then return {@link Entity}.
   * </ul>
   *
   * <p>Method under test: {@link MapImpl#cloneElement(Element, Schema)}
   */
  @Test
  @DisplayName(
      "Test cloneElement(Element, Schema); when Builder (default constructor) group 'Group' vertex 'Vertex' build; then return Entity")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Element MapImpl.cloneElement(Element, Schema)"})
  void testCloneElement_whenBuilderGroupGroupVertexVertexBuild_thenReturnEntity() {
    // Arrange
    Schema schema = new Schema();
    MapImpl mapImpl = new MapImpl(schema, new MapStoreProperties());
    Entity element = new Builder().group("Group").vertex("Vertex").build();

    // Act
    Element actualCloneElementResult = mapImpl.cloneElement(element, new Schema());

    // Assert
    assertTrue(actualCloneElementResult instanceof Entity);
    assertEquals(element, actualCloneElementResult);
  }

  /**
   * Test {@link MapImpl#cloneElement(Element, Schema)}.
   *
   * <ul>
   *   <li>When {@link Edge#Edge(String)} with {@code Group}.
   *   <li>Then return {@link Edge}.
   * </ul>
   *
   * <p>Method under test: {@link MapImpl#cloneElement(Element, Schema)}
   */
  @Test
  @DisplayName(
      "Test cloneElement(Element, Schema); when Edge(String) with 'Group'; then return Edge")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Element MapImpl.cloneElement(Element, Schema)"})
  void testCloneElement_whenEdgeWithGroup_thenReturnEdge() {
    // Arrange
    Schema schema = new Schema();
    MapImpl mapImpl = new MapImpl(schema, new MapStoreProperties());
    Edge element = new Edge("Group");

    // Act
    Element actualCloneElementResult = mapImpl.cloneElement(element, new Schema());

    // Assert
    assertTrue(actualCloneElementResult instanceof Edge);
    assertEquals(element, actualCloneElementResult);
  }

  /**
   * Test {@link MapImpl#getGroupByProperties(String)}.
   *
   * <p>Method under test: {@link MapImpl#getGroupByProperties(String)}
   */
  @Test
  @DisplayName("Test getGroupByProperties(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set MapImpl.getGroupByProperties(String)"})
  void testGetGroupByProperties() {
    // Arrange
    Schema schema = new Schema();
    MapImpl mapImpl = new MapImpl(schema, new MapStoreProperties());

    // Act and Assert
    assertNull(mapImpl.getGroupByProperties("Group"));
  }

  /**
   * Test {@link MapImpl#getNonGroupByProperties(String)}.
   *
   * <p>Method under test: {@link MapImpl#getNonGroupByProperties(String)}
   */
  @Test
  @DisplayName("Test getNonGroupByProperties(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set MapImpl.getNonGroupByProperties(String)"})
  void testGetNonGroupByProperties() {
    // Arrange
    Schema schema = new Schema();
    MapImpl mapImpl = new MapImpl(schema, new MapStoreProperties());

    // Act and Assert
    assertNull(mapImpl.getNonGroupByProperties("Group"));
  }

  /**
   * Test {@link MapImpl#isAggregationEnabled(Element)}.
   *
   * <ul>
   *   <li>When {@link Edge#Edge(String)} with {@code Group}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link MapImpl#isAggregationEnabled(Element)}
   */
  @Test
  @DisplayName(
      "Test isAggregationEnabled(Element); when Edge(String) with 'Group'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MapImpl.isAggregationEnabled(Element)"})
  void testIsAggregationEnabled_whenEdgeWithGroup_thenReturnTrue() {
    // Arrange
    Schema schema = new Schema();
    MapImpl mapImpl = new MapImpl(schema, new MapStoreProperties());

    // Act
    boolean actualIsAggregationEnabledResult = mapImpl.isAggregationEnabled(new Edge("Group"));

    // Assert
    assertTrue(actualIsAggregationEnabledResult);
  }

  /**
   * Test {@link MapImpl#countAggElements()}.
   *
   * <p>Method under test: {@link MapImpl#countAggElements()}
   */
  @Test
  @DisplayName("Test countAggElements()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long MapImpl.countAggElements()"})
  void testCountAggElements() {
    // Arrange
    Schema schema = new Schema();
    MapImpl mapImpl = new MapImpl(schema, new MapStoreProperties());

    // Act and Assert
    assertEquals(0L, mapImpl.countAggElements());
  }

  /**
   * Test {@link MapImpl#countNonAggElements()}.
   *
   * <p>Method under test: {@link MapImpl#countNonAggElements()}
   */
  @Test
  @DisplayName("Test countNonAggElements()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long MapImpl.countNonAggElements()"})
  void testCountNonAggElements() {
    // Arrange
    Schema schema = new Schema();
    MapImpl mapImpl = new MapImpl(schema, new MapStoreProperties());

    // Act and Assert
    assertEquals(0L, mapImpl.countNonAggElements());
  }
}
