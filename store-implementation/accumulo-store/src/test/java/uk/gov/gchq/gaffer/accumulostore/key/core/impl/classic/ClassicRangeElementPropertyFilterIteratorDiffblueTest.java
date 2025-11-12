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
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.apache.accumulo.core.conf.DefaultConfiguration;
import org.apache.accumulo.core.conf.Property;
import org.apache.accumulo.core.data.Key;
import org.apache.accumulo.core.data.Value;
import org.apache.accumulo.core.file.BloomFilterLayer;
import org.apache.accumulo.core.file.map.MapFileOperations;
import org.apache.accumulo.core.iterators.ColumnFamilyCounter;
import org.apache.accumulo.core.iterators.IteratorEnvironment;
import org.apache.accumulo.core.iterators.OptionDescriber;
import org.apache.accumulo.core.iterators.SortedKeyValueIterator;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class ClassicRangeElementPropertyFilterIteratorDiffblueTest {
  /**
   * Method under test:
   * {@link ClassicRangeElementPropertyFilterIterator#accept(Key, Value)}
   */
  @Test
  void testAccept() {
    // Arrange
    ClassicRangeElementPropertyFilterIterator classicRangeElementPropertyFilterIterator = new ClassicRangeElementPropertyFilterIterator();
    Key key = new Key();

    // Act and Assert
    assertFalse(classicRangeElementPropertyFilterIterator.accept(key, new Value()));
  }

  /**
   * Method under test:
   * {@link ClassicRangeElementPropertyFilterIterator#accept(Key, Value)}
   */
  @Test
  void testAccept2() {
    // Arrange
    ClassicRangeElementPropertyFilterIterator classicRangeElementPropertyFilterIterator = new ClassicRangeElementPropertyFilterIterator();
    Key key = new Key(System.lineSeparator());

    // Act and Assert
    assertFalse(classicRangeElementPropertyFilterIterator.accept(key, new Value()));
  }

  /**
   * Method under test:
   * {@link ClassicRangeElementPropertyFilterIterator#hasDelimiter(Key)}
   */
  @Test
  void testHasDelimiter() {
    // Arrange
    ClassicRangeElementPropertyFilterIterator classicRangeElementPropertyFilterIterator = new ClassicRangeElementPropertyFilterIterator();

    // Act and Assert
    assertFalse(classicRangeElementPropertyFilterIterator.hasDelimiter(new Key()));
  }

  /**
   * Method under test:
   * {@link ClassicRangeElementPropertyFilterIterator#hasDelimiter(Key)}
   */
  @Test
  void testHasDelimiter2() {
    // Arrange
    ClassicRangeElementPropertyFilterIterator classicRangeElementPropertyFilterIterator = new ClassicRangeElementPropertyFilterIterator();

    // Act and Assert
    assertFalse(classicRangeElementPropertyFilterIterator.hasDelimiter(new Key(System.lineSeparator())));
  }

  /**
   * Method under test:
   * {@link ClassicRangeElementPropertyFilterIterator#init(SortedKeyValueIterator, Map, IteratorEnvironment)}
   */
  @Test
  void testInit() throws IOException {
    // Arrange
    ClassicRangeElementPropertyFilterIterator classicRangeElementPropertyFilterIterator = new ClassicRangeElementPropertyFilterIterator();
    DefaultConfiguration acuconf = mock(DefaultConfiguration.class);
    when(acuconf.getCount(Mockito.<Property>any())).thenReturn(3);
    when(acuconf.get(Mockito.<Property>any())).thenReturn("Get");
    BloomFilterLayer.Reader source = new BloomFilterLayer.Reader(
        new MapFileOperations.RangeIterator(mock(ColumnFamilyCounter.class)), acuconf);

    // Act
    classicRangeElementPropertyFilterIterator.init(source, new HashMap<>(), null);

    // Assert
    verify(acuconf, atLeast(1)).getCount(Mockito.<Property>any());
    verify(acuconf).get(eq(Property.TABLE_CLASSPATH));
  }

  /**
   * Method under test:
   * {@link ClassicRangeElementPropertyFilterIterator#describeOptions()}
   */
  @Test
  void testDescribeOptions() {
    // Arrange and Act
    OptionDescriber.IteratorOptions actualDescribeOptionsResult = (new ClassicRangeElementPropertyFilterIterator())
        .describeOptions();

    // Assert
    assertEquals("Only returns Entities or Edges that are directed undirected incoming or outgoing as specified by the"
        + " user's options", actualDescribeOptionsResult.getDescription());
    Map<String, String> namedOptions = actualDescribeOptionsResult.getNamedOptions();
    assertEquals(3, namedOptions.size());
    assertEquals("Optional: Set if edges should be returned", namedOptions.get("Include_All_Edges"));
    assertEquals("Optional: Set if entities should be returned", namedOptions.get("Include_All_Entities"));
    assertEquals("Range_Element_Property_Filter", actualDescribeOptionsResult.getName());
    assertEquals("default false keeps k/v that pass accept method, true rejects k/v that pass accept method",
        namedOptions.get("negate"));
    assertNull(actualDescribeOptionsResult.getUnnamedOptionDescriptions());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link ClassicRangeElementPropertyFilterIterator}
   */
  @Test
  void testNewClassicRangeElementPropertyFilterIterator() {
    // Arrange and Act
    ClassicRangeElementPropertyFilterIterator actualClassicRangeElementPropertyFilterIterator = new ClassicRangeElementPropertyFilterIterator();

    // Assert
    assertFalse(actualClassicRangeElementPropertyFilterIterator.edges);
    assertFalse(actualClassicRangeElementPropertyFilterIterator.entities);
  }
}
