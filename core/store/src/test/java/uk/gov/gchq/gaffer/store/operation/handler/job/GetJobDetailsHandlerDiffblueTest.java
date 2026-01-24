/*
 * Copyright 2026 Crown Copyright
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

package uk.gov.gchq.gaffer.store.operation.handler.job;

import static org.junit.jupiter.api.Assertions.assertThrows;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.operation.OperationException;
import uk.gov.gchq.gaffer.operation.impl.job.GetJobDetails;
import uk.gov.gchq.gaffer.store.Context;
import uk.gov.gchq.gaffer.store.Store;
import uk.gov.gchq.gaffer.store.operation.handler.TestAddToGraphLibraryImpl;

class GetJobDetailsHandlerDiffblueTest {
  /**
   * Test {@link GetJobDetailsHandler#doOperation(GetJobDetails, Context, Store)} with {@code
   * GetJobDetails}, {@code Context}, {@code Store}.
   *
   * <ul>
   *   <li>Then throw {@link OperationException}.
   * </ul>
   *
   * <p>Method under test: {@link GetJobDetailsHandler#doOperation(GetJobDetails, Context, Store)}
   */
  @Test
  @DisplayName(
      "Test doOperation(GetJobDetails, Context, Store) with 'GetJobDetails', 'Context', 'Store'; then throw OperationException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "uk.gov.gchq.gaffer.jobtracker.JobDetail GetJobDetailsHandler.doOperation(GetJobDetails, Context, Store)"
  })
  void testDoOperationWithGetJobDetailsContextStore_thenThrowOperationException()
      throws OperationException {
    // Arrange
    GetJobDetailsHandler getJobDetailsHandler = new GetJobDetailsHandler();
    GetJobDetails operation = new GetJobDetails();
    Context context = new Context();

    // Act and Assert
    assertThrows(
        OperationException.class,
        () ->
            getJobDetailsHandler.doOperation(operation, context, new TestAddToGraphLibraryImpl()));
  }
}
