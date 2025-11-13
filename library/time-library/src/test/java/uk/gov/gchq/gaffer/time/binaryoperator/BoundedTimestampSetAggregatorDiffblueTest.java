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

package uk.gov.gchq.gaffer.time.binaryoperator;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.time.LocalDate;
import java.time.ZoneOffset;
import org.apache.datasketches.sampling.ReservoirLongsSketch;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.roaringbitmap.RoaringBitmap;
import uk.gov.gchq.gaffer.time.BoundedTimestampSet;
import uk.gov.gchq.gaffer.time.BoundedTimestampSet.Builder;
import uk.gov.gchq.gaffer.time.BoundedTimestampSet.State;
import uk.gov.gchq.gaffer.time.CommonTimeUtil;
import uk.gov.gchq.gaffer.time.CommonTimeUtil.TimeBucket;
import uk.gov.gchq.gaffer.time.RBMBackedTimestampSet;

class BoundedTimestampSetAggregatorDiffblueTest {
  /**
   * Test {@link BoundedTimestampSetAggregator#_apply(BoundedTimestampSet, BoundedTimestampSet)} with {@code BoundedTimestampSet}, {@code BoundedTimestampSet}.
   * <p>
   * Method under test: {@link BoundedTimestampSetAggregator#_apply(BoundedTimestampSet, BoundedTimestampSet)}
   */
  @Test
  @DisplayName("Test _apply(BoundedTimestampSet, BoundedTimestampSet) with 'BoundedTimestampSet', 'BoundedTimestampSet'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "BoundedTimestampSet BoundedTimestampSetAggregator._apply(BoundedTimestampSet, BoundedTimestampSet)"})
  void test_applyWithBoundedTimestampSetBoundedTimestampSet() {
    // Arrange
    BoundedTimestampSetAggregator boundedTimestampSetAggregator = new BoundedTimestampSetAggregator();
    BoundedTimestampSet a = new BoundedTimestampSet(TimeBucket.MINUTE, 3);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> boundedTimestampSetAggregator._apply(a, new BoundedTimestampSet(TimeBucket.SECOND, 3)));
  }

  /**
   * Test {@link BoundedTimestampSetAggregator#_apply(BoundedTimestampSet, BoundedTimestampSet)} with {@code BoundedTimestampSet}, {@code BoundedTimestampSet}.
   * <p>
   * Method under test: {@link BoundedTimestampSetAggregator#_apply(BoundedTimestampSet, BoundedTimestampSet)}
   */
  @Test
  @DisplayName("Test _apply(BoundedTimestampSet, BoundedTimestampSet) with 'BoundedTimestampSet', 'BoundedTimestampSet'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "BoundedTimestampSet BoundedTimestampSetAggregator._apply(BoundedTimestampSet, BoundedTimestampSet)"})
  void test_applyWithBoundedTimestampSetBoundedTimestampSet2() {
    // Arrange
    BoundedTimestampSetAggregator boundedTimestampSetAggregator = new BoundedTimestampSetAggregator();
    BoundedTimestampSet a = new BoundedTimestampSet(TimeBucket.SECOND, 1);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> boundedTimestampSetAggregator._apply(a, new BoundedTimestampSet(TimeBucket.SECOND, 3)));
  }

