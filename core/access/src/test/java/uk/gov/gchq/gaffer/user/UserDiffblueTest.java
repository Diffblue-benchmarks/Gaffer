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

package uk.gov.gchq.gaffer.user;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.Test;

class UserDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link User.Builder#build()}
   *   <li>default or parameterless constructor of {@link User.Builder}
   *   <li>{@link User.Builder#userId(String)}
   * </ul>
   */
  @Test
  void testBuilderBuild() {
    // Arrange and Act
    User actualBuildResult = (new User.Builder()).userId("42").build();

    // Assert
    assertEquals("42", actualBuildResult.getUserId());
    assertTrue(actualBuildResult.getDataAuths().isEmpty());
    assertTrue(actualBuildResult.getOpAuths().isEmpty());
  }

  /**
   * Method under test: {@link User.Builder#dataAuth(String)}
   */
  @Test
  void testBuilderDataAuth() {
    // Arrange
    User.Builder builder = new User.Builder();

    // Act
    User.Builder actualDataAuthResult = builder.dataAuth("Data Auth");

    // Assert
    Set<String> dataAuths = builder.build().getDataAuths();
    assertEquals(1, dataAuths.size());
    assertTrue(dataAuths.contains("Data Auth"));
    assertSame(builder, actualDataAuthResult);
  }

  /**
   * Method under test: {@link User.Builder#dataAuths(Collection)}
   */
  @Test
  void testBuilderDataAuths() {
    // Arrange
    User.Builder builder = new User.Builder();

    // Act
    User.Builder actualDataAuthsResult = builder.dataAuths(new ArrayList<>());

    // Assert
    assertTrue(builder.build().getDataAuths().isEmpty());
    assertSame(builder, actualDataAuthsResult);
  }

  /**
   * Method under test: {@link User.Builder#dataAuths(Collection)}
   */
  @Test
  void testBuilderDataAuths2() {
    // Arrange
    User.Builder builder = new User.Builder();

    ArrayList<String> dataAuths = new ArrayList<>();
    dataAuths.add("foo");

    // Act
    User.Builder actualDataAuthsResult = builder.dataAuths(dataAuths);

    // Assert
    Set<String> dataAuths2 = builder.build().getDataAuths();
    assertEquals(1, dataAuths2.size());
    assertTrue(dataAuths2.contains("foo"));
    assertSame(builder, actualDataAuthsResult);
  }

  /**
   * Method under test: {@link User.Builder#dataAuths(Collection)}
   */
  @Test
  void testBuilderDataAuths3() {
    // Arrange
    User.Builder builder = new User.Builder();

    ArrayList<String> dataAuths = new ArrayList<>();
    dataAuths.add("42");
    dataAuths.add("foo");

    // Act
    User.Builder actualDataAuthsResult = builder.dataAuths(dataAuths);

    // Assert
    Set<String> dataAuths2 = builder.build().getDataAuths();
    assertEquals(2, dataAuths2.size());
    assertTrue(dataAuths2.contains("42"));
    assertTrue(dataAuths2.contains("foo"));
    assertSame(builder, actualDataAuthsResult);
  }

  /**
   * Method under test: {@link User.Builder#dataAuths(String[])}
   */
  @Test
  void testBuilderDataAuths4() {
    // Arrange
    User.Builder builder = new User.Builder();

    // Act
    User.Builder actualDataAuthsResult = builder.dataAuths("Data Auths");

    // Assert
    Set<String> dataAuths = builder.build().getDataAuths();
    assertEquals(1, dataAuths.size());
    assertTrue(dataAuths.contains("Data Auths"));
    assertSame(builder, actualDataAuthsResult);
  }

  /**
   * Method under test: {@link User.Builder#opAuth(String)}
   */
  @Test
  void testBuilderOpAuth() {
    // Arrange
    User.Builder builder = new User.Builder();

    // Act
    User.Builder actualOpAuthResult = builder.opAuth("Op Auth");

    // Assert
    Set<String> opAuths = builder.build().getOpAuths();
    assertEquals(1, opAuths.size());
    assertTrue(opAuths.contains("Op Auth"));
    assertSame(builder, actualOpAuthResult);
  }

  /**
   * Method under test: {@link User.Builder#opAuths(Collection)}
   */
  @Test
  void testBuilderOpAuths() {
    // Arrange
    User.Builder builder = new User.Builder();

    // Act
    User.Builder actualOpAuthsResult = builder.opAuths(new ArrayList<>());

    // Assert
    assertTrue(builder.build().getOpAuths().isEmpty());
    assertSame(builder, actualOpAuthsResult);
  }

  /**
   * Method under test: {@link User.Builder#opAuths(Collection)}
   */
  @Test
  void testBuilderOpAuths2() {
    // Arrange
    User.Builder builder = new User.Builder();

    ArrayList<String> opAuths = new ArrayList<>();
    opAuths.add("foo");

    // Act
    User.Builder actualOpAuthsResult = builder.opAuths(opAuths);

    // Assert
    Set<String> opAuths2 = builder.build().getOpAuths();
    assertEquals(1, opAuths2.size());
    assertTrue(opAuths2.contains("foo"));
    assertSame(builder, actualOpAuthsResult);
  }

  /**
   * Method under test: {@link User.Builder#opAuths(Collection)}
   */
  @Test
  void testBuilderOpAuths3() {
    // Arrange
    User.Builder builder = new User.Builder();

    ArrayList<String> opAuths = new ArrayList<>();
    opAuths.add("42");
    opAuths.add("foo");

    // Act
    User.Builder actualOpAuthsResult = builder.opAuths(opAuths);

    // Assert
    Set<String> opAuths2 = builder.build().getOpAuths();
    assertEquals(2, opAuths2.size());
    assertTrue(opAuths2.contains("42"));
    assertTrue(opAuths2.contains("foo"));
    assertSame(builder, actualOpAuthsResult);
  }

  /**
   * Method under test: {@link User.Builder#opAuths(String[])}
   */
  @Test
  void testBuilderOpAuths4() {
    // Arrange
    User.Builder builder = new User.Builder();

    // Act
    User.Builder actualOpAuthsResult = builder.opAuths("Op Auths");

    // Assert
    Set<String> opAuths = builder.build().getOpAuths();
    assertEquals(1, opAuths.size());
    assertTrue(opAuths.contains("Op Auths"));
    assertSame(builder, actualOpAuthsResult);
  }

  /**
   * Method under test: {@link User#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    User user = new User("42");

    // Act and Assert
    assertNotEquals(user, new User());
  }

  /**
   * Method under test: {@link User#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new User(), null);
  }

  /**
   * Method under test: {@link User#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new User(), "Different type to User");
  }

  /**
   * Method under test: {@link User#getUserId()}
   */
  @Test
  void testGetUserId() {
    // Arrange, Act and Assert
    assertEquals(User.UNKNOWN_USER_ID, (new User()).getUserId());
  }

  /**
   * Method under test: {@link User#getDataAuths()}
   */
  @Test
  void testGetDataAuths() {
    // Arrange, Act and Assert
    assertTrue((new User()).getDataAuths().isEmpty());
  }

  /**
   * Method under test: {@link User#getOpAuths()}
   */
  @Test
  void testGetOpAuths() {
    // Arrange, Act and Assert
    assertTrue((new User()).getOpAuths().isEmpty());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link User#equals(Object)}
   *   <li>{@link User#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    User user = new User();
    User user2 = new User();

    // Act and Assert
    assertEquals(user, user2);
    int expectedHashCodeResult = user.hashCode();
    assertEquals(expectedHashCodeResult, user2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link User#equals(Object)}
   *   <li>{@link User#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    User user = new User();

    // Act and Assert
    assertEquals(user, user);
    int expectedHashCodeResult = user.hashCode();
    assertEquals(expectedHashCodeResult, user.hashCode());
  }

  /**
   * Method under test: {@link User#User()}
   */
  @Test
  void testNewUser() {
    // Arrange and Act
    User actualUser = new User();

    // Assert
    assertTrue(actualUser.getDataAuths().isEmpty());
    assertTrue(actualUser.getOpAuths().isEmpty());
    assertEquals(User.UNKNOWN_USER_ID, actualUser.getUserId());
  }

  /**
   * Method under test: {@link User#User(String)}
   */
  @Test
  void testNewUser2() {
    // Arrange and Act
    User actualUser = new User("42");

    // Assert
    assertEquals("42", actualUser.getUserId());
    assertTrue(actualUser.getDataAuths().isEmpty());
    assertTrue(actualUser.getOpAuths().isEmpty());
  }

  /**
   * Method under test: {@link User#User(String)}
   */
  @Test
  void testNewUser3() {
    // Arrange and Act
    User actualUser = new User(null);

    // Assert
    assertTrue(actualUser.getDataAuths().isEmpty());
    assertTrue(actualUser.getOpAuths().isEmpty());
    assertEquals(User.UNKNOWN_USER_ID, actualUser.getUserId());
  }

  /**
   * Method under test: {@link User#User(String)}
   */
  @Test
  void testNewUser4() {
    // Arrange and Act
    User actualUser = new User("");

    // Assert
    assertTrue(actualUser.getDataAuths().isEmpty());
    assertTrue(actualUser.getOpAuths().isEmpty());
    assertEquals(User.UNKNOWN_USER_ID, actualUser.getUserId());
  }

  /**
   * Method under test: {@link User#User(String, Set)}
   */
  @Test
  void testNewUser5() {
    // Arrange and Act
    User actualUser = new User("42", new HashSet<>());

    // Assert
    assertEquals("42", actualUser.getUserId());
    assertTrue(actualUser.getDataAuths().isEmpty());
    assertTrue(actualUser.getOpAuths().isEmpty());
  }

  /**
   * Method under test: {@link User#User(String, Set)}
   */
  @Test
  void testNewUser6() {
    // Arrange and Act
    User actualUser = new User(null, new HashSet<>());

    // Assert
    assertTrue(actualUser.getDataAuths().isEmpty());
    assertTrue(actualUser.getOpAuths().isEmpty());
    assertEquals(User.UNKNOWN_USER_ID, actualUser.getUserId());
  }

  /**
   * Method under test: {@link User#User(String, Set)}
   */
  @Test
  void testNewUser7() {
    // Arrange and Act
    User actualUser = new User("", new HashSet<>());

    // Assert
    assertTrue(actualUser.getDataAuths().isEmpty());
    assertTrue(actualUser.getOpAuths().isEmpty());
    assertEquals(User.UNKNOWN_USER_ID, actualUser.getUserId());
  }

  /**
   * Method under test: {@link User#User(String, Set)}
   */
  @Test
  void testNewUser8() {
    // Arrange
    HashSet<String> dataAuths = new HashSet<>();
    dataAuths.add("foo");

    // Act
    User actualUser = new User("42", dataAuths);

    // Assert
    assertEquals("42", actualUser.getUserId());
    Set<String> dataAuths2 = actualUser.getDataAuths();
    assertEquals(1, dataAuths2.size());
    assertTrue(dataAuths2.contains("foo"));
    assertTrue(actualUser.getOpAuths().isEmpty());
  }

  /**
   * Method under test: {@link User#User(String, Set)}
   */
  @Test
  void testNewUser9() {
    // Arrange
    HashSet<String> dataAuths = new HashSet<>();
    dataAuths.add("42");
    dataAuths.add("foo");

    // Act
    User actualUser = new User("42", dataAuths);

    // Assert
    assertEquals("42", actualUser.getUserId());
    assertTrue(actualUser.getOpAuths().isEmpty());
    assertEquals(dataAuths, actualUser.getDataAuths());
  }

  /**
   * Method under test: {@link User#User(String, Set, Set)}
   */
  @Test
  void testNewUser10() {
    // Arrange
    HashSet<String> dataAuths = new HashSet<>();

    // Act
    User actualUser = new User("42", dataAuths, new HashSet<>());

    // Assert
    assertEquals("42", actualUser.getUserId());
    assertTrue(actualUser.getDataAuths().isEmpty());
    assertTrue(actualUser.getOpAuths().isEmpty());
  }

  /**
   * Method under test: {@link User#User(String, Set, Set)}
   */
  @Test
  void testNewUser11() {
    // Arrange
    HashSet<String> dataAuths = new HashSet<>();

    // Act
    User actualUser = new User(null, dataAuths, new HashSet<>());

    // Assert
    assertTrue(actualUser.getDataAuths().isEmpty());
    assertTrue(actualUser.getOpAuths().isEmpty());
    assertEquals(User.UNKNOWN_USER_ID, actualUser.getUserId());
  }

  /**
   * Method under test: {@link User#User(String, Set, Set)}
   */
  @Test
  void testNewUser12() {
    // Arrange
    HashSet<String> dataAuths = new HashSet<>();

    // Act
    User actualUser = new User("", dataAuths, new HashSet<>());

    // Assert
    assertTrue(actualUser.getDataAuths().isEmpty());
    assertTrue(actualUser.getOpAuths().isEmpty());
    assertEquals(User.UNKNOWN_USER_ID, actualUser.getUserId());
  }

  /**
   * Method under test: {@link User#User(String, Set, Set)}
   */
  @Test
  void testNewUser13() {
    // Arrange
    HashSet<String> dataAuths = new HashSet<>();
    dataAuths.add("foo");

    // Act
    User actualUser = new User("42", dataAuths, new HashSet<>());

    // Assert
    assertEquals("42", actualUser.getUserId());
    Set<String> dataAuths2 = actualUser.getDataAuths();
    assertEquals(1, dataAuths2.size());
    assertTrue(dataAuths2.contains("foo"));
    assertTrue(actualUser.getOpAuths().isEmpty());
  }

  /**
   * Method under test: {@link User#User(String, Set, Set)}
   */
  @Test
  void testNewUser14() {
    // Arrange
    HashSet<String> dataAuths = new HashSet<>();
    dataAuths.add("42");
    dataAuths.add("foo");

    // Act
    User actualUser = new User("42", dataAuths, new HashSet<>());

    // Assert
    assertEquals("42", actualUser.getUserId());
    assertTrue(actualUser.getOpAuths().isEmpty());
    assertEquals(dataAuths, actualUser.getDataAuths());
  }

  /**
   * Method under test: {@link User#User(String, Set, Set)}
   */
  @Test
  void testNewUser15() {
    // Arrange
    HashSet<String> dataAuths = new HashSet<>();

    HashSet<String> opAuths = new HashSet<>();
    opAuths.add("foo");

    // Act
    User actualUser = new User("42", dataAuths, opAuths);

    // Assert
    assertEquals("42", actualUser.getUserId());
    Set<String> opAuths2 = actualUser.getOpAuths();
    assertEquals(1, opAuths2.size());
    assertTrue(opAuths2.contains("foo"));
    assertTrue(actualUser.getDataAuths().isEmpty());
  }

  /**
   * Method under test: {@link User#User(String, Set, Set)}
   */
  @Test
  void testNewUser16() {
    // Arrange
    HashSet<String> dataAuths = new HashSet<>();

    HashSet<String> opAuths = new HashSet<>();
    opAuths.add("42");
    opAuths.add("foo");

    // Act
    User actualUser = new User("42", dataAuths, opAuths);

    // Assert
    assertEquals("42", actualUser.getUserId());
    assertTrue(actualUser.getDataAuths().isEmpty());
    assertEquals(opAuths, actualUser.getOpAuths());
  }
}
