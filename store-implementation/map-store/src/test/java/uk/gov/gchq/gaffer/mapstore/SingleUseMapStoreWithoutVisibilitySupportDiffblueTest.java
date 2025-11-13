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

class SingleUseMapStoreWithoutVisibilitySupportDiffblueTest {
  /**
   * Test {@link SingleUseMapStoreWithoutVisibilitySupport#getTraits()}.
   * <p>
   * Method under test: {@link SingleUseMapStoreWithoutVisibilitySupport#getTraits()}
   */
  @Test
  @DisplayName("Test getTraits()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Set SingleUseMapStoreWithoutVisibilitySupport.getTraits()"})
  void testGetTraits() {
    // Arrange and Act
    Set<StoreTrait> actualTraits = (new SingleUseMapStoreWithoutVisibilitySupport()).getTraits();

    // Assert
    assertEquals(7, actualTraits.size());
    assertTrue(actualTraits.contains(StoreTrait.INGEST_AGGREGATION));
    assertTrue(actualTraits.contains(StoreTrait.MATCHED_VERTEX));
    assertTrue(actualTraits.contains(StoreTrait.POST_AGGREGATION_FILTERING));
    assertTrue(actualTraits.contains(StoreTrait.POST_TRANSFORMATION_FILTERING));
    assertTrue(actualTraits.contains(StoreTrait.PRE_AGGREGATION_FILTERING));
    assertTrue(actualTraits.contains(StoreTrait.QUERY_AGGREGATION));
    assertTrue(actualTraits.contains(StoreTrait.TRANSFORMATION));
  }

  /**
   * Test new {@link SingleUseMapStoreWithoutVisibilitySupport} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of {@link SingleUseMapStoreWithoutVisibilitySupport}
   */
  @Test
  @DisplayName("Test new SingleUseMapStoreWithoutVisibilitySupport (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void SingleUseMapStoreWithoutVisibilitySupport.<init>()"})
  void testNewSingleUseMapStoreWithoutVisibilitySupport() {
    // Arrange and Act
    SingleUseMapStoreWithoutVisibilitySupport actualSingleUseMapStoreWithoutVisibilitySupport = new SingleUseMapStoreWithoutVisibilitySupport();

    // Assert
    assertTrue(actualSingleUseMapStoreWithoutVisibilitySupport.getAddElementsHandler() instanceof AddElementsHandler);
    assertTrue(
        actualSingleUseMapStoreWithoutVisibilitySupport.getDeleteAllDataHandler() instanceof DeleteAllDataHandler);
    assertTrue(
        actualSingleUseMapStoreWithoutVisibilitySupport.getDeleteElementsHandler() instanceof DeleteElementsHandler);
    assertTrue(
        actualSingleUseMapStoreWithoutVisibilitySupport.getAdjacentIdsHandler() instanceof GetAdjacentIdsHandler);
    assertTrue(
        actualSingleUseMapStoreWithoutVisibilitySupport.getGetAllElementsHandler() instanceof GetAllElementsHandler);
    assertTrue(actualSingleUseMapStoreWithoutVisibilitySupport.getGetElementsHandler() instanceof GetElementsHandler);
    assertTrue(actualSingleUseMapStoreWithoutVisibilitySupport.getGetTraitsHandler() instanceof GetTraitsHandler);
    assertNull(actualSingleUseMapStoreWithoutVisibilitySupport.getGraphId());
    assertNull(actualSingleUseMapStoreWithoutVisibilitySupport.getJobTracker());
    assertNull(actualSingleUseMapStoreWithoutVisibilitySupport.getProperties());
    assertNull(actualSingleUseMapStoreWithoutVisibilitySupport.getMapImpl());
    assertNull(actualSingleUseMapStoreWithoutVisibilitySupport.getGraphLibrary());
    assertNull(actualSingleUseMapStoreWithoutVisibilitySupport.getOriginalSchema());
    assertNull(actualSingleUseMapStoreWithoutVisibilitySupport.getSchema());
    assertEquals(7, actualSingleUseMapStoreWithoutVisibilitySupport.getTraits().size());
    assertTrue(actualSingleUseMapStoreWithoutVisibilitySupport.getOperationChainOptimisers().isEmpty());
    assertTrue(actualSingleUseMapStoreWithoutVisibilitySupport.getSupportedOperations().isEmpty());
    Class<MapStoreProperties> expectedPropertiesClass = MapStoreProperties.class;
    assertEquals(expectedPropertiesClass, actualSingleUseMapStoreWithoutVisibilitySupport.getPropertiesClass());
    Class<Serialiser> expectedRequiredParentSerialiserClass = Serialiser.class;
    assertEquals(expectedRequiredParentSerialiserClass,
        actualSingleUseMapStoreWithoutVisibilitySupport.getRequiredParentSerialiserClass());
  }
}
