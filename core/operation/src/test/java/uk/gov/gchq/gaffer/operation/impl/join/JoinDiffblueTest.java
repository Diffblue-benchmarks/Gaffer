package uk.gov.gchq.gaffer.operation.impl.join;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
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
  @Tag("MaintainedByDiffblue")
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
  @Tag("MaintainedByDiffblue")
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
  @Tag("MaintainedByDiffblue")
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
  @Tag("MaintainedByDiffblue")
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
  @Tag("MaintainedByDiffblue")
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
  @Tag("MaintainedByDiffblue")
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
  @Tag("MaintainedByDiffblue")
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
  @Tag("MaintainedByDiffblue")
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
  @Tag("MaintainedByDiffblue")
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
  @Tag("MaintainedByDiffblue")
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
  @Tag("MaintainedByDiffblue")
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
