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

package uk.gov.gchq.gaffer.sketches.datasketches.cardinality.function;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import org.apache.datasketches.hll.HllSketch;
import org.apache.datasketches.hll.TgtHllType;
import org.junit.jupiter.api.Test;

class IterableToHllSketchDiffblueTest {
  /**
   * Method under test: {@link IterableToHllSketch#apply(Iterable)}
   */
  @Test
  void testApply() {
    // Arrange
    IterableToHllSketch iterableToHllSketch = new IterableToHllSketch();

    // Act
    HllSketch actualApplyResult = iterableToHllSketch.apply(new ArrayList<>());

    // Assert
    assertEquals(0.0d, actualApplyResult.getCompositeEstimate());
    assertEquals(0.0d, actualApplyResult.getEstimate());
    assertEquals(10, actualApplyResult.getLgConfigK());
    assertEquals(40, actualApplyResult.getUpdatableSerializationBytes());
    assertEquals(8, actualApplyResult.getCompactSerializationBytes());
    assertEquals(TgtHllType.HLL_4, actualApplyResult.getTgtHllType());
    assertFalse(actualApplyResult.isCompact());
    assertFalse(actualApplyResult.isMemory());
    assertFalse(actualApplyResult.isOffHeap());
    assertTrue(actualApplyResult.isEmpty());
  }

  /**
   * Method under test: {@link IterableToHllSketch#apply(Iterable)}
   */
  @Test
  void testApply2() {
    // Arrange
    IterableToHllSketch iterableToHllSketch = new IterableToHllSketch();

    LinkedHashSet<Object> iterable = new LinkedHashSet<>();
    iterable.add(null);

    // Act
    HllSketch actualApplyResult = iterableToHllSketch.apply(iterable);

    // Assert
    assertEquals(0.0d, actualApplyResult.getCompositeEstimate());
    assertEquals(0.0d, actualApplyResult.getEstimate());
    assertEquals(10, actualApplyResult.getLgConfigK());
    assertEquals(40, actualApplyResult.getUpdatableSerializationBytes());
    assertEquals(8, actualApplyResult.getCompactSerializationBytes());
    assertEquals(TgtHllType.HLL_4, actualApplyResult.getTgtHllType());
    assertFalse(actualApplyResult.isCompact());
    assertFalse(actualApplyResult.isMemory());
    assertFalse(actualApplyResult.isOffHeap());
    assertTrue(actualApplyResult.isEmpty());
  }

  /**
   * Method under test: {@link IterableToHllSketch#apply(Iterable)}
   */
  @Test
  void testApply3() {
    // Arrange
    IterableToHllSketch iterableToHllSketch = new IterableToHllSketch();

    LinkedHashSet<Object> iterable = new LinkedHashSet<>();
    iterable.add("");

    // Act
    HllSketch actualApplyResult = iterableToHllSketch.apply(iterable);

    // Assert
    assertEquals(0.0d, actualApplyResult.getCompositeEstimate());
    assertEquals(0.0d, actualApplyResult.getEstimate());
    assertEquals(10, actualApplyResult.getLgConfigK());
    assertEquals(40, actualApplyResult.getUpdatableSerializationBytes());
    assertEquals(8, actualApplyResult.getCompactSerializationBytes());
    assertEquals(TgtHllType.HLL_4, actualApplyResult.getTgtHllType());
    assertFalse(actualApplyResult.isCompact());
    assertFalse(actualApplyResult.isMemory());
    assertFalse(actualApplyResult.isOffHeap());
    assertTrue(actualApplyResult.isEmpty());
  }

