package uk.gov.gchq.gaffer.graph.hook.migrate;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.fasterxml.jackson.core.type.TypeReference;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Predicate;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.data.element.Element;
import uk.gov.gchq.gaffer.data.element.function.ElementAggregator;
import uk.gov.gchq.gaffer.data.element.function.ElementFilter;
import uk.gov.gchq.gaffer.data.element.function.ElementTransformer;
import uk.gov.gchq.gaffer.data.element.function.ElementTransformer.Builder;
import uk.gov.gchq.gaffer.data.elementdefinition.exception.SchemaException;
import uk.gov.gchq.gaffer.data.elementdefinition.view.ViewElementDefinition;
import uk.gov.gchq.gaffer.graph.hook.migrate.MigrateElement.ElementType;
import uk.gov.gchq.gaffer.graph.hook.migrate.predicate.TransformAndFilter;
import uk.gov.gchq.gaffer.operation.Operation;
import uk.gov.gchq.gaffer.operation.impl.function.Aggregate;
import uk.gov.gchq.gaffer.operation.serialisation.TypeReferenceImpl;
import uk.gov.gchq.gaffer.operation.serialisation.TypeReferenceImpl.IterableElement;
import uk.gov.gchq.koryphe.tuple.function.TupleAdaptedFunction;
import uk.gov.gchq.koryphe.tuple.predicate.TupleAdaptedPredicate;

class ViewMigrationDiffblueTest {
  /**
   * Test {@link ViewMigration#ViewMigration(boolean)}.
   *
   * <p>Method under test: {@link ViewMigration#ViewMigration(boolean)}
   */
  @Test
  @DisplayName("Test new ViewMigration(boolean)")
  @Tag("MaintainedByDiffblue")
  void testNewViewMigration() throws SchemaException {
    // Arrange, Act and Assert
    ViewElementDefinition buildViewElementDefinitionResult =
        new ViewMigration(true).buildViewElementDefinition();
    assertNull(buildViewElementDefinitionResult.getTransformFunctions());
    assertNull(buildViewElementDefinitionResult.getPostAggregationFilterFunctions());
    assertNull(buildViewElementDefinitionResult.getPostTransformFilterFunctions());
    assertNull(buildViewElementDefinitionResult.getPreAggregationFilterFunctions());
    assertNull(buildViewElementDefinitionResult.getTransientPropertyMapWithClassNames());
    assertNull(buildViewElementDefinitionResult.getExcludeProperties());
    assertNull(buildViewElementDefinitionResult.getGroupBy());
    assertNull(buildViewElementDefinitionResult.getProperties());
    assertNull(buildViewElementDefinitionResult.getAggregator());
    assertNull(buildViewElementDefinitionResult.getPostAggregationFilter());
    assertNull(buildViewElementDefinitionResult.getPostTransformFilter());
    assertNull(buildViewElementDefinitionResult.getPreAggregationFilter());
    assertNull(buildViewElementDefinitionResult.getTransformer());
    assertFalse(buildViewElementDefinitionResult.hasPostAggregationFilters());
    assertFalse(buildViewElementDefinitionResult.hasPostTransformFilters());
    assertFalse(buildViewElementDefinitionResult.hasPreAggregationFilters());
    assertFalse(buildViewElementDefinitionResult.hasTransform());
    assertFalse(buildViewElementDefinitionResult.isEmpty());
    assertTrue(buildViewElementDefinitionResult.getTransientPropertyClasses().isEmpty());
    assertTrue(buildViewElementDefinitionResult.getTransientPropertyMap().isEmpty());
    assertTrue(buildViewElementDefinitionResult.getTransientProperties().isEmpty());
    assertTrue(buildViewElementDefinitionResult.isAllProperties());
    assertArrayEquals(new byte[] {'{', '}'}, buildViewElementDefinitionResult.toCompactJson());
  }

  /**
   * Test {@link ViewMigration#createMigrationOps(boolean, Iterable, Iterable)} with {@code
   * aggregateAfter}, {@code views1}, {@code views2}.
   *
   * <p>Method under test: {@link ViewMigration#createMigrationOps(boolean, Iterable, Iterable)}
   */
  @Test
  @DisplayName(
      "Test createMigrationOps(boolean, Iterable, Iterable) with 'aggregateAfter', 'views1', 'views2'")
  @Tag("MaintainedByDiffblue")
  void testCreateMigrationOpsWithAggregateAfterViews1Views2() {
    // Arrange
    ArrayList<ViewMigration> views1 = new ArrayList<>();
    views1.add(new ViewMigration(true));

    // Act
    List<Operation> actualCreateMigrationOpsResult =
        ViewMigration.createMigrationOps(true, views1, new ArrayList<>());

    // Assert
    assertEquals(1, actualCreateMigrationOpsResult.size());
    Operation getResult = actualCreateMigrationOpsResult.get(0);
    assertTrue(getResult instanceof Aggregate);
    TypeReference<Iterable<? extends Element>> outputTypeReference =
        ((Aggregate) getResult).getOutputTypeReference();
    assertTrue(outputTypeReference instanceof IterableElement);
    Type outputType = ((Aggregate) getResult).getOutputType();
    assertEquals(
        "java.lang.Iterable<? extends uk.gov.gchq.gaffer.data.element.Element>",
        outputType.getTypeName());
    assertNull(((Aggregate) getResult).getInput());
    assertNull(getResult.getOptions());
    assertNull(((Aggregate) getResult).getEdges());
    assertNull(((Aggregate) getResult).getEntities());
    Class<Iterable> expectedOutputClass = Iterable.class;
    assertEquals(expectedOutputClass, ((Aggregate) getResult).getOutputClass());
    assertSame(outputType, outputTypeReference.getType());
  }

  /**
   * Test {@link ViewMigration#createMigrationOps(boolean, Iterable, Iterable)} with {@code
   * aggregateAfter}, {@code views1}, {@code views2}.
   *
   * <ul>
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link ViewMigration#createMigrationOps(boolean, Iterable, Iterable)}
   */
  @Test
  @DisplayName(
      "Test createMigrationOps(boolean, Iterable, Iterable) with 'aggregateAfter', 'views1', 'views2'; then return size is one")
  @Tag("MaintainedByDiffblue")
  void testCreateMigrationOpsWithAggregateAfterViews1Views2_thenReturnSizeIsOne() {
    // Arrange
    ArrayList<ViewMigration> views1 = new ArrayList<>();

    // Act
    List<Operation> actualCreateMigrationOpsResult =
        ViewMigration.createMigrationOps(true, views1, new ArrayList<>());

    // Assert
    assertEquals(1, actualCreateMigrationOpsResult.size());
    Operation getResult = actualCreateMigrationOpsResult.get(0);
    assertTrue(getResult instanceof Aggregate);
    TypeReference<Iterable<? extends Element>> outputTypeReference =
        ((Aggregate) getResult).getOutputTypeReference();
    assertTrue(outputTypeReference instanceof IterableElement);
    Type outputType = ((Aggregate) getResult).getOutputType();
    assertEquals(
        "java.lang.Iterable<? extends uk.gov.gchq.gaffer.data.element.Element>",
        outputType.getTypeName());
    assertNull(((Aggregate) getResult).getInput());
    assertNull(getResult.getOptions());
    assertNull(((Aggregate) getResult).getEdges());
    assertNull(((Aggregate) getResult).getEntities());
    Class<Iterable> expectedOutputClass = Iterable.class;
    assertEquals(expectedOutputClass, ((Aggregate) getResult).getOutputClass());
    assertSame(outputType, outputTypeReference.getType());
  }

  /**
   * Test {@link ViewMigration#createMigrationOps(boolean, Iterable, Iterable)} with {@code
   * aggregateAfter}, {@code views1}, {@code views2}.
   *
   * <ul>
   *   <li>When {@code false}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link ViewMigration#createMigrationOps(boolean, Iterable, Iterable)}
   */
  @Test
  @DisplayName(
      "Test createMigrationOps(boolean, Iterable, Iterable) with 'aggregateAfter', 'views1', 'views2'; when 'false'; then return Empty")
  @Tag("MaintainedByDiffblue")
  void testCreateMigrationOpsWithAggregateAfterViews1Views2_whenFalse_thenReturnEmpty() {
    // Arrange
    ArrayList<ViewMigration> views1 = new ArrayList<>();

    // Act
    List<Operation> actualCreateMigrationOpsResult =
        ViewMigration.createMigrationOps(false, views1, new ArrayList<>());

    // Assert
    assertTrue(actualCreateMigrationOpsResult.isEmpty());
  }

