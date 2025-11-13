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

package uk.gov.gchq.gaffer.federated.simple;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.accumulostore.operation.impl.GetElementsBetweenSets;
import uk.gov.gchq.gaffer.data.element.Element;
import uk.gov.gchq.gaffer.federated.simple.operation.AddGraph;
import uk.gov.gchq.gaffer.federated.simple.operation.FederatedOperationChainValidator;
import uk.gov.gchq.gaffer.federated.simple.operation.handler.FederatedOperationHandler;
import uk.gov.gchq.gaffer.federated.simple.operation.handler.FederatedOutputHandler;
import uk.gov.gchq.gaffer.operation.Operation;
import uk.gov.gchq.gaffer.operation.OperationChain;
import uk.gov.gchq.gaffer.operation.OperationException;
import uk.gov.gchq.gaffer.operation.impl.delete.DeleteElements;
import uk.gov.gchq.gaffer.operation.impl.get.GetAllElements;
import uk.gov.gchq.gaffer.operation.impl.get.GetElements;
import uk.gov.gchq.gaffer.serialisation.Serialiser;
import uk.gov.gchq.gaffer.serialisation.ToBytesSerialiser;
import uk.gov.gchq.gaffer.store.Context;
import uk.gov.gchq.gaffer.store.Context.Builder;
import uk.gov.gchq.gaffer.store.StoreProperties;
import uk.gov.gchq.gaffer.store.StoreTrait;
import uk.gov.gchq.gaffer.store.operation.DeleteAllData;
import uk.gov.gchq.gaffer.store.operation.GetTraits;
import uk.gov.gchq.gaffer.store.operation.handler.OperationHandler;
import uk.gov.gchq.gaffer.store.operation.handler.OutputOperationHandler;
import uk.gov.gchq.gaffer.user.User;

