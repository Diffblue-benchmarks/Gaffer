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

package uk.gov.gchq.gaffer.accumulostore.operation.hdfs.handler.job.factory;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.apache.accumulo.core.client.AccumuloException;
import org.apache.accumulo.core.client.AccumuloSecurityException;
import org.apache.accumulo.core.client.IteratorSetting;
import org.apache.accumulo.core.client.NamespaceExistsException;
import org.apache.accumulo.core.client.TableExistsException;
import org.apache.accumulo.core.client.TableNotFoundException;
import org.apache.accumulo.core.client.admin.NamespaceOperations;
import org.apache.accumulo.core.clientImpl.ConnectorImpl;
import org.apache.accumulo.core.clientImpl.TableOperationsImpl;
import org.apache.accumulo.core.data.Key;
import org.apache.accumulo.core.data.Value;
import org.apache.accumulo.core.iterators.IteratorUtil;
import org.apache.accumulo.core.iterators.IteratorUtil.IteratorScope;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.WritableComparator;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.OutputFormat;
import org.apache.hadoop.mapreduce.Partitioner;
import org.apache.hadoop.mapreduce.Reducer;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import uk.gov.gchq.gaffer.accumulostore.AccumuloProperties;
import uk.gov.gchq.gaffer.accumulostore.AccumuloStore;
import uk.gov.gchq.gaffer.accumulostore.key.AccumuloKeyPackage;
import uk.gov.gchq.gaffer.accumulostore.key.core.impl.CoreKeyBloomFunctor;
import uk.gov.gchq.gaffer.accumulostore.key.core.impl.byteEntity.ByteEntityKeyPackage;
import uk.gov.gchq.gaffer.accumulostore.operation.hdfs.mapper.AddElementsFromHdfsMapper;
import uk.gov.gchq.gaffer.accumulostore.operation.hdfs.reducer.AccumuloKeyValueReducer;
import uk.gov.gchq.gaffer.data.elementdefinition.exception.SchemaException;
import uk.gov.gchq.gaffer.hdfs.operation.AddElementsFromHdfs;
import uk.gov.gchq.gaffer.store.Store;
import uk.gov.gchq.gaffer.store.StoreException;
import uk.gov.gchq.gaffer.store.schema.Schema;

