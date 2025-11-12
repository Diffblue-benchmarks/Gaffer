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
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.data.element.Edge;
import uk.gov.gchq.gaffer.data.element.Element;
import uk.gov.gchq.gaffer.data.element.ElementValueLoader;
import uk.gov.gchq.gaffer.data.element.LazyEdge;

class ElementTransformerDiffblueTest {
  /**
   * Method under test: {@link ElementTransformer#apply(Element)}
   */
  @Test
  void testApply() {
    // Arrange
    ElementTransformer elementTransformer = new ElementTransformer();
    Edge element = new Edge("Group");

    // Act and Assert
    assertSame(element, elementTransformer.apply(element));
  }

  /**
   * Method under test: {@link ElementTransformer#apply(Element)}
   */
  @Test
  void testApply2() {
    // Arrange
    ElementTransformer elementTransformer = new ElementTransformer();
    LazyEdge element = new LazyEdge(new Edge("Group"), mock(ElementValueLoader.class));

    // Act and Assert
    assertSame(element, elementTransformer.apply(element));
  }

  /**
   * Method under test: {@link ElementTransformer.Builder#build()}
   */
  @Test
  void testBuilderBuild() {
    // Arrange, Act and Assert
    assertTrue((new ElementTransformer.Builder()).build().getComponents().isEmpty());
  }

  /**
   * Method under test: {@link ElementTransformer.Builder#Builder()}
   */
  @Test
  void testBuilderNewBuilder() {
    // Arrange, Act and Assert
    assertTrue((new ElementTransformer.Builder()).build().getComponents().isEmpty());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ElementTransformer#equals(Object)}
   *   <li>{@link ElementTransformer#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ElementTransformer elementTransformer = new ElementTransformer();
    ElementTransformer elementTransformer2 = new ElementTransformer();

    // Act and Assert
    assertEquals(elementTransformer, elementTransformer2);
    int expectedHashCodeResult = elementTransformer.hashCode();
    assertEquals(expectedHashCodeResult, elementTransformer2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ElementTransformer#equals(Object)}
   *   <li>{@link ElementTransformer#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ElementTransformer elementTransformer = new ElementTransformer();

    // Act and Assert
    assertEquals(elementTransformer, elementTransformer);
    int expectedHashCodeResult = elementTransformer.hashCode();
    assertEquals(expectedHashCodeResult, elementTransformer.hashCode());
  }

  /**
   * Method under test: {@link ElementTransformer#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ElementTransformer elementTransformer = new ElementTransformer();

    // Act and Assert
    assertNotEquals(elementTransformer, new ElementAggregator());
  }

  /**
   * Method under test: {@link ElementTransformer#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange, Act and Assert
    assertNotEquals(new ElementTransformer(), mock(ElementAggregator.class));
  }

  /**
   * Method under test: {@link ElementTransformer#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new ElementTransformer(), null);
  }

  /**
   * Method under test: {@link ElementTransformer#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new ElementTransformer(), "Different type to ElementTransformer");
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link ElementTransformer}
   */
  @Test
  void testNewElementTransformer() {
    // Arrange, Act and Assert
    assertTrue((new ElementTransformer()).getComponents().isEmpty());
  }
}
