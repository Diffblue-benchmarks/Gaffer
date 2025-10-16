package uk.gov.gchq.gaffer.spark.serialisation.kryo.impl.datasketches.cardinality;

import static org.junit.jupiter.api.Assertions.assertFalse;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class HllSketchKryoSerializerDiffblueTest {
  /**
   * Test new {@link HllSketchKryoSerializer} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link HllSketchKryoSerializer}
   */
  @Test
  @DisplayName("Test new HllSketchKryoSerializer (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void HllSketchKryoSerializer.<init>()"})
  void testNewHllSketchKryoSerializer() {
    // Arrange and Act
    HllSketchKryoSerializer actualHllSketchKryoSerializer = new HllSketchKryoSerializer();

    // Assert
    assertFalse(actualHllSketchKryoSerializer.getAcceptsNull());
    assertFalse(actualHllSketchKryoSerializer.isImmutable());
  }
}
