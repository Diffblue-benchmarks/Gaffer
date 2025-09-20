package uk.gov.gchq.gaffer.store.schema;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.function.BinaryOperator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import uk.gov.gchq.gaffer.data.element.function.ElementAggregator;
import uk.gov.gchq.gaffer.data.element.function.ElementFilter;
import uk.gov.gchq.gaffer.data.element.function.ElementFilter.Builder;
import uk.gov.gchq.gaffer.data.element.function.ElementTransformer;
import uk.gov.gchq.gaffer.data.elementdefinition.view.GlobalViewElementDefinition;
import uk.gov.gchq.gaffer.data.elementdefinition.view.NamedView;
import uk.gov.gchq.gaffer.data.elementdefinition.view.View;
import uk.gov.gchq.gaffer.data.elementdefinition.view.ViewElementDefinition;
import uk.gov.gchq.gaffer.store.StoreTrait;
import uk.gov.gchq.gaffer.store.operation.OperationUtil;
import uk.gov.gchq.koryphe.ValidationResult;
import uk.gov.gchq.koryphe.tuple.binaryoperator.TupleAdaptedBinaryOperator;
import uk.gov.gchq.koryphe.tuple.predicate.TupleAdaptedPredicate;

class ViewValidatorDiffblueTest {
  /**
   * Test {@link ViewValidator#validate(View, Schema, Set)}.
   *
   * <ul>
   *   <li>Given {@code INGEST_AGGREGATION}.
   *   <li>When {@link HashSet#HashSet()} add {@code INGEST_AGGREGATION}.
   * </ul>
   *
   * <p>Method under test: {@link ViewValidator#validate(View, Schema, Set)}
   */
  @Test
  @DisplayName(
      "Test validate(View, Schema, Set); given 'INGEST_AGGREGATION'; when HashSet() add 'INGEST_AGGREGATION'")
  @Tag("MaintainedByDiffblue")
  void testValidate_givenIngestAggregation_whenHashSetAddIngestAggregation() {
    // Arrange
    ViewValidator viewValidator = new ViewValidator();
    View view = new View();
    Schema schema = new Schema();

    HashSet<StoreTrait> storeTraits = new HashSet<>();
    storeTraits.add(StoreTrait.INGEST_AGGREGATION);

    // Act
    ValidationResult actualValidateResult = viewValidator.validate(view, schema, storeTraits);

    // Assert
    assertEquals("Validation errors: \n", actualValidateResult.getErrorString());
    assertTrue(actualValidateResult.getErrors().isEmpty());
    assertTrue(actualValidateResult.isValid());
  }

  /**
   * Test {@link ViewValidator#validate(View, Schema, Set)}.
   *
   * <ul>
   *   <li>Given {@code QUERY_AGGREGATION}.
   *   <li>When {@link HashSet#HashSet()} add {@code QUERY_AGGREGATION}.
   * </ul>
   *
   * <p>Method under test: {@link ViewValidator#validate(View, Schema, Set)}
   */
  @Test
  @DisplayName(
      "Test validate(View, Schema, Set); given 'QUERY_AGGREGATION'; when HashSet() add 'QUERY_AGGREGATION'")
  @Tag("MaintainedByDiffblue")
  void testValidate_givenQueryAggregation_whenHashSetAddQueryAggregation() {
    // Arrange
    ViewValidator viewValidator = new ViewValidator();
    View view = new View();
    Schema schema = new Schema();

    HashSet<StoreTrait> storeTraits = new HashSet<>();
    storeTraits.add(StoreTrait.QUERY_AGGREGATION);
    storeTraits.add(StoreTrait.INGEST_AGGREGATION);

    // Act
    ValidationResult actualValidateResult = viewValidator.validate(view, schema, storeTraits);

    // Assert
    assertEquals("Validation errors: \n", actualValidateResult.getErrorString());
    assertTrue(actualValidateResult.getErrors().isEmpty());
    assertTrue(actualValidateResult.isValid());
  }

  /**
   * Test {@link ViewValidator#validate(View, Schema, Set)}.
   *
   * <ul>
   *   <li>When {@link HashSet#HashSet()}.
   *   <li>Then return ErrorString is {@code Validation errors:}.
   * </ul>
   *
   * <p>Method under test: {@link ViewValidator#validate(View, Schema, Set)}
   */
  @Test
  @DisplayName(
      "Test validate(View, Schema, Set); when HashSet(); then return ErrorString is 'Validation errors:'")
  @Tag("MaintainedByDiffblue")
  void testValidate_whenHashSet_thenReturnErrorStringIsValidationErrors() {
    // Arrange
    ViewValidator viewValidator = new ViewValidator();
    View view = new View();
    Schema schema = new Schema();

    // Act
    ValidationResult actualValidateResult = viewValidator.validate(view, schema, new HashSet<>());

    // Assert
    assertEquals("Validation errors: \n", actualValidateResult.getErrorString());
    assertTrue(actualValidateResult.getErrors().isEmpty());
    assertTrue(actualValidateResult.isValid());
  }

  /**
   * Test {@link ViewValidator#validate(View, Schema, Set)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return ErrorString is {@code Validation errors:}.
   * </ul>
   *
   * <p>Method under test: {@link ViewValidator#validate(View, Schema, Set)}
   */
  @Test
  @DisplayName(
      "Test validate(View, Schema, Set); when 'null'; then return ErrorString is 'Validation errors:'")
  @Tag("MaintainedByDiffblue")
  void testValidate_whenNull_thenReturnErrorStringIsValidationErrors() {
    // Arrange
    ViewValidator viewValidator = new ViewValidator();
    Schema schema = new Schema();

    // Act
    ValidationResult actualValidateResult = viewValidator.validate(null, schema, new HashSet<>());

    // Assert
    assertEquals("Validation errors: \n", actualValidateResult.getErrorString());
    assertTrue(actualValidateResult.getErrors().isEmpty());
    assertTrue(actualValidateResult.isValid());
  }

  /**
   * Test {@link ViewValidator#validateEdge(View, Schema, Set, boolean, ValidationResult)}.
   *
   * <p>Method under test: {@link ViewValidator#validateEdge(View, Schema, Set, boolean,
   * ValidationResult)}
   */
  @Test
  @DisplayName("Test validateEdge(View, Schema, Set, boolean, ValidationResult)")
  @Tag("MaintainedByDiffblue")
  void testValidateEdge() {
    // Arrange
    ViewValidator viewValidator = new ViewValidator();

    HashMap<String, ViewElementDefinition> stringViewElementDefinitionMap = new HashMap<>();
    stringViewElementDefinitionMap.put("foo", new ViewElementDefinition());

    NamedView view = mock(NamedView.class);
    when(view.getEdges()).thenReturn(stringViewElementDefinitionMap);
    Schema schema = new Schema();
    HashSet<StoreTrait> storeTraits = new HashSet<>();
    Class<Object> output = Object.class;
    Class<Object> input = Object.class;

    ValidationResult result = OperationUtil.isValid(output, input);

    // Act
    viewValidator.validateEdge(view, schema, storeTraits, true, result);

    // Assert
    verify(view, atLeast(1)).getEdges();
    assertEquals(
        "Validation errors: \nEdge group foo does not exist in the schema",
        result.getErrorString());
    Set<String> errors = result.getErrors();
    assertEquals(1, errors.size());
    assertFalse(result.isValid());
    assertTrue(errors.contains("Edge group foo does not exist in the schema"));
  }

  /**
   * Test {@link ViewValidator#validateEdge(View, Schema, Set, boolean, ValidationResult)}.
   *
   * <p>Method under test: {@link ViewValidator#validateEdge(View, Schema, Set, boolean,
   * ValidationResult)}
   */
  @Test
  @DisplayName("Test validateEdge(View, Schema, Set, boolean, ValidationResult)")
  @Tag("MaintainedByDiffblue")
  void testValidateEdge2() {
    // Arrange
    ViewValidator viewValidator = new ViewValidator();

    LinkedHashSet<String> stringSet = new LinkedHashSet<>();
    stringSet.add("Transient Properties");

    ElementAggregator elementAggregator = new ElementAggregator.Builder().build();
    elementAggregator.setComponents(new ArrayList<>());

    ElementFilter elementFilter = new Builder().build();
    elementFilter.setComponents(new ArrayList<>());

    ElementFilter elementFilter2 = new Builder().build();
    elementFilter2.setComponents(new ArrayList<>());

    ElementFilter elementFilter3 = new Builder().build();
    elementFilter3.setComponents(new ArrayList<>());

    GlobalViewElementDefinition globalViewElementDefinition =
        mock(GlobalViewElementDefinition.class);
    when(globalViewElementDefinition.getGroupBy()).thenReturn(null);
    when(globalViewElementDefinition.getTransientProperties()).thenReturn(stringSet);
    when(globalViewElementDefinition.getAggregator()).thenReturn(elementAggregator);
    when(globalViewElementDefinition.getPostAggregationFilter()).thenReturn(elementFilter);
    when(globalViewElementDefinition.getPostTransformFilter()).thenReturn(elementFilter2);
    when(globalViewElementDefinition.getPreAggregationFilter()).thenReturn(elementFilter3);
    when(globalViewElementDefinition.getTransformer()).thenReturn(null);

    HashMap<String, ViewElementDefinition> stringViewElementDefinitionMap = new HashMap<>();
    stringViewElementDefinitionMap.put("foo", globalViewElementDefinition);

    NamedView view = mock(NamedView.class);
    when(view.getConfig(Mockito.<String>any())).thenReturn(Boolean.TRUE.toString());
    when(view.getEdges()).thenReturn(stringViewElementDefinitionMap);

    Schema schema = mock(Schema.class);
    when(schema.getEdge(Mockito.<String>any())).thenReturn(new SchemaEdgeDefinition());
    HashSet<StoreTrait> storeTraits = new HashSet<>();
    Class<Object> output = Object.class;
    Class<Object> input = Object.class;

    ValidationResult result = OperationUtil.isValid(output, input);

    // Act
    viewValidator.validateEdge(view, schema, storeTraits, true, result);

    // Assert
    verify(schema).getEdge("foo");
    verify(view, atLeast(1)).getEdges();
    verify(view).getConfig("skipViewValidation");
    verify(globalViewElementDefinition).getAggregator();
    verify(globalViewElementDefinition).getGroupBy();
    verify(globalViewElementDefinition).getPostAggregationFilter();
    verify(globalViewElementDefinition).getPostTransformFilter();
    verify(globalViewElementDefinition).getPreAggregationFilter();
    verify(globalViewElementDefinition).getTransformer();
    verify(globalViewElementDefinition).getTransientProperties();
    assertEquals(
        "Validation errors: \nThis store does not currently support QUERY_AGGREGATION",
        result.getErrorString());
    Set<String> errors = result.getErrors();
    assertEquals(1, errors.size());
    assertFalse(result.isValid());
    assertTrue(errors.contains("This store does not currently support QUERY_AGGREGATION"));
  }

  /**
   * Test {@link ViewValidator#validateEdge(View, Schema, Set, boolean, ValidationResult)}.
   *
   * <p>Method under test: {@link ViewValidator#validateEdge(View, Schema, Set, boolean,
   * ValidationResult)}
   */
  @Test
  @DisplayName("Test validateEdge(View, Schema, Set, boolean, ValidationResult)")
  @Tag("MaintainedByDiffblue")
  void testValidateEdge3() {
    // Arrange
    ViewValidator viewValidator = new ViewValidator();

    LinkedHashSet<String> stringSet = new LinkedHashSet<>();
    stringSet.add("Transient Properties");

    ArrayList<TupleAdaptedBinaryOperator<String, ?>> components = new ArrayList<>();
    components.add(new TupleAdaptedBinaryOperator<>());

    ElementAggregator elementAggregator = new ElementAggregator.Builder().build();
    elementAggregator.setComponents(components);

    ArrayList<TupleAdaptedPredicate<String, ?>> components2 = new ArrayList<>();
    components2.add(new TupleAdaptedPredicate<>());

    ElementFilter elementFilter = new Builder().build();
    elementFilter.setComponents(components2);

    ArrayList<TupleAdaptedPredicate<String, ?>> components3 = new ArrayList<>();
    components3.add(new TupleAdaptedPredicate<>());

    ElementFilter elementFilter2 = new Builder().build();
    elementFilter2.setComponents(components3);

    ArrayList<TupleAdaptedPredicate<String, ?>> components4 = new ArrayList<>();
    components4.add(new TupleAdaptedPredicate<>());

    ElementFilter elementFilter3 = new Builder().build();
    elementFilter3.setComponents(components4);

    GlobalViewElementDefinition globalViewElementDefinition =
        mock(GlobalViewElementDefinition.class);
    when(globalViewElementDefinition.getGroupBy()).thenReturn(null);
    when(globalViewElementDefinition.getTransientProperties()).thenReturn(stringSet);
    when(globalViewElementDefinition.getAggregator()).thenReturn(elementAggregator);
    when(globalViewElementDefinition.getPostAggregationFilter()).thenReturn(elementFilter);
    when(globalViewElementDefinition.getPostTransformFilter()).thenReturn(elementFilter2);
    when(globalViewElementDefinition.getPreAggregationFilter()).thenReturn(elementFilter3);
    when(globalViewElementDefinition.getTransformer()).thenReturn(null);

    HashMap<String, ViewElementDefinition> stringViewElementDefinitionMap = new HashMap<>();
    stringViewElementDefinitionMap.put("foo", globalViewElementDefinition);

    NamedView view = mock(NamedView.class);
    when(view.getConfig(Mockito.<String>any())).thenReturn(Boolean.TRUE.toString());
    when(view.getEdges()).thenReturn(stringViewElementDefinitionMap);

    Schema schema = mock(Schema.class);
    when(schema.getEdge(Mockito.<String>any())).thenReturn(new SchemaEdgeDefinition());
    HashSet<StoreTrait> storeTraits = new HashSet<>();
    Class<Object> output = Object.class;
    Class<Object> input = Object.class;

    ValidationResult result = OperationUtil.isValid(output, input);

    // Act
    viewValidator.validateEdge(view, schema, storeTraits, true, result);

    // Assert
    verify(schema).getEdge("foo");
    verify(view, atLeast(1)).getEdges();
    verify(view).getConfig("skipViewValidation");
    verify(globalViewElementDefinition).getAggregator();
    verify(globalViewElementDefinition).getGroupBy();
    verify(globalViewElementDefinition).getPostAggregationFilter();
    verify(globalViewElementDefinition).getPostTransformFilter();
    verify(globalViewElementDefinition).getPreAggregationFilter();
    verify(globalViewElementDefinition).getTransformer();
    verify(globalViewElementDefinition).getTransientProperties();
    assertEquals(
        "Validation errors: \n"
            + "This store does not currently support QUERY_AGGREGATION\n"
            + "This store does not currently support PRE_AGGREGATION_FILTERING\n"
            + "This store does not currently support POST_AGGREGATION_FILTERING\n"
            + "This store does not currently support POST_TRANSFORMATION_FILTERING",
        result.getErrorString());
    Set<String> errors = result.getErrors();
    assertEquals(4, errors.size());
    assertTrue(
        errors.contains("This store does not currently support POST_TRANSFORMATION_FILTERING"));
    assertTrue(errors.contains("This store does not currently support PRE_AGGREGATION_FILTERING"));
  }

