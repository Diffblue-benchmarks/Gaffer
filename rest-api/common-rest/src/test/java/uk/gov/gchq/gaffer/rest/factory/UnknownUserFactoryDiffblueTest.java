package uk.gov.gchq.gaffer.rest.factory;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Set;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.user.User;

class UnknownUserFactoryDiffblueTest {
  /**
   * Test {@link UnknownUserFactory#createUser()}.
   *
   * <p>Method under test: {@link UnknownUserFactory#createUser()}
   */
  @Test
  @DisplayName("Test createUser()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"User UnknownUserFactory.createUser()"})
  void testCreateUser() {
    // Arrange and Act
    User actualCreateUserResult = new UnknownUserFactory().createUser();

    // Assert
    assertEquals("UNKNOWN", actualCreateUserResult.getUserId());
    Set<String> opAuths = actualCreateUserResult.getOpAuths();
    assertEquals(1, opAuths.size());
    assertTrue(opAuths.contains("user"));
    assertTrue(actualCreateUserResult.getDataAuths().isEmpty());
  }
}
