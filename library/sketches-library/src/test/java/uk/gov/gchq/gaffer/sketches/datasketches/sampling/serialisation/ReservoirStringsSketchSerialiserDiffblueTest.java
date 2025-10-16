package uk.gov.gchq.gaffer.sketches.datasketches.sampling.serialisation;

import static org.junit.jupiter.api.Assertions.assertFalse;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ReservoirStringsSketchSerialiserDiffblueTest {
  /**
   * Test new {@link ReservoirStringsSketchSerialiser} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link
   * ReservoirStringsSketchSerialiser}
   */
  @Test
  @DisplayName("Test new ReservoirStringsSketchSerialiser (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ReservoirStringsSketchSerialiser.<init>()"})
  void testNewReservoirStringsSketchSerialiser() {
    // Arrange, Act and Assert
    assertFalse(new ReservoirStringsSketchSerialiser().isConsistent());
  }
}
