package uk.gov.gchq.gaffer.flink.operation.handler.serialisation;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import org.apache.flink.api.common.typeinfo.PrimitiveArrayTypeInfo;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ByteArraySchemaDiffblueTest {
  /**
   * Test {@link ByteArraySchema#deserialize(byte[])}.
   *
   * <p>Method under test: {@link ByteArraySchema#deserialize(byte[])}
   */
  @Test
  @DisplayName("Test deserialize(byte[])")
  @Tag("MaintainedByDiffblue")
  void testDeserialize() throws IOException {
    // Arrange and Act
    byte[] actualDeserializeResult =
        new ByteArraySchema().deserialize("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualDeserializeResult);
  }

  /**
   * Test {@link ByteArraySchema#isEndOfStream(byte[])} with {@code byte[]}.
   *
   * <p>Method under test: {@link ByteArraySchema#isEndOfStream(byte[])}
   */
  @Test
  @DisplayName("Test isEndOfStream(byte[]) with 'byte[]'")
  @Tag("MaintainedByDiffblue")
  void testIsEndOfStreamWithByte() throws UnsupportedEncodingException {
    // Arrange and Act
    boolean actualIsEndOfStreamResult =
        new ByteArraySchema().isEndOfStream("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertFalse(actualIsEndOfStreamResult);
  }

  /**
   * Test new {@link ByteArraySchema} (default constructor).
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link ByteArraySchema}
   *   <li>{@link ByteArraySchema#getProducedType()}
   * </ul>
   */
  @Test
  @DisplayName("Test new ByteArraySchema (default constructor)")
  @Tag("MaintainedByDiffblue")
  void testNewByteArraySchema() {
    // Arrange, Act and Assert
    assertTrue(new ByteArraySchema().getProducedType() instanceof PrimitiveArrayTypeInfo);
  }
}
