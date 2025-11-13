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
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.function.Predicate;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.access.predicate.user.UnrestrictedAccessUserPredicate;
import uk.gov.gchq.gaffer.user.User;
import uk.gov.gchq.gaffer.user.User.Builder;

class UnrestrictedAccessPredicateDiffblueTest {
  /**
   * Test new {@link UnrestrictedAccessPredicate} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of {@link UnrestrictedAccessPredicate}
   */
  @Test
  @DisplayName("Test new UnrestrictedAccessPredicate (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void UnrestrictedAccessPredicate.<init>()"})
  void testNewUnrestrictedAccessPredicate() {
    // Arrange, Act and Assert
    assertTrue((new UnrestrictedAccessPredicate()).getUserPredicate() instanceof UnrestrictedAccessUserPredicate);
  }

  /**
   * Test {@link UnrestrictedAccessPredicate#getUserPredicate()}.
   * <p>
   * Method under test: {@link UnrestrictedAccessPredicate#getUserPredicate()}
   */
  @Test
  @DisplayName("Test getUserPredicate()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Predicate UnrestrictedAccessPredicate.getUserPredicate()"})
  void testGetUserPredicate() {
    // Arrange and Act
    Predicate<User> actualUserPredicate = (new UnrestrictedAccessPredicate()).getUserPredicate();
    User buildResult = (new Builder()).userId("42").build();

    // Assert
    assertTrue(actualUserPredicate instanceof UnrestrictedAccessUserPredicate);
    assertTrue(actualUserPredicate.test(buildResult));
    assertTrue(((UnrestrictedAccessUserPredicate) actualUserPredicate).test(null));
  }
}
