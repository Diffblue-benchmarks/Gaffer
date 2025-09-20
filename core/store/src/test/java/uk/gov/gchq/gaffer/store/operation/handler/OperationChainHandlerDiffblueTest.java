package uk.gov.gchq.gaffer.store.operation.handler;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
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
import uk.gov.gchq.gaffer.operation.impl.OperationImpl;
import uk.gov.gchq.gaffer.operation.impl.compare.Max;
import uk.gov.gchq.gaffer.operation.serialisation.TypeReferenceImpl;
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
  @Tag("MaintainedByDiffblue")
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
   * <p>Method under test: {@link OperationChainHandler#doOperation(OperationChain, Context, Store)}
   */
  @Test
  @DisplayName(
      "Test doOperation(OperationChain, Context, Store) with 'OperationChain', 'Context', 'Store'")
  @Tag("MaintainedByDiffblue")
  void testDoOperationWithOperationChainContextStore2() throws OperationException {
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
   * <p>Method under test: {@link OperationChainHandler#doOperation(OperationChain, Context, Store)}
   */
  @Test
  @DisplayName(
      "Test doOperation(OperationChain, Context, Store) with 'OperationChain', 'Context', 'Store'")
  @Tag("MaintainedByDiffblue")
  void testDoOperationWithOperationChainContextStore3() throws OperationException {
    // Arrange
    ArrayList<OperationChainOptimiser> opChainOptimisers = new ArrayList<>();
    opChainOptimisers.add(mock(OperationChainOptimiser.class));
    OperationChainHandler<Object> operationChainHandler =
        new OperationChainHandler<>(
            new OperationChainValidator(new ViewValidator()), opChainOptimisers);
    OperationChainDAO<Object> operationChain = new OperationChainDAO<>(new OperationImpl());
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
   * <p>Method under test: {@link OperationChainHandler#doOperation(OperationChain, Context, Store)}
   */
  @Test
  @DisplayName(
      "Test doOperation(OperationChain, Context, Store) with 'OperationChain', 'Context', 'Store'")
  @Tag("MaintainedByDiffblue")
  void testDoOperationWithOperationChainContextStore4() throws OperationException {
    // Arrange
    ArrayList<OperationChainOptimiser> opChainOptimisers = new ArrayList<>();
    opChainOptimisers.add(mock(OperationChainOptimiser.class));
    OperationChainHandler<Object> operationChainHandler =
        new OperationChainHandler<>(
            new OperationChainValidator(new ViewValidator()), opChainOptimisers);
    OperationChainDAO<Object> operationChain = new OperationChainDAO<>(new Max());
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
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link OperationChainHandler#doOperation(OperationChain, Context, Store)}
   */
  @Test
  @DisplayName(
      "Test doOperation(OperationChain, Context, Store) with 'OperationChain', 'Context', 'Store'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  void testDoOperationWithOperationChainContextStore_thenReturnNull() throws OperationException {
    // Arrange
    OperationChainOptimiser operationChainOptimiser = mock(OperationChainOptimiser.class);
    OperationChain<Object> wrapResult = OperationChain.wrap(new OperationChain<>());
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
    Object actualDoOperationResult =
        operationChainHandler.doOperation(operationChain, context, new TestAddToGraphLibraryImpl());

    // Assert
    verify(operationChainOptimiser).optimise(isA(OperationChain.class));
    assertNull(actualDoOperationResult);
  }

  /**
   * Test {@link OperationChainHandler#doOperation(OperationChain, Context, Store)} with {@code
   * OperationChain}, {@code Context}, {@code Store}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link OperationChainHandler#doOperation(OperationChain, Context, Store)}
   */
  @Test
  @DisplayName(
      "Test doOperation(OperationChain, Context, Store) with 'OperationChain', 'Context', 'Store'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  void testDoOperationWithOperationChainContextStore_thenReturnNull2() throws OperationException {
    // Arrange
    OperationChainOptimiser operationChainOptimiser = mock(OperationChainOptimiser.class);
    OperationChain<Object> wrapResult = OperationChain.wrap(new OperationChain<>());
    when(operationChainOptimiser.optimise(Mockito.<OperationChain<Object>>any()))
        .thenReturn(wrapResult);

    ArrayList<OperationChainOptimiser> opChainOptimisers = new ArrayList<>();
    opChainOptimisers.add(operationChainOptimiser);
    OperationChainHandler<Object> operationChainHandler =
        new OperationChainHandler<>(
            new OperationChainValidator(new ViewValidator()), opChainOptimisers);

    Max operation = new Max();
    operation.setComparators(new ArrayList<>());
    OperationChainDAO<Object> operationChain = new OperationChainDAO<>(operation);
    Context context = new Context();

    // Act
    Object actualDoOperationResult =
        operationChainHandler.doOperation(operationChain, context, new TestAddToGraphLibraryImpl());

    // Assert
    verify(operationChainOptimiser).optimise(isA(OperationChain.class));
    assertNull(actualDoOperationResult);
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
  @Tag("MaintainedByDiffblue")
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
   * Test {@link OperationChainHandler#doOperation(OperationChain, Context, Store)} with {@code
   * OperationChain}, {@code Context}, {@code Store}.
   *
   * <ul>
   *   <li>When wrap {@link NamedOperation} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link OperationChainHandler#doOperation(OperationChain, Context, Store)}
   */
  @Test
  @DisplayName(
      "Test doOperation(OperationChain, Context, Store) with 'OperationChain', 'Context', 'Store'; when wrap NamedOperation (default constructor)")
  @Tag("MaintainedByDiffblue")
  void testDoOperationWithOperationChainContextStore_whenWrapNamedOperation()
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
   * Test {@link OperationChainHandler#prepareOperationChain(OperationChain, Context, Store)}.
   *
   * <p>Method under test: {@link OperationChainHandler#prepareOperationChain(OperationChain,
   * Context, Store)}
   */
  @Test
  @DisplayName("Test prepareOperationChain(OperationChain, Context, Store)")
  @Tag("MaintainedByDiffblue")
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
  @Tag("MaintainedByDiffblue")
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
   *   <li>Given {@link ArrayList#ArrayList()}.
   *   <li>Then return Operations size is one.
   * </ul>
   *
   * <p>Method under test: {@link OperationChainHandler#prepareOperationChain(OperationChain,
   * Context, Store)}
   */
  @Test
  @DisplayName(
      "Test prepareOperationChain(OperationChain, Context, Store); given ArrayList(); then return Operations size is one")
  @Tag("MaintainedByDiffblue")
  void testPrepareOperationChain_givenArrayList_thenReturnOperationsSizeIsOne() {
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

    Max operation = new Max();
    operation.setComparators(new ArrayList<>());
    OperationChainDAO<Object> operationChain = new OperationChainDAO<>(operation);
    Context context = new Context();

    // Act
    OperationChain<Object> actualPrepareOperationChainResult =
        operationChainHandler.prepareOperationChain(
            operationChain, context, new TestAddToGraphLibraryImpl());

    // Assert
    verify(operationChainOptimiser).optimise(isA(OperationChain.class));
    List<Operation> operations = actualPrepareOperationChainResult.getOperations();
    assertEquals(1, operations.size());
    Operation getResult = operations.get(0);
    assertTrue(getResult instanceof NamedOperation);
    assertTrue(
        ((NamedOperation<Object, Object>) getResult).getOutputTypeReference()
            instanceof TypeReferenceImpl.Object);
    assertTrue(
        actualPrepareOperationChainResult.getOutputTypeReference()
            instanceof TypeReferenceImpl.Object);
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
  @Tag("MaintainedByDiffblue")
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
   *   <li>When {@link OperationChainDAO#OperationChainDAO(Operation)} with operation is {@link Max}
   *       (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link OperationChainHandler#prepareOperationChain(OperationChain,
   * Context, Store)}
   */
  @Test
  @DisplayName(
      "Test prepareOperationChain(OperationChain, Context, Store); when OperationChainDAO(Operation) with operation is Max (default constructor)")
  @Tag("MaintainedByDiffblue")
  void testPrepareOperationChain_whenOperationChainDAOWithOperationIsMax() {
    // Arrange
    ArrayList<OperationChainOptimiser> opChainOptimisers = new ArrayList<>();
    opChainOptimisers.add(mock(OperationChainOptimiser.class));
    OperationChainHandler<Object> operationChainHandler =
        new OperationChainHandler<>(
            new OperationChainValidator(new ViewValidator()), opChainOptimisers);
    OperationChainDAO<Object> operationChain = new OperationChainDAO<>(new Max());
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
   *   <li>When {@link OperationChainDAO#OperationChainDAO(Operation)} with operation is {@link
   *       OperationImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link OperationChainHandler#prepareOperationChain(OperationChain,
   * Context, Store)}
   */
  @Test
  @DisplayName(
      "Test prepareOperationChain(OperationChain, Context, Store); when OperationChainDAO(Operation) with operation is OperationImpl (default constructor)")
  @Tag("MaintainedByDiffblue")
  void testPrepareOperationChain_whenOperationChainDAOWithOperationIsOperationImpl() {
    // Arrange
    ArrayList<OperationChainOptimiser> opChainOptimisers = new ArrayList<>();
    opChainOptimisers.add(mock(OperationChainOptimiser.class));
    OperationChainHandler<Object> operationChainHandler =
        new OperationChainHandler<>(
            new OperationChainValidator(new ViewValidator()), opChainOptimisers);
    OperationChainDAO<Object> operationChain = new OperationChainDAO<>(new OperationImpl());
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
  @Tag("MaintainedByDiffblue")
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
   * Test {@link OperationChainHandler#prepareOperationChain(OperationChain, Context, Store)}.
   *
   * <ul>
   *   <li>When wrap {@link NamedOperation} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link OperationChainHandler#prepareOperationChain(OperationChain,
   * Context, Store)}
   */
  @Test
  @DisplayName(
      "Test prepareOperationChain(OperationChain, Context, Store); when wrap NamedOperation (default constructor)")
  @Tag("MaintainedByDiffblue")
  void testPrepareOperationChain_whenWrapNamedOperation() {
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
  @Tag("MaintainedByDiffblue")
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
