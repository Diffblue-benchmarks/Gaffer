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

package uk.gov.gchq.gaffer.accumulostore.operation.hdfs.handler.job.partitioner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import java.net.URI;
import javassist.Loader;
import org.apache.accumulo.core.client.IteratorSetting;
import org.apache.accumulo.core.data.Key;
import org.apache.accumulo.core.data.Value;
import org.apache.accumulo.core.iterators.SortedKeyValueIterator;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.conf.ConfigurationWithLogging;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.Writable;
import org.apache.hadoop.mapred.JobConf;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.yarn.conf.YarnConfiguration;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class GafferRangePartitionerDiffblueTest {
  /**
   * Test {@link GafferRangePartitioner#getPartition(Text, Writable, int)} with {@code Text}, {@code
   * Writable}, {@code int}.
   *
   * <p>Method under test: {@link GafferRangePartitioner#getPartition(Text, Writable, int)}
   */
  @Test
  @DisplayName("Test getPartition(Text, Writable, int) with 'Text', 'Writable', 'int'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int GafferRangePartitioner.getPartition(Text, Writable, int)"})
  void testGetPartitionWithTextWritableInt() {
    // Arrange
    GafferRangePartitioner gafferRangePartitioner = new GafferRangePartitioner();
    gafferRangePartitioner.setConf(new ConfigurationWithLogging(new Configuration()));
    Text key = new Text();
    Class<SortedKeyValueIterator> forNameResult = SortedKeyValueIterator.class;

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            gafferRangePartitioner.getPartition(
                key,
                new IteratorSetting(
                    1, (Class<SortedKeyValueIterator<Key, Value>>) (Class) forNameResult),
                10));
  }

  /**
   * Test {@link GafferRangePartitioner#getPartition(Text, Writable, int)} with {@code Text}, {@code
   * Writable}, {@code int}.
   *
   * <p>Method under test: {@link GafferRangePartitioner#getPartition(Text, Writable, int)}
   */
  @Test
  @DisplayName("Test getPartition(Text, Writable, int) with 'Text', 'Writable', 'int'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int GafferRangePartitioner.getPartition(Text, Writable, int)"})
  void testGetPartitionWithTextWritableInt2() {
    // Arrange
    GafferRangePartitioner gafferRangePartitioner = new GafferRangePartitioner();
    gafferRangePartitioner.setConf(new YarnConfiguration(new Configuration()));
    Text key = new Text();
    Class<SortedKeyValueIterator> forNameResult = SortedKeyValueIterator.class;

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            gafferRangePartitioner.getPartition(
                key,
                new IteratorSetting(
                    1, (Class<SortedKeyValueIterator<Key, Value>>) (Class) forNameResult),
                10));
  }

  /**
   * Test {@link GafferRangePartitioner#getPartition(Text, Writable, int)} with {@code Text}, {@code
   * Writable}, {@code int}.
   *
   * <p>Method under test: {@link GafferRangePartitioner#getPartition(Text, Writable, int)}
   */
  @Test
  @DisplayName("Test getPartition(Text, Writable, int) with 'Text', 'Writable', 'int'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int GafferRangePartitioner.getPartition(Text, Writable, int)"})
  void testGetPartitionWithTextWritableInt3() throws IllegalArgumentException {
    // Arrange
    Configuration conf = new Configuration();
    conf.addResource(new Path(" not found in distributed cache"));
    conf.addResource(" not found in distributed cache");

    GafferRangePartitioner gafferRangePartitioner = new GafferRangePartitioner();
    gafferRangePartitioner.setConf(conf);
    Text key = new Text();
    Class<SortedKeyValueIterator> forNameResult = SortedKeyValueIterator.class;

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            gafferRangePartitioner.getPartition(
                key,
                new IteratorSetting(
                    1, (Class<SortedKeyValueIterator<Key, Value>>) (Class) forNameResult),
                10));
  }

  /**
   * Test {@link GafferRangePartitioner#getPartition(Text, Writable, int)} with {@code Text}, {@code
   * Writable}, {@code int}.
   *
   * <p>Method under test: {@link GafferRangePartitioner#getPartition(Text, Writable, int)}
   */
  @Test
  @DisplayName("Test getPartition(Text, Writable, int) with 'Text', 'Writable', 'int'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int GafferRangePartitioner.getPartition(Text, Writable, int)"})
  void testGetPartitionWithTextWritableInt4() {
    // Arrange
    Configuration conf = new Configuration();
    conf.setAllowNullValueProperties(true);
    conf.addResource(" not found in distributed cache");

    GafferRangePartitioner gafferRangePartitioner = new GafferRangePartitioner();
    gafferRangePartitioner.setConf(conf);
    Text key = new Text();
    Class<SortedKeyValueIterator> forNameResult = SortedKeyValueIterator.class;

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            gafferRangePartitioner.getPartition(
                key,
                new IteratorSetting(
                    1, (Class<SortedKeyValueIterator<Key, Value>>) (Class) forNameResult),
                10));
  }

  /**
   * Test {@link GafferRangePartitioner#getPartition(Text, Writable, int)} with {@code Text}, {@code
   * Writable}, {@code int}.
   *
   * <ul>
   *   <li>Given {@link Configuration#Configuration()} addResource {@link
   *       Configuration#Configuration()}.
   * </ul>
   *
   * <p>Method under test: {@link GafferRangePartitioner#getPartition(Text, Writable, int)}
   */
  @Test
  @DisplayName(
      "Test getPartition(Text, Writable, int) with 'Text', 'Writable', 'int'; given Configuration() addResource Configuration()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int GafferRangePartitioner.getPartition(Text, Writable, int)"})
  void testGetPartitionWithTextWritableInt_givenConfigurationAddResourceConfiguration() {
    // Arrange
    Configuration conf = new Configuration();
    conf.addResource(new Configuration());
    conf.addResource(" not found in distributed cache");

    GafferRangePartitioner gafferRangePartitioner = new GafferRangePartitioner();
    gafferRangePartitioner.setConf(conf);
    Text key = new Text();
    Class<SortedKeyValueIterator> forNameResult = SortedKeyValueIterator.class;

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            gafferRangePartitioner.getPartition(
                key,
                new IteratorSetting(
                    1, (Class<SortedKeyValueIterator<Key, Value>>) (Class) forNameResult),
                10));
  }

  /**
   * Test {@link GafferRangePartitioner#getPartition(Text, Writable, int)} with {@code Text}, {@code
   * Writable}, {@code int}.
   *
   * <ul>
   *   <li>Given {@link Configuration#Configuration()} ClassLoader is {@link Loader#Loader()}.
   * </ul>
   *
   * <p>Method under test: {@link GafferRangePartitioner#getPartition(Text, Writable, int)}
   */
  @Test
  @DisplayName(
      "Test getPartition(Text, Writable, int) with 'Text', 'Writable', 'int'; given Configuration() ClassLoader is Loader()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int GafferRangePartitioner.getPartition(Text, Writable, int)"})
  void testGetPartitionWithTextWritableInt_givenConfigurationClassLoaderIsLoader() {
    // Arrange
    Configuration conf = new Configuration();
    conf.setClassLoader(new Loader());
    conf.addResource(" not found in distributed cache");

    GafferRangePartitioner gafferRangePartitioner = new GafferRangePartitioner();
    gafferRangePartitioner.setConf(conf);
    Text key = new Text();
    Class<SortedKeyValueIterator> forNameResult = SortedKeyValueIterator.class;

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            gafferRangePartitioner.getPartition(
                key,
                new IteratorSetting(
                    1, (Class<SortedKeyValueIterator<Key, Value>>) (Class) forNameResult),
                10));
  }

  /**
   * Test {@link GafferRangePartitioner#getPartition(Text, Writable, int)} with {@code Text}, {@code
   * Writable}, {@code int}.
   *
   * <ul>
   *   <li>Given {@link GafferRangePartitioner} (default constructor) Conf is {@link
   *       JobConf#JobConf()}.
   * </ul>
   *
   * <p>Method under test: {@link GafferRangePartitioner#getPartition(Text, Writable, int)}
   */
  @Test
  @DisplayName(
      "Test getPartition(Text, Writable, int) with 'Text', 'Writable', 'int'; given GafferRangePartitioner (default constructor) Conf is JobConf()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int GafferRangePartitioner.getPartition(Text, Writable, int)"})
  void testGetPartitionWithTextWritableInt_givenGafferRangePartitionerConfIsJobConf() {
    // Arrange
    GafferRangePartitioner gafferRangePartitioner = new GafferRangePartitioner();
    gafferRangePartitioner.setConf(new JobConf());
    Text key = new Text();
    Class<SortedKeyValueIterator> forNameResult = SortedKeyValueIterator.class;

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            gafferRangePartitioner.getPartition(
                key,
                new IteratorSetting(
                    1, (Class<SortedKeyValueIterator<Key, Value>>) (Class) forNameResult),
                10));
  }

  /**
   * Test {@link GafferRangePartitioner#getPartition(Text, Writable, int)} with {@code Text}, {@code
   * Writable}, {@code int}.
   *
   * <ul>
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link GafferRangePartitioner#getPartition(Text, Writable, int)}
   */
  @Test
  @DisplayName(
      "Test getPartition(Text, Writable, int) with 'Text', 'Writable', 'int'; then throw RuntimeException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int GafferRangePartitioner.getPartition(Text, Writable, int)"})
  void testGetPartitionWithTextWritableInt_thenThrowRuntimeException() {
    // Arrange
    GafferRangePartitioner gafferRangePartitioner = new GafferRangePartitioner();
    gafferRangePartitioner.setConf(new Configuration());
    Text key = new Text();
    Class<SortedKeyValueIterator> forNameResult = SortedKeyValueIterator.class;

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            gafferRangePartitioner.getPartition(
                key,
                new IteratorSetting(
                    1, (Class<SortedKeyValueIterator<Key, Value>>) (Class) forNameResult),
                10));
  }

  /**
   * Test {@link GafferRangePartitioner#getPartition(Text, Writable, int)} with {@code Text}, {@code
   * Writable}, {@code int}.
   *
   * <ul>
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link GafferRangePartitioner#getPartition(Text, Writable, int)}
   */
  @Test
  @DisplayName(
      "Test getPartition(Text, Writable, int) with 'Text', 'Writable', 'int'; then throw RuntimeException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int GafferRangePartitioner.getPartition(Text, Writable, int)"})
  void testGetPartitionWithTextWritableInt_thenThrowRuntimeException2() {
    // Arrange
    Configuration conf = new Configuration();
    conf.addResource(" not found in distributed cache");

    GafferRangePartitioner gafferRangePartitioner = new GafferRangePartitioner();
    gafferRangePartitioner.setConf(conf);
    Text key = new Text();
    Class<SortedKeyValueIterator> forNameResult = SortedKeyValueIterator.class;

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            gafferRangePartitioner.getPartition(
                key,
                new IteratorSetting(
                    1, (Class<SortedKeyValueIterator<Key, Value>>) (Class) forNameResult),
                10));
  }

  /**
   * Test {@link GafferRangePartitioner#findPartition(Text, Text[], int)}.
   *
   * <ul>
   *   <li>Given {@link GafferRangePartitioner} (default constructor) Conf is {@link
   *       Configuration#Configuration()}.
   *   <li>When one.
   * </ul>
   *
   * <p>Method under test: {@link GafferRangePartitioner#findPartition(Text, Text[], int)}
   */
  @Test
  @DisplayName(
      "Test findPartition(Text, Text[], int); given GafferRangePartitioner (default constructor) Conf is Configuration(); when one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int GafferRangePartitioner.findPartition(Text, Text[], int)"})
  void testFindPartition_givenGafferRangePartitionerConfIsConfiguration_whenOne() {
    // Arrange
    GafferRangePartitioner gafferRangePartitioner = new GafferRangePartitioner();
    gafferRangePartitioner.setConf(new Configuration());
    Text key = new Text();

    // Act and Assert
    assertEquals(0, gafferRangePartitioner.findPartition(key, new Text[] {new Text()}, 1));
  }

  /**
   * Test {@link GafferRangePartitioner#findPartition(Text, Text[], int)}.
   *
   * <ul>
   *   <li>Given {@link GafferRangePartitioner} (default constructor) Conf is {@link
   *       Configuration#Configuration()}.
   *   <li>When two.
   * </ul>
   *
   * <p>Method under test: {@link GafferRangePartitioner#findPartition(Text, Text[], int)}
   */
  @Test
  @DisplayName(
      "Test findPartition(Text, Text[], int); given GafferRangePartitioner (default constructor) Conf is Configuration(); when two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int GafferRangePartitioner.findPartition(Text, Text[], int)"})
  void testFindPartition_givenGafferRangePartitionerConfIsConfiguration_whenTwo() {
    // Arrange
    GafferRangePartitioner gafferRangePartitioner = new GafferRangePartitioner();
    gafferRangePartitioner.setConf(new Configuration());
    Text key = new Text();

    // Act and Assert
    assertEquals(0, gafferRangePartitioner.findPartition(key, new Text[] {new Text()}, 2));
  }

  /**
   * Test {@link GafferRangePartitioner#findPartition(Text, Text[], int)}.
   *
   * <ul>
   *   <li>Given {@link GafferRangePartitioner} (default constructor).
   *   <li>When {@link Text#Text()}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link GafferRangePartitioner#findPartition(Text, Text[], int)}
   */
  @Test
  @DisplayName(
      "Test findPartition(Text, Text[], int); given GafferRangePartitioner (default constructor); when Text(); then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int GafferRangePartitioner.findPartition(Text, Text[], int)"})
  void testFindPartition_givenGafferRangePartitioner_whenText_thenReturnZero() {
    // Arrange
    GafferRangePartitioner gafferRangePartitioner = new GafferRangePartitioner();
    Text key = new Text();

    // Act and Assert
    assertEquals(0, gafferRangePartitioner.findPartition(key, new Text[] {new Text()}, 10));
  }

  /**
   * Test {@link GafferRangePartitioner#findPartition(Text, Text[], int)}.
   *
   * <ul>
   *   <li>When array of {@link Text} with {@link Text#Text()} and {@link Text#Text()}.
   *   <li>Then return twenty-three.
   * </ul>
   *
   * <p>Method under test: {@link GafferRangePartitioner#findPartition(Text, Text[], int)}
   */
  @Test
  @DisplayName(
      "Test findPartition(Text, Text[], int); when array of Text with Text() and Text(); then return twenty-three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int GafferRangePartitioner.findPartition(Text, Text[], int)"})
  void testFindPartition_whenArrayOfTextWithTextAndText_thenReturnTwentyThree() {
    // Arrange
    GafferRangePartitioner gafferRangePartitioner = new GafferRangePartitioner();
    Text key = new Text("String");
    Text text = new Text();

    // Act
    int actualFindPartitionResult =
        gafferRangePartitioner.findPartition(key, new Text[] {text, new Text()}, 10);

    // Assert
    assertEquals(23, actualFindPartitionResult);
  }

  /**
   * Test {@link GafferRangePartitioner#findPartition(Text, Text[], int)}.
   *
   * <ul>
   *   <li>When empty array of {@link Text}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link GafferRangePartitioner#findPartition(Text, Text[], int)}
   */
  @Test
  @DisplayName("Test findPartition(Text, Text[], int); when empty array of Text; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int GafferRangePartitioner.findPartition(Text, Text[], int)"})
  void testFindPartition_whenEmptyArrayOfText_thenReturnZero() {
    // Arrange
    GafferRangePartitioner gafferRangePartitioner = new GafferRangePartitioner();

    // Act and Assert
    assertEquals(0, gafferRangePartitioner.findPartition(new Text(), new Text[] {}, 10));
  }

  /**
   * Test {@link GafferRangePartitioner#findPartition(Text, Text[], int)}.
   *
   * <ul>
   *   <li>When {@link Text#Text(String)} with {@code String}.
   *   <li>Then return thirteen.
   * </ul>
   *
   * <p>Method under test: {@link GafferRangePartitioner#findPartition(Text, Text[], int)}
   */
  @Test
  @DisplayName(
      "Test findPartition(Text, Text[], int); when Text(String) with 'String'; then return thirteen")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int GafferRangePartitioner.findPartition(Text, Text[], int)"})
  void testFindPartition_whenTextWithString_thenReturnThirteen() {
    // Arrange
    GafferRangePartitioner gafferRangePartitioner = new GafferRangePartitioner();
    Text key = new Text("String");

    // Act
    int actualFindPartitionResult =
        gafferRangePartitioner.findPartition(key, new Text[] {new Text()}, 10);

    // Assert
    assertEquals(13, actualFindPartitionResult);
  }

  /**
   * Test {@link GafferRangePartitioner#setSplitFile(Job, String)}.
   *
   * <ul>
   *   <li>When {@code ///}.
   *   <li>Then first element toString is {@code ///}.
   * </ul>
   *
   * <p>Method under test: {@link GafferRangePartitioner#setSplitFile(Job, String)}
   */
  @Test
  @DisplayName("Test setSplitFile(Job, String); when '///'; then first element toString is '///'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void GafferRangePartitioner.setSplitFile(Job, String)"})
  void testSetSplitFile_whenSlashSlashSlash_thenFirstElementToStringIsSlashSlashSlash()
      throws IOException {
    // Arrange
    Job job = new Job();

    // Act
    GafferRangePartitioner.setSplitFile(job, "///");

    // Assert
    Configuration configuration = job.getConfiguration();
    assertTrue(configuration instanceof JobConf);
    URI[] cacheFiles = job.getCacheFiles();
    assertEquals("///", cacheFiles[0].toString());
    assertEquals(1, cacheFiles.length);
    assertEquals(1448, configuration.size());
  }

  /**
   * Test {@link GafferRangePartitioner#setNumSubBins(Job, int)}.
   *
   * <ul>
   *   <li>When {@link Job#Job()}.
   *   <li>Then {@link Job#Job()} Configuration {@link JobConf}.
   * </ul>
   *
   * <p>Method under test: {@link GafferRangePartitioner#setNumSubBins(Job, int)}
   */
  @Test
  @DisplayName("Test setNumSubBins(Job, int); when Job(); then Job() Configuration JobConf")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void GafferRangePartitioner.setNumSubBins(Job, int)"})
  void testSetNumSubBins_whenJob_thenJobConfigurationJobConf() throws IOException {
    // Arrange
    Job job = new Job();

    // Act
    GafferRangePartitioner.setNumSubBins(job, 10);

    // Assert
    Configuration configuration = job.getConfiguration();
    assertTrue(configuration instanceof JobConf);
    assertEquals(1447, configuration.size());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link GafferRangePartitioner}
   *   <li>{@link GafferRangePartitioner#setConf(Configuration)}
   *   <li>{@link GafferRangePartitioner#getConf()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void GafferRangePartitioner.<init>()",
    "Configuration GafferRangePartitioner.getConf()",
    "void GafferRangePartitioner.setConf(Configuration)"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    GafferRangePartitioner actualGafferRangePartitioner = new GafferRangePartitioner();
    Configuration conf = new Configuration();
    actualGafferRangePartitioner.setConf(conf);

    // Assert
    assertSame(conf, actualGafferRangePartitioner.getConf());
  }
}