  /**
   * Test {@link ViewMigration#createMigrationOps(boolean, Iterable)} with {@code aggregateAfter},
   * {@code views}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link ViewMigration#createMigrationOps(boolean, Iterable)}
   */
  @Test
  @DisplayName(
      "Test createMigrationOps(boolean, Iterable) with 'aggregateAfter', 'views'; then return Empty")
  @Tag("MaintainedByDiffblue")
  void testCreateMigrationOpsWithAggregateAfterViews_thenReturnEmpty() {
    // Arrange
    LinkedHashSet<ViewMigration> views = new LinkedHashSet<>();
    views.add(new ViewMigration(true));

    // Act
    List<Operation> actualCreateMigrationOpsResult = ViewMigration.createMigrationOps(false, views);

    // Assert
    assertTrue(actualCreateMigrationOpsResult.isEmpty());
  }

  /**
   * Test {@link ViewMigration#createMigrationOps(boolean, Iterable)} with {@code aggregateAfter},
   * {@code views}.
   *
   * <ul>
   *   <li>When {@code true}.
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link ViewMigration#createMigrationOps(boolean, Iterable)}
   */
  @Test
  @DisplayName(
      "Test createMigrationOps(boolean, Iterable) with 'aggregateAfter', 'views'; when 'true'; then return size is one")
  @Tag("MaintainedByDiffblue")
  void testCreateMigrationOpsWithAggregateAfterViews_whenTrue_thenReturnSizeIsOne() {
    // Arrange and Act
    List<Operation> actualCreateMigrationOpsResult =
        ViewMigration.createMigrationOps(true, new ArrayList<>());

    // Assert
    assertEquals(1, actualCreateMigrationOpsResult.size());
    Operation getResult = actualCreateMigrationOpsResult.get(0);
    assertTrue(getResult instanceof Aggregate);
    TypeReference<Iterable<? extends Element>> outputTypeReference =
        ((Aggregate) getResult).getOutputTypeReference();
    assertTrue(outputTypeReference instanceof IterableElement);
    Type outputType = ((Aggregate) getResult).getOutputType();
    assertEquals(
        "java.lang.Iterable<? extends uk.gov.gchq.gaffer.data.element.Element>",
        outputType.getTypeName());
    assertNull(((Aggregate) getResult).getInput());
    assertNull(getResult.getOptions());
    assertNull(((Aggregate) getResult).getEdges());
    assertNull(((Aggregate) getResult).getEntities());
    Class<Iterable> expectedOutputClass = Iterable.class;
    assertEquals(expectedOutputClass, ((Aggregate) getResult).getOutputClass());
    assertSame(outputType, outputTypeReference.getType());
  }

  /**
   * Test {@link ViewMigration#update(MigrateElement, String, ViewElementDefinition)}.
   *
   * <ul>
   *   <li>Then return buildViewElementDefinition is {@link ViewElementDefinition} (default
   *       constructor).
   * </ul>
   *
   * <p>Method under test: {@link ViewMigration#update(MigrateElement, String,
   * ViewElementDefinition)}
   */
  @Test
  @DisplayName(
      "Test update(MigrateElement, String, ViewElementDefinition); then return buildViewElementDefinition is ViewElementDefinition (default constructor)")
  @Tag("MaintainedByDiffblue")
  void testUpdate_thenReturnBuildViewElementDefinitionIsViewElementDefinition() {
    // Arrange
    ViewMigration viewMigration = new ViewMigration(true);
    MigrateElement migration = new MigrateElement();
    ViewElementDefinition elementDefinition = new ViewElementDefinition();

    // Act
    ViewMigration actualUpdateResult = viewMigration.update(migration, "Group", elementDefinition);

    // Assert
    assertEquals(elementDefinition, actualUpdateResult.buildViewElementDefinition());
    assertSame(viewMigration, actualUpdateResult);
  }

  /**
   * Test {@link ViewMigration#update(MigrateElement, String, ViewElementDefinition)}.
   *
   * <ul>
   *   <li>Then return buildViewElementDefinition TransformFunctions is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ViewMigration#update(MigrateElement, String,
   * ViewElementDefinition)}
   */
  @Test
  @DisplayName(
      "Test update(MigrateElement, String, ViewElementDefinition); then return buildViewElementDefinition TransformFunctions is 'null'")
  @Tag("MaintainedByDiffblue")
  void testUpdate_thenReturnBuildViewElementDefinitionTransformFunctionsIsNull()
      throws UnsupportedEncodingException, SchemaException {
    // Arrange
    ViewMigration viewMigration = new ViewMigration(true);
    MigrateElement migration = new MigrateElement();

    ViewElementDefinition elementDefinition = new ViewElementDefinition();
    elementDefinition.setGroupBy(new LinkedHashSet<>());

    // Act and Assert
    ViewElementDefinition buildViewElementDefinitionResult =
        viewMigration.update(migration, "Group", elementDefinition).buildViewElementDefinition();
    assertNull(buildViewElementDefinitionResult.getTransformFunctions());
    assertNull(buildViewElementDefinitionResult.getPostAggregationFilterFunctions());
    assertNull(buildViewElementDefinitionResult.getPostTransformFilterFunctions());
    assertNull(buildViewElementDefinitionResult.getPreAggregationFilterFunctions());
    assertNull(buildViewElementDefinitionResult.getTransientPropertyMapWithClassNames());
    assertNull(buildViewElementDefinitionResult.getExcludeProperties());
    assertNull(buildViewElementDefinitionResult.getProperties());
    assertNull(buildViewElementDefinitionResult.getAggregator());
    assertNull(buildViewElementDefinitionResult.getPostAggregationFilter());
    assertNull(buildViewElementDefinitionResult.getPostTransformFilter());
    assertNull(buildViewElementDefinitionResult.getPreAggregationFilter());
    assertNull(buildViewElementDefinitionResult.getTransformer());
    assertFalse(buildViewElementDefinitionResult.hasPostAggregationFilters());
    assertFalse(buildViewElementDefinitionResult.hasPostTransformFilters());
    assertFalse(buildViewElementDefinitionResult.hasPreAggregationFilters());
    assertFalse(buildViewElementDefinitionResult.hasTransform());
    assertFalse(buildViewElementDefinitionResult.isEmpty());
    assertTrue(buildViewElementDefinitionResult.getTransientPropertyClasses().isEmpty());
    assertTrue(buildViewElementDefinitionResult.getTransientPropertyMap().isEmpty());
    assertTrue(buildViewElementDefinitionResult.getGroupBy().isEmpty());
    assertTrue(buildViewElementDefinitionResult.getTransientProperties().isEmpty());
    assertTrue(buildViewElementDefinitionResult.isAllProperties());
    byte[] expectedToCompactJsonResult = "{\"groupBy\":[]}".getBytes("UTF-8");
    assertArrayEquals(
        expectedToCompactJsonResult, buildViewElementDefinitionResult.toCompactJson());
  }

  /**
   * Test {@link ViewMigration#prepareBuilder(ViewElementDefinition)}.
   *
   * <ul>
   *   <li>Given {@link LinkedHashSet#LinkedHashSet()}.
   * </ul>
   *
   * <p>Method under test: {@link ViewMigration#prepareBuilder(ViewElementDefinition)}
   */
  @Test
  @DisplayName("Test prepareBuilder(ViewElementDefinition); given LinkedHashSet()")
  @Tag("MaintainedByDiffblue")
  void testPrepareBuilder_givenLinkedHashSet() {
    // Arrange
    ViewMigration viewMigration = new ViewMigration(true);

    ViewElementDefinition elementDef = new ViewElementDefinition();
    elementDef.setGroupBy(new LinkedHashSet<>());

    // Act and Assert
    assertEquals(elementDef, viewMigration.prepareBuilder(elementDef).buildViewElementDefinition());
  }

