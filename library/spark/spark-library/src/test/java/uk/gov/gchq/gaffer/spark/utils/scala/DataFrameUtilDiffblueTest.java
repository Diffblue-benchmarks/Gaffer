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

package uk.gov.gchq.gaffer.spark.utils.scala;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.apache.spark.sql.Column;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class DataFrameUtilDiffblueTest {
  /**
   * Test {@link DataFrameUtil#emptyEdges(SparkSession)}.
   * <ul>
   *   <li>Given {@link Dataset} {@link Dataset#select(Column[])} return {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataFrameUtil#emptyEdges(SparkSession)}
   */
  @Test
  @DisplayName("Test emptyEdges(SparkSession); given Dataset select(Column[]) return 'null'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Dataset DataFrameUtil.emptyEdges(SparkSession)"})
  void testEmptyEdges_givenDatasetSelectReturnNull_thenReturnNull() {
    // Arrange
    Dataset<Row> dataset = mock(Dataset.class);
    when(dataset.select((Column[]) Mockito.any())).thenReturn(null);
    SparkSession sparkSession = mock(SparkSession.class);
    when(sparkSession.emptyDataFrame()).thenReturn(dataset);

    // Act
    Dataset<Row> actualEmptyEdgesResult = DataFrameUtil.emptyEdges(sparkSession);

    // Assert
    verify(dataset).select((Column[]) Mockito.any());
    verify(sparkSession).emptyDataFrame();
    assertNull(actualEmptyEdgesResult);
  }
}
