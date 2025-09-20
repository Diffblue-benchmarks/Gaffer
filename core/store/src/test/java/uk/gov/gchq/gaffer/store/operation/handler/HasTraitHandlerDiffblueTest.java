package uk.gov.gchq.gaffer.store.operation.handler;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import uk.gov.gchq.gaffer.operation.OperationException;
import uk.gov.gchq.gaffer.operation.io.Output;
import uk.gov.gchq.gaffer.store.Context;
import uk.gov.gchq.gaffer.store.Store;
import uk.gov.gchq.gaffer.store.StoreTrait;
import uk.gov.gchq.gaffer.store.operation.HasTrait;

class HasTraitHandlerDiffblueTest {
  /**
   * Test {@link HasTraitHandler#doOperation(HasTrait, Context, Store)} with {@code HasTrait},
   * {@code Context}, {@code Store}.
   *
   * <ul>
   *   <li>Given empty string.
   * </ul>
   *
   * <p>Method under test: {@link HasTraitHandler#doOperation(HasTrait, Context, Store)}
   */
  @Test
  @DisplayName(
      "Test doOperation(HasTrait, Context, Store) with 'HasTrait', 'Context', 'Store'; given empty string")
  @Tag("MaintainedByDiffblue")
  void testDoOperationWithHasTraitContextStore_givenEmptyString() throws OperationException {
    // Arrange
    HasTraitHandler hasTraitHandler = new HasTraitHandler();

    HasTrait operation = new HasTrait();
    operation.addOption("", "");
    Context context = new Context();

    Store store = mock(Store.class);
    when(store.execute(Mockito.<Output<Set<StoreTrait>>>any(), Mockito.<Context>any()))
        .thenReturn(new HashSet<>());

    // Act
    Boolean actualDoOperationResult = hasTraitHandler.doOperation(operation, context, store);

    // Assert
    verify(store).execute(isA(Output.class), isA(Context.class));
    assertFalse(actualDoOperationResult);
  }

  /**
   * Test {@link HasTraitHandler#doOperation(HasTrait, Context, Store)} with {@code HasTrait},
   * {@code Context}, {@code Store}.
   *
   * <ul>
   *   <li>Given {@link HashSet#HashSet()}.
   *   <li>When {@link HasTrait} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link HasTraitHandler#doOperation(HasTrait, Context, Store)}
   */
  @Test
  @DisplayName(
      "Test doOperation(HasTrait, Context, Store) with 'HasTrait', 'Context', 'Store'; given HashSet(); when HasTrait (default constructor)")
  @Tag("MaintainedByDiffblue")
  void testDoOperationWithHasTraitContextStore_givenHashSet_whenHasTrait()
      throws OperationException {
    // Arrange
    HasTraitHandler hasTraitHandler = new HasTraitHandler();
    HasTrait operation = new HasTrait();
    Context context = new Context();

    Store store = mock(Store.class);
    when(store.execute(Mockito.<Output<Set<StoreTrait>>>any(), Mockito.<Context>any()))
        .thenReturn(new HashSet<>());

    // Act
    Boolean actualDoOperationResult = hasTraitHandler.doOperation(operation, context, store);

    // Assert
    verify(store).execute(isA(Output.class), isA(Context.class));
    assertFalse(actualDoOperationResult);
  }

  /**
   * Test {@link HasTraitHandler#doOperation(HasTrait, Context, Store)} with {@code HasTrait},
   * {@code Context}, {@code Store}.
   *
   * <ul>
   *   <li>Given {@code INGEST_AGGREGATION}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link HasTraitHandler#doOperation(HasTrait, Context, Store)}
   */
  @Test
  @DisplayName(
      "Test doOperation(HasTrait, Context, Store) with 'HasTrait', 'Context', 'Store'; given 'INGEST_AGGREGATION'; then return 'true'")
  @Tag("MaintainedByDiffblue")
  void testDoOperationWithHasTraitContextStore_givenIngestAggregation_thenReturnTrue()
      throws OperationException {
    // Arrange
    HasTraitHandler hasTraitHandler = new HasTraitHandler();

    HasTrait operation = new HasTrait();
    operation.setTrait(StoreTrait.INGEST_AGGREGATION);
    Context context = new Context();

    HashSet<StoreTrait> storeTraitSet = new HashSet<>();
    storeTraitSet.add(StoreTrait.INGEST_AGGREGATION);

    Store store = mock(Store.class);
    when(store.execute(Mockito.<Output<Set<StoreTrait>>>any(), Mockito.<Context>any()))
        .thenReturn(storeTraitSet);

    // Act
    Boolean actualDoOperationResult = hasTraitHandler.doOperation(operation, context, store);

    // Assert
    verify(store).execute(isA(Output.class), isA(Context.class));
    assertTrue(actualDoOperationResult);
  }

