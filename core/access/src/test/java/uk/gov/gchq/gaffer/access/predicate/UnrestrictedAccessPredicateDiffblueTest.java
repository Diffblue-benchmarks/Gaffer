package uk.gov.gchq.gaffer.access.predicate;

import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.function.Predicate;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.access.predicate.user.UnrestrictedAccessUserPredicate;
import uk.gov.gchq.gaffer.user.User;
import uk.gov.gchq.gaffer.user.User.Builder;

class UnrestrictedAccessPredicateDiffblueTest {
  /**
   * Test new {@link UnrestrictedAccessPredicate} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link
   * UnrestrictedAccessPredicate}
   */
  @Test
  @DisplayName("Test new UnrestrictedAccessPredicate (default constructor)")
  @Tag("MaintainedByDiffblue")
  void testNewUnrestrictedAccessPredicate() {
    // Arrange, Act and Assert
    assertTrue(
        new UnrestrictedAccessPredicate().getUserPredicate()
            instanceof UnrestrictedAccessUserPredicate);
  }

  /**
   * Test {@link UnrestrictedAccessPredicate#getUserPredicate()}.
   *
   * <p>Method under test: {@link UnrestrictedAccessPredicate#getUserPredicate()}
   */
  @Test
  @DisplayName("Test getUserPredicate()")
  @Tag("MaintainedByDiffblue")
  void testGetUserPredicate() {
    // Arrange and Act
    Predicate<User> actualUserPredicate = new UnrestrictedAccessPredicate().getUserPredicate();
    boolean actualTestResult = actualUserPredicate.test(new Builder().userId("42").build());

    // Assert
    assertTrue(actualUserPredicate instanceof UnrestrictedAccessUserPredicate);
    assertTrue(actualTestResult);
    assertTrue(((UnrestrictedAccessUserPredicate) actualUserPredicate).test(null));
  }
}
