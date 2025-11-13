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
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
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
import uk.gov.gchq.gaffer.user.User;
import uk.gov.gchq.gaffer.user.User.Builder;
import uk.gov.gchq.koryphe.ValidationResult;

class ValidateOperationChainHandlerDiffblueTest {
  /**
   * Test {@link ValidateOperationChainHandler#doOperation(ValidateOperationChain, Context, Store)} with {@code ValidateOperationChain}, {@code Context}, {@code Store}.
   * <p>
   * Method under test: {@link ValidateOperationChainHandler#doOperation(ValidateOperationChain, Context, Store)}
   */
  @Test
  @DisplayName("Test doOperation(ValidateOperationChain, Context, Store) with 'ValidateOperationChain', 'Context', 'Store'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "ValidationResult ValidateOperationChainHandler.doOperation(ValidateOperationChain, Context, Store)"})
  void testDoOperationWithValidateOperationChainContextStore() throws OperationException {
    // Arrange
    ValidateOperationChainHandler validateOperationChainHandler = new ValidateOperationChainHandler();
    ValidateOperationChain operation = new ValidateOperationChain();
    Context context = mock(Context.class);
    User buildResult = (new Builder()).userId("42").build();
    when(context.getUser()).thenReturn(buildResult);
    OperationChainValidator operationChainValidator = mock(OperationChainValidator.class);
    ValidationResult validationResult = new ValidationResult("An error occurred");
    when(operationChainValidator.validate(Mockito.<OperationChain<Object>>any(), Mockito.<User>any(),
        Mockito.<Store>any())).thenReturn(validationResult);
    Store store = mock(Store.class);
    when(store.getOperationChainValidator()).thenReturn(operationChainValidator);

    // Act
    ValidationResult actualDoOperationResult = validateOperationChainHandler.doOperation(operation, context, store);

    // Assert
    verify(context).getUser();
    verify(store).getOperationChainValidator();
    verify(operationChainValidator).validate(isNull(), isA(User.class), isA(Store.class));
    assertSame(validationResult, actualDoOperationResult);
  }
}
