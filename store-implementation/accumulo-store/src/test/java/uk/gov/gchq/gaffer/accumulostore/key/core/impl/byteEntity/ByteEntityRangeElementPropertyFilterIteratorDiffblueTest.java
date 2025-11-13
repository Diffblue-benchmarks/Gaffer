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

package uk.gov.gchq.gaffer.accumulostore.key.core.impl.byteEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashMap;
import java.util.Map;
import org.apache.accumulo.core.data.Key;
import org.apache.accumulo.core.data.Value;
import org.apache.accumulo.core.file.rfile.RFile;
import org.apache.accumulo.core.iterators.OptionDescriber;
import org.apache.accumulo.core.iterators.OptionDescriber.IteratorOptions;
import org.apache.accumulo.tserver.MemKey;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ByteEntityRangeElementPropertyFilterIteratorDiffblueTest {
  /**
   * Test {@link ByteEntityRangeElementPropertyFilterIterator#accept(Key, Value)}.
   *
   * <ul>
   *   <li>When {@code A}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ByteEntityRangeElementPropertyFilterIterator#accept(Key, Value)}
   */
  @Test
  @DisplayName("Test accept(Key, Value); when 'A'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ByteEntityRangeElementPropertyFilterIterator.accept(Key, Value)"})
  void testAccept_whenA_thenReturnFalse() {
    // Arrange
    ByteEntityRangeElementPropertyFilterIterator byteEntityRangeElementPropertyFilterIterator =
        new ByteEntityRangeElementPropertyFilterIterator();
    MemKey key =
        new MemKey(
            new byte[] {
              'A',
              ByteEntityPositions.ENTITY,
              'A',
              ByteEntityPositions.ENTITY,
              'A',
              ByteEntityPositions.ENTITY,
              'A',
              ByteEntityPositions.ENTITY
            },
            new byte[] {
              'A',
              ByteEntityPositions.ENTITY,
              'A',
              ByteEntityPositions.ENTITY,
              'A',
              ByteEntityPositions.ENTITY,
              'A',
              ByteEntityPositions.ENTITY
            },
            new byte[] {
              'A',
              ByteEntityPositions.ENTITY,
              'A',
              ByteEntityPositions.ENTITY,
              'A',
              ByteEntityPositions.ENTITY,
              'A',
              ByteEntityPositions.ENTITY
            },
            new byte[] {
              'A',
              ByteEntityPositions.ENTITY,
              'A',
              ByteEntityPositions.ENTITY,
              'A',
              ByteEntityPositions.ENTITY,
              'A',
              ByteEntityPositions.ENTITY
            },
            1L,
            true,
            true,
            1);

    // Act and Assert
    assertFalse(byteEntityRangeElementPropertyFilterIterator.accept(key, new Value()));
  }

  /**
   * Test {@link ByteEntityRangeElementPropertyFilterIterator#accept(Key, Value)}.
   *
   * <ul>
   *   <li>When {@link Key#Key(CharSequence)} with row is {@link RFile#EXTENSION}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ByteEntityRangeElementPropertyFilterIterator#accept(Key, Value)}
   */
  @Test
  @DisplayName(
      "Test accept(Key, Value); when Key(CharSequence) with row is EXTENSION; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ByteEntityRangeElementPropertyFilterIterator.accept(Key, Value)"})
  void testAccept_whenKeyWithRowIsExtension_thenReturnFalse() {
    // Arrange
    ByteEntityRangeElementPropertyFilterIterator byteEntityRangeElementPropertyFilterIterator =
        new ByteEntityRangeElementPropertyFilterIterator();
    Key key = new Key(RFile.EXTENSION);

    // Act and Assert
    assertFalse(byteEntityRangeElementPropertyFilterIterator.accept(key, new Value()));
  }

  /**
   * Test {@link ByteEntityRangeElementPropertyFilterIterator#validateOptions(Map)}.
   *
   * <ul>
   *   <li>Given {@code negate}.
   *   <li>When {@link HashMap#HashMap()} {@code negate} is {@link Boolean#TRUE} toString.
   * </ul>
   *
   * <p>Method under test: {@link ByteEntityRangeElementPropertyFilterIterator#validateOptions(Map)}
   */
  @Test
  @DisplayName(
      "Test validateOptions(Map); given 'negate'; when HashMap() 'negate' is TRUE toString")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ByteEntityRangeElementPropertyFilterIterator.validateOptions(Map)"})
  void testValidateOptions_givenNegate_whenHashMapNegateIsTrueToString() {
    // Arrange
    ByteEntityRangeElementPropertyFilterIterator byteEntityRangeElementPropertyFilterIterator =
        new ByteEntityRangeElementPropertyFilterIterator();

    HashMap<String, String> options = new HashMap<>();
    options.put("negate", Boolean.TRUE.toString());
    options.put("Directed_Edges_Only", "Options");
    options.put("Undirected_Edges_Only", "Options");
    options.put("Incoming_Edges_Only", "Options");
    options.put("Outgoing_Edges_Only", "Options");

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> byteEntityRangeElementPropertyFilterIterator.validateOptions(options));
  }

  /**
   * Test {@link ByteEntityRangeElementPropertyFilterIterator#validateOptions(Map)}.
   *
   * <ul>
   *   <li>When {@link HashMap#HashMap()} {@code Directed_Edges_Only} is {@code
   *       Directed_Edges_Only}.
   * </ul>
   *
   * <p>Method under test: {@link ByteEntityRangeElementPropertyFilterIterator#validateOptions(Map)}
   */
  @Test
  @DisplayName(
      "Test validateOptions(Map); when HashMap() 'Directed_Edges_Only' is 'Directed_Edges_Only'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ByteEntityRangeElementPropertyFilterIterator.validateOptions(Map)"})
  void testValidateOptions_whenHashMapDirectedEdgesOnlyIsDirectedEdgesOnly() {
    // Arrange
    ByteEntityRangeElementPropertyFilterIterator byteEntityRangeElementPropertyFilterIterator =
        new ByteEntityRangeElementPropertyFilterIterator();

    HashMap<String, String> options = new HashMap<>();
    options.put("Directed_Edges_Only", "Directed_Edges_Only");

    // Act and Assert
    assertTrue(byteEntityRangeElementPropertyFilterIterator.validateOptions(options));
  }

  /**
   * Test {@link ByteEntityRangeElementPropertyFilterIterator#validateOptions(Map)}.
   *
   * <ul>
   *   <li>When {@link HashMap#HashMap()} {@code Incoming_Edges_Only} is {@code
   *       Directed_Edges_Only}.
   * </ul>
   *
   * <p>Method under test: {@link ByteEntityRangeElementPropertyFilterIterator#validateOptions(Map)}
   */
  @Test
  @DisplayName(
      "Test validateOptions(Map); when HashMap() 'Incoming_Edges_Only' is 'Directed_Edges_Only'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ByteEntityRangeElementPropertyFilterIterator.validateOptions(Map)"})
  void testValidateOptions_whenHashMapIncomingEdgesOnlyIsDirectedEdgesOnly() {
    // Arrange
    ByteEntityRangeElementPropertyFilterIterator byteEntityRangeElementPropertyFilterIterator =
        new ByteEntityRangeElementPropertyFilterIterator();

    HashMap<String, String> options = new HashMap<>();
    options.put("Incoming_Edges_Only", "Directed_Edges_Only");

    // Act and Assert
    assertTrue(byteEntityRangeElementPropertyFilterIterator.validateOptions(options));
  }

  /**
   * Test {@link ByteEntityRangeElementPropertyFilterIterator#validateOptions(Map)}.
   *
   * <ul>
   *   <li>When {@link HashMap#HashMap()} {@code Outgoing_Edges_Only} is {@code
   *       Outgoing_Edges_Only}.
   * </ul>
   *
   * <p>Method under test: {@link ByteEntityRangeElementPropertyFilterIterator#validateOptions(Map)}
   */
  @Test
  @DisplayName(
      "Test validateOptions(Map); when HashMap() 'Outgoing_Edges_Only' is 'Outgoing_Edges_Only'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ByteEntityRangeElementPropertyFilterIterator.validateOptions(Map)"})
  void testValidateOptions_whenHashMapOutgoingEdgesOnlyIsOutgoingEdgesOnly() {
    // Arrange
    ByteEntityRangeElementPropertyFilterIterator byteEntityRangeElementPropertyFilterIterator =
        new ByteEntityRangeElementPropertyFilterIterator();

    HashMap<String, String> options = new HashMap<>();
    options.put("Outgoing_Edges_Only", "Outgoing_Edges_Only");
    options.put("Incoming_Edges_Only", "Directed_Edges_Only");

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> byteEntityRangeElementPropertyFilterIterator.validateOptions(options));
  }

  /**
   * Test {@link ByteEntityRangeElementPropertyFilterIterator#validateOptions(Map)}.
   *
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link ByteEntityRangeElementPropertyFilterIterator#validateOptions(Map)}
   */
  @Test
  @DisplayName("Test validateOptions(Map); when HashMap(); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ByteEntityRangeElementPropertyFilterIterator.validateOptions(Map)"})
  void testValidateOptions_whenHashMap_thenReturnTrue() {
    // Arrange
    ByteEntityRangeElementPropertyFilterIterator byteEntityRangeElementPropertyFilterIterator =
        new ByteEntityRangeElementPropertyFilterIterator();

    // Act and Assert
    assertTrue(byteEntityRangeElementPropertyFilterIterator.validateOptions(new HashMap<>()));
  }

  /**
   * Test {@link ByteEntityRangeElementPropertyFilterIterator#describeOptions()}.
   *
   * <p>Method under test: {@link ByteEntityRangeElementPropertyFilterIterator#describeOptions()}
   */
  @Test
  @DisplayName("Test describeOptions()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "IteratorOptions ByteEntityRangeElementPropertyFilterIterator.describeOptions()"
  })
  void testDescribeOptions() {
    // Arrange and Act
    IteratorOptions actualDescribeOptionsResult =
        new ByteEntityRangeElementPropertyFilterIterator().describeOptions();

    // Assert
    assertEquals(
        "Only returns Entities or Edges that are directed undirected incoming or outgoing as specified by the"
            + " user's options",
        actualDescribeOptionsResult.getDescription());
    Map<String, String> namedOptions = actualDescribeOptionsResult.getNamedOptions();
    assertEquals(8, namedOptions.size());
    assertEquals(
        "Optional : Set if only directed edges should be returned",
        namedOptions.get("Directed_Edges_Only"));
    assertEquals(
        "Optional: Set if entities should be returned", namedOptions.get("Include_All_Entities"));
    assertEquals(
        "Optional: Set if only incoming edges should be returned",
        namedOptions.get("Incoming_Edges_Only"));
    assertEquals(
        "Optional: Set if only outgoing edges should be returned",
        namedOptions.get("Outgoing_Edges_Only"));
    assertEquals(
        "Optional: Set if only undirected edges should be returned",
        namedOptions.get("Undirected_Edges_Only"));
    assertEquals("Range_Element_Property_Filter", actualDescribeOptionsResult.getName());
    assertEquals(
        "default false keeps k/v that pass accept method, true rejects k/v that pass accept method",
        namedOptions.get("negate"));
    assertNull(actualDescribeOptionsResult.getUnnamedOptionDescriptions());
  }

  /**
   * Test new {@link ByteEntityRangeElementPropertyFilterIterator} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link
   * ByteEntityRangeElementPropertyFilterIterator}
   */
  @Test
  @DisplayName("Test new ByteEntityRangeElementPropertyFilterIterator (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ByteEntityRangeElementPropertyFilterIterator.<init>()"})
  void testNewByteEntityRangeElementPropertyFilterIterator() {
    // Arrange, Act and Assert
    IteratorOptions describeOptionsResult =
        new ByteEntityRangeElementPropertyFilterIterator().describeOptions();
    assertEquals(
        "Only returns Entities or Edges that are directed undirected incoming or outgoing as specified by the"
            + " user's options",
        describeOptionsResult.getDescription());
    Map<String, String> namedOptions = describeOptionsResult.getNamedOptions();
    assertEquals(8, namedOptions.size());
    assertEquals(
        "Optional : Set if only directed edges should be returned",
        namedOptions.get("Directed_Edges_Only"));
    assertEquals(
        "Optional: Set if entities should be returned", namedOptions.get("Include_All_Entities"));
    assertEquals(
        "Optional: Set if only undirected edges should be returned",
        namedOptions.get("Undirected_Edges_Only"));
    assertEquals("Range_Element_Property_Filter", describeOptionsResult.getName());
    assertEquals(
        "default false keeps k/v that pass accept method, true rejects k/v that pass accept method",
        namedOptions.get("negate"));
    assertNull(describeOptionsResult.getUnnamedOptionDescriptions());
  }
}
