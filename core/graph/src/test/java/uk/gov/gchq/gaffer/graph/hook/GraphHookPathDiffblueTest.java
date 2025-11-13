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
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.operation.OperationChain;
import uk.gov.gchq.gaffer.store.Context;

class GraphHookPathDiffblueTest {
  /**
   * Test {@link GraphHookPath#preExecute(OperationChain, Context)}.
   * <p>
   * Method under test: {@link GraphHookPath#preExecute(OperationChain, Context)}
   */
  @Test
  @DisplayName("Test preExecute(OperationChain, Context)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void GraphHookPath.preExecute(OperationChain, Context)"})
  void testPreExecute() {
    // Arrange
    GraphHookPath graphHookPath = new GraphHookPath();
    OperationChain<?> opChain = new OperationChain<>();

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> graphHookPath.preExecute(opChain, new Context()));
  }

  /**
   * Test {@link GraphHookPath#postExecute(Object, OperationChain, Context)}.
   * <p>
   * Method under test: {@link GraphHookPath#postExecute(Object, OperationChain, Context)}
   */
  @Test
  @DisplayName("Test postExecute(Object, OperationChain, Context)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object GraphHookPath.postExecute(Object, OperationChain, Context)"})
  void testPostExecute() {
    // Arrange
    GraphHookPath graphHookPath = new GraphHookPath();
    OperationChain<?> opChain = new OperationChain<>();

    // Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> graphHookPath.postExecute("Result", opChain, new Context()));
  }

  /**
   * Test {@link GraphHookPath#onFailure(Object, OperationChain, Context, Exception)}.
   * <p>
   * Method under test: {@link GraphHookPath#onFailure(Object, OperationChain, Context, Exception)}
   */
  @Test
  @DisplayName("Test onFailure(Object, OperationChain, Context, Exception)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object GraphHookPath.onFailure(Object, OperationChain, Context, Exception)"})
  void testOnFailure() {
    // Arrange
    GraphHookPath graphHookPath = new GraphHookPath();
    OperationChain<?> opChain = new OperationChain<>();
    Context context = new Context();

    // Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> graphHookPath.onFailure("Result", opChain, context, new Exception("foo")));
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link GraphHookPath}
   *   <li>{@link GraphHookPath#setPath(String)}
   *   <li>{@link GraphHookPath#getPath()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void GraphHookPath.<init>()", "String GraphHookPath.getPath()",
      "void GraphHookPath.setPath(String)"})
  void testGettersAndSetters() {
    // Arrange and Act
    GraphHookPath actualGraphHookPath = new GraphHookPath();
    actualGraphHookPath.setPath("Path");

    // Assert
    assertEquals("Path", actualGraphHookPath.getPath());
  }
}
