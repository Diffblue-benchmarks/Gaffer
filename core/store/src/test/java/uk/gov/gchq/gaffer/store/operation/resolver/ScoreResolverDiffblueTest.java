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

package uk.gov.gchq.gaffer.store.operation.resolver;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.named.operation.NamedOperation;
import uk.gov.gchq.gaffer.operation.Operation;
import uk.gov.gchq.gaffer.operation.OperationChain;

class ScoreResolverDiffblueTest {
  /**
   * Test {@link ScoreResolver#getScore(Operation, ScoreResolver)} with {@code Operation}, {@code
   * ScoreResolver}.
   *
   * <p>Method under test: {@link ScoreResolver#getScore(Operation, ScoreResolver)}
   */
  @Test
  @DisplayName("Test getScore(Operation, ScoreResolver) with 'Operation', 'ScoreResolver'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.Integer ScoreResolver.getScore(Operation, ScoreResolver)"})
  void testGetScoreWithOperationScoreResolver() {
    // Arrange
    DefaultScoreResolver defaultScoreResolver = new DefaultScoreResolver();
    OperationChain<Object> wrapResult = OperationChain.wrap(new NamedOperation<>());

    // Act and Assert
    assertEquals(
        1, defaultScoreResolver.getScore(wrapResult, mock(ScoreResolver.class)).intValue());
  }
}
