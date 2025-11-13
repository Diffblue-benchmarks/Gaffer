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
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.apache.accumulo.core.client.AccumuloException;
import org.apache.accumulo.core.client.AccumuloSecurityException;
import org.apache.accumulo.core.client.IteratorSetting;
import org.apache.accumulo.core.client.TableExistsException;
import org.apache.accumulo.core.client.TableNotFoundException;
import org.apache.accumulo.core.client.admin.TableOperations;
import org.apache.accumulo.core.clientImpl.ConnectorImpl;
import org.apache.accumulo.core.data.Key;
import org.apache.accumulo.core.data.Value;
import org.apache.accumulo.core.iterators.IteratorUtil;
import org.apache.accumulo.core.iterators.IteratorUtil.IteratorScope;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.io.LongWritable;
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
import uk.gov.gchq.gaffer.accumulostore.key.core.impl.byteEntity.ByteEntityKeyPackage;
import uk.gov.gchq.gaffer.accumulostore.operation.hdfs.mapper.AddElementsFromHdfsMapper;
import uk.gov.gchq.gaffer.data.elementdefinition.exception.SchemaException;
import uk.gov.gchq.gaffer.hdfs.operation.AddElementsFromHdfs;
import uk.gov.gchq.gaffer.store.Store;
import uk.gov.gchq.gaffer.store.StoreException;
import uk.gov.gchq.gaffer.store.schema.Schema;

