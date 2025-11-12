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

package uk.gov.gchq.gaffer.data.elementdefinition.view.access.predicate.user;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.user.User;

class NamedViewWriteUserPredicateDiffblueTest {
  /**
   * Method under test:
   * {@link NamedViewWriteUserPredicate#isResourceCreator(User)}
   */
  @Test
  void testIsResourceCreator() {
    // Arrange
    NamedViewWriteUserPredicate namedViewWriteUserPredicate = new NamedViewWriteUserPredicate("42", new ArrayList<>());

    // Act and Assert
    assertFalse(namedViewWriteUserPredicate.isResourceCreator(new User()));
  }

  /**
   * Method under test:
   * {@link NamedViewWriteUserPredicate#isResourceCreator(User)}
   */
  @Test
  void testIsResourceCreator2() {
    // Arrange
    NamedViewWriteUserPredicate namedViewWriteUserPredicate = new NamedViewWriteUserPredicate("UNKNOWN",
        new ArrayList<>());

    // Act and Assert
    assertTrue(namedViewWriteUserPredicate.isResourceCreator(new User()));
  }

  /**
   * Method under test:
   * {@link NamedViewWriteUserPredicate#isResourceCreator(User)}
   */
  @Test
  void testIsResourceCreator3() {
    // Arrange, Act and Assert
    assertFalse((new NamedViewWriteUserPredicate("42", new ArrayList<>())).isResourceCreator(null));
  }

  /**
   * Method under test:
   * {@link NamedViewWriteUserPredicate#NamedViewWriteUserPredicate(String, List)}
   */
  @Test
  void testNewNamedViewWriteUserPredicate() {
    // Arrange and Act
    NamedViewWriteUserPredicate actualNamedViewWriteUserPredicate = new NamedViewWriteUserPredicate("42",
        new ArrayList<>());

    // Assert
    assertEquals("42", actualNamedViewWriteUserPredicate.getCreatingUserId());
    assertTrue(actualNamedViewWriteUserPredicate.getAuths().isEmpty());
  }

  /**
   * Method under test:
   * {@link NamedViewWriteUserPredicate#NamedViewWriteUserPredicate(String, List)}
   */
  @Test
  void testNewNamedViewWriteUserPredicate2() {
    // Arrange and Act
    NamedViewWriteUserPredicate actualNamedViewWriteUserPredicate = new NamedViewWriteUserPredicate("42", null);

    // Assert
    assertEquals("42", actualNamedViewWriteUserPredicate.getCreatingUserId());
    assertTrue(actualNamedViewWriteUserPredicate.getAuths().isEmpty());
  }

  /**
   * Method under test:
   * {@link NamedViewWriteUserPredicate#NamedViewWriteUserPredicate(String, List)}
   */
  @Test
  void testNewNamedViewWriteUserPredicate3() {
    // Arrange
    ArrayList<String> auths = new ArrayList<>();
    auths.add("foo");

    // Act
    NamedViewWriteUserPredicate actualNamedViewWriteUserPredicate = new NamedViewWriteUserPredicate("42", auths);

    // Assert
    assertEquals("42", actualNamedViewWriteUserPredicate.getCreatingUserId());
    List<String> auths2 = actualNamedViewWriteUserPredicate.getAuths();
    assertEquals(1, auths2.size());
    assertEquals("foo", auths2.get(0));
  }

  /**
   * Method under test:
   * {@link NamedViewWriteUserPredicate#NamedViewWriteUserPredicate(String, List)}
   */
  @Test
  void testNewNamedViewWriteUserPredicate4() {
    // Arrange
    ArrayList<String> auths = new ArrayList<>();
    auths.add("42");
    auths.add("foo");

    // Act
    NamedViewWriteUserPredicate actualNamedViewWriteUserPredicate = new NamedViewWriteUserPredicate("42", auths);

    // Assert
    assertEquals("42", actualNamedViewWriteUserPredicate.getCreatingUserId());
    assertEquals(auths, actualNamedViewWriteUserPredicate.getAuths());
  }
}
