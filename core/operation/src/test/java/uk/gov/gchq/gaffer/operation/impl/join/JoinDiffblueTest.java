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

package uk.gov.gchq.gaffer.operation.impl.join;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.operation.Operation;
import uk.gov.gchq.gaffer.operation.impl.join.match.Match;
import uk.gov.gchq.gaffer.operation.impl.join.match.MatchKey;
import uk.gov.gchq.gaffer.operation.impl.join.methods.JoinType;

class JoinDiffblueTest {
  /**
   * Method under test: {@link Join.Builder#collectionLimit(Integer)}
   */
  @Test
  void testBuilderCollectionLimit() {
    // Arrange
    Join.Builder<Object> builder = new Join.Builder<>();

    // Act and Assert
    assertSame(builder, builder.collectionLimit(1));
  }

  /**
   * Method under test: {@link Join.Builder#flatten(Boolean)}
   */
  @Test
  void testBuilderFlatten() {
    // Arrange
    Join.Builder<Object> builder = new Join.Builder<>();

    // Act and Assert
    assertSame(builder, builder.flatten(true));
  }

  /**
   * Method under test: {@link Join.Builder#joinType(JoinType)}
   */
  @Test
  void testBuilderJoinType() {
    // Arrange
    Join.Builder<Object> builder = new Join.Builder<>();

    // Act and Assert
    assertSame(builder, builder.joinType(JoinType.FULL));
  }

  /**
   * Method under test: {@link Join.Builder#matchKey(MatchKey)}
   */
  @Test
  void testBuilderMatchKey() {
    // Arrange
    Join.Builder<Object> builder = new Join.Builder<>();

    // Act and Assert
    assertSame(builder, builder.matchKey(MatchKey.LEFT));
  }

  /**
   * Method under test: {@link Join.Builder#matchMethod(Match)}
   */
  @Test
  void testBuilderMatchMethod() {
    // Arrange
    Join.Builder<Object> builder = new Join.Builder<>();

    // Act and Assert
    assertSame(builder, builder.matchMethod(mock(Match.class)));
  }

  /**
   * Method under test: {@link Join#getOperations()}
   */
  @Test
  void testGetOperations() {
    // Arrange
    Join<Object> join = new Join<>();

    // Act
    Collection<Operation> actualOperations = join.getOperations();

    // Assert
    assertTrue(actualOperations instanceof List);
    assertEquals(1, actualOperations.size());
    assertNull(((List<Operation>) actualOperations).get(0));
  }

  /**
   * Method under test: {@link Join#getOperations()}
   */
  @Test
  void testGetOperations2() {
    // Arrange
    HashMap<String, String> options = new HashMap<>();
    options.computeIfPresent("foo", mock(BiFunction.class));

    Join<Object> join = new Join<>();
    join.setOptions(options);

    // Act
    Collection<Operation> actualOperations = join.getOperations();

    // Assert
    assertTrue(actualOperations instanceof List);
    assertEquals(1, actualOperations.size());
    assertNull(((List<Operation>) actualOperations).get(0));
  }

  /**
   * Method under test: {@link Join#createInputArray()}
   */
  @Test
  void testCreateInputArray() {
    // Arrange
    Join<Object> join = new Join<>();

    // Act and Assert
    assertNull(join.createInputArray());
  }

  /**
   * Method under test: {@link Join#createInputArray()}
   */
  @Test
  void testCreateInputArray2() {
    // Arrange
    Join<Object> join = new Join<>();
    join.setInput(new ArrayList<>());

    // Act and Assert
    assertEquals(0, join.createInputArray().length);
  }

  /**
   * Method under test: {@link Join#createInputArray()}
   */
  @Test
  void testCreateInputArray3() {
    // Arrange
    HashMap<String, String> options = new HashMap<>();
    options.computeIfPresent("foo", mock(BiFunction.class));

    Join<Object> join = new Join<>();
    join.setOptions(options);

    // Act and Assert
    assertNull(join.createInputArray());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link Join}
   *   <li>{@link Join#setCollectionLimit(Integer)}
   *   <li>{@link Join#setFlatten(Boolean)}
   *   <li>{@link Join#setInput(Iterable)}
   *   <li>{@link Join#setJoinType(JoinType)}
   *   <li>{@link Join#setMatchKey(MatchKey)}
   *   <li>{@link Join#setMatchMethod(Match)}
   *   <li>{@link Join#setOptions(Map)}
   *   <li>{@link Join#getCollectionLimit()}
   *   <li>{@link Join#getJoinType()}
   *   <li>{@link Join#getMatchKey()}
   *   <li>{@link Join#getMatchMethod()}
   *   <li>{@link Join#getOperation()}
   *   <li>{@link Join#getOptions()}
   *   <li>{@link Join#isFlatten()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    Join<Object> actualJoin = new Join<>();
    actualJoin.setCollectionLimit(1);
    actualJoin.setFlatten(true);
    ArrayList<Object> leftSideInput = new ArrayList<>();
    actualJoin.setInput(leftSideInput);
    actualJoin.setJoinType(JoinType.FULL);
    actualJoin.setMatchKey(MatchKey.LEFT);
    Match matchMethod = mock(Match.class);
    actualJoin.setMatchMethod(matchMethod);
    HashMap<String, String> options = new HashMap<>();
    actualJoin.setOptions(options);
    Integer actualCollectionLimit = actualJoin.getCollectionLimit();
    JoinType actualJoinType = actualJoin.getJoinType();
    MatchKey actualMatchKey = actualJoin.getMatchKey();
    Match actualMatchMethod = actualJoin.getMatchMethod();
    actualJoin.getOperation();
    Map<String, String> actualOptions = actualJoin.getOptions();
    Boolean actualIsFlattenResult = actualJoin.isFlatten();

    // Assert that nothing has changed
    Iterable<?> input = actualJoin.getInput();
    assertTrue(input instanceof List);
    assertEquals(1, actualCollectionLimit.intValue());
    assertEquals(MatchKey.LEFT, actualMatchKey);
    assertEquals(JoinType.FULL, actualJoinType);
    assertTrue(actualOptions.isEmpty());
    assertTrue(actualIsFlattenResult);
    assertSame(leftSideInput, input);
    assertSame(options, actualOptions);
    assertSame(matchMethod, actualMatchMethod);
  }
}
