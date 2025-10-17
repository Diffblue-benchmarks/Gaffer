/*
 * Copyright 2025 Crown Copyright
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

package uk.gov.gchq.gaffer.accumulostore.key.core;

import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.accumulostore.key.core.impl.byteEntity.ByteEntityRangeFactory;
import uk.gov.gchq.gaffer.accumulostore.key.exception.RangeFactoryException;
import uk.gov.gchq.gaffer.accumulostore.operation.impl.GetElementsBetweenSets;
import uk.gov.gchq.gaffer.data.element.id.ElementId;
import uk.gov.gchq.gaffer.data.elementdefinition.view.View;
import uk.gov.gchq.gaffer.operation.data.EdgeSeed;
import uk.gov.gchq.gaffer.operation.graph.GraphFilters;
import uk.gov.gchq.gaffer.store.schema.Schema;

class AbstractCoreKeyRangeFactoryDiffblueTest {
  /**
   * Test {@link AbstractCoreKeyRangeFactory#getRange(ElementId, GraphFilters)} with {@code
   * elementId}, {@code operation}.
   *
   * <ul>
   *   <li>Given {@link View} (default constructor).
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link AbstractCoreKeyRangeFactory#getRange(ElementId, GraphFilters)}
   */
  @Test
  @DisplayName(
      "Test getRange(ElementId, GraphFilters) with 'elementId', 'operation'; given View (default constructor); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.util.List AbstractCoreKeyRangeFactory.getRange(ElementId, GraphFilters)"
  })
  void testGetRangeWithElementIdOperation_givenView_thenReturnEmpty() throws RangeFactoryException {
    // Arrange
    ByteEntityRangeFactory byteEntityRangeFactory = new ByteEntityRangeFactory(new Schema());
    EdgeSeed elementId = new EdgeSeed();

    GetElementsBetweenSets operation = new GetElementsBetweenSets();
    operation.setView(new View());

    // Act and Assert
    assertTrue(byteEntityRangeFactory.getRange(elementId, operation).isEmpty());
  }
}
