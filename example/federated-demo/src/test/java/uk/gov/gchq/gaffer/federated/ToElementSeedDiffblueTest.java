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

package uk.gov.gchq.gaffer.federated;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.apache.accumulo.core.data.Key;
import org.apache.accumulo.core.data.Value;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.accumulostore.data.element.AccumuloEntityValueLoader;
import uk.gov.gchq.gaffer.accumulostore.key.core.impl.byteEntity.ByteEntityAccumuloElementConverter;
import uk.gov.gchq.gaffer.data.element.Edge;
import uk.gov.gchq.gaffer.data.element.Edge.Builder;
import uk.gov.gchq.gaffer.data.element.Element;
import uk.gov.gchq.gaffer.data.element.Entity;
import uk.gov.gchq.gaffer.data.element.LazyEdge;
import uk.gov.gchq.gaffer.data.element.id.EdgeId;
import uk.gov.gchq.gaffer.data.element.id.EdgeId.MatchedVertex;
import uk.gov.gchq.gaffer.data.element.id.ElementId;
import uk.gov.gchq.gaffer.operation.data.EntitySeed;
import uk.gov.gchq.gaffer.store.schema.Schema;

class ToElementSeedDiffblueTest {
  /**
   * Test {@link ToElementSeed#apply(Element)} with {@code Element}.
   *
   * <ul>
   *   <li>Given {@code vertex}.
   *   <li>Then return Vertex is {@code Value}.
   * </ul>
   *
   * <p>Method under test: {@link ToElementSeed#apply(Element)}
   */
  @Test
  @DisplayName("Test apply(Element) with 'Element'; given 'vertex'; then return Vertex is 'Value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ElementId ToElementSeed.apply(Element)"})
  void testApplyWithElement_givenVertex_thenReturnVertexIsValue() {
    // Arrange
    ToElementSeed toElementSeed = new ToElementSeed();
    Edge edge =
        new Builder()
            .dest("Dest")
            .directed(true)
            .group("Group")
            .matchedVertex(MatchedVertex.SOURCE)
            .source("Source")
            .build();
    Key key = new Key();
    Value value = new Value();
    ByteEntityAccumuloElementConverter elementConverter =
        new ByteEntityAccumuloElementConverter(new Schema());

    AccumuloEntityValueLoader valueLoader =
        new AccumuloEntityValueLoader("|Edge", key, value, elementConverter, new Schema());

    LazyEdge element = new LazyEdge(edge, valueLoader);
    element.putProperty("vertex", "Value");

    // Act
    ElementId actualApplyResult = toElementSeed.apply(element);

    // Assert
    assertTrue(actualApplyResult instanceof EntitySeed);
    assertEquals("Value", ((EntitySeed) actualApplyResult).getVertex());
    assertEquals("uk.gov.gchq.gaffer.operation.data.EntitySeed", actualApplyResult.getClassName());
  }

  /**
   * Test {@link ToElementSeed#apply(Element)} with {@code Element}.
   *
   * <ul>
   *   <li>When {@link Entity#Entity(String)} with {@code Group}.
   *   <li>Then return Vertex is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ToElementSeed#apply(Element)}
   */
  @Test
  @DisplayName(
      "Test apply(Element) with 'Element'; when Entity(String) with 'Group'; then return Vertex is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ElementId ToElementSeed.apply(Element)"})
  void testApplyWithElement_whenEntityWithGroup_thenReturnVertexIsNull() {
    // Arrange
    ToElementSeed toElementSeed = new ToElementSeed();

    // Act
    ElementId actualApplyResult = toElementSeed.apply(new Entity("Group"));

    // Assert
    assertTrue(actualApplyResult instanceof EntitySeed);
    assertEquals("uk.gov.gchq.gaffer.operation.data.EntitySeed", actualApplyResult.getClassName());
    assertNull(((EntitySeed) actualApplyResult).getVertex());
  }
}
