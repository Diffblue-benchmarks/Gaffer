package uk.gov.gchq.gaffer.store.operation.handler;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import uk.gov.gchq.gaffer.operation.OperationChain;
import uk.gov.gchq.gaffer.operation.OperationException;
import uk.gov.gchq.gaffer.operation.impl.ValidateOperationChain;
import uk.gov.gchq.gaffer.store.Context;
import uk.gov.gchq.gaffer.store.Store;
import uk.gov.gchq.gaffer.store.operation.OperationChainValidator;
import uk.gov.gchq.gaffer.store.operation.OperationUtil;
import uk.gov.gchq.gaffer.user.User;
import uk.gov.gchq.gaffer.user.User.Builder;
import uk.gov.gchq.koryphe.ValidationResult;

class ValidateOperationChainHandlerDiffblueTest {
  /**
   * Test {@link ValidateOperationChainHandler#doOperation(ValidateOperationChain, Context, Store)}
   * with {@code ValidateOperationChain}, {@code Context}, {@code Store}.
   *
   * <p>Method under test: {@link ValidateOperationChainHandler#doOperation(ValidateOperationChain,
   * Context, Store)}
   */
  @Test
  @DisplayName(
      "Test doOperation(ValidateOperationChain, Context, Store) with 'ValidateOperationChain', 'Context', 'Store'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ValidationResult ValidateOperationChainHandler.doOperation(ValidateOperationChain, Context, Store)"
  })
  void testDoOperationWithValidateOperationChainContextStore() throws OperationException {
    // Arrange
    ValidateOperationChainHandler validateOperationChainHandler =
        new ValidateOperationChainHandler();
    ValidateOperationChain operation = new ValidateOperationChain();

    Context context = mock(Context.class);
    when(context.getUser()).thenReturn(new Builder().userId("42").build());

    OperationChainValidator operationChainValidator = mock(OperationChainValidator.class);
    Class<Object> output = Object.class;
    Class<Object> input = Object.class;

    ValidationResult isValidResult = OperationUtil.isValid(output, input);
    when(operationChainValidator.validate(
            Mockito.<OperationChain<?>>any(), Mockito.<User>any(), Mockito.<Store>any()))
        .thenReturn(isValidResult);

    Store store = mock(Store.class);
    when(store.getOperationChainValidator()).thenReturn(operationChainValidator);

    // Act
    ValidationResult actualDoOperationResult =
        validateOperationChainHandler.doOperation(operation, context, store);

    // Assert
    verify(context).getUser();
    verify(store).getOperationChainValidator();
    verify(operationChainValidator).validate(isNull(), isA(User.class), isA(Store.class));
    assertSame(isValidResult, actualDoOperationResult);
  }
}
