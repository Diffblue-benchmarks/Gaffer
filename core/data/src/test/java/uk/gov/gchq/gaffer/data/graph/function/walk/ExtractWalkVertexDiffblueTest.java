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

package uk.gov.gchq.gaffer.data.graph.function.walk;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.data.element.Entity;
import uk.gov.gchq.gaffer.data.graph.Walk;

class ExtractWalkVertexDiffblueTest {
  /**
   * Method under test: {@link ExtractWalkVertex#apply(Walk)}
   */
  @Test
  void testApply() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> (new ExtractWalkVertex()).apply(null));
  }

  /**
   * Method under test: {@link ExtractWalkVertex#apply(Walk)}
   */
  @Test
  void testApply2() {
    // Arrange
    ExtractWalkVertex extractWalkVertex = new ExtractWalkVertex();

    ArrayList<Map.Entry<Object, Set<Entity>>> entities = new ArrayList<>();
    entities.add(new AbstractMap.SimpleEntry<>("42", new HashSet<>()));

    // Act and Assert
    assertEquals("42", extractWalkVertex.apply(new Walk(new ArrayList<>(), entities)));
  }
}
