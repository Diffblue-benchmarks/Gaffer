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

package uk.gov.gchq.gaffer.commonutil;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class CollectionUtilDiffblueTest {
  /**
   * Test {@link CollectionUtil#toIterableArray(Collection)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.
   *   <li>Then first element return {@link List}.
   * </ul>
   *
   * <p>Method under test: {@link CollectionUtil#toIterableArray(Collection)}
   */
  @Test
  @DisplayName(
      "Test toIterableArray(Collection); given ArrayList(); then first element return List")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Iterable[] CollectionUtil.toIterableArray(Collection)"})
  void testToIterableArray_givenArrayList_thenFirstElementReturnList() {
    // Arrange
    ArrayList<Iterable> collection = new ArrayList<>();
    ArrayList<Object> objectList = new ArrayList<>();
    collection.add(objectList);

    // Act
    Iterable[] actualToIterableArrayResult = CollectionUtil.toIterableArray(collection);

    // Assert
    Iterable iterable = actualToIterableArrayResult[0];
    assertTrue(iterable instanceof List);
    assertEquals(1, actualToIterableArrayResult.length);
    assertTrue(((List<Object>) iterable).isEmpty());
    assertSame(objectList, iterable);
  }

  /**
   * Test {@link CollectionUtil#toIterableArray(Collection)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.
   *   <li>Then return array length is two.
   * </ul>
   *
   * <p>Method under test: {@link CollectionUtil#toIterableArray(Collection)}
   */
  @Test
  @DisplayName(
      "Test toIterableArray(Collection); given ArrayList(); then return array length is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Iterable[] CollectionUtil.toIterableArray(Collection)"})
  void testToIterableArray_givenArrayList_thenReturnArrayLengthIsTwo() {
    // Arrange
    ArrayList<Iterable> collection = new ArrayList<>();
    collection.add(new ArrayList<>());
    ArrayList<Object> objectList = new ArrayList<>();
    collection.add(objectList);

    // Act
    Iterable[] actualToIterableArrayResult = CollectionUtil.toIterableArray(collection);

    // Assert
    assertEquals(2, actualToIterableArrayResult.length);
    assertSame(objectList, actualToIterableArrayResult[1]);
  }

  /**
   * Test {@link CollectionUtil#toIterableArray(Collection)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return array length is zero.
   * </ul>
   *
   * <p>Method under test: {@link CollectionUtil#toIterableArray(Collection)}
   */
  @Test
  @DisplayName(
      "Test toIterableArray(Collection); when ArrayList(); then return array length is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Iterable[] CollectionUtil.toIterableArray(Collection)"})
  void testToIterableArray_whenArrayList_thenReturnArrayLengthIsZero() {
    // Arrange and Act
    Iterable[] actualToIterableArrayResult = CollectionUtil.toIterableArray(new ArrayList<>());

    // Assert
    assertEquals(0, actualToIterableArrayResult.length);
  }

  /**
   * Test {@link CollectionUtil#toIterableArray(Collection)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link CollectionUtil#toIterableArray(Collection)}
   */
  @Test
  @DisplayName("Test toIterableArray(Collection); when 'null'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Iterable[] CollectionUtil.toIterableArray(Collection)"})
  void testToIterableArray_whenNull_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(CollectionUtil.toIterableArray(null));
  }

  /**
   * Test {@link CollectionUtil#treeSet(Object[])}.
   *
   * <p>Method under test: {@link CollectionUtil#treeSet(Object[])}
   */
  @Test
  @DisplayName("Test treeSet(Object[])")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TreeSet CollectionUtil.treeSet(Object[])"})
  void testTreeSet() {
    // Arrange and Act
    TreeSet<Object> actualTreeSetResult = CollectionUtil.treeSet("Items");

    // Assert
    assertEquals(1, actualTreeSetResult.size());
  }

  /**
   * Test {@link CollectionUtil#toMapWithClassKeys(Map)} with {@code mapAsStrings}.
   *
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link CollectionUtil#toMapWithClassKeys(Map)}
   */
  @Test
  @DisplayName(
      "Test toMapWithClassKeys(Map) with 'mapAsStrings'; when HashMap(); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map CollectionUtil.toMapWithClassKeys(Map)"})
  void testToMapWithClassKeysWithMapAsStrings_whenHashMap_thenReturnEmpty()
      throws ClassNotFoundException {
    // Arrange and Act
    Map<Class<?>, Object> actualToMapWithClassKeysResult =
        CollectionUtil.toMapWithClassKeys(new HashMap<>());

    // Assert
    assertTrue(actualToMapWithClassKeysResult.isEmpty());
  }

  /**
   * Test {@link CollectionUtil#toMapWithStringKeys(Map, Map)} with {@code map}, {@code
   * mapAsStrings}.
   *
   * <ul>
   *   <li>Then {@link HashMap#HashMap()} size is one.
   * </ul>
   *
   * <p>Method under test: {@link CollectionUtil#toMapWithStringKeys(Map, Map)}
   */
  @Test
  @DisplayName(
      "Test toMapWithStringKeys(Map, Map) with 'map', 'mapAsStrings'; then HashMap() size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CollectionUtil.toMapWithStringKeys(Map, Map)"})
  void testToMapWithStringKeysWithMapMapAsStrings_thenHashMapSizeIsOne() {
    // Arrange
    HashMap<Class<?>, Object> map = new HashMap<>();
    Class<Object> forNameResult = Object.class;
    map.put(forNameResult, "42");
    HashMap<String, Object> mapAsStrings = new HashMap<>();

    // Act
    CollectionUtil.toMapWithStringKeys(map, mapAsStrings);

    // Assert
    assertEquals(1, mapAsStrings.size());
    assertEquals("42", mapAsStrings.get("java.lang.Object"));
  }

  /**
   * Test {@link CollectionUtil#toMapWithStringKeys(Map, Map)} with {@code map}, {@code
   * mapAsStrings}.
   *
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.
   *   <li>Then {@link HashMap#HashMap()} Empty.
   * </ul>
   *
   * <p>Method under test: {@link CollectionUtil#toMapWithStringKeys(Map, Map)}
   */
  @Test
  @DisplayName(
      "Test toMapWithStringKeys(Map, Map) with 'map', 'mapAsStrings'; when HashMap(); then HashMap() Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CollectionUtil.toMapWithStringKeys(Map, Map)"})
  void testToMapWithStringKeysWithMapMapAsStrings_whenHashMap_thenHashMapEmpty() {
    // Arrange
    HashMap<Class<?>, Object> map = new HashMap<>();
    HashMap<String, Object> mapAsStrings = new HashMap<>();

    // Act
    CollectionUtil.toMapWithStringKeys(map, mapAsStrings);

    // Assert that nothing has changed
    assertTrue(mapAsStrings.isEmpty());
  }

  /**
   * Test {@link CollectionUtil#toMapWithStringKeys(Map)} with {@code map}.
   *
   * <ul>
   *   <li>Given {@code Object}.
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link CollectionUtil#toMapWithStringKeys(Map)}
   */
  @Test
  @DisplayName(
      "Test toMapWithStringKeys(Map) with 'map'; given 'java.lang.Object'; then return size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map CollectionUtil.toMapWithStringKeys(Map)"})
  void testToMapWithStringKeysWithMap_givenJavaLangObject_thenReturnSizeIsOne() {
    // Arrange
    HashMap<Class<?>, Object> map = new HashMap<>();
    Class<Object> forNameResult = Object.class;
    map.put(forNameResult, "42");

    // Act
    Map<String, Object> actualToMapWithStringKeysResult = CollectionUtil.toMapWithStringKeys(map);

    // Assert
    assertEquals(1, actualToMapWithStringKeysResult.size());
    assertEquals("42", actualToMapWithStringKeysResult.get("java.lang.Object"));
  }

  /**
   * Test {@link CollectionUtil#toMapWithStringKeys(Map)} with {@code map}.
   *
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link CollectionUtil#toMapWithStringKeys(Map)}
   */
  @Test
  @DisplayName("Test toMapWithStringKeys(Map) with 'map'; when HashMap(); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map CollectionUtil.toMapWithStringKeys(Map)"})
  void testToMapWithStringKeysWithMap_whenHashMap_thenReturnEmpty() {
    // Arrange and Act
    Map<String, Object> actualToMapWithStringKeysResult =
        CollectionUtil.toMapWithStringKeys(new HashMap<>());

    // Assert
    assertTrue(actualToMapWithStringKeysResult.isEmpty());
  }

  /**
   * Test {@link CollectionUtil#containsAny(Collection, Object[])}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@code 42}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link CollectionUtil#containsAny(Collection, Object[])}
   */
  @Test
  @DisplayName("Test containsAny(Collection, Object[]); given '42'; when '42'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CollectionUtil.containsAny(Collection, Object[])"})
  void testContainsAny_given42_when42_thenReturnTrue() {
    // Arrange
    ArrayList<Object> collection = new ArrayList<>();
    collection.add("42");

    // Act and Assert
    assertTrue(CollectionUtil.containsAny(collection, "42"));
  }

  /**
   * Test {@link CollectionUtil#containsAny(Collection, Object[])}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link CollectionUtil#containsAny(Collection, Object[])}
   */
  @Test
  @DisplayName(
      "Test containsAny(Collection, Object[]); given '42'; when ArrayList() add '42'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CollectionUtil.containsAny(Collection, Object[])"})
  void testContainsAny_given42_whenArrayListAdd42_thenReturnFalse() {
    // Arrange
    ArrayList<Object> collection = new ArrayList<>();
    collection.add("42");

    // Act and Assert
    assertFalse(CollectionUtil.containsAny(collection, "Objects"));
  }

  /**
   * Test {@link CollectionUtil#containsAny(Collection, Object[])}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link CollectionUtil#containsAny(Collection, Object[])}
   */
  @Test
  @DisplayName(
      "Test containsAny(Collection, Object[]); given '42'; when ArrayList() add '42'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CollectionUtil.containsAny(Collection, Object[])"})
  void testContainsAny_given42_whenArrayListAdd42_thenReturnFalse2() {
    // Arrange
    ArrayList<Object> collection = new ArrayList<>();
    collection.add("42");
    collection.add("42");

    // Act and Assert
    assertFalse(CollectionUtil.containsAny(collection, "Objects"));
  }

  /**
   * Test {@link CollectionUtil#containsAny(Collection, Object[])}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link CollectionUtil#containsAny(Collection, Object[])}
   */
  @Test
  @DisplayName("Test containsAny(Collection, Object[]); when ArrayList(); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CollectionUtil.containsAny(Collection, Object[])"})
  void testContainsAny_whenArrayList_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(CollectionUtil.containsAny(new ArrayList<>(), "Objects"));
  }

  /**
   * Test {@link CollectionUtil#containsAny(Collection, Object[])}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link CollectionUtil#containsAny(Collection, Object[])}
   */
  @Test
  @DisplayName("Test containsAny(Collection, Object[]); when ArrayList(); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CollectionUtil.containsAny(Collection, Object[])"})
  void testContainsAny_whenArrayList_thenReturnFalse2() {
    // Arrange, Act and Assert
    assertFalse(CollectionUtil.containsAny(new ArrayList<>(), null));
  }

  /**
   * Test {@link CollectionUtil#containsAny(Collection, Object[])}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link CollectionUtil#containsAny(Collection, Object[])}
   */
  @Test
  @DisplayName("Test containsAny(Collection, Object[]); when 'null'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CollectionUtil.containsAny(Collection, Object[])"})
  void testContainsAny_whenNull_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(CollectionUtil.containsAny(null, "Objects"));
  }

  /**
   * Test {@link CollectionUtil#anyMissing(Collection, Object[])}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@code 42}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link CollectionUtil#anyMissing(Collection, Object[])}
   */
  @Test
  @DisplayName("Test anyMissing(Collection, Object[]); given '42'; when '42'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CollectionUtil.anyMissing(Collection, Object[])"})
  void testAnyMissing_given42_when42_thenReturnFalse() {
    // Arrange
    ArrayList<Object> collection = new ArrayList<>();
    collection.add("42");

    // Act and Assert
    assertFalse(CollectionUtil.anyMissing(collection, "42"));
  }

  /**
   * Test {@link CollectionUtil#anyMissing(Collection, Object[])}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link CollectionUtil#anyMissing(Collection, Object[])}
   */
  @Test
  @DisplayName(
      "Test anyMissing(Collection, Object[]); given '42'; when ArrayList() add '42'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CollectionUtil.anyMissing(Collection, Object[])"})
  void testAnyMissing_given42_whenArrayListAdd42_thenReturnFalse() {
    // Arrange
    ArrayList<Object> collection = new ArrayList<>();
    collection.add("42");

    // Act and Assert
    assertFalse(CollectionUtil.anyMissing(collection));
  }

  /**
   * Test {@link CollectionUtil#anyMissing(Collection, Object[])}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link CollectionUtil#anyMissing(Collection, Object[])}
   */
  @Test
  @DisplayName(
      "Test anyMissing(Collection, Object[]); given '42'; when ArrayList() add '42'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CollectionUtil.anyMissing(Collection, Object[])"})
  void testAnyMissing_given42_whenArrayListAdd42_thenReturnTrue() {
    // Arrange
    ArrayList<Object> collection = new ArrayList<>();
    collection.add("42");

    // Act and Assert
    assertTrue(CollectionUtil.anyMissing(collection, "Objects"));
  }

  /**
   * Test {@link CollectionUtil#anyMissing(Collection, Object[])}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link CollectionUtil#anyMissing(Collection, Object[])}
   */
  @Test
  @DisplayName(
      "Test anyMissing(Collection, Object[]); given '42'; when ArrayList() add '42'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CollectionUtil.anyMissing(Collection, Object[])"})
  void testAnyMissing_given42_whenArrayListAdd42_thenReturnTrue2() {
    // Arrange
    ArrayList<Object> collection = new ArrayList<>();
    collection.add("42");
    collection.add("42");

    // Act and Assert
    assertTrue(CollectionUtil.anyMissing(collection, "Objects"));
  }

  /**
   * Test {@link CollectionUtil#anyMissing(Collection, Object[])}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link CollectionUtil#anyMissing(Collection, Object[])}
   */
  @Test
  @DisplayName("Test anyMissing(Collection, Object[]); when ArrayList(); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CollectionUtil.anyMissing(Collection, Object[])"})
  void testAnyMissing_whenArrayList_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(CollectionUtil.anyMissing(new ArrayList<>()));
  }

  /**
   * Test {@link CollectionUtil#anyMissing(Collection, Object[])}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link CollectionUtil#anyMissing(Collection, Object[])}
   */
  @Test
  @DisplayName("Test anyMissing(Collection, Object[]); when ArrayList(); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CollectionUtil.anyMissing(Collection, Object[])"})
  void testAnyMissing_whenArrayList_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(CollectionUtil.anyMissing(new ArrayList<>(), "Objects"));
  }

  /**
   * Test {@link CollectionUtil#anyMissing(Collection, Object[])}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link CollectionUtil#anyMissing(Collection, Object[])}
   */
  @Test
  @DisplayName("Test anyMissing(Collection, Object[]); when 'null'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CollectionUtil.anyMissing(Collection, Object[])"})
  void testAnyMissing_whenNull_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(CollectionUtil.anyMissing(new ArrayList<>(), null));
  }

  /**
   * Test {@link CollectionUtil#anyMissing(Collection, Object[])}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link CollectionUtil#anyMissing(Collection, Object[])}
   */
  @Test
  @DisplayName("Test anyMissing(Collection, Object[]); when 'null'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CollectionUtil.anyMissing(Collection, Object[])"})
  void testAnyMissing_whenNull_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(CollectionUtil.anyMissing(null, "Objects"));
  }

  /**
   * Test {@link CollectionUtil#distinct(Collection)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link CollectionUtil#distinct(Collection)}
   */
  @Test
  @DisplayName(
      "Test distinct(Collection); given '42'; when ArrayList() add '42'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CollectionUtil.distinct(Collection)"})
  void testDistinct_given42_whenArrayListAdd42_thenReturnFalse() {
    // Arrange
    ArrayList<Object> collection = new ArrayList<>();
    collection.add("42");
    collection.add("42");

    // Act and Assert
    assertFalse(CollectionUtil.distinct(collection));
  }

  /**
   * Test {@link CollectionUtil#distinct(Collection)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link CollectionUtil#distinct(Collection)}
   */
  @Test
  @DisplayName(
      "Test distinct(Collection); given '42'; when ArrayList() add '42'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CollectionUtil.distinct(Collection)"})
  void testDistinct_given42_whenArrayListAdd42_thenReturnTrue() {
    // Arrange
    ArrayList<Object> collection = new ArrayList<>();
    collection.add("42");

    // Act and Assert
    assertTrue(CollectionUtil.distinct(collection));
  }

  /**
   * Test {@link CollectionUtil#distinct(Collection)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link CollectionUtil#distinct(Collection)}
   */
  @Test
  @DisplayName("Test distinct(Collection); when ArrayList(); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CollectionUtil.distinct(Collection)"})
  void testDistinct_whenArrayList_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(CollectionUtil.distinct(new ArrayList<>()));
  }
}
