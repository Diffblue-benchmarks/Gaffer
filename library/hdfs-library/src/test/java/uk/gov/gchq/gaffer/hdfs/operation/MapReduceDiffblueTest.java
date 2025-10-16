package uk.gov.gchq.gaffer.hdfs.operation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashMap;
import java.util.Map;
import org.apache.hadoop.mapreduce.Partitioner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.hdfs.operation.AddElementsFromHdfs.Builder;
import uk.gov.gchq.gaffer.hdfs.operation.handler.job.initialiser.JobInitialiser;

class MapReduceDiffblueTest {
  /**
   * Test {@link MapReduce#addInputMapperPairs(Map)}.
   *
   * <ul>
   *   <li>Then {@link AddElementsFromHdfs} (default constructor) InputMapperPairs Empty.
   * </ul>
   *
   * <p>Method under test: {@link MapReduce#addInputMapperPairs(Map)}
   */
  @Test
  @DisplayName(
      "Test addInputMapperPairs(Map); then AddElementsFromHdfs (default constructor) InputMapperPairs Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MapReduce.addInputMapperPairs(Map)"})
  void testAddInputMapperPairs_thenAddElementsFromHdfsInputMapperPairsEmpty() {
    // Arrange
    AddElementsFromHdfs addElementsFromHdfs = new AddElementsFromHdfs();
    addElementsFromHdfs.setInputMapperPairs(new HashMap<>());

    // Act
    addElementsFromHdfs.addInputMapperPairs(new HashMap<>());

    // Assert that nothing has changed
    assertTrue(addElementsFromHdfs.getInputMapperPairs().isEmpty());
  }

  /**
   * Test {@link MapReduce#addInputMapperPairs(Map)}.
   *
   * <ul>
   *   <li>Then {@link AddElementsFromHdfs} (default constructor) InputMapperPairs is {@link
   *       HashMap#HashMap()}.
   * </ul>
   *
   * <p>Method under test: {@link MapReduce#addInputMapperPairs(Map)}
   */
  @Test
  @DisplayName(
      "Test addInputMapperPairs(Map); then AddElementsFromHdfs (default constructor) InputMapperPairs is HashMap()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MapReduce.addInputMapperPairs(Map)"})
  void testAddInputMapperPairs_thenAddElementsFromHdfsInputMapperPairsIsHashMap() {
    // Arrange
    AddElementsFromHdfs addElementsFromHdfs = new AddElementsFromHdfs();
    HashMap<String, String> inputMapperPairs = new HashMap<>();

    // Act
    addElementsFromHdfs.addInputMapperPairs(inputMapperPairs);

    // Assert
    assertSame(inputMapperPairs, addElementsFromHdfs.getInputMapperPairs());
  }

  /**
   * Test {@link MapReduce#addInputMapperPair(String, String)}.
   *
   * <ul>
   *   <li>Given {@link AddElementsFromHdfs} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link MapReduce#addInputMapperPair(String, String)}
   */
  @Test
  @DisplayName(
      "Test addInputMapperPair(String, String); given AddElementsFromHdfs (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MapReduce.addInputMapperPair(String, String)"})
  void testAddInputMapperPair_givenAddElementsFromHdfs() {
    // Arrange
    AddElementsFromHdfs addElementsFromHdfs = new AddElementsFromHdfs();

    // Act
    addElementsFromHdfs.addInputMapperPair("Input Path", "Mapper Generator Class Name");

    // Assert
    Map<String, String> inputMapperPairs = addElementsFromHdfs.getInputMapperPairs();
    assertEquals(1, inputMapperPairs.size());
    assertEquals("Mapper Generator Class Name", inputMapperPairs.get("Input Path"));
  }

  /**
   * Test {@link MapReduce#addInputMapperPair(String, String)}.
   *
   * <ul>
   *   <li>Then {@link AddElementsFromHdfs} (default constructor) InputMapperPairs is {@link
   *       HashMap#HashMap()}.
   * </ul>
   *
   * <p>Method under test: {@link MapReduce#addInputMapperPair(String, String)}
   */
  @Test
  @DisplayName(
      "Test addInputMapperPair(String, String); then AddElementsFromHdfs (default constructor) InputMapperPairs is HashMap()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MapReduce.addInputMapperPair(String, String)"})
  void testAddInputMapperPair_thenAddElementsFromHdfsInputMapperPairsIsHashMap() {
    // Arrange
    AddElementsFromHdfs addElementsFromHdfs = new AddElementsFromHdfs();
    HashMap<String, String> inputMapperPairs = new HashMap<>();
    addElementsFromHdfs.setInputMapperPairs(inputMapperPairs);

    // Act
    addElementsFromHdfs.addInputMapperPair("Input Path", "Mapper Generator Class Name");

    // Assert
    Map<String, String> inputMapperPairs2 = addElementsFromHdfs.getInputMapperPairs();
    assertEquals(1, inputMapperPairs2.size());
    assertEquals("Mapper Generator Class Name", inputMapperPairs2.get("Input Path"));
    assertSame(inputMapperPairs, inputMapperPairs2);
  }

  /**
   * Test Builder {@link MapReduce.Builder#addInputMapperPair(String, Class)} with {@code
   * inputPath}, {@code mapperGeneratorClass}.
   *
   * <p>Method under test: {@link MapReduce.Builder#addInputMapperPair(String, Class)}
   */
  @Test
  @DisplayName(
      "Test Builder addInputMapperPair(String, Class) with 'inputPath', 'mapperGeneratorClass'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MapReduce.Builder MapReduce.Builder.addInputMapperPair(String, Class)"})
  void testBuilderAddInputMapperPairWithInputPathMapperGeneratorClass() {
    // Arrange
    Builder builder = new Builder();
    builder.addInputMapperPairs(new HashMap<>());
    Class<Object> mapperGeneratorClass = Object.class;

    // Act
    Builder actualAddInputMapperPairResult =
        builder.addInputMapperPair("Input Path", mapperGeneratorClass);

    // Assert
    assertSame(builder, actualAddInputMapperPairResult);
  }

  /**
   * Test Builder {@link MapReduce.Builder#addInputMapperPair(String, String)} with {@code
   * inputPath}, {@code mapperGeneratorClassName}.
   *
   * <p>Method under test: {@link MapReduce.Builder#addInputMapperPair(String, String)}
   */
  @Test
  @DisplayName(
      "Test Builder addInputMapperPair(String, String) with 'inputPath', 'mapperGeneratorClassName'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MapReduce.Builder MapReduce.Builder.addInputMapperPair(String, String)"})
  void testBuilderAddInputMapperPairWithInputPathMapperGeneratorClassName() {
    // Arrange
    Builder builder = new Builder();
    builder.addInputMapperPairs(new HashMap<>());

    // Act
    Builder actualAddInputMapperPairResult =
        builder.addInputMapperPair("Input Path", "Mapper Generator Class Name");

    // Assert
    assertSame(builder, actualAddInputMapperPairResult);
  }

  /**
   * Test Builder {@link MapReduce.Builder#addInputMapperPair(String, String)} with {@code
   * inputPath}, {@code mapperGeneratorClassName}.
   *
   * <ul>
   *   <li>Given {@link Builder} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link MapReduce.Builder#addInputMapperPair(String, String)}
   */
  @Test
  @DisplayName(
      "Test Builder addInputMapperPair(String, String) with 'inputPath', 'mapperGeneratorClassName'; given Builder (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MapReduce.Builder MapReduce.Builder.addInputMapperPair(String, String)"})
  void testBuilderAddInputMapperPairWithInputPathMapperGeneratorClassName_givenBuilder() {
    // Arrange
    Builder builder = new Builder();

    // Act
    Builder actualAddInputMapperPairResult =
        builder.addInputMapperPair("Input Path", "Mapper Generator Class Name");

    // Assert
    assertSame(builder, actualAddInputMapperPairResult);
  }

  /**
   * Test Builder {@link MapReduce.Builder#addInputMapperPair(String, Class)} with {@code
   * inputPath}, {@code mapperGeneratorClass}.
   *
   * <ul>
   *   <li>Then return {@link Builder} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link MapReduce.Builder#addInputMapperPair(String, Class)}
   */
  @Test
  @DisplayName(
      "Test Builder addInputMapperPair(String, Class) with 'inputPath', 'mapperGeneratorClass'; then return Builder (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MapReduce.Builder MapReduce.Builder.addInputMapperPair(String, Class)"})
  void testBuilderAddInputMapperPairWithInputPathMapperGeneratorClass_thenReturnBuilder() {
    // Arrange
    Builder builder = new Builder();
    Class<Object> mapperGeneratorClass = Object.class;

    // Act
    Builder actualAddInputMapperPairResult =
        builder.addInputMapperPair("Input Path", mapperGeneratorClass);

    // Assert
    assertSame(builder, actualAddInputMapperPairResult);
  }

  /**
   * Test Builder {@link MapReduce.Builder#addInputMapperPairs(Map)}.
   *
   * <ul>
   *   <li>Given {@link Builder} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link MapReduce.Builder#addInputMapperPairs(Map)}
   */
  @Test
  @DisplayName("Test Builder addInputMapperPairs(Map); given Builder (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MapReduce.Builder MapReduce.Builder.addInputMapperPairs(Map)"})
  void testBuilderAddInputMapperPairs_givenBuilder() {
    // Arrange
    Builder builder = new Builder();

    // Act
    Builder actualAddInputMapperPairsResult = builder.addInputMapperPairs(new HashMap<>());

    // Assert
    assertSame(builder, actualAddInputMapperPairsResult);
  }

  /**
   * Test Builder {@link MapReduce.Builder#addInputMapperPairs(Map)}.
   *
   * <ul>
   *   <li>Given {@link Builder} (default constructor) addInputMapperPairs {@link
   *       HashMap#HashMap()}.
   * </ul>
   *
   * <p>Method under test: {@link MapReduce.Builder#addInputMapperPairs(Map)}
   */
  @Test
  @DisplayName(
      "Test Builder addInputMapperPairs(Map); given Builder (default constructor) addInputMapperPairs HashMap()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MapReduce.Builder MapReduce.Builder.addInputMapperPairs(Map)"})
  void testBuilderAddInputMapperPairs_givenBuilderAddInputMapperPairsHashMap() {
    // Arrange
    Builder builder = new Builder();
    builder.addInputMapperPairs(new HashMap<>());

    // Act
    Builder actualAddInputMapperPairsResult = builder.addInputMapperPairs(new HashMap<>());

    // Assert
    assertSame(builder, actualAddInputMapperPairsResult);
  }

  /**
   * Test Builder {@link MapReduce.Builder#commandLineArgs(String[])}.
   *
   * <p>Method under test: {@link MapReduce.Builder#commandLineArgs(String[])}
   */
  @Test
  @DisplayName("Test Builder commandLineArgs(String[])")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MapReduce.Builder MapReduce.Builder.commandLineArgs(String[])"})
  void testBuilderCommandLineArgs() {
    // Arrange
    Builder builder = new Builder();

    // Act
    Builder actualCommandLineArgsResult = builder.commandLineArgs("Command Line Args");

    // Assert
    assertSame(builder, actualCommandLineArgsResult);
  }

  /**
   * Test Builder {@link MapReduce.Builder#jobInitialiser(JobInitialiser)}.
   *
   * <p>Method under test: {@link MapReduce.Builder#jobInitialiser(JobInitialiser)}
   */
  @Test
  @DisplayName("Test Builder jobInitialiser(JobInitialiser)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MapReduce.Builder MapReduce.Builder.jobInitialiser(JobInitialiser)"})
  void testBuilderJobInitialiser() {
    // Arrange
    Builder builder = new Builder();

    // Act
    Builder actualJobInitialiserResult = builder.jobInitialiser(mock(JobInitialiser.class));

    // Assert
    assertSame(builder, actualJobInitialiserResult);
  }

  /**
   * Test Builder {@link MapReduce.Builder#mappers(Integer)}.
   *
   * <ul>
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link MapReduce.Builder#mappers(Integer)}
   */
  @Test
  @DisplayName("Test Builder mappers(Integer); when 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MapReduce.Builder MapReduce.Builder.mappers(Integer)"})
  void testBuilderMappers_whenNull() {
    // Arrange
    Builder builder = new Builder();

    // Act
    Builder actualMappersResult = builder.mappers(null);

    // Assert
    assertSame(builder, actualMappersResult);
  }

  /**
   * Test Builder {@link MapReduce.Builder#mappers(Integer)}.
   *
   * <ul>
   *   <li>When ten.
   * </ul>
   *
   * <p>Method under test: {@link MapReduce.Builder#mappers(Integer)}
   */
  @Test
  @DisplayName("Test Builder mappers(Integer); when ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MapReduce.Builder MapReduce.Builder.mappers(Integer)"})
  void testBuilderMappers_whenTen() {
    // Arrange
    Builder builder = new Builder();

    // Act
    Builder actualMappersResult = builder.mappers(10);

    // Assert
    assertSame(builder, actualMappersResult);
  }

  /**
   * Test Builder {@link MapReduce.Builder#maxMappers(Integer)}.
   *
   * <ul>
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link MapReduce.Builder#maxMappers(Integer)}
   */
  @Test
  @DisplayName("Test Builder maxMappers(Integer); when 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MapReduce.Builder MapReduce.Builder.maxMappers(Integer)"})
  void testBuilderMaxMappers_whenNull() {
    // Arrange
    Builder builder = new Builder();

    // Act
    Builder actualMaxMappersResult = builder.maxMappers(null);

    // Assert
    assertSame(builder, actualMaxMappersResult);
  }

  /**
   * Test Builder {@link MapReduce.Builder#maxMappers(Integer)}.
   *
   * <ul>
   *   <li>When three.
   * </ul>
   *
   * <p>Method under test: {@link MapReduce.Builder#maxMappers(Integer)}
   */
  @Test
  @DisplayName("Test Builder maxMappers(Integer); when three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MapReduce.Builder MapReduce.Builder.maxMappers(Integer)"})
  void testBuilderMaxMappers_whenThree() {
    // Arrange
    Builder builder = new Builder();

    // Act
    Builder actualMaxMappersResult = builder.maxMappers(3);

    // Assert
    assertSame(builder, actualMaxMappersResult);
  }

  /**
   * Test Builder {@link MapReduce.Builder#maxReducers(Integer)}.
   *
   * <p>Method under test: {@link MapReduce.Builder#maxReducers(Integer)}
   */
  @Test
  @DisplayName("Test Builder maxReducers(Integer)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MapReduce.Builder MapReduce.Builder.maxReducers(Integer)"})
  void testBuilderMaxReducers() {
    // Arrange
    Builder builder = new Builder();

    // Act
    Builder actualMaxReducersResult = builder.maxReducers(3);

    // Assert
    assertSame(builder, actualMaxReducersResult);
  }

  /**
   * Test Builder {@link MapReduce.Builder#minMappers(Integer)}.
   *
   * <ul>
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link MapReduce.Builder#minMappers(Integer)}
   */
  @Test
  @DisplayName("Test Builder minMappers(Integer); when 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MapReduce.Builder MapReduce.Builder.minMappers(Integer)"})
  void testBuilderMinMappers_whenNull() {
    // Arrange
    Builder builder = new Builder();

    // Act
    Builder actualMinMappersResult = builder.minMappers(null);

    // Assert
    assertSame(builder, actualMinMappersResult);
  }

  /**
   * Test Builder {@link MapReduce.Builder#minMappers(Integer)}.
   *
   * <ul>
   *   <li>When one.
   * </ul>
   *
   * <p>Method under test: {@link MapReduce.Builder#minMappers(Integer)}
   */
  @Test
  @DisplayName("Test Builder minMappers(Integer); when one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MapReduce.Builder MapReduce.Builder.minMappers(Integer)"})
  void testBuilderMinMappers_whenOne() {
    // Arrange
    Builder builder = new Builder();

    // Act
    Builder actualMinMappersResult = builder.minMappers(1);

    // Assert
    assertSame(builder, actualMinMappersResult);
  }

  /**
   * Test Builder {@link MapReduce.Builder#minReducers(Integer)}.
   *
   * <p>Method under test: {@link MapReduce.Builder#minReducers(Integer)}
   */
  @Test
  @DisplayName("Test Builder minReducers(Integer)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MapReduce.Builder MapReduce.Builder.minReducers(Integer)"})
  void testBuilderMinReducers() {
    // Arrange
    Builder builder = new Builder();

    // Act
    Builder actualMinReducersResult = builder.minReducers(1);

    // Assert
    assertSame(builder, actualMinReducersResult);
  }

  /**
   * Test Builder {@link MapReduce.Builder#outputPath(String)}.
   *
   * <p>Method under test: {@link MapReduce.Builder#outputPath(String)}
   */
  @Test
  @DisplayName("Test Builder outputPath(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MapReduce.Builder MapReduce.Builder.outputPath(String)"})
  void testBuilderOutputPath() {
    // Arrange
    Builder builder = new Builder();

    // Act
    Builder actualOutputPathResult = builder.outputPath("Output Path");

    // Assert
    assertSame(builder, actualOutputPathResult);
  }

  /**
   * Test Builder {@link MapReduce.Builder#partitioner(Class)}.
   *
   * <p>Method under test: {@link MapReduce.Builder#partitioner(Class)}
   */
  @Test
  @DisplayName("Test Builder partitioner(Class)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MapReduce.Builder MapReduce.Builder.partitioner(Class)"})
  void testBuilderPartitioner() {
    // Arrange
    Builder builder = new Builder();
    Class<Partitioner> partitioner = Partitioner.class;

    // Act
    Builder actualPartitionerResult = builder.partitioner(partitioner);

    // Assert
    assertSame(builder, actualPartitionerResult);
  }

  /**
   * Test Builder {@link MapReduce.Builder#splitsFilePath(String)}.
   *
   * <p>Method under test: {@link MapReduce.Builder#splitsFilePath(String)}
   */
  @Test
  @DisplayName("Test Builder splitsFilePath(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MapReduce.Builder MapReduce.Builder.splitsFilePath(String)"})
  void testBuilderSplitsFilePath() {
    // Arrange
    Builder builder = new Builder();

    // Act
    Builder actualSplitsFilePathResult = builder.splitsFilePath("Splits File");

    // Assert
    assertSame(builder, actualSplitsFilePathResult);
  }

  /**
   * Test Builder {@link MapReduce.Builder#useProvidedSplits(boolean)}.
   *
   * <p>Method under test: {@link MapReduce.Builder#useProvidedSplits(boolean)}
   */
  @Test
  @DisplayName("Test Builder useProvidedSplits(boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MapReduce.Builder MapReduce.Builder.useProvidedSplits(boolean)"})
  void testBuilderUseProvidedSplits() {
    // Arrange
    Builder builder = new Builder();

    // Act
    Builder actualUseProvidedSplitsResult = builder.useProvidedSplits(true);

    // Assert
    assertSame(builder, actualUseProvidedSplitsResult);
  }
}