  /**
   * Test {@link ViewMigration#prepareBuilder(ViewElementDefinition)}.
   *
   * <ul>
   *   <li>Then return buildViewElementDefinition TransformFunctions is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ViewMigration#prepareBuilder(ViewElementDefinition)}
   */
  @Test
  @DisplayName(
      "Test prepareBuilder(ViewElementDefinition); then return buildViewElementDefinition TransformFunctions is 'null'")
  @Tag("MaintainedByDiffblue")
  void testPrepareBuilder_thenReturnBuildViewElementDefinitionTransformFunctionsIsNull()
      throws SchemaException {
    // Arrange, Act and Assert
    ViewElementDefinition buildViewElementDefinitionResult =
        new ViewMigration(true).prepareBuilder(null).buildViewElementDefinition();
    assertNull(buildViewElementDefinitionResult.getTransformFunctions());
    assertNull(buildViewElementDefinitionResult.getPostAggregationFilterFunctions());
    assertNull(buildViewElementDefinitionResult.getPostTransformFilterFunctions());
    assertNull(buildViewElementDefinitionResult.getPreAggregationFilterFunctions());
    assertNull(buildViewElementDefinitionResult.getTransientPropertyMapWithClassNames());
    assertNull(buildViewElementDefinitionResult.getExcludeProperties());
    assertNull(buildViewElementDefinitionResult.getGroupBy());
    assertNull(buildViewElementDefinitionResult.getProperties());
    assertNull(buildViewElementDefinitionResult.getAggregator());
    assertNull(buildViewElementDefinitionResult.getPostAggregationFilter());
    assertNull(buildViewElementDefinitionResult.getPostTransformFilter());
    assertNull(buildViewElementDefinitionResult.getPreAggregationFilter());
    assertNull(buildViewElementDefinitionResult.getTransformer());
    assertFalse(buildViewElementDefinitionResult.hasPostAggregationFilters());
    assertFalse(buildViewElementDefinitionResult.hasPostTransformFilters());
    assertFalse(buildViewElementDefinitionResult.hasPreAggregationFilters());
    assertFalse(buildViewElementDefinitionResult.hasTransform());
    assertFalse(buildViewElementDefinitionResult.isEmpty());
    assertTrue(buildViewElementDefinitionResult.getTransientPropertyClasses().isEmpty());
    assertTrue(buildViewElementDefinitionResult.getTransientPropertyMap().isEmpty());
    assertTrue(buildViewElementDefinitionResult.getTransientProperties().isEmpty());
    assertTrue(buildViewElementDefinitionResult.isAllProperties());
    assertArrayEquals(new byte[] {'{', '}'}, buildViewElementDefinitionResult.toCompactJson());
  }

  /**
   * Test {@link ViewMigration#prepareBuilder(ViewElementDefinition)}.
   *
   * <ul>
   *   <li>Then return {@link ViewMigration#ViewMigration(boolean)} with aggregateAfter is {@code
   *       true}.
   * </ul>
   *
   * <p>Method under test: {@link ViewMigration#prepareBuilder(ViewElementDefinition)}
   */
  @Test
  @DisplayName(
      "Test prepareBuilder(ViewElementDefinition); then return ViewMigration(boolean) with aggregateAfter is 'true'")
  @Tag("MaintainedByDiffblue")
  void testPrepareBuilder_thenReturnViewMigrationWithAggregateAfterIsTrue() {
    // Arrange
    ViewMigration viewMigration = new ViewMigration(true);
    ViewElementDefinition elementDef = new ViewElementDefinition();

    // Act
    ViewMigration actualPrepareBuilderResult = viewMigration.prepareBuilder(elementDef);

    // Assert
    assertEquals(elementDef, actualPrepareBuilderResult.buildViewElementDefinition());
    assertSame(viewMigration, actualPrepareBuilderResult);
  }

  /**
   * Test {@link ViewMigration#updatePreAggregationFilters(ViewElementDefinition)} with {@code
   * elementDef}.
   *
   * <p>Method under test: {@link ViewMigration#updatePreAggregationFilters(ViewElementDefinition)}
   */
  @Test
  @DisplayName("Test updatePreAggregationFilters(ViewElementDefinition) with 'elementDef'")
  @Tag("MaintainedByDiffblue")
  void testUpdatePreAggregationFiltersWithElementDef() {
    // Arrange
    ViewMigration viewMigration = new ViewMigration(true);
    ViewElementDefinition elementDef = new ViewElementDefinition();

    // Act
    ViewMigration actualUpdatePreAggregationFiltersResult =
        viewMigration.updatePreAggregationFilters(elementDef);

    // Assert
    assertEquals(elementDef, actualUpdatePreAggregationFiltersResult.buildViewElementDefinition());
    assertSame(viewMigration, actualUpdatePreAggregationFiltersResult);
  }

  /**
   * Test {@link ViewMigration#updatePreAggregationFilters(ElementFilter)} with {@code filter}.
   *
   * <p>Method under test: {@link ViewMigration#updatePreAggregationFilters(ElementFilter)}
   */
  @Test
  @DisplayName("Test updatePreAggregationFilters(ElementFilter) with 'filter'")
  @Tag("MaintainedByDiffblue")
  void testUpdatePreAggregationFiltersWithFilter() {
    // Arrange
    ViewMigration viewMigration = new ViewMigration(true);

    // Act
    ViewMigration actualUpdatePreAggregationFiltersResult =
        viewMigration.updatePreAggregationFilters(new ElementFilter());

    // Assert
    assertSame(viewMigration, actualUpdatePreAggregationFiltersResult);
  }

  /**
   * Test {@link ViewMigration#updatePreAggregationFilters(ElementTransformer,
   * ViewElementDefinition)} with {@code transformer}, {@code elementDef}.
   *
   * <p>Method under test: {@link ViewMigration#updatePreAggregationFilters(ElementTransformer,
   * ViewElementDefinition)}
   */
  @Test
  @DisplayName(
      "Test updatePreAggregationFilters(ElementTransformer, ViewElementDefinition) with 'transformer', 'elementDef'")
  @Tag("MaintainedByDiffblue")
  void testUpdatePreAggregationFiltersWithTransformerElementDef() {
    // Arrange
    ViewMigration viewMigration = new ViewMigration(true);
    ElementTransformer transformer = new ElementTransformer();
    ViewElementDefinition elementDef = new ViewElementDefinition();

    // Act
    ViewMigration actualUpdatePreAggregationFiltersResult =
        viewMigration.updatePreAggregationFilters(transformer, elementDef);

    // Assert
    assertEquals(elementDef, actualUpdatePreAggregationFiltersResult.buildViewElementDefinition());
    assertSame(viewMigration, actualUpdatePreAggregationFiltersResult);
  }

  /**
   * Test {@link ViewMigration#updatePreAggregationFilters(ElementTransformer, ElementFilter)} with
   * {@code transformer}, {@code filter}.
   *
   * <p>Method under test: {@link ViewMigration#updatePreAggregationFilters(ElementTransformer,
   * ElementFilter)}
   */
  @Test
  @DisplayName(
      "Test updatePreAggregationFilters(ElementTransformer, ElementFilter) with 'transformer', 'filter'")
  @Tag("MaintainedByDiffblue")
  void testUpdatePreAggregationFiltersWithTransformerFilter() {
    // Arrange
    ViewMigration viewMigration = new ViewMigration(true);
    ElementTransformer transformer = new ElementTransformer();

    LinkedList<TupleAdaptedPredicate<String, ?>> components = new LinkedList<>();
    components.add(new TupleAdaptedPredicate<>());

    ElementFilter filter = new ElementFilter();
    filter.setComponents(components);

    // Act and Assert
    ViewElementDefinition buildViewElementDefinitionResult =
        viewMigration.updatePreAggregationFilters(transformer, filter).buildViewElementDefinition();
    List<TupleAdaptedPredicate<String, ?>> preAggregationFilterFunctions =
        buildViewElementDefinitionResult.getPreAggregationFilterFunctions();
    assertEquals(1, preAggregationFilterFunctions.size());
    TupleAdaptedPredicate<String, ?> getResult = preAggregationFilterFunctions.get(0);
    Predicate<?> predicate = getResult.getPredicate();
    assertTrue(predicate instanceof TransformAndFilter);
    ElementTransformer transformer2 = ((TransformAndFilter) predicate).getTransformer();
    assertTrue(transformer2.getComponents().isEmpty());
    assertTrue(buildViewElementDefinitionResult.hasPreAggregationFilters());
    assertSame(filter, ((TransformAndFilter) predicate).getFilter());
    assertSame(transformer, transformer2);
    assertSame(
        preAggregationFilterFunctions,
        buildViewElementDefinitionResult.getPreAggregationFilter().getComponents());
    assertArrayEquals(new String[] {"ELEMENT"}, getResult.getInputAdapter().getSelection());
    assertArrayEquals(new String[] {"ELEMENT"}, getResult.getSelection());
  }

