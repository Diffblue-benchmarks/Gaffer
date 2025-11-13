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

package uk.gov.gchq.gaffer.accumulostore.key.core.impl.byteEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Map;
import org.apache.accumulo.core.client.IteratorSetting;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.accumulostore.operation.impl.GetElementsBetweenSets;
import uk.gov.gchq.gaffer.data.elementdefinition.view.View;
import uk.gov.gchq.gaffer.operation.graph.GraphFilters;

class ByteEntityIteratorSettingsFactoryDiffblueTest {
  /**
   * Test {@link ByteEntityIteratorSettingsFactory#getEdgeEntityDirectionFilterIteratorSetting(GraphFilters)}.
   * <p>
   * Method under test: {@link ByteEntityIteratorSettingsFactory#getEdgeEntityDirectionFilterIteratorSetting(GraphFilters)}
   */
  @Test
  @DisplayName("Test getEdgeEntityDirectionFilterIteratorSetting(GraphFilters)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "IteratorSetting ByteEntityIteratorSettingsFactory.getEdgeEntityDirectionFilterIteratorSetting(GraphFilters)"})
  void testGetEdgeEntityDirectionFilterIteratorSetting() {
    // Arrange
    ByteEntityIteratorSettingsFactory byteEntityIteratorSettingsFactory = new ByteEntityIteratorSettingsFactory();

    // Act and Assert
    assertNull(
        byteEntityIteratorSettingsFactory.getEdgeEntityDirectionFilterIteratorSetting(new GetElementsBetweenSets()));
  }

  /**
   * Test {@link ByteEntityIteratorSettingsFactory#getElementPropertyRangeQueryFilter(GraphFilters)}.
   * <p>
   * Method under test: {@link ByteEntityIteratorSettingsFactory#getElementPropertyRangeQueryFilter(GraphFilters)}
   */
  @Test
  @DisplayName("Test getElementPropertyRangeQueryFilter(GraphFilters)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "IteratorSetting ByteEntityIteratorSettingsFactory.getElementPropertyRangeQueryFilter(GraphFilters)"})
  void testGetElementPropertyRangeQueryFilter() {
    // Arrange
    ByteEntityIteratorSettingsFactory byteEntityIteratorSettingsFactory = new ByteEntityIteratorSettingsFactory();

    GetElementsBetweenSets operation = new GetElementsBetweenSets();
    operation.setView(new View());

    // Act
    IteratorSetting actualElementPropertyRangeQueryFilter = byteEntityIteratorSettingsFactory
        .getElementPropertyRangeQueryFilter(operation);

    // Assert
    assertEquals("Range_Element_Property_Filter", actualElementPropertyRangeQueryFilter.getName());
    assertEquals(
        "uk.gov.gchq.gaffer.accumulostore.key.core.impl.byteEntity.ByteEntityRangeElementPropertyFilt" + "erIterator",
        actualElementPropertyRangeQueryFilter.getIteratorClass());
    Map<String, String> options = actualElementPropertyRangeQueryFilter.getOptions();
    assertEquals(1, options.size());
    String expectedGetResult = Boolean.TRUE.toString();
    assertEquals(expectedGetResult, options.get("all"));
    assertEquals(Integer.SIZE, actualElementPropertyRangeQueryFilter.getPriority());
  }
}
