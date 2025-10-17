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
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Map;
import org.apache.accumulo.core.data.Key;
import org.apache.accumulo.core.data.Value;
import org.apache.accumulo.core.file.rfile.RFile;
import org.apache.accumulo.core.iterators.OptionDescriber;
import org.apache.accumulo.core.iterators.OptionDescriber.IteratorOptions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ClassicRangeElementPropertyFilterIteratorDiffblueTest {
  /**
   * Test {@link ClassicRangeElementPropertyFilterIterator#accept(Key, Value)}.
   *
   * <ul>
   *   <li>When {@link Key#Key(CharSequence)} with row is {@link RFile#EXTENSION}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ClassicRangeElementPropertyFilterIterator#accept(Key, Value)}
   */
  @Test
  @DisplayName(
      "Test accept(Key, Value); when Key(CharSequence) with row is EXTENSION; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ClassicRangeElementPropertyFilterIterator.accept(Key, Value)"})
  void testAccept_whenKeyWithRowIsExtension_thenReturnFalse() {
    // Arrange
    ClassicRangeElementPropertyFilterIterator classicRangeElementPropertyFilterIterator =
        new ClassicRangeElementPropertyFilterIterator();
    Key key = new Key(RFile.EXTENSION);

    // Act and Assert
    assertFalse(classicRangeElementPropertyFilterIterator.accept(key, new Value()));
  }

  /**
   * Test {@link ClassicRangeElementPropertyFilterIterator#accept(Key, Value)}.
   *
   * <ul>
   *   <li>When {@link Key#Key()}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ClassicRangeElementPropertyFilterIterator#accept(Key, Value)}
   */
  @Test
  @DisplayName("Test accept(Key, Value); when Key(); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ClassicRangeElementPropertyFilterIterator.accept(Key, Value)"})
  void testAccept_whenKey_thenReturnFalse() {
    // Arrange
    ClassicRangeElementPropertyFilterIterator classicRangeElementPropertyFilterIterator =
        new ClassicRangeElementPropertyFilterIterator();
    Key key = new Key();

    // Act and Assert
    assertFalse(classicRangeElementPropertyFilterIterator.accept(key, new Value()));
  }

  /**
   * Test {@link ClassicRangeElementPropertyFilterIterator#hasDelimiter(Key)}.
   *
   * <ul>
   *   <li>When {@link Key#Key(CharSequence)} with row is {@link RFile#EXTENSION}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ClassicRangeElementPropertyFilterIterator#hasDelimiter(Key)}
   */
  @Test
  @DisplayName(
      "Test hasDelimiter(Key); when Key(CharSequence) with row is EXTENSION; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ClassicRangeElementPropertyFilterIterator.hasDelimiter(Key)"})
  void testHasDelimiter_whenKeyWithRowIsExtension_thenReturnFalse() {
    // Arrange
    ClassicRangeElementPropertyFilterIterator classicRangeElementPropertyFilterIterator =
        new ClassicRangeElementPropertyFilterIterator();

    // Act
    boolean actualHasDelimiterResult =
        classicRangeElementPropertyFilterIterator.hasDelimiter(new Key(RFile.EXTENSION));

    // Assert
    assertFalse(actualHasDelimiterResult);
  }

  /**
   * Test {@link ClassicRangeElementPropertyFilterIterator#hasDelimiter(Key)}.
   *
   * <ul>
   *   <li>When {@link Key#Key()}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ClassicRangeElementPropertyFilterIterator#hasDelimiter(Key)}
   */
  @Test
  @DisplayName("Test hasDelimiter(Key); when Key(); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ClassicRangeElementPropertyFilterIterator.hasDelimiter(Key)"})
  void testHasDelimiter_whenKey_thenReturnFalse() {
    // Arrange
    ClassicRangeElementPropertyFilterIterator classicRangeElementPropertyFilterIterator =
        new ClassicRangeElementPropertyFilterIterator();

    // Act and Assert
    assertFalse(classicRangeElementPropertyFilterIterator.hasDelimiter(new Key()));
  }

  /**
   * Test {@link ClassicRangeElementPropertyFilterIterator#describeOptions()}.
   *
   * <p>Method under test: {@link ClassicRangeElementPropertyFilterIterator#describeOptions()}
   */
  @Test
  @DisplayName("Test describeOptions()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IteratorOptions ClassicRangeElementPropertyFilterIterator.describeOptions()"})
  void testDescribeOptions() {
    // Arrange and Act
    IteratorOptions actualDescribeOptionsResult =
        new ClassicRangeElementPropertyFilterIterator().describeOptions();

    // Assert
    assertEquals(
        "Only returns Entities or Edges that are directed undirected incoming or outgoing as specified by the"
            + " user's options",
        actualDescribeOptionsResult.getDescription());
    Map<String, String> namedOptions = actualDescribeOptionsResult.getNamedOptions();
    assertEquals(3, namedOptions.size());
    assertEquals(
        "Optional: Set if edges should be returned", namedOptions.get("Include_All_Edges"));
    assertEquals(
        "Optional: Set if entities should be returned", namedOptions.get("Include_All_Entities"));
    assertEquals("Range_Element_Property_Filter", actualDescribeOptionsResult.getName());
    assertEquals(
        "default false keeps k/v that pass accept method, true rejects k/v that pass accept method",
        namedOptions.get("negate"));
    assertNull(actualDescribeOptionsResult.getUnnamedOptionDescriptions());
  }

  /**
   * Test new {@link ClassicRangeElementPropertyFilterIterator} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link
   * ClassicRangeElementPropertyFilterIterator}
   */
  @Test
  @DisplayName("Test new ClassicRangeElementPropertyFilterIterator (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ClassicRangeElementPropertyFilterIterator.<init>()"})
  void testNewClassicRangeElementPropertyFilterIterator() {
    // Arrange and Act
    ClassicRangeElementPropertyFilterIterator actualClassicRangeElementPropertyFilterIterator =
        new ClassicRangeElementPropertyFilterIterator();

    // Assert
    assertFalse(actualClassicRangeElementPropertyFilterIterator.edges);
    assertFalse(actualClassicRangeElementPropertyFilterIterator.entities);
  }
}
