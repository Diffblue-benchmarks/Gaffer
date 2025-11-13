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
import uk.gov.gchq.gaffer.data.element.Properties;
import uk.gov.gchq.gaffer.data.element.function.ElementAggregator.Builder;

class ElementAggregatorDiffblueTest {
  /**
   * Test {@link ElementAggregator#apply(Element, Element)} with {@code state}, {@code element}.
   * <ul>
   *   <li>When {@link Edge#Edge(String)} with {@code Group}.</li>
   *   <li>Then return {@link Edge#Edge(String)} with {@code Group}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ElementAggregator#apply(Element, Element)}
   */
  @Test
  @DisplayName("Test apply(Element, Element) with 'state', 'element'; when Edge(String) with 'Group'; then return Edge(String) with 'Group'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Element ElementAggregator.apply(Element, Element)"})
  void testApplyWithStateElement_whenEdgeWithGroup_thenReturnEdgeWithGroup() {
    // Arrange
    ElementAggregator elementAggregator = new ElementAggregator();
    Edge state = new Edge("Group");

    // Act and Assert
    assertSame(state, elementAggregator.apply(state, new Edge("Group")));
  }

  /**
   * Test {@link ElementAggregator#apply(Element, Element)} with {@code state}, {@code element}.
   * <ul>
   *   <li>When {@link Edge#Edge(String)} with {@code Group}.</li>
   *   <li>Then return {@link Edge#Edge(String)} with {@code Group}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ElementAggregator#apply(Element, Element)}
   */
  @Test
  @DisplayName("Test apply(Element, Element) with 'state', 'element'; when Edge(String) with 'Group'; then return Edge(String) with 'Group'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Element ElementAggregator.apply(Element, Element)"})
  void testApplyWithStateElement_whenEdgeWithGroup_thenReturnEdgeWithGroup2() {
    // Arrange
    ElementAggregator elementAggregator = new ElementAggregator();
    Edge state = new Edge("Group");

    // Act and Assert
    assertSame(state, elementAggregator.apply(state, new Edge("Group")));
  }

  /**
   * Test {@link ElementAggregator#apply(Element, Element)} with {@code state}, {@code element}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@link Edge#Edge(String)} with {@code Group}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ElementAggregator#apply(Element, Element)}
   */
  @Test
  @DisplayName("Test apply(Element, Element) with 'state', 'element'; when 'null'; then return Edge(String) with 'Group'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Element ElementAggregator.apply(Element, Element)"})
  void testApplyWithStateElement_whenNull_thenReturnEdgeWithGroup() {
    // Arrange
    ElementAggregator elementAggregator = new ElementAggregator();
    Edge element = new Edge("Group");

    // Act and Assert
    assertSame(element, elementAggregator.apply(null, element));
  }

  /**
   * Test {@link ElementAggregator#apply(Properties, Properties)} with {@code state}, {@code properties}.
   * <ul>
   *   <li>Given {@link ElementAggregator} (default constructor).</li>
   *   <li>Then return {@link Properties#Properties()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ElementAggregator#apply(Properties, Properties)}
   */
  @Test
  @DisplayName("Test apply(Properties, Properties) with 'state', 'properties'; given ElementAggregator (default constructor); then return Properties()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Properties ElementAggregator.apply(Properties, Properties)"})
  void testApplyWithStateProperties_givenElementAggregator_thenReturnProperties() {
    // Arrange
    ElementAggregator elementAggregator = new ElementAggregator();
    Properties state = new Properties();

    // Act and Assert
    assertSame(state, elementAggregator.apply(state, new Properties()));
  }

  /**
   * Test {@link ElementAggregator#apply(Properties, Properties)} with {@code state}, {@code properties}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@link Properties#Properties()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ElementAggregator#apply(Properties, Properties)}
   */
  @Test
  @DisplayName("Test apply(Properties, Properties) with 'state', 'properties'; when 'null'; then return Properties()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Properties ElementAggregator.apply(Properties, Properties)"})
  void testApplyWithStateProperties_whenNull_thenReturnProperties() {
    // Arrange
    ElementAggregator elementAggregator = new ElementAggregator();
    Properties properties = new Properties();

    // Act and Assert
    assertSame(properties, elementAggregator.apply(null, properties));
  }

  /**
   * Test Builder {@link Builder#build()}.
   * <p>
   * Method under test: {@link Builder#build()}
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ElementAggregator Builder.build()"})
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
   * Test {@link ElementAggregator#getComponents()}.
   * <p>
   * Method under test: {@link ElementAggregator#getComponents()}
   */
  @Test
  @DisplayName("Test getComponents()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.util.List ElementAggregator.getComponents()"})
  void testGetComponents() {
    // Arrange, Act and Assert
    assertTrue((new ElementAggregator()).getComponents().isEmpty());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ElementAggregator#lock()}
   *   <li>{@link ElementAggregator#toString()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void ElementAggregator.lock()", "java.lang.String ElementAggregator.toString()"})
  void testGettersAndSetters() {
    // Arrange
    ElementAggregator buildResult = (new Builder()).build();

    // Act
    buildResult.lock();

    // Assert
    assertEquals("ElementAggregator[stateTuple=PropertiesTuple[],propertiesTuple=PropertiesTuple[]]",
        buildResult.toString());
  }

  /**
   * Test {@link ElementAggregator#equals(Object)}, and {@link ElementAggregator#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ElementAggregator#equals(Object)}
   *   <li>{@link ElementAggregator#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ElementAggregator.equals(Object)", "int ElementAggregator.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ElementAggregator buildResult = (new Builder()).build();
    ElementAggregator buildResult2 = (new Builder()).build();

    // Act and Assert
    assertEquals(buildResult, buildResult2);
    int expectedHashCodeResult = buildResult.hashCode();
    assertEquals(expectedHashCodeResult, buildResult2.hashCode());
  }

  /**
   * Test {@link ElementAggregator#equals(Object)}, and {@link ElementAggregator#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ElementAggregator#equals(Object)}
   *   <li>{@link ElementAggregator#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ElementAggregator.equals(Object)", "int ElementAggregator.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ElementAggregator buildResult = (new Builder()).build();

    // Act and Assert
    assertEquals(buildResult, buildResult);
    int expectedHashCodeResult = buildResult.hashCode();
    assertEquals(expectedHashCodeResult, buildResult.hashCode());
  }

  /**
   * Test {@link ElementAggregator#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ElementAggregator#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ElementAggregator.equals(Object)", "int ElementAggregator.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    ElementAggregator buildResult = (new Builder()).build();

    // Act and Assert
    assertNotEquals(buildResult, null);
  }

  /**
   * Test {@link ElementAggregator#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ElementAggregator#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ElementAggregator.equals(Object)", "int ElementAggregator.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    ElementAggregator buildResult = (new Builder()).build();

    // Act and Assert
    assertNotEquals(buildResult, "Different type to ElementAggregator");
  }

  /**
   * Test new {@link ElementAggregator} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of {@link ElementAggregator}
   */
  @Test
  @DisplayName("Test new ElementAggregator (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void ElementAggregator.<init>()"})
  void testNewElementAggregator() {
    // Arrange, Act and Assert
    assertTrue((new ElementAggregator()).getComponents().isEmpty());
  }
}
