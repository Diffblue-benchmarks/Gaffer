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

package uk.gov.gchq.gaffer.time;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;
import org.junit.jupiter.api.Test;

class LongTimeSeriesDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link LongTimeSeries.Builder#build()}
   *   <li>default or parameterless constructor of {@link LongTimeSeries.Builder}
   *   <li>{@link LongTimeSeries.Builder#instantCountPairs(Map)}
   *   <li>{@link LongTimeSeries.Builder#timeBucket(CommonTimeUtil.TimeBucket)}
   * </ul>
   */
  @Test
  void testBuilderBuild() {
    // Arrange
    LongTimeSeries.Builder builder = new LongTimeSeries.Builder();

    // Act
    LongTimeSeries actualBuildResult = builder.instantCountPairs(new HashMap<>())
        .timeBucket(CommonTimeUtil.TimeBucket.SECOND)
        .build();

    // Assert
    assertEquals(0, actualBuildResult.getNumberOfInstants());
    assertEquals(CommonTimeUtil.TimeBucket.SECOND, actualBuildResult.getTimeBucket());
  }

  /**
   * Method under test: {@link LongTimeSeries#put(Instant, Long)}
   */
  @Test
  void testPut() {
    // Arrange
    LongTimeSeries longTimeSeries = new LongTimeSeries(CommonTimeUtil.TimeBucket.SECOND);

    // Act
    longTimeSeries.put(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant(), 42L);

    // Assert
    assertEquals(1, longTimeSeries.getTimeSeries().size());
    assertEquals(1, longTimeSeries.getInstants().size());
    assertEquals(1, longTimeSeries.getNumberOfInstants());
  }

  /**
   * Method under test: {@link LongTimeSeries#put(Instant, Long)}
   */
  @Test
  void testPut2() {
    // Arrange
    LongTimeSeries longTimeSeries = new LongTimeSeries(CommonTimeUtil.TimeBucket.MINUTE);

    // Act
    longTimeSeries.put(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant(), 42L);

    // Assert
    assertEquals(1, longTimeSeries.getTimeSeries().size());
    assertEquals(1, longTimeSeries.getInstants().size());
    assertEquals(1, longTimeSeries.getNumberOfInstants());
  }

  /**
   * Method under test: {@link LongTimeSeries#put(Instant, Long)}
   */
  @Test
  void testPut3() {
    // Arrange
    LongTimeSeries longTimeSeries = new LongTimeSeries(CommonTimeUtil.TimeBucket.HOUR);

    // Act
    longTimeSeries.put(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant(), 42L);

    // Assert
    assertEquals(1, longTimeSeries.getTimeSeries().size());
    assertEquals(1, longTimeSeries.getInstants().size());
    assertEquals(1, longTimeSeries.getNumberOfInstants());
  }

  /**
   * Method under test: {@link LongTimeSeries#put(Instant, Long)}
   */
  @Test
  void testPut4() {
    // Arrange
    LongTimeSeries longTimeSeries = new LongTimeSeries(CommonTimeUtil.TimeBucket.DAY);

    // Act
    longTimeSeries.put(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant(), 42L);

    // Assert
    assertEquals(1, longTimeSeries.getTimeSeries().size());
    assertEquals(1, longTimeSeries.getInstants().size());
    assertEquals(1, longTimeSeries.getNumberOfInstants());
  }

  /**
   * Method under test: {@link LongTimeSeries#put(Instant, Long)}
   */
  @Test
  void testPut5() {
    // Arrange
    LongTimeSeries longTimeSeries = new LongTimeSeries(CommonTimeUtil.TimeBucket.WEEK);

    // Act
    longTimeSeries.put(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant(), 42L);

    // Assert
    assertEquals(1, longTimeSeries.getTimeSeries().size());
    assertEquals(1, longTimeSeries.getInstants().size());
    assertEquals(1, longTimeSeries.getNumberOfInstants());
  }

  /**
   * Method under test: {@link LongTimeSeries#put(Instant, Long)}
   */
  @Test
  void testPut6() {
    // Arrange
    LongTimeSeries longTimeSeries = new LongTimeSeries(CommonTimeUtil.TimeBucket.MONTH);

    // Act
    longTimeSeries.put(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant(), 42L);

    // Assert
    assertEquals(1, longTimeSeries.getTimeSeries().size());
    assertEquals(1, longTimeSeries.getInstants().size());
    assertEquals(1, longTimeSeries.getNumberOfInstants());
  }

  /**
   * Method under test: {@link LongTimeSeries#put(Instant, Long)}
   */
  @Test
  void testPut7() {
    // Arrange
    LongTimeSeries longTimeSeries = new LongTimeSeries(CommonTimeUtil.TimeBucket.YEAR);

    // Act
    longTimeSeries.put(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant(), 42L);

    // Assert
    assertEquals(1, longTimeSeries.getTimeSeries().size());
    assertEquals(1, longTimeSeries.getInstants().size());
    assertEquals(1, longTimeSeries.getNumberOfInstants());
  }

  /**
   * Method under test: {@link LongTimeSeries#put(Instant, Long)}
   */
  @Test
  void testPut8() {
    // Arrange
    LongTimeSeries longTimeSeries = new LongTimeSeries(CommonTimeUtil.TimeBucket.MILLISECOND);

    // Act
    longTimeSeries.put(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant(), 42L);

    // Assert
    assertEquals(1, longTimeSeries.getTimeSeries().size());
    assertEquals(1, longTimeSeries.getInstants().size());
    assertEquals(1, longTimeSeries.getNumberOfInstants());
  }

  /**
   * Method under test: {@link LongTimeSeries#get(Instant)}
   */
  @Test
  void testGet() {
    // Arrange
    LongTimeSeries longTimeSeries = new LongTimeSeries(CommonTimeUtil.TimeBucket.SECOND);

    // Act and Assert
    assertNull(longTimeSeries.get(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
  }

  /**
   * Method under test: {@link LongTimeSeries#get(Instant)}
   */
  @Test
  void testGet2() {
    // Arrange
    LongTimeSeries longTimeSeries = new LongTimeSeries(CommonTimeUtil.TimeBucket.MINUTE);

    // Act and Assert
    assertNull(longTimeSeries.get(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
  }

  /**
   * Method under test: {@link LongTimeSeries#get(Instant)}
   */
  @Test
  void testGet3() {
    // Arrange
    LongTimeSeries longTimeSeries = new LongTimeSeries(CommonTimeUtil.TimeBucket.HOUR);

    // Act and Assert
    assertNull(longTimeSeries.get(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
  }

  /**
   * Method under test: {@link LongTimeSeries#get(Instant)}
   */
  @Test
  void testGet4() {
    // Arrange
    LongTimeSeries longTimeSeries = new LongTimeSeries(CommonTimeUtil.TimeBucket.DAY);

    // Act and Assert
    assertNull(longTimeSeries.get(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
  }

  /**
   * Method under test: {@link LongTimeSeries#get(Instant)}
   */
  @Test
  void testGet5() {
    // Arrange
    LongTimeSeries longTimeSeries = new LongTimeSeries(CommonTimeUtil.TimeBucket.WEEK);

    // Act and Assert
    assertNull(longTimeSeries.get(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
  }

  /**
   * Method under test: {@link LongTimeSeries#get(Instant)}
   */
  @Test
  void testGet6() {
    // Arrange
    LongTimeSeries longTimeSeries = new LongTimeSeries(CommonTimeUtil.TimeBucket.MONTH);

    // Act and Assert
    assertNull(longTimeSeries.get(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
  }

  /**
   * Method under test: {@link LongTimeSeries#get(Instant)}
   */
  @Test
  void testGet7() {
    // Arrange
    LongTimeSeries longTimeSeries = new LongTimeSeries(CommonTimeUtil.TimeBucket.YEAR);

    // Act and Assert
    assertNull(longTimeSeries.get(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
  }

  /**
   * Method under test: {@link LongTimeSeries#get(Instant)}
   */
  @Test
  void testGet8() {
    // Arrange
    LongTimeSeries longTimeSeries = new LongTimeSeries(CommonTimeUtil.TimeBucket.MILLISECOND);

    // Act and Assert
    assertNull(longTimeSeries.get(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
  }

  /**
   * Method under test: {@link LongTimeSeries#upsert(Instant, long)}
   */
  @Test
  void testUpsert() {
    // Arrange
    LongTimeSeries longTimeSeries = new LongTimeSeries(CommonTimeUtil.TimeBucket.SECOND);

    // Act
    longTimeSeries.upsert(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant(), 3L);

    // Assert
    assertEquals(1, longTimeSeries.getTimeSeries().size());
    assertEquals(1, longTimeSeries.getInstants().size());
    assertEquals(1, longTimeSeries.getNumberOfInstants());
  }

  /**
   * Method under test: {@link LongTimeSeries#upsert(Instant, long)}
   */
  @Test
  void testUpsert2() {
    // Arrange
    LongTimeSeries longTimeSeries = new LongTimeSeries(CommonTimeUtil.TimeBucket.MINUTE);

    // Act
    longTimeSeries.upsert(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant(), 3L);

    // Assert
    assertEquals(1, longTimeSeries.getTimeSeries().size());
    assertEquals(1, longTimeSeries.getInstants().size());
    assertEquals(1, longTimeSeries.getNumberOfInstants());
  }

  /**
   * Method under test: {@link LongTimeSeries#upsert(Instant, long)}
   */
  @Test
  void testUpsert3() {
    // Arrange
    LongTimeSeries longTimeSeries = new LongTimeSeries(CommonTimeUtil.TimeBucket.HOUR);

    // Act
    longTimeSeries.upsert(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant(), 3L);

    // Assert
    assertEquals(1, longTimeSeries.getTimeSeries().size());
    assertEquals(1, longTimeSeries.getInstants().size());
    assertEquals(1, longTimeSeries.getNumberOfInstants());
  }

  /**
   * Method under test: {@link LongTimeSeries#upsert(Instant, long)}
   */
  @Test
  void testUpsert4() {
    // Arrange
    LongTimeSeries longTimeSeries = new LongTimeSeries(CommonTimeUtil.TimeBucket.DAY);

    // Act
    longTimeSeries.upsert(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant(), 3L);

    // Assert
    assertEquals(1, longTimeSeries.getTimeSeries().size());
    assertEquals(1, longTimeSeries.getInstants().size());
    assertEquals(1, longTimeSeries.getNumberOfInstants());
  }

  /**
   * Method under test: {@link LongTimeSeries#upsert(Instant, long)}
   */
  @Test
  void testUpsert5() {
    // Arrange
    LongTimeSeries longTimeSeries = new LongTimeSeries(CommonTimeUtil.TimeBucket.SECOND);
    longTimeSeries.put(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant(), 42L);

    // Act
    longTimeSeries.upsert(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant(), 3L);

    // Assert
    assertEquals(1, longTimeSeries.getTimeSeries().size());
    assertEquals(1, longTimeSeries.getInstants().size());
    assertEquals(1, longTimeSeries.getNumberOfInstants());
  }

  /**
   * Method under test: {@link LongTimeSeries#upsert(Instant, long)}
   */
  @Test
  void testUpsert6() {
    // Arrange
    LongTimeSeries longTimeSeries = new LongTimeSeries(CommonTimeUtil.TimeBucket.WEEK);

    // Act
    longTimeSeries.upsert(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant(), 3L);

    // Assert
    assertEquals(1, longTimeSeries.getTimeSeries().size());
    assertEquals(1, longTimeSeries.getInstants().size());
    assertEquals(1, longTimeSeries.getNumberOfInstants());
  }

  /**
   * Method under test: {@link LongTimeSeries#upsert(Instant, long)}
   */
  @Test
  void testUpsert7() {
    // Arrange
    LongTimeSeries longTimeSeries = new LongTimeSeries(CommonTimeUtil.TimeBucket.MONTH);

    // Act
    longTimeSeries.upsert(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant(), 3L);

    // Assert
    assertEquals(1, longTimeSeries.getTimeSeries().size());
    assertEquals(1, longTimeSeries.getInstants().size());
    assertEquals(1, longTimeSeries.getNumberOfInstants());
  }

  /**
   * Method under test: {@link LongTimeSeries#upsert(Instant, long)}
   */
  @Test
  void testUpsert8() {
    // Arrange
    LongTimeSeries longTimeSeries = new LongTimeSeries(CommonTimeUtil.TimeBucket.YEAR);

    // Act
    longTimeSeries.upsert(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant(), 3L);

    // Assert
    assertEquals(1, longTimeSeries.getTimeSeries().size());
    assertEquals(1, longTimeSeries.getInstants().size());
    assertEquals(1, longTimeSeries.getNumberOfInstants());
  }

  /**
   * Method under test: {@link LongTimeSeries#upsert(Instant, long)}
   */
  @Test
  void testUpsert9() {
    // Arrange
    LongTimeSeries longTimeSeries = new LongTimeSeries(CommonTimeUtil.TimeBucket.MILLISECOND);

    // Act
    longTimeSeries.upsert(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant(), 3L);

    // Assert
    assertEquals(1, longTimeSeries.getTimeSeries().size());
    assertEquals(1, longTimeSeries.getInstants().size());
    assertEquals(1, longTimeSeries.getNumberOfInstants());
  }

  /**
   * Method under test: {@link LongTimeSeries#getInstants()}
   */
  @Test
  void testGetInstants() {
    // Arrange, Act and Assert
    assertTrue((new LongTimeSeries(CommonTimeUtil.TimeBucket.SECOND)).getInstants().isEmpty());
  }

  /**
   * Method under test: {@link LongTimeSeries#getInstants()}
   */
  @Test
  void testGetInstants2() {
    // Arrange
    LongTimeSeries longTimeSeries = new LongTimeSeries(CommonTimeUtil.TimeBucket.SECOND);
    longTimeSeries.put(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant(), 42L);

    // Act and Assert
    assertEquals(1, longTimeSeries.getInstants().size());
  }

  /**
   * Method under test: {@link LongTimeSeries#getInstants()}
   */
  @Test
  void testGetInstants3() {
    // Arrange
    LongTimeSeries longTimeSeries = new LongTimeSeries(CommonTimeUtil.TimeBucket.MINUTE);
    longTimeSeries.put(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant(), 42L);

    // Act and Assert
    assertEquals(1, longTimeSeries.getInstants().size());
  }

  /**
   * Method under test: {@link LongTimeSeries#getInstants()}
   */
  @Test
  void testGetInstants4() {
    // Arrange
    LongTimeSeries longTimeSeries = new LongTimeSeries(CommonTimeUtil.TimeBucket.HOUR);
    longTimeSeries.put(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant(), 42L);

    // Act and Assert
    assertEquals(1, longTimeSeries.getInstants().size());
  }

  /**
   * Method under test: {@link LongTimeSeries#getInstants()}
   */
  @Test
  void testGetInstants5() {
    // Arrange
    LongTimeSeries longTimeSeries = new LongTimeSeries(CommonTimeUtil.TimeBucket.DAY);
    longTimeSeries.put(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant(), 42L);

    // Act and Assert
    assertEquals(1, longTimeSeries.getInstants().size());
  }

  /**
   * Method under test: {@link LongTimeSeries#getInstants()}
   */
  @Test
  void testGetInstants6() {
    // Arrange
    LongTimeSeries longTimeSeries = new LongTimeSeries(CommonTimeUtil.TimeBucket.WEEK);
    longTimeSeries.put(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant(), 42L);

    // Act and Assert
    assertEquals(1, longTimeSeries.getInstants().size());
  }

  /**
   * Method under test: {@link LongTimeSeries#getInstants()}
   */
  @Test
  void testGetInstants7() {
    // Arrange
    LongTimeSeries longTimeSeries = new LongTimeSeries(CommonTimeUtil.TimeBucket.MONTH);
    longTimeSeries.put(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant(), 42L);

    // Act and Assert
    assertEquals(1, longTimeSeries.getInstants().size());
  }

  /**
   * Method under test: {@link LongTimeSeries#getInstants()}
   */
  @Test
  void testGetInstants8() {
    // Arrange
    LongTimeSeries longTimeSeries = new LongTimeSeries(CommonTimeUtil.TimeBucket.YEAR);
    longTimeSeries.put(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant(), 42L);

    // Act and Assert
    assertEquals(1, longTimeSeries.getInstants().size());
  }

  /**
   * Method under test: {@link LongTimeSeries#getInstants()}
   */
  @Test
  void testGetInstants9() {
    // Arrange
    LongTimeSeries longTimeSeries = new LongTimeSeries(CommonTimeUtil.TimeBucket.MILLISECOND);
    longTimeSeries.put(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant(), 42L);

    // Act and Assert
    assertEquals(1, longTimeSeries.getInstants().size());
  }

  /**
   * Method under test: {@link LongTimeSeries#getNumberOfInstants()}
   */
  @Test
  void testGetNumberOfInstants() {
    // Arrange, Act and Assert
    assertEquals(0, (new LongTimeSeries(CommonTimeUtil.TimeBucket.SECOND)).getNumberOfInstants());
  }

  /**
   * Method under test: {@link LongTimeSeries#getNumberOfInstants()}
   */
  @Test
  void testGetNumberOfInstants2() {
    // Arrange
    HashMap<Instant, Long> timeSeries = new HashMap<>();
    timeSeries.computeIfPresent(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant(),
        mock(BiFunction.class));

    // Act and Assert
    assertEquals(0, (new LongTimeSeries(CommonTimeUtil.TimeBucket.SECOND, timeSeries)).getNumberOfInstants());
  }

  /**
   * Method under test: {@link LongTimeSeries#getTimeSeries()}
   */
  @Test
  void testGetTimeSeries() {
    // Arrange, Act and Assert
    assertTrue((new LongTimeSeries(CommonTimeUtil.TimeBucket.SECOND)).getTimeSeries().isEmpty());
  }

  /**
   * Method under test: {@link LongTimeSeries#getTimeSeries()}
   */
  @Test
  void testGetTimeSeries2() {
    // Arrange
    LongTimeSeries longTimeSeries = new LongTimeSeries(CommonTimeUtil.TimeBucket.SECOND);
    longTimeSeries.put(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant(), 42L);

    // Act and Assert
    assertEquals(1, longTimeSeries.getTimeSeries().size());
  }

  /**
   * Method under test: {@link LongTimeSeries#getTimeSeries()}
   */
  @Test
  void testGetTimeSeries3() {
    // Arrange
    LongTimeSeries longTimeSeries = new LongTimeSeries(CommonTimeUtil.TimeBucket.MINUTE);
    longTimeSeries.put(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant(), 42L);

    // Act and Assert
    assertEquals(1, longTimeSeries.getTimeSeries().size());
  }

  /**
   * Method under test: {@link LongTimeSeries#getTimeSeries()}
   */
  @Test
  void testGetTimeSeries4() {
    // Arrange
    LongTimeSeries longTimeSeries = new LongTimeSeries(CommonTimeUtil.TimeBucket.HOUR);
    longTimeSeries.put(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant(), 42L);

    // Act and Assert
    assertEquals(1, longTimeSeries.getTimeSeries().size());
  }

  /**
   * Method under test: {@link LongTimeSeries#getTimeSeries()}
   */
  @Test
  void testGetTimeSeries5() {
    // Arrange
    LongTimeSeries longTimeSeries = new LongTimeSeries(CommonTimeUtil.TimeBucket.DAY);
    longTimeSeries.put(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant(), 42L);

    // Act and Assert
    assertEquals(1, longTimeSeries.getTimeSeries().size());
  }

  /**
   * Method under test: {@link LongTimeSeries#getTimeSeries()}
   */
  @Test
  void testGetTimeSeries6() {
    // Arrange
    LongTimeSeries longTimeSeries = new LongTimeSeries(CommonTimeUtil.TimeBucket.WEEK);
    longTimeSeries.put(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant(), 42L);

    // Act and Assert
    assertEquals(1, longTimeSeries.getTimeSeries().size());
  }

  /**
   * Method under test: {@link LongTimeSeries#getTimeSeries()}
   */
  @Test
  void testGetTimeSeries7() {
    // Arrange
    LongTimeSeries longTimeSeries = new LongTimeSeries(CommonTimeUtil.TimeBucket.MONTH);
    longTimeSeries.put(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant(), 42L);

    // Act and Assert
    assertEquals(1, longTimeSeries.getTimeSeries().size());
  }

  /**
   * Method under test: {@link LongTimeSeries#getTimeSeries()}
   */
  @Test
  void testGetTimeSeries8() {
    // Arrange
    LongTimeSeries longTimeSeries = new LongTimeSeries(CommonTimeUtil.TimeBucket.YEAR);
    longTimeSeries.put(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant(), 42L);

    // Act and Assert
    assertEquals(1, longTimeSeries.getTimeSeries().size());
  }

  /**
   * Method under test: {@link LongTimeSeries#getTimeSeries()}
   */
  @Test
  void testGetTimeSeries9() {
    // Arrange
    LongTimeSeries longTimeSeries = new LongTimeSeries(CommonTimeUtil.TimeBucket.MILLISECOND);
    longTimeSeries.put(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant(), 42L);

    // Act and Assert
    assertEquals(1, longTimeSeries.getTimeSeries().size());
  }

  /**
   * Method under test: {@link LongTimeSeries#setTimeSeries(Map)}
   */
  @Test
  void testSetTimeSeries() {
    // Arrange
    LongTimeSeries longTimeSeries = new LongTimeSeries(CommonTimeUtil.TimeBucket.SECOND);

    // Act
    longTimeSeries.setTimeSeries(new HashMap<>());

    // Assert
    assertEquals(0, longTimeSeries.getNumberOfInstants());
    assertTrue(longTimeSeries.getTimeSeries().isEmpty());
    assertTrue(longTimeSeries.getInstants().isEmpty());
  }

  /**
   * Method under test: {@link LongTimeSeries#setTimeSeries(Map)}
   */
  @Test
  void testSetTimeSeries2() {
    // Arrange
    LongTimeSeries longTimeSeries = new LongTimeSeries(CommonTimeUtil.TimeBucket.SECOND);

    HashMap<Instant, Long> timeSeries = new HashMap<>();
    timeSeries.put(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant(), 1L);

    // Act
    longTimeSeries.setTimeSeries(timeSeries);

    // Assert
    assertEquals(1, longTimeSeries.getTimeSeries().size());
    assertEquals(1, longTimeSeries.getInstants().size());
    assertEquals(1, longTimeSeries.getNumberOfInstants());
  }

  /**
   * Method under test: {@link LongTimeSeries#setTimeSeries(Map)}
   */
  @Test
  void testSetTimeSeries3() {
    // Arrange
    LongTimeSeries longTimeSeries = new LongTimeSeries(CommonTimeUtil.TimeBucket.SECOND);

    HashMap<Instant, Long> timeSeries = new HashMap<>();
    timeSeries.computeIfPresent(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant(),
        mock(BiFunction.class));
    timeSeries.put(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant(), 1L);

    // Act
    longTimeSeries.setTimeSeries(timeSeries);

    // Assert
    assertEquals(1, longTimeSeries.getTimeSeries().size());
    assertEquals(1, longTimeSeries.getInstants().size());
    assertEquals(1, longTimeSeries.getNumberOfInstants());
  }

  /**
   * Method under test: {@link LongTimeSeries#setTimeSeries(Map)}
   */
  @Test
  void testSetTimeSeries4() {
    // Arrange
    LongTimeSeries longTimeSeries = new LongTimeSeries(CommonTimeUtil.TimeBucket.MINUTE);

    HashMap<Instant, Long> timeSeries = new HashMap<>();
    timeSeries.put(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant(), 1L);

    // Act
    longTimeSeries.setTimeSeries(timeSeries);

    // Assert
    assertEquals(1, longTimeSeries.getTimeSeries().size());
    assertEquals(1, longTimeSeries.getInstants().size());
    assertEquals(1, longTimeSeries.getNumberOfInstants());
  }

  /**
   * Method under test: {@link LongTimeSeries#setTimeSeries(Map)}
   */
  @Test
  void testSetTimeSeries5() {
    // Arrange
    LongTimeSeries longTimeSeries = new LongTimeSeries(CommonTimeUtil.TimeBucket.HOUR);

    HashMap<Instant, Long> timeSeries = new HashMap<>();
    timeSeries.put(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant(), 1L);

    // Act
    longTimeSeries.setTimeSeries(timeSeries);

    // Assert
    assertEquals(1, longTimeSeries.getTimeSeries().size());
    assertEquals(1, longTimeSeries.getInstants().size());
    assertEquals(1, longTimeSeries.getNumberOfInstants());
  }

  /**
   * Method under test: {@link LongTimeSeries#setTimeSeries(Map)}
   */
  @Test
  void testSetTimeSeries6() {
    // Arrange
    LongTimeSeries longTimeSeries = new LongTimeSeries(CommonTimeUtil.TimeBucket.DAY);

    HashMap<Instant, Long> timeSeries = new HashMap<>();
    timeSeries.put(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant(), 1L);

    // Act
    longTimeSeries.setTimeSeries(timeSeries);

    // Assert
    assertEquals(1, longTimeSeries.getTimeSeries().size());
    assertEquals(1, longTimeSeries.getInstants().size());
    assertEquals(1, longTimeSeries.getNumberOfInstants());
  }

  /**
   * Method under test: {@link LongTimeSeries#setTimeSeries(Map)}
   */
  @Test
  void testSetTimeSeries7() {
    // Arrange
    LongTimeSeries longTimeSeries = new LongTimeSeries(CommonTimeUtil.TimeBucket.WEEK);

    HashMap<Instant, Long> timeSeries = new HashMap<>();
    timeSeries.put(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant(), 1L);

    // Act
    longTimeSeries.setTimeSeries(timeSeries);

    // Assert
    assertEquals(1, longTimeSeries.getTimeSeries().size());
    assertEquals(1, longTimeSeries.getInstants().size());
    assertEquals(1, longTimeSeries.getNumberOfInstants());
  }

  /**
   * Method under test: {@link LongTimeSeries#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    LongTimeSeries longTimeSeries = new LongTimeSeries(CommonTimeUtil.TimeBucket.MINUTE);

    // Act and Assert
    assertNotEquals(longTimeSeries, new LongTimeSeries(CommonTimeUtil.TimeBucket.SECOND));
  }

  /**
   * Method under test: {@link LongTimeSeries#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new LongTimeSeries(CommonTimeUtil.TimeBucket.SECOND), null);
  }

  /**
   * Method under test: {@link LongTimeSeries#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new LongTimeSeries(CommonTimeUtil.TimeBucket.SECOND), "Different type to LongTimeSeries");
  }

  /**
   * Method under test: {@link LongTimeSeries#getTimeBucket()}
   */
  @Test
  void testGetTimeBucket() {
    // Arrange, Act and Assert
    assertEquals(CommonTimeUtil.TimeBucket.SECOND,
        (new LongTimeSeries(CommonTimeUtil.TimeBucket.SECOND)).getTimeBucket());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link LongTimeSeries#equals(Object)}
   *   <li>{@link LongTimeSeries#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    LongTimeSeries longTimeSeries = new LongTimeSeries(CommonTimeUtil.TimeBucket.SECOND);
    LongTimeSeries longTimeSeries2 = new LongTimeSeries(CommonTimeUtil.TimeBucket.SECOND);

    // Act and Assert
    assertEquals(longTimeSeries, longTimeSeries2);
    int expectedHashCodeResult = longTimeSeries.hashCode();
    assertEquals(expectedHashCodeResult, longTimeSeries2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link LongTimeSeries#equals(Object)}
   *   <li>{@link LongTimeSeries#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    LongTimeSeries longTimeSeries = new LongTimeSeries(CommonTimeUtil.TimeBucket.SECOND);

    // Act and Assert
    assertEquals(longTimeSeries, longTimeSeries);
    int expectedHashCodeResult = longTimeSeries.hashCode();
    assertEquals(expectedHashCodeResult, longTimeSeries.hashCode());
  }

  /**
   * Method under test:
   * {@link LongTimeSeries#LongTimeSeries(CommonTimeUtil.TimeBucket)}
   */
  @Test
  void testNewLongTimeSeries() {
    // Arrange and Act
    LongTimeSeries actualLongTimeSeries = new LongTimeSeries(CommonTimeUtil.TimeBucket.SECOND);

    // Assert
    assertEquals(0, actualLongTimeSeries.getNumberOfInstants());
    assertEquals(CommonTimeUtil.TimeBucket.SECOND, actualLongTimeSeries.getTimeBucket());
    assertTrue(actualLongTimeSeries.getTimeSeries().isEmpty());
    assertTrue(actualLongTimeSeries.getInstants().isEmpty());
  }

  /**
   * Method under test:
   * {@link LongTimeSeries#LongTimeSeries(CommonTimeUtil.TimeBucket, Map)}
   */
  @Test
  void testNewLongTimeSeries2() {
    // Arrange and Act
    LongTimeSeries actualLongTimeSeries = new LongTimeSeries(CommonTimeUtil.TimeBucket.SECOND, new HashMap<>());

    // Assert
    assertEquals(0, actualLongTimeSeries.getNumberOfInstants());
    assertEquals(CommonTimeUtil.TimeBucket.SECOND, actualLongTimeSeries.getTimeBucket());
    assertTrue(actualLongTimeSeries.getTimeSeries().isEmpty());
    assertTrue(actualLongTimeSeries.getInstants().isEmpty());
  }

  /**
   * Method under test:
   * {@link LongTimeSeries#LongTimeSeries(CommonTimeUtil.TimeBucket, Map)}
   */
  @Test
  void testNewLongTimeSeries3() {
    // Arrange and Act
    LongTimeSeries actualLongTimeSeries = new LongTimeSeries(CommonTimeUtil.TimeBucket.SECOND, null);

    // Assert
    assertEquals(0, actualLongTimeSeries.getNumberOfInstants());
    assertEquals(CommonTimeUtil.TimeBucket.SECOND, actualLongTimeSeries.getTimeBucket());
    assertTrue(actualLongTimeSeries.getTimeSeries().isEmpty());
    assertTrue(actualLongTimeSeries.getInstants().isEmpty());
  }

  /**
   * Method under test:
   * {@link LongTimeSeries#LongTimeSeries(CommonTimeUtil.TimeBucket, Map)}
   */
  @Test
  void testNewLongTimeSeries4() {
    // Arrange
    HashMap<Instant, Long> timeSeries = new HashMap<>();
    timeSeries.put(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant(), 1L);

    // Act
    LongTimeSeries actualLongTimeSeries = new LongTimeSeries(CommonTimeUtil.TimeBucket.SECOND, timeSeries);

    // Assert
    assertEquals(1, actualLongTimeSeries.getTimeSeries().size());
    assertEquals(1, actualLongTimeSeries.getInstants().size());
    assertEquals(1, actualLongTimeSeries.getNumberOfInstants());
    assertEquals(CommonTimeUtil.TimeBucket.SECOND, actualLongTimeSeries.getTimeBucket());
  }

  /**
   * Method under test:
   * {@link LongTimeSeries#LongTimeSeries(CommonTimeUtil.TimeBucket, Map)}
   */
  @Test
  void testNewLongTimeSeries5() {
    // Arrange
    HashMap<Instant, Long> timeSeries = new HashMap<>();
    timeSeries.computeIfPresent(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant(),
        mock(BiFunction.class));
    timeSeries.put(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant(), 1L);

    // Act
    LongTimeSeries actualLongTimeSeries = new LongTimeSeries(CommonTimeUtil.TimeBucket.SECOND, timeSeries);

    // Assert
    assertEquals(1, actualLongTimeSeries.getTimeSeries().size());
    assertEquals(1, actualLongTimeSeries.getInstants().size());
    assertEquals(1, actualLongTimeSeries.getNumberOfInstants());
    assertEquals(CommonTimeUtil.TimeBucket.SECOND, actualLongTimeSeries.getTimeBucket());
  }

  /**
   * Method under test:
   * {@link LongTimeSeries#LongTimeSeries(CommonTimeUtil.TimeBucket, Map)}
   */
  @Test
  void testNewLongTimeSeries6() {
    // Arrange
    HashMap<Instant, Long> timeSeries = new HashMap<>();
    timeSeries.put(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant(), 1L);

    // Act
    LongTimeSeries actualLongTimeSeries = new LongTimeSeries(CommonTimeUtil.TimeBucket.MINUTE, timeSeries);

    // Assert
    assertEquals(1, actualLongTimeSeries.getTimeSeries().size());
    assertEquals(1, actualLongTimeSeries.getInstants().size());
    assertEquals(1, actualLongTimeSeries.getNumberOfInstants());
    assertEquals(CommonTimeUtil.TimeBucket.MINUTE, actualLongTimeSeries.getTimeBucket());
  }

  /**
   * Method under test:
   * {@link LongTimeSeries#LongTimeSeries(CommonTimeUtil.TimeBucket, Map)}
   */
  @Test
  void testNewLongTimeSeries7() {
    // Arrange
    HashMap<Instant, Long> timeSeries = new HashMap<>();
    timeSeries.put(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant(), 1L);

    // Act
    LongTimeSeries actualLongTimeSeries = new LongTimeSeries(CommonTimeUtil.TimeBucket.HOUR, timeSeries);

    // Assert
    assertEquals(1, actualLongTimeSeries.getTimeSeries().size());
    assertEquals(1, actualLongTimeSeries.getInstants().size());
    assertEquals(1, actualLongTimeSeries.getNumberOfInstants());
    assertEquals(CommonTimeUtil.TimeBucket.HOUR, actualLongTimeSeries.getTimeBucket());
  }

  /**
   * Method under test:
   * {@link LongTimeSeries#LongTimeSeries(CommonTimeUtil.TimeBucket, Map)}
   */
  @Test
  void testNewLongTimeSeries8() {
    // Arrange
    HashMap<Instant, Long> timeSeries = new HashMap<>();
    timeSeries.put(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant(), 1L);

    // Act
    LongTimeSeries actualLongTimeSeries = new LongTimeSeries(CommonTimeUtil.TimeBucket.DAY, timeSeries);

    // Assert
    assertEquals(1, actualLongTimeSeries.getTimeSeries().size());
    assertEquals(1, actualLongTimeSeries.getInstants().size());
    assertEquals(1, actualLongTimeSeries.getNumberOfInstants());
    assertEquals(CommonTimeUtil.TimeBucket.DAY, actualLongTimeSeries.getTimeBucket());
  }

  /**
   * Method under test:
   * {@link LongTimeSeries#LongTimeSeries(CommonTimeUtil.TimeBucket, Map)}
   */
  @Test
  void testNewLongTimeSeries9() {
    // Arrange
    HashMap<Instant, Long> timeSeries = new HashMap<>();
    timeSeries.put(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant(), 1L);

    // Act
    LongTimeSeries actualLongTimeSeries = new LongTimeSeries(CommonTimeUtil.TimeBucket.WEEK, timeSeries);

    // Assert
    assertEquals(1, actualLongTimeSeries.getTimeSeries().size());
    assertEquals(1, actualLongTimeSeries.getInstants().size());
    assertEquals(1, actualLongTimeSeries.getNumberOfInstants());
    assertEquals(CommonTimeUtil.TimeBucket.WEEK, actualLongTimeSeries.getTimeBucket());
  }
}
