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

package uk.gov.gchq.gaffer.store.operation.validator.function;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashMap;
import java.util.Set;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.data.element.function.ElementFilter;
import uk.gov.gchq.gaffer.data.element.function.ElementFilter.Builder;
import uk.gov.gchq.gaffer.operation.impl.function.Filter;
import uk.gov.gchq.gaffer.store.schema.Schema;
import uk.gov.gchq.koryphe.ValidationResult;

class FilterValidatorDiffblueTest {
  /**
   * Test {@link FilterValidator#validateOperation(Filter, Schema)} with {@code Filter}, {@code
   * Schema}.
   *
   * <p>Method under test: {@link FilterValidator#validateOperation(Filter, Schema)}
   */
  @Test
  @DisplayName("Test validateOperation(Filter, Schema) with 'Filter', 'Schema'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ValidationResult FilterValidator.validateOperation(Filter, Schema)"})
  void testValidateOperationWithFilterSchema() {
    // Arrange
    FilterValidator filterValidator = new FilterValidator();

    HashMap<String, ElementFilter> edges = new HashMap<>();
    edges.put("foo", new Builder().build());

    Filter operation = new Filter();
    operation.setEdges(edges);

    // Act
    ValidationResult actualValidateOperationResult =
        filterValidator.validateOperation(operation, new Schema());

    // Assert
    assertEquals(
        "Validation errors: \nEdge group: foo does not exist in the schema.",
        actualValidateOperationResult.getErrorString());
    Set<String> errors = actualValidateOperationResult.getErrors();
    assertEquals(1, errors.size());
    assertFalse(actualValidateOperationResult.isValid());
    assertTrue(errors.contains("Edge group: foo does not exist in the schema."));
  }

  /**
   * Test {@link FilterValidator#validateOperation(Filter, Schema)} with {@code Filter}, {@code
   * Schema}.
   *
   * <p>Method under test: {@link FilterValidator#validateOperation(Filter, Schema)}
   */
  @Test
  @DisplayName("Test validateOperation(Filter, Schema) with 'Filter', 'Schema'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ValidationResult FilterValidator.validateOperation(Filter, Schema)"})
  void testValidateOperationWithFilterSchema2() {
    // Arrange
    FilterValidator filterValidator = new FilterValidator();

    HashMap<String, ElementFilter> entities = new HashMap<>();
    entities.put("foo", new Builder().build());

    Filter operation = new Filter();
    operation.setEntities(entities);

    // Act
    ValidationResult actualValidateOperationResult =
        filterValidator.validateOperation(operation, new Schema());

    // Assert
    assertEquals(
        "Validation errors: \nEntity group: foo does not exist in the schema.",
        actualValidateOperationResult.getErrorString());
    Set<String> errors = actualValidateOperationResult.getErrors();
    assertEquals(1, errors.size());
    assertFalse(actualValidateOperationResult.isValid());
    assertTrue(errors.contains("Entity group: foo does not exist in the schema."));
  }

  /**
   * Test {@link FilterValidator#validateOperation(Filter, Schema)} with {@code Filter}, {@code
   * Schema}.
   *
   * <ul>
   *   <li>Given {@link HashMap#HashMap()}.
   *   <li>When {@link Filter} (default constructor) Edges is {@link HashMap#HashMap()}.
   * </ul>
   *
   * <p>Method under test: {@link FilterValidator#validateOperation(Filter, Schema)}
   */
  @Test
  @DisplayName(
      "Test validateOperation(Filter, Schema) with 'Filter', 'Schema'; given HashMap(); when Filter (default constructor) Edges is HashMap()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ValidationResult FilterValidator.validateOperation(Filter, Schema)"})
  void testValidateOperationWithFilterSchema_givenHashMap_whenFilterEdgesIsHashMap() {
    // Arrange
    FilterValidator filterValidator = new FilterValidator();

    Filter operation = new Filter();
    operation.setEdges(new HashMap<>());

    // Act
    ValidationResult actualValidateOperationResult =
        filterValidator.validateOperation(operation, new Schema());

    // Assert
    assertEquals("Validation errors: \n", actualValidateOperationResult.getErrorString());
    assertTrue(actualValidateOperationResult.getErrors().isEmpty());
    assertTrue(actualValidateOperationResult.isValid());
  }

  /**
   * Test {@link FilterValidator#validateOperation(Filter, Schema)} with {@code Filter}, {@code
   * Schema}.
   *
   * <ul>
   *   <li>Given {@link HashMap#HashMap()}.
   *   <li>When {@link Filter} (default constructor) Entities is {@link HashMap#HashMap()}.
   * </ul>
   *
   * <p>Method under test: {@link FilterValidator#validateOperation(Filter, Schema)}
   */
  @Test
  @DisplayName(
      "Test validateOperation(Filter, Schema) with 'Filter', 'Schema'; given HashMap(); when Filter (default constructor) Entities is HashMap()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ValidationResult FilterValidator.validateOperation(Filter, Schema)"})
  void testValidateOperationWithFilterSchema_givenHashMap_whenFilterEntitiesIsHashMap() {
    // Arrange
    FilterValidator filterValidator = new FilterValidator();

    Filter operation = new Filter();
    operation.setEntities(new HashMap<>());

    // Act
    ValidationResult actualValidateOperationResult =
        filterValidator.validateOperation(operation, new Schema());

    // Assert
    assertEquals("Validation errors: \n", actualValidateOperationResult.getErrorString());
    assertTrue(actualValidateOperationResult.getErrors().isEmpty());
    assertTrue(actualValidateOperationResult.isValid());
  }

  /**
   * Test {@link FilterValidator#validateOperation(Filter, Schema)} with {@code Filter}, {@code
   * Schema}.
   *
   * <ul>
   *   <li>When {@link Filter} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link FilterValidator#validateOperation(Filter, Schema)}
   */
  @Test
  @DisplayName(
      "Test validateOperation(Filter, Schema) with 'Filter', 'Schema'; when Filter (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ValidationResult FilterValidator.validateOperation(Filter, Schema)"})
  void testValidateOperationWithFilterSchema_whenFilter() {
    // Arrange
    FilterValidator filterValidator = new FilterValidator();
    Filter operation = new Filter();

    // Act
    ValidationResult actualValidateOperationResult =
        filterValidator.validateOperation(operation, new Schema());

    // Assert
    assertEquals("Validation errors: \n", actualValidateOperationResult.getErrorString());
    assertTrue(actualValidateOperationResult.getErrors().isEmpty());
    assertTrue(actualValidateOperationResult.isValid());
  }

  /**
   * Test {@link FilterValidator#validateOperation(Filter, Schema)} with {@code Filter}, {@code
   * Schema}.
   *
   * <ul>
   *   <li>When {@link Filter} (default constructor) GlobalEdges is {@link ElementFilter} (default
   *       constructor).
   * </ul>
   *
   * <p>Method under test: {@link FilterValidator#validateOperation(Filter, Schema)}
   */
  @Test
  @DisplayName(
      "Test validateOperation(Filter, Schema) with 'Filter', 'Schema'; when Filter (default constructor) GlobalEdges is ElementFilter (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ValidationResult FilterValidator.validateOperation(Filter, Schema)"})
  void testValidateOperationWithFilterSchema_whenFilterGlobalEdgesIsElementFilter() {
    // Arrange
    FilterValidator filterValidator = new FilterValidator();

    Filter operation = new Filter();
    operation.setEntities(null);
    operation.setEdges(null);
    operation.setGlobalElements(null);
    operation.setGlobalEdges(new ElementFilter());
    operation.setGlobalEntities(null);

    // Act
    ValidationResult actualValidateOperationResult =
        filterValidator.validateOperation(operation, new Schema());

    // Assert
    assertEquals("Validation errors: \n", actualValidateOperationResult.getErrorString());
    assertTrue(actualValidateOperationResult.getErrors().isEmpty());
    assertTrue(actualValidateOperationResult.isValid());
  }

  /**
   * Test {@link FilterValidator#validateOperation(Filter, Schema)} with {@code Filter}, {@code
   * Schema}.
   *
   * <ul>
   *   <li>When {@link Filter} (default constructor) GlobalElements is {@link ElementFilter}
   *       (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link FilterValidator#validateOperation(Filter, Schema)}
   */
  @Test
  @DisplayName(
      "Test validateOperation(Filter, Schema) with 'Filter', 'Schema'; when Filter (default constructor) GlobalElements is ElementFilter (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ValidationResult FilterValidator.validateOperation(Filter, Schema)"})
  void testValidateOperationWithFilterSchema_whenFilterGlobalElementsIsElementFilter() {
    // Arrange
    FilterValidator filterValidator = new FilterValidator();

    Filter operation = new Filter();
    operation.setEntities(null);
    operation.setEdges(null);
    operation.setGlobalElements(new ElementFilter());
    operation.setGlobalEdges(null);
    operation.setGlobalEntities(null);

    // Act
    ValidationResult actualValidateOperationResult =
        filterValidator.validateOperation(operation, new Schema());

    // Assert
    assertEquals("Validation errors: \n", actualValidateOperationResult.getErrorString());
    assertTrue(actualValidateOperationResult.getErrors().isEmpty());
    assertTrue(actualValidateOperationResult.isValid());
  }

  /**
   * Test {@link FilterValidator#validateOperation(Filter, Schema)} with {@code Filter}, {@code
   * Schema}.
   *
   * <ul>
   *   <li>When {@link Filter} (default constructor) GlobalEntities is {@link ElementFilter}
   *       (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link FilterValidator#validateOperation(Filter, Schema)}
   */
  @Test
  @DisplayName(
      "Test validateOperation(Filter, Schema) with 'Filter', 'Schema'; when Filter (default constructor) GlobalEntities is ElementFilter (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ValidationResult FilterValidator.validateOperation(Filter, Schema)"})
  void testValidateOperationWithFilterSchema_whenFilterGlobalEntitiesIsElementFilter() {
    // Arrange
    FilterValidator filterValidator = new FilterValidator();

    Filter operation = new Filter();
    operation.setEntities(null);
    operation.setEdges(null);
    operation.setGlobalElements(null);
    operation.setGlobalEdges(null);
    operation.setGlobalEntities(new ElementFilter());

    // Act
    ValidationResult actualValidateOperationResult =
        filterValidator.validateOperation(operation, new Schema());

    // Assert
    assertEquals("Validation errors: \n", actualValidateOperationResult.getErrorString());
    assertTrue(actualValidateOperationResult.getErrors().isEmpty());
    assertTrue(actualValidateOperationResult.isValid());
  }
}
