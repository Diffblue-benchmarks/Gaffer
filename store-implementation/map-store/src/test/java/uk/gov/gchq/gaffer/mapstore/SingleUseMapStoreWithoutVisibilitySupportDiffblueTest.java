package uk.gov.gchq.gaffer.mapstore;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
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
import uk.gov.gchq.gaffer.operation.OperationException;
import uk.gov.gchq.gaffer.serialisation.Serialiser;
import uk.gov.gchq.gaffer.store.Context;
import uk.gov.gchq.gaffer.store.Context.Builder;
import uk.gov.gchq.gaffer.store.StoreTrait;
import uk.gov.gchq.gaffer.store.TypeReferenceStoreImpl;
import uk.gov.gchq.gaffer.store.TypeReferenceStoreImpl.StoreTraits;
import uk.gov.gchq.gaffer.store.operation.GetTraits;
import uk.gov.gchq.gaffer.store.operation.handler.GetTraitsHandler;
import uk.gov.gchq.gaffer.store.operation.handler.OutputOperationHandler;
import uk.gov.gchq.gaffer.user.User;

class SingleUseMapStoreWithoutVisibilitySupportDiffblueTest {
  /**
   * Test {@link SingleUseMapStoreWithoutVisibilitySupport#getTraits()}.
   *
   * <p>Method under test: {@link SingleUseMapStoreWithoutVisibilitySupport#getTraits()}
   */
  @Test
  @DisplayName("Test getTraits()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set SingleUseMapStoreWithoutVisibilitySupport.getTraits()"})
  void testGetTraits() {
    // Arrange and Act
    Set<StoreTrait> actualTraits = new SingleUseMapStoreWithoutVisibilitySupport().getTraits();

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
   * Test {@link SingleUseMapStoreWithoutVisibilitySupport#getGetTraitsHandler()}.
   *
   * <p>Method under test: {@link SingleUseMapStoreWithoutVisibilitySupport#getGetTraitsHandler()}
   */
  @Test
  @DisplayName("Test getGetTraitsHandler()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "OutputOperationHandler SingleUseMapStoreWithoutVisibilitySupport.getGetTraitsHandler()"
  })
  void testGetGetTraitsHandler() {
    // Arrange
    SingleUseMapStoreWithoutVisibilitySupport singleUseMapStoreWithoutVisibilitySupport =
        new SingleUseMapStoreWithoutVisibilitySupport();

    // Act
    OutputOperationHandler<GetTraits, Set<StoreTrait>> actualGetTraitsHandler =
        singleUseMapStoreWithoutVisibilitySupport.getGetTraitsHandler();

    // Assert
    assertTrue(
        singleUseMapStoreWithoutVisibilitySupport.getAddElementsHandler()
            instanceof AddElementsHandler);
    assertTrue(
        singleUseMapStoreWithoutVisibilitySupport.getDeleteAllDataHandler()
            instanceof DeleteAllDataHandler);
    assertTrue(
        singleUseMapStoreWithoutVisibilitySupport.getDeleteElementsHandler()
            instanceof DeleteElementsHandler);
    assertTrue(
        singleUseMapStoreWithoutVisibilitySupport.getAdjacentIdsHandler()
            instanceof GetAdjacentIdsHandler);
    assertTrue(
        singleUseMapStoreWithoutVisibilitySupport.getGetAllElementsHandler()
            instanceof GetAllElementsHandler);
    assertTrue(
        singleUseMapStoreWithoutVisibilitySupport.getGetElementsHandler()
            instanceof GetElementsHandler);
    assertTrue(actualGetTraitsHandler instanceof GetTraitsHandler);
    assertNull(singleUseMapStoreWithoutVisibilitySupport.getGraphId());
    assertNull(singleUseMapStoreWithoutVisibilitySupport.getJobTracker());
    assertNull(singleUseMapStoreWithoutVisibilitySupport.getProperties());
    assertNull(singleUseMapStoreWithoutVisibilitySupport.getMapImpl());
    assertNull(singleUseMapStoreWithoutVisibilitySupport.getGraphLibrary());
    assertNull(singleUseMapStoreWithoutVisibilitySupport.getOriginalSchema());
    assertNull(singleUseMapStoreWithoutVisibilitySupport.getSchema());
    assertEquals(7, singleUseMapStoreWithoutVisibilitySupport.getTraits().size());
    assertTrue(singleUseMapStoreWithoutVisibilitySupport.getOperationChainOptimisers().isEmpty());
    assertTrue(singleUseMapStoreWithoutVisibilitySupport.getSupportedOperations().isEmpty());
    Class<MapStoreProperties> expectedPropertiesClass = MapStoreProperties.class;
    assertEquals(
        expectedPropertiesClass, singleUseMapStoreWithoutVisibilitySupport.getPropertiesClass());
    Class<Serialiser> expectedRequiredParentSerialiserClass = Serialiser.class;
    assertEquals(
        expectedRequiredParentSerialiserClass,
        singleUseMapStoreWithoutVisibilitySupport.getRequiredParentSerialiserClass());
  }

  /**
   * Test {@link SingleUseMapStoreWithoutVisibilitySupport#getGetTraitsHandler()}.
   *
   * <ul>
   *   <li>Then {@link MapStore} (default constructor) AddElementsHandler {@link
   *       AddElementsHandler}.
   * </ul>
   *
   * <p>Method under test: {@link SingleUseMapStoreWithoutVisibilitySupport#getGetTraitsHandler()}
   */
  @Test
  @DisplayName(
      "Test getGetTraitsHandler(); then MapStore (default constructor) AddElementsHandler AddElementsHandler")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "OutputOperationHandler SingleUseMapStoreWithoutVisibilitySupport.getGetTraitsHandler()"
  })
  void testGetGetTraitsHandler_thenMapStoreAddElementsHandlerAddElementsHandler()
      throws OperationException {
    // Arrange
    SingleUseMapStoreWithoutVisibilitySupport singleUseMapStoreWithoutVisibilitySupport =
        new SingleUseMapStoreWithoutVisibilitySupport();

    // Act
    OutputOperationHandler<GetTraits, Set<StoreTrait>> actualGetTraitsHandler =
        singleUseMapStoreWithoutVisibilitySupport.getGetTraitsHandler();
    GetTraits getTraits = new GetTraits();
    getTraits.setCurrentTraits(false);
    Builder builder = new Builder();
    Context context = builder.user(new User.Builder().userId("42").build()).build();
    MapStore mapStore = new MapStore();
    Set<StoreTrait> actualDoOperationResult =
        actualGetTraitsHandler.doOperation(getTraits, context, mapStore);

    // Assert
    assertTrue(mapStore.getAddElementsHandler() instanceof AddElementsHandler);
    assertTrue(
        singleUseMapStoreWithoutVisibilitySupport.getAddElementsHandler()
            instanceof AddElementsHandler);
    assertTrue(mapStore.getDeleteAllDataHandler() instanceof DeleteAllDataHandler);
    assertTrue(
        singleUseMapStoreWithoutVisibilitySupport.getDeleteAllDataHandler()
            instanceof DeleteAllDataHandler);
    assertTrue(mapStore.getDeleteElementsHandler() instanceof DeleteElementsHandler);
    assertTrue(
        singleUseMapStoreWithoutVisibilitySupport.getDeleteElementsHandler()
            instanceof DeleteElementsHandler);
    assertTrue(mapStore.getAdjacentIdsHandler() instanceof GetAdjacentIdsHandler);
    assertTrue(
        singleUseMapStoreWithoutVisibilitySupport.getAdjacentIdsHandler()
            instanceof GetAdjacentIdsHandler);
    assertTrue(mapStore.getGetAllElementsHandler() instanceof GetAllElementsHandler);
    assertTrue(
        singleUseMapStoreWithoutVisibilitySupport.getGetAllElementsHandler()
            instanceof GetAllElementsHandler);
    assertTrue(mapStore.getGetElementsHandler() instanceof GetElementsHandler);
    assertTrue(
        singleUseMapStoreWithoutVisibilitySupport.getGetElementsHandler()
            instanceof GetElementsHandler);
    assertTrue(getTraits.getOutputTypeReference() instanceof StoreTraits);
    assertTrue(mapStore.getGetTraitsHandler() instanceof GetTraitsHandler);
    assertTrue(actualGetTraitsHandler instanceof GetTraitsHandler);
    assertNull(mapStore.getGraphId());
    assertNull(singleUseMapStoreWithoutVisibilitySupport.getGraphId());
    assertNull(mapStore.getJobTracker());
    assertNull(singleUseMapStoreWithoutVisibilitySupport.getJobTracker());
    assertNull(mapStore.getProperties());
    assertNull(singleUseMapStoreWithoutVisibilitySupport.getProperties());
    assertNull(mapStore.getMapImpl());
    assertNull(singleUseMapStoreWithoutVisibilitySupport.getMapImpl());
    assertNull(context.getOriginalOpChain());
    assertNull(mapStore.getGraphLibrary());
    assertNull(singleUseMapStoreWithoutVisibilitySupport.getGraphLibrary());
    assertNull(mapStore.getOriginalSchema());
    assertNull(singleUseMapStoreWithoutVisibilitySupport.getOriginalSchema());
    assertNull(mapStore.getSchema());
    assertNull(singleUseMapStoreWithoutVisibilitySupport.getSchema());
    Set<StoreTrait> traits = singleUseMapStoreWithoutVisibilitySupport.getTraits();
    assertEquals(7, traits.size());
    assertFalse(getTraits.isCurrentTraits());
    assertTrue(context.getExporters().isEmpty());
    assertTrue(mapStore.getOperationChainOptimisers().isEmpty());
    assertTrue(singleUseMapStoreWithoutVisibilitySupport.getOperationChainOptimisers().isEmpty());
    assertTrue(context.getVariables().isEmpty());
    assertTrue(getTraits.getOptions().isEmpty());
    assertTrue(mapStore.getSupportedOperations().isEmpty());
    assertTrue(singleUseMapStoreWithoutVisibilitySupport.getSupportedOperations().isEmpty());
    assertEquals(traits, actualDoOperationResult);
    Class<Set> expectedOutputClass = Set.class;
    assertEquals(expectedOutputClass, getTraits.getOutputClass());
    Class<MapStoreProperties> expectedPropertiesClass = MapStoreProperties.class;
    Class<MapStoreProperties> propertiesClass =
        singleUseMapStoreWithoutVisibilitySupport.getPropertiesClass();
    assertEquals(expectedPropertiesClass, propertiesClass);
    Class<Serialiser> expectedRequiredParentSerialiserClass = Serialiser.class;
    Class<? extends Serialiser> requiredParentSerialiserClass =
        singleUseMapStoreWithoutVisibilitySupport.getRequiredParentSerialiserClass();
    assertEquals(expectedRequiredParentSerialiserClass, requiredParentSerialiserClass);
    assertSame(propertiesClass, mapStore.getPropertiesClass());
    assertSame(requiredParentSerialiserClass, mapStore.getRequiredParentSerialiserClass());
    assertSame(MapStore.TRAITS, mapStore.getTraits());
  }

  /**
   * Test new {@link SingleUseMapStoreWithoutVisibilitySupport} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link
   * SingleUseMapStoreWithoutVisibilitySupport}
   */
  @Test
  @DisplayName("Test new SingleUseMapStoreWithoutVisibilitySupport (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SingleUseMapStoreWithoutVisibilitySupport.<init>()"})
  void testNewSingleUseMapStoreWithoutVisibilitySupport() {
    // Arrange and Act
    SingleUseMapStoreWithoutVisibilitySupport actualSingleUseMapStoreWithoutVisibilitySupport =
        new SingleUseMapStoreWithoutVisibilitySupport();

    // Assert
    assertTrue(
        actualSingleUseMapStoreWithoutVisibilitySupport.getAddElementsHandler()
            instanceof AddElementsHandler);
    assertTrue(
        actualSingleUseMapStoreWithoutVisibilitySupport.getDeleteAllDataHandler()
            instanceof DeleteAllDataHandler);
    assertTrue(
        actualSingleUseMapStoreWithoutVisibilitySupport.getDeleteElementsHandler()
            instanceof DeleteElementsHandler);
    assertTrue(
        actualSingleUseMapStoreWithoutVisibilitySupport.getAdjacentIdsHandler()
            instanceof GetAdjacentIdsHandler);
    assertTrue(
        actualSingleUseMapStoreWithoutVisibilitySupport.getGetAllElementsHandler()
            instanceof GetAllElementsHandler);
    assertTrue(
        actualSingleUseMapStoreWithoutVisibilitySupport.getGetElementsHandler()
            instanceof GetElementsHandler);
    assertTrue(
        actualSingleUseMapStoreWithoutVisibilitySupport.getGetTraitsHandler()
            instanceof GetTraitsHandler);
    assertNull(actualSingleUseMapStoreWithoutVisibilitySupport.getGraphId());
    assertNull(actualSingleUseMapStoreWithoutVisibilitySupport.getJobTracker());
    assertNull(actualSingleUseMapStoreWithoutVisibilitySupport.getProperties());
    assertNull(actualSingleUseMapStoreWithoutVisibilitySupport.getMapImpl());
    assertNull(actualSingleUseMapStoreWithoutVisibilitySupport.getGraphLibrary());
    assertNull(actualSingleUseMapStoreWithoutVisibilitySupport.getOriginalSchema());
    assertNull(actualSingleUseMapStoreWithoutVisibilitySupport.getSchema());
    assertEquals(7, actualSingleUseMapStoreWithoutVisibilitySupport.getTraits().size());
    assertTrue(
        actualSingleUseMapStoreWithoutVisibilitySupport.getOperationChainOptimisers().isEmpty());
    assertTrue(actualSingleUseMapStoreWithoutVisibilitySupport.getSupportedOperations().isEmpty());
    Class<MapStoreProperties> expectedPropertiesClass = MapStoreProperties.class;
    assertEquals(
        expectedPropertiesClass,
        actualSingleUseMapStoreWithoutVisibilitySupport.getPropertiesClass());
    Class<Serialiser> expectedRequiredParentSerialiserClass = Serialiser.class;
    assertEquals(
        expectedRequiredParentSerialiserClass,
        actualSingleUseMapStoreWithoutVisibilitySupport.getRequiredParentSerialiserClass());
  }
}
