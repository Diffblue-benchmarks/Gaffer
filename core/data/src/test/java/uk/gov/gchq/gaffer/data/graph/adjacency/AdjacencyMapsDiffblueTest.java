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

package uk.gov.gchq.gaffer.data.graph.adjacency;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class AdjacencyMapsDiffblueTest {
  /**
   * Method under test: {@link AdjacencyMaps#add(AdjacencyMap)}
   */
  @Test
  void testAdd() {
    // Arrange
    SimpleAdjacencyMaps simpleAdjacencyMaps = new SimpleAdjacencyMaps();

    // Act
    simpleAdjacencyMaps.add(new AdjacencyMap());

    // Assert
    assertEquals(1, simpleAdjacencyMaps.size());
  }

  /**
   * Method under test: {@link AdjacencyMaps#add(AdjacencyMap)}
   */
  @Test
  void testAdd2() {
    // Arrange
    AdjacencyMaps adjacencyMaps = mock(AdjacencyMaps.class);
    doNothing().when(adjacencyMaps).add(Mockito.<AdjacencyMap>any());

    // Act
    adjacencyMaps.add(new AdjacencyMap());

    // Assert
    verify(adjacencyMaps).add(isA(AdjacencyMap.class));
  }

  /**
   * Method under test: {@link AdjacencyMaps#get(int)}
   */
  @Test
  void testGet() {
    // Arrange
    AdjacencyMaps adjacencyMaps = mock(AdjacencyMaps.class);
    when(adjacencyMaps.get(anyInt())).thenReturn(new AdjacencyMap());

    // Act
    adjacencyMaps.get(1);

    // Assert
    verify(adjacencyMaps).get(eq(1));
  }

  /**
   * Method under test: {@link AdjacencyMaps#get(int)}
   */
  @Test
  void testGet2() {
    // Arrange
    PrunedAdjacencyMaps prunedAdjacencyMaps = new PrunedAdjacencyMaps();
    prunedAdjacencyMaps.add(new AdjacencyMap());
    AdjacencyMap adjacencyMap = new AdjacencyMap();
    prunedAdjacencyMaps.add(adjacencyMap);

    // Act and Assert
    assertSame(adjacencyMap, prunedAdjacencyMaps.get(1));
  }

  /**
   * Method under test: {@link AdjacencyMaps#size()}
   */
  @Test
  void testSize() {
    // Arrange, Act and Assert
    assertEquals(0, (new PrunedAdjacencyMaps()).size());
  }

  /**
   * Method under test: {@link AdjacencyMaps#size()}
   */
  @Test
  void testSize2() {
    // Arrange
    AdjacencyMaps adjacencyMaps = mock(AdjacencyMaps.class);
    when(adjacencyMaps.size()).thenReturn(3);

    // Act
    adjacencyMaps.size();

    // Assert
    verify(adjacencyMaps).size();
  }

  /**
   * Method under test: {@link AdjacencyMaps#empty()}
   */
  @Test
  void testEmpty() {
    // Arrange, Act and Assert
    assertTrue((new PrunedAdjacencyMaps()).empty());
  }

  /**
   * Method under test: {@link AdjacencyMaps#empty()}
   */
  @Test
  void testEmpty2() {
    // Arrange
    AdjacencyMaps adjacencyMaps = mock(AdjacencyMaps.class);
    when(adjacencyMaps.empty()).thenReturn(true);

    // Act
    adjacencyMaps.empty();

    // Assert
    verify(adjacencyMaps).empty();
  }

  /**
   * Method under test: {@link AdjacencyMaps#empty()}
   */
  @Test
  void testEmpty3() {
    // Arrange
    AdjacencyMaps adjacencyMaps = mock(AdjacencyMaps.class);
    when(adjacencyMaps.empty()).thenReturn(false);

    // Act
    adjacencyMaps.empty();

    // Assert
    verify(adjacencyMaps).empty();
  }

  /**
   * Method under test: {@link AdjacencyMaps#empty()}
   */
  @Test
  void testEmpty4() {
    // Arrange
    PrunedAdjacencyMaps prunedAdjacencyMaps = new PrunedAdjacencyMaps();
    prunedAdjacencyMaps.add(new AdjacencyMap());

    // Act and Assert
    assertFalse(prunedAdjacencyMaps.empty());
  }

  /**
   * Method under test: {@link AdjacencyMaps#prettyPrint()}
   */
  @Test
  void testPrettyPrint() {
    // Arrange
    AdjacencyMaps adjacencyMaps = mock(AdjacencyMaps.class);
    when(adjacencyMaps.prettyPrint()).thenReturn("Pretty Print");

    // Act
    adjacencyMaps.prettyPrint();

    // Assert
    verify(adjacencyMaps).prettyPrint();
  }

  /**
   * Method under test: {@link AdjacencyMaps#iterator()}
   */
  @Test
  void testIterator() {
    // Arrange, Act and Assert
    assertFalse((new PrunedAdjacencyMaps()).iterator().hasNext());
  }

  /**
   * Method under test: {@link AdjacencyMaps#iterator()}
   */
  @Test
  void testIterator2() {
    // Arrange
    AdjacencyMaps adjacencyMaps = mock(AdjacencyMaps.class);

    ArrayList<AdjacencyMap> adjacencyMapList = new ArrayList<>();
    when(adjacencyMaps.iterator()).thenReturn(adjacencyMapList.iterator());

    // Act
    adjacencyMaps.iterator();

    // Assert
    verify(adjacencyMaps).iterator();
  }
}