  /**
   * Method under test: {@link IterableToHllSketch#apply(Iterable)}
   */
  @Test
  void testApply4() {
    // Arrange
    IterableToHllSketch iterableToHllSketch = new IterableToHllSketch();

    LinkedHashSet<Object> iterable = new LinkedHashSet<>();
    iterable.add(0.0d);

    // Act
    HllSketch actualApplyResult = iterableToHllSketch.apply(iterable);

    // Assert
    assertEquals(1.0d, actualApplyResult.getCompositeEstimate());
    assertEquals(1.0d, actualApplyResult.getEstimate());
    assertEquals(10, actualApplyResult.getLgConfigK());
    assertEquals(12, actualApplyResult.getCompactSerializationBytes());
    assertEquals(40, actualApplyResult.getUpdatableSerializationBytes());
    assertEquals(TgtHllType.HLL_4, actualApplyResult.getTgtHllType());
    assertFalse(actualApplyResult.isCompact());
    assertFalse(actualApplyResult.isEmpty());
    assertFalse(actualApplyResult.isMemory());
    assertFalse(actualApplyResult.isOffHeap());
  }

  /**
   * Method under test: {@link IterableToHllSketch#apply(Iterable)}
   */
  @Test
  void testApply5() {
    // Arrange
    IterableToHllSketch iterableToHllSketch = new IterableToHllSketch();

    LinkedHashSet<Object> iterable = new LinkedHashSet<>();
    iterable.add("Iterable");

    // Act
    HllSketch actualApplyResult = iterableToHllSketch.apply(iterable);

    // Assert
    assertEquals(1.0d, actualApplyResult.getCompositeEstimate());
    assertEquals(1.0d, actualApplyResult.getEstimate());
    assertEquals(10, actualApplyResult.getLgConfigK());
    assertEquals(12, actualApplyResult.getCompactSerializationBytes());
    assertEquals(40, actualApplyResult.getUpdatableSerializationBytes());
    assertEquals(TgtHllType.HLL_4, actualApplyResult.getTgtHllType());
    assertFalse(actualApplyResult.isCompact());
    assertFalse(actualApplyResult.isEmpty());
    assertFalse(actualApplyResult.isMemory());
    assertFalse(actualApplyResult.isOffHeap());
  }

  /**
   * Method under test: {@link IterableToHllSketch#apply(Iterable)}
   */
  @Test
  void testApply6() {
    // Arrange
    IterableToHllSketch iterableToHllSketch = new IterableToHllSketch();

    ArrayList<Object> iterable = new ArrayList<>();
    iterable.add(2);

    // Act
    HllSketch actualApplyResult = iterableToHllSketch.apply(iterable);

    // Assert
    assertEquals(1.0d, actualApplyResult.getCompositeEstimate());
    assertEquals(1.0d, actualApplyResult.getEstimate());
    assertEquals(10, actualApplyResult.getLgConfigK());
    assertEquals(12, actualApplyResult.getCompactSerializationBytes());
    assertEquals(40, actualApplyResult.getUpdatableSerializationBytes());
    assertEquals(TgtHllType.HLL_4, actualApplyResult.getTgtHllType());
    assertFalse(actualApplyResult.isCompact());
    assertFalse(actualApplyResult.isEmpty());
    assertFalse(actualApplyResult.isMemory());
    assertFalse(actualApplyResult.isOffHeap());
  }

  /**
   * Method under test: {@link IterableToHllSketch#apply(Iterable)}
   */
  @Test
  void testApply7() {
    // Arrange
    IterableToHllSketch iterableToHllSketch = new IterableToHllSketch();

    LinkedHashSet<Object> iterable = new LinkedHashSet<>();
    iterable.add(1L);

    // Act
    HllSketch actualApplyResult = iterableToHllSketch.apply(iterable);

    // Assert
    assertEquals(1.0d, actualApplyResult.getCompositeEstimate());
    assertEquals(1.0d, actualApplyResult.getEstimate());
    assertEquals(10, actualApplyResult.getLgConfigK());
    assertEquals(12, actualApplyResult.getCompactSerializationBytes());
    assertEquals(40, actualApplyResult.getUpdatableSerializationBytes());
    assertEquals(TgtHllType.HLL_4, actualApplyResult.getTgtHllType());
    assertFalse(actualApplyResult.isCompact());
    assertFalse(actualApplyResult.isEmpty());
    assertFalse(actualApplyResult.isMemory());
    assertFalse(actualApplyResult.isOffHeap());
  }

