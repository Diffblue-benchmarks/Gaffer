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

package uk.gov.gchq.gaffer.federatedstore.access.predicate.user;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.user.User;

class FederatedGraphReadUserPredicateDiffblueTest {
  /**
   * Test {@link FederatedGraphReadUserPredicate#FederatedGraphReadUserPredicate(String, List,
   * boolean)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link
   * FederatedGraphReadUserPredicate#FederatedGraphReadUserPredicate(String, List, boolean)}
   */
  @Test
  @DisplayName(
      "Test new FederatedGraphReadUserPredicate(String, List, boolean); given '42'; when ArrayList() add '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void FederatedGraphReadUserPredicate.<init>(String, List, boolean)"})
  void testNewFederatedGraphReadUserPredicate_given42_whenArrayListAdd42() {
    // Arrange
    ArrayList<String> auths = new ArrayList<>();
    auths.add("42");
    auths.add("foo");

    // Act
    FederatedGraphReadUserPredicate actualFederatedGraphReadUserPredicate =
        new FederatedGraphReadUserPredicate("42", auths, true);

    // Assert
    assertEquals("42", actualFederatedGraphReadUserPredicate.getCreatingUserId());
    assertTrue(actualFederatedGraphReadUserPredicate.isPublic());
    assertEquals(auths, actualFederatedGraphReadUserPredicate.getAuths());
  }

  /**
   * Test {@link FederatedGraphReadUserPredicate#FederatedGraphReadUserPredicate(String, List,
   * boolean)}.
   *
   * <ul>
   *   <li>Given {@code foo}.
   *   <li>Then return Auths is {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * FederatedGraphReadUserPredicate#FederatedGraphReadUserPredicate(String, List, boolean)}
   */
  @Test
  @DisplayName(
      "Test new FederatedGraphReadUserPredicate(String, List, boolean); given 'foo'; then return Auths is ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void FederatedGraphReadUserPredicate.<init>(String, List, boolean)"})
  void testNewFederatedGraphReadUserPredicate_givenFoo_thenReturnAuthsIsArrayList() {
    // Arrange
    ArrayList<String> auths = new ArrayList<>();
    auths.add("foo");

    // Act
    FederatedGraphReadUserPredicate actualFederatedGraphReadUserPredicate =
        new FederatedGraphReadUserPredicate("42", auths, true);

    // Assert
    assertEquals("42", actualFederatedGraphReadUserPredicate.getCreatingUserId());
    assertTrue(actualFederatedGraphReadUserPredicate.isPublic());
    assertEquals(auths, actualFederatedGraphReadUserPredicate.getAuths());
  }

  /**
   * Test {@link FederatedGraphReadUserPredicate#FederatedGraphReadUserPredicate(String, List,
   * boolean)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return Auths Empty.
   * </ul>
   *
   * <p>Method under test: {@link
   * FederatedGraphReadUserPredicate#FederatedGraphReadUserPredicate(String, List, boolean)}
   */
  @Test
  @DisplayName(
      "Test new FederatedGraphReadUserPredicate(String, List, boolean); when ArrayList(); then return Auths Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void FederatedGraphReadUserPredicate.<init>(String, List, boolean)"})
  void testNewFederatedGraphReadUserPredicate_whenArrayList_thenReturnAuthsEmpty() {
    // Arrange and Act
    FederatedGraphReadUserPredicate actualFederatedGraphReadUserPredicate =
        new FederatedGraphReadUserPredicate("42", new ArrayList<>(), true);

    // Assert
    assertEquals("42", actualFederatedGraphReadUserPredicate.getCreatingUserId());
    assertTrue(actualFederatedGraphReadUserPredicate.getAuths().isEmpty());
    assertTrue(actualFederatedGraphReadUserPredicate.isPublic());
  }

  /**
   * Test {@link FederatedGraphReadUserPredicate#FederatedGraphReadUserPredicate(String, List,
   * boolean)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return Auths Empty.
   * </ul>
   *
   * <p>Method under test: {@link
   * FederatedGraphReadUserPredicate#FederatedGraphReadUserPredicate(String, List, boolean)}
   */
  @Test
  @DisplayName(
      "Test new FederatedGraphReadUserPredicate(String, List, boolean); when 'null'; then return Auths Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void FederatedGraphReadUserPredicate.<init>(String, List, boolean)"})
  void testNewFederatedGraphReadUserPredicate_whenNull_thenReturnAuthsEmpty() {
    // Arrange and Act
    FederatedGraphReadUserPredicate actualFederatedGraphReadUserPredicate =
        new FederatedGraphReadUserPredicate("42", null, true);

    // Assert
    assertEquals("42", actualFederatedGraphReadUserPredicate.getCreatingUserId());
    assertTrue(actualFederatedGraphReadUserPredicate.getAuths().isEmpty());
    assertTrue(actualFederatedGraphReadUserPredicate.isPublic());
  }

  /**
   * Test {@link FederatedGraphReadUserPredicate#test(User)} with {@code User}.
   *
   * <p>Method under test: {@link FederatedGraphReadUserPredicate#test(User)}
   */
  @Test
  @DisplayName("Test test(User) with 'User'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean FederatedGraphReadUserPredicate.test(User)"})
  void testTestWithUser() {
    // Arrange
    FederatedGraphReadUserPredicate federatedGraphReadUserPredicate =
        new FederatedGraphReadUserPredicate("42", new ArrayList<>(), true);

    // Act and Assert
    assertTrue(federatedGraphReadUserPredicate.test(new User()));
  }

  /**
   * Test {@link FederatedGraphReadUserPredicate#test(User)} with {@code User}.
   *
   * <p>Method under test: {@link FederatedGraphReadUserPredicate#test(User)}
   */
  @Test
  @DisplayName("Test test(User) with 'User'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean FederatedGraphReadUserPredicate.test(User)"})
  void testTestWithUser2() {
    // Arrange
    FederatedGraphReadUserPredicate federatedGraphReadUserPredicate =
        new FederatedGraphReadUserPredicate("42", new ArrayList<>(), false);

    // Act and Assert
    assertFalse(federatedGraphReadUserPredicate.test(new User()));
  }

  /**
   * Test {@link FederatedGraphReadUserPredicate#test(User)} with {@code User}.
   *
   * <p>Method under test: {@link FederatedGraphReadUserPredicate#test(User)}
   */
  @Test
  @DisplayName("Test test(User) with 'User'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean FederatedGraphReadUserPredicate.test(User)"})
  void testTestWithUser3() {
    // Arrange
    FederatedGraphReadUserPredicate federatedGraphReadUserPredicate =
        new FederatedGraphReadUserPredicate("UNKNOWN", new ArrayList<>(), false);

    // Act and Assert
    assertTrue(federatedGraphReadUserPredicate.test(new User()));
  }

  /**
   * Test {@link FederatedGraphReadUserPredicate#test(User)} with {@code User}.
   *
   * <p>Method under test: {@link FederatedGraphReadUserPredicate#test(User)}
   */
  @Test
  @DisplayName("Test test(User) with 'User'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean FederatedGraphReadUserPredicate.test(User)"})
  void testTestWithUser4() {
    // Arrange
    FederatedGraphReadUserPredicate federatedGraphReadUserPredicate =
        new FederatedGraphReadUserPredicate("", new ArrayList<>(), false);

    // Act and Assert
    assertFalse(federatedGraphReadUserPredicate.test(new User()));
  }

  /**
   * Test {@link FederatedGraphReadUserPredicate#test(User)} with {@code User}.
   *
   * <ul>
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link FederatedGraphReadUserPredicate#test(User)}
   */
  @Test
  @DisplayName("Test test(User) with 'User'; when 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean FederatedGraphReadUserPredicate.test(User)"})
  void testTestWithUser_whenNull() {
    // Arrange
    FederatedGraphReadUserPredicate federatedGraphReadUserPredicate =
        new FederatedGraphReadUserPredicate("42", new ArrayList<>(), false);

    // Act and Assert
    assertFalse(federatedGraphReadUserPredicate.test(null));
  }

  /**
   * Test {@link FederatedGraphReadUserPredicate#isPublic()}.
   *
   * <p>Method under test: {@link FederatedGraphReadUserPredicate#isPublic()}
   */
  @Test
  @DisplayName("Test isPublic()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean FederatedGraphReadUserPredicate.isPublic()"})
  void testIsPublic() {
    // Arrange
    FederatedGraphReadUserPredicate federatedGraphReadUserPredicate =
        new FederatedGraphReadUserPredicate("42", new ArrayList<>(), true);

    // Act and Assert
    assertTrue(federatedGraphReadUserPredicate.isPublic());
  }

  /**
   * Test {@link FederatedGraphReadUserPredicate#hasPermission(User)}.
   *
   * <ul>
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link FederatedGraphReadUserPredicate#hasPermission(User)}
   */
  @Test
  @DisplayName("Test hasPermission(User); when 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean FederatedGraphReadUserPredicate.hasPermission(User)"})
  void testHasPermission_whenNull() {
    // Arrange
    FederatedGraphReadUserPredicate federatedGraphReadUserPredicate =
        new FederatedGraphReadUserPredicate("42", new ArrayList<>(), true);

    // Act and Assert
    assertFalse(federatedGraphReadUserPredicate.hasPermission(null));
  }

  /**
   * Test {@link FederatedGraphReadUserPredicate#hasPermission(User)}.
   *
   * <ul>
   *   <li>When {@link User#User()}.
   * </ul>
   *
   * <p>Method under test: {@link FederatedGraphReadUserPredicate#hasPermission(User)}
   */
  @Test
  @DisplayName("Test hasPermission(User); when User()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean FederatedGraphReadUserPredicate.hasPermission(User)"})
  void testHasPermission_whenUser() {
    // Arrange
    FederatedGraphReadUserPredicate federatedGraphReadUserPredicate =
        new FederatedGraphReadUserPredicate("42", new ArrayList<>(), true);

    // Act and Assert
    assertFalse(federatedGraphReadUserPredicate.hasPermission(new User()));
  }

  /**
   * Test {@link FederatedGraphReadUserPredicate#equals(Object)}, and {@link
   * FederatedGraphReadUserPredicate#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link FederatedGraphReadUserPredicate#equals(Object)}
   *   <li>{@link FederatedGraphReadUserPredicate#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean FederatedGraphReadUserPredicate.equals(Object)",
    "int FederatedGraphReadUserPredicate.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    FederatedGraphReadUserPredicate federatedGraphReadUserPredicate =
        new FederatedGraphReadUserPredicate("42", new ArrayList<>(), true);
    FederatedGraphReadUserPredicate federatedGraphReadUserPredicate2 =
        new FederatedGraphReadUserPredicate("42", new ArrayList<>(), true);

    // Act and Assert
    assertEquals(federatedGraphReadUserPredicate, federatedGraphReadUserPredicate2);
    assertEquals(
        federatedGraphReadUserPredicate.hashCode(), federatedGraphReadUserPredicate2.hashCode());
  }

  /**
   * Test {@link FederatedGraphReadUserPredicate#equals(Object)}, and {@link
   * FederatedGraphReadUserPredicate#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link FederatedGraphReadUserPredicate#equals(Object)}
   *   <li>{@link FederatedGraphReadUserPredicate#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean FederatedGraphReadUserPredicate.equals(Object)",
    "int FederatedGraphReadUserPredicate.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    FederatedGraphReadUserPredicate federatedGraphReadUserPredicate =
        new FederatedGraphReadUserPredicate("42", new ArrayList<>(), true);

    // Act and Assert
    assertEquals(federatedGraphReadUserPredicate, federatedGraphReadUserPredicate);
    int expectedHashCodeResult = federatedGraphReadUserPredicate.hashCode();
    assertEquals(expectedHashCodeResult, federatedGraphReadUserPredicate.hashCode());
  }

  /**
   * Test {@link FederatedGraphReadUserPredicate#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link FederatedGraphReadUserPredicate#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean FederatedGraphReadUserPredicate.equals(Object)",
    "int FederatedGraphReadUserPredicate.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    FederatedGraphReadUserPredicate federatedGraphReadUserPredicate =
        new FederatedGraphReadUserPredicate("Creating User Id", new ArrayList<>(), true);

    // Act and Assert
    assertNotEquals(
        federatedGraphReadUserPredicate,
        new FederatedGraphReadUserPredicate("42", new ArrayList<>(), true));
  }

  /**
   * Test {@link FederatedGraphReadUserPredicate#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link FederatedGraphReadUserPredicate#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean FederatedGraphReadUserPredicate.equals(Object)",
    "int FederatedGraphReadUserPredicate.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new FederatedGraphReadUserPredicate("42", new ArrayList<>(), true), null);
  }

  /**
   * Test {@link FederatedGraphReadUserPredicate#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link FederatedGraphReadUserPredicate#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean FederatedGraphReadUserPredicate.equals(Object)",
    "int FederatedGraphReadUserPredicate.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        new FederatedGraphReadUserPredicate("42", new ArrayList<>(), true),
        "Different type to FederatedGraphReadUserPredicate");
  }
}
