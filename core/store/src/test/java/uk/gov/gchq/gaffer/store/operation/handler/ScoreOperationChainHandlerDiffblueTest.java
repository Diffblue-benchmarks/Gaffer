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
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.named.operation.NamedOperation;
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
   * Method under test:
   * {@link ScoreOperationChainHandler#getSuffixNamedOperationCacheName()}
   */
  @Test
  void testGetSuffixNamedOperationCacheName() {
    // Arrange, Act and Assert
    assertEquals("named operation cache name suffix",
        (new ScoreOperationChainHandler("Named Operation Cache Name Suffix")).getSuffixNamedOperationCacheName());
  }

  /**
   * Method under test:
   * {@link ScoreOperationChainHandler#doOperation(ScoreOperationChain, Context, Store)}
   */
  @Test
  void testDoOperation() throws OperationException {
    // Arrange
    ScoreOperationChainHandler scoreOperationChainHandler = new ScoreOperationChainHandler(
        "Named Operation Cache Name Suffix");
    ScoreOperationChain operation = new ScoreOperationChain();

    // Act and Assert
    assertEquals(0, scoreOperationChainHandler.doOperation(operation, new Context(), null).intValue());
  }

  /**
   * Method under test:
   * {@link ScoreOperationChainHandler#doOperation(ScoreOperationChain, Context, Store)}
   */
  @Test
  void testDoOperation2() throws OperationException {
    // Arrange
    ScoreOperationChainHandler scoreOperationChainHandler = new ScoreOperationChainHandler(
        "Named Operation Cache Name Suffix");

    ScoreOperationChain operation = new ScoreOperationChain();
    operation.setOperationChain(new OperationChain());

    // Act and Assert
    assertEquals(0, scoreOperationChainHandler.doOperation(operation, new Context(), null).intValue());
  }

  /**
   * Method under test:
   * {@link ScoreOperationChainHandler#doOperation(ScoreOperationChain, Context, Store)}
   */
  @Test
  void testDoOperation3() throws OperationException {
    // Arrange
    ScoreOperationChainHandler scoreOperationChainHandler = new ScoreOperationChainHandler(
        "Named Operation Cache Name Suffix");

    ScoreOperationChain operation = new ScoreOperationChain();
    operation.setOperationChain(new OperationChain(new DeleteAllData()));

    // Act and Assert
    assertEquals(1, scoreOperationChainHandler.doOperation(operation, new Context(), null).intValue());
  }

  /**
   * Method under test:
   * {@link ScoreOperationChainHandler#doOperation(ScoreOperationChain, Context, Store)}
   */
  @Test
  void testDoOperation4() throws OperationException {
    // Arrange
    ScoreOperationChainHandler scoreOperationChainHandler = new ScoreOperationChainHandler(
        "Named Operation Cache Name Suffix");

    ScoreOperationChain operation = new ScoreOperationChain();
    operation.setOperationChain(new OperationChain(new NamedOperation<>()));

    // Act and Assert
    assertEquals(1, scoreOperationChainHandler.doOperation(operation, new Context(), null).intValue());
  }

  /**
   * Method under test:
   * {@link ScoreOperationChainHandler#getChainScore(Operations, User)}
   */
  @Test
  void testGetChainScore() {
    // Arrange
    ScoreOperationChainHandler scoreOperationChainHandler = new ScoreOperationChainHandler(
        "Named Operation Cache Name Suffix");
    OperationChain<Object> operations = new OperationChain<>();

    // Act and Assert
    assertEquals(0, scoreOperationChainHandler.getChainScore(operations, new User()));
  }

  /**
   * Method under test:
   * {@link ScoreOperationChainHandler#getChainScore(Operations, User)}
   */
  @Test
  void testGetChainScore2() {
    // Arrange
    ScoreOperationChainHandler scoreOperationChainHandler = new ScoreOperationChainHandler(
        "Named Operation Cache Name Suffix");

    // Act and Assert
    assertEquals(0, scoreOperationChainHandler.getChainScore(null, new User()));
  }

  /**
   * Method under test:
   * {@link ScoreOperationChainHandler#getChainScore(Operations, User)}
   */
  @Test
  void testGetChainScore3() {
    // Arrange
    ScoreOperationChainHandler scoreOperationChainHandler = new ScoreOperationChainHandler(
        "Named Operation Cache Name Suffix");
    OperationChain<Object> operations = new OperationChain<>(new DeleteAllData());

    // Act and Assert
    assertEquals(1, scoreOperationChainHandler.getChainScore(operations, new User()));
  }

  /**
   * Method under test:
   * {@link ScoreOperationChainHandler#getMaxUserAuthScore(Set)}
   */
  @Test
  void testGetMaxUserAuthScore() {
    // Arrange
    ScoreOperationChainHandler scoreOperationChainHandler = new ScoreOperationChainHandler(
        "Named Operation Cache Name Suffix");

    // Act and Assert
    assertEquals(0, scoreOperationChainHandler.getMaxUserAuthScore(new HashSet<>()));
  }

  /**
   * Method under test:
   * {@link ScoreOperationChainHandler#getMaxUserAuthScore(Set)}
   */
  @Test
  void testGetMaxUserAuthScore2() {
    // Arrange
    ScoreOperationChainHandler scoreOperationChainHandler = new ScoreOperationChainHandler(
        "Named Operation Cache Name Suffix");

    HashSet<String> opAuths = new HashSet<>();
    opAuths.add("Returning users max operation chain limit score of {}");

    // Act and Assert
    assertEquals(0, scoreOperationChainHandler.getMaxUserAuthScore(opAuths));
  }

  /**
   * Method under test:
   * {@link ScoreOperationChainHandler#getMaxUserAuthScore(Set)}
   */
  @Test
  void testGetMaxUserAuthScore3() {
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
   * Method under test: {@link ScoreOperationChainHandler#getOpScores()}
   */
  @Test
  void testGetOpScores() {
    // Arrange, Act and Assert
    assertTrue((new ScoreOperationChainHandler("Named Operation Cache Name Suffix")).getOpScores().isEmpty());
  }

  /**
   * Method under test: {@link ScoreOperationChainHandler#getAuthScores()}
   */
  @Test
  void testGetAuthScores() {
    // Arrange, Act and Assert
    assertTrue((new ScoreOperationChainHandler("Named Operation Cache Name Suffix")).getAuthScores().isEmpty());
  }

  /**
   * Method under test: {@link ScoreOperationChainHandler#getScoreResolvers()}
   */
  @Test
  void testGetScoreResolvers() {
    // Arrange, Act and Assert
    assertTrue((new ScoreOperationChainHandler("Named Operation Cache Name Suffix")).getScoreResolvers().isEmpty());
  }
}
