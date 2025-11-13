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
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
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
import org.apache.accumulo.core.file.rfile.RFile.Writer;
import org.apache.accumulo.core.security.Authorizations;
import org.apache.accumulo.core.util.Pair;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.FileSystem.Statistics;
import org.apache.hadoop.fs.FilterFileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.Text;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import uk.gov.gchq.gaffer.accumulostore.utils.LegacySupport.BackwardsCompatibleRFileWriter;
import uk.gov.gchq.gaffer.accumulostore.utils.LegacySupport.BackwardsCompatibleReaderBuilder;
import uk.gov.gchq.gaffer.accumulostore.utils.LegacySupport.BackwardsCompatibleWriterBuilder;
import uk.gov.gchq.gaffer.accumulostore.utils.LegacySupport.InputConfigurator;

class LegacySupportDiffblueTest {
  /**
   * Test BackwardsCompatibleRFileWriter {@link BackwardsCompatibleRFileWriter#create(String, Configuration, int)}.
   * <ul>
   *   <li>When empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link BackwardsCompatibleRFileWriter#create(String, Configuration, int)}
   */
  @Test
  @DisplayName("Test BackwardsCompatibleRFileWriter create(String, Configuration, int); when empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RFile.Writer BackwardsCompatibleRFileWriter.create(String, Configuration, int)"})
  void testBackwardsCompatibleRFileWriterCreate_whenEmptyString() {
    // Arrange, Act and Assert
    assertThrows(RuntimeException.class, () -> BackwardsCompatibleRFileWriter.create("", new Configuration(), 3));
  }

  /**
   * Test BackwardsCompatibleRFileWriter {@link BackwardsCompatibleRFileWriter#create(String, Configuration, int)}.
   * <ul>
   *   <li>When {@code ///}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BackwardsCompatibleRFileWriter#create(String, Configuration, int)}
   */
  @Test
  @DisplayName("Test BackwardsCompatibleRFileWriter create(String, Configuration, int); when '///'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RFile.Writer BackwardsCompatibleRFileWriter.create(String, Configuration, int)"})
  void testBackwardsCompatibleRFileWriterCreate_whenSlashSlashSlash() {
    // Arrange, Act and Assert
    assertThrows(RuntimeException.class, () -> BackwardsCompatibleRFileWriter.create("///", new Configuration(), 3));
  }

  /**
   * Test BackwardsCompatibleReaderBuilder {@link BackwardsCompatibleReaderBuilder#create(String, FileSystem, Configuration, AccumuloConfiguration, boolean)}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BackwardsCompatibleReaderBuilder#create(String, FileSystem, Configuration, AccumuloConfiguration, boolean)}
   */
  @Test
  @DisplayName("Test BackwardsCompatibleReaderBuilder create(String, FileSystem, Configuration, AccumuloConfiguration, boolean); then throw RuntimeException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "org.apache.accumulo.core.file.FileSKVIterator BackwardsCompatibleReaderBuilder.create(String, FileSystem, Configuration, AccumuloConfiguration, boolean)"})
  void testBackwardsCompatibleReaderBuilderCreate_thenThrowRuntimeException() {
    // Arrange
    FilterFileSystem fs = new FilterFileSystem();
    Configuration fsConf = new Configuration();

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> BackwardsCompatibleReaderBuilder.create("foo.txt", fs, fsConf, new ConfigurationCopy(), true));
  }

  /**
   * Test BackwardsCompatibleWriterBuilder {@link BackwardsCompatibleWriterBuilder#create(String, FileSystem, Configuration, AccumuloConfiguration)}.
   * <ul>
   *   <li>Then return {@link RFile.Writer}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BackwardsCompatibleWriterBuilder#create(String, FileSystem, Configuration, AccumuloConfiguration)}
   */
  @Test
  @DisplayName("Test BackwardsCompatibleWriterBuilder create(String, FileSystem, Configuration, AccumuloConfiguration); then return Writer")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "FileSKVWriter BackwardsCompatibleWriterBuilder.create(String, FileSystem, Configuration, AccumuloConfiguration)"})
  void testBackwardsCompatibleWriterBuilderCreate_thenReturnWriter() throws IOException {
    // Arrange
    FilterFileSystem fs = mock(FilterFileSystem.class);
    ByteArrayOutputStream out = new ByteArrayOutputStream(1);
    when(fs.create(Mockito.<Path>any(), anyBoolean(), anyInt(), anyShort(), anyLong()))
        .thenReturn(new FSDataOutputStream(out, new Statistics("Scheme")));
    Configuration fsConf = new Configuration();

    // Act
    FileSKVWriter actualCreateResult = BackwardsCompatibleWriterBuilder.create("foo.txt", fs, fsConf,
        DefaultConfiguration.getInstance());

    // Assert
    verify(fs).create(isA(Path.class), eq(false), eq(4096), eq((short) 3), eq(134217728L));
    assertTrue(actualCreateResult instanceof Writer);
    assertEquals(0L, actualCreateResult.getLength());
  }

  /**
   * Test InputConfigurator {@link InputConfigurator#addIterator(Class, Configuration, IteratorSetting)}.
   * <ul>
   *   <li>Then {@link Configuration#Configuration()} size is {@code 1447}.</li>
   * </ul>
   * <p>
   * Method under test: {@link InputConfigurator#addIterator(Class, Configuration, IteratorSetting)}
   */
  @Test
  @DisplayName("Test InputConfigurator addIterator(Class, Configuration, IteratorSetting); then Configuration() size is '1447'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void InputConfigurator.addIterator(Class, Configuration, IteratorSetting)"})
  void testInputConfiguratorAddIterator_thenConfigurationSizeIs1447() {
    // Arrange
    Class<AccumuloInputFormat> accumuloInputFormatClass = AccumuloInputFormat.class;
    Configuration conf = new Configuration();

    // Act
    InputConfigurator.addIterator(accumuloInputFormatClass, conf, new IteratorSetting(1, "Name", "Iterator Class"));

    // Assert
    assertEquals(1447, conf.size());
  }

  /**
   * Test InputConfigurator {@link InputConfigurator#fetchColumns(Class, Configuration, Collection)}.
   * <ul>
   *   <li>Given {@link Pair#Pair(Object, Object)} with f is {@link Text#Text()} and s is {@link Text#Text()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link InputConfigurator#fetchColumns(Class, Configuration, Collection)}
   */
  @Test
  @DisplayName("Test InputConfigurator fetchColumns(Class, Configuration, Collection); given Pair(Object, Object) with f is Text() and s is Text()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void InputConfigurator.fetchColumns(Class, Configuration, Collection)"})
  void testInputConfiguratorFetchColumns_givenPairWithFIsTextAndSIsText() {
    // Arrange
    Class<AccumuloInputFormat> accumuloInputFormatClass = AccumuloInputFormat.class;
    Configuration conf = new Configuration();

    ArrayList<Pair<Text, Text>> columnFamilyColumnQualifierPairs = new ArrayList<>();
    Text text = new Text();
    columnFamilyColumnQualifierPairs.add(new Pair<>(text, new Text()));

    // Act
    InputConfigurator.fetchColumns(accumuloInputFormatClass, conf, columnFamilyColumnQualifierPairs);

    // Assert
    assertEquals(1447, conf.size());
  }

  /**
   * Test InputConfigurator {@link InputConfigurator#fetchColumns(Class, Configuration, Collection)}.
   * <ul>
   *   <li>Given {@link Pair#Pair(Object, Object)} with f is {@link Text#Text()} and s is {@link Text#Text()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link InputConfigurator#fetchColumns(Class, Configuration, Collection)}
   */
  @Test
  @DisplayName("Test InputConfigurator fetchColumns(Class, Configuration, Collection); given Pair(Object, Object) with f is Text() and s is Text()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void InputConfigurator.fetchColumns(Class, Configuration, Collection)"})
  void testInputConfiguratorFetchColumns_givenPairWithFIsTextAndSIsText2() {
    // Arrange
    Class<AccumuloInputFormat> accumuloInputFormatClass = AccumuloInputFormat.class;
    Configuration conf = new Configuration();

    ArrayList<Pair<Text, Text>> columnFamilyColumnQualifierPairs = new ArrayList<>();
    Text text = new Text();
    columnFamilyColumnQualifierPairs.add(new Pair<>(text, new Text()));
    Text text2 = new Text();
    columnFamilyColumnQualifierPairs.add(new Pair<>(text2, new Text()));

    // Act
    InputConfigurator.fetchColumns(accumuloInputFormatClass, conf, columnFamilyColumnQualifierPairs);

    // Assert
    assertEquals(1447, conf.size());
  }

  /**
   * Test InputConfigurator {@link InputConfigurator#fetchColumns(Class, Configuration, Collection)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then {@link Configuration#Configuration()} size is {@code 1447}.</li>
   * </ul>
   * <p>
   * Method under test: {@link InputConfigurator#fetchColumns(Class, Configuration, Collection)}
   */
  @Test
  @DisplayName("Test InputConfigurator fetchColumns(Class, Configuration, Collection); when ArrayList(); then Configuration() size is '1447'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void InputConfigurator.fetchColumns(Class, Configuration, Collection)"})
  void testInputConfiguratorFetchColumns_whenArrayList_thenConfigurationSizeIs1447() {
    // Arrange
    Class<AccumuloInputFormat> accumuloInputFormatClass = AccumuloInputFormat.class;
    Configuration conf = new Configuration();

    // Act
    InputConfigurator.fetchColumns(accumuloInputFormatClass, conf, new ArrayList<>());

    // Assert
    assertEquals(1447, conf.size());
  }

  /**
   * Test InputConfigurator {@link InputConfigurator#getFetchedColumns(Class, Configuration)}.
   * <ul>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link InputConfigurator#getFetchedColumns(Class, Configuration)}
   */
  @Test
  @DisplayName("Test InputConfigurator getFetchedColumns(Class, Configuration); then return Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Set InputConfigurator.getFetchedColumns(Class, Configuration)"})
  void testInputConfiguratorGetFetchedColumns_thenReturnEmpty() {
    // Arrange
    Class<AccumuloInputFormat> accumuloInputFormatClass = AccumuloInputFormat.class;

    // Act
    Set<Pair<Text, Text>> actualFetchedColumns = InputConfigurator.getFetchedColumns(accumuloInputFormatClass,
        new Configuration());

    // Assert
    assertTrue(actualFetchedColumns.isEmpty());
  }

  /**
   * Test InputConfigurator {@link InputConfigurator#getIterators(Class, Configuration)}.
   * <ul>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link InputConfigurator#getIterators(Class, Configuration)}
   */
  @Test
  @DisplayName("Test InputConfigurator getIterators(Class, Configuration); then return Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List InputConfigurator.getIterators(Class, Configuration)"})
  void testInputConfiguratorGetIterators_thenReturnEmpty() {
    // Arrange
    Class<AccumuloInputFormat> accumuloInputFormatClass = AccumuloInputFormat.class;

    // Act
    List<IteratorSetting> actualIterators = InputConfigurator.getIterators(accumuloInputFormatClass,
        new Configuration());

    // Assert
    assertTrue(actualIterators.isEmpty());
  }

  /**
   * Test InputConfigurator {@link InputConfigurator#setBatchScan(Class, Configuration, boolean)}.
   * <ul>
   *   <li>Then {@link Configuration#Configuration()} size is {@code 1447}.</li>
   * </ul>
   * <p>
   * Method under test: {@link InputConfigurator#setBatchScan(Class, Configuration, boolean)}
   */
  @Test
  @DisplayName("Test InputConfigurator setBatchScan(Class, Configuration, boolean); then Configuration() size is '1447'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void InputConfigurator.setBatchScan(Class, Configuration, boolean)"})
  void testInputConfiguratorSetBatchScan_thenConfigurationSizeIs1447() {
    // Arrange
    Class<AccumuloInputFormat> accumuloInputFormatClass = AccumuloInputFormat.class;
    Configuration conf = new Configuration();

    // Act
    InputConfigurator.setBatchScan(accumuloInputFormatClass, conf, true);

    // Assert
    assertEquals(1447, conf.size());
  }

  /**
   * Test InputConfigurator {@link InputConfigurator#setConnectorInfo(Class, Configuration, String, AuthenticationToken)}.
   * <ul>
   *   <li>Then {@link Configuration#Configuration()} size is {@code 1449}.</li>
   * </ul>
   * <p>
   * Method under test: {@link InputConfigurator#setConnectorInfo(Class, Configuration, String, AuthenticationToken)}
   */
  @Test
  @DisplayName("Test InputConfigurator setConnectorInfo(Class, Configuration, String, AuthenticationToken); then Configuration() size is '1449'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void InputConfigurator.setConnectorInfo(Class, Configuration, String, AuthenticationToken)"})
  void testInputConfiguratorSetConnectorInfo_thenConfigurationSizeIs1449() {
    // Arrange
    Class<AccumuloInputFormat> accumuloInputFormatClass = AccumuloInputFormat.class;
    Configuration conf = new Configuration();

    // Act
    InputConfigurator.setConnectorInfo(accumuloInputFormatClass, conf, "User", new CredentialProviderToken());

    // Assert
    assertEquals(1449, conf.size());
  }

  /**
   * Test InputConfigurator {@link InputConfigurator#setInputTableName(Class, Configuration, String)}.
   * <ul>
   *   <li>Then {@link Configuration#Configuration()} size is {@code 1447}.</li>
   * </ul>
   * <p>
   * Method under test: {@link InputConfigurator#setInputTableName(Class, Configuration, String)}
   */
  @Test
  @DisplayName("Test InputConfigurator setInputTableName(Class, Configuration, String); then Configuration() size is '1447'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void InputConfigurator.setInputTableName(Class, Configuration, String)"})
  void testInputConfiguratorSetInputTableName_thenConfigurationSizeIs1447() {
    // Arrange
    Class<AccumuloInputFormat> accumuloInputFormatClass = AccumuloInputFormat.class;
    Configuration conf = new Configuration();

    // Act
    InputConfigurator.setInputTableName(accumuloInputFormatClass, conf, "Table Name");

    // Assert
    assertEquals(1447, conf.size());
  }

  /**
   * Test InputConfigurator {@link InputConfigurator#setRanges(Class, Configuration, Collection)}.
   * <ul>
   *   <li>Given {@link Range#Range()}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@link Range#Range()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link InputConfigurator#setRanges(Class, Configuration, Collection)}
   */
  @Test
  @DisplayName("Test InputConfigurator setRanges(Class, Configuration, Collection); given Range(); when ArrayList() add Range()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void InputConfigurator.setRanges(Class, Configuration, Collection)"})
  void testInputConfiguratorSetRanges_givenRange_whenArrayListAddRange() {
    // Arrange
    Class<AccumuloInputFormat> accumuloInputFormatClass = AccumuloInputFormat.class;
    Configuration conf = new Configuration();

    ArrayList<Range> ranges = new ArrayList<>();
    ranges.add(new Range());

    // Act
    InputConfigurator.setRanges(accumuloInputFormatClass, conf, ranges);

    // Assert
    assertEquals(1447, conf.size());
  }

  /**
   * Test InputConfigurator {@link InputConfigurator#setRanges(Class, Configuration, Collection)}.
   * <ul>
   *   <li>Given {@link Range#Range()}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@link Range#Range()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link InputConfigurator#setRanges(Class, Configuration, Collection)}
   */
  @Test
  @DisplayName("Test InputConfigurator setRanges(Class, Configuration, Collection); given Range(); when ArrayList() add Range()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void InputConfigurator.setRanges(Class, Configuration, Collection)"})
  void testInputConfiguratorSetRanges_givenRange_whenArrayListAddRange2() {
    // Arrange
    Class<AccumuloInputFormat> accumuloInputFormatClass = AccumuloInputFormat.class;
    Configuration conf = new Configuration();

    ArrayList<Range> ranges = new ArrayList<>();
    ranges.add(new Range());
    ranges.add(new Range());

    // Act
    InputConfigurator.setRanges(accumuloInputFormatClass, conf, ranges);

    // Assert
    assertEquals(1447, conf.size());
  }

  /**
   * Test InputConfigurator {@link InputConfigurator#setRanges(Class, Configuration, Collection)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then {@link Configuration#Configuration()} size is {@code 1447}.</li>
   * </ul>
   * <p>
   * Method under test: {@link InputConfigurator#setRanges(Class, Configuration, Collection)}
   */
  @Test
  @DisplayName("Test InputConfigurator setRanges(Class, Configuration, Collection); when ArrayList(); then Configuration() size is '1447'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void InputConfigurator.setRanges(Class, Configuration, Collection)"})
  void testInputConfiguratorSetRanges_whenArrayList_thenConfigurationSizeIs1447() {
    // Arrange
    Class<AccumuloInputFormat> accumuloInputFormatClass = AccumuloInputFormat.class;
    Configuration conf = new Configuration();

    // Act
    InputConfigurator.setRanges(accumuloInputFormatClass, conf, new ArrayList<>());

    // Assert
    assertEquals(1447, conf.size());
  }

  /**
   * Test InputConfigurator {@link InputConfigurator#setScanAuthorizations(Class, Configuration, Authorizations)}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link InputConfigurator#setScanAuthorizations(Class, Configuration, Authorizations)}
   */
  @Test
  @DisplayName("Test InputConfigurator setScanAuthorizations(Class, Configuration, Authorizations); then throw RuntimeException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void InputConfigurator.setScanAuthorizations(Class, Configuration, Authorizations)"})
  void testInputConfiguratorSetScanAuthorizations_thenThrowRuntimeException() {
    // Arrange
    Class<Object> implementingClass = Object.class;
    Configuration conf = new Configuration();
    Authorizations auths = mock(Authorizations.class);
    when(auths.isEmpty()).thenThrow(new RuntimeException("setScanAuthorizations"));

    // Act and Assert
    assertThrows(RuntimeException.class, () -> InputConfigurator.setScanAuthorizations(implementingClass, conf, auths));
    verify(auths).isEmpty();
  }

  /**
   * Test InputConfigurator {@link InputConfigurator#setZooKeeperInstance(Class, Configuration, ClientConfiguration)}.
   * <ul>
   *   <li>Then {@link Configuration#Configuration()} size is {@code 1448}.</li>
   * </ul>
   * <p>
   * Method under test: {@link InputConfigurator#setZooKeeperInstance(Class, Configuration, ClientConfiguration)}
   */
  @Test
  @DisplayName("Test InputConfigurator setZooKeeperInstance(Class, Configuration, ClientConfiguration); then Configuration() size is '1448'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void InputConfigurator.setZooKeeperInstance(Class, Configuration, ClientConfiguration)"})
  void testInputConfiguratorSetZooKeeperInstance_thenConfigurationSizeIs1448() {
    // Arrange
    Class<AccumuloInputFormat> accumuloInputFormatClass = AccumuloInputFormat.class;
    Configuration conf = new Configuration();

    // Act
    InputConfigurator.setZooKeeperInstance(accumuloInputFormatClass, conf, ClientConfiguration.create());

    // Assert
    assertEquals(1448, conf.size());
  }
}
