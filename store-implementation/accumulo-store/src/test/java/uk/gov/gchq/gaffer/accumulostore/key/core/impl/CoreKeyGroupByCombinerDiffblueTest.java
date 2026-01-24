/*
 * Copyright 2026 Crown Copyright
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
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import org.apache.accumulo.core.data.ArrayByteSequence;
import org.apache.accumulo.core.data.ByteSequence;
import org.apache.accumulo.core.data.Key;
import org.apache.accumulo.core.data.Range;
import org.apache.accumulo.core.data.Value;
import org.apache.accumulo.core.file.rfile.RFile;
import org.apache.accumulo.core.iterators.IteratorEnvironment;
import org.apache.accumulo.core.iterators.OptionDescriber;
import org.apache.accumulo.core.iterators.OptionDescriber.IteratorOptions;
import org.apache.accumulo.core.iterators.SortedKeyValueIterator;
import org.apache.hadoop.io.Text;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.accumulostore.key.AccumuloElementConverter;
import uk.gov.gchq.gaffer.accumulostore.key.core.impl.CoreKeyGroupByCombiner.KeyValueIterator;
import uk.gov.gchq.gaffer.accumulostore.key.core.impl.byteEntity.ByteEntityAccumuloElementConverter;
import uk.gov.gchq.gaffer.store.schema.Schema;

class CoreKeyGroupByCombinerDiffblueTest {
  /**
   * Test {@link CoreKeyGroupByCombiner#getTopKey()}.
   *
   * <p>Method under test: {@link CoreKeyGroupByCombiner#getTopKey()}
   */
  @Test
  @DisplayName("Test getTopKey()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Key CoreKeyGroupByCombiner.getTopKey()"})
  void testGetTopKey() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalStateException.class, () -> new CoreKeyGroupByAggregatorIterator().getTopKey());
  }

  /**
   * Test {@link CoreKeyGroupByCombiner#getTopValue()}.
   *
   * <p>Method under test: {@link CoreKeyGroupByCombiner#getTopValue()}
   */
  @Test
  @DisplayName("Test getTopValue()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Value CoreKeyGroupByCombiner.getTopValue()"})
  void testGetTopValue() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalStateException.class, () -> new CoreKeyGroupByAggregatorIterator().getTopValue());
  }

  /**
   * Test {@link CoreKeyGroupByCombiner#hasTop()}.
   *
   * <p>Method under test: {@link CoreKeyGroupByCombiner#hasTop()}
   */
  @Test
  @DisplayName("Test hasTop()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CoreKeyGroupByCombiner.hasTop()"})
  void testHasTop() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalStateException.class, () -> new CoreKeyGroupByAggregatorIterator().hasTop());
  }

  /**
   * Test KeyValueIterator {@link KeyValueIterator#KeyValueIterator(SortedKeyValueIterator, String,
   * AccumuloElementConverter, Schema, Set)}.
   *
   * <p>Method under test: {@link KeyValueIterator#KeyValueIterator(SortedKeyValueIterator, String,
   * AccumuloElementConverter, Schema, Set)}
   */
  @Test
  @DisplayName(
      "Test KeyValueIterator new KeyValueIterator(SortedKeyValueIterator, String, AccumuloElementConverter, Schema, Set)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void KeyValueIterator.<init>(SortedKeyValueIterator, String, AccumuloElementConverter, Schema, Set)"
  })
  void testKeyValueIteratorNewKeyValueIterator() {
    // Arrange
    Key key = mock(Key.class);
    when(key.getColumnFamily()).thenThrow(new NoSuchElementException());
    when(key.getRow()).thenReturn(new Text());

    SortedKeyValueIterator<Key, Value> source = mock(SortedKeyValueIterator.class);
    when(source.getTopKey()).thenReturn(key);
    ByteEntityAccumuloElementConverter elementConverter =
        new ByteEntityAccumuloElementConverter(new Schema());
    Schema schema = new Schema();

    HashSet<String> groupBy = new HashSet<>();
    groupBy.add("foo");

    // Act and Assert
    assertThrows(
        NoSuchElementException.class,
        () -> new KeyValueIterator(source, "Group", elementConverter, schema, groupBy));
    verify(key).getColumnFamily();
    verify(key).getRow();
    verify(source).getTopKey();
  }

  /**
   * Test KeyValueIterator {@link KeyValueIterator#KeyValueIterator(SortedKeyValueIterator, String,
   * AccumuloElementConverter, Schema, Set)}.
   *
   * <p>Method under test: {@link KeyValueIterator#KeyValueIterator(SortedKeyValueIterator, String,
   * AccumuloElementConverter, Schema, Set)}
   */
  @Test
  @DisplayName(
      "Test KeyValueIterator new KeyValueIterator(SortedKeyValueIterator, String, AccumuloElementConverter, Schema, Set)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void KeyValueIterator.<init>(SortedKeyValueIterator, String, AccumuloElementConverter, Schema, Set)"
  })
  void testKeyValueIteratorNewKeyValueIterator2() {
    // Arrange
    Key key = mock(Key.class);
    when(key.getColumnQualifier()).thenThrow(new NoSuchElementException());
    when(key.getColumnFamily()).thenReturn(new Text());
    when(key.getRow()).thenReturn(new Text());

    SortedKeyValueIterator<Key, Value> source = mock(SortedKeyValueIterator.class);
    when(source.getTopKey()).thenReturn(key);
    ByteEntityAccumuloElementConverter elementConverter =
        new ByteEntityAccumuloElementConverter(new Schema());
    Schema schema = new Schema();

    HashSet<String> groupBy = new HashSet<>();
    groupBy.add("foo");

    // Act and Assert
    assertThrows(
        NoSuchElementException.class,
        () -> new KeyValueIterator(source, "Group", elementConverter, schema, groupBy));
    verify(key).getColumnFamily();
    verify(key).getColumnQualifier();
    verify(key).getRow();
    verify(source).getTopKey();
  }

  /**
   * Test KeyValueIterator {@link KeyValueIterator#KeyValueIterator(SortedKeyValueIterator, String,
   * AccumuloElementConverter, Schema, Set)}.
   *
   * <p>Method under test: {@link KeyValueIterator#KeyValueIterator(SortedKeyValueIterator, String,
   * AccumuloElementConverter, Schema, Set)}
   */
  @Test
  @DisplayName(
      "Test KeyValueIterator new KeyValueIterator(SortedKeyValueIterator, String, AccumuloElementConverter, Schema, Set)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void KeyValueIterator.<init>(SortedKeyValueIterator, String, AccumuloElementConverter, Schema, Set)"
  })
  void testKeyValueIteratorNewKeyValueIterator3() {
    // Arrange
    Key key = mock(Key.class);
    when(key.getColumnVisibility()).thenThrow(new NoSuchElementException());
    when(key.getColumnQualifier()).thenReturn(new Text());
    when(key.getColumnFamily()).thenReturn(new Text());
    when(key.getRow()).thenReturn(new Text());

    SortedKeyValueIterator<Key, Value> source = mock(SortedKeyValueIterator.class);
    when(source.getTopKey()).thenReturn(key);
    ByteEntityAccumuloElementConverter elementConverter =
        new ByteEntityAccumuloElementConverter(new Schema());
    Schema schema = new Schema();

    HashSet<String> groupBy = new HashSet<>();
    groupBy.add("foo");

    // Act and Assert
    assertThrows(
        NoSuchElementException.class,
        () -> new KeyValueIterator(source, "Group", elementConverter, schema, groupBy));
    verify(key).getColumnFamily();
    verify(key).getColumnQualifier();
    verify(key).getColumnVisibility();
    verify(key).getRow();
    verify(source).getTopKey();
  }

  /**
   * Test KeyValueIterator {@link KeyValueIterator#KeyValueIterator(SortedKeyValueIterator, String,
   * AccumuloElementConverter, Schema, Set)}.
   *
   * <ul>
   *   <li>Given {@link Key} {@link Key#getColumnQualifier()} return {@link Text}.
   * </ul>
   *
   * <p>Method under test: {@link KeyValueIterator#KeyValueIterator(SortedKeyValueIterator, String,
   * AccumuloElementConverter, Schema, Set)}
   */
  @Test
  @DisplayName(
      "Test KeyValueIterator new KeyValueIterator(SortedKeyValueIterator, String, AccumuloElementConverter, Schema, Set); given Key getColumnQualifier() return Text")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void KeyValueIterator.<init>(SortedKeyValueIterator, String, AccumuloElementConverter, Schema, Set)"
  })
  void testKeyValueIteratorNewKeyValueIterator_givenKeyGetColumnQualifierReturnText()
      throws UnsupportedEncodingException {
    // Arrange
    Text text = mock(Text.class);
    when(text.getBytes()).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    Text text2 = mock(Text.class);
    when(text2.getBytes()).thenThrow(new NoSuchElementException());

    Key key = mock(Key.class);
    when(key.getColumnQualifier()).thenReturn(text2);
    when(key.getColumnFamily()).thenReturn(text);
    when(key.getRow()).thenReturn(new Text());

    SortedKeyValueIterator<Key, Value> source = mock(SortedKeyValueIterator.class);
    when(source.getTopKey()).thenReturn(key);
    ByteEntityAccumuloElementConverter elementConverter =
        new ByteEntityAccumuloElementConverter(new Schema());
    Schema schema = new Schema();

    HashSet<String> groupBy = new HashSet<>();
    groupBy.add("foo");

    // Act and Assert
    assertThrows(
        NoSuchElementException.class,
        () -> new KeyValueIterator(source, "Group", elementConverter, schema, groupBy));
    verify(key).getColumnFamily();
    verify(key).getColumnQualifier();
    verify(key).getRow();
    verify(source).getTopKey();
    verify(text2).getBytes();
    verify(text).getBytes();
  }

  /**
   * Test KeyValueIterator {@link KeyValueIterator#KeyValueIterator(SortedKeyValueIterator, String,
   * AccumuloElementConverter, Schema, Set)}.
   *
   * <ul>
   *   <li>Given {@link Key} {@link Key#getColumnVisibility()} return {@link Text}.
   * </ul>
   *
   * <p>Method under test: {@link KeyValueIterator#KeyValueIterator(SortedKeyValueIterator, String,
   * AccumuloElementConverter, Schema, Set)}
   */
  @Test
  @DisplayName(
      "Test KeyValueIterator new KeyValueIterator(SortedKeyValueIterator, String, AccumuloElementConverter, Schema, Set); given Key getColumnVisibility() return Text")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void KeyValueIterator.<init>(SortedKeyValueIterator, String, AccumuloElementConverter, Schema, Set)"
  })
  void testKeyValueIteratorNewKeyValueIterator_givenKeyGetColumnVisibilityReturnText()
      throws UnsupportedEncodingException {
    // Arrange
    Text text = mock(Text.class);
    when(text.getBytes()).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    Text text2 = mock(Text.class);
    when(text2.getBytes()).thenThrow(new NoSuchElementException());

    Key key = mock(Key.class);
    when(key.getColumnVisibility()).thenReturn(text2);
    when(key.getColumnQualifier()).thenReturn(text);
    when(key.getColumnFamily()).thenReturn(new Text());
    when(key.getRow()).thenReturn(new Text());

    SortedKeyValueIterator<Key, Value> source = mock(SortedKeyValueIterator.class);
    when(source.getTopKey()).thenReturn(key);
    ByteEntityAccumuloElementConverter elementConverter =
        new ByteEntityAccumuloElementConverter(new Schema());
    Schema schema = new Schema();

    HashSet<String> groupBy = new HashSet<>();
    groupBy.add("foo");

    // Act and Assert
    assertThrows(
        NoSuchElementException.class,
        () -> new KeyValueIterator(source, "Group", elementConverter, schema, groupBy));
    verify(key).getColumnFamily();
    verify(key).getColumnQualifier();
    verify(key).getColumnVisibility();
    verify(key).getRow();
    verify(source).getTopKey();
    verify(text2).getBytes();
    verify(text).getBytes();
  }

  /**
   * Test KeyValueIterator {@link KeyValueIterator#KeyValueIterator(SortedKeyValueIterator, String,
   * AccumuloElementConverter, Schema, Set)}.
   *
   * <ul>
   *   <li>Given {@link Key} {@link Key#getRow()} return {@link Text}.
   * </ul>
   *
   * <p>Method under test: {@link KeyValueIterator#KeyValueIterator(SortedKeyValueIterator, String,
   * AccumuloElementConverter, Schema, Set)}
   */
  @Test
  @DisplayName(
      "Test KeyValueIterator new KeyValueIterator(SortedKeyValueIterator, String, AccumuloElementConverter, Schema, Set); given Key getRow() return Text")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void KeyValueIterator.<init>(SortedKeyValueIterator, String, AccumuloElementConverter, Schema, Set)"
  })
  void testKeyValueIteratorNewKeyValueIterator_givenKeyGetRowReturnText()
      throws UnsupportedEncodingException {
    // Arrange
    Text text = mock(Text.class);
    when(text.getBytes()).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    Text text2 = mock(Text.class);
    when(text2.getBytes()).thenThrow(new NoSuchElementException());

    Key key = mock(Key.class);
    when(key.getColumnFamily()).thenReturn(text2);
    when(key.getRow()).thenReturn(text);

    SortedKeyValueIterator<Key, Value> source = mock(SortedKeyValueIterator.class);
    when(source.getTopKey()).thenReturn(key);
    ByteEntityAccumuloElementConverter elementConverter =
        new ByteEntityAccumuloElementConverter(new Schema());
    Schema schema = new Schema();

    HashSet<String> groupBy = new HashSet<>();
    groupBy.add("foo");

    // Act and Assert
    assertThrows(
        NoSuchElementException.class,
        () -> new KeyValueIterator(source, "Group", elementConverter, schema, groupBy));
    verify(key).getColumnFamily();
    verify(key).getRow();
    verify(source).getTopKey();
    verify(text2).getBytes();
    verify(text).getBytes();
  }

  /**
   * Test KeyValueIterator {@link KeyValueIterator#KeyValueIterator(SortedKeyValueIterator, String,
   * AccumuloElementConverter, Schema, Set)}.
   *
   * <ul>
   *   <li>Then calls {@link Key#getTimestamp()}.
   * </ul>
   *
   * <p>Method under test: {@link KeyValueIterator#KeyValueIterator(SortedKeyValueIterator, String,
   * AccumuloElementConverter, Schema, Set)}
   */
  @Test
  @DisplayName(
      "Test KeyValueIterator new KeyValueIterator(SortedKeyValueIterator, String, AccumuloElementConverter, Schema, Set); then calls getTimestamp()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void KeyValueIterator.<init>(SortedKeyValueIterator, String, AccumuloElementConverter, Schema, Set)"
  })
  void testKeyValueIteratorNewKeyValueIterator_thenCallsGetTimestamp() {
    // Arrange
    Key key = mock(Key.class);
    when(key.getTimestamp()).thenThrow(new NoSuchElementException());
    when(key.getColumnVisibility()).thenReturn(new Text());
    when(key.getColumnQualifier()).thenReturn(new Text());
    when(key.getColumnFamily()).thenReturn(new Text());
    when(key.getRow()).thenReturn(new Text());

    SortedKeyValueIterator<Key, Value> source = mock(SortedKeyValueIterator.class);
    when(source.getTopKey()).thenReturn(key);
    ByteEntityAccumuloElementConverter elementConverter =
        new ByteEntityAccumuloElementConverter(new Schema());
    Schema schema = new Schema();

    HashSet<String> groupBy = new HashSet<>();
    groupBy.add("foo");

    // Act and Assert
    assertThrows(
        NoSuchElementException.class,
        () -> new KeyValueIterator(source, "Group", elementConverter, schema, groupBy));
    verify(key).getColumnFamily();
    verify(key).getColumnQualifier();
    verify(key).getColumnVisibility();
    verify(key).getRow();
    verify(key).getTimestamp();
    verify(source).getTopKey();
  }

  /**
   * Test {@link CoreKeyGroupByCombiner#next()}.
   *
   * <p>Method under test: {@link CoreKeyGroupByCombiner#next()}
   */
  @Test
  @DisplayName("Test next()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CoreKeyGroupByCombiner.next()"})
  void testNext() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IllegalStateException.class, () -> new CoreKeyGroupByAggregatorIterator().next());
  }

  /**
   * Test {@link CoreKeyGroupByCombiner#seek(Range, Collection, boolean)}.
   *
   * <ul>
   *   <li>Given {@link ArrayByteSequence#ArrayByteSequence(String)} with s is {@code foo}.
   * </ul>
   *
   * <p>Method under test: {@link CoreKeyGroupByCombiner#seek(Range, Collection, boolean)}
   */
  @Test
  @DisplayName(
      "Test seek(Range, Collection, boolean); given ArrayByteSequence(String) with s is 'foo'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CoreKeyGroupByCombiner.seek(Range, Collection, boolean)"})
  void testSeek_givenArrayByteSequenceWithSIsFoo() throws IOException {
    // Arrange
    CoreKeyGroupByAggregatorIterator coreKeyGroupByAggregatorIterator =
        new CoreKeyGroupByAggregatorIterator();
    Range range = new Range();

    ArrayList<ByteSequence> columnFamilies = new ArrayList<>();
    columnFamilies.add(new ArrayByteSequence("foo"));

    // Act and Assert
    assertThrows(
        IllegalStateException.class,
        () -> coreKeyGroupByAggregatorIterator.seek(range, columnFamilies, true));
  }

  /**
   * Test {@link CoreKeyGroupByCombiner#seek(Range, Collection, boolean)}.
   *
   * <ul>
   *   <li>Given {@link ArrayByteSequence#ArrayByteSequence(String)} with s is {@code foo}.
   * </ul>
   *
   * <p>Method under test: {@link CoreKeyGroupByCombiner#seek(Range, Collection, boolean)}
   */
  @Test
  @DisplayName(
      "Test seek(Range, Collection, boolean); given ArrayByteSequence(String) with s is 'foo'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CoreKeyGroupByCombiner.seek(Range, Collection, boolean)"})
  void testSeek_givenArrayByteSequenceWithSIsFoo2() throws IOException {
    // Arrange
    CoreKeyGroupByAggregatorIterator coreKeyGroupByAggregatorIterator =
        new CoreKeyGroupByAggregatorIterator();
    Range range = new Range();

    ArrayList<ByteSequence> columnFamilies = new ArrayList<>();
    columnFamilies.add(new ArrayByteSequence("foo"));
    columnFamilies.add(new ArrayByteSequence("foo"));

    // Act and Assert
    assertThrows(
        IllegalStateException.class,
        () -> coreKeyGroupByAggregatorIterator.seek(range, columnFamilies, true));
  }

  /**
   * Test {@link CoreKeyGroupByCombiner#seek(Range, Collection, boolean)}.
   *
   * <ul>
   *   <li>When {@link Range#Range(CharSequence)} with row is {@link RFile#EXTENSION}.
   *   <li>Then throw {@link IllegalStateException}.
   * </ul>
   *
   * <p>Method under test: {@link CoreKeyGroupByCombiner#seek(Range, Collection, boolean)}
   */
  @Test
  @DisplayName(
      "Test seek(Range, Collection, boolean); when Range(CharSequence) with row is EXTENSION; then throw IllegalStateException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CoreKeyGroupByCombiner.seek(Range, Collection, boolean)"})
  void testSeek_whenRangeWithRowIsExtension_thenThrowIllegalStateException() throws IOException {
    // Arrange
    CoreKeyGroupByAggregatorIterator coreKeyGroupByAggregatorIterator =
        new CoreKeyGroupByAggregatorIterator();
    Range range = new Range(RFile.EXTENSION);

    // Act and Assert
    assertThrows(
        IllegalStateException.class,
        () -> coreKeyGroupByAggregatorIterator.seek(range, new ArrayList<>(), true));
  }

  /**
   * Test {@link CoreKeyGroupByCombiner#seek(Range, Collection, boolean)}.
   *
   * <ul>
   *   <li>When {@link Range#Range()}.
   *   <li>Then throw {@link IllegalStateException}.
   * </ul>
   *
   * <p>Method under test: {@link CoreKeyGroupByCombiner#seek(Range, Collection, boolean)}
   */
  @Test
  @DisplayName(
      "Test seek(Range, Collection, boolean); when Range(); then throw IllegalStateException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CoreKeyGroupByCombiner.seek(Range, Collection, boolean)"})
  void testSeek_whenRange_thenThrowIllegalStateException() throws IOException {
    // Arrange
    CoreKeyGroupByAggregatorIterator coreKeyGroupByAggregatorIterator =
        new CoreKeyGroupByAggregatorIterator();
    Range range = new Range();

    // Act and Assert
    assertThrows(
        IllegalStateException.class,
        () -> coreKeyGroupByAggregatorIterator.seek(range, new ArrayList<>(), true));
  }

  /**
   * Test {@link CoreKeyGroupByCombiner#deepCopy(IteratorEnvironment)}.
   *
   * <p>Method under test: {@link CoreKeyGroupByCombiner#deepCopy(IteratorEnvironment)}
   */
  @Test
  @DisplayName("Test deepCopy(IteratorEnvironment)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"SortedKeyValueIterator CoreKeyGroupByCombiner.deepCopy(IteratorEnvironment)"})
  void testDeepCopy() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalStateException.class, () -> new CoreKeyGroupByAggregatorIterator().deepCopy(null));
  }

  /**
   * Test {@link CoreKeyGroupByCombiner#validateOptions(Map)}.
   *
   * <ul>
   *   <li>Given {@code Options}.
   *   <li>When {@link HashMap#HashMap()} {@code Schema} is {@code Options}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link CoreKeyGroupByCombiner#validateOptions(Map)}
   */
  @Test
  @DisplayName(
      "Test validateOptions(Map); given 'Options'; when HashMap() 'Schema' is 'Options'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CoreKeyGroupByCombiner.validateOptions(Map)"})
  void testValidateOptions_givenOptions_whenHashMapSchemaIsOptions_thenReturnTrue() {
    // Arrange
    CoreKeyGroupByAggregatorIterator coreKeyGroupByAggregatorIterator =
        new CoreKeyGroupByAggregatorIterator();

    HashMap<String, String> options = new HashMap<>();
    options.put("Schema", "Options");
    options.put("View", "Options");

    // Act and Assert
    assertTrue(coreKeyGroupByAggregatorIterator.validateOptions(options));
  }

  /**
   * Test {@link CoreKeyGroupByCombiner#validateOptions(Map)}.
   *
   * <ul>
   *   <li>When {@link HashMap#HashMap()} {@code Schema} is {@code Schema}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link CoreKeyGroupByCombiner#validateOptions(Map)}
   */
  @Test
  @DisplayName(
      "Test validateOptions(Map); when HashMap() 'Schema' is 'Schema'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CoreKeyGroupByCombiner.validateOptions(Map)"})
  void testValidateOptions_whenHashMapSchemaIsSchema_thenThrowIllegalArgumentException() {
    // Arrange
    CoreKeyGroupByAggregatorIterator coreKeyGroupByAggregatorIterator =
        new CoreKeyGroupByAggregatorIterator();

    HashMap<String, String> options = new HashMap<>();
    options.put("Schema", "Schema");

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> coreKeyGroupByAggregatorIterator.validateOptions(options));
  }

  /**
   * Test {@link CoreKeyGroupByCombiner#validateOptions(Map)}.
   *
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link CoreKeyGroupByCombiner#validateOptions(Map)}
   */
  @Test
  @DisplayName("Test validateOptions(Map); when HashMap(); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CoreKeyGroupByCombiner.validateOptions(Map)"})
  void testValidateOptions_whenHashMap_thenThrowIllegalArgumentException() {
    // Arrange
    CoreKeyGroupByAggregatorIterator coreKeyGroupByAggregatorIterator =
        new CoreKeyGroupByAggregatorIterator();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> coreKeyGroupByAggregatorIterator.validateOptions(new HashMap<>()));
  }

  /**
   * Test {@link CoreKeyGroupByCombiner#describeOptions()}.
   *
   * <p>Method under test: {@link CoreKeyGroupByCombiner#describeOptions()}
   */
  @Test
  @DisplayName("Test describeOptions()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IteratorOptions CoreKeyGroupByCombiner.describeOptions()"})
  void testDescribeOptions() {
    // Arrange and Act
    IteratorOptions actualDescribeOptionsResult =
        new CoreKeyGroupByAggregatorIterator().describeOptions();

    // Assert
    assertEquals(
        "Applies a reduce function to a set of Properties with identical rowKey, column family and column"
            + " qualifier constants.",
        actualDescribeOptionsResult.getDescription());
    assertEquals("Column_Qualifier_Aggregator", actualDescribeOptionsResult.getName());
    Map<String, String> namedOptions = actualDescribeOptionsResult.getNamedOptions();
    assertEquals(2, namedOptions.size());
    assertEquals(
        "Required: The element converter class to be used for key/value conversion",
        namedOptions.get("accumulostore.key.element_converter"));
    assertEquals("Required: The json serialised form of the schema", namedOptions.get("Schema"));
    assertNull(actualDescribeOptionsResult.getUnnamedOptionDescriptions());
  }
}
