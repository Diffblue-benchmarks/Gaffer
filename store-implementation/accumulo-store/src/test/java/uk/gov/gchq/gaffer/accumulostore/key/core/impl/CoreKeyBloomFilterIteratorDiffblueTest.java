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

package uk.gov.gchq.gaffer.accumulostore.key.core.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashMap;
import java.util.Map;
import org.apache.accumulo.core.data.Key;
import org.apache.accumulo.core.data.Value;
import org.apache.accumulo.core.iterators.OptionDescriber;
import org.apache.accumulo.core.iterators.OptionDescriber.IteratorOptions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.accumulostore.AccumuloProperties;
import uk.gov.gchq.gaffer.accumulostore.key.exception.BloomFilterIteratorException;

class CoreKeyBloomFilterIteratorDiffblueTest {
  /**
   * Test {@link CoreKeyBloomFilterIterator#accept(Key, Value)}.
   * <ul>
   *   <li>When {@link Key#Key(CharSequence)} with row is {@link AccumuloProperties#CLIENT_SIDE_BLOOM_FILTER_SIZE}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CoreKeyBloomFilterIterator#accept(Key, Value)}
   */
  @Test
  @DisplayName("Test accept(Key, Value); when Key(CharSequence) with row is CLIENT_SIDE_BLOOM_FILTER_SIZE; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean CoreKeyBloomFilterIterator.accept(Key, Value)"})
  void testAccept_whenKeyWithRowIsClient_side_bloom_filter_size_thenReturnTrue() {
    // Arrange
    CoreKeyBloomFilterIterator coreKeyBloomFilterIterator = new CoreKeyBloomFilterIterator();
    Key key = new Key(AccumuloProperties.CLIENT_SIDE_BLOOM_FILTER_SIZE);

    // Act and Assert
    assertTrue(coreKeyBloomFilterIterator.accept(key, new Value()));
  }

  /**
   * Test {@link CoreKeyBloomFilterIterator#accept(Key, Value)}.
   * <ul>
   *   <li>When {@link Key#Key()}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CoreKeyBloomFilterIterator#accept(Key, Value)}
   */
  @Test
  @DisplayName("Test accept(Key, Value); when Key(); then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean CoreKeyBloomFilterIterator.accept(Key, Value)"})
  void testAccept_whenKey_thenReturnTrue() {
    // Arrange
    CoreKeyBloomFilterIterator coreKeyBloomFilterIterator = new CoreKeyBloomFilterIterator();
    Key key = new Key();

    // Act and Assert
    assertTrue(coreKeyBloomFilterIterator.accept(key, new Value()));
  }

  /**
   * Test {@link CoreKeyBloomFilterIterator#validateOptions(Map)}.
   * <ul>
   *   <li>Given {@code negate}.</li>
   *   <li>When {@link HashMap#HashMap()} {@code negate} is {@code Options}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CoreKeyBloomFilterIterator#validateOptions(Map)}
   */
  @Test
  @DisplayName("Test validateOptions(Map); given 'negate'; when HashMap() 'negate' is 'Options'; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean CoreKeyBloomFilterIterator.validateOptions(Map)"})
  void testValidateOptions_givenNegate_whenHashMapNegateIsOptions_thenReturnTrue() {
    // Arrange
    CoreKeyBloomFilterIterator coreKeyBloomFilterIterator = new CoreKeyBloomFilterIterator();

    HashMap<String, String> options = new HashMap<>();
    options.put("negate", "Options");
    options.put("Bloom_Filter", "Options");

    // Act and Assert
    assertTrue(coreKeyBloomFilterIterator.validateOptions(options));
  }

  /**
   * Test {@link CoreKeyBloomFilterIterator#validateOptions(Map)}.
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>When {@link HashMap#HashMap()} {@code negate} is {@code null}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CoreKeyBloomFilterIterator#validateOptions(Map)}
   */
  @Test
  @DisplayName("Test validateOptions(Map); given 'null'; when HashMap() 'negate' is 'null'; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean CoreKeyBloomFilterIterator.validateOptions(Map)"})
  void testValidateOptions_givenNull_whenHashMapNegateIsNull_thenReturnTrue() {
    // Arrange
    CoreKeyBloomFilterIterator coreKeyBloomFilterIterator = new CoreKeyBloomFilterIterator();

    HashMap<String, String> options = new HashMap<>();
    options.put("negate", null);
    options.put("Bloom_Filter", "Options");

    // Act and Assert
    assertTrue(coreKeyBloomFilterIterator.validateOptions(options));
  }

  /**
   * Test {@link CoreKeyBloomFilterIterator#validateOptions(Map)}.
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.</li>
   *   <li>Then throw {@link BloomFilterIteratorException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CoreKeyBloomFilterIterator#validateOptions(Map)}
   */
  @Test
  @DisplayName("Test validateOptions(Map); when HashMap(); then throw BloomFilterIteratorException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean CoreKeyBloomFilterIterator.validateOptions(Map)"})
  void testValidateOptions_whenHashMap_thenThrowBloomFilterIteratorException() {
    // Arrange
    CoreKeyBloomFilterIterator coreKeyBloomFilterIterator = new CoreKeyBloomFilterIterator();

    // Act and Assert
    assertThrows(BloomFilterIteratorException.class, () -> coreKeyBloomFilterIterator.validateOptions(new HashMap<>()));
  }

  /**
   * Test {@link CoreKeyBloomFilterIterator#describeOptions()}.
   * <p>
   * Method under test: {@link CoreKeyBloomFilterIterator#describeOptions()}
   */
  @Test
  @DisplayName("Test describeOptions()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"IteratorOptions CoreKeyBloomFilterIterator.describeOptions()"})
  void testDescribeOptions() {
    // Arrange and Act
    IteratorOptions actualDescribeOptionsResult = (new CoreKeyBloomFilterIterator()).describeOptions();

    // Assert
    assertEquals("Bloom Filter", actualDescribeOptionsResult.getDescription());
    assertEquals("Bloom_Filter", actualDescribeOptionsResult.getName());
    Map<String, String> namedOptions = actualDescribeOptionsResult.getNamedOptions();
    assertEquals(1, namedOptions.size());
    assertEquals("Required: The serialised form of the bloom filter that keys will be tested against",
        namedOptions.get("Bloom_Filter"));
    assertNull(actualDescribeOptionsResult.getUnnamedOptionDescriptions());
  }

  /**
   * Test new {@link CoreKeyBloomFilterIterator} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of {@link CoreKeyBloomFilterIterator}
   */
  @Test
  @DisplayName("Test new CoreKeyBloomFilterIterator (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void CoreKeyBloomFilterIterator.<init>()"})
  void testNewCoreKeyBloomFilterIterator() {
    // Arrange, Act and Assert
    assertNull((new CoreKeyBloomFilterIterator()).filter);
  }
}
