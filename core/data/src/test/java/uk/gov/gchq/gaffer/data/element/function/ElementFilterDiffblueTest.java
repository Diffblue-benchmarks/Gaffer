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
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.data.element.Edge;
import uk.gov.gchq.gaffer.data.element.Element;
import uk.gov.gchq.gaffer.data.element.ElementValueLoader;
import uk.gov.gchq.gaffer.data.element.LazyEdge;
import uk.gov.gchq.koryphe.ValidationResult;
import uk.gov.gchq.koryphe.tuple.predicate.TupleAdaptedPredicate;

class ElementFilterDiffblueTest {
  /**
   * Method under test: {@link ElementFilter.Builder#build()}
   */
  @Test
  void testBuilderBuild() {
    // Arrange, Act and Assert
    assertTrue((new ElementFilter.Builder()).build().getComponents().isEmpty());
  }

  /**
   * Method under test: {@link ElementFilter.Builder#Builder()}
   */
  @Test
  void testBuilderNewBuilder() {
    // Arrange, Act and Assert
    assertTrue((new ElementFilter.Builder()).build().getComponents().isEmpty());
  }

  /**
   * Method under test: {@link ElementFilter#test(Element)}
   */
  @Test
  void testTest() {
    // Arrange
    ElementFilter elementFilter = new ElementFilter();

    // Act and Assert
    assertTrue(elementFilter.test(new Edge("Group")));
  }

  /**
   * Method under test: {@link ElementFilter#test(Element)}
   */
  @Test
  void testTest2() {
    // Arrange
    ElementFilter elementFilter = new ElementFilter();

    // Act and Assert
    assertTrue(elementFilter.test(new LazyEdge(new Edge("Group"), mock(ElementValueLoader.class))));
  }

  /**
   * Method under test: {@link ElementFilter#testWithValidationResult(Element)}
   */
  @Test
  void testTestWithValidationResult() {
    // Arrange
    ElementFilter elementFilter = new ElementFilter();

    // Act
    ValidationResult actualTestWithValidationResultResult = elementFilter.testWithValidationResult(new Edge("Group"));

    // Assert
    assertEquals("Validation errors: \n", actualTestWithValidationResultResult.getErrorString());
    assertTrue(actualTestWithValidationResultResult.getErrors().isEmpty());
    assertTrue(actualTestWithValidationResultResult.isValid());
  }

  /**
   * Method under test: {@link ElementFilter#testWithValidationResult(Element)}
   */
  @Test
  void testTestWithValidationResult2() {
    // Arrange
    ElementFilter elementFilter = new ElementFilter();

    // Act
    ValidationResult actualTestWithValidationResultResult = elementFilter
        .testWithValidationResult(new LazyEdge(new Edge("Group"), mock(ElementValueLoader.class)));

    // Assert
    assertEquals("Validation errors: \n", actualTestWithValidationResultResult.getErrorString());
    assertTrue(actualTestWithValidationResultResult.getErrors().isEmpty());
    assertTrue(actualTestWithValidationResultResult.isValid());
  }

  /**
   * Method under test: {@link ElementFilter#testWithValidationResult(Element)}
   */
  @Test
  void testTestWithValidationResult3() {
    // Arrange
    ArrayList<TupleAdaptedPredicate<String, ?>> components = new ArrayList<>();
    components.add(new TupleAdaptedPredicate<>());

    ElementFilter elementFilter = new ElementFilter();
    elementFilter.setComponents(components);

    // Act
    ValidationResult actualTestWithValidationResultResult = elementFilter.testWithValidationResult(new Edge("Group"));

    // Assert
    assertEquals("Validation errors: \n", actualTestWithValidationResultResult.getErrorString());
    assertTrue(actualTestWithValidationResultResult.getErrors().isEmpty());
    assertTrue(actualTestWithValidationResultResult.isValid());
  }

  /**
   * Method under test: {@link ElementFilter#testWithValidationResult(Element)}
   */
  @Test
  void testTestWithValidationResult4() {
    // Arrange
    ArrayList<TupleAdaptedPredicate<String, ?>> components = new ArrayList<>();
    components.add(new TupleAdaptedPredicate<>());
    components.add(new TupleAdaptedPredicate<>());

    ElementFilter elementFilter = new ElementFilter();
    elementFilter.setComponents(components);

    // Act
    ValidationResult actualTestWithValidationResultResult = elementFilter.testWithValidationResult(new Edge("Group"));

    // Assert
    assertEquals("Validation errors: \n", actualTestWithValidationResultResult.getErrorString());
    assertTrue(actualTestWithValidationResultResult.getErrors().isEmpty());
    assertTrue(actualTestWithValidationResultResult.isValid());
  }

  /**
   * Method under test: {@link ElementFilter#getComponents()}
   */
  @Test
  void testGetComponents() {
    // Arrange, Act and Assert
    assertTrue((new ElementFilter()).getComponents().isEmpty());
  }

  /**
   * Method under test: {@link ElementFilter#getComponents()}
   */
  @Test
  void testGetComponents2() {
    // Arrange
    ElementFilter elementFilter = new ElementFilter();
    elementFilter.test(new LazyEdge(new Edge("Group"), mock(ElementValueLoader.class)));

    // Act and Assert
    assertTrue(elementFilter.getComponents().isEmpty());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ElementFilter#equals(Object)}
   *   <li>{@link ElementFilter#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ElementFilter elementFilter = new ElementFilter();
    ElementFilter elementFilter2 = new ElementFilter();

    // Act and Assert
    assertEquals(elementFilter, elementFilter2);
    int expectedHashCodeResult = elementFilter.hashCode();
    assertEquals(expectedHashCodeResult, elementFilter2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ElementFilter#equals(Object)}
   *   <li>{@link ElementFilter#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ElementFilter elementFilter = new ElementFilter();

    // Act and Assert
    assertEquals(elementFilter, elementFilter);
    int expectedHashCodeResult = elementFilter.hashCode();
    assertEquals(expectedHashCodeResult, elementFilter.hashCode());
  }

  /**
   * Method under test: {@link ElementFilter#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ElementFilter elementFilter = new ElementFilter();

    // Act and Assert
    assertNotEquals(elementFilter, new ElementAggregator());
  }

  /**
   * Method under test: {@link ElementFilter#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange, Act and Assert
    assertNotEquals(new ElementFilter(), mock(ElementAggregator.class));
  }

  /**
   * Method under test: {@link ElementFilter#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new ElementFilter(), null);
  }

  /**
   * Method under test: {@link ElementFilter#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new ElementFilter(), "Different type to ElementFilter");
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link ElementFilter}
   */
  @Test
  void testNewElementFilter() {
    // Arrange, Act and Assert
    assertTrue((new ElementFilter()).getComponents().isEmpty());
  }
}
