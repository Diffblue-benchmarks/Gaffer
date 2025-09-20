package uk.gov.gchq.gaffer.access.predicate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import uk.gov.gchq.gaffer.access.predicate.user.DefaultUserPredicate;
import uk.gov.gchq.gaffer.user.User;
import uk.gov.gchq.gaffer.user.User.Builder;

class AccessPredicateDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link AccessPredicate#AccessPredicate(Predicate)}
   *   <li>{@link AccessPredicate#getUserPredicate()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  void testGettersAndSetters() {
    // Arrange
    Predicate<User> userPredicate = mock(Predicate.class);

    // Act and Assert
    assertSame(userPredicate, new AccessPredicate(userPredicate).getUserPredicate());
  }

  /**
   * Test {@link AccessPredicate#AccessPredicate(String, List)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link AccessPredicate#AccessPredicate(String, List)}
   */
  @Test
  @DisplayName("Test new AccessPredicate(String, List); given '42'; when ArrayList() add '42'")
  @Tag("MaintainedByDiffblue")
  void testNewAccessPredicate_given42_whenArrayListAdd42() {
    // Arrange
    ArrayList<String> auths = new ArrayList<>();
    auths.add("42");
    auths.add("foo");

    // Act
    AccessPredicate actualAccessPredicate = new AccessPredicate("42", auths);

    // Assert
    Predicate<User> userPredicate = actualAccessPredicate.getUserPredicate();
    assertTrue(userPredicate instanceof DefaultUserPredicate);
    assertEquals("42", ((DefaultUserPredicate) userPredicate).getCreatingUserId());
    assertEquals(auths, ((DefaultUserPredicate) userPredicate).getAuths());
  }

  /**
   * Test {@link AccessPredicate#AccessPredicate(User, List)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link AccessPredicate#AccessPredicate(User, List)}
   */
  @Test
  @DisplayName("Test new AccessPredicate(User, List); given '42'; when ArrayList() add '42'")
  @Tag("MaintainedByDiffblue")
  void testNewAccessPredicate_given42_whenArrayListAdd422() {
    // Arrange
    User creatingUser = new User();

    ArrayList<String> auths = new ArrayList<>();
    auths.add("42");
    auths.add("foo");

    // Act
    AccessPredicate actualAccessPredicate = new AccessPredicate(creatingUser, auths);

    // Assert
    Predicate<User> userPredicate = actualAccessPredicate.getUserPredicate();
    assertTrue(userPredicate instanceof DefaultUserPredicate);
    assertEquals("UNKNOWN", ((DefaultUserPredicate) userPredicate).getCreatingUserId());
    assertEquals(auths, ((DefaultUserPredicate) userPredicate).getAuths());
  }

  /**
   * Test {@link AccessPredicate#AccessPredicate(String, List)}.
   *
   * <ul>
   *   <li>Given {@code foo}.
   *   <li>Then return UserPredicate Auths is {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link AccessPredicate#AccessPredicate(String, List)}
   */
  @Test
  @DisplayName(
      "Test new AccessPredicate(String, List); given 'foo'; then return UserPredicate Auths is ArrayList()")
  @Tag("MaintainedByDiffblue")
  void testNewAccessPredicate_givenFoo_thenReturnUserPredicateAuthsIsArrayList() {
    // Arrange
    ArrayList<String> auths = new ArrayList<>();
    auths.add("foo");

    // Act
    AccessPredicate actualAccessPredicate = new AccessPredicate("42", auths);

    // Assert
    Predicate<User> userPredicate = actualAccessPredicate.getUserPredicate();
    assertTrue(userPredicate instanceof DefaultUserPredicate);
    assertEquals("42", ((DefaultUserPredicate) userPredicate).getCreatingUserId());
    assertEquals(auths, ((DefaultUserPredicate) userPredicate).getAuths());
  }

  /**
   * Test {@link AccessPredicate#AccessPredicate(User, List)}.
   *
   * <ul>
   *   <li>Given {@code foo}.
   *   <li>Then return UserPredicate Auths is {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link AccessPredicate#AccessPredicate(User, List)}
   */
  @Test
  @DisplayName(
      "Test new AccessPredicate(User, List); given 'foo'; then return UserPredicate Auths is ArrayList()")
  @Tag("MaintainedByDiffblue")
  void testNewAccessPredicate_givenFoo_thenReturnUserPredicateAuthsIsArrayList2() {
    // Arrange
    User creatingUser = new User();

    ArrayList<String> auths = new ArrayList<>();
    auths.add("foo");

    // Act
    AccessPredicate actualAccessPredicate = new AccessPredicate(creatingUser, auths);

    // Assert
    Predicate<User> userPredicate = actualAccessPredicate.getUserPredicate();
    assertTrue(userPredicate instanceof DefaultUserPredicate);
    assertEquals("UNKNOWN", ((DefaultUserPredicate) userPredicate).getCreatingUserId());
    assertEquals(auths, ((DefaultUserPredicate) userPredicate).getAuths());
  }

  /**
   * Test {@link AccessPredicate#AccessPredicate(String, List)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return UserPredicate Auths Empty.
   * </ul>
   *
   * <p>Method under test: {@link AccessPredicate#AccessPredicate(String, List)}
   */
  @Test
  @DisplayName(
      "Test new AccessPredicate(String, List); when ArrayList(); then return UserPredicate Auths Empty")
  @Tag("MaintainedByDiffblue")
  void testNewAccessPredicate_whenArrayList_thenReturnUserPredicateAuthsEmpty() {
    // Arrange and Act
    AccessPredicate actualAccessPredicate = new AccessPredicate("42", new ArrayList<>());

    // Assert
    Predicate<User> userPredicate = actualAccessPredicate.getUserPredicate();
    assertTrue(userPredicate instanceof DefaultUserPredicate);
    assertEquals("42", ((DefaultUserPredicate) userPredicate).getCreatingUserId());
    assertTrue(((DefaultUserPredicate) userPredicate).getAuths().isEmpty());
  }

  /**
   * Test {@link AccessPredicate#AccessPredicate(User, List)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return UserPredicate Auths Empty.
   * </ul>
   *
   * <p>Method under test: {@link AccessPredicate#AccessPredicate(User, List)}
   */
  @Test
  @DisplayName(
      "Test new AccessPredicate(User, List); when ArrayList(); then return UserPredicate Auths Empty")
  @Tag("MaintainedByDiffblue")
  void testNewAccessPredicate_whenArrayList_thenReturnUserPredicateAuthsEmpty2() {
    // Arrange
    User creatingUser = new User();

    // Act
    AccessPredicate actualAccessPredicate = new AccessPredicate(creatingUser, new ArrayList<>());

    // Assert
    Predicate<User> userPredicate = actualAccessPredicate.getUserPredicate();
    assertTrue(userPredicate instanceof DefaultUserPredicate);
    assertEquals("UNKNOWN", ((DefaultUserPredicate) userPredicate).getCreatingUserId());
    assertTrue(((DefaultUserPredicate) userPredicate).getAuths().isEmpty());
  }

  /**
   * Test {@link AccessPredicate#AccessPredicate(String, List)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return UserPredicate Auths Empty.
   * </ul>
   *
   * <p>Method under test: {@link AccessPredicate#AccessPredicate(String, List)}
   */
  @Test
  @DisplayName(
      "Test new AccessPredicate(String, List); when 'null'; then return UserPredicate Auths Empty")
  @Tag("MaintainedByDiffblue")
  void testNewAccessPredicate_whenNull_thenReturnUserPredicateAuthsEmpty() {
    // Arrange and Act
    AccessPredicate actualAccessPredicate = new AccessPredicate("42", null);

    // Assert
    Predicate<User> userPredicate = actualAccessPredicate.getUserPredicate();
    assertTrue(userPredicate instanceof DefaultUserPredicate);
    assertEquals("42", ((DefaultUserPredicate) userPredicate).getCreatingUserId());
    assertTrue(((DefaultUserPredicate) userPredicate).getAuths().isEmpty());
  }

  /**
   * Test {@link AccessPredicate#AccessPredicate(User, List)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return UserPredicate Auths Empty.
   * </ul>
   *
   * <p>Method under test: {@link AccessPredicate#AccessPredicate(User, List)}
   */
  @Test
  @DisplayName(
      "Test new AccessPredicate(User, List); when 'null'; then return UserPredicate Auths Empty")
  @Tag("MaintainedByDiffblue")
  void testNewAccessPredicate_whenNull_thenReturnUserPredicateAuthsEmpty2() {
    // Arrange and Act
    AccessPredicate actualAccessPredicate = new AccessPredicate(new User(), null);

    // Assert
    Predicate<User> userPredicate = actualAccessPredicate.getUserPredicate();
    assertTrue(userPredicate instanceof DefaultUserPredicate);
    assertEquals("UNKNOWN", ((DefaultUserPredicate) userPredicate).getCreatingUserId());
    assertTrue(((DefaultUserPredicate) userPredicate).getAuths().isEmpty());
  }

  /**
   * Test {@link AccessPredicate#test(User, String)} with {@code User}, {@code String}.
   *
   * <p>Method under test: {@link AccessPredicate#test(User, String)}
   */
  @Test
  @DisplayName("Test test(User, String) with 'User', 'String'")
  @Tag("MaintainedByDiffblue")
  void testTestWithUserString() {
    // Arrange
    AccessPredicate accessPredicate = new AccessPredicate("42", new ArrayList<>());

    // Act and Assert
    assertFalse(accessPredicate.test(new User(), "Admin Auth"));
  }

  /**
   * Test {@link AccessPredicate#test(User, String)} with {@code User}, {@code String}.
   *
   * <p>Method under test: {@link AccessPredicate#test(User, String)}
   */
  @Test
  @DisplayName("Test test(User, String) with 'User', 'String'")
  @Tag("MaintainedByDiffblue")
  void testTestWithUserString2() {
    // Arrange
    AccessPredicate accessPredicate = new AccessPredicate("42", new ArrayList<>());

    // Act and Assert
    assertFalse(accessPredicate.test(null, "Admin Auth"));
  }

  /**
   * Test {@link AccessPredicate#test(User, String)} with {@code User}, {@code String}.
   *
   * <p>Method under test: {@link AccessPredicate#test(User, String)}
   */
  @Test
  @DisplayName("Test test(User, String) with 'User', 'String'")
  @Tag("MaintainedByDiffblue")
  void testTestWithUserString3() {
    // Arrange
    AccessPredicate accessPredicate = new AccessPredicate("", new ArrayList<>());

    // Act and Assert
    assertFalse(accessPredicate.test(new User(), "Admin Auth"));
  }

  /**
   * Test {@link AccessPredicate#test(User, String)} with {@code User}, {@code String}.
   *
   * <ul>
   *   <li>Given {@link NoAccessPredicate} (default constructor).
   *   <li>When {@link User#User()}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link AccessPredicate#test(User, String)}
   */
  @Test
  @DisplayName(
      "Test test(User, String) with 'User', 'String'; given NoAccessPredicate (default constructor); when User(); then return 'false'")
  @Tag("MaintainedByDiffblue")
  void testTestWithUserString_givenNoAccessPredicate_whenUser_thenReturnFalse() {
    // Arrange
    NoAccessPredicate noAccessPredicate = new NoAccessPredicate();

    // Act and Assert
    assertFalse(noAccessPredicate.test(new User(), "Admin Auth"));
  }

  /**
   * Test {@link AccessPredicate#test(User, String)} with {@code User}, {@code String}.
   *
   * <ul>
   *   <li>Given {@link Predicate} {@link Predicate#test(Object)} return {@code true}.
   *   <li>When {@code null}.
   *   <li>Then calls {@link Predicate#test(Object)}.
   * </ul>
   *
   * <p>Method under test: {@link AccessPredicate#test(User, String)}
   */
  @Test
  @DisplayName(
      "Test test(User, String) with 'User', 'String'; given Predicate test(Object) return 'true'; when 'null'; then calls test(Object)")
  @Tag("MaintainedByDiffblue")
  void testTestWithUserString_givenPredicateTestReturnTrue_whenNull_thenCallsTest() {
    // Arrange
    Predicate<User> userPredicate = mock(Predicate.class);
    when(userPredicate.test(Mockito.<User>any())).thenReturn(true);

    // Act
    boolean actualTestResult = new AccessPredicate(userPredicate).test(null, "Admin Auth");

    // Assert
    verify(userPredicate).test(isNull());
    assertTrue(actualTestResult);
  }

  /**
   * Test {@link AccessPredicate#test(User, String)} with {@code User}, {@code String}.
   *
   * <ul>
   *   <li>Given {@link Predicate} {@link Predicate#test(Object)} return {@code true}.
   *   <li>When {@code null}.
   *   <li>Then calls {@link Predicate#test(Object)}.
   * </ul>
   *
   * <p>Method under test: {@link AccessPredicate#test(User, String)}
   */
  @Test
  @DisplayName(
      "Test test(User, String) with 'User', 'String'; given Predicate test(Object) return 'true'; when 'null'; then calls test(Object)")
  @Tag("MaintainedByDiffblue")
  void testTestWithUserString_givenPredicateTestReturnTrue_whenNull_thenCallsTest2() {
    // Arrange
    Predicate<User> userPredicate = mock(Predicate.class);
    when(userPredicate.test(Mockito.<User>any())).thenReturn(true);
    AccessPredicate accessPredicate = new AccessPredicate(userPredicate);

    // Act
    boolean actualTestResult = accessPredicate.test(new User(), null);

    // Assert
    verify(userPredicate).test(isA(User.class));
    assertTrue(actualTestResult);
  }

  /**
   * Test {@link AccessPredicate#test(User, String)} with {@code User}, {@code String}.
   *
   * <ul>
   *   <li>Given {@link Predicate} {@link Predicate#test(Object)} return {@code true}.
   *   <li>When {@link User#User()}.
   *   <li>Then calls {@link Predicate#test(Object)}.
   * </ul>
   *
   * <p>Method under test: {@link AccessPredicate#test(User, String)}
   */
  @Test
  @DisplayName(
      "Test test(User, String) with 'User', 'String'; given Predicate test(Object) return 'true'; when User(); then calls test(Object)")
  @Tag("MaintainedByDiffblue")
  void testTestWithUserString_givenPredicateTestReturnTrue_whenUser_thenCallsTest() {
    // Arrange
    Predicate<User> userPredicate = mock(Predicate.class);
    when(userPredicate.test(Mockito.<User>any())).thenReturn(true);
    AccessPredicate accessPredicate = new AccessPredicate(userPredicate);

    // Act
    boolean actualTestResult = accessPredicate.test(new User(), "Admin Auth");

    // Assert
    verify(userPredicate).test(isA(User.class));
    assertTrue(actualTestResult);
  }

  /**
   * Test {@link AccessPredicate#test(User, String)} with {@code User}, {@code String}.
   *
   * <ul>
   *   <li>When {@link User.Builder} (default constructor) userId {@code 42} build.
   * </ul>
   *
   * <p>Method under test: {@link AccessPredicate#test(User, String)}
   */
  @Test
  @DisplayName(
      "Test test(User, String) with 'User', 'String'; when Builder (default constructor) userId '42' build")
  @Tag("MaintainedByDiffblue")
  void testTestWithUserString_whenBuilderUserId42Build() {
    // Arrange
    AccessPredicate accessPredicate = new AccessPredicate("42", new ArrayList<>());

    // Act and Assert
    assertTrue(accessPredicate.test(new Builder().userId("42").build(), "not empty"));
  }

  /**
   * Test {@link AccessPredicate#test(User, String)} with {@code User}, {@code String}.
   *
   * <ul>
   *   <li>When empty string.
   *   <li>Then calls {@link Predicate#test(Object)}.
   * </ul>
   *
   * <p>Method under test: {@link AccessPredicate#test(User, String)}
   */
  @Test
  @DisplayName(
      "Test test(User, String) with 'User', 'String'; when empty string; then calls test(Object)")
  @Tag("MaintainedByDiffblue")
  void testTestWithUserString_whenEmptyString_thenCallsTest() {
    // Arrange
    Predicate<User> userPredicate = mock(Predicate.class);
    when(userPredicate.test(Mockito.<User>any())).thenReturn(true);
    AccessPredicate accessPredicate = new AccessPredicate(userPredicate);

    // Act
    boolean actualTestResult = accessPredicate.test(new User(), "");

    // Assert
    verify(userPredicate).test(isA(User.class));
    assertTrue(actualTestResult);
  }

  /**
   * Test {@link AccessPredicate#isAdministrator(User, String)}.
   *
   * <ul>
   *   <li>When {@code Admin Auth}.
   * </ul>
   *
   * <p>Method under test: {@link AccessPredicate#isAdministrator(User, String)}
   */
  @Test
  @DisplayName("Test isAdministrator(User, String); when 'Admin Auth'")
  @Tag("MaintainedByDiffblue")
  void testIsAdministrator_whenAdminAuth() {
    // Arrange
    AccessPredicate accessPredicate = new AccessPredicate(mock(Predicate.class));

    // Act and Assert
    assertFalse(accessPredicate.isAdministrator(new User(), "Admin Auth"));
  }

  /**
   * Test {@link AccessPredicate#isAdministrator(User, String)}.
   *
   * <ul>
   *   <li>When empty string.
   * </ul>
   *
   * <p>Method under test: {@link AccessPredicate#isAdministrator(User, String)}
   */
  @Test
  @DisplayName("Test isAdministrator(User, String); when empty string")
  @Tag("MaintainedByDiffblue")
  void testIsAdministrator_whenEmptyString() {
    // Arrange
    AccessPredicate accessPredicate = new AccessPredicate(mock(Predicate.class));

    // Act and Assert
    assertFalse(accessPredicate.isAdministrator(new User(), ""));
  }

  /**
   * Test {@link AccessPredicate#isAdministrator(User, String)}.
   *
   * <ul>
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link AccessPredicate#isAdministrator(User, String)}
   */
  @Test
  @DisplayName("Test isAdministrator(User, String); when 'null'")
  @Tag("MaintainedByDiffblue")
  void testIsAdministrator_whenNull() {
    // Arrange
    AccessPredicate accessPredicate = new AccessPredicate(mock(Predicate.class));

    // Act and Assert
    assertFalse(accessPredicate.isAdministrator(new User(), null));
  }

  /**
   * Test {@link AccessPredicate#isAdministrator(User, String)}.
   *
   * <ul>
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link AccessPredicate#isAdministrator(User, String)}
   */
  @Test
  @DisplayName("Test isAdministrator(User, String); when 'null'")
  @Tag("MaintainedByDiffblue")
  void testIsAdministrator_whenNull2() {
    // Arrange, Act and Assert
    assertFalse(new AccessPredicate(mock(Predicate.class)).isAdministrator(null, "Admin Auth"));
  }

  /**
   * Test {@link AccessPredicate#equals(Object)}, and {@link AccessPredicate#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link AccessPredicate#equals(Object)}
   *   <li>{@link AccessPredicate#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    AccessPredicate accessPredicate = new AccessPredicate(null);
    AccessPredicate accessPredicate2 = new AccessPredicate(null);

    // Act and Assert
    assertEquals(accessPredicate, accessPredicate2);
    assertEquals(accessPredicate.hashCode(), accessPredicate2.hashCode());
  }

  /**
   * Test {@link AccessPredicate#equals(Object)}, and {@link AccessPredicate#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link AccessPredicate#equals(Object)}
   *   <li>{@link AccessPredicate#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    AccessPredicate accessPredicate = new AccessPredicate(mock(Predicate.class));

    // Act and Assert
    assertEquals(accessPredicate, accessPredicate);
    int expectedHashCodeResult = accessPredicate.hashCode();
    assertEquals(expectedHashCodeResult, accessPredicate.hashCode());
  }

  /**
   * Test {@link AccessPredicate#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AccessPredicate#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    AccessPredicate accessPredicate = new AccessPredicate(mock(Predicate.class));

    // Act and Assert
    assertNotEquals(accessPredicate, new AccessPredicate(mock(Predicate.class)));
  }

  /**
   * Test {@link AccessPredicate#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AccessPredicate#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new AccessPredicate(mock(Predicate.class)), null);
  }

  /**
   * Test {@link AccessPredicate#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AccessPredicate#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        new AccessPredicate(mock(Predicate.class)), "Different type to AccessPredicate");
  }
}
