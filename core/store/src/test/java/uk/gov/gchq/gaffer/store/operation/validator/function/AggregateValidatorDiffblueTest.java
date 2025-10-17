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
import uk.gov.gchq.gaffer.data.element.function.ElementAggregator;
import uk.gov.gchq.gaffer.data.element.function.ElementAggregator.Builder;
import uk.gov.gchq.gaffer.operation.impl.function.Aggregate;
import uk.gov.gchq.gaffer.operation.util.AggregatePair;
import uk.gov.gchq.gaffer.store.schema.Schema;
import uk.gov.gchq.koryphe.ValidationResult;

class AggregateValidatorDiffblueTest {
  /**
   * Test {@link AggregateValidator#validateOperation(Aggregate, Schema)} with {@code Aggregate},
   * {@code Schema}.
   *
   * <p>Method under test: {@link AggregateValidator#validateOperation(Aggregate, Schema)}
   */
  @Test
  @DisplayName("Test validateOperation(Aggregate, Schema) with 'Aggregate', 'Schema'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ValidationResult AggregateValidator.validateOperation(Aggregate, Schema)"})
  void testValidateOperationWithAggregateSchema() {
    // Arrange
    AggregateValidator aggregateValidator = new AggregateValidator();

    HashMap<String, AggregatePair> edges = new HashMap<>();
    edges.put("foo", new AggregatePair());

    Aggregate operation = new Aggregate();
    operation.setEntities(null);
    operation.setEdges(edges);

    // Act
    ValidationResult actualValidateOperationResult =
        aggregateValidator.validateOperation(operation, new Schema());

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
   * Test {@link AggregateValidator#validateOperation(Aggregate, Schema)} with {@code Aggregate},
   * {@code Schema}.
   *
   * <p>Method under test: {@link AggregateValidator#validateOperation(Aggregate, Schema)}
   */
  @Test
  @DisplayName("Test validateOperation(Aggregate, Schema) with 'Aggregate', 'Schema'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ValidationResult AggregateValidator.validateOperation(Aggregate, Schema)"})
  void testValidateOperationWithAggregateSchema2() {
    // Arrange
    AggregateValidator aggregateValidator = new AggregateValidator();

    HashMap<String, AggregatePair> edges = new HashMap<>();
    ElementAggregator aggregator = new Builder().build();
    edges.put("foo", new AggregatePair(aggregator));

    Aggregate operation = new Aggregate();
    operation.setEntities(null);
    operation.setEdges(edges);

    // Act
    ValidationResult actualValidateOperationResult =
        aggregateValidator.validateOperation(operation, new Schema());

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
   * Test {@link AggregateValidator#validateOperation(Aggregate, Schema)} with {@code Aggregate},
   * {@code Schema}.
   *
   * <p>Method under test: {@link AggregateValidator#validateOperation(Aggregate, Schema)}
   */
  @Test
  @DisplayName("Test validateOperation(Aggregate, Schema) with 'Aggregate', 'Schema'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ValidationResult AggregateValidator.validateOperation(Aggregate, Schema)"})
  void testValidateOperationWithAggregateSchema3() {
    // Arrange
    AggregateValidator aggregateValidator = new AggregateValidator();

    HashMap<String, AggregatePair> entities = new HashMap<>();
    entities.put("foo", new AggregatePair());

    Aggregate operation = new Aggregate();
    operation.setEntities(entities);
    operation.setEdges(null);

    // Act
    ValidationResult actualValidateOperationResult =
        aggregateValidator.validateOperation(operation, new Schema());

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
   * Test {@link AggregateValidator#validateOperation(Aggregate, Schema)} with {@code Aggregate},
   * {@code Schema}.
   *
   * <ul>
   *   <li>Given {@link HashMap#HashMap()}.
   * </ul>
   *
   * <p>Method under test: {@link AggregateValidator#validateOperation(Aggregate, Schema)}
   */
  @Test
  @DisplayName(
      "Test validateOperation(Aggregate, Schema) with 'Aggregate', 'Schema'; given HashMap()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ValidationResult AggregateValidator.validateOperation(Aggregate, Schema)"})
  void testValidateOperationWithAggregateSchema_givenHashMap() {
    // Arrange
    AggregateValidator aggregateValidator = new AggregateValidator();

    Aggregate operation = new Aggregate();
    operation.setEntities(null);
    operation.setEdges(new HashMap<>());

    // Act
    ValidationResult actualValidateOperationResult =
        aggregateValidator.validateOperation(operation, new Schema());

    // Assert
    assertEquals("Validation errors: \n", actualValidateOperationResult.getErrorString());
    assertTrue(actualValidateOperationResult.getErrors().isEmpty());
    assertTrue(actualValidateOperationResult.isValid());
  }

  /**
   * Test {@link AggregateValidator#validateOperation(Aggregate, Schema)} with {@code Aggregate},
   * {@code Schema}.
   *
   * <ul>
   *   <li>Given {@link HashMap#HashMap()}.
   * </ul>
   *
   * <p>Method under test: {@link AggregateValidator#validateOperation(Aggregate, Schema)}
   */
  @Test
  @DisplayName(
      "Test validateOperation(Aggregate, Schema) with 'Aggregate', 'Schema'; given HashMap()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ValidationResult AggregateValidator.validateOperation(Aggregate, Schema)"})
  void testValidateOperationWithAggregateSchema_givenHashMap2() {
    // Arrange
    AggregateValidator aggregateValidator = new AggregateValidator();

    Aggregate operation = new Aggregate();
    operation.setEntities(new HashMap<>());
    operation.setEdges(null);

    // Act
    ValidationResult actualValidateOperationResult =
        aggregateValidator.validateOperation(operation, new Schema());

    // Assert
    assertEquals("Validation errors: \n", actualValidateOperationResult.getErrorString());
    assertTrue(actualValidateOperationResult.getErrors().isEmpty());
    assertTrue(actualValidateOperationResult.isValid());
  }

  /**
   * Test {@link AggregateValidator#validateOperation(Aggregate, Schema)} with {@code Aggregate},
   * {@code Schema}.
   *
   * <ul>
   *   <li>Then return ErrorString is {@code Validation errors:}.
   * </ul>
   *
   * <p>Method under test: {@link AggregateValidator#validateOperation(Aggregate, Schema)}
   */
  @Test
  @DisplayName(
      "Test validateOperation(Aggregate, Schema) with 'Aggregate', 'Schema'; then return ErrorString is 'Validation errors:'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ValidationResult AggregateValidator.validateOperation(Aggregate, Schema)"})
  void testValidateOperationWithAggregateSchema_thenReturnErrorStringIsValidationErrors() {
    // Arrange
    AggregateValidator aggregateValidator = new AggregateValidator();

    Aggregate operation = new Aggregate();
    operation.setEntities(null);
    operation.setEdges(null);

    // Act
    ValidationResult actualValidateOperationResult =
        aggregateValidator.validateOperation(operation, new Schema());

    // Assert
    assertEquals("Validation errors: \n", actualValidateOperationResult.getErrorString());
    assertTrue(actualValidateOperationResult.getErrors().isEmpty());
    assertTrue(actualValidateOperationResult.isValid());
  }

  /**
   * Test {@link AggregateValidator#validateOperation(Aggregate, Schema)} with {@code Aggregate},
   * {@code Schema}.
   *
   * <ul>
   *   <li>When {@link Aggregate} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link AggregateValidator#validateOperation(Aggregate, Schema)}
   */
  @Test
  @DisplayName(
      "Test validateOperation(Aggregate, Schema) with 'Aggregate', 'Schema'; when Aggregate (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ValidationResult AggregateValidator.validateOperation(Aggregate, Schema)"})
  void testValidateOperationWithAggregateSchema_whenAggregate() {
    // Arrange
    AggregateValidator aggregateValidator = new AggregateValidator();
    Aggregate operation = new Aggregate();

    // Act
    ValidationResult actualValidateOperationResult =
        aggregateValidator.validateOperation(operation, new Schema());

    // Assert
    assertEquals("Validation errors: \n", actualValidateOperationResult.getErrorString());
    assertTrue(actualValidateOperationResult.getErrors().isEmpty());
    assertTrue(actualValidateOperationResult.isValid());
  }
}
