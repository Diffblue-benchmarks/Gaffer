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

package uk.gov.gchq.gaffer.accumulostore.utils;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Properties;
import org.apache.accumulo.core.client.BatchWriter;
import org.apache.accumulo.core.client.BatchWriterConfig;
import org.apache.accumulo.core.client.TableExistsException;
import org.apache.accumulo.core.client.TableNotFoundException;
import org.apache.accumulo.core.clientImpl.BatchWriterImpl;
import org.apache.accumulo.core.clientImpl.ClientContext;
import org.apache.accumulo.core.clientImpl.ConnectorImpl;
import org.apache.accumulo.core.data.TableId;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import uk.gov.gchq.gaffer.accumulostore.AccumuloProperties;
import uk.gov.gchq.gaffer.accumulostore.AccumuloStore;
import uk.gov.gchq.gaffer.accumulostore.key.AccumuloRuntimeException;
import uk.gov.gchq.gaffer.store.StoreException;

class TableUtilsDiffblueTest {
  /**
   * Test {@link TableUtils#ensureTableExists(AccumuloStore)}.
   * <ul>
   *   <li>Then throw {@link AccumuloRuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TableUtils#ensureTableExists(AccumuloStore)}
   */
  @Test
  @DisplayName("Test ensureTableExists(AccumuloStore); then throw AccumuloRuntimeException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TableUtils.ensureTableExists(AccumuloStore)"})
  void testEnsureTableExists_thenThrowAccumuloRuntimeException() throws StoreException {
    // Arrange
    AccumuloStore store = mock(AccumuloStore.class);
    when(store.getConnection()).thenThrow(new AccumuloRuntimeException("An error occurred"));
    when(store.getTableName()).thenReturn("Table Name");

    // Act and Assert
    assertThrows(AccumuloRuntimeException.class, () -> TableUtils.ensureTableExists(store));
    verify(store).getConnection();
    verify(store).getTableName();
  }

  /**
   * Test {@link TableUtils#createTable(AccumuloStore)}.
   * <ul>
   *   <li>Then throw {@link AccumuloRuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TableUtils#createTable(AccumuloStore)}
   */
  @Test
  @DisplayName("Test createTable(AccumuloStore); then throw AccumuloRuntimeException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TableUtils.createTable(AccumuloStore)"})
  void testCreateTable_thenThrowAccumuloRuntimeException() throws TableExistsException, StoreException {
    // Arrange
    AccumuloStore store = mock(AccumuloStore.class);
    when(store.getConnection()).thenThrow(new AccumuloRuntimeException("An error occurred"));
    when(store.getTableName()).thenReturn("Table Name");

    // Act and Assert
    assertThrows(AccumuloRuntimeException.class, () -> TableUtils.createTable(store));
    verify(store).getConnection();
    verify(store).getTableName();
  }

  /**
   * Test {@link TableUtils#createBatchWriter(AccumuloStore)} with {@code store}.
   * <p>
   * Method under test: {@link TableUtils#createBatchWriter(AccumuloStore)}
   */
  @Test
  @DisplayName("Test createBatchWriter(AccumuloStore) with 'store'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"BatchWriter TableUtils.createBatchWriter(AccumuloStore)"})
  void testCreateBatchWriterWithStore() throws StoreException {
    // Arrange
    AccumuloStore store = mock(AccumuloStore.class);
    when(store.getConnection()).thenThrow(new AccumuloRuntimeException("An error occurred"));
    when(store.getTableName()).thenReturn("Table Name");
    when(store.getProperties()).thenReturn(new AccumuloProperties());

    // Act and Assert
    assertThrows(AccumuloRuntimeException.class, () -> TableUtils.createBatchWriter(store));
    verify(store).getConnection();
    verify(store, atLeast(1)).getProperties();
    verify(store).getTableName();
  }

  /**
   * Test {@link TableUtils#createBatchWriter(AccumuloStore)} with {@code store}.
   * <ul>
   *   <li>Then calls {@link AccumuloProperties#getMaxBufferSizeForBatchWriterInBytes()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TableUtils#createBatchWriter(AccumuloStore)}
   */
  @Test
  @DisplayName("Test createBatchWriter(AccumuloStore) with 'store'; then calls getMaxBufferSizeForBatchWriterInBytes()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"BatchWriter TableUtils.createBatchWriter(AccumuloStore)"})
  void testCreateBatchWriterWithStore_thenCallsGetMaxBufferSizeForBatchWriterInBytes()
      throws TableNotFoundException, StoreException {
    // Arrange
    AccumuloProperties accumuloProperties = mock(AccumuloProperties.class);
    when(accumuloProperties.getNumThreadsForBatchWriter())
        .thenReturn(AccumuloStoreConstants.AGGREGATOR_ITERATOR_PRIORITY);
    when(accumuloProperties.getMaxBufferSizeForBatchWriterInBytes()).thenReturn(3L);
    when(accumuloProperties.getMaxTimeOutForBatchWriterInMilliseconds()).thenReturn(0L);
    ConnectorImpl connectorImpl = mock(ConnectorImpl.class);
    when(connectorImpl.createBatchWriter(Mockito.<String>any(), Mockito.<BatchWriterConfig>any()))
        .thenThrow(new AccumuloRuntimeException("An error occurred"));
    AccumuloStore store = mock(AccumuloStore.class);
    when(store.getConnection()).thenReturn(connectorImpl);
    when(store.getTableName()).thenReturn("Table Name");
    when(store.getProperties()).thenReturn(accumuloProperties);

    // Act and Assert
    assertThrows(AccumuloRuntimeException.class, () -> TableUtils.createBatchWriter(store));
    verify(connectorImpl).createBatchWriter(eq("Table Name"), isA(BatchWriterConfig.class));
    verify(accumuloProperties).getMaxBufferSizeForBatchWriterInBytes();
    verify(accumuloProperties).getMaxTimeOutForBatchWriterInMilliseconds();
    verify(accumuloProperties).getNumThreadsForBatchWriter();
    verify(store).getConnection();
    verify(store, atLeast(1)).getProperties();
    verify(store).getTableName();
  }

  /**
   * Test {@link TableUtils#createBatchWriter(AccumuloStore)} with {@code store}.
   * <ul>
   *   <li>Then return {@link BatchWriterImpl}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TableUtils#createBatchWriter(AccumuloStore)}
   */
  @Test
  @DisplayName("Test createBatchWriter(AccumuloStore) with 'store'; then return BatchWriterImpl")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"BatchWriter TableUtils.createBatchWriter(AccumuloStore)"})
  void testCreateBatchWriterWithStore_thenReturnBatchWriterImpl() throws TableNotFoundException, StoreException {
    // Arrange
    ConnectorImpl connectorImpl = mock(ConnectorImpl.class);
    ClientContext context = new ClientContext(new Properties());
    TableId tableId = mock(TableId.class);
    when(connectorImpl.createBatchWriter(Mockito.<String>any(), Mockito.<BatchWriterConfig>any()))
        .thenReturn(new BatchWriterImpl(context, tableId, new BatchWriterConfig()));
    AccumuloStore store = mock(AccumuloStore.class);
    when(store.getConnection()).thenReturn(connectorImpl);
    when(store.getTableName()).thenReturn("Table Name");
    when(store.getProperties()).thenReturn(new AccumuloProperties());

    // Act
    BatchWriter actualCreateBatchWriterResult = TableUtils.createBatchWriter(store);

    // Assert
    verify(connectorImpl).createBatchWriter(eq("Table Name"), isA(BatchWriterConfig.class));
    verify(store).getConnection();
    verify(store, atLeast(1)).getProperties();
    verify(store).getTableName();
    assertTrue(actualCreateBatchWriterResult instanceof BatchWriterImpl);
  }

  /**
   * Test {@link TableUtils#getTableName(AccumuloProperties, String)}.
   * <ul>
   *   <li>Given {@code accumulo.namespace}.</li>
   *   <li>Then return {@code 42.42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TableUtils#getTableName(AccumuloProperties, String)}
   */
  @Test
  @DisplayName("Test getTableName(AccumuloProperties, String); given 'accumulo.namespace'; then return '42.42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String TableUtils.getTableName(AccumuloProperties, String)"})
  void testGetTableName_givenAccumuloNamespace_thenReturn4242() {
    // Arrange
    AccumuloProperties accumuloProperties = new AccumuloProperties();
    accumuloProperties.set("accumulo.namespace", "42");

    // Act and Assert
    assertEquals("42.42", TableUtils.getTableName(accumuloProperties, "42"));
  }

  /**
   * Test {@link TableUtils#getTableName(AccumuloProperties, String)}.
   * <ul>
   *   <li>When {@link AccumuloProperties#AccumuloProperties()}.</li>
   *   <li>Then return {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TableUtils#getTableName(AccumuloProperties, String)}
   */
  @Test
  @DisplayName("Test getTableName(AccumuloProperties, String); when AccumuloProperties(); then return '42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String TableUtils.getTableName(AccumuloProperties, String)"})
  void testGetTableName_whenAccumuloProperties_thenReturn42() {
    // Arrange, Act and Assert
    assertEquals("42", TableUtils.getTableName(new AccumuloProperties(), "42"));
  }
}
