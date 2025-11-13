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

package uk.gov.gchq.gaffer.access.predicate.user;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
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
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultUserPredicate#DefaultUserPredicate(String, List)}
   */
  @Test
  @DisplayName("Test new DefaultUserPredicate(String, List); given '42'; when ArrayList() add '42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void DefaultUserPredicate.<init>(String, List)"})
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
   * <ul>
   *   <li>Given {@code foo}.</li>
   *   <li>Then return Auths is {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultUserPredicate#DefaultUserPredicate(String, List)}
   */
  @Test
  @DisplayName("Test new DefaultUserPredicate(String, List); given 'foo'; then return Auths is ArrayList()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void DefaultUserPredicate.<init>(String, List)"})
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
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return Auths Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultUserPredicate#DefaultUserPredicate(String, List)}
   */
  @Test
  @DisplayName("Test new DefaultUserPredicate(String, List); when ArrayList(); then return Auths Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void DefaultUserPredicate.<init>(String, List)"})
  void testNewDefaultUserPredicate_whenArrayList_thenReturnAuthsEmpty() {
    // Arrange and Act
    DefaultUserPredicate actualDefaultUserPredicate = new DefaultUserPredicate("42", new ArrayList<>());

    // Assert
    assertEquals("42", actualDefaultUserPredicate.getCreatingUserId());
    assertTrue(actualDefaultUserPredicate.getAuths().isEmpty());
  }

  /**
   * Test {@link DefaultUserPredicate#DefaultUserPredicate(String, List)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return Auths Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultUserPredicate#DefaultUserPredicate(String, List)}
   */
  @Test
  @DisplayName("Test new DefaultUserPredicate(String, List); when 'null'; then return Auths Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void DefaultUserPredicate.<init>(String, List)"})
  void testNewDefaultUserPredicate_whenNull_thenReturnAuthsEmpty() {
    // Arrange and Act
    DefaultUserPredicate actualDefaultUserPredicate = new DefaultUserPredicate("42", null);

    // Assert
    assertEquals("42", actualDefaultUserPredicate.getCreatingUserId());
    assertTrue(actualDefaultUserPredicate.getAuths().isEmpty());
  }

  /**
   * Test {@link DefaultUserPredicate#equals(Object)}, and {@link DefaultUserPredicate#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link DefaultUserPredicate#equals(Object)}
   *   <li>{@link DefaultUserPredicate#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean DefaultUserPredicate.equals(Object)", "int DefaultUserPredicate.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    DefaultUserPredicate defaultUserPredicate = new DefaultUserPredicate("42", new ArrayList<>());
    DefaultUserPredicate defaultUserPredicate2 = new DefaultUserPredicate("42", new ArrayList<>());

    // Act and Assert
    assertEquals(defaultUserPredicate, defaultUserPredicate2);
    int expectedHashCodeResult = defaultUserPredicate.hashCode();
    assertEquals(expectedHashCodeResult, defaultUserPredicate2.hashCode());
  }

  /**
   * Test {@link DefaultUserPredicate#equals(Object)}, and {@link DefaultUserPredicate#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link DefaultUserPredicate#equals(Object)}
   *   <li>{@link DefaultUserPredicate#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean DefaultUserPredicate.equals(Object)", "int DefaultUserPredicate.hashCode()"})
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
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultUserPredicate#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean DefaultUserPredicate.equals(Object)", "int DefaultUserPredicate.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    DefaultUserPredicate defaultUserPredicate = new DefaultUserPredicate("Creating User Id", new ArrayList<>());

    // Act and Assert
    assertNotEquals(defaultUserPredicate, new DefaultUserPredicate("42", new ArrayList<>()));
  }

  /**
   * Test {@link DefaultUserPredicate#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultUserPredicate#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean DefaultUserPredicate.equals(Object)", "int DefaultUserPredicate.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new DefaultUserPredicate("42", new ArrayList<>()), null);
  }

  /**
   * Test {@link DefaultUserPredicate#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultUserPredicate#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean DefaultUserPredicate.equals(Object)", "int DefaultUserPredicate.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new DefaultUserPredicate("42", new ArrayList<>()), "Different type to DefaultUserPredicate");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link DefaultUserPredicate#getAuths()}
   *   <li>{@link DefaultUserPredicate#getCreatingUserId()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List DefaultUserPredicate.getAuths()", "String DefaultUserPredicate.getCreatingUserId()"})
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
   * <p>
   * Method under test: {@link DefaultUserPredicate#test(User)}
   */
  @Test
  @DisplayName("Test test(User) with 'User'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean DefaultUserPredicate.test(User)"})
  void testTestWithUser() {
    // Arrange
    DefaultUserPredicate defaultUserPredicate = new DefaultUserPredicate("", new ArrayList<>());

    // Act and Assert
    assertFalse(defaultUserPredicate.test(new User()));
  }

  /**
   * Test {@link DefaultUserPredicate#test(User)} with {@code User}.
   * <ul>
   *   <li>When {@link User.Builder} (default constructor) userId {@code 42} build.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultUserPredicate#test(User)}
   */
  @Test
  @DisplayName("Test test(User) with 'User'; when Builder (default constructor) userId '42' build; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean DefaultUserPredicate.test(User)"})
  void testTestWithUser_whenBuilderUserId42Build_thenReturnTrue() {
    // Arrange
    DefaultUserPredicate defaultUserPredicate = new DefaultUserPredicate("42", new ArrayList<>());
    User user = (new Builder()).userId("42").build();

    // Act and Assert
    assertTrue(defaultUserPredicate.test(user));
  }

  /**
   * Test {@link DefaultUserPredicate#test(User)} with {@code User}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultUserPredicate#test(User)}
   */
  @Test
  @DisplayName("Test test(User) with 'User'; when 'null'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean DefaultUserPredicate.test(User)"})
  void testTestWithUser_whenNull_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new DefaultUserPredicate("42", new ArrayList<>())).test(null));
  }

  /**
   * Test {@link DefaultUserPredicate#test(User)} with {@code User}.
   * <ul>
   *   <li>When {@link User#User()}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultUserPredicate#test(User)}
   */
  @Test
  @DisplayName("Test test(User) with 'User'; when User(); then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean DefaultUserPredicate.test(User)"})
  void testTestWithUser_whenUser_thenReturnFalse() {
    // Arrange
    DefaultUserPredicate defaultUserPredicate = new DefaultUserPredicate("42", new ArrayList<>());

    // Act and Assert
    assertFalse(defaultUserPredicate.test(new User()));
  }

  /**
   * Test {@link DefaultUserPredicate#isResourceCreator(User)}.
   * <p>
   * Method under test: {@link DefaultUserPredicate#isResourceCreator(User)}
   */
  @Test
  @DisplayName("Test isResourceCreator(User)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean DefaultUserPredicate.isResourceCreator(User)"})
  void testIsResourceCreator() {
    // Arrange
    DefaultUserPredicate defaultUserPredicate = new DefaultUserPredicate("", new ArrayList<>());

    // Act and Assert
    assertFalse(defaultUserPredicate.isResourceCreator(new User()));
  }

  /**
   * Test {@link DefaultUserPredicate#isResourceCreator(User)}.
   * <ul>
   *   <li>When {@link User.Builder} (default constructor) userId {@code 42} build.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultUserPredicate#isResourceCreator(User)}
   */
  @Test
  @DisplayName("Test isResourceCreator(User); when Builder (default constructor) userId '42' build; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean DefaultUserPredicate.isResourceCreator(User)"})
  void testIsResourceCreator_whenBuilderUserId42Build_thenReturnTrue() {
    // Arrange
    DefaultUserPredicate defaultUserPredicate = new DefaultUserPredicate("42", new ArrayList<>());
    User user = (new Builder()).userId("42").build();

    // Act and Assert
    assertTrue(defaultUserPredicate.isResourceCreator(user));
  }

  /**
   * Test {@link DefaultUserPredicate#isResourceCreator(User)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultUserPredicate#isResourceCreator(User)}
   */
  @Test
  @DisplayName("Test isResourceCreator(User); when 'null'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean DefaultUserPredicate.isResourceCreator(User)"})
  void testIsResourceCreator_whenNull_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new DefaultUserPredicate("42", new ArrayList<>())).isResourceCreator(null));
  }

  /**
   * Test {@link DefaultUserPredicate#isResourceCreator(User)}.
   * <ul>
   *   <li>When {@link User#User()}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultUserPredicate#isResourceCreator(User)}
   */
  @Test
  @DisplayName("Test isResourceCreator(User); when User(); then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean DefaultUserPredicate.isResourceCreator(User)"})
  void testIsResourceCreator_whenUser_thenReturnFalse() {
    // Arrange
    DefaultUserPredicate defaultUserPredicate = new DefaultUserPredicate("42", new ArrayList<>());

    // Act and Assert
    assertFalse(defaultUserPredicate.isResourceCreator(new User()));
  }

  /**
   * Test {@link DefaultUserPredicate#hasPermission(User)}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultUserPredicate#hasPermission(User)}
   */
  @Test
  @DisplayName("Test hasPermission(User); when 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean DefaultUserPredicate.hasPermission(User)"})
  void testHasPermission_whenNull() {
    // Arrange, Act and Assert
    assertFalse((new DefaultUserPredicate("42", new ArrayList<>())).hasPermission(null));
  }

  /**
   * Test {@link DefaultUserPredicate#hasPermission(User)}.
   * <ul>
   *   <li>When {@link User#User()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultUserPredicate#hasPermission(User)}
   */
  @Test
  @DisplayName("Test hasPermission(User); when User()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean DefaultUserPredicate.hasPermission(User)"})
  void testHasPermission_whenUser() {
    // Arrange
    DefaultUserPredicate defaultUserPredicate = new DefaultUserPredicate("42", new ArrayList<>());

    // Act and Assert
    assertFalse(defaultUserPredicate.hasPermission(new User()));
  }
}
