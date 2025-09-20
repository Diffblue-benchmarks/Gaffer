package uk.gov.gchq.gaffer.access.predicate.user;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.user.User;
import uk.gov.gchq.gaffer.user.User.Builder;

class DefaultUserPredicateDiffblueTest {
  /**
   * Test {@link DefaultUserPredicate#DefaultUserPredicate(String, List)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultUserPredicate#DefaultUserPredicate(String, List)}
   */
  @Test
  @DisplayName("Test new DefaultUserPredicate(String, List); given '42'; when ArrayList() add '42'")
  @Tag("MaintainedByDiffblue")
  void testNewDefaultUserPredicate_given42_whenArrayListAdd42() {
    // Arrange
    ArrayList<String> auths = new ArrayList<>();
    auths.add("42");
    auths.add("foo");

    // Act
    DefaultUserPredicate actualDefaultUserPredicate = new DefaultUserPredicate("42", auths);

    // Assert
    assertEquals("42", actualDefaultUserPredicate.getCreatingUserId());
    assertEquals(auths, actualDefaultUserPredicate.getAuths());
  }

  /**
   * Test {@link DefaultUserPredicate#DefaultUserPredicate(String, List)}.
   *
   * <ul>
   *   <li>Given {@code foo}.
   *   <li>Then return Auths is {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultUserPredicate#DefaultUserPredicate(String, List)}
   */
  @Test
  @DisplayName(
      "Test new DefaultUserPredicate(String, List); given 'foo'; then return Auths is ArrayList()")
  @Tag("MaintainedByDiffblue")
  void testNewDefaultUserPredicate_givenFoo_thenReturnAuthsIsArrayList() {
    // Arrange
    ArrayList<String> auths = new ArrayList<>();
    auths.add("foo");

    // Act
    DefaultUserPredicate actualDefaultUserPredicate = new DefaultUserPredicate("42", auths);

    // Assert
    assertEquals("42", actualDefaultUserPredicate.getCreatingUserId());
    assertEquals(auths, actualDefaultUserPredicate.getAuths());
  }

  /**
   * Test {@link DefaultUserPredicate#DefaultUserPredicate(String, List)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return Auths Empty.
   * </ul>
   *
   * <p>Method under test: {@link DefaultUserPredicate#DefaultUserPredicate(String, List)}
   */
  @Test
  @DisplayName(
      "Test new DefaultUserPredicate(String, List); when ArrayList(); then return Auths Empty")
  @Tag("MaintainedByDiffblue")
  void testNewDefaultUserPredicate_whenArrayList_thenReturnAuthsEmpty() {
    // Arrange and Act
    DefaultUserPredicate actualDefaultUserPredicate =
        new DefaultUserPredicate("42", new ArrayList<>());

    // Assert
    assertEquals("42", actualDefaultUserPredicate.getCreatingUserId());
    assertTrue(actualDefaultUserPredicate.getAuths().isEmpty());
  }

  /**
   * Test {@link DefaultUserPredicate#DefaultUserPredicate(String, List)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return Auths Empty.
   * </ul>
   *
   * <p>Method under test: {@link DefaultUserPredicate#DefaultUserPredicate(String, List)}
   */
  @Test
  @DisplayName("Test new DefaultUserPredicate(String, List); when 'null'; then return Auths Empty")
  @Tag("MaintainedByDiffblue")
  void testNewDefaultUserPredicate_whenNull_thenReturnAuthsEmpty() {
    // Arrange and Act
    DefaultUserPredicate actualDefaultUserPredicate = new DefaultUserPredicate("42", null);

    // Assert
    assertEquals("42", actualDefaultUserPredicate.getCreatingUserId());
    assertTrue(actualDefaultUserPredicate.getAuths().isEmpty());
  }

