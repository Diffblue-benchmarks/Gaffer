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

package uk.gov.gchq.gaffer.operation.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.core.type.TypeReference;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.named.operation.AddNamedOperation;
import uk.gov.gchq.gaffer.operation.OperationChain;
import uk.gov.gchq.gaffer.operation.impl.ScoreOperationChain.Builder;
import uk.gov.gchq.gaffer.operation.serialisation.TypeReferenceImpl;

class ScoreOperationChainDiffblueTest {
  /**
   * Test Builder new {@link Builder} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link Builder}
   */
  @Test
  @DisplayName("Test Builder new Builder (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Builder.<init>()"})
  void testBuilderNewBuilder() {
    // Arrange and Act
    Builder actualBuilder = new Builder();

    // Assert
    ScoreOperationChain _getOpResult = actualBuilder._getOp();
    TypeReference<Integer> outputTypeReference = _getOpResult.getOutputTypeReference();
    assertTrue(outputTypeReference instanceof TypeReferenceImpl.Integer);
    assertNull(_getOpResult.getOptions());
    assertNull(_getOpResult.getOperationChain());
    Class<Integer> expectedOutputClass = Integer.class;
    Class<?> outputClass = _getOpResult.getOutputClass();
    assertEquals(expectedOutputClass, outputClass);
    ScoreOperationChain actualScoreOperationChain = actualBuilder.build();
    assertSame(_getOpResult, actualScoreOperationChain);
    assertSame(outputClass, outputTypeReference.getType());
    assertSame(outputClass, _getOpResult.getOutputType());
  }

  /**
   * Test Builder {@link Builder#operationChain(OperationChain)}.
   *
   * <p>Method under test: {@link Builder#operationChain(OperationChain)}
   */
  @Test
  @DisplayName("Test Builder operationChain(OperationChain)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.operationChain(OperationChain)"})
  void testBuilderOperationChain() {
    // Arrange
    Builder builder = new Builder();
    OperationChain<?> opChain = OperationChain.wrap(new AddNamedOperation());

    // Act
    Builder actualOperationChainResult = builder.operationChain(opChain);

    // Assert
    assertSame(builder, actualOperationChainResult);
  }

  /**
   * Test {@link ScoreOperationChain#getOutputTypeReference()}.
   *
   * <p>Method under test: {@link ScoreOperationChain#getOutputTypeReference()}
   */
  @Test
  @DisplayName("Test getOutputTypeReference()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TypeReference ScoreOperationChain.getOutputTypeReference()"})
  void testGetOutputTypeReference() {
    // Arrange, Act and Assert
    assertTrue(
        new ScoreOperationChain().getOutputTypeReference() instanceof TypeReferenceImpl.Integer);
  }

  /**
   * Test {@link ScoreOperationChain#shallowClone()}.
   *
   * <ul>
   *   <li>Given {@link ScoreOperationChain} (default constructor) Options is {@link
   *       HashMap#HashMap()}.
   *   <li>Then return Options Empty.
   * </ul>
   *
   * <p>Method under test: {@link ScoreOperationChain#shallowClone()}
   */
  @Test
  @DisplayName(
      "Test shallowClone(); given ScoreOperationChain (default constructor) Options is HashMap(); then return Options Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ScoreOperationChain ScoreOperationChain.shallowClone()"})
  void testShallowClone_givenScoreOperationChainOptionsIsHashMap_thenReturnOptionsEmpty() {
    // Arrange
    ScoreOperationChain scoreOperationChain = new ScoreOperationChain();
    scoreOperationChain.setOptions(new HashMap<>());

    // Act
    ScoreOperationChain actualShallowCloneResult = scoreOperationChain.shallowClone();

    // Assert
    TypeReference<Integer> outputTypeReference = actualShallowCloneResult.getOutputTypeReference();
    assertTrue(outputTypeReference instanceof TypeReferenceImpl.Integer);
    assertNull(actualShallowCloneResult.getOperationChain());
    assertTrue(actualShallowCloneResult.getOptions().isEmpty());
    Class<Integer> expectedOutputClass = Integer.class;
    Class<?> outputClass = actualShallowCloneResult.getOutputClass();
    assertEquals(expectedOutputClass, outputClass);
    assertSame(outputClass, outputTypeReference.getType());
    assertSame(outputClass, actualShallowCloneResult.getOutputType());
  }

  /**
   * Test {@link ScoreOperationChain#shallowClone()}.
   *
   * <ul>
   *   <li>Given {@link ScoreOperationChain} (default constructor).
   *   <li>Then return Options is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ScoreOperationChain#shallowClone()}
   */
  @Test
  @DisplayName(
      "Test shallowClone(); given ScoreOperationChain (default constructor); then return Options is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ScoreOperationChain ScoreOperationChain.shallowClone()"})
  void testShallowClone_givenScoreOperationChain_thenReturnOptionsIsNull() {
    // Arrange and Act
    ScoreOperationChain actualShallowCloneResult = new ScoreOperationChain().shallowClone();

    // Assert
    TypeReference<Integer> outputTypeReference = actualShallowCloneResult.getOutputTypeReference();
    assertTrue(outputTypeReference instanceof TypeReferenceImpl.Integer);
    assertNull(actualShallowCloneResult.getOptions());
    assertNull(actualShallowCloneResult.getOperationChain());
    Class<Integer> expectedOutputClass = Integer.class;
    Class<?> outputClass = actualShallowCloneResult.getOutputClass();
    assertEquals(expectedOutputClass, outputClass);
    assertSame(outputClass, outputTypeReference.getType());
    assertSame(outputClass, actualShallowCloneResult.getOutputType());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link ScoreOperationChain}
   *   <li>{@link ScoreOperationChain#setOptions(Map)}
   *   <li>{@link ScoreOperationChain#getOperationChain()}
   *   <li>{@link ScoreOperationChain#getOptions()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ScoreOperationChain.<init>()",
    "OperationChain ScoreOperationChain.getOperationChain()",
    "Map ScoreOperationChain.getOptions()",
    "void ScoreOperationChain.setOperationChain(OperationChain)",
    "void ScoreOperationChain.setOptions(Map)"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    ScoreOperationChain actualScoreOperationChain = new ScoreOperationChain();
    HashMap<String, String> options = new HashMap<>();
    actualScoreOperationChain.setOptions(options);
    OperationChain actualOperationChain = actualScoreOperationChain.getOperationChain();
    Map<String, String> actualOptions = actualScoreOperationChain.getOptions();

    // Assert
    assertNull(actualOperationChain);
    assertTrue(actualOptions.isEmpty());
    assertSame(options, actualOptions);
  }
}