  /**
   * Test {@link ViewMigration#updatePreAggregationFilters(ElementTransformer, ElementFilter)} with
   * {@code transformer}, {@code filter}.
   *
   * <ul>
   *   <li>Given {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ViewMigration#updatePreAggregationFilters(ElementTransformer,
   * ElementFilter)}
   */
  @Test
  @DisplayName(
      "Test updatePreAggregationFilters(ElementTransformer, ElementFilter) with 'transformer', 'filter'; given 'null'")
  @Tag("MaintainedByDiffblue")
  void testUpdatePreAggregationFiltersWithTransformerFilter_givenNull() throws SchemaException {
    // Arrange
    ViewMigration viewMigration = new ViewMigration(true);
    ElementTransformer transformer = new ElementTransformer();

    ElementFilter filter = new ElementFilter();
    filter.setComponents(null);

    // Act and Assert
    ViewElementDefinition buildViewElementDefinitionResult =
        viewMigration.updatePreAggregationFilters(transformer, filter).buildViewElementDefinition();
    assertNull(buildViewElementDefinitionResult.getPreAggregationFilterFunctions());
    assertNull(buildViewElementDefinitionResult.getPreAggregationFilter());
    assertFalse(buildViewElementDefinitionResult.hasPreAggregationFilters());
    assertArrayEquals(new byte[] {'{', '}'}, buildViewElementDefinitionResult.toCompactJson());
  }

  /**
   * Test {@link ViewMigration#updatePreAggregationFilters(ElementTransformer, ElementFilter)} with
   * {@code transformer}, {@code filter}.
   *
   * <ul>
   *   <li>When {@link ElementFilter} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link ViewMigration#updatePreAggregationFilters(ElementTransformer,
   * ElementFilter)}
   */
  @Test
  @DisplayName(
      "Test updatePreAggregationFilters(ElementTransformer, ElementFilter) with 'transformer', 'filter'; when ElementFilter (default constructor)")
  @Tag("MaintainedByDiffblue")
  void testUpdatePreAggregationFiltersWithTransformerFilter_whenElementFilter()
      throws SchemaException {
    // Arrange
    ViewMigration viewMigration = new ViewMigration(true);
    ElementTransformer transformer = new ElementTransformer();

    // Act and Assert
    ViewElementDefinition buildViewElementDefinitionResult =
        viewMigration
            .updatePreAggregationFilters(transformer, new ElementFilter())
            .buildViewElementDefinition();
    assertNull(buildViewElementDefinitionResult.getPreAggregationFilterFunctions());
    assertNull(buildViewElementDefinitionResult.getPreAggregationFilter());
    assertFalse(buildViewElementDefinitionResult.hasPreAggregationFilters());
    assertArrayEquals(new byte[] {'{', '}'}, buildViewElementDefinitionResult.toCompactJson());
  }

  /**
   * Test {@link ViewMigration#updatePreAggregationFilters(ElementTransformer, ElementFilter)} with
   * {@code transformer}, {@code filter}.
   *
   * <ul>
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ViewMigration#updatePreAggregationFilters(ElementTransformer,
   * ElementFilter)}
   */
  @Test
  @DisplayName(
      "Test updatePreAggregationFilters(ElementTransformer, ElementFilter) with 'transformer', 'filter'; when 'null'")
  @Tag("MaintainedByDiffblue")
  void testUpdatePreAggregationFiltersWithTransformerFilter_whenNull() throws SchemaException {
    // Arrange
    ViewMigration viewMigration = new ViewMigration(true);

    // Act and Assert
    ViewElementDefinition buildViewElementDefinitionResult =
        viewMigration
            .updatePreAggregationFilters(new ElementTransformer(), (ElementFilter) null)
            .buildViewElementDefinition();
    assertNull(buildViewElementDefinitionResult.getPreAggregationFilterFunctions());
    assertNull(buildViewElementDefinitionResult.getPreAggregationFilter());
    assertFalse(buildViewElementDefinitionResult.hasPreAggregationFilters());
    assertArrayEquals(new byte[] {'{', '}'}, buildViewElementDefinitionResult.toCompactJson());
  }

  /**
   * Test {@link ViewMigration#updateAggregator(ElementAggregator)} with {@code aggregator}.
   *
   * <p>Method under test: {@link ViewMigration#updateAggregator(ElementAggregator)}
   */
  @Test
  @DisplayName("Test updateAggregator(ElementAggregator) with 'aggregator'")
  @Tag("MaintainedByDiffblue")
  void testUpdateAggregatorWithAggregator() {
    // Arrange
    ViewMigration viewMigration = new ViewMigration(true);

    // Act
    ViewMigration actualUpdateAggregatorResult =
        viewMigration.updateAggregator(new ElementAggregator());

    // Assert
    assertSame(viewMigration, actualUpdateAggregatorResult);
  }

  /**
   * Test {@link ViewMigration#updateAggregator(ViewElementDefinition)} with {@code elementDef}.
   *
   * <p>Method under test: {@link ViewMigration#updateAggregator(ViewElementDefinition)}
   */
  @Test
  @DisplayName("Test updateAggregator(ViewElementDefinition) with 'elementDef'")
  @Tag("MaintainedByDiffblue")
  void testUpdateAggregatorWithElementDef() {
    // Arrange
    ViewMigration viewMigration = new ViewMigration(true);
    ViewElementDefinition elementDef = new ViewElementDefinition();

    // Act
    ViewMigration actualUpdateAggregatorResult = viewMigration.updateAggregator(elementDef);

    // Assert
    assertEquals(elementDef, actualUpdateAggregatorResult.buildViewElementDefinition());
    assertSame(viewMigration, actualUpdateAggregatorResult);
  }

  /**
   * Test {@link ViewMigration#updatePostAggregationFilters(MigrateElement, String,
   * ViewElementDefinition)} with {@code migration}, {@code group}, {@code elementDef}.
   *
   * <p>Method under test: {@link ViewMigration#updatePostAggregationFilters(MigrateElement, String,
   * ViewElementDefinition)}
   */
  @Test
  @DisplayName(
      "Test updatePostAggregationFilters(MigrateElement, String, ViewElementDefinition) with 'migration', 'group', 'elementDef'")
  @Tag("MaintainedByDiffblue")
  void testUpdatePostAggregationFiltersWithMigrationGroupElementDef() {
    // Arrange
    ViewMigration viewMigration = new ViewMigration(true);
    MigrateElement migration = new MigrateElement();
    ViewElementDefinition elementDef = new ViewElementDefinition();

    // Act
    ViewMigration actualUpdatePostAggregationFiltersResult =
        viewMigration.updatePostAggregationFilters(migration, "Group", elementDef);

    // Assert
    assertEquals(elementDef, actualUpdatePostAggregationFiltersResult.buildViewElementDefinition());
    assertSame(viewMigration, actualUpdatePostAggregationFiltersResult);
  }

  /**
   * Test {@link ViewMigration#updatePostAggregationFilters(MigrateElement, String, ElementFilter)}
   * with {@code migration}, {@code group}, {@code filter}.
   *
   * <ul>
   *   <li>Given {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ViewMigration#updatePostAggregationFilters(MigrateElement, String,
   * ElementFilter)}
   */
  @Test
  @DisplayName(
      "Test updatePostAggregationFilters(MigrateElement, String, ElementFilter) with 'migration', 'group', 'filter'; given 'null'")
  @Tag("MaintainedByDiffblue")
  void testUpdatePostAggregationFiltersWithMigrationGroupFilter_givenNull() {
    // Arrange
    ViewMigration viewMigration = new ViewMigration(true);
    MigrateElement migration = new MigrateElement();

    ElementFilter filter = new ElementFilter();
    filter.setComponents(null);

    // Act
    ViewMigration actualUpdatePostAggregationFiltersResult =
        viewMigration.updatePostAggregationFilters(migration, "Group", filter);

    // Assert
    assertSame(viewMigration, actualUpdatePostAggregationFiltersResult);
  }

  /**
   * Test {@link ViewMigration#updatePostAggregationFilters(MigrateElement, String, ElementFilter)}
   * with {@code migration}, {@code group}, {@code filter}.
   *
   * <ul>
   *   <li>When {@link ElementFilter} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link ViewMigration#updatePostAggregationFilters(MigrateElement, String,
   * ElementFilter)}
   */
  @Test
  @DisplayName(
      "Test updatePostAggregationFilters(MigrateElement, String, ElementFilter) with 'migration', 'group', 'filter'; when ElementFilter (default constructor)")
  @Tag("MaintainedByDiffblue")
  void testUpdatePostAggregationFiltersWithMigrationGroupFilter_whenElementFilter() {
    // Arrange
    ViewMigration viewMigration = new ViewMigration(true);
    MigrateElement migration = new MigrateElement();

    // Act
    ViewMigration actualUpdatePostAggregationFiltersResult =
        viewMigration.updatePostAggregationFilters(migration, "Group", new ElementFilter());

    // Assert
    assertSame(viewMigration, actualUpdatePostAggregationFiltersResult);
  }

