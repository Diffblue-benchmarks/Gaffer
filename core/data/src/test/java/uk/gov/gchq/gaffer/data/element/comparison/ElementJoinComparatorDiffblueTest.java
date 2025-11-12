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

package uk.gov.gchq.gaffer.data.element.comparison;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.data.element.Edge;
import uk.gov.gchq.gaffer.data.element.Element;
import uk.gov.gchq.gaffer.data.element.ElementValueLoader;
import uk.gov.gchq.gaffer.data.element.Entity;
import uk.gov.gchq.gaffer.data.element.LazyEntity;

class ElementJoinComparatorDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ElementJoinComparator#ElementJoinComparator()}
   *   <li>{@link ElementJoinComparator#setGroupByProperties(Set)}
   *   <li>{@link ElementJoinComparator#getGroupByProperties()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    ElementJoinComparator actualElementJoinComparator = new ElementJoinComparator();
    HashSet<String> groupByProperties = new HashSet<>();
    actualElementJoinComparator.setGroupByProperties(groupByProperties);
    Set<String> actualGroupByProperties = actualElementJoinComparator.getGroupByProperties();

    // Assert that nothing has changed
    assertTrue(actualGroupByProperties.isEmpty());
    assertSame(groupByProperties, actualGroupByProperties);
  }

  /**
   * Method under test: {@link ElementJoinComparator#test(Element, Element)}
   */
  @Test
  void testTest() {
    // Arrange
    ElementJoinComparator elementJoinComparator = new ElementJoinComparator();
    Entity element = new Entity("Group");

    // Act and Assert
    assertFalse(elementJoinComparator.test(element, new Edge("Group")));
  }

  /**
   * Method under test: {@link ElementJoinComparator#test(Element, Element)}
   */
  @Test
  void testTest2() {
    // Arrange
    ElementJoinComparator elementJoinComparator = new ElementJoinComparator();

    // Act and Assert
    assertFalse(elementJoinComparator.test(null, new Edge("Group")));
  }

  /**
   * Method under test: {@link ElementJoinComparator#test(Element, Element)}
   */
  @Test
  void testTest3() {
    // Arrange
    ElementJoinComparator elementJoinComparator = new ElementJoinComparator();
    Edge element = new Edge("Group", "Source", "Destination", true);

    // Act and Assert
    assertFalse(elementJoinComparator.test(element, new Edge("Group")));
  }

  /**
   * Method under test: {@link ElementJoinComparator#test(Element, Element)}
   */
  @Test
  void testTest4() {
    // Arrange
    ElementJoinComparator elementJoinComparator = new ElementJoinComparator();
    LazyEntity element = new LazyEntity(new Entity("Group"), mock(ElementValueLoader.class));

    // Act and Assert
    assertFalse(elementJoinComparator.test(element, new Edge("Group")));
  }

  /**
   * Method under test: {@link ElementJoinComparator#test(Element, Element)}
   */
  @Test
  void testTest5() {
    // Arrange
    ElementJoinComparator elementJoinComparator = new ElementJoinComparator();

    // Act and Assert
    assertFalse(elementJoinComparator.test(new Edge("Group"), null));
  }

  /**
   * Method under test: {@link ElementJoinComparator#test(Element, Element)}
   */
  @Test
  void testTest6() {
    // Arrange, Act and Assert
    assertTrue((new ElementJoinComparator()).test(null, null));
  }

  /**
   * Method under test: {@link ElementJoinComparator#test(Element, Element)}
   */
  @Test
  void testTest7() {
    // Arrange
    ElementJoinComparator elementJoinComparator = new ElementJoinComparator();
    Edge element = new Edge("directed", "Source", "Destination", true);

    // Act and Assert
    assertFalse(elementJoinComparator.test(element, new Edge("Group")));
  }

  /**
   * Method under test: {@link ElementJoinComparator#test(Element, Element)}
   */
  @Test
  void testTest8() {
    // Arrange
    ElementJoinComparator elementJoinComparator = new ElementJoinComparator();
    Edge element = new Edge("Group", "Source", "Destination", true);

    // Act and Assert
    assertTrue(elementJoinComparator.test(element, new Edge("Group", "Source", "Destination", true)));
  }

  /**
   * Method under test: {@link ElementJoinComparator#test(Element, Element)}
   */
  @Test
  void testTest9() {
    // Arrange
    ElementJoinComparator elementJoinComparator = new ElementJoinComparator();

    Entity element = new Entity("Group");
    element.setVertex("Vertex");

    // Act and Assert
    assertFalse(elementJoinComparator.test(element, new Entity("Group")));
  }

  /**
   * Method under test: {@link ElementJoinComparator#test(Element, Element)}
   */
  @Test
  void testTest10() {
    // Arrange
    ElementJoinComparator elementJoinComparator = new ElementJoinComparator("Group");
    Edge element = new Edge("Group", "Source", "Destination", true);

    // Act and Assert
    assertTrue(elementJoinComparator.test(element, new Edge("Group", "Source", "Destination", true)));
  }

  /**
   * Method under test: {@link ElementJoinComparator#test(Element, Element)}
   */
  @Test
  void testTest11() {
    // Arrange
    ElementJoinComparator elementJoinComparator = new ElementJoinComparator();
    Edge element = new Edge("Group", "Source", 1, true);

    // Act and Assert
    assertFalse(elementJoinComparator.test(element, new Edge("Group", "Source", "Destination", true)));
  }

  /**
   * Method under test: {@link ElementJoinComparator#test(Element, Element)}
   */
  @Test
  void testTest12() {
    // Arrange
    ElementJoinComparator elementJoinComparator = new ElementJoinComparator();

    Entity element = new Entity("Group");
    element.setVertex("Vertex");

    Entity element2 = new Entity("Group");
    element2.setVertex("Vertex");

    // Act and Assert
    assertTrue(elementJoinComparator.test(element, element2));
  }

  /**
   * Method under test: {@link ElementJoinComparator#ElementJoinComparator(Set)}
   */
  @Test
  void testNewElementJoinComparator() {
    // Arrange, Act and Assert
    assertTrue((new ElementJoinComparator(new HashSet<>())).getGroupByProperties().isEmpty());
  }

  /**
   * Method under test: {@link ElementJoinComparator#ElementJoinComparator(Set)}
   */
  @Test
  void testNewElementJoinComparator2() {
    // Arrange
    HashSet<String> groupByProperties = new HashSet<>();
    groupByProperties.add("foo");

    // Act and Assert
    Set<String> groupByProperties2 = (new ElementJoinComparator(groupByProperties)).getGroupByProperties();
    assertEquals(1, groupByProperties2.size());
    assertTrue(groupByProperties2.contains("foo"));
  }

  /**
   * Method under test: {@link ElementJoinComparator#ElementJoinComparator(Set)}
   */
  @Test
  void testNewElementJoinComparator3() {
    // Arrange
    HashSet<String> groupByProperties = new HashSet<>();
    groupByProperties.add("42");
    groupByProperties.add("foo");

    // Act and Assert
    assertEquals(groupByProperties, (new ElementJoinComparator(groupByProperties)).getGroupByProperties());
  }

  /**
   * Method under test:
   * {@link ElementJoinComparator#ElementJoinComparator(String[])}
   */
  @Test
  void testNewElementJoinComparator4() {
    // Arrange, Act and Assert
    Set<String> groupByProperties = (new ElementJoinComparator("Group By Properties")).getGroupByProperties();
    assertEquals(1, groupByProperties.size());
    assertTrue(groupByProperties.contains("Group By Properties"));
  }

  /**
   * Method under test:
   * {@link ElementJoinComparator#ElementJoinComparator(String[])}
   */
  @Test
  void testNewElementJoinComparator5() {
    // Arrange, Act and Assert
    Set<String> groupByProperties = (new ElementJoinComparator("Group By Properties",
        "uk.gov.gchq.gaffer.data.element.Edge", "Group By Properties")).getGroupByProperties();
    assertEquals(2, groupByProperties.size());
    assertTrue(groupByProperties.contains("Group By Properties"));
    assertTrue(groupByProperties.contains("uk.gov.gchq.gaffer.data.element.Edge"));
  }
}
