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

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import org.apache.hadoop.io.compress.CompressionCodec;
import org.apache.hadoop.io.compress.GzipCodec;
import org.apache.hadoop.mapreduce.Partitioner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.hdfs.operation.SampleDataForSplitPoints.Builder;
import uk.gov.gchq.gaffer.hdfs.operation.handler.job.initialiser.JobInitialiser;
import uk.gov.gchq.koryphe.ValidationResult;

class SampleDataForSplitPointsDiffblueTest {
  /**
   * Test Builder {@link Builder#compressionCodec(Class)}.
   * <p>
   * Method under test: {@link Builder#compressionCodec(Class)}
   */
  @Test
  @DisplayName("Test Builder compressionCodec(Class)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.compressionCodec(Class)"})
  void testBuilderCompressionCodec() {
    // Arrange
    Builder builder = new Builder();
    Class<CompressionCodec> compressionCodec = CompressionCodec.class;

    // Act and Assert
    assertSame(builder, builder.compressionCodec(compressionCodec));
  }

  /**
   * Test Builder {@link Builder#inputMapperPairs(Map)}.
   * <p>
   * Method under test: {@link Builder#inputMapperPairs(Map)}
   */
  @Test
  @DisplayName("Test Builder inputMapperPairs(Map)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.inputMapperPairs(Map)"})
  void testBuilderInputMapperPairs() {
    // Arrange
    Builder builder = new Builder();

    // Act and Assert
    assertSame(builder, builder.inputMapperPairs(new HashMap<>()));
  }

  /**
   * Test Builder new {@link Builder} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of {@link Builder}
   */
  @Test
  @DisplayName("Test Builder new Builder (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Builder.<init>()"})
  void testBuilderNewBuilder() {
    // Arrange and Act
    Builder actualBuilder = new Builder();

    // Assert
    SampleDataForSplitPoints _getOpResult = actualBuilder._getOp();
    assertNull(_getOpResult.getCommandLineArgs());
    assertNull(_getOpResult.getPartitioner());
    assertNull(_getOpResult.getMaxMapTasks());
    assertNull(_getOpResult.getMinMapTasks());
    assertNull(_getOpResult.getNumMapTasks());
    assertNull(_getOpResult.getNumSplits());
    assertNull(_getOpResult.getOutputPath());
    assertNull(_getOpResult.getSplitsFilePath());
    assertNull(_getOpResult.getInputMapperPairs());
    assertNull(_getOpResult.getOptions());
    assertNull(_getOpResult.getJobInitialiser());
    assertEquals(0.01f, _getOpResult.getProportionToSample());
    assertEquals(1, _getOpResult.getMaxReduceTasks().intValue());
    assertEquals(1, _getOpResult.getMinReduceTasks().intValue());
    assertFalse(_getOpResult.isUseProvidedSplits());
    assertTrue(_getOpResult.isValidate());
    Class<GzipCodec> expectedCompressionCodec = GzipCodec.class;
    assertEquals(expectedCompressionCodec, _getOpResult.getCompressionCodec());
    assertSame(_getOpResult, actualBuilder.build());
  }

  /**
   * Test Builder {@link Builder#numSplits(Integer)}.
   * <p>
   * Method under test: {@link Builder#numSplits(Integer)}
   */
  @Test
  @DisplayName("Test Builder numSplits(Integer)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.numSplits(Integer)"})
  void testBuilderNumSplits() {
    // Arrange
    Builder builder = new Builder();

    // Act and Assert
    assertSame(builder, builder.numSplits(10));
  }

  /**
   * Test Builder {@link Builder#proportionToSample(float)}.
   * <p>
   * Method under test: {@link Builder#proportionToSample(float)}
   */
  @Test
  @DisplayName("Test Builder proportionToSample(float)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.proportionToSample(float)"})
  void testBuilderProportionToSample() {
    // Arrange
    Builder builder = new Builder();

    // Act and Assert
    assertSame(builder, builder.proportionToSample(10.0f));
  }

  /**
   * Test Builder {@link Builder#validate(boolean)}.
   * <p>
   * Method under test: {@link Builder#validate(boolean)}
   */
  @Test
  @DisplayName("Test Builder validate(boolean)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.validate(boolean)"})
  void testBuilderValidate() {
    // Arrange
    Builder builder = new Builder();

    // Act and Assert
    assertSame(builder, builder.validate(true));
  }

  /**
   * Test {@link SampleDataForSplitPoints#validate()}.
   * <p>
   * Method under test: {@link SampleDataForSplitPoints#validate()}
   */
  @Test
  @DisplayName("Test validate()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ValidationResult SampleDataForSplitPoints.validate()"})
  void testValidate() {
    // Arrange and Act
    ValidationResult actualValidateResult = (new SampleDataForSplitPoints()).validate();

    // Assert
    assertEquals("Validation errors: \n" + "splitsFilePath is required for: SampleDataForSplitPoints\n"
        + "jobInitialiser is required for: SampleDataForSplitPoints\n"
        + "inputMapperPairs is required for: SampleDataForSplitPoints\n"
        + "outputPath is required for: SampleDataForSplitPoints", actualValidateResult.getErrorString());
    Set<String> errors = actualValidateResult.getErrors();
    assertEquals(4, errors.size());
    assertTrue(errors.contains("inputMapperPairs is required for: SampleDataForSplitPoints"));
    assertTrue(errors.contains("outputPath is required for: SampleDataForSplitPoints"));
  }

  /**
   * Test {@link SampleDataForSplitPoints#validate()}.
   * <ul>
   *   <li>Then return Errors contains {@code proportionToSample must be greater than 0}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SampleDataForSplitPoints#validate()}
   */
  @Test
  @DisplayName("Test validate(); then return Errors contains 'proportionToSample must be greater than 0'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ValidationResult SampleDataForSplitPoints.validate()"})
  void testValidate_thenReturnErrorsContainsProportionToSampleMustBeGreaterThan0() {
    // Arrange
    SampleDataForSplitPoints sampleDataForSplitPoints = new SampleDataForSplitPoints();
    sampleDataForSplitPoints.setProportionToSample(0.0f);
    sampleDataForSplitPoints.addInputMapperPairs(new HashMap<>());

    // Act
    ValidationResult actualValidateResult = sampleDataForSplitPoints.validate();

    // Assert
    assertEquals(
        "Validation errors: \n" + "splitsFilePath is required for: SampleDataForSplitPoints\n"
            + "jobInitialiser is required for: SampleDataForSplitPoints\n"
            + "outputPath is required for: SampleDataForSplitPoints\n" + "proportionToSample must be greater than 0",
        actualValidateResult.getErrorString());
    Set<String> errors = actualValidateResult.getErrors();
    assertEquals(4, errors.size());
    assertTrue(errors.contains("outputPath is required for: SampleDataForSplitPoints"));
    assertTrue(errors.contains("proportionToSample must be greater than 0"));
  }

  /**
   * Test {@link SampleDataForSplitPoints#validate()}.
   * <ul>
   *   <li>Then return Errors size is three.</li>
   * </ul>
   * <p>
   * Method under test: {@link SampleDataForSplitPoints#validate()}
   */
  @Test
  @DisplayName("Test validate(); then return Errors size is three")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ValidationResult SampleDataForSplitPoints.validate()"})
  void testValidate_thenReturnErrorsSizeIsThree() {
    // Arrange
    SampleDataForSplitPoints sampleDataForSplitPoints = new SampleDataForSplitPoints();
    sampleDataForSplitPoints.addInputMapperPairs(new HashMap<>());

    // Act
    ValidationResult actualValidateResult = sampleDataForSplitPoints.validate();

    // Assert
    assertEquals("Validation errors: \n" + "splitsFilePath is required for: SampleDataForSplitPoints\n"
        + "jobInitialiser is required for: SampleDataForSplitPoints\n"
        + "outputPath is required for: SampleDataForSplitPoints", actualValidateResult.getErrorString());
    Set<String> errors = actualValidateResult.getErrors();
    assertEquals(3, errors.size());
    assertFalse(actualValidateResult.isValid());
    assertTrue(errors.contains("jobInitialiser is required for: SampleDataForSplitPoints"));
    assertTrue(errors.contains("splitsFilePath is required for: SampleDataForSplitPoints"));
  }

  /**
   * Test {@link SampleDataForSplitPoints#getMinReduceTasks()}.
   * <p>
   * Method under test: {@link SampleDataForSplitPoints#getMinReduceTasks()}
   */
  @Test
  @DisplayName("Test getMinReduceTasks()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Integer SampleDataForSplitPoints.getMinReduceTasks()"})
  void testGetMinReduceTasks() {
    // Arrange, Act and Assert
    assertEquals(1, (new SampleDataForSplitPoints()).getMinReduceTasks().intValue());
  }

  /**
   * Test {@link SampleDataForSplitPoints#setMinReduceTasks(Integer)}.
   * <ul>
   *   <li>When zero.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SampleDataForSplitPoints#setMinReduceTasks(Integer)}
   */
  @Test
  @DisplayName("Test setMinReduceTasks(Integer); when zero; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void SampleDataForSplitPoints.setMinReduceTasks(Integer)"})
  void testSetMinReduceTasks_whenZero_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> (new SampleDataForSplitPoints()).setMinReduceTasks(0));
  }

  /**
   * Test {@link SampleDataForSplitPoints#getMaxReduceTasks()}.
   * <p>
   * Method under test: {@link SampleDataForSplitPoints#getMaxReduceTasks()}
   */
  @Test
  @DisplayName("Test getMaxReduceTasks()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Integer SampleDataForSplitPoints.getMaxReduceTasks()"})
  void testGetMaxReduceTasks() {
    // Arrange, Act and Assert
    assertEquals(1, (new SampleDataForSplitPoints()).getMaxReduceTasks().intValue());
  }

  /**
   * Test {@link SampleDataForSplitPoints#setMaxReduceTasks(Integer)}.
   * <ul>
   *   <li>When three.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SampleDataForSplitPoints#setMaxReduceTasks(Integer)}
   */
  @Test
  @DisplayName("Test setMaxReduceTasks(Integer); when three; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void SampleDataForSplitPoints.setMaxReduceTasks(Integer)"})
  void testSetMaxReduceTasks_whenThree_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> (new SampleDataForSplitPoints()).setMaxReduceTasks(3));
  }

  /**
   * Test {@link SampleDataForSplitPoints#setPartitioner(Class)}.
   * <p>
   * Method under test: {@link SampleDataForSplitPoints#setPartitioner(Class)}
   */
  @Test
  @DisplayName("Test setPartitioner(Class)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void SampleDataForSplitPoints.setPartitioner(Class)"})
  void testSetPartitioner() {
    // Arrange
    SampleDataForSplitPoints sampleDataForSplitPoints = new SampleDataForSplitPoints();
    Class<Partitioner> partitioner = Partitioner.class;

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> sampleDataForSplitPoints.setPartitioner(partitioner));
  }

  /**
   * Test {@link SampleDataForSplitPoints#shallowClone()}.
   * <ul>
   *   <li>Given {@link SampleDataForSplitPoints} (default constructor).</li>
   *   <li>Then return MaxMapTasks is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SampleDataForSplitPoints#shallowClone()}
   */
  @Test
  @DisplayName("Test shallowClone(); given SampleDataForSplitPoints (default constructor); then return MaxMapTasks is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"SampleDataForSplitPoints SampleDataForSplitPoints.shallowClone()"})
  void testShallowClone_givenSampleDataForSplitPoints_thenReturnMaxMapTasksIsNull() {
    // Arrange and Act
    SampleDataForSplitPoints actualShallowCloneResult = (new SampleDataForSplitPoints()).shallowClone();

    // Assert
    assertNull(actualShallowCloneResult.getMaxMapTasks());
    assertNull(actualShallowCloneResult.getMinMapTasks());
    assertNull(actualShallowCloneResult.getNumMapTasks());
    assertNull(actualShallowCloneResult.getOptions());
  }

  /**
   * Test {@link SampleDataForSplitPoints#shallowClone()}.
   * <ul>
   *   <li>Then return MaxMapTasks intValue is three.</li>
   * </ul>
   * <p>
   * Method under test: {@link SampleDataForSplitPoints#shallowClone()}
   */
  @Test
  @DisplayName("Test shallowClone(); then return MaxMapTasks intValue is three")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"SampleDataForSplitPoints SampleDataForSplitPoints.shallowClone()"})
  void testShallowClone_thenReturnMaxMapTasksIntValueIsThree() {
    // Arrange
    SampleDataForSplitPoints sampleDataForSplitPoints = new SampleDataForSplitPoints();
    sampleDataForSplitPoints.setMaxMapTasks(3);

    // Act
    SampleDataForSplitPoints actualShallowCloneResult = sampleDataForSplitPoints.shallowClone();

    // Assert
    assertNull(actualShallowCloneResult.getMinMapTasks());
    assertNull(actualShallowCloneResult.getNumMapTasks());
    assertNull(actualShallowCloneResult.getOptions());
    assertEquals(3, actualShallowCloneResult.getMaxMapTasks().intValue());
  }

  /**
   * Test {@link SampleDataForSplitPoints#shallowClone()}.
   * <ul>
   *   <li>Then return MinMapTasks intValue is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link SampleDataForSplitPoints#shallowClone()}
   */
  @Test
  @DisplayName("Test shallowClone(); then return MinMapTasks intValue is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"SampleDataForSplitPoints SampleDataForSplitPoints.shallowClone()"})
  void testShallowClone_thenReturnMinMapTasksIntValueIsOne() {
    // Arrange
    SampleDataForSplitPoints sampleDataForSplitPoints = new SampleDataForSplitPoints();
    sampleDataForSplitPoints.setMinMapTasks(1);

    // Act
    SampleDataForSplitPoints actualShallowCloneResult = sampleDataForSplitPoints.shallowClone();

    // Assert
    assertNull(actualShallowCloneResult.getMaxMapTasks());
    assertNull(actualShallowCloneResult.getNumMapTasks());
    assertNull(actualShallowCloneResult.getOptions());
    assertEquals(1, actualShallowCloneResult.getMinMapTasks().intValue());
  }

  /**
   * Test {@link SampleDataForSplitPoints#shallowClone()}.
   * <ul>
   *   <li>Then return NumMapTasks intValue is ten.</li>
   * </ul>
   * <p>
   * Method under test: {@link SampleDataForSplitPoints#shallowClone()}
   */
  @Test
  @DisplayName("Test shallowClone(); then return NumMapTasks intValue is ten")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"SampleDataForSplitPoints SampleDataForSplitPoints.shallowClone()"})
  void testShallowClone_thenReturnNumMapTasksIntValueIsTen() {
    // Arrange
    SampleDataForSplitPoints sampleDataForSplitPoints = new SampleDataForSplitPoints();
    sampleDataForSplitPoints.setNumMapTasks(10);

    // Act
    SampleDataForSplitPoints actualShallowCloneResult = sampleDataForSplitPoints.shallowClone();

    // Assert
    assertNull(actualShallowCloneResult.getMaxMapTasks());
    assertNull(actualShallowCloneResult.getMinMapTasks());
    assertNull(actualShallowCloneResult.getOptions());
    assertEquals(10, actualShallowCloneResult.getNumMapTasks().intValue());
  }

  /**
   * Test {@link SampleDataForSplitPoints#shallowClone()}.
   * <ul>
   *   <li>Then return Options Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link SampleDataForSplitPoints#shallowClone()}
   */
  @Test
  @DisplayName("Test shallowClone(); then return Options Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"SampleDataForSplitPoints SampleDataForSplitPoints.shallowClone()"})
  void testShallowClone_thenReturnOptionsEmpty() {
    // Arrange
    SampleDataForSplitPoints sampleDataForSplitPoints = new SampleDataForSplitPoints();
    sampleDataForSplitPoints.setOptions(new HashMap<>());

    // Act
    SampleDataForSplitPoints actualShallowCloneResult = sampleDataForSplitPoints.shallowClone();

    // Assert
    assertNull(actualShallowCloneResult.getMaxMapTasks());
    assertNull(actualShallowCloneResult.getMinMapTasks());
    assertNull(actualShallowCloneResult.getNumMapTasks());
    assertTrue(actualShallowCloneResult.getOptions().isEmpty());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link SampleDataForSplitPoints}
   *   <li>{@link SampleDataForSplitPoints#setCommandLineArgs(String[])}
   *   <li>{@link SampleDataForSplitPoints#setCompressionCodec(Class)}
   *   <li>{@link SampleDataForSplitPoints#setInputMapperPairs(Map)}
   *   <li>{@link SampleDataForSplitPoints#setJobInitialiser(JobInitialiser)}
   *   <li>{@link SampleDataForSplitPoints#setMaxMapTasks(Integer)}
   *   <li>{@link SampleDataForSplitPoints#setMinMapTasks(Integer)}
   *   <li>{@link SampleDataForSplitPoints#setNumMapTasks(Integer)}
   *   <li>{@link SampleDataForSplitPoints#setNumSplits(Integer)}
   *   <li>{@link SampleDataForSplitPoints#setOptions(Map)}
   *   <li>{@link SampleDataForSplitPoints#setOutputPath(String)}
   *   <li>{@link SampleDataForSplitPoints#setProportionToSample(float)}
   *   <li>{@link SampleDataForSplitPoints#setSplitsFilePath(String)}
   *   <li>{@link SampleDataForSplitPoints#setUseProvidedSplits(boolean)}
   *   <li>{@link SampleDataForSplitPoints#setValidate(boolean)}
   *   <li>{@link SampleDataForSplitPoints#getCommandLineArgs()}
   *   <li>{@link SampleDataForSplitPoints#getCompressionCodec()}
   *   <li>{@link SampleDataForSplitPoints#getInputMapperPairs()}
   *   <li>{@link SampleDataForSplitPoints#getJobInitialiser()}
   *   <li>{@link SampleDataForSplitPoints#getMaxMapTasks()}
   *   <li>{@link SampleDataForSplitPoints#getMinMapTasks()}
   *   <li>{@link SampleDataForSplitPoints#getNumMapTasks()}
   *   <li>{@link SampleDataForSplitPoints#getNumSplits()}
   *   <li>{@link SampleDataForSplitPoints#getOptions()}
   *   <li>{@link SampleDataForSplitPoints#getOutputPath()}
   *   <li>{@link SampleDataForSplitPoints#getPartitioner()}
   *   <li>{@link SampleDataForSplitPoints#getProportionToSample()}
   *   <li>{@link SampleDataForSplitPoints#getSplitsFilePath()}
   *   <li>{@link SampleDataForSplitPoints#isUseProvidedSplits()}
   *   <li>{@link SampleDataForSplitPoints#isValidate()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void SampleDataForSplitPoints.<init>()", "String[] SampleDataForSplitPoints.getCommandLineArgs()",
      "Class SampleDataForSplitPoints.getCompressionCodec()", "Map SampleDataForSplitPoints.getInputMapperPairs()",
      "JobInitialiser SampleDataForSplitPoints.getJobInitialiser()",
      "Integer SampleDataForSplitPoints.getMaxMapTasks()", "Integer SampleDataForSplitPoints.getMinMapTasks()",
      "Integer SampleDataForSplitPoints.getNumMapTasks()", "Integer SampleDataForSplitPoints.getNumSplits()",
      "Map SampleDataForSplitPoints.getOptions()", "String SampleDataForSplitPoints.getOutputPath()",
      "Class SampleDataForSplitPoints.getPartitioner()", "float SampleDataForSplitPoints.getProportionToSample()",
      "String SampleDataForSplitPoints.getSplitsFilePath()", "boolean SampleDataForSplitPoints.isUseProvidedSplits()",
      "boolean SampleDataForSplitPoints.isValidate()", "void SampleDataForSplitPoints.setCommandLineArgs(String[])",
      "void SampleDataForSplitPoints.setCompressionCodec(Class)",
      "void SampleDataForSplitPoints.setInputMapperPairs(Map)",
      "void SampleDataForSplitPoints.setJobInitialiser(JobInitialiser)",
      "void SampleDataForSplitPoints.setMaxMapTasks(Integer)", "void SampleDataForSplitPoints.setMinMapTasks(Integer)",
      "void SampleDataForSplitPoints.setNumMapTasks(Integer)", "void SampleDataForSplitPoints.setNumSplits(Integer)",
      "void SampleDataForSplitPoints.setOptions(Map)", "void SampleDataForSplitPoints.setOutputPath(String)",
      "void SampleDataForSplitPoints.setProportionToSample(float)",
      "void SampleDataForSplitPoints.setSplitsFilePath(String)",
      "void SampleDataForSplitPoints.setUseProvidedSplits(boolean)",
      "void SampleDataForSplitPoints.setValidate(boolean)"})
  void testGettersAndSetters() {
    // Arrange and Act
    SampleDataForSplitPoints actualSampleDataForSplitPoints = new SampleDataForSplitPoints();
    String[] commandLineArgs = new String[]{"Command Line Args"};
    actualSampleDataForSplitPoints.setCommandLineArgs(commandLineArgs);
    Class<CompressionCodec> compressionCodec = CompressionCodec.class;
    actualSampleDataForSplitPoints.setCompressionCodec(compressionCodec);
    HashMap<String, String> inputMapperPairs = new HashMap<>();
    actualSampleDataForSplitPoints.setInputMapperPairs(inputMapperPairs);
    JobInitialiser jobInitialiser = mock(JobInitialiser.class);
    actualSampleDataForSplitPoints.setJobInitialiser(jobInitialiser);
    actualSampleDataForSplitPoints.setMaxMapTasks(3);
    actualSampleDataForSplitPoints.setMinMapTasks(1);
    actualSampleDataForSplitPoints.setNumMapTasks(10);
    actualSampleDataForSplitPoints.setNumSplits(10);
    HashMap<String, String> options = new HashMap<>();
    actualSampleDataForSplitPoints.setOptions(options);
    actualSampleDataForSplitPoints.setOutputPath("Output Path");
    actualSampleDataForSplitPoints.setProportionToSample(10.0f);
    actualSampleDataForSplitPoints.setSplitsFilePath("/directory/foo.txt");
    actualSampleDataForSplitPoints.setUseProvidedSplits(true);
    actualSampleDataForSplitPoints.setValidate(true);
    String[] actualCommandLineArgs = actualSampleDataForSplitPoints.getCommandLineArgs();
    Class<? extends CompressionCodec> actualCompressionCodec = actualSampleDataForSplitPoints.getCompressionCodec();
    Map<String, String> actualInputMapperPairs = actualSampleDataForSplitPoints.getInputMapperPairs();
    JobInitialiser actualJobInitialiser = actualSampleDataForSplitPoints.getJobInitialiser();
    Integer actualMaxMapTasks = actualSampleDataForSplitPoints.getMaxMapTasks();
    Integer actualMinMapTasks = actualSampleDataForSplitPoints.getMinMapTasks();
    Integer actualNumMapTasks = actualSampleDataForSplitPoints.getNumMapTasks();
    Integer actualNumSplits = actualSampleDataForSplitPoints.getNumSplits();
    Map<String, String> actualOptions = actualSampleDataForSplitPoints.getOptions();
    String actualOutputPath = actualSampleDataForSplitPoints.getOutputPath();
    Class<? extends Partitioner> actualPartitioner = actualSampleDataForSplitPoints.getPartitioner();
    float actualProportionToSample = actualSampleDataForSplitPoints.getProportionToSample();
    String actualSplitsFilePath = actualSampleDataForSplitPoints.getSplitsFilePath();
    boolean actualIsUseProvidedSplitsResult = actualSampleDataForSplitPoints.isUseProvidedSplits();
    boolean actualIsValidateResult = actualSampleDataForSplitPoints.isValidate();

    // Assert
    assertEquals("/directory/foo.txt", actualSplitsFilePath);
    assertEquals("Output Path", actualOutputPath);
    assertNull(actualPartitioner);
    assertEquals(1, actualMinMapTasks.intValue());
    assertEquals(10, actualNumMapTasks.intValue());
    assertEquals(10, actualNumSplits.intValue());
    assertEquals(10.0f, actualProportionToSample);
    assertEquals(3, actualMaxMapTasks.intValue());
    assertTrue(actualInputMapperPairs.isEmpty());
    assertTrue(actualOptions.isEmpty());
    assertTrue(actualIsUseProvidedSplitsResult);
    assertTrue(actualIsValidateResult);
    Class<CompressionCodec> expectedCompressionCodec = CompressionCodec.class;
    assertEquals(expectedCompressionCodec, actualCompressionCodec);
    assertSame(inputMapperPairs, actualInputMapperPairs);
    assertSame(options, actualOptions);
    assertSame(compressionCodec, actualCompressionCodec);
    assertSame(commandLineArgs, actualCommandLineArgs);
    assertSame(jobInitialiser, actualJobInitialiser);
    assertArrayEquals(new String[]{"Command Line Args"}, actualCommandLineArgs);
  }
}
