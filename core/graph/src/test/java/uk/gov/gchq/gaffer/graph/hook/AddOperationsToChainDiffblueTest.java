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
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import uk.gov.gchq.gaffer.operation.Operation;
import uk.gov.gchq.gaffer.operation.OperationChain;
import uk.gov.gchq.gaffer.operation.TestOperationsImpl;
import uk.gov.gchq.gaffer.operation.TestUnmodifiableOperationsImpl;
import uk.gov.gchq.gaffer.operation.export.graph.ExportToOtherAuthorisedGraph;
import uk.gov.gchq.gaffer.store.Context;

class AddOperationsToChainDiffblueTest {
  /**
   * Method under test:
   * {@link AddOperationsToChain#preExecute(OperationChain, Context)}
   */
  @Test
  void testPreExecute() {
    // Arrange
    AddOperationsToChain addOperationsToChain = new AddOperationsToChain();
    OperationChain<?> opChain = mock(OperationChain.class);
    doNothing().when(opChain).updateOperations(Mockito.<Collection<Operation>>any());
    when(opChain.getOperations()).thenReturn(new ArrayList<>());

    // Act
    addOperationsToChain.preExecute(opChain, new Context());

    // Assert
    verify(opChain).getOperations();
    verify(opChain).updateOperations(isA(Collection.class));
  }

  /**
   * Method under test:
   * {@link AddOperationsToChain#preExecute(OperationChain, Context)}
   */
  @Test
  void testPreExecute2() {
    // Arrange
    AddOperationsToChain addOperationsToChain = new AddOperationsToChain();

    ArrayList<Operation> operationList = new ArrayList<>();
    operationList.add(new ExportToOtherAuthorisedGraph());
    OperationChain<?> opChain = mock(OperationChain.class);
    Class<Operation> forNameResult = Operation.class;
    when(opChain.getOperationsClass()).thenReturn(forNameResult);
    doNothing().when(opChain).updateOperations(Mockito.<Collection<Operation>>any());
    when(opChain.getOperations()).thenReturn(operationList);

    // Act
    addOperationsToChain.preExecute(opChain, new Context());

    // Assert
    verify(opChain, atLeast(1)).getOperations();
    verify(opChain).getOperationsClass();
    verify(opChain).updateOperations(isA(Collection.class));
  }

  /**
   * Method under test:
   * {@link AddOperationsToChain#preExecute(OperationChain, Context)}
   */
  @Test
  void testPreExecute3() {
    // Arrange
    AddOperationsToChain addOperationsToChain = new AddOperationsToChain();

    ArrayList<Operation> operationList = new ArrayList<>();
    operationList.add(new TestOperationsImpl(new ArrayList<>()));
    OperationChain<?> opChain = mock(OperationChain.class);
    Class<Operation> forNameResult = Operation.class;
    when(opChain.getOperationsClass()).thenReturn(forNameResult);
    doNothing().when(opChain).updateOperations(Mockito.<Collection<Operation>>any());
    when(opChain.getOperations()).thenReturn(operationList);

    // Act
    addOperationsToChain.preExecute(opChain, new Context());

    // Assert
    verify(opChain, atLeast(1)).getOperations();
    verify(opChain).getOperationsClass();
    verify(opChain).updateOperations(isA(Collection.class));
  }

  /**
   * Method under test:
   * {@link AddOperationsToChain#preExecute(OperationChain, Context)}
   */
  @Test
  void testPreExecute4() {
    // Arrange
    AddOperationsToChain addOperationsToChain = new AddOperationsToChain();

    ArrayList<Operation> operationList = new ArrayList<>();
    operationList.add(new TestUnmodifiableOperationsImpl(new ArrayList<>()));
    OperationChain<?> opChain = mock(OperationChain.class);
    Class<Operation> forNameResult = Operation.class;
    when(opChain.getOperationsClass()).thenReturn(forNameResult);
    doNothing().when(opChain).updateOperations(Mockito.<Collection<Operation>>any());
    when(opChain.getOperations()).thenReturn(operationList);

    // Act
    addOperationsToChain.preExecute(opChain, new Context());

    // Assert
    verify(opChain, atLeast(1)).getOperations();
    verify(opChain).getOperationsClass();
    verify(opChain).updateOperations(isA(Collection.class));
  }

  /**
   * Method under test:
   * {@link AddOperationsToChain#preExecute(OperationChain, Context)}
   */
  @Test
  void testPreExecute5() {
    // Arrange
    AddOperationsToChain addOperationsToChain = new AddOperationsToChain();
    TestOperationsImpl testOperationsImpl = mock(TestOperationsImpl.class);
    doNothing().when(testOperationsImpl).updateOperations(Mockito.<Collection<Operation>>any());
    when(testOperationsImpl.getOperations()).thenReturn(new ArrayList<>());

    ArrayList<Operation> operationList = new ArrayList<>();
    operationList.add(testOperationsImpl);
    OperationChain<?> opChain = mock(OperationChain.class);
    Class<Operation> forNameResult = Operation.class;
    when(opChain.getOperationsClass()).thenReturn(forNameResult);
    doNothing().when(opChain).updateOperations(Mockito.<Collection<Operation>>any());
    when(opChain.getOperations()).thenReturn(operationList);

    // Act
    addOperationsToChain.preExecute(opChain, new Context());

    // Assert
    verify(opChain, atLeast(1)).getOperations();
    verify(opChain).getOperationsClass();
    verify(opChain).updateOperations(isA(Collection.class));
    verify(testOperationsImpl).updateOperations(isA(Collection.class));
    verify(testOperationsImpl).getOperations();
  }

  /**
   * Method under test:
   * {@link AddOperationsToChain#postExecute(Object, OperationChain, Context)}
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
   * {@link AddOperationsToChain#onFailure(Object, OperationChain, Context, Exception)}
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

  /**
   * Method under test: {@link AddOperationsToChain#getStart()}
   */
  @Test
  void testGetStart() {
    // Arrange, Act and Assert
    assertTrue((new AddOperationsToChain()).getStart().isEmpty());
  }

  /**
   * Method under test: {@link AddOperationsToChain#getEnd()}
   */
  @Test
  void testGetEnd() {
    // Arrange, Act and Assert
    assertTrue((new AddOperationsToChain()).getEnd().isEmpty());
  }

  /**
   * Method under test: {@link AddOperationsToChain#getBefore()}
   */
  @Test
  void testGetBefore() {
    // Arrange, Act and Assert
    assertTrue((new AddOperationsToChain()).getBefore().isEmpty());
  }

  /**
   * Method under test: {@link AddOperationsToChain#getAfter()}
   */
  @Test
  void testGetAfter() {
    // Arrange, Act and Assert
    assertTrue((new AddOperationsToChain()).getAfter().isEmpty());
  }

  /**
   * Method under test: {@link AddOperationsToChain#getAuthorisedOps()}
   */
  @Test
  void testGetAuthorisedOps() {
    // Arrange, Act and Assert
    assertTrue((new AddOperationsToChain()).getAuthorisedOps().isEmpty());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link AddOperationsToChain}
   */
  @Test
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
