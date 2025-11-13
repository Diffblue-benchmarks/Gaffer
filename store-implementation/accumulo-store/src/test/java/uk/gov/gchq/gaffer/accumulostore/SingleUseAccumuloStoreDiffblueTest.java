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

package uk.gov.gchq.gaffer.accumulostore;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.accumulostore.operation.handler.AddElementsHandler;
import uk.gov.gchq.gaffer.accumulostore.operation.handler.DeleteAllDataHandler;
import uk.gov.gchq.gaffer.accumulostore.operation.handler.DeleteElementsHandler;
import uk.gov.gchq.gaffer.accumulostore.operation.handler.GetAdjacentIdsHandler;
import uk.gov.gchq.gaffer.accumulostore.operation.handler.GetAllElementsHandler;
import uk.gov.gchq.gaffer.accumulostore.operation.handler.GetElementsHandler;
import uk.gov.gchq.gaffer.serialisation.ToBytesSerialiser;
import uk.gov.gchq.gaffer.store.operation.handler.GetTraitsHandler;

class SingleUseAccumuloStoreDiffblueTest {
  /**
   * Test new {@link SingleUseAccumuloStore} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of {@link SingleUseAccumuloStore}
   */
  @Test
  @DisplayName("Test new SingleUseAccumuloStore (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void SingleUseAccumuloStore.<init>()"})
  void testNewSingleUseAccumuloStore() {
    // Arrange and Act
    SingleUseAccumuloStore actualSingleUseAccumuloStore = new SingleUseAccumuloStore();

    // Assert
    assertTrue(actualSingleUseAccumuloStore.getAddElementsHandler() instanceof AddElementsHandler);
    assertTrue(actualSingleUseAccumuloStore.getDeleteAllDataHandler() instanceof DeleteAllDataHandler);
    assertTrue(actualSingleUseAccumuloStore.getDeleteElementsHandler() instanceof DeleteElementsHandler);
    assertTrue(actualSingleUseAccumuloStore.getAdjacentIdsHandler() instanceof GetAdjacentIdsHandler);
    assertTrue(actualSingleUseAccumuloStore.getGetAllElementsHandler() instanceof GetAllElementsHandler);
    assertTrue(actualSingleUseAccumuloStore.getGetElementsHandler() instanceof GetElementsHandler);
    assertTrue(actualSingleUseAccumuloStore.getGetTraitsHandler() instanceof GetTraitsHandler);
    assertNull(actualSingleUseAccumuloStore.getGraphId());
    assertNull(actualSingleUseAccumuloStore.getProperties());
    assertNull(actualSingleUseAccumuloStore.getKeyPackage());
    assertNull(actualSingleUseAccumuloStore.getJobTracker());
    assertNull(actualSingleUseAccumuloStore.getGraphLibrary());
    assertNull(actualSingleUseAccumuloStore.getOriginalSchema());
    assertNull(actualSingleUseAccumuloStore.getSchema());
    assertTrue(actualSingleUseAccumuloStore.getOperationChainOptimisers().isEmpty());
    assertTrue(actualSingleUseAccumuloStore.getSupportedOperations().isEmpty());
    Class<AccumuloProperties> expectedPropertiesClass = AccumuloProperties.class;
    assertEquals(expectedPropertiesClass, actualSingleUseAccumuloStore.getPropertiesClass());
    Class<ToBytesSerialiser> expectedRequiredParentSerialiserClass = ToBytesSerialiser.class;
    assertEquals(expectedRequiredParentSerialiserClass,
        actualSingleUseAccumuloStore.getRequiredParentSerialiserClass());
  }
}
