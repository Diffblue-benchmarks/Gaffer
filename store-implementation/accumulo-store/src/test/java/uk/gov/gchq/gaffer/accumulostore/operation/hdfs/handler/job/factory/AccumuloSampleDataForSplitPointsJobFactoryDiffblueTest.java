package uk.gov.gchq.gaffer.accumulostore.operation.hdfs.handler.job.factory;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import java.util.ArrayList;
import org.apache.accumulo.core.client.IteratorSetting;
import org.apache.accumulo.core.data.ArrayByteSequence;
import org.apache.accumulo.core.data.ByteSequence;
import org.apache.accumulo.core.data.Key;
import org.apache.accumulo.core.data.Value;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.RawComparator;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.Writable;
import org.apache.hadoop.io.WritableComparator;
import org.apache.hadoop.io.compress.CompressionCodec;
import org.apache.hadoop.mapred.JobConf;
import org.apache.hadoop.mapreduce.Job;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.accumulostore.AccumuloStore;
import uk.gov.gchq.gaffer.accumulostore.operation.hdfs.mapper.SampleDataForSplitPointsMapper;
import uk.gov.gchq.gaffer.data.elementdefinition.exception.SchemaException;
import uk.gov.gchq.gaffer.hdfs.operation.SampleDataForSplitPoints;
import uk.gov.gchq.gaffer.store.Store;
import uk.gov.gchq.gaffer.store.StoreException;
import uk.gov.gchq.gaffer.store.operation.handler.TestAddToGraphLibraryImpl;
import uk.gov.gchq.gaffer.store.schema.Schema;

