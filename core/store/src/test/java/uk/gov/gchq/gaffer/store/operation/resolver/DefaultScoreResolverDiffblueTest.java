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

package uk.gov.gchq.gaffer.store.operation.resolver;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.named.operation.NamedOperation;
import uk.gov.gchq.gaffer.operation.Operation;
import uk.gov.gchq.gaffer.operation.OperationChain;
import uk.gov.gchq.gaffer.store.operation.DeleteAllData;

class DefaultScoreResolverDiffblueTest {
  /**
   * Method under test: {@link DefaultScoreResolver#getScore(Operation)}
   */
  @Test
  void testGetScore() {
    // Arrange
    DefaultScoreResolver defaultScoreResolver = new DefaultScoreResolver();

    // Act and Assert
    assertEquals(1, defaultScoreResolver.getScore(new DeleteAllData()).intValue());
  }

  /**
   * Method under test: {@link DefaultScoreResolver#getScore(Operation)}
   */
  @Test
  void testGetScore2() {
    // Arrange
    DefaultScoreResolver defaultScoreResolver = new DefaultScoreResolver();

    // Act and Assert
    assertEquals(0, defaultScoreResolver.getScore(new OperationChain<>()).intValue());
  }

  /**
   * Method under test: {@link DefaultScoreResolver#getScore(Operation)}
   */
  @Test
  void testGetScore3() {
    // Arrange, Act and Assert
    assertEquals(0, (new DefaultScoreResolver()).getScore(null).intValue());
  }

  /**
   * Method under test: {@link DefaultScoreResolver#getScore(Operation)}
   */
  @Test
  void testGetScore4() {
    // Arrange
    DefaultScoreResolver defaultScoreResolver = new DefaultScoreResolver();

    // Act and Assert
    assertEquals(1, defaultScoreResolver.getScore(new OperationChain<>(new DeleteAllData())).intValue());
  }

  /**
   * Method under test: {@link DefaultScoreResolver#getScore(Operation)}
   */
  @Test
  void testGetScore5() {
    // Arrange
    DefaultScoreResolver defaultScoreResolver = new DefaultScoreResolver();

    // Act and Assert
    assertEquals(1, defaultScoreResolver.getScore(new NamedOperation<>()).intValue());
  }

  /**
   * Method under test: {@link DefaultScoreResolver#getScore(Operation)}
   */
  @Test
  void testGetScore6() {
    // Arrange
    HashMap<Class<? extends Operation>, Integer> opScores = new HashMap<>();
    Class<Operation> forNameResult = Operation.class;
    opScores.put(forNameResult, 1);
    DefaultScoreResolver defaultScoreResolver = new DefaultScoreResolver(opScores);

    // Act and Assert
    assertEquals(1, defaultScoreResolver.getScore(new DeleteAllData()).intValue());
  }

  /**
   * Method under test: {@link DefaultScoreResolver#getScore(Operation)}
   */
  @Test
  void testGetScore7() {
    // Arrange
    HashMap<Class<? extends Operation>, Integer> opScores = new HashMap<>();
    Class<Operation> forNameResult = Operation.class;
    opScores.computeIfPresent(forNameResult, mock(BiFunction.class));
    Class<Operation> forNameResult2 = Operation.class;
    opScores.put(forNameResult2, 1);
    DefaultScoreResolver defaultScoreResolver = new DefaultScoreResolver(opScores);

    // Act and Assert
    assertEquals(1, defaultScoreResolver.getScore(new DeleteAllData()).intValue());
  }

  /**
   * Method under test: {@link DefaultScoreResolver#DefaultScoreResolver()}
   */
  @Test
  void testNewDefaultScoreResolver() {
    // Arrange and Act
    DefaultScoreResolver actualDefaultScoreResolver = new DefaultScoreResolver();

    // Assert
    assertEquals(1, actualDefaultScoreResolver.getScore(new DeleteAllData()).intValue());
  }

  /**
   * Method under test: {@link DefaultScoreResolver#DefaultScoreResolver()}
   */
  @Test
  void testNewDefaultScoreResolver2() {
    // Arrange and Act
    DefaultScoreResolver actualDefaultScoreResolver = new DefaultScoreResolver();

    // Assert
    assertEquals(0, actualDefaultScoreResolver.getScore(new OperationChain<>()).intValue());
  }

