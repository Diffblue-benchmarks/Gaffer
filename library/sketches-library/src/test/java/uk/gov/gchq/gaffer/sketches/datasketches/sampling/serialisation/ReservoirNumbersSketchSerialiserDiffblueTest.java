package uk.gov.gchq.gaffer.sketches.datasketches.sampling.serialisation;

import static org.junit.jupiter.api.Assertions.assertFalse;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ReservoirNumbersSketchSerialiserDiffblueTest {
  /**
   * Test new {@link ReservoirNumbersSketchSerialiser} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link
   * ReservoirNumbersSketchSerialiser}
   */
  @Test
  @DisplayName("Test new ReservoirNumbersSketchSerialiser (default constructor)")
  @Tag("MaintainedByDiffblue")
  void testNewReservoirNumbersSketchSerialiser() {
    // Arrange, Act and Assert
    assertFalse(new ReservoirNumbersSketchSerialiser().isConsistent());
  }
}
