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

package uk.gov.gchq.gaffer.operation.impl.join;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.named.operation.AddNamedOperation;
import uk.gov.gchq.gaffer.operation.Operation;
import uk.gov.gchq.gaffer.operation.impl.JoinTest;
import uk.gov.gchq.gaffer.operation.impl.JoinTest.TestMatchImpl;
import uk.gov.gchq.gaffer.operation.impl.join.Join.Builder;
import uk.gov.gchq.gaffer.operation.impl.join.match.Match;
import uk.gov.gchq.gaffer.operation.impl.join.match.MatchKey;
import uk.gov.gchq.gaffer.operation.impl.join.methods.JoinType;

class JoinDiffblueTest {
  /**
   * Test Builder {@link Builder#collectionLimit(Integer)}.
   *
   * <p>Method under test: {@link Builder#collectionLimit(Integer)}
   */
  @Test
  @DisplayName("Test Builder collectionLimit(Integer)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.collectionLimit(Integer)"})
  void testBuilderCollectionLimit() {
    // Arrange
    Builder<Object> builder = new Builder<>();

    // Act
    Builder<Object> actualCollectionLimitResult = builder.collectionLimit(1);

    // Assert
    assertSame(builder, actualCollectionLimitResult);
  }

  /**
   * Test Builder {@link Builder#flatten(Boolean)}.
   *
   * <p>Method under test: {@link Builder#flatten(Boolean)}
   */
  @Test
  @DisplayName("Test Builder flatten(Boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.flatten(Boolean)"})
  void testBuilderFlatten() {
    // Arrange
    Builder<Object> builder = new Builder<>();

    // Act
    Builder<Object> actualFlattenResult = builder.flatten(true);

    // Assert
    assertSame(builder, actualFlattenResult);
  }

  /**
   * Test Builder {@link Builder#joinType(JoinType)}.
   *
   * <p>Method under test: {@link Builder#joinType(JoinType)}
   */
  @Test
  @DisplayName("Test Builder joinType(JoinType)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.joinType(JoinType)"})
  void testBuilderJoinType() {
    // Arrange
    Builder<Object> builder = new Builder<>();

    // Act
    Builder<Object> actualJoinTypeResult = builder.joinType(JoinType.FULL);

    // Assert
    assertSame(builder, actualJoinTypeResult);
  }

  /**
   * Test Builder {@link Builder#matchKey(MatchKey)}.
   *
   * <p>Method under test: {@link Builder#matchKey(MatchKey)}
   */
  @Test
  @DisplayName("Test Builder matchKey(MatchKey)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.matchKey(MatchKey)"})
  void testBuilderMatchKey() {
    // Arrange
    Builder<Object> builder = new Builder<>();

    // Act
    Builder<Object> actualMatchKeyResult = builder.matchKey(MatchKey.LEFT);

    // Assert
    assertSame(builder, actualMatchKeyResult);
  }

  /**
   * Test Builder {@link Builder#matchMethod(Match)}.
   *
   * <p>Method under test: {@link Builder#matchMethod(Match)}
   */
  @Test
  @DisplayName("Test Builder matchMethod(Match)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.matchMethod(Match)"})
  void testBuilderMatchMethod() {
    // Arrange
    Builder<Object> builder = new Builder<>();

    // Act
    Builder<Object> actualMatchMethodResult = builder.matchMethod(new TestMatchImpl());

    // Assert
    assertSame(builder, actualMatchMethodResult);
  }

  /**
   * Test Builder {@link Builder#operation(Operation)}.
   *
   * <p>Method under test: {@link Builder#operation(Operation)}
   */
  @Test
  @DisplayName("Test Builder operation(Operation)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.operation(Operation)"})
  void testBuilderOperation() {
    // Arrange
    Builder<Object> builder = new Builder<>();

    // Act
    Builder<Object> actualOperationResult = builder.operation(new AddNamedOperation());

    // Assert
    assertSame(builder, actualOperationResult);
  }

  /**
   * Test {@link Join#getInput()}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link Join#getInput()}
   */
  @Test
  @DisplayName("Test getInput(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Iterable Join.getInput()"})
  void testGetInput_thenReturnNull() {
    // Arrange
    Join<Object> join = new Join<>();

    // Act and Assert
    assertNull(join.getInput());
  }

  /**
   * Test {@link Join#getOperations()}.
   *
   * <p>Method under test: {@link Join#getOperations()}
   */
  @Test
  @DisplayName("Test getOperations()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Collection Join.getOperations()"})
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
   * Test {@link Join#createInputArray()}.
   *
   * <ul>
   *   <li>Given {@link Join} (default constructor) Input is {@link ArrayList#ArrayList()}.
   *   <li>Then return array length is zero.
   * </ul>
   *
   * <p>Method under test: {@link Join#createInputArray()}
   */
  @Test
  @DisplayName(
      "Test createInputArray(); given Join (default constructor) Input is ArrayList(); then return array length is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object[] Join.createInputArray()"})
  void testCreateInputArray_givenJoinInputIsArrayList_thenReturnArrayLengthIsZero() {
    // Arrange
    Join<Object> join = new Join<>();
    join.setInput(new ArrayList<>());

    // Act and Assert
    assertEquals(0, join.createInputArray().length);
  }

  /**
   * Test {@link Join#createInputArray()}.
   *
   * <ul>
   *   <li>Given {@link Join} (default constructor).
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link Join#createInputArray()}
   */
  @Test
  @DisplayName("Test createInputArray(); given Join (default constructor); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object[] Join.createInputArray()"})
  void testCreateInputArray_givenJoin_thenReturnNull() {
    // Arrange
    Join<Object> join = new Join<>();

    // Act and Assert
    assertNull(join.createInputArray());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link Join}
   *   <li>{@link Join#setCollectionLimit(Integer)}
   *   <li>{@link Join#setFlatten(Boolean)}
   *   <li>{@link Join#setInput(Iterable)}
   *   <li>{@link Join#setJoinType(JoinType)}
   *   <li>{@link Join#setMatchKey(MatchKey)}
   *   <li>{@link Join#setMatchMethod(Match)}
   *   <li>{@link Join#setOperation(Operation)}
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
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void Join.<init>()",
    "Integer Join.getCollectionLimit()",
    "JoinType Join.getJoinType()",
    "MatchKey Join.getMatchKey()",
    "Match Join.getMatchMethod()",
    "Operation Join.getOperation()",
    "Map Join.getOptions()",
    "Boolean Join.isFlatten()",
    "void Join.setCollectionLimit(Integer)",
    "void Join.setFlatten(Boolean)",
    "void Join.setInput(Iterable)",
    "void Join.setJoinType(JoinType)",
    "void Join.setMatchKey(MatchKey)",
    "void Join.setMatchMethod(Match)",
    "void Join.setOperation(Operation)",
    "void Join.setOptions(Map)"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    Join<Object> actualJoin = new Join<>();
    actualJoin.setCollectionLimit(1);
    actualJoin.setFlatten(true);
    ArrayList<Object> leftSideInput = new ArrayList<>();
    actualJoin.setInput(leftSideInput);
    actualJoin.setJoinType(JoinType.FULL);
    actualJoin.setMatchKey(MatchKey.LEFT);
    TestMatchImpl matchMethod = new TestMatchImpl();
    actualJoin.setMatchMethod(matchMethod);
    AddNamedOperation rightSideOperation = new AddNamedOperation();
    actualJoin.setOperation(rightSideOperation);
    HashMap<String, String> options = new HashMap<>();
    actualJoin.setOptions(options);
    Integer actualCollectionLimit = actualJoin.getCollectionLimit();
    JoinType actualJoinType = actualJoin.getJoinType();
    MatchKey actualMatchKey = actualJoin.getMatchKey();
    Match actualMatchMethod = actualJoin.getMatchMethod();
    Operation actualOperation = actualJoin.getOperation();
    Map<String, String> actualOptions = actualJoin.getOptions();
    Boolean actualIsFlattenResult = actualJoin.isFlatten();

    // Assert
    Iterable<?> input = actualJoin.getInput();
    assertTrue(input instanceof List);
    assertTrue(actualMatchMethod instanceof TestMatchImpl);
    assertEquals(1, actualCollectionLimit.intValue());
    assertEquals(MatchKey.LEFT, actualMatchKey);
    assertEquals(JoinType.FULL, actualJoinType);
    assertTrue(actualOptions.isEmpty());
    assertTrue(actualIsFlattenResult);
    assertSame(leftSideInput, input);
    assertSame(options, actualOptions);
    assertSame(rightSideOperation, actualOperation);
    assertSame(matchMethod, actualMatchMethod);
  }
}
