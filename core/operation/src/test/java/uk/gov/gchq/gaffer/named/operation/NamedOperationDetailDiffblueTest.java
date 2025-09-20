package uk.gov.gchq.gaffer.named.operation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.access.ResourceType;
import uk.gov.gchq.gaffer.access.predicate.AccessPredicate;
import uk.gov.gchq.gaffer.access.predicate.user.DefaultUserPredicate;
import uk.gov.gchq.gaffer.named.operation.NamedOperationDetail.Builder;
import uk.gov.gchq.gaffer.operation.OperationChain;
import uk.gov.gchq.gaffer.user.User;

class NamedOperationDetailDiffblueTest {
  /**
   * Test Builder {@link Builder#operationChain(OperationChain)} with {@code OperationChain}.
   *
   * <ul>
   *   <li>Given {@code filterFieldsByName}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#operationChain(OperationChain)}
   */
  @Test
  @DisplayName(
      "Test Builder operationChain(OperationChain) with 'OperationChain'; given 'filterFieldsByName'")
  @Tag("MaintainedByDiffblue")
  void testBuilderOperationChainWithOperationChain_givenFilterFieldsByName() {
    // Arrange
    Builder builder = new Builder();

    AddNamedOperation operation = new AddNamedOperation();
    operation.setOperationChain("filterFieldsByName");
    OperationChain<?> opChain = OperationChain.wrap(operation);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> builder.operationChain(opChain));
  }

  /**
   * Test Builder {@link Builder#operationChain(OperationChain)} with {@code OperationChain}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#operationChain(OperationChain)}
   */
  @Test
  @DisplayName(
      "Test Builder operationChain(OperationChain) with 'OperationChain'; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  void testBuilderOperationChainWithOperationChain_thenThrowIllegalArgumentException() {
    // Arrange
    Builder builder = new Builder();
    OperationChain<?> opChain = OperationChain.wrap(new AddNamedOperation());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> builder.operationChain(opChain));
  }

  /**
   * Test {@link NamedOperationDetail#NamedOperationDetail()}.
   *
   * <p>Method under test: {@link NamedOperationDetail#NamedOperationDetail()}
   */
  @Test
  @DisplayName("Test new NamedOperationDetail()")
  @Tag("MaintainedByDiffblue")
  void testNewNamedOperationDetail() {
    // Arrange and Act
    NamedOperationDetail actualNamedOperationDetail = new NamedOperationDetail();

    // Assert
    assertNull(actualNamedOperationDetail.getScore());
    assertNull(actualNamedOperationDetail.getCreatorId());
    assertNull(actualNamedOperationDetail.getDescription());
    assertNull(actualNamedOperationDetail.getInputType());
    assertNull(actualNamedOperationDetail.getOperationName());
    assertNull(actualNamedOperationDetail.getOperations());
    assertNull(actualNamedOperationDetail.getLabels());
    assertNull(actualNamedOperationDetail.getReadAccessRoles());
    assertNull(actualNamedOperationDetail.getWriteAccessRoles());
    assertNull(actualNamedOperationDetail.getReadAccessPredicate());
    assertNull(actualNamedOperationDetail.getWriteAccessPredicate());
    assertEquals(ResourceType.NamedOperation, actualNamedOperationDetail.getResourceType());
    assertTrue(actualNamedOperationDetail.getParameters().isEmpty());
  }

  /**
   * Test {@link NamedOperationDetail#NamedOperationDetail(String, String, String, String, String,
   * List, List, Map, Integer)}.
   *
   * <p>Method under test: {@link NamedOperationDetail#NamedOperationDetail(String, String, String,
   * String, String, List, List, Map, Integer)}
   */
  @Test
  @DisplayName(
      "Test new NamedOperationDetail(String, String, String, String, String, List, List, Map, Integer)")
  @Tag("MaintainedByDiffblue")
  void testNewNamedOperationDetail2() {
    // Arrange
    ArrayList<String> readers = new ArrayList<>();
    readers.add("foo");
    ArrayList<String> writers = new ArrayList<>();

    // Act
    NamedOperationDetail actualNamedOperationDetail =
        new NamedOperationDetail(
            "Operation Name",
            "Input Type",
            "The characteristics of someone or something",
            "42",
            "Operations",
            readers,
            writers,
            new HashMap<>(),
            3);

    // Assert
    assertTrue(
        actualNamedOperationDetail.getOrDefaultReadAccessPredicate().getUserPredicate()
            instanceof DefaultUserPredicate);
    Predicate<User> userPredicate =
        actualNamedOperationDetail.getOrDefaultWriteAccessPredicate().getUserPredicate();
    assertTrue(userPredicate instanceof DefaultUserPredicate);
    assertTrue(((DefaultUserPredicate) userPredicate).getAuths().isEmpty());
    assertSame(readers, actualNamedOperationDetail.getReadAccessRoles());
  }

  /**
   * Test {@link NamedOperationDetail#NamedOperationDetail(String, String, String, String, String,
   * List, List, Map, Integer)}.
   *
   * <p>Method under test: {@link NamedOperationDetail#NamedOperationDetail(String, String, String,
   * String, String, List, List, Map, Integer)}
   */
  @Test
  @DisplayName(
      "Test new NamedOperationDetail(String, String, String, String, String, List, List, Map, Integer)")
  @Tag("MaintainedByDiffblue")
  void testNewNamedOperationDetail3() {
    // Arrange
    ArrayList<String> readers = new ArrayList<>();
    readers.add("42");
    readers.add("foo");
    ArrayList<String> writers = new ArrayList<>();

    // Act
    NamedOperationDetail actualNamedOperationDetail =
        new NamedOperationDetail(
            "Operation Name",
            "Input Type",
            "The characteristics of someone or something",
            "42",
            "Operations",
            readers,
            writers,
            new HashMap<>(),
            3);

    // Assert
    assertTrue(
        actualNamedOperationDetail.getOrDefaultReadAccessPredicate().getUserPredicate()
            instanceof DefaultUserPredicate);
    Predicate<User> userPredicate =
        actualNamedOperationDetail.getOrDefaultWriteAccessPredicate().getUserPredicate();
    assertTrue(userPredicate instanceof DefaultUserPredicate);
    assertTrue(((DefaultUserPredicate) userPredicate).getAuths().isEmpty());
    assertSame(readers, actualNamedOperationDetail.getReadAccessRoles());
  }

  /**
   * Test {@link NamedOperationDetail#NamedOperationDetail(String, String, String, String, List,
   * List, Map, Integer)}.
   *
   * <p>Method under test: {@link NamedOperationDetail#NamedOperationDetail(String, String, String,
   * String, List, List, Map, Integer)}
   */
  @Test
  @DisplayName(
      "Test new NamedOperationDetail(String, String, String, String, List, List, Map, Integer)")
  @Tag("MaintainedByDiffblue")
  void testNewNamedOperationDetail4() {
    // Arrange
    ArrayList<String> readers = new ArrayList<>();
    readers.add("foo");
    ArrayList<String> writers = new ArrayList<>();

    // Act
    NamedOperationDetail actualNamedOperationDetail =
        new NamedOperationDetail(
            "Operation Name",
            "The characteristics of someone or something",
            "42",
            "Operations",
            readers,
            writers,
            new HashMap<>(),
            3);

    // Assert
    assertTrue(
        actualNamedOperationDetail.getOrDefaultReadAccessPredicate().getUserPredicate()
            instanceof DefaultUserPredicate);
    Predicate<User> userPredicate =
        actualNamedOperationDetail.getOrDefaultWriteAccessPredicate().getUserPredicate();
    assertTrue(userPredicate instanceof DefaultUserPredicate);
    assertTrue(((DefaultUserPredicate) userPredicate).getAuths().isEmpty());
    assertSame(readers, actualNamedOperationDetail.getReadAccessRoles());
  }

  /**
   * Test {@link NamedOperationDetail#NamedOperationDetail(String, String, String, String, List,
   * List, Map, Integer)}.
   *
   * <p>Method under test: {@link NamedOperationDetail#NamedOperationDetail(String, String, String,
   * String, List, List, Map, Integer)}
   */
  @Test
  @DisplayName(
      "Test new NamedOperationDetail(String, String, String, String, List, List, Map, Integer)")
  @Tag("MaintainedByDiffblue")
  void testNewNamedOperationDetail5() {
    // Arrange
    ArrayList<String> readers = new ArrayList<>();
    readers.add("42");
    readers.add("foo");
    ArrayList<String> writers = new ArrayList<>();

    // Act
    NamedOperationDetail actualNamedOperationDetail =
        new NamedOperationDetail(
            "Operation Name",
            "The characteristics of someone or something",
            "42",
            "Operations",
            readers,
            writers,
            new HashMap<>(),
            3);

    // Assert
    assertTrue(
        actualNamedOperationDetail.getOrDefaultReadAccessPredicate().getUserPredicate()
            instanceof DefaultUserPredicate);
    Predicate<User> userPredicate =
        actualNamedOperationDetail.getOrDefaultWriteAccessPredicate().getUserPredicate();
    assertTrue(userPredicate instanceof DefaultUserPredicate);
    assertTrue(((DefaultUserPredicate) userPredicate).getAuths().isEmpty());
    assertSame(readers, actualNamedOperationDetail.getReadAccessRoles());
  }

  /**
   * Test {@link NamedOperationDetail#NamedOperationDetail(String, List, String, String, String,
   * String, List, List, Map, Integer)}.
   *
   * <p>Method under test: {@link NamedOperationDetail#NamedOperationDetail(String, List, String,
   * String, String, String, List, List, Map, Integer)}
   */
  @Test
  @DisplayName(
      "Test new NamedOperationDetail(String, List, String, String, String, String, List, List, Map, Integer)")
  @Tag("MaintainedByDiffblue")
  void testNewNamedOperationDetail6() {
    // Arrange
    ArrayList<String> labels = new ArrayList<>();
    ArrayList<String> readers = new ArrayList<>();
    ArrayList<String> writers = new ArrayList<>();

    // Act
    NamedOperationDetail actualNamedOperationDetail =
        new NamedOperationDetail(
            "Operation Name",
            labels,
            "Input Type",
            "The characteristics of someone or something",
            "42",
            "Operations",
            readers,
            writers,
            new HashMap<>(),
            3);

    // Assert
    AccessPredicate orDefaultReadAccessPredicate =
        actualNamedOperationDetail.getOrDefaultReadAccessPredicate();
    Predicate<User> userPredicate = orDefaultReadAccessPredicate.getUserPredicate();
    assertTrue(userPredicate instanceof DefaultUserPredicate);
    assertTrue(((DefaultUserPredicate) userPredicate).getAuths().isEmpty());
    assertTrue(actualNamedOperationDetail.getLabels().isEmpty());
    assertTrue(actualNamedOperationDetail.getReadAccessRoles().isEmpty());
    assertTrue(actualNamedOperationDetail.getWriteAccessRoles().isEmpty());
    assertEquals(
        orDefaultReadAccessPredicate,
        actualNamedOperationDetail.getOrDefaultWriteAccessPredicate());
  }

  /**
   * Test {@link NamedOperationDetail#NamedOperationDetail(String, List, String, String, String,
   * String, List, List, Map, Integer)}.
   *
   * <p>Method under test: {@link NamedOperationDetail#NamedOperationDetail(String, List, String,
   * String, String, String, List, List, Map, Integer)}
   */
  @Test
  @DisplayName(
      "Test new NamedOperationDetail(String, List, String, String, String, String, List, List, Map, Integer)")
  @Tag("MaintainedByDiffblue")
  void testNewNamedOperationDetail7() {
    // Arrange
    ArrayList<String> labels = new ArrayList<>();

    // Act
    NamedOperationDetail actualNamedOperationDetail =
        new NamedOperationDetail(
            "Operation Name",
            labels,
            "Input Type",
            "The characteristics of someone or something",
            "42",
            "Operations",
            null,
            null,
            new HashMap<>(),
            3);

    // Assert
    Predicate<User> userPredicate =
        actualNamedOperationDetail.getOrDefaultWriteAccessPredicate().getUserPredicate();
    assertTrue(userPredicate instanceof DefaultUserPredicate);
    assertEquals("42", ((DefaultUserPredicate) userPredicate).getCreatingUserId());
    assertNull(actualNamedOperationDetail.getReadAccessRoles());
    assertNull(actualNamedOperationDetail.getWriteAccessRoles());
  }

  /**
   * Test {@link NamedOperationDetail#NamedOperationDetail(String, List, String, String, String,
   * String, List, List, Map, Integer)}.
   *
   * <p>Method under test: {@link NamedOperationDetail#NamedOperationDetail(String, List, String,
   * String, String, String, List, List, Map, Integer)}
   */
  @Test
  @DisplayName(
      "Test new NamedOperationDetail(String, List, String, String, String, String, List, List, Map, Integer)")
  @Tag("MaintainedByDiffblue")
  void testNewNamedOperationDetail8() {
    // Arrange
    ArrayList<String> labels = new ArrayList<>();

    ArrayList<String> readers = new ArrayList<>();
    readers.add("42");
    readers.add("foo");
    ArrayList<String> writers = new ArrayList<>();

    // Act
    NamedOperationDetail actualNamedOperationDetail =
        new NamedOperationDetail(
            "Operation Name",
            labels,
            "Input Type",
            "The characteristics of someone or something",
            "42",
            "Operations",
            readers,
            writers,
            new HashMap<>(),
            3);

    // Assert
    assertTrue(
        actualNamedOperationDetail.getOrDefaultReadAccessPredicate().getUserPredicate()
            instanceof DefaultUserPredicate);
    Predicate<User> userPredicate =
        actualNamedOperationDetail.getOrDefaultWriteAccessPredicate().getUserPredicate();
    assertTrue(userPredicate instanceof DefaultUserPredicate);
    assertTrue(((DefaultUserPredicate) userPredicate).getAuths().isEmpty());
    assertSame(readers, actualNamedOperationDetail.getReadAccessRoles());
  }

  /**
   * Test {@link NamedOperationDetail#NamedOperationDetail(String, List, String, String, String,
   * String, List, List, Map, Integer, AccessPredicate, AccessPredicate)}.
   *
   * <p>Method under test: {@link NamedOperationDetail#NamedOperationDetail(String, List, String,
   * String, String, String, List, List, Map, Integer, AccessPredicate, AccessPredicate)}
   */
  @Test
  @DisplayName(
      "Test new NamedOperationDetail(String, List, String, String, String, String, List, List, Map, Integer, AccessPredicate, AccessPredicate)")
  @Tag("MaintainedByDiffblue")
  void testNewNamedOperationDetail9() {
    // Arrange
    ArrayList<String> labels = new ArrayList<>();
    labels.add("Only one of readers or readAccessPredicate should be supplied.");
    ArrayList<String> readers = new ArrayList<>();
    ArrayList<String> writers = new ArrayList<>();
    HashMap<String, ParameterDetail> parameters = new HashMap<>();
    AccessPredicate readAccessPredicate = new AccessPredicate(mock(Predicate.class));
    AccessPredicate writeAccessPredicate = new AccessPredicate(mock(Predicate.class));

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            new NamedOperationDetail(
                "Operation Name",
                labels,
                "Input Type",
                "The characteristics of someone or something",
                "42",
                "Operations",
                readers,
                writers,
                parameters,
                3,
                readAccessPredicate,
                writeAccessPredicate));
  }

  /**
   * Test {@link NamedOperationDetail#NamedOperationDetail(String, List, String, String, String,
   * String, List, List, Map, Integer, AccessPredicate, AccessPredicate)}.
   *
   * <p>Method under test: {@link NamedOperationDetail#NamedOperationDetail(String, List, String,
   * String, String, String, List, List, Map, Integer, AccessPredicate, AccessPredicate)}
   */
  @Test
  @DisplayName(
      "Test new NamedOperationDetail(String, List, String, String, String, String, List, List, Map, Integer, AccessPredicate, AccessPredicate)")
  @Tag("MaintainedByDiffblue")
  void testNewNamedOperationDetail10() {
    // Arrange
    ArrayList<String> labels = new ArrayList<>();

    ArrayList<String> readers = new ArrayList<>();
    readers.add("Only one of readers or readAccessPredicate should be supplied.");
    ArrayList<String> writers = new ArrayList<>();
    HashMap<String, ParameterDetail> parameters = new HashMap<>();
    AccessPredicate readAccessPredicate = new AccessPredicate(mock(Predicate.class));
    AccessPredicate writeAccessPredicate = new AccessPredicate(mock(Predicate.class));

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            new NamedOperationDetail(
                "Operation Name",
                labels,
                "Input Type",
                "The characteristics of someone or something",
                "42",
                "Operations",
                readers,
                writers,
                parameters,
                3,
                readAccessPredicate,
                writeAccessPredicate));
  }

  /**
   * Test {@link NamedOperationDetail#NamedOperationDetail(String, List, String, String, String,
   * String, List, List, Map, Integer, AccessPredicate, AccessPredicate)}.
   *
   * <p>Method under test: {@link NamedOperationDetail#NamedOperationDetail(String, List, String,
   * String, String, String, List, List, Map, Integer, AccessPredicate, AccessPredicate)}
   */
  @Test
  @DisplayName(
      "Test new NamedOperationDetail(String, List, String, String, String, String, List, List, Map, Integer, AccessPredicate, AccessPredicate)")
  @Tag("MaintainedByDiffblue")
  void testNewNamedOperationDetail11() {
    // Arrange
    ArrayList<String> labels = new ArrayList<>();
    ArrayList<String> readers = new ArrayList<>();

    ArrayList<String> writers = new ArrayList<>();
    writers.add("Only one of readers or readAccessPredicate should be supplied.");
    HashMap<String, ParameterDetail> parameters = new HashMap<>();
    AccessPredicate readAccessPredicate = new AccessPredicate(mock(Predicate.class));
    AccessPredicate writeAccessPredicate = new AccessPredicate(mock(Predicate.class));

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            new NamedOperationDetail(
                "Operation Name",
                labels,
                "Input Type",
                "The characteristics of someone or something",
                "42",
                "Operations",
                readers,
                writers,
                parameters,
                3,
                readAccessPredicate,
                writeAccessPredicate));
  }

  /**
   * Test {@link NamedOperationDetail#NamedOperationDetail(String, List, String, String, String,
   * String, List, List, Map, Integer, AccessPredicate, AccessPredicate)}.
   *
   * <p>Method under test: {@link NamedOperationDetail#NamedOperationDetail(String, List, String,
   * String, String, String, List, List, Map, Integer, AccessPredicate, AccessPredicate)}
   */
  @Test
  @DisplayName(
      "Test new NamedOperationDetail(String, List, String, String, String, String, List, List, Map, Integer, AccessPredicate, AccessPredicate)")
  @Tag("MaintainedByDiffblue")
  void testNewNamedOperationDetail12() {
    // Arrange
    ArrayList<String> labels = new ArrayList<>();

    // Act
    NamedOperationDetail actualNamedOperationDetail =
        new NamedOperationDetail(
            "Operation Name must not be empty",
            labels,
            "Input Type",
            "The characteristics of someone or something",
            "42",
            "Operations",
            null,
            null,
            new HashMap<>(),
            3,
            null,
            null);

    // Assert
    assertTrue(
        actualNamedOperationDetail.getOrDefaultReadAccessPredicate().getUserPredicate()
            instanceof DefaultUserPredicate);
    Predicate<User> userPredicate =
        actualNamedOperationDetail.getOrDefaultWriteAccessPredicate().getUserPredicate();
    assertTrue(userPredicate instanceof DefaultUserPredicate);
    assertEquals("42", ((DefaultUserPredicate) userPredicate).getCreatingUserId());
    assertNull(actualNamedOperationDetail.getReadAccessPredicate());
  }

  /**
   * Test {@link NamedOperationDetail#NamedOperationDetail(String, List, String, String, String,
   * String, List, List, Map, Integer)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>Then return Labels is {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link NamedOperationDetail#NamedOperationDetail(String, List, String,
   * String, String, String, List, List, Map, Integer)}
   */
  @Test
  @DisplayName(
      "Test new NamedOperationDetail(String, List, String, String, String, String, List, List, Map, Integer); given '42'; then return Labels is ArrayList()")
  @Tag("MaintainedByDiffblue")
  void testNewNamedOperationDetail_given42_thenReturnLabelsIsArrayList() {
    // Arrange
    ArrayList<String> labels = new ArrayList<>();
    labels.add("42");
    labels.add("foo");
    ArrayList<String> readers = new ArrayList<>();
    ArrayList<String> writers = new ArrayList<>();

    // Act
    NamedOperationDetail actualNamedOperationDetail =
        new NamedOperationDetail(
            "Operation Name",
            labels,
            "Input Type",
            "The characteristics of someone or something",
            "42",
            "Operations",
            readers,
            writers,
            new HashMap<>(),
            3);

    // Assert
    assertTrue(actualNamedOperationDetail.getReadAccessRoles().isEmpty());
    assertTrue(actualNamedOperationDetail.getWriteAccessRoles().isEmpty());
    assertSame(labels, actualNamedOperationDetail.getLabels());
  }

  /**
   * Test {@link NamedOperationDetail#NamedOperationDetail(String, String, String, String, String,
   * List, List, Map, Integer)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>Then return WriteAccessRoles is {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link NamedOperationDetail#NamedOperationDetail(String, String, String,
   * String, String, List, List, Map, Integer)}
   */
  @Test
  @DisplayName(
      "Test new NamedOperationDetail(String, String, String, String, String, List, List, Map, Integer); given '42'; then return WriteAccessRoles is ArrayList()")
  @Tag("MaintainedByDiffblue")
  void testNewNamedOperationDetail_given42_thenReturnWriteAccessRolesIsArrayList() {
    // Arrange
    ArrayList<String> readers = new ArrayList<>();

    ArrayList<String> writers = new ArrayList<>();
    writers.add("42");
    writers.add("foo");

    // Act
    NamedOperationDetail actualNamedOperationDetail =
        new NamedOperationDetail(
            "Operation Name",
            "Input Type",
            "The characteristics of someone or something",
            "42",
            "Operations",
            readers,
            writers,
            new HashMap<>(),
            3);

    // Assert
    assertTrue(
        actualNamedOperationDetail.getOrDefaultWriteAccessPredicate().getUserPredicate()
            instanceof DefaultUserPredicate);
    assertSame(writers, actualNamedOperationDetail.getWriteAccessRoles());
  }

  /**
   * Test {@link NamedOperationDetail#NamedOperationDetail(String, String, String, String, List,
   * List, Map, Integer)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>Then return WriteAccessRoles is {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link NamedOperationDetail#NamedOperationDetail(String, String, String,
   * String, List, List, Map, Integer)}
   */
  @Test
  @DisplayName(
      "Test new NamedOperationDetail(String, String, String, String, List, List, Map, Integer); given '42'; then return WriteAccessRoles is ArrayList()")
  @Tag("MaintainedByDiffblue")
  void testNewNamedOperationDetail_given42_thenReturnWriteAccessRolesIsArrayList2() {
    // Arrange
    ArrayList<String> readers = new ArrayList<>();

    ArrayList<String> writers = new ArrayList<>();
    writers.add("42");
    writers.add("foo");

    // Act
    NamedOperationDetail actualNamedOperationDetail =
        new NamedOperationDetail(
            "Operation Name",
            "The characteristics of someone or something",
            "42",
            "Operations",
            readers,
            writers,
            new HashMap<>(),
            3);

    // Assert
    assertTrue(
        actualNamedOperationDetail.getOrDefaultWriteAccessPredicate().getUserPredicate()
            instanceof DefaultUserPredicate);
    assertSame(writers, actualNamedOperationDetail.getWriteAccessRoles());
  }

  /**
   * Test {@link NamedOperationDetail#NamedOperationDetail(String, List, String, String, String,
   * String, List, List, Map, Integer)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>Then return WriteAccessRoles is {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link NamedOperationDetail#NamedOperationDetail(String, List, String,
   * String, String, String, List, List, Map, Integer)}
   */
  @Test
  @DisplayName(
      "Test new NamedOperationDetail(String, List, String, String, String, String, List, List, Map, Integer); given '42'; then return WriteAccessRoles is ArrayList()")
  @Tag("MaintainedByDiffblue")
  void testNewNamedOperationDetail_given42_thenReturnWriteAccessRolesIsArrayList3() {
    // Arrange
    ArrayList<String> labels = new ArrayList<>();
    ArrayList<String> readers = new ArrayList<>();

    ArrayList<String> writers = new ArrayList<>();
    writers.add("42");
    writers.add("foo");

    // Act
    NamedOperationDetail actualNamedOperationDetail =
        new NamedOperationDetail(
            "Operation Name",
            labels,
            "Input Type",
            "The characteristics of someone or something",
            "42",
            "Operations",
            readers,
            writers,
            new HashMap<>(),
            3);

    // Assert
    assertTrue(
        actualNamedOperationDetail.getOrDefaultWriteAccessPredicate().getUserPredicate()
            instanceof DefaultUserPredicate);
    assertSame(writers, actualNamedOperationDetail.getWriteAccessRoles());
  }

  /**
   * Test {@link NamedOperationDetail#NamedOperationDetail(String, List, String, String, String,
   * String, List, List, Map, Integer)}.
   *
   * <ul>
   *   <li>Given {@code foo}.
   *   <li>Then return Labels is {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link NamedOperationDetail#NamedOperationDetail(String, List, String,
   * String, String, String, List, List, Map, Integer)}
   */
  @Test
  @DisplayName(
      "Test new NamedOperationDetail(String, List, String, String, String, String, List, List, Map, Integer); given 'foo'; then return Labels is ArrayList()")
  @Tag("MaintainedByDiffblue")
  void testNewNamedOperationDetail_givenFoo_thenReturnLabelsIsArrayList() {
    // Arrange
    ArrayList<String> labels = new ArrayList<>();
    labels.add("foo");
    ArrayList<String> readers = new ArrayList<>();
    ArrayList<String> writers = new ArrayList<>();

    // Act
    NamedOperationDetail actualNamedOperationDetail =
        new NamedOperationDetail(
            "Operation Name",
            labels,
            "Input Type",
            "The characteristics of someone or something",
            "42",
            "Operations",
            readers,
            writers,
            new HashMap<>(),
            3);

    // Assert
    assertTrue(actualNamedOperationDetail.getReadAccessRoles().isEmpty());
    assertTrue(actualNamedOperationDetail.getWriteAccessRoles().isEmpty());
    assertSame(labels, actualNamedOperationDetail.getLabels());
  }

  /**
   * Test {@link NamedOperationDetail#NamedOperationDetail(String, List, String, String, String,
   * String, List, List, Map, Integer)}.
   *
   * <ul>
   *   <li>Given {@code foo}.
   *   <li>Then return ReadAccessRoles size is one.
   * </ul>
   *
   * <p>Method under test: {@link NamedOperationDetail#NamedOperationDetail(String, List, String,
   * String, String, String, List, List, Map, Integer)}
   */
  @Test
  @DisplayName(
      "Test new NamedOperationDetail(String, List, String, String, String, String, List, List, Map, Integer); given 'foo'; then return ReadAccessRoles size is one")
  @Tag("MaintainedByDiffblue")
  void testNewNamedOperationDetail_givenFoo_thenReturnReadAccessRolesSizeIsOne() {
    // Arrange
    ArrayList<String> labels = new ArrayList<>();

    ArrayList<String> readers = new ArrayList<>();
    readers.add("foo");
    ArrayList<String> writers = new ArrayList<>();

    // Act
    NamedOperationDetail actualNamedOperationDetail =
        new NamedOperationDetail(
            "Operation Name",
            labels,
            "Input Type",
            "The characteristics of someone or something",
            "42",
            "Operations",
            readers,
            writers,
            new HashMap<>(),
            3);

    // Assert
    assertTrue(
        actualNamedOperationDetail.getOrDefaultReadAccessPredicate().getUserPredicate()
            instanceof DefaultUserPredicate);
    Predicate<User> userPredicate =
        actualNamedOperationDetail.getOrDefaultWriteAccessPredicate().getUserPredicate();
    assertTrue(userPredicate instanceof DefaultUserPredicate);
    List<String> readAccessRoles = actualNamedOperationDetail.getReadAccessRoles();
    assertEquals(1, readAccessRoles.size());
    assertEquals("foo", readAccessRoles.get(0));
    assertTrue(((DefaultUserPredicate) userPredicate).getAuths().isEmpty());
    assertSame(readers, readAccessRoles);
  }

  /**
   * Test {@link NamedOperationDetail#NamedOperationDetail(String, String, String, String, String,
   * List, List, Map, Integer)}.
   *
   * <ul>
   *   <li>Given {@code foo}.
   *   <li>Then return WriteAccessRoles size is one.
   * </ul>
   *
   * <p>Method under test: {@link NamedOperationDetail#NamedOperationDetail(String, String, String,
   * String, String, List, List, Map, Integer)}
   */
  @Test
  @DisplayName(
      "Test new NamedOperationDetail(String, String, String, String, String, List, List, Map, Integer); given 'foo'; then return WriteAccessRoles size is one")
  @Tag("MaintainedByDiffblue")
  void testNewNamedOperationDetail_givenFoo_thenReturnWriteAccessRolesSizeIsOne() {
    // Arrange
    ArrayList<String> readers = new ArrayList<>();

    ArrayList<String> writers = new ArrayList<>();
    writers.add("foo");

    // Act
    NamedOperationDetail actualNamedOperationDetail =
        new NamedOperationDetail(
            "Operation Name",
            "Input Type",
            "The characteristics of someone or something",
            "42",
            "Operations",
            readers,
            writers,
            new HashMap<>(),
            3);

    // Assert
    assertTrue(
        actualNamedOperationDetail.getOrDefaultWriteAccessPredicate().getUserPredicate()
            instanceof DefaultUserPredicate);
    List<String> writeAccessRoles = actualNamedOperationDetail.getWriteAccessRoles();
    assertEquals(1, writeAccessRoles.size());
    assertEquals("foo", writeAccessRoles.get(0));
    assertSame(writers, writeAccessRoles);
  }

  /**
   * Test {@link NamedOperationDetail#NamedOperationDetail(String, String, String, String, List,
   * List, Map, Integer)}.
   *
   * <ul>
   *   <li>Given {@code foo}.
   *   <li>Then return WriteAccessRoles size is one.
   * </ul>
   *
   * <p>Method under test: {@link NamedOperationDetail#NamedOperationDetail(String, String, String,
   * String, List, List, Map, Integer)}
   */
  @Test
  @DisplayName(
      "Test new NamedOperationDetail(String, String, String, String, List, List, Map, Integer); given 'foo'; then return WriteAccessRoles size is one")
  @Tag("MaintainedByDiffblue")
  void testNewNamedOperationDetail_givenFoo_thenReturnWriteAccessRolesSizeIsOne2() {
    // Arrange
    ArrayList<String> readers = new ArrayList<>();

    ArrayList<String> writers = new ArrayList<>();
    writers.add("foo");

    // Act
    NamedOperationDetail actualNamedOperationDetail =
        new NamedOperationDetail(
            "Operation Name",
            "The characteristics of someone or something",
            "42",
            "Operations",
            readers,
            writers,
            new HashMap<>(),
            3);

    // Assert
    assertTrue(
        actualNamedOperationDetail.getOrDefaultWriteAccessPredicate().getUserPredicate()
            instanceof DefaultUserPredicate);
    List<String> writeAccessRoles = actualNamedOperationDetail.getWriteAccessRoles();
    assertEquals(1, writeAccessRoles.size());
    assertEquals("foo", writeAccessRoles.get(0));
    assertSame(writers, writeAccessRoles);
  }

  /**
   * Test {@link NamedOperationDetail#NamedOperationDetail(String, List, String, String, String,
   * String, List, List, Map, Integer)}.
   *
   * <ul>
   *   <li>Given {@code foo}.
   *   <li>Then return WriteAccessRoles size is one.
   * </ul>
   *
   * <p>Method under test: {@link NamedOperationDetail#NamedOperationDetail(String, List, String,
   * String, String, String, List, List, Map, Integer)}
   */
  @Test
  @DisplayName(
      "Test new NamedOperationDetail(String, List, String, String, String, String, List, List, Map, Integer); given 'foo'; then return WriteAccessRoles size is one")
  @Tag("MaintainedByDiffblue")
  void testNewNamedOperationDetail_givenFoo_thenReturnWriteAccessRolesSizeIsOne3() {
    // Arrange
    ArrayList<String> labels = new ArrayList<>();
    ArrayList<String> readers = new ArrayList<>();

    ArrayList<String> writers = new ArrayList<>();
    writers.add("foo");

    // Act
    NamedOperationDetail actualNamedOperationDetail =
        new NamedOperationDetail(
            "Operation Name",
            labels,
            "Input Type",
            "The characteristics of someone or something",
            "42",
            "Operations",
            readers,
            writers,
            new HashMap<>(),
            3);

    // Assert
    assertTrue(
        actualNamedOperationDetail.getOrDefaultWriteAccessPredicate().getUserPredicate()
            instanceof DefaultUserPredicate);
    List<String> writeAccessRoles = actualNamedOperationDetail.getWriteAccessRoles();
    assertEquals(1, writeAccessRoles.size());
    assertEquals("foo", writeAccessRoles.get(0));
    assertSame(writers, writeAccessRoles);
  }

  /**
   * Test {@link NamedOperationDetail#NamedOperationDetail(String, List, String, String, String,
   * String, List, List, Map, Integer, AccessPredicate, AccessPredicate)}.
   *
   * <ul>
   *   <li>Given {@code foo}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code foo}.
   * </ul>
   *
   * <p>Method under test: {@link NamedOperationDetail#NamedOperationDetail(String, List, String,
   * String, String, String, List, List, Map, Integer, AccessPredicate, AccessPredicate)}
   */
  @Test
  @DisplayName(
      "Test new NamedOperationDetail(String, List, String, String, String, String, List, List, Map, Integer, AccessPredicate, AccessPredicate); given 'foo'; when ArrayList() add 'foo'")
  @Tag("MaintainedByDiffblue")
  void testNewNamedOperationDetail_givenFoo_whenArrayListAddFoo() {
    // Arrange
    ArrayList<String> labels = new ArrayList<>();
    labels.add("foo");
    labels.add("Only one of readers or readAccessPredicate should be supplied.");
    ArrayList<String> readers = new ArrayList<>();
    ArrayList<String> writers = new ArrayList<>();
    HashMap<String, ParameterDetail> parameters = new HashMap<>();
    AccessPredicate readAccessPredicate = new AccessPredicate(mock(Predicate.class));
    AccessPredicate writeAccessPredicate = new AccessPredicate(mock(Predicate.class));

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            new NamedOperationDetail(
                "Operation Name",
                labels,
                "Input Type",
                "The characteristics of someone or something",
                "42",
                "Operations",
                readers,
                writers,
                parameters,
                3,
                readAccessPredicate,
                writeAccessPredicate));
  }

  /**
   * Test {@link NamedOperationDetail#NamedOperationDetail(String, List, String, String, String,
   * String, List, List, Map, Integer, AccessPredicate, AccessPredicate)}.
   *
   * <ul>
   *   <li>Given {@code foo}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code foo}.
   * </ul>
   *
   * <p>Method under test: {@link NamedOperationDetail#NamedOperationDetail(String, List, String,
   * String, String, String, List, List, Map, Integer, AccessPredicate, AccessPredicate)}
   */
  @Test
  @DisplayName(
      "Test new NamedOperationDetail(String, List, String, String, String, String, List, List, Map, Integer, AccessPredicate, AccessPredicate); given 'foo'; when ArrayList() add 'foo'")
  @Tag("MaintainedByDiffblue")
  void testNewNamedOperationDetail_givenFoo_whenArrayListAddFoo2() {
    // Arrange
    ArrayList<String> labels = new ArrayList<>();

    ArrayList<String> readers = new ArrayList<>();
    readers.add("foo");
    readers.add("Only one of readers or readAccessPredicate should be supplied.");
    ArrayList<String> writers = new ArrayList<>();
    HashMap<String, ParameterDetail> parameters = new HashMap<>();
    AccessPredicate readAccessPredicate = new AccessPredicate(mock(Predicate.class));
    AccessPredicate writeAccessPredicate = new AccessPredicate(mock(Predicate.class));

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            new NamedOperationDetail(
                "Operation Name",
                labels,
                "Input Type",
                "The characteristics of someone or something",
                "42",
                "Operations",
                readers,
                writers,
                parameters,
                3,
                readAccessPredicate,
                writeAccessPredicate));
  }

  /**
   * Test {@link NamedOperationDetail#NamedOperationDetail(String, List, String, String, String,
   * String, List, List, Map, Integer, AccessPredicate, AccessPredicate)}.
   *
   * <ul>
   *   <li>Given {@code foo}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code foo}.
   * </ul>
   *
   * <p>Method under test: {@link NamedOperationDetail#NamedOperationDetail(String, List, String,
   * String, String, String, List, List, Map, Integer, AccessPredicate, AccessPredicate)}
   */
  @Test
  @DisplayName(
      "Test new NamedOperationDetail(String, List, String, String, String, String, List, List, Map, Integer, AccessPredicate, AccessPredicate); given 'foo'; when ArrayList() add 'foo'")
  @Tag("MaintainedByDiffblue")
  void testNewNamedOperationDetail_givenFoo_whenArrayListAddFoo3() {
    // Arrange
    ArrayList<String> labels = new ArrayList<>();
    ArrayList<String> readers = new ArrayList<>();

    ArrayList<String> writers = new ArrayList<>();
    writers.add("foo");
    writers.add("Only one of readers or readAccessPredicate should be supplied.");
    HashMap<String, ParameterDetail> parameters = new HashMap<>();
    AccessPredicate readAccessPredicate = new AccessPredicate(mock(Predicate.class));
    AccessPredicate writeAccessPredicate = new AccessPredicate(mock(Predicate.class));

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            new NamedOperationDetail(
                "Operation Name",
                labels,
                "Input Type",
                "The characteristics of someone or something",
                "42",
                "Operations",
                readers,
                writers,
                parameters,
                3,
                readAccessPredicate,
                writeAccessPredicate));
  }

  /**
   * Test {@link NamedOperationDetail#NamedOperationDetail(String, List, String, String, String,
   * String, List, List, Map, Integer, AccessPredicate, AccessPredicate)}.
   *
   * <ul>
   *   <li>Then return WriteAccessRoles Empty.
   * </ul>
   *
   * <p>Method under test: {@link NamedOperationDetail#NamedOperationDetail(String, List, String,
   * String, String, String, List, List, Map, Integer, AccessPredicate, AccessPredicate)}
   */
  @Test
  @DisplayName(
      "Test new NamedOperationDetail(String, List, String, String, String, String, List, List, Map, Integer, AccessPredicate, AccessPredicate); then return WriteAccessRoles Empty")
  @Tag("MaintainedByDiffblue")
  void testNewNamedOperationDetail_thenReturnWriteAccessRolesEmpty() {
    // Arrange
    ArrayList<String> labels = new ArrayList<>();
    ArrayList<String> writers = new ArrayList<>();

    // Act
    NamedOperationDetail actualNamedOperationDetail =
        new NamedOperationDetail(
            "Operation Name must not be empty",
            labels,
            "Input Type",
            "The characteristics of someone or something",
            "42",
            "Operations",
            null,
            writers,
            new HashMap<>(),
            3,
            null,
            null);

    // Assert
    AccessPredicate orDefaultReadAccessPredicate =
        actualNamedOperationDetail.getOrDefaultReadAccessPredicate();
    assertTrue(orDefaultReadAccessPredicate.getUserPredicate() instanceof DefaultUserPredicate);
    assertNull(actualNamedOperationDetail.getReadAccessPredicate());
    assertTrue(actualNamedOperationDetail.getWriteAccessRoles().isEmpty());
    assertEquals(
        orDefaultReadAccessPredicate,
        actualNamedOperationDetail.getOrDefaultWriteAccessPredicate());
  }

  /**
   * Test {@link NamedOperationDetail#NamedOperationDetail(String, String, String, String, String,
   * List, List, Map, Integer)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return ReadAccessRoles Empty.
   * </ul>
   *
   * <p>Method under test: {@link NamedOperationDetail#NamedOperationDetail(String, String, String,
   * String, String, List, List, Map, Integer)}
   */
  @Test
  @DisplayName(
      "Test new NamedOperationDetail(String, String, String, String, String, List, List, Map, Integer); when ArrayList(); then return ReadAccessRoles Empty")
  @Tag("MaintainedByDiffblue")
  void testNewNamedOperationDetail_whenArrayList_thenReturnReadAccessRolesEmpty() {
    // Arrange
    ArrayList<String> readers = new ArrayList<>();
    ArrayList<String> writers = new ArrayList<>();

    // Act
    NamedOperationDetail actualNamedOperationDetail =
        new NamedOperationDetail(
            "Operation Name",
            "Input Type",
            "The characteristics of someone or something",
            "42",
            "Operations",
            readers,
            writers,
            new HashMap<>(),
            3);

    // Assert
    AccessPredicate orDefaultReadAccessPredicate =
        actualNamedOperationDetail.getOrDefaultReadAccessPredicate();
    Predicate<User> userPredicate = orDefaultReadAccessPredicate.getUserPredicate();
    assertTrue(userPredicate instanceof DefaultUserPredicate);
    assertTrue(((DefaultUserPredicate) userPredicate).getAuths().isEmpty());
    assertTrue(actualNamedOperationDetail.getReadAccessRoles().isEmpty());
    assertTrue(actualNamedOperationDetail.getWriteAccessRoles().isEmpty());
    assertEquals(
        orDefaultReadAccessPredicate,
        actualNamedOperationDetail.getOrDefaultWriteAccessPredicate());
  }

  /**
   * Test {@link NamedOperationDetail#NamedOperationDetail(String, String, String, String, List,
   * List, Map, Integer)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return ReadAccessRoles Empty.
   * </ul>
   *
   * <p>Method under test: {@link NamedOperationDetail#NamedOperationDetail(String, String, String,
   * String, List, List, Map, Integer)}
   */
  @Test
  @DisplayName(
      "Test new NamedOperationDetail(String, String, String, String, List, List, Map, Integer); when ArrayList(); then return ReadAccessRoles Empty")
  @Tag("MaintainedByDiffblue")
  void testNewNamedOperationDetail_whenArrayList_thenReturnReadAccessRolesEmpty2() {
    // Arrange
    ArrayList<String> readers = new ArrayList<>();
    ArrayList<String> writers = new ArrayList<>();

    // Act
    NamedOperationDetail actualNamedOperationDetail =
        new NamedOperationDetail(
            "Operation Name",
            "The characteristics of someone or something",
            "42",
            "Operations",
            readers,
            writers,
            new HashMap<>(),
            3);

    // Assert
    AccessPredicate orDefaultReadAccessPredicate =
        actualNamedOperationDetail.getOrDefaultReadAccessPredicate();
    Predicate<User> userPredicate = orDefaultReadAccessPredicate.getUserPredicate();
    assertTrue(userPredicate instanceof DefaultUserPredicate);
    assertTrue(((DefaultUserPredicate) userPredicate).getAuths().isEmpty());
    assertTrue(actualNamedOperationDetail.getReadAccessRoles().isEmpty());
    assertTrue(actualNamedOperationDetail.getWriteAccessRoles().isEmpty());
    assertEquals(
        orDefaultReadAccessPredicate,
        actualNamedOperationDetail.getOrDefaultWriteAccessPredicate());
  }

  /**
   * Test {@link NamedOperationDetail#NamedOperationDetail(String, String, String, String, String,
   * List, List, Map, Integer)}.
   *
   * <ul>
   *   <li>When empty string.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link NamedOperationDetail#NamedOperationDetail(String, String, String,
   * String, String, List, List, Map, Integer)}
   */
  @Test
  @DisplayName(
      "Test new NamedOperationDetail(String, String, String, String, String, List, List, Map, Integer); when empty string; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  void testNewNamedOperationDetail_whenEmptyString_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            new NamedOperationDetail(
                "",
                "Input Type",
                "The characteristics of someone or something",
                "42",
                "Operations",
                null,
                null,
                new HashMap<>(),
                3));
  }

  /**
   * Test {@link NamedOperationDetail#NamedOperationDetail(String, String, String, String, List,
   * List, Map, Integer)}.
   *
   * <ul>
   *   <li>When empty string.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link NamedOperationDetail#NamedOperationDetail(String, String, String,
   * String, List, List, Map, Integer)}
   */
  @Test
  @DisplayName(
      "Test new NamedOperationDetail(String, String, String, String, List, List, Map, Integer); when empty string; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  void testNewNamedOperationDetail_whenEmptyString_thenThrowIllegalArgumentException2() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            new NamedOperationDetail(
                "",
                "The characteristics of someone or something",
                "42",
                "Operations",
                null,
                null,
                new HashMap<>(),
                3));
  }

  /**
   * Test {@link NamedOperationDetail#NamedOperationDetail(String, List, String, String, String,
   * String, List, List, Map, Integer)}.
   *
   * <ul>
   *   <li>When empty string.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link NamedOperationDetail#NamedOperationDetail(String, List, String,
   * String, String, String, List, List, Map, Integer)}
   */
  @Test
  @DisplayName(
      "Test new NamedOperationDetail(String, List, String, String, String, String, List, List, Map, Integer); when empty string; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  void testNewNamedOperationDetail_whenEmptyString_thenThrowIllegalArgumentException3() {
    // Arrange
    ArrayList<String> labels = new ArrayList<>();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            new NamedOperationDetail(
                "",
                labels,
                "Input Type",
                "The characteristics of someone or something",
                "42",
                "Operations",
                null,
                null,
                new HashMap<>(),
                3));
  }

  /**
   * Test {@link NamedOperationDetail#NamedOperationDetail(String, List, String, String, String,
   * String, List, List, Map, Integer, AccessPredicate, AccessPredicate)}.
   *
   * <ul>
   *   <li>When empty string.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link NamedOperationDetail#NamedOperationDetail(String, List, String,
   * String, String, String, List, List, Map, Integer, AccessPredicate, AccessPredicate)}
   */
  @Test
  @DisplayName(
      "Test new NamedOperationDetail(String, List, String, String, String, String, List, List, Map, Integer, AccessPredicate, AccessPredicate); when empty string; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  void testNewNamedOperationDetail_whenEmptyString_thenThrowIllegalArgumentException4() {
    // Arrange
    ArrayList<String> labels = new ArrayList<>();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            new NamedOperationDetail(
                "",
                labels,
                "Input Type",
                "The characteristics of someone or something",
                "42",
                "Operations",
                null,
                null,
                new HashMap<>(),
                3,
                null,
                null));
  }

  /**
   * Test {@link NamedOperationDetail#NamedOperationDetail(String, String, String, String, String,
   * List, List, Map, Integer)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return ReadAccessRoles is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link NamedOperationDetail#NamedOperationDetail(String, String, String,
   * String, String, List, List, Map, Integer)}
   */
  @Test
  @DisplayName(
      "Test new NamedOperationDetail(String, String, String, String, String, List, List, Map, Integer); when 'null'; then return ReadAccessRoles is 'null'")
  @Tag("MaintainedByDiffblue")
  void testNewNamedOperationDetail_whenNull_thenReturnReadAccessRolesIsNull() {
    // Arrange and Act
    NamedOperationDetail actualNamedOperationDetail =
        new NamedOperationDetail(
            "Operation Name",
            "Input Type",
            "The characteristics of someone or something",
            "42",
            "Operations",
            null,
            null,
            new HashMap<>(),
            3);

    // Assert
    AccessPredicate orDefaultReadAccessPredicate =
        actualNamedOperationDetail.getOrDefaultReadAccessPredicate();
    Predicate<User> userPredicate = orDefaultReadAccessPredicate.getUserPredicate();
    assertTrue(userPredicate instanceof DefaultUserPredicate);
    assertNull(actualNamedOperationDetail.getReadAccessRoles());
    assertNull(actualNamedOperationDetail.getWriteAccessRoles());
    assertTrue(((DefaultUserPredicate) userPredicate).getAuths().isEmpty());
    assertEquals(
        orDefaultReadAccessPredicate,
        actualNamedOperationDetail.getOrDefaultWriteAccessPredicate());
  }

  /**
   * Test {@link NamedOperationDetail#NamedOperationDetail(String, String, String, String, List,
   * List, Map, Integer)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return ReadAccessRoles is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link NamedOperationDetail#NamedOperationDetail(String, String, String,
   * String, List, List, Map, Integer)}
   */
  @Test
  @DisplayName(
      "Test new NamedOperationDetail(String, String, String, String, List, List, Map, Integer); when 'null'; then return ReadAccessRoles is 'null'")
  @Tag("MaintainedByDiffblue")
  void testNewNamedOperationDetail_whenNull_thenReturnReadAccessRolesIsNull2() {
    // Arrange and Act
    NamedOperationDetail actualNamedOperationDetail =
        new NamedOperationDetail(
            "Operation Name",
            "The characteristics of someone or something",
            "42",
            "Operations",
            null,
            null,
            new HashMap<>(),
            3);

    // Assert
    AccessPredicate orDefaultReadAccessPredicate =
        actualNamedOperationDetail.getOrDefaultReadAccessPredicate();
    Predicate<User> userPredicate = orDefaultReadAccessPredicate.getUserPredicate();
    assertTrue(userPredicate instanceof DefaultUserPredicate);
    assertNull(actualNamedOperationDetail.getReadAccessRoles());
    assertNull(actualNamedOperationDetail.getWriteAccessRoles());
    assertTrue(((DefaultUserPredicate) userPredicate).getAuths().isEmpty());
    assertEquals(
        orDefaultReadAccessPredicate,
        actualNamedOperationDetail.getOrDefaultWriteAccessPredicate());
  }

  /**
   * Test {@link NamedOperationDetail#NamedOperationDetail(String, String, String, String, String,
   * List, List, Map, Integer)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link NamedOperationDetail#NamedOperationDetail(String, String, String,
   * String, String, List, List, Map, Integer)}
   */
  @Test
  @DisplayName(
      "Test new NamedOperationDetail(String, String, String, String, String, List, List, Map, Integer); when 'null'; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  void testNewNamedOperationDetail_whenNull_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            new NamedOperationDetail(
                null,
                "Input Type",
                "The characteristics of someone or something",
                "42",
                null,
                null,
                null,
                new HashMap<>(),
                3));
  }

  /**
   * Test {@link NamedOperationDetail#NamedOperationDetail(String, String, String, String, String,
   * List, List, Map, Integer)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link NamedOperationDetail#NamedOperationDetail(String, String, String,
   * String, String, List, List, Map, Integer)}
   */
  @Test
  @DisplayName(
      "Test new NamedOperationDetail(String, String, String, String, String, List, List, Map, Integer); when 'null'; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  void testNewNamedOperationDetail_whenNull_thenThrowIllegalArgumentException2() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            new NamedOperationDetail(
                null,
                "Input Type",
                "The characteristics of someone or something",
                "42",
                "Operations",
                null,
                null,
                new HashMap<>(),
                3));
  }

  /**
   * Test {@link NamedOperationDetail#NamedOperationDetail(String, String, String, String, List,
   * List, Map, Integer)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link NamedOperationDetail#NamedOperationDetail(String, String, String,
   * String, List, List, Map, Integer)}
   */
  @Test
  @DisplayName(
      "Test new NamedOperationDetail(String, String, String, String, List, List, Map, Integer); when 'null'; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  void testNewNamedOperationDetail_whenNull_thenThrowIllegalArgumentException3() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            new NamedOperationDetail(
                null,
                "The characteristics of someone or something",
                "42",
                null,
                null,
                null,
                new HashMap<>(),
                3));
  }

  /**
   * Test {@link NamedOperationDetail#NamedOperationDetail(String, String, String, String, List,
   * List, Map, Integer)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link NamedOperationDetail#NamedOperationDetail(String, String, String,
   * String, List, List, Map, Integer)}
   */
  @Test
  @DisplayName(
      "Test new NamedOperationDetail(String, String, String, String, List, List, Map, Integer); when 'null'; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  void testNewNamedOperationDetail_whenNull_thenThrowIllegalArgumentException4() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            new NamedOperationDetail(
                null,
                "The characteristics of someone or something",
                "42",
                "Operations",
                null,
                null,
                new HashMap<>(),
                3));
  }

  /**
   * Test {@link NamedOperationDetail#NamedOperationDetail(String, List, String, String, String,
   * String, List, List, Map, Integer)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link NamedOperationDetail#NamedOperationDetail(String, List, String,
   * String, String, String, List, List, Map, Integer)}
   */
  @Test
  @DisplayName(
      "Test new NamedOperationDetail(String, List, String, String, String, String, List, List, Map, Integer); when 'null'; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  void testNewNamedOperationDetail_whenNull_thenThrowIllegalArgumentException5() {
    // Arrange
    ArrayList<String> labels = new ArrayList<>();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            new NamedOperationDetail(
                null,
                labels,
                "Input Type",
                "The characteristics of someone or something",
                "42",
                null,
                null,
                null,
                new HashMap<>(),
                3));
  }

  /**
   * Test {@link NamedOperationDetail#NamedOperationDetail(String, List, String, String, String,
   * String, List, List, Map, Integer)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link NamedOperationDetail#NamedOperationDetail(String, List, String,
   * String, String, String, List, List, Map, Integer)}
   */
  @Test
  @DisplayName(
      "Test new NamedOperationDetail(String, List, String, String, String, String, List, List, Map, Integer); when 'null'; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  void testNewNamedOperationDetail_whenNull_thenThrowIllegalArgumentException6() {
    // Arrange
    ArrayList<String> labels = new ArrayList<>();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            new NamedOperationDetail(
                null,
                labels,
                "Input Type",
                "The characteristics of someone or something",
                "42",
                "Operations",
                null,
                null,
                new HashMap<>(),
                3));
  }

  /**
   * Test {@link NamedOperationDetail#NamedOperationDetail(String, List, String, String, String,
   * String, List, List, Map, Integer, AccessPredicate, AccessPredicate)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link NamedOperationDetail#NamedOperationDetail(String, List, String,
   * String, String, String, List, List, Map, Integer, AccessPredicate, AccessPredicate)}
   */
  @Test
  @DisplayName(
      "Test new NamedOperationDetail(String, List, String, String, String, String, List, List, Map, Integer, AccessPredicate, AccessPredicate); when 'null'; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  void testNewNamedOperationDetail_whenNull_thenThrowIllegalArgumentException7() {
    // Arrange
    ArrayList<String> labels = new ArrayList<>();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            new NamedOperationDetail(
                null,
                labels,
                "Input Type",
                "The characteristics of someone or something",
                "42",
                null,
                null,
                null,
                new HashMap<>(),
                3,
                null,
                null));
  }

  /**
   * Test {@link NamedOperationDetail#NamedOperationDetail(String, List, String, String, String,
   * String, List, List, Map, Integer, AccessPredicate, AccessPredicate)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link NamedOperationDetail#NamedOperationDetail(String, List, String,
   * String, String, String, List, List, Map, Integer, AccessPredicate, AccessPredicate)}
   */
  @Test
  @DisplayName(
      "Test new NamedOperationDetail(String, List, String, String, String, String, List, List, Map, Integer, AccessPredicate, AccessPredicate); when 'null'; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  void testNewNamedOperationDetail_whenNull_thenThrowIllegalArgumentException8() {
    // Arrange
    ArrayList<String> labels = new ArrayList<>();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            new NamedOperationDetail(
                null,
                labels,
                "Input Type",
                "The characteristics of someone or something",
                "42",
                "Operations",
                null,
                null,
                new HashMap<>(),
                3,
                null,
                null));
  }

  /**
   * Test {@link NamedOperationDetail#NamedOperationDetail(String, List, String, String, String,
   * String, List, List, Map, Integer, AccessPredicate, AccessPredicate)}.
   *
   * <ul>
   *   <li>When {@code Operation Name}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link NamedOperationDetail#NamedOperationDetail(String, List, String,
   * String, String, String, List, List, Map, Integer, AccessPredicate, AccessPredicate)}
   */
  @Test
  @DisplayName(
      "Test new NamedOperationDetail(String, List, String, String, String, String, List, List, Map, Integer, AccessPredicate, AccessPredicate); when 'Operation Name'; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  void testNewNamedOperationDetail_whenOperationName_thenThrowIllegalArgumentException() {
    // Arrange
    ArrayList<String> labels = new ArrayList<>();
    ArrayList<String> readers = new ArrayList<>();
    ArrayList<String> writers = new ArrayList<>();
    HashMap<String, ParameterDetail> parameters = new HashMap<>();
    AccessPredicate readAccessPredicate = new AccessPredicate(mock(Predicate.class));
    AccessPredicate writeAccessPredicate = new AccessPredicate(mock(Predicate.class));

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            new NamedOperationDetail(
                "Operation Name",
                labels,
                "Input Type",
                "The characteristics of someone or something",
                "42",
                "Operations",
                readers,
                writers,
                parameters,
                3,
                readAccessPredicate,
                writeAccessPredicate));
  }

  /**
   * Test {@link NamedOperationDetail#NamedOperationDetail(String, List, String, String, String,
   * String, List, List, Map, Integer, AccessPredicate, AccessPredicate)}.
   *
   * <ul>
   *   <li>When {@code Operation Name}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link NamedOperationDetail#NamedOperationDetail(String, List, String,
   * String, String, String, List, List, Map, Integer, AccessPredicate, AccessPredicate)}
   */
  @Test
  @DisplayName(
      "Test new NamedOperationDetail(String, List, String, String, String, String, List, List, Map, Integer, AccessPredicate, AccessPredicate); when 'Operation Name'; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  void testNewNamedOperationDetail_whenOperationName_thenThrowIllegalArgumentException2() {
    // Arrange
    ArrayList<String> labels = new ArrayList<>();
    ArrayList<String> readers = new ArrayList<>();
    ArrayList<String> writers = new ArrayList<>();
    HashMap<String, ParameterDetail> parameters = new HashMap<>();
    AccessPredicate writeAccessPredicate = new AccessPredicate(mock(Predicate.class));

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            new NamedOperationDetail(
                "Operation Name",
                labels,
                "Input Type",
                "The characteristics of someone or something",
                "42",
                "Operations",
                readers,
                writers,
                parameters,
                3,
                null,
                writeAccessPredicate));
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link NamedOperationDetail#setInputType(String)}
   *   <li>{@link NamedOperationDetail#toString()}
   *   <li>{@link NamedOperationDetail#getCreatorId()}
   *   <li>{@link NamedOperationDetail#getDescription()}
   *   <li>{@link NamedOperationDetail#getInputType()}
   *   <li>{@link NamedOperationDetail#getLabels()}
   *   <li>{@link NamedOperationDetail#getOperationName()}
   *   <li>{@link NamedOperationDetail#getOperations()}
   *   <li>{@link NamedOperationDetail#getParameters()}
   *   <li>{@link NamedOperationDetail#getReadAccessRoles()}
   *   <li>{@link NamedOperationDetail#getResourceType()}
   *   <li>{@link NamedOperationDetail#getScore()}
   *   <li>{@link NamedOperationDetail#getWriteAccessRoles()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  void testGettersAndSetters() {
    // Arrange
    NamedOperationDetail namedOperationDetail = new NamedOperationDetail();

    // Act
    namedOperationDetail.setInputType("Input Type");
    String actualToStringResult = namedOperationDetail.toString();
    String actualCreatorId = namedOperationDetail.getCreatorId();
    String actualDescription = namedOperationDetail.getDescription();
    String actualInputType = namedOperationDetail.getInputType();
    List<String> actualLabels = namedOperationDetail.getLabels();
    String actualOperationName = namedOperationDetail.getOperationName();
    String actualOperations = namedOperationDetail.getOperations();
    Map<String, ParameterDetail> actualParameters = namedOperationDetail.getParameters();
    List<String> actualReadAccessRoles = namedOperationDetail.getReadAccessRoles();
    ResourceType actualResourceType = namedOperationDetail.getResourceType();
    Integer actualScore = namedOperationDetail.getScore();

    // Assert
    assertEquals("Input Type", actualInputType);
    assertEquals("NamedOperationDetail[inputType=Input Type,parameters={}]", actualToStringResult);
    assertNull(actualScore);
    assertNull(actualCreatorId);
    assertNull(actualDescription);
    assertNull(actualOperationName);
    assertNull(actualOperations);
    assertNull(actualLabels);
    assertNull(actualReadAccessRoles);
    assertNull(namedOperationDetail.getWriteAccessRoles());
    assertEquals(ResourceType.NamedOperation, actualResourceType);
    assertTrue(actualParameters.isEmpty());
  }

  /**
   * Test {@link NamedOperationDetail#getOperationChainWithDefaultParams()}.
   *
   * <p>Method under test: {@link NamedOperationDetail#getOperationChainWithDefaultParams()}
   */
  @Test
  @DisplayName("Test getOperationChainWithDefaultParams()")
  @Tag("MaintainedByDiffblue")
  void testGetOperationChainWithDefaultParams() {
    // Arrange
    ArrayList<String> readers = new ArrayList<>();
    ArrayList<String> writers = new ArrayList<>();

    NamedOperationDetail namedOperationDetail =
        new NamedOperationDetail(
            "Operation Name",
            "The characteristics of someone or something",
            "42",
            "Operations",
            readers,
            writers,
            new HashMap<>(),
            3);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> namedOperationDetail.getOperationChainWithDefaultParams());
  }

  /**
   * Test {@link NamedOperationDetail#getOperationChainWithDefaultParams()}.
   *
   * <p>Method under test: {@link NamedOperationDetail#getOperationChainWithDefaultParams()}
   */
  @Test
  @DisplayName("Test getOperationChainWithDefaultParams()")
  @Tag("MaintainedByDiffblue")
  void testGetOperationChainWithDefaultParams2() {
    // Arrange
    ArrayList<String> readers = new ArrayList<>();
    ArrayList<String> writers = new ArrayList<>();

    NamedOperationDetail namedOperationDetail =
        new NamedOperationDetail(
            "Operation Name",
            "The characteristics of someone or something",
            "42",
            "42",
            readers,
            writers,
            new HashMap<>(),
            3);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> namedOperationDetail.getOperationChainWithDefaultParams());
  }

  /**
   * Test {@link NamedOperationDetail#getOperationChainWithDefaultParams()}.
   *
   * <p>Method under test: {@link NamedOperationDetail#getOperationChainWithDefaultParams()}
   */
  @Test
  @DisplayName("Test getOperationChainWithDefaultParams()")
  @Tag("MaintainedByDiffblue")
  void testGetOperationChainWithDefaultParams3() {
    // Arrange
    ArrayList<String> readers = new ArrayList<>();
    ArrayList<String> writers = new ArrayList<>();

    NamedOperationDetail namedOperationDetail =
        new NamedOperationDetail(
            "Operation Name",
            "The characteristics of someone or something",
            "42",
            "",
            readers,
            writers,
            new HashMap<>(),
            3);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> namedOperationDetail.getOperationChainWithDefaultParams());
  }

  /**
   * Test {@link NamedOperationDetail#getOperationChain(Map)}.
   *
   * <p>Method under test: {@link NamedOperationDetail#getOperationChain(Map)}
   */
  @Test
  @DisplayName("Test getOperationChain(Map)")
  @Tag("MaintainedByDiffblue")
  void testGetOperationChain() {
    // Arrange
    ArrayList<String> readers = new ArrayList<>();
    ArrayList<String> writers = new ArrayList<>();

    NamedOperationDetail namedOperationDetail =
        new NamedOperationDetail(
            "Operation Name",
            "The characteristics of someone or something",
            "42",
            "Operations",
            readers,
            writers,
            new HashMap<>(),
            3);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> namedOperationDetail.getOperationChain(new HashMap<>()));
  }

  /**
   * Test {@link NamedOperationDetail#getOperationChain(Map)}.
   *
   * <p>Method under test: {@link NamedOperationDetail#getOperationChain(Map)}
   */
  @Test
  @DisplayName("Test getOperationChain(Map)")
  @Tag("MaintainedByDiffblue")
  void testGetOperationChain2() {
    // Arrange
    ArrayList<String> readers = new ArrayList<>();
    ArrayList<String> writers = new ArrayList<>();

    NamedOperationDetail namedOperationDetail =
        new NamedOperationDetail(
            "Operation Name",
            "The characteristics of someone or something",
            "42",
            "42",
            readers,
            writers,
            new HashMap<>(),
            3);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> namedOperationDetail.getOperationChain(new HashMap<>()));
  }

  /**
   * Test {@link NamedOperationDetail#getOperationChain(Map)}.
   *
   * <p>Method under test: {@link NamedOperationDetail#getOperationChain(Map)}
   */
  @Test
  @DisplayName("Test getOperationChain(Map)")
  @Tag("MaintainedByDiffblue")
  void testGetOperationChain3() {
    // Arrange
    ArrayList<String> readers = new ArrayList<>();
    ArrayList<String> writers = new ArrayList<>();

    NamedOperationDetail namedOperationDetail =
        new NamedOperationDetail(
            "Operation Name",
            "The characteristics of someone or something",
            "42",
            "",
            readers,
            writers,
            new HashMap<>(),
            3);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> namedOperationDetail.getOperationChain(new HashMap<>()));
  }

  /**
   * Test {@link NamedOperationDetail#getOperationChain(Map)}.
   *
   * <ul>
   *   <li>Given {@link NamedOperationDetail#NamedOperationDetail()}.
   *   <li>When {@link HashMap#HashMap()} {@code foo} is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link NamedOperationDetail#getOperationChain(Map)}
   */
  @Test
  @DisplayName(
      "Test getOperationChain(Map); given NamedOperationDetail(); when HashMap() 'foo' is '42'")
  @Tag("MaintainedByDiffblue")
  void testGetOperationChain_givenNamedOperationDetail_whenHashMapFooIs42() {
    // Arrange
    NamedOperationDetail namedOperationDetail = new NamedOperationDetail();

    HashMap<String, Object> executionParams = new HashMap<>();
    executionParams.put("foo", "42");

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> namedOperationDetail.getOperationChain(executionParams));
  }

  /**
   * Test {@link NamedOperationDetail#hasReadAccess(User, String)} with {@code user}, {@code
   * adminAuth}.
   *
   * <p>Method under test: {@link NamedOperationDetail#hasReadAccess(User, String)}
   */
  @Test
  @DisplayName("Test hasReadAccess(User, String) with 'user', 'adminAuth'")
  @Tag("MaintainedByDiffblue")
  void testHasReadAccessWithUserAdminAuth() {
    // Arrange
    ArrayList<String> readers = new ArrayList<>();
    ArrayList<String> writers = new ArrayList<>();

    NamedOperationDetail namedOperationDetail =
        new NamedOperationDetail(
            "Operation Name",
            "The characteristics of someone or something",
            "42",
            "Operations",
            readers,
            writers,
            new HashMap<>(),
            3);

    // Act and Assert
    assertFalse(namedOperationDetail.hasReadAccess(new User(), "Admin Auth"));
  }

  /**
   * Test {@link NamedOperationDetail#hasReadAccess(User, String)} with {@code user}, {@code
   * adminAuth}.
   *
   * <ul>
   *   <li>Given {@link NamedOperationDetail#NamedOperationDetail()}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link NamedOperationDetail#hasReadAccess(User, String)}
   */
  @Test
  @DisplayName(
      "Test hasReadAccess(User, String) with 'user', 'adminAuth'; given NamedOperationDetail(); then return 'false'")
  @Tag("MaintainedByDiffblue")
  void testHasReadAccessWithUserAdminAuth_givenNamedOperationDetail_thenReturnFalse() {
    // Arrange
    NamedOperationDetail namedOperationDetail = new NamedOperationDetail();

    // Act and Assert
    assertFalse(namedOperationDetail.hasReadAccess(new User(), "Admin Auth"));
  }

  /**
   * Test {@link NamedOperationDetail#hasReadAccess(User, String)} with {@code user}, {@code
   * adminAuth}.
   *
   * <ul>
   *   <li>Given {@link NamedOperationDetail#NamedOperationDetail()}.
   *   <li>When empty string.
   * </ul>
   *
   * <p>Method under test: {@link NamedOperationDetail#hasReadAccess(User, String)}
   */
  @Test
  @DisplayName(
      "Test hasReadAccess(User, String) with 'user', 'adminAuth'; given NamedOperationDetail(); when empty string")
  @Tag("MaintainedByDiffblue")
  void testHasReadAccessWithUserAdminAuth_givenNamedOperationDetail_whenEmptyString() {
    // Arrange
    NamedOperationDetail namedOperationDetail = new NamedOperationDetail();

    // Act and Assert
    assertFalse(namedOperationDetail.hasReadAccess(new User(), ""));
  }

  /**
   * Test {@link NamedOperationDetail#hasReadAccess(User, String)} with {@code user}, {@code
   * adminAuth}.
   *
   * <ul>
   *   <li>Given {@link NamedOperationDetail#NamedOperationDetail()}.
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link NamedOperationDetail#hasReadAccess(User, String)}
   */
  @Test
  @DisplayName(
      "Test hasReadAccess(User, String) with 'user', 'adminAuth'; given NamedOperationDetail(); when 'null'")
  @Tag("MaintainedByDiffblue")
  void testHasReadAccessWithUserAdminAuth_givenNamedOperationDetail_whenNull() {
    // Arrange, Act and Assert
    assertFalse(new NamedOperationDetail().hasReadAccess(null, "Admin Auth"));
  }

  /**
   * Test {@link NamedOperationDetail#hasReadAccess(User, String)} with {@code user}, {@code
   * adminAuth}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link NamedOperationDetail#hasReadAccess(User, String)}
   */
  @Test
  @DisplayName("Test hasReadAccess(User, String) with 'user', 'adminAuth'; then return 'true'")
  @Tag("MaintainedByDiffblue")
  void testHasReadAccessWithUserAdminAuth_thenReturnTrue() {
    // Arrange
    ArrayList<String> readers = new ArrayList<>();
    ArrayList<String> writers = new ArrayList<>();

    NamedOperationDetail namedOperationDetail =
        new NamedOperationDetail(
            "Operation Name",
            "The characteristics of someone or something",
            "UNKNOWN",
            "Operations",
            readers,
            writers,
            new HashMap<>(),
            3);

    // Act and Assert
    assertTrue(namedOperationDetail.hasReadAccess(new User(), "Admin Auth"));
  }

  /**
   * Test {@link NamedOperationDetail#hasWriteAccess(User, String)} with {@code user}, {@code
   * adminAuth}.
   *
   * <p>Method under test: {@link NamedOperationDetail#hasWriteAccess(User, String)}
   */
  @Test
  @DisplayName("Test hasWriteAccess(User, String) with 'user', 'adminAuth'")
  @Tag("MaintainedByDiffblue")
  void testHasWriteAccessWithUserAdminAuth() {
    // Arrange
    ArrayList<String> readers = new ArrayList<>();
    ArrayList<String> writers = new ArrayList<>();

    NamedOperationDetail namedOperationDetail =
        new NamedOperationDetail(
            "Operation Name",
            "The characteristics of someone or something",
            "42",
            "Operations",
            readers,
            writers,
            new HashMap<>(),
            3);

    // Act and Assert
    assertFalse(namedOperationDetail.hasWriteAccess(new User(), "Admin Auth"));
  }

  /**
   * Test {@link NamedOperationDetail#hasWriteAccess(User, String)} with {@code user}, {@code
   * adminAuth}.
   *
   * <ul>
   *   <li>Given {@link NamedOperationDetail#NamedOperationDetail()}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link NamedOperationDetail#hasWriteAccess(User, String)}
   */
  @Test
  @DisplayName(
      "Test hasWriteAccess(User, String) with 'user', 'adminAuth'; given NamedOperationDetail(); then return 'false'")
  @Tag("MaintainedByDiffblue")
  void testHasWriteAccessWithUserAdminAuth_givenNamedOperationDetail_thenReturnFalse() {
    // Arrange
    NamedOperationDetail namedOperationDetail = new NamedOperationDetail();

    // Act and Assert
    assertFalse(namedOperationDetail.hasWriteAccess(new User(), "Admin Auth"));
  }

  /**
   * Test {@link NamedOperationDetail#hasWriteAccess(User, String)} with {@code user}, {@code
   * adminAuth}.
   *
   * <ul>
   *   <li>Given {@link NamedOperationDetail#NamedOperationDetail()}.
   *   <li>When empty string.
   * </ul>
   *
   * <p>Method under test: {@link NamedOperationDetail#hasWriteAccess(User, String)}
   */
  @Test
  @DisplayName(
      "Test hasWriteAccess(User, String) with 'user', 'adminAuth'; given NamedOperationDetail(); when empty string")
  @Tag("MaintainedByDiffblue")
  void testHasWriteAccessWithUserAdminAuth_givenNamedOperationDetail_whenEmptyString() {
    // Arrange
    NamedOperationDetail namedOperationDetail = new NamedOperationDetail();

    // Act and Assert
    assertFalse(namedOperationDetail.hasWriteAccess(new User(), ""));
  }

  /**
   * Test {@link NamedOperationDetail#hasWriteAccess(User, String)} with {@code user}, {@code
   * adminAuth}.
   *
   * <ul>
   *   <li>Given {@link NamedOperationDetail#NamedOperationDetail()}.
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link NamedOperationDetail#hasWriteAccess(User, String)}
   */
  @Test
  @DisplayName(
      "Test hasWriteAccess(User, String) with 'user', 'adminAuth'; given NamedOperationDetail(); when 'null'")
  @Tag("MaintainedByDiffblue")
  void testHasWriteAccessWithUserAdminAuth_givenNamedOperationDetail_whenNull() {
    // Arrange, Act and Assert
    assertFalse(new NamedOperationDetail().hasWriteAccess(null, "Admin Auth"));
  }

  /**
   * Test {@link NamedOperationDetail#hasWriteAccess(User, String)} with {@code user}, {@code
   * adminAuth}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link NamedOperationDetail#hasWriteAccess(User, String)}
   */
  @Test
  @DisplayName("Test hasWriteAccess(User, String) with 'user', 'adminAuth'; then return 'true'")
  @Tag("MaintainedByDiffblue")
  void testHasWriteAccessWithUserAdminAuth_thenReturnTrue() {
    // Arrange
    ArrayList<String> readers = new ArrayList<>();
    ArrayList<String> writers = new ArrayList<>();

    NamedOperationDetail namedOperationDetail =
        new NamedOperationDetail(
            "Operation Name",
            "The characteristics of someone or something",
            "UNKNOWN",
            "Operations",
            readers,
            writers,
            new HashMap<>(),
            3);

    // Act and Assert
    assertTrue(namedOperationDetail.hasWriteAccess(new User(), "Admin Auth"));
  }

  /**
   * Test {@link NamedOperationDetail#getReadAccessPredicate()}.
   *
   * <p>Method under test: {@link NamedOperationDetail#getReadAccessPredicate()}
   */
  @Test
  @DisplayName("Test getReadAccessPredicate()")
  @Tag("MaintainedByDiffblue")
  void testGetReadAccessPredicate() {
    // Arrange, Act and Assert
    assertNull(new NamedOperationDetail().getReadAccessPredicate());
  }

  /**
   * Test {@link NamedOperationDetail#getWriteAccessPredicate()}.
   *
   * <p>Method under test: {@link NamedOperationDetail#getWriteAccessPredicate()}
   */
  @Test
  @DisplayName("Test getWriteAccessPredicate()")
  @Tag("MaintainedByDiffblue")
  void testGetWriteAccessPredicate() {
    // Arrange, Act and Assert
    assertNull(new NamedOperationDetail().getWriteAccessPredicate());
  }

  /**
   * Test {@link NamedOperationDetail#getOrDefaultReadAccessPredicate()}.
   *
   * <ul>
   *   <li>Then return UserPredicate CreatingUserId is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link NamedOperationDetail#getOrDefaultReadAccessPredicate()}
   */
  @Test
  @DisplayName(
      "Test getOrDefaultReadAccessPredicate(); then return UserPredicate CreatingUserId is '42'")
  @Tag("MaintainedByDiffblue")
  void testGetOrDefaultReadAccessPredicate_thenReturnUserPredicateCreatingUserIdIs42() {
    // Arrange
    ArrayList<String> readers = new ArrayList<>();
    ArrayList<String> writers = new ArrayList<>();

    NamedOperationDetail namedOperationDetail =
        new NamedOperationDetail(
            "Operation Name",
            "The characteristics of someone or something",
            "42",
            "Operations",
            readers,
            writers,
            new HashMap<>(),
            3);

    // Act and Assert
    Predicate<User> userPredicate =
        namedOperationDetail.getOrDefaultReadAccessPredicate().getUserPredicate();
    assertTrue(userPredicate instanceof DefaultUserPredicate);
    assertEquals("42", ((DefaultUserPredicate) userPredicate).getCreatingUserId());
    assertTrue(((DefaultUserPredicate) userPredicate).getAuths().isEmpty());
  }

  /**
   * Test {@link NamedOperationDetail#getOrDefaultReadAccessPredicate()}.
   *
   * <ul>
   *   <li>Then return UserPredicate CreatingUserId is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link NamedOperationDetail#getOrDefaultReadAccessPredicate()}
   */
  @Test
  @DisplayName(
      "Test getOrDefaultReadAccessPredicate(); then return UserPredicate CreatingUserId is 'null'")
  @Tag("MaintainedByDiffblue")
  void testGetOrDefaultReadAccessPredicate_thenReturnUserPredicateCreatingUserIdIsNull() {
    // Arrange, Act and Assert
    Predicate<User> userPredicate =
        new NamedOperationDetail().getOrDefaultReadAccessPredicate().getUserPredicate();
    assertTrue(userPredicate instanceof DefaultUserPredicate);
    assertNull(((DefaultUserPredicate) userPredicate).getCreatingUserId());
    assertTrue(((DefaultUserPredicate) userPredicate).getAuths().isEmpty());
  }

  /**
   * Test {@link NamedOperationDetail#getOrDefaultWriteAccessPredicate()}.
   *
   * <ul>
   *   <li>Then return UserPredicate CreatingUserId is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link NamedOperationDetail#getOrDefaultWriteAccessPredicate()}
   */
  @Test
  @DisplayName(
      "Test getOrDefaultWriteAccessPredicate(); then return UserPredicate CreatingUserId is '42'")
  @Tag("MaintainedByDiffblue")
  void testGetOrDefaultWriteAccessPredicate_thenReturnUserPredicateCreatingUserIdIs42() {
    // Arrange
    ArrayList<String> readers = new ArrayList<>();
    ArrayList<String> writers = new ArrayList<>();

    NamedOperationDetail namedOperationDetail =
        new NamedOperationDetail(
            "Operation Name",
            "The characteristics of someone or something",
            "42",
            "Operations",
            readers,
            writers,
            new HashMap<>(),
            3);

    // Act and Assert
    Predicate<User> userPredicate =
        namedOperationDetail.getOrDefaultWriteAccessPredicate().getUserPredicate();
    assertTrue(userPredicate instanceof DefaultUserPredicate);
    assertEquals("42", ((DefaultUserPredicate) userPredicate).getCreatingUserId());
    assertTrue(((DefaultUserPredicate) userPredicate).getAuths().isEmpty());
  }

  /**
   * Test {@link NamedOperationDetail#getOrDefaultWriteAccessPredicate()}.
   *
   * <ul>
   *   <li>Then return UserPredicate CreatingUserId is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link NamedOperationDetail#getOrDefaultWriteAccessPredicate()}
   */
  @Test
  @DisplayName(
      "Test getOrDefaultWriteAccessPredicate(); then return UserPredicate CreatingUserId is 'null'")
  @Tag("MaintainedByDiffblue")
  void testGetOrDefaultWriteAccessPredicate_thenReturnUserPredicateCreatingUserIdIsNull() {
    // Arrange, Act and Assert
    Predicate<User> userPredicate =
        new NamedOperationDetail().getOrDefaultWriteAccessPredicate().getUserPredicate();
    assertTrue(userPredicate instanceof DefaultUserPredicate);
    assertNull(((DefaultUserPredicate) userPredicate).getCreatingUserId());
    assertTrue(((DefaultUserPredicate) userPredicate).getAuths().isEmpty());
  }
}
