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

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.Iterator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.data.element.Element;
import uk.gov.gchq.gaffer.operation.OperationException;
import uk.gov.gchq.gaffer.operation.impl.Validate;
import uk.gov.gchq.gaffer.store.Context;
import uk.gov.gchq.gaffer.store.Store;
import uk.gov.gchq.gaffer.store.ValidatedElements;
import uk.gov.gchq.gaffer.store.schema.Schema;

class ValidateHandlerDiffblueTest {
  /**
   * Test {@link ValidateHandler#doOperation(Validate, Context, Store)} with {@code operation}, {@code context}, {@code store}.
   * <ul>
   *   <li>Then return {@link ValidatedElements}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ValidateHandler#doOperation(Validate, Context, Store)}
   */
  @Test
  @DisplayName("Test doOperation(Validate, Context, Store) with 'operation', 'context', 'store'; then return ValidatedElements")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Iterable ValidateHandler.doOperation(Validate, Context, Store)"})
  void testDoOperationWithOperationContextStore_thenReturnValidatedElements() throws OperationException {
    // Arrange
    ValidateHandler validateHandler = new ValidateHandler();

    Validate operation = new Validate();
    operation.setInput(new ArrayList<>());
    Context context = new Context();

    // Act
    Iterable<? extends Element> actualDoOperationResult = validateHandler.doOperation(operation, context,
        new TestAddToGraphLibraryImpl());
    Iterator<? extends Element> actualIteratorResult = actualDoOperationResult.iterator();

    // Assert
    assertTrue(actualDoOperationResult instanceof ValidatedElements);
    assertFalse(actualDoOperationResult.iterator().hasNext());
    assertFalse(actualIteratorResult.hasNext());
  }

  /**
   * Test {@link ValidateHandler#doOperation(Validate, Schema)} with {@code operation}, {@code schema}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return {@link ValidatedElements}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ValidateHandler#doOperation(Validate, Schema)}
   */
  @Test
  @DisplayName("Test doOperation(Validate, Schema) with 'operation', 'schema'; given ArrayList(); then return ValidatedElements")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Iterable ValidateHandler.doOperation(Validate, Schema)"})
  void testDoOperationWithOperationSchema_givenArrayList_thenReturnValidatedElements() {
    // Arrange
    ValidateHandler validateHandler = new ValidateHandler();

    Validate operation = new Validate();
    operation.setInput(new ArrayList<>());

    // Act
    Iterable<? extends Element> actualDoOperationResult = validateHandler.doOperation(operation, new Schema());
    Iterator<? extends Element> actualIteratorResult = actualDoOperationResult.iterator();

    // Assert
    assertTrue(actualDoOperationResult instanceof ValidatedElements);
    assertFalse(actualDoOperationResult.iterator().hasNext());
    assertFalse(actualIteratorResult.hasNext());
  }
}
