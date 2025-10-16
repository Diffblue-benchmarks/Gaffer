package uk.gov.gchq.gaffer.spark.function;

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
   *   <li>Then calls {@link Dataset#toLocalIterator()}.
   * </ul>
   *
   * <p>Method under test: {@link GraphFrameToIterableRow#apply(GraphFrame)}
   */
  @Test
  @DisplayName("Test apply(GraphFrame) with 'GraphFrame'; then calls toLocalIterator()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.Iterable GraphFrameToIterableRow.apply(GraphFrame)"})
  void testApplyWithGraphFrame_thenCallsToLocalIterator() {
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
    graphFrameToIterableRow.apply(graphFrame);

    // Assert
    verify(_vertices).toLocalIterator();
    verify(_edges).toLocalIterator();
  }
}
