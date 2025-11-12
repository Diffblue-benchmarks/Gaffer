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
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import org.junit.jupiter.api.Test;
import org.roaringbitmap.RoaringBitmap;

class RBMBackedTimestampSetDiffblueTest {
  /**
   * Method under test: {@link RBMBackedTimestampSet#add(Instant)}
   */
  @Test
  void testAdd() {
    // Arrange
    RBMBackedTimestampSet rbmBackedTimestampSet = new RBMBackedTimestampSet(CommonTimeUtil.TimeBucket.SECOND);
    Instant instant = LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant();

    // Act
    rbmBackedTimestampSet.add(instant);

    // Assert
    RoaringBitmap rbm = rbmBackedTimestampSet.getRbm();
    Iterator<Integer> iteratorResult = rbm.iterator();
    assertEquals(0, iteratorResult.next().intValue());
    assertEquals(1, rbmBackedTimestampSet.getTimestamps().size());
    assertEquals(1, rbm.getCardinality());
    assertEquals(1L, rbmBackedTimestampSet.getNumberOfTimestamps());
    assertFalse(iteratorResult.hasNext());
    assertFalse(rbm.isEmpty());
    assertEquals(rbmBackedTimestampSet, rbmBackedTimestampSet.getShallowClone());
    assertEquals(Short.SIZE, rbm.getSizeInBytes());
    Instant instant2 = instant.EPOCH;
    assertSame(instant2, rbmBackedTimestampSet.getEarliest());
    assertSame(instant2, rbmBackedTimestampSet.getLatest());
  }

  /**
   * Method under test: {@link RBMBackedTimestampSet#add(Instant)}
   */
  @Test
  void testAdd2() {
    // Arrange
    RBMBackedTimestampSet rbmBackedTimestampSet = new RBMBackedTimestampSet(CommonTimeUtil.TimeBucket.MINUTE);
    Instant instant = LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant();

    // Act
    rbmBackedTimestampSet.add(instant);

    // Assert
    RoaringBitmap rbm = rbmBackedTimestampSet.getRbm();
    Iterator<Integer> iteratorResult = rbm.iterator();
    assertEquals(0, iteratorResult.next().intValue());
    assertEquals(1, rbmBackedTimestampSet.getTimestamps().size());
    assertEquals(1, rbm.getCardinality());
    assertEquals(1L, rbmBackedTimestampSet.getNumberOfTimestamps());
    assertFalse(iteratorResult.hasNext());
    assertFalse(rbm.isEmpty());
    assertEquals(rbmBackedTimestampSet, rbmBackedTimestampSet.getShallowClone());
    assertEquals(Short.SIZE, rbm.getSizeInBytes());
    Instant instant2 = instant.EPOCH;
    assertSame(instant2, rbmBackedTimestampSet.getEarliest());
    assertSame(instant2, rbmBackedTimestampSet.getLatest());
  }

  /**
   * Method under test: {@link RBMBackedTimestampSet#add(Instant)}
   */
  @Test
  void testAdd3() {
    // Arrange
    RBMBackedTimestampSet rbmBackedTimestampSet = new RBMBackedTimestampSet(CommonTimeUtil.TimeBucket.HOUR);
    Instant instant = LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant();

    // Act
    rbmBackedTimestampSet.add(instant);

    // Assert
    RoaringBitmap rbm = rbmBackedTimestampSet.getRbm();
    Iterator<Integer> iteratorResult = rbm.iterator();
    assertEquals(0, iteratorResult.next().intValue());
    assertEquals(1, rbmBackedTimestampSet.getTimestamps().size());
    assertEquals(1, rbm.getCardinality());
    assertEquals(1L, rbmBackedTimestampSet.getNumberOfTimestamps());
    assertFalse(iteratorResult.hasNext());
    assertFalse(rbm.isEmpty());
    assertEquals(rbmBackedTimestampSet, rbmBackedTimestampSet.getShallowClone());
    assertEquals(Short.SIZE, rbm.getSizeInBytes());
    Instant instant2 = instant.EPOCH;
    assertSame(instant2, rbmBackedTimestampSet.getEarliest());
    assertSame(instant2, rbmBackedTimestampSet.getLatest());
  }

  /**
   * Method under test: {@link RBMBackedTimestampSet#add(Instant)}
   */
  @Test
  void testAdd4() {
    // Arrange
    RBMBackedTimestampSet rbmBackedTimestampSet = new RBMBackedTimestampSet(CommonTimeUtil.TimeBucket.DAY);
    Instant instant = LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant();

    // Act
    rbmBackedTimestampSet.add(instant);

    // Assert
    RoaringBitmap rbm = rbmBackedTimestampSet.getRbm();
    Iterator<Integer> iteratorResult = rbm.iterator();
    assertEquals(0, iteratorResult.next().intValue());
    assertEquals(1, rbmBackedTimestampSet.getTimestamps().size());
    assertEquals(1, rbm.getCardinality());
    assertEquals(1L, rbmBackedTimestampSet.getNumberOfTimestamps());
    assertFalse(iteratorResult.hasNext());
    assertFalse(rbm.isEmpty());
    assertEquals(rbmBackedTimestampSet, rbmBackedTimestampSet.getShallowClone());
    assertEquals(Short.SIZE, rbm.getSizeInBytes());
    Instant instant2 = instant.EPOCH;
    assertSame(instant2, rbmBackedTimestampSet.getEarliest());
    assertSame(instant2, rbmBackedTimestampSet.getLatest());
  }

