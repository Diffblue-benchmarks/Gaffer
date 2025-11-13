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

package uk.gov.gchq.gaffer.accumulostore.operation.hdfs.handler.job.tool;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;
import org.apache.accumulo.core.clientImpl.ConnectorImpl;
import org.apache.accumulo.core.clientImpl.TableOperationsImpl;
import org.apache.accumulo.core.iterators.IteratorUtil;
import org.apache.accumulo.core.iterators.IteratorUtil.IteratorScope;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import uk.gov.gchq.gaffer.accumulostore.AccumuloProperties;
import uk.gov.gchq.gaffer.accumulostore.AccumuloStore;
import uk.gov.gchq.gaffer.accumulostore.key.core.impl.byteEntity.ByteEntityKeyPackage;
import uk.gov.gchq.gaffer.store.schema.Schema;

class ImportElementsToAccumuloToolDiffblueTest {
  /**
   * Test {@link ImportElementsToAccumuloTool#ImportElementsToAccumuloTool(String, String, AccumuloStore)}.
   * <p>
   * Method under test: {@link ImportElementsToAccumuloTool#ImportElementsToAccumuloTool(String, String, AccumuloStore)}
   */
  @Test
  @DisplayName("Test new ImportElementsToAccumuloTool(String, String, AccumuloStore)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void ImportElementsToAccumuloTool.<init>(String, String, AccumuloStore)"})
  void testNewImportElementsToAccumuloTool() {
    // Arrange, Act and Assert
    assertNull((new ImportElementsToAccumuloTool("Input Path", "Failure Path", new AccumuloStore())).getConf());
  }

  /**
   * Test {@link ImportElementsToAccumuloTool#ImportElementsToAccumuloTool(String, String, AccumuloStore, Map)}.
   * <p>
   * Method under test: {@link ImportElementsToAccumuloTool#ImportElementsToAccumuloTool(String, String, AccumuloStore, Map)}
   */
  @Test
  @DisplayName("Test new ImportElementsToAccumuloTool(String, String, AccumuloStore, Map)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void ImportElementsToAccumuloTool.<init>(String, String, AccumuloStore, Map)"})
  void testNewImportElementsToAccumuloTool2() {
    // Arrange
    AccumuloStore store = new AccumuloStore();

    // Act and Assert
    assertNull((new ImportElementsToAccumuloTool("Input Path", "Failure Path", store, new HashMap<>())).getConf());
  }

  /**
   * Test {@link ImportElementsToAccumuloTool#run(String[])}.
   * <p>
   * Method under test: {@link ImportElementsToAccumuloTool#run(String[])}
   */
  @Test
  @DisplayName("Test run(String[])")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int ImportElementsToAccumuloTool.run(String[])"})
  void testRun() throws Exception {
    // Arrange
    AccumuloStore store = mock(AccumuloStore.class);
    when(store.getConnection()).thenThrow(new IllegalArgumentException("Ensuring table {} exists"));
    when(store.getTableName()).thenReturn("Table Name");

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> (new ImportElementsToAccumuloTool("Input Path", "Failure Path", store)).run(new String[]{"Strings"}));
    verify(store).getConnection();
    verify(store, atLeast(1)).getTableName();
  }

  /**
   * Test {@link ImportElementsToAccumuloTool#run(String[])}.
   * <ul>
   *   <li>Given {@link TableOperationsImpl} {@link TableOperationsImpl#exists(String)} return {@code false}.</li>
   *   <li>Then calls {@link ConnectorImpl#whoami()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImportElementsToAccumuloTool#run(String[])}
   */
  @Test
  @DisplayName("Test run(String[]); given TableOperationsImpl exists(String) return 'false'; then calls whoami()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int ImportElementsToAccumuloTool.run(String[])"})
  void testRun_givenTableOperationsImplExistsReturnFalse_thenCallsWhoami() throws Exception {
    // Arrange
    TableOperationsImpl tableOperationsImpl = mock(TableOperationsImpl.class);
    when(tableOperationsImpl.exists(Mockito.<String>any())).thenReturn(false);
    doNothing().when(tableOperationsImpl)
        .removeIterator(Mockito.<String>any(), Mockito.<String>any(), Mockito.<EnumSet<IteratorScope>>any());
    doNothing().when(tableOperationsImpl).create(Mockito.<String>any());
    doNothing().when(tableOperationsImpl)
        .setProperty(Mockito.<String>any(), Mockito.<String>any(), Mockito.<String>any());
    ConnectorImpl connectorImpl = mock(ConnectorImpl.class);
    when(connectorImpl.whoami()).thenReturn("Whoami");
    when(connectorImpl.tableOperations()).thenReturn(tableOperationsImpl);
    Schema schema = mock(Schema.class);
    when(schema.getAggregatedGroups()).thenThrow(new IllegalArgumentException("Ensuring table {} exists"));
    when(schema.isAggregationEnabled()).thenReturn(true);
    AccumuloStore store = mock(AccumuloStore.class);
    when(store.getSchema()).thenReturn(schema);
    when(store.getKeyPackage()).thenReturn(new ByteEntityKeyPackage());
    when(store.getProperties()).thenReturn(new AccumuloProperties());
    when(store.getConnection()).thenReturn(connectorImpl);
    when(store.getTableName()).thenReturn("Table Name");

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> (new ImportElementsToAccumuloTool("Input Path", "Failure Path", store)).run(new String[]{"Strings"}));
    verify(connectorImpl, atLeast(1)).tableOperations();
    verify(connectorImpl).whoami();
    verify(tableOperationsImpl).removeIterator(eq("Table Name"), eq("vers"), isA(EnumSet.class));
    verify(tableOperationsImpl).create(eq("Table Name"));
    verify(tableOperationsImpl, atLeast(1)).exists(eq("Table Name"));
    verify(tableOperationsImpl, atLeast(1)).setProperty(eq("Table Name"), Mockito.<String>any(), Mockito.<String>any());
    verify(store, atLeast(1)).getConnection();
    verify(store, atLeast(1)).getKeyPackage();
    verify(store, atLeast(1)).getProperties();
    verify(store, atLeast(1)).getTableName();
    verify(store, atLeast(1)).getSchema();
    verify(schema).getAggregatedGroups();
    verify(schema).isAggregationEnabled();
  }

  /**
   * Test {@link ImportElementsToAccumuloTool#run(String[])}.
   * <ul>
   *   <li>Then calls {@link Schema#hasValidation()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImportElementsToAccumuloTool#run(String[])}
   */
  @Test
  @DisplayName("Test run(String[]); then calls hasValidation()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int ImportElementsToAccumuloTool.run(String[])"})
  void testRun_thenCallsHasValidation() throws Exception {
    // Arrange
    TableOperationsImpl tableOperationsImpl = mock(TableOperationsImpl.class);
    when(tableOperationsImpl.exists(Mockito.<String>any())).thenReturn(true);
    ConnectorImpl connectorImpl = mock(ConnectorImpl.class);
    when(connectorImpl.tableOperations()).thenReturn(tableOperationsImpl);
    Schema schema = mock(Schema.class);
    when(schema.toCompactJson()).thenThrow(new IllegalArgumentException("Ensuring table {} exists"));
    when(schema.hasValidation()).thenReturn(true);
    when(schema.isAggregationEnabled()).thenReturn(false);
    AccumuloStore store = mock(AccumuloStore.class);
    when(store.getSchema()).thenReturn(schema);
    when(store.getKeyPackage()).thenReturn(new ByteEntityKeyPackage());
    when(store.getProperties()).thenReturn(new AccumuloProperties());
    when(store.getConnection()).thenReturn(connectorImpl);
    when(store.getTableName()).thenReturn("Table Name");

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> (new ImportElementsToAccumuloTool("Input Path", "Failure Path", store)).run(new String[]{"Strings"}));
    verify(connectorImpl).tableOperations();
    verify(tableOperationsImpl).exists(eq("Table Name"));
    verify(store).getConnection();
    verify(store).getKeyPackage();
    verify(store).getProperties();
    verify(store, atLeast(1)).getTableName();
    verify(store, atLeast(1)).getSchema();
    verify(schema).hasValidation();
    verify(schema).isAggregationEnabled();
    verify(schema).toCompactJson();
  }
}
