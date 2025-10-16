package uk.gov.gchq.gaffer.spark.serialisation.kryo.impl.datasketches.quantiles;

import static org.junit.jupiter.api.Assertions.assertFalse;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class StringsSketchKryoSerializerDiffblueTest {
  /**
   * Test new {@link StringsSketchKryoSerializer} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link
   * StringsSketchKryoSerializer}
   */
  @Test
  @DisplayName("Test new StringsSketchKryoSerializer (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void StringsSketchKryoSerializer.<init>()"})
  void testNewStringsSketchKryoSerializer() {
    // Arrange and Act
    StringsSketchKryoSerializer actualStringsSketchKryoSerializer =
        new StringsSketchKryoSerializer();

    // Assert
    assertFalse(actualStringsSketchKryoSerializer.getAcceptsNull());
    assertFalse(actualStringsSketchKryoSerializer.isImmutable());
  }
}
