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

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashSet;
import org.apache.commons.lang3.exception.CloneFailedException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.federatedstore.operation.AddGraphWithHooks.AddGraphWithHooksBuilder;
import uk.gov.gchq.gaffer.federatedstore.operation.AddGraphWithHooks.Builder;
import uk.gov.gchq.gaffer.graph.hook.AddOperationsToChain;
import uk.gov.gchq.gaffer.graph.hook.GraphHook;

class AddGraphWithHooksDiffblueTest {
  /**
   * Test AddGraphWithHooksBuilder {@link AddGraphWithHooksBuilder#hooks(GraphHook[])}.
   *
   * <p>Method under test: {@link AddGraphWithHooksBuilder#hooks(GraphHook[])}
   */
  @Test
  @DisplayName("Test AddGraphWithHooksBuilder hooks(GraphHook[])")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"AddGraphWithHooksBuilder AddGraphWithHooksBuilder.hooks(GraphHook[])"})
  void testAddGraphWithHooksBuilderHooks() {
    // Arrange
    Builder builder = new Builder();

    // Act
    Builder actualHooksResult = builder.hooks(new AddOperationsToChain());

    // Assert
    assertSame(builder, actualHooksResult);
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
    AddGraphWithHooks _getOpResult = actualBuilder._getOp();
    assertNull(_getOpResult.getGraphId());
    assertNull(_getOpResult.getParentPropertiesId());
    assertNull(_getOpResult.getParentSchemaIds());
    assertNull(_getOpResult.getOptions());
    assertNull(_getOpResult.getProperties());
    assertNull(_getOpResult.getGraphAuths());
    assertNull(_getOpResult.getReadAccessPredicate());
    assertNull(_getOpResult.getWriteAccessPredicate());
    assertNull(_getOpResult.getHooks());
    assertNull(_getOpResult.getStoreProperties());
    assertNull(_getOpResult.getSchema());
    assertFalse(_getOpResult.getIsPublic());
    assertFalse(_getOpResult.isUserRequestingAdminUsage());
    AddGraphWithHooks actualAddGraphWithHooks = actualBuilder.build();
    assertSame(_getOpResult, actualAddGraphWithHooks);
  }

  /**
   * Test {@link AddGraphWithHooks#shallowClone()}.
   *
   * <ul>
   *   <li>Given {@link AddGraphWithHooks} (default constructor).
   *   <li>Then return GraphAuths is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link AddGraphWithHooks#shallowClone()}
   */
  @Test
  @DisplayName(
      "Test shallowClone(); given AddGraphWithHooks (default constructor); then return GraphAuths is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"AddGraphWithHooks AddGraphWithHooks.shallowClone()"})
  void testShallowClone_givenAddGraphWithHooks_thenReturnGraphAuthsIsNull()
      throws CloneFailedException {
    // Arrange and Act
    AddGraphWithHooks actualShallowCloneResult = new AddGraphWithHooks().shallowClone();

    // Assert
    assertNull(actualShallowCloneResult.getGraphId());
    assertNull(actualShallowCloneResult.getParentPropertiesId());
    assertNull(actualShallowCloneResult.getParentSchemaIds());
    assertNull(actualShallowCloneResult.getOptions());
    assertNull(actualShallowCloneResult.getProperties());
    assertNull(actualShallowCloneResult.getGraphAuths());
    assertNull(actualShallowCloneResult.getReadAccessPredicate());
    assertNull(actualShallowCloneResult.getWriteAccessPredicate());
    assertNull(actualShallowCloneResult.getHooks());
    assertNull(actualShallowCloneResult.getStoreProperties());
    assertNull(actualShallowCloneResult.getSchema());
    assertFalse(actualShallowCloneResult.getIsPublic());
    assertFalse(actualShallowCloneResult.isUserRequestingAdminUsage());
  }

  /**
   * Test {@link AddGraphWithHooks#shallowClone()}.
   *
   * <ul>
   *   <li>Then return GraphAuths Empty.
   * </ul>
   *
   * <p>Method under test: {@link AddGraphWithHooks#shallowClone()}
   */
  @Test
  @DisplayName("Test shallowClone(); then return GraphAuths Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"AddGraphWithHooks AddGraphWithHooks.shallowClone()"})
  void testShallowClone_thenReturnGraphAuthsEmpty() throws CloneFailedException {
    // Arrange
    AddGraphWithHooks addGraphWithHooks = new AddGraphWithHooks();
    addGraphWithHooks.setGraphAuths(new HashSet<>());

    // Act
    AddGraphWithHooks actualShallowCloneResult = addGraphWithHooks.shallowClone();

    // Assert
    assertNull(actualShallowCloneResult.getGraphId());
    assertNull(actualShallowCloneResult.getParentPropertiesId());
    assertNull(actualShallowCloneResult.getParentSchemaIds());
    assertNull(actualShallowCloneResult.getOptions());
    assertNull(actualShallowCloneResult.getProperties());
    assertNull(actualShallowCloneResult.getReadAccessPredicate());
    assertNull(actualShallowCloneResult.getWriteAccessPredicate());
    assertNull(actualShallowCloneResult.getHooks());
    assertNull(actualShallowCloneResult.getStoreProperties());
    assertNull(actualShallowCloneResult.getSchema());
    assertFalse(actualShallowCloneResult.getIsPublic());
    assertFalse(actualShallowCloneResult.isUserRequestingAdminUsage());
    assertTrue(actualShallowCloneResult.getGraphAuths().isEmpty());
  }
}
