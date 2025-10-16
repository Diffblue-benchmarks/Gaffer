package uk.gov.gchq.gaffer.mapstore.impl;

import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.data.element.Edge;
import uk.gov.gchq.gaffer.data.element.Edge.Builder;
import uk.gov.gchq.gaffer.data.element.Element;
import uk.gov.gchq.gaffer.data.element.Entity;
import uk.gov.gchq.gaffer.data.element.id.DirectedType;
import uk.gov.gchq.gaffer.data.element.id.EdgeId;
import uk.gov.gchq.gaffer.data.element.id.EdgeId.MatchedVertex;
import uk.gov.gchq.gaffer.data.element.id.ElementId;
import uk.gov.gchq.gaffer.data.elementdefinition.view.View;
import uk.gov.gchq.gaffer.mapstore.MapStoreProperties;
import uk.gov.gchq.gaffer.operation.data.EdgeSeed;
import uk.gov.gchq.gaffer.operation.data.EntitySeed;
import uk.gov.gchq.gaffer.operation.graph.SeededGraphFilters;
import uk.gov.gchq.gaffer.operation.graph.SeededGraphFilters.IncludeIncomingOutgoingType;
import uk.gov.gchq.gaffer.store.schema.Schema;
import uk.gov.gchq.gaffer.user.User;

