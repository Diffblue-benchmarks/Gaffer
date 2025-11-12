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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import uk.gov.gchq.gaffer.access.predicate.user.DefaultUserPredicate;
import uk.gov.gchq.gaffer.user.User;

class AccessPredicateDiffblueTest {
  /**
   * Method under test: {@link AccessPredicate#test(User, String)}
   */
  @Test
  void testTest() {
    // Arrange
    Predicate<User> userPredicate = mock(Predicate.class);
    when(userPredicate.test(Mockito.<User>any())).thenReturn(true);
    AccessPredicate accessPredicate = new AccessPredicate(userPredicate);

    // Act
    boolean actualTestResult = accessPredicate.test(new User(), "Admin Auth");

    // Assert
    verify(userPredicate).test(isA(User.class));
    assertTrue(actualTestResult);
  }

  /**
   * Method under test: {@link AccessPredicate#test(User, String)}
   */
  @Test
  void testTest2() {
    // Arrange
    Predicate<User> userPredicate = mock(Predicate.class);
    when(userPredicate.test(Mockito.<User>any())).thenReturn(false);
    AccessPredicate accessPredicate = new AccessPredicate(userPredicate);

    // Act
    boolean actualTestResult = accessPredicate.test(new User(), "Admin Auth");

    // Assert
    verify(userPredicate).test(isA(User.class));
    assertFalse(actualTestResult);
  }

  /**
   * Method under test: {@link AccessPredicate#test(User, String)}
   */
  @Test
  void testTest3() {
    // Arrange
    AccessPredicate accessPredicate = new AccessPredicate("42", new ArrayList<>());

    // Act and Assert
    assertFalse(accessPredicate.test(new User(), "Admin Auth"));
  }

  /**
   * Method under test: {@link AccessPredicate#test(User, String)}
   */
  @Test
  void testTest4() {
    // Arrange
    NoAccessPredicate noAccessPredicate = new NoAccessPredicate();

    // Act and Assert
    assertFalse(noAccessPredicate.test(new User(), "Admin Auth"));
  }

  /**
   * Method under test: {@link AccessPredicate#test(User, String)}
   */
  @Test
  void testTest5() {
    // Arrange
    User creatingUser = new User();
    AccessPredicate accessPredicate = new AccessPredicate(creatingUser, new ArrayList<>());

    // Act and Assert
    assertTrue(accessPredicate.test(new User(), "Admin Auth"));
  }

  /**
   * Method under test: {@link AccessPredicate#test(User, String)}
   */
  @Test
  void testTest6() {
    // Arrange
    Predicate<User> userPredicate = mock(Predicate.class);
    when(userPredicate.test(Mockito.<User>any())).thenReturn(true);

    // Act
    boolean actualTestResult = (new AccessPredicate(userPredicate)).test(null, "Admin Auth");

    // Assert
    verify(userPredicate).test(isNull());
    assertTrue(actualTestResult);
  }

  /**
   * Method under test: {@link AccessPredicate#test(User, String)}
   */
  @Test
  void testTest7() {
    // Arrange
    Predicate<User> userPredicate = mock(Predicate.class);
    when(userPredicate.test(Mockito.<User>any())).thenReturn(true);
    AccessPredicate accessPredicate = new AccessPredicate(userPredicate);

    // Act
    boolean actualTestResult = accessPredicate.test(new User(), "");

    // Assert
    verify(userPredicate).test(isA(User.class));
    assertTrue(actualTestResult);
  }

  /**
   * Method under test: {@link AccessPredicate#test(User, String)}
   */
  @Test
  void testTest8() {
    // Arrange
    Predicate<User> userPredicate = mock(Predicate.class);
    when(userPredicate.test(Mockito.<User>any())).thenReturn(true);
    AccessPredicate accessPredicate = new AccessPredicate(userPredicate);

    // Act
    boolean actualTestResult = accessPredicate.test(new User(), null);

    // Assert
    verify(userPredicate).test(isA(User.class));
    assertTrue(actualTestResult);
  }

  /**
   * Method under test: {@link AccessPredicate#test(User, String)}
   */
  @Test
  void testTest9() {
    // Arrange
    AccessPredicate accessPredicate = new AccessPredicate("", new ArrayList<>());

    // Act and Assert
    assertFalse(accessPredicate.test(new User(), "Admin Auth"));
  }

