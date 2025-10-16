package uk.gov.gchq.gaffer.graph.hook;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
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
   * Test {@link AddOperationsToChain#preExecute(OperationChain, Context)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link ExportToOtherAuthorisedGraph} (default
   *       constructor).
   * </ul>
   *
   * <p>Method under test: {@link AddOperationsToChain#preExecute(OperationChain, Context)}
   */
  @Test
  @DisplayName(
      "Test preExecute(OperationChain, Context); given ArrayList() add ExportToOtherAuthorisedGraph (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AddOperationsToChain.preExecute(OperationChain, Context)"})
  void testPreExecute_givenArrayListAddExportToOtherAuthorisedGraph() {
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
   * Test {@link AddOperationsToChain#preExecute(OperationChain, Context)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link
   *       TestOperationsImpl#TestOperationsImpl(List)} with ops is {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link AddOperationsToChain#preExecute(OperationChain, Context)}
   */
  @Test
  @DisplayName(
      "Test preExecute(OperationChain, Context); given ArrayList() add TestOperationsImpl(List) with ops is ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AddOperationsToChain.preExecute(OperationChain, Context)"})
  void testPreExecute_givenArrayListAddTestOperationsImplWithOpsIsArrayList() {
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
   * Test {@link AddOperationsToChain#preExecute(OperationChain, Context)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link
   *       TestUnmodifiableOperationsImpl#TestUnmodifiableOperationsImpl(List)} with ops is {@link
   *       ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link AddOperationsToChain#preExecute(OperationChain, Context)}
   */
  @Test
  @DisplayName(
      "Test preExecute(OperationChain, Context); given ArrayList() add TestUnmodifiableOperationsImpl(List) with ops is ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AddOperationsToChain.preExecute(OperationChain, Context)"})
  void testPreExecute_givenArrayListAddTestUnmodifiableOperationsImplWithOpsIsArrayList() {
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
   * Test {@link AddOperationsToChain#preExecute(OperationChain, Context)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.
   *   <li>Then calls {@link OperationChain#updateOperations(Collection)}.
   * </ul>
   *
   * <p>Method under test: {@link AddOperationsToChain#preExecute(OperationChain, Context)}
   */
  @Test
  @DisplayName(
      "Test preExecute(OperationChain, Context); given ArrayList(); then calls updateOperations(Collection)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AddOperationsToChain.preExecute(OperationChain, Context)"})
  void testPreExecute_givenArrayList_thenCallsUpdateOperations() {
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
   * Test {@link AddOperationsToChain#preExecute(OperationChain, Context)}.
   *
   * <ul>
   *   <li>Then calls {@link TestOperationsImpl#updateOperations(Collection)}.
   * </ul>
   *
   * <p>Method under test: {@link AddOperationsToChain#preExecute(OperationChain, Context)}
   */
  @Test
  @DisplayName("Test preExecute(OperationChain, Context); then calls updateOperations(Collection)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AddOperationsToChain.preExecute(OperationChain, Context)"})
  void testPreExecute_thenCallsUpdateOperations() {
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
   * Test {@link AddOperationsToChain#preExecute(OperationChain, Context)}.
   *
   * <ul>
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link AddOperationsToChain#preExecute(OperationChain, Context)}
   */
  @Test
  @DisplayName("Test preExecute(OperationChain, Context); then throw RuntimeException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AddOperationsToChain.preExecute(OperationChain, Context)"})
  void testPreExecute_thenThrowRuntimeException() {
    // Arrange
    AddOperationsToChain addOperationsToChain = new AddOperationsToChain();

    TestOperationsImpl testOperationsImpl = mock(TestOperationsImpl.class);
    when(testOperationsImpl.getOperations()).thenThrow(new RuntimeException());

    ArrayList<Operation> operationList = new ArrayList<>();
    operationList.add(testOperationsImpl);

    OperationChain<?> opChain = mock(OperationChain.class);
    Class<Operation> forNameResult = Operation.class;
    when(opChain.getOperationsClass()).thenReturn(forNameResult);
    when(opChain.getOperations()).thenReturn(operationList);

    // Act and Assert
    assertThrows(
        RuntimeException.class, () -> addOperationsToChain.preExecute(opChain, new Context()));
    verify(opChain, atLeast(1)).getOperations();
    verify(opChain).getOperationsClass();
    verify(testOperationsImpl).getOperations();
  }

  /**
   * Test {@link AddOperationsToChain#postExecute(Object, OperationChain, Context)}.
   *
   * <p>Method under test: {@link AddOperationsToChain#postExecute(Object, OperationChain, Context)}
   */
  @Test
  @DisplayName("Test postExecute(Object, OperationChain, Context)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object AddOperationsToChain.postExecute(Object, OperationChain, Context)"})
  void testPostExecute() {
    // Arrange
    AddOperationsToChain addOperationsToChain = new AddOperationsToChain();
    OperationChain<?> opChain = OperationChain.wrap(new ExportToOtherAuthorisedGraph());

    // Act and Assert
    assertEquals("Result", addOperationsToChain.postExecute("Result", opChain, new Context()));
  }

  /**
   * Test {@link AddOperationsToChain#onFailure(Object, OperationChain, Context, Exception)}.
   *
   * <p>Method under test: {@link AddOperationsToChain#onFailure(Object, OperationChain, Context,
   * Exception)}
   */
  @Test
  @DisplayName("Test onFailure(Object, OperationChain, Context, Exception)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Object AddOperationsToChain.onFailure(Object, OperationChain, Context, Exception)"
  })
  void testOnFailure() {
    // Arrange
    AddOperationsToChain addOperationsToChain = new AddOperationsToChain();
    OperationChain<?> opChain = OperationChain.wrap(new ExportToOtherAuthorisedGraph());
    Context context = new Context();

    // Act and Assert
    assertEquals(
        "Result", addOperationsToChain.onFailure("Result", opChain, context, new Exception()));
  }

  /**
   * Test {@link AddOperationsToChain#getStart()}.
   *
   * <p>Method under test: {@link AddOperationsToChain#getStart()}
   */
  @Test
  @DisplayName("Test getStart()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List AddOperationsToChain.getStart()"})
  void testGetStart() {
    // Arrange, Act and Assert
    assertTrue(new AddOperationsToChain().getStart().isEmpty());
  }

  /**
   * Test {@link AddOperationsToChain#getEnd()}.
   *
   * <p>Method under test: {@link AddOperationsToChain#getEnd()}
   */
  @Test
  @DisplayName("Test getEnd()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List AddOperationsToChain.getEnd()"})
  void testGetEnd() {
    // Arrange, Act and Assert
    assertTrue(new AddOperationsToChain().getEnd().isEmpty());
  }

  /**
   * Test {@link AddOperationsToChain#setEnd(List)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then {@link AddOperationsToChain} (default constructor) End Empty.
   * </ul>
   *
   * <p>Method under test: {@link AddOperationsToChain#setEnd(List)}
   */
  @Test
  @DisplayName(
      "Test setEnd(List); when ArrayList(); then AddOperationsToChain (default constructor) End Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
   *
   * <p>Method under test: {@link AddOperationsToChain#getBefore()}
   */
  @Test
  @DisplayName("Test getBefore()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map AddOperationsToChain.getBefore()"})
  void testGetBefore() {
    // Arrange, Act and Assert
    assertTrue(new AddOperationsToChain().getBefore().isEmpty());
  }

  /**
   * Test {@link AddOperationsToChain#getAfter()}.
   *
   * <p>Method under test: {@link AddOperationsToChain#getAfter()}
   */
  @Test
  @DisplayName("Test getAfter()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map AddOperationsToChain.getAfter()"})
  void testGetAfter() {
    // Arrange, Act and Assert
    assertTrue(new AddOperationsToChain().getAfter().isEmpty());
  }

  /**
   * Test {@link AddOperationsToChain#getAuthorisedOps()}.
   *
   * <p>Method under test: {@link AddOperationsToChain#getAuthorisedOps()}
   */
  @Test
  @DisplayName("Test getAuthorisedOps()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.LinkedHashMap AddOperationsToChain.getAuthorisedOps()"})
  void testGetAuthorisedOps() {
    // Arrange, Act and Assert
    assertTrue(new AddOperationsToChain().getAuthorisedOps().isEmpty());
  }

  /**
   * Test new {@link AddOperationsToChain} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link AddOperationsToChain}
   */
  @Test
  @DisplayName("Test new AddOperationsToChain (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
