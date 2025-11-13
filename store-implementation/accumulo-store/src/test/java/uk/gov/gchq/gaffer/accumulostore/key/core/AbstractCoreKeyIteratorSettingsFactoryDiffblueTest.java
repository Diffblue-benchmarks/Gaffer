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
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;
import org.apache.accumulo.core.client.IteratorSetting;
import org.apache.hadoop.util.bloom.BloomFilter;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import uk.gov.gchq.gaffer.accumulostore.AccumuloStore;
import uk.gov.gchq.gaffer.accumulostore.key.core.impl.byteEntity.ByteEntityIteratorSettingsFactory;
import uk.gov.gchq.gaffer.accumulostore.key.core.impl.byteEntity.ByteEntityKeyPackage;
import uk.gov.gchq.gaffer.accumulostore.key.exception.IteratorSettingException;
import uk.gov.gchq.gaffer.data.elementdefinition.ElementDefinitions;
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
   * <p>
   * Method under test: {@link AbstractCoreKeyIteratorSettingsFactory#getBloomFilterIteratorSetting(BloomFilter)}
   */
  @Test
  @DisplayName("Test getBloomFilterIteratorSetting(BloomFilter)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "IteratorSetting AbstractCoreKeyIteratorSettingsFactory.getBloomFilterIteratorSetting(BloomFilter)"})
  void testGetBloomFilterIteratorSetting() throws IteratorSettingException {
    // Arrange
    ByteEntityIteratorSettingsFactory byteEntityIteratorSettingsFactory = new ByteEntityIteratorSettingsFactory();

    // Act
    IteratorSetting actualBloomFilterIteratorSetting = byteEntityIteratorSettingsFactory
        .getBloomFilterIteratorSetting(new BloomFilter(3, 19088743, 1));

    // Assert
    assertEquals("Bloom_Filter", actualBloomFilterIteratorSetting.getName());
    Map<String, String> options = actualBloomFilterIteratorSetting.getOptions();
    assertEquals(1, options.size());
    assertEquals("ÿÿÿÿ\u0001#Eg\u0001\u0000\u0000\u0000\u0003\u0000", options.get("Bloom_Filter"));
    assertEquals("uk.gov.gchq.gaffer.accumulostore.key.core.impl.CoreKeyBloomFilterIterator",
        actualBloomFilterIteratorSetting.getIteratorClass());
    assertEquals(31, actualBloomFilterIteratorSetting.getPriority());
  }

  /**
   * Test {@link AbstractCoreKeyIteratorSettingsFactory#getBloomFilterIteratorSetting(BloomFilter)}.
   * <p>
   * Method under test: {@link AbstractCoreKeyIteratorSettingsFactory#getBloomFilterIteratorSetting(BloomFilter)}
   */
  @Test
  @DisplayName("Test getBloomFilterIteratorSetting(BloomFilter)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "IteratorSetting AbstractCoreKeyIteratorSettingsFactory.getBloomFilterIteratorSetting(BloomFilter)"})
  void testGetBloomFilterIteratorSetting2() throws IteratorSettingException {
    // Arrange
    ByteEntityIteratorSettingsFactory byteEntityIteratorSettingsFactory = new ByteEntityIteratorSettingsFactory();

    // Act
    IteratorSetting actualBloomFilterIteratorSetting = byteEntityIteratorSettingsFactory
        .getBloomFilterIteratorSetting(new BloomFilter(31, 19088743, 1));

    // Assert
    assertEquals("Bloom_Filter", actualBloomFilterIteratorSetting.getName());
    Map<String, String> options = actualBloomFilterIteratorSetting.getOptions();
    assertEquals(1, options.size());
    assertEquals("ÿÿÿÿ\u0001#Eg\u0001\u0000\u0000\u0000\u001f\u0000\u0000\u0000\u0000", options.get("Bloom_Filter"));
    assertEquals("uk.gov.gchq.gaffer.accumulostore.key.core.impl.CoreKeyBloomFilterIterator",
        actualBloomFilterIteratorSetting.getIteratorClass());
    assertEquals(31, actualBloomFilterIteratorSetting.getPriority());
  }

  /**
   * Test {@link AbstractCoreKeyIteratorSettingsFactory#getElementPreAggregationFilterIteratorSetting(View, AccumuloStore)}.
   * <ul>
   *   <li>When {@link View} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractCoreKeyIteratorSettingsFactory#getElementPreAggregationFilterIteratorSetting(View, AccumuloStore)}
   */
  @Test
  @DisplayName("Test getElementPreAggregationFilterIteratorSetting(View, AccumuloStore); when View (default constructor); then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "IteratorSetting AbstractCoreKeyIteratorSettingsFactory.getElementPreAggregationFilterIteratorSetting(View, AccumuloStore)"})
  void testGetElementPreAggregationFilterIteratorSetting_whenView_thenReturnNull() throws IteratorSettingException {
    // Arrange
    ByteEntityIteratorSettingsFactory byteEntityIteratorSettingsFactory = new ByteEntityIteratorSettingsFactory();
    View view = new View();

    // Act and Assert
    assertNull(
        byteEntityIteratorSettingsFactory.getElementPreAggregationFilterIteratorSetting(view, new AccumuloStore()));
  }

  /**
   * Test {@link AbstractCoreKeyIteratorSettingsFactory#getElementPostAggregationFilterIteratorSetting(View, AccumuloStore)}.
   * <ul>
   *   <li>When {@link View} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractCoreKeyIteratorSettingsFactory#getElementPostAggregationFilterIteratorSetting(View, AccumuloStore)}
   */
  @Test
  @DisplayName("Test getElementPostAggregationFilterIteratorSetting(View, AccumuloStore); when View (default constructor); then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "IteratorSetting AbstractCoreKeyIteratorSettingsFactory.getElementPostAggregationFilterIteratorSetting(View, AccumuloStore)"})
  void testGetElementPostAggregationFilterIteratorSetting_whenView_thenReturnNull() throws IteratorSettingException {
    // Arrange
    ByteEntityIteratorSettingsFactory byteEntityIteratorSettingsFactory = new ByteEntityIteratorSettingsFactory();
    View view = new View();

    // Act and Assert
    assertNull(
        byteEntityIteratorSettingsFactory.getElementPostAggregationFilterIteratorSetting(view, new AccumuloStore()));
  }

  /**
   * Test {@link AbstractCoreKeyIteratorSettingsFactory#getAggregatorIteratorSetting(AccumuloStore)}.
   * <ul>
   *   <li>Then return Options {@code Schema} is {@code AXAXAXAX}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractCoreKeyIteratorSettingsFactory#getAggregatorIteratorSetting(AccumuloStore)}
   */
  @Test
  @DisplayName("Test getAggregatorIteratorSetting(AccumuloStore); then return Options 'Schema' is 'AXAXAXAX'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "IteratorSetting AbstractCoreKeyIteratorSettingsFactory.getAggregatorIteratorSetting(AccumuloStore)"})
  void testGetAggregatorIteratorSetting_thenReturnOptionsSchemaIsAxaxaxax()
      throws UnsupportedEncodingException, IteratorSettingException, SchemaException {
    // Arrange
    ByteEntityIteratorSettingsFactory byteEntityIteratorSettingsFactory = new ByteEntityIteratorSettingsFactory();
    Schema schema = mock(Schema.class);
    when(schema.toCompactJson()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    when(schema.getAggregatedGroups()).thenReturn(new ArrayList<>());
    AccumuloStore store = mock(AccumuloStore.class);
    when(store.getKeyPackage()).thenReturn(new ByteEntityKeyPackage(new Schema()));
    when(store.getSchema()).thenReturn(schema);

    // Act
    IteratorSetting actualAggregatorIteratorSetting = byteEntityIteratorSettingsFactory
        .getAggregatorIteratorSetting(store);

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
    assertEquals("uk.gov.gchq.gaffer.accumulostore.key.core.impl.byteEntity.ByteEntityAccumuloElementConverter",
        options.get("accumulostore.key.element_converter"));
    assertEquals("uk.gov.gchq.gaffer.accumulostore.key.impl.AggregatorIterator",
        actualAggregatorIteratorSetting.getIteratorClass());
    assertEquals(10, actualAggregatorIteratorSetting.getPriority());
  }

  /**
   * Test {@link AbstractCoreKeyIteratorSettingsFactory#getRowIDAggregatorIteratorSetting(AccumuloStore, String)}.
   * <ul>
   *   <li>Given {@link Schema#Schema()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractCoreKeyIteratorSettingsFactory#getRowIDAggregatorIteratorSetting(AccumuloStore, String)}
   */
  @Test
  @DisplayName("Test getRowIDAggregatorIteratorSetting(AccumuloStore, String); given Schema()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "IteratorSetting AbstractCoreKeyIteratorSettingsFactory.getRowIDAggregatorIteratorSetting(AccumuloStore, String)"})
  void testGetRowIDAggregatorIteratorSetting_givenSchema() throws IteratorSettingException {
    // Arrange
    ByteEntityIteratorSettingsFactory byteEntityIteratorSettingsFactory = new ByteEntityIteratorSettingsFactory();
    AccumuloStore store = mock(AccumuloStore.class);
    when(store.getSchema()).thenReturn(new Schema());

    // Act
    IteratorSetting actualRowIDAggregatorIteratorSetting = byteEntityIteratorSettingsFactory
        .getRowIDAggregatorIteratorSetting(store, "Column Family");

    // Assert
    verify(store, atLeast(1)).getSchema();
    assertNull(actualRowIDAggregatorIteratorSetting);
  }

  /**
   * Test {@link AbstractCoreKeyIteratorSettingsFactory#getRowIDAggregatorIteratorSetting(AccumuloStore, String)}.
   * <ul>
   *   <li>Given {@link Schema} {@link Schema#isAggregationEnabled()} return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractCoreKeyIteratorSettingsFactory#getRowIDAggregatorIteratorSetting(AccumuloStore, String)}
   */
  @Test
  @DisplayName("Test getRowIDAggregatorIteratorSetting(AccumuloStore, String); given Schema isAggregationEnabled() return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "IteratorSetting AbstractCoreKeyIteratorSettingsFactory.getRowIDAggregatorIteratorSetting(AccumuloStore, String)"})
  void testGetRowIDAggregatorIteratorSetting_givenSchemaIsAggregationEnabledReturnFalse()
      throws IteratorSettingException {
    // Arrange
    ByteEntityIteratorSettingsFactory byteEntityIteratorSettingsFactory = new ByteEntityIteratorSettingsFactory();
    Schema schema = mock(Schema.class);
    when(schema.isAggregationEnabled()).thenReturn(false);
    AccumuloStore store = mock(AccumuloStore.class);
    when(store.getSchema()).thenReturn(schema);

    // Act
    IteratorSetting actualRowIDAggregatorIteratorSetting = byteEntityIteratorSettingsFactory
        .getRowIDAggregatorIteratorSetting(store, "Column Family");

    // Assert
    verify(store, atLeast(1)).getSchema();
    verify(schema, atLeast(1)).isAggregationEnabled();
    assertNull(actualRowIDAggregatorIteratorSetting);
  }

  /**
   * Test {@link AbstractCoreKeyIteratorSettingsFactory#getRowIDAggregatorIteratorSetting(AccumuloStore, String)}.
   * <ul>
   *   <li>Then return Options size is four.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractCoreKeyIteratorSettingsFactory#getRowIDAggregatorIteratorSetting(AccumuloStore, String)}
   */
  @Test
  @DisplayName("Test getRowIDAggregatorIteratorSetting(AccumuloStore, String); then return Options size is four")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "IteratorSetting AbstractCoreKeyIteratorSettingsFactory.getRowIDAggregatorIteratorSetting(AccumuloStore, String)"})
  void testGetRowIDAggregatorIteratorSetting_thenReturnOptionsSizeIsFour()
      throws UnsupportedEncodingException, IteratorSettingException, SchemaException {
    // Arrange
    ByteEntityIteratorSettingsFactory byteEntityIteratorSettingsFactory = new ByteEntityIteratorSettingsFactory();
    Schema schema = mock(Schema.class);
    when(schema.toCompactJson()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    when(schema.getAggregatedGroups()).thenReturn(new ArrayList<>());
    when(schema.isAggregationEnabled()).thenReturn(true);
    AccumuloStore store = mock(AccumuloStore.class);
    when(store.getKeyPackage()).thenReturn(new ByteEntityKeyPackage(new Schema()));
    when(store.getSchema()).thenReturn(schema);

    // Act
    IteratorSetting actualRowIDAggregatorIteratorSetting = byteEntityIteratorSettingsFactory
        .getRowIDAggregatorIteratorSetting(store, "Column Family");

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
    assertEquals("uk.gov.gchq.gaffer.accumulostore.key.core.impl.byteEntity.ByteEntityAccumuloElementConverter",
        options.get("accumulostore.key.element_converter"));
    assertEquals("uk.gov.gchq.gaffer.accumulostore.key.impl.RowIDAggregator",
        actualRowIDAggregatorIteratorSetting.getIteratorClass());
    assertEquals(35, actualRowIDAggregatorIteratorSetting.getPriority());
  }

  /**
   * Test {@link AbstractCoreKeyIteratorSettingsFactory#getRowIDAggregatorIteratorSetting(AccumuloStore, String)}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractCoreKeyIteratorSettingsFactory#getRowIDAggregatorIteratorSetting(AccumuloStore, String)}
   */
  @Test
  @DisplayName("Test getRowIDAggregatorIteratorSetting(AccumuloStore, String); then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "IteratorSetting AbstractCoreKeyIteratorSettingsFactory.getRowIDAggregatorIteratorSetting(AccumuloStore, String)"})
  void testGetRowIDAggregatorIteratorSetting_thenThrowIllegalArgumentException()
      throws UnsupportedEncodingException, IteratorSettingException, SchemaException {
    // Arrange
    ByteEntityIteratorSettingsFactory byteEntityIteratorSettingsFactory = new ByteEntityIteratorSettingsFactory();
    Schema schema = mock(Schema.class);
    when(schema.toCompactJson()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    when(schema.getAggregatedGroups()).thenReturn(new ArrayList<>());
    when(schema.isAggregationEnabled()).thenReturn(true);
    AccumuloStore store = mock(AccumuloStore.class);
    when(store.getKeyPackage()).thenThrow(new IllegalArgumentException("Row_ID_Aggregator"));
    when(store.getSchema()).thenReturn(schema);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> byteEntityIteratorSettingsFactory.getRowIDAggregatorIteratorSetting(store, "Column Family"));
    verify(store).getKeyPackage();
    verify(store, atLeast(1)).getSchema();
    verify(schema).getAggregatedGroups();
    verify(schema).isAggregationEnabled();
    verify(schema).toCompactJson();
  }

  /**
   * Test {@link AbstractCoreKeyIteratorSettingsFactory#getValidatorIteratorSetting(AccumuloStore)}.
   * <ul>
   *   <li>Given {@link Schema#Schema()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractCoreKeyIteratorSettingsFactory#getValidatorIteratorSetting(AccumuloStore)}
   */
  @Test
  @DisplayName("Test getValidatorIteratorSetting(AccumuloStore); given Schema()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "IteratorSetting AbstractCoreKeyIteratorSettingsFactory.getValidatorIteratorSetting(AccumuloStore)"})
  void testGetValidatorIteratorSetting_givenSchema() {
    // Arrange
    ByteEntityIteratorSettingsFactory byteEntityIteratorSettingsFactory = new ByteEntityIteratorSettingsFactory();
    AccumuloStore store = mock(AccumuloStore.class);
    when(store.getSchema()).thenReturn(new Schema());

    // Act
    IteratorSetting actualValidatorIteratorSetting = byteEntityIteratorSettingsFactory
        .getValidatorIteratorSetting(store);

    // Assert
    verify(store, atLeast(1)).getSchema();
    assertNull(actualValidatorIteratorSetting);
  }

  /**
   * Test {@link AbstractCoreKeyIteratorSettingsFactory#getValidatorIteratorSetting(AccumuloStore)}.
   * <ul>
   *   <li>Given {@link Schema} {@link Schema#hasValidation()} return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractCoreKeyIteratorSettingsFactory#getValidatorIteratorSetting(AccumuloStore)}
   */
  @Test
  @DisplayName("Test getValidatorIteratorSetting(AccumuloStore); given Schema hasValidation() return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "IteratorSetting AbstractCoreKeyIteratorSettingsFactory.getValidatorIteratorSetting(AccumuloStore)"})
  void testGetValidatorIteratorSetting_givenSchemaHasValidationReturnFalse() {
    // Arrange
    ByteEntityIteratorSettingsFactory byteEntityIteratorSettingsFactory = new ByteEntityIteratorSettingsFactory();
    Schema schema = mock(Schema.class);
    when(schema.hasValidation()).thenReturn(false);
    AccumuloStore store = mock(AccumuloStore.class);
    when(store.getSchema()).thenReturn(schema);

    // Act
    IteratorSetting actualValidatorIteratorSetting = byteEntityIteratorSettingsFactory
        .getValidatorIteratorSetting(store);

    // Assert
    verify(store, atLeast(1)).getSchema();
    verify(schema, atLeast(1)).hasValidation();
    assertNull(actualValidatorIteratorSetting);
  }

  /**
   * Test {@link AbstractCoreKeyIteratorSettingsFactory#getValidatorIteratorSetting(AccumuloStore)}.
   * <ul>
   *   <li>Then return Options size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractCoreKeyIteratorSettingsFactory#getValidatorIteratorSetting(AccumuloStore)}
   */
  @Test
  @DisplayName("Test getValidatorIteratorSetting(AccumuloStore); then return Options size is two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "IteratorSetting AbstractCoreKeyIteratorSettingsFactory.getValidatorIteratorSetting(AccumuloStore)"})
  void testGetValidatorIteratorSetting_thenReturnOptionsSizeIsTwo()
      throws UnsupportedEncodingException, SchemaException {
    // Arrange
    ByteEntityIteratorSettingsFactory byteEntityIteratorSettingsFactory = new ByteEntityIteratorSettingsFactory();
    Schema schema = mock(Schema.class);
    when(schema.toCompactJson()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    when(schema.hasValidation()).thenReturn(true);
    AccumuloStore store = mock(AccumuloStore.class);
    when(store.getKeyPackage()).thenReturn(new ByteEntityKeyPackage(new Schema()));
    when(store.getSchema()).thenReturn(schema);

    // Act
    IteratorSetting actualValidatorIteratorSetting = byteEntityIteratorSettingsFactory
        .getValidatorIteratorSetting(store);

    // Assert
    verify(store, atLeast(1)).getKeyPackage();
    verify(store, atLeast(1)).getSchema();
    verify(schema).hasValidation();
    verify(schema).toCompactJson();
    Map<String, String> options = actualValidatorIteratorSetting.getOptions();
    assertEquals(2, options.size());
    assertEquals("AXAXAXAX", options.get("Schema"));
    assertEquals("Validator", actualValidatorIteratorSetting.getName());
    assertEquals("uk.gov.gchq.gaffer.accumulostore.key.core.impl.byteEntity.ByteEntityAccumuloElementConverter",
        options.get("accumulostore.key.element_converter"));
    assertEquals("uk.gov.gchq.gaffer.accumulostore.key.impl.ValidatorFilter",
        actualValidatorIteratorSetting.getIteratorClass());
    assertEquals(20, actualValidatorIteratorSetting.getPriority());
  }

  /**
   * Test {@link AbstractCoreKeyIteratorSettingsFactory#getValidatorIteratorSetting(AccumuloStore)}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractCoreKeyIteratorSettingsFactory#getValidatorIteratorSetting(AccumuloStore)}
   */
  @Test
  @DisplayName("Test getValidatorIteratorSetting(AccumuloStore); then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "IteratorSetting AbstractCoreKeyIteratorSettingsFactory.getValidatorIteratorSetting(AccumuloStore)"})
  void testGetValidatorIteratorSetting_thenThrowIllegalArgumentException()
      throws UnsupportedEncodingException, SchemaException {
    // Arrange
    ByteEntityIteratorSettingsFactory byteEntityIteratorSettingsFactory = new ByteEntityIteratorSettingsFactory();
    Schema schema = mock(Schema.class);
    when(schema.toCompactJson()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    when(schema.hasValidation()).thenReturn(true);
    AccumuloStore store = mock(AccumuloStore.class);
    when(store.getKeyPackage()).thenThrow(new IllegalArgumentException("Validator"));
    when(store.getSchema()).thenReturn(schema);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> byteEntityIteratorSettingsFactory.getValidatorIteratorSetting(store));
    verify(store).getKeyPackage();
    verify(store, atLeast(1)).getSchema();
    verify(schema).hasValidation();
    verify(schema).toCompactJson();
  }

  /**
   * Test {@link AbstractCoreKeyIteratorSettingsFactory#getQueryTimeAggregatorIteratorSetting(View, AccumuloStore)}.
   * <p>
   * Method under test: {@link AbstractCoreKeyIteratorSettingsFactory#getQueryTimeAggregatorIteratorSetting(View, AccumuloStore)}
   */
  @Test
  @DisplayName("Test getQueryTimeAggregatorIteratorSetting(View, AccumuloStore)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "IteratorSetting AbstractCoreKeyIteratorSettingsFactory.getQueryTimeAggregatorIteratorSetting(View, AccumuloStore)"})
  void testGetQueryTimeAggregatorIteratorSetting() throws IteratorSettingException {
    // Arrange
    ByteEntityIteratorSettingsFactory byteEntityIteratorSettingsFactory = new ByteEntityIteratorSettingsFactory();
    View view = new View();
    Schema schema = mock(Schema.class);
    when(schema.getVisibilityProperty()).thenThrow(new IllegalArgumentException(
        "Returning null from getQueryTimeAggregatorIteratorSetting as queryTimeAggregatorRequired(view,"
            + " store) = {}"));
    when(schema.isAggregationEnabled()).thenReturn(true);
    AccumuloStore store = mock(AccumuloStore.class);
    when(store.getSchema()).thenReturn(schema);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> byteEntityIteratorSettingsFactory.getQueryTimeAggregatorIteratorSetting(view, store));
    verify(store).getSchema();
    verify(schema).getVisibilityProperty();
    verify(schema).isAggregationEnabled();
  }

  /**
   * Test {@link AbstractCoreKeyIteratorSettingsFactory#getQueryTimeAggregatorIteratorSetting(View, AccumuloStore)}.
   * <p>
   * Method under test: {@link AbstractCoreKeyIteratorSettingsFactory#getQueryTimeAggregatorIteratorSetting(View, AccumuloStore)}
   */
  @Test
  @DisplayName("Test getQueryTimeAggregatorIteratorSetting(View, AccumuloStore)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "IteratorSetting AbstractCoreKeyIteratorSettingsFactory.getQueryTimeAggregatorIteratorSetting(View, AccumuloStore)"})
  void testGetQueryTimeAggregatorIteratorSetting2()
      throws UnsupportedEncodingException, IteratorSettingException, SchemaException {
    // Arrange
    ByteEntityIteratorSettingsFactory byteEntityIteratorSettingsFactory = new ByteEntityIteratorSettingsFactory();

    HashSet<String> stringSet = new HashSet<>();
    stringSet.add("Returning null from getQueryTimeAggregatorIteratorSetting as queryTimeAggregatorRequired(view,"
        + " store) = {}");

    HashSet<String> stringSet2 = new HashSet<>();
    stringSet2.add("Returning null from getQueryTimeAggregatorIteratorSetting as queryTimeAggregatorRequired(view,"
        + " store) = {}");
    GlobalViewElementDefinition globalViewElementDefinition = mock(GlobalViewElementDefinition.class);
    when(globalViewElementDefinition.getGroupBy()).thenReturn(stringSet2);
    NamedView view = mock(NamedView.class);
    when(view.toCompactJson()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    when(view.getEdge(Mockito.<String>any())).thenReturn(globalViewElementDefinition);
    when(view.getEdgeGroups()).thenReturn(stringSet);
    Schema schema = mock(Schema.class);
    when(schema.toCompactJson()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    when(schema.getAggregatedGroups()).thenReturn(new ArrayList<>());
    when(schema.getEdge(Mockito.<String>any())).thenReturn(new SchemaEdgeDefinition());
    when(schema.getVisibilityProperty()).thenReturn("Visibility Property");
    when(schema.isAggregationEnabled()).thenReturn(true);
    AccumuloStore store = mock(AccumuloStore.class);
    when(store.getKeyPackage()).thenThrow(new IllegalArgumentException("Column_Qualifier_Aggregator"));
    when(store.getSchema()).thenReturn(schema);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> byteEntityIteratorSettingsFactory.getQueryTimeAggregatorIteratorSetting(view, store));
    verify(store).getKeyPackage();
    verify(view).getEdge(eq(
        "Returning null from getQueryTimeAggregatorIteratorSetting as queryTimeAggregatorRequired(view, store) = {}"));
    verify(schema).getEdge(eq(
        "Returning null from getQueryTimeAggregatorIteratorSetting as queryTimeAggregatorRequired(view, store) = {}"));
    verify(view).getEdgeGroups();
    verify(view).toCompactJson();
    verify(globalViewElementDefinition, atLeast(1)).getGroupBy();
    verify(store, atLeast(1)).getSchema();
    verify(schema).getAggregatedGroups();
    verify(schema).getVisibilityProperty();
    verify(schema).isAggregationEnabled();
    verify(schema).toCompactJson();
  }

  /**
   * Test {@link AbstractCoreKeyIteratorSettingsFactory#getQueryTimeAggregatorIteratorSetting(View, AccumuloStore)}.
   * <ul>
   *   <li>Given {@link GlobalViewElementDefinition}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractCoreKeyIteratorSettingsFactory#getQueryTimeAggregatorIteratorSetting(View, AccumuloStore)}
   */
  @Test
  @DisplayName("Test getQueryTimeAggregatorIteratorSetting(View, AccumuloStore); given GlobalViewElementDefinition")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "IteratorSetting AbstractCoreKeyIteratorSettingsFactory.getQueryTimeAggregatorIteratorSetting(View, AccumuloStore)"})
  void testGetQueryTimeAggregatorIteratorSetting_givenGlobalViewElementDefinition() throws IteratorSettingException {
    // Arrange
    ByteEntityIteratorSettingsFactory byteEntityIteratorSettingsFactory = new ByteEntityIteratorSettingsFactory();

    HashSet<String> stringSet = new HashSet<>();
    stringSet.add("Returning null from getQueryTimeAggregatorIteratorSetting as queryTimeAggregatorRequired(view,"
        + " store) = {}");
    NamedView view = mock(NamedView.class);
    when(view.getEdge(Mockito.<String>any())).thenReturn(mock(GlobalViewElementDefinition.class));
    when(view.getEdgeGroups()).thenReturn(stringSet);
    when(view.getEntityGroups()).thenReturn(new HashSet<>());
    Schema schema = mock(Schema.class);
    when(schema.getEdge(Mockito.<String>any())).thenReturn(null);
    when(schema.getVisibilityProperty()).thenReturn("Visibility Property");
    when(schema.isAggregationEnabled()).thenReturn(true);
    AccumuloStore store = mock(AccumuloStore.class);
    when(store.getSchema()).thenReturn(schema);

    // Act
    IteratorSetting actualQueryTimeAggregatorIteratorSetting = byteEntityIteratorSettingsFactory
        .getQueryTimeAggregatorIteratorSetting(view, store);

    // Assert
    verify(schema, atLeast(1)).getEdge(eq(
        "Returning null from getQueryTimeAggregatorIteratorSetting as queryTimeAggregatorRequired(view, store) = {}"));
    verify(view, atLeast(1)).getEdgeGroups();
    verify(view, atLeast(1)).getEntityGroups();
    verify(store, atLeast(1)).getSchema();
    verify(schema, atLeast(1)).getVisibilityProperty();
    verify(schema, atLeast(1)).isAggregationEnabled();
    assertNull(actualQueryTimeAggregatorIteratorSetting);
  }

  /**
   * Test {@link AbstractCoreKeyIteratorSettingsFactory#getQueryTimeAggregatorIteratorSetting(View, AccumuloStore)}.
   * <ul>
   *   <li>Given {@link HashSet#HashSet()}.</li>
   *   <li>Then calls {@link ElementDefinitions#getEntityGroups()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractCoreKeyIteratorSettingsFactory#getQueryTimeAggregatorIteratorSetting(View, AccumuloStore)}
   */
  @Test
  @DisplayName("Test getQueryTimeAggregatorIteratorSetting(View, AccumuloStore); given HashSet(); then calls getEntityGroups()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "IteratorSetting AbstractCoreKeyIteratorSettingsFactory.getQueryTimeAggregatorIteratorSetting(View, AccumuloStore)"})
  void testGetQueryTimeAggregatorIteratorSetting_givenHashSet_thenCallsGetEntityGroups()
      throws IteratorSettingException {
    // Arrange
    ByteEntityIteratorSettingsFactory byteEntityIteratorSettingsFactory = new ByteEntityIteratorSettingsFactory();
    NamedView view = mock(NamedView.class);
    when(view.getEdgeGroups()).thenReturn(new HashSet<>());
    when(view.getEntityGroups()).thenReturn(new HashSet<>());
    Schema schema = mock(Schema.class);
    when(schema.getVisibilityProperty()).thenReturn("Visibility Property");
    when(schema.isAggregationEnabled()).thenReturn(true);
    AccumuloStore store = mock(AccumuloStore.class);
    when(store.getSchema()).thenReturn(schema);

    // Act
    IteratorSetting actualQueryTimeAggregatorIteratorSetting = byteEntityIteratorSettingsFactory
        .getQueryTimeAggregatorIteratorSetting(view, store);

    // Assert
    verify(view, atLeast(1)).getEdgeGroups();
    verify(view, atLeast(1)).getEntityGroups();
    verify(store, atLeast(1)).getSchema();
    verify(schema, atLeast(1)).getVisibilityProperty();
    verify(schema, atLeast(1)).isAggregationEnabled();
    assertNull(actualQueryTimeAggregatorIteratorSetting);
  }

  /**
   * Test {@link AbstractCoreKeyIteratorSettingsFactory#getQueryTimeAggregatorIteratorSetting(View, AccumuloStore)}.
   * <ul>
   *   <li>Given {@link Schema#Schema()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractCoreKeyIteratorSettingsFactory#getQueryTimeAggregatorIteratorSetting(View, AccumuloStore)}
   */
  @Test
  @DisplayName("Test getQueryTimeAggregatorIteratorSetting(View, AccumuloStore); given Schema()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "IteratorSetting AbstractCoreKeyIteratorSettingsFactory.getQueryTimeAggregatorIteratorSetting(View, AccumuloStore)"})
  void testGetQueryTimeAggregatorIteratorSetting_givenSchema() throws IteratorSettingException {
    // Arrange
    ByteEntityIteratorSettingsFactory byteEntityIteratorSettingsFactory = new ByteEntityIteratorSettingsFactory();
    View view = new View();
    AccumuloStore store = mock(AccumuloStore.class);
    when(store.getSchema()).thenReturn(new Schema());

    // Act
    IteratorSetting actualQueryTimeAggregatorIteratorSetting = byteEntityIteratorSettingsFactory
        .getQueryTimeAggregatorIteratorSetting(view, store);

    // Assert
    verify(store, atLeast(1)).getSchema();
    assertNull(actualQueryTimeAggregatorIteratorSetting);
  }

  /**
   * Test {@link AbstractCoreKeyIteratorSettingsFactory#getQueryTimeAggregatorIteratorSetting(View, AccumuloStore)}.
   * <ul>
   *   <li>Given {@link ViewElementDefinition} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractCoreKeyIteratorSettingsFactory#getQueryTimeAggregatorIteratorSetting(View, AccumuloStore)}
   */
  @Test
  @DisplayName("Test getQueryTimeAggregatorIteratorSetting(View, AccumuloStore); given ViewElementDefinition (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "IteratorSetting AbstractCoreKeyIteratorSettingsFactory.getQueryTimeAggregatorIteratorSetting(View, AccumuloStore)"})
  void testGetQueryTimeAggregatorIteratorSetting_givenViewElementDefinition() throws IteratorSettingException {
    // Arrange
    ByteEntityIteratorSettingsFactory byteEntityIteratorSettingsFactory = new ByteEntityIteratorSettingsFactory();

    HashSet<String> stringSet = new HashSet<>();
    stringSet.add("Returning null from getQueryTimeAggregatorIteratorSetting as queryTimeAggregatorRequired(view,"
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
    IteratorSetting actualQueryTimeAggregatorIteratorSetting = byteEntityIteratorSettingsFactory
        .getQueryTimeAggregatorIteratorSetting(view, store);

    // Assert
    verify(view, atLeast(1)).getEdge(eq(
        "Returning null from getQueryTimeAggregatorIteratorSetting as queryTimeAggregatorRequired(view, store) = {}"));
    verify(schema, atLeast(1)).getEdge(eq(
        "Returning null from getQueryTimeAggregatorIteratorSetting as queryTimeAggregatorRequired(view, store) = {}"));
    verify(view, atLeast(1)).getEdgeGroups();
    verify(view, atLeast(1)).getEntityGroups();
    verify(store, atLeast(1)).getSchema();
    verify(schema, atLeast(1)).getVisibilityProperty();
    verify(schema, atLeast(1)).isAggregationEnabled();
    assertNull(actualQueryTimeAggregatorIteratorSetting);
  }

  /**
   * Test {@link AbstractCoreKeyIteratorSettingsFactory#getQueryTimeAggregatorIteratorSetting(View, AccumuloStore)}.
   * <ul>
   *   <li>Then calls {@link ViewElementDefinition#getGroupBy()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractCoreKeyIteratorSettingsFactory#getQueryTimeAggregatorIteratorSetting(View, AccumuloStore)}
   */
  @Test
  @DisplayName("Test getQueryTimeAggregatorIteratorSetting(View, AccumuloStore); then calls getGroupBy()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "IteratorSetting AbstractCoreKeyIteratorSettingsFactory.getQueryTimeAggregatorIteratorSetting(View, AccumuloStore)"})
  void testGetQueryTimeAggregatorIteratorSetting_thenCallsGetGroupBy() throws IteratorSettingException {
    // Arrange
    ByteEntityIteratorSettingsFactory byteEntityIteratorSettingsFactory = new ByteEntityIteratorSettingsFactory();

    HashSet<String> stringSet = new HashSet<>();
    stringSet.add("Returning null from getQueryTimeAggregatorIteratorSetting as queryTimeAggregatorRequired(view,"
        + " store) = {}");
    GlobalViewElementDefinition globalViewElementDefinition = mock(GlobalViewElementDefinition.class);
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
    IteratorSetting actualQueryTimeAggregatorIteratorSetting = byteEntityIteratorSettingsFactory
        .getQueryTimeAggregatorIteratorSetting(view, store);

    // Assert
    verify(view, atLeast(1)).getEdge(eq(
        "Returning null from getQueryTimeAggregatorIteratorSetting as queryTimeAggregatorRequired(view, store) = {}"));
    verify(schema, atLeast(1)).getEdge(eq(
        "Returning null from getQueryTimeAggregatorIteratorSetting as queryTimeAggregatorRequired(view, store) = {}"));
    verify(view, atLeast(1)).getEdgeGroups();
    verify(view, atLeast(1)).getEntityGroups();
    verify(globalViewElementDefinition, atLeast(1)).getGroupBy();
    verify(store, atLeast(1)).getSchema();
    verify(schema, atLeast(1)).getVisibilityProperty();
    verify(schema, atLeast(1)).isAggregationEnabled();
    assertNull(actualQueryTimeAggregatorIteratorSetting);
  }

  /**
   * Test {@link AbstractCoreKeyIteratorSettingsFactory#getQueryTimeAggregatorIteratorSetting(View, AccumuloStore)}.
   * <ul>
   *   <li>Then return Options size is four.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractCoreKeyIteratorSettingsFactory#getQueryTimeAggregatorIteratorSetting(View, AccumuloStore)}
   */
  @Test
  @DisplayName("Test getQueryTimeAggregatorIteratorSetting(View, AccumuloStore); then return Options size is four")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "IteratorSetting AbstractCoreKeyIteratorSettingsFactory.getQueryTimeAggregatorIteratorSetting(View, AccumuloStore)"})
  void testGetQueryTimeAggregatorIteratorSetting_thenReturnOptionsSizeIsFour()
      throws UnsupportedEncodingException, IteratorSettingException, SchemaException {
    // Arrange
    ByteEntityIteratorSettingsFactory byteEntityIteratorSettingsFactory = new ByteEntityIteratorSettingsFactory();

    HashSet<String> stringSet = new HashSet<>();
    stringSet.add("Returning null from getQueryTimeAggregatorIteratorSetting as queryTimeAggregatorRequired(view,"
        + " store) = {}");

    HashSet<String> stringSet2 = new HashSet<>();
    stringSet2.add("Returning null from getQueryTimeAggregatorIteratorSetting as queryTimeAggregatorRequired(view,"
        + " store) = {}");
    GlobalViewElementDefinition globalViewElementDefinition = mock(GlobalViewElementDefinition.class);
    when(globalViewElementDefinition.getGroupBy()).thenReturn(stringSet2);
    NamedView view = mock(NamedView.class);
    when(view.toCompactJson()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    when(view.getEdge(Mockito.<String>any())).thenReturn(globalViewElementDefinition);
    when(view.getEdgeGroups()).thenReturn(stringSet);
    Schema schema = mock(Schema.class);
    when(schema.toCompactJson()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    when(schema.getAggregatedGroups()).thenReturn(new ArrayList<>());
    when(schema.getEdge(Mockito.<String>any())).thenReturn(new SchemaEdgeDefinition());
    when(schema.getVisibilityProperty()).thenReturn("Visibility Property");
    when(schema.isAggregationEnabled()).thenReturn(true);
    AccumuloStore store = mock(AccumuloStore.class);
    when(store.getKeyPackage()).thenReturn(new ByteEntityKeyPackage(new Schema()));
    when(store.getSchema()).thenReturn(schema);

    // Act
    IteratorSetting actualQueryTimeAggregatorIteratorSetting = byteEntityIteratorSettingsFactory
        .getQueryTimeAggregatorIteratorSetting(view, store);

    // Assert
    verify(store, atLeast(1)).getKeyPackage();
    verify(view).getEdge(eq(
        "Returning null from getQueryTimeAggregatorIteratorSetting as queryTimeAggregatorRequired(view, store) = {}"));
    verify(schema).getEdge(eq(
        "Returning null from getQueryTimeAggregatorIteratorSetting as queryTimeAggregatorRequired(view, store) = {}"));
    verify(view).getEdgeGroups();
    verify(view).toCompactJson();
    verify(globalViewElementDefinition, atLeast(1)).getGroupBy();
    verify(store, atLeast(1)).getSchema();
    verify(schema, atLeast(1)).getAggregatedGroups();
    verify(schema).getVisibilityProperty();
    verify(schema).isAggregationEnabled();
    verify(schema).toCompactJson();
    Map<String, String> options = actualQueryTimeAggregatorIteratorSetting.getOptions();
    assertEquals(4, options.size());
    assertEquals("", options.get("columns"));
    assertEquals("AXAXAXAX", options.get("Schema"));
    assertEquals("AXAXAXAX", options.get("View"));
    assertEquals("Column_Qualifier_Aggregator", actualQueryTimeAggregatorIteratorSetting.getName());
    assertEquals("uk.gov.gchq.gaffer.accumulostore.key.core.impl.CoreKeyGroupByAggregatorIterator",
        actualQueryTimeAggregatorIteratorSetting.getIteratorClass());
    assertEquals("uk.gov.gchq.gaffer.accumulostore.key.core.impl.byteEntity.ByteEntityAccumuloElementConverter",
        options.get("accumulostore.key.element_converter"));
    assertEquals(36, actualQueryTimeAggregatorIteratorSetting.getPriority());
  }

  /**
   * Test {@link AbstractCoreKeyIteratorSettingsFactory#getQueryTimeAggregatorIteratorSetting(View, AccumuloStore)}.
   * <ul>
   *   <li>When {@link NamedView} {@link ElementDefinitions#getEdge(String)} return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractCoreKeyIteratorSettingsFactory#getQueryTimeAggregatorIteratorSetting(View, AccumuloStore)}
   */
  @Test
  @DisplayName("Test getQueryTimeAggregatorIteratorSetting(View, AccumuloStore); when NamedView getEdge(String) return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "IteratorSetting AbstractCoreKeyIteratorSettingsFactory.getQueryTimeAggregatorIteratorSetting(View, AccumuloStore)"})
  void testGetQueryTimeAggregatorIteratorSetting_whenNamedViewGetEdgeReturnNull() throws IteratorSettingException {
    // Arrange
    ByteEntityIteratorSettingsFactory byteEntityIteratorSettingsFactory = new ByteEntityIteratorSettingsFactory();

    HashSet<String> stringSet = new HashSet<>();
    stringSet.add("Returning null from getQueryTimeAggregatorIteratorSetting as queryTimeAggregatorRequired(view,"
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
    IteratorSetting actualQueryTimeAggregatorIteratorSetting = byteEntityIteratorSettingsFactory
        .getQueryTimeAggregatorIteratorSetting(view, store);

    // Assert
    verify(view, atLeast(1)).getEdge(eq(
        "Returning null from getQueryTimeAggregatorIteratorSetting as queryTimeAggregatorRequired(view, store) = {}"));
    verify(schema, atLeast(1)).getEdge(eq(
        "Returning null from getQueryTimeAggregatorIteratorSetting as queryTimeAggregatorRequired(view, store) = {}"));
    verify(view, atLeast(1)).getEdgeGroups();
    verify(view, atLeast(1)).getEntityGroups();
    verify(store, atLeast(1)).getSchema();
    verify(schema, atLeast(1)).getVisibilityProperty();
    verify(schema, atLeast(1)).isAggregationEnabled();
    assertNull(actualQueryTimeAggregatorIteratorSetting);
  }

  /**
   * Test {@link AbstractCoreKeyIteratorSettingsFactory#getQueryTimeAggregatorIteratorSetting(View, AccumuloStore)}.
   * <ul>
   *   <li>When {@link View} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractCoreKeyIteratorSettingsFactory#getQueryTimeAggregatorIteratorSetting(View, AccumuloStore)}
   */
  @Test
  @DisplayName("Test getQueryTimeAggregatorIteratorSetting(View, AccumuloStore); when View (default constructor); then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "IteratorSetting AbstractCoreKeyIteratorSettingsFactory.getQueryTimeAggregatorIteratorSetting(View, AccumuloStore)"})
  void testGetQueryTimeAggregatorIteratorSetting_whenView_thenReturnNull() throws IteratorSettingException {
    // Arrange
    ByteEntityIteratorSettingsFactory byteEntityIteratorSettingsFactory = new ByteEntityIteratorSettingsFactory();
    View view = new View();
    Schema schema = mock(Schema.class);
    when(schema.getVisibilityProperty()).thenReturn("Visibility Property");
    when(schema.isAggregationEnabled()).thenReturn(true);
    AccumuloStore store = mock(AccumuloStore.class);
    when(store.getSchema()).thenReturn(schema);

    // Act
    IteratorSetting actualQueryTimeAggregatorIteratorSetting = byteEntityIteratorSettingsFactory
        .getQueryTimeAggregatorIteratorSetting(view, store);

    // Assert
    verify(store, atLeast(1)).getSchema();
    verify(schema, atLeast(1)).getVisibilityProperty();
    verify(schema, atLeast(1)).isAggregationEnabled();
    assertNull(actualQueryTimeAggregatorIteratorSetting);
  }

  /**
   * Test {@link AbstractCoreKeyIteratorSettingsFactory#queryTimeAggregatorRequired(View, AccumuloStore)}.
   * <p>
   * Method under test: {@link AbstractCoreKeyIteratorSettingsFactory#queryTimeAggregatorRequired(View, AccumuloStore)}
   */
  @Test
  @DisplayName("Test queryTimeAggregatorRequired(View, AccumuloStore)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean AbstractCoreKeyIteratorSettingsFactory.queryTimeAggregatorRequired(View, AccumuloStore)"})
  void testQueryTimeAggregatorRequired() {
    // Arrange
    ByteEntityIteratorSettingsFactory byteEntityIteratorSettingsFactory = new ByteEntityIteratorSettingsFactory();

    HashSet<String> stringSet = new HashSet<>();
    stringSet.add("foo");

    HashSet<String> stringSet2 = new HashSet<>();
    stringSet2.add("foo");
    GlobalViewElementDefinition globalViewElementDefinition = mock(GlobalViewElementDefinition.class);
    when(globalViewElementDefinition.getGroupBy()).thenReturn(new HashSet<>());
    NamedView view = mock(NamedView.class);
    when(view.getElement(Mockito.<String>any())).thenReturn(new ViewElementDefinition());
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
    boolean actualQueryTimeAggregatorRequiredResult = byteEntityIteratorSettingsFactory
        .queryTimeAggregatorRequired(view, store);

    // Assert
    verify(view).getEdge(eq("foo"));
    verify(schema).getEdge(eq("foo"));
    verify(view).getEdgeGroups();
    verify(schema).getEntity(eq("foo"));
    verify(view).getEntityGroups();
    verify(view).getElement(eq("foo"));
    verify(globalViewElementDefinition, atLeast(1)).getGroupBy();
    verify(store).getSchema();
    verify(schema).getVisibilityProperty();
    verify(schema).isAggregationEnabled();
    assertFalse(actualQueryTimeAggregatorRequiredResult);
  }

  /**
   * Test {@link AbstractCoreKeyIteratorSettingsFactory#queryTimeAggregatorRequired(View, AccumuloStore)}.
   * <p>
   * Method under test: {@link AbstractCoreKeyIteratorSettingsFactory#queryTimeAggregatorRequired(View, AccumuloStore)}
   */
  @Test
  @DisplayName("Test queryTimeAggregatorRequired(View, AccumuloStore)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean AbstractCoreKeyIteratorSettingsFactory.queryTimeAggregatorRequired(View, AccumuloStore)"})
  void testQueryTimeAggregatorRequired2() {
    // Arrange
    ByteEntityIteratorSettingsFactory byteEntityIteratorSettingsFactory = new ByteEntityIteratorSettingsFactory();

    HashSet<String> stringSet = new HashSet<>();
    stringSet.add("foo");

    HashSet<String> stringSet2 = new HashSet<>();
    stringSet2.add("foo");
    GlobalViewElementDefinition globalViewElementDefinition = mock(GlobalViewElementDefinition.class);
    when(globalViewElementDefinition.getGroupBy()).thenReturn(new HashSet<>());
    NamedView view = mock(NamedView.class);
    when(view.getEdge(Mockito.<String>any())).thenReturn(globalViewElementDefinition);
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
    boolean actualQueryTimeAggregatorRequiredResult = byteEntityIteratorSettingsFactory
        .queryTimeAggregatorRequired(view, store);

    // Assert
    verify(view).getEdge(eq("foo"));
    verify(schema).getEdge(eq("foo"));
    verify(view).getEdgeGroups();
    verify(schema).getEntity(eq("foo"));
    verify(view).getEntityGroups();
    verify(globalViewElementDefinition, atLeast(1)).getGroupBy();
    verify(store).getSchema();
    verify(schema).getVisibilityProperty();
    verify(schema).isAggregationEnabled();
    verify(schemaEntityDefinition).containsProperty(eq("Visibility Property"));
    assertTrue(actualQueryTimeAggregatorRequiredResult);
  }

  /**
   * Test {@link AbstractCoreKeyIteratorSettingsFactory#queryTimeAggregatorRequired(View, AccumuloStore)}.
   * <p>
   * Method under test: {@link AbstractCoreKeyIteratorSettingsFactory#queryTimeAggregatorRequired(View, AccumuloStore)}
   */
  @Test
  @DisplayName("Test queryTimeAggregatorRequired(View, AccumuloStore)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean AbstractCoreKeyIteratorSettingsFactory.queryTimeAggregatorRequired(View, AccumuloStore)"})
  void testQueryTimeAggregatorRequired3() {
    // Arrange
    ByteEntityIteratorSettingsFactory byteEntityIteratorSettingsFactory = new ByteEntityIteratorSettingsFactory();

    HashSet<String> stringSet = new HashSet<>();
    stringSet.add("foo");

    HashSet<String> stringSet2 = new HashSet<>();
    stringSet2.add("foo");
    GlobalViewElementDefinition globalViewElementDefinition = mock(GlobalViewElementDefinition.class);
    when(globalViewElementDefinition.getGroupBy()).thenReturn(new HashSet<>());
    GlobalViewElementDefinition globalViewElementDefinition2 = mock(GlobalViewElementDefinition.class);
    when(globalViewElementDefinition2.getGroupBy()).thenReturn(new HashSet<>());
    NamedView view = mock(NamedView.class);
    when(view.getElement(Mockito.<String>any())).thenReturn(globalViewElementDefinition2);
    when(view.getEdge(Mockito.<String>any())).thenReturn(globalViewElementDefinition);
    when(view.getEdgeGroups()).thenReturn(stringSet);
    when(view.getEntityGroups()).thenReturn(stringSet2);
    SchemaEntityDefinition schemaEntityDefinition = mock(SchemaEntityDefinition.class);
    when(schemaEntityDefinition.containsProperty(Mockito.<String>any())).thenReturn(false);
    when(schemaEntityDefinition.getGroupBy()).thenReturn(new HashSet<>());
    Schema schema = mock(Schema.class);
    when(schema.getEntity(Mockito.<String>any())).thenReturn(schemaEntityDefinition);
    when(schema.getEdge(Mockito.<String>any())).thenReturn(new SchemaEdgeDefinition());
    when(schema.getVisibilityProperty()).thenReturn("Visibility Property");
    when(schema.isAggregationEnabled()).thenReturn(true);
    AccumuloStore store = mock(AccumuloStore.class);
    when(store.getSchema()).thenReturn(schema);

    // Act
    boolean actualQueryTimeAggregatorRequiredResult = byteEntityIteratorSettingsFactory
        .queryTimeAggregatorRequired(view, store);

    // Assert
    verify(view).getEdge(eq("foo"));
    verify(schema).getEdge(eq("foo"));
    verify(view).getEdgeGroups();
    verify(schema).getEntity(eq("foo"));
    verify(view).getEntityGroups();
    verify(view).getElement(eq("foo"));
    verify(globalViewElementDefinition2, atLeast(1)).getGroupBy();
    verify(globalViewElementDefinition, atLeast(1)).getGroupBy();
    verify(store).getSchema();
    verify(schema).getVisibilityProperty();
    verify(schema).isAggregationEnabled();
    verify(schemaEntityDefinition).containsProperty(eq("Visibility Property"));
    verify(schemaEntityDefinition).getGroupBy();
    assertFalse(actualQueryTimeAggregatorRequiredResult);
  }

  /**
   * Test {@link AbstractCoreKeyIteratorSettingsFactory#queryTimeAggregatorRequired(View, AccumuloStore)}.
   * <p>
   * Method under test: {@link AbstractCoreKeyIteratorSettingsFactory#queryTimeAggregatorRequired(View, AccumuloStore)}
   */
  @Test
  @DisplayName("Test queryTimeAggregatorRequired(View, AccumuloStore)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean AbstractCoreKeyIteratorSettingsFactory.queryTimeAggregatorRequired(View, AccumuloStore)"})
  void testQueryTimeAggregatorRequired4() {
    // Arrange
    ByteEntityIteratorSettingsFactory byteEntityIteratorSettingsFactory = new ByteEntityIteratorSettingsFactory();

    HashSet<String> stringSet = new HashSet<>();
    stringSet.add("foo");
    NamedView view = mock(NamedView.class);
    when(view.getEdge(Mockito.<String>any())).thenReturn(mock(GlobalViewElementDefinition.class));
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
    boolean actualQueryTimeAggregatorRequiredResult = byteEntityIteratorSettingsFactory
        .queryTimeAggregatorRequired(view, store);

    // Assert
    verify(schema).getEdge(eq("foo"));
    verify(view).getEdgeGroups();
    verify(store).getSchema();
    verify(schema).getVisibilityProperty();
    verify(schema).isAggregationEnabled();
    verify(schemaEdgeDefinition).containsProperty(eq("Visibility Property"));
    assertTrue(actualQueryTimeAggregatorRequiredResult);
  }

  /**
   * Test {@link AbstractCoreKeyIteratorSettingsFactory#queryTimeAggregatorRequired(View, AccumuloStore)}.
   * <p>
   * Method under test: {@link AbstractCoreKeyIteratorSettingsFactory#queryTimeAggregatorRequired(View, AccumuloStore)}
   */
  @Test
  @DisplayName("Test queryTimeAggregatorRequired(View, AccumuloStore)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean AbstractCoreKeyIteratorSettingsFactory.queryTimeAggregatorRequired(View, AccumuloStore)"})
  void testQueryTimeAggregatorRequired5() {
    // Arrange
    ByteEntityIteratorSettingsFactory byteEntityIteratorSettingsFactory = new ByteEntityIteratorSettingsFactory();

    HashSet<String> stringSet = new HashSet<>();
    stringSet.add("foo");

    HashSet<String> stringSet2 = new HashSet<>();
    stringSet2.add("foo");
    GlobalViewElementDefinition globalViewElementDefinition = mock(GlobalViewElementDefinition.class);
    when(globalViewElementDefinition.getGroupBy()).thenReturn(new HashSet<>());
    NamedView view = mock(NamedView.class);
    when(view.getEdge(Mockito.<String>any())).thenReturn(globalViewElementDefinition);
    when(view.getEdgeGroups()).thenReturn(stringSet);
    when(view.getEntityGroups()).thenReturn(stringSet2);
    SchemaEdgeDefinition schemaEdgeDefinition = mock(SchemaEdgeDefinition.class);
    when(schemaEdgeDefinition.containsProperty(Mockito.<String>any())).thenReturn(false);
    when(schemaEdgeDefinition.getGroupBy()).thenReturn(new HashSet<>());
    SchemaEntityDefinition schemaEntityDefinition = mock(SchemaEntityDefinition.class);
    when(schemaEntityDefinition.containsProperty(Mockito.<String>any())).thenReturn(true);
    when(schemaEntityDefinition.getGroupBy()).thenReturn(new HashSet<>());
    Schema schema = mock(Schema.class);
    when(schema.getEntity(Mockito.<String>any())).thenReturn(schemaEntityDefinition);
    when(schema.getEdge(Mockito.<String>any())).thenReturn(schemaEdgeDefinition);
    when(schema.getVisibilityProperty()).thenReturn("Visibility Property");
    when(schema.isAggregationEnabled()).thenReturn(true);
    AccumuloStore store = mock(AccumuloStore.class);
    when(store.getSchema()).thenReturn(schema);

    // Act
    boolean actualQueryTimeAggregatorRequiredResult = byteEntityIteratorSettingsFactory
        .queryTimeAggregatorRequired(view, store);

    // Assert
    verify(view).getEdge(eq("foo"));
    verify(schema).getEdge(eq("foo"));
    verify(view).getEdgeGroups();
    verify(schema).getEntity(eq("foo"));
    verify(view).getEntityGroups();
    verify(globalViewElementDefinition, atLeast(1)).getGroupBy();
    verify(store).getSchema();
    verify(schema).getVisibilityProperty();
    verify(schema).isAggregationEnabled();
    verify(schemaEdgeDefinition).containsProperty(eq("Visibility Property"));
    verify(schemaEntityDefinition).containsProperty(eq("Visibility Property"));
    verify(schemaEdgeDefinition).getGroupBy();
    assertTrue(actualQueryTimeAggregatorRequiredResult);
  }

  /**
   * Test {@link AbstractCoreKeyIteratorSettingsFactory#queryTimeAggregatorRequired(View, AccumuloStore)}.
   * <ul>
   *   <li>Given {@link HashSet#HashSet()}.</li>
   *   <li>Then calls {@link ViewElementDefinition#getGroupBy()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractCoreKeyIteratorSettingsFactory#queryTimeAggregatorRequired(View, AccumuloStore)}
   */
  @Test
  @DisplayName("Test queryTimeAggregatorRequired(View, AccumuloStore); given HashSet(); then calls getGroupBy()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean AbstractCoreKeyIteratorSettingsFactory.queryTimeAggregatorRequired(View, AccumuloStore)"})
  void testQueryTimeAggregatorRequired_givenHashSet_thenCallsGetGroupBy() {
    // Arrange
    ByteEntityIteratorSettingsFactory byteEntityIteratorSettingsFactory = new ByteEntityIteratorSettingsFactory();

    HashSet<String> stringSet = new HashSet<>();
    stringSet.add("foo");
    GlobalViewElementDefinition globalViewElementDefinition = mock(GlobalViewElementDefinition.class);
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
    boolean actualQueryTimeAggregatorRequiredResult = byteEntityIteratorSettingsFactory
        .queryTimeAggregatorRequired(view, store);

    // Assert
    verify(view).getEdge(eq("foo"));
    verify(schema).getEdge(eq("foo"));
    verify(view).getEdgeGroups();
    verify(view).getEntityGroups();
    verify(globalViewElementDefinition, atLeast(1)).getGroupBy();
    verify(store).getSchema();
    verify(schema).getVisibilityProperty();
    verify(schema).isAggregationEnabled();
    assertFalse(actualQueryTimeAggregatorRequiredResult);
  }

  /**
   * Test {@link AbstractCoreKeyIteratorSettingsFactory#queryTimeAggregatorRequired(View, AccumuloStore)}.
   * <ul>
   *   <li>Given {@link HashSet#HashSet()}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractCoreKeyIteratorSettingsFactory#queryTimeAggregatorRequired(View, AccumuloStore)}
   */
  @Test
  @DisplayName("Test queryTimeAggregatorRequired(View, AccumuloStore); given HashSet(); then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean AbstractCoreKeyIteratorSettingsFactory.queryTimeAggregatorRequired(View, AccumuloStore)"})
  void testQueryTimeAggregatorRequired_givenHashSet_thenReturnFalse() {
    // Arrange
    ByteEntityIteratorSettingsFactory byteEntityIteratorSettingsFactory = new ByteEntityIteratorSettingsFactory();
    NamedView view = mock(NamedView.class);
    when(view.getEdgeGroups()).thenReturn(new HashSet<>());
    when(view.getEntityGroups()).thenReturn(new HashSet<>());
    Schema schema = mock(Schema.class);
    when(schema.getVisibilityProperty()).thenReturn("Visibility Property");
    when(schema.isAggregationEnabled()).thenReturn(true);
    AccumuloStore store = mock(AccumuloStore.class);
    when(store.getSchema()).thenReturn(schema);

    // Act
    boolean actualQueryTimeAggregatorRequiredResult = byteEntityIteratorSettingsFactory
        .queryTimeAggregatorRequired(view, store);

    // Assert
    verify(view).getEdgeGroups();
    verify(view).getEntityGroups();
    verify(store).getSchema();
    verify(schema).getVisibilityProperty();
    verify(schema).isAggregationEnabled();
    assertFalse(actualQueryTimeAggregatorRequiredResult);
  }

  /**
   * Test {@link AbstractCoreKeyIteratorSettingsFactory#queryTimeAggregatorRequired(View, AccumuloStore)}.
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>When {@link NamedView} {@link ElementDefinitions#getEdge(String)} return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractCoreKeyIteratorSettingsFactory#queryTimeAggregatorRequired(View, AccumuloStore)}
   */
  @Test
  @DisplayName("Test queryTimeAggregatorRequired(View, AccumuloStore); given 'null'; when NamedView getEdge(String) return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean AbstractCoreKeyIteratorSettingsFactory.queryTimeAggregatorRequired(View, AccumuloStore)"})
  void testQueryTimeAggregatorRequired_givenNull_whenNamedViewGetEdgeReturnNull() {
    // Arrange
    ByteEntityIteratorSettingsFactory byteEntityIteratorSettingsFactory = new ByteEntityIteratorSettingsFactory();

    HashSet<String> stringSet = new HashSet<>();
    stringSet.add("foo");
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
    boolean actualQueryTimeAggregatorRequiredResult = byteEntityIteratorSettingsFactory
        .queryTimeAggregatorRequired(view, store);

    // Assert
    verify(view).getEdge(eq("foo"));
    verify(schema).getEdge(eq("foo"));
    verify(view).getEdgeGroups();
    verify(view).getEntityGroups();
    verify(store).getSchema();
    verify(schema).getVisibilityProperty();
    verify(schema).isAggregationEnabled();
    assertFalse(actualQueryTimeAggregatorRequiredResult);
  }

  /**
   * Test {@link AbstractCoreKeyIteratorSettingsFactory#queryTimeAggregatorRequired(View, AccumuloStore)}.
   * <ul>
   *   <li>Given {@link Schema#Schema()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractCoreKeyIteratorSettingsFactory#queryTimeAggregatorRequired(View, AccumuloStore)}
   */
  @Test
  @DisplayName("Test queryTimeAggregatorRequired(View, AccumuloStore); given Schema()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean AbstractCoreKeyIteratorSettingsFactory.queryTimeAggregatorRequired(View, AccumuloStore)"})
  void testQueryTimeAggregatorRequired_givenSchema() {
    // Arrange
    ByteEntityIteratorSettingsFactory byteEntityIteratorSettingsFactory = new ByteEntityIteratorSettingsFactory();
    View view = new View();
    AccumuloStore store = mock(AccumuloStore.class);
    when(store.getSchema()).thenReturn(new Schema());

    // Act
    boolean actualQueryTimeAggregatorRequiredResult = byteEntityIteratorSettingsFactory
        .queryTimeAggregatorRequired(view, store);

    // Assert
    verify(store).getSchema();
    assertFalse(actualQueryTimeAggregatorRequiredResult);
  }

  /**
   * Test {@link AbstractCoreKeyIteratorSettingsFactory#queryTimeAggregatorRequired(View, AccumuloStore)}.
   * <ul>
   *   <li>Given {@link Schema} {@link ElementDefinitions#getEdge(String)} return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractCoreKeyIteratorSettingsFactory#queryTimeAggregatorRequired(View, AccumuloStore)}
   */
  @Test
  @DisplayName("Test queryTimeAggregatorRequired(View, AccumuloStore); given Schema getEdge(String) return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean AbstractCoreKeyIteratorSettingsFactory.queryTimeAggregatorRequired(View, AccumuloStore)"})
  void testQueryTimeAggregatorRequired_givenSchemaGetEdgeReturnNull() {
    // Arrange
    ByteEntityIteratorSettingsFactory byteEntityIteratorSettingsFactory = new ByteEntityIteratorSettingsFactory();

    HashSet<String> stringSet = new HashSet<>();
    stringSet.add("foo");

    HashSet<String> stringSet2 = new HashSet<>();
    stringSet2.add("foo");
    NamedView view = mock(NamedView.class);
    when(view.getEdge(Mockito.<String>any())).thenReturn(mock(GlobalViewElementDefinition.class));
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
    boolean actualQueryTimeAggregatorRequiredResult = byteEntityIteratorSettingsFactory
        .queryTimeAggregatorRequired(view, store);

    // Assert
    verify(schema).getEdge(eq("foo"));
    verify(view).getEdgeGroups();
    verify(schema).getEntity(eq("foo"));
    verify(view).getEntityGroups();
    verify(store).getSchema();
    verify(schema).getVisibilityProperty();
    verify(schema).isAggregationEnabled();
    verify(schemaEntityDefinition).containsProperty(eq("Visibility Property"));
    assertTrue(actualQueryTimeAggregatorRequiredResult);
  }

  /**
   * Test {@link AbstractCoreKeyIteratorSettingsFactory#queryTimeAggregatorRequired(View, AccumuloStore)}.
   * <ul>
   *   <li>Given {@link Schema} {@link ElementDefinitions#getEntity(String)} return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractCoreKeyIteratorSettingsFactory#queryTimeAggregatorRequired(View, AccumuloStore)}
   */
  @Test
  @DisplayName("Test queryTimeAggregatorRequired(View, AccumuloStore); given Schema getEntity(String) return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean AbstractCoreKeyIteratorSettingsFactory.queryTimeAggregatorRequired(View, AccumuloStore)"})
  void testQueryTimeAggregatorRequired_givenSchemaGetEntityReturnNull() {
    // Arrange
    ByteEntityIteratorSettingsFactory byteEntityIteratorSettingsFactory = new ByteEntityIteratorSettingsFactory();

    HashSet<String> stringSet = new HashSet<>();
    stringSet.add("foo");

    HashSet<String> stringSet2 = new HashSet<>();
    stringSet2.add("foo");
    GlobalViewElementDefinition globalViewElementDefinition = mock(GlobalViewElementDefinition.class);
    when(globalViewElementDefinition.getGroupBy()).thenReturn(new HashSet<>());
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
    boolean actualQueryTimeAggregatorRequiredResult = byteEntityIteratorSettingsFactory
        .queryTimeAggregatorRequired(view, store);

    // Assert
    verify(view).getEdge(eq("foo"));
    verify(schema).getEdge(eq("foo"));
    verify(view).getEdgeGroups();
    verify(schema).getEntity(eq("foo"));
    verify(view).getEntityGroups();
    verify(globalViewElementDefinition, atLeast(1)).getGroupBy();
    verify(store).getSchema();
    verify(schema).getVisibilityProperty();
    verify(schema).isAggregationEnabled();
    assertFalse(actualQueryTimeAggregatorRequiredResult);
  }

  /**
   * Test {@link AbstractCoreKeyIteratorSettingsFactory#queryTimeAggregatorRequired(View, AccumuloStore)}.
   * <ul>
   *   <li>Then calls {@link View#getElement(String)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractCoreKeyIteratorSettingsFactory#queryTimeAggregatorRequired(View, AccumuloStore)}
   */
  @Test
  @DisplayName("Test queryTimeAggregatorRequired(View, AccumuloStore); then calls getElement(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean AbstractCoreKeyIteratorSettingsFactory.queryTimeAggregatorRequired(View, AccumuloStore)"})
  void testQueryTimeAggregatorRequired_thenCallsGetElement() {
    // Arrange
    ByteEntityIteratorSettingsFactory byteEntityIteratorSettingsFactory = new ByteEntityIteratorSettingsFactory();

    HashSet<String> stringSet = new HashSet<>();
    stringSet.add("foo");

    HashSet<String> stringSet2 = new HashSet<>();
    stringSet2.add("foo");
    GlobalViewElementDefinition globalViewElementDefinition = mock(GlobalViewElementDefinition.class);
    when(globalViewElementDefinition.getGroupBy()).thenReturn(new HashSet<>());
    GlobalViewElementDefinition globalViewElementDefinition2 = mock(GlobalViewElementDefinition.class);
    when(globalViewElementDefinition2.getGroupBy()).thenReturn(new HashSet<>());
    NamedView view = mock(NamedView.class);
    when(view.getElement(Mockito.<String>any())).thenReturn(globalViewElementDefinition2);
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
    boolean actualQueryTimeAggregatorRequiredResult = byteEntityIteratorSettingsFactory
        .queryTimeAggregatorRequired(view, store);

    // Assert
    verify(view).getEdge(eq("foo"));
    verify(schema).getEdge(eq("foo"));
    verify(view).getEdgeGroups();
    verify(schema).getEntity(eq("foo"));
    verify(view).getEntityGroups();
    verify(view).getElement(eq("foo"));
    verify(globalViewElementDefinition2, atLeast(1)).getGroupBy();
    verify(globalViewElementDefinition, atLeast(1)).getGroupBy();
    verify(store).getSchema();
    verify(schema).getVisibilityProperty();
    verify(schema).isAggregationEnabled();
    assertFalse(actualQueryTimeAggregatorRequiredResult);
  }

  /**
   * Test {@link AbstractCoreKeyIteratorSettingsFactory#queryTimeAggregatorRequired(View, AccumuloStore)}.
   * <ul>
   *   <li>Then calls {@link View#getElement(String)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractCoreKeyIteratorSettingsFactory#queryTimeAggregatorRequired(View, AccumuloStore)}
   */
  @Test
  @DisplayName("Test queryTimeAggregatorRequired(View, AccumuloStore); then calls getElement(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean AbstractCoreKeyIteratorSettingsFactory.queryTimeAggregatorRequired(View, AccumuloStore)"})
  void testQueryTimeAggregatorRequired_thenCallsGetElement2() {
    // Arrange
    ByteEntityIteratorSettingsFactory byteEntityIteratorSettingsFactory = new ByteEntityIteratorSettingsFactory();

    HashSet<String> stringSet = new HashSet<>();
    stringSet.add("foo");

    HashSet<String> stringSet2 = new HashSet<>();
    stringSet2.add("foo");
    GlobalViewElementDefinition globalViewElementDefinition = mock(GlobalViewElementDefinition.class);
    when(globalViewElementDefinition.getGroupBy()).thenReturn(new HashSet<>());

    HashSet<String> stringSet3 = new HashSet<>();
    stringSet3.add("foo");
    GlobalViewElementDefinition globalViewElementDefinition2 = mock(GlobalViewElementDefinition.class);
    when(globalViewElementDefinition2.getGroupBy()).thenReturn(stringSet3);
    NamedView view = mock(NamedView.class);
    when(view.getElement(Mockito.<String>any())).thenReturn(globalViewElementDefinition2);
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
    boolean actualQueryTimeAggregatorRequiredResult = byteEntityIteratorSettingsFactory
        .queryTimeAggregatorRequired(view, store);

    // Assert
    verify(view).getEdge(eq("foo"));
    verify(schema).getEdge(eq("foo"));
    verify(view).getEdgeGroups();
    verify(schema).getEntity(eq("foo"));
    verify(view).getEntityGroups();
    verify(view).getElement(eq("foo"));
    verify(globalViewElementDefinition2, atLeast(1)).getGroupBy();
    verify(globalViewElementDefinition, atLeast(1)).getGroupBy();
    verify(store).getSchema();
    verify(schema).getVisibilityProperty();
    verify(schema).isAggregationEnabled();
    assertTrue(actualQueryTimeAggregatorRequiredResult);
  }

  /**
   * Test {@link AbstractCoreKeyIteratorSettingsFactory#queryTimeAggregatorRequired(View, AccumuloStore)}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractCoreKeyIteratorSettingsFactory#queryTimeAggregatorRequired(View, AccumuloStore)}
   */
  @Test
  @DisplayName("Test queryTimeAggregatorRequired(View, AccumuloStore); then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean AbstractCoreKeyIteratorSettingsFactory.queryTimeAggregatorRequired(View, AccumuloStore)"})
  void testQueryTimeAggregatorRequired_thenReturnTrue() {
    // Arrange
    ByteEntityIteratorSettingsFactory byteEntityIteratorSettingsFactory = new ByteEntityIteratorSettingsFactory();

    HashSet<String> stringSet = new HashSet<>();
    stringSet.add("foo");

    HashSet<String> stringSet2 = new HashSet<>();
    stringSet2.add("foo");
    GlobalViewElementDefinition globalViewElementDefinition = mock(GlobalViewElementDefinition.class);
    when(globalViewElementDefinition.getGroupBy()).thenReturn(stringSet2);
    NamedView view = mock(NamedView.class);
    when(view.getEdge(Mockito.<String>any())).thenReturn(globalViewElementDefinition);
    when(view.getEdgeGroups()).thenReturn(stringSet);
    Schema schema = mock(Schema.class);
    when(schema.getEdge(Mockito.<String>any())).thenReturn(new SchemaEdgeDefinition());
    when(schema.getVisibilityProperty()).thenReturn("Visibility Property");
    when(schema.isAggregationEnabled()).thenReturn(true);
    AccumuloStore store = mock(AccumuloStore.class);
    when(store.getSchema()).thenReturn(schema);

    // Act
    boolean actualQueryTimeAggregatorRequiredResult = byteEntityIteratorSettingsFactory
        .queryTimeAggregatorRequired(view, store);

    // Assert
    verify(view).getEdge(eq("foo"));
    verify(schema).getEdge(eq("foo"));
    verify(view).getEdgeGroups();
    verify(globalViewElementDefinition, atLeast(1)).getGroupBy();
    verify(store).getSchema();
    verify(schema).getVisibilityProperty();
    verify(schema).isAggregationEnabled();
    assertTrue(actualQueryTimeAggregatorRequiredResult);
  }

  /**
   * Test {@link AbstractCoreKeyIteratorSettingsFactory#queryTimeAggregatorRequired(View, AccumuloStore)}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractCoreKeyIteratorSettingsFactory#queryTimeAggregatorRequired(View, AccumuloStore)}
   */
  @Test
  @DisplayName("Test queryTimeAggregatorRequired(View, AccumuloStore); then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean AbstractCoreKeyIteratorSettingsFactory.queryTimeAggregatorRequired(View, AccumuloStore)"})
  void testQueryTimeAggregatorRequired_thenThrowIllegalArgumentException() {
    // Arrange
    ByteEntityIteratorSettingsFactory byteEntityIteratorSettingsFactory = new ByteEntityIteratorSettingsFactory();
    View view = new View();
    Schema schema = mock(Schema.class);
    when(schema.getVisibilityProperty()).thenThrow(new IllegalArgumentException("foo"));
    when(schema.isAggregationEnabled()).thenReturn(true);
    AccumuloStore store = mock(AccumuloStore.class);
    when(store.getSchema()).thenReturn(schema);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> byteEntityIteratorSettingsFactory.queryTimeAggregatorRequired(view, store));
    verify(store).getSchema();
    verify(schema).getVisibilityProperty();
    verify(schema).isAggregationEnabled();
  }

  /**
   * Test {@link AbstractCoreKeyIteratorSettingsFactory#queryTimeAggregatorRequired(View, AccumuloStore)}.
   * <ul>
   *   <li>When {@link NamedView} {@link ElementDefinitions#getEdge(String)} return {@link ViewElementDefinition} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractCoreKeyIteratorSettingsFactory#queryTimeAggregatorRequired(View, AccumuloStore)}
   */
  @Test
  @DisplayName("Test queryTimeAggregatorRequired(View, AccumuloStore); when NamedView getEdge(String) return ViewElementDefinition (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean AbstractCoreKeyIteratorSettingsFactory.queryTimeAggregatorRequired(View, AccumuloStore)"})
  void testQueryTimeAggregatorRequired_whenNamedViewGetEdgeReturnViewElementDefinition() {
    // Arrange
    ByteEntityIteratorSettingsFactory byteEntityIteratorSettingsFactory = new ByteEntityIteratorSettingsFactory();

    HashSet<String> stringSet = new HashSet<>();
    stringSet.add("foo");
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
    boolean actualQueryTimeAggregatorRequiredResult = byteEntityIteratorSettingsFactory
        .queryTimeAggregatorRequired(view, store);

    // Assert
    verify(view).getEdge(eq("foo"));
    verify(schema).getEdge(eq("foo"));
    verify(view).getEdgeGroups();
    verify(view).getEntityGroups();
    verify(store).getSchema();
    verify(schema).getVisibilityProperty();
    verify(schema).isAggregationEnabled();
    assertFalse(actualQueryTimeAggregatorRequiredResult);
  }

  /**
   * Test {@link AbstractCoreKeyIteratorSettingsFactory#queryTimeAggregatorRequired(View, AccumuloStore)}.
   * <ul>
   *   <li>When {@link View} (default constructor).</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractCoreKeyIteratorSettingsFactory#queryTimeAggregatorRequired(View, AccumuloStore)}
   */
  @Test
  @DisplayName("Test queryTimeAggregatorRequired(View, AccumuloStore); when View (default constructor); then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean AbstractCoreKeyIteratorSettingsFactory.queryTimeAggregatorRequired(View, AccumuloStore)"})
  void testQueryTimeAggregatorRequired_whenView_thenReturnFalse() {
    // Arrange
    ByteEntityIteratorSettingsFactory byteEntityIteratorSettingsFactory = new ByteEntityIteratorSettingsFactory();
    View view = new View();
    Schema schema = mock(Schema.class);
    when(schema.getVisibilityProperty()).thenReturn("Visibility Property");
    when(schema.isAggregationEnabled()).thenReturn(true);
    AccumuloStore store = mock(AccumuloStore.class);
    when(store.getSchema()).thenReturn(schema);

    // Act
    boolean actualQueryTimeAggregatorRequiredResult = byteEntityIteratorSettingsFactory
        .queryTimeAggregatorRequired(view, store);

    // Assert
    verify(store).getSchema();
    verify(schema).getVisibilityProperty();
    verify(schema).isAggregationEnabled();
    assertFalse(actualQueryTimeAggregatorRequiredResult);
  }

  /**
   * Test {@link AbstractCoreKeyIteratorSettingsFactory#getIteratorSetting(AccumuloStore, String)}.
   * <ul>
   *   <li>When {@code Iterator Name}.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractCoreKeyIteratorSettingsFactory#getIteratorSetting(AccumuloStore, String)}
   */
  @Test
  @DisplayName("Test getIteratorSetting(AccumuloStore, String); when 'Iterator Name'; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "IteratorSetting AbstractCoreKeyIteratorSettingsFactory.getIteratorSetting(AccumuloStore, String)"})
  void testGetIteratorSetting_whenIteratorName_thenThrowIllegalArgumentException() throws IteratorSettingException {
    // Arrange
    ByteEntityIteratorSettingsFactory byteEntityIteratorSettingsFactory = new ByteEntityIteratorSettingsFactory();

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> byteEntityIteratorSettingsFactory.getIteratorSetting(new AccumuloStore(), "Iterator Name"));
  }
}
