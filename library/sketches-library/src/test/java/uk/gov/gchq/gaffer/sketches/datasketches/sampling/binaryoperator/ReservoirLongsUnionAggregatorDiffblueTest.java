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

package uk.gov.gchq.gaffer.sketches.datasketches.sampling.binaryoperator;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import org.apache.datasketches.sampling.ReservoirLongsSketch;
import org.apache.datasketches.sampling.ReservoirLongsUnion;
import org.junit.jupiter.api.Test;

class ReservoirLongsUnionAggregatorDiffblueTest {
  /**
   * Method under test:
   * {@link ReservoirLongsUnionAggregator#_apply(ReservoirLongsUnion, ReservoirLongsUnion)}
   */
  @Test
  void test_apply() {
    // Arrange
    ReservoirLongsUnionAggregator reservoirLongsUnionAggregator = new ReservoirLongsUnionAggregator();
    ReservoirLongsUnion a = ReservoirLongsUnion.newInstance(3);

    // Act
    ReservoirLongsUnion actual_applyResult = reservoirLongsUnionAggregator._apply(a,
        ReservoirLongsUnion.newInstance(3));

    // Assert
    assertNull(a.getResult());
    assertSame(a, actual_applyResult);
  }

  /**
   * Method under test:
   * {@link ReservoirLongsUnionAggregator#_apply(ReservoirLongsUnion, ReservoirLongsUnion)}
   */
  @Test
  void test_apply2() {
    // Arrange
    ReservoirLongsUnionAggregator reservoirLongsUnionAggregator = new ReservoirLongsUnionAggregator();
    ReservoirLongsUnion a = ReservoirLongsUnion.newInstance(3);
    ReservoirLongsUnion b = ReservoirLongsUnion.newInstance(3);
    b.update(1L);

    // Act
    ReservoirLongsUnion actual_applyResult = reservoirLongsUnionAggregator._apply(a, b);

    // Assert
    ReservoirLongsSketch result = a.getResult();
    assertEquals(1, result.getNumSamples());
    assertEquals(1L, result.getN());
    assertEquals(3, result.getK());
    assertSame(a, actual_applyResult);
    assertArrayEquals(new long[]{1L}, result.getSamples());
  }

  /**
   * Method under test:
   * {@link ReservoirLongsUnionAggregator#_apply(ReservoirLongsUnion, ReservoirLongsUnion)}
   */
  @Test
  void test_apply3() {
    // Arrange
    ReservoirLongsUnionAggregator reservoirLongsUnionAggregator = new ReservoirLongsUnionAggregator();
    ReservoirLongsUnion a = ReservoirLongsUnion.newInstance(3);
    a.update(1L);
    ReservoirLongsUnion b = ReservoirLongsUnion.newInstance(3);
    b.update(1L);

    // Act
    ReservoirLongsUnion actual_applyResult = reservoirLongsUnionAggregator._apply(a, b);

    // Assert
    ReservoirLongsSketch result = a.getResult();
    assertEquals(2, result.getNumSamples());
    assertEquals(2L, result.getN());
    assertEquals(3, result.getK());
    assertSame(a, actual_applyResult);
    assertArrayEquals(new long[]{1L, 1L}, result.getSamples());
  }
}
