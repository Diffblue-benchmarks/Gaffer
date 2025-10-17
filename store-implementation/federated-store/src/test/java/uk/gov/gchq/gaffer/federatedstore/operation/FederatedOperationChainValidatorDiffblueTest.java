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
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.apache.commons.lang3.exception.CloneFailedException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import uk.gov.gchq.gaffer.federatedstore.FederatedStore;
import uk.gov.gchq.gaffer.operation.Operation;
import uk.gov.gchq.gaffer.operation.OperationChain;
import uk.gov.gchq.gaffer.operation.OperationException;
import uk.gov.gchq.gaffer.operation.export.graph.ExportToOtherAuthorisedGraph;
import uk.gov.gchq.gaffer.operation.impl.add.AddElements;
import uk.gov.gchq.gaffer.operation.impl.get.GetAllElements;
import uk.gov.gchq.gaffer.operation.impl.io.GenericInputImpl;
import uk.gov.gchq.gaffer.operation.io.Output;
import uk.gov.gchq.gaffer.store.Context;
import uk.gov.gchq.gaffer.store.Store;
import uk.gov.gchq.gaffer.store.optimiser.OperationChainOptimiser;
import uk.gov.gchq.gaffer.store.schema.Schema;
import uk.gov.gchq.gaffer.store.schema.ViewValidator;
import uk.gov.gchq.gaffer.user.User;
import uk.gov.gchq.gaffer.user.User.Builder;
import uk.gov.gchq.koryphe.ValidationResult;

