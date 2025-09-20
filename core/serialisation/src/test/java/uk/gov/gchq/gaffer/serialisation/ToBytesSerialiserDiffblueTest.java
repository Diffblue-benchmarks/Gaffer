package uk.gov.gchq.gaffer.serialisation;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import java.io.UnsupportedEncodingException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.exception.SerialisationException;
import uk.gov.gchq.gaffer.serialisation.implementation.BooleanSerialiser;
import uk.gov.gchq.gaffer.serialisation.implementation.BytesSerialiser;

class ToBytesSerialiserDiffblueTest {
  /**
   * Test {@link ToBytesSerialiser#serialiseNull()}.
   *
   * <p>Method under test: {@link ToBytesSerialiser#serialiseNull()}
   */
  @Test
  @DisplayName("Test serialiseNull()")
  @Tag("MaintainedByDiffblue")
  void testSerialiseNull() {
    // Arrange, Act and Assert
    assertArrayEquals(new byte[] {}, new BooleanSerialiser().serialiseNull());
  }

  /**
   * Test {@link ToBytesSerialiser#deserialise(byte[], int, int)} with {@code byte[]}, {@code int},
   * {@code int}.
   *
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.
   *   <li>Then return {@code AXA} Bytes is {@code UTF-8}.
   * </ul>
   *
   * <p>Method under test: {@link ToBytesSerialiser#deserialise(byte[], int, int)}
   */
  @Test
  @DisplayName(
      "Test deserialise(byte[], int, int) with 'byte[]', 'int', 'int'; when 'AXAXAXAX' Bytes is 'UTF-8'; then return 'AXA' Bytes is 'UTF-8'")
  @Tag("MaintainedByDiffblue")
  void testDeserialiseWithByteIntInt_whenAxaxaxaxBytesIsUtf8_thenReturnAxaBytesIsUtf8()
      throws UnsupportedEncodingException, SerialisationException {
    // Arrange, Act and Assert
    assertArrayEquals(
        "AXA".getBytes("UTF-8"),
        new BytesSerialiser().deserialise("AXAXAXAX".getBytes("UTF-8"), 2, 3));
  }
}
