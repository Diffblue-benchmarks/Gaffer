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

package uk.gov.gchq.gaffer.sketches.datasketches.cardinality.serialisation.json;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import org.apache.datasketches.hll.HllSketch;
import org.apache.datasketches.hll.TgtHllType;
import org.junit.jupiter.api.Test;

class HllSketchWithValuesDiffblueTest {
  /**
   * Method under test: {@link HllSketchWithValues#getHllSketch()}
   */
  @Test
  void testGetHllSketch() throws IOException {
    // Arrange and Act
    HllSketch actualHllSketch = (new HllSketchWithValues()).getHllSketch();

    // Assert
    assertEquals(0.0d, actualHllSketch.getCompositeEstimate());
    assertEquals(0.0d, actualHllSketch.getEstimate());
    assertEquals(40, actualHllSketch.getUpdatableSerializationBytes());
    assertEquals(8, actualHllSketch.getCompactSerializationBytes());
    assertEquals(TgtHllType.HLL_4, actualHllSketch.getTgtHllType());
    assertFalse(actualHllSketch.isCompact());
    assertFalse(actualHllSketch.isMemory());
    assertFalse(actualHllSketch.isOffHeap());
    assertTrue(actualHllSketch.isEmpty());
    assertEquals(HllSketchJsonConstants.DEFAULT_LOG_K, actualHllSketch.getLgConfigK());
  }

  /**
   * Method under test: {@link HllSketchWithValues#getHllSketch()}
   */
  @Test
  void testGetHllSketch2() throws IOException {
    // Arrange
    ArrayList<Object> values = new ArrayList<>();
    values.add(null);

    HllSketchWithValues hllSketchWithValues = new HllSketchWithValues();
    hllSketchWithValues.setBytes(null);
    hllSketchWithValues.setValues(values);
    hllSketchWithValues.setLogK(4);

    // Act
    HllSketch actualHllSketch = hllSketchWithValues.getHllSketch();

    // Assert
    assertEquals(0.0d, actualHllSketch.getCompositeEstimate());
    assertEquals(0.0d, actualHllSketch.getEstimate());
    assertEquals(4, actualHllSketch.getLgConfigK());
    assertEquals(40, actualHllSketch.getUpdatableSerializationBytes());
    assertEquals(8, actualHllSketch.getCompactSerializationBytes());
    assertEquals(TgtHllType.HLL_4, actualHllSketch.getTgtHllType());
    assertFalse(actualHllSketch.isCompact());
    assertFalse(actualHllSketch.isMemory());
    assertFalse(actualHllSketch.isOffHeap());
    assertTrue(actualHllSketch.isEmpty());
  }

  /**
   * Method under test: {@link HllSketchWithValues#getHllSketch()}
   */
  @Test
  void testGetHllSketch3() throws IOException {
    // Arrange
    ArrayList<Object> values = new ArrayList<>();
    values.add("");

    HllSketchWithValues hllSketchWithValues = new HllSketchWithValues();
    hllSketchWithValues.setBytes(null);
    hllSketchWithValues.setValues(values);
    hllSketchWithValues.setLogK(4);

    // Act
    HllSketch actualHllSketch = hllSketchWithValues.getHllSketch();

    // Assert
    assertEquals(0.0d, actualHllSketch.getCompositeEstimate());
    assertEquals(0.0d, actualHllSketch.getEstimate());
    assertEquals(4, actualHllSketch.getLgConfigK());
    assertEquals(40, actualHllSketch.getUpdatableSerializationBytes());
    assertEquals(8, actualHllSketch.getCompactSerializationBytes());
    assertEquals(TgtHllType.HLL_4, actualHllSketch.getTgtHllType());
    assertFalse(actualHllSketch.isCompact());
    assertFalse(actualHllSketch.isMemory());
    assertFalse(actualHllSketch.isOffHeap());
    assertTrue(actualHllSketch.isEmpty());
  }

  /**
   * Method under test: {@link HllSketchWithValues#getHllSketch()}
   */
  @Test
  void testGetHllSketch4() throws IOException {
    // Arrange
    ArrayList<Object> values = new ArrayList<>();
    values.add(0.0d);

    HllSketchWithValues hllSketchWithValues = new HllSketchWithValues();
    hllSketchWithValues.setBytes(null);
    hllSketchWithValues.setValues(values);
    hllSketchWithValues.setLogK(4);

    // Act
    HllSketch actualHllSketch = hllSketchWithValues.getHllSketch();

    // Assert
    assertEquals(1.0d, actualHllSketch.getCompositeEstimate());
    assertEquals(1.0d, actualHllSketch.getEstimate());
    assertEquals(12, actualHllSketch.getCompactSerializationBytes());
    assertEquals(4, actualHllSketch.getLgConfigK());
    assertEquals(40, actualHllSketch.getUpdatableSerializationBytes());
    assertEquals(TgtHllType.HLL_4, actualHllSketch.getTgtHllType());
    assertFalse(actualHllSketch.isCompact());
    assertFalse(actualHllSketch.isEmpty());
    assertFalse(actualHllSketch.isMemory());
    assertFalse(actualHllSketch.isOffHeap());
  }

