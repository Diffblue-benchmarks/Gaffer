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

package uk.gov.gchq.gaffer.accumulostore.key.core;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Map;
import org.apache.accumulo.core.client.IteratorSetting;
import org.apache.hadoop.util.bloom.BloomFilter;
import org.apache.hadoop.util.bloom.Key;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import uk.gov.gchq.gaffer.accumulostore.AccumuloStore;
import uk.gov.gchq.gaffer.accumulostore.key.core.impl.byteEntity.ByteEntityIteratorSettingsFactory;
import uk.gov.gchq.gaffer.accumulostore.key.core.impl.byteEntity.ByteEntityKeyPackage;
import uk.gov.gchq.gaffer.accumulostore.key.exception.IteratorSettingException;
import uk.gov.gchq.gaffer.data.elementdefinition.exception.SchemaException;
import uk.gov.gchq.gaffer.data.elementdefinition.view.GlobalViewElementDefinition;
import uk.gov.gchq.gaffer.data.elementdefinition.view.NamedView;
import uk.gov.gchq.gaffer.data.elementdefinition.view.View;
import uk.gov.gchq.gaffer.data.elementdefinition.view.ViewElementDefinition;
import uk.gov.gchq.gaffer.store.schema.Schema;
import uk.gov.gchq.gaffer.store.schema.SchemaEdgeDefinition;
import uk.gov.gchq.gaffer.store.schema.SchemaEntityDefinition;

