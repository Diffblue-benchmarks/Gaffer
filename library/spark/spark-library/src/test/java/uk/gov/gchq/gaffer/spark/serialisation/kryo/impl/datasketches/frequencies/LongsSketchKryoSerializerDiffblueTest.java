package uk.gov.gchq.gaffer.spark.serialisation.kryo.impl.datasketches.frequencies;

import static org.junit.jupiter.api.Assertions.assertFalse;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class LongsSketchKryoSerializerDiffblueTest {
  /**
   * Test new {@link LongsSketchKryoSerializer} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link LongsSketchKryoSerializer}
   */
  @Test
  @DisplayName("Test new LongsSketchKryoSerializer (default constructor)")
  @Tag("MaintainedByDiffblue")
  void testNewLongsSketchKryoSerializer() {
    // Arrange and Act
    LongsSketchKryoSerializer actualLongsSketchKryoSerializer = new LongsSketchKryoSerializer();

    // Assert
    assertFalse(actualLongsSketchKryoSerializer.getAcceptsNull());
    assertFalse(actualLongsSketchKryoSerializer.isImmutable());
  }
}
