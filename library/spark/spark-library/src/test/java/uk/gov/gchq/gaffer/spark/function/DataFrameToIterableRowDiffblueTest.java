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

package uk.gov.gchq.gaffer.spark.function;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.Iterator;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class DataFrameToIterableRowDiffblueTest {
  /**
   * Test {@link DataFrameToIterableRow#apply(Dataset)} with {@code Dataset}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} iterator.
   *   <li>Then return not iterator hasNext.
   * </ul>
   *
   * <p>Method under test: {@link DataFrameToIterableRow#apply(Dataset)}
   */
  @Test
  @DisplayName(
      "Test apply(Dataset) with 'Dataset'; given ArrayList() iterator; then return not iterator hasNext")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.Iterable DataFrameToIterableRow.apply(Dataset)"})
  void testApplyWithDataset_givenArrayListIterator_thenReturnNotIteratorHasNext() {
    // Arrange
    DataFrameToIterableRow dataFrameToIterableRow = new DataFrameToIterableRow();

    Dataset<Row> dataset = mock(Dataset.class);

    ArrayList<Row> rowList = new ArrayList<>();
    when(dataset.toLocalIterator()).thenReturn(rowList.iterator());

    // Act
    Iterator<? extends Row> actualIteratorResult = dataFrameToIterableRow.apply(dataset).iterator();

    // Assert
    verify(dataset).toLocalIterator();
    assertFalse(actualIteratorResult.hasNext());
  }
}
