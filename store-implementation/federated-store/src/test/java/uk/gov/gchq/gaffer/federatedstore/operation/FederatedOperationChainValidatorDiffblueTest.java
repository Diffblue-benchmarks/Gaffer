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
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.apache.commons.lang3.exception.CloneFailedException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import uk.gov.gchq.gaffer.accumulostore.operation.impl.GetElementsBetweenSets;
import uk.gov.gchq.gaffer.core.exception.GafferRuntimeException;
import uk.gov.gchq.gaffer.federatedstore.FederatedStore;
import uk.gov.gchq.gaffer.operation.Operation;
import uk.gov.gchq.gaffer.operation.OperationException;
import uk.gov.gchq.gaffer.operation.export.graph.ExportToOtherAuthorisedGraph;
import uk.gov.gchq.gaffer.operation.io.Output;
import uk.gov.gchq.gaffer.store.Context;
import uk.gov.gchq.gaffer.store.Store;
import uk.gov.gchq.gaffer.store.schema.Schema;
import uk.gov.gchq.gaffer.store.schema.ViewValidator;
import uk.gov.gchq.gaffer.user.User;
import uk.gov.gchq.koryphe.ValidationResult;

class FederatedOperationChainValidatorDiffblueTest {
  /**
   * Test {@link FederatedOperationChainValidator#getSchema(Operation, User, Store)}.
   * <ul>
   *   <li>Given {@link Schema#Schema()}.</li>
   *   <li>When {@link Store} {@link Store#execute(Output, Context)} return {@link Schema#Schema()}.</li>
   *   <li>Then return {@link Schema#Schema()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FederatedOperationChainValidator#getSchema(Operation, User, Store)}
   */
  @Test
  @DisplayName("Test getSchema(Operation, User, Store); given Schema(); when Store execute(Output, Context) return Schema(); then return Schema()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Schema FederatedOperationChainValidator.getSchema(Operation, User, Store)"})
  void testGetSchema_givenSchema_whenStoreExecuteReturnSchema_thenReturnSchema() throws OperationException {
    // Arrange
    FederatedOperationChainValidator federatedOperationChainValidator = new FederatedOperationChainValidator(
        new ViewValidator());
    AddGraph op = new AddGraph();
    User user = new User();
    Store store = mock(Store.class);
    Schema schema = new Schema();
    when(store.execute(Mockito.<Output<Schema>>any(), Mockito.<Context>any())).thenReturn(schema);

    // Act
    Schema actualSchema = federatedOperationChainValidator.getSchema(op, user, store);

    // Assert
    verify(store).execute(isA(Output.class), isA(Context.class));
    assertSame(schema, actualSchema);
  }

  /**
   * Test {@link FederatedOperationChainValidator#getSchema(Operation, User, Store)}.
   * <ul>
   *   <li>Given {@link Schema#Schema()}.</li>
   *   <li>When {@link Store} {@link Store#execute(Output, Context)} return {@link Schema#Schema()}.</li>
   *   <li>Then return {@link Schema#Schema()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FederatedOperationChainValidator#getSchema(Operation, User, Store)}
   */
  @Test
  @DisplayName("Test getSchema(Operation, User, Store); given Schema(); when Store execute(Output, Context) return Schema(); then return Schema()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Schema FederatedOperationChainValidator.getSchema(Operation, User, Store)"})
  void testGetSchema_givenSchema_whenStoreExecuteReturnSchema_thenReturnSchema2() throws OperationException {
    // Arrange
    FederatedOperationChainValidator federatedOperationChainValidator = new FederatedOperationChainValidator(
        new ViewValidator());

    FederatedOperation<Object, Object> op = new FederatedOperation<>();
    op.graphIds(null);
    User user = new User();
    Store store = mock(Store.class);
    Schema schema = new Schema();
    when(store.execute(Mockito.<Output<Schema>>any(), Mockito.<Context>any())).thenReturn(schema);

    // Act
    Schema actualSchema = federatedOperationChainValidator.getSchema(op, user, store);

    // Assert
    verify(store).execute(isA(Output.class), isA(Context.class));
    assertSame(schema, actualSchema);
  }

  /**
   * Test {@link FederatedOperationChainValidator#getSchema(Operation, User, Store)}.
   * <ul>
   *   <li>Then throw {@link GafferRuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FederatedOperationChainValidator#getSchema(Operation, User, Store)}
   */
  @Test
  @DisplayName("Test getSchema(Operation, User, Store); then throw GafferRuntimeException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Schema FederatedOperationChainValidator.getSchema(Operation, User, Store)"})
  void testGetSchema_thenThrowGafferRuntimeException() throws OperationException {
    // Arrange
    FederatedOperationChainValidator federatedOperationChainValidator = new FederatedOperationChainValidator(
        new ViewValidator());
    AddGraph op = new AddGraph();
    User user = new User();
    Store store = mock(Store.class);
    when(store.execute(Mockito.<Output<Schema>>any(), Mockito.<Context>any()))
        .thenThrow(new OperationException("An error occurred"));

    // Act and Assert
    assertThrows(GafferRuntimeException.class, () -> federatedOperationChainValidator.getSchema(op, user, store));
    verify(store).execute(isA(Output.class), isA(Context.class));
  }

  /**
   * Test {@link FederatedOperationChainValidator#getSchema(Operation, User, Store)}.
   * <ul>
   *   <li>Then throw {@link GafferRuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FederatedOperationChainValidator#getSchema(Operation, User, Store)}
   */
  @Test
  @DisplayName("Test getSchema(Operation, User, Store); then throw GafferRuntimeException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Schema FederatedOperationChainValidator.getSchema(Operation, User, Store)"})
  void testGetSchema_thenThrowGafferRuntimeException2() throws OperationException {
    // Arrange
    FederatedOperationChainValidator federatedOperationChainValidator = new FederatedOperationChainValidator(
        new ViewValidator());

    FederatedOperation<Object, Object> op = new FederatedOperation<>();
    op.graphIds(null);
    User user = new User();
    Store store = mock(Store.class);
    when(store.execute(Mockito.<Output<Schema>>any(), Mockito.<Context>any()))
        .thenThrow(new OperationException("An error occurred"));

    // Act and Assert
    assertThrows(GafferRuntimeException.class, () -> federatedOperationChainValidator.getSchema(op, user, store));
    verify(store).execute(isA(Output.class), isA(Context.class));
  }

  /**
   * Test {@link FederatedOperationChainValidator#shouldValidate(Operation)}.
   * <ul>
   *   <li>When {@link AddGraph} (default constructor).</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FederatedOperationChainValidator#shouldValidate(Operation)}
   */
  @Test
  @DisplayName("Test shouldValidate(Operation); when AddGraph (default constructor); then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean FederatedOperationChainValidator.shouldValidate(Operation)"})
  void testShouldValidate_whenAddGraph_thenReturnFalse() {
    // Arrange
    FederatedOperationChainValidator federatedOperationChainValidator = new FederatedOperationChainValidator(
        new ViewValidator());

    // Act and Assert
    assertFalse(federatedOperationChainValidator.shouldValidate(new AddGraph()));
  }

  /**
   * Test {@link FederatedOperationChainValidator#shouldValidate(Operation)}.
   * <ul>
   *   <li>When {@link FederatedOperation} (default constructor).</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FederatedOperationChainValidator#shouldValidate(Operation)}
   */
  @Test
  @DisplayName("Test shouldValidate(Operation); when FederatedOperation (default constructor); then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean FederatedOperationChainValidator.shouldValidate(Operation)"})
  void testShouldValidate_whenFederatedOperation_thenReturnFalse() {
    // Arrange
    FederatedOperationChainValidator federatedOperationChainValidator = new FederatedOperationChainValidator(
        new ViewValidator());

    // Act and Assert
    assertFalse(federatedOperationChainValidator.shouldValidate(new FederatedOperation<>()));
  }

  /**
   * Test {@link FederatedOperationChainValidator#shouldValidate(Operation)}.
   * <ul>
   *   <li>When {@link GetElementsBetweenSets} (default constructor).</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FederatedOperationChainValidator#shouldValidate(Operation)}
   */
  @Test
  @DisplayName("Test shouldValidate(Operation); when GetElementsBetweenSets (default constructor); then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean FederatedOperationChainValidator.shouldValidate(Operation)"})
  void testShouldValidate_whenGetElementsBetweenSets_thenReturnTrue() {
    // Arrange
    FederatedOperationChainValidator federatedOperationChainValidator = new FederatedOperationChainValidator(
        new ViewValidator());

    // Act and Assert
    assertTrue(federatedOperationChainValidator.shouldValidate(new GetElementsBetweenSets()));
  }

  /**
   * Test {@link FederatedOperationChainValidator#validateViews(Operation, User, Store, ValidationResult)}.
   * <ul>
   *   <li>Given {@link AddGraph} (default constructor).</li>
   *   <li>When {@link Operation} {@link Operation#shallowClone()} return {@link AddGraph} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link FederatedOperationChainValidator#validateViews(Operation, User, Store, ValidationResult)}
   */
  @Test
  @DisplayName("Test validateViews(Operation, User, Store, ValidationResult); given AddGraph (default constructor); when Operation shallowClone() return AddGraph (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void FederatedOperationChainValidator.validateViews(Operation, User, Store, ValidationResult)"})
  void testValidateViews_givenAddGraph_whenOperationShallowCloneReturnAddGraph() throws CloneFailedException {
    // Arrange
    FederatedOperationChainValidator federatedOperationChainValidator = new FederatedOperationChainValidator(
        new ViewValidator());
    Operation op = mock(Operation.class);
    when(op.getOptions()).thenReturn(new HashMap<>());
    when(op.shallowClone()).thenReturn(new AddGraph());
    User user = new User();
    FederatedStore store = mock(FederatedStore.class);
    when(store.getAllGraphIds(Mockito.<User>any(), anyBoolean())).thenReturn(new ArrayList<>());
    when(store.getGraphs(Mockito.<User>any(), Mockito.<List<String>>any(), Mockito.<IFederationOperation>any()))
        .thenReturn(new ArrayList<>());

    // Act
    federatedOperationChainValidator.validateViews(op, user, store, new ValidationResult("An error occurred"));

    // Assert
    verify(store).getAllGraphIds(isA(User.class), eq(false));
    verify(store).getGraphs(isA(User.class), isA(List.class), isA(IFederationOperation.class));
    verify(op).getOptions();
    verify(op).shallowClone();
  }

  /**
   * Test {@link FederatedOperationChainValidator#validateViews(Operation, User, Store, ValidationResult)}.
   * <ul>
   *   <li>Given {@link ExportToOtherAuthorisedGraph} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link FederatedOperationChainValidator#validateViews(Operation, User, Store, ValidationResult)}
   */
  @Test
  @DisplayName("Test validateViews(Operation, User, Store, ValidationResult); given ExportToOtherAuthorisedGraph (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void FederatedOperationChainValidator.validateViews(Operation, User, Store, ValidationResult)"})
  void testValidateViews_givenExportToOtherAuthorisedGraph() throws CloneFailedException {
    // Arrange
    FederatedOperationChainValidator federatedOperationChainValidator = new FederatedOperationChainValidator(
        new ViewValidator());
    Operation op = mock(Operation.class);
    when(op.getOptions()).thenReturn(new HashMap<>());
    when(op.shallowClone()).thenReturn(new ExportToOtherAuthorisedGraph());
    User user = new User();
    FederatedStore store = mock(FederatedStore.class);
    when(store.getAllGraphIds(Mockito.<User>any(), anyBoolean())).thenReturn(new ArrayList<>());
    when(store.getGraphs(Mockito.<User>any(), Mockito.<List<String>>any(), Mockito.<IFederationOperation>any()))
        .thenReturn(new ArrayList<>());

    // Act
    federatedOperationChainValidator.validateViews(op, user, store, new ValidationResult("An error occurred"));

    // Assert
    verify(store).getAllGraphIds(isA(User.class), eq(false));
    verify(store).getGraphs(isA(User.class), isA(List.class), isA(IFederationOperation.class));
    verify(op).getOptions();
    verify(op).shallowClone();
  }
}
