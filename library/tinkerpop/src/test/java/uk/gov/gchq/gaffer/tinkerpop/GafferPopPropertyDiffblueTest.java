package uk.gov.gchq.gaffer.tinkerpop;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class GafferPopPropertyDiffblueTest {
  /**
   * Test {@link GafferPopProperty#isPresent()}.
   *
   * <ul>
   *   <li>Given {@link GafferPopVertex#GafferPopVertex(String, Object, GafferPopGraph)} with {@code
   *       Label} and {@code Id} and graph is {@code null}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link GafferPopProperty#isPresent()}
   */
  @Test
  @DisplayName(
      "Test isPresent(); given GafferPopVertex(String, Object, GafferPopGraph) with 'Label' and 'Id' and graph is 'null'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean GafferPopProperty.isPresent()"})
  void testIsPresent_givenGafferPopVertexWithLabelAndIdAndGraphIsNull_thenReturnFalse() {
    // Arrange
    GafferPopVertex element = new GafferPopVertex("Label", "Id", null);
    GafferPopProperty<Object> gafferPopProperty = new GafferPopProperty<>(element, "Key", null);

    // Act and Assert
    assertFalse(gafferPopProperty.isPresent());
  }

  /**
   * Test {@link GafferPopProperty#isPresent()}.
   *
   * <ul>
   *   <li>Given {@link GafferPopVertex#GafferPopVertex(String, Object, GafferPopGraph)} with {@code
   *       Label} and {@code Id} and graph is {@code null}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link GafferPopProperty#isPresent()}
   */
  @Test
  @DisplayName(
      "Test isPresent(); given GafferPopVertex(String, Object, GafferPopGraph) with 'Label' and 'Id' and graph is 'null'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean GafferPopProperty.isPresent()"})
  void testIsPresent_givenGafferPopVertexWithLabelAndIdAndGraphIsNull_thenReturnTrue() {
    // Arrange
    GafferPopVertex element = new GafferPopVertex("Label", "Id", null);
    GafferPopProperty<Object> gafferPopProperty = new GafferPopProperty<>(element, "Key", "Value");

    // Act and Assert
    assertTrue(gafferPopProperty.isPresent());
  }
}
