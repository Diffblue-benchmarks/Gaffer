package uk.gov.gchq.gaffer.store;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.store.TypeReferenceStoreImpl.Operations;
import uk.gov.gchq.gaffer.store.TypeReferenceStoreImpl.StoreTraits;

class TypeReferenceStoreImplDiffblueTest {
  /**
   * Test Operations new {@link Operations} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link Operations}
   */
  @Test
  @DisplayName("Test Operations new Operations (default constructor)")
  @Tag("MaintainedByDiffblue")
  void testOperationsNewOperations() {
    // Arrange, Act and Assert
    assertEquals(
        "java.util.Set<java.lang.Class<? extends uk.gov.gchq.gaffer.operation.Operation>>",
        new Operations().getType().getTypeName());
  }

  /**
   * Test StoreTraits new {@link StoreTraits} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link StoreTraits}
   */
  @Test
  @DisplayName("Test StoreTraits new StoreTraits (default constructor)")
  @Tag("MaintainedByDiffblue")
  void testStoreTraitsNewStoreTraits() {
    // Arrange, Act and Assert
    assertEquals(
        "java.util.Set<uk.gov.gchq.gaffer.store.StoreTrait>",
        new StoreTraits().getType().getTypeName());
  }
}
