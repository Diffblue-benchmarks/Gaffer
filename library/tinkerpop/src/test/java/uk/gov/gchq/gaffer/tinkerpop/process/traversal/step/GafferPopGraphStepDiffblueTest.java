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

package uk.gov.gchq.gaffer.tinkerpop.process.traversal.step;

import static org.junit.Assert.assertThrows;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.function.Supplier;
import org.apache.tinkerpop.gremlin.process.traversal.Traversal;
import org.apache.tinkerpop.gremlin.process.traversal.Traversal.Admin;
import org.apache.tinkerpop.gremlin.process.traversal.step.map.GraphStep;
import org.apache.tinkerpop.gremlin.process.traversal.traverser.util.TraverserSet;
import org.apache.tinkerpop.gremlin.structure.Element;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class GafferPopGraphStepDiffblueTest {
  /**
   * Test {@link GafferPopGraphStep#GafferPopGraphStep(GraphStep)}.
   * <p>
   * Method under test: {@link GafferPopGraphStep#GafferPopGraphStep(GraphStep)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void GafferPopGraphStep.<init>(GraphStep)"})
  public void testNewGafferPopGraphStep() {
    // Arrange
    Supplier<TraverserSet> supplier = mock(Supplier.class);
    when(supplier.get()).thenReturn(new TraverserSet());
    Admin traversal = mock(Admin.class);
    when(traversal.getGraph()).thenThrow(new IllegalArgumentException("Running custom GraphStep on GafferPopGraph"));
    when(traversal.getTraverserSetSupplier()).thenReturn(supplier);
    Class<Element> returnClass = Element.class;

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> new GafferPopGraphStep<>(new GraphStep<>(traversal, returnClass, true, "Ids")));
    verify(supplier, atLeast(1)).get();
    verify(traversal).getGraph();
    verify(traversal, atLeast(1)).getTraverserSetSupplier();
  }

  /**
   * Test {@link GafferPopGraphStep#GafferPopGraphStep(GraphStep)}.
   * <p>
   * Method under test: {@link GafferPopGraphStep#GafferPopGraphStep(GraphStep)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void GafferPopGraphStep.<init>(GraphStep)"})
  public void testNewGafferPopGraphStep2() {
    // Arrange
    Supplier<TraverserSet> supplier = mock(Supplier.class);
    when(supplier.get()).thenReturn(new TraverserSet());
    Admin traversal = mock(Admin.class);
    when(traversal.getGraph()).thenThrow(new IllegalArgumentException("Running custom GraphStep on GafferPopGraph"));
    when(traversal.getTraverserSetSupplier()).thenReturn(supplier);
    Class<Element> returnClass = Element.class;

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> new GafferPopGraphStep<>(new GraphStep<>(traversal, returnClass, false, "Ids")));
    verify(supplier, atLeast(1)).get();
    verify(traversal).getGraph();
    verify(traversal, atLeast(1)).getTraverserSetSupplier();
  }

  /**
   * Test {@link GafferPopGraphStep#GafferPopGraphStep(GraphStep)}.
   * <p>
   * Method under test: {@link GafferPopGraphStep#GafferPopGraphStep(GraphStep)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void GafferPopGraphStep.<init>(GraphStep)"})
  public void testNewGafferPopGraphStep3() {
    // Arrange
    Supplier<TraverserSet> supplier = mock(Supplier.class);
    when(supplier.get()).thenReturn(new TraverserSet());
    Admin traversal = mock(Admin.class);
    when(traversal.getGraph()).thenThrow(new IllegalArgumentException("Running custom GraphStep on GafferPopGraph"));
    when(traversal.getTraverserSetSupplier()).thenReturn(supplier);
    Class<Element> returnClass = Element.class;

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> new GafferPopGraphStep<>(new GraphStep<>(traversal, returnClass, true)));
    verify(supplier, atLeast(1)).get();
    verify(traversal).getGraph();
    verify(traversal, atLeast(1)).getTraverserSetSupplier();
  }
}
