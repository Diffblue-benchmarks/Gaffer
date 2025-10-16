package uk.gov.gchq.gaffer.time.function;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ToSingletonTreeSetDiffblueTest {
  /**
   * Test {@link ToSingletonTreeSet#apply(Object)}.
   *
   * <p>Method under test: {@link ToSingletonTreeSet#apply(Object)}
   */
  @Test
  @DisplayName("Test apply(Object)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.TreeSet ToSingletonTreeSet.apply(Object)"})
  void testApply() {
    // Arrange, Act and Assert
    assertEquals(1, new ToSingletonTreeSet().apply("42").size());
  }
}
