package uk.gov.gchq.gaffer.operation.impl.function;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.core.type.TypeReference;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang3.exception.CloneFailedException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.data.element.Element;
import uk.gov.gchq.gaffer.data.element.function.ElementFilter;
import uk.gov.gchq.gaffer.operation.impl.function.Filter.Builder;
import uk.gov.gchq.gaffer.operation.serialisation.TypeReferenceImpl;
import uk.gov.gchq.gaffer.operation.serialisation.TypeReferenceImpl.IterableElement;

class FilterDiffblueTest {
  /**
   * Test Builder {@link Builder#edge(String)} with {@code group}.
   *
   * <p>Method under test: {@link Builder#edge(String)}
   */
  @Test
  @DisplayName("Test Builder edge(String) with 'group'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.edge(String)"})
  void testBuilderEdgeWithGroup() {
    // Arrange
    Builder builder = new Builder();

    // Act
    Builder actualEdgeResult = builder.edge("Group");

    // Assert
    assertSame(builder, actualEdgeResult);
  }

  /**
   * Test Builder {@link Builder#edge(String, ElementFilter)} with {@code group}, {@code
   * elementFilter}.
   *
   * <p>Method under test: {@link Builder#edge(String, ElementFilter)}
   */
  @Test
  @DisplayName("Test Builder edge(String, ElementFilter) with 'group', 'elementFilter'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.edge(String, ElementFilter)"})
  void testBuilderEdgeWithGroupElementFilter() {
    // Arrange
    Builder builder = new Builder();

    // Act
    Builder actualEdgeResult = builder.edge("Group", new ElementFilter());

    // Assert
    assertSame(builder, actualEdgeResult);
  }

  /**
   * Test Builder {@link Builder#edges(Map)} with {@code edges}.
   *
   * <p>Method under test: {@link Builder#edges(Map)}
   */
  @Test
  @DisplayName("Test Builder edges(Map) with 'edges'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.edges(Map)"})
  void testBuilderEdgesWithEdges() {
    // Arrange
    Builder builder = new Builder();

    // Act
    Builder actualEdgesResult = builder.edges(new HashMap<>());

    // Assert
    assertSame(builder, actualEdgesResult);
  }

  /**
   * Test Builder {@link Builder#edges(Collection)} with {@code groups}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>Then return _getOp Edges size is two.
   * </ul>
   *
   * <p>Method under test: {@link Builder#edges(Collection)}
   */
  @Test
  @DisplayName(
      "Test Builder edges(Collection) with 'groups'; given '42'; then return _getOp Edges size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.edges(Collection)"})
  void testBuilderEdgesWithGroups_given42_thenReturn_getOpEdgesSizeIsTwo() {
    // Arrange
    Builder builder = new Builder();

    ArrayList<String> groups = new ArrayList<>();
    groups.add("42");
    groups.add("foo");

    // Act and Assert
    Map<String, ElementFilter> edges = builder.edges(groups)._getOp().getEdges();
    assertEquals(2, edges.size());
    ElementFilter getResult = edges.get("foo");
    assertTrue(getResult.getComponents().isEmpty());
    assertEquals(getResult, edges.get("42"));
  }

  /**
   * Test Builder {@link Builder#edges(Collection)} with {@code groups}.
   *
   * <ul>
   *   <li>Then _getOp OutputTypeReference return {@link TypeReferenceImpl.IterableElement}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#edges(Collection)}
   */
  @Test
  @DisplayName(
      "Test Builder edges(Collection) with 'groups'; then _getOp OutputTypeReference return IterableElement")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.edges(Collection)"})
  void testBuilderEdgesWithGroups_then_getOpOutputTypeReferenceReturnIterableElement() {
    // Arrange
    Builder builder = new Builder();

    LinkedHashSet<String> groups = new LinkedHashSet<>();
    groups.add("Groups");

    // Act
    Builder actualEdgesResult = builder.edges(groups);

    // Assert
    Filter _getOpResult = actualEdgesResult._getOp();
    assertTrue(_getOpResult.getOutputTypeReference() instanceof IterableElement);
    Map<String, ElementFilter> edges = _getOpResult.getEdges();
    assertEquals(1, edges.size());
    assertTrue(edges.get("Groups").getComponents().isEmpty());
    Filter actualFilter = actualEdgesResult.build();
    assertSame(_getOpResult, actualFilter);
  }

  /**
   * Test Builder {@link Builder#edges(Collection)} with {@code groups}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return {@link Builder} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link Builder#edges(Collection)}
   */
  @Test
  @DisplayName(
      "Test Builder edges(Collection) with 'groups'; when ArrayList(); then return Builder (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.edges(Collection)"})
  void testBuilderEdgesWithGroups_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builder = new Builder();

    // Act
    Builder actualEdgesResult = builder.edges(new ArrayList<>());

    // Assert
    assertSame(builder, actualEdgesResult);
  }

  /**
   * Test Builder {@link Builder#entities(Map)} with {@code entities}.
   *
   * <p>Method under test: {@link Builder#entities(Map)}
   */
  @Test
  @DisplayName("Test Builder entities(Map) with 'entities'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.entities(Map)"})
  void testBuilderEntitiesWithEntities() {
    // Arrange
    Builder builder = new Builder();

    // Act
    Builder actualEntitiesResult = builder.entities(new HashMap<>());

    // Assert
    assertSame(builder, actualEntitiesResult);
  }

  /**
   * Test Builder {@link Builder#entities(Collection)} with {@code groups}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>Then return _getOp Entities size is two.
   * </ul>
   *
   * <p>Method under test: {@link Builder#entities(Collection)}
   */
  @Test
  @DisplayName(
      "Test Builder entities(Collection) with 'groups'; given '42'; then return _getOp Entities size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.entities(Collection)"})
  void testBuilderEntitiesWithGroups_given42_thenReturn_getOpEntitiesSizeIsTwo() {
    // Arrange
    Builder builder = new Builder();

    ArrayList<String> groups = new ArrayList<>();
    groups.add("42");
    groups.add("foo");

    // Act and Assert
    Map<String, ElementFilter> entities = builder.entities(groups)._getOp().getEntities();
    assertEquals(2, entities.size());
    ElementFilter getResult = entities.get("foo");
    assertTrue(getResult.getComponents().isEmpty());
    assertEquals(getResult, entities.get("42"));
  }

  /**
   * Test Builder {@link Builder#entities(Collection)} with {@code groups}.
   *
   * <ul>
   *   <li>Then _getOp OutputTypeReference return {@link TypeReferenceImpl.IterableElement}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#entities(Collection)}
   */
  @Test
  @DisplayName(
      "Test Builder entities(Collection) with 'groups'; then _getOp OutputTypeReference return IterableElement")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.entities(Collection)"})
  void testBuilderEntitiesWithGroups_then_getOpOutputTypeReferenceReturnIterableElement() {
    // Arrange
    Builder builder = new Builder();

    LinkedHashSet<String> groups = new LinkedHashSet<>();
    groups.add("Groups");

    // Act
    Builder actualEntitiesResult = builder.entities(groups);

    // Assert
    Filter _getOpResult = actualEntitiesResult._getOp();
    assertTrue(_getOpResult.getOutputTypeReference() instanceof IterableElement);
    Map<String, ElementFilter> entities = _getOpResult.getEntities();
    assertEquals(1, entities.size());
    assertTrue(entities.get("Groups").getComponents().isEmpty());
    Filter actualFilter = actualEntitiesResult.build();
    assertSame(_getOpResult, actualFilter);
  }

  /**
   * Test Builder {@link Builder#entities(Collection)} with {@code groups}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return {@link Builder} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link Builder#entities(Collection)}
   */
  @Test
  @DisplayName(
      "Test Builder entities(Collection) with 'groups'; when ArrayList(); then return Builder (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.entities(Collection)"})
  void testBuilderEntitiesWithGroups_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builder = new Builder();

    // Act
    Builder actualEntitiesResult = builder.entities(new ArrayList<>());

    // Assert
    assertSame(builder, actualEntitiesResult);
  }

  /**
   * Test Builder {@link Builder#entity(String)} with {@code group}.
   *
   * <p>Method under test: {@link Builder#entity(String)}
   */
  @Test
  @DisplayName("Test Builder entity(String) with 'group'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.entity(String)"})
  void testBuilderEntityWithGroup() {
    // Arrange
    Builder builder = new Builder();

    // Act
    Builder actualEntityResult = builder.entity("Group");

    // Assert
    assertSame(builder, actualEntityResult);
  }

  /**
   * Test Builder {@link Builder#entity(String, ElementFilter)} with {@code group}, {@code
   * elementFilter}.
   *
   * <p>Method under test: {@link Builder#entity(String, ElementFilter)}
   */
  @Test
  @DisplayName("Test Builder entity(String, ElementFilter) with 'group', 'elementFilter'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.entity(String, ElementFilter)"})
  void testBuilderEntityWithGroupElementFilter() {
    // Arrange
    Builder builder = new Builder();

    // Act
    Builder actualEntityResult = builder.entity("Group", new ElementFilter());

    // Assert
    assertSame(builder, actualEntityResult);
  }

  /**
   * Test Builder {@link Builder#globalEdges(ElementFilter)}.
   *
   * <p>Method under test: {@link Builder#globalEdges(ElementFilter)}
   */
  @Test
  @DisplayName("Test Builder globalEdges(ElementFilter)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.globalEdges(ElementFilter)"})
  void testBuilderGlobalEdges() {
    // Arrange
    Builder builder = new Builder();

    // Act
    Builder actualGlobalEdgesResult = builder.globalEdges(new ElementFilter());

    // Assert
    assertSame(builder, actualGlobalEdgesResult);
  }

  /**
   * Test Builder {@link Builder#globalElements(ElementFilter)}.
   *
   * <p>Method under test: {@link Builder#globalElements(ElementFilter)}
   */
  @Test
  @DisplayName("Test Builder globalElements(ElementFilter)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.globalElements(ElementFilter)"})
  void testBuilderGlobalElements() {
    // Arrange
    Builder builder = new Builder();

    // Act
    Builder actualGlobalElementsResult = builder.globalElements(new ElementFilter());

    // Assert
    assertSame(builder, actualGlobalElementsResult);
  }

  /**
   * Test Builder {@link Builder#globalEntities(ElementFilter)}.
   *
   * <p>Method under test: {@link Builder#globalEntities(ElementFilter)}
   */
  @Test
  @DisplayName("Test Builder globalEntities(ElementFilter)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.globalEntities(ElementFilter)"})
  void testBuilderGlobalEntities() {
    // Arrange
    Builder builder = new Builder();

    // Act
    Builder actualGlobalEntitiesResult = builder.globalEntities(new ElementFilter());

    // Assert
    assertSame(builder, actualGlobalEntitiesResult);
  }

  /**
   * Test Builder new {@link Builder} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link Builder}
   */
  @Test
  @DisplayName("Test Builder new Builder (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Builder.<init>()"})
  void testBuilderNewBuilder() {
    // Arrange and Act
    Builder actualBuilder = new Builder();

    // Assert
    Filter _getOpResult = actualBuilder._getOp();
    TypeReference<Iterable<? extends Element>> outputTypeReference =
        _getOpResult.getOutputTypeReference();
    assertTrue(outputTypeReference instanceof IterableElement);
    Type outputType = _getOpResult.getOutputType();
    assertEquals(
        "java.lang.Iterable<? extends uk.gov.gchq.gaffer.data.element.Element>",
        outputType.getTypeName());
    assertNull(_getOpResult.getInput());
    assertNull(_getOpResult.getOptions());
    assertNull(_getOpResult.getEdges());
    assertNull(_getOpResult.getEntities());
    assertNull(_getOpResult.getGlobalEdges());
    assertNull(_getOpResult.getGlobalElements());
    assertNull(_getOpResult.getGlobalEntities());
    Class<Iterable> expectedOutputClass = Iterable.class;
    assertEquals(expectedOutputClass, _getOpResult.getOutputClass());
    Filter actualFilter = actualBuilder.build();
    assertSame(_getOpResult, actualFilter);
    assertSame(outputType, outputTypeReference.getType());
  }

  /**
   * Test {@link Filter#shallowClone()}.
   *
   * <ul>
   *   <li>Given {@link Filter} (default constructor) Options is {@link HashMap#HashMap()}.
   *   <li>Then return Options Empty.
   * </ul>
   *
   * <p>Method under test: {@link Filter#shallowClone()}
   */
  @Test
  @DisplayName(
      "Test shallowClone(); given Filter (default constructor) Options is HashMap(); then return Options Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Filter Filter.shallowClone()"})
  void testShallowClone_givenFilterOptionsIsHashMap_thenReturnOptionsEmpty()
      throws CloneFailedException {
    // Arrange
    Filter filter = new Filter();
    filter.setOptions(new HashMap<>());

    // Act
    Filter actualShallowCloneResult = filter.shallowClone();

    // Assert
    TypeReference<Iterable<? extends Element>> outputTypeReference =
        actualShallowCloneResult.getOutputTypeReference();
    assertTrue(outputTypeReference instanceof IterableElement);
    Type outputType = actualShallowCloneResult.getOutputType();
    assertEquals(
        "java.lang.Iterable<? extends uk.gov.gchq.gaffer.data.element.Element>",
        outputType.getTypeName());
    assertNull(actualShallowCloneResult.getInput());
    assertNull(actualShallowCloneResult.getEdges());
    assertNull(actualShallowCloneResult.getEntities());
    assertNull(actualShallowCloneResult.getGlobalEdges());
    assertNull(actualShallowCloneResult.getGlobalElements());
    assertNull(actualShallowCloneResult.getGlobalEntities());
    assertTrue(actualShallowCloneResult.getOptions().isEmpty());
    Class<Iterable> expectedOutputClass = Iterable.class;
    assertEquals(expectedOutputClass, actualShallowCloneResult.getOutputClass());
    assertSame(outputType, outputTypeReference.getType());
  }

  /**
   * Test {@link Filter#shallowClone()}.
   *
   * <ul>
   *   <li>Given {@link Filter} (default constructor).
   *   <li>Then return Options is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link Filter#shallowClone()}
   */
  @Test
  @DisplayName(
      "Test shallowClone(); given Filter (default constructor); then return Options is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Filter Filter.shallowClone()"})
  void testShallowClone_givenFilter_thenReturnOptionsIsNull() throws CloneFailedException {
    // Arrange and Act
    Filter actualShallowCloneResult = new Filter().shallowClone();

    // Assert
    TypeReference<Iterable<? extends Element>> outputTypeReference =
        actualShallowCloneResult.getOutputTypeReference();
    assertTrue(outputTypeReference instanceof IterableElement);
    Type outputType = actualShallowCloneResult.getOutputType();
    assertEquals(
        "java.lang.Iterable<? extends uk.gov.gchq.gaffer.data.element.Element>",
        outputType.getTypeName());
    assertNull(actualShallowCloneResult.getInput());
    assertNull(actualShallowCloneResult.getOptions());
    assertNull(actualShallowCloneResult.getEdges());
    assertNull(actualShallowCloneResult.getEntities());
    assertNull(actualShallowCloneResult.getGlobalEdges());
    assertNull(actualShallowCloneResult.getGlobalElements());
    assertNull(actualShallowCloneResult.getGlobalEntities());
    Class<Iterable> expectedOutputClass = Iterable.class;
    assertEquals(expectedOutputClass, actualShallowCloneResult.getOutputClass());
    assertSame(outputType, outputTypeReference.getType());
  }

  /**
   * Test {@link Filter#getInput()}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link Filter#getInput()}
   */
  @Test
  @DisplayName("Test getInput(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Iterable Filter.getInput()"})
  void testGetInput_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new Filter().getInput());
  }

  /**
   * Test {@link Filter#getOutputTypeReference()}.
   *
   * <p>Method under test: {@link Filter#getOutputTypeReference()}
   */
  @Test
  @DisplayName("Test getOutputTypeReference()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TypeReference Filter.getOutputTypeReference()"})
  void testGetOutputTypeReference() {
    // Arrange and Act
    TypeReference<Iterable<? extends Element>> actualOutputTypeReference =
        new Filter().getOutputTypeReference();

    // Assert
    assertTrue(actualOutputTypeReference instanceof IterableElement);
    assertEquals(
        "java.lang.Iterable<? extends uk.gov.gchq.gaffer.data.element.Element>",
        actualOutputTypeReference.getType().getTypeName());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link Filter}
   *   <li>{@link Filter#setEdges(Map)}
   *   <li>{@link Filter#setEntities(Map)}
   *   <li>{@link Filter#setGlobalEdges(ElementFilter)}
   *   <li>{@link Filter#setGlobalElements(ElementFilter)}
   *   <li>{@link Filter#setGlobalEntities(ElementFilter)}
   *   <li>{@link Filter#setInput(Iterable)}
   *   <li>{@link Filter#setOptions(Map)}
   *   <li>{@link Filter#getEdges()}
   *   <li>{@link Filter#getEntities()}
   *   <li>{@link Filter#getGlobalEdges()}
   *   <li>{@link Filter#getGlobalElements()}
   *   <li>{@link Filter#getGlobalEntities()}
   *   <li>{@link Filter#getOptions()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void Filter.<init>()",
    "Map Filter.getEdges()",
    "Map Filter.getEntities()",
    "ElementFilter Filter.getGlobalEdges()",
    "ElementFilter Filter.getGlobalElements()",
    "ElementFilter Filter.getGlobalEntities()",
    "Map Filter.getOptions()",
    "void Filter.setEdges(Map)",
    "void Filter.setEntities(Map)",
    "void Filter.setGlobalEdges(ElementFilter)",
    "void Filter.setGlobalElements(ElementFilter)",
    "void Filter.setGlobalEntities(ElementFilter)",
    "void Filter.setInput(Iterable)",
    "void Filter.setOptions(Map)"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    Filter actualFilter = new Filter();
    HashMap<String, ElementFilter> edges = new HashMap<>();
    actualFilter.setEdges(edges);
    HashMap<String, ElementFilter> entities = new HashMap<>();
    actualFilter.setEntities(entities);
    ElementFilter globalEdges = new ElementFilter.Builder().build();
    actualFilter.setGlobalEdges(globalEdges);
    ElementFilter globalElements = new ElementFilter.Builder().build();
    actualFilter.setGlobalElements(globalElements);
    ElementFilter globalEntities = new ElementFilter.Builder().build();
    actualFilter.setGlobalEntities(globalEntities);
    ArrayList<Element> input = new ArrayList<>();
    actualFilter.setInput(input);
    HashMap<String, String> options = new HashMap<>();
    actualFilter.setOptions(options);
    Map<String, ElementFilter> actualEdges = actualFilter.getEdges();
    Map<String, ElementFilter> actualEntities = actualFilter.getEntities();
    ElementFilter actualGlobalEdges = actualFilter.getGlobalEdges();
    ElementFilter actualGlobalElements = actualFilter.getGlobalElements();
    ElementFilter actualGlobalEntities = actualFilter.getGlobalEntities();
    Map<String, String> actualOptions = actualFilter.getOptions();

    // Assert
    Iterable<? extends Element> input2 = actualFilter.getInput();
    assertTrue(input2 instanceof List);
    assertTrue(actualEdges.isEmpty());
    assertTrue(actualEntities.isEmpty());
    assertTrue(actualOptions.isEmpty());
    assertSame(input, input2);
    assertSame(edges, actualEdges);
    assertSame(entities, actualEntities);
    assertSame(options, actualOptions);
    assertSame(globalEdges, actualGlobalEdges);
    assertSame(globalElements, actualGlobalElements);
    assertSame(globalEntities, actualGlobalEntities);
  }
}
