package uk.gov.gchq.gaffer.sketches.clearspring.cardinality.serialisation.json;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.clearspring.analytics.stream.cardinality.HyperLogLogPlus;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class HyperLogLogPlusWithOffersDiffblueTest {
  /**
   * Test {@link HyperLogLogPlusWithOffers#getHyperLogLogPlus()}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@code 42}.
   *   <li>Then return sizeof is twenty-four.
   * </ul>
   *
   * <p>Method under test: {@link HyperLogLogPlusWithOffers#getHyperLogLogPlus()}
   */
  @Test
  @DisplayName(
      "Test getHyperLogLogPlus(); given ArrayList() add '42'; then return sizeof is twenty-four")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"HyperLogLogPlus HyperLogLogPlusWithOffers.getHyperLogLogPlus()"})
  void testGetHyperLogLogPlus_givenArrayListAdd42_thenReturnSizeofIsTwentyFour()
      throws IOException {
    // Arrange
    ArrayList<Object> offers = new ArrayList<>();
    offers.add("42");

    HyperLogLogPlusWithOffers hyperLogLogPlusWithOffers = new HyperLogLogPlusWithOffers();
    hyperLogLogPlusWithOffers.setOffers(offers);

    // Act
    HyperLogLogPlus actualHyperLogLogPlus = hyperLogLogPlusWithOffers.getHyperLogLogPlus();

    // Assert
    assertEquals(24, actualHyperLogLogPlus.sizeof());
    assertArrayEquals(
        new byte[] {-1, -1, -1, -2, 5, 5, 1, 1, -5, 23}, actualHyperLogLogPlus.getBytes());
  }

  /**
   * Test {@link HyperLogLogPlusWithOffers#getHyperLogLogPlus()}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@code 42}.
   *   <li>Then return sizeof is twenty-four.
   * </ul>
   *
   * <p>Method under test: {@link HyperLogLogPlusWithOffers#getHyperLogLogPlus()}
   */
  @Test
  @DisplayName(
      "Test getHyperLogLogPlus(); given ArrayList() add '42'; then return sizeof is twenty-four")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"HyperLogLogPlus HyperLogLogPlusWithOffers.getHyperLogLogPlus()"})
  void testGetHyperLogLogPlus_givenArrayListAdd42_thenReturnSizeofIsTwentyFour2()
      throws IOException {
    // Arrange
    ArrayList<Object> offers = new ArrayList<>();
    offers.add("42");
    offers.add("42");

    HyperLogLogPlusWithOffers hyperLogLogPlusWithOffers = new HyperLogLogPlusWithOffers();
    hyperLogLogPlusWithOffers.setOffers(offers);

    // Act
    HyperLogLogPlus actualHyperLogLogPlus = hyperLogLogPlusWithOffers.getHyperLogLogPlus();

    // Assert
    assertEquals(24, actualHyperLogLogPlus.sizeof());
    assertArrayEquals(
        new byte[] {-1, -1, -1, -2, 5, 5, 1, 1, -5, 23}, actualHyperLogLogPlus.getBytes());
  }

  /**
   * Test {@link HyperLogLogPlusWithOffers#getHyperLogLogPlus()}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add empty string.
   *   <li>Then return sizeof is twenty-four.
   * </ul>
   *
   * <p>Method under test: {@link HyperLogLogPlusWithOffers#getHyperLogLogPlus()}
   */
  @Test
  @DisplayName(
      "Test getHyperLogLogPlus(); given ArrayList() add empty string; then return sizeof is twenty-four")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"HyperLogLogPlus HyperLogLogPlusWithOffers.getHyperLogLogPlus()"})
  void testGetHyperLogLogPlus_givenArrayListAddEmptyString_thenReturnSizeofIsTwentyFour()
      throws IOException {
    // Arrange
    ArrayList<Object> offers = new ArrayList<>();
    offers.add("");

    HyperLogLogPlusWithOffers hyperLogLogPlusWithOffers = new HyperLogLogPlusWithOffers();
    hyperLogLogPlusWithOffers.setOffers(offers);

    // Act
    HyperLogLogPlus actualHyperLogLogPlus = hyperLogLogPlusWithOffers.getHyperLogLogPlus();

    // Assert
    assertEquals(24, actualHyperLogLogPlus.sizeof());
    assertArrayEquals(
        new byte[] {-1, -1, -1, -2, 5, 5, 1, 1, -5, 19}, actualHyperLogLogPlus.getBytes());
  }

  /**
   * Test {@link HyperLogLogPlusWithOffers#getHyperLogLogPlus()}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@code foo}.
   *   <li>Then return sizeof is twenty-four.
   * </ul>
   *
   * <p>Method under test: {@link HyperLogLogPlusWithOffers#getHyperLogLogPlus()}
   */
  @Test
  @DisplayName(
      "Test getHyperLogLogPlus(); given ArrayList() add 'foo'; then return sizeof is twenty-four")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"HyperLogLogPlus HyperLogLogPlusWithOffers.getHyperLogLogPlus()"})
  void testGetHyperLogLogPlus_givenArrayListAddFoo_thenReturnSizeofIsTwentyFour()
      throws IOException {
    // Arrange
    ArrayList<Object> offers = new ArrayList<>();
    offers.add("foo");

    HyperLogLogPlusWithOffers hyperLogLogPlusWithOffers = new HyperLogLogPlusWithOffers();
    hyperLogLogPlusWithOffers.setOffers(offers);

    // Act
    HyperLogLogPlus actualHyperLogLogPlus = hyperLogLogPlusWithOffers.getHyperLogLogPlus();

    // Assert
    assertEquals(24, actualHyperLogLogPlus.sizeof());
    assertArrayEquals(
        new byte[] {-1, -1, -1, -2, 5, 5, 1, 1, -3, 18}, actualHyperLogLogPlus.getBytes());
  }

  /**
   * Test {@link HyperLogLogPlusWithOffers#getHyperLogLogPlus()}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link Integer#MIN_VALUE}.
   *   <li>Then return sizeof is twenty-four.
   * </ul>
   *
   * <p>Method under test: {@link HyperLogLogPlusWithOffers#getHyperLogLogPlus()}
   */
  @Test
  @DisplayName(
      "Test getHyperLogLogPlus(); given ArrayList() add MIN_VALUE; then return sizeof is twenty-four")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"HyperLogLogPlus HyperLogLogPlusWithOffers.getHyperLogLogPlus()"})
  void testGetHyperLogLogPlus_givenArrayListAddMin_value_thenReturnSizeofIsTwentyFour()
      throws IOException {
    // Arrange
    ArrayList<Object> offers = new ArrayList<>();
    offers.add(Integer.MIN_VALUE);

    HyperLogLogPlusWithOffers hyperLogLogPlusWithOffers = new HyperLogLogPlusWithOffers();
    hyperLogLogPlusWithOffers.setOffers(offers);

    // Act
    HyperLogLogPlus actualHyperLogLogPlus = hyperLogLogPlusWithOffers.getHyperLogLogPlus();

    // Assert
    assertEquals(24, actualHyperLogLogPlus.sizeof());
    assertArrayEquals(
        new byte[] {-1, -1, -1, -2, 5, 5, 1, 1, -3, 28}, actualHyperLogLogPlus.getBytes());
  }

  /**
   * Test {@link HyperLogLogPlusWithOffers#getHyperLogLogPlus()}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@code null}.
   *   <li>Then return sizeof is twenty-four.
   * </ul>
   *
   * <p>Method under test: {@link HyperLogLogPlusWithOffers#getHyperLogLogPlus()}
   */
  @Test
  @DisplayName(
      "Test getHyperLogLogPlus(); given ArrayList() add 'null'; then return sizeof is twenty-four")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"HyperLogLogPlus HyperLogLogPlusWithOffers.getHyperLogLogPlus()"})
  void testGetHyperLogLogPlus_givenArrayListAddNull_thenReturnSizeofIsTwentyFour()
      throws IOException {
    // Arrange
    ArrayList<Object> offers = new ArrayList<>();
    offers.add(null);

    HyperLogLogPlusWithOffers hyperLogLogPlusWithOffers = new HyperLogLogPlusWithOffers();
    hyperLogLogPlusWithOffers.setOffers(offers);

    // Act
    HyperLogLogPlus actualHyperLogLogPlus = hyperLogLogPlusWithOffers.getHyperLogLogPlus();

    // Assert
    assertEquals(24, actualHyperLogLogPlus.sizeof());
    assertArrayEquals(new byte[] {-1, -1, -1, -2, 5, 5, 1, 1, 7}, actualHyperLogLogPlus.getBytes());
  }

  /**
   * Test {@link HyperLogLogPlusWithOffers#getHyperLogLogPlus()}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add two.
   *   <li>Then return sizeof is twenty-four.
   * </ul>
   *
   * <p>Method under test: {@link HyperLogLogPlusWithOffers#getHyperLogLogPlus()}
   */
  @Test
  @DisplayName(
      "Test getHyperLogLogPlus(); given ArrayList() add two; then return sizeof is twenty-four")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"HyperLogLogPlus HyperLogLogPlusWithOffers.getHyperLogLogPlus()"})
  void testGetHyperLogLogPlus_givenArrayListAddTwo_thenReturnSizeofIsTwentyFour()
      throws IOException {
    // Arrange
    ArrayList<Object> offers = new ArrayList<>();
    offers.add(2);

    HyperLogLogPlusWithOffers hyperLogLogPlusWithOffers = new HyperLogLogPlusWithOffers();
    hyperLogLogPlusWithOffers.setOffers(offers);

    // Act
    HyperLogLogPlus actualHyperLogLogPlus = hyperLogLogPlusWithOffers.getHyperLogLogPlus();

    // Assert
    assertEquals(24, actualHyperLogLogPlus.sizeof());
    assertArrayEquals(
        new byte[] {-1, -1, -1, -2, 5, 5, 1, 1, -5, 11}, actualHyperLogLogPlus.getBytes());
  }

  /**
   * Test {@link HyperLogLogPlusWithOffers#getHyperLogLogPlus()}.
   *
   * <ul>
   *   <li>Given {@link HyperLogLogPlusWithOffers} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link HyperLogLogPlusWithOffers#getHyperLogLogPlus()}
   */
  @Test
  @DisplayName("Test getHyperLogLogPlus(); given HyperLogLogPlusWithOffers (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"HyperLogLogPlus HyperLogLogPlusWithOffers.getHyperLogLogPlus()"})
  void testGetHyperLogLogPlus_givenHyperLogLogPlusWithOffers() throws IOException {
    // Arrange and Act
    HyperLogLogPlus actualHyperLogLogPlus = new HyperLogLogPlusWithOffers().getHyperLogLogPlus();

    // Assert
    assertEquals(24, actualHyperLogLogPlus.sizeof());
    assertArrayEquals(new byte[] {-1, -1, -1, -2, 5, 5, 1, 0}, actualHyperLogLogPlus.getBytes());
  }

  /**
   * Test {@link HyperLogLogPlusWithOffers#getHyperLogLogPlus()}.
   *
   * <ul>
   *   <li>Given {@link HyperLogLogPlusWithOffers} (default constructor) Sp is zero.
   * </ul>
   *
   * <p>Method under test: {@link HyperLogLogPlusWithOffers#getHyperLogLogPlus()}
   */
  @Test
  @DisplayName(
      "Test getHyperLogLogPlus(); given HyperLogLogPlusWithOffers (default constructor) Sp is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"HyperLogLogPlus HyperLogLogPlusWithOffers.getHyperLogLogPlus()"})
  void testGetHyperLogLogPlus_givenHyperLogLogPlusWithOffersSpIsZero() throws IOException {
    // Arrange
    HyperLogLogPlusWithOffers hyperLogLogPlusWithOffers = new HyperLogLogPlusWithOffers();
    hyperLogLogPlusWithOffers.setSp(0);

    // Act
    HyperLogLogPlus actualHyperLogLogPlus = hyperLogLogPlusWithOffers.getHyperLogLogPlus();

    // Assert
    assertEquals(24, actualHyperLogLogPlus.sizeof());
    assertArrayEquals(
        new byte[] {
          -1, -1, -1, -2, 5, 0, 0, 24, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
          0, 0, 0, 0
        },
        actualHyperLogLogPlus.getBytes());
  }

  /**
   * Test {@link HyperLogLogPlusWithOffers#getHyperLogLogPlus()}.
   *
   * <ul>
   *   <li>Given {@link HyperLogLogPlusWithOffers} (default constructor) Sp is zero.
   * </ul>
   *
   * <p>Method under test: {@link HyperLogLogPlusWithOffers#getHyperLogLogPlus()}
   */
  @Test
  @DisplayName(
      "Test getHyperLogLogPlus(); given HyperLogLogPlusWithOffers (default constructor) Sp is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"HyperLogLogPlus HyperLogLogPlusWithOffers.getHyperLogLogPlus()"})
  void testGetHyperLogLogPlus_givenHyperLogLogPlusWithOffersSpIsZero2() throws IOException {
    // Arrange
    ArrayList<Object> offers = new ArrayList<>();
    offers.add("42");

    HyperLogLogPlusWithOffers hyperLogLogPlusWithOffers = new HyperLogLogPlusWithOffers();
    hyperLogLogPlusWithOffers.setOffers(offers);
    hyperLogLogPlusWithOffers.setSp(0);

    // Act
    HyperLogLogPlus actualHyperLogLogPlus = hyperLogLogPlusWithOffers.getHyperLogLogPlus();

    // Assert
    assertEquals(24, actualHyperLogLogPlus.sizeof());
    assertArrayEquals(
        new byte[] {
          -1, -1, -1, -2, 5, 0, 0, 24, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 4, 0, 0, 0, 0, 0, 0, 0,
          0, 0, 0, 0
        },
        actualHyperLogLogPlus.getBytes());
  }

  /**
   * Test {@link HyperLogLogPlusWithOffers#getHyperLogLogPlus()}.
   *
   * <ul>
   *   <li>Then return sizeof is {@code 1431655768}.
   * </ul>
   *
   * <p>Method under test: {@link HyperLogLogPlusWithOffers#getHyperLogLogPlus()}
   */
  @Test
  @DisplayName("Test getHyperLogLogPlus(); then return sizeof is '1431655768'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"HyperLogLogPlus HyperLogLogPlusWithOffers.getHyperLogLogPlus()"})
  void testGetHyperLogLogPlus_thenReturnSizeofIs1431655768() throws IOException {
    // Arrange
    HyperLogLogPlusWithOffers hyperLogLogPlusWithOffers = new HyperLogLogPlusWithOffers();
    hyperLogLogPlusWithOffers.setHyperLogLogPlusSketchBytes(
        new byte[] {-1, 'X', 'A', 'X', 'A', 0, 'A', 0});

    // Act
    HyperLogLogPlus actualHyperLogLogPlus = hyperLogLogPlusWithOffers.getHyperLogLogPlus();

    // Assert
    assertEquals(1431655768, actualHyperLogLogPlus.sizeof());
    assertArrayEquals(new byte[] {-1, -1, -1, -2, 'A', 0, 1, 0}, actualHyperLogLogPlus.getBytes());
  }

  /**
   * Test {@link HyperLogLogPlusWithOffers#getHyperLogLogPlus()}.
   *
   * <ul>
   *   <li>Then return sizeof is zero.
   * </ul>
   *
   * <p>Method under test: {@link HyperLogLogPlusWithOffers#getHyperLogLogPlus()}
   */
  @Test
  @DisplayName("Test getHyperLogLogPlus(); then return sizeof is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"HyperLogLogPlus HyperLogLogPlusWithOffers.getHyperLogLogPlus()"})
  void testGetHyperLogLogPlus_thenReturnSizeofIsZero() throws IOException {
    // Arrange
    HyperLogLogPlusWithOffers hyperLogLogPlusWithOffers = new HyperLogLogPlusWithOffers();
    hyperLogLogPlusWithOffers.setHyperLogLogPlusSketchBytes(
        new byte[] {-1, 'X', 'A', 'X', 'A', 0, 0, 0});

    // Act
    HyperLogLogPlus actualHyperLogLogPlus = hyperLogLogPlusWithOffers.getHyperLogLogPlus();

    // Assert
    assertEquals(0, actualHyperLogLogPlus.sizeof());
    assertArrayEquals(new byte[] {-1, -1, -1, -2, 'A', 0, 0, 0}, actualHyperLogLogPlus.getBytes());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link HyperLogLogPlusWithOffers}
   *   <li>{@link HyperLogLogPlusWithOffers#setHyperLogLogPlusSketchBytes(byte[])}
   *   <li>{@link HyperLogLogPlusWithOffers#setOffers(List)}
   *   <li>{@link HyperLogLogPlusWithOffers#setP(int)}
   *   <li>{@link HyperLogLogPlusWithOffers#setSp(int)}
   *   <li>{@link HyperLogLogPlusWithOffers#getHyperLogLogPlusSketchBytes()}
   *   <li>{@link HyperLogLogPlusWithOffers#getOffers()}
   *   <li>{@link HyperLogLogPlusWithOffers#getP()}
   *   <li>{@link HyperLogLogPlusWithOffers#getSp()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void HyperLogLogPlusWithOffers.<init>()",
    "byte[] HyperLogLogPlusWithOffers.getHyperLogLogPlusSketchBytes()",
    "List HyperLogLogPlusWithOffers.getOffers()",
    "int HyperLogLogPlusWithOffers.getP()",
    "int HyperLogLogPlusWithOffers.getSp()",
    "void HyperLogLogPlusWithOffers.setHyperLogLogPlusSketchBytes(byte[])",
    "void HyperLogLogPlusWithOffers.setOffers(List)",
    "void HyperLogLogPlusWithOffers.setP(int)",
    "void HyperLogLogPlusWithOffers.setSp(int)"
  })
  void testGettersAndSetters() throws UnsupportedEncodingException {
    // Arrange and Act
    HyperLogLogPlusWithOffers actualHyperLogLogPlusWithOffers = new HyperLogLogPlusWithOffers();
    byte[] hyperLogLogPlusSketchBytes = "AXAXAXAX".getBytes("UTF-8");
    actualHyperLogLogPlusWithOffers.setHyperLogLogPlusSketchBytes(hyperLogLogPlusSketchBytes);
    ArrayList<Object> offers = new ArrayList<>();
    actualHyperLogLogPlusWithOffers.setOffers(offers);
    actualHyperLogLogPlusWithOffers.setP(3);
    actualHyperLogLogPlusWithOffers.setSp(3);
    byte[] actualHyperLogLogPlusSketchBytes =
        actualHyperLogLogPlusWithOffers.getHyperLogLogPlusSketchBytes();
    List<?> actualOffers = actualHyperLogLogPlusWithOffers.getOffers();
    int actualP = actualHyperLogLogPlusWithOffers.getP();

    // Assert
    assertEquals(3, actualP);
    assertEquals(3, actualHyperLogLogPlusWithOffers.getSp());
    assertTrue(actualOffers.isEmpty());
    assertSame(offers, actualOffers);
    assertSame(hyperLogLogPlusSketchBytes, actualHyperLogLogPlusSketchBytes);
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualHyperLogLogPlusSketchBytes);
  }
}
