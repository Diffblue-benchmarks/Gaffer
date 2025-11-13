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
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.named.operation.NamedOperation;
import uk.gov.gchq.gaffer.operation.Operation;
import uk.gov.gchq.gaffer.operation.OperationChain;
import uk.gov.gchq.gaffer.operation.impl.OperationImpl;

class DefaultScoreResolverDiffblueTest {
  /**
   * Test {@link DefaultScoreResolver#DefaultScoreResolver(Map)}.
   *
   * <ul>
   *   <li>Given {@code Operation}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultScoreResolver#DefaultScoreResolver(Map)}
   */
  @Test
  @DisplayName("Test new DefaultScoreResolver(Map); given 'uk.gov.gchq.gaffer.operation.Operation'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DefaultScoreResolver.<init>(Map)"})
  void testNewDefaultScoreResolver_givenUkGovGchqGafferOperationOperation() {
    // Arrange
    HashMap<Class<? extends Operation>, Integer> opScores = new HashMap<>();
    Class<Operation> forNameResult = Operation.class;
    opScores.put(forNameResult, 1);

    // Act
    DefaultScoreResolver actualDefaultScoreResolver = new DefaultScoreResolver(opScores);
    OperationChain<Object> operation = OperationChain.wrap(new NamedOperation<>());

    // Assert
    assertEquals(1, actualDefaultScoreResolver.getScore(operation).intValue());
  }

  /**
   * Test {@link DefaultScoreResolver#DefaultScoreResolver(Map, Map)}.
   *
   * <ul>
   *   <li>Given {@code Operation}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultScoreResolver#DefaultScoreResolver(Map, Map)}
   */
  @Test
  @DisplayName(
      "Test new DefaultScoreResolver(Map, Map); given 'uk.gov.gchq.gaffer.operation.Operation'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DefaultScoreResolver.<init>(Map, Map)"})
  void testNewDefaultScoreResolver_givenUkGovGchqGafferOperationOperation2() {
    // Arrange
    HashMap<Class<? extends Operation>, Integer> opScores = new HashMap<>();
    Class<Operation> forNameResult = Operation.class;
    opScores.put(forNameResult, 1);

    // Act
    DefaultScoreResolver actualDefaultScoreResolver =
        new DefaultScoreResolver(opScores, new HashMap<>());
    OperationChain<Object> operation = OperationChain.wrap(new NamedOperation<>());

    // Assert
    assertEquals(1, actualDefaultScoreResolver.getScore(operation).intValue());
  }

  /**
   * Test {@link DefaultScoreResolver#DefaultScoreResolver(Map, Map, Operation)}.
   *
   * <ul>
   *   <li>Given {@code Operation}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultScoreResolver#DefaultScoreResolver(Map, Map, Operation)}
   */
  @Test
  @DisplayName(
      "Test new DefaultScoreResolver(Map, Map, Operation); given 'uk.gov.gchq.gaffer.operation.Operation'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DefaultScoreResolver.<init>(Map, Map, Operation)"})
  void testNewDefaultScoreResolver_givenUkGovGchqGafferOperationOperation3() {
    // Arrange
    HashMap<Class<? extends Operation>, Integer> opScores = new HashMap<>();
    Class<Operation> forNameResult = Operation.class;
    opScores.put(forNameResult, 1);
    HashMap<Class<? extends Operation>, ScoreResolver> scoreResolvers = new HashMap<>();
    OperationChain<Object> skipResolvingOperation = OperationChain.wrap(new NamedOperation<>());

    // Act
    DefaultScoreResolver actualDefaultScoreResolver =
        new DefaultScoreResolver(opScores, scoreResolvers, skipResolvingOperation);
    OperationChain<Object> operation = OperationChain.wrap(new NamedOperation<>());
    Integer actualScore = actualDefaultScoreResolver.getScore(operation);

    // Assert
    assertEquals(1, actualScore.intValue());
  }

  /**
   * Test {@link DefaultScoreResolver#DefaultScoreResolver()}.
   *
   * <ul>
   *   <li>Then return Score is {@code null} intValue is zero.
   * </ul>
   *
   * <p>Method under test: {@link DefaultScoreResolver#DefaultScoreResolver()}
   */
  @Test
  @DisplayName("Test new DefaultScoreResolver(); then return Score is 'null' intValue is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DefaultScoreResolver.<init>()"})
  void testNewDefaultScoreResolver_thenReturnScoreIsNullIntValueIsZero() {
    // Arrange, Act and Assert
    assertEquals(0, new DefaultScoreResolver().getScore(null).intValue());
  }

  /**
   * Test {@link DefaultScoreResolver#DefaultScoreResolver(Map, Map, Operation)}.
   *
   * <ul>
   *   <li>Then return Score is {@code null} intValue is zero.
   * </ul>
   *
   * <p>Method under test: {@link DefaultScoreResolver#DefaultScoreResolver(Map, Map, Operation)}
   */
  @Test
  @DisplayName(
      "Test new DefaultScoreResolver(Map, Map, Operation); then return Score is 'null' intValue is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DefaultScoreResolver.<init>(Map, Map, Operation)"})
  void testNewDefaultScoreResolver_thenReturnScoreIsNullIntValueIsZero2() {
    // Arrange
    HashMap<Class<? extends Operation>, Integer> opScores = new HashMap<>();
    HashMap<Class<? extends Operation>, ScoreResolver> scoreResolvers = new HashMap<>();
    OperationChain<Object> skipResolvingOperation = OperationChain.wrap(new NamedOperation<>());

    // Act
    DefaultScoreResolver actualDefaultScoreResolver =
        new DefaultScoreResolver(opScores, scoreResolvers, skipResolvingOperation);

    // Assert
    assertEquals(0, actualDefaultScoreResolver.getScore(null).intValue());
  }

  /**
   * Test {@link DefaultScoreResolver#DefaultScoreResolver()}.
   *
   * <ul>
   *   <li>Then return Score is {@link OperationImpl} (default constructor) intValue is one.
   * </ul>
   *
   * <p>Method under test: {@link DefaultScoreResolver#DefaultScoreResolver()}
   */
  @Test
  @DisplayName(
      "Test new DefaultScoreResolver(); then return Score is OperationImpl (default constructor) intValue is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DefaultScoreResolver.<init>()"})
  void testNewDefaultScoreResolver_thenReturnScoreIsOperationImplIntValueIsOne() {
    // Arrange and Act
    DefaultScoreResolver actualDefaultScoreResolver = new DefaultScoreResolver();

    // Assert
    assertEquals(1, actualDefaultScoreResolver.getScore(new OperationImpl()).intValue());
  }

  /**
   * Test {@link DefaultScoreResolver#DefaultScoreResolver(Map)}.
   *
   * <ul>
   *   <li>Then return Score is {@link OperationImpl} (default constructor) intValue is one.
   * </ul>
   *
   * <p>Method under test: {@link DefaultScoreResolver#DefaultScoreResolver(Map)}
   */
  @Test
  @DisplayName(
      "Test new DefaultScoreResolver(Map); then return Score is OperationImpl (default constructor) intValue is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DefaultScoreResolver.<init>(Map)"})
  void testNewDefaultScoreResolver_thenReturnScoreIsOperationImplIntValueIsOne2() {
    // Arrange and Act
    DefaultScoreResolver actualDefaultScoreResolver = new DefaultScoreResolver(new HashMap<>());

    // Assert
    assertEquals(1, actualDefaultScoreResolver.getScore(new OperationImpl()).intValue());
  }

  /**
   * Test {@link DefaultScoreResolver#DefaultScoreResolver(Map, Map)}.
   *
   * <ul>
   *   <li>Then return Score is {@link OperationImpl} (default constructor) intValue is one.
   * </ul>
   *
   * <p>Method under test: {@link DefaultScoreResolver#DefaultScoreResolver(Map, Map)}
   */
  @Test
  @DisplayName(
      "Test new DefaultScoreResolver(Map, Map); then return Score is OperationImpl (default constructor) intValue is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DefaultScoreResolver.<init>(Map, Map)"})
  void testNewDefaultScoreResolver_thenReturnScoreIsOperationImplIntValueIsOne3() {
    // Arrange
    HashMap<Class<? extends Operation>, Integer> opScores = new HashMap<>();

    // Act
    DefaultScoreResolver actualDefaultScoreResolver =
        new DefaultScoreResolver(opScores, new HashMap<>());

    // Assert
    assertEquals(1, actualDefaultScoreResolver.getScore(new OperationImpl()).intValue());
  }

  /**
   * Test {@link DefaultScoreResolver#DefaultScoreResolver(Map, Map, Operation)}.
   *
   * <ul>
   *   <li>Then return Score is {@link OperationImpl} (default constructor) intValue is one.
   * </ul>
   *
   * <p>Method under test: {@link DefaultScoreResolver#DefaultScoreResolver(Map, Map, Operation)}
   */
  @Test
  @DisplayName(
      "Test new DefaultScoreResolver(Map, Map, Operation); then return Score is OperationImpl (default constructor) intValue is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DefaultScoreResolver.<init>(Map, Map, Operation)"})
  void testNewDefaultScoreResolver_thenReturnScoreIsOperationImplIntValueIsOne4() {
    // Arrange
    HashMap<Class<? extends Operation>, Integer> opScores = new HashMap<>();
    HashMap<Class<? extends Operation>, ScoreResolver> scoreResolvers = new HashMap<>();
    OperationChain<Object> skipResolvingOperation = OperationChain.wrap(new NamedOperation<>());

    // Act
    DefaultScoreResolver actualDefaultScoreResolver =
        new DefaultScoreResolver(opScores, scoreResolvers, skipResolvingOperation);

    // Assert
    assertEquals(1, actualDefaultScoreResolver.getScore(new OperationImpl()).intValue());
  }

  /**
   * Test {@link DefaultScoreResolver#DefaultScoreResolver()}.
   *
   * <ul>
   *   <li>Then return Score is wrap {@link NamedOperation} (default constructor) intValue is one.
   * </ul>
   *
   * <p>Method under test: {@link DefaultScoreResolver#DefaultScoreResolver()}
   */
  @Test
  @DisplayName(
      "Test new DefaultScoreResolver(); then return Score is wrap NamedOperation (default constructor) intValue is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DefaultScoreResolver.<init>()"})
  void testNewDefaultScoreResolver_thenReturnScoreIsWrapNamedOperationIntValueIsOne() {
    // Arrange and Act
    DefaultScoreResolver actualDefaultScoreResolver = new DefaultScoreResolver();
    OperationChain<Object> operation = OperationChain.wrap(new NamedOperation<>());

    // Assert
    assertEquals(1, actualDefaultScoreResolver.getScore(operation).intValue());
  }

  /**
   * Test {@link DefaultScoreResolver#DefaultScoreResolver(Map, Map)}.
   *
   * <ul>
   *   <li>Then return Score is wrap {@link NamedOperation} (default constructor) intValue is one.
   * </ul>
   *
   * <p>Method under test: {@link DefaultScoreResolver#DefaultScoreResolver(Map, Map)}
   */
  @Test
  @DisplayName(
      "Test new DefaultScoreResolver(Map, Map); then return Score is wrap NamedOperation (default constructor) intValue is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DefaultScoreResolver.<init>(Map, Map)"})
  void testNewDefaultScoreResolver_thenReturnScoreIsWrapNamedOperationIntValueIsOne2() {
    // Arrange
    HashMap<Class<? extends Operation>, Integer> opScores = new HashMap<>();

    // Act
    DefaultScoreResolver actualDefaultScoreResolver =
        new DefaultScoreResolver(opScores, new HashMap<>());
    OperationChain<Object> operation = OperationChain.wrap(new NamedOperation<>());

    // Assert
    assertEquals(1, actualDefaultScoreResolver.getScore(operation).intValue());
  }

  /**
   * Test {@link DefaultScoreResolver#DefaultScoreResolver(Map, Map, Operation)}.
   *
   * <ul>
   *   <li>Then return Score is wrap {@link NamedOperation} (default constructor) intValue is one.
   * </ul>
   *
   * <p>Method under test: {@link DefaultScoreResolver#DefaultScoreResolver(Map, Map, Operation)}
   */
  @Test
  @DisplayName(
      "Test new DefaultScoreResolver(Map, Map, Operation); then return Score is wrap NamedOperation (default constructor) intValue is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DefaultScoreResolver.<init>(Map, Map, Operation)"})
  void testNewDefaultScoreResolver_thenReturnScoreIsWrapNamedOperationIntValueIsOne3() {
    // Arrange
    HashMap<Class<? extends Operation>, Integer> opScores = new HashMap<>();
    HashMap<Class<? extends Operation>, ScoreResolver> scoreResolvers = new HashMap<>();
    OperationChain<Object> skipResolvingOperation = OperationChain.wrap(new NamedOperation<>());

    // Act
    DefaultScoreResolver actualDefaultScoreResolver =
        new DefaultScoreResolver(opScores, scoreResolvers, skipResolvingOperation);
    OperationChain<Object> operation = OperationChain.wrap(new NamedOperation<>());
    Integer actualScore = actualDefaultScoreResolver.getScore(operation);

    // Assert
    assertEquals(1, actualScore.intValue());
  }

  /**
   * Test {@link DefaultScoreResolver#DefaultScoreResolver(Map)}.
   *
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultScoreResolver#DefaultScoreResolver(Map)}
   */
  @Test
  @DisplayName("Test new DefaultScoreResolver(Map); when HashMap()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DefaultScoreResolver.<init>(Map)"})
  void testNewDefaultScoreResolver_whenHashMap() {
    // Arrange and Act
    DefaultScoreResolver actualDefaultScoreResolver = new DefaultScoreResolver(new HashMap<>());
    OperationChain<Object> operation = OperationChain.wrap(new NamedOperation<>());

    // Assert
    assertEquals(1, actualDefaultScoreResolver.getScore(operation).intValue());
  }

  /**
   * Test {@link DefaultScoreResolver#DefaultScoreResolver(Map)}.
   *
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.
   *   <li>Then return Score is {@code null} intValue is zero.
   * </ul>
   *
   * <p>Method under test: {@link DefaultScoreResolver#DefaultScoreResolver(Map)}
   */
  @Test
  @DisplayName(
      "Test new DefaultScoreResolver(Map); when HashMap(); then return Score is 'null' intValue is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DefaultScoreResolver.<init>(Map)"})
  void testNewDefaultScoreResolver_whenHashMap_thenReturnScoreIsNullIntValueIsZero() {
    // Arrange, Act and Assert
    assertEquals(0, new DefaultScoreResolver(new HashMap<>()).getScore(null).intValue());
  }

  /**
   * Test {@link DefaultScoreResolver#DefaultScoreResolver(Map, Map)}.
   *
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.
   *   <li>Then return Score is {@code null} intValue is zero.
   * </ul>
   *
   * <p>Method under test: {@link DefaultScoreResolver#DefaultScoreResolver(Map, Map)}
   */
  @Test
  @DisplayName(
      "Test new DefaultScoreResolver(Map, Map); when HashMap(); then return Score is 'null' intValue is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DefaultScoreResolver.<init>(Map, Map)"})
  void testNewDefaultScoreResolver_whenHashMap_thenReturnScoreIsNullIntValueIsZero2() {
    // Arrange
    HashMap<Class<? extends Operation>, Integer> opScores = new HashMap<>();

    // Act
    DefaultScoreResolver actualDefaultScoreResolver =
        new DefaultScoreResolver(opScores, new HashMap<>());

    // Assert
    assertEquals(0, actualDefaultScoreResolver.getScore(null).intValue());
  }

  /**
   * Test {@link DefaultScoreResolver#DefaultScoreResolver(Map)}.
   *
   * <ul>
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultScoreResolver#DefaultScoreResolver(Map)}
   */
  @Test
  @DisplayName("Test new DefaultScoreResolver(Map); when 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DefaultScoreResolver.<init>(Map)"})
  void testNewDefaultScoreResolver_whenNull() {
    // Arrange and Act
    DefaultScoreResolver actualDefaultScoreResolver = new DefaultScoreResolver(null);
    OperationChain<Object> operation = OperationChain.wrap(new NamedOperation<>());

    // Assert
    assertEquals(1, actualDefaultScoreResolver.getScore(operation).intValue());
  }

  /**
   * Test {@link DefaultScoreResolver#DefaultScoreResolver(Map, Map)}.
   *
   * <ul>
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultScoreResolver#DefaultScoreResolver(Map, Map)}
   */
  @Test
  @DisplayName("Test new DefaultScoreResolver(Map, Map); when 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DefaultScoreResolver.<init>(Map, Map)"})
  void testNewDefaultScoreResolver_whenNull2() {
    // Arrange and Act
    DefaultScoreResolver actualDefaultScoreResolver =
        new DefaultScoreResolver(new HashMap<>(), null);
    OperationChain<Object> operation = OperationChain.wrap(new NamedOperation<>());

    // Assert
    assertEquals(1, actualDefaultScoreResolver.getScore(operation).intValue());
  }

  /**
   * Test {@link DefaultScoreResolver#DefaultScoreResolver(Map, Map)}.
   *
   * <ul>
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultScoreResolver#DefaultScoreResolver(Map, Map)}
   */
  @Test
  @DisplayName("Test new DefaultScoreResolver(Map, Map); when 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DefaultScoreResolver.<init>(Map, Map)"})
  void testNewDefaultScoreResolver_whenNull3() {
    // Arrange and Act
    DefaultScoreResolver actualDefaultScoreResolver =
        new DefaultScoreResolver(null, new HashMap<>());
    OperationChain<Object> operation = OperationChain.wrap(new NamedOperation<>());

    // Assert
    assertEquals(1, actualDefaultScoreResolver.getScore(operation).intValue());
  }

  /**
   * Test {@link DefaultScoreResolver#DefaultScoreResolver(Map, Map, Operation)}.
   *
   * <ul>
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultScoreResolver#DefaultScoreResolver(Map, Map, Operation)}
   */
  @Test
  @DisplayName("Test new DefaultScoreResolver(Map, Map, Operation); when 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DefaultScoreResolver.<init>(Map, Map, Operation)"})
  void testNewDefaultScoreResolver_whenNull4() {
    // Arrange
    HashMap<Class<? extends Operation>, Integer> opScores = new HashMap<>();
    OperationChain<Object> skipResolvingOperation = OperationChain.wrap(new NamedOperation<>());

    // Act
    DefaultScoreResolver actualDefaultScoreResolver =
        new DefaultScoreResolver(opScores, null, skipResolvingOperation);
    OperationChain<Object> operation = OperationChain.wrap(new NamedOperation<>());
    Integer actualScore = actualDefaultScoreResolver.getScore(operation);

    // Assert
    assertEquals(1, actualScore.intValue());
  }

  /**
   * Test {@link DefaultScoreResolver#DefaultScoreResolver(Map, Map, Operation)}.
   *
   * <ul>
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultScoreResolver#DefaultScoreResolver(Map, Map, Operation)}
   */
  @Test
  @DisplayName("Test new DefaultScoreResolver(Map, Map, Operation); when 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DefaultScoreResolver.<init>(Map, Map, Operation)"})
  void testNewDefaultScoreResolver_whenNull5() {
    // Arrange
    HashMap<Class<? extends Operation>, ScoreResolver> scoreResolvers = new HashMap<>();
    OperationChain<Object> skipResolvingOperation = OperationChain.wrap(new NamedOperation<>());

    // Act
    DefaultScoreResolver actualDefaultScoreResolver =
        new DefaultScoreResolver(null, scoreResolvers, skipResolvingOperation);
    OperationChain<Object> operation = OperationChain.wrap(new NamedOperation<>());
    Integer actualScore = actualDefaultScoreResolver.getScore(operation);

    // Assert
    assertEquals(1, actualScore.intValue());
  }

  /**
   * Test {@link DefaultScoreResolver#DefaultScoreResolver(Map, Map, Operation)}.
   *
   * <ul>
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultScoreResolver#DefaultScoreResolver(Map, Map, Operation)}
   */
  @Test
  @DisplayName("Test new DefaultScoreResolver(Map, Map, Operation); when 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DefaultScoreResolver.<init>(Map, Map, Operation)"})
  void testNewDefaultScoreResolver_whenNull6() {
    // Arrange
    HashMap<Class<? extends Operation>, Integer> opScores = new HashMap<>();

    // Act
    DefaultScoreResolver actualDefaultScoreResolver =
        new DefaultScoreResolver(opScores, new HashMap<>(), null);
    OperationChain<Object> operation = OperationChain.wrap(new NamedOperation<>());
    Integer actualScore = actualDefaultScoreResolver.getScore(operation);

    // Assert
    assertEquals(1, actualScore.intValue());
  }

  /**
   * Test {@link DefaultScoreResolver#getScore(Operation)} with {@code operation}.
   *
   * <ul>
   *   <li>Given {@link DefaultScoreResolver#DefaultScoreResolver()}.
   *   <li>Then return intValue is one.
   * </ul>
   *
   * <p>Method under test: {@link DefaultScoreResolver#getScore(Operation)}
   */
  @Test
  @DisplayName(
      "Test getScore(Operation) with 'operation'; given DefaultScoreResolver(); then return intValue is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Integer DefaultScoreResolver.getScore(Operation)"})
  void testGetScoreWithOperation_givenDefaultScoreResolver_thenReturnIntValueIsOne() {
    // Arrange
    DefaultScoreResolver defaultScoreResolver = new DefaultScoreResolver();
    OperationChain<Object> operation = OperationChain.wrap(new NamedOperation<>());

    // Act and Assert
    assertEquals(1, defaultScoreResolver.getScore(operation).intValue());
  }

  /**
   * Test {@link DefaultScoreResolver#getScore(Operation)} with {@code operation}.
   *
   * <ul>
   *   <li>Given {@link DefaultScoreResolver#DefaultScoreResolver()}.
   *   <li>When {@link OperationImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link DefaultScoreResolver#getScore(Operation)}
   */
  @Test
  @DisplayName(
      "Test getScore(Operation) with 'operation'; given DefaultScoreResolver(); when OperationImpl (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Integer DefaultScoreResolver.getScore(Operation)"})
  void testGetScoreWithOperation_givenDefaultScoreResolver_whenOperationImpl() {
    // Arrange
    DefaultScoreResolver defaultScoreResolver = new DefaultScoreResolver();

    // Act and Assert
    assertEquals(1, defaultScoreResolver.getScore(new OperationImpl()).intValue());
  }

  /**
   * Test {@link DefaultScoreResolver#getScore(Operation)} with {@code operation}.
   *
   * <ul>
   *   <li>Given {@code Operation}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultScoreResolver#getScore(Operation)}
   */
  @Test
  @DisplayName(
      "Test getScore(Operation) with 'operation'; given 'uk.gov.gchq.gaffer.operation.Operation'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Integer DefaultScoreResolver.getScore(Operation)"})
  void testGetScoreWithOperation_givenUkGovGchqGafferOperationOperation() {
    // Arrange
    HashMap<Class<? extends Operation>, Integer> opScores = new HashMap<>();
    Class<Operation> forNameResult = Operation.class;
    opScores.put(forNameResult, 1);
    DefaultScoreResolver defaultScoreResolver = new DefaultScoreResolver(opScores);
    OperationChain<Object> operation = OperationChain.wrap(new NamedOperation<>());

    // Act and Assert
    assertEquals(1, defaultScoreResolver.getScore(operation).intValue());
  }

  /**
   * Test {@link DefaultScoreResolver#getScore(Operation)} with {@code operation}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return intValue is zero.
   * </ul>
   *
   * <p>Method under test: {@link DefaultScoreResolver#getScore(Operation)}
   */
  @Test
  @DisplayName(
      "Test getScore(Operation) with 'operation'; when 'null'; then return intValue is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Integer DefaultScoreResolver.getScore(Operation)"})
  void testGetScoreWithOperation_whenNull_thenReturnIntValueIsZero() {
    // Arrange, Act and Assert
    assertEquals(0, new DefaultScoreResolver().getScore(null).intValue());
  }
}
