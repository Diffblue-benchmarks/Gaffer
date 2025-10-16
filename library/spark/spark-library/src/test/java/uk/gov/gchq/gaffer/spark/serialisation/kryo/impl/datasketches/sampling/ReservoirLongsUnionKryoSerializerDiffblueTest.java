package uk.gov.gchq.gaffer.spark.serialisation.kryo.impl.datasketches.sampling;

import static org.junit.jupiter.api.Assertions.assertFalse;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ReservoirLongsUnionKryoSerializer.<init>()"})
  void testNewReservoirLongsUnionKryoSerializer() {
    // Arrange and Act
    ReservoirLongsUnionKryoSerializer actualReservoirLongsUnionKryoSerializer =
        new ReservoirLongsUnionKryoSerializer();

    // Assert
    assertFalse(actualReservoirLongsUnionKryoSerializer.getAcceptsNull());
    assertFalse(actualReservoirLongsUnionKryoSerializer.isImmutable());
  }
}
