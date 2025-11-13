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
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.data.element.Edge;
import uk.gov.gchq.gaffer.data.element.Element;
import uk.gov.gchq.gaffer.data.element.function.ElementTransformer.Builder;

class ElementTransformerDiffblueTest {
  /**
   * Test {@link ElementTransformer#apply(Element)} with {@code element}.
   * <ul>
   *   <li>Given {@link ElementTransformer} (default constructor).</li>
   *   <li>Then return {@link Edge#Edge(String)} with {@code Group}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ElementTransformer#apply(Element)}
   */
  @Test
  @DisplayName("Test apply(Element) with 'element'; given ElementTransformer (default constructor); then return Edge(String) with 'Group'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Element ElementTransformer.apply(Element)"})
  void testApplyWithElement_givenElementTransformer_thenReturnEdgeWithGroup() {
    // Arrange
    ElementTransformer elementTransformer = new ElementTransformer();
    Edge element = new Edge("Group");

    // Act and Assert
    assertSame(element, elementTransformer.apply(element));
  }

  /**
   * Test Builder {@link Builder#build()}.
   * <p>
   * Method under test: {@link Builder#build()}
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ElementTransformer Builder.build()"})
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
   * Test {@link ElementTransformer#equals(Object)}, and {@link ElementTransformer#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ElementTransformer#equals(Object)}
   *   <li>{@link ElementTransformer#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ElementTransformer.equals(Object)", "int ElementTransformer.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ElementTransformer buildResult = (new Builder()).build();
    ElementTransformer buildResult2 = (new Builder()).build();

    // Act and Assert
    assertEquals(buildResult, buildResult2);
    int expectedHashCodeResult = buildResult.hashCode();
    assertEquals(expectedHashCodeResult, buildResult2.hashCode());
  }

  /**
   * Test {@link ElementTransformer#equals(Object)}, and {@link ElementTransformer#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ElementTransformer#equals(Object)}
   *   <li>{@link ElementTransformer#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ElementTransformer.equals(Object)", "int ElementTransformer.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ElementTransformer buildResult = (new Builder()).build();

    // Act and Assert
    assertEquals(buildResult, buildResult);
    int expectedHashCodeResult = buildResult.hashCode();
    assertEquals(expectedHashCodeResult, buildResult.hashCode());
  }

  /**
   * Test {@link ElementTransformer#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ElementTransformer#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ElementTransformer.equals(Object)", "int ElementTransformer.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    ElementTransformer buildResult = (new Builder()).build();

    // Act and Assert
    assertNotEquals(buildResult, null);
  }

  /**
   * Test {@link ElementTransformer#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ElementTransformer#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ElementTransformer.equals(Object)", "int ElementTransformer.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    ElementTransformer buildResult = (new Builder()).build();

    // Act and Assert
    assertNotEquals(buildResult, "Different type to ElementTransformer");
  }

  /**
   * Test new {@link ElementTransformer} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of {@link ElementTransformer}
   */
  @Test
  @DisplayName("Test new ElementTransformer (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void ElementTransformer.<init>()"})
  void testNewElementTransformer() {
    // Arrange, Act and Assert
    assertTrue((new ElementTransformer()).getComponents().isEmpty());
  }

  /**
   * Test {@link ElementTransformer#toString()}.
   * <p>
   * Method under test: {@link ElementTransformer#toString()}
   */
  @Test
  @DisplayName("Test toString()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String ElementTransformer.toString()"})
  void testToString() {
    // Arrange
    ElementTransformer buildResult = (new Builder()).build();

    // Act and Assert
    assertEquals("ElementTransformer[elementTuple=ElementTuple[]]", buildResult.toString());
  }
}
