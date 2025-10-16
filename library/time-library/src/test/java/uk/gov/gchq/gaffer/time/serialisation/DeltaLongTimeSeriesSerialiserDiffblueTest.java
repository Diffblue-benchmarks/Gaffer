package uk.gov.gchq.gaffer.time.serialisation;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.UnsupportedEncodingException;
import java.time.LocalDate;
import java.time.ZoneOffset;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.exception.SerialisationException;
import uk.gov.gchq.gaffer.time.CommonTimeUtil;
import uk.gov.gchq.gaffer.time.CommonTimeUtil.TimeBucket;
import uk.gov.gchq.gaffer.time.LongTimeSeries;

class DeltaLongTimeSeriesSerialiserDiffblueTest {
  /**
   * Test {@link DeltaLongTimeSeriesSerialiser#canHandle(Class)}.
   *
   * <ul>
   *   <li>When {@code Object}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link DeltaLongTimeSeriesSerialiser#canHandle(Class)}
   */
  @Test
  @DisplayName("Test canHandle(Class); when 'java.lang.Object'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DeltaLongTimeSeriesSerialiser.canHandle(Class)"})
  void testCanHandle_whenJavaLangObject_thenReturnFalse() {
    // Arrange
    DeltaLongTimeSeriesSerialiser deltaLongTimeSeriesSerialiser =
        new DeltaLongTimeSeriesSerialiser();
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertFalse(deltaLongTimeSeriesSerialiser.canHandle(clazz));
  }

  /**
   * Test {@link DeltaLongTimeSeriesSerialiser#canHandle(Class)}.
   *
   * <ul>
   *   <li>When {@code LongTimeSeries}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link DeltaLongTimeSeriesSerialiser#canHandle(Class)}
   */
  @Test
  @DisplayName(
      "Test canHandle(Class); when 'uk.gov.gchq.gaffer.time.LongTimeSeries'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DeltaLongTimeSeriesSerialiser.canHandle(Class)"})
  void testCanHandle_whenUkGovGchqGafferTimeLongTimeSeries_thenReturnTrue() {
    // Arrange
    DeltaLongTimeSeriesSerialiser deltaLongTimeSeriesSerialiser =
        new DeltaLongTimeSeriesSerialiser();
    Class<LongTimeSeries> clazz = LongTimeSeries.class;

    // Act and Assert
    assertTrue(deltaLongTimeSeriesSerialiser.canHandle(clazz));
  }

  /**
   * Test {@link DeltaLongTimeSeriesSerialiser#serialise(LongTimeSeries)} with {@code
   * LongTimeSeries}.
   *
   * <p>Method under test: {@link DeltaLongTimeSeriesSerialiser#serialise(LongTimeSeries)}
   */
  @Test
  @DisplayName("Test serialise(LongTimeSeries) with 'LongTimeSeries'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] DeltaLongTimeSeriesSerialiser.serialise(LongTimeSeries)"})
  void testSerialiseWithLongTimeSeries() throws SerialisationException {
    // Arrange
    DeltaLongTimeSeriesSerialiser deltaLongTimeSeriesSerialiser =
        new DeltaLongTimeSeriesSerialiser();

    LongTimeSeries timeSeries = new LongTimeSeries(TimeBucket.SECOND);
    timeSeries.put(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant(), 42L);

    // Act
    byte[] actualSerialiseResult = deltaLongTimeSeriesSerialiser.serialise(timeSeries);

    // Assert
    assertArrayEquals(new byte[] {0, 1, 1, 0, '*'}, actualSerialiseResult);
  }

  /**
   * Test {@link DeltaLongTimeSeriesSerialiser#serialise(LongTimeSeries)} with {@code
   * LongTimeSeries}.
   *
   * <ul>
   *   <li>Given {@code 86400000}.
   * </ul>
   *
   * <p>Method under test: {@link DeltaLongTimeSeriesSerialiser#serialise(LongTimeSeries)}
   */
  @Test
  @DisplayName("Test serialise(LongTimeSeries) with 'LongTimeSeries'; given '86400000'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] DeltaLongTimeSeriesSerialiser.serialise(LongTimeSeries)"})
  void testSerialiseWithLongTimeSeries_given86400000() throws SerialisationException {
    // Arrange
    DeltaLongTimeSeriesSerialiser deltaLongTimeSeriesSerialiser =
        new DeltaLongTimeSeriesSerialiser();

    LongTimeSeries timeSeries = new LongTimeSeries(TimeBucket.SECOND);
    timeSeries.put(
        LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant(), 86400000L);

    // Act
    byte[] actualSerialiseResult = deltaLongTimeSeriesSerialiser.serialise(timeSeries);

    // Assert
    assertArrayEquals(new byte[] {0, 1, 1, 0, -116, 5, '&', '\\', 0}, actualSerialiseResult);
  }

  /**
   * Test {@link DeltaLongTimeSeriesSerialiser#serialise(LongTimeSeries)} with {@code
   * LongTimeSeries}.
   *
   * <ul>
   *   <li>Given {@link Long#MAX_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link DeltaLongTimeSeriesSerialiser#serialise(LongTimeSeries)}
   */
  @Test
  @DisplayName("Test serialise(LongTimeSeries) with 'LongTimeSeries'; given MAX_VALUE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] DeltaLongTimeSeriesSerialiser.serialise(LongTimeSeries)"})
  void testSerialiseWithLongTimeSeries_givenMax_value() throws SerialisationException {
    // Arrange
    DeltaLongTimeSeriesSerialiser deltaLongTimeSeriesSerialiser =
        new DeltaLongTimeSeriesSerialiser();

    LongTimeSeries timeSeries = new LongTimeSeries(TimeBucket.SECOND);
    timeSeries.put(
        LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant(), Long.MAX_VALUE);

    // Act
    byte[] actualSerialiseResult = deltaLongTimeSeriesSerialiser.serialise(timeSeries);

    // Assert
    assertArrayEquals(
        new byte[] {0, 1, 0, 0, -120, Byte.MAX_VALUE, -1, -1, -1, -1, -1, -1, -1},
        actualSerialiseResult);
  }

  /**
   * Test {@link DeltaLongTimeSeriesSerialiser#serialise(LongTimeSeries)} with {@code
   * LongTimeSeries}.
   *
   * <ul>
   *   <li>Given {@link Long#MIN_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link DeltaLongTimeSeriesSerialiser#serialise(LongTimeSeries)}
   */
  @Test
  @DisplayName("Test serialise(LongTimeSeries) with 'LongTimeSeries'; given MIN_VALUE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] DeltaLongTimeSeriesSerialiser.serialise(LongTimeSeries)"})
  void testSerialiseWithLongTimeSeries_givenMin_value() throws SerialisationException {
    // Arrange
    DeltaLongTimeSeriesSerialiser deltaLongTimeSeriesSerialiser =
        new DeltaLongTimeSeriesSerialiser();

    LongTimeSeries timeSeries = new LongTimeSeries(TimeBucket.SECOND);
    timeSeries.put(
        LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant(), Long.MIN_VALUE);

    // Act
    byte[] actualSerialiseResult = deltaLongTimeSeriesSerialiser.serialise(timeSeries);

    // Assert
    assertArrayEquals(
        new byte[] {0, 1, 0, 0, Byte.MIN_VALUE, Byte.MAX_VALUE, -1, -1, -1, -1, -1, -1, -1},
        actualSerialiseResult);
  }

  /**
   * Test {@link DeltaLongTimeSeriesSerialiser#serialise(LongTimeSeries)} with {@code
   * LongTimeSeries}.
   *
   * <ul>
   *   <li>Then return array of {@code byte} with five and one.
   * </ul>
   *
   * <p>Method under test: {@link DeltaLongTimeSeriesSerialiser#serialise(LongTimeSeries)}
   */
  @Test
  @DisplayName(
      "Test serialise(LongTimeSeries) with 'LongTimeSeries'; then return array of byte with five and one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] DeltaLongTimeSeriesSerialiser.serialise(LongTimeSeries)"})
  void testSerialiseWithLongTimeSeries_thenReturnArrayOfByteWithFiveAndOne()
      throws SerialisationException {
    // Arrange
    DeltaLongTimeSeriesSerialiser deltaLongTimeSeriesSerialiser =
        new DeltaLongTimeSeriesSerialiser();

    LongTimeSeries timeSeries = new LongTimeSeries(TimeBucket.MONTH);
    timeSeries.put(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant(), 42L);

    // Act
    byte[] actualSerialiseResult = deltaLongTimeSeriesSerialiser.serialise(timeSeries);

    // Assert
    assertArrayEquals(new byte[] {5, 1, 1, 0, '*'}, actualSerialiseResult);
  }

  /**
   * Test {@link DeltaLongTimeSeriesSerialiser#serialise(LongTimeSeries)} with {@code
   * LongTimeSeries}.
   *
   * <ul>
   *   <li>Then return array of {@code byte} with four and one.
   * </ul>
   *
   * <p>Method under test: {@link DeltaLongTimeSeriesSerialiser#serialise(LongTimeSeries)}
   */
  @Test
  @DisplayName(
      "Test serialise(LongTimeSeries) with 'LongTimeSeries'; then return array of byte with four and one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] DeltaLongTimeSeriesSerialiser.serialise(LongTimeSeries)"})
  void testSerialiseWithLongTimeSeries_thenReturnArrayOfByteWithFourAndOne()
      throws SerialisationException {
    // Arrange
    DeltaLongTimeSeriesSerialiser deltaLongTimeSeriesSerialiser =
        new DeltaLongTimeSeriesSerialiser();

    LongTimeSeries timeSeries = new LongTimeSeries(TimeBucket.WEEK);
    timeSeries.put(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant(), 42L);

    // Act
    byte[] actualSerialiseResult = deltaLongTimeSeriesSerialiser.serialise(timeSeries);

    // Assert
    assertArrayEquals(new byte[] {4, 1, 1, -124, 15, 's', 19, -1, '*'}, actualSerialiseResult);
  }

  /**
   * Test {@link DeltaLongTimeSeriesSerialiser#serialise(LongTimeSeries)} with {@code
   * LongTimeSeries}.
   *
   * <ul>
   *   <li>Then return array of {@code byte} with one and one.
   * </ul>
   *
   * <p>Method under test: {@link DeltaLongTimeSeriesSerialiser#serialise(LongTimeSeries)}
   */
  @Test
  @DisplayName(
      "Test serialise(LongTimeSeries) with 'LongTimeSeries'; then return array of byte with one and one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] DeltaLongTimeSeriesSerialiser.serialise(LongTimeSeries)"})
  void testSerialiseWithLongTimeSeries_thenReturnArrayOfByteWithOneAndOne()
      throws SerialisationException {
    // Arrange
    DeltaLongTimeSeriesSerialiser deltaLongTimeSeriesSerialiser =
        new DeltaLongTimeSeriesSerialiser();

    LongTimeSeries timeSeries = new LongTimeSeries(TimeBucket.MINUTE);
    timeSeries.put(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant(), 42L);

    // Act
    byte[] actualSerialiseResult = deltaLongTimeSeriesSerialiser.serialise(timeSeries);

    // Assert
    assertArrayEquals(new byte[] {1, 1, 1, 0, '*'}, actualSerialiseResult);
  }

  /**
   * Test {@link DeltaLongTimeSeriesSerialiser#serialise(LongTimeSeries)} with {@code
   * LongTimeSeries}.
   *
   * <ul>
   *   <li>Then return array of {@code byte} with seven and one.
   * </ul>
   *
   * <p>Method under test: {@link DeltaLongTimeSeriesSerialiser#serialise(LongTimeSeries)}
   */
  @Test
  @DisplayName(
      "Test serialise(LongTimeSeries) with 'LongTimeSeries'; then return array of byte with seven and one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] DeltaLongTimeSeriesSerialiser.serialise(LongTimeSeries)"})
  void testSerialiseWithLongTimeSeries_thenReturnArrayOfByteWithSevenAndOne()
      throws SerialisationException {
    // Arrange
    DeltaLongTimeSeriesSerialiser deltaLongTimeSeriesSerialiser =
        new DeltaLongTimeSeriesSerialiser();

    LongTimeSeries timeSeries = new LongTimeSeries(TimeBucket.MILLISECOND);
    timeSeries.put(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant(), 42L);

    // Act
    byte[] actualSerialiseResult = deltaLongTimeSeriesSerialiser.serialise(timeSeries);

    // Assert
    assertArrayEquals(new byte[] {7, 1, 1, 0, '*'}, actualSerialiseResult);
  }

  /**
   * Test {@link DeltaLongTimeSeriesSerialiser#serialise(LongTimeSeries)} with {@code
   * LongTimeSeries}.
   *
   * <ul>
   *   <li>Then return array of {@code byte} with six and one.
   * </ul>
   *
   * <p>Method under test: {@link DeltaLongTimeSeriesSerialiser#serialise(LongTimeSeries)}
   */
  @Test
  @DisplayName(
      "Test serialise(LongTimeSeries) with 'LongTimeSeries'; then return array of byte with six and one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] DeltaLongTimeSeriesSerialiser.serialise(LongTimeSeries)"})
  void testSerialiseWithLongTimeSeries_thenReturnArrayOfByteWithSixAndOne()
      throws SerialisationException {
    // Arrange
    DeltaLongTimeSeriesSerialiser deltaLongTimeSeriesSerialiser =
        new DeltaLongTimeSeriesSerialiser();

    LongTimeSeries timeSeries = new LongTimeSeries(TimeBucket.YEAR);
    timeSeries.put(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant(), 42L);

    // Act
    byte[] actualSerialiseResult = deltaLongTimeSeriesSerialiser.serialise(timeSeries);

    // Assert
    assertArrayEquals(new byte[] {6, 1, 1, 0, '*'}, actualSerialiseResult);
  }

  /**
   * Test {@link DeltaLongTimeSeriesSerialiser#serialise(LongTimeSeries)} with {@code
   * LongTimeSeries}.
   *
   * <ul>
   *   <li>Then return array of {@code byte} with three and one.
   * </ul>
   *
   * <p>Method under test: {@link DeltaLongTimeSeriesSerialiser#serialise(LongTimeSeries)}
   */
  @Test
  @DisplayName(
      "Test serialise(LongTimeSeries) with 'LongTimeSeries'; then return array of byte with three and one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] DeltaLongTimeSeriesSerialiser.serialise(LongTimeSeries)"})
  void testSerialiseWithLongTimeSeries_thenReturnArrayOfByteWithThreeAndOne()
      throws SerialisationException {
    // Arrange
    DeltaLongTimeSeriesSerialiser deltaLongTimeSeriesSerialiser =
        new DeltaLongTimeSeriesSerialiser();

    LongTimeSeries timeSeries = new LongTimeSeries(TimeBucket.DAY);
    timeSeries.put(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant(), 42L);

    // Act
    byte[] actualSerialiseResult = deltaLongTimeSeriesSerialiser.serialise(timeSeries);

    // Assert
    assertArrayEquals(new byte[] {3, 1, 1, 0, '*'}, actualSerialiseResult);
  }

  /**
   * Test {@link DeltaLongTimeSeriesSerialiser#serialise(LongTimeSeries)} with {@code
   * LongTimeSeries}.
   *
   * <ul>
   *   <li>Then return array of {@code byte} with two and one.
   * </ul>
   *
   * <p>Method under test: {@link DeltaLongTimeSeriesSerialiser#serialise(LongTimeSeries)}
   */
  @Test
  @DisplayName(
      "Test serialise(LongTimeSeries) with 'LongTimeSeries'; then return array of byte with two and one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] DeltaLongTimeSeriesSerialiser.serialise(LongTimeSeries)"})
  void testSerialiseWithLongTimeSeries_thenReturnArrayOfByteWithTwoAndOne()
      throws SerialisationException {
    // Arrange
    DeltaLongTimeSeriesSerialiser deltaLongTimeSeriesSerialiser =
        new DeltaLongTimeSeriesSerialiser();

    LongTimeSeries timeSeries = new LongTimeSeries(TimeBucket.HOUR);
    timeSeries.put(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant(), 42L);

    // Act
    byte[] actualSerialiseResult = deltaLongTimeSeriesSerialiser.serialise(timeSeries);

    // Assert
    assertArrayEquals(new byte[] {2, 1, 1, 0, '*'}, actualSerialiseResult);
  }

  /**
   * Test {@link DeltaLongTimeSeriesSerialiser#serialise(LongTimeSeries)} with {@code
   * LongTimeSeries}.
   *
   * <ul>
   *   <li>Then return array of {@code byte} with zero and zero.
   * </ul>
   *
   * <p>Method under test: {@link DeltaLongTimeSeriesSerialiser#serialise(LongTimeSeries)}
   */
  @Test
  @DisplayName(
      "Test serialise(LongTimeSeries) with 'LongTimeSeries'; then return array of byte with zero and zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] DeltaLongTimeSeriesSerialiser.serialise(LongTimeSeries)"})
  void testSerialiseWithLongTimeSeries_thenReturnArrayOfByteWithZeroAndZero()
      throws SerialisationException {
    // Arrange
    DeltaLongTimeSeriesSerialiser deltaLongTimeSeriesSerialiser =
        new DeltaLongTimeSeriesSerialiser();

    // Act
    byte[] actualSerialiseResult =
        deltaLongTimeSeriesSerialiser.serialise(new LongTimeSeries(TimeBucket.SECOND));

    // Assert
    assertArrayEquals(new byte[] {0, 0, 1}, actualSerialiseResult);
  }

  /**
   * Test {@link DeltaLongTimeSeriesSerialiser#serialise(LongTimeSeries)} with {@code
   * LongTimeSeries}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return empty array of {@code byte}.
   * </ul>
   *
   * <p>Method under test: {@link DeltaLongTimeSeriesSerialiser#serialise(LongTimeSeries)}
   */
  @Test
  @DisplayName(
      "Test serialise(LongTimeSeries) with 'LongTimeSeries'; when 'null'; then return empty array of byte")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] DeltaLongTimeSeriesSerialiser.serialise(LongTimeSeries)"})
  void testSerialiseWithLongTimeSeries_whenNull_thenReturnEmptyArrayOfByte()
      throws SerialisationException {
    // Arrange, Act and Assert
    assertArrayEquals(new byte[] {}, new DeltaLongTimeSeriesSerialiser().serialise(null));
  }

  /**
   * Test {@link DeltaLongTimeSeriesSerialiser#deserialise(byte[], int, int)} with {@code allBytes},
   * {@code offset}, {@code length}.
   *
   * <ul>
   *   <li>When empty array of {@code byte}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DeltaLongTimeSeriesSerialiser#deserialise(byte[], int, int)}
   */
  @Test
  @DisplayName(
      "Test deserialise(byte[], int, int) with 'allBytes', 'offset', 'length'; when empty array of byte; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LongTimeSeries DeltaLongTimeSeriesSerialiser.deserialise(byte[], int, int)"})
  void testDeserialiseWithAllBytesOffsetLength_whenEmptyArrayOfByte_thenReturnNull()
      throws SerialisationException {
    // Arrange, Act and Assert
    assertNull(new DeltaLongTimeSeriesSerialiser().deserialise(new byte[] {}, 2, 3));
  }

  /**
   * Test {@link DeltaLongTimeSeriesSerialiser#deserialise(byte[], int, int)} with {@code allBytes},
   * {@code offset}, {@code length}.
   *
   * <ul>
   *   <li>When {@code X}.
   *   <li>Then return TimeBucket is {@code DAY}.
   * </ul>
   *
   * <p>Method under test: {@link DeltaLongTimeSeriesSerialiser#deserialise(byte[], int, int)}
   */
  @Test
  @DisplayName(
      "Test deserialise(byte[], int, int) with 'allBytes', 'offset', 'length'; when 'X'; then return TimeBucket is 'DAY'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LongTimeSeries DeltaLongTimeSeriesSerialiser.deserialise(byte[], int, int)"})
  void testDeserialiseWithAllBytesOffsetLength_whenX_thenReturnTimeBucketIsDay()
      throws SerialisationException {
    // Arrange and Act
    LongTimeSeries actualDeserialiseResult =
        new DeltaLongTimeSeriesSerialiser()
            .deserialise(new byte[] {'A', 'X', 3, 'X', 'A', 'X', 'A', 'X'}, 2, 3);

    // Assert
    assertEquals(1, actualDeserialiseResult.getTimeSeries().size());
    assertEquals(1, actualDeserialiseResult.getInstants().size());
    assertEquals(1, actualDeserialiseResult.getNumberOfInstants());
    assertEquals(TimeBucket.DAY, actualDeserialiseResult.getTimeBucket());
  }

  /**
   * Test {@link DeltaLongTimeSeriesSerialiser#deserialise(byte[], int, int)} with {@code allBytes},
   * {@code offset}, {@code length}.
   *
   * <ul>
   *   <li>When {@code X}.
   *   <li>Then return TimeBucket is {@code DAY}.
   * </ul>
   *
   * <p>Method under test: {@link DeltaLongTimeSeriesSerialiser#deserialise(byte[], int, int)}
   */
  @Test
  @DisplayName(
      "Test deserialise(byte[], int, int) with 'allBytes', 'offset', 'length'; when 'X'; then return TimeBucket is 'DAY'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LongTimeSeries DeltaLongTimeSeriesSerialiser.deserialise(byte[], int, int)"})
  void testDeserialiseWithAllBytesOffsetLength_whenX_thenReturnTimeBucketIsDay2()
      throws SerialisationException {
    // Arrange and Act
    LongTimeSeries actualDeserialiseResult =
        new DeltaLongTimeSeriesSerialiser()
            .deserialise(new byte[] {'A', 'X', 3, 'X', 0, 'X', 'A', 'X'}, 2, 3);

    // Assert
    assertEquals(1, actualDeserialiseResult.getTimeSeries().size());
    assertEquals(1, actualDeserialiseResult.getInstants().size());
    assertEquals(1, actualDeserialiseResult.getNumberOfInstants());
    assertEquals(TimeBucket.DAY, actualDeserialiseResult.getTimeBucket());
  }

  /**
   * Test {@link DeltaLongTimeSeriesSerialiser#deserialise(byte[], int, int)} with {@code allBytes},
   * {@code offset}, {@code length}.
   *
   * <ul>
   *   <li>When {@code X}.
   *   <li>Then return TimeBucket is {@code MINUTE}.
   * </ul>
   *
   * <p>Method under test: {@link DeltaLongTimeSeriesSerialiser#deserialise(byte[], int, int)}
   */
  @Test
  @DisplayName(
      "Test deserialise(byte[], int, int) with 'allBytes', 'offset', 'length'; when 'X'; then return TimeBucket is 'MINUTE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LongTimeSeries DeltaLongTimeSeriesSerialiser.deserialise(byte[], int, int)"})
  void testDeserialiseWithAllBytesOffsetLength_whenX_thenReturnTimeBucketIsMinute()
      throws SerialisationException {
    // Arrange and Act
    LongTimeSeries actualDeserialiseResult =
        new DeltaLongTimeSeriesSerialiser()
            .deserialise(new byte[] {'A', 'X', 1, 'X', 'A', 'X', 'A', 'X'}, 2, 3);

    // Assert
    assertEquals(1, actualDeserialiseResult.getTimeSeries().size());
    assertEquals(1, actualDeserialiseResult.getInstants().size());
    assertEquals(1, actualDeserialiseResult.getNumberOfInstants());
    assertEquals(TimeBucket.MINUTE, actualDeserialiseResult.getTimeBucket());
  }

  /**
   * Test {@link DeltaLongTimeSeriesSerialiser#deserialise(byte[], int, int)} with {@code allBytes},
   * {@code offset}, {@code length}.
   *
   * <ul>
   *   <li>When {@code X}.
   *   <li>Then return TimeBucket is {@code SECOND}.
   * </ul>
   *
   * <p>Method under test: {@link DeltaLongTimeSeriesSerialiser#deserialise(byte[], int, int)}
   */
  @Test
  @DisplayName(
      "Test deserialise(byte[], int, int) with 'allBytes', 'offset', 'length'; when 'X'; then return TimeBucket is 'SECOND'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LongTimeSeries DeltaLongTimeSeriesSerialiser.deserialise(byte[], int, int)"})
  void testDeserialiseWithAllBytesOffsetLength_whenX_thenReturnTimeBucketIsSecond()
      throws SerialisationException {
    // Arrange and Act
    LongTimeSeries actualDeserialiseResult =
        new DeltaLongTimeSeriesSerialiser()
            .deserialise(new byte[] {'A', 'X', 0, 'X', 'A', 'X', 'A', 'X'}, 2, 3);

    // Assert
    assertEquals(1, actualDeserialiseResult.getTimeSeries().size());
    assertEquals(1, actualDeserialiseResult.getInstants().size());
    assertEquals(1, actualDeserialiseResult.getNumberOfInstants());
    assertEquals(TimeBucket.SECOND, actualDeserialiseResult.getTimeBucket());
  }

  /**
   * Test {@link DeltaLongTimeSeriesSerialiser#deserialise(byte[], int, int)} with {@code allBytes},
   * {@code offset}, {@code length}.
   *
   * <ul>
   *   <li>When {@code X}.
   *   <li>Then throw {@link SerialisationException}.
   * </ul>
   *
   * <p>Method under test: {@link DeltaLongTimeSeriesSerialiser#deserialise(byte[], int, int)}
   */
  @Test
  @DisplayName(
      "Test deserialise(byte[], int, int) with 'allBytes', 'offset', 'length'; when 'X'; then throw SerialisationException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LongTimeSeries DeltaLongTimeSeriesSerialiser.deserialise(byte[], int, int)"})
  void testDeserialiseWithAllBytesOffsetLength_whenX_thenThrowSerialisationException()
      throws SerialisationException {
    // Arrange, Act and Assert
    assertThrows(
        SerialisationException.class,
        () ->
            new DeltaLongTimeSeriesSerialiser()
                .deserialise(new byte[] {'A', 'X', Byte.MIN_VALUE, 'X', 'A', 'X', 'A', 'X'}, 2, 3));
  }

  /**
   * Test {@link DeltaLongTimeSeriesSerialiser#deserialise(byte[], int, int)} with {@code allBytes},
   * {@code offset}, {@code length}.
   *
   * <ul>
   *   <li>When zero.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DeltaLongTimeSeriesSerialiser#deserialise(byte[], int, int)}
   */
  @Test
  @DisplayName(
      "Test deserialise(byte[], int, int) with 'allBytes', 'offset', 'length'; when zero; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LongTimeSeries DeltaLongTimeSeriesSerialiser.deserialise(byte[], int, int)"})
  void testDeserialiseWithAllBytesOffsetLength_whenZero_thenReturnNull()
      throws UnsupportedEncodingException, SerialisationException {
    // Arrange, Act and Assert
    assertNull(new DeltaLongTimeSeriesSerialiser().deserialise("AXAXAXAX".getBytes("UTF-8"), 2, 0));
  }

  /**
   * Test {@link DeltaLongTimeSeriesSerialiser#deserialise(byte[])} with {@code bytes}.
   *
   * <ul>
   *   <li>Then return TimeBucket is {@code SECOND}.
   * </ul>
   *
   * <p>Method under test: {@link DeltaLongTimeSeriesSerialiser#deserialise(byte[])}
   */
  @Test
  @DisplayName("Test deserialise(byte[]) with 'bytes'; then return TimeBucket is 'SECOND'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LongTimeSeries DeltaLongTimeSeriesSerialiser.deserialise(byte[])"})
  void testDeserialiseWithBytes_thenReturnTimeBucketIsSecond() throws SerialisationException {
    // Arrange and Act
    LongTimeSeries actualDeserialiseResult =
        new DeltaLongTimeSeriesSerialiser()
            .deserialise(new byte[] {0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Assert
    assertEquals(1, actualDeserialiseResult.getTimeSeries().size());
    assertEquals(1, actualDeserialiseResult.getInstants().size());
    assertEquals(1, actualDeserialiseResult.getNumberOfInstants());
    assertEquals(TimeBucket.SECOND, actualDeserialiseResult.getTimeBucket());
  }

  /**
   * Test {@link DeltaLongTimeSeriesSerialiser#deserialise(byte[])} with {@code bytes}.
   *
   * <ul>
   *   <li>Then return TimeSeries size is one.
   * </ul>
   *
   * <p>Method under test: {@link DeltaLongTimeSeriesSerialiser#deserialise(byte[])}
   */
  @Test
  @DisplayName("Test deserialise(byte[]) with 'bytes'; then return TimeSeries size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LongTimeSeries DeltaLongTimeSeriesSerialiser.deserialise(byte[])"})
  void testDeserialiseWithBytes_thenReturnTimeSeriesSizeIsOne() throws SerialisationException {
    // Arrange and Act
    LongTimeSeries actualDeserialiseResult =
        new DeltaLongTimeSeriesSerialiser()
            .deserialise(new byte[] {1, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Assert
    assertEquals(1, actualDeserialiseResult.getTimeSeries().size());
    assertEquals(1, actualDeserialiseResult.getInstants().size());
    assertEquals(1, actualDeserialiseResult.getNumberOfInstants());
    assertEquals(TimeBucket.MINUTE, actualDeserialiseResult.getTimeBucket());
  }

  /**
   * Test {@link DeltaLongTimeSeriesSerialiser#deserialise(byte[])} with {@code bytes}.
   *
   * <ul>
   *   <li>Then return TimeSeries size is two.
   * </ul>
   *
   * <p>Method under test: {@link DeltaLongTimeSeriesSerialiser#deserialise(byte[])}
   */
  @Test
  @DisplayName("Test deserialise(byte[]) with 'bytes'; then return TimeSeries size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LongTimeSeries DeltaLongTimeSeriesSerialiser.deserialise(byte[])"})
  void testDeserialiseWithBytes_thenReturnTimeSeriesSizeIsTwo() throws SerialisationException {
    // Arrange and Act
    LongTimeSeries actualDeserialiseResult =
        new DeltaLongTimeSeriesSerialiser()
            .deserialise(new byte[] {1, 'X', 0, 'X', 'A', 'X', 'A', 'X'});

    // Assert
    assertEquals(2, actualDeserialiseResult.getTimeSeries().size());
    assertEquals(2, actualDeserialiseResult.getInstants().size());
    assertEquals(2, actualDeserialiseResult.getNumberOfInstants());
    assertEquals(TimeBucket.MINUTE, actualDeserialiseResult.getTimeBucket());
  }

  /**
   * Test {@link DeltaLongTimeSeriesSerialiser#deserialise(byte[])} with {@code bytes}.
   *
   * <ul>
   *   <li>Then throw {@link SerialisationException}.
   * </ul>
   *
   * <p>Method under test: {@link DeltaLongTimeSeriesSerialiser#deserialise(byte[])}
   */
  @Test
  @DisplayName("Test deserialise(byte[]) with 'bytes'; then throw SerialisationException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LongTimeSeries DeltaLongTimeSeriesSerialiser.deserialise(byte[])"})
  void testDeserialiseWithBytes_thenThrowSerialisationException() throws SerialisationException {
    // Arrange, Act and Assert
    assertThrows(
        SerialisationException.class,
        () ->
            new DeltaLongTimeSeriesSerialiser()
                .deserialise(new byte[] {1, Byte.MIN_VALUE, 'A', 'X', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test {@link DeltaLongTimeSeriesSerialiser#deserialise(byte[])} with {@code bytes}.
   *
   * <ul>
   *   <li>When empty array of {@code byte}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DeltaLongTimeSeriesSerialiser#deserialise(byte[])}
   */
  @Test
  @DisplayName(
      "Test deserialise(byte[]) with 'bytes'; when empty array of byte; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LongTimeSeries DeltaLongTimeSeriesSerialiser.deserialise(byte[])"})
  void testDeserialiseWithBytes_whenEmptyArrayOfByte_thenReturnNull()
      throws SerialisationException {
    // Arrange and Act
    LongTimeSeries actualDeserialiseResult =
        new DeltaLongTimeSeriesSerialiser().deserialise(new byte[] {});

    // Assert
    assertNull(actualDeserialiseResult);
  }

  /**
   * Test {@link DeltaLongTimeSeriesSerialiser#deserialiseEmpty()}.
   *
   * <p>Method under test: {@link DeltaLongTimeSeriesSerialiser#deserialiseEmpty()}
   */
  @Test
  @DisplayName("Test deserialiseEmpty()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LongTimeSeries DeltaLongTimeSeriesSerialiser.deserialiseEmpty()"})
  void testDeserialiseEmpty() throws SerialisationException {
    // Arrange, Act and Assert
    assertNull(new DeltaLongTimeSeriesSerialiser().deserialiseEmpty());
  }

  /**
   * Test {@link DeltaLongTimeSeriesSerialiser#preservesObjectOrdering()}.
   *
   * <p>Method under test: {@link DeltaLongTimeSeriesSerialiser#preservesObjectOrdering()}
   */
  @Test
  @DisplayName("Test preservesObjectOrdering()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DeltaLongTimeSeriesSerialiser.preservesObjectOrdering()"})
  void testPreservesObjectOrdering() {
    // Arrange, Act and Assert
    assertFalse(new DeltaLongTimeSeriesSerialiser().preservesObjectOrdering());
  }

  /**
   * Test {@link DeltaLongTimeSeriesSerialiser#equals(Object)}, and {@link
   * DeltaLongTimeSeriesSerialiser#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link DeltaLongTimeSeriesSerialiser#equals(Object)}
   *   <li>{@link DeltaLongTimeSeriesSerialiser#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DeltaLongTimeSeriesSerialiser.equals(Object)",
    "int DeltaLongTimeSeriesSerialiser.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    DeltaLongTimeSeriesSerialiser deltaLongTimeSeriesSerialiser =
        new DeltaLongTimeSeriesSerialiser();
    DeltaLongTimeSeriesSerialiser deltaLongTimeSeriesSerialiser2 =
        new DeltaLongTimeSeriesSerialiser();

    // Act and Assert
    assertEquals(deltaLongTimeSeriesSerialiser, deltaLongTimeSeriesSerialiser2);
    assertEquals(
        deltaLongTimeSeriesSerialiser.hashCode(), deltaLongTimeSeriesSerialiser2.hashCode());
  }

  /**
   * Test {@link DeltaLongTimeSeriesSerialiser#equals(Object)}, and {@link
   * DeltaLongTimeSeriesSerialiser#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link DeltaLongTimeSeriesSerialiser#equals(Object)}
   *   <li>{@link DeltaLongTimeSeriesSerialiser#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DeltaLongTimeSeriesSerialiser.equals(Object)",
    "int DeltaLongTimeSeriesSerialiser.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    DeltaLongTimeSeriesSerialiser deltaLongTimeSeriesSerialiser =
        new DeltaLongTimeSeriesSerialiser();

    // Act and Assert
    assertEquals(deltaLongTimeSeriesSerialiser, deltaLongTimeSeriesSerialiser);
    int expectedHashCodeResult = deltaLongTimeSeriesSerialiser.hashCode();
    assertEquals(expectedHashCodeResult, deltaLongTimeSeriesSerialiser.hashCode());
  }

  /**
   * Test {@link DeltaLongTimeSeriesSerialiser#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DeltaLongTimeSeriesSerialiser#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DeltaLongTimeSeriesSerialiser.equals(Object)",
    "int DeltaLongTimeSeriesSerialiser.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new DeltaLongTimeSeriesSerialiser(), 1);
  }

  /**
   * Test {@link DeltaLongTimeSeriesSerialiser#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DeltaLongTimeSeriesSerialiser#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DeltaLongTimeSeriesSerialiser.equals(Object)",
    "int DeltaLongTimeSeriesSerialiser.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new DeltaLongTimeSeriesSerialiser(), null);
  }

  /**
   * Test {@link DeltaLongTimeSeriesSerialiser#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DeltaLongTimeSeriesSerialiser#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DeltaLongTimeSeriesSerialiser.equals(Object)",
    "int DeltaLongTimeSeriesSerialiser.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        new DeltaLongTimeSeriesSerialiser(), "Different type to DeltaLongTimeSeriesSerialiser");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link DeltaLongTimeSeriesSerialiser}
   *   <li>{@link DeltaLongTimeSeriesSerialiser#isConsistent()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DeltaLongTimeSeriesSerialiser.<init>()",
    "boolean DeltaLongTimeSeriesSerialiser.isConsistent()"
  })
  void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertTrue(new DeltaLongTimeSeriesSerialiser().isConsistent());
  }
}
