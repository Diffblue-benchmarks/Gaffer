package uk.gov.gchq.gaffer.federatedstore.access.predicate.user;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.user.User;
import uk.gov.gchq.gaffer.user.User.Builder;

class FederatedGraphWriteUserPredicateDiffblueTest {
  /**
   * Test {@link FederatedGraphWriteUserPredicate#FederatedGraphWriteUserPredicate(String)}.
   *
   * <p>Method under test: {@link
   * FederatedGraphWriteUserPredicate#FederatedGraphWriteUserPredicate(String)}
   */
  @Test
  @DisplayName("Test new FederatedGraphWriteUserPredicate(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void FederatedGraphWriteUserPredicate.<init>(String)"})
  void testNewFederatedGraphWriteUserPredicate() {
    // Arrange and Act
    FederatedGraphWriteUserPredicate actualFederatedGraphWriteUserPredicate =
        new FederatedGraphWriteUserPredicate("42");

    // Assert
    assertEquals("42", actualFederatedGraphWriteUserPredicate.getCreatingUserId());
    assertTrue(actualFederatedGraphWriteUserPredicate.getAuths().isEmpty());
  }

  /**
   * Test {@link FederatedGraphWriteUserPredicate#getAuths()}.
   *
   * <p>Method under test: {@link FederatedGraphWriteUserPredicate#getAuths()}
   */
  @Test
  @DisplayName("Test getAuths()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.List FederatedGraphWriteUserPredicate.getAuths()"})
  void testGetAuths() {
    // Arrange, Act and Assert
    assertTrue(new FederatedGraphWriteUserPredicate("42").getAuths().isEmpty());
  }

  /**
   * Test {@link FederatedGraphWriteUserPredicate#test(User)} with {@code User}.
   *
   * <p>Method under test: {@link FederatedGraphWriteUserPredicate#test(User)}
   */
  @Test
  @DisplayName("Test test(User) with 'User'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean FederatedGraphWriteUserPredicate.test(User)"})
  void testTestWithUser() {
    // Arrange
    FederatedGraphWriteUserPredicate federatedGraphWriteUserPredicate =
        new FederatedGraphWriteUserPredicate("");

    // Act and Assert
    assertFalse(federatedGraphWriteUserPredicate.test(new User()));
  }

  /**
   * Test {@link FederatedGraphWriteUserPredicate#test(User)} with {@code User}.
   *
   * <ul>
   *   <li>When {@link User.Builder} (default constructor) userId {@code 42} build.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link FederatedGraphWriteUserPredicate#test(User)}
   */
  @Test
  @DisplayName(
      "Test test(User) with 'User'; when Builder (default constructor) userId '42' build; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean FederatedGraphWriteUserPredicate.test(User)"})
  void testTestWithUser_whenBuilderUserId42Build_thenReturnTrue() {
    // Arrange
    FederatedGraphWriteUserPredicate federatedGraphWriteUserPredicate =
        new FederatedGraphWriteUserPredicate("42");

    // Act
    boolean actualTestResult =
        federatedGraphWriteUserPredicate.test(new Builder().userId("42").build());

    // Assert
    assertTrue(actualTestResult);
  }

  /**
   * Test {@link FederatedGraphWriteUserPredicate#test(User)} with {@code User}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link FederatedGraphWriteUserPredicate#test(User)}
   */
  @Test
  @DisplayName("Test test(User) with 'User'; when 'null'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean FederatedGraphWriteUserPredicate.test(User)"})
  void testTestWithUser_whenNull_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new FederatedGraphWriteUserPredicate("42").test(null));
  }

  /**
   * Test {@link FederatedGraphWriteUserPredicate#test(User)} with {@code User}.
   *
   * <ul>
   *   <li>When {@link User#User()}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link FederatedGraphWriteUserPredicate#test(User)}
   */
  @Test
  @DisplayName("Test test(User) with 'User'; when User(); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean FederatedGraphWriteUserPredicate.test(User)"})
  void testTestWithUser_whenUser_thenReturnFalse() {
    // Arrange
    FederatedGraphWriteUserPredicate federatedGraphWriteUserPredicate =
        new FederatedGraphWriteUserPredicate("42");

    // Act and Assert
    assertFalse(federatedGraphWriteUserPredicate.test(new User()));
  }
}
