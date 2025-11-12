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
import static org.mockito.Mockito.mock;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import java.util.function.BiFunction;
import org.junit.jupiter.api.Test;

class CollectionUtilDiffblueTest {
  /**
   * Method under test: {@link CollectionUtil#toIterableArray(Collection)}
   */
  @Test
  void testToIterableArray() {
    // Arrange, Act and Assert
    assertEquals(0, CollectionUtil.toIterableArray(new ArrayList<>()).length);
    assertNull(CollectionUtil.toIterableArray(null));
  }

  /**
   * Method under test: {@link CollectionUtil#toIterableArray(Collection)}
   */
  @Test
  void testToIterableArray2() {
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
   * Method under test: {@link CollectionUtil#toIterableArray(Collection)}
   */
  @Test
  void testToIterableArray3() {
    // Arrange
    ArrayList<Iterable> collection = new ArrayList<>();
    ArrayList<Object> objectList = new ArrayList<>();
    collection.add(objectList);
    ArrayList<Object> objectList2 = new ArrayList<>();
    collection.add(objectList2);

    // Act
    Iterable[] actualToIterableArrayResult = CollectionUtil.toIterableArray(collection);

    // Assert
    Iterable iterable = actualToIterableArrayResult[0];
    assertTrue(iterable instanceof List);
    Iterable iterable2 = actualToIterableArrayResult[1];
    assertTrue(iterable2 instanceof List);
    assertEquals(2, actualToIterableArrayResult.length);
    assertTrue(((List<Object>) iterable).isEmpty());
    assertTrue(((List<Object>) iterable2).isEmpty());
    assertSame(objectList, iterable);
    assertSame(objectList2, iterable2);
  }

  /**
   * Method under test: {@link CollectionUtil#treeSet(Object[])}
   */
  @Test
  void testTreeSet() {
    // Arrange and Act
    TreeSet<Object> actualTreeSetResult = CollectionUtil.treeSet("Items");

    // Assert
    assertEquals(1, actualTreeSetResult.size());
  }

  /**
   * Method under test: {@link CollectionUtil#toMapWithClassKeys(Map)}
   */
  @Test
  void testToMapWithClassKeys() throws ClassNotFoundException {
    // Arrange and Act
    Map<Class<?>, Object> actualToMapWithClassKeysResult = CollectionUtil.toMapWithClassKeys(new HashMap<>());

    // Assert
    assertTrue(actualToMapWithClassKeysResult.isEmpty());
  }

  /**
   * Method under test: {@link CollectionUtil#toMapWithStringKeys(Map)}
   */
  @Test
  void testToMapWithStringKeys() {
    // Arrange and Act
    Map<String, Object> actualToMapWithStringKeysResult = CollectionUtil.toMapWithStringKeys(new HashMap<>());

    // Assert
    assertTrue(actualToMapWithStringKeysResult.isEmpty());
  }

  /**
   * Method under test: {@link CollectionUtil#toMapWithStringKeys(Map)}
   */
  @Test
  void testToMapWithStringKeys2() {
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
   * Method under test: {@link CollectionUtil#toMapWithStringKeys(Map)}
   */
  @Test
  void testToMapWithStringKeys3() {
    // Arrange
    HashMap<Class<?>, Object> map = new HashMap<>();
    Class<Object> forNameResult = Object.class;
    map.computeIfPresent(forNameResult, mock(BiFunction.class));
    Class<Object> forNameResult2 = Object.class;
    map.put(forNameResult2, "42");

    // Act
    Map<String, Object> actualToMapWithStringKeysResult = CollectionUtil.toMapWithStringKeys(map);

    // Assert
    assertEquals(1, actualToMapWithStringKeysResult.size());
    assertEquals("42", actualToMapWithStringKeysResult.get("java.lang.Object"));
  }

  /**
   * Method under test: {@link CollectionUtil#toMapWithStringKeys(Map, Map)}
   */
  @Test
  void testToMapWithStringKeys4() {
    // Arrange
    HashMap<Class<?>, Object> map = new HashMap<>();
    HashMap<String, Object> mapAsStrings = new HashMap<>();

    // Act
    CollectionUtil.toMapWithStringKeys(map, mapAsStrings);

    // Assert that nothing has changed
    assertTrue(mapAsStrings.isEmpty());
  }

  /**
   * Method under test: {@link CollectionUtil#toMapWithStringKeys(Map, Map)}
   */
  @Test
  void testToMapWithStringKeys5() {
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
   * Method under test: {@link CollectionUtil#toMapWithStringKeys(Map, Map)}
   */
  @Test
  void testToMapWithStringKeys6() {
    // Arrange
    HashMap<Class<?>, Object> map = new HashMap<>();
    Class<Object> forNameResult = Object.class;
    map.computeIfPresent(forNameResult, mock(BiFunction.class));
    Class<Object> forNameResult2 = Object.class;
    map.put(forNameResult2, "42");
    HashMap<String, Object> mapAsStrings = new HashMap<>();

    // Act
    CollectionUtil.toMapWithStringKeys(map, mapAsStrings);

    // Assert
    assertEquals(1, mapAsStrings.size());
    assertEquals("42", mapAsStrings.get("java.lang.Object"));
  }

  /**
   * Method under test: {@link CollectionUtil#containsAny(Collection, Object[])}
   */
  @Test
  void testContainsAny() {
    // Arrange, Act and Assert
    assertFalse(CollectionUtil.containsAny(new ArrayList<>(), "Objects"));
    assertFalse(CollectionUtil.containsAny(null, null));
    assertFalse(CollectionUtil.containsAny(new ArrayList<>(), null));
  }

  /**
   * Method under test: {@link CollectionUtil#containsAny(Collection, Object[])}
   */
  @Test
  void testContainsAny2() {
    // Arrange
    ArrayList<Object> collection = new ArrayList<>();
    collection.add("42");

    // Act and Assert
    assertFalse(CollectionUtil.containsAny(collection, "Objects"));
  }

  /**
   * Method under test: {@link CollectionUtil#containsAny(Collection, Object[])}
   */
  @Test
  void testContainsAny3() {
    // Arrange
    ArrayList<Object> collection = new ArrayList<>();
    collection.add("42");
    collection.add("42");

    // Act and Assert
    assertFalse(CollectionUtil.containsAny(collection, "Objects"));
  }

  /**
   * Method under test: {@link CollectionUtil#containsAny(Collection, Object[])}
   */
  @Test
  void testContainsAny4() {
    // Arrange
    ArrayList<Object> collection = new ArrayList<>();
    collection.add("42");

    // Act and Assert
    assertTrue(CollectionUtil.containsAny(collection, "42"));
  }

  /**
   * Method under test: {@link CollectionUtil#anyMissing(Collection, Object[])}
   */
  @Test
  void testAnyMissing() {
    // Arrange, Act and Assert
    assertTrue(CollectionUtil.anyMissing(new ArrayList<>(), "Objects"));
    assertFalse(CollectionUtil.anyMissing(null, null));
    assertFalse(CollectionUtil.anyMissing(new ArrayList<>()));
  }

  /**
   * Method under test: {@link CollectionUtil#anyMissing(Collection, Object[])}
   */
  @Test
  void testAnyMissing2() {
    // Arrange
    ArrayList<Object> collection = new ArrayList<>();
    collection.add("42");

    // Act and Assert
    assertTrue(CollectionUtil.anyMissing(collection, "Objects"));
  }

  /**
   * Method under test: {@link CollectionUtil#anyMissing(Collection, Object[])}
   */
  @Test
  void testAnyMissing3() {
    // Arrange
    ArrayList<Object> collection = new ArrayList<>();
    collection.add("42");
    collection.add("42");

    // Act and Assert
    assertTrue(CollectionUtil.anyMissing(collection, "Objects"));
  }

  /**
   * Method under test: {@link CollectionUtil#anyMissing(Collection, Object[])}
   */
  @Test
  void testAnyMissing4() {
    // Arrange
    ArrayList<Object> collection = new ArrayList<>();
    collection.add("42");

    // Act and Assert
    assertFalse(CollectionUtil.anyMissing(collection, "42"));
  }

  /**
   * Method under test: {@link CollectionUtil#anyMissing(Collection, Object[])}
   */
  @Test
  void testAnyMissing5() {
    // Arrange
    HashSet<Object> collection = new HashSet<>();
    collection.add("42");

    // Act and Assert
    assertFalse(CollectionUtil.anyMissing(collection, null));
  }

  /**
   * Method under test: {@link CollectionUtil#distinct(Collection)}
   */
  @Test
  void testDistinct() {
    // Arrange, Act and Assert
    assertTrue(CollectionUtil.distinct(new ArrayList<>()));
  }

  /**
   * Method under test: {@link CollectionUtil#distinct(Collection)}
   */
  @Test
  void testDistinct2() {
    // Arrange
    ArrayList<Object> collection = new ArrayList<>();
    collection.add("42");

    // Act and Assert
    assertTrue(CollectionUtil.distinct(collection));
  }

  /**
   * Method under test: {@link CollectionUtil#distinct(Collection)}
   */
  @Test
  void testDistinct3() {
    // Arrange
    ArrayList<Object> collection = new ArrayList<>();
    collection.add("42");
    collection.add("42");

    // Act and Assert
    assertFalse(CollectionUtil.distinct(collection));
  }
}
