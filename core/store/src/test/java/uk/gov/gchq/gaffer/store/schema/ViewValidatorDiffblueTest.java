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

package uk.gov.gchq.gaffer.store.schema;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
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
import uk.gov.gchq.koryphe.ValidationResult;

class ViewValidatorDiffblueTest {
  /**
   * Test {@link ViewValidator#validate(View, Schema, Set)}.
   * <ul>
   *   <li>Given {@code INGEST_AGGREGATION}.</li>
   *   <li>When {@link HashSet#HashSet()} add {@code INGEST_AGGREGATION}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ViewValidator#validate(View, Schema, Set)}
   */
  @Test
  @DisplayName("Test validate(View, Schema, Set); given 'INGEST_AGGREGATION'; when HashSet() add 'INGEST_AGGREGATION'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ValidationResult ViewValidator.validate(View, Schema, Set)"})
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
   * <ul>
   *   <li>Given {@code QUERY_AGGREGATION}.</li>
   *   <li>When {@link HashSet#HashSet()} add {@code QUERY_AGGREGATION}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ViewValidator#validate(View, Schema, Set)}
   */
  @Test
  @DisplayName("Test validate(View, Schema, Set); given 'QUERY_AGGREGATION'; when HashSet() add 'QUERY_AGGREGATION'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ValidationResult ViewValidator.validate(View, Schema, Set)"})
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
   * <ul>
   *   <li>When {@link HashSet#HashSet()}.</li>
   *   <li>Then return ErrorString is {@code Validation errors:}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ViewValidator#validate(View, Schema, Set)}
   */
  @Test
  @DisplayName("Test validate(View, Schema, Set); when HashSet(); then return ErrorString is 'Validation errors:'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ValidationResult ViewValidator.validate(View, Schema, Set)"})
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
   * <ul>
   *   <li>When {@link HashSet#HashSet()}.</li>
   *   <li>Then return ErrorString is {@code Validation errors:}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ViewValidator#validate(View, Schema, Set)}
   */
  @Test
  @DisplayName("Test validate(View, Schema, Set); when HashSet(); then return ErrorString is 'Validation errors:'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ValidationResult ViewValidator.validate(View, Schema, Set)"})
  void testValidate_whenHashSet_thenReturnErrorStringIsValidationErrors2() {
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
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return ErrorString is {@code Validation errors:}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ViewValidator#validate(View, Schema, Set)}
   */
  @Test
  @DisplayName("Test validate(View, Schema, Set); when 'null'; then return ErrorString is 'Validation errors:'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ValidationResult ViewValidator.validate(View, Schema, Set)"})
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
   * <p>
   * Method under test: {@link ViewValidator#validateEdge(View, Schema, Set, boolean, ValidationResult)}
   */
  @Test
  @DisplayName("Test validateEdge(View, Schema, Set, boolean, ValidationResult)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void ViewValidator.validateEdge(View, Schema, Set, boolean, ValidationResult)"})
  void testValidateEdge() {
    // Arrange
    ViewValidator viewValidator = new ViewValidator();

    HashMap<String, ViewElementDefinition> stringViewElementDefinitionMap = new HashMap<>();
    stringViewElementDefinitionMap.put("foo", new ViewElementDefinition());
    NamedView view = mock(NamedView.class);
    when(view.getEdges()).thenReturn(stringViewElementDefinitionMap);
    Schema schema = new Schema();
    HashSet<StoreTrait> storeTraits = new HashSet<>();
    ValidationResult result = new ValidationResult("An error occurred");

    // Act
    viewValidator.validateEdge(view, schema, storeTraits, true, result);

    // Assert
    verify(view, atLeast(1)).getEdges();
    assertEquals("Validation errors: \nAn error occurred\nEdge group foo does not exist in the schema",
        result.getErrorString());
    Set<String> errors = result.getErrors();
    assertEquals(2, errors.size());
    assertTrue(errors.contains("Edge group foo does not exist in the schema"));
  }

  /**
   * Test {@link ViewValidator#validateEdge(View, Schema, Set, boolean, ValidationResult)}.
   * <p>
   * Method under test: {@link ViewValidator#validateEdge(View, Schema, Set, boolean, ValidationResult)}
   */
  @Test
  @DisplayName("Test validateEdge(View, Schema, Set, boolean, ValidationResult)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void ViewValidator.validateEdge(View, Schema, Set, boolean, ValidationResult)"})
  void testValidateEdge2() {
    // Arrange
    ViewValidator viewValidator = new ViewValidator();
    GlobalViewElementDefinition globalViewElementDefinition = mock(GlobalViewElementDefinition.class);
    when(globalViewElementDefinition.getGroupBy()).thenReturn(new HashSet<>());
    when(globalViewElementDefinition.getTransientProperties()).thenReturn(new HashSet<>());
    ElementAggregator buildResult = (new ElementAggregator.Builder()).build();
    when(globalViewElementDefinition.getAggregator()).thenReturn(buildResult);
    ElementFilter buildResult2 = (new Builder()).build();
    when(globalViewElementDefinition.getPostAggregationFilter()).thenReturn(buildResult2);
    ElementFilter buildResult3 = (new Builder()).build();
    when(globalViewElementDefinition.getPostTransformFilter()).thenReturn(buildResult3);
    ElementFilter buildResult4 = (new Builder()).build();
    when(globalViewElementDefinition.getPreAggregationFilter()).thenReturn(buildResult4);
    ElementTransformer buildResult5 = (new ElementTransformer.Builder()).build();
    when(globalViewElementDefinition.getTransformer()).thenReturn(buildResult5);

    HashMap<String, ViewElementDefinition> stringViewElementDefinitionMap = new HashMap<>();
    stringViewElementDefinitionMap.put("foo", globalViewElementDefinition);
    NamedView view = mock(NamedView.class);
    when(view.getConfig(Mockito.<String>any())).thenReturn("Config");
    when(view.getEdges()).thenReturn(stringViewElementDefinitionMap);
    Schema schema = mock(Schema.class);
    when(schema.getEdge(Mockito.<String>any())).thenReturn(new SchemaEdgeDefinition());
    HashSet<StoreTrait> storeTraits = new HashSet<>();
    ValidationResult result = new ValidationResult("An error occurred");

    // Act
    viewValidator.validateEdge(view, schema, storeTraits, true, result);

    // Assert
    verify(schema).getEdge(eq("foo"));
    verify(view, atLeast(1)).getEdges();
    verify(view).getConfig(eq("skipViewValidation"));
    verify(globalViewElementDefinition, atLeast(1)).getAggregator();
    verify(globalViewElementDefinition).getGroupBy();
    verify(globalViewElementDefinition, atLeast(1)).getPostAggregationFilter();
    verify(globalViewElementDefinition, atLeast(1)).getPostTransformFilter();
    verify(globalViewElementDefinition, atLeast(1)).getPreAggregationFilter();
    verify(globalViewElementDefinition, atLeast(1)).getTransformer();
    verify(globalViewElementDefinition).getTransientProperties();
    assertEquals("Validation errors: \nAn error occurred\nThis store does not currently support QUERY_AGGREGATION",
        result.getErrorString());
    Set<String> errors = result.getErrors();
    assertEquals(2, errors.size());
    assertTrue(errors.contains("This store does not currently support QUERY_AGGREGATION"));
  }

  /**
   * Test {@link ViewValidator#validateEdge(View, Schema, Set, boolean, ValidationResult)}.
   * <p>
   * Method under test: {@link ViewValidator#validateEdge(View, Schema, Set, boolean, ValidationResult)}
   */
  @Test
  @DisplayName("Test validateEdge(View, Schema, Set, boolean, ValidationResult)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void ViewValidator.validateEdge(View, Schema, Set, boolean, ValidationResult)"})
  void testValidateEdge3() {
    // Arrange
    ViewValidator viewValidator = new ViewValidator();

    HashSet<String> stringSet = new HashSet<>();
    stringSet.add("This store does not currently support ");
    GlobalViewElementDefinition globalViewElementDefinition = mock(GlobalViewElementDefinition.class);
    when(globalViewElementDefinition.getGroupBy()).thenReturn(stringSet);
    when(globalViewElementDefinition.getTransientProperties()).thenReturn(new HashSet<>());
    ElementAggregator buildResult = (new ElementAggregator.Builder()).build();
    when(globalViewElementDefinition.getAggregator()).thenReturn(buildResult);
    ElementFilter buildResult2 = (new Builder()).build();
    when(globalViewElementDefinition.getPostAggregationFilter()).thenReturn(buildResult2);
    ElementFilter buildResult3 = (new Builder()).build();
    when(globalViewElementDefinition.getPostTransformFilter()).thenReturn(buildResult3);
    ElementFilter buildResult4 = (new Builder()).build();
    when(globalViewElementDefinition.getPreAggregationFilter()).thenReturn(buildResult4);
    ElementTransformer buildResult5 = (new ElementTransformer.Builder()).build();
    when(globalViewElementDefinition.getTransformer()).thenReturn(buildResult5);

    HashMap<String, ViewElementDefinition> stringViewElementDefinitionMap = new HashMap<>();
    stringViewElementDefinitionMap.put("foo", globalViewElementDefinition);
    NamedView view = mock(NamedView.class);
    when(view.getConfig(Mockito.<String>any())).thenReturn("Config");
    when(view.getEdges()).thenReturn(stringViewElementDefinitionMap);
    Schema schema = mock(Schema.class);
    when(schema.getEdge(Mockito.<String>any())).thenReturn(new SchemaEdgeDefinition());
    HashSet<StoreTrait> storeTraits = new HashSet<>();
    ValidationResult result = new ValidationResult("An error occurred");

    // Act
    viewValidator.validateEdge(view, schema, storeTraits, true, result);

    // Assert
    verify(schema).getEdge(eq("foo"));
    verify(view, atLeast(1)).getEdges();
    verify(view).getConfig(eq("skipViewValidation"));
    verify(globalViewElementDefinition, atLeast(1)).getAggregator();
    verify(globalViewElementDefinition).getGroupBy();
    verify(globalViewElementDefinition, atLeast(1)).getPostAggregationFilter();
    verify(globalViewElementDefinition, atLeast(1)).getPostTransformFilter();
    verify(globalViewElementDefinition, atLeast(1)).getPreAggregationFilter();
    verify(globalViewElementDefinition, atLeast(1)).getTransformer();
    verify(globalViewElementDefinition).getTransientProperties();
    assertEquals(
        "Validation errors: \n" + "An error occurred\n" + "This store does not currently support QUERY_AGGREGATION\n"
            + "Group by properties for group foo in the view are not all included in the group by field in the schema."
            + " View groupBy:[This store does not currently support ]. Schema groupBy:[]",
        result.getErrorString());
    Set<String> errors = result.getErrors();
    assertEquals(3, errors.size());
    assertTrue(errors.contains(
        "Group by properties for group foo in the view are not all included in the group by field in the schema."
            + " View groupBy:[This store does not currently support ]. Schema groupBy:[]"));
    assertTrue(errors.contains("This store does not currently support QUERY_AGGREGATION"));
  }

  /**
   * Test {@link ViewValidator#validateEdge(View, Schema, Set, boolean, ValidationResult)}.
   * <p>
   * Method under test: {@link ViewValidator#validateEdge(View, Schema, Set, boolean, ValidationResult)}
   */
  @Test
  @DisplayName("Test validateEdge(View, Schema, Set, boolean, ValidationResult)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void ViewValidator.validateEdge(View, Schema, Set, boolean, ValidationResult)"})
  void testValidateEdge4() {
    // Arrange
    ViewValidator viewValidator = new ViewValidator();

    HashSet<String> stringSet = new HashSet<>();
    stringSet.add("This store does not currently support ");
    GlobalViewElementDefinition globalViewElementDefinition = mock(GlobalViewElementDefinition.class);
    when(globalViewElementDefinition.getGroupBy()).thenReturn(new HashSet<>());
    when(globalViewElementDefinition.getTransientProperties()).thenReturn(stringSet);
    ElementAggregator buildResult = (new ElementAggregator.Builder()).build();
    when(globalViewElementDefinition.getAggregator()).thenReturn(buildResult);
    ElementFilter buildResult2 = (new Builder()).build();
    when(globalViewElementDefinition.getPostAggregationFilter()).thenReturn(buildResult2);
    ElementFilter buildResult3 = (new Builder()).build();
    when(globalViewElementDefinition.getPostTransformFilter()).thenReturn(buildResult3);
    ElementFilter buildResult4 = (new Builder()).build();
    when(globalViewElementDefinition.getPreAggregationFilter()).thenReturn(buildResult4);
    ElementTransformer buildResult5 = (new ElementTransformer.Builder()).build();
    when(globalViewElementDefinition.getTransformer()).thenReturn(buildResult5);

    HashMap<String, ViewElementDefinition> stringViewElementDefinitionMap = new HashMap<>();
    stringViewElementDefinitionMap.put("foo", globalViewElementDefinition);
    NamedView view = mock(NamedView.class);
    when(view.getConfig(Mockito.<String>any())).thenReturn("Config");
    when(view.getEdges()).thenReturn(stringViewElementDefinitionMap);
    Schema schema = mock(Schema.class);
    when(schema.getEdge(Mockito.<String>any())).thenReturn(new SchemaEdgeDefinition());
    HashSet<StoreTrait> storeTraits = new HashSet<>();
    ValidationResult result = new ValidationResult("An error occurred");

    // Act
    viewValidator.validateEdge(view, schema, storeTraits, true, result);

    // Assert
    verify(schema).getEdge(eq("foo"));
    verify(view, atLeast(1)).getEdges();
    verify(view).getConfig(eq("skipViewValidation"));
    verify(globalViewElementDefinition, atLeast(1)).getAggregator();
    verify(globalViewElementDefinition).getGroupBy();
    verify(globalViewElementDefinition, atLeast(1)).getPostAggregationFilter();
    verify(globalViewElementDefinition, atLeast(1)).getPostTransformFilter();
    verify(globalViewElementDefinition, atLeast(1)).getPreAggregationFilter();
    verify(globalViewElementDefinition, atLeast(1)).getTransformer();
    verify(globalViewElementDefinition).getTransientProperties();
    assertEquals("Validation errors: \nAn error occurred\nThis store does not currently support QUERY_AGGREGATION",
        result.getErrorString());
    Set<String> errors = result.getErrors();
    assertEquals(2, errors.size());
    assertTrue(errors.contains("This store does not currently support QUERY_AGGREGATION"));
  }

  /**
   * Test {@link ViewValidator#validateEdge(View, Schema, Set, boolean, ValidationResult)}.
   * <p>
   * Method under test: {@link ViewValidator#validateEdge(View, Schema, Set, boolean, ValidationResult)}
   */
  @Test
  @DisplayName("Test validateEdge(View, Schema, Set, boolean, ValidationResult)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void ViewValidator.validateEdge(View, Schema, Set, boolean, ValidationResult)"})
  void testValidateEdge5() {
    // Arrange
    ViewValidator viewValidator = new ViewValidator();

    HashSet<String> stringSet = new HashSet<>();
    stringSet.add("This store does not currently support ");
    GlobalViewElementDefinition globalViewElementDefinition = mock(GlobalViewElementDefinition.class);
    when(globalViewElementDefinition.getGroupBy()).thenReturn(stringSet);
    when(globalViewElementDefinition.getTransientProperties()).thenReturn(new HashSet<>());
    ElementAggregator buildResult = (new ElementAggregator.Builder()).build();
    when(globalViewElementDefinition.getAggregator()).thenReturn(buildResult);
    ElementFilter buildResult2 = (new Builder()).build();
    when(globalViewElementDefinition.getPostAggregationFilter()).thenReturn(buildResult2);
    ElementFilter buildResult3 = (new Builder()).build();
    when(globalViewElementDefinition.getPostTransformFilter()).thenReturn(buildResult3);
    ElementFilter buildResult4 = (new Builder()).build();
    when(globalViewElementDefinition.getPreAggregationFilter()).thenReturn(buildResult4);
    ElementTransformer buildResult5 = (new ElementTransformer.Builder()).build();
    when(globalViewElementDefinition.getTransformer()).thenReturn(buildResult5);

    HashMap<String, ViewElementDefinition> stringViewElementDefinitionMap = new HashMap<>();
    stringViewElementDefinitionMap.put("foo", globalViewElementDefinition);
    NamedView view = mock(NamedView.class);
    when(view.getConfig(Mockito.<String>any())).thenReturn("Config");
    when(view.getEdges()).thenReturn(stringViewElementDefinitionMap);
    SchemaEdgeDefinition schemaEdgeDefinition = mock(SchemaEdgeDefinition.class);
    when(schemaEdgeDefinition.getGroupBy()).thenReturn(new HashSet<>());
    Schema schema = mock(Schema.class);
    when(schema.getEdge(Mockito.<String>any())).thenReturn(schemaEdgeDefinition);
    HashSet<StoreTrait> storeTraits = new HashSet<>();
    ValidationResult result = new ValidationResult("An error occurred");

    // Act
    viewValidator.validateEdge(view, schema, storeTraits, true, result);

    // Assert
    verify(schema).getEdge(eq("foo"));
    verify(view, atLeast(1)).getEdges();
    verify(view).getConfig(eq("skipViewValidation"));
    verify(globalViewElementDefinition, atLeast(1)).getAggregator();
    verify(globalViewElementDefinition).getGroupBy();
    verify(globalViewElementDefinition, atLeast(1)).getPostAggregationFilter();
    verify(globalViewElementDefinition, atLeast(1)).getPostTransformFilter();
    verify(globalViewElementDefinition, atLeast(1)).getPreAggregationFilter();
    verify(globalViewElementDefinition, atLeast(1)).getTransformer();
    verify(globalViewElementDefinition).getTransientProperties();
    verify(schemaEdgeDefinition).getGroupBy();
    assertEquals(
        "Validation errors: \n" + "An error occurred\n" + "This store does not currently support QUERY_AGGREGATION\n"
            + "Group by properties for group foo in the view are not all included in the group by field in the schema."
            + " View groupBy:[This store does not currently support ]. Schema groupBy:[]",
        result.getErrorString());
    Set<String> errors = result.getErrors();
    assertEquals(3, errors.size());
    assertTrue(errors.contains(
        "Group by properties for group foo in the view are not all included in the group by field in the schema."
            + " View groupBy:[This store does not currently support ]. Schema groupBy:[]"));
    assertTrue(errors.contains("This store does not currently support QUERY_AGGREGATION"));
  }

  /**
   * Test {@link ViewValidator#validateEdge(View, Schema, Set, boolean, ValidationResult)}.
   * <p>
   * Method under test: {@link ViewValidator#validateEdge(View, Schema, Set, boolean, ValidationResult)}
   */
  @Test
  @DisplayName("Test validateEdge(View, Schema, Set, boolean, ValidationResult)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void ViewValidator.validateEdge(View, Schema, Set, boolean, ValidationResult)"})
  void testValidateEdge6() {
    // Arrange
    ViewValidator viewValidator = new ViewValidator();

    HashSet<String> stringSet = new HashSet<>();
    stringSet.add("This store does not currently support ");

    HashSet<String> stringSet2 = new HashSet<>();
    stringSet2.add("This store does not currently support ");
    GlobalViewElementDefinition globalViewElementDefinition = mock(GlobalViewElementDefinition.class);
    when(globalViewElementDefinition.getGroupBy()).thenReturn(stringSet);
    when(globalViewElementDefinition.getTransientProperties()).thenReturn(stringSet2);
    ElementAggregator buildResult = (new ElementAggregator.Builder()).build();
    when(globalViewElementDefinition.getAggregator()).thenReturn(buildResult);
    ElementFilter buildResult2 = (new Builder()).build();
    when(globalViewElementDefinition.getPostAggregationFilter()).thenReturn(buildResult2);
    ElementFilter buildResult3 = (new Builder()).build();
    when(globalViewElementDefinition.getPostTransformFilter()).thenReturn(buildResult3);
    ElementFilter buildResult4 = (new Builder()).build();
    when(globalViewElementDefinition.getPreAggregationFilter()).thenReturn(buildResult4);
    ElementTransformer buildResult5 = (new ElementTransformer.Builder()).build();
    when(globalViewElementDefinition.getTransformer()).thenReturn(buildResult5);

    HashMap<String, ViewElementDefinition> stringViewElementDefinitionMap = new HashMap<>();
    stringViewElementDefinitionMap.put("foo", globalViewElementDefinition);
    NamedView view = mock(NamedView.class);
    when(view.getConfig(Mockito.<String>any())).thenReturn("Config");
    when(view.getEdges()).thenReturn(stringViewElementDefinitionMap);
    SchemaEdgeDefinition schemaEdgeDefinition = mock(SchemaEdgeDefinition.class);
    when(schemaEdgeDefinition.containsProperty(Mockito.<String>any())).thenReturn(true);
    when(schemaEdgeDefinition.getGroupBy()).thenReturn(new HashSet<>());
    Schema schema = mock(Schema.class);
    when(schema.getEdge(Mockito.<String>any())).thenReturn(schemaEdgeDefinition);
    HashSet<StoreTrait> storeTraits = new HashSet<>();
    ValidationResult result = new ValidationResult("An error occurred");

    // Act
    viewValidator.validateEdge(view, schema, storeTraits, true, result);

    // Assert
    verify(schema).getEdge(eq("foo"));
    verify(view, atLeast(1)).getEdges();
    verify(view).getConfig(eq("skipViewValidation"));
    verify(globalViewElementDefinition, atLeast(1)).getAggregator();
    verify(globalViewElementDefinition).getGroupBy();
    verify(globalViewElementDefinition, atLeast(1)).getPostAggregationFilter();
    verify(globalViewElementDefinition, atLeast(1)).getPostTransformFilter();
    verify(globalViewElementDefinition, atLeast(1)).getPreAggregationFilter();
    verify(globalViewElementDefinition, atLeast(1)).getTransformer();
    verify(globalViewElementDefinition).getTransientProperties();
    verify(schemaEdgeDefinition).containsProperty(eq("This store does not currently support "));
    verify(schemaEdgeDefinition).getGroupBy();
    assertEquals("Validation errors: \n" + "An error occurred\n"
        + "Transient property This store does not currently support  for edge group foo is not transient as it"
        + " has been found in the schema\n" + "This store does not currently support QUERY_AGGREGATION\n"
        + "Group by properties for group foo in the view are not all included in the group by field in the schema."
        + " View groupBy:[This store does not currently support ]. Schema groupBy:[]", result.getErrorString());
    Set<String> errors = result.getErrors();
    assertEquals(4, errors.size());
    assertTrue(errors.contains(
        "Group by properties for group foo in the view are not all included in the group by field in the schema."
            + " View groupBy:[This store does not currently support ]. Schema groupBy:[]"));
    assertTrue(errors.contains("This store does not currently support QUERY_AGGREGATION"));
  }

  /**
   * Test {@link ViewValidator#validateEdge(View, Schema, Set, boolean, ValidationResult)}.
   * <ul>
   *   <li>Given {@link HashMap#HashMap()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ViewValidator#validateEdge(View, Schema, Set, boolean, ValidationResult)}
   */
  @Test
  @DisplayName("Test validateEdge(View, Schema, Set, boolean, ValidationResult); given HashMap()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void ViewValidator.validateEdge(View, Schema, Set, boolean, ValidationResult)"})
  void testValidateEdge_givenHashMap() {
    // Arrange
    ViewValidator viewValidator = new ViewValidator();
    NamedView view = mock(NamedView.class);
    when(view.getEdges()).thenReturn(new HashMap<>());
    Schema schema = new Schema();
    HashSet<StoreTrait> storeTraits = new HashSet<>();
    ValidationResult result = new ValidationResult("An error occurred");

    // Act
    viewValidator.validateEdge(view, schema, storeTraits, true, result);

    // Assert that nothing has changed
    verify(view, atLeast(1)).getEdges();
    assertEquals("Validation errors: \nAn error occurred", result.getErrorString());
    assertEquals(1, result.getErrors().size());
  }

  /**
   * Test {@link ViewValidator#validateEdge(View, Schema, Set, boolean, ValidationResult)}.
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} {@code foo} is {@link ViewElementDefinition} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link ViewValidator#validateEdge(View, Schema, Set, boolean, ValidationResult)}
   */
  @Test
  @DisplayName("Test validateEdge(View, Schema, Set, boolean, ValidationResult); given HashMap() 'foo' is ViewElementDefinition (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void ViewValidator.validateEdge(View, Schema, Set, boolean, ValidationResult)"})
  void testValidateEdge_givenHashMapFooIsViewElementDefinition() {
    // Arrange
    ViewValidator viewValidator = new ViewValidator();

    HashMap<String, ViewElementDefinition> stringViewElementDefinitionMap = new HashMap<>();
    stringViewElementDefinitionMap.put("foo", new ViewElementDefinition());
    NamedView view = mock(NamedView.class);
    when(view.getConfig(Mockito.<String>any())).thenReturn("Config");
    when(view.getEdges()).thenReturn(stringViewElementDefinitionMap);
    Schema schema = mock(Schema.class);
    when(schema.getEdge(Mockito.<String>any())).thenReturn(new SchemaEdgeDefinition());
    HashSet<StoreTrait> storeTraits = new HashSet<>();
    ValidationResult result = new ValidationResult("An error occurred");

    // Act
    viewValidator.validateEdge(view, schema, storeTraits, true, result);

    // Assert that nothing has changed
    verify(schema).getEdge(eq("foo"));
    verify(view, atLeast(1)).getEdges();
    verify(view).getConfig(eq("skipViewValidation"));
    assertEquals("Validation errors: \nAn error occurred", result.getErrorString());
    assertEquals(1, result.getErrors().size());
  }

  /**
   * Test {@link ViewValidator#validateEdge(View, Schema, Set, boolean, ValidationResult)}.
   * <ul>
   *   <li>Given {@code INGEST_AGGREGATION}.</li>
   *   <li>When {@link HashSet#HashSet()} add {@code INGEST_AGGREGATION}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ViewValidator#validateEdge(View, Schema, Set, boolean, ValidationResult)}
   */
  @Test
  @DisplayName("Test validateEdge(View, Schema, Set, boolean, ValidationResult); given 'INGEST_AGGREGATION'; when HashSet() add 'INGEST_AGGREGATION'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void ViewValidator.validateEdge(View, Schema, Set, boolean, ValidationResult)"})
  void testValidateEdge_givenIngestAggregation_whenHashSetAddIngestAggregation() {
    // Arrange
    ViewValidator viewValidator = new ViewValidator();
    NamedView view = mock(NamedView.class);
    when(view.getEdges()).thenReturn(new HashMap<>());
    Schema schema = new Schema();

    HashSet<StoreTrait> storeTraits = new HashSet<>();
    storeTraits.add(StoreTrait.INGEST_AGGREGATION);
    ValidationResult result = new ValidationResult("An error occurred");

    // Act
    viewValidator.validateEdge(view, schema, storeTraits, true, result);

    // Assert that nothing has changed
    verify(view, atLeast(1)).getEdges();
    assertEquals("Validation errors: \nAn error occurred", result.getErrorString());
    assertEquals(1, result.getErrors().size());
  }

  /**
   * Test {@link ViewValidator#validateEdge(View, Schema, Set, boolean, ValidationResult)}.
   * <ul>
   *   <li>Given {@code INGEST_AGGREGATION}.</li>
   *   <li>When {@link HashSet#HashSet()} add {@code INGEST_AGGREGATION}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ViewValidator#validateEdge(View, Schema, Set, boolean, ValidationResult)}
   */
  @Test
  @DisplayName("Test validateEdge(View, Schema, Set, boolean, ValidationResult); given 'INGEST_AGGREGATION'; when HashSet() add 'INGEST_AGGREGATION'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void ViewValidator.validateEdge(View, Schema, Set, boolean, ValidationResult)"})
  void testValidateEdge_givenIngestAggregation_whenHashSetAddIngestAggregation2() {
    // Arrange
    ViewValidator viewValidator = new ViewValidator();
    NamedView view = mock(NamedView.class);
    when(view.getEdges()).thenReturn(new HashMap<>());
    Schema schema = new Schema();

    HashSet<StoreTrait> storeTraits = new HashSet<>();
    storeTraits.add(StoreTrait.QUERY_AGGREGATION);
    storeTraits.add(StoreTrait.INGEST_AGGREGATION);
    ValidationResult result = new ValidationResult("An error occurred");

    // Act
    viewValidator.validateEdge(view, schema, storeTraits, true, result);

    // Assert that nothing has changed
    verify(view, atLeast(1)).getEdges();
    assertEquals("Validation errors: \nAn error occurred", result.getErrorString());
    assertEquals(1, result.getErrors().size());
  }

  /**
   * Test {@link ViewValidator#validateEdge(View, Schema, Set, boolean, ValidationResult)}.
   * <ul>
   *   <li>Given {@code PRE_AGGREGATION_FILTERING}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ViewValidator#validateEdge(View, Schema, Set, boolean, ValidationResult)}
   */
  @Test
  @DisplayName("Test validateEdge(View, Schema, Set, boolean, ValidationResult); given 'PRE_AGGREGATION_FILTERING'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void ViewValidator.validateEdge(View, Schema, Set, boolean, ValidationResult)"})
  void testValidateEdge_givenPreAggregationFiltering() {
    // Arrange
    ViewValidator viewValidator = new ViewValidator();

    HashSet<String> stringSet = new HashSet<>();
    stringSet.add("This store does not currently support ");

    HashSet<String> stringSet2 = new HashSet<>();
    stringSet2.add("This store does not currently support ");
    GlobalViewElementDefinition globalViewElementDefinition = mock(GlobalViewElementDefinition.class);
    when(globalViewElementDefinition.getGroupBy()).thenReturn(stringSet);
    when(globalViewElementDefinition.getTransientProperties()).thenReturn(stringSet2);
    ElementAggregator buildResult = (new ElementAggregator.Builder()).build();
    when(globalViewElementDefinition.getAggregator()).thenReturn(buildResult);
    ElementFilter buildResult2 = (new Builder()).build();
    when(globalViewElementDefinition.getPostAggregationFilter()).thenReturn(buildResult2);
    ElementFilter buildResult3 = (new Builder()).build();
    when(globalViewElementDefinition.getPostTransformFilter()).thenReturn(buildResult3);
    ElementFilter buildResult4 = (new Builder()).build();
    when(globalViewElementDefinition.getPreAggregationFilter()).thenReturn(buildResult4);
    ElementTransformer buildResult5 = (new ElementTransformer.Builder()).build();
    when(globalViewElementDefinition.getTransformer()).thenReturn(buildResult5);

    HashMap<String, ViewElementDefinition> stringViewElementDefinitionMap = new HashMap<>();
    stringViewElementDefinitionMap.put("foo", globalViewElementDefinition);
    NamedView view = mock(NamedView.class);
    when(view.getConfig(Mockito.<String>any())).thenReturn("Config");
    when(view.getEdges()).thenReturn(stringViewElementDefinitionMap);
    SchemaEdgeDefinition schemaEdgeDefinition = mock(SchemaEdgeDefinition.class);
    when(schemaEdgeDefinition.containsProperty(Mockito.<String>any())).thenReturn(true);
    when(schemaEdgeDefinition.getGroupBy()).thenReturn(new HashSet<>());
    Schema schema = mock(Schema.class);
    when(schema.getEdge(Mockito.<String>any())).thenReturn(schemaEdgeDefinition);

    HashSet<StoreTrait> storeTraits = new HashSet<>();
    storeTraits.add(StoreTrait.PRE_AGGREGATION_FILTERING);
    storeTraits.add(StoreTrait.QUERY_AGGREGATION);
    ValidationResult result = new ValidationResult("An error occurred");

    // Act
    viewValidator.validateEdge(view, schema, storeTraits, true, result);

    // Assert
    verify(schema).getEdge(eq("foo"));
    verify(view, atLeast(1)).getEdges();
    verify(view).getConfig(eq("skipViewValidation"));
    verify(globalViewElementDefinition).getAggregator();
    verify(globalViewElementDefinition).getGroupBy();
    verify(globalViewElementDefinition, atLeast(1)).getPostAggregationFilter();
    verify(globalViewElementDefinition, atLeast(1)).getPostTransformFilter();
    verify(globalViewElementDefinition, atLeast(1)).getPreAggregationFilter();
    verify(globalViewElementDefinition, atLeast(1)).getTransformer();
    verify(globalViewElementDefinition).getTransientProperties();
    verify(schemaEdgeDefinition).containsProperty(eq("This store does not currently support "));
    verify(schemaEdgeDefinition).getGroupBy();
    assertEquals("Validation errors: \n" + "An error occurred\n"
        + "Transient property This store does not currently support  for edge group foo is not transient as it"
        + " has been found in the schema\n"
        + "Group by properties for group foo in the view are not all included in the group by field in the schema."
        + " View groupBy:[This store does not currently support ]. Schema groupBy:[]", result.getErrorString());
    Set<String> errors = result.getErrors();
    assertEquals(3, errors.size());
    assertTrue(errors.contains(
        "Group by properties for group foo in the view are not all included in the group by field in the schema."
            + " View groupBy:[This store does not currently support ]. Schema groupBy:[]"));
    assertTrue(errors
        .contains("Transient property This store does not currently support  for edge group foo is not transient as it"
            + " has been found in the schema"));
  }

  /**
   * Test {@link ViewValidator#validateEdge(View, Schema, Set, boolean, ValidationResult)}.
   * <ul>
   *   <li>Given {@code QUERY_AGGREGATION}.</li>
   *   <li>Then calls {@link SchemaElementDefinition#containsProperty(String)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ViewValidator#validateEdge(View, Schema, Set, boolean, ValidationResult)}
   */
  @Test
  @DisplayName("Test validateEdge(View, Schema, Set, boolean, ValidationResult); given 'QUERY_AGGREGATION'; then calls containsProperty(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void ViewValidator.validateEdge(View, Schema, Set, boolean, ValidationResult)"})
  void testValidateEdge_givenQueryAggregation_thenCallsContainsProperty() {
    // Arrange
    ViewValidator viewValidator = new ViewValidator();

    HashSet<String> stringSet = new HashSet<>();
    stringSet.add("This store does not currently support ");

    HashSet<String> stringSet2 = new HashSet<>();
    stringSet2.add("This store does not currently support ");
    GlobalViewElementDefinition globalViewElementDefinition = mock(GlobalViewElementDefinition.class);
    when(globalViewElementDefinition.getGroupBy()).thenReturn(stringSet);
    when(globalViewElementDefinition.getTransientProperties()).thenReturn(stringSet2);
    ElementAggregator buildResult = (new ElementAggregator.Builder()).build();
    when(globalViewElementDefinition.getAggregator()).thenReturn(buildResult);
    ElementFilter buildResult2 = (new Builder()).build();
    when(globalViewElementDefinition.getPostAggregationFilter()).thenReturn(buildResult2);
    ElementFilter buildResult3 = (new Builder()).build();
    when(globalViewElementDefinition.getPostTransformFilter()).thenReturn(buildResult3);
    ElementFilter buildResult4 = (new Builder()).build();
    when(globalViewElementDefinition.getPreAggregationFilter()).thenReturn(buildResult4);
    ElementTransformer buildResult5 = (new ElementTransformer.Builder()).build();
    when(globalViewElementDefinition.getTransformer()).thenReturn(buildResult5);

    HashMap<String, ViewElementDefinition> stringViewElementDefinitionMap = new HashMap<>();
    stringViewElementDefinitionMap.put("foo", globalViewElementDefinition);
    NamedView view = mock(NamedView.class);
    when(view.getConfig(Mockito.<String>any())).thenReturn("Config");
    when(view.getEdges()).thenReturn(stringViewElementDefinitionMap);
    SchemaEdgeDefinition schemaEdgeDefinition = mock(SchemaEdgeDefinition.class);
    when(schemaEdgeDefinition.containsProperty(Mockito.<String>any())).thenReturn(true);
    when(schemaEdgeDefinition.getGroupBy()).thenReturn(new HashSet<>());
    Schema schema = mock(Schema.class);
    when(schema.getEdge(Mockito.<String>any())).thenReturn(schemaEdgeDefinition);

    HashSet<StoreTrait> storeTraits = new HashSet<>();
    storeTraits.add(StoreTrait.QUERY_AGGREGATION);
    ValidationResult result = new ValidationResult("An error occurred");

    // Act
    viewValidator.validateEdge(view, schema, storeTraits, true, result);

    // Assert
    verify(schema).getEdge(eq("foo"));
    verify(view, atLeast(1)).getEdges();
    verify(view).getConfig(eq("skipViewValidation"));
    verify(globalViewElementDefinition).getAggregator();
    verify(globalViewElementDefinition).getGroupBy();
    verify(globalViewElementDefinition, atLeast(1)).getPostAggregationFilter();
    verify(globalViewElementDefinition, atLeast(1)).getPostTransformFilter();
    verify(globalViewElementDefinition, atLeast(1)).getPreAggregationFilter();
    verify(globalViewElementDefinition, atLeast(1)).getTransformer();
    verify(globalViewElementDefinition).getTransientProperties();
    verify(schemaEdgeDefinition).containsProperty(eq("This store does not currently support "));
    verify(schemaEdgeDefinition).getGroupBy();
    assertEquals("Validation errors: \n" + "An error occurred\n"
        + "Transient property This store does not currently support  for edge group foo is not transient as it"
        + " has been found in the schema\n"
        + "Group by properties for group foo in the view are not all included in the group by field in the schema."
        + " View groupBy:[This store does not currently support ]. Schema groupBy:[]", result.getErrorString());
    Set<String> errors = result.getErrors();
    assertEquals(3, errors.size());
    assertTrue(errors.contains(
        "Group by properties for group foo in the view are not all included in the group by field in the schema."
            + " View groupBy:[This store does not currently support ]. Schema groupBy:[]"));
    assertTrue(errors
        .contains("Transient property This store does not currently support  for edge group foo is not transient as it"
            + " has been found in the schema"));
  }

  /**
   * Test {@link ViewValidator#validateEdge(View, Schema, Set, boolean, ValidationResult)}.
   * <ul>
   *   <li>When {@link View} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link ViewValidator#validateEdge(View, Schema, Set, boolean, ValidationResult)}
   */
  @Test
  @DisplayName("Test validateEdge(View, Schema, Set, boolean, ValidationResult); when View (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void ViewValidator.validateEdge(View, Schema, Set, boolean, ValidationResult)"})
  void testValidateEdge_whenView() {
    // Arrange
    ViewValidator viewValidator = new ViewValidator();
    View view = new View();
    Schema schema = new Schema();
    HashSet<StoreTrait> storeTraits = new HashSet<>();
    ValidationResult result = new ValidationResult("An error occurred");

    // Act
    viewValidator.validateEdge(view, schema, storeTraits, true, result);

    // Assert that nothing has changed
    assertEquals("Validation errors: \nAn error occurred", result.getErrorString());
    assertEquals(1, result.getErrors().size());
  }

  /**
   * Test {@link ViewValidator#validateEntities(View, Schema, Set, boolean, ValidationResult)}.
   * <p>
   * Method under test: {@link ViewValidator#validateEntities(View, Schema, Set, boolean, ValidationResult)}
   */
  @Test
  @DisplayName("Test validateEntities(View, Schema, Set, boolean, ValidationResult)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void ViewValidator.validateEntities(View, Schema, Set, boolean, ValidationResult)"})
  void testValidateEntities() {
    // Arrange
    ViewValidator viewValidator = new ViewValidator();

    HashMap<String, ViewElementDefinition> stringViewElementDefinitionMap = new HashMap<>();
    stringViewElementDefinitionMap.put("foo", new ViewElementDefinition());
    NamedView view = mock(NamedView.class);
    when(view.getEntities()).thenReturn(stringViewElementDefinitionMap);
    Schema schema = new Schema();
    HashSet<StoreTrait> storeTraits = new HashSet<>();
    ValidationResult result = new ValidationResult("An error occurred");

    // Act
    viewValidator.validateEntities(view, schema, storeTraits, true, result);

    // Assert
    verify(view, atLeast(1)).getEntities();
    assertEquals("Validation errors: \nAn error occurred\nEntity group foo does not exist in the schema",
        result.getErrorString());
    Set<String> errors = result.getErrors();
    assertEquals(2, errors.size());
    assertTrue(errors.contains("Entity group foo does not exist in the schema"));
  }

  /**
   * Test {@link ViewValidator#validateEntities(View, Schema, Set, boolean, ValidationResult)}.
   * <p>
   * Method under test: {@link ViewValidator#validateEntities(View, Schema, Set, boolean, ValidationResult)}
   */
  @Test
  @DisplayName("Test validateEntities(View, Schema, Set, boolean, ValidationResult)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void ViewValidator.validateEntities(View, Schema, Set, boolean, ValidationResult)"})
  void testValidateEntities2() {
    // Arrange
    ViewValidator viewValidator = new ViewValidator();
    GlobalViewElementDefinition globalViewElementDefinition = mock(GlobalViewElementDefinition.class);
    when(globalViewElementDefinition.getGroupBy()).thenReturn(new HashSet<>());
    when(globalViewElementDefinition.getTransientProperties()).thenReturn(new HashSet<>());
    ElementAggregator buildResult = (new ElementAggregator.Builder()).build();
    when(globalViewElementDefinition.getAggregator()).thenReturn(buildResult);
    ElementFilter buildResult2 = (new Builder()).build();
    when(globalViewElementDefinition.getPostAggregationFilter()).thenReturn(buildResult2);
    ElementFilter buildResult3 = (new Builder()).build();
    when(globalViewElementDefinition.getPostTransformFilter()).thenReturn(buildResult3);
    ElementFilter buildResult4 = (new Builder()).build();
    when(globalViewElementDefinition.getPreAggregationFilter()).thenReturn(buildResult4);
    ElementTransformer buildResult5 = (new ElementTransformer.Builder()).build();
    when(globalViewElementDefinition.getTransformer()).thenReturn(buildResult5);

    HashMap<String, ViewElementDefinition> stringViewElementDefinitionMap = new HashMap<>();
    stringViewElementDefinitionMap.put("foo", globalViewElementDefinition);
    NamedView view = mock(NamedView.class);
    when(view.getConfig(Mockito.<String>any())).thenReturn("Config");
    when(view.getEntities()).thenReturn(stringViewElementDefinitionMap);
    Schema schema = mock(Schema.class);
    when(schema.getEntity(Mockito.<String>any())).thenReturn(new SchemaEntityDefinition());
    HashSet<StoreTrait> storeTraits = new HashSet<>();
    ValidationResult result = new ValidationResult("An error occurred");

    // Act
    viewValidator.validateEntities(view, schema, storeTraits, true, result);

    // Assert
    verify(view, atLeast(1)).getEntities();
    verify(schema).getEntity(eq("foo"));
    verify(view).getConfig(eq("skipViewValidation"));
    verify(globalViewElementDefinition, atLeast(1)).getAggregator();
    verify(globalViewElementDefinition).getGroupBy();
    verify(globalViewElementDefinition, atLeast(1)).getPostAggregationFilter();
    verify(globalViewElementDefinition, atLeast(1)).getPostTransformFilter();
    verify(globalViewElementDefinition, atLeast(1)).getPreAggregationFilter();
    verify(globalViewElementDefinition, atLeast(1)).getTransformer();
    verify(globalViewElementDefinition).getTransientProperties();
    assertEquals("Validation errors: \nAn error occurred\nThis store does not currently support QUERY_AGGREGATION",
        result.getErrorString());
    Set<String> errors = result.getErrors();
    assertEquals(2, errors.size());
    assertTrue(errors.contains("This store does not currently support QUERY_AGGREGATION"));
  }

  /**
   * Test {@link ViewValidator#validateEntities(View, Schema, Set, boolean, ValidationResult)}.
   * <p>
   * Method under test: {@link ViewValidator#validateEntities(View, Schema, Set, boolean, ValidationResult)}
   */
  @Test
  @DisplayName("Test validateEntities(View, Schema, Set, boolean, ValidationResult)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void ViewValidator.validateEntities(View, Schema, Set, boolean, ValidationResult)"})
  void testValidateEntities3() {
    // Arrange
    ViewValidator viewValidator = new ViewValidator();

    HashSet<String> stringSet = new HashSet<>();
    stringSet.add("This store does not currently support ");
    GlobalViewElementDefinition globalViewElementDefinition = mock(GlobalViewElementDefinition.class);
    when(globalViewElementDefinition.getGroupBy()).thenReturn(stringSet);
    when(globalViewElementDefinition.getTransientProperties()).thenReturn(new HashSet<>());
    ElementAggregator buildResult = (new ElementAggregator.Builder()).build();
    when(globalViewElementDefinition.getAggregator()).thenReturn(buildResult);
    ElementFilter buildResult2 = (new Builder()).build();
    when(globalViewElementDefinition.getPostAggregationFilter()).thenReturn(buildResult2);
    ElementFilter buildResult3 = (new Builder()).build();
    when(globalViewElementDefinition.getPostTransformFilter()).thenReturn(buildResult3);
    ElementFilter buildResult4 = (new Builder()).build();
    when(globalViewElementDefinition.getPreAggregationFilter()).thenReturn(buildResult4);
    ElementTransformer buildResult5 = (new ElementTransformer.Builder()).build();
    when(globalViewElementDefinition.getTransformer()).thenReturn(buildResult5);

    HashMap<String, ViewElementDefinition> stringViewElementDefinitionMap = new HashMap<>();
    stringViewElementDefinitionMap.put("foo", globalViewElementDefinition);
    NamedView view = mock(NamedView.class);
    when(view.getConfig(Mockito.<String>any())).thenReturn("Config");
    when(view.getEntities()).thenReturn(stringViewElementDefinitionMap);
    Schema schema = mock(Schema.class);
    when(schema.getEntity(Mockito.<String>any())).thenReturn(new SchemaEntityDefinition());
    HashSet<StoreTrait> storeTraits = new HashSet<>();
    ValidationResult result = new ValidationResult("An error occurred");

    // Act
    viewValidator.validateEntities(view, schema, storeTraits, true, result);

    // Assert
    verify(view, atLeast(1)).getEntities();
    verify(schema).getEntity(eq("foo"));
    verify(view).getConfig(eq("skipViewValidation"));
    verify(globalViewElementDefinition, atLeast(1)).getAggregator();
    verify(globalViewElementDefinition).getGroupBy();
    verify(globalViewElementDefinition, atLeast(1)).getPostAggregationFilter();
    verify(globalViewElementDefinition, atLeast(1)).getPostTransformFilter();
    verify(globalViewElementDefinition, atLeast(1)).getPreAggregationFilter();
    verify(globalViewElementDefinition, atLeast(1)).getTransformer();
    verify(globalViewElementDefinition).getTransientProperties();
    assertEquals(
        "Validation errors: \n" + "An error occurred\n" + "This store does not currently support QUERY_AGGREGATION\n"
            + "Group by properties for group foo in the view are not all included in the group by field in the schema."
            + " View groupBy:[This store does not currently support ]. Schema groupBy:[]",
        result.getErrorString());
    Set<String> errors = result.getErrors();
    assertEquals(3, errors.size());
    assertTrue(errors.contains(
        "Group by properties for group foo in the view are not all included in the group by field in the schema."
            + " View groupBy:[This store does not currently support ]. Schema groupBy:[]"));
    assertTrue(errors.contains("This store does not currently support QUERY_AGGREGATION"));
  }

  /**
   * Test {@link ViewValidator#validateEntities(View, Schema, Set, boolean, ValidationResult)}.
   * <p>
   * Method under test: {@link ViewValidator#validateEntities(View, Schema, Set, boolean, ValidationResult)}
   */
  @Test
  @DisplayName("Test validateEntities(View, Schema, Set, boolean, ValidationResult)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void ViewValidator.validateEntities(View, Schema, Set, boolean, ValidationResult)"})
  void testValidateEntities4() {
    // Arrange
    ViewValidator viewValidator = new ViewValidator();

    HashSet<String> stringSet = new HashSet<>();
    stringSet.add("This store does not currently support ");
    GlobalViewElementDefinition globalViewElementDefinition = mock(GlobalViewElementDefinition.class);
    when(globalViewElementDefinition.getGroupBy()).thenReturn(new HashSet<>());
    when(globalViewElementDefinition.getTransientProperties()).thenReturn(stringSet);
    ElementAggregator buildResult = (new ElementAggregator.Builder()).build();
    when(globalViewElementDefinition.getAggregator()).thenReturn(buildResult);
    ElementFilter buildResult2 = (new Builder()).build();
    when(globalViewElementDefinition.getPostAggregationFilter()).thenReturn(buildResult2);
    ElementFilter buildResult3 = (new Builder()).build();
    when(globalViewElementDefinition.getPostTransformFilter()).thenReturn(buildResult3);
    ElementFilter buildResult4 = (new Builder()).build();
    when(globalViewElementDefinition.getPreAggregationFilter()).thenReturn(buildResult4);
    ElementTransformer buildResult5 = (new ElementTransformer.Builder()).build();
    when(globalViewElementDefinition.getTransformer()).thenReturn(buildResult5);

    HashMap<String, ViewElementDefinition> stringViewElementDefinitionMap = new HashMap<>();
    stringViewElementDefinitionMap.put("foo", globalViewElementDefinition);
    NamedView view = mock(NamedView.class);
    when(view.getConfig(Mockito.<String>any())).thenReturn("Config");
    when(view.getEntities()).thenReturn(stringViewElementDefinitionMap);
    Schema schema = mock(Schema.class);
    when(schema.getEntity(Mockito.<String>any())).thenReturn(new SchemaEntityDefinition());
    HashSet<StoreTrait> storeTraits = new HashSet<>();
    ValidationResult result = new ValidationResult("An error occurred");

    // Act
    viewValidator.validateEntities(view, schema, storeTraits, true, result);

    // Assert
    verify(view, atLeast(1)).getEntities();
    verify(schema).getEntity(eq("foo"));
    verify(view).getConfig(eq("skipViewValidation"));
    verify(globalViewElementDefinition, atLeast(1)).getAggregator();
    verify(globalViewElementDefinition).getGroupBy();
    verify(globalViewElementDefinition, atLeast(1)).getPostAggregationFilter();
    verify(globalViewElementDefinition, atLeast(1)).getPostTransformFilter();
    verify(globalViewElementDefinition, atLeast(1)).getPreAggregationFilter();
    verify(globalViewElementDefinition, atLeast(1)).getTransformer();
    verify(globalViewElementDefinition).getTransientProperties();
    assertEquals("Validation errors: \nAn error occurred\nThis store does not currently support QUERY_AGGREGATION",
        result.getErrorString());
    Set<String> errors = result.getErrors();
    assertEquals(2, errors.size());
    assertTrue(errors.contains("This store does not currently support QUERY_AGGREGATION"));
  }

  /**
   * Test {@link ViewValidator#validateEntities(View, Schema, Set, boolean, ValidationResult)}.
   * <p>
   * Method under test: {@link ViewValidator#validateEntities(View, Schema, Set, boolean, ValidationResult)}
   */
  @Test
  @DisplayName("Test validateEntities(View, Schema, Set, boolean, ValidationResult)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void ViewValidator.validateEntities(View, Schema, Set, boolean, ValidationResult)"})
  void testValidateEntities5() {
    // Arrange
    ViewValidator viewValidator = new ViewValidator();

    HashSet<String> stringSet = new HashSet<>();
    stringSet.add("This store does not currently support ");
    GlobalViewElementDefinition globalViewElementDefinition = mock(GlobalViewElementDefinition.class);
    when(globalViewElementDefinition.getGroupBy()).thenReturn(stringSet);
    when(globalViewElementDefinition.getTransientProperties()).thenReturn(new HashSet<>());
    ElementAggregator buildResult = (new ElementAggregator.Builder()).build();
    when(globalViewElementDefinition.getAggregator()).thenReturn(buildResult);
    ElementFilter buildResult2 = (new Builder()).build();
    when(globalViewElementDefinition.getPostAggregationFilter()).thenReturn(buildResult2);
    ElementFilter buildResult3 = (new Builder()).build();
    when(globalViewElementDefinition.getPostTransformFilter()).thenReturn(buildResult3);
    ElementFilter buildResult4 = (new Builder()).build();
    when(globalViewElementDefinition.getPreAggregationFilter()).thenReturn(buildResult4);
    ElementTransformer buildResult5 = (new ElementTransformer.Builder()).build();
    when(globalViewElementDefinition.getTransformer()).thenReturn(buildResult5);

    HashMap<String, ViewElementDefinition> stringViewElementDefinitionMap = new HashMap<>();
    stringViewElementDefinitionMap.put("foo", globalViewElementDefinition);
    NamedView view = mock(NamedView.class);
    when(view.getConfig(Mockito.<String>any())).thenReturn("Config");
    when(view.getEntities()).thenReturn(stringViewElementDefinitionMap);
    SchemaEntityDefinition schemaEntityDefinition = mock(SchemaEntityDefinition.class);
    when(schemaEntityDefinition.getGroupBy()).thenReturn(new HashSet<>());
    Schema schema = mock(Schema.class);
    when(schema.getEntity(Mockito.<String>any())).thenReturn(schemaEntityDefinition);
    HashSet<StoreTrait> storeTraits = new HashSet<>();
    ValidationResult result = new ValidationResult("An error occurred");

    // Act
    viewValidator.validateEntities(view, schema, storeTraits, true, result);

    // Assert
    verify(view, atLeast(1)).getEntities();
    verify(schema).getEntity(eq("foo"));
    verify(view).getConfig(eq("skipViewValidation"));
    verify(globalViewElementDefinition, atLeast(1)).getAggregator();
    verify(globalViewElementDefinition).getGroupBy();
    verify(globalViewElementDefinition, atLeast(1)).getPostAggregationFilter();
    verify(globalViewElementDefinition, atLeast(1)).getPostTransformFilter();
    verify(globalViewElementDefinition, atLeast(1)).getPreAggregationFilter();
    verify(globalViewElementDefinition, atLeast(1)).getTransformer();
    verify(globalViewElementDefinition).getTransientProperties();
    verify(schemaEntityDefinition).getGroupBy();
    assertEquals(
        "Validation errors: \n" + "An error occurred\n" + "This store does not currently support QUERY_AGGREGATION\n"
            + "Group by properties for group foo in the view are not all included in the group by field in the schema."
            + " View groupBy:[This store does not currently support ]. Schema groupBy:[]",
        result.getErrorString());
    Set<String> errors = result.getErrors();
    assertEquals(3, errors.size());
    assertTrue(errors.contains(
        "Group by properties for group foo in the view are not all included in the group by field in the schema."
            + " View groupBy:[This store does not currently support ]. Schema groupBy:[]"));
    assertTrue(errors.contains("This store does not currently support QUERY_AGGREGATION"));
  }

  /**
   * Test {@link ViewValidator#validateEntities(View, Schema, Set, boolean, ValidationResult)}.
   * <p>
   * Method under test: {@link ViewValidator#validateEntities(View, Schema, Set, boolean, ValidationResult)}
   */
  @Test
  @DisplayName("Test validateEntities(View, Schema, Set, boolean, ValidationResult)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void ViewValidator.validateEntities(View, Schema, Set, boolean, ValidationResult)"})
  void testValidateEntities6() {
    // Arrange
    ViewValidator viewValidator = new ViewValidator();

    HashSet<String> stringSet = new HashSet<>();
    stringSet.add("This store does not currently support ");

    HashSet<String> stringSet2 = new HashSet<>();
    stringSet2.add("This store does not currently support ");
    GlobalViewElementDefinition globalViewElementDefinition = mock(GlobalViewElementDefinition.class);
    when(globalViewElementDefinition.getGroupBy()).thenReturn(stringSet);
    when(globalViewElementDefinition.getTransientProperties()).thenReturn(stringSet2);
    ElementAggregator buildResult = (new ElementAggregator.Builder()).build();
    when(globalViewElementDefinition.getAggregator()).thenReturn(buildResult);
    ElementFilter buildResult2 = (new Builder()).build();
    when(globalViewElementDefinition.getPostAggregationFilter()).thenReturn(buildResult2);
    ElementFilter buildResult3 = (new Builder()).build();
    when(globalViewElementDefinition.getPostTransformFilter()).thenReturn(buildResult3);
    ElementFilter buildResult4 = (new Builder()).build();
    when(globalViewElementDefinition.getPreAggregationFilter()).thenReturn(buildResult4);
    ElementTransformer buildResult5 = (new ElementTransformer.Builder()).build();
    when(globalViewElementDefinition.getTransformer()).thenReturn(buildResult5);

    HashMap<String, ViewElementDefinition> stringViewElementDefinitionMap = new HashMap<>();
    stringViewElementDefinitionMap.put("foo", globalViewElementDefinition);
    NamedView view = mock(NamedView.class);
    when(view.getConfig(Mockito.<String>any())).thenReturn("Config");
    when(view.getEntities()).thenReturn(stringViewElementDefinitionMap);
    SchemaEntityDefinition schemaEntityDefinition = mock(SchemaEntityDefinition.class);
    when(schemaEntityDefinition.containsProperty(Mockito.<String>any())).thenReturn(true);
    when(schemaEntityDefinition.getGroupBy()).thenReturn(new HashSet<>());
    Schema schema = mock(Schema.class);
    when(schema.getEntity(Mockito.<String>any())).thenReturn(schemaEntityDefinition);
    HashSet<StoreTrait> storeTraits = new HashSet<>();
    ValidationResult result = new ValidationResult("An error occurred");

    // Act
    viewValidator.validateEntities(view, schema, storeTraits, true, result);

    // Assert
    verify(view, atLeast(1)).getEntities();
    verify(schema).getEntity(eq("foo"));
    verify(view).getConfig(eq("skipViewValidation"));
    verify(globalViewElementDefinition, atLeast(1)).getAggregator();
    verify(globalViewElementDefinition).getGroupBy();
    verify(globalViewElementDefinition, atLeast(1)).getPostAggregationFilter();
    verify(globalViewElementDefinition, atLeast(1)).getPostTransformFilter();
    verify(globalViewElementDefinition, atLeast(1)).getPreAggregationFilter();
    verify(globalViewElementDefinition, atLeast(1)).getTransformer();
    verify(globalViewElementDefinition).getTransientProperties();
    verify(schemaEntityDefinition).containsProperty(eq("This store does not currently support "));
    verify(schemaEntityDefinition).getGroupBy();
    assertEquals("Validation errors: \n" + "An error occurred\n"
        + "Transient property This store does not currently support  for entity group foo is not transient as it"
        + " has been found in the schema\n" + "This store does not currently support QUERY_AGGREGATION\n"
        + "Group by properties for group foo in the view are not all included in the group by field in the schema."
        + " View groupBy:[This store does not currently support ]. Schema groupBy:[]", result.getErrorString());
    Set<String> errors = result.getErrors();
    assertEquals(4, errors.size());
    assertTrue(errors.contains(
        "Group by properties for group foo in the view are not all included in the group by field in the schema."
            + " View groupBy:[This store does not currently support ]. Schema groupBy:[]"));
    assertTrue(errors.contains("This store does not currently support QUERY_AGGREGATION"));
  }

  /**
   * Test {@link ViewValidator#validateEntities(View, Schema, Set, boolean, ValidationResult)}.
   * <ul>
   *   <li>Given {@link HashMap#HashMap()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ViewValidator#validateEntities(View, Schema, Set, boolean, ValidationResult)}
   */
  @Test
  @DisplayName("Test validateEntities(View, Schema, Set, boolean, ValidationResult); given HashMap()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void ViewValidator.validateEntities(View, Schema, Set, boolean, ValidationResult)"})
  void testValidateEntities_givenHashMap() {
    // Arrange
    ViewValidator viewValidator = new ViewValidator();
    NamedView view = mock(NamedView.class);
    when(view.getEntities()).thenReturn(new HashMap<>());
    Schema schema = new Schema();
    HashSet<StoreTrait> storeTraits = new HashSet<>();
    ValidationResult result = new ValidationResult("An error occurred");

    // Act
    viewValidator.validateEntities(view, schema, storeTraits, true, result);

    // Assert that nothing has changed
    verify(view, atLeast(1)).getEntities();
    assertEquals("Validation errors: \nAn error occurred", result.getErrorString());
    assertEquals(1, result.getErrors().size());
  }

  /**
   * Test {@link ViewValidator#validateEntities(View, Schema, Set, boolean, ValidationResult)}.
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} {@code foo} is {@link ViewElementDefinition} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link ViewValidator#validateEntities(View, Schema, Set, boolean, ValidationResult)}
   */
  @Test
  @DisplayName("Test validateEntities(View, Schema, Set, boolean, ValidationResult); given HashMap() 'foo' is ViewElementDefinition (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void ViewValidator.validateEntities(View, Schema, Set, boolean, ValidationResult)"})
  void testValidateEntities_givenHashMapFooIsViewElementDefinition() {
    // Arrange
    ViewValidator viewValidator = new ViewValidator();

    HashMap<String, ViewElementDefinition> stringViewElementDefinitionMap = new HashMap<>();
    stringViewElementDefinitionMap.put("foo", new ViewElementDefinition());
    NamedView view = mock(NamedView.class);
    when(view.getConfig(Mockito.<String>any())).thenReturn("Config");
    when(view.getEntities()).thenReturn(stringViewElementDefinitionMap);
    Schema schema = mock(Schema.class);
    when(schema.getEntity(Mockito.<String>any())).thenReturn(new SchemaEntityDefinition());
    HashSet<StoreTrait> storeTraits = new HashSet<>();
    ValidationResult result = new ValidationResult("An error occurred");

    // Act
    viewValidator.validateEntities(view, schema, storeTraits, true, result);

    // Assert that nothing has changed
    verify(view, atLeast(1)).getEntities();
    verify(schema).getEntity(eq("foo"));
    verify(view).getConfig(eq("skipViewValidation"));
    assertEquals("Validation errors: \nAn error occurred", result.getErrorString());
    assertEquals(1, result.getErrors().size());
  }

  /**
   * Test {@link ViewValidator#validateEntities(View, Schema, Set, boolean, ValidationResult)}.
   * <ul>
   *   <li>Given {@code INGEST_AGGREGATION}.</li>
   *   <li>When {@link HashSet#HashSet()} add {@code INGEST_AGGREGATION}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ViewValidator#validateEntities(View, Schema, Set, boolean, ValidationResult)}
   */
  @Test
  @DisplayName("Test validateEntities(View, Schema, Set, boolean, ValidationResult); given 'INGEST_AGGREGATION'; when HashSet() add 'INGEST_AGGREGATION'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void ViewValidator.validateEntities(View, Schema, Set, boolean, ValidationResult)"})
  void testValidateEntities_givenIngestAggregation_whenHashSetAddIngestAggregation() {
    // Arrange
    ViewValidator viewValidator = new ViewValidator();
    NamedView view = mock(NamedView.class);
    when(view.getEntities()).thenReturn(new HashMap<>());
    Schema schema = new Schema();

    HashSet<StoreTrait> storeTraits = new HashSet<>();
    storeTraits.add(StoreTrait.INGEST_AGGREGATION);
    ValidationResult result = new ValidationResult("An error occurred");

    // Act
    viewValidator.validateEntities(view, schema, storeTraits, true, result);

    // Assert that nothing has changed
    verify(view, atLeast(1)).getEntities();
    assertEquals("Validation errors: \nAn error occurred", result.getErrorString());
    assertEquals(1, result.getErrors().size());
  }

  /**
   * Test {@link ViewValidator#validateEntities(View, Schema, Set, boolean, ValidationResult)}.
   * <ul>
   *   <li>Given {@code INGEST_AGGREGATION}.</li>
   *   <li>When {@link HashSet#HashSet()} add {@code INGEST_AGGREGATION}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ViewValidator#validateEntities(View, Schema, Set, boolean, ValidationResult)}
   */
  @Test
  @DisplayName("Test validateEntities(View, Schema, Set, boolean, ValidationResult); given 'INGEST_AGGREGATION'; when HashSet() add 'INGEST_AGGREGATION'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void ViewValidator.validateEntities(View, Schema, Set, boolean, ValidationResult)"})
  void testValidateEntities_givenIngestAggregation_whenHashSetAddIngestAggregation2() {
    // Arrange
    ViewValidator viewValidator = new ViewValidator();
    NamedView view = mock(NamedView.class);
    when(view.getEntities()).thenReturn(new HashMap<>());
    Schema schema = new Schema();

    HashSet<StoreTrait> storeTraits = new HashSet<>();
    storeTraits.add(StoreTrait.QUERY_AGGREGATION);
    storeTraits.add(StoreTrait.INGEST_AGGREGATION);
    ValidationResult result = new ValidationResult("An error occurred");

    // Act
    viewValidator.validateEntities(view, schema, storeTraits, true, result);

    // Assert that nothing has changed
    verify(view, atLeast(1)).getEntities();
    assertEquals("Validation errors: \nAn error occurred", result.getErrorString());
    assertEquals(1, result.getErrors().size());
  }

  /**
   * Test {@link ViewValidator#validateEntities(View, Schema, Set, boolean, ValidationResult)}.
   * <ul>
   *   <li>Given {@code PRE_AGGREGATION_FILTERING}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ViewValidator#validateEntities(View, Schema, Set, boolean, ValidationResult)}
   */
  @Test
  @DisplayName("Test validateEntities(View, Schema, Set, boolean, ValidationResult); given 'PRE_AGGREGATION_FILTERING'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void ViewValidator.validateEntities(View, Schema, Set, boolean, ValidationResult)"})
  void testValidateEntities_givenPreAggregationFiltering() {
    // Arrange
    ViewValidator viewValidator = new ViewValidator();

    HashSet<String> stringSet = new HashSet<>();
    stringSet.add("This store does not currently support ");

    HashSet<String> stringSet2 = new HashSet<>();
    stringSet2.add("This store does not currently support ");
    GlobalViewElementDefinition globalViewElementDefinition = mock(GlobalViewElementDefinition.class);
    when(globalViewElementDefinition.getGroupBy()).thenReturn(stringSet);
    when(globalViewElementDefinition.getTransientProperties()).thenReturn(stringSet2);
    ElementAggregator buildResult = (new ElementAggregator.Builder()).build();
    when(globalViewElementDefinition.getAggregator()).thenReturn(buildResult);
    ElementFilter buildResult2 = (new Builder()).build();
    when(globalViewElementDefinition.getPostAggregationFilter()).thenReturn(buildResult2);
    ElementFilter buildResult3 = (new Builder()).build();
    when(globalViewElementDefinition.getPostTransformFilter()).thenReturn(buildResult3);
    ElementFilter buildResult4 = (new Builder()).build();
    when(globalViewElementDefinition.getPreAggregationFilter()).thenReturn(buildResult4);
    ElementTransformer buildResult5 = (new ElementTransformer.Builder()).build();
    when(globalViewElementDefinition.getTransformer()).thenReturn(buildResult5);

    HashMap<String, ViewElementDefinition> stringViewElementDefinitionMap = new HashMap<>();
    stringViewElementDefinitionMap.put("foo", globalViewElementDefinition);
    NamedView view = mock(NamedView.class);
    when(view.getConfig(Mockito.<String>any())).thenReturn("Config");
    when(view.getEntities()).thenReturn(stringViewElementDefinitionMap);
    SchemaEntityDefinition schemaEntityDefinition = mock(SchemaEntityDefinition.class);
    when(schemaEntityDefinition.containsProperty(Mockito.<String>any())).thenReturn(true);
    when(schemaEntityDefinition.getGroupBy()).thenReturn(new HashSet<>());
    Schema schema = mock(Schema.class);
    when(schema.getEntity(Mockito.<String>any())).thenReturn(schemaEntityDefinition);

    HashSet<StoreTrait> storeTraits = new HashSet<>();
    storeTraits.add(StoreTrait.PRE_AGGREGATION_FILTERING);
    storeTraits.add(StoreTrait.QUERY_AGGREGATION);
    ValidationResult result = new ValidationResult("An error occurred");

    // Act
    viewValidator.validateEntities(view, schema, storeTraits, true, result);

    // Assert
    verify(view, atLeast(1)).getEntities();
    verify(schema).getEntity(eq("foo"));
    verify(view).getConfig(eq("skipViewValidation"));
    verify(globalViewElementDefinition).getAggregator();
    verify(globalViewElementDefinition).getGroupBy();
    verify(globalViewElementDefinition, atLeast(1)).getPostAggregationFilter();
    verify(globalViewElementDefinition, atLeast(1)).getPostTransformFilter();
    verify(globalViewElementDefinition, atLeast(1)).getPreAggregationFilter();
    verify(globalViewElementDefinition, atLeast(1)).getTransformer();
    verify(globalViewElementDefinition).getTransientProperties();
    verify(schemaEntityDefinition).containsProperty(eq("This store does not currently support "));
    verify(schemaEntityDefinition).getGroupBy();
    assertEquals("Validation errors: \n" + "An error occurred\n"
        + "Transient property This store does not currently support  for entity group foo is not transient as it"
        + " has been found in the schema\n"
        + "Group by properties for group foo in the view are not all included in the group by field in the schema."
        + " View groupBy:[This store does not currently support ]. Schema groupBy:[]", result.getErrorString());
    Set<String> errors = result.getErrors();
    assertEquals(3, errors.size());
    assertTrue(errors.contains(
        "Group by properties for group foo in the view are not all included in the group by field in the schema."
            + " View groupBy:[This store does not currently support ]. Schema groupBy:[]"));
    assertTrue(errors.contains(
        "Transient property This store does not currently support  for entity group foo is not transient as it"
            + " has been found in the schema"));
  }

  /**
   * Test {@link ViewValidator#validateEntities(View, Schema, Set, boolean, ValidationResult)}.
   * <ul>
   *   <li>Given {@code QUERY_AGGREGATION}.</li>
   *   <li>Then calls {@link SchemaElementDefinition#containsProperty(String)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ViewValidator#validateEntities(View, Schema, Set, boolean, ValidationResult)}
   */
  @Test
  @DisplayName("Test validateEntities(View, Schema, Set, boolean, ValidationResult); given 'QUERY_AGGREGATION'; then calls containsProperty(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void ViewValidator.validateEntities(View, Schema, Set, boolean, ValidationResult)"})
  void testValidateEntities_givenQueryAggregation_thenCallsContainsProperty() {
    // Arrange
    ViewValidator viewValidator = new ViewValidator();

    HashSet<String> stringSet = new HashSet<>();
    stringSet.add("This store does not currently support ");

    HashSet<String> stringSet2 = new HashSet<>();
    stringSet2.add("This store does not currently support ");
    GlobalViewElementDefinition globalViewElementDefinition = mock(GlobalViewElementDefinition.class);
    when(globalViewElementDefinition.getGroupBy()).thenReturn(stringSet);
    when(globalViewElementDefinition.getTransientProperties()).thenReturn(stringSet2);
    ElementAggregator buildResult = (new ElementAggregator.Builder()).build();
    when(globalViewElementDefinition.getAggregator()).thenReturn(buildResult);
    ElementFilter buildResult2 = (new Builder()).build();
    when(globalViewElementDefinition.getPostAggregationFilter()).thenReturn(buildResult2);
    ElementFilter buildResult3 = (new Builder()).build();
    when(globalViewElementDefinition.getPostTransformFilter()).thenReturn(buildResult3);
    ElementFilter buildResult4 = (new Builder()).build();
    when(globalViewElementDefinition.getPreAggregationFilter()).thenReturn(buildResult4);
    ElementTransformer buildResult5 = (new ElementTransformer.Builder()).build();
    when(globalViewElementDefinition.getTransformer()).thenReturn(buildResult5);

    HashMap<String, ViewElementDefinition> stringViewElementDefinitionMap = new HashMap<>();
    stringViewElementDefinitionMap.put("foo", globalViewElementDefinition);
    NamedView view = mock(NamedView.class);
    when(view.getConfig(Mockito.<String>any())).thenReturn("Config");
    when(view.getEntities()).thenReturn(stringViewElementDefinitionMap);
    SchemaEntityDefinition schemaEntityDefinition = mock(SchemaEntityDefinition.class);
    when(schemaEntityDefinition.containsProperty(Mockito.<String>any())).thenReturn(true);
    when(schemaEntityDefinition.getGroupBy()).thenReturn(new HashSet<>());
    Schema schema = mock(Schema.class);
    when(schema.getEntity(Mockito.<String>any())).thenReturn(schemaEntityDefinition);

    HashSet<StoreTrait> storeTraits = new HashSet<>();
    storeTraits.add(StoreTrait.QUERY_AGGREGATION);
    ValidationResult result = new ValidationResult("An error occurred");

    // Act
    viewValidator.validateEntities(view, schema, storeTraits, true, result);

    // Assert
    verify(view, atLeast(1)).getEntities();
    verify(schema).getEntity(eq("foo"));
    verify(view).getConfig(eq("skipViewValidation"));
    verify(globalViewElementDefinition).getAggregator();
    verify(globalViewElementDefinition).getGroupBy();
    verify(globalViewElementDefinition, atLeast(1)).getPostAggregationFilter();
    verify(globalViewElementDefinition, atLeast(1)).getPostTransformFilter();
    verify(globalViewElementDefinition, atLeast(1)).getPreAggregationFilter();
    verify(globalViewElementDefinition, atLeast(1)).getTransformer();
    verify(globalViewElementDefinition).getTransientProperties();
    verify(schemaEntityDefinition).containsProperty(eq("This store does not currently support "));
    verify(schemaEntityDefinition).getGroupBy();
    assertEquals("Validation errors: \n" + "An error occurred\n"
        + "Transient property This store does not currently support  for entity group foo is not transient as it"
        + " has been found in the schema\n"
        + "Group by properties for group foo in the view are not all included in the group by field in the schema."
        + " View groupBy:[This store does not currently support ]. Schema groupBy:[]", result.getErrorString());
    Set<String> errors = result.getErrors();
    assertEquals(3, errors.size());
    assertTrue(errors.contains(
        "Group by properties for group foo in the view are not all included in the group by field in the schema."
            + " View groupBy:[This store does not currently support ]. Schema groupBy:[]"));
    assertTrue(errors.contains(
        "Transient property This store does not currently support  for entity group foo is not transient as it"
            + " has been found in the schema"));
  }

  /**
   * Test {@link ViewValidator#validateEntities(View, Schema, Set, boolean, ValidationResult)}.
   * <ul>
   *   <li>When {@link View} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link ViewValidator#validateEntities(View, Schema, Set, boolean, ValidationResult)}
   */
  @Test
  @DisplayName("Test validateEntities(View, Schema, Set, boolean, ValidationResult); when View (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void ViewValidator.validateEntities(View, Schema, Set, boolean, ValidationResult)"})
  void testValidateEntities_whenView() {
    // Arrange
    ViewValidator viewValidator = new ViewValidator();
    View view = new View();
    Schema schema = new Schema();
    HashSet<StoreTrait> storeTraits = new HashSet<>();
    ValidationResult result = new ValidationResult("An error occurred");

    // Act
    viewValidator.validateEntities(view, schema, storeTraits, true, result);

    // Assert that nothing has changed
    assertEquals("Validation errors: \nAn error occurred", result.getErrorString());
    assertEquals(1, result.getErrors().size());
  }

  /**
   * Test {@link ViewValidator#validateAgainstStoreTraits(ViewElementDefinition, Set)}.
   * <ul>
   *   <li>Given {@code INGEST_AGGREGATION}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ViewValidator#validateAgainstStoreTraits(ViewElementDefinition, Set)}
   */
  @Test
  @DisplayName("Test validateAgainstStoreTraits(ViewElementDefinition, Set); given 'INGEST_AGGREGATION'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ValidationResult ViewValidator.validateAgainstStoreTraits(ViewElementDefinition, Set)"})
  void testValidateAgainstStoreTraits_givenIngestAggregation() {
    // Arrange
    ViewValidator viewValidator = new ViewValidator();
    ViewElementDefinition viewElDef = new ViewElementDefinition();

    HashSet<StoreTrait> storeTraits = new HashSet<>();
    storeTraits.add(StoreTrait.INGEST_AGGREGATION);

    // Act
    ValidationResult actualValidateAgainstStoreTraitsResult = viewValidator.validateAgainstStoreTraits(viewElDef,
        storeTraits);

    // Assert
    assertEquals("Validation errors: \n", actualValidateAgainstStoreTraitsResult.getErrorString());
    assertTrue(actualValidateAgainstStoreTraitsResult.getErrors().isEmpty());
    assertTrue(actualValidateAgainstStoreTraitsResult.isValid());
  }

  /**
   * Test {@link ViewValidator#validateAgainstStoreTraits(ViewElementDefinition, Set)}.
   * <ul>
   *   <li>Given {@code PRE_AGGREGATION_FILTERING}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ViewValidator#validateAgainstStoreTraits(ViewElementDefinition, Set)}
   */
  @Test
  @DisplayName("Test validateAgainstStoreTraits(ViewElementDefinition, Set); given 'PRE_AGGREGATION_FILTERING'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ValidationResult ViewValidator.validateAgainstStoreTraits(ViewElementDefinition, Set)"})
  void testValidateAgainstStoreTraits_givenPreAggregationFiltering() {
    // Arrange
    ViewValidator viewValidator = new ViewValidator();
    ViewElementDefinition viewElDef = new ViewElementDefinition();

    HashSet<StoreTrait> storeTraits = new HashSet<>();
    storeTraits.add(StoreTrait.PRE_AGGREGATION_FILTERING);

    // Act
    ValidationResult actualValidateAgainstStoreTraitsResult = viewValidator.validateAgainstStoreTraits(viewElDef,
        storeTraits);

    // Assert
    assertEquals("Validation errors: \n", actualValidateAgainstStoreTraitsResult.getErrorString());
    assertTrue(actualValidateAgainstStoreTraitsResult.getErrors().isEmpty());
    assertTrue(actualValidateAgainstStoreTraitsResult.isValid());
  }

  /**
   * Test {@link ViewValidator#validateAgainstStoreTraits(ViewElementDefinition, Set)}.
   * <ul>
   *   <li>Given {@code QUERY_AGGREGATION}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ViewValidator#validateAgainstStoreTraits(ViewElementDefinition, Set)}
   */
  @Test
  @DisplayName("Test validateAgainstStoreTraits(ViewElementDefinition, Set); given 'QUERY_AGGREGATION'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ValidationResult ViewValidator.validateAgainstStoreTraits(ViewElementDefinition, Set)"})
  void testValidateAgainstStoreTraits_givenQueryAggregation() {
    // Arrange
    ViewValidator viewValidator = new ViewValidator();
    ViewElementDefinition viewElDef = new ViewElementDefinition();

    HashSet<StoreTrait> storeTraits = new HashSet<>();
    storeTraits.add(StoreTrait.QUERY_AGGREGATION);
    storeTraits.add(StoreTrait.INGEST_AGGREGATION);

    // Act
    ValidationResult actualValidateAgainstStoreTraitsResult = viewValidator.validateAgainstStoreTraits(viewElDef,
        storeTraits);

    // Assert
    assertEquals("Validation errors: \n", actualValidateAgainstStoreTraitsResult.getErrorString());
    assertTrue(actualValidateAgainstStoreTraitsResult.getErrors().isEmpty());
    assertTrue(actualValidateAgainstStoreTraitsResult.isValid());
  }

  /**
   * Test {@link ViewValidator#validateAgainstStoreTraits(ViewElementDefinition, Set)}.
   * <ul>
   *   <li>When {@link HashSet#HashSet()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ViewValidator#validateAgainstStoreTraits(ViewElementDefinition, Set)}
   */
  @Test
  @DisplayName("Test validateAgainstStoreTraits(ViewElementDefinition, Set); when HashSet()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ValidationResult ViewValidator.validateAgainstStoreTraits(ViewElementDefinition, Set)"})
  void testValidateAgainstStoreTraits_whenHashSet() {
    // Arrange
    ViewValidator viewValidator = new ViewValidator();
    ViewElementDefinition viewElDef = new ViewElementDefinition();

    // Act
    ValidationResult actualValidateAgainstStoreTraitsResult = viewValidator.validateAgainstStoreTraits(viewElDef,
        new HashSet<>());

    // Assert
    assertEquals("Validation errors: \n", actualValidateAgainstStoreTraitsResult.getErrorString());
    assertTrue(actualValidateAgainstStoreTraitsResult.getErrors().isEmpty());
    assertTrue(actualValidateAgainstStoreTraitsResult.isValid());
  }

  /**
   * Test {@link ViewValidator#validateGroupBy(boolean, String, ViewElementDefinition, SchemaElementDefinition)}.
   * <ul>
   *   <li>Given {@link LinkedHashSet#LinkedHashSet()} add {@code foo}.</li>
   *   <li>Then return ErrorString is a string.</li>
   * </ul>
   * <p>
   * Method under test: {@link ViewValidator#validateGroupBy(boolean, String, ViewElementDefinition, SchemaElementDefinition)}
   */
  @Test
  @DisplayName("Test validateGroupBy(boolean, String, ViewElementDefinition, SchemaElementDefinition); given LinkedHashSet() add 'foo'; then return ErrorString is a string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "ValidationResult ViewValidator.validateGroupBy(boolean, String, ViewElementDefinition, SchemaElementDefinition)"})
  void testValidateGroupBy_givenLinkedHashSetAddFoo_thenReturnErrorStringIsAString() {
    // Arrange
    ViewValidator viewValidator = new ViewValidator();

    LinkedHashSet<String> groupBy = new LinkedHashSet<>();
    groupBy.add("foo");

    ViewElementDefinition viewElDef = new ViewElementDefinition();
    viewElDef.setGroupBy(groupBy);

    // Act
    ValidationResult actualValidateGroupByResult = viewValidator.validateGroupBy(true, "Group", viewElDef,
        new SchemaEdgeDefinition());

    // Assert
    assertEquals("Validation errors: \n"
        + "Group by properties for group Group in the view are not all included in the group by field in the"
        + " schema. View groupBy:[foo]. Schema groupBy:[]", actualValidateGroupByResult.getErrorString());
    Set<String> errors = actualValidateGroupByResult.getErrors();
    assertEquals(1, errors.size());
    assertFalse(actualValidateGroupByResult.isValid());
    assertTrue(errors
        .contains("Group by properties for group Group in the view are not all included in the group by field in the"
            + " schema. View groupBy:[foo]. Schema groupBy:[]"));
  }

  /**
   * Test {@link ViewValidator#validateGroupBy(boolean, String, ViewElementDefinition, SchemaElementDefinition)}.
   * <ul>
   *   <li>Given {@link LinkedHashSet#LinkedHashSet()}.</li>
   *   <li>Then return ErrorString is {@code Validation errors:}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ViewValidator#validateGroupBy(boolean, String, ViewElementDefinition, SchemaElementDefinition)}
   */
  @Test
  @DisplayName("Test validateGroupBy(boolean, String, ViewElementDefinition, SchemaElementDefinition); given LinkedHashSet(); then return ErrorString is 'Validation errors:'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "ValidationResult ViewValidator.validateGroupBy(boolean, String, ViewElementDefinition, SchemaElementDefinition)"})
  void testValidateGroupBy_givenLinkedHashSet_thenReturnErrorStringIsValidationErrors() {
    // Arrange
    ViewValidator viewValidator = new ViewValidator();

    ViewElementDefinition viewElDef = new ViewElementDefinition();
    viewElDef.setGroupBy(new LinkedHashSet<>());

    // Act
    ValidationResult actualValidateGroupByResult = viewValidator.validateGroupBy(true, "Group", viewElDef,
        new SchemaEdgeDefinition());

    // Assert
    assertEquals("Validation errors: \n", actualValidateGroupByResult.getErrorString());
    assertTrue(actualValidateGroupByResult.getErrors().isEmpty());
    assertTrue(actualValidateGroupByResult.isValid());
  }

  /**
   * Test {@link ViewValidator#validateGroupBy(boolean, String, ViewElementDefinition, SchemaElementDefinition)}.
   * <ul>
   *   <li>When {@link ViewElementDefinition} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link ViewValidator#validateGroupBy(boolean, String, ViewElementDefinition, SchemaElementDefinition)}
   */
  @Test
  @DisplayName("Test validateGroupBy(boolean, String, ViewElementDefinition, SchemaElementDefinition); when ViewElementDefinition (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "ValidationResult ViewValidator.validateGroupBy(boolean, String, ViewElementDefinition, SchemaElementDefinition)"})
  void testValidateGroupBy_whenViewElementDefinition() {
    // Arrange
    ViewValidator viewValidator = new ViewValidator();
    ViewElementDefinition viewElDef = new ViewElementDefinition();

    // Act
    ValidationResult actualValidateGroupByResult = viewValidator.validateGroupBy(true, "Group", viewElDef,
        new SchemaEdgeDefinition());

    // Assert
    assertEquals("Validation errors: \n", actualValidateGroupByResult.getErrorString());
    assertTrue(actualValidateGroupByResult.getErrors().isEmpty());
    assertTrue(actualValidateGroupByResult.isValid());
  }
}
