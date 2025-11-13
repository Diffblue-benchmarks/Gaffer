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

package uk.gov.gchq.gaffer.operation.function;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.data.element.Entity;
import uk.gov.gchq.gaffer.data.element.Entity.Builder;
import uk.gov.gchq.gaffer.data.element.id.ElementId;
import uk.gov.gchq.gaffer.operation.data.EdgeSeed;

class FromElementIdDiffblueTest {
  /**
   * Test {@link FromElementId#apply(ElementId)} with {@code ElementId}.
   * <ul>
   *   <li>When {@link Entity.Builder} (default constructor) group {@code Group} vertex {@code Vertex} build.</li>
   *   <li>Then return {@code Vertex}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FromElementId#apply(ElementId)}
   */
  @Test
  @DisplayName("Test apply(ElementId) with 'ElementId'; when Builder (default constructor) group 'Group' vertex 'Vertex' build; then return 'Vertex'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.Object FromElementId.apply(ElementId)"})
  void testApplyWithElementId_whenBuilderGroupGroupVertexVertexBuild_thenReturnVertex() {
    // Arrange
    FromElementId fromElementId = new FromElementId();
    Entity e = (new Builder()).group("Group").vertex("Vertex").build();

    // Act and Assert
    assertEquals("Vertex", fromElementId.apply(e));
  }

  /**
   * Test {@link FromElementId#apply(ElementId)} with {@code ElementId}.
   * <ul>
   *   <li>When {@link EdgeSeed#EdgeSeed()}.</li>
   *   <li>Then return {@link EdgeSeed#EdgeSeed()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FromElementId#apply(ElementId)}
   */
  @Test
  @DisplayName("Test apply(ElementId) with 'ElementId'; when EdgeSeed(); then return EdgeSeed()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.Object FromElementId.apply(ElementId)"})
  void testApplyWithElementId_whenEdgeSeed_thenReturnEdgeSeed() {
    // Arrange
    FromElementId fromElementId = new FromElementId();
    EdgeSeed e = new EdgeSeed();

    // Act and Assert
    assertSame(e, fromElementId.apply(e));
  }

  /**
   * Test {@link FromElementId#apply(ElementId)} with {@code ElementId}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FromElementId#apply(ElementId)}
   */
  @Test
  @DisplayName("Test apply(ElementId) with 'ElementId'; when 'null'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.Object FromElementId.apply(ElementId)"})
  void testApplyWithElementId_whenNull_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new FromElementId()).apply(null));
  }
}
