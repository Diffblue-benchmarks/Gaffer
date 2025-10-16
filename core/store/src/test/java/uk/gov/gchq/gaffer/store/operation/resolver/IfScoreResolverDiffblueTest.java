package uk.gov.gchq.gaffer.store.operation.resolver;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
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
   *   <li>Given {@link Conditional#Conditional()}.
   * </ul>
   *
   * <p>Method under test: {@link IfScoreResolver#getScore(If, ScoreResolver)}
   */
  @Test
  @DisplayName(
      "Test getScore(If, ScoreResolver) with 'operation', 'defaultScoreResolver'; given Conditional()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.Integer IfScoreResolver.getScore(If, ScoreResolver)"})
  void testGetScoreWithOperationDefaultScoreResolver_givenConditional() {
    // Arrange
    IfScoreResolver ifScoreResolver = new IfScoreResolver();

    If operation = new If();
    operation.setConditional(new Conditional());
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
