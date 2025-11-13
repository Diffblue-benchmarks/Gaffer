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
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
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
import org.apache.accumulo.core.conf.DefaultConfiguration;
import org.apache.accumulo.core.data.Key;
import org.apache.accumulo.core.data.Range;
import org.apache.accumulo.core.file.BloomFilterLayer;
import org.apache.accumulo.core.file.BloomFilterLayer.Reader;
import org.apache.accumulo.core.iterators.OptionDescriber;
import org.apache.accumulo.core.iterators.OptionDescriber.IteratorOptions;
import org.apache.accumulo.core.iterators.SortedKeyValueIterator;
import org.apache.hadoop.io.Text;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import uk.gov.gchq.gaffer.accumulostore.key.AccumuloElementConverter;
import uk.gov.gchq.gaffer.accumulostore.key.core.impl.CoreKeyGroupByCombiner.KeyValueIterator;
import uk.gov.gchq.gaffer.accumulostore.key.core.impl.byteEntity.ByteEntityAccumuloElementConverter;
import uk.gov.gchq.gaffer.accumulostore.key.exception.AggregationException;
import uk.gov.gchq.gaffer.store.schema.Schema;
import uk.gov.gchq.gaffer.store.schema.SchemaEdgeDefinition;
import uk.gov.gchq.gaffer.store.schema.SchemaElementDefinition;

