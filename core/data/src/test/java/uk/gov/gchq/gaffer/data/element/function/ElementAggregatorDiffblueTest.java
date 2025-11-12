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
import java.util.function.BiFunction;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.data.element.Edge;
import uk.gov.gchq.gaffer.data.element.Element;
import uk.gov.gchq.gaffer.data.element.ElementValueLoader;
import uk.gov.gchq.gaffer.data.element.LazyEdge;
import uk.gov.gchq.gaffer.data.element.Properties;

class ElementAggregatorDiffblueTest {
  /**
   * Method under test: {@link ElementAggregator#apply(Element, Element)}
   */
  @Test
  void testApply() {
    // Arrange
    ElementAggregator elementAggregator = new ElementAggregator();
    Edge state = new Edge("Group");

    // Act and Assert
    assertSame(state, elementAggregator.apply(state, new Edge("Group")));
  }

  /**
   * Method under test: {@link ElementAggregator#apply(Element, Element)}
   */
  @Test
  void testApply2() {
    // Arrange
    ElementAggregator elementAggregator = new ElementAggregator();
    Edge element = new Edge("Group");

    // Act and Assert
    assertSame(element, elementAggregator.apply(null, element));
  }

  /**
   * Method under test: {@link ElementAggregator#apply(Element, Element)}
   */
  @Test
  void testApply3() {
    // Arrange
    ElementAggregator elementAggregator = new ElementAggregator();
    Edge state = new Edge("Group");

    // Act and Assert
    assertSame(state, elementAggregator.apply(state, new Edge("Group")));
  }

  /**
   * Method under test: {@link ElementAggregator#apply(Element, Element)}
   */
  @Test
  void testApply4() {
    // Arrange
    ElementAggregator elementAggregator = new ElementAggregator();
    LazyEdge state = new LazyEdge(new Edge("Group"), mock(ElementValueLoader.class));

    // Act and Assert
    assertSame(state, elementAggregator.apply(state, new Edge("Group")));
  }

  /**
   * Method under test: {@link ElementAggregator#apply(Properties, Properties)}
   */
  @Test
  void testApply5() {
    // Arrange
    ElementAggregator elementAggregator = new ElementAggregator();
    Properties state = new Properties();

    // Act
    Properties actualApplyResult = elementAggregator.apply(state, new Properties());

    // Assert
    assertTrue(actualApplyResult.isEmpty());
    assertSame(state, actualApplyResult);
  }

  /**
   * Method under test: {@link ElementAggregator#apply(Properties, Properties)}
   */
  @Test
  void testApply6() {
    // Arrange
    ElementAggregator elementAggregator = new ElementAggregator();
    Properties properties = new Properties();

    // Act
    Properties actualApplyResult = elementAggregator.apply(null, properties);

    // Assert
    assertTrue(actualApplyResult.isEmpty());
    assertSame(properties, actualApplyResult);
  }

  /**
   * Method under test: {@link ElementAggregator#apply(Properties, Properties)}
   */
  @Test
  void testApply7() {
    // Arrange
    ElementAggregator elementAggregator = new ElementAggregator();

    Properties state = new Properties();
    state.computeIfPresent("foo", mock(BiFunction.class));

    // Act
    Properties actualApplyResult = elementAggregator.apply(state, new Properties());

    // Assert
    assertTrue(actualApplyResult.isEmpty());
    assertSame(state, actualApplyResult);
  }

  /**
   * Method under test: {@link ElementAggregator.Builder#build()}
   */
  @Test
  void testBuilderBuild() {
    // Arrange, Act and Assert
    assertTrue((new ElementAggregator.Builder()).build().getComponents().isEmpty());
  }

  /**
   * Method under test: {@link ElementAggregator.Builder#Builder()}
   */
  @Test
  void testBuilderNewBuilder() {
    // Arrange, Act and Assert
    assertTrue((new ElementAggregator.Builder()).build().getComponents().isEmpty());
  }

  /**
   * Method under test: {@link ElementAggregator#getComponents()}
   */
  @Test
  void testGetComponents() {
    // Arrange, Act and Assert
    assertTrue((new ElementAggregator()).getComponents().isEmpty());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ElementAggregator#equals(Object)}
   *   <li>{@link ElementAggregator#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ElementAggregator elementAggregator = new ElementAggregator();
    ElementAggregator elementAggregator2 = new ElementAggregator();

    // Act and Assert
    assertEquals(elementAggregator, elementAggregator2);
    int expectedHashCodeResult = elementAggregator.hashCode();
    assertEquals(expectedHashCodeResult, elementAggregator2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ElementAggregator#equals(Object)}
   *   <li>{@link ElementAggregator#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ElementAggregator elementAggregator = new ElementAggregator();

    // Act and Assert
    assertEquals(elementAggregator, elementAggregator);
    int expectedHashCodeResult = elementAggregator.hashCode();
    assertEquals(expectedHashCodeResult, elementAggregator.hashCode());
  }

  /**
   * Method under test: {@link ElementAggregator#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ElementAggregator elementAggregator = new ElementAggregator();

    // Act and Assert
    assertNotEquals(elementAggregator, new PropertiesTuple());
  }

  /**
   * Method under test: {@link ElementAggregator#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange, Act and Assert
    assertNotEquals(new ElementAggregator(), mock(PropertiesTuple.class));
  }

  /**
   * Method under test: {@link ElementAggregator#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new ElementAggregator(), null);
  }

  /**
   * Method under test: {@link ElementAggregator#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new ElementAggregator(), "Different type to ElementAggregator");
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link ElementAggregator}
   */
  @Test
  void testNewElementAggregator() {
    // Arrange, Act and Assert
    assertTrue((new ElementAggregator()).getComponents().isEmpty());
  }
}
