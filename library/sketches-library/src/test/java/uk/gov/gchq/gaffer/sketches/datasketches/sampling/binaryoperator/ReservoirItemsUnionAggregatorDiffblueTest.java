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
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.apache.datasketches.sampling.ReservoirItemsSketch;
import org.apache.datasketches.sampling.ReservoirItemsUnion;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ReservoirItemsUnionAggregatorDiffblueTest {
  /**
   * Test {@link ReservoirItemsUnionAggregator#_apply(ReservoirItemsUnion, ReservoirItemsUnion)} with {@code ReservoirItemsUnion}, {@code ReservoirItemsUnion}.
   * <p>
   * Method under test: {@link ReservoirItemsUnionAggregator#_apply(ReservoirItemsUnion, ReservoirItemsUnion)}
   */
  @Test
  @DisplayName("Test _apply(ReservoirItemsUnion, ReservoirItemsUnion) with 'ReservoirItemsUnion', 'ReservoirItemsUnion'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "ReservoirItemsUnion ReservoirItemsUnionAggregator._apply(ReservoirItemsUnion, ReservoirItemsUnion)"})
  void test_applyWithReservoirItemsUnionReservoirItemsUnion() {
    // Arrange
    ReservoirItemsUnionAggregator<Object> reservoirItemsUnionAggregator = new ReservoirItemsUnionAggregator<>();
    ReservoirItemsUnion<Object> a = ReservoirItemsUnion.newInstance(3);
    ReservoirItemsUnion<Object> b = ReservoirItemsUnion.newInstance(3);
    b.update("Datum");

    // Act
    reservoirItemsUnionAggregator._apply(a, b);

    // Assert
    ReservoirItemsSketch<Object> result = a.getResult();
    Object[] samples = result.getSamples();
    assertTrue(samples instanceof String[]);
    assertEquals(1, result.getNumSamples());
    assertEquals(1L, result.getN());
    assertEquals(3, result.getK());
    assertArrayEquals(new String[]{"Datum"}, samples);
  }

  /**
   * Test {@link ReservoirItemsUnionAggregator#_apply(ReservoirItemsUnion, ReservoirItemsUnion)} with {@code ReservoirItemsUnion}, {@code ReservoirItemsUnion}.
   * <ul>
   *   <li>Then return newInstance three.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReservoirItemsUnionAggregator#_apply(ReservoirItemsUnion, ReservoirItemsUnion)}
   */
  @Test
  @DisplayName("Test _apply(ReservoirItemsUnion, ReservoirItemsUnion) with 'ReservoirItemsUnion', 'ReservoirItemsUnion'; then return newInstance three")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "ReservoirItemsUnion ReservoirItemsUnionAggregator._apply(ReservoirItemsUnion, ReservoirItemsUnion)"})
  void test_applyWithReservoirItemsUnionReservoirItemsUnion_thenReturnNewInstanceThree() {
    // Arrange
    ReservoirItemsUnionAggregator<Object> reservoirItemsUnionAggregator = new ReservoirItemsUnionAggregator<>();
    ReservoirItemsUnion<Object> a = ReservoirItemsUnion.newInstance(3);
    ReservoirItemsUnion<Object> b = ReservoirItemsUnion.newInstance(3);

    // Act and Assert
    assertSame(a, reservoirItemsUnionAggregator._apply(a, b));
  }
}
