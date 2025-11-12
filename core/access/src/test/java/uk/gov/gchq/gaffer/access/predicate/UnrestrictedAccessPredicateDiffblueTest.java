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

import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.function.Predicate;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.access.predicate.user.UnrestrictedAccessUserPredicate;
import uk.gov.gchq.gaffer.user.User;

class UnrestrictedAccessPredicateDiffblueTest {
  /**
   * Method under test: {@link UnrestrictedAccessPredicate#getUserPredicate()}
   */
  @Test
  void testGetUserPredicate() {
    // Arrange and Act
    Predicate<User> actualUserPredicate = (new UnrestrictedAccessPredicate()).getUserPredicate();

    // Assert
    assertTrue(actualUserPredicate instanceof UnrestrictedAccessUserPredicate);
    assertTrue(actualUserPredicate.test(new User()));
    assertTrue(((UnrestrictedAccessUserPredicate) actualUserPredicate).test(null));
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link UnrestrictedAccessPredicate}
   */
  @Test
  void testNewUnrestrictedAccessPredicate() {
    // Arrange, Act and Assert
    assertTrue((new UnrestrictedAccessPredicate()).getUserPredicate() instanceof UnrestrictedAccessUserPredicate);
  }
}
