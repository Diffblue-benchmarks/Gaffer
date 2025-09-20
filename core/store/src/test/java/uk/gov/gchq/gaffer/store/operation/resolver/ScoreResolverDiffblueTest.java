package uk.gov.gchq.gaffer.store.operation.resolver;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
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
  @Tag("MaintainedByDiffblue")
  void testGetScoreWithOperationScoreResolver() {
    // Arrange
    DefaultScoreResolver defaultScoreResolver = new DefaultScoreResolver();
    OperationChain<Object> wrapResult = OperationChain.wrap(new NamedOperation<>());

    // Act and Assert
    assertEquals(
        1, defaultScoreResolver.getScore(wrapResult, mock(ScoreResolver.class)).intValue());
  }
}
