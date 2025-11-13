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
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.apache.hadoop.io.NullWritable;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import scala.Tuple2;
import uk.gov.gchq.gaffer.data.element.Edge;
import uk.gov.gchq.gaffer.data.element.Element;
import uk.gov.gchq.gaffer.sparkaccumulo.operation.handler.javardd.GetJavaRDDOfElementsInRangesHandler.FirstElement;

class GetJavaRDDOfElementsInRangesHandlerDiffblueTest {
  /**
   * Test FirstElement {@link FirstElement#call(Tuple2)} with {@code Tuple2}.
   * <ul>
   *   <li>Then return {@link Tuple2#Tuple2(Object, Object)} with _1 is {@link Edge#Edge(String)} and _2 is {@link NullWritable#get()} {@link Tuple2#_1}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FirstElement#call(Tuple2)}
   */
  @Test
  @DisplayName("Test FirstElement call(Tuple2) with 'Tuple2'; then return Tuple2(Object, Object) with _1 is Edge(String) and _2 is get() _1")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Element FirstElement.call(Tuple2)"})
  void testFirstElementCallWithTuple2_thenReturnTuple2With_1IsEdgeAnd_2IsGet_1() throws Exception {
    // Arrange
    FirstElement firstElement = new FirstElement();
    Edge edge = new Edge("Group");
    Tuple2<Element, NullWritable> tuple = new Tuple2<>(edge, NullWritable.get());

    // Act and Assert
    assertSame(tuple._1, firstElement.call(tuple));
  }
}
