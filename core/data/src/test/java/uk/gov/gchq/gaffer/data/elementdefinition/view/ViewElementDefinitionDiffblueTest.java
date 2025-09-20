package uk.gov.gchq.gaffer.data.elementdefinition.view;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.data.element.function.ElementAggregator;
import uk.gov.gchq.gaffer.data.element.function.ElementFilter;
import uk.gov.gchq.gaffer.data.element.function.ElementTransformer;
import uk.gov.gchq.gaffer.data.elementdefinition.exception.SchemaException;
import uk.gov.gchq.gaffer.data.elementdefinition.view.GlobalViewElementDefinition.Builder;
import uk.gov.gchq.gaffer.data.elementdefinition.view.ViewElementDefinition.BaseBuilder;
import uk.gov.gchq.koryphe.tuple.function.TupleAdaptedFunction;
import uk.gov.gchq.koryphe.tuple.predicate.TupleAdaptedPredicate;

class ViewElementDefinitionDiffblueTest {
  /**
   * Test BaseBuilder {@link BaseBuilder#addTransformFunctions(List)}.
   *
   * <p>Method under test: {@link BaseBuilder#addTransformFunctions(List)}
   */
  @Test
  @DisplayName("Test BaseBuilder addTransformFunctions(List)")
  @Tag("MaintainedByDiffblue")
  void testBaseBuilderAddTransformFunctions() {
    // Arrange
    Builder builder = new Builder();

    ArrayList<TupleAdaptedFunction<String, ?, ?>> transformFunctions = new ArrayList<>();
    transformFunctions.add(new TupleAdaptedFunction<>());
    TupleAdaptedFunction<String, ?, ?> tupleAdaptedFunction = new TupleAdaptedFunction<>();
    transformFunctions.add(tupleAdaptedFunction);

    // Act and Assert
    List<TupleAdaptedFunction<String, ?, ?>> transformFunctions2 =
        builder.addTransformFunctions(transformFunctions).getElementDef().getTransformFunctions();
    assertEquals(2, transformFunctions2.size());
    assertSame(tupleAdaptedFunction, transformFunctions2.get(1));
  }

  /**
   * Test BaseBuilder {@link BaseBuilder#addTransformFunctions(List)}.
   *
   * <ul>
   *   <li>Then return ElementDef hasTransform.
   * </ul>
   *
   * <p>Method under test: {@link BaseBuilder#addTransformFunctions(List)}
   */
  @Test
  @DisplayName("Test BaseBuilder addTransformFunctions(List); then return ElementDef hasTransform")
  @Tag("MaintainedByDiffblue")
  void testBaseBuilderAddTransformFunctions_thenReturnElementDefHasTransform() {
    // Arrange
    Builder builder = new Builder();

    ArrayList<TupleAdaptedFunction<String, ?, ?>> transformFunctions = new ArrayList<>();
    transformFunctions.add(new TupleAdaptedFunction<>());

    // Act and Assert
    GlobalViewElementDefinition elementDef =
        builder.addTransformFunctions(transformFunctions).getElementDef();
    assertTrue(elementDef.hasTransform());
    assertEquals(transformFunctions, elementDef.getTransformFunctions());
  }

  /**
   * Test BaseBuilder {@link BaseBuilder#aggregator(ElementAggregator)}.
   *
   * <p>Method under test: {@link BaseBuilder#aggregator(ElementAggregator)}
   */
  @Test
  @DisplayName("Test BaseBuilder aggregator(ElementAggregator)")
  @Tag("MaintainedByDiffblue")
  void testBaseBuilderAggregator() {
    // Arrange
    Builder builder = new Builder();

    // Act
    Builder actualAggregatorResult = builder.aggregator(new ElementAggregator());

    // Assert
    assertSame(builder, actualAggregatorResult);
  }

  /**
   * Test BaseBuilder {@link BaseBuilder#allProperties()}.
   *
   * <p>Method under test: {@link BaseBuilder#allProperties()}
   */
  @Test
  @DisplayName("Test BaseBuilder allProperties()")
  @Tag("MaintainedByDiffblue")
  void testBaseBuilderAllProperties() {
    // Arrange
    Builder builder = new Builder();

    // Act
    Builder actualAllPropertiesResult = builder.allProperties();

    // Assert
    assertSame(builder, actualAllPropertiesResult);
  }

  /**
   * Test BaseBuilder {@link BaseBuilder#clearAggregator()}.
   *
   * <p>Method under test: {@link BaseBuilder#clearAggregator()}
   */
  @Test
  @DisplayName("Test BaseBuilder clearAggregator()")
  @Tag("MaintainedByDiffblue")
  void testBaseBuilderClearAggregator() {
    // Arrange
    Builder builder = new Builder();

    // Act
    Builder actualClearAggregatorResult = builder.clearAggregator();

    // Assert
    assertSame(builder, actualClearAggregatorResult);
  }

  /**
   * Test BaseBuilder {@link BaseBuilder#clearFunctions()}.
   *
   * <p>Method under test: {@link BaseBuilder#clearFunctions()}
   */
  @Test
  @DisplayName("Test BaseBuilder clearFunctions()")
  @Tag("MaintainedByDiffblue")
  void testBaseBuilderClearFunctions() {
    // Arrange
    Builder builder = new Builder();

    // Act
    Builder actualClearFunctionsResult = builder.clearFunctions();

    // Assert
    assertSame(builder, actualClearFunctionsResult);
  }

  /**
   * Test BaseBuilder {@link BaseBuilder#clearPostAggregationFilter()}.
   *
   * <p>Method under test: {@link BaseBuilder#clearPostAggregationFilter()}
   */
  @Test
  @DisplayName("Test BaseBuilder clearPostAggregationFilter()")
  @Tag("MaintainedByDiffblue")
  void testBaseBuilderClearPostAggregationFilter() {
    // Arrange
    Builder builder = new Builder();

    // Act
    Builder actualClearPostAggregationFilterResult = builder.clearPostAggregationFilter();

    // Assert
    assertSame(builder, actualClearPostAggregationFilterResult);
  }