  /**
   * Test {@link ViewValidator#validateEdge(View, Schema, Set, boolean, ValidationResult)}.
   *
   * <p>Method under test: {@link ViewValidator#validateEdge(View, Schema, Set, boolean,
   * ValidationResult)}
   */
  @Test
  @DisplayName("Test validateEdge(View, Schema, Set, boolean, ValidationResult)")
  @Tag("MaintainedByDiffblue")
  void testValidateEdge4() {
    // Arrange
    ViewValidator viewValidator = new ViewValidator();

    LinkedHashSet<String> stringSet = new LinkedHashSet<>();
    stringSet.add("Transient Properties");

    ArrayList<TupleAdaptedBinaryOperator<String, ?>> components = new ArrayList<>();
    components.add(new TupleAdaptedBinaryOperator<>());

    ElementAggregator elementAggregator = new ElementAggregator.Builder().build();
    elementAggregator.setComponents(components);

    GlobalViewElementDefinition globalViewElementDefinition =
        mock(GlobalViewElementDefinition.class);
    when(globalViewElementDefinition.getGroupBy()).thenReturn(null);
    when(globalViewElementDefinition.getTransientProperties()).thenReturn(stringSet);
    when(globalViewElementDefinition.getAggregator()).thenReturn(elementAggregator);
    when(globalViewElementDefinition.getPostAggregationFilter()).thenReturn(null);
    when(globalViewElementDefinition.getPostTransformFilter()).thenReturn(null);
    when(globalViewElementDefinition.getPreAggregationFilter()).thenReturn(null);
    when(globalViewElementDefinition.getTransformer()).thenReturn(null);

    HashMap<String, ViewElementDefinition> stringViewElementDefinitionMap = new HashMap<>();
    stringViewElementDefinitionMap.put("foo", globalViewElementDefinition);

    NamedView view = mock(NamedView.class);
    when(view.getConfig(Mockito.<String>any())).thenReturn("Transient property ");
    when(view.getEdges()).thenReturn(stringViewElementDefinitionMap);

    SchemaEdgeDefinition schemaEdgeDefinition = mock(SchemaEdgeDefinition.class);
    when(schemaEdgeDefinition.containsProperty(Mockito.<String>any())).thenReturn(true);

    Schema schema = mock(Schema.class);
    when(schema.getEdge(Mockito.<String>any())).thenReturn(schemaEdgeDefinition);
    HashSet<StoreTrait> storeTraits = new HashSet<>();
    Class<Object> output = Object.class;
    Class<Object> input = Object.class;

    ValidationResult result = OperationUtil.isValid(output, input);

    // Act
    viewValidator.validateEdge(view, schema, storeTraits, true, result);

    // Assert
    verify(schema).getEdge("foo");
    verify(view, atLeast(1)).getEdges();
    verify(view).getConfig("skipViewValidation");
    verify(globalViewElementDefinition, atLeast(1)).getAggregator();
    verify(globalViewElementDefinition).getGroupBy();
    verify(globalViewElementDefinition, atLeast(1)).getPostAggregationFilter();
    verify(globalViewElementDefinition, atLeast(1)).getPostTransformFilter();
    verify(globalViewElementDefinition, atLeast(1)).getPreAggregationFilter();
    verify(globalViewElementDefinition, atLeast(1)).getTransformer();
    verify(globalViewElementDefinition).getTransientProperties();
    verify(schemaEdgeDefinition).containsProperty("Transient Properties");
    assertEquals(
        "Validation errors: \n"
            + "Transient property Transient Properties for edge group foo is not transient as it has been found in"
            + " the schema\n"
            + "This store does not currently support QUERY_AGGREGATION\n"
            + "ElementAggregator contains a null function.",
        result.getErrorString());
    Set<String> errors = result.getErrors();
    assertEquals(3, errors.size());
    assertTrue(errors.contains("ElementAggregator contains a null function."));
    assertTrue(errors.contains("This store does not currently support QUERY_AGGREGATION"));
  }

  /**
   * Test {@link ViewValidator#validateEdge(View, Schema, Set, boolean, ValidationResult)}.
   *
   * <p>Method under test: {@link ViewValidator#validateEdge(View, Schema, Set, boolean,
   * ValidationResult)}
   */
  @Test
  @DisplayName("Test validateEdge(View, Schema, Set, boolean, ValidationResult)")
  @Tag("MaintainedByDiffblue")
  void testValidateEdge5() {
    // Arrange
    ViewValidator viewValidator = new ViewValidator();

    LinkedHashSet<String> stringSet = new LinkedHashSet<>();
    stringSet.add("Transient Properties");
    String[] selection = new String[] {"Transient property "};

    TupleAdaptedBinaryOperator<String, ?> tupleAdaptedBinaryOperator =
        new TupleAdaptedBinaryOperator<>(mock(BinaryOperator.class), selection);
    tupleAdaptedBinaryOperator.setBinaryOperator(mock(BinaryOperator.class));

    ArrayList<TupleAdaptedBinaryOperator<String, ?>> components = new ArrayList<>();
    components.add(tupleAdaptedBinaryOperator);

    ElementAggregator elementAggregator = new ElementAggregator.Builder().build();
    elementAggregator.setComponents(components);

    GlobalViewElementDefinition globalViewElementDefinition =
        mock(GlobalViewElementDefinition.class);
    when(globalViewElementDefinition.getGroupBy()).thenReturn(null);
    when(globalViewElementDefinition.getTransientProperties()).thenReturn(stringSet);
    when(globalViewElementDefinition.getAggregator()).thenReturn(elementAggregator);
    when(globalViewElementDefinition.getPostAggregationFilter()).thenReturn(null);
    when(globalViewElementDefinition.getPostTransformFilter()).thenReturn(null);
    when(globalViewElementDefinition.getPreAggregationFilter()).thenReturn(null);
    when(globalViewElementDefinition.getTransformer()).thenReturn(null);

    HashMap<String, ViewElementDefinition> stringViewElementDefinitionMap = new HashMap<>();
    stringViewElementDefinitionMap.put("foo", globalViewElementDefinition);

    NamedView view = mock(NamedView.class);
    when(view.getConfig(Mockito.<String>any())).thenReturn("Transient property ");
    when(view.getEdges()).thenReturn(stringViewElementDefinitionMap);

    SchemaEdgeDefinition schemaEdgeDefinition = mock(SchemaEdgeDefinition.class);
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>>when(schemaEdgeDefinition.getPropertyClass(Mockito.<String>any()))
        .thenReturn(forNameResult);
    when(schemaEdgeDefinition.containsProperty(Mockito.<String>any())).thenReturn(true);

    Schema schema = mock(Schema.class);
    when(schema.getEdge(Mockito.<String>any())).thenReturn(schemaEdgeDefinition);
    HashSet<StoreTrait> storeTraits = new HashSet<>();
    Class<Object> output = Object.class;
    Class<Object> input = Object.class;

    ValidationResult result = OperationUtil.isValid(output, input);

    // Act
    viewValidator.validateEdge(view, schema, storeTraits, true, result);

    // Assert
    verify(schema).getEdge("foo");
    verify(view, atLeast(1)).getEdges();
    verify(view).getConfig("skipViewValidation");
    verify(globalViewElementDefinition, atLeast(1)).getAggregator();
    verify(globalViewElementDefinition).getGroupBy();
    verify(globalViewElementDefinition, atLeast(1)).getPostAggregationFilter();
    verify(globalViewElementDefinition, atLeast(1)).getPostTransformFilter();
    verify(globalViewElementDefinition, atLeast(1)).getPreAggregationFilter();
    verify(globalViewElementDefinition, atLeast(1)).getTransformer();
    verify(globalViewElementDefinition).getTransientProperties();
    verify(schemaEdgeDefinition).containsProperty("Transient Properties");
    verify(schemaEdgeDefinition).getPropertyClass("Transient property ");
    assertEquals(
        "Validation errors: \n"
            + "Transient property Transient Properties for edge group foo is not transient as it has been found in"
            + " the schema\n"
            + "This store does not currently support QUERY_AGGREGATION",
        result.getErrorString());
    Set<String> errors = result.getErrors();
    assertEquals(2, errors.size());
    assertTrue(errors.contains("This store does not currently support QUERY_AGGREGATION"));
    assertTrue(
        errors.contains(
            "Transient property Transient Properties for edge group foo is not transient as it has been found in"
                + " the schema"));
  }

  /**
   * Test {@link ViewValidator#validateEdge(View, Schema, Set, boolean, ValidationResult)}.
   *
   * <ul>
   *   <li>Given {@link ElementAggregator.Builder#Builder()} build Components is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ViewValidator#validateEdge(View, Schema, Set, boolean,
   * ValidationResult)}
   */
  @Test
  @DisplayName(
      "Test validateEdge(View, Schema, Set, boolean, ValidationResult); given Builder() build Components is 'null'")
  @Tag("MaintainedByDiffblue")
  void testValidateEdge_givenBuilderBuildComponentsIsNull() {
    // Arrange
    ViewValidator viewValidator = new ViewValidator();

    LinkedHashSet<String> stringSet = new LinkedHashSet<>();
    stringSet.add("Transient Properties");

    ElementAggregator elementAggregator = new ElementAggregator.Builder().build();
    elementAggregator.setComponents(null);

    ElementFilter elementFilter = new Builder().build();
    elementFilter.setComponents(null);

    ElementFilter elementFilter2 = new Builder().build();
    elementFilter2.setComponents(null);

    ElementFilter elementFilter3 = new Builder().build();
    elementFilter3.setComponents(null);

    GlobalViewElementDefinition globalViewElementDefinition =
        mock(GlobalViewElementDefinition.class);
    when(globalViewElementDefinition.getGroupBy()).thenReturn(null);
    when(globalViewElementDefinition.getTransientProperties()).thenReturn(stringSet);
    when(globalViewElementDefinition.getAggregator()).thenReturn(elementAggregator);
    when(globalViewElementDefinition.getPostAggregationFilter()).thenReturn(elementFilter);
    when(globalViewElementDefinition.getPostTransformFilter()).thenReturn(elementFilter2);
    when(globalViewElementDefinition.getPreAggregationFilter()).thenReturn(elementFilter3);
    when(globalViewElementDefinition.getTransformer()).thenReturn(null);

    HashMap<String, ViewElementDefinition> stringViewElementDefinitionMap = new HashMap<>();
    stringViewElementDefinitionMap.put("foo", globalViewElementDefinition);

    NamedView view = mock(NamedView.class);
    when(view.getConfig(Mockito.<String>any())).thenReturn(Boolean.TRUE.toString());
    when(view.getEdges()).thenReturn(stringViewElementDefinitionMap);

    Schema schema = mock(Schema.class);
    when(schema.getEdge(Mockito.<String>any())).thenReturn(new SchemaEdgeDefinition());
    HashSet<StoreTrait> storeTraits = new HashSet<>();
    Class<Object> output = Object.class;
    Class<Object> input = Object.class;

    ValidationResult result = OperationUtil.isValid(output, input);

    // Act
    viewValidator.validateEdge(view, schema, storeTraits, true, result);

    // Assert
    verify(schema).getEdge("foo");
    verify(view, atLeast(1)).getEdges();
    verify(view).getConfig("skipViewValidation");
    verify(globalViewElementDefinition).getAggregator();
    verify(globalViewElementDefinition).getGroupBy();
    verify(globalViewElementDefinition).getPostAggregationFilter();
    verify(globalViewElementDefinition).getPostTransformFilter();
    verify(globalViewElementDefinition).getPreAggregationFilter();
    verify(globalViewElementDefinition).getTransformer();
    verify(globalViewElementDefinition).getTransientProperties();
    assertEquals(
        "Validation errors: \nThis store does not currently support QUERY_AGGREGATION",
        result.getErrorString());
    Set<String> errors = result.getErrors();
    assertEquals(1, errors.size());
    assertFalse(result.isValid());
    assertTrue(errors.contains("This store does not currently support QUERY_AGGREGATION"));
  }

  /**
   * Test {@link ViewValidator#validateEdge(View, Schema, Set, boolean, ValidationResult)}.
   *
   * <ul>
   *   <li>Given {@link ElementAggregator.Builder#Builder()} build Components is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ViewValidator#validateEdge(View, Schema, Set, boolean,
   * ValidationResult)}
   */
  @Test
  @DisplayName(
      "Test validateEdge(View, Schema, Set, boolean, ValidationResult); given Builder() build Components is 'null'")
  @Tag("MaintainedByDiffblue")
  void testValidateEdge_givenBuilderBuildComponentsIsNull2() {
    // Arrange
    ViewValidator viewValidator = new ViewValidator();

    LinkedHashSet<String> stringSet = new LinkedHashSet<>();
    stringSet.add("Transient Properties");

    ElementAggregator elementAggregator = new ElementAggregator.Builder().build();
    elementAggregator.setComponents(null);

    GlobalViewElementDefinition globalViewElementDefinition =
        mock(GlobalViewElementDefinition.class);
    when(globalViewElementDefinition.getGroupBy()).thenReturn(null);
    when(globalViewElementDefinition.getTransientProperties()).thenReturn(stringSet);
    when(globalViewElementDefinition.getAggregator()).thenReturn(elementAggregator);
    when(globalViewElementDefinition.getPostAggregationFilter()).thenReturn(null);
    when(globalViewElementDefinition.getPostTransformFilter()).thenReturn(null);
    when(globalViewElementDefinition.getPreAggregationFilter()).thenReturn(null);
    when(globalViewElementDefinition.getTransformer()).thenReturn(null);

    HashMap<String, ViewElementDefinition> stringViewElementDefinitionMap = new HashMap<>();
    stringViewElementDefinitionMap.put("foo", globalViewElementDefinition);

    NamedView view = mock(NamedView.class);
    when(view.getConfig(Mockito.<String>any())).thenReturn("Transient property ");
    when(view.getEdges()).thenReturn(stringViewElementDefinitionMap);

    SchemaEdgeDefinition schemaEdgeDefinition = mock(SchemaEdgeDefinition.class);
    when(schemaEdgeDefinition.containsProperty(Mockito.<String>any())).thenReturn(true);

    Schema schema = mock(Schema.class);
    when(schema.getEdge(Mockito.<String>any())).thenReturn(schemaEdgeDefinition);
    HashSet<StoreTrait> storeTraits = new HashSet<>();
    Class<Object> output = Object.class;
    Class<Object> input = Object.class;

    ValidationResult result = OperationUtil.isValid(output, input);

    // Act
    viewValidator.validateEdge(view, schema, storeTraits, true, result);

    // Assert
    verify(schema).getEdge("foo");
    verify(view, atLeast(1)).getEdges();
    verify(view).getConfig("skipViewValidation");
    verify(globalViewElementDefinition, atLeast(1)).getAggregator();
    verify(globalViewElementDefinition).getGroupBy();
    verify(globalViewElementDefinition, atLeast(1)).getPostAggregationFilter();
    verify(globalViewElementDefinition, atLeast(1)).getPostTransformFilter();
    verify(globalViewElementDefinition, atLeast(1)).getPreAggregationFilter();
    verify(globalViewElementDefinition, atLeast(1)).getTransformer();
    verify(globalViewElementDefinition).getTransientProperties();
    verify(schemaEdgeDefinition).containsProperty("Transient Properties");
    assertEquals(
        "Validation errors: \n"
            + "Transient property Transient Properties for edge group foo is not transient as it has been found in"
            + " the schema\n"
            + "This store does not currently support QUERY_AGGREGATION",
        result.getErrorString());
    Set<String> errors = result.getErrors();
    assertEquals(2, errors.size());
    assertTrue(errors.contains("This store does not currently support QUERY_AGGREGATION"));
    assertTrue(
        errors.contains(
            "Transient property Transient Properties for edge group foo is not transient as it has been found in"
                + " the schema"));
  }

  /**
   * Test {@link ViewValidator#validateEdge(View, Schema, Set, boolean, ValidationResult)}.
   *
   * <ul>
   *   <li>Given {@link Boolean#FALSE} toString.
   *   <li>When {@link NamedView} {@link NamedView#getConfig(String)} return {@link Boolean#FALSE}
   *       toString.
   * </ul>
   *
   * <p>Method under test: {@link ViewValidator#validateEdge(View, Schema, Set, boolean,
   * ValidationResult)}
   */
  @Test
  @DisplayName(
      "Test validateEdge(View, Schema, Set, boolean, ValidationResult); given FALSE toString; when NamedView getConfig(String) return FALSE toString")
  @Tag("MaintainedByDiffblue")
  void testValidateEdge_givenFalseToString_whenNamedViewGetConfigReturnFalseToString() {
    // Arrange
    ViewValidator viewValidator = new ViewValidator();

    HashMap<String, ViewElementDefinition> stringViewElementDefinitionMap = new HashMap<>();
    stringViewElementDefinitionMap.put("foo", new ViewElementDefinition());

    NamedView view = mock(NamedView.class);
    when(view.getConfig(Mockito.<String>any())).thenReturn(Boolean.FALSE.toString());
    when(view.getEdges()).thenReturn(stringViewElementDefinitionMap);

    Schema schema = mock(Schema.class);
    when(schema.getEdge(Mockito.<String>any())).thenReturn(new SchemaEdgeDefinition());
    HashSet<StoreTrait> storeTraits = new HashSet<>();
    Class<Object> output = Object.class;
    Class<Object> input = Object.class;

    ValidationResult result = OperationUtil.isValid(output, input);

    // Act
    viewValidator.validateEdge(view, schema, storeTraits, true, result);

    // Assert that nothing has changed
    verify(schema).getEdge("foo");
    verify(view, atLeast(1)).getEdges();
    verify(view).getConfig("skipViewValidation");
    assertEquals("Validation errors: \n", result.getErrorString());
    assertTrue(result.getErrors().isEmpty());
    assertTrue(result.isValid());
  }

