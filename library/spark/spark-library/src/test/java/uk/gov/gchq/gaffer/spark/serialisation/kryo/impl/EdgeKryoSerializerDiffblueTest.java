package uk.gov.gchq.gaffer.spark.serialisation.kryo.impl;

import static org.junit.jupiter.api.Assertions.assertFalse;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class EdgeKryoSerializerDiffblueTest {
  /**
   * Test new {@link EdgeKryoSerializer} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link EdgeKryoSerializer}
   */
  @Test
  @DisplayName("Test new EdgeKryoSerializer (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void EdgeKryoSerializer.<init>()"})
  void testNewEdgeKryoSerializer() {
    // Arrange and Act
    EdgeKryoSerializer actualEdgeKryoSerializer = new EdgeKryoSerializer();

    // Assert
    assertFalse(actualEdgeKryoSerializer.getAcceptsNull());
    assertFalse(actualEdgeKryoSerializer.isImmutable());
  }
}
