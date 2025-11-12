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

package uk.gov.gchq.gaffer.data.element.function;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.mock;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.data.element.Edge;
import uk.gov.gchq.gaffer.data.element.Element;
import uk.gov.gchq.gaffer.data.element.ElementValueLoader;
import uk.gov.gchq.gaffer.data.element.LazyEdge;

class ExtractGroupDiffblueTest {
  /**
   * Method under test: {@link ExtractGroup#apply(Element)}
   */
  @Test
  void testApply() {
    // Arrange
    ExtractGroup extractGroup = new ExtractGroup();

    // Act and Assert
    assertEquals("Group", extractGroup.apply(new Edge("Group")));
  }

  /**
   * Method under test: {@link ExtractGroup#apply(Element)}
   */
  @Test
  void testApply2() {
    // Arrange, Act and Assert
    assertNull((new ExtractGroup()).apply(null));
  }

  /**
   * Method under test: {@link ExtractGroup#apply(Element)}
   */
  @Test
  void testApply3() {
    // Arrange
    ExtractGroup extractGroup = new ExtractGroup();

    // Act and Assert
    assertEquals("Group", extractGroup.apply(new LazyEdge(new Edge("Group"), mock(ElementValueLoader.class))));
  }
}
