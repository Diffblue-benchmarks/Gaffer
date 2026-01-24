/*
 * Copyright 2026 Crown Copyright
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

package uk.gov.gchq.gaffer.federatedstore;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.json.JsonMapper;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Predicate;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import uk.gov.gchq.gaffer.access.ResourceType;
import uk.gov.gchq.gaffer.access.predicate.AccessPredicate;
import uk.gov.gchq.gaffer.data.elementdefinition.view.access.predicate.NamedViewWriteAccessPredicate;
import uk.gov.gchq.gaffer.federatedstore.FederatedAccess.Builder;
import uk.gov.gchq.gaffer.federatedstore.FederatedAccess.Transient;
import uk.gov.gchq.gaffer.federatedstore.access.predicate.FederatedGraphReadAccessPredicate;
import uk.gov.gchq.gaffer.federatedstore.access.predicate.FederatedGraphWriteAccessPredicate;
import uk.gov.gchq.gaffer.federatedstore.access.predicate.user.FederatedGraphReadUserPredicate;
import uk.gov.gchq.gaffer.federatedstore.access.predicate.user.FederatedGraphWriteUserPredicate;
import uk.gov.gchq.gaffer.user.User;

class FederatedAccessDiffblueTest {
  /**
   * Test Builder {@link Builder#addGraphAuths(Collection)}.
   *
   * <p>Method under test: {@link Builder#addGraphAuths(Collection)}
   */
  @Test
  @DisplayName("Test Builder addGraphAuths(Collection)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addGraphAuths(Collection)"})
  void testBuilderAddGraphAuths() {
    // Arrange
    Builder builder = new Builder();

    // Act
    Builder actualAddGraphAuthsResult = builder.addGraphAuths(new ArrayList<>());

    // Assert
    FederatedAccess federatedAccess = builder.build();
    AccessPredicate orDefaultReadAccessPredicate =
        federatedAccess.getOrDefaultReadAccessPredicate();
    assertTrue(orDefaultReadAccessPredicate instanceof FederatedGraphReadAccessPredicate);
    Predicate<User> userPredicate = orDefaultReadAccessPredicate.getUserPredicate();
    assertTrue(userPredicate instanceof FederatedGraphReadUserPredicate);
    assertTrue(((FederatedGraphReadUserPredicate) userPredicate).getAuths().isEmpty());
    assertTrue(federatedAccess.getGraphAuths().isEmpty());
    assertSame(builder, actualAddGraphAuthsResult);
  }

  /**
   * Test Builder {@link Builder#addGraphAuths(Collection)}.
   *
   * <p>Method under test: {@link Builder#addGraphAuths(Collection)}
   */
  @Test
  @DisplayName("Test Builder addGraphAuths(Collection)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addGraphAuths(Collection)"})
  void testBuilderAddGraphAuths2() {
    // Arrange
    Builder builder = new Builder();

    ArrayList<String> graphAuths = new ArrayList<>();
    graphAuths.add("foo");

    // Act
    Builder actualAddGraphAuthsResult = builder.addGraphAuths(graphAuths);

    // Assert
    FederatedAccess federatedAccess = builder.build();
    AccessPredicate orDefaultReadAccessPredicate =
        federatedAccess.getOrDefaultReadAccessPredicate();
    assertTrue(orDefaultReadAccessPredicate instanceof FederatedGraphReadAccessPredicate);
    Predicate<User> userPredicate = orDefaultReadAccessPredicate.getUserPredicate();
    assertTrue(userPredicate instanceof FederatedGraphReadUserPredicate);
    Set<String> graphAuths2 = federatedAccess.getGraphAuths();
    assertEquals(1, graphAuths2.size());
    assertTrue(graphAuths2.contains("foo"));
    assertEquals(graphAuths, ((FederatedGraphReadUserPredicate) userPredicate).getAuths());
    assertSame(builder, actualAddGraphAuthsResult);
  }

  /**
   * Test Builder {@link Builder#addGraphAuths(Collection)}.
   *
   * <ul>
   *   <li>Given array of {@link String} with {@code foo}.
   *   <li>When {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addGraphAuths(Collection)}
   */
  @Test
  @DisplayName(
      "Test Builder addGraphAuths(Collection); given array of String with 'foo'; when ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addGraphAuths(Collection)"})
  void testBuilderAddGraphAuths_givenArrayOfStringWithFoo_whenArrayList() {
    // Arrange
    Builder builder = new Builder();
    builder.graphAuths("foo");

    // Act
    builder.addGraphAuths(new ArrayList<>());

    // Assert that nothing has changed
    FederatedAccess federatedAccess = builder.build();
    AccessPredicate orDefaultReadAccessPredicate =
        federatedAccess.getOrDefaultReadAccessPredicate();
    assertTrue(orDefaultReadAccessPredicate instanceof FederatedGraphReadAccessPredicate);
    Predicate<User> userPredicate = orDefaultReadAccessPredicate.getUserPredicate();
    assertTrue(userPredicate instanceof FederatedGraphReadUserPredicate);
    List<String> auths = ((FederatedGraphReadUserPredicate) userPredicate).getAuths();
    assertEquals(1, auths.size());
    assertEquals("foo", auths.get(0));
    Set<String> graphAuths = federatedAccess.getGraphAuths();
    assertEquals(1, graphAuths.size());
    assertTrue(graphAuths.contains("foo"));
  }

  /**
   * Test Builder {@link Builder#addGraphAuths(Collection)}.
   *
   * <ul>
   *   <li>Given array of {@link String} with {@code foo}.
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addGraphAuths(Collection)}
   */
  @Test
  @DisplayName(
      "Test Builder addGraphAuths(Collection); given array of String with 'foo'; when 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addGraphAuths(Collection)"})
  void testBuilderAddGraphAuths_givenArrayOfStringWithFoo_whenNull() {
    // Arrange
    Builder builder = new Builder();
    builder.graphAuths("foo");

    // Act
    builder.addGraphAuths(null);

    // Assert that nothing has changed
    FederatedAccess federatedAccess = builder.build();
    AccessPredicate orDefaultReadAccessPredicate =
        federatedAccess.getOrDefaultReadAccessPredicate();
    assertTrue(orDefaultReadAccessPredicate instanceof FederatedGraphReadAccessPredicate);
    Predicate<User> userPredicate = orDefaultReadAccessPredicate.getUserPredicate();
    assertTrue(userPredicate instanceof FederatedGraphReadUserPredicate);
    List<String> auths = ((FederatedGraphReadUserPredicate) userPredicate).getAuths();
    assertEquals(1, auths.size());
    assertEquals("foo", auths.get(0));
    Set<String> graphAuths = federatedAccess.getGraphAuths();
    assertEquals(1, graphAuths.size());
    assertTrue(graphAuths.contains("foo"));
  }

  /**
   * Test Builder {@link Builder#addGraphAuths(Collection)}.
   *
   * <ul>
   *   <li>Given empty string.
   *   <li>When {@link ArrayList#ArrayList()} add empty string.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addGraphAuths(Collection)}
   */
  @Test
  @DisplayName(
      "Test Builder addGraphAuths(Collection); given empty string; when ArrayList() add empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addGraphAuths(Collection)"})
  void testBuilderAddGraphAuths_givenEmptyString_whenArrayListAddEmptyString() {
    // Arrange
    Builder builder = new Builder();

    ArrayList<String> graphAuths = new ArrayList<>();
    graphAuths.add("");
    graphAuths.add("foo");

    // Act
    builder.addGraphAuths(graphAuths);

    // Assert
    FederatedAccess federatedAccess = builder.build();
    AccessPredicate orDefaultReadAccessPredicate =
        federatedAccess.getOrDefaultReadAccessPredicate();
    assertTrue(orDefaultReadAccessPredicate instanceof FederatedGraphReadAccessPredicate);
    Predicate<User> userPredicate = orDefaultReadAccessPredicate.getUserPredicate();
    assertTrue(userPredicate instanceof FederatedGraphReadUserPredicate);
    List<String> auths = ((FederatedGraphReadUserPredicate) userPredicate).getAuths();
    assertEquals(1, auths.size());
    assertEquals("foo", auths.get(0));
    Set<String> graphAuths2 = federatedAccess.getGraphAuths();
    assertEquals(1, graphAuths2.size());
    assertTrue(graphAuths2.contains("foo"));
  }

  /**
   * Test Builder {@link Builder#clone(FederatedAccess)} with {@code FederatedAccess}.
   *
   * <p>Method under test: {@link Builder#clone(FederatedAccess)}
   */
  @Test
  @DisplayName("Test Builder clone(FederatedAccess) with 'FederatedAccess'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.clone(FederatedAccess)"})
  void testBuilderCloneWithFederatedAccess() {
    // Arrange
    Builder builder = new Builder();
    FederatedAccess that = new FederatedAccess(new HashSet<>(), "42");

    // Act
    Builder actualCloneResult = builder.clone(that);

    // Assert
    FederatedAccess actualFederatedAccess = builder.build();
    assertEquals(that, actualFederatedAccess);
    FederatedAccess actualFederatedAccess2 = actualCloneResult.build();
    assertEquals(that, actualFederatedAccess2);
  }

  /**
   * Test Builder {@link Builder#clone(FederatedAccess)} with {@code FederatedAccess}.
   *
   * <p>Method under test: {@link Builder#clone(FederatedAccess)}
   */
  @Test
  @DisplayName("Test Builder clone(FederatedAccess) with 'FederatedAccess'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.clone(FederatedAccess)"})
  void testBuilderCloneWithFederatedAccess2() {
    // Arrange
    Builder builder = new Builder();
    FederatedAccess that = new FederatedAccess(new HashSet<>(), "42", true);

    // Act
    Builder actualCloneResult = builder.clone(that);

    // Assert
    FederatedAccess actualFederatedAccess = builder.build();
    assertEquals(that, actualFederatedAccess);
    FederatedAccess actualFederatedAccess2 = actualCloneResult.build();
    assertEquals(that, actualFederatedAccess2);
  }

  /**
   * Test Builder {@link Builder#graphAuths(Collection)} with {@code graphAuths}.
   *
   * <p>Method under test: {@link Builder#graphAuths(Collection)}
   */
  @Test
  @DisplayName("Test Builder graphAuths(Collection) with 'graphAuths'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.graphAuths(Collection)"})
  void testBuilderGraphAuthsWithGraphAuths() {
    // Arrange
    Builder builder = new Builder();

    // Act
    Builder actualGraphAuthsResult = builder.graphAuths(new ArrayList<>());

    // Assert
    FederatedAccess federatedAccess = builder.build();
    AccessPredicate orDefaultReadAccessPredicate =
        federatedAccess.getOrDefaultReadAccessPredicate();
    assertTrue(orDefaultReadAccessPredicate instanceof FederatedGraphReadAccessPredicate);
    Predicate<User> userPredicate = orDefaultReadAccessPredicate.getUserPredicate();
    assertTrue(userPredicate instanceof FederatedGraphReadUserPredicate);
    assertTrue(((FederatedGraphReadUserPredicate) userPredicate).getAuths().isEmpty());
    assertTrue(federatedAccess.getGraphAuths().isEmpty());
    assertSame(builder, actualGraphAuthsResult);
  }

  /**
   * Test Builder {@link Builder#graphAuths(Collection)} with {@code graphAuths}.
   *
   * <p>Method under test: {@link Builder#graphAuths(Collection)}
   */
  @Test
  @DisplayName("Test Builder graphAuths(Collection) with 'graphAuths'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.graphAuths(Collection)"})
  void testBuilderGraphAuthsWithGraphAuths2() {
    // Arrange
    Builder builder = new Builder();

    // Act and Assert
    FederatedAccess federatedAccess =
        builder.graphAuths((Collection<? extends String>) null).build();
    AccessPredicate orDefaultReadAccessPredicate =
        federatedAccess.getOrDefaultReadAccessPredicate();
    assertTrue(orDefaultReadAccessPredicate instanceof FederatedGraphReadAccessPredicate);
    AccessPredicate orDefaultWriteAccessPredicate =
        federatedAccess.getOrDefaultWriteAccessPredicate();
    assertTrue(orDefaultWriteAccessPredicate instanceof FederatedGraphWriteAccessPredicate);
    assertTrue(
        orDefaultReadAccessPredicate.getUserPredicate() instanceof FederatedGraphReadUserPredicate);
    assertTrue(
        orDefaultWriteAccessPredicate.getUserPredicate()
            instanceof FederatedGraphWriteUserPredicate);
    assertNull(federatedAccess.getOwningUserId());
    assertNull(builder.build().getGraphAuths());
    assertNull(federatedAccess.getGraphAuths());
    assertNull(federatedAccess.getReadAccessPredicate());
    assertNull(federatedAccess.getWriteAccessPredicate());
    assertEquals(ResourceType.FederatedStoreGraph, federatedAccess.getResourceType());
    assertFalse(federatedAccess.isPublic());
  }

  /**
   * Test Builder {@link Builder#graphAuths(Collection)} with {@code graphAuths}.
   *
   * <p>Method under test: {@link Builder#graphAuths(Collection)}
   */
  @Test
  @DisplayName("Test Builder graphAuths(Collection) with 'graphAuths'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.graphAuths(Collection)"})
  void testBuilderGraphAuthsWithGraphAuths3() {
    // Arrange
    Builder builder = new Builder();

    ArrayList<String> graphAuths = new ArrayList<>();
    graphAuths.add("foo");

    // Act
    Builder actualGraphAuthsResult = builder.graphAuths(graphAuths);

    // Assert
    FederatedAccess federatedAccess = builder.build();
    AccessPredicate orDefaultReadAccessPredicate =
        federatedAccess.getOrDefaultReadAccessPredicate();
    assertTrue(orDefaultReadAccessPredicate instanceof FederatedGraphReadAccessPredicate);
    Predicate<User> userPredicate = orDefaultReadAccessPredicate.getUserPredicate();
    assertTrue(userPredicate instanceof FederatedGraphReadUserPredicate);
    Set<String> graphAuths2 = federatedAccess.getGraphAuths();
    assertEquals(1, graphAuths2.size());
    assertTrue(graphAuths2.contains("foo"));
    assertEquals(graphAuths, ((FederatedGraphReadUserPredicate) userPredicate).getAuths());
    assertSame(builder, actualGraphAuthsResult);
  }

  /**
   * Test Builder {@link Builder#graphAuths(Collection)} with {@code graphAuths}.
   *
   * <p>Method under test: {@link Builder#graphAuths(Collection)}
   */
  @Test
  @DisplayName("Test Builder graphAuths(Collection) with 'graphAuths'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.graphAuths(Collection)"})
  void testBuilderGraphAuthsWithGraphAuths4() {
    // Arrange
    Builder builder = new Builder();

    ArrayList<String> graphAuths = new ArrayList<>();
    graphAuths.add("");
    graphAuths.add("foo");

    // Act
    builder.graphAuths(graphAuths);

    // Assert
    FederatedAccess federatedAccess = builder.build();
    AccessPredicate orDefaultReadAccessPredicate =
        federatedAccess.getOrDefaultReadAccessPredicate();
    assertTrue(orDefaultReadAccessPredicate instanceof FederatedGraphReadAccessPredicate);
    Predicate<User> userPredicate = orDefaultReadAccessPredicate.getUserPredicate();
    assertTrue(userPredicate instanceof FederatedGraphReadUserPredicate);
    List<String> auths = ((FederatedGraphReadUserPredicate) userPredicate).getAuths();
    assertEquals(1, auths.size());
    assertEquals("foo", auths.get(0));
    Set<String> graphAuths2 = federatedAccess.getGraphAuths();
    assertEquals(1, graphAuths2.size());
    assertTrue(graphAuths2.contains("foo"));
  }

  /**
   * Test Builder {@link Builder#graphAuths(String[])} with {@code opAuth}.
   *
   * <p>Method under test: {@link Builder#graphAuths(String[])}
   */
  @Test
  @DisplayName("Test Builder graphAuths(String[]) with 'opAuth'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.graphAuths(String[])"})
  void testBuilderGraphAuthsWithOpAuth() {
    // Arrange
    Builder builder = new Builder();

    // Act and Assert
    FederatedAccess federatedAccess = builder.graphAuths((String[]) null).build();
    AccessPredicate orDefaultReadAccessPredicate =
        federatedAccess.getOrDefaultReadAccessPredicate();
    assertTrue(orDefaultReadAccessPredicate instanceof FederatedGraphReadAccessPredicate);
    AccessPredicate orDefaultWriteAccessPredicate =
        federatedAccess.getOrDefaultWriteAccessPredicate();
    assertTrue(orDefaultWriteAccessPredicate instanceof FederatedGraphWriteAccessPredicate);
    assertTrue(
        orDefaultReadAccessPredicate.getUserPredicate() instanceof FederatedGraphReadUserPredicate);
    assertTrue(
        orDefaultWriteAccessPredicate.getUserPredicate()
            instanceof FederatedGraphWriteUserPredicate);
    assertNull(federatedAccess.getOwningUserId());
    assertNull(builder.build().getGraphAuths());
    assertNull(federatedAccess.getGraphAuths());
    assertNull(federatedAccess.getReadAccessPredicate());
    assertNull(federatedAccess.getWriteAccessPredicate());
    assertEquals(ResourceType.FederatedStoreGraph, federatedAccess.getResourceType());
    assertFalse(federatedAccess.isPublic());
  }

  /**
   * Test Builder new {@link Builder} (default constructor).
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link Builder}
   *   <li>{@link Builder#owningUserId(String)}
   *   <li>{@link Builder#readAccessPredicate(AccessPredicate)}
   *   <li>{@link Builder#writeAccessPredicate(AccessPredicate)}
   * </ul>
   */
  @Test
  @DisplayName("Test Builder new Builder (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "FederatedAccess Builder.build()",
    "Builder Builder.isPublic(boolean)",
    "Builder Builder.makePrivate()",
    "Builder Builder.makePublic()",
    "Builder Builder.owningUserId(String)",
    "Builder Builder.readAccessPredicate(AccessPredicate)",
    "Builder Builder.writeAccessPredicate(AccessPredicate)"
  })
  void testBuilderNewBuilder() {
    // Arrange and Act
    Builder actualBuilder = new Builder();
    Builder actualOwningUserIdResult =
        actualBuilder
            .graphAuths(new ArrayList<>())
            .graphAuths("Op Auth")
            .owningUserId("Owning User");
    Builder actualReadAccessPredicateResult =
        actualOwningUserIdResult.readAccessPredicate(new AccessPredicate(mock(Predicate.class)));
    Builder actualWriteAccessPredicateResult =
        actualReadAccessPredicateResult.writeAccessPredicate(
            new AccessPredicate(mock(Predicate.class)));

    // Assert
    assertSame(actualReadAccessPredicateResult, actualWriteAccessPredicateResult);
  }

  /**
   * Test {@link FederatedAccess#FederatedAccess(Set, String)}.
   *
   * <p>Method under test: {@link FederatedAccess#FederatedAccess(Set, String)}
   */
  @Test
  @DisplayName("Test new FederatedAccess(Set, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void FederatedAccess.<init>(Set, String)"})
  void testNewFederatedAccess() {
    // Arrange
    HashSet<String> graphAuths = new HashSet<>();
    graphAuths.add("42");
    graphAuths.add("foo");

    // Act and Assert
    AccessPredicate orDefaultReadAccessPredicate =
        new FederatedAccess(graphAuths, "42").getOrDefaultReadAccessPredicate();
    assertTrue(orDefaultReadAccessPredicate instanceof FederatedGraphReadAccessPredicate);
    Predicate<User> userPredicate = orDefaultReadAccessPredicate.getUserPredicate();
    assertTrue(userPredicate instanceof FederatedGraphReadUserPredicate);
    List<String> auths = ((FederatedGraphReadUserPredicate) userPredicate).getAuths();
    assertEquals(2, auths.size());
    assertEquals("42", auths.get(0));
    assertEquals("foo", auths.get(1));
  }

  /**
   * Test {@link FederatedAccess#FederatedAccess(Set, String, boolean)}.
   *
   * <p>Method under test: {@link FederatedAccess#FederatedAccess(Set, String, boolean)}
   */
  @Test
  @DisplayName("Test new FederatedAccess(Set, String, boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void FederatedAccess.<init>(Set, String, boolean)"})
  void testNewFederatedAccess2() {
    // Arrange
    HashSet<String> graphAuths = new HashSet<>();
    graphAuths.add("42");
    graphAuths.add("foo");

    // Act
    FederatedAccess actualFederatedAccess = new FederatedAccess(graphAuths, "42", true);

    // Assert
    AccessPredicate orDefaultReadAccessPredicate =
        actualFederatedAccess.getOrDefaultReadAccessPredicate();
    assertTrue(orDefaultReadAccessPredicate instanceof FederatedGraphReadAccessPredicate);
    Predicate<User> userPredicate = orDefaultReadAccessPredicate.getUserPredicate();
    assertTrue(userPredicate instanceof FederatedGraphReadUserPredicate);
    List<String> auths = ((FederatedGraphReadUserPredicate) userPredicate).getAuths();
    assertEquals(2, auths.size());
    assertEquals("42", auths.get(0));
    assertEquals("foo", auths.get(1));
  }

  /**
   * Test {@link FederatedAccess#FederatedAccess(Set, String, boolean, AccessPredicate,
   * AccessPredicate)}.
   *
   * <p>Method under test: {@link FederatedAccess#FederatedAccess(Set, String, boolean,
   * AccessPredicate, AccessPredicate)}
   */
  @Test
  @DisplayName("Test new FederatedAccess(Set, String, boolean, AccessPredicate, AccessPredicate)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void FederatedAccess.<init>(Set, String, boolean, AccessPredicate, AccessPredicate)"
  })
  void testNewFederatedAccess3() {
    // Arrange
    HashSet<String> graphAuths = new HashSet<>();
    AccessPredicate writeAccessPredicate = new AccessPredicate(mock(Predicate.class));

    // Act
    FederatedAccess actualFederatedAccess =
        new FederatedAccess(graphAuths, "42", true, null, writeAccessPredicate);

    // Assert
    AccessPredicate orDefaultReadAccessPredicate =
        actualFederatedAccess.getOrDefaultReadAccessPredicate();
    assertTrue(orDefaultReadAccessPredicate instanceof FederatedGraphReadAccessPredicate);
    Predicate<User> userPredicate = orDefaultReadAccessPredicate.getUserPredicate();
    assertTrue(userPredicate instanceof FederatedGraphReadUserPredicate);
    assertEquals("42", ((FederatedGraphReadUserPredicate) userPredicate).getCreatingUserId());
    assertNull(actualFederatedAccess.getReadAccessPredicate());
    assertTrue(((FederatedGraphReadUserPredicate) userPredicate).getAuths().isEmpty());
    assertTrue(actualFederatedAccess.getGraphAuths().isEmpty());
    assertTrue(((FederatedGraphReadUserPredicate) userPredicate).isPublic());
  }

  /**
   * Test {@link FederatedAccess#FederatedAccess(Set, String, boolean, AccessPredicate,
   * AccessPredicate)}.
   *
   * <p>Method under test: {@link FederatedAccess#FederatedAccess(Set, String, boolean,
   * AccessPredicate, AccessPredicate)}
   */
  @Test
  @DisplayName("Test new FederatedAccess(Set, String, boolean, AccessPredicate, AccessPredicate)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void FederatedAccess.<init>(Set, String, boolean, AccessPredicate, AccessPredicate)"
  })
  void testNewFederatedAccess4() {
    // Arrange
    HashSet<String> graphAuths = new HashSet<>();
    graphAuths.add("Only one of graphAuths or readAccessPredicate should be supplied.");
    AccessPredicate readAccessPredicate = new AccessPredicate(mock(Predicate.class));
    AccessPredicate writeAccessPredicate = new AccessPredicate(mock(Predicate.class));

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            new FederatedAccess(graphAuths, "42", true, readAccessPredicate, writeAccessPredicate));
  }

  /**
   * Test {@link FederatedAccess#FederatedAccess(Set, String, boolean, AccessPredicate,
   * AccessPredicate)}.
   *
   * <ul>
   *   <li>Given {@code foo}.
   *   <li>When {@link HashSet#HashSet()} add {@code foo}.
   * </ul>
   *
   * <p>Method under test: {@link FederatedAccess#FederatedAccess(Set, String, boolean,
   * AccessPredicate, AccessPredicate)}
   */
  @Test
  @DisplayName(
      "Test new FederatedAccess(Set, String, boolean, AccessPredicate, AccessPredicate); given 'foo'; when HashSet() add 'foo'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void FederatedAccess.<init>(Set, String, boolean, AccessPredicate, AccessPredicate)"
  })
  void testNewFederatedAccess_givenFoo_whenHashSetAddFoo() {
    // Arrange
    HashSet<String> graphAuths = new HashSet<>();
    graphAuths.add("foo");
    graphAuths.add("Only one of graphAuths or readAccessPredicate should be supplied.");
    AccessPredicate readAccessPredicate = new AccessPredicate(mock(Predicate.class));
    AccessPredicate writeAccessPredicate = new AccessPredicate(mock(Predicate.class));

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            new FederatedAccess(graphAuths, "42", true, readAccessPredicate, writeAccessPredicate));
  }

  /**
   * Test {@link FederatedAccess#FederatedAccess(Set, String)}.
   *
   * <ul>
   *   <li>Given {@code foo}.
   *   <li>When {@link HashSet#HashSet()} add {@code foo}.
   *   <li>Then return GraphAuths is {@link HashSet#HashSet()}.
   * </ul>
   *
   * <p>Method under test: {@link FederatedAccess#FederatedAccess(Set, String)}
   */
  @Test
  @DisplayName(
      "Test new FederatedAccess(Set, String); given 'foo'; when HashSet() add 'foo'; then return GraphAuths is HashSet()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void FederatedAccess.<init>(Set, String)"})
  void testNewFederatedAccess_givenFoo_whenHashSetAddFoo_thenReturnGraphAuthsIsHashSet() {
    // Arrange
    HashSet<String> graphAuths = new HashSet<>();
    graphAuths.add("foo");

    // Act
    FederatedAccess actualFederatedAccess = new FederatedAccess(graphAuths, "42");

    // Assert
    AccessPredicate orDefaultWriteAccessPredicate =
        actualFederatedAccess.getOrDefaultWriteAccessPredicate();
    assertTrue(orDefaultWriteAccessPredicate instanceof FederatedGraphWriteAccessPredicate);
    assertTrue(
        orDefaultWriteAccessPredicate.getUserPredicate()
            instanceof FederatedGraphWriteUserPredicate);
    assertEquals("42", actualFederatedAccess.getOwningUserId());
    assertNull(actualFederatedAccess.getReadAccessPredicate());
    assertNull(actualFederatedAccess.getWriteAccessPredicate());
    assertEquals(ResourceType.FederatedStoreGraph, actualFederatedAccess.getResourceType());
    assertFalse(actualFederatedAccess.isPublic());
    assertEquals(graphAuths, actualFederatedAccess.getGraphAuths());
  }

  /**
   * Test {@link FederatedAccess#FederatedAccess(Set, String, boolean)}.
   *
   * <ul>
   *   <li>Given {@code foo}.
   *   <li>When {@link HashSet#HashSet()} add {@code foo}.
   *   <li>Then return GraphAuths is {@link HashSet#HashSet()}.
   * </ul>
   *
   * <p>Method under test: {@link FederatedAccess#FederatedAccess(Set, String, boolean)}
   */
  @Test
  @DisplayName(
      "Test new FederatedAccess(Set, String, boolean); given 'foo'; when HashSet() add 'foo'; then return GraphAuths is HashSet()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void FederatedAccess.<init>(Set, String, boolean)"})
  void testNewFederatedAccess_givenFoo_whenHashSetAddFoo_thenReturnGraphAuthsIsHashSet2() {
    // Arrange
    HashSet<String> graphAuths = new HashSet<>();
    graphAuths.add("foo");

    // Act
    FederatedAccess actualFederatedAccess = new FederatedAccess(graphAuths, "42", true);

    // Assert
    AccessPredicate orDefaultWriteAccessPredicate =
        actualFederatedAccess.getOrDefaultWriteAccessPredicate();
    assertTrue(orDefaultWriteAccessPredicate instanceof FederatedGraphWriteAccessPredicate);
    assertTrue(
        orDefaultWriteAccessPredicate.getUserPredicate()
            instanceof FederatedGraphWriteUserPredicate);
    assertEquals("42", actualFederatedAccess.getOwningUserId());
    assertNull(actualFederatedAccess.getReadAccessPredicate());
    assertNull(actualFederatedAccess.getWriteAccessPredicate());
    assertEquals(ResourceType.FederatedStoreGraph, actualFederatedAccess.getResourceType());
    assertTrue(actualFederatedAccess.isPublic());
    assertEquals(graphAuths, actualFederatedAccess.getGraphAuths());
  }

  /**
   * Test {@link FederatedAccess#FederatedAccess(Set, String)}.
   *
   * <ul>
   *   <li>When {@link HashSet#HashSet()}.
   *   <li>Then return GraphAuths Empty.
   * </ul>
   *
   * <p>Method under test: {@link FederatedAccess#FederatedAccess(Set, String)}
   */
  @Test
  @DisplayName(
      "Test new FederatedAccess(Set, String); when HashSet(); then return GraphAuths Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void FederatedAccess.<init>(Set, String)"})
  void testNewFederatedAccess_whenHashSet_thenReturnGraphAuthsEmpty() {
    // Arrange and Act
    FederatedAccess actualFederatedAccess = new FederatedAccess(new HashSet<>(), "42");

    // Assert
    AccessPredicate orDefaultWriteAccessPredicate =
        actualFederatedAccess.getOrDefaultWriteAccessPredicate();
    assertTrue(orDefaultWriteAccessPredicate instanceof FederatedGraphWriteAccessPredicate);
    assertTrue(
        orDefaultWriteAccessPredicate.getUserPredicate()
            instanceof FederatedGraphWriteUserPredicate);
    assertEquals("42", actualFederatedAccess.getOwningUserId());
    assertNull(actualFederatedAccess.getReadAccessPredicate());
    assertNull(actualFederatedAccess.getWriteAccessPredicate());
    assertEquals(ResourceType.FederatedStoreGraph, actualFederatedAccess.getResourceType());
    assertFalse(actualFederatedAccess.isPublic());
    assertTrue(actualFederatedAccess.getGraphAuths().isEmpty());
  }

  /**
   * Test {@link FederatedAccess#FederatedAccess(Set, String, boolean)}.
   *
   * <ul>
   *   <li>When {@link HashSet#HashSet()}.
   *   <li>Then return GraphAuths Empty.
   * </ul>
   *
   * <p>Method under test: {@link FederatedAccess#FederatedAccess(Set, String, boolean)}
   */
  @Test
  @DisplayName(
      "Test new FederatedAccess(Set, String, boolean); when HashSet(); then return GraphAuths Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void FederatedAccess.<init>(Set, String, boolean)"})
  void testNewFederatedAccess_whenHashSet_thenReturnGraphAuthsEmpty2() {
    // Arrange and Act
    FederatedAccess actualFederatedAccess = new FederatedAccess(new HashSet<>(), "42", true);

    // Assert
    AccessPredicate orDefaultWriteAccessPredicate =
        actualFederatedAccess.getOrDefaultWriteAccessPredicate();
    assertTrue(orDefaultWriteAccessPredicate instanceof FederatedGraphWriteAccessPredicate);
    assertTrue(
        orDefaultWriteAccessPredicate.getUserPredicate()
            instanceof FederatedGraphWriteUserPredicate);
    assertEquals("42", actualFederatedAccess.getOwningUserId());
    assertNull(actualFederatedAccess.getReadAccessPredicate());
    assertNull(actualFederatedAccess.getWriteAccessPredicate());
    assertEquals(ResourceType.FederatedStoreGraph, actualFederatedAccess.getResourceType());
    assertTrue(actualFederatedAccess.getGraphAuths().isEmpty());
    assertTrue(actualFederatedAccess.isPublic());
  }

  /**
   * Test {@link FederatedAccess#FederatedAccess(Set, String, boolean, AccessPredicate,
   * AccessPredicate)}.
   *
   * <ul>
   *   <li>When {@link HashSet#HashSet()}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link FederatedAccess#FederatedAccess(Set, String, boolean,
   * AccessPredicate, AccessPredicate)}
   */
  @Test
  @DisplayName(
      "Test new FederatedAccess(Set, String, boolean, AccessPredicate, AccessPredicate); when HashSet(); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void FederatedAccess.<init>(Set, String, boolean, AccessPredicate, AccessPredicate)"
  })
  void testNewFederatedAccess_whenHashSet_thenThrowIllegalArgumentException() {
    // Arrange
    HashSet<String> graphAuths = new HashSet<>();
    AccessPredicate readAccessPredicate = new AccessPredicate(mock(Predicate.class));
    AccessPredicate writeAccessPredicate = new AccessPredicate(mock(Predicate.class));

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            new FederatedAccess(graphAuths, "42", true, readAccessPredicate, writeAccessPredicate));
  }

  /**
   * Test {@link FederatedAccess#FederatedAccess(Set, String)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return GraphAuths is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link FederatedAccess#FederatedAccess(Set, String)}
   */
  @Test
  @DisplayName(
      "Test new FederatedAccess(Set, String); when 'null'; then return GraphAuths is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void FederatedAccess.<init>(Set, String)"})
  void testNewFederatedAccess_whenNull_thenReturnGraphAuthsIsNull() {
    // Arrange and Act
    FederatedAccess actualFederatedAccess = new FederatedAccess(null, "42");

    // Assert
    AccessPredicate orDefaultWriteAccessPredicate =
        actualFederatedAccess.getOrDefaultWriteAccessPredicate();
    assertTrue(orDefaultWriteAccessPredicate instanceof FederatedGraphWriteAccessPredicate);
    assertTrue(
        orDefaultWriteAccessPredicate.getUserPredicate()
            instanceof FederatedGraphWriteUserPredicate);
    assertEquals("42", actualFederatedAccess.getOwningUserId());
    assertNull(actualFederatedAccess.getGraphAuths());
    assertNull(actualFederatedAccess.getReadAccessPredicate());
    assertNull(actualFederatedAccess.getWriteAccessPredicate());
    assertEquals(ResourceType.FederatedStoreGraph, actualFederatedAccess.getResourceType());
    assertFalse(actualFederatedAccess.isPublic());
  }

  /**
   * Test {@link FederatedAccess#FederatedAccess(Set, String, boolean)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return GraphAuths is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link FederatedAccess#FederatedAccess(Set, String, boolean)}
   */
  @Test
  @DisplayName(
      "Test new FederatedAccess(Set, String, boolean); when 'null'; then return GraphAuths is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void FederatedAccess.<init>(Set, String, boolean)"})
  void testNewFederatedAccess_whenNull_thenReturnGraphAuthsIsNull2() {
    // Arrange and Act
    FederatedAccess actualFederatedAccess = new FederatedAccess(null, "42", true);

    // Assert
    AccessPredicate orDefaultWriteAccessPredicate =
        actualFederatedAccess.getOrDefaultWriteAccessPredicate();
    assertTrue(orDefaultWriteAccessPredicate instanceof FederatedGraphWriteAccessPredicate);
    assertTrue(
        orDefaultWriteAccessPredicate.getUserPredicate()
            instanceof FederatedGraphWriteUserPredicate);
    assertEquals("42", actualFederatedAccess.getOwningUserId());
    assertNull(actualFederatedAccess.getGraphAuths());
    assertNull(actualFederatedAccess.getReadAccessPredicate());
    assertNull(actualFederatedAccess.getWriteAccessPredicate());
    assertEquals(ResourceType.FederatedStoreGraph, actualFederatedAccess.getResourceType());
    assertTrue(actualFederatedAccess.isPublic());
  }

  /**
   * Test {@link FederatedAccess#FederatedAccess(Set, String, boolean, AccessPredicate,
   * AccessPredicate)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return OwningUserId is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link FederatedAccess#FederatedAccess(Set, String, boolean,
   * AccessPredicate, AccessPredicate)}
   */
  @Test
  @DisplayName(
      "Test new FederatedAccess(Set, String, boolean, AccessPredicate, AccessPredicate); when 'null'; then return OwningUserId is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void FederatedAccess.<init>(Set, String, boolean, AccessPredicate, AccessPredicate)"
  })
  void testNewFederatedAccess_whenNull_thenReturnOwningUserIdIs42() {
    // Arrange
    AccessPredicate readAccessPredicate = new AccessPredicate(mock(Predicate.class));
    AccessPredicate writeAccessPredicate = new AccessPredicate(mock(Predicate.class));

    // Act
    FederatedAccess actualFederatedAccess =
        new FederatedAccess(null, "42", true, readAccessPredicate, writeAccessPredicate);

    // Assert
    assertEquals("42", actualFederatedAccess.getOwningUserId());
    assertNull(actualFederatedAccess.getGraphAuths());
    assertEquals(ResourceType.FederatedStoreGraph, actualFederatedAccess.getResourceType());
    assertTrue(actualFederatedAccess.isPublic());
    assertEquals(readAccessPredicate, actualFederatedAccess.getOrDefaultReadAccessPredicate());
    assertEquals(writeAccessPredicate, actualFederatedAccess.getOrDefaultWriteAccessPredicate());
    assertEquals(readAccessPredicate, actualFederatedAccess.getReadAccessPredicate());
    assertEquals(writeAccessPredicate, actualFederatedAccess.getWriteAccessPredicate());
  }

  /**
   * Test {@link FederatedAccess#getGraphAuths()}.
   *
   * <p>Method under test: {@link FederatedAccess#getGraphAuths()}
   */
  @Test
  @DisplayName("Test getGraphAuths()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set FederatedAccess.getGraphAuths()"})
  void testGetGraphAuths() {
    // Arrange, Act and Assert
    assertTrue(new FederatedAccess(new HashSet<>(), "42").getGraphAuths().isEmpty());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link FederatedAccess#toString()}
   *   <li>{@link FederatedAccess#getOwningUserId()}
   *   <li>{@link FederatedAccess#getResourceType()}
   *   <li>{@link FederatedAccess#isPublic()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String FederatedAccess.getOwningUserId()",
    "ResourceType FederatedAccess.getResourceType()",
    "boolean FederatedAccess.isPublic()",
    "String FederatedAccess.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    FederatedAccess federatedAccess = new FederatedAccess(new HashSet<>(), "42");

    // Act
    federatedAccess.toString();
    String actualOwningUserId = federatedAccess.getOwningUserId();
    ResourceType actualResourceType = federatedAccess.getResourceType();

    // Assert
    assertEquals("42", actualOwningUserId);
    assertEquals(ResourceType.FederatedStoreGraph, actualResourceType);
    assertFalse(federatedAccess.isPublic());
  }

  /**
   * Test {@link FederatedAccess#hasReadAccess(User, String)} with {@code user}, {@code adminAuth}.
   *
   * <p>Method under test: {@link FederatedAccess#hasReadAccess(User, String)}
   */
  @Test
  @DisplayName("Test hasReadAccess(User, String) with 'user', 'adminAuth'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean FederatedAccess.hasReadAccess(User, String)"})
  void testHasReadAccessWithUserAdminAuth() {
    // Arrange
    FederatedAccess federatedAccess = new FederatedAccess(new HashSet<>(), "42");

    // Act and Assert
    assertFalse(federatedAccess.hasReadAccess(new User(), "Admin Auth"));
  }

  /**
   * Test {@link FederatedAccess#hasReadAccess(User, String)} with {@code user}, {@code adminAuth}.
   *
   * <p>Method under test: {@link FederatedAccess#hasReadAccess(User, String)}
   */
  @Test
  @DisplayName("Test hasReadAccess(User, String) with 'user', 'adminAuth'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean FederatedAccess.hasReadAccess(User, String)"})
  void testHasReadAccessWithUserAdminAuth2() {
    // Arrange
    FederatedAccess federatedAccess = new FederatedAccess(new HashSet<>(), "UNKNOWN");

    // Act and Assert
    assertTrue(federatedAccess.hasReadAccess(new User(), "Admin Auth"));
  }

  /**
   * Test {@link FederatedAccess#hasReadAccess(User, String)} with {@code user}, {@code adminAuth}.
   *
   * <p>Method under test: {@link FederatedAccess#hasReadAccess(User, String)}
   */
  @Test
  @DisplayName("Test hasReadAccess(User, String) with 'user', 'adminAuth'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean FederatedAccess.hasReadAccess(User, String)"})
  void testHasReadAccessWithUserAdminAuth3() {
    // Arrange
    FederatedAccess federatedAccess = new FederatedAccess(new HashSet<>(), null);

    // Act and Assert
    assertFalse(federatedAccess.hasReadAccess(new User(), "Admin Auth"));
  }

  /**
   * Test {@link FederatedAccess#hasReadAccess(User, String)} with {@code user}, {@code adminAuth}.
   *
   * <p>Method under test: {@link FederatedAccess#hasReadAccess(User, String)}
   */
  @Test
  @DisplayName("Test hasReadAccess(User, String) with 'user', 'adminAuth'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean FederatedAccess.hasReadAccess(User, String)"})
  void testHasReadAccessWithUserAdminAuth4() {
    // Arrange
    FederatedAccess federatedAccess = new FederatedAccess(new HashSet<>(), "42", true);

    // Act and Assert
    assertTrue(federatedAccess.hasReadAccess(new User(), "Admin Auth"));
  }

  /**
   * Test {@link FederatedAccess#hasReadAccess(User, String)} with {@code user}, {@code adminAuth}.
   *
   * <ul>
   *   <li>When empty string.
   * </ul>
   *
   * <p>Method under test: {@link FederatedAccess#hasReadAccess(User, String)}
   */
  @Test
  @DisplayName("Test hasReadAccess(User, String) with 'user', 'adminAuth'; when empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean FederatedAccess.hasReadAccess(User, String)"})
  void testHasReadAccessWithUserAdminAuth_whenEmptyString() {
    // Arrange
    FederatedAccess federatedAccess = new FederatedAccess(new HashSet<>(), "42");

    // Act and Assert
    assertFalse(federatedAccess.hasReadAccess(new User(), ""));
  }

  /**
   * Test {@link FederatedAccess#hasReadAccess(User, String)} with {@code user}, {@code adminAuth}.
   *
   * <ul>
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link FederatedAccess#hasReadAccess(User, String)}
   */
  @Test
  @DisplayName("Test hasReadAccess(User, String) with 'user', 'adminAuth'; when 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean FederatedAccess.hasReadAccess(User, String)"})
  void testHasReadAccessWithUserAdminAuth_whenNull() {
    // Arrange
    FederatedAccess federatedAccess = new FederatedAccess(new HashSet<>(), "42");

    // Act and Assert
    assertFalse(federatedAccess.hasReadAccess(new User(), null));
  }

  /**
   * Test {@link FederatedAccess#hasReadAccess(User, String)} with {@code user}, {@code adminAuth}.
   *
   * <ul>
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link FederatedAccess#hasReadAccess(User, String)}
   */
  @Test
  @DisplayName("Test hasReadAccess(User, String) with 'user', 'adminAuth'; when 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean FederatedAccess.hasReadAccess(User, String)"})
  void testHasReadAccessWithUserAdminAuth_whenNull2() {
    // Arrange, Act and Assert
    assertFalse(new FederatedAccess(new HashSet<>(), "42").hasReadAccess(null, "Admin Auth"));
  }

  /**
   * Test {@link FederatedAccess#hasWriteAccess(User, String)} with {@code user}, {@code adminAuth}.
   *
   * <p>Method under test: {@link FederatedAccess#hasWriteAccess(User, String)}
   */
  @Test
  @DisplayName("Test hasWriteAccess(User, String) with 'user', 'adminAuth'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean FederatedAccess.hasWriteAccess(User, String)"})
  void testHasWriteAccessWithUserAdminAuth() {
    // Arrange
    FederatedAccess federatedAccess = new FederatedAccess(new HashSet<>(), "42");

    // Act and Assert
    assertFalse(federatedAccess.hasWriteAccess(new User(), "Admin Auth"));
  }

  /**
   * Test {@link FederatedAccess#hasWriteAccess(User, String)} with {@code user}, {@code adminAuth}.
   *
   * <p>Method under test: {@link FederatedAccess#hasWriteAccess(User, String)}
   */
  @Test
  @DisplayName("Test hasWriteAccess(User, String) with 'user', 'adminAuth'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean FederatedAccess.hasWriteAccess(User, String)"})
  void testHasWriteAccessWithUserAdminAuth2() {
    // Arrange
    FederatedAccess federatedAccess = new FederatedAccess(new HashSet<>(), "UNKNOWN");

    // Act and Assert
    assertTrue(federatedAccess.hasWriteAccess(new User(), "Admin Auth"));
  }

  /**
   * Test {@link FederatedAccess#hasWriteAccess(User, String)} with {@code user}, {@code adminAuth}.
   *
   * <p>Method under test: {@link FederatedAccess#hasWriteAccess(User, String)}
   */
  @Test
  @DisplayName("Test hasWriteAccess(User, String) with 'user', 'adminAuth'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean FederatedAccess.hasWriteAccess(User, String)"})
  void testHasWriteAccessWithUserAdminAuth3() {
    // Arrange
    FederatedAccess federatedAccess = new FederatedAccess(new HashSet<>(), null);

    // Act and Assert
    assertFalse(federatedAccess.hasWriteAccess(new User(), "Admin Auth"));
  }

  /**
   * Test {@link FederatedAccess#hasWriteAccess(User, String)} with {@code user}, {@code adminAuth}.
   *
   * <p>Method under test: {@link FederatedAccess#hasWriteAccess(User, String)}
   */
  @Test
  @DisplayName("Test hasWriteAccess(User, String) with 'user', 'adminAuth'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean FederatedAccess.hasWriteAccess(User, String)"})
  void testHasWriteAccessWithUserAdminAuth4() {
    // Arrange
    Builder builder = new Builder();

    Builder readAccessPredicateResult =
        builder.graphAuths(new ArrayList<>()).owningUserId("Owning User").readAccessPredicate(null);
    AccessPredicate writeAccessPredicate = new AccessPredicate("42", new ArrayList<>());
    FederatedAccess federatedAccess =
        readAccessPredicateResult.writeAccessPredicate(writeAccessPredicate).build();

    // Act and Assert
    assertTrue(
        federatedAccess.hasWriteAccess(new User.Builder().userId("42").build(), "Admin Auth"));
  }

  /**
   * Test {@link FederatedAccess#hasWriteAccess(User, String)} with {@code user}, {@code adminAuth}.
   *
   * <p>Method under test: {@link FederatedAccess#hasWriteAccess(User, String)}
   */
  @Test
  @DisplayName("Test hasWriteAccess(User, String) with 'user', 'adminAuth'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean FederatedAccess.hasWriteAccess(User, String)"})
  void testHasWriteAccessWithUserAdminAuth5() {
    // Arrange
    Builder builder = new Builder();

    Builder readAccessPredicateResult =
        builder.graphAuths(new ArrayList<>()).owningUserId("Owning User").readAccessPredicate(null);
    FederatedGraphReadAccessPredicate writeAccessPredicate =
        new FederatedGraphReadAccessPredicate("42", new ArrayList<>(), true);
    FederatedAccess federatedAccess =
        readAccessPredicateResult.writeAccessPredicate(writeAccessPredicate).build();

    // Act and Assert
    assertTrue(
        federatedAccess.hasWriteAccess(new User.Builder().userId("42").build(), "Admin Auth"));
  }

  /**
   * Test {@link FederatedAccess#hasWriteAccess(User, String)} with {@code user}, {@code adminAuth}.
   *
   * <p>Method under test: {@link FederatedAccess#hasWriteAccess(User, String)}
   */
  @Test
  @DisplayName("Test hasWriteAccess(User, String) with 'user', 'adminAuth'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean FederatedAccess.hasWriteAccess(User, String)"})
  void testHasWriteAccessWithUserAdminAuth6() {
    // Arrange
    Builder builder = new Builder();

    Builder readAccessPredicateResult =
        builder.graphAuths(new ArrayList<>()).owningUserId("Owning User").readAccessPredicate(null);
    NamedViewWriteAccessPredicate writeAccessPredicate =
        new NamedViewWriteAccessPredicate("42", new ArrayList<>());
    FederatedAccess federatedAccess =
        readAccessPredicateResult.writeAccessPredicate(writeAccessPredicate).build();

    // Act and Assert
    assertTrue(
        federatedAccess.hasWriteAccess(new User.Builder().userId("42").build(), "Admin Auth"));
  }

  /**
   * Test {@link FederatedAccess#hasWriteAccess(User, String)} with {@code user}, {@code adminAuth}.
   *
   * <p>Method under test: {@link FederatedAccess#hasWriteAccess(User, String)}
   */
  @Test
  @DisplayName("Test hasWriteAccess(User, String) with 'user', 'adminAuth'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean FederatedAccess.hasWriteAccess(User, String)"})
  void testHasWriteAccessWithUserAdminAuth7() {
    // Arrange
    Builder builder = new Builder();

    Builder readAccessPredicateResult =
        builder.graphAuths(new ArrayList<>()).owningUserId("Owning User").readAccessPredicate(null);
    AccessPredicate writeAccessPredicate =
        new AccessPredicate("Creating User Id", new ArrayList<>());
    FederatedAccess federatedAccess =
        readAccessPredicateResult.writeAccessPredicate(writeAccessPredicate).build();

    // Act and Assert
    assertFalse(
        federatedAccess.hasWriteAccess(new User.Builder().userId("42").build(), "Admin Auth"));
  }

  /**
   * Test {@link FederatedAccess#hasWriteAccess(User, String)} with {@code user}, {@code adminAuth}.
   *
   * <p>Method under test: {@link FederatedAccess#hasWriteAccess(User, String)}
   */
  @Test
  @DisplayName("Test hasWriteAccess(User, String) with 'user', 'adminAuth'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean FederatedAccess.hasWriteAccess(User, String)"})
  void testHasWriteAccessWithUserAdminAuth8() {
    // Arrange
    Builder builder = new Builder();

    Builder readAccessPredicateResult =
        builder.graphAuths(new ArrayList<>()).owningUserId("Owning User").readAccessPredicate(null);
    FederatedGraphReadAccessPredicate writeAccessPredicate =
        new FederatedGraphReadAccessPredicate("42", new ArrayList<>(), false);
    FederatedAccess federatedAccess =
        readAccessPredicateResult.writeAccessPredicate(writeAccessPredicate).build();

    // Act and Assert
    assertTrue(
        federatedAccess.hasWriteAccess(new User.Builder().userId("42").build(), "Admin Auth"));
  }

  /**
   * Test {@link FederatedAccess#hasWriteAccess(User, String)} with {@code user}, {@code adminAuth}.
   *
   * <p>Method under test: {@link FederatedAccess#hasWriteAccess(User, String)}
   */
  @Test
  @DisplayName("Test hasWriteAccess(User, String) with 'user', 'adminAuth'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean FederatedAccess.hasWriteAccess(User, String)"})
  void testHasWriteAccessWithUserAdminAuth9() {
    // Arrange
    Builder builder = new Builder();

    Builder readAccessPredicateResult =
        builder.graphAuths(new ArrayList<>()).owningUserId("Owning User").readAccessPredicate(null);
    FederatedGraphReadAccessPredicate writeAccessPredicate =
        new FederatedGraphReadAccessPredicate("Creating User Id", new ArrayList<>(), false);
    FederatedAccess federatedAccess =
        readAccessPredicateResult.writeAccessPredicate(writeAccessPredicate).build();

    // Act and Assert
    assertFalse(
        federatedAccess.hasWriteAccess(new User.Builder().userId("42").build(), "Admin Auth"));
  }

  /**
   * Test {@link FederatedAccess#hasWriteAccess(User, String)} with {@code user}, {@code adminAuth}.
   *
   * <ul>
   *   <li>Given {@link Predicate} {@link Predicate#test(Object)} return {@code true}.
   *   <li>Then calls {@link Predicate#test(Object)}.
   * </ul>
   *
   * <p>Method under test: {@link FederatedAccess#hasWriteAccess(User, String)}
   */
  @Test
  @DisplayName(
      "Test hasWriteAccess(User, String) with 'user', 'adminAuth'; given Predicate test(Object) return 'true'; then calls test(Object)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean FederatedAccess.hasWriteAccess(User, String)"})
  void testHasWriteAccessWithUserAdminAuth_givenPredicateTestReturnTrue_thenCallsTest() {
    // Arrange
    Predicate<User> userPredicate = mock(Predicate.class);
    when(userPredicate.test(Mockito.<User>any())).thenReturn(true);
    AccessPredicate writeAccessPredicate = new AccessPredicate(userPredicate);

    Builder builder = new Builder();
    FederatedAccess federatedAccess =
        builder
            .graphAuths(new ArrayList<>())
            .owningUserId("Owning User")
            .readAccessPredicate(null)
            .writeAccessPredicate(writeAccessPredicate)
            .build();

    // Act
    boolean actualHasWriteAccessResult =
        federatedAccess.hasWriteAccess(new User.Builder().userId("42").build(), "Admin Auth");

    // Assert
    verify(userPredicate).test(isA(User.class));
    assertTrue(actualHasWriteAccessResult);
  }

  /**
   * Test {@link FederatedAccess#hasWriteAccess(User, String)} with {@code user}, {@code adminAuth}.
   *
   * <ul>
   *   <li>Given {@link Predicate} {@link Predicate#test(Object)} return {@code true}.
   *   <li>Then calls {@link Predicate#test(Object)}.
   * </ul>
   *
   * <p>Method under test: {@link FederatedAccess#hasWriteAccess(User, String)}
   */
  @Test
  @DisplayName(
      "Test hasWriteAccess(User, String) with 'user', 'adminAuth'; given Predicate test(Object) return 'true'; then calls test(Object)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean FederatedAccess.hasWriteAccess(User, String)"})
  void testHasWriteAccessWithUserAdminAuth_givenPredicateTestReturnTrue_thenCallsTest2() {
    // Arrange
    Predicate<User> userPredicate = mock(Predicate.class);
    when(userPredicate.test(Mockito.<User>any())).thenReturn(true);
    AccessPredicate writeAccessPredicate = new AccessPredicate(userPredicate);

    Builder builder = new Builder();
    FederatedAccess federatedAccess =
        builder
            .graphAuths(new ArrayList<>())
            .owningUserId("Owning User")
            .readAccessPredicate(null)
            .writeAccessPredicate(writeAccessPredicate)
            .build();

    // Act
    boolean actualHasWriteAccessResult =
        federatedAccess.hasWriteAccess(new User.Builder().userId("42").build(), null);

    // Assert
    verify(userPredicate).test(isA(User.class));
    assertTrue(actualHasWriteAccessResult);
  }

  /**
   * Test {@link FederatedAccess#hasWriteAccess(User, String)} with {@code user}, {@code adminAuth}.
   *
   * <ul>
   *   <li>When empty string.
   * </ul>
   *
   * <p>Method under test: {@link FederatedAccess#hasWriteAccess(User, String)}
   */
  @Test
  @DisplayName("Test hasWriteAccess(User, String) with 'user', 'adminAuth'; when empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean FederatedAccess.hasWriteAccess(User, String)"})
  void testHasWriteAccessWithUserAdminAuth_whenEmptyString() {
    // Arrange
    FederatedAccess federatedAccess = new FederatedAccess(new HashSet<>(), "42");

    // Act and Assert
    assertFalse(federatedAccess.hasWriteAccess(new User(), ""));
  }

  /**
   * Test {@link FederatedAccess#hasWriteAccess(User, String)} with {@code user}, {@code adminAuth}.
   *
   * <ul>
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link FederatedAccess#hasWriteAccess(User, String)}
   */
  @Test
  @DisplayName("Test hasWriteAccess(User, String) with 'user', 'adminAuth'; when 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean FederatedAccess.hasWriteAccess(User, String)"})
  void testHasWriteAccessWithUserAdminAuth_whenNull() {
    // Arrange
    FederatedAccess federatedAccess = new FederatedAccess(new HashSet<>(), "42");

    // Act and Assert
    assertFalse(federatedAccess.hasWriteAccess(new User(), null));
  }

  /**
   * Test {@link FederatedAccess#hasWriteAccess(User, String)} with {@code user}, {@code adminAuth}.
   *
   * <ul>
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link FederatedAccess#hasWriteAccess(User, String)}
   */
  @Test
  @DisplayName("Test hasWriteAccess(User, String) with 'user', 'adminAuth'; when 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean FederatedAccess.hasWriteAccess(User, String)"})
  void testHasWriteAccessWithUserAdminAuth_whenNull2() {
    // Arrange, Act and Assert
    assertFalse(new FederatedAccess(new HashSet<>(), "42").hasWriteAccess(null, "Admin Auth"));
  }

  /**
   * Test {@link FederatedAccess#deserialisePredicate(String)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link FederatedAccess#deserialisePredicate(String)}
   */
  @Test
  @DisplayName("Test deserialisePredicate(String); given '42'; when ArrayList() add '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"AccessPredicate FederatedAccess.deserialisePredicate(String)"})
  void testDeserialisePredicate_given42_whenArrayListAdd42() throws JsonProcessingException {
    // Arrange
    ArrayList<Object> objectList = new ArrayList<>();
    objectList.add("42");

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            FederatedAccess.deserialisePredicate(
                JsonMapper.builder().findAndAddModules().build().writeValueAsString(objectList)));
  }

  /**
   * Test {@link FederatedAccess#deserialisePredicate(String)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link FederatedAccess#deserialisePredicate(String)}
   */
  @Test
  @DisplayName("Test deserialisePredicate(String); when '42'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"AccessPredicate FederatedAccess.deserialisePredicate(String)"})
  void testDeserialisePredicate_when42_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> FederatedAccess.deserialisePredicate("42"));
  }

  /**
   * Test {@link FederatedAccess#deserialisePredicate(String)}.
   *
   * <ul>
   *   <li>When empty string.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link FederatedAccess#deserialisePredicate(String)}
   */
  @Test
  @DisplayName(
      "Test deserialisePredicate(String); when empty string; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"AccessPredicate FederatedAccess.deserialisePredicate(String)"})
  void testDeserialisePredicate_whenEmptyString_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> FederatedAccess.deserialisePredicate(""));
  }

  /**
   * Test {@link FederatedAccess#deserialisePredicate(String)}.
   *
   * <ul>
   *   <li>When {@code Predicate Json}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link FederatedAccess#deserialisePredicate(String)}
   */
  @Test
  @DisplayName(
      "Test deserialisePredicate(String); when 'Predicate Json'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"AccessPredicate FederatedAccess.deserialisePredicate(String)"})
  void testDeserialisePredicate_whenPredicateJson_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> FederatedAccess.deserialisePredicate("Predicate Json"));
  }

  /**
   * Test {@link FederatedAccess#serialisePredicate(AccessPredicate)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link FederatedAccess#serialisePredicate(AccessPredicate)}
   */
  @Test
  @DisplayName("Test serialisePredicate(AccessPredicate); when 'null'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String FederatedAccess.serialisePredicate(AccessPredicate)"})
  void testSerialisePredicate_whenNull_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(FederatedAccess.serialisePredicate(null));
  }

  /**
   * Test {@link FederatedAccess#getReadAccessPredicate()}.
   *
   * <p>Method under test: {@link FederatedAccess#getReadAccessPredicate()}
   */
  @Test
  @DisplayName("Test getReadAccessPredicate()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"AccessPredicate FederatedAccess.getReadAccessPredicate()"})
  void testGetReadAccessPredicate() {
    // Arrange, Act and Assert
    assertNull(new FederatedAccess(new HashSet<>(), "42").getReadAccessPredicate());
  }

  /**
   * Test {@link FederatedAccess#getWriteAccessPredicate()}.
   *
   * <p>Method under test: {@link FederatedAccess#getWriteAccessPredicate()}
   */
  @Test
  @DisplayName("Test getWriteAccessPredicate()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"AccessPredicate FederatedAccess.getWriteAccessPredicate()"})
  void testGetWriteAccessPredicate() {
    // Arrange
    HashSet<String> graphAuths = new HashSet<>();
    AccessPredicate writeAccessPredicate = new AccessPredicate(mock(Predicate.class));

    FederatedAccess federatedAccess =
        new FederatedAccess(graphAuths, "42", true, null, writeAccessPredicate);

    // Act and Assert
    assertEquals(writeAccessPredicate, federatedAccess.getWriteAccessPredicate());
  }

  /**
   * Test {@link FederatedAccess#getWriteAccessPredicate()}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link FederatedAccess#getWriteAccessPredicate()}
   */
  @Test
  @DisplayName("Test getWriteAccessPredicate(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"AccessPredicate FederatedAccess.getWriteAccessPredicate()"})
  void testGetWriteAccessPredicate_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new FederatedAccess(new HashSet<>(), "42").getWriteAccessPredicate());
  }

  /**
   * Test {@link FederatedAccess#getOrDefaultReadAccessPredicate()}.
   *
   * <p>Method under test: {@link FederatedAccess#getOrDefaultReadAccessPredicate()}
   */
  @Test
  @DisplayName("Test getOrDefaultReadAccessPredicate()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"AccessPredicate FederatedAccess.getOrDefaultReadAccessPredicate()"})
  void testGetOrDefaultReadAccessPredicate() {
    // Arrange and Act
    AccessPredicate actualOrDefaultReadAccessPredicate =
        new FederatedAccess(new HashSet<>(), "42").getOrDefaultReadAccessPredicate();

    // Assert
    assertTrue(actualOrDefaultReadAccessPredicate instanceof FederatedGraphReadAccessPredicate);
    Predicate<User> userPredicate = actualOrDefaultReadAccessPredicate.getUserPredicate();
    assertTrue(userPredicate instanceof FederatedGraphReadUserPredicate);
    assertEquals("42", ((FederatedGraphReadUserPredicate) userPredicate).getCreatingUserId());
    assertFalse(((FederatedGraphReadUserPredicate) userPredicate).isPublic());
    assertTrue(((FederatedGraphReadUserPredicate) userPredicate).getAuths().isEmpty());
  }

  /**
   * Test {@link FederatedAccess#getOrDefaultWriteAccessPredicate()}.
   *
   * <p>Method under test: {@link FederatedAccess#getOrDefaultWriteAccessPredicate()}
   */
  @Test
  @DisplayName("Test getOrDefaultWriteAccessPredicate()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"AccessPredicate FederatedAccess.getOrDefaultWriteAccessPredicate()"})
  void testGetOrDefaultWriteAccessPredicate() {
    // Arrange and Act
    AccessPredicate actualOrDefaultWriteAccessPredicate =
        new FederatedAccess(new HashSet<>(), "42").getOrDefaultWriteAccessPredicate();

    // Assert
    assertTrue(actualOrDefaultWriteAccessPredicate instanceof FederatedGraphWriteAccessPredicate);
    Predicate<User> userPredicate = actualOrDefaultWriteAccessPredicate.getUserPredicate();
    assertTrue(userPredicate instanceof FederatedGraphWriteUserPredicate);
    assertEquals("42", ((FederatedGraphWriteUserPredicate) userPredicate).getCreatingUserId());
    assertTrue(((FederatedGraphWriteUserPredicate) userPredicate).getAuths().isEmpty());
  }

  /**
   * Test {@link FederatedAccess#getOrDefaultWriteAccessPredicate()}.
   *
   * <p>Method under test: {@link FederatedAccess#getOrDefaultWriteAccessPredicate()}
   */
  @Test
  @DisplayName("Test getOrDefaultWriteAccessPredicate()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"AccessPredicate FederatedAccess.getOrDefaultWriteAccessPredicate()"})
  void testGetOrDefaultWriteAccessPredicate2() {
    // Arrange
    HashSet<String> graphAuths = new HashSet<>();
    AccessPredicate writeAccessPredicate = new AccessPredicate(mock(Predicate.class));

    FederatedAccess federatedAccess =
        new FederatedAccess(graphAuths, "42", true, null, writeAccessPredicate);

    // Act and Assert
    assertEquals(writeAccessPredicate, federatedAccess.getOrDefaultWriteAccessPredicate());
  }

  /**
   * Test Transient {@link Transient#getFederatedAccess(Transient)}.
   *
   * <p>Method under test: {@link Transient#getFederatedAccess(Transient)}
   */
  @Test
  @DisplayName("Test Transient getFederatedAccess(Transient)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"FederatedAccess Transient.getFederatedAccess(Transient)"})
  void testTransientGetFederatedAccess() {
    // Arrange, Act and Assert
    assertNull(Transient.getFederatedAccess(null));
  }

  /**
   * Test Transient {@link Transient#getTransient(FederatedAccess)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link Transient#getTransient(FederatedAccess)}
   */
  @Test
  @DisplayName("Test Transient getTransient(FederatedAccess); when 'null'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Transient Transient.getTransient(FederatedAccess)"})
  void testTransientGetTransient_whenNull_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(Transient.getTransient(null));
  }
}