class AccumuloAddElementsFromHdfsJobFactoryDiffblueTest {
  /**
   * Test {@link AccumuloAddElementsFromHdfsJobFactory#AccumuloAddElementsFromHdfsJobFactory()}.
   *
   * <p>Method under test: {@link
   * AccumuloAddElementsFromHdfsJobFactory#AccumuloAddElementsFromHdfsJobFactory()}
   */
  @Test
  @DisplayName("Test new AccumuloAddElementsFromHdfsJobFactory()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AccumuloAddElementsFromHdfsJobFactory.<init>()"})
  void testNewAccumuloAddElementsFromHdfsJobFactory() {
    // Arrange, Act and Assert
    assertEquals(
        "Ingest HDFS data: Generator = Mapper Generator, output = Output Path",
        new AccumuloAddElementsFromHdfsJobFactory().getJobName("Mapper Generator", "Output Path"));
  }

  /**
   * Test {@link AccumuloAddElementsFromHdfsJobFactory#prepareStore(Store)}.
   *
   * <ul>
   *   <li>Given {@link AccumuloProperties} {@link AccumuloProperties#getEnableValidatorIterator()}
   *       return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link AccumuloAddElementsFromHdfsJobFactory#prepareStore(Store)}
   */
  @Test
  @DisplayName(
      "Test prepareStore(Store); given AccumuloProperties getEnableValidatorIterator() return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AccumuloAddElementsFromHdfsJobFactory.prepareStore(Store)"})
  void testPrepareStore_givenAccumuloPropertiesGetEnableValidatorIteratorReturnTrue()
      throws AccumuloException, AccumuloSecurityException, TableExistsException,
          TableNotFoundException, StoreException {
    // Arrange
    AccumuloAddElementsFromHdfsJobFactory accumuloAddElementsFromHdfsJobFactory =
        new AccumuloAddElementsFromHdfsJobFactory();

    TableOperationsImpl tableOperationsImpl = mock(TableOperationsImpl.class);
    when(tableOperationsImpl.exists(Mockito.<String>any())).thenReturn(false);
    doNothing()
        .when(tableOperationsImpl)
        .removeIterator(
            Mockito.<String>any(), Mockito.<String>any(), Mockito.<EnumSet<IteratorScope>>any());
    doNothing().when(tableOperationsImpl).create(Mockito.<String>any());
    doNothing()
        .when(tableOperationsImpl)
        .setProperty(Mockito.<String>any(), Mockito.<String>any(), Mockito.<String>any());

    NamespaceOperations namespaceOperations = mock(NamespaceOperations.class);
    when(namespaceOperations.exists(Mockito.<String>any())).thenReturn(true);

    ConnectorImpl connectorImpl = mock(ConnectorImpl.class);
    when(connectorImpl.namespaceOperations()).thenReturn(namespaceOperations);
    when(connectorImpl.whoami()).thenReturn("Whoami");
    when(connectorImpl.tableOperations()).thenReturn(tableOperationsImpl);

    AccumuloProperties accumuloProperties = mock(AccumuloProperties.class);
    when(accumuloProperties.getNamespace()).thenReturn("not blank");
    when(accumuloProperties.getTableFileReplicationFactor())
        .thenReturn("Table File Replication Factor");
    when(accumuloProperties.getEnableValidatorIterator()).thenReturn(true);

    AccumuloKeyPackage accumuloKeyPackage = mock(AccumuloKeyPackage.class);
    when(accumuloKeyPackage.getIteratorFactory()).thenThrow(new RuntimeException());
    when(accumuloKeyPackage.getKeyFunctor()).thenReturn(new CoreKeyBloomFunctor());

    Schema schema = mock(Schema.class);
    when(schema.isAggregationEnabled()).thenReturn(false);

    AccumuloStore store = mock(AccumuloStore.class);
    when(store.getSchema()).thenReturn(schema);
    when(store.getKeyPackage()).thenReturn(accumuloKeyPackage);
    when(store.getProperties()).thenReturn(accumuloProperties);
    when(store.getConnection()).thenReturn(connectorImpl);
    when(store.getTableName()).thenReturn("Table Name");

    // Act and Assert
    assertThrows(
        RuntimeException.class, () -> accumuloAddElementsFromHdfsJobFactory.prepareStore(store));
    verify(namespaceOperations).exists("not blank");
    verify(connectorImpl).namespaceOperations();
    verify(connectorImpl, atLeast(1)).tableOperations();
    verify(connectorImpl).whoami();
    verify(tableOperationsImpl).removeIterator(eq("Table Name"), eq("vers"), isA(EnumSet.class));
    verify(tableOperationsImpl).create("Table Name");
    verify(tableOperationsImpl, atLeast(1)).exists("Table Name");
    verify(tableOperationsImpl, atLeast(1))
        .setProperty(eq("Table Name"), Mockito.<String>any(), Mockito.<String>any());
    verify(accumuloProperties).getEnableValidatorIterator();
    verify(accumuloProperties).getNamespace();
    verify(accumuloProperties).getTableFileReplicationFactor();
    verify(store, atLeast(1)).getConnection();
    verify(store, atLeast(1)).getKeyPackage();
    verify(store, atLeast(1)).getProperties();
    verify(store, atLeast(1)).getTableName();
    verify(accumuloKeyPackage).getIteratorFactory();
    verify(accumuloKeyPackage).getKeyFunctor();
    verify(store).getSchema();
    verify(schema).isAggregationEnabled();
  }

  /**
   * Test {@link AccumuloAddElementsFromHdfsJobFactory#prepareStore(Store)}.
   *
   * <ul>
   *   <li>Given {@link AccumuloProperties} {@link AccumuloProperties#getNamespace()} return empty
   *       string.
   * </ul>
   *
   * <p>Method under test: {@link AccumuloAddElementsFromHdfsJobFactory#prepareStore(Store)}
   */
  @Test
  @DisplayName(
      "Test prepareStore(Store); given AccumuloProperties getNamespace() return empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AccumuloAddElementsFromHdfsJobFactory.prepareStore(Store)"})
  void testPrepareStore_givenAccumuloPropertiesGetNamespaceReturnEmptyString()
      throws AccumuloException, AccumuloSecurityException, TableExistsException,
          TableNotFoundException, StoreException {
    // Arrange
    AccumuloAddElementsFromHdfsJobFactory accumuloAddElementsFromHdfsJobFactory =
        new AccumuloAddElementsFromHdfsJobFactory();

    TableOperationsImpl tableOperationsImpl = mock(TableOperationsImpl.class);
    when(tableOperationsImpl.exists(Mockito.<String>any())).thenReturn(false);
    doNothing()
        .when(tableOperationsImpl)
        .removeIterator(
            Mockito.<String>any(), Mockito.<String>any(), Mockito.<EnumSet<IteratorScope>>any());
    doNothing().when(tableOperationsImpl).create(Mockito.<String>any());
    doNothing()
        .when(tableOperationsImpl)
        .setLocalityGroups(Mockito.<String>any(), Mockito.<Map<String, Set<Text>>>any());
    doNothing()
        .when(tableOperationsImpl)
        .setProperty(Mockito.<String>any(), Mockito.<String>any(), Mockito.<String>any());

    ConnectorImpl connectorImpl = mock(ConnectorImpl.class);
    when(connectorImpl.whoami()).thenReturn("Whoami");
    when(connectorImpl.tableOperations()).thenReturn(tableOperationsImpl);

    AccumuloProperties accumuloProperties = mock(AccumuloProperties.class);
    when(accumuloProperties.getNamespace()).thenReturn("");
    when(accumuloProperties.getTableFileReplicationFactor())
        .thenReturn("Table File Replication Factor");
    when(accumuloProperties.getEnableValidatorIterator()).thenReturn(false);

    AccumuloKeyPackage accumuloKeyPackage = mock(AccumuloKeyPackage.class);
    when(accumuloKeyPackage.getKeyFunctor()).thenReturn(new CoreKeyBloomFunctor());

    Schema schema = mock(Schema.class);
    when(schema.getGroups()).thenReturn(new HashSet<>());
    when(schema.isAggregationEnabled()).thenReturn(false);

    AccumuloStore store = mock(AccumuloStore.class);
    when(store.getSchema()).thenReturn(schema);
    when(store.getKeyPackage()).thenReturn(accumuloKeyPackage);
    when(store.getProperties()).thenReturn(accumuloProperties);
    when(store.getConnection()).thenReturn(connectorImpl);
    when(store.getTableName()).thenReturn("Table Name");

    // Act
    accumuloAddElementsFromHdfsJobFactory.prepareStore(store);

    // Assert
    verify(connectorImpl, atLeast(1)).tableOperations();
    verify(connectorImpl).whoami();
    verify(tableOperationsImpl).removeIterator(eq("Table Name"), eq("vers"), isA(EnumSet.class));
    verify(tableOperationsImpl).create("Table Name");
    verify(tableOperationsImpl, atLeast(1)).exists("Table Name");
    verify(tableOperationsImpl).setLocalityGroups(eq("Table Name"), isA(Map.class));
    verify(tableOperationsImpl, atLeast(1))
        .setProperty(eq("Table Name"), Mockito.<String>any(), Mockito.<String>any());
    verify(accumuloProperties).getEnableValidatorIterator();
    verify(accumuloProperties).getNamespace();
    verify(accumuloProperties).getTableFileReplicationFactor();
    verify(store, atLeast(1)).getConnection();
    verify(store).getKeyPackage();
    verify(store, atLeast(1)).getProperties();
    verify(store, atLeast(1)).getTableName();
    verify(accumuloKeyPackage).getKeyFunctor();
    verify(schema).getGroups();
    verify(store, atLeast(1)).getSchema();
    verify(schema).isAggregationEnabled();
  }

  /**
   * Test {@link AccumuloAddElementsFromHdfsJobFactory#prepareStore(Store)}.
   *
   * <ul>
   *   <li>Given {@link AccumuloProperties} {@link AccumuloProperties#getNamespace()} throw {@link
   *       RuntimeException#RuntimeException()}.
   * </ul>
   *
   * <p>Method under test: {@link AccumuloAddElementsFromHdfsJobFactory#prepareStore(Store)}
   */
  @Test
  @DisplayName(
      "Test prepareStore(Store); given AccumuloProperties getNamespace() throw RuntimeException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AccumuloAddElementsFromHdfsJobFactory.prepareStore(Store)"})
  void testPrepareStore_givenAccumuloPropertiesGetNamespaceThrowRuntimeException()
      throws StoreException {
    // Arrange
    AccumuloAddElementsFromHdfsJobFactory accumuloAddElementsFromHdfsJobFactory =
        new AccumuloAddElementsFromHdfsJobFactory();

    TableOperationsImpl tableOperationsImpl = mock(TableOperationsImpl.class);
    when(tableOperationsImpl.exists(Mockito.<String>any())).thenReturn(false);

    ConnectorImpl connectorImpl = mock(ConnectorImpl.class);
    when(connectorImpl.tableOperations()).thenReturn(tableOperationsImpl);

    AccumuloProperties accumuloProperties = mock(AccumuloProperties.class);
    when(accumuloProperties.getNamespace()).thenThrow(new RuntimeException());

    AccumuloStore store = mock(AccumuloStore.class);
    when(store.getProperties()).thenReturn(accumuloProperties);
    when(store.getConnection()).thenReturn(connectorImpl);
    when(store.getTableName()).thenReturn("Table Name");

    // Act and Assert
    assertThrows(
        RuntimeException.class, () -> accumuloAddElementsFromHdfsJobFactory.prepareStore(store));
    verify(connectorImpl, atLeast(1)).tableOperations();
    verify(tableOperationsImpl, atLeast(1)).exists("Table Name");
    verify(accumuloProperties).getNamespace();
    verify(store, atLeast(1)).getConnection();
    verify(store).getProperties();
    verify(store, atLeast(1)).getTableName();
  }

  /**
   * Test {@link AccumuloAddElementsFromHdfsJobFactory#prepareStore(Store)}.
   *
   * <ul>
   *   <li>Given {@link ConnectorImpl} {@link ConnectorImpl#namespaceOperations()} throw {@link
   *       RuntimeException#RuntimeException()}.
   * </ul>
   *
   * <p>Method under test: {@link AccumuloAddElementsFromHdfsJobFactory#prepareStore(Store)}
   */
  @Test
  @DisplayName(
      "Test prepareStore(Store); given ConnectorImpl namespaceOperations() throw RuntimeException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AccumuloAddElementsFromHdfsJobFactory.prepareStore(Store)"})
  void testPrepareStore_givenConnectorImplNamespaceOperationsThrowRuntimeException()
      throws StoreException {
    // Arrange
    AccumuloAddElementsFromHdfsJobFactory accumuloAddElementsFromHdfsJobFactory =
        new AccumuloAddElementsFromHdfsJobFactory();

    TableOperationsImpl tableOperationsImpl = mock(TableOperationsImpl.class);
    when(tableOperationsImpl.exists(Mockito.<String>any())).thenReturn(false);

    ConnectorImpl connectorImpl = mock(ConnectorImpl.class);
    when(connectorImpl.namespaceOperations()).thenThrow(new RuntimeException());
    when(connectorImpl.tableOperations()).thenReturn(tableOperationsImpl);

    AccumuloProperties accumuloProperties = mock(AccumuloProperties.class);
    when(accumuloProperties.getNamespace()).thenReturn("not blank");

    AccumuloStore store = mock(AccumuloStore.class);
    when(store.getProperties()).thenReturn(accumuloProperties);
    when(store.getConnection()).thenReturn(connectorImpl);
    when(store.getTableName()).thenReturn("Table Name");

    // Act and Assert
    assertThrows(
        RuntimeException.class, () -> accumuloAddElementsFromHdfsJobFactory.prepareStore(store));
    verify(connectorImpl).namespaceOperations();
    verify(connectorImpl, atLeast(1)).tableOperations();
    verify(tableOperationsImpl, atLeast(1)).exists("Table Name");
    verify(accumuloProperties).getNamespace();
    verify(store, atLeast(1)).getConnection();
    verify(store).getProperties();
    verify(store, atLeast(1)).getTableName();
  }

  /**
   * Test {@link AccumuloAddElementsFromHdfsJobFactory#prepareStore(Store)}.
   *
   * <ul>
   *   <li>Given {@link HashSet#HashSet()} add {@code Creating table {} as user {}}.
   *   <li>Then calls {@link TableOperationsImpl#setLocalityGroups(String, Map)}.
   * </ul>
   *
   * <p>Method under test: {@link AccumuloAddElementsFromHdfsJobFactory#prepareStore(Store)}
   */
  @Test
  @DisplayName(
      "Test prepareStore(Store); given HashSet() add 'Creating table {} as user {}'; then calls setLocalityGroups(String, Map)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AccumuloAddElementsFromHdfsJobFactory.prepareStore(Store)"})
  void testPrepareStore_givenHashSetAddCreatingTableAsUser_thenCallsSetLocalityGroups()
      throws AccumuloException, AccumuloSecurityException, TableExistsException,
          TableNotFoundException, StoreException {
    // Arrange
    AccumuloAddElementsFromHdfsJobFactory accumuloAddElementsFromHdfsJobFactory =
        new AccumuloAddElementsFromHdfsJobFactory();

    TableOperationsImpl tableOperationsImpl = mock(TableOperationsImpl.class);
    when(tableOperationsImpl.exists(Mockito.<String>any())).thenReturn(false);
    doNothing()
        .when(tableOperationsImpl)
        .removeIterator(
            Mockito.<String>any(), Mockito.<String>any(), Mockito.<EnumSet<IteratorScope>>any());
    doNothing().when(tableOperationsImpl).create(Mockito.<String>any());
    doNothing()
        .when(tableOperationsImpl)
        .setLocalityGroups(Mockito.<String>any(), Mockito.<Map<String, Set<Text>>>any());
    doNothing()
        .when(tableOperationsImpl)
        .setProperty(Mockito.<String>any(), Mockito.<String>any(), Mockito.<String>any());

    NamespaceOperations namespaceOperations = mock(NamespaceOperations.class);
    when(namespaceOperations.exists(Mockito.<String>any())).thenReturn(true);

    ConnectorImpl connectorImpl = mock(ConnectorImpl.class);
    when(connectorImpl.namespaceOperations()).thenReturn(namespaceOperations);
    when(connectorImpl.whoami()).thenReturn("Whoami");
    when(connectorImpl.tableOperations()).thenReturn(tableOperationsImpl);

    AccumuloProperties accumuloProperties = mock(AccumuloProperties.class);
    when(accumuloProperties.getNamespace()).thenReturn("not blank");
    when(accumuloProperties.getTableFileReplicationFactor())
        .thenReturn("Table File Replication Factor");
    when(accumuloProperties.getEnableValidatorIterator()).thenReturn(false);

    AccumuloKeyPackage accumuloKeyPackage = mock(AccumuloKeyPackage.class);
    when(accumuloKeyPackage.getKeyFunctor()).thenReturn(new CoreKeyBloomFunctor());

    HashSet<String> stringSet = new HashSet<>();
    stringSet.add("Creating table {} as user {}");

    Schema schema = mock(Schema.class);
    when(schema.getGroups()).thenReturn(stringSet);
    when(schema.isAggregationEnabled()).thenReturn(false);

    AccumuloStore store = mock(AccumuloStore.class);
    when(store.getSchema()).thenReturn(schema);
    when(store.getKeyPackage()).thenReturn(accumuloKeyPackage);
    when(store.getProperties()).thenReturn(accumuloProperties);
    when(store.getConnection()).thenReturn(connectorImpl);
    when(store.getTableName()).thenReturn("Table Name");

    // Act
    accumuloAddElementsFromHdfsJobFactory.prepareStore(store);

    // Assert
    verify(namespaceOperations).exists("not blank");
    verify(connectorImpl).namespaceOperations();
    verify(connectorImpl, atLeast(1)).tableOperations();
    verify(connectorImpl).whoami();
    verify(tableOperationsImpl).removeIterator(eq("Table Name"), eq("vers"), isA(EnumSet.class));
    verify(tableOperationsImpl).create("Table Name");
    verify(tableOperationsImpl, atLeast(1)).exists("Table Name");
    verify(tableOperationsImpl).setLocalityGroups(eq("Table Name"), isA(Map.class));
    verify(tableOperationsImpl, atLeast(1))
        .setProperty(eq("Table Name"), Mockito.<String>any(), Mockito.<String>any());
    verify(accumuloProperties).getEnableValidatorIterator();
    verify(accumuloProperties).getNamespace();
    verify(accumuloProperties).getTableFileReplicationFactor();
    verify(store, atLeast(1)).getConnection();
    verify(store).getKeyPackage();
    verify(store, atLeast(1)).getProperties();
    verify(store, atLeast(1)).getTableName();
    verify(accumuloKeyPackage).getKeyFunctor();
    verify(schema).getGroups();
    verify(store, atLeast(1)).getSchema();
    verify(schema).isAggregationEnabled();
  }

  /**
   * Test {@link AccumuloAddElementsFromHdfsJobFactory#prepareStore(Store)}.
   *
   * <ul>
   *   <li>Given {@link NamespaceOperations} {@link NamespaceOperations#exists(String)} return
   *       {@code false}.
   *   <li>Then calls {@link NamespaceOperations#create(String)}.
   * </ul>
   *
   * <p>Method under test: {@link AccumuloAddElementsFromHdfsJobFactory#prepareStore(Store)}
   */
  @Test
  @DisplayName(
      "Test prepareStore(Store); given NamespaceOperations exists(String) return 'false'; then calls create(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AccumuloAddElementsFromHdfsJobFactory.prepareStore(Store)"})
  void testPrepareStore_givenNamespaceOperationsExistsReturnFalse_thenCallsCreate()
      throws AccumuloException, AccumuloSecurityException, NamespaceExistsException,
          TableExistsException, TableNotFoundException, StoreException {
    // Arrange
    AccumuloAddElementsFromHdfsJobFactory accumuloAddElementsFromHdfsJobFactory =
        new AccumuloAddElementsFromHdfsJobFactory();

    TableOperationsImpl tableOperationsImpl = mock(TableOperationsImpl.class);
    when(tableOperationsImpl.exists(Mockito.<String>any())).thenReturn(false);
    doNothing()
        .when(tableOperationsImpl)
        .removeIterator(
            Mockito.<String>any(), Mockito.<String>any(), Mockito.<EnumSet<IteratorScope>>any());
    doNothing().when(tableOperationsImpl).create(Mockito.<String>any());
    doNothing()
        .when(tableOperationsImpl)
        .setLocalityGroups(Mockito.<String>any(), Mockito.<Map<String, Set<Text>>>any());
    doNothing()
        .when(tableOperationsImpl)
        .setProperty(Mockito.<String>any(), Mockito.<String>any(), Mockito.<String>any());

    NamespaceOperations namespaceOperations = mock(NamespaceOperations.class);
    when(namespaceOperations.exists(Mockito.<String>any())).thenReturn(false);
    doNothing().when(namespaceOperations).create(Mockito.<String>any());

    ConnectorImpl connectorImpl = mock(ConnectorImpl.class);
    when(connectorImpl.namespaceOperations()).thenReturn(namespaceOperations);
    when(connectorImpl.whoami()).thenReturn("Whoami");
    when(connectorImpl.tableOperations()).thenReturn(tableOperationsImpl);

    AccumuloProperties accumuloProperties = mock(AccumuloProperties.class);
    when(accumuloProperties.getNamespace()).thenReturn("not blank");
    when(accumuloProperties.getTableFileReplicationFactor())
        .thenReturn("Table File Replication Factor");
    when(accumuloProperties.getEnableValidatorIterator()).thenReturn(false);

    AccumuloKeyPackage accumuloKeyPackage = mock(AccumuloKeyPackage.class);
    when(accumuloKeyPackage.getKeyFunctor()).thenReturn(new CoreKeyBloomFunctor());

    Schema schema = mock(Schema.class);
    when(schema.getGroups()).thenReturn(new HashSet<>());
    when(schema.isAggregationEnabled()).thenReturn(false);

    AccumuloStore store = mock(AccumuloStore.class);
    when(store.getSchema()).thenReturn(schema);
    when(store.getKeyPackage()).thenReturn(accumuloKeyPackage);
    when(store.getProperties()).thenReturn(accumuloProperties);
    when(store.getConnection()).thenReturn(connectorImpl);
    when(store.getTableName()).thenReturn("Table Name");

    // Act
    accumuloAddElementsFromHdfsJobFactory.prepareStore(store);

    // Assert
    verify(namespaceOperations).create("not blank");
    verify(namespaceOperations).exists("not blank");
    verify(connectorImpl, atLeast(1)).namespaceOperations();
    verify(connectorImpl, atLeast(1)).tableOperations();
    verify(connectorImpl, atLeast(1)).whoami();
    verify(tableOperationsImpl).removeIterator(eq("Table Name"), eq("vers"), isA(EnumSet.class));
    verify(tableOperationsImpl).create("Table Name");
    verify(tableOperationsImpl, atLeast(1)).exists("Table Name");
    verify(tableOperationsImpl).setLocalityGroups(eq("Table Name"), isA(Map.class));
    verify(tableOperationsImpl, atLeast(1))
        .setProperty(eq("Table Name"), Mockito.<String>any(), Mockito.<String>any());
    verify(accumuloProperties).getEnableValidatorIterator();
    verify(accumuloProperties).getNamespace();
    verify(accumuloProperties).getTableFileReplicationFactor();
    verify(store, atLeast(1)).getConnection();
    verify(store).getKeyPackage();
    verify(store, atLeast(1)).getProperties();
    verify(store, atLeast(1)).getTableName();
    verify(accumuloKeyPackage).getKeyFunctor();
    verify(schema).getGroups();
    verify(store, atLeast(1)).getSchema();
    verify(schema).isAggregationEnabled();
  }

  /**
   * Test {@link AccumuloAddElementsFromHdfsJobFactory#prepareStore(Store)}.
   *
   * <ul>
   *   <li>Given {@link Schema} {@link Schema#getGroups()} return {@link HashSet#HashSet()}.
   *   <li>Then calls {@link TableOperationsImpl#setLocalityGroups(String, Map)}.
   * </ul>
   *
   * <p>Method under test: {@link AccumuloAddElementsFromHdfsJobFactory#prepareStore(Store)}
   */
  @Test
  @DisplayName(
      "Test prepareStore(Store); given Schema getGroups() return HashSet(); then calls setLocalityGroups(String, Map)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AccumuloAddElementsFromHdfsJobFactory.prepareStore(Store)"})
  void testPrepareStore_givenSchemaGetGroupsReturnHashSet_thenCallsSetLocalityGroups()
      throws AccumuloException, AccumuloSecurityException, TableExistsException,
          TableNotFoundException, StoreException {
    // Arrange
    AccumuloAddElementsFromHdfsJobFactory accumuloAddElementsFromHdfsJobFactory =
        new AccumuloAddElementsFromHdfsJobFactory();

    TableOperationsImpl tableOperationsImpl = mock(TableOperationsImpl.class);
    when(tableOperationsImpl.exists(Mockito.<String>any())).thenReturn(false);
    doNothing()
        .when(tableOperationsImpl)
        .removeIterator(
            Mockito.<String>any(), Mockito.<String>any(), Mockito.<EnumSet<IteratorScope>>any());
    doNothing().when(tableOperationsImpl).create(Mockito.<String>any());
    doNothing()
        .when(tableOperationsImpl)
        .setLocalityGroups(Mockito.<String>any(), Mockito.<Map<String, Set<Text>>>any());
    doNothing()
        .when(tableOperationsImpl)
        .setProperty(Mockito.<String>any(), Mockito.<String>any(), Mockito.<String>any());

    NamespaceOperations namespaceOperations = mock(NamespaceOperations.class);
    when(namespaceOperations.exists(Mockito.<String>any())).thenReturn(true);

    ConnectorImpl connectorImpl = mock(ConnectorImpl.class);
    when(connectorImpl.namespaceOperations()).thenReturn(namespaceOperations);
    when(connectorImpl.whoami()).thenReturn("Whoami");
    when(connectorImpl.tableOperations()).thenReturn(tableOperationsImpl);

    AccumuloProperties accumuloProperties = mock(AccumuloProperties.class);
    when(accumuloProperties.getNamespace()).thenReturn("not blank");
    when(accumuloProperties.getTableFileReplicationFactor())
        .thenReturn("Table File Replication Factor");
    when(accumuloProperties.getEnableValidatorIterator()).thenReturn(false);

    AccumuloKeyPackage accumuloKeyPackage = mock(AccumuloKeyPackage.class);
    when(accumuloKeyPackage.getKeyFunctor()).thenReturn(new CoreKeyBloomFunctor());

    Schema schema = mock(Schema.class);
    when(schema.getGroups()).thenReturn(new HashSet<>());
    when(schema.isAggregationEnabled()).thenReturn(false);

    AccumuloStore store = mock(AccumuloStore.class);
    when(store.getSchema()).thenReturn(schema);
    when(store.getKeyPackage()).thenReturn(accumuloKeyPackage);
    when(store.getProperties()).thenReturn(accumuloProperties);
    when(store.getConnection()).thenReturn(connectorImpl);
    when(store.getTableName()).thenReturn("Table Name");

    // Act
    accumuloAddElementsFromHdfsJobFactory.prepareStore(store);

    // Assert
    verify(namespaceOperations).exists("not blank");
    verify(connectorImpl).namespaceOperations();
    verify(connectorImpl, atLeast(1)).tableOperations();
    verify(connectorImpl).whoami();
    verify(tableOperationsImpl).removeIterator(eq("Table Name"), eq("vers"), isA(EnumSet.class));
    verify(tableOperationsImpl).create("Table Name");
    verify(tableOperationsImpl, atLeast(1)).exists("Table Name");
    verify(tableOperationsImpl).setLocalityGroups(eq("Table Name"), isA(Map.class));
    verify(tableOperationsImpl, atLeast(1))
        .setProperty(eq("Table Name"), Mockito.<String>any(), Mockito.<String>any());
    verify(accumuloProperties).getEnableValidatorIterator();
    verify(accumuloProperties).getNamespace();
    verify(accumuloProperties).getTableFileReplicationFactor();
    verify(store, atLeast(1)).getConnection();
    verify(store).getKeyPackage();
    verify(store, atLeast(1)).getProperties();
    verify(store, atLeast(1)).getTableName();
    verify(accumuloKeyPackage).getKeyFunctor();
    verify(schema).getGroups();
    verify(store, atLeast(1)).getSchema();
    verify(schema).isAggregationEnabled();
  }

  /**
   * Test {@link AccumuloAddElementsFromHdfsJobFactory#prepareStore(Store)}.
   *
   * <ul>
   *   <li>Given {@link Schema} {@link Schema#getGroups()} throw {@link
   *       RuntimeException#RuntimeException()}.
   *   <li>Then calls {@link Schema#getGroups()}.
   * </ul>
   *
   * <p>Method under test: {@link AccumuloAddElementsFromHdfsJobFactory#prepareStore(Store)}
   */
  @Test
  @DisplayName(
      "Test prepareStore(Store); given Schema getGroups() throw RuntimeException(); then calls getGroups()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AccumuloAddElementsFromHdfsJobFactory.prepareStore(Store)"})
  void testPrepareStore_givenSchemaGetGroupsThrowRuntimeException_thenCallsGetGroups()
      throws AccumuloException, AccumuloSecurityException, TableExistsException,
          TableNotFoundException, StoreException {
    // Arrange
    AccumuloAddElementsFromHdfsJobFactory accumuloAddElementsFromHdfsJobFactory =
        new AccumuloAddElementsFromHdfsJobFactory();

    TableOperationsImpl tableOperationsImpl = mock(TableOperationsImpl.class);
    when(tableOperationsImpl.exists(Mockito.<String>any())).thenReturn(false);
    doNothing()
        .when(tableOperationsImpl)
        .removeIterator(
            Mockito.<String>any(), Mockito.<String>any(), Mockito.<EnumSet<IteratorScope>>any());
    doNothing().when(tableOperationsImpl).create(Mockito.<String>any());
    doNothing()
        .when(tableOperationsImpl)
        .setProperty(Mockito.<String>any(), Mockito.<String>any(), Mockito.<String>any());

    NamespaceOperations namespaceOperations = mock(NamespaceOperations.class);
    when(namespaceOperations.exists(Mockito.<String>any())).thenReturn(true);

    ConnectorImpl connectorImpl = mock(ConnectorImpl.class);
    when(connectorImpl.namespaceOperations()).thenReturn(namespaceOperations);
    when(connectorImpl.whoami()).thenReturn("Whoami");
    when(connectorImpl.tableOperations()).thenReturn(tableOperationsImpl);

    AccumuloProperties accumuloProperties = mock(AccumuloProperties.class);
    when(accumuloProperties.getNamespace()).thenReturn("not blank");
    when(accumuloProperties.getTableFileReplicationFactor())
        .thenReturn("Table File Replication Factor");
    when(accumuloProperties.getEnableValidatorIterator()).thenReturn(false);

    AccumuloKeyPackage accumuloKeyPackage = mock(AccumuloKeyPackage.class);
    when(accumuloKeyPackage.getKeyFunctor()).thenReturn(new CoreKeyBloomFunctor());

    Schema schema = mock(Schema.class);
    when(schema.getGroups()).thenThrow(new RuntimeException());
    when(schema.isAggregationEnabled()).thenReturn(false);

    AccumuloStore store = mock(AccumuloStore.class);
    when(store.getSchema()).thenReturn(schema);
    when(store.getKeyPackage()).thenReturn(accumuloKeyPackage);
    when(store.getProperties()).thenReturn(accumuloProperties);
    when(store.getConnection()).thenReturn(connectorImpl);
    when(store.getTableName()).thenReturn("Table Name");

    // Act and Assert
    assertThrows(
        RuntimeException.class, () -> accumuloAddElementsFromHdfsJobFactory.prepareStore(store));
    verify(namespaceOperations).exists("not blank");
    verify(connectorImpl).namespaceOperations();
    verify(connectorImpl, atLeast(1)).tableOperations();
    verify(connectorImpl).whoami();
    verify(tableOperationsImpl).removeIterator(eq("Table Name"), eq("vers"), isA(EnumSet.class));
    verify(tableOperationsImpl).create("Table Name");
    verify(tableOperationsImpl, atLeast(1)).exists("Table Name");
    verify(tableOperationsImpl, atLeast(1))
        .setProperty(eq("Table Name"), Mockito.<String>any(), Mockito.<String>any());
    verify(accumuloProperties).getEnableValidatorIterator();
    verify(accumuloProperties).getNamespace();
    verify(accumuloProperties).getTableFileReplicationFactor();
    verify(store, atLeast(1)).getConnection();
    verify(store).getKeyPackage();
    verify(store, atLeast(1)).getProperties();
    verify(store, atLeast(1)).getTableName();
    verify(accumuloKeyPackage).getKeyFunctor();
    verify(schema).getGroups();
    verify(store, atLeast(1)).getSchema();
    verify(schema).isAggregationEnabled();
  }

  /**
   * Test {@link AccumuloAddElementsFromHdfsJobFactory#prepareStore(Store)}.
   *
   * <ul>
   *   <li>Given {@link TableOperationsImpl} {@link TableOperationsImpl#getIteratorSetting(String,
   *       String, IteratorScope)} throw {@link RuntimeException#RuntimeException()}.
   * </ul>
   *
   * <p>Method under test: {@link AccumuloAddElementsFromHdfsJobFactory#prepareStore(Store)}
   */
  @Test
  @DisplayName(
      "Test prepareStore(Store); given TableOperationsImpl getIteratorSetting(String, String, IteratorScope) throw RuntimeException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AccumuloAddElementsFromHdfsJobFactory.prepareStore(Store)"})
  void testPrepareStore_givenTableOperationsImplGetIteratorSettingThrowRuntimeException()
      throws AccumuloException, TableNotFoundException, StoreException {
    // Arrange
    AccumuloAddElementsFromHdfsJobFactory accumuloAddElementsFromHdfsJobFactory =
        new AccumuloAddElementsFromHdfsJobFactory();

    TableOperationsImpl tableOperationsImpl = mock(TableOperationsImpl.class);
    when(tableOperationsImpl.getIteratorSetting(
            Mockito.<String>any(), Mockito.<String>any(), Mockito.<IteratorScope>any()))
        .thenThrow(new RuntimeException());
    when(tableOperationsImpl.exists(Mockito.<String>any())).thenReturn(true);

    ConnectorImpl connectorImpl = mock(ConnectorImpl.class);
    when(connectorImpl.tableOperations()).thenReturn(tableOperationsImpl);

    AccumuloStore store = mock(AccumuloStore.class);
    when(store.getSchema()).thenReturn(new Schema());
    when(store.getKeyPackage()).thenReturn(new ByteEntityKeyPackage());
    when(store.getProperties()).thenReturn(new AccumuloProperties());
    when(store.getConnection()).thenReturn(connectorImpl);
    when(store.getTableName()).thenReturn("Table Name");

    // Act and Assert
    assertThrows(
        RuntimeException.class, () -> accumuloAddElementsFromHdfsJobFactory.prepareStore(store));
    verify(connectorImpl, atLeast(1)).tableOperations();
    verify(tableOperationsImpl).getIteratorSetting("Table Name", "Aggregator", IteratorScope.majc);
    verify(tableOperationsImpl).exists("Table Name");
    verify(store, atLeast(1)).getConnection();
    verify(store).getKeyPackage();
    verify(store).getProperties();
    verify(store).getTableName();
    verify(store, atLeast(1)).getSchema();
  }

  /**
   * Test {@link AccumuloAddElementsFromHdfsJobFactory#prepareStore(Store)}.
   *
   * <ul>
   *   <li>Then calls {@link Schema#getAggregatedGroups()}.
   * </ul>
   *
   * <p>Method under test: {@link AccumuloAddElementsFromHdfsJobFactory#prepareStore(Store)}
   */
  @Test
  @DisplayName("Test prepareStore(Store); then calls getAggregatedGroups()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AccumuloAddElementsFromHdfsJobFactory.prepareStore(Store)"})
  void testPrepareStore_thenCallsGetAggregatedGroups() throws SchemaException, StoreException {
    // Arrange
    AccumuloAddElementsFromHdfsJobFactory accumuloAddElementsFromHdfsJobFactory =
        new AccumuloAddElementsFromHdfsJobFactory();

    TableOperationsImpl tableOperationsImpl = mock(TableOperationsImpl.class);
    when(tableOperationsImpl.exists(Mockito.<String>any())).thenReturn(true);

    ConnectorImpl connectorImpl = mock(ConnectorImpl.class);
    when(connectorImpl.tableOperations()).thenReturn(tableOperationsImpl);

    Schema schema = mock(Schema.class);
    when(schema.getAggregatedGroups()).thenReturn(new ArrayList<>());
    when(schema.toCompactJson()).thenThrow(new RuntimeException());
    when(schema.isAggregationEnabled()).thenReturn(true);

    AccumuloStore store = mock(AccumuloStore.class);
    when(store.getSchema()).thenReturn(schema);
    when(store.getKeyPackage()).thenReturn(new ByteEntityKeyPackage());
    when(store.getConnection()).thenReturn(connectorImpl);
    when(store.getTableName()).thenReturn("Table Name");

    // Act and Assert
    assertThrows(
        RuntimeException.class, () -> accumuloAddElementsFromHdfsJobFactory.prepareStore(store));
    verify(connectorImpl).tableOperations();
    verify(tableOperationsImpl).exists("Table Name");
    verify(store).getConnection();
    verify(store).getKeyPackage();
    verify(store).getTableName();
    verify(store, atLeast(1)).getSchema();
    verify(schema).getAggregatedGroups();
    verify(schema).isAggregationEnabled();
    verify(schema).toCompactJson();
  }

  /**
   * Test {@link AccumuloAddElementsFromHdfsJobFactory#prepareStore(Store)}.
   *
   * <ul>
   *   <li>Then calls {@link Schema#getAggregatedGroups()}.
   * </ul>
   *
   * <p>Method under test: {@link AccumuloAddElementsFromHdfsJobFactory#prepareStore(Store)}
   */
  @Test
  @DisplayName("Test prepareStore(Store); then calls getAggregatedGroups()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AccumuloAddElementsFromHdfsJobFactory.prepareStore(Store)"})
  void testPrepareStore_thenCallsGetAggregatedGroups2()
      throws AccumuloException, AccumuloSecurityException, TableExistsException,
          TableNotFoundException, SchemaException, StoreException {
    // Arrange
    AccumuloAddElementsFromHdfsJobFactory accumuloAddElementsFromHdfsJobFactory =
        new AccumuloAddElementsFromHdfsJobFactory();

    TableOperationsImpl tableOperationsImpl = mock(TableOperationsImpl.class);
    when(tableOperationsImpl.exists(Mockito.<String>any())).thenReturn(false);
    doNothing()
        .when(tableOperationsImpl)
        .removeIterator(
            Mockito.<String>any(), Mockito.<String>any(), Mockito.<EnumSet<IteratorScope>>any());
    doNothing().when(tableOperationsImpl).create(Mockito.<String>any());
    doNothing()
        .when(tableOperationsImpl)
        .setProperty(Mockito.<String>any(), Mockito.<String>any(), Mockito.<String>any());

    NamespaceOperations namespaceOperations = mock(NamespaceOperations.class);
    when(namespaceOperations.exists(Mockito.<String>any())).thenReturn(true);

    ConnectorImpl connectorImpl = mock(ConnectorImpl.class);
    when(connectorImpl.namespaceOperations()).thenReturn(namespaceOperations);
    when(connectorImpl.whoami()).thenReturn("Whoami");
    when(connectorImpl.tableOperations()).thenReturn(tableOperationsImpl);

    AccumuloProperties accumuloProperties = mock(AccumuloProperties.class);
    when(accumuloProperties.getNamespace()).thenReturn("not blank");
    when(accumuloProperties.getTableFileReplicationFactor())
        .thenReturn("Table File Replication Factor");

    Schema schema = mock(Schema.class);
    when(schema.getAggregatedGroups()).thenReturn(new ArrayList<>());
    when(schema.toCompactJson()).thenThrow(new RuntimeException());
    when(schema.isAggregationEnabled()).thenReturn(true);

    AccumuloStore store = mock(AccumuloStore.class);
    when(store.getSchema()).thenReturn(schema);
    when(store.getKeyPackage()).thenReturn(new ByteEntityKeyPackage());
    when(store.getProperties()).thenReturn(accumuloProperties);
    when(store.getConnection()).thenReturn(connectorImpl);
    when(store.getTableName()).thenReturn("Table Name");

    // Act and Assert
    assertThrows(
        RuntimeException.class, () -> accumuloAddElementsFromHdfsJobFactory.prepareStore(store));
    verify(namespaceOperations).exists("not blank");
    verify(connectorImpl).namespaceOperations();
    verify(connectorImpl, atLeast(1)).tableOperations();
    verify(connectorImpl).whoami();
    verify(tableOperationsImpl).removeIterator(eq("Table Name"), eq("vers"), isA(EnumSet.class));
    verify(tableOperationsImpl).create("Table Name");
    verify(tableOperationsImpl, atLeast(1)).exists("Table Name");
    verify(tableOperationsImpl, atLeast(1))
        .setProperty(eq("Table Name"), Mockito.<String>any(), Mockito.<String>any());
    verify(accumuloProperties).getNamespace();
    verify(accumuloProperties).getTableFileReplicationFactor();
    verify(store, atLeast(1)).getConnection();
    verify(store, atLeast(1)).getKeyPackage();
    verify(store, atLeast(1)).getProperties();
    verify(store, atLeast(1)).getTableName();
    verify(store, atLeast(1)).getSchema();
    verify(schema).getAggregatedGroups();
    verify(schema).isAggregationEnabled();
    verify(schema).toCompactJson();
  }

  /**
   * Test {@link AccumuloAddElementsFromHdfsJobFactory#prepareStore(Store)}.
   *
   * <ul>
   *   <li>Then calls {@link AccumuloKeyPackage#getIteratorFactory()}.
   * </ul>
   *
   * <p>Method under test: {@link AccumuloAddElementsFromHdfsJobFactory#prepareStore(Store)}
   */
  @Test
  @DisplayName("Test prepareStore(Store); then calls getIteratorFactory()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AccumuloAddElementsFromHdfsJobFactory.prepareStore(Store)"})
  void testPrepareStore_thenCallsGetIteratorFactory()
      throws AccumuloException, AccumuloSecurityException, TableExistsException,
          TableNotFoundException, StoreException {
    // Arrange
    AccumuloAddElementsFromHdfsJobFactory accumuloAddElementsFromHdfsJobFactory =
        new AccumuloAddElementsFromHdfsJobFactory();

    TableOperationsImpl tableOperationsImpl = mock(TableOperationsImpl.class);
    when(tableOperationsImpl.exists(Mockito.<String>any())).thenReturn(false);
    doNothing()
        .when(tableOperationsImpl)
        .removeIterator(
            Mockito.<String>any(), Mockito.<String>any(), Mockito.<EnumSet<IteratorScope>>any());
    doNothing().when(tableOperationsImpl).create(Mockito.<String>any());
    doNothing()
        .when(tableOperationsImpl)
        .setProperty(Mockito.<String>any(), Mockito.<String>any(), Mockito.<String>any());

    NamespaceOperations namespaceOperations = mock(NamespaceOperations.class);
    when(namespaceOperations.exists(Mockito.<String>any())).thenReturn(true);

    ConnectorImpl connectorImpl = mock(ConnectorImpl.class);
    when(connectorImpl.namespaceOperations()).thenReturn(namespaceOperations);
    when(connectorImpl.whoami()).thenReturn("Whoami");
    when(connectorImpl.tableOperations()).thenReturn(tableOperationsImpl);

    AccumuloProperties accumuloProperties = mock(AccumuloProperties.class);
    when(accumuloProperties.getNamespace()).thenReturn("not blank");
    when(accumuloProperties.getTableFileReplicationFactor())
        .thenReturn("Table File Replication Factor");

    AccumuloKeyPackage accumuloKeyPackage = mock(AccumuloKeyPackage.class);
    when(accumuloKeyPackage.getIteratorFactory()).thenThrow(new RuntimeException());
    when(accumuloKeyPackage.getKeyFunctor()).thenReturn(new CoreKeyBloomFunctor());

    Schema schema = mock(Schema.class);
    when(schema.isAggregationEnabled()).thenReturn(true);

    AccumuloStore store = mock(AccumuloStore.class);
    when(store.getSchema()).thenReturn(schema);
    when(store.getKeyPackage()).thenReturn(accumuloKeyPackage);
    when(store.getProperties()).thenReturn(accumuloProperties);
    when(store.getConnection()).thenReturn(connectorImpl);
    when(store.getTableName()).thenReturn("Table Name");

    // Act and Assert
    assertThrows(
        RuntimeException.class, () -> accumuloAddElementsFromHdfsJobFactory.prepareStore(store));
    verify(namespaceOperations).exists("not blank");
    verify(connectorImpl).namespaceOperations();
    verify(connectorImpl, atLeast(1)).tableOperations();
    verify(connectorImpl).whoami();
    verify(tableOperationsImpl).removeIterator(eq("Table Name"), eq("vers"), isA(EnumSet.class));
    verify(tableOperationsImpl).create("Table Name");
    verify(tableOperationsImpl, atLeast(1)).exists("Table Name");
    verify(tableOperationsImpl, atLeast(1))
        .setProperty(eq("Table Name"), Mockito.<String>any(), Mockito.<String>any());
    verify(accumuloProperties).getNamespace();
    verify(accumuloProperties).getTableFileReplicationFactor();
    verify(store, atLeast(1)).getConnection();
    verify(store, atLeast(1)).getKeyPackage();
    verify(store, atLeast(1)).getProperties();
    verify(store, atLeast(1)).getTableName();
    verify(accumuloKeyPackage).getIteratorFactory();
    verify(accumuloKeyPackage).getKeyFunctor();
    verify(store).getSchema();
    verify(schema).isAggregationEnabled();
  }

  /**
   * Test {@link AccumuloAddElementsFromHdfsJobFactory#prepareStore(Store)}.
   *
   * <ul>
   *   <li>Then calls {@link IteratorSetting#removeOption(String)}.
   * </ul>
   *
   * <p>Method under test: {@link AccumuloAddElementsFromHdfsJobFactory#prepareStore(Store)}
   */
  @Test
  @DisplayName("Test prepareStore(Store); then calls removeOption(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AccumuloAddElementsFromHdfsJobFactory.prepareStore(Store)"})
  void testPrepareStore_thenCallsRemoveOption()
      throws AccumuloException, TableNotFoundException, StoreException {
    // Arrange
    AccumuloAddElementsFromHdfsJobFactory accumuloAddElementsFromHdfsJobFactory =
        new AccumuloAddElementsFromHdfsJobFactory();

    IteratorSetting iteratorSetting = mock(IteratorSetting.class);
    when(iteratorSetting.removeOption(Mockito.<String>any())).thenThrow(new RuntimeException());

    TableOperationsImpl tableOperationsImpl = mock(TableOperationsImpl.class);
    when(tableOperationsImpl.getIteratorSetting(
            Mockito.<String>any(), Mockito.<String>any(), Mockito.<IteratorScope>any()))
        .thenReturn(iteratorSetting);
    when(tableOperationsImpl.exists(Mockito.<String>any())).thenReturn(true);

    ConnectorImpl connectorImpl = mock(ConnectorImpl.class);
    when(connectorImpl.tableOperations()).thenReturn(tableOperationsImpl);

    AccumuloProperties accumuloProperties = mock(AccumuloProperties.class);
    when(accumuloProperties.getEnableValidatorIterator()).thenReturn(false);

    Schema schema = mock(Schema.class);
    when(schema.isAggregationEnabled()).thenReturn(false);

    AccumuloStore store = mock(AccumuloStore.class);
    when(store.getSchema()).thenReturn(schema);
    when(store.getProperties()).thenReturn(accumuloProperties);
    when(store.getConnection()).thenReturn(connectorImpl);
    when(store.getTableName()).thenReturn("Table Name");

    // Act and Assert
    assertThrows(
        RuntimeException.class, () -> accumuloAddElementsFromHdfsJobFactory.prepareStore(store));
    verify(iteratorSetting).removeOption("Schema");
    verify(connectorImpl, atLeast(1)).tableOperations();
    verify(tableOperationsImpl).getIteratorSetting("Table Name", "Aggregator", IteratorScope.majc);
    verify(tableOperationsImpl).exists("Table Name");
    verify(accumuloProperties).getEnableValidatorIterator();
    verify(store, atLeast(1)).getConnection();
    verify(store).getProperties();
    verify(store).getTableName();
    verify(store).getSchema();
    verify(schema).isAggregationEnabled();
  }

  /**
   * Test {@link AccumuloAddElementsFromHdfsJobFactory#prepareStore(Store)}.
   *
   * <ul>
   *   <li>Then throw {@link StoreException}.
   * </ul>
   *
   * <p>Method under test: {@link AccumuloAddElementsFromHdfsJobFactory#prepareStore(Store)}
   */
  @Test
  @DisplayName("Test prepareStore(Store); then throw StoreException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AccumuloAddElementsFromHdfsJobFactory.prepareStore(Store)"})
  void testPrepareStore_thenThrowStoreException() throws StoreException {
    // Arrange
    AccumuloAddElementsFromHdfsJobFactory accumuloAddElementsFromHdfsJobFactory =
        new AccumuloAddElementsFromHdfsJobFactory();

    AccumuloStore store = mock(AccumuloStore.class);
    when(store.getConnection()).thenThrow(new StoreException("An error occurred"));
    when(store.getTableName()).thenReturn("Table Name");

    // Act and Assert
    assertThrows(
        StoreException.class, () -> accumuloAddElementsFromHdfsJobFactory.prepareStore(store));
    verify(store).getConnection();
    verify(store).getTableName();
  }

  /**
   * Test {@link AccumuloAddElementsFromHdfsJobFactory#getJobName(String, String)}.
   *
   * <p>Method under test: {@link AccumuloAddElementsFromHdfsJobFactory#getJobName(String, String)}
   */
  @Test
  @DisplayName("Test getJobName(String, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String AccumuloAddElementsFromHdfsJobFactory.getJobName(String, String)"})
  void testGetJobName() {
    // Arrange, Act and Assert
    assertEquals(
        "Ingest HDFS data: Generator = Mapper Generator, output = Output Path",
        new AccumuloAddElementsFromHdfsJobFactory().getJobName("Mapper Generator", "Output Path"));
  }

  /**
   * Test {@link AccumuloAddElementsFromHdfsJobFactory#setupJob(Job, AddElementsFromHdfs, String,
   * Store)} with {@code Job}, {@code AddElementsFromHdfs}, {@code String}, {@code Store}.
   *
   * <p>Method under test: {@link AccumuloAddElementsFromHdfsJobFactory#setupJob(Job,
   * AddElementsFromHdfs, String, Store)}
   */
  @Test
  @DisplayName(
      "Test setupJob(Job, AddElementsFromHdfs, String, Store) with 'Job', 'AddElementsFromHdfs', 'String', 'Store'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AccumuloAddElementsFromHdfsJobFactory.setupJob(Job, AddElementsFromHdfs, String, Store)"
  })
  void testSetupJobWithJobAddElementsFromHdfsStringStore()
      throws IOException, IllegalStateException {
    // Arrange
    AccumuloAddElementsFromHdfsJobFactory accumuloAddElementsFromHdfsJobFactory =
        new AccumuloAddElementsFromHdfsJobFactory();

    Job job = mock(Job.class);
    when(job.getConfiguration()).thenThrow(new RuntimeException());
    doNothing()
        .when(job)
        .setCombinerClass(Mockito.<Class<Reducer<Object, Object, Object, Object>>>any());
    doNothing().when(job).setJarByClass(Mockito.<Class<?>>any());
    doNothing().when(job).setJobName(Mockito.<String>any());
    doNothing().when(job).setMapOutputKeyClass(Mockito.<Class<?>>any());
    doNothing().when(job).setMapOutputValueClass(Mockito.<Class<?>>any());
    doNothing()
        .when(job)
        .setMapperClass(Mockito.<Class<Mapper<Object, Object, Object, Object>>>any());
    doNothing().when(job).setOutputFormatClass(Mockito.<Class<OutputFormat<Object, Object>>>any());
    doNothing().when(job).setOutputKeyClass(Mockito.<Class<?>>any());
    doNothing().when(job).setOutputValueClass(Mockito.<Class<?>>any());
    doNothing()
        .when(job)
        .setReducerClass(Mockito.<Class<Reducer<Object, Object, Object, Object>>>any());

    AddElementsFromHdfs operation = mock(AddElementsFromHdfs.class);
    when(operation.getOutputPath()).thenReturn("Output Path");

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            accumuloAddElementsFromHdfsJobFactory.setupJob(
                job, operation, "Mapper Generator", new AccumuloStore()));
    verify(job).setCombinerClass(isA(Class.class));
    verify(job).setJarByClass(isA(Class.class));
    verify(job).setJobName("Ingest HDFS data: Generator = Mapper Generator, output = Output Path");
    verify(job).setMapOutputKeyClass(isA(Class.class));
    verify(job).setMapOutputValueClass(isA(Class.class));
    verify(job).setMapperClass(isA(Class.class));
    verify(job).setOutputFormatClass(isA(Class.class));
    verify(job).setOutputKeyClass(isA(Class.class));
    verify(job).setOutputValueClass(isA(Class.class));
    verify(job).setReducerClass(isA(Class.class));
    verify(job).getConfiguration();
    verify(operation, atLeast(1)).getOutputPath();
  }

  /**
   * Test {@link AccumuloAddElementsFromHdfsJobFactory#setupJob(Job, AddElementsFromHdfs, String,
   * Store)} with {@code Job}, {@code AddElementsFromHdfs}, {@code String}, {@code Store}.
   *
   * <p>Method under test: {@link AccumuloAddElementsFromHdfsJobFactory#setupJob(Job,
   * AddElementsFromHdfs, String, Store)}
   */
  @Test
  @DisplayName(
      "Test setupJob(Job, AddElementsFromHdfs, String, Store) with 'Job', 'AddElementsFromHdfs', 'String', 'Store'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AccumuloAddElementsFromHdfsJobFactory.setupJob(Job, AddElementsFromHdfs, String, Store)"
  })
  void testSetupJobWithJobAddElementsFromHdfsStringStore2()
      throws IOException, IllegalStateException {
    // Arrange
    AccumuloAddElementsFromHdfsJobFactory accumuloAddElementsFromHdfsJobFactory =
        new AccumuloAddElementsFromHdfsJobFactory();

    Job job = mock(Job.class);
    when(job.getConfiguration()).thenReturn(new Configuration());
    doNothing()
        .when(job)
        .setCombinerClass(Mockito.<Class<Reducer<Object, Object, Object, Object>>>any());
    doNothing().when(job).setJarByClass(Mockito.<Class<?>>any());
    doNothing().when(job).setJobName(Mockito.<String>any());
    doNothing().when(job).setMapOutputKeyClass(Mockito.<Class<?>>any());
    doNothing().when(job).setMapOutputValueClass(Mockito.<Class<?>>any());
    doNothing()
        .when(job)
        .setMapperClass(Mockito.<Class<Mapper<Object, Object, Object, Object>>>any());
    doNothing().when(job).setOutputFormatClass(Mockito.<Class<OutputFormat<Object, Object>>>any());
    doNothing().when(job).setOutputKeyClass(Mockito.<Class<?>>any());
    doNothing().when(job).setOutputValueClass(Mockito.<Class<?>>any());
    doNothing()
        .when(job)
        .setReducerClass(Mockito.<Class<Reducer<Object, Object, Object, Object>>>any());

    AddElementsFromHdfs operation = mock(AddElementsFromHdfs.class);
    Mockito.<Class<? extends Partitioner>>when(operation.getPartitioner())
        .thenThrow(new RuntimeException());
    when(operation.getOutputPath()).thenReturn("Output Path");

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            accumuloAddElementsFromHdfsJobFactory.setupJob(
                job, operation, "Mapper Generator", new AccumuloStore()));
    verify(job).setCombinerClass(isA(Class.class));
    verify(job).setJarByClass(isA(Class.class));
    verify(job).setJobName("Ingest HDFS data: Generator = Mapper Generator, output = Output Path");
    verify(job).setMapOutputKeyClass(isA(Class.class));
    verify(job).setMapOutputValueClass(isA(Class.class));
    verify(job).setMapperClass(isA(Class.class));
    verify(job).setOutputFormatClass(isA(Class.class));
    verify(job).setOutputKeyClass(isA(Class.class));
    verify(job).setOutputValueClass(isA(Class.class));
    verify(job).setReducerClass(isA(Class.class));
    verify(job, atLeast(1)).getConfiguration();
    verify(operation, atLeast(1)).getOutputPath();
    verify(operation).getPartitioner();
  }

  /**
   * Test {@link AccumuloAddElementsFromHdfsJobFactory#setupJob(Job, AddElementsFromHdfs, String,
   * Store)} with {@code Job}, {@code AddElementsFromHdfs}, {@code String}, {@code Store}.
   *
   * <ul>
   *   <li>Then calls {@link Configuration#addResource(String)}.
   * </ul>
   *
   * <p>Method under test: {@link AccumuloAddElementsFromHdfsJobFactory#setupJob(Job,
   * AddElementsFromHdfs, String, Store)}
   */
  @Test
  @DisplayName(
      "Test setupJob(Job, AddElementsFromHdfs, String, Store) with 'Job', 'AddElementsFromHdfs', 'String', 'Store'; then calls addResource(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AccumuloAddElementsFromHdfsJobFactory.setupJob(Job, AddElementsFromHdfs, String, Store)"
  })
  void testSetupJobWithJobAddElementsFromHdfsStringStore_thenCallsAddResource()
      throws IOException, IllegalStateException {
    // Arrange
    AccumuloAddElementsFromHdfsJobFactory accumuloAddElementsFromHdfsJobFactory =
        new AccumuloAddElementsFromHdfsJobFactory();

    Configuration configuration = mock(Configuration.class);
    when(configuration.getBoolean(Mockito.<String>any(), anyBoolean()))
        .thenThrow(new RuntimeException());
    when(configuration.get(Mockito.<String>any(), Mockito.<String>any())).thenReturn("Get");
    doNothing().when(configuration).addResource(Mockito.<String>any());
    configuration.addResource("///");

    Job job = mock(Job.class);
    when(job.getConfiguration()).thenReturn(configuration);
    doNothing()
        .when(job)
        .setCombinerClass(Mockito.<Class<Reducer<Object, Object, Object, Object>>>any());
    doNothing().when(job).setJarByClass(Mockito.<Class<?>>any());
    doNothing().when(job).setJobName(Mockito.<String>any());
    doNothing().when(job).setMapOutputKeyClass(Mockito.<Class<?>>any());
    doNothing().when(job).setMapOutputValueClass(Mockito.<Class<?>>any());
    doNothing()
        .when(job)
        .setMapperClass(Mockito.<Class<Mapper<Object, Object, Object, Object>>>any());
    doNothing().when(job).setOutputFormatClass(Mockito.<Class<OutputFormat<Object, Object>>>any());
    doNothing().when(job).setOutputKeyClass(Mockito.<Class<?>>any());
    doNothing().when(job).setOutputValueClass(Mockito.<Class<?>>any());
    doNothing()
        .when(job)
        .setReducerClass(Mockito.<Class<Reducer<Object, Object, Object, Object>>>any());

    AddElementsFromHdfs operation = mock(AddElementsFromHdfs.class);
    when(operation.getOutputPath()).thenReturn("Output Path");

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            accumuloAddElementsFromHdfsJobFactory.setupJob(
                job, operation, "Mapper Generator", new AccumuloStore()));
    verify(configuration).addResource("///");
    verify(configuration).get("fs.defaultFS", "file:///");
    verify(configuration).getBoolean("fs.hdfs.impl.disable.cache", false);
    verify(job).setCombinerClass(isA(Class.class));
    verify(job).setJarByClass(isA(Class.class));
    verify(job).setJobName("Ingest HDFS data: Generator = Mapper Generator, output = Output Path");
    verify(job).setMapOutputKeyClass(isA(Class.class));
    verify(job).setMapOutputValueClass(isA(Class.class));
    verify(job).setMapperClass(isA(Class.class));
    verify(job).setOutputFormatClass(isA(Class.class));
    verify(job).setOutputKeyClass(isA(Class.class));
    verify(job).setOutputValueClass(isA(Class.class));
    verify(job).setReducerClass(isA(Class.class));
    verify(job).getConfiguration();
    verify(operation, atLeast(1)).getOutputPath();
  }

  /**
   * Test {@link AccumuloAddElementsFromHdfsJobFactory#setupJob(Job, AddElementsFromHdfs, String,
   * Store)} with {@code Job}, {@code AddElementsFromHdfs}, {@code String}, {@code Store}.
   *
   * <ul>
   *   <li>Then calls {@link AddElementsFromHdfs#setPartitioner(Class)}.
   * </ul>
   *
   * <p>Method under test: {@link AccumuloAddElementsFromHdfsJobFactory#setupJob(Job,
   * AddElementsFromHdfs, String, Store)}
   */
  @Test
  @DisplayName(
      "Test setupJob(Job, AddElementsFromHdfs, String, Store) with 'Job', 'AddElementsFromHdfs', 'String', 'Store'; then calls setPartitioner(Class)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AccumuloAddElementsFromHdfsJobFactory.setupJob(Job, AddElementsFromHdfs, String, Store)"
  })
  void testSetupJobWithJobAddElementsFromHdfsStringStore_thenCallsSetPartitioner()
      throws IOException, IllegalStateException {
    // Arrange
    AccumuloAddElementsFromHdfsJobFactory accumuloAddElementsFromHdfsJobFactory =
        new AccumuloAddElementsFromHdfsJobFactory();

    Job job = mock(Job.class);
    when(job.getConfiguration()).thenReturn(new Configuration());
    doNothing()
        .when(job)
        .setCombinerClass(Mockito.<Class<Reducer<Object, Object, Object, Object>>>any());
    doNothing().when(job).setJarByClass(Mockito.<Class<?>>any());
    doNothing().when(job).setJobName(Mockito.<String>any());
    doNothing().when(job).setMapOutputKeyClass(Mockito.<Class<?>>any());
    doNothing().when(job).setMapOutputValueClass(Mockito.<Class<?>>any());
    doNothing()
        .when(job)
        .setMapperClass(Mockito.<Class<Mapper<Object, Object, Object, Object>>>any());
    doNothing().when(job).setOutputFormatClass(Mockito.<Class<OutputFormat<Object, Object>>>any());
    doNothing().when(job).setOutputKeyClass(Mockito.<Class<?>>any());
    doNothing().when(job).setOutputValueClass(Mockito.<Class<?>>any());
    doNothing()
        .when(job)
        .setReducerClass(Mockito.<Class<Reducer<Object, Object, Object, Object>>>any());

    AddElementsFromHdfs operation = mock(AddElementsFromHdfs.class);
    doThrow(new RuntimeException())
        .when(operation)
        .setPartitioner(Mockito.<Class<Partitioner<Object, Object>>>any());
    Class<Partitioner> forNameResult = Partitioner.class;
    Mockito.<Class<? extends Partitioner>>when(operation.getPartitioner())
        .thenReturn(forNameResult);
    when(operation.getOutputPath()).thenReturn("Output Path");

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            accumuloAddElementsFromHdfsJobFactory.setupJob(
                job, operation, "Mapper Generator", new AccumuloStore()));
    verify(job).setCombinerClass(isA(Class.class));
    verify(job).setJarByClass(isA(Class.class));
    verify(job).setJobName("Ingest HDFS data: Generator = Mapper Generator, output = Output Path");
    verify(job).setMapOutputKeyClass(isA(Class.class));
    verify(job).setMapOutputValueClass(isA(Class.class));
    verify(job).setMapperClass(isA(Class.class));
    verify(job).setOutputFormatClass(isA(Class.class));
    verify(job).setOutputKeyClass(isA(Class.class));
    verify(job).setOutputValueClass(isA(Class.class));
    verify(job).setReducerClass(isA(Class.class));
    verify(job, atLeast(1)).getConfiguration();
    verify(operation, atLeast(1)).getOutputPath();
    verify(operation, atLeast(1)).getPartitioner();
    verify(operation).setPartitioner(isA(Class.class));
  }

  /**
   * Test {@link AccumuloAddElementsFromHdfsJobFactory#setupMapper(Job)}.
   *
   * <ul>
   *   <li>When {@link Job#Job()}.
   *   <li>Then {@link Job#Job()} CombinerKeyGroupingComparator {@link WritableComparator}.
   * </ul>
   *
   * <p>Method under test: {@link AccumuloAddElementsFromHdfsJobFactory#setupMapper(Job)}
   */
  @Test
  @DisplayName(
      "Test setupMapper(Job); when Job(); then Job() CombinerKeyGroupingComparator WritableComparator")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AccumuloAddElementsFromHdfsJobFactory.setupMapper(Job)"})
  void testSetupMapper_whenJob_thenJobCombinerKeyGroupingComparatorWritableComparator()
      throws IOException, ClassNotFoundException {
    // Arrange
    AccumuloAddElementsFromHdfsJobFactory accumuloAddElementsFromHdfsJobFactory =
        new AccumuloAddElementsFromHdfsJobFactory();
    Job job = new Job();

    // Act
    accumuloAddElementsFromHdfsJobFactory.setupMapper(job);

    // Assert
    assertTrue(job.getCombinerKeyGroupingComparator() instanceof WritableComparator);
    assertTrue(job.getGroupingComparator() instanceof WritableComparator);
    assertTrue(job.getSortComparator() instanceof WritableComparator);
    Class<Key> expectedMapOutputKeyClass = Key.class;
    assertEquals(expectedMapOutputKeyClass, job.getMapOutputKeyClass());
    Class<Value> expectedMapOutputValueClass = Value.class;
    assertEquals(expectedMapOutputValueClass, job.getMapOutputValueClass());
    Class<AddElementsFromHdfsMapper> expectedMapperClass = AddElementsFromHdfsMapper.class;
    assertEquals(expectedMapperClass, job.getMapperClass());
  }

  /**
   * Test {@link AccumuloAddElementsFromHdfsJobFactory#setupReducer(Job)}.
   *
   * <ul>
   *   <li>When {@link Job#Job()}.
   *   <li>Then {@link Job#Job()} CombinerKeyGroupingComparator {@link WritableComparator}.
   * </ul>
   *
   * <p>Method under test: {@link AccumuloAddElementsFromHdfsJobFactory#setupReducer(Job)}
   */
  @Test
  @DisplayName(
      "Test setupReducer(Job); when Job(); then Job() CombinerKeyGroupingComparator WritableComparator")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AccumuloAddElementsFromHdfsJobFactory.setupReducer(Job)"})
  void testSetupReducer_whenJob_thenJobCombinerKeyGroupingComparatorWritableComparator()
      throws IOException, ClassNotFoundException {
    // Arrange
    AccumuloAddElementsFromHdfsJobFactory accumuloAddElementsFromHdfsJobFactory =
        new AccumuloAddElementsFromHdfsJobFactory();
    Job job = new Job();

    // Act
    accumuloAddElementsFromHdfsJobFactory.setupReducer(job);

    // Assert
    assertTrue(job.getCombinerKeyGroupingComparator() instanceof WritableComparator);
    assertTrue(job.getGroupingComparator() instanceof WritableComparator);
    assertTrue(job.getSortComparator() instanceof WritableComparator);
    Class<Key> expectedMapOutputKeyClass = Key.class;
    assertEquals(expectedMapOutputKeyClass, job.getMapOutputKeyClass());
    Class<Key> expectedOutputKeyClass = Key.class;
    assertEquals(expectedOutputKeyClass, job.getOutputKeyClass());
    Class<Value> expectedMapOutputValueClass = Value.class;
    assertEquals(expectedMapOutputValueClass, job.getMapOutputValueClass());
    Class<Value> expectedOutputValueClass = Value.class;
    assertEquals(expectedOutputValueClass, job.getOutputValueClass());
    Class<AccumuloKeyValueReducer> expectedReducerClass = AccumuloKeyValueReducer.class;
    assertEquals(expectedReducerClass, job.getReducerClass());
  }

  /**
   * Test {@link AccumuloAddElementsFromHdfsJobFactory#setupPartitioner(Job, AddElementsFromHdfs,
   * AccumuloStore)}.
   *
   * <ul>
   *   <li>Given minus one.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link AccumuloAddElementsFromHdfsJobFactory#setupPartitioner(Job,
   * AddElementsFromHdfs, AccumuloStore)}
   */
  @Test
  @DisplayName(
      "Test setupPartitioner(Job, AddElementsFromHdfs, AccumuloStore); given minus one; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AccumuloAddElementsFromHdfsJobFactory.setupPartitioner(Job, AddElementsFromHdfs, AccumuloStore)"
  })
  void testSetupPartitioner_givenMinusOne_thenThrowIllegalArgumentException() throws IOException {
    // Arrange
    AccumuloAddElementsFromHdfsJobFactory accumuloAddElementsFromHdfsJobFactory =
        new AccumuloAddElementsFromHdfsJobFactory();
    Job job = new Job();

    AddElementsFromHdfs operation = mock(AddElementsFromHdfs.class);
    when(operation.getMaxReduceTasks()).thenReturn(-1);
    when(operation.isUseProvidedSplits()).thenReturn(true);
    when(operation.getSplitsFilePath()).thenReturn("/directory/foo.txt");

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            accumuloAddElementsFromHdfsJobFactory.setupPartitioner(
                job, operation, new AccumuloStore()));
    verify(operation).getMaxReduceTasks();
    verify(operation).getSplitsFilePath();
    verify(operation).isUseProvidedSplits();
  }

  /**
   * Test {@link AccumuloAddElementsFromHdfsJobFactory#setupPartitioner(Job, AddElementsFromHdfs,
   * AccumuloStore)}.
   *
   * <ul>
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link AccumuloAddElementsFromHdfsJobFactory#setupPartitioner(Job,
   * AddElementsFromHdfs, AccumuloStore)}
   */
  @Test
  @DisplayName(
      "Test setupPartitioner(Job, AddElementsFromHdfs, AccumuloStore); then throw RuntimeException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AccumuloAddElementsFromHdfsJobFactory.setupPartitioner(Job, AddElementsFromHdfs, AccumuloStore)"
  })
  void testSetupPartitioner_thenThrowRuntimeException() throws IOException {
    // Arrange
    AccumuloAddElementsFromHdfsJobFactory accumuloAddElementsFromHdfsJobFactory =
        new AccumuloAddElementsFromHdfsJobFactory();

    Configuration configuration = mock(Configuration.class);
    when(configuration.getBoolean(Mockito.<String>any(), anyBoolean()))
        .thenThrow(new RuntimeException());
    when(configuration.get(Mockito.<String>any(), Mockito.<String>any())).thenReturn("Get");

    Job job = mock(Job.class);
    when(job.getConfiguration()).thenReturn(configuration);

    AddElementsFromHdfs operation = mock(AddElementsFromHdfs.class);
    when(operation.getMaxReduceTasks()).thenReturn(1);
    when(operation.isUseProvidedSplits()).thenReturn(true);
    when(operation.getSplitsFilePath()).thenReturn("/directory/foo.txt");

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            accumuloAddElementsFromHdfsJobFactory.setupPartitioner(
                job, operation, new AccumuloStore()));
    verify(configuration).get("fs.defaultFS", "file:///");
    verify(configuration).getBoolean("fs.hdfs.impl.disable.cache", false);
    verify(job).getConfiguration();
    verify(operation).getMaxReduceTasks();
    verify(operation).getSplitsFilePath();
    verify(operation).isUseProvidedSplits();
  }

  /**
   * Test {@link
   * AccumuloAddElementsFromHdfsJobFactory#setUpPartitionerFromUserProvidedSplitsFile(Job,
   * AddElementsFromHdfs)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AccumuloAddElementsFromHdfsJobFactory#setUpPartitionerFromUserProvidedSplitsFile(Job,
   * AddElementsFromHdfs)}
   */
  @Test
  @DisplayName(
      "Test setUpPartitionerFromUserProvidedSplitsFile(Job, AddElementsFromHdfs); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AccumuloAddElementsFromHdfsJobFactory.setUpPartitionerFromUserProvidedSplitsFile(Job, AddElementsFromHdfs)"
  })
  void testSetUpPartitionerFromUserProvidedSplitsFile_thenThrowIllegalArgumentException()
      throws IOException {
    // Arrange
    AccumuloAddElementsFromHdfsJobFactory accumuloAddElementsFromHdfsJobFactory =
        new AccumuloAddElementsFromHdfsJobFactory();
    Job job = new Job();

    AddElementsFromHdfs operation = new AddElementsFromHdfs();
    operation.setMaxReduceTasks(-1);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            accumuloAddElementsFromHdfsJobFactory.setUpPartitionerFromUserProvidedSplitsFile(
                job, operation));
  }

  /**
   * Test {@link AccumuloAddElementsFromHdfsJobFactory#validateValue(Integer)}.
   *
   * <ul>
   *   <li>When forty-two.
   *   <li>Then return forty-two.
   * </ul>
   *
   * <p>Method under test: {@link AccumuloAddElementsFromHdfsJobFactory#validateValue(Integer)}
   */
  @Test
  @DisplayName("Test validateValue(Integer); when forty-two; then return forty-two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int AccumuloAddElementsFromHdfsJobFactory.validateValue(Integer)"})
  void testValidateValue_whenFortyTwo_thenReturnFortyTwo() throws IOException {
    // Arrange, Act and Assert
    assertEquals(42, AccumuloAddElementsFromHdfsJobFactory.validateValue(42));
  }

  /**
   * Test {@link AccumuloAddElementsFromHdfsJobFactory#validateValue(Integer)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link AccumuloAddElementsFromHdfsJobFactory#validateValue(Integer)}
   */
  @Test
  @DisplayName("Test validateValue(Integer); when 'null'; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int AccumuloAddElementsFromHdfsJobFactory.validateValue(Integer)"})
  void testValidateValue_whenNull_thenReturnZero() throws IOException {
    // Arrange, Act and Assert
    assertEquals(0, AccumuloAddElementsFromHdfsJobFactory.validateValue(null));
  }

  /**
   * Test {@link AccumuloAddElementsFromHdfsJobFactory#validateValue(Integer)}.
   *
   * <ul>
   *   <li>When zero.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link AccumuloAddElementsFromHdfsJobFactory#validateValue(Integer)}
   */
  @Test
  @DisplayName("Test validateValue(Integer); when zero; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int AccumuloAddElementsFromHdfsJobFactory.validateValue(Integer)"})
  void testValidateValue_whenZero_thenThrowIllegalArgumentException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> AccumuloAddElementsFromHdfsJobFactory.validateValue(0));
  }
}
