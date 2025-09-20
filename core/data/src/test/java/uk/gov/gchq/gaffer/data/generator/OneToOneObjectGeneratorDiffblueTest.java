package uk.gov.gchq.gaffer.data.generator;

import static org.junit.jupiter.api.Assertions.assertFalse;
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
  @Tag("MaintainedByDiffblue")
  void testApplyWithIterable() {
    // Arrange
    CsvGenerator csvGenerator = new CsvGenerator();

    // Act and Assert
    assertFalse(csvGenerator.apply(new ArrayList<>()).iterator().hasNext());
  }
}
