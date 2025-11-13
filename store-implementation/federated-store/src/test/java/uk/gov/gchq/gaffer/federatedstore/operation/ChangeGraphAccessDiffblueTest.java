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

package uk.gov.gchq.gaffer.federatedstore.operation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.apache.commons.lang3.exception.CloneFailedException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.federatedstore.operation.ChangeGraphAccess.Builder;
import uk.gov.gchq.gaffer.operation.serialisation.TypeReferenceImpl;

class ChangeGraphAccessDiffblueTest {
  /**
   * Test Builder {@link Builder#graphAuths(String[])}.
   *
   * <ul>
   *   <li>Given {@link Builder#Builder()}.
   *   <li>Then _getOp OutputTypeReference return {@link TypeReferenceImpl.Boolean}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#graphAuths(String[])}
   */
  @Test
  @DisplayName(
      "Test Builder graphAuths(String[]); given Builder(); then _getOp OutputTypeReference return Boolean")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.graphAuths(String[])"})
  void testBuilderGraphAuths_givenBuilder_then_getOpOutputTypeReferenceReturnBoolean() {
    // Arrange and Act
    Builder actualGraphAuthsResult = new Builder().graphAuths(null);

    // Assert
    ChangeGraphAccess _getOpResult = actualGraphAuthsResult._getOp();
    assertTrue(_getOpResult.getOutputTypeReference() instanceof TypeReferenceImpl.Boolean);
    assertNull(_getOpResult.getGraphAuths());
    ChangeGraphAccess actualChangeGraphAccess = actualGraphAuthsResult.build();
    assertSame(_getOpResult, actualChangeGraphAccess);
  }

