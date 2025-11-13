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
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.operation.Operation;
import uk.gov.gchq.gaffer.operation.OperationChain;
import uk.gov.gchq.gaffer.store.Context;

class AddOperationsToChainDiffblueTest {
  /**
   * Test {@link AddOperationsToChain#postExecute(Object, OperationChain, Context)}.
   * <p>
   * Method under test: {@link AddOperationsToChain#postExecute(Object, OperationChain, Context)}
   */
  @Test
  @DisplayName("Test postExecute(Object, OperationChain, Context)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object AddOperationsToChain.postExecute(Object, OperationChain, Context)"})
  void testPostExecute() {
    // Arrange
    AddOperationsToChain addOperationsToChain = new AddOperationsToChain();
    OperationChain<?> opChain = new OperationChain<>();

    // Act and Assert
    assertEquals("Result", addOperationsToChain.postExecute("Result", opChain, new Context()));
  }

  /**
   * Test {@link AddOperationsToChain#onFailure(Object, OperationChain, Context, Exception)}.
   * <p>
   * Method under test: {@link AddOperationsToChain#onFailure(Object, OperationChain, Context, Exception)}
   */
  @Test
  @DisplayName("Test onFailure(Object, OperationChain, Context, Exception)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object AddOperationsToChain.onFailure(Object, OperationChain, Context, Exception)"})
  void testOnFailure() {
    // Arrange
    AddOperationsToChain addOperationsToChain = new AddOperationsToChain();
    OperationChain<?> opChain = new OperationChain<>();
    Context context = new Context();

    // Act and Assert
    assertEquals("Result", addOperationsToChain.onFailure("Result", opChain, context, new Exception("foo")));
  }

  /**
   * Test {@link AddOperationsToChain#getStart()}.
   * <p>
   * Method under test: {@link AddOperationsToChain#getStart()}
   */
  @Test
  @DisplayName("Test getStart()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List AddOperationsToChain.getStart()"})
  void testGetStart() {
    // Arrange, Act and Assert
    assertTrue((new AddOperationsToChain()).getStart().isEmpty());
  }

  /**
   * Test {@link AddOperationsToChain#getEnd()}.
   * <p>
   * Method under test: {@link AddOperationsToChain#getEnd()}
   */
  @Test
  @DisplayName("Test getEnd()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List AddOperationsToChain.getEnd()"})
  void testGetEnd() {
    // Arrange, Act and Assert
    assertTrue((new AddOperationsToChain()).getEnd().isEmpty());
  }

  /**
   * Test {@link AddOperationsToChain#setEnd(List)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then {@link AddOperationsToChain} (default constructor) End Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link AddOperationsToChain#setEnd(List)}
   */
  @Test
  @DisplayName("Test setEnd(List); when ArrayList(); then AddOperationsToChain (default constructor) End Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void AddOperationsToChain.setEnd(List)"})
  void testSetEnd_whenArrayList_thenAddOperationsToChainEndEmpty() {
    // Arrange
    AddOperationsToChain addOperationsToChain = new AddOperationsToChain();

    // Act
    addOperationsToChain.setEnd(new ArrayList<>());

    // Assert that nothing has changed
    List<Operation> end = addOperationsToChain.getEnd();
    assertTrue(end.isEmpty());
    assertSame(end, addOperationsToChain.getStart());
  }

  /**
   * Test {@link AddOperationsToChain#getBefore()}.
   * <p>
   * Method under test: {@link AddOperationsToChain#getBefore()}
   */
  @Test
  @DisplayName("Test getBefore()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Map AddOperationsToChain.getBefore()"})
  void testGetBefore() {
    // Arrange, Act and Assert
    assertTrue((new AddOperationsToChain()).getBefore().isEmpty());
  }

  /**
   * Test {@link AddOperationsToChain#getAfter()}.
   * <p>
   * Method under test: {@link AddOperationsToChain#getAfter()}
   */
  @Test
  @DisplayName("Test getAfter()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Map AddOperationsToChain.getAfter()"})
  void testGetAfter() {
    // Arrange, Act and Assert
    assertTrue((new AddOperationsToChain()).getAfter().isEmpty());
  }

  /**
   * Test {@link AddOperationsToChain#getAuthorisedOps()}.
   * <p>
   * Method under test: {@link AddOperationsToChain#getAuthorisedOps()}
   */
  @Test
  @DisplayName("Test getAuthorisedOps()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.util.LinkedHashMap AddOperationsToChain.getAuthorisedOps()"})
  void testGetAuthorisedOps() {
    // Arrange, Act and Assert
    assertTrue((new AddOperationsToChain()).getAuthorisedOps().isEmpty());
  }

  /**
   * Test new {@link AddOperationsToChain} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of {@link AddOperationsToChain}
   */
  @Test
  @DisplayName("Test new AddOperationsToChain (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void AddOperationsToChain.<init>()"})
  void testNewAddOperationsToChain() {
    // Arrange and Act
    AddOperationsToChain actualAddOperationsToChain = new AddOperationsToChain();

    // Assert
    assertTrue(actualAddOperationsToChain.getAuthorisedOps().isEmpty());
    List<Operation> end = actualAddOperationsToChain.getEnd();
    assertTrue(end.isEmpty());
    Map<String, List<Operation>> after = actualAddOperationsToChain.getAfter();
    assertTrue(after.isEmpty());
    assertSame(after, actualAddOperationsToChain.getBefore());
    assertSame(end, actualAddOperationsToChain.getStart());
  }
}
