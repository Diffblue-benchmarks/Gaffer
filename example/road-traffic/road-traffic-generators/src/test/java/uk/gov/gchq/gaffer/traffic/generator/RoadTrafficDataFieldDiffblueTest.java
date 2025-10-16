package uk.gov.gchq.gaffer.traffic.generator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String RoadTrafficDataField.fieldName()"})
  void testFieldName() {
    // Arrange, Act and Assert
    assertEquals("Region Name (GO)", RoadTrafficDataField.valueOf("Region_Name").fieldName());
  }
}