  /**
   * Test {@link HasTraitHandler#doOperation(HasTrait, Context, Store)} with {@code HasTrait},
   * {@code Context}, {@code Store}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link Store} {@link Store#execute(Output, Context)} return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link HasTraitHandler#doOperation(HasTrait, Context, Store)}
   */
  @Test
  @DisplayName(
      "Test doOperation(HasTrait, Context, Store) with 'HasTrait', 'Context', 'Store'; given 'null'; when Store execute(Output, Context) return 'null'")
  @Tag("MaintainedByDiffblue")
  void testDoOperationWithHasTraitContextStore_givenNull_whenStoreExecuteReturnNull()
      throws OperationException {
    // Arrange
    HasTraitHandler hasTraitHandler = new HasTraitHandler();
    HasTrait operation = new HasTrait();
    Context context = new Context();

    Store store = mock(Store.class);
    when(store.execute(Mockito.<Output<Set<StoreTrait>>>any(), Mockito.<Context>any()))
        .thenReturn(null);

    // Act
    Boolean actualDoOperationResult = hasTraitHandler.doOperation(operation, context, store);

    // Assert
    verify(store).execute(isA(Output.class), isA(Context.class));
    assertFalse(actualDoOperationResult);
  }

  /**
   * Test {@link HasTraitHandler#doOperation(HasTrait, Context, Store)} with {@code HasTrait},
   * {@code Context}, {@code Store}.
   *
   * <ul>
   *   <li>Given {@code Value}.
   * </ul>
   *
   * <p>Method under test: {@link HasTraitHandler#doOperation(HasTrait, Context, Store)}
   */
  @Test
  @DisplayName(
      "Test doOperation(HasTrait, Context, Store) with 'HasTrait', 'Context', 'Store'; given 'Value'")
  @Tag("MaintainedByDiffblue")
  void testDoOperationWithHasTraitContextStore_givenValue() throws OperationException {
    // Arrange
    HasTraitHandler hasTraitHandler = new HasTraitHandler();

    HasTrait operation = new HasTrait();
    operation.addOption("42", "Value");
    operation.addOption("", "");
    Context context = new Context();

    Store store = mock(Store.class);
    when(store.execute(Mockito.<Output<Set<StoreTrait>>>any(), Mockito.<Context>any()))
        .thenReturn(new HashSet<>());

    // Act
    Boolean actualDoOperationResult = hasTraitHandler.doOperation(operation, context, store);

    // Assert
    verify(store).execute(isA(Output.class), isA(Context.class));
    assertFalse(actualDoOperationResult);
  }

  /**
   * Test {@link HasTraitHandler#doOperation(HasTrait, Context, Store)} with {@code HasTrait},
   * {@code Context}, {@code Store}.
   *
   * <ul>
   *   <li>Given {@code Value}.
   * </ul>
   *
   * <p>Method under test: {@link HasTraitHandler#doOperation(HasTrait, Context, Store)}
   */
  @Test
  @DisplayName(
      "Test doOperation(HasTrait, Context, Store) with 'HasTrait', 'Context', 'Store'; given 'Value'")
  @Tag("MaintainedByDiffblue")
  void testDoOperationWithHasTraitContextStore_givenValue2() throws OperationException {
    // Arrange
    HasTraitHandler hasTraitHandler = new HasTraitHandler();

    HasTrait operation = new HasTrait();
    operation.addOption("FederatedStore.processed.", "42");
    operation.addOption("42", "Value");
    operation.addOption("", "");
    Context context = new Context();

    Store store = mock(Store.class);
    when(store.execute(Mockito.<Output<Set<StoreTrait>>>any(), Mockito.<Context>any()))
        .thenReturn(new HashSet<>());

    // Act
    Boolean actualDoOperationResult = hasTraitHandler.doOperation(operation, context, store);

    // Assert
    verify(store).execute(isA(Output.class), isA(Context.class));
    assertFalse(actualDoOperationResult);
  }
}
