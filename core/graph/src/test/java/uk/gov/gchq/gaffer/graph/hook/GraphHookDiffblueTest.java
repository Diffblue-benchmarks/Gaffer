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

package uk.gov.gchq.gaffer.graph.hook;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.operation.OperationChain;
import uk.gov.gchq.gaffer.store.Context;

class GraphHookDiffblueTest {
  /**
   * Method under test:
   * {@link GraphHook#postExecute(Object, OperationChain, Context)}
   */
  @Test
  void testPostExecute() {
    // Arrange
    AddOperationsToChain addOperationsToChain = new AddOperationsToChain();
    OperationChain<?> opChain = new OperationChain<>();

    // Act and Assert
    assertEquals("Result", addOperationsToChain.postExecute("Result", opChain, new Context()));
  }

  /**
   * Method under test:
   * {@link GraphHook#onFailure(Object, OperationChain, Context, Exception)}
   */
  @Test
  void testOnFailure() {
    // Arrange
    AddOperationsToChain addOperationsToChain = new AddOperationsToChain();
    OperationChain<?> opChain = new OperationChain<>();
    Context context = new Context();

    // Act and Assert
    assertEquals("Result", addOperationsToChain.onFailure("Result", opChain, context, new Exception("foo")));
  }
}
