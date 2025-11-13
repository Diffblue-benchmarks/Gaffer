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

package uk.gov.gchq.gaffer.accumulostore.key.core.impl.classic;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
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

class ClassicEdgeDirectedUndirectedFilterIteratorDiffblueTest {
  /**
   * Test {@link ClassicEdgeDirectedUndirectedFilterIterator#accept(Key, Value)}.
   * <ul>
   *   <li>When {@link Key#Key(CharSequence)} with row is {@link AccumuloProperties#CLIENT_SIDE_BLOOM_FILTER_SIZE}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ClassicEdgeDirectedUndirectedFilterIterator#accept(Key, Value)}
   */
  @Test
  @DisplayName("Test accept(Key, Value); when Key(CharSequence) with row is CLIENT_SIDE_BLOOM_FILTER_SIZE; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ClassicEdgeDirectedUndirectedFilterIterator.accept(Key, Value)"})
  void testAccept_whenKeyWithRowIsClient_side_bloom_filter_size_thenReturnFalse() {
    // Arrange
    ClassicEdgeDirectedUndirectedFilterIterator classicEdgeDirectedUndirectedFilterIterator = new ClassicEdgeDirectedUndirectedFilterIterator();
    Key key = new Key(AccumuloProperties.CLIENT_SIDE_BLOOM_FILTER_SIZE);

    // Act and Assert
    assertFalse(classicEdgeDirectedUndirectedFilterIterator.accept(key, new Value()));
  }

  /**
   * Test {@link ClassicEdgeDirectedUndirectedFilterIterator#validateOptions(Map)}.
   * <ul>
   *   <li>Given {@code negate}.</li>
   *   <li>When {@link HashMap#HashMap()} {@code negate} is {@code Options}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ClassicEdgeDirectedUndirectedFilterIterator#validateOptions(Map)}
   */
  @Test
  @DisplayName("Test validateOptions(Map); given 'negate'; when HashMap() 'negate' is 'Options'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ClassicEdgeDirectedUndirectedFilterIterator.validateOptions(Map)"})
  void testValidateOptions_givenNegate_whenHashMapNegateIsOptions() {
    // Arrange
    ClassicEdgeDirectedUndirectedFilterIterator classicEdgeDirectedUndirectedFilterIterator = new ClassicEdgeDirectedUndirectedFilterIterator();

    HashMap<String, String> options = new HashMap<>();
    options.put("negate", "Options");
    options.put("Directed_Edges_Only", "Options");
    options.put("Undirected_Edges_Only", "Options");
    options.put("Incoming_Edges_Only", "Options");
    options.put("Outgoing_Edges_Only", "Options");

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> classicEdgeDirectedUndirectedFilterIterator.validateOptions(options));
  }

  /**
   * Test {@link ClassicEdgeDirectedUndirectedFilterIterator#validateOptions(Map)}.
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>When {@link HashMap#HashMap()} {@code negate} is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ClassicEdgeDirectedUndirectedFilterIterator#validateOptions(Map)}
   */
  @Test
  @DisplayName("Test validateOptions(Map); given 'null'; when HashMap() 'negate' is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ClassicEdgeDirectedUndirectedFilterIterator.validateOptions(Map)"})
  void testValidateOptions_givenNull_whenHashMapNegateIsNull() {
    // Arrange
    ClassicEdgeDirectedUndirectedFilterIterator classicEdgeDirectedUndirectedFilterIterator = new ClassicEdgeDirectedUndirectedFilterIterator();

    HashMap<String, String> options = new HashMap<>();
    options.put("negate", null);
    options.put("Directed_Edges_Only", "Options");
    options.put("Undirected_Edges_Only", "Options");
    options.put("Incoming_Edges_Only", "Options");
    options.put("Outgoing_Edges_Only", "Options");

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> classicEdgeDirectedUndirectedFilterIterator.validateOptions(options));
  }

  /**
   * Test {@link ClassicEdgeDirectedUndirectedFilterIterator#validateOptions(Map)}.
   * <ul>
   *   <li>When {@link HashMap#HashMap()} {@code Directed_Edges_Only} is {@code Directed_Edges_Only}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ClassicEdgeDirectedUndirectedFilterIterator#validateOptions(Map)}
   */
  @Test
  @DisplayName("Test validateOptions(Map); when HashMap() 'Directed_Edges_Only' is 'Directed_Edges_Only'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ClassicEdgeDirectedUndirectedFilterIterator.validateOptions(Map)"})
  void testValidateOptions_whenHashMapDirectedEdgesOnlyIsDirectedEdgesOnly() {
    // Arrange
    ClassicEdgeDirectedUndirectedFilterIterator classicEdgeDirectedUndirectedFilterIterator = new ClassicEdgeDirectedUndirectedFilterIterator();

    HashMap<String, String> options = new HashMap<>();
    options.put("Directed_Edges_Only", "Directed_Edges_Only");

    // Act and Assert
    assertTrue(classicEdgeDirectedUndirectedFilterIterator.validateOptions(options));
  }

  /**
   * Test {@link ClassicEdgeDirectedUndirectedFilterIterator#validateOptions(Map)}.
   * <ul>
   *   <li>When {@link HashMap#HashMap()} {@code Incoming_Edges_Only} is {@code Directed_Edges_Only}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ClassicEdgeDirectedUndirectedFilterIterator#validateOptions(Map)}
   */
  @Test
  @DisplayName("Test validateOptions(Map); when HashMap() 'Incoming_Edges_Only' is 'Directed_Edges_Only'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ClassicEdgeDirectedUndirectedFilterIterator.validateOptions(Map)"})
  void testValidateOptions_whenHashMapIncomingEdgesOnlyIsDirectedEdgesOnly() {
    // Arrange
    ClassicEdgeDirectedUndirectedFilterIterator classicEdgeDirectedUndirectedFilterIterator = new ClassicEdgeDirectedUndirectedFilterIterator();

    HashMap<String, String> options = new HashMap<>();
    options.put("Incoming_Edges_Only", "Directed_Edges_Only");

    // Act and Assert
    assertTrue(classicEdgeDirectedUndirectedFilterIterator.validateOptions(options));
  }

  /**
   * Test {@link ClassicEdgeDirectedUndirectedFilterIterator#validateOptions(Map)}.
   * <ul>
   *   <li>When {@link HashMap#HashMap()} {@code Outgoing_Edges_Only} is {@code Outgoing_Edges_Only}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ClassicEdgeDirectedUndirectedFilterIterator#validateOptions(Map)}
   */
  @Test
  @DisplayName("Test validateOptions(Map); when HashMap() 'Outgoing_Edges_Only' is 'Outgoing_Edges_Only'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ClassicEdgeDirectedUndirectedFilterIterator.validateOptions(Map)"})
  void testValidateOptions_whenHashMapOutgoingEdgesOnlyIsOutgoingEdgesOnly() {
    // Arrange
    ClassicEdgeDirectedUndirectedFilterIterator classicEdgeDirectedUndirectedFilterIterator = new ClassicEdgeDirectedUndirectedFilterIterator();

    HashMap<String, String> options = new HashMap<>();
    options.put("Outgoing_Edges_Only", "Outgoing_Edges_Only");
    options.put("Incoming_Edges_Only", "Directed_Edges_Only");

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> classicEdgeDirectedUndirectedFilterIterator.validateOptions(options));
  }

  /**
   * Test {@link ClassicEdgeDirectedUndirectedFilterIterator#validateOptions(Map)}.
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ClassicEdgeDirectedUndirectedFilterIterator#validateOptions(Map)}
   */
  @Test
  @DisplayName("Test validateOptions(Map); when HashMap(); then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ClassicEdgeDirectedUndirectedFilterIterator.validateOptions(Map)"})
  void testValidateOptions_whenHashMap_thenReturnTrue() {
    // Arrange
    ClassicEdgeDirectedUndirectedFilterIterator classicEdgeDirectedUndirectedFilterIterator = new ClassicEdgeDirectedUndirectedFilterIterator();

    // Act and Assert
    assertTrue(classicEdgeDirectedUndirectedFilterIterator.validateOptions(new HashMap<>()));
  }

  /**
   * Test {@link ClassicEdgeDirectedUndirectedFilterIterator#describeOptions()}.
   * <p>
   * Method under test: {@link ClassicEdgeDirectedUndirectedFilterIterator#describeOptions()}
   */
  @Test
  @DisplayName("Test describeOptions()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"IteratorOptions ClassicEdgeDirectedUndirectedFilterIterator.describeOptions()"})
  void testDescribeOptions() {
    // Arrange and Act
    IteratorOptions actualDescribeOptionsResult = (new ClassicEdgeDirectedUndirectedFilterIterator()).describeOptions();

    // Assert
    assertEquals("Edge_Entity_Directed_Undirected_Incoming_Outgoing_Filter", actualDescribeOptionsResult.getName());
    assertEquals("Only returns Entities or Edges that are directed undirected incoming or outgoing as specified by the"
        + " user's options", actualDescribeOptionsResult.getDescription());
    Map<String, String> namedOptions = actualDescribeOptionsResult.getNamedOptions();
    assertEquals(8, namedOptions.size());
    assertEquals("Optional : Set if only directed edges should be returned", namedOptions.get("Directed_Edges_Only"));
    assertEquals("Optional: Set if entities should be returned", namedOptions.get("Include_All_Entities"));
    assertEquals("Optional: Set if only incoming edges should be returned", namedOptions.get("Incoming_Edges_Only"));
    assertEquals("Optional: Set if only outgoing edges should be returned", namedOptions.get("Outgoing_Edges_Only"));
    assertEquals("Optional: Set if only undirected edges should be returned",
        namedOptions.get("Undirected_Edges_Only"));
    assertEquals("default false keeps k/v that pass accept method, true rejects k/v that pass accept method",
        namedOptions.get("negate"));
    assertNull(actualDescribeOptionsResult.getUnnamedOptionDescriptions());
  }

  /**
   * Test new {@link ClassicEdgeDirectedUndirectedFilterIterator} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of {@link ClassicEdgeDirectedUndirectedFilterIterator}
   */
  @Test
  @DisplayName("Test new ClassicEdgeDirectedUndirectedFilterIterator (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void ClassicEdgeDirectedUndirectedFilterIterator.<init>()"})
  void testNewClassicEdgeDirectedUndirectedFilterIterator() {
    // Arrange, Act and Assert
    IteratorOptions describeOptionsResult = (new ClassicEdgeDirectedUndirectedFilterIterator()).describeOptions();
    assertEquals("Edge_Entity_Directed_Undirected_Incoming_Outgoing_Filter", describeOptionsResult.getName());
    assertEquals("Only returns Entities or Edges that are directed undirected incoming or outgoing as specified by the"
        + " user's options", describeOptionsResult.getDescription());
    Map<String, String> namedOptions = describeOptionsResult.getNamedOptions();
    assertEquals(8, namedOptions.size());
    assertEquals("Optional : Set if only directed edges should be returned", namedOptions.get("Directed_Edges_Only"));
    assertEquals("Optional: Set if entities should be returned", namedOptions.get("Include_All_Entities"));
    assertEquals("Optional: Set if only undirected edges should be returned",
        namedOptions.get("Undirected_Edges_Only"));
    assertEquals("default false keeps k/v that pass accept method, true rejects k/v that pass accept method",
        namedOptions.get("negate"));
    assertNull(describeOptionsResult.getUnnamedOptionDescriptions());
  }
}