  /**
   * Test {@link DefaultUserPredicate#equals(Object)}, and {@link DefaultUserPredicate#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link DefaultUserPredicate#equals(Object)}
   *   <li>{@link DefaultUserPredicate#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    DefaultUserPredicate defaultUserPredicate = new DefaultUserPredicate("42", new ArrayList<>());
    DefaultUserPredicate defaultUserPredicate2 = new DefaultUserPredicate("42", new ArrayList<>());

    // Act and Assert
    assertEquals(defaultUserPredicate, defaultUserPredicate2);
    assertEquals(defaultUserPredicate.hashCode(), defaultUserPredicate2.hashCode());
  }

  /**
   * Test {@link DefaultUserPredicate#equals(Object)}, and {@link DefaultUserPredicate#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link DefaultUserPredicate#equals(Object)}
   *   <li>{@link DefaultUserPredicate#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    DefaultUserPredicate defaultUserPredicate = new DefaultUserPredicate("42", new ArrayList<>());

    // Act and Assert
    assertEquals(defaultUserPredicate, defaultUserPredicate);
    int expectedHashCodeResult = defaultUserPredicate.hashCode();
    assertEquals(expectedHashCodeResult, defaultUserPredicate.hashCode());
  }

  /**
   * Test {@link DefaultUserPredicate#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DefaultUserPredicate#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    DefaultUserPredicate defaultUserPredicate =
        new DefaultUserPredicate("Creating User Id", new ArrayList<>());
    DefaultUserPredicate defaultUserPredicate2 = new DefaultUserPredicate("42", new ArrayList<>());

    // Act and Assert
    assertNotEquals(defaultUserPredicate, defaultUserPredicate2);
  }

  /**
   * Test {@link DefaultUserPredicate#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DefaultUserPredicate#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    DefaultUserPredicate defaultUserPredicate = new DefaultUserPredicate("42", new ArrayList<>());

    // Act and Assert
    assertNotEquals(defaultUserPredicate, null);
  }

  /**
   * Test {@link DefaultUserPredicate#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DefaultUserPredicate#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    DefaultUserPredicate defaultUserPredicate = new DefaultUserPredicate("42", new ArrayList<>());

    // Act and Assert
    assertNotEquals(defaultUserPredicate, "Different type to DefaultUserPredicate");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link DefaultUserPredicate#getAuths()}
   *   <li>{@link DefaultUserPredicate#getCreatingUserId()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  void testGettersAndSetters() {
    // Arrange
    DefaultUserPredicate defaultUserPredicate = new DefaultUserPredicate("42", new ArrayList<>());

    // Act
    List<String> actualAuths = defaultUserPredicate.getAuths();

    // Assert
    assertEquals("42", defaultUserPredicate.getCreatingUserId());
    assertTrue(actualAuths.isEmpty());
  }

  /**
   * Test {@link DefaultUserPredicate#test(User)} with {@code User}.
   *
   * <p>Method under test: {@link DefaultUserPredicate#test(User)}
   */
  @Test
  @DisplayName("Test test(User) with 'User'")
  @Tag("MaintainedByDiffblue")
  void testTestWithUser() {
    // Arrange
    DefaultUserPredicate defaultUserPredicate = new DefaultUserPredicate("", new ArrayList<>());

    // Act and Assert
    assertFalse(defaultUserPredicate.test(new User()));
  }

  /**
   * Test {@link DefaultUserPredicate#test(User)} with {@code User}.
   *
   * <ul>
   *   <li>When {@link User.Builder} (default constructor) userId {@code 42} build.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultUserPredicate#test(User)}
   */
  @Test
  @DisplayName(
      "Test test(User) with 'User'; when Builder (default constructor) userId '42' build; then return 'true'")
  @Tag("MaintainedByDiffblue")
  void testTestWithUser_whenBuilderUserId42Build_thenReturnTrue() {
    // Arrange
    DefaultUserPredicate defaultUserPredicate = new DefaultUserPredicate("42", new ArrayList<>());

    // Act
    boolean actualTestResult = defaultUserPredicate.test(new Builder().userId("42").build());

    // Assert
    assertTrue(actualTestResult);
  }

  /**
   * Test {@link DefaultUserPredicate#test(User)} with {@code User}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultUserPredicate#test(User)}
   */
  @Test
  @DisplayName("Test test(User) with 'User'; when 'null'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  void testTestWithUser_whenNull_thenReturnFalse() {
    // Arrange
    DefaultUserPredicate defaultUserPredicate = new DefaultUserPredicate("42", new ArrayList<>());

    // Act and Assert
    assertFalse(defaultUserPredicate.test(null));
  }

