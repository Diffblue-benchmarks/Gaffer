package uk.gov.gchq.gaffer.spark.serialisation.kryo.impl.datasketches.sampling;

import static org.junit.jupiter.api.Assertions.assertFalse;
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
  @Tag("MaintainedByDiffblue")
  void testNewReservoirLongsSketchKryoSerializer() {
    // Arrange and Act
    ReservoirLongsSketchKryoSerializer actualReservoirLongsSketchKryoSerializer =
        new ReservoirLongsSketchKryoSerializer();

    // Assert
    assertFalse(actualReservoirLongsSketchKryoSerializer.getAcceptsNull());
    assertFalse(actualReservoirLongsSketchKryoSerializer.isImmutable());
  }
}
