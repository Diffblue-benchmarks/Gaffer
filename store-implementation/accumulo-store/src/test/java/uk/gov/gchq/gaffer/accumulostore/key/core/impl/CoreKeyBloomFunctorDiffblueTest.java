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
import static org.junit.jupiter.api.Assertions.assertSame;
import java.io.UnsupportedEncodingException;
import org.apache.accumulo.core.data.Range;
import org.apache.hadoop.util.bloom.Key;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.shadow.com.univocity.parsers.common.input.DefaultCharAppender;

class CoreKeyBloomFunctorDiffblueTest {
  /**
   * Method under test:
   * {@link CoreKeyBloomFunctor#transform(org.apache.accumulo.core.data.Key)}
   */
  @Test
  void testTransform() {
    // Arrange
    CoreKeyBloomFunctor coreKeyBloomFunctor = new CoreKeyBloomFunctor();

    // Act
    org.apache.hadoop.util.bloom.Key actualTransformResult = coreKeyBloomFunctor
        .transform(new org.apache.accumulo.core.data.Key(System.lineSeparator()));

    // Assert
    assertEquals(1.0d, actualTransformResult.getWeight());
    assertArrayEquals(new byte[]{'\n'}, actualTransformResult.getBytes());
  }

  /**
   * Method under test:
   * {@link CoreKeyBloomFunctor#transform(org.apache.accumulo.core.data.Key)}
   */
  @Test
  void testTransform2() {
    // Arrange
    CoreKeyBloomFunctor coreKeyBloomFunctor = new CoreKeyBloomFunctor();

    DefaultCharAppender row = new DefaultCharAppender(3, "42", -1);
    row.append(1);

    // Act
    org.apache.hadoop.util.bloom.Key actualTransformResult = coreKeyBloomFunctor
        .transform(new org.apache.accumulo.core.data.Key(row));

    // Assert
    assertEquals(0, actualTransformResult.getBytes().length);
    assertEquals(1.0d, actualTransformResult.getWeight());
  }

  /**
   * Method under test:
   * {@link CoreKeyBloomFunctor#transform(org.apache.accumulo.core.data.Key)}
   */
  @Test
  void testTransform3() {
    // Arrange
    CoreKeyBloomFunctor coreKeyBloomFunctor = new CoreKeyBloomFunctor();

    DefaultCharAppender row = new DefaultCharAppender(3, "42", -1);
    row.appendIgnoringWhitespace('￿');
    row.append(1);

    // Act
    org.apache.hadoop.util.bloom.Key actualTransformResult = coreKeyBloomFunctor
        .transform(new org.apache.accumulo.core.data.Key(row));

    // Assert
    assertEquals(1.0d, actualTransformResult.getWeight());
    assertArrayEquals(new byte[]{-17, -65, -65}, actualTransformResult.getBytes());
  }

  /**
   * Method under test:
   * {@link CoreKeyBloomFunctor#transform(org.apache.accumulo.core.data.Key)}
   */
  @Test
  void testTransform4() {
    // Arrange
    CoreKeyBloomFunctor coreKeyBloomFunctor = new CoreKeyBloomFunctor();

    DefaultCharAppender row = new DefaultCharAppender(3, "42", -1);
    row.append('\u0001');
    row.append(1);

    // Act
    org.apache.hadoop.util.bloom.Key actualTransformResult = coreKeyBloomFunctor
        .transform(new org.apache.accumulo.core.data.Key(row));

    // Assert
    assertEquals(1.0d, actualTransformResult.getWeight());
    assertArrayEquals(new byte[]{1, 1}, actualTransformResult.getBytes());
  }

  /**
   * Method under test:
   * {@link CoreKeyBloomFunctor#transform(org.apache.accumulo.core.data.Key)}
   */
  @Test
  void testTransform5() {
    // Arrange
    CoreKeyBloomFunctor coreKeyBloomFunctor = new CoreKeyBloomFunctor();

    DefaultCharAppender row = new DefaultCharAppender(3, "42", -1);
    row.append(0);

    // Act
    org.apache.hadoop.util.bloom.Key actualTransformResult = coreKeyBloomFunctor
        .transform(new org.apache.accumulo.core.data.Key(row));

    // Assert
    assertEquals(0, actualTransformResult.getBytes().length);
    assertEquals(1.0d, actualTransformResult.getWeight());
  }

