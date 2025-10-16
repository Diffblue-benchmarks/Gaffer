package uk.gov.gchq.gaffer.spark.serialisation.kryo.impl;

import static org.junit.jupiter.api.Assertions.assertFalse;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class EntityKryoSerializerDiffblueTest {
  /**
   * Test new {@link EntityKryoSerializer} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link EntityKryoSerializer}
   */
  @Test
  @DisplayName("Test new EntityKryoSerializer (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void EntityKryoSerializer.<init>()"})
  void testNewEntityKryoSerializer() {
    // Arrange and Act
    EntityKryoSerializer actualEntityKryoSerializer = new EntityKryoSerializer();

    // Assert
    assertFalse(actualEntityKryoSerializer.getAcceptsNull());
    assertFalse(actualEntityKryoSerializer.isImmutable());
  }
}