  /**
   * Test {@link DefaultUserPredicate#test(User)} with {@code User}.
   *
   * <ul>
   *   <li>When {@link User#User()}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultUserPredicate#test(User)}
   */
  @Test
  @DisplayName("Test test(User) with 'User'; when User(); then return 'false'")
  @Tag("MaintainedByDiffblue")
  void testTestWithUser_whenUser_thenReturnFalse() {
    // Arrange
    DefaultUserPredicate defaultUserPredicate = new DefaultUserPredicate("42", new ArrayList<>());

    // Act and Assert
    assertFalse(defaultUserPredicate.test(new User()));
  }

  /**
   * Test {@link DefaultUserPredicate#isResourceCreator(User)}.
   *
   * <p>Method under test: {@link DefaultUserPredicate#isResourceCreator(User)}
   */
  @Test
  @DisplayName("Test isResourceCreator(User)")
  @Tag("MaintainedByDiffblue")
  void testIsResourceCreator() {
    // Arrange
    DefaultUserPredicate defaultUserPredicate = new DefaultUserPredicate("", new ArrayList<>());

    // Act and Assert
    assertFalse(defaultUserPredicate.isResourceCreator(new User()));
  }

  /**
   * Test {@link DefaultUserPredicate#isResourceCreator(User)}.
   *
   * <ul>
   *   <li>When {@link User.Builder} (default constructor) userId {@code 42} build.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultUserPredicate#isResourceCreator(User)}
   */
  @Test
  @DisplayName(
      "Test isResourceCreator(User); when Builder (default constructor) userId '42' build; then return 'true'")
  @Tag("MaintainedByDiffblue")
  void testIsResourceCreator_whenBuilderUserId42Build_thenReturnTrue() {
    // Arrange
    DefaultUserPredicate defaultUserPredicate = new DefaultUserPredicate("42", new ArrayList<>());

    // Act
    boolean actualIsResourceCreatorResult =
        defaultUserPredicate.isResourceCreator(new Builder().userId("42").build());

    // Assert
    assertTrue(actualIsResourceCreatorResult);
  }

  /**
   * Test {@link DefaultUserPredicate#isResourceCreator(User)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultUserPredicate#isResourceCreator(User)}
   */
  @Test
  @DisplayName("Test isResourceCreator(User); when 'null'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  void testIsResourceCreator_whenNull_thenReturnFalse() {
    // Arrange
    DefaultUserPredicate defaultUserPredicate = new DefaultUserPredicate("42", new ArrayList<>());

    // Act and Assert
    assertFalse(defaultUserPredicate.isResourceCreator(null));
  }

  /**
   * Test {@link DefaultUserPredicate#isResourceCreator(User)}.
   *
   * <ul>
   *   <li>When {@link User#User()}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultUserPredicate#isResourceCreator(User)}
   */
  @Test
  @DisplayName("Test isResourceCreator(User); when User(); then return 'false'")
  @Tag("MaintainedByDiffblue")
  void testIsResourceCreator_whenUser_thenReturnFalse() {
    // Arrange
    DefaultUserPredicate defaultUserPredicate = new DefaultUserPredicate("42", new ArrayList<>());

    // Act and Assert
    assertFalse(defaultUserPredicate.isResourceCreator(new User()));
  }

  /**
   * Test {@link DefaultUserPredicate#hasPermission(User)}.
   *
   * <ul>
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultUserPredicate#hasPermission(User)}
   */
  @Test
  @DisplayName("Test hasPermission(User); when 'null'")
  @Tag("MaintainedByDiffblue")
  void testHasPermission_whenNull() {
    // Arrange
    DefaultUserPredicate defaultUserPredicate = new DefaultUserPredicate("42", new ArrayList<>());

    // Act and Assert
    assertFalse(defaultUserPredicate.hasPermission(null));
  }

  /**
   * Test {@link DefaultUserPredicate#hasPermission(User)}.
   *
   * <ul>
   *   <li>When {@link User#User()}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultUserPredicate#hasPermission(User)}
   */
  @Test
  @DisplayName("Test hasPermission(User); when User()")
  @Tag("MaintainedByDiffblue")
  void testHasPermission_whenUser() {
    // Arrange
    DefaultUserPredicate defaultUserPredicate = new DefaultUserPredicate("42", new ArrayList<>());

    // Act and Assert
    assertFalse(defaultUserPredicate.hasPermission(new User()));
  }
}