  /**
   * Method under test: {@link CoreKeyBloomFunctor#transform(Range)}
   */
  @Test
  void testTransform6() {
    // Arrange
    CoreKeyBloomFunctor coreKeyBloomFunctor = new CoreKeyBloomFunctor();

    // Act and Assert
    assertNull(coreKeyBloomFunctor.transform(new Range()));
  }

  /**
   * Method under test: {@link CoreKeyBloomFunctor#transform(Range)}
   */
  @Test
  void testTransform7() {
    // Arrange
    CoreKeyBloomFunctor coreKeyBloomFunctor = new CoreKeyBloomFunctor();

    // Act
    Key actualTransformResult = coreKeyBloomFunctor.transform(new Range(System.lineSeparator()));

    // Assert
    assertEquals(1.0d, actualTransformResult.getWeight());
    assertArrayEquals(new byte[]{'\n'}, actualTransformResult.getBytes());
  }

  /**
   * Method under test: {@link CoreKeyBloomFunctor#transform(Range)}
   */
  @Test
  void testTransform8() {
    // Arrange
    CoreKeyBloomFunctor coreKeyBloomFunctor = new CoreKeyBloomFunctor();

    DefaultCharAppender row = new DefaultCharAppender(3, "42", -1);
    row.append(1);

    // Act and Assert
    assertNull(coreKeyBloomFunctor.transform(new Range(row)));
  }

  /**
   * Method under test: {@link CoreKeyBloomFunctor#transform(Range)}
   */
  @Test
  void testTransform9() {
    // Arrange
    CoreKeyBloomFunctor coreKeyBloomFunctor = new CoreKeyBloomFunctor();

    DefaultCharAppender row = new DefaultCharAppender(3, "42", -1);
    row.appendIgnoringWhitespace('￿');
    row.append(1);

    // Act and Assert
    assertNull(coreKeyBloomFunctor.transform(new Range(row)));
  }

  /**
   * Method under test: {@link CoreKeyBloomFunctor#transform(Range)}
   */
  @Test
  void testTransform10() {
    // Arrange
    CoreKeyBloomFunctor coreKeyBloomFunctor = new CoreKeyBloomFunctor();

    DefaultCharAppender row = new DefaultCharAppender(3, "42", -1);
    row.append('\u0001');
    row.append(1);

    // Act
    Key actualTransformResult = coreKeyBloomFunctor.transform(new Range(row));

    // Assert
    assertEquals(1.0d, actualTransformResult.getWeight());
    assertArrayEquals(new byte[]{1, 1}, actualTransformResult.getBytes());
  }

  /**
   * Method under test: {@link CoreKeyBloomFunctor#getVertexFromRangeKey(byte[])}
   */
  @Test
  void testGetVertexFromRangeKey() throws UnsupportedEncodingException {
    // Arrange
    CoreKeyBloomFunctor coreKeyBloomFunctor = new CoreKeyBloomFunctor();
    byte[] key = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertSame(key, coreKeyBloomFunctor.getVertexFromRangeKey(key));
  }

  /**
   * Method under test: {@link CoreKeyBloomFunctor#getVertexFromRangeKey(byte[])}
   */
  @Test
  void testGetVertexFromRangeKey2() {
    // Arrange, Act and Assert
    assertEquals(0, (new CoreKeyBloomFunctor())
        .getVertexFromRangeKey(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}).length);
  }

  /**
   * Method under test: {@link CoreKeyBloomFunctor#getVertexFromRangeKey(byte[])}
   */
  @Test
  void testGetVertexFromRangeKey3() throws UnsupportedEncodingException {
    // Arrange and Act
    byte[] actualVertexFromRangeKey = (new CoreKeyBloomFunctor())
        .getVertexFromRangeKey(new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 1});

    // Assert
    assertArrayEquals("AXAXAXA".getBytes("UTF-8"), actualVertexFromRangeKey);
  }

  /**
   * Method under test: {@link CoreKeyBloomFunctor#getVertexFromRangeKey(byte[])}
   */
  @Test
  void testGetVertexFromRangeKey4() {
    // Arrange
    byte[] key = new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 1, 1};

    // Act and Assert
    assertSame(key, (new CoreKeyBloomFunctor()).getVertexFromRangeKey(key));
  }
}
