package uk.gov.gchq.gaffer.cache.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.Collection;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class HashMapCacheDiffblueTest {
  /**
   * Test {@link HashMapCache#HashMapCache()}.
   *
   * <p>Method under test: {@link HashMapCache#HashMapCache()}
   */
  @Test
  @DisplayName("Test new HashMapCache()")
  @Tag("MaintainedByDiffblue")
  void testNewHashMapCache() {
    // Arrange and Act
    HashMapCache<Object, Object> actualHashMapCache = new HashMapCache<>();

    // Assert
    assertEquals(0, actualHashMapCache.size());
    assertTrue(actualHashMapCache.getAllValues().isEmpty());
    assertTrue(actualHashMapCache.getAllKeys().isEmpty());
  }

  /**
   * Test {@link HashMapCache#HashMapCache(boolean)}.
   *
   * <ul>
   *   <li>When {@code true}.
   *   <li>Then AllValues return {@link List}.
   * </ul>
   *
   * <p>Method under test: {@link HashMapCache#HashMapCache(boolean)}
   */
  @Test
  @DisplayName("Test new HashMapCache(boolean); when 'true'; then AllValues return List")
  @Tag("MaintainedByDiffblue")
  void testNewHashMapCache_whenTrue_thenAllValuesReturnList() {
    // Arrange and Act
    HashMapCache<Object, Object> actualHashMapCache = new HashMapCache<>(true);

    // Assert
    Collection<Object> allValues = actualHashMapCache.getAllValues();
    assertTrue(allValues instanceof List);
    assertEquals(0, actualHashMapCache.size());
    assertTrue(allValues.isEmpty());
    assertTrue(actualHashMapCache.getAllKeys().isEmpty());
  }

  /**
   * Test {@link HashMapCache#get(Object)}.
   *
   * <ul>
   *   <li>Given {@link HashMapCache#HashMapCache(boolean)} with useJavaSerialisation is {@code
   *       false}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link HashMapCache#get(Object)}
   */
  @Test
  @DisplayName(
      "Test get(Object); given HashMapCache(boolean) with useJavaSerialisation is 'false'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  void testGet_givenHashMapCacheWithUseJavaSerialisationIsFalse_thenReturnNull() {
    // Arrange
    HashMapCache<Object, Object> hashMapCache = new HashMapCache<>(false);

    // Act and Assert
    assertNull(hashMapCache.get("Key"));
  }

  /**
   * Test {@link HashMapCache#get(Object)}.
   *
   * <ul>
   *   <li>Then return {@code Value}.
   * </ul>
   *
   * <p>Method under test: {@link HashMapCache#get(Object)}
   */
  @Test
  @DisplayName("Test get(Object); then return 'Value'")
  @Tag("MaintainedByDiffblue")
  void testGet_thenReturnValue() {
    // Arrange
    HashMapCache<Object, Object> hashMapCache = new HashMapCache<>(true);
    hashMapCache.put("Key", "Value");

    // Act and Assert
    assertEquals("Value", hashMapCache.get("Key"));
  }

  /**
   * Test {@link HashMapCache#put(Object, Object)}.
   *
   * <ul>
   *   <li>Then {@link HashMapCache#HashMapCache(boolean)} with useJavaSerialisation is {@code
   *       false} AllValues size is one.
   * </ul>
   *
   * <p>Method under test: {@link HashMapCache#put(Object, Object)}
   */
  @Test
  @DisplayName(
      "Test put(Object, Object); then HashMapCache(boolean) with useJavaSerialisation is 'false' AllValues size is one")
  @Tag("MaintainedByDiffblue")
  void testPut_thenHashMapCacheWithUseJavaSerialisationIsFalseAllValuesSizeIsOne() {
    // Arrange
    HashMapCache<Object, Object> hashMapCache = new HashMapCache<>(false);

    // Act
    hashMapCache.put("Key", "Value");

    // Assert
    assertEquals(1, hashMapCache.getAllValues().size());
    assertEquals(1, hashMapCache.getAllKeys().size());
    assertEquals(1, hashMapCache.size());
  }

  /**
   * Test {@link HashMapCache#put(Object, Object)}.
   *
   * <ul>
   *   <li>Then {@link HashMapCache#HashMapCache(boolean)} with useJavaSerialisation is {@code true}
   *       AllValues size is one.
   * </ul>
   *
   * <p>Method under test: {@link HashMapCache#put(Object, Object)}
   */
  @Test
  @DisplayName(
      "Test put(Object, Object); then HashMapCache(boolean) with useJavaSerialisation is 'true' AllValues size is one")
  @Tag("MaintainedByDiffblue")
  void testPut_thenHashMapCacheWithUseJavaSerialisationIsTrueAllValuesSizeIsOne() {
    // Arrange
    HashMapCache<Object, Object> hashMapCache = new HashMapCache<>(true);

    // Act
    hashMapCache.put("Key", "Value");

    // Assert
    Collection<Object> allValues = hashMapCache.getAllValues();
    assertEquals(1, allValues.size());
    assertTrue(allValues instanceof List);
    assertEquals("Value", ((List<Object>) allValues).get(0));
    assertEquals(1, hashMapCache.getAllKeys().size());
    assertEquals(1, hashMapCache.size());
  }

  /**
   * Test {@link HashMapCache#getAllValues()}.
   *
   * <ul>
   *   <li>Given {@link HashMapCache#HashMapCache(boolean)} with useJavaSerialisation is {@code
   *       false}.
   * </ul>
   *
   * <p>Method under test: {@link HashMapCache#getAllValues()}
   */
  @Test
  @DisplayName(
      "Test getAllValues(); given HashMapCache(boolean) with useJavaSerialisation is 'false'")
  @Tag("MaintainedByDiffblue")
  void testGetAllValues_givenHashMapCacheWithUseJavaSerialisationIsFalse() {
    // Arrange
    HashMapCache<Object, Object> hashMapCache = new HashMapCache<>(false);

    // Act and Assert
    assertTrue(hashMapCache.getAllValues().isEmpty());
  }

  /**
   * Test {@link HashMapCache#getAllValues()}.
   *
   * <ul>
   *   <li>Given {@link HashMapCache#HashMapCache(boolean)} with useJavaSerialisation is {@code
   *       true}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link HashMapCache#getAllValues()}
   */
  @Test
  @DisplayName(
      "Test getAllValues(); given HashMapCache(boolean) with useJavaSerialisation is 'true'; then return Empty")
  @Tag("MaintainedByDiffblue")
  void testGetAllValues_givenHashMapCacheWithUseJavaSerialisationIsTrue_thenReturnEmpty() {
    // Arrange
    HashMapCache<Object, Object> hashMapCache = new HashMapCache<>(true);

    // Act
    Collection<Object> actualAllValues = hashMapCache.getAllValues();

    // Assert
    assertTrue(actualAllValues instanceof List);
    assertTrue(actualAllValues.isEmpty());
  }

  /**
   * Test {@link HashMapCache#getAllValues()}.
   *
   * <ul>
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link HashMapCache#getAllValues()}
   */
  @Test
  @DisplayName("Test getAllValues(); then return size is one")
  @Tag("MaintainedByDiffblue")
  void testGetAllValues_thenReturnSizeIsOne() {
    // Arrange
    HashMapCache<Object, Object> hashMapCache = new HashMapCache<>(true);
    hashMapCache.put("Key", "Value");

    // Act
    Collection<Object> actualAllValues = hashMapCache.getAllValues();

    // Assert
    assertTrue(actualAllValues instanceof List);
    assertEquals(1, actualAllValues.size());
    assertEquals("Value", ((List<Object>) actualAllValues).get(0));
  }

  /**
   * Test {@link HashMapCache#getAllValues()}.
   *
   * <ul>
   *   <li>Then return size is two.
   * </ul>
   *
   * <p>Method under test: {@link HashMapCache#getAllValues()}
   */
  @Test
  @DisplayName("Test getAllValues(); then return size is two")
  @Tag("MaintainedByDiffblue")
  void testGetAllValues_thenReturnSizeIsTwo() {
    // Arrange
    HashMapCache<Object, Object> hashMapCache = new HashMapCache<>(true);
    hashMapCache.put(42, "Value");
    hashMapCache.put("Key", "Value");

    // Act
    Collection<Object> actualAllValues = hashMapCache.getAllValues();

    // Assert
    assertTrue(actualAllValues instanceof List);
    assertEquals(2, actualAllValues.size());
    assertEquals("Value", ((List<Object>) actualAllValues).get(0));
    assertEquals("Value", ((List<Object>) actualAllValues).get(1));
  }

  /**
   * Test {@link HashMapCache#getAllKeys()}.
   *
   * <p>Method under test: {@link HashMapCache#getAllKeys()}
   */
  @Test
  @DisplayName("Test getAllKeys()")
  @Tag("MaintainedByDiffblue")
  void testGetAllKeys() {
    // Arrange
    HashMapCache<Object, Object> hashMapCache = new HashMapCache<>(true);

    // Act and Assert
    assertTrue(hashMapCache.getAllKeys().isEmpty());
  }

  /**
   * Test {@link HashMapCache#size()}.
   *
   * <p>Method under test: {@link HashMapCache#size()}
   */
  @Test
  @DisplayName("Test size()")
  @Tag("MaintainedByDiffblue")
  void testSize() {
    // Arrange
    HashMapCache<Object, Object> hashMapCache = new HashMapCache<>(true);

    // Act and Assert
    assertEquals(0, hashMapCache.size());
  }
}
