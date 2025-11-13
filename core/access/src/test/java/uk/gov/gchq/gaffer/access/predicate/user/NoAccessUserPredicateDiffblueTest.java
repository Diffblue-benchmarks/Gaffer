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

import static org.junit.jupiter.api.Assertions.assertFalse;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.user.User;

class NoAccessUserPredicateDiffblueTest {
  /**
   * Test {@link NoAccessUserPredicate#test(User)} with {@code User}.
   * <p>
   * Method under test: {@link NoAccessUserPredicate#test(User)}
   */
  @Test
  @DisplayName("Test test(User) with 'User'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean NoAccessUserPredicate.test(User)"})
  void testTestWithUser() {
    // Arrange
    NoAccessUserPredicate noAccessUserPredicate = new NoAccessUserPredicate();

    // Act and Assert
    assertFalse(noAccessUserPredicate.test(new User()));
  }
}
