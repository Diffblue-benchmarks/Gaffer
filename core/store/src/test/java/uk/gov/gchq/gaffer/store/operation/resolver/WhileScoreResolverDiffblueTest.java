package uk.gov.gchq.gaffer.store.operation.resolver;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.operation.impl.While;

class WhileScoreResolverDiffblueTest {
  /**
   * Test {@link WhileScoreResolver#getScore(While)} with {@code operation}.
   *
   * <p>Method under test: {@link WhileScoreResolver#getScore(While)}
   */
  @Test
  @DisplayName("Test getScore(While) with 'operation'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.Integer WhileScoreResolver.getScore(While)"})
  void testGetScoreWithOperation() {
    // Arrange
    WhileScoreResolver whileScoreResolver = new WhileScoreResolver();

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class, () -> whileScoreResolver.getScore(new While()));
  }

  /**
   * Test {@link WhileScoreResolver#getScore(While, ScoreResolver)} with {@code operation}, {@code
   * defaultScoreResolver}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link WhileScoreResolver#getScore(While, ScoreResolver)}
   */
  @Test
  @DisplayName(
      "Test getScore(While, ScoreResolver) with 'operation', 'defaultScoreResolver'; when 'null'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.Integer WhileScoreResolver.getScore(While, ScoreResolver)"})
  void testGetScoreWithOperationDefaultScoreResolver_whenNull_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new WhileScoreResolver().getScore(null, mock(ScoreResolver.class)));
  }
}
