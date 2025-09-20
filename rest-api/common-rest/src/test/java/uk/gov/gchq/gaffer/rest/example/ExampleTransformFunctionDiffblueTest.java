package uk.gov.gchq.gaffer.rest.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ExampleTransformFunctionDiffblueTest {
  /**
   * Test {@link ExampleTransformFunction#apply(Object)}.
   *
   * <p>Method under test: {@link ExampleTransformFunction#apply(Object)}
   */
  @Test
  @DisplayName("Test apply(Object)")
  @Tag("MaintainedByDiffblue")
  void testApply() {
    // Arrange, Act and Assert
    assertEquals("Input transformed", new ExampleTransformFunction().apply("Input"));
  }
}
