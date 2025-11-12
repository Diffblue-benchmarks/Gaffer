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
import org.apache.datasketches.hll.HllSketch;
import org.apache.datasketches.hll.TgtHllType;
import org.junit.jupiter.api.Test;

class ToHllSketchDiffblueTest {
  /**
   * Method under test: {@link ToHllSketch#apply(Object)}
   */
  @Test
  void testApply() {
    // Arrange and Act
    HllSketch actualApplyResult = (new ToHllSketch()).apply("42");

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
   * Method under test: {@link ToHllSketch#apply(Object)}
   */
  @Test
  void testApply2() {
    // Arrange and Act
    HllSketch actualApplyResult = (new ToHllSketch()).apply(null);

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
   * Method under test: {@link ToHllSketch#apply(Object)}
   */
  @Test
  void testApply3() {
    // Arrange and Act
    HllSketch actualApplyResult = (new ToHllSketch()).apply("");

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
   * Method under test: {@link ToHllSketch#apply(Object)}
   */
  @Test
  void testApply4() {
    // Arrange and Act
    HllSketch actualApplyResult = (new ToHllSketch()).apply(0.0d);

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
   * Method under test: {@link ToHllSketch#apply(Object)}
   */
  @Test
  void testApply5() {
    // Arrange and Act
    HllSketch actualApplyResult = (new ToHllSketch()).apply(3);

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
   * Method under test: {@link ToHllSketch#apply(Object)}
   */
  @Test
  void testApply6() {
    // Arrange and Act
    HllSketch actualApplyResult = (new ToHllSketch()).apply(1L);

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
   * Method under test: {@link ToHllSketch#apply(Object)}
   */
  @Test
  void testApply7() {
    // Arrange and Act
    HllSketch actualApplyResult = (new ToHllSketch()).apply(10.0d);

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
   * Method under test: {@link ToHllSketch#setHllSketch(HllSketch)}
   */
  @Test
  void testSetHllSketch() {
    // Arrange
    ToHllSketch toHllSketch = new ToHllSketch();

    // Act
    toHllSketch.setHllSketch(new HllSketch());

    // Assert
    assertEquals(12, toHllSketch.getHllSketch().getLgConfigK());
  }

  /**
   * Method under test: {@link ToHllSketch#setHllSketch(HllSketch)}
   */
  @Test
  void testSetHllSketch2() {
    // Arrange
    ToHllSketch toHllSketch = new ToHllSketch();
    toHllSketch.setLogK(7);

    // Act
    toHllSketch.setHllSketch(null);

    // Assert
    assertEquals(7, toHllSketch.getHllSketch().getLgConfigK());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ToHllSketch#setLogK(int)}
   *   <li>{@link ToHllSketch#getHllSketch()}
   *   <li>{@link ToHllSketch#getLogK()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange
    ToHllSketch toHllSketch = new ToHllSketch();

    // Act
    toHllSketch.setLogK(3);
    HllSketch actualHllSketch = toHllSketch.getHllSketch();
    int actualLogK = toHllSketch.getLogK();

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
   * Method under test: {@link ToHllSketch#ToHllSketch()}
   */
  @Test
  void testNewToHllSketch() {
    // Arrange and Act
    ToHllSketch actualToHllSketch = new ToHllSketch();

    // Assert
    HllSketch hllSketch = actualToHllSketch.getHllSketch();
    assertEquals(0.0d, hllSketch.getCompositeEstimate());
    assertEquals(0.0d, hllSketch.getEstimate());
    assertEquals(10, hllSketch.getLgConfigK());
    assertEquals(10, actualToHllSketch.getLogK());
    assertEquals(40, hllSketch.getUpdatableSerializationBytes());
    assertEquals(8, hllSketch.getCompactSerializationBytes());
    assertEquals(TgtHllType.HLL_4, hllSketch.getTgtHllType());
    assertFalse(hllSketch.isCompact());
    assertFalse(hllSketch.isMemory());
    assertFalse(hllSketch.isOffHeap());
    assertTrue(hllSketch.isEmpty());
  }

  /**
   * Method under test: {@link ToHllSketch#ToHllSketch(int)}
   */
  @Test
  void testNewToHllSketch2() {
    // Arrange and Act
    ToHllSketch actualToHllSketch = new ToHllSketch(4);

    // Assert
    HllSketch hllSketch = actualToHllSketch.getHllSketch();
    assertEquals(0.0d, hllSketch.getCompositeEstimate());
    assertEquals(0.0d, hllSketch.getEstimate());
    assertEquals(4, hllSketch.getLgConfigK());
    assertEquals(4, actualToHllSketch.getLogK());
    assertEquals(40, hllSketch.getUpdatableSerializationBytes());
    assertEquals(8, hllSketch.getCompactSerializationBytes());
    assertEquals(TgtHllType.HLL_4, hllSketch.getTgtHllType());
    assertFalse(hllSketch.isCompact());
    assertFalse(hllSketch.isMemory());
    assertFalse(hllSketch.isOffHeap());
    assertTrue(hllSketch.isEmpty());
  }

  /**
   * Method under test: {@link ToHllSketch#ToHllSketch(HllSketch)}
   */
  @Test
  void testNewToHllSketch3() {
    // Arrange and Act
    ToHllSketch actualToHllSketch = new ToHllSketch(new HllSketch());

    // Assert
    HllSketch hllSketch = actualToHllSketch.getHllSketch();
    assertEquals(0.0d, hllSketch.getCompositeEstimate());
    assertEquals(0.0d, hllSketch.getEstimate());
    assertEquals(10, actualToHllSketch.getLogK());
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
   * Method under test: {@link ToHllSketch#ToHllSketch(HllSketch)}
   */
  @Test
  void testNewToHllSketch4() {
    // Arrange and Act
    ToHllSketch actualToHllSketch = new ToHllSketch(null);

    // Assert
    HllSketch hllSketch = actualToHllSketch.getHllSketch();
    assertEquals(0.0d, hllSketch.getCompositeEstimate());
    assertEquals(0.0d, hllSketch.getEstimate());
    assertEquals(10, hllSketch.getLgConfigK());
    assertEquals(10, actualToHllSketch.getLogK());
    assertEquals(40, hllSketch.getUpdatableSerializationBytes());
    assertEquals(8, hllSketch.getCompactSerializationBytes());
    assertEquals(TgtHllType.HLL_4, hllSketch.getTgtHllType());
    assertFalse(hllSketch.isCompact());
    assertFalse(hllSketch.isMemory());
    assertFalse(hllSketch.isOffHeap());
    assertTrue(hllSketch.isEmpty());
  }
}