class AbstractCoreKeyIteratorSettingsFactoryDiffblueTest {
  /**
   * Test {@link AbstractCoreKeyIteratorSettingsFactory#getBloomFilterIteratorSetting(BloomFilter)}.
   *
   * <p>Method under test: {@link
   * AbstractCoreKeyIteratorSettingsFactory#getBloomFilterIteratorSetting(BloomFilter)}
   */
  @Test
  @DisplayName("Test getBloomFilterIteratorSetting(BloomFilter)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "IteratorSetting AbstractCoreKeyIteratorSettingsFactory.getBloomFilterIteratorSetting(BloomFilter)"
  })
  void testGetBloomFilterIteratorSetting() throws IteratorSettingException {
    // Arrange
    ByteEntityIteratorSettingsFactory byteEntityIteratorSettingsFactory =
        new ByteEntityIteratorSettingsFactory();

    // Act
    IteratorSetting actualBloomFilterIteratorSetting =
        byteEntityIteratorSettingsFactory.getBloomFilterIteratorSetting(
            new BloomFilter(3, 19088743, 1));

    // Assert
    assertEquals("Bloom_Filter", actualBloomFilterIteratorSetting.getName());
    Map<String, String> options = actualBloomFilterIteratorSetting.getOptions();
    assertEquals(1, options.size());
    assertEquals("ÿÿÿÿ\u0001#Eg\u0001\u0000\u0000\u0000\u0003\u0000", options.get("Bloom_Filter"));
    assertEquals(
        "uk.gov.gchq.gaffer.accumulostore.key.core.impl.CoreKeyBloomFilterIterator",
        actualBloomFilterIteratorSetting.getIteratorClass());
    assertEquals(31, actualBloomFilterIteratorSetting.getPriority());
  }

  /**
   * Test {@link AbstractCoreKeyIteratorSettingsFactory#getBloomFilterIteratorSetting(BloomFilter)}.
   *
   * <p>Method under test: {@link
   * AbstractCoreKeyIteratorSettingsFactory#getBloomFilterIteratorSetting(BloomFilter)}
   */
  @Test
  @DisplayName("Test getBloomFilterIteratorSetting(BloomFilter)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "IteratorSetting AbstractCoreKeyIteratorSettingsFactory.getBloomFilterIteratorSetting(BloomFilter)"
  })
  void testGetBloomFilterIteratorSetting2() throws IteratorSettingException {
    // Arrange
    ByteEntityIteratorSettingsFactory byteEntityIteratorSettingsFactory =
        new ByteEntityIteratorSettingsFactory();

    // Act
    IteratorSetting actualBloomFilterIteratorSetting =
        byteEntityIteratorSettingsFactory.getBloomFilterIteratorSetting(
            new BloomFilter(31, 19088743, 1));

    // Assert
    assertEquals("Bloom_Filter", actualBloomFilterIteratorSetting.getName());
    Map<String, String> options = actualBloomFilterIteratorSetting.getOptions();
    assertEquals(1, options.size());
    assertEquals(
        "ÿÿÿÿ\u0001#Eg\u0001\u0000\u0000\u0000\u001f\u0000\u0000\u0000\u0000",
        options.get("Bloom_Filter"));
    assertEquals(
        "uk.gov.gchq.gaffer.accumulostore.key.core.impl.CoreKeyBloomFilterIterator",
        actualBloomFilterIteratorSetting.getIteratorClass());
    assertEquals(31, actualBloomFilterIteratorSetting.getPriority());
  }

  /**
   * Test {@link AbstractCoreKeyIteratorSettingsFactory#getBloomFilterIteratorSetting(BloomFilter)}.
   *
   * <ul>
   *   <li>Given {@link Key#Key(byte[])} with value is {@code AXAXAXAX} Bytes is {@code UTF-8}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AbstractCoreKeyIteratorSettingsFactory#getBloomFilterIteratorSetting(BloomFilter)}
   */
  @Test
  @DisplayName(
      "Test getBloomFilterIteratorSetting(BloomFilter); given Key(byte[]) with value is 'AXAXAXAX' Bytes is 'UTF-8'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "IteratorSetting AbstractCoreKeyIteratorSettingsFactory.getBloomFilterIteratorSetting(BloomFilter)"
  })
  void testGetBloomFilterIteratorSetting_givenKeyWithValueIsAxaxaxaxBytesIsUtf8()
      throws UnsupportedEncodingException, IteratorSettingException {
    // Arrange
    ByteEntityIteratorSettingsFactory byteEntityIteratorSettingsFactory =
        new ByteEntityIteratorSettingsFactory();

    BloomFilter filter = new BloomFilter(3, 19088743, 1);
    filter.add(new Key("AXAXAXAX".getBytes("UTF-8")));

    // Act
    IteratorSetting actualBloomFilterIteratorSetting =
        byteEntityIteratorSettingsFactory.getBloomFilterIteratorSetting(filter);

    // Assert
    assertEquals("Bloom_Filter", actualBloomFilterIteratorSetting.getName());
    Map<String, String> options = actualBloomFilterIteratorSetting.getOptions();
    assertEquals(1, options.size());
    assertEquals("ÿÿÿÿ\u0001#Eg\u0001\u0000\u0000\u0000\u0003\u0007", options.get("Bloom_Filter"));
    assertEquals(
        "uk.gov.gchq.gaffer.accumulostore.key.core.impl.CoreKeyBloomFilterIterator",
        actualBloomFilterIteratorSetting.getIteratorClass());
    assertEquals(31, actualBloomFilterIteratorSetting.getPriority());
  }

  /**
   * Test {@link
   * AbstractCoreKeyIteratorSettingsFactory#getElementPreAggregationFilterIteratorSetting(View,
   * AccumuloStore)}.
   *
   * <ul>
   *   <li>When {@link View} (default constructor).
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AbstractCoreKeyIteratorSettingsFactory#getElementPreAggregationFilterIteratorSetting(View,
   * AccumuloStore)}
   */
  @Test
  @DisplayName(
      "Test getElementPreAggregationFilterIteratorSetting(View, AccumuloStore); when View (default constructor); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "IteratorSetting AbstractCoreKeyIteratorSettingsFactory.getElementPreAggregationFilterIteratorSetting(View, AccumuloStore)"
  })
  void testGetElementPreAggregationFilterIteratorSetting_whenView_thenReturnNull()
      throws IteratorSettingException {
    // Arrange
    ByteEntityIteratorSettingsFactory byteEntityIteratorSettingsFactory =
        new ByteEntityIteratorSettingsFactory();
    View view = new View();

    // Act and Assert
    assertNull(
        byteEntityIteratorSettingsFactory.getElementPreAggregationFilterIteratorSetting(
            view, new AccumuloStore()));
  }

  /**
   * Test {@link
   * AbstractCoreKeyIteratorSettingsFactory#getElementPostAggregationFilterIteratorSetting(View,
   * AccumuloStore)}.
   *
   * <ul>
   *   <li>When {@link View} (default constructor).
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AbstractCoreKeyIteratorSettingsFactory#getElementPostAggregationFilterIteratorSetting(View,
   * AccumuloStore)}
   */
  @Test
  @DisplayName(
      "Test getElementPostAggregationFilterIteratorSetting(View, AccumuloStore); when View (default constructor); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "IteratorSetting AbstractCoreKeyIteratorSettingsFactory.getElementPostAggregationFilterIteratorSetting(View, AccumuloStore)"
  })
  void testGetElementPostAggregationFilterIteratorSetting_whenView_thenReturnNull()
      throws IteratorSettingException {
    // Arrange
    ByteEntityIteratorSettingsFactory byteEntityIteratorSettingsFactory =
        new ByteEntityIteratorSettingsFactory();
    View view = new View();

    // Act and Assert
    assertNull(
        byteEntityIteratorSettingsFactory.getElementPostAggregationFilterIteratorSetting(
            view, new AccumuloStore()));
  }

  /**
   * Test {@link
   * AbstractCoreKeyIteratorSettingsFactory#getAggregatorIteratorSetting(AccumuloStore)}.
   *
   * <p>Method under test: {@link
   * AbstractCoreKeyIteratorSettingsFactory#getAggregatorIteratorSetting(AccumuloStore)}
   */
  @Test
  @DisplayName("Test getAggregatorIteratorSetting(AccumuloStore)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "IteratorSetting AbstractCoreKeyIteratorSettingsFactory.getAggregatorIteratorSetting(AccumuloStore)"
  })
  void testGetAggregatorIteratorSetting()
      throws UnsupportedEncodingException, IteratorSettingException, SchemaException {
    // Arrange
    ByteEntityIteratorSettingsFactory byteEntityIteratorSettingsFactory =
        new ByteEntityIteratorSettingsFactory();

    ArrayList<String> stringList = new ArrayList<>();
    stringList.add("accumulostore.key.element_converter");

    Schema schema = mock(Schema.class);
    when(schema.getAggregatedGroups()).thenReturn(stringList);
    when(schema.toCompactJson()).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    AccumuloStore store = mock(AccumuloStore.class);
    when(store.getKeyPackage()).thenReturn(new ByteEntityKeyPackage(new Schema()));
    when(store.getSchema()).thenReturn(schema);

    // Act
    IteratorSetting actualAggregatorIteratorSetting =
        byteEntityIteratorSettingsFactory.getAggregatorIteratorSetting(store);

    // Assert
    verify(store, atLeast(1)).getKeyPackage();
    verify(store, atLeast(1)).getSchema();
    verify(schema, atLeast(1)).getAggregatedGroups();
    verify(schema).toCompactJson();
    Map<String, String> options = actualAggregatorIteratorSetting.getOptions();
    assertEquals(3, options.size());
    assertEquals("AXAXAXAX", options.get("Schema"));
    assertEquals("Aggregator", actualAggregatorIteratorSetting.getName());
    assertEquals("accumulostore%2ekey%2eelement_converter", options.get("columns"));
    assertEquals(
        "uk.gov.gchq.gaffer.accumulostore.key.core.impl.byteEntity.ByteEntityAccumuloElementConverter",
        options.get("accumulostore.key.element_converter"));
    assertEquals(
        "uk.gov.gchq.gaffer.accumulostore.key.impl.AggregatorIterator",
        actualAggregatorIteratorSetting.getIteratorClass());
    assertEquals(10, actualAggregatorIteratorSetting.getPriority());
  }

  /**
   * Test {@link
   * AbstractCoreKeyIteratorSettingsFactory#getAggregatorIteratorSetting(AccumuloStore)}.
   *
   * <ul>
   *   <li>Then return Options {@code columns} is empty string.
   * </ul>
   *
   * <p>Method under test: {@link
   * AbstractCoreKeyIteratorSettingsFactory#getAggregatorIteratorSetting(AccumuloStore)}
   */
  @Test
  @DisplayName(
      "Test getAggregatorIteratorSetting(AccumuloStore); then return Options 'columns' is empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "IteratorSetting AbstractCoreKeyIteratorSettingsFactory.getAggregatorIteratorSetting(AccumuloStore)"
  })
  void testGetAggregatorIteratorSetting_thenReturnOptionsColumnsIsEmptyString()
      throws UnsupportedEncodingException, IteratorSettingException, SchemaException {
    // Arrange
    ByteEntityIteratorSettingsFactory byteEntityIteratorSettingsFactory =
        new ByteEntityIteratorSettingsFactory();

    Schema schema = mock(Schema.class);
    when(schema.getAggregatedGroups()).thenReturn(new ArrayList<>());
    when(schema.toCompactJson()).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    AccumuloStore store = mock(AccumuloStore.class);
    when(store.getKeyPackage()).thenReturn(new ByteEntityKeyPackage(new Schema()));
    when(store.getSchema()).thenReturn(schema);

    // Act
    IteratorSetting actualAggregatorIteratorSetting =
        byteEntityIteratorSettingsFactory.getAggregatorIteratorSetting(store);

    // Assert
    verify(store, atLeast(1)).getKeyPackage();
    verify(store, atLeast(1)).getSchema();
    verify(schema, atLeast(1)).getAggregatedGroups();
    verify(schema).toCompactJson();
    Map<String, String> options = actualAggregatorIteratorSetting.getOptions();
    assertEquals(3, options.size());
    assertEquals("", options.get("columns"));
    assertEquals("AXAXAXAX", options.get("Schema"));
    assertEquals("Aggregator", actualAggregatorIteratorSetting.getName());
    assertEquals(
        "uk.gov.gchq.gaffer.accumulostore.key.core.impl.byteEntity.ByteEntityAccumuloElementConverter",
        options.get("accumulostore.key.element_converter"));
    assertEquals(
        "uk.gov.gchq.gaffer.accumulostore.key.impl.AggregatorIterator",
        actualAggregatorIteratorSetting.getIteratorClass());
    assertEquals(10, actualAggregatorIteratorSetting.getPriority());
  }

  /**
   * Test {@link
   * AbstractCoreKeyIteratorSettingsFactory#getRowIDAggregatorIteratorSetting(AccumuloStore,
   * String)}.
   *
   * <p>Method under test: {@link
   * AbstractCoreKeyIteratorSettingsFactory#getRowIDAggregatorIteratorSetting(AccumuloStore,
   * String)}
   */
  @Test
  @DisplayName("Test getRowIDAggregatorIteratorSetting(AccumuloStore, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "IteratorSetting AbstractCoreKeyIteratorSettingsFactory.getRowIDAggregatorIteratorSetting(AccumuloStore, String)"
  })
  void testGetRowIDAggregatorIteratorSetting() throws IteratorSettingException {
    // Arrange
    ByteEntityIteratorSettingsFactory byteEntityIteratorSettingsFactory =
        new ByteEntityIteratorSettingsFactory();

    Schema schema = mock(Schema.class);
    when(schema.getAggregatedGroups()).thenThrow(new IllegalArgumentException());
    when(schema.isAggregationEnabled()).thenReturn(true);

    AccumuloStore store = mock(AccumuloStore.class);
    when(store.getSchema()).thenReturn(schema);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            byteEntityIteratorSettingsFactory.getRowIDAggregatorIteratorSetting(
                store, "Column Family"));
    verify(store, atLeast(1)).getSchema();
    verify(schema).getAggregatedGroups();
    verify(schema).isAggregationEnabled();
  }

  /**
   * Test {@link
   * AbstractCoreKeyIteratorSettingsFactory#getRowIDAggregatorIteratorSetting(AccumuloStore,
   * String)}.
   *
   * <ul>
   *   <li>Given {@link IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AbstractCoreKeyIteratorSettingsFactory#getRowIDAggregatorIteratorSetting(AccumuloStore,
   * String)}
   */
  @Test
  @DisplayName(
      "Test getRowIDAggregatorIteratorSetting(AccumuloStore, String); given IllegalArgumentException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "IteratorSetting AbstractCoreKeyIteratorSettingsFactory.getRowIDAggregatorIteratorSetting(AccumuloStore, String)"
  })
  void testGetRowIDAggregatorIteratorSetting_givenIllegalArgumentException()
      throws UnsupportedEncodingException, IteratorSettingException, SchemaException {
    // Arrange
    ByteEntityIteratorSettingsFactory byteEntityIteratorSettingsFactory =
        new ByteEntityIteratorSettingsFactory();

    Schema schema = mock(Schema.class);
    when(schema.getAggregatedGroups()).thenReturn(new ArrayList<>());
    when(schema.toCompactJson()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    when(schema.isAggregationEnabled()).thenReturn(true);

    AccumuloStore store = mock(AccumuloStore.class);
    when(store.getKeyPackage()).thenThrow(new IllegalArgumentException());
    when(store.getSchema()).thenReturn(schema);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            byteEntityIteratorSettingsFactory.getRowIDAggregatorIteratorSetting(
                store, "Column Family"));
    verify(store).getKeyPackage();
    verify(store, atLeast(1)).getSchema();
    verify(schema).getAggregatedGroups();
    verify(schema).isAggregationEnabled();
    verify(schema).toCompactJson();
  }

  /**
   * Test {@link
   * AbstractCoreKeyIteratorSettingsFactory#getRowIDAggregatorIteratorSetting(AccumuloStore,
   * String)}.
   *
   * <ul>
   *   <li>Given {@link Schema#Schema()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AbstractCoreKeyIteratorSettingsFactory#getRowIDAggregatorIteratorSetting(AccumuloStore,
   * String)}
   */
  @Test
  @DisplayName("Test getRowIDAggregatorIteratorSetting(AccumuloStore, String); given Schema()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "IteratorSetting AbstractCoreKeyIteratorSettingsFactory.getRowIDAggregatorIteratorSetting(AccumuloStore, String)"
  })
  void testGetRowIDAggregatorIteratorSetting_givenSchema() throws IteratorSettingException {
    // Arrange
    ByteEntityIteratorSettingsFactory byteEntityIteratorSettingsFactory =
        new ByteEntityIteratorSettingsFactory();

    AccumuloStore store = mock(AccumuloStore.class);
    when(store.getSchema()).thenReturn(new Schema());

    // Act
    IteratorSetting actualRowIDAggregatorIteratorSetting =
        byteEntityIteratorSettingsFactory.getRowIDAggregatorIteratorSetting(store, "Column Family");

    // Assert
    verify(store, atLeast(1)).getSchema();
    assertNull(actualRowIDAggregatorIteratorSetting);
  }

  /**
   * Test {@link
   * AbstractCoreKeyIteratorSettingsFactory#getRowIDAggregatorIteratorSetting(AccumuloStore,
   * String)}.
   *
   * <ul>
   *   <li>Given {@link Schema} {@link Schema#isAggregationEnabled()} return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AbstractCoreKeyIteratorSettingsFactory#getRowIDAggregatorIteratorSetting(AccumuloStore,
   * String)}
   */
  @Test
  @DisplayName(
      "Test getRowIDAggregatorIteratorSetting(AccumuloStore, String); given Schema isAggregationEnabled() return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "IteratorSetting AbstractCoreKeyIteratorSettingsFactory.getRowIDAggregatorIteratorSetting(AccumuloStore, String)"
  })
  void testGetRowIDAggregatorIteratorSetting_givenSchemaIsAggregationEnabledReturnFalse()
      throws IteratorSettingException {
    // Arrange
    ByteEntityIteratorSettingsFactory byteEntityIteratorSettingsFactory =
        new ByteEntityIteratorSettingsFactory();

    Schema schema = mock(Schema.class);
    when(schema.isAggregationEnabled()).thenReturn(false);

    AccumuloStore store = mock(AccumuloStore.class);
    when(store.getSchema()).thenReturn(schema);

    // Act
    IteratorSetting actualRowIDAggregatorIteratorSetting =
        byteEntityIteratorSettingsFactory.getRowIDAggregatorIteratorSetting(store, "Column Family");

    // Assert
    verify(store, atLeast(1)).getSchema();
    verify(schema, atLeast(1)).isAggregationEnabled();
    assertNull(actualRowIDAggregatorIteratorSetting);
  }

  /**
   * Test {@link
   * AbstractCoreKeyIteratorSettingsFactory#getRowIDAggregatorIteratorSetting(AccumuloStore,
   * String)}.
   *
   * <ul>
   *   <li>Then return Options {@code columns} is empty string.
   * </ul>
   *
   * <p>Method under test: {@link
   * AbstractCoreKeyIteratorSettingsFactory#getRowIDAggregatorIteratorSetting(AccumuloStore,
   * String)}
   */
  @Test
  @DisplayName(
      "Test getRowIDAggregatorIteratorSetting(AccumuloStore, String); then return Options 'columns' is empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "IteratorSetting AbstractCoreKeyIteratorSettingsFactory.getRowIDAggregatorIteratorSetting(AccumuloStore, String)"
  })
  void testGetRowIDAggregatorIteratorSetting_thenReturnOptionsColumnsIsEmptyString()
      throws UnsupportedEncodingException, IteratorSettingException, SchemaException {
    // Arrange
    ByteEntityIteratorSettingsFactory byteEntityIteratorSettingsFactory =
        new ByteEntityIteratorSettingsFactory();

    Schema schema = mock(Schema.class);
    when(schema.getAggregatedGroups()).thenReturn(new ArrayList<>());
    when(schema.toCompactJson()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    when(schema.isAggregationEnabled()).thenReturn(true);

    AccumuloStore store = mock(AccumuloStore.class);
    when(store.getKeyPackage()).thenReturn(new ByteEntityKeyPackage(new Schema()));
    when(store.getSchema()).thenReturn(schema);

    // Act
    IteratorSetting actualRowIDAggregatorIteratorSetting =
        byteEntityIteratorSettingsFactory.getRowIDAggregatorIteratorSetting(store, "Column Family");

    // Assert
    verify(store, atLeast(1)).getKeyPackage();
    verify(store, atLeast(1)).getSchema();
    verify(schema, atLeast(1)).getAggregatedGroups();
    verify(schema).isAggregationEnabled();
    verify(schema).toCompactJson();
    Map<String, String> options = actualRowIDAggregatorIteratorSetting.getOptions();
    assertEquals(4, options.size());
    assertEquals("", options.get("columns"));
    assertEquals("AXAXAXAX", options.get("Schema"));
    assertEquals("Column Family", options.get("columnFamily"));
    assertEquals("Row_ID_Aggregator", actualRowIDAggregatorIteratorSetting.getName());
    assertEquals(
        "uk.gov.gchq.gaffer.accumulostore.key.core.impl.byteEntity.ByteEntityAccumuloElementConverter",
        options.get("accumulostore.key.element_converter"));
    assertEquals(
        "uk.gov.gchq.gaffer.accumulostore.key.impl.RowIDAggregator",
        actualRowIDAggregatorIteratorSetting.getIteratorClass());
    assertEquals(35, actualRowIDAggregatorIteratorSetting.getPriority());
  }

  /**
   * Test {@link
   * AbstractCoreKeyIteratorSettingsFactory#getRowIDAggregatorIteratorSetting(AccumuloStore,
   * String)}.
   *
   * <ul>
   *   <li>Then return Options {@code columns} is {@code Row_ID_Aggregator}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AbstractCoreKeyIteratorSettingsFactory#getRowIDAggregatorIteratorSetting(AccumuloStore,
   * String)}
   */
  @Test
  @DisplayName(
      "Test getRowIDAggregatorIteratorSetting(AccumuloStore, String); then return Options 'columns' is 'Row_ID_Aggregator'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "IteratorSetting AbstractCoreKeyIteratorSettingsFactory.getRowIDAggregatorIteratorSetting(AccumuloStore, String)"
  })
  void testGetRowIDAggregatorIteratorSetting_thenReturnOptionsColumnsIsRowIdAggregator()
      throws UnsupportedEncodingException, IteratorSettingException, SchemaException {
    // Arrange
    ByteEntityIteratorSettingsFactory byteEntityIteratorSettingsFactory =
        new ByteEntityIteratorSettingsFactory();

    ArrayList<String> stringList = new ArrayList<>();
    stringList.add("Row_ID_Aggregator");

    Schema schema = mock(Schema.class);
    when(schema.getAggregatedGroups()).thenReturn(stringList);
    when(schema.toCompactJson()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    when(schema.isAggregationEnabled()).thenReturn(true);

    AccumuloStore store = mock(AccumuloStore.class);
    when(store.getKeyPackage()).thenReturn(new ByteEntityKeyPackage(new Schema()));
    when(store.getSchema()).thenReturn(schema);

    // Act
    IteratorSetting actualRowIDAggregatorIteratorSetting =
        byteEntityIteratorSettingsFactory.getRowIDAggregatorIteratorSetting(store, "Column Family");

    // Assert
    verify(store, atLeast(1)).getKeyPackage();
    verify(store, atLeast(1)).getSchema();
    verify(schema, atLeast(1)).getAggregatedGroups();
    verify(schema).isAggregationEnabled();
    verify(schema).toCompactJson();
    Map<String, String> options = actualRowIDAggregatorIteratorSetting.getOptions();
    assertEquals(4, options.size());
    assertEquals("AXAXAXAX", options.get("Schema"));
    assertEquals("Column Family", options.get("columnFamily"));
    assertEquals("Row_ID_Aggregator", options.get("columns"));
    assertEquals("Row_ID_Aggregator", actualRowIDAggregatorIteratorSetting.getName());
    assertEquals(
        "uk.gov.gchq.gaffer.accumulostore.key.core.impl.byteEntity.ByteEntityAccumuloElementConverter",
        options.get("accumulostore.key.element_converter"));
    assertEquals(
        "uk.gov.gchq.gaffer.accumulostore.key.impl.RowIDAggregator",
        actualRowIDAggregatorIteratorSetting.getIteratorClass());
    assertEquals(35, actualRowIDAggregatorIteratorSetting.getPriority());
  }

  /**
   * Test {@link AbstractCoreKeyIteratorSettingsFactory#getValidatorIteratorSetting(AccumuloStore)}.
   *
   * <p>Method under test: {@link
   * AbstractCoreKeyIteratorSettingsFactory#getValidatorIteratorSetting(AccumuloStore)}
   */
  @Test
  @DisplayName("Test getValidatorIteratorSetting(AccumuloStore)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "IteratorSetting AbstractCoreKeyIteratorSettingsFactory.getValidatorIteratorSetting(AccumuloStore)"
  })
  void testGetValidatorIteratorSetting() throws SchemaException {
    // Arrange
    ByteEntityIteratorSettingsFactory byteEntityIteratorSettingsFactory =
        new ByteEntityIteratorSettingsFactory();

    Schema schema = mock(Schema.class);
    when(schema.toCompactJson()).thenThrow(new IllegalArgumentException());
    when(schema.hasValidation()).thenReturn(true);

    AccumuloStore store = mock(AccumuloStore.class);
    when(store.getSchema()).thenReturn(schema);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> byteEntityIteratorSettingsFactory.getValidatorIteratorSetting(store));
    verify(store, atLeast(1)).getSchema();
    verify(schema).hasValidation();
    verify(schema).toCompactJson();
  }

  /**
   * Test {@link AbstractCoreKeyIteratorSettingsFactory#getValidatorIteratorSetting(AccumuloStore)}.
   *
   * <ul>
   *   <li>Given {@link IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AbstractCoreKeyIteratorSettingsFactory#getValidatorIteratorSetting(AccumuloStore)}
   */
  @Test
  @DisplayName("Test getValidatorIteratorSetting(AccumuloStore); given IllegalArgumentException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "IteratorSetting AbstractCoreKeyIteratorSettingsFactory.getValidatorIteratorSetting(AccumuloStore)"
  })
  void testGetValidatorIteratorSetting_givenIllegalArgumentException()
      throws UnsupportedEncodingException, SchemaException {
    // Arrange
    ByteEntityIteratorSettingsFactory byteEntityIteratorSettingsFactory =
        new ByteEntityIteratorSettingsFactory();

    Schema schema = mock(Schema.class);
    when(schema.toCompactJson()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    when(schema.hasValidation()).thenReturn(true);

    AccumuloStore store = mock(AccumuloStore.class);
    when(store.getKeyPackage()).thenThrow(new IllegalArgumentException());
    when(store.getSchema()).thenReturn(schema);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> byteEntityIteratorSettingsFactory.getValidatorIteratorSetting(store));
    verify(store).getKeyPackage();
    verify(store, atLeast(1)).getSchema();
    verify(schema).hasValidation();
    verify(schema).toCompactJson();
  }

  /**
   * Test {@link AbstractCoreKeyIteratorSettingsFactory#getValidatorIteratorSetting(AccumuloStore)}.
   *
   * <ul>
   *   <li>Given {@link Schema#Schema()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AbstractCoreKeyIteratorSettingsFactory#getValidatorIteratorSetting(AccumuloStore)}
   */
  @Test
  @DisplayName("Test getValidatorIteratorSetting(AccumuloStore); given Schema()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "IteratorSetting AbstractCoreKeyIteratorSettingsFactory.getValidatorIteratorSetting(AccumuloStore)"
  })
  void testGetValidatorIteratorSetting_givenSchema() {
    // Arrange
    ByteEntityIteratorSettingsFactory byteEntityIteratorSettingsFactory =
        new ByteEntityIteratorSettingsFactory();

    AccumuloStore store = mock(AccumuloStore.class);
    when(store.getSchema()).thenReturn(new Schema());

    // Act
    IteratorSetting actualValidatorIteratorSetting =
        byteEntityIteratorSettingsFactory.getValidatorIteratorSetting(store);

    // Assert
    verify(store, atLeast(1)).getSchema();
    assertNull(actualValidatorIteratorSetting);
  }

  /**
   * Test {@link AbstractCoreKeyIteratorSettingsFactory#getValidatorIteratorSetting(AccumuloStore)}.
   *
   * <ul>
   *   <li>Given {@link Schema} {@link Schema#hasValidation()} return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AbstractCoreKeyIteratorSettingsFactory#getValidatorIteratorSetting(AccumuloStore)}
   */
  @Test
  @DisplayName(
      "Test getValidatorIteratorSetting(AccumuloStore); given Schema hasValidation() return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "IteratorSetting AbstractCoreKeyIteratorSettingsFactory.getValidatorIteratorSetting(AccumuloStore)"
  })
  void testGetValidatorIteratorSetting_givenSchemaHasValidationReturnFalse() {
    // Arrange
    ByteEntityIteratorSettingsFactory byteEntityIteratorSettingsFactory =
        new ByteEntityIteratorSettingsFactory();

    Schema schema = mock(Schema.class);
    when(schema.hasValidation()).thenReturn(false);

    AccumuloStore store = mock(AccumuloStore.class);
    when(store.getSchema()).thenReturn(schema);

    // Act
    IteratorSetting actualValidatorIteratorSetting =
        byteEntityIteratorSettingsFactory.getValidatorIteratorSetting(store);

    // Assert
    verify(store, atLeast(1)).getSchema();
    verify(schema, atLeast(1)).hasValidation();
    assertNull(actualValidatorIteratorSetting);
  }

  /**
   * Test {@link AbstractCoreKeyIteratorSettingsFactory#getValidatorIteratorSetting(AccumuloStore)}.
   *
   * <ul>
   *   <li>Then return Options size is two.
   * </ul>
   *
   * <p>Method under test: {@link
   * AbstractCoreKeyIteratorSettingsFactory#getValidatorIteratorSetting(AccumuloStore)}
   */
  @Test
  @DisplayName("Test getValidatorIteratorSetting(AccumuloStore); then return Options size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "IteratorSetting AbstractCoreKeyIteratorSettingsFactory.getValidatorIteratorSetting(AccumuloStore)"
  })
  void testGetValidatorIteratorSetting_thenReturnOptionsSizeIsTwo()
      throws UnsupportedEncodingException, SchemaException {
    // Arrange
    ByteEntityIteratorSettingsFactory byteEntityIteratorSettingsFactory =
        new ByteEntityIteratorSettingsFactory();

    Schema schema = mock(Schema.class);
    when(schema.toCompactJson()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    when(schema.hasValidation()).thenReturn(true);

    AccumuloStore store = mock(AccumuloStore.class);
    when(store.getKeyPackage()).thenReturn(new ByteEntityKeyPackage(new Schema()));
    when(store.getSchema()).thenReturn(schema);

    // Act
    IteratorSetting actualValidatorIteratorSetting =
        byteEntityIteratorSettingsFactory.getValidatorIteratorSetting(store);

    // Assert
    verify(store, atLeast(1)).getKeyPackage();
    verify(store, atLeast(1)).getSchema();
    verify(schema).hasValidation();
    verify(schema).toCompactJson();
    Map<String, String> options = actualValidatorIteratorSetting.getOptions();
    assertEquals(2, options.size());
    assertEquals("AXAXAXAX", options.get("Schema"));
    assertEquals("Validator", actualValidatorIteratorSetting.getName());
    assertEquals(
        "uk.gov.gchq.gaffer.accumulostore.key.core.impl.byteEntity.ByteEntityAccumuloElementConverter",
        options.get("accumulostore.key.element_converter"));
    assertEquals(
        "uk.gov.gchq.gaffer.accumulostore.key.impl.ValidatorFilter",
        actualValidatorIteratorSetting.getIteratorClass());
    assertEquals(20, actualValidatorIteratorSetting.getPriority());
  }

  /**
   * Test {@link AbstractCoreKeyIteratorSettingsFactory#getQueryTimeAggregatorIteratorSetting(View,
   * AccumuloStore)}.
   *
   * <p>Method under test: {@link
   * AbstractCoreKeyIteratorSettingsFactory#getQueryTimeAggregatorIteratorSetting(View,
   * AccumuloStore)}
   */
  @Test
  @DisplayName("Test getQueryTimeAggregatorIteratorSetting(View, AccumuloStore)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "IteratorSetting AbstractCoreKeyIteratorSettingsFactory.getQueryTimeAggregatorIteratorSetting(View, AccumuloStore)"
  })
  void testGetQueryTimeAggregatorIteratorSetting() throws IteratorSettingException {
    // Arrange
    ByteEntityIteratorSettingsFactory byteEntityIteratorSettingsFactory =
        new ByteEntityIteratorSettingsFactory();
    View view = new View();

    Schema schema = mock(Schema.class);
    when(schema.isAggregationEnabled()).thenReturn(false);

    AccumuloStore store = mock(AccumuloStore.class);
    when(store.getSchema()).thenReturn(schema);

    // Act
    IteratorSetting actualQueryTimeAggregatorIteratorSetting =
        byteEntityIteratorSettingsFactory.getQueryTimeAggregatorIteratorSetting(view, store);

    // Assert
    verify(store, atLeast(1)).getSchema();
    verify(schema, atLeast(1)).isAggregationEnabled();
    assertNull(actualQueryTimeAggregatorIteratorSetting);
  }

  /**
   * Test {@link AbstractCoreKeyIteratorSettingsFactory#getQueryTimeAggregatorIteratorSetting(View,
   * AccumuloStore)}.
   *
   * <p>Method under test: {@link
   * AbstractCoreKeyIteratorSettingsFactory#getQueryTimeAggregatorIteratorSetting(View,
   * AccumuloStore)}
   */
  @Test
  @DisplayName("Test getQueryTimeAggregatorIteratorSetting(View, AccumuloStore)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "IteratorSetting AbstractCoreKeyIteratorSettingsFactory.getQueryTimeAggregatorIteratorSetting(View, AccumuloStore)"
  })
  void testGetQueryTimeAggregatorIteratorSetting2() throws IteratorSettingException {
    // Arrange
    ByteEntityIteratorSettingsFactory byteEntityIteratorSettingsFactory =
        new ByteEntityIteratorSettingsFactory();
    View view = new View();

    Schema schema = mock(Schema.class);
    when(schema.getVisibilityProperty()).thenThrow(new IllegalArgumentException());
    when(schema.isAggregationEnabled()).thenReturn(true);

    AccumuloStore store = mock(AccumuloStore.class);
    when(store.getSchema()).thenReturn(schema);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> byteEntityIteratorSettingsFactory.getQueryTimeAggregatorIteratorSetting(view, store));
    verify(store).getSchema();
    verify(schema).getVisibilityProperty();
    verify(schema).isAggregationEnabled();
  }

  /**
   * Test {@link AbstractCoreKeyIteratorSettingsFactory#getQueryTimeAggregatorIteratorSetting(View,
   * AccumuloStore)}.
   *
   * <p>Method under test: {@link
   * AbstractCoreKeyIteratorSettingsFactory#getQueryTimeAggregatorIteratorSetting(View,
   * AccumuloStore)}
   */
  @Test
  @DisplayName("Test getQueryTimeAggregatorIteratorSetting(View, AccumuloStore)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "IteratorSetting AbstractCoreKeyIteratorSettingsFactory.getQueryTimeAggregatorIteratorSetting(View, AccumuloStore)"
  })
  void testGetQueryTimeAggregatorIteratorSetting3() throws IteratorSettingException {
    // Arrange
    ByteEntityIteratorSettingsFactory byteEntityIteratorSettingsFactory =
        new ByteEntityIteratorSettingsFactory();

    HashSet<String> stringSet = new HashSet<>();
    stringSet.add(
        "Returning null from getQueryTimeAggregatorIteratorSetting as queryTimeAggregatorRequired(view,"
            + " store) = {}");

    NamedView view = mock(NamedView.class);
    when(view.getEdgeGroups()).thenReturn(stringSet);

    Schema schema = mock(Schema.class);
    when(schema.getEdge(Mockito.<String>any())).thenThrow(new IllegalArgumentException());
    when(schema.getVisibilityProperty()).thenReturn("Visibility Property");
    when(schema.isAggregationEnabled()).thenReturn(true);

    AccumuloStore store = mock(AccumuloStore.class);
    when(store.getSchema()).thenReturn(schema);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> byteEntityIteratorSettingsFactory.getQueryTimeAggregatorIteratorSetting(view, store));
    verify(schema)
        .getEdge(
            "Returning null from getQueryTimeAggregatorIteratorSetting as queryTimeAggregatorRequired(view, store) = {}");
    verify(view).getEdgeGroups();
    verify(store).getSchema();
    verify(schema).getVisibilityProperty();
    verify(schema).isAggregationEnabled();
  }

  /**
   * Test {@link AbstractCoreKeyIteratorSettingsFactory#getQueryTimeAggregatorIteratorSetting(View,
   * AccumuloStore)}.
   *
   * <p>Method under test: {@link
   * AbstractCoreKeyIteratorSettingsFactory#getQueryTimeAggregatorIteratorSetting(View,
   * AccumuloStore)}
   */
  @Test
  @DisplayName("Test getQueryTimeAggregatorIteratorSetting(View, AccumuloStore)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "IteratorSetting AbstractCoreKeyIteratorSettingsFactory.getQueryTimeAggregatorIteratorSetting(View, AccumuloStore)"
  })
  void testGetQueryTimeAggregatorIteratorSetting4() throws IteratorSettingException {
    // Arrange
    ByteEntityIteratorSettingsFactory byteEntityIteratorSettingsFactory =
        new ByteEntityIteratorSettingsFactory();

    HashSet<String> stringSet = new HashSet<>();
    stringSet.add(
        "Returning null from getQueryTimeAggregatorIteratorSetting as queryTimeAggregatorRequired(view,"
            + " store) = {}");

    NamedView view = mock(NamedView.class);
    when(view.getEdge(Mockito.<String>any())).thenThrow(new IllegalArgumentException());
    when(view.getEdgeGroups()).thenReturn(stringSet);

    Schema schema = mock(Schema.class);
    when(schema.getEdge(Mockito.<String>any())).thenReturn(new SchemaEdgeDefinition());
    when(schema.getVisibilityProperty()).thenReturn("Visibility Property");
    when(schema.isAggregationEnabled()).thenReturn(true);

    AccumuloStore store = mock(AccumuloStore.class);
    when(store.getSchema()).thenReturn(schema);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> byteEntityIteratorSettingsFactory.getQueryTimeAggregatorIteratorSetting(view, store));
    verify(view)
        .getEdge(
            "Returning null from getQueryTimeAggregatorIteratorSetting as queryTimeAggregatorRequired(view, store) = {}");
    verify(schema)
        .getEdge(
            "Returning null from getQueryTimeAggregatorIteratorSetting as queryTimeAggregatorRequired(view, store) = {}");
    verify(view).getEdgeGroups();
    verify(store).getSchema();
    verify(schema).getVisibilityProperty();
    verify(schema).isAggregationEnabled();
  }

  /**
   * Test {@link AbstractCoreKeyIteratorSettingsFactory#getQueryTimeAggregatorIteratorSetting(View,
   * AccumuloStore)}.
   *
   * <p>Method under test: {@link
   * AbstractCoreKeyIteratorSettingsFactory#getQueryTimeAggregatorIteratorSetting(View,
   * AccumuloStore)}
   */
  @Test
  @DisplayName("Test getQueryTimeAggregatorIteratorSetting(View, AccumuloStore)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "IteratorSetting AbstractCoreKeyIteratorSettingsFactory.getQueryTimeAggregatorIteratorSetting(View, AccumuloStore)"
  })
  void testGetQueryTimeAggregatorIteratorSetting5() throws IteratorSettingException {
    // Arrange
    ByteEntityIteratorSettingsFactory byteEntityIteratorSettingsFactory =
        new ByteEntityIteratorSettingsFactory();

    HashSet<String> stringSet = new HashSet<>();
    stringSet.add(
        "Returning null from getQueryTimeAggregatorIteratorSetting as queryTimeAggregatorRequired(view,"
            + " store) = {}");

    GlobalViewElementDefinition globalViewElementDefinition =
        mock(GlobalViewElementDefinition.class);
    when(globalViewElementDefinition.getGroupBy()).thenReturn(new HashSet<>());

    NamedView view = mock(NamedView.class);
    when(view.getEdge(Mockito.<String>any())).thenReturn(globalViewElementDefinition);
    when(view.getEdgeGroups()).thenReturn(stringSet);
    when(view.getEntityGroups()).thenReturn(new HashSet<>());

    Schema schema = mock(Schema.class);
    when(schema.getEdge(Mockito.<String>any())).thenReturn(new SchemaEdgeDefinition());
    when(schema.getVisibilityProperty()).thenReturn("Visibility Property");
    when(schema.isAggregationEnabled()).thenReturn(true);

    AccumuloStore store = mock(AccumuloStore.class);
    when(store.getSchema()).thenReturn(schema);

    // Act
    IteratorSetting actualQueryTimeAggregatorIteratorSetting =
        byteEntityIteratorSettingsFactory.getQueryTimeAggregatorIteratorSetting(view, store);

    // Assert
    verify(view, atLeast(1))
        .getEdge(
            "Returning null from getQueryTimeAggregatorIteratorSetting as queryTimeAggregatorRequired(view, store) = {}");
    verify(schema, atLeast(1))
        .getEdge(
            "Returning null from getQueryTimeAggregatorIteratorSetting as queryTimeAggregatorRequired(view, store) = {}");
    verify(view, atLeast(1)).getEdgeGroups();
    verify(view, atLeast(1)).getEntityGroups();
    verify(globalViewElementDefinition, atLeast(1)).getGroupBy();
    verify(store, atLeast(1)).getSchema();
    verify(schema, atLeast(1)).getVisibilityProperty();
    verify(schema, atLeast(1)).isAggregationEnabled();
    assertNull(actualQueryTimeAggregatorIteratorSetting);
  }

  /**
   * Test {@link AbstractCoreKeyIteratorSettingsFactory#getQueryTimeAggregatorIteratorSetting(View,
   * AccumuloStore)}.
   *
   * <p>Method under test: {@link
   * AbstractCoreKeyIteratorSettingsFactory#getQueryTimeAggregatorIteratorSetting(View,
   * AccumuloStore)}
   */
  @Test
  @DisplayName("Test getQueryTimeAggregatorIteratorSetting(View, AccumuloStore)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "IteratorSetting AbstractCoreKeyIteratorSettingsFactory.getQueryTimeAggregatorIteratorSetting(View, AccumuloStore)"
  })
  void testGetQueryTimeAggregatorIteratorSetting6() throws IteratorSettingException {
    // Arrange
    ByteEntityIteratorSettingsFactory byteEntityIteratorSettingsFactory =
        new ByteEntityIteratorSettingsFactory();

    HashSet<String> stringSet = new HashSet<>();
    stringSet.add(
        "Returning null from getQueryTimeAggregatorIteratorSetting as queryTimeAggregatorRequired(view,"
            + " store) = {}");

    GlobalViewElementDefinition globalViewElementDefinition =
        mock(GlobalViewElementDefinition.class);
    when(globalViewElementDefinition.getGroupBy()).thenThrow(new IllegalArgumentException());

    NamedView view = mock(NamedView.class);
    when(view.getEdge(Mockito.<String>any())).thenReturn(globalViewElementDefinition);
    when(view.getEdgeGroups()).thenReturn(stringSet);

    Schema schema = mock(Schema.class);
    when(schema.getEdge(Mockito.<String>any())).thenReturn(new SchemaEdgeDefinition());
    when(schema.getVisibilityProperty()).thenReturn("Visibility Property");
    when(schema.isAggregationEnabled()).thenReturn(true);

    AccumuloStore store = mock(AccumuloStore.class);
    when(store.getSchema()).thenReturn(schema);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> byteEntityIteratorSettingsFactory.getQueryTimeAggregatorIteratorSetting(view, store));
    verify(view)
        .getEdge(
            "Returning null from getQueryTimeAggregatorIteratorSetting as queryTimeAggregatorRequired(view, store) = {}");
    verify(schema)
        .getEdge(
            "Returning null from getQueryTimeAggregatorIteratorSetting as queryTimeAggregatorRequired(view, store) = {}");
    verify(view).getEdgeGroups();
    verify(globalViewElementDefinition).getGroupBy();
    verify(store).getSchema();
    verify(schema).getVisibilityProperty();
    verify(schema).isAggregationEnabled();
  }

  /**
   * Test {@link AbstractCoreKeyIteratorSettingsFactory#getQueryTimeAggregatorIteratorSetting(View,
   * AccumuloStore)}.
   *
   * <p>Method under test: {@link
   * AbstractCoreKeyIteratorSettingsFactory#getQueryTimeAggregatorIteratorSetting(View,
   * AccumuloStore)}
   */
  @Test
  @DisplayName("Test getQueryTimeAggregatorIteratorSetting(View, AccumuloStore)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "IteratorSetting AbstractCoreKeyIteratorSettingsFactory.getQueryTimeAggregatorIteratorSetting(View, AccumuloStore)"
  })
  void testGetQueryTimeAggregatorIteratorSetting7() throws IteratorSettingException {
    // Arrange
    ByteEntityIteratorSettingsFactory byteEntityIteratorSettingsFactory =
        new ByteEntityIteratorSettingsFactory();

    HashSet<String> stringSet = new HashSet<>();
    stringSet.add(
        "Returning null from getQueryTimeAggregatorIteratorSetting as queryTimeAggregatorRequired(view,"
            + " store) = {}");

    HashSet<String> stringSet2 = new HashSet<>();
    stringSet2.add("foo");

    GlobalViewElementDefinition globalViewElementDefinition =
        mock(GlobalViewElementDefinition.class);
    when(globalViewElementDefinition.getGroupBy()).thenReturn(null);

    NamedView view = mock(NamedView.class);
    when(view.getEdge(Mockito.<String>any())).thenReturn(globalViewElementDefinition);
    when(view.getEdgeGroups()).thenReturn(stringSet);
    when(view.getEntityGroups()).thenReturn(stringSet2);

    Schema schema = mock(Schema.class);
    when(schema.getEntity(Mockito.<String>any())).thenThrow(new IllegalArgumentException());
    when(schema.getEdge(Mockito.<String>any())).thenReturn(new SchemaEdgeDefinition());
    when(schema.getVisibilityProperty()).thenReturn("Visibility Property");
    when(schema.isAggregationEnabled()).thenReturn(true);

    AccumuloStore store = mock(AccumuloStore.class);
    when(store.getSchema()).thenReturn(schema);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> byteEntityIteratorSettingsFactory.getQueryTimeAggregatorIteratorSetting(view, store));
    verify(view)
        .getEdge(
            "Returning null from getQueryTimeAggregatorIteratorSetting as queryTimeAggregatorRequired(view, store) = {}");
    verify(schema)
        .getEdge(
            "Returning null from getQueryTimeAggregatorIteratorSetting as queryTimeAggregatorRequired(view, store) = {}");
    verify(view).getEdgeGroups();
    verify(schema).getEntity("foo");
    verify(view).getEntityGroups();
    verify(globalViewElementDefinition).getGroupBy();
    verify(store).getSchema();
    verify(schema).getVisibilityProperty();
    verify(schema).isAggregationEnabled();
  }

  /**
   * Test {@link AbstractCoreKeyIteratorSettingsFactory#getQueryTimeAggregatorIteratorSetting(View,
   * AccumuloStore)}.
   *
   * <p>Method under test: {@link
   * AbstractCoreKeyIteratorSettingsFactory#getQueryTimeAggregatorIteratorSetting(View,
   * AccumuloStore)}
   */
  @Test
  @DisplayName("Test getQueryTimeAggregatorIteratorSetting(View, AccumuloStore)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "IteratorSetting AbstractCoreKeyIteratorSettingsFactory.getQueryTimeAggregatorIteratorSetting(View, AccumuloStore)"
  })
  void testGetQueryTimeAggregatorIteratorSetting8() throws IteratorSettingException {
    // Arrange
    ByteEntityIteratorSettingsFactory byteEntityIteratorSettingsFactory =
        new ByteEntityIteratorSettingsFactory();

    HashSet<String> stringSet = new HashSet<>();
    stringSet.add(
        "Returning null from getQueryTimeAggregatorIteratorSetting as queryTimeAggregatorRequired(view,"
            + " store) = {}");

    HashSet<String> stringSet2 = new HashSet<>();
    stringSet2.add("foo");

    GlobalViewElementDefinition globalViewElementDefinition =
        mock(GlobalViewElementDefinition.class);
    when(globalViewElementDefinition.getGroupBy()).thenReturn(null);

    ViewElementDefinition viewElementDefinition = new ViewElementDefinition();
    viewElementDefinition.setGroupBy(new LinkedHashSet<>());

    NamedView view = mock(NamedView.class);
    when(view.getElement(Mockito.<String>any())).thenReturn(viewElementDefinition);
    when(view.getEdge(Mockito.<String>any())).thenReturn(globalViewElementDefinition);
    when(view.getEdgeGroups()).thenReturn(stringSet);
    when(view.getEntityGroups()).thenReturn(stringSet2);

    Schema schema = mock(Schema.class);
    when(schema.getEntity(Mockito.<String>any())).thenReturn(new SchemaEntityDefinition());
    when(schema.getEdge(Mockito.<String>any())).thenReturn(new SchemaEdgeDefinition());
    when(schema.getVisibilityProperty()).thenReturn("Visibility Property");
    when(schema.isAggregationEnabled()).thenReturn(true);

    AccumuloStore store = mock(AccumuloStore.class);
    when(store.getSchema()).thenReturn(schema);

    // Act
    IteratorSetting actualQueryTimeAggregatorIteratorSetting =
        byteEntityIteratorSettingsFactory.getQueryTimeAggregatorIteratorSetting(view, store);

    // Assert
    verify(view, atLeast(1))
        .getEdge(
            "Returning null from getQueryTimeAggregatorIteratorSetting as queryTimeAggregatorRequired(view, store) = {}");
    verify(schema, atLeast(1))
        .getEdge(
            "Returning null from getQueryTimeAggregatorIteratorSetting as queryTimeAggregatorRequired(view, store) = {}");
    verify(view, atLeast(1)).getEdgeGroups();
    verify(schema, atLeast(1)).getEntity("foo");
    verify(view, atLeast(1)).getEntityGroups();
    verify(view, atLeast(1)).getElement("foo");
    verify(globalViewElementDefinition, atLeast(1)).getGroupBy();
    verify(store, atLeast(1)).getSchema();
    verify(schema, atLeast(1)).getVisibilityProperty();
    verify(schema, atLeast(1)).isAggregationEnabled();
    assertNull(actualQueryTimeAggregatorIteratorSetting);
  }

  /**
   * Test {@link AbstractCoreKeyIteratorSettingsFactory#getQueryTimeAggregatorIteratorSetting(View,
   * AccumuloStore)}.
   *
   * <p>Method under test: {@link
   * AbstractCoreKeyIteratorSettingsFactory#getQueryTimeAggregatorIteratorSetting(View,
   * AccumuloStore)}
   */
  @Test
  @DisplayName("Test getQueryTimeAggregatorIteratorSetting(View, AccumuloStore)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "IteratorSetting AbstractCoreKeyIteratorSettingsFactory.getQueryTimeAggregatorIteratorSetting(View, AccumuloStore)"
  })
  void testGetQueryTimeAggregatorIteratorSetting9() throws IteratorSettingException {
    // Arrange
    ByteEntityIteratorSettingsFactory byteEntityIteratorSettingsFactory =
        new ByteEntityIteratorSettingsFactory();

    HashSet<String> stringSet = new HashSet<>();
    stringSet.add(
        "Returning null from getQueryTimeAggregatorIteratorSetting as queryTimeAggregatorRequired(view,"
            + " store) = {}");

    HashSet<String> stringSet2 = new HashSet<>();
    stringSet2.add("foo");

    GlobalViewElementDefinition globalViewElementDefinition =
        mock(GlobalViewElementDefinition.class);
    when(globalViewElementDefinition.getGroupBy()).thenReturn(null);

    NamedView view = mock(NamedView.class);
    when(view.getElement(Mockito.<String>any())).thenThrow(new IllegalArgumentException());
    when(view.getEdge(Mockito.<String>any())).thenReturn(globalViewElementDefinition);
    when(view.getEdgeGroups()).thenReturn(stringSet);
    when(view.getEntityGroups()).thenReturn(stringSet2);

    Schema schema = mock(Schema.class);
    when(schema.getEntity(Mockito.<String>any())).thenReturn(new SchemaEntityDefinition());
    when(schema.getEdge(Mockito.<String>any())).thenReturn(new SchemaEdgeDefinition());
    when(schema.getVisibilityProperty()).thenReturn("Visibility Property");
    when(schema.isAggregationEnabled()).thenReturn(true);

    AccumuloStore store = mock(AccumuloStore.class);
    when(store.getSchema()).thenReturn(schema);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> byteEntityIteratorSettingsFactory.getQueryTimeAggregatorIteratorSetting(view, store));
    verify(view)
        .getEdge(
            "Returning null from getQueryTimeAggregatorIteratorSetting as queryTimeAggregatorRequired(view, store) = {}");
    verify(schema)
        .getEdge(
            "Returning null from getQueryTimeAggregatorIteratorSetting as queryTimeAggregatorRequired(view, store) = {}");
    verify(view).getEdgeGroups();
    verify(schema).getEntity("foo");
    verify(view).getEntityGroups();
    verify(view).getElement("foo");
    verify(globalViewElementDefinition).getGroupBy();
    verify(store).getSchema();
    verify(schema).getVisibilityProperty();
    verify(schema).isAggregationEnabled();
  }

  /**
   * Test {@link AbstractCoreKeyIteratorSettingsFactory#getQueryTimeAggregatorIteratorSetting(View,
   * AccumuloStore)}.
   *
   * <p>Method under test: {@link
   * AbstractCoreKeyIteratorSettingsFactory#getQueryTimeAggregatorIteratorSetting(View,
   * AccumuloStore)}
   */
  @Test
  @DisplayName("Test getQueryTimeAggregatorIteratorSetting(View, AccumuloStore)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "IteratorSetting AbstractCoreKeyIteratorSettingsFactory.getQueryTimeAggregatorIteratorSetting(View, AccumuloStore)"
  })
  void testGetQueryTimeAggregatorIteratorSetting10() throws IteratorSettingException {
    // Arrange
    ByteEntityIteratorSettingsFactory byteEntityIteratorSettingsFactory =
        new ByteEntityIteratorSettingsFactory();

    HashSet<String> stringSet = new HashSet<>();
    stringSet.add(
        "Returning null from getQueryTimeAggregatorIteratorSetting as queryTimeAggregatorRequired(view,"
            + " store) = {}");

    HashSet<String> stringSet2 = new HashSet<>();
    stringSet2.add("foo");

    GlobalViewElementDefinition globalViewElementDefinition =
        mock(GlobalViewElementDefinition.class);
    when(globalViewElementDefinition.getGroupBy()).thenReturn(null);

    NamedView view = mock(NamedView.class);
    when(view.getEdge(Mockito.<String>any())).thenReturn(globalViewElementDefinition);
    when(view.getEdgeGroups()).thenReturn(stringSet);
    when(view.getEntityGroups()).thenReturn(stringSet2);

    SchemaEntityDefinition schemaEntityDefinition = mock(SchemaEntityDefinition.class);
    when(schemaEntityDefinition.containsProperty(Mockito.<String>any()))
        .thenThrow(new IllegalArgumentException());

    Schema schema = mock(Schema.class);
    when(schema.getEntity(Mockito.<String>any())).thenReturn(schemaEntityDefinition);
    when(schema.getEdge(Mockito.<String>any())).thenReturn(new SchemaEdgeDefinition());
    when(schema.getVisibilityProperty()).thenReturn("Visibility Property");
    when(schema.isAggregationEnabled()).thenReturn(true);

    AccumuloStore store = mock(AccumuloStore.class);
    when(store.getSchema()).thenReturn(schema);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> byteEntityIteratorSettingsFactory.getQueryTimeAggregatorIteratorSetting(view, store));
    verify(view)
        .getEdge(
            "Returning null from getQueryTimeAggregatorIteratorSetting as queryTimeAggregatorRequired(view, store) = {}");
    verify(schema)
        .getEdge(
            "Returning null from getQueryTimeAggregatorIteratorSetting as queryTimeAggregatorRequired(view, store) = {}");
    verify(view).getEdgeGroups();
    verify(schema).getEntity("foo");
    verify(view).getEntityGroups();
    verify(globalViewElementDefinition).getGroupBy();
    verify(store).getSchema();
    verify(schema).getVisibilityProperty();
    verify(schema).isAggregationEnabled();
    verify(schemaEntityDefinition).containsProperty("Visibility Property");
  }

  /**
   * Test {@link AbstractCoreKeyIteratorSettingsFactory#getQueryTimeAggregatorIteratorSetting(View,
   * AccumuloStore)}.
   *
   * <p>Method under test: {@link
   * AbstractCoreKeyIteratorSettingsFactory#getQueryTimeAggregatorIteratorSetting(View,
   * AccumuloStore)}
   */
  @Test
  @DisplayName("Test getQueryTimeAggregatorIteratorSetting(View, AccumuloStore)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "IteratorSetting AbstractCoreKeyIteratorSettingsFactory.getQueryTimeAggregatorIteratorSetting(View, AccumuloStore)"
  })
  void testGetQueryTimeAggregatorIteratorSetting11() throws IteratorSettingException {
    // Arrange
    ByteEntityIteratorSettingsFactory byteEntityIteratorSettingsFactory =
        new ByteEntityIteratorSettingsFactory();

    HashSet<String> stringSet = new HashSet<>();
    stringSet.add(
        "Returning null from getQueryTimeAggregatorIteratorSetting as queryTimeAggregatorRequired(view,"
            + " store) = {}");

    HashSet<String> stringSet2 = new HashSet<>();
    stringSet2.add("foo");

    GlobalViewElementDefinition globalViewElementDefinition =
        mock(GlobalViewElementDefinition.class);
    when(globalViewElementDefinition.getGroupBy()).thenReturn(null);

    NamedView view = mock(NamedView.class);
    when(view.getEdge(Mockito.<String>any())).thenReturn(globalViewElementDefinition);
    when(view.getEdgeGroups()).thenReturn(stringSet);
    when(view.getEntityGroups()).thenReturn(stringSet2);

    SchemaEntityDefinition schemaEntityDefinition = mock(SchemaEntityDefinition.class);
    when(schemaEntityDefinition.containsProperty(Mockito.<String>any())).thenReturn(true);

    Schema schema = mock(Schema.class);
    when(schema.getAggregatedGroups()).thenThrow(new IllegalArgumentException());
    when(schema.getEntity(Mockito.<String>any())).thenReturn(schemaEntityDefinition);
    when(schema.getEdge(Mockito.<String>any())).thenReturn(new SchemaEdgeDefinition());
    when(schema.getVisibilityProperty()).thenReturn("Visibility Property");
    when(schema.isAggregationEnabled()).thenReturn(true);

    AccumuloStore store = mock(AccumuloStore.class);
    when(store.getSchema()).thenReturn(schema);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> byteEntityIteratorSettingsFactory.getQueryTimeAggregatorIteratorSetting(view, store));
    verify(view)
        .getEdge(
            "Returning null from getQueryTimeAggregatorIteratorSetting as queryTimeAggregatorRequired(view, store) = {}");
    verify(schema)
        .getEdge(
            "Returning null from getQueryTimeAggregatorIteratorSetting as queryTimeAggregatorRequired(view, store) = {}");
    verify(view).getEdgeGroups();
    verify(schema).getEntity("foo");
    verify(view).getEntityGroups();
    verify(globalViewElementDefinition).getGroupBy();
    verify(store, atLeast(1)).getSchema();
    verify(schema).getAggregatedGroups();
    verify(schema).getVisibilityProperty();
    verify(schema).isAggregationEnabled();
    verify(schemaEntityDefinition).containsProperty("Visibility Property");
  }

  /**
   * Test {@link AbstractCoreKeyIteratorSettingsFactory#getQueryTimeAggregatorIteratorSetting(View,
   * AccumuloStore)}.
   *
   * <p>Method under test: {@link
   * AbstractCoreKeyIteratorSettingsFactory#getQueryTimeAggregatorIteratorSetting(View,
   * AccumuloStore)}
   */
  @Test
  @DisplayName("Test getQueryTimeAggregatorIteratorSetting(View, AccumuloStore)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "IteratorSetting AbstractCoreKeyIteratorSettingsFactory.getQueryTimeAggregatorIteratorSetting(View, AccumuloStore)"
  })
  void testGetQueryTimeAggregatorIteratorSetting12()
      throws UnsupportedEncodingException, IteratorSettingException, SchemaException {
    // Arrange
    ByteEntityIteratorSettingsFactory byteEntityIteratorSettingsFactory =
        new ByteEntityIteratorSettingsFactory();

    HashSet<String> stringSet = new HashSet<>();
    stringSet.add(
        "Returning null from getQueryTimeAggregatorIteratorSetting as queryTimeAggregatorRequired(view,"
            + " store) = {}");

    HashSet<String> stringSet2 = new HashSet<>();
    stringSet2.add("foo");

    GlobalViewElementDefinition globalViewElementDefinition =
        mock(GlobalViewElementDefinition.class);
    when(globalViewElementDefinition.getGroupBy()).thenReturn(null);

    NamedView view = mock(NamedView.class);
    when(view.toCompactJson()).thenThrow(new IllegalArgumentException());
    when(view.getEdge(Mockito.<String>any())).thenReturn(globalViewElementDefinition);
    when(view.getEdgeGroups()).thenReturn(stringSet);
    when(view.getEntityGroups()).thenReturn(stringSet2);

    SchemaEntityDefinition schemaEntityDefinition = mock(SchemaEntityDefinition.class);
    when(schemaEntityDefinition.containsProperty(Mockito.<String>any())).thenReturn(true);

    Schema schema = mock(Schema.class);
    when(schema.toCompactJson()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    when(schema.getAggregatedGroups()).thenReturn(new ArrayList<>());
    when(schema.getEntity(Mockito.<String>any())).thenReturn(schemaEntityDefinition);
    when(schema.getEdge(Mockito.<String>any())).thenReturn(new SchemaEdgeDefinition());
    when(schema.getVisibilityProperty()).thenReturn("Visibility Property");
    when(schema.isAggregationEnabled()).thenReturn(true);

    AccumuloStore store = mock(AccumuloStore.class);
    when(store.getSchema()).thenReturn(schema);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> byteEntityIteratorSettingsFactory.getQueryTimeAggregatorIteratorSetting(view, store));
    verify(view)
        .getEdge(
            "Returning null from getQueryTimeAggregatorIteratorSetting as queryTimeAggregatorRequired(view, store) = {}");
    verify(schema)
        .getEdge(
            "Returning null from getQueryTimeAggregatorIteratorSetting as queryTimeAggregatorRequired(view, store) = {}");
    verify(view).getEdgeGroups();
    verify(schema).getEntity("foo");
    verify(view).getEntityGroups();
    verify(view).toCompactJson();
    verify(globalViewElementDefinition).getGroupBy();
    verify(store, atLeast(1)).getSchema();
    verify(schema).getAggregatedGroups();
    verify(schema).getVisibilityProperty();
    verify(schema).isAggregationEnabled();
    verify(schema).toCompactJson();
    verify(schemaEntityDefinition).containsProperty("Visibility Property");
  }

  /**
   * Test {@link AbstractCoreKeyIteratorSettingsFactory#getQueryTimeAggregatorIteratorSetting(View,
   * AccumuloStore)}.
   *
   * <p>Method under test: {@link
   * AbstractCoreKeyIteratorSettingsFactory#getQueryTimeAggregatorIteratorSetting(View,
   * AccumuloStore)}
   */
  @Test
  @DisplayName("Test getQueryTimeAggregatorIteratorSetting(View, AccumuloStore)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "IteratorSetting AbstractCoreKeyIteratorSettingsFactory.getQueryTimeAggregatorIteratorSetting(View, AccumuloStore)"
  })
  void testGetQueryTimeAggregatorIteratorSetting13()
      throws UnsupportedEncodingException, IteratorSettingException, SchemaException {
    // Arrange
    ByteEntityIteratorSettingsFactory byteEntityIteratorSettingsFactory =
        new ByteEntityIteratorSettingsFactory();

    HashSet<String> stringSet = new HashSet<>();
    stringSet.add(
        "Returning null from getQueryTimeAggregatorIteratorSetting as queryTimeAggregatorRequired(view,"
            + " store) = {}");

    HashSet<String> stringSet2 = new HashSet<>();
    stringSet2.add("foo");

    GlobalViewElementDefinition globalViewElementDefinition =
        mock(GlobalViewElementDefinition.class);
    when(globalViewElementDefinition.getGroupBy()).thenReturn(null);

    NamedView view = mock(NamedView.class);
    when(view.toCompactJson()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    when(view.getEdge(Mockito.<String>any())).thenReturn(globalViewElementDefinition);
    when(view.getEdgeGroups()).thenReturn(stringSet);
    when(view.getEntityGroups()).thenReturn(stringSet2);

    SchemaEntityDefinition schemaEntityDefinition = mock(SchemaEntityDefinition.class);
    when(schemaEntityDefinition.containsProperty(Mockito.<String>any())).thenReturn(true);

    Schema schema = mock(Schema.class);
    when(schema.toCompactJson()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    when(schema.getAggregatedGroups()).thenReturn(new ArrayList<>());
    when(schema.getEntity(Mockito.<String>any())).thenReturn(schemaEntityDefinition);
    when(schema.getEdge(Mockito.<String>any())).thenReturn(new SchemaEdgeDefinition());
    when(schema.getVisibilityProperty()).thenReturn("Visibility Property");
    when(schema.isAggregationEnabled()).thenReturn(true);

    AccumuloStore store = mock(AccumuloStore.class);
    when(store.getKeyPackage()).thenThrow(new IllegalArgumentException());
    when(store.getSchema()).thenReturn(schema);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> byteEntityIteratorSettingsFactory.getQueryTimeAggregatorIteratorSetting(view, store));
    verify(store).getKeyPackage();
    verify(view)
        .getEdge(
            "Returning null from getQueryTimeAggregatorIteratorSetting as queryTimeAggregatorRequired(view, store) = {}");
    verify(schema)
        .getEdge(
            "Returning null from getQueryTimeAggregatorIteratorSetting as queryTimeAggregatorRequired(view, store) = {}");
    verify(view).getEdgeGroups();
    verify(schema).getEntity("foo");
    verify(view).getEntityGroups();
    verify(view).toCompactJson();
    verify(globalViewElementDefinition).getGroupBy();
    verify(store, atLeast(1)).getSchema();
    verify(schema).getAggregatedGroups();
    verify(schema).getVisibilityProperty();
    verify(schema).isAggregationEnabled();
    verify(schema).toCompactJson();
    verify(schemaEntityDefinition).containsProperty("Visibility Property");
  }

  /**
   * Test {@link AbstractCoreKeyIteratorSettingsFactory#getQueryTimeAggregatorIteratorSetting(View,
   * AccumuloStore)}.
   *
   * <ul>
   *   <li>Given {@link HashSet#HashSet()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AbstractCoreKeyIteratorSettingsFactory#getQueryTimeAggregatorIteratorSetting(View,
   * AccumuloStore)}
   */
  @Test
  @DisplayName(
      "Test getQueryTimeAggregatorIteratorSetting(View, AccumuloStore); given HashSet(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "IteratorSetting AbstractCoreKeyIteratorSettingsFactory.getQueryTimeAggregatorIteratorSetting(View, AccumuloStore)"
  })
  void testGetQueryTimeAggregatorIteratorSetting_givenHashSet_thenReturnNull()
      throws IteratorSettingException {
    // Arrange
    ByteEntityIteratorSettingsFactory byteEntityIteratorSettingsFactory =
        new ByteEntityIteratorSettingsFactory();

    NamedView view = mock(NamedView.class);
    when(view.getEdgeGroups()).thenReturn(new HashSet<>());
    when(view.getEntityGroups()).thenReturn(new HashSet<>());

    Schema schema = mock(Schema.class);
    when(schema.getVisibilityProperty()).thenReturn("Visibility Property");
    when(schema.isAggregationEnabled()).thenReturn(true);

    AccumuloStore store = mock(AccumuloStore.class);
    when(store.getSchema()).thenReturn(schema);

    // Act
    IteratorSetting actualQueryTimeAggregatorIteratorSetting =
        byteEntityIteratorSettingsFactory.getQueryTimeAggregatorIteratorSetting(view, store);

    // Assert
    verify(view, atLeast(1)).getEdgeGroups();
    verify(view, atLeast(1)).getEntityGroups();
    verify(store, atLeast(1)).getSchema();
    verify(schema, atLeast(1)).getVisibilityProperty();
    verify(schema, atLeast(1)).isAggregationEnabled();
    assertNull(actualQueryTimeAggregatorIteratorSetting);
  }

  /**
   * Test {@link AbstractCoreKeyIteratorSettingsFactory#getQueryTimeAggregatorIteratorSetting(View,
   * AccumuloStore)}.
   *
   * <ul>
   *   <li>Given {@link Schema#Schema()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AbstractCoreKeyIteratorSettingsFactory#getQueryTimeAggregatorIteratorSetting(View,
   * AccumuloStore)}
   */
  @Test
  @DisplayName("Test getQueryTimeAggregatorIteratorSetting(View, AccumuloStore); given Schema()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "IteratorSetting AbstractCoreKeyIteratorSettingsFactory.getQueryTimeAggregatorIteratorSetting(View, AccumuloStore)"
  })
  void testGetQueryTimeAggregatorIteratorSetting_givenSchema() throws IteratorSettingException {
    // Arrange
    ByteEntityIteratorSettingsFactory byteEntityIteratorSettingsFactory =
        new ByteEntityIteratorSettingsFactory();
    View view = new View();

    AccumuloStore store = mock(AccumuloStore.class);
    when(store.getSchema()).thenReturn(new Schema());

    // Act
    IteratorSetting actualQueryTimeAggregatorIteratorSetting =
        byteEntityIteratorSettingsFactory.getQueryTimeAggregatorIteratorSetting(view, store);

    // Assert
    verify(store, atLeast(1)).getSchema();
    assertNull(actualQueryTimeAggregatorIteratorSetting);
  }

  /**
   * Test {@link AbstractCoreKeyIteratorSettingsFactory#getQueryTimeAggregatorIteratorSetting(View,
   * AccumuloStore)}.
   *
   * <ul>
   *   <li>Given {@link Schema} {@link Schema#getEntity(String)} return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AbstractCoreKeyIteratorSettingsFactory#getQueryTimeAggregatorIteratorSetting(View,
   * AccumuloStore)}
   */
  @Test
  @DisplayName(
      "Test getQueryTimeAggregatorIteratorSetting(View, AccumuloStore); given Schema getEntity(String) return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "IteratorSetting AbstractCoreKeyIteratorSettingsFactory.getQueryTimeAggregatorIteratorSetting(View, AccumuloStore)"
  })
  void testGetQueryTimeAggregatorIteratorSetting_givenSchemaGetEntityReturnNull()
      throws IteratorSettingException {
    // Arrange
    ByteEntityIteratorSettingsFactory byteEntityIteratorSettingsFactory =
        new ByteEntityIteratorSettingsFactory();

    HashSet<String> stringSet = new HashSet<>();
    stringSet.add(
        "Returning null from getQueryTimeAggregatorIteratorSetting as queryTimeAggregatorRequired(view,"
            + " store) = {}");

    HashSet<String> stringSet2 = new HashSet<>();
    stringSet2.add("foo");

    GlobalViewElementDefinition globalViewElementDefinition =
        mock(GlobalViewElementDefinition.class);
    when(globalViewElementDefinition.getGroupBy()).thenReturn(null);

    NamedView view = mock(NamedView.class);
    when(view.getEdge(Mockito.<String>any())).thenReturn(globalViewElementDefinition);
    when(view.getEdgeGroups()).thenReturn(stringSet);
    when(view.getEntityGroups()).thenReturn(stringSet2);

    Schema schema = mock(Schema.class);
    when(schema.getEntity(Mockito.<String>any())).thenReturn(null);
    when(schema.getEdge(Mockito.<String>any())).thenReturn(new SchemaEdgeDefinition());
    when(schema.getVisibilityProperty()).thenReturn("Visibility Property");
    when(schema.isAggregationEnabled()).thenReturn(true);

    AccumuloStore store = mock(AccumuloStore.class);
    when(store.getSchema()).thenReturn(schema);

    // Act
    IteratorSetting actualQueryTimeAggregatorIteratorSetting =
        byteEntityIteratorSettingsFactory.getQueryTimeAggregatorIteratorSetting(view, store);

    // Assert
    verify(view, atLeast(1))
        .getEdge(
            "Returning null from getQueryTimeAggregatorIteratorSetting as queryTimeAggregatorRequired(view, store) = {}");
    verify(schema, atLeast(1))
        .getEdge(
            "Returning null from getQueryTimeAggregatorIteratorSetting as queryTimeAggregatorRequired(view, store) = {}");
    verify(view, atLeast(1)).getEdgeGroups();
    verify(schema, atLeast(1)).getEntity("foo");
    verify(view, atLeast(1)).getEntityGroups();
    verify(globalViewElementDefinition, atLeast(1)).getGroupBy();
    verify(store, atLeast(1)).getSchema();
    verify(schema, atLeast(1)).getVisibilityProperty();
    verify(schema, atLeast(1)).isAggregationEnabled();
    assertNull(actualQueryTimeAggregatorIteratorSetting);
  }

  /**
   * Test {@link AbstractCoreKeyIteratorSettingsFactory#getQueryTimeAggregatorIteratorSetting(View,
   * AccumuloStore)}.
   *
   * <ul>
   *   <li>Given {@link ViewElementDefinition} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link
   * AbstractCoreKeyIteratorSettingsFactory#getQueryTimeAggregatorIteratorSetting(View,
   * AccumuloStore)}
   */
  @Test
  @DisplayName(
      "Test getQueryTimeAggregatorIteratorSetting(View, AccumuloStore); given ViewElementDefinition (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "IteratorSetting AbstractCoreKeyIteratorSettingsFactory.getQueryTimeAggregatorIteratorSetting(View, AccumuloStore)"
  })
  void testGetQueryTimeAggregatorIteratorSetting_givenViewElementDefinition()
      throws IteratorSettingException {
    // Arrange
    ByteEntityIteratorSettingsFactory byteEntityIteratorSettingsFactory =
        new ByteEntityIteratorSettingsFactory();

    HashSet<String> stringSet = new HashSet<>();
    stringSet.add(
        "Returning null from getQueryTimeAggregatorIteratorSetting as queryTimeAggregatorRequired(view,"
            + " store) = {}");

    NamedView view = mock(NamedView.class);
    when(view.getEdge(Mockito.<String>any())).thenReturn(new ViewElementDefinition());
    when(view.getEdgeGroups()).thenReturn(stringSet);
    when(view.getEntityGroups()).thenReturn(new HashSet<>());

    Schema schema = mock(Schema.class);
    when(schema.getEdge(Mockito.<String>any())).thenReturn(new SchemaEdgeDefinition());
    when(schema.getVisibilityProperty()).thenReturn("Visibility Property");
    when(schema.isAggregationEnabled()).thenReturn(true);

    AccumuloStore store = mock(AccumuloStore.class);
    when(store.getSchema()).thenReturn(schema);

    // Act
    IteratorSetting actualQueryTimeAggregatorIteratorSetting =
        byteEntityIteratorSettingsFactory.getQueryTimeAggregatorIteratorSetting(view, store);

    // Assert
    verify(view, atLeast(1))
        .getEdge(
            "Returning null from getQueryTimeAggregatorIteratorSetting as queryTimeAggregatorRequired(view, store) = {}");
    verify(schema, atLeast(1))
        .getEdge(
            "Returning null from getQueryTimeAggregatorIteratorSetting as queryTimeAggregatorRequired(view, store) = {}");
    verify(view, atLeast(1)).getEdgeGroups();
    verify(view, atLeast(1)).getEntityGroups();
    verify(store, atLeast(1)).getSchema();
    verify(schema, atLeast(1)).getVisibilityProperty();
    verify(schema, atLeast(1)).isAggregationEnabled();
    assertNull(actualQueryTimeAggregatorIteratorSetting);
  }

  /**
   * Test {@link AbstractCoreKeyIteratorSettingsFactory#getQueryTimeAggregatorIteratorSetting(View,
   * AccumuloStore)}.
   *
   * <ul>
   *   <li>Then calls {@link NamedView#getElement(String)}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AbstractCoreKeyIteratorSettingsFactory#getQueryTimeAggregatorIteratorSetting(View,
   * AccumuloStore)}
   */
  @Test
  @DisplayName(
      "Test getQueryTimeAggregatorIteratorSetting(View, AccumuloStore); then calls getElement(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "IteratorSetting AbstractCoreKeyIteratorSettingsFactory.getQueryTimeAggregatorIteratorSetting(View, AccumuloStore)"
  })
  void testGetQueryTimeAggregatorIteratorSetting_thenCallsGetElement()
      throws IteratorSettingException {
    // Arrange
    ByteEntityIteratorSettingsFactory byteEntityIteratorSettingsFactory =
        new ByteEntityIteratorSettingsFactory();

    HashSet<String> stringSet = new HashSet<>();
    stringSet.add(
        "Returning null from getQueryTimeAggregatorIteratorSetting as queryTimeAggregatorRequired(view,"
            + " store) = {}");

    HashSet<String> stringSet2 = new HashSet<>();
    stringSet2.add("foo");

    GlobalViewElementDefinition globalViewElementDefinition =
        mock(GlobalViewElementDefinition.class);
    when(globalViewElementDefinition.getGroupBy()).thenReturn(null);

    ViewElementDefinition viewElementDefinition = new ViewElementDefinition();
    viewElementDefinition.setGroupBy(null);

    NamedView view = mock(NamedView.class);
    when(view.getElement(Mockito.<String>any())).thenReturn(viewElementDefinition);
    when(view.getEdge(Mockito.<String>any())).thenReturn(globalViewElementDefinition);
    when(view.getEdgeGroups()).thenReturn(stringSet);
    when(view.getEntityGroups()).thenReturn(stringSet2);

    Schema schema = mock(Schema.class);
    when(schema.getEntity(Mockito.<String>any())).thenReturn(new SchemaEntityDefinition());
    when(schema.getEdge(Mockito.<String>any())).thenReturn(new SchemaEdgeDefinition());
    when(schema.getVisibilityProperty()).thenReturn("Visibility Property");
    when(schema.isAggregationEnabled()).thenReturn(true);

    AccumuloStore store = mock(AccumuloStore.class);
    when(store.getSchema()).thenReturn(schema);

    // Act
    IteratorSetting actualQueryTimeAggregatorIteratorSetting =
        byteEntityIteratorSettingsFactory.getQueryTimeAggregatorIteratorSetting(view, store);

    // Assert
    verify(view, atLeast(1))
        .getEdge(
            "Returning null from getQueryTimeAggregatorIteratorSetting as queryTimeAggregatorRequired(view, store) = {}");
    verify(schema, atLeast(1))
        .getEdge(
            "Returning null from getQueryTimeAggregatorIteratorSetting as queryTimeAggregatorRequired(view, store) = {}");
    verify(view, atLeast(1)).getEdgeGroups();
    verify(schema, atLeast(1)).getEntity("foo");
    verify(view, atLeast(1)).getEntityGroups();
    verify(view, atLeast(1)).getElement("foo");
    verify(globalViewElementDefinition, atLeast(1)).getGroupBy();
    verify(store, atLeast(1)).getSchema();
    verify(schema, atLeast(1)).getVisibilityProperty();
    verify(schema, atLeast(1)).isAggregationEnabled();
    assertNull(actualQueryTimeAggregatorIteratorSetting);
  }

  /**
   * Test {@link AbstractCoreKeyIteratorSettingsFactory#getQueryTimeAggregatorIteratorSetting(View,
   * AccumuloStore)}.
   *
   * <ul>
   *   <li>Then return Options {@code columns} is empty string.
   * </ul>
   *
   * <p>Method under test: {@link
   * AbstractCoreKeyIteratorSettingsFactory#getQueryTimeAggregatorIteratorSetting(View,
   * AccumuloStore)}
   */
  @Test
  @DisplayName(
      "Test getQueryTimeAggregatorIteratorSetting(View, AccumuloStore); then return Options 'columns' is empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "IteratorSetting AbstractCoreKeyIteratorSettingsFactory.getQueryTimeAggregatorIteratorSetting(View, AccumuloStore)"
  })
  void testGetQueryTimeAggregatorIteratorSetting_thenReturnOptionsColumnsIsEmptyString()
      throws UnsupportedEncodingException, IteratorSettingException, SchemaException {
    // Arrange
    ByteEntityIteratorSettingsFactory byteEntityIteratorSettingsFactory =
        new ByteEntityIteratorSettingsFactory();

    HashSet<String> stringSet = new HashSet<>();
    stringSet.add(
        "Returning null from getQueryTimeAggregatorIteratorSetting as queryTimeAggregatorRequired(view,"
            + " store) = {}");

    HashSet<String> stringSet2 = new HashSet<>();
    stringSet2.add("foo");

    GlobalViewElementDefinition globalViewElementDefinition =
        mock(GlobalViewElementDefinition.class);
    when(globalViewElementDefinition.getGroupBy()).thenReturn(null);

    NamedView view = mock(NamedView.class);
    when(view.toCompactJson()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    when(view.getEdge(Mockito.<String>any())).thenReturn(globalViewElementDefinition);
    when(view.getEdgeGroups()).thenReturn(stringSet);
    when(view.getEntityGroups()).thenReturn(stringSet2);

    SchemaEntityDefinition schemaEntityDefinition = mock(SchemaEntityDefinition.class);
    when(schemaEntityDefinition.containsProperty(Mockito.<String>any())).thenReturn(true);

    Schema schema = mock(Schema.class);
    when(schema.toCompactJson()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    when(schema.getAggregatedGroups()).thenReturn(new ArrayList<>());
    when(schema.getEntity(Mockito.<String>any())).thenReturn(schemaEntityDefinition);
    when(schema.getEdge(Mockito.<String>any())).thenReturn(new SchemaEdgeDefinition());
    when(schema.getVisibilityProperty()).thenReturn("Visibility Property");
    when(schema.isAggregationEnabled()).thenReturn(true);

    AccumuloStore store = mock(AccumuloStore.class);
    when(store.getKeyPackage()).thenReturn(new ByteEntityKeyPackage(new Schema()));
    when(store.getSchema()).thenReturn(schema);

    // Act
    IteratorSetting actualQueryTimeAggregatorIteratorSetting =
        byteEntityIteratorSettingsFactory.getQueryTimeAggregatorIteratorSetting(view, store);

    // Assert
    verify(store, atLeast(1)).getKeyPackage();
    verify(view)
        .getEdge(
            "Returning null from getQueryTimeAggregatorIteratorSetting as queryTimeAggregatorRequired(view, store) = {}");
    verify(schema)
        .getEdge(
            "Returning null from getQueryTimeAggregatorIteratorSetting as queryTimeAggregatorRequired(view, store) = {}");
    verify(view).getEdgeGroups();
    verify(schema).getEntity("foo");
    verify(view).getEntityGroups();
    verify(view).toCompactJson();
    verify(globalViewElementDefinition).getGroupBy();
    verify(store, atLeast(1)).getSchema();
    verify(schema, atLeast(1)).getAggregatedGroups();
    verify(schema).getVisibilityProperty();
    verify(schema).isAggregationEnabled();
    verify(schema).toCompactJson();
    verify(schemaEntityDefinition).containsProperty("Visibility Property");
    Map<String, String> options = actualQueryTimeAggregatorIteratorSetting.getOptions();
    assertEquals(4, options.size());
    assertEquals("", options.get("columns"));
    assertEquals("AXAXAXAX", options.get("Schema"));
    assertEquals("AXAXAXAX", options.get("View"));
    assertEquals("Column_Qualifier_Aggregator", actualQueryTimeAggregatorIteratorSetting.getName());
    assertEquals(
        "uk.gov.gchq.gaffer.accumulostore.key.core.impl.CoreKeyGroupByAggregatorIterator",
        actualQueryTimeAggregatorIteratorSetting.getIteratorClass());
    assertEquals(
        "uk.gov.gchq.gaffer.accumulostore.key.core.impl.byteEntity.ByteEntityAccumuloElementConverter",
        options.get("accumulostore.key.element_converter"));
    assertEquals(36, actualQueryTimeAggregatorIteratorSetting.getPriority());
  }

  /**
   * Test {@link AbstractCoreKeyIteratorSettingsFactory#getQueryTimeAggregatorIteratorSetting(View,
   * AccumuloStore)}.
   *
   * <ul>
   *   <li>Then return Options {@code columns} is empty string.
   * </ul>
   *
   * <p>Method under test: {@link
   * AbstractCoreKeyIteratorSettingsFactory#getQueryTimeAggregatorIteratorSetting(View,
   * AccumuloStore)}
   */
  @Test
  @DisplayName(
      "Test getQueryTimeAggregatorIteratorSetting(View, AccumuloStore); then return Options 'columns' is empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "IteratorSetting AbstractCoreKeyIteratorSettingsFactory.getQueryTimeAggregatorIteratorSetting(View, AccumuloStore)"
  })
  void testGetQueryTimeAggregatorIteratorSetting_thenReturnOptionsColumnsIsEmptyString2()
      throws UnsupportedEncodingException, IteratorSettingException, SchemaException {
    // Arrange
    ByteEntityIteratorSettingsFactory byteEntityIteratorSettingsFactory =
        new ByteEntityIteratorSettingsFactory();

    HashSet<String> stringSet = new HashSet<>();
    stringSet.add(
        "Returning null from getQueryTimeAggregatorIteratorSetting as queryTimeAggregatorRequired(view,"
            + " store) = {}");

    NamedView view = mock(NamedView.class);
    when(view.toCompactJson()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    when(view.getEdgeGroups()).thenReturn(stringSet);

    SchemaEdgeDefinition schemaEdgeDefinition = mock(SchemaEdgeDefinition.class);
    when(schemaEdgeDefinition.containsProperty(Mockito.<String>any())).thenReturn(true);

    Schema schema = mock(Schema.class);
    when(schema.toCompactJson()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    when(schema.getAggregatedGroups()).thenReturn(new ArrayList<>());
    when(schema.getEdge(Mockito.<String>any())).thenReturn(schemaEdgeDefinition);
    when(schema.getVisibilityProperty()).thenReturn("Visibility Property");
    when(schema.isAggregationEnabled()).thenReturn(true);

    AccumuloStore store = mock(AccumuloStore.class);
    when(store.getKeyPackage()).thenReturn(new ByteEntityKeyPackage(new Schema()));
    when(store.getSchema()).thenReturn(schema);

    // Act
    IteratorSetting actualQueryTimeAggregatorIteratorSetting =
        byteEntityIteratorSettingsFactory.getQueryTimeAggregatorIteratorSetting(view, store);

    // Assert
    verify(store, atLeast(1)).getKeyPackage();
    verify(schema)
        .getEdge(
            "Returning null from getQueryTimeAggregatorIteratorSetting as queryTimeAggregatorRequired(view, store) = {}");
    verify(view).getEdgeGroups();
    verify(view).toCompactJson();
    verify(store, atLeast(1)).getSchema();
    verify(schema, atLeast(1)).getAggregatedGroups();
    verify(schema).getVisibilityProperty();
    verify(schema).isAggregationEnabled();
    verify(schema).toCompactJson();
    verify(schemaEdgeDefinition).containsProperty("Visibility Property");
    Map<String, String> options = actualQueryTimeAggregatorIteratorSetting.getOptions();
    assertEquals(4, options.size());
    assertEquals("", options.get("columns"));
    assertEquals("AXAXAXAX", options.get("Schema"));
    assertEquals("AXAXAXAX", options.get("View"));
    assertEquals("Column_Qualifier_Aggregator", actualQueryTimeAggregatorIteratorSetting.getName());
    assertEquals(
        "uk.gov.gchq.gaffer.accumulostore.key.core.impl.CoreKeyGroupByAggregatorIterator",
        actualQueryTimeAggregatorIteratorSetting.getIteratorClass());
    assertEquals(
        "uk.gov.gchq.gaffer.accumulostore.key.core.impl.byteEntity.ByteEntityAccumuloElementConverter",
        options.get("accumulostore.key.element_converter"));
    assertEquals(36, actualQueryTimeAggregatorIteratorSetting.getPriority());
  }

  /**
   * Test {@link AbstractCoreKeyIteratorSettingsFactory#getQueryTimeAggregatorIteratorSetting(View,
   * AccumuloStore)}.
   *
   * <ul>
   *   <li>Then return Options {@code columns} is {@code Schema}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AbstractCoreKeyIteratorSettingsFactory#getQueryTimeAggregatorIteratorSetting(View,
   * AccumuloStore)}
   */
  @Test
  @DisplayName(
      "Test getQueryTimeAggregatorIteratorSetting(View, AccumuloStore); then return Options 'columns' is 'Schema'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "IteratorSetting AbstractCoreKeyIteratorSettingsFactory.getQueryTimeAggregatorIteratorSetting(View, AccumuloStore)"
  })
  void testGetQueryTimeAggregatorIteratorSetting_thenReturnOptionsColumnsIsSchema()
      throws UnsupportedEncodingException, IteratorSettingException, SchemaException {
    // Arrange
    ByteEntityIteratorSettingsFactory byteEntityIteratorSettingsFactory =
        new ByteEntityIteratorSettingsFactory();

    HashSet<String> stringSet = new HashSet<>();
    stringSet.add(
        "Returning null from getQueryTimeAggregatorIteratorSetting as queryTimeAggregatorRequired(view,"
            + " store) = {}");

    NamedView view = mock(NamedView.class);
    when(view.toCompactJson()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    when(view.getEdgeGroups()).thenReturn(stringSet);

    SchemaEdgeDefinition schemaEdgeDefinition = mock(SchemaEdgeDefinition.class);
    when(schemaEdgeDefinition.containsProperty(Mockito.<String>any())).thenReturn(true);

    ArrayList<String> stringList = new ArrayList<>();
    stringList.add("Schema");

    Schema schema = mock(Schema.class);
    when(schema.toCompactJson()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    when(schema.getAggregatedGroups()).thenReturn(stringList);
    when(schema.getEdge(Mockito.<String>any())).thenReturn(schemaEdgeDefinition);
    when(schema.getVisibilityProperty()).thenReturn("Visibility Property");
    when(schema.isAggregationEnabled()).thenReturn(true);

    AccumuloStore store = mock(AccumuloStore.class);
    when(store.getKeyPackage()).thenReturn(new ByteEntityKeyPackage(new Schema()));
    when(store.getSchema()).thenReturn(schema);

    // Act
    IteratorSetting actualQueryTimeAggregatorIteratorSetting =
        byteEntityIteratorSettingsFactory.getQueryTimeAggregatorIteratorSetting(view, store);

    // Assert
    verify(store, atLeast(1)).getKeyPackage();
    verify(schema)
        .getEdge(
            "Returning null from getQueryTimeAggregatorIteratorSetting as queryTimeAggregatorRequired(view, store) = {}");
    verify(view).getEdgeGroups();
    verify(view).toCompactJson();
    verify(store, atLeast(1)).getSchema();
    verify(schema, atLeast(1)).getAggregatedGroups();
    verify(schema).getVisibilityProperty();
    verify(schema).isAggregationEnabled();
    verify(schema).toCompactJson();
    verify(schemaEdgeDefinition).containsProperty("Visibility Property");
    Map<String, String> options = actualQueryTimeAggregatorIteratorSetting.getOptions();
    assertEquals(4, options.size());
    assertEquals("AXAXAXAX", options.get("Schema"));
    assertEquals("AXAXAXAX", options.get("View"));
    assertEquals("Column_Qualifier_Aggregator", actualQueryTimeAggregatorIteratorSetting.getName());
    assertEquals("Schema", options.get("columns"));
    assertEquals(
        "uk.gov.gchq.gaffer.accumulostore.key.core.impl.CoreKeyGroupByAggregatorIterator",
        actualQueryTimeAggregatorIteratorSetting.getIteratorClass());
    assertEquals(
        "uk.gov.gchq.gaffer.accumulostore.key.core.impl.byteEntity.ByteEntityAccumuloElementConverter",
        options.get("accumulostore.key.element_converter"));
    assertEquals(36, actualQueryTimeAggregatorIteratorSetting.getPriority());
  }

  /**
   * Test {@link AbstractCoreKeyIteratorSettingsFactory#getQueryTimeAggregatorIteratorSetting(View,
   * AccumuloStore)}.
   *
   * <ul>
   *   <li>When {@link NamedView} {@link NamedView#getEdge(String)} return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AbstractCoreKeyIteratorSettingsFactory#getQueryTimeAggregatorIteratorSetting(View,
   * AccumuloStore)}
   */
  @Test
  @DisplayName(
      "Test getQueryTimeAggregatorIteratorSetting(View, AccumuloStore); when NamedView getEdge(String) return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "IteratorSetting AbstractCoreKeyIteratorSettingsFactory.getQueryTimeAggregatorIteratorSetting(View, AccumuloStore)"
  })
  void testGetQueryTimeAggregatorIteratorSetting_whenNamedViewGetEdgeReturnNull()
      throws IteratorSettingException {
    // Arrange
    ByteEntityIteratorSettingsFactory byteEntityIteratorSettingsFactory =
        new ByteEntityIteratorSettingsFactory();

    HashSet<String> stringSet = new HashSet<>();
    stringSet.add(
        "Returning null from getQueryTimeAggregatorIteratorSetting as queryTimeAggregatorRequired(view,"
            + " store) = {}");

    NamedView view = mock(NamedView.class);
    when(view.getEdge(Mockito.<String>any())).thenReturn(null);
    when(view.getEdgeGroups()).thenReturn(stringSet);
    when(view.getEntityGroups()).thenReturn(new HashSet<>());

    Schema schema = mock(Schema.class);
    when(schema.getEdge(Mockito.<String>any())).thenReturn(new SchemaEdgeDefinition());
    when(schema.getVisibilityProperty()).thenReturn("Visibility Property");
    when(schema.isAggregationEnabled()).thenReturn(true);

    AccumuloStore store = mock(AccumuloStore.class);
    when(store.getSchema()).thenReturn(schema);

    // Act
    IteratorSetting actualQueryTimeAggregatorIteratorSetting =
        byteEntityIteratorSettingsFactory.getQueryTimeAggregatorIteratorSetting(view, store);

    // Assert
    verify(view, atLeast(1))
        .getEdge(
            "Returning null from getQueryTimeAggregatorIteratorSetting as queryTimeAggregatorRequired(view, store) = {}");
    verify(schema, atLeast(1))
        .getEdge(
            "Returning null from getQueryTimeAggregatorIteratorSetting as queryTimeAggregatorRequired(view, store) = {}");
    verify(view, atLeast(1)).getEdgeGroups();
    verify(view, atLeast(1)).getEntityGroups();
    verify(store, atLeast(1)).getSchema();
    verify(schema, atLeast(1)).getVisibilityProperty();
    verify(schema, atLeast(1)).isAggregationEnabled();
    assertNull(actualQueryTimeAggregatorIteratorSetting);
  }

  /**
   * Test {@link AbstractCoreKeyIteratorSettingsFactory#getQueryTimeAggregatorIteratorSetting(View,
   * AccumuloStore)}.
   *
   * <ul>
   *   <li>When {@link View} (default constructor).
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AbstractCoreKeyIteratorSettingsFactory#getQueryTimeAggregatorIteratorSetting(View,
   * AccumuloStore)}
   */
  @Test
  @DisplayName(
      "Test getQueryTimeAggregatorIteratorSetting(View, AccumuloStore); when View (default constructor); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "IteratorSetting AbstractCoreKeyIteratorSettingsFactory.getQueryTimeAggregatorIteratorSetting(View, AccumuloStore)"
  })
  void testGetQueryTimeAggregatorIteratorSetting_whenView_thenReturnNull()
      throws IteratorSettingException {
    // Arrange
    ByteEntityIteratorSettingsFactory byteEntityIteratorSettingsFactory =
        new ByteEntityIteratorSettingsFactory();
    View view = new View();

    Schema schema = mock(Schema.class);
    when(schema.getVisibilityProperty()).thenReturn("Visibility Property");
    when(schema.isAggregationEnabled()).thenReturn(true);

    AccumuloStore store = mock(AccumuloStore.class);
    when(store.getSchema()).thenReturn(schema);

    // Act
    IteratorSetting actualQueryTimeAggregatorIteratorSetting =
        byteEntityIteratorSettingsFactory.getQueryTimeAggregatorIteratorSetting(view, store);

    // Assert
    verify(store, atLeast(1)).getSchema();
    verify(schema, atLeast(1)).getVisibilityProperty();
    verify(schema, atLeast(1)).isAggregationEnabled();
    assertNull(actualQueryTimeAggregatorIteratorSetting);
  }

  /**
   * Test {@link AbstractCoreKeyIteratorSettingsFactory#queryTimeAggregatorRequired(View,
   * AccumuloStore)}.
   *
   * <p>Method under test: {@link
   * AbstractCoreKeyIteratorSettingsFactory#queryTimeAggregatorRequired(View, AccumuloStore)}
   */
  @Test
  @DisplayName("Test queryTimeAggregatorRequired(View, AccumuloStore)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AbstractCoreKeyIteratorSettingsFactory.queryTimeAggregatorRequired(View, AccumuloStore)"
  })
  void testQueryTimeAggregatorRequired() {
    // Arrange
    ByteEntityIteratorSettingsFactory byteEntityIteratorSettingsFactory =
        new ByteEntityIteratorSettingsFactory();
    View view = new View();

    Schema schema = mock(Schema.class);
    when(schema.getVisibilityProperty()).thenThrow(new IllegalArgumentException());
    when(schema.isAggregationEnabled()).thenReturn(true);

    AccumuloStore store = mock(AccumuloStore.class);
    when(store.getSchema()).thenReturn(schema);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> byteEntityIteratorSettingsFactory.queryTimeAggregatorRequired(view, store));
    verify(store).getSchema();
    verify(schema).getVisibilityProperty();
    verify(schema).isAggregationEnabled();
  }

  /**
   * Test {@link AbstractCoreKeyIteratorSettingsFactory#queryTimeAggregatorRequired(View,
   * AccumuloStore)}.
   *
   * <p>Method under test: {@link
   * AbstractCoreKeyIteratorSettingsFactory#queryTimeAggregatorRequired(View, AccumuloStore)}
   */
  @Test
  @DisplayName("Test queryTimeAggregatorRequired(View, AccumuloStore)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AbstractCoreKeyIteratorSettingsFactory.queryTimeAggregatorRequired(View, AccumuloStore)"
  })
  void testQueryTimeAggregatorRequired2() {
    // Arrange
    ByteEntityIteratorSettingsFactory byteEntityIteratorSettingsFactory =
        new ByteEntityIteratorSettingsFactory();

    HashSet<String> stringSet = new HashSet<>();
    stringSet.add("foo");

    NamedView view = mock(NamedView.class);
    when(view.getEdge(Mockito.<String>any())).thenThrow(new IllegalArgumentException());
    when(view.getEdgeGroups()).thenReturn(stringSet);

    Schema schema = mock(Schema.class);
    when(schema.getEdge(Mockito.<String>any())).thenReturn(new SchemaEdgeDefinition());
    when(schema.getVisibilityProperty()).thenReturn("Visibility Property");
    when(schema.isAggregationEnabled()).thenReturn(true);

    AccumuloStore store = mock(AccumuloStore.class);
    when(store.getSchema()).thenReturn(schema);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> byteEntityIteratorSettingsFactory.queryTimeAggregatorRequired(view, store));
    verify(view).getEdge("foo");
    verify(schema).getEdge("foo");
    verify(view).getEdgeGroups();
    verify(store).getSchema();
    verify(schema).getVisibilityProperty();
    verify(schema).isAggregationEnabled();
  }

  /**
   * Test {@link AbstractCoreKeyIteratorSettingsFactory#queryTimeAggregatorRequired(View,
   * AccumuloStore)}.
   *
   * <p>Method under test: {@link
   * AbstractCoreKeyIteratorSettingsFactory#queryTimeAggregatorRequired(View, AccumuloStore)}
   */
  @Test
  @DisplayName("Test queryTimeAggregatorRequired(View, AccumuloStore)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AbstractCoreKeyIteratorSettingsFactory.queryTimeAggregatorRequired(View, AccumuloStore)"
  })
  void testQueryTimeAggregatorRequired3() {
    // Arrange
    ByteEntityIteratorSettingsFactory byteEntityIteratorSettingsFactory =
        new ByteEntityIteratorSettingsFactory();

    HashSet<String> stringSet = new HashSet<>();
    stringSet.add("foo");

    HashSet<String> stringSet2 = new HashSet<>();
    stringSet2.add("foo");

    ViewElementDefinition viewElementDefinition = new ViewElementDefinition();
    viewElementDefinition.setGroupBy(null);

    NamedView view = mock(NamedView.class);
    when(view.getEdge(Mockito.<String>any())).thenReturn(viewElementDefinition);
    when(view.getEdgeGroups()).thenReturn(stringSet);
    when(view.getEntityGroups()).thenReturn(stringSet2);

    Schema schema = mock(Schema.class);
    when(schema.getEntity(Mockito.<String>any())).thenThrow(new IllegalArgumentException());
    when(schema.getEdge(Mockito.<String>any())).thenReturn(new SchemaEdgeDefinition());
    when(schema.getVisibilityProperty()).thenReturn("Visibility Property");
    when(schema.isAggregationEnabled()).thenReturn(true);

    AccumuloStore store = mock(AccumuloStore.class);
    when(store.getSchema()).thenReturn(schema);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> byteEntityIteratorSettingsFactory.queryTimeAggregatorRequired(view, store));
    verify(view).getEdge("foo");
    verify(schema).getEdge("foo");
    verify(view).getEdgeGroups();
    verify(schema).getEntity("foo");
    verify(view).getEntityGroups();
    verify(store).getSchema();
    verify(schema).getVisibilityProperty();
    verify(schema).isAggregationEnabled();
  }

  /**
   * Test {@link AbstractCoreKeyIteratorSettingsFactory#queryTimeAggregatorRequired(View,
   * AccumuloStore)}.
   *
   * <p>Method under test: {@link
   * AbstractCoreKeyIteratorSettingsFactory#queryTimeAggregatorRequired(View, AccumuloStore)}
   */
  @Test
  @DisplayName("Test queryTimeAggregatorRequired(View, AccumuloStore)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AbstractCoreKeyIteratorSettingsFactory.queryTimeAggregatorRequired(View, AccumuloStore)"
  })
  void testQueryTimeAggregatorRequired4() {
    // Arrange
    ByteEntityIteratorSettingsFactory byteEntityIteratorSettingsFactory =
        new ByteEntityIteratorSettingsFactory();

    HashSet<String> stringSet = new HashSet<>();
    stringSet.add("foo");

    HashSet<String> stringSet2 = new HashSet<>();
    stringSet2.add("foo");

    ViewElementDefinition viewElementDefinition = new ViewElementDefinition();
    viewElementDefinition.setGroupBy(null);

    ViewElementDefinition viewElementDefinition2 = new ViewElementDefinition();
    viewElementDefinition2.setGroupBy(null);

    NamedView view = mock(NamedView.class);
    when(view.getElement(Mockito.<String>any())).thenReturn(viewElementDefinition2);
    when(view.getEdge(Mockito.<String>any())).thenReturn(viewElementDefinition);
    when(view.getEdgeGroups()).thenReturn(stringSet);
    when(view.getEntityGroups()).thenReturn(stringSet2);

    Schema schema = mock(Schema.class);
    when(schema.getEntity(Mockito.<String>any())).thenReturn(new SchemaEntityDefinition());
    when(schema.getEdge(Mockito.<String>any())).thenReturn(new SchemaEdgeDefinition());
    when(schema.getVisibilityProperty()).thenReturn("Visibility Property");
    when(schema.isAggregationEnabled()).thenReturn(true);

    AccumuloStore store = mock(AccumuloStore.class);
    when(store.getSchema()).thenReturn(schema);

    // Act
    boolean actualQueryTimeAggregatorRequiredResult =
        byteEntityIteratorSettingsFactory.queryTimeAggregatorRequired(view, store);

    // Assert
    verify(view).getEdge("foo");
    verify(schema).getEdge("foo");
    verify(view).getEdgeGroups();
    verify(schema).getEntity("foo");
    verify(view).getEntityGroups();
    verify(view).getElement("foo");
    verify(store).getSchema();
    verify(schema).getVisibilityProperty();
    verify(schema).isAggregationEnabled();
    assertFalse(actualQueryTimeAggregatorRequiredResult);
  }

  /**
   * Test {@link AbstractCoreKeyIteratorSettingsFactory#queryTimeAggregatorRequired(View,
   * AccumuloStore)}.
   *
   * <p>Method under test: {@link
   * AbstractCoreKeyIteratorSettingsFactory#queryTimeAggregatorRequired(View, AccumuloStore)}
   */
  @Test
  @DisplayName("Test queryTimeAggregatorRequired(View, AccumuloStore)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AbstractCoreKeyIteratorSettingsFactory.queryTimeAggregatorRequired(View, AccumuloStore)"
  })
  void testQueryTimeAggregatorRequired5() {
    // Arrange
    ByteEntityIteratorSettingsFactory byteEntityIteratorSettingsFactory =
        new ByteEntityIteratorSettingsFactory();

    HashSet<String> stringSet = new HashSet<>();
    stringSet.add("foo");

    HashSet<String> stringSet2 = new HashSet<>();
    stringSet2.add("foo");

    ViewElementDefinition viewElementDefinition = new ViewElementDefinition();
    viewElementDefinition.setGroupBy(null);

    NamedView view = mock(NamedView.class);
    when(view.getElement(Mockito.<String>any())).thenThrow(new IllegalArgumentException());
    when(view.getEdge(Mockito.<String>any())).thenReturn(viewElementDefinition);
    when(view.getEdgeGroups()).thenReturn(stringSet);
    when(view.getEntityGroups()).thenReturn(stringSet2);

    Schema schema = mock(Schema.class);
    when(schema.getEntity(Mockito.<String>any())).thenReturn(new SchemaEntityDefinition());
    when(schema.getEdge(Mockito.<String>any())).thenReturn(new SchemaEdgeDefinition());
    when(schema.getVisibilityProperty()).thenReturn("Visibility Property");
    when(schema.isAggregationEnabled()).thenReturn(true);

    AccumuloStore store = mock(AccumuloStore.class);
    when(store.getSchema()).thenReturn(schema);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> byteEntityIteratorSettingsFactory.queryTimeAggregatorRequired(view, store));
    verify(view).getEdge("foo");
    verify(schema).getEdge("foo");
    verify(view).getEdgeGroups();
    verify(schema).getEntity("foo");
    verify(view).getEntityGroups();
    verify(view).getElement("foo");
    verify(store).getSchema();
    verify(schema).getVisibilityProperty();
    verify(schema).isAggregationEnabled();
  }

  /**
   * Test {@link AbstractCoreKeyIteratorSettingsFactory#queryTimeAggregatorRequired(View,
   * AccumuloStore)}.
   *
   * <p>Method under test: {@link
   * AbstractCoreKeyIteratorSettingsFactory#queryTimeAggregatorRequired(View, AccumuloStore)}
   */
  @Test
  @DisplayName("Test queryTimeAggregatorRequired(View, AccumuloStore)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AbstractCoreKeyIteratorSettingsFactory.queryTimeAggregatorRequired(View, AccumuloStore)"
  })
  void testQueryTimeAggregatorRequired6() {
    // Arrange
    ByteEntityIteratorSettingsFactory byteEntityIteratorSettingsFactory =
        new ByteEntityIteratorSettingsFactory();

    HashSet<String> stringSet = new HashSet<>();
    stringSet.add("foo");

    HashSet<String> stringSet2 = new HashSet<>();
    stringSet2.add("foo");

    ViewElementDefinition viewElementDefinition = new ViewElementDefinition();
    viewElementDefinition.setGroupBy(null);

    NamedView view = mock(NamedView.class);
    when(view.getEdge(Mockito.<String>any())).thenReturn(viewElementDefinition);
    when(view.getEdgeGroups()).thenReturn(stringSet);
    when(view.getEntityGroups()).thenReturn(stringSet2);

    SchemaEntityDefinition schemaEntityDefinition = mock(SchemaEntityDefinition.class);
    when(schemaEntityDefinition.containsProperty(Mockito.<String>any())).thenReturn(true);

    Schema schema = mock(Schema.class);
    when(schema.getEntity(Mockito.<String>any())).thenReturn(schemaEntityDefinition);
    when(schema.getEdge(Mockito.<String>any())).thenReturn(new SchemaEdgeDefinition());
    when(schema.getVisibilityProperty()).thenReturn("Visibility Property");
    when(schema.isAggregationEnabled()).thenReturn(true);

    AccumuloStore store = mock(AccumuloStore.class);
    when(store.getSchema()).thenReturn(schema);

    // Act
    boolean actualQueryTimeAggregatorRequiredResult =
        byteEntityIteratorSettingsFactory.queryTimeAggregatorRequired(view, store);

    // Assert
    verify(view).getEdge("foo");
    verify(schema).getEdge("foo");
    verify(view).getEdgeGroups();
    verify(schema).getEntity("foo");
    verify(view).getEntityGroups();
    verify(store).getSchema();
    verify(schema).getVisibilityProperty();
    verify(schema).isAggregationEnabled();
    verify(schemaEntityDefinition).containsProperty("Visibility Property");
    assertTrue(actualQueryTimeAggregatorRequiredResult);
  }

  /**
   * Test {@link AbstractCoreKeyIteratorSettingsFactory#queryTimeAggregatorRequired(View,
   * AccumuloStore)}.
   *
   * <p>Method under test: {@link
   * AbstractCoreKeyIteratorSettingsFactory#queryTimeAggregatorRequired(View, AccumuloStore)}
   */
  @Test
  @DisplayName("Test queryTimeAggregatorRequired(View, AccumuloStore)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AbstractCoreKeyIteratorSettingsFactory.queryTimeAggregatorRequired(View, AccumuloStore)"
  })
  void testQueryTimeAggregatorRequired7() {
    // Arrange
    ByteEntityIteratorSettingsFactory byteEntityIteratorSettingsFactory =
        new ByteEntityIteratorSettingsFactory();

    HashSet<String> stringSet = new HashSet<>();
    stringSet.add("foo");

    HashSet<String> stringSet2 = new HashSet<>();
    stringSet2.add("foo");

    ViewElementDefinition viewElementDefinition = new ViewElementDefinition();
    viewElementDefinition.setGroupBy(null);

    NamedView view = mock(NamedView.class);
    when(view.getEdge(Mockito.<String>any())).thenReturn(viewElementDefinition);
    when(view.getEdgeGroups()).thenReturn(stringSet);
    when(view.getEntityGroups()).thenReturn(stringSet2);

    SchemaEntityDefinition schemaEntityDefinition = mock(SchemaEntityDefinition.class);
    when(schemaEntityDefinition.containsProperty(Mockito.<String>any()))
        .thenThrow(new IllegalArgumentException());

    Schema schema = mock(Schema.class);
    when(schema.getEntity(Mockito.<String>any())).thenReturn(schemaEntityDefinition);
    when(schema.getEdge(Mockito.<String>any())).thenReturn(new SchemaEdgeDefinition());
    when(schema.getVisibilityProperty()).thenReturn("Visibility Property");
    when(schema.isAggregationEnabled()).thenReturn(true);

    AccumuloStore store = mock(AccumuloStore.class);
    when(store.getSchema()).thenReturn(schema);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> byteEntityIteratorSettingsFactory.queryTimeAggregatorRequired(view, store));
    verify(view).getEdge("foo");
    verify(schema).getEdge("foo");
    verify(view).getEdgeGroups();
    verify(schema).getEntity("foo");
    verify(view).getEntityGroups();
    verify(store).getSchema();
    verify(schema).getVisibilityProperty();
    verify(schema).isAggregationEnabled();
    verify(schemaEntityDefinition).containsProperty("Visibility Property");
  }

  /**
   * Test {@link AbstractCoreKeyIteratorSettingsFactory#queryTimeAggregatorRequired(View,
   * AccumuloStore)}.
   *
   * <p>Method under test: {@link
   * AbstractCoreKeyIteratorSettingsFactory#queryTimeAggregatorRequired(View, AccumuloStore)}
   */
  @Test
  @DisplayName("Test queryTimeAggregatorRequired(View, AccumuloStore)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AbstractCoreKeyIteratorSettingsFactory.queryTimeAggregatorRequired(View, AccumuloStore)"
  })
  void testQueryTimeAggregatorRequired8() {
    // Arrange
    ByteEntityIteratorSettingsFactory byteEntityIteratorSettingsFactory =
        new ByteEntityIteratorSettingsFactory();

    HashSet<String> stringSet = new HashSet<>();
    stringSet.add("foo");

    NamedView view = mock(NamedView.class);
    when(view.getEdgeGroups()).thenReturn(stringSet);

    SchemaEdgeDefinition schemaEdgeDefinition = mock(SchemaEdgeDefinition.class);
    when(schemaEdgeDefinition.containsProperty(Mockito.<String>any())).thenReturn(true);

    Schema schema = mock(Schema.class);
    when(schema.getEdge(Mockito.<String>any())).thenReturn(schemaEdgeDefinition);
    when(schema.getVisibilityProperty()).thenReturn("Visibility Property");
    when(schema.isAggregationEnabled()).thenReturn(true);

    AccumuloStore store = mock(AccumuloStore.class);
    when(store.getSchema()).thenReturn(schema);

    // Act
    boolean actualQueryTimeAggregatorRequiredResult =
        byteEntityIteratorSettingsFactory.queryTimeAggregatorRequired(view, store);

    // Assert
    verify(schema).getEdge("foo");
    verify(view).getEdgeGroups();
    verify(store).getSchema();
    verify(schema).getVisibilityProperty();
    verify(schema).isAggregationEnabled();
    verify(schemaEdgeDefinition).containsProperty("Visibility Property");
    assertTrue(actualQueryTimeAggregatorRequiredResult);
  }

  /**
   * Test {@link AbstractCoreKeyIteratorSettingsFactory#queryTimeAggregatorRequired(View,
   * AccumuloStore)}.
   *
   * <p>Method under test: {@link
   * AbstractCoreKeyIteratorSettingsFactory#queryTimeAggregatorRequired(View, AccumuloStore)}
   */
  @Test
  @DisplayName("Test queryTimeAggregatorRequired(View, AccumuloStore)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AbstractCoreKeyIteratorSettingsFactory.queryTimeAggregatorRequired(View, AccumuloStore)"
  })
  void testQueryTimeAggregatorRequired9() {
    // Arrange
    ByteEntityIteratorSettingsFactory byteEntityIteratorSettingsFactory =
        new ByteEntityIteratorSettingsFactory();

    HashSet<String> stringSet = new HashSet<>();
    stringSet.add("foo");

    NamedView view = mock(NamedView.class);
    when(view.getEdgeGroups()).thenReturn(stringSet);

    SchemaEdgeDefinition schemaEdgeDefinition = mock(SchemaEdgeDefinition.class);
    when(schemaEdgeDefinition.containsProperty(Mockito.<String>any()))
        .thenThrow(new IllegalArgumentException());

    Schema schema = mock(Schema.class);
    when(schema.getEdge(Mockito.<String>any())).thenReturn(schemaEdgeDefinition);
    when(schema.getVisibilityProperty()).thenReturn("Visibility Property");
    when(schema.isAggregationEnabled()).thenReturn(true);

    AccumuloStore store = mock(AccumuloStore.class);
    when(store.getSchema()).thenReturn(schema);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> byteEntityIteratorSettingsFactory.queryTimeAggregatorRequired(view, store));
    verify(schema).getEdge("foo");
    verify(view).getEdgeGroups();
    verify(store).getSchema();
    verify(schema).getVisibilityProperty();
    verify(schema).isAggregationEnabled();
    verify(schemaEdgeDefinition).containsProperty("Visibility Property");
  }

  /**
   * Test {@link AbstractCoreKeyIteratorSettingsFactory#queryTimeAggregatorRequired(View,
   * AccumuloStore)}.
   *
   * <p>Method under test: {@link
   * AbstractCoreKeyIteratorSettingsFactory#queryTimeAggregatorRequired(View, AccumuloStore)}
   */
  @Test
  @DisplayName("Test queryTimeAggregatorRequired(View, AccumuloStore)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AbstractCoreKeyIteratorSettingsFactory.queryTimeAggregatorRequired(View, AccumuloStore)"
  })
  void testQueryTimeAggregatorRequired10() {
    // Arrange
    ByteEntityIteratorSettingsFactory byteEntityIteratorSettingsFactory =
        new ByteEntityIteratorSettingsFactory();

    HashSet<String> stringSet = new HashSet<>();
    stringSet.add("foo");

    HashSet<String> stringSet2 = new HashSet<>();
    stringSet2.add("foo");

    GlobalViewElementDefinition globalViewElementDefinition =
        mock(GlobalViewElementDefinition.class);
    when(globalViewElementDefinition.getGroupBy()).thenReturn(new HashSet<>());
    doNothing().when(globalViewElementDefinition).setGroupBy(Mockito.<LinkedHashSet<String>>any());
    globalViewElementDefinition.setGroupBy(null);

    NamedView view = mock(NamedView.class);
    when(view.getEdge(Mockito.<String>any())).thenReturn(globalViewElementDefinition);
    when(view.getEdgeGroups()).thenReturn(stringSet);
    when(view.getEntityGroups()).thenReturn(stringSet2);

    SchemaEdgeDefinition schemaEdgeDefinition = mock(SchemaEdgeDefinition.class);
    when(schemaEdgeDefinition.getGroupBy()).thenReturn(new HashSet<>());
    when(schemaEdgeDefinition.containsProperty(Mockito.<String>any())).thenReturn(false);

    SchemaEntityDefinition schemaEntityDefinition = mock(SchemaEntityDefinition.class);
    when(schemaEntityDefinition.containsProperty(Mockito.<String>any())).thenReturn(true);

    Schema schema = mock(Schema.class);
    when(schema.getEntity(Mockito.<String>any())).thenReturn(schemaEntityDefinition);
    when(schema.getEdge(Mockito.<String>any())).thenReturn(schemaEdgeDefinition);
    when(schema.getVisibilityProperty()).thenReturn("Visibility Property");
    when(schema.isAggregationEnabled()).thenReturn(true);

    AccumuloStore store = mock(AccumuloStore.class);
    when(store.getSchema()).thenReturn(schema);

    // Act
    boolean actualQueryTimeAggregatorRequiredResult =
        byteEntityIteratorSettingsFactory.queryTimeAggregatorRequired(view, store);

    // Assert
    verify(view).getEdge("foo");
    verify(schema).getEdge("foo");
    verify(view).getEdgeGroups();
    verify(schema).getEntity("foo");
    verify(view).getEntityGroups();
    verify(globalViewElementDefinition, atLeast(1)).getGroupBy();
    verify(globalViewElementDefinition).setGroupBy(isNull());
    verify(store).getSchema();
    verify(schema).getVisibilityProperty();
    verify(schema).isAggregationEnabled();
    verify(schemaEdgeDefinition).containsProperty("Visibility Property");
    verify(schemaEntityDefinition).containsProperty("Visibility Property");
    verify(schemaEdgeDefinition).getGroupBy();
    assertTrue(actualQueryTimeAggregatorRequiredResult);
  }

  /**
   * Test {@link AbstractCoreKeyIteratorSettingsFactory#queryTimeAggregatorRequired(View,
   * AccumuloStore)}.
   *
   * <p>Method under test: {@link
   * AbstractCoreKeyIteratorSettingsFactory#queryTimeAggregatorRequired(View, AccumuloStore)}
   */
  @Test
  @DisplayName("Test queryTimeAggregatorRequired(View, AccumuloStore)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AbstractCoreKeyIteratorSettingsFactory.queryTimeAggregatorRequired(View, AccumuloStore)"
  })
  void testQueryTimeAggregatorRequired11() {
    // Arrange
    ByteEntityIteratorSettingsFactory byteEntityIteratorSettingsFactory =
        new ByteEntityIteratorSettingsFactory();

    HashSet<String> stringSet = new HashSet<>();
    stringSet.add("foo");

    GlobalViewElementDefinition globalViewElementDefinition =
        mock(GlobalViewElementDefinition.class);
    when(globalViewElementDefinition.getGroupBy()).thenReturn(new HashSet<>());
    doNothing().when(globalViewElementDefinition).setGroupBy(Mockito.<LinkedHashSet<String>>any());
    globalViewElementDefinition.setGroupBy(null);

    NamedView view = mock(NamedView.class);
    when(view.getEdge(Mockito.<String>any())).thenReturn(globalViewElementDefinition);
    when(view.getEdgeGroups()).thenReturn(stringSet);

    SchemaEdgeDefinition schemaEdgeDefinition = mock(SchemaEdgeDefinition.class);
    when(schemaEdgeDefinition.getGroupBy()).thenThrow(new IllegalArgumentException());
    when(schemaEdgeDefinition.containsProperty(Mockito.<String>any())).thenReturn(false);

    Schema schema = mock(Schema.class);
    when(schema.getEdge(Mockito.<String>any())).thenReturn(schemaEdgeDefinition);
    when(schema.getVisibilityProperty()).thenReturn("Visibility Property");
    when(schema.isAggregationEnabled()).thenReturn(true);

    AccumuloStore store = mock(AccumuloStore.class);
    when(store.getSchema()).thenReturn(schema);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> byteEntityIteratorSettingsFactory.queryTimeAggregatorRequired(view, store));
    verify(view).getEdge("foo");
    verify(schema).getEdge("foo");
    verify(view).getEdgeGroups();
    verify(globalViewElementDefinition).getGroupBy();
    verify(globalViewElementDefinition).setGroupBy(isNull());
    verify(store).getSchema();
    verify(schema).getVisibilityProperty();
    verify(schema).isAggregationEnabled();
    verify(schemaEdgeDefinition).containsProperty("Visibility Property");
    verify(schemaEdgeDefinition).getGroupBy();
  }

  /**
   * Test {@link AbstractCoreKeyIteratorSettingsFactory#queryTimeAggregatorRequired(View,
   * AccumuloStore)}.
   *
   * <p>Method under test: {@link
   * AbstractCoreKeyIteratorSettingsFactory#queryTimeAggregatorRequired(View, AccumuloStore)}
   */
  @Test
  @DisplayName("Test queryTimeAggregatorRequired(View, AccumuloStore)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AbstractCoreKeyIteratorSettingsFactory.queryTimeAggregatorRequired(View, AccumuloStore)"
  })
  void testQueryTimeAggregatorRequired12() {
    // Arrange
    ByteEntityIteratorSettingsFactory byteEntityIteratorSettingsFactory =
        new ByteEntityIteratorSettingsFactory();

    HashSet<String> stringSet = new HashSet<>();
    stringSet.add("foo");

    HashSet<String> stringSet2 = new HashSet<>();
    stringSet2.add("foo");

    GlobalViewElementDefinition globalViewElementDefinition =
        mock(GlobalViewElementDefinition.class);
    when(globalViewElementDefinition.getGroupBy()).thenReturn(new HashSet<>());
    doNothing().when(globalViewElementDefinition).setGroupBy(Mockito.<LinkedHashSet<String>>any());
    globalViewElementDefinition.setGroupBy(null);

    GlobalViewElementDefinition globalViewElementDefinition2 =
        mock(GlobalViewElementDefinition.class);
    when(globalViewElementDefinition2.getGroupBy()).thenReturn(new HashSet<>());
    doNothing().when(globalViewElementDefinition2).setGroupBy(Mockito.<LinkedHashSet<String>>any());
    globalViewElementDefinition2.setGroupBy(null);

    NamedView view = mock(NamedView.class);
    when(view.getElement(Mockito.<String>any())).thenReturn(globalViewElementDefinition2);
    when(view.getEdge(Mockito.<String>any())).thenReturn(globalViewElementDefinition);
    when(view.getEdgeGroups()).thenReturn(stringSet);
    when(view.getEntityGroups()).thenReturn(stringSet2);

    SchemaEdgeDefinition schemaEdgeDefinition = mock(SchemaEdgeDefinition.class);
    when(schemaEdgeDefinition.getGroupBy()).thenReturn(new HashSet<>());
    when(schemaEdgeDefinition.containsProperty(Mockito.<String>any())).thenReturn(false);

    SchemaEntityDefinition schemaEntityDefinition = mock(SchemaEntityDefinition.class);
    when(schemaEntityDefinition.getGroupBy()).thenReturn(new HashSet<>());
    when(schemaEntityDefinition.containsProperty(Mockito.<String>any())).thenReturn(false);

    Schema schema = mock(Schema.class);
    when(schema.getEntity(Mockito.<String>any())).thenReturn(schemaEntityDefinition);
    when(schema.getEdge(Mockito.<String>any())).thenReturn(schemaEdgeDefinition);
    when(schema.getVisibilityProperty()).thenReturn("Visibility Property");
    when(schema.isAggregationEnabled()).thenReturn(true);

    AccumuloStore store = mock(AccumuloStore.class);
    when(store.getSchema()).thenReturn(schema);

    // Act
    boolean actualQueryTimeAggregatorRequiredResult =
        byteEntityIteratorSettingsFactory.queryTimeAggregatorRequired(view, store);

    // Assert
    verify(view).getEdge("foo");
    verify(schema).getEdge("foo");
    verify(view).getEdgeGroups();
    verify(schema).getEntity("foo");
    verify(view).getEntityGroups();
    verify(view).getElement("foo");
    verify(globalViewElementDefinition2, atLeast(1)).getGroupBy();
    verify(globalViewElementDefinition, atLeast(1)).getGroupBy();
    verify(globalViewElementDefinition2).setGroupBy(isNull());
    verify(globalViewElementDefinition).setGroupBy(isNull());
    verify(store).getSchema();
    verify(schema).getVisibilityProperty();
    verify(schema).isAggregationEnabled();
    verify(schemaEdgeDefinition).containsProperty("Visibility Property");
    verify(schemaEntityDefinition).containsProperty("Visibility Property");
    verify(schemaEdgeDefinition).getGroupBy();
    verify(schemaEntityDefinition).getGroupBy();
    assertFalse(actualQueryTimeAggregatorRequiredResult);
  }

  /**
   * Test {@link AbstractCoreKeyIteratorSettingsFactory#queryTimeAggregatorRequired(View,
   * AccumuloStore)}.
   *
   * <p>Method under test: {@link
   * AbstractCoreKeyIteratorSettingsFactory#queryTimeAggregatorRequired(View, AccumuloStore)}
   */
  @Test
  @DisplayName("Test queryTimeAggregatorRequired(View, AccumuloStore)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AbstractCoreKeyIteratorSettingsFactory.queryTimeAggregatorRequired(View, AccumuloStore)"
  })
  void testQueryTimeAggregatorRequired13() {
    // Arrange
    ByteEntityIteratorSettingsFactory byteEntityIteratorSettingsFactory =
        new ByteEntityIteratorSettingsFactory();

    HashSet<String> stringSet = new HashSet<>();
    stringSet.add("foo");

    HashSet<String> stringSet2 = new HashSet<>();
    stringSet2.add("foo");

    GlobalViewElementDefinition globalViewElementDefinition =
        mock(GlobalViewElementDefinition.class);
    when(globalViewElementDefinition.getGroupBy()).thenReturn(new HashSet<>());
    doNothing().when(globalViewElementDefinition).setGroupBy(Mockito.<LinkedHashSet<String>>any());
    globalViewElementDefinition.setGroupBy(null);

    GlobalViewElementDefinition globalViewElementDefinition2 =
        mock(GlobalViewElementDefinition.class);
    when(globalViewElementDefinition2.getGroupBy()).thenReturn(new HashSet<>());
    doNothing().when(globalViewElementDefinition2).setGroupBy(Mockito.<LinkedHashSet<String>>any());
    globalViewElementDefinition2.setGroupBy(null);

    NamedView view = mock(NamedView.class);
    when(view.getElement(Mockito.<String>any())).thenReturn(globalViewElementDefinition2);
    when(view.getEdge(Mockito.<String>any())).thenReturn(globalViewElementDefinition);
    when(view.getEdgeGroups()).thenReturn(stringSet);
    when(view.getEntityGroups()).thenReturn(stringSet2);

    SchemaEdgeDefinition schemaEdgeDefinition = mock(SchemaEdgeDefinition.class);
    when(schemaEdgeDefinition.getGroupBy()).thenReturn(new HashSet<>());
    when(schemaEdgeDefinition.containsProperty(Mockito.<String>any())).thenReturn(false);

    SchemaEntityDefinition schemaEntityDefinition = mock(SchemaEntityDefinition.class);
    when(schemaEntityDefinition.getGroupBy()).thenThrow(new IllegalArgumentException());
    when(schemaEntityDefinition.containsProperty(Mockito.<String>any())).thenReturn(false);

    Schema schema = mock(Schema.class);
    when(schema.getEntity(Mockito.<String>any())).thenReturn(schemaEntityDefinition);
    when(schema.getEdge(Mockito.<String>any())).thenReturn(schemaEdgeDefinition);
    when(schema.getVisibilityProperty()).thenReturn("Visibility Property");
    when(schema.isAggregationEnabled()).thenReturn(true);

    AccumuloStore store = mock(AccumuloStore.class);
    when(store.getSchema()).thenReturn(schema);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> byteEntityIteratorSettingsFactory.queryTimeAggregatorRequired(view, store));
    verify(view).getEdge("foo");
    verify(schema).getEdge("foo");
    verify(view).getEdgeGroups();
    verify(schema).getEntity("foo");
    verify(view).getEntityGroups();
    verify(view).getElement("foo");
    verify(globalViewElementDefinition2).getGroupBy();
    verify(globalViewElementDefinition, atLeast(1)).getGroupBy();
    verify(globalViewElementDefinition2).setGroupBy(isNull());
    verify(globalViewElementDefinition).setGroupBy(isNull());
    verify(store).getSchema();
    verify(schema).getVisibilityProperty();
    verify(schema).isAggregationEnabled();
    verify(schemaEdgeDefinition).containsProperty("Visibility Property");
    verify(schemaEntityDefinition).containsProperty("Visibility Property");
    verify(schemaEdgeDefinition).getGroupBy();
    verify(schemaEntityDefinition).getGroupBy();
  }

  /**
   * Test {@link AbstractCoreKeyIteratorSettingsFactory#queryTimeAggregatorRequired(View,
   * AccumuloStore)}.
   *
   * <p>Method under test: {@link
   * AbstractCoreKeyIteratorSettingsFactory#queryTimeAggregatorRequired(View, AccumuloStore)}
   */
  @Test
  @DisplayName("Test queryTimeAggregatorRequired(View, AccumuloStore)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AbstractCoreKeyIteratorSettingsFactory.queryTimeAggregatorRequired(View, AccumuloStore)"
  })
  void testQueryTimeAggregatorRequired14() {
    // Arrange
    ByteEntityIteratorSettingsFactory byteEntityIteratorSettingsFactory =
        new ByteEntityIteratorSettingsFactory();

    HashSet<String> stringSet = new HashSet<>();
    stringSet.add("foo");

    HashSet<String> stringSet2 = new HashSet<>();
    stringSet2.add("foo");

    GlobalViewElementDefinition globalViewElementDefinition =
        mock(GlobalViewElementDefinition.class);
    when(globalViewElementDefinition.getGroupBy()).thenReturn(new HashSet<>());
    doNothing().when(globalViewElementDefinition).setGroupBy(Mockito.<LinkedHashSet<String>>any());
    globalViewElementDefinition.setGroupBy(null);

    HashSet<String> stringSet3 = new HashSet<>();
    stringSet3.add("foo");

    GlobalViewElementDefinition globalViewElementDefinition2 =
        mock(GlobalViewElementDefinition.class);
    when(globalViewElementDefinition2.getGroupBy()).thenReturn(stringSet3);
    doNothing().when(globalViewElementDefinition2).setGroupBy(Mockito.<LinkedHashSet<String>>any());
    globalViewElementDefinition2.setGroupBy(null);

    NamedView view = mock(NamedView.class);
    when(view.getElement(Mockito.<String>any())).thenReturn(globalViewElementDefinition2);
    when(view.getEdge(Mockito.<String>any())).thenReturn(globalViewElementDefinition);
    when(view.getEdgeGroups()).thenReturn(stringSet);
    when(view.getEntityGroups()).thenReturn(stringSet2);

    SchemaEdgeDefinition schemaEdgeDefinition = mock(SchemaEdgeDefinition.class);
    when(schemaEdgeDefinition.getGroupBy()).thenReturn(new HashSet<>());
    when(schemaEdgeDefinition.containsProperty(Mockito.<String>any())).thenReturn(false);

    SchemaEntityDefinition schemaEntityDefinition = mock(SchemaEntityDefinition.class);
    when(schemaEntityDefinition.getGroupBy()).thenReturn(new HashSet<>());
    when(schemaEntityDefinition.containsProperty(Mockito.<String>any())).thenReturn(false);

    Schema schema = mock(Schema.class);
    when(schema.getEntity(Mockito.<String>any())).thenReturn(schemaEntityDefinition);
    when(schema.getEdge(Mockito.<String>any())).thenReturn(schemaEdgeDefinition);
    when(schema.getVisibilityProperty()).thenReturn("Visibility Property");
    when(schema.isAggregationEnabled()).thenReturn(true);

    AccumuloStore store = mock(AccumuloStore.class);
    when(store.getSchema()).thenReturn(schema);

    // Act
    boolean actualQueryTimeAggregatorRequiredResult =
        byteEntityIteratorSettingsFactory.queryTimeAggregatorRequired(view, store);

    // Assert
    verify(view).getEdge("foo");
    verify(schema).getEdge("foo");
    verify(view).getEdgeGroups();
    verify(schema).getEntity("foo");
    verify(view).getEntityGroups();
    verify(view).getElement("foo");
    verify(globalViewElementDefinition2, atLeast(1)).getGroupBy();
    verify(globalViewElementDefinition, atLeast(1)).getGroupBy();
    verify(globalViewElementDefinition2).setGroupBy(isNull());
    verify(globalViewElementDefinition).setGroupBy(isNull());
    verify(store).getSchema();
    verify(schema).getVisibilityProperty();
    verify(schema).isAggregationEnabled();
    verify(schemaEdgeDefinition).containsProperty("Visibility Property");
    verify(schemaEntityDefinition).containsProperty("Visibility Property");
    verify(schemaEdgeDefinition).getGroupBy();
    verify(schemaEntityDefinition).getGroupBy();
    assertTrue(actualQueryTimeAggregatorRequiredResult);
  }

  /**
   * Test {@link AbstractCoreKeyIteratorSettingsFactory#queryTimeAggregatorRequired(View,
   * AccumuloStore)}.
   *
   * <ul>
   *   <li>Given {@link HashSet#HashSet()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AbstractCoreKeyIteratorSettingsFactory#queryTimeAggregatorRequired(View, AccumuloStore)}
   */
  @Test
  @DisplayName("Test queryTimeAggregatorRequired(View, AccumuloStore); given HashSet()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AbstractCoreKeyIteratorSettingsFactory.queryTimeAggregatorRequired(View, AccumuloStore)"
  })
  void testQueryTimeAggregatorRequired_givenHashSet() {
    // Arrange
    ByteEntityIteratorSettingsFactory byteEntityIteratorSettingsFactory =
        new ByteEntityIteratorSettingsFactory();

    HashSet<String> stringSet = new HashSet<>();
    stringSet.add("foo");

    ViewElementDefinition viewElementDefinition = new ViewElementDefinition();
    viewElementDefinition.setGroupBy(null);

    NamedView view = mock(NamedView.class);
    when(view.getEdge(Mockito.<String>any())).thenReturn(viewElementDefinition);
    when(view.getEdgeGroups()).thenReturn(stringSet);
    when(view.getEntityGroups()).thenReturn(new HashSet<>());

    Schema schema = mock(Schema.class);
    when(schema.getEdge(Mockito.<String>any())).thenReturn(new SchemaEdgeDefinition());
    when(schema.getVisibilityProperty()).thenReturn("Visibility Property");
    when(schema.isAggregationEnabled()).thenReturn(true);

    AccumuloStore store = mock(AccumuloStore.class);
    when(store.getSchema()).thenReturn(schema);

    // Act
    boolean actualQueryTimeAggregatorRequiredResult =
        byteEntityIteratorSettingsFactory.queryTimeAggregatorRequired(view, store);

    // Assert
    verify(view).getEdge("foo");
    verify(schema).getEdge("foo");
    verify(view).getEdgeGroups();
    verify(view).getEntityGroups();
    verify(store).getSchema();
    verify(schema).getVisibilityProperty();
    verify(schema).isAggregationEnabled();
    assertFalse(actualQueryTimeAggregatorRequiredResult);
  }

  /**
   * Test {@link AbstractCoreKeyIteratorSettingsFactory#queryTimeAggregatorRequired(View,
   * AccumuloStore)}.
   *
   * <ul>
   *   <li>Given {@link HashSet#HashSet()}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AbstractCoreKeyIteratorSettingsFactory#queryTimeAggregatorRequired(View, AccumuloStore)}
   */
  @Test
  @DisplayName(
      "Test queryTimeAggregatorRequired(View, AccumuloStore); given HashSet(); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AbstractCoreKeyIteratorSettingsFactory.queryTimeAggregatorRequired(View, AccumuloStore)"
  })
  void testQueryTimeAggregatorRequired_givenHashSet_thenReturnFalse() {
    // Arrange
    ByteEntityIteratorSettingsFactory byteEntityIteratorSettingsFactory =
        new ByteEntityIteratorSettingsFactory();

    NamedView view = mock(NamedView.class);
    when(view.getEdgeGroups()).thenReturn(new HashSet<>());
    when(view.getEntityGroups()).thenReturn(new HashSet<>());

    Schema schema = mock(Schema.class);
    when(schema.getVisibilityProperty()).thenReturn("Visibility Property");
    when(schema.isAggregationEnabled()).thenReturn(true);

    AccumuloStore store = mock(AccumuloStore.class);
    when(store.getSchema()).thenReturn(schema);

    // Act
    boolean actualQueryTimeAggregatorRequiredResult =
        byteEntityIteratorSettingsFactory.queryTimeAggregatorRequired(view, store);

    // Assert
    verify(view).getEdgeGroups();
    verify(view).getEntityGroups();
    verify(store).getSchema();
    verify(schema).getVisibilityProperty();
    verify(schema).isAggregationEnabled();
    assertFalse(actualQueryTimeAggregatorRequiredResult);
  }

  /**
   * Test {@link AbstractCoreKeyIteratorSettingsFactory#queryTimeAggregatorRequired(View,
   * AccumuloStore)}.
   *
   * <ul>
   *   <li>Given {@link Schema#Schema()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AbstractCoreKeyIteratorSettingsFactory#queryTimeAggregatorRequired(View, AccumuloStore)}
   */
  @Test
  @DisplayName("Test queryTimeAggregatorRequired(View, AccumuloStore); given Schema()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AbstractCoreKeyIteratorSettingsFactory.queryTimeAggregatorRequired(View, AccumuloStore)"
  })
  void testQueryTimeAggregatorRequired_givenSchema() {
    // Arrange
    ByteEntityIteratorSettingsFactory byteEntityIteratorSettingsFactory =
        new ByteEntityIteratorSettingsFactory();
    View view = new View();

    AccumuloStore store = mock(AccumuloStore.class);
    when(store.getSchema()).thenReturn(new Schema());

    // Act
    boolean actualQueryTimeAggregatorRequiredResult =
        byteEntityIteratorSettingsFactory.queryTimeAggregatorRequired(view, store);

    // Assert
    verify(store).getSchema();
    assertFalse(actualQueryTimeAggregatorRequiredResult);
  }

  /**
   * Test {@link AbstractCoreKeyIteratorSettingsFactory#queryTimeAggregatorRequired(View,
   * AccumuloStore)}.
   *
   * <ul>
   *   <li>Given {@link SchemaEdgeDefinition} {@link SchemaEdgeDefinition#getGroupBy()} return
   *       {@link HashSet#HashSet()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AbstractCoreKeyIteratorSettingsFactory#queryTimeAggregatorRequired(View, AccumuloStore)}
   */
  @Test
  @DisplayName(
      "Test queryTimeAggregatorRequired(View, AccumuloStore); given SchemaEdgeDefinition getGroupBy() return HashSet()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AbstractCoreKeyIteratorSettingsFactory.queryTimeAggregatorRequired(View, AccumuloStore)"
  })
  void testQueryTimeAggregatorRequired_givenSchemaEdgeDefinitionGetGroupByReturnHashSet() {
    // Arrange
    ByteEntityIteratorSettingsFactory byteEntityIteratorSettingsFactory =
        new ByteEntityIteratorSettingsFactory();

    HashSet<String> stringSet = new HashSet<>();
    stringSet.add("foo");

    HashSet<String> stringSet2 = new HashSet<>();
    stringSet2.add("foo");

    GlobalViewElementDefinition globalViewElementDefinition =
        mock(GlobalViewElementDefinition.class);
    when(globalViewElementDefinition.getGroupBy()).thenReturn(stringSet2);
    doNothing().when(globalViewElementDefinition).setGroupBy(Mockito.<LinkedHashSet<String>>any());
    globalViewElementDefinition.setGroupBy(null);

    NamedView view = mock(NamedView.class);
    when(view.getEdge(Mockito.<String>any())).thenReturn(globalViewElementDefinition);
    when(view.getEdgeGroups()).thenReturn(stringSet);

    SchemaEdgeDefinition schemaEdgeDefinition = mock(SchemaEdgeDefinition.class);
    when(schemaEdgeDefinition.getGroupBy()).thenReturn(new HashSet<>());
    when(schemaEdgeDefinition.containsProperty(Mockito.<String>any())).thenReturn(false);

    Schema schema = mock(Schema.class);
    when(schema.getEdge(Mockito.<String>any())).thenReturn(schemaEdgeDefinition);
    when(schema.getVisibilityProperty()).thenReturn("Visibility Property");
    when(schema.isAggregationEnabled()).thenReturn(true);

    AccumuloStore store = mock(AccumuloStore.class);
    when(store.getSchema()).thenReturn(schema);

    // Act
    boolean actualQueryTimeAggregatorRequiredResult =
        byteEntityIteratorSettingsFactory.queryTimeAggregatorRequired(view, store);

    // Assert
    verify(view).getEdge("foo");
    verify(schema).getEdge("foo");
    verify(view).getEdgeGroups();
    verify(globalViewElementDefinition, atLeast(1)).getGroupBy();
    verify(globalViewElementDefinition).setGroupBy(isNull());
    verify(store).getSchema();
    verify(schema).getVisibilityProperty();
    verify(schema).isAggregationEnabled();
    verify(schemaEdgeDefinition).containsProperty("Visibility Property");
    verify(schemaEdgeDefinition).getGroupBy();
    assertTrue(actualQueryTimeAggregatorRequiredResult);
  }

  /**
   * Test {@link AbstractCoreKeyIteratorSettingsFactory#queryTimeAggregatorRequired(View,
   * AccumuloStore)}.
   *
   * <ul>
   *   <li>Given {@link Schema} {@link Schema#getEdge(String)} return {@code null}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AbstractCoreKeyIteratorSettingsFactory#queryTimeAggregatorRequired(View, AccumuloStore)}
   */
  @Test
  @DisplayName(
      "Test queryTimeAggregatorRequired(View, AccumuloStore); given Schema getEdge(String) return 'null'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AbstractCoreKeyIteratorSettingsFactory.queryTimeAggregatorRequired(View, AccumuloStore)"
  })
  void testQueryTimeAggregatorRequired_givenSchemaGetEdgeReturnNull_thenReturnTrue() {
    // Arrange
    ByteEntityIteratorSettingsFactory byteEntityIteratorSettingsFactory =
        new ByteEntityIteratorSettingsFactory();

    HashSet<String> stringSet = new HashSet<>();
    stringSet.add("foo");

    HashSet<String> stringSet2 = new HashSet<>();
    stringSet2.add("foo");

    NamedView view = mock(NamedView.class);
    when(view.getEdgeGroups()).thenReturn(stringSet);
    when(view.getEntityGroups()).thenReturn(stringSet2);

    SchemaEntityDefinition schemaEntityDefinition = mock(SchemaEntityDefinition.class);
    when(schemaEntityDefinition.containsProperty(Mockito.<String>any())).thenReturn(true);

    Schema schema = mock(Schema.class);
    when(schema.getEntity(Mockito.<String>any())).thenReturn(schemaEntityDefinition);
    when(schema.getEdge(Mockito.<String>any())).thenReturn(null);
    when(schema.getVisibilityProperty()).thenReturn("Visibility Property");
    when(schema.isAggregationEnabled()).thenReturn(true);

    AccumuloStore store = mock(AccumuloStore.class);
    when(store.getSchema()).thenReturn(schema);

    // Act
    boolean actualQueryTimeAggregatorRequiredResult =
        byteEntityIteratorSettingsFactory.queryTimeAggregatorRequired(view, store);

    // Assert
    verify(schema).getEdge("foo");
    verify(view).getEdgeGroups();
    verify(schema).getEntity("foo");
    verify(view).getEntityGroups();
    verify(store).getSchema();
    verify(schema).getVisibilityProperty();
    verify(schema).isAggregationEnabled();
    verify(schemaEntityDefinition).containsProperty("Visibility Property");
    assertTrue(actualQueryTimeAggregatorRequiredResult);
  }

  /**
   * Test {@link AbstractCoreKeyIteratorSettingsFactory#queryTimeAggregatorRequired(View,
   * AccumuloStore)}.
   *
   * <ul>
   *   <li>Given {@link Schema} {@link Schema#getEdge(String)} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AbstractCoreKeyIteratorSettingsFactory#queryTimeAggregatorRequired(View, AccumuloStore)}
   */
  @Test
  @DisplayName(
      "Test queryTimeAggregatorRequired(View, AccumuloStore); given Schema getEdge(String) throw IllegalArgumentException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AbstractCoreKeyIteratorSettingsFactory.queryTimeAggregatorRequired(View, AccumuloStore)"
  })
  void testQueryTimeAggregatorRequired_givenSchemaGetEdgeThrowIllegalArgumentException() {
    // Arrange
    ByteEntityIteratorSettingsFactory byteEntityIteratorSettingsFactory =
        new ByteEntityIteratorSettingsFactory();

    HashSet<String> stringSet = new HashSet<>();
    stringSet.add("foo");

    NamedView view = mock(NamedView.class);
    when(view.getEdgeGroups()).thenReturn(stringSet);

    Schema schema = mock(Schema.class);
    when(schema.getEdge(Mockito.<String>any())).thenThrow(new IllegalArgumentException());
    when(schema.getVisibilityProperty()).thenReturn("Visibility Property");
    when(schema.isAggregationEnabled()).thenReturn(true);

    AccumuloStore store = mock(AccumuloStore.class);
    when(store.getSchema()).thenReturn(schema);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> byteEntityIteratorSettingsFactory.queryTimeAggregatorRequired(view, store));
    verify(schema).getEdge("foo");
    verify(view).getEdgeGroups();
    verify(store).getSchema();
    verify(schema).getVisibilityProperty();
    verify(schema).isAggregationEnabled();
  }

  /**
   * Test {@link AbstractCoreKeyIteratorSettingsFactory#queryTimeAggregatorRequired(View,
   * AccumuloStore)}.
   *
   * <ul>
   *   <li>Given {@link Schema} {@link Schema#getEntity(String)} return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AbstractCoreKeyIteratorSettingsFactory#queryTimeAggregatorRequired(View, AccumuloStore)}
   */
  @Test
  @DisplayName(
      "Test queryTimeAggregatorRequired(View, AccumuloStore); given Schema getEntity(String) return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AbstractCoreKeyIteratorSettingsFactory.queryTimeAggregatorRequired(View, AccumuloStore)"
  })
  void testQueryTimeAggregatorRequired_givenSchemaGetEntityReturnNull() {
    // Arrange
    ByteEntityIteratorSettingsFactory byteEntityIteratorSettingsFactory =
        new ByteEntityIteratorSettingsFactory();

    HashSet<String> stringSet = new HashSet<>();
    stringSet.add("foo");

    HashSet<String> stringSet2 = new HashSet<>();
    stringSet2.add("foo");

    ViewElementDefinition viewElementDefinition = new ViewElementDefinition();
    viewElementDefinition.setGroupBy(null);

    NamedView view = mock(NamedView.class);
    when(view.getEdge(Mockito.<String>any())).thenReturn(viewElementDefinition);
    when(view.getEdgeGroups()).thenReturn(stringSet);
    when(view.getEntityGroups()).thenReturn(stringSet2);

    Schema schema = mock(Schema.class);
    when(schema.getEntity(Mockito.<String>any())).thenReturn(null);
    when(schema.getEdge(Mockito.<String>any())).thenReturn(new SchemaEdgeDefinition());
    when(schema.getVisibilityProperty()).thenReturn("Visibility Property");
    when(schema.isAggregationEnabled()).thenReturn(true);

    AccumuloStore store = mock(AccumuloStore.class);
    when(store.getSchema()).thenReturn(schema);

    // Act
    boolean actualQueryTimeAggregatorRequiredResult =
        byteEntityIteratorSettingsFactory.queryTimeAggregatorRequired(view, store);

    // Assert
    verify(view).getEdge("foo");
    verify(schema).getEdge("foo");
    verify(view).getEdgeGroups();
    verify(schema).getEntity("foo");
    verify(view).getEntityGroups();
    verify(store).getSchema();
    verify(schema).getVisibilityProperty();
    verify(schema).isAggregationEnabled();
    assertFalse(actualQueryTimeAggregatorRequiredResult);
  }

  /**
   * Test {@link AbstractCoreKeyIteratorSettingsFactory#queryTimeAggregatorRequired(View,
   * AccumuloStore)}.
   *
   * <ul>
   *   <li>Given {@link Schema} {@link Schema#isAggregationEnabled()} return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AbstractCoreKeyIteratorSettingsFactory#queryTimeAggregatorRequired(View, AccumuloStore)}
   */
  @Test
  @DisplayName(
      "Test queryTimeAggregatorRequired(View, AccumuloStore); given Schema isAggregationEnabled() return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AbstractCoreKeyIteratorSettingsFactory.queryTimeAggregatorRequired(View, AccumuloStore)"
  })
  void testQueryTimeAggregatorRequired_givenSchemaIsAggregationEnabledReturnFalse() {
    // Arrange
    ByteEntityIteratorSettingsFactory byteEntityIteratorSettingsFactory =
        new ByteEntityIteratorSettingsFactory();
    View view = new View();

    Schema schema = mock(Schema.class);
    when(schema.isAggregationEnabled()).thenReturn(false);

    AccumuloStore store = mock(AccumuloStore.class);
    when(store.getSchema()).thenReturn(schema);

    // Act
    boolean actualQueryTimeAggregatorRequiredResult =
        byteEntityIteratorSettingsFactory.queryTimeAggregatorRequired(view, store);

    // Assert
    verify(store).getSchema();
    verify(schema).isAggregationEnabled();
    assertFalse(actualQueryTimeAggregatorRequiredResult);
  }

  /**
   * Test {@link AbstractCoreKeyIteratorSettingsFactory#queryTimeAggregatorRequired(View,
   * AccumuloStore)}.
   *
   * <ul>
   *   <li>Given {@link ViewElementDefinition} (default constructor) GroupBy is {@link
   *       LinkedHashSet#LinkedHashSet()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AbstractCoreKeyIteratorSettingsFactory#queryTimeAggregatorRequired(View, AccumuloStore)}
   */
  @Test
  @DisplayName(
      "Test queryTimeAggregatorRequired(View, AccumuloStore); given ViewElementDefinition (default constructor) GroupBy is LinkedHashSet()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AbstractCoreKeyIteratorSettingsFactory.queryTimeAggregatorRequired(View, AccumuloStore)"
  })
  void testQueryTimeAggregatorRequired_givenViewElementDefinitionGroupByIsLinkedHashSet() {
    // Arrange
    ByteEntityIteratorSettingsFactory byteEntityIteratorSettingsFactory =
        new ByteEntityIteratorSettingsFactory();

    HashSet<String> stringSet = new HashSet<>();
    stringSet.add("foo");

    ViewElementDefinition viewElementDefinition = new ViewElementDefinition();
    viewElementDefinition.setGroupBy(new LinkedHashSet<>());

    NamedView view = mock(NamedView.class);
    when(view.getEdge(Mockito.<String>any())).thenReturn(viewElementDefinition);
    when(view.getEdgeGroups()).thenReturn(stringSet);
    when(view.getEntityGroups()).thenReturn(new HashSet<>());

    Schema schema = mock(Schema.class);
    when(schema.getEdge(Mockito.<String>any())).thenReturn(new SchemaEdgeDefinition());
    when(schema.getVisibilityProperty()).thenReturn("Visibility Property");
    when(schema.isAggregationEnabled()).thenReturn(true);

    AccumuloStore store = mock(AccumuloStore.class);
    when(store.getSchema()).thenReturn(schema);

    // Act
    boolean actualQueryTimeAggregatorRequiredResult =
        byteEntityIteratorSettingsFactory.queryTimeAggregatorRequired(view, store);

    // Assert
    verify(view).getEdge("foo");
    verify(schema).getEdge("foo");
    verify(view).getEdgeGroups();
    verify(view).getEntityGroups();
    verify(store).getSchema();
    verify(schema).getVisibilityProperty();
    verify(schema).isAggregationEnabled();
    assertFalse(actualQueryTimeAggregatorRequiredResult);
  }

  /**
   * Test {@link AbstractCoreKeyIteratorSettingsFactory#queryTimeAggregatorRequired(View,
   * AccumuloStore)}.
   *
   * <ul>
   *   <li>Given {@link ViewElementDefinition} (default constructor) GroupBy is {@link
   *       LinkedHashSet#LinkedHashSet()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AbstractCoreKeyIteratorSettingsFactory#queryTimeAggregatorRequired(View, AccumuloStore)}
   */
  @Test
  @DisplayName(
      "Test queryTimeAggregatorRequired(View, AccumuloStore); given ViewElementDefinition (default constructor) GroupBy is LinkedHashSet()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AbstractCoreKeyIteratorSettingsFactory.queryTimeAggregatorRequired(View, AccumuloStore)"
  })
  void testQueryTimeAggregatorRequired_givenViewElementDefinitionGroupByIsLinkedHashSet2() {
    // Arrange
    ByteEntityIteratorSettingsFactory byteEntityIteratorSettingsFactory =
        new ByteEntityIteratorSettingsFactory();

    HashSet<String> stringSet = new HashSet<>();
    stringSet.add("foo");

    HashSet<String> stringSet2 = new HashSet<>();
    stringSet2.add("foo");

    ViewElementDefinition viewElementDefinition = new ViewElementDefinition();
    viewElementDefinition.setGroupBy(null);

    ViewElementDefinition viewElementDefinition2 = new ViewElementDefinition();
    viewElementDefinition2.setGroupBy(new LinkedHashSet<>());

    NamedView view = mock(NamedView.class);
    when(view.getElement(Mockito.<String>any())).thenReturn(viewElementDefinition2);
    when(view.getEdge(Mockito.<String>any())).thenReturn(viewElementDefinition);
    when(view.getEdgeGroups()).thenReturn(stringSet);
    when(view.getEntityGroups()).thenReturn(stringSet2);

    Schema schema = mock(Schema.class);
    when(schema.getEntity(Mockito.<String>any())).thenReturn(new SchemaEntityDefinition());
    when(schema.getEdge(Mockito.<String>any())).thenReturn(new SchemaEdgeDefinition());
    when(schema.getVisibilityProperty()).thenReturn("Visibility Property");
    when(schema.isAggregationEnabled()).thenReturn(true);

    AccumuloStore store = mock(AccumuloStore.class);
    when(store.getSchema()).thenReturn(schema);

    // Act
    boolean actualQueryTimeAggregatorRequiredResult =
        byteEntityIteratorSettingsFactory.queryTimeAggregatorRequired(view, store);

    // Assert
    verify(view).getEdge("foo");
    verify(schema).getEdge("foo");
    verify(view).getEdgeGroups();
    verify(schema).getEntity("foo");
    verify(view).getEntityGroups();
    verify(view).getElement("foo");
    verify(store).getSchema();
    verify(schema).getVisibilityProperty();
    verify(schema).isAggregationEnabled();
    assertFalse(actualQueryTimeAggregatorRequiredResult);
  }

  /**
   * Test {@link AbstractCoreKeyIteratorSettingsFactory#queryTimeAggregatorRequired(View,
   * AccumuloStore)}.
   *
   * <ul>
   *   <li>When {@link View} (default constructor).
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AbstractCoreKeyIteratorSettingsFactory#queryTimeAggregatorRequired(View, AccumuloStore)}
   */
  @Test
  @DisplayName(
      "Test queryTimeAggregatorRequired(View, AccumuloStore); when View (default constructor); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AbstractCoreKeyIteratorSettingsFactory.queryTimeAggregatorRequired(View, AccumuloStore)"
  })
  void testQueryTimeAggregatorRequired_whenView_thenReturnFalse() {
    // Arrange
    ByteEntityIteratorSettingsFactory byteEntityIteratorSettingsFactory =
        new ByteEntityIteratorSettingsFactory();
    View view = new View();

    Schema schema = mock(Schema.class);
    when(schema.getVisibilityProperty()).thenReturn("Visibility Property");
    when(schema.isAggregationEnabled()).thenReturn(true);

    AccumuloStore store = mock(AccumuloStore.class);
    when(store.getSchema()).thenReturn(schema);

    // Act
    boolean actualQueryTimeAggregatorRequiredResult =
        byteEntityIteratorSettingsFactory.queryTimeAggregatorRequired(view, store);

    // Assert
    verify(store).getSchema();
    verify(schema).getVisibilityProperty();
    verify(schema).isAggregationEnabled();
    assertFalse(actualQueryTimeAggregatorRequiredResult);
  }

  /**
   * Test {@link AbstractCoreKeyIteratorSettingsFactory#getIteratorSetting(AccumuloStore, String)}.
   *
   * <ul>
   *   <li>When {@code Iterator Name}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AbstractCoreKeyIteratorSettingsFactory#getIteratorSetting(AccumuloStore, String)}
   */
  @Test
  @DisplayName(
      "Test getIteratorSetting(AccumuloStore, String); when 'Iterator Name'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "IteratorSetting AbstractCoreKeyIteratorSettingsFactory.getIteratorSetting(AccumuloStore, String)"
  })
  void testGetIteratorSetting_whenIteratorName_thenThrowIllegalArgumentException()
      throws IteratorSettingException {
    // Arrange
    ByteEntityIteratorSettingsFactory byteEntityIteratorSettingsFactory =
        new ByteEntityIteratorSettingsFactory();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            byteEntityIteratorSettingsFactory.getIteratorSetting(
                new AccumuloStore(), "Iterator Name"));
  }
}
