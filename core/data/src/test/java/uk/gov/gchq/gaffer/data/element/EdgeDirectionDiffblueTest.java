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

package uk.gov.gchq.gaffer.data.element;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class EdgeDirectionDiffblueTest {
  /**
   * Test {@link EdgeDirection#isDirected()}.
   *
   * <ul>
   *   <li>Given {@link EdgeDirection#DIRECTED_REVERSED}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link EdgeDirection#isDirected()}
   */
  @Test
  @DisplayName("Test isDirected(); given DIRECTED_REVERSED; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EdgeDirection.isDirected()"})
  void testIsDirected_givenDirected_reversed_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(EdgeDirection.DIRECTED_REVERSED.isDirected());
  }

  /**
   * Test {@link EdgeDirection#isDirected()}.
   *
   * <ul>
   *   <li>Given {@code DIRECTED}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link EdgeDirection#isDirected()}
   */
  @Test
  @DisplayName("Test isDirected(); given 'DIRECTED'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EdgeDirection.isDirected()"})
  void testIsDirected_givenDirected_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(EdgeDirection.DIRECTED.isDirected());
  }

  /**
   * Test {@link EdgeDirection#isDirected()}.
   *
   * <ul>
   *   <li>Given {@code UNDIRECTED}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link EdgeDirection#isDirected()}
   */
  @Test
  @DisplayName("Test isDirected(); given 'UNDIRECTED'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EdgeDirection.isDirected()"})
  void testIsDirected_givenUndirected_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(EdgeDirection.UNDIRECTED.isDirected());
  }
}
