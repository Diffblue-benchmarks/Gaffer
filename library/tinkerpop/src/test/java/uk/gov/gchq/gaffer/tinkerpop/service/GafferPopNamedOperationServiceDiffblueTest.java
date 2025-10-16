package uk.gov.gchq.gaffer.tinkerpop.service;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.apache.tinkerpop.gremlin.groovy.jsr223.dsl.credential.DefaultCredentialTraversal;
import org.apache.tinkerpop.gremlin.process.computer.traversal.step.map.ComputerResultStep;
import org.apache.tinkerpop.gremlin.structure.service.Service;
import org.apache.tinkerpop.gremlin.structure.service.Service.ServiceCallContext;
import org.apache.tinkerpop.gremlin.structure.util.CloseableIterator;
import org.apache.tinkerpop.gremlin.structure.util.CloseableIterator.EmptyCloseableIterator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import uk.gov.gchq.gaffer.operation.OperationChain;
import uk.gov.gchq.gaffer.tinkerpop.GafferPopGraph;

class GafferPopNamedOperationServiceDiffblueTest {
  /**
   * Test {@link GafferPopNamedOperationService#execute(ServiceCallContext, Map)} with {@code
   * ServiceCallContext}, {@code Map}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.
   * </ul>
   *
   * <p>Method under test: {@link GafferPopNamedOperationService#execute(ServiceCallContext, Map)}
   */
  @Test
  @DisplayName(
      "Test execute(ServiceCallContext, Map) with 'ServiceCallContext', 'Map'; then throw IllegalStateException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CloseableIterator GafferPopNamedOperationService.execute(ServiceCallContext, Map)"
  })
  void testExecuteWithServiceCallContextMap_thenThrowIllegalStateException() {
    // Arrange
    GafferPopNamedOperationService<Object, Object> gafferPopNamedOperationService =
        new GafferPopNamedOperationService<>(null);
    DefaultCredentialTraversal traversal = new DefaultCredentialTraversal();
    ServiceCallContext ctx =
        new ServiceCallContext(traversal, new ComputerResultStep(new DefaultCredentialTraversal()));

    // Act and Assert
    assertThrows(
        IllegalStateException.class,
        () -> gafferPopNamedOperationService.execute(ctx, new HashMap<>()));
  }

  /**
   * Test {@link GafferPopNamedOperationService#executeNamedOperation(String)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.
   * </ul>
   *
   * <p>Method under test: {@link GafferPopNamedOperationService#executeNamedOperation(String)}
   */
  @Test
  @DisplayName("Test executeNamedOperation(String); then throw IllegalStateException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CloseableIterator GafferPopNamedOperationService.executeNamedOperation(String)"
  })
  void testExecuteNamedOperation_thenThrowIllegalStateException() {
    // Arrange
    GafferPopGraph graph = mock(GafferPopGraph.class);
    when(graph.execute(Mockito.<OperationChain<Object>>any())).thenReturn(new ArrayList<>());
    GafferPopNamedOperationService<Object, Object> gafferPopNamedOperationService =
        new GafferPopNamedOperationService<>(graph);

    // Act and Assert
    assertThrows(
        IllegalStateException.class,
        () -> gafferPopNamedOperationService.executeNamedOperation("Name"));
    verify(graph).execute(isA(OperationChain.class));
  }

  /**
   * Test {@link GafferPopNamedOperationService#addNamedOperation(Map)}.
   *
   * <ul>
   *   <li>Then return {@link CloseableIterator.EmptyCloseableIterator}.
   * </ul>
   *
   * <p>Method under test: {@link GafferPopNamedOperationService#addNamedOperation(Map)}
   */
  @Test
  @DisplayName("Test addNamedOperation(Map); then return EmptyCloseableIterator")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"CloseableIterator GafferPopNamedOperationService.addNamedOperation(Map)"})
  void testAddNamedOperation_thenReturnEmptyCloseableIterator() {
    // Arrange
    GafferPopGraph graph = mock(GafferPopGraph.class);
    when(graph.execute(Mockito.<OperationChain<Object>>any())).thenReturn("Execute");
    GafferPopNamedOperationService<Object, Object> gafferPopNamedOperationService =
        new GafferPopNamedOperationService<>(graph);

    // Act
    CloseableIterator<Object> actualAddNamedOperationResult =
        gafferPopNamedOperationService.addNamedOperation(new HashMap<>());

    // Assert
    verify(graph).execute(isA(OperationChain.class));
    assertTrue(actualAddNamedOperationResult instanceof EmptyCloseableIterator);
    assertFalse(actualAddNamedOperationResult.hasNext());
  }
}