  /**
   * Method under test: {@link DefaultScoreResolver#DefaultScoreResolver()}
   */
  @Test
  void testNewDefaultScoreResolver3() {
    // Arrange, Act and Assert
    assertEquals(0, (new DefaultScoreResolver()).getScore(null).intValue());
  }

  /**
   * Method under test: {@link DefaultScoreResolver#DefaultScoreResolver()}
   */
  @Test
  void testNewDefaultScoreResolver4() {
    // Arrange and Act
    DefaultScoreResolver actualDefaultScoreResolver = new DefaultScoreResolver();

    // Assert
    assertEquals(1, actualDefaultScoreResolver.getScore(new OperationChain<>(new DeleteAllData())).intValue());
  }

  /**
   * Method under test: {@link DefaultScoreResolver#DefaultScoreResolver(Map)}
   */
  @Test
  void testNewDefaultScoreResolver5() {
    // Arrange and Act
    DefaultScoreResolver actualDefaultScoreResolver = new DefaultScoreResolver(new HashMap<>());

    // Assert
    assertEquals(1, actualDefaultScoreResolver.getScore(new DeleteAllData()).intValue());
  }

  /**
   * Method under test: {@link DefaultScoreResolver#DefaultScoreResolver(Map)}
   */
  @Test
  void testNewDefaultScoreResolver6() {
    // Arrange
    HashMap<Class<? extends Operation>, Integer> opScores = new HashMap<>();
    Class<Operation> forNameResult = Operation.class;
    opScores.put(forNameResult, 1);

    // Act
    DefaultScoreResolver actualDefaultScoreResolver = new DefaultScoreResolver(opScores);

    // Assert
    assertEquals(1, actualDefaultScoreResolver.getScore(new DeleteAllData()).intValue());
  }

  /**
   * Method under test: {@link DefaultScoreResolver#DefaultScoreResolver(Map)}
   */
  @Test
  void testNewDefaultScoreResolver7() {
    // Arrange
    HashMap<Class<? extends Operation>, Integer> opScores = new HashMap<>();
    Class<Operation> forNameResult = Operation.class;
    opScores.computeIfPresent(forNameResult, mock(BiFunction.class));
    Class<Operation> forNameResult2 = Operation.class;
    opScores.put(forNameResult2, 1);

    // Act
    DefaultScoreResolver actualDefaultScoreResolver = new DefaultScoreResolver(opScores);

    // Assert
    assertEquals(1, actualDefaultScoreResolver.getScore(new DeleteAllData()).intValue());
  }

  /**
   * Method under test: {@link DefaultScoreResolver#DefaultScoreResolver(Map)}
   */
  @Test
  void testNewDefaultScoreResolver8() {
    // Arrange and Act
    DefaultScoreResolver actualDefaultScoreResolver = new DefaultScoreResolver(new HashMap<>());

    // Assert
    assertEquals(0, actualDefaultScoreResolver.getScore(new OperationChain<>()).intValue());
  }

  /**
   * Method under test: {@link DefaultScoreResolver#DefaultScoreResolver(Map)}
   */
  @Test
  void testNewDefaultScoreResolver9() {
    // Arrange, Act and Assert
    assertEquals(0, (new DefaultScoreResolver(new HashMap<>())).getScore(null).intValue());
  }

  /**
   * Method under test: {@link DefaultScoreResolver#DefaultScoreResolver(Map)}
   */
  @Test
  void testNewDefaultScoreResolver10() {
    // Arrange and Act
    DefaultScoreResolver actualDefaultScoreResolver = new DefaultScoreResolver(new HashMap<>());

    // Assert
    assertEquals(1, actualDefaultScoreResolver.getScore(new OperationChain<>(new DeleteAllData())).intValue());
  }

