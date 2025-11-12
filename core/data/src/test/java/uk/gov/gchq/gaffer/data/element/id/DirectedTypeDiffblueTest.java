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
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

class DirectedTypeDiffblueTest {
  /**
   * Method under test: {@link DirectedType#and(DirectedType, DirectedType)}
   */
  @Test
  void testAnd() {
    // Arrange, Act and Assert
    assertEquals(DirectedType.EITHER, DirectedType.and(DirectedType.EITHER, DirectedType.EITHER));
    assertEquals(DirectedType.EITHER, DirectedType.and(null, null));
    assertEquals(DirectedType.DIRECTED, DirectedType.and(DirectedType.DIRECTED, null));
    assertEquals(DirectedType.DIRECTED, DirectedType.and(DirectedType.DIRECTED, DirectedType.EITHER));
    assertEquals(DirectedType.DIRECTED, DirectedType.and(DirectedType.DIRECTED, DirectedType.DIRECTED));
    assertThrows(IllegalArgumentException.class,
        () -> DirectedType.and(DirectedType.DIRECTED, DirectedType.UNDIRECTED));
    assertThrows(IllegalArgumentException.class,
        () -> DirectedType.and(DirectedType.UNDIRECTED, DirectedType.DIRECTED));
    assertEquals(DirectedType.UNDIRECTED, DirectedType.and(DirectedType.UNDIRECTED, DirectedType.UNDIRECTED));
  }

  /**
   * Method under test:
   * {@link DirectedType#areCompatible(DirectedType, DirectedType)}
   */
  @Test
  void testAreCompatible() {
    // Arrange, Act and Assert
    assertTrue(DirectedType.areCompatible(DirectedType.EITHER, DirectedType.EITHER));
    assertTrue(DirectedType.areCompatible(DirectedType.DIRECTED, DirectedType.DIRECTED));
    assertFalse(DirectedType.areCompatible(DirectedType.DIRECTED, DirectedType.UNDIRECTED));
    assertFalse(DirectedType.areCompatible(DirectedType.UNDIRECTED, DirectedType.DIRECTED));
    assertTrue(DirectedType.areCompatible(DirectedType.UNDIRECTED, DirectedType.UNDIRECTED));
  }

  /**
   * Method under test: {@link DirectedType#isDirected()}
   */
  @Test
  void testIsDirected() {
    // Arrange, Act and Assert
    assertTrue(DirectedType.EITHER.isDirected());
    assertFalse(DirectedType.UNDIRECTED.isDirected());
    assertTrue(DirectedType.isDirected(DirectedType.EITHER));
    assertTrue(DirectedType.isDirected(null));
    assertFalse(DirectedType.isDirected(DirectedType.UNDIRECTED));
  }

  /**
   * Method under test: {@link DirectedType#isEither(DirectedType)}
   */
  @Test
  void testIsEither() {
    // Arrange, Act and Assert
    assertTrue(DirectedType.isEither(DirectedType.EITHER));
    assertTrue(DirectedType.isEither(null));
    assertFalse(DirectedType.isEither(DirectedType.DIRECTED));
  }

  /**
   * Method under test: {@link DirectedType#isUndirected()}
   */
  @Test
  void testIsUndirected() {
    // Arrange, Act and Assert
    assertTrue(DirectedType.EITHER.isUndirected());
    assertFalse(DirectedType.DIRECTED.isUndirected());
    assertTrue(DirectedType.isUndirected(DirectedType.EITHER));
    assertTrue(DirectedType.isUndirected(null));
    assertFalse(DirectedType.isUndirected(DirectedType.DIRECTED));
  }
}
