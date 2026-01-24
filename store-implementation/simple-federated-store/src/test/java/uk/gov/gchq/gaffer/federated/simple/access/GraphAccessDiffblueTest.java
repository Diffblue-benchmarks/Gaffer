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

package uk.gov.gchq.gaffer.federated.simple.access;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.function.Predicate;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.access.ResourceType;
import uk.gov.gchq.gaffer.access.predicate.AccessPredicate;
import uk.gov.gchq.gaffer.access.predicate.UnrestrictedAccessPredicate;
import uk.gov.gchq.gaffer.access.predicate.user.UnrestrictedAccessUserPredicate;
import uk.gov.gchq.gaffer.federated.simple.access.GraphAccess.Builder;
import uk.gov.gchq.gaffer.user.User;

class GraphAccessDiffblueTest {
  /**
   * Test Builder {@link Builder#build()}.
   *
   * <p>Method under test: {@link Builder#build()}
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"GraphAccess Builder.build()"})
  void testBuilderBuild() {
    // Arrange and Act
    Builder actualBuilder = new Builder();
    GraphAccess actualGraphAccess = actualBuilder.build();

    // Assert
    assertSame(actualBuilder.graphAccess, actualGraphAccess);
  }

  /**
   * Test Builder {@link Builder#isPublic(boolean)}.
   *
   * <ul>
   *   <li>When {@code false}.
   *   <li>Then not {@link Builder} (default constructor) {@link Builder#graphAccess} Public.
   * </ul>
   *
   * <p>Method under test: {@link Builder#isPublic(boolean)}
   */
  @Test
  @DisplayName(
      "Test Builder isPublic(boolean); when 'false'; then not Builder (default constructor) graphAccess Public")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.isPublic(boolean)"})
  void testBuilderIsPublic_whenFalse_thenNotBuilderGraphAccessPublic() {
    // Arrange
    Builder builder = new Builder();

    // Act
    Builder actualIsPublicResult = builder.isPublic(false);

    // Assert
    assertFalse(builder.graphAccess.isPublic());
    assertSame(builder, actualIsPublicResult);
  }

  /**
   * Test Builder {@link Builder#isPublic(boolean)}.
   *
   * <ul>
   *   <li>When {@code true}.
   *   <li>Then {@link Builder} (default constructor) {@link Builder#graphAccess} Public.
   * </ul>
   *
   * <p>Method under test: {@link Builder#isPublic(boolean)}
   */
  @Test
  @DisplayName(
      "Test Builder isPublic(boolean); when 'true'; then Builder (default constructor) graphAccess Public")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.isPublic(boolean)"})
  void testBuilderIsPublic_whenTrue_thenBuilderGraphAccessPublic() {
    // Arrange
    Builder builder = new Builder();

    // Act
    Builder actualIsPublicResult = builder.isPublic(true);

    // Assert
    assertTrue(builder.graphAccess.isPublic());
    assertSame(builder, actualIsPublicResult);
  }

