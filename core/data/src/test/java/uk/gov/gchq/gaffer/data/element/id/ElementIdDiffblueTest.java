package uk.gov.gchq.gaffer.data.element.id;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.data.element.id.ElementId.Matches;

class ElementIdDiffblueTest {
  /**
   * Test Matches {@link Matches#isDestination()}.
   *
   * <ul>
   *   <li>Given {@code BOTH}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link Matches#isDestination()}
   */
  @Test
  @DisplayName("Test Matches isDestination(); given 'BOTH'; then return 'true'")
  @Tag("MaintainedByDiffblue")
  void testMatchesIsDestination_givenBoth_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(Matches.BOTH.isDestination());
  }

  /**
   * Test Matches {@link Matches#isDestination()}.
   *
   * <ul>
   *   <li>Given {@link Matches#DESTINATION}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link Matches#isDestination()}
   */
  @Test
  @DisplayName("Test Matches isDestination(); given DESTINATION; then return 'true'")
  @Tag("MaintainedByDiffblue")
  void testMatchesIsDestination_givenDestination_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(Matches.DESTINATION.isDestination());
  }

  /**
   * Test Matches {@link Matches#isDestination()}.
   *
   * <ul>
   *   <li>Given {@code VERTEX}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link Matches#isDestination()}
   */
  @Test
  @DisplayName("Test Matches isDestination(); given 'VERTEX'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  void testMatchesIsDestination_givenVertex_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(Matches.VERTEX.isDestination());
  }

  /**
   * Test Matches {@link Matches#isIdentifier()}.
   *
   * <ul>
   *   <li>Given {@code BOTH}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link Matches#isIdentifier()}
   */
  @Test
  @DisplayName("Test Matches isIdentifier(); given 'BOTH'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  void testMatchesIsIdentifier_givenBoth_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(Matches.BOTH.isIdentifier());
  }

  /**
   * Test Matches {@link Matches#isIdentifier()}.
   *
   * <ul>
   *   <li>Given {@link Matches#VERTEX}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link Matches#isIdentifier()}
   */
  @Test
  @DisplayName("Test Matches isIdentifier(); given VERTEX; then return 'true'")
  @Tag("MaintainedByDiffblue")
  void testMatchesIsIdentifier_givenVertex_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(Matches.VERTEX.isIdentifier());
  }

  /**
   * Test Matches {@link Matches#isMatch()}.
   *
   * <ul>
   *   <li>Given {@code BOTH}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link Matches#isMatch()}
   */
  @Test
  @DisplayName("Test Matches isMatch(); given 'BOTH'; then return 'true'")
  @Tag("MaintainedByDiffblue")
  void testMatchesIsMatch_givenBoth_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(Matches.BOTH.isMatch());
  }

  /**
   * Test Matches {@link Matches#isMatch()}.
   *
   * <ul>
   *   <li>Given {@link Matches#NONE}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link Matches#isMatch()}
   */
  @Test
  @DisplayName("Test Matches isMatch(); given NONE; then return 'false'")
  @Tag("MaintainedByDiffblue")
  void testMatchesIsMatch_givenNone_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(Matches.NONE.isMatch());
  }

  /**
   * Test Matches {@link Matches#isSource()}.
   *
   * <ul>
   *   <li>Given {@code BOTH}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link Matches#isSource()}
   */
  @Test
  @DisplayName("Test Matches isSource(); given 'BOTH'; then return 'true'")
  @Tag("MaintainedByDiffblue")
  void testMatchesIsSource_givenBoth_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(Matches.BOTH.isSource());
  }

  /**
   * Test Matches {@link Matches#isSource()}.
   *
   * <ul>
   *   <li>Given {@link Matches#SOURCE}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link Matches#isSource()}
   */
  @Test
  @DisplayName("Test Matches isSource(); given SOURCE; then return 'true'")
  @Tag("MaintainedByDiffblue")
  void testMatchesIsSource_givenSource_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(Matches.SOURCE.isSource());
  }

  /**
   * Test Matches {@link Matches#isSource()}.
   *
   * <ul>
   *   <li>Given {@code VERTEX}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link Matches#isSource()}
   */
  @Test
  @DisplayName("Test Matches isSource(); given 'VERTEX'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  void testMatchesIsSource_givenVertex_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(Matches.VERTEX.isSource());
  }
}
