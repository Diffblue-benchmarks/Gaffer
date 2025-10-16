package uk.gov.gchq.gaffer.graph;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Set;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.operation.OperationChain;
import uk.gov.gchq.gaffer.operation.export.graph.ExportToOtherAuthorisedGraph;
import uk.gov.gchq.gaffer.store.schema.Schema;
import uk.gov.gchq.koryphe.ValidationResult;

class SchemaOperationChainUtilDiffblueTest {
  /**
   * Test {@link SchemaOperationChainUtil#validate(Schema, OperationChain)}.
   *
   * <p>Method under test: {@link SchemaOperationChainUtil#validate(Schema, OperationChain)}
   */
  @Test
  @DisplayName("Test validate(Schema, OperationChain)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ValidationResult SchemaOperationChainUtil.validate(Schema, OperationChain)"})
  void testValidate() {
    // Arrange
    Schema schema = new Schema();
    OperationChain<?> operationChain = OperationChain.wrap(new ExportToOtherAuthorisedGraph());

    // Act
    ValidationResult actualValidateResult =
        SchemaOperationChainUtil.validate(schema, operationChain);

    // Assert
    assertEquals(
        "Validation errors: \ngraphId is required for: ExportToOtherAuthorisedGraph",
        actualValidateResult.getErrorString());
    Set<String> errors = actualValidateResult.getErrors();
    assertEquals(1, errors.size());
    assertFalse(actualValidateResult.isValid());
    assertTrue(errors.contains("graphId is required for: ExportToOtherAuthorisedGraph"));
  }
}
