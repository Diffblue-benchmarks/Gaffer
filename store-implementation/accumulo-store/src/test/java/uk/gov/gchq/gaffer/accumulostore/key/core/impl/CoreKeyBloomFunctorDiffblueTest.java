/*
 * Copyright 2025 Crown Copyright
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

package uk.gov.gchq.gaffer.accumulostore.key.core.impl;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.UnsupportedEncodingException;
import org.apache.accumulo.core.data.Key;
import org.apache.accumulo.core.data.Range;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.accumulostore.AccumuloProperties;

class CoreKeyBloomFunctorDiffblueTest {
  /**
   * Test {@link CoreKeyBloomFunctor#transform(Key)} with {@code key}.
   * <p>
   * Method under test: {@link CoreKeyBloomFunctor#transform(Key)}
   */
  @Test
  @DisplayName("Test transform(Key) with 'key'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"org.apache.hadoop.util.bloom.Key CoreKeyBloomFunctor.transform(Key)"})
  void testTransformWithKey() throws UnsupportedEncodingException {
    // Arrange
    CoreKeyBloomFunctor coreKeyBloomFunctor = new CoreKeyBloomFunctor();

    // Act
    org.apache.hadoop.util.bloom.Key actualTransformResult = coreKeyBloomFunctor
        .transform(new Key(AccumuloProperties.CLIENT_SIDE_BLOOM_FILTER_SIZE));

    // Assert
    assertEquals(1.0d, actualTransformResult.getWeight());
    byte[] expectedBytes = "accumulo.clientSideBloomFilterSize".getBytes("UTF-8");
    assertArrayEquals(expectedBytes, actualTransformResult.getBytes());
  }

  /**
   * Test {@link CoreKeyBloomFunctor#transform(Key)} with {@code key}.
   * <ul>
   *   <li>Given zero.</li>
   *   <li>When {@link StringBuilder#StringBuilder(String)} with {@code foo} appendCodePoint zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link CoreKeyBloomFunctor#transform(Key)}
   */
  @Test
  @DisplayName("Test transform(Key) with 'key'; given zero; when StringBuilder(String) with 'foo' appendCodePoint zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"org.apache.hadoop.util.bloom.Key CoreKeyBloomFunctor.transform(Key)"})
  void testTransformWithKey_givenZero_whenStringBuilderWithFooAppendCodePointZero()
      throws UnsupportedEncodingException {
    // Arrange
    CoreKeyBloomFunctor coreKeyBloomFunctor = new CoreKeyBloomFunctor();

    StringBuilder row = new StringBuilder("foo");
    row.appendCodePoint(0);

    // Act
    org.apache.hadoop.util.bloom.Key actualTransformResult = coreKeyBloomFunctor.transform(new Key(row));

    // Assert
    assertEquals(1.0d, actualTransformResult.getWeight());
    byte[] expectedBytes = "foo".getBytes("UTF-8");
    assertArrayEquals(expectedBytes, actualTransformResult.getBytes());
  }

  /**
   * Test {@link CoreKeyBloomFunctor#transform(Key)} with {@code key}.
   * <ul>
   *   <li>Then return Bytes is array of {@code byte} with {@code f} and {@code o}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CoreKeyBloomFunctor#transform(Key)}
   */
  @Test
  @DisplayName("Test transform(Key) with 'key'; then return Bytes is array of byte with 'f' and 'o'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"org.apache.hadoop.util.bloom.Key CoreKeyBloomFunctor.transform(Key)"})
  void testTransformWithKey_thenReturnBytesIsArrayOfByteWithFAndO() {
    // Arrange
    CoreKeyBloomFunctor coreKeyBloomFunctor = new CoreKeyBloomFunctor();

    StringBuilder row = new StringBuilder("foo");
    row.appendCodePoint(1);
    row.appendCodePoint(1);

    // Act
    org.apache.hadoop.util.bloom.Key actualTransformResult = coreKeyBloomFunctor.transform(new Key(row));

    // Assert
    assertEquals(1.0d, actualTransformResult.getWeight());
    assertArrayEquals(new byte[]{'f', 'o', 'o', 1, 1}, actualTransformResult.getBytes());
  }

  /**
   * Test {@link CoreKeyBloomFunctor#transform(Key)} with {@code key}.
   * <ul>
   *   <li>Then return Bytes is empty array of {@code byte}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CoreKeyBloomFunctor#transform(Key)}
   */
  @Test
  @DisplayName("Test transform(Key) with 'key'; then return Bytes is empty array of byte")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"org.apache.hadoop.util.bloom.Key CoreKeyBloomFunctor.transform(Key)"})
  void testTransformWithKey_thenReturnBytesIsEmptyArrayOfByte() {
    // Arrange
    CoreKeyBloomFunctor coreKeyBloomFunctor = new CoreKeyBloomFunctor();

    StringBuilder row = new StringBuilder("");
    row.appendCodePoint(1);

    // Act
    org.apache.hadoop.util.bloom.Key actualTransformResult = coreKeyBloomFunctor.transform(new Key(row));

    // Assert
    assertEquals(1.0d, actualTransformResult.getWeight());
    assertArrayEquals(new byte[]{}, actualTransformResult.getBytes());
  }

  /**
   * Test {@link CoreKeyBloomFunctor#transform(Key)} with {@code key}.
   * <ul>
   *   <li>Then return Bytes is {@code foo} Bytes is {@code UTF-8}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CoreKeyBloomFunctor#transform(Key)}
   */
  @Test
  @DisplayName("Test transform(Key) with 'key'; then return Bytes is 'foo' Bytes is 'UTF-8'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"org.apache.hadoop.util.bloom.Key CoreKeyBloomFunctor.transform(Key)"})
  void testTransformWithKey_thenReturnBytesIsFooBytesIsUtf8() throws UnsupportedEncodingException {
    // Arrange
    CoreKeyBloomFunctor coreKeyBloomFunctor = new CoreKeyBloomFunctor();

    StringBuilder row = new StringBuilder("foo");
    row.appendCodePoint(1);

    // Act
    org.apache.hadoop.util.bloom.Key actualTransformResult = coreKeyBloomFunctor.transform(new Key(row));

    // Assert
    assertEquals(1.0d, actualTransformResult.getWeight());
    byte[] expectedBytes = "foo".getBytes("UTF-8");
    assertArrayEquals(expectedBytes, actualTransformResult.getBytes());
  }

  /**
   * Test {@link CoreKeyBloomFunctor#transform(Range)} with {@code range}.
   * <p>
   * Method under test: {@link CoreKeyBloomFunctor#transform(Range)}
   */
  @Test
  @DisplayName("Test transform(Range) with 'range'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"org.apache.hadoop.util.bloom.Key CoreKeyBloomFunctor.transform(Range)"})
  void testTransformWithRange() throws UnsupportedEncodingException {
    // Arrange
    CoreKeyBloomFunctor coreKeyBloomFunctor = new CoreKeyBloomFunctor();

    // Act
    org.apache.hadoop.util.bloom.Key actualTransformResult = coreKeyBloomFunctor
        .transform(new Range(AccumuloProperties.CLIENT_SIDE_BLOOM_FILTER_SIZE));

    // Assert
    assertEquals(1.0d, actualTransformResult.getWeight());
    byte[] expectedBytes = "accumulo.clientSideBloomFilterSize".getBytes("UTF-8");
    assertArrayEquals(expectedBytes, actualTransformResult.getBytes());
  }

  /**
   * Test {@link CoreKeyBloomFunctor#transform(Range)} with {@code range}.
   * <ul>
   *   <li>Then return Bytes is array of {@code byte} with {@code f} and {@code o}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CoreKeyBloomFunctor#transform(Range)}
   */
  @Test
  @DisplayName("Test transform(Range) with 'range'; then return Bytes is array of byte with 'f' and 'o'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"org.apache.hadoop.util.bloom.Key CoreKeyBloomFunctor.transform(Range)"})
  void testTransformWithRange_thenReturnBytesIsArrayOfByteWithFAndO() {
    // Arrange
    CoreKeyBloomFunctor coreKeyBloomFunctor = new CoreKeyBloomFunctor();

    StringBuilder row = new StringBuilder("foo");
    row.appendCodePoint(1);
    row.appendCodePoint(1);

    // Act
    org.apache.hadoop.util.bloom.Key actualTransformResult = coreKeyBloomFunctor.transform(new Range(row));

    // Assert
    assertEquals(1.0d, actualTransformResult.getWeight());
    assertArrayEquals(new byte[]{'f', 'o', 'o', 1, 1}, actualTransformResult.getBytes());
  }

  /**
   * Test {@link CoreKeyBloomFunctor#transform(Range)} with {@code range}.
   * <ul>
   *   <li>When {@link Range#Range()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CoreKeyBloomFunctor#transform(Range)}
   */
  @Test
  @DisplayName("Test transform(Range) with 'range'; when Range(); then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"org.apache.hadoop.util.bloom.Key CoreKeyBloomFunctor.transform(Range)"})
  void testTransformWithRange_whenRange_thenReturnNull() {
    // Arrange
    CoreKeyBloomFunctor coreKeyBloomFunctor = new CoreKeyBloomFunctor();

    // Act and Assert
    assertNull(coreKeyBloomFunctor.transform(new Range()));
  }

  /**
   * Test {@link CoreKeyBloomFunctor#transform(Range)} with {@code range}.
   * <ul>
   *   <li>When {@link StringBuilder#StringBuilder(String)} with empty string appendCodePoint one.</li>
   * </ul>
   * <p>
   * Method under test: {@link CoreKeyBloomFunctor#transform(Range)}
   */
  @Test
  @DisplayName("Test transform(Range) with 'range'; when StringBuilder(String) with empty string appendCodePoint one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"org.apache.hadoop.util.bloom.Key CoreKeyBloomFunctor.transform(Range)"})
  void testTransformWithRange_whenStringBuilderWithEmptyStringAppendCodePointOne() {
    // Arrange
    CoreKeyBloomFunctor coreKeyBloomFunctor = new CoreKeyBloomFunctor();

    StringBuilder row = new StringBuilder("");
    row.appendCodePoint(1);

    // Act and Assert
    assertNull(coreKeyBloomFunctor.transform(new Range(row)));
  }

  /**
   * Test {@link CoreKeyBloomFunctor#transform(Range)} with {@code range}.
   * <ul>
   *   <li>When {@link StringBuilder#StringBuilder(String)} with {@code foo} appendCodePoint one.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CoreKeyBloomFunctor#transform(Range)}
   */
  @Test
  @DisplayName("Test transform(Range) with 'range'; when StringBuilder(String) with 'foo' appendCodePoint one; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"org.apache.hadoop.util.bloom.Key CoreKeyBloomFunctor.transform(Range)"})
  void testTransformWithRange_whenStringBuilderWithFooAppendCodePointOne_thenReturnNull() {
    // Arrange
    CoreKeyBloomFunctor coreKeyBloomFunctor = new CoreKeyBloomFunctor();

    StringBuilder row = new StringBuilder("foo");
    row.appendCodePoint(1);

    // Act and Assert
    assertNull(coreKeyBloomFunctor.transform(new Range(row)));
  }

  /**
   * Test {@link CoreKeyBloomFunctor#getVertexFromRangeKey(byte[])}.
   * <ul>
   *   <li>Then return empty array of {@code byte}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CoreKeyBloomFunctor#getVertexFromRangeKey(byte[])}
   */
  @Test
  @DisplayName("Test getVertexFromRangeKey(byte[]); then return empty array of byte")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"byte[] CoreKeyBloomFunctor.getVertexFromRangeKey(byte[])"})
  void testGetVertexFromRangeKey_thenReturnEmptyArrayOfByte() {
    // Arrange, Act and Assert
    assertArrayEquals(new byte[]{}, (new CoreKeyBloomFunctor())
        .getVertexFromRangeKey(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}));
  }

  /**
   * Test {@link CoreKeyBloomFunctor#getVertexFromRangeKey(byte[])}.
   * <ul>
   *   <li>When {@code A}.</li>
   *   <li>Then return array of {@code byte} with {@code A} and {@code X}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CoreKeyBloomFunctor#getVertexFromRangeKey(byte[])}
   */
  @Test
  @DisplayName("Test getVertexFromRangeKey(byte[]); when 'A'; then return array of byte with 'A' and 'X'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"byte[] CoreKeyBloomFunctor.getVertexFromRangeKey(byte[])"})
  void testGetVertexFromRangeKey_whenA_thenReturnArrayOfByteWithAAndX() {
    // Arrange, Act and Assert
    assertArrayEquals(new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 1, 1},
        (new CoreKeyBloomFunctor()).getVertexFromRangeKey(new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 1, 1}));
  }

  /**
   * Test {@link CoreKeyBloomFunctor#getVertexFromRangeKey(byte[])}.
   * <ul>
   *   <li>When {@code A}.</li>
   *   <li>Then return {@code AXAXAXA} Bytes is {@code UTF-8}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CoreKeyBloomFunctor#getVertexFromRangeKey(byte[])}
   */
  @Test
  @DisplayName("Test getVertexFromRangeKey(byte[]); when 'A'; then return 'AXAXAXA' Bytes is 'UTF-8'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"byte[] CoreKeyBloomFunctor.getVertexFromRangeKey(byte[])"})
  void testGetVertexFromRangeKey_whenA_thenReturnAxaxaxaBytesIsUtf8() throws UnsupportedEncodingException {
    // Arrange and Act
    byte[] actualVertexFromRangeKey = (new CoreKeyBloomFunctor())
        .getVertexFromRangeKey(new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 1});

    // Assert
    assertArrayEquals("AXAXAXA".getBytes("UTF-8"), actualVertexFromRangeKey);
  }

  /**
   * Test {@link CoreKeyBloomFunctor#getVertexFromRangeKey(byte[])}.
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   *   <li>Then return {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CoreKeyBloomFunctor#getVertexFromRangeKey(byte[])}
   */
  @Test
  @DisplayName("Test getVertexFromRangeKey(byte[]); when 'AXAXAXAX' Bytes is 'UTF-8'; then return 'AXAXAXAX' Bytes is 'UTF-8'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"byte[] CoreKeyBloomFunctor.getVertexFromRangeKey(byte[])"})
  void testGetVertexFromRangeKey_whenAxaxaxaxBytesIsUtf8_thenReturnAxaxaxaxBytesIsUtf8()
      throws UnsupportedEncodingException {
    // Arrange
    CoreKeyBloomFunctor coreKeyBloomFunctor = new CoreKeyBloomFunctor();

    // Act
    byte[] actualVertexFromRangeKey = coreKeyBloomFunctor.getVertexFromRangeKey("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualVertexFromRangeKey);
  }
}