  /**
   * Test BaseBuilder {@link BaseBuilder#clearPostTransformFilter()}.
   *
   * <p>Method under test: {@link BaseBuilder#clearPostTransformFilter()}
   */
  @Test
  @DisplayName("Test BaseBuilder clearPostTransformFilter()")
  @Tag("MaintainedByDiffblue")
  void testBaseBuilderClearPostTransformFilter() {
    // Arrange
    Builder builder = new Builder();

    // Act
    Builder actualClearPostTransformFilterResult = builder.clearPostTransformFilter();

    // Assert
    assertSame(builder, actualClearPostTransformFilterResult);
  }

  /**
   * Test BaseBuilder {@link BaseBuilder#clearPreAggregationFilter()}.
   *
   * <p>Method under test: {@link BaseBuilder#clearPreAggregationFilter()}
   */
  @Test
  @DisplayName("Test BaseBuilder clearPreAggregationFilter()")
  @Tag("MaintainedByDiffblue")
  void testBaseBuilderClearPreAggregationFilter() {
    // Arrange
    Builder builder = new Builder();

    // Act
    Builder actualClearPreAggregationFilterResult = builder.clearPreAggregationFilter();

    // Assert
    assertSame(builder, actualClearPreAggregationFilterResult);
  }

  /**
   * Test BaseBuilder {@link BaseBuilder#clearTransform()}.
   *
   * <p>Method under test: {@link BaseBuilder#clearTransform()}
   */
  @Test
  @DisplayName("Test BaseBuilder clearTransform()")
  @Tag("MaintainedByDiffblue")
  void testBaseBuilderClearTransform() {
    // Arrange
    Builder builder = new Builder();

    // Act
    Builder actualClearTransformResult = builder.clearTransform();

    // Assert
    assertSame(builder, actualClearTransformResult);
  }

  /**
   * Test BaseBuilder {@link BaseBuilder#excludeProperties(Set)} with {@code Set}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link HashSet#HashSet()} add {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link BaseBuilder#excludeProperties(Set)}
   */
  @Test
  @DisplayName(
      "Test BaseBuilder excludeProperties(Set) with 'Set'; given '42'; when HashSet() add '42'")
  @Tag("MaintainedByDiffblue")
  void testBaseBuilderExcludePropertiesWithSet_given42_whenHashSetAdd42() {
    // Arrange
    Builder builder = new Builder();

    HashSet<String> excludeProperties = new HashSet<>();
    excludeProperties.add("42");
    excludeProperties.add("foo");

    // Act
    Builder actualExcludePropertiesResult = builder.excludeProperties(excludeProperties);

    // Assert
    assertSame(builder, actualExcludePropertiesResult);
  }

  /**
   * Test BaseBuilder {@link BaseBuilder#excludeProperties(Set)} with {@code Set}.
   *
   * <ul>
   *   <li>Given {@code foo}.
   *   <li>When {@link HashSet#HashSet()} add {@code foo}.
   * </ul>
   *
   * <p>Method under test: {@link BaseBuilder#excludeProperties(Set)}
   */
  @Test
  @DisplayName(
      "Test BaseBuilder excludeProperties(Set) with 'Set'; given 'foo'; when HashSet() add 'foo'")
  @Tag("MaintainedByDiffblue")
  void testBaseBuilderExcludePropertiesWithSet_givenFoo_whenHashSetAddFoo() {
    // Arrange
    Builder builder = new Builder();

    HashSet<String> excludeProperties = new HashSet<>();
    excludeProperties.add("foo");

    // Act
    Builder actualExcludePropertiesResult = builder.excludeProperties(excludeProperties);

    // Assert
    assertSame(builder, actualExcludePropertiesResult);
  }

  /**
   * Test BaseBuilder {@link BaseBuilder#excludeProperties(Set)} with {@code Set}.
   *
   * <ul>
   *   <li>When {@link HashSet#HashSet()}.
   * </ul>
   *
   * <p>Method under test: {@link BaseBuilder#excludeProperties(Set)}
   */
  @Test
  @DisplayName("Test BaseBuilder excludeProperties(Set) with 'Set'; when HashSet()")
  @Tag("MaintainedByDiffblue")
  void testBaseBuilderExcludePropertiesWithSet_whenHashSet() {
    // Arrange
    Builder builder = new Builder();

    // Act
    Builder actualExcludePropertiesResult = builder.excludeProperties(new HashSet<>());

    // Assert
    assertSame(builder, actualExcludePropertiesResult);
  }

  /**
   * Test BaseBuilder {@link BaseBuilder#excludeProperties(Set)} with {@code Set}.
   *
   * <ul>
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link BaseBuilder#excludeProperties(Set)}
   */
  @Test
  @DisplayName("Test BaseBuilder excludeProperties(Set) with 'Set'; when 'null'")
  @Tag("MaintainedByDiffblue")
  void testBaseBuilderExcludePropertiesWithSet_whenNull() {
    // Arrange
    Builder builder = new Builder();

    // Act
    Builder actualExcludePropertiesResult = builder.excludeProperties((Set<String>) null);

    // Assert
    assertSame(builder, actualExcludePropertiesResult);
  }

  /**
   * Test BaseBuilder {@link BaseBuilder#excludeProperties(String[])} with {@code String[]}.
   *
   * <ul>
   *   <li>Then return {@link Builder#Builder()}.
   * </ul>
   *
   * <p>Method under test: {@link BaseBuilder#excludeProperties(String[])}
   */
  @Test
  @DisplayName(
      "Test BaseBuilder excludeProperties(String[]) with 'String[]'; then return Builder()")
  @Tag("MaintainedByDiffblue")
  void testBaseBuilderExcludePropertiesWithString_thenReturnBuilder() {
    // Arrange
    Builder builder = new Builder();

    // Act
    Builder actualExcludePropertiesResult = builder.excludeProperties();

    // Assert
    assertSame(builder, actualExcludePropertiesResult);
  }

  /**
   * Test BaseBuilder {@link BaseBuilder#excludeProperties(String[])} with {@code String[]}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@link Builder#Builder()}.
   * </ul>
   *
   * <p>Method under test: {@link BaseBuilder#excludeProperties(String[])}
   */
  @Test
  @DisplayName(
      "Test BaseBuilder excludeProperties(String[]) with 'String[]'; when 'null'; then return Builder()")
  @Tag("MaintainedByDiffblue")
  void testBaseBuilderExcludePropertiesWithString_whenNull_thenReturnBuilder() {
    // Arrange
    Builder builder = new Builder();

    // Act
    Builder actualExcludePropertiesResult = builder.excludeProperties((String[]) null);

    // Assert
    assertSame(builder, actualExcludePropertiesResult);
  }