  /**
   * Test Builder {@link Builder#graphAuths(String[])}.
   *
   * <ul>
   *   <li>Given {@link Builder#Builder()}.
   *   <li>When {@code Graph Auths}.
   *   <li>Then return {@link Builder#Builder()}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#graphAuths(String[])}
   */
  @Test
  @DisplayName(
      "Test Builder graphAuths(String[]); given Builder(); when 'Graph Auths'; then return Builder()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.graphAuths(String[])"})
  void testBuilderGraphAuths_givenBuilder_whenGraphAuths_thenReturnBuilder() {
    // Arrange
    Builder builder = new Builder();

    // Act
    Builder actualGraphAuthsResult = builder.graphAuths("Graph Auths");

    // Assert
    assertSame(builder, actualGraphAuthsResult);
  }

  /**
   * Test Builder {@link Builder#graphId(String)}.
   *
   * <ul>
   *   <li>Given {@link Builder#Builder()}.
   *   <li>Then return {@link Builder#Builder()}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#graphId(String)}
   */
  @Test
  @DisplayName("Test Builder graphId(String); given Builder(); then return Builder()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.graphId(String)"})
  void testBuilderGraphId_givenBuilder_thenReturnBuilder() {
    // Arrange
    Builder builder = new Builder();

    // Act
    Builder actualGraphIdResult = builder.graphId("42");

    // Assert
    assertSame(builder, actualGraphIdResult);
  }

  /**
   * Test Builder {@link Builder#isPublic(boolean)}.
   *
   * <ul>
   *   <li>Given {@link Builder#Builder()}.
   *   <li>Then return {@link Builder#Builder()}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#isPublic(boolean)}
   */
  @Test
  @DisplayName("Test Builder isPublic(boolean); given Builder(); then return Builder()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.isPublic(boolean)"})
  void testBuilderIsPublic_givenBuilder_thenReturnBuilder() {
    // Arrange
    Builder builder = new Builder();

    // Act
    Builder actualIsPublicResult = builder.isPublic(true);

    // Assert
    assertSame(builder, actualIsPublicResult);
  }

  /**
   * Test Builder {@link Builder#Builder()}.
   *
   * <p>Method under test: {@link Builder#Builder()}
   */
  @Test
  @DisplayName("Test Builder new Builder()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Builder.<init>()"})
  void testBuilderNewBuilder() {
    // Arrange and Act
    Builder actualBuilder = new Builder();

    // Assert
    ChangeGraphAccess _getOpResult = actualBuilder._getOp();
    assertTrue(_getOpResult.getOutputTypeReference() instanceof TypeReferenceImpl.Boolean);
    assertNull(_getOpResult.getGraphId());
    assertNull(_getOpResult.getOwnerUserId());
    assertFalse(_getOpResult.getIsPublic());
    assertFalse(_getOpResult.isUserRequestingAdminUsage());
    assertTrue(_getOpResult.getOptions().isEmpty());
    assertTrue(_getOpResult.getGraphAuths().isEmpty());
    Class<Boolean> expectedOutputClass = Boolean.class;
    assertEquals(expectedOutputClass, _getOpResult.getOutputClass());
    ChangeGraphAccess actualChangeGraphAccess = actualBuilder.build();
    assertSame(_getOpResult, actualChangeGraphAccess);
  }

  /**
   * Test Builder {@link Builder#ownerUserId(String)}.
   *
   * <ul>
   *   <li>Given {@link Builder#Builder()}.
   *   <li>Then return {@link Builder#Builder()}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#ownerUserId(String)}
   */
  @Test
  @DisplayName("Test Builder ownerUserId(String); given Builder(); then return Builder()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.ownerUserId(String)"})
  void testBuilderOwnerUserId_givenBuilder_thenReturnBuilder() {
    // Arrange
    Builder builder = new Builder();

    // Act
    Builder actualOwnerUserIdResult = builder.ownerUserId("42");

    // Assert
    assertSame(builder, actualOwnerUserIdResult);
  }

  /**
   * Test {@link ChangeGraphAccess#shallowClone()}.
   *
   * <ul>
   *   <li>Given {@link ChangeGraphAccess} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link ChangeGraphAccess#shallowClone()}
   */
  @Test
  @DisplayName("Test shallowClone(); given ChangeGraphAccess (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ChangeGraphAccess ChangeGraphAccess.shallowClone()"})
  void testShallowClone_givenChangeGraphAccess() throws CloneFailedException {
    // Arrange and Act
    ChangeGraphAccess actualShallowCloneResult = new ChangeGraphAccess().shallowClone();

    // Assert
    assertTrue(
        actualShallowCloneResult.getOutputTypeReference() instanceof TypeReferenceImpl.Boolean);
    assertNull(actualShallowCloneResult.getGraphId());
    assertNull(actualShallowCloneResult.getOwnerUserId());
    assertFalse(actualShallowCloneResult.getIsPublic());
    assertFalse(actualShallowCloneResult.isUserRequestingAdminUsage());
    assertTrue(actualShallowCloneResult.getOptions().isEmpty());
    assertTrue(actualShallowCloneResult.getGraphAuths().isEmpty());
    Class<Boolean> expectedOutputClass = Boolean.class;
    assertEquals(expectedOutputClass, actualShallowCloneResult.getOutputClass());
  }

  /**
   * Test {@link ChangeGraphAccess#shallowClone()}.
   *
   * <ul>
   *   <li>Given {@link ChangeGraphAccess} (default constructor) GraphAuths is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ChangeGraphAccess#shallowClone()}
   */
  @Test
  @DisplayName(
      "Test shallowClone(); given ChangeGraphAccess (default constructor) GraphAuths is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ChangeGraphAccess ChangeGraphAccess.shallowClone()"})
  void testShallowClone_givenChangeGraphAccessGraphAuthsIsNull() throws CloneFailedException {
    // Arrange
    ChangeGraphAccess changeGraphAccess = new ChangeGraphAccess();
    changeGraphAccess.setGraphAuths(null);

    // Act
    ChangeGraphAccess actualShallowCloneResult = changeGraphAccess.shallowClone();

    // Assert
    assertTrue(
        actualShallowCloneResult.getOutputTypeReference() instanceof TypeReferenceImpl.Boolean);
    assertNull(actualShallowCloneResult.getGraphId());
    assertNull(actualShallowCloneResult.getOwnerUserId());
    assertFalse(actualShallowCloneResult.getIsPublic());
    assertFalse(actualShallowCloneResult.isUserRequestingAdminUsage());
    assertTrue(actualShallowCloneResult.getOptions().isEmpty());
    assertTrue(actualShallowCloneResult.getGraphAuths().isEmpty());
    Class<Boolean> expectedOutputClass = Boolean.class;
    assertEquals(expectedOutputClass, actualShallowCloneResult.getOutputClass());
  }

  /**
   * Test {@link ChangeGraphAccess#setUserRequestingAdminUsage(boolean)}.
   *
   * <p>Method under test: {@link ChangeGraphAccess#setUserRequestingAdminUsage(boolean)}
   */
  @Test
  @DisplayName("Test setUserRequestingAdminUsage(boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ChangeGraphAccess ChangeGraphAccess.setUserRequestingAdminUsage(boolean)"})
  void testSetUserRequestingAdminUsage() {
    // Arrange
    ChangeGraphAccess changeGraphAccess = new ChangeGraphAccess();

    // Act
    ChangeGraphAccess actualSetUserRequestingAdminUsageResult =
        changeGraphAccess.setUserRequestingAdminUsage(true);

    // Assert
    assertTrue(changeGraphAccess.isUserRequestingAdminUsage());
    assertSame(changeGraphAccess, actualSetUserRequestingAdminUsageResult);
  }

  /**
   * Test {@link ChangeGraphAccess#getOutputTypeReference()}.
   *
   * <p>Method under test: {@link ChangeGraphAccess#getOutputTypeReference()}
   */
  @Test
  @DisplayName("Test getOutputTypeReference()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "com.fasterxml.jackson.core.type.TypeReference ChangeGraphAccess.getOutputTypeReference()"
  })
  void testGetOutputTypeReference() {
    // Arrange, Act and Assert
    assertTrue(
        new ChangeGraphAccess().getOutputTypeReference() instanceof TypeReferenceImpl.Boolean);
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link ChangeGraphAccess}
   *   <li>{@link ChangeGraphAccess#setGraphAuths(Set)}
   *   <li>{@link ChangeGraphAccess#setGraphId(String)}
   *   <li>{@link ChangeGraphAccess#setIsPublic(boolean)}
   *   <li>{@link ChangeGraphAccess#setOptions(Map)}
   *   <li>{@link ChangeGraphAccess#setOwnerUserId(String)}
   *   <li>{@link ChangeGraphAccess#getGraphAuths()}
   *   <li>{@link ChangeGraphAccess#getGraphId()}
   *   <li>{@link ChangeGraphAccess#getIsPublic()}
   *   <li>{@link ChangeGraphAccess#getOptions()}
   *   <li>{@link ChangeGraphAccess#getOwnerUserId()}
   *   <li>{@link ChangeGraphAccess#isUserRequestingAdminUsage()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ChangeGraphAccess.<init>()",
    "Set ChangeGraphAccess.getGraphAuths()",
    "String ChangeGraphAccess.getGraphId()",
    "boolean ChangeGraphAccess.getIsPublic()",
    "Map ChangeGraphAccess.getOptions()",
    "String ChangeGraphAccess.getOwnerUserId()",
    "boolean ChangeGraphAccess.isUserRequestingAdminUsage()",
    "void ChangeGraphAccess.setGraphAuths(Set)",
    "void ChangeGraphAccess.setGraphId(String)",
    "void ChangeGraphAccess.setIsPublic(boolean)",
    "void ChangeGraphAccess.setOptions(Map)",
    "void ChangeGraphAccess.setOwnerUserId(String)"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    ChangeGraphAccess actualChangeGraphAccess = new ChangeGraphAccess();
    HashSet<String> graphAuths = new HashSet<>();
    actualChangeGraphAccess.setGraphAuths(graphAuths);
    actualChangeGraphAccess.setGraphId("42");
    actualChangeGraphAccess.setIsPublic(true);
    HashMap<String, String> options = new HashMap<>();
    actualChangeGraphAccess.setOptions(options);
    actualChangeGraphAccess.setOwnerUserId("42");
    Set<String> actualGraphAuths = actualChangeGraphAccess.getGraphAuths();
    String actualGraphId = actualChangeGraphAccess.getGraphId();
    boolean actualIsPublic = actualChangeGraphAccess.getIsPublic();
    Map<String, String> actualOptions = actualChangeGraphAccess.getOptions();
    String actualOwnerUserId = actualChangeGraphAccess.getOwnerUserId();

    // Assert
    assertEquals("42", actualGraphId);
    assertEquals("42", actualOwnerUserId);
    assertFalse(actualChangeGraphAccess.isUserRequestingAdminUsage());
    assertTrue(actualOptions.isEmpty());
    assertTrue(actualGraphAuths.isEmpty());
    assertTrue(actualIsPublic);
    assertSame(options, actualOptions);
    assertSame(graphAuths, actualGraphAuths);
  }
}
