package uk.gov.gchq.gaffer.spark.serialisation.kryo.impl;

import static org.junit.jupiter.api.Assertions.assertFalse;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class TypeSubTypeValueKryoSerializerDiffblueTest {
  /**
   * Test new {@link TypeSubTypeValueKryoSerializer} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link
   * TypeSubTypeValueKryoSerializer}
   */
  @Test
  @DisplayName("Test new TypeSubTypeValueKryoSerializer (default constructor)")
  @Tag("MaintainedByDiffblue")
  void testNewTypeSubTypeValueKryoSerializer() {
    // Arrange and Act
    TypeSubTypeValueKryoSerializer actualTypeSubTypeValueKryoSerializer =
        new TypeSubTypeValueKryoSerializer();

    // Assert
    assertFalse(actualTypeSubTypeValueKryoSerializer.getAcceptsNull());
    assertFalse(actualTypeSubTypeValueKryoSerializer.isImmutable());
  }
}
