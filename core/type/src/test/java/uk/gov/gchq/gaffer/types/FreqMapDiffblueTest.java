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
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class FreqMapDiffblueTest {
  /**
   * Test {@link FreqMap#FreqMap()}.
   *
   * <p>Method under test: {@link FreqMap#FreqMap()}
   */
  @Test
  @DisplayName("Test new FreqMap()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void FreqMap.<init>()",
    "void FreqMap.<init>(int)",
    "void FreqMap.<init>(int, float)",
    "void FreqMap.<init>(Map)"
  })
  void testNewFreqMap() {
    // Arrange, Act and Assert
    assertTrue(new FreqMap().isEmpty());
  }

  /**
   * Test {@link FreqMap#FreqMap(String)}.
   *
   * <p>Method under test: {@link FreqMap#FreqMap(String)}
   */
  @Test
  @DisplayName("Test new FreqMap(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void FreqMap.<init>(String)"})
  void testNewFreqMap2() {
    // Arrange and Act
    FreqMap actualFreqMap = new FreqMap("Initial Key");

    // Assert
    assertEquals(1, actualFreqMap.size());
    assertEquals(1L, actualFreqMap.get("Initial Key").longValue());
  }

  /**
   * Test {@link FreqMap#FreqMap(Map)}.
   *
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.
   * </ul>
   *
   * <p>Method under test: {@link FreqMap#FreqMap(Map)}
   */
  @Test
  @DisplayName("Test new FreqMap(Map); when HashMap()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void FreqMap.<init>()",
    "void FreqMap.<init>(int)",
    "void FreqMap.<init>(int, float)",
    "void FreqMap.<init>(Map)"
  })
  void testNewFreqMap_whenHashMap() {
    // Arrange, Act and Assert
    assertTrue(new FreqMap(new HashMap<>()).isEmpty());
  }

  /**
   * Test {@link FreqMap#FreqMap(int)}.
   *
   * <ul>
   *   <li>When one.
   * </ul>
   *
   * <p>Method under test: {@link FreqMap#FreqMap(int)}
   */
  @Test
  @DisplayName("Test new FreqMap(int); when one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void FreqMap.<init>()",
    "void FreqMap.<init>(int)",
    "void FreqMap.<init>(int, float)",
    "void FreqMap.<init>(Map)"
  })
  void testNewFreqMap_whenOne() {
    // Arrange, Act and Assert
    assertTrue(new FreqMap(1).isEmpty());
  }

  /**
   * Test {@link FreqMap#FreqMap(int, float)}.
   *
   * <ul>
   *   <li>When ten.
   * </ul>
   *
   * <p>Method under test: {@link FreqMap#FreqMap(int, float)}
   */
  @Test
  @DisplayName("Test new FreqMap(int, float); when ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void FreqMap.<init>()",
    "void FreqMap.<init>(int)",
    "void FreqMap.<init>(int, float)",
    "void FreqMap.<init>(Map)"
  })
  void testNewFreqMap_whenTen() {
    // Arrange, Act and Assert
    assertTrue(new FreqMap(1, 10.0f).isEmpty());
  }

  /**
   * Test {@link FreqMap#upsert(String, Long)} with {@code key}, {@code value}.
   *
   * <ul>
   *   <li>Given {@link FreqMap#FreqMap()}.
   *   <li>When {@code Key}.
   *   <li>Then {@link FreqMap#FreqMap()} {@code Key} longValue is forty-two.
   * </ul>
   *
   * <p>Method under test: {@link FreqMap#upsert(String, Long)}
   */
  @Test
  @DisplayName(
      "Test upsert(String, Long) with 'key', 'value'; given FreqMap(); when 'Key'; then FreqMap() 'Key' longValue is forty-two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void FreqMap.upsert(String, Long)"})
  void testUpsertWithKeyValue_givenFreqMap_whenKey_thenFreqMapKeyLongValueIsFortyTwo() {
    // Arrange
    FreqMap freqMap = new FreqMap();

    // Act
    freqMap.upsert("Key", 42L);

    // Assert
    assertEquals(1, freqMap.size());
    assertEquals(42L, freqMap.get("Key").longValue());
  }

  /**
   * Test {@link FreqMap#upsert(String, Long)} with {@code key}, {@code value}.
   *
   * <ul>
   *   <li>Then {@link FreqMap#FreqMap()} {@code Long} longValue is forty-one.
   * </ul>
   *
   * <p>Method under test: {@link FreqMap#upsert(String, Long)}
   */
  @Test
  @DisplayName(
      "Test upsert(String, Long) with 'key', 'value'; then FreqMap() 'java.lang.Long' longValue is forty-one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void FreqMap.upsert(String, Long)"})
  void testUpsertWithKeyValue_thenFreqMapJavaLangLongLongValueIsFortyOne() {
    // Arrange
    FreqMap freqMap = new FreqMap();
    freqMap.put("java.lang.Long", -1L);

    // Act
    freqMap.upsert("java.lang.Long", 42L);

    // Assert
    assertEquals(1, freqMap.size());
    assertEquals(41L, freqMap.get("java.lang.Long").longValue());
  }

  /**
   * Test {@link FreqMap#upsert(String)} with {@code key}.
   *
   * <ul>
   *   <li>Given {@link FreqMap#FreqMap()}.
   *   <li>When {@code Key}.
   *   <li>Then {@link FreqMap#FreqMap()} {@code Key} longValue is one.
   * </ul>
   *
   * <p>Method under test: {@link FreqMap#upsert(String)}
   */
  @Test
  @DisplayName(
      "Test upsert(String) with 'key'; given FreqMap(); when 'Key'; then FreqMap() 'Key' longValue is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void FreqMap.upsert(String)"})
  void testUpsertWithKey_givenFreqMap_whenKey_thenFreqMapKeyLongValueIsOne() {
    // Arrange
    FreqMap freqMap = new FreqMap();

    // Act
    freqMap.upsert("Key");

    // Assert
    assertEquals(1, freqMap.size());
    assertEquals(1L, freqMap.get("Key").longValue());
  }

  /**
   * Test {@link FreqMap#upsert(String)} with {@code key}.
   *
   * <ul>
   *   <li>Then {@link FreqMap#FreqMap()} {@code Long} longValue is zero.
   * </ul>
   *
   * <p>Method under test: {@link FreqMap#upsert(String)}
   */
  @Test
  @DisplayName("Test upsert(String) with 'key'; then FreqMap() 'java.lang.Long' longValue is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void FreqMap.upsert(String)"})
  void testUpsertWithKey_thenFreqMapJavaLangLongLongValueIsZero() {
    // Arrange
    FreqMap freqMap = new FreqMap();
    freqMap.put("java.lang.Long", -1L);

    // Act
    freqMap.upsert("java.lang.Long");

    // Assert
    assertEquals(1, freqMap.size());
    assertEquals(0L, freqMap.get("java.lang.Long").longValue());
  }

  /**
   * Test {@link FreqMap#getTotal()}.
   *
   * <ul>
   *   <li>Given {@link FreqMap#FreqMap()} {@code foo} is one.
   *   <li>Then return longValue is one.
   * </ul>
   *
   * <p>Method under test: {@link FreqMap#getTotal()}
   */
  @Test
  @DisplayName("Test getTotal(); given FreqMap() 'foo' is one; then return longValue is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Long FreqMap.getTotal()"})
  void testGetTotal_givenFreqMapFooIsOne_thenReturnLongValueIsOne() {
    // Arrange
    FreqMap freqMap = new FreqMap();
    freqMap.put("foo", 1L);

    // Act and Assert
    assertEquals(1L, freqMap.getTotal().longValue());
  }

  /**
   * Test {@link FreqMap#getTotal()}.
   *
   * <ul>
   *   <li>Given {@link FreqMap#FreqMap()}.
   *   <li>Then return longValue is zero.
   * </ul>
   *
   * <p>Method under test: {@link FreqMap#getTotal()}
   */
  @Test
  @DisplayName("Test getTotal(); given FreqMap(); then return longValue is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Long FreqMap.getTotal()"})
  void testGetTotal_givenFreqMap_thenReturnLongValueIsZero() {
    // Arrange, Act and Assert
    assertEquals(0L, new FreqMap().getTotal().longValue());
  }
}
