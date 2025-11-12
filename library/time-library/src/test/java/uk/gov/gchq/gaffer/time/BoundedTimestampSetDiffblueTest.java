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

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
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
import org.apache.datasketches.sampling.ReservoirLongsSketch;
import org.apache.datasketches.sampling.ReservoirLongsUnion;
import org.junit.jupiter.api.Test;
import org.roaringbitmap.RoaringBitmap;

class BoundedTimestampSetDiffblueTest {
  /**
   * Method under test: {@link BoundedTimestampSet#add(Instant)}
   */
  @Test
  void testAdd() {
    // Arrange
    BoundedTimestampSet boundedTimestampSet = new BoundedTimestampSet(CommonTimeUtil.TimeBucket.SECOND, 3);
    Instant instant = LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant();

    // Act
    boundedTimestampSet.add(instant);

    // Assert
    RBMBackedTimestampSet rbmBackedTimestampSet = boundedTimestampSet.getRbmBackedTimestampSet();
    RoaringBitmap rbm = rbmBackedTimestampSet.getRbm();
    Iterator<Integer> iteratorResult = rbm.iterator();
    assertEquals(0, iteratorResult.next().intValue());
    assertEquals(1, boundedTimestampSet.getTimestamps().size());
    assertEquals(1, rbmBackedTimestampSet.getTimestamps().size());
    assertEquals(1, rbm.getCardinality());
    assertEquals(1L, boundedTimestampSet.getNumberOfTimestamps());
    assertEquals(1L, rbmBackedTimestampSet.getNumberOfTimestamps());
    assertFalse(iteratorResult.hasNext());
    assertFalse(rbm.isEmpty());
    assertEquals(rbmBackedTimestampSet, rbmBackedTimestampSet.getShallowClone());
    assertEquals(Short.SIZE, rbm.getSizeInBytes());
    Instant instant2 = instant.EPOCH;
    assertSame(instant2, boundedTimestampSet.getEarliest());
    assertSame(instant2, boundedTimestampSet.getLatest());
    assertSame(instant2, rbmBackedTimestampSet.getEarliest());
    assertSame(instant2, rbmBackedTimestampSet.getLatest());
  }

  /**
   * Method under test: {@link BoundedTimestampSet#add(Instant)}
   */
  @Test
  void testAdd2() {
    // Arrange
    BoundedTimestampSet boundedTimestampSet = new BoundedTimestampSet(CommonTimeUtil.TimeBucket.MINUTE, 3);
    Instant instant = LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant();

    // Act
    boundedTimestampSet.add(instant);

    // Assert
    RBMBackedTimestampSet rbmBackedTimestampSet = boundedTimestampSet.getRbmBackedTimestampSet();
    RoaringBitmap rbm = rbmBackedTimestampSet.getRbm();
    Iterator<Integer> iteratorResult = rbm.iterator();
    assertEquals(0, iteratorResult.next().intValue());
    assertEquals(1, boundedTimestampSet.getTimestamps().size());
    assertEquals(1, rbmBackedTimestampSet.getTimestamps().size());
    assertEquals(1, rbm.getCardinality());
    assertEquals(1L, boundedTimestampSet.getNumberOfTimestamps());
    assertEquals(1L, rbmBackedTimestampSet.getNumberOfTimestamps());
    assertFalse(iteratorResult.hasNext());
    assertFalse(rbm.isEmpty());
    assertEquals(rbmBackedTimestampSet, rbmBackedTimestampSet.getShallowClone());
    assertEquals(Short.SIZE, rbm.getSizeInBytes());
    Instant instant2 = instant.EPOCH;
    assertSame(instant2, boundedTimestampSet.getEarliest());
    assertSame(instant2, boundedTimestampSet.getLatest());
    assertSame(instant2, rbmBackedTimestampSet.getEarliest());
    assertSame(instant2, rbmBackedTimestampSet.getLatest());
  }

  /**
   * Method under test: {@link BoundedTimestampSet#add(Instant)}
   */
  @Test
  void testAdd3() {
    // Arrange
    BoundedTimestampSet boundedTimestampSet = new BoundedTimestampSet(CommonTimeUtil.TimeBucket.HOUR, 3);
    Instant instant = LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant();

    // Act
    boundedTimestampSet.add(instant);

    // Assert
    RBMBackedTimestampSet rbmBackedTimestampSet = boundedTimestampSet.getRbmBackedTimestampSet();
    RoaringBitmap rbm = rbmBackedTimestampSet.getRbm();
    Iterator<Integer> iteratorResult = rbm.iterator();
    assertEquals(0, iteratorResult.next().intValue());
    assertEquals(1, boundedTimestampSet.getTimestamps().size());
    assertEquals(1, rbmBackedTimestampSet.getTimestamps().size());
    assertEquals(1, rbm.getCardinality());
    assertEquals(1L, boundedTimestampSet.getNumberOfTimestamps());
    assertEquals(1L, rbmBackedTimestampSet.getNumberOfTimestamps());
    assertFalse(iteratorResult.hasNext());
    assertFalse(rbm.isEmpty());
    assertEquals(rbmBackedTimestampSet, rbmBackedTimestampSet.getShallowClone());
    assertEquals(Short.SIZE, rbm.getSizeInBytes());
    Instant instant2 = instant.EPOCH;
    assertSame(instant2, boundedTimestampSet.getEarliest());
    assertSame(instant2, boundedTimestampSet.getLatest());
    assertSame(instant2, rbmBackedTimestampSet.getEarliest());
    assertSame(instant2, rbmBackedTimestampSet.getLatest());
  }

  /**
   * Method under test: {@link BoundedTimestampSet#add(Instant)}
   */
  @Test
  void testAdd4() {
    // Arrange
    BoundedTimestampSet boundedTimestampSet = new BoundedTimestampSet(CommonTimeUtil.TimeBucket.DAY, 3);
    Instant instant = LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant();

    // Act
    boundedTimestampSet.add(instant);

    // Assert
    RBMBackedTimestampSet rbmBackedTimestampSet = boundedTimestampSet.getRbmBackedTimestampSet();
    RoaringBitmap rbm = rbmBackedTimestampSet.getRbm();
    Iterator<Integer> iteratorResult = rbm.iterator();
    assertEquals(0, iteratorResult.next().intValue());
    assertEquals(1, boundedTimestampSet.getTimestamps().size());
    assertEquals(1, rbmBackedTimestampSet.getTimestamps().size());
    assertEquals(1, rbm.getCardinality());
    assertEquals(1L, boundedTimestampSet.getNumberOfTimestamps());
    assertEquals(1L, rbmBackedTimestampSet.getNumberOfTimestamps());
    assertFalse(iteratorResult.hasNext());
    assertFalse(rbm.isEmpty());
    assertEquals(rbmBackedTimestampSet, rbmBackedTimestampSet.getShallowClone());
    assertEquals(Short.SIZE, rbm.getSizeInBytes());
    Instant instant2 = instant.EPOCH;
    assertSame(instant2, boundedTimestampSet.getEarliest());
    assertSame(instant2, boundedTimestampSet.getLatest());
    assertSame(instant2, rbmBackedTimestampSet.getEarliest());
    assertSame(instant2, rbmBackedTimestampSet.getLatest());
  }

