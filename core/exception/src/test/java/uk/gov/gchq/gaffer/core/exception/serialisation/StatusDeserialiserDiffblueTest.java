package uk.gov.gchq.gaffer.core.exception.serialisation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import com.fasterxml.jackson.databind.util.AccessPattern;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class StatusDeserialiserDiffblueTest {
  /**
   * Test new {@link StatusDeserialiser} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link StatusDeserialiser}
   */
  @Test
  @DisplayName("Test new StatusDeserialiser (default constructor)")
  @Tag("MaintainedByDiffblue")
  void testNewStatusDeserialiser() {
    // Arrange and Act
    StatusDeserialiser actualStatusDeserialiser = new StatusDeserialiser();

    // Assert
    assertNull(actualStatusDeserialiser.getDelegatee());
    assertNull(actualStatusDeserialiser.getObjectIdReader());
    assertNull(actualStatusDeserialiser.getEmptyValue());
    assertNull(actualStatusDeserialiser.getKnownPropertyNames());
    assertNull(actualStatusDeserialiser.getNullValue());
    assertEquals(AccessPattern.CONSTANT, actualStatusDeserialiser.getNullAccessPattern());
    assertEquals(AccessPattern.DYNAMIC, actualStatusDeserialiser.getEmptyAccessPattern());
    assertFalse(actualStatusDeserialiser.isCachable());
  }
}
