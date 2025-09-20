package uk.gov.gchq.gaffer.sketches.clearspring.cardinality.function;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import com.clearspring.analytics.stream.cardinality.HyperLogLogPlus;
import java.io.IOException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ToHyperLogLogPlusDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ToHyperLogLogPlus#ToHyperLogLogPlus()}
   *   <li>{@link ToHyperLogLogPlus#setP(int)}
   *   <li>{@link ToHyperLogLogPlus#setSp(int)}
   *   <li>{@link ToHyperLogLogPlus#getP()}
   *   <li>{@link ToHyperLogLogPlus#getSp()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  void testGettersAndSetters() {
    // Arrange and Act
    ToHyperLogLogPlus actualToHyperLogLogPlus = new ToHyperLogLogPlus();
    actualToHyperLogLogPlus.setP(3);
    actualToHyperLogLogPlus.setSp(3);
    int actualP = actualToHyperLogLogPlus.getP();

    // Assert
    assertEquals(3, actualP);
    assertEquals(3, actualToHyperLogLogPlus.getSp());
  }

  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>When three.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ToHyperLogLogPlus#ToHyperLogLogPlus(int, int)}
   *   <li>{@link ToHyperLogLogPlus#setP(int)}
   *   <li>{@link ToHyperLogLogPlus#setSp(int)}
   *   <li>{@link ToHyperLogLogPlus#getP()}
   *   <li>{@link ToHyperLogLogPlus#getSp()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; when three")
  @Tag("MaintainedByDiffblue")
  void testGettersAndSetters_whenThree() {
    // Arrange and Act
    ToHyperLogLogPlus actualToHyperLogLogPlus = new ToHyperLogLogPlus(3, 3);
    actualToHyperLogLogPlus.setP(3);
    actualToHyperLogLogPlus.setSp(3);
    int actualP = actualToHyperLogLogPlus.getP();

    // Assert
    assertEquals(3, actualP);
    assertEquals(3, actualToHyperLogLogPlus.getSp());
  }

  /**
   * Test {@link ToHyperLogLogPlus#apply(Object)}.
   *
   * <ul>
   *   <li>Given {@link ToHyperLogLogPlus#ToHyperLogLogPlus(int, int)} with p is four and sp is
   *       {@link Integer#SIZE}.
   *   <li>Then return sizeof is twelve.
   * </ul>
   *
   * <p>Method under test: {@link ToHyperLogLogPlus#apply(Object)}
   */
  @Test
  @DisplayName(
      "Test apply(Object); given ToHyperLogLogPlus(int, int) with p is four and sp is SIZE; then return sizeof is twelve")
  @Tag("MaintainedByDiffblue")
  void testApply_givenToHyperLogLogPlusWithPIsFourAndSpIsSize_thenReturnSizeofIsTwelve()
      throws IOException {
    // Arrange and Act
    HyperLogLogPlus actualApplyResult = new ToHyperLogLogPlus(4, Integer.SIZE).apply(null);

    // Assert
    assertEquals(12, actualApplyResult.sizeof());
    assertArrayEquals(new byte[] {-1, -1, -1, -2, 4, ' ', 1, 0}, actualApplyResult.getBytes());
  }

  /**
   * Test {@link ToHyperLogLogPlus#apply(Object)}.
   *
   * <ul>
   *   <li>Given {@link ToHyperLogLogPlus#ToHyperLogLogPlus(int, int)} with p is four and sp is
   *       {@link Integer#SIZE}.
   *   <li>Then return sizeof is twelve.
   * </ul>
   *
   * <p>Method under test: {@link ToHyperLogLogPlus#apply(Object)}
   */
  @Test
  @DisplayName(
      "Test apply(Object); given ToHyperLogLogPlus(int, int) with p is four and sp is SIZE; then return sizeof is twelve")
  @Tag("MaintainedByDiffblue")
  void testApply_givenToHyperLogLogPlusWithPIsFourAndSpIsSize_thenReturnSizeofIsTwelve2()
      throws IOException {
    // Arrange and Act
    HyperLogLogPlus actualApplyResult = new ToHyperLogLogPlus(4, Integer.SIZE).apply("42");

    // Assert
    assertEquals(12, actualApplyResult.sizeof());
    assertArrayEquals(
        new byte[] {-1, -1, -1, -2, 4, ' ', 1, 1, -64, -120, -45, -80, 7},
        actualApplyResult.getBytes());
  }

  /**
   * Test {@link ToHyperLogLogPlus#apply(Object)}.
   *
   * <ul>
   *   <li>Given {@link ToHyperLogLogPlus#ToHyperLogLogPlus(int, int)} with p is four and sp is
   *       zero.
   *   <li>Then return sizeof is twelve.
   * </ul>
   *
   * <p>Method under test: {@link ToHyperLogLogPlus#apply(Object)}
   */
  @Test
  @DisplayName(
      "Test apply(Object); given ToHyperLogLogPlus(int, int) with p is four and sp is zero; then return sizeof is twelve")
  @Tag("MaintainedByDiffblue")
  void testApply_givenToHyperLogLogPlusWithPIsFourAndSpIsZero_thenReturnSizeofIsTwelve()
      throws IOException {
    // Arrange and Act
    HyperLogLogPlus actualApplyResult = new ToHyperLogLogPlus(4, 0).apply(null);

    // Assert
    assertEquals(12, actualApplyResult.sizeof());
    assertArrayEquals(
        new byte[] {-1, -1, -1, -2, 4, 0, 0, '\f', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        actualApplyResult.getBytes());
  }

  /**
   * Test {@link ToHyperLogLogPlus#apply(Object)}.
   *
   * <ul>
   *   <li>Given {@link ToHyperLogLogPlus#ToHyperLogLogPlus(int, int)} with p is four and sp is
   *       zero.
   *   <li>Then return sizeof is twelve.
   * </ul>
   *
   * <p>Method under test: {@link ToHyperLogLogPlus#apply(Object)}
   */
  @Test
  @DisplayName(
      "Test apply(Object); given ToHyperLogLogPlus(int, int) with p is four and sp is zero; then return sizeof is twelve")
  @Tag("MaintainedByDiffblue")
  void testApply_givenToHyperLogLogPlusWithPIsFourAndSpIsZero_thenReturnSizeofIsTwelve2()
      throws IOException {
    // Arrange and Act
    HyperLogLogPlus actualApplyResult = new ToHyperLogLogPlus(4, 0).apply("42");

    // Assert
    assertEquals(12, actualApplyResult.sizeof());
    assertArrayEquals(
        new byte[] {-1, -1, -1, -2, 4, 0, 0, '\f', 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0},
        actualApplyResult.getBytes());
  }

  /**
   * Test {@link ToHyperLogLogPlus#apply(Object)}.
   *
   * <ul>
   *   <li>Given {@link ToHyperLogLogPlus#ToHyperLogLogPlus()}.
   *   <li>When {@code 42}.
   *   <li>Then return sizeof is twenty-four.
   * </ul>
   *
   * <p>Method under test: {@link ToHyperLogLogPlus#apply(Object)}
   */
  @Test
  @DisplayName(
      "Test apply(Object); given ToHyperLogLogPlus(); when '42'; then return sizeof is twenty-four")
  @Tag("MaintainedByDiffblue")
  void testApply_givenToHyperLogLogPlus_when42_thenReturnSizeofIsTwentyFour() throws IOException {
    // Arrange and Act
    HyperLogLogPlus actualApplyResult = new ToHyperLogLogPlus().apply("42");

    // Assert
    assertEquals(24, actualApplyResult.sizeof());
    assertArrayEquals(
        new byte[] {-1, -1, -1, -2, 5, 5, 1, 1, -5, 23}, actualApplyResult.getBytes());
  }

  /**
   * Test {@link ToHyperLogLogPlus#apply(Object)}.
   *
   * <ul>
   *   <li>Given {@link ToHyperLogLogPlus#ToHyperLogLogPlus()}.
   *   <li>When empty string.
   *   <li>Then return sizeof is twenty-four.
   * </ul>
   *
   * <p>Method under test: {@link ToHyperLogLogPlus#apply(Object)}
   */
  @Test
  @DisplayName(
      "Test apply(Object); given ToHyperLogLogPlus(); when empty string; then return sizeof is twenty-four")
  @Tag("MaintainedByDiffblue")
  void testApply_givenToHyperLogLogPlus_whenEmptyString_thenReturnSizeofIsTwentyFour()
      throws IOException {
    // Arrange and Act
    HyperLogLogPlus actualApplyResult = new ToHyperLogLogPlus().apply("");

    // Assert
    assertEquals(24, actualApplyResult.sizeof());
    assertArrayEquals(
        new byte[] {-1, -1, -1, -2, 5, 5, 1, 1, -5, 19}, actualApplyResult.getBytes());
  }

  /**
   * Test {@link ToHyperLogLogPlus#apply(Object)}.
   *
   * <ul>
   *   <li>Given {@link ToHyperLogLogPlus#ToHyperLogLogPlus()}.
   *   <li>When {@code foo}.
   *   <li>Then return sizeof is twenty-four.
   * </ul>
   *
   * <p>Method under test: {@link ToHyperLogLogPlus#apply(Object)}
   */
  @Test
  @DisplayName(
      "Test apply(Object); given ToHyperLogLogPlus(); when 'foo'; then return sizeof is twenty-four")
  @Tag("MaintainedByDiffblue")
  void testApply_givenToHyperLogLogPlus_whenFoo_thenReturnSizeofIsTwentyFour() throws IOException {
    // Arrange and Act
    HyperLogLogPlus actualApplyResult = new ToHyperLogLogPlus().apply("foo");

    // Assert
    assertEquals(24, actualApplyResult.sizeof());
    assertArrayEquals(
        new byte[] {-1, -1, -1, -2, 5, 5, 1, 1, -3, 18}, actualApplyResult.getBytes());
  }

  /**
   * Test {@link ToHyperLogLogPlus#apply(Object)}.
   *
   * <ul>
   *   <li>Given {@link ToHyperLogLogPlus#ToHyperLogLogPlus()}.
   *   <li>When {@link Integer#MIN_VALUE}.
   *   <li>Then return sizeof is twenty-four.
   * </ul>
   *
   * <p>Method under test: {@link ToHyperLogLogPlus#apply(Object)}
   */
  @Test
  @DisplayName(
      "Test apply(Object); given ToHyperLogLogPlus(); when MIN_VALUE; then return sizeof is twenty-four")
  @Tag("MaintainedByDiffblue")
  void testApply_givenToHyperLogLogPlus_whenMin_value_thenReturnSizeofIsTwentyFour()
      throws IOException {
    // Arrange and Act
    HyperLogLogPlus actualApplyResult = new ToHyperLogLogPlus().apply(Integer.MIN_VALUE);

    // Assert
    assertEquals(24, actualApplyResult.sizeof());
    assertArrayEquals(
        new byte[] {-1, -1, -1, -2, 5, 5, 1, 1, -3, 28}, actualApplyResult.getBytes());
  }

  /**
   * Test {@link ToHyperLogLogPlus#apply(Object)}.
   *
   * <ul>
   *   <li>Given {@link ToHyperLogLogPlus#ToHyperLogLogPlus()}.
   *   <li>When three.
   *   <li>Then return sizeof is twenty-four.
   * </ul>
   *
   * <p>Method under test: {@link ToHyperLogLogPlus#apply(Object)}
   */
  @Test
  @DisplayName(
      "Test apply(Object); given ToHyperLogLogPlus(); when three; then return sizeof is twenty-four")
  @Tag("MaintainedByDiffblue")
  void testApply_givenToHyperLogLogPlus_whenThree_thenReturnSizeofIsTwentyFour()
      throws IOException {
    // Arrange and Act
    HyperLogLogPlus actualApplyResult = new ToHyperLogLogPlus().apply(3);

    // Assert
    assertEquals(24, actualApplyResult.sizeof());
    assertArrayEquals(
        new byte[] {-1, -1, -1, -2, 5, 5, 1, 1, -9, '\f'}, actualApplyResult.getBytes());
  }
}
