package uk.gov.gchq.gaffer.rest.factory.spring;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.Set;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import uk.gov.gchq.gaffer.user.User;

@ContextConfiguration(classes = {UnknownUserFactory.class})
@ExtendWith(SpringExtension.class)
class UnknownUserFactoryDiffblueTest {
  @Autowired private UnknownUserFactory unknownUserFactory;

  /**
   * Test {@link UnknownUserFactory#createUser()}.
   *
   * <p>Method under test: {@link UnknownUserFactory#createUser()}
   */
  @Test
  @DisplayName("Test createUser()")
  @Tag("MaintainedByDiffblue")
  void testCreateUser() {
    // Arrange and Act
    User actualCreateUserResult = unknownUserFactory.createUser();

    // Assert
    assertEquals("UNKNOWN", actualCreateUserResult.getUserId());
    Set<String> opAuths = actualCreateUserResult.getOpAuths();
    assertEquals(1, opAuths.size());
    assertTrue(opAuths.contains("user"));
    assertTrue(actualCreateUserResult.getDataAuths().isEmpty());
  }

  /**
   * Test new {@link UnknownUserFactory} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link UnknownUserFactory}
   */
  @Test
  @DisplayName("Test new UnknownUserFactory (default constructor)")
  @Tag("MaintainedByDiffblue")
  void testNewUnknownUserFactory() {
    // Arrange, Act and Assert
    assertNull(new UnknownUserFactory().httpHeaders);
  }
}
