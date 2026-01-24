/*
 * Copyright 2026 Crown Copyright
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package uk.gov.gchq.gaffer.flink.operation.handler.serialisation;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import org.apache.flink.api.common.typeinfo.PrimitiveArrayTypeInfo;
import org.apache.flink.api.common.typeinfo.TypeInformation;
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] ByteArraySchema.deserialize(byte[])"})
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ByteArraySchema.isEndOfStream(byte[])"})
  void testIsEndOfStreamWithByte() throws UnsupportedEncodingException {
    // Arrange and Act
    boolean actualIsEndOfStreamResult =
        new ByteArraySchema().isEndOfStream("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertFalse(actualIsEndOfStreamResult);
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link ByteArraySchema}
   *   <li>{@link ByteArraySchema#getProducedType()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ByteArraySchema.<init>()",
    "TypeInformation ByteArraySchema.getProducedType()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    TypeInformation<byte[]> actualProducedType = new ByteArraySchema().getProducedType();

    // Assert
    assertSame(
        ((PrimitiveArrayTypeInfo) actualProducedType).BYTE_PRIMITIVE_ARRAY_TYPE_INFO,
        actualProducedType);
  }
}
