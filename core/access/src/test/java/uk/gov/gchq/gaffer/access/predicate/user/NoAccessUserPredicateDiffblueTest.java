package uk.gov.gchq.gaffer.access.predicate.user;

import static org.junit.jupiter.api.Assertions.assertFalse;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.user.User;

class NoAccessUserPredicateDiffblueTest {
  /**
   * Test {@link NoAccessUserPredicate#test(User)} with {@code User}.
   *
   * <p>Method under test: {@link NoAccessUserPredicate#test(User)}
   */
  @Test
  @DisplayName("Test test(User) with 'User'")
  @Tag("MaintainedByDiffblue")
  void testTestWithUser() {
    // Arrange
    NoAccessUserPredicate noAccessUserPredicate = new NoAccessUserPredicate();

    // Act and Assert
    assertFalse(noAccessUserPredicate.test(new User()));
  }
}
