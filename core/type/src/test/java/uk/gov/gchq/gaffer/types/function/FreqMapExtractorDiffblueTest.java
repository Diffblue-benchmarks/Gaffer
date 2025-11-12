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

package uk.gov.gchq.gaffer.types.function;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.mock;
import java.util.function.BiFunction;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.types.FreqMap;

class FreqMapExtractorDiffblueTest {
  /**
   * Method under test: {@link FreqMapExtractor#apply(FreqMap)}
   */
  @Test
  void testApply() {
    // Arrange
    FreqMapExtractor freqMapExtractor = new FreqMapExtractor("Key");

    // Act and Assert
    assertNull(freqMapExtractor.apply(new FreqMap()));
  }

  /**
   * Method under test: {@link FreqMapExtractor#apply(FreqMap)}
   */
  @Test
  void testApply2() {
    // Arrange, Act and Assert
    assertNull((new FreqMapExtractor("Key")).apply(null));
  }

  /**
   * Method under test: {@link FreqMapExtractor#apply(FreqMap)}
   */
  @Test
  void testApply3() {
    // Arrange
    FreqMapExtractor freqMapExtractor = new FreqMapExtractor("Key");

    FreqMap freqMap = new FreqMap();
    freqMap.computeIfPresent("foo", mock(BiFunction.class));

    // Act and Assert
    assertNull(freqMapExtractor.apply(freqMap));
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link FreqMapExtractor#FreqMapExtractor()}
   *   <li>{@link FreqMapExtractor#setKey(String)}
   *   <li>{@link FreqMapExtractor#getKey()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    FreqMapExtractor actualFreqMapExtractor = new FreqMapExtractor();
    actualFreqMapExtractor.setKey("Key");

    // Assert that nothing has changed
    assertEquals("Key", actualFreqMapExtractor.getKey());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link FreqMapExtractor#FreqMapExtractor(String)}
   *   <li>{@link FreqMapExtractor#setKey(String)}
   *   <li>{@link FreqMapExtractor#getKey()}
   * </ul>
   */
  @Test
  void testGettersAndSetters2() {
    // Arrange and Act
    FreqMapExtractor actualFreqMapExtractor = new FreqMapExtractor("Key");
    actualFreqMapExtractor.setKey("Key");

    // Assert that nothing has changed
    assertEquals("Key", actualFreqMapExtractor.getKey());
  }
}
