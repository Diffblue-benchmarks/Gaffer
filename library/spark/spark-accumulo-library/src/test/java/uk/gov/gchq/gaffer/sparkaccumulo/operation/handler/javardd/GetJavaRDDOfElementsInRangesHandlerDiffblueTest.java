package uk.gov.gchq.gaffer.sparkaccumulo.operation.handler.javardd;

import static org.junit.jupiter.api.Assertions.assertSame;
import org.apache.hadoop.io.NullWritable;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import scala.Tuple2;
import uk.gov.gchq.gaffer.data.element.Edge;
import uk.gov.gchq.gaffer.data.element.Edge.Builder;
import uk.gov.gchq.gaffer.data.element.Element;
import uk.gov.gchq.gaffer.data.element.id.EdgeId;
import uk.gov.gchq.gaffer.data.element.id.EdgeId.MatchedVertex;
import uk.gov.gchq.gaffer.sparkaccumulo.operation.handler.javardd.GetJavaRDDOfElementsInRangesHandler.FirstElement;

class GetJavaRDDOfElementsInRangesHandlerDiffblueTest {
  /**
   * Test FirstElement {@link FirstElement#call(Tuple2)} with {@code Tuple2}.
   *
   * <p>Method under test: {@link FirstElement#call(Tuple2)}
   */
  @Test
  @DisplayName("Test FirstElement call(Tuple2) with 'Tuple2'")
  @Tag("MaintainedByDiffblue")
  void testFirstElementCallWithTuple2() throws Exception {
    // Arrange
    FirstElement firstElement = new FirstElement();
    Edge edge =
        new Builder()
            .dest("Dest")
            .directed(true)
            .group("Group")
            .matchedVertex(MatchedVertex.SOURCE)
            .source("Source")
            .build();
    Tuple2<Element, NullWritable> tuple = new Tuple2<>(edge, NullWritable.get());

    // Act
    Element actualCallResult = firstElement.call(tuple);

    // Assert
    assertSame(tuple._1, actualCallResult);
  }
}