  /**
   * Test {@link ViewValidator#validateEdge(View, Schema, Set, boolean, ValidationResult)}.
   *
   * <ul>
   *   <li>Given {@link GlobalViewElementDefinition} {@link
   *       GlobalViewElementDefinition#getAggregator()} return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ViewValidator#validateEdge(View, Schema, Set, boolean,
   * ValidationResult)}
   */
  @Test
  @DisplayName(
      "Test validateEdge(View, Schema, Set, boolean, ValidationResult); given GlobalViewElementDefinition getAggregator() return 'null'")
  @Tag("MaintainedByDiffblue")
  void testValidateEdge_givenGlobalViewElementDefinitionGetAggregatorReturnNull() {
    // Arrange
    ViewValidator viewValidator = new ViewValidator();

    LinkedHashSet<String> stringSet = new LinkedHashSet<>();
    stringSet.add("Transient Properties");

    GlobalViewElementDefinition globalViewElementDefinition =
        mock(GlobalViewElementDefinition.class);
    when(globalViewElementDefinition.getGroupBy()).thenReturn(null);
    when(globalViewElementDefinition.getTransientProperties()).thenReturn(stringSet);
    when(globalViewElementDefinition.getAggregator()).thenReturn(null);
    when(globalViewElementDefinition.getPostAggregationFilter()).thenReturn(null);
    when(globalViewElementDefinition.getPostTransformFilter()).thenReturn(null);
    when(globalViewElementDefinition.getPreAggregationFilter()).thenReturn(null);
    when(globalViewElementDefinition.getTransformer()).thenReturn(null);

    HashMap<String, ViewElementDefinition> stringViewElementDefinitionMap = new HashMap<>();
    stringViewElementDefinitionMap.put("foo", globalViewElementDefinition);

    NamedView view = mock(NamedView.class);
    when(view.getConfig(Mockito.<String>any())).thenReturn(Boolean.TRUE.toString());
    when(view.getEdges()).thenReturn(stringViewElementDefinitionMap);

    SchemaEdgeDefinition schemaEdgeDefinition = mock(SchemaEdgeDefinition.class);
    when(schemaEdgeDefinition.containsProperty(Mockito.<String>any())).thenReturn(true);

    Schema schema = mock(Schema.class);
    when(schema.getEdge(Mockito.<String>any())).thenReturn(schemaEdgeDefinition);
    HashSet<StoreTrait> storeTraits = new HashSet<>();
    Class<Object> output = Object.class;
    Class<Object> input = Object.class;

    ValidationResult result = OperationUtil.isValid(output, input);

    // Act
    viewValidator.validateEdge(view, schema, storeTraits, true, result);

    // Assert
    verify(schema).getEdge("foo");
    verify(view, atLeast(1)).getEdges();
    verify(view).getConfig("skipViewValidation");
    verify(globalViewElementDefinition).getAggregator();
    verify(globalViewElementDefinition).getGroupBy();
    verify(globalViewElementDefinition).getPostAggregationFilter();
    verify(globalViewElementDefinition).getPostTransformFilter();
    verify(globalViewElementDefinition).getPreAggregationFilter();
    verify(globalViewElementDefinition).getTransformer();
    verify(globalViewElementDefinition).getTransientProperties();
    verify(schemaEdgeDefinition).containsProperty("Transient Properties");
    assertEquals(
        "Validation errors: \n"
            + "Transient property Transient Properties for edge group foo is not transient as it has been found in"
            + " the schema",
        result.getErrorString());
    Set<String> errors = result.getErrors();
    assertEquals(1, errors.size());
    assertFalse(result.isValid());
    assertTrue(
        errors.contains(
            "Transient property Transient Properties for edge group foo is not transient as it has been found in"
                + " the schema"));
  }

  /**
   * Test {@link ViewValidator#validateEdge(View, Schema, Set, boolean, ValidationResult)}.
   *
   * <ul>
   *   <li>Given {@link GlobalViewElementDefinition} {@link
   *       GlobalViewElementDefinition#getAggregator()} return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ViewValidator#validateEdge(View, Schema, Set, boolean,
   * ValidationResult)}
   */
  @Test
  @DisplayName(
      "Test validateEdge(View, Schema, Set, boolean, ValidationResult); given GlobalViewElementDefinition getAggregator() return 'null'")
  @Tag("MaintainedByDiffblue")
  void testValidateEdge_givenGlobalViewElementDefinitionGetAggregatorReturnNull2() {
    // Arrange
    ViewValidator viewValidator = new ViewValidator();

    LinkedHashSet<String> stringSet = new LinkedHashSet<>();
    stringSet.add("Transient Properties");

    GlobalViewElementDefinition globalViewElementDefinition =
        mock(GlobalViewElementDefinition.class);
    when(globalViewElementDefinition.getGroupBy()).thenReturn(null);
    when(globalViewElementDefinition.getTransientProperties()).thenReturn(stringSet);
    when(globalViewElementDefinition.getAggregator()).thenReturn(null);
    when(globalViewElementDefinition.getPostAggregationFilter()).thenReturn(null);
    when(globalViewElementDefinition.getPostTransformFilter()).thenReturn(null);
    when(globalViewElementDefinition.getPreAggregationFilter()).thenReturn(null);
    when(globalViewElementDefinition.getTransformer()).thenReturn(null);

    HashMap<String, ViewElementDefinition> stringViewElementDefinitionMap = new HashMap<>();
    stringViewElementDefinitionMap.put("foo", globalViewElementDefinition);

    NamedView view = mock(NamedView.class);
    when(view.getConfig(Mockito.<String>any())).thenReturn("Transient property ");
    when(view.getEdges()).thenReturn(stringViewElementDefinitionMap);

    SchemaEdgeDefinition schemaEdgeDefinition = mock(SchemaEdgeDefinition.class);
    when(schemaEdgeDefinition.containsProperty(Mockito.<String>any())).thenReturn(true);

    Schema schema = mock(Schema.class);
    when(schema.getEdge(Mockito.<String>any())).thenReturn(schemaEdgeDefinition);
    HashSet<StoreTrait> storeTraits = new HashSet<>();
    Class<Object> output = Object.class;
    Class<Object> input = Object.class;

    ValidationResult result = OperationUtil.isValid(output, input);

    // Act
    viewValidator.validateEdge(view, schema, storeTraits, true, result);

    // Assert
    verify(schema).getEdge("foo");
    verify(view, atLeast(1)).getEdges();
    verify(view).getConfig("skipViewValidation");
    verify(globalViewElementDefinition, atLeast(1)).getAggregator();
    verify(globalViewElementDefinition).getGroupBy();
    verify(globalViewElementDefinition, atLeast(1)).getPostAggregationFilter();
    verify(globalViewElementDefinition, atLeast(1)).getPostTransformFilter();
    verify(globalViewElementDefinition, atLeast(1)).getPreAggregationFilter();
    verify(globalViewElementDefinition, atLeast(1)).getTransformer();
    verify(globalViewElementDefinition).getTransientProperties();
    verify(schemaEdgeDefinition).containsProperty("Transient Properties");
    assertEquals(
        "Validation errors: \n"
            + "Transient property Transient Properties for edge group foo is not transient as it has been found in"
            + " the schema",
        result.getErrorString());
    Set<String> errors = result.getErrors();
    assertEquals(1, errors.size());
    assertFalse(result.isValid());
    assertTrue(
        errors.contains(
            "Transient property Transient Properties for edge group foo is not transient as it has been found in"
                + " the schema"));
  }

  /**
   * Test {@link ViewValidator#validateEdge(View, Schema, Set, boolean, ValidationResult)}.
   *
   * <ul>
   *   <li>Given {@link GlobalViewElementDefinition} {@link
   *       GlobalViewElementDefinition#getGroupBy()} return {@link HashSet#HashSet()}.
   * </ul>
   *
   * <p>Method under test: {@link ViewValidator#validateEdge(View, Schema, Set, boolean,
   * ValidationResult)}
   */
  @Test
  @DisplayName(
      "Test validateEdge(View, Schema, Set, boolean, ValidationResult); given GlobalViewElementDefinition getGroupBy() return HashSet()")
  @Tag("MaintainedByDiffblue")
  void testValidateEdge_givenGlobalViewElementDefinitionGetGroupByReturnHashSet() {
    // Arrange
    ViewValidator viewValidator = new ViewValidator();

    GlobalViewElementDefinition globalViewElementDefinition =
        mock(GlobalViewElementDefinition.class);
    when(globalViewElementDefinition.getGroupBy()).thenReturn(new HashSet<>());
    when(globalViewElementDefinition.getTransientProperties()).thenReturn(new HashSet<>());
    when(globalViewElementDefinition.getAggregator())
        .thenReturn(new ElementAggregator.Builder().build());
    when(globalViewElementDefinition.getPostAggregationFilter()).thenReturn(new Builder().build());
    when(globalViewElementDefinition.getPostTransformFilter()).thenReturn(new Builder().build());
    when(globalViewElementDefinition.getPreAggregationFilter()).thenReturn(new Builder().build());
    when(globalViewElementDefinition.getTransformer())
        .thenReturn(new ElementTransformer.Builder().build());

    HashMap<String, ViewElementDefinition> stringViewElementDefinitionMap = new HashMap<>();
    stringViewElementDefinitionMap.put("foo", globalViewElementDefinition);

    NamedView view = mock(NamedView.class);
    when(view.getConfig(Mockito.<String>any())).thenReturn(Boolean.TRUE.toString());
    when(view.getEdges()).thenReturn(stringViewElementDefinitionMap);

    Schema schema = mock(Schema.class);
    when(schema.getEdge(Mockito.<String>any())).thenReturn(new SchemaEdgeDefinition());
    HashSet<StoreTrait> storeTraits = new HashSet<>();
    Class<Object> output = Object.class;
    Class<Object> input = Object.class;

    ValidationResult result = OperationUtil.isValid(output, input);

    // Act
    viewValidator.validateEdge(view, schema, storeTraits, true, result);

    // Assert
    verify(schema).getEdge("foo");
    verify(view, atLeast(1)).getEdges();
    verify(view).getConfig("skipViewValidation");
    verify(globalViewElementDefinition).getAggregator();
    verify(globalViewElementDefinition).getGroupBy();
    verify(globalViewElementDefinition).getPostAggregationFilter();
    verify(globalViewElementDefinition).getPostTransformFilter();
    verify(globalViewElementDefinition).getPreAggregationFilter();
    verify(globalViewElementDefinition).getTransformer();
    verify(globalViewElementDefinition).getTransientProperties();
    assertEquals(
        "Validation errors: \nThis store does not currently support QUERY_AGGREGATION",
        result.getErrorString());
    Set<String> errors = result.getErrors();
    assertEquals(1, errors.size());
    assertFalse(result.isValid());
    assertTrue(errors.contains("This store does not currently support QUERY_AGGREGATION"));
  }

  /**
   * Test {@link ViewValidator#validateEdge(View, Schema, Set, boolean, ValidationResult)}.
   *
   * <ul>
   *   <li>Given {@link HashMap#HashMap()}.
   * </ul>
   *
   * <p>Method under test: {@link ViewValidator#validateEdge(View, Schema, Set, boolean,
   * ValidationResult)}
   */
  @Test
  @DisplayName("Test validateEdge(View, Schema, Set, boolean, ValidationResult); given HashMap()")
  @Tag("MaintainedByDiffblue")
  void testValidateEdge_givenHashMap() {
    // Arrange
    ViewValidator viewValidator = new ViewValidator();

    NamedView view = mock(NamedView.class);
    when(view.getEdges()).thenReturn(new HashMap<>());
    Schema schema = new Schema();
    HashSet<StoreTrait> storeTraits = new HashSet<>();
    Class<Object> output = Object.class;
    Class<Object> input = Object.class;

    ValidationResult result = OperationUtil.isValid(output, input);

    // Act
    viewValidator.validateEdge(view, schema, storeTraits, true, result);

    // Assert that nothing has changed
    verify(view, atLeast(1)).getEdges();
    assertEquals("Validation errors: \n", result.getErrorString());
    assertTrue(result.getErrors().isEmpty());
    assertTrue(result.isValid());
  }

  /**
   * Test {@link ViewValidator#validateEdge(View, Schema, Set, boolean, ValidationResult)}.
   *
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} {@code foo} is {@link ViewElementDefinition} (default
   *       constructor).
   * </ul>
   *
   * <p>Method under test: {@link ViewValidator#validateEdge(View, Schema, Set, boolean,
   * ValidationResult)}
   */
  @Test
  @DisplayName(
      "Test validateEdge(View, Schema, Set, boolean, ValidationResult); given HashMap() 'foo' is ViewElementDefinition (default constructor)")
  @Tag("MaintainedByDiffblue")
  void testValidateEdge_givenHashMapFooIsViewElementDefinition() {
    // Arrange
    ViewValidator viewValidator = new ViewValidator();

    HashMap<String, ViewElementDefinition> stringViewElementDefinitionMap = new HashMap<>();
    stringViewElementDefinitionMap.put("foo", new ViewElementDefinition());

    NamedView view = mock(NamedView.class);
    when(view.getConfig(Mockito.<String>any())).thenReturn(Boolean.TRUE.toString());
    when(view.getEdges()).thenReturn(stringViewElementDefinitionMap);

    Schema schema = mock(Schema.class);
    when(schema.getEdge(Mockito.<String>any())).thenReturn(new SchemaEdgeDefinition());
    HashSet<StoreTrait> storeTraits = new HashSet<>();
    Class<Object> output = Object.class;
    Class<Object> input = Object.class;

    ValidationResult result = OperationUtil.isValid(output, input);

    // Act
    viewValidator.validateEdge(view, schema, storeTraits, true, result);

    // Assert that nothing has changed
    verify(schema).getEdge("foo");
    verify(view, atLeast(1)).getEdges();
    verify(view).getConfig("skipViewValidation");
    assertEquals("Validation errors: \n", result.getErrorString());
    assertTrue(result.getErrors().isEmpty());
    assertTrue(result.isValid());
  }

  /**
   * Test {@link ViewValidator#validateEdge(View, Schema, Set, boolean, ValidationResult)}.
   *
   * <ul>
   *   <li>Given {@code INGEST_AGGREGATION}.
   *   <li>When {@link HashSet#HashSet()} add {@code INGEST_AGGREGATION}.
   * </ul>
   *
   * <p>Method under test: {@link ViewValidator#validateEdge(View, Schema, Set, boolean,
   * ValidationResult)}
   */
  @Test
  @DisplayName(
      "Test validateEdge(View, Schema, Set, boolean, ValidationResult); given 'INGEST_AGGREGATION'; when HashSet() add 'INGEST_AGGREGATION'")
  @Tag("MaintainedByDiffblue")
  void testValidateEdge_givenIngestAggregation_whenHashSetAddIngestAggregation() {
    // Arrange
    ViewValidator viewValidator = new ViewValidator();

    NamedView view = mock(NamedView.class);
    when(view.getEdges()).thenReturn(new HashMap<>());
    Schema schema = new Schema();

    HashSet<StoreTrait> storeTraits = new HashSet<>();
    storeTraits.add(StoreTrait.INGEST_AGGREGATION);
    Class<Object> output = Object.class;
    Class<Object> input = Object.class;

    ValidationResult result = OperationUtil.isValid(output, input);

    // Act
    viewValidator.validateEdge(view, schema, storeTraits, true, result);

    // Assert that nothing has changed
    verify(view, atLeast(1)).getEdges();
    assertEquals("Validation errors: \n", result.getErrorString());
    assertTrue(result.getErrors().isEmpty());
    assertTrue(result.isValid());
  }

  /**
   * Test {@link ViewValidator#validateEdge(View, Schema, Set, boolean, ValidationResult)}.
   *
   * <ul>
   *   <li>Given {@code INGEST_AGGREGATION}.
   *   <li>When {@link HashSet#HashSet()} add {@code INGEST_AGGREGATION}.
   * </ul>
   *
   * <p>Method under test: {@link ViewValidator#validateEdge(View, Schema, Set, boolean,
   * ValidationResult)}
   */
  @Test
  @DisplayName(
      "Test validateEdge(View, Schema, Set, boolean, ValidationResult); given 'INGEST_AGGREGATION'; when HashSet() add 'INGEST_AGGREGATION'")
  @Tag("MaintainedByDiffblue")
  void testValidateEdge_givenIngestAggregation_whenHashSetAddIngestAggregation2() {
    // Arrange
    ViewValidator viewValidator = new ViewValidator();

    NamedView view = mock(NamedView.class);
    when(view.getEdges()).thenReturn(new HashMap<>());
    Schema schema = new Schema();

    HashSet<StoreTrait> storeTraits = new HashSet<>();
    storeTraits.add(StoreTrait.QUERY_AGGREGATION);
    storeTraits.add(StoreTrait.INGEST_AGGREGATION);
    Class<Object> output = Object.class;
    Class<Object> input = Object.class;

    ValidationResult result = OperationUtil.isValid(output, input);

    // Act
    viewValidator.validateEdge(view, schema, storeTraits, true, result);

    // Assert that nothing has changed
    verify(view, atLeast(1)).getEdges();
    assertEquals("Validation errors: \n", result.getErrorString());
    assertTrue(result.getErrors().isEmpty());
    assertTrue(result.isValid());
  }

