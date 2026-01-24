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

package uk.gov.gchq.gaffer.spark.function;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.graphframes.GraphFrame;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class GraphFrameToIterableRowDiffblueTest {
  /**
   * Test {@link GraphFrameToIterableRow#apply(GraphFrame)} with {@code GraphFrame}.
   *
   * <ul>
   *   <li>Then return spliterator ExactSizeIfKnown is minus one.
   * </ul>
   *
   * <p>Method under test: {@link GraphFrameToIterableRow#apply(GraphFrame)}
   */
  @Test
  @DisplayName(
      "Test apply(GraphFrame) with 'GraphFrame'; then return spliterator ExactSizeIfKnown is minus one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Iterable GraphFrameToIterableRow.apply(GraphFrame)"})
  void testApplyWithGraphFrame_thenReturnSpliteratorExactSizeIfKnownIsMinusOne() {
    // Arrange
    GraphFrameToIterableRow graphFrameToIterableRow = new GraphFrameToIterableRow();

    Dataset<Row> _vertices = mock(Dataset.class);

    ArrayList<Row> rowList = new ArrayList<>();
    when(_vertices.toLocalIterator()).thenReturn(rowList.iterator());

    Dataset<Row> _edges = mock(Dataset.class);

    ArrayList<Row> rowList2 = new ArrayList<>();
    when(_edges.toLocalIterator()).thenReturn(rowList2.iterator());

    GraphFrame graphFrame = new GraphFrame(_vertices, _edges);

    // Act
    Iterable<Row> actualApplyResult = graphFrameToIterableRow.apply(graphFrame);

    // Assert
    verify(_vertices).toLocalIterator();
    verify(_edges).toLocalIterator();
    assertEquals(-1L, actualApplyResult.spliterator().getExactSizeIfKnown());
  }
}
