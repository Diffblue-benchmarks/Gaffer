package uk.gov.gchq.gaffer.federatedstore.access.predicate;

import static org.junit.jupiter.api.Assertions.assertFalse;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.user.User;

class FederatedGraphAccessPredicateDiffblueTest {
  /**
   * Test {@link FederatedGraphAccessPredicate#isAdministrator(User, String)}.
   *
   * <ul>
   *   <li>When empty string.
   * </ul>
   *
   * <p>Method under test: {@link FederatedGraphAccessPredicate#isAdministrator(User, String)}
   */
  @Test
  @DisplayName("Test isAdministrator(User, String); when empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean FederatedGraphAccessPredicate.isAdministrator(User, String)"})
  void testIsAdministrator_whenEmptyString() {
    // Arrange
    FederatedGraphWriteAccessPredicate federatedGraphWriteAccessPredicate =
        new FederatedGraphWriteAccessPredicate("42");

    // Act and Assert
    assertFalse(federatedGraphWriteAccessPredicate.isAdministrator(new User(), ""));
  }

  /**
   * Test {@link FederatedGraphAccessPredicate#isAdministrator(User, String)}.
   *
   * <ul>
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link FederatedGraphAccessPredicate#isAdministrator(User, String)}
   */
  @Test
  @DisplayName("Test isAdministrator(User, String); when 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean FederatedGraphAccessPredicate.isAdministrator(User, String)"})
  void testIsAdministrator_whenNull() {
    // Arrange, Act and Assert
    assertFalse(new FederatedGraphWriteAccessPredicate("42").isAdministrator(null, "Admin Auth"));
  }

  /**
   * Test {@link FederatedGraphAccessPredicate#isAdministrator(User, String)}.
   *
   * <ul>
   *   <li>When {@link User#User()}.
   * </ul>
   *
   * <p>Method under test: {@link FederatedGraphAccessPredicate#isAdministrator(User, String)}
   */
  @Test
  @DisplayName("Test isAdministrator(User, String); when User()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean FederatedGraphAccessPredicate.isAdministrator(User, String)"})
  void testIsAdministrator_whenUser() {
    // Arrange
    FederatedGraphWriteAccessPredicate federatedGraphWriteAccessPredicate =
        new FederatedGraphWriteAccessPredicate("42");

    // Act and Assert
    assertFalse(federatedGraphWriteAccessPredicate.isAdministrator(new User(), "Admin Auth"));
  }
}