  /**
   * Test {@link ViewValidator#validateEdge(View, Schema, Set, boolean, ValidationResult)}.
   *
   * <ul>
   *   <li>Given {@code PRE_AGGREGATION_FILTERING}.
   * </ul>
   *
   * <p>Method under test: {@link ViewValidator#validateEdge(View, Schema, Set, boolean,
   * ValidationResult)}
   */
  @Test
  @DisplayName(
      "Test validateEdge(View, Schema, Set, boolean, ValidationResult); given 'PRE_AGGREGATION_FILTERING'")
  @Tag("MaintainedByDiffblue")
  void testValidateEdge_givenPreAggregationFiltering() {
    // Arrange
    ViewValidator viewValidator = new ViewValidator();

    LinkedHashSet<String> stringSet = new LinkedHashSet<>();
    stringSet.add("Transient Properties");

    GlobalViewElementDefinition globalViewElementDefinition =
        mock(GlobalViewElementDefinition.class);
    when(globalViewElementDefinition.getGroupBy()).thenReturn(null);
    when(globalViewElementDefinition.getTransientProperties()).thenReturn(stringSet);
    when(globalViewElementDefinition.getAggregator()).thenReturn(null);
    when(globalViewElementDefinition.getPostAggregationFilter()).thenReturn(null);
    when(globalViewElementDefinition.getPostTransformFilter()).thenReturn(null);
    when(globalViewElementDefinition.getPreAggregationFilter()).thenReturn(null);
    when(globalViewElementDefinition.getTransformer()).thenReturn(null);

    HashMap<String, ViewElementDefinition> stringViewElementDefinitionMap = new HashMap<>();
    stringViewElementDefinitionMap.put("foo", globalViewElementDefinition);

    NamedView view = mock(NamedView.class);
    when(view.getConfig(Mockito.<String>any())).thenReturn("Transient property ");
    when(view.getEdges()).thenReturn(stringViewElementDefinitionMap);

    SchemaEdgeDefinition schemaEdgeDefinition = mock(SchemaEdgeDefinition.class);
    when(schemaEdgeDefinition.containsProperty(Mockito.<String>any())).thenReturn(true);

    Schema schema = mock(Schema.class);
    when(schema.getEdge(Mockito.<String>any())).thenReturn(schemaEdgeDefinition);

    HashSet<StoreTrait> storeTraits = new HashSet<>();
    storeTraits.add(StoreTrait.PRE_AGGREGATION_FILTERING);
    storeTraits.add(StoreTrait.QUERY_AGGREGATION);
    Class<Object> output = Object.class;
    Class<Object> input = Object.class;

    ValidationResult result = OperationUtil.isValid(output, input);

    // Act
    viewValidator.validateEdge(view, schema, storeTraits, true, result);

    // Assert
    verify(schema).getEdge("foo");
    verify(view, atLeast(1)).getEdges();
    verify(view).getConfig("skipViewValidation");
    verify(globalViewElementDefinition).getAggregator();
    verify(globalViewElementDefinition).getGroupBy();
    verify(globalViewElementDefinition, atLeast(1)).getPostAggregationFilter();
    verify(globalViewElementDefinition, atLeast(1)).getPostTransformFilter();
    verify(globalViewElementDefinition, atLeast(1)).getPreAggregationFilter();
    verify(globalViewElementDefinition, atLeast(1)).getTransformer();
    verify(globalViewElementDefinition).getTransientProperties();
    verify(schemaEdgeDefinition).containsProperty("Transient Properties");
    assertEquals(
        "Validation errors: \n"
            + "Transient property Transient Properties for edge group foo is not transient as it has been found in"
            + " the schema",
        result.getErrorString());
    Set<String> errors = result.getErrors();
    assertEquals(1, errors.size());
    assertFalse(result.isValid());
    assertTrue(
        errors.contains(
            "Transient property Transient Properties for edge group foo is not transient as it has been found in"
                + " the schema"));
  }

  /**
   * Test {@link ViewValidator#validateEdge(View, Schema, Set, boolean, ValidationResult)}.
   *
   * <ul>
   *   <li>Given {@code QUERY_AGGREGATION}.
   *   <li>When {@link HashSet#HashSet()} add {@code QUERY_AGGREGATION}.
   * </ul>
   *
   * <p>Method under test: {@link ViewValidator#validateEdge(View, Schema, Set, boolean,
   * ValidationResult)}
   */
  @Test
  @DisplayName(
      "Test validateEdge(View, Schema, Set, boolean, ValidationResult); given 'QUERY_AGGREGATION'; when HashSet() add 'QUERY_AGGREGATION'")
  @Tag("MaintainedByDiffblue")
  void testValidateEdge_givenQueryAggregation_whenHashSetAddQueryAggregation() {
    // Arrange
    ViewValidator viewValidator = new ViewValidator();

    LinkedHashSet<String> stringSet = new LinkedHashSet<>();
    stringSet.add("Transient Properties");

    GlobalViewElementDefinition globalViewElementDefinition =
        mock(GlobalViewElementDefinition.class);
    when(globalViewElementDefinition.getGroupBy()).thenReturn(null);
    when(globalViewElementDefinition.getTransientProperties()).thenReturn(stringSet);
    when(globalViewElementDefinition.getAggregator()).thenReturn(null);
    when(globalViewElementDefinition.getPostAggregationFilter()).thenReturn(null);
    when(globalViewElementDefinition.getPostTransformFilter()).thenReturn(null);
    when(globalViewElementDefinition.getPreAggregationFilter()).thenReturn(null);
    when(globalViewElementDefinition.getTransformer()).thenReturn(null);

    HashMap<String, ViewElementDefinition> stringViewElementDefinitionMap = new HashMap<>();
    stringViewElementDefinitionMap.put("foo", globalViewElementDefinition);

    NamedView view = mock(NamedView.class);
    when(view.getConfig(Mockito.<String>any())).thenReturn("Transient property ");
    when(view.getEdges()).thenReturn(stringViewElementDefinitionMap);

    SchemaEdgeDefinition schemaEdgeDefinition = mock(SchemaEdgeDefinition.class);
    when(schemaEdgeDefinition.containsProperty(Mockito.<String>any())).thenReturn(true);

    Schema schema = mock(Schema.class);
    when(schema.getEdge(Mockito.<String>any())).thenReturn(schemaEdgeDefinition);

    HashSet<StoreTrait> storeTraits = new HashSet<>();
    storeTraits.add(StoreTrait.QUERY_AGGREGATION);
    Class<Object> output = Object.class;
    Class<Object> input = Object.class;

    ValidationResult result = OperationUtil.isValid(output, input);

    // Act
    viewValidator.validateEdge(view, schema, storeTraits, true, result);

    // Assert
    verify(schema).getEdge("foo");
    verify(view, atLeast(1)).getEdges();
    verify(view).getConfig("skipViewValidation");
    verify(globalViewElementDefinition).getAggregator();
    verify(globalViewElementDefinition).getGroupBy();
    verify(globalViewElementDefinition, atLeast(1)).getPostAggregationFilter();
    verify(globalViewElementDefinition, atLeast(1)).getPostTransformFilter();
    verify(globalViewElementDefinition, atLeast(1)).getPreAggregationFilter();
    verify(globalViewElementDefinition, atLeast(1)).getTransformer();
    verify(globalViewElementDefinition).getTransientProperties();
    verify(schemaEdgeDefinition).containsProperty("Transient Properties");
    assertEquals(
        "Validation errors: \n"
            + "Transient property Transient Properties for edge group foo is not transient as it has been found in"
            + " the schema",
        result.getErrorString());
    Set<String> errors = result.getErrors();
    assertEquals(1, errors.size());
    assertFalse(result.isValid());
    assertTrue(
        errors.contains(
            "Transient property Transient Properties for edge group foo is not transient as it has been found in"
                + " the schema"));
  }

  /**
   * Test {@link ViewValidator#validateEdge(View, Schema, Set, boolean, ValidationResult)}.
   *
   * <ul>
   *   <li>Then Valid {@link Object} is {@link Object} ErrorString is {@code Validation errors:}.
   * </ul>
   *
   * <p>Method under test: {@link ViewValidator#validateEdge(View, Schema, Set, boolean,
   * ValidationResult)}
   */
  @Test
  @DisplayName(
      "Test validateEdge(View, Schema, Set, boolean, ValidationResult); then Valid Object is Object ErrorString is 'Validation errors:'")
  @Tag("MaintainedByDiffblue")
  void testValidateEdge_thenValidObjectIsObjectErrorStringIsValidationErrors() {
    // Arrange
    ViewValidator viewValidator = new ViewValidator();

    LinkedHashSet<String> stringSet = new LinkedHashSet<>();
    stringSet.add("Transient Properties");

    GlobalViewElementDefinition globalViewElementDefinition =
        mock(GlobalViewElementDefinition.class);
    when(globalViewElementDefinition.getGroupBy()).thenReturn(null);
    when(globalViewElementDefinition.getTransientProperties()).thenReturn(stringSet);
    when(globalViewElementDefinition.getAggregator()).thenReturn(null);
    when(globalViewElementDefinition.getPostAggregationFilter()).thenReturn(null);
    when(globalViewElementDefinition.getPostTransformFilter()).thenReturn(null);
    when(globalViewElementDefinition.getPreAggregationFilter()).thenReturn(null);
    when(globalViewElementDefinition.getTransformer()).thenReturn(null);

    HashMap<String, ViewElementDefinition> stringViewElementDefinitionMap = new HashMap<>();
    stringViewElementDefinitionMap.put("foo", globalViewElementDefinition);

    NamedView view = mock(NamedView.class);
    when(view.getConfig(Mockito.<String>any())).thenReturn(Boolean.TRUE.toString());
    when(view.getEdges()).thenReturn(stringViewElementDefinitionMap);

    Schema schema = mock(Schema.class);
    when(schema.getEdge(Mockito.<String>any())).thenReturn(new SchemaEdgeDefinition());
    HashSet<StoreTrait> storeTraits = new HashSet<>();
    Class<Object> output = Object.class;
    Class<Object> input = Object.class;

    ValidationResult result = OperationUtil.isValid(output, input);

    // Act
    viewValidator.validateEdge(view, schema, storeTraits, true, result);

    // Assert that nothing has changed
    verify(schema).getEdge("foo");
    verify(view, atLeast(1)).getEdges();
    verify(view).getConfig("skipViewValidation");
    verify(globalViewElementDefinition).getAggregator();
    verify(globalViewElementDefinition).getGroupBy();
    verify(globalViewElementDefinition).getPostAggregationFilter();
    verify(globalViewElementDefinition).getPostTransformFilter();
    verify(globalViewElementDefinition).getPreAggregationFilter();
    verify(globalViewElementDefinition).getTransformer();
    verify(globalViewElementDefinition).getTransientProperties();
    assertEquals("Validation errors: \n", result.getErrorString());
    assertTrue(result.getErrors().isEmpty());
    assertTrue(result.isValid());
  }

  /**
   * Test {@link ViewValidator#validateEdge(View, Schema, Set, boolean, ValidationResult)}.
   *
   * <ul>
   *   <li>Then Valid {@link Object} is {@link Object} Errors size is two.
   * </ul>
   *
   * <p>Method under test: {@link ViewValidator#validateEdge(View, Schema, Set, boolean,
   * ValidationResult)}
   */
  @Test
  @DisplayName(
      "Test validateEdge(View, Schema, Set, boolean, ValidationResult); then Valid Object is Object Errors size is two")
  @Tag("MaintainedByDiffblue")
  void testValidateEdge_thenValidObjectIsObjectErrorsSizeIsTwo() {
    // Arrange
    ViewValidator viewValidator = new ViewValidator();

    LinkedHashSet<String> stringSet = new LinkedHashSet<>();
    stringSet.add("Transient Properties");

    GlobalViewElementDefinition globalViewElementDefinition =
        mock(GlobalViewElementDefinition.class);
    when(globalViewElementDefinition.getGroupBy()).thenReturn(null);
    when(globalViewElementDefinition.getTransientProperties()).thenReturn(stringSet);
    when(globalViewElementDefinition.getAggregator())
        .thenReturn(new ElementAggregator.Builder().build());
    when(globalViewElementDefinition.getPostAggregationFilter()).thenReturn(null);
    when(globalViewElementDefinition.getPostTransformFilter()).thenReturn(null);
    when(globalViewElementDefinition.getPreAggregationFilter()).thenReturn(null);
    when(globalViewElementDefinition.getTransformer()).thenReturn(null);

    HashMap<String, ViewElementDefinition> stringViewElementDefinitionMap = new HashMap<>();
    stringViewElementDefinitionMap.put("foo", globalViewElementDefinition);

    NamedView view = mock(NamedView.class);
    when(view.getConfig(Mockito.<String>any())).thenReturn("Transient property ");
    when(view.getEdges()).thenReturn(stringViewElementDefinitionMap);

    SchemaEdgeDefinition schemaEdgeDefinition = mock(SchemaEdgeDefinition.class);
    when(schemaEdgeDefinition.containsProperty(Mockito.<String>any())).thenReturn(true);

    Schema schema = mock(Schema.class);
    when(schema.getEdge(Mockito.<String>any())).thenReturn(schemaEdgeDefinition);
    HashSet<StoreTrait> storeTraits = new HashSet<>();
    Class<Object> output = Object.class;
    Class<Object> input = Object.class;

    ValidationResult result = OperationUtil.isValid(output, input);

    // Act
    viewValidator.validateEdge(view, schema, storeTraits, true, result);

    // Assert
    verify(schema).getEdge("foo");
    verify(view, atLeast(1)).getEdges();
    verify(view).getConfig("skipViewValidation");
    verify(globalViewElementDefinition, atLeast(1)).getAggregator();
    verify(globalViewElementDefinition).getGroupBy();
    verify(globalViewElementDefinition, atLeast(1)).getPostAggregationFilter();
    verify(globalViewElementDefinition, atLeast(1)).getPostTransformFilter();
    verify(globalViewElementDefinition, atLeast(1)).getPreAggregationFilter();
    verify(globalViewElementDefinition, atLeast(1)).getTransformer();
    verify(globalViewElementDefinition).getTransientProperties();
    verify(schemaEdgeDefinition).containsProperty("Transient Properties");
    assertEquals(
        "Validation errors: \n"
            + "Transient property Transient Properties for edge group foo is not transient as it has been found in"
            + " the schema\n"
            + "This store does not currently support QUERY_AGGREGATION",
        result.getErrorString());
    Set<String> errors = result.getErrors();
    assertEquals(2, errors.size());
    assertTrue(errors.contains("This store does not currently support QUERY_AGGREGATION"));
    assertTrue(
        errors.contains(
            "Transient property Transient Properties for edge group foo is not transient as it has been found in"
                + " the schema"));
  }

  /**
   * Test {@link ViewValidator#validateEdge(View, Schema, Set, boolean, ValidationResult)}.
   *
   * <ul>
   *   <li>When {@link View} (default constructor).
   *   <li>Then Valid {@link Object} is {@link Object} ErrorString is {@code Validation errors:}.
   * </ul>
   *
   * <p>Method under test: {@link ViewValidator#validateEdge(View, Schema, Set, boolean,
   * ValidationResult)}
   */
  @Test
  @DisplayName(
      "Test validateEdge(View, Schema, Set, boolean, ValidationResult); when View (default constructor); then Valid Object is Object ErrorString is 'Validation errors:'")
  @Tag("MaintainedByDiffblue")
  void testValidateEdge_whenView_thenValidObjectIsObjectErrorStringIsValidationErrors() {
    // Arrange
    ViewValidator viewValidator = new ViewValidator();
    View view = new View();
    Schema schema = new Schema();
    HashSet<StoreTrait> storeTraits = new HashSet<>();
    Class<Object> output = Object.class;
    Class<Object> input = Object.class;

    ValidationResult result = OperationUtil.isValid(output, input);

    // Act
    viewValidator.validateEdge(view, schema, storeTraits, true, result);

    // Assert that nothing has changed
    assertEquals("Validation errors: \n", result.getErrorString());
    assertTrue(result.getErrors().isEmpty());
    assertTrue(result.isValid());
  }

  /**
   * Test {@link ViewValidator#validateEntities(View, Schema, Set, boolean, ValidationResult)}.
   *
   * <p>Method under test: {@link ViewValidator#validateEntities(View, Schema, Set, boolean,
   * ValidationResult)}
   */
  @Test
  @DisplayName("Test validateEntities(View, Schema, Set, boolean, ValidationResult)")
  @Tag("MaintainedByDiffblue")
  void testValidateEntities() {
    // Arrange
    ViewValidator viewValidator = new ViewValidator();

    HashMap<String, ViewElementDefinition> stringViewElementDefinitionMap = new HashMap<>();
    stringViewElementDefinitionMap.put("foo", new ViewElementDefinition());

    NamedView view = mock(NamedView.class);
    when(view.getEntities()).thenReturn(stringViewElementDefinitionMap);
    Schema schema = new Schema();
    HashSet<StoreTrait> storeTraits = new HashSet<>();
    Class<Object> output = Object.class;
    Class<Object> input = Object.class;

    ValidationResult result = OperationUtil.isValid(output, input);

    // Act
    viewValidator.validateEntities(view, schema, storeTraits, true, result);

    // Assert
    verify(view, atLeast(1)).getEntities();
    assertEquals(
        "Validation errors: \nEntity group foo does not exist in the schema",
        result.getErrorString());
    Set<String> errors = result.getErrors();
    assertEquals(1, errors.size());
    assertFalse(result.isValid());
    assertTrue(errors.contains("Entity group foo does not exist in the schema"));
  }