  /**
   * Method under test:
   * {@link DefaultScoreResolver#DefaultScoreResolver(Map, Map)}
   */
  @Test
  void testNewDefaultScoreResolver11() {
    // Arrange
    HashMap<Class<? extends Operation>, Integer> opScores = new HashMap<>();

    // Act
    DefaultScoreResolver actualDefaultScoreResolver = new DefaultScoreResolver(opScores, new HashMap<>());

    // Assert
    assertEquals(1, actualDefaultScoreResolver.getScore(new DeleteAllData()).intValue());
  }

  /**
   * Method under test:
   * {@link DefaultScoreResolver#DefaultScoreResolver(Map, Map)}
   */
  @Test
  void testNewDefaultScoreResolver12() {
    // Arrange
    HashMap<Class<? extends Operation>, Integer> opScores = new HashMap<>();
    Class<Operation> forNameResult = Operation.class;
    opScores.put(forNameResult, 1);

    // Act
    DefaultScoreResolver actualDefaultScoreResolver = new DefaultScoreResolver(opScores, new HashMap<>());

    // Assert
    assertEquals(1, actualDefaultScoreResolver.getScore(new DeleteAllData()).intValue());
  }

  /**
   * Method under test:
   * {@link DefaultScoreResolver#DefaultScoreResolver(Map, Map)}
   */
  @Test
  void testNewDefaultScoreResolver13() {
    // Arrange
    HashMap<Class<? extends Operation>, Integer> opScores = new HashMap<>();
    Class<Operation> forNameResult = Operation.class;
    opScores.computeIfPresent(forNameResult, mock(BiFunction.class));
    Class<Operation> forNameResult2 = Operation.class;
    opScores.put(forNameResult2, 1);

    // Act
    DefaultScoreResolver actualDefaultScoreResolver = new DefaultScoreResolver(opScores, new HashMap<>());

    // Assert
    assertEquals(1, actualDefaultScoreResolver.getScore(new DeleteAllData()).intValue());
  }

  /**
   * Method under test:
   * {@link DefaultScoreResolver#DefaultScoreResolver(Map, Map)}
   */
  @Test
  void testNewDefaultScoreResolver14() {
    // Arrange
    HashMap<Class<? extends Operation>, Integer> opScores = new HashMap<>();

    // Act
    DefaultScoreResolver actualDefaultScoreResolver = new DefaultScoreResolver(opScores, new HashMap<>());

    // Assert
    assertEquals(0, actualDefaultScoreResolver.getScore(new OperationChain<>()).intValue());
  }

  /**
   * Method under test:
   * {@link DefaultScoreResolver#DefaultScoreResolver(Map, Map)}
   */
  @Test
  void testNewDefaultScoreResolver15() {
    // Arrange
    HashMap<Class<? extends Operation>, Integer> opScores = new HashMap<>();

    // Act and Assert
    assertEquals(0, (new DefaultScoreResolver(opScores, new HashMap<>())).getScore(null).intValue());
  }

  /**
   * Method under test:
   * {@link DefaultScoreResolver#DefaultScoreResolver(Map, Map)}
   */
  @Test
  void testNewDefaultScoreResolver16() {
    // Arrange
    HashMap<Class<? extends Operation>, Integer> opScores = new HashMap<>();

    // Act
    DefaultScoreResolver actualDefaultScoreResolver = new DefaultScoreResolver(opScores, new HashMap<>());

    // Assert
    assertEquals(1, actualDefaultScoreResolver.getScore(new OperationChain<>(new DeleteAllData())).intValue());
  }

  /**
   * Method under test:
   * {@link DefaultScoreResolver#DefaultScoreResolver(Map, Map, Operation)}
   */
  @Test
  void testNewDefaultScoreResolver17() {
    // Arrange
    HashMap<Class<? extends Operation>, Integer> opScores = new HashMap<>();
    HashMap<Class<? extends Operation>, ScoreResolver> scoreResolvers = new HashMap<>();

    // Act
    DefaultScoreResolver actualDefaultScoreResolver = new DefaultScoreResolver(opScores, scoreResolvers,
        new DeleteAllData());

    // Assert
    assertEquals(1, actualDefaultScoreResolver.getScore(new DeleteAllData()).intValue());
  }

