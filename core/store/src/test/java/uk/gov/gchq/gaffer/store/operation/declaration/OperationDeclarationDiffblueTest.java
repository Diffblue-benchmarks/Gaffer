package uk.gov.gchq.gaffer.store.operation.declaration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.operation.Operation;
import uk.gov.gchq.gaffer.store.operation.declaration.OperationDeclaration.Builder;
import uk.gov.gchq.gaffer.store.operation.handler.OperationHandler;

class OperationDeclarationDiffblueTest {
  /**
   * Test Builder {@link Builder#build()}.
   *
   * <p>Method under test: {@link Builder#build()}
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"OperationDeclaration Builder.build()"})
  void testBuilderBuild() {
    // Arrange
    OperationHandler handler = mock(OperationHandler.class);

    // Act
    Builder actualHandlerResult = new Builder().handler(handler);
    Class<Operation> operation = Operation.class;
    OperationDeclaration actualOperationDeclaration =
        actualHandlerResult.operation(operation).build();

    // Assert
    Class<Operation> expectedOperation = Operation.class;
    Class<? extends Operation> operation2 = actualOperationDeclaration.getOperation();
    assertEquals(expectedOperation, operation2);
    assertSame(operation, operation2);
    assertSame(handler, actualOperationDeclaration.getHandler());
  }

  /**
   * Test Builder {@link Builder#handler(OperationHandler)}.
   *
   * <p>Method under test: {@link Builder#handler(OperationHandler)}
   */
  @Test
  @DisplayName("Test Builder handler(OperationHandler)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.handler(OperationHandler)"})
  void testBuilderHandler() {
    // Arrange
    Builder builder = new Builder();

    // Act
    Builder actualHandlerResult = builder.handler(mock(OperationHandler.class));

    // Assert
    assertSame(builder, actualHandlerResult);
  }

  /**
   * Test Builder new {@link Builder} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link Builder}
   */
  @Test
  @DisplayName("Test Builder new Builder (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Builder.<init>()"})
  void testBuilderNewBuilder() {
    // Arrange, Act and Assert
    OperationDeclaration operationDeclaration = new Builder().build();
    assertNull(operationDeclaration.getOperation());
    assertNull(operationDeclaration.getHandler());
  }

  /**
   * Test Builder {@link Builder#operation(Class)}.
   *
   * <p>Method under test: {@link Builder#operation(Class)}
   */
  @Test
  @DisplayName("Test Builder operation(Class)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.operation(Class)"})
  void testBuilderOperation() {
    // Arrange
    Builder builder = new Builder();
    Class<Operation> operation = Operation.class;

    // Act
    Builder actualOperationResult = builder.operation(operation);

    // Assert
    assertSame(builder, actualOperationResult);
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link OperationDeclaration}
   *   <li>{@link OperationDeclaration#setHandler(OperationHandler)}
   *   <li>{@link OperationDeclaration#setOperation(Class)}
   *   <li>{@link OperationDeclaration#toString()}
   *   <li>{@link OperationDeclaration#getHandler()}
   *   <li>{@link OperationDeclaration#getOperation()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void OperationDeclaration.<init>()",
    "OperationHandler OperationDeclaration.getHandler()",
    "Class OperationDeclaration.getOperation()",
    "void OperationDeclaration.setHandler(OperationHandler)",
    "void OperationDeclaration.setOperation(Class)",
    "java.lang.String OperationDeclaration.toString()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    OperationDeclaration actualOperationDeclaration = new OperationDeclaration();
    OperationHandler handler = mock(OperationHandler.class);
    actualOperationDeclaration.setHandler(handler);
    Class<Operation> operation = Operation.class;
    actualOperationDeclaration.setOperation(operation);
    actualOperationDeclaration.toString();
    OperationHandler actualHandler = actualOperationDeclaration.getHandler();
    Class<? extends Operation> actualOperation = actualOperationDeclaration.getOperation();

    // Assert
    Class<Operation> expectedOperation = Operation.class;
    assertEquals(expectedOperation, actualOperation);
    assertSame(operation, actualOperation);
    assertSame(handler, actualHandler);
  }
}
