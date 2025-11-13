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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class DirectedTypeDiffblueTest {
  /**
   * Test {@link DirectedType#isEither(DirectedType)}.
   *
   * <ul>
   *   <li>When {@code DIRECTED}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link DirectedType#isEither(DirectedType)}
   */
  @Test
  @DisplayName("Test isEither(DirectedType); when 'DIRECTED'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DirectedType.isEither(DirectedType)"})
  void testIsEither_whenDirected_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(DirectedType.isEither(DirectedType.DIRECTED));
  }

  /**
   * Test {@link DirectedType#isEither(DirectedType)}.
   *
   * <ul>
   *   <li>When {@code EITHER}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link DirectedType#isEither(DirectedType)}
   */
  @Test
  @DisplayName("Test isEither(DirectedType); when 'EITHER'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DirectedType.isEither(DirectedType)"})
  void testIsEither_whenEither_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(DirectedType.isEither(DirectedType.EITHER));
  }

  /**
   * Test {@link DirectedType#isEither(DirectedType)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link DirectedType#isEither(DirectedType)}
   */
  @Test
  @DisplayName("Test isEither(DirectedType); when 'null'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DirectedType.isEither(DirectedType)"})
  void testIsEither_whenNull_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(DirectedType.isEither(null));
  }

  /**
   * Test {@link DirectedType#isDirected(DirectedType)} with {@code DirectedType}.
   *
   * <ul>
   *   <li>When {@code EITHER}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link DirectedType#isDirected(DirectedType)}
   */
  @Test
  @DisplayName(
      "Test isDirected(DirectedType) with 'DirectedType'; when 'EITHER'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DirectedType.isDirected(DirectedType)"})
  void testIsDirectedWithDirectedType_whenEither_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(DirectedType.isDirected(DirectedType.EITHER));
  }

  /**
   * Test {@link DirectedType#isDirected(DirectedType)} with {@code DirectedType}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link DirectedType#isDirected(DirectedType)}
   */
  @Test
  @DisplayName("Test isDirected(DirectedType) with 'DirectedType'; when 'null'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DirectedType.isDirected(DirectedType)"})
  void testIsDirectedWithDirectedType_whenNull_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(DirectedType.isDirected(null));
  }

  /**
   * Test {@link DirectedType#isDirected(DirectedType)} with {@code DirectedType}.
   *
   * <ul>
   *   <li>When {@link DirectedType#UNDIRECTED}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link DirectedType#isDirected(DirectedType)}
   */
  @Test
  @DisplayName(
      "Test isDirected(DirectedType) with 'DirectedType'; when UNDIRECTED; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DirectedType.isDirected(DirectedType)"})
  void testIsDirectedWithDirectedType_whenUndirected_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(DirectedType.isDirected(DirectedType.UNDIRECTED));
  }

  /**
   * Test {@link DirectedType#isDirected()}.
   *
   * <ul>
   *   <li>Given {@code EITHER}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link DirectedType#isDirected()}
   */
  @Test
  @DisplayName("Test isDirected(); given 'EITHER'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DirectedType.isDirected()"})
  void testIsDirected_givenEither_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(DirectedType.EITHER.isDirected());
  }

  /**
   * Test {@link DirectedType#isDirected()}.
   *
   * <ul>
   *   <li>Given {@link DirectedType#UNDIRECTED}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link DirectedType#isDirected()}
   */
  @Test
  @DisplayName("Test isDirected(); given UNDIRECTED; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DirectedType.isDirected()"})
  void testIsDirected_givenUndirected_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(DirectedType.UNDIRECTED.isDirected());
  }

  /**
   * Test {@link DirectedType#isUndirected(DirectedType)} with {@code DirectedType}.
   *
   * <ul>
   *   <li>When {@link DirectedType#DIRECTED}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link DirectedType#isUndirected(DirectedType)}
   */
  @Test
  @DisplayName(
      "Test isUndirected(DirectedType) with 'DirectedType'; when DIRECTED; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DirectedType.isUndirected(DirectedType)"})
  void testIsUndirectedWithDirectedType_whenDirected_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(DirectedType.isUndirected(DirectedType.DIRECTED));
  }

  /**
   * Test {@link DirectedType#isUndirected(DirectedType)} with {@code DirectedType}.
   *
   * <ul>
   *   <li>When {@code EITHER}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link DirectedType#isUndirected(DirectedType)}
   */
  @Test
  @DisplayName(
      "Test isUndirected(DirectedType) with 'DirectedType'; when 'EITHER'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DirectedType.isUndirected(DirectedType)"})
  void testIsUndirectedWithDirectedType_whenEither_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(DirectedType.isUndirected(DirectedType.EITHER));
  }

  /**
   * Test {@link DirectedType#isUndirected(DirectedType)} with {@code DirectedType}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link DirectedType#isUndirected(DirectedType)}
   */
  @Test
  @DisplayName(
      "Test isUndirected(DirectedType) with 'DirectedType'; when 'null'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DirectedType.isUndirected(DirectedType)"})
  void testIsUndirectedWithDirectedType_whenNull_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(DirectedType.isUndirected(null));
  }

  /**
   * Test {@link DirectedType#isUndirected()}.
   *
   * <ul>
   *   <li>Given {@link DirectedType#DIRECTED}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link DirectedType#isUndirected()}
   */
  @Test
  @DisplayName("Test isUndirected(); given DIRECTED; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DirectedType.isUndirected()"})
  void testIsUndirected_givenDirected_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(DirectedType.DIRECTED.isUndirected());
  }

  /**
   * Test {@link DirectedType#isUndirected()}.
   *
   * <ul>
   *   <li>Given {@code EITHER}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link DirectedType#isUndirected()}
   */
  @Test
  @DisplayName("Test isUndirected(); given 'EITHER'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DirectedType.isUndirected()"})
  void testIsUndirected_givenEither_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(DirectedType.EITHER.isUndirected());
  }

  /**
   * Test {@link DirectedType#areCompatible(DirectedType, DirectedType)}.
   *
   * <ul>
   *   <li>When {@link DirectedType#DIRECTED}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link DirectedType#areCompatible(DirectedType, DirectedType)}
   */
  @Test
  @DisplayName("Test areCompatible(DirectedType, DirectedType); when DIRECTED; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DirectedType.areCompatible(DirectedType, DirectedType)"})
  void testAreCompatible_whenDirected_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(DirectedType.areCompatible(DirectedType.DIRECTED, DirectedType.UNDIRECTED));
  }

  /**
   * Test {@link DirectedType#areCompatible(DirectedType, DirectedType)}.
   *
   * <ul>
   *   <li>When {@link DirectedType#DIRECTED}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link DirectedType#areCompatible(DirectedType, DirectedType)}
   */
  @Test
  @DisplayName("Test areCompatible(DirectedType, DirectedType); when DIRECTED; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DirectedType.areCompatible(DirectedType, DirectedType)"})
  void testAreCompatible_whenDirected_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(DirectedType.areCompatible(DirectedType.DIRECTED, DirectedType.DIRECTED));
  }

  /**
   * Test {@link DirectedType#areCompatible(DirectedType, DirectedType)}.
   *
   * <ul>
   *   <li>When {@code EITHER}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link DirectedType#areCompatible(DirectedType, DirectedType)}
   */
  @Test
  @DisplayName("Test areCompatible(DirectedType, DirectedType); when 'EITHER'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DirectedType.areCompatible(DirectedType, DirectedType)"})
  void testAreCompatible_whenEither_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(DirectedType.areCompatible(DirectedType.EITHER, DirectedType.EITHER));
  }

  /**
   * Test {@link DirectedType#areCompatible(DirectedType, DirectedType)}.
   *
   * <ul>
   *   <li>When {@link DirectedType#UNDIRECTED}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link DirectedType#areCompatible(DirectedType, DirectedType)}
   */
  @Test
  @DisplayName(
      "Test areCompatible(DirectedType, DirectedType); when UNDIRECTED; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DirectedType.areCompatible(DirectedType, DirectedType)"})
  void testAreCompatible_whenUndirected_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(DirectedType.areCompatible(DirectedType.UNDIRECTED, DirectedType.DIRECTED));
  }

  /**
   * Test {@link DirectedType#areCompatible(DirectedType, DirectedType)}.
   *
   * <ul>
   *   <li>When {@link DirectedType#UNDIRECTED}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link DirectedType#areCompatible(DirectedType, DirectedType)}
   */
  @Test
  @DisplayName(
      "Test areCompatible(DirectedType, DirectedType); when UNDIRECTED; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DirectedType.areCompatible(DirectedType, DirectedType)"})
  void testAreCompatible_whenUndirected_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(DirectedType.areCompatible(DirectedType.UNDIRECTED, DirectedType.UNDIRECTED));
  }

  /**
   * Test {@link DirectedType#and(DirectedType, DirectedType)}.
   *
   * <ul>
   *   <li>When {@link DirectedType#DIRECTED}.
   *   <li>Then return {@code DIRECTED}.
   * </ul>
   *
   * <p>Method under test: {@link DirectedType#and(DirectedType, DirectedType)}
   */
  @Test
  @DisplayName("Test and(DirectedType, DirectedType); when DIRECTED; then return 'DIRECTED'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"DirectedType DirectedType.and(DirectedType, DirectedType)"})
  void testAnd_whenDirected_thenReturnDirected() {
    // Arrange, Act and Assert
    assertEquals(
        DirectedType.DIRECTED, DirectedType.and(DirectedType.DIRECTED, DirectedType.DIRECTED));
  }

  /**
   * Test {@link DirectedType#and(DirectedType, DirectedType)}.
   *
   * <ul>
   *   <li>When {@code DIRECTED}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link DirectedType#and(DirectedType, DirectedType)}
   */
  @Test
  @DisplayName(
      "Test and(DirectedType, DirectedType); when 'DIRECTED'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"DirectedType DirectedType.and(DirectedType, DirectedType)"})
  void testAnd_whenDirected_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> DirectedType.and(DirectedType.UNDIRECTED, DirectedType.DIRECTED));
  }

  /**
   * Test {@link DirectedType#and(DirectedType, DirectedType)}.
   *
   * <ul>
   *   <li>When {@link DirectedType#EITHER}.
   *   <li>Then return {@code DIRECTED}.
   * </ul>
   *
   * <p>Method under test: {@link DirectedType#and(DirectedType, DirectedType)}
   */
  @Test
  @DisplayName("Test and(DirectedType, DirectedType); when EITHER; then return 'DIRECTED'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"DirectedType DirectedType.and(DirectedType, DirectedType)"})
  void testAnd_whenEither_thenReturnDirected() {
    // Arrange, Act and Assert
    assertEquals(
        DirectedType.DIRECTED, DirectedType.and(DirectedType.DIRECTED, DirectedType.EITHER));
  }

  /**
   * Test {@link DirectedType#and(DirectedType, DirectedType)}.
   *
   * <ul>
   *   <li>When {@code EITHER}.
   *   <li>Then return {@code EITHER}.
   * </ul>
   *
   * <p>Method under test: {@link DirectedType#and(DirectedType, DirectedType)}
   */
  @Test
  @DisplayName("Test and(DirectedType, DirectedType); when 'EITHER'; then return 'EITHER'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"DirectedType DirectedType.and(DirectedType, DirectedType)"})
  void testAnd_whenEither_thenReturnEither() {
    // Arrange, Act and Assert
    assertEquals(DirectedType.EITHER, DirectedType.and(DirectedType.EITHER, DirectedType.EITHER));
  }

  /**
   * Test {@link DirectedType#and(DirectedType, DirectedType)}.
   *
   * <ul>
   *   <li>When {@link DirectedType#EITHER}.
   *   <li>Then return {@code EITHER}.
   * </ul>
   *
   * <p>Method under test: {@link DirectedType#and(DirectedType, DirectedType)}
   */
  @Test
  @DisplayName("Test and(DirectedType, DirectedType); when EITHER; then return 'EITHER'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"DirectedType DirectedType.and(DirectedType, DirectedType)"})
  void testAnd_whenEither_thenReturnEither2() {
    // Arrange, Act and Assert
    assertEquals(DirectedType.EITHER, DirectedType.and(DirectedType.EITHER, null));
  }

  /**
   * Test {@link DirectedType#and(DirectedType, DirectedType)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code DIRECTED}.
   * </ul>
   *
   * <p>Method under test: {@link DirectedType#and(DirectedType, DirectedType)}
   */
  @Test
  @DisplayName("Test and(DirectedType, DirectedType); when 'null'; then return 'DIRECTED'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"DirectedType DirectedType.and(DirectedType, DirectedType)"})
  void testAnd_whenNull_thenReturnDirected() {
    // Arrange, Act and Assert
    assertEquals(DirectedType.DIRECTED, DirectedType.and(DirectedType.DIRECTED, null));
  }

  /**
   * Test {@link DirectedType#and(DirectedType, DirectedType)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code EITHER}.
   * </ul>
   *
   * <p>Method under test: {@link DirectedType#and(DirectedType, DirectedType)}
   */
  @Test
  @DisplayName("Test and(DirectedType, DirectedType); when 'null'; then return 'EITHER'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"DirectedType DirectedType.and(DirectedType, DirectedType)"})
  void testAnd_whenNull_thenReturnEither() {
    // Arrange, Act and Assert
    assertEquals(DirectedType.EITHER, DirectedType.and(null, DirectedType.EITHER));
  }

  /**
   * Test {@link DirectedType#and(DirectedType, DirectedType)}.
   *
   * <ul>
   *   <li>When {@link DirectedType#UNDIRECTED}.
   *   <li>Then return {@code UNDIRECTED}.
   * </ul>
   *
   * <p>Method under test: {@link DirectedType#and(DirectedType, DirectedType)}
   */
  @Test
  @DisplayName("Test and(DirectedType, DirectedType); when UNDIRECTED; then return 'UNDIRECTED'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"DirectedType DirectedType.and(DirectedType, DirectedType)"})
  void testAnd_whenUndirected_thenReturnUndirected() {
    // Arrange, Act and Assert
    assertEquals(
        DirectedType.UNDIRECTED,
        DirectedType.and(DirectedType.UNDIRECTED, DirectedType.UNDIRECTED));
  }

  /**
   * Test {@link DirectedType#and(DirectedType, DirectedType)}.
   *
   * <ul>
   *   <li>When {@link DirectedType#UNDIRECTED}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link DirectedType#and(DirectedType, DirectedType)}
   */
  @Test
  @DisplayName(
      "Test and(DirectedType, DirectedType); when UNDIRECTED; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"DirectedType DirectedType.and(DirectedType, DirectedType)"})
  void testAnd_whenUndirected_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> DirectedType.and(DirectedType.DIRECTED, DirectedType.UNDIRECTED));
  }
}
