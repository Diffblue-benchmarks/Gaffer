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
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.named.operation.NamedOperation;
import uk.gov.gchq.gaffer.operation.Operation;
import uk.gov.gchq.gaffer.operation.OperationChain;
import uk.gov.gchq.gaffer.store.operation.DeleteAllData;

class DefaultScoreResolverDiffblueTest {
  /**
   * Test {@link DefaultScoreResolver#DefaultScoreResolver()}.
   * <p>
   * Method under test: {@link DefaultScoreResolver#DefaultScoreResolver()}
   */
  @Test
  @DisplayName("Test new DefaultScoreResolver()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void DefaultScoreResolver.<init>()"})
  void testNewDefaultScoreResolver() {
    // Arrange and Act
    DefaultScoreResolver actualDefaultScoreResolver = new DefaultScoreResolver();

    // Assert
    assertEquals(1, actualDefaultScoreResolver.getScore(new OperationChain<>(new DeleteAllData())).intValue());
  }

  /**
   * Test {@link DefaultScoreResolver#DefaultScoreResolver(Map)}.
   * <p>
   * Method under test: {@link DefaultScoreResolver#DefaultScoreResolver(Map)}
   */
  @Test
  @DisplayName("Test new DefaultScoreResolver(Map)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void DefaultScoreResolver.<init>(Map)"})
  void testNewDefaultScoreResolver2() {
    // Arrange and Act
    DefaultScoreResolver actualDefaultScoreResolver = new DefaultScoreResolver(new HashMap<>());

    // Assert
    assertEquals(1, actualDefaultScoreResolver.getScore(new OperationChain<>(new DeleteAllData())).intValue());
  }

  /**
   * Test {@link DefaultScoreResolver#DefaultScoreResolver(Map, Map)}.
   * <p>
   * Method under test: {@link DefaultScoreResolver#DefaultScoreResolver(Map, Map)}
   */
  @Test
  @DisplayName("Test new DefaultScoreResolver(Map, Map)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void DefaultScoreResolver.<init>(Map, Map)"})
  void testNewDefaultScoreResolver3() {
    // Arrange
    HashMap<Class<? extends Operation>, Integer> opScores = new HashMap<>();

    // Act
    DefaultScoreResolver actualDefaultScoreResolver = new DefaultScoreResolver(opScores, new HashMap<>());

    // Assert
    assertEquals(1, actualDefaultScoreResolver.getScore(new OperationChain<>(new DeleteAllData())).intValue());
  }

  /**
   * Test {@link DefaultScoreResolver#DefaultScoreResolver(Map, Map, Operation)}.
   * <p>
   * Method under test: {@link DefaultScoreResolver#DefaultScoreResolver(Map, Map, Operation)}
   */
  @Test
  @DisplayName("Test new DefaultScoreResolver(Map, Map, Operation)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void DefaultScoreResolver.<init>(Map, Map, Operation)"})
  void testNewDefaultScoreResolver4() {
    // Arrange
    HashMap<Class<? extends Operation>, Integer> opScores = new HashMap<>();
    HashMap<Class<? extends Operation>, ScoreResolver> scoreResolvers = new HashMap<>();

    // Act
    DefaultScoreResolver actualDefaultScoreResolver = new DefaultScoreResolver(opScores, scoreResolvers,
        new DeleteAllData());

    // Assert
    assertEquals(1, actualDefaultScoreResolver.getScore(new OperationChain<>(new DeleteAllData())).intValue());
  }

  /**
   * Test {@link DefaultScoreResolver#DefaultScoreResolver(Map)}.
   * <ul>
   *   <li>Given {@code Operation}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultScoreResolver#DefaultScoreResolver(Map)}
   */
  @Test
  @DisplayName("Test new DefaultScoreResolver(Map); given 'uk.gov.gchq.gaffer.operation.Operation'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void DefaultScoreResolver.<init>(Map)"})
  void testNewDefaultScoreResolver_givenUkGovGchqGafferOperationOperation() {
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
   * Test {@link DefaultScoreResolver#DefaultScoreResolver(Map, Map)}.
   * <ul>
   *   <li>Given {@code Operation}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultScoreResolver#DefaultScoreResolver(Map, Map)}
   */
  @Test
  @DisplayName("Test new DefaultScoreResolver(Map, Map); given 'uk.gov.gchq.gaffer.operation.Operation'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void DefaultScoreResolver.<init>(Map, Map)"})
  void testNewDefaultScoreResolver_givenUkGovGchqGafferOperationOperation2() {
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
   * Test {@link DefaultScoreResolver#DefaultScoreResolver(Map, Map, Operation)}.
   * <ul>
   *   <li>Given {@code Operation}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultScoreResolver#DefaultScoreResolver(Map, Map, Operation)}
   */
  @Test
  @DisplayName("Test new DefaultScoreResolver(Map, Map, Operation); given 'uk.gov.gchq.gaffer.operation.Operation'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void DefaultScoreResolver.<init>(Map, Map, Operation)"})
  void testNewDefaultScoreResolver_givenUkGovGchqGafferOperationOperation3() {
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
   * Test {@link DefaultScoreResolver#DefaultScoreResolver()}.
   * <ul>
   *   <li>Then return Score is {@link DeleteAllData} (default constructor) intValue is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultScoreResolver#DefaultScoreResolver()}
   */
  @Test
  @DisplayName("Test new DefaultScoreResolver(); then return Score is DeleteAllData (default constructor) intValue is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void DefaultScoreResolver.<init>()"})
  void testNewDefaultScoreResolver_thenReturnScoreIsDeleteAllDataIntValueIsOne() {
    // Arrange and Act
    DefaultScoreResolver actualDefaultScoreResolver = new DefaultScoreResolver();

    // Assert
    assertEquals(1, actualDefaultScoreResolver.getScore(new DeleteAllData()).intValue());
  }

  /**
   * Test {@link DefaultScoreResolver#DefaultScoreResolver(Map)}.
   * <ul>
   *   <li>Then return Score is {@link DeleteAllData} (default constructor) intValue is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultScoreResolver#DefaultScoreResolver(Map)}
   */
  @Test
  @DisplayName("Test new DefaultScoreResolver(Map); then return Score is DeleteAllData (default constructor) intValue is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void DefaultScoreResolver.<init>(Map)"})
  void testNewDefaultScoreResolver_thenReturnScoreIsDeleteAllDataIntValueIsOne2() {
    // Arrange and Act
    DefaultScoreResolver actualDefaultScoreResolver = new DefaultScoreResolver(new HashMap<>());

    // Assert
    assertEquals(1, actualDefaultScoreResolver.getScore(new DeleteAllData()).intValue());
  }

  /**
   * Test {@link DefaultScoreResolver#DefaultScoreResolver(Map, Map)}.
   * <ul>
   *   <li>Then return Score is {@link DeleteAllData} (default constructor) intValue is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultScoreResolver#DefaultScoreResolver(Map, Map)}
   */
  @Test
  @DisplayName("Test new DefaultScoreResolver(Map, Map); then return Score is DeleteAllData (default constructor) intValue is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void DefaultScoreResolver.<init>(Map, Map)"})
  void testNewDefaultScoreResolver_thenReturnScoreIsDeleteAllDataIntValueIsOne3() {
    // Arrange
    HashMap<Class<? extends Operation>, Integer> opScores = new HashMap<>();

    // Act
    DefaultScoreResolver actualDefaultScoreResolver = new DefaultScoreResolver(opScores, new HashMap<>());

    // Assert
    assertEquals(1, actualDefaultScoreResolver.getScore(new DeleteAllData()).intValue());
  }

  /**
   * Test {@link DefaultScoreResolver#DefaultScoreResolver(Map, Map, Operation)}.
   * <ul>
   *   <li>Then return Score is {@link DeleteAllData} (default constructor) intValue is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultScoreResolver#DefaultScoreResolver(Map, Map, Operation)}
   */
  @Test
  @DisplayName("Test new DefaultScoreResolver(Map, Map, Operation); then return Score is DeleteAllData (default constructor) intValue is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void DefaultScoreResolver.<init>(Map, Map, Operation)"})
  void testNewDefaultScoreResolver_thenReturnScoreIsDeleteAllDataIntValueIsOne4() {
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
   * Test {@link DefaultScoreResolver#DefaultScoreResolver()}.
   * <ul>
   *   <li>Then return Score is {@code null} intValue is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultScoreResolver#DefaultScoreResolver()}
   */
  @Test
  @DisplayName("Test new DefaultScoreResolver(); then return Score is 'null' intValue is zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void DefaultScoreResolver.<init>()"})
  void testNewDefaultScoreResolver_thenReturnScoreIsNullIntValueIsZero() {
    // Arrange, Act and Assert
    assertEquals(0, (new DefaultScoreResolver()).getScore(null).intValue());
  }

  /**
   * Test {@link DefaultScoreResolver#DefaultScoreResolver(Map, Map, Operation)}.
   * <ul>
   *   <li>Then return Score is {@code null} intValue is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultScoreResolver#DefaultScoreResolver(Map, Map, Operation)}
   */
  @Test
  @DisplayName("Test new DefaultScoreResolver(Map, Map, Operation); then return Score is 'null' intValue is zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void DefaultScoreResolver.<init>(Map, Map, Operation)"})
  void testNewDefaultScoreResolver_thenReturnScoreIsNullIntValueIsZero2() {
    // Arrange
    HashMap<Class<? extends Operation>, Integer> opScores = new HashMap<>();
    HashMap<Class<? extends Operation>, ScoreResolver> scoreResolvers = new HashMap<>();

    // Act and Assert
    assertEquals(0,
        (new DefaultScoreResolver(opScores, scoreResolvers, new DeleteAllData())).getScore(null).intValue());
  }

  /**
   * Test {@link DefaultScoreResolver#DefaultScoreResolver()}.
   * <ul>
   *   <li>Then return Score is {@link OperationChain#OperationChain()} intValue is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultScoreResolver#DefaultScoreResolver()}
   */
  @Test
  @DisplayName("Test new DefaultScoreResolver(); then return Score is OperationChain() intValue is zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void DefaultScoreResolver.<init>()"})
  void testNewDefaultScoreResolver_thenReturnScoreIsOperationChainIntValueIsZero() {
    // Arrange and Act
    DefaultScoreResolver actualDefaultScoreResolver = new DefaultScoreResolver();

    // Assert
    assertEquals(0, actualDefaultScoreResolver.getScore(new OperationChain<>()).intValue());
  }

  /**
   * Test {@link DefaultScoreResolver#DefaultScoreResolver(Map)}.
   * <ul>
   *   <li>Then return Score is {@link OperationChain#OperationChain()} intValue is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultScoreResolver#DefaultScoreResolver(Map)}
   */
  @Test
  @DisplayName("Test new DefaultScoreResolver(Map); then return Score is OperationChain() intValue is zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void DefaultScoreResolver.<init>(Map)"})
  void testNewDefaultScoreResolver_thenReturnScoreIsOperationChainIntValueIsZero2() {
    // Arrange and Act
    DefaultScoreResolver actualDefaultScoreResolver = new DefaultScoreResolver(new HashMap<>());

    // Assert
    assertEquals(0, actualDefaultScoreResolver.getScore(new OperationChain<>()).intValue());
  }

  /**
   * Test {@link DefaultScoreResolver#DefaultScoreResolver(Map, Map)}.
   * <ul>
   *   <li>Then return Score is {@link OperationChain#OperationChain()} intValue is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultScoreResolver#DefaultScoreResolver(Map, Map)}
   */
  @Test
  @DisplayName("Test new DefaultScoreResolver(Map, Map); then return Score is OperationChain() intValue is zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void DefaultScoreResolver.<init>(Map, Map)"})
  void testNewDefaultScoreResolver_thenReturnScoreIsOperationChainIntValueIsZero3() {
    // Arrange
    HashMap<Class<? extends Operation>, Integer> opScores = new HashMap<>();

    // Act
    DefaultScoreResolver actualDefaultScoreResolver = new DefaultScoreResolver(opScores, new HashMap<>());

    // Assert
    assertEquals(0, actualDefaultScoreResolver.getScore(new OperationChain<>()).intValue());
  }

  /**
   * Test {@link DefaultScoreResolver#DefaultScoreResolver(Map, Map, Operation)}.
   * <ul>
   *   <li>Then return Score is {@link OperationChain#OperationChain()} intValue is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultScoreResolver#DefaultScoreResolver(Map, Map, Operation)}
   */
  @Test
  @DisplayName("Test new DefaultScoreResolver(Map, Map, Operation); then return Score is OperationChain() intValue is zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void DefaultScoreResolver.<init>(Map, Map, Operation)"})
  void testNewDefaultScoreResolver_thenReturnScoreIsOperationChainIntValueIsZero4() {
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
   * Test {@link DefaultScoreResolver#DefaultScoreResolver(Map)}.
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.</li>
   *   <li>Then return Score is {@code null} intValue is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultScoreResolver#DefaultScoreResolver(Map)}
   */
  @Test
  @DisplayName("Test new DefaultScoreResolver(Map); when HashMap(); then return Score is 'null' intValue is zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void DefaultScoreResolver.<init>(Map)"})
  void testNewDefaultScoreResolver_whenHashMap_thenReturnScoreIsNullIntValueIsZero() {
    // Arrange, Act and Assert
    assertEquals(0, (new DefaultScoreResolver(new HashMap<>())).getScore(null).intValue());
  }

  /**
   * Test {@link DefaultScoreResolver#DefaultScoreResolver(Map, Map)}.
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.</li>
   *   <li>Then return Score is {@code null} intValue is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultScoreResolver#DefaultScoreResolver(Map, Map)}
   */
  @Test
  @DisplayName("Test new DefaultScoreResolver(Map, Map); when HashMap(); then return Score is 'null' intValue is zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void DefaultScoreResolver.<init>(Map, Map)"})
  void testNewDefaultScoreResolver_whenHashMap_thenReturnScoreIsNullIntValueIsZero2() {
    // Arrange
    HashMap<Class<? extends Operation>, Integer> opScores = new HashMap<>();

    // Act and Assert
    assertEquals(0, (new DefaultScoreResolver(opScores, new HashMap<>())).getScore(null).intValue());
  }

  /**
   * Test {@link DefaultScoreResolver#DefaultScoreResolver(Map, Map, Operation)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return Score is {@link DeleteAllData} (default constructor) intValue is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultScoreResolver#DefaultScoreResolver(Map, Map, Operation)}
   */
  @Test
  @DisplayName("Test new DefaultScoreResolver(Map, Map, Operation); when 'null'; then return Score is DeleteAllData (default constructor) intValue is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void DefaultScoreResolver.<init>(Map, Map, Operation)"})
  void testNewDefaultScoreResolver_whenNull_thenReturnScoreIsDeleteAllDataIntValueIsOne() {
    // Arrange
    HashMap<Class<? extends Operation>, Integer> opScores = new HashMap<>();

    // Act
    DefaultScoreResolver actualDefaultScoreResolver = new DefaultScoreResolver(opScores, new HashMap<>(), null);

    // Assert
    assertEquals(1, actualDefaultScoreResolver.getScore(new DeleteAllData()).intValue());
  }

  /**
   * Test {@link DefaultScoreResolver#getScore(Operation)} with {@code operation}.
   * <ul>
   *   <li>Given {@code Operation}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultScoreResolver#getScore(Operation)}
   */
  @Test
  @DisplayName("Test getScore(Operation) with 'operation'; given 'uk.gov.gchq.gaffer.operation.Operation'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Integer DefaultScoreResolver.getScore(Operation)"})
  void testGetScoreWithOperation_givenUkGovGchqGafferOperationOperation() {
    // Arrange
    HashMap<Class<? extends Operation>, Integer> opScores = new HashMap<>();
    Class<Operation> forNameResult = Operation.class;
    opScores.put(forNameResult, 1);
    DefaultScoreResolver defaultScoreResolver = new DefaultScoreResolver(opScores);

    // Act and Assert
    assertEquals(1, defaultScoreResolver.getScore(new DeleteAllData()).intValue());
  }

  /**
   * Test {@link DefaultScoreResolver#getScore(Operation)} with {@code operation}.
   * <ul>
   *   <li>When {@link DeleteAllData} (default constructor).</li>
   *   <li>Then return intValue is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultScoreResolver#getScore(Operation)}
   */
  @Test
  @DisplayName("Test getScore(Operation) with 'operation'; when DeleteAllData (default constructor); then return intValue is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Integer DefaultScoreResolver.getScore(Operation)"})
  void testGetScoreWithOperation_whenDeleteAllData_thenReturnIntValueIsOne() {
    // Arrange
    DefaultScoreResolver defaultScoreResolver = new DefaultScoreResolver();

    // Act and Assert
    assertEquals(1, defaultScoreResolver.getScore(new DeleteAllData()).intValue());
  }

  /**
   * Test {@link DefaultScoreResolver#getScore(Operation)} with {@code operation}.
   * <ul>
   *   <li>When {@link NamedOperation} (default constructor).</li>
   *   <li>Then return intValue is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultScoreResolver#getScore(Operation)}
   */
  @Test
  @DisplayName("Test getScore(Operation) with 'operation'; when NamedOperation (default constructor); then return intValue is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Integer DefaultScoreResolver.getScore(Operation)"})
  void testGetScoreWithOperation_whenNamedOperation_thenReturnIntValueIsOne() {
    // Arrange
    DefaultScoreResolver defaultScoreResolver = new DefaultScoreResolver();

    // Act and Assert
    assertEquals(1, defaultScoreResolver.getScore(new NamedOperation<>()).intValue());
  }

  /**
   * Test {@link DefaultScoreResolver#getScore(Operation)} with {@code operation}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return intValue is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultScoreResolver#getScore(Operation)}
   */
  @Test
  @DisplayName("Test getScore(Operation) with 'operation'; when 'null'; then return intValue is zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Integer DefaultScoreResolver.getScore(Operation)"})
  void testGetScoreWithOperation_whenNull_thenReturnIntValueIsZero() {
    // Arrange, Act and Assert
    assertEquals(0, (new DefaultScoreResolver()).getScore(null).intValue());
  }

  /**
   * Test {@link DefaultScoreResolver#getScore(Operation)} with {@code operation}.
   * <ul>
   *   <li>When {@link OperationChain#OperationChain(Operation[])} with operations is {@link DeleteAllData} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultScoreResolver#getScore(Operation)}
   */
  @Test
  @DisplayName("Test getScore(Operation) with 'operation'; when OperationChain(Operation[]) with operations is DeleteAllData (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Integer DefaultScoreResolver.getScore(Operation)"})
  void testGetScoreWithOperation_whenOperationChainWithOperationsIsDeleteAllData() {
    // Arrange
    DefaultScoreResolver defaultScoreResolver = new DefaultScoreResolver();

    // Act and Assert
    assertEquals(1, defaultScoreResolver.getScore(new OperationChain<>(new DeleteAllData())).intValue());
  }

  /**
   * Test {@link DefaultScoreResolver#getScore(Operation)} with {@code operation}.
   * <ul>
   *   <li>When {@link OperationChain#OperationChain()}.</li>
   *   <li>Then return intValue is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultScoreResolver#getScore(Operation)}
   */
  @Test
  @DisplayName("Test getScore(Operation) with 'operation'; when OperationChain(); then return intValue is zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Integer DefaultScoreResolver.getScore(Operation)"})
  void testGetScoreWithOperation_whenOperationChain_thenReturnIntValueIsZero() {
    // Arrange
    DefaultScoreResolver defaultScoreResolver = new DefaultScoreResolver();

    // Act and Assert
    assertEquals(0, defaultScoreResolver.getScore(new OperationChain<>()).intValue());
  }
}
