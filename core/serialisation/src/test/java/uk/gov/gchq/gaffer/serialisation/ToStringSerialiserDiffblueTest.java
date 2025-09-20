package uk.gov.gchq.gaffer.serialisation;

import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.serialisation.implementation.tostring.StringToStringSerialiser;

class ToStringSerialiserDiffblueTest {
  /**
   * Test {@link ToStringSerialiser#serialiseNull()}.
   *
   * <p>Method under test: {@link ToStringSerialiser#serialiseNull()}
   */
  @Test
  @DisplayName("Test serialiseNull()")
  @Tag("MaintainedByDiffblue")
  void testSerialiseNull() {
    // Arrange, Act and Assert
    assertNull(new StringToStringSerialiser().serialiseNull());
  }

  /**
   * Test {@link ToStringSerialiser#deserialiseEmpty()}.
   *
   * <p>Method under test: {@link ToStringSerialiser#deserialiseEmpty()}
   */
  @Test
  @DisplayName("Test deserialiseEmpty()")
  @Tag("MaintainedByDiffblue")
  void testDeserialiseEmpty() {
    // Arrange, Act and Assert
    assertNull(new StringToStringSerialiser().deserialiseEmpty());
  }
}
