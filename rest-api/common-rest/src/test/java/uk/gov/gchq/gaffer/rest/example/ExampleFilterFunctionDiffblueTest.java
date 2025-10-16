package uk.gov.gchq.gaffer.rest.example;

import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ExampleFilterFunction.test(Object)"})
  void testTest() {
    // Arrange, Act and Assert
    assertTrue(new ExampleFilterFunction().test("Input"));
  }
}
