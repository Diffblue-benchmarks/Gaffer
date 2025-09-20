package uk.gov.gchq.gaffer.user;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.user.User.Builder;

class UserDiffblueTest {
  /**
   * Test Builder {@link Builder#build()}.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Builder#build()}
   *   <li>default or parameterless constructor of {@link Builder}
   *   <li>{@link Builder#userId(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("MaintainedByDiffblue")
  void testBuilderBuild() {
    // Arrange and Act
    User actualUser = new Builder().userId("42").build();

    // Assert
    assertEquals("42", actualUser.getUserId());
    assertTrue(actualUser.getDataAuths().isEmpty());
    assertTrue(actualUser.getOpAuths().isEmpty());
  }

  /**
   * Test Builder {@link Builder#dataAuth(String)}.
   *
   * <p>Method under test: {@link Builder#dataAuth(String)}
   */
  @Test
  @DisplayName("Test Builder dataAuth(String)")
  @Tag("MaintainedByDiffblue")
  void testBuilderDataAuth() {
    // Arrange
    Builder builder = new Builder();

    // Act
    Builder actualDataAuthResult = builder.dataAuth("Data Auth");

    // Assert
    Set<String> dataAuths = builder.build().getDataAuths();
    assertEquals(1, dataAuths.size());
    assertTrue(dataAuths.contains("Data Auth"));
    assertSame(builder, actualDataAuthResult);
  }

  /**
   * Test Builder {@link Builder#dataAuths(Collection)} with {@code Collection}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>Then {@link Builder} (default constructor) build DataAuths size is two.
   * </ul>
   *
   * <p>Method under test: {@link Builder#dataAuths(Collection)}
   */
  @Test
  @DisplayName(
      "Test Builder dataAuths(Collection) with 'Collection'; given '42'; then Builder (default constructor) build DataAuths size is two")
  @Tag("MaintainedByDiffblue")
  void testBuilderDataAuthsWithCollection_given42_thenBuilderBuildDataAuthsSizeIsTwo() {
    // Arrange
    Builder builder = new Builder();

    ArrayList<String> dataAuths = new ArrayList<>();
    dataAuths.add("42");
    dataAuths.add("foo");

    // Act
    Builder actualDataAuthsResult = builder.dataAuths(dataAuths);

    // Assert
    Set<String> dataAuths2 = builder.build().getDataAuths();
    assertEquals(2, dataAuths2.size());
    assertTrue(dataAuths2.contains("42"));
    assertTrue(dataAuths2.contains("foo"));
    assertSame(builder, actualDataAuthsResult);
  }

  /**
   * Test Builder {@link Builder#dataAuths(Collection)} with {@code Collection}.
   *
   * <ul>
   *   <li>Given {@code foo}.
   *   <li>Then {@link Builder} (default constructor) build DataAuths size is one.
   * </ul>
   *
   * <p>Method under test: {@link Builder#dataAuths(Collection)}
   */
  @Test
  @DisplayName(
      "Test Builder dataAuths(Collection) with 'Collection'; given 'foo'; then Builder (default constructor) build DataAuths size is one")
  @Tag("MaintainedByDiffblue")
  void testBuilderDataAuthsWithCollection_givenFoo_thenBuilderBuildDataAuthsSizeIsOne() {
    // Arrange
    Builder builder = new Builder();

    ArrayList<String> dataAuths = new ArrayList<>();
    dataAuths.add("foo");

    // Act
    Builder actualDataAuthsResult = builder.dataAuths(dataAuths);

    // Assert
    Set<String> dataAuths2 = builder.build().getDataAuths();
    assertEquals(1, dataAuths2.size());
    assertTrue(dataAuths2.contains("foo"));
    assertSame(builder, actualDataAuthsResult);
  }

