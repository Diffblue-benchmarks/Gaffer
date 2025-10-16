package uk.gov.gchq.gaffer.operation.io;

import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.named.operation.NamedOperation;
import uk.gov.gchq.gaffer.named.operation.NamedOperation.Builder;

class InputDiffblueTest {
  /**
   * Test Builder {@link uk.gov.gchq.gaffer.operation.io.Input.Builder#input(Object)}.
   *
   * <p>Method under test: {@link uk.gov.gchq.gaffer.operation.io.Input.Builder#input(Object)}
   */
  @Test
  @DisplayName("Test Builder input(Object)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "uk.gov.gchq.gaffer.operation.io.Input.Builder uk.gov.gchq.gaffer.operation.io.Input.Builder.input(Object)"
  })
  void testBuilderInput() {
    // Arrange
    Builder<Object, Object> builder = new Builder<>();

    // Act
    Builder<Object, Object> actualInputResult = builder.input(new ArrayList<>());

    // Assert
    assertSame(builder, actualInputResult);
  }
}
