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
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.BinaryOperator;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.data.element.Element;
import uk.gov.gchq.koryphe.impl.binaryoperator.First;

class ReduceRelatedElementsDiffblueTest {
  /**
   * Method under test: {@link ReduceRelatedElements#apply(Iterable)}
   */
  @Test
  void testApply() {
    // Arrange
    ReduceRelatedElements reduceRelatedElements = new ReduceRelatedElements();

    // Act
    Iterable<Element> actualApplyResult = reduceRelatedElements.apply(new ArrayList<>());

    // Assert
    assertTrue(actualApplyResult instanceof List);
    assertFalse(actualApplyResult.iterator().hasNext());
    assertTrue(((List<Element>) actualApplyResult).isEmpty());
  }

  /**
   * Method under test: {@link ReduceRelatedElements#apply(Iterable)}
   */
  @Test
  void testApply2() {
    // Arrange
    ReduceRelatedElements reduceRelatedElements = new ReduceRelatedElements();
    reduceRelatedElements.setVisibilityAggregator(mock(BinaryOperator.class));

    // Act
    Iterable<Element> actualApplyResult = reduceRelatedElements.apply(new ArrayList<>());

    // Assert
    assertTrue(actualApplyResult instanceof List);
    assertFalse(actualApplyResult.iterator().hasNext());
    assertTrue(((List<Element>) actualApplyResult).isEmpty());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ReduceRelatedElements#setRelatedVertexGroups(Set)}
   *   <li>{@link ReduceRelatedElements#setVertexAggregator(BinaryOperator)}
   *   <li>{@link ReduceRelatedElements#setVisibilityAggregator(BinaryOperator)}
   *   <li>{@link ReduceRelatedElements#setVisibilityProperty(String)}
   *   <li>{@link ReduceRelatedElements#getRelatedVertexGroups()}
   *   <li>{@link ReduceRelatedElements#getVertexAggregator()}
   *   <li>{@link ReduceRelatedElements#getVisibilityAggregator()}
   *   <li>{@link ReduceRelatedElements#getVisibilityProperty()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange
    ReduceRelatedElements reduceRelatedElements = new ReduceRelatedElements();
    HashSet<String> relatedVertexGroups = new HashSet<>();

    // Act
    reduceRelatedElements.setRelatedVertexGroups(relatedVertexGroups);
    BinaryOperator<Object> vertexAggregator = mock(BinaryOperator.class);
    reduceRelatedElements.setVertexAggregator(vertexAggregator);
    BinaryOperator<Object> visibilityAggregator = mock(BinaryOperator.class);
    reduceRelatedElements.setVisibilityAggregator(visibilityAggregator);
    reduceRelatedElements.setVisibilityProperty("Visibility Property");
    Set<String> actualRelatedVertexGroups = reduceRelatedElements.getRelatedVertexGroups();
    BinaryOperator<Object> actualVertexAggregator = reduceRelatedElements.getVertexAggregator();
    BinaryOperator<Object> actualVisibilityAggregator = reduceRelatedElements.getVisibilityAggregator();

    // Assert that nothing has changed
    assertEquals("Visibility Property", reduceRelatedElements.getVisibilityProperty());
    assertTrue(actualRelatedVertexGroups.isEmpty());
    assertSame(relatedVertexGroups, actualRelatedVertexGroups);
    assertSame(vertexAggregator, actualVertexAggregator);
    assertSame(visibilityAggregator, actualVisibilityAggregator);
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link ReduceRelatedElements}
   */
  @Test
  void testNewReduceRelatedElements() {
    // Arrange and Act
    ReduceRelatedElements actualReduceRelatedElements = new ReduceRelatedElements();

    // Assert
    assertTrue(actualReduceRelatedElements.getVertexAggregator() instanceof First);
    assertNull(actualReduceRelatedElements.getVisibilityProperty());
    assertNull(actualReduceRelatedElements.getRelatedVertexGroups());
    assertNull(actualReduceRelatedElements.getVisibilityAggregator());
  }
}
