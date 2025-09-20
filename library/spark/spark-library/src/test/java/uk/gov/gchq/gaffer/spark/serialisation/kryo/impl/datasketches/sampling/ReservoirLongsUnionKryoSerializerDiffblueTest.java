package uk.gov.gchq.gaffer.spark.serialisation.kryo.impl.datasketches.sampling;

import static org.junit.jupiter.api.Assertions.assertFalse;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ReservoirLongsUnionKryoSerializerDiffblueTest {
  /**
   * Test new {@link ReservoirLongsUnionKryoSerializer} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link
   * ReservoirLongsUnionKryoSerializer}
   */
  @Test
  @DisplayName("Test new ReservoirLongsUnionKryoSerializer (default constructor)")
  @Tag("MaintainedByDiffblue")
  void testNewReservoirLongsUnionKryoSerializer() {
    // Arrange and Act
    ReservoirLongsUnionKryoSerializer actualReservoirLongsUnionKryoSerializer =
        new ReservoirLongsUnionKryoSerializer();

    // Assert
    assertFalse(actualReservoirLongsUnionKryoSerializer.getAcceptsNull());
    assertFalse(actualReservoirLongsUnionKryoSerializer.isImmutable());
  }
}
