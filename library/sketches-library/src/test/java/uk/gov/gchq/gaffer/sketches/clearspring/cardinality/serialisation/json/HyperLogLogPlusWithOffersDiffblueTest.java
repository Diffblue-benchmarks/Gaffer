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

package uk.gov.gchq.gaffer.sketches.clearspring.cardinality.serialisation.json;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.clearspring.analytics.stream.cardinality.HyperLogLogPlus;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

class HyperLogLogPlusWithOffersDiffblueTest {
  /**
   * Method under test: {@link HyperLogLogPlusWithOffers#getHyperLogLogPlus()}
   */
  @Test
  void testGetHyperLogLogPlus() throws IOException {
    // Arrange and Act
    HyperLogLogPlus actualHyperLogLogPlus = (new HyperLogLogPlusWithOffers()).getHyperLogLogPlus();

    // Assert
    assertEquals(24, actualHyperLogLogPlus.sizeof());
    assertArrayEquals(new byte[]{-1, -1, -1, -2, 5, 5, 1, 0}, actualHyperLogLogPlus.getBytes());
  }

  /**
   * Method under test: {@link HyperLogLogPlusWithOffers#getHyperLogLogPlus()}
   */
  @Test
  void testGetHyperLogLogPlus2() throws IOException {
    // Arrange
    HyperLogLogPlusWithOffers hyperLogLogPlusWithOffers = new HyperLogLogPlusWithOffers();
    hyperLogLogPlusWithOffers.setSp(0);

    // Act
    HyperLogLogPlus actualHyperLogLogPlus = hyperLogLogPlusWithOffers.getHyperLogLogPlus();

    // Assert
    assertEquals(24, actualHyperLogLogPlus.sizeof());
    assertArrayEquals(
        new byte[]{-1, -1, -1, -2, 5, 0, 0, 24, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        actualHyperLogLogPlus.getBytes());
  }

  /**
   * Method under test: {@link HyperLogLogPlusWithOffers#getHyperLogLogPlus()}
   */
  @Test
  void testGetHyperLogLogPlus3() throws IOException {
    // Arrange
    HyperLogLogPlusWithOffers hyperLogLogPlusWithOffers = new HyperLogLogPlusWithOffers();
    hyperLogLogPlusWithOffers.setHyperLogLogPlusSketchBytes(new byte[]{-1, 'X', 'A', 'X', 'A', 0, 'A', 0});

    // Act
    HyperLogLogPlus actualHyperLogLogPlus = hyperLogLogPlusWithOffers.getHyperLogLogPlus();

    // Assert
    assertEquals(1431655768, actualHyperLogLogPlus.sizeof());
    assertArrayEquals(new byte[]{-1, -1, -1, -2, 'A', 0, 1, 0}, actualHyperLogLogPlus.getBytes());
  }

  /**
   * Method under test: {@link HyperLogLogPlusWithOffers#getHyperLogLogPlus()}
   */
  @Test
  void testGetHyperLogLogPlus4() throws IOException {
    // Arrange
    HyperLogLogPlusWithOffers hyperLogLogPlusWithOffers = new HyperLogLogPlusWithOffers();
    hyperLogLogPlusWithOffers.setHyperLogLogPlusSketchBytes(new byte[]{-1, 'X', 'A', 'X', 'A', 0, 0, 0});

    // Act
    HyperLogLogPlus actualHyperLogLogPlus = hyperLogLogPlusWithOffers.getHyperLogLogPlus();

    // Assert
    assertEquals(0, actualHyperLogLogPlus.sizeof());
    assertArrayEquals(new byte[]{-1, -1, -1, -2, 'A', 0, 0, 0}, actualHyperLogLogPlus.getBytes());
  }

  /**
   * Method under test: {@link HyperLogLogPlusWithOffers#getHyperLogLogPlus()}
   */
  @Test
  void testGetHyperLogLogPlus5() throws IOException {
    // Arrange
    ArrayList<Object> offers = new ArrayList<>();
    offers.add("42");

    HyperLogLogPlusWithOffers hyperLogLogPlusWithOffers = new HyperLogLogPlusWithOffers();
    hyperLogLogPlusWithOffers.setOffers(offers);

    // Act
    HyperLogLogPlus actualHyperLogLogPlus = hyperLogLogPlusWithOffers.getHyperLogLogPlus();

    // Assert
    assertEquals(24, actualHyperLogLogPlus.sizeof());
    assertArrayEquals(new byte[]{-1, -1, -1, -2, 5, 5, 1, 1, -5, 23}, actualHyperLogLogPlus.getBytes());
  }

  /**
   * Method under test: {@link HyperLogLogPlusWithOffers#getHyperLogLogPlus()}
   */
  @Test
  void testGetHyperLogLogPlus6() throws IOException {
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
    assertArrayEquals(new byte[]{-1, -1, -1, -2, 5, 5, 1, 1, -5, 23}, actualHyperLogLogPlus.getBytes());
  }

  /**
   * Method under test: {@link HyperLogLogPlusWithOffers#getHyperLogLogPlus()}
   */
  @Test
  void testGetHyperLogLogPlus7() throws IOException {
    // Arrange
    ArrayList<Object> offers = new ArrayList<>();
    offers.add(2);

    HyperLogLogPlusWithOffers hyperLogLogPlusWithOffers = new HyperLogLogPlusWithOffers();
    hyperLogLogPlusWithOffers.setOffers(offers);

    // Act
    HyperLogLogPlus actualHyperLogLogPlus = hyperLogLogPlusWithOffers.getHyperLogLogPlus();

    // Assert
    assertEquals(24, actualHyperLogLogPlus.sizeof());
    assertArrayEquals(new byte[]{-1, -1, -1, -2, 5, 5, 1, 1, -5, 11}, actualHyperLogLogPlus.getBytes());
  }

  /**
   * Method under test: {@link HyperLogLogPlusWithOffers#getHyperLogLogPlus()}
   */
  @Test
  void testGetHyperLogLogPlus8() throws IOException {
    // Arrange
    ArrayList<Object> offers = new ArrayList<>();
    offers.add(null);

    HyperLogLogPlusWithOffers hyperLogLogPlusWithOffers = new HyperLogLogPlusWithOffers();
    hyperLogLogPlusWithOffers.setOffers(offers);

    // Act
    HyperLogLogPlus actualHyperLogLogPlus = hyperLogLogPlusWithOffers.getHyperLogLogPlus();

    // Assert
    assertEquals(24, actualHyperLogLogPlus.sizeof());
    assertArrayEquals(new byte[]{-1, -1, -1, -2, 5, 5, 1, 1, 7}, actualHyperLogLogPlus.getBytes());
  }

  /**
   * Method under test: {@link HyperLogLogPlusWithOffers#getHyperLogLogPlus()}
   */
  @Test
  void testGetHyperLogLogPlus9() throws IOException {
    // Arrange
    ArrayList<Object> offers = new ArrayList<>();
    offers.add("foo");

    HyperLogLogPlusWithOffers hyperLogLogPlusWithOffers = new HyperLogLogPlusWithOffers();
    hyperLogLogPlusWithOffers.setOffers(offers);

    // Act
    HyperLogLogPlus actualHyperLogLogPlus = hyperLogLogPlusWithOffers.getHyperLogLogPlus();

    // Assert
    assertEquals(24, actualHyperLogLogPlus.sizeof());
    assertArrayEquals(new byte[]{-1, -1, -1, -2, 5, 5, 1, 1, -3, 18}, actualHyperLogLogPlus.getBytes());
  }

  /**
   * Method under test: {@link HyperLogLogPlusWithOffers#getHyperLogLogPlus()}
   */
  @Test
  void testGetHyperLogLogPlus10() throws IOException {
    // Arrange
    ArrayList<Object> offers = new ArrayList<>();
    offers.add(Integer.MIN_VALUE);

    HyperLogLogPlusWithOffers hyperLogLogPlusWithOffers = new HyperLogLogPlusWithOffers();
    hyperLogLogPlusWithOffers.setOffers(offers);

    // Act
    HyperLogLogPlus actualHyperLogLogPlus = hyperLogLogPlusWithOffers.getHyperLogLogPlus();

    // Assert
    assertEquals(24, actualHyperLogLogPlus.sizeof());
    assertArrayEquals(new byte[]{-1, -1, -1, -2, 5, 5, 1, 1, -3, 28}, actualHyperLogLogPlus.getBytes());
  }

  /**
   * Method under test: {@link HyperLogLogPlusWithOffers#getHyperLogLogPlus()}
   */
  @Test
  void testGetHyperLogLogPlus11() throws IOException {
    // Arrange
    ArrayList<Object> offers = new ArrayList<>();
    offers.add("");

    HyperLogLogPlusWithOffers hyperLogLogPlusWithOffers = new HyperLogLogPlusWithOffers();
    hyperLogLogPlusWithOffers.setOffers(offers);

    // Act
    HyperLogLogPlus actualHyperLogLogPlus = hyperLogLogPlusWithOffers.getHyperLogLogPlus();

    // Assert
    assertEquals(24, actualHyperLogLogPlus.sizeof());
    assertArrayEquals(new byte[]{-1, -1, -1, -2, 5, 5, 1, 1, -5, 19}, actualHyperLogLogPlus.getBytes());
  }

  /**
   * Methods under test:
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
  void testGettersAndSetters() throws UnsupportedEncodingException {
    // Arrange and Act
    HyperLogLogPlusWithOffers actualHyperLogLogPlusWithOffers = new HyperLogLogPlusWithOffers();
    byte[] hyperLogLogPlusSketchBytes = "AXAXAXAX".getBytes("UTF-8");
    actualHyperLogLogPlusWithOffers.setHyperLogLogPlusSketchBytes(hyperLogLogPlusSketchBytes);
    ArrayList<Object> offers = new ArrayList<>();
    actualHyperLogLogPlusWithOffers.setOffers(offers);
    actualHyperLogLogPlusWithOffers.setP(3);
    actualHyperLogLogPlusWithOffers.setSp(3);
    byte[] actualHyperLogLogPlusSketchBytes = actualHyperLogLogPlusWithOffers.getHyperLogLogPlusSketchBytes();
    List<?> actualOffers = actualHyperLogLogPlusWithOffers.getOffers();
    int actualP = actualHyperLogLogPlusWithOffers.getP();

    // Assert that nothing has changed
    assertEquals(3, actualP);
    assertEquals(3, actualHyperLogLogPlusWithOffers.getSp());
    assertTrue(actualOffers.isEmpty());
    assertSame(offers, actualOffers);
    assertSame(hyperLogLogPlusSketchBytes, actualHyperLogLogPlusSketchBytes);
  }
}