  /**
   * Test {@link ViewValidator#validateEntities(View, Schema, Set, boolean, ValidationResult)}.
   *
   * <p>Method under test: {@link ViewValidator#validateEntities(View, Schema, Set, boolean,
   * ValidationResult)}
   */
  @Test
  @DisplayName("Test validateEntities(View, Schema, Set, boolean, ValidationResult)")
  @Tag("MaintainedByDiffblue")
  void testValidateEntities2() {
    // Arrange
    ViewValidator viewValidator = new ViewValidator();

    LinkedHashSet<String> stringSet = new LinkedHashSet<>();
    stringSet.add("Transient Properties");

    ElementAggregator elementAggregator = new ElementAggregator.Builder().build();
    elementAggregator.setComponents(new ArrayList<>());

    ElementFilter elementFilter = new Builder().build();
    elementFilter.setComponents(new ArrayList<>());

    ElementFilter elementFilter2 = new Builder().build();
    elementFilter2.setComponents(new ArrayList<>());

    ElementFilter elementFilter3 = new Builder().build();
    elementFilter3.setComponents(new ArrayList<>());

    GlobalViewElementDefinition globalViewElementDefinition =
        mock(GlobalViewElementDefinition.class);
    when(globalViewElementDefinition.getGroupBy()).thenReturn(null);
    when(globalViewElementDefinition.getTransientProperties()).thenReturn(stringSet);
    when(globalViewElementDefinition.getAggregator()).thenReturn(elementAggregator);
    when(globalViewElementDefinition.getPostAggregationFilter()).thenReturn(elementFilter);
    when(globalViewElementDefinition.getPostTransformFilter()).thenReturn(elementFilter2);
    when(globalViewElementDefinition.getPreAggregationFilter()).thenReturn(elementFilter3);
    when(globalViewElementDefinition.getTransformer()).thenReturn(null);

    HashMap<String, ViewElementDefinition> stringViewElementDefinitionMap = new HashMap<>();
    stringViewElementDefinitionMap.put("foo", globalViewElementDefinition);

    NamedView view = mock(NamedView.class);
    when(view.getConfig(Mockito.<String>any())).thenReturn(Boolean.TRUE.toString());
    when(view.getEntities()).thenReturn(stringViewElementDefinitionMap);

    Schema schema = mock(Schema.class);
    when(schema.getEntity(Mockito.<String>any())).thenReturn(new SchemaEntityDefinition());
    HashSet<StoreTrait> storeTraits = new HashSet<>();
    Class<Object> output = Object.class;
    Class<Object> input = Object.class;

    ValidationResult result = OperationUtil.isValid(output, input);

    // Act
    viewValidator.validateEntities(view, schema, storeTraits, true, result);

    // Assert
    verify(view, atLeast(1)).getEntities();
    verify(schema).getEntity("foo");
    verify(view).getConfig("skipViewValidation");
    verify(globalViewElementDefinition).getAggregator();
    verify(globalViewElementDefinition).getGroupBy();
    verify(globalViewElementDefinition).getPostAggregationFilter();
    verify(globalViewElementDefinition).getPostTransformFilter();
    verify(globalViewElementDefinition).getPreAggregationFilter();
    verify(globalViewElementDefinition).getTransformer();
    verify(globalViewElementDefinition).getTransientProperties();
    assertEquals(
        "Validation errors: \nThis store does not currently support QUERY_AGGREGATION",
        result.getErrorString());
    Set<String> errors = result.getErrors();
    assertEquals(1, errors.size());
    assertFalse(result.isValid());
    assertTrue(errors.contains("This store does not currently support QUERY_AGGREGATION"));
  }

  /**
   * Test {@link ViewValidator#validateEntities(View, Schema, Set, boolean, ValidationResult)}.
   *
   * <p>Method under test: {@link ViewValidator#validateEntities(View, Schema, Set, boolean,
   * ValidationResult)}
   */
  @Test
  @DisplayName("Test validateEntities(View, Schema, Set, boolean, ValidationResult)")
  @Tag("MaintainedByDiffblue")
  void testValidateEntities3() {
    // Arrange
    ViewValidator viewValidator = new ViewValidator();

    LinkedHashSet<String> stringSet = new LinkedHashSet<>();
    stringSet.add("Transient Properties");

    ArrayList<TupleAdaptedBinaryOperator<String, ?>> components = new ArrayList<>();
    components.add(new TupleAdaptedBinaryOperator<>());

    ElementAggregator elementAggregator = new ElementAggregator.Builder().build();
    elementAggregator.setComponents(components);

    ArrayList<TupleAdaptedPredicate<String, ?>> components2 = new ArrayList<>();
    components2.add(new TupleAdaptedPredicate<>());

    ElementFilter elementFilter = new Builder().build();
    elementFilter.setComponents(components2);

    ArrayList<TupleAdaptedPredicate<String, ?>> components3 = new ArrayList<>();
    components3.add(new TupleAdaptedPredicate<>());

    ElementFilter elementFilter2 = new Builder().build();
    elementFilter2.setComponents(components3);

    ArrayList<TupleAdaptedPredicate<String, ?>> components4 = new ArrayList<>();
    components4.add(new TupleAdaptedPredicate<>());

    ElementFilter elementFilter3 = new Builder().build();
    elementFilter3.setComponents(components4);

    GlobalViewElementDefinition globalViewElementDefinition =
        mock(GlobalViewElementDefinition.class);
    when(globalViewElementDefinition.getGroupBy()).thenReturn(null);
    when(globalViewElementDefinition.getTransientProperties()).thenReturn(stringSet);
    when(globalViewElementDefinition.getAggregator()).thenReturn(elementAggregator);
    when(globalViewElementDefinition.getPostAggregationFilter()).thenReturn(elementFilter);
    when(globalViewElementDefinition.getPostTransformFilter()).thenReturn(elementFilter2);
    when(globalViewElementDefinition.getPreAggregationFilter()).thenReturn(elementFilter3);
    when(globalViewElementDefinition.getTransformer()).thenReturn(null);

    HashMap<String, ViewElementDefinition> stringViewElementDefinitionMap = new HashMap<>();
    stringViewElementDefinitionMap.put("foo", globalViewElementDefinition);

    NamedView view = mock(NamedView.class);
    when(view.getConfig(Mockito.<String>any())).thenReturn(Boolean.TRUE.toString());
    when(view.getEntities()).thenReturn(stringViewElementDefinitionMap);

    Schema schema = mock(Schema.class);
    when(schema.getEntity(Mockito.<String>any())).thenReturn(new SchemaEntityDefinition());
    HashSet<StoreTrait> storeTraits = new HashSet<>();
    Class<Object> output = Object.class;
    Class<Object> input = Object.class;

    ValidationResult result = OperationUtil.isValid(output, input);

    // Act
    viewValidator.validateEntities(view, schema, storeTraits, true, result);

    // Assert
    verify(view, atLeast(1)).getEntities();
    verify(schema).getEntity("foo");
    verify(view).getConfig("skipViewValidation");
    verify(globalViewElementDefinition).getAggregator();
    verify(globalViewElementDefinition).getGroupBy();
    verify(globalViewElementDefinition).getPostAggregationFilter();
    verify(globalViewElementDefinition).getPostTransformFilter();
    verify(globalViewElementDefinition).getPreAggregationFilter();
    verify(globalViewElementDefinition).getTransformer();
    verify(globalViewElementDefinition).getTransientProperties();
    assertEquals(
        "Validation errors: \n"
            + "This store does not currently support QUERY_AGGREGATION\n"
            + "This store does not currently support PRE_AGGREGATION_FILTERING\n"
            + "This store does not currently support POST_AGGREGATION_FILTERING\n"
            + "This store does not currently support POST_TRANSFORMATION_FILTERING",
        result.getErrorString());
    Set<String> errors = result.getErrors();
    assertEquals(4, errors.size());
    assertTrue(
        errors.contains("This store does not currently support POST_TRANSFORMATION_FILTERING"));
    assertTrue(errors.contains("This store does not currently support PRE_AGGREGATION_FILTERING"));
  }

  /**
   * Test {@link ViewValidator#validateEntities(View, Schema, Set, boolean, ValidationResult)}.
   *
   * <p>Method under test: {@link ViewValidator#validateEntities(View, Schema, Set, boolean,
   * ValidationResult)}
   */
  @Test
  @DisplayName("Test validateEntities(View, Schema, Set, boolean, ValidationResult)")
  @Tag("MaintainedByDiffblue")
  void testValidateEntities4() {
    // Arrange
    ViewValidator viewValidator = new ViewValidator();

    LinkedHashSet<String> stringSet = new LinkedHashSet<>();
    stringSet.add("Transient Properties");

    ArrayList<TupleAdaptedBinaryOperator<String, ?>> components = new ArrayList<>();
    components.add(new TupleAdaptedBinaryOperator<>());

    ElementAggregator elementAggregator = new ElementAggregator.Builder().build();
    elementAggregator.setComponents(components);

    GlobalViewElementDefinition globalViewElementDefinition =
        mock(GlobalViewElementDefinition.class);
    when(globalViewElementDefinition.getGroupBy()).thenReturn(null);
    when(globalViewElementDefinition.getTransientProperties()).thenReturn(stringSet);
    when(globalViewElementDefinition.getAggregator()).thenReturn(elementAggregator);
    when(globalViewElementDefinition.getPostAggregationFilter()).thenReturn(null);
    when(globalViewElementDefinition.getPostTransformFilter()).thenReturn(null);
    when(globalViewElementDefinition.getPreAggregationFilter()).thenReturn(null);
    when(globalViewElementDefinition.getTransformer()).thenReturn(null);

    HashMap<String, ViewElementDefinition> stringViewElementDefinitionMap = new HashMap<>();
    stringViewElementDefinitionMap.put("foo", globalViewElementDefinition);

    NamedView view = mock(NamedView.class);
    when(view.getConfig(Mockito.<String>any())).thenReturn("Transient property ");
    when(view.getEntities()).thenReturn(stringViewElementDefinitionMap);

    SchemaEntityDefinition schemaEntityDefinition = mock(SchemaEntityDefinition.class);
    when(schemaEntityDefinition.containsProperty(Mockito.<String>any())).thenReturn(true);

    Schema schema = mock(Schema.class);
    when(schema.getEntity(Mockito.<String>any())).thenReturn(schemaEntityDefinition);
    HashSet<StoreTrait> storeTraits = new HashSet<>();
    Class<Object> output = Object.class;
    Class<Object> input = Object.class;

    ValidationResult result = OperationUtil.isValid(output, input);

    // Act
    viewValidator.validateEntities(view, schema, storeTraits, true, result);

    // Assert
    verify(view, atLeast(1)).getEntities();
    verify(schema).getEntity("foo");
    verify(view).getConfig("skipViewValidation");
    verify(globalViewElementDefinition, atLeast(1)).getAggregator();
    verify(globalViewElementDefinition).getGroupBy();
    verify(globalViewElementDefinition, atLeast(1)).getPostAggregationFilter();
    verify(globalViewElementDefinition, atLeast(1)).getPostTransformFilter();
    verify(globalViewElementDefinition, atLeast(1)).getPreAggregationFilter();
    verify(globalViewElementDefinition, atLeast(1)).getTransformer();
    verify(globalViewElementDefinition).getTransientProperties();
    verify(schemaEntityDefinition).containsProperty("Transient Properties");
    assertEquals(
        "Validation errors: \n"
            + "Transient property Transient Properties for entity group foo is not transient as it has been found in"
            + " the schema\n"
            + "This store does not currently support QUERY_AGGREGATION\n"
            + "ElementAggregator contains a null function.",
        result.getErrorString());
    Set<String> errors = result.getErrors();
    assertEquals(3, errors.size());
    assertTrue(errors.contains("ElementAggregator contains a null function."));
    assertTrue(errors.contains("This store does not currently support QUERY_AGGREGATION"));
  }

  /**
   * Test {@link ViewValidator#validateEntities(View, Schema, Set, boolean, ValidationResult)}.
   *
   * <p>Method under test: {@link ViewValidator#validateEntities(View, Schema, Set, boolean,
   * ValidationResult)}
   */
  @Test
  @DisplayName("Test validateEntities(View, Schema, Set, boolean, ValidationResult)")
  @Tag("MaintainedByDiffblue")
  void testValidateEntities5() {
    // Arrange
    ViewValidator viewValidator = new ViewValidator();

    LinkedHashSet<String> stringSet = new LinkedHashSet<>();
    stringSet.add("Transient Properties");
    String[] selection = new String[] {"Transient property "};

    TupleAdaptedBinaryOperator<String, ?> tupleAdaptedBinaryOperator =
        new TupleAdaptedBinaryOperator<>(mock(BinaryOperator.class), selection);
    tupleAdaptedBinaryOperator.setBinaryOperator(mock(BinaryOperator.class));

    ArrayList<TupleAdaptedBinaryOperator<String, ?>> components = new ArrayList<>();
    components.add(tupleAdaptedBinaryOperator);

    ElementAggregator elementAggregator = new ElementAggregator.Builder().build();
    elementAggregator.setComponents(components);

    GlobalViewElementDefinition globalViewElementDefinition =
        mock(GlobalViewElementDefinition.class);
    when(globalViewElementDefinition.getGroupBy()).thenReturn(null);
    when(globalViewElementDefinition.getTransientProperties()).thenReturn(stringSet);
    when(globalViewElementDefinition.getAggregator()).thenReturn(elementAggregator);
    when(globalViewElementDefinition.getPostAggregationFilter()).thenReturn(null);
    when(globalViewElementDefinition.getPostTransformFilter()).thenReturn(null);
    when(globalViewElementDefinition.getPreAggregationFilter()).thenReturn(null);
    when(globalViewElementDefinition.getTransformer()).thenReturn(null);

    HashMap<String, ViewElementDefinition> stringViewElementDefinitionMap = new HashMap<>();
    stringViewElementDefinitionMap.put("foo", globalViewElementDefinition);

    NamedView view = mock(NamedView.class);
    when(view.getConfig(Mockito.<String>any())).thenReturn("Transient property ");
    when(view.getEntities()).thenReturn(stringViewElementDefinitionMap);

    SchemaEntityDefinition schemaEntityDefinition = mock(SchemaEntityDefinition.class);
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>>when(schemaEntityDefinition.getPropertyClass(Mockito.<String>any()))
        .thenReturn(forNameResult);
    when(schemaEntityDefinition.containsProperty(Mockito.<String>any())).thenReturn(true);

    Schema schema = mock(Schema.class);
    when(schema.getEntity(Mockito.<String>any())).thenReturn(schemaEntityDefinition);
    HashSet<StoreTrait> storeTraits = new HashSet<>();
    Class<Object> output = Object.class;
    Class<Object> input = Object.class;

    ValidationResult result = OperationUtil.isValid(output, input);

    // Act
    viewValidator.validateEntities(view, schema, storeTraits, true, result);

    // Assert
    verify(view, atLeast(1)).getEntities();
    verify(schema).getEntity("foo");
    verify(view).getConfig("skipViewValidation");
    verify(globalViewElementDefinition, atLeast(1)).getAggregator();
    verify(globalViewElementDefinition).getGroupBy();
    verify(globalViewElementDefinition, atLeast(1)).getPostAggregationFilter();
    verify(globalViewElementDefinition, atLeast(1)).getPostTransformFilter();
    verify(globalViewElementDefinition, atLeast(1)).getPreAggregationFilter();
    verify(globalViewElementDefinition, atLeast(1)).getTransformer();
    verify(globalViewElementDefinition).getTransientProperties();
    verify(schemaEntityDefinition).containsProperty("Transient Properties");
    verify(schemaEntityDefinition).getPropertyClass("Transient property ");
    assertEquals(
        "Validation errors: \n"
            + "Transient property Transient Properties for entity group foo is not transient as it has been found in"
            + " the schema\n"
            + "This store does not currently support QUERY_AGGREGATION",
        result.getErrorString());
    Set<String> errors = result.getErrors();
    assertEquals(2, errors.size());
    assertTrue(errors.contains("This store does not currently support QUERY_AGGREGATION"));
    assertTrue(
        errors.contains(
            "Transient property Transient Properties for entity group foo is not transient as it has been found in"
                + " the schema"));
  }

