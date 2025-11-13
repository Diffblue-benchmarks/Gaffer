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
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.function.Predicate;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.operation.impl.If;
import uk.gov.gchq.gaffer.operation.util.Conditional;

class IfScoreResolverDiffblueTest {
  /**
   * Test {@link IfScoreResolver#getScore(If)} with {@code operation}.
   *
   * <p>Method under test: {@link IfScoreResolver#getScore(If)}
   */
  @Test
  @DisplayName("Test getScore(If) with 'operation'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.Integer IfScoreResolver.getScore(If)"})
  void testGetScoreWithOperation() {
    // Arrange
    IfScoreResolver ifScoreResolver = new IfScoreResolver();

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> ifScoreResolver.getScore(new If()));
  }

  /**
   * Test {@link IfScoreResolver#getScore(If, ScoreResolver)} with {@code operation}, {@code
   * defaultScoreResolver}.
   *
   * <ul>
   *   <li>When {@link If} (default constructor) Otherwise is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link IfScoreResolver#getScore(If, ScoreResolver)}
   */
  @Test
  @DisplayName(
      "Test getScore(If, ScoreResolver) with 'operation', 'defaultScoreResolver'; when If (default constructor) Otherwise is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.Integer IfScoreResolver.getScore(If, ScoreResolver)"})
  void testGetScoreWithOperationDefaultScoreResolver_whenIfOtherwiseIsNull() {
    // Arrange
    IfScoreResolver ifScoreResolver = new IfScoreResolver();

    Conditional conditional = new Conditional(mock(Predicate.class));
    conditional.setTransform(null);

    If operation = new If();
    operation.setConditional(conditional);
    operation.setThen(null);
    operation.setOtherwise(null);

    // Act and Assert
    assertEquals(2, ifScoreResolver.getScore(operation, mock(ScoreResolver.class)).intValue());
  }

  /**
   * Test {@link IfScoreResolver#getScore(If, ScoreResolver)} with {@code operation}, {@code
   * defaultScoreResolver}.
   *
   * <ul>
   *   <li>When {@link If} (default constructor).
   *   <li>Then return intValue is two.
   * </ul>
   *
   * <p>Method under test: {@link IfScoreResolver#getScore(If, ScoreResolver)}
   */
  @Test
  @DisplayName(
      "Test getScore(If, ScoreResolver) with 'operation', 'defaultScoreResolver'; when If (default constructor); then return intValue is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.Integer IfScoreResolver.getScore(If, ScoreResolver)"})
  void testGetScoreWithOperationDefaultScoreResolver_whenIf_thenReturnIntValueIsTwo() {
    // Arrange
    IfScoreResolver ifScoreResolver = new IfScoreResolver();

    // Act and Assert
    assertEquals(2, ifScoreResolver.getScore(new If(), mock(ScoreResolver.class)).intValue());
  }

  /**
   * Test {@link IfScoreResolver#getScore(If, ScoreResolver)} with {@code operation}, {@code
   * defaultScoreResolver}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return intValue is one.
   * </ul>
   *
   * <p>Method under test: {@link IfScoreResolver#getScore(If, ScoreResolver)}
   */
  @Test
  @DisplayName(
      "Test getScore(If, ScoreResolver) with 'operation', 'defaultScoreResolver'; when 'null'; then return intValue is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.Integer IfScoreResolver.getScore(If, ScoreResolver)"})
  void testGetScoreWithOperationDefaultScoreResolver_whenNull_thenReturnIntValueIsOne() {
    // Arrange, Act and Assert
    assertEquals(1, new IfScoreResolver().getScore(null, mock(ScoreResolver.class)).intValue());
  }
}
