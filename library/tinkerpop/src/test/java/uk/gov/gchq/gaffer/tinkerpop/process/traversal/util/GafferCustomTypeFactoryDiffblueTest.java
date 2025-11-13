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
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import uk.gov.gchq.gaffer.types.TypeSubTypeValue;

public class GafferCustomTypeFactoryDiffblueTest {
  /**
   * Test {@link GafferCustomTypeFactory#parseAsCustomTypeIfValid(Object)}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>When {@link LinkedList#LinkedList()} add {@code 42}.</li>
   *   <li>Then return {@link LinkedList#LinkedList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GafferCustomTypeFactory#parseAsCustomTypeIfValid(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Object GafferCustomTypeFactory.parseAsCustomTypeIfValid(Object)"})
  public void testParseAsCustomTypeIfValid_given42_whenLinkedListAdd42_thenReturnLinkedList() {
    // Arrange
    LinkedList<Object> objectList = new LinkedList<>();
    objectList.add("42");
    objectList.add("42");

    // Act and Assert
    assertEquals(objectList, GafferCustomTypeFactory.parseAsCustomTypeIfValid(objectList));
  }

  /**
   * Test {@link GafferCustomTypeFactory#parseAsCustomTypeIfValid(Object)}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>When {@link LinkedList#LinkedList()} add {@code 42}.</li>
   *   <li>Then return {@link List}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GafferCustomTypeFactory#parseAsCustomTypeIfValid(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Object GafferCustomTypeFactory.parseAsCustomTypeIfValid(Object)"})
  public void testParseAsCustomTypeIfValid_given42_whenLinkedListAdd42_thenReturnList() {
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
   * Test {@link GafferCustomTypeFactory#parseAsCustomTypeIfValid(Object)}.
   * <ul>
   *   <li>Then return {@link TypeSubTypeValue}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GafferCustomTypeFactory#parseAsCustomTypeIfValid(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Object GafferCustomTypeFactory.parseAsCustomTypeIfValid(Object)"})
  public void testParseAsCustomTypeIfValid_thenReturnTypeSubTypeValue() {
    // Arrange and Act
    Object actualParseAsCustomTypeIfValidResult = GafferCustomTypeFactory
        .parseAsCustomTypeIfValid("xx[type=xx,  subType=xx,  value=xx]");

    // Assert
    assertTrue(actualParseAsCustomTypeIfValidResult instanceof TypeSubTypeValue);
    assertEquals("xx", ((TypeSubTypeValue) actualParseAsCustomTypeIfValidResult).getSubType());
    assertEquals("xx", ((TypeSubTypeValue) actualParseAsCustomTypeIfValidResult).getType());
    assertEquals("xx", ((TypeSubTypeValue) actualParseAsCustomTypeIfValidResult).getValue());
  }

  /**
   * Test {@link GafferCustomTypeFactory#parseAsCustomTypeIfValid(Object)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GafferCustomTypeFactory#parseAsCustomTypeIfValid(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Object GafferCustomTypeFactory.parseAsCustomTypeIfValid(Object)"})
  public void testParseAsCustomTypeIfValid_whenArrayList_thenReturnArrayList() {
    // Arrange
    ArrayList<Object> objectList = new ArrayList<>();

    // Act and Assert
    assertEquals(objectList, GafferCustomTypeFactory.parseAsCustomTypeIfValid(objectList));
  }

  /**
   * Test {@link GafferCustomTypeFactory#parseAsCustomTypeIfValid(Object)}.
   * <ul>
   *   <li>When {@link HashSet#HashSet()}.</li>
   *   <li>Then return {@link HashSet#HashSet()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GafferCustomTypeFactory#parseAsCustomTypeIfValid(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Object GafferCustomTypeFactory.parseAsCustomTypeIfValid(Object)"})
  public void testParseAsCustomTypeIfValid_whenHashSet_thenReturnHashSet() {
    // Arrange
    HashSet<Object> objectSet = new HashSet<>();

    // Act and Assert
    assertEquals(objectSet, GafferCustomTypeFactory.parseAsCustomTypeIfValid(objectSet));
  }

  /**
   * Test {@link GafferCustomTypeFactory#parseAsCustomTypeIfValid(Object)}.
   * <ul>
   *   <li>When {@code Value}.</li>
   *   <li>Then return {@code Value}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GafferCustomTypeFactory#parseAsCustomTypeIfValid(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Object GafferCustomTypeFactory.parseAsCustomTypeIfValid(Object)"})
  public void testParseAsCustomTypeIfValid_whenValue_thenReturnValue() {
    // Arrange, Act and Assert
    assertEquals("Value", GafferCustomTypeFactory.parseAsCustomTypeIfValid("Value"));
  }

  /**
   * Test {@link GafferCustomTypeFactory#parseForGraphSONv3(Object)}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.</li>
   *   <li>Then return size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link GafferCustomTypeFactory#parseForGraphSONv3(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Object GafferCustomTypeFactory.parseForGraphSONv3(Object)"})
  public void testParseForGraphSONv3_given42_whenArrayListAdd42_thenReturnSizeIsOne() {
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
   * Test {@link GafferCustomTypeFactory#parseForGraphSONv3(Object)}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.</li>
   *   <li>Then return size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link GafferCustomTypeFactory#parseForGraphSONv3(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Object GafferCustomTypeFactory.parseForGraphSONv3(Object)"})
  public void testParseForGraphSONv3_given42_whenArrayListAdd42_thenReturnSizeIsTwo() {
    // Arrange
    ArrayList<Object> objectList = new ArrayList<>();
    objectList.add("42");
    objectList.add("42");

    // Act
    Object actualParseForGraphSONv3Result = GafferCustomTypeFactory.parseForGraphSONv3(objectList);

    // Assert
    assertTrue(actualParseForGraphSONv3Result instanceof List);
    assertEquals(2, ((List<String>) actualParseForGraphSONv3Result).size());
    assertEquals("42", ((List<String>) actualParseForGraphSONv3Result).get(0));
    assertEquals("42", ((List<String>) actualParseForGraphSONv3Result).get(1));
  }

  /**
   * Test {@link GafferCustomTypeFactory#parseForGraphSONv3(Object)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GafferCustomTypeFactory#parseForGraphSONv3(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Object GafferCustomTypeFactory.parseForGraphSONv3(Object)"})
  public void testParseForGraphSONv3_whenArrayList_thenReturnArrayList() {
    // Arrange
    ArrayList<Object> objectList = new ArrayList<>();

    // Act and Assert
    assertEquals(objectList, GafferCustomTypeFactory.parseForGraphSONv3(objectList));
  }

  /**
   * Test {@link GafferCustomTypeFactory#parseForGraphSONv3(Object)}.
   * <ul>
   *   <li>When {@link HashSet#HashSet()}.</li>
   *   <li>Then return {@link HashSet#HashSet()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GafferCustomTypeFactory#parseForGraphSONv3(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Object GafferCustomTypeFactory.parseForGraphSONv3(Object)"})
  public void testParseForGraphSONv3_whenHashSet_thenReturnHashSet() {
    // Arrange
    HashSet<Object> objectSet = new HashSet<>();

    // Act and Assert
    assertEquals(objectSet, GafferCustomTypeFactory.parseForGraphSONv3(objectSet));
  }

  /**
   * Test {@link GafferCustomTypeFactory#parseForGraphSONv3(Object)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GafferCustomTypeFactory#parseForGraphSONv3(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Object GafferCustomTypeFactory.parseForGraphSONv3(Object)"})
  public void testParseForGraphSONv3_whenNull_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(GafferCustomTypeFactory.parseForGraphSONv3(null));
  }

  /**
   * Test {@link GafferCustomTypeFactory#parseForGraphSONv3(Object)}.
   * <ul>
   *   <li>When {@code Value}.</li>
   *   <li>Then return {@code Value}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GafferCustomTypeFactory#parseForGraphSONv3(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Object GafferCustomTypeFactory.parseForGraphSONv3(Object)"})
  public void testParseForGraphSONv3_whenValue_thenReturnValue() {
    // Arrange, Act and Assert
    assertEquals("Value", GafferCustomTypeFactory.parseForGraphSONv3("Value"));
  }
}