  /**
   * Test {@link ViewValidator#validateEntities(View, Schema, Set, boolean, ValidationResult)}.
   *
   * <ul>
   *   <li>Given {@link ElementAggregator.Builder#Builder()} build Components is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ViewValidator#validateEntities(View, Schema, Set, boolean,
   * ValidationResult)}
   */
  @Test
  @DisplayName(
      "Test validateEntities(View, Schema, Set, boolean, ValidationResult); given Builder() build Components is 'null'")
  @Tag("MaintainedByDiffblue")
  void testValidateEntities_givenBuilderBuildComponentsIsNull() {
    // Arrange
    ViewValidator viewValidator = new ViewValidator();

    LinkedHashSet<String> stringSet = new LinkedHashSet<>();
    stringSet.add("Transient Properties");

    ElementAggregator elementAggregator = new ElementAggregator.Builder().build();
    elementAggregator.setComponents(null);

    ElementFilter elementFilter = new Builder().build();
    elementFilter.setComponents(null);

    ElementFilter elementFilter2 = new Builder().build();
    elementFilter2.setComponents(null);

    ElementFilter elementFilter3 = new Builder().build();
    elementFilter3.setComponents(null);

    GlobalViewElementDefinition globalViewElementDefinition =
        mock(GlobalViewElementDefinition.class);
    when(globalViewElementDefinition.getGroupBy()).thenReturn(null);
    when(globalViewElementDefinition.getTransientProperties()).thenReturn(stringSet);
    when(globalViewElementDefinition.getAggregator()).thenReturn(elementAggregator);
    when(globalViewElementDefinition.getPostAggregationFilter()).thenReturn(elementFilter);
    when(globalViewElementDefinition.getPostTransformFilter()).thenReturn(elementFilter2);
    when(globalViewElementDefinition.getPreAggregationFilter()).thenReturn(elementFilter3);
    when(globalViewElementDefinition.getTransformer()).thenReturn(null);

    HashMap<String, ViewElementDefinition> stringViewElementDefinitionMap = new HashMap<>();
    stringViewElementDefinitionMap.put("foo", globalViewElementDefinition);

    NamedView view = mock(NamedView.class);
    when(view.getConfig(Mockito.<String>any())).thenReturn(Boolean.TRUE.toString());
    when(view.getEntities()).thenReturn(stringViewElementDefinitionMap);

    Schema schema = mock(Schema.class);
    when(schema.getEntity(Mockito.<String>any())).thenReturn(new SchemaEntityDefinition());
    HashSet<StoreTrait> storeTraits = new HashSet<>();
    Class<Object> output = Object.class;
    Class<Object> input = Object.class;

    ValidationResult result = OperationUtil.isValid(output, input);

    // Act
    viewValidator.validateEntities(view, schema, storeTraits, true, result);

    // Assert
    verify(view, atLeast(1)).getEntities();
    verify(schema).getEntity("foo");
    verify(view).getConfig("skipViewValidation");
    verify(globalViewElementDefinition).getAggregator();
    verify(globalViewElementDefinition).getGroupBy();
    verify(globalViewElementDefinition).getPostAggregationFilter();
    verify(globalViewElementDefinition).getPostTransformFilter();
    verify(globalViewElementDefinition).getPreAggregationFilter();
    verify(globalViewElementDefinition).getTransformer();
    verify(globalViewElementDefinition).getTransientProperties();
    assertEquals(
        "Validation errors: \nThis store does not currently support QUERY_AGGREGATION",
        result.getErrorString());
    Set<String> errors = result.getErrors();
    assertEquals(1, errors.size());
    assertFalse(result.isValid());
    assertTrue(errors.contains("This store does not currently support QUERY_AGGREGATION"));
  }

  /**
   * Test {@link ViewValidator#validateEntities(View, Schema, Set, boolean, ValidationResult)}.
   *
   * <ul>
   *   <li>Given {@link ElementAggregator.Builder#Builder()} build Components is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ViewValidator#validateEntities(View, Schema, Set, boolean,
   * ValidationResult)}
   */
  @Test
  @DisplayName(
      "Test validateEntities(View, Schema, Set, boolean, ValidationResult); given Builder() build Components is 'null'")
  @Tag("MaintainedByDiffblue")
  void testValidateEntities_givenBuilderBuildComponentsIsNull2() {
    // Arrange
    ViewValidator viewValidator = new ViewValidator();

    LinkedHashSet<String> stringSet = new LinkedHashSet<>();
    stringSet.add("Transient Properties");

    ElementAggregator elementAggregator = new ElementAggregator.Builder().build();
    elementAggregator.setComponents(null);

    GlobalViewElementDefinition globalViewElementDefinition =
        mock(GlobalViewElementDefinition.class);
    when(globalViewElementDefinition.getGroupBy()).thenReturn(null);
    when(globalViewElementDefinition.getTransientProperties()).thenReturn(stringSet);
    when(globalViewElementDefinition.getAggregator()).thenReturn(elementAggregator);
    when(globalViewElementDefinition.getPostAggregationFilter()).thenReturn(null);
    when(globalViewElementDefinition.getPostTransformFilter()).thenReturn(null);
    when(globalViewElementDefinition.getPreAggregationFilter()).thenReturn(null);
    when(globalViewElementDefinition.getTransformer()).thenReturn(null);

    HashMap<String, ViewElementDefinition> stringViewElementDefinitionMap = new HashMap<>();
    stringViewElementDefinitionMap.put("foo", globalViewElementDefinition);

    NamedView view = mock(NamedView.class);
    when(view.getConfig(Mockito.<String>any())).thenReturn("Transient property ");
    when(view.getEntities()).thenReturn(stringViewElementDefinitionMap);

    SchemaEntityDefinition schemaEntityDefinition = mock(SchemaEntityDefinition.class);
    when(schemaEntityDefinition.containsProperty(Mockito.<String>any())).thenReturn(true);

    Schema schema = mock(Schema.class);
    when(schema.getEntity(Mockito.<String>any())).thenReturn(schemaEntityDefinition);
    HashSet<StoreTrait> storeTraits = new HashSet<>();
    Class<Object> output = Object.class;
    Class<Object> input = Object.class;

    ValidationResult result = OperationUtil.isValid(output, input);

    // Act
    viewValidator.validateEntities(view, schema, storeTraits, true, result);

    // Assert
    verify(view, atLeast(1)).getEntities();
    verify(schema).getEntity("foo");
    verify(view).getConfig("skipViewValidation");
    verify(globalViewElementDefinition, atLeast(1)).getAggregator();
    verify(globalViewElementDefinition).getGroupBy();
    verify(globalViewElementDefinition, atLeast(1)).getPostAggregationFilter();
    verify(globalViewElementDefinition, atLeast(1)).getPostTransformFilter();
    verify(globalViewElementDefinition, atLeast(1)).getPreAggregationFilter();
    verify(globalViewElementDefinition, atLeast(1)).getTransformer();
    verify(globalViewElementDefinition).getTransientProperties();
    verify(schemaEntityDefinition).containsProperty("Transient Properties");
    assertEquals(
        "Validation errors: \n"
            + "Transient property Transient Properties for entity group foo is not transient as it has been found in"
            + " the schema\n"
            + "This store does not currently support QUERY_AGGREGATION",
        result.getErrorString());
    Set<String> errors = result.getErrors();
    assertEquals(2, errors.size());
    assertTrue(errors.contains("This store does not currently support QUERY_AGGREGATION"));
    assertTrue(
        errors.contains(
            "Transient property Transient Properties for entity group foo is not transient as it has been found in"
                + " the schema"));
  }

  /**
   * Test {@link ViewValidator#validateEntities(View, Schema, Set, boolean, ValidationResult)}.
   *
   * <ul>
   *   <li>Given {@link Boolean#FALSE} toString.
   * </ul>
   *
   * <p>Method under test: {@link ViewValidator#validateEntities(View, Schema, Set, boolean,
   * ValidationResult)}
   */
  @Test
  @DisplayName(
      "Test validateEntities(View, Schema, Set, boolean, ValidationResult); given FALSE toString")
  @Tag("MaintainedByDiffblue")
  void testValidateEntities_givenFalseToString() {
    // Arrange
    ViewValidator viewValidator = new ViewValidator();

    HashMap<String, ViewElementDefinition> stringViewElementDefinitionMap = new HashMap<>();
    stringViewElementDefinitionMap.put("foo", new ViewElementDefinition());

    NamedView view = mock(NamedView.class);
    when(view.getConfig(Mockito.<String>any())).thenReturn(Boolean.FALSE.toString());
    when(view.getEntities()).thenReturn(stringViewElementDefinitionMap);

    Schema schema = mock(Schema.class);
    when(schema.getEntity(Mockito.<String>any())).thenReturn(new SchemaEntityDefinition());
    HashSet<StoreTrait> storeTraits = new HashSet<>();
    Class<Object> output = Object.class;
    Class<Object> input = Object.class;

    ValidationResult result = OperationUtil.isValid(output, input);

    // Act
    viewValidator.validateEntities(view, schema, storeTraits, true, result);

    // Assert that nothing has changed
    verify(view, atLeast(1)).getEntities();
    verify(schema).getEntity("foo");
    verify(view).getConfig("skipViewValidation");
    assertEquals("Validation errors: \n", result.getErrorString());
    assertTrue(result.getErrors().isEmpty());
    assertTrue(result.isValid());
  }

  /**
   * Test {@link ViewValidator#validateEntities(View, Schema, Set, boolean, ValidationResult)}.
   *
   * <ul>
   *   <li>Given {@link GlobalViewElementDefinition} {@link
   *       GlobalViewElementDefinition#getAggregator()} return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ViewValidator#validateEntities(View, Schema, Set, boolean,
   * ValidationResult)}
   */
  @Test
  @DisplayName(
      "Test validateEntities(View, Schema, Set, boolean, ValidationResult); given GlobalViewElementDefinition getAggregator() return 'null'")
  @Tag("MaintainedByDiffblue")
  void testValidateEntities_givenGlobalViewElementDefinitionGetAggregatorReturnNull() {
    // Arrange
    ViewValidator viewValidator = new ViewValidator();

    LinkedHashSet<String> stringSet = new LinkedHashSet<>();
    stringSet.add("Transient Properties");

    GlobalViewElementDefinition globalViewElementDefinition =
        mock(GlobalViewElementDefinition.class);
    when(globalViewElementDefinition.getGroupBy()).thenReturn(null);
    when(globalViewElementDefinition.getTransientProperties()).thenReturn(stringSet);
    when(globalViewElementDefinition.getAggregator()).thenReturn(null);
    when(globalViewElementDefinition.getPostAggregationFilter()).thenReturn(null);
    when(globalViewElementDefinition.getPostTransformFilter()).thenReturn(null);
    when(globalViewElementDefinition.getPreAggregationFilter()).thenReturn(null);
    when(globalViewElementDefinition.getTransformer()).thenReturn(null);

    HashMap<String, ViewElementDefinition> stringViewElementDefinitionMap = new HashMap<>();
    stringViewElementDefinitionMap.put("foo", globalViewElementDefinition);

    NamedView view = mock(NamedView.class);
    when(view.getConfig(Mockito.<String>any())).thenReturn(Boolean.TRUE.toString());
    when(view.getEntities()).thenReturn(stringViewElementDefinitionMap);

    SchemaEntityDefinition schemaEntityDefinition = mock(SchemaEntityDefinition.class);
    when(schemaEntityDefinition.containsProperty(Mockito.<String>any())).thenReturn(true);

    Schema schema = mock(Schema.class);
    when(schema.getEntity(Mockito.<String>any())).thenReturn(schemaEntityDefinition);
    HashSet<StoreTrait> storeTraits = new HashSet<>();
    Class<Object> output = Object.class;
    Class<Object> input = Object.class;

    ValidationResult result = OperationUtil.isValid(output, input);

    // Act
    viewValidator.validateEntities(view, schema, storeTraits, true, result);

    // Assert
    verify(view, atLeast(1)).getEntities();
    verify(schema).getEntity("foo");
    verify(view).getConfig("skipViewValidation");
    verify(globalViewElementDefinition).getAggregator();
    verify(globalViewElementDefinition).getGroupBy();
    verify(globalViewElementDefinition).getPostAggregationFilter();
    verify(globalViewElementDefinition).getPostTransformFilter();
    verify(globalViewElementDefinition).getPreAggregationFilter();
    verify(globalViewElementDefinition).getTransformer();
    verify(globalViewElementDefinition).getTransientProperties();
    verify(schemaEntityDefinition).containsProperty("Transient Properties");
    assertEquals(
        "Validation errors: \n"
            + "Transient property Transient Properties for entity group foo is not transient as it has been found in"
            + " the schema",
        result.getErrorString());
    Set<String> errors = result.getErrors();
    assertEquals(1, errors.size());
    assertFalse(result.isValid());
    assertTrue(
        errors.contains(
            "Transient property Transient Properties for entity group foo is not transient as it has been found in"
                + " the schema"));
  }

  /**
   * Test {@link ViewValidator#validateEntities(View, Schema, Set, boolean, ValidationResult)}.
   *
   * <ul>
   *   <li>Given {@link GlobalViewElementDefinition} {@link
   *       GlobalViewElementDefinition#getAggregator()} return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ViewValidator#validateEntities(View, Schema, Set, boolean,
   * ValidationResult)}
   */
  @Test
  @DisplayName(
      "Test validateEntities(View, Schema, Set, boolean, ValidationResult); given GlobalViewElementDefinition getAggregator() return 'null'")
  @Tag("MaintainedByDiffblue")
  void testValidateEntities_givenGlobalViewElementDefinitionGetAggregatorReturnNull2() {
    // Arrange
    ViewValidator viewValidator = new ViewValidator();

    LinkedHashSet<String> stringSet = new LinkedHashSet<>();
    stringSet.add("Transient Properties");

    GlobalViewElementDefinition globalViewElementDefinition =
        mock(GlobalViewElementDefinition.class);
    when(globalViewElementDefinition.getGroupBy()).thenReturn(null);
    when(globalViewElementDefinition.getTransientProperties()).thenReturn(stringSet);
    when(globalViewElementDefinition.getAggregator()).thenReturn(null);
    when(globalViewElementDefinition.getPostAggregationFilter()).thenReturn(null);
    when(globalViewElementDefinition.getPostTransformFilter()).thenReturn(null);
    when(globalViewElementDefinition.getPreAggregationFilter()).thenReturn(null);
    when(globalViewElementDefinition.getTransformer()).thenReturn(null);

    HashMap<String, ViewElementDefinition> stringViewElementDefinitionMap = new HashMap<>();
    stringViewElementDefinitionMap.put("foo", globalViewElementDefinition);

    NamedView view = mock(NamedView.class);
    when(view.getConfig(Mockito.<String>any())).thenReturn("Transient property ");
    when(view.getEntities()).thenReturn(stringViewElementDefinitionMap);

    SchemaEntityDefinition schemaEntityDefinition = mock(SchemaEntityDefinition.class);
    when(schemaEntityDefinition.containsProperty(Mockito.<String>any())).thenReturn(true);

    Schema schema = mock(Schema.class);
    when(schema.getEntity(Mockito.<String>any())).thenReturn(schemaEntityDefinition);
    HashSet<StoreTrait> storeTraits = new HashSet<>();
    Class<Object> output = Object.class;
    Class<Object> input = Object.class;

    ValidationResult result = OperationUtil.isValid(output, input);

    // Act
    viewValidator.validateEntities(view, schema, storeTraits, true, result);

    // Assert
    verify(view, atLeast(1)).getEntities();
    verify(schema).getEntity("foo");
    verify(view).getConfig("skipViewValidation");
    verify(globalViewElementDefinition, atLeast(1)).getAggregator();
    verify(globalViewElementDefinition).getGroupBy();
    verify(globalViewElementDefinition, atLeast(1)).getPostAggregationFilter();
    verify(globalViewElementDefinition, atLeast(1)).getPostTransformFilter();
    verify(globalViewElementDefinition, atLeast(1)).getPreAggregationFilter();
    verify(globalViewElementDefinition, atLeast(1)).getTransformer();
    verify(globalViewElementDefinition).getTransientProperties();
    verify(schemaEntityDefinition).containsProperty("Transient Properties");
    assertEquals(
        "Validation errors: \n"
            + "Transient property Transient Properties for entity group foo is not transient as it has been found in"
            + " the schema",
        result.getErrorString());
    Set<String> errors = result.getErrors();
    assertEquals(1, errors.size());
    assertFalse(result.isValid());
    assertTrue(
        errors.contains(
            "Transient property Transient Properties for entity group foo is not transient as it has been found in"
                + " the schema"));
  }

