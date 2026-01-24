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

import static org.junit.jupiter.api.Assertions.assertFalse;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.user.User;

class FederatedGraphAccessPredicateDiffblueTest {
  /**
   * Test {@link FederatedGraphAccessPredicate#isAdministrator(User, String)}.
   *
   * <ul>
   *   <li>When empty string.
   * </ul>
   *
   * <p>Method under test: {@link FederatedGraphAccessPredicate#isAdministrator(User, String)}
   */
  @Test
  @DisplayName("Test isAdministrator(User, String); when empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean FederatedGraphAccessPredicate.isAdministrator(User, String)"})
  void testIsAdministrator_whenEmptyString() {
    // Arrange
    FederatedGraphWriteAccessPredicate federatedGraphWriteAccessPredicate =
        new FederatedGraphWriteAccessPredicate("42");

    // Act and Assert
    assertFalse(federatedGraphWriteAccessPredicate.isAdministrator(new User(), ""));
  }

  /**
   * Test {@link FederatedGraphAccessPredicate#isAdministrator(User, String)}.
   *
   * <ul>
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link FederatedGraphAccessPredicate#isAdministrator(User, String)}
   */
  @Test
  @DisplayName("Test isAdministrator(User, String); when 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean FederatedGraphAccessPredicate.isAdministrator(User, String)"})
  void testIsAdministrator_whenNull() {
    // Arrange, Act and Assert
    assertFalse(new FederatedGraphWriteAccessPredicate("42").isAdministrator(null, "Admin Auth"));
  }

  /**
   * Test {@link FederatedGraphAccessPredicate#isAdministrator(User, String)}.
   *
   * <ul>
   *   <li>When {@link User#User()}.
   * </ul>
   *
   * <p>Method under test: {@link FederatedGraphAccessPredicate#isAdministrator(User, String)}
   */
  @Test
  @DisplayName("Test isAdministrator(User, String); when User()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean FederatedGraphAccessPredicate.isAdministrator(User, String)"})
  void testIsAdministrator_whenUser() {
    // Arrange
    FederatedGraphWriteAccessPredicate federatedGraphWriteAccessPredicate =
        new FederatedGraphWriteAccessPredicate("42");

    // Act and Assert
    assertFalse(federatedGraphWriteAccessPredicate.isAdministrator(new User(), "Admin Auth"));
  }
}