  /**
   * Test {@link ViewMigration#updatePostAggregationFilters(MigrateElement, String, ElementFilter)}
   * with {@code migration}, {@code group}, {@code filter}.
   *
   * <ul>
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ViewMigration#updatePostAggregationFilters(MigrateElement, String,
   * ElementFilter)}
   */
  @Test
  @DisplayName(
      "Test updatePostAggregationFilters(MigrateElement, String, ElementFilter) with 'migration', 'group', 'filter'; when 'null'")
  @Tag("MaintainedByDiffblue")
  void testUpdatePostAggregationFiltersWithMigrationGroupFilter_whenNull() {
    // Arrange
    ViewMigration viewMigration = new ViewMigration(true);

    // Act
    ViewMigration actualUpdatePostAggregationFiltersResult =
        viewMigration.updatePostAggregationFilters(
            new MigrateElement(), "Group", (ElementFilter) null);

    // Assert
    assertSame(viewMigration, actualUpdatePostAggregationFiltersResult);
  }

  /**
   * Test {@link ViewMigration#updatePostAggregationFilters(MigrateElement, String,
   * ElementTransformer, ViewElementDefinition)} with {@code migration}, {@code group}, {@code
   * transformer}, {@code elementDef}.
   *
   * <p>Method under test: {@link ViewMigration#updatePostAggregationFilters(MigrateElement, String,
   * ElementTransformer, ViewElementDefinition)}
   */
  @Test
  @DisplayName(
      "Test updatePostAggregationFilters(MigrateElement, String, ElementTransformer, ViewElementDefinition) with 'migration', 'group', 'transformer', 'elementDef'")
  @Tag("MaintainedByDiffblue")
  void testUpdatePostAggregationFiltersWithMigrationGroupTransformerElementDef() {
    // Arrange
    ViewMigration viewMigration = new ViewMigration(true);
    MigrateElement migration = new MigrateElement();
    ElementTransformer transformer = new ElementTransformer();
    ViewElementDefinition elementDef = new ViewElementDefinition();

    // Act
    ViewMigration actualUpdatePostAggregationFiltersResult =
        viewMigration.updatePostAggregationFilters(migration, "Group", transformer, elementDef);

    // Assert
    assertEquals(elementDef, actualUpdatePostAggregationFiltersResult.buildViewElementDefinition());
    assertSame(viewMigration, actualUpdatePostAggregationFiltersResult);
  }

  /**
   * Test {@link ViewMigration#updatePostAggregationFilters(MigrateElement, String,
   * ElementTransformer, ElementFilter)} with {@code migration}, {@code group}, {@code transformer},
   * {@code filter}.
   *
   * <p>Method under test: {@link ViewMigration#updatePostAggregationFilters(MigrateElement, String,
   * ElementTransformer, ElementFilter)}
   */
  @Test
  @DisplayName(
      "Test updatePostAggregationFilters(MigrateElement, String, ElementTransformer, ElementFilter) with 'migration', 'group', 'transformer', 'filter'")
  @Tag("MaintainedByDiffblue")
  void testUpdatePostAggregationFiltersWithMigrationGroupTransformerFilter() {
    // Arrange
    ViewMigration viewMigration = new ViewMigration(true);
    MigrateElement migration = new MigrateElement();
    ElementTransformer transformer = new ElementTransformer();

    // Act
    ViewMigration actualUpdatePostAggregationFiltersResult =
        viewMigration.updatePostAggregationFilters(
            migration, "Group", transformer, new ElementFilter());

    // Assert
    assertSame(viewMigration, actualUpdatePostAggregationFiltersResult);
  }

  /**
   * Test {@link ViewMigration#updatePostAggregationFilters(MigrateElement, String,
   * ElementTransformer, ElementFilter)} with {@code migration}, {@code group}, {@code transformer},
   * {@code filter}.
   *
   * <ul>
   *   <li>Given {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ViewMigration#updatePostAggregationFilters(MigrateElement, String,
   * ElementTransformer, ElementFilter)}
   */
  @Test
  @DisplayName(
      "Test updatePostAggregationFilters(MigrateElement, String, ElementTransformer, ElementFilter) with 'migration', 'group', 'transformer', 'filter'; given 'null'")
  @Tag("MaintainedByDiffblue")
  void testUpdatePostAggregationFiltersWithMigrationGroupTransformerFilter_givenNull() {
    // Arrange
    ViewMigration viewMigration = new ViewMigration(true);
    MigrateElement migration = new MigrateElement();
    ElementTransformer transformer = new ElementTransformer();

    ElementFilter filter = new ElementFilter();
    filter.setComponents(null);

    // Act
    ViewMigration actualUpdatePostAggregationFiltersResult =
        viewMigration.updatePostAggregationFilters(migration, "Group", transformer, filter);

    // Assert
    assertSame(viewMigration, actualUpdatePostAggregationFiltersResult);
  }

  /**
   * Test {@link ViewMigration#updatePostAggregationFilters(MigrateElement, String,
   * ElementTransformer, ElementFilter)} with {@code migration}, {@code group}, {@code transformer},
   * {@code filter}.
   *
   * <ul>
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ViewMigration#updatePostAggregationFilters(MigrateElement, String,
   * ElementTransformer, ElementFilter)}
   */
  @Test
  @DisplayName(
      "Test updatePostAggregationFilters(MigrateElement, String, ElementTransformer, ElementFilter) with 'migration', 'group', 'transformer', 'filter'; when 'null'")
  @Tag("MaintainedByDiffblue")
  void testUpdatePostAggregationFiltersWithMigrationGroupTransformerFilter_whenNull() {
    // Arrange
    ViewMigration viewMigration = new ViewMigration(true);
    MigrateElement migration = new MigrateElement();

    // Act
    ViewMigration actualUpdatePostAggregationFiltersResult =
        viewMigration.updatePostAggregationFilters(
            migration, "Group", new ElementTransformer(), (ElementFilter) null);

    // Assert
    assertSame(viewMigration, actualUpdatePostAggregationFiltersResult);
  }

  /**
   * Test {@link ViewMigration#updateTransformer(ElementType, String, ElementTransformer)} with
   * {@code migrationElementType}, {@code group}, {@code transformer}.
   *
   * <p>Method under test: {@link ViewMigration#updateTransformer(ElementType, String,
   * ElementTransformer)}
   */
  @Test
  @DisplayName(
      "Test updateTransformer(ElementType, String, ElementTransformer) with 'migrationElementType', 'group', 'transformer'")
  @Tag("MaintainedByDiffblue")
  void testUpdateTransformerWithMigrationElementTypeGroupTransformer() {
    // Arrange
    ViewMigration viewMigration = new ViewMigration(true);

    // Act
    ViewMigration actualUpdateTransformerResult =
        viewMigration.updateTransformer(ElementType.EDGE, "Group", new ElementTransformer());

    // Assert
    assertSame(viewMigration, actualUpdateTransformerResult);
  }

  /**
   * Test {@link ViewMigration#updateTransformer(ElementType, String, ElementTransformer)} with
   * {@code migrationElementType}, {@code group}, {@code transformer}.
   *
   * <p>Method under test: {@link ViewMigration#updateTransformer(ElementType, String,
   * ElementTransformer)}
   */
  @Test
  @DisplayName(
      "Test updateTransformer(ElementType, String, ElementTransformer) with 'migrationElementType', 'group', 'transformer'")
  @Tag("MaintainedByDiffblue")
  void testUpdateTransformerWithMigrationElementTypeGroupTransformer2() {
    // Arrange
    ViewMigration viewMigration = new ViewMigration(true);

    LinkedList<TupleAdaptedFunction<String, ?, ?>> components = new LinkedList<>();
    components.add(new TupleAdaptedFunction<>());

    ElementTransformer transformer = new ElementTransformer();
    transformer.setComponents(components);

    // Act
    ViewMigration actualUpdateTransformerResult =
        viewMigration.updateTransformer(ElementType.EDGE, "Group", transformer);

    // Assert
    assertSame(viewMigration, actualUpdateTransformerResult);
  }

