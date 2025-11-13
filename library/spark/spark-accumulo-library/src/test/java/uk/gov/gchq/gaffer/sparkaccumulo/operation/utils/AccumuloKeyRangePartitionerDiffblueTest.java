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

package uk.gov.gchq.gaffer.sparkaccumulo.operation.utils;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.accumulostore.AccumuloStore;
import uk.gov.gchq.gaffer.operation.OperationException;
import uk.gov.gchq.gaffer.store.StoreException;

class AccumuloKeyRangePartitionerDiffblueTest {
  /**
   * Test {@link AccumuloKeyRangePartitioner#AccumuloKeyRangePartitioner(AccumuloStore)}.
   *
   * <ul>
   *   <li>Then throw {@link OperationException}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AccumuloKeyRangePartitioner#AccumuloKeyRangePartitioner(AccumuloStore)}
   */
  @Test
  @DisplayName("Test new AccumuloKeyRangePartitioner(AccumuloStore); then throw OperationException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AccumuloKeyRangePartitioner.<init>(AccumuloStore)"})
  void testNewAccumuloKeyRangePartitioner_thenThrowOperationException()
      throws OperationException, StoreException {
    // Arrange
    AccumuloStore store = mock(AccumuloStore.class);
    when(store.getConnection()).thenThrow(new StoreException("An error occurred"));

    // Act and Assert
    assertThrows(OperationException.class, () -> new AccumuloKeyRangePartitioner(store));
    verify(store).getConnection();
  }

  /**
   * Test {@link AccumuloKeyRangePartitioner#getSplits(AccumuloStore)}.
   *
   * <ul>
   *   <li>Then throw {@link OperationException}.
   * </ul>
   *
   * <p>Method under test: {@link AccumuloKeyRangePartitioner#getSplits(AccumuloStore)}
   */
  @Test
  @DisplayName("Test getSplits(AccumuloStore); then throw OperationException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String[] AccumuloKeyRangePartitioner.getSplits(AccumuloStore)"})
  void testGetSplits_thenThrowOperationException() throws OperationException, StoreException {
    // Arrange
    AccumuloStore store = mock(AccumuloStore.class);
    when(store.getConnection()).thenThrow(new StoreException("An error occurred"));

    // Act and Assert
    assertThrows(OperationException.class, () -> AccumuloKeyRangePartitioner.getSplits(store));
    verify(store).getConnection();
  }
}
