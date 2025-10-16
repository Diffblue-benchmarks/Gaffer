package uk.gov.gchq.gaffer.mapstore.utils;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class MapWrapperDiffblueTest {
  /**
   * Test {@link MapWrapper#MapWrapper(Map)}.
   *
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link MapWrapper#MapWrapper(Map)}
   */
  @Test
  @DisplayName("Test new MapWrapper(Map); when HashMap(); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MapWrapper.<init>(Map)"})
  void testNewMapWrapper_whenHashMap_thenReturnEmpty() {
    // Arrange and Act
    MapWrapper<Object, Object> actualObjectObjectMap = new MapWrapper<>(new HashMap<>());

    // Assert
    assertTrue(actualObjectObjectMap.isEmpty());
  }

  /**
   * Test {@link MapWrapper#MapWrapper(Map)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link MapWrapper#MapWrapper(Map)}
   */
  @Test
  @DisplayName("Test new MapWrapper(Map); when 'null'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MapWrapper.<init>(Map)"})
  void testNewMapWrapper_whenNull_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> new MapWrapper<>(null));
  }

  /**
   * Test {@link MapWrapper#containsKey(Object)}.
   *
   * <ul>
   *   <li>Given {@link MapWrapper#MapWrapper(Map)} with map is {@link HashMap#HashMap()} {@code
   *       Key} is {@code Value}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link MapWrapper#containsKey(Object)}
   */
  @Test
  @DisplayName(
      "Test containsKey(Object); given MapWrapper(Map) with map is HashMap() 'Key' is 'Value'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MapWrapper.containsKey(Object)"})
  void testContainsKey_givenMapWrapperWithMapIsHashMapKeyIsValue_thenReturnTrue() {
    // Arrange
    MapWrapper<Object, Object> objectObjectMap = new MapWrapper<>(new HashMap<>());
    objectObjectMap.put("Key", "Value");

    // Act and Assert
    assertTrue(objectObjectMap.containsKey("Key"));
  }

  /**
   * Test {@link MapWrapper#containsKey(Object)}.
   *
   * <ul>
   *   <li>Given {@link MapWrapper#MapWrapper(Map)} with map is {@link HashMap#HashMap()}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link MapWrapper#containsKey(Object)}
   */
  @Test
  @DisplayName(
      "Test containsKey(Object); given MapWrapper(Map) with map is HashMap(); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MapWrapper.containsKey(Object)"})
  void testContainsKey_givenMapWrapperWithMapIsHashMap_thenReturnFalse() {
    // Arrange
    MapWrapper<Object, Object> objectObjectMap = new MapWrapper<>(new HashMap<>());

    // Act and Assert
    assertFalse(objectObjectMap.containsKey("Key"));
  }

  /**
   * Test {@link MapWrapper#containsValue(Object)}.
   *
   * <ul>
   *   <li>Given {@link MapWrapper#MapWrapper(Map)} with map is {@link HashMap#HashMap()} {@code
   *       Key} is {@code Value}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link MapWrapper#containsValue(Object)}
   */
  @Test
  @DisplayName(
      "Test containsValue(Object); given MapWrapper(Map) with map is HashMap() 'Key' is 'Value'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MapWrapper.containsValue(Object)"})
  void testContainsValue_givenMapWrapperWithMapIsHashMapKeyIsValue_thenReturnTrue() {
    // Arrange
    HashMap<Object, Object> map = new HashMap<>();
    map.put("Map", "Map");

    MapWrapper<Object, Object> objectObjectMap = new MapWrapper<>(map);
    objectObjectMap.put("Key", "Value");

    // Act and Assert
    assertTrue(objectObjectMap.containsValue("Value"));
  }

  /**
   * Test {@link MapWrapper#containsValue(Object)}.
   *
   * <ul>
   *   <li>Given {@link MapWrapper#MapWrapper(Map)} with map is {@link HashMap#HashMap()}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link MapWrapper#containsValue(Object)}
   */
  @Test
  @DisplayName(
      "Test containsValue(Object); given MapWrapper(Map) with map is HashMap(); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MapWrapper.containsValue(Object)"})
  void testContainsValue_givenMapWrapperWithMapIsHashMap_thenReturnFalse() {
    // Arrange
    HashMap<Object, Object> map = new HashMap<>();
    map.put("Map", "Map");
    MapWrapper<Object, Object> objectObjectMap = new MapWrapper<>(map);

    // Act and Assert
    assertFalse(objectObjectMap.containsValue("Value"));
  }

  /**
   * Test {@link MapWrapper#getAll(Set)}.
   *
   * <p>Method under test: {@link MapWrapper#getAll(Set)}
   */
  @Test
  @DisplayName("Test getAll(Set)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map MapWrapper.getAll(Set)"})
  void testGetAll() {
    // Arrange
    MapWrapper<Object, Object> objectObjectMap = new MapWrapper<>(new HashMap<>());

    // Act and Assert
    assertTrue(objectObjectMap.getAll(new HashSet<>()).isEmpty());
  }

  /**
   * Test {@link MapWrapper#put(Object, Object)}.
   *
   * <p>Method under test: {@link MapWrapper#put(Object, Object)}
   */
  @Test
  @DisplayName("Test put(Object, Object)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object MapWrapper.put(Object, Object)"})
  void testPut() {
    // Arrange
    MapWrapper<Object, Object> objectObjectMap = new MapWrapper<>(new HashMap<>());

    // Act
    Object actualPutResult = objectObjectMap.put("Key", "Value");

    // Assert
    assertEquals(1, objectObjectMap.size());
    assertEquals("Value", objectObjectMap.get("Key"));
    assertNull(actualPutResult);
  }

  /**
   * Test {@link MapWrapper#remove(Object)} with {@code Object}.
   *
   * <p>Method under test: {@link MapWrapper#remove(Object)}
   */
  @Test
  @DisplayName("Test remove(Object) with 'Object'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object MapWrapper.remove(Object)"})
  void testRemoveWithObject() {
    // Arrange
    MapWrapper<Object, Object> objectObjectMap = new MapWrapper<>(new HashMap<>());

    // Act and Assert
    assertNull(objectObjectMap.remove("Key"));
  }

  /**
   * Test {@link MapWrapper#getMap()}.
   *
   * <p>Method under test: {@link MapWrapper#getMap()}
   */
  @Test
  @DisplayName("Test getMap()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map MapWrapper.getMap()"})
  void testGetMap() {
    // Arrange
    HashMap<Object, Object> map = new HashMap<>();
    MapWrapper<Object, Object> objectObjectMap = new MapWrapper<>(map);

    // Act
    Map<Object, Object> actualMap = objectObjectMap.getMap();

    // Assert
    assertTrue(actualMap.isEmpty());
    assertSame(map, actualMap);
  }
}
