package uk.gov.gchq.gaffer.data.generator;

import static org.junit.jupiter.api.Assertions.assertFalse;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class OneToOneObjectGeneratorDiffblueTest {
  /**
   * Test {@link OneToOneObjectGenerator#apply(Iterable)} with {@code Iterable}.
   *
   * <p>Method under test: {@link OneToOneObjectGenerator#apply(Iterable)}
   */
  @Test
  @DisplayName("Test apply(Iterable) with 'Iterable'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Iterable OneToOneObjectGenerator.apply(Iterable)"})
  void testApplyWithIterable() {
    // Arrange
    CsvGenerator csvGenerator = new CsvGenerator();

    // Act and Assert
    assertFalse(csvGenerator.apply(new ArrayList<>()).iterator().hasNext());
  }
}
