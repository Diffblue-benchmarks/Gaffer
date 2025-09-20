package uk.gov.gchq.gaffer.tinkerpop.process.traversal.step;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.function.Supplier;
import org.apache.tinkerpop.gremlin.process.traversal.Traversal;
import org.apache.tinkerpop.gremlin.process.traversal.Traverser;
import org.apache.tinkerpop.gremlin.process.traversal.Traverser.Admin;
import org.apache.tinkerpop.gremlin.process.traversal.step.map.GraphStep;
import org.apache.tinkerpop.gremlin.process.traversal.traverser.B_LP_NL_O_P_S_SE_SL_TraverserGenerator;
import org.apache.tinkerpop.gremlin.process.traversal.traverser.util.DummyTraverser;
import org.apache.tinkerpop.gremlin.process.traversal.traverser.util.TraverserSet;
import org.apache.tinkerpop.gremlin.process.traversal.util.DefaultTraversal;
import org.apache.tinkerpop.gremlin.structure.Element;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class GafferPopGraphStepDiffblueTest {
  /**
   * Test {@link GafferPopGraphStep#GafferPopGraphStep(GraphStep)}.
   *
   * <p>Method under test: {@link GafferPopGraphStep#GafferPopGraphStep(GraphStep)}
   */
  @Test
  @DisplayName("Test new GafferPopGraphStep(GraphStep)")
  @Tag("MaintainedByDiffblue")
  void testNewGafferPopGraphStep() {
    // Arrange
    Supplier<TraverserSet> supplier = mock(Supplier.class);
    when(supplier.get()).thenReturn(new TraverserSet());

    DefaultTraversal traversal = mock(DefaultTraversal.class);
    when(traversal.getGraph()).thenThrow(new IllegalArgumentException());
    when(traversal.getTraverserSetSupplier()).thenReturn(supplier);
    doNothing().when(traversal).addStart(Mockito.<Admin<Object>>any());
    traversal.addStart(new DummyTraverser(B_LP_NL_O_P_S_SE_SL_TraverserGenerator.instance()));
    Class<Element> returnClass = Element.class;

    GraphStep<Object, Element> originalGraphStep =
        new GraphStep<>(traversal, returnClass, true, "Ids");

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> new GafferPopGraphStep<>(originalGraphStep));
    verify(supplier, atLeast(1)).get();
    verify(traversal, atLeast(1)).getTraverserSetSupplier();
    verify(traversal).addStart(isA(Admin.class));
    verify(traversal).getGraph();
  }

  /**
   * Test {@link GafferPopGraphStep#GafferPopGraphStep(GraphStep)}.
   *
   * <p>Method under test: {@link GafferPopGraphStep#GafferPopGraphStep(GraphStep)}
   */
  @Test
  @DisplayName("Test new GafferPopGraphStep(GraphStep)")
  @Tag("MaintainedByDiffblue")
  void testNewGafferPopGraphStep2() {
    // Arrange
    Supplier<TraverserSet> supplier = mock(Supplier.class);
    when(supplier.get()).thenReturn(new TraverserSet());

    DefaultTraversal traversal = mock(DefaultTraversal.class);
    when(traversal.getGraph()).thenThrow(new IllegalArgumentException());
    when(traversal.getTraverserSetSupplier()).thenReturn(supplier);
    doNothing().when(traversal).addStart(Mockito.<Admin<Object>>any());
    traversal.addStart(new DummyTraverser(B_LP_NL_O_P_S_SE_SL_TraverserGenerator.instance()));
    Class<Element> returnClass = Element.class;

    GraphStep<Object, Element> originalGraphStep =
        new GraphStep<>(traversal, returnClass, false, "Ids");

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> new GafferPopGraphStep<>(originalGraphStep));
    verify(supplier, atLeast(1)).get();
    verify(traversal, atLeast(1)).getTraverserSetSupplier();
    verify(traversal).addStart(isA(Admin.class));
    verify(traversal).getGraph();
  }

  /**
   * Test {@link GafferPopGraphStep#GafferPopGraphStep(GraphStep)}.
   *
   * <p>Method under test: {@link GafferPopGraphStep#GafferPopGraphStep(GraphStep)}
   */
  @Test
  @DisplayName("Test new GafferPopGraphStep(GraphStep)")
  @Tag("MaintainedByDiffblue")
  void testNewGafferPopGraphStep3() {
    // Arrange
    Supplier<TraverserSet> supplier = mock(Supplier.class);
    when(supplier.get()).thenReturn(new TraverserSet());

    DefaultTraversal traversal = mock(DefaultTraversal.class);
    when(traversal.getGraph()).thenThrow(new IllegalArgumentException());
    when(traversal.getTraverserSetSupplier()).thenReturn(supplier);
    doNothing().when(traversal).addStart(Mockito.<Admin<Object>>any());
    traversal.addStart(new DummyTraverser(B_LP_NL_O_P_S_SE_SL_TraverserGenerator.instance()));
    Class<Element> returnClass = Element.class;

    GraphStep<Object, Element> originalGraphStep = new GraphStep<>(traversal, returnClass, true);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> new GafferPopGraphStep<>(originalGraphStep));
    verify(supplier, atLeast(1)).get();
    verify(traversal, atLeast(1)).getTraverserSetSupplier();
    verify(traversal).addStart(isA(Admin.class));
    verify(traversal).getGraph();
  }

  /**
   * Test {@link GafferPopGraphStep#GafferPopGraphStep(GraphStep)}.
   *
   * <p>Method under test: {@link GafferPopGraphStep#GafferPopGraphStep(GraphStep)}
   */
  @Test
  @DisplayName("Test new GafferPopGraphStep(GraphStep)")
  @Tag("MaintainedByDiffblue")
  void testNewGafferPopGraphStep4() {
    // Arrange
    Traversal.Admin<Object, Object> admin = mock(Traversal.Admin.class);
    when(admin.getTraverserSetSupplier()).thenThrow(new IllegalArgumentException());

    GraphStep<Object, Element> originalGraphStep = mock(GraphStep.class);
    when(originalGraphStep.getIds()).thenReturn(null);
    when(originalGraphStep.isStartStep()).thenReturn(true);
    Class<Element> forNameResult = Element.class;
    when(originalGraphStep.getReturnClass()).thenReturn(forNameResult);
    when(originalGraphStep.getTraversal()).thenReturn(admin);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> new GafferPopGraphStep<>(originalGraphStep));
    verify(admin).getTraverserSetSupplier();
    verify(originalGraphStep).getIds();
    verify(originalGraphStep).getReturnClass();
    verify(originalGraphStep).isStartStep();
    verify(originalGraphStep).getTraversal();
  }

  /**
   * Test {@link GafferPopGraphStep#GafferPopGraphStep(GraphStep)}.
   *
   * <ul>
   *   <li>Given {@link Supplier} {@link Supplier#get()} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link GafferPopGraphStep#GafferPopGraphStep(GraphStep)}
   */
  @Test
  @DisplayName(
      "Test new GafferPopGraphStep(GraphStep); given Supplier get() throw IllegalArgumentException()")
  @Tag("MaintainedByDiffblue")
  void testNewGafferPopGraphStep_givenSupplierGetThrowIllegalArgumentException() {
    // Arrange
    Supplier<TraverserSet<Object>> supplier = mock(Supplier.class);
    when(supplier.get()).thenThrow(new IllegalArgumentException());

    Traversal.Admin<Object, Object> admin = mock(Traversal.Admin.class);
    when(admin.getTraverserSetSupplier()).thenReturn(supplier);

    GraphStep<Object, Element> originalGraphStep = mock(GraphStep.class);
    when(originalGraphStep.getIds()).thenReturn(null);
    when(originalGraphStep.isStartStep()).thenReturn(true);
    Class<Element> forNameResult = Element.class;
    when(originalGraphStep.getReturnClass()).thenReturn(forNameResult);
    when(originalGraphStep.getTraversal()).thenReturn(admin);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> new GafferPopGraphStep<>(originalGraphStep));
    verify(supplier).get();
    verify(admin).getTraverserSetSupplier();
    verify(originalGraphStep).getIds();
    verify(originalGraphStep).getReturnClass();
    verify(originalGraphStep).isStartStep();
    verify(originalGraphStep).getTraversal();
  }
}
