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
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ElementTupleDefinitionDiffblueTest {
  /**
   * Test {@link ElementTupleDefinition#ElementTupleDefinition()}.
   *
   * <p>Method under test: {@link ElementTupleDefinition#ElementTupleDefinition()}
   */
  @Test
  @DisplayName("Test new ElementTupleDefinition()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ElementTupleDefinition.<init>()"})
  void testNewElementTupleDefinition() {
    // Arrange, Act and Assert
    assertTrue(new ElementTupleDefinition().isEmpty());
  }

  /**
   * Test {@link ElementTupleDefinition#ElementTupleDefinition(String)}.
   *
   * <p>Method under test: {@link ElementTupleDefinition#ElementTupleDefinition(String)}
   */
  @Test
  @DisplayName("Test new ElementTupleDefinition(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ElementTupleDefinition.<init>(String)"})
  void testNewElementTupleDefinition2() {
    // Arrange and Act
    ElementTupleDefinition actualElementTupleDefinition = new ElementTupleDefinition("Group");

    // Assert
    assertEquals(1, actualElementTupleDefinition.size());
    assertEquals("Group", actualElementTupleDefinition.get(ElementTupleDefinition.GROUP));
  }

  /**
   * Test {@link ElementTupleDefinition#getGroup()}.
   *
   * <ul>
   *   <li>Given {@link ElementTupleDefinition#ElementTupleDefinition()} {@link
   *       ElementTupleDefinition#GROUP} is {@code foo}.
   *   <li>Then return {@code foo}.
   * </ul>
   *
   * <p>Method under test: {@link ElementTupleDefinition#getGroup()}
   */
  @Test
  @DisplayName("Test getGroup(); given ElementTupleDefinition() GROUP is 'foo'; then return 'foo'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ElementTupleDefinition.getGroup()"})
  void testGetGroup_givenElementTupleDefinitionGroupIsFoo_thenReturnFoo() {
    // Arrange
    ElementTupleDefinition elementTupleDefinition = new ElementTupleDefinition();
    elementTupleDefinition.put(ElementTupleDefinition.GROUP, "foo");

    // Act and Assert
    assertEquals("foo", elementTupleDefinition.getGroup());
  }

  /**
   * Test {@link ElementTupleDefinition#getGroup()}.
   *
   * <ul>
   *   <li>Given {@link ElementTupleDefinition#ElementTupleDefinition()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ElementTupleDefinition#getGroup()}
   */
  @Test
  @DisplayName("Test getGroup(); given ElementTupleDefinition(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ElementTupleDefinition.getGroup()"})
  void testGetGroup_givenElementTupleDefinition_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new ElementTupleDefinition().getGroup());
  }

  /**
   * Test {@link ElementTupleDefinition#get(Object)}.
   *
   * <ul>
   *   <li>Given {@link ElementTupleDefinition#ElementTupleDefinition()} {@link
   *       ElementTupleDefinition#DIRECTED} is {@code 42}.
   *   <li>When {@link ElementTupleDefinition#DIRECTED}.
   *   <li>Then return {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ElementTupleDefinition#get(Object)}
   */
  @Test
  @DisplayName(
      "Test get(Object); given ElementTupleDefinition() DIRECTED is '42'; when DIRECTED; then return '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object ElementTupleDefinition.get(Object)"})
  void testGet_givenElementTupleDefinitionDirectedIs42_whenDirected_thenReturn42() {
    // Arrange
    ElementTupleDefinition elementTupleDefinition = new ElementTupleDefinition();
    elementTupleDefinition.put(ElementTupleDefinition.DIRECTED, "42");

    // Act and Assert
    assertEquals("42", elementTupleDefinition.get(ElementTupleDefinition.DIRECTED));
  }

  /**
   * Test {@link ElementTupleDefinition#get(Object)}.
   *
   * <ul>
   *   <li>Given {@link ElementTupleDefinition#ElementTupleDefinition()}.
   *   <li>When {@link ElementTupleDefinition#DIRECTED}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link ElementTupleDefinition#get(Object)}
   */
  @Test
  @DisplayName(
      "Test get(Object); given ElementTupleDefinition(); when DIRECTED; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object ElementTupleDefinition.get(Object)"})
  void testGet_givenElementTupleDefinition_whenDirected_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue((Boolean) new ElementTupleDefinition().get(ElementTupleDefinition.DIRECTED));
  }

  /**
   * Test {@link ElementTupleDefinition#get(Object)}.
   *
   * <ul>
   *   <li>Given {@link ElementTupleDefinition#ElementTupleDefinition()}.
   *   <li>When {@code Key}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ElementTupleDefinition#get(Object)}
   */
  @Test
  @DisplayName("Test get(Object); given ElementTupleDefinition(); when 'Key'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object ElementTupleDefinition.get(Object)"})
  void testGet_givenElementTupleDefinition_whenKey_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new ElementTupleDefinition().get("Key"));
  }

  /**
   * Test {@link ElementTupleDefinition#vertex(Object)}.
   *
   * <p>Method under test: {@link ElementTupleDefinition#vertex(Object)}
   */
  @Test
  @DisplayName("Test vertex(Object)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ElementTupleDefinition ElementTupleDefinition.vertex(Object)"})
  void testVertex() {
    // Arrange
    ElementTupleDefinition elementTupleDefinition = new ElementTupleDefinition();

    // Act
    ElementTupleDefinition actualVertexResult = elementTupleDefinition.vertex("Value");

    // Assert
    assertEquals(1, elementTupleDefinition.size());
    assertEquals("Value", elementTupleDefinition.get(ElementTupleDefinition.VERTEX));
    assertSame(elementTupleDefinition, actualVertexResult);
  }

  /**
   * Test {@link ElementTupleDefinition#source(Object)}.
   *
   * <p>Method under test: {@link ElementTupleDefinition#source(Object)}
   */
  @Test
  @DisplayName("Test source(Object)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ElementTupleDefinition ElementTupleDefinition.source(Object)"})
  void testSource() {
    // Arrange
    ElementTupleDefinition elementTupleDefinition = new ElementTupleDefinition();

    // Act
    ElementTupleDefinition actualSourceResult = elementTupleDefinition.source("Value");

    // Assert
    assertEquals(1, elementTupleDefinition.size());
    assertEquals("Value", elementTupleDefinition.get(ElementTupleDefinition.SOURCE));
    assertSame(elementTupleDefinition, actualSourceResult);
  }

  /**
   * Test {@link ElementTupleDefinition#destination(Object)}.
   *
   * <p>Method under test: {@link ElementTupleDefinition#destination(Object)}
   */
  @Test
  @DisplayName("Test destination(Object)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ElementTupleDefinition ElementTupleDefinition.destination(Object)"})
  void testDestination() {
    // Arrange
    ElementTupleDefinition elementTupleDefinition = new ElementTupleDefinition();

    // Act
    ElementTupleDefinition actualDestinationResult = elementTupleDefinition.destination("Value");

    // Assert
    assertEquals(1, elementTupleDefinition.size());
    assertEquals("Value", elementTupleDefinition.get(ElementTupleDefinition.DESTINATION));
    assertSame(elementTupleDefinition, actualDestinationResult);
  }

  /**
   * Test {@link ElementTupleDefinition#directed(Object)}.
   *
   * <p>Method under test: {@link ElementTupleDefinition#directed(Object)}
   */
  @Test
  @DisplayName("Test directed(Object)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ElementTupleDefinition ElementTupleDefinition.directed(Object)"})
  void testDirected() {
    // Arrange
    ElementTupleDefinition elementTupleDefinition = new ElementTupleDefinition();

    // Act
    ElementTupleDefinition actualDirectedResult = elementTupleDefinition.directed("Value");

    // Assert
    assertEquals(1, elementTupleDefinition.size());
    assertEquals("Value", elementTupleDefinition.get(ElementTupleDefinition.DIRECTED));
    assertSame(elementTupleDefinition, actualDirectedResult);
  }

  /**
   * Test {@link ElementTupleDefinition#property(String)} with {@code key}.
   *
   * <p>Method under test: {@link ElementTupleDefinition#property(String)}
   */
  @Test
  @DisplayName("Test property(String) with 'key'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ElementTupleDefinition ElementTupleDefinition.property(String)"})
  void testPropertyWithKey() {
    // Arrange
    ElementTupleDefinition elementTupleDefinition = new ElementTupleDefinition();

    // Act
    ElementTupleDefinition actualPropertyResult = elementTupleDefinition.property("Key");

    // Assert
    assertEquals(1, elementTupleDefinition.size());
    assertEquals("Key", elementTupleDefinition.get("Key"));
    assertSame(elementTupleDefinition, actualPropertyResult);
  }

  /**
   * Test {@link ElementTupleDefinition#property(String, Object)} with {@code key}, {@code value}.
   *
   * <p>Method under test: {@link ElementTupleDefinition#property(String, Object)}
   */
  @Test
  @DisplayName("Test property(String, Object) with 'key', 'value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ElementTupleDefinition ElementTupleDefinition.property(String, Object)"})
  void testPropertyWithKeyValue() {
    // Arrange
    ElementTupleDefinition elementTupleDefinition = new ElementTupleDefinition();

    // Act
    ElementTupleDefinition actualPropertyResult = elementTupleDefinition.property("Key", "Value");

    // Assert
    assertEquals(1, elementTupleDefinition.size());
    assertEquals("Value", elementTupleDefinition.get("Key"));
    assertSame(elementTupleDefinition, actualPropertyResult);
  }
}
