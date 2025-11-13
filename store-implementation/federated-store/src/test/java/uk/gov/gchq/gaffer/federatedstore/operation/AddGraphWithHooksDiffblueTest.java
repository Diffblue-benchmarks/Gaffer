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

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
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
   * <p>
   * Method under test: {@link AddGraphWithHooksBuilder#hooks(GraphHook[])}
   */
  @Test
  @DisplayName("Test AddGraphWithHooksBuilder hooks(GraphHook[])")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"AddGraphWithHooksBuilder AddGraphWithHooksBuilder.hooks(GraphHook[])"})
  void testAddGraphWithHooksBuilderHooks() {
    // Arrange
    Builder builder = new Builder();

    // Act and Assert
    assertSame(builder, builder.hooks(new AddOperationsToChain()));
  }

  /**
   * Test Builder new {@link Builder} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of {@link Builder}
   */
  @Test
  @DisplayName("Test Builder new Builder (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Builder.<init>()"})
  void testBuilderNewBuilder() {
    // Arrange and Act
    Builder actualBuilder = new Builder();

    // Assert
    AddGraphWithHooks _getOpResult = actualBuilder._getOp();
    assertNull(_getOpResult.getHooks());
    assertNull(_getOpResult.getGraphId());
    assertNull(_getOpResult.getParentPropertiesId());
    assertNull(_getOpResult.getParentSchemaIds());
    assertNull(_getOpResult.getOptions());
    assertNull(_getOpResult.getProperties());
    assertNull(_getOpResult.getGraphAuths());
    assertNull(_getOpResult.getReadAccessPredicate());
    assertNull(_getOpResult.getWriteAccessPredicate());
    assertNull(_getOpResult.getStoreProperties());
    assertNull(_getOpResult.getSchema());
    assertFalse(_getOpResult.getIsPublic());
    assertFalse(_getOpResult.isUserRequestingAdminUsage());
    assertSame(_getOpResult, actualBuilder.build());
  }

  /**
   * Test {@link AddGraphWithHooks#shallowClone()}.
   * <ul>
   *   <li>Given {@link AddGraphWithHooks} (default constructor).</li>
   *   <li>Then return GraphAuths is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AddGraphWithHooks#shallowClone()}
   */
  @Test
  @DisplayName("Test shallowClone(); given AddGraphWithHooks (default constructor); then return GraphAuths is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"AddGraphWithHooks AddGraphWithHooks.shallowClone()"})
  void testShallowClone_givenAddGraphWithHooks_thenReturnGraphAuthsIsNull() throws CloneFailedException {
    // Arrange and Act
    AddGraphWithHooks actualShallowCloneResult = (new AddGraphWithHooks()).shallowClone();

    // Assert
    assertNull(actualShallowCloneResult.getHooks());
    assertNull(actualShallowCloneResult.getGraphId());
    assertNull(actualShallowCloneResult.getParentPropertiesId());
    assertNull(actualShallowCloneResult.getParentSchemaIds());
    assertNull(actualShallowCloneResult.getOptions());
    assertNull(actualShallowCloneResult.getProperties());
    assertNull(actualShallowCloneResult.getGraphAuths());
    assertNull(actualShallowCloneResult.getReadAccessPredicate());
    assertNull(actualShallowCloneResult.getWriteAccessPredicate());
    assertNull(actualShallowCloneResult.getStoreProperties());
    assertNull(actualShallowCloneResult.getSchema());
    assertFalse(actualShallowCloneResult.getIsPublic());
    assertFalse(actualShallowCloneResult.isUserRequestingAdminUsage());
  }

  /**
   * Test {@link AddGraphWithHooks#shallowClone()}.
   * <ul>
   *   <li>Then return GraphAuths Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link AddGraphWithHooks#shallowClone()}
   */
  @Test
  @DisplayName("Test shallowClone(); then return GraphAuths Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"AddGraphWithHooks AddGraphWithHooks.shallowClone()"})
  void testShallowClone_thenReturnGraphAuthsEmpty() throws CloneFailedException {
    // Arrange
    AddGraphWithHooks addGraphWithHooks = new AddGraphWithHooks();
    addGraphWithHooks.setGraphAuths(new HashSet<>());

    // Act
    AddGraphWithHooks actualShallowCloneResult = addGraphWithHooks.shallowClone();

    // Assert
    assertNull(actualShallowCloneResult.getHooks());
    assertNull(actualShallowCloneResult.getGraphId());
    assertNull(actualShallowCloneResult.getParentPropertiesId());
    assertNull(actualShallowCloneResult.getParentSchemaIds());
    assertNull(actualShallowCloneResult.getOptions());
    assertNull(actualShallowCloneResult.getProperties());
    assertNull(actualShallowCloneResult.getReadAccessPredicate());
    assertNull(actualShallowCloneResult.getWriteAccessPredicate());
    assertNull(actualShallowCloneResult.getStoreProperties());
    assertNull(actualShallowCloneResult.getSchema());
    assertFalse(actualShallowCloneResult.getIsPublic());
    assertFalse(actualShallowCloneResult.isUserRequestingAdminUsage());
    assertTrue(actualShallowCloneResult.getGraphAuths().isEmpty());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link AddGraphWithHooks}
   *   <li>{@link AddGraphWithHooks#setHooks(GraphHook[])}
   *   <li>{@link AddGraphWithHooks#getHooks()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void AddGraphWithHooks.<init>()", "GraphHook[] AddGraphWithHooks.getHooks()",
      "void AddGraphWithHooks.setHooks(GraphHook[])"})
  void testGettersAndSetters() {
    // Arrange and Act
    AddGraphWithHooks actualAddGraphWithHooks = new AddGraphWithHooks();
    GraphHook[] hooks = new GraphHook[]{new AddOperationsToChain()};
    actualAddGraphWithHooks.setHooks(hooks);
    GraphHook[] actualHooks = actualAddGraphWithHooks.getHooks();

    // Assert
    assertNull(actualAddGraphWithHooks.getGraphId());
    assertNull(actualAddGraphWithHooks.getParentPropertiesId());
    assertNull(actualAddGraphWithHooks.getParentSchemaIds());
    assertNull(actualAddGraphWithHooks.getOptions());
    assertNull(actualAddGraphWithHooks.getGraphAuths());
    assertNull(actualAddGraphWithHooks.getReadAccessPredicate());
    assertNull(actualAddGraphWithHooks.getWriteAccessPredicate());
    assertNull(actualAddGraphWithHooks.getStoreProperties());
    assertNull(actualAddGraphWithHooks.getSchema());
    assertFalse(actualAddGraphWithHooks.getIsPublic());
    assertFalse(actualAddGraphWithHooks.isUserRequestingAdminUsage());
    assertSame(hooks, actualHooks);
  }
}