  /**
   * Test {@link ViewValidator#validateEntities(View, Schema, Set, boolean, ValidationResult)}.
   *
   * <ul>
   *   <li>Given {@link GlobalViewElementDefinition} {@link
   *       GlobalViewElementDefinition#getGroupBy()} return {@link HashSet#HashSet()}.
   * </ul>
   *
   * <p>Method under test: {@link ViewValidator#validateEntities(View, Schema, Set, boolean,
   * ValidationResult)}
   */
  @Test
  @DisplayName(
      "Test validateEntities(View, Schema, Set, boolean, ValidationResult); given GlobalViewElementDefinition getGroupBy() return HashSet()")
  @Tag("MaintainedByDiffblue")
  void testValidateEntities_givenGlobalViewElementDefinitionGetGroupByReturnHashSet() {
    // Arrange
    ViewValidator viewValidator = new ViewValidator();

    GlobalViewElementDefinition globalViewElementDefinition =
        mock(GlobalViewElementDefinition.class);
    when(globalViewElementDefinition.getGroupBy()).thenReturn(new HashSet<>());
    when(globalViewElementDefinition.getTransientProperties()).thenReturn(new HashSet<>());
    when(globalViewElementDefinition.getAggregator())
        .thenReturn(new ElementAggregator.Builder().build());
    when(globalViewElementDefinition.getPostAggregationFilter()).thenReturn(new Builder().build());
    when(globalViewElementDefinition.getPostTransformFilter()).thenReturn(new Builder().build());
    when(globalViewElementDefinition.getPreAggregationFilter()).thenReturn(new Builder().build());
    when(globalViewElementDefinition.getTransformer())
        .thenReturn(new ElementTransformer.Builder().build());

    HashMap<String, ViewElementDefinition> stringViewElementDefinitionMap = new HashMap<>();
    stringViewElementDefinitionMap.put("foo", globalViewElementDefinition);

    NamedView view = mock(NamedView.class);
    when(view.getConfig(Mockito.<String>any())).thenReturn(Boolean.TRUE.toString());
    when(view.getEntities()).thenReturn(stringViewElementDefinitionMap);

    Schema schema = mock(Schema.class);
    when(schema.getEntity(Mockito.<String>any())).thenReturn(new SchemaEntityDefinition());
    HashSet<StoreTrait> storeTraits = new HashSet<>();
    Class<Object> output = Object.class;
    Class<Object> input = Object.class;

    ValidationResult result = OperationUtil.isValid(output, input);

    // Act
    viewValidator.validateEntities(view, schema, storeTraits, true, result);

    // Assert
    verify(view, atLeast(1)).getEntities();
    verify(schema).getEntity("foo");
    verify(view).getConfig("skipViewValidation");
    verify(globalViewElementDefinition).getAggregator();
    verify(globalViewElementDefinition).getGroupBy();
    verify(globalViewElementDefinition).getPostAggregationFilter();
    verify(globalViewElementDefinition).getPostTransformFilter();
    verify(globalViewElementDefinition).getPreAggregationFilter();
    verify(globalViewElementDefinition).getTransformer();
    verify(globalViewElementDefinition).getTransientProperties();
    assertEquals(
        "Validation errors: \nThis store does not currently support QUERY_AGGREGATION",
        result.getErrorString());
    Set<String> errors = result.getErrors();
    assertEquals(1, errors.size());
    assertFalse(result.isValid());
    assertTrue(errors.contains("This store does not currently support QUERY_AGGREGATION"));
  }

  /**
   * Test {@link ViewValidator#validateEntities(View, Schema, Set, boolean, ValidationResult)}.
   *
   * <ul>
   *   <li>Given {@link HashMap#HashMap()}.
   * </ul>
   *
   * <p>Method under test: {@link ViewValidator#validateEntities(View, Schema, Set, boolean,
   * ValidationResult)}
   */
  @Test
  @DisplayName(
      "Test validateEntities(View, Schema, Set, boolean, ValidationResult); given HashMap()")
  @Tag("MaintainedByDiffblue")
  void testValidateEntities_givenHashMap() {
    // Arrange
    ViewValidator viewValidator = new ViewValidator();

    NamedView view = mock(NamedView.class);
    when(view.getEntities()).thenReturn(new HashMap<>());
    Schema schema = new Schema();
    HashSet<StoreTrait> storeTraits = new HashSet<>();
    Class<Object> output = Object.class;
    Class<Object> input = Object.class;

    ValidationResult result = OperationUtil.isValid(output, input);

    // Act
    viewValidator.validateEntities(view, schema, storeTraits, true, result);

    // Assert that nothing has changed
    verify(view, atLeast(1)).getEntities();
    assertEquals("Validation errors: \n", result.getErrorString());
    assertTrue(result.getErrors().isEmpty());
    assertTrue(result.isValid());
  }

  /**
   * Test {@link ViewValidator#validateEntities(View, Schema, Set, boolean, ValidationResult)}.
   *
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} {@code foo} is {@link ViewElementDefinition} (default
   *       constructor).
   * </ul>
   *
   * <p>Method under test: {@link ViewValidator#validateEntities(View, Schema, Set, boolean,
   * ValidationResult)}
   */
  @Test
  @DisplayName(
      "Test validateEntities(View, Schema, Set, boolean, ValidationResult); given HashMap() 'foo' is ViewElementDefinition (default constructor)")
  @Tag("MaintainedByDiffblue")
  void testValidateEntities_givenHashMapFooIsViewElementDefinition() {
    // Arrange
    ViewValidator viewValidator = new ViewValidator();

    HashMap<String, ViewElementDefinition> stringViewElementDefinitionMap = new HashMap<>();
    stringViewElementDefinitionMap.put("foo", new ViewElementDefinition());

    NamedView view = mock(NamedView.class);
    when(view.getConfig(Mockito.<String>any())).thenReturn(Boolean.TRUE.toString());
    when(view.getEntities()).thenReturn(stringViewElementDefinitionMap);

    Schema schema = mock(Schema.class);
    when(schema.getEntity(Mockito.<String>any())).thenReturn(new SchemaEntityDefinition());
    HashSet<StoreTrait> storeTraits = new HashSet<>();
    Class<Object> output = Object.class;
    Class<Object> input = Object.class;

    ValidationResult result = OperationUtil.isValid(output, input);

    // Act
    viewValidator.validateEntities(view, schema, storeTraits, true, result);

    // Assert that nothing has changed
    verify(view, atLeast(1)).getEntities();
    verify(schema).getEntity("foo");
    verify(view).getConfig("skipViewValidation");
    assertEquals("Validation errors: \n", result.getErrorString());
    assertTrue(result.getErrors().isEmpty());
    assertTrue(result.isValid());
  }

  /**
   * Test {@link ViewValidator#validateEntities(View, Schema, Set, boolean, ValidationResult)}.
   *
   * <ul>
   *   <li>Given {@code INGEST_AGGREGATION}.
   *   <li>When {@link HashSet#HashSet()} add {@code INGEST_AGGREGATION}.
   * </ul>
   *
   * <p>Method under test: {@link ViewValidator#validateEntities(View, Schema, Set, boolean,
   * ValidationResult)}
   */
  @Test
  @DisplayName(
      "Test validateEntities(View, Schema, Set, boolean, ValidationResult); given 'INGEST_AGGREGATION'; when HashSet() add 'INGEST_AGGREGATION'")
  @Tag("MaintainedByDiffblue")
  void testValidateEntities_givenIngestAggregation_whenHashSetAddIngestAggregation() {
    // Arrange
    ViewValidator viewValidator = new ViewValidator();

    NamedView view = mock(NamedView.class);
    when(view.getEntities()).thenReturn(new HashMap<>());
    Schema schema = new Schema();

    HashSet<StoreTrait> storeTraits = new HashSet<>();
    storeTraits.add(StoreTrait.INGEST_AGGREGATION);
    Class<Object> output = Object.class;
    Class<Object> input = Object.class;

    ValidationResult result = OperationUtil.isValid(output, input);

    // Act
    viewValidator.validateEntities(view, schema, storeTraits, true, result);

    // Assert that nothing has changed
    verify(view, atLeast(1)).getEntities();
    assertEquals("Validation errors: \n", result.getErrorString());
    assertTrue(result.getErrors().isEmpty());
    assertTrue(result.isValid());
  }

  /**
   * Test {@link ViewValidator#validateEntities(View, Schema, Set, boolean, ValidationResult)}.
   *
   * <ul>
   *   <li>Given {@code INGEST_AGGREGATION}.
   *   <li>When {@link HashSet#HashSet()} add {@code INGEST_AGGREGATION}.
   * </ul>
   *
   * <p>Method under test: {@link ViewValidator#validateEntities(View, Schema, Set, boolean,
   * ValidationResult)}
   */
  @Test
  @DisplayName(
      "Test validateEntities(View, Schema, Set, boolean, ValidationResult); given 'INGEST_AGGREGATION'; when HashSet() add 'INGEST_AGGREGATION'")
  @Tag("MaintainedByDiffblue")
  void testValidateEntities_givenIngestAggregation_whenHashSetAddIngestAggregation2() {
    // Arrange
    ViewValidator viewValidator = new ViewValidator();

    NamedView view = mock(NamedView.class);
    when(view.getEntities()).thenReturn(new HashMap<>());
    Schema schema = new Schema();

    HashSet<StoreTrait> storeTraits = new HashSet<>();
    storeTraits.add(StoreTrait.QUERY_AGGREGATION);
    storeTraits.add(StoreTrait.INGEST_AGGREGATION);
    Class<Object> output = Object.class;
    Class<Object> input = Object.class;

    ValidationResult result = OperationUtil.isValid(output, input);

    // Act
    viewValidator.validateEntities(view, schema, storeTraits, true, result);

    // Assert that nothing has changed
    verify(view, atLeast(1)).getEntities();
    assertEquals("Validation errors: \n", result.getErrorString());
    assertTrue(result.getErrors().isEmpty());
    assertTrue(result.isValid());
  }

  /**
   * Test {@link ViewValidator#validateEntities(View, Schema, Set, boolean, ValidationResult)}.
   *
   * <ul>
   *   <li>Given {@code PRE_AGGREGATION_FILTERING}.
   * </ul>
   *
   * <p>Method under test: {@link ViewValidator#validateEntities(View, Schema, Set, boolean,
   * ValidationResult)}
   */
  @Test
  @DisplayName(
      "Test validateEntities(View, Schema, Set, boolean, ValidationResult); given 'PRE_AGGREGATION_FILTERING'")
  @Tag("MaintainedByDiffblue")
  void testValidateEntities_givenPreAggregationFiltering() {
    // Arrange
    ViewValidator viewValidator = new ViewValidator();

    LinkedHashSet<String> stringSet = new LinkedHashSet<>();
    stringSet.add("Transient Properties");

    GlobalViewElementDefinition globalViewElementDefinition =
        mock(GlobalViewElementDefinition.class);
    when(globalViewElementDefinition.getGroupBy()).thenReturn(null);
    when(globalViewElementDefinition.getTransientProperties()).thenReturn(stringSet);
    when(globalViewElementDefinition.getAggregator()).thenReturn(null);
    when(globalViewElementDefinition.getPostAggregationFilter()).thenReturn(null);
    when(globalViewElementDefinition.getPostTransformFilter()).thenReturn(null);
    when(globalViewElementDefinition.getPreAggregationFilter()).thenReturn(null);
    when(globalViewElementDefinition.getTransformer()).thenReturn(null);

    HashMap<String, ViewElementDefinition> stringViewElementDefinitionMap = new HashMap<>();
    stringViewElementDefinitionMap.put("foo", globalViewElementDefinition);

    NamedView view = mock(NamedView.class);
    when(view.getConfig(Mockito.<String>any())).thenReturn("Transient property ");
    when(view.getEntities()).thenReturn(stringViewElementDefinitionMap);

    SchemaEntityDefinition schemaEntityDefinition = mock(SchemaEntityDefinition.class);
    when(schemaEntityDefinition.containsProperty(Mockito.<String>any())).thenReturn(true);

    Schema schema = mock(Schema.class);
    when(schema.getEntity(Mockito.<String>any())).thenReturn(schemaEntityDefinition);

    HashSet<StoreTrait> storeTraits = new HashSet<>();
    storeTraits.add(StoreTrait.PRE_AGGREGATION_FILTERING);
    storeTraits.add(StoreTrait.QUERY_AGGREGATION);
    Class<Object> output = Object.class;
    Class<Object> input = Object.class;

    ValidationResult result = OperationUtil.isValid(output, input);

    // Act
    viewValidator.validateEntities(view, schema, storeTraits, true, result);

    // Assert
    verify(view, atLeast(1)).getEntities();
    verify(schema).getEntity("foo");
    verify(view).getConfig("skipViewValidation");
    verify(globalViewElementDefinition).getAggregator();
    verify(globalViewElementDefinition).getGroupBy();
    verify(globalViewElementDefinition, atLeast(1)).getPostAggregationFilter();
    verify(globalViewElementDefinition, atLeast(1)).getPostTransformFilter();
    verify(globalViewElementDefinition, atLeast(1)).getPreAggregationFilter();
    verify(globalViewElementDefinition, atLeast(1)).getTransformer();
    verify(globalViewElementDefinition).getTransientProperties();
    verify(schemaEntityDefinition).containsProperty("Transient Properties");
    assertEquals(
        "Validation errors: \n"
            + "Transient property Transient Properties for entity group foo is not transient as it has been found in"
            + " the schema",
        result.getErrorString());
    Set<String> errors = result.getErrors();
    assertEquals(1, errors.size());
    assertFalse(result.isValid());
    assertTrue(
        errors.contains(
            "Transient property Transient Properties for entity group foo is not transient as it has been found in"
                + " the schema"));
  }

  /**
   * Test {@link ViewValidator#validateEntities(View, Schema, Set, boolean, ValidationResult)}.
   *
   * <ul>
   *   <li>Given {@code QUERY_AGGREGATION}.
   *   <li>When {@link HashSet#HashSet()} add {@code QUERY_AGGREGATION}.
   * </ul>
   *
   * <p>Method under test: {@link ViewValidator#validateEntities(View, Schema, Set, boolean,
   * ValidationResult)}
   */
  @Test
  @DisplayName(
      "Test validateEntities(View, Schema, Set, boolean, ValidationResult); given 'QUERY_AGGREGATION'; when HashSet() add 'QUERY_AGGREGATION'")
  @Tag("MaintainedByDiffblue")
  void testValidateEntities_givenQueryAggregation_whenHashSetAddQueryAggregation() {
    // Arrange
    ViewValidator viewValidator = new ViewValidator();

    LinkedHashSet<String> stringSet = new LinkedHashSet<>();
    stringSet.add("Transient Properties");

    GlobalViewElementDefinition globalViewElementDefinition =
        mock(GlobalViewElementDefinition.class);
    when(globalViewElementDefinition.getGroupBy()).thenReturn(null);
    when(globalViewElementDefinition.getTransientProperties()).thenReturn(stringSet);
    when(globalViewElementDefinition.getAggregator()).thenReturn(null);
    when(globalViewElementDefinition.getPostAggregationFilter()).thenReturn(null);
    when(globalViewElementDefinition.getPostTransformFilter()).thenReturn(null);
    when(globalViewElementDefinition.getPreAggregationFilter()).thenReturn(null);
    when(globalViewElementDefinition.getTransformer()).thenReturn(null);

    HashMap<String, ViewElementDefinition> stringViewElementDefinitionMap = new HashMap<>();
    stringViewElementDefinitionMap.put("foo", globalViewElementDefinition);

    NamedView view = mock(NamedView.class);
    when(view.getConfig(Mockito.<String>any())).thenReturn("Transient property ");
    when(view.getEntities()).thenReturn(stringViewElementDefinitionMap);

    SchemaEntityDefinition schemaEntityDefinition = mock(SchemaEntityDefinition.class);
    when(schemaEntityDefinition.containsProperty(Mockito.<String>any())).thenReturn(true);

    Schema schema = mock(Schema.class);
    when(schema.getEntity(Mockito.<String>any())).thenReturn(schemaEntityDefinition);

    HashSet<StoreTrait> storeTraits = new HashSet<>();
    storeTraits.add(StoreTrait.QUERY_AGGREGATION);
    Class<Object> output = Object.class;
    Class<Object> input = Object.class;

    ValidationResult result = OperationUtil.isValid(output, input);

    // Act
    viewValidator.validateEntities(view, schema, storeTraits, true, result);

    // Assert
    verify(view, atLeast(1)).getEntities();
    verify(schema).getEntity("foo");
    verify(view).getConfig("skipViewValidation");
    verify(globalViewElementDefinition).getAggregator();
    verify(globalViewElementDefinition).getGroupBy();
    verify(globalViewElementDefinition, atLeast(1)).getPostAggregationFilter();
    verify(globalViewElementDefinition, atLeast(1)).getPostTransformFilter();
    verify(globalViewElementDefinition, atLeast(1)).getPreAggregationFilter();
    verify(globalViewElementDefinition, atLeast(1)).getTransformer();
    verify(globalViewElementDefinition).getTransientProperties();
    verify(schemaEntityDefinition).containsProperty("Transient Properties");
    assertEquals(
        "Validation errors: \n"
            + "Transient property Transient Properties for entity group foo is not transient as it has been found in"
            + " the schema",
        result.getErrorString());
    Set<String> errors = result.getErrors();
    assertEquals(1, errors.size());
    assertFalse(result.isValid());
    assertTrue(
        errors.contains(
            "Transient property Transient Properties for entity group foo is not transient as it has been found in"
                + " the schema"));
  }

