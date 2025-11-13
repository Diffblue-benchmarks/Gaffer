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
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashMap;
import java.util.Set;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.data.element.function.ElementTransformer;
import uk.gov.gchq.gaffer.data.element.function.ElementTransformer.Builder;
import uk.gov.gchq.gaffer.operation.impl.function.Transform;
import uk.gov.gchq.gaffer.store.schema.Schema;
import uk.gov.gchq.koryphe.ValidationResult;

class TransformValidatorDiffblueTest {
  /**
   * Test {@link TransformValidator#validateOperation(Transform, Schema)} with {@code Transform}, {@code Schema}.
   * <p>
   * Method under test: {@link TransformValidator#validateOperation(Transform, Schema)}
   */
  @Test
  @DisplayName("Test validateOperation(Transform, Schema) with 'Transform', 'Schema'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ValidationResult TransformValidator.validateOperation(Transform, Schema)"})
  void testValidateOperationWithTransformSchema() {
    // Arrange
    TransformValidator transformValidator = new TransformValidator();

    HashMap<String, ElementTransformer> edges = new HashMap<>();
    ElementTransformer buildResult = (new Builder()).build();
    edges.put("foo", buildResult);

    Transform operation = new Transform();
    operation.setEntities(null);
    operation.setEdges(edges);

    // Act
    ValidationResult actualValidateOperationResult = transformValidator.validateOperation(operation, new Schema());

    // Assert
    assertEquals("Validation errors: \nEdge group: foo does not exist in the schema.",
        actualValidateOperationResult.getErrorString());
    Set<String> errors = actualValidateOperationResult.getErrors();
    assertEquals(1, errors.size());
    assertFalse(actualValidateOperationResult.isValid());
    assertTrue(errors.contains("Edge group: foo does not exist in the schema."));
  }

  /**
   * Test {@link TransformValidator#validateOperation(Transform, Schema)} with {@code Transform}, {@code Schema}.
   * <p>
   * Method under test: {@link TransformValidator#validateOperation(Transform, Schema)}
   */
  @Test
  @DisplayName("Test validateOperation(Transform, Schema) with 'Transform', 'Schema'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ValidationResult TransformValidator.validateOperation(Transform, Schema)"})
  void testValidateOperationWithTransformSchema2() {
    // Arrange
    TransformValidator transformValidator = new TransformValidator();

    HashMap<String, ElementTransformer> entities = new HashMap<>();
    ElementTransformer buildResult = (new Builder()).build();
    entities.put("foo", buildResult);

    Transform operation = new Transform();
    operation.setEntities(entities);
    operation.setEdges(null);

    // Act
    ValidationResult actualValidateOperationResult = transformValidator.validateOperation(operation, new Schema());

    // Assert
    assertEquals("Validation errors: \nEntity group: foo does not exist in the schema.",
        actualValidateOperationResult.getErrorString());
    Set<String> errors = actualValidateOperationResult.getErrors();
    assertEquals(1, errors.size());
    assertFalse(actualValidateOperationResult.isValid());
    assertTrue(errors.contains("Entity group: foo does not exist in the schema."));
  }

  /**
   * Test {@link TransformValidator#validateOperation(Transform, Schema)} with {@code Transform}, {@code Schema}.
   * <ul>
   *   <li>Given {@link HashMap#HashMap()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TransformValidator#validateOperation(Transform, Schema)}
   */
  @Test
  @DisplayName("Test validateOperation(Transform, Schema) with 'Transform', 'Schema'; given HashMap()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ValidationResult TransformValidator.validateOperation(Transform, Schema)"})
  void testValidateOperationWithTransformSchema_givenHashMap() {
    // Arrange
    TransformValidator transformValidator = new TransformValidator();

    Transform operation = new Transform();
    operation.setEntities(null);
    operation.setEdges(new HashMap<>());

    // Act
    ValidationResult actualValidateOperationResult = transformValidator.validateOperation(operation, new Schema());

    // Assert
    assertEquals("Validation errors: \n", actualValidateOperationResult.getErrorString());
    assertTrue(actualValidateOperationResult.getErrors().isEmpty());
    assertTrue(actualValidateOperationResult.isValid());
  }

  /**
   * Test {@link TransformValidator#validateOperation(Transform, Schema)} with {@code Transform}, {@code Schema}.
   * <ul>
   *   <li>Given {@link HashMap#HashMap()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TransformValidator#validateOperation(Transform, Schema)}
   */
  @Test
  @DisplayName("Test validateOperation(Transform, Schema) with 'Transform', 'Schema'; given HashMap()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ValidationResult TransformValidator.validateOperation(Transform, Schema)"})
  void testValidateOperationWithTransformSchema_givenHashMap2() {
    // Arrange
    TransformValidator transformValidator = new TransformValidator();

    Transform operation = new Transform();
    operation.setEntities(new HashMap<>());
    operation.setEdges(null);

    // Act
    ValidationResult actualValidateOperationResult = transformValidator.validateOperation(operation, new Schema());

    // Assert
    assertEquals("Validation errors: \n", actualValidateOperationResult.getErrorString());
    assertTrue(actualValidateOperationResult.getErrors().isEmpty());
    assertTrue(actualValidateOperationResult.isValid());
  }

  /**
   * Test {@link TransformValidator#validateOperation(Transform, Schema)} with {@code Transform}, {@code Schema}.
   * <ul>
   *   <li>When {@link Transform} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link TransformValidator#validateOperation(Transform, Schema)}
   */
  @Test
  @DisplayName("Test validateOperation(Transform, Schema) with 'Transform', 'Schema'; when Transform (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ValidationResult TransformValidator.validateOperation(Transform, Schema)"})
  void testValidateOperationWithTransformSchema_whenTransform() {
    // Arrange
    TransformValidator transformValidator = new TransformValidator();
    Transform operation = new Transform();

    // Act
    ValidationResult actualValidateOperationResult = transformValidator.validateOperation(operation, new Schema());

    // Assert
    assertEquals("Validation errors: \n", actualValidateOperationResult.getErrorString());
    assertTrue(actualValidateOperationResult.getErrors().isEmpty());
    assertTrue(actualValidateOperationResult.isValid());
  }
}
