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
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import org.apache.datasketches.hll.HllSketch;
import org.apache.datasketches.hll.TgtHllType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class IterableToHllSketchDiffblueTest {
  /**
   * Test {@link IterableToHllSketch#IterableToHllSketch()}.
   *
   * <p>Method under test: {@link IterableToHllSketch#IterableToHllSketch()}
   */
  @Test
  @DisplayName("Test new IterableToHllSketch()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void IterableToHllSketch.<init>()"})
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
    assertTrue(hllSketch.isEstimationMode());
  }

  /**
   * Test {@link IterableToHllSketch#IterableToHllSketch(int)}.
   *
   * <ul>
   *   <li>When four.
   *   <li>Then return HllSketch CompositeEstimate is zero.
   * </ul>
   *
   * <p>Method under test: {@link IterableToHllSketch#IterableToHllSketch(int)}
   */
  @Test
  @DisplayName(
      "Test new IterableToHllSketch(int); when four; then return HllSketch CompositeEstimate is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void IterableToHllSketch.<init>(int)"})
  void testNewIterableToHllSketch_whenFour_thenReturnHllSketchCompositeEstimateIsZero() {
    // Arrange and Act
    IterableToHllSketch actualIterableToHllSketch = new IterableToHllSketch(4);

    // Assert
    HllSketch hllSketch = actualIterableToHllSketch.getHllSketch();
    assertEquals(0.0d, hllSketch.getCompositeEstimate());
    assertEquals(0.0d, hllSketch.getEstimate());
    assertEquals(4, hllSketch.getLgConfigK());
    assertEquals(4, actualIterableToHllSketch.getLogK());
    assertEquals(40, hllSketch.getUpdatableSerializationBytes());
    assertEquals(8, hllSketch.getCompactSerializationBytes());
    assertEquals(TgtHllType.HLL_4, hllSketch.getTgtHllType());
    assertFalse(hllSketch.isCompact());
    assertFalse(hllSketch.isMemory());
    assertFalse(hllSketch.isOffHeap());
    assertTrue(hllSketch.isEmpty());
    assertTrue(hllSketch.isEstimationMode());
  }

  /**
   * Test {@link IterableToHllSketch#IterableToHllSketch(HllSketch)}.
   *
   * <ul>
   *   <li>When {@link HllSketch#HllSketch()}.
   *   <li>Then return HllSketch LgConfigK is twelve.
   * </ul>
   *
   * <p>Method under test: {@link IterableToHllSketch#IterableToHllSketch(HllSketch)}
   */
  @Test
  @DisplayName(
      "Test new IterableToHllSketch(HllSketch); when HllSketch(); then return HllSketch LgConfigK is twelve")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void IterableToHllSketch.<init>(HllSketch)"})
  void testNewIterableToHllSketch_whenHllSketch_thenReturnHllSketchLgConfigKIsTwelve() {
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
    assertTrue(hllSketch.isEstimationMode());
  }

  /**
   * Test {@link IterableToHllSketch#IterableToHllSketch(HllSketch)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return HllSketch LgConfigK is ten.
   * </ul>
   *
   * <p>Method under test: {@link IterableToHllSketch#IterableToHllSketch(HllSketch)}
   */
  @Test
  @DisplayName(
      "Test new IterableToHllSketch(HllSketch); when 'null'; then return HllSketch LgConfigK is ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void IterableToHllSketch.<init>(HllSketch)"})
  void testNewIterableToHllSketch_whenNull_thenReturnHllSketchLgConfigKIsTen() {
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
    assertTrue(hllSketch.isEstimationMode());
  }

  /**
   * Test {@link IterableToHllSketch#apply(Iterable)} with {@code Iterable}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link IterableToHllSketch#apply(Iterable)}
   */
  @Test
  @DisplayName("Test apply(Iterable) with 'Iterable'; given '42'; when ArrayList() add '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"HllSketch IterableToHllSketch.apply(Iterable)"})
  void testApplyWithIterable_given42_whenArrayListAdd42() {
    // Arrange
    IterableToHllSketch iterableToHllSketch = new IterableToHllSketch();

    ArrayList<Object> iterable = new ArrayList<>();
    iterable.add("42");
    iterable.add(2);

    // Act
    HllSketch actualApplyResult = iterableToHllSketch.apply(iterable);

    // Assert
    assertEquals(2.000000004967054d, actualApplyResult.getCompositeEstimate());
    assertEquals(2.000000004967054d, actualApplyResult.getEstimate());
    assertFalse(actualApplyResult.isEmpty());
    assertEquals(Short.SIZE, actualApplyResult.getCompactSerializationBytes());
  }

  /**
   * Test {@link IterableToHllSketch#apply(Iterable)} with {@code Iterable}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link IterableToHllSketch#apply(Iterable)}
   */
  @Test
  @DisplayName("Test apply(Iterable) with 'Iterable'; given '42'; when ArrayList() add '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"HllSketch IterableToHllSketch.apply(Iterable)"})
  void testApplyWithIterable_given42_whenArrayListAdd422() {
    // Arrange
    IterableToHllSketch iterableToHllSketch = new IterableToHllSketch();

    ArrayList<Object> iterable = new ArrayList<>();
    iterable.add("42");
    iterable.add("42");
    iterable.add(2);

    // Act
    HllSketch actualApplyResult = iterableToHllSketch.apply(iterable);

    // Assert
    assertEquals(2.000000004967054d, actualApplyResult.getCompositeEstimate());
    assertEquals(2.000000004967054d, actualApplyResult.getEstimate());
    assertFalse(actualApplyResult.isEmpty());
    assertEquals(Short.SIZE, actualApplyResult.getCompactSerializationBytes());
  }

  /**
   * Test {@link IterableToHllSketch#apply(Iterable)} with {@code Iterable}.
   *
   * <ul>
   *   <li>Given empty string.
   *   <li>When {@link LinkedHashSet#LinkedHashSet()} add empty string.
   * </ul>
   *
   * <p>Method under test: {@link IterableToHllSketch#apply(Iterable)}
   */
  @Test
  @DisplayName(
      "Test apply(Iterable) with 'Iterable'; given empty string; when LinkedHashSet() add empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"HllSketch IterableToHllSketch.apply(Iterable)"})
  void testApplyWithIterable_givenEmptyString_whenLinkedHashSetAddEmptyString() {
    // Arrange
    IterableToHllSketch iterableToHllSketch = new IterableToHllSketch();

    LinkedHashSet<Object> iterable = new LinkedHashSet<>();
    iterable.add("");

    // Act
    HllSketch actualApplyResult = iterableToHllSketch.apply(iterable);

    // Assert
    assertEquals(0.0d, actualApplyResult.getCompositeEstimate());
    assertEquals(0.0d, actualApplyResult.getEstimate());
    assertEquals(8, actualApplyResult.getCompactSerializationBytes());
    assertTrue(actualApplyResult.isEmpty());
  }

  /**
   * Test {@link IterableToHllSketch#apply(Iterable)} with {@code Iterable}.
   *
   * <ul>
   *   <li>Given {@code Iterable}.
   *   <li>When {@link LinkedHashSet#LinkedHashSet()} add {@code Iterable}.
   * </ul>
   *
   * <p>Method under test: {@link IterableToHllSketch#apply(Iterable)}
   */
  @Test
  @DisplayName(
      "Test apply(Iterable) with 'Iterable'; given 'Iterable'; when LinkedHashSet() add 'Iterable'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"HllSketch IterableToHllSketch.apply(Iterable)"})
  void testApplyWithIterable_givenIterable_whenLinkedHashSetAddIterable() {
    // Arrange
    IterableToHllSketch iterableToHllSketch = new IterableToHllSketch();

    LinkedHashSet<Object> iterable = new LinkedHashSet<>();
    iterable.add("Iterable");

    // Act
    HllSketch actualApplyResult = iterableToHllSketch.apply(iterable);

    // Assert
    assertEquals(1.0d, actualApplyResult.getCompositeEstimate());
    assertEquals(1.0d, actualApplyResult.getEstimate());
    assertEquals(12, actualApplyResult.getCompactSerializationBytes());
    assertFalse(actualApplyResult.isEmpty());
  }

  /**
   * Test {@link IterableToHllSketch#apply(Iterable)} with {@code Iterable}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link LinkedHashSet#LinkedHashSet()} add {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link IterableToHllSketch#apply(Iterable)}
   */
  @Test
  @DisplayName(
      "Test apply(Iterable) with 'Iterable'; given 'null'; when LinkedHashSet() add 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"HllSketch IterableToHllSketch.apply(Iterable)"})
  void testApplyWithIterable_givenNull_whenLinkedHashSetAddNull() {
    // Arrange
    IterableToHllSketch iterableToHllSketch = new IterableToHllSketch();

    LinkedHashSet<Object> iterable = new LinkedHashSet<>();
    iterable.add(null);

    // Act
    HllSketch actualApplyResult = iterableToHllSketch.apply(iterable);

    // Assert
    assertEquals(0.0d, actualApplyResult.getCompositeEstimate());
    assertEquals(0.0d, actualApplyResult.getEstimate());
    assertEquals(8, actualApplyResult.getCompactSerializationBytes());
    assertTrue(actualApplyResult.isEmpty());
  }

  /**
   * Test {@link IterableToHllSketch#apply(Iterable)} with {@code Iterable}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>When {@link ArrayList#ArrayList()} add one.
   * </ul>
   *
   * <p>Method under test: {@link IterableToHllSketch#apply(Iterable)}
   */
  @Test
  @DisplayName("Test apply(Iterable) with 'Iterable'; given one; when ArrayList() add one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"HllSketch IterableToHllSketch.apply(Iterable)"})
  void testApplyWithIterable_givenOne_whenArrayListAddOne() {
    // Arrange
    IterableToHllSketch iterableToHllSketch = new IterableToHllSketch();

    ArrayList<Object> iterable = new ArrayList<>();
    iterable.add(1L);
    iterable.add(2);

    // Act
    HllSketch actualApplyResult = iterableToHllSketch.apply(iterable);

    // Assert
    assertEquals(2.000000004967054d, actualApplyResult.getCompositeEstimate());
    assertEquals(2.000000004967054d, actualApplyResult.getEstimate());
    assertFalse(actualApplyResult.isEmpty());
    assertEquals(Short.SIZE, actualApplyResult.getCompactSerializationBytes());
  }

  /**
   * Test {@link IterableToHllSketch#apply(Iterable)} with {@code Iterable}.
   *
   * <ul>
   *   <li>Given ten.
   *   <li>When {@link LinkedHashSet#LinkedHashSet()} add ten.
   * </ul>
   *
   * <p>Method under test: {@link IterableToHllSketch#apply(Iterable)}
   */
  @Test
  @DisplayName("Test apply(Iterable) with 'Iterable'; given ten; when LinkedHashSet() add ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"HllSketch IterableToHllSketch.apply(Iterable)"})
  void testApplyWithIterable_givenTen_whenLinkedHashSetAddTen() {
    // Arrange
    IterableToHllSketch iterableToHllSketch = new IterableToHllSketch();

    LinkedHashSet<Object> iterable = new LinkedHashSet<>();
    iterable.add(10.0d);

    // Act
    HllSketch actualApplyResult = iterableToHllSketch.apply(iterable);

    // Assert
    assertEquals(1.0d, actualApplyResult.getCompositeEstimate());
    assertEquals(1.0d, actualApplyResult.getEstimate());
    assertEquals(12, actualApplyResult.getCompactSerializationBytes());
    assertFalse(actualApplyResult.isEmpty());
  }

  /**
   * Test {@link IterableToHllSketch#apply(Iterable)} with {@code Iterable}.
   *
   * <ul>
   *   <li>Given two.
   *   <li>Then return CompositeEstimate is one.
   * </ul>
   *
   * <p>Method under test: {@link IterableToHllSketch#apply(Iterable)}
   */
  @Test
  @DisplayName(
      "Test apply(Iterable) with 'Iterable'; given two; then return CompositeEstimate is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"HllSketch IterableToHllSketch.apply(Iterable)"})
  void testApplyWithIterable_givenTwo_thenReturnCompositeEstimateIsOne() {
    // Arrange
    IterableToHllSketch iterableToHllSketch = new IterableToHllSketch();

    ArrayList<Object> iterable = new ArrayList<>();
    iterable.add(2);

    // Act
    HllSketch actualApplyResult = iterableToHllSketch.apply(iterable);

    // Assert
    assertEquals(1.0d, actualApplyResult.getCompositeEstimate());
    assertEquals(1.0d, actualApplyResult.getEstimate());
    assertEquals(12, actualApplyResult.getCompactSerializationBytes());
    assertFalse(actualApplyResult.isEmpty());
  }

  /**
   * Test {@link IterableToHllSketch#apply(Iterable)} with {@code Iterable}.
   *
   * <ul>
   *   <li>Given zero.
   *   <li>When {@link LinkedHashSet#LinkedHashSet()} add zero.
   * </ul>
   *
   * <p>Method under test: {@link IterableToHllSketch#apply(Iterable)}
   */
  @Test
  @DisplayName("Test apply(Iterable) with 'Iterable'; given zero; when LinkedHashSet() add zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"HllSketch IterableToHllSketch.apply(Iterable)"})
  void testApplyWithIterable_givenZero_whenLinkedHashSetAddZero() {
    // Arrange
    IterableToHllSketch iterableToHllSketch = new IterableToHllSketch();

    LinkedHashSet<Object> iterable = new LinkedHashSet<>();
    iterable.add(0.0d);

    // Act
    HllSketch actualApplyResult = iterableToHllSketch.apply(iterable);

    // Assert
    assertEquals(1.0d, actualApplyResult.getCompositeEstimate());
    assertEquals(1.0d, actualApplyResult.getEstimate());
    assertEquals(12, actualApplyResult.getCompactSerializationBytes());
    assertFalse(actualApplyResult.isEmpty());
  }

  /**
   * Test {@link IterableToHllSketch#apply(Iterable)} with {@code Iterable}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return CompositeEstimate is zero.
   * </ul>
   *
   * <p>Method under test: {@link IterableToHllSketch#apply(Iterable)}
   */
  @Test
  @DisplayName(
      "Test apply(Iterable) with 'Iterable'; when ArrayList(); then return CompositeEstimate is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"HllSketch IterableToHllSketch.apply(Iterable)"})
  void testApplyWithIterable_whenArrayList_thenReturnCompositeEstimateIsZero() {
    // Arrange
    IterableToHllSketch iterableToHllSketch = new IterableToHllSketch();

    // Act
    HllSketch actualApplyResult = iterableToHllSketch.apply(new ArrayList<>());

    // Assert
    assertEquals(0.0d, actualApplyResult.getCompositeEstimate());
    assertEquals(0.0d, actualApplyResult.getEstimate());
    assertEquals(8, actualApplyResult.getCompactSerializationBytes());
    assertTrue(actualApplyResult.isEmpty());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link IterableToHllSketch#setLogK(int)}
   *   <li>{@link IterableToHllSketch#getHllSketch()}
   *   <li>{@link IterableToHllSketch#getLogK()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "HllSketch IterableToHllSketch.getHllSketch()",
    "int IterableToHllSketch.getLogK()",
    "void IterableToHllSketch.setLogK(int)"
  })
  void testGettersAndSetters() {
    // Arrange
    IterableToHllSketch iterableToHllSketch = new IterableToHllSketch();

    // Act
    iterableToHllSketch.setLogK(3);
    HllSketch actualHllSketch = iterableToHllSketch.getHllSketch();

    // Assert
    assertEquals(0.0d, actualHllSketch.getCompositeEstimate());
    assertEquals(0.0d, actualHllSketch.getEstimate());
    assertEquals(10, actualHllSketch.getLgConfigK());
    assertEquals(3, iterableToHllSketch.getLogK());
    assertEquals(40, actualHllSketch.getUpdatableSerializationBytes());
    assertEquals(8, actualHllSketch.getCompactSerializationBytes());
    assertEquals(TgtHllType.HLL_4, actualHllSketch.getTgtHllType());
    assertFalse(actualHllSketch.isCompact());
    assertFalse(actualHllSketch.isMemory());
    assertFalse(actualHllSketch.isOffHeap());
    assertTrue(actualHllSketch.isEmpty());
    assertTrue(actualHllSketch.isEstimationMode());
  }

  /**
   * Test {@link IterableToHllSketch#setHllSketch(HllSketch)}.
   *
   * <ul>
   *   <li>Then {@link IterableToHllSketch#IterableToHllSketch()} HllSketch LgConfigK is twelve.
   * </ul>
   *
   * <p>Method under test: {@link IterableToHllSketch#setHllSketch(HllSketch)}
   */
  @Test
  @DisplayName(
      "Test setHllSketch(HllSketch); then IterableToHllSketch() HllSketch LgConfigK is twelve")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void IterableToHllSketch.setHllSketch(HllSketch)"})
  void testSetHllSketch_thenIterableToHllSketchHllSketchLgConfigKIsTwelve() {
    // Arrange
    IterableToHllSketch iterableToHllSketch = new IterableToHllSketch();

    // Act
    iterableToHllSketch.setHllSketch(new HllSketch());

    // Assert
    assertEquals(12, iterableToHllSketch.getHllSketch().getLgConfigK());
  }

  /**
   * Test {@link IterableToHllSketch#setHllSketch(HllSketch)}.
   *
   * <ul>
   *   <li>Then {@link IterableToHllSketch#IterableToHllSketch(int)} with logK is four HllSketch
   *       LgConfigK is four.
   * </ul>
   *
   * <p>Method under test: {@link IterableToHllSketch#setHllSketch(HllSketch)}
   */
  @Test
  @DisplayName(
      "Test setHllSketch(HllSketch); then IterableToHllSketch(int) with logK is four HllSketch LgConfigK is four")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void IterableToHllSketch.setHllSketch(HllSketch)"})
  void testSetHllSketch_thenIterableToHllSketchWithLogKIsFourHllSketchLgConfigKIsFour() {
    // Arrange
    IterableToHllSketch iterableToHllSketch = new IterableToHllSketch(4);

    // Act
    iterableToHllSketch.setHllSketch(null);

    // Assert that nothing has changed
    assertEquals(4, iterableToHllSketch.getHllSketch().getLgConfigK());
  }
}