  /**
   * Test {@link BoundedTimestampSetAggregator#_apply(BoundedTimestampSet, BoundedTimestampSet)} with {@code BoundedTimestampSet}, {@code BoundedTimestampSet}.
   * <p>
   * Method under test: {@link BoundedTimestampSetAggregator#_apply(BoundedTimestampSet, BoundedTimestampSet)}
   */
  @Test
  @DisplayName("Test _apply(BoundedTimestampSet, BoundedTimestampSet) with 'BoundedTimestampSet', 'BoundedTimestampSet'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "BoundedTimestampSet BoundedTimestampSetAggregator._apply(BoundedTimestampSet, BoundedTimestampSet)"})
  void test_applyWithBoundedTimestampSetBoundedTimestampSet3() {
    // Arrange
    BoundedTimestampSetAggregator boundedTimestampSetAggregator = new BoundedTimestampSetAggregator();
    BoundedTimestampSet a = (new Builder()).maxSize(3).state(State.SAMPLE).timeBucket(TimeBucket.SECOND).build();

    // Act and Assert
    assertSame(a, boundedTimestampSetAggregator._apply(a, new BoundedTimestampSet(TimeBucket.SECOND, 3)));
  }

  /**
   * Test {@link BoundedTimestampSetAggregator#_apply(BoundedTimestampSet, BoundedTimestampSet)} with {@code BoundedTimestampSet}, {@code BoundedTimestampSet}.
   * <p>
   * Method under test: {@link BoundedTimestampSetAggregator#_apply(BoundedTimestampSet, BoundedTimestampSet)}
   */
  @Test
  @DisplayName("Test _apply(BoundedTimestampSet, BoundedTimestampSet) with 'BoundedTimestampSet', 'BoundedTimestampSet'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "BoundedTimestampSet BoundedTimestampSetAggregator._apply(BoundedTimestampSet, BoundedTimestampSet)"})
  void test_applyWithBoundedTimestampSetBoundedTimestampSet4() {
    // Arrange
    BoundedTimestampSetAggregator boundedTimestampSetAggregator = new BoundedTimestampSetAggregator();
    BoundedTimestampSet a = (new Builder()).maxSize(3).state(State.SAMPLE).timeBucket(TimeBucket.SECOND).build();

    BoundedTimestampSet b = new BoundedTimestampSet(TimeBucket.SECOND, 3);
    b.add(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Act and Assert
    ReservoirLongsSketch result = boundedTimestampSetAggregator._apply(a, b).getReservoirLongsUnion().getResult();
    assertEquals(1, result.getNumSamples());
    assertEquals(1L, result.getN());
    assertEquals(3, result.getK());
    assertArrayEquals(new long[]{0L}, result.getSamples());
  }

  /**
   * Test {@link BoundedTimestampSetAggregator#_apply(BoundedTimestampSet, BoundedTimestampSet)} with {@code BoundedTimestampSet}, {@code BoundedTimestampSet}.
   * <ul>
   *   <li>Then return Earliest is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BoundedTimestampSetAggregator#_apply(BoundedTimestampSet, BoundedTimestampSet)}
   */
  @Test
  @DisplayName("Test _apply(BoundedTimestampSet, BoundedTimestampSet) with 'BoundedTimestampSet', 'BoundedTimestampSet'; then return Earliest is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "BoundedTimestampSet BoundedTimestampSetAggregator._apply(BoundedTimestampSet, BoundedTimestampSet)"})
  void test_applyWithBoundedTimestampSetBoundedTimestampSet_thenReturnEarliestIsNull() {
    // Arrange
    BoundedTimestampSetAggregator boundedTimestampSetAggregator = new BoundedTimestampSetAggregator();
    BoundedTimestampSet a = new BoundedTimestampSet(TimeBucket.SECOND, 3);

    // Act
    BoundedTimestampSet actual_applyResult = boundedTimestampSetAggregator._apply(a,
        new BoundedTimestampSet(TimeBucket.SECOND, 3));

    // Assert
    assertNull(actual_applyResult.getEarliest());
    assertNull(actual_applyResult.getLatest());
    RBMBackedTimestampSet rbmBackedTimestampSet = actual_applyResult.getRbmBackedTimestampSet();
    assertNull(rbmBackedTimestampSet.getEarliest());
    RBMBackedTimestampSet shallowClone = rbmBackedTimestampSet.getShallowClone();
    assertNull(shallowClone.getEarliest());
    assertNull(rbmBackedTimestampSet.getLatest());
    assertNull(shallowClone.getLatest());
    RoaringBitmap rbm = rbmBackedTimestampSet.getRbm();
    assertEquals(0, rbm.getCardinality());
    assertEquals(0L, actual_applyResult.getNumberOfTimestamps());
    assertEquals(0L, rbmBackedTimestampSet.getNumberOfTimestamps());
    assertEquals(0L, shallowClone.getNumberOfTimestamps());
    assertEquals(8, rbm.getSizeInBytes());
    assertFalse(rbm.iterator().hasNext());
    assertTrue(actual_applyResult.getTimestamps().isEmpty());
    assertTrue(rbm.isEmpty());
  }
}
