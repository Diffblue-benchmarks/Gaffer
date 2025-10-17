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

package uk.gov.gchq.gaffer.types;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Function;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import uk.gov.gchq.gaffer.commonutil.pair.Pair;
import uk.gov.gchq.gaffer.serialisation.AvroSerialiser;
import uk.gov.gchq.gaffer.serialisation.ToBytesSerialiser;
import uk.gov.gchq.gaffer.serialisation.implementation.JavaSerialiser;
import uk.gov.gchq.gaffer.serialisation.implementation.MultiSerialiser;

class CustomMapDiffblueTest {
  /**
   * Test {@link CustomMap#CustomMap(ToBytesSerialiser, ToBytesSerialiser, Map)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link HashMap#HashMap()} {@code 42} is {@code 42}.
   *   <li>Then return JsonStorage size is one.
   * </ul>
   *
   * <p>Method under test: {@link CustomMap#CustomMap(ToBytesSerialiser, ToBytesSerialiser, Map)}
   */
  @Test
  @DisplayName(
      "Test new CustomMap(ToBytesSerialiser, ToBytesSerialiser, Map); given '42'; when HashMap() '42' is '42'; then return JsonStorage size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CustomMap.<init>(ToBytesSerialiser, ToBytesSerialiser, Map)"})
  void testNewCustomMap_given42_whenHashMap42Is42_thenReturnJsonStorageSizeIsOne() {
    // Arrange
    AvroSerialiser keySerialiser = new AvroSerialiser();
    AvroSerialiser valueSerialiser = new AvroSerialiser();

    HashMap<Object, Object> storageMap = new HashMap<>();
    storageMap.put("42", "42");

    // Act
    CustomMap<Object, Object> actualCustomMap =
        new CustomMap<>(keySerialiser, valueSerialiser, storageMap);

    // Assert
    ToBytesSerialiser<? super Object> keySerialiser2 = actualCustomMap.getKeySerialiser();
    assertTrue(keySerialiser2 instanceof AvroSerialiser);
    assertEquals(1, actualCustomMap.getJsonStorage().size());
    assertEquals(1, actualCustomMap.size());
    assertFalse(keySerialiser2.isConsistent());
    assertFalse(actualCustomMap.isEmpty());
    assertEquals(storageMap, actualCustomMap.getMap());
    assertSame(keySerialiser, keySerialiser2);
    assertSame(valueSerialiser, actualCustomMap.getValueSerialiser());
  }

  /**
   * Test {@link CustomMap#CustomMap(ToBytesSerialiser, ToBytesSerialiser, Map)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link HashMap#HashMap()} {@code 42} is {@code 42}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link CustomMap#CustomMap(ToBytesSerialiser, ToBytesSerialiser, Map)}
   */
  @Test
  @DisplayName(
      "Test new CustomMap(ToBytesSerialiser, ToBytesSerialiser, Map); given '42'; when HashMap() '42' is '42'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CustomMap.<init>(ToBytesSerialiser, ToBytesSerialiser, Map)"})
  void testNewCustomMap_given42_whenHashMap42Is42_thenThrowIllegalArgumentException() {
    // Arrange
    MultiSerialiser keySerialiser = new MultiSerialiser();
    AvroSerialiser valueSerialiser = new AvroSerialiser();

    HashMap<Object, Object> storageMap = new HashMap<>();
    storageMap.put("42", "42");

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> new CustomMap<>(keySerialiser, valueSerialiser, storageMap));
  }

  /**
   * Test {@link CustomMap#CustomMap(ToBytesSerialiser, ToBytesSerialiser, Map)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link HashMap#HashMap()} {@code 42} is {@code 42}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link CustomMap#CustomMap(ToBytesSerialiser, ToBytesSerialiser, Map)}
   */
  @Test
  @DisplayName(
      "Test new CustomMap(ToBytesSerialiser, ToBytesSerialiser, Map); given '42'; when HashMap() '42' is '42'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CustomMap.<init>(ToBytesSerialiser, ToBytesSerialiser, Map)"})
  void testNewCustomMap_given42_whenHashMap42Is42_thenThrowIllegalArgumentException2() {
    // Arrange
    AvroSerialiser keySerialiser = new AvroSerialiser();
    MultiSerialiser valueSerialiser = new MultiSerialiser();

    HashMap<Object, Object> storageMap = new HashMap<>();
    storageMap.put("42", "42");

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> new CustomMap<>(keySerialiser, valueSerialiser, storageMap));
  }

  /**
   * Test {@link CustomMap#CustomMap(ToBytesSerialiser, ToBytesSerialiser, Map)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link HashMap#HashMap()} {@code 42} is {@code 42}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link CustomMap#CustomMap(ToBytesSerialiser, ToBytesSerialiser, Map)}
   */
  @Test
  @DisplayName(
      "Test new CustomMap(ToBytesSerialiser, ToBytesSerialiser, Map); given '42'; when HashMap() '42' is '42'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CustomMap.<init>(ToBytesSerialiser, ToBytesSerialiser, Map)"})
  void testNewCustomMap_given42_whenHashMap42Is42_thenThrowIllegalArgumentException3() {
    // Arrange
    MultiSerialiser keySerialiser = new MultiSerialiser();
    MultiSerialiser valueSerialiser = new MultiSerialiser();

    HashMap<Object, Object> storageMap = new HashMap<>();
    storageMap.put("42", "42");

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> new CustomMap<>(keySerialiser, valueSerialiser, storageMap));
  }

  /**
   * Test {@link CustomMap#CustomMap(ToBytesSerialiser, ToBytesSerialiser, Map)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link HashMap#HashMap()} {@code 42} is {@code null}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link CustomMap#CustomMap(ToBytesSerialiser, ToBytesSerialiser, Map)}
   */
  @Test
  @DisplayName(
      "Test new CustomMap(ToBytesSerialiser, ToBytesSerialiser, Map); given 'null'; when HashMap() '42' is 'null'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CustomMap.<init>(ToBytesSerialiser, ToBytesSerialiser, Map)"})
  void testNewCustomMap_givenNull_whenHashMap42IsNull_thenThrowIllegalArgumentException() {
    // Arrange
    AvroSerialiser keySerialiser = new AvroSerialiser();
    MultiSerialiser valueSerialiser = new MultiSerialiser();

    HashMap<Object, Object> storageMap = new HashMap<>();
    storageMap.put("42", null);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> new CustomMap<>(keySerialiser, valueSerialiser, storageMap));
  }

  /**
   * Test {@link CustomMap#CustomMap(ToBytesSerialiser, ToBytesSerialiser, Map)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link HashMap#HashMap()} {@code null} is {@code 42}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link CustomMap#CustomMap(ToBytesSerialiser, ToBytesSerialiser, Map)}
   */
  @Test
  @DisplayName(
      "Test new CustomMap(ToBytesSerialiser, ToBytesSerialiser, Map); given 'null'; when HashMap() 'null' is '42'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CustomMap.<init>(ToBytesSerialiser, ToBytesSerialiser, Map)"})
  void testNewCustomMap_givenNull_whenHashMapNullIs42_thenThrowIllegalArgumentException() {
    // Arrange
    MultiSerialiser keySerialiser = new MultiSerialiser();
    AvroSerialiser valueSerialiser = new AvroSerialiser();

    HashMap<Object, Object> storageMap = new HashMap<>();
    storageMap.put(null, "42");

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> new CustomMap<>(keySerialiser, valueSerialiser, storageMap));
  }

  /**
   * Test {@link CustomMap#CustomMap(ToBytesSerialiser, ToBytesSerialiser, HashSet)}.
   *
   * <ul>
   *   <li>Given {@link Pair#Pair(Object, Object)} with {@code First} and {@code Second}.
   * </ul>
   *
   * <p>Method under test: {@link CustomMap#CustomMap(ToBytesSerialiser, ToBytesSerialiser,
   * HashSet)}
   */
  @Test
  @DisplayName(
      "Test new CustomMap(ToBytesSerialiser, ToBytesSerialiser, HashSet); given Pair(Object, Object) with 'First' and 'Second'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CustomMap.<init>(ToBytesSerialiser, ToBytesSerialiser, HashSet)"})
  void testNewCustomMap_givenPairWithFirstAndSecond() {
    // Arrange
    AvroSerialiser keySerialiser = new AvroSerialiser();
    AvroSerialiser valueSerialiser = new AvroSerialiser();

    Pair<Object, Object> pair = new Pair<>(new Pair<>("First", "Second"), "Second");
    pair.setSecond(1);

    LinkedHashSet<Pair<Object, Object>> interimPairs = new LinkedHashSet<>();
    interimPairs.add(pair);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> new CustomMap<>(keySerialiser, valueSerialiser, interimPairs));
  }

  /**
   * Test {@link CustomMap#CustomMap(ToBytesSerialiser, ToBytesSerialiser, HashSet)}.
   *
   * <ul>
   *   <li>Given {@link Pair#Pair(Object, Object)} with {@code First} and {@code Second} Second is
   *       one.
   *   <li>Then return Map size is one.
   * </ul>
   *
   * <p>Method under test: {@link CustomMap#CustomMap(ToBytesSerialiser, ToBytesSerialiser,
   * HashSet)}
   */
  @Test
  @DisplayName(
      "Test new CustomMap(ToBytesSerialiser, ToBytesSerialiser, HashSet); given Pair(Object, Object) with 'First' and 'Second' Second is one; then return Map size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CustomMap.<init>(ToBytesSerialiser, ToBytesSerialiser, HashSet)"})
  void testNewCustomMap_givenPairWithFirstAndSecondSecondIsOne_thenReturnMapSizeIsOne() {
    // Arrange
    AvroSerialiser keySerialiser = new AvroSerialiser();
    AvroSerialiser valueSerialiser = new AvroSerialiser();

    Pair<Object, Object> pair = new Pair<>("First", "Second");
    pair.setSecond(1);

    LinkedHashSet<Pair<Object, Object>> interimPairs = new LinkedHashSet<>();
    interimPairs.add(pair);

    // Act
    CustomMap<Object, Object> actualCustomMap =
        new CustomMap<>(keySerialiser, valueSerialiser, interimPairs);

    // Assert
    assertTrue(actualCustomMap.getValueSerialiser() instanceof AvroSerialiser);
    HashMap<Object, Object> map = actualCustomMap.getMap();
    assertEquals(1, map.size());
    assertEquals(1, ((Integer) map.get("First")).intValue());
    assertEquals(1, actualCustomMap.size());
    assertFalse(actualCustomMap.isEmpty());
    assertEquals(interimPairs, actualCustomMap.getJsonStorage());
  }

  /**
   * Test {@link CustomMap#CustomMap(ToBytesSerialiser, ToBytesSerialiser, HashSet)}.
   *
   * <ul>
   *   <li>Given {@link Pair#Pair(Object, Object)} with {@code First} and {@code Second} Second is
   *       {@link Pair#Pair()}.
   * </ul>
   *
   * <p>Method under test: {@link CustomMap#CustomMap(ToBytesSerialiser, ToBytesSerialiser,
   * HashSet)}
   */
  @Test
  @DisplayName(
      "Test new CustomMap(ToBytesSerialiser, ToBytesSerialiser, HashSet); given Pair(Object, Object) with 'First' and 'Second' Second is Pair()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CustomMap.<init>(ToBytesSerialiser, ToBytesSerialiser, HashSet)"})
  void testNewCustomMap_givenPairWithFirstAndSecondSecondIsPair() {
    // Arrange
    AvroSerialiser keySerialiser = new AvroSerialiser();
    AvroSerialiser valueSerialiser = new AvroSerialiser();

    Pair<Object, Object> pair = new Pair<>("First", "Second");
    pair.setSecond(new Pair<>());

    LinkedHashSet<Pair<Object, Object>> interimPairs = new LinkedHashSet<>();
    interimPairs.add(pair);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> new CustomMap<>(keySerialiser, valueSerialiser, interimPairs));
  }

  /**
   * Test {@link CustomMap#CustomMap(ToBytesSerialiser, ToBytesSerialiser, HashSet)}.
   *
   * <ul>
   *   <li>Given {@link Pair#Pair(Object, Object)} with first is {@link Pair#Pair()} and {@code
   *       Second}.
   * </ul>
   *
   * <p>Method under test: {@link CustomMap#CustomMap(ToBytesSerialiser, ToBytesSerialiser,
   * HashSet)}
   */
  @Test
  @DisplayName(
      "Test new CustomMap(ToBytesSerialiser, ToBytesSerialiser, HashSet); given Pair(Object, Object) with first is Pair() and 'Second'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CustomMap.<init>(ToBytesSerialiser, ToBytesSerialiser, HashSet)"})
  void testNewCustomMap_givenPairWithFirstIsPairAndSecond() {
    // Arrange
    AvroSerialiser keySerialiser = new AvroSerialiser();
    AvroSerialiser valueSerialiser = new AvroSerialiser();

    Pair<Object, Object> pair = new Pair<>(new Pair<>(new Pair<>(), "Second"), "Second");
    pair.setSecond(1);

    LinkedHashSet<Pair<Object, Object>> interimPairs = new LinkedHashSet<>();
    interimPairs.add(pair);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> new CustomMap<>(keySerialiser, valueSerialiser, interimPairs));
  }

  /**
   * Test {@link CustomMap#CustomMap(ToBytesSerialiser, ToBytesSerialiser, HashSet)}.
   *
   * <ul>
   *   <li>Given {@link Pair#Pair(Object, Object)} with first is {@link Pair#Pair()} and {@code
   *       Second} Second is one.
   * </ul>
   *
   * <p>Method under test: {@link CustomMap#CustomMap(ToBytesSerialiser, ToBytesSerialiser,
   * HashSet)}
   */
  @Test
  @DisplayName(
      "Test new CustomMap(ToBytesSerialiser, ToBytesSerialiser, HashSet); given Pair(Object, Object) with first is Pair() and 'Second' Second is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CustomMap.<init>(ToBytesSerialiser, ToBytesSerialiser, HashSet)"})
  void testNewCustomMap_givenPairWithFirstIsPairAndSecondSecondIsOne() {
    // Arrange
    AvroSerialiser keySerialiser = new AvroSerialiser();
    AvroSerialiser valueSerialiser = new AvroSerialiser();

    Pair<Object, Object> pair = new Pair<>(new Pair<>(), "Second");
    pair.setSecond(1);

    LinkedHashSet<Pair<Object, Object>> interimPairs = new LinkedHashSet<>();
    interimPairs.add(pair);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> new CustomMap<>(keySerialiser, valueSerialiser, interimPairs));
  }

  /**
   * Test {@link CustomMap#CustomMap(ToBytesSerialiser, ToBytesSerialiser, HashSet)}.
   *
   * <ul>
   *   <li>Given {@link Pair#Pair(Object, Object)} with first is {@link Pair#Pair()} and {@code
   *       Second} Second is {@link Pair#Pair()}.
   * </ul>
   *
   * <p>Method under test: {@link CustomMap#CustomMap(ToBytesSerialiser, ToBytesSerialiser,
   * HashSet)}
   */
  @Test
  @DisplayName(
      "Test new CustomMap(ToBytesSerialiser, ToBytesSerialiser, HashSet); given Pair(Object, Object) with first is Pair() and 'Second' Second is Pair()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CustomMap.<init>(ToBytesSerialiser, ToBytesSerialiser, HashSet)"})
  void testNewCustomMap_givenPairWithFirstIsPairAndSecondSecondIsPair() {
    // Arrange
    AvroSerialiser keySerialiser = new AvroSerialiser();
    AvroSerialiser valueSerialiser = new AvroSerialiser();

    Pair<Object, Object> pair = new Pair<>(new Pair<>(), "Second");
    pair.setSecond(new Pair<>());

    LinkedHashSet<Pair<Object, Object>> interimPairs = new LinkedHashSet<>();
    interimPairs.add(pair);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> new CustomMap<>(keySerialiser, valueSerialiser, interimPairs));
  }

  /**
   * Test {@link CustomMap#CustomMap(ToBytesSerialiser, ToBytesSerialiser)}.
   *
   * <ul>
   *   <li>When {@link AvroSerialiser} (default constructor).
   *   <li>Then KeySerialiser return {@link AvroSerialiser}.
   * </ul>
   *
   * <p>Method under test: {@link CustomMap#CustomMap(ToBytesSerialiser, ToBytesSerialiser)}
   */
  @Test
  @DisplayName(
      "Test new CustomMap(ToBytesSerialiser, ToBytesSerialiser); when AvroSerialiser (default constructor); then KeySerialiser return AvroSerialiser")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CustomMap.<init>(ToBytesSerialiser, ToBytesSerialiser)"})
  void testNewCustomMap_whenAvroSerialiser_thenKeySerialiserReturnAvroSerialiser() {
    // Arrange
    AvroSerialiser keySerialiser = new AvroSerialiser();
    AvroSerialiser valueSerialiser = new AvroSerialiser();

    // Act
    CustomMap<Object, Object> actualCustomMap = new CustomMap<>(keySerialiser, valueSerialiser);

    // Assert
    ToBytesSerialiser<? super Object> keySerialiser2 = actualCustomMap.getKeySerialiser();
    assertTrue(keySerialiser2 instanceof AvroSerialiser);
    assertEquals(0, actualCustomMap.size());
    assertFalse(keySerialiser2.isConsistent());
    assertTrue(actualCustomMap.getMap().isEmpty());
    assertTrue(actualCustomMap.getJsonStorage().isEmpty());
    assertTrue(actualCustomMap.isEmpty());
    assertSame(keySerialiser, keySerialiser2);
    assertSame(valueSerialiser, actualCustomMap.getValueSerialiser());
  }

  /**
   * Test {@link CustomMap#CustomMap(ToBytesSerialiser, ToBytesSerialiser, Map)}.
   *
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.
   *   <li>Then return size is zero.
   * </ul>
   *
   * <p>Method under test: {@link CustomMap#CustomMap(ToBytesSerialiser, ToBytesSerialiser, Map)}
   */
  @Test
  @DisplayName(
      "Test new CustomMap(ToBytesSerialiser, ToBytesSerialiser, Map); when HashMap(); then return size is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CustomMap.<init>(ToBytesSerialiser, ToBytesSerialiser, Map)"})
  void testNewCustomMap_whenHashMap_thenReturnSizeIsZero() {
    // Arrange
    AvroSerialiser keySerialiser = new AvroSerialiser();
    AvroSerialiser valueSerialiser = new AvroSerialiser();
    HashMap<Object, Object> storageMap = new HashMap<>();

    // Act
    CustomMap<Object, Object> actualCustomMap =
        new CustomMap<>(keySerialiser, valueSerialiser, storageMap);

    // Assert
    ToBytesSerialiser<? super Object> keySerialiser2 = actualCustomMap.getKeySerialiser();
    assertTrue(keySerialiser2 instanceof AvroSerialiser);
    assertEquals(0, actualCustomMap.size());
    assertFalse(keySerialiser2.isConsistent());
    assertTrue(actualCustomMap.getJsonStorage().isEmpty());
    assertTrue(actualCustomMap.isEmpty());
    assertEquals(storageMap, actualCustomMap.getMap());
    assertSame(keySerialiser, keySerialiser2);
    assertSame(valueSerialiser, actualCustomMap.getValueSerialiser());
  }

  /**
   * Test {@link CustomMap#CustomMap(ToBytesSerialiser, ToBytesSerialiser, HashSet)}.
   *
   * <ul>
   *   <li>When {@link HashSet#HashSet()}.
   *   <li>Then return size is zero.
   * </ul>
   *
   * <p>Method under test: {@link CustomMap#CustomMap(ToBytesSerialiser, ToBytesSerialiser,
   * HashSet)}
   */
  @Test
  @DisplayName(
      "Test new CustomMap(ToBytesSerialiser, ToBytesSerialiser, HashSet); when HashSet(); then return size is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CustomMap.<init>(ToBytesSerialiser, ToBytesSerialiser, HashSet)"})
  void testNewCustomMap_whenHashSet_thenReturnSizeIsZero() {
    // Arrange
    AvroSerialiser keySerialiser = new AvroSerialiser();
    AvroSerialiser valueSerialiser = new AvroSerialiser();
    HashSet<Pair<Object, Object>> interimPairs = new HashSet<>();

    // Act
    CustomMap<Object, Object> actualCustomMap =
        new CustomMap<>(keySerialiser, valueSerialiser, interimPairs);

    // Assert
    assertTrue(actualCustomMap.getValueSerialiser() instanceof AvroSerialiser);
    assertEquals(0, actualCustomMap.size());
    assertTrue(actualCustomMap.getMap().isEmpty());
    assertTrue(actualCustomMap.isEmpty());
    assertEquals(interimPairs, actualCustomMap.getJsonStorage());
  }

  /**
   * Test {@link CustomMap#constructorValidation(Map)}.
   *
   * <p>Method under test: {@link CustomMap#constructorValidation(Map)}
   */
  @Test
  @DisplayName("Test constructorValidation(Map)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CustomMap.constructorValidation(Map)"})
  void testConstructorValidation() {
    // Arrange
    MultiSerialiser keySerialiser = new MultiSerialiser();
    CustomMap<Object, Object> customMap = new CustomMap<>(keySerialiser, new AvroSerialiser());

    HashMap<Object, Object> storageMap = new HashMap<>();
    storageMap.put("42", "42");

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> customMap.constructorValidation(storageMap));
  }

  /**
   * Test {@link CustomMap#constructorValidation(Map)}.
   *
   * <p>Method under test: {@link CustomMap#constructorValidation(Map)}
   */
  @Test
  @DisplayName("Test constructorValidation(Map)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CustomMap.constructorValidation(Map)"})
  void testConstructorValidation2() {
    // Arrange
    AvroSerialiser keySerialiser = new AvroSerialiser();
    CustomMap<Object, Object> customMap = new CustomMap<>(keySerialiser, new MultiSerialiser());

    HashMap<Object, Object> storageMap = new HashMap<>();
    storageMap.put("42", "42");

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> customMap.constructorValidation(storageMap));
  }

  /**
   * Test {@link CustomMap#constructorValidation(Map)}.
   *
   * <p>Method under test: {@link CustomMap#constructorValidation(Map)}
   */
  @Test
  @DisplayName("Test constructorValidation(Map)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CustomMap.constructorValidation(Map)"})
  void testConstructorValidation3() {
    // Arrange
    MultiSerialiser keySerialiser = new MultiSerialiser();
    CustomMap<Object, Object> customMap = new CustomMap<>(keySerialiser, new MultiSerialiser());

    HashMap<Object, Object> storageMap = new HashMap<>();
    storageMap.put("42", "42");

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> customMap.constructorValidation(storageMap));
  }

  /**
   * Test {@link CustomMap#constructorValidation(Map)}.
   *
   * <p>Method under test: {@link CustomMap#constructorValidation(Map)}
   */
  @Test
  @DisplayName("Test constructorValidation(Map)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CustomMap.constructorValidation(Map)"})
  void testConstructorValidation4() {
    // Arrange
    MultiSerialiser keySerialiser = new MultiSerialiser();
    CustomMap<Object, Object> customMap = new CustomMap<>(keySerialiser, new MultiSerialiser());

    HashMap<Object, Object> storageMap = new HashMap<>();
    storageMap.put("42", null);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> customMap.constructorValidation(storageMap));
  }

  /**
   * Test {@link CustomMap#constructorValidation(Map)}.
   *
   * <ul>
   *   <li>When {@link HashMap#HashMap()} {@code null} is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link CustomMap#constructorValidation(Map)}
   */
  @Test
  @DisplayName("Test constructorValidation(Map); when HashMap() 'null' is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CustomMap.constructorValidation(Map)"})
  void testConstructorValidation_whenHashMapNullIs42() {
    // Arrange
    MultiSerialiser keySerialiser = new MultiSerialiser();
    CustomMap<Object, Object> customMap = new CustomMap<>(keySerialiser, new AvroSerialiser());

    HashMap<Object, Object> storageMap = new HashMap<>();
    storageMap.put(null, "42");

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> customMap.constructorValidation(storageMap));
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link CustomMap#toString()}
   *   <li>{@link CustomMap#getKeySerialiser()}
   *   <li>{@link CustomMap#getMap()}
   *   <li>{@link CustomMap#getValueSerialiser()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ToBytesSerialiser CustomMap.getKeySerialiser()",
    "HashMap CustomMap.getMap()",
    "ToBytesSerialiser CustomMap.getValueSerialiser()",
    "java.lang.String CustomMap.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    AvroSerialiser keySerialiser = new AvroSerialiser();
    AvroSerialiser valueSerialiser = new AvroSerialiser();

    CustomMap<Object, Object> customMap = new CustomMap<>(keySerialiser, valueSerialiser);

    // Act
    customMap.toString();
    ToBytesSerialiser<? super Object> actualKeySerialiser = customMap.getKeySerialiser();
    HashMap<Object, Object> actualMap = customMap.getMap();
    ToBytesSerialiser<? super Object> actualValueSerialiser = customMap.getValueSerialiser();

    // Assert
    assertTrue(actualKeySerialiser instanceof AvroSerialiser);
    assertTrue(actualMap.isEmpty());
    assertSame(keySerialiser, actualKeySerialiser);
    assertSame(valueSerialiser, actualValueSerialiser);
  }

  /**
   * Test {@link CustomMap#getJsonStorage()}.
   *
   * <p>Method under test: {@link CustomMap#getJsonStorage()}
   */
  @Test
  @DisplayName("Test getJsonStorage()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"HashSet CustomMap.getJsonStorage()"})
  void testGetJsonStorage() {
    // Arrange
    AvroSerialiser keySerialiser = new AvroSerialiser();

    CustomMap<Object, Object> customMap = new CustomMap<>(keySerialiser, new AvroSerialiser());
    customMap.put("Key", "Value");

    // Act and Assert
    assertEquals(1, customMap.getJsonStorage().size());
  }

  /**
   * Test {@link CustomMap#getJsonStorage()}.
   *
   * <p>Method under test: {@link CustomMap#getJsonStorage()}
   */
  @Test
  @DisplayName("Test getJsonStorage()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"HashSet CustomMap.getJsonStorage()"})
  void testGetJsonStorage2() {
    // Arrange
    AvroSerialiser keySerialiser = new AvroSerialiser();

    CustomMap<Object, Object> customMap = new CustomMap<>(keySerialiser, new AvroSerialiser());
    customMap.put(0, new Pair<>());
    customMap.put(null, "Value");

    // Act and Assert
    assertEquals(2, customMap.getJsonStorage().size());
  }

  /**
   * Test {@link CustomMap#getJsonStorage()}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link CustomMap#getJsonStorage()}
   */
  @Test
  @DisplayName("Test getJsonStorage(); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"HashSet CustomMap.getJsonStorage()"})
  void testGetJsonStorage_thenReturnEmpty() {
    // Arrange
    AvroSerialiser keySerialiser = new AvroSerialiser();
    CustomMap<Object, Object> customMap = new CustomMap<>(keySerialiser, new AvroSerialiser());

    // Act and Assert
    assertTrue(customMap.getJsonStorage().isEmpty());
  }

  /**
   * Test {@link CustomMap#getJsonStorage()}.
   *
   * <ul>
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link CustomMap#getJsonStorage()}
   */
  @Test
  @DisplayName("Test getJsonStorage(); then return size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"HashSet CustomMap.getJsonStorage()"})
  void testGetJsonStorage_thenReturnSizeIsOne() {
    // Arrange
    AvroSerialiser keySerialiser = new AvroSerialiser();

    CustomMap<Object, Object> customMap = new CustomMap<>(keySerialiser, new AvroSerialiser());
    customMap.put(null, "Value");

    // Act and Assert
    assertEquals(1, customMap.getJsonStorage().size());
  }

  /**
   * Test {@link CustomMap#getJsonStorage()}.
   *
   * <ul>
   *   <li>Then return size is three.
   * </ul>
   *
   * <p>Method under test: {@link CustomMap#getJsonStorage()}
   */
  @Test
  @DisplayName("Test getJsonStorage(); then return size is three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"HashSet CustomMap.getJsonStorage()"})
  void testGetJsonStorage_thenReturnSizeIsThree() {
    // Arrange
    AvroSerialiser keySerialiser = new AvroSerialiser();

    CustomMap<Object, Object> customMap = new CustomMap<>(keySerialiser, new AvroSerialiser());
    customMap.put("", "Value");
    customMap.put(0, "Value");
    customMap.put(null, "Value");

    // Act and Assert
    assertEquals(3, customMap.getJsonStorage().size());
  }

  /**
   * Test {@link CustomMap#getJsonStorage()}.
   *
   * <ul>
   *   <li>Then return size is two.
   * </ul>
   *
   * <p>Method under test: {@link CustomMap#getJsonStorage()}
   */
  @Test
  @DisplayName("Test getJsonStorage(); then return size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"HashSet CustomMap.getJsonStorage()"})
  void testGetJsonStorage_thenReturnSizeIsTwo() {
    // Arrange
    AvroSerialiser keySerialiser = new AvroSerialiser();

    CustomMap<Object, Object> customMap = new CustomMap<>(keySerialiser, new AvroSerialiser());
    customMap.put(0, "Value");
    customMap.put(null, "Value");

    // Act and Assert
    assertEquals(2, customMap.getJsonStorage().size());
  }

  /**
   * Test {@link CustomMap#size()}.
   *
   * <p>Method under test: {@link CustomMap#size()}
   */
  @Test
  @DisplayName("Test size()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int CustomMap.size()"})
  void testSize() {
    // Arrange
    AvroSerialiser keySerialiser = new AvroSerialiser();
    CustomMap<Object, Object> customMap = new CustomMap<>(keySerialiser, new AvroSerialiser());

    // Act and Assert
    assertEquals(0, customMap.size());
  }

  /**
   * Test {@link CustomMap#isEmpty()}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link CustomMap#isEmpty()}
   */
  @Test
  @DisplayName("Test isEmpty(); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CustomMap.isEmpty()"})
  void testIsEmpty_thenReturnFalse() {
    // Arrange
    AvroSerialiser keySerialiser = new AvroSerialiser();

    CustomMap<Object, Object> customMap = new CustomMap<>(keySerialiser, new AvroSerialiser());
    customMap.put("Key", "Value");

    // Act and Assert
    assertFalse(customMap.isEmpty());
  }

  /**
   * Test {@link CustomMap#isEmpty()}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link CustomMap#isEmpty()}
   */
  @Test
  @DisplayName("Test isEmpty(); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CustomMap.isEmpty()"})
  void testIsEmpty_thenReturnTrue() {
    // Arrange
    AvroSerialiser keySerialiser = new AvroSerialiser();
    CustomMap<Object, Object> customMap = new CustomMap<>(keySerialiser, new AvroSerialiser());

    // Act and Assert
    assertTrue(customMap.isEmpty());
  }

  /**
   * Test {@link CustomMap#get(Object)}.
   *
   * <p>Method under test: {@link CustomMap#get(Object)}
   */
  @Test
  @DisplayName("Test get(Object)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object CustomMap.get(Object)"})
  void testGet() {
    // Arrange
    AvroSerialiser keySerialiser = new AvroSerialiser();
    CustomMap<Object, Object> customMap = new CustomMap<>(keySerialiser, new AvroSerialiser());

    // Act and Assert
    assertNull(customMap.get("Key"));
  }

  /**
   * Test {@link CustomMap#containsKey(Object)}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link CustomMap#containsKey(Object)}
   */
  @Test
  @DisplayName("Test containsKey(Object); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CustomMap.containsKey(Object)"})
  void testContainsKey_thenReturnFalse() {
    // Arrange
    AvroSerialiser keySerialiser = new AvroSerialiser();
    CustomMap<Object, Object> customMap = new CustomMap<>(keySerialiser, new AvroSerialiser());

    // Act and Assert
    assertFalse(customMap.containsKey("Key"));
  }

  /**
   * Test {@link CustomMap#containsKey(Object)}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link CustomMap#containsKey(Object)}
   */
  @Test
  @DisplayName("Test containsKey(Object); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CustomMap.containsKey(Object)"})
  void testContainsKey_thenReturnTrue() {
    // Arrange
    AvroSerialiser keySerialiser = new AvroSerialiser();

    CustomMap<Object, Object> customMap = new CustomMap<>(keySerialiser, new AvroSerialiser());
    customMap.put("Key", "Value");

    // Act and Assert
    assertTrue(customMap.containsKey("Key"));
  }

  /**
   * Test {@link CustomMap#put(Object, Object)}.
   *
   * <p>Method under test: {@link CustomMap#put(Object, Object)}
   */
  @Test
  @DisplayName("Test put(Object, Object)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object CustomMap.put(Object, Object)"})
  void testPut() {
    // Arrange
    AvroSerialiser keySerialiser = new AvroSerialiser();
    CustomMap<Object, Object> customMap = new CustomMap<>(keySerialiser, new AvroSerialiser());

    // Act
    Object actualPutResult = customMap.put("Key", "Value");

    // Assert
    HashMap<Object, Object> map = customMap.getMap();
    assertEquals(1, map.size());
    assertEquals("Value", map.get("Key"));
    assertNull(actualPutResult);
    assertEquals(1, customMap.getJsonStorage().size());
    assertEquals(1, customMap.size());
    assertFalse(customMap.isEmpty());
  }

  /**
   * Test {@link CustomMap#remove(Object)} with {@code key}.
   *
   * <p>Method under test: {@link CustomMap#remove(Object)}
   */
  @Test
  @DisplayName("Test remove(Object) with 'key'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object CustomMap.remove(Object)"})
  void testRemoveWithKey() {
    // Arrange
    AvroSerialiser keySerialiser = new AvroSerialiser();
    CustomMap<Object, Object> customMap = new CustomMap<>(keySerialiser, new AvroSerialiser());

    // Act and Assert
    assertNull(customMap.remove("Key"));
  }

  /**
   * Test {@link CustomMap#remove(Object, Object)} with {@code key}, {@code value}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link CustomMap#remove(Object, Object)}
   */
  @Test
  @DisplayName("Test remove(Object, Object) with 'key', 'value'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CustomMap.remove(Object, Object)"})
  void testRemoveWithKeyValue_thenReturnFalse() {
    // Arrange
    AvroSerialiser keySerialiser = new AvroSerialiser();
    CustomMap<Object, Object> customMap = new CustomMap<>(keySerialiser, new AvroSerialiser());

    // Act
    boolean actualRemoveResult = customMap.remove("Key", "Value");

    // Assert
    assertEquals(0, customMap.size());
    assertFalse(actualRemoveResult);
    assertTrue(customMap.getMap().isEmpty());
    assertTrue(customMap.getJsonStorage().isEmpty());
    assertTrue(customMap.isEmpty());
  }

  /**
   * Test {@link CustomMap#remove(Object, Object)} with {@code key}, {@code value}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link CustomMap#remove(Object, Object)}
   */
  @Test
  @DisplayName("Test remove(Object, Object) with 'key', 'value'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CustomMap.remove(Object, Object)"})
  void testRemoveWithKeyValue_thenReturnTrue() {
    // Arrange
    AvroSerialiser keySerialiser = new AvroSerialiser();

    CustomMap<Object, Object> customMap = new CustomMap<>(keySerialiser, new AvroSerialiser());
    customMap.put("Key", "Value");

    // Act
    boolean actualRemoveResult = customMap.remove("Key", "Value");

    // Assert
    assertEquals(0, customMap.size());
    assertTrue(customMap.getMap().isEmpty());
    assertTrue(customMap.getJsonStorage().isEmpty());
    assertTrue(customMap.isEmpty());
    assertTrue(actualRemoveResult);
  }

  /**
   * Test {@link CustomMap#replace(Object, Object, Object)} with {@code key}, {@code oldValue},
   * {@code newValue}.
   *
   * <p>Method under test: {@link CustomMap#replace(Object, Object, Object)}
   */
  @Test
  @DisplayName("Test replace(Object, Object, Object) with 'key', 'oldValue', 'newValue'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CustomMap.replace(Object, Object, Object)"})
  void testReplaceWithKeyOldValueNewValue() {
    // Arrange
    AvroSerialiser keySerialiser = new AvroSerialiser();
    CustomMap<Object, Object> customMap = new CustomMap<>(keySerialiser, new AvroSerialiser());

    // Act and Assert
    assertFalse(customMap.replace("Key", "Old Value", "New Value"));
  }

  /**
   * Test {@link CustomMap#replace(Object, Object)} with {@code key}, {@code value}.
   *
   * <p>Method under test: {@link CustomMap#replace(Object, Object)}
   */
  @Test
  @DisplayName("Test replace(Object, Object) with 'key', 'value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object CustomMap.replace(Object, Object)"})
  void testReplaceWithKeyValue() {
    // Arrange
    AvroSerialiser keySerialiser = new AvroSerialiser();
    CustomMap<Object, Object> customMap = new CustomMap<>(keySerialiser, new AvroSerialiser());

    // Act and Assert
    assertNull(customMap.replace("Key", "Value"));
  }

  /**
   * Test {@link CustomMap#containsValue(Object)}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link CustomMap#containsValue(Object)}
   */
  @Test
  @DisplayName("Test containsValue(Object); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CustomMap.containsValue(Object)"})
  void testContainsValue_thenReturnFalse() {
    // Arrange
    AvroSerialiser keySerialiser = new AvroSerialiser();
    CustomMap<Object, Object> customMap = new CustomMap<>(keySerialiser, new AvroSerialiser());

    // Act and Assert
    assertFalse(customMap.containsValue("Value"));
  }

  /**
   * Test {@link CustomMap#containsValue(Object)}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link CustomMap#containsValue(Object)}
   */
  @Test
  @DisplayName("Test containsValue(Object); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CustomMap.containsValue(Object)"})
  void testContainsValue_thenReturnTrue() {
    // Arrange
    AvroSerialiser keySerialiser = new AvroSerialiser();

    CustomMap<Object, Object> customMap = new CustomMap<>(keySerialiser, new AvroSerialiser());
    customMap.put("Key", "Value");

    // Act and Assert
    assertTrue(customMap.containsValue("Value"));
  }

  /**
   * Test {@link CustomMap#keySet()}.
   *
   * <p>Method under test: {@link CustomMap#keySet()}
   */
  @Test
  @DisplayName("Test keySet()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.Set CustomMap.keySet()"})
  void testKeySet() {
    // Arrange
    AvroSerialiser keySerialiser = new AvroSerialiser();
    CustomMap<Object, Object> customMap = new CustomMap<>(keySerialiser, new AvroSerialiser());

    // Act and Assert
    assertTrue(customMap.keySet().isEmpty());
  }

  /**
   * Test {@link CustomMap#values()}.
   *
   * <p>Method under test: {@link CustomMap#values()}
   */
  @Test
  @DisplayName("Test values()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.Collection CustomMap.values()"})
  void testValues() {
    // Arrange
    AvroSerialiser keySerialiser = new AvroSerialiser();
    CustomMap<Object, Object> customMap = new CustomMap<>(keySerialiser, new AvroSerialiser());

    // Act and Assert
    assertTrue(customMap.values().isEmpty());
  }

  /**
   * Test {@link CustomMap#entrySet()}.
   *
   * <p>Method under test: {@link CustomMap#entrySet()}
   */
  @Test
  @DisplayName("Test entrySet()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.Set CustomMap.entrySet()"})
  void testEntrySet() {
    // Arrange
    AvroSerialiser keySerialiser = new AvroSerialiser();
    CustomMap<Object, Object> customMap = new CustomMap<>(keySerialiser, new AvroSerialiser());

    // Act and Assert
    assertTrue(customMap.entrySet().isEmpty());
  }

  /**
   * Test {@link CustomMap#getOrDefault(Object, Object)}.
   *
   * <p>Method under test: {@link CustomMap#getOrDefault(Object, Object)}
   */
  @Test
  @DisplayName("Test getOrDefault(Object, Object)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object CustomMap.getOrDefault(Object, Object)"})
  void testGetOrDefault() {
    // Arrange
    AvroSerialiser keySerialiser = new AvroSerialiser();
    CustomMap<Object, Object> customMap = new CustomMap<>(keySerialiser, new AvroSerialiser());

    // Act and Assert
    assertEquals("Default Value", customMap.getOrDefault("Key", "Default Value"));
  }

  /**
   * Test {@link CustomMap#putIfAbsent(Object, Object)}.
   *
   * <p>Method under test: {@link CustomMap#putIfAbsent(Object, Object)}
   */
  @Test
  @DisplayName("Test putIfAbsent(Object, Object)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object CustomMap.putIfAbsent(Object, Object)"})
  void testPutIfAbsent() {
    // Arrange
    AvroSerialiser keySerialiser = new AvroSerialiser();
    CustomMap<Object, Object> customMap = new CustomMap<>(keySerialiser, new AvroSerialiser());

    // Act
    Object actualPutIfAbsentResult = customMap.putIfAbsent("Key", "Value");

    // Assert
    HashMap<Object, Object> map = customMap.getMap();
    assertEquals(1, map.size());
    assertEquals("Value", map.get("Key"));
    assertNull(actualPutIfAbsentResult);
    assertEquals(1, customMap.getJsonStorage().size());
    assertEquals(1, customMap.size());
    assertFalse(customMap.isEmpty());
  }

  /**
   * Test {@link CustomMap#computeIfAbsent(Object, Function)}.
   *
   * <p>Method under test: {@link CustomMap#computeIfAbsent(Object, Function)}
   */
  @Test
  @DisplayName("Test computeIfAbsent(Object, Function)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object CustomMap.computeIfAbsent(Object, Function)"})
  void testComputeIfAbsent() {
    // Arrange
    AvroSerialiser keySerialiser = new AvroSerialiser();
    CustomMap<Object, Object> customMap = new CustomMap<>(keySerialiser, new AvroSerialiser());

    Function<Object, Object> mappingFunction = mock(Function.class);
    when(mappingFunction.apply(Mockito.<Object>any())).thenReturn("Apply");

    // Act
    Object actualComputeIfAbsentResult = customMap.computeIfAbsent("Key", mappingFunction);

    // Assert
    verify(mappingFunction).apply(isA(Object.class));
    HashMap<Object, Object> map = customMap.getMap();
    assertEquals(1, map.size());
    assertEquals("Apply", map.get("Key"));
    assertEquals("Apply", actualComputeIfAbsentResult);
    assertEquals(1, customMap.getJsonStorage().size());
    assertEquals(1, customMap.size());
    assertFalse(customMap.isEmpty());
  }

  /**
   * Test {@link CustomMap#computeIfPresent(Object, BiFunction)}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link CustomMap#computeIfPresent(Object, BiFunction)}
   */
  @Test
  @DisplayName("Test computeIfPresent(Object, BiFunction); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object CustomMap.computeIfPresent(Object, BiFunction)"})
  void testComputeIfPresent_thenReturnNull() {
    // Arrange
    AvroSerialiser keySerialiser = new AvroSerialiser();
    CustomMap<Object, Object> customMap = new CustomMap<>(keySerialiser, new AvroSerialiser());

    // Act and Assert
    assertNull(customMap.computeIfPresent("Key", mock(BiFunction.class)));
  }

  /**
   * Test {@link CustomMap#compute(Object, BiFunction)}.
   *
   * <p>Method under test: {@link CustomMap#compute(Object, BiFunction)}
   */
  @Test
  @DisplayName("Test compute(Object, BiFunction)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object CustomMap.compute(Object, BiFunction)"})
  void testCompute() {
    // Arrange
    AvroSerialiser keySerialiser = new AvroSerialiser();
    CustomMap<Object, Object> customMap = new CustomMap<>(keySerialiser, new AvroSerialiser());

    BiFunction<Object, Object, Object> remappingFunction = mock(BiFunction.class);
    when(remappingFunction.apply(Mockito.<Object>any(), Mockito.<Object>any())).thenReturn("Apply");

    // Act
    Object actualComputeResult = customMap.compute("Key", remappingFunction);

    // Assert
    verify(remappingFunction).apply(isA(Object.class), isNull());
    HashMap<Object, Object> map = customMap.getMap();
    assertEquals(1, map.size());
    assertEquals("Apply", map.get("Key"));
    assertEquals("Apply", actualComputeResult);
    assertEquals(1, customMap.getJsonStorage().size());
    assertEquals(1, customMap.size());
    assertFalse(customMap.isEmpty());
  }

  /**
   * Test {@link CustomMap#merge(Object, Object, BiFunction)}.
   *
   * <p>Method under test: {@link CustomMap#merge(Object, Object, BiFunction)}
   */
  @Test
  @DisplayName("Test merge(Object, Object, BiFunction)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object CustomMap.merge(Object, Object, BiFunction)"})
  void testMerge() {
    // Arrange
    AvroSerialiser keySerialiser = new AvroSerialiser();
    CustomMap<Object, Object> customMap = new CustomMap<>(keySerialiser, new AvroSerialiser());

    // Act
    Object actualMergeResult = customMap.merge("Key", "Value", mock(BiFunction.class));

    // Assert
    HashMap<Object, Object> map = customMap.getMap();
    assertEquals(1, map.size());
    assertEquals("Value", map.get("Key"));
    assertEquals("Value", actualMergeResult);
    assertEquals(1, customMap.getJsonStorage().size());
    assertEquals(1, customMap.size());
    assertFalse(customMap.isEmpty());
  }

  /**
   * Test {@link CustomMap#equals(Object)}, and {@link CustomMap#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link CustomMap#equals(Object)}
   *   <li>{@link CustomMap#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CustomMap.equals(Object)", "int CustomMap.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    AvroSerialiser keySerialiser = new AvroSerialiser();
    CustomMap<Object, Object> customMap = new CustomMap<>(keySerialiser, new AvroSerialiser());
    AvroSerialiser keySerialiser2 = new AvroSerialiser();
    CustomMap<Object, Object> customMap2 = new CustomMap<>(keySerialiser2, new AvroSerialiser());

    // Act and Assert
    assertEquals(customMap, customMap2);
    assertEquals(customMap.hashCode(), customMap2.hashCode());
  }

  /**
   * Test {@link CustomMap#equals(Object)}, and {@link CustomMap#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link CustomMap#equals(Object)}
   *   <li>{@link CustomMap#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CustomMap.equals(Object)", "int CustomMap.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    AvroSerialiser keySerialiser = new AvroSerialiser();
    CustomMap<Object, Object> customMap = new CustomMap<>(keySerialiser, new AvroSerialiser());

    // Act and Assert
    assertEquals(customMap, customMap);
    int expectedHashCodeResult = customMap.hashCode();
    assertEquals(expectedHashCodeResult, customMap.hashCode());
  }

  /**
   * Test {@link CustomMap#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CustomMap#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CustomMap.equals(Object)", "int CustomMap.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    JavaSerialiser keySerialiser = new JavaSerialiser();
    CustomMap<Object, Object> customMap = new CustomMap<>(keySerialiser, new AvroSerialiser());
    AvroSerialiser keySerialiser2 = new AvroSerialiser();
    CustomMap<Object, Object> customMap2 = new CustomMap<>(keySerialiser2, new AvroSerialiser());

    // Act and Assert
    assertNotEquals(customMap, customMap2);
  }

  /**
   * Test {@link CustomMap#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CustomMap#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CustomMap.equals(Object)", "int CustomMap.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    AvroSerialiser keySerialiser = new AvroSerialiser();
    CustomMap<Object, Object> customMap = new CustomMap<>(keySerialiser, new AvroSerialiser());

    // Act and Assert
    assertNotEquals(customMap, null);
  }

  /**
   * Test {@link CustomMap#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CustomMap#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CustomMap.equals(Object)", "int CustomMap.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    AvroSerialiser keySerialiser = new AvroSerialiser();
    CustomMap<Object, Object> customMap = new CustomMap<>(keySerialiser, new AvroSerialiser());

    // Act and Assert
    assertNotEquals(customMap, "Different type to CustomMap");
  }
}
