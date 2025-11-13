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
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.UnsupportedEncodingException;
import java.util.Set;
import org.apache.hadoop.io.Text;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class AccumuloTabletDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link AccumuloTablet#AccumuloTablet(int, int, String, String)}
   *   <li>{@link AccumuloTablet#getFiles()}
   *   <li>{@link AccumuloTablet#index()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void AccumuloTablet.<init>(int, int, String, String)", "Set AccumuloTablet.getFiles()",
      "int AccumuloTablet.index()"})
  void testGettersAndSetters() {
    // Arrange and Act
    AccumuloTablet actualAccumuloTablet = new AccumuloTablet(1, 1, "Start", "End");
    Set<String> actualFiles = actualAccumuloTablet.getFiles();

    // Assert
    assertEquals(1, actualAccumuloTablet.index());
    assertTrue(actualFiles.isEmpty());
  }

  /**
   * Test {@link AccumuloTablet#addRFile(String)}.
   * <p>
   * Method under test: {@link AccumuloTablet#addRFile(String)}
   */
  @Test
  @DisplayName("Test addRFile(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void AccumuloTablet.addRFile(String)"})
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
   * Test {@link AccumuloTablet#getStartRow()}.
   * <p>
   * Method under test: {@link AccumuloTablet#getStartRow()}
   */
  @Test
  @DisplayName("Test getStartRow()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Text AccumuloTablet.getStartRow()"})
  void testGetStartRow() throws UnsupportedEncodingException {
    // Arrange and Act
    Text actualStartRow = (new AccumuloTablet(1, 1, "Start", "End")).getStartRow();

    // Assert
    assertEquals(5, actualStartRow.getLength());
    byte[] expectedBytes = "Start".getBytes("UTF-8");
    assertArrayEquals(expectedBytes, actualStartRow.getBytes());
  }

  /**
   * Test {@link AccumuloTablet#getEndRow()}.
   * <p>
   * Method under test: {@link AccumuloTablet#getEndRow()}
   */
  @Test
  @DisplayName("Test getEndRow()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Text AccumuloTablet.getEndRow()"})
  void testGetEndRow() throws UnsupportedEncodingException {
    // Arrange and Act
    Text actualEndRow = (new AccumuloTablet(1, 1, "Start", "End")).getEndRow();

    // Assert
    assertEquals(3, actualEndRow.getLength());
    byte[] expectedBytes = "End".getBytes("UTF-8");
    assertArrayEquals(expectedBytes, actualEndRow.getBytes());
  }

  /**
   * Test {@link AccumuloTablet#equals(Object)}, and {@link AccumuloTablet#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link AccumuloTablet#equals(Object)}
   *   <li>{@link AccumuloTablet#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean AccumuloTablet.equals(Object)", "int AccumuloTablet.hashCode()"})
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
   * Test {@link AccumuloTablet#equals(Object)}, and {@link AccumuloTablet#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link AccumuloTablet#equals(Object)}
   *   <li>{@link AccumuloTablet#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean AccumuloTablet.equals(Object)", "int AccumuloTablet.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    AccumuloTablet accumuloTablet = new AccumuloTablet(1, 1, "Start", "End");

    // Act and Assert
    assertEquals(accumuloTablet, accumuloTablet);
    int expectedHashCodeResult = accumuloTablet.hashCode();
    assertEquals(expectedHashCodeResult, accumuloTablet.hashCode());
  }

  /**
   * Test {@link AccumuloTablet#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AccumuloTablet#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean AccumuloTablet.equals(Object)", "int AccumuloTablet.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    AccumuloTablet accumuloTablet = new AccumuloTablet(2, 1, "Start", "End");

    // Act and Assert
    assertNotEquals(accumuloTablet, new AccumuloTablet(1, 1, "Start", "End"));
  }

  /**
   * Test {@link AccumuloTablet#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AccumuloTablet#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean AccumuloTablet.equals(Object)", "int AccumuloTablet.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new AccumuloTablet(1, 1, "Start", "End"), null);
  }

  /**
   * Test {@link AccumuloTablet#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AccumuloTablet#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean AccumuloTablet.equals(Object)", "int AccumuloTablet.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new AccumuloTablet(1, 1, "Start", "End"), "Different type to AccumuloTablet");
  }
}
