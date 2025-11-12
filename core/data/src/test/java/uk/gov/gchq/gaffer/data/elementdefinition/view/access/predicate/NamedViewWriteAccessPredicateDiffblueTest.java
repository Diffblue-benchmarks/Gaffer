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

package uk.gov.gchq.gaffer.data.elementdefinition.view.access.predicate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.data.elementdefinition.view.access.predicate.user.NamedViewWriteUserPredicate;
import uk.gov.gchq.gaffer.user.User;

class NamedViewWriteAccessPredicateDiffblueTest {
  /**
   * Method under test:
   * {@link NamedViewWriteAccessPredicate#NamedViewWriteAccessPredicate(String, List)}
   */
  @Test
  void testNewNamedViewWriteAccessPredicate() {
    // Arrange, Act and Assert
    Predicate<User> userPredicate = (new NamedViewWriteAccessPredicate("42", new ArrayList<>())).getUserPredicate();
    assertTrue(userPredicate instanceof NamedViewWriteUserPredicate);
    assertEquals("42", ((NamedViewWriteUserPredicate) userPredicate).getCreatingUserId());
    assertTrue(((NamedViewWriteUserPredicate) userPredicate).getAuths().isEmpty());
  }

  /**
   * Method under test:
   * {@link NamedViewWriteAccessPredicate#NamedViewWriteAccessPredicate(String, List)}
   */
  @Test
  void testNewNamedViewWriteAccessPredicate2() {
    // Arrange, Act and Assert
    Predicate<User> userPredicate = (new NamedViewWriteAccessPredicate("42", null)).getUserPredicate();
    assertTrue(userPredicate instanceof NamedViewWriteUserPredicate);
    assertEquals("42", ((NamedViewWriteUserPredicate) userPredicate).getCreatingUserId());
    assertTrue(((NamedViewWriteUserPredicate) userPredicate).getAuths().isEmpty());
  }

  /**
   * Method under test:
   * {@link NamedViewWriteAccessPredicate#NamedViewWriteAccessPredicate(String, List)}
   */
  @Test
  void testNewNamedViewWriteAccessPredicate3() {
    // Arrange
    ArrayList<String> auths = new ArrayList<>();
    auths.add("foo");

    // Act and Assert
    Predicate<User> userPredicate = (new NamedViewWriteAccessPredicate("42", auths)).getUserPredicate();
    assertTrue(userPredicate instanceof NamedViewWriteUserPredicate);
    assertEquals("42", ((NamedViewWriteUserPredicate) userPredicate).getCreatingUserId());
    List<String> auths2 = ((NamedViewWriteUserPredicate) userPredicate).getAuths();
    assertEquals(1, auths2.size());
    assertEquals("foo", auths2.get(0));
  }

  /**
   * Method under test:
   * {@link NamedViewWriteAccessPredicate#NamedViewWriteAccessPredicate(String, List)}
   */
  @Test
  void testNewNamedViewWriteAccessPredicate4() {
    // Arrange
    ArrayList<String> auths = new ArrayList<>();
    auths.add("42");
    auths.add("foo");

    // Act and Assert
    Predicate<User> userPredicate = (new NamedViewWriteAccessPredicate("42", auths)).getUserPredicate();
    assertTrue(userPredicate instanceof NamedViewWriteUserPredicate);
    assertEquals("42", ((NamedViewWriteUserPredicate) userPredicate).getCreatingUserId());
    assertEquals(auths, ((NamedViewWriteUserPredicate) userPredicate).getAuths());
  }

  /**
   * Method under test:
   * {@link NamedViewWriteAccessPredicate#NamedViewWriteAccessPredicate(User, List)}
   */
  @Test
  void testNewNamedViewWriteAccessPredicate5() {
    // Arrange
    User creatingUser = new User();

    // Act and Assert
    Predicate<User> userPredicate = (new NamedViewWriteAccessPredicate(creatingUser, new ArrayList<>()))
        .getUserPredicate();
    assertTrue(userPredicate instanceof NamedViewWriteUserPredicate);
    assertEquals("UNKNOWN", ((NamedViewWriteUserPredicate) userPredicate).getCreatingUserId());
    assertTrue(((NamedViewWriteUserPredicate) userPredicate).getAuths().isEmpty());
  }

  /**
   * Method under test:
   * {@link NamedViewWriteAccessPredicate#NamedViewWriteAccessPredicate(User, List)}
   */
  @Test
  void testNewNamedViewWriteAccessPredicate6() {
    // Arrange, Act and Assert
    Predicate<User> userPredicate = (new NamedViewWriteAccessPredicate(new User(), null)).getUserPredicate();
    assertTrue(userPredicate instanceof NamedViewWriteUserPredicate);
    assertEquals("UNKNOWN", ((NamedViewWriteUserPredicate) userPredicate).getCreatingUserId());
    assertTrue(((NamedViewWriteUserPredicate) userPredicate).getAuths().isEmpty());
  }

  /**
   * Method under test:
   * {@link NamedViewWriteAccessPredicate#NamedViewWriteAccessPredicate(User, List)}
   */
  @Test
  void testNewNamedViewWriteAccessPredicate7() {
    // Arrange
    User creatingUser = new User();

    ArrayList<String> auths = new ArrayList<>();
    auths.add("foo");

    // Act and Assert
    Predicate<User> userPredicate = (new NamedViewWriteAccessPredicate(creatingUser, auths)).getUserPredicate();
    assertTrue(userPredicate instanceof NamedViewWriteUserPredicate);
    assertEquals("UNKNOWN", ((NamedViewWriteUserPredicate) userPredicate).getCreatingUserId());
    List<String> auths2 = ((NamedViewWriteUserPredicate) userPredicate).getAuths();
    assertEquals(1, auths2.size());
    assertEquals("foo", auths2.get(0));
  }

  /**
   * Method under test:
   * {@link NamedViewWriteAccessPredicate#NamedViewWriteAccessPredicate(User, List)}
   */
  @Test
  void testNewNamedViewWriteAccessPredicate8() {
    // Arrange
    User creatingUser = new User();

    ArrayList<String> auths = new ArrayList<>();
    auths.add("42");
    auths.add("foo");

    // Act and Assert
    Predicate<User> userPredicate = (new NamedViewWriteAccessPredicate(creatingUser, auths)).getUserPredicate();
    assertTrue(userPredicate instanceof NamedViewWriteUserPredicate);
    assertEquals("UNKNOWN", ((NamedViewWriteUserPredicate) userPredicate).getCreatingUserId());
    assertEquals(auths, ((NamedViewWriteUserPredicate) userPredicate).getAuths());
  }
}