class GetElementsUtilDiffblueTest {
  /**
   * Test {@link GetElementsUtil#getRelevantElements(MapImpl, ElementId, View, DirectedType,
   * IncludeIncomingOutgoingType)} with {@code mapImpl}, {@code elementId}, {@code view}, {@code
   * directedType}, {@code inOutType}.
   *
   * <p>Method under test: {@link GetElementsUtil#getRelevantElements(MapImpl, ElementId, View,
   * DirectedType, IncludeIncomingOutgoingType)}
   */
  @Test
  @DisplayName(
      "Test getRelevantElements(MapImpl, ElementId, View, DirectedType, IncludeIncomingOutgoingType) with 'mapImpl', 'elementId', 'view', 'directedType', 'inOutType'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set GetElementsUtil.getRelevantElements(MapImpl, ElementId, View, DirectedType, IncludeIncomingOutgoingType)"
  })
  void testGetRelevantElementsWithMapImplElementIdViewDirectedTypeInOutType() {
    // Arrange
    Schema schema = new Schema();
    MapImpl mapImpl = new MapImpl(schema, new MapStoreProperties());
    EdgeSeed elementId = new EdgeSeed();

    // Act
    Set<Element> actualRelevantElements =
        GetElementsUtil.getRelevantElements(
            mapImpl,
            elementId,
            new View(),
            DirectedType.EITHER,
            IncludeIncomingOutgoingType.EITHER);

    // Assert
    assertTrue(actualRelevantElements.isEmpty());
  }

  /**
   * Test {@link GetElementsUtil#getRelevantElements(MapImpl, ElementId, View, DirectedType,
   * IncludeIncomingOutgoingType)} with {@code mapImpl}, {@code elementId}, {@code view}, {@code
   * directedType}, {@code inOutType}.
   *
   * <p>Method under test: {@link GetElementsUtil#getRelevantElements(MapImpl, ElementId, View,
   * DirectedType, IncludeIncomingOutgoingType)}
   */
  @Test
  @DisplayName(
      "Test getRelevantElements(MapImpl, ElementId, View, DirectedType, IncludeIncomingOutgoingType) with 'mapImpl', 'elementId', 'view', 'directedType', 'inOutType'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set GetElementsUtil.getRelevantElements(MapImpl, ElementId, View, DirectedType, IncludeIncomingOutgoingType)"
  })
  void testGetRelevantElementsWithMapImplElementIdViewDirectedTypeInOutType2() {
    // Arrange
    Schema schema = new Schema();
    MapImpl mapImpl = new MapImpl(schema, new MapStoreProperties());
    Edge elementId =
        new Builder()
            .dest("Dest")
            .directed(true)
            .group("Group")
            .matchedVertex(MatchedVertex.SOURCE)
            .source("Source")
            .build();

    // Act
    Set<Element> actualRelevantElements =
        GetElementsUtil.getRelevantElements(
            mapImpl,
            elementId,
            new View(),
            DirectedType.EITHER,
            IncludeIncomingOutgoingType.EITHER);

    // Assert
    assertTrue(actualRelevantElements.isEmpty());
  }

  /**
   * Test {@link GetElementsUtil#getRelevantElements(MapImpl, ElementId, View, DirectedType,
   * IncludeIncomingOutgoingType)} with {@code mapImpl}, {@code elementId}, {@code view}, {@code
   * directedType}, {@code inOutType}.
   *
   * <p>Method under test: {@link GetElementsUtil#getRelevantElements(MapImpl, ElementId, View,
   * DirectedType, IncludeIncomingOutgoingType)}
   */
  @Test
  @DisplayName(
      "Test getRelevantElements(MapImpl, ElementId, View, DirectedType, IncludeIncomingOutgoingType) with 'mapImpl', 'elementId', 'view', 'directedType', 'inOutType'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set GetElementsUtil.getRelevantElements(MapImpl, ElementId, View, DirectedType, IncludeIncomingOutgoingType)"
  })
  void testGetRelevantElementsWithMapImplElementIdViewDirectedTypeInOutType3() {
    // Arrange
    Schema schema = new Schema();
    MapImpl mapImpl = new MapImpl(schema, new MapStoreProperties());
    EntitySeed elementId = new EntitySeed();

    // Act
    Set<Element> actualRelevantElements =
        GetElementsUtil.getRelevantElements(
            mapImpl,
            elementId,
            new View(),
            DirectedType.DIRECTED,
            IncludeIncomingOutgoingType.INCOMING);

    // Assert
    assertTrue(actualRelevantElements.isEmpty());
  }

  /**
   * Test {@link GetElementsUtil#getRelevantElements(MapImpl, ElementId, View, DirectedType,
   * IncludeIncomingOutgoingType)} with {@code mapImpl}, {@code elementId}, {@code view}, {@code
   * directedType}, {@code inOutType}.
   *
   * <p>Method under test: {@link GetElementsUtil#getRelevantElements(MapImpl, ElementId, View,
   * DirectedType, IncludeIncomingOutgoingType)}
   */
  @Test
  @DisplayName(
      "Test getRelevantElements(MapImpl, ElementId, View, DirectedType, IncludeIncomingOutgoingType) with 'mapImpl', 'elementId', 'view', 'directedType', 'inOutType'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set GetElementsUtil.getRelevantElements(MapImpl, ElementId, View, DirectedType, IncludeIncomingOutgoingType)"
  })
  void testGetRelevantElementsWithMapImplElementIdViewDirectedTypeInOutType4() {
    // Arrange
    Schema schema = new Schema();
    MapImpl mapImpl = new MapImpl(schema, new MapStoreProperties());
    EdgeSeed elementId = new EdgeSeed();

    // Act
    Set<Element> actualRelevantElements =
        GetElementsUtil.getRelevantElements(
            mapImpl,
            elementId,
            new View(),
            DirectedType.DIRECTED,
            IncludeIncomingOutgoingType.INCOMING);

    // Assert
    assertTrue(actualRelevantElements.isEmpty());
  }

  /**
   * Test {@link GetElementsUtil#getRelevantElements(MapImpl, ElementId, View, DirectedType,
   * IncludeIncomingOutgoingType)} with {@code mapImpl}, {@code elementId}, {@code view}, {@code
   * directedType}, {@code inOutType}.
   *
   * <p>Method under test: {@link GetElementsUtil#getRelevantElements(MapImpl, ElementId, View,
   * DirectedType, IncludeIncomingOutgoingType)}
   */
  @Test
  @DisplayName(
      "Test getRelevantElements(MapImpl, ElementId, View, DirectedType, IncludeIncomingOutgoingType) with 'mapImpl', 'elementId', 'view', 'directedType', 'inOutType'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set GetElementsUtil.getRelevantElements(MapImpl, ElementId, View, DirectedType, IncludeIncomingOutgoingType)"
  })
  void testGetRelevantElementsWithMapImplElementIdViewDirectedTypeInOutType5() {
    // Arrange
    Schema schema = new Schema();
    MapImpl mapImpl = new MapImpl(schema, new MapStoreProperties());
    EdgeSeed elementId = new EdgeSeed();

    // Act
    Set<Element> actualRelevantElements =
        GetElementsUtil.getRelevantElements(
            mapImpl,
            elementId,
            new View(),
            DirectedType.UNDIRECTED,
            IncludeIncomingOutgoingType.INCOMING);

    // Assert
    assertTrue(actualRelevantElements.isEmpty());
  }

  /**
   * Test {@link GetElementsUtil#getRelevantElements(MapImpl, ElementId, View, DirectedType,
   * IncludeIncomingOutgoingType)} with {@code mapImpl}, {@code elementId}, {@code view}, {@code
   * directedType}, {@code inOutType}.
   *
   * <p>Method under test: {@link GetElementsUtil#getRelevantElements(MapImpl, ElementId, View,
   * DirectedType, IncludeIncomingOutgoingType)}
   */
  @Test
  @DisplayName(
      "Test getRelevantElements(MapImpl, ElementId, View, DirectedType, IncludeIncomingOutgoingType) with 'mapImpl', 'elementId', 'view', 'directedType', 'inOutType'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set GetElementsUtil.getRelevantElements(MapImpl, ElementId, View, DirectedType, IncludeIncomingOutgoingType)"
  })
  void testGetRelevantElementsWithMapImplElementIdViewDirectedTypeInOutType6() {
    // Arrange
    Schema schema = new Schema();

    MapImpl mapImpl = new MapImpl(schema, new MapStoreProperties());
    EntitySeed entitySeed = new EntitySeed();
    mapImpl.addIndex(
        entitySeed,
        new Builder()
            .dest("Dest")
            .directed(true)
            .group("Group")
            .matchedVertex(MatchedVertex.SOURCE)
            .source("Source")
            .build());
    EdgeSeed elementId = new EdgeSeed();

    // Act
    Set<Element> actualRelevantElements =
        GetElementsUtil.getRelevantElements(
            mapImpl,
            elementId,
            new View(),
            DirectedType.EITHER,
            IncludeIncomingOutgoingType.EITHER);

    // Assert
    assertTrue(actualRelevantElements.isEmpty());
  }

  /**
   * Test {@link GetElementsUtil#getRelevantElements(MapImpl, ElementId, View, DirectedType,
   * IncludeIncomingOutgoingType)} with {@code mapImpl}, {@code elementId}, {@code view}, {@code
   * directedType}, {@code inOutType}.
   *
   * <p>Method under test: {@link GetElementsUtil#getRelevantElements(MapImpl, ElementId, View,
   * DirectedType, IncludeIncomingOutgoingType)}
   */
  @Test
  @DisplayName(
      "Test getRelevantElements(MapImpl, ElementId, View, DirectedType, IncludeIncomingOutgoingType) with 'mapImpl', 'elementId', 'view', 'directedType', 'inOutType'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set GetElementsUtil.getRelevantElements(MapImpl, ElementId, View, DirectedType, IncludeIncomingOutgoingType)"
  })
  void testGetRelevantElementsWithMapImplElementIdViewDirectedTypeInOutType7() {
    // Arrange
    Schema schema = new Schema();
    MapImpl mapImpl = new MapImpl(schema, new MapStoreProperties());
    EdgeSeed elementId = new EdgeSeed("Source", "Destination");

    // Act
    Set<Element> actualRelevantElements =
        GetElementsUtil.getRelevantElements(
            mapImpl,
            elementId,
            new View(),
            DirectedType.EITHER,
            IncludeIncomingOutgoingType.EITHER);

    // Assert
    assertTrue(actualRelevantElements.isEmpty());
  }

  /**
   * Test {@link GetElementsUtil#getRelevantElements(MapImpl, ElementId, View, DirectedType,
   * IncludeIncomingOutgoingType)} with {@code mapImpl}, {@code elementId}, {@code view}, {@code
   * directedType}, {@code inOutType}.
   *
   * <p>Method under test: {@link GetElementsUtil#getRelevantElements(MapImpl, ElementId, View,
   * DirectedType, IncludeIncomingOutgoingType)}
   */
  @Test
  @DisplayName(
      "Test getRelevantElements(MapImpl, ElementId, View, DirectedType, IncludeIncomingOutgoingType) with 'mapImpl', 'elementId', 'view', 'directedType', 'inOutType'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set GetElementsUtil.getRelevantElements(MapImpl, ElementId, View, DirectedType, IncludeIncomingOutgoingType)"
  })
  void testGetRelevantElementsWithMapImplElementIdViewDirectedTypeInOutType8() {
    // Arrange
    Schema schema = new Schema();

    MapImpl mapImpl = new MapImpl(schema, new MapStoreProperties());
    EntitySeed entitySeed = new EntitySeed();
    mapImpl.addIndex(
        entitySeed,
        new Builder()
            .dest("Dest")
            .directed(true)
            .group("Group")
            .matchedVertex(MatchedVertex.SOURCE)
            .source("Source")
            .build());
    Entity elementId = new Entity("Group");

    // Act
    Set<Element> actualRelevantElements =
        GetElementsUtil.getRelevantElements(
            mapImpl,
            elementId,
            new View(),
            DirectedType.EITHER,
            IncludeIncomingOutgoingType.EITHER);

    // Assert
    assertTrue(actualRelevantElements.isEmpty());
  }

  /**
   * Test {@link GetElementsUtil#getRelevantElements(MapImpl, ElementId, View, DirectedType,
   * IncludeIncomingOutgoingType)} with {@code mapImpl}, {@code elementId}, {@code view}, {@code
   * directedType}, {@code inOutType}.
   *
   * <p>Method under test: {@link GetElementsUtil#getRelevantElements(MapImpl, ElementId, View,
   * DirectedType, IncludeIncomingOutgoingType)}
   */
  @Test
  @DisplayName(
      "Test getRelevantElements(MapImpl, ElementId, View, DirectedType, IncludeIncomingOutgoingType) with 'mapImpl', 'elementId', 'view', 'directedType', 'inOutType'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set GetElementsUtil.getRelevantElements(MapImpl, ElementId, View, DirectedType, IncludeIncomingOutgoingType)"
  })
  void testGetRelevantElementsWithMapImplElementIdViewDirectedTypeInOutType9() {
    // Arrange
    Schema schema = new Schema();
    MapImpl mapImpl = new MapImpl(schema, new MapStoreProperties());
    Entity entity = new Entity.Builder().group("Group").vertex("Vertex").build();
    EdgeSeed elementId = new EdgeSeed(entity, "Destination");

    // Act
    Set<Element> actualRelevantElements =
        GetElementsUtil.getRelevantElements(
            mapImpl,
            elementId,
            new View(),
            DirectedType.EITHER,
            IncludeIncomingOutgoingType.EITHER);

    // Assert
    assertTrue(actualRelevantElements.isEmpty());
  }

  /**
   * Test {@link GetElementsUtil#getRelevantElements(MapImpl, ElementId, View, DirectedType,
   * IncludeIncomingOutgoingType)} with {@code mapImpl}, {@code elementId}, {@code view}, {@code
   * directedType}, {@code inOutType}.
   *
   * <p>Method under test: {@link GetElementsUtil#getRelevantElements(MapImpl, ElementId, View,
   * DirectedType, IncludeIncomingOutgoingType)}
   */
  @Test
  @DisplayName(
      "Test getRelevantElements(MapImpl, ElementId, View, DirectedType, IncludeIncomingOutgoingType) with 'mapImpl', 'elementId', 'view', 'directedType', 'inOutType'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set GetElementsUtil.getRelevantElements(MapImpl, ElementId, View, DirectedType, IncludeIncomingOutgoingType)"
  })
  void testGetRelevantElementsWithMapImplElementIdViewDirectedTypeInOutType10() {
    // Arrange
    Schema schema = new Schema();
    MapImpl mapImpl = new MapImpl(schema, new MapStoreProperties());
    Edge edge =
        new Builder()
            .dest("Dest")
            .directed(true)
            .group("Group")
            .matchedVertex(MatchedVertex.SOURCE)
            .source("Source")
            .build();
    EdgeSeed elementId = new EdgeSeed(edge, "Destination");

    // Act
    Set<Element> actualRelevantElements =
        GetElementsUtil.getRelevantElements(
            mapImpl,
            elementId,
            new View(),
            DirectedType.EITHER,
            IncludeIncomingOutgoingType.EITHER);

    // Assert
    assertTrue(actualRelevantElements.isEmpty());
  }

  /**
   * Test {@link GetElementsUtil#getRelevantElements(MapImpl, ElementId, View, DirectedType,
   * IncludeIncomingOutgoingType)} with {@code mapImpl}, {@code elementId}, {@code view}, {@code
   * directedType}, {@code inOutType}.
   *
   * <p>Method under test: {@link GetElementsUtil#getRelevantElements(MapImpl, ElementId, View,
   * DirectedType, IncludeIncomingOutgoingType)}
   */
  @Test
  @DisplayName(
      "Test getRelevantElements(MapImpl, ElementId, View, DirectedType, IncludeIncomingOutgoingType) with 'mapImpl', 'elementId', 'view', 'directedType', 'inOutType'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set GetElementsUtil.getRelevantElements(MapImpl, ElementId, View, DirectedType, IncludeIncomingOutgoingType)"
  })
  void testGetRelevantElementsWithMapImplElementIdViewDirectedTypeInOutType11() {
    // Arrange
    Schema schema = new Schema();
    MapImpl mapImpl = new MapImpl(schema, new MapStoreProperties());
    EdgeSeed elementId = new EdgeSeed(new Edge("Group"), "Destination");

    // Act
    Set<Element> actualRelevantElements =
        GetElementsUtil.getRelevantElements(
            mapImpl,
            elementId,
            new View(),
            DirectedType.EITHER,
            IncludeIncomingOutgoingType.EITHER);

    // Assert
    assertTrue(actualRelevantElements.isEmpty());
  }

  /**
   * Test {@link GetElementsUtil#getRelevantElements(MapImpl, ElementId, View, DirectedType,
   * IncludeIncomingOutgoingType)} with {@code mapImpl}, {@code elementId}, {@code view}, {@code
   * directedType}, {@code inOutType}.
   *
   * <p>Method under test: {@link GetElementsUtil#getRelevantElements(MapImpl, ElementId, View,
   * DirectedType, IncludeIncomingOutgoingType)}
   */
  @Test
  @DisplayName(
      "Test getRelevantElements(MapImpl, ElementId, View, DirectedType, IncludeIncomingOutgoingType) with 'mapImpl', 'elementId', 'view', 'directedType', 'inOutType'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set GetElementsUtil.getRelevantElements(MapImpl, ElementId, View, DirectedType, IncludeIncomingOutgoingType)"
  })
  void testGetRelevantElementsWithMapImplElementIdViewDirectedTypeInOutType12() {
    // Arrange
    Schema schema = new Schema();
    MapImpl mapImpl = new MapImpl(schema, new MapStoreProperties());
    EdgeSeed elementId = new EdgeSeed(new EntitySeed(), "Destination");

    // Act
    Set<Element> actualRelevantElements =
        GetElementsUtil.getRelevantElements(
            mapImpl,
            elementId,
            new View(),
            DirectedType.EITHER,
            IncludeIncomingOutgoingType.EITHER);

    // Assert
    assertTrue(actualRelevantElements.isEmpty());
  }

  /**
   * Test {@link GetElementsUtil#getRelevantElements(MapImpl, ElementId, View, DirectedType,
   * IncludeIncomingOutgoingType)} with {@code mapImpl}, {@code elementId}, {@code view}, {@code
   * directedType}, {@code inOutType}.
   *
   * <p>Method under test: {@link GetElementsUtil#getRelevantElements(MapImpl, ElementId, View,
   * DirectedType, IncludeIncomingOutgoingType)}
   */
  @Test
  @DisplayName(
      "Test getRelevantElements(MapImpl, ElementId, View, DirectedType, IncludeIncomingOutgoingType) with 'mapImpl', 'elementId', 'view', 'directedType', 'inOutType'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set GetElementsUtil.getRelevantElements(MapImpl, ElementId, View, DirectedType, IncludeIncomingOutgoingType)"
  })
  void testGetRelevantElementsWithMapImplElementIdViewDirectedTypeInOutType13() {
    // Arrange
    Schema schema = new Schema();
    MapImpl mapImpl = new MapImpl(schema, new MapStoreProperties());
    EdgeSeed elementId = new EdgeSeed(new EdgeSeed(), "Destination");

    // Act
    Set<Element> actualRelevantElements =
        GetElementsUtil.getRelevantElements(
            mapImpl,
            elementId,
            new View(),
            DirectedType.EITHER,
            IncludeIncomingOutgoingType.EITHER);

    // Assert
    assertTrue(actualRelevantElements.isEmpty());
  }

  /**
   * Test {@link GetElementsUtil#getRelevantElements(MapImpl, ElementId, View, DirectedType,
   * IncludeIncomingOutgoingType)} with {@code mapImpl}, {@code elementId}, {@code view}, {@code
   * directedType}, {@code inOutType}.
   *
   * <p>Method under test: {@link GetElementsUtil#getRelevantElements(MapImpl, ElementId, View,
   * DirectedType, IncludeIncomingOutgoingType)}
   */
  @Test
  @DisplayName(
      "Test getRelevantElements(MapImpl, ElementId, View, DirectedType, IncludeIncomingOutgoingType) with 'mapImpl', 'elementId', 'view', 'directedType', 'inOutType'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set GetElementsUtil.getRelevantElements(MapImpl, ElementId, View, DirectedType, IncludeIncomingOutgoingType)"
  })
  void testGetRelevantElementsWithMapImplElementIdViewDirectedTypeInOutType14() {
    // Arrange
    Schema schema = new Schema();
    MapImpl mapImpl = new MapImpl(schema, new MapStoreProperties());
    Entity entity = new Entity.Builder().group("Group").vertex("Vertex").build();
    Entity entity2 = new Entity.Builder().group("Group").vertex("Vertex").build();

    EdgeSeed elementId = new EdgeSeed(entity, entity2);

    // Act
    Set<Element> actualRelevantElements =
        GetElementsUtil.getRelevantElements(
            mapImpl,
            elementId,
            new View(),
            DirectedType.EITHER,
            IncludeIncomingOutgoingType.EITHER);

    // Assert
    assertTrue(actualRelevantElements.isEmpty());
  }

  /**
   * Test {@link GetElementsUtil#getRelevantElements(MapImpl, ElementId, View, DirectedType,
   * IncludeIncomingOutgoingType)} with {@code mapImpl}, {@code elementId}, {@code view}, {@code
   * directedType}, {@code inOutType}.
   *
   * <p>Method under test: {@link GetElementsUtil#getRelevantElements(MapImpl, ElementId, View,
   * DirectedType, IncludeIncomingOutgoingType)}
   */
  @Test
  @DisplayName(
      "Test getRelevantElements(MapImpl, ElementId, View, DirectedType, IncludeIncomingOutgoingType) with 'mapImpl', 'elementId', 'view', 'directedType', 'inOutType'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set GetElementsUtil.getRelevantElements(MapImpl, ElementId, View, DirectedType, IncludeIncomingOutgoingType)"
  })
  void testGetRelevantElementsWithMapImplElementIdViewDirectedTypeInOutType15() {
    // Arrange
    Schema schema = new Schema();
    MapImpl mapImpl = new MapImpl(schema, new MapStoreProperties());
    Entity entity = new Entity.Builder().group("Group").vertex("Vertex").build();
    EdgeSeed elementId = new EdgeSeed(entity, new EdgeSeed());

    // Act
    Set<Element> actualRelevantElements =
        GetElementsUtil.getRelevantElements(
            mapImpl,
            elementId,
            new View(),
            DirectedType.EITHER,
            IncludeIncomingOutgoingType.EITHER);

    // Assert
    assertTrue(actualRelevantElements.isEmpty());
  }

  /**
   * Test {@link GetElementsUtil#getRelevantElements(MapImpl, ElementId, View, DirectedType,
   * IncludeIncomingOutgoingType)} with {@code mapImpl}, {@code elementId}, {@code view}, {@code
   * directedType}, {@code inOutType}.
   *
   * <p>Method under test: {@link GetElementsUtil#getRelevantElements(MapImpl, ElementId, View,
   * DirectedType, IncludeIncomingOutgoingType)}
   */
  @Test
  @DisplayName(
      "Test getRelevantElements(MapImpl, ElementId, View, DirectedType, IncludeIncomingOutgoingType) with 'mapImpl', 'elementId', 'view', 'directedType', 'inOutType'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set GetElementsUtil.getRelevantElements(MapImpl, ElementId, View, DirectedType, IncludeIncomingOutgoingType)"
  })
  void testGetRelevantElementsWithMapImplElementIdViewDirectedTypeInOutType16() {
    // Arrange
    Schema schema = new Schema();
    MapImpl mapImpl = new MapImpl(schema, new MapStoreProperties());

    Edge edge = new Edge("Group");
    edge.putProperty("destination", "Value");
    edge.putProperty("source", "Value");
    EdgeSeed elementId = new EdgeSeed(edge, "Destination");

    // Act
    Set<Element> actualRelevantElements =
        GetElementsUtil.getRelevantElements(
            mapImpl,
            elementId,
            new View(),
            DirectedType.EITHER,
            IncludeIncomingOutgoingType.EITHER);

    // Assert
    assertTrue(actualRelevantElements.isEmpty());
  }

  /**
   * Test {@link GetElementsUtil#getRelevantElements(MapImpl, ElementId, View, DirectedType,
   * IncludeIncomingOutgoingType)} with {@code mapImpl}, {@code elementId}, {@code view}, {@code
   * directedType}, {@code inOutType}.
   *
   * <p>Method under test: {@link GetElementsUtil#getRelevantElements(MapImpl, ElementId, View,
   * DirectedType, IncludeIncomingOutgoingType)}
   */
  @Test
  @DisplayName(
      "Test getRelevantElements(MapImpl, ElementId, View, DirectedType, IncludeIncomingOutgoingType) with 'mapImpl', 'elementId', 'view', 'directedType', 'inOutType'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set GetElementsUtil.getRelevantElements(MapImpl, ElementId, View, DirectedType, IncludeIncomingOutgoingType)"
  })
  void testGetRelevantElementsWithMapImplElementIdViewDirectedTypeInOutType17() {
    // Arrange
    Schema schema = new Schema();

    MapImpl mapImpl = new MapImpl(schema, new MapStoreProperties());
    EntitySeed entitySeed = new EntitySeed();
    mapImpl.addIndex(
        entitySeed,
        new Builder()
            .dest("Dest")
            .directed(true)
            .group("Group")
            .matchedVertex(MatchedVertex.SOURCE)
            .source("Source")
            .build());
    EdgeSeed elementId = new EdgeSeed(new EntitySeed(), "Destination");

    // Act
    Set<Element> actualRelevantElements =
        GetElementsUtil.getRelevantElements(
            mapImpl,
            elementId,
            new View(),
            DirectedType.EITHER,
            IncludeIncomingOutgoingType.EITHER);

    // Assert
    assertTrue(actualRelevantElements.isEmpty());
  }

  /**
   * Test {@link GetElementsUtil#getRelevantElements(MapImpl, ElementId, View, DirectedType,
   * IncludeIncomingOutgoingType)} with {@code mapImpl}, {@code elementId}, {@code view}, {@code
   * directedType}, {@code inOutType}.
   *
   * <p>Method under test: {@link GetElementsUtil#getRelevantElements(MapImpl, ElementId, View,
   * DirectedType, IncludeIncomingOutgoingType)}
   */
  @Test
  @DisplayName(
      "Test getRelevantElements(MapImpl, ElementId, View, DirectedType, IncludeIncomingOutgoingType) with 'mapImpl', 'elementId', 'view', 'directedType', 'inOutType'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set GetElementsUtil.getRelevantElements(MapImpl, ElementId, View, DirectedType, IncludeIncomingOutgoingType)"
  })
  void testGetRelevantElementsWithMapImplElementIdViewDirectedTypeInOutType18() {
    // Arrange
    Schema schema = new Schema();

    MapImpl mapImpl = new MapImpl(schema, new MapStoreProperties());
    EntitySeed entitySeed = new EntitySeed();
    mapImpl.addIndex(
        entitySeed,
        new Builder()
            .dest(42)
            .directed(true)
            .group("Group")
            .matchedVertex(MatchedVertex.SOURCE)
            .source("Source")
            .build());
    EntitySeed entitySeed2 = new EntitySeed();
    mapImpl.addIndex(
        entitySeed2,
        new Builder()
            .dest("Dest")
            .directed(true)
            .group("Group")
            .matchedVertex(MatchedVertex.SOURCE)
            .source("Source")
            .build());
    Entity elementId = new Entity("Group");

    // Act
    Set<Element> actualRelevantElements =
        GetElementsUtil.getRelevantElements(
            mapImpl,
            elementId,
            new View(),
            DirectedType.EITHER,
            IncludeIncomingOutgoingType.EITHER);

    // Assert
    assertTrue(actualRelevantElements.isEmpty());
  }

  /**
   * Test {@link GetElementsUtil#getRelevantElements(MapImpl, ElementId, View, DirectedType,
   * IncludeIncomingOutgoingType)} with {@code mapImpl}, {@code elementId}, {@code view}, {@code
   * directedType}, {@code inOutType}.
   *
   * <ul>
   *   <li>Given {@code source}.
   * </ul>
   *
   * <p>Method under test: {@link GetElementsUtil#getRelevantElements(MapImpl, ElementId, View,
   * DirectedType, IncludeIncomingOutgoingType)}
   */
  @Test
  @DisplayName(
      "Test getRelevantElements(MapImpl, ElementId, View, DirectedType, IncludeIncomingOutgoingType) with 'mapImpl', 'elementId', 'view', 'directedType', 'inOutType'; given 'source'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set GetElementsUtil.getRelevantElements(MapImpl, ElementId, View, DirectedType, IncludeIncomingOutgoingType)"
  })
  void testGetRelevantElementsWithMapImplElementIdViewDirectedTypeInOutType_givenSource() {
    // Arrange
    Schema schema = new Schema();
    MapImpl mapImpl = new MapImpl(schema, new MapStoreProperties());

    Edge edge = new Edge("Group");
    edge.putProperty("source", "Value");
    EdgeSeed elementId = new EdgeSeed(edge, "Destination");

    // Act
    Set<Element> actualRelevantElements =
        GetElementsUtil.getRelevantElements(
            mapImpl,
            elementId,
            new View(),
            DirectedType.EITHER,
            IncludeIncomingOutgoingType.EITHER);

    // Assert
    assertTrue(actualRelevantElements.isEmpty());
  }

  /**
   * Test {@link GetElementsUtil#applyVisibilityFilter(Stream, Schema, User)}.
   *
   * <ul>
   *   <li>Given {@code foo}.
   *   <li>Then return limit five collect toList Empty.
   * </ul>
   *
   * <p>Method under test: {@link GetElementsUtil#applyVisibilityFilter(Stream, Schema, User)}
   */
  @Test
  @DisplayName(
      "Test applyVisibilityFilter(Stream, Schema, User); given 'foo'; then return limit five collect toList Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Stream GetElementsUtil.applyVisibilityFilter(Stream, Schema, User)"})
  void testApplyVisibilityFilter_givenFoo_thenReturnLimitFiveCollectToListEmpty() {
    // Arrange
    ArrayList<Element> elementList = new ArrayList<>();
    Stream<Element> elements = elementList.stream();
    Schema schema = new Schema();

    HashSet<String> dataAuths = new HashSet<>();
    dataAuths.add("foo");
    dataAuths.add("foo");
    User user = new User("42", dataAuths);

    // Act
    Stream<Element> actualApplyVisibilityFilterResult =
        GetElementsUtil.applyVisibilityFilter(elements, schema, user);

    // Assert
    assertTrue(actualApplyVisibilityFilterResult.limit(5).collect(Collectors.toList()).isEmpty());
  }

  /**
   * Test {@link GetElementsUtil#applyVisibilityFilter(Stream, Schema, User)}.
   *
   * <ul>
   *   <li>When {@link User#User()}.
   *   <li>Then return limit five collect toList Empty.
   * </ul>
   *
   * <p>Method under test: {@link GetElementsUtil#applyVisibilityFilter(Stream, Schema, User)}
   */
  @Test
  @DisplayName(
      "Test applyVisibilityFilter(Stream, Schema, User); when User(); then return limit five collect toList Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Stream GetElementsUtil.applyVisibilityFilter(Stream, Schema, User)"})
  void testApplyVisibilityFilter_whenUser_thenReturnLimitFiveCollectToListEmpty() {
    // Arrange
    ArrayList<Element> elementList = new ArrayList<>();
    Stream<Element> elements = elementList.stream();
    Schema schema = new Schema();

    // Act
    Stream<Element> actualApplyVisibilityFilterResult =
        GetElementsUtil.applyVisibilityFilter(elements, schema, new User());

    // Assert
    assertTrue(actualApplyVisibilityFilterResult.limit(5).collect(Collectors.toList()).isEmpty());
  }

  /**
   * Test {@link GetElementsUtil#applyDirectedTypeFilter(Stream, boolean, DirectedType)}.
   *
   * <ul>
   *   <li>When {@code DIRECTED}.
   * </ul>
   *
   * <p>Method under test: {@link GetElementsUtil#applyDirectedTypeFilter(Stream, boolean,
   * DirectedType)}
   */
  @Test
  @DisplayName("Test applyDirectedTypeFilter(Stream, boolean, DirectedType); when 'DIRECTED'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Stream GetElementsUtil.applyDirectedTypeFilter(Stream, boolean, DirectedType)"
  })
  void testApplyDirectedTypeFilter_whenDirected() {
    // Arrange
    ArrayList<Element> elementList = new ArrayList<>();
    Stream<Element> elements = elementList.stream();

    // Act
    Stream<Element> actualApplyDirectedTypeFilterResult =
        GetElementsUtil.applyDirectedTypeFilter(elements, true, DirectedType.DIRECTED);

    // Assert
    assertTrue(actualApplyDirectedTypeFilterResult.limit(5).collect(Collectors.toList()).isEmpty());
  }

  /**
   * Test {@link GetElementsUtil#applyDirectedTypeFilter(Stream, boolean, DirectedType)}.
   *
   * <ul>
   *   <li>When {@code EITHER}.
   * </ul>
   *
   * <p>Method under test: {@link GetElementsUtil#applyDirectedTypeFilter(Stream, boolean,
   * DirectedType)}
   */
  @Test
  @DisplayName("Test applyDirectedTypeFilter(Stream, boolean, DirectedType); when 'EITHER'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Stream GetElementsUtil.applyDirectedTypeFilter(Stream, boolean, DirectedType)"
  })
  void testApplyDirectedTypeFilter_whenEither() {
    // Arrange
    ArrayList<Element> elementList = new ArrayList<>();
    Stream<Element> elements = elementList.stream();

    // Act
    Stream<Element> actualApplyDirectedTypeFilterResult =
        GetElementsUtil.applyDirectedTypeFilter(elements, true, DirectedType.EITHER);

    // Assert
    assertTrue(actualApplyDirectedTypeFilterResult.limit(5).collect(Collectors.toList()).isEmpty());
  }

  /**
   * Test {@link GetElementsUtil#applyDirectedTypeFilter(Stream, boolean, DirectedType)}.
   *
   * <ul>
   *   <li>When {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link GetElementsUtil#applyDirectedTypeFilter(Stream, boolean,
   * DirectedType)}
   */
  @Test
  @DisplayName("Test applyDirectedTypeFilter(Stream, boolean, DirectedType); when 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Stream GetElementsUtil.applyDirectedTypeFilter(Stream, boolean, DirectedType)"
  })
  void testApplyDirectedTypeFilter_whenFalse() {
    // Arrange
    ArrayList<Element> elementList = new ArrayList<>();
    Stream<Element> elements = elementList.stream();

    // Act
    Stream<Element> actualApplyDirectedTypeFilterResult =
        GetElementsUtil.applyDirectedTypeFilter(elements, false, DirectedType.DIRECTED);

    // Assert
    assertTrue(actualApplyDirectedTypeFilterResult.limit(5).collect(Collectors.toList()).isEmpty());
  }

  /**
   * Test {@link GetElementsUtil#applyDirectedTypeFilter(Stream, boolean, DirectedType)}.
   *
   * <ul>
   *   <li>When {@link DirectedType#UNDIRECTED}.
   * </ul>
   *
   * <p>Method under test: {@link GetElementsUtil#applyDirectedTypeFilter(Stream, boolean,
   * DirectedType)}
   */
  @Test
  @DisplayName("Test applyDirectedTypeFilter(Stream, boolean, DirectedType); when UNDIRECTED")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Stream GetElementsUtil.applyDirectedTypeFilter(Stream, boolean, DirectedType)"
  })
  void testApplyDirectedTypeFilter_whenUndirected() {
    // Arrange
    ArrayList<Element> elementList = new ArrayList<>();
    Stream<Element> elements = elementList.stream();

    // Act
    Stream<Element> actualApplyDirectedTypeFilterResult =
        GetElementsUtil.applyDirectedTypeFilter(elements, true, DirectedType.UNDIRECTED);

    // Assert
    assertTrue(actualApplyDirectedTypeFilterResult.limit(5).collect(Collectors.toList()).isEmpty());
  }

  /**
   * Test {@link GetElementsUtil#applyView(Stream, Schema, View, boolean)} with {@code
   * elementStream}, {@code schema}, {@code view}, {@code includeMatchedVertex}.
   *
   * <p>Method under test: {@link GetElementsUtil#applyView(Stream, Schema, View, boolean)}
   */
  @Test
  @DisplayName(
      "Test applyView(Stream, Schema, View, boolean) with 'elementStream', 'schema', 'view', 'includeMatchedVertex'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Stream GetElementsUtil.applyView(Stream, Schema, View, boolean)"})
  void testApplyViewWithElementStreamSchemaViewIncludeMatchedVertex() {
    // Arrange
    ArrayList<Element> elementList = new ArrayList<>();
    Stream<Element> elementStream = elementList.stream();
    Schema schema = new Schema();

    // Act
    Stream<Element> actualApplyViewResult =
        GetElementsUtil.applyView(elementStream, schema, new View(), true);

    // Assert
    assertTrue(actualApplyViewResult.limit(5).collect(Collectors.toList()).isEmpty());
  }

  /**
   * Test {@link GetElementsUtil#applyView(Stream, Schema, View)} with {@code elementStream}, {@code
   * schema}, {@code view}.
   *
   * <ul>
   *   <li>Then return limit five collect toList Empty.
   * </ul>
   *
   * <p>Method under test: {@link GetElementsUtil#applyView(Stream, Schema, View)}
   */
  @Test
  @DisplayName(
      "Test applyView(Stream, Schema, View) with 'elementStream', 'schema', 'view'; then return limit five collect toList Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Stream GetElementsUtil.applyView(Stream, Schema, View)"})
  void testApplyViewWithElementStreamSchemaView_thenReturnLimitFiveCollectToListEmpty() {
    // Arrange
    ArrayList<Element> elementList = new ArrayList<>();
    Stream<Element> elementStream = elementList.stream();
    Schema schema = new Schema();

    // Act
    Stream<Element> actualApplyViewResult =
        GetElementsUtil.applyView(elementStream, schema, new View());

    // Assert
    assertTrue(actualApplyViewResult.limit(5).collect(Collectors.toList()).isEmpty());
  }
}