  /**
   * Method under test: {@link IterableToHllSketch#apply(Iterable)}
   */
  @Test
  void testApply8() {
    // Arrange
    IterableToHllSketch iterableToHllSketch = new IterableToHllSketch();

    LinkedHashSet<Object> iterable = new LinkedHashSet<>();
    iterable.add(10.0d);

    // Act
    HllSketch actualApplyResult = iterableToHllSketch.apply(iterable);

    // Assert
    assertEquals(1.0d, actualApplyResult.getCompositeEstimate());
    assertEquals(1.0d, actualApplyResult.getEstimate());
    assertEquals(10, actualApplyResult.getLgConfigK());
    assertEquals(12, actualApplyResult.getCompactSerializationBytes());
    assertEquals(40, actualApplyResult.getUpdatableSerializationBytes());
    assertEquals(TgtHllType.HLL_4, actualApplyResult.getTgtHllType());
    assertFalse(actualApplyResult.isCompact());
    assertFalse(actualApplyResult.isEmpty());
    assertFalse(actualApplyResult.isMemory());
    assertFalse(actualApplyResult.isOffHeap());
  }

  /**
   * Method under test: {@link IterableToHllSketch#setHllSketch(HllSketch)}
   */
  @Test
  void testSetHllSketch() {
    // Arrange
    IterableToHllSketch iterableToHllSketch = new IterableToHllSketch();

    // Act
    iterableToHllSketch.setHllSketch(new HllSketch());

    // Assert
    assertEquals(12, iterableToHllSketch.getHllSketch().getLgConfigK());
  }

