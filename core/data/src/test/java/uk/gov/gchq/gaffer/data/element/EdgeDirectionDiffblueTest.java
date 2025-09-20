package uk.gov.gchq.gaffer.data.element;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
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
  @Tag("MaintainedByDiffblue")
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
  @Tag("MaintainedByDiffblue")
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
  @Tag("MaintainedByDiffblue")
  void testIsDirected_givenUndirected_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(EdgeDirection.UNDIRECTED.isDirected());
  }
}
