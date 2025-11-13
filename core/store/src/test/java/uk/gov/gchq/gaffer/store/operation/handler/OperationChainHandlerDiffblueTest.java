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

package uk.gov.gchq.gaffer.store.operation.handler;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import uk.gov.gchq.gaffer.named.operation.NamedOperation;
import uk.gov.gchq.gaffer.operation.Operation;
import uk.gov.gchq.gaffer.operation.OperationChain;
import uk.gov.gchq.gaffer.operation.OperationChainDAO;
import uk.gov.gchq.gaffer.operation.OperationException;
import uk.gov.gchq.gaffer.store.Context;
import uk.gov.gchq.gaffer.store.Context.Builder;
import uk.gov.gchq.gaffer.store.Store;
import uk.gov.gchq.gaffer.store.operation.OperationChainValidator;
import uk.gov.gchq.gaffer.store.optimiser.OperationChainOptimiser;
import uk.gov.gchq.gaffer.store.schema.ViewValidator;
import uk.gov.gchq.gaffer.user.User;

class OperationChainHandlerDiffblueTest {
  /**
   * Test {@link OperationChainHandler#doOperation(OperationChain, Context, Store)} with {@code
   * OperationChain}, {@code Context}, {@code Store}.
   *
   * <p>Method under test: {@link OperationChainHandler#doOperation(OperationChain, Context, Store)}
   */
  @Test
  @DisplayName(
      "Test doOperation(OperationChain, Context, Store) with 'OperationChain', 'Context', 'Store'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object OperationChainHandler.doOperation(OperationChain, Context, Store)"})
  void testDoOperationWithOperationChainContextStore() throws OperationException {
    // Arrange
    OperationChainValidator opChainValidator = new OperationChainValidator(new ViewValidator());
    OperationChainHandler<Object> operationChainHandler =
        new OperationChainHandler<>(opChainValidator, new ArrayList<>());
    OperationChain<Object> operationChain = OperationChain.wrap(new NamedOperation<>());

    Builder builder = new Builder();
    Context context = builder.user(new User.Builder().userId("42").build()).build();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            operationChainHandler.doOperation(
                operationChain, context, new TestAddToGraphLibraryImpl()));
  }

  /**
   * Test {@link OperationChainHandler#doOperation(OperationChain, Context, Store)} with {@code
   * OperationChain}, {@code Context}, {@code Store}.
   *
   * <ul>
   *   <li>Then calls {@link OperationChainOptimiser#optimise(OperationChain)}.
   * </ul>
   *
   * <p>Method under test: {@link OperationChainHandler#doOperation(OperationChain, Context, Store)}
   */
  @Test
  @DisplayName(
      "Test doOperation(OperationChain, Context, Store) with 'OperationChain', 'Context', 'Store'; then calls optimise(OperationChain)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object OperationChainHandler.doOperation(OperationChain, Context, Store)"})
  void testDoOperationWithOperationChainContextStore_thenCallsOptimise() throws OperationException {
    // Arrange
    OperationChainOptimiser operationChainOptimiser = mock(OperationChainOptimiser.class);
    when(operationChainOptimiser.optimise(Mockito.<OperationChain<Object>>any()))
        .thenThrow(new IllegalArgumentException());

    ArrayList<OperationChainOptimiser> opChainOptimisers = new ArrayList<>();
    opChainOptimisers.add(operationChainOptimiser);
    OperationChainHandler<Object> operationChainHandler =
        new OperationChainHandler<>(
            new OperationChainValidator(new ViewValidator()), opChainOptimisers);
    OperationChain<Object> operation = OperationChain.wrap(new NamedOperation<>());
    OperationChainDAO<Object> operationChain = new OperationChainDAO<>((Operation) operation);
    Context context = new Context();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            operationChainHandler.doOperation(
                operationChain, context, new TestAddToGraphLibraryImpl()));
    verify(operationChainOptimiser).optimise(isA(OperationChain.class));
  }

  /**
   * Test {@link OperationChainHandler#doOperation(OperationChain, Context, Store)} with {@code
   * OperationChain}, {@code Context}, {@code Store}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link OperationChainHandler#doOperation(OperationChain, Context, Store)}
   */
  @Test
  @DisplayName(
      "Test doOperation(OperationChain, Context, Store) with 'OperationChain', 'Context', 'Store'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object OperationChainHandler.doOperation(OperationChain, Context, Store)"})
  void testDoOperationWithOperationChainContextStore_thenThrowIllegalArgumentException()
      throws OperationException {
    // Arrange
    OperationChainValidator opChainValidator = new OperationChainValidator(new ViewValidator());
    OperationChainHandler<Object> operationChainHandler =
        new OperationChainHandler<>(opChainValidator, new ArrayList<>());
    OperationChain<Object> operationChain = OperationChain.wrap(new NamedOperation<>());
    Context context = new Context();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            operationChainHandler.doOperation(
                operationChain, context, new TestAddToGraphLibraryImpl()));
  }

  /**
   * Test {@link OperationChainHandler#doOperation(OperationChain, Context, Store)} with {@code
   * OperationChain}, {@code Context}, {@code Store}.
   *
   * <ul>
   *   <li>When {@link OperationChain#OperationChain()}.
   * </ul>
   *
   * <p>Method under test: {@link OperationChainHandler#doOperation(OperationChain, Context, Store)}
   */
  @Test
  @DisplayName(
      "Test doOperation(OperationChain, Context, Store) with 'OperationChain', 'Context', 'Store'; when OperationChain()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object OperationChainHandler.doOperation(OperationChain, Context, Store)"})
  void testDoOperationWithOperationChainContextStore_whenOperationChain()
      throws OperationException {
    // Arrange
    OperationChainValidator opChainValidator = new OperationChainValidator(new ViewValidator());
    OperationChainHandler<Object> operationChainHandler =
        new OperationChainHandler<>(opChainValidator, new ArrayList<>());
    OperationChain<Object> operationChain = new OperationChain<>();
    Context context = new Context();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            operationChainHandler.doOperation(
                operationChain, context, new TestAddToGraphLibraryImpl()));
  }

  /**
   * Test {@link OperationChainHandler#prepareOperationChain(OperationChain, Context, Store)}.
   *
   * <p>Method under test: {@link OperationChainHandler#prepareOperationChain(OperationChain,
   * Context, Store)}
   */
  @Test
  @DisplayName("Test prepareOperationChain(OperationChain, Context, Store)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "OperationChain OperationChainHandler.prepareOperationChain(OperationChain, Context, Store)"
  })
  void testPrepareOperationChain() {
    // Arrange
    OperationChainValidator opChainValidator = new OperationChainValidator(new ViewValidator());
    OperationChainHandler<Object> operationChainHandler =
        new OperationChainHandler<>(opChainValidator, new ArrayList<>());
    OperationChain<Object> operation = OperationChain.wrap(new NamedOperation<>());
    OperationChainDAO<Object> operationChain = new OperationChainDAO<>((Operation) operation);
    Context context = new Context();

    // Act
    OperationChain<Object> actualPrepareOperationChainResult =
        operationChainHandler.prepareOperationChain(
            operationChain, context, new TestAddToGraphLibraryImpl());

    // Assert
    assertSame(operationChain, actualPrepareOperationChainResult);
  }

  /**
   * Test {@link OperationChainHandler#prepareOperationChain(OperationChain, Context, Store)}.
   *
   * <p>Method under test: {@link OperationChainHandler#prepareOperationChain(OperationChain,
   * Context, Store)}
   */
  @Test
  @DisplayName("Test prepareOperationChain(OperationChain, Context, Store)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "OperationChain OperationChainHandler.prepareOperationChain(OperationChain, Context, Store)"
  })
  void testPrepareOperationChain2() {
    // Arrange
    OperationChainOptimiser operationChainOptimiser = mock(OperationChainOptimiser.class);
    when(operationChainOptimiser.optimise(Mockito.<OperationChain<Object>>any()))
        .thenThrow(new IllegalArgumentException());

    ArrayList<OperationChainOptimiser> opChainOptimisers = new ArrayList<>();
    opChainOptimisers.add(operationChainOptimiser);
    OperationChainHandler<Object> operationChainHandler =
        new OperationChainHandler<>(
            new OperationChainValidator(new ViewValidator()), opChainOptimisers);
    OperationChain<Object> operation = OperationChain.wrap(new NamedOperation<>());
    OperationChainDAO<Object> operationChain = new OperationChainDAO<>((Operation) operation);
    Context context = new Context();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            operationChainHandler.prepareOperationChain(
                operationChain, context, new TestAddToGraphLibraryImpl()));
    verify(operationChainOptimiser).optimise(isA(OperationChain.class));
  }

  /**
   * Test {@link OperationChainHandler#prepareOperationChain(OperationChain, Context, Store)}.
   *
   * <ul>
   *   <li>Then return wrap {@link NamedOperation} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link OperationChainHandler#prepareOperationChain(OperationChain,
   * Context, Store)}
   */
  @Test
  @DisplayName(
      "Test prepareOperationChain(OperationChain, Context, Store); then return wrap NamedOperation (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "OperationChain OperationChainHandler.prepareOperationChain(OperationChain, Context, Store)"
  })
  void testPrepareOperationChain_thenReturnWrapNamedOperation() {
    // Arrange
    OperationChainOptimiser operationChainOptimiser = mock(OperationChainOptimiser.class);
    OperationChain<Object> wrapResult = OperationChain.wrap(new NamedOperation<>());
    when(operationChainOptimiser.optimise(Mockito.<OperationChain<Object>>any()))
        .thenReturn(wrapResult);

    ArrayList<OperationChainOptimiser> opChainOptimisers = new ArrayList<>();
    opChainOptimisers.add(operationChainOptimiser);
    OperationChainHandler<Object> operationChainHandler =
        new OperationChainHandler<>(
            new OperationChainValidator(new ViewValidator()), opChainOptimisers);
    OperationChain<Object> operation = OperationChain.wrap(new NamedOperation<>());
    OperationChainDAO<Object> operationChain = new OperationChainDAO<>((Operation) operation);
    Context context = new Context();

    // Act
    OperationChain<Object> actualPrepareOperationChainResult =
        operationChainHandler.prepareOperationChain(
            operationChain, context, new TestAddToGraphLibraryImpl());

    // Assert
    verify(operationChainOptimiser).optimise(isA(OperationChain.class));
    assertSame(wrapResult, actualPrepareOperationChainResult);
  }

  /**
   * Test {@link OperationChainHandler#prepareOperationChain(OperationChain, Context, Store)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link OperationChainHandler#prepareOperationChain(OperationChain,
   * Context, Store)}
   */
  @Test
  @DisplayName(
      "Test prepareOperationChain(OperationChain, Context, Store); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "OperationChain OperationChainHandler.prepareOperationChain(OperationChain, Context, Store)"
  })
  void testPrepareOperationChain_thenThrowIllegalArgumentException() {
    // Arrange
    OperationChainValidator opChainValidator = new OperationChainValidator(new ViewValidator());
    OperationChainHandler<Object> operationChainHandler =
        new OperationChainHandler<>(opChainValidator, new ArrayList<>());
    OperationChain<Object> operationChain = OperationChain.wrap(new NamedOperation<>());
    Context context = new Context();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            operationChainHandler.prepareOperationChain(
                operationChain, context, new TestAddToGraphLibraryImpl()));
  }

  /**
   * Test {@link OperationChainHandler#prepareOperationChain(OperationChain, Context, Store)}.
   *
   * <ul>
   *   <li>When {@link OperationChain#OperationChain()}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link OperationChainHandler#prepareOperationChain(OperationChain,
   * Context, Store)}
   */
  @Test
  @DisplayName(
      "Test prepareOperationChain(OperationChain, Context, Store); when OperationChain(); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "OperationChain OperationChainHandler.prepareOperationChain(OperationChain, Context, Store)"
  })
  void testPrepareOperationChain_whenOperationChain_thenThrowIllegalArgumentException() {
    // Arrange
    OperationChainValidator opChainValidator = new OperationChainValidator(new ViewValidator());
    OperationChainHandler<Object> operationChainHandler =
        new OperationChainHandler<>(opChainValidator, new ArrayList<>());
    OperationChain<Object> operationChain = new OperationChain<>();
    Context context = new Context();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            operationChainHandler.prepareOperationChain(
                operationChain, context, new TestAddToGraphLibraryImpl()));
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link OperationChainHandler#OperationChainHandler(OperationChainValidator, List)}
   *   <li>{@link OperationChainHandler#getOpChainOptimisers()}
   *   <li>{@link OperationChainHandler#getOpChainValidator()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void OperationChainHandler.<init>(OperationChainValidator, List)",
    "List OperationChainHandler.getOpChainOptimisers()",
    "OperationChainValidator OperationChainHandler.getOpChainValidator()"
  })
  void testGettersAndSetters() {
    // Arrange
    OperationChainValidator opChainValidator = new OperationChainValidator(new ViewValidator());
    ArrayList<OperationChainOptimiser> opChainOptimisers = new ArrayList<>();

    // Act
    OperationChainHandler<Object> actualOperationChainHandler =
        new OperationChainHandler<>(opChainValidator, opChainOptimisers);
    List<OperationChainOptimiser> actualOpChainOptimisers =
        actualOperationChainHandler.getOpChainOptimisers();
    OperationChainValidator actualOpChainValidator =
        actualOperationChainHandler.getOpChainValidator();

    // Assert
    assertTrue(actualOpChainOptimisers.isEmpty());
    assertSame(opChainOptimisers, actualOpChainOptimisers);
    assertSame(opChainValidator, actualOpChainValidator);
  }
}
