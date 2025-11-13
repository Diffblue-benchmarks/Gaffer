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

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import java.util.ArrayList;
import org.apache.accumulo.core.bloomfilter.BloomFilter;
import org.apache.accumulo.core.data.ArrayByteSequence;
import org.apache.accumulo.core.data.ByteSequence;
import org.apache.accumulo.core.data.Key;
import org.apache.accumulo.core.data.Value;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.Writable;
import org.apache.hadoop.io.WritableComparator;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.output.SequenceFileOutputFormat;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.accumulostore.AccumuloStore;
import uk.gov.gchq.gaffer.accumulostore.operation.hdfs.mapper.SampleDataForSplitPointsMapper;
import uk.gov.gchq.gaffer.accumulostore.operation.hdfs.reducer.AccumuloKeyValueReducer;
import uk.gov.gchq.gaffer.hdfs.operation.SampleDataForSplitPoints;
import uk.gov.gchq.gaffer.store.Store;
import uk.gov.gchq.gaffer.store.StoreException;

class AccumuloSampleDataForSplitPointsJobFactoryDiffblueTest {
  /**
   * Test {@link AccumuloSampleDataForSplitPointsJobFactory#AccumuloSampleDataForSplitPointsJobFactory()}.
   * <p>
   * Method under test: {@link AccumuloSampleDataForSplitPointsJobFactory#AccumuloSampleDataForSplitPointsJobFactory()}
   */
  @Test
  @DisplayName("Test new AccumuloSampleDataForSplitPointsJobFactory()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void AccumuloSampleDataForSplitPointsJobFactory.<init>()"})
  void testNewAccumuloSampleDataForSplitPointsJobFactory() {
    // Arrange and Act
    AccumuloSampleDataForSplitPointsJobFactory actualAccumuloSampleDataForSplitPointsJobFactory = new AccumuloSampleDataForSplitPointsJobFactory();

    // Assert
    Writable createKeyResult = actualAccumuloSampleDataForSplitPointsJobFactory.createKey();
    ByteSequence columnFamilyData = ((Key) createKeyResult).getColumnFamilyData();
    assertTrue(columnFamilyData instanceof ArrayByteSequence);
    ByteSequence columnQualifierData = ((Key) createKeyResult).getColumnQualifierData();
    assertTrue(columnQualifierData instanceof ArrayByteSequence);
    ByteSequence columnVisibilityData = ((Key) createKeyResult).getColumnVisibilityData();
    assertTrue(columnVisibilityData instanceof ArrayByteSequence);
    ByteSequence rowData = ((Key) createKeyResult).getRowData();
    assertTrue(rowData instanceof ArrayByteSequence);
    assertTrue(createKeyResult instanceof Key);
    Writable createValueResult = actualAccumuloSampleDataForSplitPointsJobFactory.createValue();
    assertTrue(createValueResult instanceof Value);
    assertEquals(0, ((Key) createKeyResult).getLength());
    assertEquals(0, ((Key) createKeyResult).getSize());
    assertEquals(0, ((Value) createValueResult).getSize());
    assertFalse(((Key) createKeyResult).isDeleted());
    assertEquals(Long.MAX_VALUE, ((Key) createKeyResult).getTimestamp());
    assertEquals(columnFamilyData, columnQualifierData);
    assertEquals(columnFamilyData, columnVisibilityData);
    assertEquals(columnFamilyData, rowData);
    assertArrayEquals(new byte[]{}, ((Value) createValueResult).get());
  }

  /**
   * Test {@link AccumuloSampleDataForSplitPointsJobFactory#createSplit(Writable, Writable)}.
   * <ul>
   *   <li>Then return empty array of {@code byte}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AccumuloSampleDataForSplitPointsJobFactory#createSplit(Writable, Writable)}
   */
  @Test
  @DisplayName("Test createSplit(Writable, Writable); then return empty array of byte")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"byte[] AccumuloSampleDataForSplitPointsJobFactory.createSplit(Writable, Writable)"})
  void testCreateSplit_thenReturnEmptyArrayOfByte() {
    // Arrange
    AccumuloSampleDataForSplitPointsJobFactory accumuloSampleDataForSplitPointsJobFactory = new AccumuloSampleDataForSplitPointsJobFactory();
    Key key = new Key();

    // Act and Assert
    assertArrayEquals(new byte[]{},
        accumuloSampleDataForSplitPointsJobFactory.createSplit(key, new BloomFilter(3, 19088743, 1)));
  }

  /**
   * Test {@link AccumuloSampleDataForSplitPointsJobFactory#createKey()}.
   * <p>
   * Method under test: {@link AccumuloSampleDataForSplitPointsJobFactory#createKey()}
   */
  @Test
  @DisplayName("Test createKey()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Writable AccumuloSampleDataForSplitPointsJobFactory.createKey()"})
  void testCreateKey() {
    // Arrange and Act
    Writable actualCreateKeyResult = (new AccumuloSampleDataForSplitPointsJobFactory()).createKey();

    // Assert
    ByteSequence columnFamilyData = ((Key) actualCreateKeyResult).getColumnFamilyData();
    assertTrue(columnFamilyData instanceof ArrayByteSequence);
    ByteSequence columnQualifierData = ((Key) actualCreateKeyResult).getColumnQualifierData();
    assertTrue(columnQualifierData instanceof ArrayByteSequence);
    ByteSequence columnVisibilityData = ((Key) actualCreateKeyResult).getColumnVisibilityData();
    assertTrue(columnVisibilityData instanceof ArrayByteSequence);
    ByteSequence rowData = ((Key) actualCreateKeyResult).getRowData();
    assertTrue(rowData instanceof ArrayByteSequence);
    assertTrue(actualCreateKeyResult instanceof Key);
    assertEquals(0, ((Key) actualCreateKeyResult).getLength());
    assertEquals(0, ((Key) actualCreateKeyResult).getSize());
    assertFalse(((Key) actualCreateKeyResult).isDeleted());
    assertEquals(Long.MAX_VALUE, ((Key) actualCreateKeyResult).getTimestamp());
    assertEquals(columnFamilyData, columnQualifierData);
    assertEquals(columnFamilyData, columnVisibilityData);
    assertEquals(columnFamilyData, rowData);
  }

  /**
   * Test {@link AccumuloSampleDataForSplitPointsJobFactory#createValue()}.
   * <p>
   * Method under test: {@link AccumuloSampleDataForSplitPointsJobFactory#createValue()}
   */
  @Test
  @DisplayName("Test createValue()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Writable AccumuloSampleDataForSplitPointsJobFactory.createValue()"})
  void testCreateValue() {
    // Arrange and Act
    Writable actualCreateValueResult = (new AccumuloSampleDataForSplitPointsJobFactory()).createValue();

    // Assert
    assertTrue(actualCreateValueResult instanceof Value);
    assertEquals(0, ((Value) actualCreateValueResult).getSize());
    assertArrayEquals(new byte[]{}, ((Value) actualCreateValueResult).get());
  }

  /**
   * Test {@link AccumuloSampleDataForSplitPointsJobFactory#getExpectedNumberOfSplits(Store)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return minus one.</li>
   * </ul>
   * <p>
   * Method under test: {@link AccumuloSampleDataForSplitPointsJobFactory#getExpectedNumberOfSplits(Store)}
   */
  @Test
  @DisplayName("Test getExpectedNumberOfSplits(Store); given ArrayList(); then return minus one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int AccumuloSampleDataForSplitPointsJobFactory.getExpectedNumberOfSplits(Store)"})
  void testGetExpectedNumberOfSplits_givenArrayList_thenReturnMinusOne() throws StoreException {
    // Arrange
    AccumuloSampleDataForSplitPointsJobFactory accumuloSampleDataForSplitPointsJobFactory = new AccumuloSampleDataForSplitPointsJobFactory();
    AccumuloStore store = mock(AccumuloStore.class);
    when(store.getTabletServers()).thenReturn(new ArrayList<>());

    // Act
    int actualExpectedNumberOfSplits = accumuloSampleDataForSplitPointsJobFactory.getExpectedNumberOfSplits(store);

    // Assert
    verify(store).getTabletServers();
    assertEquals(-1, actualExpectedNumberOfSplits);
  }

  /**
   * Test {@link AccumuloSampleDataForSplitPointsJobFactory#getExpectedNumberOfSplits(Store)}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AccumuloSampleDataForSplitPointsJobFactory#getExpectedNumberOfSplits(Store)}
   */
  @Test
  @DisplayName("Test getExpectedNumberOfSplits(Store); then throw RuntimeException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int AccumuloSampleDataForSplitPointsJobFactory.getExpectedNumberOfSplits(Store)"})
  void testGetExpectedNumberOfSplits_thenThrowRuntimeException() throws StoreException {
    // Arrange
    AccumuloSampleDataForSplitPointsJobFactory accumuloSampleDataForSplitPointsJobFactory = new AccumuloSampleDataForSplitPointsJobFactory();
    AccumuloStore store = mock(AccumuloStore.class);
    when(store.getTabletServers()).thenThrow(new StoreException("An error occurred"));

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> accumuloSampleDataForSplitPointsJobFactory.getExpectedNumberOfSplits(store));
    verify(store).getTabletServers();
  }

  /**
   * Test {@link AccumuloSampleDataForSplitPointsJobFactory#setupJob(Job, SampleDataForSplitPoints, String, Store)} with {@code Job}, {@code SampleDataForSplitPoints}, {@code String}, {@code Store}.
   * <p>
   * Method under test: {@link AccumuloSampleDataForSplitPointsJobFactory#setupJob(Job, SampleDataForSplitPoints, String, Store)}
   */
  @Test
  @DisplayName("Test setupJob(Job, SampleDataForSplitPoints, String, Store) with 'Job', 'SampleDataForSplitPoints', 'String', 'Store'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "void AccumuloSampleDataForSplitPointsJobFactory.setupJob(Job, SampleDataForSplitPoints, String, Store)"})
  void testSetupJobWithJobSampleDataForSplitPointsStringStore() throws IOException, ClassNotFoundException {
    // Arrange
    AccumuloSampleDataForSplitPointsJobFactory accumuloSampleDataForSplitPointsJobFactory = new AccumuloSampleDataForSplitPointsJobFactory();
    Job job = new Job();

    SampleDataForSplitPoints operation = new SampleDataForSplitPoints();
    operation.setOutputPath(".");

    // Act
    accumuloSampleDataForSplitPointsJobFactory.setupJob(job, operation, "Mapper Generator Class Name",
        new AccumuloStore());

    // Assert
    assertTrue(job.getCombinerKeyGroupingComparator() instanceof WritableComparator);
    assertTrue(job.getGroupingComparator() instanceof WritableComparator);
    assertTrue(job.getSortComparator() instanceof WritableComparator);
    assertEquals("Sample Data: Generator=Mapper Generator Class Name, output=", job.getJobName());
    Class<Key> expectedMapOutputKeyClass = Key.class;
    assertEquals(expectedMapOutputKeyClass, job.getMapOutputKeyClass());
    Class<Value> expectedMapOutputValueClass = Value.class;
    assertEquals(expectedMapOutputValueClass, job.getMapOutputValueClass());
    Class<SequenceFileOutputFormat> expectedOutputFormatClass = SequenceFileOutputFormat.class;
    assertEquals(expectedOutputFormatClass, job.getOutputFormatClass());
    Class<SampleDataForSplitPointsMapper> expectedMapperClass = SampleDataForSplitPointsMapper.class;
    assertEquals(expectedMapperClass, job.getMapperClass());
    Class<AccumuloKeyValueReducer> expectedReducerClass = AccumuloKeyValueReducer.class;
    assertEquals(expectedReducerClass, job.getReducerClass());
  }

  /**
   * Test {@link AccumuloSampleDataForSplitPointsJobFactory#setupJob(Job, SampleDataForSplitPoints, String, Store)} with {@code Job}, {@code SampleDataForSplitPoints}, {@code String}, {@code Store}.
   * <p>
   * Method under test: {@link AccumuloSampleDataForSplitPointsJobFactory#setupJob(Job, SampleDataForSplitPoints, String, Store)}
   */
  @Test
  @DisplayName("Test setupJob(Job, SampleDataForSplitPoints, String, Store) with 'Job', 'SampleDataForSplitPoints', 'String', 'Store'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "void AccumuloSampleDataForSplitPointsJobFactory.setupJob(Job, SampleDataForSplitPoints, String, Store)"})
  void testSetupJobWithJobSampleDataForSplitPointsStringStore2() throws IOException, ClassNotFoundException {
    // Arrange
    AccumuloSampleDataForSplitPointsJobFactory accumuloSampleDataForSplitPointsJobFactory = new AccumuloSampleDataForSplitPointsJobFactory(
        new Configuration());
    Job job = new Job();

    SampleDataForSplitPoints operation = new SampleDataForSplitPoints();
    operation.setOutputPath(".");

    // Act
    accumuloSampleDataForSplitPointsJobFactory.setupJob(job, operation, "Mapper Generator Class Name",
        new AccumuloStore());

    // Assert
    assertTrue(job.getCombinerKeyGroupingComparator() instanceof WritableComparator);
    assertTrue(job.getGroupingComparator() instanceof WritableComparator);
    assertTrue(job.getSortComparator() instanceof WritableComparator);
    assertEquals("Sample Data: Generator=Mapper Generator Class Name, output=", job.getJobName());
    Class<Key> expectedMapOutputKeyClass = Key.class;
    assertEquals(expectedMapOutputKeyClass, job.getMapOutputKeyClass());
    Class<Value> expectedMapOutputValueClass = Value.class;
    assertEquals(expectedMapOutputValueClass, job.getMapOutputValueClass());
    Class<SequenceFileOutputFormat> expectedOutputFormatClass = SequenceFileOutputFormat.class;
    assertEquals(expectedOutputFormatClass, job.getOutputFormatClass());
    Class<SampleDataForSplitPointsMapper> expectedMapperClass = SampleDataForSplitPointsMapper.class;
    assertEquals(expectedMapperClass, job.getMapperClass());
    Class<AccumuloKeyValueReducer> expectedReducerClass = AccumuloKeyValueReducer.class;
    assertEquals(expectedReducerClass, job.getReducerClass());
  }

  /**
   * Test {@link AccumuloSampleDataForSplitPointsJobFactory#setupJob(Job, SampleDataForSplitPoints, String, Store)} with {@code Job}, {@code SampleDataForSplitPoints}, {@code String}, {@code Store}.
   * <p>
   * Method under test: {@link AccumuloSampleDataForSplitPointsJobFactory#setupJob(Job, SampleDataForSplitPoints, String, Store)}
   */
  @Test
  @DisplayName("Test setupJob(Job, SampleDataForSplitPoints, String, Store) with 'Job', 'SampleDataForSplitPoints', 'String', 'Store'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "void AccumuloSampleDataForSplitPointsJobFactory.setupJob(Job, SampleDataForSplitPoints, String, Store)"})
  void testSetupJobWithJobSampleDataForSplitPointsStringStore3() throws IOException, ClassNotFoundException {
    // Arrange
    AccumuloSampleDataForSplitPointsJobFactory accumuloSampleDataForSplitPointsJobFactory = new AccumuloSampleDataForSplitPointsJobFactory();
    Job job = new Job();

    SampleDataForSplitPoints operation = new SampleDataForSplitPoints();
    operation.setOutputPath("///");

    // Act
    accumuloSampleDataForSplitPointsJobFactory.setupJob(job, operation, "Mapper Generator Class Name",
        new AccumuloStore());

    // Assert
    assertTrue(job.getCombinerKeyGroupingComparator() instanceof WritableComparator);
    assertTrue(job.getGroupingComparator() instanceof WritableComparator);
    assertTrue(job.getSortComparator() instanceof WritableComparator);
    assertEquals("Sample Data: Generator=Mapper Generator Class Name, output=/", job.getJobName());
    Class<Key> expectedMapOutputKeyClass = Key.class;
    assertEquals(expectedMapOutputKeyClass, job.getMapOutputKeyClass());
    Class<Value> expectedMapOutputValueClass = Value.class;
    assertEquals(expectedMapOutputValueClass, job.getMapOutputValueClass());
    Class<SequenceFileOutputFormat> expectedOutputFormatClass = SequenceFileOutputFormat.class;
    assertEquals(expectedOutputFormatClass, job.getOutputFormatClass());
    Class<SampleDataForSplitPointsMapper> expectedMapperClass = SampleDataForSplitPointsMapper.class;
    assertEquals(expectedMapperClass, job.getMapperClass());
    Class<AccumuloKeyValueReducer> expectedReducerClass = AccumuloKeyValueReducer.class;
    assertEquals(expectedReducerClass, job.getReducerClass());
  }

  /**
   * Test {@link AccumuloSampleDataForSplitPointsJobFactory#getJobName(String, Path)}.
   * <ul>
   *   <li>Then return {@code Sample Data: Generator=Mapper Generator, output=Path String}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AccumuloSampleDataForSplitPointsJobFactory#getJobName(String, Path)}
   */
  @Test
  @DisplayName("Test getJobName(String, Path); then return 'Sample Data: Generator=Mapper Generator, output=Path String'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String AccumuloSampleDataForSplitPointsJobFactory.getJobName(String, Path)"})
  void testGetJobName_thenReturnSampleDataGeneratorMapperGeneratorOutputPathString() throws IllegalArgumentException {
    // Arrange
    AccumuloSampleDataForSplitPointsJobFactory accumuloSampleDataForSplitPointsJobFactory = new AccumuloSampleDataForSplitPointsJobFactory();

    // Act and Assert
    assertEquals("Sample Data: Generator=Mapper Generator, output=Path String",
        accumuloSampleDataForSplitPointsJobFactory.getJobName("Mapper Generator", new Path("Path String")));
  }

  /**
   * Test {@link AccumuloSampleDataForSplitPointsJobFactory#getJobName(String, Path)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code Sample Data: Generator=Mapper Generator, output=null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AccumuloSampleDataForSplitPointsJobFactory#getJobName(String, Path)}
   */
  @Test
  @DisplayName("Test getJobName(String, Path); when 'null'; then return 'Sample Data: Generator=Mapper Generator, output=null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String AccumuloSampleDataForSplitPointsJobFactory.getJobName(String, Path)"})
  void testGetJobName_whenNull_thenReturnSampleDataGeneratorMapperGeneratorOutputNull() {
    // Arrange, Act and Assert
    assertEquals("Sample Data: Generator=Mapper Generator, output=null",
        (new AccumuloSampleDataForSplitPointsJobFactory()).getJobName("Mapper Generator", null));
  }

  /**
   * Test {@link AccumuloSampleDataForSplitPointsJobFactory#setupMapper(Job)}.
   * <ul>
   *   <li>When {@link Job#Job()}.</li>
   *   <li>Then {@link Job#Job()} CombinerKeyGroupingComparator {@link WritableComparator}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AccumuloSampleDataForSplitPointsJobFactory#setupMapper(Job)}
   */
  @Test
  @DisplayName("Test setupMapper(Job); when Job(); then Job() CombinerKeyGroupingComparator WritableComparator")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void AccumuloSampleDataForSplitPointsJobFactory.setupMapper(Job)"})
  void testSetupMapper_whenJob_thenJobCombinerKeyGroupingComparatorWritableComparator()
      throws IOException, ClassNotFoundException {
    // Arrange
    AccumuloSampleDataForSplitPointsJobFactory accumuloSampleDataForSplitPointsJobFactory = new AccumuloSampleDataForSplitPointsJobFactory();
    Job job = new Job();

    // Act
    accumuloSampleDataForSplitPointsJobFactory.setupMapper(job);

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
    Class<SampleDataForSplitPointsMapper> expectedMapperClass = SampleDataForSplitPointsMapper.class;
    assertEquals(expectedMapperClass, job.getMapperClass());
  }
}
