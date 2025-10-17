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

package uk.gov.gchq.gaffer.sparkaccumulo.operation.handler.javardd;

import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
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
import uk.gov.gchq.gaffer.sparkaccumulo.operation.handler.javardd.GetJavaRDDOfElementsHandler.FirstElement;

class GetJavaRDDOfElementsHandlerDiffblueTest {
  /**
   * Test FirstElement {@link FirstElement#call(Tuple2)} with {@code Tuple2}.
   *
   * <p>Method under test: {@link FirstElement#call(Tuple2)}
   */
  @Test
  @DisplayName("Test FirstElement call(Tuple2) with 'Tuple2'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Element FirstElement.call(Tuple2)"})
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
