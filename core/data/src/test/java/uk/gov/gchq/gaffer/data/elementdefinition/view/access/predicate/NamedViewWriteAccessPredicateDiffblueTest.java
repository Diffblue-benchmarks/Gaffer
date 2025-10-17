/*
 * Copyright 2025 Crown Copyright
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

package uk.gov.gchq.gaffer.data.elementdefinition.view.access.predicate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.data.elementdefinition.view.access.predicate.user.NamedViewWriteUserPredicate;
import uk.gov.gchq.gaffer.user.User;

class NamedViewWriteAccessPredicateDiffblueTest {
  /**
   * Test {@link NamedViewWriteAccessPredicate#NamedViewWriteAccessPredicate(String, List)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link
   * NamedViewWriteAccessPredicate#NamedViewWriteAccessPredicate(String, List)}
   */
  @Test
  @DisplayName(
      "Test new NamedViewWriteAccessPredicate(String, List); given '42'; when ArrayList() add '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void NamedViewWriteAccessPredicate.<init>(String, List)"})
  void testNewNamedViewWriteAccessPredicate_given42_whenArrayListAdd42() {
    // Arrange
    ArrayList<String> auths = new ArrayList<>();
    auths.add("42");
    auths.add("foo");

    // Act
    NamedViewWriteAccessPredicate actualNamedViewWriteAccessPredicate =
        new NamedViewWriteAccessPredicate("42", auths);

    // Assert
    Predicate<User> userPredicate = actualNamedViewWriteAccessPredicate.getUserPredicate();
    assertTrue(userPredicate instanceof NamedViewWriteUserPredicate);
    assertEquals("42", ((NamedViewWriteUserPredicate) userPredicate).getCreatingUserId());
    assertEquals(auths, ((NamedViewWriteUserPredicate) userPredicate).getAuths());
  }

  /**
   * Test {@link NamedViewWriteAccessPredicate#NamedViewWriteAccessPredicate(User, List)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link NamedViewWriteAccessPredicate#NamedViewWriteAccessPredicate(User,
   * List)}
   */
  @Test
  @DisplayName(
      "Test new NamedViewWriteAccessPredicate(User, List); given '42'; when ArrayList() add '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void NamedViewWriteAccessPredicate.<init>(User, List)"})
  void testNewNamedViewWriteAccessPredicate_given42_whenArrayListAdd422() {
    // Arrange
    User creatingUser = new User();

    ArrayList<String> auths = new ArrayList<>();
    auths.add("42");
    auths.add("foo");

    // Act
    NamedViewWriteAccessPredicate actualNamedViewWriteAccessPredicate =
        new NamedViewWriteAccessPredicate(creatingUser, auths);

    // Assert
    Predicate<User> userPredicate = actualNamedViewWriteAccessPredicate.getUserPredicate();
    assertTrue(userPredicate instanceof NamedViewWriteUserPredicate);
    assertEquals("UNKNOWN", ((NamedViewWriteUserPredicate) userPredicate).getCreatingUserId());
    assertEquals(auths, ((NamedViewWriteUserPredicate) userPredicate).getAuths());
  }

  /**
   * Test {@link NamedViewWriteAccessPredicate#NamedViewWriteAccessPredicate(String, List)}.
   *
   * <ul>
   *   <li>Then return UserPredicate Auths is {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * NamedViewWriteAccessPredicate#NamedViewWriteAccessPredicate(String, List)}
   */
  @Test
  @DisplayName(
      "Test new NamedViewWriteAccessPredicate(String, List); then return UserPredicate Auths is ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void NamedViewWriteAccessPredicate.<init>(String, List)"})
  void testNewNamedViewWriteAccessPredicate_thenReturnUserPredicateAuthsIsArrayList() {
    // Arrange
    ArrayList<String> auths = new ArrayList<>();
    auths.add("foo");

    // Act
    NamedViewWriteAccessPredicate actualNamedViewWriteAccessPredicate =
        new NamedViewWriteAccessPredicate("42", auths);

    // Assert
    Predicate<User> userPredicate = actualNamedViewWriteAccessPredicate.getUserPredicate();
    assertTrue(userPredicate instanceof NamedViewWriteUserPredicate);
    assertEquals("42", ((NamedViewWriteUserPredicate) userPredicate).getCreatingUserId());
    assertEquals(auths, ((NamedViewWriteUserPredicate) userPredicate).getAuths());
  }

  /**
   * Test {@link NamedViewWriteAccessPredicate#NamedViewWriteAccessPredicate(User, List)}.
   *
   * <ul>
   *   <li>Then return UserPredicate Auths is {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link NamedViewWriteAccessPredicate#NamedViewWriteAccessPredicate(User,
   * List)}
   */
  @Test
  @DisplayName(
      "Test new NamedViewWriteAccessPredicate(User, List); then return UserPredicate Auths is ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void NamedViewWriteAccessPredicate.<init>(User, List)"})
  void testNewNamedViewWriteAccessPredicate_thenReturnUserPredicateAuthsIsArrayList2() {
    // Arrange
    User creatingUser = new User();

    ArrayList<String> auths = new ArrayList<>();
    auths.add("foo");

    // Act
    NamedViewWriteAccessPredicate actualNamedViewWriteAccessPredicate =
        new NamedViewWriteAccessPredicate(creatingUser, auths);

    // Assert
    Predicate<User> userPredicate = actualNamedViewWriteAccessPredicate.getUserPredicate();
    assertTrue(userPredicate instanceof NamedViewWriteUserPredicate);
    assertEquals("UNKNOWN", ((NamedViewWriteUserPredicate) userPredicate).getCreatingUserId());
    assertEquals(auths, ((NamedViewWriteUserPredicate) userPredicate).getAuths());
  }

  /**
   * Test {@link NamedViewWriteAccessPredicate#NamedViewWriteAccessPredicate(String, List)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * NamedViewWriteAccessPredicate#NamedViewWriteAccessPredicate(String, List)}
   */
  @Test
  @DisplayName("Test new NamedViewWriteAccessPredicate(String, List); when ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void NamedViewWriteAccessPredicate.<init>(String, List)"})
  void testNewNamedViewWriteAccessPredicate_whenArrayList() {
    // Arrange and Act
    NamedViewWriteAccessPredicate actualNamedViewWriteAccessPredicate =
        new NamedViewWriteAccessPredicate("42", new ArrayList<>());

    // Assert
    Predicate<User> userPredicate = actualNamedViewWriteAccessPredicate.getUserPredicate();
    assertTrue(userPredicate instanceof NamedViewWriteUserPredicate);
    assertEquals("42", ((NamedViewWriteUserPredicate) userPredicate).getCreatingUserId());
    assertTrue(((NamedViewWriteUserPredicate) userPredicate).getAuths().isEmpty());
  }

  /**
   * Test {@link NamedViewWriteAccessPredicate#NamedViewWriteAccessPredicate(User, List)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link NamedViewWriteAccessPredicate#NamedViewWriteAccessPredicate(User,
   * List)}
   */
  @Test
  @DisplayName("Test new NamedViewWriteAccessPredicate(User, List); when ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void NamedViewWriteAccessPredicate.<init>(User, List)"})
  void testNewNamedViewWriteAccessPredicate_whenArrayList2() {
    // Arrange
    User creatingUser = new User();

    // Act
    NamedViewWriteAccessPredicate actualNamedViewWriteAccessPredicate =
        new NamedViewWriteAccessPredicate(creatingUser, new ArrayList<>());

    // Assert
    Predicate<User> userPredicate = actualNamedViewWriteAccessPredicate.getUserPredicate();
    assertTrue(userPredicate instanceof NamedViewWriteUserPredicate);
    assertEquals("UNKNOWN", ((NamedViewWriteUserPredicate) userPredicate).getCreatingUserId());
    assertTrue(((NamedViewWriteUserPredicate) userPredicate).getAuths().isEmpty());
  }

  /**
   * Test {@link NamedViewWriteAccessPredicate#NamedViewWriteAccessPredicate(String, List)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return UserPredicate Auths Empty.
   * </ul>
   *
   * <p>Method under test: {@link
   * NamedViewWriteAccessPredicate#NamedViewWriteAccessPredicate(String, List)}
   */
  @Test
  @DisplayName(
      "Test new NamedViewWriteAccessPredicate(String, List); when 'null'; then return UserPredicate Auths Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void NamedViewWriteAccessPredicate.<init>(String, List)"})
  void testNewNamedViewWriteAccessPredicate_whenNull_thenReturnUserPredicateAuthsEmpty() {
    // Arrange and Act
    NamedViewWriteAccessPredicate actualNamedViewWriteAccessPredicate =
        new NamedViewWriteAccessPredicate("42", null);

    // Assert
    Predicate<User> userPredicate = actualNamedViewWriteAccessPredicate.getUserPredicate();
    assertTrue(userPredicate instanceof NamedViewWriteUserPredicate);
    assertEquals("42", ((NamedViewWriteUserPredicate) userPredicate).getCreatingUserId());
    assertTrue(((NamedViewWriteUserPredicate) userPredicate).getAuths().isEmpty());
  }

  /**
   * Test {@link NamedViewWriteAccessPredicate#NamedViewWriteAccessPredicate(User, List)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return UserPredicate Auths Empty.
   * </ul>
   *
   * <p>Method under test: {@link NamedViewWriteAccessPredicate#NamedViewWriteAccessPredicate(User,
   * List)}
   */
  @Test
  @DisplayName(
      "Test new NamedViewWriteAccessPredicate(User, List); when 'null'; then return UserPredicate Auths Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void NamedViewWriteAccessPredicate.<init>(User, List)"})
  void testNewNamedViewWriteAccessPredicate_whenNull_thenReturnUserPredicateAuthsEmpty2() {
    // Arrange and Act
    NamedViewWriteAccessPredicate actualNamedViewWriteAccessPredicate =
        new NamedViewWriteAccessPredicate(new User(), null);

    // Assert
    Predicate<User> userPredicate = actualNamedViewWriteAccessPredicate.getUserPredicate();
    assertTrue(userPredicate instanceof NamedViewWriteUserPredicate);
    assertEquals("UNKNOWN", ((NamedViewWriteUserPredicate) userPredicate).getCreatingUserId());
    assertTrue(((NamedViewWriteUserPredicate) userPredicate).getAuths().isEmpty());
  }
}