class FederatedStoreDiffblueTest {
  /**
   * Test {@link FederatedStore#getDefaultGraphIds()}.
   * <ul>
   *   <li>Given {@link FederatedStore} (default constructor).</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link FederatedStore#getDefaultGraphIds()}
   */
  @Test
  @DisplayName("Test getDefaultGraphIds(); given FederatedStore (default constructor); then return Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List FederatedStore.getDefaultGraphIds()"})
  void testGetDefaultGraphIds_givenFederatedStore_thenReturnEmpty() {
    // Arrange, Act and Assert
    assertTrue((new FederatedStore()).getDefaultGraphIds().isEmpty());
  }

  /**
   * Test {@link FederatedStore#getStoreSpecificOperations()}.
   * <p>
   * Method under test: {@link FederatedStore#getStoreSpecificOperations()}
   */
  @Test
  @DisplayName("Test getStoreSpecificOperations()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Set FederatedStore.getStoreSpecificOperations()"})
  void testGetStoreSpecificOperations() {
    // Arrange, Act and Assert
    assertEquals(8, (new FederatedStore()).getStoreSpecificOperations().size());
  }

  /**
   * Test {@link FederatedStore#doUnhandledOperation(Operation, Context)}.
   * <ul>
   *   <li>Given {@link HashMap#HashMap()}.</li>
   *   <li>When {@link GetElementsBetweenSets} (default constructor) Options is {@link HashMap#HashMap()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FederatedStore#doUnhandledOperation(Operation, Context)}
   */
  @Test
  @DisplayName("Test doUnhandledOperation(Operation, Context); given HashMap(); when GetElementsBetweenSets (default constructor) Options is HashMap()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object FederatedStore.doUnhandledOperation(Operation, Context)"})
  void testDoUnhandledOperation_givenHashMap_whenGetElementsBetweenSetsOptionsIsHashMap() {
    // Arrange
    FederatedStore federatedStore = new FederatedStore();

    GetElementsBetweenSets operation = new GetElementsBetweenSets();
    operation.setOptions(new HashMap<>());

    // Act and Assert
    assertNull(federatedStore.doUnhandledOperation(operation, new Context()));
  }

  /**
   * Test {@link FederatedStore#doUnhandledOperation(Operation, Context)}.
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>When {@link GetElementsBetweenSets} (default constructor) Options is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FederatedStore#doUnhandledOperation(Operation, Context)}
   */
  @Test
  @DisplayName("Test doUnhandledOperation(Operation, Context); given 'null'; when GetElementsBetweenSets (default constructor) Options is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object FederatedStore.doUnhandledOperation(Operation, Context)"})
  void testDoUnhandledOperation_givenNull_whenGetElementsBetweenSetsOptionsIsNull() {
    // Arrange
    FederatedStore federatedStore = new FederatedStore();

    GetElementsBetweenSets operation = new GetElementsBetweenSets();
    operation.setOptions(null);

    // Act and Assert
    assertNull(federatedStore.doUnhandledOperation(operation, new Context()));
  }

  /**
   * Test {@link FederatedStore#doUnhandledOperation(Operation, Context)}.
   * <ul>
   *   <li>Given {@code Running operation: {}}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FederatedStore#doUnhandledOperation(Operation, Context)}
   */
  @Test
  @DisplayName("Test doUnhandledOperation(Operation, Context); given 'Running operation: {}'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object FederatedStore.doUnhandledOperation(Operation, Context)"})
  void testDoUnhandledOperation_givenRunningOperation() {
    // Arrange
    FederatedStore federatedStore = new FederatedStore();

    OperationChain<Object> operation = new OperationChain<>();
    operation.addOption("Running operation: {}", "42");

    // Act and Assert
    assertNull(federatedStore.doUnhandledOperation(operation, new Context()));
  }

  /**
   * Test {@link FederatedStore#doUnhandledOperation(Operation, Context)}.
   * <ul>
   *   <li>When {@link AddGraph} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FederatedStore#doUnhandledOperation(Operation, Context)}
   */
  @Test
  @DisplayName("Test doUnhandledOperation(Operation, Context); when AddGraph (default constructor); then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object FederatedStore.doUnhandledOperation(Operation, Context)"})
  void testDoUnhandledOperation_whenAddGraph_thenReturnNull() {
    // Arrange
    FederatedStore federatedStore = new FederatedStore();
    AddGraph operation = new AddGraph();

    // Act and Assert
    assertNull(federatedStore.doUnhandledOperation(operation, new Context()));
  }

  /**
   * Test {@link FederatedStore#createOperationChainValidator()}.
   * <p>
   * Method under test: {@link FederatedStore#createOperationChainValidator()}
   */
  @Test
  @DisplayName("Test createOperationChainValidator()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "uk.gov.gchq.gaffer.store.operation.OperationChainValidator FederatedStore.createOperationChainValidator()"})
  void testCreateOperationChainValidator() {
    // Arrange, Act and Assert
    assertTrue((new FederatedStore()).createOperationChainValidator() instanceof FederatedOperationChainValidator);
  }

  /**
   * Test {@link FederatedStore#getGetElementsHandler()}.
   * <ul>
   *   <li>Then return {@link FederatedOutputHandler}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FederatedStore#getGetElementsHandler()}
   */
  @Test
  @DisplayName("Test getGetElementsHandler(); then return FederatedOutputHandler")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"OutputOperationHandler FederatedStore.getGetElementsHandler()"})
  void testGetGetElementsHandler_thenReturnFederatedOutputHandler() throws OperationException {
    // Arrange and Act
    OutputOperationHandler<GetElements, Iterable<? extends Element>> actualGetElementsHandler = (new FederatedStore())
        .getGetElementsHandler();
    GetElements getElements = new GetElements();
    Builder builder = new Builder();
    User user = (new User.Builder()).userId("42").build();
    Context buildResult = builder.user(user).build();

    // Assert
    assertTrue(actualGetElementsHandler instanceof FederatedOutputHandler);
    assertNull(actualGetElementsHandler.doOperation(getElements, buildResult, new FederatedStore()));
  }

  /**
   * Test {@link FederatedStore#getGetElementsHandler()}.
   * <ul>
   *   <li>Then return {@link FederatedOutputHandler}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FederatedStore#getGetElementsHandler()}
   */
  @Test
  @DisplayName("Test getGetElementsHandler(); then return FederatedOutputHandler")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"OutputOperationHandler FederatedStore.getGetElementsHandler()"})
  void testGetGetElementsHandler_thenReturnFederatedOutputHandler2() throws OperationException {
    // Arrange and Act
    OutputOperationHandler<GetElements, Iterable<? extends Element>> actualGetElementsHandler = (new FederatedStore())
        .getGetElementsHandler();
    GetElements getElements = new GetElements();
    getElements.addOption("federated.fixOperationLimit", "42");
    Builder builder = new Builder();
    User user = (new User.Builder()).userId("42").build();
    Context buildResult = builder.user(user).build();

    // Assert
    assertTrue(actualGetElementsHandler instanceof FederatedOutputHandler);
    assertNull(actualGetElementsHandler.doOperation(getElements, buildResult, new FederatedStore()));
  }

  /**
   * Test {@link FederatedStore#getGetAllElementsHandler()}.
   * <ul>
   *   <li>Then return {@link FederatedOutputHandler}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FederatedStore#getGetAllElementsHandler()}
   */
  @Test
  @DisplayName("Test getGetAllElementsHandler(); then return FederatedOutputHandler")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"OutputOperationHandler FederatedStore.getGetAllElementsHandler()"})
  void testGetGetAllElementsHandler_thenReturnFederatedOutputHandler() throws OperationException {
    // Arrange and Act
    OutputOperationHandler<GetAllElements, Iterable<? extends Element>> actualGetAllElementsHandler = (new FederatedStore())
        .getGetAllElementsHandler();
    GetAllElements getAllElements = new GetAllElements();
    Builder builder = new Builder();
    User user = (new User.Builder()).userId("42").build();
    Context buildResult = builder.user(user).build();

    // Assert
    assertTrue(actualGetAllElementsHandler instanceof FederatedOutputHandler);
    assertNull(actualGetAllElementsHandler.doOperation(getAllElements, buildResult, new FederatedStore()));
  }

  /**
   * Test {@link FederatedStore#getGetAllElementsHandler()}.
   * <ul>
   *   <li>Then return {@link FederatedOutputHandler}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FederatedStore#getGetAllElementsHandler()}
   */
  @Test
  @DisplayName("Test getGetAllElementsHandler(); then return FederatedOutputHandler")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"OutputOperationHandler FederatedStore.getGetAllElementsHandler()"})
  void testGetGetAllElementsHandler_thenReturnFederatedOutputHandler2() throws OperationException {
    // Arrange and Act
    OutputOperationHandler<GetAllElements, Iterable<? extends Element>> actualGetAllElementsHandler = (new FederatedStore())
        .getGetAllElementsHandler();
    GetAllElements getAllElements = new GetAllElements();
    getAllElements.addOption("federated.fixOperationLimit", "42");
    Builder builder = new Builder();
    User user = (new User.Builder()).userId("42").build();
    Context buildResult = builder.user(user).build();

    // Assert
    assertTrue(actualGetAllElementsHandler instanceof FederatedOutputHandler);
    assertNull(actualGetAllElementsHandler.doOperation(getAllElements, buildResult, new FederatedStore()));
  }

  /**
   * Test {@link FederatedStore#getDeleteElementsHandler()}.
   * <ul>
   *   <li>Then return {@link FederatedOutputHandler}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FederatedStore#getDeleteElementsHandler()}
   */
  @Test
  @DisplayName("Test getDeleteElementsHandler(); then return FederatedOutputHandler")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"OutputOperationHandler FederatedStore.getDeleteElementsHandler()"})
  void testGetDeleteElementsHandler_thenReturnFederatedOutputHandler() throws OperationException {
    // Arrange and Act
    OutputOperationHandler<DeleteElements, Long> actualDeleteElementsHandler = (new FederatedStore())
        .getDeleteElementsHandler();
    DeleteElements deleteElements = new DeleteElements();
    Builder builder = new Builder();
    User user = (new User.Builder()).userId("42").build();
    Context buildResult = builder.user(user).build();

    // Assert
    assertTrue(actualDeleteElementsHandler instanceof FederatedOutputHandler);
    assertNull(actualDeleteElementsHandler.doOperation(deleteElements, buildResult, new FederatedStore()));
  }

  /**
   * Test {@link FederatedStore#getDeleteElementsHandler()}.
   * <ul>
   *   <li>Then return {@link FederatedOutputHandler}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FederatedStore#getDeleteElementsHandler()}
   */
  @Test
  @DisplayName("Test getDeleteElementsHandler(); then return FederatedOutputHandler")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"OutputOperationHandler FederatedStore.getDeleteElementsHandler()"})
  void testGetDeleteElementsHandler_thenReturnFederatedOutputHandler2() throws OperationException {
    // Arrange and Act
    OutputOperationHandler<DeleteElements, Long> actualDeleteElementsHandler = (new FederatedStore())
        .getDeleteElementsHandler();
    DeleteElements deleteElements = new DeleteElements();
    deleteElements.addOption("federated.fixOperationLimit", "42");
    Builder builder = new Builder();
    User user = (new User.Builder()).userId("42").build();
    Context buildResult = builder.user(user).build();

    // Assert
    assertTrue(actualDeleteElementsHandler instanceof FederatedOutputHandler);
    assertNull(actualDeleteElementsHandler.doOperation(deleteElements, buildResult, new FederatedStore()));
  }

  /**
   * Test {@link FederatedStore#getDeleteAllDataHandler()}.
   * <ul>
   *   <li>Then return {@link FederatedOperationHandler}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FederatedStore#getDeleteAllDataHandler()}
   */
  @Test
  @DisplayName("Test getDeleteAllDataHandler(); then return FederatedOperationHandler")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"OperationHandler FederatedStore.getDeleteAllDataHandler()"})
  void testGetDeleteAllDataHandler_thenReturnFederatedOperationHandler() throws OperationException {
    // Arrange and Act
    OperationHandler<DeleteAllData> actualDeleteAllDataHandler = (new FederatedStore()).getDeleteAllDataHandler();
    DeleteAllData deleteAllData = new DeleteAllData();
    Builder builder = new Builder();
    User user = (new User.Builder()).userId("42").build();
    Context buildResult = builder.user(user).build();

    // Assert
    assertTrue(actualDeleteAllDataHandler instanceof FederatedOperationHandler);
    assertNull(actualDeleteAllDataHandler.doOperation(deleteAllData, buildResult, new FederatedStore()));
  }

  /**
   * Test {@link FederatedStore#getGetTraitsHandler()}.
   * <ul>
   *   <li>Then return {@link FederatedOutputHandler}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FederatedStore#getGetTraitsHandler()}
   */
  @Test
  @DisplayName("Test getGetTraitsHandler(); then return FederatedOutputHandler")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"OutputOperationHandler FederatedStore.getGetTraitsHandler()"})
  void testGetGetTraitsHandler_thenReturnFederatedOutputHandler() throws OperationException {
    // Arrange and Act
    OutputOperationHandler<GetTraits, Set<StoreTrait>> actualGetTraitsHandler = (new FederatedStore())
        .getGetTraitsHandler();
    GetTraits getTraits = new GetTraits();
    Builder builder = new Builder();
    User user = (new User.Builder()).userId("42").build();
    Context buildResult = builder.user(user).build();

    // Assert
    assertTrue(actualGetTraitsHandler instanceof FederatedOutputHandler);
    assertNull(actualGetTraitsHandler.doOperation(getTraits, buildResult, new FederatedStore()));
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link FederatedStore#setDefaultGraphIds(List)}
   *   <li>{@link FederatedStore#getPropertiesClass()}
   *   <li>{@link FederatedStore#getRequiredParentSerialiserClass()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Class FederatedStore.getPropertiesClass()",
      "Class FederatedStore.getRequiredParentSerialiserClass()", "void FederatedStore.setDefaultGraphIds(List)"})
  void testGettersAndSetters() {
    // Arrange
    FederatedStore federatedStore = new FederatedStore();

    // Act
    federatedStore.setDefaultGraphIds(new ArrayList<>());
    Class<FederatedStoreProperties> actualPropertiesClass = federatedStore.getPropertiesClass();
    Class<? extends Serialiser> actualRequiredParentSerialiserClass = federatedStore.getRequiredParentSerialiserClass();

    // Assert
    Class<FederatedStoreProperties> expectedPropertiesClass = FederatedStoreProperties.class;
    assertEquals(expectedPropertiesClass, actualPropertiesClass);
    Class<ToBytesSerialiser> expectedRequiredParentSerialiserClass = ToBytesSerialiser.class;
    assertEquals(expectedRequiredParentSerialiserClass, actualRequiredParentSerialiserClass);
  }

  /**
   * Test {@link FederatedStore#startCacheServiceLoader(StoreProperties)}.
   * <ul>
   *   <li>Then calls {@link StoreProperties#getDefaultCacheServiceClass()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FederatedStore#startCacheServiceLoader(StoreProperties)}
   */
  @Test
  @DisplayName("Test startCacheServiceLoader(StoreProperties); then calls getDefaultCacheServiceClass()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void FederatedStore.startCacheServiceLoader(StoreProperties)"})
  void testStartCacheServiceLoader_thenCallsGetDefaultCacheServiceClass() {
    // Arrange
    FederatedStore federatedStore = new FederatedStore();
    StoreProperties properties = mock(StoreProperties.class);
    when(properties.getJobTrackerEnabled()).thenReturn(false);
    when(properties.getNamedOperationEnabled()).thenReturn(false);
    when(properties.getNamedViewEnabled()).thenReturn(false);
    when(properties.getDefaultCacheServiceClass()).thenReturn("Default Cache Service Class");
    when(properties.getJobTrackerCacheServiceClass()).thenReturn("Job Tracker Cache Service Class");
    when(properties.getNamedOperationCacheServiceClass()).thenReturn("Named Operation Cache Service Class");
    when(properties.getNamedViewCacheServiceClass()).thenReturn("Named View Cache Service Class");

    // Act
    federatedStore.startCacheServiceLoader(properties);

    // Assert
    verify(properties).getDefaultCacheServiceClass();
    verify(properties).getJobTrackerCacheServiceClass();
    verify(properties).getJobTrackerEnabled();
    verify(properties).getNamedOperationCacheServiceClass();
    verify(properties).getNamedOperationEnabled();
    verify(properties).getNamedViewCacheServiceClass();
    verify(properties).getNamedViewEnabled();
  }
}
