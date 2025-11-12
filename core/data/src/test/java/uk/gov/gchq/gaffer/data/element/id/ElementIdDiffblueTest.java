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

package uk.gov.gchq.gaffer.data.element.id;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.data.element.Edge;
import uk.gov.gchq.gaffer.data.element.ElementValueLoader;
import uk.gov.gchq.gaffer.data.element.LazyEdge;

class ElementIdDiffblueTest {
  /**
   * Method under test: {@link ElementId#getClassName()}
   */
  @Test
  void testGetClassName() {
    // Arrange, Act and Assert
    assertEquals("uk.gov.gchq.gaffer.data.element.LazyEdge",
        (new LazyEdge(new Edge("Group"), mock(ElementValueLoader.class))).getClassName());
  }

  /**
   * Method under test: {@link ElementId.Matches#isDestination()}
   */
  @Test
  void testMatchesIsDestination() {
    // Arrange, Act and Assert
    assertTrue(ElementId.Matches.BOTH.isDestination());
    assertTrue(ElementId.Matches.DESTINATION.isDestination());
    assertFalse(ElementId.Matches.VERTEX.isDestination());
  }

  /**
   * Method under test: {@link ElementId.Matches#isIdentifier()}
   */
  @Test
  void testMatchesIsIdentifier() {
    // Arrange, Act and Assert
    assertFalse(ElementId.Matches.BOTH.isIdentifier());
    assertTrue(ElementId.Matches.VERTEX.isIdentifier());
  }

  /**
   * Method under test: {@link ElementId.Matches#isMatch()}
   */
  @Test
  void testMatchesIsMatch() {
    // Arrange, Act and Assert
    assertTrue(ElementId.Matches.BOTH.isMatch());
    assertFalse(ElementId.Matches.NONE.isMatch());
  }

  /**
   * Method under test: {@link ElementId.Matches#isSource()}
   */
  @Test
  void testMatchesIsSource() {
    // Arrange, Act and Assert
    assertTrue(ElementId.Matches.BOTH.isSource());
    assertTrue(ElementId.Matches.SOURCE.isSource());
    assertFalse(ElementId.Matches.VERTEX.isSource());
  }
}