  /**
   * Test BaseBuilder {@link BaseBuilder#groupBy(String[])}.
   *
   * <p>Method under test: {@link BaseBuilder#groupBy(String[])}
   */
  @Test
  @DisplayName("Test BaseBuilder groupBy(String[])")
  @Tag("MaintainedByDiffblue")
  void testBaseBuilderGroupBy() {
    // Arrange
    GlobalViewElementDefinition viewElementDef = new GlobalViewElementDefinition();
    viewElementDef.setGroupBy(new LinkedHashSet<>());
    Builder builder = new Builder(viewElementDef);

    // Act
    Builder actualGroupByResult = builder.groupBy("Group By");

    // Assert
    assertSame(builder, actualGroupByResult);
  }

  /**
   * Test BaseBuilder {@link BaseBuilder#groupBy(String[])}.
   *
   * <ul>
   *   <li>Given {@link Builder#Builder()}.
   *   <li>When {@code Group By}.
   *   <li>Then return {@link Builder#Builder()}.
   * </ul>
   *
   * <p>Method under test: {@link BaseBuilder#groupBy(String[])}
   */
  @Test
  @DisplayName(
      "Test BaseBuilder groupBy(String[]); given Builder(); when 'Group By'; then return Builder()")
  @Tag("MaintainedByDiffblue")
  void testBaseBuilderGroupBy_givenBuilder_whenGroupBy_thenReturnBuilder() {
    // Arrange
    Builder builder = new Builder();

    // Act
    Builder actualGroupByResult = builder.groupBy("Group By");

    // Assert
    assertSame(builder, actualGroupByResult);
  }

  /**
   * Test BaseBuilder {@link BaseBuilder#json(byte[], Class)} with {@code jsonBytes}, {@code clazz}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@link Builder#Builder()}.
   * </ul>
   *
   * <p>Method under test: {@link BaseBuilder#json(byte[], Class)}
   */
  @Test
  @DisplayName(
      "Test BaseBuilder json(byte[], Class) with 'jsonBytes', 'clazz'; when 'null'; then return Builder()")
  @Tag("MaintainedByDiffblue")
  void testBaseBuilderJsonWithJsonBytesClazz_whenNull_thenReturnBuilder() throws SchemaException {
    // Arrange
    Builder builder = new Builder();
    Class<ViewElementDefinition> clazz = ViewElementDefinition.class;

    // Act
    Builder actualJsonResult = builder.json(null, clazz);

    // Assert
    assertSame(builder, actualJsonResult);
  }

  /**
   * Test BaseBuilder {@link BaseBuilder#json(byte[])} with {@code jsonBytes}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@link ViewElementDefinition.Builder#Builder()}.
   * </ul>
   *
   * <p>Method under test: {@link BaseBuilder#json(byte[])}
   */
  @Test
  @DisplayName("Test BaseBuilder json(byte[]) with 'jsonBytes'; when 'null'; then return Builder()")
  @Tag("MaintainedByDiffblue")
  void testBaseBuilderJsonWithJsonBytes_whenNull_thenReturnBuilder() throws SchemaException {
    // Arrange
    ViewElementDefinition.Builder builder = new ViewElementDefinition.Builder();

    // Act
    ViewElementDefinition.Builder actualJsonResult = builder.json(null);

    // Assert
    assertSame(builder, actualJsonResult);
  }

  /**
   * Test BaseBuilder {@link BaseBuilder#postAggregationFilterFunctions(List)}.
   *
   * <p>Method under test: {@link BaseBuilder#postAggregationFilterFunctions(List)}
   */
  @Test
  @DisplayName("Test BaseBuilder postAggregationFilterFunctions(List)")
  @Tag("MaintainedByDiffblue")
  void testBaseBuilderPostAggregationFilterFunctions() {
    // Arrange
    Builder builder = new Builder();

    ArrayList<TupleAdaptedPredicate<String, ?>> filterFunctions = new ArrayList<>();
    filterFunctions.add(new TupleAdaptedPredicate<>());

    // Act and Assert
    GlobalViewElementDefinition elementDef =
        builder.postAggregationFilterFunctions(filterFunctions).getElementDef();
    assertTrue(elementDef.hasPostAggregationFilters());
    assertEquals(filterFunctions, elementDef.getPostAggregationFilterFunctions());
  }

  /**
   * Test BaseBuilder {@link BaseBuilder#postAggregationFilterFunctions(List)}.
   *
   * <p>Method under test: {@link BaseBuilder#postAggregationFilterFunctions(List)}
   */
  @Test
  @DisplayName("Test BaseBuilder postAggregationFilterFunctions(List)")
  @Tag("MaintainedByDiffblue")
  void testBaseBuilderPostAggregationFilterFunctions2() {
    // Arrange
    Builder builder = new Builder();

    ArrayList<TupleAdaptedPredicate<String, ?>> filterFunctions = new ArrayList<>();
    filterFunctions.add(new TupleAdaptedPredicate<>());
    TupleAdaptedPredicate<String, ?> tupleAdaptedPredicate = new TupleAdaptedPredicate<>();
    filterFunctions.add(tupleAdaptedPredicate);

    // Act and Assert
    List<TupleAdaptedPredicate<String, ?>> postAggregationFilterFunctions =
        builder
            .postAggregationFilterFunctions(filterFunctions)
            .getElementDef()
            .getPostAggregationFilterFunctions();
    assertEquals(2, postAggregationFilterFunctions.size());
    assertSame(tupleAdaptedPredicate, postAggregationFilterFunctions.get(1));
  }