  /**
   * Test {@link ViewValidator#validateEntities(View, Schema, Set, boolean, ValidationResult)}.
   *
   * <ul>
   *   <li>Then Valid {@link Object} is {@link Object} ErrorString is {@code Validation errors:}.
   * </ul>
   *
   * <p>Method under test: {@link ViewValidator#validateEntities(View, Schema, Set, boolean,
   * ValidationResult)}
   */
  @Test
  @DisplayName(
      "Test validateEntities(View, Schema, Set, boolean, ValidationResult); then Valid Object is Object ErrorString is 'Validation errors:'")
  @Tag("MaintainedByDiffblue")
  void testValidateEntities_thenValidObjectIsObjectErrorStringIsValidationErrors() {
    // Arrange
    ViewValidator viewValidator = new ViewValidator();

    LinkedHashSet<String> stringSet = new LinkedHashSet<>();
    stringSet.add("Transient Properties");

    GlobalViewElementDefinition globalViewElementDefinition =
        mock(GlobalViewElementDefinition.class);
    when(globalViewElementDefinition.getGroupBy()).thenReturn(null);
    when(globalViewElementDefinition.getTransientProperties()).thenReturn(stringSet);
    when(globalViewElementDefinition.getAggregator()).thenReturn(null);
    when(globalViewElementDefinition.getPostAggregationFilter()).thenReturn(null);
    when(globalViewElementDefinition.getPostTransformFilter()).thenReturn(null);
    when(globalViewElementDefinition.getPreAggregationFilter()).thenReturn(null);
    when(globalViewElementDefinition.getTransformer()).thenReturn(null);

    HashMap<String, ViewElementDefinition> stringViewElementDefinitionMap = new HashMap<>();
    stringViewElementDefinitionMap.put("foo", globalViewElementDefinition);

    NamedView view = mock(NamedView.class);
    when(view.getConfig(Mockito.<String>any())).thenReturn(Boolean.TRUE.toString());
    when(view.getEntities()).thenReturn(stringViewElementDefinitionMap);

    Schema schema = mock(Schema.class);
    when(schema.getEntity(Mockito.<String>any())).thenReturn(new SchemaEntityDefinition());
    HashSet<StoreTrait> storeTraits = new HashSet<>();
    Class<Object> output = Object.class;
    Class<Object> input = Object.class;

    ValidationResult result = OperationUtil.isValid(output, input);

    // Act
    viewValidator.validateEntities(view, schema, storeTraits, true, result);

    // Assert that nothing has changed
    verify(view, atLeast(1)).getEntities();
    verify(schema).getEntity("foo");
    verify(view).getConfig("skipViewValidation");
    verify(globalViewElementDefinition).getAggregator();
    verify(globalViewElementDefinition).getGroupBy();
    verify(globalViewElementDefinition).getPostAggregationFilter();
    verify(globalViewElementDefinition).getPostTransformFilter();
    verify(globalViewElementDefinition).getPreAggregationFilter();
    verify(globalViewElementDefinition).getTransformer();
    verify(globalViewElementDefinition).getTransientProperties();
    assertEquals("Validation errors: \n", result.getErrorString());
    assertTrue(result.getErrors().isEmpty());
    assertTrue(result.isValid());
  }

  /**
   * Test {@link ViewValidator#validateEntities(View, Schema, Set, boolean, ValidationResult)}.
   *
   * <ul>
   *   <li>Then Valid {@link Object} is {@link Object} Errors size is two.
   * </ul>
   *
   * <p>Method under test: {@link ViewValidator#validateEntities(View, Schema, Set, boolean,
   * ValidationResult)}
   */
  @Test
  @DisplayName(
      "Test validateEntities(View, Schema, Set, boolean, ValidationResult); then Valid Object is Object Errors size is two")
  @Tag("MaintainedByDiffblue")
  void testValidateEntities_thenValidObjectIsObjectErrorsSizeIsTwo() {
    // Arrange
    ViewValidator viewValidator = new ViewValidator();

    LinkedHashSet<String> stringSet = new LinkedHashSet<>();
    stringSet.add("Transient Properties");

    GlobalViewElementDefinition globalViewElementDefinition =
        mock(GlobalViewElementDefinition.class);
    when(globalViewElementDefinition.getGroupBy()).thenReturn(null);
    when(globalViewElementDefinition.getTransientProperties()).thenReturn(stringSet);
    when(globalViewElementDefinition.getAggregator())
        .thenReturn(new ElementAggregator.Builder().build());
    when(globalViewElementDefinition.getPostAggregationFilter()).thenReturn(null);
    when(globalViewElementDefinition.getPostTransformFilter()).thenReturn(null);
    when(globalViewElementDefinition.getPreAggregationFilter()).thenReturn(null);
    when(globalViewElementDefinition.getTransformer()).thenReturn(null);

    HashMap<String, ViewElementDefinition> stringViewElementDefinitionMap = new HashMap<>();
    stringViewElementDefinitionMap.put("foo", globalViewElementDefinition);

    NamedView view = mock(NamedView.class);
    when(view.getConfig(Mockito.<String>any())).thenReturn("Transient property ");
    when(view.getEntities()).thenReturn(stringViewElementDefinitionMap);

    SchemaEntityDefinition schemaEntityDefinition = mock(SchemaEntityDefinition.class);
    when(schemaEntityDefinition.containsProperty(Mockito.<String>any())).thenReturn(true);

    Schema schema = mock(Schema.class);
    when(schema.getEntity(Mockito.<String>any())).thenReturn(schemaEntityDefinition);
    HashSet<StoreTrait> storeTraits = new HashSet<>();
    Class<Object> output = Object.class;
    Class<Object> input = Object.class;

    ValidationResult result = OperationUtil.isValid(output, input);

    // Act
    viewValidator.validateEntities(view, schema, storeTraits, true, result);

    // Assert
    verify(view, atLeast(1)).getEntities();
    verify(schema).getEntity("foo");
    verify(view).getConfig("skipViewValidation");
    verify(globalViewElementDefinition, atLeast(1)).getAggregator();
    verify(globalViewElementDefinition).getGroupBy();
    verify(globalViewElementDefinition, atLeast(1)).getPostAggregationFilter();
    verify(globalViewElementDefinition, atLeast(1)).getPostTransformFilter();
    verify(globalViewElementDefinition, atLeast(1)).getPreAggregationFilter();
    verify(globalViewElementDefinition, atLeast(1)).getTransformer();
    verify(globalViewElementDefinition).getTransientProperties();
    verify(schemaEntityDefinition).containsProperty("Transient Properties");
    assertEquals(
        "Validation errors: \n"
            + "Transient property Transient Properties for entity group foo is not transient as it has been found in"
            + " the schema\n"
            + "This store does not currently support QUERY_AGGREGATION",
        result.getErrorString());
    Set<String> errors = result.getErrors();
    assertEquals(2, errors.size());
    assertTrue(errors.contains("This store does not currently support QUERY_AGGREGATION"));
    assertTrue(
        errors.contains(
            "Transient property Transient Properties for entity group foo is not transient as it has been found in"
                + " the schema"));
  }

  /**
   * Test {@link ViewValidator#validateEntities(View, Schema, Set, boolean, ValidationResult)}.
   *
   * <ul>
   *   <li>When {@link View} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link ViewValidator#validateEntities(View, Schema, Set, boolean,
   * ValidationResult)}
   */
  @Test
  @DisplayName(
      "Test validateEntities(View, Schema, Set, boolean, ValidationResult); when View (default constructor)")
  @Tag("MaintainedByDiffblue")
  void testValidateEntities_whenView() {
    // Arrange
    ViewValidator viewValidator = new ViewValidator();
    View view = new View();
    Schema schema = new Schema();
    HashSet<StoreTrait> storeTraits = new HashSet<>();
    Class<Object> output = Object.class;
    Class<Object> input = Object.class;

    ValidationResult result = OperationUtil.isValid(output, input);

    // Act
    viewValidator.validateEntities(view, schema, storeTraits, true, result);

    // Assert that nothing has changed
    assertEquals("Validation errors: \n", result.getErrorString());
    assertTrue(result.getErrors().isEmpty());
    assertTrue(result.isValid());
  }

  /**
   * Test {@link ViewValidator#validateAgainstStoreTraits(ViewElementDefinition, Set)}.
   *
   * <ul>
   *   <li>Given {@code INGEST_AGGREGATION}.
   * </ul>
   *
   * <p>Method under test: {@link ViewValidator#validateAgainstStoreTraits(ViewElementDefinition,
   * Set)}
   */
  @Test
  @DisplayName(
      "Test validateAgainstStoreTraits(ViewElementDefinition, Set); given 'INGEST_AGGREGATION'")
  @Tag("MaintainedByDiffblue")
  void testValidateAgainstStoreTraits_givenIngestAggregation() {
    // Arrange
    ViewValidator viewValidator = new ViewValidator();
    ViewElementDefinition viewElDef = new ViewElementDefinition();

    HashSet<StoreTrait> storeTraits = new HashSet<>();
    storeTraits.add(StoreTrait.INGEST_AGGREGATION);

    // Act
    ValidationResult actualValidateAgainstStoreTraitsResult =
        viewValidator.validateAgainstStoreTraits(viewElDef, storeTraits);

    // Assert
    assertEquals("Validation errors: \n", actualValidateAgainstStoreTraitsResult.getErrorString());
    assertTrue(actualValidateAgainstStoreTraitsResult.getErrors().isEmpty());
    assertTrue(actualValidateAgainstStoreTraitsResult.isValid());
  }

  /**
   * Test {@link ViewValidator#validateAgainstStoreTraits(ViewElementDefinition, Set)}.
   *
   * <ul>
   *   <li>Given {@code PRE_AGGREGATION_FILTERING}.
   * </ul>
   *
   * <p>Method under test: {@link ViewValidator#validateAgainstStoreTraits(ViewElementDefinition,
   * Set)}
   */
  @Test
  @DisplayName(
      "Test validateAgainstStoreTraits(ViewElementDefinition, Set); given 'PRE_AGGREGATION_FILTERING'")
  @Tag("MaintainedByDiffblue")
  void testValidateAgainstStoreTraits_givenPreAggregationFiltering() {
    // Arrange
    ViewValidator viewValidator = new ViewValidator();
    ViewElementDefinition viewElDef = new ViewElementDefinition();

    HashSet<StoreTrait> storeTraits = new HashSet<>();
    storeTraits.add(StoreTrait.PRE_AGGREGATION_FILTERING);
    storeTraits.add(StoreTrait.QUERY_AGGREGATION);
    storeTraits.add(StoreTrait.INGEST_AGGREGATION);

    // Act
    ValidationResult actualValidateAgainstStoreTraitsResult =
        viewValidator.validateAgainstStoreTraits(viewElDef, storeTraits);

    // Assert
    assertEquals("Validation errors: \n", actualValidateAgainstStoreTraitsResult.getErrorString());
    assertTrue(actualValidateAgainstStoreTraitsResult.getErrors().isEmpty());
    assertTrue(actualValidateAgainstStoreTraitsResult.isValid());
  }

  /**
   * Test {@link ViewValidator#validateAgainstStoreTraits(ViewElementDefinition, Set)}.
   *
   * <ul>
   *   <li>Given {@code QUERY_AGGREGATION}.
   * </ul>
   *
   * <p>Method under test: {@link ViewValidator#validateAgainstStoreTraits(ViewElementDefinition,
   * Set)}
   */
  @Test
  @DisplayName(
      "Test validateAgainstStoreTraits(ViewElementDefinition, Set); given 'QUERY_AGGREGATION'")
  @Tag("MaintainedByDiffblue")
  void testValidateAgainstStoreTraits_givenQueryAggregation() {
    // Arrange
    ViewValidator viewValidator = new ViewValidator();
    ViewElementDefinition viewElDef = new ViewElementDefinition();

    HashSet<StoreTrait> storeTraits = new HashSet<>();
    storeTraits.add(StoreTrait.QUERY_AGGREGATION);
    storeTraits.add(StoreTrait.INGEST_AGGREGATION);

    // Act
    ValidationResult actualValidateAgainstStoreTraitsResult =
        viewValidator.validateAgainstStoreTraits(viewElDef, storeTraits);

    // Assert
    assertEquals("Validation errors: \n", actualValidateAgainstStoreTraitsResult.getErrorString());
    assertTrue(actualValidateAgainstStoreTraitsResult.getErrors().isEmpty());
    assertTrue(actualValidateAgainstStoreTraitsResult.isValid());
  }

  /**
   * Test {@link ViewValidator#validateAgainstStoreTraits(ViewElementDefinition, Set)}.
   *
   * <ul>
   *   <li>When {@link HashSet#HashSet()}.
   * </ul>
   *
   * <p>Method under test: {@link ViewValidator#validateAgainstStoreTraits(ViewElementDefinition,
   * Set)}
   */
  @Test
  @DisplayName("Test validateAgainstStoreTraits(ViewElementDefinition, Set); when HashSet()")
  @Tag("MaintainedByDiffblue")
  void testValidateAgainstStoreTraits_whenHashSet() {
    // Arrange
    ViewValidator viewValidator = new ViewValidator();
    ViewElementDefinition viewElDef = new ViewElementDefinition();

    // Act
    ValidationResult actualValidateAgainstStoreTraitsResult =
        viewValidator.validateAgainstStoreTraits(viewElDef, new HashSet<>());

    // Assert
    assertEquals("Validation errors: \n", actualValidateAgainstStoreTraitsResult.getErrorString());
    assertTrue(actualValidateAgainstStoreTraitsResult.getErrors().isEmpty());
    assertTrue(actualValidateAgainstStoreTraitsResult.isValid());
  }

  /**
   * Test {@link ViewValidator#validateGroupBy(boolean, String, ViewElementDefinition,
   * SchemaElementDefinition)}.
   *
   * <ul>
   *   <li>Given {@link LinkedHashSet#LinkedHashSet()} add {@code foo}.
   *   <li>Then return ErrorString is a string.
   * </ul>
   *
   * <p>Method under test: {@link ViewValidator#validateGroupBy(boolean, String,
   * ViewElementDefinition, SchemaElementDefinition)}
   */
  @Test
  @DisplayName(
      "Test validateGroupBy(boolean, String, ViewElementDefinition, SchemaElementDefinition); given LinkedHashSet() add 'foo'; then return ErrorString is a string")
  @Tag("MaintainedByDiffblue")
  void testValidateGroupBy_givenLinkedHashSetAddFoo_thenReturnErrorStringIsAString() {
    // Arrange
    ViewValidator viewValidator = new ViewValidator();

    LinkedHashSet<String> groupBy = new LinkedHashSet<>();
    groupBy.add("foo");

    ViewElementDefinition viewElDef = new ViewElementDefinition();
    viewElDef.setGroupBy(groupBy);

    // Act
    ValidationResult actualValidateGroupByResult =
        viewValidator.validateGroupBy(true, "Group", viewElDef, new SchemaEdgeDefinition());

    // Assert
    assertEquals(
        "Validation errors: \n"
            + "Group by properties for group Group in the view are not all included in the group by field in the"
            + " schema. View groupBy:[foo]. Schema groupBy:[]",
        actualValidateGroupByResult.getErrorString());
    Set<String> errors = actualValidateGroupByResult.getErrors();
    assertEquals(1, errors.size());
    assertFalse(actualValidateGroupByResult.isValid());
    assertTrue(
        errors.contains(
            "Group by properties for group Group in the view are not all included in the group by field in the"
                + " schema. View groupBy:[foo]. Schema groupBy:[]"));
  }

  /**
   * Test {@link ViewValidator#validateGroupBy(boolean, String, ViewElementDefinition,
   * SchemaElementDefinition)}.
   *
   * <ul>
   *   <li>Given {@link LinkedHashSet#LinkedHashSet()}.
   *   <li>Then return ErrorString is {@code Validation errors:}.
   * </ul>
   *
   * <p>Method under test: {@link ViewValidator#validateGroupBy(boolean, String,
   * ViewElementDefinition, SchemaElementDefinition)}
   */
  @Test
  @DisplayName(
      "Test validateGroupBy(boolean, String, ViewElementDefinition, SchemaElementDefinition); given LinkedHashSet(); then return ErrorString is 'Validation errors:'")
  @Tag("MaintainedByDiffblue")
  void testValidateGroupBy_givenLinkedHashSet_thenReturnErrorStringIsValidationErrors() {
    // Arrange
    ViewValidator viewValidator = new ViewValidator();

    ViewElementDefinition viewElDef = new ViewElementDefinition();
    viewElDef.setGroupBy(new LinkedHashSet<>());

    // Act
    ValidationResult actualValidateGroupByResult =
        viewValidator.validateGroupBy(true, "Group", viewElDef, new SchemaEdgeDefinition());

    // Assert
    assertEquals("Validation errors: \n", actualValidateGroupByResult.getErrorString());
    assertTrue(actualValidateGroupByResult.getErrors().isEmpty());
    assertTrue(actualValidateGroupByResult.isValid());
  }

  /**
   * Test {@link ViewValidator#validateGroupBy(boolean, String, ViewElementDefinition,
   * SchemaElementDefinition)}.
   *
   * <ul>
   *   <li>When {@link ViewElementDefinition} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link ViewValidator#validateGroupBy(boolean, String,
   * ViewElementDefinition, SchemaElementDefinition)}
   */
  @Test
  @DisplayName(
      "Test validateGroupBy(boolean, String, ViewElementDefinition, SchemaElementDefinition); when ViewElementDefinition (default constructor)")
  @Tag("MaintainedByDiffblue")
  void testValidateGroupBy_whenViewElementDefinition() {
    // Arrange
    ViewValidator viewValidator = new ViewValidator();
    ViewElementDefinition viewElDef = new ViewElementDefinition();

    // Act
    ValidationResult actualValidateGroupByResult =
        viewValidator.validateGroupBy(true, "Group", viewElDef, new SchemaEdgeDefinition());

    // Assert
    assertEquals("Validation errors: \n", actualValidateGroupByResult.getErrorString());
    assertTrue(actualValidateGroupByResult.getErrors().isEmpty());
    assertTrue(actualValidateGroupByResult.isValid());
  }
}
