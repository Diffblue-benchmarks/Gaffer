/*
 * Copyright 2026 Crown Copyright
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package uk.gov.gchq.gaffer.accumulostore.operation.handler;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.accumulostore.AccumuloStore;
import uk.gov.gchq.gaffer.operation.impl.SampleElementsForSplitPoints;

class SampleElementsForSplitPointsHandlerDiffblueTest {
  /**
   * Test {@link SampleElementsForSplitPointsHandler#getNumSplits(SampleElementsForSplitPoints,
   * AccumuloStore)} with {@code SampleElementsForSplitPoints}, {@code AccumuloStore}.
   *
   * <p>Method under test: {@link
   * SampleElementsForSplitPointsHandler#getNumSplits(SampleElementsForSplitPoints, AccumuloStore)}
   */
  @Test
  @DisplayName(
      "Test getNumSplits(SampleElementsForSplitPoints, AccumuloStore) with 'SampleElementsForSplitPoints', 'AccumuloStore'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Integer SampleElementsForSplitPointsHandler.getNumSplits(SampleElementsForSplitPoints, AccumuloStore)"
  })
  void testGetNumSplitsWithSampleElementsForSplitPointsAccumuloStore() {
    // Arrange
    SampleElementsForSplitPointsHandler sampleElementsForSplitPointsHandler =
        new SampleElementsForSplitPointsHandler();

    SampleElementsForSplitPoints operation = new SampleElementsForSplitPoints();
    operation.setNumSplits(1);

    // Act and Assert
    assertEquals(
        1,
        sampleElementsForSplitPointsHandler
            .getNumSplits(operation, new AccumuloStore())
            .intValue());
  }

  /**
   * Test new {@link SampleElementsForSplitPointsHandler} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link
   * SampleElementsForSplitPointsHandler}
   */
  @Test
  @DisplayName("Test new SampleElementsForSplitPointsHandler (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SampleElementsForSplitPointsHandler.<init>()"})
  void testNewSampleElementsForSplitPointsHandler() {
    // Arrange, Act and Assert
    assertEquals(10000000, new SampleElementsForSplitPointsHandler().getMaxSampledElements());
  }
}