  /**
   * Test BaseBuilder {@link BaseBuilder#postAggregationFilter(ElementFilter)}.
   *
   * <ul>
   *   <li>Given {@link Builder#Builder()}.
   *   <li>Then return {@link Builder#Builder()}.
   * </ul>
   *
   * <p>Method under test: {@link BaseBuilder#postAggregationFilter(ElementFilter)}
   */
  @Test
  @DisplayName(
      "Test BaseBuilder postAggregationFilter(ElementFilter); given Builder(); then return Builder()")
  @Tag("MaintainedByDiffblue")
  void testBaseBuilderPostAggregationFilter_givenBuilder_thenReturnBuilder() {
    // Arrange
    Builder builder = new Builder();

    // Act
    Builder actualPostAggregationFilterResult = builder.postAggregationFilter(new ElementFilter());

    // Assert
    assertSame(builder, actualPostAggregationFilterResult);
  }

  /**
   * Test BaseBuilder {@link BaseBuilder#postAggregationFilter(ElementFilter)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link BaseBuilder#postAggregationFilter(ElementFilter)}
   */
  @Test
  @DisplayName(
      "Test BaseBuilder postAggregationFilter(ElementFilter); then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  void testBaseBuilderPostAggregationFilter_thenThrowIllegalArgumentException() {
    // Arrange
    Builder builder = new Builder();
    builder.postAggregationFilterFunctions(new ArrayList<>());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> builder.postAggregationFilter(new ElementFilter()));
  }

  /**
   * Test BaseBuilder {@link BaseBuilder#postTransformFilterFunctions(List)}.
   *
   * <p>Method under test: {@link BaseBuilder#postTransformFilterFunctions(List)}
   */
  @Test
  @DisplayName("Test BaseBuilder postTransformFilterFunctions(List)")
  @Tag("MaintainedByDiffblue")
  void testBaseBuilderPostTransformFilterFunctions() {
    // Arrange
    Builder builder = new Builder();

    ArrayList<TupleAdaptedPredicate<String, ?>> filterFunctions = new ArrayList<>();
    filterFunctions.add(new TupleAdaptedPredicate<>());

    // Act and Assert
    GlobalViewElementDefinition elementDef =
        builder.postTransformFilterFunctions(filterFunctions).getElementDef();
    assertTrue(elementDef.hasPostTransformFilters());
    assertEquals(filterFunctions, elementDef.getPostTransformFilterFunctions());
  }

  /**
   * Test BaseBuilder {@link BaseBuilder#postTransformFilterFunctions(List)}.
   *
   * <p>Method under test: {@link BaseBuilder#postTransformFilterFunctions(List)}
   */
  @Test
  @DisplayName("Test BaseBuilder postTransformFilterFunctions(List)")
  @Tag("MaintainedByDiffblue")
  void testBaseBuilderPostTransformFilterFunctions2() {
    // Arrange
    Builder builder = new Builder();

    ArrayList<TupleAdaptedPredicate<String, ?>> filterFunctions = new ArrayList<>();
    filterFunctions.add(new TupleAdaptedPredicate<>());
    TupleAdaptedPredicate<String, ?> tupleAdaptedPredicate = new TupleAdaptedPredicate<>();
    filterFunctions.add(tupleAdaptedPredicate);

    // Act and Assert
    List<TupleAdaptedPredicate<String, ?>> postTransformFilterFunctions =
        builder
            .postTransformFilterFunctions(filterFunctions)
            .getElementDef()
            .getPostTransformFilterFunctions();
    assertEquals(2, postTransformFilterFunctions.size());
    assertSame(tupleAdaptedPredicate, postTransformFilterFunctions.get(1));
  }

  /**
   * Test BaseBuilder {@link BaseBuilder#postTransformFilter(ElementFilter)}.
   *
   * <ul>
   *   <li>Given {@link Builder#Builder()}.
   *   <li>Then return {@link Builder#Builder()}.
   * </ul>
   *
   * <p>Method under test: {@link BaseBuilder#postTransformFilter(ElementFilter)}
   */
  @Test
  @DisplayName(
      "Test BaseBuilder postTransformFilter(ElementFilter); given Builder(); then return Builder()")
  @Tag("MaintainedByDiffblue")
  void testBaseBuilderPostTransformFilter_givenBuilder_thenReturnBuilder() {
    // Arrange
    Builder builder = new Builder();

    // Act
    Builder actualPostTransformFilterResult = builder.postTransformFilter(new ElementFilter());

    // Assert
    assertSame(builder, actualPostTransformFilterResult);
  }

  /**
   * Test BaseBuilder {@link BaseBuilder#postTransformFilter(ElementFilter)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link BaseBuilder#postTransformFilter(ElementFilter)}
   */
  @Test
  @DisplayName(
      "Test BaseBuilder postTransformFilter(ElementFilter); then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  void testBaseBuilderPostTransformFilter_thenThrowIllegalArgumentException() {
    // Arrange
    Builder builder = new Builder();
    builder.postTransformFilterFunctions(new ArrayList<>());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> builder.postTransformFilter(new ElementFilter()));
  }

  /**
   * Test BaseBuilder {@link BaseBuilder#preAggregationFilterFunctions(List)}.
   *
   * <p>Method under test: {@link BaseBuilder#preAggregationFilterFunctions(List)}
   */
  @Test
  @DisplayName("Test BaseBuilder preAggregationFilterFunctions(List)")
  @Tag("MaintainedByDiffblue")
  void testBaseBuilderPreAggregationFilterFunctions() {
    // Arrange
    Builder builder = new Builder();

    ArrayList<TupleAdaptedPredicate<String, ?>> filterFunctions = new ArrayList<>();
    filterFunctions.add(new TupleAdaptedPredicate<>());

    // Act and Assert
    GlobalViewElementDefinition elementDef =
        builder.preAggregationFilterFunctions(filterFunctions).getElementDef();
    assertTrue(elementDef.hasPreAggregationFilters());
    assertEquals(filterFunctions, elementDef.getPreAggregationFilterFunctions());
  }

  /**
   * Test BaseBuilder {@link BaseBuilder#preAggregationFilterFunctions(List)}.
   *
   * <p>Method under test: {@link BaseBuilder#preAggregationFilterFunctions(List)}
   */
  @Test
  @DisplayName("Test BaseBuilder preAggregationFilterFunctions(List)")
  @Tag("MaintainedByDiffblue")
  void testBaseBuilderPreAggregationFilterFunctions2() {
    // Arrange
    Builder builder = new Builder();

    ArrayList<TupleAdaptedPredicate<String, ?>> filterFunctions = new ArrayList<>();
    filterFunctions.add(new TupleAdaptedPredicate<>());
    TupleAdaptedPredicate<String, ?> tupleAdaptedPredicate = new TupleAdaptedPredicate<>();
    filterFunctions.add(tupleAdaptedPredicate);

    // Act and Assert
    List<TupleAdaptedPredicate<String, ?>> preAggregationFilterFunctions =
        builder
            .preAggregationFilterFunctions(filterFunctions)
            .getElementDef()
            .getPreAggregationFilterFunctions();
    assertEquals(2, preAggregationFilterFunctions.size());
    assertSame(tupleAdaptedPredicate, preAggregationFilterFunctions.get(1));
  }

  /**
   * Test BaseBuilder {@link BaseBuilder#preAggregationFilter(ElementFilter)}.
   *
   * <ul>
   *   <li>Given {@link Builder#Builder()}.
   *   <li>Then return {@link Builder#Builder()}.
   * </ul>
   *
   * <p>Method under test: {@link BaseBuilder#preAggregationFilter(ElementFilter)}
   */
  @Test
  @DisplayName(
      "Test BaseBuilder preAggregationFilter(ElementFilter); given Builder(); then return Builder()")
  @Tag("MaintainedByDiffblue")
  void testBaseBuilderPreAggregationFilter_givenBuilder_thenReturnBuilder() {
    // Arrange
    Builder builder = new Builder();

    // Act
    Builder actualPreAggregationFilterResult = builder.preAggregationFilter(new ElementFilter());

    // Assert
    assertSame(builder, actualPreAggregationFilterResult);
  }

  /**
   * Test BaseBuilder {@link BaseBuilder#preAggregationFilter(ElementFilter)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link BaseBuilder#preAggregationFilter(ElementFilter)}
   */
  @Test
  @DisplayName(
      "Test BaseBuilder preAggregationFilter(ElementFilter); then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  void testBaseBuilderPreAggregationFilter_thenThrowIllegalArgumentException() {
    // Arrange
    Builder builder = new Builder();
    builder.preAggregationFilterFunctions(new ArrayList<>());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> builder.preAggregationFilter(new ElementFilter()));
  }

  /**
   * Test BaseBuilder {@link BaseBuilder#properties(Set)} with {@code Set}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link HashSet#HashSet()} add {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link BaseBuilder#properties(Set)}
   */
  @Test
  @DisplayName("Test BaseBuilder properties(Set) with 'Set'; given '42'; when HashSet() add '42'")
  @Tag("MaintainedByDiffblue")
  void testBaseBuilderPropertiesWithSet_given42_whenHashSetAdd42() {
    // Arrange
    Builder builder = new Builder();

    HashSet<String> properties = new HashSet<>();
    properties.add("42");
    properties.add("foo");

    // Act
    Builder actualPropertiesResult = builder.properties(properties);

    // Assert
    assertSame(builder, actualPropertiesResult);
  }

  /**
   * Test BaseBuilder {@link BaseBuilder#properties(Set)} with {@code Set}.
   *
   * <ul>
   *   <li>Given {@code foo}.
   *   <li>When {@link HashSet#HashSet()} add {@code foo}.
   * </ul>
   *
   * <p>Method under test: {@link BaseBuilder#properties(Set)}
   */
  @Test
  @DisplayName("Test BaseBuilder properties(Set) with 'Set'; given 'foo'; when HashSet() add 'foo'")
  @Tag("MaintainedByDiffblue")
  void testBaseBuilderPropertiesWithSet_givenFoo_whenHashSetAddFoo() {
    // Arrange
    Builder builder = new Builder();

    HashSet<String> properties = new HashSet<>();
    properties.add("foo");

    // Act
    Builder actualPropertiesResult = builder.properties(properties);

    // Assert
    assertSame(builder, actualPropertiesResult);
  }

  /**
   * Test BaseBuilder {@link BaseBuilder#properties(Set)} with {@code Set}.
   *
   * <ul>
   *   <li>When {@link HashSet#HashSet()}.
   * </ul>
   *
   * <p>Method under test: {@link BaseBuilder#properties(Set)}
   */
  @Test
  @DisplayName("Test BaseBuilder properties(Set) with 'Set'; when HashSet()")
  @Tag("MaintainedByDiffblue")
  void testBaseBuilderPropertiesWithSet_whenHashSet() {
    // Arrange
    Builder builder = new Builder();

    // Act
    Builder actualPropertiesResult = builder.properties(new HashSet<>());

    // Assert
    assertSame(builder, actualPropertiesResult);
  }

  /**
   * Test BaseBuilder {@link BaseBuilder#properties(Set)} with {@code Set}.
   *
   * <ul>
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link BaseBuilder#properties(Set)}
   */
  @Test
  @DisplayName("Test BaseBuilder properties(Set) with 'Set'; when 'null'")
  @Tag("MaintainedByDiffblue")
  void testBaseBuilderPropertiesWithSet_whenNull() {
    // Arrange
    Builder builder = new Builder();

    // Act
    Builder actualPropertiesResult = builder.properties((Set<String>) null);

    // Assert
    assertSame(builder, actualPropertiesResult);
  }

  /**
   * Test BaseBuilder {@link BaseBuilder#properties(String[])} with {@code String[]}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@link Builder#Builder()}.
   * </ul>
   *
   * <p>Method under test: {@link BaseBuilder#properties(String[])}
   */
  @Test
  @DisplayName(
      "Test BaseBuilder properties(String[]) with 'String[]'; when 'null'; then return Builder()")
  @Tag("MaintainedByDiffblue")
  void testBaseBuilderPropertiesWithString_whenNull_thenReturnBuilder() {
    // Arrange
    Builder builder = new Builder();

    // Act
    Builder actualPropertiesResult = builder.properties((String[]) null);

    // Assert
    assertSame(builder, actualPropertiesResult);
  }

  /**
   * Test BaseBuilder {@link BaseBuilder#transformFunctions(List)}.
   *
   * <p>Method under test: {@link BaseBuilder#transformFunctions(List)}
   */
  @Test
  @DisplayName("Test BaseBuilder transformFunctions(List)")
  @Tag("MaintainedByDiffblue")
  void testBaseBuilderTransformFunctions() {
    // Arrange
    Builder builder = new Builder();

    ArrayList<TupleAdaptedFunction<String, ?, ?>> transformFunctions = new ArrayList<>();
    transformFunctions.add(new TupleAdaptedFunction<>());
    TupleAdaptedFunction<String, ?, ?> tupleAdaptedFunction = new TupleAdaptedFunction<>();
    transformFunctions.add(tupleAdaptedFunction);

    // Act and Assert
    List<TupleAdaptedFunction<String, ?, ?>> transformFunctions2 =
        builder.transformFunctions(transformFunctions).getElementDef().getTransformFunctions();
    assertEquals(2, transformFunctions2.size());
    assertSame(tupleAdaptedFunction, transformFunctions2.get(1));
  }

  /**
   * Test BaseBuilder {@link BaseBuilder#transformFunctions(List)}.
   *
   * <ul>
   *   <li>Then return ElementDef hasTransform.
   * </ul>
   *
   * <p>Method under test: {@link BaseBuilder#transformFunctions(List)}
   */
  @Test
  @DisplayName("Test BaseBuilder transformFunctions(List); then return ElementDef hasTransform")
  @Tag("MaintainedByDiffblue")
  void testBaseBuilderTransformFunctions_thenReturnElementDefHasTransform() {
    // Arrange
    Builder builder = new Builder();

    ArrayList<TupleAdaptedFunction<String, ?, ?>> transformFunctions = new ArrayList<>();
    transformFunctions.add(new TupleAdaptedFunction<>());

    // Act and Assert
    GlobalViewElementDefinition elementDef =
        builder.transformFunctions(transformFunctions).getElementDef();
    assertTrue(elementDef.hasTransform());
    assertEquals(transformFunctions, elementDef.getTransformFunctions());
  }

  /**
   * Test BaseBuilder {@link BaseBuilder#transformer(ElementTransformer)}.
   *
   * <p>Method under test: {@link BaseBuilder#transformer(ElementTransformer)}
   */
  @Test
  @DisplayName("Test BaseBuilder transformer(ElementTransformer)")
  @Tag("MaintainedByDiffblue")
  void testBaseBuilderTransformer() {
    // Arrange
    Builder builder = new Builder();

    // Act
    Builder actualTransformerResult = builder.transformer(new ElementTransformer());

    // Assert
    assertSame(builder, actualTransformerResult);
  }

  /**
   * Test BaseBuilder {@link BaseBuilder#transientProperties(Map)}.
   *
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.
   * </ul>
   *
   * <p>Method under test: {@link BaseBuilder#transientProperties(Map)}
   */
  @Test
  @DisplayName("Test BaseBuilder transientProperties(Map); when HashMap()")
  @Tag("MaintainedByDiffblue")
  void testBaseBuilderTransientProperties_whenHashMap() {
    // Arrange
    Builder builder = new Builder();

    // Act
    Builder actualTransientPropertiesResult = builder.transientProperties(new HashMap<>());

    // Assert
    assertSame(builder, actualTransientPropertiesResult);
  }

  /**
   * Test BaseBuilder {@link BaseBuilder#transientProperties(Map)}.
   *
   * <ul>
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link BaseBuilder#transientProperties(Map)}
   */
  @Test
  @DisplayName("Test BaseBuilder transientProperties(Map); when 'null'")
  @Tag("MaintainedByDiffblue")
  void testBaseBuilderTransientProperties_whenNull() {
    // Arrange
    Builder builder = new Builder();

    // Act
    Builder actualTransientPropertiesResult = builder.transientProperties(null);

    // Assert
    assertSame(builder, actualTransientPropertiesResult);
  }

  /**
   * Test BaseBuilder {@link BaseBuilder#transientProperty(String, Class)}.
   *
   * <p>Method under test: {@link BaseBuilder#transientProperty(String, Class)}
   */
  @Test
  @DisplayName("Test BaseBuilder transientProperty(String, Class)")
  @Tag("MaintainedByDiffblue")
  void testBaseBuilderTransientProperty() {
    // Arrange
    Builder builder = new Builder();
    Class<Object> clazz = Object.class;

    // Act
    Builder actualTransientPropertyResult = builder.transientProperty("Property Name", clazz);

    // Assert
    assertSame(builder, actualTransientPropertyResult);
  }

  /**
   * Test Builder {@link ViewElementDefinition.Builder#Builder(ViewElementDefinition)}.
   *
   * <ul>
   *   <li>Given {@link LinkedHashSet#LinkedHashSet()}.
   * </ul>
   *
   * <p>Method under test: {@link ViewElementDefinition.Builder#Builder(ViewElementDefinition)}
   */
  @Test
  @DisplayName("Test Builder new Builder(ViewElementDefinition); given LinkedHashSet()")
  @Tag("MaintainedByDiffblue")
  void testBuilderNewBuilder_givenLinkedHashSet() {
    // Arrange
    ViewElementDefinition viewElementDef = new ViewElementDefinition();
    viewElementDef.setGroupBy(new LinkedHashSet<>());

    // Act and Assert
    assertEquals(viewElementDef, new ViewElementDefinition.Builder(viewElementDef).getElementDef());
  }

  /**
   * Test Builder {@link ViewElementDefinition.Builder#Builder(ViewElementDefinition)}.
   *
   * <ul>
   *   <li>When {@link ViewElementDefinition} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link ViewElementDefinition.Builder#Builder(ViewElementDefinition)}
   */
  @Test
  @DisplayName(
      "Test Builder new Builder(ViewElementDefinition); when ViewElementDefinition (default constructor)")
  @Tag("MaintainedByDiffblue")
  void testBuilderNewBuilder_whenViewElementDefinition() {
    // Arrange
    ViewElementDefinition viewElementDef = new ViewElementDefinition();

    // Act and Assert
    assertEquals(viewElementDef, new ViewElementDefinition.Builder(viewElementDef).getElementDef());
  }

  /**
   * Test Builder {@link ViewElementDefinition.Builder#self()}.
   *
   * <p>Method under test: {@link ViewElementDefinition.Builder#self()}
   */
  @Test
  @DisplayName("Test Builder self()")
  @Tag("MaintainedByDiffblue")
  void testBuilderSelf() {
    // Arrange
    ViewElementDefinition.Builder builder = new ViewElementDefinition.Builder();

    // Act
    ViewElementDefinition.Builder actualSelfResult = builder.self();

    // Assert
    assertSame(builder, actualSelfResult);
  }

  /**
   * Test {@link ViewElementDefinition#isEmpty()}.
   *
   * <ul>
   *   <li>Given {@link ViewElementDefinition} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link ViewElementDefinition#isEmpty()}
   */
  @Test
  @DisplayName("Test isEmpty(); given ViewElementDefinition (default constructor)")
  @Tag("MaintainedByDiffblue")
  void testIsEmpty_givenViewElementDefinition() {
    // Arrange, Act and Assert
    assertFalse(new ViewElementDefinition().isEmpty());
  }

  /**
   * Test {@link ViewElementDefinition#isEmpty()}.
   *
   * <ul>
   *   <li>Given {@link ViewElementDefinition} (default constructor) GroupBy is {@link
   *       LinkedHashSet#LinkedHashSet()}.
   * </ul>
   *
   * <p>Method under test: {@link ViewElementDefinition#isEmpty()}
   */
  @Test
  @DisplayName(
      "Test isEmpty(); given ViewElementDefinition (default constructor) GroupBy is LinkedHashSet()")
  @Tag("MaintainedByDiffblue")
  void testIsEmpty_givenViewElementDefinitionGroupByIsLinkedHashSet() {
    // Arrange
    ViewElementDefinition viewElementDefinition = new ViewElementDefinition();
    viewElementDefinition.setGroupBy(new LinkedHashSet<>());

    // Act and Assert
    assertFalse(viewElementDefinition.isEmpty());
  }

  /**
   * Test {@link ViewElementDefinition#isAllProperties()}.
   *
   * <p>Method under test: {@link ViewElementDefinition#isAllProperties()}
   */
  @Test
  @DisplayName("Test isAllProperties()")
  @Tag("MaintainedByDiffblue")
  void testIsAllProperties() {
    // Arrange, Act and Assert
    assertTrue(new ViewElementDefinition().isAllProperties());
  }

  /**
   * Test {@link ViewElementDefinition#getTransientPropertyClass(String)}.
   *
   * <p>Method under test: {@link ViewElementDefinition#getTransientPropertyClass(String)}
   */
  @Test
  @DisplayName("Test getTransientPropertyClass(String)")
  @Tag("MaintainedByDiffblue")
  void testGetTransientPropertyClass() {
    // Arrange, Act and Assert
    assertNull(new ViewElementDefinition().getTransientPropertyClass("Property Name"));
  }

  /**
   * Test {@link ViewElementDefinition#getTransientPropertyClasses()}.
   *
   * <p>Method under test: {@link ViewElementDefinition#getTransientPropertyClasses()}
   */
  @Test
  @DisplayName("Test getTransientPropertyClasses()")
  @Tag("MaintainedByDiffblue")
  void testGetTransientPropertyClasses() {
    // Arrange, Act and Assert
    assertTrue(new ViewElementDefinition().getTransientPropertyClasses().isEmpty());
  }

  /**
   * Test {@link ViewElementDefinition#getTransientProperties()}.
   *
   * <p>Method under test: {@link ViewElementDefinition#getTransientProperties()}
   */
  @Test
  @DisplayName("Test getTransientProperties()")
  @Tag("MaintainedByDiffblue")
  void testGetTransientProperties() {
    // Arrange, Act and Assert
    assertTrue(new ViewElementDefinition().getTransientProperties().isEmpty());
  }

  /**
   * Test {@link ViewElementDefinition#containsTransientProperty(String)}.
   *
   * <p>Method under test: {@link ViewElementDefinition#containsTransientProperty(String)}
   */
  @Test
  @DisplayName("Test containsTransientProperty(String)")
  @Tag("MaintainedByDiffblue")
  void testContainsTransientProperty() {
    // Arrange, Act and Assert
    assertFalse(new ViewElementDefinition().containsTransientProperty("Property Name"));
  }

  /**
   * Test {@link ViewElementDefinition#getTransientPropertyMapWithClassNames()}.
   *
   * <p>Method under test: {@link ViewElementDefinition#getTransientPropertyMapWithClassNames()}
   */
  @Test
  @DisplayName("Test getTransientPropertyMapWithClassNames()")
  @Tag("MaintainedByDiffblue")
  void testGetTransientPropertyMapWithClassNames() {
    // Arrange, Act and Assert
    assertNull(new ViewElementDefinition().getTransientPropertyMapWithClassNames());
  }

  /**
   * Test {@link ViewElementDefinition#getPreAggregationFilterFunctions()}.
   *
   * <p>Method under test: {@link ViewElementDefinition#getPreAggregationFilterFunctions()}
   */
  @Test
  @DisplayName("Test getPreAggregationFilterFunctions()")
  @Tag("MaintainedByDiffblue")
  void testGetPreAggregationFilterFunctions() {
    // Arrange, Act and Assert
    assertNull(new ViewElementDefinition().getPreAggregationFilterFunctions());
  }

  /**
   * Test {@link ViewElementDefinition#hasPreAggregationFilters()}.
   *
   * <p>Method under test: {@link ViewElementDefinition#hasPreAggregationFilters()}
   */
  @Test
  @DisplayName("Test hasPreAggregationFilters()")
  @Tag("MaintainedByDiffblue")
  void testHasPreAggregationFilters() {
    // Arrange, Act and Assert
    assertFalse(new ViewElementDefinition().hasPreAggregationFilters());
  }

  /**
   * Test {@link ViewElementDefinition#getPostAggregationFilterFunctions()}.
   *
   * <p>Method under test: {@link ViewElementDefinition#getPostAggregationFilterFunctions()}
   */
  @Test
  @DisplayName("Test getPostAggregationFilterFunctions()")
  @Tag("MaintainedByDiffblue")
  void testGetPostAggregationFilterFunctions() {
    // Arrange, Act and Assert
    assertNull(new ViewElementDefinition().getPostAggregationFilterFunctions());
  }

  /**
   * Test {@link ViewElementDefinition#hasPostAggregationFilters()}.
   *
   * <p>Method under test: {@link ViewElementDefinition#hasPostAggregationFilters()}
   */
  @Test
  @DisplayName("Test hasPostAggregationFilters()")
  @Tag("MaintainedByDiffblue")
  void testHasPostAggregationFilters() {
    // Arrange, Act and Assert
    assertFalse(new ViewElementDefinition().hasPostAggregationFilters());
  }

  /**
   * Test {@link ViewElementDefinition#getPostTransformFilterFunctions()}.
   *
   * <p>Method under test: {@link ViewElementDefinition#getPostTransformFilterFunctions()}
   */
  @Test
  @DisplayName("Test getPostTransformFilterFunctions()")
  @Tag("MaintainedByDiffblue")
  void testGetPostTransformFilterFunctions() {
    // Arrange, Act and Assert
    assertNull(new ViewElementDefinition().getPostTransformFilterFunctions());
  }

  /**
   * Test {@link ViewElementDefinition#hasPostTransformFilters()}.
   *
   * <p>Method under test: {@link ViewElementDefinition#hasPostTransformFilters()}
   */
  @Test
  @DisplayName("Test hasPostTransformFilters()")
  @Tag("MaintainedByDiffblue")
  void testHasPostTransformFilters() {
    // Arrange, Act and Assert
    assertFalse(new ViewElementDefinition().hasPostTransformFilters());
  }

  /**
   * Test {@link ViewElementDefinition#hasTransform()}.
   *
   * <p>Method under test: {@link ViewElementDefinition#hasTransform()}
   */
  @Test
  @DisplayName("Test hasTransform()")
  @Tag("MaintainedByDiffblue")
  void testHasTransform() {
    // Arrange, Act and Assert
    assertFalse(new ViewElementDefinition().hasTransform());
  }

  /**
   * Test {@link ViewElementDefinition#getTransformFunctions()}.
   *
   * <p>Method under test: {@link ViewElementDefinition#getTransformFunctions()}
   */
  @Test
  @DisplayName("Test getTransformFunctions()")
  @Tag("MaintainedByDiffblue")
  void testGetTransformFunctions() {
    // Arrange, Act and Assert
    assertNull(new ViewElementDefinition().getTransformFunctions());
  }

  /**
   * Test {@link ViewElementDefinition#equals(Object)}, and {@link
   * ViewElementDefinition#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ViewElementDefinition#equals(Object)}
   *   <li>{@link ViewElementDefinition#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ViewElementDefinition viewElementDefinition = new ViewElementDefinition();
    ViewElementDefinition viewElementDefinition2 = new ViewElementDefinition();

    // Act and Assert
    assertEquals(viewElementDefinition, viewElementDefinition2);
    assertEquals(viewElementDefinition.hashCode(), viewElementDefinition2.hashCode());
  }

  /**
   * Test {@link ViewElementDefinition#equals(Object)}, and {@link
   * ViewElementDefinition#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ViewElementDefinition#equals(Object)}
   *   <li>{@link ViewElementDefinition#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ViewElementDefinition viewElementDefinition = new ViewElementDefinition();

    // Act and Assert
    assertEquals(viewElementDefinition, viewElementDefinition);
    int expectedHashCodeResult = viewElementDefinition.hashCode();
    assertEquals(expectedHashCodeResult, viewElementDefinition.hashCode());
  }

  /**
   * Test {@link ViewElementDefinition#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ViewElementDefinition#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ViewElementDefinition viewElementDefinition = new ViewElementDefinition();
    viewElementDefinition.setGroupBy(new LinkedHashSet<>());

    // Act and Assert
    assertNotEquals(viewElementDefinition, new ViewElementDefinition());
  }

  /**
   * Test {@link ViewElementDefinition#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ViewElementDefinition#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new ViewElementDefinition(), null);
  }

  /**
   * Test {@link ViewElementDefinition#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ViewElementDefinition#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new ViewElementDefinition(), "Different type to ViewElementDefinition");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link ViewElementDefinition}
   *   <li>{@link ViewElementDefinition#setGroupBy(LinkedHashSet)}
   *   <li>{@link ViewElementDefinition#toString()}
   *   <li>{@link ViewElementDefinition#getAggregator()}
   *   <li>{@link ViewElementDefinition#getExcludeProperties()}
   *   <li>{@link ViewElementDefinition#getGroupBy()}
   *   <li>{@link ViewElementDefinition#getPostAggregationFilter()}
   *   <li>{@link ViewElementDefinition#getPostTransformFilter()}
   *   <li>{@link ViewElementDefinition#getPreAggregationFilter()}
   *   <li>{@link ViewElementDefinition#getProperties()}
   *   <li>{@link ViewElementDefinition#getTransformer()}
   *   <li>{@link ViewElementDefinition#getTransientPropertyMap()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  void testGettersAndSetters() {
    // Arrange and Act
    ViewElementDefinition actualViewElementDefinition = new ViewElementDefinition();
    LinkedHashSet<String> groupBy = new LinkedHashSet<>();
    actualViewElementDefinition.setGroupBy(groupBy);
    String actualToStringResult = actualViewElementDefinition.toString();
    ElementAggregator actualAggregator = actualViewElementDefinition.getAggregator();
    Set<String> actualExcludeProperties = actualViewElementDefinition.getExcludeProperties();
    Set<String> actualGroupBy = actualViewElementDefinition.getGroupBy();
    ElementFilter actualPostAggregationFilter =
        actualViewElementDefinition.getPostAggregationFilter();
    ElementFilter actualPostTransformFilter = actualViewElementDefinition.getPostTransformFilter();
    ElementFilter actualPreAggregationFilter =
        actualViewElementDefinition.getPreAggregationFilter();
    Set<String> actualProperties = actualViewElementDefinition.getProperties();
    ElementTransformer actualTransformer = actualViewElementDefinition.getTransformer();

    // Assert
    assertEquals("ViewElementDefinition[groupBy=[],transientProperties={}]", actualToStringResult);
    assertNull(actualExcludeProperties);
    assertNull(actualProperties);
    assertNull(actualAggregator);
    assertNull(actualPostAggregationFilter);
    assertNull(actualPostTransformFilter);
    assertNull(actualPreAggregationFilter);
    assertNull(actualTransformer);
    assertTrue(actualViewElementDefinition.getTransientPropertyMap().isEmpty());
    assertTrue(actualGroupBy.isEmpty());
    assertSame(groupBy, actualGroupBy);
  }
}
