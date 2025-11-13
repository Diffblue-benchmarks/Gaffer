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

package uk.gov.gchq.gaffer.federatedstore.util;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashMap;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.core.exception.GafferCheckedException;
import uk.gov.gchq.gaffer.store.schema.Schema;

class MergeSchemaDiffblueTest {
  /**
   * Test {@link MergeSchema#MergeSchema()}.
   * <p>
   * Method under test: {@link MergeSchema#MergeSchema()}
   */
  @Test
  @DisplayName("Test new MergeSchema()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void MergeSchema.<init>()"})
  void testNewMergeSchema() {
    // Arrange, Act and Assert
    assertTrue((new MergeSchema()).getRequiredContextValues().isEmpty());
  }

  /**
   * Test {@link MergeSchema#MergeSchema(HashMap)}.
   * <p>
   * Method under test: {@link MergeSchema#MergeSchema(HashMap)}
   */
  @Test
  @DisplayName("Test new MergeSchema(HashMap)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void MergeSchema.<init>(HashMap)"})
  void testNewMergeSchema2() {
    // Arrange, Act and Assert
    assertTrue((new MergeSchema(new HashMap<>())).getRequiredContextValues().isEmpty());
  }

  /**
   * Test {@link MergeSchema#apply(Schema, Schema)} with {@code Schema}, {@code Schema}.
   * <ul>
   *   <li>Given {@link MergeSchema#MergeSchema()}.</li>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@link Schema#Schema()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MergeSchema#apply(Schema, Schema)}
   */
  @Test
  @DisplayName("Test apply(Schema, Schema) with 'Schema', 'Schema'; given MergeSchema(); when 'null'; then return Schema()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Schema MergeSchema.apply(Schema, Schema)"})
  void testApplyWithSchemaSchema_givenMergeSchema_whenNull_thenReturnSchema() {
    // Arrange
    MergeSchema mergeSchema = new MergeSchema();
    Schema update = new Schema();

    // Act and Assert
    assertSame(update, mergeSchema.apply(update, null));
  }

  /**
   * Test {@link MergeSchema#createFunctionWithContext(HashMap)}.
   * <p>
   * Method under test: {@link MergeSchema#createFunctionWithContext(HashMap)}
   */
  @Test
  @DisplayName("Test createFunctionWithContext(HashMap)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ContextSpecificMergeFunction MergeSchema.createFunctionWithContext(HashMap)"})
  void testCreateFunctionWithContext() throws GafferCheckedException {
    // Arrange
    MergeSchema mergeSchema = new MergeSchema();

    // Act
    ContextSpecificMergeFunction<Schema, Schema, Schema> actualCreateFunctionWithContextResult = mergeSchema
        .createFunctionWithContext(new HashMap<>());

    // Assert
    assertTrue(actualCreateFunctionWithContextResult instanceof MergeSchema);
    assertTrue(actualCreateFunctionWithContextResult.getRequiredContextValues().isEmpty());
  }

  /**
   * Test {@link MergeSchema#getRequiredContextValues()}.
   * <p>
   * Method under test: {@link MergeSchema#getRequiredContextValues()}
   */
  @Test
  @DisplayName("Test getRequiredContextValues()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.util.Set MergeSchema.getRequiredContextValues()"})
  void testGetRequiredContextValues() {
    // Arrange, Act and Assert
    assertTrue((new MergeSchema()).getRequiredContextValues().isEmpty());
  }
}
