package uk.gov.gchq.gaffer.mapstore;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
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
import uk.gov.gchq.gaffer.store.StoreException;
import uk.gov.gchq.gaffer.store.StoreProperties;
import uk.gov.gchq.gaffer.store.operation.handler.GetTraitsHandler;
import uk.gov.gchq.gaffer.store.schema.Schema;

class SingleUseMapStoreDiffblueTest {
  /**
   * Test {@link SingleUseMapStore#initialise(String, Schema, StoreProperties)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link SingleUseMapStore#initialise(String, Schema, StoreProperties)}
   */
  @Test
  @DisplayName(
      "Test initialise(String, Schema, StoreProperties); when 'null'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SingleUseMapStore.initialise(String, Schema, StoreProperties)"})
  void testInitialise_whenNull_thenThrowIllegalArgumentException() throws StoreException {
    // Arrange
    SingleUseMapStore singleUseMapStore = new SingleUseMapStore();
    Schema schema = new Schema();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> singleUseMapStore.initialise(null, schema, new StoreProperties()));
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
