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
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import uk.gov.gchq.gaffer.operation.impl.join.match.Match;
import uk.gov.gchq.gaffer.operation.impl.join.match.MatchKey;
import uk.gov.gchq.koryphe.tuple.MapTuple;

class JoinFunctionDiffblueTest {
  /**
   * Method under test:
   * {@link JoinFunction#join(Iterable, Iterable, Match, MatchKey, Boolean)}
   */
  @Test
  void testJoin() {
    // Arrange
    FullJoin fullJoin = new FullJoin();
    ArrayList<Object> left = new ArrayList<>();
    ArrayList<Object> right = new ArrayList<>();
    Match match = mock(Match.class);
    doNothing().when(match).init(Mockito.<Iterable<Object>>any());

    // Act
    List<MapTuple> actualJoinResult = fullJoin.join(left, right, match, MatchKey.LEFT, true);

    // Assert
    verify(match).init(isA(Iterable.class));
    assertTrue(actualJoinResult.isEmpty());
  }

  /**
   * Method under test:
   * {@link JoinFunction#join(Iterable, Iterable, Match, MatchKey, Boolean)}
   */
  @Test
  void testJoin2() {
    // Arrange
    FullJoin fullJoin = new FullJoin();

    ArrayList<Object> left = new ArrayList<>();
    left.add("42");
    ArrayList<Object> right = new ArrayList<>();
    Match match = mock(Match.class);
    when(match.matching(Mockito.<Object>any())).thenReturn(new ArrayList<>());
    doNothing().when(match).init(Mockito.<Iterable<Object>>any());

    // Act
    List<MapTuple> actualJoinResult = fullJoin.join(left, right, match, MatchKey.LEFT, true);

    // Assert
    verify(match).init(isA(Iterable.class));
    verify(match).matching(isA(Object.class));
    assertEquals(1, actualJoinResult.size());
    MapTuple getResult = actualJoinResult.get(0);
    Iterable<Object> valuesResult = getResult.values();
    assertTrue(valuesResult instanceof Collection);
    Iterator<Object> iteratorResult = getResult.iterator();
    assertEquals("42", iteratorResult.next());
    Map values = getResult.getValues();
    assertEquals(2, values.size());
    assertEquals("42", values.get("LEFT"));
    assertNull(iteratorResult.next());
    assertNull(values.get("RIGHT"));
    assertEquals(2, ((Collection<Object>) valuesResult).size());
    assertFalse(iteratorResult.hasNext());
  }

  /**
   * Method under test:
   * {@link JoinFunction#join(Iterable, Iterable, Match, MatchKey, Boolean)}
   */
  @Test
  void testJoin3() {
    // Arrange
    FullJoin fullJoin = new FullJoin();

    ArrayList<Object> left = new ArrayList<>();
    left.add("42");
    ArrayList<Object> right = new ArrayList<>();
    Match match = mock(Match.class);
    doNothing().when(match).init(Mockito.<Iterable<Object>>any());

    // Act
    List<MapTuple> actualJoinResult = fullJoin.join(left, right, match, MatchKey.RIGHT, true);

    // Assert
    verify(match).init(isA(Iterable.class));
    assertTrue(actualJoinResult.isEmpty());
  }
}