  /**
   * Test Builder {@link Builder#dataAuths(Collection)} with {@code Collection}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then {@link Builder} (default constructor) build DataAuths Empty.
   * </ul>
   *
   * <p>Method under test: {@link Builder#dataAuths(Collection)}
   */
  @Test
  @DisplayName(
      "Test Builder dataAuths(Collection) with 'Collection'; when ArrayList(); then Builder (default constructor) build DataAuths Empty")
  @Tag("MaintainedByDiffblue")
  void testBuilderDataAuthsWithCollection_whenArrayList_thenBuilderBuildDataAuthsEmpty() {
    // Arrange
    Builder builder = new Builder();

    // Act
    Builder actualDataAuthsResult = builder.dataAuths(new ArrayList<>());

    // Assert
    assertTrue(builder.build().getDataAuths().isEmpty());
    User user = actualDataAuthsResult.build();
    assertTrue(user.getDataAuths().isEmpty());
    assertTrue(user.getOpAuths().isEmpty());
    assertEquals(User.UNKNOWN_USER_ID, user.getUserId());
  }

  /**
   * Test Builder {@link Builder#dataAuths(String[])} with {@code String[]}.
   *
   * <p>Method under test: {@link Builder#dataAuths(String[])}
   */
  @Test
  @DisplayName("Test Builder dataAuths(String[]) with 'String[]'")
  @Tag("MaintainedByDiffblue")
  void testBuilderDataAuthsWithString() {
    // Arrange
    Builder builder = new Builder();

    // Act
    Builder actualDataAuthsResult = builder.dataAuths("Data Auths");

    // Assert
    Set<String> dataAuths = builder.build().getDataAuths();
    assertEquals(1, dataAuths.size());
    assertTrue(dataAuths.contains("Data Auths"));
    assertSame(builder, actualDataAuthsResult);
  }

  /**
   * Test Builder {@link Builder#opAuth(String)}.
   *
   * <p>Method under test: {@link Builder#opAuth(String)}
   */
  @Test
  @DisplayName("Test Builder opAuth(String)")
  @Tag("MaintainedByDiffblue")
  void testBuilderOpAuth() {
    // Arrange
    Builder builder = new Builder();

    // Act
    Builder actualOpAuthResult = builder.opAuth("Op Auth");

    // Assert
    Set<String> opAuths = builder.build().getOpAuths();
    assertEquals(1, opAuths.size());
    assertTrue(opAuths.contains("Op Auth"));
    assertSame(builder, actualOpAuthResult);
  }

  /**
   * Test Builder {@link Builder#opAuths(Collection)} with {@code Collection}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>Then {@link Builder} (default constructor) build OpAuths size is two.
   * </ul>
   *
   * <p>Method under test: {@link Builder#opAuths(Collection)}
   */
  @Test
  @DisplayName(
      "Test Builder opAuths(Collection) with 'Collection'; given '42'; then Builder (default constructor) build OpAuths size is two")
  @Tag("MaintainedByDiffblue")
  void testBuilderOpAuthsWithCollection_given42_thenBuilderBuildOpAuthsSizeIsTwo() {
    // Arrange
    Builder builder = new Builder();

    ArrayList<String> opAuths = new ArrayList<>();
    opAuths.add("42");
    opAuths.add("foo");

    // Act
    Builder actualOpAuthsResult = builder.opAuths(opAuths);

    // Assert
    Set<String> opAuths2 = builder.build().getOpAuths();
    assertEquals(2, opAuths2.size());
    assertTrue(opAuths2.contains("42"));
    assertTrue(opAuths2.contains("foo"));
    assertSame(builder, actualOpAuthsResult);
  }

