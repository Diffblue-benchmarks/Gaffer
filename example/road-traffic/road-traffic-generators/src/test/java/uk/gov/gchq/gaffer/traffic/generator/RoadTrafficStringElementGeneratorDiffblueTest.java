package uk.gov.gchq.gaffer.traffic.generator;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class RoadTrafficStringElementGeneratorDiffblueTest {
  /**
   * Test {@link RoadTrafficStringElementGenerator#isHeader(String)}.
   *
   * <ul>
   *   <li>When {@code Line}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link RoadTrafficStringElementGenerator#isHeader(String)}
   */
  @Test
  @DisplayName("Test isHeader(String); when 'Line'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  void testIsHeader_whenLine_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(RoadTrafficStringElementGenerator.isHeader("Line"));
  }

  /**
   * Test {@link RoadTrafficStringElementGenerator#isHeader(String)}.
   *
   * <ul>
   *   <li>When {@code "Region Name (GO)",}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link RoadTrafficStringElementGenerator#isHeader(String)}
   */
  @Test
  @DisplayName("Test isHeader(String); when '\"Region Name (GO)\",'; then return 'true'")
  @Tag("MaintainedByDiffblue")
  void testIsHeader_whenRegionNameGo_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(RoadTrafficStringElementGenerator.isHeader("\"Region Name (GO)\","));
  }

  /**
   * Test {@link RoadTrafficStringElementGenerator#extractFields(String)}.
   *
   * <ul>
   *   <li>When {@code "Region Name (GO)",}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link RoadTrafficStringElementGenerator#extractFields(String)}
   */
  @Test
  @DisplayName("Test extractFields(String); when '\"Region Name (GO)\",'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  void testExtractFields_whenRegionNameGo_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(RoadTrafficStringElementGenerator.extractFields("\"Region Name (GO)\","));
  }
}
