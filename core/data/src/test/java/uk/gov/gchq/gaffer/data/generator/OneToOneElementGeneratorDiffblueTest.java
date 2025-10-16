package uk.gov.gchq.gaffer.data.generator;

import static org.junit.jupiter.api.Assertions.assertFalse;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class OneToOneElementGeneratorDiffblueTest {
  /**
   * Test {@link OneToOneElementGenerator#apply(Iterable)} with {@code Iterable}.
   *
   * <p>Method under test: {@link OneToOneElementGenerator#apply(Iterable)}
   */
  @Test
  @DisplayName("Test apply(Iterable) with 'Iterable'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Iterable OneToOneElementGenerator.apply(Iterable)"})
  void testApplyWithIterable() {
    // Arrange
    JsonToElementGenerator jsonToElementGenerator = new JsonToElementGenerator();

    // Act and Assert
    assertFalse(jsonToElementGenerator.apply(new ArrayList<>()).iterator().hasNext());
  }
}
