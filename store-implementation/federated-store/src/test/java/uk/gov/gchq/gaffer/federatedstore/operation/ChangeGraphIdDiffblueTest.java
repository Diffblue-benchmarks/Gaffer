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

package uk.gov.gchq.gaffer.federatedstore.operation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.lang3.exception.CloneFailedException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.federatedstore.operation.ChangeGraphId.Builder;
import uk.gov.gchq.gaffer.operation.serialisation.TypeReferenceImpl;

class ChangeGraphIdDiffblueTest {
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
    ChangeGraphId _getOpResult = actualBuilder._getOp();
    assertTrue(_getOpResult.getOutputTypeReference() instanceof TypeReferenceImpl.Boolean);
    assertNull(_getOpResult.getGraphId());
    assertNull(_getOpResult.getNewGraphId());
    assertFalse(_getOpResult.isUserRequestingAdminUsage());
    assertTrue(_getOpResult.getOptions().isEmpty());
    Class<Boolean> expectedOutputClass = Boolean.class;
    assertEquals(expectedOutputClass, _getOpResult.getOutputClass());
    ChangeGraphId actualChangeGraphId = actualBuilder.build();
    assertSame(_getOpResult, actualChangeGraphId);
  }

  /**
   * Test Builder {@link Builder#newGraphId(String)}.
   *
   * <ul>
   *   <li>Given {@link Builder#Builder()}.
   *   <li>Then return {@link Builder#Builder()}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#newGraphId(String)}
   */
  @Test
  @DisplayName("Test Builder newGraphId(String); given Builder(); then return Builder()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.newGraphId(String)"})
  void testBuilderNewGraphId_givenBuilder_thenReturnBuilder() {
    // Arrange
    Builder builder = new Builder();

    // Act
    Builder actualNewGraphIdResult = builder.newGraphId("42");

    // Assert
    assertSame(builder, actualNewGraphIdResult);
  }

  /**
   * Test {@link ChangeGraphId#shallowClone()}.
   *
   * <p>Method under test: {@link ChangeGraphId#shallowClone()}
   */
  @Test
  @DisplayName("Test shallowClone()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ChangeGraphId ChangeGraphId.shallowClone()"})
  void testShallowClone() throws CloneFailedException {
    // Arrange and Act
    ChangeGraphId actualShallowCloneResult = new ChangeGraphId().shallowClone();

    // Assert
    assertTrue(
        actualShallowCloneResult.getOutputTypeReference() instanceof TypeReferenceImpl.Boolean);
    assertNull(actualShallowCloneResult.getGraphId());
    assertNull(actualShallowCloneResult.getNewGraphId());
    assertFalse(actualShallowCloneResult.isUserRequestingAdminUsage());
    assertTrue(actualShallowCloneResult.getOptions().isEmpty());
    Class<Boolean> expectedOutputClass = Boolean.class;
    assertEquals(expectedOutputClass, actualShallowCloneResult.getOutputClass());
  }

  /**
   * Test {@link ChangeGraphId#setUserRequestingAdminUsage(boolean)}.
   *
   * <p>Method under test: {@link ChangeGraphId#setUserRequestingAdminUsage(boolean)}
   */
  @Test
  @DisplayName("Test setUserRequestingAdminUsage(boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ChangeGraphId ChangeGraphId.setUserRequestingAdminUsage(boolean)"})
  void testSetUserRequestingAdminUsage() {
    // Arrange
    ChangeGraphId changeGraphId = new ChangeGraphId();

    // Act
    ChangeGraphId actualSetUserRequestingAdminUsageResult =
        changeGraphId.setUserRequestingAdminUsage(true);

    // Assert
    assertTrue(changeGraphId.isUserRequestingAdminUsage());
    assertSame(changeGraphId, actualSetUserRequestingAdminUsageResult);
  }

  /**
   * Test {@link ChangeGraphId#getOutputTypeReference()}.
   *
   * <p>Method under test: {@link ChangeGraphId#getOutputTypeReference()}
   */
  @Test
  @DisplayName("Test getOutputTypeReference()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "com.fasterxml.jackson.core.type.TypeReference ChangeGraphId.getOutputTypeReference()"
  })
  void testGetOutputTypeReference() {
    // Arrange, Act and Assert
    assertTrue(new ChangeGraphId().getOutputTypeReference() instanceof TypeReferenceImpl.Boolean);
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link ChangeGraphId}
   *   <li>{@link ChangeGraphId#setGraphId(String)}
   *   <li>{@link ChangeGraphId#setNewGraphId(String)}
   *   <li>{@link ChangeGraphId#setOptions(Map)}
   *   <li>{@link ChangeGraphId#getGraphId()}
   *   <li>{@link ChangeGraphId#getNewGraphId()}
   *   <li>{@link ChangeGraphId#getOptions()}
   *   <li>{@link ChangeGraphId#isUserRequestingAdminUsage()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ChangeGraphId.<init>()",
    "String ChangeGraphId.getGraphId()",
    "String ChangeGraphId.getNewGraphId()",
    "Map ChangeGraphId.getOptions()",
    "boolean ChangeGraphId.isUserRequestingAdminUsage()",
    "void ChangeGraphId.setGraphId(String)",
    "void ChangeGraphId.setNewGraphId(String)",
    "void ChangeGraphId.setOptions(Map)"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    ChangeGraphId actualChangeGraphId = new ChangeGraphId();
    actualChangeGraphId.setGraphId("42");
    actualChangeGraphId.setNewGraphId("42");
    HashMap<String, String> options = new HashMap<>();
    actualChangeGraphId.setOptions(options);
    String actualGraphId = actualChangeGraphId.getGraphId();
    String actualNewGraphId = actualChangeGraphId.getNewGraphId();
    Map<String, String> actualOptions = actualChangeGraphId.getOptions();

    // Assert
    assertEquals("42", actualGraphId);
    assertEquals("42", actualNewGraphId);
    assertFalse(actualChangeGraphId.isUserRequestingAdminUsage());
    assertTrue(actualOptions.isEmpty());
    assertSame(options, actualOptions);
  }
}
