package uk.gov.gchq.gaffer.operation.impl.join.methods;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.operation.impl.JoinTest;
import uk.gov.gchq.gaffer.operation.impl.JoinTest.TestMatchImpl;
import uk.gov.gchq.gaffer.operation.impl.join.match.Match;
import uk.gov.gchq.gaffer.operation.impl.join.match.MatchKey;

class JoinFunctionDiffblueTest {
  /**
   * Test {@link JoinFunction#join(Iterable, Iterable, Match, MatchKey, Boolean)}.
   *
   * <ul>
   *   <li>When {@code false}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link JoinFunction#join(Iterable, Iterable, Match, MatchKey, Boolean)}
   */
  @Test
  @DisplayName(
      "Test join(Iterable, Iterable, Match, MatchKey, Boolean); when 'false'; then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.util.List JoinFunction.join(Iterable, Iterable, Match, MatchKey, Boolean)"
  })
  void testJoin_whenFalse_thenReturnEmpty() {
    // Arrange
    FullJoin fullJoin = new FullJoin();
    ArrayList<Object> left = new ArrayList<>();
    ArrayList<Object> right = new ArrayList<>();
    TestMatchImpl match = new TestMatchImpl();

    // Act and Assert
    assertTrue(fullJoin.join(left, right, match, MatchKey.LEFT, false).isEmpty());
    assertEquals(left, match.matching("Unused"));
  }

  /**
   * Test {@link JoinFunction#join(Iterable, Iterable, Match, MatchKey, Boolean)}.
   *
   * <ul>
   *   <li>When {@code RIGHT}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link JoinFunction#join(Iterable, Iterable, Match, MatchKey, Boolean)}
   */
  @Test
  @DisplayName(
      "Test join(Iterable, Iterable, Match, MatchKey, Boolean); when 'RIGHT'; then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.util.List JoinFunction.join(Iterable, Iterable, Match, MatchKey, Boolean)"
  })
  void testJoin_whenRight_thenReturnEmpty() {
    // Arrange
    FullJoin fullJoin = new FullJoin();
    ArrayList<Object> left = new ArrayList<>();
    ArrayList<Object> right = new ArrayList<>();
    TestMatchImpl match = new TestMatchImpl();

    // Act and Assert
    assertTrue(fullJoin.join(left, right, match, MatchKey.RIGHT, true).isEmpty());
    assertEquals(left, match.matching("Unused"));
  }

  /**
   * Test {@link JoinFunction#join(Iterable, Iterable, Match, MatchKey, Boolean)}.
   *
   * <ul>
   *   <li>When {@code true}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link JoinFunction#join(Iterable, Iterable, Match, MatchKey, Boolean)}
   */
  @Test
  @DisplayName(
      "Test join(Iterable, Iterable, Match, MatchKey, Boolean); when 'true'; then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.util.List JoinFunction.join(Iterable, Iterable, Match, MatchKey, Boolean)"
  })
  void testJoin_whenTrue_thenReturnEmpty() {
    // Arrange
    FullJoin fullJoin = new FullJoin();
    ArrayList<Object> left = new ArrayList<>();
    ArrayList<Object> right = new ArrayList<>();
    TestMatchImpl match = new TestMatchImpl();

    // Act and Assert
    assertTrue(fullJoin.join(left, right, match, MatchKey.LEFT, true).isEmpty());
    assertEquals(left, match.matching("Unused"));
  }
}
