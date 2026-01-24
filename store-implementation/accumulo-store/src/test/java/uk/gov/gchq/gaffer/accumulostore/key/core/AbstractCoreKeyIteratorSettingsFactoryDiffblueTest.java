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

package uk.gov.gchq.gaffer.accumulostore.key.core;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Map;
import org.apache.accumulo.core.client.IteratorSetting;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.accumulostore.AccumuloStore;
import uk.gov.gchq.gaffer.accumulostore.key.core.impl.byteEntity.ByteEntityIteratorSettingsFactory;
import uk.gov.gchq.gaffer.accumulostore.key.core.impl.byteEntity.ByteEntityKeyPackage;
import uk.gov.gchq.gaffer.accumulostore.key.exception.IteratorSettingException;
import uk.gov.gchq.gaffer.data.elementdefinition.exception.SchemaException;
import uk.gov.gchq.gaffer.store.schema.Schema;

class AbstractCoreKeyIteratorSettingsFactoryDiffblueTest {
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
}