  /**
   * Test Builder new {@link Builder} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link Builder}
   */
  @Test
  @DisplayName("Test Builder new Builder (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Builder.<init>()"})
  void testBuilderNewBuilder() {
    // Arrange, Act and Assert
    GraphAccess graphAccess = new Builder().graphAccess;
    AccessPredicate readAccessPredicate = graphAccess.getReadAccessPredicate();
    assertTrue(readAccessPredicate instanceof UnrestrictedAccessPredicate);
    AccessPredicate writeAccessPredicate = graphAccess.getWriteAccessPredicate();
    assertTrue(writeAccessPredicate instanceof UnrestrictedAccessPredicate);
    assertTrue(readAccessPredicate.getUserPredicate() instanceof UnrestrictedAccessUserPredicate);
    assertEquals("UNKNOWN", graphAccess.getOwner());
    assertEquals(ResourceType.FederatedStoreGraph, graphAccess.getResourceType());
    assertTrue(graphAccess.isPublic());
    assertEquals(readAccessPredicate, writeAccessPredicate);
  }

  /**
   * Test Builder {@link Builder#owner(String)}.
   *
   * <p>Method under test: {@link Builder#owner(String)}
   */
  @Test
  @DisplayName("Test Builder owner(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.owner(String)"})
  void testBuilderOwner() {
    // Arrange
    Builder builder = new Builder();

    // Act
    Builder actualOwnerResult = builder.owner("Owner");

    // Assert
    assertEquals("Owner", builder.graphAccess.getOwner());
    assertSame(builder, actualOwnerResult);
  }

  /**
   * Test Builder {@link Builder#readAccessPredicate(AccessPredicate)}.
   *
   * <p>Method under test: {@link Builder#readAccessPredicate(AccessPredicate)}
   */
  @Test
  @DisplayName("Test Builder readAccessPredicate(AccessPredicate)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.readAccessPredicate(AccessPredicate)"})
  void testBuilderReadAccessPredicate() {
    // Arrange
    Builder builder = new Builder();
    AccessPredicate readAccessPredicate = new AccessPredicate(mock(Predicate.class));

    // Act
    Builder actualReadAccessPredicateResult = builder.readAccessPredicate(readAccessPredicate);

    // Assert
    assertSame(readAccessPredicate, builder.graphAccess.getReadAccessPredicate());
    assertSame(builder, actualReadAccessPredicateResult);
  }

  /**
   * Test Builder {@link Builder#writeAccessPredicate(AccessPredicate)}.
   *
   * <p>Method under test: {@link Builder#writeAccessPredicate(AccessPredicate)}
   */
  @Test
  @DisplayName("Test Builder writeAccessPredicate(AccessPredicate)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.writeAccessPredicate(AccessPredicate)"})
  void testBuilderWriteAccessPredicate() {
    // Arrange
    Builder builder = new Builder();
    AccessPredicate writeAccessPredicate = new AccessPredicate(mock(Predicate.class));

    // Act
    Builder actualWriteAccessPredicateResult = builder.writeAccessPredicate(writeAccessPredicate);

    // Assert
    assertSame(writeAccessPredicate, builder.graphAccess.getWriteAccessPredicate());
    assertSame(builder, actualWriteAccessPredicateResult);
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link GraphAccess#getOwner()}
   *   <li>{@link GraphAccess#getReadAccessPredicate()}
   *   <li>{@link GraphAccess#getResourceType()}
   *   <li>{@link GraphAccess#getWriteAccessPredicate()}
   *   <li>{@link GraphAccess#isPublic()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String GraphAccess.getOwner()",
    "AccessPredicate GraphAccess.getReadAccessPredicate()",
    "ResourceType GraphAccess.getResourceType()",
    "AccessPredicate GraphAccess.getWriteAccessPredicate()",
    "boolean GraphAccess.isPublic()"
  })
  void testGettersAndSetters() {
    // Arrange
    GraphAccess graphAccess = new Builder().build();

    // Act
    String actualOwner = graphAccess.getOwner();
    AccessPredicate actualReadAccessPredicate = graphAccess.getReadAccessPredicate();
    ResourceType actualResourceType = graphAccess.getResourceType();
    AccessPredicate actualWriteAccessPredicate = graphAccess.getWriteAccessPredicate();

    // Assert
    assertTrue(actualReadAccessPredicate instanceof UnrestrictedAccessPredicate);
    assertTrue(actualWriteAccessPredicate instanceof UnrestrictedAccessPredicate);
    assertEquals("UNKNOWN", actualOwner);
    assertEquals(ResourceType.FederatedStoreGraph, actualResourceType);
    assertTrue(graphAccess.isPublic());
    assertEquals(actualReadAccessPredicate, actualWriteAccessPredicate);
  }

  /**
   * Test {@link GraphAccess#hasReadAccess(User, String)} with {@code user}, {@code adminAuth}.
   *
   * <p>Method under test: {@link GraphAccess#hasReadAccess(User, String)}
   */
  @Test
  @DisplayName("Test hasReadAccess(User, String) with 'user', 'adminAuth'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean GraphAccess.hasReadAccess(User, String)"})
  void testHasReadAccessWithUserAdminAuth() {
    // Arrange
    GraphAccess graphAccess = new GraphAccess();

    // Act and Assert
    assertTrue(graphAccess.hasReadAccess(new User(), "Admin Auth"));
  }

  /**
   * Test {@link GraphAccess#hasWriteAccess(User, String)} with {@code user}, {@code adminAuth}.
   *
   * <ul>
   *   <li>When empty string.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link GraphAccess#hasWriteAccess(User, String)}
   */
  @Test
  @DisplayName(
      "Test hasWriteAccess(User, String) with 'user', 'adminAuth'; when empty string; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean GraphAccess.hasWriteAccess(User, String)"})
  void testHasWriteAccessWithUserAdminAuth_whenEmptyString_thenReturnTrue() {
    // Arrange
    GraphAccess graphAccess = new GraphAccess();

    // Act and Assert
    assertTrue(graphAccess.hasWriteAccess(new User(), ""));
  }

  /**
   * Test {@link GraphAccess#hasWriteAccess(User, String)} with {@code user}, {@code adminAuth}.
   *
   * <ul>
   *   <li>When {@link User#User()}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link GraphAccess#hasWriteAccess(User, String)}
   */
  @Test
  @DisplayName(
      "Test hasWriteAccess(User, String) with 'user', 'adminAuth'; when User(); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean GraphAccess.hasWriteAccess(User, String)"})
  void testHasWriteAccessWithUserAdminAuth_whenUser_thenReturnTrue() {
    // Arrange
    GraphAccess graphAccess = new GraphAccess();

    // Act and Assert
    assertTrue(graphAccess.hasWriteAccess(new User(), "Admin Auth"));
  }

  /**
   * Test new {@link GraphAccess} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link GraphAccess}
   */
  @Test
  @DisplayName("Test new GraphAccess (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void GraphAccess.<init>()"})
  void testNewGraphAccess() {
    // Arrange and Act
    GraphAccess actualGraphAccess = new GraphAccess();

    // Assert
    AccessPredicate readAccessPredicate = actualGraphAccess.getReadAccessPredicate();
    assertTrue(readAccessPredicate instanceof UnrestrictedAccessPredicate);
    AccessPredicate writeAccessPredicate = actualGraphAccess.getWriteAccessPredicate();
    assertTrue(writeAccessPredicate instanceof UnrestrictedAccessPredicate);
    assertTrue(readAccessPredicate.getUserPredicate() instanceof UnrestrictedAccessUserPredicate);
    assertEquals("UNKNOWN", actualGraphAccess.getOwner());
    assertEquals(ResourceType.FederatedStoreGraph, actualGraphAccess.getResourceType());
    assertTrue(actualGraphAccess.isPublic());
    assertEquals(readAccessPredicate, writeAccessPredicate);
  }
}
