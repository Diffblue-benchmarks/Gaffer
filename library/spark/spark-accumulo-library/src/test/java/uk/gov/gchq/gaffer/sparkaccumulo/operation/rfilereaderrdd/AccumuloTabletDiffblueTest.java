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

package uk.gov.gchq.gaffer.sparkaccumulo.operation.rfilereaderrdd;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.io.UnsupportedEncodingException;
import java.util.Set;
import org.apache.hadoop.io.Text;
import org.junit.jupiter.api.Test;

class AccumuloTabletDiffblueTest {
  /**
   * Method under test: {@link AccumuloTablet#addRFile(String)}
   */
  @Test
  void testAddRFile() {
    // Arrange
    AccumuloTablet accumuloTablet = new AccumuloTablet(1, 1, "Start", "End");

    // Act
    accumuloTablet.addRFile("R File");

    // Assert
    Set<String> files = accumuloTablet.getFiles();
    assertEquals(1, files.size());
    assertTrue(files.contains("R File"));
  }

  /**
   * Method under test: {@link AccumuloTablet#getStartRow()}
   */
  @Test
  void testGetStartRow() throws UnsupportedEncodingException {
    // Arrange and Act
    Text actualStartRow = (new AccumuloTablet(1, 1, "Start", "End")).getStartRow();

    // Assert
    assertEquals(5, actualStartRow.getLength());
    byte[] expectedBytes = "Start".getBytes("UTF-8");
    assertArrayEquals(expectedBytes, actualStartRow.getBytes());
  }

  /**
   * Method under test: {@link AccumuloTablet#getEndRow()}
   */
  @Test
  void testGetEndRow() throws UnsupportedEncodingException {
    // Arrange and Act
    Text actualEndRow = (new AccumuloTablet(1, 1, "Start", "End")).getEndRow();

    // Assert
    assertEquals(3, actualEndRow.getLength());
    byte[] expectedBytes = "End".getBytes("UTF-8");
    assertArrayEquals(expectedBytes, actualEndRow.getBytes());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link AccumuloTablet#equals(Object)}
   *   <li>{@link AccumuloTablet#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    AccumuloTablet accumuloTablet = new AccumuloTablet(1, 1, "Start", "End");
    AccumuloTablet accumuloTablet2 = new AccumuloTablet(1, 1, "Start", "End");

    // Act and Assert
    assertEquals(accumuloTablet, accumuloTablet2);
    int expectedHashCodeResult = accumuloTablet.hashCode();
    assertEquals(expectedHashCodeResult, accumuloTablet2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link AccumuloTablet#equals(Object)}
   *   <li>{@link AccumuloTablet#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    AccumuloTablet accumuloTablet = new AccumuloTablet(1, 1, "Start", "End");

    // Act and Assert
    assertEquals(accumuloTablet, accumuloTablet);
    int expectedHashCodeResult = accumuloTablet.hashCode();
    assertEquals(expectedHashCodeResult, accumuloTablet.hashCode());
  }

  /**
   * Method under test: {@link AccumuloTablet#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    AccumuloTablet accumuloTablet = new AccumuloTablet(2, 1, "Start", "End");

    // Act and Assert
    assertNotEquals(accumuloTablet, new AccumuloTablet(1, 1, "Start", "End"));
  }

  /**
   * Method under test: {@link AccumuloTablet#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new AccumuloTablet(1, 1, "Start", "End"), null);
  }

  /**
   * Method under test: {@link AccumuloTablet#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new AccumuloTablet(1, 1, "Start", "End"), "Different type to AccumuloTablet");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link AccumuloTablet#AccumuloTablet(int, int, String, String)}
   *   <li>{@link AccumuloTablet#getFiles()}
   *   <li>{@link AccumuloTablet#index()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    AccumuloTablet actualAccumuloTablet = new AccumuloTablet(1, 1, "Start", "End");
    Set<String> actualFiles = actualAccumuloTablet.getFiles();

    // Assert
    assertEquals(1, actualAccumuloTablet.index());
    assertTrue(actualFiles.isEmpty());
  }
}
