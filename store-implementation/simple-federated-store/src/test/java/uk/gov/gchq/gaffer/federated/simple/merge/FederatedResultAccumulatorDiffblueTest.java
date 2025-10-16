package uk.gov.gchq.gaffer.federated.simple.merge;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class FederatedResultAccumulatorDiffblueTest {
  /**
   * Test {@link FederatedResultAccumulator#setAggregateElements(boolean)}.
   *
   * <p>Method under test: {@link FederatedResultAccumulator#setAggregateElements(boolean)}
   */
  @Test
  @DisplayName("Test setAggregateElements(boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void FederatedResultAccumulator.setAggregateElements(boolean)"})
  void testSetAggregateElements() {
    // Arrange
    DefaultResultAccumulator<Object> defaultResultAccumulator = new DefaultResultAccumulator<>();

    // Act
    defaultResultAccumulator.setAggregateElements(true);

    // Assert
    assertTrue(defaultResultAccumulator.aggregateElements());
    assertTrue(defaultResultAccumulator.aggregateElements);
  }

  /**
   * Test {@link FederatedResultAccumulator#aggregateElements()}.
   *
   * <ul>
   *   <li>Given {@link DefaultResultAccumulator#DefaultResultAccumulator()}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link FederatedResultAccumulator#aggregateElements()}
   */
  @Test
  @DisplayName("Test aggregateElements(); given DefaultResultAccumulator(); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean FederatedResultAccumulator.aggregateElements()"})
  void testAggregateElements_givenDefaultResultAccumulator_thenReturnFalse() {
    // Arrange
    DefaultResultAccumulator<Object> defaultResultAccumulator = new DefaultResultAccumulator<>();

    // Act and Assert
    assertFalse(defaultResultAccumulator.aggregateElements());
  }

  /**
   * Test {@link FederatedResultAccumulator#aggregateElements()}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link FederatedResultAccumulator#aggregateElements()}
   */
  @Test
  @DisplayName("Test aggregateElements(); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean FederatedResultAccumulator.aggregateElements()"})
  void testAggregateElements_thenReturnTrue() {
    // Arrange
    DefaultResultAccumulator<Object> defaultResultAccumulator = new DefaultResultAccumulator<>();
    defaultResultAccumulator.setAggregateElements(true);

    // Act and Assert
    assertTrue(defaultResultAccumulator.aggregateElements());
  }
}
