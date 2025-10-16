package uk.gov.gchq.gaffer.spark.serialisation.kryo.impl;

import static org.junit.jupiter.api.Assertions.assertFalse;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class HyperLogLogPlusKryoSerializerDiffblueTest {
  /**
   * Test new {@link HyperLogLogPlusKryoSerializer} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link
   * HyperLogLogPlusKryoSerializer}
   */
  @Test
  @DisplayName("Test new HyperLogLogPlusKryoSerializer (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void HyperLogLogPlusKryoSerializer.<init>()"})
  void testNewHyperLogLogPlusKryoSerializer() {
    // Arrange and Act
    HyperLogLogPlusKryoSerializer actualHyperLogLogPlusKryoSerializer =
        new HyperLogLogPlusKryoSerializer();

    // Assert
    assertFalse(actualHyperLogLogPlusKryoSerializer.getAcceptsNull());
    assertFalse(actualHyperLogLogPlusKryoSerializer.isImmutable());
  }
}
