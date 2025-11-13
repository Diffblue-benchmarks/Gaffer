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

package uk.gov.gchq.gaffer.accumulostore.key.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Map;
import org.apache.accumulo.core.iterators.OptionDescriber;
import org.apache.accumulo.core.iterators.OptionDescriber.IteratorOptions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ValidatorFilterDiffblueTest {
  /**
   * Test new {@link ValidatorFilter} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of {@link ValidatorFilter}
   */
  @Test
  @DisplayName("Test new ValidatorFilter (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void ValidatorFilter.<init>()"})
  void testNewValidatorFilter() {
    // Arrange, Act and Assert
    IteratorOptions describeOptionsResult = (new ValidatorFilter()).describeOptions();
    Map<String, String> namedOptions = describeOptionsResult.getNamedOptions();
    assertEquals(1, namedOptions.size());
    assertEquals("A serialised schema", namedOptions.get("Schema"));
    assertEquals("Only returns elements that are valid against the schema", describeOptionsResult.getDescription());
    assertEquals("Schema", describeOptionsResult.getName());
    assertNull(describeOptionsResult.getUnnamedOptionDescriptions());
  }

  /**
   * Test {@link ValidatorFilter#describeOptions()}.
   * <p>
   * Method under test: {@link ValidatorFilter#describeOptions()}
   */
  @Test
  @DisplayName("Test describeOptions()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"OptionDescriber.IteratorOptions ValidatorFilter.describeOptions()"})
  void testDescribeOptions() {
    // Arrange and Act
    IteratorOptions actualDescribeOptionsResult = (new ValidatorFilter()).describeOptions();

    // Assert
    Map<String, String> namedOptions = actualDescribeOptionsResult.getNamedOptions();
    assertEquals(1, namedOptions.size());
    assertEquals("A serialised schema", namedOptions.get("Schema"));
    assertEquals("Only returns elements that are valid against the schema",
        actualDescribeOptionsResult.getDescription());
    assertEquals("Schema", actualDescribeOptionsResult.getName());
    assertNull(actualDescribeOptionsResult.getUnnamedOptionDescriptions());
  }
}