class CoreKeyGroupByCombinerDiffblueTest {
  /**
   * Test KeyValueIterator {@link KeyValueIterator#KeyValueIterator(SortedKeyValueIterator, String, AccumuloElementConverter, Schema, Set)}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>When {@link HashSet#HashSet()} add {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link KeyValueIterator#KeyValueIterator(SortedKeyValueIterator, String, AccumuloElementConverter, Schema, Set)}
   */
  @Test
  @DisplayName("Test KeyValueIterator new KeyValueIterator(SortedKeyValueIterator, String, AccumuloElementConverter, Schema, Set); given '42'; when HashSet() add '42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "void KeyValueIterator.<init>(SortedKeyValueIterator, String, AccumuloElementConverter, Schema, Set)"})
  void testKeyValueIteratorNewKeyValueIterator_given42_whenHashSetAdd42() throws UnsupportedEncodingException {
    // Arrange
    Text text = mock(Text.class);
    when(text.getBytes()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    Text text2 = mock(Text.class);
    when(text2.getBytes()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    Text text3 = mock(Text.class);
    when(text3.getBytes()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    Text text4 = mock(Text.class);
    when(text4.getBytes()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    Key key = mock(Key.class);
    when(key.isDeleted()).thenReturn(true);
    when(key.getTimestamp()).thenReturn(10L);
    when(key.getColumnVisibility()).thenReturn(text4);
    when(key.getColumnQualifier()).thenReturn(text3);
    when(key.getColumnFamily()).thenReturn(text2);
    when(key.getRow()).thenReturn(text);
    Reader reader = mock(Reader.class);
    when(reader.hasTop()).thenReturn(true);
    when(reader.getTopKey()).thenReturn(key);
    Reader source = new Reader(reader, DefaultConfiguration.getInstance());

    ByteEntityAccumuloElementConverter elementConverter = new ByteEntityAccumuloElementConverter(new Schema());
    SchemaElementDefinition schemaElementDefinition = mock(SchemaElementDefinition.class);
    when(schemaElementDefinition.getGroupBy()).thenReturn(new HashSet<>());
    Schema schema = mock(Schema.class);
    when(schema.getElement(Mockito.<String>any())).thenReturn(schemaElementDefinition);

    HashSet<String> groupBy = new HashSet<>();
    groupBy.add("42");
    groupBy.add("foo");

    // Act
    KeyValueIterator actualKeyValueIterator = new KeyValueIterator(source, "Group", elementConverter, schema, groupBy);

    // Assert
    verify(key).getColumnFamily();
    verify(key).getColumnQualifier();
    verify(key).getColumnVisibility();
    verify(key).getRow();
    verify(key).getTimestamp();
    verify(key, atLeast(1)).isDeleted();
    verify(reader, atLeast(1)).getTopKey();
    verify(reader).hasTop();
    verify(text4).getBytes();
    verify(text3).getBytes();
    verify(text2).getBytes();
    verify(text).getBytes();
    verify(schema).getElement(eq("Group"));
    verify(schemaElementDefinition).getGroupBy();
    assertFalse(actualKeyValueIterator.hasNext());
  }

  /**
   * Test KeyValueIterator {@link KeyValueIterator#KeyValueIterator(SortedKeyValueIterator, String, AccumuloElementConverter, Schema, Set)}.
   * <ul>
   *   <li>Given {@code false}.</li>
   *   <li>When {@link BloomFilterLayer.Reader} {@link BloomFilterLayer.Reader#hasTop()} return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link KeyValueIterator#KeyValueIterator(SortedKeyValueIterator, String, AccumuloElementConverter, Schema, Set)}
   */
  @Test
  @DisplayName("Test KeyValueIterator new KeyValueIterator(SortedKeyValueIterator, String, AccumuloElementConverter, Schema, Set); given 'false'; when Reader hasTop() return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "void KeyValueIterator.<init>(SortedKeyValueIterator, String, AccumuloElementConverter, Schema, Set)"})
  void testKeyValueIteratorNewKeyValueIterator_givenFalse_whenReaderHasTopReturnFalse()
      throws UnsupportedEncodingException {
    // Arrange
    Text text = mock(Text.class);
    when(text.getBytes()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    Text text2 = mock(Text.class);
    when(text2.getBytes()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    Text text3 = mock(Text.class);
    when(text3.getBytes()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    Text text4 = mock(Text.class);
    when(text4.getBytes()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    Key key = mock(Key.class);
    when(key.isDeleted()).thenReturn(true);
    when(key.getTimestamp()).thenReturn(10L);
    when(key.getColumnVisibility()).thenReturn(text4);
    when(key.getColumnQualifier()).thenReturn(text3);
    when(key.getColumnFamily()).thenReturn(text2);
    when(key.getRow()).thenReturn(text);
    Reader reader = mock(Reader.class);
    when(reader.hasTop()).thenReturn(false);
    when(reader.getTopKey()).thenReturn(key);
    Reader source = new Reader(reader, DefaultConfiguration.getInstance());

    ByteEntityAccumuloElementConverter elementConverter = new ByteEntityAccumuloElementConverter(new Schema());
    Schema schema = mock(Schema.class);
    when(schema.getElement(Mockito.<String>any())).thenReturn(new SchemaEdgeDefinition());

    // Act
    KeyValueIterator actualKeyValueIterator = new KeyValueIterator(source, "Group", elementConverter, schema,
        new HashSet<>());

    // Assert
    verify(key).getColumnFamily();
    verify(key).getColumnQualifier();
    verify(key).getColumnVisibility();
    verify(key).getRow();
    verify(key).getTimestamp();
    verify(key).isDeleted();
    verify(reader).getTopKey();
    verify(reader).hasTop();
    verify(text4).getBytes();
    verify(text3).getBytes();
    verify(text2).getBytes();
    verify(text).getBytes();
    verify(schema).getElement(eq("Group"));
    assertFalse(actualKeyValueIterator.hasNext());
  }

  /**
   * Test KeyValueIterator {@link KeyValueIterator#KeyValueIterator(SortedKeyValueIterator, String, AccumuloElementConverter, Schema, Set)}.
   * <ul>
   *   <li>Given {@code foo}.</li>
   *   <li>When {@link HashSet#HashSet()} add {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link KeyValueIterator#KeyValueIterator(SortedKeyValueIterator, String, AccumuloElementConverter, Schema, Set)}
   */
  @Test
  @DisplayName("Test KeyValueIterator new KeyValueIterator(SortedKeyValueIterator, String, AccumuloElementConverter, Schema, Set); given 'foo'; when HashSet() add 'foo'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "void KeyValueIterator.<init>(SortedKeyValueIterator, String, AccumuloElementConverter, Schema, Set)"})
  void testKeyValueIteratorNewKeyValueIterator_givenFoo_whenHashSetAddFoo() throws UnsupportedEncodingException {
    // Arrange
    Text text = mock(Text.class);
    when(text.getBytes()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    Text text2 = mock(Text.class);
    when(text2.getBytes()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    Text text3 = mock(Text.class);
    when(text3.getBytes()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    Text text4 = mock(Text.class);
    when(text4.getBytes()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    Key key = mock(Key.class);
    when(key.isDeleted()).thenReturn(true);
    when(key.getTimestamp()).thenReturn(10L);
    when(key.getColumnVisibility()).thenReturn(text4);
    when(key.getColumnQualifier()).thenReturn(text3);
    when(key.getColumnFamily()).thenReturn(text2);
    when(key.getRow()).thenReturn(text);
    Reader reader = mock(Reader.class);
    when(reader.hasTop()).thenReturn(true);
    when(reader.getTopKey()).thenReturn(key);
    Reader source = new Reader(reader, DefaultConfiguration.getInstance());

    ByteEntityAccumuloElementConverter elementConverter = new ByteEntityAccumuloElementConverter(new Schema());
    SchemaElementDefinition schemaElementDefinition = mock(SchemaElementDefinition.class);
    when(schemaElementDefinition.getGroupBy()).thenReturn(new HashSet<>());
    Schema schema = mock(Schema.class);
    when(schema.getElement(Mockito.<String>any())).thenReturn(schemaElementDefinition);

    HashSet<String> groupBy = new HashSet<>();
    groupBy.add("foo");

    // Act
    KeyValueIterator actualKeyValueIterator = new KeyValueIterator(source, "Group", elementConverter, schema, groupBy);

    // Assert
    verify(key).getColumnFamily();
    verify(key).getColumnQualifier();
    verify(key).getColumnVisibility();
    verify(key).getRow();
    verify(key).getTimestamp();
    verify(key, atLeast(1)).isDeleted();
    verify(reader, atLeast(1)).getTopKey();
    verify(reader).hasTop();
    verify(text4).getBytes();
    verify(text3).getBytes();
    verify(text2).getBytes();
    verify(text).getBytes();
    verify(schema).getElement(eq("Group"));
    verify(schemaElementDefinition).getGroupBy();
    assertFalse(actualKeyValueIterator.hasNext());
  }

  /**
   * Test KeyValueIterator {@link KeyValueIterator#KeyValueIterator(SortedKeyValueIterator, String, AccumuloElementConverter, Schema, Set)}.
   * <ul>
   *   <li>Given {@link SchemaEdgeDefinition} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link KeyValueIterator#KeyValueIterator(SortedKeyValueIterator, String, AccumuloElementConverter, Schema, Set)}
   */
  @Test
  @DisplayName("Test KeyValueIterator new KeyValueIterator(SortedKeyValueIterator, String, AccumuloElementConverter, Schema, Set); given SchemaEdgeDefinition (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "void KeyValueIterator.<init>(SortedKeyValueIterator, String, AccumuloElementConverter, Schema, Set)"})
  void testKeyValueIteratorNewKeyValueIterator_givenSchemaEdgeDefinition() throws UnsupportedEncodingException {
    // Arrange
    Text text = mock(Text.class);
    when(text.getBytes()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    Text text2 = mock(Text.class);
    when(text2.getBytes()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    Text text3 = mock(Text.class);
    when(text3.getBytes()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    Text text4 = mock(Text.class);
    when(text4.getBytes()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    Key key = mock(Key.class);
    when(key.isDeleted()).thenReturn(true);
    when(key.getTimestamp()).thenReturn(10L);
    when(key.getColumnVisibility()).thenReturn(text4);
    when(key.getColumnQualifier()).thenReturn(text3);
    when(key.getColumnFamily()).thenReturn(text2);
    when(key.getRow()).thenReturn(text);
    Reader reader = mock(Reader.class);
    when(reader.hasTop()).thenReturn(true);
    when(reader.getTopKey()).thenReturn(key);
    Reader source = new Reader(reader, DefaultConfiguration.getInstance());

    ByteEntityAccumuloElementConverter elementConverter = new ByteEntityAccumuloElementConverter(new Schema());
    Schema schema = mock(Schema.class);
    when(schema.getElement(Mockito.<String>any())).thenReturn(new SchemaEdgeDefinition());

    // Act
    KeyValueIterator actualKeyValueIterator = new KeyValueIterator(source, "Group", elementConverter, schema,
        new HashSet<>());

    // Assert
    verify(key).getColumnFamily();
    verify(key).getColumnQualifier();
    verify(key).getColumnVisibility();
    verify(key).getRow();
    verify(key).getTimestamp();
    verify(key, atLeast(1)).isDeleted();
    verify(reader, atLeast(1)).getTopKey();
    verify(reader).hasTop();
    verify(text4).getBytes();
    verify(text3).getBytes();
    verify(text2).getBytes();
    verify(text).getBytes();
    verify(schema).getElement(eq("Group"));
    assertFalse(actualKeyValueIterator.hasNext());
  }

  /**
   * Test KeyValueIterator {@link KeyValueIterator#KeyValueIterator(SortedKeyValueIterator, String, AccumuloElementConverter, Schema, Set)}.
   * <ul>
   *   <li>Then calls {@link SchemaElementDefinition#getGroupBy()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link KeyValueIterator#KeyValueIterator(SortedKeyValueIterator, String, AccumuloElementConverter, Schema, Set)}
   */
  @Test
  @DisplayName("Test KeyValueIterator new KeyValueIterator(SortedKeyValueIterator, String, AccumuloElementConverter, Schema, Set); then calls getGroupBy()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "void KeyValueIterator.<init>(SortedKeyValueIterator, String, AccumuloElementConverter, Schema, Set)"})
  void testKeyValueIteratorNewKeyValueIterator_thenCallsGetGroupBy() throws UnsupportedEncodingException {
    // Arrange
    Text text = mock(Text.class);
    when(text.getBytes()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    Text text2 = mock(Text.class);
    when(text2.getBytes()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    Text text3 = mock(Text.class);
    when(text3.getBytes()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    Text text4 = mock(Text.class);
    when(text4.getBytes()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    Key key = mock(Key.class);
    when(key.isDeleted()).thenReturn(true);
    when(key.getTimestamp()).thenReturn(10L);
    when(key.getColumnVisibility()).thenReturn(text4);
    when(key.getColumnQualifier()).thenReturn(text3);
    when(key.getColumnFamily()).thenReturn(text2);
    when(key.getRow()).thenReturn(text);
    Reader reader = mock(Reader.class);
    when(reader.hasTop()).thenReturn(true);
    when(reader.getTopKey()).thenReturn(key);
    Reader source = new Reader(reader, DefaultConfiguration.getInstance());

    ByteEntityAccumuloElementConverter elementConverter = new ByteEntityAccumuloElementConverter(new Schema());
    SchemaElementDefinition schemaElementDefinition = mock(SchemaElementDefinition.class);
    when(schemaElementDefinition.getGroupBy()).thenReturn(new HashSet<>());
    Schema schema = mock(Schema.class);
    when(schema.getElement(Mockito.<String>any())).thenReturn(schemaElementDefinition);

    // Act
    KeyValueIterator actualKeyValueIterator = new KeyValueIterator(source, "Group", elementConverter, schema,
        new HashSet<>());

    // Assert
    verify(key).getColumnFamily();
    verify(key).getColumnQualifier();
    verify(key).getColumnVisibility();
    verify(key).getRow();
    verify(key).getTimestamp();
    verify(key, atLeast(1)).isDeleted();
    verify(reader, atLeast(1)).getTopKey();
    verify(reader).hasTop();
    verify(text4).getBytes();
    verify(text3).getBytes();
    verify(text2).getBytes();
    verify(text).getBytes();
    verify(schema).getElement(eq("Group"));
    verify(schemaElementDefinition).getGroupBy();
    assertFalse(actualKeyValueIterator.hasNext());
  }

  /**
   * Test KeyValueIterator {@link KeyValueIterator#KeyValueIterator(SortedKeyValueIterator, String, AccumuloElementConverter, Schema, Set)}.
   * <ul>
   *   <li>Then throw {@link NoSuchElementException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link KeyValueIterator#KeyValueIterator(SortedKeyValueIterator, String, AccumuloElementConverter, Schema, Set)}
   */
  @Test
  @DisplayName("Test KeyValueIterator new KeyValueIterator(SortedKeyValueIterator, String, AccumuloElementConverter, Schema, Set); then throw NoSuchElementException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "void KeyValueIterator.<init>(SortedKeyValueIterator, String, AccumuloElementConverter, Schema, Set)"})
  void testKeyValueIteratorNewKeyValueIterator_thenThrowNoSuchElementException() throws UnsupportedEncodingException {
    // Arrange
    Text text = mock(Text.class);
    when(text.getBytes()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    Text text2 = mock(Text.class);
    when(text2.getBytes()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    Text text3 = mock(Text.class);
    when(text3.getBytes()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    Text text4 = mock(Text.class);
    when(text4.getBytes()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    Key key = mock(Key.class);
    when(key.isDeleted()).thenReturn(true);
    when(key.getTimestamp()).thenReturn(10L);
    when(key.getColumnVisibility()).thenReturn(text4);
    when(key.getColumnQualifier()).thenReturn(text3);
    when(key.getColumnFamily()).thenReturn(text2);
    when(key.getRow()).thenReturn(text);
    Reader reader = mock(Reader.class);
    when(reader.hasTop()).thenThrow(new NoSuchElementException("foo"));
    when(reader.getTopKey()).thenReturn(key);
    Reader source = new Reader(reader, DefaultConfiguration.getInstance());

    ByteEntityAccumuloElementConverter elementConverter = new ByteEntityAccumuloElementConverter(new Schema());
    Schema schema = mock(Schema.class);
    when(schema.getElement(Mockito.<String>any())).thenReturn(new SchemaEdgeDefinition());

    // Act and Assert
    assertThrows(NoSuchElementException.class,
        () -> new KeyValueIterator(source, "Group", elementConverter, schema, new HashSet<>()));

    verify(key).getColumnFamily();
    verify(key).getColumnQualifier();
    verify(key).getColumnVisibility();
    verify(key).getRow();
    verify(key).getTimestamp();
    verify(key).isDeleted();
    verify(reader).getTopKey();
    verify(reader).hasTop();
    verify(text4).getBytes();
    verify(text3).getBytes();
    verify(text2).getBytes();
    verify(text).getBytes();
    verify(schema).getElement(eq("Group"));
  }

  /**
   * Test KeyValueIterator {@link KeyValueIterator#KeyValueIterator(SortedKeyValueIterator, String, AccumuloElementConverter, Schema, Set)}.
   * <ul>
   *   <li>Then throw {@link UnsupportedOperationException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link KeyValueIterator#KeyValueIterator(SortedKeyValueIterator, String, AccumuloElementConverter, Schema, Set)}
   */
  @Test
  @DisplayName("Test KeyValueIterator new KeyValueIterator(SortedKeyValueIterator, String, AccumuloElementConverter, Schema, Set); then throw UnsupportedOperationException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "void KeyValueIterator.<init>(SortedKeyValueIterator, String, AccumuloElementConverter, Schema, Set)"})
  void testKeyValueIteratorNewKeyValueIterator_thenThrowUnsupportedOperationException() {
    // Arrange
    Key key = mock(Key.class);
    when(key.getTimestamp()).thenThrow(new UnsupportedOperationException("foo"));
    when(key.getColumnVisibility()).thenReturn(new Text());
    when(key.getColumnQualifier()).thenReturn(new Text());
    when(key.getColumnFamily()).thenReturn(new Text());
    when(key.getRow()).thenReturn(new Text());
    Reader reader = mock(Reader.class);
    when(reader.getTopKey()).thenReturn(key);
    Reader source = new Reader(reader, DefaultConfiguration.getInstance());

    ByteEntityAccumuloElementConverter elementConverter = new ByteEntityAccumuloElementConverter(new Schema());
    Schema schema = new Schema();

    // Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> new KeyValueIterator(source, "Group", elementConverter, schema, new HashSet<>()));

    verify(key).getColumnFamily();
    verify(key).getColumnQualifier();
    verify(key).getColumnVisibility();
    verify(key).getRow();
    verify(key).getTimestamp();
    verify(reader).getTopKey();
  }

  /**
   * Test {@link CoreKeyGroupByCombiner#seek(Range, Collection, boolean)}.
   * <ul>
   *   <li>Then throw {@link AggregationException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CoreKeyGroupByCombiner#seek(Range, Collection, boolean)}
   */
  @Test
  @DisplayName("Test seek(Range, Collection, boolean); then throw AggregationException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void CoreKeyGroupByCombiner.seek(Range, Collection, boolean)"})
  void testSeek_thenThrowAggregationException() throws IOException {
    // Arrange
    CoreKeyGroupByAggregatorIterator coreKeyGroupByAggregatorIterator = new CoreKeyGroupByAggregatorIterator();
    Range range = mock(Range.class);
    when(range.isStartKeyInclusive()).thenThrow(new AggregationException("An error occurred"));
    when(range.getStartKey()).thenReturn(new Key());

    // Act and Assert
    assertThrows(AggregationException.class,
        () -> coreKeyGroupByAggregatorIterator.seek(range, new ArrayList<>(), true));
    verify(range, atLeast(1)).getStartKey();
    verify(range).isStartKeyInclusive();
  }

  /**
   * Test {@link CoreKeyGroupByCombiner#validateOptions(Map)}.
   * <ul>
   *   <li>Given {@code Options}.</li>
   *   <li>When {@link HashMap#HashMap()} {@code Schema} is {@code Options}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CoreKeyGroupByCombiner#validateOptions(Map)}
   */
  @Test
  @DisplayName("Test validateOptions(Map); given 'Options'; when HashMap() 'Schema' is 'Options'; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean CoreKeyGroupByCombiner.validateOptions(Map)"})
  void testValidateOptions_givenOptions_whenHashMapSchemaIsOptions_thenReturnTrue() {
    // Arrange
    CoreKeyGroupByAggregatorIterator coreKeyGroupByAggregatorIterator = new CoreKeyGroupByAggregatorIterator();

    HashMap<String, String> options = new HashMap<>();
    options.put("Schema", "Options");
    options.put("View", "Options");

    // Act and Assert
    assertTrue(coreKeyGroupByAggregatorIterator.validateOptions(options));
  }

  /**
   * Test {@link CoreKeyGroupByCombiner#validateOptions(Map)}.
   * <ul>
   *   <li>When {@link HashMap#HashMap()} {@code Schema} is {@code Schema}.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CoreKeyGroupByCombiner#validateOptions(Map)}
   */
  @Test
  @DisplayName("Test validateOptions(Map); when HashMap() 'Schema' is 'Schema'; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean CoreKeyGroupByCombiner.validateOptions(Map)"})
  void testValidateOptions_whenHashMapSchemaIsSchema_thenThrowIllegalArgumentException() {
    // Arrange
    CoreKeyGroupByAggregatorIterator coreKeyGroupByAggregatorIterator = new CoreKeyGroupByAggregatorIterator();

    HashMap<String, String> options = new HashMap<>();
    options.put("Schema", "Schema");

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> coreKeyGroupByAggregatorIterator.validateOptions(options));
  }

  /**
   * Test {@link CoreKeyGroupByCombiner#validateOptions(Map)}.
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CoreKeyGroupByCombiner#validateOptions(Map)}
   */
  @Test
  @DisplayName("Test validateOptions(Map); when HashMap(); then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean CoreKeyGroupByCombiner.validateOptions(Map)"})
  void testValidateOptions_whenHashMap_thenThrowIllegalArgumentException() {
    // Arrange
    CoreKeyGroupByAggregatorIterator coreKeyGroupByAggregatorIterator = new CoreKeyGroupByAggregatorIterator();

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> coreKeyGroupByAggregatorIterator.validateOptions(new HashMap<>()));
  }

  /**
   * Test {@link CoreKeyGroupByCombiner#describeOptions()}.
   * <p>
   * Method under test: {@link CoreKeyGroupByCombiner#describeOptions()}
   */
  @Test
  @DisplayName("Test describeOptions()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"IteratorOptions CoreKeyGroupByCombiner.describeOptions()"})
  void testDescribeOptions() {
    // Arrange and Act
    IteratorOptions actualDescribeOptionsResult = (new CoreKeyGroupByAggregatorIterator()).describeOptions();

    // Assert
    assertEquals("Applies a reduce function to a set of Properties with identical rowKey, column family and column"
        + " qualifier constants.", actualDescribeOptionsResult.getDescription());
    assertEquals("Column_Qualifier_Aggregator", actualDescribeOptionsResult.getName());
    Map<String, String> namedOptions = actualDescribeOptionsResult.getNamedOptions();
    assertEquals(2, namedOptions.size());
    assertEquals("Required: The element converter class to be used for key/value conversion",
        namedOptions.get("accumulostore.key.element_converter"));
    assertEquals("Required: The json serialised form of the schema", namedOptions.get("Schema"));
    assertNull(actualDescribeOptionsResult.getUnnamedOptionDescriptions());
  }
}
