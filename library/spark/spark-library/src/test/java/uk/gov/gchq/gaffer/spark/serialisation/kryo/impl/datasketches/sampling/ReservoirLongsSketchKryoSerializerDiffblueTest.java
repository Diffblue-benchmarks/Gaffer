package uk.gov.gchq.gaffer.spark.serialisation.kryo.impl.datasketches.sampling;

import static org.junit.jupiter.api.Assertions.assertFalse;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ReservoirLongsSketchKryoSerializerDiffblueTest {
  /**
   * Test new {@link ReservoirLongsSketchKryoSerializer} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link
   * ReservoirLongsSketchKryoSerializer}
   */
  @Test
  @DisplayName("Test new ReservoirLongsSketchKryoSerializer (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ReservoirLongsSketchKryoSerializer.<init>()"})
  void testNewReservoirLongsSketchKryoSerializer() {
    // Arrange and Act
    ReservoirLongsSketchKryoSerializer actualReservoirLongsSketchKryoSerializer =
        new ReservoirLongsSketchKryoSerializer();

    // Assert
    assertFalse(actualReservoirLongsSketchKryoSerializer.getAcceptsNull());
    assertFalse(actualReservoirLongsSketchKryoSerializer.isImmutable());
  }
}
