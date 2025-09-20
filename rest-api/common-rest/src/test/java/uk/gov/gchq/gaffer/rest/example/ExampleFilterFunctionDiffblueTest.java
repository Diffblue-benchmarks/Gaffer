package uk.gov.gchq.gaffer.rest.example;

import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ExampleFilterFunctionDiffblueTest {
  /**
   * Test {@link ExampleFilterFunction#test(Object)}.
   *
   * <p>Method under test: {@link ExampleFilterFunction#test(Object)}
   */
  @Test
  @DisplayName("Test test(Object)")
  @Tag("MaintainedByDiffblue")
  void testTest() {
    // Arrange, Act and Assert
    assertTrue(new ExampleFilterFunction().test("Input"));
  }
}
