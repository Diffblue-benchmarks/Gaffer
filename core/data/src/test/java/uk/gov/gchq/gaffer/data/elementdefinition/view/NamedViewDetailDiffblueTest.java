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

package uk.gov.gchq.gaffer.data.elementdefinition.view;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
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
import uk.gov.gchq.gaffer.access.predicate.UnrestrictedAccessPredicate;
import uk.gov.gchq.gaffer.access.predicate.user.UnrestrictedAccessUserPredicate;
import uk.gov.gchq.gaffer.data.elementdefinition.view.NamedViewDetail.Builder;
import uk.gov.gchq.gaffer.data.elementdefinition.view.access.predicate.NamedViewWriteAccessPredicate;
import uk.gov.gchq.gaffer.data.elementdefinition.view.access.predicate.user.NamedViewWriteUserPredicate;
import uk.gov.gchq.gaffer.user.User;

class NamedViewDetailDiffblueTest {
  /**
   * Test Builder {@link Builder#view(String)} with {@code String}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#view(String)}
   */
  @Test
  @DisplayName(
      "Test Builder view(String) with 'String'; when 'null'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.view(String)"})
  void testBuilderViewWithString_whenNull_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> new Builder().view((String) null));
  }

  /**
   * Test Builder {@link Builder#view(String)} with {@code String}.
   *
   * <ul>
   *   <li>When {@code View}.
   *   <li>Then return {@link Builder} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link Builder#view(String)}
   */
  @Test
  @DisplayName(
      "Test Builder view(String) with 'String'; when 'View'; then return Builder (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.view(String)"})
  void testBuilderViewWithString_whenView_thenReturnBuilder() {
    // Arrange
    Builder builder = new Builder();

    // Act
    Builder actualViewResult = builder.view("View");

    // Assert
    assertSame(builder, actualViewResult);
  }

  /**
   * Test Builder {@link Builder#view(View)} with {@code View}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#view(View)}
   */
  @Test
  @DisplayName(
      "Test Builder view(View) with 'View'; when 'null'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.view(View)"})
  void testBuilderViewWithView_whenNull_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> new Builder().view((View) null));
  }

  /**
   * Test {@link NamedViewDetail#NamedViewDetail()}.
   *
   * <p>Method under test: {@link NamedViewDetail#NamedViewDetail()}
   */
  @Test
  @DisplayName("Test new NamedViewDetail()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void NamedViewDetail.<init>()"})
  void testNewNamedViewDetail() {
    // Arrange and Act
    NamedViewDetail actualNamedViewDetail = new NamedViewDetail();

    // Assert
    assertTrue(
        actualNamedViewDetail.getOrDefaultReadAccessPredicate()
            instanceof UnrestrictedAccessPredicate);
    assertTrue(
        actualNamedViewDetail.getOrDefaultWriteAccessPredicate()
            instanceof NamedViewWriteAccessPredicate);
    assertNull(actualNamedViewDetail.getCreatorId());
    assertNull(actualNamedViewDetail.getDescription());
    assertNull(actualNamedViewDetail.getName());
    assertNull(actualNamedViewDetail.getView());
    assertNull(actualNamedViewDetail.getWriteAccessRoles());
    assertNull(actualNamedViewDetail.getReadAccessPredicate());
    assertNull(actualNamedViewDetail.getWriteAccessPredicate());
    assertEquals(ResourceType.NamedView, actualNamedViewDetail.getResourceType());
    assertTrue(actualNamedViewDetail.getParameters().isEmpty());
  }

  /**
   * Test {@link NamedViewDetail#NamedViewDetail(String, String, String, String, List, Map,
   * AccessPredicate, AccessPredicate)}.
   *
   * <p>Method under test: {@link NamedViewDetail#NamedViewDetail(String, String, String, String,
   * List, Map, AccessPredicate, AccessPredicate)}
   */
  @Test
  @DisplayName(
      "Test new NamedViewDetail(String, String, String, String, List, Map, AccessPredicate, AccessPredicate)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void NamedViewDetail.<init>(String, String, String, String, List, Map, AccessPredicate, AccessPredicate)"
  })
  void testNewNamedViewDetail2() {
    // Arrange
    ArrayList<String> writers = new ArrayList<>();
    writers.add("Only one of writers or writeAccessPredicate should be supplied.");
    HashMap<String, ViewParameterDetail> parameters = new HashMap<>();
    AccessPredicate readAccessPredicate = new AccessPredicate(mock(Predicate.class));
    AccessPredicate writeAccessPredicate = new AccessPredicate(mock(Predicate.class));

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            new NamedViewDetail(
                "Name",
                "View",
                "The characteristics of someone or something",
                "42",
                writers,
                parameters,
                readAccessPredicate,
                writeAccessPredicate));
  }

  /**
   * Test {@link NamedViewDetail#NamedViewDetail(String, String, String, String, List, Map,
   * AccessPredicate, AccessPredicate)}.
   *
   * <p>Method under test: {@link NamedViewDetail#NamedViewDetail(String, String, String, String,
   * List, Map, AccessPredicate, AccessPredicate)}
   */
  @Test
  @DisplayName(
      "Test new NamedViewDetail(String, String, String, String, List, Map, AccessPredicate, AccessPredicate)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void NamedViewDetail.<init>(String, String, String, String, List, Map, AccessPredicate, AccessPredicate)"
  })
  void testNewNamedViewDetail3() {
    // Arrange
    ArrayList<String> writers = new ArrayList<>();

    // Act
    NamedViewDetail actualNamedViewDetail =
        new NamedViewDetail(
            "Name",
            "View",
            "The characteristics of someone or something",
            "42",
            writers,
            new HashMap<>(),
            null,
            null);

    // Assert
    AccessPredicate orDefaultReadAccessPredicate =
        actualNamedViewDetail.getOrDefaultReadAccessPredicate();
    assertTrue(orDefaultReadAccessPredicate instanceof UnrestrictedAccessPredicate);
    assertTrue(
        orDefaultReadAccessPredicate.getUserPredicate() instanceof UnrestrictedAccessUserPredicate);
    AccessPredicate orDefaultWriteAccessPredicate =
        actualNamedViewDetail.getOrDefaultWriteAccessPredicate();
    assertTrue(orDefaultWriteAccessPredicate instanceof NamedViewWriteAccessPredicate);
    Predicate<User> userPredicate = orDefaultWriteAccessPredicate.getUserPredicate();
    assertTrue(userPredicate instanceof NamedViewWriteUserPredicate);
    assertEquals("42", ((NamedViewWriteUserPredicate) userPredicate).getCreatingUserId());
    assertEquals("Name", actualNamedViewDetail.getName());
    assertEquals("View", actualNamedViewDetail.getView());
    assertNull(actualNamedViewDetail.getReadAccessPredicate());
    assertTrue(((NamedViewWriteUserPredicate) userPredicate).getAuths().isEmpty());
    assertTrue(actualNamedViewDetail.getWriteAccessRoles().isEmpty());
  }

  /**
   * Test {@link NamedViewDetail#NamedViewDetail(String, String, String, Map)}.
   *
   * <p>Method under test: {@link NamedViewDetail#NamedViewDetail(String, String, String, Map)}
   */
  @Test
  @DisplayName("Test new NamedViewDetail(String, String, String, Map)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void NamedViewDetail.<init>(String, String, String, Map)"})
  void testNewNamedViewDetail4() {
    // Arrange and Act
    NamedViewDetail actualNamedViewDetail =
        new NamedViewDetail("Name", "View", "The characteristics of someone or something", null);

    // Assert
    assertTrue(
        actualNamedViewDetail.getOrDefaultReadAccessPredicate()
            instanceof UnrestrictedAccessPredicate);
    assertTrue(
        actualNamedViewDetail.getOrDefaultWriteAccessPredicate()
            instanceof NamedViewWriteAccessPredicate);
    assertEquals("Name", actualNamedViewDetail.getName());
    assertEquals(
        "The characteristics of someone or something", actualNamedViewDetail.getDescription());
    assertEquals("View", actualNamedViewDetail.getView());
    assertNull(actualNamedViewDetail.getCreatorId());
    assertNull(actualNamedViewDetail.getReadAccessPredicate());
    assertNull(actualNamedViewDetail.getWriteAccessPredicate());
    assertEquals(ResourceType.NamedView, actualNamedViewDetail.getResourceType());
    assertTrue(actualNamedViewDetail.getWriteAccessRoles().isEmpty());
    assertTrue(actualNamedViewDetail.getParameters().isEmpty());
  }

  /**
   * Test {@link NamedViewDetail#NamedViewDetail(String, String, String, String, List, Map)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link NamedViewDetail#NamedViewDetail(String, String, String, String,
   * List, Map)}
   */
  @Test
  @DisplayName(
      "Test new NamedViewDetail(String, String, String, String, List, Map); given '42'; when ArrayList() add '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void NamedViewDetail.<init>(String, String, String, String, List, Map)"})
  void testNewNamedViewDetail_given42_whenArrayListAdd42() {
    // Arrange
    ArrayList<String> writers = new ArrayList<>();
    writers.add("42");
    writers.add("foo");

    // Act
    NamedViewDetail actualNamedViewDetail =
        new NamedViewDetail(
            "Name",
            "View",
            "The characteristics of someone or something",
            "42",
            writers,
            new HashMap<>());

    // Assert
    assertTrue(
        actualNamedViewDetail.getOrDefaultReadAccessPredicate()
            instanceof UnrestrictedAccessPredicate);
    assertTrue(
        actualNamedViewDetail.getOrDefaultWriteAccessPredicate()
            instanceof NamedViewWriteAccessPredicate);
    assertEquals("42", actualNamedViewDetail.getCreatorId());
    assertEquals("Name", actualNamedViewDetail.getName());
    assertEquals(
        "The characteristics of someone or something", actualNamedViewDetail.getDescription());
    assertEquals("View", actualNamedViewDetail.getView());
    assertNull(actualNamedViewDetail.getReadAccessPredicate());
    assertNull(actualNamedViewDetail.getWriteAccessPredicate());
    assertEquals(ResourceType.NamedView, actualNamedViewDetail.getResourceType());
    assertTrue(actualNamedViewDetail.getParameters().isEmpty());
    assertSame(writers, actualNamedViewDetail.getWriteAccessRoles());
  }

  /**
   * Test {@link NamedViewDetail#NamedViewDetail(String, String, String, String, List, Map)}.
   *
   * <ul>
   *   <li>Given {@code foo}.
   *   <li>Then return WriteAccessRoles is {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link NamedViewDetail#NamedViewDetail(String, String, String, String,
   * List, Map)}
   */
  @Test
  @DisplayName(
      "Test new NamedViewDetail(String, String, String, String, List, Map); given 'foo'; then return WriteAccessRoles is ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void NamedViewDetail.<init>(String, String, String, String, List, Map)"})
  void testNewNamedViewDetail_givenFoo_thenReturnWriteAccessRolesIsArrayList() {
    // Arrange
    ArrayList<String> writers = new ArrayList<>();
    writers.add("foo");

    // Act
    NamedViewDetail actualNamedViewDetail =
        new NamedViewDetail(
            "Name",
            "View",
            "The characteristics of someone or something",
            "42",
            writers,
            new HashMap<>());

    // Assert
    assertTrue(
        actualNamedViewDetail.getOrDefaultReadAccessPredicate()
            instanceof UnrestrictedAccessPredicate);
    assertTrue(
        actualNamedViewDetail.getOrDefaultWriteAccessPredicate()
            instanceof NamedViewWriteAccessPredicate);
    assertEquals("42", actualNamedViewDetail.getCreatorId());
    assertEquals("Name", actualNamedViewDetail.getName());
    assertEquals(
        "The characteristics of someone or something", actualNamedViewDetail.getDescription());
    assertEquals("View", actualNamedViewDetail.getView());
    assertNull(actualNamedViewDetail.getReadAccessPredicate());
    assertNull(actualNamedViewDetail.getWriteAccessPredicate());
    assertEquals(ResourceType.NamedView, actualNamedViewDetail.getResourceType());
    assertTrue(actualNamedViewDetail.getParameters().isEmpty());
    assertSame(writers, actualNamedViewDetail.getWriteAccessRoles());
  }

  /**
   * Test {@link NamedViewDetail#NamedViewDetail(String, String, String, String, List, Map,
   * AccessPredicate, AccessPredicate)}.
   *
   * <ul>
   *   <li>Given {@code foo}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code foo}.
   * </ul>
   *
   * <p>Method under test: {@link NamedViewDetail#NamedViewDetail(String, String, String, String,
   * List, Map, AccessPredicate, AccessPredicate)}
   */
  @Test
  @DisplayName(
      "Test new NamedViewDetail(String, String, String, String, List, Map, AccessPredicate, AccessPredicate); given 'foo'; when ArrayList() add 'foo'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void NamedViewDetail.<init>(String, String, String, String, List, Map, AccessPredicate, AccessPredicate)"
  })
  void testNewNamedViewDetail_givenFoo_whenArrayListAddFoo() {
    // Arrange
    ArrayList<String> writers = new ArrayList<>();
    writers.add("foo");
    writers.add("Only one of writers or writeAccessPredicate should be supplied.");
    HashMap<String, ViewParameterDetail> parameters = new HashMap<>();
    AccessPredicate readAccessPredicate = new AccessPredicate(mock(Predicate.class));
    AccessPredicate writeAccessPredicate = new AccessPredicate(mock(Predicate.class));

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            new NamedViewDetail(
                "Name",
                "View",
                "The characteristics of someone or something",
                "42",
                writers,
                parameters,
                readAccessPredicate,
                writeAccessPredicate));
  }

  /**
   * Test {@link NamedViewDetail#NamedViewDetail(String, String, String, String, List, Map,
   * AccessPredicate, AccessPredicate)}.
   *
   * <ul>
   *   <li>Then return Name is {@code Name cannot be null or empty}.
   * </ul>
   *
   * <p>Method under test: {@link NamedViewDetail#NamedViewDetail(String, String, String, String,
   * List, Map, AccessPredicate, AccessPredicate)}
   */
  @Test
  @DisplayName(
      "Test new NamedViewDetail(String, String, String, String, List, Map, AccessPredicate, AccessPredicate); then return Name is 'Name cannot be null or empty'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void NamedViewDetail.<init>(String, String, String, String, List, Map, AccessPredicate, AccessPredicate)"
  })
  void testNewNamedViewDetail_thenReturnNameIsNameCannotBeNullOrEmpty() {
    // Arrange and Act
    NamedViewDetail actualNamedViewDetail =
        new NamedViewDetail(
            "Name cannot be null or empty",
            "View cannot be null",
            "The characteristics of someone or something",
            "42",
            null,
            null,
            null,
            null);

    // Assert
    AccessPredicate orDefaultReadAccessPredicate =
        actualNamedViewDetail.getOrDefaultReadAccessPredicate();
    assertTrue(orDefaultReadAccessPredicate instanceof UnrestrictedAccessPredicate);
    assertTrue(
        orDefaultReadAccessPredicate.getUserPredicate() instanceof UnrestrictedAccessUserPredicate);
    assertEquals("Name cannot be null or empty", actualNamedViewDetail.getName());
    assertEquals("View cannot be null", actualNamedViewDetail.getView());
    assertNull(actualNamedViewDetail.getWriteAccessRoles());
    assertNull(actualNamedViewDetail.getReadAccessPredicate());
  }

  /**
   * Test {@link NamedViewDetail#NamedViewDetail(String, String, String, String, List, Map,
   * AccessPredicate, AccessPredicate)}.
   *
   * <ul>
   *   <li>When {@link AccessPredicate#AccessPredicate(Predicate)} with userPredicate is {@link
   *       Predicate}.
   * </ul>
   *
   * <p>Method under test: {@link NamedViewDetail#NamedViewDetail(String, String, String, String,
   * List, Map, AccessPredicate, AccessPredicate)}
   */
  @Test
  @DisplayName(
      "Test new NamedViewDetail(String, String, String, String, List, Map, AccessPredicate, AccessPredicate); when AccessPredicate(Predicate) with userPredicate is Predicate")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void NamedViewDetail.<init>(String, String, String, String, List, Map, AccessPredicate, AccessPredicate)"
  })
  void testNewNamedViewDetail_whenAccessPredicateWithUserPredicateIsPredicate() {
    // Arrange
    ArrayList<String> writers = new ArrayList<>();
    HashMap<String, ViewParameterDetail> parameters = new HashMap<>();
    AccessPredicate readAccessPredicate = new AccessPredicate(mock(Predicate.class));
    AccessPredicate writeAccessPredicate = new AccessPredicate(mock(Predicate.class));

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            new NamedViewDetail(
                "Name",
                "View",
                "The characteristics of someone or something",
                "42",
                writers,
                parameters,
                readAccessPredicate,
                writeAccessPredicate));
  }

  /**
   * Test {@link NamedViewDetail#NamedViewDetail(String, String, String, String, List, Map)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return WriteAccessRoles Empty.
   * </ul>
   *
   * <p>Method under test: {@link NamedViewDetail#NamedViewDetail(String, String, String, String,
   * List, Map)}
   */
  @Test
  @DisplayName(
      "Test new NamedViewDetail(String, String, String, String, List, Map); when ArrayList(); then return WriteAccessRoles Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void NamedViewDetail.<init>(String, String, String, String, List, Map)"})
  void testNewNamedViewDetail_whenArrayList_thenReturnWriteAccessRolesEmpty() {
    // Arrange
    ArrayList<String> writers = new ArrayList<>();

    // Act
    NamedViewDetail actualNamedViewDetail =
        new NamedViewDetail(
            "Name",
            "View",
            "The characteristics of someone or something",
            "42",
            writers,
            new HashMap<>());

    // Assert
    assertTrue(
        actualNamedViewDetail.getOrDefaultReadAccessPredicate()
            instanceof UnrestrictedAccessPredicate);
    assertTrue(
        actualNamedViewDetail.getOrDefaultWriteAccessPredicate()
            instanceof NamedViewWriteAccessPredicate);
    assertEquals("42", actualNamedViewDetail.getCreatorId());
    assertEquals("Name", actualNamedViewDetail.getName());
    assertEquals(
        "The characteristics of someone or something", actualNamedViewDetail.getDescription());
    assertEquals("View", actualNamedViewDetail.getView());
    assertNull(actualNamedViewDetail.getReadAccessPredicate());
    assertNull(actualNamedViewDetail.getWriteAccessPredicate());
    assertEquals(ResourceType.NamedView, actualNamedViewDetail.getResourceType());
    assertTrue(actualNamedViewDetail.getWriteAccessRoles().isEmpty());
    assertTrue(actualNamedViewDetail.getParameters().isEmpty());
  }

  /**
   * Test {@link NamedViewDetail#NamedViewDetail(String, String, String, String, List, Map,
   * AccessPredicate, AccessPredicate)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link NamedViewDetail#NamedViewDetail(String, String, String, String,
   * List, Map, AccessPredicate, AccessPredicate)}
   */
  @Test
  @DisplayName(
      "Test new NamedViewDetail(String, String, String, String, List, Map, AccessPredicate, AccessPredicate); when ArrayList(); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void NamedViewDetail.<init>(String, String, String, String, List, Map, AccessPredicate, AccessPredicate)"
  })
  void testNewNamedViewDetail_whenArrayList_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            new NamedViewDetail(
                null,
                null,
                "The characteristics of someone or something",
                "42",
                new ArrayList<>(),
                null,
                null,
                null));
  }

  /**
   * Test {@link NamedViewDetail#NamedViewDetail(String, String, String, String, List, Map)}.
   *
   * <ul>
   *   <li>When empty string.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link NamedViewDetail#NamedViewDetail(String, String, String, String,
   * List, Map)}
   */
  @Test
  @DisplayName(
      "Test new NamedViewDetail(String, String, String, String, List, Map); when empty string; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void NamedViewDetail.<init>(String, String, String, String, List, Map)"})
  void testNewNamedViewDetail_whenEmptyString_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            new NamedViewDetail(
                "", null, "The characteristics of someone or something", "42", null, null));
  }

  /**
   * Test {@link NamedViewDetail#NamedViewDetail(String, String, String, String, List, Map,
   * AccessPredicate, AccessPredicate)}.
   *
   * <ul>
   *   <li>When empty string.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link NamedViewDetail#NamedViewDetail(String, String, String, String,
   * List, Map, AccessPredicate, AccessPredicate)}
   */
  @Test
  @DisplayName(
      "Test new NamedViewDetail(String, String, String, String, List, Map, AccessPredicate, AccessPredicate); when empty string; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void NamedViewDetail.<init>(String, String, String, String, List, Map, AccessPredicate, AccessPredicate)"
  })
  void testNewNamedViewDetail_whenEmptyString_thenThrowIllegalArgumentException2() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            new NamedViewDetail(
                "",
                null,
                "The characteristics of someone or something",
                "42",
                null,
                null,
                null,
                null));
  }

  /**
   * Test {@link NamedViewDetail#NamedViewDetail(String, String, String, Map)}.
   *
   * <ul>
   *   <li>When empty string.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link NamedViewDetail#NamedViewDetail(String, String, String, Map)}
   */
  @Test
  @DisplayName(
      "Test new NamedViewDetail(String, String, String, Map); when empty string; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void NamedViewDetail.<init>(String, String, String, Map)"})
  void testNewNamedViewDetail_whenEmptyString_thenThrowIllegalArgumentException3() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> new NamedViewDetail("", null, "The characteristics of someone or something", null));
  }

  /**
   * Test {@link NamedViewDetail#NamedViewDetail(String, String, String, Map)}.
   *
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.
   * </ul>
   *
   * <p>Method under test: {@link NamedViewDetail#NamedViewDetail(String, String, String, Map)}
   */
  @Test
  @DisplayName("Test new NamedViewDetail(String, String, String, Map); when HashMap()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void NamedViewDetail.<init>(String, String, String, Map)"})
  void testNewNamedViewDetail_whenHashMap() {
    // Arrange and Act
    NamedViewDetail actualNamedViewDetail =
        new NamedViewDetail(
            "Name", "View", "The characteristics of someone or something", new HashMap<>());

    // Assert
    assertTrue(
        actualNamedViewDetail.getOrDefaultReadAccessPredicate()
            instanceof UnrestrictedAccessPredicate);
    assertTrue(
        actualNamedViewDetail.getOrDefaultWriteAccessPredicate()
            instanceof NamedViewWriteAccessPredicate);
    assertEquals("Name", actualNamedViewDetail.getName());
    assertEquals(
        "The characteristics of someone or something", actualNamedViewDetail.getDescription());
    assertEquals("View", actualNamedViewDetail.getView());
    assertNull(actualNamedViewDetail.getCreatorId());
    assertNull(actualNamedViewDetail.getReadAccessPredicate());
    assertNull(actualNamedViewDetail.getWriteAccessPredicate());
    assertEquals(ResourceType.NamedView, actualNamedViewDetail.getResourceType());
    assertTrue(actualNamedViewDetail.getWriteAccessRoles().isEmpty());
    assertTrue(actualNamedViewDetail.getParameters().isEmpty());
  }

  /**
   * Test {@link NamedViewDetail#NamedViewDetail(String, String, String, String, List, Map,
   * AccessPredicate, AccessPredicate)}.
   *
   * <ul>
   *   <li>When {@code Name cannot be null or empty}.
   * </ul>
   *
   * <p>Method under test: {@link NamedViewDetail#NamedViewDetail(String, String, String, String,
   * List, Map, AccessPredicate, AccessPredicate)}
   */
  @Test
  @DisplayName(
      "Test new NamedViewDetail(String, String, String, String, List, Map, AccessPredicate, AccessPredicate); when 'Name cannot be null or empty'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void NamedViewDetail.<init>(String, String, String, String, List, Map, AccessPredicate, AccessPredicate)"
  })
  void testNewNamedViewDetail_whenNameCannotBeNullOrEmpty() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            new NamedViewDetail(
                "Name cannot be null or empty",
                null,
                "The characteristics of someone or something",
                "42",
                null,
                null,
                null,
                null));
  }

  /**
   * Test {@link NamedViewDetail#NamedViewDetail(String, String, String, Map)}.
   *
   * <ul>
   *   <li>When {@code Name}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link NamedViewDetail#NamedViewDetail(String, String, String, Map)}
   */
  @Test
  @DisplayName(
      "Test new NamedViewDetail(String, String, String, Map); when 'Name'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void NamedViewDetail.<init>(String, String, String, Map)"})
  void testNewNamedViewDetail_whenName_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            new NamedViewDetail("Name", null, "The characteristics of someone or something", null));
  }

  /**
   * Test {@link NamedViewDetail#NamedViewDetail(String, String, String, String, List, Map)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link NamedViewDetail#NamedViewDetail(String, String, String, String,
   * List, Map)}
   */
  @Test
  @DisplayName(
      "Test new NamedViewDetail(String, String, String, String, List, Map); when 'null'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void NamedViewDetail.<init>(String, String, String, String, List, Map)"})
  void testNewNamedViewDetail_whenNull_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            new NamedViewDetail(
                null, null, "The characteristics of someone or something", "42", null, null));
  }

  /**
   * Test {@link NamedViewDetail#NamedViewDetail(String, String, String, String, List, Map)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link NamedViewDetail#NamedViewDetail(String, String, String, String,
   * List, Map)}
   */
  @Test
  @DisplayName(
      "Test new NamedViewDetail(String, String, String, String, List, Map); when 'null'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void NamedViewDetail.<init>(String, String, String, String, List, Map)"})
  void testNewNamedViewDetail_whenNull_thenThrowIllegalArgumentException2() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            new NamedViewDetail(
                "Name", null, "The characteristics of someone or something", "42", null, null));
  }

  /**
   * Test {@link NamedViewDetail#NamedViewDetail(String, String, String, String, List, Map,
   * AccessPredicate, AccessPredicate)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link NamedViewDetail#NamedViewDetail(String, String, String, String,
   * List, Map, AccessPredicate, AccessPredicate)}
   */
  @Test
  @DisplayName(
      "Test new NamedViewDetail(String, String, String, String, List, Map, AccessPredicate, AccessPredicate); when 'null'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void NamedViewDetail.<init>(String, String, String, String, List, Map, AccessPredicate, AccessPredicate)"
  })
  void testNewNamedViewDetail_whenNull_thenThrowIllegalArgumentException3() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            new NamedViewDetail(
                null,
                null,
                "The characteristics of someone or something",
                "42",
                null,
                null,
                null,
                null));
  }

  /**
   * Test {@link NamedViewDetail#NamedViewDetail(String, String, String, Map)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link NamedViewDetail#NamedViewDetail(String, String, String, Map)}
   */
  @Test
  @DisplayName(
      "Test new NamedViewDetail(String, String, String, Map); when 'null'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void NamedViewDetail.<init>(String, String, String, Map)"})
  void testNewNamedViewDetail_whenNull_thenThrowIllegalArgumentException4() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> new NamedViewDetail(null, null, "The characteristics of someone or something", null));
  }

  /**
   * Test {@link NamedViewDetail#NamedViewDetail(String, String, String, String, List, Map)}.
   *
   * <ul>
   *   <li>When {@code View}.
   *   <li>Then return WriteAccessRoles is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link NamedViewDetail#NamedViewDetail(String, String, String, String,
   * List, Map)}
   */
  @Test
  @DisplayName(
      "Test new NamedViewDetail(String, String, String, String, List, Map); when 'View'; then return WriteAccessRoles is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void NamedViewDetail.<init>(String, String, String, String, List, Map)"})
  void testNewNamedViewDetail_whenView_thenReturnWriteAccessRolesIsNull() {
    // Arrange and Act
    NamedViewDetail actualNamedViewDetail =
        new NamedViewDetail(
            "Name", "View", "The characteristics of someone or something", "42", null, null);

    // Assert
    assertTrue(
        actualNamedViewDetail.getOrDefaultReadAccessPredicate()
            instanceof UnrestrictedAccessPredicate);
    assertTrue(
        actualNamedViewDetail.getOrDefaultWriteAccessPredicate()
            instanceof NamedViewWriteAccessPredicate);
    assertEquals("42", actualNamedViewDetail.getCreatorId());
    assertEquals("Name", actualNamedViewDetail.getName());
    assertEquals(
        "The characteristics of someone or something", actualNamedViewDetail.getDescription());
    assertEquals("View", actualNamedViewDetail.getView());
    assertNull(actualNamedViewDetail.getWriteAccessRoles());
    assertNull(actualNamedViewDetail.getReadAccessPredicate());
    assertNull(actualNamedViewDetail.getWriteAccessPredicate());
    assertEquals(ResourceType.NamedView, actualNamedViewDetail.getResourceType());
    assertTrue(actualNamedViewDetail.getParameters().isEmpty());
  }

  /**
   * Test {@link NamedViewDetail#setName(String)}.
   *
   * <ul>
   *   <li>When empty string.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link NamedViewDetail#setName(String)}
   */
  @Test
  @DisplayName("Test setName(String); when empty string; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void NamedViewDetail.setName(String)"})
  void testSetName_whenEmptyString_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> new NamedViewDetail().setName(""));
  }

  /**
   * Test {@link NamedViewDetail#setName(String)}.
   *
   * <ul>
   *   <li>When {@code Name}.
   *   <li>Then {@link NamedViewDetail#NamedViewDetail()} Name is {@code Name}.
   * </ul>
   *
   * <p>Method under test: {@link NamedViewDetail#setName(String)}
   */
  @Test
  @DisplayName("Test setName(String); when 'Name'; then NamedViewDetail() Name is 'Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void NamedViewDetail.setName(String)"})
  void testSetName_whenName_thenNamedViewDetailNameIsName() {
    // Arrange
    NamedViewDetail namedViewDetail = new NamedViewDetail();

    // Act
    namedViewDetail.setName("Name");

    // Assert
    assertEquals("Name", namedViewDetail.getName());
  }

  /**
   * Test {@link NamedViewDetail#setName(String)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link NamedViewDetail#setName(String)}
   */
  @Test
  @DisplayName("Test setName(String); when 'null'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void NamedViewDetail.setName(String)"})
  void testSetName_whenNull_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> new NamedViewDetail().setName(null));
  }

  /**
   * Test {@link NamedViewDetail#getView(Map)} with {@code Map}.
   *
   * <p>Method under test: {@link NamedViewDetail#getView(Map)}
   */
  @Test
  @DisplayName("Test getView(Map) with 'Map'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"View NamedViewDetail.getView(Map)"})
  void testGetViewWithMap() {
    // Arrange
    NamedViewDetail namedViewDetail =
        new NamedViewDetail(
            "Name", "View", "The characteristics of someone or something", new HashMap<>());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> namedViewDetail.getView(new HashMap<>()));
  }

  /**
   * Test {@link NamedViewDetail#getView(Map)} with {@code Map}.
   *
   * <ul>
   *   <li>Given {@link NamedViewDetail#NamedViewDetail()}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link NamedViewDetail#getView(Map)}
   */
  @Test
  @DisplayName(
      "Test getView(Map) with 'Map'; given NamedViewDetail(); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"View NamedViewDetail.getView(Map)"})
  void testGetViewWithMap_givenNamedViewDetail_thenThrowIllegalArgumentException() {
    // Arrange
    NamedViewDetail namedViewDetail = new NamedViewDetail();

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> namedViewDetail.getView(new HashMap<>()));
  }

  /**
   * Test {@link NamedViewDetail#setView(String)} with {@code String}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link NamedViewDetail#setView(String)}
   */
  @Test
  @DisplayName(
      "Test setView(String) with 'String'; when 'null'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void NamedViewDetail.setView(String)"})
  void testSetViewWithString_whenNull_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> new NamedViewDetail().setView((String) null));
  }

  /**
   * Test {@link NamedViewDetail#setView(String)} with {@code String}.
   *
   * <ul>
   *   <li>When {@code View}.
   *   <li>Then {@link NamedViewDetail#NamedViewDetail()} View is {@code View}.
   * </ul>
   *
   * <p>Method under test: {@link NamedViewDetail#setView(String)}
   */
  @Test
  @DisplayName(
      "Test setView(String) with 'String'; when 'View'; then NamedViewDetail() View is 'View'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void NamedViewDetail.setView(String)"})
  void testSetViewWithString_whenView_thenNamedViewDetailViewIsView() {
    // Arrange
    NamedViewDetail namedViewDetail = new NamedViewDetail();

    // Act
    namedViewDetail.setView("View");

    // Assert
    assertEquals("View", namedViewDetail.getView());
  }

  /**
   * Test {@link NamedViewDetail#setView(View)} with {@code View}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link NamedViewDetail#setView(View)}
   */
  @Test
  @DisplayName("Test setView(View) with 'View'; when 'null'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void NamedViewDetail.setView(View)"})
  void testSetViewWithView_whenNull_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> new NamedViewDetail().setView((View) null));
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link NamedViewDetail#setDescription(String)}
   *   <li>{@link NamedViewDetail#toString()}
   *   <li>{@link NamedViewDetail#getCreatorId()}
   *   <li>{@link NamedViewDetail#getDescription()}
   *   <li>{@link NamedViewDetail#getName()}
   *   <li>{@link NamedViewDetail#getParameters()}
   *   <li>{@link NamedViewDetail#getResourceType()}
   *   <li>{@link NamedViewDetail#getView()}
   *   <li>{@link NamedViewDetail#getWriteAccessRoles()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String NamedViewDetail.getCreatorId()",
    "String NamedViewDetail.getDescription()",
    "String NamedViewDetail.getName()",
    "Map NamedViewDetail.getParameters()",
    "ResourceType NamedViewDetail.getResourceType()",
    "String NamedViewDetail.getView()",
    "List NamedViewDetail.getWriteAccessRoles()",
    "void NamedViewDetail.setDescription(String)",
    "String NamedViewDetail.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    NamedViewDetail namedViewDetail = new NamedViewDetail();

    // Act
    namedViewDetail.setDescription("The characteristics of someone or something");
    String actualToStringResult = namedViewDetail.toString();
    String actualCreatorId = namedViewDetail.getCreatorId();
    String actualDescription = namedViewDetail.getDescription();
    String actualName = namedViewDetail.getName();
    Map<String, ViewParameterDetail> actualParameters = namedViewDetail.getParameters();
    ResourceType actualResourceType = namedViewDetail.getResourceType();
    String actualView = namedViewDetail.getView();

    // Assert
    assertEquals(
        "NamedViewDetail[description=The characteristics of someone or something,parameters={}]",
        actualToStringResult);
    assertEquals("The characteristics of someone or something", actualDescription);
    assertNull(actualCreatorId);
    assertNull(actualName);
    assertNull(actualView);
    assertNull(namedViewDetail.getWriteAccessRoles());
    assertEquals(ResourceType.NamedView, actualResourceType);
    assertTrue(actualParameters.isEmpty());
  }

  /**
   * Test {@link NamedViewDetail#hasReadAccess(User, String)} with {@code user}, {@code adminAuth}.
   *
   * <ul>
   *   <li>Given {@link NamedViewDetail#NamedViewDetail()}.
   *   <li>When empty string.
   * </ul>
   *
   * <p>Method under test: {@link NamedViewDetail#hasReadAccess(User, String)}
   */
  @Test
  @DisplayName(
      "Test hasReadAccess(User, String) with 'user', 'adminAuth'; given NamedViewDetail(); when empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean NamedViewDetail.hasReadAccess(User, String)"})
  void testHasReadAccessWithUserAdminAuth_givenNamedViewDetail_whenEmptyString() {
    // Arrange
    NamedViewDetail namedViewDetail = new NamedViewDetail();

    // Act and Assert
    assertTrue(namedViewDetail.hasReadAccess(new User(), ""));
  }

  /**
   * Test {@link NamedViewDetail#hasReadAccess(User, String)} with {@code user}, {@code adminAuth}.
   *
   * <ul>
   *   <li>Given {@link NamedViewDetail#NamedViewDetail()}.
   *   <li>When {@code null}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link NamedViewDetail#hasReadAccess(User, String)}
   */
  @Test
  @DisplayName(
      "Test hasReadAccess(User, String) with 'user', 'adminAuth'; given NamedViewDetail(); when 'null'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean NamedViewDetail.hasReadAccess(User, String)"})
  void testHasReadAccessWithUserAdminAuth_givenNamedViewDetail_whenNull_thenReturnTrue() {
    // Arrange
    NamedViewDetail namedViewDetail = new NamedViewDetail();

    // Act and Assert
    assertTrue(namedViewDetail.hasReadAccess(new User(), null));
  }

  /**
   * Test {@link NamedViewDetail#hasReadAccess(User, String)} with {@code user}, {@code adminAuth}.
   *
   * <ul>
   *   <li>Given {@link NamedViewDetail#NamedViewDetail()}.
   *   <li>When {@code null}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link NamedViewDetail#hasReadAccess(User, String)}
   */
  @Test
  @DisplayName(
      "Test hasReadAccess(User, String) with 'user', 'adminAuth'; given NamedViewDetail(); when 'null'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean NamedViewDetail.hasReadAccess(User, String)"})
  void testHasReadAccessWithUserAdminAuth_givenNamedViewDetail_whenNull_thenReturnTrue2() {
    // Arrange, Act and Assert
    assertTrue(new NamedViewDetail().hasReadAccess(null, "Admin Auth"));
  }

  /**
   * Test {@link NamedViewDetail#hasReadAccess(User, String)} with {@code user}, {@code adminAuth}.
   *
   * <ul>
   *   <li>Given {@link NamedViewDetail#NamedViewDetail()}.
   *   <li>When {@link User#User()}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link NamedViewDetail#hasReadAccess(User, String)}
   */
  @Test
  @DisplayName(
      "Test hasReadAccess(User, String) with 'user', 'adminAuth'; given NamedViewDetail(); when User(); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean NamedViewDetail.hasReadAccess(User, String)"})
  void testHasReadAccessWithUserAdminAuth_givenNamedViewDetail_whenUser_thenReturnTrue() {
    // Arrange
    NamedViewDetail namedViewDetail = new NamedViewDetail();

    // Act and Assert
    assertTrue(namedViewDetail.hasReadAccess(new User(), "Admin Auth"));
  }

  /**
   * Test {@link NamedViewDetail#hasWriteAccess(User, String)} with {@code user}, {@code adminAuth}.
   *
   * <p>Method under test: {@link NamedViewDetail#hasWriteAccess(User, String)}
   */
  @Test
  @DisplayName("Test hasWriteAccess(User, String) with 'user', 'adminAuth'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean NamedViewDetail.hasWriteAccess(User, String)"})
  void testHasWriteAccessWithUserAdminAuth() {
    // Arrange
    NamedViewDetail namedViewDetail =
        new NamedViewDetail(
            "Name", "View", "The characteristics of someone or something", new HashMap<>());

    // Act and Assert
    assertTrue(namedViewDetail.hasWriteAccess(new User(), "Admin Auth"));
  }

  /**
   * Test {@link NamedViewDetail#hasWriteAccess(User, String)} with {@code user}, {@code adminAuth}.
   *
   * <p>Method under test: {@link NamedViewDetail#hasWriteAccess(User, String)}
   */
  @Test
  @DisplayName("Test hasWriteAccess(User, String) with 'user', 'adminAuth'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean NamedViewDetail.hasWriteAccess(User, String)"})
  void testHasWriteAccessWithUserAdminAuth2() {
    // Arrange
    ArrayList<String> writers = new ArrayList<>();
    NamedViewDetail namedViewDetail =
        new NamedViewDetail(
            "Name",
            "View",
            "The characteristics of someone or something",
            "42",
            writers,
            new HashMap<>());

    // Act and Assert
    assertFalse(namedViewDetail.hasWriteAccess(new User(), "Admin Auth"));
  }

  /**
   * Test {@link NamedViewDetail#hasWriteAccess(User, String)} with {@code user}, {@code adminAuth}.
   *
   * <p>Method under test: {@link NamedViewDetail#hasWriteAccess(User, String)}
   */
  @Test
  @DisplayName("Test hasWriteAccess(User, String) with 'user', 'adminAuth'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean NamedViewDetail.hasWriteAccess(User, String)"})
  void testHasWriteAccessWithUserAdminAuth3() {
    // Arrange
    ArrayList<String> writers = new ArrayList<>();
    NamedViewDetail namedViewDetail =
        new NamedViewDetail(
            "Name",
            "View",
            "The characteristics of someone or something",
            "UNKNOWN",
            writers,
            new HashMap<>());

    // Act and Assert
    assertTrue(namedViewDetail.hasWriteAccess(new User(), "Admin Auth"));
  }

  /**
   * Test {@link NamedViewDetail#hasWriteAccess(User, String)} with {@code user}, {@code adminAuth}.
   *
   * <ul>
   *   <li>Given {@link NamedViewDetail#NamedViewDetail()}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link NamedViewDetail#hasWriteAccess(User, String)}
   */
  @Test
  @DisplayName(
      "Test hasWriteAccess(User, String) with 'user', 'adminAuth'; given NamedViewDetail(); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean NamedViewDetail.hasWriteAccess(User, String)"})
  void testHasWriteAccessWithUserAdminAuth_givenNamedViewDetail_thenReturnTrue() {
    // Arrange
    NamedViewDetail namedViewDetail = new NamedViewDetail();

    // Act and Assert
    assertTrue(namedViewDetail.hasWriteAccess(new User(), "Admin Auth"));
  }

  /**
   * Test {@link NamedViewDetail#hasWriteAccess(User, String)} with {@code user}, {@code adminAuth}.
   *
   * <ul>
   *   <li>Given {@link NamedViewDetail#NamedViewDetail()}.
   *   <li>When empty string.
   * </ul>
   *
   * <p>Method under test: {@link NamedViewDetail#hasWriteAccess(User, String)}
   */
  @Test
  @DisplayName(
      "Test hasWriteAccess(User, String) with 'user', 'adminAuth'; given NamedViewDetail(); when empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean NamedViewDetail.hasWriteAccess(User, String)"})
  void testHasWriteAccessWithUserAdminAuth_givenNamedViewDetail_whenEmptyString() {
    // Arrange
    NamedViewDetail namedViewDetail = new NamedViewDetail();

    // Act and Assert
    assertTrue(namedViewDetail.hasWriteAccess(new User(), ""));
  }

  /**
   * Test {@link NamedViewDetail#hasWriteAccess(User, String)} with {@code user}, {@code adminAuth}.
   *
   * <ul>
   *   <li>Given {@link NamedViewDetail#NamedViewDetail()}.
   *   <li>When {@code null}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link NamedViewDetail#hasWriteAccess(User, String)}
   */
  @Test
  @DisplayName(
      "Test hasWriteAccess(User, String) with 'user', 'adminAuth'; given NamedViewDetail(); when 'null'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean NamedViewDetail.hasWriteAccess(User, String)"})
  void testHasWriteAccessWithUserAdminAuth_givenNamedViewDetail_whenNull_thenReturnTrue() {
    // Arrange
    NamedViewDetail namedViewDetail = new NamedViewDetail();

    // Act and Assert
    assertTrue(namedViewDetail.hasWriteAccess(new User(), null));
  }

  /**
   * Test {@link NamedViewDetail#hasWriteAccess(User, String)} with {@code user}, {@code adminAuth}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link NamedViewDetail#hasWriteAccess(User, String)}
   */
  @Test
  @DisplayName(
      "Test hasWriteAccess(User, String) with 'user', 'adminAuth'; when 'null'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean NamedViewDetail.hasWriteAccess(User, String)"})
  void testHasWriteAccessWithUserAdminAuth_whenNull_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new NamedViewDetail().hasWriteAccess(null, "Admin Auth"));
  }

  /**
   * Test {@link NamedViewDetail#getViewWithDefaultParams()}.
   *
   * <p>Method under test: {@link NamedViewDetail#getViewWithDefaultParams()}
   */
  @Test
  @DisplayName("Test getViewWithDefaultParams()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"View NamedViewDetail.getViewWithDefaultParams()"})
  void testGetViewWithDefaultParams() {
    // Arrange
    NamedViewDetail namedViewDetail =
        new NamedViewDetail(
            "Name", "View", "The characteristics of someone or something", new HashMap<>());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> namedViewDetail.getViewWithDefaultParams());
  }

  /**
   * Test {@link NamedViewDetail#getViewWithDefaultParams()}.
   *
   * <ul>
   *   <li>Given {@link NamedViewDetail#NamedViewDetail()}.
   * </ul>
   *
   * <p>Method under test: {@link NamedViewDetail#getViewWithDefaultParams()}
   */
  @Test
  @DisplayName("Test getViewWithDefaultParams(); given NamedViewDetail()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"View NamedViewDetail.getViewWithDefaultParams()"})
  void testGetViewWithDefaultParams_givenNamedViewDetail() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> new NamedViewDetail().getViewWithDefaultParams());
  }

  /**
   * Test {@link NamedViewDetail#getReadAccessPredicate()}.
   *
   * <ul>
   *   <li>Given {@link NamedViewDetail#NamedViewDetail()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link NamedViewDetail#getReadAccessPredicate()}
   */
  @Test
  @DisplayName("Test getReadAccessPredicate(); given NamedViewDetail(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"AccessPredicate NamedViewDetail.getReadAccessPredicate()"})
  void testGetReadAccessPredicate_givenNamedViewDetail_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new NamedViewDetail().getReadAccessPredicate());
  }

  /**
   * Test {@link NamedViewDetail#getReadAccessPredicate()}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link NamedViewDetail#getReadAccessPredicate()}
   */
  @Test
  @DisplayName("Test getReadAccessPredicate(); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"AccessPredicate NamedViewDetail.getReadAccessPredicate()"})
  void testGetReadAccessPredicate_thenThrowIllegalArgumentException() {
    // Arrange
    Builder nameResult =
        new Builder()
            .creatorId("42")
            .description("The characteristics of someone or something")
            .name("Name");

    Builder parametersResult = nameResult.parameters(new HashMap<>());

    Builder writeAccessPredicateResult =
        parametersResult
            .readAccessPredicate(new AccessPredicate(mock(Predicate.class)))
            .view("View")
            .writeAccessPredicate(null);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            writeAccessPredicateResult.writers(new ArrayList<>()).build().getReadAccessPredicate());
  }

  /**
   * Test {@link NamedViewDetail#getWriteAccessPredicate()}.
   *
   * <p>Method under test: {@link NamedViewDetail#getWriteAccessPredicate()}
   */
  @Test
  @DisplayName("Test getWriteAccessPredicate()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"AccessPredicate NamedViewDetail.getWriteAccessPredicate()"})
  void testGetWriteAccessPredicate() {
    // Arrange, Act and Assert
    assertNull(new NamedViewDetail().getWriteAccessPredicate());
  }

  /**
   * Test {@link NamedViewDetail#getOrDefaultReadAccessPredicate()}.
   *
   * <ul>
   *   <li>Given {@link NamedViewDetail#NamedViewDetail()}.
   * </ul>
   *
   * <p>Method under test: {@link NamedViewDetail#getOrDefaultReadAccessPredicate()}
   */
  @Test
  @DisplayName("Test getOrDefaultReadAccessPredicate(); given NamedViewDetail()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"AccessPredicate NamedViewDetail.getOrDefaultReadAccessPredicate()"})
  void testGetOrDefaultReadAccessPredicate_givenNamedViewDetail() {
    // Arrange and Act
    AccessPredicate actualOrDefaultReadAccessPredicate =
        new NamedViewDetail().getOrDefaultReadAccessPredicate();

    // Assert
    assertTrue(actualOrDefaultReadAccessPredicate instanceof UnrestrictedAccessPredicate);
    assertTrue(
        actualOrDefaultReadAccessPredicate.getUserPredicate()
            instanceof UnrestrictedAccessUserPredicate);
  }

  /**
   * Test {@link NamedViewDetail#getOrDefaultReadAccessPredicate()}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link NamedViewDetail#getOrDefaultReadAccessPredicate()}
   */
  @Test
  @DisplayName("Test getOrDefaultReadAccessPredicate(); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"AccessPredicate NamedViewDetail.getOrDefaultReadAccessPredicate()"})
  void testGetOrDefaultReadAccessPredicate_thenThrowIllegalArgumentException() {
    // Arrange
    Builder nameResult =
        new Builder()
            .creatorId("42")
            .description("The characteristics of someone or something")
            .name("Name");

    Builder parametersResult = nameResult.parameters(new HashMap<>());

    Builder writeAccessPredicateResult =
        parametersResult
            .readAccessPredicate(new AccessPredicate(mock(Predicate.class)))
            .view("View")
            .writeAccessPredicate(null);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            writeAccessPredicateResult
                .writers(new ArrayList<>())
                .build()
                .getOrDefaultReadAccessPredicate());
  }

  /**
   * Test {@link NamedViewDetail#getOrDefaultWriteAccessPredicate()}.
   *
   * <p>Method under test: {@link NamedViewDetail#getOrDefaultWriteAccessPredicate()}
   */
  @Test
  @DisplayName("Test getOrDefaultWriteAccessPredicate()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"AccessPredicate NamedViewDetail.getOrDefaultWriteAccessPredicate()"})
  void testGetOrDefaultWriteAccessPredicate() {
    // Arrange
    NamedViewDetail namedViewDetail =
        new NamedViewDetail(
            "Name", "View", "The characteristics of someone or something", new HashMap<>());

    // Act
    AccessPredicate actualOrDefaultWriteAccessPredicate =
        namedViewDetail.getOrDefaultWriteAccessPredicate();

    // Assert
    assertTrue(actualOrDefaultWriteAccessPredicate instanceof NamedViewWriteAccessPredicate);
    Predicate<User> userPredicate = actualOrDefaultWriteAccessPredicate.getUserPredicate();
    assertTrue(userPredicate instanceof NamedViewWriteUserPredicate);
    assertNull(((NamedViewWriteUserPredicate) userPredicate).getCreatingUserId());
    assertTrue(((NamedViewWriteUserPredicate) userPredicate).getAuths().isEmpty());
  }

  /**
   * Test {@link NamedViewDetail#getOrDefaultWriteAccessPredicate()}.
   *
   * <ul>
   *   <li>Given {@link NamedViewDetail#NamedViewDetail()}.
   * </ul>
   *
   * <p>Method under test: {@link NamedViewDetail#getOrDefaultWriteAccessPredicate()}
   */
  @Test
  @DisplayName("Test getOrDefaultWriteAccessPredicate(); given NamedViewDetail()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"AccessPredicate NamedViewDetail.getOrDefaultWriteAccessPredicate()"})
  void testGetOrDefaultWriteAccessPredicate_givenNamedViewDetail() {
    // Arrange and Act
    AccessPredicate actualOrDefaultWriteAccessPredicate =
        new NamedViewDetail().getOrDefaultWriteAccessPredicate();

    // Assert
    assertTrue(actualOrDefaultWriteAccessPredicate instanceof NamedViewWriteAccessPredicate);
    Predicate<User> userPredicate = actualOrDefaultWriteAccessPredicate.getUserPredicate();
    assertTrue(userPredicate instanceof NamedViewWriteUserPredicate);
    assertNull(((NamedViewWriteUserPredicate) userPredicate).getCreatingUserId());
    assertTrue(((NamedViewWriteUserPredicate) userPredicate).getAuths().isEmpty());
  }
}
