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

package uk.gov.gchq.gaffer.data.element.id;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.data.element.id.ElementId.Matches;

class ElementIdDiffblueTest {
  /**
   * Test Matches {@link Matches#isDestination()}.
   * <ul>
   *   <li>Given {@code BOTH}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Matches#isDestination()}
   */
  @Test
  @DisplayName("Test Matches isDestination(); given 'BOTH'; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Matches.isDestination()"})
  void testMatchesIsDestination_givenBoth_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(Matches.BOTH.isDestination());
  }

  /**
   * Test Matches {@link Matches#isDestination()}.
   * <ul>
   *   <li>Given {@link Matches#DESTINATION}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Matches#isDestination()}
   */
  @Test
  @DisplayName("Test Matches isDestination(); given DESTINATION; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Matches.isDestination()"})
  void testMatchesIsDestination_givenDestination_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(Matches.DESTINATION.isDestination());
  }

  /**
   * Test Matches {@link Matches#isDestination()}.
   * <ul>
   *   <li>Given {@code VERTEX}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Matches#isDestination()}
   */
  @Test
  @DisplayName("Test Matches isDestination(); given 'VERTEX'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Matches.isDestination()"})
  void testMatchesIsDestination_givenVertex_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(Matches.VERTEX.isDestination());
  }

  /**
   * Test Matches {@link Matches#isIdentifier()}.
   * <ul>
   *   <li>Given {@code BOTH}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Matches#isIdentifier()}
   */
  @Test
  @DisplayName("Test Matches isIdentifier(); given 'BOTH'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Matches.isIdentifier()"})
  void testMatchesIsIdentifier_givenBoth_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(Matches.BOTH.isIdentifier());
  }

  /**
   * Test Matches {@link Matches#isIdentifier()}.
   * <ul>
   *   <li>Given {@link Matches#VERTEX}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Matches#isIdentifier()}
   */
  @Test
  @DisplayName("Test Matches isIdentifier(); given VERTEX; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Matches.isIdentifier()"})
  void testMatchesIsIdentifier_givenVertex_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(Matches.VERTEX.isIdentifier());
  }

  /**
   * Test Matches {@link Matches#isMatch()}.
   * <ul>
   *   <li>Given {@code BOTH}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Matches#isMatch()}
   */
  @Test
  @DisplayName("Test Matches isMatch(); given 'BOTH'; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Matches.isMatch()"})
  void testMatchesIsMatch_givenBoth_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(Matches.BOTH.isMatch());
  }

  /**
   * Test Matches {@link Matches#isMatch()}.
   * <ul>
   *   <li>Given {@link Matches#NONE}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Matches#isMatch()}
   */
  @Test
  @DisplayName("Test Matches isMatch(); given NONE; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Matches.isMatch()"})
  void testMatchesIsMatch_givenNone_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(Matches.NONE.isMatch());
  }

  /**
   * Test Matches {@link Matches#isSource()}.
   * <ul>
   *   <li>Given {@code BOTH}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Matches#isSource()}
   */
  @Test
  @DisplayName("Test Matches isSource(); given 'BOTH'; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Matches.isSource()"})
  void testMatchesIsSource_givenBoth_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(Matches.BOTH.isSource());
  }

  /**
   * Test Matches {@link Matches#isSource()}.
   * <ul>
   *   <li>Given {@link Matches#SOURCE}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Matches#isSource()}
   */
  @Test
  @DisplayName("Test Matches isSource(); given SOURCE; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Matches.isSource()"})
  void testMatchesIsSource_givenSource_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(Matches.SOURCE.isSource());
  }

  /**
   * Test Matches {@link Matches#isSource()}.
   * <ul>
   *   <li>Given {@code VERTEX}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Matches#isSource()}
   */
  @Test
  @DisplayName("Test Matches isSource(); given 'VERTEX'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Matches.isSource()"})
  void testMatchesIsSource_givenVertex_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(Matches.VERTEX.isSource());
  }
}
