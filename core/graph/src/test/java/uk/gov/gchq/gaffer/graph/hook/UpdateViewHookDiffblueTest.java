package uk.gov.gchq.gaffer.graph.hook;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.UnsupportedEncodingException;
import java.util.AbstractMap;
import java.util.AbstractMap.SimpleEntry;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.data.elementdefinition.exception.SchemaException;
import uk.gov.gchq.gaffer.data.elementdefinition.view.NamedView;
import uk.gov.gchq.gaffer.data.elementdefinition.view.View;
import uk.gov.gchq.gaffer.data.elementdefinition.view.ViewElementDefinition;
import uk.gov.gchq.gaffer.graph.hook.UpdateViewHook.Builder;
import uk.gov.gchq.gaffer.operation.OperationChain;
import uk.gov.gchq.gaffer.operation.export.graph.ExportToOtherAuthorisedGraph;
import uk.gov.gchq.gaffer.operation.graph.OperationView;
import uk.gov.gchq.gaffer.operation.impl.get.GetElements;
import uk.gov.gchq.gaffer.store.Context;
import uk.gov.gchq.gaffer.user.User;

class UpdateViewHookDiffblueTest {
  /**
   * Test Builder {@link Builder#build()}.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Builder#build()}
   *   <li>default or parameterless constructor of {@link Builder}
   *   <li>{@link Builder#blackListElementGroups(Set)}
   *   <li>{@link Builder#setViewToMerge(View)}
   *   <li>{@link Builder#whiteListElementGroups(Set)}
   *   <li>{@link Builder#withDataAuth(Set)}
   *   <li>{@link Builder#withOpAuth(Set)}
   *   <li>{@link Builder#withoutDataAuth(Set)}
   *   <li>{@link Builder#withoutOpAuth(Set)}
   * </ul>
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void Builder.<init>()",
    "Builder Builder.addExtraGroups(boolean)",
    "Builder Builder.blackListElementGroups(Set)",
    "UpdateViewHook Builder.build()",
    "Builder Builder.setViewToMerge(View)",
    "Builder Builder.whiteListElementGroups(Set)",
    "Builder Builder.withDataAuth(Set)",
    "Builder Builder.withOpAuth(Set)",
    "Builder Builder.withoutDataAuth(Set)",
    "Builder Builder.withoutOpAuth(Set)"
  })
  void testBuilderBuild() {
    // Arrange and Act
    Builder actualBuilder = new Builder();
    HashSet<String> blackListElementGroups = new HashSet<>();
    Builder actualBlackListElementGroupsResult =
        actualBuilder.blackListElementGroups(blackListElementGroups);
    View viewToMerge = new View();
    Builder actualSetViewToMergeResult =
        actualBlackListElementGroupsResult.setViewToMerge(viewToMerge);
    HashSet<String> whiteListElementGroups = new HashSet<>();
    Builder actualWhiteListElementGroupsResult =
        actualSetViewToMergeResult.whiteListElementGroups(whiteListElementGroups);
    HashSet<String> withDataAuths = new HashSet<>();
    Builder actualWithDataAuthResult =
        actualWhiteListElementGroupsResult.withDataAuth(withDataAuths);
    HashSet<String> withOpAuth = new HashSet<>();
    Builder actualWithOpAuthResult = actualWithDataAuthResult.withOpAuth(withOpAuth);
    HashSet<String> withoutDataAuth = new HashSet<>();
    Builder actualWithoutDataAuthResult = actualWithOpAuthResult.withoutDataAuth(withoutDataAuth);
    HashSet<String> withoutOpAuth = new HashSet<>();
    UpdateViewHook actualUpdateViewHook =
        actualWithoutDataAuthResult.withoutOpAuth(withoutOpAuth).build();

    // Assert
    assertFalse(actualUpdateViewHook.isAddExtraGroups());
    Set<String> blackListElementGroups2 = actualUpdateViewHook.getBlackListElementGroups();
    assertTrue(blackListElementGroups2.isEmpty());
    Set<String> whiteListElementGroups2 = actualUpdateViewHook.getWhiteListElementGroups();
    assertTrue(whiteListElementGroups2.isEmpty());
    Set<String> withDataAuth = actualUpdateViewHook.getWithDataAuth();
    assertTrue(withDataAuth.isEmpty());
    Set<String> withOpAuth2 = actualUpdateViewHook.getWithOpAuth();
    assertTrue(withOpAuth2.isEmpty());
    Set<String> withoutDataAuth2 = actualUpdateViewHook.getWithoutDataAuth();
    assertTrue(withoutDataAuth2.isEmpty());
    Set<String> withoutOpAuth2 = actualUpdateViewHook.getWithoutOpAuth();
    assertTrue(withoutOpAuth2.isEmpty());
    assertEquals(viewToMerge, actualUpdateViewHook.getViewToMerge());
    assertSame(blackListElementGroups, blackListElementGroups2);
    assertSame(whiteListElementGroups, whiteListElementGroups2);
    assertSame(withDataAuths, withDataAuth);
    assertSame(withOpAuth, withOpAuth2);
    assertSame(withoutDataAuth, withoutDataAuth2);
    assertSame(withoutOpAuth, withoutOpAuth2);
  }

  /**
   * Test {@link UpdateViewHook#removeElementGroups(Entry)}.
   *
   * <ul>
   *   <li>Given {@link HashSet#HashSet()} add {@code foo}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link UpdateViewHook#removeElementGroups(Entry)}
   */
  @Test
  @DisplayName("Test removeElementGroups(Entry); given HashSet() add 'foo'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean UpdateViewHook.removeElementGroups(Entry)"})
  void testRemoveElementGroups_givenHashSetAddFoo_thenReturnFalse() {
    // Arrange
    HashSet<String> whiteListElementGroups = new HashSet<>();
    whiteListElementGroups.add("foo");

    Builder builder = new Builder();

    Builder blackListElementGroupsResult = builder.blackListElementGroups(new HashSet<>());

    Builder whiteListElementGroupsResult =
        blackListElementGroupsResult
            .setViewToMerge(new View())
            .whiteListElementGroups(whiteListElementGroups);

    Builder withDataAuthResult = whiteListElementGroupsResult.withDataAuth(new HashSet<>());

    Builder withOpAuthResult = withDataAuthResult.withOpAuth(new HashSet<>());

    Builder withoutDataAuthResult = withOpAuthResult.withoutDataAuth(new HashSet<>());
    UpdateViewHook updateViewHook = withoutDataAuthResult.withoutOpAuth(new HashSet<>()).build();
    SimpleEntry<String, ViewElementDefinition> entry =
        new SimpleEntry<>("foo", new ViewElementDefinition());

    // Act
    boolean actualRemoveElementGroupsResult = updateViewHook.removeElementGroups(entry);

    // Assert
    assertFalse(actualRemoveElementGroupsResult);
  }

  /**
   * Test {@link UpdateViewHook#removeElementGroups(Entry)}.
   *
   * <ul>
   *   <li>Given {@link UpdateViewHook} (default constructor) WhiteListElementGroups is {@code
   *       null}.
   * </ul>
   *
   * <p>Method under test: {@link UpdateViewHook#removeElementGroups(Entry)}
   */
  @Test
  @DisplayName(
      "Test removeElementGroups(Entry); given UpdateViewHook (default constructor) WhiteListElementGroups is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean UpdateViewHook.removeElementGroups(Entry)"})
  void testRemoveElementGroups_givenUpdateViewHookWhiteListElementGroupsIsNull() {
    // Arrange
    UpdateViewHook updateViewHook = new UpdateViewHook();
    updateViewHook.setWhiteListElementGroups(null);
    updateViewHook.setBlackListElementGroups(new HashSet<>());
    SimpleEntry<String, ViewElementDefinition> entry =
        new SimpleEntry<>("foo", new ViewElementDefinition());

    // Act
    boolean actualRemoveElementGroupsResult = updateViewHook.removeElementGroups(entry);

    // Assert
    assertFalse(actualRemoveElementGroupsResult);
  }

  /**
   * Test {@link UpdateViewHook#removeElementGroups(Entry)}.
   *
   * <ul>
   *   <li>Given {@link UpdateViewHook} (default constructor).
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link UpdateViewHook#removeElementGroups(Entry)}
   */
  @Test
  @DisplayName(
      "Test removeElementGroups(Entry); given UpdateViewHook (default constructor); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean UpdateViewHook.removeElementGroups(Entry)"})
  void testRemoveElementGroups_givenUpdateViewHook_thenReturnFalse() {
    // Arrange
    UpdateViewHook updateViewHook = new UpdateViewHook();
    SimpleEntry<String, ViewElementDefinition> entry =
        new SimpleEntry<>("foo", new ViewElementDefinition());

    // Act
    boolean actualRemoveElementGroupsResult = updateViewHook.removeElementGroups(entry);

    // Assert
    assertFalse(actualRemoveElementGroupsResult);
  }

  /**
   * Test {@link UpdateViewHook#removeElementGroups(Entry)}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link UpdateViewHook#removeElementGroups(Entry)}
   */
  @Test
  @DisplayName("Test removeElementGroups(Entry); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean UpdateViewHook.removeElementGroups(Entry)"})
  void testRemoveElementGroups_thenReturnTrue() {
    // Arrange
    Builder builder = new Builder();

    Builder blackListElementGroupsResult = builder.blackListElementGroups(new HashSet<>());

    Builder setViewToMergeResult = blackListElementGroupsResult.setViewToMerge(new View());

    Builder whiteListElementGroupsResult =
        setViewToMergeResult.whiteListElementGroups(new HashSet<>());

    Builder withDataAuthResult = whiteListElementGroupsResult.withDataAuth(new HashSet<>());

    Builder withOpAuthResult = withDataAuthResult.withOpAuth(new HashSet<>());

    Builder withoutDataAuthResult = withOpAuthResult.withoutDataAuth(new HashSet<>());
    UpdateViewHook updateViewHook = withoutDataAuthResult.withoutOpAuth(new HashSet<>()).build();
    SimpleEntry<String, ViewElementDefinition> entry =
        new SimpleEntry<>("foo", new ViewElementDefinition());

    // Act
    boolean actualRemoveElementGroupsResult = updateViewHook.removeElementGroups(entry);

    // Assert
    assertTrue(actualRemoveElementGroupsResult);
  }

  /**
   * Test {@link UpdateViewHook#applyToUser(User)}.
   *
   * <p>Method under test: {@link UpdateViewHook#applyToUser(User)}
   */
  @Test
  @DisplayName("Test applyToUser(User)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean UpdateViewHook.applyToUser(User)"})
  void testApplyToUser() {
    // Arrange
    Builder builder = new Builder();

    Builder blackListElementGroupsResult = builder.blackListElementGroups(new HashSet<>());

    Builder setViewToMergeResult = blackListElementGroupsResult.setViewToMerge(new View());

    Builder whiteListElementGroupsResult =
        setViewToMergeResult.whiteListElementGroups(new HashSet<>());

    Builder withDataAuthResult = whiteListElementGroupsResult.withDataAuth(new HashSet<>());

    Builder withOpAuthResult = withDataAuthResult.withOpAuth(new HashSet<>());

    Builder withoutDataAuthResult = withOpAuthResult.withoutDataAuth(new HashSet<>());
    UpdateViewHook updateViewHook = withoutDataAuthResult.withoutOpAuth(new HashSet<>()).build();

    // Act
    boolean actualApplyToUserResult =
        updateViewHook.applyToUser(new User.Builder().userId("42").build());

    // Assert
    assertFalse(actualApplyToUserResult);
  }

  /**
   * Test {@link UpdateViewHook#applyToUser(User)}.
   *
   * <ul>
   *   <li>Given {@link HashSet#HashSet()} add {@code foo}.
   *   <li>When {@link User.Builder} (default constructor) userId {@code 42} build.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link UpdateViewHook#applyToUser(User)}
   */
  @Test
  @DisplayName(
      "Test applyToUser(User); given HashSet() add 'foo'; when Builder (default constructor) userId '42' build; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean UpdateViewHook.applyToUser(User)"})
  void testApplyToUser_givenHashSetAddFoo_whenBuilderUserId42Build_thenReturnFalse() {
    // Arrange
    HashSet<String> withDataAuths = new HashSet<>();
    withDataAuths.add("foo");

    Builder builder = new Builder();

    Builder blackListElementGroupsResult = builder.blackListElementGroups(new HashSet<>());

    Builder setViewToMergeResult = blackListElementGroupsResult.setViewToMerge(new View());

    Builder withDataAuthResult =
        setViewToMergeResult.whiteListElementGroups(new HashSet<>()).withDataAuth(withDataAuths);

    Builder withOpAuthResult = withDataAuthResult.withOpAuth(new HashSet<>());

    Builder withoutDataAuthResult = withOpAuthResult.withoutDataAuth(new HashSet<>());
    UpdateViewHook updateViewHook = withoutDataAuthResult.withoutOpAuth(new HashSet<>()).build();

    // Act
    boolean actualApplyToUserResult =
        updateViewHook.applyToUser(new User.Builder().userId("42").build());

    // Assert
    assertFalse(actualApplyToUserResult);
  }

  /**
   * Test {@link UpdateViewHook#applyToUser(User)}.
   *
   * <ul>
   *   <li>Given {@link UpdateViewHook} (default constructor) WithDataAuth is {@code null}.
   *   <li>When {@link User#User()}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link UpdateViewHook#applyToUser(User)}
   */
  @Test
  @DisplayName(
      "Test applyToUser(User); given UpdateViewHook (default constructor) WithDataAuth is 'null'; when User(); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean UpdateViewHook.applyToUser(User)"})
  void testApplyToUser_givenUpdateViewHookWithDataAuthIsNull_whenUser_thenReturnFalse() {
    // Arrange
    UpdateViewHook updateViewHook = new UpdateViewHook();
    updateViewHook.setWithDataAuth(null);
    updateViewHook.setWithOpAuth(new HashSet<>());
    updateViewHook.setWithoutDataAuth(null);
    updateViewHook.setWithoutOpAuth(null);

    // Act and Assert
    assertFalse(updateViewHook.applyToUser(new User()));
  }

  /**
   * Test {@link UpdateViewHook#applyToUser(User)}.
   *
   * <ul>
   *   <li>Given {@link UpdateViewHook} (default constructor).
   *   <li>When {@link User#User()}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link UpdateViewHook#applyToUser(User)}
   */
  @Test
  @DisplayName(
      "Test applyToUser(User); given UpdateViewHook (default constructor); when User(); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean UpdateViewHook.applyToUser(User)"})
  void testApplyToUser_givenUpdateViewHook_whenUser_thenReturnTrue() {
    // Arrange
    UpdateViewHook updateViewHook = new UpdateViewHook();

    // Act and Assert
    assertTrue(updateViewHook.applyToUser(new User()));
  }

  /**
   * Test {@link UpdateViewHook#validateAuths(Set, Set, boolean)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link HashSet#HashSet()} add {@code 42}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link UpdateViewHook#validateAuths(Set, Set, boolean)}
   */
  @Test
  @DisplayName(
      "Test validateAuths(Set, Set, boolean); given '42'; when HashSet() add '42'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean UpdateViewHook.validateAuths(Set, Set, boolean)"})
  void testValidateAuths_given42_whenHashSetAdd42_thenReturnFalse() {
    // Arrange
    UpdateViewHook updateViewHook = new UpdateViewHook();

    HashSet<String> userAuths = new HashSet<>();
    userAuths.add("42");
    userAuths.add("foo");

    // Act and Assert
    assertFalse(updateViewHook.validateAuths(userAuths, new HashSet<>(), true));
  }

  /**
   * Test {@link UpdateViewHook#validateAuths(Set, Set, boolean)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link HashSet#HashSet()} add {@code 42}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link UpdateViewHook#validateAuths(Set, Set, boolean)}
   */
  @Test
  @DisplayName(
      "Test validateAuths(Set, Set, boolean); given '42'; when HashSet() add '42'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean UpdateViewHook.validateAuths(Set, Set, boolean)"})
  void testValidateAuths_given42_whenHashSetAdd42_thenReturnFalse2() {
    // Arrange
    UpdateViewHook updateViewHook = new UpdateViewHook();
    HashSet<String> userAuths = new HashSet<>();

    HashSet<String> validAuth = new HashSet<>();
    validAuth.add("42");
    validAuth.add("foo");

    // Act and Assert
    assertFalse(updateViewHook.validateAuths(userAuths, validAuth, true));
  }

  /**
   * Test {@link UpdateViewHook#validateAuths(Set, Set, boolean)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link HashSet#HashSet()} add {@code 42}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link UpdateViewHook#validateAuths(Set, Set, boolean)}
   */
  @Test
  @DisplayName(
      "Test validateAuths(Set, Set, boolean); given '42'; when HashSet() add '42'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean UpdateViewHook.validateAuths(Set, Set, boolean)"})
  void testValidateAuths_given42_whenHashSetAdd42_thenReturnFalse3() {
    // Arrange
    UpdateViewHook updateViewHook = new UpdateViewHook();

    HashSet<String> userAuths = new HashSet<>();
    userAuths.add("foo");

    HashSet<String> validAuth = new HashSet<>();
    validAuth.add("42");

    // Act and Assert
    assertFalse(updateViewHook.validateAuths(userAuths, validAuth, true));
  }

  /**
   * Test {@link UpdateViewHook#validateAuths(Set, Set, boolean)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link HashSet#HashSet()} add {@code 42}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link UpdateViewHook#validateAuths(Set, Set, boolean)}
   */
  @Test
  @DisplayName(
      "Test validateAuths(Set, Set, boolean); given '42'; when HashSet() add '42'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean UpdateViewHook.validateAuths(Set, Set, boolean)"})
  void testValidateAuths_given42_whenHashSetAdd42_thenReturnTrue() {
    // Arrange
    UpdateViewHook updateViewHook = new UpdateViewHook();

    HashSet<String> userAuths = new HashSet<>();
    userAuths.add("foo");

    HashSet<String> validAuth = new HashSet<>();
    validAuth.add("42");
    validAuth.add("foo");

    // Act and Assert
    assertTrue(updateViewHook.validateAuths(userAuths, validAuth, true));
  }

  /**
   * Test {@link UpdateViewHook#validateAuths(Set, Set, boolean)}.
   *
   * <ul>
   *   <li>Given empty string.
   *   <li>When {@link HashSet#HashSet()} add empty string.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link UpdateViewHook#validateAuths(Set, Set, boolean)}
   */
  @Test
  @DisplayName(
      "Test validateAuths(Set, Set, boolean); given empty string; when HashSet() add empty string; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean UpdateViewHook.validateAuths(Set, Set, boolean)"})
  void testValidateAuths_givenEmptyString_whenHashSetAddEmptyString_thenReturnFalse() {
    // Arrange
    UpdateViewHook updateViewHook = new UpdateViewHook();

    HashSet<String> userAuths = new HashSet<>();
    userAuths.add("");

    HashSet<String> validAuth = new HashSet<>();
    validAuth.add("42");
    validAuth.add("foo");

    // Act and Assert
    assertFalse(updateViewHook.validateAuths(userAuths, validAuth, true));
  }

  /**
   * Test {@link UpdateViewHook#validateAuths(Set, Set, boolean)}.
   *
   * <ul>
   *   <li>Given {@code foo}.
   *   <li>When {@link HashSet#HashSet()} add {@code foo}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link UpdateViewHook#validateAuths(Set, Set, boolean)}
   */
  @Test
  @DisplayName(
      "Test validateAuths(Set, Set, boolean); given 'foo'; when HashSet() add 'foo'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean UpdateViewHook.validateAuths(Set, Set, boolean)"})
  void testValidateAuths_givenFoo_whenHashSetAddFoo_thenReturnTrue() {
    // Arrange
    UpdateViewHook updateViewHook = new UpdateViewHook();

    HashSet<String> userAuths = new HashSet<>();
    userAuths.add("foo");

    HashSet<String> validAuth = new HashSet<>();
    validAuth.add("foo");

    // Act and Assert
    assertTrue(updateViewHook.validateAuths(userAuths, validAuth, true));
  }

  /**
   * Test {@link UpdateViewHook#validateAuths(Set, Set, boolean)}.
   *
   * <ul>
   *   <li>Given {@code foo}.
   *   <li>When {@link HashSet#HashSet()}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link UpdateViewHook#validateAuths(Set, Set, boolean)}
   */
  @Test
  @DisplayName(
      "Test validateAuths(Set, Set, boolean); given 'foo'; when HashSet(); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean UpdateViewHook.validateAuths(Set, Set, boolean)"})
  void testValidateAuths_givenFoo_whenHashSet_thenReturnFalse() {
    // Arrange
    UpdateViewHook updateViewHook = new UpdateViewHook();

    HashSet<String> userAuths = new HashSet<>();
    userAuths.add("foo");

    // Act and Assert
    assertFalse(updateViewHook.validateAuths(userAuths, new HashSet<>(), true));
  }

  /**
   * Test {@link UpdateViewHook#validateAuths(Set, Set, boolean)}.
   *
   * <ul>
   *   <li>Given {@code foo}.
   *   <li>When {@link HashSet#HashSet()}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link UpdateViewHook#validateAuths(Set, Set, boolean)}
   */
  @Test
  @DisplayName(
      "Test validateAuths(Set, Set, boolean); given 'foo'; when HashSet(); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean UpdateViewHook.validateAuths(Set, Set, boolean)"})
  void testValidateAuths_givenFoo_whenHashSet_thenReturnFalse2() {
    // Arrange
    UpdateViewHook updateViewHook = new UpdateViewHook();
    HashSet<String> userAuths = new HashSet<>();

    HashSet<String> validAuth = new HashSet<>();
    validAuth.add("foo");

    // Act and Assert
    assertFalse(updateViewHook.validateAuths(userAuths, validAuth, true));
  }

  /**
   * Test {@link UpdateViewHook#validateAuths(Set, Set, boolean)}.
   *
   * <ul>
   *   <li>When {@link HashSet#HashSet()}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link UpdateViewHook#validateAuths(Set, Set, boolean)}
   */
  @Test
  @DisplayName("Test validateAuths(Set, Set, boolean); when HashSet(); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean UpdateViewHook.validateAuths(Set, Set, boolean)"})
  void testValidateAuths_whenHashSet_thenReturnFalse() {
    // Arrange
    UpdateViewHook updateViewHook = new UpdateViewHook();
    HashSet<String> userAuths = new HashSet<>();

    // Act and Assert
    assertFalse(updateViewHook.validateAuths(userAuths, new HashSet<>(), true));
  }

  /**
   * Test {@link UpdateViewHook#validateAuths(Set, Set, boolean)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link UpdateViewHook#validateAuths(Set, Set, boolean)}
   */
  @Test
  @DisplayName("Test validateAuths(Set, Set, boolean); when 'null'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean UpdateViewHook.validateAuths(Set, Set, boolean)"})
  void testValidateAuths_whenNull_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(new UpdateViewHook().validateAuths(null, null, true));
  }

  /**
   * Test {@link UpdateViewHook#validateAuths(Set, Set, boolean)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link UpdateViewHook#validateAuths(Set, Set, boolean)}
   */
  @Test
  @DisplayName("Test validateAuths(Set, Set, boolean); when 'null'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean UpdateViewHook.validateAuths(Set, Set, boolean)"})
  void testValidateAuths_whenNull_thenReturnTrue2() {
    // Arrange
    UpdateViewHook updateViewHook = new UpdateViewHook();

    // Act and Assert
    assertTrue(updateViewHook.validateAuths(null, new HashSet<>(), true));
  }

  /**
   * Test {@link UpdateViewHook#postExecute(Object, OperationChain, Context)}.
   *
   * <p>Method under test: {@link UpdateViewHook#postExecute(Object, OperationChain, Context)}
   */
  @Test
  @DisplayName("Test postExecute(Object, OperationChain, Context)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object UpdateViewHook.postExecute(Object, OperationChain, Context)"})
  void testPostExecute() {
    // Arrange
    UpdateViewHook updateViewHook = new UpdateViewHook();
    OperationChain<?> opChain = OperationChain.wrap(new ExportToOtherAuthorisedGraph());

    // Act and Assert
    assertEquals("Result", updateViewHook.postExecute("Result", opChain, new Context()));
  }

  /**
   * Test {@link UpdateViewHook#onFailure(Object, OperationChain, Context, Exception)}.
   *
   * <p>Method under test: {@link UpdateViewHook#onFailure(Object, OperationChain, Context,
   * Exception)}
   */
  @Test
  @DisplayName("Test onFailure(Object, OperationChain, Context, Exception)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object UpdateViewHook.onFailure(Object, OperationChain, Context, Exception)"})
  void testOnFailure() {
    // Arrange
    UpdateViewHook updateViewHook = new UpdateViewHook();
    OperationChain<?> opChain = OperationChain.wrap(new ExportToOtherAuthorisedGraph());
    Context context = new Context();

    // Act and Assert
    assertEquals("Result", updateViewHook.onFailure("Result", opChain, context, new Exception()));
  }

  /**
   * Test {@link UpdateViewHook#setViewToMerge(View)}.
   *
   * <ul>
   *   <li>Given {@code true}.
   *   <li>When {@link View} (default constructor) AllEntities is {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link UpdateViewHook#setViewToMerge(View)}
   */
  @Test
  @DisplayName(
      "Test setViewToMerge(View); given 'true'; when View (default constructor) AllEntities is 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"UpdateViewHook UpdateViewHook.setViewToMerge(View)"})
  void testSetViewToMerge_givenTrue_whenViewAllEntitiesIsTrue() {
    // Arrange
    UpdateViewHook updateViewHook = new UpdateViewHook();

    View viewToMerge = new View();
    viewToMerge.setAllEntities(true);

    // Act
    UpdateViewHook actualSetViewToMergeResult = updateViewHook.setViewToMerge(viewToMerge);

    // Assert
    assertNull(actualSetViewToMergeResult.getBlackListElementGroups());
    assertNull(actualSetViewToMergeResult.getWhiteListElementGroups());
    assertNull(actualSetViewToMergeResult.getWithDataAuth());
    assertNull(actualSetViewToMergeResult.getWithOpAuth());
    assertNull(actualSetViewToMergeResult.getWithoutDataAuth());
    assertNull(actualSetViewToMergeResult.getWithoutOpAuth());
    assertFalse(actualSetViewToMergeResult.isAddExtraGroups());
    assertEquals(viewToMerge, updateViewHook.getViewToMerge());
    assertEquals(viewToMerge, actualSetViewToMergeResult.getViewToMerge());
  }

  /**
   * Test {@link UpdateViewHook#setViewToMerge(View)}.
   *
   * <ul>
   *   <li>When {@link NamedView} (default constructor).
   *   <li>Then return {@link UpdateViewHook} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link UpdateViewHook#setViewToMerge(View)}
   */
  @Test
  @DisplayName(
      "Test setViewToMerge(View); when NamedView (default constructor); then return UpdateViewHook (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"UpdateViewHook UpdateViewHook.setViewToMerge(View)"})
  void testSetViewToMerge_whenNamedView_thenReturnUpdateViewHook() {
    // Arrange
    UpdateViewHook updateViewHook = new UpdateViewHook();

    // Act
    UpdateViewHook actualSetViewToMergeResult = updateViewHook.setViewToMerge(new NamedView());

    // Assert
    assertSame(updateViewHook, actualSetViewToMergeResult);
  }

  /**
   * Test {@link UpdateViewHook#setViewToMerge(View)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then {@link UpdateViewHook} (default constructor) ViewToMerge is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link UpdateViewHook#setViewToMerge(View)}
   */
  @Test
  @DisplayName(
      "Test setViewToMerge(View); when 'null'; then UpdateViewHook (default constructor) ViewToMerge is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"UpdateViewHook UpdateViewHook.setViewToMerge(View)"})
  void testSetViewToMerge_whenNull_thenUpdateViewHookViewToMergeIsNull() {
    // Arrange
    UpdateViewHook updateViewHook = new UpdateViewHook();

    // Act
    UpdateViewHook actualSetViewToMergeResult = updateViewHook.setViewToMerge(null);

    // Assert
    assertNull(updateViewHook.getViewToMerge());
    assertSame(updateViewHook, actualSetViewToMergeResult);
  }

  /**
   * Test {@link UpdateViewHook#setViewToMerge(View)}.
   *
   * <ul>
   *   <li>When {@link View} (default constructor).
   *   <li>Then return BlackListElementGroups is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link UpdateViewHook#setViewToMerge(View)}
   */
  @Test
  @DisplayName(
      "Test setViewToMerge(View); when View (default constructor); then return BlackListElementGroups is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"UpdateViewHook UpdateViewHook.setViewToMerge(View)"})
  void testSetViewToMerge_whenView_thenReturnBlackListElementGroupsIsNull() {
    // Arrange
    UpdateViewHook updateViewHook = new UpdateViewHook();
    View viewToMerge = new View();

    // Act
    UpdateViewHook actualSetViewToMergeResult = updateViewHook.setViewToMerge(viewToMerge);

    // Assert
    assertNull(actualSetViewToMergeResult.getBlackListElementGroups());
    assertNull(actualSetViewToMergeResult.getWhiteListElementGroups());
    assertNull(actualSetViewToMergeResult.getWithDataAuth());
    assertNull(actualSetViewToMergeResult.getWithOpAuth());
    assertNull(actualSetViewToMergeResult.getWithoutDataAuth());
    assertNull(actualSetViewToMergeResult.getWithoutOpAuth());
    assertFalse(actualSetViewToMergeResult.isAddExtraGroups());
    assertEquals(viewToMerge, updateViewHook.getViewToMerge());
    assertEquals(viewToMerge, actualSetViewToMergeResult.getViewToMerge());
  }

  /**
   * Test {@link UpdateViewHook#getViewToMerge()}.
   *
   * <ul>
   *   <li>Given {@link UpdateViewHook} (default constructor).
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link UpdateViewHook#getViewToMerge()}
   */
  @Test
  @DisplayName(
      "Test getViewToMerge(); given UpdateViewHook (default constructor); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"View UpdateViewHook.getViewToMerge()"})
  void testGetViewToMerge_givenUpdateViewHook_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new UpdateViewHook().getViewToMerge());
  }

  /**
   * Test {@link UpdateViewHook#getViewToMerge()}.
   *
   * <ul>
   *   <li>Given {@link View} (default constructor) AllEdges is {@code true}.
   *   <li>Then return AllEdges.
   * </ul>
   *
   * <p>Method under test: {@link UpdateViewHook#getViewToMerge()}
   */
  @Test
  @DisplayName(
      "Test getViewToMerge(); given View (default constructor) AllEdges is 'true'; then return AllEdges")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"View UpdateViewHook.getViewToMerge()"})
  void testGetViewToMerge_givenViewAllEdgesIsTrue_thenReturnAllEdges()
      throws UnsupportedEncodingException, SchemaException {
    // Arrange
    View viewToMerge = new View();
    viewToMerge.setAllEdges(true);
    viewToMerge.addConfig("Key", "42");

    Builder builder = new Builder();

    Builder setViewToMergeResult =
        builder.blackListElementGroups(new HashSet<>()).setViewToMerge(viewToMerge);

    Builder whiteListElementGroupsResult =
        setViewToMergeResult.whiteListElementGroups(new HashSet<>());

    Builder withDataAuthResult = whiteListElementGroupsResult.withDataAuth(new HashSet<>());

    Builder withOpAuthResult = withDataAuthResult.withOpAuth(new HashSet<>());

    Builder withoutDataAuthResult = withOpAuthResult.withoutDataAuth(new HashSet<>());

    // Act
    View actualViewToMerge =
        withoutDataAuthResult.withoutOpAuth(new HashSet<>()).build().getViewToMerge();

    // Assert
    Map<String, String> config = actualViewToMerge.getConfig();
    assertEquals(1, config.size());
    assertEquals("42", config.get("Key"));
    assertFalse(actualViewToMerge.isAllEntities());
    assertTrue(actualViewToMerge.isAllEdges());
    byte[] expectedToCompactJsonResult =
        "{\"allEdges\":true,\"config\":{\"Key\":\"42\"}}".getBytes("UTF-8");
    assertArrayEquals(expectedToCompactJsonResult, actualViewToMerge.toCompactJson());
  }

  /**
   * Test {@link UpdateViewHook#getViewToMerge()}.
   *
   * <ul>
   *   <li>Given {@link View} (default constructor) AllEntities is {@code true}.
   *   <li>Then return AllEntities.
   * </ul>
   *
   * <p>Method under test: {@link UpdateViewHook#getViewToMerge()}
   */
  @Test
  @DisplayName(
      "Test getViewToMerge(); given View (default constructor) AllEntities is 'true'; then return AllEntities")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"View UpdateViewHook.getViewToMerge()"})
  void testGetViewToMerge_givenViewAllEntitiesIsTrue_thenReturnAllEntities()
      throws UnsupportedEncodingException, SchemaException {
    // Arrange
    View viewToMerge = new View();
    viewToMerge.setAllEntities(true);
    viewToMerge.addConfig("Key", "42");

    Builder builder = new Builder();

    Builder setViewToMergeResult =
        builder.blackListElementGroups(new HashSet<>()).setViewToMerge(viewToMerge);

    Builder whiteListElementGroupsResult =
        setViewToMergeResult.whiteListElementGroups(new HashSet<>());

    Builder withDataAuthResult = whiteListElementGroupsResult.withDataAuth(new HashSet<>());

    Builder withOpAuthResult = withDataAuthResult.withOpAuth(new HashSet<>());

    Builder withoutDataAuthResult = withOpAuthResult.withoutDataAuth(new HashSet<>());

    // Act
    View actualViewToMerge =
        withoutDataAuthResult.withoutOpAuth(new HashSet<>()).build().getViewToMerge();

    // Assert
    Map<String, String> config = actualViewToMerge.getConfig();
    assertEquals(1, config.size());
    assertEquals("42", config.get("Key"));
    assertFalse(actualViewToMerge.isAllEdges());
    assertTrue(actualViewToMerge.isAllEntities());
    byte[] expectedToCompactJsonResult =
        "{\"allEntities\":true,\"config\":{\"Key\":\"42\"}}".getBytes("UTF-8");
    assertArrayEquals(expectedToCompactJsonResult, actualViewToMerge.toCompactJson());
  }

  /**
   * Test {@link UpdateViewHook#getViewToMerge()}.
   *
   * <ul>
   *   <li>Then return Config Empty.
   * </ul>
   *
   * <p>Method under test: {@link UpdateViewHook#getViewToMerge()}
   */
  @Test
  @DisplayName("Test getViewToMerge(); then return Config Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"View UpdateViewHook.getViewToMerge()"})
  void testGetViewToMerge_thenReturnConfigEmpty() throws SchemaException {
    // Arrange
    Builder builder = new Builder();

    Builder blackListElementGroupsResult = builder.blackListElementGroups(new HashSet<>());

    Builder setViewToMergeResult = blackListElementGroupsResult.setViewToMerge(new View());

    Builder whiteListElementGroupsResult =
        setViewToMergeResult.whiteListElementGroups(new HashSet<>());

    Builder withDataAuthResult = whiteListElementGroupsResult.withDataAuth(new HashSet<>());

    Builder withOpAuthResult = withDataAuthResult.withOpAuth(new HashSet<>());

    Builder withoutDataAuthResult = withOpAuthResult.withoutDataAuth(new HashSet<>());

    // Act
    View actualViewToMerge =
        withoutDataAuthResult.withoutOpAuth(new HashSet<>()).build().getViewToMerge();

    // Assert
    assertFalse(actualViewToMerge.isAllEdges());
    assertFalse(actualViewToMerge.isAllEntities());
    assertTrue(actualViewToMerge.getConfig().isEmpty());
    assertArrayEquals(new byte[] {'{', '}'}, actualViewToMerge.toCompactJson());
  }

  /**
   * Test {@link UpdateViewHook#getViewToMerge()}.
   *
   * <ul>
   *   <li>Then return toCompactJson is {@code {"config":{"Key":"42"}}} Bytes is {@code UTF-8}.
   * </ul>
   *
   * <p>Method under test: {@link UpdateViewHook#getViewToMerge()}
   */
  @Test
  @DisplayName(
      "Test getViewToMerge(); then return toCompactJson is '{\"config\":{\"Key\":\"42\"}}' Bytes is 'UTF-8'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"View UpdateViewHook.getViewToMerge()"})
  void testGetViewToMerge_thenReturnToCompactJsonIsConfigKey42BytesIsUtf8()
      throws UnsupportedEncodingException, SchemaException {
    // Arrange
    View viewToMerge = new View();
    viewToMerge.addConfig("Key", "42");

    Builder builder = new Builder();

    Builder setViewToMergeResult =
        builder.blackListElementGroups(new HashSet<>()).setViewToMerge(viewToMerge);

    Builder whiteListElementGroupsResult =
        setViewToMergeResult.whiteListElementGroups(new HashSet<>());

    Builder withDataAuthResult = whiteListElementGroupsResult.withDataAuth(new HashSet<>());

    Builder withOpAuthResult = withDataAuthResult.withOpAuth(new HashSet<>());

    Builder withoutDataAuthResult = withOpAuthResult.withoutDataAuth(new HashSet<>());

    // Act
    View actualViewToMerge =
        withoutDataAuthResult.withoutOpAuth(new HashSet<>()).build().getViewToMerge();

    // Assert
    Map<String, String> config = actualViewToMerge.getConfig();
    assertEquals(1, config.size());
    assertEquals("42", config.get("Key"));
    assertFalse(actualViewToMerge.isAllEdges());
    assertFalse(actualViewToMerge.isAllEntities());
    byte[] expectedToCompactJsonResult = "{\"config\":{\"Key\":\"42\"}}".getBytes("UTF-8");
    assertArrayEquals(expectedToCompactJsonResult, actualViewToMerge.toCompactJson());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link UpdateViewHook}
   *   <li>{@link UpdateViewHook#setAddExtraGroups(boolean)}
   *   <li>{@link UpdateViewHook#setBlackListElementGroups(Set)}
   *   <li>{@link UpdateViewHook#setWhiteListElementGroups(Set)}
   *   <li>{@link UpdateViewHook#setWithDataAuth(Set)}
   *   <li>{@link UpdateViewHook#setWithOpAuth(Set)}
   *   <li>{@link UpdateViewHook#setWithoutDataAuth(Set)}
   *   <li>{@link UpdateViewHook#setWithoutOpAuth(Set)}
   *   <li>{@link UpdateViewHook#mergeView(OperationView, View)}
   *   <li>{@link UpdateViewHook#getBlackListElementGroups()}
   *   <li>{@link UpdateViewHook#getWhiteListElementGroups()}
   *   <li>{@link UpdateViewHook#getWithDataAuth()}
   *   <li>{@link UpdateViewHook#getWithOpAuth()}
   *   <li>{@link UpdateViewHook#getWithoutDataAuth()}
   *   <li>{@link UpdateViewHook#getWithoutOpAuth()}
   *   <li>{@link UpdateViewHook#isAddExtraGroups()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void UpdateViewHook.<init>()",
    "Set UpdateViewHook.getBlackListElementGroups()",
    "Set UpdateViewHook.getWhiteListElementGroups()",
    "Set UpdateViewHook.getWithDataAuth()",
    "Set UpdateViewHook.getWithOpAuth()",
    "Set UpdateViewHook.getWithoutDataAuth()",
    "Set UpdateViewHook.getWithoutOpAuth()",
    "boolean UpdateViewHook.isAddExtraGroups()",
    "View.Builder UpdateViewHook.mergeView(OperationView, View)",
    "UpdateViewHook UpdateViewHook.setAddExtraGroups(boolean)",
    "UpdateViewHook UpdateViewHook.setBlackListElementGroups(Set)",
    "UpdateViewHook UpdateViewHook.setWhiteListElementGroups(Set)",
    "UpdateViewHook UpdateViewHook.setWithDataAuth(Set)",
    "UpdateViewHook UpdateViewHook.setWithOpAuth(Set)",
    "UpdateViewHook UpdateViewHook.setWithoutDataAuth(Set)",
    "UpdateViewHook UpdateViewHook.setWithoutOpAuth(Set)"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    UpdateViewHook actualUpdateViewHook = new UpdateViewHook();
    UpdateViewHook actualSetAddExtraGroupsResult = actualUpdateViewHook.setAddExtraGroups(true);
    HashSet<String> blackListElementGroups = new HashSet<>();
    UpdateViewHook actualSetBlackListElementGroupsResult =
        actualUpdateViewHook.setBlackListElementGroups(blackListElementGroups);
    HashSet<String> whiteListElementGroups = new HashSet<>();
    UpdateViewHook actualSetWhiteListElementGroupsResult =
        actualUpdateViewHook.setWhiteListElementGroups(whiteListElementGroups);
    HashSet<String> withDataAuth = new HashSet<>();
    UpdateViewHook actualSetWithDataAuthResult = actualUpdateViewHook.setWithDataAuth(withDataAuth);
    HashSet<String> withOpAuth = new HashSet<>();
    UpdateViewHook actualSetWithOpAuthResult = actualUpdateViewHook.setWithOpAuth(withOpAuth);
    HashSet<String> withoutDataAuth = new HashSet<>();
    UpdateViewHook actualSetWithoutDataAuthResult =
        actualUpdateViewHook.setWithoutDataAuth(withoutDataAuth);
    HashSet<String> withoutOpAuth = new HashSet<>();
    UpdateViewHook actualSetWithoutOpAuthResult =
        actualUpdateViewHook.setWithoutOpAuth(withoutOpAuth);
    GetElements operationView = new GetElements();
    actualUpdateViewHook.mergeView(operationView, new View());
    Set<String> actualBlackListElementGroups = actualUpdateViewHook.getBlackListElementGroups();
    Set<String> actualWhiteListElementGroups = actualUpdateViewHook.getWhiteListElementGroups();
    Set<String> actualWithDataAuth = actualUpdateViewHook.getWithDataAuth();
    Set<String> actualWithOpAuth = actualUpdateViewHook.getWithOpAuth();
    Set<String> actualWithoutDataAuth = actualUpdateViewHook.getWithoutDataAuth();
    Set<String> actualWithoutOpAuth = actualUpdateViewHook.getWithoutOpAuth();
    boolean actualIsAddExtraGroupsResult = actualUpdateViewHook.isAddExtraGroups();

    // Assert
    assertTrue(actualBlackListElementGroups.isEmpty());
    assertTrue(actualWhiteListElementGroups.isEmpty());
    assertTrue(actualWithDataAuth.isEmpty());
    assertTrue(actualWithOpAuth.isEmpty());
    assertTrue(actualWithoutDataAuth.isEmpty());
    assertTrue(actualWithoutOpAuth.isEmpty());
    assertTrue(actualIsAddExtraGroupsResult);
    assertSame(blackListElementGroups, actualBlackListElementGroups);
    assertSame(whiteListElementGroups, actualWhiteListElementGroups);
    assertSame(withDataAuth, actualWithDataAuth);
    assertSame(withOpAuth, actualWithOpAuth);
    assertSame(withoutDataAuth, actualWithoutDataAuth);
    assertSame(withoutOpAuth, actualWithoutOpAuth);
    assertSame(actualUpdateViewHook, actualSetAddExtraGroupsResult);
    assertSame(actualUpdateViewHook, actualSetBlackListElementGroupsResult);
    assertSame(actualUpdateViewHook, actualSetWhiteListElementGroupsResult);
    assertSame(actualUpdateViewHook, actualSetWithDataAuthResult);
    assertSame(actualUpdateViewHook, actualSetWithOpAuthResult);
    assertSame(actualUpdateViewHook, actualSetWithoutDataAuthResult);
    assertSame(actualUpdateViewHook, actualSetWithoutOpAuthResult);
  }
}
