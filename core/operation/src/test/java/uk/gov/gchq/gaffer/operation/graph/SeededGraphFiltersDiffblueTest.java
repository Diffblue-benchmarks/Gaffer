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

package uk.gov.gchq.gaffer.operation.graph;

import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.operation.graph.SeededGraphFilters.IncludeIncomingOutgoingType;
import uk.gov.gchq.gaffer.operation.impl.get.GetAdjacentIds;
import uk.gov.gchq.gaffer.operation.impl.get.GetAdjacentIds.Builder;

class SeededGraphFiltersDiffblueTest {
  /**
   * Test Builder {@link SeededGraphFilters.Builder#inOutType(IncludeIncomingOutgoingType)}.
   *
   * <p>Method under test: {@link SeededGraphFilters.Builder#inOutType(IncludeIncomingOutgoingType)}
   */
  @Test
  @DisplayName("Test Builder inOutType(IncludeIncomingOutgoingType)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "SeededGraphFilters.Builder SeededGraphFilters.Builder.inOutType(IncludeIncomingOutgoingType)"
  })
  void testBuilderInOutType() {
    // Arrange
    Builder builder = new Builder();

    // Act
    Builder actualInOutTypeResult = builder.inOutType(IncludeIncomingOutgoingType.EITHER);

    // Assert
    assertSame(builder, actualInOutTypeResult);
  }
}
