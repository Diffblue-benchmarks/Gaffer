package uk.gov.gchq.gaffer.graph.hook;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.operation.OperationChain;
import uk.gov.gchq.gaffer.operation.export.graph.ExportToOtherAuthorisedGraph;
import uk.gov.gchq.gaffer.store.Context;

class GraphHookPathDiffblueTest {
  /**
   * Test {@link GraphHookPath#preExecute(OperationChain, Context)}.
   *
   * <p>Method under test: {@link GraphHookPath#preExecute(OperationChain, Context)}
   */
  @Test
  @DisplayName("Test preExecute(OperationChain, Context)")
  @Tag("MaintainedByDiffblue")
  void testPreExecute() {
    // Arrange
    GraphHookPath graphHookPath = new GraphHookPath();
    OperationChain<?> opChain = OperationChain.wrap(new ExportToOtherAuthorisedGraph());

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> graphHookPath.preExecute(opChain, new Context()));
  }

  /**
   * Test {@link GraphHookPath#postExecute(Object, OperationChain, Context)}.
   *
   * <p>Method under test: {@link GraphHookPath#postExecute(Object, OperationChain, Context)}
   */
  @Test
  @DisplayName("Test postExecute(Object, OperationChain, Context)")
  @Tag("MaintainedByDiffblue")
  void testPostExecute() {
    // Arrange
    GraphHookPath graphHookPath = new GraphHookPath();
    OperationChain<?> opChain = OperationChain.wrap(new ExportToOtherAuthorisedGraph());

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> graphHookPath.postExecute("Result", opChain, new Context()));
  }

  /**
   * Test {@link GraphHookPath#onFailure(Object, OperationChain, Context, Exception)}.
   *
   * <p>Method under test: {@link GraphHookPath#onFailure(Object, OperationChain, Context,
   * Exception)}
   */
  @Test
  @DisplayName("Test onFailure(Object, OperationChain, Context, Exception)")
  @Tag("MaintainedByDiffblue")
  void testOnFailure() {
    // Arrange
    GraphHookPath graphHookPath = new GraphHookPath();
    OperationChain<?> opChain = OperationChain.wrap(new ExportToOtherAuthorisedGraph());
    Context context = new Context();

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> graphHookPath.onFailure("Result", opChain, context, new Exception()));
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link GraphHookPath}
   *   <li>{@link GraphHookPath#setPath(String)}
   *   <li>{@link GraphHookPath#getPath()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  void testGettersAndSetters() {
    // Arrange and Act
    GraphHookPath actualGraphHookPath = new GraphHookPath();
    actualGraphHookPath.setPath("Path");

    // Assert
    assertEquals("Path", actualGraphHookPath.getPath());
  }
}
