/*
 * Copyright 2026 Crown Copyright
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

package uk.gov.gchq.gaffer.operation.export.resultcache.handler.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.data.elementdefinition.exception.SchemaException;
import uk.gov.gchq.gaffer.store.schema.Schema;
import uk.gov.gchq.gaffer.store.schema.SchemaEdgeDefinition;
import uk.gov.gchq.gaffer.store.schema.TypeDefinition;

class GafferResultCacheUtilDiffblueTest {
  /**
   * Test {@link GafferResultCacheUtil#createGraph(String, String, Long)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link GafferResultCacheUtil#createGraph(String, String, Long)}
   */
  @Test
  @DisplayName(
      "Test createGraph(String, String, Long); when 'null'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "uk.gov.gchq.gaffer.graph.Graph GafferResultCacheUtil.createGraph(String, String, Long)"
  })
  void testCreateGraph_whenNull_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> GafferResultCacheUtil.createGraph("42", null, 10L));
  }

  /**
   * Test {@link GafferResultCacheUtil#createSchema(Long)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return array length is six hundred forty-five.
   * </ul>
   *
   * <p>Method under test: {@link GafferResultCacheUtil#createSchema(Long)}
   */
  @Test
  @DisplayName(
      "Test createSchema(Long); when 'null'; then return array length is six hundred forty-five")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Schema GafferResultCacheUtil.createSchema(Long)"})
  void testCreateSchema_whenNull_thenReturnArrayLengthIsSixHundredFortyFive()
      throws SchemaException {
    // Arrange and Act
    Schema actualCreateSchemaResult = GafferResultCacheUtil.createSchema(null);

    // Assert
    Map<String, SchemaEdgeDefinition> edges = actualCreateSchemaResult.getEdges();
    assertEquals(1, edges.size());
    assertEquals(645, actualCreateSchemaResult.toCompactJson().length);
    Map<String, TypeDefinition> types = actualCreateSchemaResult.getTypes();
    assertEquals(8, types.size());
    assertTrue(edges.containsKey("result"));
    assertTrue(types.containsKey("exportKey"));
    assertTrue(types.containsKey("jobId"));
    assertTrue(types.containsKey("json"));
    assertTrue(types.containsKey("string"));
    assertTrue(types.containsKey("timestamp"));
    boolean actualContainsKeyResult = types.containsKey(Boolean.TRUE.toString());
    assertTrue(actualContainsKeyResult);
  }

  /**
   * Test {@link GafferResultCacheUtil#createSchema(Long)}.
   *
   * <ul>
   *   <li>When ten.
   *   <li>Then return array length is seven hundred thirty-seven.
   * </ul>
   *
   * <p>Method under test: {@link GafferResultCacheUtil#createSchema(Long)}
   */
  @Test
  @DisplayName(
      "Test createSchema(Long); when ten; then return array length is seven hundred thirty-seven")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Schema GafferResultCacheUtil.createSchema(Long)"})
  void testCreateSchema_whenTen_thenReturnArrayLengthIsSevenHundredThirtySeven()
      throws SchemaException {
    // Arrange and Act
    Schema actualCreateSchemaResult = GafferResultCacheUtil.createSchema(10L);

    // Assert
    Map<String, SchemaEdgeDefinition> edges = actualCreateSchemaResult.getEdges();
    assertEquals(1, edges.size());
    assertEquals(737, actualCreateSchemaResult.toCompactJson().length);
    Map<String, TypeDefinition> types = actualCreateSchemaResult.getTypes();
    assertEquals(8, types.size());
    assertTrue(edges.containsKey("result"));
    assertTrue(types.containsKey("exportKey"));
    assertTrue(types.containsKey("jobId"));
    assertTrue(types.containsKey("json"));
    assertTrue(types.containsKey("string"));
    assertTrue(types.containsKey("timestamp"));
    boolean actualContainsKeyResult = types.containsKey(Boolean.TRUE.toString());
    assertTrue(actualContainsKeyResult);
  }
}
