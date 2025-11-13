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

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import org.apache.datasketches.hll.HllSketch;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class HllSketchWithValuesDiffblueTest {
  /**
   * Test {@link HllSketchWithValues#getHllSketch()}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link HllSketchWithValues#getHllSketch()}
   */
  @Test
  @DisplayName("Test getHllSketch(); given ArrayList() add '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"HllSketch HllSketchWithValues.getHllSketch()"})
  void testGetHllSketch_givenArrayListAdd42() throws IOException {
    // Arrange
    ArrayList<Object> values = new ArrayList<>();
    values.add("42");
    values.add(2);
    values.add("");

    HllSketchWithValues hllSketchWithValues = new HllSketchWithValues();
    hllSketchWithValues.setBytes(null);
    hllSketchWithValues.setValues(values);
    hllSketchWithValues.setLogK(4);

    // Act
    HllSketch actualHllSketch = hllSketchWithValues.getHllSketch();

    // Assert
    assertEquals(2.000000004967054d, actualHllSketch.getCompositeEstimate());
    assertEquals(2.000000004967054d, actualHllSketch.getEstimate());
    assertFalse(actualHllSketch.isEmpty());
    assertEquals(Short.SIZE, actualHllSketch.getCompactSerializationBytes());
  }

  /**
   * Test {@link HllSketchWithValues#getHllSketch()}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link HllSketchWithValues#getHllSketch()}
   */
  @Test
  @DisplayName("Test getHllSketch(); given ArrayList() add '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"HllSketch HllSketchWithValues.getHllSketch()"})
  void testGetHllSketch_givenArrayListAdd422() throws IOException {
    // Arrange
    ArrayList<Object> values = new ArrayList<>();
    values.add("42");
    values.add("42");
    values.add(2);
    values.add("");

    HllSketchWithValues hllSketchWithValues = new HllSketchWithValues();
    hllSketchWithValues.setBytes(null);
    hllSketchWithValues.setValues(values);
    hllSketchWithValues.setLogK(4);

    // Act
    HllSketch actualHllSketch = hllSketchWithValues.getHllSketch();

    // Assert
    assertEquals(2.000000004967054d, actualHllSketch.getCompositeEstimate());
    assertEquals(2.000000004967054d, actualHllSketch.getEstimate());
    assertFalse(actualHllSketch.isEmpty());
    assertEquals(Short.SIZE, actualHllSketch.getCompactSerializationBytes());
  }

  /**
   * Test {@link HllSketchWithValues#getHllSketch()}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add empty string.
   *   <li>Then return CompositeEstimate is zero.
   * </ul>
   *
   * <p>Method under test: {@link HllSketchWithValues#getHllSketch()}
   */
  @Test
  @DisplayName(
      "Test getHllSketch(); given ArrayList() add empty string; then return CompositeEstimate is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"HllSketch HllSketchWithValues.getHllSketch()"})
  void testGetHllSketch_givenArrayListAddEmptyString_thenReturnCompositeEstimateIsZero()
      throws IOException {
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
    assertEquals(8, actualHllSketch.getCompactSerializationBytes());
    assertTrue(actualHllSketch.isEmpty());
  }

  /**
   * Test {@link HllSketchWithValues#getHllSketch()}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@code foo}.
   *   <li>Then return CompositeEstimate is one.
   * </ul>
   *
   * <p>Method under test: {@link HllSketchWithValues#getHllSketch()}
   */
  @Test
  @DisplayName(
      "Test getHllSketch(); given ArrayList() add 'foo'; then return CompositeEstimate is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"HllSketch HllSketchWithValues.getHllSketch()"})
  void testGetHllSketch_givenArrayListAddFoo_thenReturnCompositeEstimateIsOne() throws IOException {
    // Arrange
    ArrayList<Object> values = new ArrayList<>();
    values.add("foo");

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
    assertFalse(actualHllSketch.isEmpty());
  }

  /**
   * Test {@link HllSketchWithValues#getHllSketch()}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@code null}.
   *   <li>Then return CompositeEstimate is zero.
   * </ul>
   *
   * <p>Method under test: {@link HllSketchWithValues#getHllSketch()}
   */
  @Test
  @DisplayName(
      "Test getHllSketch(); given ArrayList() add 'null'; then return CompositeEstimate is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"HllSketch HllSketchWithValues.getHllSketch()"})
  void testGetHllSketch_givenArrayListAddNull_thenReturnCompositeEstimateIsZero()
      throws IOException {
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
    assertEquals(8, actualHllSketch.getCompactSerializationBytes());
    assertTrue(actualHllSketch.isEmpty());
  }

  /**
   * Test {@link HllSketchWithValues#getHllSketch()}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add ten.
   * </ul>
   *
   * <p>Method under test: {@link HllSketchWithValues#getHllSketch()}
   */
  @Test
  @DisplayName("Test getHllSketch(); given ArrayList() add ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"HllSketch HllSketchWithValues.getHllSketch()"})
  void testGetHllSketch_givenArrayListAddTen() throws IOException {
    // Arrange
    ArrayList<Object> values = new ArrayList<>();
    values.add(10L);
    values.add(2);
    values.add("");

    HllSketchWithValues hllSketchWithValues = new HllSketchWithValues();
    hllSketchWithValues.setBytes(null);
    hllSketchWithValues.setValues(values);
    hllSketchWithValues.setLogK(4);

    // Act
    HllSketch actualHllSketch = hllSketchWithValues.getHllSketch();

    // Assert
    assertEquals(2.000000004967054d, actualHllSketch.getCompositeEstimate());
    assertEquals(2.000000004967054d, actualHllSketch.getEstimate());
    assertFalse(actualHllSketch.isEmpty());
    assertEquals(Short.SIZE, actualHllSketch.getCompactSerializationBytes());
  }

  /**
   * Test {@link HllSketchWithValues#getHllSketch()}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add ten.
   *   <li>Then return CompositeEstimate is one.
   * </ul>
   *
   * <p>Method under test: {@link HllSketchWithValues#getHllSketch()}
   */
  @Test
  @DisplayName(
      "Test getHllSketch(); given ArrayList() add ten; then return CompositeEstimate is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"HllSketch HllSketchWithValues.getHllSketch()"})
  void testGetHllSketch_givenArrayListAddTen_thenReturnCompositeEstimateIsOne() throws IOException {
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
    assertFalse(actualHllSketch.isEmpty());
  }

  /**
   * Test {@link HllSketchWithValues#getHllSketch()}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add two.
   *   <li>Then return CompositeEstimate is one.
   * </ul>
   *
   * <p>Method under test: {@link HllSketchWithValues#getHllSketch()}
   */
  @Test
  @DisplayName(
      "Test getHllSketch(); given ArrayList() add two; then return CompositeEstimate is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"HllSketch HllSketchWithValues.getHllSketch()"})
  void testGetHllSketch_givenArrayListAddTwo_thenReturnCompositeEstimateIsOne() throws IOException {
    // Arrange
    ArrayList<Object> values = new ArrayList<>();
    values.add(2);
    values.add("");

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
    assertFalse(actualHllSketch.isEmpty());
  }

  /**
   * Test {@link HllSketchWithValues#getHllSketch()}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add zero.
   *   <li>Then return CompositeEstimate is one.
   * </ul>
   *
   * <p>Method under test: {@link HllSketchWithValues#getHllSketch()}
   */
  @Test
  @DisplayName(
      "Test getHllSketch(); given ArrayList() add zero; then return CompositeEstimate is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"HllSketch HllSketchWithValues.getHllSketch()"})
  void testGetHllSketch_givenArrayListAddZero_thenReturnCompositeEstimateIsOne()
      throws IOException {
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
    assertFalse(actualHllSketch.isEmpty());
  }

  /**
   * Test {@link HllSketchWithValues#getHllSketch()}.
   *
   * <ul>
   *   <li>Given {@link HllSketchWithValues} (default constructor).
   *   <li>Then return LgConfigK is {@link HllSketchJsonConstants#DEFAULT_LOG_K}.
   * </ul>
   *
   * <p>Method under test: {@link HllSketchWithValues#getHllSketch()}
   */
  @Test
  @DisplayName(
      "Test getHllSketch(); given HllSketchWithValues (default constructor); then return LgConfigK is DEFAULT_LOG_K")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"HllSketch HllSketchWithValues.getHllSketch()"})
  void testGetHllSketch_givenHllSketchWithValues_thenReturnLgConfigKIsDefault_log_k()
      throws IOException {
    // Arrange and Act
    HllSketch actualHllSketch = new HllSketchWithValues().getHllSketch();

    // Assert
    assertEquals(0.0d, actualHllSketch.getCompositeEstimate());
    assertEquals(0.0d, actualHllSketch.getEstimate());
    assertEquals(8, actualHllSketch.getCompactSerializationBytes());
    assertTrue(actualHllSketch.isEmpty());
    assertEquals(HllSketchJsonConstants.DEFAULT_LOG_K, actualHllSketch.getLgConfigK());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
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
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void HllSketchWithValues.<init>()",
    "byte[] HllSketchWithValues.getBytes()",
    "int HllSketchWithValues.getLogK()",
    "List HllSketchWithValues.getValues()",
    "void HllSketchWithValues.setBytes(byte[])",
    "void HllSketchWithValues.setLogK(int)",
    "void HllSketchWithValues.setValues(List)"
  })
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

    // Assert
    assertEquals(3, actualLogK);
    assertTrue(actualValues.isEmpty());
    assertSame(values, actualValues);
    assertSame(bytes, actualBytes);
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualBytes);
  }
}
