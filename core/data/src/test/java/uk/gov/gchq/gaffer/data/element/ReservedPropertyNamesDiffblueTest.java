package uk.gov.gchq.gaffer.data.element;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ReservedPropertyNamesDiffblueTest {
  /**
   * Test {@link ReservedPropertyNames#contains(String)}.
   *
   * <ul>
   *   <li>When {@code DIRECTED}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link ReservedPropertyNames#contains(String)}
   */
  @Test
  @DisplayName("Test contains(String); when 'DIRECTED'; then return 'true'")
  @Tag("MaintainedByDiffblue")
  void testContains_whenDirected_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(ReservedPropertyNames.contains("DIRECTED"));
  }

  /**
   * Test {@link ReservedPropertyNames#contains(String)}.
   *
   * <ul>
   *   <li>When {@code Property}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ReservedPropertyNames#contains(String)}
   */
  @Test
  @DisplayName("Test contains(String); when 'Property'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  void testContains_whenProperty_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(ReservedPropertyNames.contains("Property"));
  }

  /**
   * Test {@link ReservedPropertyNames#getNames()}.
   *
   * <p>Method under test: {@link ReservedPropertyNames#getNames()}
   */
  @Test
  @DisplayName("Test getNames()")
  @Tag("MaintainedByDiffblue")
  void testGetNames() {
    // Arrange and Act
    Stream<String> actualNames = ReservedPropertyNames.GROUP.getNames();

    // Assert
    List<String> collectResult = actualNames.limit(5).collect(Collectors.toList());
    assertEquals(2, collectResult.size());
    assertEquals("GROUP", collectResult.get(1));
    assertEquals("group", collectResult.get(0));
  }
}
