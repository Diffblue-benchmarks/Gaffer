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
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.apache.datasketches.sampling.ReservoirItemsSketch;
import org.apache.datasketches.sampling.ReservoirItemsUnion;
import org.junit.jupiter.api.Test;

class ReservoirItemsUnionAggregatorDiffblueTest {
  /**
   * Method under test:
   * {@link ReservoirItemsUnionAggregator#_apply(ReservoirItemsUnion, ReservoirItemsUnion)}
   */
  @Test
  void test_apply() {
    // Arrange
    ReservoirItemsUnionAggregator<Object> reservoirItemsUnionAggregator = new ReservoirItemsUnionAggregator<>();
    ReservoirItemsUnion<Object> a = ReservoirItemsUnion.newInstance(3);
    ReservoirItemsUnion<Object> b = ReservoirItemsUnion.newInstance(3);

    // Act
    ReservoirItemsUnion<Object> actual_applyResult = reservoirItemsUnionAggregator._apply(a, b);

    // Assert
    assertNull(a.getResult());
    assertSame(a, actual_applyResult);
  }

  /**
   * Method under test:
   * {@link ReservoirItemsUnionAggregator#_apply(ReservoirItemsUnion, ReservoirItemsUnion)}
   */
  @Test
  void test_apply2() {
    // Arrange
    ReservoirItemsUnionAggregator<Object> reservoirItemsUnionAggregator = new ReservoirItemsUnionAggregator<>();
    ReservoirItemsUnion<Object> a = ReservoirItemsUnion.newInstance(3);
    ReservoirItemsUnion<Object> b = ReservoirItemsUnion.newInstance(3);
    b.update("Datum");

    // Act
    ReservoirItemsUnion<Object> actual_applyResult = reservoirItemsUnionAggregator._apply(a, b);

    // Assert
    ReservoirItemsSketch<Object> result = a.getResult();
    Object[] samples = result.getSamples();
    assertTrue(samples instanceof String[]);
    assertEquals(1, result.getNumSamples());
    assertEquals(1L, result.getN());
    assertEquals(3, result.getK());
    assertSame(a, actual_applyResult);
    assertArrayEquals(new String[]{"Datum"}, samples);
  }

  /**
   * Method under test:
   * {@link ReservoirItemsUnionAggregator#_apply(ReservoirItemsUnion, ReservoirItemsUnion)}
   */
  @Test
  void test_apply3() {
    // Arrange
    ReservoirItemsUnionAggregator<Object> reservoirItemsUnionAggregator = new ReservoirItemsUnionAggregator<>();
    ReservoirItemsUnion<Object> a = ReservoirItemsUnion.newInstance(3);
    a.update("Datum");
    ReservoirItemsUnion<Object> b = ReservoirItemsUnion.newInstance(3);
    b.update("Datum");

    // Act
    ReservoirItemsUnion<Object> actual_applyResult = reservoirItemsUnionAggregator._apply(a, b);

    // Assert
    ReservoirItemsSketch<Object> result = a.getResult();
    Object[] samples = result.getSamples();
    assertTrue(samples instanceof String[]);
    assertEquals(2, result.getNumSamples());
    assertEquals(2L, result.getN());
    assertEquals(3, result.getK());
    assertSame(a, actual_applyResult);
    assertArrayEquals(new String[]{"Datum", "Datum"}, samples);
  }
}