  /**
   * Method under test: {@link AccessPredicate#test(User, String)}
   */
  @Test
  void testTest10() {
    // Arrange, Act and Assert
    assertFalse((new AccessPredicate("42", new ArrayList<>())).test(null, "Admin Auth"));
  }

  /**
   * Method under test: {@link AccessPredicate#isAdministrator(User, String)}
   */
  @Test
  void testIsAdministrator() {
    // Arrange
    AccessPredicate accessPredicate = new AccessPredicate(mock(Predicate.class));

    // Act and Assert
    assertFalse(accessPredicate.isAdministrator(new User(), "Admin Auth"));
  }

  /**
   * Method under test: {@link AccessPredicate#isAdministrator(User, String)}
   */
  @Test
  void testIsAdministrator2() {
    // Arrange
    AccessPredicate accessPredicate = new AccessPredicate(mock(Predicate.class));

    // Act and Assert
    assertFalse(accessPredicate.isAdministrator(new User(), null));
  }

  /**
   * Method under test: {@link AccessPredicate#isAdministrator(User, String)}
   */
  @Test
  void testIsAdministrator3() {
    // Arrange, Act and Assert
    assertFalse((new AccessPredicate(mock(Predicate.class))).isAdministrator(null, "Admin Auth"));
  }

  /**
   * Method under test: {@link AccessPredicate#isAdministrator(User, String)}
   */
  @Test
  void testIsAdministrator4() {
    // Arrange
    AccessPredicate accessPredicate = new AccessPredicate(mock(Predicate.class));

    // Act and Assert
    assertFalse(accessPredicate.isAdministrator(new User(), ""));
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link AccessPredicate#equals(Object)}
   *   <li>{@link AccessPredicate#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    AccessPredicate accessPredicate = new AccessPredicate(null);
    AccessPredicate accessPredicate2 = new AccessPredicate(null);

    // Act and Assert
    assertEquals(accessPredicate, accessPredicate2);
    int expectedHashCodeResult = accessPredicate.hashCode();
    assertEquals(expectedHashCodeResult, accessPredicate2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link AccessPredicate#equals(Object)}
   *   <li>{@link AccessPredicate#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    AccessPredicate accessPredicate = new AccessPredicate(mock(Predicate.class));

    // Act and Assert
    assertEquals(accessPredicate, accessPredicate);
    int expectedHashCodeResult = accessPredicate.hashCode();
    assertEquals(expectedHashCodeResult, accessPredicate.hashCode());
  }

  /**
   * Method under test: {@link AccessPredicate#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    AccessPredicate accessPredicate = new AccessPredicate(mock(Predicate.class));

    // Act and Assert
    assertNotEquals(accessPredicate, new AccessPredicate(mock(Predicate.class)));
  }

  /**
   * Method under test: {@link AccessPredicate#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new AccessPredicate(mock(Predicate.class)), null);
  }

  /**
   * Method under test: {@link AccessPredicate#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new AccessPredicate(mock(Predicate.class)), "Different type to AccessPredicate");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link AccessPredicate#AccessPredicate(Predicate)}
   *   <li>{@link AccessPredicate#getUserPredicate()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange
    Predicate<User> userPredicate = mock(Predicate.class);

    // Act and Assert
    assertSame(userPredicate, (new AccessPredicate(userPredicate)).getUserPredicate());
  }

  /**
   * Method under test: {@link AccessPredicate#AccessPredicate(String, List)}
   */
  @Test
  void testNewAccessPredicate() {
    // Arrange, Act and Assert
    Predicate<User> userPredicate = (new AccessPredicate("42", new ArrayList<>())).getUserPredicate();
    assertTrue(userPredicate instanceof DefaultUserPredicate);
    assertEquals("42", ((DefaultUserPredicate) userPredicate).getCreatingUserId());
    assertTrue(((DefaultUserPredicate) userPredicate).getAuths().isEmpty());
  }

  /**
   * Method under test: {@link AccessPredicate#AccessPredicate(String, List)}
   */
  @Test
  void testNewAccessPredicate2() {
    // Arrange, Act and Assert
    Predicate<User> userPredicate = (new AccessPredicate("42", null)).getUserPredicate();
    assertTrue(userPredicate instanceof DefaultUserPredicate);
    assertEquals("42", ((DefaultUserPredicate) userPredicate).getCreatingUserId());
    assertTrue(((DefaultUserPredicate) userPredicate).getAuths().isEmpty());
  }

  /**
   * Method under test: {@link AccessPredicate#AccessPredicate(String, List)}
   */
  @Test
  void testNewAccessPredicate3() {
    // Arrange
    ArrayList<String> auths = new ArrayList<>();
    auths.add("foo");

    // Act and Assert
    Predicate<User> userPredicate = (new AccessPredicate("42", auths)).getUserPredicate();
    assertTrue(userPredicate instanceof DefaultUserPredicate);
    assertEquals("42", ((DefaultUserPredicate) userPredicate).getCreatingUserId());
    List<String> auths2 = ((DefaultUserPredicate) userPredicate).getAuths();
    assertEquals(1, auths2.size());
    assertEquals("foo", auths2.get(0));
  }

  /**
   * Method under test: {@link AccessPredicate#AccessPredicate(String, List)}
   */
  @Test
  void testNewAccessPredicate4() {
    // Arrange
    ArrayList<String> auths = new ArrayList<>();
    auths.add("42");
    auths.add("foo");

    // Act and Assert
    Predicate<User> userPredicate = (new AccessPredicate("42", auths)).getUserPredicate();
    assertTrue(userPredicate instanceof DefaultUserPredicate);
    assertEquals("42", ((DefaultUserPredicate) userPredicate).getCreatingUserId());
    assertEquals(auths, ((DefaultUserPredicate) userPredicate).getAuths());
  }

  /**
   * Method under test: {@link AccessPredicate#AccessPredicate(User, List)}
   */
  @Test
  void testNewAccessPredicate5() {
    // Arrange
    User creatingUser = new User();

    // Act and Assert
    Predicate<User> userPredicate = (new AccessPredicate(creatingUser, new ArrayList<>())).getUserPredicate();
    assertTrue(userPredicate instanceof DefaultUserPredicate);
    assertEquals("UNKNOWN", ((DefaultUserPredicate) userPredicate).getCreatingUserId());
    assertTrue(((DefaultUserPredicate) userPredicate).getAuths().isEmpty());
  }

  /**
   * Method under test: {@link AccessPredicate#AccessPredicate(User, List)}
   */
  @Test
  void testNewAccessPredicate6() {
    // Arrange, Act and Assert
    Predicate<User> userPredicate = (new AccessPredicate(new User(), null)).getUserPredicate();
    assertTrue(userPredicate instanceof DefaultUserPredicate);
    assertEquals("UNKNOWN", ((DefaultUserPredicate) userPredicate).getCreatingUserId());
    assertTrue(((DefaultUserPredicate) userPredicate).getAuths().isEmpty());
  }

  /**
   * Method under test: {@link AccessPredicate#AccessPredicate(User, List)}
   */
  @Test
  void testNewAccessPredicate7() {
    // Arrange
    User creatingUser = new User();

    ArrayList<String> auths = new ArrayList<>();
    auths.add("foo");

    // Act and Assert
    Predicate<User> userPredicate = (new AccessPredicate(creatingUser, auths)).getUserPredicate();
    assertTrue(userPredicate instanceof DefaultUserPredicate);
    assertEquals("UNKNOWN", ((DefaultUserPredicate) userPredicate).getCreatingUserId());
    List<String> auths2 = ((DefaultUserPredicate) userPredicate).getAuths();
    assertEquals(1, auths2.size());
    assertEquals("foo", auths2.get(0));
  }

  /**
   * Method under test: {@link AccessPredicate#AccessPredicate(User, List)}
   */
  @Test
  void testNewAccessPredicate8() {
    // Arrange
    User creatingUser = new User();

    ArrayList<String> auths = new ArrayList<>();
    auths.add("42");
    auths.add("foo");

    // Act and Assert
    Predicate<User> userPredicate = (new AccessPredicate(creatingUser, auths)).getUserPredicate();
    assertTrue(userPredicate instanceof DefaultUserPredicate);
    assertEquals("UNKNOWN", ((DefaultUserPredicate) userPredicate).getCreatingUserId());
    assertEquals(auths, ((DefaultUserPredicate) userPredicate).getAuths());
  }
}
