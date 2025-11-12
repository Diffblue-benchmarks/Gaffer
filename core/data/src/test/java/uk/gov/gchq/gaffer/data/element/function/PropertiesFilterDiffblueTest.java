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
import java.util.function.BiFunction;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.data.element.Properties;
import uk.gov.gchq.koryphe.ValidationResult;
import uk.gov.gchq.koryphe.tuple.predicate.TupleAdaptedPredicate;

class PropertiesFilterDiffblueTest {
  /**
   * Method under test: {@link PropertiesFilter.Builder#build()}
   */
  @Test
  void testBuilderBuild() {
    // Arrange, Act and Assert
    assertTrue((new PropertiesFilter.Builder()).build().getComponents().isEmpty());
  }

  /**
   * Method under test: {@link PropertiesFilter.Builder#Builder()}
   */
  @Test
  void testBuilderNewBuilder() {
    // Arrange, Act and Assert
    assertTrue((new PropertiesFilter.Builder()).build().getComponents().isEmpty());
  }

  /**
   * Method under test: {@link PropertiesFilter#test(Properties)}
   */
  @Test
  void testTest() {
    // Arrange
    PropertiesFilter propertiesFilter = new PropertiesFilter();

    // Act and Assert
    assertTrue(propertiesFilter.test(new Properties()));
  }

  /**
   * Method under test: {@link PropertiesFilter#test(Properties)}
   */
  @Test
  void testTest2() {
    // Arrange
    PropertiesFilter propertiesFilter = new PropertiesFilter();

    Properties properties = new Properties();
    properties.computeIfPresent("foo", mock(BiFunction.class));

    // Act and Assert
    assertTrue(propertiesFilter.test(properties));
  }

  /**
   * Method under test:
   * {@link PropertiesFilter#testWithValidationResult(Properties)}
   */
  @Test
  void testTestWithValidationResult() {
    // Arrange
    PropertiesFilter propertiesFilter = new PropertiesFilter();

    // Act
    ValidationResult actualTestWithValidationResultResult = propertiesFilter.testWithValidationResult(new Properties());

    // Assert
    assertEquals("Validation errors: \n", actualTestWithValidationResultResult.getErrorString());
    assertTrue(actualTestWithValidationResultResult.getErrors().isEmpty());
    assertTrue(actualTestWithValidationResultResult.isValid());
  }

  /**
   * Method under test:
   * {@link PropertiesFilter#testWithValidationResult(Properties)}
   */
  @Test
  void testTestWithValidationResult2() {
    // Arrange
    PropertiesFilter propertiesFilter = new PropertiesFilter();

    Properties properties = new Properties();
    properties.computeIfPresent("foo", mock(BiFunction.class));

    // Act
    ValidationResult actualTestWithValidationResultResult = propertiesFilter.testWithValidationResult(properties);

    // Assert
    assertEquals("Validation errors: \n", actualTestWithValidationResultResult.getErrorString());
    assertTrue(actualTestWithValidationResultResult.getErrors().isEmpty());
    assertTrue(actualTestWithValidationResultResult.isValid());
  }

  /**
   * Method under test:
   * {@link PropertiesFilter#testWithValidationResult(Properties)}
   */
  @Test
  void testTestWithValidationResult3() {
    // Arrange
    ArrayList<TupleAdaptedPredicate<String, ?>> components = new ArrayList<>();
    components.add(new TupleAdaptedPredicate<>());

    PropertiesFilter propertiesFilter = new PropertiesFilter();
    propertiesFilter.setComponents(components);

    // Act
    ValidationResult actualTestWithValidationResultResult = propertiesFilter.testWithValidationResult(new Properties());

    // Assert
    assertEquals("Validation errors: \n", actualTestWithValidationResultResult.getErrorString());
    assertTrue(actualTestWithValidationResultResult.getErrors().isEmpty());
    assertTrue(actualTestWithValidationResultResult.isValid());
  }

  /**
   * Method under test:
   * {@link PropertiesFilter#testWithValidationResult(Properties)}
   */
  @Test
  void testTestWithValidationResult4() {
    // Arrange
    ArrayList<TupleAdaptedPredicate<String, ?>> components = new ArrayList<>();
    components.add(new TupleAdaptedPredicate<>());
    components.add(new TupleAdaptedPredicate<>());

    PropertiesFilter propertiesFilter = new PropertiesFilter();
    propertiesFilter.setComponents(components);

    // Act
    ValidationResult actualTestWithValidationResultResult = propertiesFilter.testWithValidationResult(new Properties());

    // Assert
    assertEquals("Validation errors: \n", actualTestWithValidationResultResult.getErrorString());
    assertTrue(actualTestWithValidationResultResult.getErrors().isEmpty());
    assertTrue(actualTestWithValidationResultResult.isValid());
  }

  /**
   * Method under test: {@link PropertiesFilter#getComponents()}
   */
  @Test
  void testGetComponents() {
    // Arrange, Act and Assert
    assertTrue((new PropertiesFilter()).getComponents().isEmpty());
  }

  /**
   * Method under test: {@link PropertiesFilter#getComponents()}
   */
  @Test
  void testGetComponents2() {
    // Arrange
    Properties properties = new Properties();
    properties.computeIfPresent("foo", mock(BiFunction.class));

    PropertiesFilter propertiesFilter = new PropertiesFilter();
    propertiesFilter.test(properties);

    // Act and Assert
    assertTrue(propertiesFilter.getComponents().isEmpty());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link PropertiesFilter#equals(Object)}
   *   <li>{@link PropertiesFilter#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    PropertiesFilter propertiesFilter = new PropertiesFilter();
    PropertiesFilter propertiesFilter2 = new PropertiesFilter();

    // Act and Assert
    assertEquals(propertiesFilter, propertiesFilter2);
    int expectedHashCodeResult = propertiesFilter.hashCode();
    assertEquals(expectedHashCodeResult, propertiesFilter2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link PropertiesFilter#equals(Object)}
   *   <li>{@link PropertiesFilter#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    PropertiesFilter propertiesFilter = new PropertiesFilter();

    // Act and Assert
    assertEquals(propertiesFilter, propertiesFilter);
    int expectedHashCodeResult = propertiesFilter.hashCode();
    assertEquals(expectedHashCodeResult, propertiesFilter.hashCode());
  }

  /**
   * Method under test: {@link PropertiesFilter#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    PropertiesFilter propertiesFilter = new PropertiesFilter();

    // Act and Assert
    assertNotEquals(propertiesFilter, new ElementAggregator());
  }

  /**
   * Method under test: {@link PropertiesFilter#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange, Act and Assert
    assertNotEquals(new PropertiesFilter(), mock(ElementAggregator.class));
  }

  /**
   * Method under test: {@link PropertiesFilter#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new PropertiesFilter(), null);
  }

  /**
   * Method under test: {@link PropertiesFilter#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new PropertiesFilter(), "Different type to PropertiesFilter");
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link PropertiesFilter}
   */
  @Test
  void testNewPropertiesFilter() {
    // Arrange, Act and Assert
    assertTrue((new PropertiesFilter()).getComponents().isEmpty());
  }
}
