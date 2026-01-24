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

package uk.gov.gchq.gaffer.federated.simple.operation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Predicate;
import org.apache.commons.lang3.exception.CloneFailedException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.access.predicate.AccessPredicate;
import uk.gov.gchq.gaffer.federated.simple.operation.ChangeGraphAccess.Builder;
import uk.gov.gchq.gaffer.operation.Operation;

class ChangeGraphAccessDiffblueTest {
  /**
   * Test Builder {@link Builder#graphId(String)}.
   *
   * <p>Method under test: {@link Builder#graphId(String)}
   */
  @Test
  @DisplayName("Test Builder graphId(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.graphId(String)"})
  void testBuilderGraphId() {
    // Arrange
    Builder builder = new Builder();

    // Act
    Builder actualGraphIdResult = builder.graphId("42");

    // Assert
    assertSame(builder, actualGraphIdResult);
  }

  /**
   * Test Builder {@link Builder#isPublic(Boolean)}.
   *
   * <p>Method under test: {@link Builder#isPublic(Boolean)}
   */
  @Test
  @DisplayName("Test Builder isPublic(Boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.isPublic(Boolean)"})
  void testBuilderIsPublic() {
    // Arrange
    Builder builder = new Builder();

    // Act
    Builder actualIsPublicResult = builder.isPublic(true);

    // Assert
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
    // Arrange and Act
    Builder actualBuilder = new Builder();

    // Assert
    ChangeGraphAccess _getOpResult = actualBuilder._getOp();
    assertNull(_getOpResult.isPublic());
    assertNull(_getOpResult.getGraphId());
    assertNull(_getOpResult.getOwner());
    assertNull(_getOpResult.getOptions());
    assertNull(_getOpResult.getReadPredicate());
    assertNull(_getOpResult.getWritePredicate());
    ChangeGraphAccess actualChangeGraphAccess = actualBuilder.build();
    assertSame(_getOpResult, actualChangeGraphAccess);
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
    assertSame(builder, actualOwnerResult);
  }

  /**
   * Test Builder {@link Builder#readPredicate(AccessPredicate)}.
   *
   * <p>Method under test: {@link Builder#readPredicate(AccessPredicate)}
   */
  @Test
  @DisplayName("Test Builder readPredicate(AccessPredicate)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.readPredicate(AccessPredicate)"})
  void testBuilderReadPredicate() {
    // Arrange
    Builder builder = new Builder();

    // Act
    Builder actualReadPredicateResult =
        builder.readPredicate(new AccessPredicate(mock(Predicate.class)));

    // Assert
    assertSame(builder, actualReadPredicateResult);
  }

  /**
   * Test Builder {@link Builder#writePredicate(AccessPredicate)}.
   *
   * <p>Method under test: {@link Builder#writePredicate(AccessPredicate)}
   */
  @Test
  @DisplayName("Test Builder writePredicate(AccessPredicate)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.writePredicate(AccessPredicate)"})
  void testBuilderWritePredicate() {
    // Arrange
    Builder builder = new Builder();

    // Act
    Builder actualWritePredicateResult =
        builder.writePredicate(new AccessPredicate(mock(Predicate.class)));

    // Assert
    assertSame(builder, actualWritePredicateResult);
  }

  /**
   * Test {@link ChangeGraphAccess#shallowClone()}.
   *
   * <ul>
   *   <li>Given {@link ChangeGraphAccess} (default constructor) Options is {@link
   *       HashMap#HashMap()}.
   *   <li>Then return Options Empty.
   * </ul>
   *
   * <p>Method under test: {@link ChangeGraphAccess#shallowClone()}
   */
  @Test
  @DisplayName(
      "Test shallowClone(); given ChangeGraphAccess (default constructor) Options is HashMap(); then return Options Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Operation ChangeGraphAccess.shallowClone()"})
  void testShallowClone_givenChangeGraphAccessOptionsIsHashMap_thenReturnOptionsEmpty()
      throws CloneFailedException {
    // Arrange
    ChangeGraphAccess changeGraphAccess = new ChangeGraphAccess();
    changeGraphAccess.setOptions(new HashMap<>());

    // Act
    Operation actualShallowCloneResult = changeGraphAccess.shallowClone();

    // Assert
    assertTrue(actualShallowCloneResult instanceof ChangeGraphAccess);
    assertNull(((ChangeGraphAccess) actualShallowCloneResult).isPublic());
    assertNull(((ChangeGraphAccess) actualShallowCloneResult).getGraphId());
    assertNull(((ChangeGraphAccess) actualShallowCloneResult).getOwner());
    assertNull(((ChangeGraphAccess) actualShallowCloneResult).getReadPredicate());
    assertNull(((ChangeGraphAccess) actualShallowCloneResult).getWritePredicate());
    assertTrue(actualShallowCloneResult.getOptions().isEmpty());
  }

  /**
   * Test {@link ChangeGraphAccess#shallowClone()}.
   *
   * <ul>
   *   <li>Given {@link ChangeGraphAccess} (default constructor).
   *   <li>Then return Options is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ChangeGraphAccess#shallowClone()}
   */
  @Test
  @DisplayName(
      "Test shallowClone(); given ChangeGraphAccess (default constructor); then return Options is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Operation ChangeGraphAccess.shallowClone()"})
  void testShallowClone_givenChangeGraphAccess_thenReturnOptionsIsNull()
      throws CloneFailedException {
    // Arrange and Act
    Operation actualShallowCloneResult = new ChangeGraphAccess().shallowClone();

    // Assert
    assertTrue(actualShallowCloneResult instanceof ChangeGraphAccess);
    assertNull(((ChangeGraphAccess) actualShallowCloneResult).isPublic());
    assertNull(((ChangeGraphAccess) actualShallowCloneResult).getGraphId());
    assertNull(((ChangeGraphAccess) actualShallowCloneResult).getOwner());
    assertNull(actualShallowCloneResult.getOptions());
    assertNull(((ChangeGraphAccess) actualShallowCloneResult).getReadPredicate());
    assertNull(((ChangeGraphAccess) actualShallowCloneResult).getWritePredicate());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link ChangeGraphAccess}
   *   <li>{@link ChangeGraphAccess#setGraphId(String)}
   *   <li>{@link ChangeGraphAccess#setIsPublic(Boolean)}
   *   <li>{@link ChangeGraphAccess#setOptions(Map)}
   *   <li>{@link ChangeGraphAccess#setOwner(String)}
   *   <li>{@link ChangeGraphAccess#setReadPredicate(AccessPredicate)}
   *   <li>{@link ChangeGraphAccess#setWritePredicate(AccessPredicate)}
   *   <li>{@link ChangeGraphAccess#getGraphId()}
   *   <li>{@link ChangeGraphAccess#getOptions()}
   *   <li>{@link ChangeGraphAccess#getOwner()}
   *   <li>{@link ChangeGraphAccess#getReadPredicate()}
   *   <li>{@link ChangeGraphAccess#getWritePredicate()}
   *   <li>{@link ChangeGraphAccess#isPublic()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ChangeGraphAccess.<init>()",
    "String ChangeGraphAccess.getGraphId()",
    "Map ChangeGraphAccess.getOptions()",
    "String ChangeGraphAccess.getOwner()",
    "AccessPredicate ChangeGraphAccess.getReadPredicate()",
    "AccessPredicate ChangeGraphAccess.getWritePredicate()",
    "Boolean ChangeGraphAccess.isPublic()",
    "void ChangeGraphAccess.setGraphId(String)",
    "void ChangeGraphAccess.setIsPublic(Boolean)",
    "void ChangeGraphAccess.setOptions(Map)",
    "void ChangeGraphAccess.setOwner(String)",
    "void ChangeGraphAccess.setReadPredicate(AccessPredicate)",
    "void ChangeGraphAccess.setWritePredicate(AccessPredicate)"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    ChangeGraphAccess actualChangeGraphAccess = new ChangeGraphAccess();
    actualChangeGraphAccess.setGraphId("42");
    actualChangeGraphAccess.setIsPublic(true);
    HashMap<String, String> options = new HashMap<>();
    actualChangeGraphAccess.setOptions(options);
    actualChangeGraphAccess.setOwner("Owner");
    AccessPredicate readPredicate = new AccessPredicate(mock(Predicate.class));
    actualChangeGraphAccess.setReadPredicate(readPredicate);
    AccessPredicate writePredicate = new AccessPredicate(mock(Predicate.class));
    actualChangeGraphAccess.setWritePredicate(writePredicate);
    String actualGraphId = actualChangeGraphAccess.getGraphId();
    Map<String, String> actualOptions = actualChangeGraphAccess.getOptions();
    String actualOwner = actualChangeGraphAccess.getOwner();
    AccessPredicate actualReadPredicate = actualChangeGraphAccess.getReadPredicate();
    AccessPredicate actualWritePredicate = actualChangeGraphAccess.getWritePredicate();
    Boolean actualIsPublicResult = actualChangeGraphAccess.isPublic();

    // Assert
    assertEquals("42", actualGraphId);
    assertEquals("Owner", actualOwner);
    assertTrue(actualOptions.isEmpty());
    assertTrue(actualIsPublicResult);
    assertSame(options, actualOptions);
    assertSame(readPredicate, actualReadPredicate);
    assertSame(writePredicate, actualWritePredicate);
  }
}
