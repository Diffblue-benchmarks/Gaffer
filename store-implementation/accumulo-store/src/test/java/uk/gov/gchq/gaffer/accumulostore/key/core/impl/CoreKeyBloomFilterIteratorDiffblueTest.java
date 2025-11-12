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
import java.util.HashMap;
import java.util.Map;
import org.apache.accumulo.core.data.Key;
import org.apache.accumulo.core.data.Value;
import org.apache.accumulo.core.iterators.OptionDescriber;
import org.apache.accumulo.tserver.MemKey;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.accumulostore.key.exception.BloomFilterIteratorException;

class CoreKeyBloomFilterIteratorDiffblueTest {
  /**
   * Method under test: {@link CoreKeyBloomFilterIterator#accept(Key, Value)}
   */
  @Test
  void testAccept() {
    // Arrange
    CoreKeyBloomFilterIterator coreKeyBloomFilterIterator = new CoreKeyBloomFilterIterator();
    Key key = new Key();

    // Act and Assert
    assertTrue(coreKeyBloomFilterIterator.accept(key, new Value()));
  }

  /**
   * Method under test: {@link CoreKeyBloomFilterIterator#accept(Key, Value)}
   */
  @Test
  void testAccept2() {
    // Arrange
    CoreKeyBloomFilterIterator coreKeyBloomFilterIterator = new CoreKeyBloomFilterIterator();
    MemKey key = new MemKey(new byte[]{'A', -1, 'A', -1, 'A', -1, 'A', -1},
        new byte[]{'A', -1, 'A', -1, 'A', -1, 'A', -1}, new byte[]{'A', -1, 'A', -1, 'A', -1, 'A', -1},
        new byte[]{'A', -1, 'A', -1, 'A', -1, 'A', -1}, -1L, true, true, -1);

    // Act and Assert
    assertTrue(coreKeyBloomFilterIterator.accept(key, new Value()));
  }

  /**
   * Method under test: {@link CoreKeyBloomFilterIterator#validateOptions(Map)}
   */
  @Test
  void testValidateOptions() {
    // Arrange
    CoreKeyBloomFilterIterator coreKeyBloomFilterIterator = new CoreKeyBloomFilterIterator();

    // Act and Assert
    assertThrows(BloomFilterIteratorException.class, () -> coreKeyBloomFilterIterator.validateOptions(new HashMap<>()));
  }

  /**
   * Method under test: {@link CoreKeyBloomFilterIterator#validateOptions(Map)}
   */
  @Test
  void testValidateOptions2() {
    // Arrange
    CoreKeyBloomFilterIterator coreKeyBloomFilterIterator = new CoreKeyBloomFilterIterator();

    HashMap<String, String> options = new HashMap<>();
    options.put("negate", null);
    options.put("Bloom_Filter", "Options");

    // Act and Assert
    assertTrue(coreKeyBloomFilterIterator.validateOptions(options));
  }

  /**
   * Method under test: {@link CoreKeyBloomFilterIterator#validateOptions(Map)}
   */
  @Test
  void testValidateOptions3() {
    // Arrange
    CoreKeyBloomFilterIterator coreKeyBloomFilterIterator = new CoreKeyBloomFilterIterator();

    HashMap<String, String> options = new HashMap<>();
    options.put("negate", "Options");
    options.put("Bloom_Filter", "Options");

    // Act and Assert
    assertTrue(coreKeyBloomFilterIterator.validateOptions(options));
  }

  /**
   * Method under test: {@link CoreKeyBloomFilterIterator#describeOptions()}
   */
  @Test
  void testDescribeOptions() {
    // Arrange and Act
    OptionDescriber.IteratorOptions actualDescribeOptionsResult = (new CoreKeyBloomFilterIterator()).describeOptions();

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
   * Method under test: default or parameterless constructor of
   * {@link CoreKeyBloomFilterIterator}
   */
  @Test
  void testNewCoreKeyBloomFilterIterator() {
    // Arrange, Act and Assert
    assertNull((new CoreKeyBloomFilterIterator()).filter);
  }
}
