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

package uk.gov.gchq.gaffer.store.operation.handler;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.operation.OperationException;
import uk.gov.gchq.gaffer.serialisation.ToBytesSerialiser;
import uk.gov.gchq.gaffer.store.Context;
import uk.gov.gchq.gaffer.store.Context.Builder;
import uk.gov.gchq.gaffer.store.StoreTrait;
import uk.gov.gchq.gaffer.store.TypeReferenceStoreImpl;
import uk.gov.gchq.gaffer.store.TypeReferenceStoreImpl.StoreTraits;
import uk.gov.gchq.gaffer.store.operation.GetTraits;
import uk.gov.gchq.gaffer.user.User;

class GetTraitsHandlerDiffblueTest {
  /**
   * Test {@link GetTraitsHandler#GetTraitsHandler(Set)}.
   *
   * <ul>
   *   <li>When {@link HashSet#HashSet()}.
   *   <li>Then {@link GetTraits} (default constructor) OutputTypeReference {@link
   *       TypeReferenceStoreImpl.StoreTraits}.
   * </ul>
   *
   * <p>Method under test: {@link GetTraitsHandler#GetTraitsHandler(Set)}
   */
  @Test
  @DisplayName(
      "Test new GetTraitsHandler(Set); when HashSet(); then GetTraits (default constructor) OutputTypeReference StoreTraits")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void GetTraitsHandler.<init>(Set)"})
  void testNewGetTraitsHandler_whenHashSet_thenGetTraitsOutputTypeReferenceStoreTraits()
      throws OperationException {
    // Arrange
    HashSet<StoreTrait> storeTraits = new HashSet<>();

    // Act
    GetTraitsHandler actualGetTraitsHandler = new GetTraitsHandler(storeTraits);
    GetTraits operation = new GetTraits();
    operation.setCurrentTraits(false);
    Builder builder = new Builder();
    Context context = builder.user(new User.Builder().userId("42").build()).build();
    TestAddToGraphLibraryImpl store = new TestAddToGraphLibraryImpl();
    Set<StoreTrait> actualDoOperationResult =
        actualGetTraitsHandler.doOperation(operation, context, store);

    // Assert
    assertTrue(operation.getOutputTypeReference() instanceof StoreTraits);
    assertTrue(store.getGetTraitsHandler() instanceof GetTraitsHandler);
    assertNull(store.getGraphId());
    assertNull(store.getJobTracker());
    assertNull(context.getOriginalOpChain());
    assertNull(store.getProperties());
    assertNull(store.getGraphLibrary());
    assertNull(store.getAddElementsHandler());
    assertNull(store.getDeleteAllDataHandler());
    assertNull(store.getDeleteElementsHandler());
    assertNull(store.getAdjacentIdsHandler());
    assertNull(store.getGetAllElementsHandler());
    assertNull(store.getGetElementsHandler());
    assertNull(store.getOriginalSchema());
    assertNull(store.getSchema());
    assertFalse(operation.isCurrentTraits());
    assertTrue(context.getExporters().isEmpty());
    assertTrue(storeTraits.isEmpty());
    assertTrue(store.getOperationChainOptimisers().isEmpty());
    assertTrue(context.getVariables().isEmpty());
    assertTrue(operation.getOptions().isEmpty());
    assertTrue(store.getSupportedOperations().isEmpty());
    assertTrue(actualDoOperationResult.isEmpty());
    Class<Set> expectedOutputClass = Set.class;
    assertEquals(expectedOutputClass, operation.getOutputClass());
    Class<ToBytesSerialiser> expectedRequiredParentSerialiserClass = ToBytesSerialiser.class;
    assertEquals(expectedRequiredParentSerialiserClass, store.getRequiredParentSerialiserClass());
  }

  /**
   * Test {@link GetTraitsHandler#GetTraitsHandler(Set)}.
   *
   * <ul>
   *   <li>When {@link HashSet#HashSet()}.
   *   <li>Then {@link HashSet#HashSet()} Empty.
   * </ul>
   *
   * <p>Method under test: {@link GetTraitsHandler#GetTraitsHandler(Set)}
   */
  @Test
  @DisplayName("Test new GetTraitsHandler(Set); when HashSet(); then HashSet() Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void GetTraitsHandler.<init>(Set)"})
  void testNewGetTraitsHandler_whenHashSet_thenHashSetEmpty() {
    // Arrange
    HashSet<StoreTrait> storeTraits = new HashSet<>();

    // Act
    new GetTraitsHandler(storeTraits);

    // Assert that nothing has changed
    assertTrue(storeTraits.isEmpty());
  }
}
