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
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Set;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.mapstore.impl.AddElementsHandler;
import uk.gov.gchq.gaffer.mapstore.impl.DeleteAllDataHandler;
import uk.gov.gchq.gaffer.mapstore.impl.DeleteElementsHandler;
import uk.gov.gchq.gaffer.mapstore.impl.GetAdjacentIdsHandler;
import uk.gov.gchq.gaffer.mapstore.impl.GetAllElementsHandler;
import uk.gov.gchq.gaffer.mapstore.impl.GetElementsHandler;
import uk.gov.gchq.gaffer.serialisation.Serialiser;
import uk.gov.gchq.gaffer.store.StoreTrait;
import uk.gov.gchq.gaffer.store.operation.handler.GetTraitsHandler;

class SingleUseMapStoreDiffblueTest {
  /**
   * Test new {@link SingleUseMapStore} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of {@link SingleUseMapStore}
   */
  @Test
  @DisplayName("Test new SingleUseMapStore (default constructor)")
  @Tag("MaintainedByDiffblue")
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
    assertEquals(expectedRequiredParentSerialiserClass, actualSingleUseMapStore.getRequiredParentSerialiserClass());
    Set<StoreTrait> expectedTraits = actualSingleUseMapStore.TRAITS;
    assertSame(expectedTraits, actualSingleUseMapStore.getTraits());
  }
}
