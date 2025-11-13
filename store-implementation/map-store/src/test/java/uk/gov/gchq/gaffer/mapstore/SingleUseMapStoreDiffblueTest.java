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

package uk.gov.gchq.gaffer.mapstore;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.verify;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import uk.gov.gchq.gaffer.mapstore.impl.AddElementsHandler;
import uk.gov.gchq.gaffer.mapstore.impl.DeleteAllDataHandler;
import uk.gov.gchq.gaffer.mapstore.impl.DeleteElementsHandler;
import uk.gov.gchq.gaffer.mapstore.impl.GetAdjacentIdsHandler;
import uk.gov.gchq.gaffer.mapstore.impl.GetAllElementsHandler;
import uk.gov.gchq.gaffer.mapstore.impl.GetElementsHandler;
import uk.gov.gchq.gaffer.mapstore.impl.MapImpl;
import uk.gov.gchq.gaffer.serialisation.Serialiser;
import uk.gov.gchq.gaffer.store.StoreException;
import uk.gov.gchq.gaffer.store.StoreProperties;
import uk.gov.gchq.gaffer.store.operation.handler.GetTraitsHandler;
import uk.gov.gchq.gaffer.store.schema.Schema;

@ExtendWith(MockitoExtension.class)
class SingleUseMapStoreDiffblueTest {
  @Mock private MapImpl mapImpl;

  @Mock private Schema schema;

  @InjectMocks private SingleUseMapStore singleUseMapStore;

  /**
   * Test {@link SingleUseMapStore#initialise(String, Schema, StoreProperties)}.
   *
   * <ul>
   *   <li>Given {@link MapImpl} {@link MapImpl#clear()} throw {@link
   *       RuntimeException#RuntimeException()}.
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link SingleUseMapStore#initialise(String, Schema, StoreProperties)}
   */
  @Test
  @DisplayName(
      "Test initialise(String, Schema, StoreProperties); given MapImpl clear() throw RuntimeException(); then throw RuntimeException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SingleUseMapStore.initialise(String, Schema, StoreProperties)"})
  void testInitialise_givenMapImplClearThrowRuntimeException_thenThrowRuntimeException()
      throws StoreException {
    // Arrange
    doThrow(new RuntimeException()).when(mapImpl).clear();

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> singleUseMapStore.initialise("42", schema, new StoreProperties()));
    verify(mapImpl).clear();
  }

  /**
   * Test new {@link SingleUseMapStore} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link SingleUseMapStore}
   */
  @Test
  @DisplayName("Test new SingleUseMapStore (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SingleUseMapStore.<init>()"})
  void testNewSingleUseMapStore() {
    // Arrange and Act
    SingleUseMapStore actualSingleUseMapStore = new SingleUseMapStore();

    // Assert
    assertTrue(actualSingleUseMapStore.getAddElementsHandler() instanceof AddElementsHandler);
    assertTrue(actualSingleUseMapStore.getDeleteAllDataHandler() instanceof DeleteAllDataHandler);
    assertTrue(actualSingleUseMapStore.getDeleteElementsHandler() instanceof DeleteElementsHandler);
    assertTrue(actualSingleUseMapStore.getAdjacentIdsHandler() instanceof GetAdjacentIdsHandler);
    assertTrue(actualSingleUseMapStore.getGetAllElementsHandler() instanceof GetAllElementsHandler);
    assertTrue(actualSingleUseMapStore.getGetElementsHandler() instanceof GetElementsHandler);
    assertTrue(actualSingleUseMapStore.getGetTraitsHandler() instanceof GetTraitsHandler);
    assertNull(actualSingleUseMapStore.getGraphId());
    assertNull(actualSingleUseMapStore.getJobTracker());
    assertNull(actualSingleUseMapStore.getProperties());
    assertNull(actualSingleUseMapStore.getMapImpl());
    assertNull(actualSingleUseMapStore.getGraphLibrary());
    assertNull(actualSingleUseMapStore.getOriginalSchema());
    assertNull(actualSingleUseMapStore.getSchema());
    assertTrue(actualSingleUseMapStore.getOperationChainOptimisers().isEmpty());
    assertTrue(actualSingleUseMapStore.getSupportedOperations().isEmpty());
    Class<MapStoreProperties> expectedPropertiesClass = MapStoreProperties.class;
    assertEquals(expectedPropertiesClass, actualSingleUseMapStore.getPropertiesClass());
    Class<Serialiser> expectedRequiredParentSerialiserClass = Serialiser.class;
    assertEquals(
        expectedRequiredParentSerialiserClass,
        actualSingleUseMapStore.getRequiredParentSerialiserClass());
    assertSame(MapStore.TRAITS, actualSingleUseMapStore.getTraits());
  }
}
