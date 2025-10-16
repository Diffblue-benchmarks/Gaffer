package uk.gov.gchq.gaffer.store.operation.handler;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.operation.OperationException;
import uk.gov.gchq.gaffer.store.Context;
import uk.gov.gchq.gaffer.store.Store;
import uk.gov.gchq.gaffer.store.operation.GetSchema;

class GetSchemaHandlerDiffblueTest {
  /**
   * Test {@link GetSchemaHandler#doOperation(GetSchema, Context, Store)} with {@code GetSchema},
   * {@code Context}, {@code Store}.
   *
   * <ul>
   *   <li>When {@link GetSchema} (default constructor).
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link GetSchemaHandler#doOperation(GetSchema, Context, Store)}
   */
  @Test
  @DisplayName(
      "Test doOperation(GetSchema, Context, Store) with 'GetSchema', 'Context', 'Store'; when GetSchema (default constructor); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "uk.gov.gchq.gaffer.store.schema.Schema GetSchemaHandler.doOperation(GetSchema, Context, Store)"
  })
  void testDoOperationWithGetSchemaContextStore_whenGetSchema_thenReturnNull()
      throws OperationException {
    // Arrange
    GetSchemaHandler getSchemaHandler = new GetSchemaHandler();
    GetSchema operation = new GetSchema();
    Context context = new Context();

    // Act and Assert
    assertNull(getSchemaHandler.doOperation(operation, context, new TestAddToGraphLibraryImpl()));
  }

  /**
   * Test {@link GetSchemaHandler#doOperation(GetSchema, Context, Store)} with {@code GetSchema},
   * {@code Context}, {@code Store}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then throw {@link OperationException}.
   * </ul>
   *
   * <p>Method under test: {@link GetSchemaHandler#doOperation(GetSchema, Context, Store)}
   */
  @Test
  @DisplayName(
      "Test doOperation(GetSchema, Context, Store) with 'GetSchema', 'Context', 'Store'; when 'null'; then throw OperationException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "uk.gov.gchq.gaffer.store.schema.Schema GetSchemaHandler.doOperation(GetSchema, Context, Store)"
  })
  void testDoOperationWithGetSchemaContextStore_whenNull_thenThrowOperationException()
      throws OperationException {
    // Arrange
    GetSchemaHandler getSchemaHandler = new GetSchemaHandler();
    Context context = new Context();

    // Act and Assert
    assertThrows(
        OperationException.class,
        () -> getSchemaHandler.doOperation(null, context, new TestAddToGraphLibraryImpl()));
  }
}