  /**
   * Method under test:
   * {@link DefaultScoreResolver#DefaultScoreResolver(Map, Map, Operation)}
   */
  @Test
  void testNewDefaultScoreResolver18() {
    // Arrange
    HashMap<Class<? extends Operation>, Integer> opScores = new HashMap<>();
    Class<Operation> forNameResult = Operation.class;
    opScores.put(forNameResult, 1);
    HashMap<Class<? extends Operation>, ScoreResolver> scoreResolvers = new HashMap<>();

    // Act
    DefaultScoreResolver actualDefaultScoreResolver = new DefaultScoreResolver(opScores, scoreResolvers,
        new DeleteAllData());

    // Assert
    assertEquals(1, actualDefaultScoreResolver.getScore(new DeleteAllData()).intValue());
  }

  /**
   * Method under test:
   * {@link DefaultScoreResolver#DefaultScoreResolver(Map, Map, Operation)}
   */
  @Test
  void testNewDefaultScoreResolver19() {
    // Arrange
    HashMap<Class<? extends Operation>, Integer> opScores = new HashMap<>();
    Class<Operation> forNameResult = Operation.class;
    opScores.computeIfPresent(forNameResult, mock(BiFunction.class));
    Class<Operation> forNameResult2 = Operation.class;
    opScores.put(forNameResult2, 1);
    HashMap<Class<? extends Operation>, ScoreResolver> scoreResolvers = new HashMap<>();

    // Act
    DefaultScoreResolver actualDefaultScoreResolver = new DefaultScoreResolver(opScores, scoreResolvers,
        new DeleteAllData());

    // Assert
    assertEquals(1, actualDefaultScoreResolver.getScore(new DeleteAllData()).intValue());
  }

  /**
   * Method under test:
   * {@link DefaultScoreResolver#DefaultScoreResolver(Map, Map, Operation)}
   */
  @Test
  void testNewDefaultScoreResolver20() {
    // Arrange
    HashMap<Class<? extends Operation>, Integer> opScores = new HashMap<>();

    // Act
    DefaultScoreResolver actualDefaultScoreResolver = new DefaultScoreResolver(opScores, new HashMap<>(), null);

    // Assert
    assertEquals(1, actualDefaultScoreResolver.getScore(new DeleteAllData()).intValue());
  }

  /**
   * Method under test:
   * {@link DefaultScoreResolver#DefaultScoreResolver(Map, Map, Operation)}
   */
  @Test
  void testNewDefaultScoreResolver21() {
    // Arrange
    HashMap<Class<? extends Operation>, Integer> opScores = new HashMap<>();
    HashMap<Class<? extends Operation>, ScoreResolver> scoreResolvers = new HashMap<>();

    // Act
    DefaultScoreResolver actualDefaultScoreResolver = new DefaultScoreResolver(opScores, scoreResolvers,
        new DeleteAllData());

    // Assert
    assertEquals(0, actualDefaultScoreResolver.getScore(new OperationChain<>()).intValue());
  }

  /**
   * Method under test:
   * {@link DefaultScoreResolver#DefaultScoreResolver(Map, Map, Operation)}
   */
  @Test
  void testNewDefaultScoreResolver22() {
    // Arrange
    HashMap<Class<? extends Operation>, Integer> opScores = new HashMap<>();
    HashMap<Class<? extends Operation>, ScoreResolver> scoreResolvers = new HashMap<>();

    // Act and Assert
    assertEquals(0,
        (new DefaultScoreResolver(opScores, scoreResolvers, new DeleteAllData())).getScore(null).intValue());
  }

  /**
   * Method under test:
   * {@link DefaultScoreResolver#DefaultScoreResolver(Map, Map, Operation)}
   */
  @Test
  void testNewDefaultScoreResolver23() {
    // Arrange
    HashMap<Class<? extends Operation>, Integer> opScores = new HashMap<>();
    HashMap<Class<? extends Operation>, ScoreResolver> scoreResolvers = new HashMap<>();

    // Act
    DefaultScoreResolver actualDefaultScoreResolver = new DefaultScoreResolver(opScores, scoreResolvers,
        new DeleteAllData());

    // Assert
    assertEquals(1, actualDefaultScoreResolver.getScore(new OperationChain<>(new DeleteAllData())).intValue());
  }
}