  /**
   * Test Builder {@link Builder#opAuths(Collection)} with {@code Collection}.
   *
   * <ul>
   *   <li>Given {@code foo}.
   *   <li>Then {@link Builder} (default constructor) build OpAuths size is one.
   * </ul>
   *
   * <p>Method under test: {@link Builder#opAuths(Collection)}
   */
  @Test
  @DisplayName(
      "Test Builder opAuths(Collection) with 'Collection'; given 'foo'; then Builder (default constructor) build OpAuths size is one")
  @Tag("MaintainedByDiffblue")
  void testBuilderOpAuthsWithCollection_givenFoo_thenBuilderBuildOpAuthsSizeIsOne() {
    // Arrange
    Builder builder = new Builder();

    ArrayList<String> opAuths = new ArrayList<>();
    opAuths.add("foo");

    // Act
    Builder actualOpAuthsResult = builder.opAuths(opAuths);

    // Assert
    Set<String> opAuths2 = builder.build().getOpAuths();
    assertEquals(1, opAuths2.size());
    assertTrue(opAuths2.contains("foo"));
    assertSame(builder, actualOpAuthsResult);
  }

  /**
   * Test Builder {@link Builder#opAuths(Collection)} with {@code Collection}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return build DataAuths Empty.
   * </ul>
   *
   * <p>Method under test: {@link Builder#opAuths(Collection)}
   */
  @Test
  @DisplayName(
      "Test Builder opAuths(Collection) with 'Collection'; when ArrayList(); then return build DataAuths Empty")
  @Tag("MaintainedByDiffblue")
  void testBuilderOpAuthsWithCollection_whenArrayList_thenReturnBuildDataAuthsEmpty() {
    // Arrange
    Builder builder = new Builder();

    // Act and Assert
    User user = builder.opAuths(new ArrayList<>()).build();
    assertTrue(user.getDataAuths().isEmpty());
    assertTrue(builder.build().getOpAuths().isEmpty());
    assertTrue(user.getOpAuths().isEmpty());
    assertEquals(User.UNKNOWN_USER_ID, user.getUserId());
  }

  /**
   * Test Builder {@link Builder#opAuths(String[])} with {@code String[]}.
   *
   * <p>Method under test: {@link Builder#opAuths(String[])}
   */
  @Test
  @DisplayName("Test Builder opAuths(String[]) with 'String[]'")
  @Tag("MaintainedByDiffblue")
  void testBuilderOpAuthsWithString() {
    // Arrange
    Builder builder = new Builder();

    // Act
    Builder actualOpAuthsResult = builder.opAuths("Op Auths");

    // Assert
    Set<String> opAuths = builder.build().getOpAuths();
    assertEquals(1, opAuths.size());
    assertTrue(opAuths.contains("Op Auths"));
    assertSame(builder, actualOpAuthsResult);
  }

  /**
   * Test {@link User#User()}.
   *
   * <p>Method under test: {@link User#User()}
   */
  @Test
  @DisplayName("Test new User()")
  @Tag("MaintainedByDiffblue")
  void testNewUser() {
    // Arrange and Act
    User actualUser = new User();

    // Assert
    assertTrue(actualUser.getDataAuths().isEmpty());
    assertTrue(actualUser.getOpAuths().isEmpty());
    assertEquals(User.UNKNOWN_USER_ID, actualUser.getUserId());
  }

