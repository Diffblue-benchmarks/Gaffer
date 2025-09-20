package uk.gov.gchq.gaffer.sketches.datasketches.cardinality.function;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.apache.datasketches.hll.HllSketch;
import org.apache.datasketches.hll.TgtHllType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ToHllSketchDiffblueTest {
  /**
   * Test {@link ToHllSketch#ToHllSketch()}.
   *
   * <p>Method under test: {@link ToHllSketch#ToHllSketch()}
   */
  @Test
  @DisplayName("Test new ToHllSketch()")
  @Tag("MaintainedByDiffblue")
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
    assertTrue(hllSketch.isEstimationMode());
  }

  /**
   * Test {@link ToHllSketch#ToHllSketch(int)}.
   *
   * <ul>
   *   <li>When four.
   *   <li>Then return HllSketch CompositeEstimate is zero.
   * </ul>
   *
   * <p>Method under test: {@link ToHllSketch#ToHllSketch(int)}
   */
  @Test
  @DisplayName(
      "Test new ToHllSketch(int); when four; then return HllSketch CompositeEstimate is zero")
  @Tag("MaintainedByDiffblue")
  void testNewToHllSketch_whenFour_thenReturnHllSketchCompositeEstimateIsZero() {
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
    assertTrue(hllSketch.isEstimationMode());
  }

  /**
   * Test {@link ToHllSketch#ToHllSketch(HllSketch)}.
   *
   * <ul>
   *   <li>When {@link HllSketch#HllSketch()}.
   *   <li>Then return HllSketch LgConfigK is twelve.
   * </ul>
   *
   * <p>Method under test: {@link ToHllSketch#ToHllSketch(HllSketch)}
   */
  @Test
  @DisplayName(
      "Test new ToHllSketch(HllSketch); when HllSketch(); then return HllSketch LgConfigK is twelve")
  @Tag("MaintainedByDiffblue")
  void testNewToHllSketch_whenHllSketch_thenReturnHllSketchLgConfigKIsTwelve() {
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
    assertTrue(hllSketch.isEstimationMode());
  }

  /**
   * Test {@link ToHllSketch#ToHllSketch(HllSketch)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return HllSketch LgConfigK is ten.
   * </ul>
   *
   * <p>Method under test: {@link ToHllSketch#ToHllSketch(HllSketch)}
   */
  @Test
  @DisplayName(
      "Test new ToHllSketch(HllSketch); when 'null'; then return HllSketch LgConfigK is ten")
  @Tag("MaintainedByDiffblue")
  void testNewToHllSketch_whenNull_thenReturnHllSketchLgConfigKIsTen() {
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
    assertTrue(hllSketch.isEstimationMode());
  }

  /**
   * Test {@link ToHllSketch#apply(Object)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   *   <li>Then return CompositeEstimate is one.
   * </ul>
   *
   * <p>Method under test: {@link ToHllSketch#apply(Object)}
   */
  @Test
  @DisplayName("Test apply(Object); when '42'; then return CompositeEstimate is one")
  @Tag("MaintainedByDiffblue")
  void testApply_when42_thenReturnCompositeEstimateIsOne() {
    // Arrange and Act
    HllSketch actualApplyResult = new ToHllSketch().apply("42");

    // Assert
    assertEquals(1.0d, actualApplyResult.getCompositeEstimate());
    assertEquals(1.0d, actualApplyResult.getEstimate());
    assertEquals(12, actualApplyResult.getCompactSerializationBytes());
    assertFalse(actualApplyResult.isEmpty());
  }

  /**
   * Test {@link ToHllSketch#apply(Object)}.
   *
   * <ul>
   *   <li>When empty string.
   *   <li>Then return CompositeEstimate is zero.
   * </ul>
   *
   * <p>Method under test: {@link ToHllSketch#apply(Object)}
   */
  @Test
  @DisplayName("Test apply(Object); when empty string; then return CompositeEstimate is zero")
  @Tag("MaintainedByDiffblue")
  void testApply_whenEmptyString_thenReturnCompositeEstimateIsZero() {
    // Arrange and Act
    HllSketch actualApplyResult = new ToHllSketch().apply("");

    // Assert
    assertEquals(0.0d, actualApplyResult.getCompositeEstimate());
    assertEquals(0.0d, actualApplyResult.getEstimate());
    assertEquals(8, actualApplyResult.getCompactSerializationBytes());
    assertTrue(actualApplyResult.isEmpty());
  }

  /**
   * Test {@link ToHllSketch#apply(Object)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return CompositeEstimate is zero.
   * </ul>
   *
   * <p>Method under test: {@link ToHllSketch#apply(Object)}
   */
  @Test
  @DisplayName("Test apply(Object); when 'null'; then return CompositeEstimate is zero")
  @Tag("MaintainedByDiffblue")
  void testApply_whenNull_thenReturnCompositeEstimateIsZero() {
    // Arrange and Act
    HllSketch actualApplyResult = new ToHllSketch().apply(null);

    // Assert
    assertEquals(0.0d, actualApplyResult.getCompositeEstimate());
    assertEquals(0.0d, actualApplyResult.getEstimate());
    assertEquals(8, actualApplyResult.getCompactSerializationBytes());
    assertTrue(actualApplyResult.isEmpty());
  }

  /**
   * Test {@link ToHllSketch#apply(Object)}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then return CompositeEstimate is one.
   * </ul>
   *
   * <p>Method under test: {@link ToHllSketch#apply(Object)}
   */
  @Test
  @DisplayName("Test apply(Object); when one; then return CompositeEstimate is one")
  @Tag("MaintainedByDiffblue")
  void testApply_whenOne_thenReturnCompositeEstimateIsOne() {
    // Arrange and Act
    HllSketch actualApplyResult = new ToHllSketch().apply(1L);

    // Assert
    assertEquals(1.0d, actualApplyResult.getCompositeEstimate());
    assertEquals(1.0d, actualApplyResult.getEstimate());
    assertEquals(12, actualApplyResult.getCompactSerializationBytes());
    assertFalse(actualApplyResult.isEmpty());
  }

  /**
   * Test {@link ToHllSketch#apply(Object)}.
   *
   * <ul>
   *   <li>When ten.
   *   <li>Then return CompositeEstimate is one.
   * </ul>
   *
   * <p>Method under test: {@link ToHllSketch#apply(Object)}
   */
  @Test
  @DisplayName("Test apply(Object); when ten; then return CompositeEstimate is one")
  @Tag("MaintainedByDiffblue")
  void testApply_whenTen_thenReturnCompositeEstimateIsOne() {
    // Arrange and Act
    HllSketch actualApplyResult = new ToHllSketch().apply(10.0d);

    // Assert
    assertEquals(1.0d, actualApplyResult.getCompositeEstimate());
    assertEquals(1.0d, actualApplyResult.getEstimate());
    assertEquals(12, actualApplyResult.getCompactSerializationBytes());
    assertFalse(actualApplyResult.isEmpty());
  }

  /**
   * Test {@link ToHllSketch#apply(Object)}.
   *
   * <ul>
   *   <li>When three.
   *   <li>Then return CompositeEstimate is one.
   * </ul>
   *
   * <p>Method under test: {@link ToHllSketch#apply(Object)}
   */
  @Test
  @DisplayName("Test apply(Object); when three; then return CompositeEstimate is one")
  @Tag("MaintainedByDiffblue")
  void testApply_whenThree_thenReturnCompositeEstimateIsOne() {
    // Arrange and Act
    HllSketch actualApplyResult = new ToHllSketch().apply(3);

    // Assert
    assertEquals(1.0d, actualApplyResult.getCompositeEstimate());
    assertEquals(1.0d, actualApplyResult.getEstimate());
    assertEquals(12, actualApplyResult.getCompactSerializationBytes());
    assertFalse(actualApplyResult.isEmpty());
  }

  /**
   * Test {@link ToHllSketch#apply(Object)}.
   *
   * <ul>
   *   <li>When zero.
   *   <li>Then return CompositeEstimate is one.
   * </ul>
   *
   * <p>Method under test: {@link ToHllSketch#apply(Object)}
   */
  @Test
  @DisplayName("Test apply(Object); when zero; then return CompositeEstimate is one")
  @Tag("MaintainedByDiffblue")
  void testApply_whenZero_thenReturnCompositeEstimateIsOne() {
    // Arrange and Act
    HllSketch actualApplyResult = new ToHllSketch().apply(0.0d);

    // Assert
    assertEquals(1.0d, actualApplyResult.getCompositeEstimate());
    assertEquals(1.0d, actualApplyResult.getEstimate());
    assertEquals(12, actualApplyResult.getCompactSerializationBytes());
    assertFalse(actualApplyResult.isEmpty());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ToHllSketch#setLogK(int)}
   *   <li>{@link ToHllSketch#getHllSketch()}
   *   <li>{@link ToHllSketch#getLogK()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  void testGettersAndSetters() {
    // Arrange
    ToHllSketch toHllSketch = new ToHllSketch();

    // Act
    toHllSketch.setLogK(3);
    HllSketch actualHllSketch = toHllSketch.getHllSketch();

    // Assert
    assertEquals(0.0d, actualHllSketch.getCompositeEstimate());
    assertEquals(0.0d, actualHllSketch.getEstimate());
    assertEquals(10, actualHllSketch.getLgConfigK());
    assertEquals(3, toHllSketch.getLogK());
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
   * Test {@link ToHllSketch#setHllSketch(HllSketch)}.
   *
   * <ul>
   *   <li>Given {@link ToHllSketch#ToHllSketch()}.
   *   <li>Then {@link ToHllSketch#ToHllSketch()} HllSketch LgConfigK is twelve.
   * </ul>
   *
   * <p>Method under test: {@link ToHllSketch#setHllSketch(HllSketch)}
   */
  @Test
  @DisplayName(
      "Test setHllSketch(HllSketch); given ToHllSketch(); then ToHllSketch() HllSketch LgConfigK is twelve")
  @Tag("MaintainedByDiffblue")
  void testSetHllSketch_givenToHllSketch_thenToHllSketchHllSketchLgConfigKIsTwelve() {
    // Arrange
    ToHllSketch toHllSketch = new ToHllSketch();

    // Act
    toHllSketch.setHllSketch(new HllSketch());

    // Assert
    assertEquals(12, toHllSketch.getHllSketch().getLgConfigK());
  }

  /**
   * Test {@link ToHllSketch#setHllSketch(HllSketch)}.
   *
   * <ul>
   *   <li>Then {@link ToHllSketch#ToHllSketch(int)} with logK is four HllSketch LgConfigK is four.
   * </ul>
   *
   * <p>Method under test: {@link ToHllSketch#setHllSketch(HllSketch)}
   */
  @Test
  @DisplayName(
      "Test setHllSketch(HllSketch); then ToHllSketch(int) with logK is four HllSketch LgConfigK is four")
  @Tag("MaintainedByDiffblue")
  void testSetHllSketch_thenToHllSketchWithLogKIsFourHllSketchLgConfigKIsFour() {
    // Arrange
    ToHllSketch toHllSketch = new ToHllSketch(4);

    // Act
    toHllSketch.setHllSketch(null);

    // Assert that nothing has changed
    assertEquals(4, toHllSketch.getHllSketch().getLgConfigK());
  }
}