class AccumuloSampleDataForSplitPointsJobFactoryDiffblueTest {
  /**
   * Test {@link
   * AccumuloSampleDataForSplitPointsJobFactory#AccumuloSampleDataForSplitPointsJobFactory()}.
   *
   * <p>Method under test: {@link
   * AccumuloSampleDataForSplitPointsJobFactory#AccumuloSampleDataForSplitPointsJobFactory()}
   */
  @Test
  @DisplayName("Test new AccumuloSampleDataForSplitPointsJobFactory()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AccumuloSampleDataForSplitPointsJobFactory.<init>()"})
  void testNewAccumuloSampleDataForSplitPointsJobFactory() {
    // Arrange and Act
    AccumuloSampleDataForSplitPointsJobFactory actualAccumuloSampleDataForSplitPointsJobFactory =
        new AccumuloSampleDataForSplitPointsJobFactory();

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
    assertArrayEquals(new byte[] {}, ((Value) createValueResult).get());
  }

  /**
   * Test {@link AccumuloSampleDataForSplitPointsJobFactory#createSplit(Writable, Writable)}.
   *
   * <p>Method under test: {@link AccumuloSampleDataForSplitPointsJobFactory#createSplit(Writable,
   * Writable)}
   */
  @Test
  @DisplayName("Test createSplit(Writable, Writable)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "byte[] AccumuloSampleDataForSplitPointsJobFactory.createSplit(Writable, Writable)"
  })
  void testCreateSplit() {
    // Arrange
    AccumuloSampleDataForSplitPointsJobFactory accumuloSampleDataForSplitPointsJobFactory =
        new AccumuloSampleDataForSplitPointsJobFactory();
    Key key = new Key();
    IteratorSetting value = new IteratorSetting(1, "Name", "Iterator Class");

    // Act and Assert
    assertArrayEquals(
        new byte[] {}, accumuloSampleDataForSplitPointsJobFactory.createSplit(key, value));
  }

  /**
   * Test {@link AccumuloSampleDataForSplitPointsJobFactory#createKey()}.
   *
   * <p>Method under test: {@link AccumuloSampleDataForSplitPointsJobFactory#createKey()}
   */
  @Test
  @DisplayName("Test createKey()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Writable AccumuloSampleDataForSplitPointsJobFactory.createKey()"})
  void testCreateKey() {
    // Arrange and Act
    Writable actualCreateKeyResult = new AccumuloSampleDataForSplitPointsJobFactory().createKey();

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
   *
   * <p>Method under test: {@link AccumuloSampleDataForSplitPointsJobFactory#createValue()}
   */
  @Test
  @DisplayName("Test createValue()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Writable AccumuloSampleDataForSplitPointsJobFactory.createValue()"})
  void testCreateValue() {
    // Arrange and Act
    Writable actualCreateValueResult =
        new AccumuloSampleDataForSplitPointsJobFactory().createValue();

    // Assert
    assertTrue(actualCreateValueResult instanceof Value);
    assertEquals(0, ((Value) actualCreateValueResult).getSize());
    assertArrayEquals(new byte[] {}, ((Value) actualCreateValueResult).get());
  }

  /**
   * Test {@link AccumuloSampleDataForSplitPointsJobFactory#getExpectedNumberOfSplits(Store)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.
   *   <li>Then return minus one.
   * </ul>
   *
   * <p>Method under test: {@link
   * AccumuloSampleDataForSplitPointsJobFactory#getExpectedNumberOfSplits(Store)}
   */
  @Test
  @DisplayName("Test getExpectedNumberOfSplits(Store); given ArrayList(); then return minus one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "int AccumuloSampleDataForSplitPointsJobFactory.getExpectedNumberOfSplits(Store)"
  })
  void testGetExpectedNumberOfSplits_givenArrayList_thenReturnMinusOne() throws StoreException {
    // Arrange
    AccumuloSampleDataForSplitPointsJobFactory accumuloSampleDataForSplitPointsJobFactory =
        new AccumuloSampleDataForSplitPointsJobFactory();

    AccumuloStore store = mock(AccumuloStore.class);
    when(store.getTabletServers()).thenReturn(new ArrayList<>());

    // Act
    int actualExpectedNumberOfSplits =
        accumuloSampleDataForSplitPointsJobFactory.getExpectedNumberOfSplits(store);

    // Assert
    verify(store).getTabletServers();
    assertEquals(-1, actualExpectedNumberOfSplits);
  }

  /**
   * Test {@link AccumuloSampleDataForSplitPointsJobFactory#getExpectedNumberOfSplits(Store)}.
   *
   * <ul>
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AccumuloSampleDataForSplitPointsJobFactory#getExpectedNumberOfSplits(Store)}
   */
  @Test
  @DisplayName("Test getExpectedNumberOfSplits(Store); then throw RuntimeException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "int AccumuloSampleDataForSplitPointsJobFactory.getExpectedNumberOfSplits(Store)"
  })
  void testGetExpectedNumberOfSplits_thenThrowRuntimeException() throws StoreException {
    // Arrange
    AccumuloSampleDataForSplitPointsJobFactory accumuloSampleDataForSplitPointsJobFactory =
        new AccumuloSampleDataForSplitPointsJobFactory();

    AccumuloStore store = mock(AccumuloStore.class);
    when(store.getTabletServers()).thenThrow(new StoreException("An error occurred"));

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> accumuloSampleDataForSplitPointsJobFactory.getExpectedNumberOfSplits(store));
    verify(store).getTabletServers();
  }

  /**
   * Test {@link AccumuloSampleDataForSplitPointsJobFactory#createJobConf(SampleDataForSplitPoints,
   * String, Store)} with {@code SampleDataForSplitPoints}, {@code String}, {@code Store}.
   *
   * <p>Method under test: {@link
   * AccumuloSampleDataForSplitPointsJobFactory#createJobConf(SampleDataForSplitPoints, String,
   * Store)}
   */
  @Test
  @DisplayName(
      "Test createJobConf(SampleDataForSplitPoints, String, Store) with 'SampleDataForSplitPoints', 'String', 'Store'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "JobConf AccumuloSampleDataForSplitPointsJobFactory.createJobConf(SampleDataForSplitPoints, String, Store)"
  })
  void testCreateJobConfWithSampleDataForSplitPointsStringStore()
      throws IOException, SchemaException {
    // Arrange
    AccumuloSampleDataForSplitPointsJobFactory accumuloSampleDataForSplitPointsJobFactory =
        new AccumuloSampleDataForSplitPointsJobFactory();

    SampleDataForSplitPoints operation = mock(SampleDataForSplitPoints.class);
    when(operation.isValidate()).thenThrow(new RuntimeException());

    Schema schema = mock(Schema.class);
    when(schema.toCompactJson()).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    TestAddToGraphLibraryImpl store = mock(TestAddToGraphLibraryImpl.class);
    when(store.getSchema()).thenReturn(schema);

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            accumuloSampleDataForSplitPointsJobFactory.createJobConf(
                operation, "Mapper Generator Class Name", store));
    verify(operation).isValidate();
    verify(store, atLeast(1)).getSchema();
    verify(schema, atLeast(1)).toCompactJson();
  }

  /**
   * Test {@link AccumuloSampleDataForSplitPointsJobFactory#createJobConf(SampleDataForSplitPoints,
   * String, Store)} with {@code SampleDataForSplitPoints}, {@code String}, {@code Store}.
   *
   * <p>Method under test: {@link
   * AccumuloSampleDataForSplitPointsJobFactory#createJobConf(SampleDataForSplitPoints, String,
   * Store)}
   */
  @Test
  @DisplayName(
      "Test createJobConf(SampleDataForSplitPoints, String, Store) with 'SampleDataForSplitPoints', 'String', 'Store'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "JobConf AccumuloSampleDataForSplitPointsJobFactory.createJobConf(SampleDataForSplitPoints, String, Store)"
  })
  void testCreateJobConfWithSampleDataForSplitPointsStringStore2()
      throws IOException, SchemaException {
    // Arrange
    AccumuloSampleDataForSplitPointsJobFactory accumuloSampleDataForSplitPointsJobFactory =
        new AccumuloSampleDataForSplitPointsJobFactory(new JobConf());

    SampleDataForSplitPoints operation = mock(SampleDataForSplitPoints.class);
    when(operation.isValidate()).thenThrow(new RuntimeException());

    Schema schema = mock(Schema.class);
    when(schema.toCompactJson()).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    TestAddToGraphLibraryImpl store = mock(TestAddToGraphLibraryImpl.class);
    when(store.getSchema()).thenReturn(schema);

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            accumuloSampleDataForSplitPointsJobFactory.createJobConf(
                operation, "Mapper Generator Class Name", store));
    verify(operation).isValidate();
    verify(store, atLeast(1)).getSchema();
    verify(schema, atLeast(1)).toCompactJson();
  }

  /**
   * Test {@link AccumuloSampleDataForSplitPointsJobFactory#createJobConf(SampleDataForSplitPoints,
   * String, Store)} with {@code SampleDataForSplitPoints}, {@code String}, {@code Store}.
   *
   * <p>Method under test: {@link
   * AccumuloSampleDataForSplitPointsJobFactory#createJobConf(SampleDataForSplitPoints, String,
   * Store)}
   */
  @Test
  @DisplayName(
      "Test createJobConf(SampleDataForSplitPoints, String, Store) with 'SampleDataForSplitPoints', 'String', 'Store'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "JobConf AccumuloSampleDataForSplitPointsJobFactory.createJobConf(SampleDataForSplitPoints, String, Store)"
  })
  void testCreateJobConfWithSampleDataForSplitPointsStringStore3()
      throws IOException, IllegalArgumentException, SchemaException {
    // Arrange
    Configuration configuration = new Configuration();
    configuration.addResource(new Path("Setting up job conf"));
    AccumuloSampleDataForSplitPointsJobFactory accumuloSampleDataForSplitPointsJobFactory =
        new AccumuloSampleDataForSplitPointsJobFactory(configuration);

    SampleDataForSplitPoints operation = mock(SampleDataForSplitPoints.class);
    when(operation.isValidate()).thenThrow(new RuntimeException());

    Schema schema = mock(Schema.class);
    when(schema.toCompactJson()).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    TestAddToGraphLibraryImpl store = mock(TestAddToGraphLibraryImpl.class);
    when(store.getSchema()).thenReturn(schema);

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            accumuloSampleDataForSplitPointsJobFactory.createJobConf(
                operation, "Mapper Generator Class Name", store));
    verify(operation).isValidate();
    verify(store, atLeast(1)).getSchema();
    verify(schema, atLeast(1)).toCompactJson();
  }

  /**
   * Test {@link AccumuloSampleDataForSplitPointsJobFactory#setupJob(Job, SampleDataForSplitPoints,
   * String, Store)} with {@code Job}, {@code SampleDataForSplitPoints}, {@code String}, {@code
   * Store}.
   *
   * <p>Method under test: {@link AccumuloSampleDataForSplitPointsJobFactory#setupJob(Job,
   * SampleDataForSplitPoints, String, Store)}
   */
  @Test
  @DisplayName(
      "Test setupJob(Job, SampleDataForSplitPoints, String, Store) with 'Job', 'SampleDataForSplitPoints', 'String', 'Store'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AccumuloSampleDataForSplitPointsJobFactory.setupJob(Job, SampleDataForSplitPoints, String, Store)"
  })
  void testSetupJobWithJobSampleDataForSplitPointsStringStore() throws IOException {
    // Arrange
    AccumuloSampleDataForSplitPointsJobFactory accumuloSampleDataForSplitPointsJobFactory =
        new AccumuloSampleDataForSplitPointsJobFactory();
    Job job = new Job();

    SampleDataForSplitPoints operation = new SampleDataForSplitPoints();
    operation.setOutputPath(".");

    // Act
    accumuloSampleDataForSplitPointsJobFactory.setupJob(
        job, operation, "Mapper Generator Class Name", new AccumuloStore());

    // Assert
    RawComparator<?> groupingComparator = job.getGroupingComparator();
    assertTrue(groupingComparator instanceof WritableComparator);
    RawComparator<?> sortComparator = job.getSortComparator();
    assertTrue(sortComparator instanceof WritableComparator);
    Configuration configuration = job.getConfiguration();
    assertTrue(configuration instanceof JobConf);
    assertEquals(
        "Sample Data: Generator=Mapper Generator Class Name, output=",
        ((JobConf) configuration).getJobName());
    assertEquals("Sample Data: Generator=Mapper Generator Class Name, output=", job.getJobName());
    assertSame(configuration, ((WritableComparator) groupingComparator).getConf());
    assertSame(configuration, ((WritableComparator) sortComparator).getConf());
  }

  /**
   * Test {@link AccumuloSampleDataForSplitPointsJobFactory#setupJob(Job, SampleDataForSplitPoints,
   * String, Store)} with {@code Job}, {@code SampleDataForSplitPoints}, {@code String}, {@code
   * Store}.
   *
   * <p>Method under test: {@link AccumuloSampleDataForSplitPointsJobFactory#setupJob(Job,
   * SampleDataForSplitPoints, String, Store)}
   */
  @Test
  @DisplayName(
      "Test setupJob(Job, SampleDataForSplitPoints, String, Store) with 'Job', 'SampleDataForSplitPoints', 'String', 'Store'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AccumuloSampleDataForSplitPointsJobFactory.setupJob(Job, SampleDataForSplitPoints, String, Store)"
  })
  void testSetupJobWithJobSampleDataForSplitPointsStringStore2() throws IOException {
    // Arrange
    AccumuloSampleDataForSplitPointsJobFactory accumuloSampleDataForSplitPointsJobFactory =
        new AccumuloSampleDataForSplitPointsJobFactory();
    Job job = new Job(new Configuration());

    SampleDataForSplitPoints operation = new SampleDataForSplitPoints();
    operation.setOutputPath(".");

    // Act
    accumuloSampleDataForSplitPointsJobFactory.setupJob(
        job, operation, "Mapper Generator Class Name", new AccumuloStore());

    // Assert
    assertTrue(job.getGroupingComparator() instanceof WritableComparator);
    assertTrue(job.getSortComparator() instanceof WritableComparator);
  }

  /**
   * Test {@link AccumuloSampleDataForSplitPointsJobFactory#setupJob(Job, SampleDataForSplitPoints,
   * String, Store)} with {@code Job}, {@code SampleDataForSplitPoints}, {@code String}, {@code
   * Store}.
   *
   * <p>Method under test: {@link AccumuloSampleDataForSplitPointsJobFactory#setupJob(Job,
   * SampleDataForSplitPoints, String, Store)}
   */
  @Test
  @DisplayName(
      "Test setupJob(Job, SampleDataForSplitPoints, String, Store) with 'Job', 'SampleDataForSplitPoints', 'String', 'Store'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AccumuloSampleDataForSplitPointsJobFactory.setupJob(Job, SampleDataForSplitPoints, String, Store)"
  })
  void testSetupJobWithJobSampleDataForSplitPointsStringStore3() throws IOException {
    // Arrange
    AccumuloSampleDataForSplitPointsJobFactory accumuloSampleDataForSplitPointsJobFactory =
        new AccumuloSampleDataForSplitPointsJobFactory();
    Job job = new Job();

    SampleDataForSplitPoints operation = new SampleDataForSplitPoints();
    operation.setOutputPath("///");

    // Act
    accumuloSampleDataForSplitPointsJobFactory.setupJob(
        job, operation, "Mapper Generator Class Name", new AccumuloStore());

    // Assert
    RawComparator<?> groupingComparator = job.getGroupingComparator();
    assertTrue(groupingComparator instanceof WritableComparator);
    RawComparator<?> sortComparator = job.getSortComparator();
    assertTrue(sortComparator instanceof WritableComparator);
    Configuration configuration = job.getConfiguration();
    assertTrue(configuration instanceof JobConf);
    assertEquals(
        "Sample Data: Generator=Mapper Generator Class Name, output=/",
        ((JobConf) configuration).getJobName());
    assertEquals("Sample Data: Generator=Mapper Generator Class Name, output=/", job.getJobName());
    assertSame(configuration, ((WritableComparator) groupingComparator).getConf());
    assertSame(configuration, ((WritableComparator) sortComparator).getConf());
  }

  /**
   * Test {@link AccumuloSampleDataForSplitPointsJobFactory#setupJob(Job, SampleDataForSplitPoints,
   * String, Store)} with {@code Job}, {@code SampleDataForSplitPoints}, {@code String}, {@code
   * Store}.
   *
   * <p>Method under test: {@link AccumuloSampleDataForSplitPointsJobFactory#setupJob(Job,
   * SampleDataForSplitPoints, String, Store)}
   */
  @Test
  @DisplayName(
      "Test setupJob(Job, SampleDataForSplitPoints, String, Store) with 'Job', 'SampleDataForSplitPoints', 'String', 'Store'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AccumuloSampleDataForSplitPointsJobFactory.setupJob(Job, SampleDataForSplitPoints, String, Store)"
  })
  void testSetupJobWithJobSampleDataForSplitPointsStringStore4() throws IOException {
    // Arrange
    AccumuloSampleDataForSplitPointsJobFactory accumuloSampleDataForSplitPointsJobFactory =
        new AccumuloSampleDataForSplitPointsJobFactory();
    Job job = new Job();

    SampleDataForSplitPoints operation = new SampleDataForSplitPoints();
    operation.setOutputPath(", output=");

    // Act
    accumuloSampleDataForSplitPointsJobFactory.setupJob(
        job, operation, "Mapper Generator Class Name", new AccumuloStore());

    // Assert
    RawComparator<?> groupingComparator = job.getGroupingComparator();
    assertTrue(groupingComparator instanceof WritableComparator);
    RawComparator<?> sortComparator = job.getSortComparator();
    assertTrue(sortComparator instanceof WritableComparator);
    Configuration configuration = job.getConfiguration();
    assertTrue(configuration instanceof JobConf);
    assertEquals(
        "Sample Data: Generator=Mapper Generator Class Name, output=, output=",
        ((JobConf) configuration).getJobName());
    assertEquals(
        "Sample Data: Generator=Mapper Generator Class Name, output=, output=", job.getJobName());
    assertSame(configuration, ((WritableComparator) groupingComparator).getConf());
    assertSame(configuration, ((WritableComparator) sortComparator).getConf());
  }

  /**
   * Test {@link AccumuloSampleDataForSplitPointsJobFactory#setupJob(Job, SampleDataForSplitPoints,
   * String, Store)} with {@code Job}, {@code SampleDataForSplitPoints}, {@code String}, {@code
   * Store}.
   *
   * <p>Method under test: {@link AccumuloSampleDataForSplitPointsJobFactory#setupJob(Job,
   * SampleDataForSplitPoints, String, Store)}
   */
  @Test
  @DisplayName(
      "Test setupJob(Job, SampleDataForSplitPoints, String, Store) with 'Job', 'SampleDataForSplitPoints', 'String', 'Store'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AccumuloSampleDataForSplitPointsJobFactory.setupJob(Job, SampleDataForSplitPoints, String, Store)"
  })
  void testSetupJobWithJobSampleDataForSplitPointsStringStore5() throws IOException {
    // Arrange
    AccumuloSampleDataForSplitPointsJobFactory accumuloSampleDataForSplitPointsJobFactory =
        new AccumuloSampleDataForSplitPointsJobFactory();
    Job job = new Job(new Configuration());

    SampleDataForSplitPoints operation = new SampleDataForSplitPoints();
    Class<CompressionCodec> compressionCodec = CompressionCodec.class;
    operation.setCompressionCodec(compressionCodec);
    operation.setOutputPath(".");

    // Act
    accumuloSampleDataForSplitPointsJobFactory.setupJob(
        job, operation, "Mapper Generator Class Name", new AccumuloStore());

    // Assert
    assertTrue(job.getGroupingComparator() instanceof WritableComparator);
    assertTrue(job.getSortComparator() instanceof WritableComparator);
  }

  /**
   * Test {@link AccumuloSampleDataForSplitPointsJobFactory#setupJob(Job, SampleDataForSplitPoints,
   * String, Store)} with {@code Job}, {@code SampleDataForSplitPoints}, {@code String}, {@code
   * Store}.
   *
   * <p>Method under test: {@link AccumuloSampleDataForSplitPointsJobFactory#setupJob(Job,
   * SampleDataForSplitPoints, String, Store)}
   */
  @Test
  @DisplayName(
      "Test setupJob(Job, SampleDataForSplitPoints, String, Store) with 'Job', 'SampleDataForSplitPoints', 'String', 'Store'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AccumuloSampleDataForSplitPointsJobFactory.setupJob(Job, SampleDataForSplitPoints, String, Store)"
  })
  void testSetupJobWithJobSampleDataForSplitPointsStringStore6() throws IOException {
    // Arrange
    AccumuloSampleDataForSplitPointsJobFactory accumuloSampleDataForSplitPointsJobFactory =
        new AccumuloSampleDataForSplitPointsJobFactory();
    Job job = new Job();

    SampleDataForSplitPoints operation = new SampleDataForSplitPoints();
    Class<CompressionCodec> compressionCodec = CompressionCodec.class;
    operation.setCompressionCodec(compressionCodec);
    operation.setOutputPath("///");

    // Act
    accumuloSampleDataForSplitPointsJobFactory.setupJob(
        job, operation, "Mapper Generator Class Name", new AccumuloStore());

    // Assert
    RawComparator<?> groupingComparator = job.getGroupingComparator();
    assertTrue(groupingComparator instanceof WritableComparator);
    RawComparator<?> sortComparator = job.getSortComparator();
    assertTrue(sortComparator instanceof WritableComparator);
    Configuration configuration = job.getConfiguration();
    assertTrue(configuration instanceof JobConf);
    assertEquals(
        "Sample Data: Generator=Mapper Generator Class Name, output=/",
        ((JobConf) configuration).getJobName());
    assertEquals("Sample Data: Generator=Mapper Generator Class Name, output=/", job.getJobName());
    assertSame(configuration, ((WritableComparator) groupingComparator).getConf());
    assertSame(configuration, ((WritableComparator) sortComparator).getConf());
  }

  /**
   * Test {@link AccumuloSampleDataForSplitPointsJobFactory#setupJob(Job, SampleDataForSplitPoints,
   * String, Store)} with {@code Job}, {@code SampleDataForSplitPoints}, {@code String}, {@code
   * Store}.
   *
   * <ul>
   *   <li>Given {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link AccumuloSampleDataForSplitPointsJobFactory#setupJob(Job,
   * SampleDataForSplitPoints, String, Store)}
   */
  @Test
  @DisplayName(
      "Test setupJob(Job, SampleDataForSplitPoints, String, Store) with 'Job', 'SampleDataForSplitPoints', 'String', 'Store'; given 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AccumuloSampleDataForSplitPointsJobFactory.setupJob(Job, SampleDataForSplitPoints, String, Store)"
  })
  void testSetupJobWithJobSampleDataForSplitPointsStringStore_givenNull() throws IOException {
    // Arrange
    AccumuloSampleDataForSplitPointsJobFactory accumuloSampleDataForSplitPointsJobFactory =
        new AccumuloSampleDataForSplitPointsJobFactory();
    Job job = new Job(new Configuration());

    SampleDataForSplitPoints operation = new SampleDataForSplitPoints();
    operation.setCompressionCodec(null);
    operation.setOutputPath(".");

    // Act
    accumuloSampleDataForSplitPointsJobFactory.setupJob(
        job, operation, "Mapper Generator Class Name", new AccumuloStore());

    // Assert
    assertTrue(job.getGroupingComparator() instanceof WritableComparator);
    assertTrue(job.getSortComparator() instanceof WritableComparator);
  }

  /**
   * Test {@link AccumuloSampleDataForSplitPointsJobFactory#getJobName(String, Path)}.
   *
   * <ul>
   *   <li>Then return {@code Sample Data: Generator=Mapper Generator, output=Path String}.
   * </ul>
   *
   * <p>Method under test: {@link AccumuloSampleDataForSplitPointsJobFactory#getJobName(String,
   * Path)}
   */
  @Test
  @DisplayName(
      "Test getJobName(String, Path); then return 'Sample Data: Generator=Mapper Generator, output=Path String'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String AccumuloSampleDataForSplitPointsJobFactory.getJobName(String, Path)"})
  void testGetJobName_thenReturnSampleDataGeneratorMapperGeneratorOutputPathString()
      throws IllegalArgumentException {
    // Arrange
    AccumuloSampleDataForSplitPointsJobFactory accumuloSampleDataForSplitPointsJobFactory =
        new AccumuloSampleDataForSplitPointsJobFactory();

    // Act and Assert
    assertEquals(
        "Sample Data: Generator=Mapper Generator, output=Path String",
        accumuloSampleDataForSplitPointsJobFactory.getJobName(
            "Mapper Generator", new Path("Path String")));
  }

  /**
   * Test {@link AccumuloSampleDataForSplitPointsJobFactory#getJobName(String, Path)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code Sample Data: Generator=Mapper Generator, output=null}.
   * </ul>
   *
   * <p>Method under test: {@link AccumuloSampleDataForSplitPointsJobFactory#getJobName(String,
   * Path)}
   */
  @Test
  @DisplayName(
      "Test getJobName(String, Path); when 'null'; then return 'Sample Data: Generator=Mapper Generator, output=null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String AccumuloSampleDataForSplitPointsJobFactory.getJobName(String, Path)"})
  void testGetJobName_whenNull_thenReturnSampleDataGeneratorMapperGeneratorOutputNull() {
    // Arrange, Act and Assert
    assertEquals(
        "Sample Data: Generator=Mapper Generator, output=null",
        new AccumuloSampleDataForSplitPointsJobFactory().getJobName("Mapper Generator", null));
  }

  /**
   * Test {@link AccumuloSampleDataForSplitPointsJobFactory#setupMapper(Job)}.
   *
   * <ul>
   *   <li>When {@link Job#Job()}.
   *   <li>Then {@link Job#Job()} CombinerKeyGroupingComparator {@link WritableComparator}.
   * </ul>
   *
   * <p>Method under test: {@link AccumuloSampleDataForSplitPointsJobFactory#setupMapper(Job)}
   */
  @Test
  @DisplayName(
      "Test setupMapper(Job); when Job(); then Job() CombinerKeyGroupingComparator WritableComparator")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AccumuloSampleDataForSplitPointsJobFactory.setupMapper(Job)"})
  void testSetupMapper_whenJob_thenJobCombinerKeyGroupingComparatorWritableComparator()
      throws IOException, ClassNotFoundException {
    // Arrange
    AccumuloSampleDataForSplitPointsJobFactory accumuloSampleDataForSplitPointsJobFactory =
        new AccumuloSampleDataForSplitPointsJobFactory();
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
    Class<SampleDataForSplitPointsMapper> expectedMapperClass =
        SampleDataForSplitPointsMapper.class;
    assertEquals(expectedMapperClass, job.getMapperClass());
  }
}