  /**
   * Method under test: {@link BoundedTimestampSet#add(Instant)}
   */
  @Test
  void testAdd5() {
    // Arrange
    BoundedTimestampSet boundedTimestampSet = new BoundedTimestampSet(CommonTimeUtil.TimeBucket.SECOND, 3);
    boundedTimestampSet.add(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
    Instant instant = LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant();

    // Act
    boundedTimestampSet.add(instant);

    // Assert
    RBMBackedTimestampSet rbmBackedTimestampSet = boundedTimestampSet.getRbmBackedTimestampSet();
    RoaringBitmap rbm = rbmBackedTimestampSet.getRbm();
    Iterator<Integer> iteratorResult = rbm.iterator();
    assertEquals(0, iteratorResult.next().intValue());
    assertEquals(1, boundedTimestampSet.getTimestamps().size());
    assertEquals(1, rbmBackedTimestampSet.getTimestamps().size());
    assertEquals(1, rbm.getCardinality());
    assertEquals(1L, boundedTimestampSet.getNumberOfTimestamps());
    assertEquals(1L, rbmBackedTimestampSet.getNumberOfTimestamps());
    assertFalse(iteratorResult.hasNext());
    assertFalse(rbm.isEmpty());
    assertEquals(rbmBackedTimestampSet, rbmBackedTimestampSet.getShallowClone());
    assertEquals(Short.SIZE, rbm.getSizeInBytes());
    Instant instant2 = instant.EPOCH;
    assertSame(instant2, boundedTimestampSet.getEarliest());
    assertSame(instant2, boundedTimestampSet.getLatest());
    assertSame(instant2, rbmBackedTimestampSet.getEarliest());
    assertSame(instant2, rbmBackedTimestampSet.getLatest());
  }

  /**
   * Method under test: {@link BoundedTimestampSet#add(Instant)}
   */
  @Test
  void testAdd6() {
    // Arrange
    BoundedTimestampSet boundedTimestampSet = new BoundedTimestampSet(CommonTimeUtil.TimeBucket.WEEK, 3);

    // Act
    boundedTimestampSet.add(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Assert
    Instant earliest = boundedTimestampSet.getEarliest();
    assertEquals(-259200L, earliest.getEpochSecond());
    RBMBackedTimestampSet rbmBackedTimestampSet = boundedTimestampSet.getRbmBackedTimestampSet();
    RoaringBitmap rbm = rbmBackedTimestampSet.getRbm();
    Iterator<Integer> iteratorResult = rbm.iterator();
    assertEquals(-3, iteratorResult.next().intValue());
    assertEquals(0, earliest.getNano());
    assertEquals(1, boundedTimestampSet.getTimestamps().size());
    assertEquals(1, rbmBackedTimestampSet.getTimestamps().size());
    assertEquals(1, rbm.getCardinality());
    assertEquals(1L, boundedTimestampSet.getNumberOfTimestamps());
    assertEquals(1L, rbmBackedTimestampSet.getNumberOfTimestamps());
    assertFalse(iteratorResult.hasNext());
    assertFalse(rbm.isEmpty());
    assertEquals(earliest, boundedTimestampSet.getLatest());
    assertEquals(earliest, rbmBackedTimestampSet.getEarliest());
    assertEquals(earliest, rbmBackedTimestampSet.getLatest());
    assertEquals(Short.SIZE, rbm.getSizeInBytes());
  }

  /**
   * Method under test: {@link BoundedTimestampSet#add(Instant)}
   */
  @Test
  void testAdd7() {
    // Arrange
    BoundedTimestampSet boundedTimestampSet = new BoundedTimestampSet(CommonTimeUtil.TimeBucket.MONTH, 3);
    Instant instant = LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant();

    // Act
    boundedTimestampSet.add(instant);

    // Assert
    RBMBackedTimestampSet rbmBackedTimestampSet = boundedTimestampSet.getRbmBackedTimestampSet();
    RoaringBitmap rbm = rbmBackedTimestampSet.getRbm();
    Iterator<Integer> iteratorResult = rbm.iterator();
    assertEquals(0, iteratorResult.next().intValue());
    assertEquals(1, boundedTimestampSet.getTimestamps().size());
    assertEquals(1, rbmBackedTimestampSet.getTimestamps().size());
    assertEquals(1, rbm.getCardinality());
    assertEquals(1L, boundedTimestampSet.getNumberOfTimestamps());
    assertEquals(1L, rbmBackedTimestampSet.getNumberOfTimestamps());
    assertFalse(iteratorResult.hasNext());
    assertFalse(rbm.isEmpty());
    assertEquals(rbmBackedTimestampSet, rbmBackedTimestampSet.getShallowClone());
    assertEquals(Short.SIZE, rbm.getSizeInBytes());
    Instant instant2 = instant.EPOCH;
    assertSame(instant2, boundedTimestampSet.getEarliest());
    assertSame(instant2, boundedTimestampSet.getLatest());
    assertSame(instant2, rbmBackedTimestampSet.getEarliest());
    assertSame(instant2, rbmBackedTimestampSet.getLatest());
  }

  /**
   * Method under test: {@link BoundedTimestampSet#add(Instant)}
   */
  @Test
  void testAdd8() {
    // Arrange
    BoundedTimestampSet boundedTimestampSet = new BoundedTimestampSet(CommonTimeUtil.TimeBucket.YEAR, 3);
    Instant instant = LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant();

    // Act
    boundedTimestampSet.add(instant);

    // Assert
    RBMBackedTimestampSet rbmBackedTimestampSet = boundedTimestampSet.getRbmBackedTimestampSet();
    RoaringBitmap rbm = rbmBackedTimestampSet.getRbm();
    Iterator<Integer> iteratorResult = rbm.iterator();
    assertEquals(0, iteratorResult.next().intValue());
    assertEquals(1, boundedTimestampSet.getTimestamps().size());
    assertEquals(1, rbmBackedTimestampSet.getTimestamps().size());
    assertEquals(1, rbm.getCardinality());
    assertEquals(1L, boundedTimestampSet.getNumberOfTimestamps());
    assertEquals(1L, rbmBackedTimestampSet.getNumberOfTimestamps());
    assertFalse(iteratorResult.hasNext());
    assertFalse(rbm.isEmpty());
    assertEquals(rbmBackedTimestampSet, rbmBackedTimestampSet.getShallowClone());
    assertEquals(Short.SIZE, rbm.getSizeInBytes());
    Instant instant2 = instant.EPOCH;
    assertSame(instant2, boundedTimestampSet.getEarliest());
    assertSame(instant2, boundedTimestampSet.getLatest());
    assertSame(instant2, rbmBackedTimestampSet.getEarliest());
    assertSame(instant2, rbmBackedTimestampSet.getLatest());
  }

  /**
   * Method under test: {@link BoundedTimestampSet#add(Collection)}
   */
  @Test
  void testAdd9() {
    // Arrange
    BoundedTimestampSet boundedTimestampSet = new BoundedTimestampSet(CommonTimeUtil.TimeBucket.SECOND, 3);

    // Act
    boundedTimestampSet.add(new ArrayList<>());

    // Assert
    assertNull(boundedTimestampSet.getEarliest());
    assertNull(boundedTimestampSet.getLatest());
    RBMBackedTimestampSet rbmBackedTimestampSet = boundedTimestampSet.getRbmBackedTimestampSet();
    assertNull(rbmBackedTimestampSet.getEarliest());
    assertNull(rbmBackedTimestampSet.getLatest());
    RoaringBitmap rbm = rbmBackedTimestampSet.getRbm();
    assertEquals(0, rbm.getCardinality());
    assertEquals(0L, boundedTimestampSet.getNumberOfTimestamps());
    assertEquals(0L, rbmBackedTimestampSet.getNumberOfTimestamps());
    assertEquals(8, rbm.getSizeInBytes());
    assertFalse(rbm.iterator().hasNext());
    assertTrue(boundedTimestampSet.getTimestamps().isEmpty());
    assertTrue(rbmBackedTimestampSet.getTimestamps().isEmpty());
    assertTrue(rbm.isEmpty());
    assertEquals(rbmBackedTimestampSet, rbmBackedTimestampSet.getShallowClone());
  }

  /**
   * Method under test: {@link BoundedTimestampSet#add(Collection)}
   */
  @Test
  void testAdd10() {
    // Arrange
    BoundedTimestampSet boundedTimestampSet = new BoundedTimestampSet(CommonTimeUtil.TimeBucket.SECOND, 3);

    ArrayList<Instant> instants = new ArrayList<>();
    instants.add(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Act
    boundedTimestampSet.add(instants);

    // Assert
    RBMBackedTimestampSet rbmBackedTimestampSet = boundedTimestampSet.getRbmBackedTimestampSet();
    RoaringBitmap rbm = rbmBackedTimestampSet.getRbm();
    Iterator<Integer> iteratorResult = rbm.iterator();
    assertEquals(0, iteratorResult.next().intValue());
    assertEquals(1, boundedTimestampSet.getTimestamps().size());
    assertEquals(1, rbmBackedTimestampSet.getTimestamps().size());
    assertEquals(1, rbm.getCardinality());
    assertEquals(1L, boundedTimestampSet.getNumberOfTimestamps());
    assertEquals(1L, rbmBackedTimestampSet.getNumberOfTimestamps());
    assertFalse(iteratorResult.hasNext());
    assertFalse(rbm.isEmpty());
    assertEquals(rbmBackedTimestampSet, rbmBackedTimestampSet.getShallowClone());
    assertEquals(Short.SIZE, rbm.getSizeInBytes());
  }

  /**
   * Method under test: {@link BoundedTimestampSet#add(Collection)}
   */
  @Test
  void testAdd11() {
    // Arrange
    BoundedTimestampSet boundedTimestampSet = new BoundedTimestampSet(CommonTimeUtil.TimeBucket.SECOND, 3);

    ArrayList<Instant> instants = new ArrayList<>();
    instants.add(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
    instants.add(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Act
    boundedTimestampSet.add(instants);

    // Assert
    RBMBackedTimestampSet rbmBackedTimestampSet = boundedTimestampSet.getRbmBackedTimestampSet();
    RoaringBitmap rbm = rbmBackedTimestampSet.getRbm();
    Iterator<Integer> iteratorResult = rbm.iterator();
    assertEquals(0, iteratorResult.next().intValue());
    assertEquals(1, boundedTimestampSet.getTimestamps().size());
    assertEquals(1, rbmBackedTimestampSet.getTimestamps().size());
    assertEquals(1, rbm.getCardinality());
    assertEquals(1L, boundedTimestampSet.getNumberOfTimestamps());
    assertEquals(1L, rbmBackedTimestampSet.getNumberOfTimestamps());
    assertFalse(iteratorResult.hasNext());
    assertFalse(rbm.isEmpty());
    assertEquals(rbmBackedTimestampSet, rbmBackedTimestampSet.getShallowClone());
    assertEquals(Short.SIZE, rbm.getSizeInBytes());
  }

  /**
   * Method under test: {@link BoundedTimestampSet#add(Collection)}
   */
  @Test
  void testAdd12() {
    // Arrange
    BoundedTimestampSet boundedTimestampSet = new BoundedTimestampSet(CommonTimeUtil.TimeBucket.MINUTE, 3);

    ArrayList<Instant> instants = new ArrayList<>();
    instants.add(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Act
    boundedTimestampSet.add(instants);

    // Assert
    RBMBackedTimestampSet rbmBackedTimestampSet = boundedTimestampSet.getRbmBackedTimestampSet();
    RoaringBitmap rbm = rbmBackedTimestampSet.getRbm();
    Iterator<Integer> iteratorResult = rbm.iterator();
    assertEquals(0, iteratorResult.next().intValue());
    assertEquals(1, boundedTimestampSet.getTimestamps().size());
    assertEquals(1, rbmBackedTimestampSet.getTimestamps().size());
    assertEquals(1, rbm.getCardinality());
    assertEquals(1L, boundedTimestampSet.getNumberOfTimestamps());
    assertEquals(1L, rbmBackedTimestampSet.getNumberOfTimestamps());
    assertFalse(iteratorResult.hasNext());
    assertFalse(rbm.isEmpty());
    assertEquals(rbmBackedTimestampSet, rbmBackedTimestampSet.getShallowClone());
    assertEquals(Short.SIZE, rbm.getSizeInBytes());
  }

  /**
   * Method under test: {@link BoundedTimestampSet#add(Collection)}
   */
  @Test
  void testAdd13() {
    // Arrange
    BoundedTimestampSet boundedTimestampSet = new BoundedTimestampSet(CommonTimeUtil.TimeBucket.HOUR, 3);

    ArrayList<Instant> instants = new ArrayList<>();
    instants.add(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Act
    boundedTimestampSet.add(instants);

    // Assert
    RBMBackedTimestampSet rbmBackedTimestampSet = boundedTimestampSet.getRbmBackedTimestampSet();
    RoaringBitmap rbm = rbmBackedTimestampSet.getRbm();
    Iterator<Integer> iteratorResult = rbm.iterator();
    assertEquals(0, iteratorResult.next().intValue());
    assertEquals(1, boundedTimestampSet.getTimestamps().size());
    assertEquals(1, rbmBackedTimestampSet.getTimestamps().size());
    assertEquals(1, rbm.getCardinality());
    assertEquals(1L, boundedTimestampSet.getNumberOfTimestamps());
    assertEquals(1L, rbmBackedTimestampSet.getNumberOfTimestamps());
    assertFalse(iteratorResult.hasNext());
    assertFalse(rbm.isEmpty());
    assertEquals(rbmBackedTimestampSet, rbmBackedTimestampSet.getShallowClone());
    assertEquals(Short.SIZE, rbm.getSizeInBytes());
  }

  /**
   * Method under test: {@link BoundedTimestampSet#add(Collection)}
   */
  @Test
  void testAdd14() {
    // Arrange
    BoundedTimestampSet boundedTimestampSet = new BoundedTimestampSet(CommonTimeUtil.TimeBucket.DAY, 3);

    ArrayList<Instant> instants = new ArrayList<>();
    instants.add(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Act
    boundedTimestampSet.add(instants);

    // Assert
    RBMBackedTimestampSet rbmBackedTimestampSet = boundedTimestampSet.getRbmBackedTimestampSet();
    RoaringBitmap rbm = rbmBackedTimestampSet.getRbm();
    Iterator<Integer> iteratorResult = rbm.iterator();
    assertEquals(0, iteratorResult.next().intValue());
    assertEquals(1, boundedTimestampSet.getTimestamps().size());
    assertEquals(1, rbmBackedTimestampSet.getTimestamps().size());
    assertEquals(1, rbm.getCardinality());
    assertEquals(1L, boundedTimestampSet.getNumberOfTimestamps());
    assertEquals(1L, rbmBackedTimestampSet.getNumberOfTimestamps());
    assertFalse(iteratorResult.hasNext());
    assertFalse(rbm.isEmpty());
    assertEquals(rbmBackedTimestampSet, rbmBackedTimestampSet.getShallowClone());
    assertEquals(Short.SIZE, rbm.getSizeInBytes());
  }

  /**
   * Method under test: {@link BoundedTimestampSet#add(Collection)}
   */
  @Test
  void testAdd15() {
    // Arrange
    BoundedTimestampSet boundedTimestampSet = new BoundedTimestampSet(CommonTimeUtil.TimeBucket.WEEK, 3);

    ArrayList<Instant> instants = new ArrayList<>();
    instants.add(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Act
    boundedTimestampSet.add(instants);

    // Assert
    Instant earliest = boundedTimestampSet.getEarliest();
    assertEquals(-259200L, earliest.getEpochSecond());
    RBMBackedTimestampSet rbmBackedTimestampSet = boundedTimestampSet.getRbmBackedTimestampSet();
    RoaringBitmap rbm = rbmBackedTimestampSet.getRbm();
    Iterator<Integer> iteratorResult = rbm.iterator();
    assertEquals(-3, iteratorResult.next().intValue());
    assertEquals(0, earliest.getNano());
    assertEquals(1, boundedTimestampSet.getTimestamps().size());
    assertEquals(1, rbmBackedTimestampSet.getTimestamps().size());
    assertEquals(1, rbm.getCardinality());
    assertEquals(1L, boundedTimestampSet.getNumberOfTimestamps());
    assertEquals(1L, rbmBackedTimestampSet.getNumberOfTimestamps());
    assertFalse(iteratorResult.hasNext());
    assertFalse(rbm.isEmpty());
    assertEquals(earliest, boundedTimestampSet.getLatest());
    assertEquals(earliest, rbmBackedTimestampSet.getEarliest());
    assertEquals(earliest, rbmBackedTimestampSet.getLatest());
    assertEquals(Short.SIZE, rbm.getSizeInBytes());
  }

  /**
   * Method under test: {@link BoundedTimestampSet#add(Collection)}
   */
  @Test
  void testAdd16() {
    // Arrange
    BoundedTimestampSet boundedTimestampSet = new BoundedTimestampSet(CommonTimeUtil.TimeBucket.MONTH, 3);

    ArrayList<Instant> instants = new ArrayList<>();
    instants.add(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Act
    boundedTimestampSet.add(instants);

    // Assert
    RBMBackedTimestampSet rbmBackedTimestampSet = boundedTimestampSet.getRbmBackedTimestampSet();
    RoaringBitmap rbm = rbmBackedTimestampSet.getRbm();
    Iterator<Integer> iteratorResult = rbm.iterator();
    assertEquals(0, iteratorResult.next().intValue());
    assertEquals(1, boundedTimestampSet.getTimestamps().size());
    assertEquals(1, rbmBackedTimestampSet.getTimestamps().size());
    assertEquals(1, rbm.getCardinality());
    assertEquals(1L, boundedTimestampSet.getNumberOfTimestamps());
    assertEquals(1L, rbmBackedTimestampSet.getNumberOfTimestamps());
    assertFalse(iteratorResult.hasNext());
    assertFalse(rbm.isEmpty());
    assertEquals(rbmBackedTimestampSet, rbmBackedTimestampSet.getShallowClone());
    assertEquals(Short.SIZE, rbm.getSizeInBytes());
  }

  /**
   * Method under test: {@link BoundedTimestampSet#add(Collection)}
   */
  @Test
  void testAdd17() {
    // Arrange
    BoundedTimestampSet boundedTimestampSet = new BoundedTimestampSet(CommonTimeUtil.TimeBucket.YEAR, 3);

    ArrayList<Instant> instants = new ArrayList<>();
    instants.add(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Act
    boundedTimestampSet.add(instants);

    // Assert
    RBMBackedTimestampSet rbmBackedTimestampSet = boundedTimestampSet.getRbmBackedTimestampSet();
    RoaringBitmap rbm = rbmBackedTimestampSet.getRbm();
    Iterator<Integer> iteratorResult = rbm.iterator();
    assertEquals(0, iteratorResult.next().intValue());
    assertEquals(1, boundedTimestampSet.getTimestamps().size());
    assertEquals(1, rbmBackedTimestampSet.getTimestamps().size());
    assertEquals(1, rbm.getCardinality());
    assertEquals(1L, boundedTimestampSet.getNumberOfTimestamps());
    assertEquals(1L, rbmBackedTimestampSet.getNumberOfTimestamps());
    assertFalse(iteratorResult.hasNext());
    assertFalse(rbm.isEmpty());
    assertEquals(rbmBackedTimestampSet, rbmBackedTimestampSet.getShallowClone());
    assertEquals(Short.SIZE, rbm.getSizeInBytes());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link BoundedTimestampSet.Builder#build()}
   *   <li>default or parameterless constructor of
   * {@link BoundedTimestampSet.Builder}
   *   <li>{@link BoundedTimestampSet.Builder#maxSize(int)}
   *   <li>{@link BoundedTimestampSet.Builder#state(BoundedTimestampSet.State)}
   *   <li>{@link BoundedTimestampSet.Builder#timeBucket(CommonTimeUtil.TimeBucket)}
   * </ul>
   */
  @Test
  void testBuilderBuild() {
    // Arrange and Act
    BoundedTimestampSet actualBuildResult = (new BoundedTimestampSet.Builder()).maxSize(3)
        .state(BoundedTimestampSet.State.NOT_FULL)
        .timeBucket(CommonTimeUtil.TimeBucket.SECOND)
        .build();

    // Assert
    assertNull(actualBuildResult.getEarliest());
    assertNull(actualBuildResult.getLatest());
    RBMBackedTimestampSet rbmBackedTimestampSet = actualBuildResult.getRbmBackedTimestampSet();
    assertNull(rbmBackedTimestampSet.getEarliest());
    assertNull(rbmBackedTimestampSet.getLatest());
    RoaringBitmap rbm = rbmBackedTimestampSet.getRbm();
    assertEquals(0, rbm.getCardinality());
    assertEquals(0L, actualBuildResult.getNumberOfTimestamps());
    assertEquals(0L, rbmBackedTimestampSet.getNumberOfTimestamps());
    assertEquals(3, actualBuildResult.getMaxSize());
    assertEquals(8, rbm.getSizeInBytes());
    assertEquals(BoundedTimestampSet.State.NOT_FULL, actualBuildResult.getState());
    assertEquals(CommonTimeUtil.TimeBucket.SECOND, actualBuildResult.getTimeBucket());
    assertEquals(CommonTimeUtil.TimeBucket.SECOND, rbmBackedTimestampSet.getTimeBucket());
    assertFalse(rbm.iterator().hasNext());
    assertFalse(rbm.hasRunCompression());
    assertTrue(rbm.isEmpty());
  }

  /**
   * Method under test: {@link BoundedTimestampSet#getTimestamps()}
   */
  @Test
  void testGetTimestamps() {
    // Arrange, Act and Assert
    assertTrue((new BoundedTimestampSet(CommonTimeUtil.TimeBucket.SECOND, 3)).getTimestamps().isEmpty());
  }

  /**
   * Method under test: {@link BoundedTimestampSet#getTimestamps()}
   */
  @Test
  void testGetTimestamps2() {
    // Arrange
    BoundedTimestampSet boundedTimestampSet = new BoundedTimestampSet(CommonTimeUtil.TimeBucket.SECOND, 3);
    boundedTimestampSet.add(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Act and Assert
    assertEquals(1, boundedTimestampSet.getTimestamps().size());
  }

  /**
   * Method under test: {@link BoundedTimestampSet#getTimestamps()}
   */
  @Test
  void testGetTimestamps3() {
    // Arrange
    BoundedTimestampSet boundedTimestampSet = new BoundedTimestampSet(CommonTimeUtil.TimeBucket.MINUTE, 3);
    boundedTimestampSet.add(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Act and Assert
    assertEquals(1, boundedTimestampSet.getTimestamps().size());
  }

  /**
   * Method under test: {@link BoundedTimestampSet#getTimestamps()}
   */
  @Test
  void testGetTimestamps4() {
    // Arrange
    BoundedTimestampSet boundedTimestampSet = new BoundedTimestampSet(CommonTimeUtil.TimeBucket.HOUR, 3);
    boundedTimestampSet.add(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Act and Assert
    assertEquals(1, boundedTimestampSet.getTimestamps().size());
  }

  /**
   * Method under test: {@link BoundedTimestampSet#getTimestamps()}
   */
  @Test
  void testGetTimestamps5() {
    // Arrange
    BoundedTimestampSet boundedTimestampSet = new BoundedTimestampSet(CommonTimeUtil.TimeBucket.DAY, 3);
    boundedTimestampSet.add(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Act and Assert
    assertEquals(1, boundedTimestampSet.getTimestamps().size());
  }

  /**
   * Method under test: {@link BoundedTimestampSet#getTimestamps()}
   */
  @Test
  void testGetTimestamps6() {
    // Arrange
    BoundedTimestampSet boundedTimestampSet = new BoundedTimestampSet(CommonTimeUtil.TimeBucket.WEEK, 3);
    boundedTimestampSet.add(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Act and Assert
    assertEquals(1, boundedTimestampSet.getTimestamps().size());
  }

  /**
   * Method under test: {@link BoundedTimestampSet#getTimestamps()}
   */
  @Test
  void testGetTimestamps7() {
    // Arrange
    BoundedTimestampSet boundedTimestampSet = new BoundedTimestampSet(CommonTimeUtil.TimeBucket.MONTH, 3);
    boundedTimestampSet.add(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Act and Assert
    assertEquals(1, boundedTimestampSet.getTimestamps().size());
  }

  /**
   * Method under test: {@link BoundedTimestampSet#getTimestamps()}
   */
  @Test
  void testGetTimestamps8() {
    // Arrange
    BoundedTimestampSet boundedTimestampSet = new BoundedTimestampSet(CommonTimeUtil.TimeBucket.YEAR, 3);
    boundedTimestampSet.add(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Act and Assert
    assertEquals(1, boundedTimestampSet.getTimestamps().size());
  }

  /**
   * Method under test: {@link BoundedTimestampSet#getNumberOfTimestamps()}
   */
  @Test
  void testGetNumberOfTimestamps() {
    // Arrange, Act and Assert
    assertEquals(0L, (new BoundedTimestampSet(CommonTimeUtil.TimeBucket.SECOND, 3)).getNumberOfTimestamps());
  }

  /**
   * Method under test: {@link BoundedTimestampSet#getNumberOfTimestamps()}
   */
  @Test
  void testGetNumberOfTimestamps2() {
    // Arrange
    BoundedTimestampSet boundedTimestampSet = new BoundedTimestampSet(CommonTimeUtil.TimeBucket.SECOND, 3);
    boundedTimestampSet.add(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Act and Assert
    assertEquals(1L, boundedTimestampSet.getNumberOfTimestamps());
  }

  /**
   * Method under test: {@link BoundedTimestampSet#getEarliest()}
   */
  @Test
  void testGetEarliest() {
    // Arrange
    BoundedTimestampSet boundedTimestampSet = new BoundedTimestampSet(CommonTimeUtil.TimeBucket.SECOND, 3);

    // Act and Assert
    assertNull(boundedTimestampSet.getEarliest());
    assertNull(boundedTimestampSet.getLatest());
    RBMBackedTimestampSet rbmBackedTimestampSet = boundedTimestampSet.getRbmBackedTimestampSet();
    assertNull(rbmBackedTimestampSet.getEarliest());
    assertNull(rbmBackedTimestampSet.getLatest());
    assertEquals(rbmBackedTimestampSet, rbmBackedTimestampSet.getShallowClone());
  }

  /**
   * Method under test: {@link BoundedTimestampSet#getEarliest()}
   */
  @Test
  void testGetEarliest2() {
    // Arrange
    BoundedTimestampSet boundedTimestampSet = new BoundedTimestampSet(CommonTimeUtil.TimeBucket.SECOND, 3);
    boundedTimestampSet.add(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Act
    Instant actualEarliest = boundedTimestampSet.getEarliest();

    // Assert
    RBMBackedTimestampSet rbmBackedTimestampSet = boundedTimestampSet.getRbmBackedTimestampSet();
    assertEquals(rbmBackedTimestampSet, rbmBackedTimestampSet.getShallowClone());
    Instant instant = actualEarliest.EPOCH;
    assertSame(instant, actualEarliest);
    assertSame(instant, boundedTimestampSet.getLatest());
    assertSame(instant, rbmBackedTimestampSet.getEarliest());
    assertSame(instant, rbmBackedTimestampSet.getLatest());
  }

  /**
   * Method under test: {@link BoundedTimestampSet#getEarliest()}
   */
  @Test
  void testGetEarliest3() {
    // Arrange
    BoundedTimestampSet boundedTimestampSet = new BoundedTimestampSet(CommonTimeUtil.TimeBucket.MINUTE, 3);
    boundedTimestampSet.add(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Act
    Instant actualEarliest = boundedTimestampSet.getEarliest();

    // Assert
    RBMBackedTimestampSet rbmBackedTimestampSet = boundedTimestampSet.getRbmBackedTimestampSet();
    assertEquals(rbmBackedTimestampSet, rbmBackedTimestampSet.getShallowClone());
    Instant instant = actualEarliest.EPOCH;
    assertSame(instant, actualEarliest);
    assertSame(instant, boundedTimestampSet.getLatest());
    assertSame(instant, rbmBackedTimestampSet.getEarliest());
    assertSame(instant, rbmBackedTimestampSet.getLatest());
  }

  /**
   * Method under test: {@link BoundedTimestampSet#getEarliest()}
   */
  @Test
  void testGetEarliest4() {
    // Arrange
    BoundedTimestampSet boundedTimestampSet = new BoundedTimestampSet(CommonTimeUtil.TimeBucket.HOUR, 3);
    boundedTimestampSet.add(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Act
    Instant actualEarliest = boundedTimestampSet.getEarliest();

    // Assert
    RBMBackedTimestampSet rbmBackedTimestampSet = boundedTimestampSet.getRbmBackedTimestampSet();
    assertEquals(rbmBackedTimestampSet, rbmBackedTimestampSet.getShallowClone());
    Instant instant = actualEarliest.EPOCH;
    assertSame(instant, actualEarliest);
    assertSame(instant, boundedTimestampSet.getLatest());
    assertSame(instant, rbmBackedTimestampSet.getEarliest());
    assertSame(instant, rbmBackedTimestampSet.getLatest());
  }

  /**
   * Method under test: {@link BoundedTimestampSet#getEarliest()}
   */
  @Test
  void testGetEarliest5() {
    // Arrange
    BoundedTimestampSet boundedTimestampSet = new BoundedTimestampSet(CommonTimeUtil.TimeBucket.DAY, 3);
    boundedTimestampSet.add(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Act
    Instant actualEarliest = boundedTimestampSet.getEarliest();

    // Assert
    RBMBackedTimestampSet rbmBackedTimestampSet = boundedTimestampSet.getRbmBackedTimestampSet();
    assertEquals(rbmBackedTimestampSet, rbmBackedTimestampSet.getShallowClone());
    Instant instant = actualEarliest.EPOCH;
    assertSame(instant, actualEarliest);
    assertSame(instant, boundedTimestampSet.getLatest());
    assertSame(instant, rbmBackedTimestampSet.getEarliest());
    assertSame(instant, rbmBackedTimestampSet.getLatest());
  }

  /**
   * Method under test: {@link BoundedTimestampSet#getEarliest()}
   */
  @Test
  void testGetEarliest6() {
    // Arrange
    BoundedTimestampSet boundedTimestampSet = new BoundedTimestampSet(CommonTimeUtil.TimeBucket.WEEK, 3);
    boundedTimestampSet.add(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Act
    Instant actualEarliest = boundedTimestampSet.getEarliest();

    // Assert
    assertEquals(-259200L, actualEarliest.getEpochSecond());
    assertEquals(0, actualEarliest.getNano());
  }

  /**
   * Method under test: {@link BoundedTimestampSet#getEarliest()}
   */
  @Test
  void testGetEarliest7() {
    // Arrange
    BoundedTimestampSet boundedTimestampSet = new BoundedTimestampSet(CommonTimeUtil.TimeBucket.MONTH, 3);
    boundedTimestampSet.add(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Act
    Instant actualEarliest = boundedTimestampSet.getEarliest();

    // Assert
    RBMBackedTimestampSet rbmBackedTimestampSet = boundedTimestampSet.getRbmBackedTimestampSet();
    assertEquals(rbmBackedTimestampSet, rbmBackedTimestampSet.getShallowClone());
    Instant instant = actualEarliest.EPOCH;
    assertSame(instant, actualEarliest);
    assertSame(instant, boundedTimestampSet.getLatest());
    assertSame(instant, rbmBackedTimestampSet.getEarliest());
    assertSame(instant, rbmBackedTimestampSet.getLatest());
  }

  /**
   * Method under test: {@link BoundedTimestampSet#getEarliest()}
   */
  @Test
  void testGetEarliest8() {
    // Arrange
    BoundedTimestampSet boundedTimestampSet = new BoundedTimestampSet(CommonTimeUtil.TimeBucket.YEAR, 3);
    boundedTimestampSet.add(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Act
    Instant actualEarliest = boundedTimestampSet.getEarliest();

    // Assert
    RBMBackedTimestampSet rbmBackedTimestampSet = boundedTimestampSet.getRbmBackedTimestampSet();
    assertEquals(rbmBackedTimestampSet, rbmBackedTimestampSet.getShallowClone());
    Instant instant = actualEarliest.EPOCH;
    assertSame(instant, actualEarliest);
    assertSame(instant, boundedTimestampSet.getLatest());
    assertSame(instant, rbmBackedTimestampSet.getEarliest());
    assertSame(instant, rbmBackedTimestampSet.getLatest());
  }

  /**
   * Method under test: {@link BoundedTimestampSet#getLatest()}
   */
  @Test
  void testGetLatest() {
    // Arrange
    BoundedTimestampSet boundedTimestampSet = new BoundedTimestampSet(CommonTimeUtil.TimeBucket.SECOND, 3);

    // Act
    Instant actualLatest = boundedTimestampSet.getLatest();

    // Assert
    assertNull(boundedTimestampSet.getEarliest());
    assertNull(actualLatest);
    RBMBackedTimestampSet rbmBackedTimestampSet = boundedTimestampSet.getRbmBackedTimestampSet();
    assertNull(rbmBackedTimestampSet.getEarliest());
    assertNull(rbmBackedTimestampSet.getLatest());
    assertEquals(rbmBackedTimestampSet, rbmBackedTimestampSet.getShallowClone());
  }

  /**
   * Method under test: {@link BoundedTimestampSet#getLatest()}
   */
  @Test
  void testGetLatest2() {
    // Arrange
    BoundedTimestampSet boundedTimestampSet = new BoundedTimestampSet(CommonTimeUtil.TimeBucket.SECOND, 3);
    boundedTimestampSet.add(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Act
    Instant actualLatest = boundedTimestampSet.getLatest();

    // Assert
    RBMBackedTimestampSet rbmBackedTimestampSet = boundedTimestampSet.getRbmBackedTimestampSet();
    assertEquals(rbmBackedTimestampSet, rbmBackedTimestampSet.getShallowClone());
    Instant instant = actualLatest.EPOCH;
    assertSame(instant, boundedTimestampSet.getEarliest());
    assertSame(instant, actualLatest);
    assertSame(instant, rbmBackedTimestampSet.getEarliest());
    assertSame(instant, rbmBackedTimestampSet.getLatest());
  }

  /**
   * Method under test: {@link BoundedTimestampSet#getLatest()}
   */
  @Test
  void testGetLatest3() {
    // Arrange
    BoundedTimestampSet boundedTimestampSet = new BoundedTimestampSet(CommonTimeUtil.TimeBucket.MINUTE, 3);
    boundedTimestampSet.add(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Act
    Instant actualLatest = boundedTimestampSet.getLatest();

    // Assert
    RBMBackedTimestampSet rbmBackedTimestampSet = boundedTimestampSet.getRbmBackedTimestampSet();
    assertEquals(rbmBackedTimestampSet, rbmBackedTimestampSet.getShallowClone());
    Instant instant = actualLatest.EPOCH;
    assertSame(instant, boundedTimestampSet.getEarliest());
    assertSame(instant, actualLatest);
    assertSame(instant, rbmBackedTimestampSet.getEarliest());
    assertSame(instant, rbmBackedTimestampSet.getLatest());
  }

  /**
   * Method under test: {@link BoundedTimestampSet#getLatest()}
   */
  @Test
  void testGetLatest4() {
    // Arrange
    BoundedTimestampSet boundedTimestampSet = new BoundedTimestampSet(CommonTimeUtil.TimeBucket.HOUR, 3);
    boundedTimestampSet.add(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Act
    Instant actualLatest = boundedTimestampSet.getLatest();

    // Assert
    RBMBackedTimestampSet rbmBackedTimestampSet = boundedTimestampSet.getRbmBackedTimestampSet();
    assertEquals(rbmBackedTimestampSet, rbmBackedTimestampSet.getShallowClone());
    Instant instant = actualLatest.EPOCH;
    assertSame(instant, boundedTimestampSet.getEarliest());
    assertSame(instant, actualLatest);
    assertSame(instant, rbmBackedTimestampSet.getEarliest());
    assertSame(instant, rbmBackedTimestampSet.getLatest());
  }

  /**
   * Method under test: {@link BoundedTimestampSet#getLatest()}
   */
  @Test
  void testGetLatest5() {
    // Arrange
    BoundedTimestampSet boundedTimestampSet = new BoundedTimestampSet(CommonTimeUtil.TimeBucket.DAY, 3);
    boundedTimestampSet.add(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Act
    Instant actualLatest = boundedTimestampSet.getLatest();

    // Assert
    RBMBackedTimestampSet rbmBackedTimestampSet = boundedTimestampSet.getRbmBackedTimestampSet();
    assertEquals(rbmBackedTimestampSet, rbmBackedTimestampSet.getShallowClone());
    Instant instant = actualLatest.EPOCH;
    assertSame(instant, boundedTimestampSet.getEarliest());
    assertSame(instant, actualLatest);
    assertSame(instant, rbmBackedTimestampSet.getEarliest());
    assertSame(instant, rbmBackedTimestampSet.getLatest());
  }

  /**
   * Method under test: {@link BoundedTimestampSet#getLatest()}
   */
  @Test
  void testGetLatest6() {
    // Arrange
    BoundedTimestampSet boundedTimestampSet = new BoundedTimestampSet(CommonTimeUtil.TimeBucket.WEEK, 3);
    boundedTimestampSet.add(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Act
    Instant actualLatest = boundedTimestampSet.getLatest();

    // Assert
    assertEquals(-259200L, actualLatest.getEpochSecond());
    assertEquals(0, actualLatest.getNano());
  }

  /**
   * Method under test: {@link BoundedTimestampSet#getLatest()}
   */
  @Test
  void testGetLatest7() {
    // Arrange
    BoundedTimestampSet boundedTimestampSet = new BoundedTimestampSet(CommonTimeUtil.TimeBucket.MONTH, 3);
    boundedTimestampSet.add(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Act
    Instant actualLatest = boundedTimestampSet.getLatest();

    // Assert
    RBMBackedTimestampSet rbmBackedTimestampSet = boundedTimestampSet.getRbmBackedTimestampSet();
    assertEquals(rbmBackedTimestampSet, rbmBackedTimestampSet.getShallowClone());
    Instant instant = actualLatest.EPOCH;
    assertSame(instant, boundedTimestampSet.getEarliest());
    assertSame(instant, actualLatest);
    assertSame(instant, rbmBackedTimestampSet.getEarliest());
    assertSame(instant, rbmBackedTimestampSet.getLatest());
  }

  /**
   * Method under test: {@link BoundedTimestampSet#getLatest()}
   */
  @Test
  void testGetLatest8() {
    // Arrange
    BoundedTimestampSet boundedTimestampSet = new BoundedTimestampSet(CommonTimeUtil.TimeBucket.YEAR, 3);
    boundedTimestampSet.add(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Act
    Instant actualLatest = boundedTimestampSet.getLatest();

    // Assert
    RBMBackedTimestampSet rbmBackedTimestampSet = boundedTimestampSet.getRbmBackedTimestampSet();
    assertEquals(rbmBackedTimestampSet, rbmBackedTimestampSet.getShallowClone());
    Instant instant = actualLatest.EPOCH;
    assertSame(instant, boundedTimestampSet.getEarliest());
    assertSame(instant, actualLatest);
    assertSame(instant, rbmBackedTimestampSet.getEarliest());
    assertSame(instant, rbmBackedTimestampSet.getLatest());
  }

  /**
   * Method under test: {@link BoundedTimestampSet#getRbmBackedTimestampSet()}
   */
  @Test
  void testGetRbmBackedTimestampSet() {
    // Arrange and Act
    RBMBackedTimestampSet actualRbmBackedTimestampSet = (new BoundedTimestampSet(CommonTimeUtil.TimeBucket.SECOND, 3))
        .getRbmBackedTimestampSet();

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
   * {@link BoundedTimestampSet#setRbmBackedTimestampSet(RBMBackedTimestampSet)}
   */
  @Test
  void testSetRbmBackedTimestampSet() {
    // Arrange
    BoundedTimestampSet boundedTimestampSet = new BoundedTimestampSet(CommonTimeUtil.TimeBucket.SECOND, 3);
    RBMBackedTimestampSet rbmBackedTimestampSet = new RBMBackedTimestampSet(CommonTimeUtil.TimeBucket.SECOND);

    // Act
    boundedTimestampSet.setRbmBackedTimestampSet(rbmBackedTimestampSet);

    // Assert
    assertSame(rbmBackedTimestampSet, boundedTimestampSet.getRbmBackedTimestampSet());
  }

  /**
   * Method under test: {@link BoundedTimestampSet#getReservoirLongsUnion()}
   */
  @Test
  void testGetReservoirLongsUnion() {
    // Arrange, Act and Assert
    assertThrows(RuntimeException.class,
        () -> (new BoundedTimestampSet(CommonTimeUtil.TimeBucket.SECOND, 3)).getReservoirLongsUnion());
  }

  /**
   * Method under test:
   * {@link BoundedTimestampSet#setReservoirLongsUnion(ReservoirLongsUnion)}
   */
  @Test
  void testSetReservoirLongsUnion() {
    // Arrange
    BoundedTimestampSet boundedTimestampSet = new BoundedTimestampSet(CommonTimeUtil.TimeBucket.SECOND, 3);
    ReservoirLongsUnion reservoirLongsUnion = ReservoirLongsUnion.newInstance(3);

    // Act
    boundedTimestampSet.setReservoirLongsUnion(reservoirLongsUnion);

    // Assert
    assertEquals(BoundedTimestampSet.State.SAMPLE, boundedTimestampSet.getState());
    assertSame(reservoirLongsUnion, boundedTimestampSet.getReservoirLongsUnion());
  }

  /**
   * Method under test: {@link BoundedTimestampSet#switchToSampleState()}
   */
  @Test
  void testSwitchToSampleState() {
    // Arrange
    BoundedTimestampSet boundedTimestampSet = new BoundedTimestampSet(CommonTimeUtil.TimeBucket.SECOND, 3);

    // Act
    boundedTimestampSet.switchToSampleState();

    // Assert
    ReservoirLongsUnion reservoirLongsUnion = boundedTimestampSet.getReservoirLongsUnion();
    assertNull(reservoirLongsUnion.getResult());
    assertEquals(3, reservoirLongsUnion.getMaxK());
    assertEquals(BoundedTimestampSet.State.SAMPLE, boundedTimestampSet.getState());
  }

  /**
   * Method under test: {@link BoundedTimestampSet#switchToSampleState()}
   */
  @Test
  void testSwitchToSampleState2() {
    // Arrange
    BoundedTimestampSet boundedTimestampSet = new BoundedTimestampSet(CommonTimeUtil.TimeBucket.SECOND, 3);
    boundedTimestampSet.add(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Act
    boundedTimestampSet.switchToSampleState();

    // Assert
    ReservoirLongsUnion reservoirLongsUnion = boundedTimestampSet.getReservoirLongsUnion();
    ReservoirLongsSketch result = reservoirLongsUnion.getResult();
    assertEquals(1, result.getNumSamples());
    assertEquals(1L, result.getN());
    assertEquals(3, result.getK());
    assertEquals(3, reservoirLongsUnion.getMaxK());
    assertEquals(BoundedTimestampSet.State.SAMPLE, boundedTimestampSet.getState());
    assertArrayEquals(new long[]{0L}, result.getSamples());
  }

  /**
   * Method under test: {@link BoundedTimestampSet#switchToSampleState()}
   */
  @Test
  void testSwitchToSampleState3() {
    // Arrange
    BoundedTimestampSet boundedTimestampSet = new BoundedTimestampSet(CommonTimeUtil.TimeBucket.MINUTE, 3);
    boundedTimestampSet.add(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Act
    boundedTimestampSet.switchToSampleState();

    // Assert
    ReservoirLongsUnion reservoirLongsUnion = boundedTimestampSet.getReservoirLongsUnion();
    ReservoirLongsSketch result = reservoirLongsUnion.getResult();
    assertEquals(1, result.getNumSamples());
    assertEquals(1L, result.getN());
    assertEquals(3, result.getK());
    assertEquals(3, reservoirLongsUnion.getMaxK());
    assertEquals(BoundedTimestampSet.State.SAMPLE, boundedTimestampSet.getState());
    assertArrayEquals(new long[]{0L}, result.getSamples());
  }

  /**
   * Method under test: {@link BoundedTimestampSet#switchToSampleState()}
   */
  @Test
  void testSwitchToSampleState4() {
    // Arrange
    BoundedTimestampSet boundedTimestampSet = new BoundedTimestampSet(CommonTimeUtil.TimeBucket.HOUR, 3);
    boundedTimestampSet.add(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Act
    boundedTimestampSet.switchToSampleState();

    // Assert
    ReservoirLongsUnion reservoirLongsUnion = boundedTimestampSet.getReservoirLongsUnion();
    ReservoirLongsSketch result = reservoirLongsUnion.getResult();
    assertEquals(1, result.getNumSamples());
    assertEquals(1L, result.getN());
    assertEquals(3, result.getK());
    assertEquals(3, reservoirLongsUnion.getMaxK());
    assertEquals(BoundedTimestampSet.State.SAMPLE, boundedTimestampSet.getState());
    assertArrayEquals(new long[]{0L}, result.getSamples());
  }

  /**
   * Method under test: {@link BoundedTimestampSet#switchToSampleState()}
   */
  @Test
  void testSwitchToSampleState5() {
    // Arrange
    BoundedTimestampSet boundedTimestampSet = new BoundedTimestampSet(CommonTimeUtil.TimeBucket.DAY, 3);
    boundedTimestampSet.add(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Act
    boundedTimestampSet.switchToSampleState();

    // Assert
    ReservoirLongsUnion reservoirLongsUnion = boundedTimestampSet.getReservoirLongsUnion();
    ReservoirLongsSketch result = reservoirLongsUnion.getResult();
    assertEquals(1, result.getNumSamples());
    assertEquals(1L, result.getN());
    assertEquals(3, result.getK());
    assertEquals(3, reservoirLongsUnion.getMaxK());
    assertEquals(BoundedTimestampSet.State.SAMPLE, boundedTimestampSet.getState());
    assertArrayEquals(new long[]{0L}, result.getSamples());
  }

  /**
   * Method under test: {@link BoundedTimestampSet#switchToSampleState()}
   */
  @Test
  void testSwitchToSampleState6() {
    // Arrange
    BoundedTimestampSet boundedTimestampSet = new BoundedTimestampSet(CommonTimeUtil.TimeBucket.WEEK, 3);
    boundedTimestampSet.add(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Act
    boundedTimestampSet.switchToSampleState();

    // Assert
    ReservoirLongsUnion reservoirLongsUnion = boundedTimestampSet.getReservoirLongsUnion();
    ReservoirLongsSketch result = reservoirLongsUnion.getResult();
    assertEquals(1, result.getNumSamples());
    assertEquals(1L, result.getN());
    assertEquals(3, result.getK());
    assertEquals(3, reservoirLongsUnion.getMaxK());
    assertEquals(BoundedTimestampSet.State.SAMPLE, boundedTimestampSet.getState());
    assertArrayEquals(new long[]{-259200000L}, result.getSamples());
  }

  /**
   * Method under test: {@link BoundedTimestampSet#switchToSampleState()}
   */
  @Test
  void testSwitchToSampleState7() {
    // Arrange
    BoundedTimestampSet boundedTimestampSet = new BoundedTimestampSet(CommonTimeUtil.TimeBucket.MONTH, 3);
    boundedTimestampSet.add(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Act
    boundedTimestampSet.switchToSampleState();

    // Assert
    ReservoirLongsUnion reservoirLongsUnion = boundedTimestampSet.getReservoirLongsUnion();
    ReservoirLongsSketch result = reservoirLongsUnion.getResult();
    assertEquals(1, result.getNumSamples());
    assertEquals(1L, result.getN());
    assertEquals(3, result.getK());
    assertEquals(3, reservoirLongsUnion.getMaxK());
    assertEquals(BoundedTimestampSet.State.SAMPLE, boundedTimestampSet.getState());
    assertArrayEquals(new long[]{0L}, result.getSamples());
  }

  /**
   * Method under test: {@link BoundedTimestampSet#switchToSampleState()}
   */
  @Test
  void testSwitchToSampleState8() {
    // Arrange
    BoundedTimestampSet boundedTimestampSet = new BoundedTimestampSet(CommonTimeUtil.TimeBucket.YEAR, 3);
    boundedTimestampSet.add(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Act
    boundedTimestampSet.switchToSampleState();

    // Assert
    ReservoirLongsUnion reservoirLongsUnion = boundedTimestampSet.getReservoirLongsUnion();
    ReservoirLongsSketch result = reservoirLongsUnion.getResult();
    assertEquals(1, result.getNumSamples());
    assertEquals(1L, result.getN());
    assertEquals(3, result.getK());
    assertEquals(3, reservoirLongsUnion.getMaxK());
    assertEquals(BoundedTimestampSet.State.SAMPLE, boundedTimestampSet.getState());
    assertArrayEquals(new long[]{0L}, result.getSamples());
  }

  /**
   * Method under test: {@link BoundedTimestampSet#switchToSampleState()}
   */
  @Test
  void testSwitchToSampleState9() {
    // Arrange
    BoundedTimestampSet boundedTimestampSet = new BoundedTimestampSet(CommonTimeUtil.TimeBucket.SECOND, 3);
    boundedTimestampSet.add(LocalDate.now().atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
    boundedTimestampSet.add(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Act
    boundedTimestampSet.switchToSampleState();

    // Assert
    ReservoirLongsUnion reservoirLongsUnion = boundedTimestampSet.getReservoirLongsUnion();
    assertEquals(3, reservoirLongsUnion.getResult().getK());
    assertEquals(3, reservoirLongsUnion.getMaxK());
    assertEquals(BoundedTimestampSet.State.SAMPLE, boundedTimestampSet.getState());
  }

  /**
   * Method under test: {@link BoundedTimestampSet#switchToSampleState()}
   */
  @Test
  void testSwitchToSampleState10() {
    // Arrange
    BoundedTimestampSet boundedTimestampSet = new BoundedTimestampSet(CommonTimeUtil.TimeBucket.DAY, 3);
    boundedTimestampSet.add(LocalDate.now().atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
    boundedTimestampSet.add(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Act
    boundedTimestampSet.switchToSampleState();

    // Assert
    ReservoirLongsUnion reservoirLongsUnion = boundedTimestampSet.getReservoirLongsUnion();
    assertEquals(3, reservoirLongsUnion.getResult().getK());
    assertEquals(3, reservoirLongsUnion.getMaxK());
    assertEquals(BoundedTimestampSet.State.SAMPLE, boundedTimestampSet.getState());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link BoundedTimestampSet#equals(Object)}
   *   <li>{@link BoundedTimestampSet#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    BoundedTimestampSet boundedTimestampSet = new BoundedTimestampSet(CommonTimeUtil.TimeBucket.SECOND, 3);
    BoundedTimestampSet boundedTimestampSet2 = new BoundedTimestampSet(CommonTimeUtil.TimeBucket.SECOND, 3);

    // Act and Assert
    assertEquals(boundedTimestampSet, boundedTimestampSet2);
    int expectedHashCodeResult = boundedTimestampSet.hashCode();
    assertEquals(expectedHashCodeResult, boundedTimestampSet2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link BoundedTimestampSet#equals(Object)}
   *   <li>{@link BoundedTimestampSet#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    BoundedTimestampSet boundedTimestampSet = new BoundedTimestampSet(CommonTimeUtil.TimeBucket.SECOND, 3);

    // Act and Assert
    assertEquals(boundedTimestampSet, boundedTimestampSet);
    int expectedHashCodeResult = boundedTimestampSet.hashCode();
    assertEquals(expectedHashCodeResult, boundedTimestampSet.hashCode());
  }

  /**
   * Method under test: {@link BoundedTimestampSet#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    BoundedTimestampSet boundedTimestampSet = new BoundedTimestampSet(CommonTimeUtil.TimeBucket.MINUTE, 3);

    // Act and Assert
    assertNotEquals(boundedTimestampSet, new BoundedTimestampSet(CommonTimeUtil.TimeBucket.SECOND, 3));
  }

  /**
   * Method under test: {@link BoundedTimestampSet#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new BoundedTimestampSet(CommonTimeUtil.TimeBucket.SECOND, 3), null);
  }

  /**
   * Method under test: {@link BoundedTimestampSet#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new BoundedTimestampSet(CommonTimeUtil.TimeBucket.SECOND, 3),
        "Different type to BoundedTimestampSet");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link BoundedTimestampSet#getMaxSize()}
   *   <li>{@link BoundedTimestampSet#getState()}
   *   <li>{@link BoundedTimestampSet#getTimeBucket()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange
    BoundedTimestampSet boundedTimestampSet = new BoundedTimestampSet(CommonTimeUtil.TimeBucket.SECOND, 3);

    // Act
    int actualMaxSize = boundedTimestampSet.getMaxSize();
    BoundedTimestampSet.State actualState = boundedTimestampSet.getState();

    // Assert
    assertEquals(3, actualMaxSize);
    assertEquals(BoundedTimestampSet.State.NOT_FULL, actualState);
    assertEquals(CommonTimeUtil.TimeBucket.SECOND, boundedTimestampSet.getTimeBucket());
  }

  /**
   * Method under test:
   * {@link BoundedTimestampSet#BoundedTimestampSet(CommonTimeUtil.TimeBucket, int)}
   */
  @Test
  void testNewBoundedTimestampSet() {
    // Arrange and Act
    BoundedTimestampSet actualBoundedTimestampSet = new BoundedTimestampSet(CommonTimeUtil.TimeBucket.SECOND, 3);

    // Assert
    assertNull(actualBoundedTimestampSet.getEarliest());
    assertNull(actualBoundedTimestampSet.getLatest());
    RBMBackedTimestampSet rbmBackedTimestampSet = actualBoundedTimestampSet.getRbmBackedTimestampSet();
    assertNull(rbmBackedTimestampSet.getEarliest());
    assertNull(rbmBackedTimestampSet.getLatest());
    RoaringBitmap rbm = rbmBackedTimestampSet.getRbm();
    assertEquals(0, rbm.getCardinality());
    assertEquals(0L, actualBoundedTimestampSet.getNumberOfTimestamps());
    assertEquals(0L, rbmBackedTimestampSet.getNumberOfTimestamps());
    assertEquals(3, actualBoundedTimestampSet.getMaxSize());
    assertEquals(8, rbm.getSizeInBytes());
    assertEquals(BoundedTimestampSet.State.NOT_FULL, actualBoundedTimestampSet.getState());
    assertEquals(CommonTimeUtil.TimeBucket.SECOND, actualBoundedTimestampSet.getTimeBucket());
    assertEquals(CommonTimeUtil.TimeBucket.SECOND, rbmBackedTimestampSet.getTimeBucket());
    assertFalse(rbm.iterator().hasNext());
    assertFalse(rbm.hasRunCompression());
    assertTrue(actualBoundedTimestampSet.getTimestamps().isEmpty());
    assertTrue(rbmBackedTimestampSet.getTimestamps().isEmpty());
    assertTrue(rbm.isEmpty());
    assertEquals(rbmBackedTimestampSet, rbmBackedTimestampSet.getShallowClone());
  }

  /**
   * Method under test:
   * {@link BoundedTimestampSet#BoundedTimestampSet(CommonTimeUtil.TimeBucket, int)}
   */
  @Test
  void testNewBoundedTimestampSet2() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> new BoundedTimestampSet(CommonTimeUtil.TimeBucket.SECOND, 0));

  }
}
