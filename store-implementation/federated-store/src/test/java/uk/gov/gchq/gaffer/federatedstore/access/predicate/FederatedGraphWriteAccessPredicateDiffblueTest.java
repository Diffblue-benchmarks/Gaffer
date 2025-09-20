package uk.gov.gchq.gaffer.federatedstore.access.predicate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.function.Predicate;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.federatedstore.access.predicate.user.FederatedGraphWriteUserPredicate;
import uk.gov.gchq.gaffer.user.User;

class FederatedGraphWriteAccessPredicateDiffblueTest {
  /**
   * Test {@link FederatedGraphWriteAccessPredicate#FederatedGraphWriteAccessPredicate(String)}.
   *
   * <p>Method under test: {@link
   * FederatedGraphWriteAccessPredicate#FederatedGraphWriteAccessPredicate(String)}
   */
  @Test
  @DisplayName("Test new FederatedGraphWriteAccessPredicate(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void FederatedGraphWriteAccessPredicate.<init>(String)"})
  void testNewFederatedGraphWriteAccessPredicate() {
    // Arrange, Act and Assert
    Predicate<User> userPredicate = new FederatedGraphWriteAccessPredicate("42").getUserPredicate();
    assertTrue(userPredicate instanceof FederatedGraphWriteUserPredicate);
    assertEquals("42", ((FederatedGraphWriteUserPredicate) userPredicate).getCreatingUserId());
    assertTrue(((FederatedGraphWriteUserPredicate) userPredicate).getAuths().isEmpty());
  }
}