  /**
   * Method under test: {@link IterableToHllSketch#setHllSketch(HllSketch)}
   */
  @Test
  void testSetHllSketch2() {
    // Arrange
    IterableToHllSketch iterableToHllSketch = new IterableToHllSketch();
    iterableToHllSketch.setLogK(4);

    // Act
    iterableToHllSketch.setHllSketch(null);

    // Assert
    assertEquals(4, iterableToHllSketch.getHllSketch().getLgConfigK());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link IterableToHllSketch#setLogK(int)}
   *   <li>{@link IterableToHllSketch#getHllSketch()}
   *   <li>{@link IterableToHllSketch#getLogK()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange
    IterableToHllSketch iterableToHllSketch = new IterableToHllSketch();

    // Act
    iterableToHllSketch.setLogK(3);
    HllSketch actualHllSketch = iterableToHllSketch.getHllSketch();
    int actualLogK = iterableToHllSketch.getLogK();

    // Assert that nothing has changed
    assertEquals(0.0d, actualHllSketch.getCompositeEstimate());
    assertEquals(0.0d, actualHllSketch.getEstimate());
    assertEquals(10, actualHllSketch.getLgConfigK());
    assertEquals(3, actualLogK);
    assertEquals(40, actualHllSketch.getUpdatableSerializationBytes());
    assertEquals(8, actualHllSketch.getCompactSerializationBytes());
    assertEquals(TgtHllType.HLL_4, actualHllSketch.getTgtHllType());
    assertFalse(actualHllSketch.isCompact());
    assertFalse(actualHllSketch.isMemory());
    assertFalse(actualHllSketch.isOffHeap());
    assertTrue(actualHllSketch.isEmpty());
  }

  /**
   * Method under test: {@link IterableToHllSketch#IterableToHllSketch()}
   */
  @Test
  void testNewIterableToHllSketch() {
    // Arrange and Act
    IterableToHllSketch actualIterableToHllSketch = new IterableToHllSketch();

    // Assert
    HllSketch hllSketch = actualIterableToHllSketch.getHllSketch();
    assertEquals(0.0d, hllSketch.getCompositeEstimate());
    assertEquals(0.0d, hllSketch.getEstimate());
    assertEquals(10, hllSketch.getLgConfigK());
    assertEquals(10, actualIterableToHllSketch.getLogK());
    assertEquals(40, hllSketch.getUpdatableSerializationBytes());
    assertEquals(8, hllSketch.getCompactSerializationBytes());
    assertEquals(TgtHllType.HLL_4, hllSketch.getTgtHllType());
    assertFalse(hllSketch.isCompact());
    assertFalse(hllSketch.isMemory());
    assertFalse(hllSketch.isOffHeap());
    assertTrue(hllSketch.isEmpty());
  }

  /**
   * Method under test: {@link IterableToHllSketch#IterableToHllSketch(int)}
   */
  @Test
  void testNewIterableToHllSketch2() {
    // Arrange and Act
    IterableToHllSketch actualIterableToHllSketch = new IterableToHllSketch(7);

    // Assert
    HllSketch hllSketch = actualIterableToHllSketch.getHllSketch();
    assertEquals(0.0d, hllSketch.getCompositeEstimate());
    assertEquals(0.0d, hllSketch.getEstimate());
    assertEquals(40, hllSketch.getUpdatableSerializationBytes());
    assertEquals(7, hllSketch.getLgConfigK());
    assertEquals(7, actualIterableToHllSketch.getLogK());
    assertEquals(8, hllSketch.getCompactSerializationBytes());
    assertEquals(TgtHllType.HLL_4, hllSketch.getTgtHllType());
    assertFalse(hllSketch.isCompact());
    assertFalse(hllSketch.isMemory());
    assertFalse(hllSketch.isOffHeap());
    assertTrue(hllSketch.isEmpty());
  }

  /**
   * Method under test: {@link IterableToHllSketch#IterableToHllSketch(HllSketch)}
   */
  @Test
  void testNewIterableToHllSketch3() {
    // Arrange and Act
    IterableToHllSketch actualIterableToHllSketch = new IterableToHllSketch(new HllSketch());

    // Assert
    HllSketch hllSketch = actualIterableToHllSketch.getHllSketch();
    assertEquals(0.0d, hllSketch.getCompositeEstimate());
    assertEquals(0.0d, hllSketch.getEstimate());
    assertEquals(10, actualIterableToHllSketch.getLogK());
    assertEquals(12, hllSketch.getLgConfigK());
    assertEquals(40, hllSketch.getUpdatableSerializationBytes());
    assertEquals(8, hllSketch.getCompactSerializationBytes());
    assertEquals(TgtHllType.HLL_4, hllSketch.getTgtHllType());
    assertFalse(hllSketch.isCompact());
    assertFalse(hllSketch.isMemory());
    assertFalse(hllSketch.isOffHeap());
    assertTrue(hllSketch.isEmpty());
  }

  /**
   * Method under test: {@link IterableToHllSketch#IterableToHllSketch(HllSketch)}
   */
  @Test
  void testNewIterableToHllSketch4() {
    // Arrange and Act
    IterableToHllSketch actualIterableToHllSketch = new IterableToHllSketch(null);

    // Assert
    HllSketch hllSketch = actualIterableToHllSketch.getHllSketch();
    assertEquals(0.0d, hllSketch.getCompositeEstimate());
    assertEquals(0.0d, hllSketch.getEstimate());
    assertEquals(10, hllSketch.getLgConfigK());
    assertEquals(10, actualIterableToHllSketch.getLogK());
    assertEquals(40, hllSketch.getUpdatableSerializationBytes());
    assertEquals(8, hllSketch.getCompactSerializationBytes());
    assertEquals(TgtHllType.HLL_4, hllSketch.getTgtHllType());
    assertFalse(hllSketch.isCompact());
    assertFalse(hllSketch.isMemory());
    assertFalse(hllSketch.isOffHeap());
    assertTrue(hllSketch.isEmpty());
  }
}
