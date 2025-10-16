package uk.gov.gchq.gaffer.graph.hook;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.operation.OperationChain;
import uk.gov.gchq.gaffer.operation.export.graph.ExportToOtherAuthorisedGraph;
import uk.gov.gchq.gaffer.store.Context;

class GraphHookDiffblueTest {
  /**
   * Test {@link GraphHook#postExecute(Object, OperationChain, Context)}.
   *
   * <p>Method under test: {@link GraphHook#postExecute(Object, OperationChain, Context)}
   */
  @Test
  @DisplayName("Test postExecute(Object, OperationChain, Context)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object GraphHook.postExecute(Object, OperationChain, Context)"})
  void testPostExecute() {
    // Arrange
    FunctionAuthoriser functionAuthoriser = new FunctionAuthoriser();
    OperationChain<?> opChain = OperationChain.wrap(new ExportToOtherAuthorisedGraph());

    // Act and Assert
    assertEquals("Result", functionAuthoriser.postExecute("Result", opChain, new Context()));
  }

  /**
   * Test {@link GraphHook#onFailure(Object, OperationChain, Context, Exception)}.
   *
   * <p>Method under test: {@link GraphHook#onFailure(Object, OperationChain, Context, Exception)}
   */
  @Test
  @DisplayName("Test onFailure(Object, OperationChain, Context, Exception)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object GraphHook.onFailure(Object, OperationChain, Context, Exception)"})
  void testOnFailure() {
    // Arrange
    FunctionAuthoriser functionAuthoriser = new FunctionAuthoriser();
    OperationChain<?> opChain = OperationChain.wrap(new ExportToOtherAuthorisedGraph());
    Context context = new Context();

    // Act and Assert
    assertEquals(
        "Result", functionAuthoriser.onFailure("Result", opChain, context, new Exception()));
  }
}
