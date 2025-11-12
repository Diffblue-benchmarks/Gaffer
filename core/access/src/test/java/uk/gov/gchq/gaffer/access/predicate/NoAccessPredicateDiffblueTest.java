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

package uk.gov.gchq.gaffer.access.predicate;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.function.Predicate;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.access.predicate.user.NoAccessUserPredicate;
import uk.gov.gchq.gaffer.user.User;

class NoAccessPredicateDiffblueTest {
  /**
   * Method under test: {@link NoAccessPredicate#getUserPredicate()}
   */
  @Test
  void testGetUserPredicate() {
    // Arrange and Act
    Predicate<User> actualUserPredicate = (new NoAccessPredicate()).getUserPredicate();

    // Assert
    assertTrue(actualUserPredicate instanceof NoAccessUserPredicate);
    assertFalse(actualUserPredicate.test(new User()));
    assertFalse(((NoAccessUserPredicate) actualUserPredicate).test(null));
  }

  /**
   * Method under test: {@link NoAccessPredicate#isAdministrator(User, String)}
   */
  @Test
  void testIsAdministrator() {
    // Arrange
    NoAccessPredicate noAccessPredicate = new NoAccessPredicate();

    // Act and Assert
    assertFalse(noAccessPredicate.isAdministrator(new User(), "Admin Auth"));
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link NoAccessPredicate}
   */
  @Test
  void testNewNoAccessPredicate() {
    // Arrange, Act and Assert
    assertTrue((new NoAccessPredicate()).getUserPredicate() instanceof NoAccessUserPredicate);
  }
}
