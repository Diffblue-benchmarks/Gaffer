package uk.gov.gchq.gaffer.traffic.generator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class RoadTrafficDataFieldDiffblueTest {
  /**
   * Test {@link RoadTrafficDataField#fieldName()}.
   *
   * <p>Method under test: {@link RoadTrafficDataField#fieldName()}
   */
  @Test
  @DisplayName("Test fieldName()")
  @Tag("MaintainedByDiffblue")
  void testFieldName() {
    // Arrange, Act and Assert
    assertEquals("Region Name (GO)", RoadTrafficDataField.valueOf("Region_Name").fieldName());
  }
}
