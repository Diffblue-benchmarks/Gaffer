package uk.gov.gchq.gaffer.time.function;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.Date;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.time.CommonTimeUtil;
import uk.gov.gchq.gaffer.time.CommonTimeUtil.TimeBucket;

class DateToTimeBucketEndDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link DateToTimeBucketEnd#DateToTimeBucketEnd()}
   *   <li>{@link DateToTimeBucketEnd#setBucket(TimeBucket)}
   *   <li>{@link DateToTimeBucketEnd#getBucket()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  void testGettersAndSetters() {
    // Arrange and Act
    DateToTimeBucketEnd actualDateToTimeBucketEnd = new DateToTimeBucketEnd();
    actualDateToTimeBucketEnd.setBucket(TimeBucket.SECOND);

    // Assert
    assertEquals(TimeBucket.SECOND, actualDateToTimeBucketEnd.getBucket());
  }

  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>When {@code SECOND}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link DateToTimeBucketEnd#DateToTimeBucketEnd(TimeBucket)}
   *   <li>{@link DateToTimeBucketEnd#setBucket(TimeBucket)}
   *   <li>{@link DateToTimeBucketEnd#getBucket()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; when 'SECOND'")
  @Tag("MaintainedByDiffblue")
  void testGettersAndSetters_whenSecond() {
    // Arrange and Act
    DateToTimeBucketEnd actualDateToTimeBucketEnd = new DateToTimeBucketEnd(TimeBucket.SECOND);
    actualDateToTimeBucketEnd.setBucket(TimeBucket.SECOND);

    // Assert
    assertEquals(TimeBucket.SECOND, actualDateToTimeBucketEnd.getBucket());
  }

  /**
   * Test {@link DateToTimeBucketEnd#apply(Date)} with {@code Date}.
   *
   * <ul>
   *   <li>Then return {@link SimpleDateFormat#SimpleDateFormat(String)} with {@code yyyy-MM-dd}
   *       format is {@code 1970-01-01}.
   * </ul>
   *
   * <p>Method under test: {@link DateToTimeBucketEnd#apply(Date)}
   */
  @Test
  @DisplayName(
      "Test apply(Date) with 'Date'; then return SimpleDateFormat(String) with 'yyyy-MM-dd' format is '1970-01-01'")
  @Tag("MaintainedByDiffblue")
  void testApplyWithDate_thenReturnSimpleDateFormatWithYyyyMmDdFormatIs19700101() {
    // Arrange
    DateToTimeBucketEnd dateToTimeBucketEnd = new DateToTimeBucketEnd(TimeBucket.DAY);

    // Act
    Date actualApplyResult =
        dateToTimeBucketEnd.apply(
            Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    // Assert
    String actualFormatResult = new SimpleDateFormat("yyyy-MM-dd").format(actualApplyResult);
    assertEquals("1970-01-01", actualFormatResult);
  }

  /**
   * Test {@link DateToTimeBucketEnd#apply(Date)} with {@code Date}.
   *
   * <ul>
   *   <li>Then return {@link SimpleDateFormat#SimpleDateFormat(String)} with {@code yyyy-MM-dd}
   *       format is {@code 1970-01-04}.
   * </ul>
   *
   * <p>Method under test: {@link DateToTimeBucketEnd#apply(Date)}
   */
  @Test
  @DisplayName(
      "Test apply(Date) with 'Date'; then return SimpleDateFormat(String) with 'yyyy-MM-dd' format is '1970-01-04'")
  @Tag("MaintainedByDiffblue")
  void testApplyWithDate_thenReturnSimpleDateFormatWithYyyyMmDdFormatIs19700104() {
    // Arrange
    DateToTimeBucketEnd dateToTimeBucketEnd = new DateToTimeBucketEnd(TimeBucket.WEEK);

    // Act
    Date actualApplyResult =
        dateToTimeBucketEnd.apply(
            Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    // Assert
    String actualFormatResult = new SimpleDateFormat("yyyy-MM-dd").format(actualApplyResult);
    assertEquals("1970-01-04", actualFormatResult);
  }

  /**
   * Test {@link DateToTimeBucketEnd#apply(Date)} with {@code Date}.
   *
   * <ul>
   *   <li>Then return {@link SimpleDateFormat#SimpleDateFormat(String)} with {@code yyyy-MM-dd}
   *       format is {@code 1970-01-31}.
   * </ul>
   *
   * <p>Method under test: {@link DateToTimeBucketEnd#apply(Date)}
   */
  @Test
  @DisplayName(
      "Test apply(Date) with 'Date'; then return SimpleDateFormat(String) with 'yyyy-MM-dd' format is '1970-01-31'")
  @Tag("MaintainedByDiffblue")
  void testApplyWithDate_thenReturnSimpleDateFormatWithYyyyMmDdFormatIs19700131() {
    // Arrange
    DateToTimeBucketEnd dateToTimeBucketEnd = new DateToTimeBucketEnd(TimeBucket.MONTH);

    // Act
    Date actualApplyResult =
        dateToTimeBucketEnd.apply(
            Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    // Assert
    String actualFormatResult = new SimpleDateFormat("yyyy-MM-dd").format(actualApplyResult);
    assertEquals("1970-01-31", actualFormatResult);
  }

  /**
   * Test {@link DateToTimeBucketEnd#apply(Date)} with {@code Date}.
   *
   * <ul>
   *   <li>Then return {@link SimpleDateFormat#SimpleDateFormat(String)} with {@code yyyy-MM-dd}
   *       format is {@code 1970-12-31}.
   * </ul>
   *
   * <p>Method under test: {@link DateToTimeBucketEnd#apply(Date)}
   */
  @Test
  @DisplayName(
      "Test apply(Date) with 'Date'; then return SimpleDateFormat(String) with 'yyyy-MM-dd' format is '1970-12-31'")
  @Tag("MaintainedByDiffblue")
  void testApplyWithDate_thenReturnSimpleDateFormatWithYyyyMmDdFormatIs19701231() {
    // Arrange
    DateToTimeBucketEnd dateToTimeBucketEnd = new DateToTimeBucketEnd(TimeBucket.YEAR);

    // Act
    Date actualApplyResult =
        dateToTimeBucketEnd.apply(
            Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    // Assert
    String actualFormatResult = new SimpleDateFormat("yyyy-MM-dd").format(actualApplyResult);
    assertEquals("1970-12-31", actualFormatResult);
  }

  /**
   * Test {@link DateToTimeBucketEnd#apply(Date)} with {@code Date}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DateToTimeBucketEnd#apply(Date)}
   */
  @Test
  @DisplayName("Test apply(Date) with 'Date'; when 'null'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  void testApplyWithDate_whenNull_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new DateToTimeBucketEnd(TimeBucket.SECOND).apply(null));
  }
}
