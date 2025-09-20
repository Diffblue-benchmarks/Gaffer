package uk.gov.gchq.gaffer.spark.serialisation.kryo.impl;

import static org.junit.jupiter.api.Assertions.assertFalse;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class TypeValueKryoSerializerDiffblueTest {
  /**
   * Test new {@link TypeValueKryoSerializer} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link TypeValueKryoSerializer}
   */
  @Test
  @DisplayName("Test new TypeValueKryoSerializer (default constructor)")
  @Tag("MaintainedByDiffblue")
  void testNewTypeValueKryoSerializer() {
    // Arrange and Act
    TypeValueKryoSerializer actualTypeValueKryoSerializer = new TypeValueKryoSerializer();

    // Assert
    assertFalse(actualTypeValueKryoSerializer.getAcceptsNull());
    assertFalse(actualTypeValueKryoSerializer.isImmutable());
  }
}