  /**
   * Test {@link ViewMigration#updateTransformer(ElementType, String, ElementTransformer)} with
   * {@code migrationElementType}, {@code group}, {@code transformer}.
   *
   * <p>Method under test: {@link ViewMigration#updateTransformer(ElementType, String,
   * ElementTransformer)}
   */
  @Test
  @DisplayName(
      "Test updateTransformer(ElementType, String, ElementTransformer) with 'migrationElementType', 'group', 'transformer'")
  @Tag("MaintainedByDiffblue")
  void testUpdateTransformerWithMigrationElementTypeGroupTransformer3() {
    // Arrange
    ViewMigration viewMigration = new ViewMigration(false);

    LinkedList<TupleAdaptedFunction<String, ?, ?>> components = new LinkedList<>();
    components.add(new TupleAdaptedFunction<>());

    ElementTransformer transformer = new ElementTransformer();
    transformer.setComponents(components);

    // Act
    ViewMigration actualUpdateTransformerResult =
        viewMigration.updateTransformer(ElementType.EDGE, "Group", transformer);

    // Assert
    assertSame(viewMigration, actualUpdateTransformerResult);
  }

  /**
   * Test {@link ViewMigration#updateTransformer(ElementType, String, ElementTransformer)} with
   * {@code migrationElementType}, {@code group}, {@code transformer}.
   *
   * <ul>
   *   <li>Given {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ViewMigration#updateTransformer(ElementType, String,
   * ElementTransformer)}
   */
  @Test
  @DisplayName(
      "Test updateTransformer(ElementType, String, ElementTransformer) with 'migrationElementType', 'group', 'transformer'; given 'null'")
  @Tag("MaintainedByDiffblue")
  void testUpdateTransformerWithMigrationElementTypeGroupTransformer_givenNull() {
    // Arrange
    ViewMigration viewMigration = new ViewMigration(true);

    ElementTransformer transformer = new ElementTransformer();
    transformer.setComponents(null);

    // Act
    ViewMigration actualUpdateTransformerResult =
        viewMigration.updateTransformer(ElementType.EDGE, "Group", transformer);

    // Assert
    assertSame(viewMigration, actualUpdateTransformerResult);
  }

  /**
   * Test {@link ViewMigration#updateTransformer(ElementType, String, ElementTransformer)} with
   * {@code migrationElementType}, {@code group}, {@code transformer}.
   *
   * <ul>
   *   <li>When {@code ENTITY}.
   * </ul>
   *
   * <p>Method under test: {@link ViewMigration#updateTransformer(ElementType, String,
   * ElementTransformer)}
   */
  @Test
  @DisplayName(
      "Test updateTransformer(ElementType, String, ElementTransformer) with 'migrationElementType', 'group', 'transformer'; when 'ENTITY'")
  @Tag("MaintainedByDiffblue")
  void testUpdateTransformerWithMigrationElementTypeGroupTransformer_whenEntity() {
    // Arrange
    ViewMigration viewMigration = new ViewMigration(true);

    LinkedList<TupleAdaptedFunction<String, ?, ?>> components = new LinkedList<>();
    components.add(new TupleAdaptedFunction<>());

    ElementTransformer transformer = new ElementTransformer();
    transformer.setComponents(components);

    // Act
    ViewMigration actualUpdateTransformerResult =
        viewMigration.updateTransformer(ElementType.ENTITY, "Group", transformer);

    // Assert
    assertSame(viewMigration, actualUpdateTransformerResult);
  }

  /**
   * Test {@link ViewMigration#updateTransformer(ElementType, String, ElementTransformer)} with
   * {@code migrationElementType}, {@code group}, {@code transformer}.
   *
   * <ul>
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ViewMigration#updateTransformer(ElementType, String,
   * ElementTransformer)}
   */
  @Test
  @DisplayName(
      "Test updateTransformer(ElementType, String, ElementTransformer) with 'migrationElementType', 'group', 'transformer'; when 'null'")
  @Tag("MaintainedByDiffblue")
  void testUpdateTransformerWithMigrationElementTypeGroupTransformer_whenNull() {
    // Arrange
    ViewMigration viewMigration = new ViewMigration(true);

    // Act
    ViewMigration actualUpdateTransformerResult =
        viewMigration.updateTransformer(ElementType.EDGE, "Group", null);

    // Assert
    assertSame(viewMigration, actualUpdateTransformerResult);
  }

  /**
   * Test {@link ViewMigration#updateTransformer(MigrateElement, String, ElementTransformer,
   * ViewElementDefinition)} with {@code migration}, {@code group}, {@code migrationTransform},
   * {@code elementDef}.
   *
   * <p>Method under test: {@link ViewMigration#updateTransformer(MigrateElement, String,
   * ElementTransformer, ViewElementDefinition)}
   */
  @Test
  @DisplayName(
      "Test updateTransformer(MigrateElement, String, ElementTransformer, ViewElementDefinition) with 'migration', 'group', 'migrationTransform', 'elementDef'")
  @Tag("MaintainedByDiffblue")
  void testUpdateTransformerWithMigrationGroupMigrationTransformElementDef() {
    // Arrange
    ViewMigration viewMigration = new ViewMigration(true);
    MigrateElement migration = new MigrateElement();
    ElementTransformer migrationTransform = new ElementTransformer();

    // Act
    ViewMigration actualUpdateTransformerResult =
        viewMigration.updateTransformer(
            migration, "Group", migrationTransform, new ViewElementDefinition());

    // Assert
    assertSame(viewMigration, actualUpdateTransformerResult);
  }

  /**
   * Test {@link ViewMigration#updateTransformer(MigrateElement, String, ElementTransformer,
   * ElementTransformer)} with {@code migration}, {@code group}, {@code migrationTransform}, {@code
   * userTransform}.
   *
   * <p>Method under test: {@link ViewMigration#updateTransformer(MigrateElement, String,
   * ElementTransformer, ElementTransformer)}
   */
  @Test
  @DisplayName(
      "Test updateTransformer(MigrateElement, String, ElementTransformer, ElementTransformer) with 'migration', 'group', 'migrationTransform', 'userTransform'")
  @Tag("MaintainedByDiffblue")
  void testUpdateTransformerWithMigrationGroupMigrationTransformUserTransform() {
    // Arrange
    ViewMigration viewMigration = new ViewMigration(true);
    MigrateElement migration = new MigrateElement();
    ElementTransformer migrationTransform = new ElementTransformer();

    // Act
    ViewMigration actualUpdateTransformerResult =
        viewMigration.updateTransformer(
            migration, "Group", migrationTransform, new ElementTransformer());

    // Assert
    assertSame(viewMigration, actualUpdateTransformerResult);
  }

  /**
   * Test {@link ViewMigration#updateTransformer(MigrateElement, String, ElementTransformer,
   * ElementTransformer)} with {@code migration}, {@code group}, {@code migrationTransform}, {@code
   * userTransform}.
   *
   * <p>Method under test: {@link ViewMigration#updateTransformer(MigrateElement, String,
   * ElementTransformer, ElementTransformer)}
   */
  @Test
  @DisplayName(
      "Test updateTransformer(MigrateElement, String, ElementTransformer, ElementTransformer) with 'migration', 'group', 'migrationTransform', 'userTransform'")
  @Tag("MaintainedByDiffblue")
  void testUpdateTransformerWithMigrationGroupMigrationTransformUserTransform2() {
    // Arrange
    ViewMigration viewMigration = new ViewMigration(true);
    MigrateElement migration = new MigrateElement();
    ElementTransformer migrationTransform = new ElementTransformer();

    ElementTransformer userTransform = new ElementTransformer();
    userTransform.setComponents(null);

    // Act
    ViewMigration actualUpdateTransformerResult =
        viewMigration.updateTransformer(migration, "Group", migrationTransform, userTransform);

    // Assert
    assertSame(viewMigration, actualUpdateTransformerResult);
  }

  /**
   * Test {@link ViewMigration#updateTransformer(MigrateElement, String, ElementTransformer,
   * ElementTransformer)} with {@code migration}, {@code group}, {@code migrationTransform}, {@code
   * userTransform}.
   *
   * <p>Method under test: {@link ViewMigration#updateTransformer(MigrateElement, String,
   * ElementTransformer, ElementTransformer)}
   */
  @Test
  @DisplayName(
      "Test updateTransformer(MigrateElement, String, ElementTransformer, ElementTransformer) with 'migration', 'group', 'migrationTransform', 'userTransform'")
  @Tag("MaintainedByDiffblue")
  void testUpdateTransformerWithMigrationGroupMigrationTransformUserTransform3() {
    // Arrange
    ViewMigration viewMigration = new ViewMigration(true);
    MigrateElement migration = new MigrateElement();

    ElementTransformer migrationTransform = new Builder().build();
    migrationTransform.setComponents(null);

    // Act
    ViewMigration actualUpdateTransformerResult =
        viewMigration.updateTransformer(
            migration, "Group", migrationTransform, new ElementTransformer());

    // Assert
    assertSame(viewMigration, actualUpdateTransformerResult);
  }

