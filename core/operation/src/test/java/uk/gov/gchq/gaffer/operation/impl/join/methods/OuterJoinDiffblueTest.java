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

package uk.gov.gchq.gaffer.operation.impl.join.methods;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.koryphe.tuple.MapTuple;

class OuterJoinDiffblueTest {
  /**
   * Method under test:
   * {@link OuterJoin#joinFlattened(Object, List, String, String)}
   */
  @Test
  void testJoinFlattened() {
    // Arrange
    OuterJoin outerJoin = new OuterJoin();

    // Act
    List<MapTuple> actualJoinFlattenedResult = outerJoin.joinFlattened("Key", new ArrayList<>(), "Key Name", "42");

    // Assert
    assertEquals(1, actualJoinFlattenedResult.size());
    MapTuple getResult = actualJoinFlattenedResult.get(0);
    Iterable<Object> valuesResult = getResult.values();
    assertTrue(valuesResult instanceof Collection);
    Iterator<Object> iteratorResult = getResult.iterator();
    assertEquals("Key", iteratorResult.next());
    Map values = getResult.getValues();
    assertEquals(2, values.size());
    assertEquals("Key", values.get("Key Name"));
    assertNull(iteratorResult.next());
    assertNull(values.get("42"));
    assertEquals(2, ((Collection<Object>) valuesResult).size());
    assertFalse(iteratorResult.hasNext());
  }

  /**
   * Method under test:
   * {@link OuterJoin#joinFlattened(Object, List, String, String)}
   */
  @Test
  void testJoinFlattened2() {
    // Arrange
    OuterJoin outerJoin = new OuterJoin();

    ArrayList<Object> matches = new ArrayList<>();
    matches.add("42");

    // Act and Assert
    assertTrue(outerJoin.joinFlattened("Key", matches, "Key Name", "42").isEmpty());
  }

  /**
   * Method under test:
   * {@link OuterJoin#joinFlattened(Object, List, String, String)}
   */
  @Test
  void testJoinFlattened3() {
    // Arrange
    OuterJoin outerJoin = new OuterJoin();

    ArrayList<Object> matches = new ArrayList<>();
    matches.add("42");
    matches.add("42");

    // Act and Assert
    assertTrue(outerJoin.joinFlattened("Key", matches, "Key Name", "42").isEmpty());
  }

  /**
   * Method under test:
   * {@link OuterJoin#joinAggregated(Object, List, String, String)}
   */
  @Test
  void testJoinAggregated() {
    // Arrange
    OuterJoin outerJoin = new OuterJoin();

    ArrayList<Object> matches = new ArrayList<>();
    matches.add("42");

    // Act and Assert
    assertNull(outerJoin.joinAggregated("Key", matches, "Key Name", "42"));
  }

  /**
   * Method under test:
   * {@link OuterJoin#joinAggregated(Object, List, String, String)}
   */
  @Test
  void testJoinAggregated2() {
    // Arrange
    OuterJoin outerJoin = new OuterJoin();

    ArrayList<Object> matches = new ArrayList<>();
    matches.add("42");
    matches.add("42");

    // Act and Assert
    assertNull(outerJoin.joinAggregated("Key", matches, "Key Name", "42"));
  }
}