  /**
   * Test {@link User#User(String, Set)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link HashSet#HashSet()} add {@code 42}.
   *   <li>Then return DataAuths is {@link HashSet#HashSet()}.
   * </ul>
   *
   * <p>Method under test: {@link User#User(String, Set)}
   */
  @Test
  @DisplayName(
      "Test new User(String, Set); given '42'; when HashSet() add '42'; then return DataAuths is HashSet()")
  @Tag("MaintainedByDiffblue")
  void testNewUser_given42_whenHashSetAdd42_thenReturnDataAuthsIsHashSet() {
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
   * Test {@link User#User(String, Set, Set)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link HashSet#HashSet()} add {@code 42}.
   *   <li>Then return DataAuths is {@link HashSet#HashSet()}.
   * </ul>
   *
   * <p>Method under test: {@link User#User(String, Set, Set)}
   */
  @Test
  @DisplayName(
      "Test new User(String, Set, Set); given '42'; when HashSet() add '42'; then return DataAuths is HashSet()")
  @Tag("MaintainedByDiffblue")
  void testNewUser_given42_whenHashSetAdd42_thenReturnDataAuthsIsHashSet2() {
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
   * Test {@link User#User(String, Set, Set)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link HashSet#HashSet()} add {@code 42}.
   *   <li>Then return OpAuths is {@link HashSet#HashSet()}.
   * </ul>
   *
   * <p>Method under test: {@link User#User(String, Set, Set)}
   */
  @Test
  @DisplayName(
      "Test new User(String, Set, Set); given '42'; when HashSet() add '42'; then return OpAuths is HashSet()")
  @Tag("MaintainedByDiffblue")
  void testNewUser_given42_whenHashSetAdd42_thenReturnOpAuthsIsHashSet() {
    // Arrange
    HashSet<String> dataAuths = new HashSet<>();

    HashSet<String> opAuths = new HashSet<>();
    opAuths.add("42");
    opAuths.add("foo");

    // Act
    User actualUser = new User("42", dataAuths, opAuths);

    // Assert
    assertEquals(opAuths, actualUser.getOpAuths());
  }

  /**
   * Test {@link User#User(String, Set)}.
   *
   * <ul>
   *   <li>Given {@code foo}.
   *   <li>When {@link HashSet#HashSet()} add {@code foo}.
   *   <li>Then return DataAuths is {@link HashSet#HashSet()}.
   * </ul>
   *
   * <p>Method under test: {@link User#User(String, Set)}
   */
  @Test
  @DisplayName(
      "Test new User(String, Set); given 'foo'; when HashSet() add 'foo'; then return DataAuths is HashSet()")
  @Tag("MaintainedByDiffblue")
  void testNewUser_givenFoo_whenHashSetAddFoo_thenReturnDataAuthsIsHashSet() {
    // Arrange
    HashSet<String> dataAuths = new HashSet<>();
    dataAuths.add("foo");

    // Act
    User actualUser = new User("42", dataAuths);

    // Assert
    assertEquals("42", actualUser.getUserId());
    assertTrue(actualUser.getOpAuths().isEmpty());
    assertEquals(dataAuths, actualUser.getDataAuths());
  }

  /**
   * Test {@link User#User(String, Set, Set)}.
   *
   * <ul>
   *   <li>Given {@code foo}.
   *   <li>When {@link HashSet#HashSet()} add {@code foo}.
   *   <li>Then return DataAuths is {@link HashSet#HashSet()}.
   * </ul>
   *
   * <p>Method under test: {@link User#User(String, Set, Set)}
   */
  @Test
  @DisplayName(
      "Test new User(String, Set, Set); given 'foo'; when HashSet() add 'foo'; then return DataAuths is HashSet()")
  @Tag("MaintainedByDiffblue")
  void testNewUser_givenFoo_whenHashSetAddFoo_thenReturnDataAuthsIsHashSet2() {
    // Arrange
    HashSet<String> dataAuths = new HashSet<>();
    dataAuths.add("foo");

    // Act
    User actualUser = new User("42", dataAuths, new HashSet<>());

    // Assert
    assertEquals("42", actualUser.getUserId());
    assertTrue(actualUser.getOpAuths().isEmpty());
    assertEquals(dataAuths, actualUser.getDataAuths());
  }

  /**
   * Test {@link User#User(String, Set, Set)}.
   *
   * <ul>
   *   <li>Given {@code foo}.
   *   <li>When {@link HashSet#HashSet()} add {@code foo}.
   *   <li>Then return OpAuths size is one.
   * </ul>
   *
   * <p>Method under test: {@link User#User(String, Set, Set)}
   */
  @Test
  @DisplayName(
      "Test new User(String, Set, Set); given 'foo'; when HashSet() add 'foo'; then return OpAuths size is one")
  @Tag("MaintainedByDiffblue")
  void testNewUser_givenFoo_whenHashSetAddFoo_thenReturnOpAuthsSizeIsOne() {
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
   * Test {@link User#User(String)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   *   <li>Then return UserId is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link User#User(String)}
   */
  @Test
  @DisplayName("Test new User(String); when '42'; then return UserId is '42'")
  @Tag("MaintainedByDiffblue")
  void testNewUser_when42_thenReturnUserIdIs42() {
    // Arrange and Act
    User actualUser = new User("42");

    // Assert
    assertEquals("42", actualUser.getUserId());
    assertTrue(actualUser.getDataAuths().isEmpty());
    assertTrue(actualUser.getOpAuths().isEmpty());
  }

  /**
   * Test {@link User#User(String, Set)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   *   <li>Then return UserId is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link User#User(String, Set)}
   */
  @Test
  @DisplayName("Test new User(String, Set); when '42'; then return UserId is '42'")
  @Tag("MaintainedByDiffblue")
  void testNewUser_when42_thenReturnUserIdIs422() {
    // Arrange and Act
    User actualUser = new User("42", new HashSet<>());

    // Assert
    assertEquals("42", actualUser.getUserId());
    assertTrue(actualUser.getDataAuths().isEmpty());
    assertTrue(actualUser.getOpAuths().isEmpty());
  }

  /**
   * Test {@link User#User(String, Set, Set)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   *   <li>Then return UserId is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link User#User(String, Set, Set)}
   */
  @Test
  @DisplayName("Test new User(String, Set, Set); when '42'; then return UserId is '42'")
  @Tag("MaintainedByDiffblue")
  void testNewUser_when42_thenReturnUserIdIs423() {
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
   * Test {@link User#User(String)}.
   *
   * <ul>
   *   <li>When empty string.
   *   <li>Then return UserId is {@link User#UNKNOWN_USER_ID}.
   * </ul>
   *
   * <p>Method under test: {@link User#User(String)}
   */
  @Test
  @DisplayName("Test new User(String); when empty string; then return UserId is UNKNOWN_USER_ID")
  @Tag("MaintainedByDiffblue")
  void testNewUser_whenEmptyString_thenReturnUserIdIsUnknown_user_id() {
    // Arrange and Act
    User actualUser = new User("");

    // Assert
    assertTrue(actualUser.getDataAuths().isEmpty());
    assertTrue(actualUser.getOpAuths().isEmpty());
    assertEquals(User.UNKNOWN_USER_ID, actualUser.getUserId());
  }

  /**
   * Test {@link User#User(String, Set)}.
   *
   * <ul>
   *   <li>When empty string.
   *   <li>Then return UserId is {@link User#UNKNOWN_USER_ID}.
   * </ul>
   *
   * <p>Method under test: {@link User#User(String, Set)}
   */
  @Test
  @DisplayName(
      "Test new User(String, Set); when empty string; then return UserId is UNKNOWN_USER_ID")
  @Tag("MaintainedByDiffblue")
  void testNewUser_whenEmptyString_thenReturnUserIdIsUnknown_user_id2() {
    // Arrange and Act
    User actualUser = new User("", new HashSet<>());

    // Assert
    assertTrue(actualUser.getDataAuths().isEmpty());
    assertTrue(actualUser.getOpAuths().isEmpty());
    assertEquals(User.UNKNOWN_USER_ID, actualUser.getUserId());
  }

  /**
   * Test {@link User#User(String, Set, Set)}.
   *
   * <ul>
   *   <li>When empty string.
   *   <li>Then return UserId is {@link User#UNKNOWN_USER_ID}.
   * </ul>
   *
   * <p>Method under test: {@link User#User(String, Set, Set)}
   */
  @Test
  @DisplayName(
      "Test new User(String, Set, Set); when empty string; then return UserId is UNKNOWN_USER_ID")
  @Tag("MaintainedByDiffblue")
  void testNewUser_whenEmptyString_thenReturnUserIdIsUnknown_user_id3() {
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
   * Test {@link User#User(String)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return UserId is {@link User#UNKNOWN_USER_ID}.
   * </ul>
   *
   * <p>Method under test: {@link User#User(String)}
   */
  @Test
  @DisplayName("Test new User(String); when 'null'; then return UserId is UNKNOWN_USER_ID")
  @Tag("MaintainedByDiffblue")
  void testNewUser_whenNull_thenReturnUserIdIsUnknown_user_id() {
    // Arrange and Act
    User actualUser = new User(null);

    // Assert
    assertTrue(actualUser.getDataAuths().isEmpty());
    assertTrue(actualUser.getOpAuths().isEmpty());
    assertEquals(User.UNKNOWN_USER_ID, actualUser.getUserId());
  }

  /**
   * Test {@link User#User(String, Set)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return UserId is {@link User#UNKNOWN_USER_ID}.
   * </ul>
   *
   * <p>Method under test: {@link User#User(String, Set)}
   */
  @Test
  @DisplayName("Test new User(String, Set); when 'null'; then return UserId is UNKNOWN_USER_ID")
  @Tag("MaintainedByDiffblue")
  void testNewUser_whenNull_thenReturnUserIdIsUnknown_user_id2() {
    // Arrange and Act
    User actualUser = new User(null, new HashSet<>());

    // Assert
    assertTrue(actualUser.getDataAuths().isEmpty());
    assertTrue(actualUser.getOpAuths().isEmpty());
    assertEquals(User.UNKNOWN_USER_ID, actualUser.getUserId());
  }

  /**
   * Test {@link User#User(String, Set, Set)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return UserId is {@link User#UNKNOWN_USER_ID}.
   * </ul>
   *
   * <p>Method under test: {@link User#User(String, Set, Set)}
   */
  @Test
  @DisplayName(
      "Test new User(String, Set, Set); when 'null'; then return UserId is UNKNOWN_USER_ID")
  @Tag("MaintainedByDiffblue")
  void testNewUser_whenNull_thenReturnUserIdIsUnknown_user_id3() {
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
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link User#toString()}
   *   <li>{@link User#getUserId()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  void testGettersAndSetters() {
    // Arrange
    User user = new Builder().userId("42").build();

    // Act
    String actualToStringResult = user.toString();

    // Assert
    assertEquals("42", user.getUserId());
    assertEquals("User[userId=42,dataAuths=[],opAuths=[]]", actualToStringResult);
  }

  /**
   * Test {@link User#getDataAuths()}.
   *
   * <p>Method under test: {@link User#getDataAuths()}
   */
  @Test
  @DisplayName("Test getDataAuths()")
  @Tag("MaintainedByDiffblue")
  void testGetDataAuths() {
    // Arrange, Act and Assert
    assertTrue(new User().getDataAuths().isEmpty());
  }

  /**
   * Test {@link User#getOpAuths()}.
   *
   * <p>Method under test: {@link User#getOpAuths()}
   */
  @Test
  @DisplayName("Test getOpAuths()")
  @Tag("MaintainedByDiffblue")
  void testGetOpAuths() {
    // Arrange, Act and Assert
    assertTrue(new User().getOpAuths().isEmpty());
  }

  /**
   * Test {@link User#equals(Object)}, and {@link User#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link User#equals(Object)}
   *   <li>{@link User#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    User user = new Builder().userId("42").build();
    User user2 = new Builder().userId("42").build();

    // Act and Assert
    assertEquals(user, user2);
    assertEquals(user.hashCode(), user2.hashCode());
  }

  /**
   * Test {@link User#equals(Object)}, and {@link User#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link User#equals(Object)}
   *   <li>{@link User#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    User user = new Builder().userId("42").build();

    // Act and Assert
    assertEquals(user, user);
    int expectedHashCodeResult = user.hashCode();
    assertEquals(expectedHashCodeResult, user.hashCode());
  }

  /**
   * Test {@link User#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link User#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    User user = new Builder().userId("User Id").build();

    // Act and Assert
    assertNotEquals(user, new Builder().userId("42").build());
  }

  /**
   * Test {@link User#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link User#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new Builder().userId("42").build(), null);
  }

  /**
   * Test {@link User#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link User#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new Builder().userId("42").build(), "Different type to User");
  }
}