class AccumuloAddElementsFromHdfsJobFactoryDiffblueTest {
  /**
   * Test {@link AccumuloAddElementsFromHdfsJobFactory#AccumuloAddElementsFromHdfsJobFactory()}.
   * <p>
   * Method under test: {@link AccumuloAddElementsFromHdfsJobFactory#AccumuloAddElementsFromHdfsJobFactory()}
   */
  @Test
  @DisplayName("Test new AccumuloAddElementsFromHdfsJobFactory()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void AccumuloAddElementsFromHdfsJobFactory.<init>()"})
  void testNewAccumuloAddElementsFromHdfsJobFactory() {
    // Arrange, Act and Assert
    assertEquals("Ingest HDFS data: Generator = Mapper Generator, output = Output Path",
        (new AccumuloAddElementsFromHdfsJobFactory()).getJobName("Mapper Generator", "Output Path"));
  }

  /**
   * Test {@link AccumuloAddElementsFromHdfsJobFactory#prepareStore(Store)}.
   * <p>
   * Method under test: {@link AccumuloAddElementsFromHdfsJobFactory#prepareStore(Store)}
   */
  @Test
  @DisplayName("Test prepareStore(Store)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void AccumuloAddElementsFromHdfsJobFactory.prepareStore(Store)"})
  void testPrepareStore() throws SchemaException, StoreException {
    // Arrange
    AccumuloAddElementsFromHdfsJobFactory accumuloAddElementsFromHdfsJobFactory = new AccumuloAddElementsFromHdfsJobFactory();
    TableOperations tableOperations = mock(TableOperations.class);
    when(tableOperations.exists(Mockito.<String>any())).thenReturn(true);
    ConnectorImpl connectorImpl = mock(ConnectorImpl.class);
    when(connectorImpl.tableOperations()).thenReturn(tableOperations);
    Schema schema = mock(Schema.class);
    when(schema.toCompactJson()).thenThrow(new IllegalArgumentException("Aggregator"));
    when(schema.hasValidation()).thenReturn(true);
    when(schema.isAggregationEnabled()).thenReturn(false);
    AccumuloStore store = mock(AccumuloStore.class);
    when(store.getSchema()).thenReturn(schema);
    when(store.getKeyPackage()).thenReturn(new ByteEntityKeyPackage());
    when(store.getProperties()).thenReturn(new AccumuloProperties());
    when(store.getConnection()).thenReturn(connectorImpl);
    when(store.getTableName()).thenReturn("Table Name");

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> accumuloAddElementsFromHdfsJobFactory.prepareStore(store));
    verify(tableOperations).exists(eq("Table Name"));
    verify(connectorImpl).tableOperations();
    verify(store).getConnection();
    verify(store).getKeyPackage();
    verify(store).getProperties();
    verify(store).getTableName();
    verify(store, atLeast(1)).getSchema();
    verify(schema).hasValidation();
    verify(schema).isAggregationEnabled();
    verify(schema).toCompactJson();
  }

  /**
   * Test {@link AccumuloAddElementsFromHdfsJobFactory#prepareStore(Store)}.
   * <p>
   * Method under test: {@link AccumuloAddElementsFromHdfsJobFactory#prepareStore(Store)}
   */
  @Test
  @DisplayName("Test prepareStore(Store)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void AccumuloAddElementsFromHdfsJobFactory.prepareStore(Store)"})
  void testPrepareStore2() throws AccumuloException, AccumuloSecurityException, TableExistsException,
      TableNotFoundException, StoreException {
    // Arrange
    AccumuloAddElementsFromHdfsJobFactory accumuloAddElementsFromHdfsJobFactory = new AccumuloAddElementsFromHdfsJobFactory();
    TableOperations tableOperations = mock(TableOperations.class);
    when(tableOperations.exists(Mockito.<String>any())).thenReturn(false);
    doNothing().when(tableOperations).create(Mockito.<String>any());
    doNothing().when(tableOperations)
        .removeIterator(Mockito.<String>any(), Mockito.<String>any(), Mockito.<EnumSet<IteratorScope>>any());
    doNothing().when(tableOperations).setProperty(Mockito.<String>any(), Mockito.<String>any(), Mockito.<String>any());
    ConnectorImpl connectorImpl = mock(ConnectorImpl.class);
    when(connectorImpl.whoami()).thenReturn("Whoami");
    when(connectorImpl.tableOperations()).thenReturn(tableOperations);
    Schema schema = mock(Schema.class);
    when(schema.getAggregatedGroups()).thenThrow(new IllegalArgumentException("Aggregator"));
    when(schema.isAggregationEnabled()).thenReturn(true);
    AccumuloStore store = mock(AccumuloStore.class);
    when(store.getSchema()).thenReturn(schema);
    when(store.getKeyPackage()).thenReturn(new ByteEntityKeyPackage());
    when(store.getProperties()).thenReturn(new AccumuloProperties());
    when(store.getConnection()).thenReturn(connectorImpl);
    when(store.getTableName()).thenReturn("Table Name");

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> accumuloAddElementsFromHdfsJobFactory.prepareStore(store));
    verify(tableOperations).create(eq("Table Name"));
    verify(tableOperations, atLeast(1)).exists(eq("Table Name"));
    verify(tableOperations).removeIterator(eq("Table Name"), eq("vers"), isA(EnumSet.class));
    verify(tableOperations, atLeast(1)).setProperty(eq("Table Name"), Mockito.<String>any(), Mockito.<String>any());
    verify(connectorImpl, atLeast(1)).tableOperations();
    verify(connectorImpl).whoami();
    verify(store, atLeast(1)).getConnection();
    verify(store, atLeast(1)).getKeyPackage();
    verify(store, atLeast(1)).getProperties();
    verify(store, atLeast(1)).getTableName();
    verify(store, atLeast(1)).getSchema();
    verify(schema).getAggregatedGroups();
    verify(schema).isAggregationEnabled();
  }

  /**
   * Test {@link AccumuloAddElementsFromHdfsJobFactory#prepareStore(Store)}.
   * <ul>
   *   <li>Given {@link HashSet#HashSet()} add {@code Table file replication set to {} on table {}}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AccumuloAddElementsFromHdfsJobFactory#prepareStore(Store)}
   */
  @Test
  @DisplayName("Test prepareStore(Store); given HashSet() add 'Table file replication set to {} on table {}'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void AccumuloAddElementsFromHdfsJobFactory.prepareStore(Store)"})
  void testPrepareStore_givenHashSetAddTableFileReplicationSetToOnTable()
      throws UnsupportedEncodingException, AccumuloException, AccumuloSecurityException, TableExistsException,
      TableNotFoundException, SchemaException, StoreException {
    // Arrange
    AccumuloAddElementsFromHdfsJobFactory accumuloAddElementsFromHdfsJobFactory = new AccumuloAddElementsFromHdfsJobFactory();
    TableOperations tableOperations = mock(TableOperations.class);
    doNothing().when(tableOperations).attachIterator(Mockito.<String>any(), Mockito.<IteratorSetting>any());
    when(tableOperations.exists(Mockito.<String>any())).thenReturn(false);
    doNothing().when(tableOperations).create(Mockito.<String>any());
    doNothing().when(tableOperations)
        .removeIterator(Mockito.<String>any(), Mockito.<String>any(), Mockito.<EnumSet<IteratorScope>>any());
    doNothing().when(tableOperations).setLocalityGroups(Mockito.<String>any(), Mockito.<Map<String, Set<Text>>>any());
    doNothing().when(tableOperations).setProperty(Mockito.<String>any(), Mockito.<String>any(), Mockito.<String>any());
    ConnectorImpl connectorImpl = mock(ConnectorImpl.class);
    when(connectorImpl.whoami()).thenReturn("Whoami");
    when(connectorImpl.tableOperations()).thenReturn(tableOperations);
    AccumuloProperties accumuloProperties = mock(AccumuloProperties.class);
    when(accumuloProperties.getNamespace()).thenReturn("");
    when(accumuloProperties.getTableFileReplicationFactor()).thenReturn("Table File Replication Factor");
    when(accumuloProperties.getEnableValidatorIterator()).thenReturn(true);

    HashSet<String> stringSet = new HashSet<>();
    stringSet.add("Table file replication set to {} on table {}");
    Schema schema = mock(Schema.class);
    when(schema.getGroups()).thenReturn(stringSet);
    when(schema.toCompactJson()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    when(schema.getAggregatedGroups()).thenReturn(new ArrayList<>());
    when(schema.hasValidation()).thenReturn(true);
    when(schema.isAggregationEnabled()).thenReturn(true);
    AccumuloStore store = mock(AccumuloStore.class);
    when(store.getSchema()).thenReturn(schema);
    when(store.getKeyPackage()).thenReturn(new ByteEntityKeyPackage(new Schema()));
    when(store.getProperties()).thenReturn(accumuloProperties);
    when(store.getConnection()).thenReturn(connectorImpl);
    when(store.getTableName()).thenReturn("Table Name");

    // Act
    accumuloAddElementsFromHdfsJobFactory.prepareStore(store);

    // Assert
    verify(tableOperations, atLeast(1)).attachIterator(eq("Table Name"), Mockito.<IteratorSetting>any());
    verify(tableOperations).create(eq("Table Name"));
    verify(tableOperations, atLeast(1)).exists(eq("Table Name"));
    verify(tableOperations).removeIterator(eq("Table Name"), eq("vers"), isA(EnumSet.class));
    verify(tableOperations).setLocalityGroups(eq("Table Name"), isA(Map.class));
    verify(tableOperations, atLeast(1)).setProperty(eq("Table Name"), Mockito.<String>any(), Mockito.<String>any());
    verify(connectorImpl, atLeast(1)).tableOperations();
    verify(connectorImpl).whoami();
    verify(accumuloProperties).getEnableValidatorIterator();
    verify(accumuloProperties).getNamespace();
    verify(accumuloProperties).getTableFileReplicationFactor();
    verify(store, atLeast(1)).getConnection();
    verify(store, atLeast(1)).getKeyPackage();
    verify(store, atLeast(1)).getProperties();
    verify(store, atLeast(1)).getTableName();
    verify(schema).getGroups();
    verify(store, atLeast(1)).getSchema();
    verify(schema, atLeast(1)).getAggregatedGroups();
    verify(schema, atLeast(1)).hasValidation();
    verify(schema).isAggregationEnabled();
    verify(schema, atLeast(1)).toCompactJson();
  }

  /**
   * Test {@link AccumuloAddElementsFromHdfsJobFactory#prepareStore(Store)}.
   * <ul>
   *   <li>Then calls {@link TableOperations#attachIterator(String, IteratorSetting)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AccumuloAddElementsFromHdfsJobFactory#prepareStore(Store)}
   */
  @Test
  @DisplayName("Test prepareStore(Store); then calls attachIterator(String, IteratorSetting)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void AccumuloAddElementsFromHdfsJobFactory.prepareStore(Store)"})
  void testPrepareStore_thenCallsAttachIterator() throws UnsupportedEncodingException, AccumuloException,
      AccumuloSecurityException, TableExistsException, TableNotFoundException, SchemaException, StoreException {
    // Arrange
    AccumuloAddElementsFromHdfsJobFactory accumuloAddElementsFromHdfsJobFactory = new AccumuloAddElementsFromHdfsJobFactory();
    TableOperations tableOperations = mock(TableOperations.class);
    doNothing().when(tableOperations).attachIterator(Mockito.<String>any(), Mockito.<IteratorSetting>any());
    when(tableOperations.exists(Mockito.<String>any())).thenReturn(false);
    doNothing().when(tableOperations).create(Mockito.<String>any());
    doNothing().when(tableOperations)
        .removeIterator(Mockito.<String>any(), Mockito.<String>any(), Mockito.<EnumSet<IteratorScope>>any());
    doNothing().when(tableOperations).setLocalityGroups(Mockito.<String>any(), Mockito.<Map<String, Set<Text>>>any());
    doNothing().when(tableOperations).setProperty(Mockito.<String>any(), Mockito.<String>any(), Mockito.<String>any());
    ConnectorImpl connectorImpl = mock(ConnectorImpl.class);
    when(connectorImpl.whoami()).thenReturn("Whoami");
    when(connectorImpl.tableOperations()).thenReturn(tableOperations);
    AccumuloProperties accumuloProperties = mock(AccumuloProperties.class);
    when(accumuloProperties.getNamespace()).thenReturn("");
    when(accumuloProperties.getTableFileReplicationFactor()).thenReturn("Table File Replication Factor");
    when(accumuloProperties.getEnableValidatorIterator()).thenReturn(true);
    Schema schema = mock(Schema.class);
    when(schema.getGroups()).thenReturn(new HashSet<>());
    when(schema.toCompactJson()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    when(schema.getAggregatedGroups()).thenReturn(new ArrayList<>());
    when(schema.hasValidation()).thenReturn(true);
    when(schema.isAggregationEnabled()).thenReturn(true);
    AccumuloStore store = mock(AccumuloStore.class);
    when(store.getSchema()).thenReturn(schema);
    when(store.getKeyPackage()).thenReturn(new ByteEntityKeyPackage(new Schema()));
    when(store.getProperties()).thenReturn(accumuloProperties);
    when(store.getConnection()).thenReturn(connectorImpl);
    when(store.getTableName()).thenReturn("Table Name");

    // Act
    accumuloAddElementsFromHdfsJobFactory.prepareStore(store);

    // Assert
    verify(tableOperations, atLeast(1)).attachIterator(eq("Table Name"), Mockito.<IteratorSetting>any());
    verify(tableOperations).create(eq("Table Name"));
    verify(tableOperations, atLeast(1)).exists(eq("Table Name"));
    verify(tableOperations).removeIterator(eq("Table Name"), eq("vers"), isA(EnumSet.class));
    verify(tableOperations).setLocalityGroups(eq("Table Name"), isA(Map.class));
    verify(tableOperations, atLeast(1)).setProperty(eq("Table Name"), Mockito.<String>any(), Mockito.<String>any());
    verify(connectorImpl, atLeast(1)).tableOperations();
    verify(connectorImpl).whoami();
    verify(accumuloProperties).getEnableValidatorIterator();
    verify(accumuloProperties).getNamespace();
    verify(accumuloProperties).getTableFileReplicationFactor();
    verify(store, atLeast(1)).getConnection();
    verify(store, atLeast(1)).getKeyPackage();
    verify(store, atLeast(1)).getProperties();
    verify(store, atLeast(1)).getTableName();
    verify(schema).getGroups();
    verify(store, atLeast(1)).getSchema();
    verify(schema, atLeast(1)).getAggregatedGroups();
    verify(schema, atLeast(1)).hasValidation();
    verify(schema).isAggregationEnabled();
    verify(schema, atLeast(1)).toCompactJson();
  }

  /**
   * Test {@link AccumuloAddElementsFromHdfsJobFactory#prepareStore(Store)}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AccumuloAddElementsFromHdfsJobFactory#prepareStore(Store)}
   */
  @Test
  @DisplayName("Test prepareStore(Store); then throw RuntimeException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void AccumuloAddElementsFromHdfsJobFactory.prepareStore(Store)"})
  void testPrepareStore_thenThrowRuntimeException() throws StoreException {
    // Arrange
    AccumuloAddElementsFromHdfsJobFactory accumuloAddElementsFromHdfsJobFactory = new AccumuloAddElementsFromHdfsJobFactory();
    TableOperations tableOperations = mock(TableOperations.class);
    when(tableOperations.exists(Mockito.<String>any())).thenReturn(false);
    ConnectorImpl connectorImpl = mock(ConnectorImpl.class);
    when(connectorImpl.namespaceOperations()).thenThrow(new RuntimeException("foo"));
    when(connectorImpl.tableOperations()).thenReturn(tableOperations);
    AccumuloProperties accumuloProperties = mock(AccumuloProperties.class);
    when(accumuloProperties.getNamespace()).thenReturn("Namespace");
    AccumuloStore store = mock(AccumuloStore.class);
    when(store.getProperties()).thenReturn(accumuloProperties);
    when(store.getConnection()).thenReturn(connectorImpl);
    when(store.getTableName()).thenReturn("Table Name");

    // Act and Assert
    assertThrows(RuntimeException.class, () -> accumuloAddElementsFromHdfsJobFactory.prepareStore(store));
    verify(tableOperations, atLeast(1)).exists(eq("Table Name"));
    verify(connectorImpl).namespaceOperations();
    verify(connectorImpl, atLeast(1)).tableOperations();
    verify(accumuloProperties).getNamespace();
    verify(store, atLeast(1)).getConnection();
    verify(store).getProperties();
    verify(store, atLeast(1)).getTableName();
  }

  /**
   * Test {@link AccumuloAddElementsFromHdfsJobFactory#prepareStore(Store)}.
   * <ul>
   *   <li>Then throw {@link StoreException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AccumuloAddElementsFromHdfsJobFactory#prepareStore(Store)}
   */
  @Test
  @DisplayName("Test prepareStore(Store); then throw StoreException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void AccumuloAddElementsFromHdfsJobFactory.prepareStore(Store)"})
  void testPrepareStore_thenThrowStoreException() throws StoreException {
    // Arrange
    AccumuloAddElementsFromHdfsJobFactory accumuloAddElementsFromHdfsJobFactory = new AccumuloAddElementsFromHdfsJobFactory();
    AccumuloStore store = mock(AccumuloStore.class);
    when(store.getConnection()).thenThrow(new StoreException("An error occurred"));
    when(store.getTableName()).thenReturn("Table Name");

    // Act and Assert
    assertThrows(StoreException.class, () -> accumuloAddElementsFromHdfsJobFactory.prepareStore(store));
    verify(store).getConnection();
    verify(store).getTableName();
  }

  /**
   * Test {@link AccumuloAddElementsFromHdfsJobFactory#getJobName(String, String)}.
   * <p>
   * Method under test: {@link AccumuloAddElementsFromHdfsJobFactory#getJobName(String, String)}
   */
  @Test
  @DisplayName("Test getJobName(String, String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String AccumuloAddElementsFromHdfsJobFactory.getJobName(String, String)"})
  void testGetJobName() {
    // Arrange, Act and Assert
    assertEquals("Ingest HDFS data: Generator = Mapper Generator, output = Output Path",
        (new AccumuloAddElementsFromHdfsJobFactory()).getJobName("Mapper Generator", "Output Path"));
  }

  /**
   * Test {@link AccumuloAddElementsFromHdfsJobFactory#setupJob(Job, AddElementsFromHdfs, String, Store)} with {@code Job}, {@code AddElementsFromHdfs}, {@code String}, {@code Store}.
   * <ul>
   *   <li>Then calls {@link Configuration#get(String, String)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AccumuloAddElementsFromHdfsJobFactory#setupJob(Job, AddElementsFromHdfs, String, Store)}
   */
  @Test
  @DisplayName("Test setupJob(Job, AddElementsFromHdfs, String, Store) with 'Job', 'AddElementsFromHdfs', 'String', 'Store'; then calls get(String, String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void AccumuloAddElementsFromHdfsJobFactory.setupJob(Job, AddElementsFromHdfs, String, Store)"})
  void testSetupJobWithJobAddElementsFromHdfsStringStore_thenCallsGet() throws IOException, IllegalStateException {
    // Arrange
    AccumuloAddElementsFromHdfsJobFactory accumuloAddElementsFromHdfsJobFactory = new AccumuloAddElementsFromHdfsJobFactory();
    Configuration configuration = mock(Configuration.class);
    when(configuration.getBoolean(Mockito.<String>any(), anyBoolean())).thenThrow(new IllegalArgumentException("///"));
    when(configuration.get(Mockito.<String>any(), Mockito.<String>any())).thenReturn("Get");
    Job job = mock(Job.class);
    when(job.getConfiguration()).thenReturn(configuration);
    doNothing().when(job).setCombinerClass(Mockito.<Class<Reducer<Object, Object, Object, Object>>>any());
    doNothing().when(job).setJarByClass(Mockito.<Class<Object>>any());
    doNothing().when(job).setJobName(Mockito.<String>any());
    doNothing().when(job).setMapOutputKeyClass(Mockito.<Class<Object>>any());
    doNothing().when(job).setMapOutputValueClass(Mockito.<Class<Object>>any());
    doNothing().when(job).setMapperClass(Mockito.<Class<Mapper<Object, Object, Object, Object>>>any());
    doNothing().when(job).setOutputFormatClass(Mockito.<Class<OutputFormat<Object, Object>>>any());
    doNothing().when(job).setOutputKeyClass(Mockito.<Class<Object>>any());
    doNothing().when(job).setOutputValueClass(Mockito.<Class<Object>>any());
    doNothing().when(job).setReducerClass(Mockito.<Class<Reducer<Object, Object, Object, Object>>>any());
    AddElementsFromHdfs operation = mock(AddElementsFromHdfs.class);
    when(operation.getOutputPath()).thenReturn("Output Path");

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> accumuloAddElementsFromHdfsJobFactory.setupJob(job, operation, "Mapper Generator", new AccumuloStore()));
    verify(configuration).get(eq("fs.defaultFS"), eq("file:///"));
    verify(configuration).getBoolean(eq("fs.hdfs.impl.disable.cache"), eq(false));
    verify(job).setCombinerClass(isA(Class.class));
    verify(job).setJarByClass(isA(Class.class));
    verify(job).setJobName(eq("Ingest HDFS data: Generator = Mapper Generator, output = Output Path"));
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
   * Test {@link AccumuloAddElementsFromHdfsJobFactory#setupJob(Job, AddElementsFromHdfs, String, Store)} with {@code Job}, {@code AddElementsFromHdfs}, {@code String}, {@code Store}.
   * <ul>
   *   <li>Then calls {@link AddElementsFromHdfs#getPartitioner()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AccumuloAddElementsFromHdfsJobFactory#setupJob(Job, AddElementsFromHdfs, String, Store)}
   */
  @Test
  @DisplayName("Test setupJob(Job, AddElementsFromHdfs, String, Store) with 'Job', 'AddElementsFromHdfs', 'String', 'Store'; then calls getPartitioner()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void AccumuloAddElementsFromHdfsJobFactory.setupJob(Job, AddElementsFromHdfs, String, Store)"})
  void testSetupJobWithJobAddElementsFromHdfsStringStore_thenCallsGetPartitioner()
      throws IOException, IllegalStateException {
    // Arrange
    AccumuloAddElementsFromHdfsJobFactory accumuloAddElementsFromHdfsJobFactory = new AccumuloAddElementsFromHdfsJobFactory();
    Job job = mock(Job.class);
    when(job.getConfiguration()).thenReturn(new Configuration());
    doNothing().when(job).setCombinerClass(Mockito.<Class<Reducer<Object, Object, Object, Object>>>any());
    doNothing().when(job).setJarByClass(Mockito.<Class<Object>>any());
    doNothing().when(job).setJobName(Mockito.<String>any());
    doNothing().when(job).setMapOutputKeyClass(Mockito.<Class<Object>>any());
    doNothing().when(job).setMapOutputValueClass(Mockito.<Class<Object>>any());
    doNothing().when(job).setMapperClass(Mockito.<Class<Mapper<Object, Object, Object, Object>>>any());
    doNothing().when(job).setOutputFormatClass(Mockito.<Class<OutputFormat<Object, Object>>>any());
    doNothing().when(job).setOutputKeyClass(Mockito.<Class<Object>>any());
    doNothing().when(job).setOutputValueClass(Mockito.<Class<Object>>any());
    doNothing().when(job).setReducerClass(Mockito.<Class<Reducer<Object, Object, Object, Object>>>any());
    AddElementsFromHdfs operation = mock(AddElementsFromHdfs.class);
    doThrow(new IllegalArgumentException("///")).when(operation)
        .setPartitioner(Mockito.<Class<Partitioner<Object, Object>>>any());
    Class<Partitioner> forNameResult = Partitioner.class;
    Mockito.<Class<? extends Partitioner>>when(operation.getPartitioner()).thenReturn(forNameResult);
    when(operation.getOutputPath()).thenReturn("Output Path");

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> accumuloAddElementsFromHdfsJobFactory.setupJob(job, operation, "Mapper Generator", new AccumuloStore()));
    verify(job).setCombinerClass(isA(Class.class));
    verify(job).setJarByClass(isA(Class.class));
    verify(job).setJobName(eq("Ingest HDFS data: Generator = Mapper Generator, output = Output Path"));
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
   * <ul>
   *   <li>When {@link Job#Job()}.</li>
   *   <li>Then {@link Job#Job()} CombinerKeyGroupingComparator {@link WritableComparator}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AccumuloAddElementsFromHdfsJobFactory#setupMapper(Job)}
   */
  @Test
  @DisplayName("Test setupMapper(Job); when Job(); then Job() CombinerKeyGroupingComparator WritableComparator")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void AccumuloAddElementsFromHdfsJobFactory.setupMapper(Job)"})
  void testSetupMapper_whenJob_thenJobCombinerKeyGroupingComparatorWritableComparator()
      throws IOException, ClassNotFoundException {
    // Arrange
    AccumuloAddElementsFromHdfsJobFactory accumuloAddElementsFromHdfsJobFactory = new AccumuloAddElementsFromHdfsJobFactory();
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
    Class<LongWritable> expectedOutputKeyClass = LongWritable.class;
    assertEquals(expectedOutputKeyClass, job.getOutputKeyClass());
    Class<Text> expectedOutputValueClass = Text.class;
    assertEquals(expectedOutputValueClass, job.getOutputValueClass());
    Class<AddElementsFromHdfsMapper> expectedMapperClass = AddElementsFromHdfsMapper.class;
    assertEquals(expectedMapperClass, job.getMapperClass());
  }

  /**
   * Test {@link AccumuloAddElementsFromHdfsJobFactory#setupPartitioner(Job, AddElementsFromHdfs, AccumuloStore)}.
   * <ul>
   *   <li>Given minus one.</li>
   *   <li>When {@link Job}.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AccumuloAddElementsFromHdfsJobFactory#setupPartitioner(Job, AddElementsFromHdfs, AccumuloStore)}
   */
  @Test
  @DisplayName("Test setupPartitioner(Job, AddElementsFromHdfs, AccumuloStore); given minus one; when Job; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "void AccumuloAddElementsFromHdfsJobFactory.setupPartitioner(Job, AddElementsFromHdfs, AccumuloStore)"})
  void testSetupPartitioner_givenMinusOne_whenJob_thenThrowIllegalArgumentException() throws IOException {
    // Arrange
    AccumuloAddElementsFromHdfsJobFactory accumuloAddElementsFromHdfsJobFactory = new AccumuloAddElementsFromHdfsJobFactory();
    Job job = mock(Job.class);
    AddElementsFromHdfs operation = mock(AddElementsFromHdfs.class);
    when(operation.getMaxReduceTasks()).thenReturn(-1);
    when(operation.isUseProvidedSplits()).thenReturn(true);
    when(operation.getSplitsFilePath()).thenReturn("/directory/foo.txt");

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> accumuloAddElementsFromHdfsJobFactory.setupPartitioner(job, operation, new AccumuloStore()));
    verify(operation).getMaxReduceTasks();
    verify(operation).getSplitsFilePath();
    verify(operation).isUseProvidedSplits();
  }

  /**
   * Test {@link AccumuloAddElementsFromHdfsJobFactory#setupPartitioner(Job, AddElementsFromHdfs, AccumuloStore)}.
   * <ul>
   *   <li>Then calls {@link Configuration#get(String, String)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AccumuloAddElementsFromHdfsJobFactory#setupPartitioner(Job, AddElementsFromHdfs, AccumuloStore)}
   */
  @Test
  @DisplayName("Test setupPartitioner(Job, AddElementsFromHdfs, AccumuloStore); then calls get(String, String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "void AccumuloAddElementsFromHdfsJobFactory.setupPartitioner(Job, AddElementsFromHdfs, AccumuloStore)"})
  void testSetupPartitioner_thenCallsGet() throws IOException {
    // Arrange
    AccumuloAddElementsFromHdfsJobFactory accumuloAddElementsFromHdfsJobFactory = new AccumuloAddElementsFromHdfsJobFactory();
    Configuration configuration = mock(Configuration.class);
    when(configuration.getBoolean(Mockito.<String>any(), anyBoolean())).thenThrow(new IllegalArgumentException(
        "Using splits file provided by user {}, ignoring minReduceTasks and maxReduceTasks"));
    when(configuration.get(Mockito.<String>any(), Mockito.<String>any())).thenReturn("Get");
    Job job = mock(Job.class);
    when(job.getConfiguration()).thenReturn(configuration);
    AddElementsFromHdfs operation = mock(AddElementsFromHdfs.class);
    when(operation.getMaxReduceTasks()).thenReturn(3);
    when(operation.isUseProvidedSplits()).thenReturn(true);
    when(operation.getSplitsFilePath()).thenReturn("/directory/foo.txt");

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> accumuloAddElementsFromHdfsJobFactory.setupPartitioner(job, operation, new AccumuloStore()));
    verify(configuration).get(eq("fs.defaultFS"), eq("file:///"));
    verify(configuration).getBoolean(eq("fs.hdfs.impl.disable.cache"), eq(false));
    verify(job).getConfiguration();
    verify(operation).getMaxReduceTasks();
    verify(operation).getSplitsFilePath();
    verify(operation).isUseProvidedSplits();
  }

  /**
   * Test {@link AccumuloAddElementsFromHdfsJobFactory#setUpPartitionerFromUserProvidedSplitsFile(Job, AddElementsFromHdfs)}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AccumuloAddElementsFromHdfsJobFactory#setUpPartitionerFromUserProvidedSplitsFile(Job, AddElementsFromHdfs)}
   */
  @Test
  @DisplayName("Test setUpPartitionerFromUserProvidedSplitsFile(Job, AddElementsFromHdfs); then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "void AccumuloAddElementsFromHdfsJobFactory.setUpPartitionerFromUserProvidedSplitsFile(Job, AddElementsFromHdfs)"})
  void testSetUpPartitionerFromUserProvidedSplitsFile_thenThrowIllegalArgumentException() throws IOException {
    // Arrange
    AccumuloAddElementsFromHdfsJobFactory accumuloAddElementsFromHdfsJobFactory = new AccumuloAddElementsFromHdfsJobFactory();
    Job job = new Job();

    AddElementsFromHdfs operation = new AddElementsFromHdfs();
    operation.setMaxReduceTasks(-1);
    operation.setMinReduceTasks(-1);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> accumuloAddElementsFromHdfsJobFactory.setUpPartitionerFromUserProvidedSplitsFile(job, operation));
  }

  /**
   * Test {@link AccumuloAddElementsFromHdfsJobFactory#validateValue(Integer)}.
   * <ul>
   *   <li>When forty-two.</li>
   *   <li>Then return forty-two.</li>
   * </ul>
   * <p>
   * Method under test: {@link AccumuloAddElementsFromHdfsJobFactory#validateValue(Integer)}
   */
  @Test
  @DisplayName("Test validateValue(Integer); when forty-two; then return forty-two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int AccumuloAddElementsFromHdfsJobFactory.validateValue(Integer)"})
  void testValidateValue_whenFortyTwo_thenReturnFortyTwo() throws IOException {
    // Arrange, Act and Assert
    assertEquals(42, AccumuloAddElementsFromHdfsJobFactory.validateValue(42));
  }

  /**
   * Test {@link AccumuloAddElementsFromHdfsJobFactory#validateValue(Integer)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link AccumuloAddElementsFromHdfsJobFactory#validateValue(Integer)}
   */
  @Test
  @DisplayName("Test validateValue(Integer); when 'null'; then return zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int AccumuloAddElementsFromHdfsJobFactory.validateValue(Integer)"})
  void testValidateValue_whenNull_thenReturnZero() throws IOException {
    // Arrange, Act and Assert
    assertEquals(0, AccumuloAddElementsFromHdfsJobFactory.validateValue(null));
  }

  /**
   * Test {@link AccumuloAddElementsFromHdfsJobFactory#validateValue(Integer)}.
   * <ul>
   *   <li>When zero.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AccumuloAddElementsFromHdfsJobFactory#validateValue(Integer)}
   */
  @Test
  @DisplayName("Test validateValue(Integer); when zero; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int AccumuloAddElementsFromHdfsJobFactory.validateValue(Integer)"})
  void testValidateValue_whenZero_thenThrowIllegalArgumentException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> AccumuloAddElementsFromHdfsJobFactory.validateValue(0));
  }
}
