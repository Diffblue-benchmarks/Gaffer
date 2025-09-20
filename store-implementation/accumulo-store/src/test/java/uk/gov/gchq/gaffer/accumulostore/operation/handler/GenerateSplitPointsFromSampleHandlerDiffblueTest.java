package uk.gov.gchq.gaffer.accumulostore.operation.handler;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.accumulostore.AccumuloStore;
import uk.gov.gchq.gaffer.operation.impl.GenerateSplitPointsFromSample;

class GenerateSplitPointsFromSampleHandlerDiffblueTest {
  /**
   * Test {@link GenerateSplitPointsFromSampleHandler#getNumSplits(GenerateSplitPointsFromSample,
   * AccumuloStore)} with {@code GenerateSplitPointsFromSample}, {@code AccumuloStore}.
   *
   * <p>Method under test: {@link
   * GenerateSplitPointsFromSampleHandler#getNumSplits(GenerateSplitPointsFromSample,
   * AccumuloStore)}
   */
  @Test
  @DisplayName(
      "Test getNumSplits(GenerateSplitPointsFromSample, AccumuloStore) with 'GenerateSplitPointsFromSample', 'AccumuloStore'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Integer GenerateSplitPointsFromSampleHandler.getNumSplits(GenerateSplitPointsFromSample, AccumuloStore)"
  })
  void testGetNumSplitsWithGenerateSplitPointsFromSampleAccumuloStore() {
    // Arrange
    GenerateSplitPointsFromSampleHandler generateSplitPointsFromSampleHandler =
        new GenerateSplitPointsFromSampleHandler();

    GenerateSplitPointsFromSample operation = new GenerateSplitPointsFromSample();
    operation.setNumSplits(1);

    // Act and Assert
    assertEquals(
        1,
        generateSplitPointsFromSampleHandler
            .getNumSplits(operation, new AccumuloStore())
            .intValue());
  }
}
