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

package uk.gov.gchq.gaffer.accumulostore.key.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.apache.accumulo.core.conf.DefaultConfiguration;
import org.apache.accumulo.core.data.ByteSequence;
import org.apache.accumulo.core.data.Key;
import org.apache.accumulo.core.data.Range;
import org.apache.accumulo.core.file.BloomFilterLayer;
import org.apache.accumulo.core.file.BloomFilterLayer.Reader;
import org.apache.accumulo.core.file.map.MapFileOperations;
import org.apache.accumulo.core.file.map.MapFileOperations.RangeIterator;
import org.apache.accumulo.core.iterators.ColumnFamilyCounter;
import org.apache.accumulo.core.iterators.OptionDescriber;
import org.apache.accumulo.core.iterators.OptionDescriber.IteratorOptions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import uk.gov.gchq.gaffer.accumulostore.key.core.impl.byteEntity.ByteEntityAccumuloElementConverter;
import uk.gov.gchq.gaffer.accumulostore.key.impl.RowIDAggregator.PropertiesIterator;
import uk.gov.gchq.gaffer.store.schema.Schema;

class RowIDAggregatorDiffblueTest {
  /**
   * Test new {@link RowIDAggregator} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of {@link RowIDAggregator}
   */
  @Test
  @DisplayName("Test new RowIDAggregator (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void RowIDAggregator.<init>()"})
  void testNewRowIDAggregator() {
    // Arrange and Act
    RowIDAggregator actualRowIDAggregator = new RowIDAggregator();

    // Assert
    assertNull(actualRowIDAggregator.getTopKey());
    assertNull(actualRowIDAggregator.getTopValue());
  }

  /**
   * Test {@link RowIDAggregator#describeOptions()}.
   * <p>
   * Method under test: {@link RowIDAggregator#describeOptions()}
   */
  @Test
  @DisplayName("Test describeOptions()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"IteratorOptions RowIDAggregator.describeOptions()"})
  void testDescribeOptions() {
    // Arrange and Act
    IteratorOptions actualDescribeOptionsResult = (new RowIDAggregator()).describeOptions();

    // Assert
    assertEquals("Applies a findTop function to triples of (column qualifier, column visibility, value) with identical"
        + " (rowKey, column family)", actualDescribeOptionsResult.getDescription());
    assertEquals("Column_Qualifier_Aggregator", actualDescribeOptionsResult.getName());
    Map<String, String> namedOptions = actualDescribeOptionsResult.getNamedOptions();
    assertEquals(2, namedOptions.size());
    assertEquals("Required: The element converter class to be used for key/value conversion",
        namedOptions.get("accumulostore.key.element_converter"));
    assertEquals("Required: The json serialised form of the schema", namedOptions.get("Schema"));
    assertNull(actualDescribeOptionsResult.getUnnamedOptionDescriptions());
  }

  /**
   * Test PropertiesIterator {@link PropertiesIterator#hasNext()}.
   * <ul>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PropertiesIterator#hasNext()}
   */
  @Test
  @DisplayName("Test PropertiesIterator hasNext(); then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean PropertiesIterator.hasNext()"})
  void testPropertiesIteratorHasNext_thenReturnFalse() throws IOException {
    // Arrange
    RangeIterator reader = new RangeIterator(new ColumnFamilyCounter());
    Reader source = new Reader(reader, DefaultConfiguration.getInstance());

    Range currentRange = new Range();
    ArrayList<ByteSequence> currentColumnFamilies = new ArrayList<>();
    Key workKeyRef = new Key();

    // Act and Assert
    assertFalse((new PropertiesIterator(source, currentRange, currentColumnFamilies, true, "Group", workKeyRef,
        new ByteEntityAccumuloElementConverter(new Schema()))).hasNext());
  }

  /**
   * Test PropertiesIterator {@link PropertiesIterator#next()}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PropertiesIterator#next()}
   */
  @Test
  @DisplayName("Test PropertiesIterator next(); then throw RuntimeException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"uk.gov.gchq.gaffer.data.element.Properties PropertiesIterator.next()"})
  void testPropertiesIteratorNext_thenThrowRuntimeException() throws IOException {
    // Arrange
    ColumnFamilyCounter source = mock(ColumnFamilyCounter.class);
    doThrow(new IOException("foo")).when(source).next();
    Key workKeyRef = mock(Key.class);
    doNothing().when(workKeyRef).set(Mockito.<Key>any());
    Range currentRange = new Range();
    ArrayList<ByteSequence> currentColumnFamilies = new ArrayList<>();

    // Act and Assert
    assertThrows(RuntimeException.class, () -> (new PropertiesIterator(source, currentRange, currentColumnFamilies,
        true, "Group", workKeyRef, new ByteEntityAccumuloElementConverter(new Schema()))).next());
    verify(workKeyRef).set(isNull());
    verify(source).next();
  }

  /**
   * Test PropertiesIterator {@link PropertiesIterator#remove()}.
   * <ul>
   *   <li>Then throw {@link UnsupportedOperationException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PropertiesIterator#remove()}
   */
  @Test
  @DisplayName("Test PropertiesIterator remove(); then throw UnsupportedOperationException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PropertiesIterator.remove()"})
  void testPropertiesIteratorRemove_thenThrowUnsupportedOperationException() throws IOException {
    // Arrange
    RangeIterator reader = new RangeIterator(new ColumnFamilyCounter());
    Reader source = new Reader(reader, DefaultConfiguration.getInstance());

    Range currentRange = new Range();
    ArrayList<ByteSequence> currentColumnFamilies = new ArrayList<>();
    Key workKeyRef = new Key();

    // Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new PropertiesIterator(source, currentRange, currentColumnFamilies, true, "Group", workKeyRef,
            new ByteEntityAccumuloElementConverter(new Schema()))).remove());
  }

  /**
   * Test {@link RowIDAggregator#validateOptions(Map)}.
   * <ul>
   *   <li>Given {@code Options}.</li>
   *   <li>When {@link HashMap#HashMap()} {@code Schema} is {@code Options}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RowIDAggregator#validateOptions(Map)}
   */
  @Test
  @DisplayName("Test validateOptions(Map); given 'Options'; when HashMap() 'Schema' is 'Options'; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean RowIDAggregator.validateOptions(Map)"})
  void testValidateOptions_givenOptions_whenHashMapSchemaIsOptions_thenReturnTrue() {
    // Arrange
    RowIDAggregator rowIDAggregator = new RowIDAggregator();

    HashMap<String, String> options = new HashMap<>();
    options.put("Schema", "Options");
    options.put("columnFamily", "Options");

    // Act and Assert
    assertTrue(rowIDAggregator.validateOptions(options));
  }

  /**
   * Test {@link RowIDAggregator#validateOptions(Map)}.
   * <ul>
   *   <li>When {@link HashMap#HashMap()} {@code Schema} is {@code Schema}.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RowIDAggregator#validateOptions(Map)}
   */
  @Test
  @DisplayName("Test validateOptions(Map); when HashMap() 'Schema' is 'Schema'; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean RowIDAggregator.validateOptions(Map)"})
  void testValidateOptions_whenHashMapSchemaIsSchema_thenThrowIllegalArgumentException() {
    // Arrange
    RowIDAggregator rowIDAggregator = new RowIDAggregator();

    HashMap<String, String> options = new HashMap<>();
    options.put("Schema", "Schema");

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> rowIDAggregator.validateOptions(options));
  }

  /**
   * Test {@link RowIDAggregator#validateOptions(Map)}.
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RowIDAggregator#validateOptions(Map)}
   */
  @Test
  @DisplayName("Test validateOptions(Map); when HashMap(); then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean RowIDAggregator.validateOptions(Map)"})
  void testValidateOptions_whenHashMap_thenThrowIllegalArgumentException() {
    // Arrange
    RowIDAggregator rowIDAggregator = new RowIDAggregator();

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> rowIDAggregator.validateOptions(new HashMap<>()));
  }

  /**
   * Test {@link RowIDAggregator#getTopKey()}.
   * <p>
   * Method under test: {@link RowIDAggregator#getTopKey()}
   */
  @Test
  @DisplayName("Test getTopKey()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Key RowIDAggregator.getTopKey()"})
  void testGetTopKey() {
    // Arrange, Act and Assert
    assertNull((new RowIDAggregator()).getTopKey());
  }

  /**
   * Test {@link RowIDAggregator#getTopValue()}.
   * <p>
   * Method under test: {@link RowIDAggregator#getTopValue()}
   */
  @Test
  @DisplayName("Test getTopValue()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"org.apache.accumulo.core.data.Value RowIDAggregator.getTopValue()"})
  void testGetTopValue() {
    // Arrange, Act and Assert
    assertNull((new RowIDAggregator()).getTopValue());
  }

  /**
   * Test {@link RowIDAggregator#hasTop()}.
   * <p>
   * Method under test: {@link RowIDAggregator#hasTop()}
   */
  @Test
  @DisplayName("Test hasTop()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean RowIDAggregator.hasTop()"})
  void testHasTop() {
    // Arrange, Act and Assert
    assertFalse((new RowIDAggregator()).hasTop());
  }
}
