package uk.gov.gchq.gaffer.data.elementdefinition.view.access.predicate.user;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.user.User;
import uk.gov.gchq.gaffer.user.User.Builder;

class NamedViewWriteUserPredicateDiffblueTest {
  /**
   * Test {@link NamedViewWriteUserPredicate#NamedViewWriteUserPredicate(String, List)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link NamedViewWriteUserPredicate#NamedViewWriteUserPredicate(String,
   * List)}
   */
  @Test
  @DisplayName(
      "Test new NamedViewWriteUserPredicate(String, List); given '42'; when ArrayList() add '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void NamedViewWriteUserPredicate.<init>(String, List)"})
  void testNewNamedViewWriteUserPredicate_given42_whenArrayListAdd42() {
    // Arrange
    ArrayList<String> auths = new ArrayList<>();
    auths.add("42");
    auths.add("foo");

    // Act
    NamedViewWriteUserPredicate actualNamedViewWriteUserPredicate =
        new NamedViewWriteUserPredicate("42", auths);

    // Assert
    assertEquals("42", actualNamedViewWriteUserPredicate.getCreatingUserId());
    assertEquals(auths, actualNamedViewWriteUserPredicate.getAuths());
  }

  /**
   * Test {@link NamedViewWriteUserPredicate#NamedViewWriteUserPredicate(String, List)}.
   *
   * <ul>
   *   <li>Given {@code foo}.
   *   <li>Then return Auths is {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link NamedViewWriteUserPredicate#NamedViewWriteUserPredicate(String,
   * List)}
   */
  @Test
  @DisplayName(
      "Test new NamedViewWriteUserPredicate(String, List); given 'foo'; then return Auths is ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void NamedViewWriteUserPredicate.<init>(String, List)"})
  void testNewNamedViewWriteUserPredicate_givenFoo_thenReturnAuthsIsArrayList() {
    // Arrange
    ArrayList<String> auths = new ArrayList<>();
    auths.add("foo");

    // Act
    NamedViewWriteUserPredicate actualNamedViewWriteUserPredicate =
        new NamedViewWriteUserPredicate("42", auths);

    // Assert
    assertEquals("42", actualNamedViewWriteUserPredicate.getCreatingUserId());
    assertEquals(auths, actualNamedViewWriteUserPredicate.getAuths());
  }

  /**
   * Test {@link NamedViewWriteUserPredicate#NamedViewWriteUserPredicate(String, List)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return Auths Empty.
   * </ul>
   *
   * <p>Method under test: {@link NamedViewWriteUserPredicate#NamedViewWriteUserPredicate(String,
   * List)}
   */
  @Test
  @DisplayName(
      "Test new NamedViewWriteUserPredicate(String, List); when ArrayList(); then return Auths Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void NamedViewWriteUserPredicate.<init>(String, List)"})
  void testNewNamedViewWriteUserPredicate_whenArrayList_thenReturnAuthsEmpty() {
    // Arrange and Act
    NamedViewWriteUserPredicate actualNamedViewWriteUserPredicate =
        new NamedViewWriteUserPredicate("42", new ArrayList<>());

    // Assert
    assertEquals("42", actualNamedViewWriteUserPredicate.getCreatingUserId());
    assertTrue(actualNamedViewWriteUserPredicate.getAuths().isEmpty());
  }

  /**
   * Test {@link NamedViewWriteUserPredicate#NamedViewWriteUserPredicate(String, List)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return Auths Empty.
   * </ul>
   *
   * <p>Method under test: {@link NamedViewWriteUserPredicate#NamedViewWriteUserPredicate(String,
   * List)}
   */
  @Test
  @DisplayName(
      "Test new NamedViewWriteUserPredicate(String, List); when 'null'; then return Auths Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void NamedViewWriteUserPredicate.<init>(String, List)"})
  void testNewNamedViewWriteUserPredicate_whenNull_thenReturnAuthsEmpty() {
    // Arrange and Act
    NamedViewWriteUserPredicate actualNamedViewWriteUserPredicate =
        new NamedViewWriteUserPredicate("42", null);

    // Assert
    assertEquals("42", actualNamedViewWriteUserPredicate.getCreatingUserId());
    assertTrue(actualNamedViewWriteUserPredicate.getAuths().isEmpty());
  }

  /**
   * Test {@link NamedViewWriteUserPredicate#isResourceCreator(User)}.
   *
   * <ul>
   *   <li>When {@link User.Builder} (default constructor) userId {@code 42} build.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link NamedViewWriteUserPredicate#isResourceCreator(User)}
   */
  @Test
  @DisplayName(
      "Test isResourceCreator(User); when Builder (default constructor) userId '42' build; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean NamedViewWriteUserPredicate.isResourceCreator(User)"})
  void testIsResourceCreator_whenBuilderUserId42Build_thenReturnTrue() {
    // Arrange
    NamedViewWriteUserPredicate namedViewWriteUserPredicate =
        new NamedViewWriteUserPredicate("42", new ArrayList<>());

    // Act
    boolean actualIsResourceCreatorResult =
        namedViewWriteUserPredicate.isResourceCreator(new Builder().userId("42").build());

    // Assert
    assertTrue(actualIsResourceCreatorResult);
  }

  /**
   * Test {@link NamedViewWriteUserPredicate#isResourceCreator(User)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link NamedViewWriteUserPredicate#isResourceCreator(User)}
   */
  @Test
  @DisplayName("Test isResourceCreator(User); when 'null'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean NamedViewWriteUserPredicate.isResourceCreator(User)"})
  void testIsResourceCreator_whenNull_thenReturnFalse() {
    // Arrange
    NamedViewWriteUserPredicate namedViewWriteUserPredicate =
        new NamedViewWriteUserPredicate("42", new ArrayList<>());

    // Act and Assert
    assertFalse(namedViewWriteUserPredicate.isResourceCreator(null));
  }

  /**
   * Test {@link NamedViewWriteUserPredicate#isResourceCreator(User)}.
   *
   * <ul>
   *   <li>When {@link User#User()}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link NamedViewWriteUserPredicate#isResourceCreator(User)}
   */
  @Test
  @DisplayName("Test isResourceCreator(User); when User(); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean NamedViewWriteUserPredicate.isResourceCreator(User)"})
  void testIsResourceCreator_whenUser_thenReturnFalse() {
    // Arrange
    NamedViewWriteUserPredicate namedViewWriteUserPredicate =
        new NamedViewWriteUserPredicate("42", new ArrayList<>());

    // Act and Assert
    assertFalse(namedViewWriteUserPredicate.isResourceCreator(new User()));
  }
}
