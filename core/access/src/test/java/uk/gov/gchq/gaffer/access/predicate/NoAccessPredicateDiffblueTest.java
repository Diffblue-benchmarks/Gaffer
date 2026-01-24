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

package uk.gov.gchq.gaffer.access.predicate;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.function.Predicate;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.access.predicate.user.NoAccessUserPredicate;
import uk.gov.gchq.gaffer.user.User;
import uk.gov.gchq.gaffer.user.User.Builder;

class NoAccessPredicateDiffblueTest {
  /**
   * Test new {@link NoAccessPredicate} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link NoAccessPredicate}
   */
  @Test
  @DisplayName("Test new NoAccessPredicate (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void NoAccessPredicate.<init>()"})
  void testNewNoAccessPredicate() {
    // Arrange, Act and Assert
    assertTrue(new NoAccessPredicate().getUserPredicate() instanceof NoAccessUserPredicate);
  }

  /**
   * Test {@link NoAccessPredicate#getUserPredicate()}.
   *
   * <p>Method under test: {@link NoAccessPredicate#getUserPredicate()}
   */
  @Test
  @DisplayName("Test getUserPredicate()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Predicate NoAccessPredicate.getUserPredicate()"})
  void testGetUserPredicate() {
    // Arrange and Act
    Predicate<User> actualUserPredicate = new NoAccessPredicate().getUserPredicate();
    boolean actualTestResult = actualUserPredicate.test(new Builder().userId("42").build());

    // Assert
    assertTrue(actualUserPredicate instanceof NoAccessUserPredicate);
    assertFalse(actualTestResult);
    assertFalse(((NoAccessUserPredicate) actualUserPredicate).test(null));
  }

  /**
   * Test {@link NoAccessPredicate#isAdministrator(User, String)}.
   *
   * <p>Method under test: {@link NoAccessPredicate#isAdministrator(User, String)}
   */
  @Test
  @DisplayName("Test isAdministrator(User, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean NoAccessPredicate.isAdministrator(User, String)"})
  void testIsAdministrator() {
    // Arrange
    NoAccessPredicate noAccessPredicate = new NoAccessPredicate();

    // Act and Assert
    assertFalse(noAccessPredicate.isAdministrator(new User(), "Admin Auth"));
  }
}
