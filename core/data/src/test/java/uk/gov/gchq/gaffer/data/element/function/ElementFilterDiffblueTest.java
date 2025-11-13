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
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.data.element.Edge;
import uk.gov.gchq.gaffer.data.element.Element;
import uk.gov.gchq.gaffer.data.element.function.ElementFilter.Builder;
import uk.gov.gchq.koryphe.ValidationResult;

class ElementFilterDiffblueTest {
  /**
   * Test Builder {@link Builder#build()}.
   * <p>
   * Method under test: {@link Builder#build()}
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ElementFilter Builder.build()"})
  void testBuilderBuild() {
    // Arrange, Act and Assert
    assertTrue((new Builder()).build().getComponents().isEmpty());
  }

  /**
   * Test Builder {@link Builder#Builder()}.
   * <p>
   * Method under test: {@link Builder#Builder()}
   */
  @Test
  @DisplayName("Test Builder new Builder()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Builder.<init>()"})
  void testBuilderNewBuilder() {
    // Arrange, Act and Assert
    assertTrue((new Builder()).build().getComponents().isEmpty());
  }

  /**
   * Test {@link ElementFilter#test(Element)} with {@code element}.
   * <p>
   * Method under test: {@link ElementFilter#test(Element)}
   */
  @Test
  @DisplayName("Test test(Element) with 'element'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ElementFilter.test(Element)"})
  void testTestWithElement() {
    // Arrange
    ElementFilter elementFilter = new ElementFilter();

    // Act and Assert
    assertTrue(elementFilter.test(new Edge("Group")));
  }

  /**
   * Test {@link ElementFilter#testWithValidationResult(Element)}.
   * <p>
   * Method under test: {@link ElementFilter#testWithValidationResult(Element)}
   */
  @Test
  @DisplayName("Test testWithValidationResult(Element)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ValidationResult ElementFilter.testWithValidationResult(Element)"})
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
   * Test {@link ElementFilter#getComponents()}.
   * <p>
   * Method under test: {@link ElementFilter#getComponents()}
   */
  @Test
  @DisplayName("Test getComponents()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.util.List ElementFilter.getComponents()"})
  void testGetComponents() {
    // Arrange, Act and Assert
    assertTrue((new ElementFilter()).getComponents().isEmpty());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ElementFilter#lock()}
   *   <li>{@link ElementFilter#toString()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void ElementFilter.lock()", "java.lang.String ElementFilter.toString()"})
  void testGettersAndSetters() {
    // Arrange
    ElementFilter buildResult = (new Builder()).build();

    // Act
    buildResult.lock();

    // Assert
    assertEquals("ElementFilter[elementTuple=ElementTuple[]]", buildResult.toString());
  }

  /**
   * Test {@link ElementFilter#equals(Object)}, and {@link ElementFilter#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ElementFilter#equals(Object)}
   *   <li>{@link ElementFilter#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ElementFilter.equals(Object)", "int ElementFilter.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ElementFilter buildResult = (new Builder()).build();
    ElementFilter buildResult2 = (new Builder()).build();

    // Act and Assert
    assertEquals(buildResult, buildResult2);
    int expectedHashCodeResult = buildResult.hashCode();
    assertEquals(expectedHashCodeResult, buildResult2.hashCode());
  }

  /**
   * Test {@link ElementFilter#equals(Object)}, and {@link ElementFilter#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ElementFilter#equals(Object)}
   *   <li>{@link ElementFilter#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ElementFilter.equals(Object)", "int ElementFilter.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ElementFilter buildResult = (new Builder()).build();

    // Act and Assert
    assertEquals(buildResult, buildResult);
    int expectedHashCodeResult = buildResult.hashCode();
    assertEquals(expectedHashCodeResult, buildResult.hashCode());
  }

  /**
   * Test {@link ElementFilter#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ElementFilter#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ElementFilter.equals(Object)", "int ElementFilter.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    ElementFilter buildResult = (new Builder()).build();

    // Act and Assert
    assertNotEquals(buildResult, null);
  }

  /**
   * Test {@link ElementFilter#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ElementFilter#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ElementFilter.equals(Object)", "int ElementFilter.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    ElementFilter buildResult = (new Builder()).build();

    // Act and Assert
    assertNotEquals(buildResult, "Different type to ElementFilter");
  }

  /**
   * Test new {@link ElementFilter} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of {@link ElementFilter}
   */
  @Test
  @DisplayName("Test new ElementFilter (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void ElementFilter.<init>()"})
  void testNewElementFilter() {
    // Arrange, Act and Assert
    assertTrue((new ElementFilter()).getComponents().isEmpty());
  }
}
