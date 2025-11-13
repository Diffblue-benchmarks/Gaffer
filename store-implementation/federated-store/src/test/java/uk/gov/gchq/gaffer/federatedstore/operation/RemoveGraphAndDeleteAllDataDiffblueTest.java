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
import org.apache.commons.lang3.exception.CloneFailedException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.federatedstore.operation.RemoveGraphAndDeleteAllData.Builder;
import uk.gov.gchq.gaffer.operation.serialisation.TypeReferenceImpl;

class RemoveGraphAndDeleteAllDataDiffblueTest {
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
    RemoveGraphAndDeleteAllData _getOpResult = actualBuilder._getOp();
    assertTrue(_getOpResult.getOutputTypeReference() instanceof TypeReferenceImpl.Boolean);
    assertNull(_getOpResult.getGraphId());
    assertNull(_getOpResult.getOptions());
    assertFalse(_getOpResult.isUserRequestingAdminUsage());
    assertTrue(_getOpResult.isRemoveCache());
    Class<Boolean> expectedOutputClass = Boolean.class;
    assertEquals(expectedOutputClass, _getOpResult.getOutputClass());
    RemoveGraphAndDeleteAllData actualRemoveGraphAndDeleteAllData = actualBuilder.build();
    assertSame(_getOpResult, actualRemoveGraphAndDeleteAllData);
  }

  /**
   * Test {@link RemoveGraphAndDeleteAllData#shallowClone()}.
   *
   * <p>Method under test: {@link RemoveGraphAndDeleteAllData#shallowClone()}
   */
  @Test
  @DisplayName("Test shallowClone()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"RemoveGraphAndDeleteAllData RemoveGraphAndDeleteAllData.shallowClone()"})
  void testShallowClone() throws CloneFailedException {
    // Arrange and Act
    RemoveGraphAndDeleteAllData actualShallowCloneResult =
        new RemoveGraphAndDeleteAllData().shallowClone();

    // Assert
    assertTrue(
        actualShallowCloneResult.getOutputTypeReference() instanceof TypeReferenceImpl.Boolean);
    assertNull(actualShallowCloneResult.getGraphId());
    assertNull(actualShallowCloneResult.getOptions());
    assertFalse(actualShallowCloneResult.isUserRequestingAdminUsage());
    assertTrue(actualShallowCloneResult.isRemoveCache());
    Class<Boolean> expectedOutputClass = Boolean.class;
    assertEquals(expectedOutputClass, actualShallowCloneResult.getOutputClass());
  }

  /**
   * Test new {@link RemoveGraphAndDeleteAllData} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link
   * RemoveGraphAndDeleteAllData}
   */
  @Test
  @DisplayName("Test new RemoveGraphAndDeleteAllData (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void RemoveGraphAndDeleteAllData.<init>()"})
  void testNewRemoveGraphAndDeleteAllData() {
    // Arrange and Act
    RemoveGraphAndDeleteAllData actualRemoveGraphAndDeleteAllData =
        new RemoveGraphAndDeleteAllData();

    // Assert
    assertNull(actualRemoveGraphAndDeleteAllData.getGraphId());
    assertNull(actualRemoveGraphAndDeleteAllData.getOptions());
    assertFalse(actualRemoveGraphAndDeleteAllData.isUserRequestingAdminUsage());
    assertTrue(actualRemoveGraphAndDeleteAllData.isRemoveCache());
  }
}
