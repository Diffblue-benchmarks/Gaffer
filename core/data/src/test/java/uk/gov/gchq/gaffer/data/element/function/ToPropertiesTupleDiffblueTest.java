package uk.gov.gchq.gaffer.data.element.function;

import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.data.element.Properties;

class ToPropertiesTupleDiffblueTest {
  /**
   * Test {@link ToPropertiesTuple#apply(Properties)} with {@code Properties}.
   *
   * <p>Method under test: {@link ToPropertiesTuple#apply(Properties)}
   */
  @Test
  @DisplayName("Test apply(Properties) with 'Properties'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "uk.gov.gchq.gaffer.data.element.function.PropertiesTuple ToPropertiesTuple.apply(Properties)"
  })
  void testApplyWithProperties() {
    // Arrange
    ToPropertiesTuple toPropertiesTuple = new ToPropertiesTuple();
    Properties properties = new Properties();

    // Act and Assert
    assertSame(properties, toPropertiesTuple.apply(properties).getProperties());
  }
}
