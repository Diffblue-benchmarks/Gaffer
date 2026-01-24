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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.AbstractMap;
import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.data.element.Entity;
import uk.gov.gchq.gaffer.data.graph.Walk;

class ExtractWalkVertexDiffblueTest {
  /**
   * Test {@link ExtractWalkVertex#apply(Walk)} with {@code Walk}.
   *
   * <ul>
   *   <li>Given {@link SimpleEntry#SimpleEntry(Object, Object)} with {@code 42} and {@link
   *       HashSet#HashSet()}.
   *   <li>Then return {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ExtractWalkVertex#apply(Walk)}
   */
  @Test
  @DisplayName(
      "Test apply(Walk) with 'Walk'; given SimpleEntry(Object, Object) with '42' and HashSet(); then return '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object ExtractWalkVertex.apply(Walk)"})
  void testApplyWithWalk_givenSimpleEntryWith42AndHashSet_thenReturn42() {
    // Arrange
    ExtractWalkVertex extractWalkVertex = new ExtractWalkVertex();

    ArrayList<Entry<Object, Set<Entity>>> entities = new ArrayList<>();
    SimpleEntry<Object, Set<Entity>> simpleEntry = new SimpleEntry<>("42", new HashSet<>());
    entities.add(simpleEntry);
    Walk walk = new Walk(new ArrayList<>(), entities);

    // Act
    Object actualApplyResult = extractWalkVertex.apply(walk);

    // Assert
    assertEquals("42", actualApplyResult);
  }

  /**
   * Test {@link ExtractWalkVertex#apply(Walk)} with {@code Walk}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link ExtractWalkVertex#apply(Walk)}
   */
  @Test
  @DisplayName("Test apply(Walk) with 'Walk'; when 'null'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object ExtractWalkVertex.apply(Walk)"})
  void testApplyWithWalk_whenNull_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> new ExtractWalkVertex().apply(null));
  }
}
