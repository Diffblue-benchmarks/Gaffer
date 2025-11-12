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

package uk.gov.gchq.gaffer.tinkerpop.process.traversal.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import org.junit.Test;

public class GafferCustomTypeFactoryDiffblueTest {
  /**
   * Method under test:
   * {@link GafferCustomTypeFactory#parseAsCustomTypeIfValid(Object)}
   */
  @Test
  public void testParseAsCustomTypeIfValid() {
    // Arrange, Act and Assert
    assertEquals("Value", GafferCustomTypeFactory.parseAsCustomTypeIfValid("Value"));
  }

  /**
   * Method under test:
   * {@link GafferCustomTypeFactory#parseAsCustomTypeIfValid(Object)}
   */
  @Test
  public void testParseAsCustomTypeIfValid2() {
    // Arrange and Act
    Object actualParseAsCustomTypeIfValidResult = GafferCustomTypeFactory.parseAsCustomTypeIfValid(new ArrayList<>());

    // Assert
    assertTrue(actualParseAsCustomTypeIfValidResult instanceof List);
    assertTrue(((List<Object>) actualParseAsCustomTypeIfValidResult).isEmpty());
  }

  /**
   * Method under test:
   * {@link GafferCustomTypeFactory#parseAsCustomTypeIfValid(Object)}
   */
  @Test
  public void testParseAsCustomTypeIfValid3() {
    // Arrange and Act
    Object actualParseAsCustomTypeIfValidResult = GafferCustomTypeFactory.parseAsCustomTypeIfValid(new HashSet<>());

    // Assert
    assertTrue(actualParseAsCustomTypeIfValidResult instanceof Set);
    assertTrue(((Set<Object>) actualParseAsCustomTypeIfValidResult).isEmpty());
  }

  /**
   * Method under test:
   * {@link GafferCustomTypeFactory#parseAsCustomTypeIfValid(Object)}
   */
  @Test
  public void testParseAsCustomTypeIfValid4() {
    // Arrange
    LinkedList<Object> objectList = new LinkedList<>();
    objectList.add("42");

    // Act
    Object actualParseAsCustomTypeIfValidResult = GafferCustomTypeFactory.parseAsCustomTypeIfValid(objectList);

    // Assert
    assertTrue(actualParseAsCustomTypeIfValidResult instanceof List);
    assertEquals(1, ((List<String>) actualParseAsCustomTypeIfValidResult).size());
    assertEquals("42", ((List<String>) actualParseAsCustomTypeIfValidResult).get(0));
  }

  /**
   * Method under test:
   * {@link GafferCustomTypeFactory#parseAsCustomTypeIfValid(Object)}
   */
  @Test
  public void testParseAsCustomTypeIfValid5() {
    // Arrange
    LinkedList<Object> objectList = new LinkedList<>();
    objectList.add("42");
    objectList.add("42");

    // Act and Assert
    assertEquals(objectList, GafferCustomTypeFactory.parseAsCustomTypeIfValid(objectList));
  }

  /**
   * Method under test: {@link GafferCustomTypeFactory#parseForGraphSONv3(Object)}
   */
  @Test
  public void testParseForGraphSONv3() {
    // Arrange, Act and Assert
    assertEquals("Value", GafferCustomTypeFactory.parseForGraphSONv3("Value"));
    assertNull(GafferCustomTypeFactory.parseForGraphSONv3(null));
  }

  /**
   * Method under test: {@link GafferCustomTypeFactory#parseForGraphSONv3(Object)}
   */
  @Test
  public void testParseForGraphSONv32() {
    // Arrange and Act
    Object actualParseForGraphSONv3Result = GafferCustomTypeFactory.parseForGraphSONv3(new ArrayList<>());

    // Assert
    assertTrue(actualParseForGraphSONv3Result instanceof List);
    assertTrue(((List<Object>) actualParseForGraphSONv3Result).isEmpty());
  }

  /**
   * Method under test: {@link GafferCustomTypeFactory#parseForGraphSONv3(Object)}
   */
  @Test
  public void testParseForGraphSONv33() {
    // Arrange and Act
    Object actualParseForGraphSONv3Result = GafferCustomTypeFactory.parseForGraphSONv3(new HashSet<>());

    // Assert
    assertTrue(actualParseForGraphSONv3Result instanceof Set);
    assertTrue(((Set<Object>) actualParseForGraphSONv3Result).isEmpty());
  }

  /**
   * Method under test: {@link GafferCustomTypeFactory#parseForGraphSONv3(Object)}
   */
  @Test
  public void testParseForGraphSONv34() {
    // Arrange
    ArrayList<Object> objectList = new ArrayList<>();
    objectList.add("42");

    // Act
    Object actualParseForGraphSONv3Result = GafferCustomTypeFactory.parseForGraphSONv3(objectList);

    // Assert
    assertTrue(actualParseForGraphSONv3Result instanceof List);
    assertEquals(1, ((List<String>) actualParseForGraphSONv3Result).size());
    assertEquals("42", ((List<String>) actualParseForGraphSONv3Result).get(0));
  }

  /**
   * Method under test: {@link GafferCustomTypeFactory#parseForGraphSONv3(Object)}
   */
  @Test
  public void testParseForGraphSONv35() {
    // Arrange
    ArrayList<Object> objectList = new ArrayList<>();
    objectList.add("42");
    objectList.add("42");

    // Act and Assert
    assertEquals(objectList, GafferCustomTypeFactory.parseForGraphSONv3(objectList));
  }
}