class FederatedOperationChainValidatorDiffblueTest {
  /**
   * Test {@link FederatedOperationChainValidator#getSchema(Operation, User, Store)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link FederatedOperation} (default constructor) graphIds {@code null}.
   *   <li>Then return {@link Schema#Schema()}.
   * </ul>
   *
   * <p>Method under test: {@link FederatedOperationChainValidator#getSchema(Operation, User,
   * Store)}
   */
  @Test
  @DisplayName(
      "Test getSchema(Operation, User, Store); given 'null'; when FederatedOperation (default constructor) graphIds 'null'; then return Schema()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Schema FederatedOperationChainValidator.getSchema(Operation, User, Store)"})
  void testGetSchema_givenNull_whenFederatedOperationGraphIdsNull_thenReturnSchema()
      throws OperationException {
    // Arrange
    FederatedOperationChainValidator federatedOperationChainValidator =
        new FederatedOperationChainValidator(new ViewValidator());

    FederatedOperation<Object, Object> op = new FederatedOperation<>();
    op.graphIds(null);
    User user = new User();

    Store store = mock(Store.class);
    Schema schema = new Schema();
    when(store.execute(Mockito.<Output<Schema>>any(), Mockito.<Context>any())).thenReturn(schema);
    doNothing()
        .when(store)
        .addOperationChainOptimisers(Mockito.<List<OperationChainOptimiser>>any());
    store.addOperationChainOptimisers(new ArrayList<>());

    // Act
    Schema actualSchema = federatedOperationChainValidator.getSchema(op, user, store);

    // Assert
    verify(store).addOperationChainOptimisers(isA(List.class));
    verify(store).execute(isA(Output.class), isA(Context.class));
    assertSame(schema, actualSchema);
  }

  /**
   * Test {@link FederatedOperationChainValidator#getSchema(Operation, User, Store)}.
   *
   * <ul>
   *   <li>Given {@link Schema#Schema()}.
   *   <li>When {@link Store} {@link Store#execute(Output, Context)} return {@link Schema#Schema()}.
   *   <li>Then return {@link Schema#Schema()}.
   * </ul>
   *
   * <p>Method under test: {@link FederatedOperationChainValidator#getSchema(Operation, User,
   * Store)}
   */
  @Test
  @DisplayName(
      "Test getSchema(Operation, User, Store); given Schema(); when Store execute(Output, Context) return Schema(); then return Schema()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Schema FederatedOperationChainValidator.getSchema(Operation, User, Store)"})
  void testGetSchema_givenSchema_whenStoreExecuteReturnSchema_thenReturnSchema()
      throws OperationException {
    // Arrange
    FederatedOperationChainValidator federatedOperationChainValidator =
        new FederatedOperationChainValidator(new ViewValidator());
    AddGraph op = new AddGraph();
    User user = new User();

    Store store = mock(Store.class);
    Schema schema = new Schema();
    when(store.execute(Mockito.<Output<Schema>>any(), Mockito.<Context>any())).thenReturn(schema);
    doNothing()
        .when(store)
        .addOperationChainOptimisers(Mockito.<List<OperationChainOptimiser>>any());
    store.addOperationChainOptimisers(new ArrayList<>());

    // Act
    Schema actualSchema = federatedOperationChainValidator.getSchema(op, user, store);

    // Assert
    verify(store).addOperationChainOptimisers(isA(List.class));
    verify(store).execute(isA(Output.class), isA(Context.class));
    assertSame(schema, actualSchema);
  }

  /**
   * Test {@link FederatedOperationChainValidator#getSchema(Operation, User, Store)}.
   *
   * <ul>
   *   <li>When {@link User.Builder} (default constructor) userId {@code 42} build.
   *   <li>Then calls {@link FederatedOperation#getGraphIds()}.
   * </ul>
   *
   * <p>Method under test: {@link FederatedOperationChainValidator#getSchema(Operation, User,
   * Store)}
   */
  @Test
  @DisplayName(
      "Test getSchema(Operation, User, Store); when Builder (default constructor) userId '42' build; then calls getGraphIds()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Schema FederatedOperationChainValidator.getSchema(Operation, User, Store)"})
  void testGetSchema_whenBuilderUserId42Build_thenCallsGetGraphIds() throws OperationException {
    // Arrange
    FederatedOperationChainValidator federatedOperationChainValidator =
        new FederatedOperationChainValidator(new ViewValidator());

    FederatedOperation<Object, Object> op = mock(FederatedOperation.class);
    when(op.getGraphIds()).thenReturn(new ArrayList<>());
    when(op.graphIds(Mockito.<List<String>>any())).thenReturn(new FederatedOperation<>());
    op.graphIds(null);
    User user = new Builder().userId("42").build();

    Store store = mock(Store.class);
    when(store.execute(Mockito.<Output<Object>>any(), Mockito.<Context>any()))
        .thenReturn(new Schema());
    Schema schema = new Schema();
    when(store.execute(Mockito.<Output<Schema>>any(), Mockito.<Context>any())).thenReturn(schema);
    doNothing()
        .when(store)
        .addOperationChainOptimisers(Mockito.<List<OperationChainOptimiser>>any());
    store.addOperationChainOptimisers(new ArrayList<>());

    // Act
    Schema actualSchema = federatedOperationChainValidator.getSchema(op, user, store);

    // Assert
    verify(op).getGraphIds();
    verify(op).graphIds(isNull());
    verify(store).addOperationChainOptimisers(isA(List.class));
    verify(store, atLeast(1)).execute(isA(Output.class), isA(Context.class));
    assertSame(schema, actualSchema);
  }

  /**
   * Test {@link FederatedOperationChainValidator#getSchema(Operation, User, Store)}.
   *
   * <ul>
   *   <li>When {@link FederatedOperation} (default constructor) graphIds {@link
   *       ArrayList#ArrayList()}.
   *   <li>Then return {@link Schema#Schema()}.
   * </ul>
   *
   * <p>Method under test: {@link FederatedOperationChainValidator#getSchema(Operation, User,
   * Store)}
   */
  @Test
  @DisplayName(
      "Test getSchema(Operation, User, Store); when FederatedOperation (default constructor) graphIds ArrayList(); then return Schema()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Schema FederatedOperationChainValidator.getSchema(Operation, User, Store)"})
  void testGetSchema_whenFederatedOperationGraphIdsArrayList_thenReturnSchema()
      throws OperationException {
    // Arrange
    FederatedOperationChainValidator federatedOperationChainValidator =
        new FederatedOperationChainValidator(new ViewValidator());

    FederatedOperation<Object, Object> op = new FederatedOperation<>();
    op.graphIds(new ArrayList<>());
    User user = new User();

    Store store = mock(Store.class);
    Schema schema = new Schema();
    when(store.execute(Mockito.<Output<Schema>>any(), Mockito.<Context>any())).thenReturn(schema);
    doNothing()
        .when(store)
        .addOperationChainOptimisers(Mockito.<List<OperationChainOptimiser>>any());
    store.addOperationChainOptimisers(new ArrayList<>());

    // Act
    Schema actualSchema = federatedOperationChainValidator.getSchema(op, user, store);

    // Assert
    verify(store).addOperationChainOptimisers(isA(List.class));
    verify(store).execute(isA(Output.class), isA(Context.class));
    assertSame(schema, actualSchema);
  }

  /**
   * Test {@link FederatedOperationChainValidator#shouldValidate(Operation)}.
   *
   * <ul>
   *   <li>When {@link AddGraph} (default constructor).
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link FederatedOperationChainValidator#shouldValidate(Operation)}
   */
  @Test
  @DisplayName(
      "Test shouldValidate(Operation); when AddGraph (default constructor); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean FederatedOperationChainValidator.shouldValidate(Operation)"})
  void testShouldValidate_whenAddGraph_thenReturnFalse() {
    // Arrange
    FederatedOperationChainValidator federatedOperationChainValidator =
        new FederatedOperationChainValidator(new ViewValidator());

    // Act and Assert
    assertFalse(federatedOperationChainValidator.shouldValidate(new AddGraph()));
  }

  /**
   * Test {@link FederatedOperationChainValidator#shouldValidate(Operation)}.
   *
   * <ul>
   *   <li>When {@link FederatedOperation} (default constructor).
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link FederatedOperationChainValidator#shouldValidate(Operation)}
   */
  @Test
  @DisplayName(
      "Test shouldValidate(Operation); when FederatedOperation (default constructor); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean FederatedOperationChainValidator.shouldValidate(Operation)"})
  void testShouldValidate_whenFederatedOperation_thenReturnFalse() {
    // Arrange
    FederatedOperationChainValidator federatedOperationChainValidator =
        new FederatedOperationChainValidator(new ViewValidator());

    // Act and Assert
    assertFalse(federatedOperationChainValidator.shouldValidate(new FederatedOperation<>()));
  }

  /**
   * Test {@link FederatedOperationChainValidator#shouldValidate(Operation)}.
   *
   * <ul>
   *   <li>When {@link GetAllElements} (default constructor).
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link FederatedOperationChainValidator#shouldValidate(Operation)}
   */
  @Test
  @DisplayName(
      "Test shouldValidate(Operation); when GetAllElements (default constructor); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean FederatedOperationChainValidator.shouldValidate(Operation)"})
  void testShouldValidate_whenGetAllElements_thenReturnTrue() {
    // Arrange
    FederatedOperationChainValidator federatedOperationChainValidator =
        new FederatedOperationChainValidator(new ViewValidator());

    // Act and Assert
    assertTrue(federatedOperationChainValidator.shouldValidate(new GetAllElements()));
  }

  /**
   * Test {@link FederatedOperationChainValidator#validateViews(Operation, User, Store,
   * ValidationResult)}.
   *
   * <ul>
   *   <li>Given {@link AddElements} (default constructor).
   *   <li>When {@link Operation} {@link Operation#shallowClone()} return {@link AddElements}
   *       (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link FederatedOperationChainValidator#validateViews(Operation, User,
   * Store, ValidationResult)}
   */
  @Test
  @DisplayName(
      "Test validateViews(Operation, User, Store, ValidationResult); given AddElements (default constructor); when Operation shallowClone() return AddElements (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void FederatedOperationChainValidator.validateViews(Operation, User, Store, ValidationResult)"
  })
  void testValidateViews_givenAddElements_whenOperationShallowCloneReturnAddElements()
      throws CloneFailedException {
    // Arrange
    FederatedOperationChainValidator federatedOperationChainValidator =
        new FederatedOperationChainValidator(new ViewValidator());

    Operation op = mock(Operation.class);
    when(op.getOptions()).thenReturn(new HashMap<>());
    when(op.shallowClone()).thenReturn(new AddElements());
    User user = new User();

    FederatedStore store = mock(FederatedStore.class);
    when(store.getAllGraphIds(Mockito.<User>any(), anyBoolean())).thenReturn(new ArrayList<>());
    when(store.getGraphs(
            Mockito.<User>any(), Mockito.<List<String>>any(), Mockito.<IFederationOperation>any()))
        .thenReturn(new ArrayList<>());

    // Act
    federatedOperationChainValidator.validateViews(
        op, user, store, new ValidationResult("An error occurred"));

    // Assert
    verify(store).getAllGraphIds(isA(User.class), eq(false));
    verify(store).getGraphs(isA(User.class), isA(List.class), isA(IFederationOperation.class));
    verify(op).getOptions();
    verify(op).shallowClone();
  }

  /**
   * Test {@link FederatedOperationChainValidator#validateViews(Operation, User, Store,
   * ValidationResult)}.
   *
   * <ul>
   *   <li>Given {@link AddGraph} (default constructor).
   *   <li>When {@link Operation} {@link Operation#shallowClone()} return {@link AddGraph} (default
   *       constructor).
   * </ul>
   *
   * <p>Method under test: {@link FederatedOperationChainValidator#validateViews(Operation, User,
   * Store, ValidationResult)}
   */
  @Test
  @DisplayName(
      "Test validateViews(Operation, User, Store, ValidationResult); given AddGraph (default constructor); when Operation shallowClone() return AddGraph (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void FederatedOperationChainValidator.validateViews(Operation, User, Store, ValidationResult)"
  })
  void testValidateViews_givenAddGraph_whenOperationShallowCloneReturnAddGraph()
      throws CloneFailedException {
    // Arrange
    FederatedOperationChainValidator federatedOperationChainValidator =
        new FederatedOperationChainValidator(new ViewValidator());

    Operation op = mock(Operation.class);
    when(op.getOptions()).thenReturn(new HashMap<>());
    when(op.shallowClone()).thenReturn(new AddGraph());
    User user = new User();

    FederatedStore store = mock(FederatedStore.class);
    when(store.getAllGraphIds(Mockito.<User>any(), anyBoolean())).thenReturn(new ArrayList<>());
    when(store.getGraphs(
            Mockito.<User>any(), Mockito.<List<String>>any(), Mockito.<IFederationOperation>any()))
        .thenReturn(new ArrayList<>());

    // Act
    federatedOperationChainValidator.validateViews(
        op, user, store, new ValidationResult("An error occurred"));

    // Assert
    verify(store).getAllGraphIds(isA(User.class), eq(false));
    verify(store).getGraphs(isA(User.class), isA(List.class), isA(IFederationOperation.class));
    verify(op).getOptions();
    verify(op).shallowClone();
  }

  /**
   * Test {@link FederatedOperationChainValidator#validateViews(Operation, User, Store,
   * ValidationResult)}.
   *
   * <ul>
   *   <li>Given {@link ExportToOtherAuthorisedGraph} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link FederatedOperationChainValidator#validateViews(Operation, User,
   * Store, ValidationResult)}
   */
  @Test
  @DisplayName(
      "Test validateViews(Operation, User, Store, ValidationResult); given ExportToOtherAuthorisedGraph (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void FederatedOperationChainValidator.validateViews(Operation, User, Store, ValidationResult)"
  })
  void testValidateViews_givenExportToOtherAuthorisedGraph() throws CloneFailedException {
    // Arrange
    FederatedOperationChainValidator federatedOperationChainValidator =
        new FederatedOperationChainValidator(new ViewValidator());

    Operation op = mock(Operation.class);
    when(op.getOptions()).thenReturn(new HashMap<>());
    when(op.shallowClone()).thenReturn(new ExportToOtherAuthorisedGraph());
    User user = new User();

    FederatedStore store = mock(FederatedStore.class);
    when(store.getAllGraphIds(Mockito.<User>any(), anyBoolean())).thenReturn(new ArrayList<>());
    when(store.getGraphs(
            Mockito.<User>any(), Mockito.<List<String>>any(), Mockito.<IFederationOperation>any()))
        .thenReturn(new ArrayList<>());

    // Act
    federatedOperationChainValidator.validateViews(
        op, user, store, new ValidationResult("An error occurred"));

    // Assert
    verify(store).getAllGraphIds(isA(User.class), eq(false));
    verify(store).getGraphs(isA(User.class), isA(List.class), isA(IFederationOperation.class));
    verify(op).getOptions();
    verify(op).shallowClone();
  }

  /**
   * Test {@link FederatedOperationChainValidator#validateViews(Operation, User, Store,
   * ValidationResult)}.
   *
   * <ul>
   *   <li>Given {@link FederatedOperation} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link FederatedOperationChainValidator#validateViews(Operation, User,
   * Store, ValidationResult)}
   */
  @Test
  @DisplayName(
      "Test validateViews(Operation, User, Store, ValidationResult); given FederatedOperation (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void FederatedOperationChainValidator.validateViews(Operation, User, Store, ValidationResult)"
  })
  void testValidateViews_givenFederatedOperation() throws CloneFailedException {
    // Arrange
    FederatedOperationChainValidator federatedOperationChainValidator =
        new FederatedOperationChainValidator(new ViewValidator());

    Operation op = mock(Operation.class);
    when(op.getOptions()).thenReturn(new HashMap<>());
    when(op.shallowClone()).thenReturn(new FederatedOperation<>());
    User user = new User();

    FederatedStore store = mock(FederatedStore.class);
    when(store.getAllGraphIds(Mockito.<User>any(), anyBoolean())).thenReturn(new ArrayList<>());
    when(store.getGraphs(
            Mockito.<User>any(), Mockito.<List<String>>any(), Mockito.<IFederationOperation>any()))
        .thenReturn(new ArrayList<>());

    // Act
    federatedOperationChainValidator.validateViews(
        op, user, store, new ValidationResult("An error occurred"));

    // Assert
    verify(store).getAllGraphIds(isA(User.class), eq(false));
    verify(store).getGraphs(isA(User.class), isA(List.class), isA(IFederationOperation.class));
    verify(op).getOptions();
    verify(op).shallowClone();
  }

  /**
   * Test {@link FederatedOperationChainValidator#validateViews(Operation, User, Store,
   * ValidationResult)}.
   *
   * <ul>
   *   <li>Given {@link GenericInputImpl#GenericInputImpl()}.
   * </ul>
   *
   * <p>Method under test: {@link FederatedOperationChainValidator#validateViews(Operation, User,
   * Store, ValidationResult)}
   */
  @Test
  @DisplayName(
      "Test validateViews(Operation, User, Store, ValidationResult); given GenericInputImpl()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void FederatedOperationChainValidator.validateViews(Operation, User, Store, ValidationResult)"
  })
  void testValidateViews_givenGenericInputImpl() throws CloneFailedException {
    // Arrange
    FederatedOperationChainValidator federatedOperationChainValidator =
        new FederatedOperationChainValidator(new ViewValidator());

    Operation op = mock(Operation.class);
    when(op.getOptions()).thenReturn(new HashMap<>());
    when(op.shallowClone()).thenReturn(new GenericInputImpl());
    User user = new User();

    FederatedStore store = mock(FederatedStore.class);
    when(store.getAllGraphIds(Mockito.<User>any(), anyBoolean())).thenReturn(new ArrayList<>());
    when(store.getGraphs(
            Mockito.<User>any(), Mockito.<List<String>>any(), Mockito.<IFederationOperation>any()))
        .thenReturn(new ArrayList<>());

    // Act
    federatedOperationChainValidator.validateViews(
        op, user, store, new ValidationResult("An error occurred"));

    // Assert
    verify(store).getAllGraphIds(isA(User.class), eq(false));
    verify(store).getGraphs(isA(User.class), isA(List.class), isA(IFederationOperation.class));
    verify(op).getOptions();
    verify(op).shallowClone();
  }

  /**
   * Test {@link FederatedOperationChainValidator#validateViews(Operation, User, Store,
   * ValidationResult)}.
   *
   * <ul>
   *   <li>Given wrap {@link FederatedOperation} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link FederatedOperationChainValidator#validateViews(Operation, User,
   * Store, ValidationResult)}
   */
  @Test
  @DisplayName(
      "Test validateViews(Operation, User, Store, ValidationResult); given wrap FederatedOperation (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void FederatedOperationChainValidator.validateViews(Operation, User, Store, ValidationResult)"
  })
  void testValidateViews_givenWrapFederatedOperation() throws CloneFailedException {
    // Arrange
    FederatedOperationChainValidator federatedOperationChainValidator =
        new FederatedOperationChainValidator(new ViewValidator());

    Operation op = mock(Operation.class);
    when(op.getOptions()).thenReturn(new HashMap<>());
    OperationChain<Object> wrapResult = OperationChain.wrap(new FederatedOperation<>());
    when(op.shallowClone()).thenReturn(wrapResult);
    User user = new User();

    FederatedStore store = mock(FederatedStore.class);
    when(store.getAllGraphIds(Mockito.<User>any(), anyBoolean())).thenReturn(new ArrayList<>());
    when(store.getGraphs(
            Mockito.<User>any(), Mockito.<List<String>>any(), Mockito.<IFederationOperation>any()))
        .thenReturn(new ArrayList<>());

    // Act
    federatedOperationChainValidator.validateViews(
        op, user, store, new ValidationResult("An error occurred"));

    // Assert
    verify(store).getAllGraphIds(isA(User.class), eq(false));
    verify(store).getGraphs(isA(User.class), isA(List.class), isA(IFederationOperation.class));
    verify(op).getOptions();
    verify(op).shallowClone();
  }
}