  /**
   * Test {@link ViewMigration#updateTransformer(MigrateElement, String, ElementTransformer,
   * ElementTransformer)} with {@code migration}, {@code group}, {@code migrationTransform}, {@code
   * userTransform}.
   *
   * <ul>
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ViewMigration#updateTransformer(MigrateElement, String,
   * ElementTransformer, ElementTransformer)}
   */
  @Test
  @DisplayName(
      "Test updateTransformer(MigrateElement, String, ElementTransformer, ElementTransformer) with 'migration', 'group', 'migrationTransform', 'userTransform'; when 'null'")
  @Tag("MaintainedByDiffblue")
  void testUpdateTransformerWithMigrationGroupMigrationTransformUserTransform_whenNull() {
    // Arrange
    ViewMigration viewMigration = new ViewMigration(true);
    MigrateElement migration = new MigrateElement();

    // Act
    ViewMigration actualUpdateTransformerResult =
        viewMigration.updateTransformer(
            migration, "Group", new ElementTransformer(), (ElementTransformer) null);

    // Assert
    assertSame(viewMigration, actualUpdateTransformerResult);
  }

  /**
   * Test {@link ViewMigration#updatePostTransformFilters(MigrateElement, String,
   * ViewElementDefinition)} with {@code migration}, {@code group}, {@code elementDef}.
   *
   * <p>Method under test: {@link ViewMigration#updatePostTransformFilters(MigrateElement, String,
   * ViewElementDefinition)}
   */
  @Test
  @DisplayName(
      "Test updatePostTransformFilters(MigrateElement, String, ViewElementDefinition) with 'migration', 'group', 'elementDef'")
  @Tag("MaintainedByDiffblue")
  void testUpdatePostTransformFiltersWithMigrationGroupElementDef() {
    // Arrange
    ViewMigration viewMigration = new ViewMigration(true);
    MigrateElement migration = new MigrateElement();
    ViewElementDefinition elementDef = new ViewElementDefinition();

    // Act
    ViewMigration actualUpdatePostTransformFiltersResult =
        viewMigration.updatePostTransformFilters(migration, "Group", elementDef);

    // Assert
    assertEquals(elementDef, actualUpdatePostTransformFiltersResult.buildViewElementDefinition());
    assertSame(viewMigration, actualUpdatePostTransformFiltersResult);
  }

  /**
   * Test {@link ViewMigration#updatePostTransformFilters(MigrateElement, String, ElementFilter)}
   * with {@code migration}, {@code group}, {@code filter}.
   *
   * <ul>
   *   <li>Given {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ViewMigration#updatePostTransformFilters(MigrateElement, String,
   * ElementFilter)}
   */
  @Test
  @DisplayName(
      "Test updatePostTransformFilters(MigrateElement, String, ElementFilter) with 'migration', 'group', 'filter'; given 'null'")
  @Tag("MaintainedByDiffblue")
  void testUpdatePostTransformFiltersWithMigrationGroupFilter_givenNull() {
    // Arrange
    ViewMigration viewMigration = new ViewMigration(true);
    MigrateElement migration = new MigrateElement();

    ElementFilter filter = new ElementFilter();
    filter.setComponents(null);

    // Act
    ViewMigration actualUpdatePostTransformFiltersResult =
        viewMigration.updatePostTransformFilters(migration, "Group", filter);

    // Assert
    assertSame(viewMigration, actualUpdatePostTransformFiltersResult);
  }

  /**
   * Test {@link ViewMigration#updatePostTransformFilters(MigrateElement, String, ElementFilter)}
   * with {@code migration}, {@code group}, {@code filter}.
   *
   * <ul>
   *   <li>When {@link ElementFilter} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link ViewMigration#updatePostTransformFilters(MigrateElement, String,
   * ElementFilter)}
   */
  @Test
  @DisplayName(
      "Test updatePostTransformFilters(MigrateElement, String, ElementFilter) with 'migration', 'group', 'filter'; when ElementFilter (default constructor)")
  @Tag("MaintainedByDiffblue")
  void testUpdatePostTransformFiltersWithMigrationGroupFilter_whenElementFilter() {
    // Arrange
    ViewMigration viewMigration = new ViewMigration(true);
    MigrateElement migration = new MigrateElement();

    // Act
    ViewMigration actualUpdatePostTransformFiltersResult =
        viewMigration.updatePostTransformFilters(migration, "Group", new ElementFilter());

    // Assert
    assertSame(viewMigration, actualUpdatePostTransformFiltersResult);
  }

  /**
   * Test {@link ViewMigration#updatePostTransformFilters(MigrateElement, String, ElementFilter)}
   * with {@code migration}, {@code group}, {@code filter}.
   *
   * <ul>
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ViewMigration#updatePostTransformFilters(MigrateElement, String,
   * ElementFilter)}
   */
  @Test
  @DisplayName(
      "Test updatePostTransformFilters(MigrateElement, String, ElementFilter) with 'migration', 'group', 'filter'; when 'null'")
  @Tag("MaintainedByDiffblue")
  void testUpdatePostTransformFiltersWithMigrationGroupFilter_whenNull() {
    // Arrange
    ViewMigration viewMigration = new ViewMigration(true);

    // Act
    ViewMigration actualUpdatePostTransformFiltersResult =
        viewMigration.updatePostTransformFilters(
            new MigrateElement(), "Group", (ElementFilter) null);

    // Assert
    assertSame(viewMigration, actualUpdatePostTransformFiltersResult);
  }

  /**
   * Test {@link ViewMigration#updatePostTransformFilters(MigrateElement, String,
   * ElementTransformer, ViewElementDefinition)} with {@code migration}, {@code group}, {@code
   * transformer}, {@code elementDef}.
   *
   * <p>Method under test: {@link ViewMigration#updatePostTransformFilters(MigrateElement, String,
   * ElementTransformer, ViewElementDefinition)}
   */
  @Test
  @DisplayName(
      "Test updatePostTransformFilters(MigrateElement, String, ElementTransformer, ViewElementDefinition) with 'migration', 'group', 'transformer', 'elementDef'")
  @Tag("MaintainedByDiffblue")
  void testUpdatePostTransformFiltersWithMigrationGroupTransformerElementDef() {
    // Arrange
    ViewMigration viewMigration = new ViewMigration(true);
    ElementTransformer toNewTransform = new Builder().build();
    ElementTransformer toOldTransform = new Builder().build();

    MigrateElement migration =
        new MigrateElement(ElementType.EDGE, "ELEMENT", "ELEMENT", toNewTransform, toOldTransform);
    ElementTransformer transformer = new ElementTransformer();
    ViewElementDefinition elementDef = new ViewElementDefinition();

    // Act
    ViewMigration actualUpdatePostTransformFiltersResult =
        viewMigration.updatePostTransformFilters(migration, "Group", transformer, elementDef);

    // Assert
    assertEquals(elementDef, actualUpdatePostTransformFiltersResult.buildViewElementDefinition());
    assertSame(viewMigration, actualUpdatePostTransformFiltersResult);
  }

  /**
   * Test {@link ViewMigration#updatePostTransformFilters(MigrateElement, String,
   * ElementTransformer, ViewElementDefinition)} with {@code migration}, {@code group}, {@code
   * transformer}, {@code elementDef}.
   *
   * <p>Method under test: {@link ViewMigration#updatePostTransformFilters(MigrateElement, String,
   * ElementTransformer, ViewElementDefinition)}
   */
  @Test
  @DisplayName(
      "Test updatePostTransformFilters(MigrateElement, String, ElementTransformer, ViewElementDefinition) with 'migration', 'group', 'transformer', 'elementDef'")
  @Tag("MaintainedByDiffblue")
  void testUpdatePostTransformFiltersWithMigrationGroupTransformerElementDef2() {
    // Arrange
    ViewMigration viewMigration = new ViewMigration(false);
    ElementTransformer toNewTransform = new Builder().build();
    ElementTransformer toOldTransform = new Builder().build();

    MigrateElement migration =
        new MigrateElement(ElementType.EDGE, "ELEMENT", "ELEMENT", toNewTransform, toOldTransform);
    ElementTransformer transformer = new ElementTransformer();

    // Act
    ViewMigration actualUpdatePostTransformFiltersResult =
        viewMigration.updatePostTransformFilters(
            migration, "Group", transformer, new ViewElementDefinition());

    // Assert
    assertSame(viewMigration, actualUpdatePostTransformFiltersResult);
  }

