/*
 * Copyright 2026 Crown Copyright
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package uk.gov.gchq.gaffer.federatedstore.access.predicate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Predicate;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.federatedstore.access.predicate.user.FederatedGraphReadUserPredicate;
import uk.gov.gchq.gaffer.user.User;
import uk.gov.gchq.gaffer.user.User.Builder;

class FederatedGraphReadAccessPredicateDiffblueTest {
  /**
   * Test {@link FederatedGraphReadAccessPredicate#FederatedGraphReadAccessPredicate(String, List,
   * boolean)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link
   * FederatedGraphReadAccessPredicate#FederatedGraphReadAccessPredicate(String, List, boolean)}
   */
  @Test
  @DisplayName(
      "Test new FederatedGraphReadAccessPredicate(String, List, boolean); given '42'; when ArrayList() add '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void FederatedGraphReadAccessPredicate.<init>(String, List, boolean)"})
  void testNewFederatedGraphReadAccessPredicate_given42_whenArrayListAdd42() {
    // Arrange
    ArrayList<String> auths = new ArrayList<>();
    auths.add("42");
    auths.add("foo");

    // Act
    FederatedGraphReadAccessPredicate actualFederatedGraphReadAccessPredicate =
        new FederatedGraphReadAccessPredicate("42", auths, true);

    // Assert
    Predicate<User> userPredicate = actualFederatedGraphReadAccessPredicate.getUserPredicate();
    assertTrue(userPredicate instanceof FederatedGraphReadUserPredicate);
    assertEquals("42", ((FederatedGraphReadUserPredicate) userPredicate).getCreatingUserId());
    assertTrue(((FederatedGraphReadUserPredicate) userPredicate).isPublic());
    assertEquals(auths, ((FederatedGraphReadUserPredicate) userPredicate).getAuths());
  }

  /**
   * Test {@link FederatedGraphReadAccessPredicate#FederatedGraphReadAccessPredicate(String, List,
   * boolean)}.
   *
   * <ul>
   *   <li>Then return UserPredicate Auths is {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * FederatedGraphReadAccessPredicate#FederatedGraphReadAccessPredicate(String, List, boolean)}
   */
  @Test
  @DisplayName(
      "Test new FederatedGraphReadAccessPredicate(String, List, boolean); then return UserPredicate Auths is ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void FederatedGraphReadAccessPredicate.<init>(String, List, boolean)"})
  void testNewFederatedGraphReadAccessPredicate_thenReturnUserPredicateAuthsIsArrayList() {
    // Arrange
    ArrayList<String> auths = new ArrayList<>();
    auths.add("foo");

    // Act
    FederatedGraphReadAccessPredicate actualFederatedGraphReadAccessPredicate =
        new FederatedGraphReadAccessPredicate("42", auths, true);

    // Assert
    Predicate<User> userPredicate = actualFederatedGraphReadAccessPredicate.getUserPredicate();
    assertTrue(userPredicate instanceof FederatedGraphReadUserPredicate);
    assertEquals("42", ((FederatedGraphReadUserPredicate) userPredicate).getCreatingUserId());
    assertTrue(((FederatedGraphReadUserPredicate) userPredicate).isPublic());
    assertEquals(auths, ((FederatedGraphReadUserPredicate) userPredicate).getAuths());
  }

  /**
   * Test {@link FederatedGraphReadAccessPredicate#FederatedGraphReadAccessPredicate(String, Set,
   * boolean)}.
   *
   * <ul>
   *   <li>Then return UserPredicate Auths size is one.
   * </ul>
   *
   * <p>Method under test: {@link
   * FederatedGraphReadAccessPredicate#FederatedGraphReadAccessPredicate(String, Set, boolean)}
   */
  @Test
  @DisplayName(
      "Test new FederatedGraphReadAccessPredicate(String, Set, boolean); then return UserPredicate Auths size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void FederatedGraphReadAccessPredicate.<init>(String, Set, boolean)"})
  void testNewFederatedGraphReadAccessPredicate_thenReturnUserPredicateAuthsSizeIsOne() {
    // Arrange
    HashSet<String> auths = new HashSet<>();
    auths.add("foo");

    // Act
    FederatedGraphReadAccessPredicate actualFederatedGraphReadAccessPredicate =
        new FederatedGraphReadAccessPredicate("42", auths, true);

    // Assert
    Predicate<User> userPredicate = actualFederatedGraphReadAccessPredicate.getUserPredicate();
    assertTrue(userPredicate instanceof FederatedGraphReadUserPredicate);
    assertEquals("42", ((FederatedGraphReadUserPredicate) userPredicate).getCreatingUserId());
    List<String> auths2 = ((FederatedGraphReadUserPredicate) userPredicate).getAuths();
    assertEquals(1, auths2.size());
    assertEquals("foo", auths2.get(0));
    assertTrue(((FederatedGraphReadUserPredicate) userPredicate).isPublic());
  }

  /**
   * Test {@link FederatedGraphReadAccessPredicate#FederatedGraphReadAccessPredicate(String, Set,
   * boolean)}.
   *
   * <ul>
   *   <li>Then return UserPredicate Auths size is two.
   * </ul>
   *
   * <p>Method under test: {@link
   * FederatedGraphReadAccessPredicate#FederatedGraphReadAccessPredicate(String, Set, boolean)}
   */
  @Test
  @DisplayName(
      "Test new FederatedGraphReadAccessPredicate(String, Set, boolean); then return UserPredicate Auths size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void FederatedGraphReadAccessPredicate.<init>(String, Set, boolean)"})
  void testNewFederatedGraphReadAccessPredicate_thenReturnUserPredicateAuthsSizeIsTwo() {
    // Arrange
    HashSet<String> auths = new HashSet<>();
    auths.add("42");
    auths.add("foo");

    // Act
    FederatedGraphReadAccessPredicate actualFederatedGraphReadAccessPredicate =
        new FederatedGraphReadAccessPredicate("42", auths, true);

    // Assert
    Predicate<User> userPredicate = actualFederatedGraphReadAccessPredicate.getUserPredicate();
    assertTrue(userPredicate instanceof FederatedGraphReadUserPredicate);
    List<String> auths2 = ((FederatedGraphReadUserPredicate) userPredicate).getAuths();
    assertEquals(2, auths2.size());
    assertEquals("42", auths2.get(0));
    assertEquals("42", ((FederatedGraphReadUserPredicate) userPredicate).getCreatingUserId());
    assertEquals("foo", auths2.get(1));
    assertTrue(((FederatedGraphReadUserPredicate) userPredicate).isPublic());
  }

  /**
   * Test {@link FederatedGraphReadAccessPredicate#FederatedGraphReadAccessPredicate(String, List,
   * boolean)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * FederatedGraphReadAccessPredicate#FederatedGraphReadAccessPredicate(String, List, boolean)}
   */
  @Test
  @DisplayName(
      "Test new FederatedGraphReadAccessPredicate(String, List, boolean); when ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void FederatedGraphReadAccessPredicate.<init>(String, List, boolean)"})
  void testNewFederatedGraphReadAccessPredicate_whenArrayList() {
    // Arrange and Act
    FederatedGraphReadAccessPredicate actualFederatedGraphReadAccessPredicate =
        new FederatedGraphReadAccessPredicate("42", new ArrayList<>(), true);

    // Assert
    Predicate<User> userPredicate = actualFederatedGraphReadAccessPredicate.getUserPredicate();
    assertTrue(userPredicate instanceof FederatedGraphReadUserPredicate);
    assertEquals("42", ((FederatedGraphReadUserPredicate) userPredicate).getCreatingUserId());
    assertTrue(((FederatedGraphReadUserPredicate) userPredicate).getAuths().isEmpty());
    assertTrue(((FederatedGraphReadUserPredicate) userPredicate).isPublic());
  }

  /**
   * Test {@link FederatedGraphReadAccessPredicate#FederatedGraphReadAccessPredicate(String, Set,
   * boolean)}.
   *
   * <ul>
   *   <li>When {@link HashSet#HashSet()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * FederatedGraphReadAccessPredicate#FederatedGraphReadAccessPredicate(String, Set, boolean)}
   */
  @Test
  @DisplayName("Test new FederatedGraphReadAccessPredicate(String, Set, boolean); when HashSet()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void FederatedGraphReadAccessPredicate.<init>(String, Set, boolean)"})
  void testNewFederatedGraphReadAccessPredicate_whenHashSet() {
    // Arrange and Act
    FederatedGraphReadAccessPredicate actualFederatedGraphReadAccessPredicate =
        new FederatedGraphReadAccessPredicate("42", new HashSet<>(), true);

    // Assert
    Predicate<User> userPredicate = actualFederatedGraphReadAccessPredicate.getUserPredicate();
    assertTrue(userPredicate instanceof FederatedGraphReadUserPredicate);
    assertEquals("42", ((FederatedGraphReadUserPredicate) userPredicate).getCreatingUserId());
    assertTrue(((FederatedGraphReadUserPredicate) userPredicate).getAuths().isEmpty());
    assertTrue(((FederatedGraphReadUserPredicate) userPredicate).isPublic());
  }

  /**
   * Test {@link FederatedGraphReadAccessPredicate#FederatedGraphReadAccessPredicate(String, List,
   * boolean)}.
   *
   * <ul>
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * FederatedGraphReadAccessPredicate#FederatedGraphReadAccessPredicate(String, List, boolean)}
   */
  @Test
  @DisplayName("Test new FederatedGraphReadAccessPredicate(String, List, boolean); when 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void FederatedGraphReadAccessPredicate.<init>(String, List, boolean)"})
  void testNewFederatedGraphReadAccessPredicate_whenNull() {
    // Arrange and Act
    FederatedGraphReadAccessPredicate actualFederatedGraphReadAccessPredicate =
        new FederatedGraphReadAccessPredicate("42", (List<String>) null, true);

    // Assert
    Predicate<User> userPredicate = actualFederatedGraphReadAccessPredicate.getUserPredicate();
    assertTrue(userPredicate instanceof FederatedGraphReadUserPredicate);
    assertEquals("42", ((FederatedGraphReadUserPredicate) userPredicate).getCreatingUserId());
    assertTrue(((FederatedGraphReadUserPredicate) userPredicate).getAuths().isEmpty());
    assertTrue(((FederatedGraphReadUserPredicate) userPredicate).isPublic());
  }

  /**
   * Test {@link FederatedGraphReadAccessPredicate#FederatedGraphReadAccessPredicate(String, Set,
   * boolean)}.
   *
   * <ul>
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * FederatedGraphReadAccessPredicate#FederatedGraphReadAccessPredicate(String, Set, boolean)}
   */
  @Test
  @DisplayName("Test new FederatedGraphReadAccessPredicate(String, Set, boolean); when 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void FederatedGraphReadAccessPredicate.<init>(String, Set, boolean)"})
  void testNewFederatedGraphReadAccessPredicate_whenNull2() {
    // Arrange and Act
    FederatedGraphReadAccessPredicate actualFederatedGraphReadAccessPredicate =
        new FederatedGraphReadAccessPredicate("42", (Set<String>) null, true);

    // Assert
    Predicate<User> userPredicate = actualFederatedGraphReadAccessPredicate.getUserPredicate();
    assertTrue(userPredicate instanceof FederatedGraphReadUserPredicate);
    assertEquals("42", ((FederatedGraphReadUserPredicate) userPredicate).getCreatingUserId());
    assertTrue(((FederatedGraphReadUserPredicate) userPredicate).getAuths().isEmpty());
    assertTrue(((FederatedGraphReadUserPredicate) userPredicate).isPublic());
  }

  /**
   * Test {@link FederatedGraphReadAccessPredicate#test(User, String)} with {@code User}, {@code
   * String}.
   *
   * <p>Method under test: {@link FederatedGraphReadAccessPredicate#test(User, String)}
   */
  @Test
  @DisplayName("Test test(User, String) with 'User', 'String'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean FederatedGraphReadAccessPredicate.test(User, String)"})
  void testTestWithUserString() {
    // Arrange
    FederatedGraphReadAccessPredicate federatedGraphReadAccessPredicate =
        new FederatedGraphReadAccessPredicate("42", new ArrayList<>(), true);

    // Act and Assert
    assertTrue(federatedGraphReadAccessPredicate.test(new User(), "Admin Auth"));
  }

  /**
   * Test {@link FederatedGraphReadAccessPredicate#test(User, String)} with {@code User}, {@code
   * String}.
   *
   * <p>Method under test: {@link FederatedGraphReadAccessPredicate#test(User, String)}
   */
  @Test
  @DisplayName("Test test(User, String) with 'User', 'String'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean FederatedGraphReadAccessPredicate.test(User, String)"})
  void testTestWithUserString2() {
    // Arrange
    FederatedGraphReadAccessPredicate federatedGraphReadAccessPredicate =
        new FederatedGraphReadAccessPredicate("", new ArrayList<>(), false);

    // Act and Assert
    assertFalse(federatedGraphReadAccessPredicate.test(new User(), "Admin Auth"));
  }

  /**
   * Test {@link FederatedGraphReadAccessPredicate#test(User, String)} with {@code User}, {@code
   * String}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link FederatedGraphReadAccessPredicate#test(User, String)}
   */
  @Test
  @DisplayName("Test test(User, String) with 'User', 'String'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean FederatedGraphReadAccessPredicate.test(User, String)"})
  void testTestWithUserString_thenReturnFalse() {
    // Arrange
    FederatedGraphReadAccessPredicate federatedGraphReadAccessPredicate =
        new FederatedGraphReadAccessPredicate("42", new ArrayList<>(), false);

    // Act and Assert
    assertFalse(federatedGraphReadAccessPredicate.test(new User(), "Admin Auth"));
  }

  /**
   * Test {@link FederatedGraphReadAccessPredicate#test(User, String)} with {@code User}, {@code
   * String}.
   *
   * <ul>
   *   <li>When {@link User.Builder} (default constructor) userId {@code 42} build.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link FederatedGraphReadAccessPredicate#test(User, String)}
   */
  @Test
  @DisplayName(
      "Test test(User, String) with 'User', 'String'; when Builder (default constructor) userId '42' build; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean FederatedGraphReadAccessPredicate.test(User, String)"})
  void testTestWithUserString_whenBuilderUserId42Build_thenReturnTrue() {
    // Arrange
    FederatedGraphReadAccessPredicate federatedGraphReadAccessPredicate =
        new FederatedGraphReadAccessPredicate("42", new ArrayList<>(), false);

    // Act and Assert
    assertTrue(
        federatedGraphReadAccessPredicate.test(new Builder().userId("42").build(), "Admin Auth"));
  }

  /**
   * Test {@link FederatedGraphReadAccessPredicate#test(User, String)} with {@code User}, {@code
   * String}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link FederatedGraphReadAccessPredicate#test(User, String)}
   */
  @Test
  @DisplayName("Test test(User, String) with 'User', 'String'; when 'null'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean FederatedGraphReadAccessPredicate.test(User, String)"})
  void testTestWithUserString_whenNull_thenReturnFalse() {
    // Arrange
    FederatedGraphReadAccessPredicate federatedGraphReadAccessPredicate =
        new FederatedGraphReadAccessPredicate("42", new ArrayList<>(), false);

    // Act and Assert
    assertFalse(federatedGraphReadAccessPredicate.test(null, "Admin Auth"));
  }
}
