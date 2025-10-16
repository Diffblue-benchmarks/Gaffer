package uk.gov.gchq.gaffer.access.predicate.user;

import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.user.User;

class UnrestrictedAccessUserPredicateDiffblueTest {
  /**
   * Test {@link UnrestrictedAccessUserPredicate#test(User)} with {@code User}.
   *
   * <p>Method under test: {@link UnrestrictedAccessUserPredicate#test(User)}
   */
  @Test
  @DisplayName("Test test(User) with 'User'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean UnrestrictedAccessUserPredicate.test(User)"})
  void testTestWithUser() {
    // Arrange
    UnrestrictedAccessUserPredicate unrestrictedAccessUserPredicate =
        new UnrestrictedAccessUserPredicate();

    // Act and Assert
    assertTrue(unrestrictedAccessUserPredicate.test(new User()));
  }
}