  /**
   * Test {@link ViewMigration#updatePostTransformFilters(MigrateElement, String,
   * ElementTransformer, ViewElementDefinition)} with {@code migration}, {@code group}, {@code
   * transformer}, {@code elementDef}.
   *
   * <p>Method under test: {@link ViewMigration#updatePostTransformFilters(MigrateElement, String,
   * ElementTransformer, ViewElementDefinition)}
   */
  @Test
  @DisplayName(
      "Test updatePostTransformFilters(MigrateElement, String, ElementTransformer, ViewElementDefinition) with 'migration', 'group', 'transformer', 'elementDef'")
  @Tag("MaintainedByDiffblue")
  void testUpdatePostTransformFiltersWithMigrationGroupTransformerElementDef3() {
    // Arrange
    ViewMigration viewMigration = new ViewMigration(true);
    ElementTransformer toNewTransform = new Builder().build();
    ElementTransformer toOldTransform = new Builder().build();

    MigrateElement migration =
        new MigrateElement(
            ElementType.ENTITY, "ELEMENT", "ELEMENT", toNewTransform, toOldTransform);
    ElementTransformer transformer = new ElementTransformer();
    ViewElementDefinition elementDef = new ViewElementDefinition();

    // Act
    ViewMigration actualUpdatePostTransformFiltersResult =
        viewMigration.updatePostTransformFilters(migration, "Group", transformer, elementDef);

    // Assert
    assertEquals(elementDef, actualUpdatePostTransformFiltersResult.buildViewElementDefinition());
    assertSame(viewMigration, actualUpdatePostTransformFiltersResult);
  }

  /**
   * Test {@link ViewMigration#updatePostTransformFilters(MigrateElement, String,
   * ElementTransformer, ElementFilter)} with {@code migration}, {@code group}, {@code transformer},
   * {@code filter}.
   *
   * <p>Method under test: {@link ViewMigration#updatePostTransformFilters(MigrateElement, String,
   * ElementTransformer, ElementFilter)}
   */
  @Test
  @DisplayName(
      "Test updatePostTransformFilters(MigrateElement, String, ElementTransformer, ElementFilter) with 'migration', 'group', 'transformer', 'filter'")
  @Tag("MaintainedByDiffblue")
  void testUpdatePostTransformFiltersWithMigrationGroupTransformerFilter() {
    // Arrange
    ViewMigration viewMigration = new ViewMigration(true);
    ElementTransformer toNewTransform = new Builder().build();
    ElementTransformer toOldTransform = new Builder().build();

    MigrateElement migration =
        new MigrateElement(ElementType.EDGE, "ELEMENT", "ELEMENT", toNewTransform, toOldTransform);
    ElementTransformer transformer = new ElementTransformer();

    // Act
    ViewMigration actualUpdatePostTransformFiltersResult =
        viewMigration.updatePostTransformFilters(
            migration, "Group", transformer, new ElementFilter());

    // Assert
    assertSame(viewMigration, actualUpdatePostTransformFiltersResult);
  }

  /**
   * Test {@link ViewMigration#updatePostTransformFilters(MigrateElement, String,
   * ElementTransformer, ElementFilter)} with {@code migration}, {@code group}, {@code transformer},
   * {@code filter}.
   *
   * <p>Method under test: {@link ViewMigration#updatePostTransformFilters(MigrateElement, String,
   * ElementTransformer, ElementFilter)}
   */
  @Test
  @DisplayName(
      "Test updatePostTransformFilters(MigrateElement, String, ElementTransformer, ElementFilter) with 'migration', 'group', 'transformer', 'filter'")
  @Tag("MaintainedByDiffblue")
  void testUpdatePostTransformFiltersWithMigrationGroupTransformerFilter2() {
    // Arrange
    ViewMigration viewMigration = new ViewMigration(false);
    ElementTransformer toNewTransform = new Builder().build();
    ElementTransformer toOldTransform = new Builder().build();

    MigrateElement migration =
        new MigrateElement(ElementType.EDGE, "ELEMENT", "ELEMENT", toNewTransform, toOldTransform);
    ElementTransformer transformer = new ElementTransformer();

    // Act
    ViewMigration actualUpdatePostTransformFiltersResult =
        viewMigration.updatePostTransformFilters(
            migration, "Group", transformer, new ElementFilter());

    // Assert
    assertSame(viewMigration, actualUpdatePostTransformFiltersResult);
  }

  /**
   * Test {@link ViewMigration#updatePostTransformFilters(MigrateElement, String,
   * ElementTransformer, ElementFilter)} with {@code migration}, {@code group}, {@code transformer},
   * {@code filter}.
   *
   * <p>Method under test: {@link ViewMigration#updatePostTransformFilters(MigrateElement, String,
   * ElementTransformer, ElementFilter)}
   */
  @Test
  @DisplayName(
      "Test updatePostTransformFilters(MigrateElement, String, ElementTransformer, ElementFilter) with 'migration', 'group', 'transformer', 'filter'")
  @Tag("MaintainedByDiffblue")
  void testUpdatePostTransformFiltersWithMigrationGroupTransformerFilter3() {
    // Arrange
    ViewMigration viewMigration = new ViewMigration(true);
    ElementTransformer toNewTransform = new Builder().build();
    ElementTransformer toOldTransform = new Builder().build();

    MigrateElement migration =
        new MigrateElement(
            ElementType.ENTITY, "ELEMENT", "ELEMENT", toNewTransform, toOldTransform);
    ElementTransformer transformer = new ElementTransformer();

    // Act
    ViewMigration actualUpdatePostTransformFiltersResult =
        viewMigration.updatePostTransformFilters(
            migration, "Group", transformer, new ElementFilter());

    // Assert
    assertSame(viewMigration, actualUpdatePostTransformFiltersResult);
  }

  /**
   * Test {@link ViewMigration#buildViewElementDefinition()}.
   *
   * <p>Method under test: {@link ViewMigration#buildViewElementDefinition()}
   */
  @Test
  @DisplayName("Test buildViewElementDefinition()")
  @Tag("MaintainedByDiffblue")
  void testBuildViewElementDefinition() throws SchemaException {
    // Arrange and Act
    ViewElementDefinition actualBuildViewElementDefinitionResult =
        new ViewMigration(true).buildViewElementDefinition();

    // Assert
    assertNull(actualBuildViewElementDefinitionResult.getTransformFunctions());
    assertNull(actualBuildViewElementDefinitionResult.getPostAggregationFilterFunctions());
    assertNull(actualBuildViewElementDefinitionResult.getPostTransformFilterFunctions());
    assertNull(actualBuildViewElementDefinitionResult.getPreAggregationFilterFunctions());
    assertNull(actualBuildViewElementDefinitionResult.getTransientPropertyMapWithClassNames());
    assertNull(actualBuildViewElementDefinitionResult.getExcludeProperties());
    assertNull(actualBuildViewElementDefinitionResult.getGroupBy());
    assertNull(actualBuildViewElementDefinitionResult.getProperties());
    assertNull(actualBuildViewElementDefinitionResult.getAggregator());
    assertNull(actualBuildViewElementDefinitionResult.getPostAggregationFilter());
    assertNull(actualBuildViewElementDefinitionResult.getPostTransformFilter());
    assertNull(actualBuildViewElementDefinitionResult.getPreAggregationFilter());
    assertNull(actualBuildViewElementDefinitionResult.getTransformer());
    assertFalse(actualBuildViewElementDefinitionResult.hasPostAggregationFilters());
    assertFalse(actualBuildViewElementDefinitionResult.hasPostTransformFilters());
    assertFalse(actualBuildViewElementDefinitionResult.hasPreAggregationFilters());
    assertFalse(actualBuildViewElementDefinitionResult.hasTransform());
    assertFalse(actualBuildViewElementDefinitionResult.isEmpty());
    assertTrue(actualBuildViewElementDefinitionResult.getTransientPropertyClasses().isEmpty());
    assertTrue(actualBuildViewElementDefinitionResult.getTransientPropertyMap().isEmpty());
    assertTrue(actualBuildViewElementDefinitionResult.getTransientProperties().isEmpty());
    assertTrue(actualBuildViewElementDefinitionResult.isAllProperties());
    assertArrayEquals(
        new byte[] {'{', '}'}, actualBuildViewElementDefinitionResult.toCompactJson());
  }
}
