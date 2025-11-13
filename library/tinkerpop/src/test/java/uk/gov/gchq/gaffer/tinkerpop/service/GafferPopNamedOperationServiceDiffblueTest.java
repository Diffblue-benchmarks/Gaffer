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

package uk.gov.gchq.gaffer.tinkerpop.service;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
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
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mockito.Mockito;
import uk.gov.gchq.gaffer.operation.OperationChain;
import uk.gov.gchq.gaffer.tinkerpop.GafferPopGraph;

public class GafferPopNamedOperationServiceDiffblueTest {
  /**
   * Test {@link GafferPopNamedOperationService#execute(ServiceCallContext, Map)} with {@code ServiceCallContext}, {@code Map}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GafferPopNamedOperationService#execute(ServiceCallContext, Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CloseableIterator GafferPopNamedOperationService.execute(ServiceCallContext, Map)"})
  public void testExecuteWithServiceCallContextMap_thenThrowIllegalStateException() {
    // Arrange
    GafferPopNamedOperationService<Object, Object> gafferPopNamedOperationService = new GafferPopNamedOperationService<>(
        null);
    DefaultCredentialTraversal traversal = new DefaultCredentialTraversal();
    ServiceCallContext ctx = new ServiceCallContext(traversal,
        new ComputerResultStep(new DefaultCredentialTraversal()));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> gafferPopNamedOperationService.execute(ctx, new HashMap<>()));
  }

  /**
   * Test {@link GafferPopNamedOperationService#executeNamedOperation(String)}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GafferPopNamedOperationService#executeNamedOperation(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CloseableIterator GafferPopNamedOperationService.executeNamedOperation(String)"})
  public void testExecuteNamedOperation_thenThrowIllegalStateException() {
    // Arrange
    GafferPopGraph graph = mock(GafferPopGraph.class);
    when(graph.execute(Mockito.<OperationChain<Object>>any())).thenReturn(new ArrayList<>());
    GafferPopNamedOperationService<Object, Object> gafferPopNamedOperationService = new GafferPopNamedOperationService<>(
        graph);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> gafferPopNamedOperationService.executeNamedOperation("Name"));
    verify(graph).execute(isA(OperationChain.class));
  }

  /**
   * Test {@link GafferPopNamedOperationService#addNamedOperation(Map)}.
   * <ul>
   *   <li>Then return {@link CloseableIterator.EmptyCloseableIterator}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GafferPopNamedOperationService#addNamedOperation(Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CloseableIterator GafferPopNamedOperationService.addNamedOperation(Map)"})
  public void testAddNamedOperation_thenReturnEmptyCloseableIterator() {
    // Arrange
    GafferPopGraph graph = mock(GafferPopGraph.class);
    when(graph.execute(Mockito.<OperationChain<Object>>any())).thenReturn("Execute");
    GafferPopNamedOperationService<Object, Object> gafferPopNamedOperationService = new GafferPopNamedOperationService<>(
        graph);

    // Act
    CloseableIterator<Object> actualAddNamedOperationResult = gafferPopNamedOperationService
        .addNamedOperation(new HashMap<>());

    // Assert
    verify(graph).execute(isA(OperationChain.class));
    assertTrue(actualAddNamedOperationResult instanceof EmptyCloseableIterator);
    assertFalse(actualAddNamedOperationResult.hasNext());
  }
}
