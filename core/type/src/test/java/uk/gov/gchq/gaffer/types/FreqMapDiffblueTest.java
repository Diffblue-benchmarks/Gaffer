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
import static org.mockito.Mockito.mock;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;
import org.junit.jupiter.api.Test;

class FreqMapDiffblueTest {
  /**
   * Method under test: {@link FreqMap#upsert(String)}
   */
  @Test
  void testUpsert() {
    // Arrange
    FreqMap freqMap = new FreqMap();

    // Act
    freqMap.upsert("Key");

    // Assert that nothing has changed
    assertEquals(1, freqMap.size());
    assertEquals(1L, freqMap.get("Key").longValue());
  }

  /**
   * Method under test: {@link FreqMap#upsert(String)}
   */
  @Test
  void testUpsert2() {
    // Arrange
    FreqMap freqMap = new FreqMap();
    freqMap.computeIfPresent("foo", mock(BiFunction.class));

    // Act
    freqMap.upsert("Key");

    // Assert that nothing has changed
    assertEquals(1, freqMap.size());
    assertEquals(1L, freqMap.get("Key").longValue());
  }

  /**
   * Method under test: {@link FreqMap#upsert(String)}
   */
  @Test
  void testUpsert3() {
    // Arrange
    FreqMap freqMap = new FreqMap();
    freqMap.put("java.lang.Long", -1L);
    freqMap.computeIfPresent("foo", mock(BiFunction.class));

    // Act
    freqMap.upsert("java.lang.Long");

    // Assert that nothing has changed
    assertEquals(1, freqMap.size());
    assertEquals(0L, freqMap.get("java.lang.Long").longValue());
  }

  /**
   * Method under test: {@link FreqMap#upsert(String, Long)}
   */
  @Test
  void testUpsert4() {
    // Arrange
    FreqMap freqMap = new FreqMap();

    // Act
    freqMap.upsert("Key", 42L);

    // Assert that nothing has changed
    assertEquals(1, freqMap.size());
    assertEquals(42L, freqMap.get("Key").longValue());
  }

  /**
   * Method under test: {@link FreqMap#upsert(String, Long)}
   */
  @Test
  void testUpsert5() {
    // Arrange
    FreqMap freqMap = new FreqMap();
    freqMap.computeIfPresent("foo", mock(BiFunction.class));

    // Act
    freqMap.upsert("Key", 42L);

    // Assert that nothing has changed
    assertEquals(1, freqMap.size());
    assertEquals(42L, freqMap.get("Key").longValue());
  }

  /**
   * Method under test: {@link FreqMap#getTotal()}
   */
  @Test
  void testGetTotal() {
    // Arrange, Act and Assert
    assertEquals(0L, (new FreqMap()).getTotal().longValue());
  }

  /**
   * Method under test: {@link FreqMap#getTotal()}
   */
  @Test
  void testGetTotal2() {
    // Arrange
    FreqMap freqMap = new FreqMap();
    freqMap.put("foo", 1L);

    // Act and Assert
    assertEquals(1L, freqMap.getTotal().longValue());
  }

  /**
   * Method under test: {@link FreqMap#getTotal()}
   */
  @Test
  void testGetTotal3() {
    // Arrange
    FreqMap freqMap = new FreqMap();
    freqMap.computeIfPresent("foo", mock(BiFunction.class));
    freqMap.put("foo", 1L);

    // Act and Assert
    assertEquals(1L, freqMap.getTotal().longValue());
  }

  /**
   * Method under test: {@link FreqMap#FreqMap()}
   */
  @Test
  void testNewFreqMap() {
    // Arrange, Act and Assert
    assertTrue((new FreqMap()).isEmpty());
    assertTrue((new FreqMap(1)).isEmpty());
    assertTrue((new FreqMap(1, 10.0f)).isEmpty());
    assertTrue((new FreqMap(new HashMap<>())).isEmpty());
  }

  /**
   * Method under test: {@link FreqMap#FreqMap(String)}
   */
  @Test
  void testNewFreqMap2() {
    // Arrange and Act
    FreqMap actualFreqMap = new FreqMap("Initial Key");

    // Assert
    assertEquals(1, actualFreqMap.size());
    assertEquals(1L, actualFreqMap.get("Initial Key").longValue());
  }
}
