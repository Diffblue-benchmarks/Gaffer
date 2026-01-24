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

package uk.gov.gchq.gaffer.data.graph.function.walk;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.data.element.Edge;
import uk.gov.gchq.gaffer.data.element.Entity;
import uk.gov.gchq.gaffer.data.graph.Walk;

class ExtractWalkEntitiesDiffblueTest {
  /**
   * Test {@link ExtractWalkEntities#apply(Walk)} with {@code Walk}.
   *
   * <ul>
   *   <li>Then return {@link List}.
   * </ul>
   *
   * <p>Method under test: {@link ExtractWalkEntities#apply(Walk)}
   */
  @Test
  @DisplayName("Test apply(Walk) with 'Walk'; then return List")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Iterable ExtractWalkEntities.apply(Walk)"})
  void testApplyWithWalk_thenReturnList() {
    // Arrange
    ExtractWalkEntities extractWalkEntities = new ExtractWalkEntities();
    ArrayList<Set<Edge>> edges = new ArrayList<>();
    Walk walk = new Walk(edges, new ArrayList<>());

    // Act
    Iterable<Set<Entity>> actualApplyResult = extractWalkEntities.apply(walk);
    Iterator<Set<Entity>> actualIteratorResult = actualApplyResult.iterator();

    // Assert
    assertTrue(actualApplyResult instanceof List);
    assertFalse(actualIteratorResult.hasNext());
    assertTrue(((List<Set<Entity>>) actualApplyResult).isEmpty());
  }
}
