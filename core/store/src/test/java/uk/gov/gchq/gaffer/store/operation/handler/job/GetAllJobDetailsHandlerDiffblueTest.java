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

package uk.gov.gchq.gaffer.store.operation.handler.job;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import uk.gov.gchq.gaffer.jobtracker.JobDetail;
import uk.gov.gchq.gaffer.jobtracker.JobTracker;
import uk.gov.gchq.gaffer.operation.OperationException;
import uk.gov.gchq.gaffer.operation.impl.job.GetAllJobDetails;
import uk.gov.gchq.gaffer.store.Context;
import uk.gov.gchq.gaffer.store.Store;
import uk.gov.gchq.gaffer.store.operation.handler.TestAddToGraphLibraryImpl;
import uk.gov.gchq.gaffer.user.User;

class GetAllJobDetailsHandlerDiffblueTest {
  /**
   * Test {@link GetAllJobDetailsHandler#doOperation(GetAllJobDetails, Context, Store)} with {@code
   * GetAllJobDetails}, {@code Context}, {@code Store}.
   *
   * <ul>
   *   <li>Then return {@link List}.
   * </ul>
   *
   * <p>Method under test: {@link GetAllJobDetailsHandler#doOperation(GetAllJobDetails, Context,
   * Store)}
   */
  @Test
  @DisplayName(
      "Test doOperation(GetAllJobDetails, Context, Store) with 'GetAllJobDetails', 'Context', 'Store'; then return List")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Iterable GetAllJobDetailsHandler.doOperation(GetAllJobDetails, Context, Store)"
  })
  void testDoOperationWithGetAllJobDetailsContextStore_thenReturnList() throws OperationException {
    // Arrange
    GetAllJobDetailsHandler getAllJobDetailsHandler = new GetAllJobDetailsHandler();
    GetAllJobDetails operation = new GetAllJobDetails();
    Context context = new Context();

    JobTracker jobTracker = mock(JobTracker.class);
    when(jobTracker.getAllJobs(Mockito.<User>any())).thenReturn(new ArrayList<>());

    TestAddToGraphLibraryImpl store = mock(TestAddToGraphLibraryImpl.class);
    when(store.getJobTracker()).thenReturn(jobTracker);

    // Act
    Iterable<JobDetail> actualDoOperationResult =
        getAllJobDetailsHandler.doOperation(operation, context, store);
    Iterator<JobDetail> actualIteratorResult = actualDoOperationResult.iterator();

    // Assert
    verify(jobTracker).getAllJobs(isA(User.class));
    verify(store, atLeast(1)).getJobTracker();
    assertTrue(actualDoOperationResult instanceof List);
    assertFalse(actualIteratorResult.hasNext());
    assertTrue(((List<JobDetail>) actualDoOperationResult).isEmpty());
  }
}
