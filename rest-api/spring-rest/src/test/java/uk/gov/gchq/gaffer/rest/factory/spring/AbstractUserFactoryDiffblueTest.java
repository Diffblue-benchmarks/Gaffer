package uk.gov.gchq.gaffer.rest.factory.spring;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {AbstractUserFactory.class})
@ExtendWith(SpringExtension.class)
class AbstractUserFactoryDiffblueTest {
  @Autowired private AbstractUserFactory abstractUserFactory;

  /**
   * Test {@link AbstractUserFactory#createUser()}.
   *
   * <p>Method under test: {@link AbstractUserFactory#createUser()}
   */
  @Test
  @DisplayName("Test createUser()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"uk.gov.gchq.gaffer.user.User AbstractUserFactory.createUser()"})
  void testCreateUser() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> abstractUserFactory.createUser());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link AbstractUserFactory}
   *   <li>{@link AbstractUserFactory#setHttpHeaders(HttpHeaders)}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AbstractUserFactory.<init>()",
    "void AbstractUserFactory.setHttpHeaders(HttpHeaders)"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    AbstractUserFactory actualAbstractUserFactory = new AbstractUserFactory();
    actualAbstractUserFactory.setHttpHeaders(new HttpHeaders());

    // Assert
    assertTrue(actualAbstractUserFactory.httpHeaders.isEmpty());
  }
}