  /**
   * Method under test: {@link RBMBackedTimestampSet#add(Instant)}
   */
  @Test
  void testAdd5() {
    // Arrange
    RBMBackedTimestampSet rbmBackedTimestampSet = new RBMBackedTimestampSet(CommonTimeUtil.TimeBucket.SECOND);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> rbmBackedTimestampSet.add(LocalDate.ofYearDay(1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
  }

  /**
   * Method under test: {@link RBMBackedTimestampSet#add(Instant)}
   */
  @Test
  void testAdd6() {
    // Arrange
    RBMBackedTimestampSet rbmBackedTimestampSet = new RBMBackedTimestampSet(CommonTimeUtil.TimeBucket.WEEK);

    // Act
    rbmBackedTimestampSet.add(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Assert
    Instant earliest = rbmBackedTimestampSet.getEarliest();
    assertEquals(-259200L, earliest.getEpochSecond());
    RoaringBitmap rbm = rbmBackedTimestampSet.getRbm();
    Iterator<Integer> iteratorResult = rbm.iterator();
    assertEquals(-3, iteratorResult.next().intValue());
    assertEquals(0, earliest.getNano());
    assertEquals(1, rbmBackedTimestampSet.getTimestamps().size());
    assertEquals(1, rbm.getCardinality());
    assertEquals(1L, rbmBackedTimestampSet.getNumberOfTimestamps());
    assertFalse(iteratorResult.hasNext());
    assertFalse(rbm.isEmpty());
    assertEquals(earliest, rbmBackedTimestampSet.getLatest());
    assertEquals(Short.SIZE, rbm.getSizeInBytes());
  }

  /**
   * Method under test: {@link RBMBackedTimestampSet#add(Instant)}
   */
  @Test
  void testAdd7() {
    // Arrange
    RBMBackedTimestampSet rbmBackedTimestampSet = new RBMBackedTimestampSet(CommonTimeUtil.TimeBucket.MONTH);
    Instant instant = LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant();

    // Act
    rbmBackedTimestampSet.add(instant);

    // Assert
    RoaringBitmap rbm = rbmBackedTimestampSet.getRbm();
    Iterator<Integer> iteratorResult = rbm.iterator();
    assertEquals(0, iteratorResult.next().intValue());
    assertEquals(1, rbmBackedTimestampSet.getTimestamps().size());
    assertEquals(1, rbm.getCardinality());
    assertEquals(1L, rbmBackedTimestampSet.getNumberOfTimestamps());
    assertFalse(iteratorResult.hasNext());
    assertFalse(rbm.isEmpty());
    assertEquals(rbmBackedTimestampSet, rbmBackedTimestampSet.getShallowClone());
    assertEquals(Short.SIZE, rbm.getSizeInBytes());
    Instant instant2 = instant.EPOCH;
    assertSame(instant2, rbmBackedTimestampSet.getEarliest());
    assertSame(instant2, rbmBackedTimestampSet.getLatest());
  }

  /**
   * Method under test: {@link RBMBackedTimestampSet#add(Instant)}
   */
  @Test
  void testAdd8() {
    // Arrange
    RBMBackedTimestampSet rbmBackedTimestampSet = new RBMBackedTimestampSet(CommonTimeUtil.TimeBucket.YEAR);
    Instant instant = LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant();

    // Act
    rbmBackedTimestampSet.add(instant);

    // Assert
    RoaringBitmap rbm = rbmBackedTimestampSet.getRbm();
    Iterator<Integer> iteratorResult = rbm.iterator();
    assertEquals(0, iteratorResult.next().intValue());
    assertEquals(1, rbmBackedTimestampSet.getTimestamps().size());
    assertEquals(1, rbm.getCardinality());
    assertEquals(1L, rbmBackedTimestampSet.getNumberOfTimestamps());
    assertFalse(iteratorResult.hasNext());
    assertFalse(rbm.isEmpty());
    assertEquals(rbmBackedTimestampSet, rbmBackedTimestampSet.getShallowClone());
    assertEquals(Short.SIZE, rbm.getSizeInBytes());
    Instant instant2 = instant.EPOCH;
    assertSame(instant2, rbmBackedTimestampSet.getEarliest());
    assertSame(instant2, rbmBackedTimestampSet.getLatest());
  }

  /**
   * Method under test: {@link RBMBackedTimestampSet#add(Collection)}
   */
  @Test
  void testAdd9() {
    // Arrange
    RBMBackedTimestampSet rbmBackedTimestampSet = new RBMBackedTimestampSet(CommonTimeUtil.TimeBucket.SECOND);

    // Act
    rbmBackedTimestampSet.add(new ArrayList<>());

    // Assert
    assertNull(rbmBackedTimestampSet.getEarliest());
    assertNull(rbmBackedTimestampSet.getLatest());
    RoaringBitmap rbm = rbmBackedTimestampSet.getRbm();
    assertEquals(0, rbm.getCardinality());
    assertEquals(0L, rbmBackedTimestampSet.getNumberOfTimestamps());
    assertEquals(8, rbm.getSizeInBytes());
    assertFalse(rbm.iterator().hasNext());
    assertTrue(rbmBackedTimestampSet.getTimestamps().isEmpty());
    assertTrue(rbm.isEmpty());
    assertEquals(rbmBackedTimestampSet, rbmBackedTimestampSet.getShallowClone());
  }

  /**
   * Method under test: {@link RBMBackedTimestampSet#add(Collection)}
   */
  @Test
  void testAdd10() {
    // Arrange
    RBMBackedTimestampSet rbmBackedTimestampSet = new RBMBackedTimestampSet(CommonTimeUtil.TimeBucket.SECOND);

    ArrayList<Instant> instants = new ArrayList<>();
    instants.add(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Act
    rbmBackedTimestampSet.add(instants);

    // Assert
    RoaringBitmap rbm = rbmBackedTimestampSet.getRbm();
    Iterator<Integer> iteratorResult = rbm.iterator();
    assertEquals(0, iteratorResult.next().intValue());
    assertEquals(1, rbmBackedTimestampSet.getTimestamps().size());
    assertEquals(1, rbm.getCardinality());
    assertEquals(1L, rbmBackedTimestampSet.getNumberOfTimestamps());
    assertFalse(iteratorResult.hasNext());
    assertFalse(rbm.isEmpty());
    assertEquals(rbmBackedTimestampSet, rbmBackedTimestampSet.getShallowClone());
    assertEquals(Short.SIZE, rbm.getSizeInBytes());
  }

  /**
   * Method under test: {@link RBMBackedTimestampSet#add(Collection)}
   */
  @Test
  void testAdd11() {
    // Arrange
    RBMBackedTimestampSet rbmBackedTimestampSet = new RBMBackedTimestampSet(CommonTimeUtil.TimeBucket.SECOND);

    ArrayList<Instant> instants = new ArrayList<>();
    instants.add(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
    instants.add(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Act
    rbmBackedTimestampSet.add(instants);

    // Assert
    RoaringBitmap rbm = rbmBackedTimestampSet.getRbm();
    Iterator<Integer> iteratorResult = rbm.iterator();
    assertEquals(0, iteratorResult.next().intValue());
    assertEquals(1, rbmBackedTimestampSet.getTimestamps().size());
    assertEquals(1, rbm.getCardinality());
    assertEquals(1L, rbmBackedTimestampSet.getNumberOfTimestamps());
    assertFalse(iteratorResult.hasNext());
    assertFalse(rbm.isEmpty());
    assertEquals(rbmBackedTimestampSet, rbmBackedTimestampSet.getShallowClone());
    assertEquals(Short.SIZE, rbm.getSizeInBytes());
  }

  /**
   * Method under test: {@link RBMBackedTimestampSet#add(Collection)}
   */
  @Test
  void testAdd12() {
    // Arrange
    RBMBackedTimestampSet rbmBackedTimestampSet = new RBMBackedTimestampSet(CommonTimeUtil.TimeBucket.MINUTE);

    ArrayList<Instant> instants = new ArrayList<>();
    instants.add(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Act
    rbmBackedTimestampSet.add(instants);

    // Assert
    RoaringBitmap rbm = rbmBackedTimestampSet.getRbm();
    Iterator<Integer> iteratorResult = rbm.iterator();
    assertEquals(0, iteratorResult.next().intValue());
    assertEquals(1, rbmBackedTimestampSet.getTimestamps().size());
    assertEquals(1, rbm.getCardinality());
    assertEquals(1L, rbmBackedTimestampSet.getNumberOfTimestamps());
    assertFalse(iteratorResult.hasNext());
    assertFalse(rbm.isEmpty());
    assertEquals(rbmBackedTimestampSet, rbmBackedTimestampSet.getShallowClone());
    assertEquals(Short.SIZE, rbm.getSizeInBytes());
  }

  /**
   * Method under test: {@link RBMBackedTimestampSet#add(Collection)}
   */
  @Test
  void testAdd13() {
    // Arrange
    RBMBackedTimestampSet rbmBackedTimestampSet = new RBMBackedTimestampSet(CommonTimeUtil.TimeBucket.HOUR);

    ArrayList<Instant> instants = new ArrayList<>();
    instants.add(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Act
    rbmBackedTimestampSet.add(instants);

    // Assert
    RoaringBitmap rbm = rbmBackedTimestampSet.getRbm();
    Iterator<Integer> iteratorResult = rbm.iterator();
    assertEquals(0, iteratorResult.next().intValue());
    assertEquals(1, rbmBackedTimestampSet.getTimestamps().size());
    assertEquals(1, rbm.getCardinality());
    assertEquals(1L, rbmBackedTimestampSet.getNumberOfTimestamps());
    assertFalse(iteratorResult.hasNext());
    assertFalse(rbm.isEmpty());
    assertEquals(rbmBackedTimestampSet, rbmBackedTimestampSet.getShallowClone());
    assertEquals(Short.SIZE, rbm.getSizeInBytes());
  }

  /**
   * Method under test: {@link RBMBackedTimestampSet#add(Collection)}
   */
  @Test
  void testAdd14() {
    // Arrange
    RBMBackedTimestampSet rbmBackedTimestampSet = new RBMBackedTimestampSet(CommonTimeUtil.TimeBucket.DAY);

    ArrayList<Instant> instants = new ArrayList<>();
    instants.add(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Act
    rbmBackedTimestampSet.add(instants);

    // Assert
    RoaringBitmap rbm = rbmBackedTimestampSet.getRbm();
    Iterator<Integer> iteratorResult = rbm.iterator();
    assertEquals(0, iteratorResult.next().intValue());
    assertEquals(1, rbmBackedTimestampSet.getTimestamps().size());
    assertEquals(1, rbm.getCardinality());
    assertEquals(1L, rbmBackedTimestampSet.getNumberOfTimestamps());
    assertFalse(iteratorResult.hasNext());
    assertFalse(rbm.isEmpty());
    assertEquals(rbmBackedTimestampSet, rbmBackedTimestampSet.getShallowClone());
    assertEquals(Short.SIZE, rbm.getSizeInBytes());
  }

  /**
   * Method under test: {@link RBMBackedTimestampSet#add(Collection)}
   */
  @Test
  void testAdd15() {
    // Arrange
    RBMBackedTimestampSet rbmBackedTimestampSet = new RBMBackedTimestampSet(CommonTimeUtil.TimeBucket.SECOND);

    ArrayList<Instant> instants = new ArrayList<>();
    instants.add(LocalDate.ofYearDay(1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> rbmBackedTimestampSet.add(instants));
  }

  /**
   * Method under test: {@link RBMBackedTimestampSet#add(Collection)}
   */
  @Test
  void testAdd16() {
    // Arrange
    RBMBackedTimestampSet rbmBackedTimestampSet = new RBMBackedTimestampSet(CommonTimeUtil.TimeBucket.SECOND);

    ArrayList<Instant> instants = new ArrayList<>();
    instants.add(LocalDate.now().atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
    instants.add(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Act
    rbmBackedTimestampSet.add(instants);

    // Assert
    assertEquals(0, rbmBackedTimestampSet.getRbm().iterator().next().intValue());
    assertEquals(rbmBackedTimestampSet, rbmBackedTimestampSet.getShallowClone());
  }

  /**
   * Method under test: {@link RBMBackedTimestampSet#add(Collection)}
   */
  @Test
  void testAdd17() {
    // Arrange
    RBMBackedTimestampSet rbmBackedTimestampSet = new RBMBackedTimestampSet(CommonTimeUtil.TimeBucket.SECOND);

    ArrayList<Instant> instants = new ArrayList<>();
    instants.add(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
    instants.add(LocalDate.now().atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Act
    rbmBackedTimestampSet.add(instants);

    // Assert
    RoaringBitmap rbm = rbmBackedTimestampSet.getRbm();
    assertEquals(0, rbm.iterator().next().intValue());
    assertFalse(rbm.isEmpty());
    assertEquals(rbmBackedTimestampSet, rbmBackedTimestampSet.getShallowClone());
  }

  /**
   * Method under test: {@link RBMBackedTimestampSet#add(Collection)}
   */
  @Test
  void testAdd18() {
    // Arrange
    RBMBackedTimestampSet rbmBackedTimestampSet = new RBMBackedTimestampSet(CommonTimeUtil.TimeBucket.WEEK);

    ArrayList<Instant> instants = new ArrayList<>();
    instants.add(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Act
    rbmBackedTimestampSet.add(instants);

    // Assert
    Instant earliest = rbmBackedTimestampSet.getEarliest();
    assertEquals(-259200L, earliest.getEpochSecond());
    RoaringBitmap rbm = rbmBackedTimestampSet.getRbm();
    Iterator<Integer> iteratorResult = rbm.iterator();
    assertEquals(-3, iteratorResult.next().intValue());
    assertEquals(0, earliest.getNano());
    assertEquals(1, rbmBackedTimestampSet.getTimestamps().size());
    assertEquals(1, rbm.getCardinality());
    assertEquals(1L, rbmBackedTimestampSet.getNumberOfTimestamps());
    assertFalse(iteratorResult.hasNext());
    assertFalse(rbm.isEmpty());
    assertEquals(earliest, rbmBackedTimestampSet.getLatest());
    assertEquals(Short.SIZE, rbm.getSizeInBytes());
  }

  /**
   * Method under test: {@link RBMBackedTimestampSet#add(Collection)}
   */
  @Test
  void testAdd19() {
    // Arrange
    RBMBackedTimestampSet rbmBackedTimestampSet = new RBMBackedTimestampSet(CommonTimeUtil.TimeBucket.MONTH);

    ArrayList<Instant> instants = new ArrayList<>();
    instants.add(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Act
    rbmBackedTimestampSet.add(instants);

    // Assert
    RoaringBitmap rbm = rbmBackedTimestampSet.getRbm();
    Iterator<Integer> iteratorResult = rbm.iterator();
    assertEquals(0, iteratorResult.next().intValue());
    assertEquals(1, rbmBackedTimestampSet.getTimestamps().size());
    assertEquals(1, rbm.getCardinality());
    assertEquals(1L, rbmBackedTimestampSet.getNumberOfTimestamps());
    assertFalse(iteratorResult.hasNext());
    assertFalse(rbm.isEmpty());
    assertEquals(rbmBackedTimestampSet, rbmBackedTimestampSet.getShallowClone());
    assertEquals(Short.SIZE, rbm.getSizeInBytes());
  }

  /**
   * Method under test: {@link RBMBackedTimestampSet#add(Collection)}
   */
  @Test
  void testAdd20() {
    // Arrange
    RBMBackedTimestampSet rbmBackedTimestampSet = new RBMBackedTimestampSet(CommonTimeUtil.TimeBucket.YEAR);

    ArrayList<Instant> instants = new ArrayList<>();
    instants.add(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Act
    rbmBackedTimestampSet.add(instants);

    // Assert
    RoaringBitmap rbm = rbmBackedTimestampSet.getRbm();
    Iterator<Integer> iteratorResult = rbm.iterator();
    assertEquals(0, iteratorResult.next().intValue());
    assertEquals(1, rbmBackedTimestampSet.getTimestamps().size());
    assertEquals(1, rbm.getCardinality());
    assertEquals(1L, rbmBackedTimestampSet.getNumberOfTimestamps());
    assertFalse(iteratorResult.hasNext());
    assertFalse(rbm.isEmpty());
    assertEquals(rbmBackedTimestampSet, rbmBackedTimestampSet.getShallowClone());
    assertEquals(Short.SIZE, rbm.getSizeInBytes());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link RBMBackedTimestampSet.Builder#build()}
   *   <li>default or parameterless constructor of
   * {@link RBMBackedTimestampSet.Builder}
   *   <li>
   * {@link RBMBackedTimestampSet.Builder#timeBucket(CommonTimeUtil.TimeBucket)}
   * </ul>
   */
  @Test
  void testBuilderBuild() {
    // Arrange
    RBMBackedTimestampSet.Builder timeBucketResult = (new RBMBackedTimestampSet.Builder())
        .timeBucket(CommonTimeUtil.TimeBucket.SECOND);
    RBMBackedTimestampSet.Builder timestampResult = timeBucketResult
        .timestamp(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
    RBMBackedTimestampSet.Builder timestampsResult = timestampResult.timestamps(new ArrayList<>());

    // Act
    RBMBackedTimestampSet actualBuildResult = timestampsResult
        .timestamps(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant())
        .build();

    // Assert
    RoaringBitmap rbm = actualBuildResult.getRbm();
    Iterator<Integer> iteratorResult = rbm.iterator();
    assertEquals(0, iteratorResult.next().intValue());
    Instant earliest = actualBuildResult.getEarliest();
    assertEquals(0, earliest.getNano());
    assertEquals(0L, earliest.getEpochSecond());
    assertEquals(1, rbm.getCardinality());
    assertEquals(1L, actualBuildResult.getNumberOfTimestamps());
    assertEquals(CommonTimeUtil.TimeBucket.SECOND, actualBuildResult.getTimeBucket());
    assertFalse(iteratorResult.hasNext());
    assertFalse(rbm.hasRunCompression());
    assertFalse(rbm.isEmpty());
    assertEquals(Short.SIZE, rbm.getSizeInBytes());
  }

  /**
   * Method under test: {@link RBMBackedTimestampSet.Builder#timestamp(Instant)}
   */
  @Test
  void testBuilderTimestamp() {
    // Arrange
    RBMBackedTimestampSet.Builder builder = new RBMBackedTimestampSet.Builder();

    // Act and Assert
    assertSame(builder, builder.timestamp(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
  }

  /**
   * Method under test: {@link RBMBackedTimestampSet.Builder#timestamp(Instant)}
   */
  @Test
  void testBuilderTimestamp2() {
    // Arrange
    RBMBackedTimestampSet.Builder builder = new RBMBackedTimestampSet.Builder();
    builder.timestamp(null);

    // Act and Assert
    assertSame(builder, builder.timestamp(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
  }

  /**
   * Method under test:
   * {@link RBMBackedTimestampSet.Builder#timestamps(Collection)}
   */
  @Test
  void testBuilderTimestamps() {
    // Arrange
    RBMBackedTimestampSet.Builder builder = new RBMBackedTimestampSet.Builder();

    // Act and Assert
    assertSame(builder, builder.timestamps(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link RBMBackedTimestampSet.Builder#timestamps(Collection)}
   */
  @Test
  void testBuilderTimestamps2() {
    // Arrange
    RBMBackedTimestampSet.Builder builder = new RBMBackedTimestampSet.Builder();
    builder.timestamp(null);

    // Act and Assert
    assertSame(builder, builder.timestamps(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link RBMBackedTimestampSet.Builder#timestamps(Collection)}
   */
  @Test
  void testBuilderTimestamps3() {
    // Arrange
    RBMBackedTimestampSet.Builder builder = new RBMBackedTimestampSet.Builder();

    ArrayList<Instant> timestamps = new ArrayList<>();
    timestamps.add(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Act and Assert
    assertSame(builder, builder.timestamps(timestamps));
  }

  /**
   * Method under test:
   * {@link RBMBackedTimestampSet.Builder#timestamps(Collection)}
   */
  @Test
  void testBuilderTimestamps4() {
    // Arrange
    RBMBackedTimestampSet.Builder builder = new RBMBackedTimestampSet.Builder();

    ArrayList<Instant> timestamps = new ArrayList<>();
    timestamps.add(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
    timestamps.add(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Act and Assert
    assertSame(builder, builder.timestamps(timestamps));
  }

  /**
   * Method under test:
   * {@link RBMBackedTimestampSet.Builder#timestamps(Instant[])}
   */
  @Test
  void testBuilderTimestamps5() {
    // Arrange
    RBMBackedTimestampSet.Builder builder = new RBMBackedTimestampSet.Builder();

    // Act and Assert
    assertSame(builder, builder.timestamps(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
  }

  /**
   * Method under test:
   * {@link RBMBackedTimestampSet.Builder#timestamps(Instant[])}
   */
  @Test
  void testBuilderTimestamps6() {
    // Arrange
    RBMBackedTimestampSet.Builder builder = new RBMBackedTimestampSet.Builder();
    builder.timestamp(null);

    // Act and Assert
    assertSame(builder, builder.timestamps(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
  }

  /**
   * Method under test: {@link RBMBackedTimestampSet#getTimestamps()}
   */
  @Test
  void testGetTimestamps() {
    // Arrange, Act and Assert
    assertTrue((new RBMBackedTimestampSet(CommonTimeUtil.TimeBucket.SECOND)).getTimestamps().isEmpty());
    assertEquals(1, (new RBMBackedTimestampSet(CommonTimeUtil.TimeBucket.SECOND,
        LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant())).getTimestamps().size());
    assertEquals(1, (new RBMBackedTimestampSet(CommonTimeUtil.TimeBucket.MINUTE,
        LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant())).getTimestamps().size());
    assertEquals(1, (new RBMBackedTimestampSet(CommonTimeUtil.TimeBucket.HOUR,
        LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant())).getTimestamps().size());
    assertEquals(1, (new RBMBackedTimestampSet(CommonTimeUtil.TimeBucket.DAY,
        LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant())).getTimestamps().size());
    assertEquals(1, (new RBMBackedTimestampSet(CommonTimeUtil.TimeBucket.WEEK,
        LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant())).getTimestamps().size());
    assertEquals(1, (new RBMBackedTimestampSet(CommonTimeUtil.TimeBucket.MONTH,
        LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant())).getTimestamps().size());
    assertEquals(1, (new RBMBackedTimestampSet(CommonTimeUtil.TimeBucket.YEAR,
        LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant())).getTimestamps().size());
  }

  /**
   * Method under test: {@link RBMBackedTimestampSet#getTimestamps()}
   */
  @Test
  void testGetTimestamps2() {
    // Arrange
    RBMBackedTimestampSet rbmBackedTimestampSet = new RBMBackedTimestampSet(CommonTimeUtil.TimeBucket.MINUTE,
        LocalDate.ofEpochDay(1L).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
    rbmBackedTimestampSet.add(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Act and Assert
    assertEquals(2, rbmBackedTimestampSet.getTimestamps().size());
  }

  /**
   * Method under test: {@link RBMBackedTimestampSet#getNumberOfTimestamps()}
   */
  @Test
  void testGetNumberOfTimestamps() {
    // Arrange, Act and Assert
    assertEquals(0L, (new RBMBackedTimestampSet(CommonTimeUtil.TimeBucket.SECOND)).getNumberOfTimestamps());
    assertEquals(1L, (new RBMBackedTimestampSet(CommonTimeUtil.TimeBucket.SECOND,
        LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant())).getNumberOfTimestamps());
  }

  /**
   * Method under test: {@link RBMBackedTimestampSet#getEarliest()}
   */
  @Test
  void testGetEarliest() {
    // Arrange, Act and Assert
    assertNull((new RBMBackedTimestampSet(CommonTimeUtil.TimeBucket.SECOND)).getEarliest());
  }

  /**
   * Method under test: {@link RBMBackedTimestampSet#getEarliest()}
   */
  @Test
  void testGetEarliest2() {
    // Arrange
    RBMBackedTimestampSet rbmBackedTimestampSet = new RBMBackedTimestampSet(CommonTimeUtil.TimeBucket.SECOND,
        LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Act
    Instant actualEarliest = rbmBackedTimestampSet.getEarliest();

    // Assert
    assertEquals(rbmBackedTimestampSet, rbmBackedTimestampSet.getShallowClone());
    Instant instant = actualEarliest.EPOCH;
    assertSame(instant, actualEarliest);
    assertSame(instant, rbmBackedTimestampSet.getLatest());
  }

  /**
   * Method under test: {@link RBMBackedTimestampSet#getEarliest()}
   */
  @Test
  void testGetEarliest3() {
    // Arrange
    RBMBackedTimestampSet rbmBackedTimestampSet = new RBMBackedTimestampSet(CommonTimeUtil.TimeBucket.MINUTE,
        LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Act
    Instant actualEarliest = rbmBackedTimestampSet.getEarliest();

    // Assert
    assertEquals(rbmBackedTimestampSet, rbmBackedTimestampSet.getShallowClone());
    Instant instant = actualEarliest.EPOCH;
    assertSame(instant, actualEarliest);
    assertSame(instant, rbmBackedTimestampSet.getLatest());
  }

  /**
   * Method under test: {@link RBMBackedTimestampSet#getEarliest()}
   */
  @Test
  void testGetEarliest4() {
    // Arrange
    RBMBackedTimestampSet rbmBackedTimestampSet = new RBMBackedTimestampSet(CommonTimeUtil.TimeBucket.HOUR,
        LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Act
    Instant actualEarliest = rbmBackedTimestampSet.getEarliest();

    // Assert
    assertEquals(rbmBackedTimestampSet, rbmBackedTimestampSet.getShallowClone());
    Instant instant = actualEarliest.EPOCH;
    assertSame(instant, actualEarliest);
    assertSame(instant, rbmBackedTimestampSet.getLatest());
  }

  /**
   * Method under test: {@link RBMBackedTimestampSet#getEarliest()}
   */
  @Test
  void testGetEarliest5() {
    // Arrange
    RBMBackedTimestampSet rbmBackedTimestampSet = new RBMBackedTimestampSet(CommonTimeUtil.TimeBucket.DAY,
        LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Act
    Instant actualEarliest = rbmBackedTimestampSet.getEarliest();

    // Assert
    assertEquals(rbmBackedTimestampSet, rbmBackedTimestampSet.getShallowClone());
    Instant instant = actualEarliest.EPOCH;
    assertSame(instant, actualEarliest);
    assertSame(instant, rbmBackedTimestampSet.getLatest());
  }

  /**
   * Method under test: {@link RBMBackedTimestampSet#getEarliest()}
   */
  @Test
  void testGetEarliest6() {
    // Arrange and Act
    Instant actualEarliest = (new RBMBackedTimestampSet(CommonTimeUtil.TimeBucket.WEEK,
        LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant())).getEarliest();

    // Assert
    assertEquals(-259200L, actualEarliest.getEpochSecond());
    assertEquals(0, actualEarliest.getNano());
  }

  /**
   * Method under test: {@link RBMBackedTimestampSet#getEarliest()}
   */
  @Test
  void testGetEarliest7() {
    // Arrange
    RBMBackedTimestampSet rbmBackedTimestampSet = new RBMBackedTimestampSet(CommonTimeUtil.TimeBucket.MONTH,
        LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Act
    Instant actualEarliest = rbmBackedTimestampSet.getEarliest();

    // Assert
    assertEquals(rbmBackedTimestampSet, rbmBackedTimestampSet.getShallowClone());
    Instant instant = actualEarliest.EPOCH;
    assertSame(instant, actualEarliest);
    assertSame(instant, rbmBackedTimestampSet.getLatest());
  }

  /**
   * Method under test: {@link RBMBackedTimestampSet#getEarliest()}
   */
  @Test
  void testGetEarliest8() {
    // Arrange
    RBMBackedTimestampSet rbmBackedTimestampSet = new RBMBackedTimestampSet(CommonTimeUtil.TimeBucket.YEAR,
        LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Act
    Instant actualEarliest = rbmBackedTimestampSet.getEarliest();

    // Assert
    assertEquals(rbmBackedTimestampSet, rbmBackedTimestampSet.getShallowClone());
    Instant instant = actualEarliest.EPOCH;
    assertSame(instant, actualEarliest);
    assertSame(instant, rbmBackedTimestampSet.getLatest());
  }

  /**
   * Method under test: {@link RBMBackedTimestampSet#getLatest()}
   */
  @Test
  void testGetLatest() {
    // Arrange, Act and Assert
    assertNull((new RBMBackedTimestampSet(CommonTimeUtil.TimeBucket.SECOND)).getLatest());
  }

  /**
   * Method under test: {@link RBMBackedTimestampSet#getLatest()}
   */
  @Test
  void testGetLatest2() {
    // Arrange
    RBMBackedTimestampSet rbmBackedTimestampSet = new RBMBackedTimestampSet(CommonTimeUtil.TimeBucket.SECOND,
        LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Act
    Instant actualLatest = rbmBackedTimestampSet.getLatest();

    // Assert
    assertEquals(rbmBackedTimestampSet, rbmBackedTimestampSet.getShallowClone());
    Instant instant = actualLatest.EPOCH;
    assertSame(instant, rbmBackedTimestampSet.getEarliest());
    assertSame(instant, actualLatest);
  }

  /**
   * Method under test: {@link RBMBackedTimestampSet#getLatest()}
   */
  @Test
  void testGetLatest3() {
    // Arrange
    RBMBackedTimestampSet rbmBackedTimestampSet = new RBMBackedTimestampSet(CommonTimeUtil.TimeBucket.MINUTE,
        LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Act
    Instant actualLatest = rbmBackedTimestampSet.getLatest();

    // Assert
    assertEquals(rbmBackedTimestampSet, rbmBackedTimestampSet.getShallowClone());
    Instant instant = actualLatest.EPOCH;
    assertSame(instant, rbmBackedTimestampSet.getEarliest());
    assertSame(instant, actualLatest);
  }

  /**
   * Method under test: {@link RBMBackedTimestampSet#getLatest()}
   */
  @Test
  void testGetLatest4() {
    // Arrange
    RBMBackedTimestampSet rbmBackedTimestampSet = new RBMBackedTimestampSet(CommonTimeUtil.TimeBucket.HOUR,
        LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Act
    Instant actualLatest = rbmBackedTimestampSet.getLatest();

    // Assert
    assertEquals(rbmBackedTimestampSet, rbmBackedTimestampSet.getShallowClone());
    Instant instant = actualLatest.EPOCH;
    assertSame(instant, rbmBackedTimestampSet.getEarliest());
    assertSame(instant, actualLatest);
  }

  /**
   * Method under test: {@link RBMBackedTimestampSet#getLatest()}
   */
  @Test
  void testGetLatest5() {
    // Arrange
    RBMBackedTimestampSet rbmBackedTimestampSet = new RBMBackedTimestampSet(CommonTimeUtil.TimeBucket.DAY,
        LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Act
    Instant actualLatest = rbmBackedTimestampSet.getLatest();

    // Assert
    assertEquals(rbmBackedTimestampSet, rbmBackedTimestampSet.getShallowClone());
    Instant instant = actualLatest.EPOCH;
    assertSame(instant, rbmBackedTimestampSet.getEarliest());
    assertSame(instant, actualLatest);
  }

  /**
   * Method under test: {@link RBMBackedTimestampSet#getLatest()}
   */
  @Test
  void testGetLatest6() {
    // Arrange and Act
    Instant actualLatest = (new RBMBackedTimestampSet(CommonTimeUtil.TimeBucket.WEEK,
        LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant())).getLatest();

    // Assert
    assertEquals(-259200L, actualLatest.getEpochSecond());
    assertEquals(0, actualLatest.getNano());
  }

  /**
   * Method under test: {@link RBMBackedTimestampSet#getLatest()}
   */
  @Test
  void testGetLatest7() {
    // Arrange
    RBMBackedTimestampSet rbmBackedTimestampSet = new RBMBackedTimestampSet(CommonTimeUtil.TimeBucket.MONTH,
        LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Act
    Instant actualLatest = rbmBackedTimestampSet.getLatest();

    // Assert
    assertEquals(rbmBackedTimestampSet, rbmBackedTimestampSet.getShallowClone());
    Instant instant = actualLatest.EPOCH;
    assertSame(instant, rbmBackedTimestampSet.getEarliest());
    assertSame(instant, actualLatest);
  }

  /**
   * Method under test: {@link RBMBackedTimestampSet#getLatest()}
   */
  @Test
  void testGetLatest8() {
    // Arrange
    RBMBackedTimestampSet rbmBackedTimestampSet = new RBMBackedTimestampSet(CommonTimeUtil.TimeBucket.YEAR,
        LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Act
    Instant actualLatest = rbmBackedTimestampSet.getLatest();

    // Assert
    assertEquals(rbmBackedTimestampSet, rbmBackedTimestampSet.getShallowClone());
    Instant instant = actualLatest.EPOCH;
    assertSame(instant, rbmBackedTimestampSet.getEarliest());
    assertSame(instant, actualLatest);
  }

  /**
   * Method under test:
   * {@link RBMBackedTimestampSet#applyTimeRangeMask(Long, Long)}
   */
  @Test
  void testApplyTimeRangeMask() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> (new RBMBackedTimestampSet(CommonTimeUtil.TimeBucket.SECOND)).applyTimeRangeMask(2L, 1L));
    assertThrows(RuntimeException.class,
        () -> (new RBMBackedTimestampSet(CommonTimeUtil.TimeBucket.SECOND)).applyTimeRangeMask(1L, Long.MAX_VALUE));
    assertThrows(RuntimeException.class,
        () -> (new RBMBackedTimestampSet(CommonTimeUtil.TimeBucket.WEEK)).applyTimeRangeMask(1L, 1L));
  }

  /**
   * Method under test: {@link RBMBackedTimestampSet#getShallowClone()}
   */
  @Test
  void testGetShallowClone() {
    // Arrange
    RBMBackedTimestampSet rbmBackedTimestampSet = new RBMBackedTimestampSet(CommonTimeUtil.TimeBucket.SECOND);

    // Act and Assert
    assertEquals(rbmBackedTimestampSet, rbmBackedTimestampSet.getShallowClone());
  }

  /**
   * Method under test: {@link RBMBackedTimestampSet#getShallowClone()}
   */
  @Test
  void testGetShallowClone2() {
    // Arrange
    RBMBackedTimestampSet rbmBackedTimestampSet = new RBMBackedTimestampSet(CommonTimeUtil.TimeBucket.SECOND,
        LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Act and Assert
    assertEquals(rbmBackedTimestampSet, rbmBackedTimestampSet.getShallowClone());
  }

  /**
   * Method under test: {@link RBMBackedTimestampSet#getShallowClone()}
   */
  @Test
  void testGetShallowClone3() {
    // Arrange
    RBMBackedTimestampSet rbmBackedTimestampSet = new RBMBackedTimestampSet(CommonTimeUtil.TimeBucket.MINUTE,
        LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Act and Assert
    assertEquals(rbmBackedTimestampSet, rbmBackedTimestampSet.getShallowClone());
  }

  /**
   * Method under test: {@link RBMBackedTimestampSet#getShallowClone()}
   */
  @Test
  void testGetShallowClone4() {
    // Arrange
    RBMBackedTimestampSet rbmBackedTimestampSet = new RBMBackedTimestampSet(CommonTimeUtil.TimeBucket.HOUR,
        LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Act and Assert
    assertEquals(rbmBackedTimestampSet, rbmBackedTimestampSet.getShallowClone());
  }

  /**
   * Method under test: {@link RBMBackedTimestampSet#getShallowClone()}
   */
  @Test
  void testGetShallowClone5() {
    // Arrange
    RBMBackedTimestampSet rbmBackedTimestampSet = new RBMBackedTimestampSet(CommonTimeUtil.TimeBucket.DAY,
        LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Act and Assert
    assertEquals(rbmBackedTimestampSet, rbmBackedTimestampSet.getShallowClone());
  }

  /**
   * Method under test: {@link RBMBackedTimestampSet#getShallowClone()}
   */
  @Test
  void testGetShallowClone6() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> (new RBMBackedTimestampSet(CommonTimeUtil.TimeBucket.WEEK,
        LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant())).getShallowClone());
  }

  /**
   * Method under test: {@link RBMBackedTimestampSet#getShallowClone()}
   */
  @Test
  void testGetShallowClone7() {
    // Arrange
    RBMBackedTimestampSet rbmBackedTimestampSet = new RBMBackedTimestampSet(CommonTimeUtil.TimeBucket.MONTH,
        LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Act and Assert
    assertEquals(rbmBackedTimestampSet, rbmBackedTimestampSet.getShallowClone());
  }

  /**
   * Method under test: {@link RBMBackedTimestampSet#getShallowClone()}
   */
  @Test
  void testGetShallowClone8() {
    // Arrange
    RBMBackedTimestampSet rbmBackedTimestampSet = new RBMBackedTimestampSet(CommonTimeUtil.TimeBucket.YEAR,
        LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Act and Assert
    assertEquals(rbmBackedTimestampSet, rbmBackedTimestampSet.getShallowClone());
  }

  /**
   * Method under test: {@link RBMBackedTimestampSet#getShallowClone()}
   */
  @Test
  void testGetShallowClone9() {
    // Arrange
    RBMBackedTimestampSet rbmBackedTimestampSet = new RBMBackedTimestampSet(CommonTimeUtil.TimeBucket.SECOND,
        LocalDate.now().atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
    rbmBackedTimestampSet.add(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Act and Assert
    assertEquals(rbmBackedTimestampSet, rbmBackedTimestampSet.getShallowClone());
  }

  /**
   * Method under test: {@link RBMBackedTimestampSet#getShallowClone()}
   */
  @Test
  void testGetShallowClone10() {
    // Arrange
    RBMBackedTimestampSet rbmBackedTimestampSet = new RBMBackedTimestampSet(CommonTimeUtil.TimeBucket.DAY,
        LocalDate.now().atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
    rbmBackedTimestampSet.add(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Act and Assert
    assertEquals(rbmBackedTimestampSet, rbmBackedTimestampSet.getShallowClone());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link RBMBackedTimestampSet#equals(Object)}
   *   <li>{@link RBMBackedTimestampSet#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    RBMBackedTimestampSet rbmBackedTimestampSet = new RBMBackedTimestampSet(CommonTimeUtil.TimeBucket.SECOND);
    RBMBackedTimestampSet rbmBackedTimestampSet2 = new RBMBackedTimestampSet(CommonTimeUtil.TimeBucket.SECOND);

    // Act and Assert
    assertEquals(rbmBackedTimestampSet, rbmBackedTimestampSet2);
    int expectedHashCodeResult = rbmBackedTimestampSet.hashCode();
    assertEquals(expectedHashCodeResult, rbmBackedTimestampSet2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link RBMBackedTimestampSet#equals(Object)}
   *   <li>{@link RBMBackedTimestampSet#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    RBMBackedTimestampSet rbmBackedTimestampSet = new RBMBackedTimestampSet(CommonTimeUtil.TimeBucket.SECOND);

    // Act and Assert
    assertEquals(rbmBackedTimestampSet, rbmBackedTimestampSet);
    int expectedHashCodeResult = rbmBackedTimestampSet.hashCode();
    assertEquals(expectedHashCodeResult, rbmBackedTimestampSet.hashCode());
  }

  /**
   * Method under test:
   * {@link RBMBackedTimestampSet#fromInt(CommonTimeUtil.TimeBucket, int)}
   */
  @Test
  void testFromInt() {
    // Arrange, Act and Assert
    assertEquals(CommonTimeUtil.MILLISECONDS_IN_SECOND,
        RBMBackedTimestampSet.fromInt(CommonTimeUtil.TimeBucket.SECOND, 1));
    assertEquals(CommonTimeUtil.MILLISECONDS_IN_MINUTE,
        RBMBackedTimestampSet.fromInt(CommonTimeUtil.TimeBucket.MINUTE, 1));
    assertEquals(CommonTimeUtil.MILLISECONDS_IN_HOUR, RBMBackedTimestampSet.fromInt(CommonTimeUtil.TimeBucket.HOUR, 1));
    assertEquals(CommonTimeUtil.MILLISECONDS_IN_DAY, RBMBackedTimestampSet.fromInt(CommonTimeUtil.TimeBucket.DAY, 1));
    assertEquals(CommonTimeUtil.MILLISECONDS_IN_DAY, RBMBackedTimestampSet.fromInt(CommonTimeUtil.TimeBucket.WEEK, 1));
    assertEquals(CommonTimeUtil.MILLISECONDS_IN_DAY, RBMBackedTimestampSet.fromInt(CommonTimeUtil.TimeBucket.MONTH, 1));
    assertEquals(CommonTimeUtil.MILLISECONDS_IN_DAY, RBMBackedTimestampSet.fromInt(CommonTimeUtil.TimeBucket.YEAR, 1));
    assertThrows(IllegalStateException.class,
        () -> RBMBackedTimestampSet.fromInt(CommonTimeUtil.TimeBucket.MILLISECOND, 1));
  }

  /**
   * Method under test: {@link RBMBackedTimestampSet#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    RBMBackedTimestampSet rbmBackedTimestampSet = new RBMBackedTimestampSet(CommonTimeUtil.TimeBucket.MINUTE);

    // Act and Assert
    assertNotEquals(rbmBackedTimestampSet, new RBMBackedTimestampSet(CommonTimeUtil.TimeBucket.SECOND));
  }

  /**
   * Method under test: {@link RBMBackedTimestampSet#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new RBMBackedTimestampSet(CommonTimeUtil.TimeBucket.SECOND), null);
  }

  /**
   * Method under test: {@link RBMBackedTimestampSet#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new RBMBackedTimestampSet(CommonTimeUtil.TimeBucket.SECOND),
        "Different type to RBMBackedTimestampSet");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link RBMBackedTimestampSet#setRbm(RoaringBitmap)}
   *   <li>{@link RBMBackedTimestampSet#getRbm()}
   *   <li>{@link RBMBackedTimestampSet#getTimeBucket()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange
    RBMBackedTimestampSet rbmBackedTimestampSet = new RBMBackedTimestampSet(CommonTimeUtil.TimeBucket.SECOND);
    RoaringBitmap rbm = new RoaringBitmap();

    // Act
    rbmBackedTimestampSet.setRbm(rbm);
    RoaringBitmap actualRbm = rbmBackedTimestampSet.getRbm();

    // Assert that nothing has changed
    assertEquals(CommonTimeUtil.TimeBucket.SECOND, rbmBackedTimestampSet.getTimeBucket());
    assertSame(rbm, actualRbm);
  }

  /**
   * Method under test:
   * {@link RBMBackedTimestampSet#RBMBackedTimestampSet(CommonTimeUtil.TimeBucket)}
   */
  @Test
  void testNewRBMBackedTimestampSet() {
    // Arrange and Act
    RBMBackedTimestampSet actualRbmBackedTimestampSet = new RBMBackedTimestampSet(CommonTimeUtil.TimeBucket.SECOND);

    // Assert
    assertNull(actualRbmBackedTimestampSet.getEarliest());
    assertNull(actualRbmBackedTimestampSet.getLatest());
    RoaringBitmap rbm = actualRbmBackedTimestampSet.getRbm();
    assertEquals(0, rbm.getCardinality());
    assertEquals(0L, actualRbmBackedTimestampSet.getNumberOfTimestamps());
    assertEquals(8, rbm.getSizeInBytes());
    assertEquals(CommonTimeUtil.TimeBucket.SECOND, actualRbmBackedTimestampSet.getTimeBucket());
    assertFalse(rbm.iterator().hasNext());
    assertFalse(rbm.hasRunCompression());
    assertTrue(actualRbmBackedTimestampSet.getTimestamps().isEmpty());
    assertTrue(rbm.isEmpty());
    assertEquals(actualRbmBackedTimestampSet, actualRbmBackedTimestampSet.getShallowClone());
  }

  /**
   * Method under test:
   * {@link RBMBackedTimestampSet#RBMBackedTimestampSet(CommonTimeUtil.TimeBucket)}
   */
  @Test
  void testNewRBMBackedTimestampSet2() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> new RBMBackedTimestampSet(CommonTimeUtil.TimeBucket.MILLISECOND));
  }

  /**
   * Method under test:
   * {@link RBMBackedTimestampSet#RBMBackedTimestampSet(CommonTimeUtil.TimeBucket, Instant[])}
   */
  @Test
  void testNewRBMBackedTimestampSet3() {
    // Arrange and Act
    RBMBackedTimestampSet actualRbmBackedTimestampSet = new RBMBackedTimestampSet(CommonTimeUtil.TimeBucket.SECOND,
        LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Assert
    RoaringBitmap rbm = actualRbmBackedTimestampSet.getRbm();
    Iterator<Integer> iteratorResult = rbm.iterator();
    assertEquals(0, iteratorResult.next().intValue());
    Instant earliest = actualRbmBackedTimestampSet.getEarliest();
    assertEquals(0, earliest.getNano());
    assertEquals(0L, earliest.getEpochSecond());
    assertEquals(1, actualRbmBackedTimestampSet.getTimestamps().size());
    assertEquals(1, rbm.getCardinality());
    assertEquals(1L, actualRbmBackedTimestampSet.getNumberOfTimestamps());
    assertEquals(CommonTimeUtil.TimeBucket.SECOND, actualRbmBackedTimestampSet.getTimeBucket());
    assertFalse(iteratorResult.hasNext());
    assertFalse(rbm.hasRunCompression());
    assertFalse(rbm.isEmpty());
    assertEquals(actualRbmBackedTimestampSet, actualRbmBackedTimestampSet.getShallowClone());
    assertEquals(Short.SIZE, rbm.getSizeInBytes());
    assertSame(earliest, actualRbmBackedTimestampSet.getLatest());
  }

  /**
   * Method under test:
   * {@link RBMBackedTimestampSet#RBMBackedTimestampSet(CommonTimeUtil.TimeBucket, Instant[])}
   */
  @Test
  void testNewRBMBackedTimestampSet4() {
    // Arrange and Act
    RBMBackedTimestampSet actualRbmBackedTimestampSet = new RBMBackedTimestampSet(CommonTimeUtil.TimeBucket.MINUTE,
        LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Assert
    RoaringBitmap rbm = actualRbmBackedTimestampSet.getRbm();
    Iterator<Integer> iteratorResult = rbm.iterator();
    assertEquals(0, iteratorResult.next().intValue());
    Instant earliest = actualRbmBackedTimestampSet.getEarliest();
    assertEquals(0, earliest.getNano());
    assertEquals(0L, earliest.getEpochSecond());
    assertEquals(1, actualRbmBackedTimestampSet.getTimestamps().size());
    assertEquals(1, rbm.getCardinality());
    assertEquals(1L, actualRbmBackedTimestampSet.getNumberOfTimestamps());
    assertEquals(CommonTimeUtil.TimeBucket.MINUTE, actualRbmBackedTimestampSet.getTimeBucket());
    assertFalse(iteratorResult.hasNext());
    assertFalse(rbm.hasRunCompression());
    assertFalse(rbm.isEmpty());
    assertEquals(actualRbmBackedTimestampSet, actualRbmBackedTimestampSet.getShallowClone());
    assertEquals(Short.SIZE, rbm.getSizeInBytes());
    assertSame(earliest, actualRbmBackedTimestampSet.getLatest());
  }

  /**
   * Method under test:
   * {@link RBMBackedTimestampSet#RBMBackedTimestampSet(CommonTimeUtil.TimeBucket, Instant[])}
   */
  @Test
  void testNewRBMBackedTimestampSet5() {
    // Arrange and Act
    RBMBackedTimestampSet actualRbmBackedTimestampSet = new RBMBackedTimestampSet(CommonTimeUtil.TimeBucket.HOUR,
        LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Assert
    RoaringBitmap rbm = actualRbmBackedTimestampSet.getRbm();
    Iterator<Integer> iteratorResult = rbm.iterator();
    assertEquals(0, iteratorResult.next().intValue());
    Instant earliest = actualRbmBackedTimestampSet.getEarliest();
    assertEquals(0, earliest.getNano());
    assertEquals(0L, earliest.getEpochSecond());
    assertEquals(1, actualRbmBackedTimestampSet.getTimestamps().size());
    assertEquals(1, rbm.getCardinality());
    assertEquals(1L, actualRbmBackedTimestampSet.getNumberOfTimestamps());
    assertEquals(CommonTimeUtil.TimeBucket.HOUR, actualRbmBackedTimestampSet.getTimeBucket());
    assertFalse(iteratorResult.hasNext());
    assertFalse(rbm.hasRunCompression());
    assertFalse(rbm.isEmpty());
    assertEquals(actualRbmBackedTimestampSet, actualRbmBackedTimestampSet.getShallowClone());
    assertEquals(Short.SIZE, rbm.getSizeInBytes());
    assertSame(earliest, actualRbmBackedTimestampSet.getLatest());
  }

  /**
   * Method under test:
   * {@link RBMBackedTimestampSet#RBMBackedTimestampSet(CommonTimeUtil.TimeBucket, Instant[])}
   */
  @Test
  void testNewRBMBackedTimestampSet6() {
    // Arrange and Act
    RBMBackedTimestampSet actualRbmBackedTimestampSet = new RBMBackedTimestampSet(CommonTimeUtil.TimeBucket.DAY,
        LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Assert
    RoaringBitmap rbm = actualRbmBackedTimestampSet.getRbm();
    Iterator<Integer> iteratorResult = rbm.iterator();
    assertEquals(0, iteratorResult.next().intValue());
    Instant earliest = actualRbmBackedTimestampSet.getEarliest();
    assertEquals(0, earliest.getNano());
    assertEquals(0L, earliest.getEpochSecond());
    assertEquals(1, actualRbmBackedTimestampSet.getTimestamps().size());
    assertEquals(1, rbm.getCardinality());
    assertEquals(1L, actualRbmBackedTimestampSet.getNumberOfTimestamps());
    assertEquals(CommonTimeUtil.TimeBucket.DAY, actualRbmBackedTimestampSet.getTimeBucket());
    assertFalse(iteratorResult.hasNext());
    assertFalse(rbm.hasRunCompression());
    assertFalse(rbm.isEmpty());
    assertEquals(actualRbmBackedTimestampSet, actualRbmBackedTimestampSet.getShallowClone());
    assertEquals(Short.SIZE, rbm.getSizeInBytes());
    assertSame(earliest, actualRbmBackedTimestampSet.getLatest());
  }

  /**
   * Method under test:
   * {@link RBMBackedTimestampSet#RBMBackedTimestampSet(CommonTimeUtil.TimeBucket, Instant[])}
   */
  @Test
  void testNewRBMBackedTimestampSet7() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> new RBMBackedTimestampSet(CommonTimeUtil.TimeBucket.SECOND,
        LocalDate.ofYearDay(1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

  }

  /**
   * Method under test:
   * {@link RBMBackedTimestampSet#RBMBackedTimestampSet(CommonTimeUtil.TimeBucket, Instant[])}
   */
  @Test
  void testNewRBMBackedTimestampSet8() {
    // Arrange and Act
    RBMBackedTimestampSet actualRbmBackedTimestampSet = new RBMBackedTimestampSet(CommonTimeUtil.TimeBucket.SECOND);

    // Assert
    assertNull(actualRbmBackedTimestampSet.getEarliest());
    assertNull(actualRbmBackedTimestampSet.getLatest());
    RoaringBitmap rbm = actualRbmBackedTimestampSet.getRbm();
    assertEquals(0, rbm.getCardinality());
    assertEquals(0L, actualRbmBackedTimestampSet.getNumberOfTimestamps());
    assertEquals(8, rbm.getSizeInBytes());
    assertEquals(CommonTimeUtil.TimeBucket.SECOND, actualRbmBackedTimestampSet.getTimeBucket());
    assertFalse(rbm.iterator().hasNext());
    assertFalse(rbm.hasRunCompression());
    assertTrue(actualRbmBackedTimestampSet.getTimestamps().isEmpty());
    assertTrue(rbm.isEmpty());
    assertEquals(actualRbmBackedTimestampSet, actualRbmBackedTimestampSet.getShallowClone());
  }

  /**
   * Method under test:
   * {@link RBMBackedTimestampSet#RBMBackedTimestampSet(CommonTimeUtil.TimeBucket, Instant[])}
   */
  @Test
  void testNewRBMBackedTimestampSet9() {
    // Arrange
    Instant toInstantResult = LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant();

    // Act
    RBMBackedTimestampSet actualRbmBackedTimestampSet = new RBMBackedTimestampSet(CommonTimeUtil.TimeBucket.SECOND,
        toInstantResult, LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Assert
    RoaringBitmap rbm = actualRbmBackedTimestampSet.getRbm();
    Iterator<Integer> iteratorResult = rbm.iterator();
    assertEquals(0, iteratorResult.next().intValue());
    Instant earliest = actualRbmBackedTimestampSet.getEarliest();
    assertEquals(0, earliest.getNano());
    assertEquals(0L, earliest.getEpochSecond());
    assertEquals(1, actualRbmBackedTimestampSet.getTimestamps().size());
    assertEquals(1, rbm.getCardinality());
    assertEquals(1L, actualRbmBackedTimestampSet.getNumberOfTimestamps());
    assertEquals(CommonTimeUtil.TimeBucket.SECOND, actualRbmBackedTimestampSet.getTimeBucket());
    assertFalse(iteratorResult.hasNext());
    assertFalse(rbm.hasRunCompression());
    assertFalse(rbm.isEmpty());
    assertEquals(actualRbmBackedTimestampSet, actualRbmBackedTimestampSet.getShallowClone());
    assertEquals(Short.SIZE, rbm.getSizeInBytes());
    assertSame(earliest, actualRbmBackedTimestampSet.getLatest());
  }

  /**
   * Method under test:
   * {@link RBMBackedTimestampSet#RBMBackedTimestampSet(CommonTimeUtil.TimeBucket, Instant[])}
   */
  @Test
  void testNewRBMBackedTimestampSet10() {
    // Arrange and Act
    RBMBackedTimestampSet actualRbmBackedTimestampSet = new RBMBackedTimestampSet(CommonTimeUtil.TimeBucket.WEEK,
        LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Assert
    Instant earliest = actualRbmBackedTimestampSet.getEarliest();
    assertEquals(-259200L, earliest.getEpochSecond());
    RoaringBitmap rbm = actualRbmBackedTimestampSet.getRbm();
    Iterator<Integer> iteratorResult = rbm.iterator();
    assertEquals(-3, iteratorResult.next().intValue());
    assertEquals(0, earliest.getNano());
    assertEquals(1, actualRbmBackedTimestampSet.getTimestamps().size());
    assertEquals(1, rbm.getCardinality());
    assertEquals(1L, actualRbmBackedTimestampSet.getNumberOfTimestamps());
    assertEquals(CommonTimeUtil.TimeBucket.WEEK, actualRbmBackedTimestampSet.getTimeBucket());
    assertFalse(iteratorResult.hasNext());
    assertFalse(rbm.hasRunCompression());
    assertFalse(rbm.isEmpty());
    assertEquals(earliest, actualRbmBackedTimestampSet.getLatest());
    assertEquals(Short.SIZE, rbm.getSizeInBytes());
  }

  /**
   * Method under test:
   * {@link RBMBackedTimestampSet#RBMBackedTimestampSet(CommonTimeUtil.TimeBucket, Instant[])}
   */
  @Test
  void testNewRBMBackedTimestampSet11() {
    // Arrange
    Instant toInstantResult = LocalDate.now().atStartOfDay().atZone(ZoneOffset.UTC).toInstant();

    // Act
    RBMBackedTimestampSet actualRbmBackedTimestampSet = new RBMBackedTimestampSet(CommonTimeUtil.TimeBucket.SECOND,
        toInstantResult, LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Assert
    RoaringBitmap rbm = actualRbmBackedTimestampSet.getRbm();
    assertEquals(0, rbm.iterator().next().intValue());
    Instant earliest = actualRbmBackedTimestampSet.getEarliest();
    assertEquals(0, earliest.getNano());
    assertEquals(0L, earliest.getEpochSecond());
    assertEquals(CommonTimeUtil.TimeBucket.SECOND, actualRbmBackedTimestampSet.getTimeBucket());
    assertFalse(rbm.hasRunCompression());
    assertFalse(rbm.isEmpty());
    assertEquals(actualRbmBackedTimestampSet, actualRbmBackedTimestampSet.getShallowClone());
  }

  /**
   * Method under test:
   * {@link RBMBackedTimestampSet#RBMBackedTimestampSet(CommonTimeUtil.TimeBucket, Instant[])}
   */
  @Test
  void testNewRBMBackedTimestampSet12() {
    // Arrange
    Instant toInstantResult = LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant();

    // Act
    RBMBackedTimestampSet actualRbmBackedTimestampSet = new RBMBackedTimestampSet(CommonTimeUtil.TimeBucket.SECOND,
        toInstantResult, LocalDate.now().atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Assert
    RoaringBitmap rbm = actualRbmBackedTimestampSet.getRbm();
    assertEquals(0, rbm.iterator().next().intValue());
    Instant earliest = actualRbmBackedTimestampSet.getEarliest();
    assertEquals(0, earliest.getNano());
    assertEquals(0L, earliest.getEpochSecond());
    assertEquals(CommonTimeUtil.TimeBucket.SECOND, actualRbmBackedTimestampSet.getTimeBucket());
    assertFalse(rbm.hasRunCompression());
    assertFalse(rbm.isEmpty());
    assertEquals(actualRbmBackedTimestampSet, actualRbmBackedTimestampSet.getShallowClone());
  }

  /**
   * Method under test:
   * {@link RBMBackedTimestampSet#RBMBackedTimestampSet(CommonTimeUtil.TimeBucket, Instant[])}
   */
  @Test
  void testNewRBMBackedTimestampSet13() {
    // Arrange and Act
    RBMBackedTimestampSet actualRbmBackedTimestampSet = new RBMBackedTimestampSet(CommonTimeUtil.TimeBucket.MONTH,
        LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Assert
    RoaringBitmap rbm = actualRbmBackedTimestampSet.getRbm();
    Iterator<Integer> iteratorResult = rbm.iterator();
    assertEquals(0, iteratorResult.next().intValue());
    Instant earliest = actualRbmBackedTimestampSet.getEarliest();
    assertEquals(0, earliest.getNano());
    assertEquals(0L, earliest.getEpochSecond());
    assertEquals(1, actualRbmBackedTimestampSet.getTimestamps().size());
    assertEquals(1, rbm.getCardinality());
    assertEquals(1L, actualRbmBackedTimestampSet.getNumberOfTimestamps());
    assertEquals(CommonTimeUtil.TimeBucket.MONTH, actualRbmBackedTimestampSet.getTimeBucket());
    assertFalse(iteratorResult.hasNext());
    assertFalse(rbm.hasRunCompression());
    assertFalse(rbm.isEmpty());
    assertEquals(actualRbmBackedTimestampSet, actualRbmBackedTimestampSet.getShallowClone());
    assertEquals(Short.SIZE, rbm.getSizeInBytes());
    assertSame(earliest, actualRbmBackedTimestampSet.getLatest());
  }

  /**
   * Method under test:
   * {@link RBMBackedTimestampSet#RBMBackedTimestampSet(CommonTimeUtil.TimeBucket, Instant[])}
   */
  @Test
  void testNewRBMBackedTimestampSet14() {
    // Arrange and Act
    RBMBackedTimestampSet actualRbmBackedTimestampSet = new RBMBackedTimestampSet(CommonTimeUtil.TimeBucket.YEAR,
        LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Assert
    RoaringBitmap rbm = actualRbmBackedTimestampSet.getRbm();
    Iterator<Integer> iteratorResult = rbm.iterator();
    assertEquals(0, iteratorResult.next().intValue());
    Instant earliest = actualRbmBackedTimestampSet.getEarliest();
    assertEquals(0, earliest.getNano());
    assertEquals(0L, earliest.getEpochSecond());
    assertEquals(1, actualRbmBackedTimestampSet.getTimestamps().size());
    assertEquals(1, rbm.getCardinality());
    assertEquals(1L, actualRbmBackedTimestampSet.getNumberOfTimestamps());
    assertEquals(CommonTimeUtil.TimeBucket.YEAR, actualRbmBackedTimestampSet.getTimeBucket());
    assertFalse(iteratorResult.hasNext());
    assertFalse(rbm.hasRunCompression());
    assertFalse(rbm.isEmpty());
    assertEquals(actualRbmBackedTimestampSet, actualRbmBackedTimestampSet.getShallowClone());
    assertEquals(Short.SIZE, rbm.getSizeInBytes());
    assertSame(earliest, actualRbmBackedTimestampSet.getLatest());
  }

  /**
   * Method under test:
   * {@link RBMBackedTimestampSet#RBMBackedTimestampSet(CommonTimeUtil.TimeBucket, Instant[])}
   */
  @Test
  void testNewRBMBackedTimestampSet15() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> new RBMBackedTimestampSet(CommonTimeUtil.TimeBucket.MILLISECOND,
        LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

  }
}
