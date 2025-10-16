package uk.gov.gchq.gaffer.spark.serialisation.kryo.impl.datasketches.quantiles;

import static org.junit.jupiter.api.Assertions.assertFalse;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class StringsUnionKryoSerializerDiffblueTest {
  /**
   * Test new {@link StringsUnionKryoSerializer} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link
   * StringsUnionKryoSerializer}
   */
  @Test
  @DisplayName("Test new StringsUnionKryoSerializer (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void StringsUnionKryoSerializer.<init>()"})
  void testNewStringsUnionKryoSerializer() {
    // Arrange and Act
    StringsUnionKryoSerializer actualStringsUnionKryoSerializer = new StringsUnionKryoSerializer();

    // Assert
    assertFalse(actualStringsUnionKryoSerializer.getAcceptsNull());
    assertFalse(actualStringsUnionKryoSerializer.isImmutable());
  }
}
