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
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.anyShort;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import org.apache.accumulo.core.client.ClientConfiguration;
import org.apache.accumulo.core.client.IteratorSetting;
import org.apache.accumulo.core.client.mapreduce.AccumuloInputFormat;
import org.apache.accumulo.core.client.security.tokens.AuthenticationToken;
import org.apache.accumulo.core.client.security.tokens.CredentialProviderToken;
import org.apache.accumulo.core.conf.AccumuloConfiguration;
import org.apache.accumulo.core.conf.ConfigurationCopy;
import org.apache.accumulo.core.conf.DefaultConfiguration;
import org.apache.accumulo.core.data.Range;
import org.apache.accumulo.core.file.FileSKVWriter;
import org.apache.accumulo.core.file.rfile.RFile;
import org.apache.accumulo.core.security.Authorizations;
import org.apache.accumulo.core.util.Pair;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.FilterFileSystem;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.util.Progressable;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class LegacySupportDiffblueTest {
  /**
   * Method under test:
   * {@link LegacySupport.BackwardsCompatibleRFileWriter#create(String, Configuration, int)}
   */
  @Test
  void testBackwardsCompatibleRFileWriterCreate() {
    // Arrange, Act and Assert
    assertThrows(RuntimeException.class,
        () -> LegacySupport.BackwardsCompatibleRFileWriter.create("///", new Configuration(), 3));
    assertThrows(RuntimeException.class,
        () -> LegacySupport.BackwardsCompatibleRFileWriter.create("", new Configuration(), 3));
  }

  /**
   * Method under test:
   * {@link LegacySupport.BackwardsCompatibleRFileWriter#create(String, Configuration, int)}
   */
  @Test
  void testBackwardsCompatibleRFileWriterCreate2() throws MalformedURLException {
    // Arrange
    Configuration fsConf = new Configuration();
    fsConf.addResource(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri().toURL());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> LegacySupport.BackwardsCompatibleRFileWriter.create("File", fsConf, 3));
  }

  /**
   * Method under test:
   * {@link LegacySupport.BackwardsCompatibleRFileWriter#create(String, Configuration, int)}
   */
  @Test
  void testBackwardsCompatibleRFileWriterCreate3() {
    // Arrange
    Configuration fsConf = new Configuration();
    fsConf.addResource(new ByteArrayInputStream(new byte[]{'A', 2, 'A', 2, 'A', 2, 'A', 2}));

    // Act and Assert
    assertThrows(RuntimeException.class, () -> LegacySupport.BackwardsCompatibleRFileWriter.create("File", fsConf, 3));
  }

  /**
   * Method under test:
   * {@link LegacySupport.BackwardsCompatibleRFileWriter#create(String, Configuration, int)}
   */
  @Test
  void testBackwardsCompatibleRFileWriterCreate4() {
    // Arrange
    Configuration fsConf = new Configuration();
    fsConf.addResource("", true);
    fsConf.addResource("42");

    // Act and Assert
    assertThrows(RuntimeException.class, () -> LegacySupport.BackwardsCompatibleRFileWriter.create("File", fsConf, 3));
  }

  /**
   * Method under test:
   * {@link LegacySupport.BackwardsCompatibleReaderBuilder#create(String, FileSystem, Configuration, AccumuloConfiguration, boolean)}
   */
  @Test
  void testBackwardsCompatibleReaderBuilderCreate() {
    // Arrange
    FilterFileSystem fs = new FilterFileSystem();
    Configuration fsConf = new Configuration();

    // Act and Assert
    assertThrows(RuntimeException.class, () -> LegacySupport.BackwardsCompatibleReaderBuilder.create("foo.txt", fs,
        fsConf, new ConfigurationCopy(), true));
  }

  /**
   * Method under test:
   * {@link LegacySupport.BackwardsCompatibleWriterBuilder#create(String, FileSystem, Configuration, AccumuloConfiguration)}
   */
  @Test
  void testBackwardsCompatibleWriterBuilderCreate() throws IOException, IllegalArgumentException {
    // Arrange
    FilterFileSystem fs = mock(FilterFileSystem.class);
    ByteArrayOutputStream out = new ByteArrayOutputStream(1);
    when(fs.create(Mockito.<org.apache.hadoop.fs.Path>any(), anyBoolean(), anyInt(), anyShort(), anyLong()))
        .thenReturn(new FSDataOutputStream(out, new FileSystem.Statistics("Scheme")));
    ByteArrayOutputStream out2 = new ByteArrayOutputStream(1);
    when(fs.append(Mockito.<org.apache.hadoop.fs.Path>any(), anyInt(), Mockito.<Progressable>any()))
        .thenReturn(new FSDataOutputStream(out2, new FileSystem.Statistics("Scheme")));
    fs.append(new org.apache.hadoop.fs.Path("Path String"), 1, mock(Progressable.class));
    Configuration fsConf = new Configuration();
    Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile();

    // Act
    FileSKVWriter actualCreateResult = LegacySupport.BackwardsCompatibleWriterBuilder.create("foo.txt", fs, fsConf,
        DefaultConfiguration.getInstance());

    // Assert
    verify(fs).create(isA(org.apache.hadoop.fs.Path.class), eq(false), eq(4096), eq((short) 3), eq(134217728L));
    verify(fs).append(isA(org.apache.hadoop.fs.Path.class), eq(1), isA(Progressable.class));
    assertTrue(actualCreateResult instanceof RFile.Writer);
    assertEquals(0L, actualCreateResult.getLength());
  }

  /**
   * Method under test:
   * {@link LegacySupport.InputConfigurator#addIterator(Class, Configuration, IteratorSetting)}
   */
  @Test
  void testInputConfiguratorAddIterator() {
    // Arrange
    Class<AccumuloInputFormat> accumuloInputFormatClass = AccumuloInputFormat.class;
    Configuration conf = new Configuration();

    // Act
    LegacySupport.InputConfigurator.addIterator(accumuloInputFormatClass, conf,
        new IteratorSetting(1, "Name", "Iterator Class"));

    // Assert
    assertEquals(1447, conf.size());
  }

  /**
   * Method under test:
   * {@link LegacySupport.InputConfigurator#fetchColumns(Class, Configuration, Collection)}
   */
  @Test
  void testInputConfiguratorFetchColumns() {
    // Arrange
    Class<AccumuloInputFormat> accumuloInputFormatClass = AccumuloInputFormat.class;
    Configuration conf = new Configuration();

    // Act
    LegacySupport.InputConfigurator.fetchColumns(accumuloInputFormatClass, conf, new ArrayList<>());

    // Assert
    assertEquals(1447, conf.size());
  }

  /**
   * Method under test:
   * {@link LegacySupport.InputConfigurator#fetchColumns(Class, Configuration, Collection)}
   */
  @Test
  void testInputConfiguratorFetchColumns2() {
    // Arrange
    Class<AccumuloInputFormat> accumuloInputFormatClass = AccumuloInputFormat.class;
    Configuration conf = new Configuration();

    ArrayList<Pair<Text, Text>> columnFamilyColumnQualifierPairs = new ArrayList<>();
    Text text = new Text();
    columnFamilyColumnQualifierPairs.add(new Pair<>(text, new Text()));

    // Act
    LegacySupport.InputConfigurator.fetchColumns(accumuloInputFormatClass, conf, columnFamilyColumnQualifierPairs);

    // Assert
    assertEquals(1447, conf.size());
  }

  /**
   * Method under test:
   * {@link LegacySupport.InputConfigurator#fetchColumns(Class, Configuration, Collection)}
   */
  @Test
  void testInputConfiguratorFetchColumns3() {
    // Arrange
    Class<AccumuloInputFormat> accumuloInputFormatClass = AccumuloInputFormat.class;
    Configuration conf = new Configuration();

    ArrayList<Pair<Text, Text>> columnFamilyColumnQualifierPairs = new ArrayList<>();
    Text text = new Text();
    columnFamilyColumnQualifierPairs.add(new Pair<>(text, new Text()));
    Text text2 = new Text();
    columnFamilyColumnQualifierPairs.add(new Pair<>(text2, new Text()));

    // Act
    LegacySupport.InputConfigurator.fetchColumns(accumuloInputFormatClass, conf, columnFamilyColumnQualifierPairs);

    // Assert
    assertEquals(1447, conf.size());
  }

  /**
   * Method under test:
   * {@link LegacySupport.InputConfigurator#getFetchedColumns(Class, Configuration)}
   */
  @Test
  void testInputConfiguratorGetFetchedColumns() {
    // Arrange
    Class<AccumuloInputFormat> accumuloInputFormatClass = AccumuloInputFormat.class;

    // Act
    Set<Pair<Text, Text>> actualFetchedColumns = LegacySupport.InputConfigurator
        .getFetchedColumns(accumuloInputFormatClass, new Configuration());

    // Assert
    assertTrue(actualFetchedColumns.isEmpty());
  }

  /**
   * Method under test:
   * {@link LegacySupport.InputConfigurator#getIterators(Class, Configuration)}
   */
  @Test
  void testInputConfiguratorGetIterators() {
    // Arrange
    Class<AccumuloInputFormat> accumuloInputFormatClass = AccumuloInputFormat.class;

    // Act
    List<IteratorSetting> actualIterators = LegacySupport.InputConfigurator.getIterators(accumuloInputFormatClass,
        new Configuration());

    // Assert
    assertTrue(actualIterators.isEmpty());
  }

  /**
   * Method under test:
   * {@link LegacySupport.InputConfigurator#setBatchScan(Class, Configuration, boolean)}
   */
  @Test
  void testInputConfiguratorSetBatchScan() {
    // Arrange
    Class<AccumuloInputFormat> accumuloInputFormatClass = AccumuloInputFormat.class;
    Configuration conf = new Configuration();

    // Act
    LegacySupport.InputConfigurator.setBatchScan(accumuloInputFormatClass, conf, true);

    // Assert
    assertEquals(1447, conf.size());
  }

  /**
   * Method under test:
   * {@link LegacySupport.InputConfigurator#setConnectorInfo(Class, Configuration, String, AuthenticationToken)}
   */
  @Test
  void testInputConfiguratorSetConnectorInfo() {
    // Arrange
    Class<AccumuloInputFormat> accumuloInputFormatClass = AccumuloInputFormat.class;
    Configuration conf = new Configuration();

    // Act
    LegacySupport.InputConfigurator.setConnectorInfo(accumuloInputFormatClass, conf, "User",
        new CredentialProviderToken());

    // Assert
    assertEquals(1449, conf.size());
  }

  /**
   * Method under test:
   * {@link LegacySupport.InputConfigurator#setInputTableName(Class, Configuration, String)}
   */
  @Test
  void testInputConfiguratorSetInputTableName() {
    // Arrange
    Class<AccumuloInputFormat> accumuloInputFormatClass = AccumuloInputFormat.class;
    Configuration conf = new Configuration();

    // Act
    LegacySupport.InputConfigurator.setInputTableName(accumuloInputFormatClass, conf, "Table Name");

    // Assert
    assertEquals(1447, conf.size());
  }

  /**
   * Method under test:
   * {@link LegacySupport.InputConfigurator#setRanges(Class, Configuration, Collection)}
   */
  @Test
  void testInputConfiguratorSetRanges() {
    // Arrange
    Class<AccumuloInputFormat> accumuloInputFormatClass = AccumuloInputFormat.class;
    Configuration conf = new Configuration();

    // Act
    LegacySupport.InputConfigurator.setRanges(accumuloInputFormatClass, conf, new ArrayList<>());

    // Assert
    assertEquals(1447, conf.size());
  }

  /**
   * Method under test:
   * {@link LegacySupport.InputConfigurator#setRanges(Class, Configuration, Collection)}
   */
  @Test
  void testInputConfiguratorSetRanges2() {
    // Arrange
    Class<AccumuloInputFormat> accumuloInputFormatClass = AccumuloInputFormat.class;
    Configuration conf = new Configuration();

    ArrayList<Range> ranges = new ArrayList<>();
    ranges.add(new Range());

    // Act
    LegacySupport.InputConfigurator.setRanges(accumuloInputFormatClass, conf, ranges);

    // Assert
    assertEquals(1447, conf.size());
  }

  /**
   * Method under test:
   * {@link LegacySupport.InputConfigurator#setRanges(Class, Configuration, Collection)}
   */
  @Test
  void testInputConfiguratorSetRanges3() {
    // Arrange
    Class<AccumuloInputFormat> accumuloInputFormatClass = AccumuloInputFormat.class;
    Configuration conf = new Configuration();

    ArrayList<Range> ranges = new ArrayList<>();
    ranges.add(new Range());
    ranges.add(new Range());

    // Act
    LegacySupport.InputConfigurator.setRanges(accumuloInputFormatClass, conf, ranges);

    // Assert
    assertEquals(1447, conf.size());
  }

  /**
   * Method under test:
   * {@link LegacySupport.InputConfigurator#setScanAuthorizations(Class, Configuration, Authorizations)}
   */
  @Test
  void testInputConfiguratorSetScanAuthorizations() {
    // Arrange
    Class<Object> implementingClass = Object.class;
    Configuration conf = new Configuration();
    Authorizations auths = mock(Authorizations.class);
    when(auths.isEmpty()).thenThrow(new RuntimeException("setScanAuthorizations"));

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> LegacySupport.InputConfigurator.setScanAuthorizations(implementingClass, conf, auths));
    verify(auths).isEmpty();
  }

  /**
   * Method under test:
   * {@link LegacySupport.InputConfigurator#setZooKeeperInstance(Class, Configuration, ClientConfiguration)}
   */
  @Test
  void testInputConfiguratorSetZooKeeperInstance() {
    // Arrange
    Class<AccumuloInputFormat> accumuloInputFormatClass = AccumuloInputFormat.class;
    Configuration conf = new Configuration();

    // Act
    LegacySupport.InputConfigurator.setZooKeeperInstance(accumuloInputFormatClass, conf, ClientConfiguration.create());

    // Assert
    assertEquals(1448, conf.size());
  }
}
