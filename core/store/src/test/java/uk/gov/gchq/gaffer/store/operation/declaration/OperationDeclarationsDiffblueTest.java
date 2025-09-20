package uk.gov.gchq.gaffer.store.operation.declaration;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.core.exception.GafferRuntimeException;
import uk.gov.gchq.gaffer.operation.Operation;
import uk.gov.gchq.gaffer.store.operation.declaration.OperationDeclarations.Builder;
import uk.gov.gchq.gaffer.store.operation.handler.OperationHandler;

class OperationDeclarationsDiffblueTest {
  /**
   * Test Builder {@link Builder#build()}.
   *
   * <p>Method under test: {@link Builder#build()}
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("MaintainedByDiffblue")
  void testBuilderBuild() {
    // Arrange, Act and Assert
    assertTrue(new Builder().build().getOperations().isEmpty());
  }

  /**
   * Test Builder {@link Builder#declaration(OperationDeclaration)}.
   *
   * <p>Method under test: {@link Builder#declaration(OperationDeclaration)}
   */
  @Test
  @DisplayName("Test Builder declaration(OperationDeclaration)")
  @Tag("MaintainedByDiffblue")
  void testBuilderDeclaration() {
    // Arrange
    Builder builder = new Builder();

    OperationDeclaration declaration = new OperationDeclaration();
    declaration.setHandler(mock(OperationHandler.class));
    Class<Operation> operation = Operation.class;
    declaration.setOperation(operation);

    // Act
    Builder actualDeclarationResult = builder.declaration(declaration);

    // Assert
    assertSame(builder, actualDeclarationResult);
  }

  /**
   * Test Builder new {@link Builder} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link Builder}
   */
  @Test
  @DisplayName("Test Builder new Builder (default constructor)")
  @Tag("MaintainedByDiffblue")
  void testBuilderNewBuilder() {
    // Arrange, Act and Assert
    assertTrue(new Builder().build().getOperations().isEmpty());
  }

  /**
   * Test {@link OperationDeclarations#fromPaths(String)}.
   *
   * <ul>
   *   <li>When {@code ,}.
   *   <li>Then return Operations Empty.
   * </ul>
   *
   * <p>Method under test: {@link OperationDeclarations#fromPaths(String)}
   */
  @Test
  @DisplayName("Test fromPaths(String); when ','; then return Operations Empty")
  @Tag("MaintainedByDiffblue")
  void testFromPaths_whenComma_thenReturnOperationsEmpty() {
    // Arrange, Act and Assert
    assertTrue(OperationDeclarations.fromPaths(",").getOperations().isEmpty());
  }

  /**
   * Test {@link OperationDeclarations#fromPaths(String)}.
   *
   * <ul>
   *   <li>When {@code /}.
   *   <li>Then throw {@link GafferRuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link OperationDeclarations#fromPaths(String)}
   */
  @Test
  @DisplayName("Test fromPaths(String); when '/'; then throw GafferRuntimeException")
  @Tag("MaintainedByDiffblue")
  void testFromPaths_whenSlash_thenThrowGafferRuntimeException() {
    // Arrange, Act and Assert
    assertThrows(GafferRuntimeException.class, () -> OperationDeclarations.fromPaths("/"));
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link OperationDeclarations}
   *   <li>{@link OperationDeclarations#setOperations(List)}
   *   <li>{@link OperationDeclarations#getOperations()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  void testGettersAndSetters() {
    // Arrange and Act
    OperationDeclarations actualOperationDeclarations = new OperationDeclarations();
    ArrayList<OperationDeclaration> operations = new ArrayList<>();
    actualOperationDeclarations.setOperations(operations);
    List<OperationDeclaration> actualOperations = actualOperationDeclarations.getOperations();

    // Assert
    assertTrue(actualOperations.isEmpty());
    assertSame(operations, actualOperations);
  }
}