  /**
   * Method under test: {@link HllSketchWithValues#getHllSketch()}
   */
  @Test
  void testGetHllSketch5() throws IOException {
    // Arrange
    ArrayList<Object> values = new ArrayList<>();
    values.add("42");

    HllSketchWithValues hllSketchWithValues = new HllSketchWithValues();
    hllSketchWithValues.setBytes(null);
    hllSketchWithValues.setValues(values);
    hllSketchWithValues.setLogK(4);

    // Act
    HllSketch actualHllSketch = hllSketchWithValues.getHllSketch();

    // Assert
    assertEquals(1.0d, actualHllSketch.getCompositeEstimate());
    assertEquals(1.0d, actualHllSketch.getEstimate());
    assertEquals(12, actualHllSketch.getCompactSerializationBytes());
    assertEquals(4, actualHllSketch.getLgConfigK());
    assertEquals(40, actualHllSketch.getUpdatableSerializationBytes());
    assertEquals(TgtHllType.HLL_4, actualHllSketch.getTgtHllType());
    assertFalse(actualHllSketch.isCompact());
    assertFalse(actualHllSketch.isEmpty());
    assertFalse(actualHllSketch.isMemory());
    assertFalse(actualHllSketch.isOffHeap());
  }

  /**
   * Method under test: {@link HllSketchWithValues#getHllSketch()}
   */
  @Test
  void testGetHllSketch6() throws IOException {
    // Arrange
    ArrayList<Object> values = new ArrayList<>();
    values.add(2);
    values.add(null);

    HllSketchWithValues hllSketchWithValues = new HllSketchWithValues();
    hllSketchWithValues.setBytes(null);
    hllSketchWithValues.setValues(values);
    hllSketchWithValues.setLogK(4);

    // Act
    HllSketch actualHllSketch = hllSketchWithValues.getHllSketch();

    // Assert
    assertEquals(1.0d, actualHllSketch.getCompositeEstimate());
    assertEquals(1.0d, actualHllSketch.getEstimate());
    assertEquals(12, actualHllSketch.getCompactSerializationBytes());
    assertEquals(4, actualHllSketch.getLgConfigK());
    assertEquals(40, actualHllSketch.getUpdatableSerializationBytes());
    assertEquals(TgtHllType.HLL_4, actualHllSketch.getTgtHllType());
    assertFalse(actualHllSketch.isCompact());
    assertFalse(actualHllSketch.isEmpty());
    assertFalse(actualHllSketch.isMemory());
    assertFalse(actualHllSketch.isOffHeap());
  }

  /**
   * Method under test: {@link HllSketchWithValues#getHllSketch()}
   */
  @Test
  void testGetHllSketch7() throws IOException {
    // Arrange
    ArrayList<Object> values = new ArrayList<>();
    values.add(2);
    values.add(10L);

    HllSketchWithValues hllSketchWithValues = new HllSketchWithValues();
    hllSketchWithValues.setBytes(null);
    hllSketchWithValues.setValues(values);
    hllSketchWithValues.setLogK(4);

    // Act
    HllSketch actualHllSketch = hllSketchWithValues.getHllSketch();

    // Assert
    assertEquals(2.000000004967054d, actualHllSketch.getCompositeEstimate());
    assertEquals(2.000000004967054d, actualHllSketch.getEstimate());
    assertEquals(4, actualHllSketch.getLgConfigK());
    assertEquals(40, actualHllSketch.getUpdatableSerializationBytes());
    assertEquals(TgtHllType.HLL_4, actualHllSketch.getTgtHllType());
    assertFalse(actualHllSketch.isCompact());
    assertFalse(actualHllSketch.isEmpty());
    assertFalse(actualHllSketch.isMemory());
    assertFalse(actualHllSketch.isOffHeap());
    assertEquals(Short.SIZE, actualHllSketch.getCompactSerializationBytes());
  }

  /**
   * Method under test: {@link HllSketchWithValues#getHllSketch()}
   */
  @Test
  void testGetHllSketch8() throws IOException {
    // Arrange
    ArrayList<Object> values = new ArrayList<>();
    values.add(10.0d);

    HllSketchWithValues hllSketchWithValues = new HllSketchWithValues();
    hllSketchWithValues.setBytes(null);
    hllSketchWithValues.setValues(values);
    hllSketchWithValues.setLogK(4);

    // Act
    HllSketch actualHllSketch = hllSketchWithValues.getHllSketch();

    // Assert
    assertEquals(1.0d, actualHllSketch.getCompositeEstimate());
    assertEquals(1.0d, actualHllSketch.getEstimate());
    assertEquals(12, actualHllSketch.getCompactSerializationBytes());
    assertEquals(4, actualHllSketch.getLgConfigK());
    assertEquals(40, actualHllSketch.getUpdatableSerializationBytes());
    assertEquals(TgtHllType.HLL_4, actualHllSketch.getTgtHllType());
    assertFalse(actualHllSketch.isCompact());
    assertFalse(actualHllSketch.isEmpty());
    assertFalse(actualHllSketch.isMemory());
    assertFalse(actualHllSketch.isOffHeap());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link HllSketchWithValues}
   *   <li>{@link HllSketchWithValues#setBytes(byte[])}
   *   <li>{@link HllSketchWithValues#setLogK(int)}
   *   <li>{@link HllSketchWithValues#setValues(List)}
   *   <li>{@link HllSketchWithValues#getBytes()}
   *   <li>{@link HllSketchWithValues#getLogK()}
   *   <li>{@link HllSketchWithValues#getValues()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() throws UnsupportedEncodingException {
    // Arrange and Act
    HllSketchWithValues actualHllSketchWithValues = new HllSketchWithValues();
    byte[] bytes = "AXAXAXAX".getBytes("UTF-8");
    actualHllSketchWithValues.setBytes(bytes);
    actualHllSketchWithValues.setLogK(3);
    ArrayList<Object> values = new ArrayList<>();
    actualHllSketchWithValues.setValues(values);
    byte[] actualBytes = actualHllSketchWithValues.getBytes();
    int actualLogK = actualHllSketchWithValues.getLogK();
    List<Object> actualValues = actualHllSketchWithValues.getValues();

    // Assert that nothing has changed
    assertEquals(3, actualLogK);
    assertTrue(actualValues.isEmpty());
    assertSame(values, actualValues);
    assertSame(bytes, actualBytes);
  }
}
