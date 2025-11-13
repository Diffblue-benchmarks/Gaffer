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

package uk.gov.gchq.gaffer.store.operation.handler;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashMap;
import java.util.HashSet;
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
import uk.gov.gchq.gaffer.operation.impl.ScoreOperationChain;
import uk.gov.gchq.gaffer.store.Context;
import uk.gov.gchq.gaffer.store.Store;
import uk.gov.gchq.gaffer.store.operation.DeleteAllData;
import uk.gov.gchq.gaffer.user.User;

class ScoreOperationChainHandlerDiffblueTest {
  /**
   * Test {@link ScoreOperationChainHandler#getSuffixNamedOperationCacheName()}.
   * <p>
   * Method under test: {@link ScoreOperationChainHandler#getSuffixNamedOperationCacheName()}
   */
  @Test
  @DisplayName("Test getSuffixNamedOperationCacheName()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ScoreOperationChainHandler.getSuffixNamedOperationCacheName()"})
  void testGetSuffixNamedOperationCacheName() {
    // Arrange, Act and Assert
    assertEquals("named operation cache name suffix",
        (new ScoreOperationChainHandler("Named Operation Cache Name Suffix")).getSuffixNamedOperationCacheName());
  }

  /**
   * Test {@link ScoreOperationChainHandler#doOperation(ScoreOperationChain, Context, Store)} with {@code ScoreOperationChain}, {@code Context}, {@code Store}.
   * <p>
   * Method under test: {@link ScoreOperationChainHandler#doOperation(ScoreOperationChain, Context, Store)}
   */
  @Test
  @DisplayName("Test doOperation(ScoreOperationChain, Context, Store) with 'ScoreOperationChain', 'Context', 'Store'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Integer ScoreOperationChainHandler.doOperation(ScoreOperationChain, Context, Store)"})
  void testDoOperationWithScoreOperationChainContextStore() throws OperationException {
    // Arrange
    ScoreOperationChainHandler scoreOperationChainHandler = new ScoreOperationChainHandler(
        "Named Operation Cache Name Suffix");

    ScoreOperationChain operation = new ScoreOperationChain();
    operation.setOperationChain(new OperationChain(new DeleteAllData()));
    Context context = new Context();

    // Act and Assert
    assertEquals(1,
        scoreOperationChainHandler.doOperation(operation, context, new TestAddToGraphLibraryImpl()).intValue());
  }

  /**
   * Test {@link ScoreOperationChainHandler#doOperation(ScoreOperationChain, Context, Store)} with {@code ScoreOperationChain}, {@code Context}, {@code Store}.
   * <p>
   * Method under test: {@link ScoreOperationChainHandler#doOperation(ScoreOperationChain, Context, Store)}
   */
  @Test
  @DisplayName("Test doOperation(ScoreOperationChain, Context, Store) with 'ScoreOperationChain', 'Context', 'Store'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Integer ScoreOperationChainHandler.doOperation(ScoreOperationChain, Context, Store)"})
  void testDoOperationWithScoreOperationChainContextStore2() throws OperationException {
    // Arrange
    ScoreOperationChainHandler scoreOperationChainHandler = new ScoreOperationChainHandler(
        "Named Operation Cache Name Suffix");

    ScoreOperationChain operation = new ScoreOperationChain();
    operation.setOperationChain(new OperationChain(new NamedOperation<>()));
    Context context = new Context();

    // Act and Assert
    assertEquals(1,
        scoreOperationChainHandler.doOperation(operation, context, new TestAddToGraphLibraryImpl()).intValue());
  }

  /**
   * Test {@link ScoreOperationChainHandler#doOperation(ScoreOperationChain, Context, Store)} with {@code ScoreOperationChain}, {@code Context}, {@code Store}.
   * <ul>
   *   <li>Given {@link OperationChain#OperationChain()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ScoreOperationChainHandler#doOperation(ScoreOperationChain, Context, Store)}
   */
  @Test
  @DisplayName("Test doOperation(ScoreOperationChain, Context, Store) with 'ScoreOperationChain', 'Context', 'Store'; given OperationChain()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Integer ScoreOperationChainHandler.doOperation(ScoreOperationChain, Context, Store)"})
  void testDoOperationWithScoreOperationChainContextStore_givenOperationChain() throws OperationException {
    // Arrange
    ScoreOperationChainHandler scoreOperationChainHandler = new ScoreOperationChainHandler(
        "Named Operation Cache Name Suffix");

    ScoreOperationChain operation = new ScoreOperationChain();
    operation.setOperationChain(new OperationChain());
    Context context = new Context();

    // Act and Assert
    assertEquals(0,
        scoreOperationChainHandler.doOperation(operation, context, new TestAddToGraphLibraryImpl()).intValue());
  }

  /**
   * Test {@link ScoreOperationChainHandler#doOperation(ScoreOperationChain, Context, Store)} with {@code ScoreOperationChain}, {@code Context}, {@code Store}.
   * <ul>
   *   <li>Then return intValue is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link ScoreOperationChainHandler#doOperation(ScoreOperationChain, Context, Store)}
   */
  @Test
  @DisplayName("Test doOperation(ScoreOperationChain, Context, Store) with 'ScoreOperationChain', 'Context', 'Store'; then return intValue is zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Integer ScoreOperationChainHandler.doOperation(ScoreOperationChain, Context, Store)"})
  void testDoOperationWithScoreOperationChainContextStore_thenReturnIntValueIsZero() throws OperationException {
    // Arrange
    ScoreOperationChainHandler scoreOperationChainHandler = new ScoreOperationChainHandler(
        "Named Operation Cache Name Suffix");
    ScoreOperationChain operation = new ScoreOperationChain();
    Context context = new Context();

    // Act and Assert
    assertEquals(0,
        scoreOperationChainHandler.doOperation(operation, context, new TestAddToGraphLibraryImpl()).intValue());
  }

  /**
   * Test {@link ScoreOperationChainHandler#getChainScore(Operations, User)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link ScoreOperationChainHandler#getChainScore(Operations, User)}
   */
  @Test
  @DisplayName("Test getChainScore(Operations, User); when 'null'; then return zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int ScoreOperationChainHandler.getChainScore(Operations, User)"})
  void testGetChainScore_whenNull_thenReturnZero() {
    // Arrange
    ScoreOperationChainHandler scoreOperationChainHandler = new ScoreOperationChainHandler(
        "Named Operation Cache Name Suffix");

    // Act and Assert
    assertEquals(0, scoreOperationChainHandler.getChainScore(null, new User()));
  }

  /**
   * Test {@link ScoreOperationChainHandler#getChainScore(Operations, User)}.
   * <ul>
   *   <li>When {@link OperationChain#OperationChain(Operation[])} with operations is {@link DeleteAllData} (default constructor).</li>
   *   <li>Then return one.</li>
   * </ul>
   * <p>
   * Method under test: {@link ScoreOperationChainHandler#getChainScore(Operations, User)}
   */
  @Test
  @DisplayName("Test getChainScore(Operations, User); when OperationChain(Operation[]) with operations is DeleteAllData (default constructor); then return one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int ScoreOperationChainHandler.getChainScore(Operations, User)"})
  void testGetChainScore_whenOperationChainWithOperationsIsDeleteAllData_thenReturnOne() {
    // Arrange
    ScoreOperationChainHandler scoreOperationChainHandler = new ScoreOperationChainHandler(
        "Named Operation Cache Name Suffix");
    OperationChain<Object> operations = new OperationChain<>(new DeleteAllData());

    // Act and Assert
    assertEquals(1, scoreOperationChainHandler.getChainScore(operations, new User()));
  }

  /**
   * Test {@link ScoreOperationChainHandler#getChainScore(Operations, User)}.
   * <ul>
   *   <li>When {@link OperationChain#OperationChain()}.</li>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link ScoreOperationChainHandler#getChainScore(Operations, User)}
   */
  @Test
  @DisplayName("Test getChainScore(Operations, User); when OperationChain(); then return zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int ScoreOperationChainHandler.getChainScore(Operations, User)"})
  void testGetChainScore_whenOperationChain_thenReturnZero() {
    // Arrange
    ScoreOperationChainHandler scoreOperationChainHandler = new ScoreOperationChainHandler(
        "Named Operation Cache Name Suffix");
    OperationChain<Object> operations = new OperationChain<>();

    // Act and Assert
    assertEquals(0, scoreOperationChainHandler.getChainScore(operations, new User()));
  }

  /**
   * Test {@link ScoreOperationChainHandler#getMaxUserAuthScore(Set)}.
   * <ul>
   *   <li>Given {@code foo}.</li>
   *   <li>When {@link HashSet#HashSet()} add {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ScoreOperationChainHandler#getMaxUserAuthScore(Set)}
   */
  @Test
  @DisplayName("Test getMaxUserAuthScore(Set); given 'foo'; when HashSet() add 'foo'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int ScoreOperationChainHandler.getMaxUserAuthScore(Set)"})
  void testGetMaxUserAuthScore_givenFoo_whenHashSetAddFoo() {
    // Arrange
    ScoreOperationChainHandler scoreOperationChainHandler = new ScoreOperationChainHandler(
        "Named Operation Cache Name Suffix");

    HashSet<String> opAuths = new HashSet<>();
    opAuths.add("foo");
    opAuths.add("Returning users max operation chain limit score of {}");

    // Act and Assert
    assertEquals(0, scoreOperationChainHandler.getMaxUserAuthScore(opAuths));
  }

  /**
   * Test {@link ScoreOperationChainHandler#getMaxUserAuthScore(Set)}.
   * <ul>
   *   <li>Given {@code Returning users max operation chain limit score of {}}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ScoreOperationChainHandler#getMaxUserAuthScore(Set)}
   */
  @Test
  @DisplayName("Test getMaxUserAuthScore(Set); given 'Returning users max operation chain limit score of {}'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int ScoreOperationChainHandler.getMaxUserAuthScore(Set)"})
  void testGetMaxUserAuthScore_givenReturningUsersMaxOperationChainLimitScoreOf() {
    // Arrange
    ScoreOperationChainHandler scoreOperationChainHandler = new ScoreOperationChainHandler(
        "Named Operation Cache Name Suffix");

    HashSet<String> opAuths = new HashSet<>();
    opAuths.add("Returning users max operation chain limit score of {}");

    // Act and Assert
    assertEquals(0, scoreOperationChainHandler.getMaxUserAuthScore(opAuths));
  }

  /**
   * Test {@link ScoreOperationChainHandler#getMaxUserAuthScore(Set)}.
   * <ul>
   *   <li>When {@link HashSet#HashSet()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ScoreOperationChainHandler#getMaxUserAuthScore(Set)}
   */
  @Test
  @DisplayName("Test getMaxUserAuthScore(Set); when HashSet()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int ScoreOperationChainHandler.getMaxUserAuthScore(Set)"})
  void testGetMaxUserAuthScore_whenHashSet() {
    // Arrange
    ScoreOperationChainHandler scoreOperationChainHandler = new ScoreOperationChainHandler(
        "Named Operation Cache Name Suffix");

    // Act and Assert
    assertEquals(0, scoreOperationChainHandler.getMaxUserAuthScore(new HashSet<>()));
  }

  /**
   * Test {@link ScoreOperationChainHandler#getOpScores()}.
   * <p>
   * Method under test: {@link ScoreOperationChainHandler#getOpScores()}
   */
  @Test
  @DisplayName("Test getOpScores()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Map ScoreOperationChainHandler.getOpScores()"})
  void testGetOpScores() {
    // Arrange, Act and Assert
    assertTrue((new ScoreOperationChainHandler("Named Operation Cache Name Suffix")).getOpScores().isEmpty());
  }

  /**
   * Test {@link ScoreOperationChainHandler#setOpScores(Map)}.
   * <p>
   * Method under test: {@link ScoreOperationChainHandler#setOpScores(Map)}
   */
  @Test
  @DisplayName("Test setOpScores(Map)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void ScoreOperationChainHandler.setOpScores(Map)"})
  void testSetOpScores() {
    // Arrange
    ScoreOperationChainHandler scoreOperationChainHandler = new ScoreOperationChainHandler(
        "Named Operation Cache Name Suffix");

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
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ScoreOperationChainHandler#setOpScores(Map)}
   */
  @Test
  @DisplayName("Test setOpScores(Map); then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void ScoreOperationChainHandler.setOpScores(Map)"})
  void testSetOpScores_thenThrowIllegalArgumentException() {
    // Arrange
    ScoreOperationChainHandler scoreOperationChainHandler = new ScoreOperationChainHandler(
        "Named Operation Cache Name Suffix");

    HashMap<Class<? extends Operation>, Integer> opScores = new HashMap<>();
    Class<NamedOperation> forNameResult = NamedOperation.class;
    opScores.put(forNameResult, 0);
    Class<Operation> forNameResult2 = Operation.class;
    opScores.put(forNameResult2, 1);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> scoreOperationChainHandler.setOpScores(opScores));
  }

  /**
   * Test {@link ScoreOperationChainHandler#setOpScores(Map)}.
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ScoreOperationChainHandler#setOpScores(Map)}
   */
  @Test
  @DisplayName("Test setOpScores(Map); when HashMap()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void ScoreOperationChainHandler.setOpScores(Map)"})
  void testSetOpScores_whenHashMap() {
    // Arrange
    ScoreOperationChainHandler scoreOperationChainHandler = new ScoreOperationChainHandler(
        "Named Operation Cache Name Suffix");

    // Act
    scoreOperationChainHandler.setOpScores(new HashMap<>());

    // Assert that nothing has changed
    assertTrue(scoreOperationChainHandler.getOpScores().isEmpty());
    assertTrue(scoreOperationChainHandler.getOpScoresAsStrings().isEmpty());
  }

  /**
   * Test {@link ScoreOperationChainHandler#setOpScores(Map)}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ScoreOperationChainHandler#setOpScores(Map)}
   */
  @Test
  @DisplayName("Test setOpScores(Map); when 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void ScoreOperationChainHandler.setOpScores(Map)"})
  void testSetOpScores_whenNull() {
    // Arrange
    ScoreOperationChainHandler scoreOperationChainHandler = new ScoreOperationChainHandler(
        "Named Operation Cache Name Suffix");

    // Act
    scoreOperationChainHandler.setOpScores(null);

    // Assert that nothing has changed
    assertTrue(scoreOperationChainHandler.getOpScores().isEmpty());
    assertTrue(scoreOperationChainHandler.getOpScoresAsStrings().isEmpty());
  }

  /**
   * Test {@link ScoreOperationChainHandler#getOpScoresAsStrings()}.
   * <p>
   * Method under test: {@link ScoreOperationChainHandler#getOpScoresAsStrings()}
   */
  @Test
  @DisplayName("Test getOpScoresAsStrings()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Map ScoreOperationChainHandler.getOpScoresAsStrings()"})
  void testGetOpScoresAsStrings() {
    // Arrange, Act and Assert
    assertTrue((new ScoreOperationChainHandler("Named Operation Cache Name Suffix")).getOpScoresAsStrings().isEmpty());
  }

  /**
   * Test {@link ScoreOperationChainHandler#getAuthScores()}.
   * <p>
   * Method under test: {@link ScoreOperationChainHandler#getAuthScores()}
   */
  @Test
  @DisplayName("Test getAuthScores()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Map ScoreOperationChainHandler.getAuthScores()"})
  void testGetAuthScores() {
    // Arrange, Act and Assert
    assertTrue((new ScoreOperationChainHandler("Named Operation Cache Name Suffix")).getAuthScores().isEmpty());
  }

  /**
   * Test {@link ScoreOperationChainHandler#getScoreResolvers()}.
   * <p>
   * Method under test: {@link ScoreOperationChainHandler#getScoreResolvers()}
   */
  @Test
  @DisplayName("Test getScoreResolvers()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Map ScoreOperationChainHandler.getScoreResolvers()"})
  void testGetScoreResolvers() {
    // Arrange, Act and Assert
    assertTrue((new ScoreOperationChainHandler("Named Operation Cache Name Suffix")).getScoreResolvers().isEmpty());
  }
}
