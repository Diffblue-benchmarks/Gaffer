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
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.function.Predicate;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import uk.gov.gchq.gaffer.data.element.Edge;
import uk.gov.gchq.gaffer.data.element.Element;
import uk.gov.gchq.gaffer.data.element.function.ElementFilter.Builder;
import uk.gov.gchq.koryphe.ValidationResult;
import uk.gov.gchq.koryphe.tuple.predicate.TupleAdaptedPredicate;

class ElementFilterDiffblueTest {
  /**
   * Test Builder {@link Builder#build()}.
   *
   * <p>Method under test: {@link Builder#build()}
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ElementFilter Builder.build()"})
  void testBuilderBuild() {
    // Arrange, Act and Assert
    assertTrue(new Builder().build().getComponents().isEmpty());
  }

  /**
   * Test Builder {@link Builder#Builder()}.
   *
   * <p>Method under test: {@link Builder#Builder()}
   */
  @Test
  @DisplayName("Test Builder new Builder()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Builder.<init>()"})
  void testBuilderNewBuilder() {
    // Arrange, Act and Assert
    assertTrue(new Builder().build().getComponents().isEmpty());
  }

  /**
   * Test {@link ElementFilter#test(Element)} with {@code element}.
   *
   * <p>Method under test: {@link ElementFilter#test(Element)}
   */
  @Test
  @DisplayName("Test test(Element) with 'element'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ElementFilter.test(Element)"})
  void testTestWithElement() {
    // Arrange
    ElementFilter elementFilter = new ElementFilter();

    // Act
    boolean actualTestResult = elementFilter.test(new Edge("Group"));

    // Assert
    assertTrue(actualTestResult);
  }

  /**
   * Test {@link ElementFilter#testWithValidationResult(Element)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link
   *       TupleAdaptedPredicate#TupleAdaptedPredicate()}.
   * </ul>
   *
   * <p>Method under test: {@link ElementFilter#testWithValidationResult(Element)}
   */
  @Test
  @DisplayName(
      "Test testWithValidationResult(Element); given ArrayList() add TupleAdaptedPredicate()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ValidationResult ElementFilter.testWithValidationResult(Element)"})
  void testTestWithValidationResult_givenArrayListAddTupleAdaptedPredicate() {
    // Arrange
    ArrayList<TupleAdaptedPredicate<String, ?>> components = new ArrayList<>();
    components.add(new TupleAdaptedPredicate<>());

    ElementFilter elementFilter = new ElementFilter();
    elementFilter.setComponents(components);

    // Act
    ValidationResult actualTestWithValidationResultResult =
        elementFilter.testWithValidationResult(new Edge("Group"));

    // Assert
    assertEquals("Validation errors: \n", actualTestWithValidationResultResult.getErrorString());
    assertTrue(actualTestWithValidationResultResult.getErrors().isEmpty());
    assertTrue(actualTestWithValidationResultResult.isValid());
  }

  /**
   * Test {@link ElementFilter#testWithValidationResult(Element)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link
   *       TupleAdaptedPredicate#TupleAdaptedPredicate()}.
   * </ul>
   *
   * <p>Method under test: {@link ElementFilter#testWithValidationResult(Element)}
   */
  @Test
  @DisplayName(
      "Test testWithValidationResult(Element); given ArrayList() add TupleAdaptedPredicate()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ValidationResult ElementFilter.testWithValidationResult(Element)"})
  void testTestWithValidationResult_givenArrayListAddTupleAdaptedPredicate2() {
    // Arrange
    ArrayList<TupleAdaptedPredicate<String, ?>> components = new ArrayList<>();
    components.add(new TupleAdaptedPredicate<>());
    components.add(new TupleAdaptedPredicate<>());

    ElementFilter elementFilter = new ElementFilter();
    elementFilter.setComponents(components);

    // Act
    ValidationResult actualTestWithValidationResultResult =
        elementFilter.testWithValidationResult(new Edge("Group"));

    // Assert
    assertEquals("Validation errors: \n", actualTestWithValidationResultResult.getErrorString());
    assertTrue(actualTestWithValidationResultResult.getErrors().isEmpty());
    assertTrue(actualTestWithValidationResultResult.isValid());
  }

  /**
   * Test {@link ElementFilter#testWithValidationResult(Element)}.
   *
   * <ul>
   *   <li>Given {@link ElementFilter} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link ElementFilter#testWithValidationResult(Element)}
   */
  @Test
  @DisplayName("Test testWithValidationResult(Element); given ElementFilter (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ValidationResult ElementFilter.testWithValidationResult(Element)"})
  void testTestWithValidationResult_givenElementFilter() {
    // Arrange
    ElementFilter elementFilter = new ElementFilter();

    // Act
    ValidationResult actualTestWithValidationResultResult =
        elementFilter.testWithValidationResult(new Edge("Group"));

    // Assert
    assertEquals("Validation errors: \n", actualTestWithValidationResultResult.getErrorString());
    assertTrue(actualTestWithValidationResultResult.getErrors().isEmpty());
    assertTrue(actualTestWithValidationResultResult.isValid());
  }

  /**
   * Test {@link ElementFilter#testWithValidationResult(Element)}.
   *
   * <ul>
   *   <li>Given {@link Predicate} {@link Predicate#test(Object)} return {@code true}.
   *   <li>Then calls {@link Predicate#test(Object)}.
   * </ul>
   *
   * <p>Method under test: {@link ElementFilter#testWithValidationResult(Element)}
   */
  @Test
  @DisplayName(
      "Test testWithValidationResult(Element); given Predicate test(Object) return 'true'; then calls test(Object)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ValidationResult ElementFilter.testWithValidationResult(Element)"})
  void testTestWithValidationResult_givenPredicateTestReturnTrue_thenCallsTest() {
    // Arrange
    Predicate<Object> predicate = mock(Predicate.class);
    when(predicate.test(Mockito.<Object>any())).thenReturn(true);
    String[] selection = new String[] {"Selection"};

    TupleAdaptedPredicate<String, ?> tupleAdaptedPredicate =
        new TupleAdaptedPredicate<>(predicate, selection);

    ArrayList<TupleAdaptedPredicate<String, ?>> components = new ArrayList<>();
    components.add(tupleAdaptedPredicate);

    ElementFilter elementFilter = new ElementFilter();
    elementFilter.setComponents(components);

    // Act
    ValidationResult actualTestWithValidationResultResult =
        elementFilter.testWithValidationResult(new Edge("Group"));

    // Assert
    verify(predicate).test(isNull());
    assertEquals("Validation errors: \n", actualTestWithValidationResultResult.getErrorString());
    assertTrue(actualTestWithValidationResultResult.getErrors().isEmpty());
    assertTrue(actualTestWithValidationResultResult.isValid());
  }

  /**
   * Test {@link ElementFilter#getComponents()}.
   *
   * <p>Method under test: {@link ElementFilter#getComponents()}
   */
  @Test
  @DisplayName("Test getComponents()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.List ElementFilter.getComponents()"})
  void testGetComponents() {
    // Arrange, Act and Assert
    assertTrue(new ElementFilter().getComponents().isEmpty());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ElementFilter#lock()}
   *   <li>{@link ElementFilter#toString()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ElementFilter.lock()", "String ElementFilter.toString()"})
  void testGettersAndSetters() {
    // Arrange
    ElementFilter elementFilter = new Builder().build();

    // Act
    elementFilter.lock();

    // Assert
    assertEquals("ElementFilter[elementTuple=ElementTuple[]]", elementFilter.toString());
  }

  /**
   * Test {@link ElementFilter#equals(Object)}, and {@link ElementFilter#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ElementFilter#equals(Object)}
   *   <li>{@link ElementFilter#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ElementFilter.equals(Object)", "int ElementFilter.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ElementFilter elementFilter = new Builder().build();
    ElementFilter elementFilter2 = new Builder().build();

    // Act and Assert
    assertEquals(elementFilter, elementFilter2);
    assertEquals(elementFilter.hashCode(), elementFilter2.hashCode());
  }

  /**
   * Test {@link ElementFilter#equals(Object)}, and {@link ElementFilter#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ElementFilter#equals(Object)}
   *   <li>{@link ElementFilter#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ElementFilter.equals(Object)", "int ElementFilter.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ElementFilter elementFilter = new Builder().build();

    // Act and Assert
    assertEquals(elementFilter, elementFilter);
    int expectedHashCodeResult = elementFilter.hashCode();
    assertEquals(expectedHashCodeResult, elementFilter.hashCode());
  }

  /**
   * Test {@link ElementFilter#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ElementFilter#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ElementFilter.equals(Object)", "int ElementFilter.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new Builder().build(), null);
  }

  /**
   * Test {@link ElementFilter#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ElementFilter#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ElementFilter.equals(Object)", "int ElementFilter.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new Builder().build(), "Different type to ElementFilter");
  }

  /**
   * Test new {@link ElementFilter} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link ElementFilter}
   */
  @Test
  @DisplayName("Test new ElementFilter (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ElementFilter.<init>()"})
  void testNewElementFilter() {
    // Arrange, Act and Assert
    assertTrue(new ElementFilter().getComponents().isEmpty());
  }
}
