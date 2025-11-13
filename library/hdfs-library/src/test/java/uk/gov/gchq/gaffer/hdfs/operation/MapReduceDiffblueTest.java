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

package uk.gov.gchq.gaffer.hdfs.operation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
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
   * <ul>
   *   <li>Then {@link AddElementsFromHdfs} (default constructor) InputMapperPairs Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link MapReduce#addInputMapperPairs(Map)}
   */
  @Test
  @DisplayName("Test addInputMapperPairs(Map); then AddElementsFromHdfs (default constructor) InputMapperPairs Empty")
  @Tag("MaintainedByDiffblue")
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
   * <ul>
   *   <li>Then {@link AddElementsFromHdfs} (default constructor) InputMapperPairs is {@link HashMap#HashMap()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MapReduce#addInputMapperPairs(Map)}
   */
  @Test
  @DisplayName("Test addInputMapperPairs(Map); then AddElementsFromHdfs (default constructor) InputMapperPairs is HashMap()")
  @Tag("MaintainedByDiffblue")
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
   * <ul>
   *   <li>Given {@link AddElementsFromHdfs} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link MapReduce#addInputMapperPair(String, String)}
   */
  @Test
  @DisplayName("Test addInputMapperPair(String, String); given AddElementsFromHdfs (default constructor)")
  @Tag("MaintainedByDiffblue")
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
   * <ul>
   *   <li>Then {@link AddElementsFromHdfs} (default constructor) InputMapperPairs is {@link HashMap#HashMap()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MapReduce#addInputMapperPair(String, String)}
   */
  @Test
  @DisplayName("Test addInputMapperPair(String, String); then AddElementsFromHdfs (default constructor) InputMapperPairs is HashMap()")
  @Tag("MaintainedByDiffblue")
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
   * Test Builder {@link MapReduce.Builder#addInputMapperPair(String, Class)} with {@code inputPath}, {@code mapperGeneratorClass}.
   * <p>
   * Method under test: {@link MapReduce.Builder#addInputMapperPair(String, Class)}
   */
  @Test
  @DisplayName("Test Builder addInputMapperPair(String, Class) with 'inputPath', 'mapperGeneratorClass'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MapReduce.Builder MapReduce.Builder.addInputMapperPair(String, Class)"})
  void testBuilderAddInputMapperPairWithInputPathMapperGeneratorClass() {
    // Arrange
    Builder builder = new Builder();
    builder.addInputMapperPairs(new HashMap<>());
    Class<Object> mapperGeneratorClass = Object.class;

    // Act and Assert
    assertSame(builder, builder.addInputMapperPair("Input Path", mapperGeneratorClass));
  }

  /**
   * Test Builder {@link MapReduce.Builder#addInputMapperPair(String, String)} with {@code inputPath}, {@code mapperGeneratorClassName}.
   * <p>
   * Method under test: {@link MapReduce.Builder#addInputMapperPair(String, String)}
   */
  @Test
  @DisplayName("Test Builder addInputMapperPair(String, String) with 'inputPath', 'mapperGeneratorClassName'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MapReduce.Builder MapReduce.Builder.addInputMapperPair(String, String)"})
  void testBuilderAddInputMapperPairWithInputPathMapperGeneratorClassName() {
    // Arrange
    Builder builder = new Builder();
    builder.addInputMapperPairs(new HashMap<>());

    // Act and Assert
    assertSame(builder, builder.addInputMapperPair("Input Path", "Mapper Generator Class Name"));
  }

  /**
   * Test Builder {@link MapReduce.Builder#addInputMapperPair(String, String)} with {@code inputPath}, {@code mapperGeneratorClassName}.
   * <ul>
   *   <li>Given {@link Builder} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link MapReduce.Builder#addInputMapperPair(String, String)}
   */
  @Test
  @DisplayName("Test Builder addInputMapperPair(String, String) with 'inputPath', 'mapperGeneratorClassName'; given Builder (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MapReduce.Builder MapReduce.Builder.addInputMapperPair(String, String)"})
  void testBuilderAddInputMapperPairWithInputPathMapperGeneratorClassName_givenBuilder() {
    // Arrange
    Builder builder = new Builder();

    // Act and Assert
    assertSame(builder, builder.addInputMapperPair("Input Path", "Mapper Generator Class Name"));
  }

  /**
   * Test Builder {@link MapReduce.Builder#addInputMapperPair(String, Class)} with {@code inputPath}, {@code mapperGeneratorClass}.
   * <ul>
   *   <li>Then return {@link Builder} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link MapReduce.Builder#addInputMapperPair(String, Class)}
   */
  @Test
  @DisplayName("Test Builder addInputMapperPair(String, Class) with 'inputPath', 'mapperGeneratorClass'; then return Builder (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MapReduce.Builder MapReduce.Builder.addInputMapperPair(String, Class)"})
  void testBuilderAddInputMapperPairWithInputPathMapperGeneratorClass_thenReturnBuilder() {
    // Arrange
    Builder builder = new Builder();
    Class<Object> mapperGeneratorClass = Object.class;

    // Act and Assert
    assertSame(builder, builder.addInputMapperPair("Input Path", mapperGeneratorClass));
  }

  /**
   * Test Builder {@link MapReduce.Builder#addInputMapperPairs(Map)}.
   * <ul>
   *   <li>Given {@link Builder} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link MapReduce.Builder#addInputMapperPairs(Map)}
   */
  @Test
  @DisplayName("Test Builder addInputMapperPairs(Map); given Builder (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MapReduce.Builder MapReduce.Builder.addInputMapperPairs(Map)"})
  void testBuilderAddInputMapperPairs_givenBuilder() {
    // Arrange
    Builder builder = new Builder();

    // Act and Assert
    assertSame(builder, builder.addInputMapperPairs(new HashMap<>()));
  }

  /**
   * Test Builder {@link MapReduce.Builder#addInputMapperPairs(Map)}.
   * <ul>
   *   <li>Given {@link Builder} (default constructor) addInputMapperPairs {@link HashMap#HashMap()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MapReduce.Builder#addInputMapperPairs(Map)}
   */
  @Test
  @DisplayName("Test Builder addInputMapperPairs(Map); given Builder (default constructor) addInputMapperPairs HashMap()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MapReduce.Builder MapReduce.Builder.addInputMapperPairs(Map)"})
  void testBuilderAddInputMapperPairs_givenBuilderAddInputMapperPairsHashMap() {
    // Arrange
    Builder builder = new Builder();
    builder.addInputMapperPairs(new HashMap<>());

    // Act and Assert
    assertSame(builder, builder.addInputMapperPairs(new HashMap<>()));
  }

  /**
   * Test Builder {@link MapReduce.Builder#commandLineArgs(String[])}.
   * <p>
   * Method under test: {@link MapReduce.Builder#commandLineArgs(String[])}
   */
  @Test
  @DisplayName("Test Builder commandLineArgs(String[])")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MapReduce.Builder MapReduce.Builder.commandLineArgs(String[])"})
  void testBuilderCommandLineArgs() {
    // Arrange
    Builder builder = new Builder();

    // Act and Assert
    assertSame(builder, builder.commandLineArgs("Command Line Args"));
  }

  /**
   * Test Builder {@link MapReduce.Builder#jobInitialiser(JobInitialiser)}.
   * <p>
   * Method under test: {@link MapReduce.Builder#jobInitialiser(JobInitialiser)}
   */
  @Test
  @DisplayName("Test Builder jobInitialiser(JobInitialiser)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MapReduce.Builder MapReduce.Builder.jobInitialiser(JobInitialiser)"})
  void testBuilderJobInitialiser() {
    // Arrange
    Builder builder = new Builder();

    // Act and Assert
    assertSame(builder, builder.jobInitialiser(mock(JobInitialiser.class)));
  }

  /**
   * Test Builder {@link MapReduce.Builder#mappers(Integer)}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MapReduce.Builder#mappers(Integer)}
   */
  @Test
  @DisplayName("Test Builder mappers(Integer); when 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MapReduce.Builder MapReduce.Builder.mappers(Integer)"})
  void testBuilderMappers_whenNull() {
    // Arrange
    Builder builder = new Builder();

    // Act and Assert
    assertSame(builder, builder.mappers(null));
  }

  /**
   * Test Builder {@link MapReduce.Builder#mappers(Integer)}.
   * <ul>
   *   <li>When ten.</li>
   * </ul>
   * <p>
   * Method under test: {@link MapReduce.Builder#mappers(Integer)}
   */
  @Test
  @DisplayName("Test Builder mappers(Integer); when ten")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MapReduce.Builder MapReduce.Builder.mappers(Integer)"})
  void testBuilderMappers_whenTen() {
    // Arrange
    Builder builder = new Builder();

    // Act and Assert
    assertSame(builder, builder.mappers(10));
  }

  /**
   * Test Builder {@link MapReduce.Builder#maxMappers(Integer)}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MapReduce.Builder#maxMappers(Integer)}
   */
  @Test
  @DisplayName("Test Builder maxMappers(Integer); when 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MapReduce.Builder MapReduce.Builder.maxMappers(Integer)"})
  void testBuilderMaxMappers_whenNull() {
    // Arrange
    Builder builder = new Builder();

    // Act and Assert
    assertSame(builder, builder.maxMappers(null));
  }

  /**
   * Test Builder {@link MapReduce.Builder#maxMappers(Integer)}.
   * <ul>
   *   <li>When three.</li>
   * </ul>
   * <p>
   * Method under test: {@link MapReduce.Builder#maxMappers(Integer)}
   */
  @Test
  @DisplayName("Test Builder maxMappers(Integer); when three")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MapReduce.Builder MapReduce.Builder.maxMappers(Integer)"})
  void testBuilderMaxMappers_whenThree() {
    // Arrange
    Builder builder = new Builder();

    // Act and Assert
    assertSame(builder, builder.maxMappers(3));
  }

  /**
   * Test Builder {@link MapReduce.Builder#maxReducers(Integer)}.
   * <p>
   * Method under test: {@link MapReduce.Builder#maxReducers(Integer)}
   */
  @Test
  @DisplayName("Test Builder maxReducers(Integer)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MapReduce.Builder MapReduce.Builder.maxReducers(Integer)"})
  void testBuilderMaxReducers() {
    // Arrange
    Builder builder = new Builder();

    // Act and Assert
    assertSame(builder, builder.maxReducers(3));
  }

  /**
   * Test Builder {@link MapReduce.Builder#minMappers(Integer)}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MapReduce.Builder#minMappers(Integer)}
   */
  @Test
  @DisplayName("Test Builder minMappers(Integer); when 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MapReduce.Builder MapReduce.Builder.minMappers(Integer)"})
  void testBuilderMinMappers_whenNull() {
    // Arrange
    Builder builder = new Builder();

    // Act and Assert
    assertSame(builder, builder.minMappers(null));
  }

  /**
   * Test Builder {@link MapReduce.Builder#minMappers(Integer)}.
   * <ul>
   *   <li>When one.</li>
   * </ul>
   * <p>
   * Method under test: {@link MapReduce.Builder#minMappers(Integer)}
   */
  @Test
  @DisplayName("Test Builder minMappers(Integer); when one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MapReduce.Builder MapReduce.Builder.minMappers(Integer)"})
  void testBuilderMinMappers_whenOne() {
    // Arrange
    Builder builder = new Builder();

    // Act and Assert
    assertSame(builder, builder.minMappers(1));
  }

  /**
   * Test Builder {@link MapReduce.Builder#minReducers(Integer)}.
   * <p>
   * Method under test: {@link MapReduce.Builder#minReducers(Integer)}
   */
  @Test
  @DisplayName("Test Builder minReducers(Integer)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MapReduce.Builder MapReduce.Builder.minReducers(Integer)"})
  void testBuilderMinReducers() {
    // Arrange
    Builder builder = new Builder();

    // Act and Assert
    assertSame(builder, builder.minReducers(1));
  }

  /**
   * Test Builder {@link MapReduce.Builder#outputPath(String)}.
   * <p>
   * Method under test: {@link MapReduce.Builder#outputPath(String)}
   */
  @Test
  @DisplayName("Test Builder outputPath(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MapReduce.Builder MapReduce.Builder.outputPath(String)"})
  void testBuilderOutputPath() {
    // Arrange
    Builder builder = new Builder();

    // Act and Assert
    assertSame(builder, builder.outputPath("Output Path"));
  }

  /**
   * Test Builder {@link MapReduce.Builder#partitioner(Class)}.
   * <p>
   * Method under test: {@link MapReduce.Builder#partitioner(Class)}
   */
  @Test
  @DisplayName("Test Builder partitioner(Class)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MapReduce.Builder MapReduce.Builder.partitioner(Class)"})
  void testBuilderPartitioner() {
    // Arrange
    Builder builder = new Builder();
    Class<Partitioner> partitioner = Partitioner.class;

    // Act and Assert
    assertSame(builder, builder.partitioner(partitioner));
  }

  /**
   * Test Builder {@link MapReduce.Builder#splitsFilePath(String)}.
   * <p>
   * Method under test: {@link MapReduce.Builder#splitsFilePath(String)}
   */
  @Test
  @DisplayName("Test Builder splitsFilePath(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MapReduce.Builder MapReduce.Builder.splitsFilePath(String)"})
  void testBuilderSplitsFilePath() {
    // Arrange
    Builder builder = new Builder();

    // Act and Assert
    assertSame(builder, builder.splitsFilePath("Splits File"));
  }

  /**
   * Test Builder {@link MapReduce.Builder#useProvidedSplits(boolean)}.
   * <p>
   * Method under test: {@link MapReduce.Builder#useProvidedSplits(boolean)}
   */
  @Test
  @DisplayName("Test Builder useProvidedSplits(boolean)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MapReduce.Builder MapReduce.Builder.useProvidedSplits(boolean)"})
  void testBuilderUseProvidedSplits() {
    // Arrange
    Builder builder = new Builder();

    // Act and Assert
    assertSame(builder, builder.useProvidedSplits(true));
  }
}
