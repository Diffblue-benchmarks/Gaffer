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

package uk.gov.gchq.gaffer.federatedstore.access.predicate.user;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.user.User;
import uk.gov.gchq.gaffer.user.User.Builder;

class FederatedGraphWriteUserPredicateDiffblueTest {
  /**
   * Test {@link FederatedGraphWriteUserPredicate#FederatedGraphWriteUserPredicate(String)}.
   * <p>
   * Method under test: {@link FederatedGraphWriteUserPredicate#FederatedGraphWriteUserPredicate(String)}
   */
  @Test
  @DisplayName("Test new FederatedGraphWriteUserPredicate(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void FederatedGraphWriteUserPredicate.<init>(String)"})
  void testNewFederatedGraphWriteUserPredicate() {
    // Arrange and Act
    FederatedGraphWriteUserPredicate actualFederatedGraphWriteUserPredicate = new FederatedGraphWriteUserPredicate(
        "42");

    // Assert
    assertEquals("42", actualFederatedGraphWriteUserPredicate.getCreatingUserId());
    assertTrue(actualFederatedGraphWriteUserPredicate.getAuths().isEmpty());
  }

  /**
   * Test {@link FederatedGraphWriteUserPredicate#getAuths()}.
   * <p>
   * Method under test: {@link FederatedGraphWriteUserPredicate#getAuths()}
   */
  @Test
  @DisplayName("Test getAuths()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.util.List FederatedGraphWriteUserPredicate.getAuths()"})
  void testGetAuths() {
    // Arrange, Act and Assert
    assertTrue((new FederatedGraphWriteUserPredicate("42")).getAuths().isEmpty());
  }

  /**
   * Test {@link FederatedGraphWriteUserPredicate#test(User)} with {@code User}.
   * <p>
   * Method under test: {@link FederatedGraphWriteUserPredicate#test(User)}
   */
  @Test
  @DisplayName("Test test(User) with 'User'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean FederatedGraphWriteUserPredicate.test(User)"})
  void testTestWithUser() {
    // Arrange
    FederatedGraphWriteUserPredicate federatedGraphWriteUserPredicate = new FederatedGraphWriteUserPredicate("");

    // Act and Assert
    assertFalse(federatedGraphWriteUserPredicate.test(new User()));
  }

  /**
   * Test {@link FederatedGraphWriteUserPredicate#test(User)} with {@code User}.
   * <ul>
   *   <li>When {@link User.Builder} (default constructor) userId {@code 42} build.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FederatedGraphWriteUserPredicate#test(User)}
   */
  @Test
  @DisplayName("Test test(User) with 'User'; when Builder (default constructor) userId '42' build; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean FederatedGraphWriteUserPredicate.test(User)"})
  void testTestWithUser_whenBuilderUserId42Build_thenReturnTrue() {
    // Arrange
    FederatedGraphWriteUserPredicate federatedGraphWriteUserPredicate = new FederatedGraphWriteUserPredicate("42");
    User user = (new Builder()).userId("42").build();

    // Act and Assert
    assertTrue(federatedGraphWriteUserPredicate.test(user));
  }

  /**
   * Test {@link FederatedGraphWriteUserPredicate#test(User)} with {@code User}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FederatedGraphWriteUserPredicate#test(User)}
   */
  @Test
  @DisplayName("Test test(User) with 'User'; when 'null'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean FederatedGraphWriteUserPredicate.test(User)"})
  void testTestWithUser_whenNull_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new FederatedGraphWriteUserPredicate("42")).test(null));
  }

  /**
   * Test {@link FederatedGraphWriteUserPredicate#test(User)} with {@code User}.
   * <ul>
   *   <li>When {@link User#User()}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FederatedGraphWriteUserPredicate#test(User)}
   */
  @Test
  @DisplayName("Test test(User) with 'User'; when User(); then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean FederatedGraphWriteUserPredicate.test(User)"})
  void testTestWithUser_whenUser_thenReturnFalse() {
    // Arrange
    FederatedGraphWriteUserPredicate federatedGraphWriteUserPredicate = new FederatedGraphWriteUserPredicate("42");

    // Act and Assert
    assertFalse(federatedGraphWriteUserPredicate.test(new User()));
  }
}
