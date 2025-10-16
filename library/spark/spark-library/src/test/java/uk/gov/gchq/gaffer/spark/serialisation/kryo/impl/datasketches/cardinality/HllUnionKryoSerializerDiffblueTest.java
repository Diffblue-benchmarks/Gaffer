package uk.gov.gchq.gaffer.spark.serialisation.kryo.impl.datasketches.cardinality;

import static org.junit.jupiter.api.Assertions.assertFalse;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class HllUnionKryoSerializerDiffblueTest {
  /**
   * Test new {@link HllUnionKryoSerializer} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link HllUnionKryoSerializer}
   */
  @Test
  @DisplayName("Test new HllUnionKryoSerializer (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void HllUnionKryoSerializer.<init>()"})
  void testNewHllUnionKryoSerializer() {
    // Arrange and Act
    HllUnionKryoSerializer actualHllUnionKryoSerializer = new HllUnionKryoSerializer();

    // Assert
    assertFalse(actualHllUnionKryoSerializer.getAcceptsNull());
    assertFalse(actualHllUnionKryoSerializer.isImmutable());
  }
}
