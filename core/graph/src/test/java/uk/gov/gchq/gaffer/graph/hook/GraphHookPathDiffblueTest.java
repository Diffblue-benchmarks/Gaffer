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
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.operation.OperationChain;
import uk.gov.gchq.gaffer.store.Context;

class GraphHookPathDiffblueTest {
  /**
   * Method under test: {@link GraphHookPath#preExecute(OperationChain, Context)}
   */
  @Test
  void testPreExecute() {
    // Arrange
    GraphHookPath graphHookPath = new GraphHookPath();
    OperationChain<?> opChain = new OperationChain<>();

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> graphHookPath.preExecute(opChain, new Context()));
  }

  /**
   * Method under test:
   * {@link GraphHookPath#postExecute(Object, OperationChain, Context)}
   */
  @Test
  void testPostExecute() {
    // Arrange
    GraphHookPath graphHookPath = new GraphHookPath();
    OperationChain<?> opChain = new OperationChain<>();

    // Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> graphHookPath.postExecute("Result", opChain, new Context()));
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link GraphHookPath}
   *   <li>{@link GraphHookPath#setPath(String)}
   *   <li>{@link GraphHookPath#getPath()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    GraphHookPath actualGraphHookPath = new GraphHookPath();
    actualGraphHookPath.setPath("Path");

    // Assert that nothing has changed
    assertEquals("Path", actualGraphHookPath.getPath());
  }

  /**
   * Method under test:
   * {@link GraphHookPath#onFailure(Object, OperationChain, Context, Exception)}
   */
  @Test
  void testOnFailure() {
    // Arrange
    GraphHookPath graphHookPath = new GraphHookPath();
    OperationChain<?> opChain = new OperationChain<>();
    Context context = new Context();

    // Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> graphHookPath.onFailure("Result", opChain, context, new Exception("foo")));
  }
}
