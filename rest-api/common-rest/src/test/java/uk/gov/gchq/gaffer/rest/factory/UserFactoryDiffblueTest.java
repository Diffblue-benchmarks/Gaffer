package uk.gov.gchq.gaffer.rest.factory;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.Set;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.store.Context;
import uk.gov.gchq.gaffer.user.User;

class UserFactoryDiffblueTest {
  /**
   * Test {@link UserFactory#createUserFactory()}.
   *
   * <p>Method under test: {@link UserFactory#createUserFactory()}
   */
  @Test
  @DisplayName("Test createUserFactory()")
  @Tag("MaintainedByDiffblue")
  void testCreateUserFactory() {
    // Arrange and Act
    UserFactory actualCreateUserFactoryResult = UserFactory.createUserFactory();
    User actualCreateUserResult = actualCreateUserFactoryResult.createUser();

    // Assert
    assertTrue(actualCreateUserFactoryResult instanceof UnknownUserFactory);
    User createUserResult = actualCreateUserFactoryResult.createUser();
    assertEquals("UNKNOWN", createUserResult.getUserId());
    Context createContextResult = actualCreateUserFactoryResult.createContext();
    assertNull(createContextResult.getOriginalOpChain());
    assertEquals(1, createUserResult.getOpAuths().size());
    assertTrue(createContextResult.getExporters().isEmpty());
    assertTrue(createContextResult.getVariables().isEmpty());
    assertTrue(createUserResult.getDataAuths().isEmpty());
    assertEquals(createUserResult, actualCreateUserResult);
    assertEquals(createUserResult, createContextResult.getUser());
  }

  /**
   * Test {@link UserFactory#createContext()}.
   *
   * <p>Method under test: {@link UserFactory#createContext()}
   */
  @Test
  @DisplayName("Test createContext()")
  @Tag("MaintainedByDiffblue")
  void testCreateContext() {
    // Arrange and Act
    Context actualCreateContextResult = new UnknownUserFactory().createContext();

    // Assert
    User user = actualCreateContextResult.getUser();
    assertEquals("UNKNOWN", user.getUserId());
    assertNull(actualCreateContextResult.getOriginalOpChain());
    Set<String> opAuths = user.getOpAuths();
    assertEquals(1, opAuths.size());
    assertTrue(actualCreateContextResult.getExporters().isEmpty());
    assertTrue(actualCreateContextResult.getVariables().isEmpty());
    assertTrue(opAuths.contains("user"));
    assertTrue(user.getDataAuths().isEmpty());
  }
}
