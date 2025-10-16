package uk.gov.gchq.gaffer.store.operation.handler;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.named.operation.NamedOperation;
import uk.gov.gchq.gaffer.operation.Operation;
import uk.gov.gchq.gaffer.operation.OperationChain;
import uk.gov.gchq.gaffer.operation.OperationException;
import uk.gov.gchq.gaffer.operation.Operations;
import uk.gov.gchq.gaffer.operation.impl.OperationImpl;
import uk.gov.gchq.gaffer.operation.impl.ScoreOperationChain;
import uk.gov.gchq.gaffer.store.Context;
import uk.gov.gchq.gaffer.store.Store;
import uk.gov.gchq.gaffer.user.User;

class ScoreOperationChainHandlerDiffblueTest {
  /**
   * Test {@link ScoreOperationChainHandler#getSuffixNamedOperationCacheName()}.
   *
   * <p>Method under test: {@link ScoreOperationChainHandler#getSuffixNamedOperationCacheName()}
   */
  @Test
  @DisplayName("Test getSuffixNamedOperationCacheName()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ScoreOperationChainHandler.getSuffixNamedOperationCacheName()"})
  void testGetSuffixNamedOperationCacheName() {
    // Arrange, Act and Assert
    assertEquals(
        "named operation cache name suffix",
        new ScoreOperationChainHandler("Named Operation Cache Name Suffix")
            .getSuffixNamedOperationCacheName());
  }

  /**
   * Test {@link ScoreOperationChainHandler#doOperation(ScoreOperationChain, Context, Store)} with
   * {@code ScoreOperationChain}, {@code Context}, {@code Store}.
   *
   * <ul>
   *   <li>Given wrap {@link OperationImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link ScoreOperationChainHandler#doOperation(ScoreOperationChain,
   * Context, Store)}
   */
  @Test
  @DisplayName(
      "Test doOperation(ScoreOperationChain, Context, Store) with 'ScoreOperationChain', 'Context', 'Store'; given wrap OperationImpl (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Integer ScoreOperationChainHandler.doOperation(ScoreOperationChain, Context, Store)"
  })
  void testDoOperationWithScoreOperationChainContextStore_givenWrapOperationImpl()
      throws OperationException {
    // Arrange
    ScoreOperationChainHandler scoreOperationChainHandler =
        new ScoreOperationChainHandler("Named Operation Cache Name Suffix");

    ScoreOperationChain operation = new ScoreOperationChain();
    OperationChain<?> operationChain = OperationChain.wrap(new OperationImpl());
    operation.setOperationChain(operationChain);
    Context context = new Context();

    // Act and Assert
    assertEquals(
        1,
        scoreOperationChainHandler
            .doOperation(operation, context, new TestAddToGraphLibraryImpl())
            .intValue());
  }

  /**
   * Test {@link ScoreOperationChainHandler#doOperation(ScoreOperationChain, Context, Store)} with
   * {@code ScoreOperationChain}, {@code Context}, {@code Store}.
   *
   * <ul>
   *   <li>Given wrap wrap {@link NamedOperation} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link ScoreOperationChainHandler#doOperation(ScoreOperationChain,
   * Context, Store)}
   */
  @Test
  @DisplayName(
      "Test doOperation(ScoreOperationChain, Context, Store) with 'ScoreOperationChain', 'Context', 'Store'; given wrap wrap NamedOperation (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Integer ScoreOperationChainHandler.doOperation(ScoreOperationChain, Context, Store)"
  })
  void testDoOperationWithScoreOperationChainContextStore_givenWrapWrapNamedOperation()
      throws OperationException {
    // Arrange
    ScoreOperationChainHandler scoreOperationChainHandler =
        new ScoreOperationChainHandler("Named Operation Cache Name Suffix");

    ScoreOperationChain operation = new ScoreOperationChain();
    OperationChain<Object> operation2 = OperationChain.wrap(new NamedOperation<>());
    OperationChain<?> operationChain = OperationChain.wrap(operation2);
    operation.setOperationChain(operationChain);
    Context context = new Context();

    // Act and Assert
    assertEquals(
        1,
        scoreOperationChainHandler
            .doOperation(operation, context, new TestAddToGraphLibraryImpl())
            .intValue());
  }

  /**
   * Test {@link ScoreOperationChainHandler#doOperation(ScoreOperationChain, Context, Store)} with
   * {@code ScoreOperationChain}, {@code Context}, {@code Store}.
   *
   * <ul>
   *   <li>Then return intValue is zero.
   * </ul>
   *
   * <p>Method under test: {@link ScoreOperationChainHandler#doOperation(ScoreOperationChain,
   * Context, Store)}
   */
  @Test
  @DisplayName(
      "Test doOperation(ScoreOperationChain, Context, Store) with 'ScoreOperationChain', 'Context', 'Store'; then return intValue is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Integer ScoreOperationChainHandler.doOperation(ScoreOperationChain, Context, Store)"
  })
  void testDoOperationWithScoreOperationChainContextStore_thenReturnIntValueIsZero()
      throws OperationException {
    // Arrange
    ScoreOperationChainHandler scoreOperationChainHandler =
        new ScoreOperationChainHandler("Named Operation Cache Name Suffix");
    ScoreOperationChain operation = new ScoreOperationChain();
    Context context = new Context();

    // Act and Assert
    assertEquals(
        0,
        scoreOperationChainHandler
            .doOperation(operation, context, new TestAddToGraphLibraryImpl())
            .intValue());
  }

  /**
   * Test {@link ScoreOperationChainHandler#getChainScore(Operations, User)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link ScoreOperationChainHandler#getChainScore(Operations, User)}
   */
  @Test
  @DisplayName("Test getChainScore(Operations, User); when 'null'; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int ScoreOperationChainHandler.getChainScore(Operations, User)"})
  void testGetChainScore_whenNull_thenReturnZero() {
    // Arrange
    ScoreOperationChainHandler scoreOperationChainHandler =
        new ScoreOperationChainHandler("Named Operation Cache Name Suffix");

    // Act and Assert
    assertEquals(0, scoreOperationChainHandler.getChainScore(null, new User()));
  }

  /**
   * Test {@link ScoreOperationChainHandler#getChainScore(Operations, User)}.
   *
   * <ul>
   *   <li>When wrap {@link NamedOperation} (default constructor).
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link ScoreOperationChainHandler#getChainScore(Operations, User)}
   */
  @Test
  @DisplayName(
      "Test getChainScore(Operations, User); when wrap NamedOperation (default constructor); then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int ScoreOperationChainHandler.getChainScore(Operations, User)"})
  void testGetChainScore_whenWrapNamedOperation_thenReturnOne() {
    // Arrange
    ScoreOperationChainHandler scoreOperationChainHandler =
        new ScoreOperationChainHandler("Named Operation Cache Name Suffix");
    OperationChain<Object> operations = OperationChain.wrap(new NamedOperation<>());

    // Act and Assert
    assertEquals(1, scoreOperationChainHandler.getChainScore(operations, new User()));
  }

  /**
   * Test {@link ScoreOperationChainHandler#getMaxUserAuthScore(Set)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link HashSet#HashSet()} add {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ScoreOperationChainHandler#getMaxUserAuthScore(Set)}
   */
  @Test
  @DisplayName("Test getMaxUserAuthScore(Set); given '42'; when HashSet() add '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int ScoreOperationChainHandler.getMaxUserAuthScore(Set)"})
  void testGetMaxUserAuthScore_given42_whenHashSetAdd42() {
    // Arrange
    ScoreOperationChainHandler scoreOperationChainHandler =
        new ScoreOperationChainHandler("Named Operation Cache Name Suffix");

    HashSet<String> opAuths = new HashSet<>();
    opAuths.add("42");
    opAuths.add("Returning users max operation chain limit score of {}");

    // Act and Assert
    assertEquals(0, scoreOperationChainHandler.getMaxUserAuthScore(opAuths));
  }

  /**
   * Test {@link ScoreOperationChainHandler#getMaxUserAuthScore(Set)}.
   *
   * <ul>
   *   <li>Given {@code Op Auths}.
   *   <li>When {@link LinkedHashSet#LinkedHashSet()} add {@code Op Auths}.
   * </ul>
   *
   * <p>Method under test: {@link ScoreOperationChainHandler#getMaxUserAuthScore(Set)}
   */
  @Test
  @DisplayName(
      "Test getMaxUserAuthScore(Set); given 'Op Auths'; when LinkedHashSet() add 'Op Auths'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int ScoreOperationChainHandler.getMaxUserAuthScore(Set)"})
  void testGetMaxUserAuthScore_givenOpAuths_whenLinkedHashSetAddOpAuths() {
    // Arrange
    ScoreOperationChainHandler scoreOperationChainHandler =
        new ScoreOperationChainHandler("Named Operation Cache Name Suffix");

    LinkedHashSet<String> opAuths = new LinkedHashSet<>();
    opAuths.add("Op Auths");

    // Act and Assert
    assertEquals(0, scoreOperationChainHandler.getMaxUserAuthScore(opAuths));
  }

  /**
   * Test {@link ScoreOperationChainHandler#getMaxUserAuthScore(Set)}.
   *
   * <ul>
   *   <li>When {@link HashSet#HashSet()}.
   * </ul>
   *
   * <p>Method under test: {@link ScoreOperationChainHandler#getMaxUserAuthScore(Set)}
   */
  @Test
  @DisplayName("Test getMaxUserAuthScore(Set); when HashSet()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int ScoreOperationChainHandler.getMaxUserAuthScore(Set)"})
  void testGetMaxUserAuthScore_whenHashSet() {
    // Arrange
    ScoreOperationChainHandler scoreOperationChainHandler =
        new ScoreOperationChainHandler("Named Operation Cache Name Suffix");

    // Act and Assert
    assertEquals(0, scoreOperationChainHandler.getMaxUserAuthScore(new HashSet<>()));
  }

  /**
   * Test {@link ScoreOperationChainHandler#getOpScores()}.
   *
   * <p>Method under test: {@link ScoreOperationChainHandler#getOpScores()}
   */
  @Test
  @DisplayName("Test getOpScores()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map ScoreOperationChainHandler.getOpScores()"})
  void testGetOpScores() {
    // Arrange, Act and Assert
    assertTrue(
        new ScoreOperationChainHandler("Named Operation Cache Name Suffix")
            .getOpScores()
            .isEmpty());
  }

  /**
   * Test {@link ScoreOperationChainHandler#setOpScores(Map)}.
   *
   * <p>Method under test: {@link ScoreOperationChainHandler#setOpScores(Map)}
   */
  @Test
  @DisplayName("Test setOpScores(Map)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ScoreOperationChainHandler.setOpScores(Map)"})
  void testSetOpScores() {
    // Arrange
    ScoreOperationChainHandler scoreOperationChainHandler =
        new ScoreOperationChainHandler("Named Operation Cache Name Suffix");

    HashMap<Class<? extends Operation>, Integer> opScores = new HashMap<>();
    Class<Operation> forNameResult = Operation.class;
    opScores.put(forNameResult, 1);

    // Act
    scoreOperationChainHandler.setOpScores(opScores);

    // Assert
    Map<String, Integer> opScoresAsStrings = scoreOperationChainHandler.getOpScoresAsStrings();
    assertEquals(1, opScoresAsStrings.size());
    assertEquals(1, opScoresAsStrings.get("uk.gov.gchq.gaffer.operation.Operation").intValue());
    assertEquals(opScores, scoreOperationChainHandler.getOpScores());
  }

  /**
   * Test {@link ScoreOperationChainHandler#setOpScores(Map)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link ScoreOperationChainHandler#setOpScores(Map)}
   */
  @Test
  @DisplayName("Test setOpScores(Map); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ScoreOperationChainHandler.setOpScores(Map)"})
  void testSetOpScores_thenThrowIllegalArgumentException() {
    // Arrange
    ScoreOperationChainHandler scoreOperationChainHandler =
        new ScoreOperationChainHandler("Named Operation Cache Name Suffix");

    HashMap<Class<? extends Operation>, Integer> opScores = new HashMap<>();
    Class<NamedOperation> forNameResult = NamedOperation.class;
    opScores.put(forNameResult, 0);
    Class<Operation> forNameResult2 = Operation.class;
    opScores.put(forNameResult2, 1);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> scoreOperationChainHandler.setOpScores(opScores));
  }

  /**
   * Test {@link ScoreOperationChainHandler#setOpScores(Map)}.
   *
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.
   * </ul>
   *
   * <p>Method under test: {@link ScoreOperationChainHandler#setOpScores(Map)}
   */
  @Test
  @DisplayName("Test setOpScores(Map); when HashMap()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ScoreOperationChainHandler.setOpScores(Map)"})
  void testSetOpScores_whenHashMap() {
    // Arrange
    ScoreOperationChainHandler scoreOperationChainHandler =
        new ScoreOperationChainHandler("Named Operation Cache Name Suffix");

    // Act
    scoreOperationChainHandler.setOpScores(new HashMap<>());

    // Assert that nothing has changed
    assertTrue(scoreOperationChainHandler.getOpScores().isEmpty());
    assertTrue(scoreOperationChainHandler.getOpScoresAsStrings().isEmpty());
  }

  /**
   * Test {@link ScoreOperationChainHandler#setOpScores(Map)}.
   *
   * <ul>
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ScoreOperationChainHandler#setOpScores(Map)}
   */
  @Test
  @DisplayName("Test setOpScores(Map); when 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ScoreOperationChainHandler.setOpScores(Map)"})
  void testSetOpScores_whenNull() {
    // Arrange
    ScoreOperationChainHandler scoreOperationChainHandler =
        new ScoreOperationChainHandler("Named Operation Cache Name Suffix");

    // Act
    scoreOperationChainHandler.setOpScores(null);

    // Assert that nothing has changed
    assertTrue(scoreOperationChainHandler.getOpScores().isEmpty());
    assertTrue(scoreOperationChainHandler.getOpScoresAsStrings().isEmpty());
  }

  /**
   * Test {@link ScoreOperationChainHandler#getOpScoresAsStrings()}.
   *
   * <p>Method under test: {@link ScoreOperationChainHandler#getOpScoresAsStrings()}
   */
  @Test
  @DisplayName("Test getOpScoresAsStrings()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map ScoreOperationChainHandler.getOpScoresAsStrings()"})
  void testGetOpScoresAsStrings() {
    // Arrange, Act and Assert
    assertTrue(
        new ScoreOperationChainHandler("Named Operation Cache Name Suffix")
            .getOpScoresAsStrings()
            .isEmpty());
  }

  /**
   * Test {@link ScoreOperationChainHandler#getAuthScores()}.
   *
   * <p>Method under test: {@link ScoreOperationChainHandler#getAuthScores()}
   */
  @Test
  @DisplayName("Test getAuthScores()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map ScoreOperationChainHandler.getAuthScores()"})
  void testGetAuthScores() {
    // Arrange, Act and Assert
    assertTrue(
        new ScoreOperationChainHandler("Named Operation Cache Name Suffix")
            .getAuthScores()
            .isEmpty());
  }

  /**
   * Test {@link ScoreOperationChainHandler#getScoreResolvers()}.
   *
   * <p>Method under test: {@link ScoreOperationChainHandler#getScoreResolvers()}
   */
  @Test
  @DisplayName("Test getScoreResolvers()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map ScoreOperationChainHandler.getScoreResolvers()"})
  void testGetScoreResolvers() {
    // Arrange, Act and Assert
    assertTrue(
        new ScoreOperationChainHandler("Named Operation Cache Name Suffix")
            .getScoreResolvers()
            .isEmpty());
  }
}
