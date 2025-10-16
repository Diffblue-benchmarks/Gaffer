package uk.gov.gchq.gaffer.time;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.time.CommonTimeUtil.TimeBucket;

class CommonTimeUtilDiffblueTest {
  /**
   * Test {@link CommonTimeUtil#timeToBucket(long, TimeBucket)}.
   *
   * <ul>
   *   <li>When {@code DAY}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link CommonTimeUtil#timeToBucket(long, TimeBucket)}
   */
  @Test
  @DisplayName("Test timeToBucket(long, TimeBucket); when 'DAY'; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long CommonTimeUtil.timeToBucket(long, TimeBucket)"})
  void testTimeToBucket_whenDay_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0L, CommonTimeUtil.timeToBucket(10L, TimeBucket.DAY));
  }

  /**
   * Test {@link CommonTimeUtil#timeToBucket(long, TimeBucket)}.
   *
   * <ul>
   *   <li>When {@code HOUR}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link CommonTimeUtil#timeToBucket(long, TimeBucket)}
   */
  @Test
  @DisplayName("Test timeToBucket(long, TimeBucket); when 'HOUR'; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long CommonTimeUtil.timeToBucket(long, TimeBucket)"})
  void testTimeToBucket_whenHour_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0L, CommonTimeUtil.timeToBucket(10L, TimeBucket.HOUR));
  }

  /**
   * Test {@link CommonTimeUtil#timeToBucket(long, TimeBucket)}.
   *
   * <ul>
   *   <li>When {@code MILLISECOND}.
   *   <li>Then return ten.
   * </ul>
   *
   * <p>Method under test: {@link CommonTimeUtil#timeToBucket(long, TimeBucket)}
   */
  @Test
  @DisplayName("Test timeToBucket(long, TimeBucket); when 'MILLISECOND'; then return ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long CommonTimeUtil.timeToBucket(long, TimeBucket)"})
  void testTimeToBucket_whenMillisecond_thenReturnTen() {
    // Arrange, Act and Assert
    assertEquals(10L, CommonTimeUtil.timeToBucket(10L, TimeBucket.MILLISECOND));
  }

  /**
   * Test {@link CommonTimeUtil#timeToBucket(long, TimeBucket)}.
   *
   * <ul>
   *   <li>When {@code MINUTE}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link CommonTimeUtil#timeToBucket(long, TimeBucket)}
   */
  @Test
  @DisplayName("Test timeToBucket(long, TimeBucket); when 'MINUTE'; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long CommonTimeUtil.timeToBucket(long, TimeBucket)"})
  void testTimeToBucket_whenMinute_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0L, CommonTimeUtil.timeToBucket(10L, TimeBucket.MINUTE));
  }

  /**
   * Test {@link CommonTimeUtil#timeToBucket(long, TimeBucket)}.
   *
   * <ul>
   *   <li>When {@code MONTH}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link CommonTimeUtil#timeToBucket(long, TimeBucket)}
   */
  @Test
  @DisplayName("Test timeToBucket(long, TimeBucket); when 'MONTH'; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long CommonTimeUtil.timeToBucket(long, TimeBucket)"})
  void testTimeToBucket_whenMonth_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0L, CommonTimeUtil.timeToBucket(10L, TimeBucket.MONTH));
  }

  /**
   * Test {@link CommonTimeUtil#timeToBucket(long, TimeBucket)}.
   *
   * <ul>
   *   <li>When {@code SECOND}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link CommonTimeUtil#timeToBucket(long, TimeBucket)}
   */
  @Test
  @DisplayName("Test timeToBucket(long, TimeBucket); when 'SECOND'; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long CommonTimeUtil.timeToBucket(long, TimeBucket)"})
  void testTimeToBucket_whenSecond_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0L, CommonTimeUtil.timeToBucket(10L, TimeBucket.SECOND));
  }

  /**
   * Test {@link CommonTimeUtil#timeToBucket(long, TimeBucket)}.
   *
   * <ul>
   *   <li>When {@code WEEK}.
   *   <li>Then return {@code -259200000}.
   * </ul>
   *
   * <p>Method under test: {@link CommonTimeUtil#timeToBucket(long, TimeBucket)}
   */
  @Test
  @DisplayName("Test timeToBucket(long, TimeBucket); when 'WEEK'; then return '-259200000'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long CommonTimeUtil.timeToBucket(long, TimeBucket)"})
  void testTimeToBucket_whenWeek_thenReturn259200000() {
    // Arrange, Act and Assert
    assertEquals(-259200000L, CommonTimeUtil.timeToBucket(10L, TimeBucket.WEEK));
  }

  /**
   * Test {@link CommonTimeUtil#timeToBucket(long, TimeBucket)}.
   *
   * <ul>
   *   <li>When {@code YEAR}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link CommonTimeUtil#timeToBucket(long, TimeBucket)}
   */
  @Test
  @DisplayName("Test timeToBucket(long, TimeBucket); when 'YEAR'; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long CommonTimeUtil.timeToBucket(long, TimeBucket)"})
  void testTimeToBucket_whenYear_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0L, CommonTimeUtil.timeToBucket(10L, TimeBucket.YEAR));
  }

  /**
   * Test {@link CommonTimeUtil#timeToBucketStart(long, TimeBucket)}.
   *
   * <ul>
   *   <li>When {@code DAY}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link CommonTimeUtil#timeToBucketStart(long, TimeBucket)}
   */
  @Test
  @DisplayName("Test timeToBucketStart(long, TimeBucket); when 'DAY'; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long CommonTimeUtil.timeToBucketStart(long, TimeBucket)"})
  void testTimeToBucketStart_whenDay_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0L, CommonTimeUtil.timeToBucketStart(10L, TimeBucket.DAY));
  }

  /**
   * Test {@link CommonTimeUtil#timeToBucketStart(long, TimeBucket)}.
   *
   * <ul>
   *   <li>When {@code HOUR}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link CommonTimeUtil#timeToBucketStart(long, TimeBucket)}
   */
  @Test
  @DisplayName("Test timeToBucketStart(long, TimeBucket); when 'HOUR'; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long CommonTimeUtil.timeToBucketStart(long, TimeBucket)"})
  void testTimeToBucketStart_whenHour_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0L, CommonTimeUtil.timeToBucketStart(10L, TimeBucket.HOUR));
  }

  /**
   * Test {@link CommonTimeUtil#timeToBucketStart(long, TimeBucket)}.
   *
   * <ul>
   *   <li>When {@code MILLISECOND}.
   *   <li>Then return ten.
   * </ul>
   *
   * <p>Method under test: {@link CommonTimeUtil#timeToBucketStart(long, TimeBucket)}
   */
  @Test
  @DisplayName("Test timeToBucketStart(long, TimeBucket); when 'MILLISECOND'; then return ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long CommonTimeUtil.timeToBucketStart(long, TimeBucket)"})
  void testTimeToBucketStart_whenMillisecond_thenReturnTen() {
    // Arrange, Act and Assert
    assertEquals(10L, CommonTimeUtil.timeToBucketStart(10L, TimeBucket.MILLISECOND));
  }

  /**
   * Test {@link CommonTimeUtil#timeToBucketStart(long, TimeBucket)}.
   *
   * <ul>
   *   <li>When {@code MINUTE}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link CommonTimeUtil#timeToBucketStart(long, TimeBucket)}
   */
  @Test
  @DisplayName("Test timeToBucketStart(long, TimeBucket); when 'MINUTE'; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long CommonTimeUtil.timeToBucketStart(long, TimeBucket)"})
  void testTimeToBucketStart_whenMinute_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0L, CommonTimeUtil.timeToBucketStart(10L, TimeBucket.MINUTE));
  }

  /**
   * Test {@link CommonTimeUtil#timeToBucketStart(long, TimeBucket)}.
   *
   * <ul>
   *   <li>When {@code MONTH}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link CommonTimeUtil#timeToBucketStart(long, TimeBucket)}
   */
  @Test
  @DisplayName("Test timeToBucketStart(long, TimeBucket); when 'MONTH'; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long CommonTimeUtil.timeToBucketStart(long, TimeBucket)"})
  void testTimeToBucketStart_whenMonth_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0L, CommonTimeUtil.timeToBucketStart(10L, TimeBucket.MONTH));
  }

  /**
   * Test {@link CommonTimeUtil#timeToBucketStart(long, TimeBucket)}.
   *
   * <ul>
   *   <li>When {@code SECOND}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link CommonTimeUtil#timeToBucketStart(long, TimeBucket)}
   */
  @Test
  @DisplayName("Test timeToBucketStart(long, TimeBucket); when 'SECOND'; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long CommonTimeUtil.timeToBucketStart(long, TimeBucket)"})
  void testTimeToBucketStart_whenSecond_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0L, CommonTimeUtil.timeToBucketStart(10L, TimeBucket.SECOND));
  }

  /**
   * Test {@link CommonTimeUtil#timeToBucketStart(long, TimeBucket)}.
   *
   * <ul>
   *   <li>When {@code WEEK}.
   *   <li>Then return {@code -259200000}.
   * </ul>
   *
   * <p>Method under test: {@link CommonTimeUtil#timeToBucketStart(long, TimeBucket)}
   */
  @Test
  @DisplayName("Test timeToBucketStart(long, TimeBucket); when 'WEEK'; then return '-259200000'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long CommonTimeUtil.timeToBucketStart(long, TimeBucket)"})
  void testTimeToBucketStart_whenWeek_thenReturn259200000() {
    // Arrange, Act and Assert
    assertEquals(-259200000L, CommonTimeUtil.timeToBucketStart(10L, TimeBucket.WEEK));
  }

  /**
   * Test {@link CommonTimeUtil#timeToBucketStart(long, TimeBucket)}.
   *
   * <ul>
   *   <li>When {@code YEAR}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link CommonTimeUtil#timeToBucketStart(long, TimeBucket)}
   */
  @Test
  @DisplayName("Test timeToBucketStart(long, TimeBucket); when 'YEAR'; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long CommonTimeUtil.timeToBucketStart(long, TimeBucket)"})
  void testTimeToBucketStart_whenYear_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0L, CommonTimeUtil.timeToBucketStart(10L, TimeBucket.YEAR));
  }

  /**
   * Test {@link CommonTimeUtil#timeToBucketEnd(long, TimeBucket)}.
   *
   * <ul>
   *   <li>When {@code DAY}.
   *   <li>Then return {@code 86399999}.
   * </ul>
   *
   * <p>Method under test: {@link CommonTimeUtil#timeToBucketEnd(long, TimeBucket)}
   */
  @Test
  @DisplayName("Test timeToBucketEnd(long, TimeBucket); when 'DAY'; then return '86399999'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long CommonTimeUtil.timeToBucketEnd(long, TimeBucket)"})
  void testTimeToBucketEnd_whenDay_thenReturn86399999() {
    // Arrange, Act and Assert
    assertEquals(86399999L, CommonTimeUtil.timeToBucketEnd(10L, TimeBucket.DAY));
  }

  /**
   * Test {@link CommonTimeUtil#timeToBucketEnd(long, TimeBucket)}.
   *
   * <ul>
   *   <li>When {@code HOUR}.
   *   <li>Then return {@code 3599999}.
   * </ul>
   *
   * <p>Method under test: {@link CommonTimeUtil#timeToBucketEnd(long, TimeBucket)}
   */
  @Test
  @DisplayName("Test timeToBucketEnd(long, TimeBucket); when 'HOUR'; then return '3599999'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long CommonTimeUtil.timeToBucketEnd(long, TimeBucket)"})
  void testTimeToBucketEnd_whenHour_thenReturn3599999() {
    // Arrange, Act and Assert
    assertEquals(3599999L, CommonTimeUtil.timeToBucketEnd(10L, TimeBucket.HOUR));
  }

  /**
   * Test {@link CommonTimeUtil#timeToBucketEnd(long, TimeBucket)}.
   *
   * <ul>
   *   <li>When {@code MILLISECOND}.
   *   <li>Then return ten.
   * </ul>
   *
   * <p>Method under test: {@link CommonTimeUtil#timeToBucketEnd(long, TimeBucket)}
   */
  @Test
  @DisplayName("Test timeToBucketEnd(long, TimeBucket); when 'MILLISECOND'; then return ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long CommonTimeUtil.timeToBucketEnd(long, TimeBucket)"})
  void testTimeToBucketEnd_whenMillisecond_thenReturnTen() {
    // Arrange, Act and Assert
    assertEquals(10L, CommonTimeUtil.timeToBucketEnd(10L, TimeBucket.MILLISECOND));
  }

  /**
   * Test {@link CommonTimeUtil#timeToBucketEnd(long, TimeBucket)}.
   *
   * <ul>
   *   <li>When {@code MINUTE}.
   *   <li>Then return {@code 59999}.
   * </ul>
   *
   * <p>Method under test: {@link CommonTimeUtil#timeToBucketEnd(long, TimeBucket)}
   */
  @Test
  @DisplayName("Test timeToBucketEnd(long, TimeBucket); when 'MINUTE'; then return '59999'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long CommonTimeUtil.timeToBucketEnd(long, TimeBucket)"})
  void testTimeToBucketEnd_whenMinute_thenReturn59999() {
    // Arrange, Act and Assert
    assertEquals(59999L, CommonTimeUtil.timeToBucketEnd(10L, TimeBucket.MINUTE));
  }

  /**
   * Test {@link CommonTimeUtil#timeToBucketEnd(long, TimeBucket)}.
   *
   * <ul>
   *   <li>When {@code MONTH}.
   *   <li>Then return {@code 2678399999}.
   * </ul>
   *
   * <p>Method under test: {@link CommonTimeUtil#timeToBucketEnd(long, TimeBucket)}
   */
  @Test
  @DisplayName("Test timeToBucketEnd(long, TimeBucket); when 'MONTH'; then return '2678399999'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long CommonTimeUtil.timeToBucketEnd(long, TimeBucket)"})
  void testTimeToBucketEnd_whenMonth_thenReturn2678399999() {
    // Arrange, Act and Assert
    assertEquals(2678399999L, CommonTimeUtil.timeToBucketEnd(10L, TimeBucket.MONTH));
  }

  /**
   * Test {@link CommonTimeUtil#timeToBucketEnd(long, TimeBucket)}.
   *
   * <ul>
   *   <li>When {@code SECOND}.
   *   <li>Then return nine hundred ninety-nine.
   * </ul>
   *
   * <p>Method under test: {@link CommonTimeUtil#timeToBucketEnd(long, TimeBucket)}
   */
  @Test
  @DisplayName(
      "Test timeToBucketEnd(long, TimeBucket); when 'SECOND'; then return nine hundred ninety-nine")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long CommonTimeUtil.timeToBucketEnd(long, TimeBucket)"})
  void testTimeToBucketEnd_whenSecond_thenReturnNineHundredNinetyNine() {
    // Arrange, Act and Assert
    assertEquals(999L, CommonTimeUtil.timeToBucketEnd(10L, TimeBucket.SECOND));
  }

  /**
   * Test {@link CommonTimeUtil#timeToBucketEnd(long, TimeBucket)}.
   *
   * <ul>
   *   <li>When {@code WEEK}.
   *   <li>Then return {@code 345599999}.
   * </ul>
   *
   * <p>Method under test: {@link CommonTimeUtil#timeToBucketEnd(long, TimeBucket)}
   */
  @Test
  @DisplayName("Test timeToBucketEnd(long, TimeBucket); when 'WEEK'; then return '345599999'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long CommonTimeUtil.timeToBucketEnd(long, TimeBucket)"})
  void testTimeToBucketEnd_whenWeek_thenReturn345599999() {
    // Arrange, Act and Assert
    assertEquals(345599999L, CommonTimeUtil.timeToBucketEnd(10L, TimeBucket.WEEK));
  }

  /**
   * Test {@link CommonTimeUtil#timeToBucketEnd(long, TimeBucket)}.
   *
   * <ul>
   *   <li>When {@code YEAR}.
   *   <li>Then return {@code 31535999999}.
   * </ul>
   *
   * <p>Method under test: {@link CommonTimeUtil#timeToBucketEnd(long, TimeBucket)}
   */
  @Test
  @DisplayName("Test timeToBucketEnd(long, TimeBucket); when 'YEAR'; then return '31535999999'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long CommonTimeUtil.timeToBucketEnd(long, TimeBucket)"})
  void testTimeToBucketEnd_whenYear_thenReturn31535999999() {
    // Arrange, Act and Assert
    assertEquals(31535999999L, CommonTimeUtil.timeToBucketEnd(10L, TimeBucket.YEAR));
  }
}
