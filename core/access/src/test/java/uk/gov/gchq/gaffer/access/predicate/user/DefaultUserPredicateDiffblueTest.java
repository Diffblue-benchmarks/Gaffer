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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.user.User;

class DefaultUserPredicateDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link DefaultUserPredicate#equals(Object)}
   *   <li>{@link DefaultUserPredicate#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    DefaultUserPredicate defaultUserPredicate = new DefaultUserPredicate("42", new ArrayList<>());
    DefaultUserPredicate defaultUserPredicate2 = new DefaultUserPredicate("42", new ArrayList<>());

    // Act and Assert
    assertEquals(defaultUserPredicate, defaultUserPredicate2);
    int expectedHashCodeResult = defaultUserPredicate.hashCode();
    assertEquals(expectedHashCodeResult, defaultUserPredicate2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link DefaultUserPredicate#equals(Object)}
   *   <li>{@link DefaultUserPredicate#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    DefaultUserPredicate defaultUserPredicate = new DefaultUserPredicate("42", new ArrayList<>());

    // Act and Assert
    assertEquals(defaultUserPredicate, defaultUserPredicate);
    int expectedHashCodeResult = defaultUserPredicate.hashCode();
    assertEquals(expectedHashCodeResult, defaultUserPredicate.hashCode());
  }

  /**
   * Method under test: {@link DefaultUserPredicate#test(User)}
   */
  @Test
  void testTest() {
    // Arrange
    DefaultUserPredicate defaultUserPredicate = new DefaultUserPredicate("42", new ArrayList<>());

    // Act and Assert
    assertFalse(defaultUserPredicate.test(new User()));
  }

  /**
   * Method under test: {@link DefaultUserPredicate#test(User)}
   */
  @Test
  void testTest2() {
    // Arrange
    DefaultUserPredicate defaultUserPredicate = new DefaultUserPredicate("UNKNOWN", new ArrayList<>());

    // Act and Assert
    assertTrue(defaultUserPredicate.test(new User()));
  }

  /**
   * Method under test: {@link DefaultUserPredicate#test(User)}
   */
  @Test
  void testTest3() {
    // Arrange
    DefaultUserPredicate defaultUserPredicate = new DefaultUserPredicate("", new ArrayList<>());

    // Act and Assert
    assertFalse(defaultUserPredicate.test(new User()));
  }

  /**
   * Method under test: {@link DefaultUserPredicate#test(User)}
   */
  @Test
  void testTest4() {
    // Arrange, Act and Assert
    assertFalse((new DefaultUserPredicate("42", new ArrayList<>())).test(null));
  }

  /**
   * Method under test: {@link DefaultUserPredicate#isResourceCreator(User)}
   */
  @Test
  void testIsResourceCreator() {
    // Arrange
    DefaultUserPredicate defaultUserPredicate = new DefaultUserPredicate("42", new ArrayList<>());

    // Act and Assert
    assertFalse(defaultUserPredicate.isResourceCreator(new User()));
  }

  /**
   * Method under test: {@link DefaultUserPredicate#isResourceCreator(User)}
   */
  @Test
  void testIsResourceCreator2() {
    // Arrange
    DefaultUserPredicate defaultUserPredicate = new DefaultUserPredicate("UNKNOWN", new ArrayList<>());

    // Act and Assert
    assertTrue(defaultUserPredicate.isResourceCreator(new User()));
  }

  /**
   * Method under test: {@link DefaultUserPredicate#isResourceCreator(User)}
   */
  @Test
  void testIsResourceCreator3() {
    // Arrange
    DefaultUserPredicate defaultUserPredicate = new DefaultUserPredicate("", new ArrayList<>());

    // Act and Assert
    assertFalse(defaultUserPredicate.isResourceCreator(new User()));
  }

  /**
   * Method under test: {@link DefaultUserPredicate#isResourceCreator(User)}
   */
  @Test
  void testIsResourceCreator4() {
    // Arrange, Act and Assert
    assertFalse((new DefaultUserPredicate("42", new ArrayList<>())).isResourceCreator(null));
  }

  /**
   * Method under test: {@link DefaultUserPredicate#hasPermission(User)}
   */
  @Test
  void testHasPermission() {
    // Arrange
    DefaultUserPredicate defaultUserPredicate = new DefaultUserPredicate("42", new ArrayList<>());

    // Act and Assert
    assertFalse(defaultUserPredicate.hasPermission(new User()));
  }

  /**
   * Method under test: {@link DefaultUserPredicate#hasPermission(User)}
   */
  @Test
  void testHasPermission2() {
    // Arrange, Act and Assert
    assertFalse((new DefaultUserPredicate("42", new ArrayList<>())).hasPermission(null));
  }

  /**
   * Method under test: {@link DefaultUserPredicate#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    DefaultUserPredicate defaultUserPredicate = new DefaultUserPredicate("Creating User Id", new ArrayList<>());

    // Act and Assert
    assertNotEquals(defaultUserPredicate, new DefaultUserPredicate("42", new ArrayList<>()));
  }

  /**
   * Method under test: {@link DefaultUserPredicate#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new DefaultUserPredicate("42", new ArrayList<>()), null);
  }

  /**
   * Method under test: {@link DefaultUserPredicate#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new DefaultUserPredicate("42", new ArrayList<>()), "Different type to DefaultUserPredicate");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link DefaultUserPredicate#getAuths()}
   *   <li>{@link DefaultUserPredicate#getCreatingUserId()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange
    DefaultUserPredicate defaultUserPredicate = new DefaultUserPredicate("42", new ArrayList<>());

    // Act
    List<String> actualAuths = defaultUserPredicate.getAuths();

    // Assert
    assertEquals("42", defaultUserPredicate.getCreatingUserId());
    assertTrue(actualAuths.isEmpty());
  }

  /**
   * Method under test:
   * {@link DefaultUserPredicate#DefaultUserPredicate(String, List)}
   */
  @Test
  void testNewDefaultUserPredicate() {
    // Arrange and Act
    DefaultUserPredicate actualDefaultUserPredicate = new DefaultUserPredicate("42", new ArrayList<>());

    // Assert
    assertEquals("42", actualDefaultUserPredicate.getCreatingUserId());
    assertTrue(actualDefaultUserPredicate.getAuths().isEmpty());
  }

  /**
   * Method under test:
   * {@link DefaultUserPredicate#DefaultUserPredicate(String, List)}
   */
  @Test
  void testNewDefaultUserPredicate2() {
    // Arrange and Act
    DefaultUserPredicate actualDefaultUserPredicate = new DefaultUserPredicate("42", null);

    // Assert
    assertEquals("42", actualDefaultUserPredicate.getCreatingUserId());
    assertTrue(actualDefaultUserPredicate.getAuths().isEmpty());
  }

  /**
   * Method under test:
   * {@link DefaultUserPredicate#DefaultUserPredicate(String, List)}
   */
  @Test
  void testNewDefaultUserPredicate3() {
    // Arrange
    ArrayList<String> auths = new ArrayList<>();
    auths.add("foo");

    // Act
    DefaultUserPredicate actualDefaultUserPredicate = new DefaultUserPredicate("42", auths);

    // Assert
    assertEquals("42", actualDefaultUserPredicate.getCreatingUserId());
    List<String> auths2 = actualDefaultUserPredicate.getAuths();
    assertEquals(1, auths2.size());
    assertEquals("foo", auths2.get(0));
  }

  /**
   * Method under test:
   * {@link DefaultUserPredicate#DefaultUserPredicate(String, List)}
   */
  @Test
  void testNewDefaultUserPredicate4() {
    // Arrange
    ArrayList<String> auths = new ArrayList<>();
    auths.add("42");
    auths.add("foo");

    // Act
    DefaultUserPredicate actualDefaultUserPredicate = new DefaultUserPredicate("42", auths);

    // Assert
    assertEquals("42", actualDefaultUserPredicate.getCreatingUserId());
    assertEquals(auths, actualDefaultUserPredicate.getAuths());
  }
}
